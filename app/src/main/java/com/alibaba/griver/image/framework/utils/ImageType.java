package com.alibaba.griver.image.framework.utils;

import android.os.Looper;
import android.text.TextUtils;
import com.google.common.base.Ascii;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes6.dex */
public class ImageType implements Format {
    public static final byte HEAD_GIF_0 = 71;
    public static final byte HEAD_HEVC_0 = 72;
    public static final byte HEAD_HEVC_ORI_0 = 0;
    public static final byte HEAD_JPG_0 = -1;
    public static final byte HEAD_WEBP_0 = 82;

    /* renamed from: a  reason: collision with root package name */
    private static final byte[] f6592a = {-119, 80, 78, 71, 13, 10, Ascii.SUB, 10};
    private static final byte[] b = {-1, -40};
    private static final byte[] c = {71, 73, 70, 56};
    private static final byte[] d = {82, 73, 70, 70};
    private static final byte[] e = {72, 69, 86, 67};
    private static final byte[] f = {0, 0, 0, 1};
    private static final byte[] g = {66, 77};
    private static final Map<Integer, String> h;

    public static boolean isJPEG(int i) {
        return i == 0;
    }

    static {
        HashMap hashMap = new HashMap(5);
        h = hashMap;
        hashMap.put(1, ".png");
        hashMap.put(0, ".jpg");
        hashMap.put(2, Format.SUFFIX_GIF);
        hashMap.put(4, Format.SUFFIX_WEBP);
        hashMap.put(5, Format.SUFFIX_HEVC);
        hashMap.put(7, Format.SUFFIX_BMP);
    }

    public static String getSuffixByType(int i) {
        return h.get(Integer.valueOf(i));
    }

    public static int detectImageFileType(File file) {
        return a(6, a(file));
    }

    public static String detectHevcTypeVersion(File file) {
        return a(a(file));
    }

    public static String detectHevcTypeVersion(byte[] bArr) {
        if (bArr == null || bArr.length <= 8) {
            return null;
        }
        byte[] bArr2 = new byte[8];
        System.arraycopy(bArr, 0, bArr2, 0, 8);
        return a(bArr2);
    }

    public static boolean detectHevcAlpha(byte[] bArr) {
        if (bArr == null || bArr.length <= 8) {
            return false;
        }
        byte[] bArr2 = new byte[8];
        System.arraycopy(bArr, 0, bArr2, 0, 8);
        byte b2 = bArr2[0];
        if (b2 == 0 || b2 == 72) {
            byte b3 = bArr2[6];
            return b3 == 17 || b3 == 34;
        }
        return false;
    }

    public static int detectImageFileType(InputStream inputStream) {
        return a(6, a(inputStream));
    }

    public static int detectImageDataType(byte[] bArr) {
        if (bArr == null || bArr.length <= 0) {
            return 6;
        }
        byte[] bArr2 = new byte[8];
        System.arraycopy(bArr, 0, bArr2, 0, 8);
        return a(6, bArr2);
    }

