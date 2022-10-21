package com.example.giuaki;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class Detail extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.detail);

        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            String item = extras.getString("item");
            TextView tv_item = (TextView) findViewById(R.id.tv_name);
            String Sclass = extras.getString("class");
            TextView tv_class = (TextView) findViewById(R.id.tv_class);
            String shortDescription = extras.getString("shortDescription");
            TextView tv_description = (TextView) findViewById(R.id.tv_description);
            tv_item.setText(item);
            tv_class.setText("Class: " + Sclass);
            tv_description.setText("Description: " + shortDescription);
            //The key argument here must match that used in the other activity
        }

        BottomNavigationView navigationView;
        navigationView = findViewById(R.id.bottom_nav);
        navigationView.setSelectedItemId(R.id.list);
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
