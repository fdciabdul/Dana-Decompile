package id.dana.switchfaceauth;

import android.app.Activity;
import com.alibaba.ariver.kernel.RVEvents;
import id.dana.analytics.tracker.danaviz.DanaVizTracker;
import id.dana.analytics.tracker.danaviz.DanaVizTrackerImpl;
import id.dana.danah5.faceverificationenablement.DefaultFaceAuthenticationManager;
import id.dana.di.PerActivity;
import id.dana.domain.DefaultObserver;
import id.dana.domain.account.interactor.GetUserId;
import id.dana.domain.auth.face.interactor.SwitchFaceAuthentication;
import id.dana.domain.auth.face.result.FaceAuthenticationResult;
import id.dana.domain.auth.face.result.SecurityContext;
import id.dana.domain.auth.face.result.VerificationMethodInfo;
import id.dana.domain.core.usecase.BaseUseCase;
import id.dana.domain.core.usecase.CompletableUseCase;
import id.dana.domain.core.usecase.NoParams;
import id.dana.domain.resetpin.interactor.FinishForceDanaVizEnroll;
import id.dana.lib.bio.faceauth.FaceAuthentication;
import id.dana.lib.bio.faceauth.FaceAuthenticationCallback;
import id.dana.lib.bio.faceauth.exception.DanaBioException;
import id.dana.switchfaceauth.SwitchFaceAuthContract;
import id.dana.utils.foundation.logger.log.DanaLog;
import id.dana.utils.foundation.logger.log.DanaLogConstants;
import io.reactivex.functions.Action;
import java.util.Iterator;
import java.util.List;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\b\u0007\u0018\u00002\u00020\u00012\u00020\u0002:\u0002()B9\b\u0007\u0012\u0006\u0010\u0007\u001a\u00020\u001f\u0012\u0006\u0010\f\u001a\u00020\u001c\u0012\u0006\u0010\u000e\u001a\u00020\u001a\u0012\u0006\u0010#\u001a\u00020\u0015\u0012\u0006\u0010$\u001a\u00020\u0011\u0012\u0006\u0010%\u001a\u00020\u0017¢\u0006\u0004\b&\u0010'J\u000f\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0004\u0010\u0005J\u0018\u0010\b\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u0006H\u0096\u0001¢\u0006\u0004\b\b\u0010\tJ)\u0010\u000f\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\n2\b\u0010\f\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\u000e\u001a\u00020\rH\u0016¢\u0006\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0014\u001a\u00020\u00118\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u0014\u0010\u0012\u001a\u00020\u00158\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0014\u0010\u0016R\u0014\u0010\u0018\u001a\u00020\u00178\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u0014\u0010\u000f\u001a\u00020\u001a8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010\u001bR\u0014\u0010\u001d\u001a\u00020\u001c8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\u0014\u0010\"\u001a\u00020\u001f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b \u0010!"}, d2 = {"Lid/dana/switchfaceauth/SwitchFaceAuthPresenter;", "Lid/dana/switchfaceauth/SwitchFaceAuthContract$Presenter;", "Lid/dana/analytics/tracker/danaviz/DanaVizTracker;", "", "onDestroy", "()V", "Lid/dana/analytics/tracker/danaviz/DanaVizTracker$Source;", "p0", "setSource", "(Lid/dana/analytics/tracker/danaviz/DanaVizTracker$Source;)V", "", "", "p1", "Landroid/app/Activity;", "p2", "MyBillsEntityDataFactory", "(ZLjava/lang/String;Landroid/app/Activity;)V", "Lid/dana/analytics/tracker/danaviz/DanaVizTrackerImpl;", "KClassImpl$Data$declaredNonStaticMembers$2", "Lid/dana/analytics/tracker/danaviz/DanaVizTrackerImpl;", "getAuthRequestContext", "Lid/dana/lib/bio/faceauth/FaceAuthentication;", "Lid/dana/lib/bio/faceauth/FaceAuthentication;", "Lid/dana/domain/resetpin/interactor/FinishForceDanaVizEnroll;", "PlaceComponentResult", "Lid/dana/domain/resetpin/interactor/FinishForceDanaVizEnroll;", "Lid/dana/domain/account/interactor/GetUserId;", "Lid/dana/domain/account/interactor/GetUserId;", "Lid/dana/domain/auth/face/interactor/SwitchFaceAuthentication;", "BuiltInFictitiousFunctionClassFactory", "Lid/dana/domain/auth/face/interactor/SwitchFaceAuthentication;", "Lid/dana/switchfaceauth/SwitchFaceAuthContract$View;", "getErrorConfigVersion", "Lid/dana/switchfaceauth/SwitchFaceAuthContract$View;", "lookAheadTest", "p3", "p4", "p5", "<init>", "(Lid/dana/switchfaceauth/SwitchFaceAuthContract$View;Lid/dana/domain/auth/face/interactor/SwitchFaceAuthentication;Lid/dana/domain/account/interactor/GetUserId;Lid/dana/lib/bio/faceauth/FaceAuthentication;Lid/dana/analytics/tracker/danaviz/DanaVizTrackerImpl;Lid/dana/domain/resetpin/interactor/FinishForceDanaVizEnroll;)V", "ActionConstant", "VerificationMethodConstant"}, k = 1, mv = {1, 6, 0}, xi = 48)
@PerActivity
/* loaded from: classes5.dex */
public final class SwitchFaceAuthPresenter implements SwitchFaceAuthContract.Presenter, DanaVizTracker {
    private final SwitchFaceAuthentication BuiltInFictitiousFunctionClassFactory;

