package com.iap.ac.android.biz.c;

import android.app.Activity;
import com.alipay.iap.android.f2fpay.widgets.widget.F2FPayCompositePaymentCodeView;
import com.iap.ac.android.biz.IAPConnect;
import com.iap.ac.android.biz.common.callback.IPaymentCodeListener;
import com.iap.ac.android.biz.cpm.CpmManager;
import com.iap.ac.android.biz.cpm.CpmOption;

/* loaded from: classes8.dex */
public class a implements CpmManager {

    /* renamed from: a  reason: collision with root package name */
    public String f7543a;
    public IPaymentCodeListener b;

    @Override // com.iap.ac.android.biz.cpm.CpmManager
    public F2FPayCompositePaymentCodeView buildCompositePaymentCodeView(Activity activity) {
        return null;
    }

    @Override // com.iap.ac.android.biz.cpm.CpmManager
    public void getPaymentCode() {
        synchronized (this) {
            IAPConnect.getPaymentCode(this.f7543a, this.b);
        }
    }

    @Override // com.iap.ac.android.biz.cpm.CpmManager
    public void startRefreshPaymentCode() {
        synchronized (this) {
            IAPConnect.getPaymentCode(this.f7543a, this.b);
        }
    }

    @Override // com.iap.ac.android.biz.cpm.CpmManager
    public void stopRefreshPaymentCode() {
    }

    @Override // com.iap.ac.android.biz.cpm.CpmManager
    public void updateOption(CpmOption cpmOption) {
        if (cpmOption != null) {
            this.f7543a = cpmOption.region;
            this.b = cpmOption.listener;
            return;
        }
        this.f7543a = null;
        this.b = null;
    }
}
