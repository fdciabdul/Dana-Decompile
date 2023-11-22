package id.dana.data.feeds.repository.source.cache;

import id.dana.data.AbstractEntityDataFactory;
import id.dana.data.cache.CacheEntityData;
import id.dana.data.cache.GeneralPreferencesCacheEntityData;
import id.dana.data.storage.GeneralPreferences;
import id.dana.domain.feeds.model.Feeds;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* loaded from: classes2.dex */
public class FeedsCacheEntityDataFactory extends AbstractEntityDataFactory<CacheEntityData<Feeds>> {
    private final GeneralPreferences generalPreferences;

    @Inject
    public FeedsCacheEntityDataFactory(GeneralPreferences generalPreferences) {
        this.generalPreferences = generalPreferences;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // id.dana.data.AbstractEntityDataFactory
    /* renamed from: createData */
    public CacheEntityData<Feeds> createData2(String str) {
        return new GeneralPreferencesCacheEntityData(this.generalPreferences);
    }
}
