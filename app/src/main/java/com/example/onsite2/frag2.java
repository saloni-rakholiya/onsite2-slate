package com.example.onsite2;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RelativeLayout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import java.util.Vector;

public class frag2 extends Fragment {

    int universal2=0;
    //here
    private for2fraglistener for2listener;

    public interface for2fraglistener{
        void for2whensent(Path path,int uni);
    }

//here

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        if(context instanceof for2fraglistener)
        { for2listener=(for2fraglistener) context;}
        else{
            throw new RuntimeException(context.toString()+"must implement listener");
        }

    }

    @Override
    public void onDetach() {
        super.onDetach();
        for2listener=null;
    }



    //here

    //tohere


    Path newpath=new Path();
    Path newpath2=new Path();
    Path newpath3=new Path();
    Path for1=new Path();
    Path for2=new Path();
    Path for3=new Path();


    Path newpath1=new Path();
    draw d;
    int k=0;

    int universal=0;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v=inflater.inflate(R.layout.fragment2,container,false);
        RelativeLayout r=v.findViewById(R.id.rect2);
        //final
        Button y=v.findViewById(R.id.y);
        Button e=v.findViewById(R.id.eraser);
        e.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                universal=3;
            }
        });
        Button g=v.findViewById(R.id.g);
        g.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                universal=1;
            }
        });
        y.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                universal=2;
            }
        });
        //final
        d=new draw(getActivity());
        r.addView(d);
        return v;
    }

    public void reset()
    {
        k=3;
        d.invalidate();
    }

    public void update(Path path,int uni) {


        universal2=uni;
        if(uni==3)
            newpath3=path;
        if(uni==0)
        newpath=path;
        if(uni==1)
            newpath1=path;
        if(uni==2) newpath2=path;
        k=1;
        d.invalidate();
       // View drawing=new draw(getActivity());
        //drawing.invalidate();



        //toupdate
    }

    public class draw extends View
    {

        private Path for2path;


        public draw(Context context) {
            super(context);
            init(null);
        }

        public draw(Context context, @Nullable AttributeSet attrs) {
            super(context, attrs);
            init(attrs);
        }

        public draw(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
            super(context, attrs, defStyleAttr);
            init(attrs);
        }

        public draw(Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
            super(context, attrs, defStyleAttr, defStyleRes);
            init(attrs);
        }

        private void init(AttributeSet attrs) {
            for2path=new Path();
            //opop

           /* paintfor1=new Paint();
            pathfor1=new Path();
            paintfor1.setColor(Color.BLACK);
            paintfor2=new Paint();
            pathfor2=new Path();
            paintfor2.setColor(Color.WHITE);*/
            //opop


        }


        @Override
        protected void onDraw(Canvas canvas) {

            super.onDraw(canvas);




            Paint mypaint=new Paint();
            mypaint.setColor(Color.RED);
            mypaint.setAntiAlias(true);
            mypaint.setStyle(Paint.Style.STROKE);
            mypaint.setStrokeJoin(Paint.Join.ROUND);
            // mpaint.setStrokeCap(Paint.Cap.ROUND);
            //mpaint.setXfermode(null);
            //mpaint.setAlpha(0xff);
            mypaint.setStrokeWidth(5f);





            Paint p=new Paint();
            p.setColor(Color.BLUE);
            p.setAntiAlias(true);
            p.setStyle(Paint.Style.STROKE);
            p.setStrokeJoin(Paint.Join.ROUND);
            // mpaint.setStrokeCap(Paint.Cap.ROUND);
            //mpaint.setXfermode(null);
            //mpaint.setAlpha(0xff);
            p.setStrokeWidth(5f);
            canvas.drawColor(Color.YELLOW);
            if(k==3) { canvas.drawColor(Color.YELLOW);
                for2path=new Path(); k=0;
                for2=new Path();
                for1=new Path();
                for3=new Path();
                newpath3=new Path();
            newpath=new Path(); newpath2=new Path(); newpath1=new Path();}
            //here
            Paint eraser=new Paint();
            eraser.setAntiAlias(true);
            eraser.setColor(Color.YELLOW);
            eraser.setStyle(Paint.Style.STROKE);
            eraser.setStrokeJoin(Paint.Join.ROUND);
            eraser.setStrokeWidth(5f);

            Paint one,two;
            one=new Paint();two=new Paint();
            one.setAntiAlias(true);
            one.setStyle(Paint.Style.STROKE);
            one.setStrokeJoin(Paint.Join.ROUND);
            one.setStrokeWidth(5f);
            two.setAntiAlias(true);
            two.setStyle(Paint.Style.STROKE);
            two.setStrokeJoin(Paint.Join.ROUND);
            two.setStrokeWidth(5f);
            one.setColor(Color.GREEN);
            two.setColor(Color.RED);
            Paint white;
            white=new Paint();
            white.setColor(Color.WHITE);
            white.setAntiAlias(true);
            white.setStyle(Paint.Style.STROKE);
            white.setStrokeJoin(Paint.Join.ROUND);
            white.setStrokeWidth(5f);




            if(k==1) {
               // canvas.drawPath(newpath,p);

                 canvas.drawPath(newpath,white);
               // if(universal2==1)
                    canvas.drawPath(newpath1,one);
                //else if(universal2==2)
                    canvas.drawPath(newpath2,two);

                    canvas.drawPath(newpath3,eraser);


            }//canvas.drawColor(Color.GREEN); //canvas.drawPath(newpath,p);
            canvas.drawPath(for2path,white);
            canvas.drawPath(for1,one);
            canvas.drawPath(for2,two);
            canvas.drawPath(for3,eraser);
        }

        //change
        @Override
        public boolean onTouchEvent(MotionEvent event) {
            //return super.onTouchEvent(event);
            float xpos=event.getX();
            float ypos=event.getY();

            switch (event.getAction())
            {
                case MotionEvent.ACTION_DOWN:
                {

                    for2path.moveTo(xpos,ypos);
                    for2listener.for2whensent(for2path,0);

                    if(universal==1)
                    { for1.moveTo(xpos,ypos);
                        for2listener.for2whensent(for1,1);}
                    else if(universal==2)
                    {for2.moveTo(xpos,ypos);for2listener.for2whensent(for2,2);}
                    if(universal==3)
                    {for3.moveTo(xpos,ypos);for2listener.for2whensent(for3,3);}


                    return true;
                }
                case MotionEvent.ACTION_MOVE:{
                    for2path.lineTo(xpos,ypos);
                    for2listener.for2whensent(for2path,0);

                    if(universal==1)
                    {for1.lineTo(xpos,ypos);for2listener.for2whensent(for1,1);}
                    else if(universal==2)
                    { for2.lineTo(xpos,ypos);for2listener.for2whensent(for2,2);}
                    else if(universal==3)
                    {for3.lineTo(xpos,ypos);for2listener.for2whensent(for3,3);}




                    break;

                }
                case MotionEvent.ACTION_UP:
                {
                    break;
                }

                default:return false;
            }


            invalidate();
            return true;
        }
        //change




    }


}
