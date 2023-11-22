package id.dana.nearbyme.model;

import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001:\u0001\u000fB!\u0012\u0006\u0010\u000b\u001a\u00020\u0007\u0012\u0010\b\u0002\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002¢\u0006\u0004\b\r\u0010\u000eR\u001a\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002X\u0086\u0002¢\u0006\u0006\n\u0004\b\u0004\u0010\u0005R\u0012\u0010\n\u001a\u00020\u0007X\u0086\u0002¢\u0006\u0006\n\u0004\b\b\u0010\t"}, d2 = {"Lid/dana/nearbyme/model/NearbyDealsSectionModel;", "", "", "Lid/dana/nearbyme/model/NearbySpecialDealsItemWrapper;", "getAuthRequestContext", "Ljava/util/List;", "BuiltInFictitiousFunctionClassFactory", "Lid/dana/nearbyme/model/NearbyDealsSectionModel$SectionState;", "PlaceComponentResult", "Lid/dana/nearbyme/model/NearbyDealsSectionModel$SectionState;", "MyBillsEntityDataFactory", "p0", "p1", "<init>", "(Lid/dana/nearbyme/model/NearbyDealsSectionModel$SectionState;Ljava/util/List;)V", "SectionState"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class NearbyDealsSectionModel {

    /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
    public SectionState MyBillsEntityDataFactory;

    /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
    public List<NearbySpecialDealsItemWrapper> BuiltInFictitiousFunctionClassFactory;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005"}, d2 = {"Lid/dana/nearbyme/model/NearbyDealsSectionModel$SectionState;", "", "<init>", "(Ljava/lang/String;I)V", "LOADING", "ACTIVE"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public enum SectionState {
        LOADING,
        ACTIVE
    }

    public NearbyDealsSectionModel(SectionState sectionState, List<NearbySpecialDealsItemWrapper> list) {
        Intrinsics.checkNotNullParameter(sectionState, "");
        this.MyBillsEntityDataFactory = sectionState;
        this.BuiltInFictitiousFunctionClassFactory = list;
    }

    public /* synthetic */ NearbyDealsSectionModel(SectionState sectionState, List list, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(sectionState, (i & 2) != 0 ? null : list);
    }
}
