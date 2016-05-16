package hk.ust.cse.com4521.escort_app;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

import hk.ust.cse.com4521.escort_app.apiservices.RestClient;
import hk.ust.cse.com4521.escort_app.apiservices.model.MeetingHistories;
import hk.ust.cse.com4521.escort_app.apiservices.model.PatientMeetingPosting;
import hk.ust.cse.com4521.escort_app.apiservices.model.UserAccount;

public class JobDetailsActivity extends AppCompatActivity {
    private static final String TAG = "JobDetailsActivity";

    private ListAdapter mAdapter;
    private Button accept;
    private Button decline;
    private RestClient restClient = RestClient.getInstanceWithAccessToken();
    private String[] jobInfo=new String[]{"","","","","","","",""};
    private String jobId;
    private ListView list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_job_details);
        accept = (Button) findViewById(R.id.btnAccept);
        decline = (Button) findViewById(R.id.btnDecline);
        setOnClickListners();

        Intent in = getIntent();
        // get job information from the previous activity
        Log.i("retour intent1",in.getStringArrayExtra(JobSugg.JOB_INFORMATION).toString());
        jobInfo=in.getStringArrayExtra(JobSugg.JOB_INFORMATION);
        Log.i("job info id", jobInfo[0]);
        // get jobId from the previous activity
        jobId =in.getStringExtra("JOB_ID");
        //adapter with the array of job information
        mAdapter = new ArrayAdapter<String>(this,
                R.layout.job_information, R.id.Information, jobInfo);
        list = (ListView) findViewById(R.id.listDetails);
        //set the list adapter
        list.setAdapter(mAdapter);

    }


    public void setOnClickListners() {
        accept.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //update meting status
               MeetingUpdate updateInfo=new MeetingUpdate();
                updateInfo.status=1;
                updateInfo.id=jobId;
                Log.i(TAG,"juste avant update dans listner");
                restClient.updateMeetingStatus(updateInfo);
                Toast.makeText(getBaseContext(), "You response has been sent " +
                        "to the NGO center ", Toast.LENGTH_LONG).show();
                accept.setEnabled(false);
                decline.setEnabled(false);

            // set the two buttons enabled
                // diplay a message that the response is send to the NGO center

            }


        });

        decline.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //update meting status
                MeetingUpdate updateInfo = new MeetingUpdate();
                updateInfo.status =-1;
                updateInfo.id = jobId;
                restClient.updateMeetingStatus(updateInfo);
                Toast.makeText(getBaseContext(), "You response has been " +
                        "sent to the NGO center ", Toast.LENGTH_LONG).show();
                accept.setEnabled(false);
                decline.setEnabled(false);
            }
        });


    }

    //we use the temporary class to update the status of
    // an existing meeting according to the escort response
    public class MeetingUpdate {
        public Integer status=0;
        public String id="";
    }
}