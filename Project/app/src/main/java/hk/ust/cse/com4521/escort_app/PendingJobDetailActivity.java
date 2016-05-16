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
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

import hk.ust.cse.com4521.escort_app.apiservices.RestClient;
import hk.ust.cse.com4521.escort_app.apiservices.model.UserAccount;


/**
 * Created by SGHAIER on 25/04/16.
 */
public class PendingJobDetailActivity extends AppCompatActivity {

    private static final String TAG = "PendingJobDetailsActivity";

    final Context mContext = this;

    private ListAdapter mAdapter;
    private Button completed;
    private RestClient restClient = RestClient.getInstanceWithAccessToken();
    private String[] jobInfo=new String[]{"","","","","","","","","",""};
    private String jobId;
    private ListView list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pending_job_detail);
        completed= (Button) findViewById(R.id.btnCompleted);
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
        completed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // get prompts.xml view
                LayoutInflater li = LayoutInflater.from(mContext);
                View promptsView = li.inflate(R.layout.doctor_advice, null);

                AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(
                        mContext);

                // set prompts.xml to alertdialog builder
                alertDialogBuilder.setView(promptsView);

                final EditText userInput = (EditText) promptsView
                        .findViewById(R.id.editTextDialogUserInput);

                // set dialog message
                alertDialogBuilder
                        .setCancelable(false)
                        .setPositiveButton("Validate",
                                new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialog, int id) {
                                        // get user input and set it to result
                                        // edit text
                                        //advice=userInput.getText();
                                        if (!userInput.getText().equals(null)) {
                                            String[] newJobInfo=new String []{"","","","","","","","","",""};
                                            for(int i=0;i<9;i++){
                                                newJobInfo[i]=jobInfo[i];
                                            }
                                            newJobInfo[9] = "Doctor's advice : " + userInput.getText().toString();
                                            mAdapter = new ArrayAdapter<String>(mContext,
                                                    R.layout.job_information, R.id.Information, newJobInfo);
                                            list.setAdapter(mAdapter);
                                            AddAdvice advice = new AddAdvice(jobId,userInput.getText().toString(), 5);
                                            restClient.updateMeetingAdvice(advice);
                                        }
                                        else {
                                            AddAdvice advice = new AddAdvice(jobId,"", 5);
                                            restClient.updateMeetingAdvice(advice);
                                        }
                                        completed.setText("Job Completed");
                                        completed.setEnabled(false);


                                    }
                                })
                        .setNegativeButton("Cancel",
                                new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialog, int id) {
                                        dialog.cancel();
                                    }
                                });

                // create alert dialog
                AlertDialog alertDialog = alertDialogBuilder.create();

                // show it
                alertDialog.show();
            }
        });

    }

    //we use the temporary class to update the status of
    // an existing meeting according to the escort response
    public class AddAdvice {
        public String id="";
        public String doctorAdvice="";
        public int status=0;
        public AddAdvice(String iD,String advice,int st){
            id=iD;
            status=st;
            doctorAdvice=advice;
        }
    }

}
