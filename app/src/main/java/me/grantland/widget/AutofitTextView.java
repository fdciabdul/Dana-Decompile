package me.grantland.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.TextView;
import me.grantland.widget.AutofitHelper;

/* loaded from: classes9.dex */
public class AutofitTextView extends TextView implements AutofitHelper.OnTextSizeChangeListener {
    private AutofitHelper mHelper;

    @Override // me.grantland.widget.AutofitHelper.OnTextSizeChangeListener
    public void onTextSizeChange(float f, float f2) {
    }

    public AutofitTextView(Context context) {
        super(context);
        init(context, null, 0);
    }

    public AutofitTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init(context, attributeSet, 0);
    }

    public AutofitTextView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init(context, attributeSet, i);
    }

    private void init(Context context, AttributeSet attributeSet, int i) {
        this.mHelper = AutofitHelper.create(this, attributeSet, i).addOnTextSizeChangeListener(this);
    }

    @Override // android.widget.TextView
    public void setTextSize(int i, float f) {
        super.setTextSize(i, f);
        AutofitHelper autofitHelper = this.mHelper;
        if (autofitHelper != null) {
            autofitHelper.setTextSize(i, f);
        }
    }

    @Override // android.widget.TextView
    public void setLines(int i) {
        super.setLines(i);
        AutofitHelper autofitHelper = this.mHelper;
        if (autofitHelper != null) {
            autofitHelper.setMaxLines(i);
        }
    }

    @Override // android.widget.TextView
    public void setMaxLines(int i) {
        super.setMaxLines(i);
        AutofitHelper autofitHelper = this.mHelper;
        if (autofitHelper != null) {
            autofitHelper.setMaxLines(i);
        }
    }

    public AutofitHelper getAutofitHelper() {
        return this.mHelper;
    }

    public boolean isSizeToFit() {
        return this.mHelper.isEnabled();
    }

    public void setSizeToFit() {
        setSizeToFit(true);
    }

    public void setSizeToFit(boolean z) {
        this.mHelper.setEnabled(z);
    }

    public float getMaxTextSize() {
        return this.mHelper.getMaxTextSize();
    }

    public void setMaxTextSize(float f) {
        this.mHelper.setMaxTextSize(f);
    }

    public void setMaxTextSize(int i, float f) {
        this.mHelper.setMaxTextSize(i, f);
    }

    public float getMinTextSize() {
        return this.mHelper.getMinTextSize();
    }

    public void setMinTextSize(int i) {
        this.mHelper.setMinTextSize(2, i);
    }

    public void setMinTextSize(int i, float f) {
        this.mHelper.setMinTextSize(i, f);
    }

    public float getPrecision() {
        return this.mHelper.getPrecision();
    }

    public void setPrecision(float f) {
        this.mHelper.setPrecision(f);
    }
}
