package androidx.view;

import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.content.IntentSender;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import androidx.core.app.ActivityCompat;
import androidx.core.app.ActivityOptionsCompat;
import androidx.core.app.MultiWindowModeChangedInfo;
import androidx.core.app.OnMultiWindowModeChangedProvider;
import androidx.core.app.OnNewIntentProvider;
import androidx.core.app.OnPictureInPictureModeChangedProvider;
import androidx.core.app.PictureInPictureModeChangedInfo;
import androidx.core.content.ContextCompat;
import androidx.core.content.OnConfigurationChangedProvider;
import androidx.core.content.OnTrimMemoryProvider;
import androidx.core.util.Consumer;
import androidx.core.view.MenuHost;
import androidx.core.view.MenuHostHelper;
import androidx.core.view.MenuProvider;
import androidx.tracing.Trace;
import androidx.view.C0216ViewTreeSavedStateRegistryOwner;
import androidx.view.HasDefaultViewModelProviderFactory;
import androidx.view.Lifecycle;
import androidx.view.LifecycleEventObserver;
import androidx.view.LifecycleOwner;
import androidx.view.LifecycleRegistry;
import androidx.view.ReportFragment;
import androidx.view.SavedStateHandleSupport;
import androidx.view.SavedStateRegistry;
import androidx.view.SavedStateRegistryController;
import androidx.view.SavedStateRegistryOwner;
import androidx.view.SavedStateViewModelFactory;
import androidx.view.ViewModelProvider;
import androidx.view.ViewModelStore;
import androidx.view.ViewModelStoreOwner;
import androidx.view.ViewTreeLifecycleOwner;
import androidx.view.ViewTreeViewModelStoreOwner;
import androidx.view.contextaware.ContextAware;
import androidx.view.contextaware.ContextAwareHelper;
import androidx.view.contextaware.OnContextAvailableListener;
import androidx.view.result.ActivityResultCallback;
import androidx.view.result.ActivityResultCaller;
import androidx.view.result.ActivityResultLauncher;
import androidx.view.result.ActivityResultRegistry;
import androidx.view.result.ActivityResultRegistryOwner;
import androidx.view.result.IntentSenderRequest;
import androidx.view.result.contract.ActivityResultContract;
import androidx.view.viewmodel.CreationExtras;
import androidx.view.viewmodel.MutableCreationExtras;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes.dex */
public class ComponentActivity extends androidx.core.app.ComponentActivity implements ContextAware, LifecycleOwner, ViewModelStoreOwner, HasDefaultViewModelProviderFactory, SavedStateRegistryOwner, OnBackPressedDispatcherOwner, ActivityResultRegistryOwner, ActivityResultCaller, OnConfigurationChangedProvider, OnTrimMemoryProvider, OnNewIntentProvider, OnMultiWindowModeChangedProvider, OnPictureInPictureModeChangedProvider, MenuHost {
    private static final String ACTIVITY_RESULT_TAG = "android:support:activity-result";
    private final ActivityResultRegistry mActivityResultRegistry;
    private int mContentLayoutId;
    final ContextAwareHelper mContextAwareHelper;
    private ViewModelProvider.Factory mDefaultFactory;
    private final LifecycleRegistry mLifecycleRegistry;
    private final MenuHostHelper mMenuHostHelper;
    private final AtomicInteger mNextLocalRequestCode;
    private final OnBackPressedDispatcher mOnBackPressedDispatcher;
    private final CopyOnWriteArrayList<Consumer<Configuration>> mOnConfigurationChangedListeners;
    private final CopyOnWriteArrayList<Consumer<MultiWindowModeChangedInfo>> mOnMultiWindowModeChangedListeners;
    private final CopyOnWriteArrayList<Consumer<Intent>> mOnNewIntentListeners;
    private final CopyOnWriteArrayList<Consumer<PictureInPictureModeChangedInfo>> mOnPictureInPictureModeChangedListeners;
    private final CopyOnWriteArrayList<Consumer<Integer>> mOnTrimMemoryListeners;
    final SavedStateRegistryController mSavedStateRegistryController;
    private ViewModelStore mViewModelStore;

    @Override // androidx.core.app.ComponentActivity, android.app.Activity, android.view.ContextThemeWrapper, android.content.ContextWrapper
    public void attachBaseContext(Context context) {
        super.attachBaseContext(context);
    }

    @Override // androidx.core.app.ComponentActivity, android.content.ContextWrapper, android.content.Context
    public Context getApplicationContext() {
        return super.getApplicationContext();
    }

    @Override // androidx.core.app.ComponentActivity, android.content.ContextWrapper
    public Context getBaseContext() {
        return super.getBaseContext();
    }

