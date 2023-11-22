package zipkin2.internal;

import com.google.common.base.Ascii;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/* loaded from: classes9.dex */
public abstract class ReadBuffer extends InputStream {
    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract int BuiltInFictitiousFunctionClassFactory();

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract long KClassImpl$Data$declaredNonStaticMembers$2();

    abstract boolean MyBillsEntityDataFactory(char[] cArr, int i);

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract short NetworkUserEntityData$$ExternalSyntheticLambda0();

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract byte PlaceComponentResult();

    abstract String PlaceComponentResult(int i);

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract int getAuthRequestContext();

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract byte[] getAuthRequestContext(int i);

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract long getErrorConfigVersion();

    @Override // java.io.InputStream
    public boolean markSupported() {
        return false;
    }

    public static ReadBuffer MyBillsEntityDataFactory(ByteBuffer byteBuffer) {
        if (byteBuffer.hasArray()) {
            return new Array(byteBuffer.array(), byteBuffer.arrayOffset() + byteBuffer.position(), byteBuffer.remaining());
        } else if (byteBuffer.order() == ByteOrder.BIG_ENDIAN) {
            return new BigEndianByteBuffer(byteBuffer);
        } else {
            return new LittleEndianByteBuffer(byteBuffer);
        }
    }

    public static ReadBuffer KClassImpl$Data$declaredNonStaticMembers$2(byte[] bArr) {
        return new Array(bArr, 0, bArr.length);
    }

    /* loaded from: classes9.dex */
    static final class BigEndianByteBuffer extends Buff {
        BigEndianByteBuffer(ByteBuffer byteBuffer) {
            super(byteBuffer);
        }

        @Override // zipkin2.internal.ReadBuffer
        final short NetworkUserEntityData$$ExternalSyntheticLambda0() {
            KClassImpl$Data$declaredNonStaticMembers$2(2);
            return this.KClassImpl$Data$declaredNonStaticMembers$2.getShort();
        }

        @Override // zipkin2.internal.ReadBuffer
        final int getAuthRequestContext() {
            KClassImpl$Data$declaredNonStaticMembers$2(4);
            return this.KClassImpl$Data$declaredNonStaticMembers$2.getInt();
        }

        @Override // zipkin2.internal.ReadBuffer
        final long KClassImpl$Data$declaredNonStaticMembers$2() {
            KClassImpl$Data$declaredNonStaticMembers$2(8);
            return this.KClassImpl$Data$declaredNonStaticMembers$2.getLong();
        }

        @Override // zipkin2.internal.ReadBuffer
        final long getErrorConfigVersion() {
            KClassImpl$Data$declaredNonStaticMembers$2(8);
            return Long.reverseBytes(this.KClassImpl$Data$declaredNonStaticMembers$2.getLong());
        }
    }

    /* loaded from: classes9.dex */
    static final class LittleEndianByteBuffer extends Buff {
        LittleEndianByteBuffer(ByteBuffer byteBuffer) {
            super(byteBuffer);
        }

        @Override // zipkin2.internal.ReadBuffer
        final short NetworkUserEntityData$$ExternalSyntheticLambda0() {
            KClassImpl$Data$declaredNonStaticMembers$2(2);
            return Short.reverseBytes(this.KClassImpl$Data$declaredNonStaticMembers$2.getShort());
        }

        @Override // zipkin2.internal.ReadBuffer
        final int getAuthRequestContext() {
            KClassImpl$Data$declaredNonStaticMembers$2(4);
            return Integer.reverseBytes(this.KClassImpl$Data$declaredNonStaticMembers$2.getInt());
        }

        @Override // zipkin2.internal.ReadBuffer
        final long getErrorConfigVersion() {
            KClassImpl$Data$declaredNonStaticMembers$2(8);
            return this.KClassImpl$Data$declaredNonStaticMembers$2.getLong();
        }

