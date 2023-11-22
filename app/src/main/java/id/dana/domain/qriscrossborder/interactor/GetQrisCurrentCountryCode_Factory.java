package id.dana.domain.qriscrossborder.interactor;

import dagger.internal.Factory;
import id.dana.domain.qriscrossborder.QrisCrossBorderRepository;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class GetQrisCurrentCountryCode_Factory implements Factory<GetQrisCurrentCountryCode> {
    private final Provider<QrisCrossBorderRepository> qrisCrossBorderRepositoryProvider;

    public GetQrisCurrentCountryCode_Factory(Provider<QrisCrossBorderRepository> provider) {
        this.qrisCrossBorderRepositoryProvider = provider;
    }

    @Override // javax.inject.Provider
    public final GetQrisCurrentCountryCode get() {
        return newInstance(this.qrisCrossBorderRepositoryProvider.get());
    }

    public static GetQrisCurrentCountryCode_Factory create(Provider<QrisCrossBorderRepository> provider) {
        return new GetQrisCurrentCountryCode_Factory(provider);
    }

    public static GetQrisCurrentCountryCode newInstance(QrisCrossBorderRepository qrisCrossBorderRepository) {
        return new GetQrisCurrentCountryCode(qrisCrossBorderRepository);
    }
}
