package id.dana.animation.adapter;

import id.dana.animation.adapter.HomeAdapter;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\f¢\u0006\u0004\b\u0010\u0010\u0011J\u001a\u0010\u0004\u001a\u00020\u00032\b\u0010\u0002\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0007\u001a\u00020\u0006HÖ\u0001¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\n\u001a\u00020\tHÖ\u0001¢\u0006\u0004\b\n\u0010\u000bR\u0012\u0010\u000f\u001a\u00020\fX\u0086\u0002¢\u0006\u0006\n\u0004\b\r\u0010\u000e"}, d2 = {"Lid/dana/home/adapter/HomeViewWidgetModel;", "", "p0", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "", "toString", "()Ljava/lang/String;", "Lid/dana/home/adapter/HomeAdapter$HomeWidget;", "PlaceComponentResult", "Lid/dana/home/adapter/HomeAdapter$HomeWidget;", "MyBillsEntityDataFactory", "<init>", "(Lid/dana/home/adapter/HomeAdapter$HomeWidget;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public final /* data */ class HomeViewWidgetModel {

    /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
    public HomeAdapter.HomeWidget MyBillsEntityDataFactory;

    public final boolean equals(Object p0) {
        if (this == p0) {
            return true;
        }
        return (p0 instanceof HomeViewWidgetModel) && this.MyBillsEntityDataFactory == ((HomeViewWidgetModel) p0).MyBillsEntityDataFactory;
    }

    public final int hashCode() {
        return this.MyBillsEntityDataFactory.hashCode();
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("HomeViewWidgetModel(MyBillsEntityDataFactory=");
        sb.append(this.MyBillsEntityDataFactory);
        sb.append(')');
        return sb.toString();
    }

    public HomeViewWidgetModel(HomeAdapter.HomeWidget homeWidget) {
        Intrinsics.checkNotNullParameter(homeWidget, "");
        this.MyBillsEntityDataFactory = homeWidget;
    }
}
