package gppp.pratapgarh.gppp_pratapgarh;

import android.os.Bundle;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.bumptech.glide.Glide;

public class About_us extends AppCompatActivity {
ImageView principalPic;
  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_about_us);
    Toolbar toolbar3=(Toolbar) findViewById(R.id.toolbar3);

    setSupportActionBar(toolbar3);

    getSupportActionBar().setTitle("");
    getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    principalPic=findViewById(R.id.principalPic);
    loadPrincipalPic();
  }

  private void loadPrincipalPic() {
    Glide.with(this)
            .load("https://firebasestorage.googleapis.com/v0/b/gppp-pratapgarh.appspot.com/o/principal.png?alt=media&token=37e1d522-4da4-4d51-9008-690fe7cf1a50")
            .into(principalPic);
  }
}
