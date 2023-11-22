package com.alibaba.griver.base.common.utils;

import android.graphics.PointF;
import android.view.ViewConfiguration;
import com.google.common.base.Ascii;
import id.dana.cashier.view.InputCardNumberView;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import o.getOnBoardingScenario;

/* loaded from: classes3.dex */
public class HexStringUtil {
    private static int $10 = 0;
    private static int $11 = 1;
    public static final Charset DEFAULT_CHARSET;
    public static final String DEFAULT_CHARSET_NAME;
    private static int KClassImpl$Data$declaredNonStaticMembers$2 = 1;
    private static long MyBillsEntityDataFactory;
    private static int PlaceComponentResult;

    /* renamed from: a  reason: collision with root package name */
    private static final char[] f6311a;
    private static final char[] b;
    private final Charset c;

    static void MyBillsEntityDataFactory() {
        MyBillsEntityDataFactory = 6216120437268792432L;
    }

    static {
        MyBillsEntityDataFactory();
        Object[] objArr = new Object[1];
        d((ViewConfiguration.getTapTimeout() >> 16) + 57881, new char[]{5478, 63358, 53575, 45909, 40303}, objArr);
        DEFAULT_CHARSET_NAME = ((String) objArr[0]).intern();
        Object[] objArr2 = new Object[1];
        d(57881 - (PointF.length(0.0f, 0.0f) > 0.0f ? 1 : (PointF.length(0.0f, 0.0f) == 0.0f ? 0 : -1)), new char[]{5478, 63358, 53575, 45909, 40303}, objArr2);
        DEFAULT_CHARSET = Charset.forName(((String) objArr2[0]).intern());
        f6311a = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
        b = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
        int i = KClassImpl$Data$declaredNonStaticMembers$2 + 73;
        PlaceComponentResult = i % 128;
        if (i % 2 != 0) {
            int i2 = 92 / 0;
        }
    }

    public HexStringUtil() {
        this.c = DEFAULT_CHARSET;
    }

    public HexStringUtil(Charset charset) {
        this.c = charset;
    }

    public HexStringUtil(String str) {
        this(Charset.forName(str));
    }

