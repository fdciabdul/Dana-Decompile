package com.splunk.rum;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* loaded from: classes8.dex */
class ServerTimingHeaderParser {
    private static final String[] PlaceComponentResult = new String[0];
    private static final Pattern BuiltInFictitiousFunctionClassFactory = Pattern.compile("traceparent;desc=['\"]00-([0-9a-f]{32})-([0-9a-f]{16})-01['\"]");

    ServerTimingHeaderParser() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String[] PlaceComponentResult(String str) {
        if (str == null) {
            return PlaceComponentResult;
        }
        Matcher matcher = BuiltInFictitiousFunctionClassFactory.matcher(str);
        if (!matcher.matches()) {
            return PlaceComponentResult;
        }
        return new String[]{matcher.group(1), matcher.group(2)};
    }
}
