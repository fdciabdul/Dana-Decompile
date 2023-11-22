package com.alipay.iap.android.f2fpay.extension.impl;

import android.content.Context;
import android.text.TextUtils;
import com.alipay.iap.android.common.log.LoggerWrapper;
import com.alipay.iap.android.f2fpay.common.F2FPayConstants;
import com.alipay.iap.android.f2fpay.extension.IF2FPayPaymentCodeGenerator;
import com.alipay.iap.android.f2fpay.otp.F2FPayOtpInfo;
import com.alipay.iap.android.f2fpay.util.CGCPUtils;
import com.alipay.secotp.SecOtpException;

/* loaded from: classes3.dex */
public class DefaultPaymentCodeGeneratorImpl implements IF2FPayPaymentCodeGenerator {

    /* renamed from: a  reason: collision with root package name */
    private Parameters f6965a;

    /* loaded from: classes3.dex */
    public static class Parameters {
        public String businessType;
        public String institutionCode;
        public int version;

        public Parameters() {
            this.version = 1;
            this.institutionCode = "012";
            this.businessType = "02";
        }

        public Parameters(String str) {
            this.version = 1;
            this.businessType = "02";
            this.institutionCode = str;
        }

        public Parameters(String str, String str2) {
            this.version = 1;
            this.institutionCode = str;
            this.businessType = str2;
        }
    }

    public DefaultPaymentCodeGeneratorImpl() {
        this(new Parameters());
    }

    public DefaultPaymentCodeGeneratorImpl(Parameters parameters) {
        this.f6965a = parameters;
    }

    @Override // com.alipay.iap.android.f2fpay.extension.IF2FPayPaymentCodeGenerator
    public void clear() {
        SecOtpGeneratorManager.getInstance().getGenerator().checkConfigure("f2fpay");
    }

    @Override // com.alipay.iap.android.f2fpay.extension.IF2FPayPaymentCodeGenerator
    public String generateCode(Context context, F2FPayOtpInfo f2FPayOtpInfo, long j, Object obj) {
        SecOtpGeneratorManager.getInstance().initialize(context);
        if (f2FPayOtpInfo == null) {
            return null;
        }
        String obj2 = obj != null ? obj.toString() : "";
        try {
            String generatePayCode = SecOtpGeneratorManager.getInstance().getGenerator().generatePayCode("f2fpay", obj2, j);
            LoggerWrapper.i(F2FPayConstants.TAG, String.format("generateCode: otpInfo = %s, timestamp = %d, payCode = %s, extra=%s", f2FPayOtpInfo.toString(), Long.valueOf(j), generatePayCode, obj2));
            if (TextUtils.isEmpty(generatePayCode) || !TextUtils.isDigitsOnly(generatePayCode)) {
                return null;
            }
            Parameters parameters = this.f6965a;
            String generateCGCP = CGCPUtils.generateCGCP(parameters.version, parameters.institutionCode, parameters.businessType, generatePayCode);
            StringBuilder sb = new StringBuilder();
            sb.append("CGCP code:");
            sb.append(generateCGCP);
            LoggerWrapper.i(F2FPayConstants.TAG, sb.toString());
            return generateCGCP;
        } catch (SecOtpException unused) {
            LoggerWrapper.e(F2FPayConstants.TAG, "secure otp generator generates failed");
            return null;
        }
    }
}
