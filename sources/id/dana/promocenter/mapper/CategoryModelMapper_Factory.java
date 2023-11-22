package id.dana.promocenter.mapper;

import android.content.Context;
import dagger.internal.Factory;
import javax.inject.Provider;

/* loaded from: classes5.dex */
public final class CategoryModelMapper_Factory implements Factory<CategoryModelMapper> {
    private final Provider<Context> PlaceComponentResult;

    private CategoryModelMapper_Factory(Provider<Context> provider) {
        this.PlaceComponentResult = provider;
    }

    public static CategoryModelMapper_Factory KClassImpl$Data$declaredNonStaticMembers$2(Provider<Context> provider) {
        return new CategoryModelMapper_Factory(provider);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return new CategoryModelMapper(this.PlaceComponentResult.get());
    }
}
