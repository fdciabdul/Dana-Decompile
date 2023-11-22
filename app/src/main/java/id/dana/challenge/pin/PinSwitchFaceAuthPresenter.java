package id.dana.challenge.pin;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import com.alibaba.ariver.kernel.RVEvents;
import id.dana.analytics.tracker.danaviz.DanaVizTracker;
import id.dana.analytics.tracker.danaviz.DanaVizTrackerImpl;
import id.dana.challenge.ChallengeControl;
import id.dana.challenge.pin.AbstractPinContract;
import id.dana.danah5.faceverificationenablement.DefaultFaceAuthenticationManager;
import id.dana.domain.DefaultObserver;
import id.dana.domain.account.interactor.GetUserId;
import id.dana.domain.auth.face.interactor.VerifyFaceAuthentication;
import id.dana.domain.auth.face.result.FaceAuthenticationResult;
import id.dana.domain.core.usecase.CompletableUseCase;
import id.dana.domain.core.usecase.NoParams;
import id.dana.domain.resetpin.interactor.FinishForceDanaVizEnroll;
import id.dana.lib.bio.faceauth.FaceAuthentication;
import id.dana.lib.bio.faceauth.FaceAuthenticationCallback;
import id.dana.lib.bio.faceauth.exception.DanaBioException;
import id.dana.model.Trust2RiskLoginModel;
import id.dana.network.exception.NetworkException;
import id.dana.utils.ErrorUtil;
import id.dana.utils.foundation.logger.log.DanaLog;
import id.dana.utils.foundation.logger.log.DanaLogConstants;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u00012\u00020\u0002:\u00012BA\b\u0007\u0012\u0006\u0010\b\u001a\u00020\u001b\u0012\u0006\u0010\n\u001a\u00020&\u0012\u0006\u0010\r\u001a\u00020$\u0012\u0006\u0010\u000e\u001a\u00020\u001f\u0012\u0006\u0010\u0010\u001a\u00020*\u0012\u0006\u0010.\u001a\u00020\u001d\u0012\u0006\u0010/\u001a\u00020\"¢\u0006\u0004\b0\u00101J\u000f\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\u0006\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0006\u0010\u0005J!\u0010\u000b\u001a\u00020\u00032\b\u0010\b\u001a\u0004\u0018\u00010\u00072\u0006\u0010\n\u001a\u00020\tH\u0016¢\u0006\u0004\b\u000b\u0010\fJ5\u0010\u000b\u001a\u00020\u00032\b\u0010\b\u001a\u0004\u0018\u00010\u00072\b\u0010\n\u001a\u0004\u0018\u00010\u00072\b\u0010\r\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u000e\u001a\u00020\tH\u0016¢\u0006\u0004\b\u000b\u0010\u000fJ?\u0010\u0006\u001a\u00020\u00032\b\u0010\b\u001a\u0004\u0018\u00010\u00072\b\u0010\n\u001a\u0004\u0018\u00010\u00072\u0006\u0010\r\u001a\u00020\t2\b\u0010\u000e\u001a\u0004\u0018\u00010\u00072\b\u0010\u0010\u001a\u0004\u0018\u00010\u0007H\u0016¢\u0006\u0004\b\u0006\u0010\u0011J7\u0010\u0004\u001a\u00020\u00032\b\u0010\b\u001a\u0004\u0018\u00010\u00072\b\u0010\n\u001a\u0004\u0018\u00010\u00072\b\u0010\r\u001a\u0004\u0018\u00010\u00072\b\u0010\u000e\u001a\u0004\u0018\u00010\u0007H\u0016¢\u0006\u0004\b\u0004\u0010\u0012J#\u0010\u0014\u001a\u00020\u00032\b\u0010\b\u001a\u0004\u0018\u00010\u00072\b\u0010\n\u001a\u0004\u0018\u00010\u0013H\u0016¢\u0006\u0004\b\u0014\u0010\u0015J\u000f\u0010\u0016\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0016\u0010\u0005J\u0019\u0010\u0014\u001a\u00020\u00032\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0016¢\u0006\u0004\b\u0014\u0010\u0017J\u0018\u0010\u0019\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\u0018H\u0096\u0001¢\u0006\u0004\b\u0019\u0010\u001aR\u0014\u0010\u0004\u001a\u00020\u001b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010\u001cR\u0014\u0010\u0014\u001a\u00020\u001d8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0006\u0010\u001eR\u0014\u0010\u000b\u001a\u00020\u001f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b \u0010!R\u0014\u0010 \u001a\u00020\"8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010#R\u0014\u0010\u0006\u001a\u00020$8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0014\u0010%R\u0014\u0010)\u001a\u00020&8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b'\u0010(R\u0014\u0010-\u001a\u00020*8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b+\u0010,"}, d2 = {"Lid/dana/challenge/pin/PinSwitchFaceAuthPresenter;", "Lid/dana/challenge/pin/AbstractPinContract$Presenter;", "Lid/dana/analytics/tracker/danaviz/DanaVizTracker;", "", "MyBillsEntityDataFactory", "()V", "PlaceComponentResult", "", "p0", "", "p1", "getAuthRequestContext", "(Ljava/lang/String;Z)V", "p2", "p3", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Z)V", "p4", "(Ljava/lang/String;Ljava/lang/String;ZLjava/lang/String;Ljava/lang/String;)V", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "Landroid/os/Bundle;", "BuiltInFictitiousFunctionClassFactory", "(Ljava/lang/String;Landroid/os/Bundle;)V", "onDestroy", "(Ljava/lang/String;)V", "Lid/dana/analytics/tracker/danaviz/DanaVizTracker$Source;", "setSource", "(Lid/dana/analytics/tracker/danaviz/DanaVizTracker$Source;)V", "Landroid/content/Context;", "Landroid/content/Context;", "Lid/dana/analytics/tracker/danaviz/DanaVizTrackerImpl;", "Lid/dana/analytics/tracker/danaviz/DanaVizTrackerImpl;", "Lid/dana/lib/bio/faceauth/FaceAuthentication;", "KClassImpl$Data$declaredNonStaticMembers$2", "Lid/dana/lib/bio/faceauth/FaceAuthentication;", "Lid/dana/domain/resetpin/interactor/FinishForceDanaVizEnroll;", "Lid/dana/domain/resetpin/interactor/FinishForceDanaVizEnroll;", "Lid/dana/domain/account/interactor/GetUserId;", "Lid/dana/domain/account/interactor/GetUserId;", "Lid/dana/domain/auth/face/interactor/VerifyFaceAuthentication;", "moveToNextValue", "Lid/dana/domain/auth/face/interactor/VerifyFaceAuthentication;", "scheduleImpl", "Lid/dana/challenge/pin/AbstractPinContract$View;", "NetworkUserEntityData$$ExternalSyntheticLambda0", "Lid/dana/challenge/pin/AbstractPinContract$View;", "lookAheadTest", "p5", "p6", "<init>", "(Landroid/content/Context;Lid/dana/domain/auth/face/interactor/VerifyFaceAuthentication;Lid/dana/domain/account/interactor/GetUserId;Lid/dana/lib/bio/faceauth/FaceAuthentication;Lid/dana/challenge/pin/AbstractPinContract$View;Lid/dana/analytics/tracker/danaviz/DanaVizTrackerImpl;Lid/dana/domain/resetpin/interactor/FinishForceDanaVizEnroll;)V", "ActionConstant"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class PinSwitchFaceAuthPresenter implements AbstractPinContract.Presenter, DanaVizTracker {

    /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
    private final GetUserId PlaceComponentResult;

    /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
    private final FaceAuthentication getAuthRequestContext;
    private final Context MyBillsEntityDataFactory;

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda0  reason: from kotlin metadata */
    private final AbstractPinContract.View lookAheadTest;

    /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
    final DanaVizTrackerImpl BuiltInFictitiousFunctionClassFactory;

    /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
    private final FinishForceDanaVizEnroll KClassImpl$Data$declaredNonStaticMembers$2;

    /* renamed from: moveToNextValue  reason: from kotlin metadata */
    private final VerifyFaceAuthentication scheduleImpl;

    @Override // id.dana.challenge.pin.AbstractPinContract.Presenter
    public final /* synthetic */ void BuiltInFictitiousFunctionClassFactory() {
        AbstractPinContract.Presenter.CC.NetworkUserEntityData$$ExternalSyntheticLambda0();
    }

    @Override // id.dana.challenge.pin.AbstractPinContract.Presenter
    public final void BuiltInFictitiousFunctionClassFactory(String p0, Bundle p1) {
    }

    @Override // id.dana.challenge.pin.AbstractPinContract.Presenter
    public final /* synthetic */ void KClassImpl$Data$declaredNonStaticMembers$2(Trust2RiskLoginModel trust2RiskLoginModel) {
        AbstractPinContract.Presenter.CC.getErrorConfigVersion();
    }

    @Override // id.dana.challenge.pin.AbstractPinContract.Presenter
    public final /* synthetic */ void KClassImpl$Data$declaredNonStaticMembers$2(String str) {
        AbstractPinContract.Presenter.CC.KClassImpl$Data$declaredNonStaticMembers$2();
    }

    @Override // id.dana.challenge.pin.AbstractPinContract.Presenter
    public final /* synthetic */ void KClassImpl$Data$declaredNonStaticMembers$2(String str, String str2) {
        AbstractPinContract.Presenter.CC.moveToNextValue();
    }

    @Override // id.dana.challenge.pin.AbstractPinContract.Presenter
    public final void MyBillsEntityDataFactory() {
    }

    @Override // id.dana.challenge.pin.AbstractPinContract.Presenter
    public final /* synthetic */ void MyBillsEntityDataFactory(String str, String str2) {
        AbstractPinContract.Presenter.CC.getAuthRequestContext();
    }

    @Override // id.dana.challenge.pin.AbstractPinContract.Presenter
    public final void MyBillsEntityDataFactory(String p0, String p1, String p2, String p3) {
    }

    @Override // id.dana.challenge.pin.AbstractPinContract.Presenter
    public final void PlaceComponentResult() {
    }

    @Override // id.dana.challenge.pin.AbstractPinContract.Presenter
    public final void PlaceComponentResult(String p0, String p1, boolean p2, String p3, String p4) {
    }

    @Override // id.dana.challenge.pin.AbstractPinContract.Presenter
    public final /* synthetic */ void getAuthRequestContext(String str) {
        AbstractPinContract.Presenter.CC.MyBillsEntityDataFactory();
    }

    @Override // id.dana.challenge.pin.AbstractPinContract.Presenter
    public final void getAuthRequestContext(String p0, String p1, String p2, boolean p3) {
    }

    @Override // id.dana.challenge.pin.AbstractPinContract.Presenter
    public final /* synthetic */ void getAuthRequestContext(String str, String str2, boolean z, boolean z2) {
        AbstractPinContract.Presenter.CC.PlaceComponentResult();
    }

    @Override // id.dana.challenge.pin.AbstractPinContract.Presenter
    public final void getAuthRequestContext(String p0, boolean p1) {
    }

    @Override // id.dana.analytics.tracker.danaviz.DanaVizTracker
    public final void setSource(DanaVizTracker.Source p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        this.BuiltInFictitiousFunctionClassFactory.setSource(p0);
    }

    @Inject
    public PinSwitchFaceAuthPresenter(Context context, VerifyFaceAuthentication verifyFaceAuthentication, GetUserId getUserId, FaceAuthentication faceAuthentication, AbstractPinContract.View view, DanaVizTrackerImpl danaVizTrackerImpl, FinishForceDanaVizEnroll finishForceDanaVizEnroll) {
        Intrinsics.checkNotNullParameter(context, "");
        Intrinsics.checkNotNullParameter(verifyFaceAuthentication, "");
        Intrinsics.checkNotNullParameter(getUserId, "");
        Intrinsics.checkNotNullParameter(faceAuthentication, "");
        Intrinsics.checkNotNullParameter(view, "");
        Intrinsics.checkNotNullParameter(danaVizTrackerImpl, "");
        Intrinsics.checkNotNullParameter(finishForceDanaVizEnroll, "");
        this.MyBillsEntityDataFactory = context;
        this.scheduleImpl = verifyFaceAuthentication;
        this.PlaceComponentResult = getUserId;
        this.getAuthRequestContext = faceAuthentication;
        this.lookAheadTest = view;
        this.BuiltInFictitiousFunctionClassFactory = danaVizTrackerImpl;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = finishForceDanaVizEnroll;
    }

    @Override // id.dana.challenge.pin.AbstractPinContract.Presenter
    public final /* synthetic */ void getAuthRequestContext(String str, String str2, String str3, Boolean bool, final Activity activity) {
        boolean booleanValue = bool.booleanValue();
        Intrinsics.checkNotNullParameter(activity, "");
        this.lookAheadTest.showProgress();
        this.scheduleImpl.execute(new VerifyFaceAuthentication.Params(booleanValue, str3, str, str2), new Function1<FaceAuthenticationResult, Unit>() { // from class: id.dana.challenge.pin.PinSwitchFaceAuthPresenter$inputSwitchFaceAuth$1
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
                if (!Intrinsics.areEqual(DefaultFaceAuthenticationManager.Companion.ActionConstant.TO_ENROLL, faceAuthenticationResult.getAction())) {
                    PinSwitchFaceAuthPresenter.KClassImpl$Data$declaredNonStaticMembers$2(PinSwitchFaceAuthPresenter.this);
                } else {
                    r2.PlaceComponentResult.execute(new DefaultObserver<String>() { // from class: id.dana.challenge.pin.PinSwitchFaceAuthPresenter$doEnroll$1
                        @Override // id.dana.domain.DefaultObserver, io.reactivex.Observer
                        public final /* synthetic */ void onNext(Object obj) {
                            String str4 = (String) obj;
                            Intrinsics.checkNotNullParameter(str4, "");
                            PinSwitchFaceAuthPresenter.getAuthRequestContext(PinSwitchFaceAuthPresenter.this, str4, r2);
                        }

                        @Override // id.dana.domain.DefaultObserver, io.reactivex.Observer
                        public final void onError(Throwable p0) {
                            Intrinsics.checkNotNullParameter(p0, "");
                            PinSwitchFaceAuthPresenter.MyBillsEntityDataFactory(PinSwitchFaceAuthPresenter.this, p0.getMessage());
                        }
                    });
                }
            }
        }, new Function1<Throwable, Unit>() { // from class: id.dana.challenge.pin.PinSwitchFaceAuthPresenter$inputSwitchFaceAuth$2
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
                AbstractPinContract.View view;
                AbstractPinContract.View view2;
                Context context;
                AbstractPinContract.View view3;
                Intrinsics.checkNotNullParameter(th, "");
                view = PinSwitchFaceAuthPresenter.this.lookAheadTest;
                view.dismissProgress();
                if (th instanceof NetworkException) {
                    view3 = PinSwitchFaceAuthPresenter.this.lookAheadTest;
                    NetworkException networkException = (NetworkException) th;
                    view3.MyBillsEntityDataFactory(networkException.getErrorCode(), th.getMessage(), ErrorUtil.getAuthRequestContext(networkException.getLeftTimes()), networkException.getTraceId());
                } else {
                    view2 = PinSwitchFaceAuthPresenter.this.lookAheadTest;
                    context = PinSwitchFaceAuthPresenter.this.MyBillsEntityDataFactory;
                    view2.onError(ErrorUtil.PlaceComponentResult(th, context));
                }
                StringBuilder sb = new StringBuilder();
                sb.append(DanaLogConstants.Prefix.SWITCH_FACE_AUTHENTICATION_PREFIX);
                sb.append(PinSwitchFaceAuthPresenter.this.getClass().getName());
                sb.append(RVEvents.EMBED_WEBVIEW_LOAD_ERROR_EVENT);
                DanaLog.BuiltInFictitiousFunctionClassFactory(DanaLogConstants.TAG.SWITCH_FACE_AUTHENTICATION, sb.toString(), th);
            }
        });
    }

    @Override // id.dana.base.AbstractContract.AbstractPresenter
    public final void onDestroy() {
        this.scheduleImpl.dispose();
        this.KClassImpl$Data$declaredNonStaticMembers$2.dispose();
        this.PlaceComponentResult.dispose();
    }

    @Override // id.dana.challenge.pin.AbstractPinContract.Presenter
    public final void BuiltInFictitiousFunctionClassFactory(String p0) {
        DanaVizTracker.Source source;
        if (Intrinsics.areEqual(p0, ChallengeControl.Key.FACE_ACTIVATION_SMART_PAY)) {
            source = DanaVizTracker.Source.SMART_PAY;
        } else if (!Intrinsics.areEqual(p0, ChallengeControl.Key.FACE_ACTIVATION_REGISTRATION)) {
            return;
        } else {
            source = DanaVizTracker.Source.REGISTRATION;
        }
        setSource(source);
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lid/dana/challenge/pin/PinSwitchFaceAuthPresenter$ActionConstant;", "", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes8.dex */
    public static final class ActionConstant {
        public static final ActionConstant INSTANCE = new ActionConstant();

        private ActionConstant() {
        }
    }

    public static final /* synthetic */ void PlaceComponentResult(PinSwitchFaceAuthPresenter pinSwitchFaceAuthPresenter, int i) {
        pinSwitchFaceAuthPresenter.lookAheadTest.dismissProgress();
        pinSwitchFaceAuthPresenter.lookAheadTest.PlaceComponentResult(i);
    }

    public static final /* synthetic */ void MyBillsEntityDataFactory(PinSwitchFaceAuthPresenter pinSwitchFaceAuthPresenter, String str) {
        pinSwitchFaceAuthPresenter.lookAheadTest.dismissProgress();
        pinSwitchFaceAuthPresenter.lookAheadTest.onError(str);
    }

    public static final /* synthetic */ void KClassImpl$Data$declaredNonStaticMembers$2(PinSwitchFaceAuthPresenter pinSwitchFaceAuthPresenter) {
        pinSwitchFaceAuthPresenter.lookAheadTest.dismissProgress();
        pinSwitchFaceAuthPresenter.lookAheadTest.getAuthRequestContext();
    }

    public static final /* synthetic */ void getAuthRequestContext(PinSwitchFaceAuthPresenter pinSwitchFaceAuthPresenter, String str, Activity activity) {
        pinSwitchFaceAuthPresenter.BuiltInFictitiousFunctionClassFactory.MyBillsEntityDataFactory();
        pinSwitchFaceAuthPresenter.getAuthRequestContext.MyBillsEntityDataFactory(activity, str, MapsKt.mapOf(TuplesKt.to("sceneId", "dana_app_securitysetting"), TuplesKt.to("productCode", "FACE_ENROLL")), new FaceAuthenticationCallback() { // from class: id.dana.challenge.pin.PinSwitchFaceAuthPresenter$startEnrollFaceAuth$1
            @Override // id.dana.lib.bio.faceauth.FaceAuthenticationCallback
            public final void onCancel() {
                AbstractPinContract.View view;
                AbstractPinContract.View view2;
                view = PinSwitchFaceAuthPresenter.this.lookAheadTest;
                view.dismissProgress();
                view2 = PinSwitchFaceAuthPresenter.this.lookAheadTest;
                view2.KClassImpl$Data$declaredNonStaticMembers$2();
                PinSwitchFaceAuthPresenter.this.BuiltInFictitiousFunctionClassFactory.PlaceComponentResult();
            }

            @Override // id.dana.lib.bio.faceauth.FaceAuthenticationCallback
            public final void onFailed(DanaBioException.FaceAuthenticationException p0) {
                Intrinsics.checkNotNullParameter(p0, "");
                int errorCode = p0.getErrorCode();
                PinSwitchFaceAuthPresenter.PlaceComponentResult(PinSwitchFaceAuthPresenter.this, errorCode);
                PinSwitchFaceAuthPresenter pinSwitchFaceAuthPresenter2 = PinSwitchFaceAuthPresenter.this;
                String message = p0.getMessage();
                Intrinsics.checkNotNullParameter(message, "");
                pinSwitchFaceAuthPresenter2.BuiltInFictitiousFunctionClassFactory.getAuthRequestContext(errorCode, message);
            }

            @Override // id.dana.lib.bio.faceauth.FaceAuthenticationCallback
            public final void onSuccess(String p0) {
                Intrinsics.checkNotNullParameter(p0, "");
                PinSwitchFaceAuthPresenter.KClassImpl$Data$declaredNonStaticMembers$2(PinSwitchFaceAuthPresenter.this);
                PinSwitchFaceAuthPresenter.this.BuiltInFictitiousFunctionClassFactory.BuiltInFictitiousFunctionClassFactory();
                CompletableUseCase.execute$default(PinSwitchFaceAuthPresenter.this.KClassImpl$Data$declaredNonStaticMembers$2, NoParams.INSTANCE, null, null, 6, null);
            }
        });
    }
}
