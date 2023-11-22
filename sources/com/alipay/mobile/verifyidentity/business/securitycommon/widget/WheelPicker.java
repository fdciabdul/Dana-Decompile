package com.alipay.mobile.verifyidentity.business.securitycommon.widget;

import android.app.Activity;
import android.graphics.Typeface;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.alipay.mobile.verifyidentity.business.securitycommon.widget.WheelView;

/* loaded from: classes7.dex */
public abstract class WheelPicker extends ConfirmPopup<View> {
    protected boolean cycleDisable;
    protected WheelView.DividerConfig dividerConfig;
    protected int labelTextColor;
    protected float lineSpaceMultiplier;
    protected int offset;
    protected int textColorFocus;
    protected int textColorNormal;
    protected int textPadding;
    protected int textSize;
    protected boolean textSizeAutoFit;
    protected Typeface typeface;
    protected boolean useWeight;

    public WheelPicker(Activity activity) {
        super(activity);
        this.lineSpaceMultiplier = 2.0f;
        this.textPadding = -1;
        this.textSize = 16;
        this.typeface = Typeface.DEFAULT;
        this.textColorNormal = -4473925;
        this.textColorFocus = -16611122;
        this.labelTextColor = -16611122;
        this.offset = 3;
        this.cycleDisable = true;
        this.useWeight = true;
        this.textSizeAutoFit = true;
        this.dividerConfig = new WheelView.DividerConfig();
    }

    public final void setLineSpaceMultiplier(float f) {
        this.lineSpaceMultiplier = f;
    }

    @Deprecated
    public void setPadding(int i) {
        this.textPadding = i;
    }

    public void setTextPadding(int i) {
        this.textPadding = i;
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

    public void setLabelTextColor(int i) {
        this.labelTextColor = i;
    }

    public void setShadowVisible(boolean z) {
        if (this.dividerConfig == null) {
            this.dividerConfig = new WheelView.DividerConfig();
        }
        this.dividerConfig.setShadowVisible(z);
    }

    public void setShadowColor(int i) {
        setShadowColor(i, 100);
    }

    public void setShadowColor(int i, int i2) {
        if (this.dividerConfig == null) {
            this.dividerConfig = new WheelView.DividerConfig();
        }
        this.dividerConfig.setShadowColor(i);
        this.dividerConfig.setShadowAlpha(i2);
    }

    public void setDividerVisible(boolean z) {
        if (this.dividerConfig == null) {
            this.dividerConfig = new WheelView.DividerConfig();
        }
        this.dividerConfig.setVisible(z);
    }

    @Deprecated
    public void setLineVisible(boolean z) {
        setDividerVisible(z);
    }

    @Deprecated
    public void setLineColor(int i) {
        setDividerColor(i);
    }

    public void setDividerColor(int i) {
        if (this.dividerConfig == null) {
            this.dividerConfig = new WheelView.DividerConfig();
        }
        this.dividerConfig.setVisible(true);
        this.dividerConfig.setColor(i);
    }

    public void setDividerRatio(float f) {
        if (this.dividerConfig == null) {
            this.dividerConfig = new WheelView.DividerConfig();
        }
        this.dividerConfig.setRatio(f);
    }

    public void setDividerConfig(WheelView.DividerConfig dividerConfig) {
        if (dividerConfig == null) {
            WheelView.DividerConfig dividerConfig2 = new WheelView.DividerConfig();
            this.dividerConfig = dividerConfig2;
            dividerConfig2.setVisible(false);
            this.dividerConfig.setShadowVisible(false);
            return;
        }
        this.dividerConfig = dividerConfig;
    }

    @Deprecated
    public void setLineConfig(WheelView.DividerConfig dividerConfig) {
        setDividerConfig(dividerConfig);
    }

    public void setOffset(int i) {
        this.offset = i;
    }

    public void setCycleDisable(boolean z) {
        this.cycleDisable = z;
    }

    public void setUseWeight(boolean z) {
        this.useWeight = z;
    }

    public void setTextSizeAutoFit(boolean z) {
        this.textSizeAutoFit = z;
    }

    @Override // com.alipay.mobile.verifyidentity.business.securitycommon.widget.BasicPopup
    public View getContentView() {
        if (this.centerView == null) {
            this.centerView = makeCenterView();
        }
        return this.centerView;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public WheelView createWheelView() {
        WheelView wheelView = new WheelView(this.activity);
        wheelView.setLineSpaceMultiplier(this.lineSpaceMultiplier);
        wheelView.setTextPadding(this.textPadding);
        wheelView.setTextSize(this.textSize);
        wheelView.setTypeface(this.typeface);
        wheelView.setTextColor(this.textColorNormal, this.textColorFocus);
        wheelView.setDividerConfig(this.dividerConfig);
        wheelView.setOffset(this.offset);
        wheelView.setCycleDisable(this.cycleDisable);
        wheelView.setUseWeight(this.useWeight);
        wheelView.setTextSizeAutoFit(this.textSizeAutoFit);
        return wheelView;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public TextView createLabelView() {
        TextView textView = new TextView(this.activity);
        textView.setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
        textView.setTextColor(this.labelTextColor);
        textView.setTextSize(this.textSize);
        return textView;
    }
}
