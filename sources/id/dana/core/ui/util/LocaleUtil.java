package id.dana.core.ui.util;

import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\n\u0010\u000bJ\r\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0011\u0010\u0005\u001a\u0004\u0018\u00010\u0002H\u0007¢\u0006\u0004\b\u0005\u0010\u0004J\r\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bR\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0003\u0010\t"}, d2 = {"Lid/dana/core/ui/util/LocaleUtil;", "", "Ljava/util/Locale;", "KClassImpl$Data$declaredNonStaticMembers$2", "()Ljava/util/Locale;", "BuiltInFictitiousFunctionClassFactory", "", "PlaceComponentResult", "()Z", "Ljava/util/Locale;", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class LocaleUtil {
    public static final LocaleUtil INSTANCE = new LocaleUtil();

    /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
    private static Locale BuiltInFictitiousFunctionClassFactory;

    private LocaleUtil() {
    }

    @JvmStatic
    public static final Locale BuiltInFictitiousFunctionClassFactory() {
        if (BuiltInFictitiousFunctionClassFactory == null) {
            BuiltInFictitiousFunctionClassFactory = new Locale("in", "ID");
        }
        return BuiltInFictitiousFunctionClassFactory;
    }

    public static Locale KClassImpl$Data$declaredNonStaticMembers$2() {
        Locale locale = Locale.getDefault();
        Intrinsics.checkNotNullExpressionValue(locale, "");
        return locale;
    }

    public static boolean PlaceComponentResult() {
        Locale locale = Locale.getDefault();
        Intrinsics.checkNotNullExpressionValue(locale, "");
        return Intrinsics.areEqual("in", locale.getLanguage());
    }
}
