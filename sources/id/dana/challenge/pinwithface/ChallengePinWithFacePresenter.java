package id.dana.challenge.pinwithface;

import android.app.Activity;
import dagger.Lazy;
import id.dana.analytics.tracker.danaviz.DanaVizTracker;
import id.dana.analytics.tracker.danaviz.DanaVizTrackerImpl;
import id.dana.biometric.domain.model.BiometricDataSize;
import id.dana.biometric.presentation.RiskTracker;
import id.dana.challenge.pinwithface.ChallengePinWithFaceContract;
import id.dana.domain.core.usecase.NoParams;
import id.dana.domain.featureconfig.model.ResetAndChangePinNativeEntryConfig;
import id.dana.domain.resetpin.interactor.ConsultForceDanaVizEnrollAfterLogin;
import id.dana.domain.resetpin.interactor.GetResetAndChangePinNativeEntryConfig;
import id.dana.domain.resetpin.interactor.SaveDanaVizPromptAfterResetPin;
import id.dana.domain.resetpin.model.ConsultDanaVizModel;
import id.dana.lib.bio.faceauth.FaceAuthentication;
import id.dana.lib.bio.faceauth.FaceAuthenticationCallback;
import id.dana.lib.bio.faceauth.exception.DanaBioException;
import javax.inject.Inject;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;

/* loaded from: classes4.dex */
public class ChallengePinWithFacePresenter implements ChallengePinWithFaceContract.Presenter {
    private final Lazy<ConsultForceDanaVizEnrollAfterLogin> BuiltInFictitiousFunctionClassFactory;
    private final Lazy<GetResetAndChangePinNativeEntryConfig> KClassImpl$Data$declaredNonStaticMembers$2;
    private final DanaVizTrackerImpl MyBillsEntityDataFactory;
    final ChallengePinWithFaceContract.View PlaceComponentResult;
    private final FaceAuthentication getAuthRequestContext;
    private final Lazy<SaveDanaVizPromptAfterResetPin> getErrorConfigVersion;
    private final RiskTracker moveToNextValue;

    @Inject
    public ChallengePinWithFacePresenter(FaceAuthentication faceAuthentication, ChallengePinWithFaceContract.View view, RiskTracker riskTracker, DanaVizTrackerImpl danaVizTrackerImpl, Lazy<GetResetAndChangePinNativeEntryConfig> lazy, Lazy<SaveDanaVizPromptAfterResetPin> lazy2, Lazy<ConsultForceDanaVizEnrollAfterLogin> lazy3) {
        this.getAuthRequestContext = faceAuthentication;
        this.PlaceComponentResult = view;
        this.moveToNextValue = riskTracker;
        this.MyBillsEntityDataFactory = danaVizTrackerImpl;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = lazy;
        this.getErrorConfigVersion = lazy2;
        this.BuiltInFictitiousFunctionClassFactory = lazy3;
        danaVizTrackerImpl.setSource(DanaVizTracker.Source.LOGIN);
    }

    @Override // id.dana.challenge.pinwithface.ChallengePinWithFaceContract.Presenter
    public final void PlaceComponentResult(String str, Activity activity) {
        if (str == null) {
            str = "";
        }
        this.MyBillsEntityDataFactory.getAuthRequestContext++;
        this.MyBillsEntityDataFactory.getErrorConfigVersion();
        this.getAuthRequestContext.PlaceComponentResult(activity, str, new FaceAuthenticationCallback() { // from class: id.dana.challenge.pinwithface.ChallengePinWithFacePresenter.1
            @Override // id.dana.lib.bio.faceauth.FaceAuthenticationCallback
            public void onCancel() {
                ChallengePinWithFacePresenter.this.PlaceComponentResult.KClassImpl$Data$declaredNonStaticMembers$2();
                ChallengePinWithFacePresenter.this.MyBillsEntityDataFactory.lookAheadTest();
            }

            @Override // id.dana.lib.bio.faceauth.FaceAuthenticationCallback
            public void onFailed(DanaBioException.FaceAuthenticationException faceAuthenticationException) {
                ChallengePinWithFaceContract.View view = ChallengePinWithFacePresenter.this.PlaceComponentResult;
                faceAuthenticationException.getErrorCode();
                view.MyBillsEntityDataFactory();
                ChallengePinWithFacePresenter.this.MyBillsEntityDataFactory.KClassImpl$Data$declaredNonStaticMembers$2(faceAuthenticationException.getErrorCode(), faceAuthenticationException.getMessage());
            }

            @Override // id.dana.lib.bio.faceauth.FaceAuthenticationCallback
            public void onSuccess(String str2) {
                ChallengePinWithFacePresenter.this.PlaceComponentResult.BuiltInFictitiousFunctionClassFactory(str2);
                ChallengePinWithFacePresenter.this.MyBillsEntityDataFactory.scheduleImpl();
            }
        });
    }

