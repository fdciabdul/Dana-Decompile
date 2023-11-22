package id.dana.drawable.search.model;

import id.dana.drawable.search.ExploreSectionType;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0086\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0010\u0012\u000e\b\u0002\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\r0\f¢\u0006\u0004\b\u0015\u0010\u0016J\u001a\u0010\u0004\u001a\u00020\u00032\b\u0010\u0002\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0007\u001a\u00020\u0006HÖ\u0001¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\n\u001a\u00020\tHÖ\u0001¢\u0006\u0004\b\n\u0010\u000bR\u0017\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\r0\fX\u0006¢\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0013\u001a\u00020\u0010X\u0006¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012"}, d2 = {"Lid/dana/nearbyrevamp/search/model/NearbySearchSectionModel;", "", "p0", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "", "toString", "()Ljava/lang/String;", "", "Lid/dana/nearbyrevamp/search/model/NearbySearchItemModel;", "KClassImpl$Data$declaredNonStaticMembers$2", "Ljava/util/List;", "Lid/dana/nearbyrevamp/search/ExploreSectionType;", "MyBillsEntityDataFactory", "Lid/dana/nearbyrevamp/search/ExploreSectionType;", "getAuthRequestContext", "p1", "<init>", "(Lid/dana/nearbyrevamp/search/ExploreSectionType;Ljava/util/List;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final /* data */ class NearbySearchSectionModel {
    public final List<NearbySearchItemModel> KClassImpl$Data$declaredNonStaticMembers$2;

    /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
    public final ExploreSectionType getAuthRequestContext;

    public final boolean equals(Object p0) {
        if (this == p0) {
            return true;
        }
        if (p0 instanceof NearbySearchSectionModel) {
            NearbySearchSectionModel nearbySearchSectionModel = (NearbySearchSectionModel) p0;
            return this.getAuthRequestContext == nearbySearchSectionModel.getAuthRequestContext && Intrinsics.areEqual(this.KClassImpl$Data$declaredNonStaticMembers$2, nearbySearchSectionModel.KClassImpl$Data$declaredNonStaticMembers$2);
        }
        return false;
    }

    public final int hashCode() {
        return (this.getAuthRequestContext.hashCode() * 31) + this.KClassImpl$Data$declaredNonStaticMembers$2.hashCode();
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("NearbySearchSectionModel(getAuthRequestContext=");
        sb.append(this.getAuthRequestContext);
        sb.append(", KClassImpl$Data$declaredNonStaticMembers$2=");
        sb.append(this.KClassImpl$Data$declaredNonStaticMembers$2);
        sb.append(')');
        return sb.toString();
    }

    public NearbySearchSectionModel(ExploreSectionType exploreSectionType, List<NearbySearchItemModel> list) {
        Intrinsics.checkNotNullParameter(exploreSectionType, "");
        Intrinsics.checkNotNullParameter(list, "");
        this.getAuthRequestContext = exploreSectionType;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = list;
    }
}
