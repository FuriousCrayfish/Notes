package com.example.notes;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.FragmentTransaction;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;
import android.widget.Toolbar;

import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(checkOrientation());
        setContentView(R.layout.activity_main);
        initDrawer();

        //создаем фрагмент
        getSupportFragmentManager()
                .beginTransaction()
                .add(R.id.fragment_container, new NoteStructureFragment()).commit();

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.menu, menu);
        return super.onCreateOptionsMenu(menu);

    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        int id = item.getItemId();
        switch (id) {

            case R.id.action_about:
                getSupportFragmentManager()
                        .beginTransaction()
                        .addToBackStack("")
                        .add(R.id.fragment_container, new AboutFragment()).commit();
                return true;
            case R.id.action_exit:

                new AlertDialog.Builder(MainActivity.this)
                        .setTitle("Attention!")
                        .setMessage("Do you want to close the app?")
                        .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialogInterface, int i) {
                                        finish();
                                    }
                                }
                        )
                        .setNegativeButton("No", null)
                        .show();

                return true;

            case R.id.action_search:
                getSupportFragmentManager()
                        .beginTransaction()
                        .addToBackStack("")
                        .add(R.id.fragment_container, new SearchFragment()).commit();
                return true;

        }

        return super.onOptionsItemSelected(item);

    }

    private void initDrawer() {

        final DrawerLayout drawer = findViewById(R.id.drawer_layout);

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer,
                R.string.navigation_draver_open,
                R.string.navigation_draver_close);

        drawer.addDrawerListener(toggle);
        toggle.syncState();
        toggle.getDrawerArrowDrawable().setColor(getResources().getColor(R.color.white));

        NavigationView navigationView = findViewById(R.id.navigation_view);
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int id = item.getItemId();
                switch (id) {

                    case R.id.action_drawer_about:
                        openAboutFragment();
                        drawer.close();
                        return true;

                    case R.id.action_drawer_exit:

                        new AlertDialog.Builder(MainActivity.this)
                                .setTitle("Attention!")
                                .setMessage("Do you want to close the app?")
                                .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                                            @Override
                                            public void onClick(DialogInterface dialogInterface, int i) {
                                                finish();
                                            }
                                        }
                                )
                                .setNegativeButton("No", null)
                                .show();

                        //finish();
                        return true;

                    case R.id.action_drawer_search:
                        openSearchFragment();
                        drawer.close();
                        return true;

                }
                return false;
            }
        });

    }

    private void openAboutFragment() {
        getSupportFragmentManager()
                .beginTransaction()
                .addToBackStack("")
                .add(R.id.fragment_container, new AboutFragment()).commit();
    }

    private void openSearchFragment() {

        getSupportFragmentManager()
                .beginTransaction()
                .addToBackStack("")
                .add(R.id.fragment_container, new SearchFragment()).commit();

    }

    private int checkOrientation() {

        if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE) {

            return R.layout.land_activity_main;

        } else {
            return R.layout.activity_main;
        }

    }
}