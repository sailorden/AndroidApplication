package hk.ust.cse.com4521.escort_app.apiservices;

import com.google.common.collect.ImmutableMap;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import java.util.List;
import java.util.Map;
//import java.util.Map;

import hk.ust.cse.com4521.escort_app.JobDetailsActivity;
import hk.ust.cse.com4521.escort_app.LoginActivity;
import hk.ust.cse.com4521.escort_app.PendingJobDetailActivity;
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
    //private static RestClient instanceLogin = null;
    private static RestClient instance=null;

    private static String accessToken ="";
    private static String userID = "";
    boolean success = false;
    boolean loginFlag = false;
    boolean signUpflag = false;
    private ResultReadyCallback callback;
    public ResultReadyCallbackDetails callback2;
    public ResultReadyCallbackLoginActivity callBack3;
    public ResultReadyCallbackSearchUserByName callBack4;
    private int userRole=-9;



    private static final String BASE_URL = "http://119.247.178.194:3000";
    private APIService service;


    private List<MeetingHistories> meetings=null;
    private List<PatientMeetingPosting> postings=null;
    private PatientMeetingPosting p=null;
    private UserAccount user=null;
    private List<UserAccount> userAccounts=null;

    public RestClient() {
        Retrofit retrofit = new Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(BASE_URL)
                .build();

        service = retrofit.create(APIService.class); // here we to add a parameter of the auth-token
    }
    public RestClient(String authToken){
            service=ServiceGenerator.createService(APIService.class, authToken);
    }
    public boolean createUser(final Context ctx, UserAccount user) {
        Call<UserAccount> u = service.createUser(user);
        u.enqueue(new Callback<UserAccount>() {
            @Override
            public void onResponse(Response<UserAccount> response) {

                success = response.isSuccess();
                if (success) {
                    Toast.makeText(ctx, "User created", Toast.LENGTH_SHORT).show();
                    signUpflag = true;
                } else {
                    Log.i("on response", "je suis dans On response");
                    Toast.makeText(ctx, "Couldn't create user", Toast.LENGTH_SHORT).show();
                    Log.i("on response", response.errorBody().contentType().toString());
                    signUpflag = false;
                }
            }

            @Override
            public void onFailure(Throwable t) {
                Log.w("REST", t.getMessage());
                Toast.makeText(ctx, "Couldn't create user", Toast.LENGTH_SHORT).show();
                Log.i("on response", "je suis dans On failure");
                signUpflag = false;
            }
        });
        return success;
    }

    //for staff creation module module   by TANG   08/05/2016
    public boolean getSignUpFlag()
    {
        return signUpflag;
    }

    //for login module   by TANG   08/05/2016
    public LoginActivity.loginResponse loginUser(final Context ctx, final LoginActivity.loginResponse Account) {
        Call<LoginActivity.loginResponse> loginAccount = service.loginUser(Account);
        loginAccount.enqueue(new Callback<LoginActivity.loginResponse>() {
            @Override
            public void onResponse(Response<LoginActivity.loginResponse> response) {

                //success = response.isSuccess();
                if (response.isSuccess()) {
                    Toast.makeText(ctx, "User was logged", Toast.LENGTH_SHORT).show();

                    loginFlag = true;
                    accessToken = response.body().id;
                    Account.userId = response.body().userId;
                    instance=new RestClient(accessToken);
                    callBack3.responseLoginReady(response.body());
                    //RestClient.getInstanceWithAccessToken().findUserById(Account.userId);
                    Log.d("on response", accessToken);
                    Log.d("on response", Account.userId);
                    Log.d("on response", "above is access token and userID");



                } else {
                    Log.i("on response", "Login Fail, incorrect login name/ password");
                    Toast.makeText(ctx, "Login Fail, incorrect login name/ password", Toast.LENGTH_SHORT).show();
                    Log.i("on response", response.errorBody().contentType().toString());
                    loginFlag = false;
                }

            }

            @Override
            public void onFailure(Throwable t) {
                Log.w("REST", t.getMessage());
                Toast.makeText(ctx, "Login Fail, incorrect login name/ password2", Toast.LENGTH_SHORT).show();
                Log.i("on response", "Couldn't create user 2");
                loginFlag = false;  //
            }
        });
        return Account;
    }

    public boolean getLoginFlag()
    {
        return loginFlag;
    }


    //for deleteUserAccount by name module by TANG  08/05/2016
    public List<UserAccount> getUserAccountList(String firstName, String lastName) {

        Log.i("drapeau:", "running getUserAccountList");
        //final Map parameters = ImmutableMap.of("filter[where][firstName]",firstName);
        final Map parameters = ImmutableMap.of("filter[where][firstName]",firstName,"filter[where][lastName]",lastName);
        final Call < List < UserAccount >> userAccountListByName = service.getUserAccountsByName((ImmutableMap) parameters);
        //final Call < List < UserAccount >> userAccountListByName = service.getUserAccountsByName();
        //Log.i("The string",parameters.toString());
        Log.i("drapeau:","ready to enqueue");
        userAccountListByName.enqueue(new Callback<List<UserAccount>>() {

            @Override
            public void onResponse(Response<List<UserAccount>> response) {
                Log.i("drapeau:", "requesting");
                if (response.isSuccess()) {
                    Log.e("On response jobs", "success getUserAccountList");
                    userAccounts = response.body();

                    for(UserAccount userAccount: userAccounts)
                    {
                        Log.e("username ", userAccount.getUsername().toString());
                        Log.e("username ", userAccount.getEmail().toString());
                        //list.add(userAccount.getUsername());
                    }
                    //callBack4.searchUserAccountResultReady(response.body());
                    //Log.e("listSize", response.body().status.toString());
                    //callback.resultReady(meetings);
                } else {
                    Log.i("onResponse failure", response.errorBody().toString());
                }
            }

            @Override
            public void onFailure(Throwable t) {
                Log.i("REST", "on Response failure 2");
                Log.e("REST", t.getMessage());
            }
        });
        Log.i("drapeau:", "getUserAccountList return");
        return userAccounts;

    }

    public List<UserAccount> getUserAccountsByName()
    {
        return (userAccounts);
    }


    //for UserAccountDetailActivity by TANG   16/05/2016
    public void deleteUserById(final Context ctx, final String userId) {
        final Call<UserAccount> userAccount = service.deleteAccountByUserId(userId);
        userAccount.enqueue(new Callback<UserAccount>() {

            @Override
            public void onResponse(Response<UserAccount> response) {
                //success = response.isSuccess();

                if (response.isSuccess()) {

                    Log.i("on response", "user is deleted");
//                  Log.i("get post id", response.body().getUsername());
                    Toast.makeText(ctx, "User account was deleted. " + userId, Toast.LENGTH_SHORT).show();

                    //callBack3.userAccountReady(user);
                } else {
                    Log.i("on response", "delete unsuccessful" + userId);
                    Toast.makeText(ctx, "Delete was unsuccessful.", Toast.LENGTH_SHORT).show();
                    Log.i("on response", response.errorBody().toString());
                }
            }


            @Override
            public void onFailure(Throwable t) {
                Toast.makeText(ctx, "Delete was unsuccessful.", Toast.LENGTH_SHORT).show();
                Log.e("REST", t.getMessage());
            }

        });
    }


    public List<MeetingHistories> getMeetings(String stat, String escortId) {

        Log.i("drapeau:", "j'entre dans fetMeetings");
        final Map parameters = ImmutableMap.of("filter[where][status]",stat,"filter[where][escortID]",escortId);
                final Call < List < MeetingHistories >> meetinglist = service.meetings((ImmutableMap) parameters);
        Log.i("The string",parameters.toString());
        Log.i("drapeau:","apres req");
        meetinglist.enqueue(new Callback<List<MeetingHistories>>() {

            @Override
            public void onResponse(Response<List<MeetingHistories>> response) {
                Log.i("drapeau:", "je suis dans onResponse");
                if (response.isSuccess()) {
                    Log.e("On reponse jobs", "success");
                    meetings = response.body();
                    Log.e("listSize", meetings.toString());
                    callback.resultReady(meetings);
                } else {
                    Log.i("onResponse failure", response.errorBody().toString());
                }
            }

            @Override
            public void onFailure(Throwable t) {
                Log.i("REST", "je suis dans onFailure");
                Log.e("REST", t.getMessage());
            }
        });
        Log.i("drapeau:", "just avant return");
        return meetings;

    }

    public UserAccount findUserById( final String userId) {
        final Call<UserAccount> userAccount = service.findUserById(userId);
        userAccount.enqueue(new Callback<UserAccount>() {

            @Override
            public void onResponse(Response<UserAccount> response) {
                success = response.isSuccess();

                if (success) {
                    //Toast.makeText(ctx, "patient found by id", Toast.LENGTH_SHORT).show();
                    Log.i("on response", "user found");
//                    Log.i("get post id", response.body().getUsername());
                    user = response.body();

                    callBack3.userAccountReady(user);
                } else {
                    Log.i("on response", "user not found" + userId);
                    //Toast.makeText(ctx, "Couldn't find patient by id", Toast.LENGTH_SHORT).show();
                    Log.i("on response", response.errorBody().toString());
                }
            }


            @Override
            public void onFailure(Throwable t) {
                Log.e("REST", t.getMessage());
            }

        });

        return user;
    }

    public void updateMeetingStatus(JobDetailsActivity.MeetingUpdate meeting){
        Log.i("enter","update");
       // MeetingHistories meeting=new MeetingHistories();
       // meeting.setStatus(status);
        final Call <JobDetailsActivity.MeetingUpdate > m= service.updateMeeting(meeting);
        m.enqueue(new Callback<JobDetailsActivity.MeetingUpdate >() {
            @Override
            public void onResponse(Response<JobDetailsActivity.MeetingUpdate> response) {
            if(response.isSuccess()) {
                   Log.i("update","sucess update meeting");
                JobDetailsActivity.MeetingUpdate meeting=response.body();
                Log.i("status",meeting.status.toString());
                Log.i("id", meeting.id);
                }
            else {
                Log.i("update","fail to update meeting");
                Log.i("error",response.errorBody().toString());
            }
            }


            @Override
            public void onFailure(Throwable t) {
                Log.e("REST", t.getMessage());

            }
        });

    }
    public void updateMeetingAdvice( PendingJobDetailActivity.AddAdvice meeting){
        Log.i("enter","update");
        // MeetingHistories meeting=new MeetingHistories();
        // meeting.setStatus(status);
        final Call <PendingJobDetailActivity.AddAdvice> m= service.updateAdvice(meeting);
        m.enqueue(new Callback<PendingJobDetailActivity.AddAdvice>() {
            @Override
            public void onResponse(Response<PendingJobDetailActivity.AddAdvice> response) {
                if(response.isSuccess()) {
                    Log.i("update","sucess update meeting");
                   // JobDetailsActivity.MeetingUpdate meeting=response.body();
                    //Log.i("status", ((String) response.body().status));
                    //Log.i("id",respo);
                }
                else {
                    Log.i("update","fail to update meeting");
                    Log.i("error",response.errorBody().toString());
                }
            }


            @Override
            public void onFailure(Throwable t) {
                Log.e("REST", t.getMessage());

            }
        });

    }





    public void setCallback(ResultReadyCallback callback) {
        this.callback = callback;
    }
    public void setCallback2(ResultReadyCallbackDetails callback) {
        this.callback2 = callback;
    }


    public static RestClient getInstanceWithAccessToken() {
        if(instance == null) {
            instance = new RestClient(accessToken);
        }
        else{
            Log.i("getInstance","Instance not null");
        }
        return instance;
    }

    public static RestClient getInstanceWithoutAccessToken(){
       if (instance == null){

           instance=new RestClient();
       }
        return instance;
    }


    public interface RoleUserReady{
        public void userAccount(UserAccount user);

    }

    public interface ResultReadyCallbackDetails{
        public void resultUserByIdReady(UserAccount user);
    }

    public interface ResultReadyCallbackLoginActivity{
        public void responseLoginReady(LoginActivity.loginResponse res);
        public void userAccountReady(UserAccount user);


    }

    public interface ResultReadyCallbackSearchUserByName{
        public void searchUserAccountResultReady(List<UserAccount> userAccounts);
    }

    public interface ResultReadyCallback{
        public void resultReady(List<MeetingHistories> l);

    }

}
