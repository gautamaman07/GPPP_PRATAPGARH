package gppp.pratapgarh.gppp_pratapgarh;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class Student_register extends AppCompatActivity {

    private EditText etEmail,etPassword,etConfirmPassword;
    private String email,password,confirmpassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_register);
        etEmail=findViewById(R.id.etEmail);
        etPassword=findViewById(R.id.etPassword);
        etConfirmPassword=findViewById(R.id.etConfirmPassword);
    }

    public void btnSignupClick(View view) {
        email =etEmail.getText().toString().trim();
        password= etPassword.getText().toString().trim();
        confirmpassword= etConfirmPassword.getText().toString().trim();

        if(email.equals(""))
        {

            etEmail.setError("Enter Email");
        }
        else if(etPassword.equals(""))
        {
            etPassword.setError("Enter Password");
        }
        else if(etConfirmPassword.equals(""))
        {
            etConfirmPassword.setError("Confirm Password");
        }
        else if(etConfirmPassword.equals(""))
        {
            etConfirmPassword.setError("Confirm Password Correctly Password");
        }
        else
        {
            FirebaseAuth mAuth= FirebaseAuth.getInstance();
            mAuth.createUserWithEmailAndPassword(email,password)
                    .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if(task.isSuccessful())
                            {
                                Toast.makeText(Student_register.this, "User Created Successfully", Toast.LENGTH_SHORT).show();
                                startActivity(new Intent(Student_register.this,MainActivity.class));
                                finish();
                            }
                            else
                            {
                                Toast.makeText(Student_register.this, "failed to create user"
                                                +task.getException()
                                        , Toast.LENGTH_SHORT).show();
                            }
                        }
                    });
        }
    }

    public void logInPage(View view) {
        startActivity(new Intent(this,Student_login.class));
        overridePendingTransition(R.anim.slide_in_left,android.R.anim.slide_out_right);
    }
}
