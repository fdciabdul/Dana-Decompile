package com.zoloz.builder.service;

import com.alipay.mobile.security.bio.utils.Logger;
import com.fullstory.instrumentation.InstrumentInjector;

/* loaded from: classes8.dex */
public class ZLZCommonLog extends Logger {
    private boolean log = false;

    public void setLog(boolean z) {
        this.log = z;
    }

    @Override // com.alipay.mobile.security.bio.utils.Logger
    public int verbose(String str, String str2) {
        if (this.log) {
            InstrumentInjector.log_v(str, str2);
            return 0;
        }
        return 0;
    }

    @Override // com.alipay.mobile.security.bio.utils.Logger
    public int debug(String str, String str2) {
        if (this.log) {
            InstrumentInjector.log_d(str, str2);
            return 0;
        }
        return 0;
    }

    @Override // com.alipay.mobile.security.bio.utils.Logger
    public int info(String str, String str2) {
        if (this.log) {
            InstrumentInjector.log_i(str, str2);
            return 0;
        }
        return 0;
    }

    @Override // com.alipay.mobile.security.bio.utils.Logger
    public int warn(String str, String str2) {
        if (this.log) {
            InstrumentInjector.log_w(str, str2);
            return 0;
        }
        return 0;
    }

    @Override // com.alipay.mobile.security.bio.utils.Logger
    public int error(String str, String str2) {
        if (this.log) {
            InstrumentInjector.log_e(str, str2);
            return 0;
        }
        return 0;
    }

    @Override // com.alipay.mobile.security.bio.utils.Logger
    public String getStackTraceString(Throwable th) {
        return th.getMessage();
    }
}
