package androidx.fragment.app;

import com.fullstory.instrumentation.InstrumentInjector;
import java.io.Writer;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class LogWriter extends Writer {
    private StringBuilder KClassImpl$Data$declaredNonStaticMembers$2 = new StringBuilder(128);
    private final String PlaceComponentResult;

    /* JADX INFO: Access modifiers changed from: package-private */
    public LogWriter(String str) {
        this.PlaceComponentResult = str;
    }

    @Override // java.io.Writer, java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        MyBillsEntityDataFactory();
    }

    @Override // java.io.Writer, java.io.Flushable
    public final void flush() {
        MyBillsEntityDataFactory();
    }

    @Override // java.io.Writer
    public final void write(char[] cArr, int i, int i2) {
        for (int i3 = 0; i3 < i2; i3++) {
            char c = cArr[i + i3];
            if (c == '\n') {
                MyBillsEntityDataFactory();
            } else {
                this.KClassImpl$Data$declaredNonStaticMembers$2.append(c);
            }
        }
    }

    private void MyBillsEntityDataFactory() {
        if (this.KClassImpl$Data$declaredNonStaticMembers$2.length() > 0) {
            InstrumentInjector.log_d(this.PlaceComponentResult, this.KClassImpl$Data$declaredNonStaticMembers$2.toString());
            StringBuilder sb = this.KClassImpl$Data$declaredNonStaticMembers$2;
            sb.delete(0, sb.length());
        }
    }
}
