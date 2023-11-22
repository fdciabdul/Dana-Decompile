package com.yellowmessenger.ymchat;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

/* loaded from: classes8.dex */
public class YmMovableFloatingActionButton extends FloatingActionButton implements View.OnTouchListener {
    private float KClassImpl$Data$declaredNonStaticMembers$2;
    private float MyBillsEntityDataFactory;
    private float PlaceComponentResult;
    private float getAuthRequestContext;

    public YmMovableFloatingActionButton(Context context) {
        super(context);
        setOnTouchListener(this);
    }

    public YmMovableFloatingActionButton(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        setOnTouchListener(this);
    }

    public YmMovableFloatingActionButton(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        setOnTouchListener(this);
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
        int action = motionEvent.getAction();
        if (action == 0) {
            this.KClassImpl$Data$declaredNonStaticMembers$2 = motionEvent.getRawX();
            this.getAuthRequestContext = motionEvent.getRawY();
            this.PlaceComponentResult = view.getX() - this.KClassImpl$Data$declaredNonStaticMembers$2;
            this.MyBillsEntityDataFactory = view.getY() - this.getAuthRequestContext;
            return true;
        } else if (action != 2) {
            if (action == 1) {
                float rawX = motionEvent.getRawX();
                float rawY = motionEvent.getRawY();
                float f = this.KClassImpl$Data$declaredNonStaticMembers$2;
                float f2 = this.getAuthRequestContext;
                if (Math.abs(rawX - f) >= 10.0f || Math.abs(rawY - f2) >= 10.0f) {
                    return true;
                }
                return performClick();
            }
            return super.onTouchEvent(motionEvent);
        } else {
            int width = view.getWidth();
            int height = view.getHeight();
            View view2 = (View) view.getParent();
            int width2 = view2.getWidth();
            int height2 = view2.getHeight();
            view.animate().x(Math.min((width2 - width) - marginLayoutParams.rightMargin, Math.max(marginLayoutParams.leftMargin, motionEvent.getRawX() + this.PlaceComponentResult))).y(Math.min((height2 - height) - marginLayoutParams.bottomMargin, Math.max(marginLayoutParams.topMargin, motionEvent.getRawY() + this.MyBillsEntityDataFactory))).setDuration(0L).start();
            return true;
        }
    }
}
