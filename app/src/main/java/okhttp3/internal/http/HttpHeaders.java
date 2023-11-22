package okhttp3.internal.http;

import com.google.firebase.perf.FirebasePerformance;
import java.io.EOFException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import okhttp3.Challenge;
import okhttp3.Cookie;
import okhttp3.CookieJar;
import okhttp3.Headers;
import okhttp3.HttpUrl;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.internal.Util;
import okio.Buffer;
import okio.ByteString;

/* loaded from: classes6.dex */
public final class HttpHeaders {
    private static final ByteString QUOTED_STRING_DELIMITERS = ByteString.encodeUtf8("\"\\");
    private static final ByteString TOKEN_DELIMITERS = ByteString.encodeUtf8("\t ,=");

    private HttpHeaders() {
    }

    public static long contentLength(Response response) {
        return contentLength(response.headers());
    }

    public static long contentLength(Headers headers) {
        return stringToLong(headers.get(com.google.common.net.HttpHeaders.CONTENT_LENGTH));
    }

    private static long stringToLong(String str) {
        if (str == null) {
            return -1L;
        }
        try {
            return Long.parseLong(str);
        } catch (NumberFormatException unused) {
            return -1L;
        }
    }

    public static boolean varyMatches(Response response, Headers headers, Request request) {
        for (String str : varyFields(response)) {
            if (!Util.equal(headers.values(str), request.headers(str))) {
                return false;
            }
        }
        return true;
    }

    public static boolean hasVaryAll(Response response) {
        return hasVaryAll(response.headers());
    }

    public static boolean hasVaryAll(Headers headers) {
        return varyFields(headers).contains("*");
    }

    private static Set<String> varyFields(Response response) {
        return varyFields(response.headers());
    }

    public static Set<String> varyFields(Headers headers) {
        Set<String> emptySet = Collections.emptySet();
        int size = headers.size();
        for (int i = 0; i < size; i++) {
            if (com.google.common.net.HttpHeaders.VARY.equalsIgnoreCase(headers.name(i))) {
                String value = headers.value(i);
                if (emptySet.isEmpty()) {
                    emptySet = new TreeSet<>(String.CASE_INSENSITIVE_ORDER);
                }
                for (String str : value.split(",")) {
                    emptySet.add(str.trim());
                }
            }
        }
        return emptySet;
    }

    public static Headers varyHeaders(Response response) {
        return varyHeaders(response.networkResponse().request().headers(), response.headers());
    }

    public static Headers varyHeaders(Headers headers, Headers headers2) {
        Set<String> varyFields = varyFields(headers2);
        if (varyFields.isEmpty()) {
            return new Headers.Builder().build();
        }
        Headers.Builder builder = new Headers.Builder();
        int size = headers.size();
        for (int i = 0; i < size; i++) {
            String name = headers.name(i);
            if (varyFields.contains(name)) {
                builder.add(name, headers.value(i));
            }
        }
        return builder.build();
    }

