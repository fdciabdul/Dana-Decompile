package com.zoloz.android.phone.zdoc.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.RelativeLayout;

/* loaded from: classes8.dex */
public abstract class IMessageView extends RelativeLayout {

    /* loaded from: classes8.dex */
    public interface IMessageViewClickListener {
        void onConfirmListener(View view);

        void onRetakePhotoListener(View view);

        void onTakePhotoListener(View view);
    }

    public abstract void clearClickListener();

    protected void init(Context context, AttributeSet attributeSet) {
    }

    public abstract void setOnConfirmListener(View.OnClickListener onClickListener);

    public abstract void setOnReTakePhotoListener(View.OnClickListener onClickListener);

    public abstract void setOnTakePhotoListener(View.OnClickListener onClickListener);

    public abstract void setUiLocation(int i, String str, int i2, int i3, int i4, int i5);

    public abstract void updateMessage(int i);

    public abstract void updateUI(UIState uIState, int i, int i2);

    public IMessageView(Context context) {
        super(context);
        init(context, null);
    }

    public IMessageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init(context, attributeSet);
    }

    public IMessageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init(context, attributeSet);
    }
}
