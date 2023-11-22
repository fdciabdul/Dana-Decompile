package id.dana.contract.switchfaceauth;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import id.dana.contract.switchfaceauth.FaceAuthPopUpConsultationContract;

/* loaded from: classes8.dex */
public final class FaceAuthPopUpConsultationModule_ProvideViewFactory implements Factory<FaceAuthPopUpConsultationContract.View> {
    private final FaceAuthPopUpConsultationModule getAuthRequestContext;

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return (FaceAuthPopUpConsultationContract.View) Preconditions.BuiltInFictitiousFunctionClassFactory(this.getAuthRequestContext.getBuiltInFictitiousFunctionClassFactory());
    }
}
