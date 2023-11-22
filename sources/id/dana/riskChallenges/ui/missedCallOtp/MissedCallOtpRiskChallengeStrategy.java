package id.dana.riskChallenges.ui.missedCallOtp;

import android.os.Bundle;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentResultListener;
import androidx.fragment.app.FragmentTransaction;
import id.dana.core.ui.extension.FragmentExtKt;
import id.dana.riskChallenges.R;
import id.dana.riskChallenges.ui.missedCallOtp.MissedCallOtpFragment;
import id.dana.riskChallenges.ui.util.model.TrackerModel;
import id.dana.riskChallenges.ui.util.strategy.RiskChallengeStrategy;
import id.dana.riskChallenges.ui.util.uicomponent.UiComponent;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u00012\u00020\u0002BC\u0012\u0006\u0010\u0007\u001a\u00020\u0013\u0012\u0006\u0010\t\u001a\u00020\u0006\u0012\u0006\u0010\u0011\u001a\u00020\u0006\u0012\b\u0010%\u001a\u0004\u0018\u00010\"\u0012\u0006\u0010&\u001a\u00020\u0006\u0012\b\u0010'\u001a\u0004\u0018\u00010\u0006\u0012\u0006\u0010(\u001a\u00020 ¢\u0006\u0004\b)\u0010*J\u000f\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0004\u0010\u0005J\u001f\u0010\n\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0016¢\u0006\u0004\b\n\u0010\u000bJ]\u0010\u0004\u001a\u00020\u00032\u001a\u0010\u0007\u001a\u0016\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u0003\u0018\u00010\fj\u0004\u0018\u0001`\r2\u001a\u0010\t\u001a\u0016\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u0003\u0018\u00010\fj\u0004\u0018\u0001`\u000e2\u0014\u0010\u0011\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u000fj\u0004\u0018\u0001`\u0010H\u0016¢\u0006\u0004\b\u0004\u0010\u0012R\u0014\u0010\u0016\u001a\u00020\u00138\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015R$\u0010\u0019\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u000fj\u0004\u0018\u0001`\u00108\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0017\u0010\u0018R*\u0010\u0017\u001a\u0016\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u0003\u0018\u00010\fj\u0004\u0018\u0001`\u000e8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u0014\u0010\u0004\u001a\u00020\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010\u001bR\u0016\u0010\u0014\u001a\u0004\u0018\u00010\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0016\u0010\u001bR\u0014\u0010\u001d\u001a\u00020\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001c\u0010\u001bR\u0014\u0010\u001f\u001a\u00020\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001e\u0010\u001bR*\u0010\u001c\u001a\u0016\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u0003\u0018\u00010\fj\u0004\u0018\u0001`\r8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001d\u0010\u001aR\u0014\u0010\u001e\u001a\u00020 8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001f\u0010!R\u0016\u0010#\u001a\u0004\u0018\u00010\"8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b#\u0010$"}, d2 = {"Lid/dana/riskChallenges/ui/missedCallOtp/MissedCallOtpRiskChallengeStrategy;", "Lid/dana/riskChallenges/ui/util/strategy/RiskChallengeStrategy;", "Landroidx/fragment/app/FragmentResultListener;", "", "BuiltInFictitiousFunctionClassFactory", "()V", "", "p0", "Landroid/os/Bundle;", "p1", "onFragmentResult", "(Ljava/lang/String;Landroid/os/Bundle;)V", "Lkotlin/Function1;", "Lid/dana/riskChallenges/ui/util/strategy/SuccessListener;", "Lid/dana/riskChallenges/ui/util/strategy/ErrorListener;", "Lkotlin/Function0;", "Lid/dana/riskChallenges/ui/util/strategy/CancelListener;", "p2", "(Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function0;)V", "Landroidx/fragment/app/FragmentActivity;", "getAuthRequestContext", "Landroidx/fragment/app/FragmentActivity;", "PlaceComponentResult", "MyBillsEntityDataFactory", "Lkotlin/jvm/functions/Function0;", "KClassImpl$Data$declaredNonStaticMembers$2", "Lkotlin/jvm/functions/Function1;", "Ljava/lang/String;", "moveToNextValue", "lookAheadTest", "NetworkUserEntityData$$ExternalSyntheticLambda0", "scheduleImpl", "Lid/dana/riskChallenges/ui/util/model/TrackerModel;", "Lid/dana/riskChallenges/ui/util/model/TrackerModel;", "Lid/dana/riskChallenges/ui/util/uicomponent/UiComponent;", "getErrorConfigVersion", "Lid/dana/riskChallenges/ui/util/uicomponent/UiComponent;", "p3", "p4", "p5", "p6", "<init>", "(Landroidx/fragment/app/FragmentActivity;Ljava/lang/String;Ljava/lang/String;Lid/dana/riskChallenges/ui/util/uicomponent/UiComponent;Ljava/lang/String;Ljava/lang/String;Lid/dana/riskChallenges/ui/util/model/TrackerModel;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class MissedCallOtpRiskChallengeStrategy implements RiskChallengeStrategy, FragmentResultListener {
    private final String BuiltInFictitiousFunctionClassFactory;

    /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
    private Function1<? super Bundle, Unit> MyBillsEntityDataFactory;

    /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
    private Function0<Unit> KClassImpl$Data$declaredNonStaticMembers$2;

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda0  reason: from kotlin metadata */
    private final String scheduleImpl;

    /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
    private final String getAuthRequestContext;

    /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
    private final FragmentActivity PlaceComponentResult;
    private final UiComponent getErrorConfigVersion;

    /* renamed from: lookAheadTest  reason: from kotlin metadata */
    private Function1<? super Bundle, Unit> moveToNextValue;

    /* renamed from: moveToNextValue  reason: from kotlin metadata */
    private final String lookAheadTest;

    /* renamed from: scheduleImpl  reason: from kotlin metadata */
    private final TrackerModel NetworkUserEntityData$$ExternalSyntheticLambda0;

    public MissedCallOtpRiskChallengeStrategy(FragmentActivity fragmentActivity, String str, String str2, UiComponent uiComponent, String str3, String str4, TrackerModel trackerModel) {
        Intrinsics.checkNotNullParameter(fragmentActivity, "");
        Intrinsics.checkNotNullParameter(str, "");
        Intrinsics.checkNotNullParameter(str2, "");
        Intrinsics.checkNotNullParameter(str3, "");
        Intrinsics.checkNotNullParameter(trackerModel, "");
        this.PlaceComponentResult = fragmentActivity;
        this.BuiltInFictitiousFunctionClassFactory = str;
        this.lookAheadTest = str2;
        this.getErrorConfigVersion = uiComponent;
        this.scheduleImpl = str3;
        this.getAuthRequestContext = str4;
        this.NetworkUserEntityData$$ExternalSyntheticLambda0 = trackerModel;
    }

    @Override // id.dana.riskChallenges.ui.util.strategy.RiskChallengeStrategy
    public final void BuiltInFictitiousFunctionClassFactory() {
        FragmentManager supportFragmentManager = this.PlaceComponentResult.getSupportFragmentManager();
        Intrinsics.checkNotNullExpressionValue(supportFragmentManager, "");
        MissedCallOtpFragment.Companion companion = MissedCallOtpFragment.MyBillsEntityDataFactory;
        MissedCallOtpFragment authRequestContext = MissedCallOtpFragment.Companion.getAuthRequestContext(this.BuiltInFictitiousFunctionClassFactory, this.lookAheadTest, this.getErrorConfigVersion, this.scheduleImpl, this.getAuthRequestContext, this.NetworkUserEntityData$$ExternalSyntheticLambda0);
        FragmentTransaction beginTransaction = supportFragmentManager.beginTransaction();
        Intrinsics.checkNotNullExpressionValue(beginTransaction, "");
        FragmentExtKt.BuiltInFictitiousFunctionClassFactory(beginTransaction);
        int i = R.id.initRecordTimeStamp;
        MissedCallOtpFragment missedCallOtpFragment = authRequestContext;
        if (i == 0) {
            throw new IllegalArgumentException("Must use non-zero containerViewId");
        }
        beginTransaction.KClassImpl$Data$declaredNonStaticMembers$2(i, missedCallOtpFragment, null, 2);
        beginTransaction.getAuthRequestContext();
    }

    @Override // id.dana.riskChallenges.ui.util.strategy.RiskChallengeStrategy
    public final void BuiltInFictitiousFunctionClassFactory(Function1<? super Bundle, Unit> p0, Function1<? super Bundle, Unit> p1, Function0<Unit> p2) {
        this.moveToNextValue = p0;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = p2;
        this.MyBillsEntityDataFactory = p1;
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
                    Function1<? super Bundle, Unit> function12 = this.MyBillsEntityDataFactory;
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
