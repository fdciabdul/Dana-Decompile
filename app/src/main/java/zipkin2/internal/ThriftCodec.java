package zipkin2.internal;

import java.io.EOFException;
import java.nio.BufferUnderflowException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import zipkin2.Span;
import zipkin2.internal.WriteBuffer;
import zipkin2.v1.V1Span;
import zipkin2.v1.V1SpanConverter;

/* loaded from: classes6.dex */
public final class ThriftCodec {
    final V1ThriftSpanWriter getAuthRequestContext = new V1ThriftSpanWriter();

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <T> int MyBillsEntityDataFactory(WriteBuffer.Writer<T> writer, List<T> list) {
        int size = list.size();
        int i = 5;
        for (int i2 = 0; i2 < size; i2++) {
            i += writer.PlaceComponentResult(list.get(i2));
        }
        return i;
    }

    public static boolean MyBillsEntityDataFactory(ReadBuffer readBuffer, Collection<Span> collection) {
        if (readBuffer.available() == 0) {
            return false;
        }
        try {
            V1Span authRequestContext = new V1ThriftSpanReader().getAuthRequestContext(readBuffer);
            V1SpanConverter PlaceComponentResult = V1SpanConverter.PlaceComponentResult();
            PlaceComponentResult.MyBillsEntityDataFactory(authRequestContext);
            PlaceComponentResult.BuiltInFictitiousFunctionClassFactory(authRequestContext);
            PlaceComponentResult.PlaceComponentResult(authRequestContext);
            PlaceComponentResult.BuiltInFictitiousFunctionClassFactory(collection);
            return true;
        } catch (Exception e) {
            throw PlaceComponentResult("Span", e);
        }
    }

    @Nullable
    public static Span PlaceComponentResult(ReadBuffer readBuffer) {
        if (readBuffer.available() == 0) {
            return null;
        }
        try {
            V1Span authRequestContext = new V1ThriftSpanReader().getAuthRequestContext(readBuffer);
            ArrayList arrayList = new ArrayList(1);
            V1SpanConverter PlaceComponentResult = V1SpanConverter.PlaceComponentResult();
            PlaceComponentResult.MyBillsEntityDataFactory(authRequestContext);
            PlaceComponentResult.BuiltInFictitiousFunctionClassFactory(authRequestContext);
            PlaceComponentResult.PlaceComponentResult(authRequestContext);
            PlaceComponentResult.BuiltInFictitiousFunctionClassFactory(arrayList);
            return (Span) arrayList.get(0);
        } catch (Exception e) {
            throw PlaceComponentResult("Span", e);
        }
    }