        @Override // zipkin2.internal.ReadBuffer
        final long KClassImpl$Data$declaredNonStaticMembers$2() {
            KClassImpl$Data$declaredNonStaticMembers$2(8);
            return Long.reverseBytes(this.KClassImpl$Data$declaredNonStaticMembers$2.getLong());
        }
    }

    /* loaded from: classes9.dex */
    static abstract class Buff extends ReadBuffer {
        final ByteBuffer KClassImpl$Data$declaredNonStaticMembers$2;

        Buff(ByteBuffer byteBuffer) {
            this.KClassImpl$Data$declaredNonStaticMembers$2 = byteBuffer;
        }

        @Override // zipkin2.internal.ReadBuffer
        final byte PlaceComponentResult() {
            return this.KClassImpl$Data$declaredNonStaticMembers$2.get();
        }

        @Override // zipkin2.internal.ReadBuffer
        final byte[] getAuthRequestContext(int i) {
            KClassImpl$Data$declaredNonStaticMembers$2(i);
            byte[] bArr = new byte[i];
            this.KClassImpl$Data$declaredNonStaticMembers$2.get(bArr);
            return bArr;
        }

        @Override // zipkin2.internal.ReadBuffer
        final boolean MyBillsEntityDataFactory(char[] cArr, int i) {
            ByteBuffer byteBuffer = (ByteBuffer) this.KClassImpl$Data$declaredNonStaticMembers$2.mark();
            for (int i2 = 0; i2 < i; i2++) {
                byte b = this.KClassImpl$Data$declaredNonStaticMembers$2.get();
                if ((b & 128) != 0) {
                    ByteBuffer byteBuffer2 = (ByteBuffer) this.KClassImpl$Data$declaredNonStaticMembers$2.reset();
                    return false;
                }
                cArr[i2] = (char) b;
            }
            return true;
        }

        @Override // zipkin2.internal.ReadBuffer
        final String PlaceComponentResult(int i) {
            return new String(getAuthRequestContext(i), JsonCodec.PlaceComponentResult);
        }

        @Override // zipkin2.internal.ReadBuffer
        public final int BuiltInFictitiousFunctionClassFactory() {
            return this.KClassImpl$Data$declaredNonStaticMembers$2.position();
        }

        @Override // java.io.InputStream
        public int read(byte[] bArr, int i, int i2) {
            if (available() == 0) {
                return -1;
            }
            int authRequestContext = getAuthRequestContext(bArr, i, i2);
            if (authRequestContext == 0) {
                return 0;
            }
            this.KClassImpl$Data$declaredNonStaticMembers$2.get(bArr, i, authRequestContext);
            return authRequestContext;
        }

        @Override // java.io.InputStream
        public long skip(long j) {
            int max = Math.max(available(), (int) j);
            ByteBuffer byteBuffer = this.KClassImpl$Data$declaredNonStaticMembers$2;
            ByteBuffer byteBuffer2 = (ByteBuffer) byteBuffer.position(byteBuffer.position() + max);
            return max;
        }

