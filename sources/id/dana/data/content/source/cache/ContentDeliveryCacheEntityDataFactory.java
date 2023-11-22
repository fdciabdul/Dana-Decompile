package id.dana.data.content.source.cache;

import id.dana.data.AbstractEntityDataFactory;
import id.dana.data.cache.CacheEntityData;
import id.dana.data.cache.GeneralPreferencesCacheEntityData;
import id.dana.data.content.source.network.result.SpaceRpcResult;
import id.dana.data.storage.GeneralPreferences;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* loaded from: classes2.dex */
public class ContentDeliveryCacheEntityDataFactory extends AbstractEntityDataFactory<CacheEntityData<SpaceRpcResult>> {
    private final GeneralPreferences generalPreferences;

    @Inject
    public ContentDeliveryCacheEntityDataFactory(GeneralPreferences generalPreferences) {
        this.generalPreferences = generalPreferences;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // id.dana.data.AbstractEntityDataFactory
    /* renamed from: createData */
    public CacheEntityData<SpaceRpcResult> createData2(String str) {
        return new GeneralPreferencesCacheEntityData(this.generalPreferences);
    }
}
