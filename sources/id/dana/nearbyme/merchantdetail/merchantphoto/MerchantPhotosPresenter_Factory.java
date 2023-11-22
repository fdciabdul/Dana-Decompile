package id.dana.nearbyme.merchantdetail.merchantphoto;

import dagger.internal.Factory;
import id.dana.domain.nearbyme.interactor.GetMerchantImage;
import id.dana.nearbyme.merchantdetail.merchantphoto.MerchantPhotoContract;
import javax.inject.Provider;

/* loaded from: classes9.dex */
public final class MerchantPhotosPresenter_Factory implements Factory<MerchantPhotosPresenter> {
    private final Provider<GetMerchantImage> KClassImpl$Data$declaredNonStaticMembers$2;
    private final Provider<MerchantPhotoContract.View> MyBillsEntityDataFactory;

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return new MerchantPhotosPresenter(this.MyBillsEntityDataFactory.get(), this.KClassImpl$Data$declaredNonStaticMembers$2.get());
    }
}
