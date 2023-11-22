package com.alipay.iap.android.f2fpay.client.callback;

/* loaded from: classes3.dex */
public interface IF2FPayOpenCallback {

    /* loaded from: classes3.dex */
    public static class Adapter implements IF2FPayOpenCallback {
        @Override // com.alipay.iap.android.f2fpay.client.callback.IF2FPayOpenCallback
        public void onSwitchOffFailed(String str) {
        }

        @Override // com.alipay.iap.android.f2fpay.client.callback.IF2FPayOpenCallback
        public void onSwitchOnCanceled() {
        }

        @Override // com.alipay.iap.android.f2fpay.client.callback.IF2FPayOpenCallback
        public void onSwitchOnFailed(String str) {
        }

        @Override // com.alipay.iap.android.f2fpay.client.callback.IF2FPayOpenCallback
        public void onSwitchStatusChanged(boolean z, StatusChangeCausedBy statusChangeCausedBy) {
        }
    }

    /* loaded from: classes3.dex */
    public enum StatusChangeCausedBy {
        CheckOpen,
        SwitchOn,
        SwitchOff
    }

    void onSwitchOffFailed(String str);

    void onSwitchOnCanceled();

    void onSwitchOnFailed(String str);

    void onSwitchStatusChanged(boolean z, StatusChangeCausedBy statusChangeCausedBy);
}
