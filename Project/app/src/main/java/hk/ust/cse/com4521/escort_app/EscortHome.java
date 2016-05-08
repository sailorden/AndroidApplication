package hk.ust.cse.com4521.escort_app;



import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;




public class EscortHome extends Fragment{
    private static final int JOB_SUGG = 0;
    private static final int PEND_JOB = 0;
    private static final int COMP_JOB = 0;



    private Button _jobSuggestions=null;
    private Button _pendingJobs=null;
    private Button _completedJobs=null;
    public EscortHome() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_escort_home, container, false);

        _jobSuggestions = (Button)view.findViewById(R.id.btn_jobSuggestions);
        _jobSuggestions.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(),JobSuggestionsActivity.class);
                startActivityForResult(intent,JOB_SUGG );
            }
        });

        _pendingJobs = (Button)view.findViewById(R.id.btn_pendingJobs);
        _pendingJobs.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(),PendingJobsActivity.class);
                startActivityForResult(intent, PEND_JOB);
            }
        });

        _completedJobs = (Button)view.findViewById(R.id.btn_completedJobs);
        _completedJobs.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(),CompletedJobActivity.class);
                startActivityForResult(intent,COMP_JOB );
            }
        });
        return view;
    }


}