package gppp.pratapgarh.gppp_pratapgarh;



import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;


public class Student_login extends AppCompatActivity {

    private EditText etEmail,etPassword;
    private String email,password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_login);
        etEmail=findViewById(R.id.etEmail);
        etPassword=findViewById(R.id.etPassword);
    }

    public void signup(View view) {
        startActivity(new Intent(this,Student_register.class));
        overridePendingTransition(R.anim.slide_in_right,R.anim.stay);
        finish();
    }
    private void redirect ()
    {
        startActivity(new Intent(this,Dashboard.class));
        finish();
    }
    public void btnLoginClick(View view) {
        email =etEmail.getText().toString().trim();
        password= etPassword.getText().toString().trim();


        if(email.equals(""))
        {

            etEmail.setError("Enter Email");
        }
        else if(etPassword.equals(""))
        {
            etPassword.setError("Enter Password");
        }
        else
        {
            FirebaseAuth mAuth= FirebaseAuth.getInstance();
            mAuth.signInWithEmailAndPassword(email,password)
                    .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if(task.isSuccessful())
                            {
                                redirect();
                            }
                            else
                            {

                                Toast.makeText( Student_login.this, "failed to log in"
                                                +task.getException()
                                        , Toast.LENGTH_SHORT).show();
                            }
                        }
                    });
        }
    }

    @Override
    protected void onStart() {
        super.onStart();

        FirebaseAuth mAuth= FirebaseAuth.getInstance();
        FirebaseUser mUser =mAuth.getCurrentUser();

        if(mUser!=null)
        {
            redirect();
        }
    }

    public void forgotpassword(View view) {

        email =etEmail.getText().toString().trim();


        if(email.equals(""))
        {

            etEmail.setError("Enter Email");
        }
        else
        {
            FirebaseAuth mAuth= FirebaseAuth.getInstance();
            mAuth.sendPasswordResetEmail(email)
                    .addOnCompleteListener(new OnCompleteListener<Void>() {
                        @Override
                        public void onComplete(@NonNull Task<Void> task) {
                            if(task.isSuccessful())
                            {
                                Toast.makeText(Student_login.this, "Sent email Successfully :" +email, Toast.LENGTH_SHORT).show();
                            }

                            else
                            {

                                Toast.makeText( Student_login.this, "failed to sent email"
                                                +task.getException()
                                        , Toast.LENGTH_SHORT).show();
                            }
                        }

                    });
        }



    }
}
