package hk.ust.cse.com4521.escort_app.apiservices;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.gson.JsonObject;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
//import java.util.Map;

import hk.ust.cse.com4521.escort_app.apiservices.model.MeetingHistories;
import hk.ust.cse.com4521.escort_app.apiservices.model.PatientMeetingPosting;
import hk.ust.cse.com4521.escort_app.apiservices.model.UserAccount;
import hk.ust.cse.com4521.escort_app.apiservices.service.APIService;
import retrofit.Call;
import retrofit.Callback;
import retrofit.GsonConverterFactory;
import retrofit.Response;
import retrofit.Retrofit;

/**
 * Created by SGHAIER on 25/04/16.
 */
public class RestClient {
    private static RestClient instance = null;
    boolean success = false;
    private ResultReadyCallback callback;



    private static final String BASE_URL = "http://119.247.178.194:3000";
    private APIService service;


    private List<PatientMeetingPosting> jobs=null;
    private List<MeetingHistories> meetings=null;
    private PatientMeetingPosting post=null;

    public RestClient() {
        Retrofit retrofit = new Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(BASE_URL)
                .build();

        service = retrofit.create(APIService.class); // here we to add a parameter of the auth-token
    }
    public RestClient(String authToken){
            service=ServiceGenerator.createService(APIService.class,authToken);
    }
    public boolean createUser(final Context ctx, UserAccount user) {
        Call<UserAccount> u = service.createUser(user);
        u.enqueue(new Callback<UserAccount>() {
            @Override
            public void onResponse(Response<UserAccount> response) {

                success = response.isSuccess();
                if(success) {
                    Toast.makeText(ctx, "user Created", Toast.LENGTH_SHORT).show();
                } else {
                    Log.i("on response","je suis dans On response");
                    Toast.makeText(ctx, "Couldn't create user", Toast.LENGTH_SHORT).show();
                    Log.i("on response", response.errorBody().contentType().toString());
                }
            }

            @Override
            public void onFailure(Throwable t) {
                Log.w("REST", t.getMessage());
                Toast.makeText(ctx, "Couldn't create user", Toast.LENGTH_SHORT).show();
                Log.i("on response", "je suis dans On failure");

            }
        });
        return success;
    }
   /* public List<PatientMeetingPosting> getJobs() {
        Call<List<PatientMeetingPosting>> joblist = service.jobs();
        joblist.enqueue(new Callback<List<PatientMeetingPosting>>() {
            @Override
            public void onResponse(Response<List<PatientMeetingPosting>> response) {
                if (response.isSuccess()) {
                    Log.e("On reponse jobs", "success");
                    jobs = response.body();
                    callback.resultReady1(jobs);
                }
            }

            @Override
            public void onFailure(Throwable t) {
                Log.e("REST", t.getMessage());
            }
        });
        return jobs;
    }*/

    public List<MeetingHistories> getMeetings(String stat, String escortId) {

        Log.i("drapeau:", "j'entre dans fetMeetings");
        final Map parameters = ImmutableMap.of("filter[where][status]",stat,"filter[where][escortUserId]",escortId);
                Call < List < MeetingHistories >> meetinglist = service.meetings((ImmutableMap) parameters);
        Log.i("The string",parameters.toString());
        Log.i("drapeau:","apres req");
        meetinglist.enqueue(new Callback<List<MeetingHistories>>() {

            @Override
            public void onResponse(Response<List<MeetingHistories>> response) {
                Log.i("drapeau:", "je suis dans onResponse");
                if (response.isSuccess()) {
                    Log.e("On reponse jobs", "success");
                    meetings = response.body();
                    callback.resultReady(meetings);
                }
                else {
                    Log.i("failure de onresponse", response.errorBody().toString());
                }
            }

            @Override
            public void onFailure(Throwable t) {
                Log.i("drapeau:", "je suis dans onFailure");
                Log.e("REST", t.getMessage());
            }
        });
        Log.i("drapeau:", "just avant return");
        return meetings;

    }
    //public List<String> getJobTimes(final Context ctx,String id,List<String>)

  /*  public PatientMeetingPosting getPost(final Context ctx,String id ){
        Call<PatientMeetingPosting> u = service.getPost(id);
        u.enqueue(new Callback<PatientMeetingPosting>() {
            @Override
            public void onResponse(Response<PatientMeetingPosting> response) {

                success = response.isSuccess();

                if (success) {
                    Toast.makeText(ctx, "user Created", Toast.LENGTH_SHORT).show();
                    post=response.body();

                } else {
                    Log.i("on response", "je suis dans On response");
                    Toast.makeText(ctx, "Couldn't create user", Toast.LENGTH_SHORT).show();
                    Log.i("on response", response.errorBody().contentType().toString());
                }
            }

            @Override
            public void onFailure(Throwable t) {
                Log.w("REST", t.getMessage());
                Toast.makeText(ctx, "Couldn't create user", Toast.LENGTH_SHORT).show();
                Log.i("on response", "je suis dans On failure");

            }
        });
        return post;

    }*/
    public void setCallback(ResultReadyCallback callback) {
        this.callback = callback;
    }


    public static RestClient getInstance() {
        if(instance == null) {
            instance = new RestClient();
        }
        return instance;
    }

    public interface ResultReadyCallback{

        public void resultReady(List<MeetingHistories> l);
    }

}