        @Override // java.io.InputStream
        public int available() {
            return this.KClassImpl$Data$declaredNonStaticMembers$2.remaining();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes9.dex */
    public static final class Array extends ReadBuffer {
        int BuiltInFictitiousFunctionClassFactory;
        int MyBillsEntityDataFactory;
        int PlaceComponentResult;
        final byte[] getAuthRequestContext;

        Array(byte[] bArr, int i, int i2) {
            this.getAuthRequestContext = bArr;
            this.MyBillsEntityDataFactory = i;
            this.PlaceComponentResult = i;
            this.BuiltInFictitiousFunctionClassFactory = i2;
        }

        @Override // zipkin2.internal.ReadBuffer
        final byte PlaceComponentResult() {
            byte[] bArr = this.getAuthRequestContext;
            int i = this.MyBillsEntityDataFactory;
            this.MyBillsEntityDataFactory = i + 1;
            return bArr[i];
        }

        @Override // zipkin2.internal.ReadBuffer
        final byte[] getAuthRequestContext(int i) {
            KClassImpl$Data$declaredNonStaticMembers$2(i);
            byte[] bArr = new byte[i];
            System.arraycopy(this.getAuthRequestContext, this.MyBillsEntityDataFactory, bArr, 0, i);
            this.MyBillsEntityDataFactory += i;
            return bArr;
        }

        @Override // java.io.InputStream
        public final int read(byte[] bArr, int i, int i2) {
            if (available() == 0) {
                return -1;
            }
            int authRequestContext = getAuthRequestContext(bArr, i, i2);
            if (authRequestContext == 0) {
                return 0;
            }
            System.arraycopy(this.getAuthRequestContext, this.MyBillsEntityDataFactory, bArr, 0, authRequestContext);
            this.MyBillsEntityDataFactory += authRequestContext;
            return authRequestContext;
        }

        @Override // zipkin2.internal.ReadBuffer
        final boolean MyBillsEntityDataFactory(char[] cArr, int i) {
            for (int i2 = 0; i2 < i; i2++) {
                byte b = this.getAuthRequestContext[this.MyBillsEntityDataFactory + i2];
                if ((b & 128) != 0) {
                    return false;
                }
                cArr[i2] = (char) b;
            }
            this.MyBillsEntityDataFactory += i;
            return true;
        }

        @Override // zipkin2.internal.ReadBuffer
        final String PlaceComponentResult(int i) {
            String str = new String(this.getAuthRequestContext, this.MyBillsEntityDataFactory, i, JsonCodec.PlaceComponentResult);
            this.MyBillsEntityDataFactory += i;
            return str;
        }

        @Override // zipkin2.internal.ReadBuffer
        final short NetworkUserEntityData$$ExternalSyntheticLambda0() {
            KClassImpl$Data$declaredNonStaticMembers$2(2);
            byte[] bArr = this.getAuthRequestContext;
            int i = this.MyBillsEntityDataFactory;
            int i2 = i + 1;
            byte b = bArr[i];
            this.MyBillsEntityDataFactory = i2 + 1;
            return (short) ((bArr[i2] & 255) | ((b & 255) << 8));
        }

        @Override // zipkin2.internal.ReadBuffer
        final int getAuthRequestContext() {
            KClassImpl$Data$declaredNonStaticMembers$2(4);
            int i = this.MyBillsEntityDataFactory;
            this.MyBillsEntityDataFactory = i + 4;
            byte[] bArr = this.getAuthRequestContext;
            return (bArr[i + 3] & 255) | ((bArr[i] & 255) << 24) | ((bArr[i + 1] & 255) << 16) | ((bArr[i + 2] & 255) << 8);
        }

        @Override // zipkin2.internal.ReadBuffer
        final long KClassImpl$Data$declaredNonStaticMembers$2() {
            return Long.reverseBytes(getErrorConfigVersion());
        }

        @Override // zipkin2.internal.ReadBuffer
        final long getErrorConfigVersion() {
            KClassImpl$Data$declaredNonStaticMembers$2(8);
            int i = this.MyBillsEntityDataFactory;
            this.MyBillsEntityDataFactory = i + 8;
            byte[] bArr = this.getAuthRequestContext;
            return ((bArr[i + 6] & 255) << 48) | (bArr[i] & 255) | ((bArr[i + 1] & 255) << 8) | ((bArr[i + 2] & 255) << 16) | ((bArr[i + 3] & 255) << 24) | ((bArr[i + 4] & 255) << 32) | ((bArr[i + 5] & 255) << 40) | ((bArr[i + 7] & 255) << 56);
        }

        @Override // zipkin2.internal.ReadBuffer
        public final int BuiltInFictitiousFunctionClassFactory() {
            return this.MyBillsEntityDataFactory - this.PlaceComponentResult;
        }

        @Override // java.io.InputStream
        public final long skip(long j) {
            int min = Math.min(available(), (int) j);
            this.MyBillsEntityDataFactory += min;
            return min;
        }

        @Override // java.io.InputStream
        public final int available() {
            return this.BuiltInFictitiousFunctionClassFactory - (this.MyBillsEntityDataFactory - this.PlaceComponentResult);
        }
    }

    @Override // java.io.InputStream
    public void mark(int i) {
        throw new UnsupportedOperationException();
    }

    @Override // java.io.InputStream
    public void reset() {
        synchronized (this) {
            throw new UnsupportedOperationException();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final byte MyBillsEntityDataFactory() {
        KClassImpl$Data$declaredNonStaticMembers$2(1);
        return PlaceComponentResult();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final String MyBillsEntityDataFactory(int i) {
        if (i == 0) {
            return "";
        }
        KClassImpl$Data$declaredNonStaticMembers$2(i);
        if (i > 256) {
            return PlaceComponentResult(i);
        }
        char[] BuiltInFictitiousFunctionClassFactory = RecyclableBuffers.BuiltInFictitiousFunctionClassFactory();
        if (MyBillsEntityDataFactory(BuiltInFictitiousFunctionClassFactory, i)) {
            return new String(BuiltInFictitiousFunctionClassFactory, 0, i);
        }
        return PlaceComponentResult(i);
    }

    @Override // java.io.InputStream
    public final int read() {
        if (available() > 0) {
            return PlaceComponentResult();
        }
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final int scheduleImpl() {
        int i;
        byte MyBillsEntityDataFactory = MyBillsEntityDataFactory();
        if (MyBillsEntityDataFactory >= 0) {
            return MyBillsEntityDataFactory;
        }
        int i2 = MyBillsEntityDataFactory & Byte.MAX_VALUE;
        byte MyBillsEntityDataFactory2 = MyBillsEntityDataFactory();
        if (MyBillsEntityDataFactory2 >= 0) {
            i = MyBillsEntityDataFactory2 << 7;
        } else {
            i2 |= (MyBillsEntityDataFactory2 & Byte.MAX_VALUE) << 7;
            byte MyBillsEntityDataFactory3 = MyBillsEntityDataFactory();
            if (MyBillsEntityDataFactory3 >= 0) {
                i = MyBillsEntityDataFactory3 << 14;
            } else {
                i2 |= (MyBillsEntityDataFactory3 & Byte.MAX_VALUE) << 14;
                byte MyBillsEntityDataFactory4 = MyBillsEntityDataFactory();
                if (MyBillsEntityDataFactory4 >= 0) {
                    i = MyBillsEntityDataFactory4 << Ascii.NAK;
                } else {
                    i2 |= (MyBillsEntityDataFactory4 & Byte.MAX_VALUE) << 21;
                    byte MyBillsEntityDataFactory5 = MyBillsEntityDataFactory();
                    if ((MyBillsEntityDataFactory5 & 240) != 0) {
                        StringBuilder sb = new StringBuilder();
                        sb.append("Greater than 32-bit varint at position ");
                        sb.append(BuiltInFictitiousFunctionClassFactory() - 1);
                        throw new IllegalArgumentException(sb.toString());
                    }
                    i = MyBillsEntityDataFactory5 << Ascii.FS;
                }
            }
        }
        return i2 | i;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void KClassImpl$Data$declaredNonStaticMembers$2(int i) {
        if (available() >= i) {
            return;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Truncated: length ");
        sb.append(i);
        sb.append(" > bytes available ");
        sb.append(available());
        throw new IllegalArgumentException(sb.toString());
    }

    final int getAuthRequestContext(byte[] bArr, int i, int i2) {
        if (i < 0 || i2 < 0 || i2 > bArr.length - i) {
            throw new IndexOutOfBoundsException();
        }
        return Math.min(available(), i2);
    }
}
