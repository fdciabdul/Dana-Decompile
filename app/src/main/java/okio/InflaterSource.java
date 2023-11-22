package okio;

import java.io.EOFException;
import java.io.IOException;
import java.util.zip.DataFormatException;
import java.util.zip.Inflater;

/* loaded from: classes6.dex */
public final class InflaterSource implements Source {
    private boolean BuiltInFictitiousFunctionClassFactory;
    private int MyBillsEntityDataFactory;
    private final Inflater PlaceComponentResult;
    private final BufferedSource getAuthRequestContext;

    /* JADX INFO: Access modifiers changed from: package-private */
    public InflaterSource(BufferedSource bufferedSource, Inflater inflater) {
        if (bufferedSource == null) {
            throw new IllegalArgumentException("source == null");
        }
        this.getAuthRequestContext = bufferedSource;
        this.PlaceComponentResult = inflater;
    }

    @Override // okio.Source
    public final long read(Buffer buffer, long j) throws IOException {
        boolean authRequestContext;
        if (j < 0) {
            StringBuilder sb = new StringBuilder();
            sb.append("byteCount < 0: ");
            sb.append(j);
            throw new IllegalArgumentException(sb.toString());
        } else if (this.BuiltInFictitiousFunctionClassFactory) {
            throw new IllegalStateException("closed");
        } else {
            if (j == 0) {
                return 0L;
            }
            do {
                authRequestContext = getAuthRequestContext();
                try {
                    Segment MyBillsEntityDataFactory = buffer.MyBillsEntityDataFactory(1);
                    int inflate = this.PlaceComponentResult.inflate(MyBillsEntityDataFactory.BuiltInFictitiousFunctionClassFactory, MyBillsEntityDataFactory.MyBillsEntityDataFactory, (int) Math.min(j, 8192 - MyBillsEntityDataFactory.MyBillsEntityDataFactory));
                    if (inflate > 0) {
                        MyBillsEntityDataFactory.MyBillsEntityDataFactory += inflate;
                        long j2 = inflate;
                        buffer.getAuthRequestContext += j2;
                        return j2;
                    }
                    if (!this.PlaceComponentResult.finished() && !this.PlaceComponentResult.needsDictionary()) {
                    }
                    PlaceComponentResult();
                    if (MyBillsEntityDataFactory.PlaceComponentResult == MyBillsEntityDataFactory.MyBillsEntityDataFactory) {
                        buffer.BuiltInFictitiousFunctionClassFactory = MyBillsEntityDataFactory.MyBillsEntityDataFactory();
                        SegmentPool.getAuthRequestContext(MyBillsEntityDataFactory);
                        return -1L;
                    }
                    return -1L;
                } catch (DataFormatException e) {
                    throw new IOException(e);
                }
            } while (!authRequestContext);
            throw new EOFException("source exhausted prematurely");
        }
    }

    private boolean getAuthRequestContext() throws IOException {
        if (this.PlaceComponentResult.needsInput()) {
            PlaceComponentResult();
            if (this.PlaceComponentResult.getRemaining() != 0) {
                throw new IllegalStateException("?");
            }
            if (this.getAuthRequestContext.lookAheadTest()) {
                return true;
            }
            Segment segment = this.getAuthRequestContext.KClassImpl$Data$declaredNonStaticMembers$2().BuiltInFictitiousFunctionClassFactory;
            this.MyBillsEntityDataFactory = segment.MyBillsEntityDataFactory - segment.PlaceComponentResult;
            this.PlaceComponentResult.setInput(segment.BuiltInFictitiousFunctionClassFactory, segment.PlaceComponentResult, this.MyBillsEntityDataFactory);
            return false;
        }
        return false;
    }

    private void PlaceComponentResult() throws IOException {
        int i = this.MyBillsEntityDataFactory;
        if (i == 0) {
            return;
        }
        int remaining = i - this.PlaceComponentResult.getRemaining();
        this.MyBillsEntityDataFactory -= remaining;
        this.getAuthRequestContext.NetworkUserEntityData$$ExternalSyntheticLambda0(remaining);
    }

    @Override // okio.Source
    public final Timeout timeout() {
        return this.getAuthRequestContext.timeout();
    }

    @Override // okio.Source, java.io.Closeable, java.lang.AutoCloseable
    public final void close() throws IOException {
        if (this.BuiltInFictitiousFunctionClassFactory) {
            return;
        }
        this.PlaceComponentResult.end();
        this.BuiltInFictitiousFunctionClassFactory = true;
        this.getAuthRequestContext.close();
    }
}
