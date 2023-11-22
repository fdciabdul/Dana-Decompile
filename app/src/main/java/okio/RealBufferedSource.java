package okio;

import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import kotlin.jvm.internal.LongCompanionObject;
import kotlin.text.Typography;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes6.dex */
public final class RealBufferedSource implements BufferedSource {
    boolean BuiltInFictitiousFunctionClassFactory;
    public final Buffer KClassImpl$Data$declaredNonStaticMembers$2 = new Buffer();
    public final Source PlaceComponentResult;

    /* JADX INFO: Access modifiers changed from: package-private */
    public RealBufferedSource(Source source) {
        if (source == null) {
            throw new NullPointerException("source == null");
        }
        this.PlaceComponentResult = source;
    }

    @Override // okio.BufferedSource, okio.BufferedSink
    public final Buffer KClassImpl$Data$declaredNonStaticMembers$2() {
        return this.KClassImpl$Data$declaredNonStaticMembers$2;
    }

    @Override // okio.Source
    public final long read(Buffer buffer, long j) throws IOException {
        if (buffer != null) {
            if (j < 0) {
                StringBuilder sb = new StringBuilder();
                sb.append("byteCount < 0: ");
                sb.append(j);
                throw new IllegalArgumentException(sb.toString());
            } else if (this.BuiltInFictitiousFunctionClassFactory) {
                throw new IllegalStateException("closed");
            } else {
                if (this.KClassImpl$Data$declaredNonStaticMembers$2.getAuthRequestContext == 0 && this.PlaceComponentResult.read(this.KClassImpl$Data$declaredNonStaticMembers$2, 8192L) == -1) {
                    return -1L;
                }
                return this.KClassImpl$Data$declaredNonStaticMembers$2.read(buffer, Math.min(j, this.KClassImpl$Data$declaredNonStaticMembers$2.getAuthRequestContext));
            }
        }
        throw new IllegalArgumentException("sink == null");
    }

    @Override // okio.BufferedSource
    public final boolean lookAheadTest() throws IOException {
        if (this.BuiltInFictitiousFunctionClassFactory) {
            throw new IllegalStateException("closed");
        }
        return this.KClassImpl$Data$declaredNonStaticMembers$2.lookAheadTest() && this.PlaceComponentResult.read(this.KClassImpl$Data$declaredNonStaticMembers$2, 8192L) == -1;
    }

    @Override // okio.BufferedSource
    public final void lookAheadTest(long j) throws IOException {
        if (!getErrorConfigVersion(j)) {
            throw new EOFException();
        }
    }

    @Override // okio.BufferedSource
    public final boolean getErrorConfigVersion(long j) throws IOException {
        if (j < 0) {
            StringBuilder sb = new StringBuilder();
            sb.append("byteCount < 0: ");
            sb.append(j);
            throw new IllegalArgumentException(sb.toString());
        }
        if (this.BuiltInFictitiousFunctionClassFactory) {
            throw new IllegalStateException("closed");
        }
        while (this.KClassImpl$Data$declaredNonStaticMembers$2.getAuthRequestContext < j) {
            if (this.PlaceComponentResult.read(this.KClassImpl$Data$declaredNonStaticMembers$2, 8192L) == -1) {
                return false;
            }
        }
        return true;
    }

    @Override // okio.BufferedSource
    public final int MyBillsEntityDataFactory(Options options) throws IOException {
        if (this.BuiltInFictitiousFunctionClassFactory) {
            throw new IllegalStateException("closed");
        }
        do {
            int authRequestContext = this.KClassImpl$Data$declaredNonStaticMembers$2.getAuthRequestContext(options, true);
            if (authRequestContext == -1) {
                return -1;
            }
            if (authRequestContext != -2) {
                this.KClassImpl$Data$declaredNonStaticMembers$2.NetworkUserEntityData$$ExternalSyntheticLambda0(options.MyBillsEntityDataFactory[authRequestContext].size());
                return authRequestContext;
            }
        } while (this.PlaceComponentResult.read(this.KClassImpl$Data$declaredNonStaticMembers$2, 8192L) != -1);
        return -1;
    }

