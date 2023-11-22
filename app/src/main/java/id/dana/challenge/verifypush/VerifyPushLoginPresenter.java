package id.dana.challenge.verifypush;

import id.dana.challenge.ChallengeScenario;
import id.dana.challenge.LoginFailureException;
import id.dana.challenge.LoginFailureExceptionKt;
import id.dana.challenge.verifypush.VerifyPushContract;
import id.dana.challenge.verifypush.mapper.ChallengeModelMapperKt;
import id.dana.challenge.verifypush.model.request.TwilioChallengeModel;
import id.dana.constants.ErrorCode;
import id.dana.di.PerActivity;
import id.dana.domain.DefaultObserver;
import id.dana.domain.featureconfig.interactor.GetTwilioTimeoutConfig;
import id.dana.domain.login.interactor.VerifyPushLogin;
import id.dana.domain.model.rpc.response.LoginResponse;
import id.dana.domain.twilio.interactor.TwilioRequestChallenge;
import id.dana.domain.twilio.model.RequestChallengeInfo;
import id.dana.utils.foundation.logger.log.DanaLog;
import id.dana.utils.foundation.logger.log.DanaLogConstants;
import java.util.HashMap;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0007\u0018\u0000 \"2\u00020\u0001:\u0001\"B)\b\u0007\u0012\u0006\u0010\u0006\u001a\u00020\u001b\u0012\u0006\u0010\t\u001a\u00020\u0015\u0012\u0006\u0010\u001e\u001a\u00020\u0012\u0012\u0006\u0010\u001f\u001a\u00020\u0018¢\u0006\u0004\b \u0010!J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J;\u0010\n\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00052\"\u0010\t\u001a\u001e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u0007j\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0005`\bH\u0016¢\u0006\u0004\b\n\u0010\u000bR\u0018\u0010\u000e\u001a\u0004\u0018\u00010\u00058\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\f\u0010\rR\u0016\u0010\u0011\u001a\u00020\u000f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\n\u0010\u0010R\u0016\u0010\n\u001a\u00020\u000f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0011\u0010\u0010R\u0014\u0010\f\u001a\u00020\u00128\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u0014\u0010\u0017\u001a\u00020\u00158\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\u0016R\u0014\u0010\u001a\u001a\u00020\u00188\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0017\u0010\u0019R\u0014\u0010\u001c\u001a\u00020\u001b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001c\u0010\u001d"}, d2 = {"Lid/dana/challenge/verifypush/VerifyPushLoginPresenter;", "Lid/dana/challenge/verifypush/VerifyPushContract$Presenter;", "", "onDestroy", "()V", "", "p0", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "p1", "getAuthRequestContext", "(Ljava/lang/String;Ljava/util/HashMap;)V", "BuiltInFictitiousFunctionClassFactory", "Ljava/lang/String;", "PlaceComponentResult", "", "I", "MyBillsEntityDataFactory", "Lid/dana/domain/twilio/interactor/TwilioRequestChallenge;", "lookAheadTest", "Lid/dana/domain/twilio/interactor/TwilioRequestChallenge;", "Lid/dana/domain/featureconfig/interactor/GetTwilioTimeoutConfig;", "Lid/dana/domain/featureconfig/interactor/GetTwilioTimeoutConfig;", "KClassImpl$Data$declaredNonStaticMembers$2", "Lid/dana/domain/login/interactor/VerifyPushLogin;", "Lid/dana/domain/login/interactor/VerifyPushLogin;", "NetworkUserEntityData$$ExternalSyntheticLambda0", "Lid/dana/challenge/verifypush/VerifyPushContract$View;", "scheduleImpl", "Lid/dana/challenge/verifypush/VerifyPushContract$View;", "p2", "p3", "<init>", "(Lid/dana/challenge/verifypush/VerifyPushContract$View;Lid/dana/domain/featureconfig/interactor/GetTwilioTimeoutConfig;Lid/dana/domain/twilio/interactor/TwilioRequestChallenge;Lid/dana/domain/login/interactor/VerifyPushLogin;)V", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
@PerActivity
/* loaded from: classes4.dex */
public final class VerifyPushLoginPresenter implements VerifyPushContract.Presenter {

    /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
    private String PlaceComponentResult;

    /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
    final VerifyPushLogin NetworkUserEntityData$$ExternalSyntheticLambda0;

    /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
    int getAuthRequestContext;

    /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
    final GetTwilioTimeoutConfig KClassImpl$Data$declaredNonStaticMembers$2;

    /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
    int MyBillsEntityDataFactory;

    /* renamed from: lookAheadTest  reason: from kotlin metadata */
    private final TwilioRequestChallenge BuiltInFictitiousFunctionClassFactory;
    private final VerifyPushContract.View scheduleImpl;

    @Inject
    public VerifyPushLoginPresenter(VerifyPushContract.View view, GetTwilioTimeoutConfig getTwilioTimeoutConfig, TwilioRequestChallenge twilioRequestChallenge, VerifyPushLogin verifyPushLogin) {
        Intrinsics.checkNotNullParameter(view, "");
        Intrinsics.checkNotNullParameter(getTwilioTimeoutConfig, "");
        Intrinsics.checkNotNullParameter(twilioRequestChallenge, "");
        Intrinsics.checkNotNullParameter(verifyPushLogin, "");
        this.scheduleImpl = view;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = getTwilioTimeoutConfig;
        this.BuiltInFictitiousFunctionClassFactory = twilioRequestChallenge;
        this.NetworkUserEntityData$$ExternalSyntheticLambda0 = verifyPushLogin;
        this.MyBillsEntityDataFactory = 20;
        this.getAuthRequestContext = 5;
    }

    public final void getAuthRequestContext(String p0, HashMap<String, String> p1) {
        Intrinsics.checkNotNullParameter(p0, "");
        Intrinsics.checkNotNullParameter(p1, "");
        this.BuiltInFictitiousFunctionClassFactory.execute(new TwilioRequestChallenge.Params(ChallengeModelMapperKt.MyBillsEntityDataFactory(new TwilioChallengeModel(p0, p1, this.PlaceComponentResult))), new Function1<RequestChallengeInfo, Unit>() { // from class: id.dana.challenge.verifypush.VerifyPushLoginPresenter$requestChallenge$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final /* bridge */ /* synthetic */ Unit invoke(RequestChallengeInfo requestChallengeInfo) {
                invoke2(requestChallengeInfo);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(RequestChallengeInfo requestChallengeInfo) {
                VerifyPushContract.View view;
                Intrinsics.checkNotNullParameter(requestChallengeInfo, "");
                view = VerifyPushLoginPresenter.this.scheduleImpl;
                String challengeSid = requestChallengeInfo.getChallengeSid();
                requestChallengeInfo.getTimer();
                view.getAuthRequestContext(challengeSid, true);
                VerifyPushLoginPresenter.this.PlaceComponentResult = requestChallengeInfo.getChallengeSid();
                final VerifyPushLoginPresenter verifyPushLoginPresenter = VerifyPushLoginPresenter.this;
                final String challengeSid2 = requestChallengeInfo.getChallengeSid();
                Intrinsics.checkNotNullParameter(challengeSid2, "");
                Intrinsics.checkNotNullParameter(ChallengeScenario.TRUST_RISK_LOGIN, "");
                verifyPushLoginPresenter.NetworkUserEntityData$$ExternalSyntheticLambda0.execute(new DefaultObserver<LoginResponse>() { // from class: id.dana.challenge.verifypush.VerifyPushLoginPresenter$verifyPushLogin$1
                    @Override // id.dana.domain.DefaultObserver, io.reactivex.Observer
                    public final /* synthetic */ void onNext(Object obj) {
                        VerifyPushContract.View view2;
                        VerifyPushContract.View view3;
                        VerifyPushContract.View view4;
                        LoginResponse loginResponse = (LoginResponse) obj;
                        Intrinsics.checkNotNullParameter(loginResponse, "");
                        if (loginResponse.isSuccess()) {
                            view4 = VerifyPushLoginPresenter.this.scheduleImpl;
                            view4.getAuthRequestContext(challengeSid2);
                        } else if (Intrinsics.areEqual(loginResponse.getErrorCode(), ErrorCode.ERROR_RISK_REJECT)) {
                            view3 = VerifyPushLoginPresenter.this.scheduleImpl;
                            view3.PlaceComponentResult(challengeSid2, loginResponse.getErrorCode(), loginResponse.getErrorMessage());
                            String errorMessage = loginResponse.getErrorMessage();
                            LoginFailureExceptionKt.BuiltInFictitiousFunctionClassFactory(new LoginFailureException(errorMessage != null ? errorMessage : ""));
                        } else {
                            String errorMessage2 = loginResponse.getErrorMessage();
                            String str = errorMessage2 != null ? errorMessage2 : "";
                            String errorCode = loginResponse.getErrorCode();
                            LoginFailureExceptionKt.BuiltInFictitiousFunctionClassFactory(new LoginFailureException(str));
                            view2 = VerifyPushLoginPresenter.this.scheduleImpl;
                            view2.getAuthRequestContext(str, challengeSid2, errorCode);
                        }
                    }

                    @Override // id.dana.domain.DefaultObserver, io.reactivex.Observer
                    public final void onError(Throwable p02) {
                        VerifyPushContract.View view2;
                        Intrinsics.checkNotNullParameter(p02, "");
                        String message = p02.getMessage();
                        LoginFailureExceptionKt.BuiltInFictitiousFunctionClassFactory(new LoginFailureException(p02));
                        view2 = VerifyPushLoginPresenter.this.scheduleImpl;
                        view2.getAuthRequestContext(message, challengeSid2, "");
                    }
                }, new VerifyPushLogin.Params(challengeSid2, ChallengeScenario.TRUST_RISK_LOGIN, verifyPushLoginPresenter.MyBillsEntityDataFactory, verifyPushLoginPresenter.getAuthRequestContext));
            }
        }, new Function1<Throwable, Unit>() { // from class: id.dana.challenge.verifypush.VerifyPushLoginPresenter$requestChallenge$2
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
                VerifyPushContract.View view;
                Intrinsics.checkNotNullParameter(th, "");
                view = VerifyPushLoginPresenter.this.scheduleImpl;
                view.getAuthRequestContext("", false);
                DanaLog.BuiltInFictitiousFunctionClassFactory(DanaLogConstants.TAG.TWILIO_REQUEST_CHALLENGE, th.getMessage(), th);
            }
        });
    }

    @Override // id.dana.base.AbstractContractKt.AbstractPresenter, id.dana.base.AbstractContract.AbstractPresenter
    public final void onDestroy() {
        this.KClassImpl$Data$declaredNonStaticMembers$2.dispose();
        this.BuiltInFictitiousFunctionClassFactory.dispose();
        this.NetworkUserEntityData$$ExternalSyntheticLambda0.dispose();
    }
}
