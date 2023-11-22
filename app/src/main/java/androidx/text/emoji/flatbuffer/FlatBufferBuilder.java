package androidx.text.emoji.flatbuffer;

import android.graphics.ImageFormat;
import android.os.SystemClock;
import java.io.IOException;
import java.io.InputStream;
import java.nio.BufferUnderflowException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.charset.Charset;
import java.nio.charset.CharsetEncoder;
import o.E;

/* loaded from: classes6.dex */
public class FlatBufferBuilder {
    private static int $10 = 0;
    private static int $11 = 1;
    static final Charset BuiltInFictitiousFunctionClassFactory;
    private static long NetworkUserEntityData$$ExternalSyntheticLambda1 = 0;
    private static int NetworkUserEntityData$$ExternalSyntheticLambda7 = 1;
    private static int NetworkUserEntityData$$ExternalSyntheticLambda8;
    private static int isLayoutRequested;
    private static char newProxyInstance;
    int DatabaseTableConfigUtil;
    int GetContactSyncConfig;
    CharsetEncoder KClassImpl$Data$declaredNonStaticMembers$2;
    ByteBuffer MyBillsEntityDataFactory;
    boolean NetworkUserEntityData$$ExternalSyntheticLambda0;
    int[] NetworkUserEntityData$$ExternalSyntheticLambda2;
    boolean PlaceComponentResult;
    ByteBufferFactory getAuthRequestContext;
    boolean getErrorConfigVersion;
    int[] initRecordTimeStamp;
    int lookAheadTest;
    int moveToNextValue;
    int scheduleImpl;

    /* loaded from: classes6.dex */
    public interface ByteBufferFactory {
        ByteBuffer getAuthRequestContext(int i);
    }

    static void KClassImpl$Data$declaredNonStaticMembers$2() {
        newProxyInstance = (char) 42026;
        NetworkUserEntityData$$ExternalSyntheticLambda1 = 4360990799332652212L;
        NetworkUserEntityData$$ExternalSyntheticLambda8 = -956812108;
    }

    static {
        KClassImpl$Data$declaredNonStaticMembers$2();
        Object[] objArr = new Object[1];
        a(new char[]{4568, 42145, 15464, 1176, 2007}, new char[]{22270, 4841, 29830, 47423}, (char) (ImageFormat.getBitsPerPixel(0) + 16245), new char[]{0, 0, 0, 0}, (SystemClock.elapsedRealtime() > 0L ? 1 : (SystemClock.elapsedRealtime() == 0L ? 0 : -1)) - 2045580971, objArr);
        BuiltInFictitiousFunctionClassFactory = Charset.forName(((String) objArr[0]).intern());
        int i = isLayoutRequested + 23;
        NetworkUserEntityData$$ExternalSyntheticLambda7 = i % 128;
        int i2 = i % 2;
    }

    private FlatBufferBuilder(ByteBufferFactory byteBufferFactory) {
        this.moveToNextValue = 1;
        this.initRecordTimeStamp = null;
        this.GetContactSyncConfig = 0;
        this.NetworkUserEntityData$$ExternalSyntheticLambda0 = false;
        this.PlaceComponentResult = false;
        this.NetworkUserEntityData$$ExternalSyntheticLambda2 = new int[16];
        this.scheduleImpl = 0;
        this.DatabaseTableConfigUtil = 0;
        this.getErrorConfigVersion = false;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = BuiltInFictitiousFunctionClassFactory.newEncoder();
        this.lookAheadTest = 1024;
        this.getAuthRequestContext = byteBufferFactory;
        this.MyBillsEntityDataFactory = byteBufferFactory.getAuthRequestContext(1024);
    }

    private FlatBufferBuilder(byte b) {
        this(new HeapByteBufferFactory());
    }

    public FlatBufferBuilder() {
        this((byte) 0);
    }

    /* loaded from: classes6.dex */
    public static final class HeapByteBufferFactory implements ByteBufferFactory {
        @Override // androidx.text.emoji.flatbuffer.FlatBufferBuilder.ByteBufferFactory
        public final ByteBuffer getAuthRequestContext(int i) {
            return ByteBuffer.allocate(1024).order(ByteOrder.LITTLE_ENDIAN);
        }
    }

    /* loaded from: classes6.dex */
    static class ByteBufferBackedInputStream extends InputStream {
        ByteBuffer MyBillsEntityDataFactory;

        @Override // java.io.InputStream
        public int read() throws IOException {
            try {
                return this.MyBillsEntityDataFactory.get() & 255;
            } catch (BufferUnderflowException unused) {
                return -1;
            }
        }
    }

    private static void a(char[] cArr, char[] cArr2, char c, char[] cArr3, int i, Object[] objArr) {
        E e = new E();
        int length = cArr2.length;
        char[] cArr4 = new char[length];
        int length2 = cArr3.length;
        char[] cArr5 = new char[length2];
        System.arraycopy(cArr2, 0, cArr4, 0, length);
        System.arraycopy(cArr3, 0, cArr5, 0, length2);
        cArr4[0] = (char) (cArr4[0] ^ c);
        cArr5[2] = (char) (cArr5[2] + ((char) i));
        int length3 = cArr.length;
        char[] cArr6 = new char[length3];
        e.KClassImpl$Data$declaredNonStaticMembers$2 = 0;
        while (true) {
            if (!(e.KClassImpl$Data$declaredNonStaticMembers$2 < length3)) {
                break;
            }
            int i2 = $10 + 59;
            $11 = i2 % 128;
            int i3 = i2 % 2;
            int i4 = (e.KClassImpl$Data$declaredNonStaticMembers$2 + 2) % 4;
            int i5 = (e.KClassImpl$Data$declaredNonStaticMembers$2 + 3) % 4;
            e.MyBillsEntityDataFactory = (char) (((cArr4[e.KClassImpl$Data$declaredNonStaticMembers$2 % 4] * 32718) + cArr5[i4]) % 65535);
            cArr5[i5] = (char) (((cArr4[i5] * 32718) + cArr5[i4]) / 65535);
            cArr4[i5] = e.MyBillsEntityDataFactory;
            cArr6[e.KClassImpl$Data$declaredNonStaticMembers$2] = (char) ((((cArr4[i5] ^ cArr[e.KClassImpl$Data$declaredNonStaticMembers$2]) ^ (NetworkUserEntityData$$ExternalSyntheticLambda1 ^ 4360990799332652212L)) ^ ((int) (NetworkUserEntityData$$ExternalSyntheticLambda8 ^ 4360990799332652212L))) ^ ((char) (newProxyInstance ^ 4360990799332652212L)));
            e.KClassImpl$Data$declaredNonStaticMembers$2++;
        }
        String str = new String(cArr6);
        int i6 = $10 + 15;
        $11 = i6 % 128;
        if ((i6 % 2 == 0 ? (char) 25 : '\t') == '\t') {
            objArr[0] = str;
            return;
        }
        Object[] objArr2 = null;
        int length4 = objArr2.length;
        objArr[0] = str;
    }
}
