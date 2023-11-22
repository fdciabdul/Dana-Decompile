package id.dana.utils;

import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.text.Regex;

@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0006\u0010\u0007J\u001b\u0010\u0004\u001a\u0004\u0018\u00010\u00022\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0007¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Lid/dana/utils/RegexUtil;", "", "", "p0", "getAuthRequestContext", "(Ljava/lang/String;)Ljava/lang/String;", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class RegexUtil {
    public static final RegexUtil INSTANCE = new RegexUtil();

    private RegexUtil() {
    }

    @JvmStatic
    public static final String getAuthRequestContext(String p0) {
        if (p0 != null) {
            return new Regex("[0-9]").replace(p0, "*");
        }
        return null;
    }
}
