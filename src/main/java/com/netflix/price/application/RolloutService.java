package com.netflix.price.application;

import com.netflix.price.hibernate.factory.RolloutFactory;
import com.netflix.price.hibernate.factory.UserPlanFactory;
import com.netflix.price.hibernate.models.RolloutStatusEntity;
import com.netflix.price.hibernate.models.UserPlanEntity;
import com.netflix.price.models.request.CreateRolloutRequest;
import com.netflix.price.models.response.CreateRolloutResponse;
import com.netflix.price.models.response.GetRolloutStatus;
import com.netflix.price.models.response.GetUserResponse;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class RolloutService {
    ExecutorService executorService = Executors.newFixedThreadPool(10);
    public CreateRolloutResponse createRollout(CreateRolloutRequest createRolloutRequest){
        RolloutFactory rolloutFactory = new RolloutFactory();
        int rolloutId= rolloutFactory.saveRolloutStatus();
        Runnable createTask = new CreateTask(rolloutId, createRolloutRequest);
        executorService.submit(createTask);
        CreateRolloutResponse createRolloutResponse = new CreateRolloutResponse();
        createRolloutResponse.setRolloutId(rolloutId);
        return createRolloutResponse;
    }

    public GetRolloutStatus getRolloutStatus(int rolloutId){
        RolloutFactory rolloutFactory = new RolloutFactory();
        RolloutStatusEntity rolloutStatusEntity = rolloutFactory.getRolloutStatus(rolloutId);
        GetRolloutStatus getRolloutStatus = new GetRolloutStatus();
        getRolloutStatus.setError(rolloutStatusEntity.getError());
        getRolloutStatus.setStatus(rolloutStatusEntity.getStatus());
        getRolloutStatus.setRolloutid(rolloutStatusEntity.getRolloutid());
        getRolloutStatus.setRolloutStatuUpdateTime(rolloutStatusEntity.getUpdatedTime());
        return getRolloutStatus;
    }

    public GetUserResponse getUserResponse(int userId){
        UserPlanFactory userPlanFactory = new UserPlanFactory();
        UserPlanEntity userPlanEntity= userPlanFactory.getUserInfo(userId);
        GetUserResponse getUserResponse = new GetUserResponse();
        getUserResponse.setCountryId(userPlanEntity.getCountryid());
        getUserResponse.setPlanId(userPlanEntity.getPlanid());
        getUserResponse.setPrice(userPlanEntity.getPrice().doubleValue());
        getUserResponse.setUserId(userPlanEntity.getUserid());
        return getUserResponse;
    }
}