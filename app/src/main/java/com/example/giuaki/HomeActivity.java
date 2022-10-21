package com.example.giuaki;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class HomeActivity extends AppCompatActivity {
    private LinearLayout profile;
    private LinearLayout listview;
    private TextView txtUsername;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home_page);

        txtUsername = findViewById(R.id.txtUsername);

        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            String username = extras.getString("username");
            txtUsername.setText(username);
            //The key argument here must match that used in the other activity
        }

        profile = findViewById(R.id.profile_button);

        profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent profile = new Intent(HomeActivity.this, ProfileActivity.class);
                profile.putExtra("username", txtUsername.getText().toString());
                HomeActivity.this.startActivity(profile);
            }
        });

        listview = findViewById(R.id.list_view_button);

        listview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent listview = new Intent(HomeActivity.this, ListViewActivity.class);
                HomeActivity.this.startActivity(listview);
            }
        });

        BottomNavigationView navigationView;
        navigationView = findViewById(R.id.bottom_nav);
        navigationView.setSelectedItemId(R.id.home);
        navigationView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.home:
                        Log.i("matching","matching inside "+R.id.home);
                        Intent home=new Intent(getBaseContext(),HomeActivity.class);
                        startActivity(home);
                        break;

                    case R.id.profile:
                        Log.i("matching","matching inside "+R.id.profile);
                        Intent profile=new Intent(getBaseContext(),ProfileActivity.class);
                        startActivity(profile);
                        break;

                    case R.id.list:
                        Log.i("matching","matching inside "+R.id.list);
                        Intent listview=new Intent(getBaseContext(),ListViewActivity.class);
                        startActivity(listview);
                        break;
                }
                return true;
            }

        });

    }
}