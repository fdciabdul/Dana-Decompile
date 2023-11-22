package androidx.emoji2.text.flatbuffer;

import androidx.emoji2.text.flatbuffer.Utf8;
import java.nio.ByteBuffer;

/* loaded from: classes3.dex */
public final class Utf8Safe extends Utf8 {
    public static String MyBillsEntityDataFactory(byte[] bArr, int i, int i2) {
        if ((i | i2 | ((bArr.length - i) - i2)) >= 0) {
            int i3 = i + i2;
            char[] cArr = new char[i2];
            int i4 = 0;
            while (i < i3) {
                byte b = bArr[i];
                if (!Utf8.DecodeUtil.KClassImpl$Data$declaredNonStaticMembers$2(b)) {
                    break;
                }
                i++;
                Utf8.DecodeUtil.PlaceComponentResult(b, cArr, i4);
                i4++;
            }
            int i5 = i4;
            while (i < i3) {
                int i6 = i + 1;
                byte b2 = bArr[i];
                if (Utf8.DecodeUtil.KClassImpl$Data$declaredNonStaticMembers$2(b2)) {
                    Utf8.DecodeUtil.PlaceComponentResult(b2, cArr, i5);
                    i = i6;
                    i5++;
                    while (i < i3) {
                        byte b3 = bArr[i];
                        if (Utf8.DecodeUtil.KClassImpl$Data$declaredNonStaticMembers$2(b3)) {
                            i++;
                            Utf8.DecodeUtil.PlaceComponentResult(b3, cArr, i5);
                            i5++;
                        }
                    }
                } else {
                    if (Utf8.DecodeUtil.getAuthRequestContext(b2)) {
                        if (i6 >= i3) {
                            throw new IllegalArgumentException("Invalid UTF-8");
                        }
                        Utf8.DecodeUtil.BuiltInFictitiousFunctionClassFactory(b2, bArr[i6], cArr, i5);
                        i = i6 + 1;
                    } else if (Utf8.DecodeUtil.MyBillsEntityDataFactory(b2)) {
                        if (i6 >= i3 - 1) {
                            throw new IllegalArgumentException("Invalid UTF-8");
                        }
                        int i7 = i6 + 1;
                        Utf8.DecodeUtil.getAuthRequestContext(b2, bArr[i6], bArr[i7], cArr, i5);
                        i = i7 + 1;
                    } else if (i6 >= i3 - 2) {
                        throw new IllegalArgumentException("Invalid UTF-8");
                    } else {
                        int i8 = i6 + 1;
                        int i9 = i8 + 1;
                        Utf8.DecodeUtil.PlaceComponentResult(b2, bArr[i6], bArr[i8], bArr[i9], cArr, i5);
                        i = i9 + 1;
                        i5 = i5 + 1 + 1;
                    }
                    i5++;
                }
            }
            return new String(cArr, 0, i5);
        }
        throw new ArrayIndexOutOfBoundsException(String.format("buffer length=%d, index=%d, size=%d", Integer.valueOf(bArr.length), Integer.valueOf(i), Integer.valueOf(i2)));
    }

    public static String KClassImpl$Data$declaredNonStaticMembers$2(ByteBuffer byteBuffer, int i, int i2) {
        if ((i | i2 | ((byteBuffer.limit() - i) - i2)) < 0) {
            throw new ArrayIndexOutOfBoundsException(String.format("buffer limit=%d, index=%d, limit=%d", Integer.valueOf(byteBuffer.limit()), Integer.valueOf(i), Integer.valueOf(i2)));
        }
        int i3 = i + i2;
        char[] cArr = new char[i2];
        int i4 = 0;
        while (i < i3) {
            byte b = byteBuffer.get(i);
            if (!Utf8.DecodeUtil.KClassImpl$Data$declaredNonStaticMembers$2(b)) {
                break;
            }
            i++;
            Utf8.DecodeUtil.PlaceComponentResult(b, cArr, i4);
            i4++;
        }
        int i5 = i4;
        while (i < i3) {
            int i6 = i + 1;
            byte b2 = byteBuffer.get(i);
            if (Utf8.DecodeUtil.KClassImpl$Data$declaredNonStaticMembers$2(b2)) {
                Utf8.DecodeUtil.PlaceComponentResult(b2, cArr, i5);
                i = i6;
                i5++;
                while (i < i3) {
                    byte b3 = byteBuffer.get(i);
                    if (Utf8.DecodeUtil.KClassImpl$Data$declaredNonStaticMembers$2(b3)) {
                        i++;
                        Utf8.DecodeUtil.PlaceComponentResult(b3, cArr, i5);
                        i5++;
                    }
                }
            } else {
                if (Utf8.DecodeUtil.getAuthRequestContext(b2)) {
                    if (i6 >= i3) {
                        throw new IllegalArgumentException("Invalid UTF-8");
                    }
                    Utf8.DecodeUtil.BuiltInFictitiousFunctionClassFactory(b2, byteBuffer.get(i6), cArr, i5);
                    i = i6 + 1;
                } else if (Utf8.DecodeUtil.MyBillsEntityDataFactory(b2)) {
                    if (i6 >= i3 - 1) {
                        throw new IllegalArgumentException("Invalid UTF-8");
                    }
                    int i7 = i6 + 1;
                    Utf8.DecodeUtil.getAuthRequestContext(b2, byteBuffer.get(i6), byteBuffer.get(i7), cArr, i5);
                    i = i7 + 1;
                } else if (i6 >= i3 - 2) {
                    throw new IllegalArgumentException("Invalid UTF-8");
                } else {
                    int i8 = i6 + 1;
                    int i9 = i8 + 1;
                    Utf8.DecodeUtil.PlaceComponentResult(b2, byteBuffer.get(i6), byteBuffer.get(i8), byteBuffer.get(i9), cArr, i5);
                    i = i9 + 1;
                    i5 = i5 + 1 + 1;
                }
                i5++;
            }
        }
        return new String(cArr, 0, i5);
    }

    /* loaded from: classes6.dex */
    static class UnpairedSurrogateException extends IllegalArgumentException {
        /* JADX WARN: Illegal instructions before constructor call */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        UnpairedSurrogateException(int r3, int r4) {
            /*
                r2 = this;
                java.lang.StringBuilder r0 = new java.lang.StringBuilder
                r0.<init>()
                java.lang.String r1 = "Unpaired surrogate at index "
                r0.append(r1)
                r0.append(r3)
                java.lang.String r3 = " of "
                r0.append(r3)
                r0.append(r4)
                java.lang.String r3 = r0.toString()
                r2.<init>(r3)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.emoji2.text.flatbuffer.Utf8Safe.UnpairedSurrogateException.<init>(int, int):void");
        }
    }
}
