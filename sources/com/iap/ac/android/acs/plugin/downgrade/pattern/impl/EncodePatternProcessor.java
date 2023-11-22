package com.iap.ac.android.acs.plugin.downgrade.pattern.impl;

import android.text.TextUtils;
import com.iap.ac.android.acs.plugin.downgrade.pattern.IPatternProcessor;
import com.iap.ac.android.acs.plugin.downgrade.utils.ApiDowngradeUtils;
import com.iap.ac.android.common.log.ACLog;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.regex.Pattern;
import o.VerifyPinStateManager$executeRiskChallenge$2$2;

/* loaded from: classes3.dex */
public class EncodePatternProcessor implements IPatternProcessor {
    private static int $10 = 0;
    private static int $11 = 1;
    private static int BuiltInFictitiousFunctionClassFactory = 1;
    public static final String FORMATTED_REGEX = "@encode(%s)";
    private static int KClassImpl$Data$declaredNonStaticMembers$2;
    public static final String TAG;
    public static final String UTF_8;
    private static char[] getAuthRequestContext;
    public static final Pattern mEncodePattern;

    static {
        PlaceComponentResult();
        Object[] objArr = new Object[1];
        a(new int[]{0, 5, 0, 0}, false, new byte[]{1, 1, 0, 1, 1}, objArr);
        UTF_8 = ((String) objArr[0]).intern();
        TAG = ApiDowngradeUtils.logTag("EncodePatternProcessor");
        mEncodePattern = Pattern.compile("(?<=@encode\\()[^)]+");
        int i = KClassImpl$Data$declaredNonStaticMembers$2 + 57;
        BuiltInFictitiousFunctionClassFactory = i % 128;
        if ((i % 2 == 0 ? '.' : '7') != '7') {
            Object[] objArr2 = null;
            int length = objArr2.length;
        }
    }

    static void PlaceComponentResult() {
        getAuthRequestContext = new char[]{35508, 35530, 35539, 35495, 35500};
    }

    private String encode(String str) {
        String intern;
        int i = KClassImpl$Data$declaredNonStaticMembers$2 + 35;
        BuiltInFictitiousFunctionClassFactory = i % 128;
        int i2 = i % 2;
        if (!(TextUtils.isEmpty(str))) {
            int i3 = KClassImpl$Data$declaredNonStaticMembers$2 + 57;
            BuiltInFictitiousFunctionClassFactory = i3 % 128;
            try {
                if (i3 % 2 == 0) {
                    Object[] objArr = new Object[1];
                    a(new int[]{0, 5, 0, 0}, false, new byte[]{1, 1, 0, 1, 1}, objArr);
                    intern = ((String) objArr[0]).intern();
                } else {
                    Object[] objArr2 = new Object[1];
                    a(new int[]{0, 5, 0, 0}, false, new byte[]{1, 1, 0, 1, 1}, objArr2);
                    intern = ((String) objArr2[0]).intern();
                }
                str = URLEncoder.encode(str, intern);
                return str;
            } catch (UnsupportedEncodingException e) {
                String str2 = TAG;
                StringBuilder sb = new StringBuilder();
                sb.append("EncodePatternProcessor#encode(), error: ");
                sb.append(e);
                ACLog.e(str2, sb.toString());
            }
        }
        return str;
    }

    private boolean hasNotEncoded(String str) {
        String decode;
        if (!(TextUtils.isEmpty(str))) {
            int i = KClassImpl$Data$declaredNonStaticMembers$2 + 97;
            BuiltInFictitiousFunctionClassFactory = i % 128;
            try {
                if (!(i % 2 == 0)) {
                    Object[] objArr = new Object[1];
                    a(new int[]{0, 5, 0, 0}, false, new byte[]{1, 1, 0, 1, 1}, objArr);
                    decode = URLDecoder.decode(str, ((String) objArr[0]).intern());
                } else {
                    Object[] objArr2 = new Object[1];
                    a(new int[]{0, 5, 0, 0}, false, new byte[]{1, 1, 0, 1, 1}, objArr2);
                    decode = URLDecoder.decode(str, ((String) objArr2[0]).intern());
                }
                boolean equals = TextUtils.equals(str, decode);
                int i2 = KClassImpl$Data$declaredNonStaticMembers$2 + 111;
                BuiltInFictitiousFunctionClassFactory = i2 % 128;
                if (i2 % 2 != 0) {
                    return equals;
                }
                int i3 = 56 / 0;
                return equals;
            } catch (UnsupportedEncodingException e) {
                String str2 = TAG;
                StringBuilder sb = new StringBuilder();
                sb.append("EncodePatternProcessor#isAlreadyEncoded(), error: ");
                sb.append(e);
                ACLog.e(str2, sb.toString());
            }
        }
        return true;
    }