    /* JADX WARN: Code restructure failed: missing block: B:29:0x004b, code lost:
    
        if (a(com.alibaba.griver.image.framework.utils.ImageType.e, r4) == false) goto L30;
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x0053, code lost:
    
        if (a(com.alibaba.griver.image.framework.utils.ImageType.f, r4) != false) goto L36;
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x0060, code lost:
    
        return 5;
     */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0039 A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0043 A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static int a(int r3, byte[] r4) {
        /*
            r0 = 0
            r1 = r4[r0]
            r2 = -119(0xffffffffffffff89, float:NaN)
            if (r1 == r2) goto L1d
            r2 = 66
            if (r1 == r2) goto L56
            r2 = 82
            if (r1 == r2) goto L3b
            r2 = -1
            if (r1 == r2) goto L27
            if (r1 == 0) goto L4d
            r0 = 71
            if (r1 == r0) goto L31
            r0 = 72
            if (r1 == r0) goto L45
            goto L61
        L1d:
            byte[] r1 = com.alibaba.griver.image.framework.utils.ImageType.f6592a
            boolean r1 = a(r1, r4)
            if (r1 == 0) goto L27
            r3 = 1
            goto L61
        L27:
            byte[] r1 = com.alibaba.griver.image.framework.utils.ImageType.b
            boolean r1 = a(r1, r4)
            if (r1 == 0) goto L31
            r3 = 0
            goto L61
        L31:
            byte[] r0 = com.alibaba.griver.image.framework.utils.ImageType.c
            boolean r0 = a(r0, r4)
            if (r0 == 0) goto L3b
            r3 = 2
            goto L61
        L3b:
            byte[] r0 = com.alibaba.griver.image.framework.utils.ImageType.d
            boolean r0 = a(r0, r4)
            if (r0 == 0) goto L45
            r3 = 4
            goto L61
        L45:
            byte[] r0 = com.alibaba.griver.image.framework.utils.ImageType.e
            boolean r0 = a(r0, r4)
            if (r0 != 0) goto L60
        L4d:
            byte[] r0 = com.alibaba.griver.image.framework.utils.ImageType.f
            boolean r0 = a(r0, r4)
            if (r0 == 0) goto L56
            goto L60
        L56:
            byte[] r0 = com.alibaba.griver.image.framework.utils.ImageType.g
            boolean r4 = a(r0, r4)
            if (r4 == 0) goto L61
            r3 = 7
            goto L61
        L60:
            r3 = 5
        L61:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.griver.image.framework.utils.ImageType.a(int, byte[]):int");
    }

    private static String a(byte[] bArr) {
        byte b2 = bArr[0];
        if (b2 != 0) {
            if (b2 == 72) {
                if (a(e, bArr)) {
                    return String.format("%x_%x", Byte.valueOf(bArr[5]), Byte.valueOf(bArr[6]));
                }
            }
            return null;
        }
        if (a(f, bArr)) {
            return String.format("%x_%x", Byte.valueOf(bArr[5]), Byte.valueOf(bArr[6]));
        }
        return null;
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0042  */
    /* JADX WARN: Removed duplicated region for block: B:17:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static boolean b(byte[] r6) {
        /*
            r0 = 0
            r1 = r6[r0]
            java.lang.String r2 = "%x"
            r3 = 5
            r4 = 1
            if (r1 == 0) goto L24
            r5 = 72
            if (r1 != r5) goto L3b
            byte[] r1 = com.alibaba.griver.image.framework.utils.ImageType.e
            boolean r1 = a(r1, r6)
            if (r1 == 0) goto L24
            java.lang.Object[] r1 = new java.lang.Object[r4]
            r6 = r6[r3]
            java.lang.Byte r6 = java.lang.Byte.valueOf(r6)
            r1[r0] = r6
            java.lang.String r6 = java.lang.String.format(r2, r1)
            goto L3c
        L24:
            byte[] r1 = com.alibaba.griver.image.framework.utils.ImageType.f
            boolean r1 = a(r1, r6)
            if (r1 == 0) goto L3b
            java.lang.Object[] r1 = new java.lang.Object[r4]
            r6 = r6[r3]
            java.lang.Byte r6 = java.lang.Byte.valueOf(r6)
            r1[r0] = r6
            java.lang.String r6 = java.lang.String.format(r2, r1)
            goto L3c
        L3b:
            r6 = 0
        L3c:
            boolean r1 = android.text.TextUtils.isEmpty(r6)
            if (r1 != 0) goto L48
            java.lang.String r0 = "a"
            boolean r0 = r0.equalsIgnoreCase(r6)
        L48:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.griver.image.framework.utils.ImageType.b(byte[]):boolean");
    }

    private static boolean a(byte[] bArr, byte[] bArr2) {
        if (bArr2.length < bArr.length) {
            return false;
        }
        boolean z = true;
        for (int i = 1; i < bArr.length && z; i++) {
            z = bArr[i] == bArr2[i];
        }
        return z;
    }

    private static byte[] a(File file) {
        FileInputStream fileInputStream;
        byte[] bArr = new byte[8];
        if (file != null && file.exists() && file.isFile() && file.length() > 0) {
            FileInputStream fileInputStream2 = null;
            try {
                fileInputStream = new FileInputStream(file);
            } catch (Exception unused) {
            } catch (Throwable th) {
                th = th;
            }
            try {
                fileInputStream.read(bArr);
                a((Closeable) fileInputStream);
            } catch (Exception unused2) {
                fileInputStream2 = fileInputStream;
                a((Closeable) fileInputStream2);
                return bArr;
            } catch (Throwable th2) {
                th = th2;
                fileInputStream2 = fileInputStream;
                a((Closeable) fileInputStream2);
                throw th;
            }
        }
        return bArr;
    }

    private static byte[] a(InputStream inputStream) {
        byte[] bArr = new byte[8];
        if (inputStream != null) {
            try {
                inputStream.read(bArr);
            } catch (Exception unused) {
            } catch (Throwable th) {
                a((Closeable) inputStream);
                throw th;
            }
            a((Closeable) inputStream);
        }
        return bArr;
    }

    public static int detectImageFileType(String str) {
        if (TextUtils.isEmpty(str)) {
            return 6;
        }
        return detectImageFileType(new File(str));
    }

    public static boolean isJPEG(File file) {
        return detectImageFileType(file) == 0;
    }

    public static boolean isJPEG(byte[] bArr) {
        return detectImageDataType(bArr) == 0;
    }

    public static boolean isAnimation(InputStream inputStream) {
        byte[] a2 = a(inputStream);
        return a(6, a2) == 2 || b(a2);
    }

    public static boolean isAnimation(File file) {
        byte[] a2 = a(file);
        return a(6, a2) == 2 || b(a2);
    }

    @Deprecated
    public static boolean isGif(File file) {
        return detectImageFileType(file) == 2;
    }

    public static boolean isAnimation(byte[] bArr) {
        if (bArr == null || bArr.length <= 0) {
            return false;
        }
        byte[] bArr2 = new byte[8];
        System.arraycopy(bArr, 0, bArr2, 0, 8);
        return a(6, bArr2) == 2 || b(bArr2);
    }

    public static boolean isInMainThread() {
        return Looper.myLooper() == Looper.getMainLooper();
    }

    private static void a(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (Throwable unused) {
            }
        }
    }
}
