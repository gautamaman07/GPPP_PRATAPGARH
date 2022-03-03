package gppp.pratapgarh.gppp_pratapgarh;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.blogspot.atifsoftwares.animatoolib.Animatoo;
import com.bumptech.glide.Glide;



public class ourfaculty extends AppCompatActivity {


    ImageView computerscience, civil, electrical;
    Toolbar toolbar;

    @Override


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ourfaculty);
        computerscience = findViewById(R.id.computerscience);
        civil = findViewById(R.id.civil);
        electrical = findViewById(R.id.electrical);
        toolbar = (Toolbar) findViewById(R.id.toolbar2);
        setSupportActionBar(toolbar);

        getSupportActionBar().setTitle("");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        loadImage();
    }

    private void loadImage() {

        Glide.with(this)
                .load("https://firebasestorage.googleapis.com/v0/b/gppp-pratapgarh.appspot.com/o/computer4.png?alt=media&token=127ef522-a3af-40f9-8cf5-4928d1d2da79")
                .error(R.drawable.error)
                .placeholder(R.drawable.error)
                .into(computerscience);


        Glide.with(this)
                .load("https://firebasestorage.googleapis.com/v0/b/gppp-pratapgarh.appspot.com/o/civil3.png?alt=media&token=8a11a7c7-944b-42d1-a338-f313cf3329e2")
                .error(R.drawable.error)
                .placeholder(R.drawable.error)
                .into(civil);

        Glide.with(this)
                .load("https://firebasestorage.googleapis.com/v0/b/gppp-pratapgarh.appspot.com/o/elec.png?alt=media&token=eb682d62-7315-460e-9cdd-240b8d259074")
                .error(R.drawable.error)
                .placeholder(R.drawable.error)
                .into(electrical);

    }


    public void computerscience(View view) {
        if (view == findViewById(R.id.splitc)) {
            startActivity(new Intent(this, computer_science_faculty.class));
            Animatoo.animateSplit(this);
        }
    }

    public void civil(View view) {

        Intent civil = new Intent(this, civil_faculty.class);
        startActivity(civil);
        if (view == findViewById(R.id.splitci)) {
            startActivity(new Intent(this, civil_faculty.class));
            Animatoo.animateSplit(this);
        }
    }

    public void electrical(View view) {

        if (view == findViewById(R.id.splite)) {
            startActivity(new Intent(this, electrical_faculty.class));
            Animatoo.animateSplit(this);
        }
    }
}
