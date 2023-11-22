package id.dana.maintenance;

import android.content.Intent;
import android.view.View;
import androidx.appcompat.widget.AppCompatTextView;
import id.dana.R;
import id.dana.base.AbstractContractKt;
import id.dana.component.buttoncomponent.DanaButtonSecondaryView;
import id.dana.databinding.ActivityEmergencyNotifBinding;
import id.dana.domain.featureconfig.model.EmergencyNotificationConfig;
import id.dana.maintenance.EmergencyNotifContract;
import id.dana.onboarding.splash.LocalConfigSplashActivity;
import id.dana.utils.DANAToast;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\b\n\u0018\u00002\u00020\u0001J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0005\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0004J\u000f\u0010\u0006\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0006\u0010\u0004J\u000f\u0010\u0007\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0007\u0010\u0004J\u000f\u0010\b\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\b\u0010\u0004J\u0017\u0010\u0007\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\tH\u0016¢\u0006\u0004\b\u0007\u0010\u000bJ\u000f\u0010\f\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\f\u0010\u0004"}, d2 = {"Lid/dana/maintenance/EmergencyNotifActivity$getEmergencyNotifModule$1;", "Lid/dana/maintenance/EmergencyNotifContract$View;", "", "MyBillsEntityDataFactory", "()V", "KClassImpl$Data$declaredNonStaticMembers$2", "PlaceComponentResult", "getAuthRequestContext", "BuiltInFictitiousFunctionClassFactory", "Lid/dana/domain/featureconfig/model/EmergencyNotificationConfig;", "p0", "(Lid/dana/domain/featureconfig/model/EmergencyNotificationConfig;)V", "moveToNextValue"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class EmergencyNotifActivity$getEmergencyNotifModule$1 implements EmergencyNotifContract.View {
    final /* synthetic */ EmergencyNotifActivity MyBillsEntityDataFactory;

    @Override // id.dana.base.AbstractContractKt.AbstractView, id.dana.base.AbstractContract.AbstractView
    public final /* synthetic */ void dismissProgress() {
        AbstractContractKt.AbstractView.CC.MyBillsEntityDataFactory();
    }

    @Override // id.dana.base.AbstractContractKt.AbstractView
    public final /* synthetic */ String getErrorSource() {
        return AbstractContractKt.AbstractView.CC.getAuthRequestContext();
    }

    @Override // id.dana.base.AbstractContractKt.AbstractView, id.dana.base.AbstractContract.AbstractView
    public final /* synthetic */ void onError(String str) {
        AbstractContractKt.AbstractView.CC.BuiltInFictitiousFunctionClassFactory();
    }

    @Override // id.dana.base.AbstractContractKt.AbstractView, id.dana.base.AbstractContract.AbstractView
    public final /* synthetic */ void showProgress() {
        AbstractContractKt.AbstractView.CC.PlaceComponentResult();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public EmergencyNotifActivity$getEmergencyNotifModule$1(EmergencyNotifActivity emergencyNotifActivity) {
        this.MyBillsEntityDataFactory = emergencyNotifActivity;
    }

    @Override // id.dana.maintenance.EmergencyNotifContract.View
    public final void PlaceComponentResult() {
        ActivityEmergencyNotifBinding binding;
        int i;
        int i2;
        int i3;
        binding = this.MyBillsEntityDataFactory.getBinding();
        AppCompatTextView appCompatTextView = binding.MyBillsEntityDataFactory;
        Intrinsics.checkNotNullExpressionValue(appCompatTextView, "");
        appCompatTextView.setVisibility(0);
        i = this.MyBillsEntityDataFactory.BuiltInFictitiousFunctionClassFactory;
        if (i >= 2) {
            i2 = this.MyBillsEntityDataFactory.BuiltInFictitiousFunctionClassFactory;
            if (i2 == 2) {
                DANAToast dANAToast = DANAToast.PlaceComponentResult;
                EmergencyNotifActivity emergencyNotifActivity = this.MyBillsEntityDataFactory;
                EmergencyNotifActivity emergencyNotifActivity2 = emergencyNotifActivity;
                String string = emergencyNotifActivity.getResources().getString(R.string.emergency_page_reminder_toast);
                Intrinsics.checkNotNullExpressionValue(string, "");
                DANAToast.MyBillsEntityDataFactory(emergencyNotifActivity2, string);
            }
            EmergencyNotifActivity.access$enableRetryNext(this.MyBillsEntityDataFactory, false);
            return;
        }
        EmergencyNotifActivity emergencyNotifActivity3 = this.MyBillsEntityDataFactory;
        i3 = emergencyNotifActivity3.BuiltInFictitiousFunctionClassFactory;
        emergencyNotifActivity3.BuiltInFictitiousFunctionClassFactory = i3 + 1;
        DANAToast dANAToast2 = DANAToast.PlaceComponentResult;
        EmergencyNotifActivity emergencyNotifActivity4 = this.MyBillsEntityDataFactory;
        EmergencyNotifActivity emergencyNotifActivity5 = emergencyNotifActivity4;
        String string2 = emergencyNotifActivity4.getResources().getString(R.string.emergency_page_reminder_toast);
        Intrinsics.checkNotNullExpressionValue(string2, "");
        DANAToast.MyBillsEntityDataFactory(emergencyNotifActivity5, string2);
    }

    @Override // id.dana.maintenance.EmergencyNotifContract.View
    public final void MyBillsEntityDataFactory() {
        ActivityEmergencyNotifBinding binding;
        ActivityEmergencyNotifBinding binding2;
        binding = this.MyBillsEntityDataFactory.getBinding();
        AppCompatTextView appCompatTextView = binding.MyBillsEntityDataFactory;
        Intrinsics.checkNotNullExpressionValue(appCompatTextView, "");
        appCompatTextView.setVisibility(8);
        EmergencyNotifActivity.access$enableRetryNext(this.MyBillsEntityDataFactory, true);
        binding2 = this.MyBillsEntityDataFactory.getBinding();
        DanaButtonSecondaryView danaButtonSecondaryView = binding2.PlaceComponentResult;
        final EmergencyNotifActivity emergencyNotifActivity = this.MyBillsEntityDataFactory;
        danaButtonSecondaryView.setOnClickListener(new View.OnClickListener() { // from class: id.dana.maintenance.EmergencyNotifActivity$getEmergencyNotifModule$1$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                EmergencyNotifActivity$getEmergencyNotifModule$1.PlaceComponentResult(EmergencyNotifActivity.this);
            }
        });
    }

    @Override // id.dana.maintenance.EmergencyNotifContract.View
    public final void KClassImpl$Data$declaredNonStaticMembers$2() {
        ActivityEmergencyNotifBinding binding;
        binding = this.MyBillsEntityDataFactory.getBinding();
        AppCompatTextView appCompatTextView = binding.MyBillsEntityDataFactory;
        Intrinsics.checkNotNullExpressionValue(appCompatTextView, "");
        appCompatTextView.setVisibility(0);
        EmergencyNotifActivity.access$startDefaultCountdown(this.MyBillsEntityDataFactory);
    }

    @Override // id.dana.maintenance.EmergencyNotifContract.View
    public final void BuiltInFictitiousFunctionClassFactory() {
        ActivityEmergencyNotifBinding binding;
        binding = this.MyBillsEntityDataFactory.getBinding();
        AppCompatTextView appCompatTextView = binding.MyBillsEntityDataFactory;
        Intrinsics.checkNotNullExpressionValue(appCompatTextView, "");
        appCompatTextView.setVisibility(0);
        EmergencyNotifActivity.access$enableRetryNext(this.MyBillsEntityDataFactory, false);
    }

    @Override // id.dana.maintenance.EmergencyNotifContract.View
    public final void getAuthRequestContext() {
        ActivityEmergencyNotifBinding binding;
        ActivityEmergencyNotifBinding binding2;
        binding = this.MyBillsEntityDataFactory.getBinding();
        AppCompatTextView appCompatTextView = binding.MyBillsEntityDataFactory;
        Intrinsics.checkNotNullExpressionValue(appCompatTextView, "");
        appCompatTextView.setVisibility(8);
        EmergencyNotifActivity.access$enableRetryNext(this.MyBillsEntityDataFactory, true);
        binding2 = this.MyBillsEntityDataFactory.getBinding();
        DanaButtonSecondaryView danaButtonSecondaryView = binding2.PlaceComponentResult;
        final EmergencyNotifActivity emergencyNotifActivity = this.MyBillsEntityDataFactory;
        danaButtonSecondaryView.setOnClickListener(new View.OnClickListener() { // from class: id.dana.maintenance.EmergencyNotifActivity$getEmergencyNotifModule$1$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                EmergencyNotifActivity$getEmergencyNotifModule$1.BuiltInFictitiousFunctionClassFactory(EmergencyNotifActivity.this);
            }
        });
    }

    @Override // id.dana.maintenance.EmergencyNotifContract.View
    public final void getAuthRequestContext(EmergencyNotificationConfig p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        this.MyBillsEntityDataFactory.MyBillsEntityDataFactory(p0);
    }

    @Override // id.dana.maintenance.EmergencyNotifContract.View
    public final void moveToNextValue() {
        Intent intent = new Intent(this.MyBillsEntityDataFactory, LocalConfigSplashActivity.class);
        this.MyBillsEntityDataFactory.finish();
        this.MyBillsEntityDataFactory.startActivity(intent);
    }

    public static /* synthetic */ void BuiltInFictitiousFunctionClassFactory(EmergencyNotifActivity emergencyNotifActivity) {
        String str;
        Intrinsics.checkNotNullParameter(emergencyNotifActivity, "");
        EmergencyNotifContract.Presenter presenter = emergencyNotifActivity.getPresenter();
        str = emergencyNotifActivity.KClassImpl$Data$declaredNonStaticMembers$2;
        presenter.PlaceComponentResult(str);
    }

    public static /* synthetic */ void PlaceComponentResult(EmergencyNotifActivity emergencyNotifActivity) {
        String str;
        Intrinsics.checkNotNullParameter(emergencyNotifActivity, "");
        EmergencyNotifContract.Presenter presenter = emergencyNotifActivity.getPresenter();
        str = emergencyNotifActivity.KClassImpl$Data$declaredNonStaticMembers$2;
        presenter.PlaceComponentResult(str);
    }
}
