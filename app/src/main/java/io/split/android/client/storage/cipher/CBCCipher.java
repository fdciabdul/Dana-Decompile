package io.split.android.client.storage.cipher;

import android.view.KeyEvent;
import java.nio.charset.Charset;
import o.VerifyPinStateManager$executeRiskChallenge$2$1;

/* loaded from: classes6.dex */
public class CBCCipher implements SplitCipher {
    private static int $10 = 0;
    private static int $11 = 1;
    private static int BuiltInFictitiousFunctionClassFactory = 1;
    private static final Charset CHARSET;
    private static int PlaceComponentResult;
    private static int[] getAuthRequestContext;
    private final CipherProvider mCipherProvider;

    static void getAuthRequestContext() {
        getAuthRequestContext = new int[]{1136221820, 271604047, -1648555962, 1717527249, -1333913744, -1872434034, -805995676, 1423828434, 2126118221, -2129555193, -145961199, -1004902866, 1255344514, 1304201621, 1264038935, -1605186555, 699959765, 1026348690};
    }

    static {
        getAuthRequestContext();
        Object[] objArr = new Object[1];
        a(KeyEvent.getDeadChar(0, 0) + 5, new int[]{-1839579889, -300366200, -1584709340, -1352041723}, objArr);
        CHARSET = Charset.forName(((String) objArr[0]).intern());
        int i = BuiltInFictitiousFunctionClassFactory + 113;
        PlaceComponentResult = i % 128;
        int i2 = i % 2;
    }

    public CBCCipher(String str) {
        this(new CBCCipherProvider(str));
    }

