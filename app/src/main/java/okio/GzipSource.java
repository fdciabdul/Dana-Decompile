package okio;

import java.io.EOFException;
import java.io.IOException;
import java.util.zip.CRC32;
import java.util.zip.Inflater;

/* loaded from: classes6.dex */
public final class GzipSource implements Source {
    private final BufferedSource BuiltInFictitiousFunctionClassFactory;
    private final InflaterSource KClassImpl$Data$declaredNonStaticMembers$2;
    private final Inflater getAuthRequestContext;
    private int PlaceComponentResult = 0;
    private final CRC32 MyBillsEntityDataFactory = new CRC32();

    public GzipSource(Source source) {
        if (source == null) {
            throw new IllegalArgumentException("source == null");
        }
        Inflater inflater = new Inflater(true);
        this.getAuthRequestContext = inflater;
        BufferedSource KClassImpl$Data$declaredNonStaticMembers$2 = Okio.KClassImpl$Data$declaredNonStaticMembers$2(source);
        this.BuiltInFictitiousFunctionClassFactory = KClassImpl$Data$declaredNonStaticMembers$2;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = new InflaterSource(KClassImpl$Data$declaredNonStaticMembers$2, inflater);
    }

    @Override // okio.Source
    public final long read(Buffer buffer, long j) throws IOException {
        long j2;
        if (j < 0) {
            StringBuilder sb = new StringBuilder();
            sb.append("byteCount < 0: ");
            sb.append(j);
            throw new IllegalArgumentException(sb.toString());
        } else if (j == 0) {
            return 0L;
        } else {
            if (this.PlaceComponentResult == 0) {
                this.BuiltInFictitiousFunctionClassFactory.lookAheadTest(10L);
                byte authRequestContext = this.BuiltInFictitiousFunctionClassFactory.KClassImpl$Data$declaredNonStaticMembers$2().getAuthRequestContext(3L);
                boolean z = ((authRequestContext >> 1) & 1) == 1;
                if (z) {
                    MyBillsEntityDataFactory(this.BuiltInFictitiousFunctionClassFactory.KClassImpl$Data$declaredNonStaticMembers$2(), 0L, 10L);
                }
                PlaceComponentResult("ID1ID2", 8075, this.BuiltInFictitiousFunctionClassFactory.NetworkUserEntityData$$ExternalSyntheticLambda8());
                this.BuiltInFictitiousFunctionClassFactory.NetworkUserEntityData$$ExternalSyntheticLambda0(8L);
                if (((authRequestContext >> 2) & 1) == 1) {
                    this.BuiltInFictitiousFunctionClassFactory.lookAheadTest(2L);
                    if (z) {
                        MyBillsEntityDataFactory(this.BuiltInFictitiousFunctionClassFactory.KClassImpl$Data$declaredNonStaticMembers$2(), 0L, 2L);
                    }
                    long isLayoutRequested = this.BuiltInFictitiousFunctionClassFactory.KClassImpl$Data$declaredNonStaticMembers$2().isLayoutRequested();
                    this.BuiltInFictitiousFunctionClassFactory.lookAheadTest(isLayoutRequested);
                    if (z) {
                        j2 = isLayoutRequested;
                        MyBillsEntityDataFactory(this.BuiltInFictitiousFunctionClassFactory.KClassImpl$Data$declaredNonStaticMembers$2(), 0L, isLayoutRequested);
                    } else {
                        j2 = isLayoutRequested;
                    }
                    this.BuiltInFictitiousFunctionClassFactory.NetworkUserEntityData$$ExternalSyntheticLambda0(j2);
                }
                if (((authRequestContext >> 3) & 1) == 1) {
                    long errorConfigVersion = this.BuiltInFictitiousFunctionClassFactory.getErrorConfigVersion();
                    if (errorConfigVersion == -1) {
                        throw new EOFException();
                    }
                    if (z) {
                        MyBillsEntityDataFactory(this.BuiltInFictitiousFunctionClassFactory.KClassImpl$Data$declaredNonStaticMembers$2(), 0L, errorConfigVersion + 1);
                    }
                    this.BuiltInFictitiousFunctionClassFactory.NetworkUserEntityData$$ExternalSyntheticLambda0(errorConfigVersion + 1);
                }
                if (((authRequestContext >> 4) & 1) == 1) {
                    long errorConfigVersion2 = this.BuiltInFictitiousFunctionClassFactory.getErrorConfigVersion();
                    if (errorConfigVersion2 == -1) {
                        throw new EOFException();
                    }
                    if (z) {
                        MyBillsEntityDataFactory(this.BuiltInFictitiousFunctionClassFactory.KClassImpl$Data$declaredNonStaticMembers$2(), 0L, errorConfigVersion2 + 1);
                    }
                    this.BuiltInFictitiousFunctionClassFactory.NetworkUserEntityData$$ExternalSyntheticLambda0(errorConfigVersion2 + 1);
                }
                if (z) {
                    PlaceComponentResult("FHCRC", this.BuiltInFictitiousFunctionClassFactory.isLayoutRequested(), (short) this.MyBillsEntityDataFactory.getValue());
                    this.MyBillsEntityDataFactory.reset();
                }
                this.PlaceComponentResult = 1;
            }
            if (this.PlaceComponentResult == 1) {
                long j3 = buffer.getAuthRequestContext;
                long read = this.KClassImpl$Data$declaredNonStaticMembers$2.read(buffer, j);
                if (read != -1) {
                    MyBillsEntityDataFactory(buffer, j3, read);
                    return read;
                }
                this.PlaceComponentResult = 2;
            }
            if (this.PlaceComponentResult == 2) {
                PlaceComponentResult("CRC", this.BuiltInFictitiousFunctionClassFactory.NetworkUserEntityData$$ExternalSyntheticLambda7(), (int) this.MyBillsEntityDataFactory.getValue());
                PlaceComponentResult("ISIZE", this.BuiltInFictitiousFunctionClassFactory.NetworkUserEntityData$$ExternalSyntheticLambda7(), (int) this.getAuthRequestContext.getBytesWritten());
                this.PlaceComponentResult = 3;
                if (!this.BuiltInFictitiousFunctionClassFactory.lookAheadTest()) {
                    throw new IOException("gzip finished without exhausting source");
                }
            }
            return -1L;
        }
    }

