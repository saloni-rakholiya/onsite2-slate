package com.example.onsite2;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BlurMaskFilter;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.EmbossMaskFilter;
import android.graphics.MaskFilter;
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
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import java.util.ArrayList;
import java.util.Vector;

public class frag1 extends Fragment {

    Vector<Path> vectorforpath=new Vector<>();
    Vector<Integer> vectorcolour=new Vector<>();
    //here
    draw d;
    int k=0;
    int for2k=0;
    int universal=0;
    Path for3;
    int universal2=0;
    Path newpath,newpath1,newpath2,newpatheraser;
    int color=0;
    private frag1listener listener;
    Path for2newpath=new Path();

    Path for1,for2;

    public interface frag1listener{
        void whensent(Path path,int uni);

    }


    //tohere


    public void reset()
    {
        k=3;
        d.invalidate();
    }

    public void togreen()
    {
        color=1;
        d.invalidate();
    }
    public void toyellow()
    {
        color=2;
        d.invalidate();
    }




    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v=inflater.inflate(R.layout.fragment1,container,false);
        RelativeLayout r=v.findViewById(R.id.rect);

        Button y=v.findViewById(R.id.y);
        Button g=v.findViewById(R.id.g);
        Button e=v.findViewById(R.id.eraser);
        e.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                universal=3;
            }
        });
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




        d=new draw(getActivity());
        r.addView(d);
        return v;
    }



    //here

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        if(context instanceof frag1listener)
           { listener=(frag1listener)context;}
        else{
           throw new RuntimeException(context.toString()+"must implement listener");
        }

    }

    @Override
    public void onDetach() {
        super.onDetach();
        listener=null;
    }

    public void update(Path path,int uni) {

        for2newpath=path;
        universal2=uni;
        if(uni==3)
            newpatheraser=path;
        if(uni==0)
            newpath=path;
        if(uni==1)
            newpath1=path;
        if(uni==2) newpath2=path;
        for2k=1;
        d.invalidate();
        // View drawing=new draw(getActivity());
        //drawing.invalidate();



        //toupdate
    }



    //here

    private class draw extends View{
     /*   public int brushsize=10;*/
        private int defaultcolor=Color.RED;
     /*   private float touchtolerance=4;
        float mx,my;

        private Path  path;*/
        private Paint mpaint;
        Paint eraserpaint=new Paint();
        Path for3=new Path();
        private Path path;

       /* private ArrayList<fingerpath> paths=new ArrayList<>();
        private int currentcolour;
        private int bgcolour;
        private int strokewidth;
        private boolean emboss;
        private boolean blur;
        private MaskFilter memboss;
        private MaskFilter mblur;
        private Bitmap mbit;
        private Canvas mcanvas;
        private Paint mbitmappaint=new Paint(Paint.DITHER_FLAG);*/


        public draw(Context context) {
            super(context);
            init(null);
        }
        public draw(Context context, @Nullable AttributeSet attrs) {
            super(context, attrs);
            init(attrs);
        }
        private void init(AttributeSet attrs) {
        mpaint=new Paint();
     /*   mpaint.setAntiAlias(true);
        mpaint.setDither(true);*/

     for1=new Path();
     for2=new Path();
            mpaint.setColor(defaultcolor);
            mpaint.setAntiAlias(true);
            mpaint.setStyle(Paint.Style.STROKE);
            mpaint.setStrokeJoin(Paint.Join.ROUND);
            mpaint.setStrokeWidth(5f);
           // mpaint.setStrokeCap(Paint.Cap.ROUND);
            //mpaint.setXfermode(null);
            //mpaint.setAlpha(0xff);


            eraserpaint.setColor(Color.BLUE);
            eraserpaint.setAntiAlias(true);
            eraserpaint.setStyle(Paint.Style.STROKE);
            eraserpaint.setStrokeJoin(Paint.Join.ROUND);
            eraserpaint.setStrokeWidth(5f);


            newpath=new Path();
            newpath1=new Path();
            newpath2=new Path();
            newpatheraser=new Path();
       /* mpaint.setStyle(Paint.Style.STROKE);
        mpaint.setStrokeJoin(Paint.Join.ROUND);
        mpaint.setStrokeCap(Paint.Cap.ROUND);
        mpaint.setXfermode(null);
        mpaint.setAlpha(0xff);
        memboss=new EmbossMaskFilter(new float[ {1,1,1}],0.4f,6,3.5f);
        mblur=new BlurMaskFilter(5,BlurMaskFilter.Blur.NORMAL);*/

       path=new Path();

        }
        public draw(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
            super(context, attrs, defStyleAttr);
            init(attrs);
        }

        public draw(Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
            super(context, attrs, defStyleAttr, defStyleRes);
            init(attrs);
        }

        @Override
        protected void onDraw(Canvas canvas) {

            super.onDraw(canvas);
            Paint forblack=new Paint();
            canvas.drawRect(0,0,50,50,forblack);
            canvas.drawColor(Color.BLUE);
            Paint paint=new Paint();
            paint.setColor(Color.RED);
                if(color==1) mpaint.setColor(Color.GREEN);
                    else if (color==2) mpaint.setColor(Color.YELLOW);

            if(k==3) { vectorcolour=new Vector<>(); vectorforpath=new Vector<>();
                path=new Path();for1=new Path();for2=new Path(); for2newpath=new Path();
                newpath=new Path(); newpath2=new Path(); newpath1=new Path();
                for3=new Path();
                newpatheraser=new Path();
            canvas.drawColor(Color.BLUE);k=0;}

            //canvas.drawPath(path,mpaint);
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


            canvas.drawPath(path,white);
                canvas.drawPath(for1,one);
                    canvas.drawPath(for2,two);
                    canvas.drawPath(for3,eraserpaint);

    /*       for(int i=0;i<vectorforpath.size();++i)
               {

               if(vectorcolour.get(i)==2)
                   canvas.drawPath(vectorforpath.get(i),two);
               else if(vectorcolour.get(i)==1)
                   canvas.drawPath(vectorforpath.get(i),one);
               else if(vectorcolour.get(i)==3)
                   canvas.drawPath(vectorforpath.get(i),eraserpaint);
               else canvas.drawPath(vectorforpath.get(i),white);}
*/



            Paint p=new Paint();
            p.setColor(Color.YELLOW);
            p.setAntiAlias(true);
            p.setStyle(Paint.Style.STROKE);
            p.setStrokeJoin(Paint.Join.ROUND);
            p.setStrokeWidth(5f);
            if(for2k==1) {//canvas.drawPath(for2newpath,p);
                canvas.drawPath(newpath,white);
                // if(universal2==1)
                canvas.drawPath(newpath1,one);
                //else if(universal2==2)
                canvas.drawPath(newpath2,two);
                canvas.drawPath(newpatheraser,eraserpaint);
            }


          //  canvas.drawRect(10,10,300,300,paint);

        }

        @Override
        public boolean onTouchEvent(MotionEvent event) {
            //return super.onTouchEvent(event);
            float xpos=event.getX();
            float ypos=event.getY();

            switch (event.getAction())
            {
                case MotionEvent.ACTION_DOWN:
                {   //path=new Path();
                    path.moveTo(xpos,ypos);
                /*vectorforpath.add(path);
                vectorcolour.add(universal);
*/

                    listener.whensent(path,0);
                    if(universal==1)
                   { for1.moveTo(xpos,ypos);
                       listener.whensent(for1,1);}
                    else if(universal==2)
                    {for2.moveTo(xpos,ypos);listener.whensent(for2,2);}


                    else if(universal==3)
                    {
                        for3.moveTo(xpos,ypos);listener.whensent(for3,3);
                    }


                    return true;
                }
                case MotionEvent.ACTION_MOVE:{


                    path.lineTo(xpos,ypos);
                    listener.whensent(path,0);
                  /*  vectorforpath.add(path);
                    vectorcolour.add(universal);*/
                    if(universal==1)
                        {for1.lineTo(xpos,ypos);listener.whensent(for1,1);}
                    else if(universal==2)
                       { for2.lineTo(xpos,ypos);listener.whensent(for2,2);}
                    else if(universal==3)
                    {
                        for3.lineTo(xpos,ypos);listener.whensent(for3,3);
                    }


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
    }


}
