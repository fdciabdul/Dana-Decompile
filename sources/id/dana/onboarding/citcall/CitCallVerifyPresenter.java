package id.dana.onboarding.citcall;

import android.content.Context;
import dagger.Lazy;
import id.dana.analytics.tracker.register.RegistrationTracker;
import id.dana.base.AbstractContractKt;
import id.dana.domain.otp.interactor.VerifyOtpRisk;
import id.dana.domain.otp.model.VerifyOtpRiskResponse;
import id.dana.network.exception.NetworkException;
import id.dana.onboarding.citcall.CitCallVerifyContract;
import id.dana.riskChallenges.ui.missedCallOtp.CitCallErrorCode;
import id.dana.tracker.EventTracker;
import id.dana.tracker.model.TrackOtpModel;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B/\b\u0007\u0012\u0006\u0010\u0006\u001a\u00020\u001c\u0012\u0006\u0010\u0007\u001a\u00020\u001a\u0012\u0006\u0010\b\u001a\u00020 \u0012\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00140\u0013¢\u0006\u0004\b!\u0010\"J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J9\u0010\f\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u00052\b\u0010\t\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u000b\u001a\u00020\nH\u0016¢\u0006\u0004\b\f\u0010\rR\u0016\u0010\u000f\u001a\u00020\n8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\f\u0010\u000eR\u0012\u0010\u0011\u001a\u00020\u0010X\u0080\u0002¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u001a\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00140\u00138\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u0014\u0010\u0019\u001a\u00020\u00178\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010\u0018R\u0014\u0010\f\u001a\u00020\u001a8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0019\u0010\u001bR\u0014\u0010\u001f\u001a\u00020\u001c8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001d\u0010\u001e"}, d2 = {"Lid/dana/onboarding/citcall/CitCallVerifyPresenter;", "Lid/dana/onboarding/citcall/CitCallVerifyContract$Presenter;", "", "onDestroy", "()V", "", "p0", "p1", "p2", "p3", "", "p4", "MyBillsEntityDataFactory", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;I)V", "I", "getAuthRequestContext", "", "PlaceComponentResult", "Z", "Ldagger/Lazy;", "Lid/dana/analytics/tracker/register/RegistrationTracker;", "KClassImpl$Data$declaredNonStaticMembers$2", "Ldagger/Lazy;", "Lid/dana/tracker/model/TrackOtpModel;", "Lid/dana/tracker/model/TrackOtpModel;", "BuiltInFictitiousFunctionClassFactory", "Lid/dana/domain/otp/interactor/VerifyOtpRisk;", "Lid/dana/domain/otp/interactor/VerifyOtpRisk;", "Lid/dana/onboarding/citcall/CitCallVerifyContract$View;", "getErrorConfigVersion", "Lid/dana/onboarding/citcall/CitCallVerifyContract$View;", "lookAheadTest", "Landroid/content/Context;", "<init>", "(Lid/dana/onboarding/citcall/CitCallVerifyContract$View;Lid/dana/domain/otp/interactor/VerifyOtpRisk;Landroid/content/Context;Ldagger/Lazy;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class CitCallVerifyPresenter implements CitCallVerifyContract.Presenter {

    /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
    private final VerifyOtpRisk MyBillsEntityDataFactory;
    private final Lazy<RegistrationTracker> KClassImpl$Data$declaredNonStaticMembers$2;

    /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
    private int getAuthRequestContext;
    public boolean PlaceComponentResult;

    /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
    final TrackOtpModel BuiltInFictitiousFunctionClassFactory;

    /* renamed from: getErrorConfigVersion  reason: from kotlin metadata */
    private final CitCallVerifyContract.View lookAheadTest;

    @Inject
    public CitCallVerifyPresenter(CitCallVerifyContract.View view, VerifyOtpRisk verifyOtpRisk, Context context, Lazy<RegistrationTracker> lazy) {
        Intrinsics.checkNotNullParameter(view, "");
        Intrinsics.checkNotNullParameter(verifyOtpRisk, "");
        Intrinsics.checkNotNullParameter(context, "");
        Intrinsics.checkNotNullParameter(lazy, "");
        this.lookAheadTest = view;
        this.MyBillsEntityDataFactory = verifyOtpRisk;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = lazy;
        TrackOtpModel trackOtpModel = new TrackOtpModel(context, "Registration");
        trackOtpModel.MyBillsEntityDataFactory = "Misscall";
        this.BuiltInFictitiousFunctionClassFactory = trackOtpModel;
    }

    public final void MyBillsEntityDataFactory(String p0, String p1, String p2, final String p3, final int p4) {
        Intrinsics.checkNotNullParameter(p0, "");
        Intrinsics.checkNotNullParameter(p1, "");
        Intrinsics.checkNotNullParameter(p2, "");
        this.lookAheadTest.showProgress();
        this.MyBillsEntityDataFactory.execute(new VerifyOtpRisk.Params(p0, p1, p2, "MISSED_CALL_OTP", "REGISTER", null, 32, null), new Function1<VerifyOtpRiskResponse, Unit>() { // from class: id.dana.onboarding.citcall.CitCallVerifyPresenter$verify$1
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
                CitCallVerifyContract.View view;
                CitCallVerifyContract.View view2;
                Lazy lazy;
                TrackOtpModel trackOtpModel;
                int i;
                Intrinsics.checkNotNullParameter(verifyOtpRiskResponse, "");
                view = CitCallVerifyPresenter.this.lookAheadTest;
                view.dismissProgress();
                view2 = CitCallVerifyPresenter.this.lookAheadTest;
                view2.MyBillsEntityDataFactory();
                lazy = CitCallVerifyPresenter.this.KClassImpl$Data$declaredNonStaticMembers$2;
                ((RegistrationTracker) lazy.get()).KClassImpl$Data$declaredNonStaticMembers$2("MISSED_CALL_OTP");
                trackOtpModel = CitCallVerifyPresenter.this.BuiltInFictitiousFunctionClassFactory;
                boolean success = verifyOtpRiskResponse.getSuccess();
                i = CitCallVerifyPresenter.this.getAuthRequestContext;
                EventTracker.PlaceComponentResult(trackOtpModel.BuiltInFictitiousFunctionClassFactory(success, i, p4, p3));
            }
        }, new Function1<Throwable, Unit>() { // from class: id.dana.onboarding.citcall.CitCallVerifyPresenter$verify$2
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
                CitCallVerifyContract.View view;
                int i;
                Intrinsics.checkNotNullParameter(th, "");
                view = CitCallVerifyPresenter.this.lookAheadTest;
                view.dismissProgress();
                CitCallVerifyPresenter citCallVerifyPresenter = CitCallVerifyPresenter.this;
                i = citCallVerifyPresenter.getAuthRequestContext;
                citCallVerifyPresenter.getAuthRequestContext = i + 1;
                CitCallVerifyPresenter.MyBillsEntityDataFactory(CitCallVerifyPresenter.this, th);
            }
        });
    }

    @Override // id.dana.base.AbstractContractKt.AbstractPresenter, id.dana.base.AbstractContract.AbstractPresenter
    public final void onDestroy() {
        AbstractContractKt.AbstractPresenter.CC.BuiltInFictitiousFunctionClassFactory();
        this.MyBillsEntityDataFactory.dispose();
    }

    public static final /* synthetic */ void MyBillsEntityDataFactory(CitCallVerifyPresenter citCallVerifyPresenter, Throwable th) {
        if (th instanceof NetworkException) {
            NetworkException networkException = (NetworkException) th;
            String errorCode = networkException.getErrorCode();
            if (errorCode != null) {
                switch (errorCode.hashCode()) {
                    case -1728187470:
                        if (!errorCode.equals(CitCallErrorCode.GENERIC_ERROR)) {
                            return;
                        }
                        citCallVerifyPresenter.lookAheadTest.MyBillsEntityDataFactory(networkException.getErrorCode(), th.getMessage());
                        return;
                    case -1728187469:
                    case -1728187468:
                    default:
                        return;
                    case -1728187467:
                        if (!errorCode.equals(CitCallErrorCode.OTP_EXPIRED)) {
                            return;
                        }
                        citCallVerifyPresenter.lookAheadTest.BuiltInFictitiousFunctionClassFactory();
                        return;
                    case -1728187466:
                        if (!errorCode.equals(CitCallErrorCode.VERIFY_OTP_EXPIRED)) {
                            return;
                        }
                        citCallVerifyPresenter.lookAheadTest.BuiltInFictitiousFunctionClassFactory();
                        return;
                    case -1728187465:
                        if (!errorCode.equals(CitCallErrorCode.INVALID_OTP)) {
                            return;
                        }
                        citCallVerifyPresenter.lookAheadTest.MyBillsEntityDataFactory(networkException.getErrorCode(), th.getMessage());
                        return;
                    case -1728187464:
                        if (!errorCode.equals(CitCallErrorCode.EXCEED_OTP_PERIOD)) {
                            return;
                        }
                        citCallVerifyPresenter.lookAheadTest.BuiltInFictitiousFunctionClassFactory();
                        return;
                }
            }
            return;
        }
        citCallVerifyPresenter.lookAheadTest.MyBillsEntityDataFactory(null, th.getMessage());
    }
}
