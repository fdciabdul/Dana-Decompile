package id.dana.domain.imagecapture.interactor;

import dagger.internal.Factory;
import id.dana.domain.imagecapture.ImageCaptureRepository;
import javax.inject.Provider;

/* loaded from: classes8.dex */
public final class GetTipUploadPhotoCDP_Factory implements Factory<GetTipUploadPhotoCDP> {
    private final Provider<ImageCaptureRepository> imageCaptureRepositoryProvider;

    public GetTipUploadPhotoCDP_Factory(Provider<ImageCaptureRepository> provider) {
        this.imageCaptureRepositoryProvider = provider;
    }

    @Override // javax.inject.Provider
    public final GetTipUploadPhotoCDP get() {
        return newInstance(this.imageCaptureRepositoryProvider.get());
    }

    public static GetTipUploadPhotoCDP_Factory create(Provider<ImageCaptureRepository> provider) {
        return new GetTipUploadPhotoCDP_Factory(provider);
    }

    public static GetTipUploadPhotoCDP newInstance(ImageCaptureRepository imageCaptureRepository) {
        return new GetTipUploadPhotoCDP(imageCaptureRepository);
    }
}
