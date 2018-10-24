package com.esraa.hp.fragmentpro2;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
Button addA,removeA,replaceA;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        addA=findViewById(R.id.showFragmentA);
        removeA=findViewById(R.id.removeFragmentA);
        replaceA=findViewById(R.id.replaceFragmentA);


        addA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentA fragmentA=new FragmentA();
                FragmentManager manager=getSupportFragmentManager();
                FragmentTransaction transaction=manager.beginTransaction();
                transaction.add(R.id.linearlayout,fragmentA,"A");
                transaction.commit();
            }
        });
        removeA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentManager manager=getSupportFragmentManager();
                FragmentTransaction transaction=manager.beginTransaction();
                FragmentA fA= (FragmentA) manager.findFragmentByTag("A");
                if(fA!=null) {
                    transaction.remove(fA);
                    transaction.commit();
                }
                else{
                    Toast.makeText(MainActivity.this,"Add Fragment First",Toast.LENGTH_SHORT).show();
                }
            }
        });

        replaceA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentB fragmentB=new FragmentB();
                FragmentManager manager=getSupportFragmentManager();
                FragmentTransaction transaction=manager.beginTransaction();
                FragmentA fA= (FragmentA) manager.findFragmentByTag("A");
                if(fA!=null) {
                    transaction.replace(R.id.linearlayout, fragmentB);
                    transaction.commit();
                }
                else{
                    Toast.makeText(MainActivity.this,"Add Fragment A First",Toast.LENGTH_SHORT).show();
                }

            }
        });




    }
}
