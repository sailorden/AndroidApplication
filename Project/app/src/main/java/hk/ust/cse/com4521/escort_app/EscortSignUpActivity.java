package hk.ust.cse.com4521.escort_app;

import android.accounts.Account;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import hk.ust.cse.com4521.escort_app.apiservices.RestClient;
import hk.ust.cse.com4521.escort_app.apiservices.model.UserAccount;

public class EscortSignUpActivity extends AppCompatActivity {


    private static final String TAG = "EscortSignUpActivity";
    private static final int REQUEST_SIGNUP =0;

    RestClient restClient = RestClient.getInstanceWithAccessToken();

    private EditText _nameText;
    private EditText _firstNameText;
    private EditText _lastNameText;
    private EditText _chineseFullName;
    private EditText _emailText;
    private EditText _passwordText;
    private EditText _adress;
    private EditText _bankAccountNum;
    private EditText _membershipId;
    private Button _signupButton;
    private Button _addButton;
    private TextView _loginLink;
    private TextView _myAvail;
    private Spinner _patientGender;
    private Spinner _HkDistrict;
    private Spinner _first_aid_certif;
    private CheckBox _D1;
    private CheckBox _D2;
    private CheckBox _D3;
    private CheckBox _D4;
    private ListView _Dialect;
    private String[] mDialect=null;
    private Spinner _days;
    private Spinner _timeSlot;

