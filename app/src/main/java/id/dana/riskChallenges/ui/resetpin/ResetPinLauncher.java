package id.dana.riskChallenges.ui.resetpin;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import androidx.core.os.BundleKt;
import androidx.fragment.app.FragmentActivity;
import androidx.view.LifecycleOwner;
import androidx.view.result.ActivityResultLauncher;
import id.dana.analytics.mixpanel.MixPanelEvent;
import id.dana.analytics.tracker.TrackerKey;
import id.dana.network.exception.NetworkException;
import id.dana.riskChallenges.di.component.RiskChallengesComponent;
import id.dana.riskChallenges.di.provider.RiskChallengesProvider;
import id.dana.riskChallenges.domain.forgetpassword.interactor.ForgetPasswordConsult;
import id.dana.riskChallenges.domain.forgetpassword.model.RiskChallenges;
import id.dana.riskChallenges.ui.RiskChallengeActivity;
import id.dana.riskChallenges.ui.passkey.launcher.enrollment.EnrollPasskeyLauncher;
import id.dana.riskChallenges.ui.resetpin.mapper.ResetPinMapperKt;
import id.dana.riskChallenges.ui.resetpin.model.ResetPinModel;
import id.dana.riskChallenges.ui.resetpin.model.UseCaseStrategy;
import id.dana.riskChallenges.ui.util.strategy.BaseLauncher;
import id.dana.utils.android.AppUtil;
import java.io.Serializable;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \u001e2\u00020\u0001:\u0002\u001f\u001eB\t\b\u0002¢\u0006\u0004\b\u001d\u0010\bJ\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\u0007\u001a\u00020\u0004H\u0014¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\t\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\t\u0010\bJ\u0017\u0010\u000b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\nH\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\r\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\r\u0010\bR\u0012\u0010\u000f\u001a\u00020\u000eX\u0081\"¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u001c\u0010\t\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002@BX\u0081\n¢\u0006\u0006\n\u0004\b\t\u0010\u0011R \u0010\r\u001a\u0004\u0018\u00010\u00022\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002@BX\u0081\n¢\u0006\u0006\n\u0004\b\u0005\u0010\u0011R\u0014\u0010\u0007\u001a\u0004\u0018\u00010\u0012X\u0081\u0002¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u0014\u0010\u0005\u001a\u0004\u0018\u00010\u0015X\u0081\u0002¢\u0006\u0006\n\u0004\b\u0007\u0010\u0016R \u0010\u0013\u001a\u0004\u0018\u00010\u00022\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002@BX\u0081\n¢\u0006\u0006\n\u0004\b\r\u0010\u0011R \u0010\u0018\u001a\u0004\u0018\u00010\u00022\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002@BX\u0081\n¢\u0006\u0006\n\u0004\b\u0017\u0010\u0011R\u001c\u0010\u001c\u001a\u00020\u00192\u0006\u0010\u0003\u001a\u00020\u0019@BX\u0081\n¢\u0006\u0006\n\u0004\b\u001a\u0010\u001b"}, d2 = {"Lid/dana/riskChallenges/ui/resetpin/ResetPinLauncher;", "Lid/dana/riskChallenges/ui/util/strategy/BaseLauncher;", "", "p0", "", "MyBillsEntityDataFactory", "(Ljava/lang/String;)V", "PlaceComponentResult", "()V", "BuiltInFictitiousFunctionClassFactory", "Landroidx/lifecycle/LifecycleOwner;", "onCreate", "(Landroidx/lifecycle/LifecycleOwner;)V", "KClassImpl$Data$declaredNonStaticMembers$2", "Lid/dana/riskChallenges/domain/forgetpassword/interactor/ForgetPasswordConsult;", "forgetPasswordConsult", "Lid/dana/riskChallenges/domain/forgetpassword/interactor/ForgetPasswordConsult;", "Ljava/lang/String;", "Lid/dana/riskChallenges/di/component/RiskChallengesComponent;", "getAuthRequestContext", "Lid/dana/riskChallenges/di/component/RiskChallengesComponent;", "Lid/dana/riskChallenges/di/provider/RiskChallengesProvider;", "Lid/dana/riskChallenges/di/provider/RiskChallengesProvider;", "getErrorConfigVersion", "lookAheadTest", "Lid/dana/riskChallenges/ui/resetpin/model/UseCaseStrategy;", "NetworkUserEntityData$$ExternalSyntheticLambda0", "Lid/dana/riskChallenges/ui/resetpin/model/UseCaseStrategy;", "moveToNextValue", "<init>", "Companion", "Builder"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class ResetPinLauncher extends BaseLauncher {
    public String BuiltInFictitiousFunctionClassFactory;

    /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
    public String getAuthRequestContext;

    /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
    public String KClassImpl$Data$declaredNonStaticMembers$2;

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda0  reason: from kotlin metadata */
    public UseCaseStrategy moveToNextValue;

    /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
    public RiskChallengesProvider MyBillsEntityDataFactory;
    @Inject
    public ForgetPasswordConsult forgetPasswordConsult;

    /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
    public RiskChallengesComponent PlaceComponentResult;

    /* renamed from: getErrorConfigVersion  reason: from kotlin metadata */
    public String lookAheadTest;

    public /* synthetic */ ResetPinLauncher(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    private ResetPinLauncher() {
        this.BuiltInFictitiousFunctionClassFactory = "";
        this.moveToNextValue = new UseCaseStrategy("MODIFY_PASSWORD", null, null, 6, null);
    }

    @Override // id.dana.riskChallenges.ui.util.strategy.RiskChallengeStrategy
    public final void BuiltInFictitiousFunctionClassFactory() {
        MyBillsEntityDataFactory(this.BuiltInFictitiousFunctionClassFactory);
    }

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
            riskChallengesComponent.BuiltInFictitiousFunctionClassFactory(this);
        }
    }

    private final void MyBillsEntityDataFactory(String p0) {
        ForgetPasswordConsult forgetPasswordConsult = null;
        String str = Intrinsics.areEqual(this.getAuthRequestContext, TrackerKey.RiskChallenge.Source.SELF_UNFREEZE) ? "SELF_UNFREEZE" : null;
        boolean MyBillsEntityDataFactory = AppUtil.MyBillsEntityDataFactory(getErrorConfigVersion());
        EnrollPasskeyLauncher.Companion companion = EnrollPasskeyLauncher.INSTANCE;
        boolean PlaceComponentResult = EnrollPasskeyLauncher.Companion.PlaceComponentResult();
        ForgetPasswordConsult forgetPasswordConsult2 = this.forgetPasswordConsult;
        if (forgetPasswordConsult2 != null) {
            forgetPasswordConsult = forgetPasswordConsult2;
        } else {
            Intrinsics.throwUninitializedPropertyAccessException("");
        }
        forgetPasswordConsult.execute(new ForgetPasswordConsult.Params(p0, str, MyBillsEntityDataFactory, PlaceComponentResult), new Function1<RiskChallenges, Unit>() { // from class: id.dana.riskChallenges.ui.resetpin.ResetPinLauncher$consultRiskChallenges$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final /* bridge */ /* synthetic */ Unit invoke(RiskChallenges riskChallenges) {
                invoke2(riskChallenges);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(RiskChallenges riskChallenges) {
                Intrinsics.checkNotNullParameter(riskChallenges, "");
                ResetPinLauncher resetPinLauncher = ResetPinLauncher.this;
                Intrinsics.checkNotNullParameter(riskChallenges, "");
                ResetPinModel KClassImpl$Data$declaredNonStaticMembers$2 = ResetPinMapperKt.KClassImpl$Data$declaredNonStaticMembers$2(riskChallenges);
                Intent intent = new Intent(resetPinLauncher.getErrorConfigVersion(), RiskChallengeActivity.class);
                intent.putExtras(BundleKt.PlaceComponentResult(TuplesKt.to("KEY_STRATEGY", resetPinLauncher.DatabaseTableConfigUtil), TuplesKt.to("KEY_UI_COMPONENT", resetPinLauncher.NetworkUserEntityData$$ExternalSyntheticLambda2), TuplesKt.to("KEY_DATA_RISK_CONSULT", KClassImpl$Data$declaredNonStaticMembers$2), TuplesKt.to("KEY_LOGIN_TYPE", resetPinLauncher.BuiltInFictitiousFunctionClassFactory), TuplesKt.to("KEY_PHONE_NUMBER", resetPinLauncher.KClassImpl$Data$declaredNonStaticMembers$2), TuplesKt.to("KEY_USE_CASE_STRATEGY", resetPinLauncher.moveToNextValue), TuplesKt.to("KEY_SOURCE", resetPinLauncher.getAuthRequestContext), TuplesKt.to("KEY_PURPOSE", resetPinLauncher.lookAheadTest)));
                resetPinLauncher.KClassImpl$Data$declaredNonStaticMembers$2();
                ActivityResultLauncher<Intent> activityResultLauncher = resetPinLauncher.BuiltInFictitiousFunctionClassFactory;
                if (activityResultLauncher != null) {
                    activityResultLauncher.MyBillsEntityDataFactory(intent, null);
                }
                ResetPinLauncher.this.getErrorConfigVersion.invoke();
            }
        }, new Function1<Throwable, Unit>() { // from class: id.dana.riskChallenges.ui.resetpin.ResetPinLauncher$consultRiskChallenges$2
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
                ResetPinLauncher.getAuthRequestContext(ResetPinLauncher.this, th);
                ResetPinLauncher.this.getErrorConfigVersion.invoke();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void KClassImpl$Data$declaredNonStaticMembers$2() {
        MixPanelEvent.Builder builder = new MixPanelEvent.Builder(getErrorConfigVersion());
        builder.KClassImpl$Data$declaredNonStaticMembers$2 = TrackerKey.Event.PIN_FORGOT_PAGE_OPEN;
        Pair<String, Object>[] pairArr = new Pair[1];
        String str = this.getAuthRequestContext;
        if (str == null) {
            str = "";
        }
        pairArr[0] = TuplesKt.to("Source", str);
        new MixPanelEvent(builder.MyBillsEntityDataFactory(pairArr), (byte) 0).PlaceComponentResult();
    }

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0019\b\u0016\u0012\u0006\u0010\u000f\u001a\u00020\u000e\u0012\u0006\u0010\u0010\u001a\u00020\u0003¢\u0006\u0004\b\u0011\u0010\u0012R\u0012\u0010\u0004\u001a\u00020\u0003X\u0096\u0002¢\u0006\u0006\n\u0004\b\u0004\u0010\u0005R\u0016\u0010\u0006\u001a\u00020\u00038\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0006\u0010\u0005R\u0018\u0010\b\u001a\u0004\u0018\u00010\u00038\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0007\u0010\u0005R\u0018\u0010\t\u001a\u0004\u0018\u00010\u00038\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\t\u0010\u0005R\u0018\u0010\u0007\u001a\u0004\u0018\u00010\u00038\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\b\u0010\u0005R\u0016\u0010\r\u001a\u00020\n8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u000b\u0010\f"}, d2 = {"Lid/dana/riskChallenges/ui/resetpin/ResetPinLauncher$Builder;", "Lid/dana/riskChallenges/ui/util/strategy/BaseLauncher$BaseBuilder;", "Lid/dana/riskChallenges/ui/resetpin/ResetPinLauncher;", "", "KClassImpl$Data$declaredNonStaticMembers$2", "Ljava/lang/String;", "MyBillsEntityDataFactory", "BuiltInFictitiousFunctionClassFactory", "PlaceComponentResult", "getAuthRequestContext", "Lid/dana/riskChallenges/ui/resetpin/model/UseCaseStrategy;", "getErrorConfigVersion", "Lid/dana/riskChallenges/ui/resetpin/model/UseCaseStrategy;", "lookAheadTest", "Landroidx/fragment/app/FragmentActivity;", "p0", "p1", "<init>", "(Landroidx/fragment/app/FragmentActivity;Ljava/lang/String;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class Builder extends BaseLauncher.BaseBuilder<ResetPinLauncher> {

        /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
        public String PlaceComponentResult;
        public String KClassImpl$Data$declaredNonStaticMembers$2;
        private String MyBillsEntityDataFactory;

        /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
        public String BuiltInFictitiousFunctionClassFactory;
        public String getAuthRequestContext;

        /* renamed from: getErrorConfigVersion  reason: from kotlin metadata */
        private UseCaseStrategy lookAheadTest;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Builder(FragmentActivity fragmentActivity, String str) {
            super(fragmentActivity);
            Intrinsics.checkNotNullParameter(fragmentActivity, "");
            Intrinsics.checkNotNullParameter(str, "");
            this.KClassImpl$Data$declaredNonStaticMembers$2 = "RESET_PIN";
            this.lookAheadTest = new UseCaseStrategy("MODIFY_PASSWORD", "AP_RESET_SIMPLE_PWD", "AP_RESET_SIMPLE_PWD");
            this.MyBillsEntityDataFactory = str;
        }

        @Override // id.dana.riskChallenges.ui.util.strategy.BaseLauncher.BaseBuilder
        public final /* synthetic */ ResetPinLauncher KClassImpl$Data$declaredNonStaticMembers$2() {
            ResetPinLauncher resetPinLauncher = new ResetPinLauncher(null);
            resetPinLauncher.NetworkUserEntityData$$ExternalSyntheticLambda0 = getNetworkUserEntityData$$ExternalSyntheticLambda0();
            resetPinLauncher.getAuthRequestContext = getBuiltInFictitiousFunctionClassFactory();
            resetPinLauncher.NetworkUserEntityData$$ExternalSyntheticLambda2 = this.scheduleImpl;
            resetPinLauncher.DatabaseTableConfigUtil = this.KClassImpl$Data$declaredNonStaticMembers$2;
            resetPinLauncher.BuiltInFictitiousFunctionClassFactory = this.MyBillsEntityDataFactory;
            resetPinLauncher.KClassImpl$Data$declaredNonStaticMembers$2 = this.PlaceComponentResult;
            Function1<? super Bundle, Unit> function1 = this.getErrorConfigVersion;
            Function1<? super Bundle, Unit> function12 = this.PlaceComponentResult;
            Function0<Unit> function0 = this.KClassImpl$Data$declaredNonStaticMembers$2;
            resetPinLauncher.GetContactSyncConfig = function1;
            resetPinLauncher.moveToNextValue = function12;
            resetPinLauncher.MyBillsEntityDataFactory = function0;
            Function0<Unit> function02 = this.MyBillsEntityDataFactory;
            Intrinsics.checkNotNullParameter(function02, "");
            resetPinLauncher.getErrorConfigVersion = function02;
            resetPinLauncher.KClassImpl$Data$declaredNonStaticMembers$2 = this.PlaceComponentResult;
            resetPinLauncher.moveToNextValue = this.lookAheadTest;
            resetPinLauncher.getAuthRequestContext = this.BuiltInFictitiousFunctionClassFactory;
            resetPinLauncher.lookAheadTest = this.getAuthRequestContext;
            return resetPinLauncher;
        }
    }

    public static final /* synthetic */ void getAuthRequestContext(ResetPinLauncher resetPinLauncher, Throwable th) {
        NetworkException networkException = th instanceof NetworkException ? (NetworkException) th : null;
        if (Intrinsics.areEqual("AE15101858018086", networkException != null ? networkException.getErrorCode() : null)) {
            Intent intent = new Intent(resetPinLauncher.getErrorConfigVersion(), RiskChallengeActivity.class);
            intent.putExtras(BundleKt.PlaceComponentResult(TuplesKt.to("KEY_STRATEGY", resetPinLauncher.DatabaseTableConfigUtil), TuplesKt.to("KEY_PHONE_NUMBER", resetPinLauncher.KClassImpl$Data$declaredNonStaticMembers$2), TuplesKt.to("KEY_UI_COMPONENT", resetPinLauncher.NetworkUserEntityData$$ExternalSyntheticLambda2), TuplesKt.to("KEY_USE_CASE_STRATEGY", resetPinLauncher.moveToNextValue)));
            resetPinLauncher.KClassImpl$Data$declaredNonStaticMembers$2();
            ActivityResultLauncher<Intent> activityResultLauncher = resetPinLauncher.BuiltInFictitiousFunctionClassFactory;
            if (activityResultLauncher != null) {
                activityResultLauncher.MyBillsEntityDataFactory(intent, null);
                return;
            }
            return;
        }
        Function1<? super Bundle, Unit> function1 = resetPinLauncher.moveToNextValue;
        if (function1 != null) {
            Pair[] pairArr = new Pair[1];
            pairArr[0] = TuplesKt.to("KEY_ERROR_THROWABLE", th instanceof Serializable ? th : null);
            function1.invoke(BundleKt.PlaceComponentResult(pairArr));
        }
    }

    @Override // id.dana.riskChallenges.ui.util.strategy.BaseLauncher
    public final void PlaceComponentResult() {
        ForgetPasswordConsult forgetPasswordConsult = this.forgetPasswordConsult;
        if (forgetPasswordConsult == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            forgetPasswordConsult = null;
        }
        forgetPasswordConsult.dispose();
    }
}
