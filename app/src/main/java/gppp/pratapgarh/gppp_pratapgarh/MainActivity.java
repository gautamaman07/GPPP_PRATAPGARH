package gppp.pratapgarh.gppp_pratapgarh;


import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.animation.AnimationUtils;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import javax.swing.text.html.ImageView;


public class MainActivity extends AppCompatActivity implements  Animation.AnimationListener{

    ImageView imageView;
    Animation animation;
    private DatabaseReference reference;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();
        imageView= findViewById(R.id.iv_logo);

        reference= FirebaseDatabase.getInstance().getReference("GPPP PRATAPGARH");
        reference.keepSynced(true);
        animation= AnimationUtils.loadAnimation(this,R.anim.splashscreen);
        imageView.startAnimation(animation);
        Handler h=new Handler();
        h.postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent I=new Intent(MainActivity.this,Student_login.class);
                startActivity(I);
                overridePendingTransition(R.anim.slide_in_right,R.anim.stay);
                finish();


            }
        },4000);
    }



    @Override
    public void onAnimationStart(Animation animation) {

    }

    @Override
    public void onAnimationEnd(Animation animation) {

    }

    @Override
    public void onAnimationRepeat(Animation animation) {

    }
}
