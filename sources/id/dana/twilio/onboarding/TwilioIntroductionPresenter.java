package id.dana.twilio.onboarding;

import android.content.Context;
import id.dana.analytics.tracker.TrackerKey;
import id.dana.domain.DefaultObserver;
import id.dana.domain.twilio.interactor.CheckTwilioEnrollmentStatus;
import id.dana.domain.twilio.interactor.CreateTwilioFactor;
import id.dana.domain.twilio.interactor.DeleteTwilioLocalFactor;
import id.dana.domain.twilio.interactor.TwilioBindEnrollment;
import id.dana.domain.twilio.interactor.TwilioConsultEnrollment;
import id.dana.domain.twilio.interactor.TwilioEnrollment;
import id.dana.domain.twilio.interactor.VerifyTwilioFactor;
import id.dana.domain.twilio.model.BindEnrollInfo;
import id.dana.domain.twilio.model.EnrollInfo;
import id.dana.domain.twilio.model.TwilioInfo;
import id.dana.tracker.EventTracker;
import id.dana.tracker.EventTrackerModel;
import id.dana.twilio.onboarding.TwilioIntroductionContract;
import id.dana.twilio.onboarding.mapper.TwilioModelMapperKt;
import id.dana.twilio.onboarding.model.request.TwilioBindEnrollModel;
import id.dana.twilio.onboarding.model.request.TwilioConsultModel;
import id.dana.twilio.onboarding.model.request.TwilioEnrollModel;
import id.dana.utils.foundation.logger.log.DanaLog;
import id.dana.utils.foundation.logger.log.DanaLogConstants;
import java.util.List;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u0000 62\u00020\u0001:\u00016BQ\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0017\u0012\u0006\u0010\u0004\u001a\u00020+\u0012\u0006\u0010\u0005\u001a\u00020#\u0012\u0006\u0010.\u001a\u00020\u0015\u0012\u0006\u0010/\u001a\u00020'\u0012\u0006\u00100\u001a\u00020\u0019\u0012\u0006\u00101\u001a\u00020)\u0012\u0006\u00102\u001a\u00020\u001b\u0012\u0006\u00103\u001a\u00020\u001f¢\u0006\u0004\b4\u00105J%\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0007\u0010\tJ\u000f\u0010\u0007\u001a\u00020\nH\u0002¢\u0006\u0004\b\u0007\u0010\u000bJ\u0015\u0010\f\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\f\u0010\rJ\u0017\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0003\u001a\u00020\nH\u0002¢\u0006\u0004\b\u000f\u0010\u0010J\u000f\u0010\u0011\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u0011\u0010\u0012J'\u0010\u0013\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0013\u0010\bJ\u001f\u0010\f\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\f\u0010\u0014R\u0014\u0010\f\u001a\u00020\u00158\u0002X\u0083\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\u0016R\u0014\u0010\u000f\u001a\u00020\u00178\u0002X\u0083\u0004¢\u0006\u0006\n\u0004\b\u0013\u0010\u0018R\u0014\u0010\u0013\u001a\u00020\u00198\u0002X\u0083\u0004¢\u0006\u0006\n\u0004\b\f\u0010\u001aR\u0014\u0010\u001c\u001a\u00020\u001b8\u0002X\u0083\u0004¢\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\u0016\u0010\u0007\u001a\u00020\n8\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\b\u000f\u0010\u001eR\u0014\u0010\"\u001a\u00020\u001f8\u0002X\u0083\u0004¢\u0006\u0006\n\u0004\b \u0010!R\u0014\u0010&\u001a\u00020#8\u0002X\u0083\u0004¢\u0006\u0006\n\u0004\b$\u0010%R\u0014\u0010$\u001a\u00020'8\u0002X\u0083\u0004¢\u0006\u0006\n\u0004\b&\u0010(R\u0014\u0010 \u001a\u00020)8\u0002X\u0083\u0004¢\u0006\u0006\n\u0004\b\"\u0010*R\u0014\u0010,\u001a\u00020+8\u0002X\u0083\u0004¢\u0006\u0006\n\u0004\b,\u0010-"}, d2 = {"Lid/dana/twilio/onboarding/TwilioIntroductionPresenter;", "Lid/dana/twilio/onboarding/TwilioIntroductionContract$Presenter;", "", "p0", "p1", "p2", "", "BuiltInFictitiousFunctionClassFactory", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "(Ljava/lang/String;)V", "", "()J", "MyBillsEntityDataFactory", "(Ljava/lang/String;)Ljava/lang/String;", "", "getAuthRequestContext", "(J)Z", "onDestroy", "()V", "PlaceComponentResult", "(Ljava/lang/String;Ljava/lang/String;)V", "Lid/dana/domain/twilio/interactor/CheckTwilioEnrollmentStatus;", "Lid/dana/domain/twilio/interactor/CheckTwilioEnrollmentStatus;", "Landroid/content/Context;", "Landroid/content/Context;", "Lid/dana/domain/twilio/interactor/CreateTwilioFactor;", "Lid/dana/domain/twilio/interactor/CreateTwilioFactor;", "Lid/dana/domain/twilio/interactor/DeleteTwilioLocalFactor;", "KClassImpl$Data$declaredNonStaticMembers$2", "Lid/dana/domain/twilio/interactor/DeleteTwilioLocalFactor;", "J", "Lid/dana/domain/twilio/interactor/TwilioBindEnrollment;", "lookAheadTest", "Lid/dana/domain/twilio/interactor/TwilioBindEnrollment;", "moveToNextValue", "Lid/dana/domain/twilio/interactor/TwilioConsultEnrollment;", "getErrorConfigVersion", "Lid/dana/domain/twilio/interactor/TwilioConsultEnrollment;", "NetworkUserEntityData$$ExternalSyntheticLambda0", "Lid/dana/domain/twilio/interactor/TwilioEnrollment;", "Lid/dana/domain/twilio/interactor/TwilioEnrollment;", "Lid/dana/domain/twilio/interactor/VerifyTwilioFactor;", "Lid/dana/domain/twilio/interactor/VerifyTwilioFactor;", "Lid/dana/twilio/onboarding/TwilioIntroductionContract$View;", "scheduleImpl", "Lid/dana/twilio/onboarding/TwilioIntroductionContract$View;", "p3", "p4", "p5", "p6", "p7", "p8", "<init>", "(Landroid/content/Context;Lid/dana/twilio/onboarding/TwilioIntroductionContract$View;Lid/dana/domain/twilio/interactor/TwilioConsultEnrollment;Lid/dana/domain/twilio/interactor/CheckTwilioEnrollmentStatus;Lid/dana/domain/twilio/interactor/TwilioEnrollment;Lid/dana/domain/twilio/interactor/CreateTwilioFactor;Lid/dana/domain/twilio/interactor/VerifyTwilioFactor;Lid/dana/domain/twilio/interactor/DeleteTwilioLocalFactor;Lid/dana/domain/twilio/interactor/TwilioBindEnrollment;)V", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class TwilioIntroductionPresenter implements TwilioIntroductionContract.Presenter {

    /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
    final CheckTwilioEnrollmentStatus MyBillsEntityDataFactory;
    final DeleteTwilioLocalFactor KClassImpl$Data$declaredNonStaticMembers$2;

    /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
    final CreateTwilioFactor PlaceComponentResult;

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda0  reason: from kotlin metadata */
    private final TwilioEnrollment getErrorConfigVersion;

    /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
    final Context getAuthRequestContext;

    /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
    long BuiltInFictitiousFunctionClassFactory;

    /* renamed from: getErrorConfigVersion  reason: from kotlin metadata */
    private final TwilioConsultEnrollment NetworkUserEntityData$$ExternalSyntheticLambda0;

    /* renamed from: lookAheadTest  reason: from kotlin metadata */
    private final TwilioBindEnrollment moveToNextValue;

    /* renamed from: moveToNextValue  reason: from kotlin metadata */
    final VerifyTwilioFactor lookAheadTest;
    final TwilioIntroductionContract.View scheduleImpl;

    @Inject
    public TwilioIntroductionPresenter(Context context, TwilioIntroductionContract.View view, TwilioConsultEnrollment twilioConsultEnrollment, CheckTwilioEnrollmentStatus checkTwilioEnrollmentStatus, TwilioEnrollment twilioEnrollment, CreateTwilioFactor createTwilioFactor, VerifyTwilioFactor verifyTwilioFactor, DeleteTwilioLocalFactor deleteTwilioLocalFactor, TwilioBindEnrollment twilioBindEnrollment) {
        Intrinsics.checkNotNullParameter(context, "");
        Intrinsics.checkNotNullParameter(view, "");
        Intrinsics.checkNotNullParameter(twilioConsultEnrollment, "");
        Intrinsics.checkNotNullParameter(checkTwilioEnrollmentStatus, "");
        Intrinsics.checkNotNullParameter(twilioEnrollment, "");
        Intrinsics.checkNotNullParameter(createTwilioFactor, "");
        Intrinsics.checkNotNullParameter(verifyTwilioFactor, "");
        Intrinsics.checkNotNullParameter(deleteTwilioLocalFactor, "");
        Intrinsics.checkNotNullParameter(twilioBindEnrollment, "");
        this.getAuthRequestContext = context;
        this.scheduleImpl = view;
        this.NetworkUserEntityData$$ExternalSyntheticLambda0 = twilioConsultEnrollment;
        this.MyBillsEntityDataFactory = checkTwilioEnrollmentStatus;
        this.getErrorConfigVersion = twilioEnrollment;
        this.PlaceComponentResult = createTwilioFactor;
        this.lookAheadTest = verifyTwilioFactor;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = deleteTwilioLocalFactor;
        this.moveToNextValue = twilioBindEnrollment;
    }

    public final void BuiltInFictitiousFunctionClassFactory(final String p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        this.NetworkUserEntityData$$ExternalSyntheticLambda0.execute(new TwilioConsultEnrollment.Params(TwilioModelMapperKt.getAuthRequestContext(new TwilioConsultModel(p0))), new Function1<TwilioInfo, Unit>() { // from class: id.dana.twilio.onboarding.TwilioIntroductionPresenter$consultEnrollmentTwilio$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final /* bridge */ /* synthetic */ Unit invoke(TwilioInfo twilioInfo) {
                invoke2(twilioInfo);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(TwilioInfo twilioInfo) {
                TwilioIntroductionContract.View view;
                TwilioIntroductionContract.View view2;
                TwilioIntroductionContract.View view3;
                Intrinsics.checkNotNullParameter(twilioInfo, "");
                if (twilioInfo.getVerificationMethodInfos() != null ? !r1.isEmpty() : false) {
                    view3 = TwilioIntroductionPresenter.this.scheduleImpl;
                    String securityId = twilioInfo.getSecurityId();
                    if (securityId == null) {
                        securityId = "";
                    }
                    String str = p0;
                    List<String> verificationMethodInfos = twilioInfo.getVerificationMethodInfos();
                    String str2 = verificationMethodInfos != null ? (String) CollectionsKt.first((List) verificationMethodInfos) : null;
                    view3.BuiltInFictitiousFunctionClassFactory(securityId, str, str2 != null ? str2 : "");
                } else if (!twilioInfo.getRegistered() && twilioInfo.getRegisterAllowed()) {
                    view2 = TwilioIntroductionPresenter.this.scheduleImpl;
                    String securityId2 = twilioInfo.getSecurityId();
                    view2.getAuthRequestContext(securityId2 != null ? securityId2 : "", p0);
                } else if (twilioInfo.getRegistered() && twilioInfo.getRegisterAllowed()) {
                    final TwilioIntroductionPresenter twilioIntroductionPresenter = TwilioIntroductionPresenter.this;
                    final String securityId3 = twilioInfo.getSecurityId();
                    if (securityId3 == null) {
                        securityId3 = "";
                    }
                    final String str3 = p0;
                    Intrinsics.checkNotNullParameter(securityId3, "");
                    Intrinsics.checkNotNullParameter(str3, "");
                    twilioIntroductionPresenter.MyBillsEntityDataFactory.execute(new DefaultObserver<Boolean>() { // from class: id.dana.twilio.onboarding.TwilioIntroductionPresenter$consultEnrollmentStatus$1
                        @Override // id.dana.domain.DefaultObserver, io.reactivex.Observer
                        public final /* synthetic */ void onNext(Object obj) {
                            TwilioIntroductionContract.View view4;
                            TwilioIntroductionContract.View view5;
                            if (!((Boolean) obj).booleanValue()) {
                                view5 = TwilioIntroductionPresenter.this.scheduleImpl;
                                view5.getAuthRequestContext(securityId3, str3);
                                return;
                            }
                            view4 = TwilioIntroductionPresenter.this.scheduleImpl;
                            view4.getAuthRequestContext();
                        }
                    });
                } else {
                    TwilioIntroductionPresenter.PlaceComponentResult(TwilioIntroductionPresenter.this, twilioInfo.getRegisterAllowed(), p0);
                    view = TwilioIntroductionPresenter.this.scheduleImpl;
                    view.getAuthRequestContext();
                }
            }
        }, new Function1<Throwable, Unit>() { // from class: id.dana.twilio.onboarding.TwilioIntroductionPresenter$consultEnrollmentTwilio$2
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
                TwilioIntroductionContract.View view;
                Intrinsics.checkNotNullParameter(th, "");
                view = TwilioIntroductionPresenter.this.scheduleImpl;
                view.onError("");
                DanaLog.BuiltInFictitiousFunctionClassFactory(DanaLogConstants.TAG.TWILIO_CONSULT, th.getMessage(), th);
            }
        });
    }

    public final void PlaceComponentResult(String p0, final String p1, final String p2) {
        Intrinsics.checkNotNullParameter(p0, "");
        Intrinsics.checkNotNullParameter(p1, "");
        Intrinsics.checkNotNullParameter(p2, "");
        this.getErrorConfigVersion.execute(new TwilioEnrollment.Params(TwilioModelMapperKt.PlaceComponentResult(new TwilioEnrollModel(p0, p1))), new Function1<EnrollInfo, Unit>() { // from class: id.dana.twilio.onboarding.TwilioIntroductionPresenter$submitEnroll$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final /* bridge */ /* synthetic */ Unit invoke(EnrollInfo enrollInfo) {
                invoke2(enrollInfo);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(EnrollInfo enrollInfo) {
                TwilioIntroductionContract.View view;
                Intrinsics.checkNotNullParameter(enrollInfo, "");
                if (!(enrollInfo.getAccessToken().length() > 0)) {
                    view = TwilioIntroductionPresenter.this.scheduleImpl;
                    view.getAuthRequestContext();
                    return;
                }
                final TwilioIntroductionPresenter twilioIntroductionPresenter = TwilioIntroductionPresenter.this;
                String serviceSid = enrollInfo.getServiceSid();
                if (serviceSid == null) {
                    serviceSid = "";
                }
                String identity = enrollInfo.getIdentity();
                if (identity == null) {
                    identity = "";
                }
                String str = p2;
                String accessToken = enrollInfo.getAccessToken();
                final String str2 = p1;
                Intrinsics.checkNotNullParameter(serviceSid, "");
                Intrinsics.checkNotNullParameter(identity, "");
                Intrinsics.checkNotNullParameter(str, "");
                Intrinsics.checkNotNullParameter(accessToken, "");
                Intrinsics.checkNotNullParameter(str2, "");
                twilioIntroductionPresenter.PlaceComponentResult.execute(new DefaultObserver<String>() { // from class: id.dana.twilio.onboarding.TwilioIntroductionPresenter$createFactor$1
                    @Override // id.dana.domain.DefaultObserver, io.reactivex.Observer
                    public final /* synthetic */ void onNext(Object obj) {
                        TwilioIntroductionContract.View view2;
                        String str3 = (String) obj;
                        Intrinsics.checkNotNullParameter(str3, "");
                        if (str3.length() > 0) {
                            final TwilioIntroductionPresenter twilioIntroductionPresenter2 = TwilioIntroductionPresenter.this;
                            final String str4 = str2;
                            Intrinsics.checkNotNullParameter(str3, "");
                            Intrinsics.checkNotNullParameter(str4, "");
                            twilioIntroductionPresenter2.lookAheadTest.execute(new DefaultObserver<List<? extends String>>() { // from class: id.dana.twilio.onboarding.TwilioIntroductionPresenter$verifyFactor$1
                                @Override // id.dana.domain.DefaultObserver, io.reactivex.Observer
                                public final /* synthetic */ void onNext(Object obj2) {
                                    TwilioIntroductionContract.View view3;
                                    long currentTimeMillis;
                                    List list = (List) obj2;
                                    Intrinsics.checkNotNullParameter(list, "");
                                    if ((!list.isEmpty()) == false) {
                                        view3 = TwilioIntroductionPresenter.this.scheduleImpl;
                                        view3.getAuthRequestContext();
                                        return;
                                    }
                                    TwilioIntroductionPresenter twilioIntroductionPresenter3 = TwilioIntroductionPresenter.this;
                                    currentTimeMillis = System.currentTimeMillis();
                                    twilioIntroductionPresenter3.BuiltInFictitiousFunctionClassFactory = currentTimeMillis;
                                    TwilioIntroductionPresenter.this.BuiltInFictitiousFunctionClassFactory((String) CollectionsKt.first(list), (String) CollectionsKt.last(list), str4);
                                }

                                @Override // id.dana.domain.DefaultObserver, io.reactivex.Observer
                                public final void onError(Throwable p02) {
                                    TwilioIntroductionContract.View view3;
                                    Intrinsics.checkNotNullParameter(p02, "");
                                    view3 = TwilioIntroductionPresenter.this.scheduleImpl;
                                    view3.onError("");
                                    DanaLog.BuiltInFictitiousFunctionClassFactory(DanaLogConstants.TAG.TWILIO_CONSULT, p02.getMessage(), p02);
                                }
                            }, str3);
                            return;
                        }
                        TwilioIntroductionPresenter.this.MyBillsEntityDataFactory("Create Factor error", str2);
                        view2 = TwilioIntroductionPresenter.this.scheduleImpl;
                        view2.getAuthRequestContext();
                    }

                    @Override // id.dana.domain.DefaultObserver, io.reactivex.Observer
                    public final void onError(Throwable p02) {
                        TwilioIntroductionContract.View view2;
                        Intrinsics.checkNotNullParameter(p02, "");
                        TwilioIntroductionPresenter.this.MyBillsEntityDataFactory("Create Factor error", str2);
                        view2 = TwilioIntroductionPresenter.this.scheduleImpl;
                        view2.onError("");
                        DanaLog.BuiltInFictitiousFunctionClassFactory(DanaLogConstants.TAG.TWILIO_CONSULT, p02.getMessage(), p02);
                    }
                }, new CreateTwilioFactor.Params(serviceSid, identity, str, accessToken));
            }
        }, new Function1<Throwable, Unit>() { // from class: id.dana.twilio.onboarding.TwilioIntroductionPresenter$submitEnroll$2
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
                TwilioIntroductionContract.View view;
                Intrinsics.checkNotNullParameter(th, "");
                view = TwilioIntroductionPresenter.this.scheduleImpl;
                view.onError("");
                DanaLog.BuiltInFictitiousFunctionClassFactory(DanaLogConstants.TAG.TWILIO_CONSULT, th.getMessage(), th);
            }
        });
    }

    public final void BuiltInFictitiousFunctionClassFactory(final String p0, final String p1, final String p2) {
        Intrinsics.checkNotNullParameter(p0, "");
        Intrinsics.checkNotNullParameter(p1, "");
        Intrinsics.checkNotNullParameter(p2, "");
        this.moveToNextValue.execute(new DefaultObserver<BindEnrollInfo>() { // from class: id.dana.twilio.onboarding.TwilioIntroductionPresenter$bindEnroll$1
            @Override // id.dana.domain.DefaultObserver, io.reactivex.Observer
            public final /* synthetic */ void onNext(Object obj) {
                TwilioIntroductionContract.View view;
                BindEnrollInfo bindEnrollInfo = (BindEnrollInfo) obj;
                Intrinsics.checkNotNullParameter(bindEnrollInfo, "");
                String status = bindEnrollInfo.getStatus();
                if (!Intrinsics.areEqual(status, "BOUND")) {
                    if (!Intrinsics.areEqual(status, "INIT")) {
                        TwilioIntroductionPresenter.this.MyBillsEntityDataFactory("Bind enrollment error", p2);
                        view = TwilioIntroductionPresenter.this.scheduleImpl;
                        view.getAuthRequestContext();
                        TwilioIntroductionPresenter.this.KClassImpl$Data$declaredNonStaticMembers$2.execute(new DefaultObserver<Boolean>() { // from class: id.dana.twilio.onboarding.TwilioIntroductionPresenter$deleteFactor$1
                            @Override // id.dana.domain.DefaultObserver, io.reactivex.Observer
                            public final /* bridge */ /* synthetic */ void onNext(Object obj2) {
                                Boolean bool = (Boolean) obj2;
                            }
                        });
                        return;
                    }
                    TwilioIntroductionPresenter twilioIntroductionPresenter = TwilioIntroductionPresenter.this;
                    String str = p0;
                    String str2 = p1;
                    String str3 = p2;
                    Intrinsics.checkNotNullParameter(str, "");
                    Intrinsics.checkNotNullParameter(str2, "");
                    Intrinsics.checkNotNullParameter(str3, "");
                    if (TwilioIntroductionPresenter.getAuthRequestContext(twilioIntroductionPresenter.BuiltInFictitiousFunctionClassFactory)) {
                        twilioIntroductionPresenter.BuiltInFictitiousFunctionClassFactory(str, str2, str3);
                    } else {
                        twilioIntroductionPresenter.scheduleImpl.getAuthRequestContext();
                        twilioIntroductionPresenter.KClassImpl$Data$declaredNonStaticMembers$2.execute(new DefaultObserver<Boolean>() { // from class: id.dana.twilio.onboarding.TwilioIntroductionPresenter$deleteFactor$1
                            @Override // id.dana.domain.DefaultObserver, io.reactivex.Observer
                            public final /* bridge */ /* synthetic */ void onNext(Object obj2) {
                                Boolean bool = (Boolean) obj2;
                            }
                        });
                    }
                    twilioIntroductionPresenter.BuiltInFictitiousFunctionClassFactory = TwilioIntroductionPresenter.BuiltInFictitiousFunctionClassFactory();
                    return;
                }
                TwilioIntroductionPresenter twilioIntroductionPresenter2 = TwilioIntroductionPresenter.this;
                String str4 = p2;
                Intrinsics.checkNotNullParameter(str4, "");
                Intrinsics.checkNotNullParameter(str4, "");
                EventTrackerModel.Builder builder = new EventTrackerModel.Builder(twilioIntroductionPresenter2.getAuthRequestContext);
                builder.MyBillsEntityDataFactory = TrackerKey.Event.TWILIO_PUSH_ENROLL;
                EventTrackerModel.Builder BuiltInFictitiousFunctionClassFactory = builder.MyBillsEntityDataFactory("Source", TwilioIntroductionPresenter.MyBillsEntityDataFactory(str4)).BuiltInFictitiousFunctionClassFactory(TrackerKey.Property.IS_SUCCESS, true);
                BuiltInFictitiousFunctionClassFactory.PlaceComponentResult();
                EventTracker.PlaceComponentResult(new EventTrackerModel(BuiltInFictitiousFunctionClassFactory, (byte) 0));
                twilioIntroductionPresenter2.scheduleImpl.KClassImpl$Data$declaredNonStaticMembers$2();
            }

            @Override // id.dana.domain.DefaultObserver, io.reactivex.Observer
            public final void onError(Throwable p02) {
                TwilioIntroductionContract.View view;
                Intrinsics.checkNotNullParameter(p02, "");
                TwilioIntroductionPresenter.this.MyBillsEntityDataFactory("Bind enrollment error", p2);
                view = TwilioIntroductionPresenter.this.scheduleImpl;
                view.onError("");
                DanaLog.BuiltInFictitiousFunctionClassFactory(DanaLogConstants.TAG.TWILIO_CONSULT, p02.getMessage(), p02);
            }
        }, new TwilioBindEnrollment.Params(TwilioModelMapperKt.BuiltInFictitiousFunctionClassFactory(new TwilioBindEnrollModel(p0, p1))));
    }

    public final void MyBillsEntityDataFactory(String p0, String p1) {
        Intrinsics.checkNotNullParameter(p0, "");
        Intrinsics.checkNotNullParameter(p1, "");
        EventTrackerModel.Builder builder = new EventTrackerModel.Builder(this.getAuthRequestContext);
        builder.MyBillsEntityDataFactory = TrackerKey.Event.TWILIO_PUSH_ENROLL;
        Intrinsics.checkNotNullParameter(p1, "");
        EventTrackerModel.Builder MyBillsEntityDataFactory = builder.MyBillsEntityDataFactory("Source", Intrinsics.areEqual(p1, TwilioIntroductionActivity.HOME_PAGE) ? "Home" : "Setting").BuiltInFictitiousFunctionClassFactory(TrackerKey.Property.IS_SUCCESS, false).MyBillsEntityDataFactory("Fail Reason", p0);
        MyBillsEntityDataFactory.PlaceComponentResult();
        EventTracker.PlaceComponentResult(new EventTrackerModel(MyBillsEntityDataFactory, (byte) 0));
    }

    public static String MyBillsEntityDataFactory(String p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        return Intrinsics.areEqual(p0, TwilioIntroductionActivity.HOME_PAGE) ? "Home" : "Setting";
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static long BuiltInFictitiousFunctionClassFactory() {
        return System.currentTimeMillis();
    }

    @Override // id.dana.base.AbstractContractKt.AbstractPresenter, id.dana.base.AbstractContract.AbstractPresenter
    public final void onDestroy() {
        this.NetworkUserEntityData$$ExternalSyntheticLambda0.dispose();
        this.MyBillsEntityDataFactory.dispose();
        this.getErrorConfigVersion.dispose();
        this.PlaceComponentResult.dispose();
        this.lookAheadTest.dispose();
        this.moveToNextValue.dispose();
        this.KClassImpl$Data$declaredNonStaticMembers$2.dispose();
    }

    public static final /* synthetic */ void PlaceComponentResult(TwilioIntroductionPresenter twilioIntroductionPresenter, boolean z, String str) {
        if (z) {
            return;
        }
        twilioIntroductionPresenter.MyBillsEntityDataFactory("register not allowed", str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean getAuthRequestContext(long p0) {
        return System.currentTimeMillis() - p0 < 3000;
    }
}
