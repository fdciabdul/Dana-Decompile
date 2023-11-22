package id.dana.riskChallenges.ui.verifypin;

import android.os.Bundle;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentResultListener;
import androidx.fragment.app.FragmentTransaction;
import id.dana.core.ui.extension.FragmentExtKt;
import id.dana.riskChallenges.R;
import id.dana.riskChallenges.ui.resetpin.model.UseCaseStrategy;
import id.dana.riskChallenges.ui.util.strategy.RiskChallengeStrategy;
import id.dana.riskChallenges.ui.util.uicomponent.UIComponentType;
import id.dana.riskChallenges.ui.util.uicomponent.UiComponent;
import id.dana.riskChallenges.ui.verifypin.VerifyPinFragment;
import id.dana.riskChallenges.ui.verifypin.dialog.VerifyPinBottomSheetFragment;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 *2\u00020\u00012\u00020\u0002:\u0001*B=\u0012\u0006\u0010\u0007\u001a\u00020\u0013\u0012\u0006\u0010\t\u001a\u00020\u001d\u0012\u0006\u0010\u0011\u001a\u00020\u0006\u0012\b\u0010%\u001a\u0004\u0018\u00010!\u0012\b\b\u0002\u0010&\u001a\u00020\u0006\u0012\b\b\u0002\u0010'\u001a\u00020\u0006¢\u0006\u0004\b(\u0010)J\u000f\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0004\u0010\u0005J\u001f\u0010\n\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0016¢\u0006\u0004\b\n\u0010\u000bJ]\u0010\u0004\u001a\u00020\u00032\u001a\u0010\u0007\u001a\u0016\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u0003\u0018\u00010\fj\u0004\u0018\u0001`\r2\u001a\u0010\t\u001a\u0016\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u0003\u0018\u00010\fj\u0004\u0018\u0001`\u000e2\u0014\u0010\u0011\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u000fj\u0004\u0018\u0001`\u0010H\u0016¢\u0006\u0004\b\u0004\u0010\u0012R\u0014\u0010\u0014\u001a\u00020\u00138\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015R$\u0010\u0004\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u000fj\u0004\u0018\u0001`\u00108\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017R*\u0010\u001a\u001a\u0016\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u0003\u0018\u00010\fj\u0004\u0018\u0001`\u000e8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u0014\u0010\u0018\u001a\u00020\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010\u001bR\u0014\u0010\u0016\u001a\u00020\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001c\u0010\u001bR\u0014\u0010 \u001a\u00020\u001d8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001e\u0010\u001fR*\u0010\u001e\u001a\u0016\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u0003\u0018\u00010\fj\u0004\u0018\u0001`\r8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001a\u0010\u0019R\u0016\u0010\u001c\u001a\u0004\u0018\u00010!8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\"\u0010#R\u0014\u0010$\u001a\u00020\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b \u0010\u001b"}, d2 = {"Lid/dana/riskChallenges/ui/verifypin/VerifyPinChallengeStrategy;", "Lid/dana/riskChallenges/ui/util/strategy/RiskChallengeStrategy;", "Landroidx/fragment/app/FragmentResultListener;", "", "BuiltInFictitiousFunctionClassFactory", "()V", "", "p0", "Landroid/os/Bundle;", "p1", "onFragmentResult", "(Ljava/lang/String;Landroid/os/Bundle;)V", "Lkotlin/Function1;", "Lid/dana/riskChallenges/ui/util/strategy/SuccessListener;", "Lid/dana/riskChallenges/ui/util/strategy/ErrorListener;", "Lkotlin/Function0;", "Lid/dana/riskChallenges/ui/util/strategy/CancelListener;", "p2", "(Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function0;)V", "Landroidx/fragment/app/FragmentActivity;", "MyBillsEntityDataFactory", "Landroidx/fragment/app/FragmentActivity;", "getAuthRequestContext", "Lkotlin/jvm/functions/Function0;", "PlaceComponentResult", "Lkotlin/jvm/functions/Function1;", "KClassImpl$Data$declaredNonStaticMembers$2", "Ljava/lang/String;", "scheduleImpl", "Lid/dana/riskChallenges/ui/resetpin/model/UseCaseStrategy;", "NetworkUserEntityData$$ExternalSyntheticLambda0", "Lid/dana/riskChallenges/ui/resetpin/model/UseCaseStrategy;", "getErrorConfigVersion", "Lid/dana/riskChallenges/ui/util/uicomponent/UiComponent;", "lookAheadTest", "Lid/dana/riskChallenges/ui/util/uicomponent/UiComponent;", "moveToNextValue", "p3", "p4", "p5", "<init>", "(Landroidx/fragment/app/FragmentActivity;Lid/dana/riskChallenges/ui/resetpin/model/UseCaseStrategy;Ljava/lang/String;Lid/dana/riskChallenges/ui/util/uicomponent/UiComponent;Ljava/lang/String;Ljava/lang/String;)V", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class VerifyPinChallengeStrategy implements RiskChallengeStrategy, FragmentResultListener {

    /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
    private final String PlaceComponentResult;

    /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
    Function1<? super Bundle, Unit> NetworkUserEntityData$$ExternalSyntheticLambda0;
    private final FragmentActivity MyBillsEntityDataFactory;

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda0  reason: from kotlin metadata */
    private final UseCaseStrategy getErrorConfigVersion;

    /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
    Function1<? super Bundle, Unit> KClassImpl$Data$declaredNonStaticMembers$2;

    /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
    Function0<Unit> BuiltInFictitiousFunctionClassFactory;

    /* renamed from: getErrorConfigVersion  reason: from kotlin metadata */
    private final String moveToNextValue;

    /* renamed from: lookAheadTest  reason: from kotlin metadata */
    private final UiComponent scheduleImpl;

    /* renamed from: scheduleImpl  reason: from kotlin metadata */
    private final String getAuthRequestContext;

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] KClassImpl$Data$declaredNonStaticMembers$2;

        static {
            int[] iArr = new int[UIComponentType.values().length];
            iArr[UIComponentType.BottomSheet.ordinal()] = 1;
            KClassImpl$Data$declaredNonStaticMembers$2 = iArr;
        }
    }

    public VerifyPinChallengeStrategy(FragmentActivity fragmentActivity, UseCaseStrategy useCaseStrategy, String str, UiComponent uiComponent, String str2, String str3) {
        Intrinsics.checkNotNullParameter(fragmentActivity, "");
        Intrinsics.checkNotNullParameter(useCaseStrategy, "");
        Intrinsics.checkNotNullParameter(str, "");
        Intrinsics.checkNotNullParameter(str2, "");
        Intrinsics.checkNotNullParameter(str3, "");
        this.MyBillsEntityDataFactory = fragmentActivity;
        this.getErrorConfigVersion = useCaseStrategy;
        this.moveToNextValue = str;
        this.scheduleImpl = uiComponent;
        this.getAuthRequestContext = str2;
        this.PlaceComponentResult = str3;
    }

    public /* synthetic */ VerifyPinChallengeStrategy(FragmentActivity fragmentActivity, UseCaseStrategy useCaseStrategy, String str, UiComponent uiComponent, String str2, String str3, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(fragmentActivity, useCaseStrategy, str, uiComponent, (i & 16) != 0 ? "" : str2, (i & 32) != 0 ? "" : str3);
    }

    @Override // id.dana.riskChallenges.ui.util.strategy.RiskChallengeStrategy
    public final void BuiltInFictitiousFunctionClassFactory() {
        FragmentManager supportFragmentManager = this.MyBillsEntityDataFactory.getSupportFragmentManager();
        Intrinsics.checkNotNullExpressionValue(supportFragmentManager, "");
        UiComponent uiComponent = this.scheduleImpl;
        UIComponentType uIComponentType = uiComponent != null ? uiComponent.getAuthRequestContext : null;
        if ((uIComponentType == null ? -1 : WhenMappings.KClassImpl$Data$declaredNonStaticMembers$2[uIComponentType.ordinal()]) == 1) {
            VerifyPinBottomSheetFragment.Companion companion = VerifyPinBottomSheetFragment.INSTANCE;
            VerifyPinBottomSheetFragment authRequestContext = VerifyPinBottomSheetFragment.Companion.getAuthRequestContext(this.getErrorConfigVersion.getAuthRequestContext, this.moveToNextValue, this.getAuthRequestContext, this.PlaceComponentResult, this.scheduleImpl);
            FragmentTransaction beginTransaction = supportFragmentManager.beginTransaction();
            Intrinsics.checkNotNullExpressionValue(beginTransaction, "");
            beginTransaction.KClassImpl$Data$declaredNonStaticMembers$2(0, authRequestContext, "VERIFY_PIN_BOTTOM_SHEET_FRAGMENT_TAG", 1);
            beginTransaction.getAuthRequestContext();
            return;
        }
        VerifyPinFragment.Companion companion2 = VerifyPinFragment.INSTANCE;
        VerifyPinFragment authRequestContext2 = VerifyPinFragment.Companion.getAuthRequestContext(this.getErrorConfigVersion.getAuthRequestContext, this.moveToNextValue, this.getAuthRequestContext, this.PlaceComponentResult, this.scheduleImpl);
        FragmentTransaction beginTransaction2 = supportFragmentManager.beginTransaction();
        Intrinsics.checkNotNullExpressionValue(beginTransaction2, "");
        FragmentExtKt.BuiltInFictitiousFunctionClassFactory(beginTransaction2);
        int i = R.id.initRecordTimeStamp;
        VerifyPinFragment verifyPinFragment = authRequestContext2;
        if (i == 0) {
            throw new IllegalArgumentException("Must use non-zero containerViewId");
        }
        beginTransaction2.KClassImpl$Data$declaredNonStaticMembers$2(i, verifyPinFragment, null, 2);
        beginTransaction2.getAuthRequestContext();
    }

    @Override // id.dana.riskChallenges.ui.util.strategy.RiskChallengeStrategy
    public final void BuiltInFictitiousFunctionClassFactory(Function1<? super Bundle, Unit> p0, Function1<? super Bundle, Unit> p1, Function0<Unit> p2) {
        this.NetworkUserEntityData$$ExternalSyntheticLambda0 = p0;
        this.BuiltInFictitiousFunctionClassFactory = p2;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = p1;
    }

    @Override // androidx.fragment.app.FragmentResultListener
    public final void onFragmentResult(String p0, Bundle p1) {
        Intrinsics.checkNotNullParameter(p0, "");
        Intrinsics.checkNotNullParameter(p1, "");
        if (Intrinsics.areEqual("KEY_RISK_CHALLENGE_FRAGMENT", p0)) {
            int i = p1.getInt("KEY_RESULT");
            if (i == -1) {
                Function1<? super Bundle, Unit> function1 = this.NetworkUserEntityData$$ExternalSyntheticLambda0;
                if (function1 != null) {
                    function1.invoke(p1);
                }
            } else if (i == 0) {
                if (p1.getBoolean("KEY_IS_ERROR")) {
                    Function1<? super Bundle, Unit> function12 = this.KClassImpl$Data$declaredNonStaticMembers$2;
                    if (function12 != null) {
                        function12.invoke(p1);
                        return;
                    }
                    return;
                }
                Function0<Unit> function0 = this.BuiltInFictitiousFunctionClassFactory;
                if (function0 != null) {
                    function0.invoke();
                }
            }
        }
    }
}
