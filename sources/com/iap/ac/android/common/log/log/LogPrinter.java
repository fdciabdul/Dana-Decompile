package com.iap.ac.android.common.log.log;

import com.fullstory.instrumentation.InstrumentInjector;

/* loaded from: classes3.dex */
public class LogPrinter implements ILogPrinter {
    @Override // com.iap.ac.android.common.log.log.ILogPrinter
    public int doPrint(int i, String str, String str2) {
        if (i != 2) {
            if (i != 3) {
                if (i != 4) {
                    if (i != 5) {
                        if (i != 6) {
                            return InstrumentInjector.log_i(str, str2);
                        }
                        return InstrumentInjector.log_e(str, str2);
                    }
                    return InstrumentInjector.log_w(str, str2);
                }
                return InstrumentInjector.log_i(str, str2);
            }
            return InstrumentInjector.log_d(str, str2);
        }
        return InstrumentInjector.log_v(str, str2);
    }

    @Override // com.iap.ac.android.common.log.log.ILogPrinter
    public int doPrint(int i, String str, String str2, Throwable th) {
        if (i != 2) {
            if (i != 3) {
                if (i != 4) {
                    if (i != 5) {
                        if (i != 6) {
                            return InstrumentInjector.log_i(str, str2, th);
                        }
                        return InstrumentInjector.log_e(str, str2, th);
                    } else if (str2 == null) {
                        return InstrumentInjector.log_w(str, th);
                    } else {
                        return InstrumentInjector.log_w(str, str2, th);
                    }
                }
                return InstrumentInjector.log_i(str, str2, th);
            }
            return InstrumentInjector.log_d(str, str2, th);
        }
        return InstrumentInjector.log_v(str, str2, th);
    }
}
