package hk.ust.cse.com4521.escort_app.apiservices.service;

import java.util.List;

import hk.ust.cse.com4521.escort_app.apiservices.model.UserAccount;
import retrofit.Call;
import retrofit.http.Body;
import retrofit.http.GET;
import retrofit.http.POST;

/**
 * Created by SGHAIER on 25/04/16.
 */
public interface APIService {
    @POST("/api/UserAccounts")
    Call<UserAccount> createUser(@Body UserAccount user);

    @GET("/api/UserAccounts")
    Call<List<UserAccount>> users();
}
