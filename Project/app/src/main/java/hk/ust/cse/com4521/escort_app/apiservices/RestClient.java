package hk.ust.cse.com4521.escort_app.apiservices;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import java.util.List;

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

    //private ResultReadyCallback callback;

    private static final String BASE_URL = "http://119.247.178.194:3000/explorer";
    private APIService service;

    public RestClient() {
        Retrofit retrofit = new Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(BASE_URL)
                .build();

        service = retrofit.create(APIService.class);
    }
    public boolean createUser(final Context ctx, UserAccount user) {
        Call<UserAccount> u = service.createUser(user);
        u.enqueue(new Callback<UserAccount>() {
            @Override
            public void onResponse(Response<UserAccount> response) {

                if(success) {
                    Toast.makeText(ctx, "User Created", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(ctx, "Couldn't create user", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Throwable t) {
                Log.w("REST", t.getMessage());
                Toast.makeText(ctx, "Couldn't create user", Toast.LENGTH_SHORT).show();

            }
        });
        return success;
    }


    public static RestClient getInstance() {
        if(instance == null) {
            instance = new RestClient();
        }
        return instance;
    }

    /*public interface ResultReadyCallback {
        public void resultReady(List<User> users);
    }*/

}
