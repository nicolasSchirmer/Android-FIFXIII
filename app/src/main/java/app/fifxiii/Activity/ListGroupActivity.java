package app.fifxiii.Activity;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

import app.fifxiii.Menu;
import app.fifxiii.R;
import app.fifxiii.mFireData;

public class ListGroupActivity extends AppCompatActivity {

    Menu menu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_group);
        menu = new Menu(this);

        //firebase();
    }
/**
    private void firebase(){
        FirebaseDatabase database = mFireData.getDatabase();
        if(database != null) {
            DatabaseReference myRef = database.getReference("grupos");

            //final TextView textView = (TextView) findViewById(R.id.textFire);

            myRef.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {
                    // This method is called once with the initial value and again
                    // whenever data at this location is updated.
                    //String value = dataSnapshot.getValue(String.class);
                    //textView.setText(value);

                    ArrayList<String> mList = new ArrayList<>();
                    for(DataSnapshot dsp : dataSnapshot.getChildren()){
                        mList.add(String.valueOf(dsp.getKey())); //add result into array list
                    }

                    ListView listView = (ListView) findViewById(R.id.listView);
                    listView.setAdapter(new ArrayAdapter<String>(ListGroupActivity.this,
                            android.R.layout.simple_list_item_1, mList));

                }

                @Override
                public void onCancelled(DatabaseError error) {
                    // Failed to read value
                }
            });
        }
    }
 **/

    public void hmbClick(View view){
        menu.showMenu();
    }

    public void homeClick(View view){
        prepareChangeActivity(MainActivity.class);
    }

    public void scheduleClick(View view){
        prepareChangeActivity(ScheduleActivity.class);
    }

    /** chance close for each activity **/
    public void groupClick(View view){
        menu.close();
    }

    public void infoClick(View view){
        prepareChangeActivity(InfoActivity.class);
    }

    public void aofClick(View view){
        prepareChangeActivity(AofActivity.class);
    }

    public void devClick(View view){
        prepareChangeActivity(DevActivity.class);
    }

    private void prepareChangeActivity(final Class mClass){
        menu.close();

        new Handler().postDelayed(new Runnable() {
            public void run() {
                changeActivity(mClass);
            }
        }, 350);
    }

    public void changeActivity(Class mClass) {
        startActivity(new Intent(this, mClass));
        onPause();
    }

    @Override
    public void onBackPressed(){
        if(menu.isOpen()) menu.close();

        new Handler().postDelayed(new Runnable() {
            public void run() {
                finish();
            }
        }, 350);
    }
}
