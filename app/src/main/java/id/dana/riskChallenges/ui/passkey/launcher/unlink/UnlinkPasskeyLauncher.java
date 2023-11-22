package id.dana.riskChallenges.ui.passkey.launcher.unlink;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import androidx.core.os.BundleKt;
import androidx.fragment.app.FragmentActivity;
import androidx.view.LifecycleOwner;
import androidx.view.result.ActivityResultLauncher;
import id.dana.riskChallenges.di.component.RiskChallengesComponent;
import id.dana.riskChallenges.di.provider.RiskChallengesProvider;
import id.dana.riskChallenges.domain.passkey.interactor.PasskeyRemoveCredential;
import id.dana.riskChallenges.ui.RiskChallengeActivity;
import id.dana.riskChallenges.ui.resetpin.model.SecurityInfoModel;
import id.dana.riskChallenges.ui.resetpin.model.UseCaseStrategy;
import id.dana.riskChallenges.ui.resetpin.model.VerificationMethodModel;
import id.dana.riskChallenges.ui.util.StrategyKey;
import id.dana.riskChallenges.ui.util.model.BasicRiskChallengesModel;
import id.dana.riskChallenges.ui.util.strategy.BaseLauncher;
import id.dana.utils.foundation.logger.log.DanaLog;
import java.util.List;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001:\u0001\u001fB\t\b\u0000¢\u0006\u0004\b\u001e\u0010\u0004J\u000f\u0010\u0003\u001a\u00020\u0002H\u0014¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0005\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0004J!\u0010\n\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016¢\u0006\u0004\b\n\u0010\u000bJ\u0017\u0010\r\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\fH\u0016¢\u0006\u0004\b\r\u0010\u000eJ\u0017\u0010\u0010\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u000fH\u0002¢\u0006\u0004\b\u0010\u0010\u0011R\u0012\u0010\u0013\u001a\u00020\u0012X\u0081\"¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014R \u0010\u0005\u001a\u0004\u0018\u00010\u00152\b\u0010\u0007\u001a\u0004\u0018\u00010\u0015@BX\u0081\n¢\u0006\u0006\n\u0004\b\u0003\u0010\u0016R\u0014\u0010\u0003\u001a\u0004\u0018\u00010\u0017X\u0081\u0002¢\u0006\u0006\n\u0004\b\n\u0010\u0018R\u0014\u0010\u001b\u001a\u0004\u0018\u00010\u0019X\u0081\u0002¢\u0006\u0006\n\u0004\b\u0005\u0010\u001aR \u0010\u0010\u001a\u0004\u0018\u00010\u00152\b\u0010\u0007\u001a\u0004\u0018\u00010\u0015@BX\u0081\n¢\u0006\u0006\n\u0004\b\u001b\u0010\u0016R \u0010\n\u001a\u0004\u0018\u00010\u00152\b\u0010\u0007\u001a\u0004\u0018\u00010\u0015@BX\u0081\n¢\u0006\u0006\n\u0004\b\u0010\u0010\u0016R \u0010\u001d\u001a\u0004\u0018\u00010\u00152\b\u0010\u0007\u001a\u0004\u0018\u00010\u0015@BX\u0081\n¢\u0006\u0006\n\u0004\b\u001c\u0010\u0016"}, d2 = {"Lid/dana/riskChallenges/ui/passkey/launcher/unlink/UnlinkPasskeyLauncher;", "Lid/dana/riskChallenges/ui/util/strategy/BaseLauncher;", "", "PlaceComponentResult", "()V", "BuiltInFictitiousFunctionClassFactory", "", "p0", "Landroid/content/Intent;", "p1", "getAuthRequestContext", "(ILandroid/content/Intent;)V", "Landroidx/lifecycle/LifecycleOwner;", "onCreate", "(Landroidx/lifecycle/LifecycleOwner;)V", "", "KClassImpl$Data$declaredNonStaticMembers$2", "(Z)V", "Lid/dana/riskChallenges/domain/passkey/interactor/PasskeyRemoveCredential;", "passkeyRemoveCredential", "Lid/dana/riskChallenges/domain/passkey/interactor/PasskeyRemoveCredential;", "", "Ljava/lang/String;", "Lid/dana/riskChallenges/di/component/RiskChallengesComponent;", "Lid/dana/riskChallenges/di/component/RiskChallengesComponent;", "Lid/dana/riskChallenges/di/provider/RiskChallengesProvider;", "Lid/dana/riskChallenges/di/provider/RiskChallengesProvider;", "MyBillsEntityDataFactory", "NetworkUserEntityData$$ExternalSyntheticLambda0", "getErrorConfigVersion", "<init>", "Builder"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class UnlinkPasskeyLauncher extends BaseLauncher {

    /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
    public RiskChallengesProvider MyBillsEntityDataFactory;

    /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
    public String getAuthRequestContext;

    /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
    public String KClassImpl$Data$declaredNonStaticMembers$2;

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda0  reason: from kotlin metadata */
    public String getErrorConfigVersion;

    /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
    public String BuiltInFictitiousFunctionClassFactory;

    /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
    public RiskChallengesComponent PlaceComponentResult;
    @Inject
    public PasskeyRemoveCredential passkeyRemoveCredential;

    @Override // id.dana.riskChallenges.ui.util.strategy.BaseLauncher, androidx.view.FullLifecycleObserver
    public final void onCreate(LifecycleOwner p0) {
        RiskChallengesComponent.Factory provideRiskChallengesComponent;
        Intrinsics.checkNotNullParameter(p0, "");
        super.onCreate(p0);
        RiskChallengesProvider riskChallengesProvider = this.MyBillsEntityDataFactory;
        RiskChallengesComponent riskChallengesComponent = null;
        if (riskChallengesProvider == null) {
            Context MyBillsEntityDataFactory = MyBillsEntityDataFactory();
            riskChallengesProvider = MyBillsEntityDataFactory instanceof RiskChallengesProvider ? (RiskChallengesProvider) MyBillsEntityDataFactory : null;
        }
        if (riskChallengesProvider != null && (provideRiskChallengesComponent = riskChallengesProvider.provideRiskChallengesComponent()) != null) {
            riskChallengesComponent = provideRiskChallengesComponent.BuiltInFictitiousFunctionClassFactory();
        }
        this.PlaceComponentResult = riskChallengesComponent;
        if (riskChallengesComponent != null) {
            riskChallengesComponent.getAuthRequestContext(this);
        }
    }

    @Override // id.dana.riskChallenges.ui.util.strategy.BaseLauncher
    public final void PlaceComponentResult() {
        super.PlaceComponentResult();
        PasskeyRemoveCredential passkeyRemoveCredential = this.passkeyRemoveCredential;
        if (passkeyRemoveCredential == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            passkeyRemoveCredential = null;
        }
        passkeyRemoveCredential.dispose();
    }

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0011\b\u0016\u0012\u0006\u0010\u000b\u001a\u00020\n¢\u0006\u0004\b\f\u0010\rR\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00038\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0004\u0010\u0005R\u0018\u0010\b\u001a\u0004\u0018\u00010\u00038\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0007\u0010\u0005R\u0018\u0010\t\u001a\u0004\u0018\u00010\u00038\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0006\u0010\u0005R\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\b\u0010\u0005"}, d2 = {"Lid/dana/riskChallenges/ui/passkey/launcher/unlink/UnlinkPasskeyLauncher$Builder;", "Lid/dana/riskChallenges/ui/util/strategy/BaseLauncher$BaseBuilder;", "Lid/dana/riskChallenges/ui/passkey/launcher/unlink/UnlinkPasskeyLauncher;", "", "BuiltInFictitiousFunctionClassFactory", "Ljava/lang/String;", "getAuthRequestContext", "KClassImpl$Data$declaredNonStaticMembers$2", "PlaceComponentResult", "MyBillsEntityDataFactory", "Landroidx/fragment/app/FragmentActivity;", "p0", "<init>", "(Landroidx/fragment/app/FragmentActivity;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class Builder extends BaseLauncher.BaseBuilder<UnlinkPasskeyLauncher> {

        /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
        private String getAuthRequestContext;

        /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
        private String PlaceComponentResult;

        /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
        public String BuiltInFictitiousFunctionClassFactory;

        /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
        public String MyBillsEntityDataFactory;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Builder(FragmentActivity fragmentActivity) {
            super(fragmentActivity);
            Intrinsics.checkNotNullParameter(fragmentActivity, "");
        }

        @Override // id.dana.riskChallenges.ui.util.strategy.BaseLauncher.BaseBuilder
        public final /* synthetic */ UnlinkPasskeyLauncher KClassImpl$Data$declaredNonStaticMembers$2() {
            UnlinkPasskeyLauncher unlinkPasskeyLauncher = new UnlinkPasskeyLauncher();
            unlinkPasskeyLauncher.NetworkUserEntityData$$ExternalSyntheticLambda0 = getNetworkUserEntityData$$ExternalSyntheticLambda0();
            unlinkPasskeyLauncher.getAuthRequestContext = getBuiltInFictitiousFunctionClassFactory();
            unlinkPasskeyLauncher.getErrorConfigVersion = this.BuiltInFictitiousFunctionClassFactory;
            unlinkPasskeyLauncher.getAuthRequestContext = this.MyBillsEntityDataFactory;
            unlinkPasskeyLauncher.BuiltInFictitiousFunctionClassFactory = this.getAuthRequestContext;
            unlinkPasskeyLauncher.KClassImpl$Data$declaredNonStaticMembers$2 = this.PlaceComponentResult;
            Function0<Unit> function0 = this.MyBillsEntityDataFactory;
            Intrinsics.checkNotNullParameter(function0, "");
            unlinkPasskeyLauncher.getErrorConfigVersion = function0;
            Function1<? super Bundle, Unit> function1 = this.getErrorConfigVersion;
            Function1<? super Bundle, Unit> function12 = this.PlaceComponentResult;
            Function0<Unit> function02 = this.KClassImpl$Data$declaredNonStaticMembers$2;
            unlinkPasskeyLauncher.GetContactSyncConfig = function1;
            unlinkPasskeyLauncher.moveToNextValue = function12;
            unlinkPasskeyLauncher.MyBillsEntityDataFactory = function02;
            unlinkPasskeyLauncher.DatabaseTableConfigUtil = StrategyKey.PASSKEY_UNLINK;
            return unlinkPasskeyLauncher;
        }
    }

    public static final /* synthetic */ void getAuthRequestContext(UnlinkPasskeyLauncher unlinkPasskeyLauncher, Pair pair) {
        String str = (String) pair.component1();
        List list = (List) pair.component2();
        StringBuilder sb = new StringBuilder();
        sb.append("handleRiskChallenges -> securityId: ");
        sb.append(str);
        sb.append(", verificationMethods: ");
        Object[] array = list.toArray(new VerificationMethodModel[0]);
        if (array != null) {
            sb.append(array);
            DanaLog.MyBillsEntityDataFactory("PASSKEY", sb.toString());
            Intent intent = new Intent(unlinkPasskeyLauncher.getErrorConfigVersion(), RiskChallengeActivity.class);
            intent.putExtras(BundleKt.PlaceComponentResult(TuplesKt.to("KEY_STRATEGY", unlinkPasskeyLauncher.DatabaseTableConfigUtil), TuplesKt.to("KEY_SOURCE", unlinkPasskeyLauncher.getErrorConfigVersion), TuplesKt.to("KEY_PURPOSE", unlinkPasskeyLauncher.getAuthRequestContext), TuplesKt.to("KEY_PASSKEY_PAGE_SOURCE", "PROFILE"), TuplesKt.to("KEY_USE_CASE_STRATEGY", new UseCaseStrategy("AP_DAPROT_ACTIVITY", null, null, 6, null)), TuplesKt.to("KEY_UI_COMPONENT", unlinkPasskeyLauncher.NetworkUserEntityData$$ExternalSyntheticLambda2), TuplesKt.to("KEY_SECURITY_ID", str), TuplesKt.to("KEY_DATA_RISK_CONSULT", new BasicRiskChallengesModel("", new SecurityInfoModel(str, "", ""), list)), TuplesKt.to("KEY_NEED_HANDLE_VERIFICATION_METHOD", Boolean.TRUE)));
            ActivityResultLauncher<Intent> activityResultLauncher = unlinkPasskeyLauncher.BuiltInFictitiousFunctionClassFactory;
            if (activityResultLauncher != null) {
                activityResultLauncher.MyBillsEntityDataFactory(intent, null);
                return;
            }
            return;
        }
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
    }

    private final void KClassImpl$Data$declaredNonStaticMembers$2(final boolean p0) {
        this.getErrorConfigVersion.invoke();
        PasskeyRemoveCredential passkeyRemoveCredential = this.passkeyRemoveCredential;
        if (passkeyRemoveCredential == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            passkeyRemoveCredential = null;
        }
        passkeyRemoveCredential.execute(new PasskeyRemoveCredential.Params(p0), new Function1<Pair<? extends String, ? extends List<? extends VerificationMethodModel>>, Unit>() { // from class: id.dana.riskChallenges.ui.passkey.launcher.unlink.UnlinkPasskeyLauncher$onRemoveCredential$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final /* bridge */ /* synthetic */ Unit invoke(Pair<? extends String, ? extends List<? extends VerificationMethodModel>> pair) {
                invoke2((Pair<String, ? extends List<VerificationMethodModel>>) pair);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(Pair<String, ? extends List<VerificationMethodModel>> pair) {
                Intrinsics.checkNotNullParameter(pair, "");
                DanaLog.MyBillsEntityDataFactory("PASSKEY", pair.toString());
                UnlinkPasskeyLauncher.this.getErrorConfigVersion.invoke();
                if (p0 && !pair.getSecond().isEmpty()) {
                    UnlinkPasskeyLauncher.getAuthRequestContext(UnlinkPasskeyLauncher.this, pair);
                    return;
                }
                Function1<? super Bundle, Unit> function1 = UnlinkPasskeyLauncher.this.GetContactSyncConfig;
                if (function1 != null) {
                    function1.invoke(BundleKt.BuiltInFictitiousFunctionClassFactory());
                }
            }
        }, new Function1<Throwable, Unit>() { // from class: id.dana.riskChallenges.ui.passkey.launcher.unlink.UnlinkPasskeyLauncher$onRemoveCredential$2
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
                Intrinsics.checkNotNullParameter(th, "");
                DanaLog.MyBillsEntityDataFactory("PASSKEY", th.getMessage());
                UnlinkPasskeyLauncher.this.getErrorConfigVersion.invoke();
                Function1<? super Bundle, Unit> function1 = UnlinkPasskeyLauncher.this.moveToNextValue;
                if (function1 != null) {
                    function1.invoke(BundleKt.BuiltInFictitiousFunctionClassFactory());
                }
            }
        });
    }

    @Override // id.dana.riskChallenges.ui.util.strategy.RiskChallengeStrategy
    public final void BuiltInFictitiousFunctionClassFactory() {
        if (this.getAuthRequestContext != null) {
            KClassImpl$Data$declaredNonStaticMembers$2(true);
        }
        this.getErrorConfigVersion.invoke();
    }

    @Override // id.dana.riskChallenges.ui.util.strategy.BaseLauncher
    public final void getAuthRequestContext(int p0, Intent p1) {
        if (p0 != -1) {
            super.getAuthRequestContext(p0, p1);
        } else if (this.getAuthRequestContext != null) {
            KClassImpl$Data$declaredNonStaticMembers$2(false);
        }
    }
}
