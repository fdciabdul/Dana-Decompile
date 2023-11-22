package id.dana.explore.data.globalsearch.source;

import id.dana.data.AbstractEntityDataFactory;
import id.dana.explore.data.globalsearch.GlobalSearchCacheEntityData;
import javax.inject.Inject;
import javax.inject.Singleton;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Singleton
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0011\b\u0007\u0012\u0006\u0010\u0007\u001a\u00020\u0003¢\u0006\u0004\b\b\u0010\tR\u0014\u0010\u0006\u001a\u00020\u00038\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010\u0005"}, d2 = {"Lid/dana/explore/data/globalsearch/source/GlobalSearchCacheEntityDataFactory;", "Lid/dana/data/AbstractEntityDataFactory;", "Lid/dana/explore/data/globalsearch/GlobalSearchCacheEntityData;", "Lid/dana/explore/data/globalsearch/source/GlobalSearchPreferenceCacheEntityData;", "getAuthRequestContext", "Lid/dana/explore/data/globalsearch/source/GlobalSearchPreferenceCacheEntityData;", "PlaceComponentResult", "p0", "<init>", "(Lid/dana/explore/data/globalsearch/source/GlobalSearchPreferenceCacheEntityData;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class GlobalSearchCacheEntityDataFactory extends AbstractEntityDataFactory<GlobalSearchCacheEntityData> {

    /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
    public final GlobalSearchPreferenceCacheEntityData PlaceComponentResult;

    @Inject
    public GlobalSearchCacheEntityDataFactory(GlobalSearchPreferenceCacheEntityData globalSearchPreferenceCacheEntityData) {
        Intrinsics.checkNotNullParameter(globalSearchPreferenceCacheEntityData, "");
        this.PlaceComponentResult = globalSearchPreferenceCacheEntityData;
    }

    @Override // id.dana.data.AbstractEntityDataFactory
    /* renamed from: createData */
    public final /* bridge */ /* synthetic */ GlobalSearchCacheEntityData createData2(String str) {
        return this.PlaceComponentResult;
    }
}
