package game.shooting;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;

import com.example.dooho_2.graphic0714.R;

public class GameView extends View{
    Bitmap ship;
    private int posX;
    private int posY;
    Paint paint;
    /* 조이스틱, 총알버튼의 크기*/
    RectF[] control = new RectF[5];
    int controlWidth=130;
    int controlHeight=130;
    int x=150;
    int y=650;

    public int getPosX() {
        return posX;
    }
    public int getPosY() {
        return posY;
    }
    public void setPosX(int posX) {
        this.posX = posX;
    }
    public void setPosY(int posY) {
        this.posY = posY;
    }
    public GameView(Context context, AttributeSet attrs) {
        super(context, attrs);
        Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.ship);
        ship=Bitmap.createScaledBitmap(bitmap,150,100,false);
        paint = new Paint();
        paint.setColor(Color.BLUE);

        control[0] = new RectF(x,y,x+controlWidth,y+controlHeight); //up
        control[1] = new RectF(x,y+150,x+controlWidth,y+150+controlHeight); //down
        control[2] = new RectF(x-150,y+150,x-150+controlWidth,y+150+controlHeight); //left
        control[3] = new RectF(x+150,y+150,x+150+controlWidth,y+150+controlHeight);  //right
        //control[4] = new RectF(300,y+150,300+controlWidth,y+150+controlHeight);
    }
    /*조이스틱 만들기*/
    public void paintJoyStick(Canvas canvas) {
        /* up */
        //for (int i=0;i<control.length;i++) {
            canvas.drawRect(control[0], paint);
            canvas.drawRect(control[1], paint);
            canvas.drawRect(control[2], paint);
            canvas.drawRect(control[3], paint);
        //}
        /* down */
        //canvas.drawRect(new Rect(100,200,100+100,200+100),paint);

        /* left */
       // canvas.drawRect(new Rect(100,200,100+100,200+100),paint);

        /* right */
       // canvas.drawRect(new Rect(100,200,100+100,200+100),paint);
    }

    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawBitmap(ship, posX, posY, null);

        paintJoyStick(canvas);
    }
}
