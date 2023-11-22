package id.dana.data.feeds.mapper;

import dagger.internal.Factory;

/* loaded from: classes2.dex */
public final class FeedsResultMapper_Factory implements Factory<FeedsResultMapper> {
    @Override // javax.inject.Provider
    public final FeedsResultMapper get() {
        return newInstance();
    }

    public static FeedsResultMapper_Factory create() {
        return InstanceHolder.PlaceComponentResult;
    }

    public static FeedsResultMapper newInstance() {
        return new FeedsResultMapper();
    }

    /* loaded from: classes4.dex */
    static final class InstanceHolder {
        private static final FeedsResultMapper_Factory PlaceComponentResult = new FeedsResultMapper_Factory();

        private InstanceHolder() {
        }
    }
}
