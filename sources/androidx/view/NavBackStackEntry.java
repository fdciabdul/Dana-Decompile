package androidx.view;

import android.app.Application;
import android.content.Context;
import android.os.Bundle;
import androidx.view.AbstractSavedStateViewModelFactory;
import androidx.view.HasDefaultViewModelProviderFactory;
import androidx.view.Lifecycle;
import androidx.view.LifecycleOwner;
import androidx.view.LifecycleRegistry;
import androidx.view.NavBackStackEntry;
import androidx.view.SavedStateHandle;
import androidx.view.SavedStateHandleSupport;
import androidx.view.SavedStateRegistry;
import androidx.view.SavedStateRegistryController;
import androidx.view.SavedStateRegistryOwner;
import androidx.view.SavedStateViewModelFactory;
import androidx.view.ViewModel;
import androidx.view.ViewModelProvider;
import androidx.view.ViewModelStore;
import androidx.view.ViewModelStoreOwner;
import androidx.view.viewmodel.CreationExtras;
import androidx.view.viewmodel.MutableCreationExtras;
import com.alibaba.ariver.engine.common.track.watchdog.ARiverTrackWatchDogEventConstant;
import com.ap.zoloz.hummer.biz.HummerConstants;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.Iterator;
import java.util.Set;
import java.util.UUID;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000¢\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\r\u0018\u0000 I2\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u0004:\u0003IJKB\u001d\b\u0016\u0012\u0006\u0010\u0006\u001a\u00020\u0000\u0012\n\b\u0002\u0010@\u001a\u0004\u0018\u00010\u001c¢\u0006\u0004\bA\u0010BBS\b\u0002\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010 \u0012\u0006\u0010@\u001a\u00020(\u0012\n\b\u0002\u0010C\u001a\u0004\u0018\u00010\u001c\u0012\b\b\u0002\u0010D\u001a\u00020*\u0012\n\b\u0002\u0010E\u001a\u0004\u0018\u00010>\u0012\b\b\u0002\u0010F\u001a\u00020,\u0012\n\b\u0002\u0010G\u001a\u0004\u0018\u00010\u001c¢\u0006\u0004\bA\u0010HJ\u001a\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0096\u0002¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\u000b\u001a\u00020\nH\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\u000e\u001a\u00020\rH\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ\u000f\u0010\u0011\u001a\u00020\u0010H\u0016¢\u0006\u0004\b\u0011\u0010\u0012J\u000f\u0010\u0014\u001a\u00020\u0013H\u0016¢\u0006\u0004\b\u0014\u0010\u0015J\u000f\u0010\u0017\u001a\u00020\u0016H\u0016¢\u0006\u0004\b\u0017\u0010\u0018J\r\u0010\u001a\u001a\u00020\u0019¢\u0006\u0004\b\u001a\u0010\u001bR\u0013\u0010\u001f\u001a\u0004\u0018\u00010\u001cX\u0007¢\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\u0016\u0010#\u001a\u0004\u0018\u00010 8\u0002X\u0083\u0004¢\u0006\u0006\n\u0004\b!\u0010\"R\u0013\u0010'\u001a\u00020$X\u0083\u0080\u0002¢\u0006\u0006\n\u0004\b%\u0010&R\u0012\u0010\u001d\u001a\u00020(X\u0087\u0002¢\u0006\u0006\n\u0004\b#\u0010)R\u0016\u0010\u001a\u001a\u00020*8\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\b\u001f\u0010+R\u0011\u0010.\u001a\u00020,X\u0007¢\u0006\u0006\n\u0004\b'\u0010-R\u0016\u0010%\u001a\u00020/8\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\b0\u00101R\u0012\u00102\u001a\u00020*X\u0087\u0002¢\u0006\u0006\n\u0004\b\u001a\u0010+R\u0016\u00100\u001a\u0004\u0018\u00010\u001c8\u0002X\u0083\u0004¢\u0006\u0006\n\u0004\b3\u0010\u001eR\u0013\u0010!\u001a\u000204X\u0087\u0080\u0002¢\u0006\u0006\n\u0004\b2\u0010&R\u0014\u00108\u001a\u0002058WX\u0096\u0004¢\u0006\u0006\u001a\u0004\b6\u00107R\u0016\u0010:\u001a\u00020\u00078\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\b8\u00109R\u0014\u0010=\u001a\u00020;8\u0002X\u0083\u0004¢\u0006\u0006\n\u0004\b.\u0010<R\u0016\u00103\u001a\u0004\u0018\u00010>8\u0002X\u0083\u0004¢\u0006\u0006\n\u0004\b=\u0010?"}, d2 = {"Landroidx/navigation/NavBackStackEntry;", "Landroidx/lifecycle/LifecycleOwner;", "Landroidx/lifecycle/ViewModelStoreOwner;", "Landroidx/lifecycle/HasDefaultViewModelProviderFactory;", "Landroidx/savedstate/SavedStateRegistryOwner;", "", "p0", "", "equals", "(Ljava/lang/Object;)Z", "Landroidx/lifecycle/viewmodel/CreationExtras;", "getDefaultViewModelCreationExtras", "()Landroidx/lifecycle/viewmodel/CreationExtras;", "Landroidx/lifecycle/ViewModelProvider$Factory;", "getDefaultViewModelProviderFactory", "()Landroidx/lifecycle/ViewModelProvider$Factory;", "Landroidx/lifecycle/Lifecycle;", "getLifecycle", "()Landroidx/lifecycle/Lifecycle;", "Landroidx/lifecycle/ViewModelStore;", "getViewModelStore", "()Landroidx/lifecycle/ViewModelStore;", "", "hashCode", "()I", "", "BuiltInFictitiousFunctionClassFactory", "()V", "Landroid/os/Bundle;", "KClassImpl$Data$declaredNonStaticMembers$2", "Landroid/os/Bundle;", "getAuthRequestContext", "Landroid/content/Context;", "scheduleImpl", "Landroid/content/Context;", "MyBillsEntityDataFactory", "Landroidx/lifecycle/SavedStateViewModelFactory;", "NetworkUserEntityData$$ExternalSyntheticLambda0", "Lkotlin/Lazy;", "PlaceComponentResult", "Landroidx/navigation/NavDestination;", "Landroidx/navigation/NavDestination;", "Landroidx/lifecycle/Lifecycle$State;", "Landroidx/lifecycle/Lifecycle$State;", "", "Ljava/lang/String;", "getErrorConfigVersion", "Landroidx/lifecycle/LifecycleRegistry;", "lookAheadTest", "Landroidx/lifecycle/LifecycleRegistry;", "moveToNextValue", "GetContactSyncConfig", "Landroidx/lifecycle/SavedStateHandle;", "Landroidx/savedstate/SavedStateRegistry;", "getSavedStateRegistry", "()Landroidx/savedstate/SavedStateRegistry;", "NetworkUserEntityData$$ExternalSyntheticLambda1", "Z", "NetworkUserEntityData$$ExternalSyntheticLambda2", "Landroidx/savedstate/SavedStateRegistryController;", "Landroidx/savedstate/SavedStateRegistryController;", "initRecordTimeStamp", "Landroidx/navigation/NavViewModelStoreProvider;", "Landroidx/navigation/NavViewModelStoreProvider;", "p1", "<init>", "(Landroidx/navigation/NavBackStackEntry;Landroid/os/Bundle;)V", "p2", "p3", "p4", "p5", "p6", "(Landroid/content/Context;Landroidx/navigation/NavDestination;Landroid/os/Bundle;Landroidx/lifecycle/Lifecycle$State;Landroidx/navigation/NavViewModelStoreProvider;Ljava/lang/String;Landroid/os/Bundle;)V", "Companion", "NavResultSavedStateFactory", "SavedStateViewModel"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class NavBackStackEntry implements LifecycleOwner, ViewModelStoreOwner, HasDefaultViewModelProviderFactory, SavedStateRegistryOwner {

    /* renamed from: Companion  reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
    Lifecycle.State moveToNextValue;

    /* renamed from: GetContactSyncConfig  reason: from kotlin metadata */
    private final Bundle lookAheadTest;

    /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
    public final Bundle getAuthRequestContext;

    /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
    public NavDestination KClassImpl$Data$declaredNonStaticMembers$2;

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda0  reason: from kotlin metadata */
    private final Lazy PlaceComponentResult;

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda1  reason: from kotlin metadata */
    private boolean NetworkUserEntityData$$ExternalSyntheticLambda2;

    /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
    public final String getErrorConfigVersion;

    /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
    Lifecycle.State BuiltInFictitiousFunctionClassFactory;

    /* renamed from: getErrorConfigVersion  reason: from kotlin metadata */
    final SavedStateRegistryController initRecordTimeStamp;

    /* renamed from: initRecordTimeStamp  reason: from kotlin metadata */
    private final NavViewModelStoreProvider GetContactSyncConfig;

    /* renamed from: lookAheadTest  reason: from kotlin metadata */
    private LifecycleRegistry NetworkUserEntityData$$ExternalSyntheticLambda0;

    /* renamed from: moveToNextValue  reason: from kotlin metadata */
    public final Lazy scheduleImpl;

    /* renamed from: scheduleImpl  reason: from kotlin metadata */
    private final Context MyBillsEntityDataFactory;

    public /* synthetic */ NavBackStackEntry(Context context, NavDestination navDestination, Bundle bundle, Lifecycle.State state, NavViewModelStoreProvider navViewModelStoreProvider, String str, Bundle bundle2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, navDestination, bundle, state, navViewModelStoreProvider, str, bundle2);
    }

    private NavBackStackEntry(Context context, NavDestination navDestination, Bundle bundle, Lifecycle.State state, NavViewModelStoreProvider navViewModelStoreProvider, String str, Bundle bundle2) {
        this.MyBillsEntityDataFactory = context;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = navDestination;
        this.getAuthRequestContext = bundle;
        this.BuiltInFictitiousFunctionClassFactory = state;
        this.GetContactSyncConfig = navViewModelStoreProvider;
        this.getErrorConfigVersion = str;
        this.lookAheadTest = bundle2;
        this.NetworkUserEntityData$$ExternalSyntheticLambda0 = new LifecycleRegistry(this);
        SavedStateRegistryController.Companion companion = SavedStateRegistryController.INSTANCE;
        this.initRecordTimeStamp = SavedStateRegistryController.Companion.BuiltInFictitiousFunctionClassFactory(this);
        this.PlaceComponentResult = LazyKt.lazy(new Function0<SavedStateViewModelFactory>() { // from class: androidx.navigation.NavBackStackEntry$defaultFactory$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final SavedStateViewModelFactory invoke() {
                Context context2;
                context2 = NavBackStackEntry.this.MyBillsEntityDataFactory;
                Context applicationContext = context2 != null ? context2.getApplicationContext() : null;
                Application application = applicationContext instanceof Application ? (Application) applicationContext : null;
                NavBackStackEntry navBackStackEntry = NavBackStackEntry.this;
                return new SavedStateViewModelFactory(application, navBackStackEntry, navBackStackEntry.getAuthRequestContext);
            }
        });
        this.scheduleImpl = LazyKt.lazy(new Function0<SavedStateHandle>() { // from class: androidx.navigation.NavBackStackEntry$savedStateHandle$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final SavedStateHandle invoke() {
                boolean z;
                LifecycleRegistry lifecycleRegistry;
                z = NavBackStackEntry.this.NetworkUserEntityData$$ExternalSyntheticLambda2;
                if (z) {
                    lifecycleRegistry = NavBackStackEntry.this.NetworkUserEntityData$$ExternalSyntheticLambda0;
                    if (!(lifecycleRegistry.KClassImpl$Data$declaredNonStaticMembers$2 != Lifecycle.State.DESTROYED)) {
                        throw new IllegalStateException("You cannot access the NavBackStackEntry's SavedStateHandle after the NavBackStackEntry is destroyed.".toString());
                    }
                    return ((NavBackStackEntry.SavedStateViewModel) new ViewModelProvider(NavBackStackEntry.this, new NavBackStackEntry.NavResultSavedStateFactory(NavBackStackEntry.this)).MyBillsEntityDataFactory(NavBackStackEntry.SavedStateViewModel.class)).PlaceComponentResult;
                }
                throw new IllegalStateException("You cannot access the NavBackStackEntry's SavedStateHandle until it is added to the NavController's back stack (i.e., the Lifecycle of the NavBackStackEntry reaches the CREATED state).".toString());
            }
        });
        this.moveToNextValue = Lifecycle.State.INITIALIZED;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public NavBackStackEntry(NavBackStackEntry navBackStackEntry, Bundle bundle) {
        this(navBackStackEntry.MyBillsEntityDataFactory, navBackStackEntry.KClassImpl$Data$declaredNonStaticMembers$2, bundle, navBackStackEntry.BuiltInFictitiousFunctionClassFactory, navBackStackEntry.GetContactSyncConfig, navBackStackEntry.getErrorConfigVersion, navBackStackEntry.lookAheadTest);
        Intrinsics.checkNotNullParameter(navBackStackEntry, "");
        this.BuiltInFictitiousFunctionClassFactory = navBackStackEntry.BuiltInFictitiousFunctionClassFactory;
        Lifecycle.State state = navBackStackEntry.moveToNextValue;
        Intrinsics.checkNotNullParameter(state, "");
        this.moveToNextValue = state;
        BuiltInFictitiousFunctionClassFactory();
    }

    @Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0087\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002JR\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0007\u001a\u00020\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n2\b\b\u0002\u0010\u000b\u001a\u00020\f2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u00102\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\nH\u0007¨\u0006\u0012"}, d2 = {"Landroidx/navigation/NavBackStackEntry$Companion;", "", "()V", ARiverTrackWatchDogEventConstant.FLAG_START_UP_CREATE, "Landroidx/navigation/NavBackStackEntry;", HummerConstants.CONTEXT, "Landroid/content/Context;", FirebaseAnalytics.Param.DESTINATION, "Landroidx/navigation/NavDestination;", "arguments", "Landroid/os/Bundle;", "hostLifecycleState", "Landroidx/lifecycle/Lifecycle$State;", "viewModelStoreProvider", "Landroidx/navigation/NavViewModelStoreProvider;", "id", "", "savedState", "navigation-common_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes3.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public static /* synthetic */ NavBackStackEntry KClassImpl$Data$declaredNonStaticMembers$2(Context context, NavDestination navDestination, Bundle bundle, Lifecycle.State state, NavViewModelStoreProvider navViewModelStoreProvider) {
            String obj = UUID.randomUUID().toString();
            Intrinsics.checkNotNullExpressionValue(obj, "");
            return BuiltInFictitiousFunctionClassFactory(context, navDestination, bundle, state, navViewModelStoreProvider, obj, null);
        }

        public static NavBackStackEntry BuiltInFictitiousFunctionClassFactory(Context context, NavDestination navDestination, Bundle bundle, Lifecycle.State state, NavViewModelStoreProvider navViewModelStoreProvider, String str, Bundle bundle2) {
            Intrinsics.checkNotNullParameter(navDestination, "");
            Intrinsics.checkNotNullParameter(state, "");
            Intrinsics.checkNotNullParameter(str, "");
            return new NavBackStackEntry(context, navDestination, bundle, state, navViewModelStoreProvider, str, bundle2, null);
        }
    }

    @Override // androidx.view.LifecycleOwner
    public final Lifecycle getLifecycle() {
        return this.NetworkUserEntityData$$ExternalSyntheticLambda0;
    }

    public final void BuiltInFictitiousFunctionClassFactory() {
        if (!this.NetworkUserEntityData$$ExternalSyntheticLambda2) {
            this.initRecordTimeStamp.getAuthRequestContext();
            this.NetworkUserEntityData$$ExternalSyntheticLambda2 = true;
            if (this.GetContactSyncConfig != null) {
                SavedStateHandleSupport.PlaceComponentResult(this);
            }
            this.initRecordTimeStamp.KClassImpl$Data$declaredNonStaticMembers$2(this.lookAheadTest);
        }
        if (this.BuiltInFictitiousFunctionClassFactory.ordinal() < this.moveToNextValue.ordinal()) {
            LifecycleRegistry lifecycleRegistry = this.NetworkUserEntityData$$ExternalSyntheticLambda0;
            Lifecycle.State state = this.BuiltInFictitiousFunctionClassFactory;
            lifecycleRegistry.PlaceComponentResult("setCurrentState");
            lifecycleRegistry.getAuthRequestContext(state);
            return;
        }
        LifecycleRegistry lifecycleRegistry2 = this.NetworkUserEntityData$$ExternalSyntheticLambda0;
        Lifecycle.State state2 = this.moveToNextValue;
        lifecycleRegistry2.PlaceComponentResult("setCurrentState");
        lifecycleRegistry2.getAuthRequestContext(state2);
    }

    @Override // androidx.view.ViewModelStoreOwner
    public final ViewModelStore getViewModelStore() {
        if (!this.NetworkUserEntityData$$ExternalSyntheticLambda2) {
            throw new IllegalStateException("You cannot access the NavBackStackEntry's ViewModels until it is added to the NavController's back stack (i.e., the Lifecycle of the NavBackStackEntry reaches the CREATED state).".toString());
        }
        if (!(this.NetworkUserEntityData$$ExternalSyntheticLambda0.KClassImpl$Data$declaredNonStaticMembers$2 != Lifecycle.State.DESTROYED)) {
            throw new IllegalStateException("You cannot access the NavBackStackEntry's ViewModels after the NavBackStackEntry is destroyed.".toString());
        }
        NavViewModelStoreProvider navViewModelStoreProvider = this.GetContactSyncConfig;
        if (navViewModelStoreProvider == null) {
            throw new IllegalStateException("You must call setViewModelStore() on your NavHostController before accessing the ViewModelStore of a navigation graph.".toString());
        }
        return navViewModelStoreProvider.KClassImpl$Data$declaredNonStaticMembers$2(this.getErrorConfigVersion);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v0, types: [androidx.lifecycle.viewmodel.CreationExtras, kotlin.jvm.internal.DefaultConstructorMarker] */
    /* JADX WARN: Type inference failed for: r1v1, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r1v7 */
    @Override // androidx.view.HasDefaultViewModelProviderFactory
    public final CreationExtras getDefaultViewModelCreationExtras() {
        MutableCreationExtras mutableCreationExtras = new MutableCreationExtras(r1, 1, r1);
        Context context = this.MyBillsEntityDataFactory;
        Context applicationContext = context != null ? context.getApplicationContext() : null;
        r1 = applicationContext instanceof Application ? (Application) applicationContext : 0;
        if (r1 != 0) {
            CreationExtras.Key<Application> key = ViewModelProvider.AndroidViewModelFactory.KClassImpl$Data$declaredNonStaticMembers$2;
            Intrinsics.checkNotNullParameter(key, "");
            mutableCreationExtras.MyBillsEntityDataFactory.put(key, r1);
        }
        CreationExtras.Key<SavedStateRegistryOwner> key2 = SavedStateHandleSupport.BuiltInFictitiousFunctionClassFactory;
        Intrinsics.checkNotNullParameter(key2, "");
        mutableCreationExtras.MyBillsEntityDataFactory.put(key2, this);
        CreationExtras.Key<ViewModelStoreOwner> key3 = SavedStateHandleSupport.getAuthRequestContext;
        Intrinsics.checkNotNullParameter(key3, "");
        mutableCreationExtras.MyBillsEntityDataFactory.put(key3, this);
        Bundle bundle = this.getAuthRequestContext;
        if (bundle != null) {
            CreationExtras.Key<Bundle> key4 = SavedStateHandleSupport.KClassImpl$Data$declaredNonStaticMembers$2;
            Intrinsics.checkNotNullParameter(key4, "");
            mutableCreationExtras.MyBillsEntityDataFactory.put(key4, bundle);
        }
        return mutableCreationExtras;
    }

    @Override // androidx.view.SavedStateRegistryOwner
    @JvmName(name = "getSavedStateRegistry")
    public final SavedStateRegistry getSavedStateRegistry() {
        return this.initRecordTimeStamp.MyBillsEntityDataFactory;
    }

    /* JADX WARN: Removed duplicated region for block: B:97:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final boolean equals(java.lang.Object r7) {
        /*
            r6 = this;
            r0 = 1
            r1 = 0
            if (r7 == 0) goto L8d
            boolean r2 = r7 instanceof androidx.view.NavBackStackEntry
            if (r2 != 0) goto La
            goto L8d
        La:
            java.lang.String r2 = r6.getErrorConfigVersion
            androidx.navigation.NavBackStackEntry r7 = (androidx.view.NavBackStackEntry) r7
            java.lang.String r3 = r7.getErrorConfigVersion
            boolean r2 = kotlin.jvm.internal.Intrinsics.areEqual(r2, r3)
            if (r2 == 0) goto L8d
            androidx.navigation.NavDestination r2 = r6.KClassImpl$Data$declaredNonStaticMembers$2
            androidx.navigation.NavDestination r3 = r7.KClassImpl$Data$declaredNonStaticMembers$2
            boolean r2 = kotlin.jvm.internal.Intrinsics.areEqual(r2, r3)
            if (r2 == 0) goto L8d
            androidx.lifecycle.LifecycleRegistry r2 = r6.NetworkUserEntityData$$ExternalSyntheticLambda0
            androidx.lifecycle.LifecycleRegistry r3 = r7.NetworkUserEntityData$$ExternalSyntheticLambda0
            boolean r2 = kotlin.jvm.internal.Intrinsics.areEqual(r2, r3)
            if (r2 == 0) goto L8d
            androidx.savedstate.SavedStateRegistry r2 = r6.getSavedStateRegistry()
            androidx.savedstate.SavedStateRegistry r3 = r7.getSavedStateRegistry()
            boolean r2 = kotlin.jvm.internal.Intrinsics.areEqual(r2, r3)
            if (r2 == 0) goto L8d
            android.os.Bundle r2 = r6.getAuthRequestContext
            android.os.Bundle r3 = r7.getAuthRequestContext
            boolean r2 = kotlin.jvm.internal.Intrinsics.areEqual(r2, r3)
            if (r2 != 0) goto L8e
            android.os.Bundle r2 = r6.getAuthRequestContext
            if (r2 == 0) goto L89
            java.util.Set r2 = r2.keySet()
            if (r2 == 0) goto L89
            java.lang.Iterable r2 = (java.lang.Iterable) r2
            boolean r3 = r2 instanceof java.util.Collection
            if (r3 == 0) goto L5c
            r3 = r2
            java.util.Collection r3 = (java.util.Collection) r3
            boolean r3 = r3.isEmpty()
            if (r3 == 0) goto L5c
            goto L84
        L5c:
            java.util.Iterator r2 = r2.iterator()
        L60:
            boolean r3 = r2.hasNext()
            if (r3 == 0) goto L84
            java.lang.Object r3 = r2.next()
            java.lang.String r3 = (java.lang.String) r3
            android.os.Bundle r4 = r6.getAuthRequestContext
            java.lang.Object r4 = r4.get(r3)
            android.os.Bundle r5 = r7.getAuthRequestContext
            if (r5 == 0) goto L7b
            java.lang.Object r3 = r5.get(r3)
            goto L7c
        L7b:
            r3 = 0
        L7c:
            boolean r3 = kotlin.jvm.internal.Intrinsics.areEqual(r4, r3)
            if (r3 != 0) goto L60
            r7 = 0
            goto L85
        L84:
            r7 = 1
        L85:
            if (r7 != r0) goto L89
            r7 = 1
            goto L8a
        L89:
            r7 = 0
        L8a:
            if (r7 == 0) goto L8d
            goto L8e
        L8d:
            r0 = 0
        L8e:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.view.NavBackStackEntry.equals(java.lang.Object):boolean");
    }

    public final int hashCode() {
        Set<String> keySet;
        int hashCode = (this.getErrorConfigVersion.hashCode() * 31) + this.KClassImpl$Data$declaredNonStaticMembers$2.hashCode();
        Bundle bundle = this.getAuthRequestContext;
        if (bundle != null && (keySet = bundle.keySet()) != null) {
            Iterator<T> it = keySet.iterator();
            while (it.hasNext()) {
                Object obj = this.getAuthRequestContext.get((String) it.next());
                hashCode = (hashCode * 31) + (obj != null ? obj.hashCode() : 0);
            }
        }
        return (((hashCode * 31) + this.NetworkUserEntityData$$ExternalSyntheticLambda0.hashCode()) * 31) + getSavedStateRegistry().hashCode();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0002\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0005\u001a\u00020\f¢\u0006\u0004\b\r\u0010\u000eJ7\u0010\n\u001a\u00028\u0000\"\b\b\u0000\u0010\u0003*\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\u00062\u0006\u0010\t\u001a\u00020\bH\u0014¢\u0006\u0004\b\n\u0010\u000b"}, d2 = {"Landroidx/navigation/NavBackStackEntry$NavResultSavedStateFactory;", "Landroidx/lifecycle/AbstractSavedStateViewModelFactory;", "Landroidx/lifecycle/ViewModel;", "T", "", "p0", "Ljava/lang/Class;", "p1", "Landroidx/lifecycle/SavedStateHandle;", "p2", "MyBillsEntityDataFactory", "(Ljava/lang/String;Ljava/lang/Class;Landroidx/lifecycle/SavedStateHandle;)Landroidx/lifecycle/ViewModel;", "Landroidx/savedstate/SavedStateRegistryOwner;", "<init>", "(Landroidx/savedstate/SavedStateRegistryOwner;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes3.dex */
    public static final class NavResultSavedStateFactory extends AbstractSavedStateViewModelFactory {
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public NavResultSavedStateFactory(SavedStateRegistryOwner savedStateRegistryOwner) {
            super(savedStateRegistryOwner);
            Intrinsics.checkNotNullParameter(savedStateRegistryOwner, "");
        }

        @Override // androidx.view.AbstractSavedStateViewModelFactory
        public final <T extends ViewModel> T MyBillsEntityDataFactory(String p0, Class<T> p1, SavedStateHandle p2) {
            Intrinsics.checkNotNullParameter(p0, "");
            Intrinsics.checkNotNullParameter(p1, "");
            Intrinsics.checkNotNullParameter(p2, "");
            return new SavedStateViewModel(p2);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0002\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0006\u001a\u00020\u0002¢\u0006\u0004\b\u0007\u0010\bR\u0011\u0010\u0005\u001a\u00020\u0002X\u0006¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004"}, d2 = {"Landroidx/navigation/NavBackStackEntry$SavedStateViewModel;", "Landroidx/lifecycle/ViewModel;", "Landroidx/lifecycle/SavedStateHandle;", "getAuthRequestContext", "Landroidx/lifecycle/SavedStateHandle;", "PlaceComponentResult", "p0", "<init>", "(Landroidx/lifecycle/SavedStateHandle;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes3.dex */
    public static final class SavedStateViewModel extends ViewModel {

        /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
        final SavedStateHandle PlaceComponentResult;

        public SavedStateViewModel(SavedStateHandle savedStateHandle) {
            Intrinsics.checkNotNullParameter(savedStateHandle, "");
            this.PlaceComponentResult = savedStateHandle;
        }
    }

    @Override // androidx.view.HasDefaultViewModelProviderFactory
    public final ViewModelProvider.Factory getDefaultViewModelProviderFactory() {
        return (SavedStateViewModelFactory) this.PlaceComponentResult.getValue();
    }
}
