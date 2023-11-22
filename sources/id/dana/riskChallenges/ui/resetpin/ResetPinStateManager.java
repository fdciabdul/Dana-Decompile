package id.dana.riskChallenges.ui.resetpin;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcelable;
import androidx.core.os.BundleKt;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentResultListener;
import id.dana.analytics.mixpanel.MixPanelEvent;
import id.dana.analytics.tracker.TrackerKey;
import id.dana.riskChallenges.constant.RiskChallengeKey;
import id.dana.riskChallenges.ui.resetpin.ResetPinStateManager;
import id.dana.riskChallenges.ui.resetpin.model.ResetPinModel;
import id.dana.riskChallenges.ui.resetpin.model.SecurityInfoModel;
import id.dana.riskChallenges.ui.resetpin.model.UseCaseStrategy;
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

@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002:\u00013B_\u0012\u0006\u0010\u0005\u001a\u00020\r\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010(\u0012\n\b\u0002\u0010*\u001a\u0004\u0018\u00010\u0018\u0012\n\b\u0002\u0010+\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010,\u001a\u0004\u0018\u00010\"\u0012\u0006\u0010-\u001a\u00020\u0004\u0012\b\b\u0002\u0010.\u001a\u00020\u0003\u0012\u0006\u0010/\u001a\u00020\u0004\u0012\u0006\u00100\u001a\u00020\u0004¢\u0006\u0004\b1\u00102J\u0019\u0010\u0007\u001a\u00020\u00062\b\b\u0001\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u001f\u0010\u000b\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\tH\u0016¢\u0006\u0004\b\u000b\u0010\fR\u0011\u0010\u0010\u001a\u00020\rX\u0006¢\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u0016\u0010\u0014\u001a\u00020\u00118\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u0011\u0010\u0007\u001a\u00020\u0003X\u0006¢\u0006\u0006\n\u0004\b\u0010\u0010\u0015R\u0013\u0010\u0017\u001a\u0004\u0018\u00010\u0004X\u0006¢\u0006\u0006\n\u0004\b\u0007\u0010\u0016R\u0013\u0010\u000e\u001a\u0004\u0018\u00010\u0018X\u0006¢\u0006\u0006\n\u0004\b\u0017\u0010\u0019R\u0011\u0010\u001a\u001a\u00020\u0004X\u0006¢\u0006\u0006\n\u0004\b\u0014\u0010\u0016R\u0013\u0010\u001e\u001a\u00020\u001bX\u0082\u0080\u0002¢\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\u0013\u0010!\u001a\u00020\u001fX\u0082\u0080\u0002¢\u0006\u0006\n\u0004\b \u0010\u001dR\u0013\u0010\u0012\u001a\u0004\u0018\u00010\"X\u0006¢\u0006\u0006\n\u0004\b\u001e\u0010#R\u0011\u0010$\u001a\u00020\u0004X\u0006¢\u0006\u0006\n\u0004\b\u001a\u0010\u0016R(\u0010%\u001a\u0004\u0018\u00010\u00032\b\u0010\u0005\u001a\u0004\u0018\u00010\u00038\u0002@CX\u0082\u000e¢\u0006\f\n\u0004\b%\u0010\u0015\"\u0004\b\u0014\u0010&R\u0011\u0010'\u001a\u00020\u0004X\u0007¢\u0006\u0006\n\u0004\b$\u0010\u0016R\u0013\u0010 \u001a\u0004\u0018\u00010(X\u0007¢\u0006\u0006\n\u0004\b!\u0010)"}, d2 = {"Lid/dana/riskChallenges/ui/resetpin/ResetPinStateManager;", "Lid/dana/riskChallenges/ui/util/statemanager/ChallengeState;", "Lid/dana/riskChallenges/ui/util/statemanager/ChangeStateListener;", "Lid/dana/riskChallenges/ui/resetpin/ResetPinStateManager$ResetPinState;", "", "p0", "", "KClassImpl$Data$declaredNonStaticMembers$2", "(Ljava/lang/String;)V", "Landroid/os/Bundle;", "p1", "onFragmentResult", "(Ljava/lang/String;Landroid/os/Bundle;)V", "Landroidx/fragment/app/FragmentActivity;", "getAuthRequestContext", "Landroidx/fragment/app/FragmentActivity;", "PlaceComponentResult", "Landroidx/fragment/app/FragmentResultListener;", "lookAheadTest", "Landroidx/fragment/app/FragmentResultListener;", "BuiltInFictitiousFunctionClassFactory", "Lid/dana/riskChallenges/ui/resetpin/ResetPinStateManager$ResetPinState;", "Ljava/lang/String;", "MyBillsEntityDataFactory", "Lid/dana/riskChallenges/ui/resetpin/model/ResetPinModel;", "Lid/dana/riskChallenges/ui/resetpin/model/ResetPinModel;", "NetworkUserEntityData$$ExternalSyntheticLambda0", "Lid/dana/riskChallenges/ui/util/statemanager/QueueVerificationMethods;", "NetworkUserEntityData$$ExternalSyntheticLambda2", "Lkotlin/Lazy;", "moveToNextValue", "Lid/dana/riskChallenges/ui/util/strategy/RiskChallengeStrategyFactory;", "initRecordTimeStamp", "getErrorConfigVersion", "Lid/dana/riskChallenges/ui/resetpin/model/UseCaseStrategy;", "Lid/dana/riskChallenges/ui/resetpin/model/UseCaseStrategy;", "scheduleImpl", "GetContactSyncConfig", "(Lid/dana/riskChallenges/ui/resetpin/ResetPinStateManager$ResetPinState;)V", "NetworkUserEntityData$$ExternalSyntheticLambda1", "Lid/dana/riskChallenges/ui/util/uicomponent/UiComponent;", "Lid/dana/riskChallenges/ui/util/uicomponent/UiComponent;", "p2", "p3", "p4", "p5", "p6", "p7", "p8", "<init>", "(Landroidx/fragment/app/FragmentActivity;Lid/dana/riskChallenges/ui/util/uicomponent/UiComponent;Lid/dana/riskChallenges/ui/resetpin/model/ResetPinModel;Ljava/lang/String;Lid/dana/riskChallenges/ui/resetpin/model/UseCaseStrategy;Ljava/lang/String;Lid/dana/riskChallenges/ui/resetpin/ResetPinStateManager$ResetPinState;Ljava/lang/String;Ljava/lang/String;)V", "ResetPinState"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class ResetPinStateManager implements ChallengeState, ChangeStateListener<ResetPinState> {

    /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
    final String NetworkUserEntityData$$ExternalSyntheticLambda0;
    private ResetPinState GetContactSyncConfig;

    /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
    public final String MyBillsEntityDataFactory;

    /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
    final ResetPinModel getAuthRequestContext;

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda0  reason: from kotlin metadata */
    final String scheduleImpl;

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda2  reason: from kotlin metadata */
    private final Lazy moveToNextValue;

    /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
    public final ResetPinState KClassImpl$Data$declaredNonStaticMembers$2;

    /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
    final FragmentActivity PlaceComponentResult;

    /* renamed from: getErrorConfigVersion  reason: from kotlin metadata */
    final UiComponent initRecordTimeStamp;

    /* renamed from: initRecordTimeStamp  reason: from kotlin metadata */
    private final Lazy getErrorConfigVersion;

    /* renamed from: lookAheadTest  reason: from kotlin metadata */
    private FragmentResultListener BuiltInFictitiousFunctionClassFactory;

    /* renamed from: moveToNextValue  reason: from kotlin metadata */
    final UseCaseStrategy lookAheadTest;

    /* renamed from: scheduleImpl  reason: from kotlin metadata */
    final String NetworkUserEntityData$$ExternalSyntheticLambda1;

    private ResetPinStateManager(FragmentActivity fragmentActivity, UiComponent uiComponent, ResetPinModel resetPinModel, String str, UseCaseStrategy useCaseStrategy, String str2, ResetPinState resetPinState, String str3, String str4) {
        Intrinsics.checkNotNullParameter(fragmentActivity, "");
        Intrinsics.checkNotNullParameter(str2, "");
        Intrinsics.checkNotNullParameter(resetPinState, "");
        Intrinsics.checkNotNullParameter(str3, "");
        Intrinsics.checkNotNullParameter(str4, "");
        this.PlaceComponentResult = fragmentActivity;
        this.initRecordTimeStamp = uiComponent;
        this.getAuthRequestContext = resetPinModel;
        this.MyBillsEntityDataFactory = str;
        this.lookAheadTest = useCaseStrategy;
        this.NetworkUserEntityData$$ExternalSyntheticLambda0 = str2;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = resetPinState;
        this.scheduleImpl = str3;
        this.NetworkUserEntityData$$ExternalSyntheticLambda1 = str4;
        this.getErrorConfigVersion = LazyKt.lazy(new Function0<RiskChallengeStrategyFactory>() { // from class: id.dana.riskChallenges.ui.resetpin.ResetPinStateManager$rcStrategyFactory$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final RiskChallengeStrategyFactory invoke() {
                SecurityInfoModel securityInfoModel;
                FragmentActivity fragmentActivity2 = ResetPinStateManager.this.PlaceComponentResult;
                ResetPinModel resetPinModel2 = ResetPinStateManager.this.getAuthRequestContext;
                String str5 = (resetPinModel2 == null || (securityInfoModel = resetPinModel2.PlaceComponentResult) == null) ? null : securityInfoModel.MyBillsEntityDataFactory;
                String str6 = str5 == null ? "" : str5;
                String str7 = ResetPinStateManager.this.NetworkUserEntityData$$ExternalSyntheticLambda0;
                UiComponent uiComponent2 = ResetPinStateManager.this.initRecordTimeStamp;
                UseCaseStrategy useCaseStrategy2 = ResetPinStateManager.this.lookAheadTest;
                if (useCaseStrategy2 == null) {
                    useCaseStrategy2 = new UseCaseStrategy("", null, null, 6, null);
                }
                Map mapOf = MapsKt.mapOf(TuplesKt.to("KEY_SOURCE", ResetPinStateManager.this.scheduleImpl), TuplesKt.to("KEY_PURPOSE", ResetPinStateManager.this.NetworkUserEntityData$$ExternalSyntheticLambda1));
                final ResetPinStateManager resetPinStateManager = ResetPinStateManager.this;
                RiskChallengeStrategyFactory riskChallengeStrategyFactory = new RiskChallengeStrategyFactory(fragmentActivity2, str6, str7, uiComponent2, useCaseStrategy2, mapOf, new Function0<String>() { // from class: id.dana.riskChallenges.ui.resetpin.ResetPinStateManager$rcStrategyFactory$2.1
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public final String invoke() {
                        return ResetPinStateManager.KClassImpl$Data$declaredNonStaticMembers$2(ResetPinStateManager.this).getAuthRequestContext();
                    }
                });
                final ResetPinStateManager resetPinStateManager2 = ResetPinStateManager.this;
                Function1<FragmentResultListener, Unit> function1 = new Function1<FragmentResultListener, Unit>() { // from class: id.dana.riskChallenges.ui.resetpin.ResetPinStateManager$rcStrategyFactory$2$2$1
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
                        ResetPinStateManager.this.BuiltInFictitiousFunctionClassFactory = fragmentResultListener;
                    }
                };
                Intrinsics.checkNotNullParameter(function1, "");
                riskChallengeStrategyFactory.PlaceComponentResult = function1;
                return riskChallengeStrategyFactory;
            }
        });
        Lazy lazy = LazyKt.lazy(new Function0<QueueVerificationMethods>() { // from class: id.dana.riskChallenges.ui.resetpin.ResetPinStateManager$queueVerificationMethods$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final QueueVerificationMethods invoke() {
                return new QueueVerificationMethods();
            }
        });
        this.moveToNextValue = lazy;
        ((QueueVerificationMethods) lazy.getValue()).BuiltInFictitiousFunctionClassFactory(resetPinModel);
        Intrinsics.checkNotNullParameter(resetPinState, "");
        BuiltInFictitiousFunctionClassFactory(resetPinState);
    }

    public /* synthetic */ ResetPinStateManager(FragmentActivity fragmentActivity, UiComponent uiComponent, ResetPinModel resetPinModel, String str, UseCaseStrategy useCaseStrategy, String str2, ResetPinState resetPinState, String str3, String str4, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(fragmentActivity, (i & 2) != 0 ? null : uiComponent, (i & 4) != 0 ? null : resetPinModel, (i & 8) != 0 ? null : str, useCaseStrategy, str2, (i & 64) != 0 ? ResetPinState.RiskChallenge.INSTANCE : resetPinState, str3, str4);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @JvmName(name = "BuiltInFictitiousFunctionClassFactory")
    public final void BuiltInFictitiousFunctionClassFactory(ResetPinState resetPinState) {
        SecurityInfoModel securityInfoModel;
        this.GetContactSyncConfig = resetPinState;
        if (!(resetPinState instanceof ResetPinState.RiskChallenge)) {
            if (!(resetPinState instanceof ResetPinState.CreateNewPin)) {
                byte b = 0;
                if (!(resetPinState instanceof ResetPinState.Success)) {
                    if (!(resetPinState instanceof ResetPinState.Failed)) {
                        if (!(resetPinState instanceof ResetPinState.Canceled)) {
                            if (resetPinState instanceof ResetPinState.RiskReject) {
                                KClassImpl$Data$declaredNonStaticMembers$2(RiskChallengeKey.RISK_REJECT);
                                return;
                            }
                            return;
                        }
                        this.PlaceComponentResult.setResult(0);
                        this.PlaceComponentResult.finish();
                        return;
                    }
                    Bundle bundle = ((ResetPinState.Failed) resetPinState).MyBillsEntityDataFactory;
                    Intrinsics.checkNotNullParameter(bundle, "");
                    Intent intent = new Intent();
                    intent.putExtras(bundle);
                    this.PlaceComponentResult.setResult(0, intent);
                    this.PlaceComponentResult.finish();
                    return;
                }
                Intrinsics.checkNotNullParameter(BundleKt.BuiltInFictitiousFunctionClassFactory(), "");
                MixPanelEvent.Builder builder = new MixPanelEvent.Builder(this.PlaceComponentResult.getBaseContext());
                builder.KClassImpl$Data$declaredNonStaticMembers$2 = TrackerKey.Event.PIN_CREATE_COMPLETE;
                new MixPanelEvent(builder.KClassImpl$Data$declaredNonStaticMembers$2("Source", Intrinsics.areEqual(this.MyBillsEntityDataFactory, "Pre-Login") ? TrackerKey.SourceType.FORGOT_PIN : "Change PIN"), b).PlaceComponentResult();
                this.PlaceComponentResult.setResult(-1);
                this.PlaceComponentResult.finish();
                return;
            }
            FragmentActivity fragmentActivity = this.PlaceComponentResult;
            String str = this.NetworkUserEntityData$$ExternalSyntheticLambda0;
            ResetPinModel resetPinModel = this.getAuthRequestContext;
            String str2 = resetPinModel != null ? resetPinModel.KClassImpl$Data$declaredNonStaticMembers$2 : null;
            String str3 = str2 == null ? "" : str2;
            ResetPinModel resetPinModel2 = this.getAuthRequestContext;
            String str4 = (resetPinModel2 == null || (securityInfoModel = resetPinModel2.PlaceComponentResult) == null) ? null : securityInfoModel.MyBillsEntityDataFactory;
            String str5 = str4 == null ? "" : str4;
            UseCaseStrategy useCaseStrategy = this.lookAheadTest;
            String str6 = useCaseStrategy != null ? useCaseStrategy.getAuthRequestContext : null;
            ResetPinChallengeStrategy resetPinChallengeStrategy = new ResetPinChallengeStrategy(fragmentActivity, str, str3, str5, str6 == null ? "" : str6, this.initRecordTimeStamp, this.scheduleImpl);
            Function1<Bundle, Unit> function1 = new Function1<Bundle, Unit>() { // from class: id.dana.riskChallenges.ui.resetpin.ResetPinStateManager$after$1
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public final /* bridge */ /* synthetic */ Unit invoke(Bundle bundle2) {
                    invoke2(bundle2);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke  reason: avoid collision after fix types in other method */
                public final void invoke2(Bundle bundle2) {
                    Intrinsics.checkNotNullParameter(bundle2, "");
                    ResetPinStateManager resetPinStateManager = ResetPinStateManager.this;
                    ResetPinStateManager.ResetPinState.Success success = ResetPinStateManager.ResetPinState.Success.INSTANCE;
                    Intrinsics.checkNotNullParameter(success, "");
                    resetPinStateManager.BuiltInFictitiousFunctionClassFactory(success);
                }
            };
            Function1<Bundle, Unit> function12 = new Function1<Bundle, Unit>() { // from class: id.dana.riskChallenges.ui.resetpin.ResetPinStateManager$after$2
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public final /* bridge */ /* synthetic */ Unit invoke(Bundle bundle2) {
                    invoke2(bundle2);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke  reason: avoid collision after fix types in other method */
                public final void invoke2(Bundle bundle2) {
                    Intrinsics.checkNotNullParameter(bundle2, "");
                    ResetPinStateManager resetPinStateManager = ResetPinStateManager.this;
                    ResetPinStateManager.ResetPinState.Failed failed = new ResetPinStateManager.ResetPinState.Failed(bundle2);
                    Intrinsics.checkNotNullParameter(failed, "");
                    resetPinStateManager.BuiltInFictitiousFunctionClassFactory(failed);
                }
            };
            Function0<Unit> function0 = new Function0<Unit>() { // from class: id.dana.riskChallenges.ui.resetpin.ResetPinStateManager$after$3
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
                    ResetPinStateManager resetPinStateManager = ResetPinStateManager.this;
                    ResetPinStateManager.ResetPinState.Canceled canceled = ResetPinStateManager.ResetPinState.Canceled.INSTANCE;
                    Intrinsics.checkNotNullParameter(canceled, "");
                    resetPinStateManager.BuiltInFictitiousFunctionClassFactory(canceled);
                }
            };
            resetPinChallengeStrategy.scheduleImpl = function1;
            resetPinChallengeStrategy.BuiltInFictitiousFunctionClassFactory = function0;
            resetPinChallengeStrategy.getAuthRequestContext = function12;
            this.BuiltInFictitiousFunctionClassFactory = resetPinChallengeStrategy;
            resetPinChallengeStrategy.BuiltInFictitiousFunctionClassFactory();
            return;
        }
        String BuiltInFictitiousFunctionClassFactory = ((QueueVerificationMethods) this.moveToNextValue.getValue()).BuiltInFictitiousFunctionClassFactory();
        KClassImpl$Data$declaredNonStaticMembers$2(BuiltInFictitiousFunctionClassFactory != null ? BuiltInFictitiousFunctionClassFactory : "");
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

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\b6\u0018\u00002\u00020\u0001:\u0006\u0004\u0005\u0006\u0007\b\tB\t\b\u0004¢\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\u0006\n\u000b\f\r\u000e\u000f"}, d2 = {"Lid/dana/riskChallenges/ui/resetpin/ResetPinStateManager$ResetPinState;", "", "<init>", "()V", "Canceled", "CreateNewPin", "Failed", "RiskChallenge", "RiskReject", "Success", "Lid/dana/riskChallenges/ui/resetpin/ResetPinStateManager$ResetPinState$RiskChallenge;", "Lid/dana/riskChallenges/ui/resetpin/ResetPinStateManager$ResetPinState$CreateNewPin;", "Lid/dana/riskChallenges/ui/resetpin/ResetPinStateManager$ResetPinState$Success;", "Lid/dana/riskChallenges/ui/resetpin/ResetPinStateManager$ResetPinState$Failed;", "Lid/dana/riskChallenges/ui/resetpin/ResetPinStateManager$ResetPinState$Canceled;", "Lid/dana/riskChallenges/ui/resetpin/ResetPinStateManager$ResetPinState$RiskReject;"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static abstract class ResetPinState {
        public /* synthetic */ ResetPinState(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lid/dana/riskChallenges/ui/resetpin/ResetPinStateManager$ResetPinState$RiskChallenge;", "Lid/dana/riskChallenges/ui/resetpin/ResetPinStateManager$ResetPinState;", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
        /* loaded from: classes5.dex */
        public static final class RiskChallenge extends ResetPinState {
            public static final RiskChallenge INSTANCE = new RiskChallenge();

            private RiskChallenge() {
                super(null);
            }
        }

        private ResetPinState() {
        }

        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lid/dana/riskChallenges/ui/resetpin/ResetPinStateManager$ResetPinState$CreateNewPin;", "Lid/dana/riskChallenges/ui/resetpin/ResetPinStateManager$ResetPinState;", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
        /* loaded from: classes5.dex */
        public static final class CreateNewPin extends ResetPinState {
            public static final CreateNewPin INSTANCE = new CreateNewPin();

            private CreateNewPin() {
                super(null);
            }
        }

        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lid/dana/riskChallenges/ui/resetpin/ResetPinStateManager$ResetPinState$Success;", "Lid/dana/riskChallenges/ui/resetpin/ResetPinStateManager$ResetPinState;", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
        /* loaded from: classes5.dex */
        public static final class Success extends ResetPinState {
            public static final Success INSTANCE = new Success();

            private Success() {
                super(null);
            }
        }

        @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\r¢\u0006\u0004\b\u0011\u0010\u0012J\u001a\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002HÖ\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u0010\u0010\b\u001a\u00020\u0007HÖ\u0001¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\u000b\u001a\u00020\nHÖ\u0001¢\u0006\u0004\b\u000b\u0010\fR\u0011\u0010\u0010\u001a\u00020\rX\u0006¢\u0006\u0006\n\u0004\b\u000e\u0010\u000f"}, d2 = {"Lid/dana/riskChallenges/ui/resetpin/ResetPinStateManager$ResetPinState$Failed;", "Lid/dana/riskChallenges/ui/resetpin/ResetPinStateManager$ResetPinState;", "", "p0", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "", "toString", "()Ljava/lang/String;", "Landroid/os/Bundle;", "BuiltInFictitiousFunctionClassFactory", "Landroid/os/Bundle;", "MyBillsEntityDataFactory", "<init>", "(Landroid/os/Bundle;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
        /* loaded from: classes5.dex */
        public static final /* data */ class Failed extends ResetPinState {

            /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
            final Bundle MyBillsEntityDataFactory;

            public final boolean equals(Object p0) {
                if (this == p0) {
                    return true;
                }
                return (p0 instanceof Failed) && Intrinsics.areEqual(this.MyBillsEntityDataFactory, ((Failed) p0).MyBillsEntityDataFactory);
            }

            public final int hashCode() {
                return this.MyBillsEntityDataFactory.hashCode();
            }

            public final String toString() {
                StringBuilder sb = new StringBuilder();
                sb.append("Failed(MyBillsEntityDataFactory=");
                sb.append(this.MyBillsEntityDataFactory);
                sb.append(')');
                return sb.toString();
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public Failed(Bundle bundle) {
                super(null);
                Intrinsics.checkNotNullParameter(bundle, "");
                this.MyBillsEntityDataFactory = bundle;
            }
        }

        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lid/dana/riskChallenges/ui/resetpin/ResetPinStateManager$ResetPinState$Canceled;", "Lid/dana/riskChallenges/ui/resetpin/ResetPinStateManager$ResetPinState;", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
        /* loaded from: classes5.dex */
        public static final class Canceled extends ResetPinState {
            public static final Canceled INSTANCE = new Canceled();

            private Canceled() {
                super(null);
            }
        }

        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lid/dana/riskChallenges/ui/resetpin/ResetPinStateManager$ResetPinState$RiskReject;", "Lid/dana/riskChallenges/ui/resetpin/ResetPinStateManager$ResetPinState;", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
        /* loaded from: classes5.dex */
        public static final class RiskReject extends ResetPinState {
            public static final RiskReject INSTANCE = new RiskReject();

            private RiskReject() {
                super(null);
            }
        }
    }

    public static final /* synthetic */ QueueVerificationMethods KClassImpl$Data$declaredNonStaticMembers$2(ResetPinStateManager resetPinStateManager) {
        return (QueueVerificationMethods) resetPinStateManager.moveToNextValue.getValue();
    }

    public static final /* synthetic */ RiskChallengeStrategyFactory BuiltInFictitiousFunctionClassFactory(ResetPinStateManager resetPinStateManager) {
        return (RiskChallengeStrategyFactory) resetPinStateManager.getErrorConfigVersion.getValue();
    }

    private final void KClassImpl$Data$declaredNonStaticMembers$2(@RiskChallengeKey String p0) {
        try {
            RiskChallengeStrategy PlaceComponentResult = ((RiskChallengeStrategyFactory) this.getErrorConfigVersion.getValue()).PlaceComponentResult(p0);
            PlaceComponentResult.BuiltInFictitiousFunctionClassFactory(new Function1<Bundle, Unit>() { // from class: id.dana.riskChallenges.ui.resetpin.ResetPinStateManager$executeRiskChallenge$1
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
                    QueueVerificationMethods KClassImpl$Data$declaredNonStaticMembers$2 = ResetPinStateManager.KClassImpl$Data$declaredNonStaticMembers$2(ResetPinStateManager.this);
                    final ResetPinStateManager resetPinStateManager = ResetPinStateManager.this;
                    Function0<Unit> function0 = new Function0<Unit>() { // from class: id.dana.riskChallenges.ui.resetpin.ResetPinStateManager$executeRiskChallenge$1.1
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
                            ResetPinStateManager resetPinStateManager2 = ResetPinStateManager.this;
                            ResetPinStateManager.ResetPinState.RiskChallenge riskChallenge = ResetPinStateManager.ResetPinState.RiskChallenge.INSTANCE;
                            Intrinsics.checkNotNullParameter(riskChallenge, "");
                            resetPinStateManager2.BuiltInFictitiousFunctionClassFactory(riskChallenge);
                        }
                    };
                    final ResetPinStateManager resetPinStateManager2 = ResetPinStateManager.this;
                    KClassImpl$Data$declaredNonStaticMembers$2.KClassImpl$Data$declaredNonStaticMembers$2(function0, new Function0<Unit>() { // from class: id.dana.riskChallenges.ui.resetpin.ResetPinStateManager$executeRiskChallenge$1.2
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
                            ResetPinStateManager resetPinStateManager3 = ResetPinStateManager.this;
                            ResetPinStateManager.ResetPinState.CreateNewPin createNewPin = ResetPinStateManager.ResetPinState.CreateNewPin.INSTANCE;
                            Intrinsics.checkNotNullParameter(createNewPin, "");
                            resetPinStateManager3.BuiltInFictitiousFunctionClassFactory(createNewPin);
                        }
                    });
                }
            }, new Function1<Bundle, Unit>() { // from class: id.dana.riskChallenges.ui.resetpin.ResetPinStateManager$executeRiskChallenge$2
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
                    QueueVerificationMethods KClassImpl$Data$declaredNonStaticMembers$2 = ResetPinStateManager.KClassImpl$Data$declaredNonStaticMembers$2(ResetPinStateManager.this);
                    final ResetPinStateManager resetPinStateManager = ResetPinStateManager.this;
                    Function0<Unit> function0 = new Function0<Unit>() { // from class: id.dana.riskChallenges.ui.resetpin.ResetPinStateManager$executeRiskChallenge$2.1
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
                            ResetPinStateManager.BuiltInFictitiousFunctionClassFactory(resetPinStateManager).KClassImpl$Data$declaredNonStaticMembers$2 = (HistoryFallbackModel) parcelable;
                            ResetPinStateManager resetPinStateManager2 = resetPinStateManager;
                            ResetPinStateManager.ResetPinState.RiskChallenge riskChallenge = ResetPinStateManager.ResetPinState.RiskChallenge.INSTANCE;
                            Intrinsics.checkNotNullParameter(riskChallenge, "");
                            resetPinStateManager2.BuiltInFictitiousFunctionClassFactory(riskChallenge);
                        }
                    };
                    final ResetPinStateManager resetPinStateManager2 = ResetPinStateManager.this;
                    KClassImpl$Data$declaredNonStaticMembers$2.KClassImpl$Data$declaredNonStaticMembers$2(z, function0, new Function0<Unit>() { // from class: id.dana.riskChallenges.ui.resetpin.ResetPinStateManager$executeRiskChallenge$2.2
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
                            ResetPinStateManager resetPinStateManager3 = ResetPinStateManager.this;
                            ResetPinStateManager.ResetPinState.Failed failed = new ResetPinStateManager.ResetPinState.Failed(bundle);
                            Intrinsics.checkNotNullParameter(failed, "");
                            resetPinStateManager3.BuiltInFictitiousFunctionClassFactory(failed);
                        }
                    });
                }
            }, new Function0<Unit>() { // from class: id.dana.riskChallenges.ui.resetpin.ResetPinStateManager$executeRiskChallenge$3
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
                    ResetPinStateManager resetPinStateManager = ResetPinStateManager.this;
                    ResetPinStateManager.ResetPinState.Canceled canceled = ResetPinStateManager.ResetPinState.Canceled.INSTANCE;
                    Intrinsics.checkNotNullParameter(canceled, "");
                    resetPinStateManager.BuiltInFictitiousFunctionClassFactory(canceled);
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
            ResetPinState.Failed failed = new ResetPinState.Failed(BundleKt.PlaceComponentResult(pairArr));
            Intrinsics.checkNotNullParameter(failed, "");
            BuiltInFictitiousFunctionClassFactory(failed);
        }
    }
}
