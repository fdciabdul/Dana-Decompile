package com.alipay.android.phone.mobilesdk.socketcraft.util;

import com.alibaba.ariver.resource.parser.tar.TarHeader;
import com.alipay.android.phone.mobilesdk.socketcraft.platform.logcat.SCLogCatUtil;
import com.google.common.base.Ascii;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FilterInputStream;
import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.ObjectStreamClass;
import java.io.Serializable;
import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;

/* loaded from: classes6.dex */
public class Base64 {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    public static final int DECODE = 0;
    public static final int DONT_GUNZIP = 4;
    public static final int DO_BREAK_LINES = 8;
    public static final int ENCODE = 1;
    public static final int GZIP = 2;
    public static final int NO_OPTIONS = 0;
    public static final int ORDERED = 32;
    public static final int URL_SAFE = 16;

    /* renamed from: a  reason: collision with root package name */
    private static final byte[] f6916a = {65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122, TarHeader.LF_NORMAL, TarHeader.LF_LINK, TarHeader.LF_SYMLINK, TarHeader.LF_CHR, TarHeader.LF_BLK, TarHeader.LF_DIR, TarHeader.LF_FIFO, TarHeader.LF_CONTIG, 56, 57, 43, 47};
    private static final byte[] b = {-9, -9, -9, -9, -9, -9, -9, -9, -9, -5, -5, -9, -9, -5, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -5, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, 62, -9, -9, -9, 63, TarHeader.LF_BLK, TarHeader.LF_DIR, TarHeader.LF_FIFO, TarHeader.LF_CONTIG, 56, 57, 58, 59, 60, 61, -9, -9, -9, -1, -9, -9, -9, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, Ascii.DC4, Ascii.NAK, 22, Ascii.ETB, Ascii.CAN, Ascii.EM, -9, -9, -9, -9, -9, -9, Ascii.SUB, Ascii.ESC, Ascii.FS, Ascii.GS, Ascii.RS, Ascii.US, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, TarHeader.LF_NORMAL, TarHeader.LF_LINK, TarHeader.LF_SYMLINK, TarHeader.LF_CHR, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9};
    private static final byte[] c = {65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122, TarHeader.LF_NORMAL, TarHeader.LF_LINK, TarHeader.LF_SYMLINK, TarHeader.LF_CHR, TarHeader.LF_BLK, TarHeader.LF_DIR, TarHeader.LF_FIFO, TarHeader.LF_CONTIG, 56, 57, 45, 95};
    private static final byte[] d = {-9, -9, -9, -9, -9, -9, -9, -9, -9, -5, -5, -9, -9, -5, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -5, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, 62, -9, -9, TarHeader.LF_BLK, TarHeader.LF_DIR, TarHeader.LF_FIFO, TarHeader.LF_CONTIG, 56, 57, 58, 59, 60, 61, -9, -9, -9, -1, -9, -9, -9, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, Ascii.DC4, Ascii.NAK, 22, Ascii.ETB, Ascii.CAN, Ascii.EM, -9, -9, -9, -9, 63, -9, Ascii.SUB, Ascii.ESC, Ascii.FS, Ascii.GS, Ascii.RS, Ascii.US, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, TarHeader.LF_NORMAL, TarHeader.LF_LINK, TarHeader.LF_SYMLINK, TarHeader.LF_CHR, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9};
    private static final byte[] e = {45, TarHeader.LF_NORMAL, TarHeader.LF_LINK, TarHeader.LF_SYMLINK, TarHeader.LF_CHR, TarHeader.LF_BLK, TarHeader.LF_DIR, TarHeader.LF_FIFO, TarHeader.LF_CONTIG, 56, 57, 65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 95, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122};
    private static final byte[] f = {-9, -9, -9, -9, -9, -9, -9, -9, -9, -5, -5, -9, -9, -5, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -5, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, 0, -9, -9, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, -9, -9, -9, -1, -9, -9, -9, 11, 12, 13, 14, 15, 16, 17, 18, 19, Ascii.DC4, Ascii.NAK, 22, Ascii.ETB, Ascii.CAN, Ascii.EM, Ascii.SUB, Ascii.ESC, Ascii.FS, Ascii.GS, Ascii.RS, Ascii.US, 32, 33, 34, 35, 36, -9, -9, -9, -9, 37, -9, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, TarHeader.LF_NORMAL, TarHeader.LF_LINK, TarHeader.LF_SYMLINK, TarHeader.LF_CHR, TarHeader.LF_BLK, TarHeader.LF_DIR, TarHeader.LF_FIFO, TarHeader.LF_CONTIG, 56, 57, 58, 59, 60, 61, 62, 63, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9};

