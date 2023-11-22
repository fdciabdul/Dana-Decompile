package id.dana.di.modules;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import id.dana.ocr.UploadSnapReceiptContract;

/* loaded from: classes8.dex */
public final class UploadSnapReceiptModule_ProvideView$app_productionReleaseFactory implements Factory<UploadSnapReceiptContract.View> {
    private final UploadSnapReceiptModule KClassImpl$Data$declaredNonStaticMembers$2;

    private UploadSnapReceiptModule_ProvideView$app_productionReleaseFactory(UploadSnapReceiptModule uploadSnapReceiptModule) {
        this.KClassImpl$Data$declaredNonStaticMembers$2 = uploadSnapReceiptModule;
    }

    public static UploadSnapReceiptModule_ProvideView$app_productionReleaseFactory PlaceComponentResult(UploadSnapReceiptModule uploadSnapReceiptModule) {
        return new UploadSnapReceiptModule_ProvideView$app_productionReleaseFactory(uploadSnapReceiptModule);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return (UploadSnapReceiptContract.View) Preconditions.BuiltInFictitiousFunctionClassFactory(this.KClassImpl$Data$declaredNonStaticMembers$2.getMyBillsEntityDataFactory());
    }
}
