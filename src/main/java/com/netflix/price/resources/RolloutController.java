package com.netflix.price.resources;

import com.netflix.price.application.RolloutService;
import com.netflix.price.models.request.CreateRolloutRequest;
import com.netflix.price.models.response.CreateRolloutResponse;
import com.netflix.price.models.response.GetRolloutStatus;
import com.netflix.price.models.response.GetUserResponse;
import com.netflix.price.validator.RolloutValidator;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.ArrayList;
import java.util.Arrays;

@Path("/rollout")
@Api(value = "RolloutResource", description = "Sample resource for rollout")
public class RolloutController {

    @POST
    @Path("/")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @ApiOperation(value = "CreateRollout", notes = "Creates rollout from request", response = String.class)
    public CreateRolloutResponse scheduleRollout(CreateRolloutRequest createRolloutRequest) {
        if (RolloutValidator.createRequest(createRolloutRequest)) {
            RolloutService rolloutService = new RolloutService();
            return rolloutService.createRollout(createRolloutRequest);
        }else{
            CreateRolloutResponse createRolloutResponse = new CreateRolloutResponse();
            createRolloutResponse.setError(new ArrayList<String>(Arrays.asList("Input Error")));
            return createRolloutResponse;
        }
    }

@GET
@Path("/{rolloutId}")
@ApiOperation(value = "GetRolloutStatus", notes = "Get rollout status with id", response = String.class)
@Produces(MediaType.APPLICATION_JSON)
public  GetRolloutStatus getRolloutStatus(@PathParam("rolloutId")  int rolloutId) {
    RolloutService rolloutService = new RolloutService();
    return rolloutService.getRolloutStatus(rolloutId);
}

@GET
@Path("/user/{userId}")
@Produces(MediaType.APPLICATION_JSON)
@ApiOperation(value = "GetUserInformation", notes = "Get user information with id", response = String.class)
public GetUserResponse getUserStatus(@PathParam("userId")  int userId) {
    RolloutService rolloutService = new RolloutService();
    return rolloutService.getUserResponse(userId);
}

}