    private static final byte[] a(int i) {
        if ((i & 16) == 16) {
            return c;
        }
        if ((i & 32) == 32) {
            return e;
        }
        return f6916a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final byte[] b(int i) {
        if ((i & 16) == 16) {
            return d;
        }
        if ((i & 32) == 32) {
            return f;
        }
        return b;
    }

    private Base64() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static byte[] a(byte[] bArr, byte[] bArr2, int i, int i2) {
        a(bArr2, 0, i, bArr, 0, i2);
        return bArr;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static byte[] a(byte[] bArr, int i, int i2, byte[] bArr2, int i3, int i4) {
        byte[] a2 = a(i4);
        int i5 = (i2 > 0 ? (bArr[i] << Ascii.CAN) >>> 8 : 0) | (i2 > 1 ? (bArr[i + 1] << Ascii.CAN) >>> 16 : 0) | (i2 > 2 ? (bArr[i + 2] << Ascii.CAN) >>> 24 : 0);
        if (i2 == 1) {
            bArr2[i3] = a2[i5 >>> 18];
            bArr2[i3 + 1] = a2[(i5 >>> 12) & 63];
            bArr2[i3 + 2] = 61;
            bArr2[i3 + 3] = 61;
            return bArr2;
        } else if (i2 == 2) {
            bArr2[i3] = a2[i5 >>> 18];
            bArr2[i3 + 1] = a2[(i5 >>> 12) & 63];
            bArr2[i3 + 2] = a2[(i5 >>> 6) & 63];
            bArr2[i3 + 3] = 61;
            return bArr2;
        } else if (i2 != 3) {
            return bArr2;
        } else {
            bArr2[i3] = a2[i5 >>> 18];
            bArr2[i3 + 1] = a2[(i5 >>> 12) & 63];
            bArr2[i3 + 2] = a2[(i5 >>> 6) & 63];
            bArr2[i3 + 3] = a2[i5 & 63];
            return bArr2;
        }
    }

    public static void encode(ByteBuffer byteBuffer, ByteBuffer byteBuffer2) {
        byte[] bArr = new byte[3];
        byte[] bArr2 = new byte[4];
        while (byteBuffer.hasRemaining()) {
            int min = Math.min(3, byteBuffer.remaining());
            byteBuffer.get(bArr, 0, min);
            a(bArr2, bArr, min, 0);
            byteBuffer2.put(bArr2);
        }
    }

    public static void encode(ByteBuffer byteBuffer, CharBuffer charBuffer) {
        byte[] bArr = new byte[3];
        byte[] bArr2 = new byte[4];
        while (byteBuffer.hasRemaining()) {
            int min = Math.min(3, byteBuffer.remaining());
            byteBuffer.get(bArr, 0, min);
            a(bArr2, bArr, min, 0);
            for (int i = 0; i < 4; i++) {
                charBuffer.put((char) (bArr2[i] & 255));
            }
        }
    }

    public static String encodeObject(Serializable serializable) {
        return encodeObject(serializable, 0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v0 */
    /* JADX WARN: Type inference failed for: r1v2, types: [java.io.OutputStream] */
    /* JADX WARN: Type inference failed for: r1v4 */
    /* JADX WARN: Type inference failed for: r1v5, types: [java.io.OutputStream, java.io.ByteArrayOutputStream] */
    public static String encodeObject(Serializable serializable, int i) {
        java.io.OutputStream outputStream;
        ?? r1;
        OutputStream outputStream2;
        java.io.OutputStream outputStream3;
        java.io.OutputStream outputStream4;
        if (serializable == null) {
            throw new NullPointerException("Cannot serialize a null object.");
        }
        ObjectOutputStream objectOutputStream = null;
        try {
            r1 = new ByteArrayOutputStream();
            try {
                outputStream2 = new OutputStream(r1, i | 1);
                try {
                    if ((i & 2) != 0) {
                        outputStream = new GZIPOutputStream(outputStream2);
                        try {
                            objectOutputStream = new ObjectOutputStream(outputStream);
                        } catch (IOException e2) {
                            e = e2;
                            outputStream4 = outputStream;
                            outputStream3 = objectOutputStream;
                            objectOutputStream = r1;
                            try {
                                throw e;
                            } catch (Throwable th) {
                                th = th;
                                ObjectOutputStream objectOutputStream2 = objectOutputStream;
                                objectOutputStream = outputStream3;
                                outputStream = outputStream4;
                                r1 = objectOutputStream2;
                                try {
                                    objectOutputStream.close();
                                } catch (Exception unused) {
                                }
                                try {
                                    outputStream.close();
                                } catch (Exception unused2) {
                                }
                                try {
                                    outputStream2.close();
                                } catch (Exception unused3) {
                                }
                                try {
                                    r1.close();
                                    throw th;
                                } catch (Exception unused4) {
                                    throw th;
                                }
                            }
                        } catch (Throwable th2) {
                            th = th2;
                            objectOutputStream.close();
                            outputStream.close();
                            outputStream2.close();
                            r1.close();
                            throw th;
                        }
                    } else {
                        objectOutputStream = new ObjectOutputStream(outputStream2);
                        outputStream = null;
                    }
                    objectOutputStream.writeObject(serializable);
                    try {
                        objectOutputStream.close();
                    } catch (Exception unused5) {
                    }
                    try {
                        outputStream.close();
                    } catch (Exception unused6) {
                    }
                    try {
                        outputStream2.close();
                    } catch (Exception unused7) {
                    }
                    try {
                        r1.close();
                    } catch (Exception unused8) {
                    }
                    try {
                        return new String(r1.toByteArray(), "US-ASCII");
                    } catch (UnsupportedEncodingException unused9) {
                        return new String(r1.toByteArray());
                    }
                } catch (IOException e3) {
                    e = e3;
                    java.io.OutputStream outputStream5 = objectOutputStream;
                    objectOutputStream = r1;
                    outputStream4 = outputStream5;
                    outputStream3 = outputStream5;
                } catch (Throwable th3) {
                    th = th3;
                    outputStream = objectOutputStream;
                }
            } catch (IOException e4) {
                e = e4;
                outputStream3 = null;
                outputStream2 = null;
                objectOutputStream = r1;
                outputStream4 = null;
            } catch (Throwable th4) {
                th = th4;
                outputStream = null;
                outputStream2 = null;
            }
        } catch (IOException e5) {
            e = e5;
            outputStream3 = null;
            outputStream4 = null;
            outputStream2 = null;
        } catch (Throwable th5) {
            th = th5;
            outputStream = null;
            r1 = 0;
            outputStream2 = null;
        }
    }

    public static String encodeBytes(byte[] bArr) {
        try {
            return encodeBytes(bArr, 0, bArr.length, 0);
        } catch (IOException unused) {
            return null;
        }
    }

    public static String encodeBytes(byte[] bArr, int i) {
        return encodeBytes(bArr, 0, bArr.length, i);
    }

    public static String encodeBytes(byte[] bArr, int i, int i2) {
        try {
            return encodeBytes(bArr, i, i2, 0);
        } catch (IOException unused) {
            return null;
        }
    }

    public static String encodeBytes(byte[] bArr, int i, int i2, int i3) {
        byte[] encodeBytesToBytes = encodeBytesToBytes(bArr, i, i2, i3);
        try {
            return new String(encodeBytesToBytes, "US-ASCII");
        } catch (UnsupportedEncodingException unused) {
            return new String(encodeBytesToBytes);
        }
    }

    public static byte[] encodeBytesToBytes(byte[] bArr) {
        try {
            return encodeBytesToBytes(bArr, 0, bArr.length, 0);
        } catch (IOException unused) {
            return null;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v0, types: [int] */
    /* JADX WARN: Type inference failed for: r2v14 */
    /* JADX WARN: Type inference failed for: r2v16, types: [java.io.OutputStream] */
    /* JADX WARN: Type inference failed for: r2v17, types: [java.io.OutputStream, java.io.ByteArrayOutputStream] */
    public static byte[] encodeBytesToBytes(byte[] bArr, int i, int i2, int i3) {
        OutputStream outputStream;
        GZIPOutputStream gZIPOutputStream;
        if (bArr == null) {
            throw new NullPointerException("Cannot serialize a null array.");
        }
        if (i < 0) {
            StringBuilder sb = new StringBuilder("Cannot have negative offset: ");
            sb.append(i);
            throw new IllegalArgumentException(sb.toString());
        } else if (i2 < 0) {
            StringBuilder sb2 = new StringBuilder("Cannot have length offset: ");
            sb2.append(i2);
            throw new IllegalArgumentException(sb2.toString());
        } else {
            int i4 = i + i2;
            ?? length = bArr.length;
            if (i4 > length) {
                throw new IllegalArgumentException(String.format("Cannot have offset of %d and length of %d with array of length %d", Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(bArr.length)));
            }
            if ((i3 & 2) != 0) {
                OutputStream outputStream2 = null;
                try {
                    try {
                        length = new ByteArrayOutputStream();
                        try {
                            outputStream = new OutputStream(length, i3 | 1);
                            try {
                                gZIPOutputStream = new GZIPOutputStream(outputStream);
                                try {
                                    gZIPOutputStream.write(bArr, i, i2);
                                    gZIPOutputStream.close();
                                    try {
                                        gZIPOutputStream.close();
                                    } catch (Exception unused) {
                                    }
                                    try {
                                        outputStream.close();
                                    } catch (Exception unused2) {
                                    }
                                    try {
                                        length.close();
                                    } catch (Exception unused3) {
                                    }
                                    return length.toByteArray();
                                } catch (IOException e2) {
                                    e = e2;
                                    outputStream2 = outputStream;
                                    throw e;
                                } catch (Throwable th) {
                                    th = th;
                                    outputStream2 = gZIPOutputStream;
                                    try {
                                        outputStream2.close();
                                    } catch (Exception unused4) {
                                    }
                                    try {
                                        outputStream.close();
                                    } catch (Exception unused5) {
                                    }
                                    try {
                                        length.close();
                                        throw th;
                                    } catch (Exception unused6) {
                                        throw th;
                                    }
                                }
                            } catch (IOException e3) {
                                e = e3;
                                gZIPOutputStream = null;
                            }
                        } catch (IOException e4) {
                            e = e4;
                            gZIPOutputStream = null;
                        } catch (Throwable th2) {
                            th = th2;
                            outputStream = null;
                        }
                    } catch (IOException e5) {
                        throw e5;
                    } catch (Throwable th3) {
                        th = th3;
                        length = 0;
                        outputStream = null;
                    }
                } catch (Throwable th4) {
                    th = th4;
                }
            } else {
                boolean z = (i3 & 8) != 0;
                int i5 = ((i2 / 3) * 4) + (i2 % 3 > 0 ? 4 : 0);
                if (z) {
                    i5 += i5 / 76;
                }
                int i6 = i5;
                byte[] bArr2 = new byte[i6];
                int i7 = 0;
                int i8 = 0;
                int i9 = 0;
                while (i7 < i2 - 2) {
                    a(bArr, i7 + i, 3, bArr2, i8, i3);
                    int i10 = i9 + 4;
                    if (!z || i10 < 76) {
                        i9 = i10;
                    } else {
                        bArr2[i8 + 4] = 10;
                        i8++;
                        i9 = 0;
                    }
                    i7 += 3;
                    i8 += 4;
                }
                if (i7 < i2) {
                    a(bArr, i7 + i, i2 - i7, bArr2, i8, i3);
                    i8 += 4;
                }
                int i11 = i8;
                if (i11 <= i6 - 1) {
                    byte[] bArr3 = new byte[i11];
                    System.arraycopy(bArr2, 0, bArr3, 0, i11);
                    return bArr3;
                }
                return bArr2;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int a(byte[] bArr, int i, byte[] bArr2, int i2, int i3) {
        int i4;
        int i5;
        if (bArr != null) {
            if (bArr2 == null) {
                throw new NullPointerException("Destination array was null.");
            }
            if (i < 0 || (i4 = i + 3) >= bArr.length) {
                throw new IllegalArgumentException(String.format("Source array with length %d cannot have offset of %d and still process four bytes.", Integer.valueOf(bArr.length), Integer.valueOf(i)));
            }
            if (i2 < 0 || (i5 = i2 + 2) >= bArr2.length) {
                throw new IllegalArgumentException(String.format("Destination array with length %d cannot have offset of %d and still store three bytes.", Integer.valueOf(bArr2.length), Integer.valueOf(i2)));
            }
            byte[] b2 = b(i3);
            byte b3 = bArr[i + 2];
            if (b3 == 61) {
                bArr2[i2] = (byte) ((((b2[bArr[i + 1]] & 255) << 12) | ((b2[bArr[i]] & 255) << 18)) >>> 16);
                return 1;
            }
            byte b4 = bArr[i4];
            if (b4 == 61) {
                int i6 = ((b2[bArr[i + 1]] & 255) << 12) | ((b2[bArr[i]] & 255) << 18) | ((b2[b3] & 255) << 6);
                bArr2[i2] = (byte) (i6 >>> 16);
                bArr2[i2 + 1] = (byte) (i6 >>> 8);
                return 2;
            }
            int i7 = ((b2[bArr[i + 1]] & 255) << 12) | ((b2[bArr[i]] & 255) << 18) | ((b2[b3] & 255) << 6) | (b2[b4] & 255);
            bArr2[i2] = (byte) (i7 >> 16);
            bArr2[i2 + 1] = (byte) (i7 >> 8);
            bArr2[i5] = (byte) i7;
            return 3;
        }
        throw new NullPointerException("Source array was null.");
    }

    public static byte[] decode(byte[] bArr) {
        return decode(bArr, 0, bArr.length, 0);
    }

    public static byte[] decode(byte[] bArr, int i, int i2, int i3) {
        int i4;
        if (bArr == null) {
            throw new NullPointerException("Cannot decode null source array.");
        }
        if (i < 0 || (i4 = i + i2) > bArr.length) {
            throw new IllegalArgumentException(String.format("Source array with length %d cannot have offset of %d and process %d bytes.", Integer.valueOf(bArr.length), Integer.valueOf(i), Integer.valueOf(i2)));
        }
        if (i2 == 0) {
            return new byte[0];
        }
        if (i2 < 4) {
            StringBuilder sb = new StringBuilder("Base64-encoded string must have at least four characters, but length specified was ");
            sb.append(i2);
            throw new IllegalArgumentException(sb.toString());
        }
        byte[] b2 = b(i3);
        byte[] bArr2 = new byte[(i2 * 3) / 4];
        byte[] bArr3 = new byte[4];
        int i5 = 0;
        int i6 = 0;
        while (i < i4) {
            byte b3 = bArr[i];
            byte b4 = b2[b3 & 255];
            if (b4 < -5) {
                throw new IOException(String.format("Bad Base64 input character decimal %d in array position %d", Integer.valueOf(bArr[i] & 255), Integer.valueOf(i)));
            }
            if (b4 >= -1) {
                int i7 = i6 + 1;
                bArr3[i6] = b3;
                if (i7 > 3) {
                    i5 += a(bArr3, 0, bArr2, i5, i3);
                    if (bArr[i] == 61) {
                        break;
                    }
                    i6 = 0;
                } else {
                    i6 = i7;
                }
            }
            i++;
        }
        byte[] bArr4 = new byte[i5];
        System.arraycopy(bArr2, 0, bArr4, 0, i5);
        return bArr4;
    }

    public static byte[] decode(String str) {
        return decode(str, 0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v1 */
    /* JADX WARN: Type inference failed for: r1v3, types: [java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r1v5 */
    /* JADX WARN: Type inference failed for: r1v7 */
    /* JADX WARN: Type inference failed for: r3v3 */
    /* JADX WARN: Type inference failed for: r3v4, types: [java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r3v5 */
    /* JADX WARN: Type inference failed for: r3v6 */
    /* JADX WARN: Type inference failed for: r3v7, types: [java.io.ByteArrayInputStream, java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r4v1 */
    /* JADX WARN: Type inference failed for: r4v2, types: [java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r4v5 */
    /* JADX WARN: Type inference failed for: r4v6 */
    /* JADX WARN: Type inference failed for: r4v7, types: [java.util.zip.GZIPInputStream, java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r6v11 */
    /* JADX WARN: Type inference failed for: r6v13 */
    /* JADX WARN: Type inference failed for: r6v7 */
    /* JADX WARN: Type inference failed for: r6v9, types: [java.io.InputStream] */
    public static byte[] decode(String str, int i) {
        byte[] bytes;
        ?? r6;
        ?? r1;
        java.io.OutputStream outputStream;
        ByteArrayOutputStream byteArrayOutputStream;
        ?? r4;
        ?? r3;
        java.io.OutputStream outputStream2;
        if (str == null) {
            throw new NullPointerException("Input string was null.");
        }
        try {
            bytes = str.getBytes("US-ASCII");
        } catch (UnsupportedEncodingException unused) {
            bytes = str.getBytes();
        }
        byte[] decode = decode(bytes, 0, bytes.length, i);
        boolean z = (i & 4) != 0;
        if (decode != null && decode.length >= 4 && !z && 35615 == ((decode[0] & 255) | ((decode[1] << 8) & 65280))) {
            byte[] bArr = new byte[2048];
            java.io.OutputStream outputStream3 = null;
            try {
                byteArrayOutputStream = new ByteArrayOutputStream();
                try {
                    r3 = new ByteArrayInputStream(decode);
                    try {
                        r4 = new GZIPInputStream(r3);
                        while (true) {
                            try {
                                int read = r4.read(bArr);
                                if (read < 0) {
                                    break;
                                }
                                byteArrayOutputStream.write(bArr, 0, read);
                            } catch (IOException e2) {
                                e = e2;
                                outputStream3 = r3;
                                outputStream2 = r4;
                                outputStream = outputStream3;
                                outputStream3 = outputStream2;
                                try {
                                    SCLogCatUtil.error("WS_Base64", "Base64 decode error.", e);
                                    try {
                                        byteArrayOutputStream.close();
                                    } catch (Exception unused2) {
                                    }
                                    r4 = outputStream3;
                                    r3 = outputStream;
                                    r4.close();
                                    r3.close();
                                    return decode;
                                } catch (Throwable th) {
                                    th = th;
                                    r6 = outputStream3;
                                    outputStream3 = byteArrayOutputStream;
                                    r1 = outputStream;
                                    try {
                                        outputStream3.close();
                                    } catch (Exception unused3) {
                                    }
                                    try {
                                        r6.close();
                                    } catch (Exception unused4) {
                                    }
                                    try {
                                        r1.close();
                                        throw th;
                                    } catch (Exception unused5) {
                                        throw th;
                                    }
                                }
                            } catch (Throwable th2) {
                                th = th2;
                                outputStream3 = r4;
                                r6 = outputStream3;
                                outputStream3 = byteArrayOutputStream;
                                r1 = r3;
                                outputStream3.close();
                                r6.close();
                                r1.close();
                                throw th;
                            }
                        }
                        decode = byteArrayOutputStream.toByteArray();
                        try {
                            byteArrayOutputStream.close();
                        } catch (Exception unused6) {
                        }
                    } catch (IOException e3) {
                        e = e3;
                        r4 = 0;
                    } catch (Throwable th3) {
                        th = th3;
                    }
                } catch (IOException e4) {
                    e = e4;
                    outputStream2 = null;
                } catch (Throwable th4) {
                    th = th4;
                    r3 = 0;
                }
            } catch (IOException e5) {
                e = e5;
                outputStream = null;
                byteArrayOutputStream = null;
            } catch (Throwable th5) {
                th = th5;
                r6 = 0;
                r1 = 0;
            }
            try {
                r4.close();
            } catch (Exception unused7) {
            }
            try {
                r3.close();
            } catch (Exception unused8) {
            }
        }
        return decode;
    }

    public static Object decodeToObject(String str) {
        return decodeToObject(str, 0, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v0, types: [java.lang.ClassLoader] */
    /* JADX WARN: Type inference failed for: r4v1 */
    /* JADX WARN: Type inference failed for: r4v4, types: [java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r4v5 */
    public static Object decodeToObject(String str, int i, final ClassLoader classLoader) {
        ByteArrayInputStream byteArrayInputStream;
        ObjectInputStream objectInputStream;
        byte[] decode = decode(str, i);
        ByteArrayInputStream byteArrayInputStream2 = null;
        r3 = null;
        r3 = null;
        Object obj = null;
        byteArrayInputStream2 = null;
        try {
            try {
                byteArrayInputStream = new ByteArrayInputStream(decode);
                try {
                    if (classLoader == 0) {
                        objectInputStream = new ObjectInputStream(byteArrayInputStream);
                    } else {
                        objectInputStream = new ObjectInputStream(byteArrayInputStream) { // from class: com.alipay.android.phone.mobilesdk.socketcraft.util.Base64.1
                            @Override // java.io.ObjectInputStream
                            public final Class<?> resolveClass(ObjectStreamClass objectStreamClass) {
                                Class<?> cls = Class.forName(objectStreamClass.getName(), false, classLoader);
                                return cls == null ? super.resolveClass(objectStreamClass) : cls;
                            }
                        };
                    }
                } catch (IOException e2) {
                    e = e2;
                } catch (ClassNotFoundException e3) {
                    e = e3;
                } catch (Throwable th) {
                    th = th;
                }
            } catch (IOException e4) {
                throw e4;
            } catch (ClassNotFoundException e5) {
                throw e5;
            } catch (Throwable th2) {
                th = th2;
                classLoader = 0;
            }
            try {
                obj = objectInputStream.readObject();
                try {
                    byteArrayInputStream.close();
                } catch (Exception unused) {
                }
                try {
                    objectInputStream.close();
                } catch (Exception unused2) {
                }
                return obj;
            } catch (IOException e6) {
                obj = objectInputStream;
                e = e6;
                throw e;
            } catch (ClassNotFoundException e7) {
                obj = objectInputStream;
                e = e7;
                throw e;
            } catch (Throwable th3) {
                obj = objectInputStream;
                th = th3;
                classLoader = obj;
                byteArrayInputStream2 = byteArrayInputStream;
                try {
                    byteArrayInputStream2.close();
                } catch (Exception unused3) {
                }
                try {
                    classLoader.close();
                    throw th;
                } catch (Exception unused4) {
                    throw th;
                }
            }
        } catch (Throwable th4) {
            th = th4;
        }
    }

    public static void encodeToFile(byte[] bArr, String str) {
        OutputStream outputStream;
        if (bArr == null) {
            throw new NullPointerException("Data to encode was null.");
        }
        try {
            try {
                outputStream = new OutputStream(new FileOutputStream(str), 1);
                try {
                    outputStream.write(bArr);
                    try {
                        outputStream.close();
                    } catch (Exception unused) {
                    }
                } catch (IOException e2) {
                } catch (Throwable th) {
                    th = th;
                    try {
                        outputStream.close();
                    } catch (Exception unused2) {
                    }
                    throw th;
                }
            } catch (IOException e3) {
                throw e3;
            }
        } catch (Throwable th2) {
            th = th2;
            outputStream = null;
        }
    }

    public static void decodeToFile(String str, String str2) {
        OutputStream outputStream;
        try {
            try {
                outputStream = new OutputStream(new FileOutputStream(str2), 0);
                try {
                    outputStream.write(str.getBytes("US-ASCII"));
                    try {
                        outputStream.close();
                    } catch (Exception unused) {
                    }
                } catch (IOException e2) {
                } catch (Throwable th) {
                    th = th;
                    try {
                        outputStream.close();
                    } catch (Exception unused2) {
                    }
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
                outputStream = null;
            }
        } catch (IOException e3) {
            throw e3;
        }
    }

    public static byte[] decodeFromFile(String str) {
        InputStream inputStream;
        try {
            try {
                File file = new File(str);
                if (file.length() > 2147483647L) {
                    StringBuilder sb = new StringBuilder("File is too big for this convenience method (");
                    sb.append(file.length());
                    sb.append(" bytes).");
                    throw new IOException(sb.toString());
                }
                byte[] bArr = new byte[(int) file.length()];
                inputStream = new InputStream(new BufferedInputStream(new FileInputStream(file)), 0);
                int i = 0;
                while (true) {
                    try {
                        int read = inputStream.read(bArr, i, 4096);
                        if (read < 0) {
                            break;
                        }
                        i += read;
                    } catch (IOException e2) {
                        throw e2;
                    } catch (Throwable th) {
                        th = th;
                        try {
                            inputStream.close();
                        } catch (Exception unused) {
                        }
                        throw th;
                    }
                }
                byte[] bArr2 = new byte[i];
                System.arraycopy(bArr, 0, bArr2, 0, i);
                try {
                    inputStream.close();
                } catch (Exception unused2) {
                }
                return bArr2;
            } catch (IOException e3) {
                throw e3;
            }
        } catch (Throwable th2) {
            th = th2;
            inputStream = null;
        }
    }

    public static String encodeFromFile(String str) {
        InputStream inputStream;
        try {
            try {
                File file = new File(str);
                double length = file.length();
                Double.isNaN(length);
                byte[] bArr = new byte[Math.max((int) ((length * 1.4d) + 1.0d), 40)];
                inputStream = new InputStream(new BufferedInputStream(new FileInputStream(file)), 1);
                int i = 0;
                while (true) {
                    try {
                        int read = inputStream.read(bArr, i, 4096);
                        if (read < 0) {
                            break;
                        }
                        i += read;
                    } catch (IOException e2) {
                        throw e2;
                    } catch (Throwable th) {
                        th = th;
                        try {
                            inputStream.close();
                        } catch (Exception unused) {
                        }
                        throw th;
                    }
                }
                String str2 = new String(bArr, 0, i, "US-ASCII");
                try {
                    inputStream.close();
                } catch (Exception unused2) {
                }
                return str2;
            } catch (Throwable th2) {
                th = th2;
                inputStream = null;
            }
        } catch (IOException e3) {
            throw e3;
        }
    }

    public static void encodeFileToFile(String str, String str2) {
        BufferedOutputStream bufferedOutputStream;
        String encodeFromFile = encodeFromFile(str);
        try {
            try {
                bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(str2));
                try {
                    bufferedOutputStream.write(encodeFromFile.getBytes("US-ASCII"));
                    try {
                        bufferedOutputStream.close();
                    } catch (Exception unused) {
                    }
                } catch (IOException e2) {
                } catch (Throwable th) {
                    th = th;
                    try {
                        bufferedOutputStream.close();
                    } catch (Exception unused2) {
                    }
                    throw th;
                }
            } catch (IOException e3) {
                throw e3;
            }
        } catch (Throwable th2) {
            th = th2;
            bufferedOutputStream = null;
        }
    }

    public static void decodeFileToFile(String str, String str2) {
        BufferedOutputStream bufferedOutputStream;
        byte[] decodeFromFile = decodeFromFile(str);
        try {
            try {
                bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(str2));
                try {
                    bufferedOutputStream.write(decodeFromFile);
                    try {
                        bufferedOutputStream.close();
                    } catch (Exception unused) {
                    }
                } catch (IOException e2) {
                } catch (Throwable th) {
                    th = th;
                    try {
                        bufferedOutputStream.close();
                    } catch (Exception unused2) {
                    }
                    throw th;
                }
            } catch (IOException e3) {
                throw e3;
            }
        } catch (Throwable th2) {
            th = th2;
            bufferedOutputStream = null;
        }
    }

    /* loaded from: classes6.dex */
    public static class InputStream extends FilterInputStream {

        /* renamed from: a  reason: collision with root package name */
        private boolean f6917a;
        private int b;
        private byte[] c;
        private int d;
        private int e;
        private int f;
        private boolean g;
        private int h;
        private byte[] i;

        public InputStream(java.io.InputStream inputStream) {
            this(inputStream, 0);
        }

        public InputStream(java.io.InputStream inputStream, int i) {
            super(inputStream);
            this.h = i;
            this.g = (i & 8) > 0;
            boolean z = (i & 1) > 0;
            this.f6917a = z;
            int i2 = z ? 4 : 3;
            this.d = i2;
            this.c = new byte[i2];
            this.b = -1;
            this.f = 0;
            this.i = Base64.b(i);
        }

        @Override // java.io.FilterInputStream, java.io.InputStream
        public int read() {
            int read;
            if (this.b < 0) {
                if (this.f6917a) {
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
                    Base64.a(bArr, 0, i, this.c, 0, this.h);
                    this.b = 0;
                    this.e = 4;
                } else {
                    byte[] bArr2 = new byte[4];
                    int i3 = 0;
                    while (i3 < 4) {
                        do {
                            read = this.in.read();
                            if (read < 0) {
                                break;
                            }
                        } while (this.i[read & 127] <= -5);
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
                    this.e = Base64.a(bArr2, 0, this.c, 0, this.h);
                    this.b = 0;
                }
            }
            int i4 = this.b;
            if (i4 >= 0) {
                if (i4 >= this.e) {
                    return -1;
                }
                if (this.f6917a && this.g && this.f >= 76) {
                    this.f = 0;
                    return 10;
                }
                this.f++;
                byte[] bArr3 = this.c;
                int i5 = i4 + 1;
                this.b = i5;
                byte b = bArr3[i4];
                if (i5 >= this.d) {
                    this.b = -1;
                }
                return b & 255;
            }
            throw new IOException("Error in Base64 code reading stream.");
        }

        @Override // java.io.FilterInputStream, java.io.InputStream
        public int read(byte[] bArr, int i, int i2) {
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

    /* loaded from: classes6.dex */
    public static class OutputStream extends FilterOutputStream {

        /* renamed from: a  reason: collision with root package name */
        private boolean f6918a;
        private int b;
        private byte[] c;
        private int d;
        private int e;
        private boolean f;
        private byte[] g;
        private boolean h;
        private int i;
        private byte[] j;

        public OutputStream(java.io.OutputStream outputStream) {
            this(outputStream, 1);
        }

        public OutputStream(java.io.OutputStream outputStream, int i) {
            super(outputStream);
            this.f = (i & 8) != 0;
            boolean z = (i & 1) != 0;
            this.f6918a = z;
            int i2 = z ? 3 : 4;
            this.d = i2;
            this.c = new byte[i2];
            this.b = 0;
            this.e = 0;
            this.h = false;
            this.g = new byte[4];
            this.i = i;
            this.j = Base64.b(i);
        }

        @Override // java.io.FilterOutputStream, java.io.OutputStream
        public void write(int i) {
            if (this.h) {
                this.out.write(i);
            } else if (this.f6918a) {
                byte[] bArr = this.c;
                int i2 = this.b;
                int i3 = i2 + 1;
                this.b = i3;
                bArr[i2] = (byte) i;
                if (i3 >= this.d) {
                    this.out.write(Base64.a(this.g, this.c, this.d, this.i));
                    int i4 = this.e + 4;
                    this.e = i4;
                    if (this.f && i4 >= 76) {
                        this.out.write(10);
                        this.e = 0;
                    }
                    this.b = 0;
                }
            } else {
                byte b = this.j[i & 127];
                if (b <= -5) {
                    if (b != -5) {
                        throw new IOException("Invalid character in Base64 data.");
                    }
                    return;
                }
                byte[] bArr2 = this.c;
                int i5 = this.b;
                int i6 = i5 + 1;
                this.b = i6;
                bArr2[i5] = (byte) i;
                if (i6 >= this.d) {
                    this.out.write(this.g, 0, Base64.a(bArr2, 0, this.g, 0, this.i));
                    this.b = 0;
                }
            }
        }

        @Override // java.io.FilterOutputStream, java.io.OutputStream
        public void write(byte[] bArr, int i, int i2) {
            if (this.h) {
                this.out.write(bArr, i, i2);
                return;
            }
            for (int i3 = 0; i3 < i2; i3++) {
                write(bArr[i + i3]);
            }
        }

        public void flushBase64() {
            if (this.b > 0) {
                if (this.f6918a) {
                    this.out.write(Base64.a(this.g, this.c, this.b, this.i));
                    this.b = 0;
                    return;
                }
                throw new IOException("Base64 input not properly padded.");
            }
        }

        @Override // java.io.FilterOutputStream, java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            flushBase64();
            super.close();
            this.c = null;
            this.out = null;
        }

        public void suspendEncoding() {
            flushBase64();
            this.h = true;
        }

        public void resumeEncoding() {
            this.h = false;
        }
    }
}
