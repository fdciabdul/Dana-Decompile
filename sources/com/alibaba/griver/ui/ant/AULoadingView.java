package com.alibaba.griver.ui.ant;

import android.content.Context;
import android.content.res.TypedArray;
import android.text.SpannableString;
import android.text.style.AbsoluteSizeSpan;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import com.alibaba.griver.ui.R;
import com.alibaba.griver.ui.ant.api.AntUI;
import com.alibaba.griver.ui.ant.dialog.AUEmptyGoneTextView;
import com.alibaba.griver.ui.ant.layout.AULinearLayout;
import com.alibaba.griver.ui.ant.text.AUTextView;
import com.alibaba.griver.ui.ant.theme.AUAbsTheme;

/* loaded from: classes6.dex */
public class AULoadingView extends AULinearLayout implements AntUI {

    /* renamed from: a  reason: collision with root package name */
    private AUTextView f6654a;
    private AUEmptyGoneTextView b;

    @Override // com.alibaba.griver.ui.ant.api.AntUI
    public void initAttrStyle(Context context, AttributeSet attributeSet, TypedArray typedArray) {
    }

    @Override // com.alibaba.griver.ui.ant.api.AntUI
    public void initContent(Context context, AttributeSet attributeSet, TypedArray typedArray) {
    }

    @Override // com.alibaba.griver.ui.ant.api.AntUI
    public void initStyleByTheme(Context context) {
    }

    @Override // com.alibaba.griver.ui.ant.api.AntUI
    public void upDateTheme(Context context, AUAbsTheme aUAbsTheme) {
    }

    public AULoadingView(Context context) {
        super(context);
        a(context, null);
    }

    public AULoadingView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a(context, attributeSet);
    }

    public AULoadingView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        a(context, attributeSet);
    }

    private void a(Context context, AttributeSet attributeSet) {
        init(context, null, null);
        if (attributeSet != null) {
            initContent(context, null, null);
            initStyleByTheme(context);
            initAttrStyle(context, null, null);
            return;
        }
        initStyleByTheme(context);
    }

    @Override // com.alibaba.griver.ui.ant.api.AntUI
    public void init(Context context, AttributeSet attributeSet, TypedArray typedArray) {
        LayoutInflater.from(context).inflate(R.layout.griver_ui_loading_view, (ViewGroup) this, true);
        this.f6654a = (AUTextView) findViewById(R.id.progress_current_text);
        this.b = (AUEmptyGoneTextView) findViewById(R.id.progress_loading_text);
    }

    public void setCurrentProgress(int i) {
        StringBuilder sb = new StringBuilder();
        sb.append(i);
        sb.append("%");
        SpannableString spannableString = new SpannableString(sb.toString());
        spannableString.setSpan(new AbsoluteSizeSpan(6, true), spannableString.length() - 1, spannableString.length(), 33);
        this.f6654a.setText(spannableString);
    }

    public void setLoadingText(String str) {
        this.b.setText(str);
    }
}
