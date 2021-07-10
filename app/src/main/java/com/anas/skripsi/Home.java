package com.anas.skripsi;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.FrameLayout;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.internal.NavigationMenu;
import com.google.android.material.navigation.NavigationBarView;
import com.google.android.material.navigation.NavigationView;

public class Home extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        BottomNavigationView bottomNav = findViewById(R.id.bottom_navigation);
        bottomNav.setOnItemSelectedListener(navListener);

        getSupportFragmentManager().beginTransaction().replace(R.id.layouthomebt, new HomeFragment()).commit();

    }
public NavigationBarView.OnItemSelectedListener navListener = new BottomNavigationView.OnItemSelectedListener() {
    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        Fragment selectedFragment = null;
        switch (item.getItemId()){
            case R.id.home:
                selectedFragment = new HomeFragment();
                break;

            case R.id.person:
                selectedFragment = new AccountFragment();
                break;

            case R.id.settings:
                selectedFragment = new HelpFragment();
                break;

        }
        getSupportFragmentManager().beginTransaction().replace(R.id.layouthomebt, selectedFragment).commit();

        return true;
    }
};

}