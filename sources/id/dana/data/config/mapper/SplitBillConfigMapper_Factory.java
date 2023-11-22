package id.dana.data.config.mapper;

import dagger.internal.Factory;

/* loaded from: classes2.dex */
public final class SplitBillConfigMapper_Factory implements Factory<SplitBillConfigMapper> {
    @Override // javax.inject.Provider
    public final SplitBillConfigMapper get() {
        return newInstance();
    }

    public static SplitBillConfigMapper_Factory create() {
        return InstanceHolder.PlaceComponentResult;
    }

    public static SplitBillConfigMapper newInstance() {
        return new SplitBillConfigMapper();
    }

    /* loaded from: classes4.dex */
    static final class InstanceHolder {
        private static final SplitBillConfigMapper_Factory PlaceComponentResult = new SplitBillConfigMapper_Factory();

        private InstanceHolder() {
        }
    }
}
