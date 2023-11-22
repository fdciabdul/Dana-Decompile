package androidx.window.embedding;

import android.app.Activity;
import com.iap.ac.android.biz.common.utils.log.LogConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0006\u0018\u00002\u00020\u0001B!\b\u0000\u0012\u0006\u0010\u0003\u001a\u00020\u000f\u0012\u0006\u0010\u0016\u001a\u00020\u000f\u0012\u0006\u0010\u0017\u001a\u00020\u0013¢\u0006\u0004\b\u0018\u0010\u0019J\u0018\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0086\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u001a\u0010\u0007\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0001H\u0096\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\n\u001a\u00020\tH\u0016¢\u0006\u0004\b\n\u0010\u000bJ\u000f\u0010\r\u001a\u00020\fH\u0016¢\u0006\u0004\b\r\u0010\u000eR\u0011\u0010\u0005\u001a\u00020\u000fX\u0006¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0010\u001a\u00020\u000fX\u0006¢\u0006\u0006\n\u0004\b\u0012\u0010\u0011R\u0011\u0010\u0014\u001a\u00020\u0013X\u0006¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015"}, d2 = {"Landroidx/window/embedding/SplitInfo;", "", "Landroid/app/Activity;", "p0", "", "getAuthRequestContext", "(Landroid/app/Activity;)Z", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "", "toString", "()Ljava/lang/String;", "Landroidx/window/embedding/ActivityStack;", "MyBillsEntityDataFactory", "Landroidx/window/embedding/ActivityStack;", "BuiltInFictitiousFunctionClassFactory", "", "KClassImpl$Data$declaredNonStaticMembers$2", LogConstants.RESULT_FALSE, "p1", "p2", "<init>", "(Landroidx/window/embedding/ActivityStack;Landroidx/window/embedding/ActivityStack;F)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class SplitInfo {

    /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
    public final ActivityStack MyBillsEntityDataFactory;
    public final float KClassImpl$Data$declaredNonStaticMembers$2;

    /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
    public final ActivityStack getAuthRequestContext;

    public SplitInfo(ActivityStack activityStack, ActivityStack activityStack2, float f) {
        Intrinsics.checkNotNullParameter(activityStack, "");
        Intrinsics.checkNotNullParameter(activityStack2, "");
        this.getAuthRequestContext = activityStack;
        this.MyBillsEntityDataFactory = activityStack2;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = f;
    }

    public final boolean getAuthRequestContext(Activity p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        return this.getAuthRequestContext.BuiltInFictitiousFunctionClassFactory(p0) || this.MyBillsEntityDataFactory.BuiltInFictitiousFunctionClassFactory(p0);
    }

    public final boolean equals(Object p0) {
        if (this == p0) {
            return true;
        }
        if (p0 instanceof SplitInfo) {
            SplitInfo splitInfo = (SplitInfo) p0;
            if (Intrinsics.areEqual(this.getAuthRequestContext, splitInfo.getAuthRequestContext) && Intrinsics.areEqual(this.MyBillsEntityDataFactory, splitInfo.MyBillsEntityDataFactory)) {
                return (this.KClassImpl$Data$declaredNonStaticMembers$2 > splitInfo.KClassImpl$Data$declaredNonStaticMembers$2 ? 1 : (this.KClassImpl$Data$declaredNonStaticMembers$2 == splitInfo.KClassImpl$Data$declaredNonStaticMembers$2 ? 0 : -1)) == 0;
            }
            return false;
        }
        return false;
    }

    public final int hashCode() {
        return (((this.getAuthRequestContext.hashCode() * 31) + this.MyBillsEntityDataFactory.hashCode()) * 31) + Float.floatToIntBits(this.KClassImpl$Data$declaredNonStaticMembers$2);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("SplitInfo:{");
        StringBuilder sb2 = new StringBuilder();
        sb2.append("primaryActivityStack=");
        sb2.append(this.getAuthRequestContext);
        sb2.append(',');
        sb.append(sb2.toString());
        StringBuilder sb3 = new StringBuilder();
        sb3.append("secondaryActivityStack=");
        sb3.append(this.MyBillsEntityDataFactory);
        sb3.append(',');
        sb.append(sb3.toString());
        StringBuilder sb4 = new StringBuilder();
        sb4.append("splitRatio=");
        sb4.append(this.KClassImpl$Data$declaredNonStaticMembers$2);
        sb4.append('}');
        sb.append(sb4.toString());
        String obj = sb.toString();
        Intrinsics.checkNotNullExpressionValue(obj, "");
        return obj;
    }
}
