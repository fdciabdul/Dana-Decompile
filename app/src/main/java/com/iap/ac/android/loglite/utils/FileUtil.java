package com.iap.ac.android.loglite.utils;

import android.graphics.ImageFormat;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.channels.FileChannel;
import o.D;

/* loaded from: classes3.dex */
public class FileUtil {
    private static int $10 = 0;
    private static int $11 = 1;
    private static long BuiltInFictitiousFunctionClassFactory = 250983695041978804L;
    private static int MyBillsEntityDataFactory = 0;
    private static int getAuthRequestContext = 1;

    public static void a(File file, File file2) throws IOException {
        Throwable th;
        FileChannel fileChannel;
        FileInputStream fileInputStream;
        FileOutputStream fileOutputStream;
        FileChannel fileChannel2 = null;
        try {
            fileInputStream = new FileInputStream(file);
            try {
                fileChannel = fileInputStream.getChannel();
            } catch (Throwable th2) {
                th = th2;
                fileChannel = null;
            }
        } catch (Throwable th3) {
            th = th3;
            fileChannel = null;
            fileInputStream = null;
            fileOutputStream = null;
        }
        try {
            fileOutputStream = new FileOutputStream(file2);
        } catch (Throwable th4) {
            th = th4;
            int i = getAuthRequestContext + 47;
            MyBillsEntityDataFactory = i % 128;
            int i2 = i % 2;
            fileOutputStream = null;
            try {
                throw new IOException(th);
            } finally {
                safeClose(fileInputStream);
                safeClose(fileChannel);
                safeClose(fileOutputStream);
                safeClose(fileChannel2);
            }
        }
        try {
            fileChannel2 = fileOutputStream.getChannel();
            fileChannel.transferTo(0L, fileChannel.size(), fileChannel2);
            if (!(file2.exists())) {
                throw new RuntimeException("copy file fail");
            }
            int i3 = MyBillsEntityDataFactory + 69;
            getAuthRequestContext = i3 % 128;
            int i4 = i3 % 2;
        } catch (Throwable th5) {
            th = th5;
            throw new IOException(th);
        }
    }

