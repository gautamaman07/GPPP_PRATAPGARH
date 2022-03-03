package gppp.pratapgarh.gppp_pratapgarh;


import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;

import de.hdodenhof.circleimageview.CircleImageView;

public class electrical_faculty extends AppCompatActivity {
    CircleImageView principal,pavandubey,pankajbharti,divyaprakash;

    @Override
    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_electrical_faculty);
        principal=findViewById(R.id.principalPic);
        divyaprakash=findViewById(R.id.divyaprakash);
        pavandubey=findViewById(R.id.pavandubey);
        pankajbharti=findViewById(R.id.pankajbharti);

     loadimage();
    }

    private void loadimage() {
        Glide.with(this)
                .load("https://firebasestorage.googleapis.com/v0/b/gppp-pratapgarh.appspot.com/o/principal.png?alt=media&token=37e1d522-4da4-4d51-9008-690fe7cf1a50")

                .placeholder(R.drawable.error)
                .error(R.drawable.error)
                .into(principal);
        Glide.with(this)
                .load("https://firebasestorage.googleapis.com/v0/b/gppp-pratapgarh.appspot.com/o/pankaj.jpg?alt=media&token=affab636-ddd4-4e00-a60c-cc5529607477")
                .placeholder(R.drawable.error)
                .error(R.drawable.error)
                .into(pankajbharti);
        Glide.with(this)
                .load("https://firebasestorage.googleapis.com/v0/b/gppp-pratapgarh.appspot.com/o/pavan.jpg?alt=media&token=b4685ff8-6c16-413d-acf0-8df89258c665")
                .placeholder(R.drawable.error)
                .error(R.drawable.error)
                .into(pavandubey);
        Glide.with(this)
                .load("https://firebasestorage.googleapis.com/v0/b/gppp-pratapgarh.appspot.com/o/images%2Fdownload.png?alt=media&token=6f2f1d67-f19e-418a-bc18-16de33720a08")
                .placeholder(R.drawable.error)
                .error(R.drawable.error)
                .into(divyaprakash);
    }

}
