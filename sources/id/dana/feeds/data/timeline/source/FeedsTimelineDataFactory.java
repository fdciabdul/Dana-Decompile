package id.dana.feeds.data.timeline.source;

import id.dana.data.AbstractEntityDataFactory;
import id.dana.feeds.data.timeline.source.network.NetworkFeedsTimelineData;
import id.dana.feeds.data.timeline.source.persistence.PersistenceFeedsTimelineEntityData;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0019\b\u0007\u0012\u0006\u0010\n\u001a\u00020\u0003\u0012\u0006\u0010\u000b\u001a\u00020\u0007¢\u0006\u0004\b\f\u0010\rR\u0014\u0010\u0006\u001a\u00020\u00038\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010\u0005R\u0014\u0010\u0004\u001a\u00020\u00078\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\b\u0010\t"}, d2 = {"Lid/dana/feeds/data/timeline/source/FeedsTimelineDataFactory;", "Lid/dana/data/AbstractEntityDataFactory;", "Lid/dana/feeds/data/timeline/source/FeedsTimelineData;", "Lid/dana/feeds/data/timeline/source/network/NetworkFeedsTimelineData;", "getAuthRequestContext", "Lid/dana/feeds/data/timeline/source/network/NetworkFeedsTimelineData;", "BuiltInFictitiousFunctionClassFactory", "Lid/dana/feeds/data/timeline/source/persistence/PersistenceFeedsTimelineEntityData;", "PlaceComponentResult", "Lid/dana/feeds/data/timeline/source/persistence/PersistenceFeedsTimelineEntityData;", "p0", "p1", "<init>", "(Lid/dana/feeds/data/timeline/source/network/NetworkFeedsTimelineData;Lid/dana/feeds/data/timeline/source/persistence/PersistenceFeedsTimelineEntityData;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class FeedsTimelineDataFactory extends AbstractEntityDataFactory<FeedsTimelineData> {

    /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
    public final PersistenceFeedsTimelineEntityData getAuthRequestContext;

    /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
    public final NetworkFeedsTimelineData BuiltInFictitiousFunctionClassFactory;

    @Inject
    public FeedsTimelineDataFactory(NetworkFeedsTimelineData networkFeedsTimelineData, PersistenceFeedsTimelineEntityData persistenceFeedsTimelineEntityData) {
        Intrinsics.checkNotNullParameter(networkFeedsTimelineData, "");
        Intrinsics.checkNotNullParameter(persistenceFeedsTimelineEntityData, "");
        this.BuiltInFictitiousFunctionClassFactory = networkFeedsTimelineData;
        this.getAuthRequestContext = persistenceFeedsTimelineEntityData;
    }

    @Override // id.dana.data.AbstractEntityDataFactory
    /* renamed from: createData */
    public final /* synthetic */ FeedsTimelineData createData2(String str) {
        return Intrinsics.areEqual(str, "local") ? this.getAuthRequestContext : this.BuiltInFictitiousFunctionClassFactory;
    }
}