    /* JADX WARN: Code restructure failed: missing block: B:12:0x001b, code lost:
    
        if (((r0 & 1) == 0) == true) goto L16;
     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x0021, code lost:
    
        if ((r0 & 0) == 0) goto L16;
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x0023, code lost:
    
        r2 = com.alibaba.griver.base.common.utils.HexStringUtil.KClassImpl$Data$declaredNonStaticMembers$2 + 115;
        com.alibaba.griver.base.common.utils.HexStringUtil.PlaceComponentResult = r2 % 128;
        r2 = r2 % 2;
        r2 = new byte[r0 >> 1];
        r3 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x0032, code lost:
    
        if (r1 >= r0) goto L31;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x0036, code lost:
    
        r4 = toDigit(r6[r1], r1);
        r1 = r1 + 1;
        r5 = toDigit(r6[r1], r1);
        r1 = r1 + 1;
        r2[r3] = (byte) (((r4 << 4) | r5) & 255);
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x004c, code lost:
    
        r3 = r3 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x004f, code lost:
    
        r6 = com.alibaba.griver.base.common.utils.HexStringUtil.KClassImpl$Data$declaredNonStaticMembers$2 + 27;
        com.alibaba.griver.base.common.utils.HexStringUtil.PlaceComponentResult = r6 % 128;
        r6 = r6 % 2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x0059, code lost:
    
        return r2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x0061, code lost:
    
        throw new java.lang.Exception("Odd number of characters.");
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static byte[] decodeHex(char[] r6) throws java.lang.Exception {
        /*
            int r0 = com.alibaba.griver.base.common.utils.HexStringUtil.KClassImpl$Data$declaredNonStaticMembers$2     // Catch: java.lang.Exception -> L62
            int r0 = r0 + 11
            int r1 = r0 % 128
            com.alibaba.griver.base.common.utils.HexStringUtil.PlaceComponentResult = r1     // Catch: java.lang.Exception -> L62
            int r0 = r0 % 2
            r1 = 0
            r2 = 1
            if (r0 == 0) goto L10
            r0 = 0
            goto L11
        L10:
            r0 = 1
        L11:
            if (r0 == 0) goto L1e
            int r0 = r6.length
            r3 = r0 & 1
            if (r3 != 0) goto L1a
            r3 = 1
            goto L1b
        L1a:
            r3 = 0
        L1b:
            if (r3 != r2) goto L5a
            goto L23
        L1e:
            int r0 = r6.length
            r2 = r0 & 0
            if (r2 != 0) goto L5a
        L23:
            int r2 = com.alibaba.griver.base.common.utils.HexStringUtil.KClassImpl$Data$declaredNonStaticMembers$2
            int r2 = r2 + 115
            int r3 = r2 % 128
            com.alibaba.griver.base.common.utils.HexStringUtil.PlaceComponentResult = r3
            int r2 = r2 % 2
            int r2 = r0 >> 1
            byte[] r2 = new byte[r2]
            r3 = 0
        L32:
            if (r1 >= r0) goto L4f
            char r4 = r6[r1]
            int r4 = toDigit(r4, r1)     // Catch: java.lang.Exception -> L62
            int r1 = r1 + 1
            char r5 = r6[r1]     // Catch: java.lang.Exception -> L62
            int r5 = toDigit(r5, r1)     // Catch: java.lang.Exception -> L62
            int r1 = r1 + 1
            int r4 = r4 << 4
            r4 = r4 | r5
            r4 = r4 & 255(0xff, float:3.57E-43)
            byte r4 = (byte) r4     // Catch: java.lang.Exception -> L62
            r2[r3] = r4     // Catch: java.lang.Exception -> L62
            int r3 = r3 + 1
            goto L32
        L4f:
            int r6 = com.alibaba.griver.base.common.utils.HexStringUtil.KClassImpl$Data$declaredNonStaticMembers$2
            int r6 = r6 + 27
            int r0 = r6 % 128
            com.alibaba.griver.base.common.utils.HexStringUtil.PlaceComponentResult = r0
            int r6 = r6 % 2
            return r2
        L5a:
            java.lang.Exception r6 = new java.lang.Exception
            java.lang.String r0 = "Odd number of characters."
            r6.<init>(r0)
            throw r6
        L62:
            r6 = move-exception
            goto L65
        L64:
            throw r6
        L65:
            goto L64
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.griver.base.common.utils.HexStringUtil.decodeHex(char[]):byte[]");
    }

    public static char[] encodeHex(byte[] bArr) {
        int i = PlaceComponentResult + 81;
        KClassImpl$Data$declaredNonStaticMembers$2 = i % 128;
        int i2 = i % 2;
        char[] encodeHex = encodeHex(bArr, true);
        int i3 = KClassImpl$Data$declaredNonStaticMembers$2 + 75;
        PlaceComponentResult = i3 % 128;
        if (!(i3 % 2 != 0)) {
            return encodeHex;
        }
        Object[] objArr = null;
        int length = objArr.length;
        return encodeHex;
    }

    public static char[] encodeHex(byte[] bArr, boolean z) {
        char[] cArr;
        try {
            int i = KClassImpl$Data$declaredNonStaticMembers$2 + 53;
            PlaceComponentResult = i % 128;
            int i2 = i % 2;
            if (!(z)) {
                cArr = b;
            } else {
                int i3 = PlaceComponentResult + 117;
                KClassImpl$Data$declaredNonStaticMembers$2 = i3 % 128;
                boolean z2 = i3 % 2 != 0;
                cArr = f6311a;
                if (!z2) {
                    Object[] objArr = null;
                    int length = objArr.length;
                }
            }
            try {
                return encodeHex(bArr, cArr);
            } catch (Exception e) {
                throw e;
            }
        } catch (Exception e2) {
            throw e2;
        }
    }

    protected static char[] encodeHex(byte[] bArr, char[] cArr) {
        int length;
        int i;
        int i2 = PlaceComponentResult + 81;
        KClassImpl$Data$declaredNonStaticMembers$2 = i2 % 128;
        if ((i2 % 2 == 0 ? 'T' : (char) 18) != 'T') {
            length = bArr.length;
            i = length << 1;
        } else {
            length = bArr.length;
            i = length * 0;
        }
        char[] cArr2 = new char[i];
        int i3 = 0;
        int i4 = 0;
        while (i3 < length) {
            int i5 = KClassImpl$Data$declaredNonStaticMembers$2 + 83;
            PlaceComponentResult = i5 % 128;
            if ((i5 % 2 != 0 ? '\f' : (char) 31) != 31) {
                int i6 = i4 / 1;
                byte b2 = bArr[i3];
                cArr2[i4] = cArr[(b2 ^ Ascii.NAK) % 2];
                i4 = i6 << 1;
                cArr2[i6] = cArr[b2 ^ 0];
                i3 += 104;
            } else {
                int i7 = i4 + 1;
                byte b3 = bArr[i3];
                cArr2[i4] = cArr[(b3 & 240) >>> 4];
                i4 = i7 + 1;
                cArr2[i7] = cArr[b3 & 15];
                i3++;
            }
            int i8 = PlaceComponentResult + 73;
            KClassImpl$Data$declaredNonStaticMembers$2 = i8 % 128;
            int i9 = i8 % 2;
        }
        return cArr2;
    }

    public static String bytesToHexString(byte[] bArr) {
        String str = new String(encodeHex(bArr));
        int i = PlaceComponentResult + 85;
        KClassImpl$Data$declaredNonStaticMembers$2 = i % 128;
        if ((i % 2 == 0 ? InputCardNumberView.DIVIDER : (char) 19) != ' ') {
            return str;
        }
        Object obj = null;
        obj.hashCode();
        return str;
    }

    protected static int toDigit(char c, int i) throws Exception {
        try {
            int i2 = KClassImpl$Data$declaredNonStaticMembers$2 + 103;
            PlaceComponentResult = i2 % 128;
            int i3 = i2 % 2;
            int digit = Character.digit(c, 16);
            if ((digit != -1 ? 'S' : '2') == '2') {
                StringBuilder sb = new StringBuilder();
                sb.append("Illegal hexadecimal character ");
                sb.append(c);
                sb.append(" at index ");
                sb.append(i);
                throw new Exception(sb.toString());
            }
            int i4 = PlaceComponentResult + 37;
            KClassImpl$Data$declaredNonStaticMembers$2 = i4 % 128;
            if (i4 % 2 == 0) {
                Object obj = null;
                obj.hashCode();
                return digit;
            }
            return digit;
        } catch (Exception e) {
            throw e;
        }
    }

    public byte[] decode(byte[] bArr) throws Exception {
        try {
            try {
                byte[] decodeHex = decodeHex(new String(bArr, getCharsetName()).toCharArray());
                int i = PlaceComponentResult + 75;
                KClassImpl$Data$declaredNonStaticMembers$2 = i % 128;
                int i2 = i % 2;
                return decodeHex;
            } catch (Exception e) {
                throw e;
            }
        } catch (Exception e2) {
            throw e2;
        }
    }

    public Object decode(Object obj) throws Exception {
        char[] cArr;
        int i = KClassImpl$Data$declaredNonStaticMembers$2 + 5;
        PlaceComponentResult = i % 128;
        int i2 = i % 2;
        try {
            if (!(!(obj instanceof String))) {
                cArr = ((String) obj).toCharArray();
                int i3 = PlaceComponentResult + 23;
                KClassImpl$Data$declaredNonStaticMembers$2 = i3 % 128;
                int i4 = i3 % 2;
            } else {
                cArr = (char[]) obj;
            }
            return decodeHex(cArr);
        } catch (ClassCastException e) {
            throw new Exception(e.getMessage(), e);
        }
    }

    public byte[] encode(byte[] bArr) throws UnsupportedEncodingException {
        try {
            int i = KClassImpl$Data$declaredNonStaticMembers$2 + 9;
            PlaceComponentResult = i % 128;
            int i2 = i % 2;
            try {
                byte[] bytes = bytesToHexString(bArr).getBytes(getCharsetName());
                int i3 = KClassImpl$Data$declaredNonStaticMembers$2 + 71;
                PlaceComponentResult = i3 % 128;
                int i4 = i3 % 2;
                return bytes;
            } catch (Exception e) {
                throw e;
            }
        } catch (Exception e2) {
            throw e2;
        }
    }

    public Object encode(Object obj) throws Exception {
        byte[] bytes;
        int i = KClassImpl$Data$declaredNonStaticMembers$2 + 87;
        PlaceComponentResult = i % 128;
        int i2 = i % 2;
        try {
            if (!(obj instanceof String)) {
                bytes = (byte[]) obj;
            } else {
                int i3 = KClassImpl$Data$declaredNonStaticMembers$2 + 19;
                PlaceComponentResult = i3 % 128;
                if ((i3 % 2 != 0 ? ':' : (char) 31) != 31) {
                    bytes = ((String) obj).getBytes(getCharsetName());
                    Object obj2 = null;
                    obj2.hashCode();
                } else {
                    bytes = ((String) obj).getBytes(getCharsetName());
                }
            }
            return encodeHex(bytes);
        } catch (ClassCastException e) {
            throw new Exception(e.getMessage(), e);
        }
    }

    public Charset getCharset() {
        Charset charset;
        int i = PlaceComponentResult + 89;
        KClassImpl$Data$declaredNonStaticMembers$2 = i % 128;
        if (i % 2 != 0) {
            try {
                charset = this.c;
            } catch (Exception e) {
                throw e;
            }
        } else {
            charset = this.c;
            Object[] objArr = null;
            int length = objArr.length;
        }
        try {
            int i2 = KClassImpl$Data$declaredNonStaticMembers$2 + 75;
            PlaceComponentResult = i2 % 128;
            int i3 = i2 % 2;
            return charset;
        } catch (Exception e2) {
            throw e2;
        }
    }

    public String getCharsetName() {
        try {
            int i = KClassImpl$Data$declaredNonStaticMembers$2 + 31;
            PlaceComponentResult = i % 128;
            if ((i % 2 != 0 ? '7' : '5') != '7') {
                return this.c.name();
            }
            String name = this.c.name();
            Object[] objArr = null;
            int length = objArr.length;
            return name;
        } catch (Exception e) {
            throw e;
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(super.toString());
        sb.append("[charsetName=");
        sb.append(this.c);
        sb.append("]");
        String obj = sb.toString();
        int i = KClassImpl$Data$declaredNonStaticMembers$2 + 33;
        PlaceComponentResult = i % 128;
        if (i % 2 == 0) {
            return obj;
        }
        Object[] objArr = null;
        int length = objArr.length;
        return obj;
    }

    private static void d(int i, char[] cArr, Object[] objArr) {
        int i2;
        getOnBoardingScenario getonboardingscenario = new getOnBoardingScenario();
        getonboardingscenario.MyBillsEntityDataFactory = i;
        int length = cArr.length;
        long[] jArr = new long[length];
        getonboardingscenario.getAuthRequestContext = 0;
        while (true) {
            if (!(getonboardingscenario.getAuthRequestContext < cArr.length)) {
                break;
            }
            int i3 = $11 + 15;
            $10 = i3 % 128;
            int i4 = i3 % 2;
            jArr[getonboardingscenario.getAuthRequestContext] = (cArr[getonboardingscenario.getAuthRequestContext] ^ (getonboardingscenario.getAuthRequestContext * getonboardingscenario.MyBillsEntityDataFactory)) ^ (MyBillsEntityDataFactory ^ 4796183387843776835L);
            getonboardingscenario.getAuthRequestContext++;
        }
        char[] cArr2 = new char[length];
        getonboardingscenario.getAuthRequestContext = 0;
        int i5 = $10 + 25;
        $11 = i5 % 128;
        int i6 = i5 % 2;
        while (true) {
            try {
                if ((getonboardingscenario.getAuthRequestContext < cArr.length ? 'b' : '8') != 'b') {
                    break;
                }
                try {
                    int i7 = $10 + 67;
                    $11 = i7 % 128;
                    if (i7 % 2 == 0) {
                        cArr2[getonboardingscenario.getAuthRequestContext] = (char) jArr[getonboardingscenario.getAuthRequestContext];
                        i2 = getonboardingscenario.getAuthRequestContext >>> 0;
                    } else {
                        cArr2[getonboardingscenario.getAuthRequestContext] = (char) jArr[getonboardingscenario.getAuthRequestContext];
                        i2 = getonboardingscenario.getAuthRequestContext + 1;
                    }
                    getonboardingscenario.getAuthRequestContext = i2;
                } catch (Exception e) {
                    throw e;
                }
            } catch (Exception e2) {
                throw e2;
            }
        }
        String str = new String(cArr2);
        int i8 = $10 + 21;
        $11 = i8 % 128;
        if (i8 % 2 != 0) {
            objArr[0] = str;
            return;
        }
        Object obj = null;
        obj.hashCode();
        objArr[0] = str;
    }
}
