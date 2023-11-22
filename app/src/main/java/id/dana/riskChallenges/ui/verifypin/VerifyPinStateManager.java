package id.dana.riskChallenges.ui.verifypin;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcelable;
import androidx.core.os.BundleKt;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentResultListener;
import id.dana.riskChallenges.constant.RiskChallengeKey;
import id.dana.riskChallenges.ui.resetpin.model.SecurityInfoModel;
import id.dana.riskChallenges.ui.resetpin.model.UseCaseStrategy;
import id.dana.riskChallenges.ui.resetpin.model.VerificationMethodModel;
import id.dana.riskChallenges.ui.util.model.BasicRiskChallengesModel;
import id.dana.riskChallenges.ui.util.model.HistoryFallbackModel;
import id.dana.riskChallenges.ui.util.statemanager.ChallengeState;
import id.dana.riskChallenges.ui.util.statemanager.ChangeStateListener;
import id.dana.riskChallenges.ui.util.statemanager.QueueVerificationMethods;
import id.dana.riskChallenges.ui.util.strategy.RiskChallengeStrategy;
import id.dana.riskChallenges.ui.util.strategy.RiskChallengeStrategyFactory;
import id.dana.riskChallenges.ui.util.uicomponent.UiComponent;
import id.dana.riskChallenges.ui.verifypin.VerifyPinStateManager;
import java.util.List;
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

