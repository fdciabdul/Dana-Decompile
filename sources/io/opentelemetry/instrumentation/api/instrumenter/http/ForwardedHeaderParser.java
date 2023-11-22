package io.opentelemetry.instrumentation.api.instrumenter.http;

import javax.annotation.Nullable;

/* loaded from: classes9.dex */
final class ForwardedHeaderParser {
    /* JADX INFO: Access modifiers changed from: package-private */
    @Nullable
    public static String extractProtoFromForwardedHeader(String str) {
        int i;
        int indexOf = str.toLowerCase().indexOf("proto=");
        if (indexOf >= 0 && (i = indexOf + 6) < str.length() - 1) {
            return extractProto(str, i);
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Nullable
    public static String extractProtoFromForwardedProtoHeader(String str) {
        return extractProto(str, 0);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Nullable
    public static String extractClientIpFromForwardedHeader(String str) {
        int i;
        int indexOf = str.toLowerCase().indexOf("for=");
        if (indexOf >= 0 && (i = indexOf + 4) < str.length() - 1) {
            return extractIpAddress(str, i);
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Nullable
    public static String extractClientIpFromForwardedForHeader(String str) {
        return extractIpAddress(str, 0);
    }

    /* JADX WARN: Code restructure failed: missing block: B:18:0x002d, code lost:
    
        return null;
     */
    @javax.annotation.Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static java.lang.String extractProto(java.lang.String r5, int r6) {
        /*
        L0:
            int r0 = r5.length()
            r1 = 0
            if (r0 != r6) goto L8
            return r1
        L8:
            char r0 = r5.charAt(r6)
            r2 = 34
            if (r0 != r2) goto L13
            int r6 = r6 + 1
            goto L0
        L13:
            r0 = r6
        L14:
            int r3 = r5.length()
            if (r0 >= r3) goto L33
            char r3 = r5.charAt(r0)
            r4 = 44
            if (r3 == r4) goto L2b
            r4 = 59
            if (r3 == r4) goto L2b
            if (r3 == r2) goto L2b
            int r0 = r0 + 1
            goto L14
        L2b:
            if (r0 != r6) goto L2e
            return r1
        L2e:
            java.lang.String r5 = r5.substring(r6, r0)
            return r5
        L33:
            java.lang.String r5 = r5.substring(r6)
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: io.opentelemetry.instrumentation.api.instrumenter.http.ForwardedHeaderParser.extractProto(java.lang.String, int):java.lang.String");
    }

    /* JADX WARN: Code restructure failed: missing block: B:31:0x0053, code lost:
    
        return null;
     */
    @javax.annotation.Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static java.lang.String extractIpAddress(java.lang.String r7, int r8) {
        /*
        L0:
            int r0 = r7.length()
            r1 = 0
            if (r0 != r8) goto L8
            return r1
        L8:
            char r0 = r7.charAt(r8)
            r2 = 34
            if (r0 != r2) goto L13
            int r8 = r8 + 1
            goto L0
        L13:
            char r0 = r7.charAt(r8)
            r3 = 91
            r4 = 1
            if (r0 != r3) goto L2c
            int r8 = r8 + r4
            r0 = 93
            int r0 = r7.indexOf(r0, r8)
            r2 = -1
            if (r0 != r2) goto L27
            return r1
        L27:
            java.lang.String r7 = r7.substring(r8, r0)
            return r7
        L2c:
            r0 = 0
            r3 = r8
        L2e:
            int r5 = r7.length()
            if (r3 >= r5) goto L59
            char r5 = r7.charAt(r3)
            r6 = 46
            if (r5 != r6) goto L3e
            r0 = 1
            goto L4e
        L3e:
            r6 = 44
            if (r5 == r6) goto L51
            r6 = 59
            if (r5 == r6) goto L51
            if (r5 == r2) goto L51
            if (r0 == 0) goto L4e
            r6 = 58
            if (r5 == r6) goto L51
        L4e:
            int r3 = r3 + 1
            goto L2e
        L51:
            if (r3 != r8) goto L54
            return r1
        L54:
            java.lang.String r7 = r7.substring(r8, r3)
            return r7
        L59:
            java.lang.String r7 = r7.substring(r8)
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: io.opentelemetry.instrumentation.api.instrumenter.http.ForwardedHeaderParser.extractIpAddress(java.lang.String, int):java.lang.String");
    }

    private ForwardedHeaderParser() {
    }
}
