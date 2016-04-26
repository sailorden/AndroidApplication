package hk.ust.cse.com4521.escort_app.apiservices;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import java.util.List;

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
    private List<PatientMeetingPosting> jobs = null;

    public RestClient() {
        Retrofit retrofit = new Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(BASE_URL)
                .build();

        service = retrofit.create(APIService.class);
    }

    public boolean createJobPosting(final Context ctx, PatientMeetingPosting job) {
        Call<PatientMeetingPosting> u = service.createJob(job);
        u.enqueue(new Callback<PatientMeetingPosting>() {
            @Override
            public void onResponse(Response<PatientMeetingPosting> response) {

                success = response.isSuccess();
                if (success) {
                    Toast.makeText(ctx, "Job Created", Toast.LENGTH_SHORT).show();
                } else {
                    //Log.i("on response","je suis dans On response");
                    Toast.makeText(ctx, "Couldn't create Job", Toast.LENGTH_SHORT).show();
                    Log.i("on response", response.errorBody().toString());
                }
            }

            @Override
            public void onFailure(Throwable t) {
                Log.w("REST", t.getMessage());
                Toast.makeText(ctx, "Couldn't create job", Toast.LENGTH_SHORT).show();
                Log.i("on response", "je suis dans On failure");

            }
        });
        return success;

    }

    public List<PatientMeetingPosting> getJobs() {
        Call<List<PatientMeetingPosting>> joblist = service.jobs();
        joblist.enqueue(new Callback<List<PatientMeetingPosting>>() {
            @Override
            public void onResponse(Response<List<PatientMeetingPosting>> response) {
                if (response.isSuccess()) {
                    Log.e("On reponse jobs", "success");
                    jobs = response.body();
                    callback.resultReady(jobs);
                }
            }

            @Override
            public void onFailure(Throwable t) {
                Log.e("REST", t.getMessage());
            }
        });
        return jobs;
    }

    public void setCallback(ResultReadyCallback callback) {
        this.callback = callback;
    }


    public static RestClient getInstance() {
        if (instance == null) {
            instance = new RestClient();
        }
        return instance;
    }

    public interface ResultReadyCallback {
        public void resultReady(List<PatientMeetingPosting> jobs);

    }
}
