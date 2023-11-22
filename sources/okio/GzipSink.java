package okio;

import java.io.IOException;
import java.util.zip.CRC32;
import java.util.zip.Deflater;

/* loaded from: classes6.dex */
public final class GzipSink implements Sink {
    private final Deflater BuiltInFictitiousFunctionClassFactory;
    private final DeflaterSink KClassImpl$Data$declaredNonStaticMembers$2;
    private boolean MyBillsEntityDataFactory;
    private final CRC32 PlaceComponentResult = new CRC32();
    private final BufferedSink getAuthRequestContext;

    public GzipSink(Sink sink) {
        if (sink == null) {
            throw new IllegalArgumentException("sink == null");
        }
        Deflater deflater = new Deflater(-1, true);
        this.BuiltInFictitiousFunctionClassFactory = deflater;
        BufferedSink BuiltInFictitiousFunctionClassFactory = Okio.BuiltInFictitiousFunctionClassFactory(sink);
        this.getAuthRequestContext = BuiltInFictitiousFunctionClassFactory;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = new DeflaterSink(BuiltInFictitiousFunctionClassFactory, deflater);
        Buffer KClassImpl$Data$declaredNonStaticMembers$2 = this.getAuthRequestContext.KClassImpl$Data$declaredNonStaticMembers$2();
        KClassImpl$Data$declaredNonStaticMembers$2.moveToNextValue(8075);
        KClassImpl$Data$declaredNonStaticMembers$2.PlaceComponentResult(8);
        KClassImpl$Data$declaredNonStaticMembers$2.PlaceComponentResult(0);
        KClassImpl$Data$declaredNonStaticMembers$2.BuiltInFictitiousFunctionClassFactory(0);
        KClassImpl$Data$declaredNonStaticMembers$2.PlaceComponentResult(0);
        KClassImpl$Data$declaredNonStaticMembers$2.PlaceComponentResult(0);
    }

    @Override // okio.Sink, java.io.Flushable
    public final void flush() throws IOException {
        this.KClassImpl$Data$declaredNonStaticMembers$2.flush();
    }

    @Override // okio.Sink
    public final Timeout timeout() {
        return this.getAuthRequestContext.timeout();
    }

    @Override // okio.Sink, java.io.Closeable, java.lang.AutoCloseable
    public final void close() throws IOException {
        if (this.MyBillsEntityDataFactory) {
            return;
        }
        Throwable th = null;
        try {
            DeflaterSink deflaterSink = this.KClassImpl$Data$declaredNonStaticMembers$2;
            deflaterSink.MyBillsEntityDataFactory.finish();
            deflaterSink.KClassImpl$Data$declaredNonStaticMembers$2(false);
            this.getAuthRequestContext.scheduleImpl((int) this.PlaceComponentResult.getValue());
            this.getAuthRequestContext.scheduleImpl((int) this.BuiltInFictitiousFunctionClassFactory.getBytesRead());
        } catch (Throwable th2) {
            th = th2;
        }
        try {
            this.BuiltInFictitiousFunctionClassFactory.end();
        } catch (Throwable th3) {
            if (th == null) {
                th = th3;
            }
        }
        try {
            this.getAuthRequestContext.close();
        } catch (Throwable th4) {
            if (th == null) {
                th = th4;
            }
        }
        this.MyBillsEntityDataFactory = true;
        if (th != null) {
            Util.PlaceComponentResult(th);
        }
    }

    @Override // okio.Sink
    public final void write(Buffer buffer, long j) throws IOException {
        if (j < 0) {
            StringBuilder sb = new StringBuilder();
            sb.append("byteCount < 0: ");
            sb.append(j);
            throw new IllegalArgumentException(sb.toString());
        } else if (j == 0) {
        } else {
            Segment segment = buffer.BuiltInFictitiousFunctionClassFactory;
            long j2 = j;
            while (j2 > 0) {
                int min = (int) Math.min(j2, segment.MyBillsEntityDataFactory - segment.PlaceComponentResult);
                this.PlaceComponentResult.update(segment.BuiltInFictitiousFunctionClassFactory, segment.PlaceComponentResult, min);
                j2 -= min;
                segment = segment.getAuthRequestContext;
            }
            this.KClassImpl$Data$declaredNonStaticMembers$2.write(buffer, j);
        }
    }
}
