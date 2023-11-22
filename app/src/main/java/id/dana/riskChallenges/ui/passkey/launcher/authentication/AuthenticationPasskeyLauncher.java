package id.dana.riskChallenges.ui.passkey.launcher.authentication;

import android.content.Intent;
import android.os.Bundle;
import androidx.core.os.BundleKt;
import androidx.fragment.app.FragmentActivity;
import androidx.view.result.ActivityResult;
import androidx.view.result.ActivityResultCallback;
import androidx.view.result.ActivityResultLauncher;
import androidx.view.result.contract.ActivityResultContracts;
import id.dana.riskChallenges.ui.RiskChallengeActivity;
import id.dana.riskChallenges.ui.util.StrategyKey;
import id.dana.riskChallenges.ui.util.strategy.BaseLauncher;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0016\u0018\u00002\u00020\u0001:\u0001\rB\t\b\u0000¢\u0006\u0004\b\f\u0010\u0004J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0005\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0005\u0010\u0004R \u0010\t\u001a\u0004\u0018\u00010\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006@BX\u0080\n¢\u0006\u0006\n\u0004\b\u0005\u0010\bR\u0014\u0010\u000b\u001a\u0004\u0018\u00010\u0006X\u0080\u0002¢\u0006\u0006\n\u0004\b\n\u0010\bR \u0010\u0003\u001a\u0004\u0018\u00010\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006@BX\u0080\n¢\u0006\u0006\n\u0004\b\u000b\u0010\bR \u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006@BX\u0080\n¢\u0006\u0006\n\u0004\b\t\u0010\b"}, d2 = {"Lid/dana/riskChallenges/ui/passkey/launcher/authentication/AuthenticationPasskeyLauncher;", "Lid/dana/riskChallenges/ui/util/strategy/BaseLauncher;", "", "BuiltInFictitiousFunctionClassFactory", "()V", "KClassImpl$Data$declaredNonStaticMembers$2", "", "p0", "Ljava/lang/String;", "MyBillsEntityDataFactory", "PlaceComponentResult", "getAuthRequestContext", "<init>", "Builder"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public class AuthenticationPasskeyLauncher extends BaseLauncher {

    /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
    public String MyBillsEntityDataFactory;

    /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
    public String KClassImpl$Data$declaredNonStaticMembers$2;

    /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
    String getAuthRequestContext;

    /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
    public String BuiltInFictitiousFunctionClassFactory;

    @Override // id.dana.riskChallenges.ui.util.strategy.RiskChallengeStrategy
    public final void BuiltInFictitiousFunctionClassFactory() {
        KClassImpl$Data$declaredNonStaticMembers$2();
    }

    private final void KClassImpl$Data$declaredNonStaticMembers$2() {
        Intent intent = new Intent(getErrorConfigVersion(), RiskChallengeActivity.class);
        intent.putExtras(BundleKt.PlaceComponentResult(TuplesKt.to("KEY_STRATEGY", this.DatabaseTableConfigUtil), TuplesKt.to("KEY_SOURCE", this.KClassImpl$Data$declaredNonStaticMembers$2), TuplesKt.to("KEY_PURPOSE", this.BuiltInFictitiousFunctionClassFactory), TuplesKt.to("KEY_SECURITY_ID", this.getAuthRequestContext), TuplesKt.to("KEY_PHONE_NUMBER", this.MyBillsEntityDataFactory)));
        if (this.BuiltInFictitiousFunctionClassFactory == null) {
            FragmentActivity fragmentActivity = this.getAuthRequestContext;
            this.BuiltInFictitiousFunctionClassFactory = fragmentActivity != null ? fragmentActivity.registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new ActivityResultCallback() { // from class: id.dana.riskChallenges.ui.passkey.launcher.authentication.AuthenticationPasskeyLauncher$$ExternalSyntheticLambda0
                @Override // androidx.view.result.ActivityResultCallback
                public final void onActivityResult(Object obj) {
                    AuthenticationPasskeyLauncher.MyBillsEntityDataFactory(AuthenticationPasskeyLauncher.this, (ActivityResult) obj);
                }
            }) : null;
        }
        ActivityResultLauncher<Intent> activityResultLauncher = this.BuiltInFictitiousFunctionClassFactory;
        if (activityResultLauncher != null) {
            activityResultLauncher.MyBillsEntityDataFactory(intent, null);
        }
    }

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0011\b\u0016\u0012\u0006\u0010\u000b\u001a\u00020\n¢\u0006\u0004\b\f\u0010\rR\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00038\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0004\u0010\u0005R\u0018\u0010\u0007\u001a\u0004\u0018\u00010\u00038\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0007\u0010\u0005R\u0018\u0010\b\u001a\u0004\u0018\u00010\u00038\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\b\u0010\u0005R\u0018\u0010\t\u001a\u0004\u0018\u00010\u00038\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0006\u0010\u0005"}, d2 = {"Lid/dana/riskChallenges/ui/passkey/launcher/authentication/AuthenticationPasskeyLauncher$Builder;", "Lid/dana/riskChallenges/ui/util/strategy/BaseLauncher$BaseBuilder;", "Lid/dana/riskChallenges/ui/passkey/launcher/authentication/AuthenticationPasskeyLauncher;", "", "PlaceComponentResult", "Ljava/lang/String;", "getAuthRequestContext", "KClassImpl$Data$declaredNonStaticMembers$2", "MyBillsEntityDataFactory", "BuiltInFictitiousFunctionClassFactory", "Landroidx/fragment/app/FragmentActivity;", "p0", "<init>", "(Landroidx/fragment/app/FragmentActivity;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class Builder extends BaseLauncher.BaseBuilder<AuthenticationPasskeyLauncher> {
        public String KClassImpl$Data$declaredNonStaticMembers$2;
        public String MyBillsEntityDataFactory;

        /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
        public String getAuthRequestContext;

        /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
        public String BuiltInFictitiousFunctionClassFactory;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Builder(FragmentActivity fragmentActivity) {
            super(fragmentActivity);
            Intrinsics.checkNotNullParameter(fragmentActivity, "");
        }

        @Override // id.dana.riskChallenges.ui.util.strategy.BaseLauncher.BaseBuilder
        public final /* synthetic */ AuthenticationPasskeyLauncher KClassImpl$Data$declaredNonStaticMembers$2() {
            AuthenticationPasskeyLauncher authenticationPasskeyLauncher = new AuthenticationPasskeyLauncher();
            authenticationPasskeyLauncher.NetworkUserEntityData$$ExternalSyntheticLambda0 = getNetworkUserEntityData$$ExternalSyntheticLambda0();
            authenticationPasskeyLauncher.getAuthRequestContext = getBuiltInFictitiousFunctionClassFactory();
            authenticationPasskeyLauncher.KClassImpl$Data$declaredNonStaticMembers$2 = this.BuiltInFictitiousFunctionClassFactory;
            authenticationPasskeyLauncher.BuiltInFictitiousFunctionClassFactory = this.MyBillsEntityDataFactory;
            authenticationPasskeyLauncher.MyBillsEntityDataFactory = this.getAuthRequestContext;
            authenticationPasskeyLauncher.getAuthRequestContext = this.KClassImpl$Data$declaredNonStaticMembers$2;
            Function1<? super Bundle, Unit> function1 = this.getErrorConfigVersion;
            Function1<? super Bundle, Unit> function12 = this.PlaceComponentResult;
            Function0<Unit> function0 = this.KClassImpl$Data$declaredNonStaticMembers$2;
            authenticationPasskeyLauncher.GetContactSyncConfig = function1;
            authenticationPasskeyLauncher.moveToNextValue = function12;
            authenticationPasskeyLauncher.MyBillsEntityDataFactory = function0;
            authenticationPasskeyLauncher.DatabaseTableConfigUtil = StrategyKey.PASSKEY_AUTHENTICATION;
            return authenticationPasskeyLauncher;
        }
    }

    public static /* synthetic */ void MyBillsEntityDataFactory(AuthenticationPasskeyLauncher authenticationPasskeyLauncher, ActivityResult activityResult) {
        Intrinsics.checkNotNullParameter(authenticationPasskeyLauncher, "");
        Intrinsics.checkNotNullParameter(activityResult, "");
        authenticationPasskeyLauncher.getAuthRequestContext(activityResult.BuiltInFictitiousFunctionClassFactory, activityResult.MyBillsEntityDataFactory);
    }
}
