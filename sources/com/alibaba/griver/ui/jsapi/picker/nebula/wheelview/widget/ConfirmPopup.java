package com.alibaba.griver.ui.jsapi.picker.nebula.wheelview.widget;

import android.app.Activity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.alibaba.griver.base.common.utils.DensityUtil;

/* loaded from: classes6.dex */
public abstract class ConfirmPopup<V extends View> extends BottomPopup<View> {
    protected CharSequence cancelText;
    protected int cancelTextColor;
    protected boolean cancelVisible;
    protected CharSequence submitText;
    protected int submitTextColor;
    protected CharSequence titleText;
    protected int titleTextColor;
    protected int topBackgroundColor;
    protected int topLineColor;
    protected boolean topLineVisible;

    protected abstract V makeCenterView();

    protected View makeFooterView() {
        return null;
    }

    protected void onCancel() {
    }

    protected void onSubmit() {
    }

    public ConfirmPopup(Activity activity) {
        super(activity);
        this.topLineVisible = true;
        this.topLineColor = -2236963;
        this.topBackgroundColor = -1;
        this.cancelVisible = true;
        this.cancelText = "";
        this.submitText = "";
        this.titleText = "";
        this.cancelTextColor = -16777216;
        this.submitTextColor = -16777216;
        this.titleTextColor = -16777216;
        this.cancelText = activity.getString(17039360);
        this.submitText = activity.getString(17039370);
    }

    public void setTopLineColor(int i) {
        this.topLineColor = i;
    }

    public void setTopBackgroundColor(int i) {
        this.topBackgroundColor = i;
    }

    public void setTopLineVisible(boolean z) {
        this.topLineVisible = z;
    }

    public void setCancelVisible(boolean z) {
        this.cancelVisible = z;
    }

    public void setCancelText(CharSequence charSequence) {
        this.cancelText = charSequence;
    }

    public void setCancelText(int i) {
        this.cancelText = this.activity.getString(i);
    }

    public void setSubmitText(CharSequence charSequence) {
        this.submitText = charSequence;
    }

    public void setSubmitText(int i) {
        this.submitText = this.activity.getString(i);
    }

    public void setTitleText(CharSequence charSequence) {
        this.titleText = charSequence;
    }

    public void setTitleText(int i) {
        this.titleText = this.activity.getString(i);
    }

    public void setCancelTextColor(int i) {
        this.cancelTextColor = i;
    }

    public void setSubmitTextColor(int i) {
        this.submitTextColor = i;
    }

    public void setTitleTextColor(int i) {
        this.titleTextColor = i;
    }

    @Override // com.alibaba.griver.ui.jsapi.picker.nebula.wheelview.widget.BottomPopup
    protected final View makeContentView() {
        LinearLayout linearLayout = new LinearLayout(this.activity);
        linearLayout.setLayoutParams(new LinearLayout.LayoutParams(-1, -1));
        linearLayout.setBackgroundColor(-1);
        linearLayout.setOrientation(1);
        linearLayout.setGravity(17);
        linearLayout.setPadding(0, 0, 0, 0);
        linearLayout.setClipToPadding(false);
        View makeHeaderView = makeHeaderView();
        if (makeHeaderView != null) {
            linearLayout.addView(makeHeaderView);
        }
        if (this.topLineVisible) {
            View view = new View(this.activity);
            view.setLayoutParams(new LinearLayout.LayoutParams(-1, 1));
            view.setBackgroundColor(this.topLineColor);
            linearLayout.addView(view);
        }
        linearLayout.addView(makeCenterView(), new LinearLayout.LayoutParams(-1, 0, 1.0f));
        View makeFooterView = makeFooterView();
        if (makeFooterView != null) {
            linearLayout.addView(makeFooterView);
        }
        return linearLayout;
    }

    protected View makeHeaderView() {
        RelativeLayout relativeLayout = new RelativeLayout(this.activity);
        relativeLayout.setLayoutParams(new RelativeLayout.LayoutParams(-1, DensityUtil.dip2px(this.activity, 40.0f)));
        relativeLayout.setBackgroundColor(this.topBackgroundColor);
        relativeLayout.setGravity(16);
        Button button = new Button(this.activity);
        button.setVisibility(this.cancelVisible ? 0 : 8);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(9, -1);
        layoutParams.addRule(15, -1);
        button.setLayoutParams(layoutParams);
        button.setBackgroundColor(0);
        button.setGravity(17);
        if (!TextUtils.isEmpty(this.cancelText)) {
            button.setText(this.cancelText);
        }
        button.setTextColor(this.cancelTextColor);
        button.setOnClickListener(new View.OnClickListener() { // from class: com.alibaba.griver.ui.jsapi.picker.nebula.wheelview.widget.ConfirmPopup.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ConfirmPopup.this.dismiss();
                ConfirmPopup.this.onCancel();
            }
        });
        relativeLayout.addView(button);
        TextView textView = new TextView(this.activity);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
        int dip2px = DensityUtil.dip2px(this.activity, 20.0f);
        layoutParams2.leftMargin = dip2px;
        layoutParams2.rightMargin = dip2px;
        layoutParams2.addRule(14, -1);
        layoutParams2.addRule(15, -1);
        textView.setLayoutParams(layoutParams2);
        textView.setGravity(17);
        if (!TextUtils.isEmpty(this.titleText)) {
            textView.setText(this.titleText);
        }
        textView.setTextColor(this.titleTextColor);
        relativeLayout.addView(textView);
        Button button2 = new Button(this.activity);
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams3.addRule(11, -1);
        layoutParams3.addRule(15, -1);
        button2.setLayoutParams(layoutParams3);
        button2.setBackgroundColor(0);
        button2.setGravity(17);
        if (!TextUtils.isEmpty(this.submitText)) {
            button2.setText(this.submitText);
        }
        button2.setTextColor(this.submitTextColor);
        button2.setOnClickListener(new View.OnClickListener() { // from class: com.alibaba.griver.ui.jsapi.picker.nebula.wheelview.widget.ConfirmPopup.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ConfirmPopup.this.dismiss();
                ConfirmPopup.this.onSubmit();
            }
        });
        relativeLayout.addView(button2);
        return relativeLayout;
    }
}
