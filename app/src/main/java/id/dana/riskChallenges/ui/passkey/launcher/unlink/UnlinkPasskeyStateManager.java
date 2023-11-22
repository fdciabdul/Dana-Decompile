package id.dana.riskChallenges.ui.passkey.launcher.unlink;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcelable;
import androidx.core.os.BundleKt;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentResultListener;
import id.dana.riskChallenges.R;
import id.dana.riskChallenges.constant.RiskChallengeKey;
import id.dana.riskChallenges.ui.passkey.PasskeyRiskChallengeStrategy;
import id.dana.riskChallenges.ui.passkey.launcher.unlink.UnlinkPasskeyStateManager;
import id.dana.riskChallenges.ui.resetpin.model.SecurityInfoModel;
import id.dana.riskChallenges.ui.resetpin.model.UseCaseStrategy;
import id.dana.riskChallenges.ui.util.model.BasicRiskChallengesModel;
import id.dana.riskChallenges.ui.util.model.HistoryFallbackModel;
import id.dana.riskChallenges.ui.util.statemanager.ChallengeState;
import id.dana.riskChallenges.ui.util.statemanager.ChangeStateListener;
import id.dana.riskChallenges.ui.util.statemanager.QueueVerificationMethods;
import id.dana.riskChallenges.ui.util.strategy.RiskChallengeStrategy;
import id.dana.riskChallenges.ui.util.strategy.RiskChallengeStrategyFactory;
import id.dana.riskChallenges.ui.util.uicomponent.UIComponentType;
import id.dana.riskChallenges.ui.util.uicomponent.UiComponent;
import id.dana.utils.foundation.logger.log.DanaLog;
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

