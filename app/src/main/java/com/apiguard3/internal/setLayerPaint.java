package com.apiguard3.internal;

import com.alibaba.wireless.security.SecExceptionCode;

/* loaded from: classes7.dex */
public class setLayerPaint {
    private static int ConfigInstance = 0;
    public static final int ConfigInstance$ConfigSerializationProxy = 0;
    private static Object E$CvmPayloadSerializationProxy = null;
    private static Object FU = null;
    public static final byte[] KernelPayloadInstance = null;
    private static long MT = 0;
    private static int NTE = 0;
    private static int RB = 0;
    private static int SLE = 1;
    public static byte[] readObject;
    private static int readResolve;
    public static byte[] writeReplace;

    /* JADX WARN: Removed duplicated region for block: B:20:0x0065  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0087  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:30:0x0087 -> B:31:0x0092). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static java.lang.String $$c(short r8, int r9, byte r10) {
        /*
            Method dump skipped, instructions count: 173
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.apiguard3.internal.setLayerPaint.$$c(short, int, byte):java.lang.String");
    }

    public static int APIGuard(int i) {
        int i2 = ConfigInstance;
        int i3 = i2 + 59;
        SLE = i3 % 128;
        if (i3 % 2 == 0) {
            throw new ArithmeticException();
        }
        Object obj = E$CvmPayloadSerializationProxy;
        SLE = ((i2 ^ 83) + ((i2 & 83) << 1)) % 128;
        try {
            Object[] objArr = {Integer.valueOf(i)};
            byte[] bArr = KernelPayloadInstance;
            int intValue = ((Integer) Class.forName($$c(bArr[131], SecExceptionCode.SEC_ERROR_DYN_STORE_GET_ENCRYPT_KEY_FAILED, bArr[202]), true, (ClassLoader) FU).getMethod($$c(bArr[34], SecExceptionCode.SEC_ERROR_SIGNATURE_NONSUPPORTED_SIGN_TYPE, bArr[227]), Integer.TYPE).invoke(obj, objArr)).intValue();
            int i4 = ConfigInstance;
            SLE = ((i4 ^ 25) + ((i4 & 25) << 1)) % 128;
            return intValue;
        } catch (Throwable th) {
            Throwable cause = th.getCause();
            if (cause != null) {
                throw cause;
            }
            throw th;
        }
    }

    public static int APIGuard(Object obj) {
        int i = ConfigInstance;
        int i2 = (i ^ 83) + ((i & 83) << 1);
        int i3 = i2 % 128;
        SLE = i3;
        if ((i2 % 2 == 0 ? '`' : '2') != '2') {
            throw new ArithmeticException();
        }
        Object obj2 = E$CvmPayloadSerializationProxy;
        ConfigInstance = ((i3 & 33) + (i3 | 33)) % 128;
        try {
            int intValue = ((Integer) Class.forName($$c(r8[131], SecExceptionCode.SEC_ERROR_DYN_STORE_GET_ENCRYPT_KEY_FAILED, r8[202]), true, (ClassLoader) FU).getMethod($$c(r8[101], (short) (KernelPayloadInstance[226] + 1), r8[19]), Object.class).invoke(obj2, obj)).intValue();
            int i4 = (ConfigInstance + 84) - 1;
            SLE = i4 % 128;
            if ((i4 % 2 == 0 ? 'A' : 'L') == 'L') {
                return intValue;
            }
            throw new NullPointerException();
        } catch (Throwable th) {
            Throwable cause = th.getCause();
            if (cause != null) {
                throw cause;
            }
            throw th;
        }
    }

    static void init$0() {
        int i;
        int i2 = SLE;
        int i3 = (i2 & 25) + (i2 | 25);
        ConfigInstance = i3 % 128;
        if (!(i3 % 2 == 0)) {
            byte[] bArr = new byte[1090];
            System.arraycopy("%\u0097\u001b\u0084\rÿÃ3\u0010úÿ\u000fí\u0012óÐý;\u0006\u0007ò\u000eýô\fÄEó\u0010à\u0011\u0010þþ\u0001× \u0012â\"\u0006ôúÀ\u0001ø\u0016ìÎ<\u0007À\u00154ò\u0001\u0000\u000eô\u0000æ&\u0003\u0006\u0000à\"ÿôý\r\u0010úÿ/í\u0012ó5\rÿÃ3\u0010úÿ\u000fí\u0012óÐý;\u0006\u0007ò\u000eýô\fÄ6Êø\u0016ìÎ?ö\u000eúÈ&'û\u0002ò\t\u0013þ\u0001ô\n\u0007Î0\u0001ýþûÿ\u0014ö\u0007\u0000\rÿÃ3\u0010úÿ\u000fí\u0012óÐý;\u0006\u0007ò\u000eýô\fÄEó\u0010Ù\u0016\u0019í\u000eß\u0012\t\u0006\u0007±Qø\u0016ìÎAü\u0007À\u00158üòÞ4ò\u0001\u0000\u000e\u000e÷\u000fþûüËIôý\u0013¸)\u0014ý\u0013Í-\u0000ù\u0004ÿ\u000fþð\u0014ö\u0007\u0000\u000e÷\u000fþûüËB\u0005¼\u00154õ\u0004ùÁ3ð\u000e\u0002÷\u0007\u0000ø\u0016ìÎ<\u0007À\u00158üòÝ2\u0001ð\u0019Ñ&\u0003\u0006\u0000à\"ÿôý\rþ\f\u000bô\u0003ÄF\u0007û\u0002ò\tÂ\u001c&à\u0019\t\u0003\u0004\bÌ\"\u0014Ì*ö\u0013\u0001Ú$ó\u0004\u0002\u000eôý\u0004ã0ø\u0001\u000eÿ\u0010Ó$\u0004ú\u000fÒ&\n\rÿÂ4\u0010úÿ\u000fí\u0012óÐ\u0006÷\u0002\u0014Ø\u0018üø\fòÿ\u0010Ú\u001d\n\u0001þ\u0004ÿ\u0010Ð\u001f\u0003\u0006þà&\nôý\u0004þ\f\u000bô\u0003ÄF\u0007û\u0002ò\tÂ\u0017\"\u0014Ï$\u0004ú\rö\u0002û\u0005ÿ\u0003\u0006þþ\f\u000bô\u0003ÄF\u0007û\u0002ò\tÂ\u0015 \u0013óà\"\u0014Ì*ö\u0013\u0001Ú$ó\u0004\u0002\u000e5\rÿÃ3\u0010úÿ\u000fí\u0012óÐý;\u0006\u0007ò\u000eýô\fÄ5Ëÿ\u0010Ð-ö\u0002ß\u001f\u0003\u0006þà&\n\u0007ööÿ\u0010à\u0011\u0010þþ\u0001Û-øû\u0012ö\u0007\u0000ì\bê\tG\u0002²Gü\f\u0001÷\u0000\u0003\t\t®Mú\u0002\u000f¶ì\u0007ë\t\rÿÂ4\u0010úÿ\u000fí\u0012óÐü<\u0006\u0007ò\u000eýô\fÃFó\u0010à\u0011\u0010þþ\u0001× \u0012â\"\u0006ôúÀ\u0001ì\u0005í\tì\té\tø\u0016ìÎ?ö\u000eúÈ\u0016*ö\u0013\u0001Ú$ó\u0004\u0002\u000e\u000e÷\u000fþûüË4\u0010\u0001¿\u00140\u0001Ø&\u0004ô\u0000\f\bÿ\u0010Ò4ýò\u000eýô\fè\"ü\u0004ð\u0007ÿà&\nôÿ\u0012ü\u0004\bø\u0016ìÎ<\u0007À\u0017\u001e\u0014îé&\u0003\u0006\u0000à\"ÿôý\r\u0004ó\u0004á\"\u0014ø\u0016ìÎ<\u0007À\u00158üòÝ2\u0001ð\u0019×'\u0000ý\u0006\u0000à\"ÿôý\r\u000e÷\u000fþûüËB\u0005¼\u0018*\tô\nþ\u0000\u0000ù\n\u0007ì\f\nñ\u000fÿ\u0010Ü\u0018\u0001\u000eó\u0010Ï$\u0002\n\u0004ôùÿ\bÿ\u0010Ð*ö\u0013\u0001Ú$ó\u0004\u0002\u000e6þ\u0014îÏ6þ\u0014îÏ\u0002\bú\u0010òÿ\u0010Óÿò\b\u0015ë\u0006\u0007\u000e÷\u000fþûüËGò\u0014ý»\u0014.÷\u000fþûüà&ú\u0012ð\u0003\u0012ò\u000eô\u0014ö\u000eðè\u001eú\u0011ð\u0012\bØ\u0012\u0014õÞ(ú\tù\n\u0007\u0000\n\u0004\u0005óø\u0016ìÎ<\u0007ÀGú\u0004õ\u0006\nÿ\u0010Ý#þ\u0002ö\u000e\u0003\u0006ÿ\u0010Î\"\u0012ýþ\n\u0000òì\u0012\u0014õ\u000e÷\u000fþûüË4\u0010\u0001¿\u0014#\u0012ö\u000eô\f\u0006Ü\u0015\u000bôý\u0004ø\u0016ìÎ<\u0007À\u0019$\u0004úë'\u0000ý\u0006\u0000à\"ÿôý\rÿ\u000eê\u001cø\fòø\u0016ìÎ<\u0007À\u001c\u0007÷4ì\u0003\f\u0005ö\u0007\u0000\u000e÷\u000fþûüËGò\u0014ý»'\u0012\u0014ýâ ö\u0004\bò\u0014õå\u001e\u000b\u0002ÿ\u0010Ö&ü\föù\fÖ0\u0001ýþûÿ\u0014ö\u0007\u0000ø\u0016ìÎ<\u0007À\u0019$\u0004úì\u0004î\t\u0013þ\u0001ô\n\u0007á\u0016\u0005ùé\u001d\u0004\u0001þ\u000bø\u0016ìÎ<\u0007À\u0019$\u0004úà\"\u000fñ\u0010ø\b\u0005ü\u0004üÔ8üòÝ2\u0001ð\u0019\u0004ó\u0004à*ö\u0013\u0001üð\u0010ô\u0014ö\u000eðè\u001eú\u0011ð\u0012\bÌ&\nôÿ\u0012ü\u0004øý\u000fø\u0016ìÎ<\u0007À\u001c&\u0003\u0006\u0000à\"ÿôý\r".getBytes("ISO-8859-1"), 0, bArr, 0, 1090);
            KernelPayloadInstance = bArr;
            i = 61;
        } else {
            byte[] bArr2 = new byte[1090];
            System.arraycopy("%\u0097\u001b\u0084\rÿÃ3\u0010úÿ\u000fí\u0012óÐý;\u0006\u0007ò\u000eýô\fÄEó\u0010à\u0011\u0010þþ\u0001× \u0012â\"\u0006ôúÀ\u0001ø\u0016ìÎ<\u0007À\u00154ò\u0001\u0000\u000eô\u0000æ&\u0003\u0006\u0000à\"ÿôý\r\u0010úÿ/í\u0012ó5\rÿÃ3\u0010úÿ\u000fí\u0012óÐý;\u0006\u0007ò\u000eýô\fÄ6Êø\u0016ìÎ?ö\u000eúÈ&'û\u0002ò\t\u0013þ\u0001ô\n\u0007Î0\u0001ýþûÿ\u0014ö\u0007\u0000\rÿÃ3\u0010úÿ\u000fí\u0012óÐý;\u0006\u0007ò\u000eýô\fÄEó\u0010Ù\u0016\u0019í\u000eß\u0012\t\u0006\u0007±Qø\u0016ìÎAü\u0007À\u00158üòÞ4ò\u0001\u0000\u000e\u000e÷\u000fþûüËIôý\u0013¸)\u0014ý\u0013Í-\u0000ù\u0004ÿ\u000fþð\u0014ö\u0007\u0000\u000e÷\u000fþûüËB\u0005¼\u00154õ\u0004ùÁ3ð\u000e\u0002÷\u0007\u0000ø\u0016ìÎ<\u0007À\u00158üòÝ2\u0001ð\u0019Ñ&\u0003\u0006\u0000à\"ÿôý\rþ\f\u000bô\u0003ÄF\u0007û\u0002ò\tÂ\u001c&à\u0019\t\u0003\u0004\bÌ\"\u0014Ì*ö\u0013\u0001Ú$ó\u0004\u0002\u000eôý\u0004ã0ø\u0001\u000eÿ\u0010Ó$\u0004ú\u000fÒ&\n\rÿÂ4\u0010úÿ\u000fí\u0012óÐ\u0006÷\u0002\u0014Ø\u0018üø\fòÿ\u0010Ú\u001d\n\u0001þ\u0004ÿ\u0010Ð\u001f\u0003\u0006þà&\nôý\u0004þ\f\u000bô\u0003ÄF\u0007û\u0002ò\tÂ\u0017\"\u0014Ï$\u0004ú\rö\u0002û\u0005ÿ\u0003\u0006þþ\f\u000bô\u0003ÄF\u0007û\u0002ò\tÂ\u0015 \u0013óà\"\u0014Ì*ö\u0013\u0001Ú$ó\u0004\u0002\u000e5\rÿÃ3\u0010úÿ\u000fí\u0012óÐý;\u0006\u0007ò\u000eýô\fÄ5Ëÿ\u0010Ð-ö\u0002ß\u001f\u0003\u0006þà&\n\u0007ööÿ\u0010à\u0011\u0010þþ\u0001Û-øû\u0012ö\u0007\u0000ì\bê\tG\u0002²Gü\f\u0001÷\u0000\u0003\t\t®Mú\u0002\u000f¶ì\u0007ë\t\rÿÂ4\u0010úÿ\u000fí\u0012óÐü<\u0006\u0007ò\u000eýô\fÃFó\u0010à\u0011\u0010þþ\u0001× \u0012â\"\u0006ôúÀ\u0001ì\u0005í\tì\té\tø\u0016ìÎ?ö\u000eúÈ\u0016*ö\u0013\u0001Ú$ó\u0004\u0002\u000e\u000e÷\u000fþûüË4\u0010\u0001¿\u00140\u0001Ø&\u0004ô\u0000\f\bÿ\u0010Ò4ýò\u000eýô\fè\"ü\u0004ð\u0007ÿà&\nôÿ\u0012ü\u0004\bø\u0016ìÎ<\u0007À\u0017\u001e\u0014îé&\u0003\u0006\u0000à\"ÿôý\r\u0004ó\u0004á\"\u0014ø\u0016ìÎ<\u0007À\u00158üòÝ2\u0001ð\u0019×'\u0000ý\u0006\u0000à\"ÿôý\r\u000e÷\u000fþûüËB\u0005¼\u0018*\tô\nþ\u0000\u0000ù\n\u0007ì\f\nñ\u000fÿ\u0010Ü\u0018\u0001\u000eó\u0010Ï$\u0002\n\u0004ôùÿ\bÿ\u0010Ð*ö\u0013\u0001Ú$ó\u0004\u0002\u000e6þ\u0014îÏ6þ\u0014îÏ\u0002\bú\u0010òÿ\u0010Óÿò\b\u0015ë\u0006\u0007\u000e÷\u000fþûüËGò\u0014ý»\u0014.÷\u000fþûüà&ú\u0012ð\u0003\u0012ò\u000eô\u0014ö\u000eðè\u001eú\u0011ð\u0012\bØ\u0012\u0014õÞ(ú\tù\n\u0007\u0000\n\u0004\u0005óø\u0016ìÎ<\u0007ÀGú\u0004õ\u0006\nÿ\u0010Ý#þ\u0002ö\u000e\u0003\u0006ÿ\u0010Î\"\u0012ýþ\n\u0000òì\u0012\u0014õ\u000e÷\u000fþûüË4\u0010\u0001¿\u0014#\u0012ö\u000eô\f\u0006Ü\u0015\u000bôý\u0004ø\u0016ìÎ<\u0007À\u0019$\u0004úë'\u0000ý\u0006\u0000à\"ÿôý\rÿ\u000eê\u001cø\fòø\u0016ìÎ<\u0007À\u001c\u0007÷4ì\u0003\f\u0005ö\u0007\u0000\u000e÷\u000fþûüËGò\u0014ý»'\u0012\u0014ýâ ö\u0004\bò\u0014õå\u001e\u000b\u0002ÿ\u0010Ö&ü\föù\fÖ0\u0001ýþûÿ\u0014ö\u0007\u0000ø\u0016ìÎ<\u0007À\u0019$\u0004úì\u0004î\t\u0013þ\u0001ô\n\u0007á\u0016\u0005ùé\u001d\u0004\u0001þ\u000bø\u0016ìÎ<\u0007À\u0019$\u0004úà\"\u000fñ\u0010ø\b\u0005ü\u0004üÔ8üòÝ2\u0001ð\u0019\u0004ó\u0004à*ö\u0013\u0001üð\u0010ô\u0014ö\u000eðè\u001eú\u0011ð\u0012\bÌ&\nôÿ\u0012ü\u0004øý\u000fø\u0016ìÎ<\u0007À\u001c&\u0003\u0006\u0000à\"ÿôý\r".getBytes("ISO-8859-1"), 0, bArr2, 0, 1090);
            KernelPayloadInstance = bArr2;
            i = 31;
        }
        ConfigInstance$ConfigSerializationProxy = i;
        int i4 = ConfigInstance;
        SLE = ((i4 ^ 75) + ((i4 & 75) << 1)) % 128;
    }

    public static Object values(int i, int i2, char c) {
        int i3 = ConfigInstance;
        SLE = (i3 + 31) % 128;
        Object obj = E$CvmPayloadSerializationProxy;
        SLE = (((i3 | 121) << 1) - (i3 ^ 121)) % 128;
        try {
            Object[] objArr = {Integer.valueOf(i), Integer.valueOf(i2), Character.valueOf(c)};
            byte[] bArr = KernelPayloadInstance;
            Object invoke = Class.forName($$c(bArr[131], SecExceptionCode.SEC_ERROR_DYN_STORE_GET_ENCRYPT_KEY_FAILED, bArr[202]), true, (ClassLoader) FU).getMethod($$c(bArr[34], SecExceptionCode.SEC_ERROR_SIGNATURE_NONSUPPORTED_SIGN_TYPE, bArr[227]), Integer.TYPE, Integer.TYPE, Character.TYPE).invoke(obj, objArr);
            int i4 = (ConfigInstance + 104) - 1;
            SLE = i4 % 128;
            if (i4 % 2 != 0) {
                return invoke;
            }
            throw new NullPointerException();
        } catch (Throwable th) {
            Throwable cause = th.getCause();
            if (cause != null) {
                throw cause;
            }
            throw th;
        }
    }

    private setLayerPaint() {
    }

    /* JADX WARN: Can't wrap try/catch for region: R(43:(1:11)(1:1010)|(42:1006|1007|(0)(0)|16|(0)|18|19|(0)|1000|(0)(0)|30|(0)(0)|(0)(0)|35|(0)(0)|(0)(0)|45|(0)|60|61|62|63|64|65|(0)(0)|68|(0)(0)|71|(0)(0)|74|(0)(0)|77|(0)(0)|80|(0)(0)|83|(0)(0)|86|87|(1:88)|943|944)|13|(0)(0)|16|(0)|18|19|(0)|1000|(0)(0)|30|(0)(0)|(0)(0)|35|(0)(0)|(0)(0)|45|(0)|60|61|62|63|64|65|(0)(0)|68|(0)(0)|71|(0)(0)|74|(0)(0)|77|(0)(0)|80|(0)(0)|83|(0)(0)|86|87|(1:88)|943|944) */
    /* JADX WARN: Code restructure failed: missing block: B:10:0x0072, code lost:
    
        if (r5 != null) goto L16;
     */
    /* JADX WARN: Code restructure failed: missing block: B:149:0x04a3, code lost:
    
        if (((java.lang.Boolean) java.lang.Class.forName($$c(r13[r15], 972, r13[r14])).getMethod($$c(r13[131(0x83, float:1.84E-43)], com.alibaba.wireless.security.SecExceptionCode.SEC_ERROR_PKG_VALID_UNKNOWN_ERR, r13[19]), null).invoke(r12, null)).booleanValue() != false) goto L167;
     */
    /* JADX WARN: Code restructure failed: missing block: B:285:0x0870, code lost:
    
        if (r13.nextBoolean() != false) goto L286;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:1005:0x143b A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:1022:0x187d A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:1030:0x167f A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:1034:0x187a A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:103:0x03dd  */
    /* JADX WARN: Removed duplicated region for block: B:104:0x03e0  */
    /* JADX WARN: Removed duplicated region for block: B:107:0x03e6  */
    /* JADX WARN: Removed duplicated region for block: B:108:0x03ea  */
    /* JADX WARN: Removed duplicated region for block: B:111:0x03f3  */
    /* JADX WARN: Removed duplicated region for block: B:112:0x03f6  */
    /* JADX WARN: Removed duplicated region for block: B:115:0x03fc  */
    /* JADX WARN: Removed duplicated region for block: B:116:0x0400  */
    /* JADX WARN: Removed duplicated region for block: B:119:0x0407  */
    /* JADX WARN: Removed duplicated region for block: B:120:0x0409  */
    /* JADX WARN: Removed duplicated region for block: B:123:0x0411  */
    /* JADX WARN: Removed duplicated region for block: B:124:0x0413  */
    /* JADX WARN: Removed duplicated region for block: B:127:0x041a  */
    /* JADX WARN: Removed duplicated region for block: B:128:0x041c  */
    /* JADX WARN: Removed duplicated region for block: B:133:0x0426  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x00ac  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x00ae  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x00d5  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x00d8  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x0105  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x0153  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x0156  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0161  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x016d  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x01f7  */
    /* JADX WARN: Removed duplicated region for block: B:624:0x1458  */
    /* JADX WARN: Removed duplicated region for block: B:625:0x145a  */
    /* JADX WARN: Removed duplicated region for block: B:627:0x145d A[Catch: all -> 0x14ab, TRY_ENTER, TryCatch #47 {all -> 0x14ab, blocks: (B:631:0x1463, B:632:0x1494, B:636:0x14a2, B:637:0x14a8, B:648:0x152c, B:617:0x143b, B:627:0x145d), top: B:922:0x1463 }] */
    /* JADX WARN: Removed duplicated region for block: B:62:0x01fa  */
    /* JADX WARN: Removed duplicated region for block: B:641:0x14b3 A[Catch: all -> 0x167b, TRY_ENTER, TRY_LEAVE, TryCatch #30 {all -> 0x167b, blocks: (B:651:0x1547, B:641:0x14b3, B:645:0x1522, B:614:0x13ee, B:621:0x144e, B:622:0x1454), top: B:894:0x1547 }] */
    /* JADX WARN: Removed duplicated region for block: B:65:0x0200 A[Catch: Exception -> 0x1933, TRY_ENTER, TRY_LEAVE, TryCatch #79 {Exception -> 0x1933, blocks: (B:3:0x0019, B:5:0x0033, B:65:0x0200, B:88:0x0298, B:94:0x02e9, B:96:0x02ef, B:97:0x02f0, B:99:0x0323, B:101:0x03ad, B:109:0x03ed, B:117:0x0403, B:121:0x040a, B:125:0x0414, B:129:0x041d, B:139:0x0431, B:817:0x18fc, B:796:0x1864, B:804:0x188a, B:806:0x18ad, B:812:0x18ea, B:814:0x18f0, B:815:0x18f1, B:805:0x189a, B:816:0x18f2, B:820:0x1920, B:822:0x1927, B:823:0x1928, B:72:0x026c, B:74:0x0272, B:75:0x0273, B:77:0x0275, B:79:0x027c, B:80:0x027d, B:51:0x0172, B:825:0x192a, B:827:0x1931, B:828:0x1932, B:58:0x01aa, B:59:0x01ce, B:68:0x0247, B:67:0x020c, B:90:0x02af, B:808:0x18b3, B:809:0x18e7, B:98:0x02f1), top: B:977:0x0019, inners: #2, #23, #28, #75, #76, #101 }] */
    /* JADX WARN: Removed duplicated region for block: B:793:0x185f  */
    /* JADX WARN: Removed duplicated region for block: B:794:0x1861  */
    /* JADX WARN: Removed duplicated region for block: B:796:0x1864 A[Catch: Exception -> 0x1933, TRY_ENTER, TRY_LEAVE, TryCatch #79 {Exception -> 0x1933, blocks: (B:3:0x0019, B:5:0x0033, B:65:0x0200, B:88:0x0298, B:94:0x02e9, B:96:0x02ef, B:97:0x02f0, B:99:0x0323, B:101:0x03ad, B:109:0x03ed, B:117:0x0403, B:121:0x040a, B:125:0x0414, B:129:0x041d, B:139:0x0431, B:817:0x18fc, B:796:0x1864, B:804:0x188a, B:806:0x18ad, B:812:0x18ea, B:814:0x18f0, B:815:0x18f1, B:805:0x189a, B:816:0x18f2, B:820:0x1920, B:822:0x1927, B:823:0x1928, B:72:0x026c, B:74:0x0272, B:75:0x0273, B:77:0x0275, B:79:0x027c, B:80:0x027d, B:51:0x0172, B:825:0x192a, B:827:0x1931, B:828:0x1932, B:58:0x01aa, B:59:0x01ce, B:68:0x0247, B:67:0x020c, B:90:0x02af, B:808:0x18b3, B:809:0x18e7, B:98:0x02f1), top: B:977:0x0019, inners: #2, #23, #28, #75, #76, #101 }] */
    /* JADX WARN: Removed duplicated region for block: B:816:0x18f2 A[Catch: Exception -> 0x1933, TryCatch #79 {Exception -> 0x1933, blocks: (B:3:0x0019, B:5:0x0033, B:65:0x0200, B:88:0x0298, B:94:0x02e9, B:96:0x02ef, B:97:0x02f0, B:99:0x0323, B:101:0x03ad, B:109:0x03ed, B:117:0x0403, B:121:0x040a, B:125:0x0414, B:129:0x041d, B:139:0x0431, B:817:0x18fc, B:796:0x1864, B:804:0x188a, B:806:0x18ad, B:812:0x18ea, B:814:0x18f0, B:815:0x18f1, B:805:0x189a, B:816:0x18f2, B:820:0x1920, B:822:0x1927, B:823:0x1928, B:72:0x026c, B:74:0x0272, B:75:0x0273, B:77:0x0275, B:79:0x027c, B:80:0x027d, B:51:0x0172, B:825:0x192a, B:827:0x1931, B:828:0x1932, B:58:0x01aa, B:59:0x01ce, B:68:0x0247, B:67:0x020c, B:90:0x02af, B:808:0x18b3, B:809:0x18e7, B:98:0x02f1), top: B:977:0x0019, inners: #2, #23, #28, #75, #76, #101 }] */
    /* JADX WARN: Removed duplicated region for block: B:81:0x027e  */
    /* JADX WARN: Removed duplicated region for block: B:83:0x028d  */
    /* JADX WARN: Removed duplicated region for block: B:84:0x0290  */
    /* JADX WARN: Removed duplicated region for block: B:861:0x00e0 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:87:0x0296 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:894:0x1547 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:905:0x00b1 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:922:0x1463 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r11v181, types: [java.lang.reflect.Method] */
    /* JADX WARN: Type inference failed for: r12v1, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r4v104, types: [java.lang.StringBuilder, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r9v22, types: [java.lang.Object[]] */
    /* JADX WARN: Type inference failed for: r9v23 */
    /* JADX WARN: Type inference failed for: r9v230 */
    /* JADX WARN: Type inference failed for: r9v25 */
    /* JADX WARN: Type inference failed for: r9v26 */
    /* JADX WARN: Type inference failed for: r9v52 */
    static {
        /*
            Method dump skipped, instructions count: 6461
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.apiguard3.internal.setLayerPaint.<clinit>():void");
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x0067, code lost:
    
        if ((r1 % 2) != 0) goto L12;
     */
    /* JADX WARN: Code restructure failed: missing block: B:12:0x0069, code lost:
    
        com.apiguard3.internal.setLayerPaint.SLE = (r13 + 25) % 128;
     */
    /* JADX WARN: Code restructure failed: missing block: B:13:0x0070, code lost:
    
        com.apiguard3.internal.setLayerPaint.ConfigInstance = (r10 + 77) % 128;
        r8 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:8:0x0058, code lost:
    
        if ((r11 / 2) != 0) goto L12;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static java.io.InputStream getSharedInstance(java.io.InputStream r10, byte[] r11, int r12, int r13) throws java.io.IOException {
        /*
            int r0 = com.apiguard3.internal.setLayerPaint.SLE
            int r0 = r0 + 27
            int r0 = r0 % 128
            com.apiguard3.internal.setLayerPaint.ConfigInstance = r0
            r1 = r0 & 67
            r0 = r0 | 67
            int r1 = r1 + r0
            int r1 = r1 % 128
            com.apiguard3.internal.setLayerPaint.SLE = r1
            r0 = 2
            int[] r3 = new int[r0]
            long r1 = com.apiguard3.internal.setLayerPaint.MT
            r4 = 32
            long r4 = r1 >>> r4
            int r5 = (int) r4
            r4 = r12 ^ (-1)
            r4 = r4 & r5
            r5 = r5 ^ (-1)
            r5 = r5 & r12
            r4 = r4 | r5
            r8 = 0
            r3[r8] = r4
            int r2 = (int) r1
            r1 = r12 | r2
            r12 = r12 & r2
            r12 = r12 ^ (-1)
            r12 = r12 & r1
            r9 = 1
            r3[r9] = r12
            com.apiguard3.internal.setBackgroundResource r12 = new com.apiguard3.internal.setBackgroundResource
            int r5 = com.apiguard3.internal.setLayerPaint.NTE
            r6 = 0
            r1 = r12
            r2 = r10
            r4 = r11
            r7 = r13
            r1.<init>(r2, r3, r4, r5, r6, r7)
            int r10 = com.apiguard3.internal.setLayerPaint.SLE
            int r11 = r10 + 37
            int r13 = r11 % 128
            com.apiguard3.internal.setLayerPaint.ConfigInstance = r13
            int r11 = r11 % r0
            r1 = 19
            if (r11 == 0) goto L4b
            r11 = 56
            goto L4d
        L4b:
            r11 = 19
        L4d:
            if (r11 == r1) goto L5b
            int r11 = com.apiguard3.internal.setLayerPaint.RB
            int r11 = r11 << 69
            int r1 = r11 / 1452
            com.apiguard3.internal.setLayerPaint.readResolve = r1
            int r11 = r11 / r0
            if (r11 == 0) goto L70
            goto L69
        L5b:
            int r11 = com.apiguard3.internal.setLayerPaint.RB
            r1 = r11 & 79
            r11 = r11 | 79
            int r1 = r1 + r11
            int r11 = r1 % 128
            com.apiguard3.internal.setLayerPaint.readResolve = r11
            int r1 = r1 % r0
            if (r1 == 0) goto L70
        L69:
            int r13 = r13 + 25
            int r13 = r13 % 128
            com.apiguard3.internal.setLayerPaint.SLE = r13
            goto L77
        L70:
            int r10 = r10 + 77
            int r10 = r10 % 128
            com.apiguard3.internal.setLayerPaint.ConfigInstance = r10
            r8 = 1
        L77:
            if (r8 == 0) goto L96
            int r10 = com.apiguard3.internal.setLayerPaint.SLE
            int r10 = r10 + 41
            int r11 = r10 % 128
            com.apiguard3.internal.setLayerPaint.ConfigInstance = r11
            int r10 = r10 % r0
            r11 = 15
            if (r10 == 0) goto L89
            r10 = 94
            goto L8b
        L89:
            r10 = 15
        L8b:
            if (r10 != r11) goto L8e
            return r12
        L8e:
            java.lang.ArithmeticException r10 = new java.lang.ArithmeticException     // Catch: java.lang.Throwable -> L94
            r10.<init>()     // Catch: java.lang.Throwable -> L94
            throw r10     // Catch: java.lang.Throwable -> L94
        L94:
            r10 = move-exception
            throw r10
        L96:
            java.lang.NullPointerException r10 = new java.lang.NullPointerException     // Catch: java.lang.Throwable -> L9c
            r10.<init>()     // Catch: java.lang.Throwable -> L9c
            throw r10     // Catch: java.lang.Throwable -> L9c
        L9c:
            r10 = move-exception
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.apiguard3.internal.setLayerPaint.getSharedInstance(java.io.InputStream, byte[], int, int):java.io.InputStream");
    }
}
