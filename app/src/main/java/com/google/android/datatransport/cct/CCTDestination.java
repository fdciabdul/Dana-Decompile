package com.google.android.datatransport.cct;

import com.alibaba.fastjson.parser.JSONLexer;
import com.google.android.datatransport.Encoding;
import com.google.android.datatransport.runtime.EncodedDestination;
import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.regex.Pattern;
import o.VerifyPinStateManager$executeRiskChallenge$2$2;

/* loaded from: classes7.dex */
public final class CCTDestination implements EncodedDestination {
    private static int $10 = 0;
    private static int $11 = 1;
    private static final String DEFAULT_API_KEY;
    static final String DEFAULT_END_POINT;
    static final String DESTINATION_NAME = "cct";
    private static final String EXTRAS_DELIMITER = "\\";
    private static final String EXTRAS_VERSION_MARKER = "1$";
    public static final CCTDestination INSTANCE;
    private static int KClassImpl$Data$declaredNonStaticMembers$2 = 1;
    static final String LEGACY_END_POINT;
    public static final CCTDestination LEGACY_INSTANCE;
    private static char[] MyBillsEntityDataFactory;
    private static final Set<Encoding> SUPPORTED_ENCODINGS;
    private static int getAuthRequestContext;
    private final String apiKey;
    private final String endPoint;

    static void BuiltInFictitiousFunctionClassFactory() {
        MyBillsEntityDataFactory = new char[]{35508, 35544, 35500, 35495, 35539};
    }

    @Override // com.google.android.datatransport.runtime.Destination
    public final String getName() {
        try {
            int i = KClassImpl$Data$declaredNonStaticMembers$2 + 23;
            try {
                getAuthRequestContext = i % 128;
                int i2 = i % 2;
                int i3 = getAuthRequestContext + 33;
                KClassImpl$Data$declaredNonStaticMembers$2 = i3 % 128;
                if ((i3 % 2 == 0 ? 'Q' : '8') != 'Q') {
                    return DESTINATION_NAME;
                }
                Object[] objArr = null;
                int length = objArr.length;
                return DESTINATION_NAME;
            } catch (Exception e) {
                throw e;
            }
        } catch (Exception e2) {
            throw e2;
        }
    }

    static {
        try {
            BuiltInFictitiousFunctionClassFactory();
            try {
                String mergeStrings = StringMerger.mergeStrings("hts/frbslgiggolai.o/0clgbthfra=snpoo", "tp:/ieaeogn.ogepscmvc/o/ac?omtjo_rt3");
                DEFAULT_END_POINT = mergeStrings;
                String mergeStrings2 = StringMerger.mergeStrings("hts/frbslgigp.ogepscmv/ieo/eaybtho", "tp:/ieaeogn-agolai.o/1frlglgc/aclg");
                LEGACY_END_POINT = mergeStrings2;
                String mergeStrings3 = StringMerger.mergeStrings("AzSCki82AwsLzKd5O8zo", "IayckHiZRO1EFl1aGoK");
                DEFAULT_API_KEY = mergeStrings3;
                SUPPORTED_ENCODINGS = Collections.unmodifiableSet(new HashSet(Arrays.asList(Encoding.of("proto"), Encoding.of("json"))));
                Object[] objArr = null;
                INSTANCE = new CCTDestination(mergeStrings, null);
                LEGACY_INSTANCE = new CCTDestination(mergeStrings2, mergeStrings3);
                int i = KClassImpl$Data$declaredNonStaticMembers$2 + 29;
                getAuthRequestContext = i % 128;
                if ((i % 2 != 0 ? ',' : (char) 25) != ',') {
                    return;
                }
                int length = objArr.length;
            } catch (Exception e) {
                throw e;
            }
        } catch (Exception e2) {
            throw e2;
        }
    }

    public CCTDestination(String str, String str2) {
        try {
            this.endPoint = str;
            try {
                this.apiKey = str2;
            } catch (Exception e) {
                throw e;
            }
        } catch (Exception e2) {
            throw e2;
        }
    }

    @Override // com.google.android.datatransport.runtime.Destination
    public final byte[] getExtras() {
        int i = KClassImpl$Data$declaredNonStaticMembers$2 + 37;
        getAuthRequestContext = i % 128;
        int i2 = i % 2;
        try {
            byte[] asByteArray = asByteArray();
            int i3 = KClassImpl$Data$declaredNonStaticMembers$2 + 121;
            getAuthRequestContext = i3 % 128;
            if ((i3 % 2 != 0 ? ',' : 'C') != ',') {
                return asByteArray;
            }
            Object[] objArr = null;
            int length = objArr.length;
            return asByteArray;
        } catch (Exception e) {
            throw e;
        }
    }

    @Override // com.google.android.datatransport.runtime.EncodedDestination
    public final Set<Encoding> getSupportedEncodings() {
        int i = getAuthRequestContext + 55;
        KClassImpl$Data$declaredNonStaticMembers$2 = i % 128;
        if (!(i % 2 == 0)) {
            return SUPPORTED_ENCODINGS;
        }
        Set<Encoding> set = SUPPORTED_ENCODINGS;
        Object[] objArr = null;
        int length = objArr.length;
        return set;
    }

