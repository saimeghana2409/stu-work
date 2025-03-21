package com.example.myapplication;

        import androidx.annotation.NonNull;
        import androidx.annotation.Nullable;
        import androidx.appcompat.app.ActionBarDrawerToggle;
        import androidx.appcompat.app.AppCompatActivity;
        import androidx.appcompat.widget.Toolbar;
        import androidx.constraintlayout.widget.ConstraintLayout;
        import androidx.drawerlayout.widget.DrawerLayout;

        import android.app.Activity;
        import android.content.Intent;
        import android.os.Bundle;
        import android.view.MenuItem;
        import android.view.View;
        import android.widget.Button;
        import android.widget.FrameLayout;

        import com.google.android.material.navigation.NavigationView;

public class MainActivity4 extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    DrawerLayout drawerLayout;
    ConstraintLayout home;
    public void setContentView(View view) {
        drawerLayout=findViewById(R.id.drawer);
        drawerLayout = (DrawerLayout) getLayoutInflater().inflate(R.layout.activity_main4, null);
        FrameLayout container= drawerLayout.findViewById(R.id.container);
        container.addView(view);
        super.setContentView(drawerLayout);

        Toolbar toolbar = drawerLayout.findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        NavigationView navigationView=drawerLayout.findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        ActionBarDrawerToggle toggle=new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.openmenu, R.string.closemenu);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();

    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        return false;
    }

    protected void allocatetitle(String titlestring) {
        if(getSupportActionBar()!=null) {
            getSupportActionBar().setTitle(titlestring);
        }
    }
}