    public static boolean BuiltInFictitiousFunctionClassFactory(ReadBuffer readBuffer, Collection<Span> collection) {
        if (readBuffer.available() == 0) {
            return false;
        }
        try {
            readBuffer.MyBillsEntityDataFactory();
            int authRequestContext = readBuffer.getAuthRequestContext();
            if (authRequestContext == 0) {
                return false;
            }
            V1ThriftSpanReader v1ThriftSpanReader = new V1ThriftSpanReader();
            V1SpanConverter PlaceComponentResult = V1SpanConverter.PlaceComponentResult();
            for (int i = 0; i < authRequestContext; i++) {
                V1Span authRequestContext2 = v1ThriftSpanReader.getAuthRequestContext(readBuffer);
                PlaceComponentResult.MyBillsEntityDataFactory(authRequestContext2);
                PlaceComponentResult.BuiltInFictitiousFunctionClassFactory(authRequestContext2);
                PlaceComponentResult.PlaceComponentResult(authRequestContext2);
                PlaceComponentResult.BuiltInFictitiousFunctionClassFactory(collection);
            }
            return true;
        } catch (Exception e) {
            throw PlaceComponentResult("List<Span>", e);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int KClassImpl$Data$declaredNonStaticMembers$2(ReadBuffer readBuffer) {
        readBuffer.MyBillsEntityDataFactory();
        return readBuffer.getAuthRequestContext();
    }

    public static <T> void BuiltInFictitiousFunctionClassFactory(WriteBuffer.Writer<T> writer, List<T> list, WriteBuffer writeBuffer) {
        int size = list.size();
        byte[] bArr = writeBuffer.PlaceComponentResult;
        int i = writeBuffer.MyBillsEntityDataFactory;
        writeBuffer.MyBillsEntityDataFactory = i + 1;
        bArr[i] = 12;
        KClassImpl$Data$declaredNonStaticMembers$2(writeBuffer, size);
        for (int i2 = 0; i2 < size; i2++) {
            writer.KClassImpl$Data$declaredNonStaticMembers$2(list.get(i2), writeBuffer);
        }
    }

    private static IllegalArgumentException PlaceComponentResult(String str, Exception exc) {
        String message = exc.getMessage() == null ? "Error" : exc.getMessage();
        if (exc instanceof EOFException) {
            message = "EOF";
        }
        if ((exc instanceof IllegalStateException) || (exc instanceof BufferUnderflowException)) {
            message = "Malformed";
        }
        throw new IllegalArgumentException(String.format("%s reading %s from TBinary", message, str), exc);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void BuiltInFictitiousFunctionClassFactory(ReadBuffer readBuffer, byte b) {
        PlaceComponentResult(readBuffer, b, Integer.MAX_VALUE);
    }

    private static void PlaceComponentResult(ReadBuffer readBuffer, byte b, int i) {
        if (i <= 0) {
            throw new IllegalStateException("Maximum skip depth exceeded");
        }
        int i2 = 0;
        switch (b) {
            case 2:
            case 3:
                readBuffer.skip(1L);
                return;
            case 4:
            case 10:
                readBuffer.skip(8L);
                return;
            case 5:
            case 7:
            case 9:
            default:
                return;
            case 6:
                readBuffer.skip(2L);
                return;
            case 8:
                readBuffer.skip(4L);
                return;
            case 11:
                readBuffer.skip(readBuffer.getAuthRequestContext());
                return;
            case 12:
                break;
            case 13:
                byte MyBillsEntityDataFactory = readBuffer.MyBillsEntityDataFactory();
                byte MyBillsEntityDataFactory2 = readBuffer.MyBillsEntityDataFactory();
                int authRequestContext = readBuffer.getAuthRequestContext();
                while (i2 < authRequestContext) {
                    int i3 = i - 1;
                    PlaceComponentResult(readBuffer, MyBillsEntityDataFactory, i3);
                    PlaceComponentResult(readBuffer, MyBillsEntityDataFactory2, i3);
                    i2++;
                }
                return;
            case 14:
            case 15:
                byte MyBillsEntityDataFactory3 = readBuffer.MyBillsEntityDataFactory();
                int authRequestContext2 = readBuffer.getAuthRequestContext();
                while (i2 < authRequestContext2) {
                    PlaceComponentResult(readBuffer, MyBillsEntityDataFactory3, i - 1);
                    i2++;
                }
                return;
        }
        while (true) {
            ThriftField KClassImpl$Data$declaredNonStaticMembers$2 = ThriftField.KClassImpl$Data$declaredNonStaticMembers$2(readBuffer);
            if (KClassImpl$Data$declaredNonStaticMembers$2.PlaceComponentResult == 0) {
                return;
            }
            PlaceComponentResult(readBuffer, KClassImpl$Data$declaredNonStaticMembers$2.PlaceComponentResult, i - 1);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void MyBillsEntityDataFactory(WriteBuffer writeBuffer, String str) {
        KClassImpl$Data$declaredNonStaticMembers$2(writeBuffer, WriteBuffer.BuiltInFictitiousFunctionClassFactory(str));
        writeBuffer.getAuthRequestContext(str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void KClassImpl$Data$declaredNonStaticMembers$2(WriteBuffer writeBuffer, int i) {
        byte[] bArr = writeBuffer.PlaceComponentResult;
        int i2 = writeBuffer.MyBillsEntityDataFactory;
        writeBuffer.MyBillsEntityDataFactory = i2 + 1;
        bArr[i2] = (byte) (((byte) ((i >>> 24) & 255)) & 255);
        byte[] bArr2 = writeBuffer.PlaceComponentResult;
        int i3 = writeBuffer.MyBillsEntityDataFactory;
        writeBuffer.MyBillsEntityDataFactory = i3 + 1;
        bArr2[i3] = (byte) (((byte) ((i >>> 16) & 255)) & 255);
        byte[] bArr3 = writeBuffer.PlaceComponentResult;
        int i4 = writeBuffer.MyBillsEntityDataFactory;
        writeBuffer.MyBillsEntityDataFactory = i4 + 1;
        bArr3[i4] = (byte) (((byte) ((i >>> 8) & 255)) & 255);
        byte[] bArr4 = writeBuffer.PlaceComponentResult;
        int i5 = writeBuffer.MyBillsEntityDataFactory;
        writeBuffer.MyBillsEntityDataFactory = i5 + 1;
        bArr4[i5] = (byte) (((byte) (i & 255)) & 255);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void PlaceComponentResult(WriteBuffer writeBuffer, int i) {
        byte[] bArr = writeBuffer.PlaceComponentResult;
        int i2 = writeBuffer.MyBillsEntityDataFactory;
        writeBuffer.MyBillsEntityDataFactory = i2 + 1;
        bArr[i2] = 12;
        KClassImpl$Data$declaredNonStaticMembers$2(writeBuffer, i);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void PlaceComponentResult(WriteBuffer writeBuffer, long j) {
        byte[] bArr = writeBuffer.PlaceComponentResult;
        int i = writeBuffer.MyBillsEntityDataFactory;
        writeBuffer.MyBillsEntityDataFactory = i + 1;
        bArr[i] = (byte) (((byte) ((j >>> 56) & 255)) & 255);
        byte[] bArr2 = writeBuffer.PlaceComponentResult;
        int i2 = writeBuffer.MyBillsEntityDataFactory;
        writeBuffer.MyBillsEntityDataFactory = i2 + 1;
        bArr2[i2] = (byte) (((byte) ((j >>> 48) & 255)) & 255);
        byte[] bArr3 = writeBuffer.PlaceComponentResult;
        int i3 = writeBuffer.MyBillsEntityDataFactory;
        writeBuffer.MyBillsEntityDataFactory = i3 + 1;
        bArr3[i3] = (byte) (((byte) ((j >>> 40) & 255)) & 255);
        byte[] bArr4 = writeBuffer.PlaceComponentResult;
        int i4 = writeBuffer.MyBillsEntityDataFactory;
        writeBuffer.MyBillsEntityDataFactory = i4 + 1;
        bArr4[i4] = (byte) (((byte) ((j >>> 32) & 255)) & 255);
        byte[] bArr5 = writeBuffer.PlaceComponentResult;
        int i5 = writeBuffer.MyBillsEntityDataFactory;
        writeBuffer.MyBillsEntityDataFactory = i5 + 1;
        bArr5[i5] = (byte) (((byte) ((j >>> 24) & 255)) & 255);
        byte[] bArr6 = writeBuffer.PlaceComponentResult;
        int i6 = writeBuffer.MyBillsEntityDataFactory;
        writeBuffer.MyBillsEntityDataFactory = i6 + 1;
        bArr6[i6] = (byte) (((byte) ((j >>> 16) & 255)) & 255);
        byte[] bArr7 = writeBuffer.PlaceComponentResult;
        int i7 = writeBuffer.MyBillsEntityDataFactory;
        writeBuffer.MyBillsEntityDataFactory = i7 + 1;
        bArr7[i7] = (byte) (((byte) ((j >>> 8) & 255)) & 255);
        byte[] bArr8 = writeBuffer.PlaceComponentResult;
        int i8 = writeBuffer.MyBillsEntityDataFactory;
        writeBuffer.MyBillsEntityDataFactory = i8 + 1;
        bArr8[i8] = (byte) (((byte) (j & 255)) & 255);
    }
}