@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 )2\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002:\u0002)*B\u0019\b\u0002\u0012\u0006\u0010\u0005\u001a\u00020\r\u0012\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b'\u0010(J\u001f\u0010\t\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\t\u0010\nJ\u0019\u0010\u000b\u001a\u00020\b2\b\b\u0001\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u000b\u0010\fR\u0014\u0010\u0010\u001a\u00020\r8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u0016\u0010\u000b\u001a\u00020\u00118\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b\u0010\u0010\u0012R\u0016\u0010\u000e\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u0014\u0010\u0013\u001a\u00020\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u0016\u0010\u0015\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u000b\u0010\u0014R\u0016\u0010\u0018\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0017\u0010\u0014R\u0013\u0010\u0017\u001a\u00020\u0019X\u0082\u0080\u0002¢\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u0013\u0010\u001a\u001a\u00020\u001cX\u0082\u0080\u0002¢\u0006\u0006\n\u0004\b\u0018\u0010\u001bR\u0016\u0010 \u001a\u0004\u0018\u00010\u001d8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u0018\u0010\u001e\u001a\u0004\u0018\u00010!8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b \u0010\"R\u0016\u0010$\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b#\u0010\u0014R(\u0010#\u001a\u0004\u0018\u00010\u00032\b\u0010\u0005\u001a\u0004\u0018\u00010\u00038\u0002@CX\u0082\u000e¢\u0006\f\n\u0004\b$\u0010%\"\u0004\b\u0013\u0010&"}, d2 = {"Lid/dana/riskChallenges/ui/passkey/launcher/unlink/UnlinkPasskeyStateManager;", "Lid/dana/riskChallenges/ui/util/statemanager/ChallengeState;", "Lid/dana/riskChallenges/ui/util/statemanager/ChangeStateListener;", "Lid/dana/riskChallenges/ui/passkey/launcher/unlink/UnlinkPasskeyStateManager$UnlinkPasskeyState;", "", "p0", "Landroid/os/Bundle;", "p1", "", "onFragmentResult", "(Ljava/lang/String;Landroid/os/Bundle;)V", "BuiltInFictitiousFunctionClassFactory", "(Ljava/lang/String;)V", "Landroidx/fragment/app/FragmentActivity;", "PlaceComponentResult", "Landroidx/fragment/app/FragmentActivity;", "getAuthRequestContext", "Landroidx/fragment/app/FragmentResultListener;", "Landroidx/fragment/app/FragmentResultListener;", "MyBillsEntityDataFactory", "Ljava/lang/String;", "KClassImpl$Data$declaredNonStaticMembers$2", "Landroid/os/Bundle;", "NetworkUserEntityData$$ExternalSyntheticLambda0", "moveToNextValue", "Lid/dana/riskChallenges/ui/util/statemanager/QueueVerificationMethods;", "getErrorConfigVersion", "Lkotlin/Lazy;", "Lid/dana/riskChallenges/ui/util/strategy/RiskChallengeStrategyFactory;", "Lid/dana/riskChallenges/ui/util/model/BasicRiskChallengesModel;", "scheduleImpl", "Lid/dana/riskChallenges/ui/util/model/BasicRiskChallengesModel;", "lookAheadTest", "Lid/dana/riskChallenges/ui/resetpin/model/UseCaseStrategy;", "Lid/dana/riskChallenges/ui/resetpin/model/UseCaseStrategy;", "NetworkUserEntityData$$ExternalSyntheticLambda1", "GetContactSyncConfig", "Lid/dana/riskChallenges/ui/passkey/launcher/unlink/UnlinkPasskeyStateManager$UnlinkPasskeyState;", "(Lid/dana/riskChallenges/ui/passkey/launcher/unlink/UnlinkPasskeyStateManager$UnlinkPasskeyState;)V", "<init>", "(Landroidx/fragment/app/FragmentActivity;Landroid/os/Bundle;)V", "Companion", "UnlinkPasskeyState"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class UnlinkPasskeyStateManager implements ChallengeState, ChangeStateListener<UnlinkPasskeyState> {

    /* renamed from: Companion  reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
    private String KClassImpl$Data$declaredNonStaticMembers$2;

    /* renamed from: GetContactSyncConfig  reason: from kotlin metadata */
    private UnlinkPasskeyState NetworkUserEntityData$$ExternalSyntheticLambda1;

    /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
    private final Bundle MyBillsEntityDataFactory;

    /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
    private String PlaceComponentResult;

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda0  reason: from kotlin metadata */
    private String moveToNextValue;

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda1  reason: from kotlin metadata */
    private String GetContactSyncConfig;

    /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
    private final FragmentActivity getAuthRequestContext;

    /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
    private FragmentResultListener BuiltInFictitiousFunctionClassFactory;

    /* renamed from: getErrorConfigVersion  reason: from kotlin metadata */
    private final Lazy NetworkUserEntityData$$ExternalSyntheticLambda0;

    /* renamed from: lookAheadTest  reason: from kotlin metadata */
    private UseCaseStrategy scheduleImpl;

    /* renamed from: moveToNextValue  reason: from kotlin metadata */
    private final Lazy getErrorConfigVersion;

    /* renamed from: scheduleImpl  reason: from kotlin metadata */
    private final BasicRiskChallengesModel lookAheadTest;

    public /* synthetic */ UnlinkPasskeyStateManager(FragmentActivity fragmentActivity, Bundle bundle, DefaultConstructorMarker defaultConstructorMarker) {
        this(fragmentActivity, bundle);
    }

    private UnlinkPasskeyStateManager(FragmentActivity fragmentActivity, Bundle bundle) {
        Parcelable parcelable;
        Parcelable parcelable2;
        this.getAuthRequestContext = fragmentActivity;
        this.MyBillsEntityDataFactory = bundle;
        this.NetworkUserEntityData$$ExternalSyntheticLambda0 = LazyKt.lazy(new Function0<QueueVerificationMethods>() { // from class: id.dana.riskChallenges.ui.passkey.launcher.unlink.UnlinkPasskeyStateManager$queueVerificationMethods$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final QueueVerificationMethods invoke() {
                return new QueueVerificationMethods();
            }
        });
        if (Build.VERSION.SDK_INT >= 33) {
            parcelable = (Parcelable) bundle.getParcelable("KEY_DATA_RISK_CONSULT", BasicRiskChallengesModel.class);
        } else {
            Parcelable parcelable3 = bundle.getParcelable("KEY_DATA_RISK_CONSULT");
            parcelable = (BasicRiskChallengesModel) (parcelable3 instanceof BasicRiskChallengesModel ? parcelable3 : null);
        }
        BasicRiskChallengesModel basicRiskChallengesModel = (BasicRiskChallengesModel) parcelable;
        this.lookAheadTest = basicRiskChallengesModel;
        String string = bundle.getString("KEY_PHONE_NUMBER");
        this.KClassImpl$Data$declaredNonStaticMembers$2 = string == null ? "" : string;
        if (Build.VERSION.SDK_INT >= 33) {
            parcelable2 = (Parcelable) bundle.getParcelable("KEY_USE_CASE_STRATEGY", UseCaseStrategy.class);
        } else {
            Parcelable parcelable4 = bundle.getParcelable("KEY_USE_CASE_STRATEGY");
            parcelable2 = (UseCaseStrategy) (parcelable4 instanceof UseCaseStrategy ? parcelable4 : null);
        }
        this.scheduleImpl = (UseCaseStrategy) parcelable2;
        String string2 = bundle.getString("KEY_SOURCE");
        this.GetContactSyncConfig = string2 == null ? "" : string2;
        String string3 = bundle.getString("KEY_PURPOSE");
        this.moveToNextValue = string3 == null ? "" : string3;
        String string4 = bundle.getString("KEY_STRATEGY");
        this.PlaceComponentResult = string4 == null ? "" : string4;
        this.getErrorConfigVersion = LazyKt.lazy(new Function0<RiskChallengeStrategyFactory>() { // from class: id.dana.riskChallenges.ui.passkey.launcher.unlink.UnlinkPasskeyStateManager$rcStrategyFactory$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final RiskChallengeStrategyFactory invoke() {
                FragmentActivity fragmentActivity2;
                BasicRiskChallengesModel basicRiskChallengesModel2;
                String str;
                UseCaseStrategy useCaseStrategy;
                String str2;
                String str3;
                SecurityInfoModel placeComponentResult;
                fragmentActivity2 = UnlinkPasskeyStateManager.this.getAuthRequestContext;
                basicRiskChallengesModel2 = UnlinkPasskeyStateManager.this.lookAheadTest;
                String str4 = (basicRiskChallengesModel2 == null || (placeComponentResult = basicRiskChallengesModel2.getPlaceComponentResult()) == null) ? null : placeComponentResult.MyBillsEntityDataFactory;
                String str5 = str4 == null ? "" : str4;
                str = UnlinkPasskeyStateManager.this.KClassImpl$Data$declaredNonStaticMembers$2;
                UiComponent uiComponent = new UiComponent(UIComponentType.Full, R.color.KClassImpl$Data$declaredNonStaticMembers$2, R.string.verify_pin_title);
                useCaseStrategy = UnlinkPasskeyStateManager.this.scheduleImpl;
                if (useCaseStrategy == null) {
                    useCaseStrategy = new UseCaseStrategy("", null, null, 6, null);
                }
                str2 = UnlinkPasskeyStateManager.this.GetContactSyncConfig;
                str3 = UnlinkPasskeyStateManager.this.moveToNextValue;
                Map mapOf = MapsKt.mapOf(TuplesKt.to("KEY_SOURCE", str2), TuplesKt.to("KEY_PURPOSE", str3));
                final UnlinkPasskeyStateManager unlinkPasskeyStateManager = UnlinkPasskeyStateManager.this;
                RiskChallengeStrategyFactory riskChallengeStrategyFactory = new RiskChallengeStrategyFactory(fragmentActivity2, str5, str, uiComponent, useCaseStrategy, mapOf, new Function0<String>() { // from class: id.dana.riskChallenges.ui.passkey.launcher.unlink.UnlinkPasskeyStateManager$rcStrategyFactory$2.1
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public final String invoke() {
                        return UnlinkPasskeyStateManager.KClassImpl$Data$declaredNonStaticMembers$2(UnlinkPasskeyStateManager.this).getAuthRequestContext();
                    }
                });
                final UnlinkPasskeyStateManager unlinkPasskeyStateManager2 = UnlinkPasskeyStateManager.this;
                Function1<FragmentResultListener, Unit> function1 = new Function1<FragmentResultListener, Unit>() { // from class: id.dana.riskChallenges.ui.passkey.launcher.unlink.UnlinkPasskeyStateManager$rcStrategyFactory$2$2$1
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
                        UnlinkPasskeyStateManager.this.BuiltInFictitiousFunctionClassFactory = fragmentResultListener;
                    }
                };
                Intrinsics.checkNotNullParameter(function1, "");
                riskChallengeStrategyFactory.PlaceComponentResult = function1;
                return riskChallengeStrategyFactory;
            }
        });
        ((QueueVerificationMethods) this.NetworkUserEntityData$$ExternalSyntheticLambda0.getValue()).BuiltInFictitiousFunctionClassFactory(basicRiskChallengesModel);
        UnlinkPasskeyState.Initial initial = UnlinkPasskeyState.Initial.INSTANCE;
        Intrinsics.checkNotNullParameter(initial, "");
        MyBillsEntityDataFactory(initial);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @JvmName(name = "MyBillsEntityDataFactory")
    public final void MyBillsEntityDataFactory(UnlinkPasskeyState unlinkPasskeyState) {
        this.NetworkUserEntityData$$ExternalSyntheticLambda1 = unlinkPasskeyState;
        if (!Intrinsics.areEqual(unlinkPasskeyState, UnlinkPasskeyState.Canceled.INSTANCE)) {
            if (!(unlinkPasskeyState instanceof UnlinkPasskeyState.Failed)) {
                if (!Intrinsics.areEqual(unlinkPasskeyState, UnlinkPasskeyState.Success.INSTANCE)) {
                    if (!Intrinsics.areEqual(unlinkPasskeyState, UnlinkPasskeyState.Initial.INSTANCE)) {
                        if (!Intrinsics.areEqual(unlinkPasskeyState, UnlinkPasskeyState.RiskReject.INSTANCE)) {
                            if (Intrinsics.areEqual(unlinkPasskeyState, UnlinkPasskeyState.RiskChallenge.INSTANCE)) {
                                DanaLog.MyBillsEntityDataFactory("PASSKEY", "executeRiskChallenge invoked");
                                String BuiltInFictitiousFunctionClassFactory = ((QueueVerificationMethods) this.NetworkUserEntityData$$ExternalSyntheticLambda0.getValue()).BuiltInFictitiousFunctionClassFactory();
                                BuiltInFictitiousFunctionClassFactory(BuiltInFictitiousFunctionClassFactory != null ? BuiltInFictitiousFunctionClassFactory : "");
                                return;
                            }
                            return;
                        }
                        BuiltInFictitiousFunctionClassFactory(RiskChallengeKey.RISK_REJECT);
                        return;
                    }
                    PasskeyRiskChallengeStrategy passkeyRiskChallengeStrategy = new PasskeyRiskChallengeStrategy(this.getAuthRequestContext, this.PlaceComponentResult, this.GetContactSyncConfig, this.moveToNextValue, this.MyBillsEntityDataFactory);
                    Function1<Bundle, Unit> function1 = new Function1<Bundle, Unit>() { // from class: id.dana.riskChallenges.ui.passkey.launcher.unlink.UnlinkPasskeyStateManager$createPasskeyChallengeStrategy$1$1
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
                            if (bundle.getBoolean("KEY_NEED_HANDLE_VERIFICATION_METHOD", false)) {
                                UnlinkPasskeyStateManager unlinkPasskeyStateManager = UnlinkPasskeyStateManager.this;
                                UnlinkPasskeyStateManager.UnlinkPasskeyState.RiskChallenge riskChallenge = UnlinkPasskeyStateManager.UnlinkPasskeyState.RiskChallenge.INSTANCE;
                                Intrinsics.checkNotNullParameter(riskChallenge, "");
                                unlinkPasskeyStateManager.MyBillsEntityDataFactory(riskChallenge);
                                return;
                            }
                            UnlinkPasskeyStateManager unlinkPasskeyStateManager2 = UnlinkPasskeyStateManager.this;
                            UnlinkPasskeyStateManager.UnlinkPasskeyState.Success success = UnlinkPasskeyStateManager.UnlinkPasskeyState.Success.INSTANCE;
                            Intrinsics.checkNotNullParameter(success, "");
                            unlinkPasskeyStateManager2.MyBillsEntityDataFactory(success);
                        }
                    };
                    Function1<Bundle, Unit> function12 = new Function1<Bundle, Unit>() { // from class: id.dana.riskChallenges.ui.passkey.launcher.unlink.UnlinkPasskeyStateManager$createPasskeyChallengeStrategy$1$2
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
                            QueueVerificationMethods KClassImpl$Data$declaredNonStaticMembers$2 = UnlinkPasskeyStateManager.KClassImpl$Data$declaredNonStaticMembers$2(UnlinkPasskeyStateManager.this);
                            final UnlinkPasskeyStateManager unlinkPasskeyStateManager = UnlinkPasskeyStateManager.this;
                            Function0<Unit> function0 = new Function0<Unit>() { // from class: id.dana.riskChallenges.ui.passkey.launcher.unlink.UnlinkPasskeyStateManager$createPasskeyChallengeStrategy$1$2.1
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
                                    UnlinkPasskeyStateManager.lookAheadTest(unlinkPasskeyStateManager).KClassImpl$Data$declaredNonStaticMembers$2 = (HistoryFallbackModel) parcelable;
                                    UnlinkPasskeyStateManager unlinkPasskeyStateManager2 = unlinkPasskeyStateManager;
                                    UnlinkPasskeyStateManager.UnlinkPasskeyState.RiskChallenge riskChallenge = UnlinkPasskeyStateManager.UnlinkPasskeyState.RiskChallenge.INSTANCE;
                                    Intrinsics.checkNotNullParameter(riskChallenge, "");
                                    unlinkPasskeyStateManager2.MyBillsEntityDataFactory(riskChallenge);
                                }
                            };
                            final UnlinkPasskeyStateManager unlinkPasskeyStateManager2 = UnlinkPasskeyStateManager.this;
                            KClassImpl$Data$declaredNonStaticMembers$2.KClassImpl$Data$declaredNonStaticMembers$2(z, function0, new Function0<Unit>() { // from class: id.dana.riskChallenges.ui.passkey.launcher.unlink.UnlinkPasskeyStateManager$createPasskeyChallengeStrategy$1$2.2
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
                                    UnlinkPasskeyStateManager unlinkPasskeyStateManager3 = UnlinkPasskeyStateManager.this;
                                    UnlinkPasskeyStateManager.UnlinkPasskeyState.Failed failed = new UnlinkPasskeyStateManager.UnlinkPasskeyState.Failed(bundle);
                                    Intrinsics.checkNotNullParameter(failed, "");
                                    unlinkPasskeyStateManager3.MyBillsEntityDataFactory(failed);
                                }
                            });
                        }
                    };
                    Function0<Unit> function0 = new Function0<Unit>() { // from class: id.dana.riskChallenges.ui.passkey.launcher.unlink.UnlinkPasskeyStateManager$createPasskeyChallengeStrategy$1$3
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
                            UnlinkPasskeyStateManager unlinkPasskeyStateManager = UnlinkPasskeyStateManager.this;
                            UnlinkPasskeyStateManager.UnlinkPasskeyState.Canceled canceled = UnlinkPasskeyStateManager.UnlinkPasskeyState.Canceled.INSTANCE;
                            Intrinsics.checkNotNullParameter(canceled, "");
                            unlinkPasskeyStateManager.MyBillsEntityDataFactory(canceled);
                        }
                    };
                    passkeyRiskChallengeStrategy.moveToNextValue = function1;
                    passkeyRiskChallengeStrategy.BuiltInFictitiousFunctionClassFactory = function12;
                    passkeyRiskChallengeStrategy.KClassImpl$Data$declaredNonStaticMembers$2 = function0;
                    passkeyRiskChallengeStrategy.BuiltInFictitiousFunctionClassFactory();
                    this.BuiltInFictitiousFunctionClassFactory = passkeyRiskChallengeStrategy;
                    return;
                }
                Intrinsics.checkNotNullParameter(BundleKt.BuiltInFictitiousFunctionClassFactory(), "");
                this.getAuthRequestContext.setResult(-1);
                this.getAuthRequestContext.finish();
                return;
            }
            Bundle bundle = ((UnlinkPasskeyState.Failed) unlinkPasskeyState).BuiltInFictitiousFunctionClassFactory;
            Intrinsics.checkNotNullParameter(bundle, "");
            Intent intent = new Intent();
            intent.putExtras(bundle);
            this.getAuthRequestContext.setResult(0, intent);
            this.getAuthRequestContext.finish();
            return;
        }
        this.getAuthRequestContext.setResult(0);
        this.getAuthRequestContext.finish();
    }

    @Override // androidx.fragment.app.FragmentResultListener
    public final void onFragmentResult(String p0, Bundle p1) {
        Intrinsics.checkNotNullParameter(p0, "");
        Intrinsics.checkNotNullParameter(p1, "");
        FragmentResultListener fragmentResultListener = this.BuiltInFictitiousFunctionClassFactory;
        if (fragmentResultListener == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            fragmentResultListener = null;
        }
        fragmentResultListener.onFragmentResult(p0, p1);
    }

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\b6\u0018\u00002\u00020\u0001:\u0006\u0004\u0005\u0006\u0007\b\tB\t\b\u0004¢\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\u0006\n\u000b\f\r\u000e\u000f"}, d2 = {"Lid/dana/riskChallenges/ui/passkey/launcher/unlink/UnlinkPasskeyStateManager$UnlinkPasskeyState;", "", "<init>", "()V", "Canceled", "Failed", "Initial", "RiskChallenge", "RiskReject", "Success", "Lid/dana/riskChallenges/ui/passkey/launcher/unlink/UnlinkPasskeyStateManager$UnlinkPasskeyState$Initial;", "Lid/dana/riskChallenges/ui/passkey/launcher/unlink/UnlinkPasskeyStateManager$UnlinkPasskeyState$Success;", "Lid/dana/riskChallenges/ui/passkey/launcher/unlink/UnlinkPasskeyStateManager$UnlinkPasskeyState$Canceled;", "Lid/dana/riskChallenges/ui/passkey/launcher/unlink/UnlinkPasskeyStateManager$UnlinkPasskeyState$RiskReject;", "Lid/dana/riskChallenges/ui/passkey/launcher/unlink/UnlinkPasskeyStateManager$UnlinkPasskeyState$RiskChallenge;", "Lid/dana/riskChallenges/ui/passkey/launcher/unlink/UnlinkPasskeyStateManager$UnlinkPasskeyState$Failed;"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static abstract class UnlinkPasskeyState {
        public /* synthetic */ UnlinkPasskeyState(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lid/dana/riskChallenges/ui/passkey/launcher/unlink/UnlinkPasskeyStateManager$UnlinkPasskeyState$Initial;", "Lid/dana/riskChallenges/ui/passkey/launcher/unlink/UnlinkPasskeyStateManager$UnlinkPasskeyState;", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
        /* loaded from: classes5.dex */
        public static final class Initial extends UnlinkPasskeyState {
            public static final Initial INSTANCE = new Initial();

            private Initial() {
                super(null);
            }
        }

        private UnlinkPasskeyState() {
        }

        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lid/dana/riskChallenges/ui/passkey/launcher/unlink/UnlinkPasskeyStateManager$UnlinkPasskeyState$Success;", "Lid/dana/riskChallenges/ui/passkey/launcher/unlink/UnlinkPasskeyStateManager$UnlinkPasskeyState;", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
        /* loaded from: classes5.dex */
        public static final class Success extends UnlinkPasskeyState {
            public static final Success INSTANCE = new Success();

            private Success() {
                super(null);
            }
        }

        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lid/dana/riskChallenges/ui/passkey/launcher/unlink/UnlinkPasskeyStateManager$UnlinkPasskeyState$Canceled;", "Lid/dana/riskChallenges/ui/passkey/launcher/unlink/UnlinkPasskeyStateManager$UnlinkPasskeyState;", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
        /* loaded from: classes5.dex */
        public static final class Canceled extends UnlinkPasskeyState {
            public static final Canceled INSTANCE = new Canceled();

            private Canceled() {
                super(null);
            }
        }

        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lid/dana/riskChallenges/ui/passkey/launcher/unlink/UnlinkPasskeyStateManager$UnlinkPasskeyState$RiskReject;", "Lid/dana/riskChallenges/ui/passkey/launcher/unlink/UnlinkPasskeyStateManager$UnlinkPasskeyState;", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
        /* loaded from: classes5.dex */
        public static final class RiskReject extends UnlinkPasskeyState {
            public static final RiskReject INSTANCE = new RiskReject();

            private RiskReject() {
                super(null);
            }
        }

        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lid/dana/riskChallenges/ui/passkey/launcher/unlink/UnlinkPasskeyStateManager$UnlinkPasskeyState$RiskChallenge;", "Lid/dana/riskChallenges/ui/passkey/launcher/unlink/UnlinkPasskeyStateManager$UnlinkPasskeyState;", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
        /* loaded from: classes5.dex */
        public static final class RiskChallenge extends UnlinkPasskeyState {
            public static final RiskChallenge INSTANCE = new RiskChallenge();

            private RiskChallenge() {
                super(null);
            }
        }

        @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\r¢\u0006\u0004\b\u0011\u0010\u0012J\u001a\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002HÖ\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u0010\u0010\b\u001a\u00020\u0007HÖ\u0001¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\u000b\u001a\u00020\nHÖ\u0001¢\u0006\u0004\b\u000b\u0010\fR\u0011\u0010\u0010\u001a\u00020\rX\u0006¢\u0006\u0006\n\u0004\b\u000e\u0010\u000f"}, d2 = {"Lid/dana/riskChallenges/ui/passkey/launcher/unlink/UnlinkPasskeyStateManager$UnlinkPasskeyState$Failed;", "Lid/dana/riskChallenges/ui/passkey/launcher/unlink/UnlinkPasskeyStateManager$UnlinkPasskeyState;", "", "p0", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "", "toString", "()Ljava/lang/String;", "Landroid/os/Bundle;", "PlaceComponentResult", "Landroid/os/Bundle;", "BuiltInFictitiousFunctionClassFactory", "<init>", "(Landroid/os/Bundle;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
        /* loaded from: classes5.dex */
        public static final /* data */ class Failed extends UnlinkPasskeyState {

            /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
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
    }

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\t\u0010\nJ\u001d\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\b"}, d2 = {"Lid/dana/riskChallenges/ui/passkey/launcher/unlink/UnlinkPasskeyStateManager$Companion;", "", "Landroidx/fragment/app/FragmentActivity;", "p0", "Landroid/os/Bundle;", "p1", "Lid/dana/riskChallenges/ui/passkey/launcher/unlink/UnlinkPasskeyStateManager;", "MyBillsEntityDataFactory", "(Landroidx/fragment/app/FragmentActivity;Landroid/os/Bundle;)Lid/dana/riskChallenges/ui/passkey/launcher/unlink/UnlinkPasskeyStateManager;", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public static UnlinkPasskeyStateManager MyBillsEntityDataFactory(FragmentActivity p0, Bundle p1) {
            Intrinsics.checkNotNullParameter(p0, "");
            Intrinsics.checkNotNullParameter(p1, "");
            return new UnlinkPasskeyStateManager(p0, p1, null);
        }
    }

    public static final /* synthetic */ QueueVerificationMethods KClassImpl$Data$declaredNonStaticMembers$2(UnlinkPasskeyStateManager unlinkPasskeyStateManager) {
        return (QueueVerificationMethods) unlinkPasskeyStateManager.NetworkUserEntityData$$ExternalSyntheticLambda0.getValue();
    }

    public static final /* synthetic */ RiskChallengeStrategyFactory lookAheadTest(UnlinkPasskeyStateManager unlinkPasskeyStateManager) {
        return (RiskChallengeStrategyFactory) unlinkPasskeyStateManager.getErrorConfigVersion.getValue();
    }

    private final void BuiltInFictitiousFunctionClassFactory(@RiskChallengeKey String p0) {
        try {
            RiskChallengeStrategy PlaceComponentResult = ((RiskChallengeStrategyFactory) this.getErrorConfigVersion.getValue()).PlaceComponentResult(p0);
            PlaceComponentResult.BuiltInFictitiousFunctionClassFactory(new Function1<Bundle, Unit>() { // from class: id.dana.riskChallenges.ui.passkey.launcher.unlink.UnlinkPasskeyStateManager$onHandleRiskChallenge$1
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
                    UnlinkPasskeyStateManager unlinkPasskeyStateManager = UnlinkPasskeyStateManager.this;
                    String string = bundle.getString("KEY_PHONE_NUMBER");
                    unlinkPasskeyStateManager.KClassImpl$Data$declaredNonStaticMembers$2 = string != null ? string : "";
                    QueueVerificationMethods KClassImpl$Data$declaredNonStaticMembers$2 = UnlinkPasskeyStateManager.KClassImpl$Data$declaredNonStaticMembers$2(UnlinkPasskeyStateManager.this);
                    final UnlinkPasskeyStateManager unlinkPasskeyStateManager2 = UnlinkPasskeyStateManager.this;
                    Function0<Unit> function0 = new Function0<Unit>() { // from class: id.dana.riskChallenges.ui.passkey.launcher.unlink.UnlinkPasskeyStateManager$onHandleRiskChallenge$1.1
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
                            UnlinkPasskeyStateManager unlinkPasskeyStateManager3 = UnlinkPasskeyStateManager.this;
                            UnlinkPasskeyStateManager.UnlinkPasskeyState.RiskChallenge riskChallenge = UnlinkPasskeyStateManager.UnlinkPasskeyState.RiskChallenge.INSTANCE;
                            Intrinsics.checkNotNullParameter(riskChallenge, "");
                            unlinkPasskeyStateManager3.MyBillsEntityDataFactory(riskChallenge);
                        }
                    };
                    final UnlinkPasskeyStateManager unlinkPasskeyStateManager3 = UnlinkPasskeyStateManager.this;
                    KClassImpl$Data$declaredNonStaticMembers$2.KClassImpl$Data$declaredNonStaticMembers$2(function0, new Function0<Unit>() { // from class: id.dana.riskChallenges.ui.passkey.launcher.unlink.UnlinkPasskeyStateManager$onHandleRiskChallenge$1.2
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
                            Bundle bundle2;
                            bundle2 = UnlinkPasskeyStateManager.this.MyBillsEntityDataFactory;
                            bundle2.remove("KEY_NEED_HANDLE_VERIFICATION_METHOD");
                            UnlinkPasskeyStateManager unlinkPasskeyStateManager4 = UnlinkPasskeyStateManager.this;
                            UnlinkPasskeyStateManager.UnlinkPasskeyState.Initial initial = UnlinkPasskeyStateManager.UnlinkPasskeyState.Initial.INSTANCE;
                            Intrinsics.checkNotNullParameter(initial, "");
                            unlinkPasskeyStateManager4.MyBillsEntityDataFactory(initial);
                        }
                    });
                }
            }, new Function1<Bundle, Unit>() { // from class: id.dana.riskChallenges.ui.passkey.launcher.unlink.UnlinkPasskeyStateManager$onHandleRiskChallenge$2
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
                    QueueVerificationMethods KClassImpl$Data$declaredNonStaticMembers$2 = UnlinkPasskeyStateManager.KClassImpl$Data$declaredNonStaticMembers$2(UnlinkPasskeyStateManager.this);
                    final UnlinkPasskeyStateManager unlinkPasskeyStateManager = UnlinkPasskeyStateManager.this;
                    Function0<Unit> function0 = new Function0<Unit>() { // from class: id.dana.riskChallenges.ui.passkey.launcher.unlink.UnlinkPasskeyStateManager$onHandleRiskChallenge$2.1
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
                            UnlinkPasskeyStateManager.lookAheadTest(unlinkPasskeyStateManager).KClassImpl$Data$declaredNonStaticMembers$2 = (HistoryFallbackModel) parcelable;
                            UnlinkPasskeyStateManager unlinkPasskeyStateManager2 = unlinkPasskeyStateManager;
                            UnlinkPasskeyStateManager.UnlinkPasskeyState.RiskChallenge riskChallenge = UnlinkPasskeyStateManager.UnlinkPasskeyState.RiskChallenge.INSTANCE;
                            Intrinsics.checkNotNullParameter(riskChallenge, "");
                            unlinkPasskeyStateManager2.MyBillsEntityDataFactory(riskChallenge);
                        }
                    };
                    final UnlinkPasskeyStateManager unlinkPasskeyStateManager2 = UnlinkPasskeyStateManager.this;
                    KClassImpl$Data$declaredNonStaticMembers$2.KClassImpl$Data$declaredNonStaticMembers$2(z, function0, new Function0<Unit>() { // from class: id.dana.riskChallenges.ui.passkey.launcher.unlink.UnlinkPasskeyStateManager$onHandleRiskChallenge$2.2
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
                            UnlinkPasskeyStateManager unlinkPasskeyStateManager3 = UnlinkPasskeyStateManager.this;
                            UnlinkPasskeyStateManager.UnlinkPasskeyState.Failed failed = new UnlinkPasskeyStateManager.UnlinkPasskeyState.Failed(bundle);
                            Intrinsics.checkNotNullParameter(failed, "");
                            unlinkPasskeyStateManager3.MyBillsEntityDataFactory(failed);
                        }
                    });
                }
            }, new Function0<Unit>() { // from class: id.dana.riskChallenges.ui.passkey.launcher.unlink.UnlinkPasskeyStateManager$onHandleRiskChallenge$3
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
                    UnlinkPasskeyStateManager unlinkPasskeyStateManager = UnlinkPasskeyStateManager.this;
                    UnlinkPasskeyStateManager.UnlinkPasskeyState.Canceled canceled = UnlinkPasskeyStateManager.UnlinkPasskeyState.Canceled.INSTANCE;
                    Intrinsics.checkNotNullParameter(canceled, "");
                    unlinkPasskeyStateManager.MyBillsEntityDataFactory(canceled);
                }
            });
            RiskChallengeStrategyFactory riskChallengeStrategyFactory = (RiskChallengeStrategyFactory) this.getErrorConfigVersion.getValue();
            Function1<FragmentResultListener, Unit> function1 = new Function1<FragmentResultListener, Unit>() { // from class: id.dana.riskChallenges.ui.passkey.launcher.unlink.UnlinkPasskeyStateManager$onHandleRiskChallenge$4
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
                    UnlinkPasskeyStateManager.this.BuiltInFictitiousFunctionClassFactory = fragmentResultListener;
                }
            };
            Intrinsics.checkNotNullParameter(function1, "");
            riskChallengeStrategyFactory.PlaceComponentResult = function1;
            PlaceComponentResult.BuiltInFictitiousFunctionClassFactory();
        } catch (Exception e) {
            Pair[] pairArr = new Pair[2];
            pairArr[0] = TuplesKt.to("KEY_IS_ERROR", Boolean.TRUE);
            String message = e.getMessage();
            if (message == null) {
                message = "";
            }
            pairArr[1] = TuplesKt.to("KEY_ERROR_MESSAGE", message);
            UnlinkPasskeyState.Failed failed = new UnlinkPasskeyState.Failed(BundleKt.PlaceComponentResult(pairArr));
            Intrinsics.checkNotNullParameter(failed, "");
            MyBillsEntityDataFactory(failed);
        }
    }
}
