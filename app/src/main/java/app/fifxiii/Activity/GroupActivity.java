package app.fifxiii.Activity;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import app.fifxiii.ListGroup.ItemRowGroup;
import app.fifxiii.R;
import app.fifxiii.mFireData;

public class GroupActivity extends AppCompatActivity {

    Intent intent;
    String group;
    Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_group);

        intent = getIntent();
        Bundle bundle = intent.getExtras();
        group = bundle.getString("Extra");

        context = getBaseContext();

        setContent();
    }

    private void setContent() {
        FirebaseDatabase database = mFireData.getDatabase();

        if (database != null) {
            DatabaseReference myRef = database.getReference("grupos/");
            myRef.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot snapshot) {

                    TextView name = (TextView) findViewById(R.id.nameGroup);
                    name.setText((String) snapshot.child(group + "/name").getValue());

                    TextView country = (TextView) findViewById(R.id.countryGroup);
                    country.setText((String) snapshot.child(group + "/country").getValue());

                    TextView desc = (TextView) findViewById(R.id.descGroup);
                    desc.setText((String) snapshot.child(group + "/description").getValue());

                    Picasso.with(context)
                            .load((String) snapshot.child(group + "/flag").getValue())
                            .fit().centerInside()
                            .into((ImageView) findViewById(R.id.flagGroup));

                    Picasso.with(context)
                            .load((String) snapshot.child(group + "/photo0").getValue())
                            .fit().centerCrop()
                            .into((ImageView) findViewById(R.id.imageMainGroup));
                }

                @Override
                public void onCancelled(DatabaseError firebaseError) {
                }
            });
        }
    }
}
