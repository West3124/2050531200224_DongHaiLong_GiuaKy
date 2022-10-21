package com.example.giuaki;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class ListViewActivity extends AppCompatActivity {
    private ListView listView;
    private String[] items = {"SCP-294", "SCP-999", "SCP-106", "SCP-173", "SCP-682"};
    private String[] classes = {"Euclid", "Safe", "Keter", "Euclid", "Keter"};
    private String[] shortDescription = {"a coffee vending machine that can dispense anything that does or can exist in liquid form—including, on occasion, abstract concepts. Regardless of the properties of the substance chosen, the machine's polystyrene cups appear to suffer no damage from the substances dispensed into them", "an orange, gelatinous being that possesses the ability to make those who touch its surface be filled with happiness", "an elderly humanoid, with a general appearance of advanced decomposition", "a humanoid statue composed of rebar, concrete and Krylon spray paint. It is immobile when directly observed, but it attacks people and breaks their neck when the line of sight with it is broken. It is extremely fast, to the point where it can move multiple meters while the observer is blinking", "a large, vaguely reptile-like creature of unknown origin"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.listview);

        Adapter itemsAdapter = new Adapter(this, items, classes, shortDescription);

        listView = (ListView) findViewById(R.id.list_view);
        listView.setAdapter(itemsAdapter);

        listView.setOnItemClickListener((adapterView, view, i, l) -> {
            Intent detail = new Intent(ListViewActivity.this, Detail.class);
            detail.putExtra("item", String.valueOf(itemsAdapter.getItem(i)));
            detail.putExtra("class", String.valueOf(itemsAdapter.getClass(i)));
            detail.putExtra("shortDescription", String.valueOf(itemsAdapter.getImage(i)));
            ListViewActivity.this.startActivity(detail);
        });

        listView.setOnItemLongClickListener((adapterView, view, i, l) -> {
            AlertDialog.Builder adb = new AlertDialog.Builder(adapterView.getContext());
            //adb.setView(Main.this);
            adb.setTitle("Bạn có chắc muốn xóa " + items[i] + "?");
            adb.setIcon(android.R.drawable.ic_dialog_alert);
            adb.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int which) {
                    itemsAdapter.removeItem(i);
                    listView.setAdapter(itemsAdapter);
                    Toast.makeText(getApplicationContext(), "Đã xóa thành công!", Toast.LENGTH_LONG).show();

                } });

            adb.setNegativeButton("No", (dialog, which) -> {
                //Toast.makeText(getApplicationContext(), "", Toast.LENGTH_LONG).show();
                //finish();
            });

            AlertDialog alertDialog = adb.create();
            alertDialog.show();
            return true;
        });

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