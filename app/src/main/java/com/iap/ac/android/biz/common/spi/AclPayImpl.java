package com.iap.ac.android.biz.common.spi;

import android.text.TextUtils;
import com.alipay.iap.android.wallet.acl.base.Callback;
import com.alipay.iap.android.wallet.acl.payment.PaymentRequest;
import com.alipay.iap.android.wallet.acl.payment.PaymentResult;
import com.alipay.iap.android.wallet.acl.payment.PaymentService;
import com.alipay.iap.android.wallet.acl.payment.PaymentType;
import com.iap.ac.android.biz.accommon.a.a;
import com.iap.ac.android.biz.common.callback.IPayCallback;
import com.iap.ac.android.biz.common.model.PayResult;
import com.iap.ac.android.biz.common.model.PayResultCode;
import com.iap.ac.android.biz.common.model.acl.AclAPIContext;

/* loaded from: classes3.dex */
public class AclPayImpl extends AclBaseImpl {
    public PaymentService mPaymentService;

    public AclPayImpl() {
        if (isAclAvailable()) {
            this.mPaymentService = (PaymentService) getAclService(PaymentService.class);
        }
    }

    public void pay(String str, String str2, AclAPIContext aclAPIContext, final IPayCallback iPayCallback) {
        PaymentRequest paymentRequest;
        if (this.mPaymentService != null) {
            if (!TextUtils.isEmpty(str)) {
                paymentRequest = new PaymentRequest(PaymentType.CASHIER_URL, str, null, null);
            } else {
                paymentRequest = new PaymentRequest(PaymentType.ORDER_ID, str2, null, null);
            }
            this.mPaymentService.pay(paymentRequest, APIContextFactory.convertToAPIContext(aclAPIContext), new Callback<PaymentResult>() { // from class: com.iap.ac.android.biz.common.spi.AclPayImpl.1
                @Override // com.alipay.iap.android.wallet.acl.base.Callback
                public void result(PaymentResult paymentResult) {
                    if (paymentResult == null) {
                        paymentResult = new PaymentResult();
                        paymentResult.setResultCode("4000");
                        paymentResult.setResultMessage("paymentResult null from acl");
                    }
                    PayResult payResult = new PayResult();
                    String resultCode = paymentResult.getResultCode();
                    resultCode.hashCode();
                    char c = 65535;
                    int hashCode = resultCode.hashCode();
                    if (hashCode != 1656379) {
                        if (hashCode != 1715960) {
                            if (hashCode == 1745751 && resultCode.equals("9000")) {
                                c = 2;
                            }
                        } else if (resultCode.equals("8000")) {
                            c = 1;
                        }
                    } else if (resultCode.equals("6001")) {
                        c = 0;
                    }
                    if (c == 0) {
                        payResult.setResultCode("USER_CANCEL");
                    } else if (c == 1) {
                        payResult.setResultCode(PayResultCode.PAY_PENDING);
                    } else if (c != 2) {
                        payResult.setResultCode(PayResultCode.PAY_FAILURE);
                    } else {
                        payResult.setResultCode(PayResultCode.PAY_SUCCESS);
                    }
                    payResult.setResultMessage(paymentResult.getResultMessage());
                    IPayCallback iPayCallback2 = iPayCallback;
                    if (iPayCallback2 != null) {
                        iPayCallback2.onResult(payResult);
                    }
                }
            });
            return;
        }
        StringBuilder a2 = a.a("implementation of ACL cannot be found, isAclAvailable: ");
        a2.append(isAclAvailable());
        handleForAclCallError("pay", a2.toString());
        if (iPayCallback != null) {
            PayResult payResult = new PayResult();
            payResult.setResultCode(PayResultCode.PAY_FAILURE);
            payResult.setResultMessage("Oops! System busy. Try again later!");
            iPayCallback.onResult(payResult);
        }
    }
}
