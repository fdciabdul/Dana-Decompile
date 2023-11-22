package com.alibaba.griver.ui.ant.layout;

import android.content.Context;
import android.content.res.ColorStateList;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import com.alibaba.griver.ui.R;
import com.alibaba.griver.ui.ant.text.AUTextView;

/* loaded from: classes6.dex */
public class MenuItemLayout extends AULinearLayout {

    /* renamed from: a  reason: collision with root package name */
    private AUTextView f6688a;

    public MenuItemLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        LayoutInflater.from(context).inflate(R.layout.griver_ui_menu_item_layout, (ViewGroup) this, true);
    }

    public MenuItemLayout(Context context) {
        super(context);
        LayoutInflater.from(context).inflate(R.layout.griver_ui_menu_item_layout, (ViewGroup) this, true);
        this.f6688a = (AUTextView) findViewById(R.id.tv_menu_name);
    }

    public MenuItemLayout(Context context, int i) {
        this(context);
        if (i > 0) {
            AUTextView aUTextView = this.f6688a;
            aUTextView.setPadding(i, aUTextView.getPaddingTop(), i, this.f6688a.getPaddingBottom());
        }
    }

    @Override // android.view.View
    protected void onFinishInflate() {
        super.onFinishInflate();
    }

    public void setText(String str) {
        this.f6688a.setText(str);
    }

    public int getTextWidth() {
        return getWidth();
    }

    public void setTextColor(ColorStateList colorStateList) {
        if (colorStateList == null) {
            return;
        }
        this.f6688a.setTextColor(colorStateList);
    }

    public void setTextBold(boolean z) {
        this.f6688a.getPaint().setFakeBoldText(z);
    }

    public void setInitTextColor(int i) {
        this.f6688a.setTextColor(i);
    }

    public void setTextSize(float f) {
        this.f6688a.setTextSize(0, f);
    }
}