    @Override // okio.Source
    public final Timeout timeout() {
        return this.BuiltInFictitiousFunctionClassFactory.timeout();
    }

    @Override // okio.Source, java.io.Closeable, java.lang.AutoCloseable
    public final void close() throws IOException {
        this.KClassImpl$Data$declaredNonStaticMembers$2.close();
    }

    private void MyBillsEntityDataFactory(Buffer buffer, long j, long j2) {
        Segment segment = buffer.BuiltInFictitiousFunctionClassFactory;
        while (j >= segment.MyBillsEntityDataFactory - segment.PlaceComponentResult) {
            j -= segment.MyBillsEntityDataFactory - segment.PlaceComponentResult;
            segment = segment.getAuthRequestContext;
        }
        while (j2 > 0) {
            int min = (int) Math.min(segment.MyBillsEntityDataFactory - r6, j2);
            this.MyBillsEntityDataFactory.update(segment.BuiltInFictitiousFunctionClassFactory, (int) (segment.PlaceComponentResult + j), min);
            j2 -= min;
            segment = segment.getAuthRequestContext;
            j = 0;
        }
    }

    private static void PlaceComponentResult(String str, int i, int i2) throws IOException {
        if (i2 != i) {
            throw new IOException(String.format("%s: actual 0x%08x != expected 0x%08x", str, Integer.valueOf(i2), Integer.valueOf(i)));
        }
    }
}
