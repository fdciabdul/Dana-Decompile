package androidx.paging;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0080\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0006\u0012\u0006\u0010\u0013\u001a\u00020\u000f¢\u0006\u0004\b\u0014\u0010\u0015J\u001a\u0010\u0004\u001a\u00020\u00032\b\u0010\u0002\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0007\u001a\u00020\u0006HÖ\u0001¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\n\u001a\u00020\tHÖ\u0001¢\u0006\u0004\b\n\u0010\u000bR\u0011\u0010\u000e\u001a\u00020\u0006X\u0006¢\u0006\u0006\n\u0004\b\f\u0010\rR\u0011\u0010\u0012\u001a\u00020\u000fX\u0006¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011"}, d2 = {"Landroidx/paging/GenerationalViewportHint;", "", "p0", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "", "toString", "()Ljava/lang/String;", "BuiltInFictitiousFunctionClassFactory", "I", "MyBillsEntityDataFactory", "Landroidx/paging/ViewportHint;", "PlaceComponentResult", "Landroidx/paging/ViewportHint;", "getAuthRequestContext", "p1", "<init>", "(ILandroidx/paging/ViewportHint;)V"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class GenerationalViewportHint {

    /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
    final int MyBillsEntityDataFactory;

    /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
    final ViewportHint getAuthRequestContext;

    public final boolean equals(Object p0) {
        if (this == p0) {
            return true;
        }
        if (p0 instanceof GenerationalViewportHint) {
            GenerationalViewportHint generationalViewportHint = (GenerationalViewportHint) p0;
            return this.MyBillsEntityDataFactory == generationalViewportHint.MyBillsEntityDataFactory && Intrinsics.areEqual(this.getAuthRequestContext, generationalViewportHint.getAuthRequestContext);
        }
        return false;
    }

    public final int hashCode() {
        return (this.MyBillsEntityDataFactory * 31) + this.getAuthRequestContext.hashCode();
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("GenerationalViewportHint(MyBillsEntityDataFactory=");
        sb.append(this.MyBillsEntityDataFactory);
        sb.append(", getAuthRequestContext=");
        sb.append(this.getAuthRequestContext);
        sb.append(')');
        return sb.toString();
    }

    public GenerationalViewportHint(int i, ViewportHint viewportHint) {
        Intrinsics.checkNotNullParameter(viewportHint, "");
        this.MyBillsEntityDataFactory = i;
        this.getAuthRequestContext = viewportHint;
    }
}
