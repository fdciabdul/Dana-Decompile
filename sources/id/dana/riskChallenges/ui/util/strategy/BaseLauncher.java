package id.dana.riskChallenges.ui.util.strategy;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import androidx.core.os.BundleKt;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.view.DefaultLifecycleObserver;
import androidx.view.LifecycleOwner;
import androidx.view.result.ActivityResult;
import androidx.view.result.ActivityResultCallback;
import androidx.view.result.ActivityResultLauncher;
import androidx.view.result.contract.ActivityResultContracts;
import com.alibaba.griver.core.ui.activity.GriverBaseActivity;
import id.dana.riskChallenges.ui.util.OnActivityResultCallback;
import id.dana.riskChallenges.ui.util.bridge.BaseRiskChallengeBridge;
import id.dana.riskChallenges.ui.util.uicomponent.UiComponent;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmName;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u008a\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\b&\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003:\u0001>B\u0007¢\u0006\u0004\b=\u0010\u0006J\u000f\u0010\u0005\u001a\u00020\u0004H\u0014¢\u0006\u0004\b\u0005\u0010\u0006J!\u0010\u000b\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00072\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u0017\u0010\u000e\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\rH\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ\u0017\u0010\u0010\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\rH\u0016¢\u0006\u0004\b\u0010\u0010\u000fJ]\u0010\u0018\u001a\u00020\u00042\u001a\u0010\b\u001a\u0016\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0011j\u0004\u0018\u0001`\u00132\u001a\u0010\n\u001a\u0016\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0011j\u0004\u0018\u0001`\u00142\u0014\u0010\u0017\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0015j\u0004\u0018\u0001`\u0016H\u0016¢\u0006\u0004\b\u0018\u0010\u0019R\u0014\u0010\u000b\u001a\u0004\u0018\u00010\u001aX\u0080\u0002¢\u0006\u0006\n\u0004\b\u001b\u0010\u001cR\u001a\u0010\u0018\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\u001dX\u0080\u0002¢\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u0016\u0010\u0005\u001a\u0004\u0018\u00010 8EX\u0084\u0004¢\u0006\u0006\u001a\u0004\b!\u0010\"R\u0014\u0010&\u001a\u0004\u0018\u00010#X\u0081\u0002¢\u0006\u0006\n\u0004\b$\u0010%R \u0010!\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0015j\u0004\u0018\u0001`\u0016X\u0081\u0002¢\u0006\u0006\n\u0004\b'\u0010(R\u0016\u0010\u001b\u001a\u0004\u0018\u00010 8EX\u0084\u0004¢\u0006\u0006\u001a\u0004\b)\u0010\"R\u0018\u0010)\u001a\b\u0012\u0004\u0012\u00020\u00040\u0015X\u0081\u0002¢\u0006\u0006\n\u0004\b*\u0010(R&\u0010-\u001a\u0016\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0011j\u0004\u0018\u0001`\u0014X\u0081\u0002¢\u0006\u0006\n\u0004\b+\u0010,R\u0014\u00101\u001a\u0004\u0018\u00010.X\u0081\u0002¢\u0006\u0006\n\u0004\b/\u00100R\u0014\u00105\u001a\u0004\u0018\u000102X\u0081\u0002¢\u0006\u0006\n\u0004\b3\u00104R\u0014\u0010\u001e\u001a\u0004\u0018\u000106X\u0081\u0002¢\u0006\u0006\n\u0004\b7\u00108R&\u0010+\u001a\u0016\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0011j\u0004\u0018\u0001`\u0013X\u0081\u0002¢\u0006\u0006\n\u0004\b9\u0010,R\u0014\u0010$\u001a\u0004\u0018\u00010:X\u0081\u0002¢\u0006\u0006\n\u0004\b;\u0010<"}, d2 = {"Lid/dana/riskChallenges/ui/util/strategy/BaseLauncher;", "Lid/dana/riskChallenges/ui/util/strategy/RiskChallengeStrategy;", "Landroidx/lifecycle/DefaultLifecycleObserver;", "Lid/dana/riskChallenges/ui/util/OnActivityResultCallback;", "", "PlaceComponentResult", "()V", "", "p0", "Landroid/content/Intent;", "p1", "getAuthRequestContext", "(ILandroid/content/Intent;)V", "Landroidx/lifecycle/LifecycleOwner;", "onCreate", "(Landroidx/lifecycle/LifecycleOwner;)V", "onDestroy", "Lkotlin/Function1;", "Landroid/os/Bundle;", "Lid/dana/riskChallenges/ui/util/strategy/SuccessListener;", "Lid/dana/riskChallenges/ui/util/strategy/ErrorListener;", "Lkotlin/Function0;", "Lid/dana/riskChallenges/ui/util/strategy/CancelListener;", "p2", "BuiltInFictitiousFunctionClassFactory", "(Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function0;)V", "Landroidx/fragment/app/FragmentActivity;", "scheduleImpl", "Landroidx/fragment/app/FragmentActivity;", "Landroidx/activity/result/ActivityResultLauncher;", "DatabaseTableConfigUtil", "Landroidx/activity/result/ActivityResultLauncher;", "Landroid/content/Context;", "MyBillsEntityDataFactory", "()Landroid/content/Context;", "Lid/dana/riskChallenges/ui/util/bridge/BaseRiskChallengeBridge;", "NetworkUserEntityData$$ExternalSyntheticLambda2", "Lid/dana/riskChallenges/ui/util/bridge/BaseRiskChallengeBridge;", "KClassImpl$Data$declaredNonStaticMembers$2", "NetworkUserEntityData$$ExternalSyntheticLambda1", "Lkotlin/jvm/functions/Function0;", "getErrorConfigVersion", "initRecordTimeStamp", "GetContactSyncConfig", "Lkotlin/jvm/functions/Function1;", "moveToNextValue", "Landroidx/fragment/app/Fragment;", "NetworkUserEntityData$$ExternalSyntheticLambda8", "Landroidx/fragment/app/Fragment;", "NetworkUserEntityData$$ExternalSyntheticLambda0", "Lcom/alibaba/griver/core/ui/activity/GriverBaseActivity;", "newProxyInstance", "Lcom/alibaba/griver/core/ui/activity/GriverBaseActivity;", "lookAheadTest", "", "NetworkUserEntityData$$ExternalSyntheticLambda7", "Ljava/lang/String;", "PrepareContext", "Lid/dana/riskChallenges/ui/util/uicomponent/UiComponent;", "isLayoutRequested", "Lid/dana/riskChallenges/ui/util/uicomponent/UiComponent;", "<init>", "BaseBuilder"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes3.dex */
public abstract class BaseLauncher implements RiskChallengeStrategy, DefaultLifecycleObserver, OnActivityResultCallback {

