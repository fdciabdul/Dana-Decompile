package com.alipay.androidinter.app.safepaybase.alikeyboard;

import android.graphics.Point;
import android.view.View;
import android.view.ViewGroup;

/* loaded from: classes6.dex */
public class AbstractKeyboard {
    protected AliKeyboardType keyboardType;
    protected ViewGroup keyboardView;
    protected OnKeyboardListener onKeyboardListener;

    public View getView() {
        return this.keyboardView;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onDel() {
        OnKeyboardListener onKeyboardListener = this.onKeyboardListener;
        if (onKeyboardListener != null) {
            onKeyboardListener.onDel();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onOK() {
        OnKeyboardListener onKeyboardListener = this.onKeyboardListener;
        if (onKeyboardListener != null) {
            onKeyboardListener.onOK();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onInput(String str) {
        OnKeyboardListener onKeyboardListener = this.onKeyboardListener;
        if (onKeyboardListener != null) {
            onKeyboardListener.onInput(str);
        }
    }

    protected void onStatisticEvent(String str) {
        OnKeyboardListener onKeyboardListener = this.onKeyboardListener;
        if (onKeyboardListener != null) {
            onKeyboardListener.onStatisticEvent(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public Point getRelatePoint(ViewGroup viewGroup, View view) {
        if (viewGroup == null || view == null) {
            return new Point();
        }
        if (view.getParent() == viewGroup) {
            return new Point(view.getLeft(), view.getTop());
        }
        Point relatePoint = getRelatePoint(viewGroup, (View) view.getParent());
        return new Point(relatePoint.x + view.getLeft(), relatePoint.y + view.getTop());
    }
}
