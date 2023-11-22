package id.dana.promodiscovery.model;

import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002B)\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0007\u0012\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003\u0012\u0006\u0010\u0010\u001a\u00020\n¢\u0006\u0004\b\u0011\u0010\u0012R\u0018\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003X\u0086\u0002¢\u0006\u0006\n\u0004\b\u0004\u0010\u0005R\u0014\u0010\t\u001a\u0004\u0018\u00010\u0007X\u0086\u0002¢\u0006\u0006\n\u0004\b\u0006\u0010\bR\u0012\u0010\r\u001a\u00020\nX\u0086\u0002¢\u0006\u0006\n\u0004\b\u000b\u0010\f"}, d2 = {"Lid/dana/promodiscovery/model/DiscoverySectionModel;", "T", "", "", "PlaceComponentResult", "Ljava/util/List;", "KClassImpl$Data$declaredNonStaticMembers$2", "Lid/dana/promodiscovery/model/DiscoverySectionConfigModel;", "Lid/dana/promodiscovery/model/DiscoverySectionConfigModel;", "MyBillsEntityDataFactory", "Lid/dana/promodiscovery/model/SectionState;", "getAuthRequestContext", "Lid/dana/promodiscovery/model/SectionState;", "BuiltInFictitiousFunctionClassFactory", "p0", "p1", "p2", "<init>", "(Lid/dana/promodiscovery/model/DiscoverySectionConfigModel;Ljava/util/List;Lid/dana/promodiscovery/model/SectionState;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class DiscoverySectionModel<T> {

    /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
    public DiscoverySectionConfigModel MyBillsEntityDataFactory;

    /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
    public List<? extends T> KClassImpl$Data$declaredNonStaticMembers$2;

    /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
    public SectionState BuiltInFictitiousFunctionClassFactory;

    private DiscoverySectionModel(DiscoverySectionConfigModel discoverySectionConfigModel, List<? extends T> list, SectionState sectionState) {
        Intrinsics.checkNotNullParameter(list, "");
        Intrinsics.checkNotNullParameter(sectionState, "");
        this.MyBillsEntityDataFactory = discoverySectionConfigModel;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = list;
        this.BuiltInFictitiousFunctionClassFactory = sectionState;
    }

    public /* synthetic */ DiscoverySectionModel(DiscoverySectionConfigModel discoverySectionConfigModel, List list, SectionState sectionState, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : discoverySectionConfigModel, list, sectionState);
    }
}
