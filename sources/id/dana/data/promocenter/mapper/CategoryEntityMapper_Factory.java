package id.dana.data.promocenter.mapper;

import dagger.internal.Factory;

/* loaded from: classes2.dex */
public final class CategoryEntityMapper_Factory implements Factory<CategoryEntityMapper> {
    @Override // javax.inject.Provider
    public final CategoryEntityMapper get() {
        return newInstance();
    }

    public static CategoryEntityMapper_Factory create() {
        return InstanceHolder.PlaceComponentResult;
    }

    public static CategoryEntityMapper newInstance() {
        return new CategoryEntityMapper();
    }

    /* loaded from: classes4.dex */
    static final class InstanceHolder {
        private static final CategoryEntityMapper_Factory PlaceComponentResult = new CategoryEntityMapper_Factory();

        private InstanceHolder() {
        }
    }
}
