package com.alibaba.jsi.standard.java;

import com.google.common.base.Ascii;
import java.util.regex.Pattern;

/* loaded from: classes6.dex */
public class JSRuntimeException extends RuntimeException {
    public static final byte[] PlaceComponentResult = {42, -75, 2, Ascii.US, -11, 19, -23, -53, 60, -13, 11, -9, -59, 35, Ascii.US, -21, 0, 6, -25, Ascii.FS, -19, 0, 0, -34, 37, -9, 6, -10, 7, 4};
    public static final int getAuthRequestContext = 125;
    private static final Pattern kJSStackTracePatternV8 = Pattern.compile("^\\s*at ([^\\s]+) \\((.*):(\\d+):(\\d+)\\)$");
    private static final Pattern kJSStackTracePatternV8_2 = Pattern.compile("^\\s*at (.*):(\\d+):(\\d+)$");

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Removed duplicated region for block: B:30:0x00c0  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x00d9  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:32:0x00d9 -> B:33:0x00e1). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public JSRuntimeException(com.alibaba.jsi.standard.JSContext r13, com.alibaba.jsi.standard.js.JSException r14) {
        /*
            Method dump skipped, instructions count: 233
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.jsi.standard.java.JSRuntimeException.<init>(com.alibaba.jsi.standard.JSContext, com.alibaba.jsi.standard.js.JSException):void");
    }
}