    @Override // androidx.core.app.ComponentActivity, android.view.ContextThemeWrapper, android.content.ContextWrapper, android.content.Context
    public Resources getResources() {
        return super.getResources();
    }

    @Override // androidx.core.app.ComponentActivity, android.app.Activity
    public void onPause() {
        super.onPause();
    }

    @Override // androidx.core.app.ComponentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
    }

    @Deprecated
    public Object onRetainCustomNonConfigurationInstance() {
        return null;
    }

    /* loaded from: classes.dex */
    public static final class NonConfigurationInstances {
        ViewModelStore KClassImpl$Data$declaredNonStaticMembers$2;
        Object PlaceComponentResult;

        NonConfigurationInstances() {
        }
    }

    public ComponentActivity() {
        this.mContextAwareHelper = new ContextAwareHelper();
        this.mMenuHostHelper = new MenuHostHelper(new Runnable() { // from class: androidx.activity.ComponentActivity$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                ComponentActivity.this.invalidateMenu();
            }
        });
        this.mLifecycleRegistry = new LifecycleRegistry(this);
        SavedStateRegistryController BuiltInFictitiousFunctionClassFactory = SavedStateRegistryController.BuiltInFictitiousFunctionClassFactory(this);
        this.mSavedStateRegistryController = BuiltInFictitiousFunctionClassFactory;
        this.mOnBackPressedDispatcher = new OnBackPressedDispatcher(new Runnable() { // from class: androidx.activity.ComponentActivity.1
            {
                ComponentActivity.this = this;
            }

            @Override // java.lang.Runnable
            public void run() {
                try {
                    ComponentActivity.super.onBackPressed();
                } catch (IllegalStateException e) {
                    if (!TextUtils.equals(e.getMessage(), "Can not perform this action after onSaveInstanceState")) {
                        throw e;
                    }
                }
            }
        });
        this.mNextLocalRequestCode = new AtomicInteger();
        this.mActivityResultRegistry = new ActivityResultRegistry() { // from class: androidx.activity.ComponentActivity.2
            {
                ComponentActivity.this = this;
            }

            @Override // androidx.view.result.ActivityResultRegistry
            public final <I, O> void MyBillsEntityDataFactory(final int i, ActivityResultContract<I, O> activityResultContract, I i2, ActivityOptionsCompat activityOptionsCompat) {
                ComponentActivity componentActivity = ComponentActivity.this;
                final ActivityResultContract.SynchronousResult<O> synchronousResult = activityResultContract.getSynchronousResult(componentActivity, i2);
                if (synchronousResult != null) {
                    new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: androidx.activity.ComponentActivity.2.1
                        {
                            AnonymousClass2.this = this;
                        }

                        @Override // java.lang.Runnable
                        public void run() {
                            KClassImpl$Data$declaredNonStaticMembers$2(i, synchronousResult.PlaceComponentResult);
                        }
                    });
                    return;
                }
                Intent createIntent = activityResultContract.createIntent(componentActivity, i2);
                Bundle bundle = null;
                if (createIntent.getExtras() != null && createIntent.getExtras().getClassLoader() == null) {
                    createIntent.setExtrasClassLoader(componentActivity.getClassLoader());
                }
                if (createIntent.hasExtra("androidx.activity.result.contract.extra.ACTIVITY_OPTIONS_BUNDLE")) {
                    bundle = createIntent.getBundleExtra("androidx.activity.result.contract.extra.ACTIVITY_OPTIONS_BUNDLE");
                    createIntent.removeExtra("androidx.activity.result.contract.extra.ACTIVITY_OPTIONS_BUNDLE");
                } else if (activityOptionsCompat != null) {
                    bundle = activityOptionsCompat.MyBillsEntityDataFactory();
                }
                Bundle bundle2 = bundle;
                if ("androidx.activity.result.contract.action.REQUEST_PERMISSIONS".equals(createIntent.getAction())) {
                    String[] stringArrayExtra = createIntent.getStringArrayExtra("androidx.activity.result.contract.extra.PERMISSIONS");
                    if (stringArrayExtra == null) {
                        stringArrayExtra = new String[0];
                    }
                    ActivityCompat.BuiltInFictitiousFunctionClassFactory(componentActivity, stringArrayExtra, i);
                } else if ("androidx.activity.result.contract.action.INTENT_SENDER_REQUEST".equals(createIntent.getAction())) {
                    IntentSenderRequest intentSenderRequest = (IntentSenderRequest) createIntent.getParcelableExtra("androidx.activity.result.contract.extra.INTENT_SENDER_REQUEST");
                    try {
                        ActivityCompat.PlaceComponentResult(componentActivity, intentSenderRequest.BuiltInFictitiousFunctionClassFactory, i, intentSenderRequest.getAuthRequestContext, intentSenderRequest.PlaceComponentResult, intentSenderRequest.MyBillsEntityDataFactory, 0, bundle2);
                    } catch (IntentSender.SendIntentException e) {
                        new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: androidx.activity.ComponentActivity.2.2
                            {
                                AnonymousClass2.this = this;
                            }

                            @Override // java.lang.Runnable
                            public void run() {
                                MyBillsEntityDataFactory(i, 0, new Intent().setAction("androidx.activity.result.contract.action.INTENT_SENDER_REQUEST").putExtra("androidx.activity.result.contract.extra.SEND_INTENT_EXCEPTION", e));
                            }
                        });
                    }
                } else {
                    ActivityCompat.PlaceComponentResult(componentActivity, createIntent, i, bundle2);
                }
            }
        };
        this.mOnConfigurationChangedListeners = new CopyOnWriteArrayList<>();
        this.mOnTrimMemoryListeners = new CopyOnWriteArrayList<>();
        this.mOnNewIntentListeners = new CopyOnWriteArrayList<>();
        this.mOnMultiWindowModeChangedListeners = new CopyOnWriteArrayList<>();
        this.mOnPictureInPictureModeChangedListeners = new CopyOnWriteArrayList<>();
        if (getLifecycle() == null) {
            throw new IllegalStateException("getLifecycle() returned null in ComponentActivity's constructor. Please make sure you are lazily constructing your Lifecycle in the first call to getLifecycle() rather than relying on field initialization.");
        }
        if (Build.VERSION.SDK_INT >= 19) {
            getLifecycle().BuiltInFictitiousFunctionClassFactory(new LifecycleEventObserver() { // from class: androidx.activity.ComponentActivity.3
                {
                    ComponentActivity.this = this;
                }

                @Override // androidx.view.LifecycleEventObserver
                public void BuiltInFictitiousFunctionClassFactory(LifecycleOwner lifecycleOwner, Lifecycle.Event event) {
                    if (event == Lifecycle.Event.ON_STOP) {
                        Window window = ComponentActivity.this.getWindow();
                        View peekDecorView = window != null ? window.peekDecorView() : null;
                        if (peekDecorView != null) {
                            Api19Impl.getAuthRequestContext(peekDecorView);
                        }
                    }
                }
            });
        }
        getLifecycle().BuiltInFictitiousFunctionClassFactory(new LifecycleEventObserver() { // from class: androidx.activity.ComponentActivity.4
            {
                ComponentActivity.this = this;
            }

            @Override // androidx.view.LifecycleEventObserver
            public void BuiltInFictitiousFunctionClassFactory(LifecycleOwner lifecycleOwner, Lifecycle.Event event) {
                if (event == Lifecycle.Event.ON_DESTROY) {
                    ComponentActivity.this.mContextAwareHelper.KClassImpl$Data$declaredNonStaticMembers$2 = null;
                    if (ComponentActivity.this.isChangingConfigurations()) {
                        return;
                    }
                    ComponentActivity.this.getViewModelStore().PlaceComponentResult();
                }
            }
        });
        getLifecycle().BuiltInFictitiousFunctionClassFactory(new LifecycleEventObserver() { // from class: androidx.activity.ComponentActivity.5
            {
                ComponentActivity.this = this;
            }

            @Override // androidx.view.LifecycleEventObserver
            public void BuiltInFictitiousFunctionClassFactory(LifecycleOwner lifecycleOwner, Lifecycle.Event event) {
                ComponentActivity.this.ensureViewModelStore();
                ComponentActivity.this.getLifecycle().KClassImpl$Data$declaredNonStaticMembers$2(this);
            }
        });
        BuiltInFictitiousFunctionClassFactory.getAuthRequestContext();
        SavedStateHandleSupport.PlaceComponentResult(this);
        if (19 <= Build.VERSION.SDK_INT && Build.VERSION.SDK_INT <= 23) {
            getLifecycle().BuiltInFictitiousFunctionClassFactory(new ImmLeaksCleaner(this));
        }
        getSavedStateRegistry().KClassImpl$Data$declaredNonStaticMembers$2(ACTIVITY_RESULT_TAG, new SavedStateRegistry.SavedStateProvider() { // from class: androidx.activity.ComponentActivity$$ExternalSyntheticLambda1
            @Override // androidx.savedstate.SavedStateRegistry.SavedStateProvider
            public final Bundle KClassImpl$Data$declaredNonStaticMembers$2() {
                return ComponentActivity.this.m0lambda$new$0$androidxactivityComponentActivity();
            }
        });
        addOnContextAvailableListener(new OnContextAvailableListener() { // from class: androidx.activity.ComponentActivity$$ExternalSyntheticLambda2
            @Override // androidx.view.contextaware.OnContextAvailableListener
            public final void BuiltInFictitiousFunctionClassFactory(Context context) {
                ComponentActivity.this.m1lambda$new$1$androidxactivityComponentActivity(context);
            }
        });
    }

    /* renamed from: lambda$new$0$androidx-activity-ComponentActivity */
    public /* synthetic */ Bundle m0lambda$new$0$androidxactivityComponentActivity() {
        Bundle bundle = new Bundle();
        ActivityResultRegistry activityResultRegistry = this.mActivityResultRegistry;
        bundle.putIntegerArrayList("KEY_COMPONENT_ACTIVITY_REGISTERED_RCS", new ArrayList<>(activityResultRegistry.KClassImpl$Data$declaredNonStaticMembers$2.values()));
        bundle.putStringArrayList("KEY_COMPONENT_ACTIVITY_REGISTERED_KEYS", new ArrayList<>(activityResultRegistry.KClassImpl$Data$declaredNonStaticMembers$2.keySet()));
        bundle.putStringArrayList("KEY_COMPONENT_ACTIVITY_LAUNCHED_KEYS", new ArrayList<>(activityResultRegistry.BuiltInFictitiousFunctionClassFactory));
        bundle.putBundle("KEY_COMPONENT_ACTIVITY_PENDING_RESULT", (Bundle) activityResultRegistry.moveToNextValue.clone());
        bundle.putSerializable("KEY_COMPONENT_ACTIVITY_RANDOM_OBJECT", activityResultRegistry.getErrorConfigVersion);
        return bundle;
    }

    /* renamed from: lambda$new$1$androidx-activity-ComponentActivity */
    public /* synthetic */ void m1lambda$new$1$androidxactivityComponentActivity(Context context) {
        Bundle PlaceComponentResult = getSavedStateRegistry().PlaceComponentResult(ACTIVITY_RESULT_TAG);
        if (PlaceComponentResult != null) {
            ActivityResultRegistry activityResultRegistry = this.mActivityResultRegistry;
            if (PlaceComponentResult != null) {
                ArrayList<Integer> integerArrayList = PlaceComponentResult.getIntegerArrayList("KEY_COMPONENT_ACTIVITY_REGISTERED_RCS");
                ArrayList<String> stringArrayList = PlaceComponentResult.getStringArrayList("KEY_COMPONENT_ACTIVITY_REGISTERED_KEYS");
                if (stringArrayList == null || integerArrayList == null) {
                    return;
                }
                activityResultRegistry.BuiltInFictitiousFunctionClassFactory = PlaceComponentResult.getStringArrayList("KEY_COMPONENT_ACTIVITY_LAUNCHED_KEYS");
                activityResultRegistry.getErrorConfigVersion = (Random) PlaceComponentResult.getSerializable("KEY_COMPONENT_ACTIVITY_RANDOM_OBJECT");
                activityResultRegistry.moveToNextValue.putAll(PlaceComponentResult.getBundle("KEY_COMPONENT_ACTIVITY_PENDING_RESULT"));
                for (int i = 0; i < stringArrayList.size(); i++) {
                    String str = stringArrayList.get(i);
                    if (activityResultRegistry.KClassImpl$Data$declaredNonStaticMembers$2.containsKey(str)) {
                        Integer remove = activityResultRegistry.KClassImpl$Data$declaredNonStaticMembers$2.remove(str);
                        if (!activityResultRegistry.moveToNextValue.containsKey(str)) {
                            activityResultRegistry.scheduleImpl.remove(remove);
                        }
                    }
                    int intValue = integerArrayList.get(i).intValue();
                    String str2 = stringArrayList.get(i);
                    activityResultRegistry.scheduleImpl.put(Integer.valueOf(intValue), str2);
                    activityResultRegistry.KClassImpl$Data$declaredNonStaticMembers$2.put(str2, Integer.valueOf(intValue));
                }
            }
        }
    }

    public ComponentActivity(int i) {
        this();
        this.mContentLayoutId = i;
    }

    @Override // androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        this.mSavedStateRegistryController.KClassImpl$Data$declaredNonStaticMembers$2(bundle);
        ContextAwareHelper contextAwareHelper = this.mContextAwareHelper;
        contextAwareHelper.KClassImpl$Data$declaredNonStaticMembers$2 = this;
        Iterator<OnContextAvailableListener> it = contextAwareHelper.getAuthRequestContext.iterator();
        while (it.hasNext()) {
            it.next().BuiltInFictitiousFunctionClassFactory(this);
        }
        super.onCreate(bundle);
        ReportFragment.PlaceComponentResult(this);
        int i = this.mContentLayoutId;
        if (i != 0) {
            setContentView(i);
        }
    }

    @Override // androidx.core.app.ComponentActivity, android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        Lifecycle lifecycle = getLifecycle();
        if (lifecycle instanceof LifecycleRegistry) {
            LifecycleRegistry lifecycleRegistry = (LifecycleRegistry) lifecycle;
            Lifecycle.State state = Lifecycle.State.CREATED;
            lifecycleRegistry.PlaceComponentResult("setCurrentState");
            lifecycleRegistry.getAuthRequestContext(state);
        }
        super.onSaveInstanceState(bundle);
        SavedStateRegistryController savedStateRegistryController = this.mSavedStateRegistryController;
        Intrinsics.checkNotNullParameter(bundle, "");
        savedStateRegistryController.MyBillsEntityDataFactory.KClassImpl$Data$declaredNonStaticMembers$2(bundle);
    }

    @Override // android.app.Activity
    public final Object onRetainNonConfigurationInstance() {
        NonConfigurationInstances nonConfigurationInstances;
        Object onRetainCustomNonConfigurationInstance = onRetainCustomNonConfigurationInstance();
        ViewModelStore viewModelStore = this.mViewModelStore;
        if (viewModelStore == null && (nonConfigurationInstances = (NonConfigurationInstances) getLastNonConfigurationInstance()) != null) {
            viewModelStore = nonConfigurationInstances.KClassImpl$Data$declaredNonStaticMembers$2;
        }
        if (viewModelStore == null && onRetainCustomNonConfigurationInstance == null) {
            return null;
        }
        NonConfigurationInstances nonConfigurationInstances2 = new NonConfigurationInstances();
        nonConfigurationInstances2.PlaceComponentResult = onRetainCustomNonConfigurationInstance;
        nonConfigurationInstances2.KClassImpl$Data$declaredNonStaticMembers$2 = viewModelStore;
        return nonConfigurationInstances2;
    }

    @Deprecated
    public Object getLastCustomNonConfigurationInstance() {
        NonConfigurationInstances nonConfigurationInstances = (NonConfigurationInstances) getLastNonConfigurationInstance();
        if (nonConfigurationInstances != null) {
            return nonConfigurationInstances.PlaceComponentResult;
        }
        return null;
    }

    @Override // android.app.Activity
    public void setContentView(int i) {
        initViewTreeOwners();
        super.setContentView(i);
    }

    @Override // android.app.Activity
    public void setContentView(View view) {
        initViewTreeOwners();
        super.setContentView(view);
    }

    @Override // android.app.Activity
    public void setContentView(View view, ViewGroup.LayoutParams layoutParams) {
        initViewTreeOwners();
        super.setContentView(view, layoutParams);
    }

    @Override // android.app.Activity
    public void addContentView(View view, ViewGroup.LayoutParams layoutParams) {
        initViewTreeOwners();
        super.addContentView(view, layoutParams);
    }

    private void initViewTreeOwners() {
        ViewTreeLifecycleOwner.getAuthRequestContext(getWindow().getDecorView(), this);
        ViewTreeViewModelStoreOwner.BuiltInFictitiousFunctionClassFactory(getWindow().getDecorView(), this);
        C0216ViewTreeSavedStateRegistryOwner.KClassImpl$Data$declaredNonStaticMembers$2(getWindow().getDecorView(), this);
        View.KClassImpl$Data$declaredNonStaticMembers$2(getWindow().getDecorView(), this);
    }

    public Context peekAvailableContext() {
        return this.mContextAwareHelper.KClassImpl$Data$declaredNonStaticMembers$2;
    }

    public final void addOnContextAvailableListener(OnContextAvailableListener onContextAvailableListener) {
        ContextAwareHelper contextAwareHelper = this.mContextAwareHelper;
        if (contextAwareHelper.KClassImpl$Data$declaredNonStaticMembers$2 != null) {
            onContextAvailableListener.BuiltInFictitiousFunctionClassFactory(contextAwareHelper.KClassImpl$Data$declaredNonStaticMembers$2);
        }
        contextAwareHelper.getAuthRequestContext.add(onContextAvailableListener);
    }

    @Override // androidx.view.contextaware.ContextAware
    public final void removeOnContextAvailableListener(OnContextAvailableListener onContextAvailableListener) {
        this.mContextAwareHelper.getAuthRequestContext.remove(onContextAvailableListener);
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean onPreparePanel(int i, View view, Menu menu) {
        if (i == 0) {
            super.onPreparePanel(i, view, menu);
            this.mMenuHostHelper.PlaceComponentResult(menu);
            return true;
        }
        return true;
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean onCreatePanelMenu(int i, Menu menu) {
        if (i == 0) {
            super.onCreatePanelMenu(i, menu);
            this.mMenuHostHelper.BuiltInFictitiousFunctionClassFactory(menu, getMenuInflater());
            return true;
        }
        return true;
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean onMenuItemSelected(int i, MenuItem menuItem) {
        if (super.onMenuItemSelected(i, menuItem)) {
            return true;
        }
        if (i == 0) {
            return this.mMenuHostHelper.getAuthRequestContext(menuItem);
        }
        return false;
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onPanelClosed(int i, Menu menu) {
        Iterator<MenuProvider> it = this.mMenuHostHelper.BuiltInFictitiousFunctionClassFactory.iterator();
        while (it.hasNext()) {
            it.next().PlaceComponentResult(menu);
        }
        super.onPanelClosed(i, menu);
    }

    @Override // androidx.core.view.MenuHost
    public void addMenuProvider(MenuProvider menuProvider) {
        MenuHostHelper menuHostHelper = this.mMenuHostHelper;
        menuHostHelper.BuiltInFictitiousFunctionClassFactory.add(menuProvider);
        menuHostHelper.getAuthRequestContext.run();
    }

    public void addMenuProvider(MenuProvider menuProvider, LifecycleOwner lifecycleOwner) {
        this.mMenuHostHelper.BuiltInFictitiousFunctionClassFactory(menuProvider, lifecycleOwner);
    }

    public void addMenuProvider(MenuProvider menuProvider, LifecycleOwner lifecycleOwner, Lifecycle.State state) {
        this.mMenuHostHelper.MyBillsEntityDataFactory(menuProvider, lifecycleOwner, state);
    }

    @Override // androidx.core.view.MenuHost
    public void removeMenuProvider(MenuProvider menuProvider) {
        this.mMenuHostHelper.PlaceComponentResult(menuProvider);
    }

    public void invalidateMenu() {
        invalidateOptionsMenu();
    }

    @Override // androidx.core.app.ComponentActivity, androidx.view.LifecycleOwner
    public Lifecycle getLifecycle() {
        return this.mLifecycleRegistry;
    }

    @Override // androidx.view.ViewModelStoreOwner
    public ViewModelStore getViewModelStore() {
        if (getApplication() == null) {
            throw new IllegalStateException("Your activity is not yet attached to the Application instance. You can't request ViewModel before onCreate call.");
        }
        ensureViewModelStore();
        return this.mViewModelStore;
    }

    void ensureViewModelStore() {
        if (this.mViewModelStore == null) {
            NonConfigurationInstances nonConfigurationInstances = (NonConfigurationInstances) getLastNonConfigurationInstance();
            if (nonConfigurationInstances != null) {
                this.mViewModelStore = nonConfigurationInstances.KClassImpl$Data$declaredNonStaticMembers$2;
            }
            if (this.mViewModelStore == null) {
                this.mViewModelStore = new ViewModelStore();
            }
        }
    }

    @Override // androidx.view.HasDefaultViewModelProviderFactory
    public ViewModelProvider.Factory getDefaultViewModelProviderFactory() {
        if (this.mDefaultFactory == null) {
            this.mDefaultFactory = new SavedStateViewModelFactory(getApplication(), this, getIntent() != null ? getIntent().getExtras() : null);
        }
        return this.mDefaultFactory;
    }

    @Override // androidx.view.HasDefaultViewModelProviderFactory
    public CreationExtras getDefaultViewModelCreationExtras() {
        MutableCreationExtras mutableCreationExtras = new MutableCreationExtras();
        if (getApplication() != null) {
            CreationExtras.Key<Application> key = ViewModelProvider.AndroidViewModelFactory.KClassImpl$Data$declaredNonStaticMembers$2;
            Application application = getApplication();
            Intrinsics.checkNotNullParameter(key, "");
            mutableCreationExtras.MyBillsEntityDataFactory.put(key, application);
        }
        CreationExtras.Key<SavedStateRegistryOwner> key2 = SavedStateHandleSupport.BuiltInFictitiousFunctionClassFactory;
        Intrinsics.checkNotNullParameter(key2, "");
        mutableCreationExtras.MyBillsEntityDataFactory.put(key2, this);
        CreationExtras.Key<ViewModelStoreOwner> key3 = SavedStateHandleSupport.getAuthRequestContext;
        Intrinsics.checkNotNullParameter(key3, "");
        mutableCreationExtras.MyBillsEntityDataFactory.put(key3, this);
        if (getIntent() != null && getIntent().getExtras() != null) {
            CreationExtras.Key<Bundle> key4 = SavedStateHandleSupport.KClassImpl$Data$declaredNonStaticMembers$2;
            Bundle extras = getIntent().getExtras();
            Intrinsics.checkNotNullParameter(key4, "");
            mutableCreationExtras.MyBillsEntityDataFactory.put(key4, extras);
        }
        return mutableCreationExtras;
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        this.mOnBackPressedDispatcher.KClassImpl$Data$declaredNonStaticMembers$2();
    }

    @Override // androidx.view.OnBackPressedDispatcherOwner
    public final OnBackPressedDispatcher getOnBackPressedDispatcher() {
        return this.mOnBackPressedDispatcher;
    }

    @Override // androidx.view.SavedStateRegistryOwner
    public final SavedStateRegistry getSavedStateRegistry() {
        return this.mSavedStateRegistryController.MyBillsEntityDataFactory;
    }

    @Override // android.app.Activity
    @Deprecated
    public void startActivityForResult(Intent intent, int i) {
        super.startActivityForResult(intent, i);
    }

    @Override // android.app.Activity
    @Deprecated
    public void startActivityForResult(Intent intent, int i, Bundle bundle) {
        super.startActivityForResult(intent, i, bundle);
    }

    @Override // android.app.Activity
    @Deprecated
    public void startIntentSenderForResult(IntentSender intentSender, int i, Intent intent, int i2, int i3, int i4) throws IntentSender.SendIntentException {
        super.startIntentSenderForResult(intentSender, i, intent, i2, i3, i4);
    }

    @Override // android.app.Activity
    @Deprecated
    public void startIntentSenderForResult(IntentSender intentSender, int i, Intent intent, int i2, int i3, int i4, Bundle bundle) throws IntentSender.SendIntentException {
        super.startIntentSenderForResult(intentSender, i, intent, i2, i3, i4, bundle);
    }

    @Override // android.app.Activity
    @Deprecated
    public void onActivityResult(int i, int i2, Intent intent) {
        if (this.mActivityResultRegistry.MyBillsEntityDataFactory(i, i2, intent)) {
            return;
        }
        super.onActivityResult(i, i2, intent);
    }

    @Override // android.app.Activity
    @Deprecated
    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        if (this.mActivityResultRegistry.MyBillsEntityDataFactory(i, -1, new Intent().putExtra("androidx.activity.result.contract.extra.PERMISSIONS", strArr).putExtra("androidx.activity.result.contract.extra.PERMISSION_GRANT_RESULTS", iArr)) || Build.VERSION.SDK_INT < 23) {
            return;
        }
        super.onRequestPermissionsResult(i, strArr, iArr);
    }

    public final <I, O> ActivityResultLauncher<I> registerForActivityResult(ActivityResultContract<I, O> activityResultContract, ActivityResultRegistry activityResultRegistry, ActivityResultCallback<O> activityResultCallback) {
        StringBuilder sb = new StringBuilder();
        sb.append("activity_rq#");
        sb.append(this.mNextLocalRequestCode.getAndIncrement());
        return activityResultRegistry.KClassImpl$Data$declaredNonStaticMembers$2(sb.toString(), this, activityResultContract, activityResultCallback);
    }

    public final <I, O> ActivityResultLauncher<I> registerForActivityResult(ActivityResultContract<I, O> activityResultContract, ActivityResultCallback<O> activityResultCallback) {
        return registerForActivityResult(activityResultContract, this.mActivityResultRegistry, activityResultCallback);
    }

    @Override // androidx.view.result.ActivityResultRegistryOwner
    public final ActivityResultRegistry getActivityResultRegistry() {
        return this.mActivityResultRegistry;
    }

    @Override // android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        Iterator<Consumer<Configuration>> it = this.mOnConfigurationChangedListeners.iterator();
        while (it.hasNext()) {
            it.next().accept(configuration);
        }
    }

    @Override // androidx.core.content.OnConfigurationChangedProvider
    public final void addOnConfigurationChangedListener(Consumer<Configuration> consumer) {
        this.mOnConfigurationChangedListeners.add(consumer);
    }

    @Override // androidx.core.content.OnConfigurationChangedProvider
    public final void removeOnConfigurationChangedListener(Consumer<Configuration> consumer) {
        this.mOnConfigurationChangedListeners.remove(consumer);
    }

    @Override // android.app.Activity, android.content.ComponentCallbacks2
    public void onTrimMemory(int i) {
        super.onTrimMemory(i);
        Iterator<Consumer<Integer>> it = this.mOnTrimMemoryListeners.iterator();
        while (it.hasNext()) {
            it.next().accept(Integer.valueOf(i));
        }
    }

    @Override // androidx.core.content.OnTrimMemoryProvider
    public final void addOnTrimMemoryListener(Consumer<Integer> consumer) {
        this.mOnTrimMemoryListeners.add(consumer);
    }

    @Override // androidx.core.content.OnTrimMemoryProvider
    public final void removeOnTrimMemoryListener(Consumer<Integer> consumer) {
        this.mOnTrimMemoryListeners.remove(consumer);
    }

    @Override // android.app.Activity
    public void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        Iterator<Consumer<Intent>> it = this.mOnNewIntentListeners.iterator();
        while (it.hasNext()) {
            it.next().accept(intent);
        }
    }

    public final void addOnNewIntentListener(Consumer<Intent> consumer) {
        this.mOnNewIntentListeners.add(consumer);
    }

    public final void removeOnNewIntentListener(Consumer<Intent> consumer) {
        this.mOnNewIntentListeners.remove(consumer);
    }

    @Override // android.app.Activity
    public void onMultiWindowModeChanged(boolean z) {
        Iterator<Consumer<MultiWindowModeChangedInfo>> it = this.mOnMultiWindowModeChangedListeners.iterator();
        while (it.hasNext()) {
            it.next().accept(new MultiWindowModeChangedInfo(z));
        }
    }

    @Override // android.app.Activity
    public void onMultiWindowModeChanged(boolean z, Configuration configuration) {
        Iterator<Consumer<MultiWindowModeChangedInfo>> it = this.mOnMultiWindowModeChangedListeners.iterator();
        while (it.hasNext()) {
            it.next().accept(new MultiWindowModeChangedInfo(z, configuration));
        }
    }

    @Override // androidx.core.app.OnMultiWindowModeChangedProvider
    public final void addOnMultiWindowModeChangedListener(Consumer<MultiWindowModeChangedInfo> consumer) {
        this.mOnMultiWindowModeChangedListeners.add(consumer);
    }

    @Override // androidx.core.app.OnMultiWindowModeChangedProvider
    public final void removeOnMultiWindowModeChangedListener(Consumer<MultiWindowModeChangedInfo> consumer) {
        this.mOnMultiWindowModeChangedListeners.remove(consumer);
    }

    @Override // android.app.Activity
    public void onPictureInPictureModeChanged(boolean z) {
        Iterator<Consumer<PictureInPictureModeChangedInfo>> it = this.mOnPictureInPictureModeChangedListeners.iterator();
        while (it.hasNext()) {
            it.next().accept(new PictureInPictureModeChangedInfo(z));
        }
    }

    @Override // android.app.Activity
    public void onPictureInPictureModeChanged(boolean z, Configuration configuration) {
        Iterator<Consumer<PictureInPictureModeChangedInfo>> it = this.mOnPictureInPictureModeChangedListeners.iterator();
        while (it.hasNext()) {
            it.next().accept(new PictureInPictureModeChangedInfo(z, configuration));
        }
    }

    @Override // androidx.core.app.OnPictureInPictureModeChangedProvider
    public final void addOnPictureInPictureModeChangedListener(Consumer<PictureInPictureModeChangedInfo> consumer) {
        this.mOnPictureInPictureModeChangedListeners.add(consumer);
    }

    @Override // androidx.core.app.OnPictureInPictureModeChangedProvider
    public final void removeOnPictureInPictureModeChangedListener(Consumer<PictureInPictureModeChangedInfo> consumer) {
        this.mOnPictureInPictureModeChangedListeners.remove(consumer);
    }

    @Override // android.app.Activity
    public void reportFullyDrawn() {
        try {
            if (Trace.PlaceComponentResult()) {
                Trace.KClassImpl$Data$declaredNonStaticMembers$2("reportFullyDrawn() for ComponentActivity");
            }
            if (Build.VERSION.SDK_INT > 19) {
                super.reportFullyDrawn();
            } else if (Build.VERSION.SDK_INT == 19 && ContextCompat.KClassImpl$Data$declaredNonStaticMembers$2(this, "android.permission.UPDATE_DEVICE_STATS") == 0) {
                super.reportFullyDrawn();
            }
        } finally {
            Trace.MyBillsEntityDataFactory();
        }
    }

    /* loaded from: classes.dex */
    static class Api19Impl {
        private Api19Impl() {
        }

        static void getAuthRequestContext(View view) {
            view.cancelPendingInputEvents();
        }
    }
}
