package com.platform.bookshare.utils.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.CornerPathEffect;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

import com.platform.bookshare.R;

/**
 * Created by Zhangchen on 2018/2/1.
 */

public class LabelView extends View{

    private Context context;
    private Paint paint = new Paint();
    private Paint paintText = new Paint();
    private Path p = new Path();
    private float scale; //将dp转换为px单位
    private final RectF mBorderRect = new RectF();
    private Rect rectText = new Rect();

    private boolean mReady;
    private boolean mSetupPending;
    private boolean mBorderOverlay;
    private boolean mDisableCircularTransformation;

    private static final int DEFAULT_BORDER_WIDTH = 0;
    private static final int DEFAULT_BORDER_COLOR = Color.BLACK;
    private static final int DEFAULT_FILL_COLOR = Color.TRANSPARENT;
    private static final boolean DEFAULT_BORDER_OVERLAY = false;
    private int mBorderColor = DEFAULT_BORDER_COLOR;
    private int mBorderWidth = DEFAULT_BORDER_WIDTH;
    private int mFillColor = DEFAULT_FILL_COLOR;
    private int[] doum = new int[]{1,2,3,4,5};

    public LabelView(Context context) {
        super(context);
        this.context = context;
        init();
    }

    public LabelView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public LabelView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        TypedArray a = context.obtainStyledAttributes(attrs, R.styleable.CircleImageView, defStyleAttr, 0);

        mBorderWidth = a.getDimensionPixelSize(R.styleable.CircleImage_civ_border_width, DEFAULT_BORDER_WIDTH);
        mBorderColor = a.getColor(R.styleable.CircleImage_civ_border_color, DEFAULT_BORDER_COLOR);
        mBorderOverlay = a.getBoolean(R.styleable.CircleImage_civ_border_overlay, DEFAULT_BORDER_OVERLAY);
        mFillColor = a.getColor(R.styleable.CircleImage_civ_fill_color, DEFAULT_FILL_COLOR);

        a.recycle();

        init();
    }

    private void init() {
        mReady = true;

        if (mSetupPending) {
            setup();
            mSetupPending = false;
        }
    }

    private RectF calculateBounds() {
        int availableWidth  = getWidth() - getPaddingLeft() - getPaddingRight();
        int availableHeight = getHeight() - getPaddingTop() - getPaddingBottom();

        float left = getPaddingLeft();
        float top = getPaddingTop();

        return new RectF(left, top, left + availableWidth, top + availableHeight);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        if (mDisableCircularTransformation) {
            super.onDraw(canvas);
            return;
        }
        p.moveTo(mBorderRect.left, (float) (0.5*mBorderRect.bottom));
        p.lineTo((float) (mBorderRect.left+0.2*mBorderRect.right), mBorderRect.top);
        p.lineTo(mBorderRect.right,mBorderRect.top);
        p.lineTo(mBorderRect.right,mBorderRect.bottom);
        p.lineTo((float) (mBorderRect.left+0.2*mBorderRect.right),mBorderRect.bottom);
        p.close();//封闭
        canvas.drawPath(p,paint);
//        float differenctx = (float) (((mBorderRect.right - mBorderRect.left) * 0.8 - rectText.right + rectText.left) / 2);
//        float differenty = ((mBorderRect.bottom - mBorderRect.top)-rectText.bottom+rectText.top)/2;
//        canvas.drawText("测试", (float) (1.2*mBorderRect.left+ differenctx),mBorderRect.bottom-differenty,paintText);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);

    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        setup();
    }

    @Override
    public void setPaddingRelative(int start, int top, int end, int bottom) {
        super.setPaddingRelative(start, top, end, bottom);
        setup();
    }

    private void setup() {
        if (!mReady) {
            mSetupPending = true;
            return;
        }

        if (getWidth() == 0 && getHeight() == 0) {
            return;
        }
        mBorderRect.set(calculateBounds());
        paint.setStyle(Paint.Style.FILL);
        paint.setAntiAlias(true);
//        paint.setColor(Color.argb(225,162,201,255));

//        Random r = new Random();
//        int i = r.nextInt(doum.length);
//        for (int x=0;x<20;x++){
//            Log.d("测试",i+"");
//        }
        paint.setColor(Color.BLACK);
        paint.setPathEffect(new CornerPathEffect(5));//绘制圆角

        paintText.setStyle(Paint.Style.FILL);
        paintText.setAntiAlias(true);
//        paintText.setColor(Color.argb(255,204,102,89));
//        paintText.setColor(Color.WHITE);
//        paintText.setTextSize(12);
//        paintText.getTextBounds("测试",0,2,rectText);
    }

}
