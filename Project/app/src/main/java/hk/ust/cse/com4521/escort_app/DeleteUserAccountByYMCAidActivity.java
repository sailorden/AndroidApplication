package hk.ust.cse.com4521.escort_app;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import hk.ust.cse.com4521.escort_app.apiservices.RestClient;
import hk.ust.cse.com4521.escort_app.apiservices.model.UserAccount;

public class DeleteUserAccountByYMCAidActivity extends AppCompatActivity {

    private ListView lv;
    private ArrayList<String> list = new ArrayList<String>();
    private List<UserAccount> userAccounts;
    ArrayAdapter<String> adapter = null;
    private String[] _userDetails=new String[]{"","","","","","","","",""} ;// contain a selected userDetail
    private static final int USER_ACCOUNT_DETAIL = 0;
    public final static String USER_INFORMATION = "hk.ust.cse.com4521.escort_app.DeleteUserAccountActivity";
    private EditText _YMCAidField ;
    private Button _searchButton=null;

    RestClient restClient = RestClient.getInstanceWithAccessToken();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delete_user_account_by_ymcaid);

        lv = (ListView)findViewById(R.id.listView);
        _searchButton = (Button)findViewById(R.id.btn_search);
        _YMCAidField = (EditText)findViewById(R.id.input_YMCAid);

        adapter = new ArrayAdapter<String>(
                this,
                android.R.layout.simple_expandable_list_item_1,
                list);
        lv.setAdapter(adapter);

        _searchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //restClient.getUserAccountList("ppppp", "ppppp");
                _searchButton.setEnabled(false);
                final String YMCAmemberID = _YMCAidField.getText().toString();
                Log.i("YMCAmemberID view", YMCAmemberID);

                restClient.getUserAccountListByYMCAid(YMCAmemberID);

                new android.os.Handler().postDelayed(
                        new Runnable() {
                            public void run() {

                                list.clear();
                                //userAccounts.removeAll(userAccounts);
                                userAccounts = restClient.getUserAccountsByYMCAid();

                                if (userAccounts.size() > 0) {
                                    for (UserAccount userAccount : userAccounts) {
                                        Log.i("username view", userAccount.getUsername().toString());
                                        list.add(userAccount.getUsername().toString());
                                    }
                                }
                                //progressDialog.dismiss();

                                adapter.notifyDataSetChanged();
                                _searchButton.setEnabled(true);
                            }
                        }, 300);


            }
        });

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position,
                                    long id) {

                // item = ((TextView) view).getText().toString();

                //Toast.makeText(getBaseContext(), item, Toast.LENGTH_LONG).show();

                UserAccount selectedUser = userAccounts.get((int) id);

                Log.i("username view onitem", selectedUser.toString());

                String selectedUserId = selectedUser.getId();
                _userDetails[0] = "Username: " + selectedUser.getUsername();
                _userDetails[1] = "Date of Birth: " + selectedUser.getDateOfBirth();
                _userDetails[2] = "Email Address: " + selectedUser.getEmail();
                _userDetails[3] = "Residential Address: " + selectedUser.getResidentialAddress();
                _userDetails[4] = "Residential Address: " + selectedUser.getResidentialAddress();
                _userDetails[5] = "Residential Address: " + selectedUser.getResidentialAddress();
                _userDetails[6] = "Residential Address: " + selectedUser.getResidentialAddress();
                _userDetails[7] = "Residential Address: " + selectedUser.getResidentialAddress();
                _userDetails[8] = "Residential Address: " + selectedUser.getResidentialAddress();


                Log.i("username view onitem", _userDetails[0].toString());
                Log.i("username view onitem", _userDetails[1].toString());
                Log.i("username view onitem", _userDetails[2].toString());
                Log.i("username view onitem", _userDetails[3].toString());

                Intent in;
                in = new Intent(getApplicationContext(), UserAccountDetailActivity.class);
                in.putExtra(DeleteUserAccountByYMCAidActivity.USER_INFORMATION, _userDetails);
                in.putExtra("USER_ID", selectedUserId);
                startActivity(in);

            }
        });

    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i("deleteUserAccount view", "On Resume .....");
        _YMCAidField.getText().clear();
        list.clear();
        adapter.notifyDataSetChanged();
        Log.i("deleteUserAccount view", "cleared list and edittext fields");
    }


}
