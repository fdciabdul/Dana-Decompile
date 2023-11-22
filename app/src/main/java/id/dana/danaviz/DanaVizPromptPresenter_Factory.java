package id.dana.danaviz;

import dagger.internal.DoubleCheck;
import dagger.internal.Factory;
import id.dana.danaviz.DanaVizPromptContract;
import id.dana.domain.account.interactor.GetPhoneNumber;
import id.dana.domain.account.interactor.GetUserId;
import id.dana.domain.auth.face.interactor.SwitchFaceAuthentication;
import id.dana.domain.resetpin.interactor.FinishForceDanaVizEnroll;
import id.dana.domain.resetpin.interactor.SaveDanaVizPromptAfterResetPin;
import id.dana.domain.resetpin.interactor.SaveForceDanaVizPrompt;
import id.dana.lib.bio.faceauth.FaceAuthentication;
import javax.inject.Provider;

/* loaded from: classes8.dex */
public final class DanaVizPromptPresenter_Factory implements Factory<DanaVizPromptPresenter> {
    private final Provider<FinishForceDanaVizEnroll> BuiltInFictitiousFunctionClassFactory;
    private final Provider<FaceAuthentication> KClassImpl$Data$declaredNonStaticMembers$2;
    private final Provider<GetUserId> MyBillsEntityDataFactory;
    private final Provider<GetPhoneNumber> PlaceComponentResult;
    private final Provider<SaveDanaVizPromptAfterResetPin> getAuthRequestContext;
    private final Provider<SwitchFaceAuthentication> getErrorConfigVersion;
    private final Provider<DanaVizPromptContract.View> moveToNextValue;
    private final Provider<SaveForceDanaVizPrompt> scheduleImpl;

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return new DanaVizPromptPresenter(this.moveToNextValue.get(), this.getErrorConfigVersion.get(), this.MyBillsEntityDataFactory.get(), this.KClassImpl$Data$declaredNonStaticMembers$2.get(), DoubleCheck.MyBillsEntityDataFactory(this.scheduleImpl), DoubleCheck.MyBillsEntityDataFactory(this.BuiltInFictitiousFunctionClassFactory), DoubleCheck.MyBillsEntityDataFactory(this.PlaceComponentResult), DoubleCheck.MyBillsEntityDataFactory(this.getAuthRequestContext));
    }
}
