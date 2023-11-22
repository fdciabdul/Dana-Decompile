package id.dana.riskChallenges.ui.verifypin;

import android.content.Intent;
import android.os.Bundle;
import androidx.core.os.BundleKt;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.view.result.ActivityResultLauncher;
import id.dana.riskChallenges.ui.RiskChallengeActivity;
import id.dana.riskChallenges.ui.resetpin.model.UseCaseStrategy;
import id.dana.riskChallenges.ui.util.StrategyKey;
import id.dana.riskChallenges.ui.util.strategy.BaseLauncher;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\u0018\u00002\u00020\u0001:\u0001\u000fB\t\b\u0002¢\u0006\u0004\b\u000e\u0010\u0004J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0005\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0005\u0010\u0004R \u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006@BX\u0080\n¢\u0006\u0006\n\u0004\b\u0003\u0010\bR \u0010\u0003\u001a\u0004\u0018\u00010\t2\b\u0010\u0007\u001a\u0004\u0018\u00010\t@BX\u0080\n¢\u0006\u0006\n\u0004\b\n\u0010\u000bR \u0010\r\u001a\u0004\u0018\u00010\t2\b\u0010\u0007\u001a\u0004\u0018\u00010\t@BX\u0080\n¢\u0006\u0006\n\u0004\b\f\u0010\u000b"}, d2 = {"Lid/dana/riskChallenges/ui/verifypin/VerifyPinLauncher;", "Lid/dana/riskChallenges/ui/util/strategy/BaseLauncher;", "", "BuiltInFictitiousFunctionClassFactory", "()V", "KClassImpl$Data$declaredNonStaticMembers$2", "Lid/dana/riskChallenges/ui/resetpin/model/UseCaseStrategy;", "p0", "Lid/dana/riskChallenges/ui/resetpin/model/UseCaseStrategy;", "", "PlaceComponentResult", "Ljava/lang/String;", "getAuthRequestContext", "MyBillsEntityDataFactory", "<init>", "Builder"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class VerifyPinLauncher extends BaseLauncher {

    /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
    public UseCaseStrategy KClassImpl$Data$declaredNonStaticMembers$2;

    /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
    public String BuiltInFictitiousFunctionClassFactory;

    /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
    public String MyBillsEntityDataFactory;

    public /* synthetic */ VerifyPinLauncher(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    private VerifyPinLauncher() {
    }

    @Override // id.dana.riskChallenges.ui.util.strategy.RiskChallengeStrategy
    public final void BuiltInFictitiousFunctionClassFactory() {
        KClassImpl$Data$declaredNonStaticMembers$2();
    }

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0011\b\u0016\u0012\u0006\u0010\r\u001a\u00020\f¢\u0006\u0004\b\u000e\u0010\u000fB\u0011\b\u0016\u0012\u0006\u0010\r\u001a\u00020\u0010¢\u0006\u0004\b\u000e\u0010\u0011R\u0012\u0010\u0006\u001a\u00020\u0003X\u0096\u0002¢\u0006\u0006\n\u0004\b\u0004\u0010\u0005R\u0018\u0010\t\u001a\u0004\u0018\u00010\u00078\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0006\u0010\bR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\n\u0010\u0005R\u0018\u0010\u000b\u001a\u0004\u0018\u00010\u00038\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\t\u0010\u0005"}, d2 = {"Lid/dana/riskChallenges/ui/verifypin/VerifyPinLauncher$Builder;", "Lid/dana/riskChallenges/ui/util/strategy/BaseLauncher$BaseBuilder;", "Lid/dana/riskChallenges/ui/verifypin/VerifyPinLauncher;", "", "BuiltInFictitiousFunctionClassFactory", "Ljava/lang/String;", "MyBillsEntityDataFactory", "Lid/dana/riskChallenges/ui/resetpin/model/UseCaseStrategy;", "Lid/dana/riskChallenges/ui/resetpin/model/UseCaseStrategy;", "PlaceComponentResult", "KClassImpl$Data$declaredNonStaticMembers$2", "getAuthRequestContext", "Landroidx/fragment/app/FragmentActivity;", "p0", "<init>", "(Landroidx/fragment/app/FragmentActivity;)V", "Landroidx/fragment/app/Fragment;", "(Landroidx/fragment/app/Fragment;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class Builder extends BaseLauncher.BaseBuilder<VerifyPinLauncher> {

        /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
        public String MyBillsEntityDataFactory;

        /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
        public String BuiltInFictitiousFunctionClassFactory;

        /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
        public UseCaseStrategy PlaceComponentResult;

        /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
        public String getAuthRequestContext;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Builder(FragmentActivity fragmentActivity) {
            super(fragmentActivity);
            Intrinsics.checkNotNullParameter(fragmentActivity, "");
            this.MyBillsEntityDataFactory = StrategyKey.VERIFY_PIN;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Builder(Fragment fragment) {
            super(fragment);
            Intrinsics.checkNotNullParameter(fragment, "");
            this.MyBillsEntityDataFactory = StrategyKey.VERIFY_PIN;
        }

        @Override // id.dana.riskChallenges.ui.util.strategy.BaseLauncher.BaseBuilder
        public final /* synthetic */ VerifyPinLauncher KClassImpl$Data$declaredNonStaticMembers$2() {
            VerifyPinLauncher verifyPinLauncher = new VerifyPinLauncher(null);
            verifyPinLauncher.NetworkUserEntityData$$ExternalSyntheticLambda0 = getNetworkUserEntityData$$ExternalSyntheticLambda0();
            verifyPinLauncher.getAuthRequestContext = getBuiltInFictitiousFunctionClassFactory();
            verifyPinLauncher.DatabaseTableConfigUtil = this.MyBillsEntityDataFactory;
            verifyPinLauncher.NetworkUserEntityData$$ExternalSyntheticLambda2 = this.scheduleImpl;
            Function1<? super Bundle, Unit> function1 = this.getErrorConfigVersion;
            Function1<? super Bundle, Unit> function12 = this.PlaceComponentResult;
            Function0<Unit> function0 = this.KClassImpl$Data$declaredNonStaticMembers$2;
            verifyPinLauncher.GetContactSyncConfig = function1;
            verifyPinLauncher.moveToNextValue = function12;
            verifyPinLauncher.MyBillsEntityDataFactory = function0;
            Function0<Unit> function02 = this.MyBillsEntityDataFactory;
            Intrinsics.checkNotNullParameter(function02, "");
            verifyPinLauncher.getErrorConfigVersion = function02;
            verifyPinLauncher.KClassImpl$Data$declaredNonStaticMembers$2 = this.PlaceComponentResult;
            verifyPinLauncher.MyBillsEntityDataFactory = this.getAuthRequestContext;
            verifyPinLauncher.BuiltInFictitiousFunctionClassFactory = this.BuiltInFictitiousFunctionClassFactory;
            return verifyPinLauncher;
        }
    }

    private final void KClassImpl$Data$declaredNonStaticMembers$2() {
        ActivityResultLauncher<Intent> activityResultLauncher = this.BuiltInFictitiousFunctionClassFactory;
        if (activityResultLauncher != null) {
            Intent intent = new Intent(getErrorConfigVersion(), RiskChallengeActivity.class);
            intent.putExtras(BundleKt.PlaceComponentResult(TuplesKt.to("KEY_STRATEGY", this.DatabaseTableConfigUtil), TuplesKt.to("KEY_SCENE", this.MyBillsEntityDataFactory), TuplesKt.to("KEY_USE_CASE_STRATEGY", this.KClassImpl$Data$declaredNonStaticMembers$2), TuplesKt.to("KEY_UI_COMPONENT", this.NetworkUserEntityData$$ExternalSyntheticLambda2), TuplesKt.to("KEY_SOURCE", this.BuiltInFictitiousFunctionClassFactory)));
            activityResultLauncher.MyBillsEntityDataFactory(intent, null);
        }
    }
}
