package id.dana.riskChallenges.ui.passkey.launcher.authentication;

import android.content.Intent;
import android.os.Bundle;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentResultListener;
import id.dana.riskChallenges.ui.passkey.PasskeyRiskChallengeStrategy;
import id.dana.riskChallenges.ui.passkey.launcher.authentication.LoginPasskeyStateManager;
import id.dana.riskChallenges.ui.util.statemanager.ChallengeState;
import id.dana.riskChallenges.ui.util.statemanager.ChangeStateListener;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmName;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0010\u0018\u0000  2\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002:\u0002 !B3\b\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u000b\u0012\u0006\u0010\u0007\u001a\u00020\u0004\u0012\u0006\u0010\u001b\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u001c\u001a\u00020\u0006\u0012\u0006\u0010\u001d\u001a\u00020\u0004¢\u0006\u0004\b\u001e\u0010\u001fJ\u001f\u0010\t\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\t\u0010\nR\u0014\u0010\f\u001a\u00020\u000b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\f\u0010\rR\u0014\u0010\u0010\u001a\u00020\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u0016\u0010\u0014\u001a\u00020\u00118\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u0014\u0010\u0012\u001a\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u0014\u0010\u000e\u001a\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0010\u0010\u0015R\u0014\u0010\u0017\u001a\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0016\u0010\u0015R(\u0010\u0016\u001a\u0004\u0018\u00010\u00032\b\u0010\u0005\u001a\u0004\u0018\u00010\u00038\u0002@CX\u0082\u000e¢\u0006\f\n\u0004\b\u0018\u0010\u0019\"\u0004\b\u0012\u0010\u001a"}, d2 = {"Lid/dana/riskChallenges/ui/passkey/launcher/authentication/LoginPasskeyStateManager;", "Lid/dana/riskChallenges/ui/util/statemanager/ChallengeState;", "Lid/dana/riskChallenges/ui/util/statemanager/ChangeStateListener;", "Lid/dana/riskChallenges/ui/passkey/launcher/authentication/LoginPasskeyStateManager$PasskeyAuthenticationState;", "", "p0", "Landroid/os/Bundle;", "p1", "", "onFragmentResult", "(Ljava/lang/String;Landroid/os/Bundle;)V", "Landroidx/fragment/app/FragmentActivity;", "BuiltInFictitiousFunctionClassFactory", "Landroidx/fragment/app/FragmentActivity;", "PlaceComponentResult", "Landroid/os/Bundle;", "MyBillsEntityDataFactory", "Landroidx/fragment/app/FragmentResultListener;", "KClassImpl$Data$declaredNonStaticMembers$2", "Landroidx/fragment/app/FragmentResultListener;", "getAuthRequestContext", "Ljava/lang/String;", "moveToNextValue", "getErrorConfigVersion", "NetworkUserEntityData$$ExternalSyntheticLambda0", "Lid/dana/riskChallenges/ui/passkey/launcher/authentication/LoginPasskeyStateManager$PasskeyAuthenticationState;", "(Lid/dana/riskChallenges/ui/passkey/launcher/authentication/LoginPasskeyStateManager$PasskeyAuthenticationState;)V", "p2", "p3", "p4", "<init>", "(Landroidx/fragment/app/FragmentActivity;Ljava/lang/String;Ljava/lang/String;Landroid/os/Bundle;Ljava/lang/String;)V", "Companion", "PasskeyAuthenticationState"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class LoginPasskeyStateManager implements ChallengeState, ChangeStateListener<PasskeyAuthenticationState> {

    /* renamed from: Companion  reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final FragmentActivity BuiltInFictitiousFunctionClassFactory;

    /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
    private FragmentResultListener getAuthRequestContext;

    /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
    private final String PlaceComponentResult;

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda0  reason: from kotlin metadata */
    private PasskeyAuthenticationState moveToNextValue;

    /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
    private final Bundle MyBillsEntityDataFactory;

    /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
    private final String KClassImpl$Data$declaredNonStaticMembers$2;

    /* renamed from: moveToNextValue  reason: from kotlin metadata */
    private final String getErrorConfigVersion;

    public /* synthetic */ LoginPasskeyStateManager(FragmentActivity fragmentActivity, String str, String str2, Bundle bundle, String str3, DefaultConstructorMarker defaultConstructorMarker) {
        this(fragmentActivity, str, str2, bundle, str3);
    }

    private LoginPasskeyStateManager(FragmentActivity fragmentActivity, String str, String str2, Bundle bundle, String str3) {
        this.BuiltInFictitiousFunctionClassFactory = fragmentActivity;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = str;
        this.getErrorConfigVersion = str2;
        this.MyBillsEntityDataFactory = bundle;
        this.PlaceComponentResult = str3;
        PasskeyAuthenticationState.Initial initial = PasskeyAuthenticationState.Initial.INSTANCE;
        Intrinsics.checkNotNullParameter(initial, "");
        KClassImpl$Data$declaredNonStaticMembers$2(initial);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @JvmName(name = "KClassImpl$Data$declaredNonStaticMembers$2")
    public final void KClassImpl$Data$declaredNonStaticMembers$2(PasskeyAuthenticationState passkeyAuthenticationState) {
        this.moveToNextValue = passkeyAuthenticationState;
        if (!Intrinsics.areEqual(passkeyAuthenticationState, PasskeyAuthenticationState.Canceled.INSTANCE)) {
            if (!(passkeyAuthenticationState instanceof PasskeyAuthenticationState.Failed)) {
                if (!(passkeyAuthenticationState instanceof PasskeyAuthenticationState.Success)) {
                    if (Intrinsics.areEqual(passkeyAuthenticationState, PasskeyAuthenticationState.Initial.INSTANCE)) {
                        PasskeyRiskChallengeStrategy passkeyRiskChallengeStrategy = new PasskeyRiskChallengeStrategy(this.BuiltInFictitiousFunctionClassFactory, this.KClassImpl$Data$declaredNonStaticMembers$2, this.getErrorConfigVersion, this.PlaceComponentResult, this.MyBillsEntityDataFactory);
                        Function1<Bundle, Unit> function1 = new Function1<Bundle, Unit>() { // from class: id.dana.riskChallenges.ui.passkey.launcher.authentication.LoginPasskeyStateManager$execute$1$1
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
                                LoginPasskeyStateManager loginPasskeyStateManager = LoginPasskeyStateManager.this;
                                LoginPasskeyStateManager.PasskeyAuthenticationState.Success success = new LoginPasskeyStateManager.PasskeyAuthenticationState.Success(bundle);
                                Intrinsics.checkNotNullParameter(success, "");
                                loginPasskeyStateManager.KClassImpl$Data$declaredNonStaticMembers$2(success);
                            }
                        };
                        Function1<Bundle, Unit> function12 = new Function1<Bundle, Unit>() { // from class: id.dana.riskChallenges.ui.passkey.launcher.authentication.LoginPasskeyStateManager$execute$1$2
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
                                LoginPasskeyStateManager loginPasskeyStateManager = LoginPasskeyStateManager.this;
                                LoginPasskeyStateManager.PasskeyAuthenticationState.Failed failed = new LoginPasskeyStateManager.PasskeyAuthenticationState.Failed(bundle);
                                Intrinsics.checkNotNullParameter(failed, "");
                                loginPasskeyStateManager.KClassImpl$Data$declaredNonStaticMembers$2(failed);
                            }
                        };
                        Function0<Unit> function0 = new Function0<Unit>() { // from class: id.dana.riskChallenges.ui.passkey.launcher.authentication.LoginPasskeyStateManager$execute$1$3
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
                                LoginPasskeyStateManager loginPasskeyStateManager = LoginPasskeyStateManager.this;
                                LoginPasskeyStateManager.PasskeyAuthenticationState.Canceled canceled = LoginPasskeyStateManager.PasskeyAuthenticationState.Canceled.INSTANCE;
                                Intrinsics.checkNotNullParameter(canceled, "");
                                loginPasskeyStateManager.KClassImpl$Data$declaredNonStaticMembers$2(canceled);
                            }
                        };
                        passkeyRiskChallengeStrategy.moveToNextValue = function1;
                        passkeyRiskChallengeStrategy.BuiltInFictitiousFunctionClassFactory = function12;
                        passkeyRiskChallengeStrategy.KClassImpl$Data$declaredNonStaticMembers$2 = function0;
                        passkeyRiskChallengeStrategy.BuiltInFictitiousFunctionClassFactory();
                        this.getAuthRequestContext = passkeyRiskChallengeStrategy;
                        return;
                    }
                    return;
                }
                Bundle bundle = ((PasskeyAuthenticationState.Success) passkeyAuthenticationState).PlaceComponentResult;
                Intrinsics.checkNotNullParameter(bundle, "");
                FragmentActivity fragmentActivity = this.BuiltInFictitiousFunctionClassFactory;
                Intent intent = new Intent();
                intent.putExtras(bundle);
                Unit unit = Unit.INSTANCE;
                fragmentActivity.setResult(-1, intent);
                this.BuiltInFictitiousFunctionClassFactory.finish();
                return;
            }
            Bundle bundle2 = ((PasskeyAuthenticationState.Failed) passkeyAuthenticationState).KClassImpl$Data$declaredNonStaticMembers$2;
            Intrinsics.checkNotNullParameter(bundle2, "");
            Intent intent2 = new Intent();
            intent2.putExtras(bundle2);
            this.BuiltInFictitiousFunctionClassFactory.setResult(0, intent2);
            this.BuiltInFictitiousFunctionClassFactory.finish();
            return;
        }
        this.BuiltInFictitiousFunctionClassFactory.setResult(0);
        this.BuiltInFictitiousFunctionClassFactory.finish();
    }

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\b6\u0018\u00002\u00020\u0001:\u0004\u0004\u0005\u0006\u0007B\t\b\u0004¢\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\u0004\b\t\n\u000b"}, d2 = {"Lid/dana/riskChallenges/ui/passkey/launcher/authentication/LoginPasskeyStateManager$PasskeyAuthenticationState;", "", "<init>", "()V", "Canceled", "Failed", "Initial", "Success", "Lid/dana/riskChallenges/ui/passkey/launcher/authentication/LoginPasskeyStateManager$PasskeyAuthenticationState$Initial;", "Lid/dana/riskChallenges/ui/passkey/launcher/authentication/LoginPasskeyStateManager$PasskeyAuthenticationState$Success;", "Lid/dana/riskChallenges/ui/passkey/launcher/authentication/LoginPasskeyStateManager$PasskeyAuthenticationState$Canceled;", "Lid/dana/riskChallenges/ui/passkey/launcher/authentication/LoginPasskeyStateManager$PasskeyAuthenticationState$Failed;"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static abstract class PasskeyAuthenticationState {
        public /* synthetic */ PasskeyAuthenticationState(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lid/dana/riskChallenges/ui/passkey/launcher/authentication/LoginPasskeyStateManager$PasskeyAuthenticationState$Initial;", "Lid/dana/riskChallenges/ui/passkey/launcher/authentication/LoginPasskeyStateManager$PasskeyAuthenticationState;", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
        /* loaded from: classes5.dex */
        public static final class Initial extends PasskeyAuthenticationState {
            public static final Initial INSTANCE = new Initial();

            private Initial() {
                super(null);
            }
        }

        private PasskeyAuthenticationState() {
        }

        @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\r¢\u0006\u0004\b\u0011\u0010\u0012J\u001a\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002HÖ\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u0010\u0010\b\u001a\u00020\u0007HÖ\u0001¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\u000b\u001a\u00020\nHÖ\u0001¢\u0006\u0004\b\u000b\u0010\fR\u0011\u0010\u0010\u001a\u00020\rX\u0006¢\u0006\u0006\n\u0004\b\u000e\u0010\u000f"}, d2 = {"Lid/dana/riskChallenges/ui/passkey/launcher/authentication/LoginPasskeyStateManager$PasskeyAuthenticationState$Success;", "Lid/dana/riskChallenges/ui/passkey/launcher/authentication/LoginPasskeyStateManager$PasskeyAuthenticationState;", "", "p0", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "", "toString", "()Ljava/lang/String;", "Landroid/os/Bundle;", "BuiltInFictitiousFunctionClassFactory", "Landroid/os/Bundle;", "PlaceComponentResult", "<init>", "(Landroid/os/Bundle;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
        /* loaded from: classes5.dex */
        public static final /* data */ class Success extends PasskeyAuthenticationState {

            /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
            final Bundle PlaceComponentResult;

            public final boolean equals(Object p0) {
                if (this == p0) {
                    return true;
                }
                return (p0 instanceof Success) && Intrinsics.areEqual(this.PlaceComponentResult, ((Success) p0).PlaceComponentResult);
            }

            public final int hashCode() {
                return this.PlaceComponentResult.hashCode();
            }

            public final String toString() {
                StringBuilder sb = new StringBuilder();
                sb.append("Success(PlaceComponentResult=");
                sb.append(this.PlaceComponentResult);
                sb.append(')');
                return sb.toString();
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public Success(Bundle bundle) {
                super(null);
                Intrinsics.checkNotNullParameter(bundle, "");
                this.PlaceComponentResult = bundle;
            }
        }

        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lid/dana/riskChallenges/ui/passkey/launcher/authentication/LoginPasskeyStateManager$PasskeyAuthenticationState$Canceled;", "Lid/dana/riskChallenges/ui/passkey/launcher/authentication/LoginPasskeyStateManager$PasskeyAuthenticationState;", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
        /* loaded from: classes5.dex */
        public static final class Canceled extends PasskeyAuthenticationState {
            public static final Canceled INSTANCE = new Canceled();

            private Canceled() {
                super(null);
            }
        }

        @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\r¢\u0006\u0004\b\u0011\u0010\u0012J\u001a\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002HÖ\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u0010\u0010\b\u001a\u00020\u0007HÖ\u0001¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\u000b\u001a\u00020\nHÖ\u0001¢\u0006\u0004\b\u000b\u0010\fR\u0011\u0010\u0010\u001a\u00020\rX\u0006¢\u0006\u0006\n\u0004\b\u000e\u0010\u000f"}, d2 = {"Lid/dana/riskChallenges/ui/passkey/launcher/authentication/LoginPasskeyStateManager$PasskeyAuthenticationState$Failed;", "Lid/dana/riskChallenges/ui/passkey/launcher/authentication/LoginPasskeyStateManager$PasskeyAuthenticationState;", "", "p0", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "", "toString", "()Ljava/lang/String;", "Landroid/os/Bundle;", "MyBillsEntityDataFactory", "Landroid/os/Bundle;", "KClassImpl$Data$declaredNonStaticMembers$2", "<init>", "(Landroid/os/Bundle;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
        /* loaded from: classes5.dex */
        public static final /* data */ class Failed extends PasskeyAuthenticationState {

            /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
            final Bundle KClassImpl$Data$declaredNonStaticMembers$2;

            public final boolean equals(Object p0) {
                if (this == p0) {
                    return true;
                }
                return (p0 instanceof Failed) && Intrinsics.areEqual(this.KClassImpl$Data$declaredNonStaticMembers$2, ((Failed) p0).KClassImpl$Data$declaredNonStaticMembers$2);
            }

            public final int hashCode() {
                return this.KClassImpl$Data$declaredNonStaticMembers$2.hashCode();
            }

            public final String toString() {
                StringBuilder sb = new StringBuilder();
                sb.append("Failed(KClassImpl$Data$declaredNonStaticMembers$2=");
                sb.append(this.KClassImpl$Data$declaredNonStaticMembers$2);
                sb.append(')');
                return sb.toString();
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public Failed(Bundle bundle) {
                super(null);
                Intrinsics.checkNotNullParameter(bundle, "");
                this.KClassImpl$Data$declaredNonStaticMembers$2 = bundle;
            }
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

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\t\u0010\nJ\u001d\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\b"}, d2 = {"Lid/dana/riskChallenges/ui/passkey/launcher/authentication/LoginPasskeyStateManager$Companion;", "", "Landroidx/fragment/app/FragmentActivity;", "p0", "Landroid/os/Bundle;", "p1", "Lid/dana/riskChallenges/ui/passkey/launcher/authentication/LoginPasskeyStateManager;", "getAuthRequestContext", "(Landroidx/fragment/app/FragmentActivity;Landroid/os/Bundle;)Lid/dana/riskChallenges/ui/passkey/launcher/authentication/LoginPasskeyStateManager;", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public static LoginPasskeyStateManager getAuthRequestContext(FragmentActivity p0, Bundle p1) {
            Intrinsics.checkNotNullParameter(p0, "");
            Intrinsics.checkNotNullParameter(p1, "");
            String string = p1.getString("KEY_SOURCE");
            String str = string == null ? "" : string;
            String string2 = p1.getString("KEY_STRATEGY");
            String str2 = string2 == null ? "" : string2;
            String string3 = p1.getString("KEY_PURPOSE");
            return new LoginPasskeyStateManager(p0, str2, str, p1, string3 == null ? "" : string3, null);
        }
    }
}
