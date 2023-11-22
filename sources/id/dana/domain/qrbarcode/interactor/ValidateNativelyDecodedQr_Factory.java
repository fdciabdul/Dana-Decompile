package id.dana.domain.qrbarcode.interactor;

import dagger.internal.Factory;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class ValidateNativelyDecodedQr_Factory implements Factory<ValidateNativelyDecodedQr> {
    private final Provider<GetDecodeTciCoListConfig> getDecodeTciCoListConfigProvider;

    public ValidateNativelyDecodedQr_Factory(Provider<GetDecodeTciCoListConfig> provider) {
        this.getDecodeTciCoListConfigProvider = provider;
    }

    @Override // javax.inject.Provider
    public final ValidateNativelyDecodedQr get() {
        return newInstance(this.getDecodeTciCoListConfigProvider.get());
    }

    public static ValidateNativelyDecodedQr_Factory create(Provider<GetDecodeTciCoListConfig> provider) {
        return new ValidateNativelyDecodedQr_Factory(provider);
    }

    public static ValidateNativelyDecodedQr newInstance(GetDecodeTciCoListConfig getDecodeTciCoListConfig) {
        return new ValidateNativelyDecodedQr(getDecodeTciCoListConfig);
    }
}
