package com.uc.crashsdk.a;

import com.alipay.android.phone.mobilesdk.socketcraft.api.WSContextConstant;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

/* loaded from: classes8.dex */
public final class d {

    /* renamed from: a  reason: collision with root package name */
    public static final int[] f7704a = {126, 147, 115, 241, 101, 198, 215, 134};
    public static final int[] b = {125, WSContextConstant.HANDSHAKE_RECEIVE_SIZE, 233, 226, 129, 142, 151, 176};
    public static final int[] c = {238, WSContextConstant.HANDSHAKE_RECEIVE_SIZE, 233, 179, 129, 142, 151, 167};

    /* JADX WARN: Not initialized variable reg: 2, insn: 0x0048: MOVE (r1 I:??[OBJECT, ARRAY]) = (r2 I:??[OBJECT, ARRAY]), block:B:20:0x0048 */
    public static String a(String str) {
        FileInputStream fileInputStream;
        Closeable closeable;
        File file = new File(str);
        Closeable closeable2 = null;
        if (file.exists()) {
            try {
                try {
                    fileInputStream = new FileInputStream(file);
                } catch (Exception e) {
                    e = e;
                    fileInputStream = null;
                } catch (Throwable th) {
                    th = th;
                    b.a(closeable2);
                    throw th;
                }
                try {
                    byte[] bArr = new byte[(int) file.length()];
                    fileInputStream.read(bArr);
                    fileInputStream.close();
                    byte[] a2 = a(bArr, f7704a);
                    if (a2 != null && a2.length > 0) {
                        int length = a2.length - 1;
                        String str2 = a2[length] == 10 ? new String(a2, 0, length) : new String(a2);
                        b.a(fileInputStream);
                        return str2;
                    }
                    b.a(fileInputStream);
                    return null;
                } catch (Exception e2) {
                    e = e2;
                    a.a(e, false);
                    b.a(fileInputStream);
                    return null;
                }
            } catch (Throwable th2) {
                th = th2;
                closeable2 = closeable;
                b.a(closeable2);
                throw th;
            }
        }
        return null;
    }

