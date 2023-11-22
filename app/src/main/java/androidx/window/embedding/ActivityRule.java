package androidx.window.embedding;

import androidx.paging.LoadState$Error$$ExternalSyntheticBackport0;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001J\u001a\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0096\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\b\u0010\tR\u0011\u0010\f\u001a\u00020\u0004X\u0006¢\u0006\u0006\n\u0004\b\n\u0010\u000bR\u0017\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u000e0\rX\u0006¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010"}, d2 = {"Landroidx/window/embedding/ActivityRule;", "Landroidx/window/embedding/EmbeddingRule;", "", "p0", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "KClassImpl$Data$declaredNonStaticMembers$2", "Z", "MyBillsEntityDataFactory", "", "Landroidx/window/embedding/ActivityFilter;", "BuiltInFictitiousFunctionClassFactory", "Ljava/util/Set;"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class ActivityRule extends EmbeddingRule {
    public final Set<ActivityFilter> BuiltInFictitiousFunctionClassFactory;

    /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
    public final boolean MyBillsEntityDataFactory;

    public final boolean equals(Object p0) {
        if (this == p0) {
            return true;
        }
        if (p0 instanceof ActivityRule) {
            ActivityRule activityRule = (ActivityRule) p0;
            return Intrinsics.areEqual(this.BuiltInFictitiousFunctionClassFactory, activityRule.BuiltInFictitiousFunctionClassFactory) && this.MyBillsEntityDataFactory == activityRule.MyBillsEntityDataFactory;
        }
        return false;
    }

    public final int hashCode() {
        return (this.BuiltInFictitiousFunctionClassFactory.hashCode() * 31) + LoadState$Error$$ExternalSyntheticBackport0.BuiltInFictitiousFunctionClassFactory(this.MyBillsEntityDataFactory);
    }
}
