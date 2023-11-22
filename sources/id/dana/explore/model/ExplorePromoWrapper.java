package id.dana.explore.model;

import id.dana.promocenter.model.PromoModel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\b\u0086\b\u0018\u0000 \u00162\u00020\u0001:\u0001\u0016B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0006\u0012\u0006\u0010\u0013\u001a\u00020\f¢\u0006\u0004\b\u0014\u0010\u0015J\u001a\u0010\u0004\u001a\u00020\u00032\b\u0010\u0002\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0007\u001a\u00020\u0006HÖ\u0001¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\n\u001a\u00020\tHÖ\u0001¢\u0006\u0004\b\n\u0010\u000bR\u0012\u0010\u000f\u001a\u00020\fX\u0086\u0002¢\u0006\u0006\n\u0004\b\r\u0010\u000eR\u0012\u0010\u0012\u001a\u00020\u0006X\u0086\u0002¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011"}, d2 = {"Lid/dana/explore/model/ExplorePromoWrapper;", "", "p0", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "", "toString", "()Ljava/lang/String;", "Lid/dana/promocenter/model/PromoModel;", "PlaceComponentResult", "Lid/dana/promocenter/model/PromoModel;", "MyBillsEntityDataFactory", "KClassImpl$Data$declaredNonStaticMembers$2", "I", "getAuthRequestContext", "p1", "<init>", "(ILid/dana/promocenter/model/PromoModel;)V", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final /* data */ class ExplorePromoWrapper {

    /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
    public int getAuthRequestContext;

    /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
    public PromoModel MyBillsEntityDataFactory;

    public final boolean equals(Object p0) {
        if (this == p0) {
            return true;
        }
        if (p0 instanceof ExplorePromoWrapper) {
            ExplorePromoWrapper explorePromoWrapper = (ExplorePromoWrapper) p0;
            return this.getAuthRequestContext == explorePromoWrapper.getAuthRequestContext && Intrinsics.areEqual(this.MyBillsEntityDataFactory, explorePromoWrapper.MyBillsEntityDataFactory);
        }
        return false;
    }

    public final int hashCode() {
        return (this.getAuthRequestContext * 31) + this.MyBillsEntityDataFactory.hashCode();
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("ExplorePromoWrapper(getAuthRequestContext=");
        sb.append(this.getAuthRequestContext);
        sb.append(", MyBillsEntityDataFactory=");
        sb.append(this.MyBillsEntityDataFactory);
        sb.append(')');
        return sb.toString();
    }

    public ExplorePromoWrapper(int i, PromoModel promoModel) {
        Intrinsics.checkNotNullParameter(promoModel, "");
        this.getAuthRequestContext = i;
        this.MyBillsEntityDataFactory = promoModel;
    }
}
