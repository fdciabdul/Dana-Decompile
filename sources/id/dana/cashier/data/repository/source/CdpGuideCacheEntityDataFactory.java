package id.dana.cashier.data.repository.source;

import id.dana.data.AbstractEntityDataFactory;
import id.dana.data.cache.CacheEntityData;
import id.dana.data.cache.GeneralPreferencesCacheEntityData;
import id.dana.data.storage.GeneralPreferences;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000*\u0004\b\u0000\u0010\u00012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00030\u0002B\u0011\b\u0007\u0012\u0006\u0010\t\u001a\u00020\b¢\u0006\u0004\b\u000b\u0010\fJ\u001f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\u00032\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016¢\u0006\u0004\b\u0006\u0010\u0007R\u0014\u0010\t\u001a\u00020\b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\t\u0010\n"}, d2 = {"Lid/dana/cashier/data/repository/source/CdpGuideCacheEntityDataFactory;", "T", "Lid/dana/data/AbstractEntityDataFactory;", "Lid/dana/data/cache/CacheEntityData;", "", "source", "createData", "(Ljava/lang/String;)Lid/dana/data/cache/CacheEntityData;", "Lid/dana/data/storage/GeneralPreferences;", "generalPreferences", "Lid/dana/data/storage/GeneralPreferences;", "<init>", "(Lid/dana/data/storage/GeneralPreferences;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes.dex */
public final class CdpGuideCacheEntityDataFactory<T> extends AbstractEntityDataFactory<CacheEntityData<T>> {
    private final GeneralPreferences generalPreferences;

    @Inject
    public CdpGuideCacheEntityDataFactory(GeneralPreferences generalPreferences) {
        Intrinsics.checkNotNullParameter(generalPreferences, "");
        this.generalPreferences = generalPreferences;
    }

    @Override // id.dana.data.AbstractEntityDataFactory
    /* renamed from: createData */
    public final CacheEntityData<T> createData2(String source) {
        return new GeneralPreferencesCacheEntityData(this.generalPreferences);
    }
}
