package com.huawei.secure.android.common.ssl.hostname;

import com.huawei.secure.android.common.ssl.util.g;
import id.dana.cashier.view.InputCardNumberView;
import io.opentelemetry.semconv.resource.attributes.ResourceAttributes;
import java.security.cert.CertificateParsingException;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import java.util.regex.Pattern;
import javax.net.ssl.SSLException;
import kotlin.text.Typography;

/* loaded from: classes8.dex */
public class b {
    private static final String[] KClassImpl$Data$declaredNonStaticMembers$2;
    private static final Pattern getAuthRequestContext = Pattern.compile("^(25[0-5]|2[0-4]\\d|[0-1]?\\d?\\d)(\\.(25[0-5]|2[0-4]\\d|[0-1]?\\d?\\d)){3}$");

    static {
        String[] strArr = {"ac", "co", "com", "ed", "edu", ResourceAttributes.TelemetrySdkLanguageValues.GO, "gouv", "gov", "info", "lg", "ne", "net", "or", "org"};
        KClassImpl$Data$declaredNonStaticMembers$2 = strArr;
        Arrays.sort(strArr);
    }

    private static String[] KClassImpl$Data$declaredNonStaticMembers$2(X509Certificate x509Certificate) {
        Collection<List<?>> collection;
        LinkedList linkedList = new LinkedList();
        try {
            collection = x509Certificate.getSubjectAlternativeNames();
        } catch (CertificateParsingException e) {
            g.KClassImpl$Data$declaredNonStaticMembers$2("", "Error parsing certificate.", e);
            collection = null;
        }
        if (collection != null) {
            for (List<?> list : collection) {
                if (((Integer) list.get(0)).intValue() == 2) {
                    linkedList.add((String) list.get(1));
                }
            }
        }
        if (linkedList.isEmpty()) {
            return null;
        }
        String[] strArr = new String[linkedList.size()];
        linkedList.toArray(strArr);
        return strArr;
    }

    private static boolean PlaceComponentResult(String str) {
        return getAuthRequestContext.matcher(str).matches();
    }

    private static int getAuthRequestContext(String str) {
        int i = 0;
        for (int i2 = 0; i2 < str.length(); i2++) {
            if (str.charAt(i2) == '.') {
                i++;
            }
        }
        return i;
    }

    private static boolean MyBillsEntityDataFactory(String str) {
        int length = str.length();
        if (length < 7 || length > 9) {
            return true;
        }
        int i = length - 3;
        if (str.charAt(i) == '.') {
            return Arrays.binarySearch(KClassImpl$Data$declaredNonStaticMembers$2, str.substring(2, i)) < 0;
        }
        return true;
    }

