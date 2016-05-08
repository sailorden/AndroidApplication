package hk.ust.cse.com4521.escort_app;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class EscortDialectAvailibityAcitivity extends AppCompatActivity {
    private ListView mListDialect = null;
    private String[] mDialect = null;
    private String[] mAvailabilities = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_escort_dialect_availibity_acitivity);

        //List of dialects
        mListDialect = (ListView) findViewById(R.id.listDialect);
        mDialect= new String[]{"Dialect1", "Dialect2", "Dialect3", "Dialect4"};
        mListDialect.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_multiple_choice, mDialect));

        //list of availibities



        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

}
