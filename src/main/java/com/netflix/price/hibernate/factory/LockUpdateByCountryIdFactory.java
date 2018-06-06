package com.netflix.price.hibernate.factory;

import com.netflix.price.hibernate.models.LockUpdateByCountryIdEntity;
import com.netflix.price.hibernate.models.LockUpdateByCountryIdEntityPK;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Session;

public class LockUpdateByCountryIdFactory {

final static Logger logger = LogManager.getLogger(LockUpdateByCountryIdFactory.class);

    public void lockUpdateByCountryId(int rolloutId, String countryId, String planId ){

            try{
                Session session = HibernateFactory.getInstance().getSessionFactory().openSession();
                session.beginTransaction();
                LockUpdateByCountryIdEntity lockUpdateByCountryIdEntity = new LockUpdateByCountryIdEntity();
                lockUpdateByCountryIdEntity.setCountryId(countryId);
                lockUpdateByCountryIdEntity.setPlanId(planId);
                lockUpdateByCountryIdEntity.setRolloutId(rolloutId);
                session.save(lockUpdateByCountryIdEntity);
                session.getTransaction().commit();
            }catch (Exception e){
                logger.error(e);
            }
        }

    public  LockUpdateByCountryIdEntity getLockUpdateByCountryIdPlanId(int rolloutId, String countryId,String planId){
        try{
            Session session = HibernateFactory.getInstance().getSessionFactory().openSession();
            LockUpdateByCountryIdEntityPK lockUpdateByCountryIdEntityPK = new LockUpdateByCountryIdEntityPK();
            lockUpdateByCountryIdEntityPK.setCountryId(countryId);
            lockUpdateByCountryIdEntityPK.setPlanId(planId);
            return session.get(LockUpdateByCountryIdEntity.class, lockUpdateByCountryIdEntityPK);
        }catch (Exception e) {
            logger.error(e);
        }
        return null;
    }

public  void deleteLock(int rolloutId, String countryId,String planId){

    try{
        Session session = HibernateFactory.getInstance().getSessionFactory().openSession();
        session.beginTransaction();
        LockUpdateByCountryIdEntity lockUpdateByCountryIdEntity = new LockUpdateByCountryIdEntity();
        lockUpdateByCountryIdEntity.setCountryId(countryId);
        lockUpdateByCountryIdEntity.setPlanId(planId);
        lockUpdateByCountryIdEntity.setRolloutId(rolloutId);

        session.delete(lockUpdateByCountryIdEntity);
        session.getTransaction().commit();

    }catch (Exception e){
        logger.error(e);
    }

}

}
