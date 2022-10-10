package com.example.giuaki;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class ProfileActivity extends AppCompatActivity {
    private Button signOut;
    private TextView txtUsername;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.profile);

        txtUsername = (TextView) findViewById(R.id.username_textview);

        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            String username = extras.getString("username");
            txtUsername.setText(username);
            //The key argument here must match that used in the other activity
        }

        signOut = (Button) findViewById(R.id.sign_out_button);

        signOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder adb = new AlertDialog.Builder(view.getContext());
                adb.setTitle("Sign out");
                adb.setMessage("Do you want to sign out?");

                adb.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        // here you can add functions
                        Intent signInPage = new Intent(ProfileActivity.this, SignInActivity.class);
                        ProfileActivity.this.startActivity(signInPage);
                    }
                });
                adb.setNegativeButton("No", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        // here you can add functions
                    }
                });
                adb.show();  //<-- See This!

            }
        });
    }
}