package id.dana.onboarding.carrieridentification;

import android.app.Activity;
import android.content.Context;
import dagger.Lazy;
import id.dana.analytics.tracker.TrackerDataKey;
import id.dana.analytics.tracker.register.RegistrationTracker;
import id.dana.challenge.ChallengeScenario;
import id.dana.data.login.source.network.model.VerifyMethod;
import id.dana.domain.carrieridentification.interactor.CheckIpificationAuthCode;
import id.dana.domain.carrieridentification.interactor.VerifyIpificationAuthCode;
import id.dana.domain.carrieridentification.model.GetAuthCodeResponse;
import id.dana.domain.twilio.model.VerifySecurityInfo;
import id.dana.network.exception.NetworkException;
import id.dana.onboarding.carrieridentification.CarrierIdentificationVerifyContract;
import id.dana.tracker.mixpanel.MixPanelTracker;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \u001d2\u00020\u0001:\u0001\u001dBC\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0012\u0012\u0006\u0010\u0005\u001a\u00020\u0018\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u000e0\r\u0012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00170\r\u0012\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00150\r¢\u0006\u0004\b\u001b\u0010\u001cJ/\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\u000b\u001a\u00020\bH\u0016¢\u0006\u0004\b\u000b\u0010\fR\u001a\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u000e0\r8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0014\u001a\u00020\u00128\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010\u0013R\u001a\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00150\r8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\t\u0010\u0010R\u001a\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00170\r8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0014\u0010\u0010R\u0014\u0010\t\u001a\u00020\u00188\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0016\u0010\u0019"}, d2 = {"Lid/dana/onboarding/carrieridentification/CarrierIdentificationVerifyPresenter;", "Lid/dana/onboarding/carrieridentification/CarrierIdentificationVerifyContract$Presenter;", "Landroid/app/Activity;", "p0", "", "p1", "p2", "p3", "", "MyBillsEntityDataFactory", "(Landroid/app/Activity;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "onDestroy", "()V", "Ldagger/Lazy;", "Lid/dana/domain/carrieridentification/interactor/CheckIpificationAuthCode;", "BuiltInFictitiousFunctionClassFactory", "Ldagger/Lazy;", "getAuthRequestContext", "Landroid/content/Context;", "Landroid/content/Context;", "KClassImpl$Data$declaredNonStaticMembers$2", "Lid/dana/analytics/tracker/register/RegistrationTracker;", "PlaceComponentResult", "Lid/dana/domain/carrieridentification/interactor/VerifyIpificationAuthCode;", "Lid/dana/onboarding/carrieridentification/CarrierIdentificationVerifyContract$View;", "Lid/dana/onboarding/carrieridentification/CarrierIdentificationVerifyContract$View;", "p4", "<init>", "(Landroid/content/Context;Lid/dana/onboarding/carrieridentification/CarrierIdentificationVerifyContract$View;Ldagger/Lazy;Ldagger/Lazy;Ldagger/Lazy;)V", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class CarrierIdentificationVerifyPresenter implements CarrierIdentificationVerifyContract.Presenter {

    /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
    private final Lazy<CheckIpificationAuthCode> getAuthRequestContext;

    /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
    final Lazy<VerifyIpificationAuthCode> BuiltInFictitiousFunctionClassFactory;

    /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
    private final Lazy<RegistrationTracker> PlaceComponentResult;

    /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
    private final CarrierIdentificationVerifyContract.View MyBillsEntityDataFactory;

    /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
    final Context KClassImpl$Data$declaredNonStaticMembers$2;

    @Inject
    public CarrierIdentificationVerifyPresenter(Context context, CarrierIdentificationVerifyContract.View view, Lazy<CheckIpificationAuthCode> lazy, Lazy<VerifyIpificationAuthCode> lazy2, Lazy<RegistrationTracker> lazy3) {
        Intrinsics.checkNotNullParameter(context, "");
        Intrinsics.checkNotNullParameter(view, "");
        Intrinsics.checkNotNullParameter(lazy, "");
        Intrinsics.checkNotNullParameter(lazy2, "");
        Intrinsics.checkNotNullParameter(lazy3, "");
        this.KClassImpl$Data$declaredNonStaticMembers$2 = context;
        this.MyBillsEntityDataFactory = view;
        this.getAuthRequestContext = lazy;
        this.BuiltInFictitiousFunctionClassFactory = lazy2;
        this.PlaceComponentResult = lazy3;
    }

    @Override // id.dana.onboarding.carrieridentification.CarrierIdentificationVerifyContract.Presenter
    public final void MyBillsEntityDataFactory(Activity p0, final String p1, final String p2, final String p3) {
        Intrinsics.checkNotNullParameter(p0, "");
        Intrinsics.checkNotNullParameter(p1, "");
        Intrinsics.checkNotNullParameter(p2, "");
        Intrinsics.checkNotNullParameter(p3, "");
        this.MyBillsEntityDataFactory.showProgress();
        this.getAuthRequestContext.get().execute(new CheckIpificationAuthCode.Params(p0, p1, p2, p3), new Function1<GetAuthCodeResponse, Unit>() { // from class: id.dana.onboarding.carrieridentification.CarrierIdentificationVerifyPresenter$getIPificationAuthCode$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final /* bridge */ /* synthetic */ Unit invoke(GetAuthCodeResponse getAuthCodeResponse) {
                invoke2(getAuthCodeResponse);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(GetAuthCodeResponse getAuthCodeResponse) {
                Lazy lazy;
                CarrierIdentificationVerifyContract.View view;
                CarrierIdentificationVerifyContract.View view2;
                Intrinsics.checkNotNullParameter(getAuthCodeResponse, "");
                lazy = CarrierIdentificationVerifyPresenter.this.PlaceComponentResult;
                ((RegistrationTracker) lazy.get()).KClassImpl$Data$declaredNonStaticMembers$2(VerifyMethod.CARRIER_IDENTIFICATION);
                String authCode = getAuthCodeResponse.getAuthCode();
                if (authCode == null || authCode.length() == 0) {
                    view = CarrierIdentificationVerifyPresenter.this.MyBillsEntityDataFactory;
                    view.dismissProgress();
                    view2 = CarrierIdentificationVerifyPresenter.this.MyBillsEntityDataFactory;
                    view2.KClassImpl$Data$declaredNonStaticMembers$2(ChallengeScenario.REGISTRATION, getAuthCodeResponse.getErrorCode(), getAuthCodeResponse.getErrorMessage());
                    return;
                }
                final CarrierIdentificationVerifyPresenter carrierIdentificationVerifyPresenter = CarrierIdentificationVerifyPresenter.this;
                String str = p1;
                String str2 = p2;
                String str3 = p3;
                String authCode2 = getAuthCodeResponse.getAuthCode();
                Intrinsics.checkNotNullParameter(str, "");
                Intrinsics.checkNotNullParameter(str2, "");
                Intrinsics.checkNotNullParameter(str3, "");
                carrierIdentificationVerifyPresenter.BuiltInFictitiousFunctionClassFactory.get().execute(new VerifyIpificationAuthCode.Params(str, str2, str3, authCode2 != null ? authCode2 : ""), new Function1<VerifySecurityInfo, Unit>() { // from class: id.dana.onboarding.carrieridentification.CarrierIdentificationVerifyPresenter$verifyCarrierIdentificationRegistration$1
                    /* JADX INFO: Access modifiers changed from: package-private */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final /* bridge */ /* synthetic */ Unit invoke(VerifySecurityInfo verifySecurityInfo) {
                        invoke2(verifySecurityInfo);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke  reason: avoid collision after fix types in other method */
                    public final void invoke2(VerifySecurityInfo verifySecurityInfo) {
                        CarrierIdentificationVerifyContract.View view3;
                        CarrierIdentificationVerifyContract.View view4;
                        CarrierIdentificationVerifyContract.View view5;
                        Intrinsics.checkNotNullParameter(verifySecurityInfo, "");
                        view3 = CarrierIdentificationVerifyPresenter.this.MyBillsEntityDataFactory;
                        view3.dismissProgress();
                        if (verifySecurityInfo.getSuccess()) {
                            view5 = CarrierIdentificationVerifyPresenter.this.MyBillsEntityDataFactory;
                            view5.BuiltInFictitiousFunctionClassFactory(ChallengeScenario.REGISTRATION);
                            return;
                        }
                        view4 = CarrierIdentificationVerifyPresenter.this.MyBillsEntityDataFactory;
                        view4.KClassImpl$Data$declaredNonStaticMembers$2(ChallengeScenario.REGISTRATION, verifySecurityInfo.getErrorCode(), verifySecurityInfo.getErrorMessage());
                    }
                }, new Function1<Throwable, Unit>() { // from class: id.dana.onboarding.carrieridentification.CarrierIdentificationVerifyPresenter$verifyCarrierIdentificationRegistration$2
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
                        CarrierIdentificationVerifyContract.View view3;
                        CarrierIdentificationVerifyContract.View view4;
                        Intrinsics.checkNotNullParameter(th, "");
                        view3 = CarrierIdentificationVerifyPresenter.this.MyBillsEntityDataFactory;
                        view3.dismissProgress();
                        view4 = CarrierIdentificationVerifyPresenter.this.MyBillsEntityDataFactory;
                        view4.KClassImpl$Data$declaredNonStaticMembers$2(ChallengeScenario.REGISTRATION, null, null);
                    }
                });
            }
        }, new Function1<Throwable, Unit>() { // from class: id.dana.onboarding.carrieridentification.CarrierIdentificationVerifyPresenter$getIPificationAuthCode$2
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
                CarrierIdentificationVerifyContract.View view;
                CarrierIdentificationVerifyContract.View view2;
                String str;
                Intrinsics.checkNotNullParameter(th, "");
                view = CarrierIdentificationVerifyPresenter.this.MyBillsEntityDataFactory;
                view.dismissProgress();
                boolean z = th instanceof NetworkException;
                String errorCode = z ? ((NetworkException) th).getErrorCode() : null;
                view2 = CarrierIdentificationVerifyPresenter.this.MyBillsEntityDataFactory;
                view2.KClassImpl$Data$declaredNonStaticMembers$2(ChallengeScenario.REGISTRATION, errorCode, th.getMessage());
                CarrierIdentificationVerifyPresenter carrierIdentificationVerifyPresenter = CarrierIdentificationVerifyPresenter.this;
                String message = th.getMessage();
                String message2 = th.getMessage();
                Intrinsics.checkNotNullParameter(TrackerDataKey.NetworkErrorOperationTypeProperty.VERIFY_SECURITY_PRODUCT, "");
                Intrinsics.checkNotNullParameter(th, "");
                if (z) {
                    String traceId = ((NetworkException) th).getTraceId();
                    Intrinsics.checkNotNullExpressionValue(traceId, "");
                    str = traceId;
                } else {
                    str = "";
                }
                MixPanelTracker.BuiltInFictitiousFunctionClassFactory(carrierIdentificationVerifyPresenter.KClassImpl$Data$declaredNonStaticMembers$2, TrackerDataKey.NetworkErrorOperationTypeProperty.VERIFY_SECURITY_PRODUCT, message, message2, TrackerDataKey.Source.VERIFY_PHONE_NUMBER, str);
            }
        });
    }

    @Override // id.dana.base.AbstractContractKt.AbstractPresenter, id.dana.base.AbstractContract.AbstractPresenter
    public final void onDestroy() {
        this.getAuthRequestContext.get().dispose();
        this.BuiltInFictitiousFunctionClassFactory.get().dispose();
    }
}
