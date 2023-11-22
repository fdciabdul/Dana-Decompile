package okhttp3.internal.publicsuffix;

import java.io.IOException;
import java.io.InputStream;
import java.io.InterruptedIOException;
import java.net.IDN;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicBoolean;
import okhttp3.internal.Util;
import okhttp3.internal.platform.Platform;
import okio.BufferedSource;
import okio.GzipSource;
import okio.Okio;

/* loaded from: classes2.dex */
public final class PublicSuffixDatabase {
    private static final byte EXCEPTION_MARKER = 33;
    public static final String PUBLIC_SUFFIX_RESOURCE = "publicsuffixes.gz";
    private byte[] publicSuffixExceptionListBytes;
    private byte[] publicSuffixListBytes;
    public static final byte[] getAuthRequestContext = {1, 78, 11, -6, 16, -5, -2, -15, 7, 4, -34, 18, 8, -15, -6, 1, -11, 19, -23, -53, 60, -13, 11, -9, -59, 36, 18, 8, -15, -6, 1};
    public static final int KClassImpl$Data$declaredNonStaticMembers$2 = 45;
    private static final byte[] WILDCARD_LABEL = {42};
    private static final String[] EMPTY_RULE = new String[0];
    private static final String[] PREVAILING_RULE = {"*"};
    private static final PublicSuffixDatabase instance = new PublicSuffixDatabase();
    private final AtomicBoolean listRead = new AtomicBoolean(false);
    private final CountDownLatch readCompleteLatch = new CountDownLatch(1);

