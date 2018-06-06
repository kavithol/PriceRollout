package com.netflix.price.application;

import com.netflix.price.hibernate.factory.LockUpdateByCountryIdFactory;
import com.netflix.price.hibernate.factory.PriceRevisionFactory;
import com.netflix.price.hibernate.factory.RolloutFactory;
import com.netflix.price.hibernate.factory.UserPlanFactory;
import com.netflix.price.hibernate.models.PriceRevisionEntity;
import com.netflix.price.models.request.CreateRolloutRequest;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class CreateTask implements Runnable{
    int rolloutId;
    int NUM_RETRIES = 3;
    Logger logger = LogManager.getLogger(CreateTask.class);
    CreateRolloutRequest createRolloutRequest;

    CreateTask(int rolloutId, CreateRolloutRequest createRolloutRequest){
        this.rolloutId = rolloutId;
        this.createRolloutRequest = createRolloutRequest;
    }

    public void run() {
        RolloutFactory rolloutFactory = new RolloutFactory();
        LockUpdateByCountryIdFactory lockUpdateByCountryIdFactory = new LockUpdateByCountryIdFactory();
        for (int i=0;i<NUM_RETRIES;i++) {
            if (lockUpdateByCountryIdFactory.getLockUpdateByCountryIdPlanId(rolloutId, createRolloutRequest.getCountryId(), createRolloutRequest.getPlanId()) == null) {
                lockUpdateByCountryIdFactory.lockUpdateByCountryId(rolloutId, createRolloutRequest.getCountryId(), createRolloutRequest.getPlanId());
                List<String> errorList = new ArrayList<String>();
                rolloutFactory.updateRolloutStatus(rolloutId, "PROCESSING", null, errorList);
                UserPlanFactory userPlanFactory = new UserPlanFactory();
                userPlanFactory.updateUserPlan(createRolloutRequest.getCountryId(),
                        createRolloutRequest.getPlanId(), createRolloutRequest.getPrice(), errorList);
                if (errorList.size() >= 1) {
                    rolloutFactory.updateRolloutStatus(rolloutId, "FAILED", errorList.get(0), errorList);
                } else {

                    rolloutFactory.updateRolloutStatus(rolloutId, "DONE", null, errorList);
                    PriceRevisionFactory priceRevisionFactory = new PriceRevisionFactory();
                    PriceRevisionEntity priceRevisionEntity = new PriceRevisionEntity();
                    priceRevisionEntity.setCountryid(createRolloutRequest.getCountryId());
                    priceRevisionEntity.setPlanid(createRolloutRequest.getPlanId());
                    priceRevisionEntity.setNewprice(new BigDecimal(createRolloutRequest.getPrice()));
                    priceRevisionEntity.setOldprice(new BigDecimal( userPlanFactory.getUserPlanByCountry(createRolloutRequest.getCountryId(),createRolloutRequest.getPlanId())));
                    priceRevisionEntity.setRolloutid(rolloutId);
                    priceRevisionFactory.saveRevisionHistory(priceRevisionEntity);
                }
                lockUpdateByCountryIdFactory.deleteLock(rolloutId, createRolloutRequest.getCountryId(), createRolloutRequest.getPlanId());
                break;
            } else {
                logger.debug("Another rollout in process");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    logger.error( e.getMessage());
                }
            }
        }
    }
}
