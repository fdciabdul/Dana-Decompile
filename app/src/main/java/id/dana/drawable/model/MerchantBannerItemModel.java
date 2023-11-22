package id.dana.drawable.model;

import id.dana.analytics.tracker.TrackerKey;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0086\b\u0018\u00002\u00020\u0001:\u0001\u0012B\u0011\u0012\b\b\u0002\u0010\u0002\u001a\u00020\f¢\u0006\u0004\b\u0010\u0010\u0011J\u001a\u0010\u0004\u001a\u00020\u00032\b\u0010\u0002\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0007\u001a\u00020\u0006HÖ\u0001¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\n\u001a\u00020\tHÖ\u0001¢\u0006\u0004\b\n\u0010\u000bR\u0012\u0010\u000f\u001a\u00020\fX\u0086\u0002¢\u0006\u0006\n\u0004\b\r\u0010\u000e"}, d2 = {"Lid/dana/nearbyrevamp/model/MerchantBannerItemModel;", "", "p0", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "", "toString", "()Ljava/lang/String;", "Lid/dana/nearbyrevamp/model/MerchantBannerItemModel$State;", "BuiltInFictitiousFunctionClassFactory", "Lid/dana/nearbyrevamp/model/MerchantBannerItemModel$State;", "PlaceComponentResult", "<init>", "(Lid/dana/nearbyrevamp/model/MerchantBannerItemModel$State;)V", TrackerKey.Property.STATE}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final /* data */ class MerchantBannerItemModel {

    /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
    public State PlaceComponentResult;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005"}, d2 = {"Lid/dana/nearbyrevamp/model/MerchantBannerItemModel$State;", "", "<init>", "(Ljava/lang/String;I)V", "SHIMMERING", "LOADED"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public enum State {
        SHIMMERING,
        LOADED
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /* JADX WARN: Type inference failed for: r0v0, types: [id.dana.nearbyrevamp.model.MerchantBannerItemModel$State, kotlin.jvm.internal.DefaultConstructorMarker] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public MerchantBannerItemModel() {
        /*
            r2 = this;
            r0 = 0
            r1 = 1
            r2.<init>(r0, r1, r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.drawable.model.MerchantBannerItemModel.<init>():void");
    }

    public final boolean equals(Object p0) {
        if (this == p0) {
            return true;
        }
        return (p0 instanceof MerchantBannerItemModel) && this.PlaceComponentResult == ((MerchantBannerItemModel) p0).PlaceComponentResult;
    }

    public final int hashCode() {
        return this.PlaceComponentResult.hashCode();
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("MerchantBannerItemModel(PlaceComponentResult=");
        sb.append(this.PlaceComponentResult);
        sb.append(')');
        return sb.toString();
    }

    private MerchantBannerItemModel(State state) {
        Intrinsics.checkNotNullParameter(state, "");
        this.PlaceComponentResult = state;
    }

    public /* synthetic */ MerchantBannerItemModel(State state, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? State.SHIMMERING : state);
    }
}
