package io.split.android.client.utils.logger;

import com.fullstory.instrumentation.InstrumentInjector;

/* loaded from: classes6.dex */
public class LogPrinterImpl implements LogPrinter {
    @Override // io.split.android.client.utils.logger.LogPrinter
    public void wtf(String str, String str2, Throwable th) {
    }

    @Override // io.split.android.client.utils.logger.LogPrinter
    public void v(String str, String str2, Throwable th) {
        InstrumentInjector.log_v(str, str2);
    }

    @Override // io.split.android.client.utils.logger.LogPrinter
    public void d(String str, String str2, Throwable th) {
        InstrumentInjector.log_d(str, str2, th);
    }

    @Override // io.split.android.client.utils.logger.LogPrinter
    public void i(String str, String str2, Throwable th) {
        InstrumentInjector.log_i(str, str2, th);
    }

    @Override // io.split.android.client.utils.logger.LogPrinter
    public void w(String str, String str2, Throwable th) {
        InstrumentInjector.log_w(str, str2, th);
    }

    @Override // io.split.android.client.utils.logger.LogPrinter
    public void e(String str, String str2, Throwable th) {
        InstrumentInjector.log_e(str, str2, th);
    }
}
