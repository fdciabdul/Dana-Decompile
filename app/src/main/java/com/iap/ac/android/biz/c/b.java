package com.iap.ac.android.biz.c;

import android.app.Activity;
import android.text.TextUtils;
import com.alipay.ac.pa.SCPMCompositeCodeUIService;
import com.alipay.iap.android.f2fpay.paymentcode.F2FPaymentCodeInfo;
import com.alipay.iap.android.f2fpay.widgets.data.IF2FPaymentCodeStateChangedListener;
import com.alipay.iap.android.f2fpay.widgets.data.PaymentCodeState;
import com.alipay.iap.android.f2fpay.widgets.widget.F2FPayCompositePaymentCodeView;
import com.iap.ac.android.biz.common.callback.IPaymentCodeListener;
import com.iap.ac.android.biz.common.constants.Constants;
import com.iap.ac.android.biz.cpm.CpmManager;
import com.iap.ac.android.biz.cpm.CpmOption;
import com.iap.ac.android.biz.internal.IAPConnectRoute;
import com.iap.ac.android.common.log.ACLog;

/* loaded from: classes8.dex */
public class b implements CpmManager, IPaymentCodeListener {

    /* renamed from: a  reason: collision with root package name */
    public com.iap.ac.android.biz.c.a f7544a;
    public c b;
    public CpmManager c;
    public F2FPayCompositePaymentCodeView d;
    public IPaymentCodeListener e;

    /* loaded from: classes8.dex */
    public class a implements IF2FPaymentCodeStateChangedListener {
        public a(b bVar) {
        }

        @Override // com.alipay.iap.android.f2fpay.widgets.data.IF2FPaymentCodeStateChangedListener
        public void onPaymentCodeStateChanged(PaymentCodeState paymentCodeState) {
        }
    }

    public CpmManager a(CpmOption cpmOption) {
        synchronized (this) {
            if (this.f7544a == null) {
                this.f7544a = new com.iap.ac.android.biz.c.a();
            }
            if (this.b == null) {
                this.b = new c();
            }
            updateOption(cpmOption);
        }
        return this;
    }

    @Override // com.iap.ac.android.biz.cpm.CpmManager
    public F2FPayCompositePaymentCodeView buildCompositePaymentCodeView(Activity activity) {
        F2FPayCompositePaymentCodeView buildCompositePaymentCodeView;
        synchronized (this) {
            this.d = null;
            buildCompositePaymentCodeView = new SCPMCompositeCodeUIService().buildCompositePaymentCodeView(activity, new a(this));
            this.d = buildCompositePaymentCodeView;
        }
        return buildCompositePaymentCodeView;
    }

    @Override // com.iap.ac.android.biz.cpm.CpmManager
    public void getPaymentCode() {
        synchronized (this) {
            this.c.getPaymentCode();
        }
    }

    @Override // com.iap.ac.android.biz.common.callback.IPaymentCodeListener
    public void onPaymentCodeUpdateFailed(String str, String str2) {
        StringBuilder sb = new StringBuilder();
        sb.append("IAPConnectPaymentImpl, onPaymentCodeUpdatedFailed: ");
        sb.append(str);
        sb.append(", msg: ");
        sb.append(str2);
        ACLog.d(Constants.TAG, sb.toString());
        IPaymentCodeListener iPaymentCodeListener = this.e;
        if (iPaymentCodeListener != null) {
            iPaymentCodeListener.onPaymentCodeUpdateFailed(str, str2);
        }
        F2FPayCompositePaymentCodeView f2FPayCompositePaymentCodeView = this.d;
        if (f2FPayCompositePaymentCodeView != null) {
            f2FPayCompositePaymentCodeView.generatePaymentCodeFailed();
        }
    }

    @Override // com.iap.ac.android.biz.common.callback.IPaymentCodeListener
    public void onPaymentCodeUpdated(String str) {
        int length;
        StringBuilder sb = new StringBuilder();
        sb.append("IAPConnectPaymentImpl, onPaymentCodeUpdated: ");
        sb.append(str);
        ACLog.d(Constants.TAG, sb.toString());
        IPaymentCodeListener iPaymentCodeListener = this.e;
        if (iPaymentCodeListener != null) {
            iPaymentCodeListener.onPaymentCodeUpdated(str);
        }
        F2FPayCompositePaymentCodeView f2FPayCompositePaymentCodeView = this.d;
        if (f2FPayCompositePaymentCodeView != null) {
            String str2 = null;
            if (!TextUtils.isEmpty(str) && (length = str.length()) >= 6) {
                str2 = str.substring(length - 6);
            }
            f2FPayCompositePaymentCodeView.updatePaymentCode(new F2FPaymentCodeInfo(str, str2));
        }
    }

    @Override // com.iap.ac.android.biz.cpm.CpmManager
    public void startRefreshPaymentCode() {
        synchronized (this) {
            this.c.startRefreshPaymentCode();
        }
    }

    @Override // com.iap.ac.android.biz.cpm.CpmManager
    public void stopRefreshPaymentCode() {
        synchronized (this) {
            this.c.stopRefreshPaymentCode();
        }
    }

    @Override // com.iap.ac.android.biz.cpm.CpmManager
    public void updateOption(CpmOption cpmOption) {
        synchronized (this) {
            if (cpmOption == null) {
                cpmOption = new CpmOption();
            }
            IAPConnectRoute.a scenarioTypeByRegion = IAPConnectRoute.getScenarioTypeByRegion(cpmOption.region);
            CpmManager cpmManager = this.b;
            if (scenarioTypeByRegion == IAPConnectRoute.a.AC) {
                cpmManager = this.f7544a;
            }
            CpmManager cpmManager2 = this.c;
            if (cpmManager2 != null && cpmManager2 != cpmManager) {
                cpmManager2.stopRefreshPaymentCode();
            }
            this.c = cpmManager;
            this.e = cpmOption.listener;
            cpmOption.listener = this;
            this.c.updateOption(cpmOption);
        }
    }
}
