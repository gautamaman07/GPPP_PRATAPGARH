package gppp.pratapgarh.gppp_pratapgarh;


import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import com.google.android.material.navigation.NavigationView;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;


public class Dashboard extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    public static final String TAG = Dashboard.class.getSimpleName();
    DrawerLayout drawer;


    Toolbar toolbar;
    FirebaseAuth mAuth;
    FirebaseUser currentUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_dashboard);
        drawer = (DrawerLayout) findViewById(R.id.drawer);

        mAuth = FirebaseAuth.getInstance();
        currentUser = mAuth.getCurrentUser();
        //now call the fragment manager
        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new Dashboard_fragment_class()).commit();

        //make the dashboard menu clickable or checked
        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view_id);
        navigationView.setNavigationItemSelectedListener(this);
        updateNavHeader();
        //now make the dashboard listener or clickable


        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("GPPP_PRATAPGARH");
        navigationView.setCheckedItem(R.id.dashboard);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawer, toolbar, R.string.navigation_open, R.string.navigation_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();


    }


    @Override
    public void onBackPressed() {
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            //set the title
            builder.setTitle("confirm Exit");
            builder.setIcon(R.drawable.ic_power_settings_new_black_24dp);
            //set the messege
            builder.setMessage("Are you sure to exit");
            builder.setCancelable(false);
            //set footer
            builder.setPositiveButton("yes", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    finish();
                }
            });
            builder.setNegativeButton("no", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    Toast.makeText(Dashboard.this, "cancel", Toast.LENGTH_SHORT).show();

                }
            });
            // create a dialog
            AlertDialog dialog = builder.create();
            //show the dialog
            dialog.show();

        }
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        //add now switch case to perform intents
        switch (menuItem.getItemId()) {
            //in dashboard we have to load fregment
            case R.id.dashboard:
                //perform any task or toast or intent
                Toast.makeText(this, " Dashboard", Toast.LENGTH_SHORT).show();
                //now call the fragment manager
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new Dashboard_fragment_class()).commit();


                break;

            case R.id.profile:
                //perform any task or toast or intent
                Toast.makeText(this, "My Profile", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(Dashboard.this, UserProfile.class));
                break;

            case R.id.share:
                //perform any task or toast or intent
                Toast.makeText(this, "Share This", Toast.LENGTH_SHORT).show();

                Intent shareintent = new Intent(Intent.ACTION_SEND);

                //content ready for sending

                String content = "Hey I am using this new app of our college get it Downloded from link :";

                String link = "https://play.google.com/store/apps/details?id=gppp.pratapgarh.gppp_pratapgarh";
                content = content + link;
                shareintent.putExtra(Intent.EXTRA_TEXT, content);

                //set the  content mme type

                shareintent.setType("text/plain");
                // start the Activity

                startActivity(Intent.createChooser(shareintent, "Share Using"));

                break;
            case R.id.team:
                //perform any task or toast or intent
                Toast.makeText(Dashboard.this, "Developer", Toast.LENGTH_SHORT).show();
                Intent intent4 = new Intent(this, Developer_Team.class);
                startActivity(intent4);

                break;
            case R.id.rate:
                //perform any task or toast or intent
                try {
                    startActivity(new Intent(Intent.ACTION_VIEW,
                            Uri.parse("market://details?id=" + getPackageName())));
                } catch (ActivityNotFoundException e) {
                    startActivity(new Intent(Intent.ACTION_VIEW,
                            Uri.parse("https://play.google.com/store/apps/details?id" + getPackageName())));
                }
                break;
        }
        //now close the drawer menu
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    public void student(View view) {

        //student section

        Intent student = new Intent(this, student_info.class);
        startActivity(student);
        overridePendingTransition(R.anim.slide_in_left, R.anim.stay);


    }

    public void aboutus(View view) {

        //About us
        startActivity(new Intent(this, About_us.class));
        overridePendingTransition(R.anim.slide_in_left, R.anim.stay);


    }


    public void ourfaculty(View view) {
        Intent ourfaculty = new Intent(this, ourfaculty.class);
        startActivity(ourfaculty);
        overridePendingTransition(R.anim.slide_in_right, R.anim.stay);

    }

    public void otherinfo(View view) {
        Intent otherinfo = new Intent(this, otherinfo.class);
        startActivity(otherinfo);
        overridePendingTransition(R.anim.slide_in_right, R.anim.stay);

    }

    public void newsFeed(View view) {

        startActivity(new Intent(this, NewsFeed.class));
        overridePendingTransition(R.anim.slide_in_right, R.anim.stay);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.example_menu, menu);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {


        if ((item.getItemId()) == R.id.log_out) {
            user_logout();
        }
        return true;
    }

    private void user_logout() {
        FirebaseAuth.getInstance().signOut();
        startActivity(new Intent(Dashboard.this, Student_login.class));
        finish();

    }


    public void updateNavHeader() {
        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view_id);
        View headerView = navigationView.getHeaderView(0);
        TextView userName = headerView.findViewById(R.id.userName);
        CircleImageView userProfile = headerView.findViewById(R.id.userprofile);
        TextView userMail = headerView.findViewById(R.id.userMail);
        userMail.setText(currentUser.getEmail());
        userName.setText(currentUser.getDisplayName());

        Glide.with(this).load(currentUser.getPhotoUrl()).into(userProfile);
    }


    public void gallery(View view) {


        startActivity(new Intent(this, NewGallery.class));

        overridePendingTransition(R.anim.slide_in_left, R.anim.stay);
    }


}
