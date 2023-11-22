package id.dana.nearbyme.di.module;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import id.dana.nearbyme.merchantdetail.mediaviewer.MediaViewerContract;
import id.dana.nearbyme.merchantdetail.merchantphoto.MerchantPhotoViewerPresenter;
import id.dana.nearbyme.merchantdetail.model.MerchantImageModel;
import javax.inject.Provider;

/* loaded from: classes5.dex */
public final class MerchantPhotoViewerModule_ProvideMerchantPhotoViewerPresenterFactory implements Factory<MediaViewerContract.Presenter<MerchantImageModel>> {
    private final Provider<MerchantPhotoViewerPresenter> BuiltInFictitiousFunctionClassFactory;
    private final MerchantPhotoViewerModule getAuthRequestContext;

    private MerchantPhotoViewerModule_ProvideMerchantPhotoViewerPresenterFactory(MerchantPhotoViewerModule merchantPhotoViewerModule, Provider<MerchantPhotoViewerPresenter> provider) {
        this.getAuthRequestContext = merchantPhotoViewerModule;
        this.BuiltInFictitiousFunctionClassFactory = provider;
    }

    public static MerchantPhotoViewerModule_ProvideMerchantPhotoViewerPresenterFactory PlaceComponentResult(MerchantPhotoViewerModule merchantPhotoViewerModule, Provider<MerchantPhotoViewerPresenter> provider) {
        return new MerchantPhotoViewerModule_ProvideMerchantPhotoViewerPresenterFactory(merchantPhotoViewerModule, provider);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return (MediaViewerContract.Presenter) Preconditions.BuiltInFictitiousFunctionClassFactory(this.getAuthRequestContext.KClassImpl$Data$declaredNonStaticMembers$2(this.BuiltInFictitiousFunctionClassFactory.get()));
    }
}