    private static byte[] a(File file) {
        FileInputStream fileInputStream;
        byte[] bArr;
        if (file.exists()) {
            try {
                bArr = new byte[(int) file.length()];
                fileInputStream = new FileInputStream(file);
            } catch (Throwable th) {
                th = th;
                fileInputStream = null;
            }
            try {
                fileInputStream.read(bArr);
                return bArr;
            } catch (Throwable th2) {
                th = th2;
                try {
                    a.a(th, false);
                    return null;
                } finally {
                    b.a(fileInputStream);
                }
            }
        }
        return null;
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x0020, code lost:
    
        r1 = a(r0);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String a(java.lang.String r7, java.lang.String r8, boolean r9) {
        /*
            if (r9 != 0) goto L3
            return r7
        L3:
            boolean r0 = com.uc.crashsdk.a.h.a(r7)
            if (r0 == 0) goto La
            return r7
        La:
            java.io.File r0 = new java.io.File
            r0.<init>(r7)
            boolean r1 = r0.exists()
            if (r1 == 0) goto Lba
            long r1 = r0.length()
            r3 = 3145728(0x300000, double:1.554196E-317)
            int r5 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r5 > 0) goto Lba
            byte[] r1 = a(r0)
            if (r1 == 0) goto Lba
            int r2 = r1.length
            if (r2 <= 0) goto Lba
            r2 = 1
            r3 = 0
            if (r9 == 0) goto L7f
            r9 = 0
            java.io.ByteArrayOutputStream r4 = new java.io.ByteArrayOutputStream     // Catch: java.lang.Throwable -> L46
            r4.<init>()     // Catch: java.lang.Throwable -> L46
            java.util.zip.GZIPOutputStream r5 = new java.util.zip.GZIPOutputStream     // Catch: java.lang.Throwable -> L41
            r5.<init>(r4)     // Catch: java.lang.Throwable -> L41
            r5.write(r1)     // Catch: java.lang.Throwable -> L3f
            r4.flush()     // Catch: java.lang.Throwable -> L3f
            goto L4d
        L3f:
            r9 = move-exception
            goto L4a
        L41:
            r5 = move-exception
            r6 = r5
            r5 = r9
            r9 = r6
            goto L4a
        L46:
            r4 = move-exception
            r5 = r9
            r9 = r4
            r4 = r5
        L4a:
            com.uc.crashsdk.a.a.a(r9, r3)     // Catch: java.lang.Throwable -> L77
        L4d:
            com.uc.crashsdk.a.b.a(r4)
            com.uc.crashsdk.a.b.a(r5)
            byte[] r1 = r4.toByteArray()     // Catch: java.lang.Throwable -> L59
            r9 = 1
            goto L5e
        L59:
            r9 = move-exception
            com.uc.crashsdk.a.a.a(r9, r3)
            r9 = 0
        L5e:
            if (r9 == 0) goto L76
            if (r1 == 0) goto L76
            int r9 = r1.length
            if (r9 <= 0) goto L76
            java.lang.StringBuilder r9 = new java.lang.StringBuilder
            r9.<init>()
            r9.append(r7)
            r9.append(r8)
            java.lang.String r8 = r9.toString()
            r9 = 1
            goto L81
        L76:
            return r7
        L77:
            r7 = move-exception
            com.uc.crashsdk.a.b.a(r4)
            com.uc.crashsdk.a.b.a(r5)
            throw r7
        L7f:
            r8 = r7
            r9 = 0
        L81:
            if (r9 == 0) goto Lba
            java.lang.String r9 = r0.getName()
            boolean r9 = r8.equals(r9)
            if (r9 == 0) goto La0
            java.lang.StringBuilder r9 = new java.lang.StringBuilder
            r9.<init>()
            r9.append(r8)
            java.lang.String r4 = ".tmp"
            r9.append(r4)
            java.lang.String r9 = r9.toString()
            r4 = 1
            goto La2
        La0:
            r9 = r8
            r4 = 0
        La2:
            java.io.File r5 = new java.io.File
            r5.<init>(r9)
            boolean r9 = com.uc.crashsdk.a.b.a(r5, r1)
            if (r9 != 0) goto Laf
            r2 = 0
            goto Lb7
        Laf:
            if (r4 == 0) goto Lb7
            r0.delete()
            r5.renameTo(r0)
        Lb7:
            if (r2 == 0) goto Lba
            return r8
        Lba:
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.uc.crashsdk.a.d.a(java.lang.String, java.lang.String, boolean):java.lang.String");
    }

    private static byte[] a(byte[] bArr, int[] iArr) {
        if (bArr.length - 0 >= 2 && iArr != null && iArr.length == 8) {
            int length = (bArr.length - 2) - 0;
            try {
                byte[] bArr2 = new byte[length];
                byte b2 = 0;
                for (int i = 0; i < length; i++) {
                    byte b3 = (byte) (bArr[i + 0] ^ iArr[i % 8]);
                    bArr2[i] = b3;
                    b2 = (byte) (b2 ^ b3);
                }
                if (bArr[length + 0] == ((byte) ((iArr[0] ^ b2) & 255)) && bArr[length + 1 + 0] == ((byte) ((iArr[1] ^ b2) & 255))) {
                    return bArr2;
                }
                return null;
            } catch (Exception e) {
                a.a(e, false);
            }
        }
        return null;
    }

    private static byte[] b(byte[] bArr, int[] iArr) {
        if (bArr == null || iArr == null || iArr.length != 8) {
            return null;
        }
        int length = bArr.length;
        try {
            byte[] bArr2 = new byte[length + 2];
            byte b2 = 0;
            for (int i = 0; i < length; i++) {
                byte b3 = bArr[i];
                bArr2[i] = (byte) (iArr[i % 8] ^ b3);
                b2 = (byte) (b2 ^ b3);
            }
            bArr2[length] = (byte) (iArr[0] ^ b2);
            bArr2[length + 1] = (byte) (iArr[1] ^ b2);
            return bArr2;
        } catch (Exception e) {
            a.a(e, false);
            return null;
        }
    }

    public static boolean a(String str, String str2) {
        FileOutputStream fileOutputStream;
        try {
            File file = new File(str);
            if (file.exists()) {
                file.delete();
            }
            fileOutputStream = new FileOutputStream(file);
        } catch (Throwable th) {
            a.a(th, false);
            fileOutputStream = null;
        }
        if (fileOutputStream == null) {
            return false;
        }
        byte[] b2 = b(str2.getBytes(), f7704a);
        if (b2 == null) {
            return false;
        }
        try {
            fileOutputStream.write(b2);
            try {
                fileOutputStream.close();
            } catch (Throwable th2) {
                a.a(th2, false);
            }
            return true;
        } catch (Throwable th3) {
            try {
                a.a(th3, false);
                try {
                    fileOutputStream.close();
                    return false;
                } catch (Throwable th4) {
                    a.a(th4, false);
                    return false;
                }
            } finally {
                try {
                    fileOutputStream.close();
                } catch (Throwable th5) {
                    a.a(th5, false);
                }
            }
        }
    }
}
