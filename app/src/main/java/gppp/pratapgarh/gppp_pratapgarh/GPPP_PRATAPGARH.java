package gppp.pratapgarh.gppp_pratapgarh;

import android.app.Application;

import com.google.firebase.database.FirebaseDatabase;

public class GPPP_PRATAPGARH extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        FirebaseDatabase.getInstance().setPersistenceEnabled(true);
    }
}
