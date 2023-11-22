package id.dana.util;

import java.util.Locale;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u001d\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"Lid/dana/util/ContentDescriptorUtil;", "", "", "p0", "p1", "KClassImpl$Data$declaredNonStaticMembers$2", "(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class ContentDescriptorUtil {
    public static final ContentDescriptorUtil INSTANCE = new ContentDescriptorUtil();

    private ContentDescriptorUtil() {
    }

    public static String KClassImpl$Data$declaredNonStaticMembers$2(String p0, String p1) {
        Intrinsics.checkNotNullParameter(p0, "");
        Intrinsics.checkNotNullParameter(p1, "");
        String joinToString$default = CollectionsKt.joinToString$default(StringsKt.split$default((CharSequence) p1, new String[]{" "}, false, 0, 6, (Object) null), null, null, null, 0, null, new Function1<String, CharSequence>() { // from class: id.dana.util.ContentDescriptorUtil$stringToContentDescriptorId$camelCasedOptionName$1
            @Override // kotlin.jvm.functions.Function1
            public final CharSequence invoke(String str) {
                Intrinsics.checkNotNullParameter(str, "");
                Locale locale = Locale.ROOT;
                Intrinsics.checkNotNullExpressionValue(locale, "");
                String upperCase = str.toUpperCase(locale);
                Intrinsics.checkNotNullExpressionValue(upperCase, "");
                return upperCase;
            }
        }, 31, null);
        StringBuilder sb = new StringBuilder();
        sb.append(p0);
        sb.append(joinToString$default);
        return sb.toString();
    }
}
