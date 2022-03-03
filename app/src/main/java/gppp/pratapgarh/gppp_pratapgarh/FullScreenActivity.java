package gppp.pratapgarh.gppp_pratapgarh;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class FullScreenActivity extends AppCompatActivity {
    ImageView mImageVie;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_full_screen);



        byte[] bytes=getIntent().getByteArrayExtra("image");

        Bitmap bmc= BitmapFactory.decodeByteArray(bytes,0,bytes.length);

        mImageVie.setImageBitmap(bmc);
    }

        @Override
        public boolean onSupportNavigateUp() {
            onBackPressed();
            return true;
        }
}