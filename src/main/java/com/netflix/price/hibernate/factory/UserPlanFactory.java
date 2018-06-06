package com.netflix.price.hibernate.factory;


import com.netflix.price.hibernate.models.UserPlanEntity;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.hibernate.query.Query;

import java.util.List;

public class UserPlanFactory {

final static Logger logger = LogManager.getLogger(UserPlanFactory.class);

public Integer saveUserPlan(UserPlanEntity userPlan) {

    try {
        Session session = HibernateFactory.getInstance().getSessionFactory().openSession();
        session.beginTransaction();
        session.save(userPlan);
        session.getTransaction().commit();
        return userPlan.getUserid();
    } catch (Exception e) {
        logger.error(e);
    }
    return null;
}

public void updateUserPlan(String countryId, String planId, Double price, List<String> errorList) {
    try {
        Session session = HibernateFactory.getInstance().getSessionFactory().openSession();
        session.getTransaction().begin();
        Query query = session.createSQLQuery(
                "update USER_PLAN set PRICE = :price" + " where COUNTRYID = :countryId and PLANID = :planId");
        query.setParameter("price", price);
        query.setParameter("countryId", countryId);
        query.setParameter("planId", planId);
        int result = query.executeUpdate();
        session.getTransaction().commit();

    } catch (Exception e) {
        logger.error(e);
        errorList.add(e.getMessage());
    }
}

public UserPlanEntity getUserPlan(int userId) {

    try {
        Session session = HibernateFactory.getInstance().getSessionFactory().openSession();
        UserPlanEntity userPlan = session.get(UserPlanEntity.class, userId);
        return userPlan;
    } catch (Exception e) {
        logger.error(e);
    }
    return null;

}

public Double getUserPlanByCountry(String countryId, String planId) {
    List<UserPlanEntity> userPlanEntity = (List<UserPlanEntity>) HibernateFactory.getInstance().getSessionFactory().openSession()
            .createCriteria(UserPlanEntity.class)
            .add(Restrictions.eq("countryid", countryId))
            .add(Restrictions.eq("planid", planId))
            .list();
    if (userPlanEntity != null && userPlanEntity.size() > 1) {
        return userPlanEntity.get(0).getPrice().doubleValue();
    }
    return null;
}

public UserPlanEntity getUserInfo(int userId) {
    try {
        Session session = HibernateFactory.getInstance().getSessionFactory().openSession();
        return session.get(UserPlanEntity.class, userId);
    } catch (Exception e) {
        logger.error(e);
    }
    return null;
}


}
