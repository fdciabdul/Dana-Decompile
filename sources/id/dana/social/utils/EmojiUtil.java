package id.dana.social.utils;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0006\u0010\u0007J\u0015\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Lid/dana/social/utils/EmojiUtil;", "", "", "p0", "getAuthRequestContext", "(Ljava/lang/String;)Ljava/lang/String;", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class EmojiUtil {
    public static final EmojiUtil INSTANCE = new EmojiUtil();

    private EmojiUtil() {
    }

    public static String getAuthRequestContext(String p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        String obj = new StringBuilder().appendCodePoint(Integer.parseInt(p0, 16)).toString();
        Intrinsics.checkNotNullExpressionValue(obj, "");
        return obj;
    }
}
