package id.dana.data.banner.repository.source;

import id.dana.data.AbstractEntityDataFactory;
import id.dana.data.banner.model.BannerListEntity;
import id.dana.data.cache.CacheEntityData;
import id.dana.data.cache.GeneralPreferencesCacheEntityData;
import id.dana.data.storage.GeneralPreferences;
import javax.inject.Inject;
import javax.inject.Singleton;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Singleton
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0007\u0018\u00002\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020\u0001B\u0011\b\u0007\u0012\u0006\u0010\b\u001a\u00020\u0004¢\u0006\u0004\b\t\u0010\nR\u0014\u0010\u0007\u001a\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\u0006"}, d2 = {"Lid/dana/data/banner/repository/source/BannerCacheEntityDataFactory;", "Lid/dana/data/AbstractEntityDataFactory;", "Lid/dana/data/cache/CacheEntityData;", "Lid/dana/data/banner/model/BannerListEntity;", "Lid/dana/data/storage/GeneralPreferences;", "MyBillsEntityDataFactory", "Lid/dana/data/storage/GeneralPreferences;", "KClassImpl$Data$declaredNonStaticMembers$2", "p0", "<init>", "(Lid/dana/data/storage/GeneralPreferences;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class BannerCacheEntityDataFactory extends AbstractEntityDataFactory<CacheEntityData<BannerListEntity>> {

    /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
    public final GeneralPreferences KClassImpl$Data$declaredNonStaticMembers$2;

    @Inject
    public BannerCacheEntityDataFactory(GeneralPreferences generalPreferences) {
        Intrinsics.checkNotNullParameter(generalPreferences, "");
        this.KClassImpl$Data$declaredNonStaticMembers$2 = generalPreferences;
    }

    @Override // id.dana.data.AbstractEntityDataFactory
    /* renamed from: createData */
    public final /* synthetic */ CacheEntityData<BannerListEntity> createData2(String str) {
        return new GeneralPreferencesCacheEntityData(this.KClassImpl$Data$declaredNonStaticMembers$2);
    }
}
