package hk.ust.cse.com4521.escort_app;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class UserChoiceActivity extends AppCompatActivity implements View.OnClickListener{

    private static final String TAG = "UserChoiceActivity";
    private static final int REQUEST_CONTINUE_SIGNUP= 0;


    private Button _continueButton=null ;
    private TextView _usertypeReq=null;
    private RadioGroup _groupeUser=null;

    private boolean escort=true;
    private boolean patient=false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_choice);
        _usertypeReq=(TextView)findViewById(R.id.user_type_req);
        _continueButton=(Button)findViewById(R.id.button_continue);
        // On récupère le RadioGroup qui gère le type de user
        _groupeUser=(RadioGroup)findViewById(R.id.group_user);
        // On rajoute un Listener sur le changement de RadioButton sélectionné
        _groupeUser.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                // En fonction de l'identifiant du RadioButton sélectionné…
                switch (checkedId) {
                    case R.id.radio_escort:
                        Log.i(TAG, "escort checked");
                        escort = true;
                        patient=false;
                        break;
                    case R.id.radio_patient:
                        Log.i(TAG, "patient checked");
                        patient = true;
                        escort=false;
                        break;


                }

            }
        });
        _continueButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (escort) {
                    Intent intent = new Intent(getApplicationContext(), EscortSignUpActivity.class);
                    startActivityForResult(intent, REQUEST_CONTINUE_SIGNUP );
                }
                else if (patient){
                    Intent intent = new Intent(getApplicationContext(),PatientSignUpActivity.class);
                    startActivityForResult(intent, REQUEST_CONTINUE_SIGNUP );
                }
            }
        });
        }


    @Override
    public void onClick(View v) {

    }

}
