package id.dana.di.component;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import id.dana.nearbyme.merchantdetail.merchantphoto.MerchantPhotoContract;

/* loaded from: classes4.dex */
public final class MerchantPhotoModule_ProvideMerchantPhotoViewFactory implements Factory<MerchantPhotoContract.View> {
    private final MerchantPhotoModule BuiltInFictitiousFunctionClassFactory;

    private MerchantPhotoModule_ProvideMerchantPhotoViewFactory(MerchantPhotoModule merchantPhotoModule) {
        this.BuiltInFictitiousFunctionClassFactory = merchantPhotoModule;
    }

    public static MerchantPhotoModule_ProvideMerchantPhotoViewFactory KClassImpl$Data$declaredNonStaticMembers$2(MerchantPhotoModule merchantPhotoModule) {
        return new MerchantPhotoModule_ProvideMerchantPhotoViewFactory(merchantPhotoModule);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return (MerchantPhotoContract.View) Preconditions.BuiltInFictitiousFunctionClassFactory(this.BuiltInFictitiousFunctionClassFactory.getMyBillsEntityDataFactory());
    }
}
