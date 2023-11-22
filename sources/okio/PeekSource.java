package okio;

import java.io.IOException;

/* loaded from: classes2.dex */
final class PeekSource implements Source {
    private boolean BuiltInFictitiousFunctionClassFactory;
    private long KClassImpl$Data$declaredNonStaticMembers$2;
    private int MyBillsEntityDataFactory;
    private final Buffer PlaceComponentResult;
    private Segment getAuthRequestContext;
    private final BufferedSource moveToNextValue;

    /* JADX INFO: Access modifiers changed from: package-private */
    public PeekSource(BufferedSource bufferedSource) {
        this.moveToNextValue = bufferedSource;
        Buffer KClassImpl$Data$declaredNonStaticMembers$2 = bufferedSource.KClassImpl$Data$declaredNonStaticMembers$2();
        this.PlaceComponentResult = KClassImpl$Data$declaredNonStaticMembers$2;
        Segment segment = KClassImpl$Data$declaredNonStaticMembers$2.BuiltInFictitiousFunctionClassFactory;
        this.getAuthRequestContext = segment;
        this.MyBillsEntityDataFactory = segment != null ? segment.PlaceComponentResult : -1;
    }

    @Override // okio.Source
    public final long read(Buffer buffer, long j) throws IOException {
        if (j < 0) {
            StringBuilder sb = new StringBuilder();
            sb.append("byteCount < 0: ");
            sb.append(j);
            throw new IllegalArgumentException(sb.toString());
        } else if (this.BuiltInFictitiousFunctionClassFactory) {
            throw new IllegalStateException("closed");
        } else {
            Segment segment = this.getAuthRequestContext;
            if (segment == null || (segment == this.PlaceComponentResult.BuiltInFictitiousFunctionClassFactory && this.MyBillsEntityDataFactory == this.PlaceComponentResult.BuiltInFictitiousFunctionClassFactory.PlaceComponentResult)) {
                if (j == 0) {
                    return 0L;
                }
                if (this.moveToNextValue.getErrorConfigVersion(this.KClassImpl$Data$declaredNonStaticMembers$2 + 1)) {
                    if (this.getAuthRequestContext == null && this.PlaceComponentResult.BuiltInFictitiousFunctionClassFactory != null) {
                        this.getAuthRequestContext = this.PlaceComponentResult.BuiltInFictitiousFunctionClassFactory;
                        this.MyBillsEntityDataFactory = this.PlaceComponentResult.BuiltInFictitiousFunctionClassFactory.PlaceComponentResult;
                    }
                    long min = Math.min(j, this.PlaceComponentResult.getAuthRequestContext - this.KClassImpl$Data$declaredNonStaticMembers$2);
                    this.PlaceComponentResult.BuiltInFictitiousFunctionClassFactory(buffer, this.KClassImpl$Data$declaredNonStaticMembers$2, min);
                    this.KClassImpl$Data$declaredNonStaticMembers$2 += min;
                    return min;
                }
                return -1L;
            }
            throw new IllegalStateException("Peek source is invalid because upstream source was used");
        }
    }

    @Override // okio.Source
    public final Timeout timeout() {
        return this.moveToNextValue.timeout();
    }

    @Override // okio.Source, java.io.Closeable, java.lang.AutoCloseable
    public final void close() throws IOException {
        this.BuiltInFictitiousFunctionClassFactory = true;
    }
}
