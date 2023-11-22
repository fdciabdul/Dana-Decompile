package id.dana.challenge.otp;

import android.content.Context;
import id.dana.challenge.otp.AbstractOtpContract;
import id.dana.domain.DefaultObserver;
import id.dana.domain.core.usecase.BaseUseCase;
import id.dana.domain.core.usecase.NoParams;
import id.dana.domain.otp.interactor.ReceiveOtp;
import id.dana.domain.otp.interactor.SendOtp;
import id.dana.domain.otp.model.SendOtpResponse;
import id.dana.domain.otp.model.SendStrategy;
import id.dana.domain.twilio.interactor.TwilioVerifySecurityProduct;
import id.dana.domain.twilio.model.TwilioVerify;
import id.dana.domain.twilio.model.VerifySecurityInfo;
import id.dana.network.exception.NetworkException;
import id.dana.tracker.EventTracker;
import id.dana.tracker.mixpanel.ChallengeEvent;
import id.dana.tracker.model.TrackOtpModel;
import id.dana.utils.foundation.logger.log.DanaLogConstants;
import id.dana.utils.log.CrashlyticsLogUtil;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 *2\u00020\u0001:\u0001*B1\b\u0007\u0012\u0006\u0010\u0006\u001a\u00020'\u0012\u0006\u0010\f\u001a\u00020$\u0012\u0006\u0010\r\u001a\u00020\u001c\u0012\u0006\u0010\u000e\u001a\u00020 \u0012\u0006\u0010\u000f\u001a\u00020\u001a¢\u0006\u0004\b(\u0010)J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J\u0019\u0010\u0007\u001a\u00020\u00022\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\n\u001a\u00020\tH\u0016¢\u0006\u0004\b\n\u0010\u000bJG\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00052\b\u0010\f\u001a\u0004\u0018\u00010\u00052\b\u0010\r\u001a\u0004\u0018\u00010\u00052\b\u0010\u000e\u001a\u0004\u0018\u00010\u00052\b\u0010\u000f\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0010\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0007\u0010\u0011J9\u0010\u0012\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\u00052\b\u0010\u000e\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u000f\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0012\u0010\u0013J\u000f\u0010\u0014\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0014\u0010\u0004J\u000f\u0010\u0012\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0012\u0010\u0004J\u0017\u0010\n\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\n\u0010\bJ7\u0010\u0015\u001a\u00020\u00022\b\u0010\u0006\u001a\u0004\u0018\u00010\u00052\b\u0010\f\u001a\u0004\u0018\u00010\u00052\b\u0010\r\u001a\u0004\u0018\u00010\u00052\b\u0010\u000e\u001a\u0004\u0018\u00010\u0005H\u0016¢\u0006\u0004\b\u0015\u0010\u0016J\u0019\u0010\u0012\u001a\u00020\u00022\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0016¢\u0006\u0004\b\u0012\u0010\bR\u0016\u0010\n\u001a\u00020\u00178\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0007\u0010\u0018R\u0016\u0010\u0012\u001a\u00020\t8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0015\u0010\u0019R\u0014\u0010\u0007\u001a\u00020\u001a8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0012\u0010\u001bR\u0014\u0010\u0003\u001a\u00020\u001c8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u001dR\u0016\u0010\u0015\u001a\u00020\u001e8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\n\u0010\u001fR\u0014\u0010#\u001a\u00020 8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b!\u0010\"R\u0014\u0010%\u001a\u00020$8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b%\u0010&"}, d2 = {"Lid/dana/challenge/otp/OtpTwilioPresenter;", "Lid/dana/challenge/otp/AbstractOtpContract$Presenter;", "", "getAuthRequestContext", "()V", "", "p0", "BuiltInFictitiousFunctionClassFactory", "(Ljava/lang/String;)V", "", "PlaceComponentResult", "()I", "p1", "p2", "p3", "p4", "p5", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "KClassImpl$Data$declaredNonStaticMembers$2", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "onDestroy", "MyBillsEntityDataFactory", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "", "Z", "I", "Lid/dana/domain/otp/interactor/ReceiveOtp;", "Lid/dana/domain/otp/interactor/ReceiveOtp;", "Lid/dana/domain/otp/interactor/SendOtp;", "Lid/dana/domain/otp/interactor/SendOtp;", "Lid/dana/tracker/model/TrackOtpModel;", "Lid/dana/tracker/model/TrackOtpModel;", "Lid/dana/domain/twilio/interactor/TwilioVerifySecurityProduct;", "scheduleImpl", "Lid/dana/domain/twilio/interactor/TwilioVerifySecurityProduct;", "lookAheadTest", "Lid/dana/challenge/otp/AbstractOtpContract$View;", "getErrorConfigVersion", "Lid/dana/challenge/otp/AbstractOtpContract$View;", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;Lid/dana/challenge/otp/AbstractOtpContract$View;Lid/dana/domain/otp/interactor/SendOtp;Lid/dana/domain/twilio/interactor/TwilioVerifySecurityProduct;Lid/dana/domain/otp/interactor/ReceiveOtp;)V", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class OtpTwilioPresenter implements AbstractOtpContract.Presenter {

    /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
    private boolean PlaceComponentResult;

    /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
    private final ReceiveOtp BuiltInFictitiousFunctionClassFactory;

    /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
    private int KClassImpl$Data$declaredNonStaticMembers$2;

    /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
    private TrackOtpModel MyBillsEntityDataFactory;
    private final SendOtp getAuthRequestContext;
    private final AbstractOtpContract.View getErrorConfigVersion;

    /* renamed from: scheduleImpl  reason: from kotlin metadata */
    private final TwilioVerifySecurityProduct lookAheadTest;

    @Override // id.dana.challenge.otp.AbstractOtpContract.Presenter
    public final /* synthetic */ OtpState BuiltInFictitiousFunctionClassFactory() {
        return AbstractOtpContract.Presenter.CC.BuiltInFictitiousFunctionClassFactory();
    }

    @Override // id.dana.challenge.otp.AbstractOtpContract.Presenter
    public final void KClassImpl$Data$declaredNonStaticMembers$2(String p0, String p1, String p2, String p3, String p4) {
        Intrinsics.checkNotNullParameter(p0, "");
        Intrinsics.checkNotNullParameter(p1, "");
        Intrinsics.checkNotNullParameter(p2, "");
        Intrinsics.checkNotNullParameter(p4, "");
    }

    @Override // id.dana.challenge.otp.AbstractOtpContract.Presenter
    public final /* synthetic */ void KClassImpl$Data$declaredNonStaticMembers$2(String str, String str2, String str3, String str4, boolean z) {
        AbstractOtpContract.Presenter.CC.PlaceComponentResult(str, str2);
    }

    @Override // id.dana.challenge.otp.AbstractOtpContract.Presenter
    public final /* synthetic */ void MyBillsEntityDataFactory() {
        AbstractOtpContract.Presenter.CC.getAuthRequestContext();
    }

    @Override // id.dana.challenge.otp.AbstractOtpContract.Presenter
    public final /* synthetic */ void NetworkUserEntityData$$ExternalSyntheticLambda0() {
        AbstractOtpContract.Presenter.CC.MyBillsEntityDataFactory();
    }

    @Override // id.dana.challenge.otp.AbstractOtpContract.Presenter
    public final /* synthetic */ void PlaceComponentResult(String str, String str2, String str3) {
        AbstractOtpContract.Presenter.CC.getAuthRequestContext(str, str2, str3);
    }

    @Override // id.dana.challenge.otp.AbstractOtpContract.Presenter
    public final /* synthetic */ void lookAheadTest() {
        AbstractOtpContract.Presenter.CC.PlaceComponentResult();
    }

    @Override // id.dana.challenge.otp.AbstractOtpContract.Presenter
    public final /* synthetic */ void moveToNextValue() {
        AbstractOtpContract.Presenter.CC.KClassImpl$Data$declaredNonStaticMembers$2();
    }

    @Inject
    public OtpTwilioPresenter(Context context, AbstractOtpContract.View view, SendOtp sendOtp, TwilioVerifySecurityProduct twilioVerifySecurityProduct, ReceiveOtp receiveOtp) {
        Intrinsics.checkNotNullParameter(context, "");
        Intrinsics.checkNotNullParameter(view, "");
        Intrinsics.checkNotNullParameter(sendOtp, "");
        Intrinsics.checkNotNullParameter(twilioVerifySecurityProduct, "");
        Intrinsics.checkNotNullParameter(receiveOtp, "");
        this.getErrorConfigVersion = view;
        this.getAuthRequestContext = sendOtp;
        this.lookAheadTest = twilioVerifySecurityProduct;
        this.BuiltInFictitiousFunctionClassFactory = receiveOtp;
        this.MyBillsEntityDataFactory = new TrackOtpModel(context, "");
        this.KClassImpl$Data$declaredNonStaticMembers$2 = 1;
    }

    @Override // id.dana.challenge.otp.AbstractOtpContract.Presenter
    public final void BuiltInFictitiousFunctionClassFactory(String p0) {
        if (this.PlaceComponentResult) {
            return;
        }
        this.PlaceComponentResult = true;
        EventTracker.PlaceComponentResult(this.MyBillsEntityDataFactory.PlaceComponentResult(p0));
    }

    @Override // id.dana.challenge.otp.AbstractOtpContract.Presenter
    public final void BuiltInFictitiousFunctionClassFactory(String p0, String p1, String p2, final String p3, final String p4, String p5) {
        Intrinsics.checkNotNullParameter(p0, "");
        Intrinsics.checkNotNullParameter(p5, "");
        this.getErrorConfigVersion.showProgress();
        TwilioVerifySecurityProduct twilioVerifySecurityProduct = this.lookAheadTest;
        DefaultObserver<VerifySecurityInfo> defaultObserver = new DefaultObserver<VerifySecurityInfo>() { // from class: id.dana.challenge.otp.OtpTwilioPresenter$input$1
            @Override // id.dana.domain.DefaultObserver, io.reactivex.Observer
            public final /* synthetic */ void onNext(Object obj) {
                AbstractOtpContract.View view;
                TrackOtpModel trackOtpModel;
                int i;
                AbstractOtpContract.View view2;
                VerifySecurityInfo verifySecurityInfo = (VerifySecurityInfo) obj;
                Intrinsics.checkNotNullParameter(verifySecurityInfo, "");
                view = OtpTwilioPresenter.this.getErrorConfigVersion;
                view.dismissProgress();
                if (verifySecurityInfo.getSuccess()) {
                    view2 = OtpTwilioPresenter.this.getErrorConfigVersion;
                    view2.KClassImpl$Data$declaredNonStaticMembers$2();
                } else {
                    String MyBillsEntityDataFactory = OtpTwilioPresenter.MyBillsEntityDataFactory(p3);
                    StringBuilder sb = new StringBuilder();
                    sb.append(OtpTwilioPresenter.getAuthRequestContext(p3));
                    sb.append("input OTP error: errorCode = ");
                    sb.append(verifySecurityInfo.getErrorCode());
                    sb.append(", errorMessage = ");
                    sb.append(verifySecurityInfo.getErrorMessage());
                    CrashlyticsLogUtil.BuiltInFictitiousFunctionClassFactory(MyBillsEntityDataFactory, sb.toString());
                }
                trackOtpModel = OtpTwilioPresenter.this.MyBillsEntityDataFactory;
                boolean success = verifySecurityInfo.getSuccess();
                int identFailedCount = verifySecurityInfo.getIdentFailedCount();
                i = OtpTwilioPresenter.this.KClassImpl$Data$declaredNonStaticMembers$2;
                EventTracker.PlaceComponentResult(trackOtpModel.BuiltInFictitiousFunctionClassFactory(success, identFailedCount, i, p4));
            }

            @Override // id.dana.domain.DefaultObserver, io.reactivex.Observer
            public final void onError(Throwable p02) {
                AbstractOtpContract.View view;
                AbstractOtpContract.View view2;
                AbstractOtpContract.View view3;
                Intrinsics.checkNotNullParameter(p02, "");
                view = OtpTwilioPresenter.this.getErrorConfigVersion;
                view.dismissProgress();
                if (p02 instanceof NetworkException) {
                    view3 = OtpTwilioPresenter.this.getErrorConfigVersion;
                    NetworkException networkException = (NetworkException) p02;
                    String errorCode = networkException.getErrorCode();
                    String message = p02.getMessage();
                    Intrinsics.checkNotNullExpressionValue(networkException.getLeftTimes(), "");
                    view3.BuiltInFictitiousFunctionClassFactory(errorCode, message, null, networkException.getTraceId());
                    return;
                }
                view2 = OtpTwilioPresenter.this.getErrorConfigVersion;
                view2.onError(p02.getMessage());
                String MyBillsEntityDataFactory = OtpTwilioPresenter.MyBillsEntityDataFactory(p3);
                StringBuilder sb = new StringBuilder();
                sb.append(OtpTwilioPresenter.getAuthRequestContext(p3));
                sb.append("input OTP  error: ");
                sb.append(p02);
                CrashlyticsLogUtil.PlaceComponentResult(MyBillsEntityDataFactory, sb.toString(), p02);
            }
        };
        if (p2 == null) {
            p2 = "";
        }
        if (p3 == null) {
            p3 = "";
        }
        twilioVerifySecurityProduct.execute(defaultObserver, new TwilioVerifySecurityProduct.Param(new TwilioVerify(p2, "OTP_SMS", p0, p3)));
    }

    @Override // id.dana.challenge.otp.AbstractOtpContract.Presenter
    public final void MyBillsEntityDataFactory(final String str, String str2, String str3) {
        this.getErrorConfigVersion.showProgress();
        EventTracker.PlaceComponentResult(this.MyBillsEntityDataFactory.BuiltInFictitiousFunctionClassFactory(ChallengeEvent.Channel.SMS, str3));
        this.KClassImpl$Data$declaredNonStaticMembers$2++;
        this.getAuthRequestContext.execute(new DefaultObserver<SendOtpResponse>() { // from class: id.dana.challenge.otp.OtpTwilioPresenter$send$1
            @Override // id.dana.domain.DefaultObserver, io.reactivex.Observer
            public final /* synthetic */ void onNext(Object obj) {
                AbstractOtpContract.View view;
                AbstractOtpContract.View view2;
                SendOtpResponse sendOtpResponse = (SendOtpResponse) obj;
                Intrinsics.checkNotNullParameter(sendOtpResponse, "");
                view = OtpTwilioPresenter.this.getErrorConfigVersion;
                view.dismissProgress();
                if (sendOtpResponse.isSuccess()) {
                    OtpTwilioPresenter.this.PlaceComponentResult = false;
                    view2 = OtpTwilioPresenter.this.getErrorConfigVersion;
                    sendOtpResponse.getExpirySeconds();
                    view2.MyBillsEntityDataFactory(sendOtpResponse.getRetrySendSeconds(), sendOtpResponse.getOtpCodeLength());
                    return;
                }
                String MyBillsEntityDataFactory = OtpTwilioPresenter.MyBillsEntityDataFactory(str);
                StringBuilder sb = new StringBuilder();
                sb.append(OtpTwilioPresenter.getAuthRequestContext(str));
                sb.append("send OTP error: errorCode = ");
                sb.append(sendOtpResponse.getErrorCode());
                sb.append(", errorMessage = ");
                sb.append(sendOtpResponse.getErrorMessage());
                CrashlyticsLogUtil.BuiltInFictitiousFunctionClassFactory(MyBillsEntityDataFactory, sb.toString());
            }

            @Override // id.dana.domain.DefaultObserver, io.reactivex.Observer
            public final void onError(Throwable p0) {
                AbstractOtpContract.View view;
                AbstractOtpContract.View view2;
                AbstractOtpContract.View view3;
                Intrinsics.checkNotNullParameter(p0, "");
                view = OtpTwilioPresenter.this.getErrorConfigVersion;
                view.dismissProgress();
                if (p0 instanceof NetworkException) {
                    view3 = OtpTwilioPresenter.this.getErrorConfigVersion;
                    NetworkException networkException = (NetworkException) p0;
                    String errorCode = networkException.getErrorCode();
                    String message = p0.getMessage();
                    Intrinsics.checkNotNullExpressionValue(networkException.getLeftTimes(), "");
                    view3.BuiltInFictitiousFunctionClassFactory(errorCode, message, null, "");
                } else {
                    view2 = OtpTwilioPresenter.this.getErrorConfigVersion;
                    view2.onError(p0.getMessage());
                }
                String MyBillsEntityDataFactory = OtpTwilioPresenter.MyBillsEntityDataFactory(str);
                StringBuilder sb = new StringBuilder();
                sb.append(OtpTwilioPresenter.getAuthRequestContext(str));
                sb.append("send OTP  error: ");
                sb.append(p0);
                CrashlyticsLogUtil.PlaceComponentResult(MyBillsEntityDataFactory, sb.toString(), p0);
            }
        }, SendOtp.Params.Companion.forSendOtp$default(SendOtp.Params.INSTANCE, str, str2, null, false, null, null, null, 124, null));
    }

    @Override // id.dana.challenge.otp.AbstractOtpContract.Presenter
    public final void KClassImpl$Data$declaredNonStaticMembers$2(String p0) {
        throw new UnsupportedOperationException();
    }

    @Override // id.dana.challenge.otp.AbstractOtpContract.Presenter
    public final void KClassImpl$Data$declaredNonStaticMembers$2() {
        BaseUseCase.execute$default(this.BuiltInFictitiousFunctionClassFactory, NoParams.INSTANCE, new Function1<String, Unit>() { // from class: id.dana.challenge.otp.OtpTwilioPresenter$receiveOtp$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final /* bridge */ /* synthetic */ Unit invoke(String str) {
                invoke2(str);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(String str) {
                AbstractOtpContract.View view;
                Intrinsics.checkNotNullParameter(str, "");
                view = OtpTwilioPresenter.this.getErrorConfigVersion;
                view.PlaceComponentResult(str);
            }
        }, null, 4, null);
    }

    @Override // id.dana.challenge.otp.AbstractOtpContract.Presenter
    public final void getAuthRequestContext() {
        throw new UnsupportedOperationException();
    }

    @Override // id.dana.challenge.otp.AbstractOtpContract.Presenter
    /* renamed from: PlaceComponentResult  reason: from getter */
    public final int getKClassImpl$Data$declaredNonStaticMembers$2() {
        return this.KClassImpl$Data$declaredNonStaticMembers$2;
    }

    @Override // id.dana.challenge.otp.AbstractOtpContract.Presenter
    public final void PlaceComponentResult(String p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        throw new UnsupportedOperationException();
    }

    @Override // id.dana.base.AbstractContractKt.AbstractPresenter, id.dana.base.AbstractContract.AbstractPresenter
    public final void onDestroy() {
        this.getAuthRequestContext.dispose();
        this.lookAheadTest.dispose();
        this.BuiltInFictitiousFunctionClassFactory.dispose();
    }

    public static final /* synthetic */ String getAuthRequestContext(String str) {
        return Intrinsics.areEqual(str, SendStrategy.AUTH_AGREEMENT) ? DanaLogConstants.Prefix.OTP_AUTH_AGREEMENT_PREFIX : DanaLogConstants.Prefix.OTP_TWILIO_PREFIX;
    }

    public static final /* synthetic */ String MyBillsEntityDataFactory(String str) {
        return Intrinsics.areEqual(str, SendStrategy.AUTH_AGREEMENT) ? DanaLogConstants.TAG.AUTH_AGREEMENT_OTP_TAG : DanaLogConstants.TAG.TWILIO_OTP_TAG;
    }
}
