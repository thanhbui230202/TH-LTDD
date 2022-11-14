package caidat.dmt.kt_1;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class Register extends AppCompatActivity {
TextView haveaccount;
EditText inputemail, inputpassword, inputconfirm;
Button btn_Register;
String emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";
ProgressDialog progressDialog;
FirebaseAuth mAuth;
FirebaseUser mUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        haveaccount = findViewById(R.id.AlreadyAccount);
        inputemail = findViewById(R.id.inputEmail);
        inputpassword = findViewById(R.id.inputPassword);
        inputconfirm = findViewById(R.id.inputConfirmPassword);
        btn_Register = findViewById(R.id.btn_Register);
        progressDialog = new ProgressDialog(this);
        mAuth = FirebaseAuth.getInstance();
        mUser = mAuth.getCurrentUser();


        haveaccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Register.this ,Login.class));
            }
        });


        btn_Register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                PerforAuth();
            }
        });
    }

    private void PerforAuth() {
        String email = inputemail.getText().toString();
        String password = inputpassword.getText().toString();
        String confirmPassword = inputconfirm.getText().toString();
        if(!email.matches(emailPattern)){
            inputemail.setError("Enter Connext Email");
        }
        else if(password.isEmpty() || password.length()<6){
            inputpassword.setError("Enter Proper Password");
        }else if(!password.equals(confirmPassword)){
            inputconfirm.setError("Password not match both field");
        }else{
            progressDialog.setMessage("Please wait Registration...");
            progressDialog.setTitle("Registration");
            progressDialog.setCanceledOnTouchOutside(false);
            progressDialog.show();

            mAuth.createUserWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    if(task.isSuccessful()){
                        progressDialog.dismiss();
                        sendUserToNextActivity();
                        Toast.makeText(Register.this,"Register Succesful",Toast.LENGTH_SHORT).show();
                    }
                    else {
                        progressDialog.dismiss();
                        Toast.makeText(Register.this,""+task.getException(),Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }
    }
    private void sendUserToNextActivity() {
        Intent intent = new Intent(Register.this,Home.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK|Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
    }
}