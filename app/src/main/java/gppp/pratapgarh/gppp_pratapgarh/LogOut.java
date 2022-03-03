package gppp.pratapgarh.gppp_pratapgarh;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class LogOut extends AppCompatActivity {
    private FirebaseAuth mAuth;
    private FirebaseUser user;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_out);
        mAuth= FirebaseAuth.getInstance();
        user=mAuth.getCurrentUser();
    }

    public void btLogOut(View view) {
        mAuth.signOut();
        startActivity( new Intent(LogOut.this,Student_login.class));
        finishAffinity();
    }
}