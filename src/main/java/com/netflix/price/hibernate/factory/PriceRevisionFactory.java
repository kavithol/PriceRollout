package com.netflix.price.hibernate.factory;

import com.netflix.price.hibernate.models.PriceRevisionEntity;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Session;

public class PriceRevisionFactory  {

final static Logger logger = LogManager.getLogger(PriceRevisionFactory.class);

    public void saveRevisionHistory(PriceRevisionEntity priceRevision){

            try{
                Session session = HibernateFactory.getInstance().getSessionFactory().openSession();
                session.save(priceRevision);
                session.getTransaction().commit();

            }catch (Exception e){
                logger.error(e);
            }

        }
}
