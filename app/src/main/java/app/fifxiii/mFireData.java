package app.fifxiii;

import com.google.firebase.database.FirebaseDatabase;

public class mFireData {

    private static FirebaseDatabase mDatabase;

    public mFireData(){}

    public static FirebaseDatabase getDatabase() {
        if (mDatabase == null) {
            mDatabase = FirebaseDatabase.getInstance();
            mDatabase.setPersistenceEnabled(true);
        }

        return mDatabase;
    }
}
