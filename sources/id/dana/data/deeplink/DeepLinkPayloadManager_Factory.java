package id.dana.data.deeplink;

import dagger.internal.Factory;

/* loaded from: classes2.dex */
public final class DeepLinkPayloadManager_Factory implements Factory<DeepLinkPayloadManager> {
    @Override // javax.inject.Provider
    public final DeepLinkPayloadManager get() {
        return newInstance();
    }

    public static DeepLinkPayloadManager_Factory create() {
        return InstanceHolder.BuiltInFictitiousFunctionClassFactory;
    }

    public static DeepLinkPayloadManager newInstance() {
        return new DeepLinkPayloadManager();
    }

    /* loaded from: classes4.dex */
    static final class InstanceHolder {
        private static final DeepLinkPayloadManager_Factory BuiltInFictitiousFunctionClassFactory = new DeepLinkPayloadManager_Factory();

        private InstanceHolder() {
        }
    }
}
