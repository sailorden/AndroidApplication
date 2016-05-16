package hk.ust.cse.com4521.escort_app;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class UserAccountManagementActivity extends AppCompatActivity {

    private static final int CREATE_STAFF_ACCOUNT = 0;
    private static final int DELETE_USER_ACCOUNT = 0;
    private static final int DELETE_USER_ACCOUNT_BY_YMCAid = 0;

    private Button _createStaffSAccountButton=null;
    private Button _deleteAccountButton=null;
    private Button _deleteAccountByYMCAidButton=null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_account_management);

        _createStaffSAccountButton=(Button)findViewById(R.id.btn_createStaffAccount);
        _deleteAccountButton=(Button)findViewById(R.id.btn_deleteAccount);
        _deleteAccountByYMCAidButton=(Button)findViewById(R.id.btn_deleteAccountByYMCAid);

        _createStaffSAccountButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), CreateStaffAccountActivity.class);
                startActivityForResult(intent, CREATE_STAFF_ACCOUNT);

            }
        });

        _deleteAccountButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), DeleteUserAccountActivity.class);
                startActivityForResult(intent, DELETE_USER_ACCOUNT);

            }
        });

        _deleteAccountByYMCAidButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), DeleteUserAccountByYMCAidActivity.class);
                startActivityForResult(intent, DELETE_USER_ACCOUNT_BY_YMCAid);

            }
        });

    }
}
