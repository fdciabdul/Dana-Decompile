package id.dana.challenge.otp;

import android.content.Context;
import dagger.Lazy;
import id.dana.analytics.tracker.TrackerDataKey;
import id.dana.analytics.tracker.register.RegistrationTracker;
import id.dana.cashier.view.InputCardNumberView;
import id.dana.challenge.otp.AbstractOtpContract;
import id.dana.challenge.otp.OtpState;
import id.dana.di.PerActivity;
import id.dana.domain.core.usecase.BaseUseCase;
import id.dana.domain.core.usecase.CompletableUseCase;
import id.dana.domain.core.usecase.NoParams;
import id.dana.domain.featureconfig.interactor.CheckResendWhatsAppEnable;
import id.dana.domain.model.rpc.response.CheckRegistrationResponse;
import id.dana.domain.otp.interactor.ReceiveOtp;
import id.dana.domain.otp.interactor.VerifyOtp;
import id.dana.domain.otp.interactor.VerifyOtpRisk;
import id.dana.domain.otp.model.OtpChannel;
import id.dana.domain.otp.model.VerifyOtpResponse;
import id.dana.domain.otp.model.VerifyOtpRiskResponse;
import id.dana.domain.registration.interactor.GetNumberOfRequestOtp;
import id.dana.domain.registration.interactor.RemoveNumberOfRequestOtp;
import id.dana.domain.registration.interactor.ResendOtp;
import id.dana.domain.registration.interactor.SaveIsFreezeVerifyOtp;
import id.dana.domain.registration.interactor.SaveNumberOfRequestOtp;
import id.dana.network.exception.NetworkException;
import id.dana.tracker.EventTracker;
import id.dana.tracker.mixpanel.ChallengeEvent;
import id.dana.tracker.mixpanel.MixPanelTracker;
import id.dana.tracker.model.TrackOtpModel;
import id.dana.utils.ErrorUtil;
import id.dana.utils.foundation.logger.log.DanaLog;
import id.dana.utils.foundation.logger.log.DanaLogConstants;
import id.dana.utils.log.CrashlyticsLogUtil;
import id.dana.utils.tracker.mixpanel.MixpanelValueUtil;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0096\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\b\u0007\u0018\u0000 O2\u00020\u0001:\u0001OBu\b\u0001\u0012\u0006\u0010\u0006\u001a\u00020\u001e\u0012\u0006\u0010\u000e\u001a\u00020D\u0012\u0006\u0010\u000f\u001a\u00020>\u0012\u0006\u0010\u0010\u001a\u00020B\u0012\u0006\u0010\u0012\u001a\u000203\u0012\u0006\u0010\u0015\u001a\u00020(\u0012\u0006\u0010G\u001a\u00020\u001b\u0012\u0006\u0010H\u001a\u00020#\u0012\u0006\u0010I\u001a\u000208\u0012\u0006\u0010J\u001a\u00020/\u0012\f\u0010K\u001a\b\u0012\u0004\u0012\u0002060+\u0012\f\u0010L\u001a\b\u0012\u0004\u0012\u00020,0+¢\u0006\u0004\bM\u0010NJ\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J\u0019\u0010\u0007\u001a\u00020\u00022\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\n\u001a\u00020\tH\u0016¢\u0006\u0004\b\n\u0010\u000bJ\u000f\u0010\u0007\u001a\u00020\fH\u0016¢\u0006\u0004\b\u0007\u0010\rJ;\u0010\u0013\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\u00052\b\u0010\u000f\u001a\u0004\u0018\u00010\u00052\b\u0010\u0010\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0012\u001a\u00020\u0011H\u0016¢\u0006\u0004\b\u0013\u0010\u0014JG\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00052\b\u0010\u000e\u001a\u0004\u0018\u00010\u00052\b\u0010\u000f\u001a\u0004\u0018\u00010\u00052\b\u0010\u0010\u001a\u0004\u0018\u00010\u00052\b\u0010\u0012\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0015\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0007\u0010\u0016J9\u0010\u0013\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00020\u00052\b\u0010\u0010\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0012\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0013\u0010\u0017J\u000f\u0010\u0018\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0018\u0010\u0004J\u000f\u0010\u0013\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0013\u0010\u0004J\u0017\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0000¢\u0006\u0004\b\u0003\u0010\bJ\u0017\u0010\n\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\n\u0010\bJ7\u0010\u0019\u001a\u00020\u00022\b\u0010\u0006\u001a\u0004\u0018\u00010\u00052\b\u0010\u000e\u001a\u0004\u0018\u00010\u00052\b\u0010\u000f\u001a\u0004\u0018\u00010\u00052\b\u0010\u0010\u001a\u0004\u0018\u00010\u0005H\u0016¢\u0006\u0004\b\u0019\u0010\u001aJ\u0019\u0010\u0013\u001a\u00020\u00022\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0016¢\u0006\u0004\b\u0013\u0010\bR\u0014\u0010\u0013\u001a\u00020\u001b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\u0014\u0010\u0019\u001a\u00020\u001e8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001f\u0010 R\u0016\u0010\u0003\u001a\u00020\t8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b!\u0010\"R\u0014\u0010\u0007\u001a\u00020#8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b$\u0010%R\u0012\u0010\n\u001a\u00020\u0011X\u0080\u0002¢\u0006\u0006\n\u0004\b\u0003\u0010&R\u0014\u0010!\u001a\u0004\u0018\u00010\u0005X\u0080\u0002¢\u0006\u0006\n\u0004\b\u0013\u0010'R\u0012\u0010\u001f\u001a\u00020\u0011X\u0080\u0002¢\u0006\u0006\n\u0004\b\u0007\u0010&R\u0012\u0010$\u001a\u00020\tX\u0080\u0002¢\u0006\u0006\n\u0004\b\u0019\u0010\"R\u0014\u0010\u001c\u001a\u0004\u0018\u00010\u0005X\u0080\u0002¢\u0006\u0006\n\u0004\b\n\u0010'R\u0014\u0010)\u001a\u00020(8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b)\u0010*R\u001a\u0010-\u001a\b\u0012\u0004\u0012\u00020,0+8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b-\u0010.R\u0014\u00102\u001a\u00020/8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b0\u00101R\u0014\u00100\u001a\u0002038\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b4\u00105R\u001a\u00107\u001a\b\u0012\u0004\u0012\u0002060+8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b2\u0010.R\u0014\u00104\u001a\u0002088\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b7\u00109R\u0014\u0010=\u001a\u00020:8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b;\u0010<R\u0014\u0010A\u001a\u00020>8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b?\u0010@R\u0014\u0010?\u001a\u00020B8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b=\u0010CR\u0014\u0010F\u001a\u00020D8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bA\u0010E"}, d2 = {"Lid/dana/challenge/otp/OtpRegistrationPresenter;", "Lid/dana/challenge/otp/AbstractOtpContract$Presenter;", "", "getAuthRequestContext", "()V", "", "p0", "BuiltInFictitiousFunctionClassFactory", "(Ljava/lang/String;)V", "", "PlaceComponentResult", "()I", "Lid/dana/challenge/otp/OtpState;", "()Lid/dana/challenge/otp/OtpState;", "p1", "p2", "p3", "", "p4", "KClassImpl$Data$declaredNonStaticMembers$2", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Z)V", "p5", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "onDestroy", "MyBillsEntityDataFactory", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "Lid/dana/domain/featureconfig/interactor/CheckResendWhatsAppEnable;", "moveToNextValue", "Lid/dana/domain/featureconfig/interactor/CheckResendWhatsAppEnable;", "Landroid/content/Context;", "scheduleImpl", "Landroid/content/Context;", "getErrorConfigVersion", "I", "Lid/dana/domain/registration/interactor/GetNumberOfRequestOtp;", "lookAheadTest", "Lid/dana/domain/registration/interactor/GetNumberOfRequestOtp;", "Z", "Ljava/lang/String;", "Lid/dana/domain/otp/interactor/ReceiveOtp;", "NetworkUserEntityData$$ExternalSyntheticLambda0", "Lid/dana/domain/otp/interactor/ReceiveOtp;", "Ldagger/Lazy;", "Lid/dana/analytics/tracker/register/RegistrationTracker;", "NetworkUserEntityData$$ExternalSyntheticLambda2", "Ldagger/Lazy;", "Lid/dana/domain/registration/interactor/RemoveNumberOfRequestOtp;", "NetworkUserEntityData$$ExternalSyntheticLambda1", "Lid/dana/domain/registration/interactor/RemoveNumberOfRequestOtp;", "initRecordTimeStamp", "Lid/dana/domain/registration/interactor/ResendOtp;", "GetContactSyncConfig", "Lid/dana/domain/registration/interactor/ResendOtp;", "Lid/dana/domain/registration/interactor/SaveIsFreezeVerifyOtp;", "DatabaseTableConfigUtil", "Lid/dana/domain/registration/interactor/SaveNumberOfRequestOtp;", "Lid/dana/domain/registration/interactor/SaveNumberOfRequestOtp;", "Lid/dana/tracker/model/TrackOtpModel;", "isLayoutRequested", "Lid/dana/tracker/model/TrackOtpModel;", "PrepareContext", "Lid/dana/domain/otp/interactor/VerifyOtp;", "newProxyInstance", "Lid/dana/domain/otp/interactor/VerifyOtp;", "NetworkUserEntityData$$ExternalSyntheticLambda7", "Lid/dana/domain/otp/interactor/VerifyOtpRisk;", "Lid/dana/domain/otp/interactor/VerifyOtpRisk;", "Lid/dana/challenge/otp/AbstractOtpContract$View;", "Lid/dana/challenge/otp/AbstractOtpContract$View;", "NetworkUserEntityData$$ExternalSyntheticLambda8", "p6", "p7", "p8", "p9", "p10", "p11", "<init>", "(Landroid/content/Context;Lid/dana/challenge/otp/AbstractOtpContract$View;Lid/dana/domain/otp/interactor/VerifyOtp;Lid/dana/domain/otp/interactor/VerifyOtpRisk;Lid/dana/domain/registration/interactor/ResendOtp;Lid/dana/domain/otp/interactor/ReceiveOtp;Lid/dana/domain/featureconfig/interactor/CheckResendWhatsAppEnable;Lid/dana/domain/registration/interactor/GetNumberOfRequestOtp;Lid/dana/domain/registration/interactor/SaveNumberOfRequestOtp;Lid/dana/domain/registration/interactor/RemoveNumberOfRequestOtp;Ldagger/Lazy;Ldagger/Lazy;)V", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
@PerActivity
/* loaded from: classes4.dex */
public final class OtpRegistrationPresenter implements AbstractOtpContract.Presenter {

    /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
    public boolean scheduleImpl;

    /* renamed from: DatabaseTableConfigUtil  reason: from kotlin metadata */
    private final SaveNumberOfRequestOtp GetContactSyncConfig;

    /* renamed from: GetContactSyncConfig  reason: from kotlin metadata */
    private final ResendOtp NetworkUserEntityData$$ExternalSyntheticLambda1;

    /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
    String getErrorConfigVersion;

    /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
    int lookAheadTest;
    private final ReceiveOtp NetworkUserEntityData$$ExternalSyntheticLambda0;

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda1  reason: from kotlin metadata */
    private final RemoveNumberOfRequestOtp initRecordTimeStamp;
    private final Lazy<RegistrationTracker> NetworkUserEntityData$$ExternalSyntheticLambda2;

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda7  reason: from kotlin metadata */
    private final AbstractOtpContract.View NetworkUserEntityData$$ExternalSyntheticLambda8;

    /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
    String moveToNextValue;

    /* renamed from: PrepareContext  reason: from kotlin metadata */
    private final VerifyOtpRisk newProxyInstance;

    /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
    boolean PlaceComponentResult;

    /* renamed from: getErrorConfigVersion  reason: from kotlin metadata */
    private int getAuthRequestContext;

    /* renamed from: initRecordTimeStamp  reason: from kotlin metadata */
    private final Lazy<SaveIsFreezeVerifyOtp> DatabaseTableConfigUtil;

    /* renamed from: isLayoutRequested  reason: from kotlin metadata */
    private final TrackOtpModel PrepareContext;

    /* renamed from: lookAheadTest  reason: from kotlin metadata */
    private final GetNumberOfRequestOtp BuiltInFictitiousFunctionClassFactory;

    /* renamed from: moveToNextValue  reason: from kotlin metadata */
    private final CheckResendWhatsAppEnable KClassImpl$Data$declaredNonStaticMembers$2;

    /* renamed from: newProxyInstance  reason: from kotlin metadata */
    private final VerifyOtp NetworkUserEntityData$$ExternalSyntheticLambda7;

    /* renamed from: scheduleImpl  reason: from kotlin metadata */
    private final Context MyBillsEntityDataFactory;

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
    public OtpRegistrationPresenter(Context context, AbstractOtpContract.View view, VerifyOtp verifyOtp, VerifyOtpRisk verifyOtpRisk, ResendOtp resendOtp, ReceiveOtp receiveOtp, CheckResendWhatsAppEnable checkResendWhatsAppEnable, GetNumberOfRequestOtp getNumberOfRequestOtp, SaveNumberOfRequestOtp saveNumberOfRequestOtp, RemoveNumberOfRequestOtp removeNumberOfRequestOtp, Lazy<SaveIsFreezeVerifyOtp> lazy, Lazy<RegistrationTracker> lazy2) {
        Intrinsics.checkNotNullParameter(context, "");
        Intrinsics.checkNotNullParameter(view, "");
        Intrinsics.checkNotNullParameter(verifyOtp, "");
        Intrinsics.checkNotNullParameter(verifyOtpRisk, "");
        Intrinsics.checkNotNullParameter(resendOtp, "");
        Intrinsics.checkNotNullParameter(receiveOtp, "");
        Intrinsics.checkNotNullParameter(checkResendWhatsAppEnable, "");
        Intrinsics.checkNotNullParameter(getNumberOfRequestOtp, "");
        Intrinsics.checkNotNullParameter(saveNumberOfRequestOtp, "");
        Intrinsics.checkNotNullParameter(removeNumberOfRequestOtp, "");
        Intrinsics.checkNotNullParameter(lazy, "");
        Intrinsics.checkNotNullParameter(lazy2, "");
        this.MyBillsEntityDataFactory = context;
        this.NetworkUserEntityData$$ExternalSyntheticLambda8 = view;
        this.NetworkUserEntityData$$ExternalSyntheticLambda7 = verifyOtp;
        this.newProxyInstance = verifyOtpRisk;
        this.NetworkUserEntityData$$ExternalSyntheticLambda1 = resendOtp;
        this.NetworkUserEntityData$$ExternalSyntheticLambda0 = receiveOtp;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = checkResendWhatsAppEnable;
        this.BuiltInFictitiousFunctionClassFactory = getNumberOfRequestOtp;
        this.GetContactSyncConfig = saveNumberOfRequestOtp;
        this.initRecordTimeStamp = removeNumberOfRequestOtp;
        this.DatabaseTableConfigUtil = lazy;
        this.NetworkUserEntityData$$ExternalSyntheticLambda2 = lazy2;
        this.PrepareContext = new TrackOtpModel(context, "Registration");
        this.lookAheadTest = -1;
    }

    @Override // id.dana.challenge.otp.AbstractOtpContract.Presenter
    public final void KClassImpl$Data$declaredNonStaticMembers$2(String p0, String p1, String p2, String p3, boolean p4) {
        Intrinsics.checkNotNullParameter(p0, "");
        Intrinsics.checkNotNullParameter(p1, "");
        this.getErrorConfigVersion = p1;
        this.moveToNextValue = p0;
        this.PrepareContext.MyBillsEntityDataFactory = Intrinsics.areEqual(p1, OtpChannel.WHATSAPP) ? ChallengeEvent.Channel.WHATSAPP : ChallengeEvent.Channel.SMS;
        BaseUseCase.execute$default(this.BuiltInFictitiousFunctionClassFactory, p0, new Function1<Integer, Unit>() { // from class: id.dana.challenge.otp.OtpRegistrationPresenter$getNumberOfRequestOtp$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final /* synthetic */ Unit invoke(Integer num) {
                invoke(num.intValue());
                return Unit.INSTANCE;
            }

            public final void invoke(int i) {
                if (i == -1) {
                    OtpRegistrationPresenter.this.PlaceComponentResult = false;
                    OtpRegistrationPresenter.this.lookAheadTest = 1;
                    return;
                }
                OtpRegistrationPresenter.this.PlaceComponentResult = true;
                OtpRegistrationPresenter.this.lookAheadTest = i;
            }
        }, null, 4, null);
    }

    @Override // id.dana.challenge.otp.AbstractOtpContract.Presenter
    public final void BuiltInFictitiousFunctionClassFactory(String p0) {
        if (this.scheduleImpl) {
            return;
        }
        this.scheduleImpl = true;
        EventTracker.PlaceComponentResult(this.PrepareContext.PlaceComponentResult(p0));
    }

    @Override // id.dana.challenge.otp.AbstractOtpContract.Presenter
    public final void BuiltInFictitiousFunctionClassFactory(String p0, String p1, String p2, String p3, final String p4, String p5) {
        Intrinsics.checkNotNullParameter(p0, "");
        Intrinsics.checkNotNullParameter(p5, "");
        this.NetworkUserEntityData$$ExternalSyntheticLambda8.showProgress();
        this.NetworkUserEntityData$$ExternalSyntheticLambda7.execute(new VerifyOtp.Param(p0), new Function1<VerifyOtpResponse, Unit>() { // from class: id.dana.challenge.otp.OtpRegistrationPresenter$input$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final /* bridge */ /* synthetic */ Unit invoke(VerifyOtpResponse verifyOtpResponse) {
                invoke2(verifyOtpResponse);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(VerifyOtpResponse verifyOtpResponse) {
                AbstractOtpContract.View view;
                AbstractOtpContract.View view2;
                TrackOtpModel trackOtpModel;
                int i;
                AbstractOtpContract.View view3;
                Intrinsics.checkNotNullParameter(verifyOtpResponse, "");
                view = OtpRegistrationPresenter.this.NetworkUserEntityData$$ExternalSyntheticLambda8;
                view.dismissProgress();
                if (verifyOtpResponse.isSuccess()) {
                    view3 = OtpRegistrationPresenter.this.NetworkUserEntityData$$ExternalSyntheticLambda8;
                    view3.KClassImpl$Data$declaredNonStaticMembers$2();
                    OtpRegistrationPresenter otpRegistrationPresenter = OtpRegistrationPresenter.this;
                    String str = otpRegistrationPresenter.moveToNextValue;
                    CompletableUseCase.execute$default(otpRegistrationPresenter.initRecordTimeStamp, str != null ? str : "", null, null, 6, null);
                } else {
                    view2 = OtpRegistrationPresenter.this.NetworkUserEntityData$$ExternalSyntheticLambda8;
                    view2.BuiltInFictitiousFunctionClassFactory(verifyOtpResponse.getErrorMessage());
                    StringBuilder sb = new StringBuilder();
                    sb.append("[OtpRegister] input OTP: errorCode = ");
                    sb.append(verifyOtpResponse.getErrorCode());
                    sb.append(", errorMessage = ");
                    sb.append(verifyOtpResponse.getErrorMessage());
                    CrashlyticsLogUtil.BuiltInFictitiousFunctionClassFactory(DanaLogConstants.TAG.REGISTER_TAG, sb.toString());
                }
                trackOtpModel = OtpRegistrationPresenter.this.PrepareContext;
                boolean isSuccess = verifyOtpResponse.isSuccess();
                i = OtpRegistrationPresenter.this.getAuthRequestContext;
                EventTracker.PlaceComponentResult(trackOtpModel.BuiltInFictitiousFunctionClassFactory(isSuccess, i, OtpRegistrationPresenter.this.lookAheadTest, p4));
            }
        }, new Function1<Throwable, Unit>() { // from class: id.dana.challenge.otp.OtpRegistrationPresenter$input$2
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
                Context context;
                Context context2;
                Intrinsics.checkNotNullParameter(th, "");
                context = OtpRegistrationPresenter.this.MyBillsEntityDataFactory;
                context2 = OtpRegistrationPresenter.this.MyBillsEntityDataFactory;
                MixPanelTracker.KClassImpl$Data$declaredNonStaticMembers$2(context, TrackerDataKey.NetworkErrorOperationTypeProperty.VERIFY_OTP, ErrorUtil.PlaceComponentResult(th, context2), "Registration", th);
                OtpRegistrationPresenter.KClassImpl$Data$declaredNonStaticMembers$2(OtpRegistrationPresenter.this, th);
            }
        });
    }

    @Override // id.dana.challenge.otp.AbstractOtpContract.Presenter
    public final void KClassImpl$Data$declaredNonStaticMembers$2(String p0, String p1, String p2, final String p3, final String p4) {
        Intrinsics.checkNotNullParameter(p0, "");
        Intrinsics.checkNotNullParameter(p1, "");
        Intrinsics.checkNotNullParameter(p2, "");
        Intrinsics.checkNotNullParameter(p4, "");
        this.NetworkUserEntityData$$ExternalSyntheticLambda8.showProgress();
        this.newProxyInstance.execute(new VerifyOtpRisk.Params(p0, p1, p2, p4, "REGISTER", null, 32, null), new Function1<VerifyOtpRiskResponse, Unit>() { // from class: id.dana.challenge.otp.OtpRegistrationPresenter$inputOtpRisk$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final /* bridge */ /* synthetic */ Unit invoke(VerifyOtpRiskResponse verifyOtpRiskResponse) {
                invoke2(verifyOtpRiskResponse);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(VerifyOtpRiskResponse verifyOtpRiskResponse) {
                AbstractOtpContract.View view;
                AbstractOtpContract.View view2;
                TrackOtpModel trackOtpModel;
                int i;
                AbstractOtpContract.View view3;
                Lazy lazy;
                Intrinsics.checkNotNullParameter(verifyOtpRiskResponse, "");
                view = OtpRegistrationPresenter.this.NetworkUserEntityData$$ExternalSyntheticLambda8;
                view.dismissProgress();
                if (verifyOtpRiskResponse.getSuccess()) {
                    view3 = OtpRegistrationPresenter.this.NetworkUserEntityData$$ExternalSyntheticLambda8;
                    view3.KClassImpl$Data$declaredNonStaticMembers$2();
                    OtpRegistrationPresenter otpRegistrationPresenter = OtpRegistrationPresenter.this;
                    String str = otpRegistrationPresenter.moveToNextValue;
                    CompletableUseCase.execute$default(otpRegistrationPresenter.initRecordTimeStamp, str != null ? str : "", null, null, 6, null);
                    lazy = OtpRegistrationPresenter.this.NetworkUserEntityData$$ExternalSyntheticLambda2;
                    ((RegistrationTracker) lazy.get()).KClassImpl$Data$declaredNonStaticMembers$2(p4);
                } else {
                    view2 = OtpRegistrationPresenter.this.NetworkUserEntityData$$ExternalSyntheticLambda8;
                    view2.BuiltInFictitiousFunctionClassFactory(verifyOtpRiskResponse.getErrorMessage());
                    StringBuilder sb = new StringBuilder();
                    sb.append("[OtpRegister] input OTP: errorCode = ");
                    sb.append(verifyOtpRiskResponse.getErrorCode());
                    sb.append(", errorMessage = ");
                    sb.append(verifyOtpRiskResponse.getErrorMessage());
                    CrashlyticsLogUtil.BuiltInFictitiousFunctionClassFactory(DanaLogConstants.TAG.REGISTER_TAG, sb.toString());
                }
                trackOtpModel = OtpRegistrationPresenter.this.PrepareContext;
                boolean success = verifyOtpRiskResponse.getSuccess();
                i = OtpRegistrationPresenter.this.getAuthRequestContext;
                EventTracker.PlaceComponentResult(trackOtpModel.BuiltInFictitiousFunctionClassFactory(success, i, OtpRegistrationPresenter.this.lookAheadTest, p3));
            }
        }, new Function1<Throwable, Unit>() { // from class: id.dana.challenge.otp.OtpRegistrationPresenter$inputOtpRisk$2
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
                Context context;
                Context context2;
                Intrinsics.checkNotNullParameter(th, "");
                context = OtpRegistrationPresenter.this.MyBillsEntityDataFactory;
                context2 = OtpRegistrationPresenter.this.MyBillsEntityDataFactory;
                MixPanelTracker.KClassImpl$Data$declaredNonStaticMembers$2(context, TrackerDataKey.NetworkErrorOperationTypeProperty.VERIFY_OTP_RISK, ErrorUtil.PlaceComponentResult(th, context2), "Registration", th);
                OtpRegistrationPresenter.KClassImpl$Data$declaredNonStaticMembers$2(OtpRegistrationPresenter.this, th);
            }
        });
    }

    @Override // id.dana.challenge.otp.AbstractOtpContract.Presenter
    public final void MyBillsEntityDataFactory(String str, String str2, String str3) {
        this.NetworkUserEntityData$$ExternalSyntheticLambda8.showProgress();
        getAuthRequestContext(OtpChannel.SMS);
        Intrinsics.checkNotNullParameter(OtpChannel.SMS, "");
        EventTracker.PlaceComponentResult(this.PrepareContext.BuiltInFictitiousFunctionClassFactory(MixpanelValueUtil.getAuthRequestContext(OtpChannel.SMS), str3));
    }

    @Override // id.dana.challenge.otp.AbstractOtpContract.Presenter
    public final void KClassImpl$Data$declaredNonStaticMembers$2(String p0) {
        this.NetworkUserEntityData$$ExternalSyntheticLambda8.showProgress();
        getAuthRequestContext(OtpChannel.WHATSAPP);
        Intrinsics.checkNotNullParameter(OtpChannel.WHATSAPP, "");
        EventTracker.PlaceComponentResult(this.PrepareContext.BuiltInFictitiousFunctionClassFactory(MixpanelValueUtil.getAuthRequestContext(OtpChannel.WHATSAPP), p0));
    }

    @Override // id.dana.challenge.otp.AbstractOtpContract.Presenter
    public final OtpState BuiltInFictitiousFunctionClassFactory() {
        OtpState.SMS1 sms1;
        if (this.PlaceComponentResult && Intrinsics.areEqual(OtpChannel.WHATSAPP, this.getErrorConfigVersion)) {
            int i = this.lookAheadTest;
            if (i == 1) {
                sms1 = OtpState.WA1.INSTANCE;
            } else if (i == 2) {
                sms1 = OtpState.WA2.INSTANCE;
            } else if (i == 3) {
                sms1 = OtpState.WA3.INSTANCE;
            }
            StringBuilder sb = new StringBuilder();
            sb.append("getOtpState ");
            sb.append(this.lookAheadTest);
            sb.append(InputCardNumberView.DIVIDER);
            sb.append(sms1);
            DanaLog.BuiltInFictitiousFunctionClassFactory("OTP", sb.toString());
            return sms1;
        }
        sms1 = OtpState.SMS1.INSTANCE;
        StringBuilder sb2 = new StringBuilder();
        sb2.append("getOtpState ");
        sb2.append(this.lookAheadTest);
        sb2.append(InputCardNumberView.DIVIDER);
        sb2.append(sms1);
        DanaLog.BuiltInFictitiousFunctionClassFactory("OTP", sb2.toString());
        return sms1;
    }

    @Override // id.dana.challenge.otp.AbstractOtpContract.Presenter
    public final void PlaceComponentResult(String p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        SaveIsFreezeVerifyOtp saveIsFreezeVerifyOtp = this.DatabaseTableConfigUtil.get();
        String str = this.moveToNextValue;
        saveIsFreezeVerifyOtp.execute(new SaveIsFreezeVerifyOtp.Params(str != null ? str : "", true), new Function0<Unit>() { // from class: id.dana.challenge.otp.OtpRegistrationPresenter$saveIsFreezeVerifyOtp$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2() {
                AbstractOtpContract.View view;
                view = OtpRegistrationPresenter.this.NetworkUserEntityData$$ExternalSyntheticLambda8;
                view.MyBillsEntityDataFactory();
            }
        }, new Function1<Throwable, Unit>() { // from class: id.dana.challenge.otp.OtpRegistrationPresenter$saveIsFreezeVerifyOtp$2
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
                AbstractOtpContract.View view;
                Intrinsics.checkNotNullParameter(th, "");
                view = OtpRegistrationPresenter.this.NetworkUserEntityData$$ExternalSyntheticLambda8;
                view.MyBillsEntityDataFactory();
            }
        });
    }

    private void getAuthRequestContext(final String p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        GetNumberOfRequestOtp getNumberOfRequestOtp = this.BuiltInFictitiousFunctionClassFactory;
        String str = this.moveToNextValue;
        BaseUseCase.execute$default(getNumberOfRequestOtp, str == null ? "" : str, new Function1<Integer, Unit>() { // from class: id.dana.challenge.otp.OtpRegistrationPresenter$resendOtp$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final /* synthetic */ Unit invoke(Integer num) {
                invoke(num.intValue());
                return Unit.INSTANCE;
            }

            public final void invoke(int i) {
                ResendOtp resendOtp;
                OtpRegistrationPresenter otpRegistrationPresenter = OtpRegistrationPresenter.this;
                if (i <= 0) {
                    i = 0;
                }
                otpRegistrationPresenter.lookAheadTest = i;
                OtpRegistrationPresenter.this.getErrorConfigVersion = p0;
                resendOtp = OtpRegistrationPresenter.this.NetworkUserEntityData$$ExternalSyntheticLambda1;
                ResendOtp.Params params = new ResendOtp.Params(p0, true);
                final OtpRegistrationPresenter otpRegistrationPresenter2 = OtpRegistrationPresenter.this;
                Function1<CheckRegistrationResponse, Unit> function1 = new Function1<CheckRegistrationResponse, Unit>() { // from class: id.dana.challenge.otp.OtpRegistrationPresenter$resendOtp$1.1
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final /* bridge */ /* synthetic */ Unit invoke(CheckRegistrationResponse checkRegistrationResponse) {
                        invoke2(checkRegistrationResponse);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke  reason: avoid collision after fix types in other method */
                    public final void invoke2(CheckRegistrationResponse checkRegistrationResponse) {
                        AbstractOtpContract.View view;
                        Intrinsics.checkNotNullParameter(checkRegistrationResponse, "");
                        view = OtpRegistrationPresenter.this.NetworkUserEntityData$$ExternalSyntheticLambda8;
                        view.dismissProgress();
                        OtpRegistrationPresenter.MyBillsEntityDataFactory(OtpRegistrationPresenter.this, checkRegistrationResponse);
                    }
                };
                final OtpRegistrationPresenter otpRegistrationPresenter3 = OtpRegistrationPresenter.this;
                resendOtp.execute(params, function1, new Function1<Throwable, Unit>() { // from class: id.dana.challenge.otp.OtpRegistrationPresenter$resendOtp$1.2
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
                        AbstractOtpContract.View view;
                        Intrinsics.checkNotNullParameter(th, "");
                        view = OtpRegistrationPresenter.this.NetworkUserEntityData$$ExternalSyntheticLambda8;
                        view.dismissProgress();
                        OtpRegistrationPresenter.MyBillsEntityDataFactory(OtpRegistrationPresenter.this, th);
                    }
                });
            }
        }, null, 4, null);
    }

    @Override // id.dana.challenge.otp.AbstractOtpContract.Presenter
    public final void KClassImpl$Data$declaredNonStaticMembers$2() {
        BaseUseCase.execute$default(this.NetworkUserEntityData$$ExternalSyntheticLambda0, NoParams.INSTANCE, new Function1<String, Unit>() { // from class: id.dana.challenge.otp.OtpRegistrationPresenter$receiveOtp$1
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
                view = OtpRegistrationPresenter.this.NetworkUserEntityData$$ExternalSyntheticLambda8;
                view.PlaceComponentResult(str);
            }
        }, null, 4, null);
    }

    @Override // id.dana.challenge.otp.AbstractOtpContract.Presenter
    public final void getAuthRequestContext() {
        BaseUseCase.execute$default(this.KClassImpl$Data$declaredNonStaticMembers$2, null, new Function1<Boolean, Unit>() { // from class: id.dana.challenge.otp.OtpRegistrationPresenter$checkIsWhatsAppFeatureEnable$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                invoke2(bool);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(Boolean bool) {
                AbstractOtpContract.View view;
                view = OtpRegistrationPresenter.this.NetworkUserEntityData$$ExternalSyntheticLambda8;
                view.PlaceComponentResult();
            }
        }, null, 4, null);
    }

    @Override // id.dana.challenge.otp.AbstractOtpContract.Presenter
    /* renamed from: PlaceComponentResult  reason: from getter */
    public final int getLookAheadTest() {
        return this.lookAheadTest;
    }

    @Override // id.dana.base.AbstractContractKt.AbstractPresenter, id.dana.base.AbstractContract.AbstractPresenter
    public final void onDestroy() {
        this.NetworkUserEntityData$$ExternalSyntheticLambda7.dispose();
        this.newProxyInstance.dispose();
        this.NetworkUserEntityData$$ExternalSyntheticLambda1.dispose();
        this.NetworkUserEntityData$$ExternalSyntheticLambda0.dispose();
        this.KClassImpl$Data$declaredNonStaticMembers$2.dispose();
        this.GetContactSyncConfig.dispose();
        this.BuiltInFictitiousFunctionClassFactory.dispose();
        this.initRecordTimeStamp.dispose();
        this.DatabaseTableConfigUtil.get().dispose();
    }

    public static final /* synthetic */ void KClassImpl$Data$declaredNonStaticMembers$2(OtpRegistrationPresenter otpRegistrationPresenter, Throwable th) {
        otpRegistrationPresenter.NetworkUserEntityData$$ExternalSyntheticLambda8.dismissProgress();
        if (th instanceof NetworkException) {
            AbstractOtpContract.View view = otpRegistrationPresenter.NetworkUserEntityData$$ExternalSyntheticLambda8;
            NetworkException networkException = (NetworkException) th;
            String errorCode = networkException.getErrorCode();
            String message = th.getMessage();
            Intrinsics.checkNotNullExpressionValue(networkException.getLeftTimes(), "");
            view.PlaceComponentResult(errorCode, message, networkException.getTraceId());
            otpRegistrationPresenter.getAuthRequestContext = networkException.getIdentFailedCount();
        } else {
            otpRegistrationPresenter.NetworkUserEntityData$$ExternalSyntheticLambda8.BuiltInFictitiousFunctionClassFactory(th.getMessage());
        }
        StringBuilder sb = new StringBuilder();
        sb.append("[OtpRegister] input OTP error: ");
        sb.append(th);
        CrashlyticsLogUtil.PlaceComponentResult(DanaLogConstants.TAG.REGISTER_TAG, sb.toString(), th);
    }

    public static final /* synthetic */ void MyBillsEntityDataFactory(OtpRegistrationPresenter otpRegistrationPresenter, Throwable th) {
        if (th instanceof NetworkException) {
            NetworkException networkException = (NetworkException) th;
            if (Intrinsics.areEqual(networkException.getErrorCode(), "AE15112158100310")) {
                String str = otpRegistrationPresenter.moveToNextValue;
                CompletableUseCase.execute$default(otpRegistrationPresenter.initRecordTimeStamp, str == null ? "" : str, null, null, 6, null);
                AbstractOtpContract.View view = otpRegistrationPresenter.NetworkUserEntityData$$ExternalSyntheticLambda8;
                String errorCode = networkException.getErrorCode();
                String message = th.getMessage();
                Intrinsics.checkNotNullExpressionValue(networkException.getLeftTimes(), "");
                view.BuiltInFictitiousFunctionClassFactory(errorCode, message, null, networkException.getTraceId());
            } else {
                AbstractOtpContract.View view2 = otpRegistrationPresenter.NetworkUserEntityData$$ExternalSyntheticLambda8;
                String errorCode2 = networkException.getErrorCode();
                String message2 = th.getMessage();
                Intrinsics.checkNotNullExpressionValue(networkException.getLeftTimes(), "");
                view2.BuiltInFictitiousFunctionClassFactory(errorCode2, message2, null, networkException.getTraceId());
            }
        } else {
            otpRegistrationPresenter.NetworkUserEntityData$$ExternalSyntheticLambda8.onError(th.getMessage());
        }
        StringBuilder sb = new StringBuilder();
        sb.append("[OtpRegister] send OTP error: ");
        sb.append(th);
        CrashlyticsLogUtil.PlaceComponentResult(DanaLogConstants.TAG.REGISTER_TAG, sb.toString(), th);
    }

    public static final /* synthetic */ void MyBillsEntityDataFactory(OtpRegistrationPresenter otpRegistrationPresenter, CheckRegistrationResponse checkRegistrationResponse) {
        if (checkRegistrationResponse.isSuccess()) {
            otpRegistrationPresenter.scheduleImpl = false;
            AbstractOtpContract.View view = otpRegistrationPresenter.NetworkUserEntityData$$ExternalSyntheticLambda8;
            checkRegistrationResponse.getExpirySeconds();
            view.MyBillsEntityDataFactory(checkRegistrationResponse.getRetrySendSeconds(), checkRegistrationResponse.getOtpCodeLength());
            int i = otpRegistrationPresenter.lookAheadTest + 1;
            otpRegistrationPresenter.lookAheadTest = i;
            String str = otpRegistrationPresenter.moveToNextValue;
            if (str == null) {
                str = "";
            }
            if (otpRegistrationPresenter.PlaceComponentResult) {
                CompletableUseCase.execute$default(otpRegistrationPresenter.GetContactSyncConfig, new SaveNumberOfRequestOtp.Params(str, i), null, null, 6, null);
                return;
            }
            return;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("[OtpRegister] send OTP: errorCode = ");
        sb.append(checkRegistrationResponse.getErrorCode());
        sb.append(", errorMessage = ");
        sb.append(checkRegistrationResponse.getErrorMessage());
        CrashlyticsLogUtil.BuiltInFictitiousFunctionClassFactory(DanaLogConstants.TAG.REGISTER_TAG, sb.toString());
    }
}
