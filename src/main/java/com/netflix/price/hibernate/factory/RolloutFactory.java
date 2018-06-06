package com.netflix.price.hibernate.factory;

import com.netflix.price.hibernate.models.RolloutStatusEntity;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.List;

public class RolloutFactory {

final static Logger logger = LogManager.getLogger(RolloutFactory.class);

    public Integer saveRolloutStatus(){

            try{
                Session session = HibernateFactory.getInstance().getSessionFactory().openSession();
                RolloutStatusEntity rolloutStatusEntity = new RolloutStatusEntity();
                rolloutStatusEntity.setStatus("NEW");
                session.getTransaction().begin();
                Integer id = (Integer) session.save(rolloutStatusEntity);
                session.getTransaction().commit();
                return rolloutStatusEntity.getRolloutid();
            }catch (Exception e){
                logger.error(e);
            }
            return null;
        }

    public void updateRolloutStatus(int rolloutId,String status,String error,List<String> errorList){
        try{
            Session session = HibernateFactory.getInstance().getSessionFactory().openSession();
            session.getTransaction().begin();
            Query query;
            if (error == null) {
               query = session.createSQLQuery(
                        "update ROLLOUT_STATUS S set S.STATUS = :status" + " where S.ROLLOUTID = :rolloutId");

            }else {
                query = session.createSQLQuery(
                        "update ROLLOUT_STATUS S set S.STATUS = :status and S.ERROR= :error" + " where S.ROLLOUTID = :rolloutId");
                query.setParameter("error", error);
            }
            query.setParameter("status", status);
            query.setParameter("rolloutId", rolloutId);
            int result = query.executeUpdate();
            session.getTransaction().commit();
        }catch (Exception e){
            logger.error(e);
            errorList.add(e.getMessage());
        }
    }
public RolloutStatusEntity getRolloutStatus(int rolloutId){
    try{
        Session session = HibernateFactory.getInstance().getSessionFactory().openSession();
        return session.get(RolloutStatusEntity.class,rolloutId);
    }catch (Exception e){
        logger.error(e);
    }
    return null;
}
}