    public static List<Challenge> parseChallenges(Headers headers, String str) {
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < headers.size(); i++) {
            if (str.equalsIgnoreCase(headers.name(i))) {
                Buffer buffer = new Buffer();
                String value = headers.value(i);
                parseChallengeHeader(arrayList, buffer.PlaceComponentResult(value, 0, value.length()));
            }
        }
        return arrayList;
    }

    /* JADX WARN: Code restructure failed: missing block: B:59:0x007c, code lost:
    
        continue;
     */
    /* JADX WARN: Code restructure failed: missing block: B:60:0x007c, code lost:
    
        continue;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void parseChallengeHeader(java.util.List<okhttp3.Challenge> r8, okio.Buffer r9) {
        /*
        L0:
            r0 = 0
            r1 = r0
        L2:
            if (r1 != 0) goto Le
            skipWhitespaceAndCommas(r9)
            java.lang.String r1 = readToken(r9)
            if (r1 != 0) goto Le
            return
        Le:
            boolean r2 = skipWhitespaceAndCommas(r9)
            java.lang.String r3 = readToken(r9)
            if (r3 != 0) goto L2c
            boolean r9 = r9.lookAheadTest()
            if (r9 != 0) goto L1f
            return
        L1f:
            okhttp3.Challenge r9 = new okhttp3.Challenge
            java.util.Map r0 = java.util.Collections.emptyMap()
            r9.<init>(r1, r0)
            r8.add(r9)
            return
        L2c:
            r4 = 61
            int r5 = skipAll(r9, r4)
            boolean r6 = skipWhitespaceAndCommas(r9)
            if (r2 != 0) goto L60
            if (r6 != 0) goto L40
            boolean r2 = r9.lookAheadTest()
            if (r2 == 0) goto L60
        L40:
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            r2.append(r3)
            java.lang.String r3 = repeat(r4, r5)
            r2.append(r3)
            java.lang.String r2 = r2.toString()
            okhttp3.Challenge r3 = new okhttp3.Challenge
            java.util.Map r0 = java.util.Collections.singletonMap(r0, r2)
            r3.<init>(r1, r0)
            r8.add(r3)
            goto L0
        L60:
            java.util.LinkedHashMap r2 = new java.util.LinkedHashMap
            r2.<init>()
            int r6 = skipAll(r9, r4)
            int r5 = r5 + r6
        L6a:
            if (r3 != 0) goto L7a
            java.lang.String r3 = readToken(r9)
            boolean r5 = skipWhitespaceAndCommas(r9)
            if (r5 != 0) goto L7c
            int r5 = skipAll(r9, r4)
        L7a:
            if (r5 != 0) goto L87
        L7c:
            okhttp3.Challenge r4 = new okhttp3.Challenge
            r4.<init>(r1, r2)
            r8.add(r4)
            r1 = r3
            goto L2
        L87:
            r6 = 1
            if (r5 <= r6) goto L8b
            return
        L8b:
            boolean r6 = skipWhitespaceAndCommas(r9)
            if (r6 == 0) goto L92
            return
        L92:
            boolean r6 = r9.lookAheadTest()
            if (r6 != 0) goto La7
            r6 = 0
            byte r6 = r9.getAuthRequestContext(r6)
            r7 = 34
            if (r6 != r7) goto La7
            java.lang.String r6 = readQuotedString(r9)
            goto Lab
        La7:
            java.lang.String r6 = readToken(r9)
        Lab:
            if (r6 != 0) goto Lae
            return
        Lae:
            java.lang.Object r3 = r2.put(r3, r6)
            java.lang.String r3 = (java.lang.String) r3
            if (r3 == 0) goto Lb7
            return
        Lb7:
            boolean r3 = skipWhitespaceAndCommas(r9)
            if (r3 != 0) goto Lc4
            boolean r3 = r9.lookAheadTest()
            if (r3 != 0) goto Lc4
            return
        Lc4:
            r3 = r0
            goto L6a
        */
        throw new UnsupportedOperationException("Method not decompiled: okhttp3.internal.http.HttpHeaders.parseChallengeHeader(java.util.List, okio.Buffer):void");
    }

    private static boolean skipWhitespaceAndCommas(Buffer buffer) {
        boolean z = false;
        while (!buffer.lookAheadTest()) {
            byte authRequestContext = buffer.getAuthRequestContext(0L);
            if (authRequestContext != 44) {
                if (authRequestContext != 32 && authRequestContext != 9) {
                    break;
                }
                buffer.initRecordTimeStamp();
            } else {
                buffer.initRecordTimeStamp();
                z = true;
            }
        }
        return z;
    }

    private static int skipAll(Buffer buffer, byte b) {
        int i = 0;
        while (!buffer.lookAheadTest() && buffer.getAuthRequestContext(0L) == b) {
            i++;
            buffer.initRecordTimeStamp();
        }
        return i;
    }

    private static String readQuotedString(Buffer buffer) {
        if (buffer.initRecordTimeStamp() != 34) {
            throw new IllegalArgumentException();
        }
        Buffer buffer2 = new Buffer();
        while (true) {
            long MyBillsEntityDataFactory = buffer.MyBillsEntityDataFactory(QUOTED_STRING_DELIMITERS, 0L);
            if (MyBillsEntityDataFactory == -1) {
                return null;
            }
            if (buffer.getAuthRequestContext(MyBillsEntityDataFactory) == 34) {
                buffer2.write(buffer, MyBillsEntityDataFactory);
                buffer.initRecordTimeStamp();
                return buffer2.FragmentBottomSheetPaymentSettingBinding();
            } else if (buffer.getAuthRequestContext == MyBillsEntityDataFactory + 1) {
                return null;
            } else {
                buffer2.write(buffer, MyBillsEntityDataFactory);
                buffer.initRecordTimeStamp();
                buffer2.write(buffer, 1L);
            }
        }
    }

    private static String readToken(Buffer buffer) {
        try {
            long MyBillsEntityDataFactory = buffer.MyBillsEntityDataFactory(TOKEN_DELIMITERS, 0L);
            if (MyBillsEntityDataFactory == -1) {
                MyBillsEntityDataFactory = buffer.getAuthRequestContext;
            }
            if (MyBillsEntityDataFactory != 0) {
                return buffer.KClassImpl$Data$declaredNonStaticMembers$2(MyBillsEntityDataFactory, okio.Util.PlaceComponentResult);
            }
            return null;
        } catch (EOFException unused) {
            throw new AssertionError();
        }
    }

    private static String repeat(char c, int i) {
        char[] cArr = new char[i];
        Arrays.fill(cArr, c);
        return new String(cArr);
    }

    public static void receiveHeaders(CookieJar cookieJar, HttpUrl httpUrl, Headers headers) {
        if (cookieJar == CookieJar.NO_COOKIES) {
            return;
        }
        List<Cookie> parseAll = Cookie.parseAll(httpUrl, headers);
        if (parseAll.isEmpty()) {
            return;
        }
        cookieJar.saveFromResponse(httpUrl, parseAll);
    }

    public static boolean hasBody(Response response) {
        if (response.request().method().equals(FirebasePerformance.HttpMethod.HEAD)) {
            return false;
        }
        int code = response.code();
        return (((code >= 100 && code < 200) || code == 204 || code == 304) && contentLength(response) == -1 && !"chunked".equalsIgnoreCase(response.header(com.google.common.net.HttpHeaders.TRANSFER_ENCODING))) ? false : true;
    }

    public static int skipUntil(String str, int i, String str2) {
        while (i < str.length() && str2.indexOf(str.charAt(i)) == -1) {
            i++;
        }
        return i;
    }

    public static int skipWhitespace(String str, int i) {
        char charAt;
        while (i < str.length() && ((charAt = str.charAt(i)) == ' ' || charAt == '\t')) {
            i++;
        }
        return i;
    }

    public static int parseSeconds(String str, int i) {
        try {
            long parseLong = Long.parseLong(str);
            if (parseLong > 2147483647L) {
                return Integer.MAX_VALUE;
            }
            if (parseLong < 0) {
                return 0;
            }
            return (int) parseLong;
        } catch (NumberFormatException unused) {
            return i;
        }
    }
}
