package gppp.pratapgarh.gppp_pratapgarh;

import android.app.AlertDialog;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.appbar.CollapsingToolbarLayout;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.squareup.picasso.Picasso;
import com.squareup.picasso.Target;

import java.util.UUID;

import gppp.pratapgarh.gppp_pratapgarh.Helper.SaveImageHelper;
import gppp.pratapgarh.gppp_pratapgarh.Utils.Utils;

public class ViewWallpaper extends AppCompatActivity {

    CollapsingToolbarLayout collapsingToolbarLayout;
    FloatingActionButton floatingDownload,flotingWallpaper;
    ImageView iV;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_wallpaper);

        final Target target=new Target() {
            @Override
            public void onBitmapLoaded(Bitmap bitmap, Picasso.LoadedFrom from) {

            }

            @Override
            public void onBitmapFailed(Exception e, Drawable errorDrawable) {

            }

            @Override
            public void onPrepareLoad(Drawable placeHolderDrawable) {

            }
        }  ;
        initilization();
        Picasso.get().load(Utils.selected_wallpaper.getImageLink()).into(iV);
        flotingWallpaper.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Picasso.get().load(Utils.selected_wallpaper.getImageLink()).into(target);
            }
        });
        floatingDownload.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String fileName= UUID.randomUUID().toString() + ".png";
                AlertDialog.Builder b=new AlertDialog.Builder(ViewWallpaper.this);
                b.setMessage("Downloading.....");
                AlertDialog alertDialog=b.create();
                alertDialog.show();
                Picasso.get().load(Utils.selected_wallpaper.getImageLink()).into(new SaveImageHelper(getBaseContext(),alertDialog,getApplicationContext().getContentResolver(),fileName,"Mini Wallpaper"));
            }
        });
    }

    private void initilization() {
        iV=findViewById(R.id.thumbImage);
        collapsingToolbarLayout=(CollapsingToolbarLayout)findViewById(R.id.collapsingToolbarLayout);
        floatingDownload=(FloatingActionButton) findViewById(R.id.fab_download);
        flotingWallpaper=(FloatingActionButton)findViewById(R.id.fab_wallpaper);

        collapsingToolbarLayout.setTitle(Utils.CATEGORY_SELECTED);

    }
}