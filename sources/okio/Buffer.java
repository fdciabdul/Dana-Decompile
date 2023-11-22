package okio;

import com.alibaba.ariver.resource.parser.tar.TarHeader;
import java.io.Closeable;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.channels.ByteChannel;
import java.nio.charset.Charset;
import javax.annotation.Nullable;
import kotlin.jvm.internal.LongCompanionObject;
import kotlin.text.Typography;

/* loaded from: classes.dex */
public final class Buffer implements BufferedSource, BufferedSink, Cloneable, ByteChannel {
    private static final byte[] MyBillsEntityDataFactory = {TarHeader.LF_NORMAL, TarHeader.LF_LINK, TarHeader.LF_SYMLINK, TarHeader.LF_CHR, TarHeader.LF_BLK, TarHeader.LF_DIR, TarHeader.LF_FIFO, TarHeader.LF_CONTIG, 56, 57, 97, 98, 99, 100, 101, 102};
    @Nullable
    Segment BuiltInFictitiousFunctionClassFactory;
    public long getAuthRequestContext;

    @Override // okio.BufferedSink
    public final /* bridge */ /* synthetic */ BufferedSink BuiltInFictitiousFunctionClassFactory() throws IOException {
        return this;
    }

    @Override // okio.BufferedSource, okio.BufferedSink
    public final Buffer KClassImpl$Data$declaredNonStaticMembers$2() {
        return this;
    }

    @Override // okio.BufferedSink
    public final BufferedSink PlaceComponentResult() {
        return this;
    }