    @Override // okio.BufferedSource
    public final byte[] NetworkUserEntityData$$ExternalSyntheticLambda1() throws IOException {
        this.KClassImpl$Data$declaredNonStaticMembers$2.BuiltInFictitiousFunctionClassFactory(this.PlaceComponentResult);
        return this.KClassImpl$Data$declaredNonStaticMembers$2.NetworkUserEntityData$$ExternalSyntheticLambda1();
    }

    @Override // okio.BufferedSource
    public final void BuiltInFictitiousFunctionClassFactory(byte[] bArr) throws IOException {
        try {
            if (getErrorConfigVersion(bArr.length)) {
                this.KClassImpl$Data$declaredNonStaticMembers$2.BuiltInFictitiousFunctionClassFactory(bArr);
                return;
            }
            throw new EOFException();
        } catch (EOFException e) {
            int i = 0;
            while (this.KClassImpl$Data$declaredNonStaticMembers$2.getAuthRequestContext > 0) {
                Buffer buffer = this.KClassImpl$Data$declaredNonStaticMembers$2;
                int authRequestContext = buffer.getAuthRequestContext(bArr, i, (int) buffer.getAuthRequestContext);
                if (authRequestContext == -1) {
                    throw new AssertionError();
                }
                i += authRequestContext;
            }
            throw e;
        }
    }

    @Override // java.nio.channels.ReadableByteChannel
    public final int read(ByteBuffer byteBuffer) throws IOException {
        if (this.KClassImpl$Data$declaredNonStaticMembers$2.getAuthRequestContext == 0 && this.PlaceComponentResult.read(this.KClassImpl$Data$declaredNonStaticMembers$2, 8192L) == -1) {
            return -1;
        }
        return this.KClassImpl$Data$declaredNonStaticMembers$2.read(byteBuffer);
    }

    @Override // okio.BufferedSource
    public final long PlaceComponentResult(Sink sink) throws IOException {
        if (sink != null) {
            long j = 0;
            while (this.PlaceComponentResult.read(this.KClassImpl$Data$declaredNonStaticMembers$2, 8192L) != -1) {
                long MyBillsEntityDataFactory = this.KClassImpl$Data$declaredNonStaticMembers$2.MyBillsEntityDataFactory();
                if (MyBillsEntityDataFactory > 0) {
                    j += MyBillsEntityDataFactory;
                    sink.write(this.KClassImpl$Data$declaredNonStaticMembers$2, MyBillsEntityDataFactory);
                }
            }
            if (this.KClassImpl$Data$declaredNonStaticMembers$2.getAuthRequestContext > 0) {
                long j2 = j + this.KClassImpl$Data$declaredNonStaticMembers$2.getAuthRequestContext;
                Buffer buffer = this.KClassImpl$Data$declaredNonStaticMembers$2;
                sink.write(buffer, buffer.getAuthRequestContext);
                return j2;
            }
            return j;
        }
        throw new IllegalArgumentException("sink == null");
    }

    @Override // okio.BufferedSource
    public final String FragmentBottomSheetPaymentSettingBinding() throws IOException {
        this.KClassImpl$Data$declaredNonStaticMembers$2.BuiltInFictitiousFunctionClassFactory(this.PlaceComponentResult);
        return this.KClassImpl$Data$declaredNonStaticMembers$2.FragmentBottomSheetPaymentSettingBinding();
    }

    @Override // okio.BufferedSource
    public final String getAuthRequestContext(Charset charset) throws IOException {
        if (charset == null) {
            throw new IllegalArgumentException("charset == null");
        }
        this.KClassImpl$Data$declaredNonStaticMembers$2.BuiltInFictitiousFunctionClassFactory(this.PlaceComponentResult);
        return this.KClassImpl$Data$declaredNonStaticMembers$2.getAuthRequestContext(charset);
    }

    @Override // okio.BufferedSource
    public final String NetworkUserEntityData$$ExternalSyntheticLambda5() throws IOException {
        return BuiltInFictitiousFunctionClassFactory(LongCompanionObject.MAX_VALUE);
    }