@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002:\u0001.B1\u0012\u0006\u0010\u0005\u001a\u00020\r\u0012\u0006\u0010\n\u001a\u00020\u001e\u0012\u0006\u0010)\u001a\u00020\u0004\u0012\b\u0010*\u001a\u0004\u0018\u00010%\u0012\u0006\u0010+\u001a\u00020\u0004¢\u0006\u0004\b,\u0010-J\u0019\u0010\u0007\u001a\u00020\u00062\b\b\u0001\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u001f\u0010\u000b\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\tH\u0016¢\u0006\u0004\b\u000b\u0010\fR\u0014\u0010\u0010\u001a\u00020\r8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u0016\u0010\u0013\u001a\u00020\u00118\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b\u0007\u0010\u0012R\u0018\u0010\u0007\u001a\u0004\u0018\u00010\u00048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u0013\u0010\u000e\u001a\u00020\u0015X\u0082\u0080\u0002¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u0016\u0010\u0016\u001a\u00020\u00188\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b\u0010\u0010\u0019R\u0018\u0010\u001d\u001a\u0004\u0018\u00010\u001a8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001b\u0010\u001cR\u0014\u0010!\u001a\u00020\u001e8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001f\u0010 R\u0014\u0010\"\u001a\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\"\u0010\u0014R(\u0010\u001f\u001a\u0004\u0018\u00010\u00032\b\u0010\u0005\u001a\u0004\u0018\u00010\u00038\u0002@CX\u0082\u000e¢\u0006\f\n\u0004\b\u001d\u0010#\"\u0004\b\u0016\u0010$R\u0016\u0010\u001b\u001a\u0004\u0018\u00010%8\u0002X\u0083\u0004¢\u0006\u0006\n\u0004\b!\u0010&R\u0014\u0010(\u001a\u00020\u00048\u0002X\u0083\u0004¢\u0006\u0006\n\u0004\b'\u0010\u0014"}, d2 = {"Lid/dana/riskChallenges/ui/verifypin/VerifyPinStateManager;", "Lid/dana/riskChallenges/ui/util/statemanager/ChallengeState;", "Lid/dana/riskChallenges/ui/util/statemanager/ChangeStateListener;", "Lid/dana/riskChallenges/ui/verifypin/VerifyPinStateManager$VerifyPinState;", "", "p0", "", "PlaceComponentResult", "(Ljava/lang/String;)V", "Landroid/os/Bundle;", "p1", "onFragmentResult", "(Ljava/lang/String;Landroid/os/Bundle;)V", "Landroidx/fragment/app/FragmentActivity;", "KClassImpl$Data$declaredNonStaticMembers$2", "Landroidx/fragment/app/FragmentActivity;", "MyBillsEntityDataFactory", "Landroidx/fragment/app/FragmentResultListener;", "Landroidx/fragment/app/FragmentResultListener;", "getAuthRequestContext", "Ljava/lang/String;", "Lid/dana/riskChallenges/ui/util/statemanager/QueueVerificationMethods;", "BuiltInFictitiousFunctionClassFactory", "Lkotlin/Lazy;", "Lid/dana/riskChallenges/ui/util/strategy/RiskChallengeStrategyFactory;", "Lid/dana/riskChallenges/ui/util/strategy/RiskChallengeStrategyFactory;", "Lid/dana/riskChallenges/ui/util/model/BasicRiskChallengesModel;", "NetworkUserEntityData$$ExternalSyntheticLambda0", "Lid/dana/riskChallenges/ui/util/model/BasicRiskChallengesModel;", "lookAheadTest", "Lid/dana/riskChallenges/ui/resetpin/model/UseCaseStrategy;", "scheduleImpl", "Lid/dana/riskChallenges/ui/resetpin/model/UseCaseStrategy;", "moveToNextValue", "getErrorConfigVersion", "Lid/dana/riskChallenges/ui/verifypin/VerifyPinStateManager$VerifyPinState;", "(Lid/dana/riskChallenges/ui/verifypin/VerifyPinStateManager$VerifyPinState;)V", "Lid/dana/riskChallenges/ui/util/uicomponent/UiComponent;", "Lid/dana/riskChallenges/ui/util/uicomponent/UiComponent;", "DatabaseTableConfigUtil", "GetContactSyncConfig", "p2", "p3", "p4", "<init>", "(Landroidx/fragment/app/FragmentActivity;Lid/dana/riskChallenges/ui/resetpin/model/UseCaseStrategy;Ljava/lang/String;Lid/dana/riskChallenges/ui/util/uicomponent/UiComponent;Ljava/lang/String;)V", "VerifyPinState"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class VerifyPinStateManager implements ChallengeState, ChangeStateListener<VerifyPinState> {

    /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
    private final Lazy KClassImpl$Data$declaredNonStaticMembers$2;

    /* renamed from: DatabaseTableConfigUtil  reason: from kotlin metadata */
    private final String GetContactSyncConfig;

    /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
    private final FragmentActivity MyBillsEntityDataFactory;

    /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
    private RiskChallengeStrategyFactory BuiltInFictitiousFunctionClassFactory;

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda0  reason: from kotlin metadata */
    private BasicRiskChallengesModel lookAheadTest;

    /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
    private FragmentResultListener getAuthRequestContext;

    /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
    private String PlaceComponentResult;
    private final String getErrorConfigVersion;

    /* renamed from: lookAheadTest  reason: from kotlin metadata */
    private VerifyPinState scheduleImpl;

    /* renamed from: moveToNextValue  reason: from kotlin metadata */
    private final UiComponent NetworkUserEntityData$$ExternalSyntheticLambda0;

    /* renamed from: scheduleImpl  reason: from kotlin metadata */
    private final UseCaseStrategy moveToNextValue;

    public VerifyPinStateManager(FragmentActivity fragmentActivity, UseCaseStrategy useCaseStrategy, String str, UiComponent uiComponent, String str2) {
        Intrinsics.checkNotNullParameter(fragmentActivity, "");
        Intrinsics.checkNotNullParameter(useCaseStrategy, "");
        Intrinsics.checkNotNullParameter(str, "");
        Intrinsics.checkNotNullParameter(str2, "");
        this.MyBillsEntityDataFactory = fragmentActivity;
        this.moveToNextValue = useCaseStrategy;
        this.GetContactSyncConfig = str;
        this.NetworkUserEntityData$$ExternalSyntheticLambda0 = uiComponent;
        this.getErrorConfigVersion = str2;
        VerifyPinState.VerifyPin verifyPin = VerifyPinState.VerifyPin.INSTANCE;
        Intrinsics.checkNotNullParameter(verifyPin, "");
        BuiltInFictitiousFunctionClassFactory(verifyPin);
        this.KClassImpl$Data$declaredNonStaticMembers$2 = LazyKt.lazy(new Function0<QueueVerificationMethods>() { // from class: id.dana.riskChallenges.ui.verifypin.VerifyPinStateManager$queueVerificationMethods$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final QueueVerificationMethods invoke() {
                return new QueueVerificationMethods();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @JvmName(name = "BuiltInFictitiousFunctionClassFactory")
    public final void BuiltInFictitiousFunctionClassFactory(VerifyPinState verifyPinState) {
        this.scheduleImpl = verifyPinState;
        if (!(verifyPinState instanceof VerifyPinState.VerifyPin)) {
            if (!(verifyPinState instanceof VerifyPinState.Failed)) {
                if (!(verifyPinState instanceof VerifyPinState.Success)) {
                    if (!(verifyPinState instanceof VerifyPinState.Canceled)) {
                        if (!(verifyPinState instanceof VerifyPinState.RiskChallenge)) {
                            if (verifyPinState instanceof VerifyPinState.RiskReject) {
                                PlaceComponentResult(RiskChallengeKey.RISK_REJECT);
                                return;
                            }
                            return;
                        }
                        String BuiltInFictitiousFunctionClassFactory = ((QueueVerificationMethods) this.KClassImpl$Data$declaredNonStaticMembers$2.getValue()).BuiltInFictitiousFunctionClassFactory();
                        PlaceComponentResult(BuiltInFictitiousFunctionClassFactory != null ? BuiltInFictitiousFunctionClassFactory : "");
                        return;
                    }
                    this.MyBillsEntityDataFactory.setResult(0);
                    this.MyBillsEntityDataFactory.finish();
                    return;
                }
                Bundle bundle = ((VerifyPinState.Success) verifyPinState).BuiltInFictitiousFunctionClassFactory;
                Intrinsics.checkNotNullParameter(bundle, "");
                FragmentActivity fragmentActivity = this.MyBillsEntityDataFactory;
                Intent intent = new Intent();
                intent.putExtras(bundle);
                Unit unit = Unit.INSTANCE;
                fragmentActivity.setResult(-1, intent);
                this.MyBillsEntityDataFactory.finish();
                return;
            }
            Bundle bundle2 = ((VerifyPinState.Failed) verifyPinState).BuiltInFictitiousFunctionClassFactory;
            Intrinsics.checkNotNullParameter(bundle2, "");
            Intent intent2 = new Intent();
            intent2.putExtras(bundle2);
            this.MyBillsEntityDataFactory.setResult(0, intent2);
            this.MyBillsEntityDataFactory.finish();
            return;
        }
        VerifyPinChallengeStrategy verifyPinChallengeStrategy = new VerifyPinChallengeStrategy(this.MyBillsEntityDataFactory, this.moveToNextValue, this.GetContactSyncConfig, this.NetworkUserEntityData$$ExternalSyntheticLambda0, null, null, 48, null);
        Function1<Bundle, Unit> function1 = new Function1<Bundle, Unit>() { // from class: id.dana.riskChallenges.ui.verifypin.VerifyPinStateManager$before$verifyPinStrategy$1$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final /* bridge */ /* synthetic */ Unit invoke(Bundle bundle3) {
                invoke2(bundle3);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(Bundle bundle3) {
                Intrinsics.checkNotNullParameter(bundle3, "");
                VerifyPinStateManager.getAuthRequestContext(VerifyPinStateManager.this, bundle3);
            }
        };
        Function1<Bundle, Unit> function12 = new Function1<Bundle, Unit>() { // from class: id.dana.riskChallenges.ui.verifypin.VerifyPinStateManager$before$verifyPinStrategy$1$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final /* bridge */ /* synthetic */ Unit invoke(Bundle bundle3) {
                invoke2(bundle3);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(Bundle bundle3) {
                Intrinsics.checkNotNullParameter(bundle3, "");
                VerifyPinStateManager verifyPinStateManager = VerifyPinStateManager.this;
                VerifyPinStateManager.VerifyPinState.Failed failed = new VerifyPinStateManager.VerifyPinState.Failed(bundle3);
                Intrinsics.checkNotNullParameter(failed, "");
                verifyPinStateManager.BuiltInFictitiousFunctionClassFactory(failed);
            }
        };
        Function0<Unit> function0 = new Function0<Unit>() { // from class: id.dana.riskChallenges.ui.verifypin.VerifyPinStateManager$before$verifyPinStrategy$1$3
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
                VerifyPinStateManager verifyPinStateManager = VerifyPinStateManager.this;
                VerifyPinStateManager.VerifyPinState.Canceled canceled = VerifyPinStateManager.VerifyPinState.Canceled.INSTANCE;
                Intrinsics.checkNotNullParameter(canceled, "");
                verifyPinStateManager.BuiltInFictitiousFunctionClassFactory(canceled);
            }
        };
        verifyPinChallengeStrategy.NetworkUserEntityData$$ExternalSyntheticLambda0 = function1;
        verifyPinChallengeStrategy.BuiltInFictitiousFunctionClassFactory = function0;
        verifyPinChallengeStrategy.KClassImpl$Data$declaredNonStaticMembers$2 = function12;
        this.getAuthRequestContext = verifyPinChallengeStrategy;
        verifyPinChallengeStrategy.BuiltInFictitiousFunctionClassFactory();
    }

    private final void PlaceComponentResult(@RiskChallengeKey String p0) {
        try {
            RiskChallengeStrategyFactory riskChallengeStrategyFactory = this.BuiltInFictitiousFunctionClassFactory;
            if (riskChallengeStrategyFactory == null) {
                Intrinsics.throwUninitializedPropertyAccessException("");
                riskChallengeStrategyFactory = null;
            }
            RiskChallengeStrategy PlaceComponentResult = riskChallengeStrategyFactory.PlaceComponentResult(p0);
            PlaceComponentResult.BuiltInFictitiousFunctionClassFactory(new Function1<Bundle, Unit>() { // from class: id.dana.riskChallenges.ui.verifypin.VerifyPinStateManager$executeRiskChallenge$1
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
                    VerifyPinStateManager.MyBillsEntityDataFactory(VerifyPinStateManager.this, bundle.getString("KEY_RISK_TOKEN"));
                    QueueVerificationMethods authRequestContext = VerifyPinStateManager.getAuthRequestContext(VerifyPinStateManager.this);
                    final VerifyPinStateManager verifyPinStateManager = VerifyPinStateManager.this;
                    Function0<Unit> function0 = new Function0<Unit>() { // from class: id.dana.riskChallenges.ui.verifypin.VerifyPinStateManager$executeRiskChallenge$1.1
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
                            VerifyPinStateManager verifyPinStateManager2 = VerifyPinStateManager.this;
                            VerifyPinStateManager.VerifyPinState.RiskChallenge riskChallenge = VerifyPinStateManager.VerifyPinState.RiskChallenge.INSTANCE;
                            Intrinsics.checkNotNullParameter(riskChallenge, "");
                            verifyPinStateManager2.BuiltInFictitiousFunctionClassFactory(riskChallenge);
                        }
                    };
                    final VerifyPinStateManager verifyPinStateManager2 = VerifyPinStateManager.this;
                    authRequestContext.KClassImpl$Data$declaredNonStaticMembers$2(function0, new Function0<Unit>() { // from class: id.dana.riskChallenges.ui.verifypin.VerifyPinStateManager$executeRiskChallenge$1.2
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
                            BasicRiskChallengesModel basicRiskChallengesModel;
                            String str;
                            basicRiskChallengesModel = VerifyPinStateManager.this.lookAheadTest;
                            str = VerifyPinStateManager.this.PlaceComponentResult;
                            Bundle PlaceComponentResult2 = BundleKt.PlaceComponentResult(TuplesKt.to("KEY_DATA_RISK_CONSULT", basicRiskChallengesModel), TuplesKt.to("KEY_PHONE_NUMBER", str));
                            VerifyPinStateManager verifyPinStateManager3 = VerifyPinStateManager.this;
                            VerifyPinStateManager.VerifyPinState.Success success = new VerifyPinStateManager.VerifyPinState.Success(PlaceComponentResult2);
                            Intrinsics.checkNotNullParameter(success, "");
                            verifyPinStateManager3.BuiltInFictitiousFunctionClassFactory(success);
                        }
                    });
                }
            }, new Function1<Bundle, Unit>() { // from class: id.dana.riskChallenges.ui.verifypin.VerifyPinStateManager$executeRiskChallenge$2
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
                    QueueVerificationMethods authRequestContext = VerifyPinStateManager.getAuthRequestContext(VerifyPinStateManager.this);
                    final VerifyPinStateManager verifyPinStateManager = VerifyPinStateManager.this;
                    Function0<Unit> function0 = new Function0<Unit>() { // from class: id.dana.riskChallenges.ui.verifypin.VerifyPinStateManager$executeRiskChallenge$2.1
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
                            RiskChallengeStrategyFactory riskChallengeStrategyFactory2;
                            Bundle bundle2 = bundle;
                            RiskChallengeStrategyFactory riskChallengeStrategyFactory3 = null;
                            if (Build.VERSION.SDK_INT >= 33) {
                                parcelable = (Parcelable) bundle2.getParcelable("KEY_HISTORY_FALLBACK_MODEL", HistoryFallbackModel.class);
                            } else {
                                Parcelable parcelable2 = bundle2.getParcelable("KEY_HISTORY_FALLBACK_MODEL");
                                if (!(parcelable2 instanceof HistoryFallbackModel)) {
                                    parcelable2 = null;
                                }
                                parcelable = (HistoryFallbackModel) parcelable2;
                            }
                            HistoryFallbackModel historyFallbackModel = (HistoryFallbackModel) parcelable;
                            riskChallengeStrategyFactory2 = verifyPinStateManager.BuiltInFictitiousFunctionClassFactory;
                            if (riskChallengeStrategyFactory2 == null) {
                                Intrinsics.throwUninitializedPropertyAccessException("");
                            } else {
                                riskChallengeStrategyFactory3 = riskChallengeStrategyFactory2;
                            }
                            riskChallengeStrategyFactory3.KClassImpl$Data$declaredNonStaticMembers$2 = historyFallbackModel;
                            VerifyPinStateManager verifyPinStateManager2 = verifyPinStateManager;
                            VerifyPinStateManager.VerifyPinState.RiskChallenge riskChallenge = VerifyPinStateManager.VerifyPinState.RiskChallenge.INSTANCE;
                            Intrinsics.checkNotNullParameter(riskChallenge, "");
                            verifyPinStateManager2.BuiltInFictitiousFunctionClassFactory(riskChallenge);
                        }
                    };
                    final VerifyPinStateManager verifyPinStateManager2 = VerifyPinStateManager.this;
                    authRequestContext.KClassImpl$Data$declaredNonStaticMembers$2(z, function0, new Function0<Unit>() { // from class: id.dana.riskChallenges.ui.verifypin.VerifyPinStateManager$executeRiskChallenge$2.2
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
                            VerifyPinStateManager verifyPinStateManager3 = VerifyPinStateManager.this;
                            VerifyPinStateManager.VerifyPinState.Failed failed = new VerifyPinStateManager.VerifyPinState.Failed(bundle);
                            Intrinsics.checkNotNullParameter(failed, "");
                            verifyPinStateManager3.BuiltInFictitiousFunctionClassFactory(failed);
                        }
                    });
                }
            }, new Function0<Unit>() { // from class: id.dana.riskChallenges.ui.verifypin.VerifyPinStateManager$executeRiskChallenge$3
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
                    VerifyPinStateManager verifyPinStateManager = VerifyPinStateManager.this;
                    VerifyPinStateManager.VerifyPinState.Canceled canceled = VerifyPinStateManager.VerifyPinState.Canceled.INSTANCE;
                    Intrinsics.checkNotNullParameter(canceled, "");
                    verifyPinStateManager.BuiltInFictitiousFunctionClassFactory(canceled);
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
            VerifyPinState.Failed failed = new VerifyPinState.Failed(BundleKt.PlaceComponentResult(pairArr));
            Intrinsics.checkNotNullParameter(failed, "");
            BuiltInFictitiousFunctionClassFactory(failed);
        }
    }

    @Override // androidx.fragment.app.FragmentResultListener
    public final void onFragmentResult(String p0, Bundle p1) {
        Intrinsics.checkNotNullParameter(p0, "");
        Intrinsics.checkNotNullParameter(p1, "");
        FragmentResultListener fragmentResultListener = this.getAuthRequestContext;
        if (fragmentResultListener == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            fragmentResultListener = null;
        }
        fragmentResultListener.onFragmentResult(p0, p1);
    }

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\b6\u0018\u00002\u00020\u0001:\u0006\u0004\u0005\u0006\u0007\b\tB\t\b\u0004¢\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\u0006\n\u000b\f\r\u000e\u000f"}, d2 = {"Lid/dana/riskChallenges/ui/verifypin/VerifyPinStateManager$VerifyPinState;", "", "<init>", "()V", "Canceled", "Failed", "RiskChallenge", "RiskReject", "Success", "VerifyPin", "Lid/dana/riskChallenges/ui/verifypin/VerifyPinStateManager$VerifyPinState$VerifyPin;", "Lid/dana/riskChallenges/ui/verifypin/VerifyPinStateManager$VerifyPinState$RiskChallenge;", "Lid/dana/riskChallenges/ui/verifypin/VerifyPinStateManager$VerifyPinState$Success;", "Lid/dana/riskChallenges/ui/verifypin/VerifyPinStateManager$VerifyPinState$Failed;", "Lid/dana/riskChallenges/ui/verifypin/VerifyPinStateManager$VerifyPinState$Canceled;", "Lid/dana/riskChallenges/ui/verifypin/VerifyPinStateManager$VerifyPinState$RiskReject;"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static abstract class VerifyPinState {
        public /* synthetic */ VerifyPinState(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private VerifyPinState() {
        }

        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lid/dana/riskChallenges/ui/verifypin/VerifyPinStateManager$VerifyPinState$VerifyPin;", "Lid/dana/riskChallenges/ui/verifypin/VerifyPinStateManager$VerifyPinState;", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
        /* loaded from: classes5.dex */
        public static final class VerifyPin extends VerifyPinState {
            public static final VerifyPin INSTANCE = new VerifyPin();

            private VerifyPin() {
                super(null);
            }
        }

        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lid/dana/riskChallenges/ui/verifypin/VerifyPinStateManager$VerifyPinState$RiskChallenge;", "Lid/dana/riskChallenges/ui/verifypin/VerifyPinStateManager$VerifyPinState;", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
        /* loaded from: classes5.dex */
        public static final class RiskChallenge extends VerifyPinState {
            public static final RiskChallenge INSTANCE = new RiskChallenge();

            private RiskChallenge() {
                super(null);
            }
        }

        @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\r¢\u0006\u0004\b\u0010\u0010\u0011J\u001a\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002HÖ\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u0010\u0010\b\u001a\u00020\u0007HÖ\u0001¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\u000b\u001a\u00020\nHÖ\u0001¢\u0006\u0004\b\u000b\u0010\fR\u0011\u0010\u000e\u001a\u00020\rX\u0006¢\u0006\u0006\n\u0004\b\u000e\u0010\u000f"}, d2 = {"Lid/dana/riskChallenges/ui/verifypin/VerifyPinStateManager$VerifyPinState$Success;", "Lid/dana/riskChallenges/ui/verifypin/VerifyPinStateManager$VerifyPinState;", "", "p0", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "", "toString", "()Ljava/lang/String;", "Landroid/os/Bundle;", "BuiltInFictitiousFunctionClassFactory", "Landroid/os/Bundle;", "<init>", "(Landroid/os/Bundle;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
        /* loaded from: classes5.dex */
        public static final /* data */ class Success extends VerifyPinState {
            final Bundle BuiltInFictitiousFunctionClassFactory;

            public final boolean equals(Object p0) {
                if (this == p0) {
                    return true;
                }
                return (p0 instanceof Success) && Intrinsics.areEqual(this.BuiltInFictitiousFunctionClassFactory, ((Success) p0).BuiltInFictitiousFunctionClassFactory);
            }

            public final int hashCode() {
                return this.BuiltInFictitiousFunctionClassFactory.hashCode();
            }

            public final String toString() {
                StringBuilder sb = new StringBuilder();
                sb.append("Success(BuiltInFictitiousFunctionClassFactory=");
                sb.append(this.BuiltInFictitiousFunctionClassFactory);
                sb.append(')');
                return sb.toString();
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public Success(Bundle bundle) {
                super(null);
                Intrinsics.checkNotNullParameter(bundle, "");
                this.BuiltInFictitiousFunctionClassFactory = bundle;
            }
        }

        @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\r¢\u0006\u0004\b\u0011\u0010\u0012J\u001a\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002HÖ\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u0010\u0010\b\u001a\u00020\u0007HÖ\u0001¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\u000b\u001a\u00020\nHÖ\u0001¢\u0006\u0004\b\u000b\u0010\fR\u0011\u0010\u0010\u001a\u00020\rX\u0006¢\u0006\u0006\n\u0004\b\u000e\u0010\u000f"}, d2 = {"Lid/dana/riskChallenges/ui/verifypin/VerifyPinStateManager$VerifyPinState$Failed;", "Lid/dana/riskChallenges/ui/verifypin/VerifyPinStateManager$VerifyPinState;", "", "p0", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "", "toString", "()Ljava/lang/String;", "Landroid/os/Bundle;", "MyBillsEntityDataFactory", "Landroid/os/Bundle;", "BuiltInFictitiousFunctionClassFactory", "<init>", "(Landroid/os/Bundle;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
        /* loaded from: classes5.dex */
        public static final /* data */ class Failed extends VerifyPinState {

            /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
            final Bundle BuiltInFictitiousFunctionClassFactory;

            public final boolean equals(Object p0) {
                if (this == p0) {
                    return true;
                }
                return (p0 instanceof Failed) && Intrinsics.areEqual(this.BuiltInFictitiousFunctionClassFactory, ((Failed) p0).BuiltInFictitiousFunctionClassFactory);
            }

            public final int hashCode() {
                return this.BuiltInFictitiousFunctionClassFactory.hashCode();
            }

            public final String toString() {
                StringBuilder sb = new StringBuilder();
                sb.append("Failed(BuiltInFictitiousFunctionClassFactory=");
                sb.append(this.BuiltInFictitiousFunctionClassFactory);
                sb.append(')');
                return sb.toString();
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public Failed(Bundle bundle) {
                super(null);
                Intrinsics.checkNotNullParameter(bundle, "");
                this.BuiltInFictitiousFunctionClassFactory = bundle;
            }
        }

        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lid/dana/riskChallenges/ui/verifypin/VerifyPinStateManager$VerifyPinState$Canceled;", "Lid/dana/riskChallenges/ui/verifypin/VerifyPinStateManager$VerifyPinState;", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
        /* loaded from: classes5.dex */
        public static final class Canceled extends VerifyPinState {
            public static final Canceled INSTANCE = new Canceled();

            private Canceled() {
                super(null);
            }
        }

        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lid/dana/riskChallenges/ui/verifypin/VerifyPinStateManager$VerifyPinState$RiskReject;", "Lid/dana/riskChallenges/ui/verifypin/VerifyPinStateManager$VerifyPinState;", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
        /* loaded from: classes5.dex */
        public static final class RiskReject extends VerifyPinState {
            public static final RiskReject INSTANCE = new RiskReject();

            private RiskReject() {
                super(null);
            }
        }
    }

    public static final /* synthetic */ void MyBillsEntityDataFactory(VerifyPinStateManager verifyPinStateManager, String str) {
        BasicRiskChallengesModel basicRiskChallengesModel;
        if (!Intrinsics.areEqual(verifyPinStateManager.moveToNextValue.getAuthRequestContext, "MODIFY_PASSWORD") || (basicRiskChallengesModel = verifyPinStateManager.lookAheadTest) == null || str == null) {
            return;
        }
        verifyPinStateManager.lookAheadTest = new BasicRiskChallengesModel(str, basicRiskChallengesModel.getPlaceComponentResult(), basicRiskChallengesModel.getAuthRequestContext());
        RiskChallengeStrategyFactory riskChallengeStrategyFactory = verifyPinStateManager.BuiltInFictitiousFunctionClassFactory;
        if (riskChallengeStrategyFactory == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            riskChallengeStrategyFactory = null;
        }
        riskChallengeStrategyFactory.getErrorConfigVersion = str;
    }

    public static final /* synthetic */ void getAuthRequestContext(final VerifyPinStateManager verifyPinStateManager, Bundle bundle) {
        Parcelable parcelable;
        SecurityInfoModel placeComponentResult;
        List<VerificationMethodModel> authRequestContext;
        String string = bundle.getString("KEY_RISK_RESULT");
        if (string != null) {
            int hashCode = string.hashCode();
            if (hashCode == -1881380961) {
                if (string.equals("REJECT")) {
                    String string2 = bundle.getString("KEY_PHONE_NUMBER");
                    RiskChallengeStrategyFactory riskChallengeStrategyFactory = new RiskChallengeStrategyFactory(verifyPinStateManager.MyBillsEntityDataFactory, "", string2 == null ? "" : string2, verifyPinStateManager.NetworkUserEntityData$$ExternalSyntheticLambda0, verifyPinStateManager.moveToNextValue, MapsKt.mapOf(TuplesKt.to("KEY_SOURCE", verifyPinStateManager.getErrorConfigVersion)), new Function0<String>() { // from class: id.dana.riskChallenges.ui.verifypin.VerifyPinStateManager$doVerifyPinSuccess$3
                        /* JADX INFO: Access modifiers changed from: package-private */
                        {
                            super(0);
                        }

                        @Override // kotlin.jvm.functions.Function0
                        public final String invoke() {
                            return VerifyPinStateManager.getAuthRequestContext(VerifyPinStateManager.this).getAuthRequestContext();
                        }
                    });
                    Function1<FragmentResultListener, Unit> function1 = new Function1<FragmentResultListener, Unit>() { // from class: id.dana.riskChallenges.ui.verifypin.VerifyPinStateManager$doVerifyPinSuccess$4$1
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
                            VerifyPinStateManager.this.getAuthRequestContext = fragmentResultListener;
                        }
                    };
                    Intrinsics.checkNotNullParameter(function1, "");
                    riskChallengeStrategyFactory.PlaceComponentResult = function1;
                    verifyPinStateManager.BuiltInFictitiousFunctionClassFactory = riskChallengeStrategyFactory;
                    VerifyPinState.RiskReject riskReject = VerifyPinState.RiskReject.INSTANCE;
                    Intrinsics.checkNotNullParameter(riskReject, "");
                    verifyPinStateManager.BuiltInFictitiousFunctionClassFactory(riskReject);
                }
            } else if (hashCode != 832880155) {
                if (hashCode == 1924835592 && string.equals("ACCEPT")) {
                    VerifyPinState.Success success = new VerifyPinState.Success(bundle);
                    Intrinsics.checkNotNullParameter(success, "");
                    verifyPinStateManager.BuiltInFictitiousFunctionClassFactory(success);
                }
            } else if (string.equals("VERIFICATION")) {
                if (Build.VERSION.SDK_INT >= 33) {
                    parcelable = (Parcelable) bundle.getParcelable("KEY_DATA_RISK_CONSULT", BasicRiskChallengesModel.class);
                } else {
                    Parcelable parcelable2 = bundle.getParcelable("KEY_DATA_RISK_CONSULT");
                    if (!(parcelable2 instanceof BasicRiskChallengesModel)) {
                        parcelable2 = null;
                    }
                    parcelable = (BasicRiskChallengesModel) parcelable2;
                }
                verifyPinStateManager.lookAheadTest = (BasicRiskChallengesModel) parcelable;
                verifyPinStateManager.PlaceComponentResult = bundle.getString("KEY_PHONE_NUMBER");
                BasicRiskChallengesModel basicRiskChallengesModel = verifyPinStateManager.lookAheadTest;
                if (basicRiskChallengesModel != null) {
                    if ((basicRiskChallengesModel == null || (authRequestContext = basicRiskChallengesModel.getAuthRequestContext()) == null || !(authRequestContext.isEmpty() ^ true)) ? false : true) {
                        FragmentActivity fragmentActivity = verifyPinStateManager.MyBillsEntityDataFactory;
                        BasicRiskChallengesModel basicRiskChallengesModel2 = verifyPinStateManager.lookAheadTest;
                        String str = (basicRiskChallengesModel2 == null || (placeComponentResult = basicRiskChallengesModel2.getPlaceComponentResult()) == null) ? null : placeComponentResult.MyBillsEntityDataFactory;
                        String str2 = str == null ? "" : str;
                        String str3 = verifyPinStateManager.PlaceComponentResult;
                        RiskChallengeStrategyFactory riskChallengeStrategyFactory2 = new RiskChallengeStrategyFactory(fragmentActivity, str2, str3 == null ? "" : str3, verifyPinStateManager.NetworkUserEntityData$$ExternalSyntheticLambda0, verifyPinStateManager.moveToNextValue, MapsKt.mapOf(TuplesKt.to("KEY_SOURCE", verifyPinStateManager.getErrorConfigVersion)), new Function0<String>() { // from class: id.dana.riskChallenges.ui.verifypin.VerifyPinStateManager$doVerifyPinSuccess$1
                            /* JADX INFO: Access modifiers changed from: package-private */
                            {
                                super(0);
                            }

                            @Override // kotlin.jvm.functions.Function0
                            public final String invoke() {
                                return VerifyPinStateManager.getAuthRequestContext(VerifyPinStateManager.this).getAuthRequestContext();
                            }
                        });
                        Function1<FragmentResultListener, Unit> function12 = new Function1<FragmentResultListener, Unit>() { // from class: id.dana.riskChallenges.ui.verifypin.VerifyPinStateManager$doVerifyPinSuccess$2$1
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
                                VerifyPinStateManager.this.getAuthRequestContext = fragmentResultListener;
                            }
                        };
                        Intrinsics.checkNotNullParameter(function12, "");
                        riskChallengeStrategyFactory2.PlaceComponentResult = function12;
                        BasicRiskChallengesModel basicRiskChallengesModel3 = verifyPinStateManager.lookAheadTest;
                        riskChallengeStrategyFactory2.getErrorConfigVersion = basicRiskChallengesModel3 != null ? basicRiskChallengesModel3.getKClassImpl$Data$declaredNonStaticMembers$2() : null;
                        verifyPinStateManager.BuiltInFictitiousFunctionClassFactory = riskChallengeStrategyFactory2;
                        ((QueueVerificationMethods) verifyPinStateManager.KClassImpl$Data$declaredNonStaticMembers$2.getValue()).BuiltInFictitiousFunctionClassFactory(verifyPinStateManager.lookAheadTest);
                        VerifyPinState.RiskChallenge riskChallenge = VerifyPinState.RiskChallenge.INSTANCE;
                        Intrinsics.checkNotNullParameter(riskChallenge, "");
                        verifyPinStateManager.BuiltInFictitiousFunctionClassFactory(riskChallenge);
                        return;
                    }
                }
                VerifyPinState.Success success2 = new VerifyPinState.Success(bundle);
                Intrinsics.checkNotNullParameter(success2, "");
                verifyPinStateManager.BuiltInFictitiousFunctionClassFactory(success2);
            }
        }
    }

    public static final /* synthetic */ QueueVerificationMethods getAuthRequestContext(VerifyPinStateManager verifyPinStateManager) {
        return (QueueVerificationMethods) verifyPinStateManager.KClassImpl$Data$declaredNonStaticMembers$2.getValue();
    }
}
