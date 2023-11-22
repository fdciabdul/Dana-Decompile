package id.dana.core.ui.util;

import android.content.Context;
import android.text.TextUtils;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u000b\u0010\fJ'\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004H\u0007¢\u0006\u0004\b\u0007\u0010\bJ!\u0010\u0007\u001a\u00020\t2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u0007\u0010\n"}, d2 = {"Lid/dana/core/ui/util/ResourceUtil;", "", "Landroid/content/Context;", "p0", "", "p1", "p2", "KClassImpl$Data$declaredNonStaticMembers$2", "(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;", "", "(Landroid/content/Context;Ljava/lang/String;)I", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class ResourceUtil {
    public static final ResourceUtil INSTANCE = new ResourceUtil();

    private ResourceUtil() {
    }

    @JvmStatic
    public static final String KClassImpl$Data$declaredNonStaticMembers$2(Context p0, String p1, String p2) {
        Intrinsics.checkNotNullParameter(p0, "");
        Intrinsics.checkNotNullParameter(p1, "");
        Intrinsics.checkNotNullParameter(p2, "");
        String str = p1;
        if (TextUtils.isEmpty(str)) {
            return p1;
        }
        String replace = new Regex(" ").replace(str, "_");
        Locale locale = Locale.ROOT;
        Intrinsics.checkNotNullExpressionValue(locale, "");
        String lowerCase = replace.toLowerCase(locale);
        Intrinsics.checkNotNullExpressionValue(lowerCase, "");
        int KClassImpl$Data$declaredNonStaticMembers$2 = KClassImpl$Data$declaredNonStaticMembers$2(p0, lowerCase);
        if (KClassImpl$Data$declaredNonStaticMembers$2 > 0) {
            String string = p0.getString(KClassImpl$Data$declaredNonStaticMembers$2);
            Intrinsics.checkNotNullExpressionValue(string, "");
            return string;
        }
        return p2;
    }

    public static int KClassImpl$Data$declaredNonStaticMembers$2(Context p0, String p1) {
        if (p0 == null || TextUtils.isEmpty(p1)) {
            return 0;
        }
        return p0.getResources().getIdentifier(p1, "string", p0.getPackageName());
    }
}
