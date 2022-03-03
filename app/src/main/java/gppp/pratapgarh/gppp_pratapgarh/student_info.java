package gppp.pratapgarh.gppp_pratapgarh;



import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class student_info extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState) ;
        setContentView(R.layout.activity_student_info);
        Toolbar toolbar4=findViewById(R.id.toolbar4);
        setSupportActionBar(toolbar4);

        getSupportActionBar().setTitle("");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);





    }

    public void books(View view) {
   Intent eBook=new Intent(student_info.this,Ebooks.class);
   startActivity(eBook);
    }

    public void studentDetail(View view) {
        startActivity(new Intent(this,StudentDetail.class));
    }
}