    @Override // okio.Source, java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
    }

    @Override // okio.BufferedSink, okio.Sink, java.io.Flushable
    public final void flush() {
    }

    @Override // java.nio.channels.Channel
    public final boolean isOpen() {
        return true;
    }

    /* renamed from: okio.Buffer$1  reason: invalid class name */
    /* loaded from: classes.dex */
    public class AnonymousClass1 extends OutputStream {
        @Override // java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
        }

        @Override // java.io.OutputStream, java.io.Flushable
        public void flush() {
        }

        public AnonymousClass1() {
        }

        @Override // java.io.OutputStream
        public void write(int i) {
            Buffer.this.PlaceComponentResult((int) ((byte) i));
        }

        @Override // java.io.OutputStream
        public void write(byte[] bArr, int i, int i2) {
            Buffer.this.MyBillsEntityDataFactory(bArr, i, i2);
        }

        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append(Buffer.this);
            sb.append(".outputStream()");
            return sb.toString();
        }
    }

    @Override // okio.BufferedSink
    public final OutputStream moveToNextValue() {
        return new AnonymousClass1();
    }

    @Override // okio.BufferedSource
    public final boolean lookAheadTest() {
        return this.getAuthRequestContext == 0;
    }

    @Override // okio.BufferedSource
    public final void lookAheadTest(long j) throws EOFException {
        if (this.getAuthRequestContext < j) {
            throw new EOFException();
        }
    }

    @Override // okio.BufferedSource
    public final boolean getErrorConfigVersion(long j) {
        return this.getAuthRequestContext >= j;
    }

    @Override // okio.BufferedSource
    public final BufferedSource scheduleImpl() {
        return Okio.KClassImpl$Data$declaredNonStaticMembers$2(new PeekSource(this));
    }

    /* renamed from: okio.Buffer$2  reason: invalid class name */
    /* loaded from: classes.dex */
    public class AnonymousClass2 extends InputStream {
        @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
        }

        public AnonymousClass2() {
        }

        @Override // java.io.InputStream
        public int read() {
            if (Buffer.this.getAuthRequestContext > 0) {
                return Buffer.this.initRecordTimeStamp() & 255;
            }
            return -1;
        }

        @Override // java.io.InputStream
        public int read(byte[] bArr, int i, int i2) {
            return Buffer.this.getAuthRequestContext(bArr, i, i2);
        }

        @Override // java.io.InputStream
        public int available() {
            return (int) Math.min(Buffer.this.getAuthRequestContext, 2147483647L);
        }

        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append(Buffer.this);
            sb.append(".inputStream()");
            return sb.toString();
        }
    }

    @Override // okio.BufferedSource
    public final InputStream NetworkUserEntityData$$ExternalSyntheticLambda0() {
        return new AnonymousClass2();
    }

    public final Buffer BuiltInFictitiousFunctionClassFactory(Buffer buffer, long j, long j2) {
        if (buffer == null) {
            throw new IllegalArgumentException("out == null");
        }
        Util.MyBillsEntityDataFactory(this.getAuthRequestContext, j, j2);
        if (j2 == 0) {
            return this;
        }
        buffer.getAuthRequestContext += j2;
        Segment segment = this.BuiltInFictitiousFunctionClassFactory;
        while (j >= segment.MyBillsEntityDataFactory - segment.PlaceComponentResult) {
            j -= segment.MyBillsEntityDataFactory - segment.PlaceComponentResult;
            segment = segment.getAuthRequestContext;
        }
        while (j2 > 0) {
            segment.moveToNextValue = true;
            Segment segment2 = new Segment(segment.BuiltInFictitiousFunctionClassFactory, segment.PlaceComponentResult, segment.MyBillsEntityDataFactory, true, false);
            segment2.PlaceComponentResult = (int) (segment2.PlaceComponentResult + j);
            segment2.MyBillsEntityDataFactory = Math.min(segment2.PlaceComponentResult + ((int) j2), segment2.MyBillsEntityDataFactory);
            Segment segment3 = buffer.BuiltInFictitiousFunctionClassFactory;
            if (segment3 == null) {
                segment2.lookAheadTest = segment2;
                segment2.getAuthRequestContext = segment2;
                buffer.BuiltInFictitiousFunctionClassFactory = segment2;
            } else {
                Segment segment4 = segment3.lookAheadTest;
                segment2.lookAheadTest = segment4;
                segment2.getAuthRequestContext = segment4.getAuthRequestContext;
                segment4.getAuthRequestContext.lookAheadTest = segment2;
                segment4.getAuthRequestContext = segment2;
            }
            j2 -= segment2.MyBillsEntityDataFactory - segment2.PlaceComponentResult;
            segment = segment.getAuthRequestContext;
            j = 0;
        }
        return this;
    }

    public final long MyBillsEntityDataFactory() {
        long j = this.getAuthRequestContext;
        if (j == 0) {
            return 0L;
        }
        Segment segment = this.BuiltInFictitiousFunctionClassFactory.lookAheadTest;
        return (segment.MyBillsEntityDataFactory >= 8192 || !segment.KClassImpl$Data$declaredNonStaticMembers$2) ? j : j - (segment.MyBillsEntityDataFactory - segment.PlaceComponentResult);
    }

    @Override // okio.BufferedSource
    public final byte initRecordTimeStamp() {
        if (this.getAuthRequestContext == 0) {
            throw new IllegalStateException("size == 0");
        }
        Segment segment = this.BuiltInFictitiousFunctionClassFactory;
        int i = segment.PlaceComponentResult;
        int i2 = segment.MyBillsEntityDataFactory;
        int i3 = i + 1;
        byte b = segment.BuiltInFictitiousFunctionClassFactory[i];
        this.getAuthRequestContext--;
        if (i3 == i2) {
            this.BuiltInFictitiousFunctionClassFactory = segment.MyBillsEntityDataFactory();
            SegmentPool.getAuthRequestContext(segment);
        } else {
            segment.PlaceComponentResult = i3;
        }
        return b;
    }

    public final byte getAuthRequestContext(long j) {
        Util.MyBillsEntityDataFactory(this.getAuthRequestContext, j, 1L);
        long j2 = this.getAuthRequestContext;
        if (j2 - j > j) {
            Segment segment = this.BuiltInFictitiousFunctionClassFactory;
            while (true) {
                long j3 = segment.MyBillsEntityDataFactory - segment.PlaceComponentResult;
                if (j >= j3) {
                    j -= j3;
                    segment = segment.getAuthRequestContext;
                } else {
                    return segment.BuiltInFictitiousFunctionClassFactory[segment.PlaceComponentResult + ((int) j)];
                }
            }
        } else {
            long j4 = j - j2;
            Segment segment2 = this.BuiltInFictitiousFunctionClassFactory;
            do {
                segment2 = segment2.lookAheadTest;
                j4 += segment2.MyBillsEntityDataFactory - segment2.PlaceComponentResult;
            } while (j4 < 0);
            return segment2.BuiltInFictitiousFunctionClassFactory[segment2.PlaceComponentResult + ((int) j4)];
        }
    }

    @Override // okio.BufferedSource
    public final short NetworkUserEntityData$$ExternalSyntheticLambda8() {
        int i;
        int i2;
        if (this.getAuthRequestContext < 2) {
            StringBuilder sb = new StringBuilder();
            sb.append("size < 2: ");
            sb.append(this.getAuthRequestContext);
            throw new IllegalStateException(sb.toString());
        }
        Segment segment = this.BuiltInFictitiousFunctionClassFactory;
        int i3 = segment.PlaceComponentResult;
        int i4 = segment.MyBillsEntityDataFactory;
        if (i4 - i3 < 2) {
            i = (initRecordTimeStamp() & 255) << 8;
            i2 = initRecordTimeStamp() & 255;
        } else {
            byte[] bArr = segment.BuiltInFictitiousFunctionClassFactory;
            int i5 = i3 + 1;
            byte b = bArr[i3];
            int i6 = i5 + 1;
            byte b2 = bArr[i5];
            this.getAuthRequestContext -= 2;
            if (i6 == i4) {
                this.BuiltInFictitiousFunctionClassFactory = segment.MyBillsEntityDataFactory();
                SegmentPool.getAuthRequestContext(segment);
            } else {
                segment.PlaceComponentResult = i6;
            }
            i = (b & 255) << 8;
            i2 = b2 & 255;
        }
        return (short) (i | i2);
    }

    @Override // okio.BufferedSource
    public final int GetContactSyncConfig() {
        int i;
        int i2;
        if (this.getAuthRequestContext < 4) {
            StringBuilder sb = new StringBuilder();
            sb.append("size < 4: ");
            sb.append(this.getAuthRequestContext);
            throw new IllegalStateException(sb.toString());
        }
        Segment segment = this.BuiltInFictitiousFunctionClassFactory;
        int i3 = segment.PlaceComponentResult;
        int i4 = segment.MyBillsEntityDataFactory;
        if (i4 - i3 < 4) {
            i = ((initRecordTimeStamp() & 255) << 24) | ((initRecordTimeStamp() & 255) << 16) | ((initRecordTimeStamp() & 255) << 8);
            i2 = initRecordTimeStamp() & 255;
        } else {
            byte[] bArr = segment.BuiltInFictitiousFunctionClassFactory;
            int i5 = i3 + 1;
            byte b = bArr[i3];
            int i6 = i5 + 1;
            byte b2 = bArr[i5];
            int i7 = i6 + 1;
            byte b3 = bArr[i6];
            int i8 = i7 + 1;
            byte b4 = bArr[i7];
            this.getAuthRequestContext -= 4;
            if (i8 == i4) {
                this.BuiltInFictitiousFunctionClassFactory = segment.MyBillsEntityDataFactory();
                SegmentPool.getAuthRequestContext(segment);
            } else {
                segment.PlaceComponentResult = i8;
            }
            i = ((b & 255) << 24) | ((b2 & 255) << 16) | ((b3 & 255) << 8);
            i2 = b4 & 255;
        }
        return i | i2;
    }

    @Override // okio.BufferedSource
    public final long newProxyInstance() {
        if (this.getAuthRequestContext < 8) {
            StringBuilder sb = new StringBuilder();
            sb.append("size < 8: ");
            sb.append(this.getAuthRequestContext);
            throw new IllegalStateException(sb.toString());
        }
        Segment segment = this.BuiltInFictitiousFunctionClassFactory;
        int i = segment.PlaceComponentResult;
        int i2 = segment.MyBillsEntityDataFactory;
        if (i2 - i < 8) {
            return ((GetContactSyncConfig() & 4294967295L) << 32) | (4294967295L & GetContactSyncConfig());
        }
        byte[] bArr = segment.BuiltInFictitiousFunctionClassFactory;
        int i3 = i + 1;
        long j = bArr[i];
        int i4 = i3 + 1;
        long j2 = bArr[i3];
        int i5 = i4 + 1;
        long j3 = bArr[i4];
        int i6 = i5 + 1;
        long j4 = bArr[i5];
        int i7 = i6 + 1;
        long j5 = bArr[i6];
        int i8 = i7 + 1;
        long j6 = bArr[i7];
        int i9 = i8 + 1;
        long j7 = bArr[i8];
        int i10 = i9 + 1;
        long j8 = bArr[i9];
        this.getAuthRequestContext -= 8;
        if (i10 == i2) {
            this.BuiltInFictitiousFunctionClassFactory = segment.MyBillsEntityDataFactory();
            SegmentPool.getAuthRequestContext(segment);
        } else {
            segment.PlaceComponentResult = i10;
        }
        return ((j7 & 255) << 8) | ((j6 & 255) << 16) | ((j & 255) << 56) | ((j2 & 255) << 48) | ((j3 & 255) << 40) | ((j4 & 255) << 32) | ((j5 & 255) << 24) | (j8 & 255);
    }

    @Override // okio.BufferedSource
    public final short isLayoutRequested() {
        return Util.PlaceComponentResult(NetworkUserEntityData$$ExternalSyntheticLambda8());
    }

    @Override // okio.BufferedSource
    public final int NetworkUserEntityData$$ExternalSyntheticLambda7() {
        return Util.MyBillsEntityDataFactory(GetContactSyncConfig());
    }

    @Override // okio.BufferedSource
    public final long PrepareContext() {
        return Util.KClassImpl$Data$declaredNonStaticMembers$2(newProxyInstance());
    }

    /* JADX WARN: Removed duplicated region for block: B:35:0x00a5  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x00af  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x00b4  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x00ba A[EDGE_INSN: B:50:0x00ba->B:41:0x00ba BREAK  A[LOOP:0: B:5:0x000f->B:53:?], SYNTHETIC] */
    @Override // okio.BufferedSource
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final long NetworkUserEntityData$$ExternalSyntheticLambda2() {
        /*
            Method dump skipped, instructions count: 206
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: okio.Buffer.NetworkUserEntityData$$ExternalSyntheticLambda2():long");
    }

    /* JADX WARN: Removed duplicated region for block: B:33:0x0092  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x009c  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x00a0  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x00a4 A[EDGE_INSN: B:43:0x00a4->B:38:0x00a4 BREAK  A[LOOP:0: B:5:0x000b->B:47:?], SYNTHETIC] */
    @Override // okio.BufferedSource
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final long DatabaseTableConfigUtil() {
        /*
            r15 = this;
            long r0 = r15.getAuthRequestContext
            r2 = 0
            int r4 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r4 == 0) goto Lab
            r0 = 0
            r4 = r2
            r1 = 0
        Lb:
            okio.Segment r6 = r15.BuiltInFictitiousFunctionClassFactory
            byte[] r7 = r6.BuiltInFictitiousFunctionClassFactory
            int r8 = r6.PlaceComponentResult
            int r9 = r6.MyBillsEntityDataFactory
        L13:
            if (r8 >= r9) goto L90
            r10 = r7[r8]
            r11 = 48
            if (r10 < r11) goto L22
            r11 = 57
            if (r10 > r11) goto L22
            int r11 = r10 + (-48)
            goto L39
        L22:
            r11 = 97
            if (r10 < r11) goto L2d
            r11 = 102(0x66, float:1.43E-43)
            if (r10 > r11) goto L2d
            int r11 = r10 + (-97)
            goto L37
        L2d:
            r11 = 65
            if (r10 < r11) goto L71
            r11 = 70
            if (r10 > r11) goto L71
            int r11 = r10 + (-65)
        L37:
            int r11 = r11 + 10
        L39:
            r12 = -1152921504606846976(0xf000000000000000, double:-3.105036184601418E231)
            long r12 = r12 & r4
            int r14 = (r12 > r2 ? 1 : (r12 == r2 ? 0 : -1))
            if (r14 != 0) goto L49
            r10 = 4
            long r4 = r4 << r10
            long r10 = (long) r11
            long r4 = r4 | r10
            int r8 = r8 + 1
            int r0 = r0 + 1
            goto L13
        L49:
            okio.Buffer r0 = new okio.Buffer
            r0.<init>()
            okio.Buffer r0 = r0.GetContactSyncConfig(r4)
            okio.Buffer r0 = r0.PlaceComponentResult(r10)
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "Number too large: "
            r1.append(r2)
            java.lang.String r0 = r0.FragmentBottomSheetPaymentSettingBinding()
            r1.append(r0)
            java.lang.NumberFormatException r0 = new java.lang.NumberFormatException
            java.lang.String r1 = r1.toString()
            r0.<init>(r1)
            throw r0
        L71:
            if (r0 == 0) goto L75
            r1 = 1
            goto L90
        L75:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "Expected leading [0-9a-fA-F] character but was 0x"
            r0.append(r1)
            java.lang.String r1 = java.lang.Integer.toHexString(r10)
            r0.append(r1)
            java.lang.NumberFormatException r1 = new java.lang.NumberFormatException
            java.lang.String r0 = r0.toString()
            r1.<init>(r0)
            throw r1
        L90:
            if (r8 != r9) goto L9c
            okio.Segment r7 = r6.MyBillsEntityDataFactory()
            r15.BuiltInFictitiousFunctionClassFactory = r7
            okio.SegmentPool.getAuthRequestContext(r6)
            goto L9e
        L9c:
            r6.PlaceComponentResult = r8
        L9e:
            if (r1 != 0) goto La4
            okio.Segment r6 = r15.BuiltInFictitiousFunctionClassFactory
            if (r6 != 0) goto Lb
        La4:
            long r1 = r15.getAuthRequestContext
            long r6 = (long) r0
            long r1 = r1 - r6
            r15.getAuthRequestContext = r1
            return r4
        Lab:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r1 = "size == 0"
            r0.<init>(r1)
            goto Lb4
        Lb3:
            throw r0
        Lb4:
            goto Lb3
        */
        throw new UnsupportedOperationException("Method not decompiled: okio.Buffer.DatabaseTableConfigUtil():long");
    }

    @Override // okio.BufferedSource
    public final ByteString MyBillsEntityDataFactory(long j) throws EOFException {
        return new ByteString(PlaceComponentResult(j));
    }

    @Override // okio.BufferedSource
    public final int MyBillsEntityDataFactory(Options options) {
        int authRequestContext = getAuthRequestContext(options, false);
        if (authRequestContext == -1) {
            return -1;
        }
        try {
            NetworkUserEntityData$$ExternalSyntheticLambda0(options.MyBillsEntityDataFactory[authRequestContext].size());
            return authRequestContext;
        } catch (EOFException unused) {
            throw new AssertionError();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Code restructure failed: missing block: B:51:0x00a1, code lost:
    
        if (r19 == false) goto L53;
     */
    /* JADX WARN: Code restructure failed: missing block: B:52:0x00a3, code lost:
    
        return -2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:53:0x00a4, code lost:
    
        return r11;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final int getAuthRequestContext(okio.Options r18, boolean r19) {
        /*
            Method dump skipped, instructions count: 165
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: okio.Buffer.getAuthRequestContext(okio.Options, boolean):int");
    }

    @Override // okio.BufferedSource
    public final void KClassImpl$Data$declaredNonStaticMembers$2(Buffer buffer, long j) throws EOFException {
        long j2 = this.getAuthRequestContext;
        if (j2 < j) {
            buffer.write(this, j2);
            throw new EOFException();
        } else {
            buffer.write(this, j);
        }
    }

    @Override // okio.BufferedSource
    public final long PlaceComponentResult(Sink sink) throws IOException {
        long j = this.getAuthRequestContext;
        if (j > 0) {
            sink.write(this, j);
        }
        return j;
    }

    @Override // okio.BufferedSource
    public final String FragmentBottomSheetPaymentSettingBinding() {
        try {
            return KClassImpl$Data$declaredNonStaticMembers$2(this.getAuthRequestContext, Util.PlaceComponentResult);
        } catch (EOFException e) {
            throw new AssertionError(e);
        }
    }

    @Override // okio.BufferedSource
    public final String getAuthRequestContext(Charset charset) {
        try {
            return KClassImpl$Data$declaredNonStaticMembers$2(this.getAuthRequestContext, charset);
        } catch (EOFException e) {
            throw new AssertionError(e);
        }
    }

    @Override // okio.BufferedSource
    public final String KClassImpl$Data$declaredNonStaticMembers$2(long j, Charset charset) throws EOFException {
        Util.MyBillsEntityDataFactory(this.getAuthRequestContext, 0L, j);
        if (charset != null) {
            if (j > 2147483647L) {
                StringBuilder sb = new StringBuilder();
                sb.append("byteCount > Integer.MAX_VALUE: ");
                sb.append(j);
                throw new IllegalArgumentException(sb.toString());
            } else if (j == 0) {
                return "";
            } else {
                Segment segment = this.BuiltInFictitiousFunctionClassFactory;
                if (segment.PlaceComponentResult + j > segment.MyBillsEntityDataFactory) {
                    return new String(PlaceComponentResult(j), charset);
                }
                String str = new String(segment.BuiltInFictitiousFunctionClassFactory, segment.PlaceComponentResult, (int) j, charset);
                segment.PlaceComponentResult = (int) (segment.PlaceComponentResult + j);
                this.getAuthRequestContext -= j;
                if (segment.PlaceComponentResult == segment.MyBillsEntityDataFactory) {
                    this.BuiltInFictitiousFunctionClassFactory = segment.MyBillsEntityDataFactory();
                    SegmentPool.getAuthRequestContext(segment);
                }
                return str;
            }
        }
        throw new IllegalArgumentException("charset == null");
    }

    @Override // okio.BufferedSource
    public final String NetworkUserEntityData$$ExternalSyntheticLambda5() throws EOFException {
        return BuiltInFictitiousFunctionClassFactory(LongCompanionObject.MAX_VALUE);
    }

    @Override // okio.BufferedSource
    public final String BuiltInFictitiousFunctionClassFactory(long j) throws EOFException {
        if (j < 0) {
            StringBuilder sb = new StringBuilder();
            sb.append("limit < 0: ");
            sb.append(j);
            throw new IllegalArgumentException(sb.toString());
        }
        long j2 = LongCompanionObject.MAX_VALUE;
        if (j != LongCompanionObject.MAX_VALUE) {
            j2 = j + 1;
        }
        long KClassImpl$Data$declaredNonStaticMembers$2 = KClassImpl$Data$declaredNonStaticMembers$2((byte) 10, 0L, j2);
        if (KClassImpl$Data$declaredNonStaticMembers$2 != -1) {
            return KClassImpl$Data$declaredNonStaticMembers$2(KClassImpl$Data$declaredNonStaticMembers$2);
        }
        if (j2 < this.getAuthRequestContext && getAuthRequestContext(j2 - 1) == 13 && getAuthRequestContext(j2) == 10) {
            return KClassImpl$Data$declaredNonStaticMembers$2(j2);
        }
        Buffer buffer = new Buffer();
        BuiltInFictitiousFunctionClassFactory(buffer, 0L, Math.min(32L, this.getAuthRequestContext));
        StringBuilder sb2 = new StringBuilder();
        sb2.append("\\n not found: limit=");
        sb2.append(Math.min(this.getAuthRequestContext, j));
        sb2.append(" content=");
        sb2.append(new ByteString(buffer.NetworkUserEntityData$$ExternalSyntheticLambda1()).hex());
        sb2.append(Typography.ellipsis);
        throw new EOFException(sb2.toString());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final String KClassImpl$Data$declaredNonStaticMembers$2(long j) throws EOFException {
        if (j > 0) {
            long j2 = j - 1;
            if (getAuthRequestContext(j2) == 13) {
                String KClassImpl$Data$declaredNonStaticMembers$2 = KClassImpl$Data$declaredNonStaticMembers$2(j2, Util.PlaceComponentResult);
                NetworkUserEntityData$$ExternalSyntheticLambda0(2L);
                return KClassImpl$Data$declaredNonStaticMembers$2;
            }
        }
        String KClassImpl$Data$declaredNonStaticMembers$22 = KClassImpl$Data$declaredNonStaticMembers$2(j, Util.PlaceComponentResult);
        NetworkUserEntityData$$ExternalSyntheticLambda0(1L);
        return KClassImpl$Data$declaredNonStaticMembers$22;
    }

    @Override // okio.BufferedSource
    public final byte[] NetworkUserEntityData$$ExternalSyntheticLambda1() {
        try {
            return PlaceComponentResult(this.getAuthRequestContext);
        } catch (EOFException e) {
            throw new AssertionError(e);
        }
    }

    @Override // okio.BufferedSource
    public final byte[] PlaceComponentResult(long j) throws EOFException {
        Util.MyBillsEntityDataFactory(this.getAuthRequestContext, 0L, j);
        if (j > 2147483647L) {
            StringBuilder sb = new StringBuilder();
            sb.append("byteCount > Integer.MAX_VALUE: ");
            sb.append(j);
            throw new IllegalArgumentException(sb.toString());
        }
        byte[] bArr = new byte[(int) j];
        BuiltInFictitiousFunctionClassFactory(bArr);
        return bArr;
    }

    @Override // okio.BufferedSource
    public final void BuiltInFictitiousFunctionClassFactory(byte[] bArr) throws EOFException {
        int i = 0;
        while (i < bArr.length) {
            int authRequestContext = getAuthRequestContext(bArr, i, bArr.length - i);
            if (authRequestContext == -1) {
                throw new EOFException();
            }
            i += authRequestContext;
        }
    }

    public final int getAuthRequestContext(byte[] bArr, int i, int i2) {
        Util.MyBillsEntityDataFactory(bArr.length, i, i2);
        Segment segment = this.BuiltInFictitiousFunctionClassFactory;
        if (segment == null) {
            return -1;
        }
        int min = Math.min(i2, segment.MyBillsEntityDataFactory - segment.PlaceComponentResult);
        System.arraycopy(segment.BuiltInFictitiousFunctionClassFactory, segment.PlaceComponentResult, bArr, i, min);
        segment.PlaceComponentResult += min;
        this.getAuthRequestContext -= min;
        if (segment.PlaceComponentResult == segment.MyBillsEntityDataFactory) {
            this.BuiltInFictitiousFunctionClassFactory = segment.MyBillsEntityDataFactory();
            SegmentPool.getAuthRequestContext(segment);
        }
        return min;
    }

    @Override // java.nio.channels.ReadableByteChannel
    public final int read(ByteBuffer byteBuffer) throws IOException {
        Segment segment = this.BuiltInFictitiousFunctionClassFactory;
        if (segment == null) {
            return -1;
        }
        int min = Math.min(byteBuffer.remaining(), segment.MyBillsEntityDataFactory - segment.PlaceComponentResult);
        byteBuffer.put(segment.BuiltInFictitiousFunctionClassFactory, segment.PlaceComponentResult, min);
        segment.PlaceComponentResult += min;
        this.getAuthRequestContext -= min;
        if (segment.PlaceComponentResult == segment.MyBillsEntityDataFactory) {
            this.BuiltInFictitiousFunctionClassFactory = segment.MyBillsEntityDataFactory();
            SegmentPool.getAuthRequestContext(segment);
        }
        return min;
    }

    @Override // okio.BufferedSource
    public final void NetworkUserEntityData$$ExternalSyntheticLambda0(long j) throws EOFException {
        while (j > 0) {
            if (this.BuiltInFictitiousFunctionClassFactory == null) {
                throw new EOFException();
            }
            int min = (int) Math.min(j, r0.MyBillsEntityDataFactory - this.BuiltInFictitiousFunctionClassFactory.PlaceComponentResult);
            long j2 = min;
            this.getAuthRequestContext -= j2;
            j -= j2;
            this.BuiltInFictitiousFunctionClassFactory.PlaceComponentResult += min;
            if (this.BuiltInFictitiousFunctionClassFactory.PlaceComponentResult == this.BuiltInFictitiousFunctionClassFactory.MyBillsEntityDataFactory) {
                Segment segment = this.BuiltInFictitiousFunctionClassFactory;
                this.BuiltInFictitiousFunctionClassFactory = segment.MyBillsEntityDataFactory();
                SegmentPool.getAuthRequestContext(segment);
            }
        }
    }

    @Override // okio.BufferedSink
    /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: merged with bridge method [inline-methods] */
    public final Buffer PlaceComponentResult(String str, int i, int i2) {
        if (str != null) {
            if (i < 0) {
                StringBuilder sb = new StringBuilder();
                sb.append("beginIndex < 0: ");
                sb.append(i);
                throw new IllegalArgumentException(sb.toString());
            } else if (i2 < i) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("endIndex < beginIndex: ");
                sb2.append(i2);
                sb2.append(" < ");
                sb2.append(i);
                throw new IllegalArgumentException(sb2.toString());
            } else if (i2 > str.length()) {
                StringBuilder sb3 = new StringBuilder();
                sb3.append("endIndex > string.length: ");
                sb3.append(i2);
                sb3.append(" > ");
                sb3.append(str.length());
                throw new IllegalArgumentException(sb3.toString());
            } else {
                while (i < i2) {
                    char charAt = str.charAt(i);
                    if (charAt < 128) {
                        Segment MyBillsEntityDataFactory2 = MyBillsEntityDataFactory(1);
                        byte[] bArr = MyBillsEntityDataFactory2.BuiltInFictitiousFunctionClassFactory;
                        int i3 = MyBillsEntityDataFactory2.MyBillsEntityDataFactory - i;
                        int min = Math.min(i2, 8192 - i3);
                        bArr[i + i3] = (byte) charAt;
                        i++;
                        while (i < min) {
                            char charAt2 = str.charAt(i);
                            if (charAt2 >= 128) {
                                break;
                            }
                            bArr[i + i3] = (byte) charAt2;
                            i++;
                        }
                        int i4 = (i3 + i) - MyBillsEntityDataFactory2.MyBillsEntityDataFactory;
                        MyBillsEntityDataFactory2.MyBillsEntityDataFactory += i4;
                        this.getAuthRequestContext += i4;
                    } else {
                        if (charAt < 2048) {
                            PlaceComponentResult((charAt >> 6) | 192);
                            PlaceComponentResult((charAt & '?') | 128);
                        } else if (charAt < 55296 || charAt > 57343) {
                            PlaceComponentResult((charAt >> '\f') | 224);
                            PlaceComponentResult(((charAt >> 6) & 63) | 128);
                            PlaceComponentResult((charAt & '?') | 128);
                        } else {
                            int i5 = i + 1;
                            char charAt3 = i5 < i2 ? str.charAt(i5) : (char) 0;
                            if (charAt > 56319 || charAt3 < 56320 || charAt3 > 57343) {
                                PlaceComponentResult(63);
                                i = i5;
                            } else {
                                int i6 = (((charAt & 10239) << 10) | (9215 & charAt3)) + 65536;
                                PlaceComponentResult((i6 >> 18) | 240);
                                PlaceComponentResult(((i6 >> 12) & 63) | 128);
                                PlaceComponentResult(((i6 >> 6) & 63) | 128);
                                PlaceComponentResult((i6 & 63) | 128);
                                i += 2;
                            }
                        }
                        i++;
                    }
                }
                return this;
            }
        }
        throw new IllegalArgumentException("string == null");
    }

    public final Buffer getErrorConfigVersion(int i) {
        if (i < 128) {
            PlaceComponentResult(i);
        } else if (i < 2048) {
            PlaceComponentResult((i >> 6) | 192);
            PlaceComponentResult((i & 63) | 128);
        } else if (i < 65536) {
            if (i >= 55296 && i <= 57343) {
                PlaceComponentResult(63);
            } else {
                PlaceComponentResult((i >> 12) | 224);
                PlaceComponentResult(((i >> 6) & 63) | 128);
                PlaceComponentResult((i & 63) | 128);
            }
        } else if (i <= 1114111) {
            PlaceComponentResult((i >> 18) | 240);
            PlaceComponentResult(((i >> 12) & 63) | 128);
            PlaceComponentResult(((i >> 6) & 63) | 128);
            PlaceComponentResult((i & 63) | 128);
        } else {
            StringBuilder sb = new StringBuilder();
            sb.append("Unexpected code point: ");
            sb.append(Integer.toHexString(i));
            throw new IllegalArgumentException(sb.toString());
        }
        return this;
    }

    public final Buffer MyBillsEntityDataFactory(String str, int i, int i2, Charset charset) {
        if (str != null) {
            if (i < 0) {
                StringBuilder sb = new StringBuilder();
                sb.append("beginIndex < 0: ");
                sb.append(i);
                throw new IllegalAccessError(sb.toString());
            } else if (i2 < i) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("endIndex < beginIndex: ");
                sb2.append(i2);
                sb2.append(" < ");
                sb2.append(i);
                throw new IllegalArgumentException(sb2.toString());
            } else if (i2 <= str.length()) {
                if (charset == null) {
                    throw new IllegalArgumentException("charset == null");
                }
                if (charset.equals(Util.PlaceComponentResult)) {
                    return PlaceComponentResult(str, i, i2);
                }
                byte[] bytes = str.substring(i, i2).getBytes(charset);
                return MyBillsEntityDataFactory(bytes, 0, bytes.length);
            } else {
                StringBuilder sb3 = new StringBuilder();
                sb3.append("endIndex > string.length: ");
                sb3.append(i2);
                sb3.append(" > ");
                sb3.append(str.length());
                throw new IllegalArgumentException(sb3.toString());
            }
        }
        throw new IllegalArgumentException("string == null");
    }

    public final Buffer KClassImpl$Data$declaredNonStaticMembers$2(byte[] bArr) {
        if (bArr == null) {
            throw new IllegalArgumentException("source == null");
        }
        return MyBillsEntityDataFactory(bArr, 0, bArr.length);
    }

    @Override // okio.BufferedSink
    /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: merged with bridge method [inline-methods] */
    public final Buffer MyBillsEntityDataFactory(byte[] bArr, int i, int i2) {
        if (bArr == null) {
            throw new IllegalArgumentException("source == null");
        }
        long j = i2;
        Util.MyBillsEntityDataFactory(bArr.length, i, j);
        int i3 = i2 + i;
        while (i < i3) {
            Segment MyBillsEntityDataFactory2 = MyBillsEntityDataFactory(1);
            int min = Math.min(i3 - i, 8192 - MyBillsEntityDataFactory2.MyBillsEntityDataFactory);
            System.arraycopy(bArr, i, MyBillsEntityDataFactory2.BuiltInFictitiousFunctionClassFactory, MyBillsEntityDataFactory2.MyBillsEntityDataFactory, min);
            i += min;
            MyBillsEntityDataFactory2.MyBillsEntityDataFactory += min;
        }
        this.getAuthRequestContext += j;
        return this;
    }

    @Override // java.nio.channels.WritableByteChannel
    public final int write(ByteBuffer byteBuffer) throws IOException {
        if (byteBuffer == null) {
            throw new IllegalArgumentException("source == null");
        }
        int remaining = byteBuffer.remaining();
        int i = remaining;
        while (i > 0) {
            Segment MyBillsEntityDataFactory2 = MyBillsEntityDataFactory(1);
            int min = Math.min(i, 8192 - MyBillsEntityDataFactory2.MyBillsEntityDataFactory);
            byteBuffer.get(MyBillsEntityDataFactory2.BuiltInFictitiousFunctionClassFactory, MyBillsEntityDataFactory2.MyBillsEntityDataFactory, min);
            i -= min;
            MyBillsEntityDataFactory2.MyBillsEntityDataFactory += min;
        }
        this.getAuthRequestContext += remaining;
        return remaining;
    }

    @Override // okio.BufferedSink
    public final long BuiltInFictitiousFunctionClassFactory(Source source) throws IOException {
        if (source == null) {
            throw new IllegalArgumentException("source == null");
        }
        long j = 0;
        while (true) {
            long read = source.read(this, 8192L);
            if (read == -1) {
                return j;
            }
            j += read;
        }
    }

    @Override // okio.BufferedSink
    /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: merged with bridge method [inline-methods] */
    public final Buffer PlaceComponentResult(int i) {
        Segment MyBillsEntityDataFactory2 = MyBillsEntityDataFactory(1);
        byte[] bArr = MyBillsEntityDataFactory2.BuiltInFictitiousFunctionClassFactory;
        int i2 = MyBillsEntityDataFactory2.MyBillsEntityDataFactory;
        MyBillsEntityDataFactory2.MyBillsEntityDataFactory = i2 + 1;
        bArr[i2] = (byte) i;
        this.getAuthRequestContext++;
        return this;
    }

    @Override // okio.BufferedSink
    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda0  reason: merged with bridge method [inline-methods] */
    public final Buffer moveToNextValue(int i) {
        Segment MyBillsEntityDataFactory2 = MyBillsEntityDataFactory(2);
        byte[] bArr = MyBillsEntityDataFactory2.BuiltInFictitiousFunctionClassFactory;
        int i2 = MyBillsEntityDataFactory2.MyBillsEntityDataFactory;
        int i3 = i2 + 1;
        bArr[i2] = (byte) ((i >>> 8) & 255);
        bArr[i3] = (byte) (i & 255);
        MyBillsEntityDataFactory2.MyBillsEntityDataFactory = i3 + 1;
        this.getAuthRequestContext += 2;
        return this;
    }

    @Override // okio.BufferedSink
    /* renamed from: getAuthRequestContext  reason: merged with bridge method [inline-methods] */
    public final Buffer BuiltInFictitiousFunctionClassFactory(int i) {
        Segment MyBillsEntityDataFactory2 = MyBillsEntityDataFactory(4);
        byte[] bArr = MyBillsEntityDataFactory2.BuiltInFictitiousFunctionClassFactory;
        int i2 = MyBillsEntityDataFactory2.MyBillsEntityDataFactory;
        int i3 = i2 + 1;
        bArr[i2] = (byte) ((i >>> 24) & 255);
        int i4 = i3 + 1;
        bArr[i3] = (byte) ((i >>> 16) & 255);
        int i5 = i4 + 1;
        bArr[i4] = (byte) ((i >>> 8) & 255);
        bArr[i5] = (byte) (i & 255);
        MyBillsEntityDataFactory2.MyBillsEntityDataFactory = i5 + 1;
        this.getAuthRequestContext += 4;
        return this;
    }

    public final Buffer initRecordTimeStamp(long j) {
        Segment MyBillsEntityDataFactory2 = MyBillsEntityDataFactory(8);
        byte[] bArr = MyBillsEntityDataFactory2.BuiltInFictitiousFunctionClassFactory;
        int i = MyBillsEntityDataFactory2.MyBillsEntityDataFactory;
        int i2 = i + 1;
        bArr[i] = (byte) ((j >>> 56) & 255);
        int i3 = i2 + 1;
        bArr[i2] = (byte) ((j >>> 48) & 255);
        int i4 = i3 + 1;
        bArr[i3] = (byte) ((j >>> 40) & 255);
        int i5 = i4 + 1;
        bArr[i4] = (byte) ((j >>> 32) & 255);
        int i6 = i5 + 1;
        bArr[i5] = (byte) ((j >>> 24) & 255);
        int i7 = i6 + 1;
        bArr[i6] = (byte) ((j >>> 16) & 255);
        int i8 = i7 + 1;
        bArr[i7] = (byte) ((j >>> 8) & 255);
        bArr[i8] = (byte) (j & 255);
        MyBillsEntityDataFactory2.MyBillsEntityDataFactory = i8 + 1;
        this.getAuthRequestContext += 8;
        return this;
    }

    @Override // okio.BufferedSink
    /* renamed from: scheduleImpl  reason: merged with bridge method [inline-methods] */
    public final Buffer moveToNextValue(long j) {
        if (j == 0) {
            return PlaceComponentResult(48);
        }
        boolean z = false;
        if (j < 0) {
            j = -j;
            if (j < 0) {
                return PlaceComponentResult("-9223372036854775808", 0, 20);
            }
            z = true;
        }
        int i = j < 100000000 ? j < 10000 ? j < 100 ? j >= 10 ? 2 : 1 : j < 1000 ? 3 : 4 : j < 1000000 ? j < 100000 ? 5 : 6 : j < 10000000 ? 7 : 8 : j < 1000000000000L ? j < 10000000000L ? j < 1000000000 ? 9 : 10 : j < 100000000000L ? 11 : 12 : j < 1000000000000000L ? j < 10000000000000L ? 13 : j < 100000000000000L ? 14 : 15 : j < 100000000000000000L ? j < 10000000000000000L ? 16 : 17 : j < 1000000000000000000L ? 18 : 19;
        if (z) {
            i++;
        }
        Segment MyBillsEntityDataFactory2 = MyBillsEntityDataFactory(i);
        byte[] bArr = MyBillsEntityDataFactory2.BuiltInFictitiousFunctionClassFactory;
        int i2 = MyBillsEntityDataFactory2.MyBillsEntityDataFactory + i;
        while (j != 0) {
            i2--;
            bArr[i2] = MyBillsEntityDataFactory[(int) (j % 10)];
            j /= 10;
        }
        if (z) {
            bArr[i2 - 1] = 45;
        }
        MyBillsEntityDataFactory2.MyBillsEntityDataFactory += i;
        this.getAuthRequestContext += i;
        return this;
    }

    @Override // okio.BufferedSink
    /* renamed from: DatabaseTableConfigUtil  reason: merged with bridge method [inline-methods] */
    public final Buffer GetContactSyncConfig(long j) {
        if (j == 0) {
            return PlaceComponentResult(48);
        }
        int numberOfTrailingZeros = (Long.numberOfTrailingZeros(Long.highestOneBit(j)) / 4) + 1;
        Segment MyBillsEntityDataFactory2 = MyBillsEntityDataFactory(numberOfTrailingZeros);
        byte[] bArr = MyBillsEntityDataFactory2.BuiltInFictitiousFunctionClassFactory;
        int i = MyBillsEntityDataFactory2.MyBillsEntityDataFactory;
        for (int i2 = (MyBillsEntityDataFactory2.MyBillsEntityDataFactory + numberOfTrailingZeros) - 1; i2 >= i; i2--) {
            bArr[i2] = MyBillsEntityDataFactory[(int) (15 & j)];
            j >>>= 4;
        }
        MyBillsEntityDataFactory2.MyBillsEntityDataFactory += numberOfTrailingZeros;
        this.getAuthRequestContext += numberOfTrailingZeros;
        return this;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final Segment MyBillsEntityDataFactory(int i) {
        if (i <= 0 || i > 8192) {
            throw new IllegalArgumentException();
        }
        Segment segment = this.BuiltInFictitiousFunctionClassFactory;
        if (segment == null) {
            Segment PlaceComponentResult = SegmentPool.PlaceComponentResult();
            this.BuiltInFictitiousFunctionClassFactory = PlaceComponentResult;
            PlaceComponentResult.lookAheadTest = PlaceComponentResult;
            PlaceComponentResult.getAuthRequestContext = PlaceComponentResult;
            return PlaceComponentResult;
        }
        Segment segment2 = segment.lookAheadTest;
        if (segment2.MyBillsEntityDataFactory + i > 8192 || !segment2.KClassImpl$Data$declaredNonStaticMembers$2) {
            Segment PlaceComponentResult2 = SegmentPool.PlaceComponentResult();
            PlaceComponentResult2.lookAheadTest = segment2;
            PlaceComponentResult2.getAuthRequestContext = segment2.getAuthRequestContext;
            segment2.getAuthRequestContext.lookAheadTest = PlaceComponentResult2;
            segment2.getAuthRequestContext = PlaceComponentResult2;
            return PlaceComponentResult2;
        }
        return segment2;
    }

    @Override // okio.Sink
    public final void write(Buffer buffer, long j) {
        Segment PlaceComponentResult;
        if (buffer == null) {
            throw new IllegalArgumentException("source == null");
        }
        if (buffer == this) {
            throw new IllegalArgumentException("source == this");
        }
        Util.MyBillsEntityDataFactory(buffer.getAuthRequestContext, 0L, j);
        while (j > 0) {
            if (j < buffer.BuiltInFictitiousFunctionClassFactory.MyBillsEntityDataFactory - buffer.BuiltInFictitiousFunctionClassFactory.PlaceComponentResult) {
                Segment segment = this.BuiltInFictitiousFunctionClassFactory;
                Segment segment2 = segment != null ? segment.lookAheadTest : null;
                if (segment2 != null && segment2.KClassImpl$Data$declaredNonStaticMembers$2) {
                    if ((segment2.MyBillsEntityDataFactory + j) - (segment2.moveToNextValue ? 0 : segment2.PlaceComponentResult) <= 8192) {
                        buffer.BuiltInFictitiousFunctionClassFactory.KClassImpl$Data$declaredNonStaticMembers$2(segment2, (int) j);
                        buffer.getAuthRequestContext -= j;
                        this.getAuthRequestContext += j;
                        return;
                    }
                }
                Segment segment3 = buffer.BuiltInFictitiousFunctionClassFactory;
                int i = (int) j;
                if (i <= 0 || i > segment3.MyBillsEntityDataFactory - segment3.PlaceComponentResult) {
                    throw new IllegalArgumentException();
                }
                if (i < 1024) {
                    PlaceComponentResult = SegmentPool.PlaceComponentResult();
                    System.arraycopy(segment3.BuiltInFictitiousFunctionClassFactory, segment3.PlaceComponentResult, PlaceComponentResult.BuiltInFictitiousFunctionClassFactory, 0, i);
                } else {
                    segment3.moveToNextValue = true;
                    PlaceComponentResult = new Segment(segment3.BuiltInFictitiousFunctionClassFactory, segment3.PlaceComponentResult, segment3.MyBillsEntityDataFactory, true, false);
                }
                PlaceComponentResult.MyBillsEntityDataFactory = PlaceComponentResult.PlaceComponentResult + i;
                segment3.PlaceComponentResult += i;
                Segment segment4 = segment3.lookAheadTest;
                PlaceComponentResult.lookAheadTest = segment4;
                PlaceComponentResult.getAuthRequestContext = segment4.getAuthRequestContext;
                segment4.getAuthRequestContext.lookAheadTest = PlaceComponentResult;
                segment4.getAuthRequestContext = PlaceComponentResult;
                buffer.BuiltInFictitiousFunctionClassFactory = PlaceComponentResult;
            }
            Segment segment5 = buffer.BuiltInFictitiousFunctionClassFactory;
            long j2 = segment5.MyBillsEntityDataFactory - segment5.PlaceComponentResult;
            buffer.BuiltInFictitiousFunctionClassFactory = segment5.MyBillsEntityDataFactory();
            Segment segment6 = this.BuiltInFictitiousFunctionClassFactory;
            if (segment6 == null) {
                this.BuiltInFictitiousFunctionClassFactory = segment5;
                segment5.lookAheadTest = segment5;
                segment5.getAuthRequestContext = segment5;
            } else {
                Segment segment7 = segment6.lookAheadTest;
                segment5.lookAheadTest = segment7;
                segment5.getAuthRequestContext = segment7.getAuthRequestContext;
                segment7.getAuthRequestContext.lookAheadTest = segment5;
                segment7.getAuthRequestContext = segment5;
                Segment segment8 = segment5.lookAheadTest;
                if (segment8 == segment5) {
                    throw new IllegalStateException();
                }
                if (segment8.KClassImpl$Data$declaredNonStaticMembers$2) {
                    int i2 = segment5.MyBillsEntityDataFactory - segment5.PlaceComponentResult;
                    if (i2 <= (8192 - segment8.MyBillsEntityDataFactory) + (segment8.moveToNextValue ? 0 : segment8.PlaceComponentResult)) {
                        segment5.KClassImpl$Data$declaredNonStaticMembers$2(segment8, i2);
                        segment5.MyBillsEntityDataFactory();
                        SegmentPool.getAuthRequestContext(segment5);
                    }
                }
            }
            buffer.getAuthRequestContext -= j2;
            this.getAuthRequestContext += j2;
            j -= j2;
        }
    }

    @Override // okio.Source
    public final long read(Buffer buffer, long j) {
        if (buffer != null) {
            if (j < 0) {
                StringBuilder sb = new StringBuilder();
                sb.append("byteCount < 0: ");
                sb.append(j);
                throw new IllegalArgumentException(sb.toString());
            }
            long j2 = this.getAuthRequestContext;
            if (j2 == 0) {
                return -1L;
            }
            if (j > j2) {
                j = j2;
            }
            buffer.write(this, j);
            return j;
        }
        throw new IllegalArgumentException("sink == null");
    }

    @Override // okio.BufferedSource
    public final long getErrorConfigVersion() {
        return KClassImpl$Data$declaredNonStaticMembers$2((byte) 0, 0L, LongCompanionObject.MAX_VALUE);
    }

    public final long KClassImpl$Data$declaredNonStaticMembers$2(byte b, long j, long j2) {
        Segment segment;
        long j3 = 0;
        if (j < 0 || j2 < j) {
            throw new IllegalArgumentException(String.format("size=%s fromIndex=%s toIndex=%s", Long.valueOf(this.getAuthRequestContext), Long.valueOf(j), Long.valueOf(j2)));
        }
        long j4 = this.getAuthRequestContext;
        long j5 = j2 > j4 ? j4 : j2;
        if (j == j5 || (segment = this.BuiltInFictitiousFunctionClassFactory) == null) {
            return -1L;
        }
        if (j4 - j < j) {
            while (j4 > j) {
                segment = segment.lookAheadTest;
                j4 -= segment.MyBillsEntityDataFactory - segment.PlaceComponentResult;
            }
        } else {
            while (true) {
                long j6 = (segment.MyBillsEntityDataFactory - segment.PlaceComponentResult) + j3;
                if (j6 >= j) {
                    break;
                }
                segment = segment.getAuthRequestContext;
                j3 = j6;
            }
            j4 = j3;
        }
        long j7 = j;
        while (j4 < j5) {
            byte[] bArr = segment.BuiltInFictitiousFunctionClassFactory;
            int min = (int) Math.min(segment.MyBillsEntityDataFactory, (segment.PlaceComponentResult + j5) - j4);
            for (int i = (int) ((segment.PlaceComponentResult + j7) - j4); i < min; i++) {
                if (bArr[i] == b) {
                    return (i - segment.PlaceComponentResult) + j4;
                }
            }
            j4 += segment.MyBillsEntityDataFactory - segment.PlaceComponentResult;
            segment = segment.getAuthRequestContext;
            j7 = j4;
        }
        return -1L;
    }

    @Override // okio.BufferedSource
    public final long KClassImpl$Data$declaredNonStaticMembers$2(ByteString byteString) throws IOException {
        return BuiltInFictitiousFunctionClassFactory(byteString, 0L);
    }

    public final long BuiltInFictitiousFunctionClassFactory(ByteString byteString, long j) throws IOException {
        if (byteString.size() != 0) {
            long j2 = 0;
            if (j < 0) {
                throw new IllegalArgumentException("fromIndex < 0");
            }
            Segment segment = this.BuiltInFictitiousFunctionClassFactory;
            long j3 = -1;
            if (segment == null) {
                return -1L;
            }
            long j4 = this.getAuthRequestContext;
            if (j4 - j < j) {
                while (j4 > j) {
                    segment = segment.lookAheadTest;
                    j4 -= segment.MyBillsEntityDataFactory - segment.PlaceComponentResult;
                }
            } else {
                while (true) {
                    long j5 = (segment.MyBillsEntityDataFactory - segment.PlaceComponentResult) + j2;
                    if (j5 >= j) {
                        break;
                    }
                    segment = segment.getAuthRequestContext;
                    j2 = j5;
                }
                j4 = j2;
            }
            byte b = byteString.getByte(0);
            int size = byteString.size();
            long j6 = (this.getAuthRequestContext - size) + 1;
            long j7 = j4;
            long j8 = j;
            while (j7 < j6) {
                byte[] bArr = segment.BuiltInFictitiousFunctionClassFactory;
                int min = (int) Math.min(segment.MyBillsEntityDataFactory, (segment.PlaceComponentResult + j6) - j7);
                for (int i = (int) ((segment.PlaceComponentResult + j8) - j7); i < min; i++) {
                    if (bArr[i] == b && getAuthRequestContext(segment, i + 1, byteString, 1, size)) {
                        return (i - segment.PlaceComponentResult) + j7;
                    }
                }
                j7 += segment.MyBillsEntityDataFactory - segment.PlaceComponentResult;
                segment = segment.getAuthRequestContext;
                j8 = j7;
                j3 = -1;
            }
            return j3;
        }
        throw new IllegalArgumentException("bytes is empty");
    }

    @Override // okio.BufferedSource
    public final long MyBillsEntityDataFactory(ByteString byteString) {
        return MyBillsEntityDataFactory(byteString, 0L);
    }

    public final long MyBillsEntityDataFactory(ByteString byteString, long j) {
        int i;
        long j2 = 0;
        if (j < 0) {
            throw new IllegalArgumentException("fromIndex < 0");
        }
        Segment segment = this.BuiltInFictitiousFunctionClassFactory;
        if (segment == null) {
            return -1L;
        }
        long j3 = this.getAuthRequestContext;
        if (j3 - j < j) {
            while (j3 > j) {
                segment = segment.lookAheadTest;
                j3 -= segment.MyBillsEntityDataFactory - segment.PlaceComponentResult;
            }
        } else {
            while (true) {
                long j4 = (segment.MyBillsEntityDataFactory - segment.PlaceComponentResult) + j2;
                if (j4 >= j) {
                    break;
                }
                segment = segment.getAuthRequestContext;
                j2 = j4;
            }
            j3 = j2;
        }
        if (byteString.size() == 2) {
            byte b = byteString.getByte(0);
            byte b2 = byteString.getByte(1);
            while (j3 < this.getAuthRequestContext) {
                byte[] bArr = segment.BuiltInFictitiousFunctionClassFactory;
                i = (int) ((segment.PlaceComponentResult + j) - j3);
                int i2 = segment.MyBillsEntityDataFactory;
                while (i < i2) {
                    byte b3 = bArr[i];
                    if (b3 != b && b3 != b2) {
                        i++;
                    }
                    return (i - segment.PlaceComponentResult) + j3;
                }
                j3 += segment.MyBillsEntityDataFactory - segment.PlaceComponentResult;
                segment = segment.getAuthRequestContext;
                j = j3;
            }
            return -1L;
        }
        byte[] internalArray = byteString.internalArray();
        while (j3 < this.getAuthRequestContext) {
            byte[] bArr2 = segment.BuiltInFictitiousFunctionClassFactory;
            i = (int) ((segment.PlaceComponentResult + j) - j3);
            int i3 = segment.MyBillsEntityDataFactory;
            while (i < i3) {
                byte b4 = bArr2[i];
                for (byte b5 : internalArray) {
                    if (b4 == b5) {
                        return (i - segment.PlaceComponentResult) + j3;
                    }
                }
                i++;
            }
            j3 += segment.MyBillsEntityDataFactory - segment.PlaceComponentResult;
            segment = segment.getAuthRequestContext;
            j = j3;
        }
        return -1L;
    }

    @Override // okio.BufferedSource
    public final boolean PlaceComponentResult(ByteString byteString) {
        return KClassImpl$Data$declaredNonStaticMembers$2(byteString, byteString.size());
    }

    private boolean KClassImpl$Data$declaredNonStaticMembers$2(ByteString byteString, int i) {
        if (i < 0 || this.getAuthRequestContext - 0 < i || byteString.size() - 0 < i) {
            return false;
        }
        for (int i2 = 0; i2 < i; i2++) {
            if (getAuthRequestContext(i2 + 0) != byteString.getByte(i2 + 0)) {
                return false;
            }
        }
        return true;
    }

    private static boolean getAuthRequestContext(Segment segment, int i, ByteString byteString, int i2, int i3) {
        int i4 = segment.MyBillsEntityDataFactory;
        byte[] bArr = segment.BuiltInFictitiousFunctionClassFactory;
        while (i2 < i3) {
            if (i == i4) {
                segment = segment.getAuthRequestContext;
                byte[] bArr2 = segment.BuiltInFictitiousFunctionClassFactory;
                bArr = bArr2;
                i = segment.PlaceComponentResult;
                i4 = segment.MyBillsEntityDataFactory;
            }
            if (bArr[i] != byteString.getByte(i2)) {
                return false;
            }
            i++;
            i2++;
        }
        return true;
    }

    @Override // okio.Source
    public final Timeout timeout() {
        return Timeout.NONE;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof Buffer) {
            Buffer buffer = (Buffer) obj;
            long j = this.getAuthRequestContext;
            if (j != buffer.getAuthRequestContext) {
                return false;
            }
            long j2 = 0;
            if (j == 0) {
                return true;
            }
            Segment segment = this.BuiltInFictitiousFunctionClassFactory;
            Segment segment2 = buffer.BuiltInFictitiousFunctionClassFactory;
            int i = segment.PlaceComponentResult;
            int i2 = segment2.PlaceComponentResult;
            while (j2 < this.getAuthRequestContext) {
                long min = Math.min(segment.MyBillsEntityDataFactory - i, segment2.MyBillsEntityDataFactory - i2);
                int i3 = 0;
                while (i3 < min) {
                    if (segment.BuiltInFictitiousFunctionClassFactory[i] != segment2.BuiltInFictitiousFunctionClassFactory[i2]) {
                        return false;
                    }
                    i3++;
                    i++;
                    i2++;
                }
                if (i == segment.MyBillsEntityDataFactory) {
                    segment = segment.getAuthRequestContext;
                    i = segment.PlaceComponentResult;
                }
                if (i2 == segment2.MyBillsEntityDataFactory) {
                    segment2 = segment2.getAuthRequestContext;
                    i2 = segment2.PlaceComponentResult;
                }
                j2 += min;
            }
            return true;
        }
        return false;
    }

    public final int hashCode() {
        Segment segment = this.BuiltInFictitiousFunctionClassFactory;
        if (segment == null) {
            return 0;
        }
        int i = 1;
        do {
            int i2 = segment.MyBillsEntityDataFactory;
            for (int i3 = segment.PlaceComponentResult; i3 < i2; i3++) {
                i = (i * 31) + segment.BuiltInFictitiousFunctionClassFactory[i3];
            }
            segment = segment.getAuthRequestContext;
        } while (segment != this.BuiltInFictitiousFunctionClassFactory);
        return i;
    }

    /* renamed from: getAuthRequestContext  reason: merged with bridge method [inline-methods] */
    public final Buffer clone() {
        Buffer buffer = new Buffer();
        if (this.getAuthRequestContext == 0) {
            return buffer;
        }
        Segment segment = this.BuiltInFictitiousFunctionClassFactory;
        segment.moveToNextValue = true;
        Segment segment2 = new Segment(segment.BuiltInFictitiousFunctionClassFactory, segment.PlaceComponentResult, segment.MyBillsEntityDataFactory, true, false);
        buffer.BuiltInFictitiousFunctionClassFactory = segment2;
        segment2.lookAheadTest = segment2;
        segment2.getAuthRequestContext = segment2;
        Segment segment3 = this.BuiltInFictitiousFunctionClassFactory;
        while (true) {
            segment3 = segment3.getAuthRequestContext;
            if (segment3 != this.BuiltInFictitiousFunctionClassFactory) {
                Segment segment4 = buffer.BuiltInFictitiousFunctionClassFactory.lookAheadTest;
                segment3.moveToNextValue = true;
                Segment segment5 = new Segment(segment3.BuiltInFictitiousFunctionClassFactory, segment3.PlaceComponentResult, segment3.MyBillsEntityDataFactory, true, false);
                segment5.lookAheadTest = segment4;
                segment5.getAuthRequestContext = segment4.getAuthRequestContext;
                segment4.getAuthRequestContext.lookAheadTest = segment5;
                segment4.getAuthRequestContext = segment5;
            } else {
                buffer.getAuthRequestContext = this.getAuthRequestContext;
                return buffer;
            }
        }
    }

    /* loaded from: classes2.dex */
    public static final class UnsafeCursor implements Closeable {
        public boolean BuiltInFictitiousFunctionClassFactory;
        public byte[] KClassImpl$Data$declaredNonStaticMembers$2;
        public Buffer PlaceComponentResult;
        private Segment lookAheadTest;
        public long getAuthRequestContext = -1;
        public int NetworkUserEntityData$$ExternalSyntheticLambda0 = -1;
        public int MyBillsEntityDataFactory = -1;

        public final int MyBillsEntityDataFactory(long j) {
            if (j < -1 || j > this.PlaceComponentResult.getAuthRequestContext) {
                throw new ArrayIndexOutOfBoundsException(String.format("offset=%s > size=%s", Long.valueOf(j), Long.valueOf(this.PlaceComponentResult.getAuthRequestContext)));
            }
            if (j == -1 || j == this.PlaceComponentResult.getAuthRequestContext) {
                this.lookAheadTest = null;
                this.getAuthRequestContext = j;
                this.KClassImpl$Data$declaredNonStaticMembers$2 = null;
                this.NetworkUserEntityData$$ExternalSyntheticLambda0 = -1;
                this.MyBillsEntityDataFactory = -1;
                return -1;
            }
            long j2 = this.PlaceComponentResult.getAuthRequestContext;
            Segment segment = this.PlaceComponentResult.BuiltInFictitiousFunctionClassFactory;
            Segment segment2 = this.PlaceComponentResult.BuiltInFictitiousFunctionClassFactory;
            long j3 = 0;
            if (this.lookAheadTest != null) {
                long j4 = this.getAuthRequestContext - (this.NetworkUserEntityData$$ExternalSyntheticLambda0 - r4.PlaceComponentResult);
                if (j4 > j) {
                    segment2 = this.lookAheadTest;
                    j2 = j4;
                } else {
                    segment = this.lookAheadTest;
                    j3 = j4;
                }
            }
            if (j2 - j > j - j3) {
                while (j >= (segment.MyBillsEntityDataFactory - segment.PlaceComponentResult) + j3) {
                    j3 += segment.MyBillsEntityDataFactory - segment.PlaceComponentResult;
                    segment = segment.getAuthRequestContext;
                }
            } else {
                while (j2 > j) {
                    segment2 = segment2.lookAheadTest;
                    j2 -= segment2.MyBillsEntityDataFactory - segment2.PlaceComponentResult;
                }
                j3 = j2;
                segment = segment2;
            }
            if (this.BuiltInFictitiousFunctionClassFactory && segment.moveToNextValue) {
                Segment KClassImpl$Data$declaredNonStaticMembers$2 = segment.KClassImpl$Data$declaredNonStaticMembers$2();
                if (this.PlaceComponentResult.BuiltInFictitiousFunctionClassFactory == segment) {
                    this.PlaceComponentResult.BuiltInFictitiousFunctionClassFactory = KClassImpl$Data$declaredNonStaticMembers$2;
                }
                KClassImpl$Data$declaredNonStaticMembers$2.lookAheadTest = segment;
                KClassImpl$Data$declaredNonStaticMembers$2.getAuthRequestContext = segment.getAuthRequestContext;
                segment.getAuthRequestContext.lookAheadTest = KClassImpl$Data$declaredNonStaticMembers$2;
                segment.getAuthRequestContext = KClassImpl$Data$declaredNonStaticMembers$2;
                KClassImpl$Data$declaredNonStaticMembers$2.lookAheadTest.MyBillsEntityDataFactory();
                segment = KClassImpl$Data$declaredNonStaticMembers$2;
            }
            this.lookAheadTest = segment;
            this.getAuthRequestContext = j;
            this.KClassImpl$Data$declaredNonStaticMembers$2 = segment.BuiltInFictitiousFunctionClassFactory;
            this.NetworkUserEntityData$$ExternalSyntheticLambda0 = segment.PlaceComponentResult + ((int) (j - j3));
            int i = segment.MyBillsEntityDataFactory;
            this.MyBillsEntityDataFactory = i;
            return i - this.NetworkUserEntityData$$ExternalSyntheticLambda0;
        }

        @Override // java.io.Closeable, java.lang.AutoCloseable
        public final void close() {
            if (this.PlaceComponentResult == null) {
                throw new IllegalStateException("not attached to a buffer");
            }
            this.PlaceComponentResult = null;
            this.lookAheadTest = null;
            this.getAuthRequestContext = -1L;
            this.KClassImpl$Data$declaredNonStaticMembers$2 = null;
            this.NetworkUserEntityData$$ExternalSyntheticLambda0 = -1;
            this.MyBillsEntityDataFactory = -1;
        }
    }

    public final String toString() {
        Object segmentedByteString;
        long j = this.getAuthRequestContext;
        if (j <= 2147483647L) {
            int i = (int) j;
            if (i == 0) {
                segmentedByteString = ByteString.EMPTY;
            } else {
                segmentedByteString = new SegmentedByteString(this, i);
            }
            return segmentedByteString.toString();
        }
        StringBuilder sb = new StringBuilder();
        sb.append("size > Integer.MAX_VALUE: ");
        sb.append(this.getAuthRequestContext);
        throw new IllegalArgumentException(sb.toString());
    }

    @Override // okio.BufferedSink
    public final /* synthetic */ BufferedSink getAuthRequestContext(ByteString byteString) throws IOException {
        if (byteString == null) {
            throw new IllegalArgumentException("byteString == null");
        }
        byteString.write(this);
        return this;
    }

    @Override // okio.BufferedSink
    public final /* synthetic */ BufferedSink MyBillsEntityDataFactory(byte[] bArr) throws IOException {
        if (bArr == null) {
            throw new IllegalArgumentException("source == null");
        }
        return MyBillsEntityDataFactory(bArr, 0, bArr.length);
    }

    @Override // okio.BufferedSink
    public final /* synthetic */ BufferedSink scheduleImpl(int i) throws IOException {
        return BuiltInFictitiousFunctionClassFactory(Util.MyBillsEntityDataFactory(i));
    }

    @Override // okio.BufferedSink
    public final /* synthetic */ BufferedSink BuiltInFictitiousFunctionClassFactory(String str) throws IOException {
        return PlaceComponentResult(str, 0, str.length());
    }
}
