package hk.ust.cse.com4521.escort_app;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;

import hk.ust.cse.com4521.escort_app.apiservices.RestClient;
import hk.ust.cse.com4521.escort_app.apiservices.model.UserAccount;

public class UserAccountDetailActivity extends AppCompatActivity {
    private String[] userAccountInfo = new String[]{"","","","","","","",""};
    private String userId = "";
    RestClient restClient = RestClient.getInstanceWithAccessToken();
    private ListView lv;
    ArrayAdapter<String> adapter = null;
    private ArrayList<String> list = new ArrayList<String>();
    private Button _deleteUserButton=null;
    AlertDialog.Builder builder1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_account_detail);
        lv = (ListView)findViewById(R.id.listView);
        _deleteUserButton = (Button)findViewById(R.id.btn_deleteUser);

        adapter = new ArrayAdapter<String>(
                this,
                android.R.layout.simple_expandable_list_item_1,
                list);
        lv.setAdapter(adapter);

        Intent in = getIntent();
        // get job information from the previous activity
        Log.i("print intent1 info", in.getStringArrayExtra(DeleteUserAccountActivity.USER_INFORMATION).toString());
        userAccountInfo=in.getStringArrayExtra(DeleteUserAccountActivity.USER_INFORMATION);
        Log.i("Username detailPage", userAccountInfo[0]);
        // get jobId from the previous activity
        userId = in.getStringExtra("USER_ID");
        Log.i("user id detail", userId);


        for (int i=0; i<9; i++) {
            Log.i("username view", userAccountInfo[i]);
            list.add(userAccountInfo[i]);

        }

        //call alert dialog after the delete user button was pressed
        builder1 = new AlertDialog.Builder(UserAccountDetailActivity.this);
        builder1.setMessage("Are you sure that you want to permanently delete the selected user?");
        builder1.setCancelable(true);

        builder1.setPositiveButton(
                "Yes",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.cancel();
                        Log.i("deleting user account ", userId);
                        restClient.deleteUserById(getApplicationContext(), userId);

                        new android.os.Handler().postDelayed(
                                new Runnable() {
                                    public void run() {
                                        finish();
                                    }
                                }, 300);
                    }
                });

        builder1.setNegativeButton(
                "No",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.cancel();
                        _deleteUserButton.setEnabled(true);
                    }
                });




        adapter.notifyDataSetChanged();

        _deleteUserButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //restClient.getUserAccountList("ppppp", "ppppp");
                _deleteUserButton.setEnabled(false);



                AlertDialog alert11 = builder1.create();
                alert11.show();





            }
        });





    }
}
