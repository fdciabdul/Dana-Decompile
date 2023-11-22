package id.dana.danaviz;

import android.app.Activity;
import dagger.Lazy;
import id.dana.base.AbstractContractKt;
import id.dana.danah5.faceverificationenablement.DefaultFaceAuthenticationManager;
import id.dana.danaviz.DanaVizPromptContract;
import id.dana.domain.DefaultObserver;
import id.dana.domain.account.interactor.GetPhoneNumber;
import id.dana.domain.account.interactor.GetUserId;
import id.dana.domain.auth.face.interactor.SwitchFaceAuthentication;
import id.dana.domain.auth.face.result.FaceAuthenticationResult;
import id.dana.domain.auth.face.result.SecurityContext;
import id.dana.domain.auth.face.result.VerificationMethodInfo;
import id.dana.domain.core.usecase.BaseUseCase;
import id.dana.domain.core.usecase.CompletableUseCase;
import id.dana.domain.core.usecase.NoParams;
import id.dana.domain.resetpin.interactor.FinishForceDanaVizEnroll;
import id.dana.domain.resetpin.interactor.SaveDanaVizPromptAfterResetPin;
import id.dana.domain.resetpin.interactor.SaveForceDanaVizPrompt;
import id.dana.lib.bio.faceauth.FaceAuthentication;
import id.dana.lib.bio.faceauth.FaceAuthenticationCallback;
import id.dana.lib.bio.faceauth.exception.DanaBioException;
import java.util.Iterator;
import java.util.List;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001Ba\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\"\u0012\u0006\u0010\u0005\u001a\u00020 \u0012\u0006\u0010\u0007\u001a\u00020\u0017\u0012\u0006\u0010\b\u001a\u00020\u000f\u0012\f\u0010%\u001a\b\u0012\u0004\u0012\u00020\u001e0\u0012\u0012\f\u0010&\u001a\b\u0012\u0004\u0012\u00020\u00130\u0012\u0012\f\u0010'\u001a\b\u0012\u0004\u0012\u00020\u00150\u0012\u0012\f\u0010(\u001a\b\u0012\u0004\u0012\u00020\u001b0\u0012¢\u0006\u0004\b)\u0010*J/\u0010\n\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\n\u0010\u000bJ\u000f\u0010\f\u001a\u00020\tH\u0016¢\u0006\u0004\b\f\u0010\rJ\u0017\u0010\n\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\n\u0010\rJ\u000f\u0010\u000e\u001a\u00020\tH\u0000¢\u0006\u0004\b\u000e\u0010\rR\u0014\u0010\u0010\u001a\u00020\u000f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u001a\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00130\u00128\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\u0014R\u001a\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00150\u00128\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0016\u0010\u0014R\u0014\u0010\u0016\u001a\u00020\u00178\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\n\u0010\u0018R\u0016\u0010\u0019\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u001a\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u001b0\u00128\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001c\u0010\u0014R\u001a\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u001e0\u00128\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001d\u0010\u0014R\u0014\u0010\u001c\u001a\u00020 8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001f\u0010!R\u0014\u0010#\u001a\u00020\"8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b#\u0010$"}, d2 = {"Lid/dana/danaviz/DanaVizPromptPresenter;", "Lid/dana/danaviz/DanaVizPromptContract$Presenter;", "", "p0", "Landroid/app/Activity;", "p1", "", "p2", "p3", "", "MyBillsEntityDataFactory", "(ZLandroid/app/Activity;Ljava/lang/String;Ljava/lang/String;)V", "onDestroy", "()V", "BuiltInFictitiousFunctionClassFactory", "Lid/dana/lib/bio/faceauth/FaceAuthentication;", "KClassImpl$Data$declaredNonStaticMembers$2", "Lid/dana/lib/bio/faceauth/FaceAuthentication;", "Ldagger/Lazy;", "Lid/dana/domain/resetpin/interactor/FinishForceDanaVizEnroll;", "Ldagger/Lazy;", "Lid/dana/domain/account/interactor/GetPhoneNumber;", "getAuthRequestContext", "Lid/dana/domain/account/interactor/GetUserId;", "Lid/dana/domain/account/interactor/GetUserId;", "PlaceComponentResult", "Ljava/lang/String;", "Lid/dana/domain/resetpin/interactor/SaveDanaVizPromptAfterResetPin;", "NetworkUserEntityData$$ExternalSyntheticLambda0", "getErrorConfigVersion", "Lid/dana/domain/resetpin/interactor/SaveForceDanaVizPrompt;", "scheduleImpl", "Lid/dana/domain/auth/face/interactor/SwitchFaceAuthentication;", "Lid/dana/domain/auth/face/interactor/SwitchFaceAuthentication;", "Lid/dana/danaviz/DanaVizPromptContract$View;", "lookAheadTest", "Lid/dana/danaviz/DanaVizPromptContract$View;", "p4", "p5", "p6", "p7", "<init>", "(Lid/dana/danaviz/DanaVizPromptContract$View;Lid/dana/domain/auth/face/interactor/SwitchFaceAuthentication;Lid/dana/domain/account/interactor/GetUserId;Lid/dana/lib/bio/faceauth/FaceAuthentication;Ldagger/Lazy;Ldagger/Lazy;Ldagger/Lazy;Ldagger/Lazy;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class DanaVizPromptPresenter implements DanaVizPromptContract.Presenter {

    /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
    private final Lazy<FinishForceDanaVizEnroll> MyBillsEntityDataFactory;
    private final FaceAuthentication KClassImpl$Data$declaredNonStaticMembers$2;

    /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
    private final GetUserId getAuthRequestContext;

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda0  reason: from kotlin metadata */
    private final Lazy<SaveDanaVizPromptAfterResetPin> getErrorConfigVersion;
    private String PlaceComponentResult;

    /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
    private final Lazy<GetPhoneNumber> BuiltInFictitiousFunctionClassFactory;

    /* renamed from: getErrorConfigVersion  reason: from kotlin metadata */
    private final Lazy<SaveForceDanaVizPrompt> scheduleImpl;
    private final DanaVizPromptContract.View lookAheadTest;

    /* renamed from: scheduleImpl  reason: from kotlin metadata */
    private final SwitchFaceAuthentication NetworkUserEntityData$$ExternalSyntheticLambda0;

    @Inject
    public DanaVizPromptPresenter(DanaVizPromptContract.View view, SwitchFaceAuthentication switchFaceAuthentication, GetUserId getUserId, FaceAuthentication faceAuthentication, Lazy<SaveForceDanaVizPrompt> lazy, Lazy<FinishForceDanaVizEnroll> lazy2, Lazy<GetPhoneNumber> lazy3, Lazy<SaveDanaVizPromptAfterResetPin> lazy4) {
        Intrinsics.checkNotNullParameter(view, "");
        Intrinsics.checkNotNullParameter(switchFaceAuthentication, "");
        Intrinsics.checkNotNullParameter(getUserId, "");
        Intrinsics.checkNotNullParameter(faceAuthentication, "");
        Intrinsics.checkNotNullParameter(lazy, "");
        Intrinsics.checkNotNullParameter(lazy2, "");
        Intrinsics.checkNotNullParameter(lazy3, "");
        Intrinsics.checkNotNullParameter(lazy4, "");
        this.lookAheadTest = view;
        this.NetworkUserEntityData$$ExternalSyntheticLambda0 = switchFaceAuthentication;
        this.getAuthRequestContext = getUserId;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = faceAuthentication;
        this.scheduleImpl = lazy;
        this.MyBillsEntityDataFactory = lazy2;
        this.BuiltInFictitiousFunctionClassFactory = lazy3;
        this.getErrorConfigVersion = lazy4;
        this.PlaceComponentResult = "";
    }

    @Override // id.dana.danaviz.DanaVizPromptContract.Presenter
    public final void MyBillsEntityDataFactory(final boolean p0, final Activity p1, String p2, String p3) {
        Intrinsics.checkNotNullParameter(p1, "");
        Intrinsics.checkNotNullParameter(p2, "");
        Intrinsics.checkNotNullParameter(p3, "");
        this.PlaceComponentResult = p3;
        this.NetworkUserEntityData$$ExternalSyntheticLambda0.execute(new SwitchFaceAuthentication.Params(p0, p2, p3), new Function1<FaceAuthenticationResult, Unit>() { // from class: id.dana.danaviz.DanaVizPromptPresenter$doSwitchFaceAuth$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final /* bridge */ /* synthetic */ Unit invoke(FaceAuthenticationResult faceAuthenticationResult) {
                invoke2(faceAuthenticationResult);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(FaceAuthenticationResult faceAuthenticationResult) {
                Intrinsics.checkNotNullParameter(faceAuthenticationResult, "");
                DanaVizPromptPresenter.getAuthRequestContext(DanaVizPromptPresenter.this, p0, faceAuthenticationResult, p1);
            }
        }, new Function1<Throwable, Unit>() { // from class: id.dana.danaviz.DanaVizPromptPresenter$doSwitchFaceAuth$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
                invoke2(th);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(Throwable th) {
                DanaVizPromptContract.View view;
                Intrinsics.checkNotNullParameter(th, "");
                view = DanaVizPromptPresenter.this.lookAheadTest;
                view.getAuthRequestContext();
            }
        });
    }

    @Override // id.dana.danaviz.DanaVizPromptContract.Presenter
    public final void MyBillsEntityDataFactory() {
        this.BuiltInFictitiousFunctionClassFactory.get().execute(new DefaultObserver<String>() { // from class: id.dana.danaviz.DanaVizPromptPresenter$saveDanaVizPromptAfterResetPin$1
            final /* synthetic */ boolean PlaceComponentResult = false;

            @Override // id.dana.domain.DefaultObserver, io.reactivex.Observer
            public final /* synthetic */ void onNext(Object obj) {
                String str = (String) obj;
                Intrinsics.checkNotNullParameter(str, "");
                r0.getErrorConfigVersion.get().execute(new SaveDanaVizPromptAfterResetPin.Params(str, this.PlaceComponentResult), new Function1<Boolean, Unit>() { // from class: id.dana.danaviz.DanaVizPromptPresenter$saveDanaVizPromptFlag$1
                    /* JADX INFO: Access modifiers changed from: package-private */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final /* synthetic */ Unit invoke(Boolean bool) {
                        invoke(bool.booleanValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(boolean z) {
                        DanaVizPromptContract.View view;
                        view = DanaVizPromptPresenter.this.lookAheadTest;
                        view.BuiltInFictitiousFunctionClassFactory();
                    }
                }, new Function1<Throwable, Unit>() { // from class: id.dana.danaviz.DanaVizPromptPresenter$saveDanaVizPromptFlag$2
                    /* JADX INFO: Access modifiers changed from: package-private */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
                        invoke2(th);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke  reason: avoid collision after fix types in other method */
                    public final void invoke2(Throwable th) {
                        DanaVizPromptContract.View view;
                        Intrinsics.checkNotNullParameter(th, "");
                        view = DanaVizPromptPresenter.this.lookAheadTest;
                        view.BuiltInFictitiousFunctionClassFactory();
                    }
                });
            }

            @Override // id.dana.domain.DefaultObserver, io.reactivex.Observer
            public final void onError(Throwable p0) {
                DanaVizPromptContract.View view;
                Intrinsics.checkNotNullParameter(p0, "");
                view = DanaVizPromptPresenter.this.lookAheadTest;
                view.BuiltInFictitiousFunctionClassFactory();
            }
        });
    }

    public final void BuiltInFictitiousFunctionClassFactory() {
        SaveForceDanaVizPrompt saveForceDanaVizPrompt = this.scheduleImpl.get();
        Intrinsics.checkNotNullExpressionValue(saveForceDanaVizPrompt, "");
        BaseUseCase.execute$default(saveForceDanaVizPrompt, Boolean.FALSE, new Function1<Unit, Unit>() { // from class: id.dana.danaviz.DanaVizPromptPresenter$saveSuccessEnrollDanaViz$1
            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(Unit unit) {
                Intrinsics.checkNotNullParameter(unit, "");
            }

            @Override // kotlin.jvm.functions.Function1
            public final /* bridge */ /* synthetic */ Unit invoke(Unit unit) {
                invoke2(unit);
                return Unit.INSTANCE;
            }
        }, null, 4, null);
    }

    @Override // id.dana.base.AbstractContractKt.AbstractPresenter, id.dana.base.AbstractContract.AbstractPresenter
    public final void onDestroy() {
        AbstractContractKt.AbstractPresenter.CC.BuiltInFictitiousFunctionClassFactory();
        this.NetworkUserEntityData$$ExternalSyntheticLambda0.dispose();
        this.getAuthRequestContext.dispose();
        this.scheduleImpl.get().dispose();
        this.MyBillsEntityDataFactory.get().dispose();
    }

    public static final /* synthetic */ void getAuthRequestContext(final DanaVizPromptPresenter danaVizPromptPresenter, final boolean z, FaceAuthenticationResult faceAuthenticationResult, final Activity activity) {
        String action = faceAuthenticationResult.getAction();
        if (action != null) {
            int hashCode = action.hashCode();
            if (hashCode == -795785494) {
                if (action.equals(DefaultFaceAuthenticationManager.Companion.ActionConstant.TO_ENROLL)) {
                    danaVizPromptPresenter.getAuthRequestContext.execute(new DefaultObserver<String>() { // from class: id.dana.danaviz.DanaVizPromptPresenter$doEnroll$1
                        @Override // id.dana.domain.DefaultObserver, io.reactivex.Observer
                        public final /* synthetic */ void onNext(Object obj) {
                            String str = (String) obj;
                            Intrinsics.checkNotNullParameter(str, "");
                            FaceAuthentication.DefaultImpls.BuiltInFictitiousFunctionClassFactory(r0.KClassImpl$Data$declaredNonStaticMembers$2, activity, str, new FaceAuthenticationCallback() { // from class: id.dana.danaviz.DanaVizPromptPresenter$startEnrollFaceAuth$1
                                @Override // id.dana.lib.bio.faceauth.FaceAuthenticationCallback
                                public final void onCancel() {
                                }

                                @Override // id.dana.lib.bio.faceauth.FaceAuthenticationCallback
                                public final void onFailed(DanaBioException.FaceAuthenticationException p0) {
                                    DanaVizPromptContract.View view;
                                    Intrinsics.checkNotNullParameter(p0, "");
                                    view = DanaVizPromptPresenter.this.lookAheadTest;
                                    view.getAuthRequestContext();
                                }

                                @Override // id.dana.lib.bio.faceauth.FaceAuthenticationCallback
                                public final void onSuccess(String p0) {
                                    DanaVizPromptContract.View view;
                                    Intrinsics.checkNotNullParameter(p0, "");
                                    view = DanaVizPromptPresenter.this.lookAheadTest;
                                    view.PlaceComponentResult();
                                    DanaVizPromptPresenter.this.BuiltInFictitiousFunctionClassFactory();
                                    DanaVizPromptPresenter.KClassImpl$Data$declaredNonStaticMembers$2(DanaVizPromptPresenter.this);
                                }
                            });
                        }

                        @Override // id.dana.domain.DefaultObserver, io.reactivex.Observer
                        public final void onError(Throwable p0) {
                            DanaVizPromptContract.View view;
                            Intrinsics.checkNotNullParameter(p0, "");
                            view = DanaVizPromptPresenter.this.lookAheadTest;
                            view.getAuthRequestContext();
                        }
                    });
                }
            } else if (hashCode != -407149037) {
                if (hashCode == 458732895 && action.equals(DefaultFaceAuthenticationManager.Companion.ActionConstant.SUCCESS_ENABLE)) {
                    danaVizPromptPresenter.lookAheadTest.PlaceComponentResult();
                    danaVizPromptPresenter.BuiltInFictitiousFunctionClassFactory();
                }
            } else if (action.equals(DefaultFaceAuthenticationManager.Companion.ActionConstant.TO_RISK)) {
                List<VerificationMethodInfo> verificationMethods = faceAuthenticationResult.getVerificationMethods();
                final String securityId = faceAuthenticationResult.getSecurityId();
                if (securityId == null) {
                    securityId = "";
                }
                SecurityContext securityContext = faceAuthenticationResult.getSecurityContext();
                String pubKey = securityContext != null ? securityContext.getPubKey() : null;
                if (verificationMethods != null) {
                    Iterator<VerificationMethodInfo> it = verificationMethods.iterator();
                    while (it.hasNext()) {
                        String verificationMethod = it.next().getVerificationMethod();
                        if (Intrinsics.areEqual(verificationMethod, "PASSWORD")) {
                            danaVizPromptPresenter.lookAheadTest.MyBillsEntityDataFactory(securityId, pubKey == null ? "" : pubKey, z);
                        } else if (Intrinsics.areEqual(verificationMethod, "MIC_FACE")) {
                            danaVizPromptPresenter.KClassImpl$Data$declaredNonStaticMembers$2.PlaceComponentResult(activity, securityId, new FaceAuthenticationCallback() { // from class: id.dana.danaviz.DanaVizPromptPresenter$doFaceAuth$1
                                @Override // id.dana.lib.bio.faceauth.FaceAuthenticationCallback
                                public final void onCancel() {
                                }

                                @Override // id.dana.lib.bio.faceauth.FaceAuthenticationCallback
                                public final void onFailed(DanaBioException.FaceAuthenticationException p0) {
                                    DanaVizPromptContract.View view;
                                    Intrinsics.checkNotNullParameter(p0, "");
                                    view = DanaVizPromptPresenter.this.lookAheadTest;
                                    view.getAuthRequestContext();
                                }

                                @Override // id.dana.lib.bio.faceauth.FaceAuthenticationCallback
                                public final void onSuccess(String p0) {
                                    String str;
                                    Intrinsics.checkNotNullParameter(p0, "");
                                    DanaVizPromptPresenter danaVizPromptPresenter2 = DanaVizPromptPresenter.this;
                                    boolean z2 = z;
                                    Activity activity2 = activity;
                                    String str2 = securityId;
                                    str = danaVizPromptPresenter2.PlaceComponentResult;
                                    danaVizPromptPresenter2.MyBillsEntityDataFactory(z2, activity2, str2, str);
                                    DanaVizPromptPresenter.this.BuiltInFictitiousFunctionClassFactory();
                                }
                            });
                        }
                    }
                }
            }
        }
    }

    public static final /* synthetic */ void KClassImpl$Data$declaredNonStaticMembers$2(DanaVizPromptPresenter danaVizPromptPresenter) {
        FinishForceDanaVizEnroll finishForceDanaVizEnroll = danaVizPromptPresenter.MyBillsEntityDataFactory.get();
        Intrinsics.checkNotNullExpressionValue(finishForceDanaVizEnroll, "");
        CompletableUseCase.execute$default(finishForceDanaVizEnroll, NoParams.INSTANCE, null, null, 6, null);
    }
}
