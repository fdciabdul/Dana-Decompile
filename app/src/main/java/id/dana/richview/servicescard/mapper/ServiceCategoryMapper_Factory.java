package id.dana.richview.servicescard.mapper;

import android.content.Context;
import dagger.internal.Factory;
import javax.inject.Provider;

/* loaded from: classes5.dex */
public final class ServiceCategoryMapper_Factory implements Factory<ServiceCategoryMapper> {
    private final Provider<Context> MyBillsEntityDataFactory;

    private ServiceCategoryMapper_Factory(Provider<Context> provider) {
        this.MyBillsEntityDataFactory = provider;
    }

    public static ServiceCategoryMapper_Factory getAuthRequestContext(Provider<Context> provider) {
        return new ServiceCategoryMapper_Factory(provider);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return new ServiceCategoryMapper(this.MyBillsEntityDataFactory.get());
    }
}
