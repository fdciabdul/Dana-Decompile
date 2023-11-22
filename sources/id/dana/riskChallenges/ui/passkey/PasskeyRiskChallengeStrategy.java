package id.dana.riskChallenges.ui.passkey;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentResultListener;
import androidx.fragment.app.FragmentTransaction;
import id.dana.core.ui.extension.FragmentExtKt;
import id.dana.riskChallenges.R;
import id.dana.riskChallenges.ui.passkey.PasskeyVerificationFragment;
import id.dana.riskChallenges.ui.passkey.main.EnrollmentMainFragment;
import id.dana.riskChallenges.ui.util.StrategyKey;
import id.dana.riskChallenges.ui.util.strategy.RiskChallengeStrategy;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u0002B1\u0012\u0006\u0010\u0007\u001a\u00020\"\u0012\u0006\u0010\t\u001a\u00020\u0006\u0012\u0006\u0010\u0011\u001a\u00020\u0006\u0012\u0006\u0010#\u001a\u00020\u0006\u0012\b\b\u0002\u0010$\u001a\u00020\b¢\u0006\u0004\b%\u0010&J\u000f\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0004\u0010\u0005J\u001f\u0010\n\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0016¢\u0006\u0004\b\n\u0010\u000bJ]\u0010\u0004\u001a\u00020\u00032\u001a\u0010\u0007\u001a\u0016\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u0003\u0018\u00010\fj\u0004\u0018\u0001`\r2\u001a\u0010\t\u001a\u0016\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u0003\u0018\u00010\fj\u0004\u0018\u0001`\u000e2\u0014\u0010\u0011\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u000fj\u0004\u0018\u0001`\u0010H\u0016¢\u0006\u0004\b\u0004\u0010\u0012R\u0014\u0010\u0014\u001a\u00020\b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010\u0013R$\u0010\u0017\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u000fj\u0004\u0018\u0001`\u00108\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016R*\u0010\u0004\u001a\u0016\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u0003\u0018\u00010\fj\u0004\u0018\u0001`\u000e8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u0014\u0010\u0018\u001a\u00020\u001a8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0014\u0010\u001bR\u0014\u0010\u0015\u001a\u00020\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\u0014\u0010\u001e\u001a\u00020\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001e\u0010\u001dR\u0014\u0010 \u001a\u00020\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001f\u0010\u001dR*\u0010!\u001a\u0016\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u0003\u0018\u00010\fj\u0004\u0018\u0001`\r8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0017\u0010\u0019"}, d2 = {"Lid/dana/riskChallenges/ui/passkey/PasskeyRiskChallengeStrategy;", "Lid/dana/riskChallenges/ui/util/strategy/RiskChallengeStrategy;", "Landroidx/fragment/app/FragmentResultListener;", "", "BuiltInFictitiousFunctionClassFactory", "()V", "", "p0", "Landroid/os/Bundle;", "p1", "onFragmentResult", "(Ljava/lang/String;Landroid/os/Bundle;)V", "Lkotlin/Function1;", "Lid/dana/riskChallenges/ui/util/strategy/SuccessListener;", "Lid/dana/riskChallenges/ui/util/strategy/ErrorListener;", "Lkotlin/Function0;", "Lid/dana/riskChallenges/ui/util/strategy/CancelListener;", "p2", "(Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function0;)V", "Landroid/os/Bundle;", "getAuthRequestContext", "PlaceComponentResult", "Lkotlin/jvm/functions/Function0;", "KClassImpl$Data$declaredNonStaticMembers$2", "MyBillsEntityDataFactory", "Lkotlin/jvm/functions/Function1;", "Landroidx/fragment/app/FragmentManager;", "Landroidx/fragment/app/FragmentManager;", "getErrorConfigVersion", "Ljava/lang/String;", "NetworkUserEntityData$$ExternalSyntheticLambda0", "scheduleImpl", "lookAheadTest", "moveToNextValue", "Landroidx/fragment/app/FragmentActivity;", "p3", "p4", "<init>", "(Landroidx/fragment/app/FragmentActivity;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Landroid/os/Bundle;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class PasskeyRiskChallengeStrategy implements RiskChallengeStrategy, FragmentResultListener {

    /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
    private final Bundle getAuthRequestContext;

    /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
    public Function1<? super Bundle, Unit> moveToNextValue;

    /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
    public Function1<? super Bundle, Unit> BuiltInFictitiousFunctionClassFactory;
    private final String NetworkUserEntityData$$ExternalSyntheticLambda0;

    /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
    public Function0<Unit> KClassImpl$Data$declaredNonStaticMembers$2;

    /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
    private final FragmentManager MyBillsEntityDataFactory;

    /* renamed from: getErrorConfigVersion  reason: from kotlin metadata */
    private final String PlaceComponentResult;

    /* renamed from: scheduleImpl  reason: from kotlin metadata */
    private final String lookAheadTest;

    public PasskeyRiskChallengeStrategy(FragmentActivity fragmentActivity, String str, String str2, String str3, Bundle bundle) {
        Intrinsics.checkNotNullParameter(fragmentActivity, "");
        Intrinsics.checkNotNullParameter(str, "");
        Intrinsics.checkNotNullParameter(str2, "");
        Intrinsics.checkNotNullParameter(str3, "");
        Intrinsics.checkNotNullParameter(bundle, "");
        this.PlaceComponentResult = str;
        this.lookAheadTest = str2;
        this.NetworkUserEntityData$$ExternalSyntheticLambda0 = str3;
        this.getAuthRequestContext = bundle;
        FragmentManager supportFragmentManager = fragmentActivity.getSupportFragmentManager();
        Intrinsics.checkNotNullExpressionValue(supportFragmentManager, "");
        this.MyBillsEntityDataFactory = supportFragmentManager;
    }

    @Override // id.dana.riskChallenges.ui.util.strategy.RiskChallengeStrategy
    public final void BuiltInFictitiousFunctionClassFactory() {
        EnrollmentMainFragment KClassImpl$Data$declaredNonStaticMembers$2;
        EnrollmentMainFragment enrollmentMainFragment;
        if (Intrinsics.areEqual(this.PlaceComponentResult, StrategyKey.PASSKEY_UNLINK)) {
            Function1<? super Bundle, Unit> function1 = this.moveToNextValue;
            if (function1 != null) {
                Bundle bundle = this.getAuthRequestContext;
                bundle.putInt("KEY_RESULT", -1);
                function1.invoke(bundle);
                return;
            }
            return;
        }
        String str = this.PlaceComponentResult;
        if (Intrinsics.areEqual(str, StrategyKey.PASSKEY_AUTHENTICATION)) {
            PasskeyVerificationFragment.Companion companion = PasskeyVerificationFragment.MyBillsEntityDataFactory;
            String string = this.getAuthRequestContext.getString("KEY_SECURITY_ID");
            if (string == null) {
                string = "";
            }
            String string2 = this.getAuthRequestContext.getString("KEY_PHONE_NUMBER");
            if (string2 == null) {
                string2 = "";
            }
            String str2 = this.lookAheadTest;
            String string3 = this.getAuthRequestContext.getString("KEY_FALLBACK_VERIFICATION_METHOD");
            if (string3 == null) {
                string3 = "";
            }
            enrollmentMainFragment = PasskeyVerificationFragment.Companion.MyBillsEntityDataFactory(string, string2, str2, this.NetworkUserEntityData$$ExternalSyntheticLambda0, string3);
        } else if (Intrinsics.areEqual(str, StrategyKey.PASSKEY_REGISTRATION)) {
            EnrollmentMainFragment.Companion companion2 = EnrollmentMainFragment.INSTANCE;
            String str3 = this.lookAheadTest;
            String string4 = this.getAuthRequestContext.getString("KEY_PASSKEY_PAGE_SOURCE");
            if (string4 == null) {
                string4 = "";
            }
            String string5 = this.getAuthRequestContext.getString("KEY_SECURITY_ID");
            if (string5 == null) {
                string5 = "";
            }
            enrollmentMainFragment = EnrollmentMainFragment.Companion.KClassImpl$Data$declaredNonStaticMembers$2(str3, this.NetworkUserEntityData$$ExternalSyntheticLambda0, string4, string5, this.getAuthRequestContext.getBoolean("KEY_NEED_SHOW_VERIFICATION_FRAGMENT", false));
        } else {
            EnrollmentMainFragment.Companion companion3 = EnrollmentMainFragment.INSTANCE;
            String str4 = this.lookAheadTest;
            String string6 = this.getAuthRequestContext.getString("KEY_PASSKEY_PAGE_SOURCE");
            if (string6 == null) {
                string6 = "";
            }
            KClassImpl$Data$declaredNonStaticMembers$2 = EnrollmentMainFragment.Companion.KClassImpl$Data$declaredNonStaticMembers$2(str4, this.NetworkUserEntityData$$ExternalSyntheticLambda0, string6, null, false);
            enrollmentMainFragment = KClassImpl$Data$declaredNonStaticMembers$2;
        }
        FragmentTransaction beginTransaction = this.MyBillsEntityDataFactory.beginTransaction();
        Intrinsics.checkNotNullExpressionValue(beginTransaction, "");
        FragmentExtKt.BuiltInFictitiousFunctionClassFactory(beginTransaction);
        int i = R.id.initRecordTimeStamp;
        Fragment fragment = enrollmentMainFragment;
        if (i == 0) {
            throw new IllegalArgumentException("Must use non-zero containerViewId");
        }
        beginTransaction.KClassImpl$Data$declaredNonStaticMembers$2(i, fragment, null, 2);
        beginTransaction.getAuthRequestContext();
    }

    @Override // id.dana.riskChallenges.ui.util.strategy.RiskChallengeStrategy
    public final void BuiltInFictitiousFunctionClassFactory(Function1<? super Bundle, Unit> p0, Function1<? super Bundle, Unit> p1, Function0<Unit> p2) {
        this.moveToNextValue = p0;
        this.BuiltInFictitiousFunctionClassFactory = p1;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = p2;
    }

    @Override // androidx.fragment.app.FragmentResultListener
    public final void onFragmentResult(String p0, Bundle p1) {
        Intrinsics.checkNotNullParameter(p0, "");
        Intrinsics.checkNotNullParameter(p1, "");
        if (Intrinsics.areEqual("KEY_RISK_CHALLENGE_FRAGMENT", p0)) {
            int i = p1.getInt("KEY_RESULT");
            if (i == -1) {
                Function1<? super Bundle, Unit> function1 = this.moveToNextValue;
                if (function1 != null) {
                    function1.invoke(p1);
                }
            } else if (i == 0) {
                if (p1.getBoolean("KEY_IS_ERROR")) {
                    Function1<? super Bundle, Unit> function12 = this.BuiltInFictitiousFunctionClassFactory;
                    if (function12 != null) {
                        function12.invoke(p1);
                        return;
                    }
                    return;
                }
                Function0<Unit> function0 = this.KClassImpl$Data$declaredNonStaticMembers$2;
                if (function0 != null) {
                    function0.invoke();
                }
            }
        }
    }
}
