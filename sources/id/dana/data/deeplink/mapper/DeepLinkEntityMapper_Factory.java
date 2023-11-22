package id.dana.data.deeplink.mapper;

import dagger.internal.Factory;

/* loaded from: classes2.dex */
public final class DeepLinkEntityMapper_Factory implements Factory<DeepLinkEntityMapper> {
    @Override // javax.inject.Provider
    public final DeepLinkEntityMapper get() {
        return newInstance();
    }

    public static DeepLinkEntityMapper_Factory create() {
        return InstanceHolder.PlaceComponentResult;
    }

    public static DeepLinkEntityMapper newInstance() {
        return new DeepLinkEntityMapper();
    }

    /* loaded from: classes4.dex */
    static final class InstanceHolder {
        private static final DeepLinkEntityMapper_Factory PlaceComponentResult = new DeepLinkEntityMapper_Factory();

        private InstanceHolder() {
        }
    }
}
