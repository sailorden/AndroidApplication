package hk.ust.cse.com4521.escort_app;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import hk.ust.cse.com4521.escort_app.apiservices.RestClient;
import hk.ust.cse.com4521.escort_app.apiservices.model.MeetingHistories;
import hk.ust.cse.com4521.escort_app.apiservices.model.PatientMeetingPosting;

public class JobSuggestionsActivity extends AppCompatActivity {
    private static final int JOB_DETAIL = 0;
    public final static String meetingId = "hk.ust.cse.com4521.escort_app.meetingId";

    private List<MeetingHistories > _listJobs=null;
    private String _escortId; // we need to use intent to have this id frm the precendent activity
    private List<String> postsId=new ArrayList<>();
    RestClient restClient = RestClient.getInstance();
    RestClient.ResultReadyCallback callback = new RestClient.ResultReadyCallback() {
        @Override
        public void resultReady(List<MeetingHistories> meetings) {
            for(MeetingHistories meeting: meetings) {
                Log.i("list of date ", meeting.getMeetingDate());
                // store id in the same index of array to use it to display meeting details
                jobsId.add(meeting.getId());
                titles.add(meeting.getMeetingDate());
            }

            ((ArrayAdapter) mAdapter).notifyDataSetChanged();
        }
    };



    private String _jobTitle;
    private List<String> titles=new ArrayList<>();
    private List<String> jobsId=new ArrayList<>();
    private ListView _list;
    private ListAdapter mAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_job_suggestions);
        _list=(ListView)findViewById(R.id.listJobs);
        restClient.setCallback(callback);
        mAdapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, android.R.id.text1, titles);
        _list.setAdapter(mAdapter);

        restClient.getMeetings("1","test");
        _list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView,
                                    View view,
                                    int position,
                                    long id) {
                // Que faire quand on clique sur un élément de la liste ?
                Intent intent = new Intent(getApplicationContext(),MeetingDetailsActivity.class);

                intent.putExtra(meetingId,jobsId.get(position));
                startActivityForResult(intent, JOB_DETAIL );

            }
        });

    }



}
