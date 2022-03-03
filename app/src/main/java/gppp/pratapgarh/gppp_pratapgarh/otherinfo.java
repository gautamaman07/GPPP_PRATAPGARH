package gppp.pratapgarh.gppp_pratapgarh;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.bumptech.glide.Glide;
import com.denzcoskun.imageslider.ImageSlider;
import com.denzcoskun.imageslider.models.SlideModel;

import java.util.ArrayList;
import java.util.List;

public class otherinfo  extends AppCompatActivity {
    ImageView mapPic;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_otherinfo);
        Toolbar toolbar2=findViewById(R.id.toolbar2);
        setSupportActionBar(toolbar2);

        getSupportActionBar().setTitle("");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        mapPic=findViewById(R.id.mapPic);
        loadPic();
        mapPic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goToUrl("https://maps.app.goo.gl/ZumK622P54JJSZC3A");
            }
        });
        ImageSlider imageSlider = findViewById(R.id.imageslider);
        List<SlideModel> slideModels = new ArrayList<>();

        slideModels.add(new SlideModel("https://firebasestorage.googleapis.com/v0/b/gppp-pratapgarh.appspot.com/o/images%2Fcollegecampus.jpg?alt=media&token=36fc88b2-8265-43da-b519-a34074d6542a","Campus"));
        slideModels.add(new SlideModel("https://firebasestorage.googleapis.com/v0/b/gppp-pratapgarh.appspot.com/o/gpp.png?alt=media&token=4b7043b5-f9ff-46f0-a81a-5949007bcade", "Our College"));
        slideModels.add(new SlideModel("https://firebasestorage.googleapis.com/v0/b/gppp-pratapgarh.appspot.com/o/computerlab.jpg?alt=media&token=467ca3cc-7218-433e-9ad1-71ae1a6b9c73","Computer Lab"));
        slideModels.add(new SlideModel("https://firebasestorage.googleapis.com/v0/b/gppp-pratapgarh.appspot.com/o/images%2Fbatch2017.jpg?alt=media&token=fda4966b-2404-4e16-950f-c47230908fc8","Batch 2017"));
        slideModels.add(new SlideModel("https://firebasestorage.googleapis.com/v0/b/gppp-pratapgarh.appspot.com/o/images%2Fbatch.jpg?alt=media&token=f3d9a8a6-f54a-4c5f-9f4b-6963baa1ca0b","BAtch 2017"));


        imageSlider.setImageList(slideModels, true);



    }

    private void goToUrl(String s) {
        Uri uri = Uri.parse(s);
        startActivity(new Intent(Intent.ACTION_VIEW, uri));
    }

    private void loadPic() {
        Glide.with(this)
                .load("https://firebasestorage.googleapis.com/v0/b/gppp-pratapgarh.appspot.com/o/map.jpeg?alt=media&token=a587f6dc-8ce9-4fb8-8d46-371b0274c860")
                .error(R.drawable.loading)
                .placeholder(R.drawable.loading)
                .into(mapPic);
    }


}
