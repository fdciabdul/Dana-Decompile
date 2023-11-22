package id.dana.nearbyme.merchantdetail.merchantphoto;

import dagger.internal.Factory;
import id.dana.domain.nearbyme.interactor.GetMerchantImage;
import id.dana.nearbyme.merchantdetail.mediaviewer.MediaViewerContract;
import id.dana.nearbyme.merchantdetail.model.MerchantImageModel;
import javax.inject.Provider;

/* loaded from: classes5.dex */
public final class MerchantPhotoViewerPresenter_Factory implements Factory<MerchantPhotoViewerPresenter> {
    private final Provider<GetMerchantImage> MyBillsEntityDataFactory;
    private final Provider<MediaViewerContract.View<MerchantImageModel>> PlaceComponentResult;

    private MerchantPhotoViewerPresenter_Factory(Provider<GetMerchantImage> provider, Provider<MediaViewerContract.View<MerchantImageModel>> provider2) {
        this.MyBillsEntityDataFactory = provider;
        this.PlaceComponentResult = provider2;
    }

    public static MerchantPhotoViewerPresenter_Factory KClassImpl$Data$declaredNonStaticMembers$2(Provider<GetMerchantImage> provider, Provider<MediaViewerContract.View<MerchantImageModel>> provider2) {
        return new MerchantPhotoViewerPresenter_Factory(provider, provider2);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return new MerchantPhotoViewerPresenter(this.MyBillsEntityDataFactory.get(), this.PlaceComponentResult.get());
    }
}
