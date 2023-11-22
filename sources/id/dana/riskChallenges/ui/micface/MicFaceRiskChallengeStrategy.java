package id.dana.riskChallenges.ui.micface;

import android.os.Bundle;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentResultListener;
import androidx.fragment.app.FragmentTransaction;
import id.dana.core.ui.extension.FragmentExtKt;
import id.dana.riskChallenges.R;
import id.dana.riskChallenges.ui.micface.MicFaceFragment;
import id.dana.riskChallenges.ui.util.model.TrackerModel;
import id.dana.riskChallenges.ui.util.strategy.RiskChallengeStrategy;
import id.dana.riskChallenges.ui.util.uicomponent.UiComponent;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u00012\u00020\u0002B1\u0012\u0006\u0010\u0007\u001a\u00020\u0013\u0012\u0006\u0010\t\u001a\u00020\u0006\u0012\b\u0010\u0011\u001a\u0004\u0018\u00010 \u0012\u0006\u0010$\u001a\u00020\u0006\u0012\u0006\u0010%\u001a\u00020\u001e¢\u0006\u0004\b&\u0010'J\u000f\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0004\u0010\u0005J\u001f\u0010\n\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0016¢\u0006\u0004\b\n\u0010\u000bJ]\u0010\u0004\u001a\u00020\u00032\u001a\u0010\u0007\u001a\u0016\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u0003\u0018\u00010\fj\u0004\u0018\u0001`\r2\u001a\u0010\t\u001a\u0016\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u0003\u0018\u00010\fj\u0004\u0018\u0001`\u000e2\u0014\u0010\u0011\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u000fj\u0004\u0018\u0001`\u0010H\u0016¢\u0006\u0004\b\u0004\u0010\u0012R\u0014\u0010\u0004\u001a\u00020\u00138\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015R$\u0010\u0018\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u000fj\u0004\u0018\u0001`\u00108\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017R*\u0010\u0014\u001a\u0016\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u0003\u0018\u00010\fj\u0004\u0018\u0001`\u000e8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u0014\u0010\u0019\u001a\u00020\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0018\u0010\u001bR\u0014\u0010\u0016\u001a\u00020\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010\u001bR*\u0010\u001d\u001a\u0016\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u0003\u0018\u00010\fj\u0004\u0018\u0001`\r8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001c\u0010\u001aR\u0014\u0010\u001c\u001a\u00020\u001e8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001d\u0010\u001fR\u0016\u0010#\u001a\u0004\u0018\u00010 8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b!\u0010\""}, d2 = {"Lid/dana/riskChallenges/ui/micface/MicFaceRiskChallengeStrategy;", "Lid/dana/riskChallenges/ui/util/strategy/RiskChallengeStrategy;", "Landroidx/fragment/app/FragmentResultListener;", "", "BuiltInFictitiousFunctionClassFactory", "()V", "", "p0", "Landroid/os/Bundle;", "p1", "onFragmentResult", "(Ljava/lang/String;Landroid/os/Bundle;)V", "Lkotlin/Function1;", "Lid/dana/riskChallenges/ui/util/strategy/SuccessListener;", "Lid/dana/riskChallenges/ui/util/strategy/ErrorListener;", "Lkotlin/Function0;", "Lid/dana/riskChallenges/ui/util/strategy/CancelListener;", "p2", "(Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function0;)V", "Landroidx/fragment/app/FragmentActivity;", "PlaceComponentResult", "Landroidx/fragment/app/FragmentActivity;", "getAuthRequestContext", "Lkotlin/jvm/functions/Function0;", "MyBillsEntityDataFactory", "KClassImpl$Data$declaredNonStaticMembers$2", "Lkotlin/jvm/functions/Function1;", "Ljava/lang/String;", "scheduleImpl", "NetworkUserEntityData$$ExternalSyntheticLambda0", "Lid/dana/riskChallenges/ui/util/model/TrackerModel;", "Lid/dana/riskChallenges/ui/util/model/TrackerModel;", "Lid/dana/riskChallenges/ui/util/uicomponent/UiComponent;", "lookAheadTest", "Lid/dana/riskChallenges/ui/util/uicomponent/UiComponent;", "moveToNextValue", "p3", "p4", "<init>", "(Landroidx/fragment/app/FragmentActivity;Ljava/lang/String;Lid/dana/riskChallenges/ui/util/uicomponent/UiComponent;Ljava/lang/String;Lid/dana/riskChallenges/ui/util/model/TrackerModel;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class MicFaceRiskChallengeStrategy implements RiskChallengeStrategy, FragmentResultListener {

    /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
    private final String getAuthRequestContext;

    /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
    private Function1<? super Bundle, Unit> PlaceComponentResult;

    /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
    private final String KClassImpl$Data$declaredNonStaticMembers$2;

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda0  reason: from kotlin metadata */
    private final TrackerModel scheduleImpl;

    /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
    private final FragmentActivity BuiltInFictitiousFunctionClassFactory;

    /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
    private Function0<Unit> MyBillsEntityDataFactory;

    /* renamed from: lookAheadTest  reason: from kotlin metadata */
    private final UiComponent moveToNextValue;

    /* renamed from: scheduleImpl  reason: from kotlin metadata */
    private Function1<? super Bundle, Unit> NetworkUserEntityData$$ExternalSyntheticLambda0;

    public MicFaceRiskChallengeStrategy(FragmentActivity fragmentActivity, String str, UiComponent uiComponent, String str2, TrackerModel trackerModel) {
        Intrinsics.checkNotNullParameter(fragmentActivity, "");
        Intrinsics.checkNotNullParameter(str, "");
        Intrinsics.checkNotNullParameter(str2, "");
        Intrinsics.checkNotNullParameter(trackerModel, "");
        this.BuiltInFictitiousFunctionClassFactory = fragmentActivity;
        this.getAuthRequestContext = str;
        this.moveToNextValue = uiComponent;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = str2;
        this.scheduleImpl = trackerModel;
    }

    @Override // id.dana.riskChallenges.ui.util.strategy.RiskChallengeStrategy
    public final void BuiltInFictitiousFunctionClassFactory() {
        FragmentManager supportFragmentManager = this.BuiltInFictitiousFunctionClassFactory.getSupportFragmentManager();
        Intrinsics.checkNotNullExpressionValue(supportFragmentManager, "");
        MicFaceFragment.Companion companion = MicFaceFragment.INSTANCE;
        MicFaceFragment authRequestContext = MicFaceFragment.Companion.getAuthRequestContext(this.getAuthRequestContext, this.moveToNextValue, this.KClassImpl$Data$declaredNonStaticMembers$2, this.scheduleImpl);
        FragmentTransaction beginTransaction = supportFragmentManager.beginTransaction();
        Intrinsics.checkNotNullExpressionValue(beginTransaction, "");
        FragmentExtKt.BuiltInFictitiousFunctionClassFactory(beginTransaction);
        int i = R.id.initRecordTimeStamp;
        MicFaceFragment micFaceFragment = authRequestContext;
        if (i == 0) {
            throw new IllegalArgumentException("Must use non-zero containerViewId");
        }
        beginTransaction.KClassImpl$Data$declaredNonStaticMembers$2(i, micFaceFragment, null, 2);
        beginTransaction.getAuthRequestContext();
    }

    @Override // id.dana.riskChallenges.ui.util.strategy.RiskChallengeStrategy
    public final void BuiltInFictitiousFunctionClassFactory(Function1<? super Bundle, Unit> p0, Function1<? super Bundle, Unit> p1, Function0<Unit> p2) {
        this.NetworkUserEntityData$$ExternalSyntheticLambda0 = p0;
        this.MyBillsEntityDataFactory = p2;
        this.PlaceComponentResult = p1;
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
                    Function1<? super Bundle, Unit> function12 = this.PlaceComponentResult;
                    if (function12 != null) {
                        function12.invoke(p1);
                        return;
                    }
                    return;
                }
                Function0<Unit> function0 = this.MyBillsEntityDataFactory;
                if (function0 != null) {
                    function0.invoke();
                }
            }
        }
    }
}
