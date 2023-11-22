package id.dana.kyb.data.repository.source;

import dagger.internal.Factory;
import id.dana.kyb.data.repository.source.split.SplitKybConfigEntityData;
import javax.inject.Provider;

/* loaded from: classes2.dex */
public final class KybConfigEntityDataFactory_Factory implements Factory<KybConfigEntityDataFactory> {
    private final Provider<SplitKybConfigEntityData> MyBillsEntityDataFactory;

    private KybConfigEntityDataFactory_Factory(Provider<SplitKybConfigEntityData> provider) {
        this.MyBillsEntityDataFactory = provider;
    }

    public static KybConfigEntityDataFactory_Factory MyBillsEntityDataFactory(Provider<SplitKybConfigEntityData> provider) {
        return new KybConfigEntityDataFactory_Factory(provider);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return new KybConfigEntityDataFactory(this.MyBillsEntityDataFactory.get());
    }
}