    /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
    final DanaVizTrackerImpl getAuthRequestContext;
    private final GetUserId MyBillsEntityDataFactory;
    private final FinishForceDanaVizEnroll PlaceComponentResult;

    /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
    private final FaceAuthentication KClassImpl$Data$declaredNonStaticMembers$2;

    /* renamed from: getErrorConfigVersion  reason: from kotlin metadata */
    private final SwitchFaceAuthContract.View lookAheadTest;

    @Override // id.dana.analytics.tracker.danaviz.DanaVizTracker
    public final void setSource(DanaVizTracker.Source p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        this.getAuthRequestContext.setSource(p0);
    }

    @Inject
    public SwitchFaceAuthPresenter(SwitchFaceAuthContract.View view, SwitchFaceAuthentication switchFaceAuthentication, GetUserId getUserId, FaceAuthentication faceAuthentication, DanaVizTrackerImpl danaVizTrackerImpl, FinishForceDanaVizEnroll finishForceDanaVizEnroll) {
        Intrinsics.checkNotNullParameter(view, "");
        Intrinsics.checkNotNullParameter(switchFaceAuthentication, "");
        Intrinsics.checkNotNullParameter(getUserId, "");
        Intrinsics.checkNotNullParameter(faceAuthentication, "");
        Intrinsics.checkNotNullParameter(danaVizTrackerImpl, "");
        Intrinsics.checkNotNullParameter(finishForceDanaVizEnroll, "");
        this.lookAheadTest = view;
        this.BuiltInFictitiousFunctionClassFactory = switchFaceAuthentication;
        this.MyBillsEntityDataFactory = getUserId;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = faceAuthentication;
        this.getAuthRequestContext = danaVizTrackerImpl;
        this.PlaceComponentResult = finishForceDanaVizEnroll;
        setSource(DanaVizTracker.Source.SMART_PAY);
    }

