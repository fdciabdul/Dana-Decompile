package id.dana.danah5.imagecapture;

import dagger.MembersInjector;
import id.dana.core.ui.di.module.ViewModelFactory;
import javax.inject.Provider;

/* loaded from: classes8.dex */
public final class ImageCaptureActivity_MembersInjector implements MembersInjector<ImageCaptureActivity> {
    private final Provider<ViewModelFactory> viewModelFactoryProvider;

    public ImageCaptureActivity_MembersInjector(Provider<ViewModelFactory> provider) {
        this.viewModelFactoryProvider = provider;
    }

    public static MembersInjector<ImageCaptureActivity> create(Provider<ViewModelFactory> provider) {
        return new ImageCaptureActivity_MembersInjector(provider);
    }

    public final void injectMembers(ImageCaptureActivity imageCaptureActivity) {
        injectViewModelFactory(imageCaptureActivity, this.viewModelFactoryProvider.get());
    }

    public static void injectViewModelFactory(ImageCaptureActivity imageCaptureActivity, ViewModelFactory viewModelFactory) {
        imageCaptureActivity.viewModelFactory = viewModelFactory;
    }
}