    public static final void getAuthRequestContext(String str, X509Certificate x509Certificate, boolean z) throws SSLException {
        String[] strArr;
        String str2;
        int i;
        char[] cArr;
        char c;
        char[] cArr2;
        int i2;
        int i3;
        char c2;
        a aVar = new a(x509Certificate.getSubjectX500Principal());
        aVar.KClassImpl$Data$declaredNonStaticMembers$2 = 0;
        aVar.getAuthRequestContext = 0;
        aVar.MyBillsEntityDataFactory = 0;
        aVar.NetworkUserEntityData$$ExternalSyntheticLambda0 = 0;
        aVar.lookAheadTest = aVar.PlaceComponentResult.toCharArray();
        List emptyList = Collections.emptyList();
        String BuiltInFictitiousFunctionClassFactory = aVar.BuiltInFictitiousFunctionClassFactory();
        if (BuiltInFictitiousFunctionClassFactory != null) {
            do {
                int i4 = aVar.KClassImpl$Data$declaredNonStaticMembers$2;
                if (i4 < aVar.BuiltInFictitiousFunctionClassFactory) {
                    char c3 = aVar.lookAheadTest[i4];
                    if (c3 == '\"') {
                        int i5 = aVar.KClassImpl$Data$declaredNonStaticMembers$2 + 1;
                        aVar.KClassImpl$Data$declaredNonStaticMembers$2 = i5;
                        aVar.getAuthRequestContext = i5;
                        aVar.MyBillsEntityDataFactory = i5;
                        while (true) {
                            int i6 = aVar.KClassImpl$Data$declaredNonStaticMembers$2;
                            if (i6 != aVar.BuiltInFictitiousFunctionClassFactory) {
                                char[] cArr3 = aVar.lookAheadTest;
                                char c4 = cArr3[i6];
                                if (c4 == '\"') {
                                    aVar.KClassImpl$Data$declaredNonStaticMembers$2 = i6 + 1;
                                    while (true) {
                                        int i7 = aVar.KClassImpl$Data$declaredNonStaticMembers$2;
                                        if (i7 >= aVar.BuiltInFictitiousFunctionClassFactory || aVar.lookAheadTest[i7] != ' ') {
                                            break;
                                        }
                                        aVar.KClassImpl$Data$declaredNonStaticMembers$2 = i7 + 1;
                                    }
                                    char[] cArr4 = aVar.lookAheadTest;
                                    int i8 = aVar.getAuthRequestContext;
                                    str2 = new String(cArr4, i8, aVar.MyBillsEntityDataFactory - i8);
                                } else {
                                    if (c4 == '\\') {
                                        cArr3[aVar.MyBillsEntityDataFactory] = aVar.KClassImpl$Data$declaredNonStaticMembers$2();
                                    } else {
                                        cArr3[aVar.MyBillsEntityDataFactory] = c4;
                                    }
                                    aVar.KClassImpl$Data$declaredNonStaticMembers$2++;
                                    aVar.MyBillsEntityDataFactory++;
                                }
                            } else {
                                StringBuilder sb = new StringBuilder();
                                sb.append("Unexpected end of DN: ");
                                sb.append(aVar.PlaceComponentResult);
                                throw new IllegalStateException(sb.toString());
                            }
                        }
                    } else if (c3 == '#') {
                        int i9 = aVar.KClassImpl$Data$declaredNonStaticMembers$2;
                        if (i9 + 4 < aVar.BuiltInFictitiousFunctionClassFactory) {
                            aVar.getAuthRequestContext = i9;
                            aVar.KClassImpl$Data$declaredNonStaticMembers$2 = i9 + 1;
                            while (true) {
                                i = aVar.KClassImpl$Data$declaredNonStaticMembers$2;
                                if (i == aVar.BuiltInFictitiousFunctionClassFactory || (c = (cArr = aVar.lookAheadTest)[i]) == '+' || c == ',' || c == ';') {
                                    break;
                                } else if (c == ' ') {
                                    aVar.MyBillsEntityDataFactory = i;
                                    aVar.KClassImpl$Data$declaredNonStaticMembers$2 = i + 1;
                                    while (true) {
                                        int i10 = aVar.KClassImpl$Data$declaredNonStaticMembers$2;
                                        if (i10 >= aVar.BuiltInFictitiousFunctionClassFactory || aVar.lookAheadTest[i10] != ' ') {
                                            break;
                                        }
                                        aVar.KClassImpl$Data$declaredNonStaticMembers$2 = i10 + 1;
                                    }
                                } else {
                                    if (c >= 'A' && c <= 'F') {
                                        cArr[i] = (char) (c + InputCardNumberView.DIVIDER);
                                    }
                                    aVar.KClassImpl$Data$declaredNonStaticMembers$2 = i + 1;
                                }
                            }
                            aVar.MyBillsEntityDataFactory = i;
                            int i11 = aVar.MyBillsEntityDataFactory;
                            int i12 = aVar.getAuthRequestContext;
                            int i13 = i11 - i12;
                            if (i13 >= 5 && (i13 & 1) != 0) {
                                int i14 = i13 / 2;
                                byte[] bArr = new byte[i14];
                                int i15 = i12 + 1;
                                for (int i16 = 0; i16 < i14; i16++) {
                                    bArr[i16] = (byte) aVar.MyBillsEntityDataFactory(i15);
                                    i15 += 2;
                                }
                                str2 = new String(aVar.lookAheadTest, aVar.getAuthRequestContext, i13);
                            } else {
                                StringBuilder sb2 = new StringBuilder();
                                sb2.append("Unexpected end of DN: ");
                                sb2.append(aVar.PlaceComponentResult);
                                throw new IllegalStateException(sb2.toString());
                            }
                        } else {
                            StringBuilder sb3 = new StringBuilder();
                            sb3.append("Unexpected end of DN: ");
                            sb3.append(aVar.PlaceComponentResult);
                            throw new IllegalStateException(sb3.toString());
                        }
                    } else if (c3 == '+' || c3 == ',' || c3 == ';') {
                        str2 = "";
                    } else {
                        int i17 = aVar.KClassImpl$Data$declaredNonStaticMembers$2;
                        aVar.getAuthRequestContext = i17;
                        aVar.MyBillsEntityDataFactory = i17;
                        while (true) {
                            int i18 = aVar.KClassImpl$Data$declaredNonStaticMembers$2;
                            if (i18 >= aVar.BuiltInFictitiousFunctionClassFactory) {
                                char[] cArr5 = aVar.lookAheadTest;
                                int i19 = aVar.getAuthRequestContext;
                                str2 = new String(cArr5, i19, aVar.MyBillsEntityDataFactory - i19);
                                break;
                            }
                            cArr2 = aVar.lookAheadTest;
                            char c5 = cArr2[i18];
                            if (c5 == ' ') {
                                int i20 = aVar.MyBillsEntityDataFactory;
                                aVar.NetworkUserEntityData$$ExternalSyntheticLambda0 = i20;
                                aVar.KClassImpl$Data$declaredNonStaticMembers$2 = i18 + 1;
                                aVar.MyBillsEntityDataFactory = i20 + 1;
                                cArr2[i20] = InputCardNumberView.DIVIDER;
                                while (true) {
                                    i2 = aVar.KClassImpl$Data$declaredNonStaticMembers$2;
                                    i3 = aVar.BuiltInFictitiousFunctionClassFactory;
                                    if (i2 >= i3) {
                                        break;
                                    }
                                    char[] cArr6 = aVar.lookAheadTest;
                                    if (cArr6[i2] != ' ') {
                                        break;
                                    }
                                    int i21 = aVar.MyBillsEntityDataFactory;
                                    aVar.MyBillsEntityDataFactory = i21 + 1;
                                    cArr6[i21] = InputCardNumberView.DIVIDER;
                                    aVar.KClassImpl$Data$declaredNonStaticMembers$2 = i2 + 1;
                                }
                                if (i2 == i3 || (c2 = aVar.lookAheadTest[i2]) == ',' || c2 == '+' || c2 == ';') {
                                    break;
                                }
                            } else if (c5 == ';') {
                                break;
                            } else if (c5 == '\\') {
                                int i22 = aVar.MyBillsEntityDataFactory;
                                aVar.MyBillsEntityDataFactory = i22 + 1;
                                cArr2[i22] = aVar.KClassImpl$Data$declaredNonStaticMembers$2();
                                aVar.KClassImpl$Data$declaredNonStaticMembers$2++;
                            } else if (c5 == '+' || c5 == ',') {
                                break;
                            } else {
                                int i23 = aVar.MyBillsEntityDataFactory;
                                aVar.MyBillsEntityDataFactory = i23 + 1;
                                cArr2[i23] = c5;
                                aVar.KClassImpl$Data$declaredNonStaticMembers$2 = i18 + 1;
                            }
                        }
                        int i24 = aVar.getAuthRequestContext;
                        str2 = new String(cArr2, i24, aVar.MyBillsEntityDataFactory - i24);
                    }
                    if ("cn".equalsIgnoreCase(BuiltInFictitiousFunctionClassFactory)) {
                        if (emptyList.isEmpty()) {
                            emptyList = new ArrayList();
                        }
                        emptyList.add(str2);
                    }
                    int i25 = aVar.KClassImpl$Data$declaredNonStaticMembers$2;
                    if (i25 < aVar.BuiltInFictitiousFunctionClassFactory) {
                        char c6 = aVar.lookAheadTest[i25];
                        if (c6 != ',' && c6 != ';' && c6 != '+') {
                            StringBuilder sb4 = new StringBuilder();
                            sb4.append("Malformed DN: ");
                            sb4.append(aVar.PlaceComponentResult);
                            throw new IllegalStateException(sb4.toString());
                        }
                        aVar.KClassImpl$Data$declaredNonStaticMembers$2 = i25 + 1;
                        BuiltInFictitiousFunctionClassFactory = aVar.BuiltInFictitiousFunctionClassFactory();
                    }
                }
            } while (BuiltInFictitiousFunctionClassFactory != null);
            StringBuilder sb5 = new StringBuilder();
            sb5.append("Malformed DN: ");
            sb5.append(aVar.PlaceComponentResult);
            throw new IllegalStateException(sb5.toString());
        }
        if (emptyList.isEmpty()) {
            strArr = null;
        } else {
            strArr = new String[emptyList.size()];
            emptyList.toArray(strArr);
        }
        String[] KClassImpl$Data$declaredNonStaticMembers$22 = KClassImpl$Data$declaredNonStaticMembers$2(x509Certificate);
        Arrays.toString(strArr);
        g.PlaceComponentResult();
        Arrays.toString(KClassImpl$Data$declaredNonStaticMembers$22);
        g.PlaceComponentResult();
        LinkedList linkedList = new LinkedList();
        if (strArr != null && strArr.length > 0) {
            String str3 = strArr[0];
            if (str3 != null) {
                linkedList.add(str3);
            }
        }
        if (KClassImpl$Data$declaredNonStaticMembers$22 != null) {
            for (String str4 : KClassImpl$Data$declaredNonStaticMembers$22) {
                if (str4 != null) {
                    linkedList.add(str4);
                }
            }
        }
        if (!linkedList.isEmpty()) {
            StringBuffer stringBuffer = new StringBuffer();
            String lowerCase = str.trim().toLowerCase(Locale.ENGLISH);
            Iterator it = linkedList.iterator();
            boolean z2 = false;
            while (it.hasNext()) {
                String lowerCase2 = ((String) it.next()).toLowerCase(Locale.ENGLISH);
                stringBuffer.append(" <");
                stringBuffer.append(lowerCase2);
                stringBuffer.append(Typography.greater);
                if (it.hasNext()) {
                    stringBuffer.append(" OR");
                }
                if (lowerCase2.startsWith("*.") && lowerCase2.indexOf(46, 2) != -1 && MyBillsEntityDataFactory(lowerCase2) && !PlaceComponentResult(str)) {
                    boolean endsWith = lowerCase.endsWith(lowerCase2.substring(1));
                    if (endsWith && z) {
                        z2 = getAuthRequestContext(lowerCase) == getAuthRequestContext(lowerCase2);
                    } else {
                        z2 = endsWith;
                    }
                } else {
                    z2 = lowerCase.equals(lowerCase2);
                }
                if (z2) {
                    break;
                }
            }
            if (z2) {
                return;
            }
            StringBuilder sb6 = new StringBuilder();
            sb6.append("hostname in certificate didn't match: <");
            sb6.append(str);
            sb6.append("> !=");
            sb6.append((Object) stringBuffer);
            throw new SSLException(sb6.toString());
        }
        StringBuilder sb7 = new StringBuilder();
        sb7.append("Certificate for <");
        sb7.append(str);
        sb7.append("> doesn't contain CN or DNS subjectAlt");
        throw new SSLException(sb7.toString());
    }
}
