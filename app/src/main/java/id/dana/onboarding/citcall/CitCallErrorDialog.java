package id.dana.onboarding.citcall;

import android.content.Context;
import android.view.View;
import id.dana.R;
import id.dana.analytics.tracker.TrackerKey;
import id.dana.component.dialogcomponent.CustomDialog;
import id.dana.component.extension.ViewExtKt;
import id.dana.onboarding.track.OnboardingFirebaseTracker;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u000f\u001a\u00020\u0005\u0012\u0006\u0010\u0010\u001a\u00020\b\u0012\u0006\u0010\u0011\u001a\u00020\f¢\u0006\u0004\b\u0012\u0010\u0013J\r\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0003\u0010\u0004R\u0011\u0010\u0006\u001a\u00020\u0005X\u0006¢\u0006\u0006\n\u0004\b\u0006\u0010\u0007R\u0011\u0010\u000b\u001a\u00020\bX\u0006¢\u0006\u0006\n\u0004\b\t\u0010\nR\u0014\u0010\r\u001a\u00020\f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u000e"}, d2 = {"Lid/dana/onboarding/citcall/CitCallErrorDialog;", "", "", "MyBillsEntityDataFactory", "()V", "Landroid/content/Context;", "PlaceComponentResult", "Landroid/content/Context;", "Lid/dana/onboarding/citcall/CitCallDialogState;", "getAuthRequestContext", "Lid/dana/onboarding/citcall/CitCallDialogState;", "BuiltInFictitiousFunctionClassFactory", "Landroid/view/View$OnClickListener;", "KClassImpl$Data$declaredNonStaticMembers$2", "Landroid/view/View$OnClickListener;", "p0", "p1", "p2", "<init>", "(Landroid/content/Context;Lid/dana/onboarding/citcall/CitCallDialogState;Landroid/view/View$OnClickListener;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class CitCallErrorDialog {
    private final View.OnClickListener KClassImpl$Data$declaredNonStaticMembers$2;
    public final Context PlaceComponentResult;

    /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
    public final CitCallDialogState BuiltInFictitiousFunctionClassFactory;

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] getAuthRequestContext;

        static {
            int[] iArr = new int[CitCallDialogState.values().length];
            iArr[CitCallDialogState.RISK_CONSULT.ordinal()] = 1;
            iArr[CitCallDialogState.NETWORK_TIMEOUT.ordinal()] = 2;
            getAuthRequestContext = iArr;
        }
    }

    public CitCallErrorDialog(Context context, CitCallDialogState citCallDialogState, View.OnClickListener onClickListener) {
        Intrinsics.checkNotNullParameter(context, "");
        Intrinsics.checkNotNullParameter(citCallDialogState, "");
        Intrinsics.checkNotNullParameter(onClickListener, "");
        this.PlaceComponentResult = context;
        this.BuiltInFictitiousFunctionClassFactory = citCallDialogState;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = onClickListener;
    }

    public final void MyBillsEntityDataFactory() {
        CustomDialog.Builder builder = new CustomDialog.Builder(this.PlaceComponentResult);
        int i = WhenMappings.getAuthRequestContext[this.BuiltInFictitiousFunctionClassFactory.ordinal()];
        if (i == 1) {
            builder.DatabaseTableConfigUtil = R.drawable.res_0x7f080905_networkuserentitydata_externalsyntheticlambda0;
            builder.SubSequence = builder.BuiltInFictitiousFunctionClassFactory.getString(R.string.citcall_consult_limit_dialog_title);
            builder.GetContactSyncConfig = builder.BuiltInFictitiousFunctionClassFactory.getString(R.string.citcall_consult_limit_dialog_desc);
            String string = builder.BuiltInFictitiousFunctionClassFactory.getString(R.string.citcall_consult_limit_dialog_button);
            Intrinsics.checkNotNullExpressionValue(string, "");
            String upperCase = string.toUpperCase(Locale.ROOT);
            Intrinsics.checkNotNullExpressionValue(upperCase, "");
            View.OnClickListener onClickListener = new View.OnClickListener() { // from class: id.dana.onboarding.citcall.CitCallErrorDialog$$ExternalSyntheticLambda0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    CitCallErrorDialog.PlaceComponentResult(CitCallErrorDialog.this, view);
                }
            };
            builder.NetworkUserEntityData$$ExternalSyntheticLambda6 = upperCase;
            builder.getSupportButtonTintMode = onClickListener;
        } else if (i == 2) {
            builder.DatabaseTableConfigUtil = R.drawable.ic_network_error;
            builder.SubSequence = builder.BuiltInFictitiousFunctionClassFactory.getString(R.string.citcall_timeout_dialog_title);
            builder.GetContactSyncConfig = builder.BuiltInFictitiousFunctionClassFactory.getString(R.string.citcall_timeout_dialog_desc);
            String string2 = builder.BuiltInFictitiousFunctionClassFactory.getString(R.string.citcall_timeout_dialog_button);
            Intrinsics.checkNotNullExpressionValue(string2, "");
            String upperCase2 = string2.toUpperCase(Locale.ROOT);
            Intrinsics.checkNotNullExpressionValue(upperCase2, "");
            View.OnClickListener onClickListener2 = new View.OnClickListener() { // from class: id.dana.onboarding.citcall.CitCallErrorDialog$$ExternalSyntheticLambda0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    CitCallErrorDialog.PlaceComponentResult(CitCallErrorDialog.this, view);
                }
            };
            builder.NetworkUserEntityData$$ExternalSyntheticLambda6 = upperCase2;
            builder.getSupportButtonTintMode = onClickListener2;
        }
        builder.moveToNextValue = 0L;
        builder.KClassImpl$Data$declaredNonStaticMembers$2(true);
        builder.PlaceComponentResult(true);
        builder.BuiltInFictitiousFunctionClassFactory();
        ViewExtKt.getAuthRequestContext(builder.BuiltInFictitiousFunctionClassFactory(), builder.moveToNextValue);
        OnboardingFirebaseTracker onboardingFirebaseTracker = OnboardingFirebaseTracker.INSTANCE;
        OnboardingFirebaseTracker.KClassImpl$Data$declaredNonStaticMembers$2(TrackerKey.Event.USER_INTERACTION_REGISTRATION_CITCALL_OTP_BACKUP_DIALOG);
    }

    public static /* synthetic */ void PlaceComponentResult(CitCallErrorDialog citCallErrorDialog, View view) {
        Intrinsics.checkNotNullParameter(citCallErrorDialog, "");
        citCallErrorDialog.KClassImpl$Data$declaredNonStaticMembers$2.onClick(view);
        OnboardingFirebaseTracker onboardingFirebaseTracker = OnboardingFirebaseTracker.INSTANCE;
        Intrinsics.checkNotNullParameter(TrackerKey.Event.USER_INTERACTION_REGISTRATION_CITCALL_OTP_BACKUP_DIALOG, "");
        OnboardingFirebaseTracker.BuiltInFictitiousFunctionClassFactory(null, TrackerKey.Event.USER_INTERACTION_REGISTRATION_CITCALL_OTP_BACKUP_DIALOG);
    }
}
