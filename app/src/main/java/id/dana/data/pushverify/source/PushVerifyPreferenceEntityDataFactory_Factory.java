package id.dana.data.pushverify.source;

import dagger.internal.Factory;
import id.dana.data.pushverify.source.local.LocalPushVerifyPreferenceEntityData;
import javax.inject.Provider;

/* loaded from: classes2.dex */
public final class PushVerifyPreferenceEntityDataFactory_Factory implements Factory<PushVerifyPreferenceEntityDataFactory> {
    private final Provider<LocalPushVerifyPreferenceEntityData> localPushVerifyPreferenceEntityDataProvider;

    public PushVerifyPreferenceEntityDataFactory_Factory(Provider<LocalPushVerifyPreferenceEntityData> provider) {
        this.localPushVerifyPreferenceEntityDataProvider = provider;
    }

    @Override // javax.inject.Provider
    public final PushVerifyPreferenceEntityDataFactory get() {
        return newInstance(this.localPushVerifyPreferenceEntityDataProvider.get());
    }

    public static PushVerifyPreferenceEntityDataFactory_Factory create(Provider<LocalPushVerifyPreferenceEntityData> provider) {
        return new PushVerifyPreferenceEntityDataFactory_Factory(provider);
    }

    public static PushVerifyPreferenceEntityDataFactory newInstance(LocalPushVerifyPreferenceEntityData localPushVerifyPreferenceEntityData) {
        return new PushVerifyPreferenceEntityDataFactory(localPushVerifyPreferenceEntityData);
    }
}
