package com.mixpanel.android.java_websocket.util;

import com.alibaba.ariver.resource.parser.tar.TarHeader;
import com.google.common.base.Ascii;
import java.io.FilterInputStream;
import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectStreamClass;
import java.io.UnsupportedEncodingException;

/* loaded from: classes3.dex */
public class Base64 {
    private static final byte[] MyBillsEntityDataFactory = {65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122, TarHeader.LF_NORMAL, TarHeader.LF_LINK, TarHeader.LF_SYMLINK, TarHeader.LF_CHR, TarHeader.LF_BLK, TarHeader.LF_DIR, TarHeader.LF_FIFO, TarHeader.LF_CONTIG, 56, 57, 43, 47};
    private static final byte[] PlaceComponentResult = {-9, -9, -9, -9, -9, -9, -9, -9, -9, -5, -5, -9, -9, -5, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -5, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, 62, -9, -9, -9, 63, TarHeader.LF_BLK, TarHeader.LF_DIR, TarHeader.LF_FIFO, TarHeader.LF_CONTIG, 56, 57, 58, 59, 60, 61, -9, -9, -9, -1, -9, -9, -9, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, Ascii.DC4, Ascii.NAK, 22, Ascii.ETB, Ascii.CAN, Ascii.EM, -9, -9, -9, -9, -9, -9, Ascii.SUB, Ascii.ESC, Ascii.FS, Ascii.GS, Ascii.RS, Ascii.US, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, TarHeader.LF_NORMAL, TarHeader.LF_LINK, TarHeader.LF_SYMLINK, TarHeader.LF_CHR, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9};
    private static final byte[] KClassImpl$Data$declaredNonStaticMembers$2 = {65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122, TarHeader.LF_NORMAL, TarHeader.LF_LINK, TarHeader.LF_SYMLINK, TarHeader.LF_CHR, TarHeader.LF_BLK, TarHeader.LF_DIR, TarHeader.LF_FIFO, TarHeader.LF_CONTIG, 56, 57, 45, 95};
    private static final byte[] NetworkUserEntityData$$ExternalSyntheticLambda0 = {-9, -9, -9, -9, -9, -9, -9, -9, -9, -5, -5, -9, -9, -5, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -5, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, 62, -9, -9, TarHeader.LF_BLK, TarHeader.LF_DIR, TarHeader.LF_FIFO, TarHeader.LF_CONTIG, 56, 57, 58, 59, 60, 61, -9, -9, -9, -1, -9, -9, -9, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, Ascii.DC4, Ascii.NAK, 22, Ascii.ETB, Ascii.CAN, Ascii.EM, -9, -9, -9, -9, 63, -9, Ascii.SUB, Ascii.ESC, Ascii.FS, Ascii.GS, Ascii.RS, Ascii.US, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, TarHeader.LF_NORMAL, TarHeader.LF_LINK, TarHeader.LF_SYMLINK, TarHeader.LF_CHR, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9};
    private static final byte[] getAuthRequestContext = {45, TarHeader.LF_NORMAL, TarHeader.LF_LINK, TarHeader.LF_SYMLINK, TarHeader.LF_CHR, TarHeader.LF_BLK, TarHeader.LF_DIR, TarHeader.LF_FIFO, TarHeader.LF_CONTIG, 56, 57, 65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 95, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122};
    private static final byte[] BuiltInFictitiousFunctionClassFactory = {-9, -9, -9, -9, -9, -9, -9, -9, -9, -5, -5, -9, -9, -5, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -5, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, 0, -9, -9, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, -9, -9, -9, -1, -9, -9, -9, 11, 12, 13, 14, 15, 16, 17, 18, 19, Ascii.DC4, Ascii.NAK, 22, Ascii.ETB, Ascii.CAN, Ascii.EM, Ascii.SUB, Ascii.ESC, Ascii.FS, Ascii.GS, Ascii.RS, Ascii.US, 32, 33, 34, 35, 36, -9, -9, -9, -9, 37, -9, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, TarHeader.LF_NORMAL, TarHeader.LF_LINK, TarHeader.LF_SYMLINK, TarHeader.LF_CHR, TarHeader.LF_BLK, TarHeader.LF_DIR, TarHeader.LF_FIFO, TarHeader.LF_CONTIG, 56, 57, 58, 59, 60, 61, 62, 63, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9};

    private static final byte[] MyBillsEntityDataFactory(int i) {
        if ((i & 16) == 16) {
            return KClassImpl$Data$declaredNonStaticMembers$2;
        }
        if ((i & 32) == 32) {
            return getAuthRequestContext;
        }
        return MyBillsEntityDataFactory;
    }

