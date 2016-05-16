package hk.ust.cse.com4521.escort_app;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class StaffHomeActivity extends AppCompatActivity {


    private Button _escortValidationButton=null;
    private Button _patientEscortPairingButton=null;
    private Button _userAccountManagementButton=null;
    private Button _notificationButton=null;
    private Button _reportGenerationButton=null;

    private static final int USER_ACCOUNT_MAN = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_staff_home);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        _escortValidationButton=(Button)findViewById(R.id.btn_escortValidation);
        _patientEscortPairingButton=(Button)findViewById(R.id.btn_patientEscortPairing);
        _userAccountManagementButton=(Button)findViewById(R.id.btn_userAccountManagement);
        _notificationButton=(Button)findViewById(R.id.btn_notification);
        _reportGenerationButton=(Button)findViewById(R.id.btn_reportGeneration);

        _escortValidationButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

            }
        });

        _patientEscortPairingButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {


            }
        });

        _userAccountManagementButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),UserAccountManagementActivity.class);
                startActivityForResult(intent, USER_ACCOUNT_MAN);
                //finish();

            }
        });

        _notificationButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {


            }
        });

        _reportGenerationButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {


            }
        });

    }

    @Override
    public void onBackPressed() {
        return;
    }

}
