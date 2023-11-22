package androidx.window.embedding;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Intent;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001J\u001a\u0010\u0004\u001a\u00020\u00032\b\u0010\u0002\u001a\u0004\u0018\u00010\u0001H\u0096\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u0015\u0010\n\u001a\u00020\u00032\u0006\u0010\u0002\u001a\u00020\t¢\u0006\u0004\b\n\u0010\u000bJ\u0015\u0010\r\u001a\u00020\u00032\u0006\u0010\u0002\u001a\u00020\f¢\u0006\u0004\b\r\u0010\u000eJ\u000f\u0010\u0010\u001a\u00020\u000fH\u0016¢\u0006\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0014\u001a\u00020\u0012X\u0006¢\u0006\u0006\n\u0004\b\n\u0010\u0013R\u0013\u0010\u0017\u001a\u0004\u0018\u00010\u000fX\u0006¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016"}, d2 = {"Landroidx/window/embedding/ActivityFilter;", "", "p0", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "Landroid/app/Activity;", "PlaceComponentResult", "(Landroid/app/Activity;)Z", "Landroid/content/Intent;", "MyBillsEntityDataFactory", "(Landroid/content/Intent;)Z", "", "toString", "()Ljava/lang/String;", "Landroid/content/ComponentName;", "Landroid/content/ComponentName;", "BuiltInFictitiousFunctionClassFactory", "getAuthRequestContext", "Ljava/lang/String;", "KClassImpl$Data$declaredNonStaticMembers$2"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class ActivityFilter {

    /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
    public final ComponentName BuiltInFictitiousFunctionClassFactory;

    /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
    public final String KClassImpl$Data$declaredNonStaticMembers$2;

    public final boolean MyBillsEntityDataFactory(Intent p0) {
        String str;
        Intrinsics.checkNotNullParameter(p0, "");
        MatcherUtils matcherUtils = MatcherUtils.INSTANCE;
        return MatcherUtils.BuiltInFictitiousFunctionClassFactory(p0.getComponent(), this.BuiltInFictitiousFunctionClassFactory) && ((str = this.KClassImpl$Data$declaredNonStaticMembers$2) == null || Intrinsics.areEqual(str, p0.getAction()));
    }

    public final boolean PlaceComponentResult(Activity p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        MatcherUtils matcherUtils = MatcherUtils.INSTANCE;
        if (MatcherUtils.KClassImpl$Data$declaredNonStaticMembers$2(p0, this.BuiltInFictitiousFunctionClassFactory)) {
            String str = this.KClassImpl$Data$declaredNonStaticMembers$2;
            if (str != null) {
                Intent intent = p0.getIntent();
                if (Intrinsics.areEqual(str, intent == null ? null : intent.getAction())) {
                }
            }
            return true;
        }
        return false;
    }

    public final boolean equals(Object p0) {
        if (this == p0) {
            return true;
        }
        if (p0 instanceof ActivityFilter) {
            ActivityFilter activityFilter = (ActivityFilter) p0;
            return Intrinsics.areEqual(this.BuiltInFictitiousFunctionClassFactory, activityFilter.BuiltInFictitiousFunctionClassFactory) && Intrinsics.areEqual(this.KClassImpl$Data$declaredNonStaticMembers$2, activityFilter.KClassImpl$Data$declaredNonStaticMembers$2);
        }
        return false;
    }

    public final int hashCode() {
        int hashCode = this.BuiltInFictitiousFunctionClassFactory.hashCode();
        String str = this.KClassImpl$Data$declaredNonStaticMembers$2;
        return (hashCode * 31) + (str == null ? 0 : str.hashCode());
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("ActivityFilter(componentName=");
        sb.append(this.BuiltInFictitiousFunctionClassFactory);
        sb.append(", intentAction=");
        sb.append((Object) this.KClassImpl$Data$declaredNonStaticMembers$2);
        sb.append(')');
        return sb.toString();
    }
}
