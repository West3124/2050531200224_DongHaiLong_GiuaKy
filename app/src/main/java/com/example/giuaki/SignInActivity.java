package com.example.giuaki;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class SignInActivity extends AppCompatActivity {
    private Button signIn;
    private TextView signUp;
    private EditText edtUsername;
    private EditText edtPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sign_in_activity);

        edtUsername = (EditText) findViewById(R.id.txt_username);
        edtPassword = (EditText) findViewById(R.id.txt_password);
        signIn = (Button) findViewById(R.id.sign_in_button);

        signIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String username = edtUsername.getText().toString().trim();
                String password = edtPassword.getText().toString().trim();

                if (username.equals("hailong") && password.equals("1234")){
                    Toast.makeText(SignInActivity.this,"Đăng nhập thành công", Toast.LENGTH_SHORT).show();
                    Intent listview = new Intent(SignInActivity.this, ListViewActivity.class);
                    listview.putExtra("username", username.toString());
                    SignInActivity.this.startActivity(listview);
                } else {
                    Toast.makeText(SignInActivity.this,"Lỗi đăng nhập!", Toast.LENGTH_SHORT).show();
                }
            }
        });

        signUp = (TextView) findViewById(R.id.sign_up_link);

        signUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                    Intent signUpPage = new Intent(SignInActivity.this, SignUpActivity.class);
                    SignInActivity.this.startActivity(signUpPage);
            }
        });
    }
}