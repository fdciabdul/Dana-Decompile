package com.alipay.mobile.verifyidentity.adapterapi.log;

import com.fullstory.instrumentation.InstrumentInjector;

/* loaded from: classes3.dex */
public class NormalLog implements ILog {
    @Override // com.alipay.mobile.verifyidentity.adapterapi.log.ILog
    public int v(String str, String str2) {
        return InstrumentInjector.log_v(str, str2);
    }

    @Override // com.alipay.mobile.verifyidentity.adapterapi.log.ILog
    public int d(String str, String str2) {
        return InstrumentInjector.log_d(str, str2);
    }

    @Override // com.alipay.mobile.verifyidentity.adapterapi.log.ILog
    public int i(String str, String str2) {
        return InstrumentInjector.log_i(str, str2);
    }

    @Override // com.alipay.mobile.verifyidentity.adapterapi.log.ILog
    public int w(String str, String str2) {
        return InstrumentInjector.log_w(str, str2);
    }

    @Override // com.alipay.mobile.verifyidentity.adapterapi.log.ILog
    public int e(String str, String str2) {
        return InstrumentInjector.log_e(str, str2);
    }
}