    @Override // id.dana.switchfaceauth.SwitchFaceAuthContract.Presenter
    public final void MyBillsEntityDataFactory(final boolean p0, final String p1, final Activity p2) {
        Intrinsics.checkNotNullParameter(p2, "");
        this.lookAheadTest.showProgress();
        BaseUseCase.execute$default(this.BuiltInFictitiousFunctionClassFactory, new SwitchFaceAuthentication.Params(p0, p1, null, 4, null), new Function1<FaceAuthenticationResult, Unit>() { // from class: id.dana.switchfaceauth.SwitchFaceAuthPresenter$switchFaceAuthentication$1
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
                SwitchFaceAuthContract.View view;
                Intrinsics.checkNotNullParameter(faceAuthenticationResult, "");
                view = SwitchFaceAuthPresenter.this.lookAheadTest;
                view.dismissProgress();
                SwitchFaceAuthPresenter.getAuthRequestContext(SwitchFaceAuthPresenter.this, p0, faceAuthenticationResult, p2);
            }
        }, new Function1<Throwable, Unit>() { // from class: id.dana.switchfaceauth.SwitchFaceAuthPresenter$switchFaceAuthentication$2
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
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
                SwitchFaceAuthContract.View view;
                SwitchFaceAuthContract.View view2;
                Intrinsics.checkNotNullParameter(th, "");
                StringBuilder sb = new StringBuilder();
                sb.append(DanaLogConstants.Prefix.SWITCH_FACE_AUTHENTICATION_PREFIX);
                sb.append(SwitchFaceAuthPresenter.this.getClass().getName());
                sb.append(RVEvents.EMBED_WEBVIEW_LOAD_ERROR_EVENT);
                DanaLog.BuiltInFictitiousFunctionClassFactory(DanaLogConstants.TAG.SWITCH_FACE_AUTHENTICATION, sb.toString(), th);
                view = SwitchFaceAuthPresenter.this.lookAheadTest;
                view.dismissProgress();
                view2 = SwitchFaceAuthPresenter.this.lookAheadTest;
                view2.onError(th.getMessage());
                String str = p1;
                if (str == null || str.length() == 0) {
                    return;
                }
                SwitchFaceAuthPresenter.this.getAuthRequestContext.MyBillsEntityDataFactory((Integer) null);
            }
        }, null, new Action() { // from class: id.dana.switchfaceauth.SwitchFaceAuthPresenter$$ExternalSyntheticLambda0
            @Override // io.reactivex.functions.Action
            public final void run() {
                SwitchFaceAuthPresenter.PlaceComponentResult(SwitchFaceAuthPresenter.this);
            }
        }, 8, null);
    }

    @Override // id.dana.base.AbstractContract.AbstractPresenter
    public final void onDestroy() {
        this.BuiltInFictitiousFunctionClassFactory.dispose();
        this.PlaceComponentResult.dispose();
        this.MyBillsEntityDataFactory.dispose();
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lid/dana/switchfaceauth/SwitchFaceAuthPresenter$VerificationMethodConstant;", "", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes9.dex */
    public static final class VerificationMethodConstant {
        public static final VerificationMethodConstant INSTANCE = new VerificationMethodConstant();

        private VerificationMethodConstant() {
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lid/dana/switchfaceauth/SwitchFaceAuthPresenter$ActionConstant;", "", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes9.dex */
    public static final class ActionConstant {
        public static final ActionConstant INSTANCE = new ActionConstant();

        private ActionConstant() {
        }
    }

    public static /* synthetic */ void PlaceComponentResult(SwitchFaceAuthPresenter switchFaceAuthPresenter) {
        Intrinsics.checkNotNullParameter(switchFaceAuthPresenter, "");
        switchFaceAuthPresenter.lookAheadTest.dismissProgress();
    }

    public static final /* synthetic */ void getAuthRequestContext(final SwitchFaceAuthPresenter switchFaceAuthPresenter, final boolean z, FaceAuthenticationResult faceAuthenticationResult, final Activity activity) {
        String action = faceAuthenticationResult.getAction();
        if (action != null) {
            switch (action.hashCode()) {
                case -1814255407:
                    if (action.equals("TO_KYC")) {
                        switchFaceAuthPresenter.lookAheadTest.toKYC();
                        return;
                    }
                    return;
                case -795785494:
                    if (action.equals(DefaultFaceAuthenticationManager.Companion.ActionConstant.TO_ENROLL)) {
                        switchFaceAuthPresenter.MyBillsEntityDataFactory.execute(new DefaultObserver<String>() { // from class: id.dana.switchfaceauth.SwitchFaceAuthPresenter$doEnroll$1
                            @Override // id.dana.domain.DefaultObserver, io.reactivex.Observer
                            public final /* synthetic */ void onNext(Object obj) {
                                String str = (String) obj;
                                Intrinsics.checkNotNullParameter(str, "");
                                SwitchFaceAuthPresenter.getAuthRequestContext(SwitchFaceAuthPresenter.this, str, activity);
                            }

                            @Override // id.dana.domain.DefaultObserver, io.reactivex.Observer
                            public final void onError(Throwable p0) {
                                SwitchFaceAuthContract.View view;
                                Intrinsics.checkNotNullParameter(p0, "");
                                view = SwitchFaceAuthPresenter.this.lookAheadTest;
                                view.onError(p0.getMessage());
                            }
                        });
                        return;
                    }
                    return;
                case -407149037:
                    if (action.equals(DefaultFaceAuthenticationManager.Companion.ActionConstant.TO_RISK)) {
                        List<VerificationMethodInfo> verificationMethods = faceAuthenticationResult.getVerificationMethods();
                        String securityId = faceAuthenticationResult.getSecurityId();
                        SecurityContext securityContext = faceAuthenticationResult.getSecurityContext();
                        String pubKey = securityContext != null ? securityContext.getPubKey() : null;
                        if (verificationMethods != null) {
                            Iterator<VerificationMethodInfo> it = verificationMethods.iterator();
                            while (it.hasNext()) {
                                String verificationMethod = it.next().getVerificationMethod();
                                if (Intrinsics.areEqual(verificationMethod, "PASSWORD")) {
                                    switchFaceAuthPresenter.lookAheadTest.onFaceSwitchRiskChallenge(securityId, pubKey, z);
                                } else if (Intrinsics.areEqual(verificationMethod, "MIC_FACE") && securityId != null) {
                                    switchFaceAuthPresenter.getAuthRequestContext.getAuthRequestContext();
                                    switchFaceAuthPresenter.getAuthRequestContext.getErrorConfigVersion();
                                    switchFaceAuthPresenter.KClassImpl$Data$declaredNonStaticMembers$2.PlaceComponentResult(activity, securityId, new FaceAuthenticationCallback() { // from class: id.dana.switchfaceauth.SwitchFaceAuthPresenter$doFaceAuth$1$1
                                        @Override // id.dana.lib.bio.faceauth.FaceAuthenticationCallback
                                        public final void onCancel() {
                                            SwitchFaceAuthContract.View view;
                                            view = SwitchFaceAuthPresenter.this.lookAheadTest;
                                            view.dismissProgress();
                                            SwitchFaceAuthPresenter.this.getAuthRequestContext.lookAheadTest();
                                        }

                                        @Override // id.dana.lib.bio.faceauth.FaceAuthenticationCallback
                                        public final void onFailed(DanaBioException.FaceAuthenticationException p0) {
                                            SwitchFaceAuthContract.View view;
                                            Intrinsics.checkNotNullParameter(p0, "");
                                            StringBuilder sb = new StringBuilder();
                                            sb.append(DanaLogConstants.Prefix.UAP_FACE_AUTHENTICATION_PREFIX);
                                            sb.append(getClass().getName());
                                            sb.append(RVEvents.EMBED_WEBVIEW_LOAD_ERROR_EVENT);
                                            DanaLog.BuiltInFictitiousFunctionClassFactory(DanaLogConstants.TAG.UAP_FACE_AUTHENTICATION, sb.toString(), p0);
                                            view = SwitchFaceAuthPresenter.this.lookAheadTest;
                                            view.onFailToggle();
                                            SwitchFaceAuthPresenter switchFaceAuthPresenter2 = SwitchFaceAuthPresenter.this;
                                            switchFaceAuthPresenter2.getAuthRequestContext.MyBillsEntityDataFactory(Integer.valueOf(p0.getErrorCode()));
                                            SwitchFaceAuthPresenter switchFaceAuthPresenter3 = SwitchFaceAuthPresenter.this;
                                            int errorCode = p0.getErrorCode();
                                            String message = p0.getMessage();
                                            Intrinsics.checkNotNullParameter(message, "");
                                            switchFaceAuthPresenter3.getAuthRequestContext.KClassImpl$Data$declaredNonStaticMembers$2(errorCode, message);
                                        }

                                        @Override // id.dana.lib.bio.faceauth.FaceAuthenticationCallback
                                        public final void onSuccess(String p0) {
                                            Intrinsics.checkNotNullParameter(p0, "");
                                            SwitchFaceAuthPresenter.this.MyBillsEntityDataFactory(z, p0, activity);
                                            SwitchFaceAuthPresenter.this.getAuthRequestContext.scheduleImpl();
                                            CompletableUseCase.execute$default(SwitchFaceAuthPresenter.this.PlaceComponentResult, NoParams.INSTANCE, null, null, 6, null);
                                        }
                                    });
                                }
                            }
                            return;
                        }
                        return;
                    }
                    return;
                case 321752684:
                    if (action.equals("SUCCESS_DISABLE")) {
                        switchFaceAuthPresenter.lookAheadTest.onSuccessFaceSwitch(Boolean.FALSE);
                        switchFaceAuthPresenter.getAuthRequestContext.KClassImpl$Data$declaredNonStaticMembers$2();
                        return;
                    }
                    return;
                case 458732895:
                    if (action.equals(DefaultFaceAuthenticationManager.Companion.ActionConstant.SUCCESS_ENABLE)) {
                        switchFaceAuthPresenter.lookAheadTest.onSuccessFaceSwitch(Boolean.TRUE);
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    }

    public static final /* synthetic */ void getAuthRequestContext(final SwitchFaceAuthPresenter switchFaceAuthPresenter, String str, Activity activity) {
        switchFaceAuthPresenter.getAuthRequestContext.MyBillsEntityDataFactory();
        FaceAuthentication.DefaultImpls.BuiltInFictitiousFunctionClassFactory(switchFaceAuthPresenter.KClassImpl$Data$declaredNonStaticMembers$2, activity, str, new FaceAuthenticationCallback() { // from class: id.dana.switchfaceauth.SwitchFaceAuthPresenter$startEnrollFaceAuth$1
            @Override // id.dana.lib.bio.faceauth.FaceAuthenticationCallback
            public final void onCancel() {
                SwitchFaceAuthContract.View view;
                view = SwitchFaceAuthPresenter.this.lookAheadTest;
                view.dismissProgress();
                SwitchFaceAuthPresenter.this.getAuthRequestContext.PlaceComponentResult();
            }

            @Override // id.dana.lib.bio.faceauth.FaceAuthenticationCallback
            public final void onFailed(DanaBioException.FaceAuthenticationException p0) {
                SwitchFaceAuthContract.View view;
                SwitchFaceAuthContract.View view2;
                Intrinsics.checkNotNullParameter(p0, "");
                view = SwitchFaceAuthPresenter.this.lookAheadTest;
                view.dismissProgress();
                view2 = SwitchFaceAuthPresenter.this.lookAheadTest;
                view2.onFailFaceEnroll();
                SwitchFaceAuthPresenter switchFaceAuthPresenter2 = SwitchFaceAuthPresenter.this;
                int errorCode = p0.getErrorCode();
                String message = p0.getMessage();
                Intrinsics.checkNotNullParameter(message, "");
                switchFaceAuthPresenter2.getAuthRequestContext.getAuthRequestContext(errorCode, message);
            }

            @Override // id.dana.lib.bio.faceauth.FaceAuthenticationCallback
            public final void onSuccess(String p0) {
                SwitchFaceAuthContract.View view;
                SwitchFaceAuthContract.View view2;
                Intrinsics.checkNotNullParameter(p0, "");
                view = SwitchFaceAuthPresenter.this.lookAheadTest;
                view.dismissProgress();
                view2 = SwitchFaceAuthPresenter.this.lookAheadTest;
                view2.onSuccessFaceSwitch(Boolean.TRUE);
                SwitchFaceAuthPresenter.this.getAuthRequestContext.BuiltInFictitiousFunctionClassFactory();
            }
        });
    }
}
