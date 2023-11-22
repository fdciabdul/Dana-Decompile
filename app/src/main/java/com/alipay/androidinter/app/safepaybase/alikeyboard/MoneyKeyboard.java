package com.alipay.androidinter.app.safepaybase.alikeyboard;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.alipay.mobile.verifyidentity.uitools.R;
import com.fullstory.instrumentation.InstrumentInjector;

/* loaded from: classes6.dex */
public class MoneyKeyboard extends AbstractKeyboard implements View.OnTouchListener {
    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0) {
            return onTouchDown(view);
        }
        if (motionEvent.getAction() == 1) {
            return onTouchUp(view);
        }
        return false;
    }

    private boolean onTouchDown(View view) {
        int id2 = view.getId();
        if (id2 == R.id.key_del) {
            onDel();
            return false;
        } else if (id2 == R.id.key_space) {
            onInput(" ");
            return false;
        } else if (id2 != R.id.key_enter) {
            onInput(((TextView) view).getText().toString());
            return false;
        } else {
            return false;
        }
    }

    private boolean onTouchUp(View view) {
        if (view.getId() == R.id.key_enter) {
            onOK();
            return false;
        }
        return false;
    }

    public MoneyKeyboard(Context context, OnKeyboardListener onKeyboardListener) {
        this.keyboardView = (ViewGroup) LayoutInflater.from(context).inflate(R.layout.keyboard_money, (ViewGroup) null, false);
        this.onKeyboardListener = onKeyboardListener;
        initialize(context);
    }

    private void initialize(Context context) {
        LinearLayout linearLayout = (LinearLayout) this.keyboardView.getChildAt(0);
        int childCount = linearLayout.getChildCount();
        int rowHeight = getRowHeight(context);
        for (int i = 0; i < childCount; i++) {
            LinearLayout linearLayout2 = (LinearLayout) linearLayout.getChildAt(i);
            if (linearLayout2 != null) {
                ((LinearLayout.LayoutParams) linearLayout2.getLayoutParams()).height = rowHeight;
                int childCount2 = linearLayout2.getChildCount();
                for (int i2 = 0; i2 < childCount2; i2++) {
                    View childAt = linearLayout2.getChildAt(i2);
                    InstrumentInjector.setAccessibilityDelegate(childAt, new SecureAccessbilityDelegate());
                    childAt.setOnTouchListener(this);
                }
            }
        }
        LinearLayout linearLayout3 = (LinearLayout) this.keyboardView.getChildAt(1);
        int childCount3 = linearLayout3.getChildCount();
        for (int i3 = 0; i3 < childCount3; i3++) {
            View childAt2 = linearLayout3.getChildAt(i3);
            InstrumentInjector.setAccessibilityDelegate(childAt2, new SecureAccessbilityDelegate());
            childAt2.setOnTouchListener(this);
        }
    }

    private int getRowHeight(Context context) {
        double d = context.getResources().getDisplayMetrics().density;
        int i = context.getResources().getDisplayMetrics().heightPixels;
        int i2 = context.getResources().getDisplayMetrics().widthPixels;
        if (i2 <= i) {
            i = i2;
        }
        Double.isNaN(d);
        double d2 = (i - (((int) (d * 4.0d)) * 4)) / 3;
        Double.isNaN(d2);
        return (int) (d2 * 0.466d);
    }
}