    /* renamed from: DatabaseTableConfigUtil  reason: from kotlin metadata */
    public ActivityResultLauncher<Intent> BuiltInFictitiousFunctionClassFactory;

    /* renamed from: GetContactSyncConfig  reason: from kotlin metadata */
    public Function1<? super Bundle, Unit> moveToNextValue;

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda1  reason: from kotlin metadata */
    public Function0<Unit> MyBillsEntityDataFactory;

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda2  reason: from kotlin metadata */
    public BaseRiskChallengeBridge KClassImpl$Data$declaredNonStaticMembers$2;

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda7  reason: from kotlin metadata */
    public String DatabaseTableConfigUtil;

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda8  reason: from kotlin metadata */
    public Fragment NetworkUserEntityData$$ExternalSyntheticLambda0;

    /* renamed from: PrepareContext  reason: from kotlin metadata */
    public Function1<? super Bundle, Unit> GetContactSyncConfig;

    /* renamed from: initRecordTimeStamp  reason: from kotlin metadata */
    public Function0<Unit> getErrorConfigVersion = new Function0<Unit>() { // from class: id.dana.riskChallenges.ui.util.strategy.BaseLauncher$dismissLoadingListener$1
        /* renamed from: invoke  reason: avoid collision after fix types in other method */
        public final void invoke2() {
        }

        @Override // kotlin.jvm.functions.Function0
        public final /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.INSTANCE;
        }
    };

    /* renamed from: isLayoutRequested  reason: from kotlin metadata */
    public UiComponent NetworkUserEntityData$$ExternalSyntheticLambda2;

    /* renamed from: newProxyInstance  reason: from kotlin metadata */
    public GriverBaseActivity lookAheadTest;

    /* renamed from: scheduleImpl  reason: from kotlin metadata */
    public FragmentActivity getAuthRequestContext;

    public void PlaceComponentResult() {
    }

    @Override // androidx.view.FullLifecycleObserver
    public /* synthetic */ void onPause(LifecycleOwner lifecycleOwner) {
        DefaultLifecycleObserver.CC.MyBillsEntityDataFactory();
    }

    @Override // androidx.view.FullLifecycleObserver
    public /* synthetic */ void onResume(LifecycleOwner lifecycleOwner) {
        DefaultLifecycleObserver.CC.BuiltInFictitiousFunctionClassFactory();
    }

    public /* synthetic */ void onStart(LifecycleOwner lifecycleOwner) {
        DefaultLifecycleObserver.CC.PlaceComponentResult();
    }

    @Override // androidx.view.FullLifecycleObserver
    public /* synthetic */ void onStop(LifecycleOwner lifecycleOwner) {
        DefaultLifecycleObserver.CC.scheduleImpl();
    }

    @JvmName(name = "getErrorConfigVersion")
    public final Context getErrorConfigVersion() {
        Fragment fragment = this.NetworkUserEntityData$$ExternalSyntheticLambda0;
        if (fragment != null) {
            return fragment != null ? fragment.getActivity() : null;
        }
        FragmentActivity fragmentActivity = this.getAuthRequestContext;
        if (fragmentActivity != null) {
            return fragmentActivity;
        }
        GriverBaseActivity griverBaseActivity = this.lookAheadTest;
        if (griverBaseActivity != null) {
            return griverBaseActivity;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @JvmName(name = "MyBillsEntityDataFactory")
    public final Context MyBillsEntityDataFactory() {
        FragmentActivity activity;
        Fragment fragment = this.NetworkUserEntityData$$ExternalSyntheticLambda0;
        if (fragment != null) {
            if (fragment == null || (activity = fragment.getActivity()) == null) {
                return null;
            }
            return activity.getApplicationContext();
        }
        FragmentActivity fragmentActivity = this.getAuthRequestContext;
        if (fragmentActivity != null) {
            if (fragmentActivity != null) {
                return fragmentActivity.getApplicationContext();
            }
            return null;
        }
        GriverBaseActivity griverBaseActivity = this.lookAheadTest;
        if (griverBaseActivity == null || griverBaseActivity == null) {
            return null;
        }
        return griverBaseActivity.getApplicationContext();
    }

    @Override // id.dana.riskChallenges.ui.util.strategy.RiskChallengeStrategy
    public final void BuiltInFictitiousFunctionClassFactory(Function1<? super Bundle, Unit> p0, Function1<? super Bundle, Unit> p1, Function0<Unit> p2) {
        this.GetContactSyncConfig = p0;
        this.moveToNextValue = p1;
        this.MyBillsEntityDataFactory = p2;
    }

    public void onCreate(LifecycleOwner p0) {
        BaseRiskChallengeBridge baseRiskChallengeBridge;
        Intrinsics.checkNotNullParameter(p0, "");
        DefaultLifecycleObserver.CC.KClassImpl$Data$declaredNonStaticMembers$2();
        FragmentActivity fragmentActivity = this.getAuthRequestContext;
        if (fragmentActivity != null) {
            this.BuiltInFictitiousFunctionClassFactory = fragmentActivity != null ? fragmentActivity.registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new ActivityResultCallback() { // from class: id.dana.riskChallenges.ui.util.strategy.BaseLauncher$$ExternalSyntheticLambda0
                @Override // androidx.view.result.ActivityResultCallback
                public final void onActivityResult(Object obj) {
                    BaseLauncher.PlaceComponentResult(BaseLauncher.this, (ActivityResult) obj);
                }
            }) : null;
            return;
        }
        Fragment fragment = this.NetworkUserEntityData$$ExternalSyntheticLambda0;
        if (fragment != null) {
            this.BuiltInFictitiousFunctionClassFactory = fragment != null ? fragment.registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new ActivityResultCallback() { // from class: id.dana.riskChallenges.ui.util.strategy.BaseLauncher$$ExternalSyntheticLambda1
                @Override // androidx.view.result.ActivityResultCallback
                public final void onActivityResult(Object obj) {
                    BaseLauncher.MyBillsEntityDataFactory(BaseLauncher.this, (ActivityResult) obj);
                }
            }) : null;
        } else if (this.lookAheadTest == null || (baseRiskChallengeBridge = this.KClassImpl$Data$declaredNonStaticMembers$2) == null || baseRiskChallengeBridge == null) {
        } else {
            baseRiskChallengeBridge.registerForActivityResult(new ActivityResultCallback() { // from class: id.dana.riskChallenges.ui.util.strategy.BaseLauncher$$ExternalSyntheticLambda2
                @Override // androidx.view.result.ActivityResultCallback
                public final void onActivityResult(Object obj) {
                    BaseLauncher.getAuthRequestContext(BaseLauncher.this, (ActivityResult) obj);
                }
            });
        }
    }

    public void getAuthRequestContext(int p0, Intent p1) {
        Bundle extras = p1 != null ? p1.getExtras() : null;
        if (p0 == -1) {
            this.getErrorConfigVersion.invoke();
            Function1<? super Bundle, Unit> function1 = this.GetContactSyncConfig;
            if (function1 != null) {
                if (extras == null) {
                    extras = BundleKt.BuiltInFictitiousFunctionClassFactory();
                }
                function1.invoke(extras);
            }
        } else if (p0 == 0) {
            if (extras != null && extras.getBoolean("KEY_IS_ERROR")) {
                this.getErrorConfigVersion.invoke();
                Function1<? super Bundle, Unit> function12 = this.moveToNextValue;
                if (function12 != null) {
                    function12.invoke(extras);
                    return;
                }
                return;
            }
            this.getErrorConfigVersion.invoke();
            Function0<Unit> function0 = this.MyBillsEntityDataFactory;
            if (function0 != null) {
                function0.invoke();
            }
        }
    }

    public void onDestroy(LifecycleOwner p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        DefaultLifecycleObserver.CC.getAuthRequestContext();
        PlaceComponentResult();
    }

    @Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\b&\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u00012\u00020\u0003B\u0019\b\u0016\u0012\u0006\u0010'\u001a\u00020\u001e\u0012\u0006\u0010(\u001a\u00020\f¢\u0006\u0004\b)\u0010*B\u0011\b\u0016\u0012\u0006\u0010'\u001a\u00020\u0006¢\u0006\u0004\b)\u0010+B\u0011\b\u0016\u0012\u0006\u0010'\u001a\u00020\u001b¢\u0006\u0004\b)\u0010,J\u000f\u0010\u0004\u001a\u00028\u0000H&¢\u0006\u0004\b\u0004\u0010\u0005R\u001c\u0010\u000b\u001a\u0004\u0018\u00010\u00068\u0005X\u0084\u0006¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\t\u0010\nR\u001c\u0010\t\u001a\u0004\u0018\u00010\f8\u0005X\u0085\u0006¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u0007\u0010\u000fR \u0010\u0004\u001a\u0010\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u0010j\u0004\u0018\u0001`\u0012X\u0085\u0002¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u0018\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010X\u0085\u0002¢\u0006\u0006\n\u0004\b\u0015\u0010\u0014R&\u0010\u0007\u001a\u0016\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u0016j\u0004\u0018\u0001`\u0018X\u0085\u0002¢\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u001c\u0010\u0015\u001a\u0004\u0018\u00010\u001b8\u0005X\u0085\u0006¢\u0006\f\n\u0004\b\u000b\u0010\u001c\u001a\u0004\b\r\u0010\u001dR\u001c\u0010\u0013\u001a\u0004\u0018\u00010\u001e8\u0005X\u0085\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u001f\u001a\u0004\b\u0013\u0010 R&\u0010#\u001a\u0016\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u0016j\u0004\u0018\u0001`!X\u0085\u0002¢\u0006\u0006\n\u0004\b\"\u0010\u001aR\u0014\u0010\"\u001a\u0004\u0018\u00010$X\u0085\u0002¢\u0006\u0006\n\u0004\b%\u0010&"}, d2 = {"Lid/dana/riskChallenges/ui/util/strategy/BaseLauncher$BaseBuilder;", "Lid/dana/riskChallenges/ui/util/strategy/BaseLauncher;", "T", "", "KClassImpl$Data$declaredNonStaticMembers$2", "()Lid/dana/riskChallenges/ui/util/strategy/BaseLauncher;", "Landroidx/fragment/app/FragmentActivity;", "PlaceComponentResult", "Landroidx/fragment/app/FragmentActivity;", "getAuthRequestContext", "()Landroidx/fragment/app/FragmentActivity;", "BuiltInFictitiousFunctionClassFactory", "Lid/dana/riskChallenges/ui/util/bridge/BaseRiskChallengeBridge;", "MyBillsEntityDataFactory", "Lid/dana/riskChallenges/ui/util/bridge/BaseRiskChallengeBridge;", "()Lid/dana/riskChallenges/ui/util/bridge/BaseRiskChallengeBridge;", "Lkotlin/Function0;", "", "Lid/dana/riskChallenges/ui/util/strategy/CancelListener;", "moveToNextValue", "Lkotlin/jvm/functions/Function0;", "NetworkUserEntityData$$ExternalSyntheticLambda0", "Lkotlin/Function1;", "Landroid/os/Bundle;", "Lid/dana/riskChallenges/ui/util/strategy/ErrorListener;", "lookAheadTest", "Lkotlin/jvm/functions/Function1;", "Landroidx/fragment/app/Fragment;", "Landroidx/fragment/app/Fragment;", "()Landroidx/fragment/app/Fragment;", "Lcom/alibaba/griver/core/ui/activity/GriverBaseActivity;", "Lcom/alibaba/griver/core/ui/activity/GriverBaseActivity;", "()Lcom/alibaba/griver/core/ui/activity/GriverBaseActivity;", "Lid/dana/riskChallenges/ui/util/strategy/SuccessListener;", "scheduleImpl", "getErrorConfigVersion", "Lid/dana/riskChallenges/ui/util/uicomponent/UiComponent;", "NetworkUserEntityData$$ExternalSyntheticLambda2", "Lid/dana/riskChallenges/ui/util/uicomponent/UiComponent;", "p0", "p1", "<init>", "(Lcom/alibaba/griver/core/ui/activity/GriverBaseActivity;Lid/dana/riskChallenges/ui/util/bridge/BaseRiskChallengeBridge;)V", "(Landroidx/fragment/app/FragmentActivity;)V", "(Landroidx/fragment/app/Fragment;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes3.dex */
    public static abstract class BaseBuilder<T extends BaseLauncher> {

        /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
        private Fragment NetworkUserEntityData$$ExternalSyntheticLambda0;

        /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
        private GriverBaseActivity moveToNextValue;

        /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
        private BaseRiskChallengeBridge getAuthRequestContext;

        /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda0  reason: from kotlin metadata */
        public Function0<Unit> MyBillsEntityDataFactory;

        /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda2  reason: from kotlin metadata */
        public UiComponent scheduleImpl;

        /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
        private FragmentActivity BuiltInFictitiousFunctionClassFactory;

        /* renamed from: lookAheadTest  reason: from kotlin metadata */
        public Function1<? super Bundle, Unit> PlaceComponentResult;

        /* renamed from: moveToNextValue  reason: from kotlin metadata */
        public Function0<Unit> KClassImpl$Data$declaredNonStaticMembers$2;

        /* renamed from: scheduleImpl  reason: from kotlin metadata */
        public Function1<? super Bundle, Unit> getErrorConfigVersion;

        public abstract T KClassImpl$Data$declaredNonStaticMembers$2();

        /* JADX INFO: Access modifiers changed from: protected */
        @JvmName(name = "moveToNextValue")
        /* renamed from: moveToNextValue  reason: from getter */
        public final GriverBaseActivity getMoveToNextValue() {
            return this.moveToNextValue;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @JvmName(name = "PlaceComponentResult")
        /* renamed from: PlaceComponentResult  reason: from getter */
        public final BaseRiskChallengeBridge getGetAuthRequestContext() {
            return this.getAuthRequestContext;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @JvmName(name = "getAuthRequestContext")
        /* renamed from: getAuthRequestContext  reason: from getter */
        public final FragmentActivity getBuiltInFictitiousFunctionClassFactory() {
            return this.BuiltInFictitiousFunctionClassFactory;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @JvmName(name = "MyBillsEntityDataFactory")
        /* renamed from: MyBillsEntityDataFactory  reason: from getter */
        public final Fragment getNetworkUserEntityData$$ExternalSyntheticLambda0() {
            return this.NetworkUserEntityData$$ExternalSyntheticLambda0;
        }

        public BaseBuilder(GriverBaseActivity griverBaseActivity, BaseRiskChallengeBridge baseRiskChallengeBridge) {
            Intrinsics.checkNotNullParameter(griverBaseActivity, "");
            Intrinsics.checkNotNullParameter(baseRiskChallengeBridge, "");
            this.MyBillsEntityDataFactory = BaseLauncher$BaseBuilder$dismissLoadingListener$1.INSTANCE;
            this.moveToNextValue = griverBaseActivity;
            this.getAuthRequestContext = baseRiskChallengeBridge;
        }

        public BaseBuilder(FragmentActivity fragmentActivity) {
            Intrinsics.checkNotNullParameter(fragmentActivity, "");
            this.MyBillsEntityDataFactory = BaseLauncher$BaseBuilder$dismissLoadingListener$1.INSTANCE;
            this.BuiltInFictitiousFunctionClassFactory = fragmentActivity;
        }

        public BaseBuilder(Fragment fragment) {
            Intrinsics.checkNotNullParameter(fragment, "");
            this.MyBillsEntityDataFactory = BaseLauncher$BaseBuilder$dismissLoadingListener$1.INSTANCE;
            this.NetworkUserEntityData$$ExternalSyntheticLambda0 = fragment;
        }
    }

    public static /* synthetic */ void getAuthRequestContext(BaseLauncher baseLauncher, ActivityResult activityResult) {
        Intrinsics.checkNotNullParameter(baseLauncher, "");
        Intrinsics.checkNotNullParameter(activityResult, "");
        baseLauncher.getAuthRequestContext(activityResult.BuiltInFictitiousFunctionClassFactory, activityResult.MyBillsEntityDataFactory);
    }

    public static /* synthetic */ void MyBillsEntityDataFactory(BaseLauncher baseLauncher, ActivityResult activityResult) {
        Intrinsics.checkNotNullParameter(baseLauncher, "");
        Intrinsics.checkNotNullParameter(activityResult, "");
        baseLauncher.getAuthRequestContext(activityResult.BuiltInFictitiousFunctionClassFactory, activityResult.MyBillsEntityDataFactory);
    }

    public static /* synthetic */ void PlaceComponentResult(BaseLauncher baseLauncher, ActivityResult activityResult) {
        Intrinsics.checkNotNullParameter(baseLauncher, "");
        Intrinsics.checkNotNullParameter(activityResult, "");
        baseLauncher.getAuthRequestContext(activityResult.BuiltInFictitiousFunctionClassFactory, activityResult.MyBillsEntityDataFactory);
    }
}
