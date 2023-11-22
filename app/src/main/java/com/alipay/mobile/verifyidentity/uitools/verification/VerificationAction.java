package com.alipay.mobile.verifyidentity.uitools.verification;

/* loaded from: classes7.dex */
public interface VerificationAction {

    /* loaded from: classes7.dex */
    public interface OnVerificationCodeChangedListener {
        void onInputCompleted(CharSequence charSequence);

        void onVerCodeChanged(CharSequence charSequence, int i, int i2, int i3);
    }

    void setBottomLineHeight(int i);

    void setBottomNormalColor(int i);

    void setBottomSelectedColor(int i);

    void setFigures(int i);

    void setOnVerificationCodeChangedListener(OnVerificationCodeChangedListener onVerificationCodeChangedListener);

    void setSelectedBackgroundColor(int i);

    void setVerCodeMargin(int i);
}
