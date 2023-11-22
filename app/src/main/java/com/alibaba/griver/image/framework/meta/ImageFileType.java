package com.alibaba.griver.image.framework.meta;

import android.os.Looper;
import android.text.TextUtils;
import com.alibaba.ariver.kernel.common.service.executor.ExecutorType;
import com.alibaba.ariver.kernel.common.utils.RVLogger;
import com.alibaba.griver.base.common.executor.GriverExecutors;
import com.alibaba.griver.image.framework.api.APImageFormat;
import com.google.common.base.Ascii;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Executor;

/* loaded from: classes6.dex */
public class ImageFileType implements APImageFormat {
    public static final byte HEAD_GIF_0 = 71;
    public static final byte HEAD_HEVC_0 = 72;
    public static final byte HEAD_HEVC_ORI_0 = 0;
    public static final byte HEAD_JPG_0 = -1;
    public static final byte HEAD_WEBP_0 = 82;

    /* renamed from: a  reason: collision with root package name */
    private static final byte[] f6583a = {-119, 80, 78, 71, 13, 10, Ascii.SUB, 10};
    private static final byte[] b = {-1, -40};
    private static final byte[] c = {71, 73, 70, 56};
    private static final byte[] d = {82, 73, 70, 70};
    private static final byte[] e = {72, 69, 86, 67};
    private static final byte[] f = {0, 0, 0, 1};
    public static final Map<Integer, String> sTypeSuffix;

    public static boolean isGif(int i) {
        return i == 2;
    }

    public static boolean isJPEG(int i) {
        return i == 0;
    }

    static {
        HashMap hashMap = new HashMap(5);
        sTypeSuffix = hashMap;
        hashMap.put(1, APImageFormat.SUFFIX_PNG);
        hashMap.put(0, APImageFormat.SUFFIX_JPG);
        hashMap.put(2, APImageFormat.SUFFIX_GIF);
        hashMap.put(4, APImageFormat.SUFFIX_WEBP);
        hashMap.put(5, APImageFormat.SUFFIX_HEVC);
    }

    public static int detectImageFileType(File file) {
        return a(6, a(file));
    }

    public static int detectImageDataType(byte[] bArr) {
        if (bArr == null || bArr.length <= 0) {
            return 6;
        }
        byte[] bArr2 = new byte[8];
        System.arraycopy(bArr, 0, bArr2, 0, 8);
        return a(6, bArr2);
    }

    /* JADX WARN: Code restructure failed: missing block: B:27:0x0047, code lost:
    
        if (a(com.alibaba.griver.image.framework.meta.ImageFileType.e, r4) == false) goto L28;
     */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0035 A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:25:0x003f A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static int a(int r3, byte[] r4) {
        /*
            r0 = 0
            r1 = r4[r0]
            r2 = -119(0xffffffffffffff89, float:NaN)
            if (r1 == r2) goto L19
            r2 = 82
            if (r1 == r2) goto L37
            r2 = -1
            if (r1 == r2) goto L23
            if (r1 == 0) goto L49
            r0 = 71
            if (r1 == r0) goto L2d
            r0 = 72
            if (r1 == r0) goto L41
            goto L52
        L19:
            byte[] r1 = com.alibaba.griver.image.framework.meta.ImageFileType.f6583a
            boolean r1 = a(r1, r4)
            if (r1 == 0) goto L23
            r3 = 1
            goto L52
        L23:
            byte[] r1 = com.alibaba.griver.image.framework.meta.ImageFileType.b
            boolean r1 = a(r1, r4)
            if (r1 == 0) goto L2d
            r3 = 0
            goto L52
        L2d:
            byte[] r0 = com.alibaba.griver.image.framework.meta.ImageFileType.c
            boolean r0 = a(r0, r4)
            if (r0 == 0) goto L37
            r3 = 2
            goto L52
        L37:
            byte[] r0 = com.alibaba.griver.image.framework.meta.ImageFileType.d
            boolean r0 = a(r0, r4)
            if (r0 == 0) goto L41
            r3 = 4
            goto L52
        L41:
            byte[] r0 = com.alibaba.griver.image.framework.meta.ImageFileType.e
            boolean r0 = a(r0, r4)
            if (r0 != 0) goto L51
        L49:
            byte[] r0 = com.alibaba.griver.image.framework.meta.ImageFileType.f
            boolean r4 = a(r0, r4)
            if (r4 == 0) goto L52
        L51:
            r3 = 5
        L52:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.griver.image.framework.meta.ImageFileType.a(int, byte[]):int");
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
        final FileInputStream fileInputStream;
        Executor executor;
        Runnable runnable;
        byte[] bArr = new byte[8];
        if (file != null && file.exists() && file.isFile() && file.length() > 0) {
            final FileInputStream fileInputStream2 = null;
            try {
                try {
                    fileInputStream = new FileInputStream(file);
                    try {
                        fileInputStream.read(bArr);
                    } catch (Exception e2) {
                        e = e2;
                        fileInputStream2 = fileInputStream;
                        StringBuilder sb = new StringBuilder();
                        sb.append("read file: ");
                        sb.append(file);
                        sb.append(", error: ");
                        sb.append(e.getMessage());
                        RVLogger.w("ImageFileType", sb.toString());
                        if (isInMainThread()) {
                            executor = GriverExecutors.getExecutor(ExecutorType.URGENT);
                            runnable = new Runnable() { // from class: com.alibaba.griver.image.framework.meta.ImageFileType.1
                                @Override // java.lang.Runnable
                                public final void run() {
                                    ImageFileType.a(fileInputStream2);
                                }
                            };
                            executor.execute(runnable);
                            return bArr;
                        }
                        fileInputStream = fileInputStream2;
                        a(fileInputStream);
                        return bArr;
                    } catch (Throwable th) {
                        th = th;
                        fileInputStream2 = fileInputStream;
                        if (isInMainThread()) {
                            GriverExecutors.getExecutor(ExecutorType.URGENT).execute(new Runnable() { // from class: com.alibaba.griver.image.framework.meta.ImageFileType.1
                                @Override // java.lang.Runnable
                                public final void run() {
                                    ImageFileType.a(fileInputStream2);
                                }
                            });
                        } else {
                            a(fileInputStream2);
                        }
                        throw th;
                    }
                } catch (Throwable th2) {
                    th = th2;
                }
            } catch (Exception e3) {
                e = e3;
            }
            if (isInMainThread()) {
                executor = GriverExecutors.getExecutor(ExecutorType.URGENT);
                runnable = new Runnable() { // from class: com.alibaba.griver.image.framework.meta.ImageFileType.1
                    @Override // java.lang.Runnable
                    public final void run() {
                        ImageFileType.a(fileInputStream);
                    }
                };
                executor.execute(runnable);
            }
            a(fileInputStream);
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

    public static boolean isGif(byte[] bArr) {
        return detectImageDataType(bArr) == 2;
    }

    public static boolean isGif(File file) {
        return detectImageFileType(file) == 2;
    }

    public static boolean isInMainThread() {
        return Looper.myLooper() == Looper.getMainLooper();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void a(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (Throwable th) {
                StringBuilder sb = new StringBuilder();
                sb.append("closeQuietly error, ");
                sb.append(th);
                RVLogger.w("ImageFileType", sb.toString());
            }
        }
    }
}
