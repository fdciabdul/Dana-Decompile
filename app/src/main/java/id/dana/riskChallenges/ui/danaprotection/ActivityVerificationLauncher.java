package id.dana.riskChallenges.ui.danaprotection;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import androidx.core.os.BundleKt;
import com.alibaba.griver.core.ui.activity.GriverBaseActivity;
import id.dana.riskChallenges.di.component.RiskChallengesComponent;
import id.dana.riskChallenges.di.provider.RiskChallengesProvider;
import id.dana.riskChallenges.domain.danaprotection.interactor.GetRiskChallengeStatus;
import id.dana.riskChallenges.domain.danaprotection.model.RiskChallengeStatusModel;
import id.dana.riskChallenges.ui.RiskChallengeActivity;
import id.dana.riskChallenges.ui.util.StrategyKey;
import id.dana.riskChallenges.ui.util.bridge.BaseRiskChallengeBridge;
import id.dana.riskChallenges.ui.util.strategy.BaseLauncher;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.jvm.JvmName;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 !2\u00020\u0001:\u0002\"!B\t\b\u0002¢\u0006\u0004\b \u0010\u0004J\u000f\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0005\u001a\u00020\u0002H\u0014¢\u0006\u0004\b\u0005\u0010\u0004J\u000f\u0010\u0006\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0006\u0010\u0004J\u000f\u0010\u0007\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0007\u0010\u0004J\u0017\u0010\u0006\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\bH\u0002¢\u0006\u0004\b\u0006\u0010\nJ!\u0010\u0007\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\u000b2\b\u0010\r\u001a\u0004\u0018\u00010\fH\u0016¢\u0006\u0004\b\u0007\u0010\u000eR \u0010\u0011\u001a\u0004\u0018\u00010\u000f2\b\u0010\t\u001a\u0004\u0018\u00010\u000f@BX\u0080\n¢\u0006\u0006\n\u0004\b\u0006\u0010\u0010R \u0010\u0007\u001a\u0004\u0018\u00010\u000f2\b\u0010\t\u001a\u0004\u0018\u00010\u000f@BX\u0080\n¢\u0006\u0006\n\u0004\b\u0005\u0010\u0010R\u0012\u0010\u0013\u001a\u00020\u0012X\u0081\"¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014R \u0010\u0003\u001a\u0004\u0018\u00010\u000f2\b\u0010\t\u001a\u0004\u0018\u00010\u000f@BX\u0081\n¢\u0006\u0006\n\u0004\b\u0003\u0010\u0010R\u0014\u0010\u0005\u001a\u0004\u0018\u00010\u0015X\u0081\u0002¢\u0006\u0006\n\u0004\b\u0007\u0010\u0016R\u0014\u0010\u0006\u001a\u0004\u0018\u00010\u0017X\u0081\u0002¢\u0006\u0006\n\u0004\b\u0011\u0010\u0018R\u001c\u0010\u001e\u001a\u0004\u0018\u00010\u00198AX\u0081\u0006¢\u0006\f\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u001dR \u0010\u001f\u001a\u0004\u0018\u00010\u000f2\b\u0010\t\u001a\u0004\u0018\u00010\u000f@BX\u0081\n¢\u0006\u0006\n\u0004\b\u001c\u0010\u0010R \u0010\u001a\u001a\u0004\u0018\u00010\u000f2\b\u0010\t\u001a\u0004\u0018\u00010\u000f@BX\u0081\n¢\u0006\u0006\n\u0004\b\u001f\u0010\u0010"}, d2 = {"Lid/dana/riskChallenges/ui/danaprotection/ActivityVerificationLauncher;", "Lid/dana/riskChallenges/ui/util/strategy/BaseLauncher;", "", "KClassImpl$Data$declaredNonStaticMembers$2", "()V", "PlaceComponentResult", "BuiltInFictitiousFunctionClassFactory", "getAuthRequestContext", "", "p0", "(Z)V", "", "Landroid/content/Intent;", "p1", "(ILandroid/content/Intent;)V", "", "Ljava/lang/String;", "MyBillsEntityDataFactory", "Lid/dana/riskChallenges/domain/danaprotection/interactor/GetRiskChallengeStatus;", "getRiskChallengeStatus", "Lid/dana/riskChallenges/domain/danaprotection/interactor/GetRiskChallengeStatus;", "Lid/dana/riskChallenges/domain/danaprotection/model/RiskChallengeStatusModel;", "Lid/dana/riskChallenges/domain/danaprotection/model/RiskChallengeStatusModel;", "Lid/dana/riskChallenges/di/component/RiskChallengesComponent;", "Lid/dana/riskChallenges/di/component/RiskChallengesComponent;", "Lid/dana/riskChallenges/di/provider/RiskChallengesProvider;", "NetworkUserEntityData$$ExternalSyntheticLambda0", "Lid/dana/riskChallenges/di/provider/RiskChallengesProvider;", "moveToNextValue", "()Lid/dana/riskChallenges/di/provider/RiskChallengesProvider;", "scheduleImpl", "getErrorConfigVersion", "<init>", "Companion", "Builder"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class ActivityVerificationLauncher extends BaseLauncher {

    /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
    public String MyBillsEntityDataFactory;
    public String KClassImpl$Data$declaredNonStaticMembers$2;

    /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
    public RiskChallengesComponent BuiltInFictitiousFunctionClassFactory;

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda0  reason: from kotlin metadata */
    private RiskChallengesProvider scheduleImpl;

    /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
    public String getAuthRequestContext;

    /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
    RiskChallengeStatusModel PlaceComponentResult;

    /* renamed from: getErrorConfigVersion  reason: from kotlin metadata */
    public String NetworkUserEntityData$$ExternalSyntheticLambda0;
    @Inject
    public GetRiskChallengeStatus getRiskChallengeStatus;

    /* renamed from: moveToNextValue  reason: from kotlin metadata */
    public String getErrorConfigVersion;

    public /* synthetic */ ActivityVerificationLauncher(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    private ActivityVerificationLauncher() {
    }

    @JvmName(name = "moveToNextValue")
    private RiskChallengesProvider moveToNextValue() {
        RiskChallengesProvider riskChallengesProvider = this.scheduleImpl;
        if (riskChallengesProvider == null) {
            Context MyBillsEntityDataFactory = MyBillsEntityDataFactory();
            if (MyBillsEntityDataFactory instanceof RiskChallengesProvider) {
                return (RiskChallengesProvider) MyBillsEntityDataFactory;
            }
            return null;
        }
        return riskChallengesProvider;
    }

    @Override // id.dana.riskChallenges.ui.util.strategy.RiskChallengeStrategy
    public final void BuiltInFictitiousFunctionClassFactory() {
        RiskChallengesComponent.Factory provideRiskChallengesComponent;
        RiskChallengesProvider moveToNextValue = moveToNextValue();
        RiskChallengesComponent BuiltInFictitiousFunctionClassFactory = (moveToNextValue == null || (provideRiskChallengesComponent = moveToNextValue.provideRiskChallengesComponent()) == null) ? null : provideRiskChallengesComponent.BuiltInFictitiousFunctionClassFactory();
        this.BuiltInFictitiousFunctionClassFactory = BuiltInFictitiousFunctionClassFactory;
        if (BuiltInFictitiousFunctionClassFactory != null) {
            BuiltInFictitiousFunctionClassFactory.PlaceComponentResult(this);
        }
        KClassImpl$Data$declaredNonStaticMembers$2();
    }

    @Override // id.dana.riskChallenges.ui.util.strategy.BaseLauncher
    public final void PlaceComponentResult() {
        super.PlaceComponentResult();
        GetRiskChallengeStatus getRiskChallengeStatus = this.getRiskChallengeStatus;
        if (getRiskChallengeStatus == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            getRiskChallengeStatus = null;
        }
        getRiskChallengeStatus.dispose();
    }

    private final void BuiltInFictitiousFunctionClassFactory(boolean p0) {
        Bundle bundle = new Bundle();
        bundle.putBoolean("KEY_RISK_RESULT", p0);
        bundle.putBoolean("KEY_RESULT", true);
        Function1<? super Bundle, Unit> function1 = this.GetContactSyncConfig;
        if (function1 != null) {
            function1.invoke(bundle);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void getAuthRequestContext() {
        Bundle bundle = new Bundle();
        bundle.putBoolean("KEY_RISK_RESULT", false);
        bundle.putBoolean("KEY_RESULT", false);
        Function1<? super Bundle, Unit> function1 = this.moveToNextValue;
        if (function1 != null) {
            function1.invoke(bundle);
        }
    }

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0017\u0012\u0006\u0010\f\u001a\u00020\u000b\u0012\u0006\u0010\u000e\u001a\u00020\r¢\u0006\u0004\b\u000f\u0010\u0010R\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00038\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0004\u0010\u0005R\u0018\u0010\u0007\u001a\u0004\u0018\u00010\u00038\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0006\u0010\u0005R\u0012\u0010\b\u001a\u00020\u0003X\u0096@¢\u0006\u0006\n\u0004\b\u0007\u0010\u0005R\u0018\u0010\t\u001a\u0004\u0018\u00010\u00038\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\b\u0010\u0005R\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\t\u0010\u0005R\u0018\u0010\n\u001a\u0004\u0018\u00010\u00038\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\n\u0010\u0005"}, d2 = {"Lid/dana/riskChallenges/ui/danaprotection/ActivityVerificationLauncher$Builder;", "Lid/dana/riskChallenges/ui/util/strategy/BaseLauncher$BaseBuilder;", "Lid/dana/riskChallenges/ui/danaprotection/ActivityVerificationLauncher;", "", "MyBillsEntityDataFactory", "Ljava/lang/String;", "KClassImpl$Data$declaredNonStaticMembers$2", "getAuthRequestContext", "BuiltInFictitiousFunctionClassFactory", "PlaceComponentResult", "getErrorConfigVersion", "Lcom/alibaba/griver/core/ui/activity/GriverBaseActivity;", "p0", "Lid/dana/riskChallenges/ui/util/bridge/BaseRiskChallengeBridge;", "p1", "<init>", "(Lcom/alibaba/griver/core/ui/activity/GriverBaseActivity;Lid/dana/riskChallenges/ui/util/bridge/BaseRiskChallengeBridge;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes3.dex */
    public static final class Builder extends BaseLauncher.BaseBuilder<ActivityVerificationLauncher> {

        /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
        public String PlaceComponentResult;

        /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
        public String getAuthRequestContext;

        /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
        public String KClassImpl$Data$declaredNonStaticMembers$2;

        /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
        public String MyBillsEntityDataFactory;

        /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
        public final String BuiltInFictitiousFunctionClassFactory;
        public String getErrorConfigVersion;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Builder(GriverBaseActivity griverBaseActivity, BaseRiskChallengeBridge baseRiskChallengeBridge) {
            super(griverBaseActivity, baseRiskChallengeBridge);
            Intrinsics.checkNotNullParameter(griverBaseActivity, "");
            Intrinsics.checkNotNullParameter(baseRiskChallengeBridge, "");
            this.BuiltInFictitiousFunctionClassFactory = StrategyKey.SUSPICIOUS_ACTIVITY_VERIFICATION;
        }

        @Override // id.dana.riskChallenges.ui.util.strategy.BaseLauncher.BaseBuilder
        public final /* synthetic */ ActivityVerificationLauncher KClassImpl$Data$declaredNonStaticMembers$2() {
            ActivityVerificationLauncher activityVerificationLauncher = new ActivityVerificationLauncher(null);
            activityVerificationLauncher.NetworkUserEntityData$$ExternalSyntheticLambda0 = getNetworkUserEntityData$$ExternalSyntheticLambda0();
            activityVerificationLauncher.getAuthRequestContext = getBuiltInFictitiousFunctionClassFactory();
            activityVerificationLauncher.lookAheadTest = getMoveToNextValue();
            activityVerificationLauncher.KClassImpl$Data$declaredNonStaticMembers$2 = getGetAuthRequestContext();
            activityVerificationLauncher.NetworkUserEntityData$$ExternalSyntheticLambda2 = this.scheduleImpl;
            activityVerificationLauncher.DatabaseTableConfigUtil = this.BuiltInFictitiousFunctionClassFactory;
            activityVerificationLauncher.KClassImpl$Data$declaredNonStaticMembers$2 = this.PlaceComponentResult;
            activityVerificationLauncher.NetworkUserEntityData$$ExternalSyntheticLambda0 = this.getErrorConfigVersion;
            activityVerificationLauncher.getAuthRequestContext = this.getAuthRequestContext;
            activityVerificationLauncher.MyBillsEntityDataFactory = this.KClassImpl$Data$declaredNonStaticMembers$2;
            activityVerificationLauncher.getErrorConfigVersion = this.MyBillsEntityDataFactory;
            Function1<? super Bundle, Unit> function1 = this.getErrorConfigVersion;
            Function1<? super Bundle, Unit> function12 = this.PlaceComponentResult;
            Function0<Unit> function0 = this.KClassImpl$Data$declaredNonStaticMembers$2;
            activityVerificationLauncher.GetContactSyncConfig = function1;
            activityVerificationLauncher.moveToNextValue = function12;
            activityVerificationLauncher.MyBillsEntityDataFactory = function0;
            Function0<Unit> function02 = this.MyBillsEntityDataFactory;
            Intrinsics.checkNotNullParameter(function02, "");
            activityVerificationLauncher.getErrorConfigVersion = function02;
            return activityVerificationLauncher;
        }
    }

    public static final /* synthetic */ void PlaceComponentResult(ActivityVerificationLauncher activityVerificationLauncher, RiskChallengeStatusModel riskChallengeStatusModel) {
        String str = riskChallengeStatusModel.MyBillsEntityDataFactory;
        int hashCode = str.hashCode();
        if (hashCode == -1881380961) {
            if (str.equals("REJECT")) {
                activityVerificationLauncher.BuiltInFictitiousFunctionClassFactory(false);
            }
        } else if (hashCode != 832880155) {
            if (hashCode == 1924835592 && str.equals("ACCEPT")) {
                activityVerificationLauncher.BuiltInFictitiousFunctionClassFactory(true);
            }
        } else if (str.equals("VERIFICATION")) {
            Intrinsics.checkNotNullParameter(riskChallengeStatusModel, "");
            Intent intent = new Intent(activityVerificationLauncher.getErrorConfigVersion(), RiskChallengeActivity.class);
            intent.putExtras(BundleKt.PlaceComponentResult(TuplesKt.to("KEY_STRATEGY", activityVerificationLauncher.DatabaseTableConfigUtil), TuplesKt.to("KEY_UI_COMPONENT", activityVerificationLauncher.NetworkUserEntityData$$ExternalSyntheticLambda2), TuplesKt.to("KEY_DATA_RISK_CONSULT", riskChallengeStatusModel), TuplesKt.to("KEY_PHONE_NUMBER", activityVerificationLauncher.KClassImpl$Data$declaredNonStaticMembers$2), TuplesKt.to("KEY_SOURCE", activityVerificationLauncher.getErrorConfigVersion)));
            BaseRiskChallengeBridge baseRiskChallengeBridge = activityVerificationLauncher.KClassImpl$Data$declaredNonStaticMembers$2;
            if (baseRiskChallengeBridge != null) {
                GriverBaseActivity griverBaseActivity = activityVerificationLauncher.lookAheadTest;
                if (griverBaseActivity != null) {
                    baseRiskChallengeBridge.startActivityForResult(griverBaseActivity, intent, 101);
                    return;
                }
                throw new NullPointerException("null cannot be cast to non-null type android.app.Activity");
            }
        }
    }

    private final void KClassImpl$Data$declaredNonStaticMembers$2() {
        GetRiskChallengeStatus getRiskChallengeStatus = this.getRiskChallengeStatus;
        if (getRiskChallengeStatus == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            getRiskChallengeStatus = null;
        }
        String str = this.NetworkUserEntityData$$ExternalSyntheticLambda0;
        if (str == null) {
            str = "";
        }
        String str2 = this.getAuthRequestContext;
        if (str2 == null) {
            str2 = "";
        }
        String str3 = this.MyBillsEntityDataFactory;
        if (str3 == null) {
            str3 = "";
        }
        RiskChallengeStatusModel riskChallengeStatusModel = this.PlaceComponentResult;
        String str4 = riskChallengeStatusModel != null ? riskChallengeStatusModel.getAuthRequestContext : null;
        getRiskChallengeStatus.execute(new GetRiskChallengeStatus.Params(str, str2, str3, str4 != null ? str4 : ""), new Function1<RiskChallengeStatusModel, Unit>() { // from class: id.dana.riskChallenges.ui.danaprotection.ActivityVerificationLauncher$consultRiskChallengeStatus$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final /* bridge */ /* synthetic */ Unit invoke(RiskChallengeStatusModel riskChallengeStatusModel2) {
                invoke2(riskChallengeStatusModel2);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(RiskChallengeStatusModel riskChallengeStatusModel2) {
                Intrinsics.checkNotNullParameter(riskChallengeStatusModel2, "");
                ActivityVerificationLauncher.this.PlaceComponentResult = riskChallengeStatusModel2;
                ActivityVerificationLauncher.PlaceComponentResult(ActivityVerificationLauncher.this, riskChallengeStatusModel2);
            }
        }, new Function1<Throwable, Unit>() { // from class: id.dana.riskChallenges.ui.danaprotection.ActivityVerificationLauncher$consultRiskChallengeStatus$2
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
                ActivityVerificationLauncher.this.getAuthRequestContext();
            }
        });
    }

    @Override // id.dana.riskChallenges.ui.util.strategy.BaseLauncher
    public final void getAuthRequestContext(int p0, Intent p1) {
        Bundle extras;
        if (p0 == -1) {
            this.getErrorConfigVersion.invoke();
            KClassImpl$Data$declaredNonStaticMembers$2();
        } else if (p0 == 0) {
            this.getErrorConfigVersion.invoke();
            if ((p1 == null || (extras = p1.getExtras()) == null || !extras.getBoolean("KEY_IS_ERROR")) ? false : true) {
                getAuthRequestContext();
            } else {
                BuiltInFictitiousFunctionClassFactory(false);
            }
        }
    }
}
