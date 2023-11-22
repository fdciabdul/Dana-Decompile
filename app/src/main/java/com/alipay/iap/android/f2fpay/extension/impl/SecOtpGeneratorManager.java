package com.alipay.iap.android.f2fpay.extension.impl;

import android.content.Context;
import com.alipay.iap.android.common.log.LoggerWrapper;
import com.alipay.iap.android.f2fpay.common.F2FPayConstants;
import com.alipay.secotp.SecOtpGenerator;
import java.io.File;

/* loaded from: classes3.dex */
public class SecOtpGeneratorManager {
    private static SecOtpGeneratorManager c;

    /* renamed from: a  reason: collision with root package name */
    private SecOtpGenerator f6967a = SecOtpGenerator.getInstance();
    private boolean b;

    private SecOtpGeneratorManager() {
    }

    public static SecOtpGeneratorManager getInstance() {
        if (c == null) {
            c = new SecOtpGeneratorManager();
        }
        return c;
    }

    public SecOtpGenerator getGenerator() {
        return this.f6967a;
    }

    public void initialize(Context context) {
        if (this.b) {
            return;
        }
        File file = new File(context.getFilesDir(), "otp_storage");
        if (!file.exists()) {
            try {
                file.mkdirs();
            } catch (Exception e) {
                LoggerWrapper.e(F2FPayConstants.TAG, "initialize", e);
                return;
            }
        }
        String absolutePath = file.getAbsolutePath();
        boolean z = false;
        try {
            if (this.f6967a.initialize(absolutePath) >= 0) {
                z = true;
            }
        } catch (Exception e2) {
            StringBuilder sb = new StringBuilder();
            sb.append("initialize failed with exception ");
            sb.append(e2.getMessage());
            LoggerWrapper.e(F2FPayConstants.TAG, sb.toString());
        }
        if (!z) {
            LoggerWrapper.w(F2FPayConstants.TAG, "initialize final failed ");
            return;
        }
        this.b = true;
        LoggerWrapper.i(F2FPayConstants.TAG, "initialize final success ");
    }
}
