package zipkin2.internal;

/* loaded from: classes6.dex */
public final class JsonEscaper {
    private static final String[] MyBillsEntityDataFactory = new String[128];

    /* JADX WARN: Removed duplicated region for block: B:19:0x002a  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0036  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.CharSequence PlaceComponentResult(java.lang.CharSequence r6) {
        /*
            int r0 = r6.length()
            if (r0 != 0) goto L7
            return r6
        L7:
            r1 = 0
            r2 = 0
            r3 = 0
        La:
            if (r2 >= r0) goto L43
            char r4 = r6.charAt(r2)
            r5 = 128(0x80, float:1.794E-43)
            if (r4 >= r5) goto L1b
            java.lang.String[] r5 = zipkin2.internal.JsonEscaper.MyBillsEntityDataFactory
            r4 = r5[r4]
            if (r4 != 0) goto L28
            goto L40
        L1b:
            r5 = 8232(0x2028, float:1.1535E-41)
            if (r4 != r5) goto L22
            java.lang.String r4 = "\\u2028"
            goto L28
        L22:
            r5 = 8233(0x2029, float:1.1537E-41)
            if (r4 != r5) goto L40
            java.lang.String r4 = "\\u2029"
        L28:
            if (r3 >= r2) goto L34
            if (r1 != 0) goto L31
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>(r0)
        L31:
            r1.append(r6, r3, r2)
        L34:
            if (r1 != 0) goto L3b
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>(r0)
        L3b:
            r1.append(r4)
            int r3 = r2 + 1
        L40:
            int r2 = r2 + 1
            goto La
        L43:
            if (r1 != 0) goto L46
            return r6
        L46:
            if (r3 >= r0) goto L4b
            r1.append(r6, r3, r0)
        L4b:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: zipkin2.internal.JsonEscaper.PlaceComponentResult(java.lang.CharSequence):java.lang.CharSequence");
    }

    static {
        for (int i = 0; i <= 31; i++) {
            MyBillsEntityDataFactory[i] = String.format("\\u%04x", Integer.valueOf(i));
        }
        String[] strArr = MyBillsEntityDataFactory;
        strArr[34] = "\\\"";
        strArr[92] = "\\\\";
        strArr[9] = "\\t";
        strArr[8] = "\\b";
        strArr[10] = "\\n";
        strArr[13] = "\\r";
        strArr[12] = "\\f";
    }

    public static int getAuthRequestContext(CharSequence charSequence) {
        int BuiltInFictitiousFunctionClassFactory;
        int length = charSequence.length();
        boolean z = true;
        int i = 0;
        for (int i2 = 0; i2 < length; i2++) {
            char charAt = charSequence.charAt(i2);
            if (charAt == 8232 || charAt == 8233) {
                i += 5;
            } else if (charAt >= 128) {
                z = false;
            } else {
                String str = MyBillsEntityDataFactory[charAt];
                if (str != null) {
                    i += str.length() - 1;
                }
            }
        }
        if (z) {
            BuiltInFictitiousFunctionClassFactory = charSequence.length();
        } else {
            BuiltInFictitiousFunctionClassFactory = WriteBuffer.BuiltInFictitiousFunctionClassFactory(charSequence);
        }
        return BuiltInFictitiousFunctionClassFactory + i;
    }
}