    /* JADX WARN: Code restructure failed: missing block: B:16:0x002b, code lost:
    
        if ((r6 ? '7' : 'b') != 'b') goto L17;
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x002d, code lost:
    
        com.iap.ac.android.common.log.ACLog.w(com.iap.ac.android.acs.plugin.downgrade.pattern.impl.EncodePatternProcessor.TAG, "EncodePatternProcessor#process(), the str is empty");
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x0034, code lost:
    
        return r5;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x0037, code lost:
    
        r6 = com.iap.ac.android.acs.plugin.downgrade.pattern.impl.EncodePatternProcessor.mEncodePattern.matcher(r5);
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x003f, code lost:
    
        if (r6.find() == false) goto L46;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x0041, code lost:
    
        r0 = r6.group();
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x004a, code lost:
    
        if (hasNotEncoded(r0) == false) goto L26;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x004c, code lost:
    
        r1 = 5;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x004e, code lost:
    
        r1 = 'R';
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x0050, code lost:
    
        if (r1 == 5) goto L29;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x0052, code lost:
    
        r1 = r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x0054, code lost:
    
        r1 = com.iap.ac.android.acs.plugin.downgrade.pattern.impl.EncodePatternProcessor.KClassImpl$Data$declaredNonStaticMembers$2 + 65;
        com.iap.ac.android.acs.plugin.downgrade.pattern.impl.EncodePatternProcessor.BuiltInFictitiousFunctionClassFactory = r1 % 128;
        r1 = r1 % 2;
        r1 = encode(r0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x0062, code lost:
    
        r5 = r5.replace(java.lang.String.format(com.iap.ac.android.acs.plugin.downgrade.pattern.impl.EncodePatternProcessor.FORMATTED_REGEX, r0), r1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x0073, code lost:
    
        return r5;
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x0074, code lost:
    
        r5 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x0075, code lost:
    
        throw r5;
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x0076, code lost:
    
        r5 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x0077, code lost:
    
        throw r5;
     */
    /* JADX WARN: Code restructure failed: missing block: B:8:0x0019, code lost:
    
        if (android.text.TextUtils.isEmpty(r5) != false) goto L17;
     */
    @Override // com.iap.ac.android.acs.plugin.downgrade.pattern.IPatternProcessor
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.String process(java.lang.String r5, org.json.JSONObject r6) {
        /*
            r4 = this;
            int r6 = com.iap.ac.android.acs.plugin.downgrade.pattern.impl.EncodePatternProcessor.BuiltInFictitiousFunctionClassFactory
            int r6 = r6 + 69
            int r0 = r6 % 128
            com.iap.ac.android.acs.plugin.downgrade.pattern.impl.EncodePatternProcessor.KClassImpl$Data$declaredNonStaticMembers$2 = r0
            int r6 = r6 % 2
            r0 = 19
            if (r6 == 0) goto L11
            r6 = 19
            goto L13
        L11:
            r6 = 48
        L13:
            if (r6 == r0) goto L1c
            boolean r6 = android.text.TextUtils.isEmpty(r5)
            if (r6 == 0) goto L35
            goto L2d
        L1c:
            boolean r6 = android.text.TextUtils.isEmpty(r5)
            r0 = 0
            int r0 = r0.length     // Catch: java.lang.Throwable -> L78
            r0 = 98
            if (r6 == 0) goto L29
            r6 = 55
            goto L2b
        L29:
            r6 = 98
        L2b:
            if (r6 == r0) goto L35
        L2d:
            java.lang.String r6 = com.iap.ac.android.acs.plugin.downgrade.pattern.impl.EncodePatternProcessor.TAG
            java.lang.String r0 = "EncodePatternProcessor#process(), the str is empty"
            com.iap.ac.android.common.log.ACLog.w(r6, r0)
            return r5
        L35:
            java.util.regex.Pattern r6 = com.iap.ac.android.acs.plugin.downgrade.pattern.impl.EncodePatternProcessor.mEncodePattern     // Catch: java.lang.Exception -> L76
            java.util.regex.Matcher r6 = r6.matcher(r5)     // Catch: java.lang.Exception -> L74
        L3b:
            boolean r0 = r6.find()     // Catch: java.lang.Exception -> L74
            if (r0 == 0) goto L73
            java.lang.String r0 = r6.group()
            boolean r1 = r4.hasNotEncoded(r0)
            r2 = 5
            if (r1 == 0) goto L4e
            r1 = 5
            goto L50
        L4e:
            r1 = 82
        L50:
            if (r1 == r2) goto L54
            r1 = r0
            goto L62
        L54:
            int r1 = com.iap.ac.android.acs.plugin.downgrade.pattern.impl.EncodePatternProcessor.KClassImpl$Data$declaredNonStaticMembers$2
            int r1 = r1 + 65
            int r2 = r1 % 128
            com.iap.ac.android.acs.plugin.downgrade.pattern.impl.EncodePatternProcessor.BuiltInFictitiousFunctionClassFactory = r2
            int r1 = r1 % 2
            java.lang.String r1 = r4.encode(r0)
        L62:
            r2 = 1
            java.lang.Object[] r2 = new java.lang.Object[r2]
            r3 = 0
            r2[r3] = r0
            java.lang.String r0 = "@encode(%s)"
            java.lang.String r0 = java.lang.String.format(r0, r2)
            java.lang.String r5 = r5.replace(r0, r1)
            goto L3b
        L73:
            return r5
        L74:
            r5 = move-exception
            throw r5
        L76:
            r5 = move-exception
            throw r5
        L78:
            r5 = move-exception
            goto L7b
        L7a:
            throw r5
        L7b:
            goto L7a
        */
        throw new UnsupportedOperationException("Method not decompiled: com.iap.ac.android.acs.plugin.downgrade.pattern.impl.EncodePatternProcessor.process(java.lang.String, org.json.JSONObject):java.lang.String");
    }

