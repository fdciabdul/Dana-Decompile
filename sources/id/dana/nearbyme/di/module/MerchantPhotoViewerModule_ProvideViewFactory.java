package id.dana.nearbyme.di.module;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import id.dana.nearbyme.merchantdetail.mediaviewer.MediaViewerContract;
import id.dana.nearbyme.merchantdetail.model.MerchantImageModel;

/* loaded from: classes5.dex */
public final class MerchantPhotoViewerModule_ProvideViewFactory implements Factory<MediaViewerContract.View<MerchantImageModel>> {
    private final MerchantPhotoViewerModule MyBillsEntityDataFactory;

    private MerchantPhotoViewerModule_ProvideViewFactory(MerchantPhotoViewerModule merchantPhotoViewerModule) {
        this.MyBillsEntityDataFactory = merchantPhotoViewerModule;
    }

    public static MerchantPhotoViewerModule_ProvideViewFactory MyBillsEntityDataFactory(MerchantPhotoViewerModule merchantPhotoViewerModule) {
        return new MerchantPhotoViewerModule_ProvideViewFactory(merchantPhotoViewerModule);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return (MediaViewerContract.View) Preconditions.BuiltInFictitiousFunctionClassFactory(this.MyBillsEntityDataFactory.KClassImpl$Data$declaredNonStaticMembers$2());
    }
}
