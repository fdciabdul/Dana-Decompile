package id.dana.onboarding.carrieridentification;

import com.alibaba.ariver.kernel.RVEvents;
import id.dana.analytics.tracker.TrackerKey;
import id.dana.base.AbstractContractKt;
import id.dana.databinding.ActivityCarrierIdentificationVerifyBinding;
import id.dana.onboarding.carrieridentification.CarrierIdentificationVerifyContract;
import id.dana.performancetracker.VerifyMethodAnalyticTracker;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\t\b\n\u0018\u00002\u00020\u0001J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J\u0019\u0010\u0007\u001a\u00020\u00022\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0016¢\u0006\u0004\b\u0007\u0010\bJ+\u0010\u000b\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00052\b\u0010\t\u001a\u0004\u0018\u00010\u00052\b\u0010\n\u001a\u0004\u0018\u00010\u0005H\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u0017\u0010\r\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\r\u0010\bJ\u000f\u0010\u000e\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u000e\u0010\u0004"}, d2 = {"Lid/dana/onboarding/carrieridentification/CarrierIdentificationVerifyActivity$getCarrierIdentificationVerifyModule$1;", "Lid/dana/onboarding/carrieridentification/CarrierIdentificationVerifyContract$View;", "", "dismissProgress", "()V", "", "p0", RVEvents.EMBED_WEBVIEW_LOAD_ERROR_EVENT, "(Ljava/lang/String;)V", "p1", "p2", "KClassImpl$Data$declaredNonStaticMembers$2", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "BuiltInFictitiousFunctionClassFactory", "showProgress"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class CarrierIdentificationVerifyActivity$getCarrierIdentificationVerifyModule$1 implements CarrierIdentificationVerifyContract.View {
    final /* synthetic */ CarrierIdentificationVerifyActivity MyBillsEntityDataFactory;

    @Override // id.dana.base.AbstractContractKt.AbstractView
    public final /* synthetic */ String getErrorSource() {
        return AbstractContractKt.AbstractView.CC.getAuthRequestContext();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public CarrierIdentificationVerifyActivity$getCarrierIdentificationVerifyModule$1(CarrierIdentificationVerifyActivity carrierIdentificationVerifyActivity) {
        this.MyBillsEntityDataFactory = carrierIdentificationVerifyActivity;
    }

    @Override // id.dana.onboarding.carrieridentification.CarrierIdentificationVerifyContract.View
    public final void BuiltInFictitiousFunctionClassFactory(String p0) {
        List list;
        Intrinsics.checkNotNullParameter(p0, "");
        if (Intrinsics.areEqual(p0, "Login")) {
            VerifyMethodAnalyticTracker.BuiltInFictitiousFunctionClassFactory(this.MyBillsEntityDataFactory, TrackerKey.Event.LOGIN_VERIFICATION_METHOD_CARRIER_IDENTIFICATION_TIME, TrackerKey.Event.LOGIN_VERIFICATION_METHOD_CARRIER_IDENTIFICATION_SUCCESS, null, null);
            CarrierIdentificationVerifyActivity.access$successVerifyCarrierIdentification(this.MyBillsEntityDataFactory);
            return;
        }
        VerifyMethodAnalyticTracker.BuiltInFictitiousFunctionClassFactory(this.MyBillsEntityDataFactory, TrackerKey.Event.REGISTRATION_VERIFICATION_METHOD_CARRIER_IDENTIFICATION_TIME, TrackerKey.Event.REGISTRATION_VERIFICATION_METHOD_CARRIER_IDENTIFICATION_SUCCESS, null, null);
        CarrierIdentificationVerifyActivity carrierIdentificationVerifyActivity = this.MyBillsEntityDataFactory;
        list = carrierIdentificationVerifyActivity.KClassImpl$Data$declaredNonStaticMembers$2;
        CarrierIdentificationVerifyActivity.access$setResultVerifyCarrierIdentificationRegistration(carrierIdentificationVerifyActivity, "successNeedCheckReferral", null, list);
    }

    @Override // id.dana.onboarding.carrieridentification.CarrierIdentificationVerifyContract.View
    public final void KClassImpl$Data$declaredNonStaticMembers$2(String p0, String p1, String p2) {
        List list;
        List list2;
        Intrinsics.checkNotNullParameter(p0, "");
        if (Intrinsics.areEqual(p0, "Login")) {
            CarrierIdentificationVerifyActivity carrierIdentificationVerifyActivity = this.MyBillsEntityDataFactory;
            VerifyMethodAnalyticTracker.BuiltInFictitiousFunctionClassFactory(carrierIdentificationVerifyActivity, TrackerKey.Event.LOGIN_VERIFICATION_METHOD_CARRIER_IDENTIFICATION_TIME, TrackerKey.Event.LOGIN_VERIFICATION_METHOD_CARRIER_IDENTIFICATION_FAILED, CarrierIdentificationVerifyActivity.access$checkErrorTracker(carrierIdentificationVerifyActivity, p1, true), CarrierIdentificationVerifyActivity.access$checkErrorTracker(this.MyBillsEntityDataFactory, p2, false));
            CarrierIdentificationVerifyActivity carrierIdentificationVerifyActivity2 = this.MyBillsEntityDataFactory;
            list2 = carrierIdentificationVerifyActivity2.PlaceComponentResult;
            carrierIdentificationVerifyActivity2.getAuthRequestContext(list2);
            return;
        }
        CarrierIdentificationVerifyActivity carrierIdentificationVerifyActivity3 = this.MyBillsEntityDataFactory;
        VerifyMethodAnalyticTracker.BuiltInFictitiousFunctionClassFactory(carrierIdentificationVerifyActivity3, TrackerKey.Event.REGISTRATION_VERIFICATION_METHOD_CARRIER_IDENTIFICATION_TIME, TrackerKey.Event.REGISTRATION_VERIFICATION_METHOD_CARRIER_IDENTIFICATION_FAILED, CarrierIdentificationVerifyActivity.access$checkErrorTracker(carrierIdentificationVerifyActivity3, p1, true), CarrierIdentificationVerifyActivity.access$checkErrorTracker(this.MyBillsEntityDataFactory, p2, false));
        CarrierIdentificationVerifyActivity carrierIdentificationVerifyActivity4 = this.MyBillsEntityDataFactory;
        list = carrierIdentificationVerifyActivity4.KClassImpl$Data$declaredNonStaticMembers$2;
        CarrierIdentificationVerifyActivity.access$setResultVerifyCarrierIdentificationRegistration(carrierIdentificationVerifyActivity4, "failedNeedFailback", null, list);
    }

    @Override // id.dana.base.AbstractContractKt.AbstractView, id.dana.base.AbstractContract.AbstractView
    public final void showProgress() {
        final CarrierIdentificationVerifyActivity carrierIdentificationVerifyActivity = this.MyBillsEntityDataFactory;
        carrierIdentificationVerifyActivity.runOnUiThread(new Runnable() { // from class: id.dana.onboarding.carrieridentification.CarrierIdentificationVerifyActivity$getCarrierIdentificationVerifyModule$1$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                CarrierIdentificationVerifyActivity$getCarrierIdentificationVerifyModule$1.BuiltInFictitiousFunctionClassFactory(CarrierIdentificationVerifyActivity.this);
            }
        });
    }

    @Override // id.dana.base.AbstractContractKt.AbstractView, id.dana.base.AbstractContract.AbstractView
    public final void dismissProgress() {
        final CarrierIdentificationVerifyActivity carrierIdentificationVerifyActivity = this.MyBillsEntityDataFactory;
        carrierIdentificationVerifyActivity.runOnUiThread(new Runnable() { // from class: id.dana.onboarding.carrieridentification.CarrierIdentificationVerifyActivity$getCarrierIdentificationVerifyModule$1$$ExternalSyntheticLambda1
            @Override // java.lang.Runnable
            public final void run() {
                CarrierIdentificationVerifyActivity$getCarrierIdentificationVerifyModule$1.KClassImpl$Data$declaredNonStaticMembers$2(CarrierIdentificationVerifyActivity.this);
            }
        });
    }

    @Override // id.dana.base.AbstractContractKt.AbstractView, id.dana.base.AbstractContract.AbstractView
    public final void onError(String p0) {
        List list;
        CarrierIdentificationVerifyActivity carrierIdentificationVerifyActivity = this.MyBillsEntityDataFactory;
        list = carrierIdentificationVerifyActivity.KClassImpl$Data$declaredNonStaticMembers$2;
        CarrierIdentificationVerifyActivity.access$setResultVerifyCarrierIdentificationRegistration(carrierIdentificationVerifyActivity, "errorVerify", p0, list);
    }

    public static /* synthetic */ void KClassImpl$Data$declaredNonStaticMembers$2(CarrierIdentificationVerifyActivity carrierIdentificationVerifyActivity) {
        ActivityCarrierIdentificationVerifyBinding binding;
        ActivityCarrierIdentificationVerifyBinding binding2;
        Intrinsics.checkNotNullParameter(carrierIdentificationVerifyActivity, "");
        binding = carrierIdentificationVerifyActivity.getBinding();
        binding.NetworkUserEntityData$$ExternalSyntheticLambda0.DatabaseTableConfigUtil.setVisibility(0);
        binding2 = carrierIdentificationVerifyActivity.getBinding();
        binding2.lookAheadTest.MyBillsEntityDataFactory.setVisibility(8);
    }

    public static /* synthetic */ void BuiltInFictitiousFunctionClassFactory(CarrierIdentificationVerifyActivity carrierIdentificationVerifyActivity) {
        ActivityCarrierIdentificationVerifyBinding binding;
        ActivityCarrierIdentificationVerifyBinding binding2;
        Intrinsics.checkNotNullParameter(carrierIdentificationVerifyActivity, "");
        binding = carrierIdentificationVerifyActivity.getBinding();
        binding.NetworkUserEntityData$$ExternalSyntheticLambda0.DatabaseTableConfigUtil.setVisibility(8);
        binding2 = carrierIdentificationVerifyActivity.getBinding();
        binding2.lookAheadTest.MyBillsEntityDataFactory.setVisibility(0);
    }
}
