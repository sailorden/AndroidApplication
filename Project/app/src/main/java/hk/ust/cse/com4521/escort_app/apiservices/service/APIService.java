package hk.ust.cse.com4521.escort_app.apiservices.service;

import com.google.common.collect.ImmutableMap;

import java.util.List;
import java.util.Map;

import hk.ust.cse.com4521.escort_app.apiservices.model.MeetingHistories;
import hk.ust.cse.com4521.escort_app.apiservices.model.PatientMeetingPosting;
import hk.ust.cse.com4521.escort_app.apiservices.model.UserAccount;
import retrofit.Call;
import retrofit.http.Body;
import retrofit.http.GET;
import retrofit.http.POST;
import retrofit.http.Path;
import retrofit.http.Query;
import retrofit.http.QueryMap;

/**
 * Created by SGHAIER on 25/04/16.
 * modified by tommy on 08/05/16.
 */
public interface APIService {
    @POST("/api/UserAccounts/login")
    Call<UserAccount> loginUser(@Body UserAccount userLoginInfo);

    @POST("/api/UserAccounts/{id}")
    Call<UserAccount> findUserByID(@Path("id") int userID);

    @POST("/api/UserAccounts")
    Call<UserAccount> createUser(@Body UserAccount user);

    @GET("/api/UserAccounts")
    Call<List<UserAccount>> users();

    @GET("/api/MeetingHistories")
    //Call<List<MeetingHistories>> meetings();

   Call<List<MeetingHistories>> meetings(@QueryMap ImmutableMap param);




   /* @GET("/api/PatientMeetingPostings")
    Call<List<PatientMeetingPosting>> jobs();
    @POST("/api/PatientMeetingPostings")
    Call<PatientMeetingPosting> createJob(@Body PatientMeetingPosting job);
    @GET("/api/PatientMeetingPostings/{id}")
    Call<PatientMeetingPosting> getPost(@Path("id") String id);*/

}