    private UserAccount escortAccount;
    private List<Integer> availabilities=new ArrayList<>(21);



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_escort_sign_up);
        getViews();
        setAdapters();
        setListeners();
    }

    public void getViews(){
        _nameText=(EditText)findViewById(R.id.input_loginName);
        _firstNameText=(EditText)findViewById(R.id.input_firstName);
        _lastNameText=(EditText)findViewById(R.id.input_lastName);
        _chineseFullName=(EditText)findViewById(R.id.input_chineseName);
        _emailText=(EditText)findViewById(R.id.input_email);
        _membershipId=(EditText)findViewById(R.id.input_membershipID);
        _adress=(EditText)findViewById(R.id.input_adress);
        _passwordText=(EditText)findViewById(R.id.input_password);
        _bankAccountNum=(EditText)findViewById(R.id.input_bankAccount);
        _signupButton=(Button)findViewById(R.id.btn_signup);
        _addButton=(Button)findViewById(R.id.btn_add);
        _myAvail=(TextView)findViewById(R.id.textA);
        _D1=(CheckBox)findViewById(R.id.D1);
        _D2=(CheckBox)findViewById(R.id.D2);
        _D3=(CheckBox)findViewById(R.id.D3);
        _D4=(CheckBox)findViewById(R.id.D4);
        _patientGender=(Spinner)findViewById(R.id.gender_spinner);
        _HkDistrict=(Spinner)findViewById(R.id.district_spinner);
        _first_aid_certif=(Spinner)findViewById(R.id.yes_no_spinner);
        _days=(Spinner)findViewById(R.id.days_spinner);
        _timeSlot=(Spinner)findViewById(R.id.time_spinner);

    }

    public List<Integer> getDialects(){
        List<Integer> l=new ArrayList<>();
        if (_D1.isChecked()) {
            l.add(0,1);
        }
        else l.add(0,0);
        if (_D2.isChecked()) {
            l.add(1,1);
        }
        else l.add(1,0);
        if (_D3.isChecked()) {
            l.add(2,1);
        }
        else l.add(2,0);
        if (_D4.isChecked()) {
            l.add(3,1);
        }
        else l.add(3,0);

        return l;

    }
    public void setAdapters(){
        // preferred patient gender spinner
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.user_gender, android.R.layout.simple_spinner_dropdown_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        _patientGender.setAdapter(adapter);
        // Hk districts list
        ArrayAdapter<CharSequence> adapter2 = ArrayAdapter.createFromResource(this,
                R.array.listDistrict, android.R.layout.simple_spinner_dropdown_item);
        adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        _HkDistrict.setAdapter(adapter2);

        // yes/no spinner
        ArrayAdapter<CharSequence> adapter3 = ArrayAdapter.createFromResource(this,
                R.array.yes_no, android.R.layout.simple_spinner_dropdown_item);
        adapter3.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        _first_aid_certif.setAdapter(adapter3);

        // days spinner
        ArrayAdapter<CharSequence> adapter4 = ArrayAdapter.createFromResource(this,
                R.array.daysList, android.R.layout.simple_spinner_dropdown_item);
        adapter4.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        _days.setAdapter(adapter4);

        // time spinner
        ArrayAdapter<CharSequence> adapter5 = ArrayAdapter.createFromResource(this,
                R.array.timeList, android.R.layout.simple_spinner_dropdown_item);
        adapter5.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        _timeSlot.setAdapter(adapter5);

    }

    public void setListeners(){
        _addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!availabilities.contains(_days.getSelectedItemPosition()+_timeSlot.getSelectedItemPosition())) {
                    availabilities.add(_days.getSelectedItemPosition() + _timeSlot.getSelectedItemPosition());
                    _myAvail.append(_days.getSelectedItem().toString() + "  " + _timeSlot.getSelectedItem().toString() + "\n");
                }

            }
        });


        _loginLink=(TextView)findViewById(R.id.link_login);

        _signupButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                signup();

                //restClient.createUser(getApplication(), createAccount());
            }
        });

        _loginLink.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Finish the registration screen and return to the Login activity
                finish();
            }
        });

    }





    public void signup() {
        Log.d(TAG, "Signup");

        if (!validate()) {
            onSignupFailed();
            return;
        }

        _signupButton.setEnabled(false);

        final ProgressDialog progressDialog = new ProgressDialog(EscortSignUpActivity.this,
                R.style.AppTheme_AppBarOverlay);
        progressDialog.setIndeterminate(true);
        progressDialog.setMessage("Creating Account...");
        progressDialog.show();

        restClient.createUser(getApplication(), createAccount());

        new android.os.Handler().postDelayed(
                new Runnable() {
                    public void run() {
                        // On complete call either onSignupSuccess or onSignupFailed
                        // depending on success
                        onSignupSuccess();
                        onSignupFailed();
                        progressDialog.dismiss();
                    }
                }, 3000);
    }


    public void onSignupSuccess() {
        _signupButton.setEnabled(true);
        setResult(RESULT_OK, null);
        saveUserInfo();
        Intent intent = new Intent(getApplicationContext(),LoginActivity.class);
        startActivityForResult(intent, REQUEST_SIGNUP);
        finish();
    }

    public void onSignupFailed() {
        Toast.makeText(getBaseContext(), "Sign up failed", Toast.LENGTH_LONG).show();

        _signupButton.setEnabled(true);
    }

    public boolean validate() {
        boolean valid = true;

        String name = _nameText.getText().toString();
        String email = _emailText.getText().toString();
        String password = _passwordText.getText().toString();

        if (name.isEmpty() || name.length() < 3) {
            _nameText.setError("at least 3 characters");
            valid = false;
        } else {
            _nameText.setError(null);
        }

        if (email.isEmpty() || !android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            _emailText.setError("enter a valid email address");
            valid = false;
        } else {
            _emailText.setError(null);
        }

        if (password.isEmpty() || password.length() < 4 || password.length() > 10) {
            _passwordText.setError("between 4 and 10 alphanumeric characters");
            valid = false;
        } else {
            _passwordText.setError(null);
        }

        return valid;
    }

    public UserAccount createAccount(){
        escortAccount=new UserAccount();
        escortAccount.setUserRole(2);
        escortAccount.setFirstName(_firstNameText.getText().toString());
        escortAccount.setLastName(_lastNameText.getText().toString());
        escortAccount.setChineseName(_chineseFullName.getText().toString());
        escortAccount.setMembershipNum(_membershipId.getText().toString());
        escortAccount.setBankAccountNum(_bankAccountNum.getText().toString());
        escortAccount.setEmail(_emailText.getText().toString());
        escortAccount.setEscortPreferLocation(_adress.getText().toString());
        escortAccount.setUsername(_nameText.getText().toString());
        escortAccount.setDialect(getDialects());
        escortAccount.setEscortPreferLocationDistrict(_HkDistrict.getSelectedItemPosition());
        if (_first_aid_certif.getSelectedItem().toString().equals("yes")){
            escortAccount.setFirstAidCert(true);
        }
        else escortAccount.setFirstAidCert(false);
        escortAccount.setEscortAvaiTimeSlot(availabilities);
        escortAccount.setPassword(_passwordText.getText().toString());
        return escortAccount;
    }

    private void saveUserInfo() {
        SharedPreferences prefs=getApplicationContext().getSharedPreferences(escortAccount.getUsername(), Context.MODE_PRIVATE);
        SharedPreferences.Editor prefed = prefs.edit();
        prefed.putString("username", escortAccount.getUsername());
        prefed.putString("password", escortAccount.getPassword());
        prefed.putInt("userRole", escortAccount.getUserRole());
        prefed.commit();
    }


}
