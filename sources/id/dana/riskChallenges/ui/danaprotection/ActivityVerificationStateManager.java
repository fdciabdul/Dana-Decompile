package id.dana.riskChallenges.ui.danaprotection;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcelable;
import androidx.core.os.BundleKt;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentResultListener;
import id.dana.riskChallenges.constant.RiskChallengeKey;
import id.dana.riskChallenges.ui.danaprotection.ActivityVerificationStateManager;
import id.dana.riskChallenges.ui.resetpin.model.SecurityInfoModel;
import id.dana.riskChallenges.ui.resetpin.model.UseCaseStrategy;
import id.dana.riskChallenges.ui.util.model.BasicRiskChallengesModel;
import id.dana.riskChallenges.ui.util.model.HistoryFallbackModel;
import id.dana.riskChallenges.ui.util.statemanager.ChallengeState;
import id.dana.riskChallenges.ui.util.statemanager.ChangeStateListener;
import id.dana.riskChallenges.ui.util.statemanager.QueueVerificationMethods;
import id.dana.riskChallenges.ui.util.strategy.RiskChallengeStrategy;
import id.dana.riskChallenges.ui.util.strategy.RiskChallengeStrategyFactory;
import id.dana.riskChallenges.ui.util.uicomponent.UiComponent;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.JvmName;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002:\u0001)B7\u0012\u0006\u0010\u0005\u001a\u00020\r\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\"\u0012\n\b\u0002\u0010$\u001a\u0004\u0018\u00010\u0015\u0012\u0006\u0010%\u001a\u00020\u0004\u0012\u0006\u0010&\u001a\u00020\u0004¢\u0006\u0004\b'\u0010(J\u0019\u0010\u0007\u001a\u00020\u00062\b\b\u0001\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u001f\u0010\u000b\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\tH\u0016¢\u0006\u0004\b\u000b\u0010\fR\u0011\u0010\u0010\u001a\u00020\rX\u0006¢\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u0016\u0010\u0014\u001a\u00020\u00118\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u0013\u0010\u000e\u001a\u0004\u0018\u00010\u0015X\u0006¢\u0006\u0006\n\u0004\b\u0014\u0010\u0016R\u0011\u0010\u0018\u001a\u00020\u0004X\u0006¢\u0006\u0006\n\u0004\b\u0010\u0010\u0017R\u0013\u0010\u0007\u001a\u00020\u0019X\u0082\u0080\u0002¢\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u0013\u0010\u001d\u001a\u00020\u001cX\u0082\u0080\u0002¢\u0006\u0006\n\u0004\b\u001d\u0010\u001bR\u0011\u0010\u001e\u001a\u00020\u0004X\u0006¢\u0006\u0006\n\u0004\b\u0007\u0010\u0017R(\u0010\u001a\u001a\u0004\u0018\u00010\u00032\b\u0010\u0005\u001a\u0004\u0018\u00010\u00038\u0002@CX\u0082\u000e¢\u0006\f\n\u0004\b\u001f\u0010 \"\u0004\b\u000e\u0010!R\u0013\u0010\u0012\u001a\u0004\u0018\u00010\"X\u0007¢\u0006\u0006\n\u0004\b\u0018\u0010#"}, d2 = {"Lid/dana/riskChallenges/ui/danaprotection/ActivityVerificationStateManager;", "Lid/dana/riskChallenges/ui/util/statemanager/ChallengeState;", "Lid/dana/riskChallenges/ui/util/statemanager/ChangeStateListener;", "Lid/dana/riskChallenges/ui/danaprotection/ActivityVerificationStateManager$ActivityVerificationState;", "", "p0", "", "PlaceComponentResult", "(Ljava/lang/String;)V", "Landroid/os/Bundle;", "p1", "onFragmentResult", "(Ljava/lang/String;Landroid/os/Bundle;)V", "Landroidx/fragment/app/FragmentActivity;", "BuiltInFictitiousFunctionClassFactory", "Landroidx/fragment/app/FragmentActivity;", "getAuthRequestContext", "Landroidx/fragment/app/FragmentResultListener;", "getErrorConfigVersion", "Landroidx/fragment/app/FragmentResultListener;", "MyBillsEntityDataFactory", "Lid/dana/riskChallenges/ui/util/model/BasicRiskChallengesModel;", "Lid/dana/riskChallenges/ui/util/model/BasicRiskChallengesModel;", "Ljava/lang/String;", "KClassImpl$Data$declaredNonStaticMembers$2", "Lid/dana/riskChallenges/ui/util/statemanager/QueueVerificationMethods;", "NetworkUserEntityData$$ExternalSyntheticLambda0", "Lkotlin/Lazy;", "Lid/dana/riskChallenges/ui/util/strategy/RiskChallengeStrategyFactory;", "moveToNextValue", "lookAheadTest", "scheduleImpl", "Lid/dana/riskChallenges/ui/danaprotection/ActivityVerificationStateManager$ActivityVerificationState;", "(Lid/dana/riskChallenges/ui/danaprotection/ActivityVerificationStateManager$ActivityVerificationState;)V", "Lid/dana/riskChallenges/ui/util/uicomponent/UiComponent;", "Lid/dana/riskChallenges/ui/util/uicomponent/UiComponent;", "p2", "p3", "p4", "<init>", "(Landroidx/fragment/app/FragmentActivity;Lid/dana/riskChallenges/ui/util/uicomponent/UiComponent;Lid/dana/riskChallenges/ui/util/model/BasicRiskChallengesModel;Ljava/lang/String;Ljava/lang/String;)V", "ActivityVerificationState"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class ActivityVerificationStateManager implements ChallengeState, ChangeStateListener<ActivityVerificationState> {

    /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
    final FragmentActivity getAuthRequestContext;

    /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
    final UiComponent getErrorConfigVersion;

    /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
    final BasicRiskChallengesModel BuiltInFictitiousFunctionClassFactory;

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda0  reason: from kotlin metadata */
    private final Lazy PlaceComponentResult;

    /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
    final String lookAheadTest;

    /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
    final String KClassImpl$Data$declaredNonStaticMembers$2;

    /* renamed from: getErrorConfigVersion  reason: from kotlin metadata */
    private FragmentResultListener MyBillsEntityDataFactory;
    private final Lazy moveToNextValue;

    /* renamed from: scheduleImpl  reason: from kotlin metadata */
    private ActivityVerificationState NetworkUserEntityData$$ExternalSyntheticLambda0;

    public ActivityVerificationStateManager(FragmentActivity fragmentActivity, UiComponent uiComponent, BasicRiskChallengesModel basicRiskChallengesModel, String str, String str2) {
        Intrinsics.checkNotNullParameter(fragmentActivity, "");
        Intrinsics.checkNotNullParameter(str, "");
        Intrinsics.checkNotNullParameter(str2, "");
        this.getAuthRequestContext = fragmentActivity;
        this.getErrorConfigVersion = uiComponent;
        this.BuiltInFictitiousFunctionClassFactory = basicRiskChallengesModel;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = str;
        this.lookAheadTest = str2;
        this.PlaceComponentResult = LazyKt.lazy(new Function0<QueueVerificationMethods>() { // from class: id.dana.riskChallenges.ui.danaprotection.ActivityVerificationStateManager$queueVerificationMethods$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final QueueVerificationMethods invoke() {
                return new QueueVerificationMethods();
            }
        });
        this.moveToNextValue = LazyKt.lazy(new Function0<RiskChallengeStrategyFactory>() { // from class: id.dana.riskChallenges.ui.danaprotection.ActivityVerificationStateManager$rcStrategyFactory$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final RiskChallengeStrategyFactory invoke() {
                SecurityInfoModel placeComponentResult;
                FragmentActivity fragmentActivity2 = ActivityVerificationStateManager.this.getAuthRequestContext;
                BasicRiskChallengesModel basicRiskChallengesModel2 = ActivityVerificationStateManager.this.BuiltInFictitiousFunctionClassFactory;
                String str3 = (basicRiskChallengesModel2 == null || (placeComponentResult = basicRiskChallengesModel2.getPlaceComponentResult()) == null) ? null : placeComponentResult.MyBillsEntityDataFactory;
                String str4 = str3 == null ? "" : str3;
                String str5 = ActivityVerificationStateManager.this.KClassImpl$Data$declaredNonStaticMembers$2;
                UiComponent uiComponent2 = ActivityVerificationStateManager.this.getErrorConfigVersion;
                Map mapOf = MapsKt.mapOf(TuplesKt.to("KEY_SOURCE", ActivityVerificationStateManager.this.lookAheadTest), TuplesKt.to("KEY_SCENE", "RESET_PASSWORD"));
                UseCaseStrategy useCaseStrategy = new UseCaseStrategy("AP_DAPROT_ACTIVITY", null, null, 6, null);
                final ActivityVerificationStateManager activityVerificationStateManager = ActivityVerificationStateManager.this;
                RiskChallengeStrategyFactory riskChallengeStrategyFactory = new RiskChallengeStrategyFactory(fragmentActivity2, str4, str5, uiComponent2, useCaseStrategy, mapOf, new Function0<String>() { // from class: id.dana.riskChallenges.ui.danaprotection.ActivityVerificationStateManager$rcStrategyFactory$2.1
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public final String invoke() {
                        return ActivityVerificationStateManager.PlaceComponentResult(ActivityVerificationStateManager.this).getAuthRequestContext();
                    }
                });
                final ActivityVerificationStateManager activityVerificationStateManager2 = ActivityVerificationStateManager.this;
                Function1<FragmentResultListener, Unit> function1 = new Function1<FragmentResultListener, Unit>() { // from class: id.dana.riskChallenges.ui.danaprotection.ActivityVerificationStateManager$rcStrategyFactory$2$2$1
                    /* JADX INFO: Access modifiers changed from: package-private */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final /* bridge */ /* synthetic */ Unit invoke(FragmentResultListener fragmentResultListener) {
                        invoke2(fragmentResultListener);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke  reason: avoid collision after fix types in other method */
                    public final void invoke2(FragmentResultListener fragmentResultListener) {
                        Intrinsics.checkNotNullParameter(fragmentResultListener, "");
                        ActivityVerificationStateManager.this.MyBillsEntityDataFactory = fragmentResultListener;
                    }
                };
                Intrinsics.checkNotNullParameter(function1, "");
                riskChallengeStrategyFactory.PlaceComponentResult = function1;
                return riskChallengeStrategyFactory;
            }
        });
        ((QueueVerificationMethods) this.PlaceComponentResult.getValue()).BuiltInFictitiousFunctionClassFactory(basicRiskChallengesModel);
        ActivityVerificationState.RiskChallenge riskChallenge = ActivityVerificationState.RiskChallenge.INSTANCE;
        Intrinsics.checkNotNullParameter(riskChallenge, "");
        BuiltInFictitiousFunctionClassFactory(riskChallenge);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @JvmName(name = "BuiltInFictitiousFunctionClassFactory")
    public final void BuiltInFictitiousFunctionClassFactory(ActivityVerificationState activityVerificationState) {
        this.NetworkUserEntityData$$ExternalSyntheticLambda0 = activityVerificationState;
        if (!(activityVerificationState instanceof ActivityVerificationState.RiskChallenge)) {
            if (!(activityVerificationState instanceof ActivityVerificationState.Success)) {
                if (!(activityVerificationState instanceof ActivityVerificationState.Failed)) {
                    if (!(activityVerificationState instanceof ActivityVerificationState.Canceled)) {
                        if (activityVerificationState instanceof ActivityVerificationState.RiskReject) {
                            PlaceComponentResult(RiskChallengeKey.RISK_REJECT);
                            return;
                        }
                        return;
                    }
                    this.getAuthRequestContext.setResult(0);
                    this.getAuthRequestContext.finish();
                    return;
                }
                Bundle bundle = ((ActivityVerificationState.Failed) activityVerificationState).getAuthRequestContext;
                Intrinsics.checkNotNullParameter(bundle, "");
                Intent intent = new Intent();
                intent.putExtras(bundle);
                this.getAuthRequestContext.setResult(0, intent);
                this.getAuthRequestContext.finish();
                return;
            }
            Intrinsics.checkNotNullParameter(BundleKt.BuiltInFictitiousFunctionClassFactory(), "");
            this.getAuthRequestContext.setResult(-1);
            this.getAuthRequestContext.finish();
            return;
        }
        String BuiltInFictitiousFunctionClassFactory = ((QueueVerificationMethods) this.PlaceComponentResult.getValue()).BuiltInFictitiousFunctionClassFactory();
        PlaceComponentResult(BuiltInFictitiousFunctionClassFactory != null ? BuiltInFictitiousFunctionClassFactory : "");
    }

    @Override // androidx.fragment.app.FragmentResultListener
    public final void onFragmentResult(String p0, Bundle p1) {
        Intrinsics.checkNotNullParameter(p0, "");
        Intrinsics.checkNotNullParameter(p1, "");
        FragmentResultListener fragmentResultListener = this.MyBillsEntityDataFactory;
        if (fragmentResultListener == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            fragmentResultListener = null;
        }
        fragmentResultListener.onFragmentResult(p0, p1);
    }

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\b6\u0018\u00002\u00020\u0001:\u0005\u0004\u0005\u0006\u0007\bB\t\b\u0004¢\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\u0005\t\n\u000b\f\r"}, d2 = {"Lid/dana/riskChallenges/ui/danaprotection/ActivityVerificationStateManager$ActivityVerificationState;", "", "<init>", "()V", "Canceled", "Failed", "RiskChallenge", "RiskReject", "Success", "Lid/dana/riskChallenges/ui/danaprotection/ActivityVerificationStateManager$ActivityVerificationState$RiskChallenge;", "Lid/dana/riskChallenges/ui/danaprotection/ActivityVerificationStateManager$ActivityVerificationState$Success;", "Lid/dana/riskChallenges/ui/danaprotection/ActivityVerificationStateManager$ActivityVerificationState$Failed;", "Lid/dana/riskChallenges/ui/danaprotection/ActivityVerificationStateManager$ActivityVerificationState$Canceled;", "Lid/dana/riskChallenges/ui/danaprotection/ActivityVerificationStateManager$ActivityVerificationState$RiskReject;"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static abstract class ActivityVerificationState {
        public /* synthetic */ ActivityVerificationState(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lid/dana/riskChallenges/ui/danaprotection/ActivityVerificationStateManager$ActivityVerificationState$RiskChallenge;", "Lid/dana/riskChallenges/ui/danaprotection/ActivityVerificationStateManager$ActivityVerificationState;", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
        /* loaded from: classes5.dex */
        public static final class RiskChallenge extends ActivityVerificationState {
            public static final RiskChallenge INSTANCE = new RiskChallenge();

            private RiskChallenge() {
                super(null);
            }
        }

        private ActivityVerificationState() {
        }

        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lid/dana/riskChallenges/ui/danaprotection/ActivityVerificationStateManager$ActivityVerificationState$Success;", "Lid/dana/riskChallenges/ui/danaprotection/ActivityVerificationStateManager$ActivityVerificationState;", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
        /* loaded from: classes5.dex */
        public static final class Success extends ActivityVerificationState {
            public static final Success INSTANCE = new Success();

            private Success() {
                super(null);
            }
        }

        @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\r¢\u0006\u0004\b\u0011\u0010\u0012J\u001a\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002HÖ\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u0010\u0010\b\u001a\u00020\u0007HÖ\u0001¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\u000b\u001a\u00020\nHÖ\u0001¢\u0006\u0004\b\u000b\u0010\fR\u0011\u0010\u0010\u001a\u00020\rX\u0006¢\u0006\u0006\n\u0004\b\u000e\u0010\u000f"}, d2 = {"Lid/dana/riskChallenges/ui/danaprotection/ActivityVerificationStateManager$ActivityVerificationState$Failed;", "Lid/dana/riskChallenges/ui/danaprotection/ActivityVerificationStateManager$ActivityVerificationState;", "", "p0", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "", "toString", "()Ljava/lang/String;", "Landroid/os/Bundle;", "BuiltInFictitiousFunctionClassFactory", "Landroid/os/Bundle;", "getAuthRequestContext", "<init>", "(Landroid/os/Bundle;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
        /* loaded from: classes5.dex */
        public static final /* data */ class Failed extends ActivityVerificationState {

            /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
            final Bundle getAuthRequestContext;

            public final boolean equals(Object p0) {
                if (this == p0) {
                    return true;
                }
                return (p0 instanceof Failed) && Intrinsics.areEqual(this.getAuthRequestContext, ((Failed) p0).getAuthRequestContext);
            }

            public final int hashCode() {
                return this.getAuthRequestContext.hashCode();
            }

            public final String toString() {
                StringBuilder sb = new StringBuilder();
                sb.append("Failed(getAuthRequestContext=");
                sb.append(this.getAuthRequestContext);
                sb.append(')');
                return sb.toString();
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public Failed(Bundle bundle) {
                super(null);
                Intrinsics.checkNotNullParameter(bundle, "");
                this.getAuthRequestContext = bundle;
            }
        }

        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lid/dana/riskChallenges/ui/danaprotection/ActivityVerificationStateManager$ActivityVerificationState$Canceled;", "Lid/dana/riskChallenges/ui/danaprotection/ActivityVerificationStateManager$ActivityVerificationState;", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
        /* loaded from: classes5.dex */
        public static final class Canceled extends ActivityVerificationState {
            public static final Canceled INSTANCE = new Canceled();

            private Canceled() {
                super(null);
            }
        }

        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lid/dana/riskChallenges/ui/danaprotection/ActivityVerificationStateManager$ActivityVerificationState$RiskReject;", "Lid/dana/riskChallenges/ui/danaprotection/ActivityVerificationStateManager$ActivityVerificationState;", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
        /* loaded from: classes5.dex */
        public static final class RiskReject extends ActivityVerificationState {
            public static final RiskReject INSTANCE = new RiskReject();

            private RiskReject() {
                super(null);
            }
        }
    }

    public static final /* synthetic */ QueueVerificationMethods PlaceComponentResult(ActivityVerificationStateManager activityVerificationStateManager) {
        return (QueueVerificationMethods) activityVerificationStateManager.PlaceComponentResult.getValue();
    }

    public static final /* synthetic */ RiskChallengeStrategyFactory MyBillsEntityDataFactory(ActivityVerificationStateManager activityVerificationStateManager) {
        return (RiskChallengeStrategyFactory) activityVerificationStateManager.moveToNextValue.getValue();
    }

    private final void PlaceComponentResult(@RiskChallengeKey String p0) {
        try {
            RiskChallengeStrategy PlaceComponentResult = ((RiskChallengeStrategyFactory) this.moveToNextValue.getValue()).PlaceComponentResult(p0);
            PlaceComponentResult.BuiltInFictitiousFunctionClassFactory(new Function1<Bundle, Unit>() { // from class: id.dana.riskChallenges.ui.danaprotection.ActivityVerificationStateManager$executeRiskChallenge$1
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public final /* bridge */ /* synthetic */ Unit invoke(Bundle bundle) {
                    invoke2(bundle);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke  reason: avoid collision after fix types in other method */
                public final void invoke2(Bundle bundle) {
                    Intrinsics.checkNotNullParameter(bundle, "");
                    QueueVerificationMethods PlaceComponentResult2 = ActivityVerificationStateManager.PlaceComponentResult(ActivityVerificationStateManager.this);
                    final ActivityVerificationStateManager activityVerificationStateManager = ActivityVerificationStateManager.this;
                    Function0<Unit> function0 = new Function0<Unit>() { // from class: id.dana.riskChallenges.ui.danaprotection.ActivityVerificationStateManager$executeRiskChallenge$1.1
                        {
                            super(0);
                        }

                        @Override // kotlin.jvm.functions.Function0
                        public final /* bridge */ /* synthetic */ Unit invoke() {
                            invoke2();
                            return Unit.INSTANCE;
                        }

                        /* renamed from: invoke  reason: avoid collision after fix types in other method */
                        public final void invoke2() {
                            ActivityVerificationStateManager activityVerificationStateManager2 = ActivityVerificationStateManager.this;
                            ActivityVerificationStateManager.ActivityVerificationState.RiskChallenge riskChallenge = ActivityVerificationStateManager.ActivityVerificationState.RiskChallenge.INSTANCE;
                            Intrinsics.checkNotNullParameter(riskChallenge, "");
                            activityVerificationStateManager2.BuiltInFictitiousFunctionClassFactory(riskChallenge);
                        }
                    };
                    final ActivityVerificationStateManager activityVerificationStateManager2 = ActivityVerificationStateManager.this;
                    PlaceComponentResult2.KClassImpl$Data$declaredNonStaticMembers$2(function0, new Function0<Unit>() { // from class: id.dana.riskChallenges.ui.danaprotection.ActivityVerificationStateManager$executeRiskChallenge$1.2
                        {
                            super(0);
                        }

                        @Override // kotlin.jvm.functions.Function0
                        public final /* bridge */ /* synthetic */ Unit invoke() {
                            invoke2();
                            return Unit.INSTANCE;
                        }

                        /* renamed from: invoke  reason: avoid collision after fix types in other method */
                        public final void invoke2() {
                            ActivityVerificationStateManager activityVerificationStateManager3 = ActivityVerificationStateManager.this;
                            ActivityVerificationStateManager.ActivityVerificationState.Success success = ActivityVerificationStateManager.ActivityVerificationState.Success.INSTANCE;
                            Intrinsics.checkNotNullParameter(success, "");
                            activityVerificationStateManager3.BuiltInFictitiousFunctionClassFactory(success);
                        }
                    });
                }
            }, new Function1<Bundle, Unit>() { // from class: id.dana.riskChallenges.ui.danaprotection.ActivityVerificationStateManager$executeRiskChallenge$2
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public final /* bridge */ /* synthetic */ Unit invoke(Bundle bundle) {
                    invoke2(bundle);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke  reason: avoid collision after fix types in other method */
                public final void invoke2(final Bundle bundle) {
                    Intrinsics.checkNotNullParameter(bundle, "");
                    boolean z = bundle.getBoolean("KEY_TRY_TO_FALLBACK");
                    QueueVerificationMethods PlaceComponentResult2 = ActivityVerificationStateManager.PlaceComponentResult(ActivityVerificationStateManager.this);
                    final ActivityVerificationStateManager activityVerificationStateManager = ActivityVerificationStateManager.this;
                    Function0<Unit> function0 = new Function0<Unit>() { // from class: id.dana.riskChallenges.ui.danaprotection.ActivityVerificationStateManager$executeRiskChallenge$2.1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(0);
                        }

                        @Override // kotlin.jvm.functions.Function0
                        public final /* bridge */ /* synthetic */ Unit invoke() {
                            invoke2();
                            return Unit.INSTANCE;
                        }

                        /* renamed from: invoke  reason: avoid collision after fix types in other method */
                        public final void invoke2() {
                            Parcelable parcelable;
                            Bundle bundle2 = bundle;
                            if (Build.VERSION.SDK_INT >= 33) {
                                parcelable = (Parcelable) bundle2.getParcelable("KEY_HISTORY_FALLBACK_MODEL", HistoryFallbackModel.class);
                            } else {
                                Parcelable parcelable2 = bundle2.getParcelable("KEY_HISTORY_FALLBACK_MODEL");
                                if (!(parcelable2 instanceof HistoryFallbackModel)) {
                                    parcelable2 = null;
                                }
                                parcelable = (HistoryFallbackModel) parcelable2;
                            }
                            ActivityVerificationStateManager.MyBillsEntityDataFactory(activityVerificationStateManager).KClassImpl$Data$declaredNonStaticMembers$2 = (HistoryFallbackModel) parcelable;
                            ActivityVerificationStateManager activityVerificationStateManager2 = activityVerificationStateManager;
                            ActivityVerificationStateManager.ActivityVerificationState.RiskChallenge riskChallenge = ActivityVerificationStateManager.ActivityVerificationState.RiskChallenge.INSTANCE;
                            Intrinsics.checkNotNullParameter(riskChallenge, "");
                            activityVerificationStateManager2.BuiltInFictitiousFunctionClassFactory(riskChallenge);
                        }
                    };
                    final ActivityVerificationStateManager activityVerificationStateManager2 = ActivityVerificationStateManager.this;
                    PlaceComponentResult2.KClassImpl$Data$declaredNonStaticMembers$2(z, function0, new Function0<Unit>() { // from class: id.dana.riskChallenges.ui.danaprotection.ActivityVerificationStateManager$executeRiskChallenge$2.2
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(0);
                        }

                        @Override // kotlin.jvm.functions.Function0
                        public final /* bridge */ /* synthetic */ Unit invoke() {
                            invoke2();
                            return Unit.INSTANCE;
                        }

                        /* renamed from: invoke  reason: avoid collision after fix types in other method */
                        public final void invoke2() {
                            ActivityVerificationStateManager activityVerificationStateManager3 = ActivityVerificationStateManager.this;
                            ActivityVerificationStateManager.ActivityVerificationState.Failed failed = new ActivityVerificationStateManager.ActivityVerificationState.Failed(bundle);
                            Intrinsics.checkNotNullParameter(failed, "");
                            activityVerificationStateManager3.BuiltInFictitiousFunctionClassFactory(failed);
                        }
                    });
                }
            }, new Function0<Unit>() { // from class: id.dana.riskChallenges.ui.danaprotection.ActivityVerificationStateManager$executeRiskChallenge$3
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public final /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke  reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    ActivityVerificationStateManager activityVerificationStateManager = ActivityVerificationStateManager.this;
                    ActivityVerificationStateManager.ActivityVerificationState.Canceled canceled = ActivityVerificationStateManager.ActivityVerificationState.Canceled.INSTANCE;
                    Intrinsics.checkNotNullParameter(canceled, "");
                    activityVerificationStateManager.BuiltInFictitiousFunctionClassFactory(canceled);
                }
            });
            PlaceComponentResult.BuiltInFictitiousFunctionClassFactory();
        } catch (Exception e) {
            Pair[] pairArr = new Pair[2];
            pairArr[0] = TuplesKt.to("KEY_IS_ERROR", Boolean.TRUE);
            String message = e.getMessage();
            if (message == null) {
                message = "";
            }
            pairArr[1] = TuplesKt.to("KEY_ERROR_MESSAGE", message);
            ActivityVerificationState.Failed failed = new ActivityVerificationState.Failed(BundleKt.PlaceComponentResult(pairArr));
            Intrinsics.checkNotNullParameter(failed, "");
            BuiltInFictitiousFunctionClassFactory(failed);
        }
    }
}