    @Override // okio.BufferedSource
    public final String BuiltInFictitiousFunctionClassFactory(long j) throws IOException {
        if (j < 0) {
            StringBuilder sb = new StringBuilder();
            sb.append("limit < 0: ");
            sb.append(j);
            throw new IllegalArgumentException(sb.toString());
        }
        long j2 = j == LongCompanionObject.MAX_VALUE ? Long.MAX_VALUE : j + 1;
        long PlaceComponentResult = PlaceComponentResult((byte) 10, 0L, j2);
        if (PlaceComponentResult != -1) {
            return this.KClassImpl$Data$declaredNonStaticMembers$2.KClassImpl$Data$declaredNonStaticMembers$2(PlaceComponentResult);
        }
        if (j2 < LongCompanionObject.MAX_VALUE && getErrorConfigVersion(j2) && this.KClassImpl$Data$declaredNonStaticMembers$2.getAuthRequestContext(j2 - 1) == 13 && getErrorConfigVersion(1 + j2) && this.KClassImpl$Data$declaredNonStaticMembers$2.getAuthRequestContext(j2) == 10) {
            return this.KClassImpl$Data$declaredNonStaticMembers$2.KClassImpl$Data$declaredNonStaticMembers$2(j2);
        }
        Buffer buffer = new Buffer();
        Buffer buffer2 = this.KClassImpl$Data$declaredNonStaticMembers$2;
        buffer2.BuiltInFictitiousFunctionClassFactory(buffer, 0L, Math.min(32L, buffer2.getAuthRequestContext));
        StringBuilder sb2 = new StringBuilder();
        sb2.append("\\n not found: limit=");
        sb2.append(Math.min(this.KClassImpl$Data$declaredNonStaticMembers$2.getAuthRequestContext, j));
        sb2.append(" content=");
        sb2.append(new ByteString(buffer.NetworkUserEntityData$$ExternalSyntheticLambda1()).hex());
        sb2.append(Typography.ellipsis);
        throw new EOFException(sb2.toString());
    }

    @Override // okio.BufferedSource
    public final void NetworkUserEntityData$$ExternalSyntheticLambda0(long j) throws IOException {
        if (this.BuiltInFictitiousFunctionClassFactory) {
            throw new IllegalStateException("closed");
        }
        while (j > 0) {
            if (this.KClassImpl$Data$declaredNonStaticMembers$2.getAuthRequestContext == 0 && this.PlaceComponentResult.read(this.KClassImpl$Data$declaredNonStaticMembers$2, 8192L) == -1) {
                throw new EOFException();
            }
            long min = Math.min(j, this.KClassImpl$Data$declaredNonStaticMembers$2.getAuthRequestContext);
            this.KClassImpl$Data$declaredNonStaticMembers$2.NetworkUserEntityData$$ExternalSyntheticLambda0(min);
            j -= min;
        }
    }

    @Override // okio.BufferedSource
    public final long getErrorConfigVersion() throws IOException {
        return PlaceComponentResult((byte) 0, 0L, LongCompanionObject.MAX_VALUE);
    }

    private long PlaceComponentResult(byte b, long j, long j2) throws IOException {
        if (this.BuiltInFictitiousFunctionClassFactory) {
            throw new IllegalStateException("closed");
        }
        if (j2 >= 0) {
            while (j < j2) {
                long KClassImpl$Data$declaredNonStaticMembers$2 = this.KClassImpl$Data$declaredNonStaticMembers$2.KClassImpl$Data$declaredNonStaticMembers$2(b, j, j2);
                if (KClassImpl$Data$declaredNonStaticMembers$2 == -1) {
                    long j3 = this.KClassImpl$Data$declaredNonStaticMembers$2.getAuthRequestContext;
                    if (j3 >= j2 || this.PlaceComponentResult.read(this.KClassImpl$Data$declaredNonStaticMembers$2, 8192L) == -1) {
                        break;
                    }
                    j = Math.max(j, j3);
                } else {
                    return KClassImpl$Data$declaredNonStaticMembers$2;
                }
            }
            return -1L;
        }
        throw new IllegalArgumentException(String.format("fromIndex=%s toIndex=%s", 0L, Long.valueOf(j2)));
    }

    @Override // okio.BufferedSource
    public final boolean PlaceComponentResult(ByteString byteString) throws IOException {
        return MyBillsEntityDataFactory(byteString, byteString.size());
    }

    private boolean MyBillsEntityDataFactory(ByteString byteString, int i) throws IOException {
        if (this.BuiltInFictitiousFunctionClassFactory) {
            throw new IllegalStateException("closed");
        }
        if (i < 0 || byteString.size() - 0 < i) {
            return false;
        }
        for (int i2 = 0; i2 < i; i2++) {
            long j = i2 + 0;
            if (!getErrorConfigVersion(1 + j) || this.KClassImpl$Data$declaredNonStaticMembers$2.getAuthRequestContext(j) != byteString.getByte(i2 + 0)) {
                return false;
            }
        }
        return true;
    }

