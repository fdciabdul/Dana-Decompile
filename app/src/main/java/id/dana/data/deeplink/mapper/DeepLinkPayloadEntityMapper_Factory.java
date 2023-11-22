package id.dana.data.deeplink.mapper;

import dagger.internal.Factory;

/* loaded from: classes2.dex */
public final class DeepLinkPayloadEntityMapper_Factory implements Factory<DeepLinkPayloadEntityMapper> {
    @Override // javax.inject.Provider
    public final DeepLinkPayloadEntityMapper get() {
        return newInstance();
    }

    public static DeepLinkPayloadEntityMapper_Factory create() {
        return InstanceHolder.MyBillsEntityDataFactory;
    }

    public static DeepLinkPayloadEntityMapper newInstance() {
        return new DeepLinkPayloadEntityMapper();
    }

    /* loaded from: classes4.dex */
    static final class InstanceHolder {
        private static final DeepLinkPayloadEntityMapper_Factory MyBillsEntityDataFactory = new DeepLinkPayloadEntityMapper_Factory();

        private InstanceHolder() {
        }
    }
}
