package org.itniorwings.aivita.Accounts;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ActionMenuView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.googlecode.mp4parser.authoring.Edit;

import org.itniorwings.aivita.R;

import okhttp3.MultipartBody;

public class SignUp extends AppCompatActivity {
   private EditText username,email,phone,password;
   private TextView tv_uploadtext;
   Button Register;
   ImageView upload;
   MultipartBody.Builder builder = new MultipartBody.Builder().setType(MultipartBody.FORM);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        TextView relogin=findViewById(R.id.tv_loginagain);
        relogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(SignUp.this,Login_A.class));
            }
        });

        username=findViewById(R.id.simpleEditText);
        email=findViewById(R.id.edtemail);
        phone=findViewById(R.id.edtphone);
        password=findViewById(R.id.password);
        tv_uploadtext=findViewById(R.id.password);
        Register=findViewById(R.id.signup_btn);
        upload=findViewById(R.id.iv_upload);

        Register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });





    }
}
