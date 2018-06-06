package com.netflix.price.validator;

import com.netflix.price.enums.CountryIdEnum;
import com.netflix.price.enums.PlanIdEnum;
import com.netflix.price.models.request.CreateRolloutRequest;

public class RolloutValidator {

    public static boolean createRequest(CreateRolloutRequest createRolloutRequest){
        return checkValidCountryId(createRolloutRequest.getCountryId())&&
                checkValidPrice(createRolloutRequest.getPlanId());
    }
    private static boolean checkValidCountryId(String countryId){
        return CountryIdEnum.fromValue(countryId) !=null;
    }
    private static boolean checkValidPrice(String planId){
        return PlanIdEnum.fromValue(planId) !=null;
    }
}
