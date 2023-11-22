package id.dana.explore.data.toggle.source;

import dagger.Lazy;
import id.dana.data.AbstractEntityDataFactory;
import id.dana.explore.data.toggle.ExploreConfigEntityData;
import id.dana.explore.data.toggle.source.split.SplitExploreConfigEntityData;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0017\b\u0007\u0012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0004\b\b\u0010\tR\u001a\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u00038\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\u0006"}, d2 = {"Lid/dana/explore/data/toggle/source/ExploreConfigEntityDataFactory;", "Lid/dana/data/AbstractEntityDataFactory;", "Lid/dana/explore/data/toggle/ExploreConfigEntityData;", "Ldagger/Lazy;", "Lid/dana/explore/data/toggle/source/split/SplitExploreConfigEntityData;", "KClassImpl$Data$declaredNonStaticMembers$2", "Ldagger/Lazy;", "p0", "<init>", "(Ldagger/Lazy;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class ExploreConfigEntityDataFactory extends AbstractEntityDataFactory<ExploreConfigEntityData> {
    public final Lazy<SplitExploreConfigEntityData> KClassImpl$Data$declaredNonStaticMembers$2;

    @Override // id.dana.data.AbstractEntityDataFactory
    /* renamed from: createData */
    public final /* synthetic */ ExploreConfigEntityData createData2(String str) {
        Intrinsics.checkNotNullParameter(str, "");
        SplitExploreConfigEntityData splitExploreConfigEntityData = this.KClassImpl$Data$declaredNonStaticMembers$2.get();
        Intrinsics.checkNotNullExpressionValue(splitExploreConfigEntityData, "");
        return splitExploreConfigEntityData;
    }

    @Inject
    public ExploreConfigEntityDataFactory(Lazy<SplitExploreConfigEntityData> lazy) {
        Intrinsics.checkNotNullParameter(lazy, "");
        this.KClassImpl$Data$declaredNonStaticMembers$2 = lazy;
    }
}