    public final String getAPIKey() {
        int i = KClassImpl$Data$declaredNonStaticMembers$2 + 7;
        getAuthRequestContext = i % 128;
        if ((i % 2 != 0 ? '1' : (char) 28) != '1') {
            return this.apiKey;
        }
        String str = this.apiKey;
        Object[] objArr = null;
        int length = objArr.length;
        return str;
    }

    public final String getEndPoint() {
        try {
            int i = getAuthRequestContext + 33;
            try {
                KClassImpl$Data$declaredNonStaticMembers$2 = i % 128;
                int i2 = i % 2;
                String str = this.endPoint;
                int i3 = getAuthRequestContext + 37;
                KClassImpl$Data$declaredNonStaticMembers$2 = i3 % 128;
                if (!(i3 % 2 == 0)) {
                    return str;
                }
                int i4 = 81 / 0;
                return str;
            } catch (Exception e) {
                throw e;
            }
        } catch (Exception e2) {
            throw e2;
        }
    }

    public final byte[] asByteArray() {
        String str = this.apiKey;
        Object obj = null;
        if (str == null && this.endPoint == null) {
            return null;
        }
        Object[] objArr = new Object[4];
        objArr[0] = EXTRAS_VERSION_MARKER;
        objArr[1] = this.endPoint;
        objArr[2] = EXTRAS_DELIMITER;
        if (str == null) {
            int i = getAuthRequestContext + 75;
            KClassImpl$Data$declaredNonStaticMembers$2 = i % 128;
            if ((i % 2 == 0 ? 'A' : (char) 3) == 'A') {
                obj.hashCode();
            }
            int i2 = getAuthRequestContext + 93;
            KClassImpl$Data$declaredNonStaticMembers$2 = i2 % 128;
            int i3 = i2 % 2;
            str = "";
        }
        objArr[3] = str;
        String format = String.format("%s%s%s%s", objArr);
        Object[] objArr2 = new Object[1];
        a(new int[]{0, 5, 0, 1}, true, new byte[]{1, 1, 1, 1, 0}, objArr2);
        return format.getBytes(Charset.forName(((String) objArr2[0]).intern()));
    }

    public static CCTDestination fromByteArray(byte[] bArr) {
        Object[] objArr = new Object[1];
        a(new int[]{0, 5, 0, 1}, true, new byte[]{1, 1, 1, 1, 0}, objArr);
        String str = new String(bArr, Charset.forName(((String) objArr[0]).intern()));
        if (!str.startsWith(EXTRAS_VERSION_MARKER)) {
            throw new IllegalArgumentException("Version marker missing from extras");
        }
        int i = getAuthRequestContext + 101;
        KClassImpl$Data$declaredNonStaticMembers$2 = i % 128;
        int i2 = i % 2;
        String[] split = str.substring(2).split(Pattern.quote(EXTRAS_DELIMITER), 2);
        if (!(split.length == 2)) {
            throw new IllegalArgumentException("Extra is not a valid encoded LegacyFlgDestination");
        }
        int i3 = getAuthRequestContext + 49;
        KClassImpl$Data$declaredNonStaticMembers$2 = i3 % 128;
        int i4 = i3 % 2;
        String str2 = split[0];
        if (str2.isEmpty()) {
            throw new IllegalArgumentException("Missing endpoint in CCTDestination extras");
        }
        int i5 = KClassImpl$Data$declaredNonStaticMembers$2 + 17;
        getAuthRequestContext = i5 % 128;
        int i6 = i5 % 2;
        String str3 = split[1];
        if (!(str3.isEmpty() ? false : true)) {
            str3 = null;
        }
        return new CCTDestination(str2, str3);
    }

    static byte[] encodeString(String str) {
        int i = getAuthRequestContext + 73;
        KClassImpl$Data$declaredNonStaticMembers$2 = i % 128;
        int i2 = i % 2;
        Object[] objArr = new Object[1];
        a(new int[]{0, 5, 0, 1}, true, new byte[]{1, 1, 1, 1, 0}, objArr);
        byte[] bytes = str.getBytes(Charset.forName(((String) objArr[0]).intern()));
        int i3 = KClassImpl$Data$declaredNonStaticMembers$2 + 61;
        getAuthRequestContext = i3 % 128;
        if ((i3 % 2 != 0 ? '?' : (char) 25) != 25) {
            Object obj = null;
            obj.hashCode();
            return bytes;
        }
        return bytes;
    }

    static String decodeExtras(byte[] bArr) {
        Object[] objArr = new Object[1];
        a(new int[]{0, 5, 0, 1}, true, new byte[]{1, 1, 1, 1, 0}, objArr);
        String str = new String(bArr, Charset.forName(((String) objArr[0]).intern()));
        int i = getAuthRequestContext + 33;
        KClassImpl$Data$declaredNonStaticMembers$2 = i % 128;
        int i2 = i % 2;
        return str;
    }

