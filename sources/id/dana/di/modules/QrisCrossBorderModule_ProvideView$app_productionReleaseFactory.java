package id.dana.di.modules;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import id.dana.qriscrossborder.QrisCrossBorderContract;

/* loaded from: classes4.dex */
public final class QrisCrossBorderModule_ProvideView$app_productionReleaseFactory implements Factory<QrisCrossBorderContract.View> {
    private final QrisCrossBorderModule getAuthRequestContext;

    private QrisCrossBorderModule_ProvideView$app_productionReleaseFactory(QrisCrossBorderModule qrisCrossBorderModule) {
        this.getAuthRequestContext = qrisCrossBorderModule;
    }

    public static QrisCrossBorderModule_ProvideView$app_productionReleaseFactory getAuthRequestContext(QrisCrossBorderModule qrisCrossBorderModule) {
        return new QrisCrossBorderModule_ProvideView$app_productionReleaseFactory(qrisCrossBorderModule);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return (QrisCrossBorderContract.View) Preconditions.BuiltInFictitiousFunctionClassFactory(this.getAuthRequestContext.getMyBillsEntityDataFactory());
    }
}
