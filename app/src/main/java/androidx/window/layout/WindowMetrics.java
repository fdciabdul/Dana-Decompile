package androidx.window.layout;

import android.graphics.Rect;
import androidx.window.core.Bounds;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0011\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0010¢\u0006\u0004\b\u0011\u0010\u0012B\u0011\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\f¢\u0006\u0004\b\u0011\u0010\u0013J\u001a\u0010\u0004\u001a\u00020\u00032\b\u0010\u0002\u001a\u0004\u0018\u00010\u0001H\u0096\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\n\u001a\u00020\tH\u0016¢\u0006\u0004\b\n\u0010\u000bR\u0014\u0010\u000f\u001a\u00020\f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u000e"}, d2 = {"Landroidx/window/layout/WindowMetrics;", "", "p0", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "", "toString", "()Ljava/lang/String;", "Landroidx/window/core/Bounds;", "PlaceComponentResult", "Landroidx/window/core/Bounds;", "BuiltInFictitiousFunctionClassFactory", "Landroid/graphics/Rect;", "<init>", "(Landroid/graphics/Rect;)V", "(Landroidx/window/core/Bounds;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class WindowMetrics {

    /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
    final Bounds BuiltInFictitiousFunctionClassFactory;

    private WindowMetrics(Bounds bounds) {
        Intrinsics.checkNotNullParameter(bounds, "");
        this.BuiltInFictitiousFunctionClassFactory = bounds;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public WindowMetrics(Rect rect) {
        this(new Bounds(rect));
        Intrinsics.checkNotNullParameter(rect, "");
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("WindowMetrics { bounds: ");
        Bounds bounds = this.BuiltInFictitiousFunctionClassFactory;
        sb.append(new Rect(bounds.BuiltInFictitiousFunctionClassFactory, bounds.KClassImpl$Data$declaredNonStaticMembers$2, bounds.MyBillsEntityDataFactory, bounds.PlaceComponentResult));
        sb.append(" }");
        return sb.toString();
    }

    public final boolean equals(Object p0) {
        if (this == p0) {
            return true;
        }
        if (p0 == null || !Intrinsics.areEqual(getClass(), p0.getClass())) {
            return false;
        }
        return Intrinsics.areEqual(this.BuiltInFictitiousFunctionClassFactory, ((WindowMetrics) p0).BuiltInFictitiousFunctionClassFactory);
    }

    public final int hashCode() {
        return this.BuiltInFictitiousFunctionClassFactory.hashCode();
    }
}
