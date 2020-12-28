package com.example.test1;

import android.os.Bundle;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.sun.jna.Library;
import com.sun.jna.Native;
import com.sun.jna.Platform;



public class MainActivity extends AppCompatActivity {

//    public interface CLibrary extends Library {
//        // libc.so ===> "c"
//        CLibrary INSTANCE = (CLibrary)
//                Native.loadLibrary((Platform.isWindows() ? "msvcrt" : "c"),
//                        CLibrary.class);
//
//        void printf(String format, Object... args);
//    }

    public interface HelloLib extends Library {
        HelloLib INSTANCE = (HelloLib)Native.loadLibrary("hello", HelloLib.class);

        void dump();
        int add();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        BottomNavigationView navView = findViewById(R.id.nav_view);
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        AppBarConfiguration appBarConfiguration = new AppBarConfiguration.Builder(
                R.id.navigation_home, R.id.navigation_dashboard, R.id.navigation_notifications)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);
        NavigationUI.setupWithNavController(navView, navController);
        // CLibrary.INSTANCE.printf("Hello, World###################################@@@@@@@@@@@@@@@@@@@@\n");
        HelloLib.INSTANCE.dump();
        int i = HelloLib.INSTANCE.add();
        System.out.println("hello: " + i + " \n");
        System.out.println("hello: " + i + " \n");
    }

}
