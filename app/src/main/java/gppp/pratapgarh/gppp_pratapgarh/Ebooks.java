package gppp.pratapgarh.gppp_pratapgarh;

import android.os.Bundle;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.bumptech.glide.Glide;

public class Ebooks extends AppCompatActivity {
ImageView eBooks;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ebooks);

        Toolbar EbooksToolbar=(Toolbar) findViewById(R.id.EbooksToolbar);

        setSupportActionBar(EbooksToolbar);

        getSupportActionBar().setTitle("");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        eBooks=(ImageView) findViewById(R.id.eBooks);
        iamge();
    }

    private void iamge() {
        Glide.with(this)
                .load("https://firebasestorage.googleapis.com/v0/b/gppp-pratapgarh.appspot.com/o/images%2FSectionUnderConstruction.png?alt=media&token=a0701999-570a-4c9d-ba74-2da827a21d66")
                .into(eBooks);
    }
}