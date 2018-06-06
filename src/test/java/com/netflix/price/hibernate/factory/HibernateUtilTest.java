package com.netflix.price.hibernate.factory;

import com.netflix.price.hibernate.models.UserPlanEntity;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.ArrayList;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class HibernateUtilTest {
    @Test
    public void testSave(){
            UserPlanEntity userPlan = new UserPlanEntity();

            userPlan.setCountryid("US");
            userPlan.setPrice(BigDecimal.valueOf(23.99));
          //  userPlan.setUserId(1);
        UserPlanFactory userPlanFactory= new UserPlanFactory();
            int userId = userPlanFactory.saveUserPlan(userPlan);
            assertNotNull(userPlanFactory .getUserPlan(userId));
        }

        @Test
public  void testUpdate(){
        UserPlanFactory userPlanFactory = new UserPlanFactory();
        userPlanFactory.updateUserPlan("US","1S",25.99,null);
        Double price = userPlanFactory.getUserPlanByCountry("US","1S");
        assertNotNull(price);
        assertEquals(25.99,price.doubleValue(),0.01);
    }
    @Test
public void testUpdatestatus(){
        RolloutFactory rolloutFactory = new RolloutFactory();
        rolloutFactory.updateRolloutStatus(1,"PROCESSING",null,new ArrayList<String>());
    }

@Test
public void createTestData(){

   createUserForCountry("US");
    createUserForCountry("UK");
    createUserForCountry("DE");
    createUserForCountry("IN");
    createUserForCountry("AU");
}
public void createUserForCountry(String countryId){
    UserPlanEntity userPlanEntity = new UserPlanEntity();
    userPlanEntity.setPrice(new BigDecimal( 9.99));
    userPlanEntity.setCountryid(countryId);
    userPlanEntity.setPlanid("1S");
    createuser(userPlanEntity);
    userPlanEntity.setPrice(new BigDecimal( 10.99));
    userPlanEntity.setPlanid("2S");
    createuser(userPlanEntity);
    userPlanEntity.setPrice(new BigDecimal( 11.99));
    userPlanEntity.setPlanid("3S");
    createuser(userPlanEntity);
}
private void createuser(UserPlanEntity userPlanEntity){
    UserPlanFactory userPlanFactory = new UserPlanFactory();
    for (int i=0;i<10000; i++) {
        userPlanFactory.saveUserPlan(userPlanEntity);
    }
}
}