    private static void a(int[] iArr, boolean z, byte[] bArr, Object[] objArr) {
        char[] cArr;
        VerifyPinStateManager$executeRiskChallenge$2$2 verifyPinStateManager$executeRiskChallenge$2$2 = new VerifyPinStateManager$executeRiskChallenge$2$2();
        int i = iArr[0];
        int i2 = iArr[1];
        int i3 = iArr[2];
        int i4 = iArr[3];
        try {
            char[] cArr2 = getAuthRequestContext;
            if (cArr2 != null) {
                int length = cArr2.length;
                char[] cArr3 = new char[length];
                int i5 = 0;
                while (true) {
                    if (!(i5 < length)) {
                        break;
                    }
                    cArr3[i5] = (char) (cArr2[i5] ^ 5097613533456403102L);
                    i5++;
                }
                cArr2 = cArr3;
            }
            char[] cArr4 = new char[i2];
            System.arraycopy(cArr2, i, cArr4, 0, i2);
            if (bArr != null) {
                int i6 = $10 + 27;
                $11 = i6 % 128;
                if (!(i6 % 2 == 0)) {
                    cArr = new char[i2];
                    verifyPinStateManager$executeRiskChallenge$2$2.BuiltInFictitiousFunctionClassFactory = 0;
                } else {
                    cArr = new char[i2];
                    verifyPinStateManager$executeRiskChallenge$2$2.BuiltInFictitiousFunctionClassFactory = 1;
                }
                char c = 0;
                while (true) {
                    if (verifyPinStateManager$executeRiskChallenge$2$2.BuiltInFictitiousFunctionClassFactory >= i2) {
                        break;
                    }
                    if (bArr[verifyPinStateManager$executeRiskChallenge$2$2.BuiltInFictitiousFunctionClassFactory] == 1) {
                        cArr[verifyPinStateManager$executeRiskChallenge$2$2.BuiltInFictitiousFunctionClassFactory] = (char) (((cArr4[verifyPinStateManager$executeRiskChallenge$2$2.BuiltInFictitiousFunctionClassFactory] * 2) + 1) - c);
                    } else {
                        cArr[verifyPinStateManager$executeRiskChallenge$2$2.BuiltInFictitiousFunctionClassFactory] = (char) ((cArr4[verifyPinStateManager$executeRiskChallenge$2$2.BuiltInFictitiousFunctionClassFactory] * 2) - c);
                    }
                    c = cArr[verifyPinStateManager$executeRiskChallenge$2$2.BuiltInFictitiousFunctionClassFactory];
                    verifyPinStateManager$executeRiskChallenge$2$2.BuiltInFictitiousFunctionClassFactory++;
                }
                cArr4 = cArr;
            }
            if (i4 > 0) {
                int i7 = $11 + 67;
                $10 = i7 % 128;
                if (i7 % 2 != 0) {
                    char[] cArr5 = new char[i2];
                    System.arraycopy(cArr4, 1, cArr5, 1, i2);
                    System.arraycopy(cArr5, 1, cArr4, i2 << i4, i4);
                    System.arraycopy(cArr5, i4, cArr4, 1, i2 >> i4);
                } else {
                    char[] cArr6 = new char[i2];
                    System.arraycopy(cArr4, 0, cArr6, 0, i2);
                    int i8 = i2 - i4;
                    System.arraycopy(cArr6, 0, cArr4, i8, i4);
                    System.arraycopy(cArr6, i4, cArr4, 0, i8);
                }
            }
            if (z) {
                char[] cArr7 = new char[i2];
                verifyPinStateManager$executeRiskChallenge$2$2.BuiltInFictitiousFunctionClassFactory = 0;
                while (verifyPinStateManager$executeRiskChallenge$2$2.BuiltInFictitiousFunctionClassFactory < i2) {
                    cArr7[verifyPinStateManager$executeRiskChallenge$2$2.BuiltInFictitiousFunctionClassFactory] = cArr4[(i2 - verifyPinStateManager$executeRiskChallenge$2$2.BuiltInFictitiousFunctionClassFactory) - 1];
                    verifyPinStateManager$executeRiskChallenge$2$2.BuiltInFictitiousFunctionClassFactory++;
                }
                cArr4 = cArr7;
            }
            if (i3 > 0) {
                int i9 = $11 + 53;
                $10 = i9 % 128;
                if (i9 % 2 != 0) {
                    verifyPinStateManager$executeRiskChallenge$2$2.BuiltInFictitiousFunctionClassFactory = 1;
                } else {
                    verifyPinStateManager$executeRiskChallenge$2$2.BuiltInFictitiousFunctionClassFactory = 0;
                }
                while (verifyPinStateManager$executeRiskChallenge$2$2.BuiltInFictitiousFunctionClassFactory < i2) {
                    int i10 = $10 + 123;
                    $11 = i10 % 128;
                    int i11 = i10 % 2;
                    cArr4[verifyPinStateManager$executeRiskChallenge$2$2.BuiltInFictitiousFunctionClassFactory] = (char) (cArr4[verifyPinStateManager$executeRiskChallenge$2$2.BuiltInFictitiousFunctionClassFactory] - iArr[2]);
                    verifyPinStateManager$executeRiskChallenge$2$2.BuiltInFictitiousFunctionClassFactory++;
                }
            }
            String str = new String(cArr4);
            int i12 = $11 + 13;
            $10 = i12 % 128;
            int i13 = i12 % 2;
            objArr[0] = str;
        } catch (Exception e) {
            throw e;
        }
    }
}
