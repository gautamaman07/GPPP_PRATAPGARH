package gppp.pratapgarh.gppp_pratapgarh;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;

import de.hdodenhof.circleimageview.CircleImageView;

public class civil_faculty extends AppCompatActivity {

CircleImageView Pranjul,kulrishi,lalgsirPic;
  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_civil_faculty);
    lalgsirPic=findViewById(R.id.lalgsirPic);
    kulrishi=findViewById(R.id.kulrishi);
    Pranjul=(CircleImageView) findViewById(R.id.Pranjul);
    lalgsirPic();
  }

  private void lalgsirPic() {
    Glide.with(this)
            .load("https://firebasestorage.googleapis.com/v0/b/gppp-pratapgarh.appspot.com/o/images%2Fdownload.png?alt=media&token=6f2f1d67-f19e-418a-bc18-16de33720a08")
            .placeholder(R.drawable.error)
            .error(R.drawable.error)
            .into(lalgsirPic);
    Glide.with(this)
            .load("https://firebasestorage.googleapis.com/v0/b/gppp-pratapgarh.appspot.com/o/kulrishi.jpg?alt=media&token=93b7eb02-f92b-4e87-b64e-b249a22f7526")
            .placeholder(R.drawable.error)
            .error(R.drawable.error)
            .into(kulrishi);
    Glide.with(this)
            .load("https://firebasestorage.googleapis.com/v0/b/gppp-pratapgarh.appspot.com/o/pranjal.jpg?alt=media&token=c0d3e71d-d818-4049-a539-8a98e0cb35a5")
            .placeholder(R.drawable.error)
            .error(R.drawable.error)
            .into(Pranjul);
  }
}
