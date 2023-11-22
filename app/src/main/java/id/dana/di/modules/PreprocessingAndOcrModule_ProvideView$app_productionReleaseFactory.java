package id.dana.di.modules;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import id.dana.ocr.PreprocessingAndOcrContract;

/* loaded from: classes8.dex */
public final class PreprocessingAndOcrModule_ProvideView$app_productionReleaseFactory implements Factory<PreprocessingAndOcrContract.View> {
    private final PreprocessingAndOcrModule KClassImpl$Data$declaredNonStaticMembers$2;

    public static PreprocessingAndOcrContract.View BuiltInFictitiousFunctionClassFactory(PreprocessingAndOcrModule preprocessingAndOcrModule) {
        return (PreprocessingAndOcrContract.View) Preconditions.BuiltInFictitiousFunctionClassFactory(preprocessingAndOcrModule.getMyBillsEntityDataFactory());
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return (PreprocessingAndOcrContract.View) Preconditions.BuiltInFictitiousFunctionClassFactory(this.KClassImpl$Data$declaredNonStaticMembers$2.getMyBillsEntityDataFactory());
    }
}
