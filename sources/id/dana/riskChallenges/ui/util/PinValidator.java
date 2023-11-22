package id.dana.riskChallenges.ui.util;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;
import kotlin.text.StringsKt;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0007\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u000b\u0010\fJ\u001d\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002¢\u0006\u0004\b\u0006\u0010\u0007J\u001d\u0010\b\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002¢\u0006\u0004\b\b\u0010\u0007J\u0015\u0010\b\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\b\u0010\tJ\u0015\u0010\n\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\n\u0010\t"}, d2 = {"Lid/dana/riskChallenges/ui/util/PinValidator;", "", "", "p0", "p1", "", "KClassImpl$Data$declaredNonStaticMembers$2", "(Ljava/lang/String;Ljava/lang/String;)Z", "getAuthRequestContext", "(Ljava/lang/String;)Z", "MyBillsEntityDataFactory", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class PinValidator {
    public static final PinValidator INSTANCE = new PinValidator();

    private PinValidator() {
    }

    public static boolean MyBillsEntityDataFactory(String p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        return StringsKt.indexOf$default((CharSequence) "0123456789012345789", p0, 0, false, 6, (Object) null) >= 0 || StringsKt.indexOf$default((CharSequence) "9876543210987654321", p0, 0, false, 6, (Object) null) >= 0;
    }

    public static boolean getAuthRequestContext(String p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        return new Regex("\\b(\\d)\\1+\\b").matches(p0);
    }

    public static boolean getAuthRequestContext(String p0, String p1) {
        Intrinsics.checkNotNullParameter(p0, "");
        Intrinsics.checkNotNullParameter(p1, "");
        return Intrinsics.areEqual(p0, p1);
    }

    public static boolean KClassImpl$Data$declaredNonStaticMembers$2(String p0, String p1) {
        Intrinsics.checkNotNullParameter(p0, "");
        Intrinsics.checkNotNullParameter(p1, "");
        return p0.length() >= p1.length();
    }
}
