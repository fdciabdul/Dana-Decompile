package id.dana.onboarding.referral;

import android.location.Location;
import id.dana.constants.ErrorCode;
import id.dana.data.network.exception.MockGpsDetectedException;
import id.dana.domain.DefaultObserver;
import id.dana.domain.core.usecase.BaseUseCase;
import id.dana.domain.core.usecase.NoParams;
import id.dana.domain.featureconfig.interactor.GetPersonalizedReferralConfig;
import id.dana.domain.featureconfig.model.PersonalizedReferralConfig;
import id.dana.domain.geocode.interactor.GetIndoSubdivisionsByLocation;
import id.dana.domain.geocode.model.IndoSubdivisions;
import id.dana.domain.referral.interactor.VerifyReferralCode;
import id.dana.domain.referral.model.VerifyReferralCodeResponse;
import id.dana.domain.tracker.HereMixPanelTrackerData;
import id.dana.network.exception.NetworkException;
import id.dana.onboarding.referral.ReferralContract;
import java.util.List;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 $2\u00020\u0001:\u0001$B)\b\u0007\u0012\u0006\u0010\u0007\u001a\u00020\u001c\u0012\u0006\u0010\u000b\u001a\u00020\u0017\u0012\u0006\u0010 \u001a\u00020\u0010\u0012\u0006\u0010!\u001a\u00020\u0012¢\u0006\u0004\b\"\u0010#J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0005\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0004J\u0019\u0010\b\u001a\u00020\u00022\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016¢\u0006\u0004\b\b\u0010\tJ!\u0010\u0003\u001a\u00020\u00022\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u000b\u001a\u00020\nH\u0016¢\u0006\u0004\b\u0003\u0010\fR\u0016\u0010\u000e\u001a\u00020\r8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0003\u001a\u00020\u00108\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\b\u0010\u0011R\u0014\u0010\u0014\u001a\u00020\u00128\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u0013R\u0016\u0010\b\u001a\u00020\u00158\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0014\u0010\u0016R\u0014\u0010\u001a\u001a\u00020\u00178\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u0012\u0010\u001b\u001a\u00020\rX\u0080\u0002¢\u0006\u0006\n\u0004\b\u001a\u0010\u000fR\u0014\u0010\u001f\u001a\u00020\u001c8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001d\u0010\u001e"}, d2 = {"Lid/dana/onboarding/referral/VerifyReferralCodePresenter;", "Lid/dana/onboarding/referral/ReferralContract$Presenter;", "", "KClassImpl$Data$declaredNonStaticMembers$2", "()V", "onDestroy", "", "p0", "getAuthRequestContext", "(Ljava/lang/String;)V", "Landroid/location/Location;", "p1", "(Ljava/lang/String;Landroid/location/Location;)V", "", "BuiltInFictitiousFunctionClassFactory", "I", "Lid/dana/domain/geocode/interactor/GetIndoSubdivisionsByLocation;", "Lid/dana/domain/geocode/interactor/GetIndoSubdivisionsByLocation;", "Lid/dana/domain/featureconfig/interactor/GetPersonalizedReferralConfig;", "Lid/dana/domain/featureconfig/interactor/GetPersonalizedReferralConfig;", "MyBillsEntityDataFactory", "", "Z", "Lid/dana/domain/referral/interactor/VerifyReferralCode;", "lookAheadTest", "Lid/dana/domain/referral/interactor/VerifyReferralCode;", "PlaceComponentResult", "moveToNextValue", "Lid/dana/onboarding/referral/ReferralContract$View;", "scheduleImpl", "Lid/dana/onboarding/referral/ReferralContract$View;", "NetworkUserEntityData$$ExternalSyntheticLambda0", "p2", "p3", "<init>", "(Lid/dana/onboarding/referral/ReferralContract$View;Lid/dana/domain/referral/interactor/VerifyReferralCode;Lid/dana/domain/geocode/interactor/GetIndoSubdivisionsByLocation;Lid/dana/domain/featureconfig/interactor/GetPersonalizedReferralConfig;)V", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class VerifyReferralCodePresenter implements ReferralContract.Presenter {
    private int BuiltInFictitiousFunctionClassFactory;

    /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
    private final GetPersonalizedReferralConfig MyBillsEntityDataFactory;

    /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
    private boolean getAuthRequestContext;

    /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
    int moveToNextValue;

    /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
    private final GetIndoSubdivisionsByLocation KClassImpl$Data$declaredNonStaticMembers$2;

    /* renamed from: lookAheadTest  reason: from kotlin metadata */
    private final VerifyReferralCode PlaceComponentResult;

    /* renamed from: scheduleImpl  reason: from kotlin metadata */
    private final ReferralContract.View NetworkUserEntityData$$ExternalSyntheticLambda0;

    @Inject
    public VerifyReferralCodePresenter(ReferralContract.View view, VerifyReferralCode verifyReferralCode, GetIndoSubdivisionsByLocation getIndoSubdivisionsByLocation, GetPersonalizedReferralConfig getPersonalizedReferralConfig) {
        Intrinsics.checkNotNullParameter(view, "");
        Intrinsics.checkNotNullParameter(verifyReferralCode, "");
        Intrinsics.checkNotNullParameter(getIndoSubdivisionsByLocation, "");
        Intrinsics.checkNotNullParameter(getPersonalizedReferralConfig, "");
        this.NetworkUserEntityData$$ExternalSyntheticLambda0 = view;
        this.PlaceComponentResult = verifyReferralCode;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = getIndoSubdivisionsByLocation;
        this.MyBillsEntityDataFactory = getPersonalizedReferralConfig;
        this.BuiltInFictitiousFunctionClassFactory = 1;
    }

    @Override // id.dana.onboarding.referral.ReferralContract.Presenter
    public final void getAuthRequestContext(String p0) {
        this.getAuthRequestContext = false;
        this.PlaceComponentResult.execute(new DefaultObserver<VerifyReferralCodeResponse>() { // from class: id.dana.onboarding.referral.VerifyReferralCodePresenter$verifyReferralCode$1
            @Override // id.dana.domain.DefaultObserver, io.reactivex.Observer
            public final /* synthetic */ void onNext(Object obj) {
                ReferralContract.View view;
                ReferralContract.View view2;
                ReferralContract.View view3;
                ReferralContract.View view4;
                VerifyReferralCodeResponse verifyReferralCodeResponse = (VerifyReferralCodeResponse) obj;
                Intrinsics.checkNotNullParameter(verifyReferralCodeResponse, "");
                if (verifyReferralCodeResponse.isSuccess() && verifyReferralCodeResponse.isValid()) {
                    VerifyReferralCodePresenter.this.getAuthRequestContext = true;
                    view3 = VerifyReferralCodePresenter.this.NetworkUserEntityData$$ExternalSyntheticLambda0;
                    view3.BuiltInFictitiousFunctionClassFactory(true, "");
                    view4 = VerifyReferralCodePresenter.this.NetworkUserEntityData$$ExternalSyntheticLambda0;
                    view4.KClassImpl$Data$declaredNonStaticMembers$2();
                    return;
                }
                VerifyReferralCodePresenter.this.moveToNextValue++;
                String str = VerifyReferralCodePresenter.this.moveToNextValue < 5 ? "Invalid Code" : "Too Much Attempt";
                view = VerifyReferralCodePresenter.this.NetworkUserEntityData$$ExternalSyntheticLambda0;
                view.BuiltInFictitiousFunctionClassFactory(false, "Invalid Code");
                view2 = VerifyReferralCodePresenter.this.NetworkUserEntityData$$ExternalSyntheticLambda0;
                view2.getAuthRequestContext(str);
            }

            @Override // id.dana.domain.DefaultObserver, io.reactivex.Observer
            public final void onError(Throwable p02) {
                ReferralContract.View view;
                ReferralContract.View view2;
                ReferralContract.View view3;
                Intrinsics.checkNotNullParameter(p02, "");
                if (p02 instanceof NetworkException) {
                    VerifyReferralCodePresenter.getAuthRequestContext(VerifyReferralCodePresenter.this, (NetworkException) p02);
                } else if (p02 instanceof MockGpsDetectedException) {
                    view3 = VerifyReferralCodePresenter.this.NetworkUserEntityData$$ExternalSyntheticLambda0;
                    view3.getAuthRequestContext();
                } else {
                    view = VerifyReferralCodePresenter.this.NetworkUserEntityData$$ExternalSyntheticLambda0;
                    view.BuiltInFictitiousFunctionClassFactory(false, p02.getMessage());
                    view2 = VerifyReferralCodePresenter.this.NetworkUserEntityData$$ExternalSyntheticLambda0;
                    view2.getAuthRequestContext("System Busy");
                }
            }
        }, VerifyReferralCode.Params.forReferralVerify(p0));
    }

    @Override // id.dana.onboarding.referral.ReferralContract.Presenter
    public final void KClassImpl$Data$declaredNonStaticMembers$2(final String p0, Location p1) {
        Intrinsics.checkNotNullParameter(p1, "");
        this.KClassImpl$Data$declaredNonStaticMembers$2.execute(new DefaultObserver<IndoSubdivisions>() { // from class: id.dana.onboarding.referral.VerifyReferralCodePresenter$verifyReferralCodeWithGivenLocation$1
            @Override // id.dana.domain.DefaultObserver, io.reactivex.Observer
            public final /* synthetic */ void onNext(Object obj) {
                Intrinsics.checkNotNullParameter((IndoSubdivisions) obj, "");
                VerifyReferralCodePresenter.this.getAuthRequestContext(p0);
            }

            @Override // id.dana.domain.DefaultObserver, io.reactivex.Observer
            public final void onError(Throwable p02) {
                ReferralContract.View view;
                ReferralContract.View view2;
                Intrinsics.checkNotNullParameter(p02, "");
                view = VerifyReferralCodePresenter.this.NetworkUserEntityData$$ExternalSyntheticLambda0;
                view.BuiltInFictitiousFunctionClassFactory(false, "Get city name fail");
                view2 = VerifyReferralCodePresenter.this.NetworkUserEntityData$$ExternalSyntheticLambda0;
                view2.getAuthRequestContext(null);
            }
        }, GetIndoSubdivisionsByLocation.Params.Companion.forLocation$default(GetIndoSubdivisionsByLocation.Params.INSTANCE, p1, false, false, new HereMixPanelTrackerData("Verify Referral", null, false, null, null, 30, null), false, 22, null));
    }

    @Override // id.dana.onboarding.referral.ReferralContract.Presenter
    public final void KClassImpl$Data$declaredNonStaticMembers$2() {
        BaseUseCase.execute$default(this.MyBillsEntityDataFactory, NoParams.INSTANCE, new Function1<List<? extends PersonalizedReferralConfig>, Unit>() { // from class: id.dana.onboarding.referral.VerifyReferralCodePresenter$getPersonalizedReferral$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final /* bridge */ /* synthetic */ Unit invoke(List<? extends PersonalizedReferralConfig> list) {
                invoke2((List<PersonalizedReferralConfig>) list);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(List<PersonalizedReferralConfig> list) {
                ReferralContract.View view;
                Intrinsics.checkNotNullParameter(list, "");
                view = VerifyReferralCodePresenter.this.NetworkUserEntityData$$ExternalSyntheticLambda0;
                view.MyBillsEntityDataFactory(list);
            }
        }, null, 4, null);
    }

    @Override // id.dana.base.AbstractContractKt.AbstractPresenter, id.dana.base.AbstractContract.AbstractPresenter
    public final void onDestroy() {
        this.BuiltInFictitiousFunctionClassFactory = 0;
        this.PlaceComponentResult.dispose();
        this.KClassImpl$Data$declaredNonStaticMembers$2.dispose();
        this.MyBillsEntityDataFactory.dispose();
    }

    public static final /* synthetic */ void getAuthRequestContext(VerifyReferralCodePresenter verifyReferralCodePresenter, NetworkException networkException) {
        if (Intrinsics.areEqual(networkException.getErrorCode(), ErrorCode.PROMO_LOCATION_REQUIRED)) {
            int i = verifyReferralCodePresenter.BuiltInFictitiousFunctionClassFactory;
            if (i >= 5) {
                verifyReferralCodePresenter.NetworkUserEntityData$$ExternalSyntheticLambda0.BuiltInFictitiousFunctionClassFactory(false, networkException.getMessage());
                verifyReferralCodePresenter.NetworkUserEntityData$$ExternalSyntheticLambda0.getAuthRequestContext(null);
                return;
            }
            verifyReferralCodePresenter.BuiltInFictitiousFunctionClassFactory = i + 1;
            verifyReferralCodePresenter.NetworkUserEntityData$$ExternalSyntheticLambda0.MyBillsEntityDataFactory();
            return;
        }
        verifyReferralCodePresenter.NetworkUserEntityData$$ExternalSyntheticLambda0.BuiltInFictitiousFunctionClassFactory(false, networkException.getMessage());
        verifyReferralCodePresenter.NetworkUserEntityData$$ExternalSyntheticLambda0.getAuthRequestContext(networkException.getMessage());
    }
}
