package id.dana.familyaccount.view.managefamily;

import id.dana.familyaccount.view.managefamily.ManageFamilySourceType;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0007\u0010\bR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004"}, d2 = {"Lid/dana/familyaccount/view/managefamily/ManageFamilyViewState;", "", "Lid/dana/familyaccount/view/managefamily/ManageFamilySourceType;", "getAuthRequestContext", "Lid/dana/familyaccount/view/managefamily/ManageFamilySourceType;", "", "p0", "<init>", "(Ljava/lang/String;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class ManageFamilyViewState {
    private final ManageFamilySourceType getAuthRequestContext;

    public ManageFamilyViewState(String str) {
        Intrinsics.checkNotNullParameter(str, "");
        ManageFamilySourceType.Companion companion = ManageFamilySourceType.INSTANCE;
        this.getAuthRequestContext = ManageFamilySourceType.Companion.BuiltInFictitiousFunctionClassFactory(str);
    }
}
