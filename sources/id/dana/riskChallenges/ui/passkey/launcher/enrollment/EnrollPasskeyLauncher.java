package id.dana.riskChallenges.ui.passkey.launcher.enrollment;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import androidx.core.os.BundleKt;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.view.LifecycleOwner;
import androidx.view.result.ActivityResultLauncher;
import id.dana.core.ui.util.OSUtil;
import id.dana.riskChallenges.R;
import id.dana.riskChallenges.data.passkey.source.local.PasskeyPreferenceEntityData;
import id.dana.riskChallenges.di.component.RiskChallengesComponent;
import id.dana.riskChallenges.di.provider.RiskChallengesProvider;
import id.dana.riskChallenges.domain.passkey.interactor.PasskeyEligibility;
import id.dana.riskChallenges.domain.passkey.interactor.PasskeyEnrollmentStatus;
import id.dana.riskChallenges.domain.passkey.model.PasskeyCredential;
import id.dana.riskChallenges.ui.RiskChallengeActivity;
import id.dana.riskChallenges.ui.resetpin.model.UseCaseStrategy;
import id.dana.riskChallenges.ui.util.StrategyKey;
import id.dana.riskChallenges.ui.util.strategy.BaseLauncher;
import id.dana.riskChallenges.ui.util.uicomponent.UIComponentType;
import id.dana.riskChallenges.ui.util.uicomponent.UiComponent;
import java.util.List;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Triple;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 (2\u00020\u0001:\u0002)(B\t\b\u0002¢\u0006\u0004\b'\u0010\u0004J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J\r\u0010\u0005\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0004J\u0017\u0010\b\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\b\u0010\tJ\u0017\u0010\n\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\n\u0010\tJ\u0017\u0010\u000b\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u000b\u0010\tJ\u000f\u0010\f\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\f\u0010\u0004R\u001c\u0010\u0005\u001a\u00020\r2\u0006\u0010\u0007\u001a\u00020\r@BX\u0080\n¢\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u0080\u0001\u0010\u0015\u001a4\u0012\u0004\u0012\u00020\r\u0012\u0016\u0012\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00130\u0012\u0012\u0004\u0012\u00020\u00020\u0011\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u00020\u0011\u0018\u00010\u001028\u0010\u0007\u001a4\u0012\u0004\u0012\u00020\r\u0012\u0016\u0012\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00130\u0012\u0012\u0004\u0012\u00020\u00020\u0011\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u00020\u0011\u0018\u00010\u0010@BX\u0080\n¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u001c\u0010\f\u001a\u00020\r2\u0006\u0010\u0007\u001a\u00020\r@BX\u0080\n¢\u0006\u0006\n\u0004\b\u0005\u0010\u000fR \u0010\u000e\u001a\u0004\u0018\u00010\u00172\b\u0010\u0007\u001a\u0004\u0018\u00010\u0017@BX\u0080\n¢\u0006\u0006\n\u0004\b\u0003\u0010\u0018R\u0012\u0010\u001a\u001a\u00020\u0019X\u0081\"¢\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u0012\u0010\u001d\u001a\u00020\u001cX\u0081\"¢\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\u0014\u0010\u0003\u001a\u0004\u0018\u00010\u001fX\u0081\u0002¢\u0006\u0006\n\u0004\b\f\u0010 R\u0014\u0010$\u001a\u0004\u0018\u00010!X\u0081\u0002¢\u0006\u0006\n\u0004\b\"\u0010#R \u0010%\u001a\u0004\u0018\u00010\u00172\b\u0010\u0007\u001a\u0004\u0018\u00010\u0017@BX\u0081\n¢\u0006\u0006\n\u0004\b%\u0010\u0018R \u0010&\u001a\u0004\u0018\u00010\u00172\b\u0010\u0007\u001a\u0004\u0018\u00010\u0017@BX\u0081\n¢\u0006\u0006\n\u0004\b&\u0010\u0018"}, d2 = {"Lid/dana/riskChallenges/ui/passkey/launcher/enrollment/EnrollPasskeyLauncher;", "Lid/dana/riskChallenges/ui/util/strategy/BaseLauncher;", "", "BuiltInFictitiousFunctionClassFactory", "()V", "getAuthRequestContext", "Landroidx/lifecycle/LifecycleOwner;", "p0", "onCreate", "(Landroidx/lifecycle/LifecycleOwner;)V", "onDestroy", "onStart", "KClassImpl$Data$declaredNonStaticMembers$2", "", "PlaceComponentResult", "Z", "Lkotlin/Triple;", "Lkotlin/Function1;", "", "Lid/dana/riskChallenges/domain/passkey/model/PasskeyCredential;", "", "MyBillsEntityDataFactory", "Lkotlin/Triple;", "", "Ljava/lang/String;", "Lid/dana/riskChallenges/domain/passkey/interactor/PasskeyEligibility;", "passkeyEligibility", "Lid/dana/riskChallenges/domain/passkey/interactor/PasskeyEligibility;", "Lid/dana/riskChallenges/domain/passkey/interactor/PasskeyEnrollmentStatus;", "passkeyEnrollmentStatus", "Lid/dana/riskChallenges/domain/passkey/interactor/PasskeyEnrollmentStatus;", "Lid/dana/riskChallenges/di/component/RiskChallengesComponent;", "Lid/dana/riskChallenges/di/component/RiskChallengesComponent;", "Lid/dana/riskChallenges/di/provider/RiskChallengesProvider;", "NetworkUserEntityData$$ExternalSyntheticLambda0", "Lid/dana/riskChallenges/di/provider/RiskChallengesProvider;", "scheduleImpl", "moveToNextValue", "lookAheadTest", "<init>", "Companion", "Builder"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class EnrollPasskeyLauncher extends BaseLauncher {

    /* renamed from: Companion  reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
    public String PlaceComponentResult;

    /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
    public RiskChallengesComponent BuiltInFictitiousFunctionClassFactory;
    public Triple<Boolean, ? extends Function1<? super List<PasskeyCredential>, Unit>, ? extends Function1<? super Throwable, Unit>> MyBillsEntityDataFactory;

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda0  reason: from kotlin metadata */
    public RiskChallengesProvider scheduleImpl;

    /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
    public boolean getAuthRequestContext;

    /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
    public boolean KClassImpl$Data$declaredNonStaticMembers$2;
    public String lookAheadTest;
    public String moveToNextValue;
    @Inject
    public PasskeyEligibility passkeyEligibility;
    @Inject
    public PasskeyEnrollmentStatus passkeyEnrollmentStatus;

    public /* synthetic */ EnrollPasskeyLauncher(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    private EnrollPasskeyLauncher() {
        this.getAuthRequestContext = true;
    }

    @Override // id.dana.riskChallenges.ui.util.strategy.RiskChallengeStrategy
    public final void BuiltInFictitiousFunctionClassFactory() {
        KClassImpl$Data$declaredNonStaticMembers$2();
    }

    private final void KClassImpl$Data$declaredNonStaticMembers$2() {
        Intent intent = new Intent(getErrorConfigVersion(), RiskChallengeActivity.class);
        intent.putExtras(BundleKt.PlaceComponentResult(TuplesKt.to("KEY_STRATEGY", this.DatabaseTableConfigUtil), TuplesKt.to("KEY_SOURCE", this.lookAheadTest), TuplesKt.to("KEY_PURPOSE", this.moveToNextValue), TuplesKt.to("KEY_PASSKEY_PAGE_SOURCE", this.PlaceComponentResult), TuplesKt.to("KEY_USE_CASE_STRATEGY", new UseCaseStrategy("AP_DAPROT_ACTIVITY", null, null, 6, null)), TuplesKt.to("KEY_UI_COMPONENT", this.NetworkUserEntityData$$ExternalSyntheticLambda2)));
        ActivityResultLauncher<Intent> activityResultLauncher = this.BuiltInFictitiousFunctionClassFactory;
        if (activityResultLauncher != null) {
            activityResultLauncher.MyBillsEntityDataFactory(intent, null);
        }
    }

    @Override // id.dana.riskChallenges.ui.util.strategy.BaseLauncher, androidx.view.FullLifecycleObserver
    public final void onStart(LifecycleOwner p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        super.onStart(p0);
        if (this.getAuthRequestContext) {
            getAuthRequestContext();
        }
    }

    public final void getAuthRequestContext() {
        Triple<Boolean, ? extends Function1<? super List<PasskeyCredential>, Unit>, ? extends Function1<? super Throwable, Unit>> triple;
        if (!this.KClassImpl$Data$declaredNonStaticMembers$2 || (triple = this.MyBillsEntityDataFactory) == null) {
            return;
        }
        boolean booleanValue = triple.component1().booleanValue();
        Function1<? super List<PasskeyCredential>, Unit> component2 = triple.component2();
        Function1<? super Throwable, Unit> component3 = triple.component3();
        PasskeyEnrollmentStatus passkeyEnrollmentStatus = this.passkeyEnrollmentStatus;
        if (passkeyEnrollmentStatus == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            passkeyEnrollmentStatus = null;
        }
        passkeyEnrollmentStatus.execute(new PasskeyEnrollmentStatus.Params(booleanValue), component2, component3);
    }

    public static /* synthetic */ void KClassImpl$Data$declaredNonStaticMembers$2(EnrollPasskeyLauncher enrollPasskeyLauncher, boolean z, boolean z2, PasskeyEligibility.Params.TypeFor typeFor, final Function1 function1, int i) {
        if ((i & 1) != 0) {
            z = true;
        }
        if ((i & 2) != 0) {
            z2 = true;
        }
        if ((i & 4) != 0) {
            typeFor = PasskeyEligibility.Params.TypeFor.Enrollment.INSTANCE;
        }
        if ((i & 8) != 0) {
            function1 = new Function1<Boolean, Unit>() { // from class: id.dana.riskChallenges.ui.passkey.launcher.enrollment.EnrollPasskeyLauncher$checkEligibility$1
                public final void invoke(boolean z3) {
                }

                @Override // kotlin.jvm.functions.Function1
                public final /* synthetic */ Unit invoke(Boolean bool) {
                    invoke(bool.booleanValue());
                    return Unit.INSTANCE;
                }
            };
        }
        Intrinsics.checkNotNullParameter(typeFor, "");
        Intrinsics.checkNotNullParameter(function1, "");
        PasskeyEligibility passkeyEligibility = enrollPasskeyLauncher.passkeyEligibility;
        if (passkeyEligibility == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            passkeyEligibility = null;
        }
        passkeyEligibility.execute(new PasskeyEligibility.Params(z, z2, typeFor), new Function1<Boolean, Unit>() { // from class: id.dana.riskChallenges.ui.passkey.launcher.enrollment.EnrollPasskeyLauncher$checkEligibility$2
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final /* synthetic */ Unit invoke(Boolean bool) {
                invoke(bool.booleanValue());
                return Unit.INSTANCE;
            }

            public final void invoke(boolean z3) {
                function1.invoke(Boolean.valueOf(z3));
            }
        }, new Function1<Throwable, Unit>() { // from class: id.dana.riskChallenges.ui.passkey.launcher.enrollment.EnrollPasskeyLauncher$checkEligibility$3
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
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
                function1.invoke(Boolean.FALSE);
            }
        });
    }

    @Override // id.dana.riskChallenges.ui.util.strategy.BaseLauncher, androidx.view.FullLifecycleObserver
    public final void onCreate(LifecycleOwner p0) {
        RiskChallengesComponent.Factory provideRiskChallengesComponent;
        Intrinsics.checkNotNullParameter(p0, "");
        super.onCreate(p0);
        RiskChallengesProvider riskChallengesProvider = this.scheduleImpl;
        RiskChallengesComponent riskChallengesComponent = null;
        if (riskChallengesProvider == null) {
            Context MyBillsEntityDataFactory = MyBillsEntityDataFactory();
            riskChallengesProvider = MyBillsEntityDataFactory instanceof RiskChallengesProvider ? (RiskChallengesProvider) MyBillsEntityDataFactory : null;
        }
        if (riskChallengesProvider != null && (provideRiskChallengesComponent = riskChallengesProvider.provideRiskChallengesComponent()) != null) {
            riskChallengesComponent = provideRiskChallengesComponent.BuiltInFictitiousFunctionClassFactory();
        }
        this.BuiltInFictitiousFunctionClassFactory = riskChallengesComponent;
        if (riskChallengesComponent != null) {
            riskChallengesComponent.MyBillsEntityDataFactory(this);
        }
    }

    @Override // id.dana.riskChallenges.ui.util.strategy.BaseLauncher, androidx.view.FullLifecycleObserver
    public final void onDestroy(LifecycleOwner p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        super.onDestroy(p0);
        PasskeyEnrollmentStatus passkeyEnrollmentStatus = this.passkeyEnrollmentStatus;
        if (passkeyEnrollmentStatus == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            passkeyEnrollmentStatus = null;
        }
        passkeyEnrollmentStatus.dispose();
    }

    @Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0010\u0003\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0011\b\u0016\u0012\u0006\u0010\u0017\u001a\u00020\u0016¢\u0006\u0004\b\u0018\u0010\u0019B\u0011\b\u0016\u0012\u0006\u0010\u0017\u001a\u00020\u001a¢\u0006\u0004\b\u0018\u0010\u001bJ\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004R\u0016\u0010\b\u001a\u00020\u00058\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0006\u0010\u0007RH\u0010\u000f\u001a4\u0012\u0004\u0012\u00020\u0005\u0012\u0016\u0012\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\u000b\u0012\u0004\u0012\u00020\r0\n\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\r0\n\u0018\u00010\t8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u0016\u0010\u0003\u001a\u00020\u00058\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0011\u0010\u0007R\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00128\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\b\u0010\u0013R\u0018\u0010\u0014\u001a\u0004\u0018\u00010\u00128\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0014\u0010\u0013R\u0018\u0010\u0015\u001a\u0004\u0018\u00010\u00128\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0003\u0010\u0013"}, d2 = {"Lid/dana/riskChallenges/ui/passkey/launcher/enrollment/EnrollPasskeyLauncher$Builder;", "Lid/dana/riskChallenges/ui/util/strategy/BaseLauncher$BaseBuilder;", "Lid/dana/riskChallenges/ui/passkey/launcher/enrollment/EnrollPasskeyLauncher;", "BuiltInFictitiousFunctionClassFactory", "()Lid/dana/riskChallenges/ui/passkey/launcher/enrollment/EnrollPasskeyLauncher;", "", "MyBillsEntityDataFactory", "Z", "getAuthRequestContext", "Lkotlin/Triple;", "Lkotlin/Function1;", "", "Lid/dana/riskChallenges/domain/passkey/model/PasskeyCredential;", "", "", "KClassImpl$Data$declaredNonStaticMembers$2", "Lkotlin/Triple;", "getErrorConfigVersion", "", "Ljava/lang/String;", "PlaceComponentResult", "moveToNextValue", "Landroidx/fragment/app/FragmentActivity;", "p0", "<init>", "(Landroidx/fragment/app/FragmentActivity;)V", "Landroidx/fragment/app/Fragment;", "(Landroidx/fragment/app/Fragment;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class Builder extends BaseLauncher.BaseBuilder<EnrollPasskeyLauncher> {

        /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
        public String moveToNextValue;
        private Triple<Boolean, ? extends Function1<? super List<PasskeyCredential>, Unit>, ? extends Function1<? super Throwable, Unit>> KClassImpl$Data$declaredNonStaticMembers$2;

        /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
        private boolean getAuthRequestContext;
        public String PlaceComponentResult;

        /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
        public String MyBillsEntityDataFactory;

        /* renamed from: getErrorConfigVersion  reason: from kotlin metadata */
        private boolean BuiltInFictitiousFunctionClassFactory;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Builder(FragmentActivity fragmentActivity) {
            super(fragmentActivity);
            Intrinsics.checkNotNullParameter(fragmentActivity, "");
            this.getAuthRequestContext = true;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Builder(Fragment fragment) {
            super(fragment);
            Intrinsics.checkNotNullParameter(fragment, "");
            this.getAuthRequestContext = true;
        }

        public static /* synthetic */ Builder BuiltInFictitiousFunctionClassFactory(Builder builder, boolean z, boolean z2, Function1 function1, Function1 function12, int i) {
            if ((i & 1) != 0) {
                z = false;
            }
            if ((i & 2) != 0) {
                z2 = true;
            }
            if ((i & 4) != 0) {
                function1 = new Function1<List<? extends PasskeyCredential>, Unit>() { // from class: id.dana.riskChallenges.ui.passkey.launcher.enrollment.EnrollPasskeyLauncher$Builder$setCheckEnrollmentStatus$1
                    /* renamed from: invoke  reason: avoid collision after fix types in other method */
                    public final void invoke2(List<PasskeyCredential> list) {
                        Intrinsics.checkNotNullParameter(list, "");
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final /* bridge */ /* synthetic */ Unit invoke(List<? extends PasskeyCredential> list) {
                        invoke2((List<PasskeyCredential>) list);
                        return Unit.INSTANCE;
                    }
                };
            }
            if ((i & 8) != 0) {
                function12 = new Function1<Throwable, Unit>() { // from class: id.dana.riskChallenges.ui.passkey.launcher.enrollment.EnrollPasskeyLauncher$Builder$setCheckEnrollmentStatus$2
                    /* renamed from: invoke  reason: avoid collision after fix types in other method */
                    public final void invoke2(Throwable th) {
                        Intrinsics.checkNotNullParameter(th, "");
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
                        invoke2(th);
                        return Unit.INSTANCE;
                    }
                };
            }
            Intrinsics.checkNotNullParameter(function1, "");
            Intrinsics.checkNotNullParameter(function12, "");
            builder.BuiltInFictitiousFunctionClassFactory = true;
            builder.getAuthRequestContext = z2;
            builder.KClassImpl$Data$declaredNonStaticMembers$2 = new Triple<>(Boolean.valueOf(z), function1, function12);
            return builder;
        }

        @Override // id.dana.riskChallenges.ui.util.strategy.BaseLauncher.BaseBuilder
        /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: merged with bridge method [inline-methods] */
        public final EnrollPasskeyLauncher KClassImpl$Data$declaredNonStaticMembers$2() {
            EnrollPasskeyLauncher enrollPasskeyLauncher = new EnrollPasskeyLauncher(null);
            enrollPasskeyLauncher.NetworkUserEntityData$$ExternalSyntheticLambda0 = getNetworkUserEntityData$$ExternalSyntheticLambda0();
            enrollPasskeyLauncher.getAuthRequestContext = getBuiltInFictitiousFunctionClassFactory();
            enrollPasskeyLauncher.lookAheadTest = this.moveToNextValue;
            enrollPasskeyLauncher.moveToNextValue = this.PlaceComponentResult;
            Function1<? super Bundle, Unit> function1 = this.getErrorConfigVersion;
            Function1<? super Bundle, Unit> function12 = this.PlaceComponentResult;
            Function0<Unit> function0 = this.KClassImpl$Data$declaredNonStaticMembers$2;
            enrollPasskeyLauncher.GetContactSyncConfig = function1;
            enrollPasskeyLauncher.moveToNextValue = function12;
            enrollPasskeyLauncher.MyBillsEntityDataFactory = function0;
            enrollPasskeyLauncher.DatabaseTableConfigUtil = StrategyKey.PASSKEY_REGISTRATION;
            enrollPasskeyLauncher.KClassImpl$Data$declaredNonStaticMembers$2 = this.BuiltInFictitiousFunctionClassFactory;
            enrollPasskeyLauncher.MyBillsEntityDataFactory = this.KClassImpl$Data$declaredNonStaticMembers$2;
            enrollPasskeyLauncher.PlaceComponentResult = this.MyBillsEntityDataFactory;
            enrollPasskeyLauncher.NetworkUserEntityData$$ExternalSyntheticLambda2 = new UiComponent(UIComponentType.Full, R.color.KClassImpl$Data$declaredNonStaticMembers$2, R.string.verify_pin_title);
            enrollPasskeyLauncher.getAuthRequestContext = this.getAuthRequestContext;
            return enrollPasskeyLauncher;
        }
    }

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\n\u0010\u000bJ\u0015\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\b\u001a\u00020\u0007H\u0007¢\u0006\u0004\b\b\u0010\t"}, d2 = {"Lid/dana/riskChallenges/ui/passkey/launcher/enrollment/EnrollPasskeyLauncher$Companion;", "", "Landroid/content/Context;", "p0", "", "MyBillsEntityDataFactory", "(Landroid/content/Context;)V", "", "PlaceComponentResult", "()Z", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public static boolean PlaceComponentResult() {
            OSUtil oSUtil = OSUtil.INSTANCE;
            if (OSUtil.moveToNextValue()) {
                OSUtil oSUtil2 = OSUtil.INSTANCE;
                if (OSUtil.getAuthRequestContext()) {
                    return true;
                }
            }
            return false;
        }

        public static void MyBillsEntityDataFactory(Context p0) {
            Intrinsics.checkNotNullParameter(p0, "");
            new PasskeyPreferenceEntityData.Impl(p0).BuiltInFictitiousFunctionClassFactory.clearAllData();
        }
    }
}
