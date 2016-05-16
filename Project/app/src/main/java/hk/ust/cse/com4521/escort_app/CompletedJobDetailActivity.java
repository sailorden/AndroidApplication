package hk.ust.cse.com4521.escort_app;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListAdapter;
import android.widget.ListView;

import hk.ust.cse.com4521.escort_app.apiservices.RestClient;

public class CompletedJobDetailActivity extends AppCompatActivity {

    private static final String TAG = "CompletedJobDetailsActivity";

    final Context mContext = this;

    private ListAdapter mAdapter;
    private String[] jobInfo=new String[]{"","","","","","","","","",""};
    private ListView list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_completed_job_detail);
        Intent in = getIntent();
        // get job information from the previous activity
        Log.i("retour intent1", in.getStringArrayExtra(JobSugg.JOB_INFORMATION).toString());
        jobInfo=in.getStringArrayExtra(JobSugg.JOB_INFORMATION);
        Log.i("job info id", jobInfo[0]);
        //adapter with the array of job information
        mAdapter = new ArrayAdapter<String>(this,
                R.layout.job_information, R.id.Information, jobInfo);
        list = (ListView) findViewById(R.id.listDetails);
        //set the list adapter
        list.setAdapter(mAdapter);

    }



}
