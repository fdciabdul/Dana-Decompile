package androidx.window.embedding;

import androidx.paging.LoadState$Error$$ExternalSyntheticBackport0;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001J\u001a\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0096\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\b\u0010\tR\u0011\u0010\n\u001a\u00020\u0004X\u0006¢\u0006\u0006\n\u0004\b\n\u0010\u000bR\u0017\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\r0\fX\u0006¢\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u0011\u0010\u000e\u001a\u00020\u0004X\u0006¢\u0006\u0006\n\u0004\b\u0011\u0010\u000bR\u0011\u0010\u0011\u001a\u00020\u0004X\u0006¢\u0006\u0006\n\u0004\b\u0010\u0010\u000b"}, d2 = {"Landroidx/window/embedding/SplitPairRule;", "Landroidx/window/embedding/SplitRule;", "", "p0", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "getAuthRequestContext", "Z", "", "Landroidx/window/embedding/SplitPairFilter;", "KClassImpl$Data$declaredNonStaticMembers$2", "Ljava/util/Set;", "PlaceComponentResult", "BuiltInFictitiousFunctionClassFactory"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class SplitPairRule extends SplitRule {

    /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
    public final boolean KClassImpl$Data$declaredNonStaticMembers$2;

    /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
    public final Set<SplitPairFilter> PlaceComponentResult;

    /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
    public final boolean BuiltInFictitiousFunctionClassFactory;
    public final boolean getAuthRequestContext;

    @Override // androidx.window.embedding.SplitRule
    public final boolean equals(Object p0) {
        if (this == p0) {
            return true;
        }
        if ((p0 instanceof SplitPairRule) && super.equals(p0)) {
            SplitPairRule splitPairRule = (SplitPairRule) p0;
            return Intrinsics.areEqual(this.PlaceComponentResult, splitPairRule.PlaceComponentResult) && this.KClassImpl$Data$declaredNonStaticMembers$2 == splitPairRule.KClassImpl$Data$declaredNonStaticMembers$2 && this.BuiltInFictitiousFunctionClassFactory == splitPairRule.BuiltInFictitiousFunctionClassFactory && this.getAuthRequestContext == splitPairRule.getAuthRequestContext;
        }
        return false;
    }

    @Override // androidx.window.embedding.SplitRule
    public final int hashCode() {
        int hashCode = super.hashCode();
        int hashCode2 = this.PlaceComponentResult.hashCode();
        return (((((((hashCode * 31) + hashCode2) * 31) + LoadState$Error$$ExternalSyntheticBackport0.BuiltInFictitiousFunctionClassFactory(this.KClassImpl$Data$declaredNonStaticMembers$2)) * 31) + LoadState$Error$$ExternalSyntheticBackport0.BuiltInFictitiousFunctionClassFactory(this.BuiltInFictitiousFunctionClassFactory)) * 31) + LoadState$Error$$ExternalSyntheticBackport0.BuiltInFictitiousFunctionClassFactory(this.getAuthRequestContext);
    }
}
