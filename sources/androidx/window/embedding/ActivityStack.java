package androidx.window.embedding;

import android.app.Activity;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u001f\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00020\u000f\u0012\b\b\u0002\u0010\u0014\u001a\u00020\u0004¢\u0006\u0004\b\u0015\u0010\u0016J\u0018\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0086\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u001a\u0010\u0007\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0001H\u0096\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\n\u001a\u00020\tH\u0016¢\u0006\u0004\b\n\u0010\u000bJ\u000f\u0010\r\u001a\u00020\fH\u0016¢\u0006\u0004\b\r\u0010\u000eR\u0017\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00020\u000fX\u0000¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u0014\u0010\u0012\u001a\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013"}, d2 = {"Landroidx/window/embedding/ActivityStack;", "", "Landroid/app/Activity;", "p0", "", "BuiltInFictitiousFunctionClassFactory", "(Landroid/app/Activity;)Z", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "", "toString", "()Ljava/lang/String;", "", "PlaceComponentResult", "Ljava/util/List;", "getAuthRequestContext", "Z", "p1", "<init>", "(Ljava/util/List;Z)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class ActivityStack {
    public final List<Activity> PlaceComponentResult;
    private final boolean getAuthRequestContext;

    /* JADX WARN: Multi-variable type inference failed */
    public ActivityStack(List<? extends Activity> list, boolean z) {
        Intrinsics.checkNotNullParameter(list, "");
        this.PlaceComponentResult = list;
        this.getAuthRequestContext = z;
    }

    public final boolean BuiltInFictitiousFunctionClassFactory(Activity p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        return this.PlaceComponentResult.contains(p0);
    }

    public final boolean equals(Object p0) {
        if (this == p0) {
            return true;
        }
        if (p0 instanceof ActivityStack) {
            ActivityStack activityStack = (ActivityStack) p0;
            return (Intrinsics.areEqual(this.PlaceComponentResult, activityStack.PlaceComponentResult) || this.getAuthRequestContext == activityStack.getAuthRequestContext) ? false : true;
        }
        return false;
    }

    public final int hashCode() {
        return ((this.getAuthRequestContext ? 1 : 0) * 31) + this.PlaceComponentResult.hashCode();
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("ActivityStack{");
        sb.append(Intrinsics.stringPlus("activities=", this.PlaceComponentResult));
        StringBuilder sb2 = new StringBuilder();
        sb2.append("isEmpty=");
        sb2.append(this.getAuthRequestContext);
        sb2.append('}');
        sb.append(sb2.toString());
        String obj = sb.toString();
        Intrinsics.checkNotNullExpressionValue(obj, "");
        return obj;
    }
}
