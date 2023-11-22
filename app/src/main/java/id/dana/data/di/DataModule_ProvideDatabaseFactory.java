package id.dana.data.di;

import android.content.Context;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import id.dana.data.base.BasePersistenceDao;
import javax.inject.Provider;

/* loaded from: classes2.dex */
public final class DataModule_ProvideDatabaseFactory implements Factory<BasePersistenceDao> {
    private final Provider<Context> contextProvider;

    public DataModule_ProvideDatabaseFactory(Provider<Context> provider) {
        this.contextProvider = provider;
    }

    @Override // javax.inject.Provider
    public final BasePersistenceDao get() {
        return provideDatabase(this.contextProvider.get());
    }

    public static DataModule_ProvideDatabaseFactory create(Provider<Context> provider) {
        return new DataModule_ProvideDatabaseFactory(provider);
    }

    public static BasePersistenceDao provideDatabase(Context context) {
        return (BasePersistenceDao) Preconditions.BuiltInFictitiousFunctionClassFactory(DataModule.INSTANCE.provideDatabase(context));
    }
}
