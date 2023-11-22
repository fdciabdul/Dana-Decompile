package id.dana.riskChallenges.ui.passkey.launcher.enrollment;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcelable;
import androidx.core.os.BundleKt;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentResultListener;
import androidx.fragment.app.FragmentTransaction;
import id.dana.core.ui.extension.FragmentExtKt;
import id.dana.riskChallenges.R;
import id.dana.riskChallenges.constant.RiskChallengeKey;
import id.dana.riskChallenges.domain.passkey.model.PasskeyEnrollmentWithRiskChallenges;
import id.dana.riskChallenges.ui.passkey.PasskeyRiskChallengeStrategy;
import id.dana.riskChallenges.ui.passkey.VerificationPagePassingFragment;
import id.dana.riskChallenges.ui.passkey.launcher.enrollment.EnrollPasskeyStateManager;
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

@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\r\u0018\u0000 72\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002:\u000278B[\b\u0002\u0012\u0006\u0010\b\u001a\u00020\u0011\u0012\u0006\u0010\r\u001a\u00020\f\u0012\u0006\u0010.\u001a\u00020\f\u0012\u0006\u0010/\u001a\u00020\f\u0012\u0006\u00100\u001a\u00020\f\u0012\n\b\u0002\u00101\u001a\u0004\u0018\u00010+\u0012\b\u00102\u001a\u0004\u0018\u00010#\u0012\u0006\u00103\u001a\u00020\f\u0012\n\b\u0002\u00104\u001a\u0004\u0018\u00010!¢\u0006\u0004\b5\u00106J\u000f\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\n\u0010\u000bJ\u001f\u0010\u000e\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ\u0019\u0010\u0005\u001a\u00020\u00042\b\b\u0001\u0010\b\u001a\u00020\fH\u0002¢\u0006\u0004\b\u0005\u0010\u0010R\u0014\u0010\u0005\u001a\u00020\u00118\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u0016\u0010\u0016\u001a\u00020\u00148\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b\n\u0010\u0015R\u0014\u0010\u0018\u001a\u00020\f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u0016\u0010\u0012\u001a\u00020\t8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u0014\u0010\n\u001a\u00020\f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\u0017R\u0016\u0010\u001b\u001a\u00020\f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001a\u0010\u0017R\u0013\u0010\u001f\u001a\u00020\u001cX\u0082\u0080\u0002¢\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\u0013\u0010\u001d\u001a\u00020 X\u0082\u0080\u0002¢\u0006\u0006\n\u0004\b\u001f\u0010\u001eR\u0018\u0010\u001a\u001a\u0004\u0018\u00010!8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001b\u0010\"R\u0016\u0010$\u001a\u0004\u0018\u00010#8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b$\u0010%R(\u0010&\u001a\u0004\u0018\u00010\u00032\b\u0010\b\u001a\u0004\u0018\u00010\u00038\u0002@CX\u0082\u000e¢\u0006\f\n\u0004\b&\u0010'\"\u0004\b\u0012\u0010(R\u0014\u0010*\u001a\u00020\f8\u0002X\u0083\u0004¢\u0006\u0006\n\u0004\b)\u0010\u0017R\u0014\u0010)\u001a\u00020\f8\u0002X\u0083\u0004¢\u0006\u0006\n\u0004\b*\u0010\u0017R\u0016\u0010,\u001a\u0004\u0018\u00010+8\u0002X\u0083\u0004¢\u0006\u0006\n\u0004\b,\u0010-"}, d2 = {"Lid/dana/riskChallenges/ui/passkey/launcher/enrollment/EnrollPasskeyStateManager;", "Lid/dana/riskChallenges/ui/util/statemanager/ChallengeState;", "Lid/dana/riskChallenges/ui/util/statemanager/ChangeStateListener;", "Lid/dana/riskChallenges/ui/passkey/launcher/enrollment/EnrollPasskeyStateManager$PasskeyEnrollmentState;", "", "BuiltInFictitiousFunctionClassFactory", "()V", "Landroid/os/Bundle;", "p0", "", "MyBillsEntityDataFactory", "(Landroid/os/Bundle;)Z", "", "p1", "onFragmentResult", "(Ljava/lang/String;Landroid/os/Bundle;)V", "(Ljava/lang/String;)V", "Landroidx/fragment/app/FragmentActivity;", "PlaceComponentResult", "Landroidx/fragment/app/FragmentActivity;", "Landroidx/fragment/app/FragmentResultListener;", "Landroidx/fragment/app/FragmentResultListener;", "KClassImpl$Data$declaredNonStaticMembers$2", "Ljava/lang/String;", "getAuthRequestContext", "Z", "scheduleImpl", "NetworkUserEntityData$$ExternalSyntheticLambda0", "Lid/dana/riskChallenges/ui/util/statemanager/QueueVerificationMethods;", "getErrorConfigVersion", "Lkotlin/Lazy;", "moveToNextValue", "Lid/dana/riskChallenges/ui/util/strategy/RiskChallengeStrategyFactory;", "Lid/dana/riskChallenges/ui/util/model/BasicRiskChallengesModel;", "Lid/dana/riskChallenges/ui/util/model/BasicRiskChallengesModel;", "Lid/dana/riskChallenges/ui/resetpin/model/UseCaseStrategy;", "lookAheadTest", "Lid/dana/riskChallenges/ui/resetpin/model/UseCaseStrategy;", "GetContactSyncConfig", "Lid/dana/riskChallenges/ui/passkey/launcher/enrollment/EnrollPasskeyStateManager$PasskeyEnrollmentState;", "(Lid/dana/riskChallenges/ui/passkey/launcher/enrollment/EnrollPasskeyStateManager$PasskeyEnrollmentState;)V", "initRecordTimeStamp", "NetworkUserEntityData$$ExternalSyntheticLambda1", "Lid/dana/riskChallenges/ui/util/uicomponent/UiComponent;", "DatabaseTableConfigUtil", "Lid/dana/riskChallenges/ui/util/uicomponent/UiComponent;", "p2", "p3", "p4", "p5", "p6", "p7", "p8", "<init>", "(Landroidx/fragment/app/FragmentActivity;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lid/dana/riskChallenges/ui/util/uicomponent/UiComponent;Lid/dana/riskChallenges/ui/resetpin/model/UseCaseStrategy;Ljava/lang/String;Lid/dana/riskChallenges/ui/util/model/BasicRiskChallengesModel;)V", "Companion", "PasskeyEnrollmentState"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class EnrollPasskeyStateManager implements ChallengeState, ChangeStateListener<PasskeyEnrollmentState> {

    /* renamed from: Companion  reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
    private final String MyBillsEntityDataFactory;
    private final UiComponent DatabaseTableConfigUtil;
    private PasskeyEnrollmentState GetContactSyncConfig;

    /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
    private final String getAuthRequestContext;

    /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
    private FragmentResultListener KClassImpl$Data$declaredNonStaticMembers$2;

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda0  reason: from kotlin metadata */
    private BasicRiskChallengesModel scheduleImpl;

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda1  reason: from kotlin metadata */
    private final String initRecordTimeStamp;

    /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
    final FragmentActivity BuiltInFictitiousFunctionClassFactory;

    /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
    private boolean PlaceComponentResult;

    /* renamed from: getErrorConfigVersion  reason: from kotlin metadata */
    private final Lazy moveToNextValue;

    /* renamed from: initRecordTimeStamp  reason: from kotlin metadata */
    private final String NetworkUserEntityData$$ExternalSyntheticLambda1;
    private final UseCaseStrategy lookAheadTest;

    /* renamed from: moveToNextValue  reason: from kotlin metadata */
    private final Lazy getErrorConfigVersion;

    /* renamed from: scheduleImpl  reason: from kotlin metadata */
    private String NetworkUserEntityData$$ExternalSyntheticLambda0;

    public /* synthetic */ EnrollPasskeyStateManager(FragmentActivity fragmentActivity, String str, String str2, String str3, String str4, UiComponent uiComponent, UseCaseStrategy useCaseStrategy, String str5, BasicRiskChallengesModel basicRiskChallengesModel, DefaultConstructorMarker defaultConstructorMarker) {
        this(fragmentActivity, str, str2, str3, str4, uiComponent, useCaseStrategy, str5, basicRiskChallengesModel);
    }

    private EnrollPasskeyStateManager(FragmentActivity fragmentActivity, String str, String str2, String str3, String str4, UiComponent uiComponent, UseCaseStrategy useCaseStrategy, String str5, BasicRiskChallengesModel basicRiskChallengesModel) {
        this.BuiltInFictitiousFunctionClassFactory = fragmentActivity;
        this.getAuthRequestContext = str;
        this.initRecordTimeStamp = str2;
        this.NetworkUserEntityData$$ExternalSyntheticLambda1 = str3;
        this.MyBillsEntityDataFactory = str4;
        this.DatabaseTableConfigUtil = uiComponent;
        this.lookAheadTest = useCaseStrategy;
        this.NetworkUserEntityData$$ExternalSyntheticLambda0 = str5;
        this.scheduleImpl = basicRiskChallengesModel;
        this.moveToNextValue = LazyKt.lazy(new Function0<QueueVerificationMethods>() { // from class: id.dana.riskChallenges.ui.passkey.launcher.enrollment.EnrollPasskeyStateManager$queueVerificationMethods$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final QueueVerificationMethods invoke() {
                return new QueueVerificationMethods();
            }
        });
        this.getErrorConfigVersion = LazyKt.lazy(new Function0<RiskChallengeStrategyFactory>() { // from class: id.dana.riskChallenges.ui.passkey.launcher.enrollment.EnrollPasskeyStateManager$rcStrategyFactory$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final RiskChallengeStrategyFactory invoke() {
                FragmentActivity fragmentActivity2;
                BasicRiskChallengesModel basicRiskChallengesModel2;
                String str6;
                UiComponent uiComponent2;
                UseCaseStrategy useCaseStrategy2;
                String str7;
                String str8;
                SecurityInfoModel placeComponentResult;
                fragmentActivity2 = EnrollPasskeyStateManager.this.BuiltInFictitiousFunctionClassFactory;
                basicRiskChallengesModel2 = EnrollPasskeyStateManager.this.scheduleImpl;
                String str9 = (basicRiskChallengesModel2 == null || (placeComponentResult = basicRiskChallengesModel2.getPlaceComponentResult()) == null) ? null : placeComponentResult.MyBillsEntityDataFactory;
                String str10 = str9 == null ? "" : str9;
                str6 = EnrollPasskeyStateManager.this.NetworkUserEntityData$$ExternalSyntheticLambda0;
                uiComponent2 = EnrollPasskeyStateManager.this.DatabaseTableConfigUtil;
                useCaseStrategy2 = EnrollPasskeyStateManager.this.lookAheadTest;
                if (useCaseStrategy2 == null) {
                    useCaseStrategy2 = new UseCaseStrategy("", null, null, 6, null);
                }
                str7 = EnrollPasskeyStateManager.this.initRecordTimeStamp;
                str8 = EnrollPasskeyStateManager.this.NetworkUserEntityData$$ExternalSyntheticLambda1;
                Map mapOf = MapsKt.mapOf(TuplesKt.to("KEY_SOURCE", str7), TuplesKt.to("KEY_PURPOSE", str8));
                final EnrollPasskeyStateManager enrollPasskeyStateManager = EnrollPasskeyStateManager.this;
                RiskChallengeStrategyFactory riskChallengeStrategyFactory = new RiskChallengeStrategyFactory(fragmentActivity2, str10, str6, uiComponent2, useCaseStrategy2, mapOf, new Function0<String>() { // from class: id.dana.riskChallenges.ui.passkey.launcher.enrollment.EnrollPasskeyStateManager$rcStrategyFactory$2.1
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public final String invoke() {
                        return EnrollPasskeyStateManager.MyBillsEntityDataFactory(EnrollPasskeyStateManager.this).getAuthRequestContext();
                    }
                });
                final EnrollPasskeyStateManager enrollPasskeyStateManager2 = EnrollPasskeyStateManager.this;
                Function1<FragmentResultListener, Unit> function1 = new Function1<FragmentResultListener, Unit>() { // from class: id.dana.riskChallenges.ui.passkey.launcher.enrollment.EnrollPasskeyStateManager$rcStrategyFactory$2$2$1
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
                        EnrollPasskeyStateManager.this.KClassImpl$Data$declaredNonStaticMembers$2 = fragmentResultListener;
                    }
                };
                Intrinsics.checkNotNullParameter(function1, "");
                riskChallengeStrategyFactory.PlaceComponentResult = function1;
                return riskChallengeStrategyFactory;
            }
        });
        ((QueueVerificationMethods) this.moveToNextValue.getValue()).BuiltInFictitiousFunctionClassFactory(this.scheduleImpl);
        PasskeyEnrollmentState.Initial initial = PasskeyEnrollmentState.Initial.INSTANCE;
        Intrinsics.checkNotNullParameter(initial, "");
        PlaceComponentResult(initial);
    }

    @JvmName(name = "PlaceComponentResult")
    public final void PlaceComponentResult(PasskeyEnrollmentState passkeyEnrollmentState) {
        SecurityInfoModel placeComponentResult;
        this.GetContactSyncConfig = passkeyEnrollmentState;
        if (!Intrinsics.areEqual(passkeyEnrollmentState, PasskeyEnrollmentState.Canceled.INSTANCE)) {
            if (!(passkeyEnrollmentState instanceof PasskeyEnrollmentState.Failed)) {
                if (!Intrinsics.areEqual(passkeyEnrollmentState, PasskeyEnrollmentState.Success.INSTANCE)) {
                    if (!Intrinsics.areEqual(passkeyEnrollmentState, PasskeyEnrollmentState.Initial.INSTANCE)) {
                        if (Intrinsics.areEqual(passkeyEnrollmentState, PasskeyEnrollmentState.RiskChallenge.INSTANCE)) {
                            BuiltInFictitiousFunctionClassFactory();
                            return;
                        } else if (Intrinsics.areEqual(passkeyEnrollmentState, PasskeyEnrollmentState.RiskReject.INSTANCE)) {
                            BuiltInFictitiousFunctionClassFactory(RiskChallengeKey.RISK_REJECT);
                            return;
                        } else {
                            return;
                        }
                    }
                    FragmentActivity fragmentActivity = this.BuiltInFictitiousFunctionClassFactory;
                    String str = this.getAuthRequestContext;
                    String str2 = this.initRecordTimeStamp;
                    String str3 = this.NetworkUserEntityData$$ExternalSyntheticLambda1;
                    Pair[] pairArr = new Pair[3];
                    pairArr[0] = TuplesKt.to("KEY_PASSKEY_PAGE_SOURCE", this.MyBillsEntityDataFactory);
                    BasicRiskChallengesModel basicRiskChallengesModel = this.scheduleImpl;
                    String str4 = (basicRiskChallengesModel == null || (placeComponentResult = basicRiskChallengesModel.getPlaceComponentResult()) == null) ? null : placeComponentResult.MyBillsEntityDataFactory;
                    pairArr[1] = TuplesKt.to("KEY_SECURITY_ID", str4 != null ? str4 : "");
                    pairArr[2] = TuplesKt.to("KEY_NEED_SHOW_VERIFICATION_FRAGMENT", Boolean.valueOf(this.PlaceComponentResult));
                    PasskeyRiskChallengeStrategy passkeyRiskChallengeStrategy = new PasskeyRiskChallengeStrategy(fragmentActivity, str, str2, str3, BundleKt.PlaceComponentResult(pairArr));
                    Function1<Bundle, Unit> function1 = new Function1<Bundle, Unit>() { // from class: id.dana.riskChallenges.ui.passkey.launcher.enrollment.EnrollPasskeyStateManager$execute$1$1
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
                            boolean MyBillsEntityDataFactory;
                            Parcelable parcelable;
                            BasicRiskChallengesModel basicRiskChallengesModel2;
                            BasicRiskChallengesModel basicRiskChallengesModel3;
                            SecurityInfoModel placeComponentResult2;
                            Intrinsics.checkNotNullParameter(bundle, "");
                            String str5 = null;
                            if (!bundle.getBoolean("KEY_NEED_HANDLE_VERIFICATION_METHOD", false)) {
                                MyBillsEntityDataFactory = EnrollPasskeyStateManager.MyBillsEntityDataFactory(bundle);
                                if (!MyBillsEntityDataFactory) {
                                    EnrollPasskeyStateManager enrollPasskeyStateManager = EnrollPasskeyStateManager.this;
                                    EnrollPasskeyStateManager.PasskeyEnrollmentState.Success success = EnrollPasskeyStateManager.PasskeyEnrollmentState.Success.INSTANCE;
                                    Intrinsics.checkNotNullParameter(success, "");
                                    enrollPasskeyStateManager.PlaceComponentResult(success);
                                    return;
                                }
                                FragmentManager supportFragmentManager = EnrollPasskeyStateManager.this.BuiltInFictitiousFunctionClassFactory.getSupportFragmentManager();
                                Intrinsics.checkNotNullExpressionValue(supportFragmentManager, "");
                                FragmentTransaction beginTransaction = supportFragmentManager.beginTransaction();
                                Intrinsics.checkNotNullExpressionValue(beginTransaction, "");
                                FragmentExtKt.BuiltInFictitiousFunctionClassFactory(beginTransaction);
                                beginTransaction.KClassImpl$Data$declaredNonStaticMembers$2(R.id.initRecordTimeStamp, new VerificationPagePassingFragment(), null, 1);
                                if (!beginTransaction.NetworkUserEntityData$$ExternalSyntheticLambda0) {
                                    throw new IllegalStateException("This FragmentTransaction is not allowed to be added to the back stack.");
                                }
                                beginTransaction.scheduleImpl = true;
                                beginTransaction.NetworkUserEntityData$$ExternalSyntheticLambda8 = null;
                                beginTransaction.getAuthRequestContext();
                                return;
                            }
                            EnrollPasskeyStateManager enrollPasskeyStateManager2 = EnrollPasskeyStateManager.this;
                            if (Build.VERSION.SDK_INT >= 33) {
                                parcelable = (Parcelable) bundle.getParcelable("KEY_DATA_RISK_CONSULT", BasicRiskChallengesModel.class);
                            } else {
                                Parcelable parcelable2 = bundle.getParcelable("KEY_DATA_RISK_CONSULT");
                                if (!(parcelable2 instanceof BasicRiskChallengesModel)) {
                                    parcelable2 = null;
                                }
                                parcelable = (BasicRiskChallengesModel) parcelable2;
                            }
                            enrollPasskeyStateManager2.scheduleImpl = (BasicRiskChallengesModel) parcelable;
                            RiskChallengeStrategyFactory BuiltInFictitiousFunctionClassFactory = EnrollPasskeyStateManager.BuiltInFictitiousFunctionClassFactory(EnrollPasskeyStateManager.this);
                            basicRiskChallengesModel2 = EnrollPasskeyStateManager.this.scheduleImpl;
                            if (basicRiskChallengesModel2 != null && (placeComponentResult2 = basicRiskChallengesModel2.getPlaceComponentResult()) != null) {
                                str5 = placeComponentResult2.MyBillsEntityDataFactory;
                            }
                            if (str5 == null) {
                                str5 = "";
                            }
                            Intrinsics.checkNotNullParameter(str5, "");
                            BuiltInFictitiousFunctionClassFactory.lookAheadTest = str5;
                            QueueVerificationMethods MyBillsEntityDataFactory2 = EnrollPasskeyStateManager.MyBillsEntityDataFactory(EnrollPasskeyStateManager.this);
                            basicRiskChallengesModel3 = EnrollPasskeyStateManager.this.scheduleImpl;
                            MyBillsEntityDataFactory2.BuiltInFictitiousFunctionClassFactory(basicRiskChallengesModel3);
                            EnrollPasskeyStateManager.PlaceComponentResult(EnrollPasskeyStateManager.this);
                        }
                    };
                    Function1<Bundle, Unit> function12 = new Function1<Bundle, Unit>() { // from class: id.dana.riskChallenges.ui.passkey.launcher.enrollment.EnrollPasskeyStateManager$execute$1$2
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
                            EnrollPasskeyStateManager enrollPasskeyStateManager = EnrollPasskeyStateManager.this;
                            EnrollPasskeyStateManager.PasskeyEnrollmentState.Failed failed = new EnrollPasskeyStateManager.PasskeyEnrollmentState.Failed(bundle);
                            Intrinsics.checkNotNullParameter(failed, "");
                            enrollPasskeyStateManager.PlaceComponentResult(failed);
                        }
                    };
                    Function0<Unit> function0 = new Function0<Unit>() { // from class: id.dana.riskChallenges.ui.passkey.launcher.enrollment.EnrollPasskeyStateManager$execute$1$3
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
                            EnrollPasskeyStateManager enrollPasskeyStateManager = EnrollPasskeyStateManager.this;
                            EnrollPasskeyStateManager.PasskeyEnrollmentState.Canceled canceled = EnrollPasskeyStateManager.PasskeyEnrollmentState.Canceled.INSTANCE;
                            Intrinsics.checkNotNullParameter(canceled, "");
                            enrollPasskeyStateManager.PlaceComponentResult(canceled);
                        }
                    };
                    passkeyRiskChallengeStrategy.moveToNextValue = function1;
                    passkeyRiskChallengeStrategy.BuiltInFictitiousFunctionClassFactory = function12;
                    passkeyRiskChallengeStrategy.KClassImpl$Data$declaredNonStaticMembers$2 = function0;
                    passkeyRiskChallengeStrategy.BuiltInFictitiousFunctionClassFactory();
                    this.KClassImpl$Data$declaredNonStaticMembers$2 = passkeyRiskChallengeStrategy;
                    return;
                }
                Intrinsics.checkNotNullParameter(BundleKt.BuiltInFictitiousFunctionClassFactory(), "");
                this.BuiltInFictitiousFunctionClassFactory.setResult(-1);
                this.BuiltInFictitiousFunctionClassFactory.finish();
                return;
            }
            Bundle bundle = ((PasskeyEnrollmentState.Failed) passkeyEnrollmentState).PlaceComponentResult;
            Intrinsics.checkNotNullParameter(bundle, "");
            Intent intent = new Intent();
            intent.putExtras(bundle);
            this.BuiltInFictitiousFunctionClassFactory.setResult(0, intent);
            this.BuiltInFictitiousFunctionClassFactory.finish();
            return;
        }
        this.BuiltInFictitiousFunctionClassFactory.setResult(0);
        this.BuiltInFictitiousFunctionClassFactory.finish();
    }

    private final void BuiltInFictitiousFunctionClassFactory() {
        DanaLog.MyBillsEntityDataFactory("PASSKEY", "executeRiskChallenge invoked");
        String BuiltInFictitiousFunctionClassFactory = ((QueueVerificationMethods) this.moveToNextValue.getValue()).BuiltInFictitiousFunctionClassFactory();
        if (BuiltInFictitiousFunctionClassFactory == null) {
            BuiltInFictitiousFunctionClassFactory = "";
        }
        BuiltInFictitiousFunctionClassFactory(BuiltInFictitiousFunctionClassFactory);
    }

    public static boolean MyBillsEntityDataFactory(Bundle p0) {
        return p0.containsKey("KEY_NEED_SHOW_VERIFICATION_FRAGMENT") && p0.getBoolean("KEY_NEED_SHOW_VERIFICATION_FRAGMENT");
    }

    @Override // androidx.fragment.app.FragmentResultListener
    public final void onFragmentResult(String p0, Bundle p1) {
        Intrinsics.checkNotNullParameter(p0, "");
        Intrinsics.checkNotNullParameter(p1, "");
        FragmentResultListener fragmentResultListener = this.KClassImpl$Data$declaredNonStaticMembers$2;
        if (fragmentResultListener == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            fragmentResultListener = null;
        }
        fragmentResultListener.onFragmentResult(p0, p1);
    }

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\b6\u0018\u00002\u00020\u0001:\u0006\u0004\u0005\u0006\u0007\b\tB\t\b\u0004¢\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\u0006\n\u000b\f\r\u000e\u000f"}, d2 = {"Lid/dana/riskChallenges/ui/passkey/launcher/enrollment/EnrollPasskeyStateManager$PasskeyEnrollmentState;", "", "<init>", "()V", "Canceled", "Failed", "Initial", "RiskChallenge", "RiskReject", "Success", "Lid/dana/riskChallenges/ui/passkey/launcher/enrollment/EnrollPasskeyStateManager$PasskeyEnrollmentState$Initial;", "Lid/dana/riskChallenges/ui/passkey/launcher/enrollment/EnrollPasskeyStateManager$PasskeyEnrollmentState$Success;", "Lid/dana/riskChallenges/ui/passkey/launcher/enrollment/EnrollPasskeyStateManager$PasskeyEnrollmentState$Canceled;", "Lid/dana/riskChallenges/ui/passkey/launcher/enrollment/EnrollPasskeyStateManager$PasskeyEnrollmentState$Failed;", "Lid/dana/riskChallenges/ui/passkey/launcher/enrollment/EnrollPasskeyStateManager$PasskeyEnrollmentState$RiskChallenge;", "Lid/dana/riskChallenges/ui/passkey/launcher/enrollment/EnrollPasskeyStateManager$PasskeyEnrollmentState$RiskReject;"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static abstract class PasskeyEnrollmentState {
        public /* synthetic */ PasskeyEnrollmentState(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private PasskeyEnrollmentState() {
        }

        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lid/dana/riskChallenges/ui/passkey/launcher/enrollment/EnrollPasskeyStateManager$PasskeyEnrollmentState$Initial;", "Lid/dana/riskChallenges/ui/passkey/launcher/enrollment/EnrollPasskeyStateManager$PasskeyEnrollmentState;", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
        /* loaded from: classes5.dex */
        public static final class Initial extends PasskeyEnrollmentState {
            public static final Initial INSTANCE = new Initial();

            private Initial() {
                super(null);
            }
        }

        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lid/dana/riskChallenges/ui/passkey/launcher/enrollment/EnrollPasskeyStateManager$PasskeyEnrollmentState$Success;", "Lid/dana/riskChallenges/ui/passkey/launcher/enrollment/EnrollPasskeyStateManager$PasskeyEnrollmentState;", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
        /* loaded from: classes5.dex */
        public static final class Success extends PasskeyEnrollmentState {
            public static final Success INSTANCE = new Success();

            private Success() {
                super(null);
            }
        }

        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lid/dana/riskChallenges/ui/passkey/launcher/enrollment/EnrollPasskeyStateManager$PasskeyEnrollmentState$Canceled;", "Lid/dana/riskChallenges/ui/passkey/launcher/enrollment/EnrollPasskeyStateManager$PasskeyEnrollmentState;", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
        /* loaded from: classes5.dex */
        public static final class Canceled extends PasskeyEnrollmentState {
            public static final Canceled INSTANCE = new Canceled();

            private Canceled() {
                super(null);
            }
        }

        @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\r¢\u0006\u0004\b\u0011\u0010\u0012J\u001a\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002HÖ\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u0010\u0010\b\u001a\u00020\u0007HÖ\u0001¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\u000b\u001a\u00020\nHÖ\u0001¢\u0006\u0004\b\u000b\u0010\fR\u0011\u0010\u0010\u001a\u00020\rX\u0006¢\u0006\u0006\n\u0004\b\u000e\u0010\u000f"}, d2 = {"Lid/dana/riskChallenges/ui/passkey/launcher/enrollment/EnrollPasskeyStateManager$PasskeyEnrollmentState$Failed;", "Lid/dana/riskChallenges/ui/passkey/launcher/enrollment/EnrollPasskeyStateManager$PasskeyEnrollmentState;", "", "p0", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "", "toString", "()Ljava/lang/String;", "Landroid/os/Bundle;", "KClassImpl$Data$declaredNonStaticMembers$2", "Landroid/os/Bundle;", "PlaceComponentResult", "<init>", "(Landroid/os/Bundle;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
        /* loaded from: classes5.dex */
        public static final /* data */ class Failed extends PasskeyEnrollmentState {

            /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
            final Bundle PlaceComponentResult;

            public final boolean equals(Object p0) {
                if (this == p0) {
                    return true;
                }
                return (p0 instanceof Failed) && Intrinsics.areEqual(this.PlaceComponentResult, ((Failed) p0).PlaceComponentResult);
            }

            public final int hashCode() {
                return this.PlaceComponentResult.hashCode();
            }

            public final String toString() {
                StringBuilder sb = new StringBuilder();
                sb.append("Failed(PlaceComponentResult=");
                sb.append(this.PlaceComponentResult);
                sb.append(')');
                return sb.toString();
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public Failed(Bundle bundle) {
                super(null);
                Intrinsics.checkNotNullParameter(bundle, "");
                this.PlaceComponentResult = bundle;
            }
        }

        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lid/dana/riskChallenges/ui/passkey/launcher/enrollment/EnrollPasskeyStateManager$PasskeyEnrollmentState$RiskChallenge;", "Lid/dana/riskChallenges/ui/passkey/launcher/enrollment/EnrollPasskeyStateManager$PasskeyEnrollmentState;", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
        /* loaded from: classes5.dex */
        public static final class RiskChallenge extends PasskeyEnrollmentState {
            public static final RiskChallenge INSTANCE = new RiskChallenge();

            private RiskChallenge() {
                super(null);
            }
        }

        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lid/dana/riskChallenges/ui/passkey/launcher/enrollment/EnrollPasskeyStateManager$PasskeyEnrollmentState$RiskReject;", "Lid/dana/riskChallenges/ui/passkey/launcher/enrollment/EnrollPasskeyStateManager$PasskeyEnrollmentState;", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
        /* loaded from: classes5.dex */
        public static final class RiskReject extends PasskeyEnrollmentState {
            public static final RiskReject INSTANCE = new RiskReject();

            private RiskReject() {
                super(null);
            }
        }
    }

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\t\u0010\nJ\u001d\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\b"}, d2 = {"Lid/dana/riskChallenges/ui/passkey/launcher/enrollment/EnrollPasskeyStateManager$Companion;", "", "Landroidx/fragment/app/FragmentActivity;", "p0", "Landroid/os/Bundle;", "p1", "Lid/dana/riskChallenges/ui/passkey/launcher/enrollment/EnrollPasskeyStateManager;", "KClassImpl$Data$declaredNonStaticMembers$2", "(Landroidx/fragment/app/FragmentActivity;Landroid/os/Bundle;)Lid/dana/riskChallenges/ui/passkey/launcher/enrollment/EnrollPasskeyStateManager;", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public static EnrollPasskeyStateManager KClassImpl$Data$declaredNonStaticMembers$2(FragmentActivity p0, Bundle p1) {
            Parcelable parcelable;
            Object obj;
            Parcelable parcelable2;
            Intrinsics.checkNotNullParameter(p0, "");
            Intrinsics.checkNotNullParameter(p1, "");
            String string = p1.getString("KEY_SOURCE");
            String str = string == null ? "" : string;
            String string2 = p1.getString("KEY_PURPOSE");
            String str2 = string2 == null ? "" : string2;
            String string3 = p1.getString("KEY_STRATEGY");
            String str3 = string3 == null ? "" : string3;
            String string4 = p1.getString("KEY_PASSKEY_PAGE_SOURCE");
            String str4 = string4 == null ? "" : string4;
            if (Build.VERSION.SDK_INT >= 33) {
                parcelable = (Parcelable) p1.getParcelable("KEY_UI_COMPONENT", UiComponent.class);
            } else {
                Parcelable parcelable3 = p1.getParcelable("KEY_UI_COMPONENT");
                if (!(parcelable3 instanceof UiComponent)) {
                    parcelable3 = null;
                }
                parcelable = (UiComponent) parcelable3;
            }
            UiComponent uiComponent = (UiComponent) parcelable;
            if (Build.VERSION.SDK_INT >= 33) {
                obj = (Parcelable) p1.getParcelable("KEY_USE_CASE_STRATEGY", UseCaseStrategy.class);
            } else {
                Object parcelable4 = p1.getParcelable("KEY_USE_CASE_STRATEGY");
                if (!(parcelable4 instanceof UseCaseStrategy)) {
                    parcelable4 = null;
                }
                obj = (Parcelable) ((UseCaseStrategy) parcelable4);
            }
            UseCaseStrategy useCaseStrategy = (UseCaseStrategy) obj;
            String string5 = p1.getString("KEY_PHONE_NUMBER");
            String str5 = string5 == null ? "" : string5;
            if (Build.VERSION.SDK_INT >= 33) {
                parcelable2 = (Parcelable) p1.getParcelable("KEY_DATA_RISK_CONSULT", PasskeyEnrollmentWithRiskChallenges.class);
            } else {
                Parcelable parcelable5 = p1.getParcelable("KEY_DATA_RISK_CONSULT");
                parcelable2 = (PasskeyEnrollmentWithRiskChallenges) (parcelable5 instanceof PasskeyEnrollmentWithRiskChallenges ? parcelable5 : null);
            }
            return new EnrollPasskeyStateManager(p0, str3, str, str2, str4, uiComponent, useCaseStrategy, str5, (PasskeyEnrollmentWithRiskChallenges) parcelable2, null);
        }
    }

    public static final /* synthetic */ void PlaceComponentResult(EnrollPasskeyStateManager enrollPasskeyStateManager) {
        DanaLog.MyBillsEntityDataFactory("PASSKEY", "executeRiskChallenge invoked");
        String BuiltInFictitiousFunctionClassFactory = ((QueueVerificationMethods) enrollPasskeyStateManager.moveToNextValue.getValue()).BuiltInFictitiousFunctionClassFactory();
        if (BuiltInFictitiousFunctionClassFactory == null) {
            BuiltInFictitiousFunctionClassFactory = "";
        }
        enrollPasskeyStateManager.BuiltInFictitiousFunctionClassFactory(BuiltInFictitiousFunctionClassFactory);
    }

    public static final /* synthetic */ QueueVerificationMethods MyBillsEntityDataFactory(EnrollPasskeyStateManager enrollPasskeyStateManager) {
        return (QueueVerificationMethods) enrollPasskeyStateManager.moveToNextValue.getValue();
    }

    public static final /* synthetic */ RiskChallengeStrategyFactory BuiltInFictitiousFunctionClassFactory(EnrollPasskeyStateManager enrollPasskeyStateManager) {
        return (RiskChallengeStrategyFactory) enrollPasskeyStateManager.getErrorConfigVersion.getValue();
    }

    private final void BuiltInFictitiousFunctionClassFactory(@RiskChallengeKey String p0) {
        try {
            RiskChallengeStrategy PlaceComponentResult = ((RiskChallengeStrategyFactory) this.getErrorConfigVersion.getValue()).PlaceComponentResult(p0);
            PlaceComponentResult.BuiltInFictitiousFunctionClassFactory(new Function1<Bundle, Unit>() { // from class: id.dana.riskChallenges.ui.passkey.launcher.enrollment.EnrollPasskeyStateManager$onHandleRiskChallenge$1
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
                    EnrollPasskeyStateManager enrollPasskeyStateManager = EnrollPasskeyStateManager.this;
                    String string = bundle.getString("KEY_PHONE_NUMBER");
                    enrollPasskeyStateManager.NetworkUserEntityData$$ExternalSyntheticLambda0 = string != null ? string : "";
                    QueueVerificationMethods MyBillsEntityDataFactory = EnrollPasskeyStateManager.MyBillsEntityDataFactory(EnrollPasskeyStateManager.this);
                    final EnrollPasskeyStateManager enrollPasskeyStateManager2 = EnrollPasskeyStateManager.this;
                    Function0<Unit> function0 = new Function0<Unit>() { // from class: id.dana.riskChallenges.ui.passkey.launcher.enrollment.EnrollPasskeyStateManager$onHandleRiskChallenge$1.1
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
                            EnrollPasskeyStateManager enrollPasskeyStateManager3 = EnrollPasskeyStateManager.this;
                            EnrollPasskeyStateManager.PasskeyEnrollmentState.RiskChallenge riskChallenge = EnrollPasskeyStateManager.PasskeyEnrollmentState.RiskChallenge.INSTANCE;
                            Intrinsics.checkNotNullParameter(riskChallenge, "");
                            enrollPasskeyStateManager3.PlaceComponentResult(riskChallenge);
                        }
                    };
                    final EnrollPasskeyStateManager enrollPasskeyStateManager3 = EnrollPasskeyStateManager.this;
                    MyBillsEntityDataFactory.KClassImpl$Data$declaredNonStaticMembers$2(function0, new Function0<Unit>() { // from class: id.dana.riskChallenges.ui.passkey.launcher.enrollment.EnrollPasskeyStateManager$onHandleRiskChallenge$1.2
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
                            EnrollPasskeyStateManager.this.PlaceComponentResult = true;
                            EnrollPasskeyStateManager enrollPasskeyStateManager4 = EnrollPasskeyStateManager.this;
                            EnrollPasskeyStateManager.PasskeyEnrollmentState.Initial initial = EnrollPasskeyStateManager.PasskeyEnrollmentState.Initial.INSTANCE;
                            Intrinsics.checkNotNullParameter(initial, "");
                            enrollPasskeyStateManager4.PlaceComponentResult(initial);
                        }
                    });
                }
            }, new Function1<Bundle, Unit>() { // from class: id.dana.riskChallenges.ui.passkey.launcher.enrollment.EnrollPasskeyStateManager$onHandleRiskChallenge$2
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
                    QueueVerificationMethods MyBillsEntityDataFactory = EnrollPasskeyStateManager.MyBillsEntityDataFactory(EnrollPasskeyStateManager.this);
                    final EnrollPasskeyStateManager enrollPasskeyStateManager = EnrollPasskeyStateManager.this;
                    Function0<Unit> function0 = new Function0<Unit>() { // from class: id.dana.riskChallenges.ui.passkey.launcher.enrollment.EnrollPasskeyStateManager$onHandleRiskChallenge$2.1
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
                            EnrollPasskeyStateManager.BuiltInFictitiousFunctionClassFactory(enrollPasskeyStateManager).KClassImpl$Data$declaredNonStaticMembers$2 = (HistoryFallbackModel) parcelable;
                            EnrollPasskeyStateManager enrollPasskeyStateManager2 = enrollPasskeyStateManager;
                            EnrollPasskeyStateManager.PasskeyEnrollmentState.RiskChallenge riskChallenge = EnrollPasskeyStateManager.PasskeyEnrollmentState.RiskChallenge.INSTANCE;
                            Intrinsics.checkNotNullParameter(riskChallenge, "");
                            enrollPasskeyStateManager2.PlaceComponentResult(riskChallenge);
                        }
                    };
                    final EnrollPasskeyStateManager enrollPasskeyStateManager2 = EnrollPasskeyStateManager.this;
                    MyBillsEntityDataFactory.KClassImpl$Data$declaredNonStaticMembers$2(z, function0, new Function0<Unit>() { // from class: id.dana.riskChallenges.ui.passkey.launcher.enrollment.EnrollPasskeyStateManager$onHandleRiskChallenge$2.2
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
                            EnrollPasskeyStateManager enrollPasskeyStateManager3 = EnrollPasskeyStateManager.this;
                            EnrollPasskeyStateManager.PasskeyEnrollmentState.Failed failed = new EnrollPasskeyStateManager.PasskeyEnrollmentState.Failed(bundle);
                            Intrinsics.checkNotNullParameter(failed, "");
                            enrollPasskeyStateManager3.PlaceComponentResult(failed);
                        }
                    });
                }
            }, new Function0<Unit>() { // from class: id.dana.riskChallenges.ui.passkey.launcher.enrollment.EnrollPasskeyStateManager$onHandleRiskChallenge$3
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
                    EnrollPasskeyStateManager enrollPasskeyStateManager = EnrollPasskeyStateManager.this;
                    EnrollPasskeyStateManager.PasskeyEnrollmentState.Canceled canceled = EnrollPasskeyStateManager.PasskeyEnrollmentState.Canceled.INSTANCE;
                    Intrinsics.checkNotNullParameter(canceled, "");
                    enrollPasskeyStateManager.PlaceComponentResult(canceled);
                }
            });
            RiskChallengeStrategyFactory riskChallengeStrategyFactory = (RiskChallengeStrategyFactory) this.getErrorConfigVersion.getValue();
            Function1<FragmentResultListener, Unit> function1 = new Function1<FragmentResultListener, Unit>() { // from class: id.dana.riskChallenges.ui.passkey.launcher.enrollment.EnrollPasskeyStateManager$onHandleRiskChallenge$4
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
                    EnrollPasskeyStateManager.this.KClassImpl$Data$declaredNonStaticMembers$2 = fragmentResultListener;
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
            PasskeyEnrollmentState.Failed failed = new PasskeyEnrollmentState.Failed(BundleKt.PlaceComponentResult(pairArr));
            Intrinsics.checkNotNullParameter(failed, "");
            PlaceComponentResult(failed);
        }
    }
}