    /* JADX WARN: Removed duplicated region for block: B:10:0x0027  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x001f  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x0027 -> B:11:0x002e). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void a(int r6, byte r7, short r8, java.lang.Object[] r9) {
        /*
            int r6 = r6 * 3
            int r6 = r6 + 13
            int r8 = r8 * 7
            int r8 = r8 + 99
            int r7 = r7 * 12
            int r7 = r7 + 4
            byte[] r0 = okhttp3.internal.publicsuffix.PublicSuffixDatabase.getAuthRequestContext
            byte[] r1 = new byte[r6]
            int r6 = r6 + (-1)
            r2 = 0
            if (r0 != 0) goto L19
            r4 = r8
            r3 = 0
            r8 = r7
            goto L2e
        L19:
            r3 = 0
        L1a:
            byte r4 = (byte) r8
            r1[r3] = r4
            if (r3 != r6) goto L27
            java.lang.String r6 = new java.lang.String
            r6.<init>(r1, r2)
            r9[r2] = r6
            return
        L27:
            int r3 = r3 + 1
            r4 = r0[r7]
            r5 = r8
            r8 = r7
            r7 = r5
        L2e:
            int r7 = r7 + r4
            int r8 = r8 + 1
            int r7 = r7 + 2
            r5 = r8
            r8 = r7
            r7 = r5
            goto L1a
        */
        throw new UnsupportedOperationException("Method not decompiled: okhttp3.internal.publicsuffix.PublicSuffixDatabase.a(int, byte, short, java.lang.Object[]):void");
    }

    public static PublicSuffixDatabase get() {
        return instance;
    }

    public final String getEffectiveTldPlusOne(String str) {
        int length;
        int length2;
        if (str == null) {
            throw new NullPointerException("domain == null");
        }
        String[] split = IDN.toUnicode(str).split("\\.");
        String[] findMatchingRule = findMatchingRule(split);
        if (split.length != findMatchingRule.length || findMatchingRule[0].charAt(0) == '!') {
            if (findMatchingRule[0].charAt(0) == '!') {
                length = split.length;
                length2 = findMatchingRule.length;
            } else {
                length = split.length;
                length2 = findMatchingRule.length + 1;
            }
            StringBuilder sb = new StringBuilder();
            String[] split2 = str.split("\\.");
            for (int i = length - length2; i < split2.length; i++) {
                sb.append(split2[i]);
                sb.append('.');
            }
            sb.deleteCharAt(sb.length() - 1);
            return sb.toString();
        }
        return null;
    }

    private String[] findMatchingRule(String[] strArr) {
        String str;
        String str2;
        String[] strArr2;
        String[] strArr3;
        String str3 = null;
        int i = 0;
        if (!this.listRead.get() && this.listRead.compareAndSet(false, true)) {
            readTheListUninterruptibly();
        } else {
            try {
                try {
                    this.readCompleteLatch.await();
                } catch (Throwable th) {
                    Throwable cause = th.getCause();
                    if (cause != null) {
                        throw cause;
                    }
                    throw th;
                }
            } catch (InterruptedException unused) {
                byte b = getAuthRequestContext[0];
                byte b2 = b;
                Object[] objArr = new Object[1];
                a(b, b2, b2, objArr);
                Class<?> cls = Class.forName((String) objArr[0]);
                byte b3 = (byte) (getAuthRequestContext[0] - 1);
                byte b4 = b3;
                Object[] objArr2 = new Object[1];
                a(b3, b4, b4, objArr2);
                ((Thread) cls.getMethod((String) objArr2[0], null).invoke(null, null)).interrupt();
            }
        }
        synchronized (this) {
            if (this.publicSuffixListBytes == null) {
                throw new IllegalStateException("Unable to load publicsuffixes.gz resource from the classpath.");
            }
        }
        int length = strArr.length;
        byte[][] bArr = new byte[length];
        for (int i2 = 0; i2 < strArr.length; i2++) {
            bArr[i2] = strArr[i2].getBytes(Util.UTF_8);
        }
        int i3 = 0;
        while (true) {
            if (i3 >= length) {
                str = null;
                break;
            }
            str = binarySearchBytes(this.publicSuffixListBytes, bArr, i3);
            if (str != null) {
                break;
            }
            i3++;
        }
        if (length > 1) {
            byte[][] bArr2 = (byte[][]) bArr.clone();
            for (int i4 = 0; i4 < bArr2.length - 1; i4++) {
                bArr2[i4] = WILDCARD_LABEL;
                str2 = binarySearchBytes(this.publicSuffixListBytes, bArr2, i4);
                if (str2 != null) {
                    break;
                }
            }
        }
        str2 = null;
        if (str2 != null) {
            while (true) {
                if (i >= length - 1) {
                    break;
                }
                String binarySearchBytes = binarySearchBytes(this.publicSuffixExceptionListBytes, bArr, i);
                if (binarySearchBytes != null) {
                    str3 = binarySearchBytes;
                    break;
                }
                i++;
            }
        }
        if (str3 != null) {
            StringBuilder sb = new StringBuilder();
            sb.append("!");
            sb.append(str3);
            return sb.toString().split("\\.");
        } else if (str == null && str2 == null) {
            return PREVAILING_RULE;
        } else {
            if (str != null) {
                strArr2 = str.split("\\.");
            } else {
                strArr2 = EMPTY_RULE;
            }
            if (str2 != null) {
                strArr3 = str2.split("\\.");
            } else {
                strArr3 = EMPTY_RULE;
            }
            return strArr2.length <= strArr3.length ? strArr3 : strArr2;
        }
    }

    private static String binarySearchBytes(byte[] bArr, byte[][] bArr2, int i) {
        int i2;
        boolean z;
        int i3;
        int i4;
        int length = bArr.length;
        int i5 = 0;
        while (i5 < length) {
            int i6 = (i5 + length) / 2;
            while (i6 >= 0 && bArr[i6] != 10) {
                i6--;
            }
            int i7 = i6 + 1;
            int i8 = 1;
            while (true) {
                i2 = i7 + i8;
                if (bArr[i2] == 10) {
                    break;
                }
                i8++;
            }
            int i9 = i2 - i7;
            int i10 = i;
            boolean z2 = false;
            int i11 = 0;
            int i12 = 0;
            while (true) {
                if (z2) {
                    i3 = 46;
                    z = false;
                } else {
                    z = z2;
                    i3 = bArr2[i10][i11] & 255;
                }
                i4 = i3 - (bArr[i7 + i12] & 255);
                if (i4 != 0) {
                    break;
                }
                i12++;
                i11++;
                if (i12 == i9) {
                    break;
                } else if (bArr2[i10].length != i11) {
                    z2 = z;
                } else if (i10 == bArr2.length - 1) {
                    break;
                } else {
                    i10++;
                    i11 = -1;
                    z2 = true;
                }
            }
            if (i4 >= 0) {
                if (i4 <= 0) {
                    int i13 = i9 - i12;
                    int length2 = bArr2[i10].length - i11;
                    while (true) {
                        i10++;
                        if (i10 >= bArr2.length) {
                            break;
                        }
                        length2 += bArr2[i10].length;
                    }
                    if (length2 >= i13) {
                        if (length2 <= i13) {
                            return new String(bArr, i7, i9, Util.UTF_8);
                        }
                    }
                }
                i5 = i2 + 1;
            }
            length = i7 - 1;
        }
        return null;
    }

    private void readTheListUninterruptibly() {
        boolean z = false;
        while (true) {
            try {
                try {
                    readTheList();
                    break;
                } catch (InterruptedIOException unused) {
                    Thread.interrupted();
                    z = true;
                } catch (IOException e) {
                    Platform.get().log(5, "Failed to read public suffix list", e);
                    if (z) {
                        try {
                            byte b = getAuthRequestContext[0];
                            byte b2 = b;
                            Object[] objArr = new Object[1];
                            a(b, b2, b2, objArr);
                            Class<?> cls = Class.forName((String) objArr[0]);
                            byte b3 = (byte) (getAuthRequestContext[0] - 1);
                            byte b4 = b3;
                            Object[] objArr2 = new Object[1];
                            a(b3, b4, b4, objArr2);
                            ((Thread) cls.getMethod((String) objArr2[0], null).invoke(null, null)).interrupt();
                            return;
                        } catch (Throwable th) {
                            Throwable cause = th.getCause();
                            if (cause == null) {
                                throw th;
                            }
                            throw cause;
                        }
                    }
                    return;
                }
            } catch (Throwable th2) {
                if (z) {
                    try {
                        byte b5 = getAuthRequestContext[0];
                        byte b6 = b5;
                        Object[] objArr3 = new Object[1];
                        a(b5, b6, b6, objArr3);
                        Class<?> cls2 = Class.forName((String) objArr3[0]);
                        byte b7 = (byte) (getAuthRequestContext[0] - 1);
                        byte b8 = b7;
                        Object[] objArr4 = new Object[1];
                        a(b7, b8, b8, objArr4);
                        ((Thread) cls2.getMethod((String) objArr4[0], null).invoke(null, null)).interrupt();
                    } catch (Throwable th3) {
                        Throwable cause2 = th3.getCause();
                        if (cause2 == null) {
                            throw th3;
                        }
                        throw cause2;
                    }
                }
                throw th2;
            }
        }
        if (z) {
            try {
                byte b9 = getAuthRequestContext[0];
                byte b10 = b9;
                Object[] objArr5 = new Object[1];
                a(b9, b10, b10, objArr5);
                Class<?> cls3 = Class.forName((String) objArr5[0]);
                byte b11 = (byte) (getAuthRequestContext[0] - 1);
                byte b12 = b11;
                Object[] objArr6 = new Object[1];
                a(b11, b12, b12, objArr6);
                ((Thread) cls3.getMethod((String) objArr6[0], null).invoke(null, null)).interrupt();
            } catch (Throwable th4) {
                Throwable cause3 = th4.getCause();
                if (cause3 == null) {
                    throw th4;
                }
                throw cause3;
            }
        }
    }

    private void readTheList() throws IOException {
        InputStream resourceAsStream = PublicSuffixDatabase.class.getResourceAsStream(PUBLIC_SUFFIX_RESOURCE);
        if (resourceAsStream == null) {
            return;
        }
        BufferedSource KClassImpl$Data$declaredNonStaticMembers$22 = Okio.KClassImpl$Data$declaredNonStaticMembers$2(new GzipSource(Okio.getAuthRequestContext(resourceAsStream)));
        try {
            byte[] bArr = new byte[KClassImpl$Data$declaredNonStaticMembers$22.GetContactSyncConfig()];
            KClassImpl$Data$declaredNonStaticMembers$22.BuiltInFictitiousFunctionClassFactory(bArr);
            byte[] bArr2 = new byte[KClassImpl$Data$declaredNonStaticMembers$22.GetContactSyncConfig()];
            KClassImpl$Data$declaredNonStaticMembers$22.BuiltInFictitiousFunctionClassFactory(bArr2);
            synchronized (this) {
                this.publicSuffixListBytes = bArr;
                this.publicSuffixExceptionListBytes = bArr2;
            }
            this.readCompleteLatch.countDown();
        } finally {
            Util.closeQuietly(KClassImpl$Data$declaredNonStaticMembers$22);
        }
    }

    final void setListBytes(byte[] bArr, byte[] bArr2) {
        this.publicSuffixListBytes = bArr;
        this.publicSuffixExceptionListBytes = bArr2;
        this.listRead.set(true);
        this.readCompleteLatch.countDown();
    }
}
