package id.dana.data.homeinfo.repository;

import dagger.internal.Factory;
import id.dana.data.config.source.split.SplitConfigEntityData;
import javax.inject.Provider;

/* loaded from: classes2.dex */
public final class HomeConfigEntityRepository_Factory implements Factory<HomeConfigEntityRepository> {
    private final Provider<SplitConfigEntityData> splitConfigEntityDataProvider;

    public HomeConfigEntityRepository_Factory(Provider<SplitConfigEntityData> provider) {
        this.splitConfigEntityDataProvider = provider;
    }

    @Override // javax.inject.Provider
    public final HomeConfigEntityRepository get() {
        return newInstance(this.splitConfigEntityDataProvider.get());
    }

    public static HomeConfigEntityRepository_Factory create(Provider<SplitConfigEntityData> provider) {
        return new HomeConfigEntityRepository_Factory(provider);
    }

    public static HomeConfigEntityRepository newInstance(SplitConfigEntityData splitConfigEntityData) {
        return new HomeConfigEntityRepository(splitConfigEntityData);
    }
}
