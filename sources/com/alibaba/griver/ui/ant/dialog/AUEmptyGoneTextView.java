package com.alibaba.griver.ui.ant.dialog;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.widget.TextView;
import com.alibaba.griver.ui.ant.text.AUTextView;

/* loaded from: classes6.dex */
public class AUEmptyGoneTextView extends AUTextView {
    public AUEmptyGoneTextView(Context context) {
        super(context);
    }

    public AUEmptyGoneTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public AUEmptyGoneTextView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    @Override // com.alibaba.griver.ui.ant.text.AUTextView, android.widget.TextView
    public void setText(CharSequence charSequence, TextView.BufferType bufferType) {
        super.setText(charSequence, bufferType);
        if (TextUtils.isEmpty(charSequence)) {
            setVisibility(8);
        } else {
            setVisibility(0);
        }
    }
}
