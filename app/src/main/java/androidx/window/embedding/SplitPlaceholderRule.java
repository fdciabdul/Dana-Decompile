package androidx.window.embedding;

import android.content.Intent;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001J\u001a\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0096\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\b\u0010\tR\u0017\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u000b0\nX\u0006¢\u0006\u0006\n\u0004\b\f\u0010\rR\u0011\u0010\u0011\u001a\u00020\u000fX\u0006¢\u0006\u0006\n\u0004\b\u000e\u0010\u0010"}, d2 = {"Landroidx/window/embedding/SplitPlaceholderRule;", "Landroidx/window/embedding/SplitRule;", "", "p0", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "", "Landroidx/window/embedding/ActivityFilter;", "getAuthRequestContext", "Ljava/util/Set;", "MyBillsEntityDataFactory", "Landroid/content/Intent;", "Landroid/content/Intent;", "KClassImpl$Data$declaredNonStaticMembers$2"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class SplitPlaceholderRule extends SplitRule {

    /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
    public final Intent KClassImpl$Data$declaredNonStaticMembers$2;

    /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
    public final Set<ActivityFilter> MyBillsEntityDataFactory;

    @Override // androidx.window.embedding.SplitRule
    public final boolean equals(Object p0) {
        if (this == p0) {
            return true;
        }
        if ((p0 instanceof SplitPlaceholderRule) && super.equals(p0) && super.equals(p0)) {
            SplitPlaceholderRule splitPlaceholderRule = (SplitPlaceholderRule) p0;
            return Intrinsics.areEqual(this.MyBillsEntityDataFactory, splitPlaceholderRule.MyBillsEntityDataFactory) && Intrinsics.areEqual(this.KClassImpl$Data$declaredNonStaticMembers$2, splitPlaceholderRule.KClassImpl$Data$declaredNonStaticMembers$2);
        }
        return false;
    }

    @Override // androidx.window.embedding.SplitRule
    public final int hashCode() {
        return (((super.hashCode() * 31) + this.MyBillsEntityDataFactory.hashCode()) * 31) + this.KClassImpl$Data$declaredNonStaticMembers$2.hashCode();
    }
}
