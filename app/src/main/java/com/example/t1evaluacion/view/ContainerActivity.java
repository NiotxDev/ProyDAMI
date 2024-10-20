package com.example.t1evaluacion.view;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.FragmentTransaction;

import com.example.t1evaluacion.R;
import com.example.t1evaluacion.view.fragments.HomeFragment;
import com.example.t1evaluacion.view.fragments.ProfileFragment;
import com.example.t1evaluacion.view.fragments.SearchFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;


public class ContainerActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_container);


        BottomNavigationView bottombar = findViewById(R.id.bottombar);

        bottombar.getMenu().getItem(0).setChecked(true);

        if (bottombar.getMenu().getItem(0).isChecked()) {

            HomeFragment homeFragment = new HomeFragment();
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.container, homeFragment)
                    .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE)
                    .addToBackStack(null).commit();

        }


        bottombar.setOnItemSelectedListener(item -> {

            switch (item.getItemId()) {
                case R.id.tab_home:
                    HomeFragment homeFragment = new HomeFragment();
                    getSupportFragmentManager().beginTransaction()
                            .replace(R.id.container, homeFragment)
                            .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE)
                            .addToBackStack(null).commit();
                    break;
                case R.id.tab_profile:
                    ProfileFragment profileFragment = new ProfileFragment();
                    getSupportFragmentManager().beginTransaction()
                            .replace(R.id.container, profileFragment)
                            .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE)
                            .addToBackStack(null).commit();
                    break;
                case R.id.tab_search:
                    SearchFragment searchFragment = new SearchFragment();
                    getSupportFragmentManager().beginTransaction()
                            .replace(R.id.container, searchFragment)
                            .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE)
                            .addToBackStack(null).commit();
                    break;

            }
            return true;

        });

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}