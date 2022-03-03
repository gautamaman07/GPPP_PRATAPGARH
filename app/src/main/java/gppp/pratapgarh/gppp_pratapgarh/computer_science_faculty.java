package gppp.pratapgarh.gppp_pratapgarh;

import android.os.Bundle;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;

public class computer_science_faculty extends AppCompatActivity {
    ImageView abhisheksir, rajasir, jagnarayansir, dilipsir, chandansir;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_computer_science_faculty);
        abhisheksir = findViewById(R.id.abhishek);
        rajasir = findViewById(R.id.raja);
        jagnarayansir = findViewById(R.id.jagnarayan);
        dilipsir = findViewById(R.id.dilipsir);
        chandansir = findViewById(R.id.chandansir);
        loadImage();
    }

    private void loadImage() {
        Glide.with(this)

                .load("https://firebasestorage.googleapis.com/v0/b/gppp-pratapgarh.appspot.com/o/raja.png?alt=media&token=37b88445-8dc3-436f-b678-4f69c577ab52")
                .placeholder(R.drawable.error)
                .error(R.drawable.error)
                .into(rajasir);

        Glide.with(this)
                .load("https://firebasestorage.googleapis.com/v0/b/gppp-pratapgarh.appspot.com/o/abhishek.png?alt=media&token=6bc0846b-1807-429d-a69f-266397f85da0")
                .placeholder(R.drawable.error)
                .error(R.drawable.error)
                .into(abhisheksir);

        Glide.with(this)

                .load("https://firebasestorage.googleapis.com/v0/b/gppp-pratapgarh.appspot.com/o/jagnarayan.png?alt=media&token=52e3a91f-ea50-41d4-a790-cd3d7a9d87d8")
                .placeholder(R.drawable.error)
                .error(R.drawable.error)
                .into(jagnarayansir);
        Glide.with(this)
                .load("https://firebasestorage.googleapis.com/v0/b/gppp-pratapgarh.appspot.com/o/images%2Fdownload.png?alt=media&token=6f2f1d67-f19e-418a-bc18-16de33720a08")
                .placeholder(R.drawable.error)
                .error(R.drawable.error)
                .into(dilipsir);
        Glide.with(this)
                .load("https://firebasestorage.googleapis.com/v0/b/gppp-pratapgarh.appspot.com/o/images%2Fdownload.png?alt=media&token=6f2f1d67-f19e-418a-bc18-16de33720a08")
                .placeholder(R.drawable.error)
                .error(R.drawable.error)
                .into(chandansir);
    }
}
