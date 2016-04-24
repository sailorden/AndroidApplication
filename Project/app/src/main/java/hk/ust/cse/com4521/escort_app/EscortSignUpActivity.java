package hk.ust.cse.com4521.escort_app;

import android.app.ProgressDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class EscortSignUpActivity extends AppCompatActivity {


    private static final String TAG = "EscortSignUpActivity";
    private static final int REQUEST_SIGNUP = 0;


    private EditText _nameText;
    private EditText _firstNameText;
    private EditText _lastNameText;
    private EditText _emailText;
    private EditText _passwordText;
    private Button _signupButton;
    private TextView _loginLink;
    private Spinner _patientGender;
    private ListView _Dialect;
    private String[] mDialect=null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_escort_sign_up);

        _nameText=(EditText)findViewById(R.id.input_loginName);
        _firstNameText=(EditText)findViewById(R.id.input_firstName);
        _lastNameText=(EditText)findViewById(R.id.input_lastName);
        _emailText=(EditText)findViewById(R.id.input_email);
        _passwordText=(EditText)findViewById(R.id.input_password);
        _signupButton=(Button)findViewById(R.id.btn_signup);
        _patientGender=(Spinner)findViewById(R.id.gender_spinner);
        _Dialect=(ListView)findViewById(R.id.listDialect);

        // Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.user_gender, android.R.layout.simple_spinner_dropdown_item);
        // Specify the layout to use when the list of choices appears
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // Apply the adapter to the spinner
        _patientGender.setAdapter(adapter);

        //Dialect lisView
        mDialect = new String[]{"D1", "D2", "D3", "D4"};
        _Dialect.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_multiple_choice, mDialect));
        //On déclare qu'on sélectionne de base le second élément (Féminin)
       _Dialect.setItemChecked(1, true);



        _loginLink=(TextView)findViewById(R.id.link_login);

        _signupButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                signup();
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

        String name = _nameText.getText().toString();
        String email = _emailText.getText().toString();
        String password = _passwordText.getText().toString();

        // TODO: Implement  signup logic here.

        new android.os.Handler().postDelayed(
                new Runnable() {
                    public void run() {
                        // On complete call either onSignupSuccess or onSignupFailed
                        // depending on success
                        onSignupSuccess();
                        // onSignupFailed();
                        progressDialog.dismiss();
                    }
                }, 3000);
    }


    public void onSignupSuccess() {
        _signupButton.setEnabled(true);
        setResult(RESULT_OK, null);
        finish();
    }

    public void onSignupFailed() {
        Toast.makeText(getBaseContext(), "Login failed", Toast.LENGTH_LONG).show();

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


}
