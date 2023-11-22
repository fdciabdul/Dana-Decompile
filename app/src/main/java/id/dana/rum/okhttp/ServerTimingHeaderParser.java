package id.dana.rum.okhttp;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0005\u0018\u0000 \t2\u00020\u0001:\u0001\tB\u0007¢\u0006\u0004\b\u0007\u0010\bJ\u001b\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"Lid/dana/rum/okhttp/ServerTimingHeaderParser;", "", "", "p0", "", "PlaceComponentResult", "(Ljava/lang/String;)[Ljava/lang/String;", "<init>", "()V", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class ServerTimingHeaderParser {
    private static final String[] KClassImpl$Data$declaredNonStaticMembers$2 = new String[0];
    private static final Pattern BuiltInFictitiousFunctionClassFactory = Pattern.compile("traceparent;desc=['\"]00-([0-9a-f]{32})-([0-9a-f]{16})-01['\"]");

    public static String[] PlaceComponentResult(String p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        Matcher matcher = BuiltInFictitiousFunctionClassFactory.matcher(p0);
        if (!matcher.matches()) {
            return KClassImpl$Data$declaredNonStaticMembers$2;
        }
        String group = matcher.group(1);
        if (group == null) {
            group = "";
        }
        String group2 = matcher.group(2);
        return new String[]{group, group2 != null ? group2 : ""};
    }
}
