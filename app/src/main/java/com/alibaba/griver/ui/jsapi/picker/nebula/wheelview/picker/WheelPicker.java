package com.alibaba.griver.ui.jsapi.picker.nebula.wheelview.picker;

import android.app.Activity;
import android.view.View;
import com.alibaba.griver.ui.jsapi.picker.nebula.wheelview.widget.ConfirmPopup;

/* loaded from: classes6.dex */
public abstract class WheelPicker extends ConfirmPopup<View> {
    protected int lineColor;
    protected boolean lineVisible;
    protected int offset;
    protected int textColorFocus;
    protected int textColorNormal;
    protected int textSize;

    public WheelPicker(Activity activity) {
        super(activity);
        this.textSize = 16;
        this.textColorNormal = -4473925;
        this.textColorFocus = -16611122;
        this.lineColor = -8139290;
        this.lineVisible = true;
        this.offset = 1;
    }

    public void setTextSize(int i) {
        this.textSize = i;
    }

    public void setTextColor(int i, int i2) {
        this.textColorFocus = i;
        this.textColorNormal = i2;
    }

    public void setTextColor(int i) {
        this.textColorFocus = i;
    }

    public void setLineVisible(boolean z) {
        this.lineVisible = z;
    }

    public void setLineColor(int i) {
        this.lineColor = i;
    }

    public void setOffset(int i) {
        this.offset = i;
    }
}
