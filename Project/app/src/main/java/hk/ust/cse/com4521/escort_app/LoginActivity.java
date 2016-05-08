package hk.ust.cse.com4521.escort_app;



        import android.app.ProgressDialog;
        import android.os.Bundle;
        import android.support.v7.app.AppCompatActivity;
        import android.util.Log;

        import android.content.Intent;
        import android.view.View;
        import android.widget.Button;
        import android.widget.EditText;
        import android.widget.TextView;
        import android.widget.Toast;

        import hk.ust.cse.com4521.escort_app.apiservices.RestClient;
        import hk.ust.cse.com4521.escort_app.apiservices.model.UserAccount;

/**
 * Created by SGHAIER on 21/04/16.
 */

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {
    private static final String TAG = "LoginActivity";
    private static final int REQUEST_SIGNUP = 0;
    private static final int SUCC_LOGIN = 0;

    RestClient restClient = RestClient.getInstanceWithOutAccessToken();

    private EditText _nameField ;
    private EditText _passwordField;
    private Button _loginButton ;
    private TextView _signupLink;

    boolean loginFlag = false;

    private UserAccount Account;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        // get all widgets of the screen
        _nameField=(EditText)findViewById(R.id.input_name); //_nameField.getText().toString() to have the email
        _passwordField=(EditText)findViewById(R.id.input_password);//_passwordField.getText().toString() to have the password
        _loginButton=(Button)findViewById(R.id.btn_login);
        _signupLink=(TextView)findViewById(R.id.link_signup);

        //ButterKnife.inject(this);

        // Set listner of differents events
        _loginButton.setOnClickListener(
                new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                login();
                //Intent intent = new Intent(getApplicationContext(),Escort.class);
                //startActivityForResult(intent, SUCC_LOGIN);
                /*if(restClient.getLoginFlag())
                {

                    //switch to other screens
                    Log.d("on response", "jump to escort screen");
                    Intent intent = new Intent(getApplicationContext(),Escort.class);
                    startActivityForResult(intent, SUCC_LOGIN);
                }
                else
                {
                    //screen remains unchange
                    Log.d("on response", "do nothing to screen");
                }
                */
            }
        });

        _signupLink.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // Start the Signup activity
                Intent intent = new Intent(getApplicationContext(),UserChoiceActivity.class);
                startActivityForResult(intent, REQUEST_SIGNUP );
            }
        });
    }

    public void login() {
        Log.d(TAG, "Login");
        // in this method
        if (!validate()) {
            onLoginFailed();
            return;
        }

        _loginButton.setEnabled(false);

       final ProgressDialog progressDialog = new ProgressDialog(LoginActivity.this,
                R.style.AppTheme);
        progressDialog.setIndeterminate(true);
        progressDialog.setMessage("Authenticating...");
        progressDialog.show();

        String name = _nameField.getText().toString();
        String password = _passwordField.getText().toString();

        // TODO: Implement your own authentication logic here.
        restClient.loginUser(getApplication(), loginAccount());




                new android.os.Handler().postDelayed(
                new Runnable() {
                    public void run() {
                        // On complete call either onLoginSuccess or onLoginFailed
                        if(restClient.getLoginFlag()) {
                            onLoginSuccess();
                        }
                        else {
                            onLoginFailed();
                            progressDialog.dismiss();
                        }
                        progressDialog.dismiss();
                    }
                }, 3000);
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == REQUEST_SIGNUP) {
            if (resultCode == RESULT_OK) {

                // TODO: Implement successful signup logic here
                // By default we just finish the Activity and log them in automatically
                this.finish();
            }
        }
    }

    @Override
    public void onBackPressed() {
        // disable going back to the MainActivity
        moveTaskToBack(true);
    }

    public void onLoginSuccess() {
        _loginButton.setEnabled(true);
        Intent intent = new Intent(getApplicationContext(),Escort.class);
        startActivityForResult(intent, SUCC_LOGIN);

        //finish();
    }

    public void onLoginFailed() {
        Toast.makeText(getBaseContext(), "Login failed", Toast.LENGTH_LONG).show();

        _loginButton.setEnabled(true);
    }

    /**this method verify if the name and the password are valid or not
     * An empty userName is not valid
     * */
    public boolean validate() {
        boolean valid = true;

        String name = _nameField.getText().toString();
        String password = _passwordField.getText().toString();

        if (name.isEmpty() ) {
            _nameField.setError("enter a valid userName");
            valid = false;
        } else {
            _nameField.setError(null);
        }

        if (password.isEmpty() || password.length() < 4 || password.length() > 10) {
            _passwordField.setError("between 4 and 10 alphanumeric characters");
            valid = false;
        } else {
            _passwordField.setError(null);
        }

        return valid;
    }

    @Override
    public void onClick(View v) {

    }

    public UserAccount loginAccount(){
        Account=new UserAccount();
        Account.setUsername(_nameField.getText().toString());
        Account.setPassword(_passwordField.getText().toString());
        return Account;
    }
}