    @Override // id.dana.challenge.pinwithface.ChallengePinWithFaceContract.Presenter
    public final void getAuthRequestContext(String str, Function0<Unit> function0, Function0<Unit> function02, Function1<? super Boolean, Unit> function1) {
        this.moveToNextValue.getAuthRequestContext(str, function0, function02, function1);
    }

    @Override // id.dana.challenge.pinwithface.ChallengePinWithFaceContract.Presenter
    public final void MyBillsEntityDataFactory(Function1<? super BiometricDataSize, Unit> function1) {
        this.moveToNextValue.MyBillsEntityDataFactory(function1);
    }

    @Override // id.dana.challenge.pinwithface.ChallengePinWithFaceContract.Presenter
    public final void getAuthRequestContext() {
        this.KClassImpl$Data$declaredNonStaticMembers$2.get().execute(NoParams.INSTANCE, new Function1() { // from class: id.dana.challenge.pinwithface.ChallengePinWithFacePresenter$$ExternalSyntheticLambda2
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                ChallengePinWithFacePresenter challengePinWithFacePresenter = ChallengePinWithFacePresenter.this;
                if (((ResetAndChangePinNativeEntryConfig) obj).getFeatureResetPinPreLogin()) {
                    challengePinWithFacePresenter.PlaceComponentResult.BuiltInFictitiousFunctionClassFactory();
                } else {
                    challengePinWithFacePresenter.PlaceComponentResult.getAuthRequestContext();
                }
                return Unit.INSTANCE;
            }
        }, new Function1() { // from class: id.dana.challenge.pinwithface.ChallengePinWithFacePresenter$$ExternalSyntheticLambda3
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Throwable th = (Throwable) obj;
                ChallengePinWithFacePresenter.this.PlaceComponentResult.getAuthRequestContext();
                return Unit.INSTANCE;
            }
        });
    }

    @Override // id.dana.challenge.pinwithface.ChallengePinWithFaceContract.Presenter
    public final void KClassImpl$Data$declaredNonStaticMembers$2(String str) {
        this.getErrorConfigVersion.get().execute(new SaveDanaVizPromptAfterResetPin.Params(str, true), new Function1() { // from class: id.dana.challenge.pinwithface.ChallengePinWithFacePresenter$$ExternalSyntheticLambda4
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit unit;
                Boolean bool = (Boolean) obj;
                unit = Unit.INSTANCE;
                return unit;
            }
        });
    }

    @Override // id.dana.challenge.pinwithface.ChallengePinWithFaceContract.Presenter
    public final void getAuthRequestContext(String str) {
        this.BuiltInFictitiousFunctionClassFactory.get().execute(new ConsultForceDanaVizEnrollAfterLogin.Params(str), new Function1() { // from class: id.dana.challenge.pinwithface.ChallengePinWithFacePresenter$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                ChallengePinWithFacePresenter.this.PlaceComponentResult.PlaceComponentResult(((ConsultDanaVizModel) obj).getIsShowDanaVizPrompt(), !r3.getIsForced());
                return Unit.INSTANCE;
            }
        }, new Function1() { // from class: id.dana.challenge.pinwithface.ChallengePinWithFacePresenter$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Throwable th = (Throwable) obj;
                ChallengePinWithFacePresenter.this.PlaceComponentResult.PlaceComponentResult(false, true);
                return Unit.INSTANCE;
            }
        });
    }

    @Override // id.dana.base.AbstractContractKt.AbstractPresenter, id.dana.base.AbstractContract.AbstractPresenter
    public void onDestroy() {
        this.getErrorConfigVersion.get().dispose();
        this.BuiltInFictitiousFunctionClassFactory.get().dispose();
        this.KClassImpl$Data$declaredNonStaticMembers$2.get().dispose();
    }
}
