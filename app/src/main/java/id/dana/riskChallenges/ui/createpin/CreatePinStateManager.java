package id.dana.riskChallenges.ui.createpin;

import android.content.Intent;
import android.os.Bundle;
import androidx.core.os.BundleKt;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentResultListener;
import id.dana.riskChallenges.ui.createpin.CreatePinStateManager;
import id.dana.riskChallenges.ui.resetpin.ResetPinChallengeStrategy;
import id.dana.riskChallenges.ui.resetpin.model.UseCaseStrategy;
import id.dana.riskChallenges.ui.util.statemanager.ChallengeState;
import id.dana.riskChallenges.ui.util.statemanager.ChangeStateListener;
import id.dana.riskChallenges.ui.util.uicomponent.UiComponent;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmName;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002:\u0001'BA\u0012\u0006\u0010\u0005\u001a\u00020\u000b\u0012\u0006\u0010\u0007\u001a\u00020\u0004\u0012\u0006\u0010 \u001a\u00020\u0004\u0012\u0006\u0010!\u001a\u00020\u0004\u0012\u0006\u0010\"\u001a\u00020\u0015\u0012\b\u0010#\u001a\u0004\u0018\u00010\u001c\u0012\u0006\u0010$\u001a\u00020\u0004¢\u0006\u0004\b%\u0010&J\u001f\u0010\t\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\t\u0010\nR\u0014\u0010\u000e\u001a\u00020\u000b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\f\u0010\rR\u0016\u0010\u0012\u001a\u00020\u000f8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u0014\u0010\u0014\u001a\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\u0013R\u0014\u0010\f\u001a\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0014\u0010\u0013R\u0014\u0010\u0010\u001a\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u0014\u0010\u0018\u001a\u00020\u00158\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u0014\u0010\u0016\u001a\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0018\u0010\u0013R(\u0010\u0019\u001a\u0004\u0018\u00010\u00032\b\u0010\u0005\u001a\u0004\u0018\u00010\u00038\u0002@CX\u0082\u000e¢\u0006\f\n\u0004\b\u0019\u0010\u001a\"\u0004\b\u0012\u0010\u001bR\u0016\u0010\u001f\u001a\u0004\u0018\u00010\u001c8\u0002X\u0083\u0004¢\u0006\u0006\n\u0004\b\u001d\u0010\u001e"}, d2 = {"Lid/dana/riskChallenges/ui/createpin/CreatePinStateManager;", "Lid/dana/riskChallenges/ui/util/statemanager/ChallengeState;", "Lid/dana/riskChallenges/ui/util/statemanager/ChangeStateListener;", "Lid/dana/riskChallenges/ui/createpin/CreatePinStateManager$CreatePinState;", "", "p0", "Landroid/os/Bundle;", "p1", "", "onFragmentResult", "(Ljava/lang/String;Landroid/os/Bundle;)V", "Landroidx/fragment/app/FragmentActivity;", "getAuthRequestContext", "Landroidx/fragment/app/FragmentActivity;", "KClassImpl$Data$declaredNonStaticMembers$2", "Landroidx/fragment/app/FragmentResultListener;", "PlaceComponentResult", "Landroidx/fragment/app/FragmentResultListener;", "BuiltInFictitiousFunctionClassFactory", "Ljava/lang/String;", "MyBillsEntityDataFactory", "Lid/dana/riskChallenges/ui/resetpin/model/UseCaseStrategy;", "NetworkUserEntityData$$ExternalSyntheticLambda0", "Lid/dana/riskChallenges/ui/resetpin/model/UseCaseStrategy;", "getErrorConfigVersion", "scheduleImpl", "Lid/dana/riskChallenges/ui/createpin/CreatePinStateManager$CreatePinState;", "(Lid/dana/riskChallenges/ui/createpin/CreatePinStateManager$CreatePinState;)V", "Lid/dana/riskChallenges/ui/util/uicomponent/UiComponent;", "lookAheadTest", "Lid/dana/riskChallenges/ui/util/uicomponent/UiComponent;", "moveToNextValue", "p2", "p3", "p4", "p5", "p6", "<init>", "(Landroidx/fragment/app/FragmentActivity;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lid/dana/riskChallenges/ui/resetpin/model/UseCaseStrategy;Lid/dana/riskChallenges/ui/util/uicomponent/UiComponent;Ljava/lang/String;)V", "CreatePinState"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class CreatePinStateManager implements ChallengeState, ChangeStateListener<CreatePinState> {

    /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
    private final String PlaceComponentResult;

    /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
    private final String MyBillsEntityDataFactory;

    /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
    private final String getAuthRequestContext;

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda0  reason: from kotlin metadata */
    private final UseCaseStrategy getErrorConfigVersion;

    /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
    private FragmentResultListener BuiltInFictitiousFunctionClassFactory;

    /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
    private final FragmentActivity KClassImpl$Data$declaredNonStaticMembers$2;

    /* renamed from: getErrorConfigVersion  reason: from kotlin metadata */
    private final String NetworkUserEntityData$$ExternalSyntheticLambda0;

    /* renamed from: lookAheadTest  reason: from kotlin metadata */
    private final UiComponent moveToNextValue;
    private CreatePinState scheduleImpl;

    public CreatePinStateManager(FragmentActivity fragmentActivity, String str, String str2, String str3, UseCaseStrategy useCaseStrategy, UiComponent uiComponent, String str4) {
        Intrinsics.checkNotNullParameter(fragmentActivity, "");
        Intrinsics.checkNotNullParameter(str, "");
        Intrinsics.checkNotNullParameter(str2, "");
        Intrinsics.checkNotNullParameter(str3, "");
        Intrinsics.checkNotNullParameter(useCaseStrategy, "");
        Intrinsics.checkNotNullParameter(str4, "");
        this.KClassImpl$Data$declaredNonStaticMembers$2 = fragmentActivity;
        this.MyBillsEntityDataFactory = str;
        this.getAuthRequestContext = str2;
        this.PlaceComponentResult = str3;
        this.getErrorConfigVersion = useCaseStrategy;
        this.moveToNextValue = uiComponent;
        this.NetworkUserEntityData$$ExternalSyntheticLambda0 = str4;
        CreatePinState.CreatePin createPin = CreatePinState.CreatePin.INSTANCE;
        Intrinsics.checkNotNullParameter(createPin, "");
        BuiltInFictitiousFunctionClassFactory(createPin);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @JvmName(name = "BuiltInFictitiousFunctionClassFactory")
    public final void BuiltInFictitiousFunctionClassFactory(CreatePinState createPinState) {
        this.scheduleImpl = createPinState;
        if (!(createPinState instanceof CreatePinState.CreatePin)) {
            if (!(createPinState instanceof CreatePinState.Failed)) {
                if (!(createPinState instanceof CreatePinState.Canceled)) {
                    if (createPinState instanceof CreatePinState.Success) {
                        Intrinsics.checkNotNullParameter(BundleKt.BuiltInFictitiousFunctionClassFactory(), "");
                        this.KClassImpl$Data$declaredNonStaticMembers$2.setResult(-1);
                        this.KClassImpl$Data$declaredNonStaticMembers$2.finish();
                        return;
                    }
                    return;
                }
                this.KClassImpl$Data$declaredNonStaticMembers$2.setResult(0);
                this.KClassImpl$Data$declaredNonStaticMembers$2.finish();
                return;
            }
            Bundle bundle = ((CreatePinState.Failed) createPinState).PlaceComponentResult;
            Intrinsics.checkNotNullParameter(bundle, "");
            Intent intent = new Intent();
            intent.putExtras(bundle);
            this.KClassImpl$Data$declaredNonStaticMembers$2.setResult(0, intent);
            this.KClassImpl$Data$declaredNonStaticMembers$2.finish();
            return;
        }
        ResetPinChallengeStrategy resetPinChallengeStrategy = new ResetPinChallengeStrategy(this.KClassImpl$Data$declaredNonStaticMembers$2, this.MyBillsEntityDataFactory, this.getAuthRequestContext, this.PlaceComponentResult, this.getErrorConfigVersion.getAuthRequestContext, this.moveToNextValue, this.NetworkUserEntityData$$ExternalSyntheticLambda0);
        Function1<Bundle, Unit> function1 = new Function1<Bundle, Unit>() { // from class: id.dana.riskChallenges.ui.createpin.CreatePinStateManager$execute$1
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
                CreatePinStateManager createPinStateManager = CreatePinStateManager.this;
                CreatePinStateManager.CreatePinState.Success success = CreatePinStateManager.CreatePinState.Success.INSTANCE;
                Intrinsics.checkNotNullParameter(success, "");
                createPinStateManager.BuiltInFictitiousFunctionClassFactory(success);
            }
        };
        Function1<Bundle, Unit> function12 = new Function1<Bundle, Unit>() { // from class: id.dana.riskChallenges.ui.createpin.CreatePinStateManager$execute$2
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
                CreatePinStateManager createPinStateManager = CreatePinStateManager.this;
                CreatePinStateManager.CreatePinState.Failed failed = new CreatePinStateManager.CreatePinState.Failed(bundle2);
                Intrinsics.checkNotNullParameter(failed, "");
                createPinStateManager.BuiltInFictitiousFunctionClassFactory(failed);
            }
        };
        Function0<Unit> function0 = new Function0<Unit>() { // from class: id.dana.riskChallenges.ui.createpin.CreatePinStateManager$execute$3
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
                CreatePinStateManager createPinStateManager = CreatePinStateManager.this;
                CreatePinStateManager.CreatePinState.Canceled canceled = CreatePinStateManager.CreatePinState.Canceled.INSTANCE;
                Intrinsics.checkNotNullParameter(canceled, "");
                createPinStateManager.BuiltInFictitiousFunctionClassFactory(canceled);
            }
        };
        resetPinChallengeStrategy.scheduleImpl = function1;
        resetPinChallengeStrategy.BuiltInFictitiousFunctionClassFactory = function0;
        resetPinChallengeStrategy.getAuthRequestContext = function12;
        this.BuiltInFictitiousFunctionClassFactory = resetPinChallengeStrategy;
        resetPinChallengeStrategy.BuiltInFictitiousFunctionClassFactory();
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

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\b6\u0018\u00002\u00020\u0001:\u0004\u0004\u0005\u0006\u0007B\t\b\u0004¢\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\u0004\b\t\n\u000b"}, d2 = {"Lid/dana/riskChallenges/ui/createpin/CreatePinStateManager$CreatePinState;", "", "<init>", "()V", "Canceled", "CreatePin", "Failed", "Success", "Lid/dana/riskChallenges/ui/createpin/CreatePinStateManager$CreatePinState$Success;", "Lid/dana/riskChallenges/ui/createpin/CreatePinStateManager$CreatePinState$Failed;", "Lid/dana/riskChallenges/ui/createpin/CreatePinStateManager$CreatePinState$Canceled;", "Lid/dana/riskChallenges/ui/createpin/CreatePinStateManager$CreatePinState$CreatePin;"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static abstract class CreatePinState {
        public /* synthetic */ CreatePinState(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private CreatePinState() {
        }

        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lid/dana/riskChallenges/ui/createpin/CreatePinStateManager$CreatePinState$Success;", "Lid/dana/riskChallenges/ui/createpin/CreatePinStateManager$CreatePinState;", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
        /* loaded from: classes5.dex */
        public static final class Success extends CreatePinState {
            public static final Success INSTANCE = new Success();

            private Success() {
                super(null);
            }
        }

        @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\r¢\u0006\u0004\b\u0011\u0010\u0012J\u001a\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002HÖ\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u0010\u0010\b\u001a\u00020\u0007HÖ\u0001¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\u000b\u001a\u00020\nHÖ\u0001¢\u0006\u0004\b\u000b\u0010\fR\u0011\u0010\u0010\u001a\u00020\rX\u0006¢\u0006\u0006\n\u0004\b\u000e\u0010\u000f"}, d2 = {"Lid/dana/riskChallenges/ui/createpin/CreatePinStateManager$CreatePinState$Failed;", "Lid/dana/riskChallenges/ui/createpin/CreatePinStateManager$CreatePinState;", "", "p0", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "", "toString", "()Ljava/lang/String;", "Landroid/os/Bundle;", "KClassImpl$Data$declaredNonStaticMembers$2", "Landroid/os/Bundle;", "PlaceComponentResult", "<init>", "(Landroid/os/Bundle;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
        /* loaded from: classes5.dex */
        public static final /* data */ class Failed extends CreatePinState {

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

        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lid/dana/riskChallenges/ui/createpin/CreatePinStateManager$CreatePinState$Canceled;", "Lid/dana/riskChallenges/ui/createpin/CreatePinStateManager$CreatePinState;", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
        /* loaded from: classes5.dex */
        public static final class Canceled extends CreatePinState {
            public static final Canceled INSTANCE = new Canceled();

            private Canceled() {
                super(null);
            }
        }

        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lid/dana/riskChallenges/ui/createpin/CreatePinStateManager$CreatePinState$CreatePin;", "Lid/dana/riskChallenges/ui/createpin/CreatePinStateManager$CreatePinState;", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
        /* loaded from: classes5.dex */
        public static final class CreatePin extends CreatePinState {
            public static final CreatePin INSTANCE = new CreatePin();

            private CreatePin() {
                super(null);
            }
        }
    }
}