    @Override // okio.BufferedSource
    public final BufferedSource scheduleImpl() {
        return Okio.KClassImpl$Data$declaredNonStaticMembers$2(new PeekSource(this));
    }

    @Override // okio.BufferedSource
    public final InputStream NetworkUserEntityData$$ExternalSyntheticLambda0() {
        return new InputStream() { // from class: okio.RealBufferedSource.1
            @Override // java.io.InputStream
            public int read() throws IOException {
                if (RealBufferedSource.this.BuiltInFictitiousFunctionClassFactory) {
                    throw new IOException("closed");
                }
                if (RealBufferedSource.this.KClassImpl$Data$declaredNonStaticMembers$2.getAuthRequestContext == 0 && RealBufferedSource.this.PlaceComponentResult.read(RealBufferedSource.this.KClassImpl$Data$declaredNonStaticMembers$2, 8192L) == -1) {
                    return -1;
                }
                return RealBufferedSource.this.KClassImpl$Data$declaredNonStaticMembers$2.initRecordTimeStamp() & 255;
            }

            @Override // java.io.InputStream
            public int read(byte[] bArr, int i, int i2) throws IOException {
                if (RealBufferedSource.this.BuiltInFictitiousFunctionClassFactory) {
                    throw new IOException("closed");
                }
                Util.MyBillsEntityDataFactory(bArr.length, i, i2);
                if (RealBufferedSource.this.KClassImpl$Data$declaredNonStaticMembers$2.getAuthRequestContext == 0 && RealBufferedSource.this.PlaceComponentResult.read(RealBufferedSource.this.KClassImpl$Data$declaredNonStaticMembers$2, 8192L) == -1) {
                    return -1;
                }
                return RealBufferedSource.this.KClassImpl$Data$declaredNonStaticMembers$2.getAuthRequestContext(bArr, i, i2);
            }

            @Override // java.io.InputStream
            public int available() throws IOException {
                if (RealBufferedSource.this.BuiltInFictitiousFunctionClassFactory) {
                    throw new IOException("closed");
                }
                return (int) Math.min(RealBufferedSource.this.KClassImpl$Data$declaredNonStaticMembers$2.getAuthRequestContext, 2147483647L);
            }

            @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
            public void close() throws IOException {
                RealBufferedSource.this.close();
            }

            public String toString() {
                StringBuilder sb = new StringBuilder();
                sb.append(RealBufferedSource.this);
                sb.append(".inputStream()");
                return sb.toString();
            }
        };
    }

    @Override // java.nio.channels.Channel
    public final boolean isOpen() {
        return !this.BuiltInFictitiousFunctionClassFactory;
    }

    @Override // okio.Source, java.io.Closeable, java.lang.AutoCloseable
    public final void close() throws IOException {
        if (this.BuiltInFictitiousFunctionClassFactory) {
            return;
        }
        this.BuiltInFictitiousFunctionClassFactory = true;
        this.PlaceComponentResult.close();
        Buffer buffer = this.KClassImpl$Data$declaredNonStaticMembers$2;
        try {
            buffer.NetworkUserEntityData$$ExternalSyntheticLambda0(buffer.getAuthRequestContext);
        } catch (EOFException e) {
            throw new AssertionError(e);
        }
    }

    @Override // okio.Source
    public final Timeout timeout() {
        return this.PlaceComponentResult.timeout();
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("buffer(");
        sb.append(this.PlaceComponentResult);
        sb.append(")");
        return sb.toString();
    }

    @Override // okio.BufferedSource
    public final long KClassImpl$Data$declaredNonStaticMembers$2(ByteString byteString) throws IOException {
        if (this.BuiltInFictitiousFunctionClassFactory) {
            throw new IllegalStateException("closed");
        }
        long j = 0;
        while (true) {
            long BuiltInFictitiousFunctionClassFactory = this.KClassImpl$Data$declaredNonStaticMembers$2.BuiltInFictitiousFunctionClassFactory(byteString, j);
            if (BuiltInFictitiousFunctionClassFactory != -1) {
                return BuiltInFictitiousFunctionClassFactory;
            }
            long j2 = this.KClassImpl$Data$declaredNonStaticMembers$2.getAuthRequestContext;
            if (this.PlaceComponentResult.read(this.KClassImpl$Data$declaredNonStaticMembers$2, 8192L) == -1) {
                return -1L;
            }
            j = Math.max(j, (j2 - byteString.size()) + 1);
        }
    }

