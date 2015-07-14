package com.example.dooho_2.graphic0714;
import android.app.Activity;
import android.graphics.Point;
import android.os.Bundle;
import android.view.MotionEvent;

import java.util.ArrayList;

public class MainActivity extends Activity {
    ArrayList<Point> list=new ArrayList<Point>();
    MyView myView;
    String Tag;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Tag=this.getClass().getName();
        myView=(MyView)findViewById(R.id.myView);
    }

    public  void printOval(ArrayList list){
        myView.list=list;
        myView.invalidate();

    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        //printOval((int)event.getX(),(int)event.getY());
        /*터치가 발생하면, 좌표를 컬렉션 객체에 담자*/
        Point point=new Point((int)event.getX(),(int)event.getY());
        list.add(point);
        printOval(list);
        return false;
    }
}
