package hk.ust.cse.com4521.escort_app.apiservices.service;

import com.google.common.collect.ImmutableMap;

import java.util.List;

import hk.ust.cse.com4521.escort_app.JobDetailsActivity;
import hk.ust.cse.com4521.escort_app.LoginActivity;
import hk.ust.cse.com4521.escort_app.PendingJobDetailActivity;
import hk.ust.cse.com4521.escort_app.apiservices.model.MeetingHistories;
import hk.ust.cse.com4521.escort_app.apiservices.model.PatientMeetingPosting;
import hk.ust.cse.com4521.escort_app.apiservices.model.UserAccount;
import retrofit.Call;
import retrofit.http.Body;
import retrofit.http.DELETE;
import retrofit.http.GET;
import retrofit.http.POST;
import retrofit.http.PUT;
import retrofit.http.Path;
import retrofit.http.QueryMap;

/**
 * Created by SGHAIER on 25/04/16.
 */
public interface APIService {
    @POST("/api/UserAccounts")
    Call<UserAccount> createUser(@Body UserAccount user);
    @POST("/api/UserAccounts/login")
    Call<LoginActivity.loginResponse> loginUser(@Body LoginActivity.loginResponse userLoginInfo);
    @GET("/api/PatientMeetingPostings/{id}")
    Call<PatientMeetingPosting> findPatientPostingById(@Path("id") String id);
    @GET("/api/UserAccounts/{id}")
    Call<UserAccount> findUserById(@Path("id") String id);
    @PUT("/api/MeetingHistories")
    Call<JobDetailsActivity.MeetingUpdate> updateMeeting(@Body JobDetailsActivity.MeetingUpdate updateInfo);
    @PUT("/api/MeetingHistories")
    Call<PendingJobDetailActivity.AddAdvice> updateAdvice(@Body PendingJobDetailActivity.AddAdvice updateInfo);
    @GET("/api/MeetingHistories?filter[include]=patient&filter[include]=PatientMeetingPosting&filter[include]=staff")
    Call<List<MeetingHistories>> meetings(@QueryMap ImmutableMap param);
    @GET("/api/MeetingHistories/{id}")
    Call<MeetingHistories> getMeeting(@Path("id") String id);
    @GET("/api/MeetingHistories?filter[include]=patient&filter[include]=PatientMeetingPosting&filter[include]=staff")
    Call<List<UserAccount>> findAccountByUserName(@QueryMap ImmutableMap param);
    @GET("/api/UserAccounts")
    Call<List<UserAccount>> getUserAccountsByName(@QueryMap ImmutableMap param);
    @GET("/api/UserAccounts")
    Call<List<UserAccount>> getUserAccountsByYMCAid(@QueryMap ImmutableMap param);
    @DELETE("/api/UserAccounts/{id}")
    Call<UserAccount> deleteAccountByUserId(@Path("id") String id);



   /* @GET("/api/UserAccounts")
    Call<List<UserAccount>> users();



    @GET ("/api/MeetingHistories/{id}/patient")
    Call<UserAccount> patientAccount(@Path("id") String id);


    @GET("/api/MeetingHistories?filter[include]=patientUserId")
    Call<List<MeetingHistory>> meetingsWithPatient();


    @GET("/api/PatientMeetingPostings")
    Call<List<PatientMeetingPosting>> postings();


    @POST("/api/PatientMeetingPostings")
    Call<MeetingHistories> createPatientPosting(@Body MeetingHistories user);




   @GET("/api/PatientMeetingPostings")
    Call<List<PatientMeetingPosting>> jobs();
    @POST("/api/PatientMeetingPostings")
    Call<PatientMeetingPosting> createJob(@Body PatientMeetingPosting job);
    @GET("/api/PatientMeetingPostings/{id}")
    Call<PatientMeetingPosting> getPost(@Path("id") String id);*/

}