    @Override // okio.BufferedSource
    public final long MyBillsEntityDataFactory(ByteString byteString) throws IOException {
        if (this.BuiltInFictitiousFunctionClassFactory) {
            throw new IllegalStateException("closed");
        }
        long j = 0;
        while (true) {
            long MyBillsEntityDataFactory = this.KClassImpl$Data$declaredNonStaticMembers$2.MyBillsEntityDataFactory(byteString, j);
            if (MyBillsEntityDataFactory != -1) {
                return MyBillsEntityDataFactory;
            }
            long j2 = this.KClassImpl$Data$declaredNonStaticMembers$2.getAuthRequestContext;
            if (this.PlaceComponentResult.read(this.KClassImpl$Data$declaredNonStaticMembers$2, 8192L) == -1) {
                return -1L;
            }
            j = Math.max(j, j2);
        }
    }

    @Override // okio.BufferedSource
    public final byte initRecordTimeStamp() throws IOException {
        if (getErrorConfigVersion(1L)) {
            return this.KClassImpl$Data$declaredNonStaticMembers$2.initRecordTimeStamp();
        }
        throw new EOFException();
    }

    @Override // okio.BufferedSource
    public final byte[] PlaceComponentResult(long j) throws IOException {
        if (getErrorConfigVersion(j)) {
            return this.KClassImpl$Data$declaredNonStaticMembers$2.PlaceComponentResult(j);
        }
        throw new EOFException();
    }

    @Override // okio.BufferedSource
    public final ByteString MyBillsEntityDataFactory(long j) throws IOException {
        if (!getErrorConfigVersion(j)) {
            throw new EOFException();
        }
        return new ByteString(this.KClassImpl$Data$declaredNonStaticMembers$2.PlaceComponentResult(j));
    }

    @Override // okio.BufferedSource
    public final long NetworkUserEntityData$$ExternalSyntheticLambda2() throws IOException {
        byte authRequestContext;
        if (getErrorConfigVersion(1L)) {
            int i = 0;
            while (true) {
                int i2 = i + 1;
                if (!getErrorConfigVersion(i2)) {
                    break;
                }
                authRequestContext = this.KClassImpl$Data$declaredNonStaticMembers$2.getAuthRequestContext(i);
                if ((authRequestContext < 48 || authRequestContext > 57) && !(i == 0 && authRequestContext == 45)) {
                    break;
                }
                i = i2;
            }
            if (i == 0) {
                throw new NumberFormatException(String.format("Expected leading [0-9] or '-' character but was %#x", Byte.valueOf(authRequestContext)));
            }
            return this.KClassImpl$Data$declaredNonStaticMembers$2.NetworkUserEntityData$$ExternalSyntheticLambda2();
        }
        throw new EOFException();
    }

