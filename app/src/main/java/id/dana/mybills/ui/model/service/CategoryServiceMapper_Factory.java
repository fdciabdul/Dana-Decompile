package id.dana.mybills.ui.model.service;

import android.content.Context;
import dagger.internal.Factory;
import javax.inject.Provider;

/* loaded from: classes5.dex */
public final class CategoryServiceMapper_Factory implements Factory<CategoryServiceMapper> {
    private final Provider<Context> contextProvider;

    public CategoryServiceMapper_Factory(Provider<Context> provider) {
        this.contextProvider = provider;
    }

    @Override // javax.inject.Provider
    public final CategoryServiceMapper get() {
        return newInstance(this.contextProvider.get());
    }

    public static CategoryServiceMapper_Factory create(Provider<Context> provider) {
        return new CategoryServiceMapper_Factory(provider);
    }

    public static CategoryServiceMapper newInstance(Context context) {
        return new CategoryServiceMapper(context);
    }
}
