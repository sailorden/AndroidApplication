package hk.ust.cse.com4521.escort_app;

import android.app.ListActivity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import hk.ust.cse.com4521.escort_app.apiservices.RestClient;
import hk.ust.cse.com4521.escort_app.apiservices.model.MeetingHistories;
import hk.ust.cse.com4521.escort_app.apiservices.model.PatientMeetingPosting;

public class JobSugg extends ListActivity {
    private static final String TAG = "LIST_ACTIVITY";
    public final static String JOB_INFORMATION = "hk.ust.cse.com4521.escort_app.JobSugg";

    private static final int JOB_DETAIL = 0;

    private List<String> titles=new ArrayList<>();
    private String[] _jobDetails=new String[]{"","","","","","","","",""} ;// contain a selected job details
    private ListAdapter mAdapter;
    public List<MeetingHistories > _listJobs=new ArrayList<>();
    private String _escortId="";
    private int val=0;
    RestClient restClient = RestClient.getInstanceWithAccessToken();
    RestClient.ResultReadyCallback callback = new RestClient.ResultReadyCallback() {
        @Override
        public void resultReady(List<MeetingHistories> meetings) {
            for(MeetingHistories meeting: meetings) {
                Log.i("list of date ", meeting.PatientMeetingPosting.getMeetingDate());
                // store id in the same index of array to use it to display meeting details
                _listJobs.add(meeting);
                titles.add(meeting.PatientMeetingPosting.getMeetingDate());
            }

            ((ArrayAdapter) mAdapter).notifyDataSetChanged();
        }
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        restoreUserInfo();
        restClient.setCallback(callback);
        Intent in=getIntent();

        val=in.getIntExtra("SELECT",val);
        if (val==1){
            //job suggestions
            restClient.getMeetings("1", _escortId);
        }
        else if (val==2){
            //pending meetings
            restClient.getMeetings("1", _escortId);
        }
        else if(val==3){
            //completed meetings
            restClient.getMeetings("5", _escortId);
        }

        mAdapter = new ArrayAdapter<String>(this,
                R.layout.meeting_item,titles);
        setListAdapter(mAdapter);

    }

    @Override
    protected void onResume() {
        super.onResume();

    }

    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);

        MeetingHistories selectedJob=_listJobs.get((int) id);


        _jobDetails[0]="Patient full Name : "+selectedJob.patient.getUsername();//selectedJob.PatientMeetingPosting.patient.getFirstName()
                //+selectedJob.PatientMeetingPosting.patient.getLastName();
        _jobDetails[1]="Date : "+selectedJob.PatientMeetingPosting.getMeetingDate();
        _jobDetails[2]="Pick up Time : "+selectedJob.PatientMeetingPosting.getMeetingTimeStart();
        _jobDetails[3]="Duration : "+selectedJob.PatientMeetingPosting.getMeetingDuration();
        _jobDetails[4]="Pick up Location: "+selectedJob.PatientMeetingPosting.getDistrict();
        _jobDetails[5]="Job Location : "+selectedJob.PatientMeetingPosting.getLocation();
        _jobDetails[6]="Need Wheel chair : "+selectedJob.PatientMeetingPosting.getWheelchair();
        _jobDetails[7]="YMCA Contact : "+selectedJob.staff.getUsername();//.getFirstName()+selectedJob.staff.getFirstName();
        _jobDetails[8]="Tel : "+selectedJob.staff.getTelephoneNum();

        //String patientId=selectedJob.getPatientID();
        //String patientPostingId=selectedJob.getPatientMeetingPostingID();
        String jobId=selectedJob.getId();
        Intent in;
        switch (val) {
            case 1:
                in = new Intent(this,JobDetailsActivity.class);
                in.putExtra(JobSugg.JOB_INFORMATION, _jobDetails);
                in.putExtra("JOB_ID",jobId);
                //in.putExtra("PATIENT_ID",patientId);
                //in.putExtra("POSTING_ID",patientPostingId);
                startActivity(in);
                break;
            case 2:
                in = new Intent(this,PendingJobDetailActivity.class);
                in.putExtra(JobSugg.JOB_INFORMATION, _jobDetails);
                in.putExtra("JOB_ID",jobId);
               // in.putExtra("PATIENT_ID",patientId);
                //in.putExtra("POSTING_ID",patientPostingId);
                startActivity(in);

                break ;
            case 3:
                in = new Intent(this,CompletedJobDetailActivity.class);
                in.putExtra(JobSugg.JOB_INFORMATION, _jobDetails);
                in.putExtra("JOB_ID",jobId);
                //in.putExtra("PATIENT_ID", patientId);
                //in.putExtra("POSTING_ID",patientPostingId);
                startActivity(in);

                break;
            default:break;
        }
    }


    private void restoreUserInfo() {
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
        _escortId= prefs.getString("userId", "");
        Log.i(TAG,"user id is "+_escortId);


    }



}
