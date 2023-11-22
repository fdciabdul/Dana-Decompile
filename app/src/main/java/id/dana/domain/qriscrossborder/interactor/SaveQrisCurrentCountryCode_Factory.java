package id.dana.domain.qriscrossborder.interactor;

import dagger.internal.Factory;
import id.dana.domain.qriscrossborder.QrisCrossBorderRepository;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class SaveQrisCurrentCountryCode_Factory implements Factory<SaveQrisCurrentCountryCode> {
    private final Provider<QrisCrossBorderRepository> qrisCrossBorderRepositoryProvider;

    public SaveQrisCurrentCountryCode_Factory(Provider<QrisCrossBorderRepository> provider) {
        this.qrisCrossBorderRepositoryProvider = provider;
    }

    @Override // javax.inject.Provider
    public final SaveQrisCurrentCountryCode get() {
        return newInstance(this.qrisCrossBorderRepositoryProvider.get());
    }

    public static SaveQrisCurrentCountryCode_Factory create(Provider<QrisCrossBorderRepository> provider) {
        return new SaveQrisCurrentCountryCode_Factory(provider);
    }

    public static SaveQrisCurrentCountryCode newInstance(QrisCrossBorderRepository qrisCrossBorderRepository) {
        return new SaveQrisCurrentCountryCode(qrisCrossBorderRepository);
    }
}
