package androidx.view;

import android.os.Bundle;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0007¢\u0006\u0004\b\u0013\u0010\u0014J\u001a\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0096\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\u000b\u001a\u00020\nH\u0016¢\u0006\u0004\b\u000b\u0010\fR\u001a\u0010\r\u001a\u00020\u00078\u0017X\u0096\u0004¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\r\u0010\tR\u001a\u0010\u0010\u001a\u00020\u000f8\u0017X\u0097\u0004¢\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0010\u0010\u0012"}, d2 = {"Landroidx/navigation/ActionOnlyNavDirections;", "Landroidx/navigation/NavDirections;", "", "p0", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "", "toString", "()Ljava/lang/String;", "PlaceComponentResult", "I", "Landroid/os/Bundle;", "KClassImpl$Data$declaredNonStaticMembers$2", "Landroid/os/Bundle;", "()Landroid/os/Bundle;", "<init>", "(I)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class ActionOnlyNavDirections implements NavDirections {
    private final Bundle KClassImpl$Data$declaredNonStaticMembers$2 = new Bundle();
    private final int PlaceComponentResult;

    public ActionOnlyNavDirections(int i) {
        this.PlaceComponentResult = i;
    }

    @Override // androidx.view.NavDirections
    @JvmName(name = "PlaceComponentResult")
    /* renamed from: PlaceComponentResult  reason: from getter */
    public final int getPlaceComponentResult() {
        return this.PlaceComponentResult;
    }

    @Override // androidx.view.NavDirections
    @JvmName(name = "KClassImpl$Data$declaredNonStaticMembers$2")
    /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from getter */
    public final Bundle getKClassImpl$Data$declaredNonStaticMembers$2() {
        return this.KClassImpl$Data$declaredNonStaticMembers$2;
    }

    public final boolean equals(Object p0) {
        if (this == p0) {
            return true;
        }
        return p0 != null && Intrinsics.areEqual(getClass(), p0.getClass()) && this.PlaceComponentResult == ((ActionOnlyNavDirections) p0).PlaceComponentResult;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("ActionOnlyNavDirections(actionId=");
        sb.append(this.PlaceComponentResult);
        sb.append(')');
        return sb.toString();
    }

    public final int hashCode() {
        return this.PlaceComponentResult + 31;
    }
}
