package okio;

import java.io.IOException;
import java.util.zip.Deflater;

/* loaded from: classes6.dex */
public final class DeflaterSink implements Sink {
    private final BufferedSink BuiltInFictitiousFunctionClassFactory;
    final Deflater MyBillsEntityDataFactory;
    private boolean PlaceComponentResult;

    /* JADX INFO: Access modifiers changed from: package-private */
    public DeflaterSink(BufferedSink bufferedSink, Deflater deflater) {
        if (bufferedSink == null) {
            throw new IllegalArgumentException("source == null");
        }
        this.BuiltInFictitiousFunctionClassFactory = bufferedSink;
        this.MyBillsEntityDataFactory = deflater;
    }

    @Override // okio.Sink
    public final void write(Buffer buffer, long j) throws IOException {
        Util.MyBillsEntityDataFactory(buffer.getAuthRequestContext, 0L, j);
        while (j > 0) {
            Segment segment = buffer.BuiltInFictitiousFunctionClassFactory;
            int min = (int) Math.min(j, segment.MyBillsEntityDataFactory - segment.PlaceComponentResult);
            this.MyBillsEntityDataFactory.setInput(segment.BuiltInFictitiousFunctionClassFactory, segment.PlaceComponentResult, min);
            KClassImpl$Data$declaredNonStaticMembers$2(false);
            long j2 = min;
            buffer.getAuthRequestContext -= j2;
            segment.PlaceComponentResult += min;
            if (segment.PlaceComponentResult == segment.MyBillsEntityDataFactory) {
                buffer.BuiltInFictitiousFunctionClassFactory = segment.MyBillsEntityDataFactory();
                SegmentPool.getAuthRequestContext(segment);
            }
            j -= j2;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void KClassImpl$Data$declaredNonStaticMembers$2(boolean z) throws IOException {
        Segment MyBillsEntityDataFactory;
        int deflate;
        Buffer KClassImpl$Data$declaredNonStaticMembers$2 = this.BuiltInFictitiousFunctionClassFactory.KClassImpl$Data$declaredNonStaticMembers$2();
        while (true) {
            MyBillsEntityDataFactory = KClassImpl$Data$declaredNonStaticMembers$2.MyBillsEntityDataFactory(1);
            if (z) {
                deflate = this.MyBillsEntityDataFactory.deflate(MyBillsEntityDataFactory.BuiltInFictitiousFunctionClassFactory, MyBillsEntityDataFactory.MyBillsEntityDataFactory, 8192 - MyBillsEntityDataFactory.MyBillsEntityDataFactory, 2);
            } else {
                deflate = this.MyBillsEntityDataFactory.deflate(MyBillsEntityDataFactory.BuiltInFictitiousFunctionClassFactory, MyBillsEntityDataFactory.MyBillsEntityDataFactory, 8192 - MyBillsEntityDataFactory.MyBillsEntityDataFactory);
            }
            if (deflate > 0) {
                MyBillsEntityDataFactory.MyBillsEntityDataFactory += deflate;
                KClassImpl$Data$declaredNonStaticMembers$2.getAuthRequestContext += deflate;
                this.BuiltInFictitiousFunctionClassFactory.BuiltInFictitiousFunctionClassFactory();
            } else if (this.MyBillsEntityDataFactory.needsInput()) {
                break;
            }
        }
        if (MyBillsEntityDataFactory.PlaceComponentResult == MyBillsEntityDataFactory.MyBillsEntityDataFactory) {
            KClassImpl$Data$declaredNonStaticMembers$2.BuiltInFictitiousFunctionClassFactory = MyBillsEntityDataFactory.MyBillsEntityDataFactory();
            SegmentPool.getAuthRequestContext(MyBillsEntityDataFactory);
        }
    }

    @Override // okio.Sink, java.io.Flushable
    public final void flush() throws IOException {
        KClassImpl$Data$declaredNonStaticMembers$2(true);
        this.BuiltInFictitiousFunctionClassFactory.flush();
    }

    @Override // okio.Sink, java.io.Closeable, java.lang.AutoCloseable
    public final void close() throws IOException {
        if (this.PlaceComponentResult) {
            return;
        }
        Throwable th = null;
        try {
            this.MyBillsEntityDataFactory.finish();
            KClassImpl$Data$declaredNonStaticMembers$2(false);
        } catch (Throwable th2) {
            th = th2;
        }
        try {
            this.MyBillsEntityDataFactory.end();
        } catch (Throwable th3) {
            if (th == null) {
                th = th3;
            }
        }
        try {
            this.BuiltInFictitiousFunctionClassFactory.close();
        } catch (Throwable th4) {
            if (th == null) {
                th = th4;
            }
        }
        this.PlaceComponentResult = true;
        if (th != null) {
            Util.PlaceComponentResult(th);
        }
    }

    @Override // okio.Sink
    public final Timeout timeout() {
        return this.BuiltInFictitiousFunctionClassFactory.timeout();
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("DeflaterSink(");
        sb.append(this.BuiltInFictitiousFunctionClassFactory);
        sb.append(")");
        return sb.toString();
    }
}
