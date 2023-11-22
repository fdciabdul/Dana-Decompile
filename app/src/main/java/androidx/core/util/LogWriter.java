package androidx.core.util;

import com.fullstory.instrumentation.InstrumentInjector;
import java.io.Writer;

@Deprecated
/* loaded from: classes6.dex */
public class LogWriter extends Writer {
    private final String KClassImpl$Data$declaredNonStaticMembers$2;
    private StringBuilder PlaceComponentResult;

    @Override // java.io.Writer, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        MyBillsEntityDataFactory();
    }

    @Override // java.io.Writer, java.io.Flushable
    public void flush() {
        MyBillsEntityDataFactory();
    }

    @Override // java.io.Writer
    public void write(char[] cArr, int i, int i2) {
        for (int i3 = 0; i3 < i2; i3++) {
            char c = cArr[i + i3];
            if (c == '\n') {
                MyBillsEntityDataFactory();
            } else {
                this.PlaceComponentResult.append(c);
            }
        }
    }

    private void MyBillsEntityDataFactory() {
        if (this.PlaceComponentResult.length() > 0) {
            InstrumentInjector.log_d(this.KClassImpl$Data$declaredNonStaticMembers$2, this.PlaceComponentResult.toString());
            StringBuilder sb = this.PlaceComponentResult;
            sb.delete(0, sb.length());
        }
    }
}
