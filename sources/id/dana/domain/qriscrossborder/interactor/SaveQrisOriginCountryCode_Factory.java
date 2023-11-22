package id.dana.domain.qriscrossborder.interactor;

import dagger.internal.Factory;
import id.dana.domain.qriscrossborder.QrisCrossBorderRepository;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class SaveQrisOriginCountryCode_Factory implements Factory<SaveQrisOriginCountryCode> {
    private final Provider<QrisCrossBorderRepository> qrisCrossBorderRepositoryProvider;

    public SaveQrisOriginCountryCode_Factory(Provider<QrisCrossBorderRepository> provider) {
        this.qrisCrossBorderRepositoryProvider = provider;
    }

    @Override // javax.inject.Provider
    public final SaveQrisOriginCountryCode get() {
        return newInstance(this.qrisCrossBorderRepositoryProvider.get());
    }

    public static SaveQrisOriginCountryCode_Factory create(Provider<QrisCrossBorderRepository> provider) {
        return new SaveQrisOriginCountryCode_Factory(provider);
    }

    public static SaveQrisOriginCountryCode newInstance(QrisCrossBorderRepository qrisCrossBorderRepository) {
        return new SaveQrisOriginCountryCode(qrisCrossBorderRepository);
    }
}
