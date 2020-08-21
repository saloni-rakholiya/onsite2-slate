package com.example.onsite2;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.Vector;

public class MainActivity extends AppCompatActivity implements frag1.frag1listener,frag2.for2fraglistener {


    private frag1 fragment1;
    private frag2 fragment2;
    Button btn,yellow,green;
    int j=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn=findViewById(R.id.btn);



        fragment1=new frag1();
        fragment2=new frag2();

        /*yellow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                j=1;
                fragment1.toyellow();
            }
        });

        green.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                j=2;
                fragment1.togreen();
            }
        });*/

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                fragment2.reset();
                fragment1.reset();
            }
        });

        getSupportFragmentManager().beginTransaction().replace(R.id.f1,fragment1).replace(R.id.f2,fragment2).commit();



    }

    @Override
    public void whensent(Path path,int uni) {

        fragment2.update(path,uni);
       // fragment2.update(path,uni);
    }

    @Override
    public void for2whensent(Path path,int uni)
    {

        fragment1.update(path,uni);
    }


}
