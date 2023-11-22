package id.dana.data.config.mapper;

import dagger.internal.Factory;

/* loaded from: classes2.dex */
public final class PromoCenterConfigMapper_Factory implements Factory<PromoCenterConfigMapper> {
    @Override // javax.inject.Provider
    public final PromoCenterConfigMapper get() {
        return newInstance();
    }

    public static PromoCenterConfigMapper_Factory create() {
        return InstanceHolder.PlaceComponentResult;
    }

    public static PromoCenterConfigMapper newInstance() {
        return new PromoCenterConfigMapper();
    }

    /* loaded from: classes4.dex */
    static final class InstanceHolder {
        private static final PromoCenterConfigMapper_Factory PlaceComponentResult = new PromoCenterConfigMapper_Factory();

        private InstanceHolder() {
        }
    }
}
