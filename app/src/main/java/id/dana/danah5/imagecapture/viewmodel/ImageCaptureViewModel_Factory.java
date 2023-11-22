package id.dana.danah5.imagecapture.viewmodel;

import dagger.internal.Factory;
import id.dana.domain.imagecapture.interactor.GetTipUploadPhotoCDP;
import id.dana.phototips.mapper.PhotoTipsModelMapper;
import javax.inject.Provider;

/* loaded from: classes8.dex */
public final class ImageCaptureViewModel_Factory implements Factory<ImageCaptureViewModel> {
    private final Provider<GetTipUploadPhotoCDP> getTipUploadPhotoCDPProvider;
    private final Provider<PhotoTipsModelMapper> mapperProvider;

    public ImageCaptureViewModel_Factory(Provider<GetTipUploadPhotoCDP> provider, Provider<PhotoTipsModelMapper> provider2) {
        this.getTipUploadPhotoCDPProvider = provider;
        this.mapperProvider = provider2;
    }

    @Override // javax.inject.Provider
    public final ImageCaptureViewModel get() {
        return newInstance(this.getTipUploadPhotoCDPProvider.get(), this.mapperProvider.get());
    }

    public static ImageCaptureViewModel_Factory create(Provider<GetTipUploadPhotoCDP> provider, Provider<PhotoTipsModelMapper> provider2) {
        return new ImageCaptureViewModel_Factory(provider, provider2);
    }

    public static ImageCaptureViewModel newInstance(GetTipUploadPhotoCDP getTipUploadPhotoCDP, PhotoTipsModelMapper photoTipsModelMapper) {
        return new ImageCaptureViewModel(getTipUploadPhotoCDP, photoTipsModelMapper);
    }
}
