package com.apiguard3.internal;

import com.alibaba.wireless.security.SecExceptionCode;
import java.io.IOException;
import java.io.InputStream;
import kotlin.text.Typography;

/* loaded from: classes3.dex */
public class AGState {
    private static int AnalysesEntry = 0;
    public static final byte[] BHT = null;
    public static byte[] BuildConfig = null;
    public static final int Config = 0;
    private static int FraudScore = 0;
    private static byte[] SConfig = null;
    private static int ScoredEntry = 0;
    private static int am = 1;
    private static int ce;
    private static Object clearCallback;
    private static long getVersion;
    private static Object pushMaxPayload;
    public static byte[] pushMinPayload;
    private static int send;

    /* JADX WARN: Removed duplicated region for block: B:20:0x0064  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x006a  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:22:0x006a -> B:23:0x0084). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static java.lang.String $$c(short r9, short r10, int r11) {
        /*
            int r0 = com.apiguard3.internal.AGState.ce
            r1 = r0 ^ 83
            r2 = r0 & 83
            r3 = 1
            int r2 = r2 << r3
            int r1 = r1 + r2
            int r1 = r1 % 128
            com.apiguard3.internal.AGState.am = r1
            r1 = r11 | 41
            int r1 = r1 << r3
            r11 = r11 ^ 41
            int r1 = r1 - r11
            r11 = r10 & 84
            r10 = r10 | 84
            int r11 = r11 + r10
            int r11 = r11 + (-79)
            int r11 = r11 - r3
            byte[] r10 = com.apiguard3.internal.AGState.BHT
            int r9 = -r9
            r2 = r9 | 36
            int r2 = r2 << r3
            r9 = r9 ^ 36
            int r2 = r2 - r9
            byte[] r9 = new byte[r2]
            r4 = 0
            if (r10 != 0) goto L2b
            r5 = 1
            goto L2c
        L2b:
            r5 = 0
        L2c:
            if (r5 == 0) goto L4c
            r5 = r0 | 15
            int r5 = r5 << r3
            r0 = r0 ^ 15
            int r5 = r5 - r0
            int r0 = r5 % 128
            com.apiguard3.internal.AGState.am = r0
            int r5 = r5 % 2
            r0 = 33
            if (r5 != 0) goto L41
            r5 = 26
            goto L43
        L41:
            r5 = 33
        L43:
            if (r5 != r0) goto L48
            r0 = r11
            r5 = 0
            goto L84
        L48:
            r9 = 0
            throw r9     // Catch: java.lang.Throwable -> L4a
        L4a:
            r9 = move-exception
            throw r9
        L4c:
            r0 = 0
        L4d:
            r5 = r11 ^ (-66)
            r11 = r11 & (-66)
            int r11 = r11 << r3
            int r5 = r5 + r11
            r11 = r5 | 67
            int r11 = r11 << r3
            r5 = r5 ^ 67
            int r11 = r11 - r5
            byte r5 = (byte) r1
            r9[r0] = r5
            r5 = r2 | (-1)
            int r5 = r5 << r3
            r6 = r2 ^ (-1)
            int r5 = r5 - r6
            if (r0 != r5) goto L6a
            java.lang.String r10 = new java.lang.String
            r10.<init>(r9, r4)
            return r10
        L6a:
            int r0 = r0 + (-106)
            int r0 = r0 - r3
            r5 = r0 ^ 108(0x6c, float:1.51E-43)
            r0 = r0 & 108(0x6c, float:1.51E-43)
            int r0 = r0 << r3
            int r5 = r5 + r0
            r0 = r10[r11]
            int r6 = com.apiguard3.internal.AGState.ce
            r7 = r6 & 41
            r6 = r6 | 41
            int r7 = r7 + r6
            int r7 = r7 % 128
            com.apiguard3.internal.AGState.am = r7
            r8 = r0
            r0 = r11
            r11 = r1
            r1 = r8
        L84:
            r1 = r1 ^ (-1)
            int r11 = r11 - r1
            int r11 = r11 - r3
            int r1 = r11 + (-3)
            int r11 = com.apiguard3.internal.AGState.ce
            r6 = r11 ^ 75
            r11 = r11 & 75
            int r11 = r11 << r3
            int r6 = r6 + r11
            int r6 = r6 % 128
            com.apiguard3.internal.AGState.am = r6
            r11 = r0
            r0 = r5
            goto L4d
        */
        throw new UnsupportedOperationException("Method not decompiled: com.apiguard3.internal.AGState.$$c(short, short, int):java.lang.String");
    }

    public static int AGState(int i) {
        int i2 = (am + 86) - 1;
        ce = i2 % 128;
        if ((i2 % 2 != 0 ? 'D' : '9') != '9') {
            throw new NullPointerException();
        }
        Object obj = pushMaxPayload;
        try {
            Object[] objArr = {Integer.valueOf(i)};
            byte b = BHT[49];
            int intValue = ((Integer) Class.forName($$c(b, (short) (b | 322), r8[1]), true, (ClassLoader) clearCallback).getMethod($$c(r8[753], (short) 714, r8[8]), Integer.TYPE).invoke(obj, objArr)).intValue();
            int i3 = ce;
            am = ((i3 ^ 43) + ((i3 & 43) << 1)) % 128;
            return intValue;
        } catch (Throwable th) {
            Throwable cause = th.getCause();
            if (cause != null) {
                throw cause;
            }
            throw th;
        }
    }

    static void init$0() {
        int i = ce;
        am = ((i & 121) + (i | 121)) % 128;
        byte[] bArr = new byte[SecExceptionCode.SEC_ERROE_OPENSDK_INVALID_PARAM];
        System.arraycopy("1:\fOú\u0018îÐ>\tÂ\u00176ô\u0003\u0002\u0010ö\u0002è(\u0005\b\u0002â$\u0001öÿ\u000f\u0012ü\u00011ï\u0014õú\u0018îÐAø\u0010üÊ()ý\u0004ô\u000b\u0015\u0000\u0003ö\f\tÐ2\u0003ÿ\u0000ý\u0001\u0016ø\t\u0002\u0010ù\u0011\u0000ýþÍKöÿ\u0015º+\u0016ÿ\u0015°,\u001bÿ\u0015\u0005\u0000öñ ø\u0001ú\u0018îÐCþ\tÂ\u0017:þôà6ô\u0003\u0002\u0010\u0010ù\u0011\u0000ýþÍKöÿ\u0015º+\u0016ÿ\u0015Ï/\u0002û\u0006\u0001\u0011\u0000ò\u0016ø\t\u0002\u0010ù\u0011\u0000ýþÍD\u0007¾\u00176÷\u0006ûÃ5ò\u0010\u0004ù\t\u0002ú\u0018îÐ>\tÂ\u0017:þôß4\u0003ò\u001bÓ(\u0005\b\u0002â$\u0001öÿ\u000f\u0000\u000e\rö\u0005ÆH\tý\u0004ô\u000bÄ\u001e(â\u001b\u000b\u0005\u0006\nÎ$\u0016Î,ø\u0015\u0003Ü&õ\u0006\u0004\u0010\u000f\u0001Å5\u0012ü\u0001\u0011ï\u0014õÒÿ=\b\tô\u0010ÿö\u000eÆ\u0015\t\u000f$ð\u0016ôÂEöÿ\u0006å2ú\u0003\u0010\u0001\u0012Ü%ø\u0004\u0001\u0012Û&\u0002üì%ö\u0011\u0003ä\u0018\u0007û\r\t\u0002\u0001\u0012Õ&\u0006ü\u0011Ô(\f\u000f\u0001Ä6\u0012ü\u0001\u0011ï\u0014õÒþú\u000eô\u0001\u0012Ò!\u0005\b\u0000â(\föÿ\u0006\u000f\u0001Ä6\u0012ü\u0001\u0011ï\u0014õÒþ>\b\tô\u0010ÿö\u000eÅKî\u000e\fóí\u001aÁ\u0003\u0000\u000e\rö\u0005ÆH\tý\u0004ô\u000bÄ\u0019$\u0016Ñ&\u0006ü\u000fø\u0004ý\u0007\u0001\u0005\b\u0000\u0000\u000e\rö\u0005ÆH\tý\u0004ô\u000bÄ\u0017\"\u0015õâ$\u0016Î,ø\u0015\u0003Ü&õ\u0006\u0004\u0010\u0001\u0012Ò/ø\u0004á!\u0005\b\u0000â(\f\tøøî\nì\u000bI\u0004´Iþ\u000e\u0003ù\u0002\u0005\u000b\u000b°Oü\u0004\u0011¸î\tí\u000bî\u0007ï\u000bî\u000bë\u000bú\u0018îÐAø\u0010üÊ\u0018,ø\u0015\u0003Ü&õ\u0006\u0004\u0010\u0010ù\u0011\u0000ýþÍ6\u0012\u0003Á\u00162\u0003Ú(\u0006ö\u0002\u000e\n\u0001\u0012Ô6ÿô\u0010ÿö\u000eê$þ\u0006ò\t\u0001â(\fö\u0001\u0014þ\u0006\nú\u0018îÐ>\tÂ\u0019 \u0016ðë(\u0005\b\u0002â$\u0001öÿ\u000f\u0006õ\u0006ã$\u0016ú\u0018îÐ>\tÂ\u0017:þôß4\u0003ò\u001bÙ)\u0002ÿ\b\u0002â$\u0001öÿ\u000f\u0010ù\u0011\u0000ýþÍD\u0007¾\u001a,\u000bö\f\u0000\u0002\u0002û\f\tî\u000e\fó\u0011û\u0001\n\u0001\u0012Ò,ø\u0015\u0003Ü&õ\u0006\u0004\u00107\u000f\u0001Å5\u0012ü\u0001\u0011ï\u0014õÒÿ=\b\tô\u0010ÿö\u000eÆ6Î\u000f\u0001Å5\u0012ü\u0001\u0011ï\u0014õÒÿ=\b\tô\u0010ÿö\u000eÆJî\u000e\fóí\u001aÁ\u00038\u0000\u0016ðÑ8\u0000\u0016ðÑ\u0004\nü\u0012ô\u0001\u0012Õ\u0001ô\n\u0017í\b\t\u0001\u0012â\u0018ü\u0014ö\u0002è(\b\u0004ð\u0010ø\u0005\u0001\u0012Ò!\u0012\u0006Ý%ø\u0004ö\u0016ø\u0010òê ü\u0013ò\u0014\nÚ\u0014\u0016÷à*ü\u000bû\f\t\u0002\f\u0006\u0007õ\u0001\u0012Ü\u0017\u001aô\u0007\u000bûÚ1ò\u0019õ\büß!\u0005\b\u0000ñ\u0019\u0014îú\u0018îÐ>\tÂIü\u0006÷\b\f\u0001\u0012ß%\u0000\u0004ø\u0010\u0005\b\u0001\u0012Ð$\u0014ÿ\u0000\f\u0002ôî\u0014\u0016÷\u0010ù\u0011\u0000ýþÍ6\u0012\u0003Á\u0016%\u0014ø\u0010ö\u000e\bÞ\u0017\röÿ\u0006î\u000e\fóí\u001aú\u0018îÐ>\tÂ\u001b&\u0006üí)\u0002ÿ\b\u0002â$\u0001öÿ\u000f7\u000f\u0001Å5\u0012ü\u0001\u0011ï\u0014õÒÿ=\b\tô\u0010ÿö\u000eÆ5Ï\u0001\u0010ì\u001eú\u000eôú\u0018îÐ>\tÂ\u001e\tù6î\u0005\u000e\u0007ø\t\u0002\u0010ù\u0011\u0000ýþÍIô\u0016ÿ½)\u0014\u0016ÿä\"ø\u0006\nô\u0016÷ç \r\u0004\u0001\u0012Ø(þ\u000eøû\u000eØ2\u0003ÿ\u0000ý\u0001\u0016ø\t\u0002ú\u0018îÐ>\tÂ\u001b&\u0006üî\u0006ð\u000b\u0015\u0000\u0003ö\f\tã\u0018\u0007ûë\u001f\u0006\u0003\u0000\rú\u0018îÐ>\tÂ\u001b&\u0006üâ$\u0011ó\u0012ú\n\u0007þ\u0006þÖ:þôß4\u0003ò\u001b\u0006õ\u0006â,ø\u0015\u0003þò\u0012ö\u0016ø\u0010òê ü\u0013ò\u0014\nÎ(\fö\u0001\u0014þ\u0006úÿ\u0011ú\u0018îÐ>\tÂ\u001e(\u0005\b\u0002â$\u0001öÿ\u000f".getBytes("ISO-8859-1"), 0, bArr, 0, SecExceptionCode.SEC_ERROE_OPENSDK_INVALID_PARAM);
        BHT = bArr;
        Config = 230;
        int i2 = am;
        int i3 = (i2 & 95) + (i2 | 95);
        ce = i3 % 128;
        if ((i3 % 2 != 0 ? '6' : ';') == ';') {
            return;
        }
        throw new ArithmeticException();
    }

    public static int valueOf(Object obj) {
        int i = ce;
        int i2 = (i & 85) + (i | 85);
        int i3 = i2 % 128;
        am = i3;
        if ((i2 % 2 == 0 ? '9' : Typography.greater) != '>') {
            throw new ArithmeticException();
        }
        Object obj2 = pushMaxPayload;
        int i4 = ((i3 + 60) - 1) % 128;
        ce = i4;
        am = ((i4 ^ 3) + ((i4 & 3) << 1)) % 128;
        try {
            Object[] objArr = {obj};
            byte[] bArr = BHT;
            byte b = bArr[49];
            return ((Integer) Class.forName($$c(b, (short) ((b ^ 322) | (b & 322)), bArr[1]), true, (ClassLoader) clearCallback).getMethod($$c((byte) (-bArr[565]), (short) 855, 77), Object.class).invoke(obj2, objArr)).intValue();
        } catch (Throwable th) {
            Throwable cause = th.getCause();
            if (cause != null) {
                throw cause;
            }
            throw th;
        }
    }

    public static Object values(int i, int i2, char c) {
        int i3 = ce;
        am = (i3 + 49) % 128;
        Object obj = pushMaxPayload;
        am = ((i3 + 70) - 1) % 128;
        try {
            Object[] objArr = {Integer.valueOf(i), Integer.valueOf(i2), Character.valueOf(c)};
            byte b = BHT[49];
            Object invoke = Class.forName($$c(b, (short) (b | 322), r7[1]), true, (ClassLoader) clearCallback).getMethod($$c(r7[207], (short) 612, 77), Integer.TYPE, Integer.TYPE, Character.TYPE).invoke(obj, objArr);
            int i4 = am + 101;
            ce = i4 % 128;
            if (i4 % 2 == 0) {
                return invoke;
            }
            throw null;
        } catch (Throwable th) {
            Throwable cause = th.getCause();
            if (cause != null) {
                throw cause;
            }
            throw th;
        }
    }

    private AGState() {
    }

    /* JADX WARN: Can't wrap try/catch for region: R(40:(2:1025|1026)|(1:13)(1:1024)|(38:1020|1021|(0)|17|(0)(0)|(0)|21|22|(0)(0)|25|(0)|(0)(0)|41|(0)(0)|(0)|62|63|64|65|66|67|(0)(0)|70|(0)(0)|73|74|(0)(0)|77|(0)(0)|80|(0)(0)|83|(0)(0)|86|87|(0)|969|970)|15|(0)|17|(0)(0)|(0)|21|22|(0)(0)|25|(0)|(0)(0)|41|(0)(0)|(0)|62|63|64|65|66|67|(0)(0)|70|(0)(0)|73|74|(0)(0)|77|(0)(0)|80|(0)(0)|83|(0)(0)|86|87|(0)|969|970) */
    /* JADX WARN: Code restructure failed: missing block: B:119:0x040f, code lost:
    
        if (((java.lang.Boolean) java.lang.Class.forName($$c(r25[r15], r14, r25[r6])).getMethod($$c((byte) (-com.apiguard3.internal.AGState.BHT[285(0x11d, float:4.0E-43)]), 909, r25[1]), null).invoke(r12, null)).booleanValue() != false) goto L139;
     */
    /* JADX WARN: Code restructure failed: missing block: B:12:0x0083, code lost:
    
        if (r6 != null) goto L18;
     */
    /* JADX WARN: Code restructure failed: missing block: B:676:0x1675, code lost:
    
        throw new java.lang.ArithmeticException();
     */
    /* JADX WARN: Code restructure failed: missing block: B:677:0x1676, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:678:0x1677, code lost:
    
        r6 = r0;
        r18 = r18;
     */
    /* JADX WARN: Removed duplicated region for block: B:101:0x03b9  */
    /* JADX WARN: Removed duplicated region for block: B:1026:0x1848 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:102:0x03bc  */
    /* JADX WARN: Removed duplicated region for block: B:1037:0x1832 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:1039:0x1624 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:1040:0x166c A[EDGE_INSN: B:1040:0x166c->B:674:0x166c BREAK  A[LOOP:2: B:305:0x0938->B:646:0x15f5], SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:1043:0x13ae A[EDGE_INSN: B:1043:0x13ae->B:581:0x13ae BREAK  A[LOOP:4: B:576:0x13a3->B:681:0x1691], SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:105:0x03c2  */
    /* JADX WARN: Removed duplicated region for block: B:106:0x03c4  */
    /* JADX WARN: Removed duplicated region for block: B:110:0x03cd  */
    /* JADX WARN: Removed duplicated region for block: B:114:0x03d5  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x00b5  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x00b7  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x00fe  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0100  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0129  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x012c  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x0136  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x018a  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x018d  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x0195  */
    /* JADX WARN: Removed duplicated region for block: B:577:0x13a5  */
    /* JADX WARN: Removed duplicated region for block: B:578:0x13a8  */
    /* JADX WARN: Removed duplicated region for block: B:584:0x13c3 A[Catch: all -> 0x176a, TRY_ENTER, TRY_LEAVE, TryCatch #30 {all -> 0x176a, blocks: (B:526:0x109d, B:532:0x1104, B:571:0x1281, B:573:0x130f, B:575:0x131a, B:581:0x13ae, B:584:0x13c3), top: B:898:0x109d }] */
    /* JADX WARN: Removed duplicated region for block: B:60:0x01af A[Catch: Exception -> 0x190e, TRY_ENTER, TRY_LEAVE, TryCatch #11 {Exception -> 0x190e, blocks: (B:3:0x001b, B:7:0x003e, B:45:0x0145, B:827:0x1905, B:829:0x190c, B:830:0x190d, B:55:0x01a6, B:56:0x01ab, B:67:0x0229, B:69:0x0241, B:75:0x0289, B:77:0x028f, B:78:0x0290, B:68:0x0236, B:80:0x02c8, B:82:0x0353, B:86:0x0389, B:90:0x0396, B:95:0x03aa, B:99:0x03b3, B:107:0x03c5, B:112:0x03d1, B:796:0x183c, B:809:0x18cf, B:797:0x1848, B:803:0x189e, B:805:0x18a4, B:806:0x18a5, B:791:0x1834, B:807:0x18a6, B:812:0x18e7, B:814:0x18ee, B:815:0x18ef, B:60:0x01af, B:817:0x18f1, B:819:0x18f8, B:820:0x18f9, B:822:0x18fb, B:824:0x1902, B:825:0x1903, B:71:0x024f, B:799:0x1869, B:800:0x189b, B:79:0x0291, B:62:0x01f8, B:61:0x01bf, B:46:0x0166), top: B:863:0x001b, inners: #50, #60, #74, #75, #78, #82 }] */
    /* JADX WARN: Removed duplicated region for block: B:618:0x1483  */
    /* JADX WARN: Removed duplicated region for block: B:630:0x14ce  */
    /* JADX WARN: Removed duplicated region for block: B:631:0x14d1  */
    /* JADX WARN: Removed duplicated region for block: B:634:0x14d7  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x021b A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:679:0x167a  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x0229 A[Catch: Exception -> 0x190e, TRY_ENTER, TryCatch #11 {Exception -> 0x190e, blocks: (B:3:0x001b, B:7:0x003e, B:45:0x0145, B:827:0x1905, B:829:0x190c, B:830:0x190d, B:55:0x01a6, B:56:0x01ab, B:67:0x0229, B:69:0x0241, B:75:0x0289, B:77:0x028f, B:78:0x0290, B:68:0x0236, B:80:0x02c8, B:82:0x0353, B:86:0x0389, B:90:0x0396, B:95:0x03aa, B:99:0x03b3, B:107:0x03c5, B:112:0x03d1, B:796:0x183c, B:809:0x18cf, B:797:0x1848, B:803:0x189e, B:805:0x18a4, B:806:0x18a5, B:791:0x1834, B:807:0x18a6, B:812:0x18e7, B:814:0x18ee, B:815:0x18ef, B:60:0x01af, B:817:0x18f1, B:819:0x18f8, B:820:0x18f9, B:822:0x18fb, B:824:0x1902, B:825:0x1903, B:71:0x024f, B:799:0x1869, B:800:0x189b, B:79:0x0291, B:62:0x01f8, B:61:0x01bf, B:46:0x0166), top: B:863:0x001b, inners: #50, #60, #74, #75, #78, #82 }] */
    /* JADX WARN: Removed duplicated region for block: B:68:0x0236 A[Catch: Exception -> 0x190e, TryCatch #11 {Exception -> 0x190e, blocks: (B:3:0x001b, B:7:0x003e, B:45:0x0145, B:827:0x1905, B:829:0x190c, B:830:0x190d, B:55:0x01a6, B:56:0x01ab, B:67:0x0229, B:69:0x0241, B:75:0x0289, B:77:0x028f, B:78:0x0290, B:68:0x0236, B:80:0x02c8, B:82:0x0353, B:86:0x0389, B:90:0x0396, B:95:0x03aa, B:99:0x03b3, B:107:0x03c5, B:112:0x03d1, B:796:0x183c, B:809:0x18cf, B:797:0x1848, B:803:0x189e, B:805:0x18a4, B:806:0x18a5, B:791:0x1834, B:807:0x18a6, B:812:0x18e7, B:814:0x18ee, B:815:0x18ef, B:60:0x01af, B:817:0x18f1, B:819:0x18f8, B:820:0x18f9, B:822:0x18fb, B:824:0x1902, B:825:0x1903, B:71:0x024f, B:799:0x1869, B:800:0x189b, B:79:0x0291, B:62:0x01f8, B:61:0x01bf, B:46:0x0166), top: B:863:0x001b, inners: #50, #60, #74, #75, #78, #82 }] */
    /* JADX WARN: Removed duplicated region for block: B:786:0x182b  */
    /* JADX WARN: Removed duplicated region for block: B:787:0x182d  */
    /* JADX WARN: Removed duplicated region for block: B:791:0x1834 A[Catch: Exception -> 0x190e, TRY_ENTER, TryCatch #11 {Exception -> 0x190e, blocks: (B:3:0x001b, B:7:0x003e, B:45:0x0145, B:827:0x1905, B:829:0x190c, B:830:0x190d, B:55:0x01a6, B:56:0x01ab, B:67:0x0229, B:69:0x0241, B:75:0x0289, B:77:0x028f, B:78:0x0290, B:68:0x0236, B:80:0x02c8, B:82:0x0353, B:86:0x0389, B:90:0x0396, B:95:0x03aa, B:99:0x03b3, B:107:0x03c5, B:112:0x03d1, B:796:0x183c, B:809:0x18cf, B:797:0x1848, B:803:0x189e, B:805:0x18a4, B:806:0x18a5, B:791:0x1834, B:807:0x18a6, B:812:0x18e7, B:814:0x18ee, B:815:0x18ef, B:60:0x01af, B:817:0x18f1, B:819:0x18f8, B:820:0x18f9, B:822:0x18fb, B:824:0x1902, B:825:0x1903, B:71:0x024f, B:799:0x1869, B:800:0x189b, B:79:0x0291, B:62:0x01f8, B:61:0x01bf, B:46:0x0166), top: B:863:0x001b, inners: #50, #60, #74, #75, #78, #82 }] */
    /* JADX WARN: Removed duplicated region for block: B:796:0x183c A[Catch: Exception -> 0x190e, TryCatch #11 {Exception -> 0x190e, blocks: (B:3:0x001b, B:7:0x003e, B:45:0x0145, B:827:0x1905, B:829:0x190c, B:830:0x190d, B:55:0x01a6, B:56:0x01ab, B:67:0x0229, B:69:0x0241, B:75:0x0289, B:77:0x028f, B:78:0x0290, B:68:0x0236, B:80:0x02c8, B:82:0x0353, B:86:0x0389, B:90:0x0396, B:95:0x03aa, B:99:0x03b3, B:107:0x03c5, B:112:0x03d1, B:796:0x183c, B:809:0x18cf, B:797:0x1848, B:803:0x189e, B:805:0x18a4, B:806:0x18a5, B:791:0x1834, B:807:0x18a6, B:812:0x18e7, B:814:0x18ee, B:815:0x18ef, B:60:0x01af, B:817:0x18f1, B:819:0x18f8, B:820:0x18f9, B:822:0x18fb, B:824:0x1902, B:825:0x1903, B:71:0x024f, B:799:0x1869, B:800:0x189b, B:79:0x0291, B:62:0x01f8, B:61:0x01bf, B:46:0x0166), top: B:863:0x001b, inners: #50, #60, #74, #75, #78, #82 }] */
    /* JADX WARN: Removed duplicated region for block: B:808:0x18b5  */
    /* JADX WARN: Removed duplicated region for block: B:84:0x0382  */
    /* JADX WARN: Removed duplicated region for block: B:853:0x00ba A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:85:0x0386  */
    /* JADX WARN: Removed duplicated region for block: B:877:0x00de A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:88:0x038f  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x0393  */
    /* JADX WARN: Removed duplicated region for block: B:926:0x13d8 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:93:0x039c  */
    /* JADX WARN: Removed duplicated region for block: B:94:0x03a9  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x03b0  */
    /* JADX WARN: Removed duplicated region for block: B:989:0x0103 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:98:0x03b2  */
    /* JADX WARN: Type inference failed for: r18v10 */
    /* JADX WARN: Type inference failed for: r18v14 */
    /* JADX WARN: Type inference failed for: r18v19 */
    /* JADX WARN: Type inference failed for: r18v2 */
    /* JADX WARN: Type inference failed for: r18v23 */
    /* JADX WARN: Type inference failed for: r18v24 */
    /* JADX WARN: Type inference failed for: r18v28 */
    /* JADX WARN: Type inference failed for: r18v29 */
    /* JADX WARN: Type inference failed for: r18v36 */
    /* JADX WARN: Type inference failed for: r18v37 */
    static {
        /*
            Method dump skipped, instructions count: 6424
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.apiguard3.internal.AGState.<clinit>():void");
    }

    private static InputStream valueOf(InputStream inputStream, int i, short s) throws IOException {
        int i2;
        int i3 = (ce + 45) % 128;
        am = i3;
        ce = ((i3 ^ 25) + ((i3 & 25) << 1)) % 128;
        long j = getVersion;
        int i4 = (int) (j >>> 32);
        int i5 = i ^ (-1);
        int i6 = (i4 ^ (-1)) & i;
        int i7 = (int) j;
        setClipBounds setclipbounds = new setClipBounds(inputStream, new int[]{(i4 & i5) | i6, (i & (i7 ^ (-1))) | (i7 & i5)}, send, SConfig, s, AnalysesEntry);
        int i8 = am;
        int i9 = (i8 + 83) % 128;
        ce = i9;
        int i10 = ScoredEntry;
        int i11 = (i10 & 73) + (i10 | 73);
        FraudScore = i11 % 128;
        if (i11 % 2 != 0) {
            int i12 = (((i8 | 25) << 1) - (i8 ^ 25)) % 128;
            ce = i12;
            i2 = ((i12 | 97) << 1) - (i12 ^ 97);
        } else {
            int i13 = i9 + 103;
            am = i13 % 128;
            r10 = (i13 % 2 == 0 ? '6' : 'K') == 'K';
            i2 = (i9 ^ 17) + ((i9 & 17) << 1);
        }
        am = i2 % 128;
        if (!r10) {
            throw null;
        }
        int i14 = am;
        ce = (((i14 | 29) << 1) - (i14 ^ 29)) % 128;
        return setclipbounds;
    }
}