    @Override // okio.BufferedSource
    public final void KClassImpl$Data$declaredNonStaticMembers$2(Buffer buffer, long j) throws IOException {
        try {
            if (getErrorConfigVersion(j)) {
                this.KClassImpl$Data$declaredNonStaticMembers$2.KClassImpl$Data$declaredNonStaticMembers$2(buffer, j);
                return;
            }
            throw new EOFException();
        } catch (EOFException e) {
            buffer.BuiltInFictitiousFunctionClassFactory(this.KClassImpl$Data$declaredNonStaticMembers$2);
            throw e;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:20:0x0034, code lost:
    
        if (r1 == 0) goto L22;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x004b, code lost:
    
        throw new java.lang.NumberFormatException(java.lang.String.format("Expected leading [0-9a-fA-F] character but was %#x", java.lang.Byte.valueOf(r3)));
     */
    @Override // okio.BufferedSource
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final long DatabaseTableConfigUtil() throws java.io.IOException {
        /*
            r6 = this;
            r0 = 1
            boolean r0 = r6.getErrorConfigVersion(r0)
            if (r0 == 0) goto L53
            r0 = 0
            r1 = 0
        La:
            int r2 = r1 + 1
            long r3 = (long) r2
            boolean r3 = r6.getErrorConfigVersion(r3)
            if (r3 == 0) goto L4c
            okio.Buffer r3 = r6.KClassImpl$Data$declaredNonStaticMembers$2
            long r4 = (long) r1
            byte r3 = r3.getAuthRequestContext(r4)
            r4 = 48
            if (r3 < r4) goto L22
            r4 = 57
            if (r3 <= r4) goto L32
        L22:
            r4 = 97
            if (r3 < r4) goto L2a
            r4 = 102(0x66, float:1.43E-43)
            if (r3 <= r4) goto L32
        L2a:
            r4 = 65
            if (r3 < r4) goto L34
            r4 = 70
            if (r3 > r4) goto L34
        L32:
            r1 = r2
            goto La
        L34:
            if (r1 == 0) goto L37
            goto L4c
        L37:
            r1 = 1
            java.lang.Object[] r1 = new java.lang.Object[r1]
            java.lang.Byte r2 = java.lang.Byte.valueOf(r3)
            r1[r0] = r2
            java.lang.NumberFormatException r0 = new java.lang.NumberFormatException
            java.lang.String r2 = "Expected leading [0-9a-fA-F] character but was %#x"
            java.lang.String r1 = java.lang.String.format(r2, r1)
            r0.<init>(r1)
            throw r0
        L4c:
            okio.Buffer r0 = r6.KClassImpl$Data$declaredNonStaticMembers$2
            long r0 = r0.DatabaseTableConfigUtil()
            return r0
        L53:
            java.io.EOFException r0 = new java.io.EOFException
            r0.<init>()
            goto L5a
        L59:
            throw r0
        L5a:
            goto L59
        */
        throw new UnsupportedOperationException("Method not decompiled: okio.RealBufferedSource.DatabaseTableConfigUtil():long");
    }

    @Override // okio.BufferedSource
    public final int GetContactSyncConfig() throws IOException {
        if (getErrorConfigVersion(4L)) {
            return this.KClassImpl$Data$declaredNonStaticMembers$2.GetContactSyncConfig();
        }
        throw new EOFException();
    }

    @Override // okio.BufferedSource
    public final int NetworkUserEntityData$$ExternalSyntheticLambda7() throws IOException {
        if (!getErrorConfigVersion(4L)) {
            throw new EOFException();
        }
        return Util.MyBillsEntityDataFactory(this.KClassImpl$Data$declaredNonStaticMembers$2.GetContactSyncConfig());
    }

    @Override // okio.BufferedSource
    public final long newProxyInstance() throws IOException {
        if (getErrorConfigVersion(8L)) {
            return this.KClassImpl$Data$declaredNonStaticMembers$2.newProxyInstance();
        }
        throw new EOFException();
    }

    @Override // okio.BufferedSource
    public final long PrepareContext() throws IOException {
        if (!getErrorConfigVersion(8L)) {
            throw new EOFException();
        }
        return Util.KClassImpl$Data$declaredNonStaticMembers$2(this.KClassImpl$Data$declaredNonStaticMembers$2.newProxyInstance());
    }

    @Override // okio.BufferedSource
    public final short NetworkUserEntityData$$ExternalSyntheticLambda8() throws IOException {
        if (getErrorConfigVersion(2L)) {
            return this.KClassImpl$Data$declaredNonStaticMembers$2.NetworkUserEntityData$$ExternalSyntheticLambda8();
        }
        throw new EOFException();
    }

    @Override // okio.BufferedSource
    public final short isLayoutRequested() throws IOException {
        if (getErrorConfigVersion(2L)) {
            return this.KClassImpl$Data$declaredNonStaticMembers$2.isLayoutRequested();
        }
        throw new EOFException();
    }

    @Override // okio.BufferedSource
    public final String KClassImpl$Data$declaredNonStaticMembers$2(long j, Charset charset) throws IOException {
        if (getErrorConfigVersion(j)) {
            if (charset == null) {
                throw new IllegalArgumentException("charset == null");
            }
            return this.KClassImpl$Data$declaredNonStaticMembers$2.KClassImpl$Data$declaredNonStaticMembers$2(j, charset);
        }
        throw new EOFException();
    }
}