    public CBCCipher(CipherProvider cipherProvider) {
        try {
            this.mCipherProvider = cipherProvider;
        } catch (Exception e) {
            throw e;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:15:0x001e, code lost:
    
        if ((r5 != null) != true) goto L16;
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x0020, code lost:
    
        r5 = io.split.android.client.storage.cipher.CBCCipher.PlaceComponentResult + 61;
        io.split.android.client.storage.cipher.CBCCipher.BuiltInFictitiousFunctionClassFactory = r5 % 128;
        r5 = r5 % 2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x002a, code lost:
    
        r5 = io.split.android.client.storage.cipher.CBCCipher.BuiltInFictitiousFunctionClassFactory + 81;
        io.split.android.client.storage.cipher.CBCCipher.PlaceComponentResult = r5 % 128;
        r5 = r5 % 2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x0034, code lost:
    
        return null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x0035, code lost:
    
        r5 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x0036, code lost:
    
        throw r5;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x0037, code lost:
    
        r0 = r4.mCipherProvider.getEncryptionCipher();
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x003d, code lost:
    
        r5 = r0.doFinal(r5.getBytes(io.split.android.client.storage.cipher.CBCCipher.CHARSET));
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x0047, code lost:
    
        r4.mCipherProvider.release(r0);
        r5 = io.split.android.client.utils.Base64Util.encode(r5);
        r0 = io.split.android.client.storage.cipher.CBCCipher.PlaceComponentResult + 117;
        io.split.android.client.storage.cipher.CBCCipher.BuiltInFictitiousFunctionClassFactory = r0 % 128;
        r0 = r0 % 2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x005a, code lost:
    
        return r5;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x005b, code lost:
    
        r5 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x005d, code lost:
    
        r5 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x005e, code lost:
    
        r1 = new java.lang.StringBuilder();
        r1.append("Error encrypting data: ");
        r1.append(r5.getMessage());
        io.split.android.client.utils.logger.Logger.e(r1.toString());
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x0076, code lost:
    
        r4.mCipherProvider.release(r0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x007b, code lost:
    
        return null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x007c, code lost:
    
        r4.mCipherProvider.release(r0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x0081, code lost:
    
        throw r5;
     */
    /* JADX WARN: Code restructure failed: missing block: B:8:0x0015, code lost:
    
        if ((r5 == null) != true) goto L21;
     */
    @Override // io.split.android.client.storage.cipher.SplitCipher
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.String encrypt(java.lang.String r5) {
        /*
            r4 = this;
            int r0 = io.split.android.client.storage.cipher.CBCCipher.PlaceComponentResult     // Catch: java.lang.Exception -> L82
            int r0 = r0 + 71
            int r1 = r0 % 128
            io.split.android.client.storage.cipher.CBCCipher.BuiltInFictitiousFunctionClassFactory = r1     // Catch: java.lang.Exception -> L82
            int r0 = r0 % 2
            r1 = 0
            r2 = 0
            r3 = 1
            if (r0 != 0) goto L1a
            r2.hashCode()     // Catch: java.lang.Throwable -> L18
            if (r5 != 0) goto L15
            r1 = 1
        L15:
            if (r1 == r3) goto L20
            goto L37
        L18:
            r5 = move-exception
            throw r5
        L1a:
            if (r5 != 0) goto L1d
            goto L1e
        L1d:
            r1 = 1
        L1e:
            if (r1 == r3) goto L37
        L20:
            int r5 = io.split.android.client.storage.cipher.CBCCipher.PlaceComponentResult
            int r5 = r5 + 61
            int r0 = r5 % 128
            io.split.android.client.storage.cipher.CBCCipher.BuiltInFictitiousFunctionClassFactory = r0
            int r5 = r5 % 2
            int r5 = io.split.android.client.storage.cipher.CBCCipher.BuiltInFictitiousFunctionClassFactory     // Catch: java.lang.Exception -> L35
            int r5 = r5 + 81
            int r0 = r5 % 128
            io.split.android.client.storage.cipher.CBCCipher.PlaceComponentResult = r0     // Catch: java.lang.Exception -> L35
            int r5 = r5 % 2
            return r2
        L35:
            r5 = move-exception
            throw r5
        L37:
            io.split.android.client.storage.cipher.CipherProvider r0 = r4.mCipherProvider
            javax.crypto.Cipher r0 = r0.getEncryptionCipher()
            java.nio.charset.Charset r1 = io.split.android.client.storage.cipher.CBCCipher.CHARSET     // Catch: java.lang.Throwable -> L5b java.lang.Exception -> L5d
            byte[] r5 = r5.getBytes(r1)     // Catch: java.lang.Throwable -> L5b java.lang.Exception -> L5d
            byte[] r5 = r0.doFinal(r5)     // Catch: java.lang.Throwable -> L5b java.lang.Exception -> L5d
            io.split.android.client.storage.cipher.CipherProvider r1 = r4.mCipherProvider
            r1.release(r0)
            java.lang.String r5 = io.split.android.client.utils.Base64Util.encode(r5)
            int r0 = io.split.android.client.storage.cipher.CBCCipher.PlaceComponentResult
            int r0 = r0 + 117
            int r1 = r0 % 128
            io.split.android.client.storage.cipher.CBCCipher.BuiltInFictitiousFunctionClassFactory = r1
            int r0 = r0 % 2
            return r5
        L5b:
            r5 = move-exception
            goto L7c
        L5d:
            r5 = move-exception
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L5b
            r1.<init>()     // Catch: java.lang.Throwable -> L5b
            java.lang.String r3 = "Error encrypting data: "
            r1.append(r3)     // Catch: java.lang.Throwable -> L5b
            java.lang.String r5 = r5.getMessage()     // Catch: java.lang.Throwable -> L5b
            r1.append(r5)     // Catch: java.lang.Throwable -> L5b
            java.lang.String r5 = r1.toString()     // Catch: java.lang.Throwable -> L5b
            io.split.android.client.utils.logger.Logger.e(r5)     // Catch: java.lang.Throwable -> L5b
            io.split.android.client.storage.cipher.CipherProvider r5 = r4.mCipherProvider
            r5.release(r0)
            return r2
        L7c:
            io.split.android.client.storage.cipher.CipherProvider r1 = r4.mCipherProvider
            r1.release(r0)
            throw r5
        L82:
            r5 = move-exception
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: io.split.android.client.storage.cipher.CBCCipher.encrypt(java.lang.String):java.lang.String");
    }

    /* JADX WARN: Code restructure failed: missing block: B:12:0x001f, code lost:
    
        if ((r5 == null ? 'P' : '/') != 'P') goto L41;
     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x0025, code lost:
    
        if (r5 == null) goto L44;
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x0029, code lost:
    
        r5 = io.split.android.client.storage.cipher.CBCCipher.PlaceComponentResult + 67;
        io.split.android.client.storage.cipher.CBCCipher.BuiltInFictitiousFunctionClassFactory = r5 % 128;
        r5 = r5 % 2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x0030, code lost:
    
        return null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x0031, code lost:
    
        r5 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x0032, code lost:
    
        throw r5;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x0033, code lost:
    
        r0 = r4.mCipherProvider.getDecryptionCipher();
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x004d, code lost:
    
        return new java.lang.String(r0.doFinal(io.split.android.client.utils.Base64Util.bytesDecode(r5)), io.split.android.client.storage.cipher.CBCCipher.CHARSET);
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x004e, code lost:
    
        r5 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x0050, code lost:
    
        r5 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x0051, code lost:
    
        r1 = new java.lang.StringBuilder();
        r1.append("Error decrypting data: ");
        r1.append(r5.getMessage());
        io.split.android.client.utils.logger.Logger.e(r1.toString());
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x006e, code lost:
    
        return null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x006f, code lost:
    
        r4.mCipherProvider.release(r0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x0074, code lost:
    
        throw r5;
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x0075, code lost:
    
        r5 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x0076, code lost:
    
        throw r5;
     */
    @Override // io.split.android.client.storage.cipher.SplitCipher
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.String decrypt(java.lang.String r5) {
        /*
            r4 = this;
            int r0 = io.split.android.client.storage.cipher.CBCCipher.PlaceComponentResult
            int r0 = r0 + 115
            int r1 = r0 % 128
            io.split.android.client.storage.cipher.CBCCipher.BuiltInFictitiousFunctionClassFactory = r1
            int r0 = r0 % 2
            r1 = 67
            if (r0 != 0) goto L11
            r0 = 67
            goto L13
        L11:
            r0 = 60
        L13:
            r2 = 0
            if (r0 == r1) goto L22
            r0 = 80
            if (r5 != 0) goto L1d
            r3 = 80
            goto L1f
        L1d:
            r3 = 47
        L1f:
            if (r3 == r0) goto L27
            goto L33
        L22:
            r2.hashCode()     // Catch: java.lang.Throwable -> L77
            if (r5 != 0) goto L33
        L27:
            int r5 = io.split.android.client.storage.cipher.CBCCipher.PlaceComponentResult     // Catch: java.lang.Exception -> L31
            int r5 = r5 + r1
            int r0 = r5 % 128
            io.split.android.client.storage.cipher.CBCCipher.BuiltInFictitiousFunctionClassFactory = r0
            int r5 = r5 % 2
            return r2
        L31:
            r5 = move-exception
            throw r5
        L33:
            io.split.android.client.storage.cipher.CipherProvider r0 = r4.mCipherProvider     // Catch: java.lang.Exception -> L75
            javax.crypto.Cipher r0 = r0.getDecryptionCipher()     // Catch: java.lang.Exception -> L75
            byte[] r5 = io.split.android.client.utils.Base64Util.bytesDecode(r5)     // Catch: java.lang.Throwable -> L4e java.lang.Exception -> L50
            byte[] r5 = r0.doFinal(r5)     // Catch: java.lang.Throwable -> L4e java.lang.Exception -> L50
            java.lang.String r1 = new java.lang.String     // Catch: java.lang.Throwable -> L4e java.lang.Exception -> L50
            java.nio.charset.Charset r3 = io.split.android.client.storage.cipher.CBCCipher.CHARSET     // Catch: java.lang.Throwable -> L4e java.lang.Exception -> L50
            r1.<init>(r5, r3)     // Catch: java.lang.Throwable -> L4e java.lang.Exception -> L50
            io.split.android.client.storage.cipher.CipherProvider r5 = r4.mCipherProvider     // Catch: java.lang.Exception -> L75
            r5.release(r0)     // Catch: java.lang.Exception -> L75
            return r1
        L4e:
            r5 = move-exception
            goto L6f
        L50:
            r5 = move-exception
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L4e
            r1.<init>()     // Catch: java.lang.Throwable -> L4e
            java.lang.String r3 = "Error decrypting data: "
            r1.append(r3)     // Catch: java.lang.Throwable -> L4e
            java.lang.String r5 = r5.getMessage()     // Catch: java.lang.Throwable -> L4e
            r1.append(r5)     // Catch: java.lang.Throwable -> L4e
            java.lang.String r5 = r1.toString()     // Catch: java.lang.Throwable -> L4e
            io.split.android.client.utils.logger.Logger.e(r5)     // Catch: java.lang.Throwable -> L4e
            io.split.android.client.storage.cipher.CipherProvider r5 = r4.mCipherProvider
            r5.release(r0)
            return r2
        L6f:
            io.split.android.client.storage.cipher.CipherProvider r1 = r4.mCipherProvider
            r1.release(r0)
            throw r5
        L75:
            r5 = move-exception
            throw r5
        L77:
            r5 = move-exception
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: io.split.android.client.storage.cipher.CBCCipher.decrypt(java.lang.String):java.lang.String");
    }

    private static void a(int i, int[] iArr, Object[] objArr) {
        int i2;
        VerifyPinStateManager$executeRiskChallenge$2$1 verifyPinStateManager$executeRiskChallenge$2$1 = new VerifyPinStateManager$executeRiskChallenge$2$1();
        char[] cArr = new char[4];
        char[] cArr2 = new char[iArr.length * 2];
        int[] iArr2 = getAuthRequestContext;
        if (iArr2 != null) {
            int length = iArr2.length;
            int[] iArr3 = new int[length];
            try {
                int i3 = $11 + 87;
                $10 = i3 % 128;
                int i4 = i3 % 2;
                int i5 = 0;
                while (true) {
                    if (i5 >= length) {
                        break;
                    }
                    iArr3[i5] = (int) (iArr2[i5] ^ (-3152031022165484798L));
                    i5++;
                }
                iArr2 = iArr3;
            } catch (Exception e) {
                throw e;
            }
        }
        int length2 = iArr2.length;
        int[] iArr4 = new int[length2];
        int[] iArr5 = getAuthRequestContext;
        if (iArr5 != null) {
            int length3 = iArr5.length;
            int[] iArr6 = new int[length3];
            int i6 = 0;
            while (i6 < length3) {
                iArr6[i6] = (int) (iArr5[i6] ^ (-3152031022165484798L));
                i6++;
                length2 = length2;
            }
            iArr5 = iArr6;
            i2 = length2;
        } else {
            i2 = length2;
        }
        System.arraycopy(iArr5, 0, iArr4, 0, i2);
        verifyPinStateManager$executeRiskChallenge$2$1.BuiltInFictitiousFunctionClassFactory = 0;
        int i7 = $10 + 65;
        $11 = i7 % 128;
        int i8 = i7 % 2;
        while (true) {
            try {
                if (verifyPinStateManager$executeRiskChallenge$2$1.BuiltInFictitiousFunctionClassFactory >= iArr.length) {
                    objArr[0] = new String(cArr2, 0, i);
                    return;
                }
                cArr[0] = (char) (iArr[verifyPinStateManager$executeRiskChallenge$2$1.BuiltInFictitiousFunctionClassFactory] >> 16);
                cArr[1] = (char) iArr[verifyPinStateManager$executeRiskChallenge$2$1.BuiltInFictitiousFunctionClassFactory];
                cArr[2] = (char) (iArr[verifyPinStateManager$executeRiskChallenge$2$1.BuiltInFictitiousFunctionClassFactory + 1] >> 16);
                cArr[3] = (char) iArr[verifyPinStateManager$executeRiskChallenge$2$1.BuiltInFictitiousFunctionClassFactory + 1];
                verifyPinStateManager$executeRiskChallenge$2$1.getAuthRequestContext = (cArr[0] << 16) + cArr[1];
                verifyPinStateManager$executeRiskChallenge$2$1.PlaceComponentResult = (cArr[2] << 16) + cArr[3];
                VerifyPinStateManager$executeRiskChallenge$2$1.PlaceComponentResult(iArr4);
                int i9 = $11 + 69;
                $10 = i9 % 128;
                int i10 = i9 % 2;
                for (int i11 = 0; i11 < 16; i11++) {
                    verifyPinStateManager$executeRiskChallenge$2$1.getAuthRequestContext ^= iArr4[i11];
                    verifyPinStateManager$executeRiskChallenge$2$1.PlaceComponentResult = VerifyPinStateManager$executeRiskChallenge$2$1.getAuthRequestContext(verifyPinStateManager$executeRiskChallenge$2$1.getAuthRequestContext) ^ verifyPinStateManager$executeRiskChallenge$2$1.PlaceComponentResult;
                    int i12 = verifyPinStateManager$executeRiskChallenge$2$1.getAuthRequestContext;
                    verifyPinStateManager$executeRiskChallenge$2$1.getAuthRequestContext = verifyPinStateManager$executeRiskChallenge$2$1.PlaceComponentResult;
                    verifyPinStateManager$executeRiskChallenge$2$1.PlaceComponentResult = i12;
                }
                int i13 = verifyPinStateManager$executeRiskChallenge$2$1.getAuthRequestContext;
                verifyPinStateManager$executeRiskChallenge$2$1.getAuthRequestContext = verifyPinStateManager$executeRiskChallenge$2$1.PlaceComponentResult;
                verifyPinStateManager$executeRiskChallenge$2$1.PlaceComponentResult = i13;
                verifyPinStateManager$executeRiskChallenge$2$1.PlaceComponentResult ^= iArr4[16];
                verifyPinStateManager$executeRiskChallenge$2$1.getAuthRequestContext ^= iArr4[17];
                int i14 = verifyPinStateManager$executeRiskChallenge$2$1.getAuthRequestContext;
                int i15 = verifyPinStateManager$executeRiskChallenge$2$1.PlaceComponentResult;
                cArr[0] = (char) (verifyPinStateManager$executeRiskChallenge$2$1.getAuthRequestContext >>> 16);
                cArr[1] = (char) verifyPinStateManager$executeRiskChallenge$2$1.getAuthRequestContext;
                cArr[2] = (char) (verifyPinStateManager$executeRiskChallenge$2$1.PlaceComponentResult >>> 16);
                cArr[3] = (char) verifyPinStateManager$executeRiskChallenge$2$1.PlaceComponentResult;
                VerifyPinStateManager$executeRiskChallenge$2$1.PlaceComponentResult(iArr4);
                cArr2[verifyPinStateManager$executeRiskChallenge$2$1.BuiltInFictitiousFunctionClassFactory * 2] = cArr[0];
                cArr2[(verifyPinStateManager$executeRiskChallenge$2$1.BuiltInFictitiousFunctionClassFactory * 2) + 1] = cArr[1];
                cArr2[(verifyPinStateManager$executeRiskChallenge$2$1.BuiltInFictitiousFunctionClassFactory * 2) + 2] = cArr[2];
                cArr2[(verifyPinStateManager$executeRiskChallenge$2$1.BuiltInFictitiousFunctionClassFactory * 2) + 3] = cArr[3];
                verifyPinStateManager$executeRiskChallenge$2$1.BuiltInFictitiousFunctionClassFactory += 2;
            } catch (Exception e2) {
                throw e2;
            }
        }
    }
}