    public static void moveFile(File file, File file2) throws IOException {
        try {
            int i = MyBillsEntityDataFactory + 123;
            getAuthRequestContext = i % 128;
            int i2 = i % 2;
            try {
                Object[] objArr = null;
                if (!(file.renameTo(file2))) {
                    int i3 = MyBillsEntityDataFactory + 51;
                    getAuthRequestContext = i3 % 128;
                    if (i3 % 2 == 0) {
                        a(file, file2);
                        file.delete();
                        objArr.hashCode();
                    } else {
                        a(file, file2);
                        file.delete();
                    }
                    int i4 = MyBillsEntityDataFactory + 41;
                    getAuthRequestContext = i4 % 128;
                    int i5 = i4 % 2;
                }
                if (!file.exists()) {
                    int i6 = MyBillsEntityDataFactory + 75;
                    getAuthRequestContext = i6 % 128;
                    if (i6 % 2 != 0) {
                        if (file2.exists()) {
                            return;
                        }
                    } else {
                        boolean exists = file2.exists();
                        int length = objArr.length;
                        if (exists) {
                            return;
                        }
                    }
                }
                throw new Exception("move file fail");
            } catch (Throwable th) {
                throw new IOException(th);
            }
        } catch (Exception e) {
            throw e;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:13:0x0022, code lost:
    
        if (r0 != false) goto L50;
     */
    /* JADX WARN: Code restructure failed: missing block: B:14:0x0024, code lost:
    
        r0 = new java.io.FileInputStream(r10);
     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x0029, code lost:
    
        r10 = new byte[r0.available()];
        r0.read(r10);
        r2 = new java.lang.Object[1];
        b(android.view.View.MeasureSpec.makeMeasureSpec(0, 0), new char[]{18933, 58836, 18848, 51676, 17873, 7471, 56564, 22989, 63677}, r2);
        r5 = new java.lang.String(r10, ((java.lang.String) r2[0]).intern());
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x007b, code lost:
    
        safeClose(r0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x007e, code lost:
    
        return r5;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x007f, code lost:
    
        r10 = th;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x0080, code lost:
    
        r4 = r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x0082, code lost:
    
        r10 = e;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x0084, code lost:
    
        r10 = th;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x0086, code lost:
    
        r10 = e;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x0087, code lost:
    
        r0 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x0088, code lost:
    
        com.iap.ac.android.loglite.utils.LoggerWrapper.w("FileUtil", r10);
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x008d, code lost:
    
        safeClose(r0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x0091, code lost:
    
        safeClose(r4);
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x0094, code lost:
    
        throw r10;
     */
    /* JADX WARN: Code restructure failed: missing block: B:9:0x0018, code lost:
    
        if (r10.exists() != false) goto L50;
     */
    /* JADX WARN: Removed duplicated region for block: B:32:0x00a2  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x00a5  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x00a9 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:36:0x00aa  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String readFile(java.io.File r10) {
        /*
            int r0 = com.iap.ac.android.loglite.utils.FileUtil.MyBillsEntityDataFactory
            int r0 = r0 + 107
            int r1 = r0 % 128
            com.iap.ac.android.loglite.utils.FileUtil.getAuthRequestContext = r1
            r1 = 2
            int r0 = r0 % r1
            r2 = 1
            r3 = 0
            if (r0 != 0) goto L10
            r0 = 0
            goto L11
        L10:
            r0 = 1
        L11:
            r4 = 0
            if (r0 == 0) goto L1b
            boolean r0 = r10.exists()
            if (r0 == 0) goto L95
            goto L24
        L1b:
            boolean r0 = r10.exists()
            r4.hashCode()     // Catch: java.lang.Throwable -> Lb0
            if (r0 == 0) goto L95
        L24:
            java.io.FileInputStream r0 = new java.io.FileInputStream     // Catch: java.lang.Throwable -> L84 java.lang.Exception -> L86
            r0.<init>(r10)     // Catch: java.lang.Throwable -> L84 java.lang.Exception -> L86
            int r10 = r0.available()     // Catch: java.lang.Throwable -> L7f java.lang.Exception -> L82
            byte[] r10 = new byte[r10]     // Catch: java.lang.Throwable -> L7f java.lang.Exception -> L82
            r0.read(r10)     // Catch: java.lang.Throwable -> L7f java.lang.Exception -> L82
            java.lang.String r5 = new java.lang.String     // Catch: java.lang.Throwable -> L7f java.lang.Exception -> L82
            int r6 = android.view.View.MeasureSpec.makeMeasureSpec(r3, r3)     // Catch: java.lang.Throwable -> L7f java.lang.Exception -> L82
            r7 = 9
            char[] r7 = new char[r7]     // Catch: java.lang.Throwable -> L7f java.lang.Exception -> L82
            r8 = 18933(0x49f5, float:2.6531E-41)
            r7[r3] = r8     // Catch: java.lang.Throwable -> L7f java.lang.Exception -> L82
            r8 = 58836(0xe5d4, float:8.2447E-41)
            r7[r2] = r8     // Catch: java.lang.Throwable -> L7f java.lang.Exception -> L82
            r8 = 18848(0x49a0, float:2.6412E-41)
            r7[r1] = r8     // Catch: java.lang.Throwable -> L7f java.lang.Exception -> L82
            r8 = 3
            r9 = 51676(0xc9dc, float:7.2413E-41)
            r7[r8] = r9     // Catch: java.lang.Throwable -> L7f java.lang.Exception -> L82
            r8 = 4
            r9 = 17873(0x45d1, float:2.5045E-41)
            r7[r8] = r9     // Catch: java.lang.Throwable -> L7f java.lang.Exception -> L82
            r8 = 5
            r9 = 7471(0x1d2f, float:1.0469E-41)
            r7[r8] = r9     // Catch: java.lang.Throwable -> L7f java.lang.Exception -> L82
            r8 = 6
            r9 = 56564(0xdcf4, float:7.9263E-41)
            r7[r8] = r9     // Catch: java.lang.Throwable -> L7f java.lang.Exception -> L82
            r8 = 7
            r9 = 22989(0x59cd, float:3.2214E-41)
            r7[r8] = r9     // Catch: java.lang.Throwable -> L7f java.lang.Exception -> L82
            r8 = 8
            r9 = 63677(0xf8bd, float:8.923E-41)
            r7[r8] = r9     // Catch: java.lang.Throwable -> L7f java.lang.Exception -> L82
            java.lang.Object[] r2 = new java.lang.Object[r2]     // Catch: java.lang.Throwable -> L7f java.lang.Exception -> L82
            b(r6, r7, r2)     // Catch: java.lang.Throwable -> L7f java.lang.Exception -> L82
            r2 = r2[r3]     // Catch: java.lang.Throwable -> L7f java.lang.Exception -> L82
            java.lang.String r2 = (java.lang.String) r2     // Catch: java.lang.Throwable -> L7f java.lang.Exception -> L82
            java.lang.String r2 = r2.intern()     // Catch: java.lang.Throwable -> L7f java.lang.Exception -> L82
            r5.<init>(r10, r2)     // Catch: java.lang.Throwable -> L7f java.lang.Exception -> L82
            safeClose(r0)
            return r5
        L7f:
            r10 = move-exception
            r4 = r0
            goto L91
        L82:
            r10 = move-exception
            goto L88
        L84:
            r10 = move-exception
            goto L91
        L86:
            r10 = move-exception
            r0 = r4
        L88:
            java.lang.String r2 = "FileUtil"
            com.iap.ac.android.loglite.utils.LoggerWrapper.w(r2, r10)     // Catch: java.lang.Throwable -> L7f
            safeClose(r0)
            goto L95
        L91:
            safeClose(r4)
            throw r10
        L95:
            int r10 = com.iap.ac.android.loglite.utils.FileUtil.MyBillsEntityDataFactory
            int r10 = r10 + 29
            int r0 = r10 % 128
            com.iap.ac.android.loglite.utils.FileUtil.getAuthRequestContext = r0
            int r10 = r10 % r1
            r0 = 78
            if (r10 != 0) goto La5
            r10 = 78
            goto La7
        La5:
            r10 = 97
        La7:
            if (r10 == r0) goto Laa
            return r4
        Laa:
            r10 = 48
            int r10 = r10 / r3
            return r4
        Lae:
            r10 = move-exception
            throw r10
        Lb0:
            r10 = move-exception
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.iap.ac.android.loglite.utils.FileUtil.readFile(java.io.File):java.lang.String");
    }

    public static void safeClose(Closeable closeable) {
        try {
            int i = MyBillsEntityDataFactory + 51;
            getAuthRequestContext = i % 128;
            if ((i % 2 == 0 ? '\r' : ';') != '\r') {
                if (!(closeable != null)) {
                    return;
                }
            } else {
                Object obj = null;
                obj.hashCode();
                if (closeable == null) {
                    return;
                }
            }
            try {
                closeable.close();
                int i2 = getAuthRequestContext + 11;
                MyBillsEntityDataFactory = i2 % 128;
                if ((i2 % 2 != 0 ? '\n' : '\\') != '\\') {
                    int i3 = 27 / 0;
                }
            } catch (IOException e) {
                LoggerWrapper.w("FileUtil", e);
            }
        } catch (Exception e2) {
            throw e2;
        }
    }

    public static void writeFile(String str, File file) throws Exception {
        FileOutputStream fileOutputStream;
        byte[] bytes;
        try {
            Object[] objArr = new Object[1];
            b(ImageFormat.getBitsPerPixel(0) + 1, new char[]{18933, 58836, 18848, 51676, 17873, 7471, 56564, 22989, 63677}, objArr);
            bytes = str.getBytes(((String) objArr[0]).intern());
            if (file.getParentFile().exists() ? false : true) {
                int i = MyBillsEntityDataFactory + 15;
                getAuthRequestContext = i % 128;
                int i2 = i % 2;
                file.getParentFile().mkdirs();
                int i3 = getAuthRequestContext + 15;
                MyBillsEntityDataFactory = i3 % 128;
                int i4 = i3 % 2;
            }
            fileOutputStream = new FileOutputStream(file, true);
        } catch (Throwable th) {
            th = th;
            fileOutputStream = null;
        }
        try {
            fileOutputStream.write(bytes);
            fileOutputStream.flush();
            safeClose(fileOutputStream);
        } catch (Throwable th2) {
            th = th2;
            safeClose(fileOutputStream);
            throw th;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:13:0x002d, code lost:
    
        if (r11.exists() != false) goto L63;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x0036, code lost:
    
        if (r11.exists() != false) goto L63;
     */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0065  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0067  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x006a A[Catch: all -> 0x008f, TryCatch #2 {all -> 0x008f, blocks: (B:25:0x0044, B:29:0x0056, B:35:0x0060, B:40:0x006a, B:45:0x0073, B:48:0x007a, B:50:0x0080, B:51:0x0085, B:32:0x005c), top: B:65:0x0044 }] */
    /* JADX WARN: Removed duplicated region for block: B:67:0x008d A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static long getFolderSize(java.io.File r11) {
        /*
            int r0 = com.iap.ac.android.loglite.utils.FileUtil.MyBillsEntityDataFactory
            int r0 = r0 + 57
            int r1 = r0 % 128
            com.iap.ac.android.loglite.utils.FileUtil.getAuthRequestContext = r1
            int r0 = r0 % 2
            r0 = 74
            if (r11 == 0) goto L11
            r1 = 74
            goto L13
        L11:
            r1 = 41
        L13:
            r2 = 0
            if (r1 == r0) goto L19
            goto L9c
        L19:
            int r0 = com.iap.ac.android.loglite.utils.FileUtil.getAuthRequestContext
            int r0 = r0 + 11
            int r1 = r0 % 128
            com.iap.ac.android.loglite.utils.FileUtil.MyBillsEntityDataFactory = r1
            int r0 = r0 % 2
            r1 = 0
            if (r0 == 0) goto L32
            boolean r0 = r11.exists()
            r4 = 87
            int r4 = r4 / r1
            if (r0 == 0) goto L9c
            goto L38
        L30:
            r11 = move-exception
            throw r11
        L32:
            boolean r0 = r11.exists()
            if (r0 == 0) goto L9c
        L38:
            boolean r0 = r11.isDirectory()     // Catch: java.lang.Exception -> L9a
            r4 = 1
            if (r0 == 0) goto L41
            r0 = 0
            goto L42
        L41:
            r0 = 1
        L42:
            if (r0 == r4) goto L9c
            java.io.File[] r0 = r11.listFiles()     // Catch: java.lang.Throwable -> L8f
            if (r0 == 0) goto L8e
            int r5 = com.iap.ac.android.loglite.utils.FileUtil.getAuthRequestContext
            int r5 = r5 + 101
            int r6 = r5 % 128
            com.iap.ac.android.loglite.utils.FileUtil.MyBillsEntityDataFactory = r6
            int r5 = r5 % 2
            if (r5 == 0) goto L5c
            int r5 = r0.length     // Catch: java.lang.Throwable -> L8f
            r6 = 0
            int r6 = r6.length     // Catch: java.lang.Throwable -> L8f
            if (r5 != 0) goto L60
            goto L8e
        L5c:
            int r5 = r0.length     // Catch: java.lang.Throwable -> L8f
            if (r5 != 0) goto L60
            goto L8e
        L60:
            int r5 = r0.length     // Catch: java.lang.Throwable -> L8f
            r7 = r2
            r6 = 0
        L63:
            if (r6 >= r5) goto L67
            r9 = 0
            goto L68
        L67:
            r9 = 1
        L68:
            if (r9 == r4) goto L8d
            r9 = r0[r6]     // Catch: java.lang.Throwable -> L8f
            if (r9 == 0) goto L70
            r10 = 0
            goto L71
        L70:
            r10 = 1
        L71:
            if (r10 == r4) goto L8a
            boolean r10 = r9.exists()     // Catch: java.lang.Throwable -> L8f
            if (r10 != 0) goto L7a
            goto L8a
        L7a:
            boolean r10 = r9.isFile()     // Catch: java.lang.Throwable -> L8f
            if (r10 == 0) goto L85
            long r9 = r9.length()     // Catch: java.lang.Throwable -> L8f
            goto L89
        L85:
            long r9 = getFolderSize(r9)     // Catch: java.lang.Throwable -> L8f
        L89:
            long r7 = r7 + r9
        L8a:
            int r6 = r6 + 1
            goto L63
        L8d:
            return r7
        L8e:
            return r2
        L8f:
            r0 = move-exception
            java.lang.String r11 = r11.getAbsolutePath()
            java.lang.String r1 = "FileUtil"
            com.iap.ac.android.loglite.utils.LoggerWrapper.w(r1, r11, r0)
            goto L9c
        L9a:
            r11 = move-exception
            throw r11
        L9c:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.iap.ac.android.loglite.utils.FileUtil.getFolderSize(java.io.File):long");
    }

    /* JADX WARN: Removed duplicated region for block: B:27:0x005b A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:44:0x0055 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static void writeFile(java.io.File r3, byte[] r4, boolean r5) throws java.io.IOException {
        /*
            int r0 = com.iap.ac.android.loglite.utils.FileUtil.MyBillsEntityDataFactory
            int r0 = r0 + 87
            int r1 = r0 % 128
            com.iap.ac.android.loglite.utils.FileUtil.getAuthRequestContext = r1
            int r0 = r0 % 2
            if (r0 != 0) goto Le
            r0 = 0
            goto Lf
        Le:
            r0 = 1
        Lf:
            r1 = 0
            if (r0 == 0) goto L1d
            java.io.File r0 = r3.getParentFile()     // Catch: java.lang.Throwable -> L61
            boolean r0 = r0.exists()     // Catch: java.lang.Throwable -> L61
            if (r0 != 0) goto L3b
            goto L34
        L1d:
            java.io.File r0 = r3.getParentFile()     // Catch: java.lang.Throwable -> L61
            boolean r0 = r0.exists()     // Catch: java.lang.Throwable -> L61
            r1.hashCode()     // Catch: java.lang.Throwable -> L61
            r2 = 30
            if (r0 != 0) goto L2f
            r0 = 30
            goto L31
        L2f:
            r0 = 9
        L31:
            if (r0 == r2) goto L34
            goto L3b
        L34:
            java.io.File r0 = r3.getParentFile()     // Catch: java.lang.Throwable -> L61
            r0.mkdirs()     // Catch: java.lang.Throwable -> L61
        L3b:
            java.io.FileOutputStream r0 = new java.io.FileOutputStream     // Catch: java.lang.Throwable -> L61
            r0.<init>(r3, r5)     // Catch: java.lang.Throwable -> L61
            r0.write(r4)     // Catch: java.lang.Throwable -> L5e
            r0.flush()     // Catch: java.lang.Throwable -> L5e
            safeClose(r0)     // Catch: java.lang.Exception -> L5c
            int r3 = com.iap.ac.android.loglite.utils.FileUtil.getAuthRequestContext
            int r3 = r3 + 105
            int r4 = r3 % 128
            com.iap.ac.android.loglite.utils.FileUtil.MyBillsEntityDataFactory = r4
            int r3 = r3 % 2
            if (r3 == 0) goto L5b
            r1.hashCode()     // Catch: java.lang.Throwable -> L59
            return
        L59:
            r3 = move-exception
            throw r3
        L5b:
            return
        L5c:
            r3 = move-exception
            throw r3
        L5e:
            r3 = move-exception
            r1 = r0
            goto L62
        L61:
            r3 = move-exception
        L62:
            java.io.IOException r4 = new java.io.IOException     // Catch: java.lang.Throwable -> L68
            r4.<init>(r3)     // Catch: java.lang.Throwable -> L68
            throw r4     // Catch: java.lang.Throwable -> L68
        L68:
            r3 = move-exception
            safeClose(r1)
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.iap.ac.android.loglite.utils.FileUtil.writeFile(java.io.File, byte[], boolean):void");
    }

    private static void b(int i, char[] cArr, Object[] objArr) {
        D d = new D();
        char[] KClassImpl$Data$declaredNonStaticMembers$2 = D.KClassImpl$Data$declaredNonStaticMembers$2(BuiltInFictitiousFunctionClassFactory ^ 3919452569568103912L, cArr, i);
        d.MyBillsEntityDataFactory = 4;
        while (true) {
            if (!(d.MyBillsEntityDataFactory >= KClassImpl$Data$declaredNonStaticMembers$2.length)) {
                int i2 = $11 + 117;
                $10 = i2 % 128;
                int i3 = i2 % 2;
                d.PlaceComponentResult = d.MyBillsEntityDataFactory - 4;
                KClassImpl$Data$declaredNonStaticMembers$2[d.MyBillsEntityDataFactory] = (char) ((KClassImpl$Data$declaredNonStaticMembers$2[d.MyBillsEntityDataFactory] ^ KClassImpl$Data$declaredNonStaticMembers$2[d.MyBillsEntityDataFactory % 4]) ^ (d.PlaceComponentResult * (BuiltInFictitiousFunctionClassFactory ^ 3919452569568103912L)));
                d.MyBillsEntityDataFactory++;
                int i4 = $10 + 109;
                $11 = i4 % 128;
                int i5 = i4 % 2;
            } else {
                objArr[0] = new String(KClassImpl$Data$declaredNonStaticMembers$2, 4, KClassImpl$Data$declaredNonStaticMembers$2.length - 4);
                return;
            }
        }
    }
}
