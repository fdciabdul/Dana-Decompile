package id.dana.core.ui.util;

import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.text.StringsKt;

@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\b\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\t\u0010\nJ\u0015\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0015\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0006\u0010\u0005J\u0015\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0007\u0010\u0005J\u0015\u0010\b\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\b\u0010\u0005"}, d2 = {"Lid/dana/core/ui/util/MaskedTextUtil;", "", "", "p0", "getAuthRequestContext", "(Ljava/lang/String;)Ljava/lang/String;", "MyBillsEntityDataFactory", "BuiltInFictitiousFunctionClassFactory", "PlaceComponentResult", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class MaskedTextUtil {
    public static final MaskedTextUtil INSTANCE = new MaskedTextUtil();

    private MaskedTextUtil() {
    }

    public static String BuiltInFictitiousFunctionClassFactory(String p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        return StringsKt.replace$default(p0, "*", "•", false, 4, (Object) null);
    }

    public static String PlaceComponentResult(String p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        String take = StringsKt.take(p0, 3);
        if (Intrinsics.areEqual(take, "+62")) {
            p0 = StringsKt.replace$default(p0, "+62", "0", false, 4, (Object) null);
        } else if (Intrinsics.areEqual(take, "62-")) {
            p0 = StringsKt.replace$default(p0, "62-", "0", false, 4, (Object) null);
        }
        return StringsKt.replace$default(p0, "*", "•", false, 4, (Object) null);
    }

    public static String getAuthRequestContext(String p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        Object[] objArr = new Object[1];
        if (p0.length() >= 4) {
            p0 = p0.substring(p0.length() - 4);
            Intrinsics.checkNotNullExpressionValue(p0, "");
        }
        objArr[0] = p0;
        String format = String.format("•••• %s", Arrays.copyOf(objArr, 1));
        Intrinsics.checkNotNullExpressionValue(format, "");
        return format;
    }

    public static String MyBillsEntityDataFactory(String p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        return p0.length() > 0 ? StringsKt.replace$default(p0, " ", "", false, 4, (Object) null) : p0;
    }
}
