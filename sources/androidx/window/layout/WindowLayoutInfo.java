package androidx.window.layout;

import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0017\b\u0016\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\r0\f¢\u0006\u0004\b\u0011\u0010\u0012J\u001a\u0010\u0004\u001a\u00020\u00032\b\u0010\u0002\u001a\u0004\u0018\u00010\u0001H\u0096\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\n\u001a\u00020\tH\u0016¢\u0006\u0004\b\n\u0010\u000bR\u0017\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\r0\fX\u0006¢\u0006\u0006\n\u0004\b\u000e\u0010\u000f"}, d2 = {"Landroidx/window/layout/WindowLayoutInfo;", "", "p0", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "", "toString", "()Ljava/lang/String;", "", "Landroidx/window/layout/DisplayFeature;", "PlaceComponentResult", "Ljava/util/List;", "getAuthRequestContext", "<init>", "(Ljava/util/List;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class WindowLayoutInfo {

    /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
    public final List<DisplayFeature> getAuthRequestContext;

    /* JADX WARN: Multi-variable type inference failed */
    public WindowLayoutInfo(List<? extends DisplayFeature> list) {
        Intrinsics.checkNotNullParameter(list, "");
        this.getAuthRequestContext = list;
    }

    public final String toString() {
        return CollectionsKt.joinToString$default(this.getAuthRequestContext, ", ", "WindowLayoutInfo{ DisplayFeatures[", "] }", 0, null, null, 56, null);
    }

    public final boolean equals(Object p0) {
        if (this == p0) {
            return true;
        }
        if (p0 == null || !Intrinsics.areEqual(getClass(), p0.getClass())) {
            return false;
        }
        return Intrinsics.areEqual(this.getAuthRequestContext, ((WindowLayoutInfo) p0).getAuthRequestContext);
    }

    public final int hashCode() {
        return this.getAuthRequestContext.hashCode();
    }
}
