package com.google.zxing.client.result;

import com.google.zxing.Result;
import com.huawei.hms.framework.common.ContainerUtils;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.Map;
import java.util.regex.Pattern;
import kotlin.text.Typography;
import o.VerifyPinStateManager$executeRiskChallenge$2$2;

/* loaded from: classes7.dex */
public abstract class ResultParser {
    private static int $10 = 0;
    private static int $11 = 1;
    private static final Pattern AMPERSAND;
    private static final String BYTE_ORDER_MARK = "\ufeff";
    private static char[] BuiltInFictitiousFunctionClassFactory = null;
    private static final Pattern DIGITS;
    private static final Pattern EQUALS;
    private static int MyBillsEntityDataFactory = 0;
    private static final ResultParser[] PARSERS;
    private static int getAuthRequestContext = 1;

    static void PlaceComponentResult() {
        BuiltInFictitiousFunctionClassFactory = new char[]{35350, 35726, 35735, 35435, 35440};
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static String[] maybeWrap(String str) {
        if (!(str == null)) {
            return new String[]{str};
        }
        int i = MyBillsEntityDataFactory + 103;
        getAuthRequestContext = i % 128;
        int i2 = i % 2;
        int i3 = MyBillsEntityDataFactory + 9;
        getAuthRequestContext = i3 % 128;
        int i4 = i3 % 2;
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static int parseHexDigit(char c) {
        int i = getAuthRequestContext + 59;
        MyBillsEntityDataFactory = i % 128;
        if ((i % 2 != 0) ? c >= 'r' : c >= '0') {
            if (c <= '9') {
                int i2 = MyBillsEntityDataFactory + 23;
                getAuthRequestContext = i2 % 128;
                return i2 % 2 == 0 ? c << 'b' : c - '0';
            }
        }
        char c2 = 'a';
        if (!(c >= 'a') || c > 'f') {
            if ((c < 'A') || c > 'F') {
                try {
                    int i3 = getAuthRequestContext + 21;
                    MyBillsEntityDataFactory = i3 % 128;
                    int i4 = i3 % 2;
                    return -1;
                } catch (Exception e) {
                    throw e;
                }
            }
            c2 = 'A';
        }
        return (c - c2) + 10;
    }

    public abstract ParsedResult parse(Result result);

    static {
        PlaceComponentResult();
        PARSERS = new ResultParser[]{new BookmarkDoCoMoResultParser(), new AddressBookDoCoMoResultParser(), new EmailDoCoMoResultParser(), new AddressBookAUResultParser(), new VCardResultParser(), new BizcardResultParser(), new VEventResultParser(), new EmailAddressResultParser(), new SMTPResultParser(), new TelResultParser(), new SMSMMSResultParser(), new SMSTOMMSTOResultParser(), new GeoResultParser(), new WifiResultParser(), new URLTOResultParser(), new URIResultParser(), new ISBNResultParser(), new ProductResultParser(), new ExpandedProductResultParser(), new VINResultParser()};
        DIGITS = Pattern.compile("\\d+");
        AMPERSAND = Pattern.compile(ContainerUtils.FIELD_DELIMITER);
        EQUALS = Pattern.compile("=");
        try {
            int i = getAuthRequestContext + 65;
            MyBillsEntityDataFactory = i % 128;
            if (!(i % 2 == 0)) {
                Object obj = null;
                obj.hashCode();
            }
        } catch (Exception e) {
            throw e;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x0037, code lost:
    
        if ((r0 ? 1 : 24) != 24) goto L18;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x0039, code lost:
    
        r4 = r4.substring(1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:9:0x0020, code lost:
    
        if (r4.startsWith(com.google.zxing.client.result.ResultParser.BYTE_ORDER_MARK) != false) goto L18;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String getMassagedText(com.google.zxing.Result r4) {
        /*
            int r0 = com.google.zxing.client.result.ResultParser.MyBillsEntityDataFactory
            int r0 = r0 + 31
            int r1 = r0 % 128
            com.google.zxing.client.result.ResultParser.getAuthRequestContext = r1
            int r0 = r0 % 2
            r1 = 34
            if (r0 != 0) goto L11
            r0 = 34
            goto L13
        L11:
            r0 = 36
        L13:
            r2 = 1
            java.lang.String r3 = "\ufeff"
            if (r0 == r1) goto L23
            java.lang.String r4 = r4.getText()
            boolean r0 = r4.startsWith(r3)
            if (r0 == 0) goto L3d
            goto L39
        L23:
            java.lang.String r4 = r4.getText()
            boolean r0 = r4.startsWith(r3)
            r1 = 0
            r1.hashCode()     // Catch: java.lang.Throwable -> L48
            r1 = 24
            if (r0 == 0) goto L35
            r0 = 1
            goto L37
        L35:
            r0 = 24
        L37:
            if (r0 == r1) goto L3d
        L39:
            java.lang.String r4 = r4.substring(r2)
        L3d:
            int r0 = com.google.zxing.client.result.ResultParser.getAuthRequestContext
            int r0 = r0 + 23
            int r1 = r0 % 128
            com.google.zxing.client.result.ResultParser.MyBillsEntityDataFactory = r1
            int r0 = r0 % 2
            return r4
        L48:
            r4 = move-exception
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.zxing.client.result.ResultParser.getMassagedText(com.google.zxing.Result):java.lang.String");
    }

    public static ParsedResult parseResult(Result result) {
        try {
            int i = getAuthRequestContext + 87;
            MyBillsEntityDataFactory = i % 128;
            int i2 = i % 2;
            ResultParser[] resultParserArr = PARSERS;
            int length = resultParserArr.length;
            int i3 = 0;
            while (true) {
                Object obj = null;
                if (i3 >= length) {
                    return new TextParsedResult(result.getText(), null);
                }
                int i4 = MyBillsEntityDataFactory + 51;
                getAuthRequestContext = i4 % 128;
                int i5 = i4 % 2;
                ParsedResult parse = resultParserArr[i3].parse(result);
                if (parse != null) {
                    int i6 = getAuthRequestContext + 5;
                    MyBillsEntityDataFactory = i6 % 128;
                    if (i6 % 2 != 0) {
                        obj.hashCode();
                    }
                    int i7 = getAuthRequestContext + 77;
                    MyBillsEntityDataFactory = i7 % 128;
                    int i8 = i7 % 2;
                    return parse;
                }
                i3++;
            }
        } catch (Exception e) {
            throw e;
        }
    }

    protected static void maybeAppend(String str, StringBuilder sb) {
        int i = MyBillsEntityDataFactory + 39;
        getAuthRequestContext = i % 128;
        int i2 = i % 2;
        if (str == null) {
            return;
        }
        sb.append('\n');
        sb.append(str);
        int i3 = getAuthRequestContext + 1;
        MyBillsEntityDataFactory = i3 % 128;
        int i4 = i3 % 2;
    }

    protected static void maybeAppend(String[] strArr, StringBuilder sb) {
        int i = MyBillsEntityDataFactory + 111;
        getAuthRequestContext = i % 128;
        int i2 = i % 2;
        if (strArr == null) {
            return;
        }
        int length = strArr.length;
        int i3 = 0;
        try {
            int i4 = getAuthRequestContext + 33;
            MyBillsEntityDataFactory = i4 % 128;
            int i5 = i4 % 2;
            while (true) {
                if ((i3 < length ? '\n' : (char) 25) != '\n') {
                    return;
                }
                int i6 = getAuthRequestContext + 49;
                MyBillsEntityDataFactory = i6 % 128;
                int i7 = i6 % 2;
                String str = strArr[i3];
                sb.append('\n');
                sb.append(str);
                i3++;
            }
        } catch (Exception e) {
            throw e;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:26:0x005a, code lost:
    
        if ((r6 == ']') != false) goto L29;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x005d, code lost:
    
        if (r6 == '\\') goto L29;
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x005f, code lost:
    
        r4 = com.google.zxing.client.result.ResultParser.MyBillsEntityDataFactory + 15;
        com.google.zxing.client.result.ResultParser.getAuthRequestContext = r4 % 128;
        r4 = r4 % 2;
        r4 = true;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    protected static java.lang.String unescapeBackslash(java.lang.String r9) {
        /*
            r0 = 92
            int r1 = r9.indexOf(r0)
            if (r1 >= 0) goto L9
            return r9
        L9:
            int r2 = r9.length()
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            int r4 = r2 + (-1)
            r3.<init>(r4)
            char[] r4 = r9.toCharArray()
            r5 = 0
            r3.append(r4, r5, r1)
            r4 = 0
        L1d:
            r6 = 42
            if (r1 >= r2) goto L24
            r7 = 97
            goto L26
        L24:
            r7 = 42
        L26:
            if (r7 == r6) goto L72
            int r6 = com.google.zxing.client.result.ResultParser.MyBillsEntityDataFactory
            int r6 = r6 + 27
            int r7 = r6 % 128
            com.google.zxing.client.result.ResultParser.getAuthRequestContext = r7
            int r6 = r6 % 2
            char r6 = r9.charAt(r1)
            r7 = 74
            if (r4 != 0) goto L3d
            r4 = 83
            goto L3f
        L3d:
            r4 = 74
        L3f:
            r8 = 1
            if (r4 == r7) goto L6b
            int r4 = com.google.zxing.client.result.ResultParser.getAuthRequestContext
            int r4 = r4 + 25
            int r7 = r4 % 128
            com.google.zxing.client.result.ResultParser.MyBillsEntityDataFactory = r7
            int r4 = r4 % 2
            if (r4 == 0) goto L50
            r4 = 0
            goto L51
        L50:
            r4 = 1
        L51:
            if (r4 == r8) goto L5d
            r4 = 93
            if (r6 != r4) goto L59
            r4 = 1
            goto L5a
        L59:
            r4 = 0
        L5a:
            if (r4 == 0) goto L6b
            goto L5f
        L5d:
            if (r6 != r0) goto L6b
        L5f:
            int r4 = com.google.zxing.client.result.ResultParser.MyBillsEntityDataFactory
            int r4 = r4 + 15
            int r6 = r4 % 128
            com.google.zxing.client.result.ResultParser.getAuthRequestContext = r6
            int r4 = r4 % 2
            r4 = 1
            goto L6f
        L6b:
            r3.append(r6)
            r4 = 0
        L6f:
            int r1 = r1 + 1
            goto L1d
        L72:
            java.lang.String r9 = r3.toString()
            int r0 = com.google.zxing.client.result.ResultParser.MyBillsEntityDataFactory
            int r0 = r0 + 95
            int r1 = r0 % 128
            com.google.zxing.client.result.ResultParser.getAuthRequestContext = r1
            int r0 = r0 % 2
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.zxing.client.result.ResultParser.unescapeBackslash(java.lang.String):java.lang.String");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Code restructure failed: missing block: B:10:0x0021, code lost:
    
        if (r5 == r1) goto L16;
     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x002a, code lost:
    
        if (r5 == r4.length()) goto L16;
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x0037, code lost:
    
        if (com.google.zxing.client.result.ResultParser.DIGITS.matcher(r4).matches() == false) goto L19;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x0039, code lost:
    
        r4 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x003b, code lost:
    
        r4 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x003c, code lost:
    
        if (r4 == false) goto L22;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x003f, code lost:
    
        r4 = com.google.zxing.client.result.ResultParser.MyBillsEntityDataFactory + 11;
        com.google.zxing.client.result.ResultParser.getAuthRequestContext = r4 % 128;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x004b, code lost:
    
        if ((r4 % 2) != 0) goto L26;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x004d, code lost:
    
        r4 = ',';
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x0050, code lost:
    
        r4 = 'I';
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x0052, code lost:
    
        if (r4 == 'I') goto L32;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x0054, code lost:
    
        r2.hashCode();
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x0057, code lost:
    
        return true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x005a, code lost:
    
        return true;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static boolean isStringOfDigits(java.lang.CharSequence r4, int r5) {
        /*
            r0 = 0
            if (r4 == 0) goto L5b
            int r1 = com.google.zxing.client.result.ResultParser.getAuthRequestContext
            int r1 = r1 + 11
            int r2 = r1 % 128
            com.google.zxing.client.result.ResultParser.MyBillsEntityDataFactory = r2
            int r1 = r1 % 2
            if (r5 <= 0) goto L5b
            int r1 = com.google.zxing.client.result.ResultParser.MyBillsEntityDataFactory
            int r1 = r1 + 115
            int r2 = r1 % 128
            com.google.zxing.client.result.ResultParser.getAuthRequestContext = r2
            int r1 = r1 % 2
            r2 = 0
            if (r1 != 0) goto L26
            int r1 = r4.length()     // Catch: java.lang.Exception -> L66
            int r3 = r2.length     // Catch: java.lang.Throwable -> L24
            if (r5 != r1) goto L5b
            goto L2c
        L24:
            r4 = move-exception
            throw r4
        L26:
            int r1 = r4.length()
            if (r5 != r1) goto L5b
        L2c:
            java.util.regex.Pattern r5 = com.google.zxing.client.result.ResultParser.DIGITS
            java.util.regex.Matcher r4 = r5.matcher(r4)
            boolean r4 = r4.matches()
            r5 = 1
            if (r4 == 0) goto L3b
            r4 = 0
            goto L3c
        L3b:
            r4 = 1
        L3c:
            if (r4 == 0) goto L3f
            goto L5b
        L3f:
            int r4 = com.google.zxing.client.result.ResultParser.MyBillsEntityDataFactory     // Catch: java.lang.Exception -> L68
            int r4 = r4 + 11
            int r0 = r4 % 128
            com.google.zxing.client.result.ResultParser.getAuthRequestContext = r0     // Catch: java.lang.Exception -> L68
            int r4 = r4 % 2
            r0 = 73
            if (r4 != 0) goto L50
            r4 = 44
            goto L52
        L50:
            r4 = 73
        L52:
            if (r4 == r0) goto L5a
            r2.hashCode()     // Catch: java.lang.Throwable -> L58
            return r5
        L58:
            r4 = move-exception
            throw r4
        L5a:
            return r5
        L5b:
            int r4 = com.google.zxing.client.result.ResultParser.getAuthRequestContext     // Catch: java.lang.Exception -> L68
            int r4 = r4 + 19
            int r5 = r4 % 128
            com.google.zxing.client.result.ResultParser.MyBillsEntityDataFactory = r5     // Catch: java.lang.Exception -> L66
            int r4 = r4 % 2
            return r0
        L66:
            r4 = move-exception
            throw r4
        L68:
            r4 = move-exception
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.zxing.client.result.ResultParser.isStringOfDigits(java.lang.CharSequence, int):boolean");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static boolean isSubstringOfDigits(CharSequence charSequence, int i, int i2) {
        int i3 = MyBillsEntityDataFactory + 27;
        getAuthRequestContext = i3 % 128;
        int i4 = i3 % 2;
        if (charSequence != null) {
            if (!(i2 <= 0)) {
                int i5 = i2 + i;
                if ((charSequence.length() >= i5 ? '8' : 'O') != 'O') {
                    int i6 = getAuthRequestContext + 43;
                    MyBillsEntityDataFactory = i6 % 128;
                    int i7 = i6 % 2;
                    try {
                        if (DIGITS.matcher(charSequence.subSequence(i, i5)).matches()) {
                            return true;
                        }
                    } catch (Exception e) {
                        throw e;
                    }
                }
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Code restructure failed: missing block: B:11:0x0024, code lost:
    
        if ((r0 < 0 ? 'S' : '6') != 'S') goto L12;
     */
    /* JADX WARN: Code restructure failed: missing block: B:12:0x0026, code lost:
    
        r1 = new java.util.HashMap(3);
     */
    /* JADX WARN: Code restructure failed: missing block: B:13:0x002c, code lost:
    
        r6 = com.google.zxing.client.result.ResultParser.AMPERSAND.split(r6.substring(r0 + 1));
        r0 = r6.length;
     */
    /* JADX WARN: Code restructure failed: missing block: B:14:0x0039, code lost:
    
        r2 = com.google.zxing.client.result.ResultParser.MyBillsEntityDataFactory + 39;
        com.google.zxing.client.result.ResultParser.getAuthRequestContext = r2 % 128;
        r2 = r2 % 2;
        r4 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x0045, code lost:
    
        if (r4 >= r0) goto L17;
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x0047, code lost:
    
        r5 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x0049, code lost:
    
        r5 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x004a, code lost:
    
        if (r5 == false) goto L20;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x004c, code lost:
    
        return r1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x004d, code lost:
    
        appendKeyValue(r6[r4], r1);
        r4 = r4 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x0055, code lost:
    
        r6 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x0056, code lost:
    
        throw r6;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x0057, code lost:
    
        r0 = com.google.zxing.client.result.ResultParser.getAuthRequestContext + 99;
        com.google.zxing.client.result.ResultParser.MyBillsEntityDataFactory = r0 % 128;
        r0 = r0 % 2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x0062, code lost:
    
        return null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:5:0x0012, code lost:
    
        if (r0 < 0) goto L23;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.util.Map<java.lang.String, java.lang.String> parseNameValuePairs(java.lang.String r6) {
        /*
            int r0 = com.google.zxing.client.result.ResultParser.getAuthRequestContext
            int r0 = r0 + 95
            int r1 = r0 % 128
            com.google.zxing.client.result.ResultParser.MyBillsEntityDataFactory = r1
            int r0 = r0 % 2
            if (r0 == 0) goto L15
            r0 = 89
            int r0 = r6.indexOf(r0)
            if (r0 >= 0) goto L26
            goto L57
        L15:
            r0 = 63
            int r0 = r6.indexOf(r0)
            r1 = 83
            if (r0 >= 0) goto L22
            r2 = 83
            goto L24
        L22:
            r2 = 54
        L24:
            if (r2 == r1) goto L57
        L26:
            java.util.HashMap r1 = new java.util.HashMap
            r2 = 3
            r1.<init>(r2)
            java.util.regex.Pattern r2 = com.google.zxing.client.result.ResultParser.AMPERSAND     // Catch: java.lang.Exception -> L55
            r3 = 1
            int r0 = r0 + r3
            java.lang.String r6 = r6.substring(r0)     // Catch: java.lang.Exception -> L55
            java.lang.String[] r6 = r2.split(r6)     // Catch: java.lang.Exception -> L55
            int r0 = r6.length     // Catch: java.lang.Exception -> L55
            int r2 = com.google.zxing.client.result.ResultParser.MyBillsEntityDataFactory
            int r2 = r2 + 39
            int r4 = r2 % 128
            com.google.zxing.client.result.ResultParser.getAuthRequestContext = r4
            int r2 = r2 % 2
            r2 = 0
            r4 = 0
        L45:
            if (r4 >= r0) goto L49
            r5 = 0
            goto L4a
        L49:
            r5 = 1
        L4a:
            if (r5 == 0) goto L4d
            return r1
        L4d:
            r5 = r6[r4]
            appendKeyValue(r5, r1)
            int r4 = r4 + 1
            goto L45
        L55:
            r6 = move-exception
            throw r6
        L57:
            r6 = 0
            int r0 = com.google.zxing.client.result.ResultParser.getAuthRequestContext
            int r0 = r0 + 99
            int r1 = r0 % 128
            com.google.zxing.client.result.ResultParser.MyBillsEntityDataFactory = r1
            int r0 = r0 % 2
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.zxing.client.result.ResultParser.parseNameValuePairs(java.lang.String):java.util.Map");
    }

    private static void appendKeyValue(CharSequence charSequence, Map<String, String> map) {
        int i = getAuthRequestContext + 43;
        MyBillsEntityDataFactory = i % 128;
        int i2 = i % 2;
        try {
            try {
                String[] split = EQUALS.split(charSequence, 2);
                if ((split.length == 2 ? (char) 17 : '*') != '*') {
                    try {
                        map.put(split[0], urlDecode(split[1]));
                    } catch (IllegalArgumentException unused) {
                        return;
                    }
                }
                int i3 = MyBillsEntityDataFactory + 13;
                getAuthRequestContext = i3 % 128;
                int i4 = i3 % 2;
            } catch (Exception e) {
                throw e;
            }
        } catch (Exception e2) {
            throw e2;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String urlDecode(String str) {
        String intern;
        int i = MyBillsEntityDataFactory + 31;
        getAuthRequestContext = i % 128;
        try {
            if ((i % 2 == 0 ? '4' : '7') != '4') {
                Object[] objArr = new Object[1];
                a(new int[]{0, 5, 188, 0}, false, new byte[]{1, 1, 0, 1, 1}, objArr);
                intern = ((String) objArr[0]).intern();
            } else {
                Object[] objArr2 = new Object[1];
                a(new int[]{0, 5, 188, 0}, false, new byte[]{1, 1, 0, 1, 1}, objArr2);
                intern = ((String) objArr2[0]).intern();
            }
            String decode = URLDecoder.decode(str, intern);
            int i2 = getAuthRequestContext + 7;
            MyBillsEntityDataFactory = i2 % 128;
            if ((i2 % 2 != 0 ? 'N' : '\b') != 'N') {
                return decode;
            }
            Object obj = null;
            obj.hashCode();
            return decode;
        } catch (UnsupportedEncodingException e) {
            throw new IllegalStateException(e);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String[] matchPrefixedField(String str, String str2, char c, boolean z) {
        try {
            int length = str2.length();
            Object obj = null;
            ArrayList arrayList = null;
            int i = 0;
            while (true) {
                if ((i < length ? (char) 27 : '2') == '2') {
                    break;
                }
                int indexOf = str2.indexOf(str, i);
                if ((indexOf >= 0 ? 'E' : 'R') != 'E') {
                    break;
                }
                int i2 = MyBillsEntityDataFactory + 73;
                getAuthRequestContext = i2 % 128;
                int i3 = i2 % 2;
                int length2 = indexOf + str.length();
                ArrayList arrayList2 = arrayList;
                boolean z2 = true;
                int i4 = length2;
                while (true) {
                    if ((z2 ? 'I' : 'H') != 'H') {
                        int indexOf2 = str2.indexOf(c, i4);
                        if (indexOf2 < 0) {
                            int i5 = getAuthRequestContext + 57;
                            MyBillsEntityDataFactory = i5 % 128;
                            if (i5 % 2 != 0) {
                                i4 = str2.length();
                                obj.hashCode();
                            } else {
                                i4 = str2.length();
                            }
                        } else {
                            try {
                                if (!(countPrecedingBackslashes(str2, indexOf2) % 2 == 0)) {
                                    i4 = indexOf2 + 1;
                                } else {
                                    if (arrayList2 == null) {
                                        arrayList2 = new ArrayList(3);
                                    }
                                    String unescapeBackslash = unescapeBackslash(str2.substring(length2, indexOf2));
                                    if (z) {
                                        int i6 = MyBillsEntityDataFactory + 71;
                                        getAuthRequestContext = i6 % 128;
                                        int i7 = i6 % 2;
                                        unescapeBackslash = unescapeBackslash.trim();
                                        int i8 = MyBillsEntityDataFactory + 59;
                                        getAuthRequestContext = i8 % 128;
                                        int i9 = i8 % 2;
                                    }
                                    if (!unescapeBackslash.isEmpty()) {
                                        int i10 = getAuthRequestContext + 35;
                                        MyBillsEntityDataFactory = i10 % 128;
                                        if (!(i10 % 2 == 0)) {
                                            arrayList2.add(unescapeBackslash);
                                            obj.hashCode();
                                        } else {
                                            arrayList2.add(unescapeBackslash);
                                        }
                                        int i11 = MyBillsEntityDataFactory + 21;
                                        getAuthRequestContext = i11 % 128;
                                        int i12 = i11 % 2;
                                    }
                                    i4 = indexOf2 + 1;
                                }
                            } catch (Exception e) {
                                throw e;
                            }
                        }
                        z2 = false;
                    }
                }
                i = i4;
                arrayList = arrayList2;
            }
            if ((arrayList != null ? Typography.amp : 'H') == '&') {
                int i13 = getAuthRequestContext + 13;
                MyBillsEntityDataFactory = i13 % 128;
                int i14 = i13 % 2;
                if (!arrayList.isEmpty()) {
                    return (String[]) arrayList.toArray(new String[arrayList.size()]);
                }
            }
            return null;
        } catch (Exception e2) {
            throw e2;
        }
    }

    private static int countPrecedingBackslashes(CharSequence charSequence, int i) {
        int i2 = getAuthRequestContext + 29;
        MyBillsEntityDataFactory = i2 % 128;
        int i3 = i2 % 2;
        int i4 = MyBillsEntityDataFactory + 15;
        getAuthRequestContext = i4 % 128;
        int i5 = i4 % 2;
        int i6 = 0;
        for (int i7 = i - 1; i7 >= 0; i7--) {
            try {
                if (!(charSequence.charAt(i7) == '\\')) {
                    break;
                }
                i6++;
            } catch (Exception e) {
                throw e;
            }
        }
        return i6;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String matchSinglePrefixedField(String str, String str2, char c, boolean z) {
        int i = getAuthRequestContext + 21;
        MyBillsEntityDataFactory = i % 128;
        int i2 = i % 2;
        String[] matchPrefixedField = matchPrefixedField(str, str2, c, z);
        if ((matchPrefixedField != null ? Typography.less : (char) 21) != '<') {
            int i3 = getAuthRequestContext + 57;
            MyBillsEntityDataFactory = i3 % 128;
            boolean z2 = i3 % 2 != 0;
            Object[] objArr = null;
            if (z2) {
                int length = objArr.length;
            }
            return null;
        }
        return matchPrefixedField[0];
    }

    private static void a(int[] iArr, boolean z, byte[] bArr, Object[] objArr) {
        VerifyPinStateManager$executeRiskChallenge$2$2 verifyPinStateManager$executeRiskChallenge$2$2 = new VerifyPinStateManager$executeRiskChallenge$2$2();
        int i = iArr[0];
        int i2 = iArr[1];
        int i3 = iArr[2];
        int i4 = iArr[3];
        char[] cArr = BuiltInFictitiousFunctionClassFactory;
        if (cArr != null) {
            int length = cArr.length;
            char[] cArr2 = new char[length];
            int i5 = 0;
            while (i5 < length) {
                cArr2[i5] = (char) (cArr[i5] ^ 5097613533456403102L);
                i5++;
                try {
                    int i6 = $11 + 15;
                    $10 = i6 % 128;
                    int i7 = i6 % 2;
                } catch (Exception e) {
                    throw e;
                }
            }
            int i8 = $10 + 65;
            $11 = i8 % 128;
            int i9 = i8 % 2;
            cArr = cArr2;
        }
        char[] cArr3 = new char[i2];
        System.arraycopy(cArr, i, cArr3, 0, i2);
        if (bArr != null) {
            char[] cArr4 = new char[i2];
            verifyPinStateManager$executeRiskChallenge$2$2.BuiltInFictitiousFunctionClassFactory = 0;
            char c = 0;
            while (true) {
                if ((verifyPinStateManager$executeRiskChallenge$2$2.BuiltInFictitiousFunctionClassFactory < i2 ? 'N' : 'O') == 'O') {
                    break;
                }
                if ((bArr[verifyPinStateManager$executeRiskChallenge$2$2.BuiltInFictitiousFunctionClassFactory] == 1 ? ';' : (char) 14) != ';') {
                    cArr4[verifyPinStateManager$executeRiskChallenge$2$2.BuiltInFictitiousFunctionClassFactory] = (char) ((cArr3[verifyPinStateManager$executeRiskChallenge$2$2.BuiltInFictitiousFunctionClassFactory] * 2) - c);
                } else {
                    cArr4[verifyPinStateManager$executeRiskChallenge$2$2.BuiltInFictitiousFunctionClassFactory] = (char) (((cArr3[verifyPinStateManager$executeRiskChallenge$2$2.BuiltInFictitiousFunctionClassFactory] * 2) + 1) - c);
                }
                c = cArr4[verifyPinStateManager$executeRiskChallenge$2$2.BuiltInFictitiousFunctionClassFactory];
                verifyPinStateManager$executeRiskChallenge$2$2.BuiltInFictitiousFunctionClassFactory++;
            }
            cArr3 = cArr4;
        }
        if (i4 > 0) {
            char[] cArr5 = new char[i2];
            System.arraycopy(cArr3, 0, cArr5, 0, i2);
            int i10 = i2 - i4;
            System.arraycopy(cArr5, 0, cArr3, i10, i4);
            System.arraycopy(cArr5, i4, cArr3, 0, i10);
        }
        if (z) {
            char[] cArr6 = new char[i2];
            verifyPinStateManager$executeRiskChallenge$2$2.BuiltInFictitiousFunctionClassFactory = 0;
            while (true) {
                if (verifyPinStateManager$executeRiskChallenge$2$2.BuiltInFictitiousFunctionClassFactory >= i2) {
                    break;
                }
                cArr6[verifyPinStateManager$executeRiskChallenge$2$2.BuiltInFictitiousFunctionClassFactory] = cArr3[(i2 - verifyPinStateManager$executeRiskChallenge$2$2.BuiltInFictitiousFunctionClassFactory) - 1];
                verifyPinStateManager$executeRiskChallenge$2$2.BuiltInFictitiousFunctionClassFactory++;
            }
            cArr3 = cArr6;
        }
        if (i3 > 0) {
            verifyPinStateManager$executeRiskChallenge$2$2.BuiltInFictitiousFunctionClassFactory = 0;
            int i11 = $11 + 113;
            $10 = i11 % 128;
            int i12 = i11 % 2;
            while (verifyPinStateManager$executeRiskChallenge$2$2.BuiltInFictitiousFunctionClassFactory < i2) {
                int i13 = $10 + 67;
                $11 = i13 % 128;
                int i14 = i13 % 2;
                cArr3[verifyPinStateManager$executeRiskChallenge$2$2.BuiltInFictitiousFunctionClassFactory] = (char) (cArr3[verifyPinStateManager$executeRiskChallenge$2$2.BuiltInFictitiousFunctionClassFactory] - iArr[2]);
                verifyPinStateManager$executeRiskChallenge$2$2.BuiltInFictitiousFunctionClassFactory++;
            }
        }
        objArr[0] = new String(cArr3);
    }
}