    private static final byte[] KClassImpl$Data$declaredNonStaticMembers$2(int i) {
        if ((i & 16) == 16) {
            return NetworkUserEntityData$$ExternalSyntheticLambda0;
        }
        if ((i & 32) == 32) {
            return BuiltInFictitiousFunctionClassFactory;
        }
        return PlaceComponentResult;
    }

    private Base64() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static byte[] getAuthRequestContext(byte[] bArr, byte[] bArr2, int i, int i2) {
        KClassImpl$Data$declaredNonStaticMembers$2(bArr2, 0, i, bArr, 0, i2);
        return bArr;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static byte[] KClassImpl$Data$declaredNonStaticMembers$2(byte[] bArr, int i, int i2, byte[] bArr2, int i3, int i4) {
        byte[] MyBillsEntityDataFactory2 = MyBillsEntityDataFactory(i4);
        int i5 = (i2 > 0 ? (bArr[i] << Ascii.CAN) >>> 8 : 0) | (i2 > 1 ? (bArr[i + 1] << Ascii.CAN) >>> 16 : 0) | (i2 > 2 ? (bArr[i + 2] << Ascii.CAN) >>> 24 : 0);
        if (i2 == 1) {
            bArr2[i3] = MyBillsEntityDataFactory2[i5 >>> 18];
            bArr2[i3 + 1] = MyBillsEntityDataFactory2[(i5 >>> 12) & 63];
            bArr2[i3 + 2] = 61;
            bArr2[i3 + 3] = 61;
            return bArr2;
        } else if (i2 == 2) {
            bArr2[i3] = MyBillsEntityDataFactory2[i5 >>> 18];
            bArr2[i3 + 1] = MyBillsEntityDataFactory2[(i5 >>> 12) & 63];
            bArr2[i3 + 2] = MyBillsEntityDataFactory2[(i5 >>> 6) & 63];
            bArr2[i3 + 3] = 61;
            return bArr2;
        } else if (i2 != 3) {
            return bArr2;
        } else {
            bArr2[i3] = MyBillsEntityDataFactory2[i5 >>> 18];
            bArr2[i3 + 1] = MyBillsEntityDataFactory2[(i5 >>> 12) & 63];
            bArr2[i3 + 2] = MyBillsEntityDataFactory2[(i5 >>> 6) & 63];
            bArr2[i3 + 3] = MyBillsEntityDataFactory2[i5 & 63];
            return bArr2;
        }
    }

    public static String KClassImpl$Data$declaredNonStaticMembers$2(byte[] bArr) {
        try {
            return getAuthRequestContext(bArr, bArr.length);
        } catch (IOException unused) {
            return null;
        }
    }

    private static String getAuthRequestContext(byte[] bArr, int i) throws IOException {
        byte[] BuiltInFictitiousFunctionClassFactory2 = BuiltInFictitiousFunctionClassFactory(bArr, i);
        try {
            return new String(BuiltInFictitiousFunctionClassFactory2, "US-ASCII");
        } catch (UnsupportedEncodingException unused) {
            return new String(BuiltInFictitiousFunctionClassFactory2);
        }
    }

    private static byte[] BuiltInFictitiousFunctionClassFactory(byte[] bArr, int i) throws IOException {
        if (bArr != null) {
            if (i < 0) {
                StringBuilder sb = new StringBuilder();
                sb.append("Cannot have length offset: ");
                sb.append(i);
                throw new IllegalArgumentException(sb.toString());
            } else if (i + 0 <= bArr.length) {
                int i2 = ((i / 3) * 4) + (i % 3 > 0 ? 4 : 0);
                byte[] bArr2 = new byte[i2];
                int i3 = 0;
                int i4 = 0;
                while (i3 < i - 2) {
                    KClassImpl$Data$declaredNonStaticMembers$2(bArr, i3 + 0, 3, bArr2, i4, 0);
                    i3 += 3;
                    i4 += 4;
                }
                if (i3 < i) {
                    KClassImpl$Data$declaredNonStaticMembers$2(bArr, i3 + 0, i - i3, bArr2, i4, 0);
                    i4 += 4;
                }
                if (i4 <= i2 - 1) {
                    byte[] bArr3 = new byte[i4];
                    System.arraycopy(bArr2, 0, bArr3, 0, i4);
                    return bArr3;
                }
                return bArr2;
            } else {
                throw new IllegalArgumentException(String.format("Cannot have offset of %d and length of %d with array of length %d", 0, Integer.valueOf(i), Integer.valueOf(bArr.length)));
            }
        }
        throw new NullPointerException("Cannot serialize a null array.");
    }

    /* renamed from: com.mixpanel.android.java_websocket.util.Base64$1  reason: invalid class name */
    /* loaded from: classes3.dex */
    class AnonymousClass1 extends ObjectInputStream {
        final /* synthetic */ ClassLoader PlaceComponentResult;

        @Override // java.io.ObjectInputStream
        public Class<?> resolveClass(ObjectStreamClass objectStreamClass) throws IOException, ClassNotFoundException {
            Class<?> cls = Class.forName(objectStreamClass.getName(), false, this.PlaceComponentResult);
            return cls == null ? super.resolveClass(objectStreamClass) : cls;
        }
    }

    /* loaded from: classes8.dex */
    public static class InputStream extends FilterInputStream {
        private int BuiltInFictitiousFunctionClassFactory;
        private byte[] KClassImpl$Data$declaredNonStaticMembers$2;
        private boolean MyBillsEntityDataFactory;
        private boolean PlaceComponentResult;
        private byte[] getAuthRequestContext;
        private int getErrorConfigVersion;
        private int lookAheadTest;
        private int moveToNextValue;
        private int scheduleImpl;

        @Override // java.io.FilterInputStream, java.io.InputStream
        public int read() throws IOException {
            int read;
            if (this.scheduleImpl < 0) {
                if (this.MyBillsEntityDataFactory) {
                    byte[] bArr = new byte[3];
                    int i = 0;
                    for (int i2 = 0; i2 < 3; i2++) {
                        int read2 = this.in.read();
                        if (read2 < 0) {
                            break;
                        }
                        bArr[i2] = (byte) read2;
                        i++;
                    }
                    if (i <= 0) {
                        return -1;
                    }
                    Base64.KClassImpl$Data$declaredNonStaticMembers$2(bArr, 0, i, this.KClassImpl$Data$declaredNonStaticMembers$2, 0, this.moveToNextValue);
                    this.scheduleImpl = 0;
                    this.lookAheadTest = 4;
                } else {
                    byte[] bArr2 = new byte[4];
                    int i3 = 0;
                    while (i3 < 4) {
                        do {
                            read = this.in.read();
                            if (read < 0) {
                                break;
                            }
                        } while (this.getAuthRequestContext[read & 127] <= -5);
                        if (read < 0) {
                            break;
                        }
                        bArr2[i3] = (byte) read;
                        i3++;
                    }
                    if (i3 != 4) {
                        if (i3 == 0) {
                            return -1;
                        }
                        throw new IOException("Improperly padded Base64 input.");
                    }
                    this.lookAheadTest = Base64.getAuthRequestContext(bArr2, this.KClassImpl$Data$declaredNonStaticMembers$2, this.moveToNextValue);
                    this.scheduleImpl = 0;
                }
            }
            int i4 = this.scheduleImpl;
            if (i4 >= 0) {
                if (i4 >= this.lookAheadTest) {
                    return -1;
                }
                if (this.MyBillsEntityDataFactory && this.PlaceComponentResult && this.getErrorConfigVersion >= 76) {
                    this.getErrorConfigVersion = 0;
                    return 10;
                }
                this.getErrorConfigVersion++;
                byte[] bArr3 = this.KClassImpl$Data$declaredNonStaticMembers$2;
                int i5 = i4 + 1;
                this.scheduleImpl = i5;
                byte b = bArr3[i4];
                if (i5 >= this.BuiltInFictitiousFunctionClassFactory) {
                    this.scheduleImpl = -1;
                }
                return b & 255;
            }
            throw new IOException("Error in Base64 code reading stream.");
        }

        @Override // java.io.FilterInputStream, java.io.InputStream
        public int read(byte[] bArr, int i, int i2) throws IOException {
            int i3 = 0;
            while (true) {
                if (i3 >= i2) {
                    break;
                }
                int read = read();
                if (read >= 0) {
                    bArr[i + i3] = (byte) read;
                    i3++;
                } else if (i3 == 0) {
                    return -1;
                }
            }
            return i3;
        }
    }

    /* loaded from: classes8.dex */
    public static class OutputStream extends FilterOutputStream {
        private byte[] BuiltInFictitiousFunctionClassFactory;
        private boolean KClassImpl$Data$declaredNonStaticMembers$2;
        private byte[] MyBillsEntityDataFactory;
        private int NetworkUserEntityData$$ExternalSyntheticLambda0;
        private int PlaceComponentResult;
        private byte[] getAuthRequestContext;
        private boolean getErrorConfigVersion;
        private int lookAheadTest;
        private boolean moveToNextValue;
        private int scheduleImpl;

        @Override // java.io.FilterOutputStream, java.io.OutputStream
        public void write(int i) throws IOException {
            if (this.getErrorConfigVersion) {
                this.out.write(i);
            } else if (this.moveToNextValue) {
                byte[] bArr = this.BuiltInFictitiousFunctionClassFactory;
                int i2 = this.lookAheadTest;
                int i3 = i2 + 1;
                this.lookAheadTest = i3;
                bArr[i2] = (byte) i;
                if (i3 >= this.PlaceComponentResult) {
                    this.out.write(Base64.getAuthRequestContext(this.MyBillsEntityDataFactory, this.BuiltInFictitiousFunctionClassFactory, this.PlaceComponentResult, this.NetworkUserEntityData$$ExternalSyntheticLambda0));
                    int i4 = this.scheduleImpl + 4;
                    this.scheduleImpl = i4;
                    if (this.KClassImpl$Data$declaredNonStaticMembers$2 && i4 >= 76) {
                        this.out.write(10);
                        this.scheduleImpl = 0;
                    }
                    this.lookAheadTest = 0;
                }
            } else {
                byte b = this.getAuthRequestContext[i & 127];
                if (b <= -5) {
                    if (b != -5) {
                        throw new IOException("Invalid character in Base64 data.");
                    }
                    return;
                }
                byte[] bArr2 = this.BuiltInFictitiousFunctionClassFactory;
                int i5 = this.lookAheadTest;
                int i6 = i5 + 1;
                this.lookAheadTest = i6;
                bArr2[i5] = (byte) i;
                if (i6 >= this.PlaceComponentResult) {
                    this.out.write(this.MyBillsEntityDataFactory, 0, Base64.getAuthRequestContext(bArr2, this.MyBillsEntityDataFactory, this.NetworkUserEntityData$$ExternalSyntheticLambda0));
                    this.lookAheadTest = 0;
                }
            }
        }

        @Override // java.io.FilterOutputStream, java.io.OutputStream
        public void write(byte[] bArr, int i, int i2) throws IOException {
            if (this.getErrorConfigVersion) {
                this.out.write(bArr, i, i2);
                return;
            }
            for (int i3 = 0; i3 < i2; i3++) {
                write(bArr[i + i3]);
            }
        }

        @Override // java.io.FilterOutputStream, java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            if (this.lookAheadTest > 0) {
                if (this.moveToNextValue) {
                    this.out.write(Base64.getAuthRequestContext(this.MyBillsEntityDataFactory, this.BuiltInFictitiousFunctionClassFactory, this.lookAheadTest, this.NetworkUserEntityData$$ExternalSyntheticLambda0));
                    this.lookAheadTest = 0;
                } else {
                    throw new IOException("Base64 input not properly padded.");
                }
            }
            super.close();
            this.BuiltInFictitiousFunctionClassFactory = null;
            this.out = null;
        }
    }

    static /* synthetic */ int getAuthRequestContext(byte[] bArr, byte[] bArr2, int i) {
        if (bArr != null) {
            if (bArr2 == null) {
                throw new NullPointerException("Destination array was null.");
            }
            if (3 >= bArr.length) {
                throw new IllegalArgumentException(String.format("Source array with length %d cannot have offset of %d and still process four bytes.", Integer.valueOf(bArr.length), 0));
            }
            if (2 >= bArr2.length) {
                throw new IllegalArgumentException(String.format("Destination array with length %d cannot have offset of %d and still store three bytes.", Integer.valueOf(bArr2.length), 0));
            }
            byte[] KClassImpl$Data$declaredNonStaticMembers$22 = KClassImpl$Data$declaredNonStaticMembers$2(i);
            byte b = bArr[2];
            if (b == 61) {
                bArr2[0] = (byte) ((((KClassImpl$Data$declaredNonStaticMembers$22[bArr[1]] & 255) << 12) | ((KClassImpl$Data$declaredNonStaticMembers$22[bArr[0]] & 255) << 18)) >>> 16);
                return 1;
            }
            byte b2 = bArr[3];
            if (b2 == 61) {
                int i2 = ((KClassImpl$Data$declaredNonStaticMembers$22[bArr[1]] & 255) << 12) | ((KClassImpl$Data$declaredNonStaticMembers$22[bArr[0]] & 255) << 18) | ((KClassImpl$Data$declaredNonStaticMembers$22[b] & 255) << 6);
                bArr2[0] = (byte) (i2 >>> 16);
                bArr2[1] = (byte) (i2 >>> 8);
                return 2;
            }
            int i3 = ((KClassImpl$Data$declaredNonStaticMembers$22[bArr[1]] & 255) << 12) | ((KClassImpl$Data$declaredNonStaticMembers$22[bArr[0]] & 255) << 18) | ((KClassImpl$Data$declaredNonStaticMembers$22[b] & 255) << 6) | (KClassImpl$Data$declaredNonStaticMembers$22[b2] & 255);
            bArr2[0] = (byte) (i3 >> 16);
            bArr2[1] = (byte) (i3 >> 8);
            bArr2[2] = (byte) i3;
            return 3;
        }
        throw new NullPointerException("Source array was null.");
    }
}
