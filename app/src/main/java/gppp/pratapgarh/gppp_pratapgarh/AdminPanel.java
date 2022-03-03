package gppp.pratapgarh.gppp_pratapgarh;

import android.os.Bundle;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.bumptech.glide.Glide;

public class AdminPanel extends AppCompatActivity {

    ImageView adminPanel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_panel);
        Toolbar adminToolbar=(Toolbar) findViewById(R.id.adminToolbar);

        setSupportActionBar(adminToolbar);

        getSupportActionBar().setTitle("");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        adminPanel=(ImageView) findViewById(R.id.adminPanel);
        iamge();
    }

    private void iamge() {
        Glide.with(this)
                .load("https://firebasestorage.googleapis.com/v0/b/gppp-pratapgarh.appspot.com/o/images%2FSectionUnderConstruction.png?alt=media&token=a0701999-570a-4c9d-ba74-2da827a21d66")
                .into(adminPanel);
    }
}