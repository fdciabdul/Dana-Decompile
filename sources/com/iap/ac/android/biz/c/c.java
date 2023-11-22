package com.iap.ac.android.biz.c;

import android.app.Activity;
import com.alipay.ac.pa.SCPMGenCodeService;
import com.alipay.ac.pa.SCPMInitService;
import com.alipay.iap.android.f2fpay.widgets.widget.F2FPayCompositePaymentCodeView;
import com.iap.ac.android.biz.common.callback.IPaymentCodeListener;
import com.iap.ac.android.biz.common.constants.Constants;
import com.iap.ac.android.biz.common.utils.Utils;
import com.iap.ac.android.biz.common.utils.log.ACLogEvent;
import com.iap.ac.android.biz.common.utils.log.LogConstants;
import com.iap.ac.android.biz.cpm.CpmManager;
import com.iap.ac.android.biz.cpm.CpmOption;
import com.iap.ac.android.common.log.ACLog;

/* loaded from: classes8.dex */
public class c implements CpmManager, SCPMGenCodeService.IAPConnectPaymentCodeListener {

    /* renamed from: a  reason: collision with root package name */
    public SCPMInitService f7545a;
    public SCPMGenCodeService b;
    public IPaymentCodeListener c;

    public c() {
        if (Utils.checkClassExist(Constants.PACKAGE_NAME_PA_CORE_MANAGER)) {
            ACLog.i(Constants.TAG, "PaCpmManager initialize SCPMInitService and SCPMGenCodeService");
            this.f7545a = SCPMInitService.getInstance();
            SCPMGenCodeService sCPMGenCodeService = new SCPMGenCodeService();
            this.b = sCPMGenCodeService;
            sCPMGenCodeService.setPaymentCodeListener(this);
        }
    }

    @Override // com.iap.ac.android.biz.cpm.CpmManager
    public F2FPayCompositePaymentCodeView buildCompositePaymentCodeView(Activity activity) {
        return null;
    }

    @Override // com.iap.ac.android.biz.cpm.CpmManager
    public void getPaymentCode() {
        SCPMGenCodeService sCPMGenCodeService = this.b;
        if (sCPMGenCodeService != null) {
            try {
                sCPMGenCodeService.getPaymentCode();
                return;
            } catch (Throwable th) {
                StringBuilder sb = new StringBuilder();
                sb.append("getPaymentCode exception: ");
                sb.append(th);
                ACLogEvent.crucialEvent("iapconnect_center", LogConstants.EVENT_ID_PA_CALL_FAIL, sb.toString());
                return;
            }
        }
        ACLogEvent.crucialEvent("iapconnect_center", LogConstants.EVENT_ID_PA_CALL_FAIL, "getPaymentCode error: scpmGenCodeService is null");
    }

    public void onPaymentCodeUpdateFailed(String str, String str2) {
        IPaymentCodeListener iPaymentCodeListener = this.c;
        if (iPaymentCodeListener != null) {
            iPaymentCodeListener.onPaymentCodeUpdateFailed(str, str2);
        }
    }

    public void onPaymentCodeUpdated(String str) {
        IPaymentCodeListener iPaymentCodeListener = this.c;
        if (iPaymentCodeListener != null) {
            iPaymentCodeListener.onPaymentCodeUpdated(str);
        }
    }

    @Override // com.iap.ac.android.biz.cpm.CpmManager
    public void startRefreshPaymentCode() {
        SCPMGenCodeService sCPMGenCodeService = this.b;
        if (sCPMGenCodeService != null) {
            try {
                sCPMGenCodeService.startRefreshPaymentCode();
                return;
            } catch (Throwable th) {
                StringBuilder sb = new StringBuilder();
                sb.append("startRefreshPaymentCode exception: ");
                sb.append(th);
                ACLogEvent.crucialEvent("iapconnect_center", LogConstants.EVENT_ID_PA_CALL_FAIL, sb.toString());
                return;
            }
        }
        ACLogEvent.crucialEvent("iapconnect_center", LogConstants.EVENT_ID_PA_CALL_FAIL, "startRefreshPaymentCode error: scpmGenCodeService is null");
    }

    @Override // com.iap.ac.android.biz.cpm.CpmManager
    public void stopRefreshPaymentCode() {
        SCPMGenCodeService sCPMGenCodeService = this.b;
        if (sCPMGenCodeService != null) {
            try {
                sCPMGenCodeService.stopRefreshCode();
                return;
            } catch (Throwable th) {
                StringBuilder sb = new StringBuilder();
                sb.append("stopRefreshPaymentCode exception: ");
                sb.append(th);
                ACLogEvent.crucialEvent("iapconnect_center", LogConstants.EVENT_ID_PA_CALL_FAIL, sb.toString());
                return;
            }
        }
        ACLogEvent.crucialEvent("iapconnect_center", LogConstants.EVENT_ID_PA_CALL_FAIL, "stopRefreshPaymentCode error: scpmGenCodeService is null");
    }

    @Override // com.iap.ac.android.biz.cpm.CpmManager
    public void updateOption(CpmOption cpmOption) {
        if (cpmOption != null) {
            this.c = cpmOption.listener;
            SCPMInitService sCPMInitService = this.f7545a;
            if (sCPMInitService != null) {
                sCPMInitService.setupWithInstitutionId(cpmOption.institutionId, cpmOption.extendInfo);
            }
        }
    }
}
