package hk.ust.cse.com4521.escort_app;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import hk.ust.cse.com4521.escort_app.apiservices.RestClient;
import hk.ust.cse.com4521.escort_app.apiservices.model.UserAccount;

public class CreateStaffAccountActivity extends AppCompatActivity {

    private Button _submit;
    private RestClient restClient = RestClient.getInstanceWithAccessToken();

    private EditText _loginNameField ;
    private EditText _passwordField;
    private EditText _emailField;
    private EditText _firstNameField;
    private EditText _lastNameField;
    private EditText _telephoneNumField;
    private UserAccount staffAccount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_staff_account);
        _submit = (Button) findViewById(R.id.btn_submit);
        _loginNameField=(EditText)findViewById(R.id.input_loginName);
        _passwordField=(EditText)findViewById(R.id.input_password);
        _emailField=(EditText)findViewById(R.id.input_email);
        _firstNameField=(EditText)findViewById(R.id.input_firstName);
        _lastNameField=(EditText)findViewById(R.id.input_lastName);
        _telephoneNumField=(EditText)findViewById(R.id.input_telephoneNum);
        setOnClickListners();


    }

    //validate if fields are correctly filled
    public boolean validate() {
        boolean valid = true;

        String loginname = _loginNameField.getText().toString();
        String password = _passwordField.getText().toString();
        String email = _emailField.getText().toString();
        String firstname = _firstNameField.getText().toString();
        String lastname = _lastNameField.getText().toString();
        String telephoneNum = _telephoneNumField.getText().toString();


        if (loginname.isEmpty() || loginname.length() < 3) {
            _loginNameField.setError("at least 3 characters");
            valid = false;
        } else {
            _loginNameField.setError(null);
        }

        if (password.isEmpty() || password.length() < 4 || password.length() > 10) {
            _passwordField.setError("between 4 and 10 alphanumeric characters");
            valid = false;
        } else {
            _passwordField.setError(null);
        }

        if (email.isEmpty() || !android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            _emailField.setError("enter a valid email address");
            valid = false;
        } else {
            _emailField.setError(null);
        }

        if (firstname.isEmpty() || firstname.length() < 3) {
            _firstNameField.setError("at least 3 characters");
            valid = false;
        } else {
            _firstNameField.setError(null);
        }

        if (lastname.isEmpty() || lastname.length() < 3) {
            _lastNameField.setError("at least 3 characters");
            valid = false;
        } else {
            _lastNameField.setError(null);
        }

        if (telephoneNum.isEmpty() || telephoneNum.length() < 8 ||telephoneNum.length() > 8) {
            _telephoneNumField.setError("Only 8 digits are allowed");
            valid = false;
        } else {
            _telephoneNumField.setError(null);
        }

        return valid;
    }

    public void setOnClickListners() {
        _submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //create an object to be sent to the restClient
                if (validate()) {
                    staffAccount = new UserAccount();
                    staffAccount.setUserRole(0);
                    staffAccount.setUsername(_loginNameField.getText().toString());
                    staffAccount.setPassword(_passwordField.getText().toString());
                    staffAccount.setEmail(_emailField.getText().toString());
                    staffAccount.setFirstName(_firstNameField.getText().toString());
                    staffAccount.setLastName(_lastNameField.getText().toString());
                    staffAccount.setTelephoneNum(_telephoneNumField.getText().toString());

                    restClient.createUser(getApplication(), staffAccount);
                    _submit.setEnabled(false);

                    new android.os.Handler().postDelayed(
                            new Runnable() {
                                public void run() {
                                    // On complete call either onSignupSuccess or onSignupFailed
                                    // depending on success
                                    if (restClient.getSignUpFlag())
                                    {
                                        _loginNameField.setText("");
                                        _passwordField.setText("");
                                        _emailField.setText("");
                                        _firstNameField.setText("");
                                        _lastNameField.setText("");
                                        _telephoneNumField.setText("");
                                    }
                                    _submit.setEnabled(true);
                                    //progressDialog.dismiss();
                                }
                            }, 3000);
                }


            }


        });


    }



}