    private static void a(int[] iArr, boolean z, byte[] bArr, Object[] objArr) {
        VerifyPinStateManager$executeRiskChallenge$2$2 verifyPinStateManager$executeRiskChallenge$2$2 = new VerifyPinStateManager$executeRiskChallenge$2$2();
        int i = iArr[0];
        int i2 = iArr[1];
        int i3 = iArr[2];
        int i4 = iArr[3];
        char[] cArr = MyBillsEntityDataFactory;
        if (cArr != null) {
            int length = cArr.length;
            char[] cArr2 = new char[length];
            for (int i5 = 0; i5 < length; i5++) {
                cArr2[i5] = (char) (cArr[i5] ^ 5097613533456403102L);
            }
            cArr = cArr2;
        }
        char[] cArr3 = new char[i2];
        try {
            System.arraycopy(cArr, i, cArr3, 0, i2);
            if (bArr != null) {
                char[] cArr4 = new char[i2];
                try {
                    verifyPinStateManager$executeRiskChallenge$2$2.BuiltInFictitiousFunctionClassFactory = 0;
                    char c = 0;
                    while (verifyPinStateManager$executeRiskChallenge$2$2.BuiltInFictitiousFunctionClassFactory < i2) {
                        if ((bArr[verifyPinStateManager$executeRiskChallenge$2$2.BuiltInFictitiousFunctionClassFactory] == 1 ? '0' : JSONLexer.EOI) != '0') {
                            cArr4[verifyPinStateManager$executeRiskChallenge$2$2.BuiltInFictitiousFunctionClassFactory] = (char) ((cArr3[verifyPinStateManager$executeRiskChallenge$2$2.BuiltInFictitiousFunctionClassFactory] * 2) - c);
                        } else {
                            int i6 = $10 + 121;
                            $11 = i6 % 128;
                            int i7 = i6 % 2;
                            cArr4[verifyPinStateManager$executeRiskChallenge$2$2.BuiltInFictitiousFunctionClassFactory] = (char) (((cArr3[verifyPinStateManager$executeRiskChallenge$2$2.BuiltInFictitiousFunctionClassFactory] * 2) + 1) - c);
                        }
                        c = cArr4[verifyPinStateManager$executeRiskChallenge$2$2.BuiltInFictitiousFunctionClassFactory];
                        verifyPinStateManager$executeRiskChallenge$2$2.BuiltInFictitiousFunctionClassFactory++;
                    }
                    cArr3 = cArr4;
                } catch (Exception e) {
                    throw e;
                }
            }
            if (i4 > 0) {
                int i8 = $11 + 75;
                $10 = i8 % 128;
                int i9 = i8 % 2;
                char[] cArr5 = new char[i2];
                System.arraycopy(cArr3, 0, cArr5, 0, i2);
                int i10 = i2 - i4;
                System.arraycopy(cArr5, 0, cArr3, i10, i4);
                System.arraycopy(cArr5, i4, cArr3, 0, i10);
            }
            if (z) {
                int i11 = $10 + 29;
                $11 = i11 % 128;
                int i12 = i11 % 2;
                char[] cArr6 = new char[i2];
                verifyPinStateManager$executeRiskChallenge$2$2.BuiltInFictitiousFunctionClassFactory = 0;
                while (verifyPinStateManager$executeRiskChallenge$2$2.BuiltInFictitiousFunctionClassFactory < i2) {
                    cArr6[verifyPinStateManager$executeRiskChallenge$2$2.BuiltInFictitiousFunctionClassFactory] = cArr3[(i2 - verifyPinStateManager$executeRiskChallenge$2$2.BuiltInFictitiousFunctionClassFactory) - 1];
                    verifyPinStateManager$executeRiskChallenge$2$2.BuiltInFictitiousFunctionClassFactory++;
                }
                cArr3 = cArr6;
            }
            if (i3 > 0) {
                int i13 = $11 + 39;
                $10 = i13 % 128;
                if (i13 % 2 != 0) {
                    verifyPinStateManager$executeRiskChallenge$2$2.BuiltInFictitiousFunctionClassFactory = 1;
                } else {
                    verifyPinStateManager$executeRiskChallenge$2$2.BuiltInFictitiousFunctionClassFactory = 0;
                }
                while (verifyPinStateManager$executeRiskChallenge$2$2.BuiltInFictitiousFunctionClassFactory < i2) {
                    cArr3[verifyPinStateManager$executeRiskChallenge$2$2.BuiltInFictitiousFunctionClassFactory] = (char) (cArr3[verifyPinStateManager$executeRiskChallenge$2$2.BuiltInFictitiousFunctionClassFactory] - iArr[2]);
                    verifyPinStateManager$executeRiskChallenge$2$2.BuiltInFictitiousFunctionClassFactory++;
                }
            }
            objArr[0] = new String(cArr3);
        } catch (Exception e2) {
            throw e2;
        }
    }
}
