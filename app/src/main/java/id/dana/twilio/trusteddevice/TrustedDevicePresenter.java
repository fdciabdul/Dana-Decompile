package id.dana.twilio.trusteddevice;

import id.dana.domain.core.usecase.NoParams;
import id.dana.domain.featureconfig.interactor.GetTwilioManualCheckConfig;
import id.dana.domain.twilio.interactor.CheckPendingChallenge;
import id.dana.domain.twilio.interactor.DeleteTwilioLocalFactor;
import id.dana.domain.twilio.interactor.SubmitTwilioDeroll;
import id.dana.domain.twilio.model.DerollInfo;
import id.dana.domain.user.UserInfoResponse;
import id.dana.domain.user.interactor.GetUserInfo;
import id.dana.twilio.identityverification.TwilioIdentityVerificationActivity;
import id.dana.twilio.onboarding.mapper.TwilioModelMapperKt;
import id.dana.twilio.onboarding.model.request.TwilioDerollModel;
import id.dana.twilio.trusteddevice.TrustedDeviceContract;
import id.dana.utils.foundation.logger.log.DanaLog;
import id.dana.utils.foundation.logger.log.DanaLogConstants;
import java.util.List;
import java.util.Map;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u0000 #2\u00020\u0001:\u0001#B9\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0019\u0012\u0006\u0010\u001c\u001a\u00020\u0013\u0012\u0006\u0010\u001d\u001a\u00020\u0010\u0012\u0006\u0010\u001e\u001a\u00020\u0016\u0012\u0006\u0010\u001f\u001a\u00020\u000e\u0012\u0006\u0010 \u001a\u00020\f¢\u0006\u0004\b!\u0010\"J\u0019\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\u0007\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\t\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\t\u0010\bJ\u000f\u0010\n\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\n\u0010\bJ\u000f\u0010\u000b\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u000b\u0010\bJ\u000f\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0005\u0010\bR\u0014\u0010\u0007\u001a\u00020\f8\u0002X\u0083\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\rR\u0014\u0010\n\u001a\u00020\u000e8\u0002X\u0083\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\u000fR\u0014\u0010\u0005\u001a\u00020\u00108\u0002X\u0083\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0014\u0010\t\u001a\u00020\u00138\u0002X\u0083\u0004¢\u0006\u0006\n\u0004\b\n\u0010\u0014R\u0018\u0010\u0011\u001a\u0006*\u00020\u00020\u00028\u0002X\u0083\u0004¢\u0006\u0006\n\u0004\b\t\u0010\u0015R\u0014\u0010\u0017\u001a\u00020\u00168\u0002X\u0083\u0004¢\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u0014\u0010\u001a\u001a\u00020\u00198\u0002X\u0083\u0004¢\u0006\u0006\n\u0004\b\u001a\u0010\u001b"}, d2 = {"Lid/dana/twilio/trusteddevice/TrustedDevicePresenter;", "Lid/dana/twilio/trusteddevice/TrustedDeviceContract$Presenter;", "", "p0", "", "MyBillsEntityDataFactory", "(Ljava/lang/String;)V", "getAuthRequestContext", "()V", "KClassImpl$Data$declaredNonStaticMembers$2", "PlaceComponentResult", "onDestroy", "Lid/dana/domain/twilio/interactor/CheckPendingChallenge;", "Lid/dana/domain/twilio/interactor/CheckPendingChallenge;", "Lid/dana/domain/twilio/interactor/DeleteTwilioLocalFactor;", "Lid/dana/domain/twilio/interactor/DeleteTwilioLocalFactor;", "Lid/dana/domain/featureconfig/interactor/GetTwilioManualCheckConfig;", "BuiltInFictitiousFunctionClassFactory", "Lid/dana/domain/featureconfig/interactor/GetTwilioManualCheckConfig;", "Lid/dana/domain/user/interactor/GetUserInfo;", "Lid/dana/domain/user/interactor/GetUserInfo;", "Ljava/lang/String;", "Lid/dana/domain/twilio/interactor/SubmitTwilioDeroll;", "NetworkUserEntityData$$ExternalSyntheticLambda0", "Lid/dana/domain/twilio/interactor/SubmitTwilioDeroll;", "Lid/dana/twilio/trusteddevice/TrustedDeviceContract$View;", "moveToNextValue", "Lid/dana/twilio/trusteddevice/TrustedDeviceContract$View;", "p1", "p2", "p3", "p4", "p5", "<init>", "(Lid/dana/twilio/trusteddevice/TrustedDeviceContract$View;Lid/dana/domain/user/interactor/GetUserInfo;Lid/dana/domain/featureconfig/interactor/GetTwilioManualCheckConfig;Lid/dana/domain/twilio/interactor/SubmitTwilioDeroll;Lid/dana/domain/twilio/interactor/DeleteTwilioLocalFactor;Lid/dana/domain/twilio/interactor/CheckPendingChallenge;)V", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class TrustedDevicePresenter implements TrustedDeviceContract.Presenter {

    /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
    private final GetTwilioManualCheckConfig MyBillsEntityDataFactory;

    /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
    private final String BuiltInFictitiousFunctionClassFactory;

    /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
    private final DeleteTwilioLocalFactor PlaceComponentResult;
    private final SubmitTwilioDeroll NetworkUserEntityData$$ExternalSyntheticLambda0;

    /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
    private final GetUserInfo KClassImpl$Data$declaredNonStaticMembers$2;
    private final CheckPendingChallenge getAuthRequestContext;
    private final TrustedDeviceContract.View moveToNextValue;

    @Inject
    public TrustedDevicePresenter(TrustedDeviceContract.View view, GetUserInfo getUserInfo, GetTwilioManualCheckConfig getTwilioManualCheckConfig, SubmitTwilioDeroll submitTwilioDeroll, DeleteTwilioLocalFactor deleteTwilioLocalFactor, CheckPendingChallenge checkPendingChallenge) {
        Intrinsics.checkNotNullParameter(view, "");
        Intrinsics.checkNotNullParameter(getUserInfo, "");
        Intrinsics.checkNotNullParameter(getTwilioManualCheckConfig, "");
        Intrinsics.checkNotNullParameter(submitTwilioDeroll, "");
        Intrinsics.checkNotNullParameter(deleteTwilioLocalFactor, "");
        Intrinsics.checkNotNullParameter(checkPendingChallenge, "");
        this.moveToNextValue = view;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = getUserInfo;
        this.MyBillsEntityDataFactory = getTwilioManualCheckConfig;
        this.NetworkUserEntityData$$ExternalSyntheticLambda0 = submitTwilioDeroll;
        this.PlaceComponentResult = deleteTwilioLocalFactor;
        this.getAuthRequestContext = checkPendingChallenge;
        this.BuiltInFictitiousFunctionClassFactory = "TrustedDevicePresenter";
    }

    @Override // id.dana.twilio.trusteddevice.TrustedDeviceContract.Presenter
    public final void KClassImpl$Data$declaredNonStaticMembers$2() {
        this.KClassImpl$Data$declaredNonStaticMembers$2.execute(new GetUserInfo.Param(false), new Function1<UserInfoResponse, Unit>() { // from class: id.dana.twilio.trusteddevice.TrustedDevicePresenter$getKycStatus$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final /* bridge */ /* synthetic */ Unit invoke(UserInfoResponse userInfoResponse) {
                invoke2(userInfoResponse);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(UserInfoResponse userInfoResponse) {
                Intrinsics.checkNotNullParameter(userInfoResponse, "");
                TrustedDevicePresenter.getAuthRequestContext(TrustedDevicePresenter.this, userInfoResponse);
            }
        }, new Function1<Throwable, Unit>() { // from class: id.dana.twilio.trusteddevice.TrustedDevicePresenter$getKycStatus$2
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
                TrustedDeviceContract.View view;
                Intrinsics.checkNotNullParameter(th, "");
                DanaLog.BuiltInFictitiousFunctionClassFactory(DanaLogConstants.ExceptionType.GET_USER_INFO_EXCEPTION, th.getMessage());
                view = TrustedDevicePresenter.this.moveToNextValue;
                view.BuiltInFictitiousFunctionClassFactory();
            }
        });
    }

    @Override // id.dana.twilio.trusteddevice.TrustedDeviceContract.Presenter
    public final void PlaceComponentResult() {
        this.MyBillsEntityDataFactory.execute(NoParams.INSTANCE, new Function1<Boolean, Unit>() { // from class: id.dana.twilio.trusteddevice.TrustedDevicePresenter$getTwilioManualCheckConfig$1
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
                TrustedDeviceContract.View view;
                view = TrustedDevicePresenter.this.moveToNextValue;
                view.MyBillsEntityDataFactory(z);
            }
        }, new Function1<Throwable, Unit>() { // from class: id.dana.twilio.trusteddevice.TrustedDevicePresenter$getTwilioManualCheckConfig$2
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
                String str;
                Intrinsics.checkNotNullParameter(th, "");
                str = TrustedDevicePresenter.this.BuiltInFictitiousFunctionClassFactory;
                DanaLog.BuiltInFictitiousFunctionClassFactory(str, th.getMessage());
            }
        });
    }

    @Override // id.dana.twilio.trusteddevice.TrustedDeviceContract.Presenter
    public final void MyBillsEntityDataFactory(String p0) {
        this.NetworkUserEntityData$$ExternalSyntheticLambda0.execute(new SubmitTwilioDeroll.Params(TwilioModelMapperKt.getAuthRequestContext(new TwilioDerollModel(p0))), new Function1<DerollInfo, Unit>() { // from class: id.dana.twilio.trusteddevice.TrustedDevicePresenter$derollVerifyPush$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final /* bridge */ /* synthetic */ Unit invoke(DerollInfo derollInfo) {
                invoke2(derollInfo);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(DerollInfo derollInfo) {
                TrustedDeviceContract.View view;
                Intrinsics.checkNotNullParameter(derollInfo, "");
                if (!derollInfo.getSuccess()) {
                    view = TrustedDevicePresenter.this.moveToNextValue;
                    view.MyBillsEntityDataFactory();
                    return;
                }
                TrustedDevicePresenter trustedDevicePresenter = TrustedDevicePresenter.this;
                String securityId = derollInfo.getSecurityId();
                String str = securityId != null ? securityId : "";
                List<String> verificationMethodInfos = derollInfo.getVerificationMethodInfos();
                if (verificationMethodInfos == null) {
                    verificationMethodInfos = CollectionsKt.emptyList();
                }
                TrustedDevicePresenter.MyBillsEntityDataFactory(trustedDevicePresenter, str, verificationMethodInfos);
            }
        }, new Function1<Throwable, Unit>() { // from class: id.dana.twilio.trusteddevice.TrustedDevicePresenter$derollVerifyPush$2
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
                TrustedDeviceContract.View view;
                Intrinsics.checkNotNullParameter(th, "");
                view = TrustedDevicePresenter.this.moveToNextValue;
                view.onError("");
                DanaLog.BuiltInFictitiousFunctionClassFactory(DanaLogConstants.TAG.TWILIO_DEROLL, th.getMessage(), th);
            }
        });
    }

    /* JADX WARN: Type inference failed for: r2v0, types: [kotlin.jvm.internal.DefaultConstructorMarker, java.lang.String] */
    @Override // id.dana.twilio.trusteddevice.TrustedDeviceContract.Presenter
    public final void getAuthRequestContext() {
        this.moveToNextValue.getAuthRequestContext();
        ?? r2 = 0;
        this.getAuthRequestContext.execute(new CheckPendingChallenge.Params(r2, 1, r2), new Function1<Map<String, ? extends String>, Unit>() { // from class: id.dana.twilio.trusteddevice.TrustedDevicePresenter$doVerifyYourDevice$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final /* bridge */ /* synthetic */ Unit invoke(Map<String, ? extends String> map) {
                invoke2((Map<String, String>) map);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(Map<String, String> map) {
                TrustedDeviceContract.View view;
                TrustedDeviceContract.View view2;
                TrustedDeviceContract.View view3;
                Intrinsics.checkNotNullParameter(map, "");
                view = TrustedDevicePresenter.this.moveToNextValue;
                view.getAuthRequestContext(true);
                if (!map.isEmpty()) {
                    view3 = TrustedDevicePresenter.this.moveToNextValue;
                    view3.KClassImpl$Data$declaredNonStaticMembers$2(map.get(TwilioIdentityVerificationActivity.FACTOR_SID), map.get(TwilioIdentityVerificationActivity.CHALLENGE_SID));
                    return;
                }
                view2 = TrustedDevicePresenter.this.moveToNextValue;
                view2.KClassImpl$Data$declaredNonStaticMembers$2();
            }
        }, new Function1<Throwable, Unit>() { // from class: id.dana.twilio.trusteddevice.TrustedDevicePresenter$doVerifyYourDevice$2
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
                String str;
                TrustedDeviceContract.View view;
                Intrinsics.checkNotNullParameter(th, "");
                str = TrustedDevicePresenter.this.BuiltInFictitiousFunctionClassFactory;
                DanaLog.BuiltInFictitiousFunctionClassFactory(str, th.getMessage());
                view = TrustedDevicePresenter.this.moveToNextValue;
                view.getAuthRequestContext(false);
            }
        });
    }

    @Override // id.dana.base.AbstractContractKt.AbstractPresenter, id.dana.base.AbstractContract.AbstractPresenter
    public final void onDestroy() {
        this.KClassImpl$Data$declaredNonStaticMembers$2.dispose();
        this.MyBillsEntityDataFactory.dispose();
        this.NetworkUserEntityData$$ExternalSyntheticLambda0.dispose();
        this.PlaceComponentResult.dispose();
        this.getAuthRequestContext.dispose();
    }

    public static final /* synthetic */ void getAuthRequestContext(TrustedDevicePresenter trustedDevicePresenter, UserInfoResponse userInfoResponse) {
        if (StringsKt.equals$default(userInfoResponse.getKycInfo(), "KYC2", false, 2, null)) {
            trustedDevicePresenter.moveToNextValue.getAuthRequestContext(userInfoResponse.getNickname());
        } else {
            trustedDevicePresenter.moveToNextValue.BuiltInFictitiousFunctionClassFactory();
        }
    }

    public static final /* synthetic */ void MyBillsEntityDataFactory(TrustedDevicePresenter trustedDevicePresenter, String str, List list) {
        if ((!list.isEmpty()) != false) {
            trustedDevicePresenter.moveToNextValue.MyBillsEntityDataFactory(str, (String) CollectionsKt.first(list));
        } else {
            trustedDevicePresenter.PlaceComponentResult.execute(new TrustedDevicePresenter$deleteLocalFactor$1(trustedDevicePresenter));
        }
    }

    @Override // id.dana.twilio.trusteddevice.TrustedDeviceContract.Presenter
    public final void MyBillsEntityDataFactory() {
        this.PlaceComponentResult.execute(new TrustedDevicePresenter$deleteLocalFactor$1(this));
    }
}
