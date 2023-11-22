package androidx.appcompat.app;

import android.app.Activity;
import android.app.Dialog;
import android.app.UiModeManager;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.media.AudioManager;
import android.os.Build;
import android.os.Bundle;
import android.os.LocaleList;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.PowerManager;
import android.text.TextUtils;
import android.util.AndroidRuntimeException;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.ActionMode;
import android.view.ContextThemeWrapper;
import android.view.KeyCharacterMap;
import android.view.KeyEvent;
import android.view.KeyboardShortcutGroup;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.Window;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.ListAdapter;
import android.widget.PopupWindow;
import android.widget.TextView;
import androidx.appcompat.R;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.view.ActionMode;
import androidx.appcompat.view.SupportActionModeWrapper;
import androidx.appcompat.view.SupportMenuInflater;
import androidx.appcompat.view.WindowCallbackWrapper;
import androidx.appcompat.view.menu.ExpandedMenuView;
import androidx.appcompat.view.menu.ListMenuPresenter;
import androidx.appcompat.view.menu.MenuBuilder;
import androidx.appcompat.view.menu.MenuPresenter;
import androidx.appcompat.view.menu.MenuView;
import androidx.appcompat.widget.ActionBarContextView;
import androidx.appcompat.widget.AppCompatDrawableManager;
import androidx.appcompat.widget.ContentFrameLayout;
import androidx.appcompat.widget.DecorContentParent;
import androidx.appcompat.widget.FitWindowsViewGroup;
import androidx.appcompat.widget.ResourceManagerInternal;
import androidx.appcompat.widget.TintTypedArray;
import androidx.appcompat.widget.Toolbar;
import androidx.appcompat.widget.ViewUtils;
import androidx.collection.SimpleArrayMap;
import androidx.core.app.ActivityCompat;
import androidx.core.app.NavUtils;
import androidx.core.content.ContextCompat;
import androidx.core.content.res.ResourcesCompat;
import androidx.core.util.ObjectsCompat;
import androidx.core.view.KeyEventDispatcher;
import androidx.core.view.LayoutInflaterCompat;
import androidx.core.view.OnApplyWindowInsetsListener;
import androidx.core.view.ViewCompat;
import androidx.core.view.ViewPropertyAnimatorCompat;
import androidx.core.view.ViewPropertyAnimatorListener;
import androidx.core.view.ViewPropertyAnimatorListenerAdapter;
import androidx.core.view.WindowInsetsCompat;
import androidx.view.Lifecycle;
import androidx.view.LifecycleOwner;
import com.alibaba.griver.base.common.utils.H5ResourceHandlerUtil;
import com.fullstory.instrumentation.InstrumentInjector;
import java.lang.Thread;
import java.util.List;

/* loaded from: classes.dex */
public class AppCompatDelegateImpl extends AppCompatDelegate implements MenuBuilder.Callback, LayoutInflater.Factory2 {
    private static final SimpleArrayMap<String, Integer> FragmentBottomSheetPaymentSettingBinding = new SimpleArrayMap<>();
    private static final boolean NetworkUserEntityData$$ExternalSyntheticLambda3;
    private static final boolean NetworkUserEntityData$$ExternalSyntheticLambda4;
    private static boolean NetworkUserEntityData$$ExternalSyntheticLambda5;
    private static final boolean NetworkUserEntityData$$ExternalSyntheticLambda6;
    private static final int[] getSupportButtonTintMode;
    private boolean A;
    private LayoutIncludeDetector AppCompatEmojiTextHelper;
    private AutoNightModeManager B;
    private boolean BottomSheetCardBindingView$watcherCardNumberView$1;
    ActionBarContextView BuiltInFictitiousFunctionClassFactory;
    private AppCompatWindowCallback C;
    private boolean D;
    boolean DatabaseTableConfigUtil;
    private DecorContentParent E;
    private boolean F;
    private final Runnable G;
    boolean GetContactSyncConfig;
    private boolean H;
    private int I;
    private boolean J;
    private PanelFeatureState[] K;
    final AppCompatCallback KClassImpl$Data$declaredNonStaticMembers$2;
    private View L;
    private PanelMenuPresenterCallback M;
    PopupWindow MyBillsEntityDataFactory;
    private CharSequence N;
    final Context NetworkUserEntityData$$ExternalSyntheticLambda0;
    int NetworkUserEntityData$$ExternalSyntheticLambda1;
    MenuInflater NetworkUserEntityData$$ExternalSyntheticLambda2;
    boolean NetworkUserEntityData$$ExternalSyntheticLambda7;
    ViewGroup NetworkUserEntityData$$ExternalSyntheticLambda8;
    private Rect O;
    private int P;
    ActionMode PlaceComponentResult;
    Window PrepareContext;
    private boolean Q;
    private boolean SubSequence;
    private Rect SummaryVoucherView$$ExternalSyntheticLambda0;
    private TextView SummaryVoucherView$$ExternalSyntheticLambda1;
    private AutoNightModeManager VerifyPinStateManager$executeRiskChallenge$2$1;
    private Configuration VerifyPinStateManager$executeRiskChallenge$2$2;
    ActionBar getAuthRequestContext;
    private boolean getCallingPid;
    ViewPropertyAnimatorCompat getErrorConfigVersion;
    private PanelFeatureState getNameOrBuilderList;
    private boolean getOnBoardingScenario;
    private boolean getValueOfTouchPositionAbsolute;
    boolean initRecordTimeStamp;
    boolean isLayoutRequested;
    boolean lookAheadTest;
    boolean moveToNextValue;
    Runnable newProxyInstance;
    private AppCompatViewInflater readMicros;
    final Object scheduleImpl;
    private ActionMenuPresenterCallback whenAvailable;

    /* loaded from: classes.dex */
    public interface ActionBarMenuCallback {
        View MyBillsEntityDataFactory(int i);

        boolean PlaceComponentResult(int i);
    }

    @Override // androidx.appcompat.app.AppCompatDelegate
    public void PlaceComponentResult(Bundle bundle) {
    }

    void getAuthRequestContext(ViewGroup viewGroup) {
    }

    static {
        boolean z = Build.VERSION.SDK_INT < 21;
        NetworkUserEntityData$$ExternalSyntheticLambda6 = z;
        getSupportButtonTintMode = new int[]{16842836};
        NetworkUserEntityData$$ExternalSyntheticLambda4 = !"robolectric".equals(Build.FINGERPRINT);
        NetworkUserEntityData$$ExternalSyntheticLambda3 = Build.VERSION.SDK_INT >= 17;
        if (!z || NetworkUserEntityData$$ExternalSyntheticLambda5) {
            return;
        }
        final Thread.UncaughtExceptionHandler defaultUncaughtExceptionHandler = InstrumentInjector.getDefaultUncaughtExceptionHandler();
        InstrumentInjector.setDefaultUncaughtExceptionHandler(new Thread.UncaughtExceptionHandler() { // from class: androidx.appcompat.app.AppCompatDelegateImpl.1
            @Override // java.lang.Thread.UncaughtExceptionHandler
            public void uncaughtException(Thread thread, Throwable th) {
                if (MyBillsEntityDataFactory(th)) {
                    StringBuilder sb = new StringBuilder();
                    sb.append(th.getMessage());
                    sb.append(". If the resource you are trying to use is a vector resource, you may be referencing it in an unsupported way. See AppCompatDelegate.setCompatVectorFromResourcesEnabled() for more info.");
                    Resources.NotFoundException notFoundException = new Resources.NotFoundException(sb.toString());
                    notFoundException.initCause(th.getCause());
                    notFoundException.setStackTrace(th.getStackTrace());
                    defaultUncaughtExceptionHandler.uncaughtException(thread, notFoundException);
                    return;
                }
                defaultUncaughtExceptionHandler.uncaughtException(thread, th);
            }

            private boolean MyBillsEntityDataFactory(Throwable th) {
                String message;
                if (!(th instanceof Resources.NotFoundException) || (message = th.getMessage()) == null) {
                    return false;
                }
                return message.contains("drawable") || message.contains("Drawable");
            }
        });
        NetworkUserEntityData$$ExternalSyntheticLambda5 = true;
    }

    public AppCompatDelegateImpl(Activity activity, AppCompatCallback appCompatCallback) {
        this(activity, null, appCompatCallback, activity);
    }

    public AppCompatDelegateImpl(Dialog dialog, AppCompatCallback appCompatCallback) {
        this(dialog.getContext(), dialog.getWindow(), appCompatCallback, dialog);
    }

    private AppCompatDelegateImpl(Context context, Window window, AppCompatCallback appCompatCallback, Object obj) {
        SimpleArrayMap<String, Integer> simpleArrayMap;
        Integer num;
        AppCompatActivity SubSequence;
        this.getErrorConfigVersion = null;
        this.F = true;
        this.I = -100;
        this.G = new Runnable() { // from class: androidx.appcompat.app.AppCompatDelegateImpl.2
            {
                AppCompatDelegateImpl.this = this;
            }

            @Override // java.lang.Runnable
            public void run() {
                if ((AppCompatDelegateImpl.this.NetworkUserEntityData$$ExternalSyntheticLambda1 & 1) != 0) {
                    AppCompatDelegateImpl.this.scheduleImpl(0);
                }
                if ((AppCompatDelegateImpl.this.NetworkUserEntityData$$ExternalSyntheticLambda1 & 4096) != 0) {
                    AppCompatDelegateImpl.this.scheduleImpl(108);
                }
                AppCompatDelegateImpl.this.initRecordTimeStamp = false;
                AppCompatDelegateImpl.this.NetworkUserEntityData$$ExternalSyntheticLambda1 = 0;
            }
        };
        this.NetworkUserEntityData$$ExternalSyntheticLambda0 = context;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = appCompatCallback;
        this.scheduleImpl = obj;
        if (this.I == -100 && (obj instanceof Dialog) && (SubSequence = SubSequence()) != null) {
            this.I = SubSequence.getDelegate().MyBillsEntityDataFactory();
        }
        if (this.I == -100 && (num = (simpleArrayMap = FragmentBottomSheetPaymentSettingBinding).get(obj.getClass().getName())) != null) {
            this.I = num.intValue();
            simpleArrayMap.remove(obj.getClass().getName());
        }
        if (window != null) {
            MyBillsEntityDataFactory(window);
        }
        AppCompatDrawableManager.PlaceComponentResult();
    }

    @Override // androidx.appcompat.app.AppCompatDelegate
    public Context getAuthRequestContext(Context context) {
        this.BottomSheetCardBindingView$watcherCardNumberView$1 = true;
        int KClassImpl$Data$declaredNonStaticMembers$2 = KClassImpl$Data$declaredNonStaticMembers$2(context, NetworkUserEntityData$$ExternalSyntheticLambda6());
        boolean z = false;
        Configuration configuration = null;
        if (NetworkUserEntityData$$ExternalSyntheticLambda3 && (context instanceof ContextThemeWrapper)) {
            try {
                ContextThemeWrapperCompatApi17Impl.MyBillsEntityDataFactory((ContextThemeWrapper) context, BuiltInFictitiousFunctionClassFactory(context, KClassImpl$Data$declaredNonStaticMembers$2, null, false));
                return context;
            } catch (IllegalStateException unused) {
            }
        }
        if (context instanceof androidx.appcompat.view.ContextThemeWrapper) {
            try {
                ((androidx.appcompat.view.ContextThemeWrapper) context).getAuthRequestContext(BuiltInFictitiousFunctionClassFactory(context, KClassImpl$Data$declaredNonStaticMembers$2, null, false));
                return context;
            } catch (IllegalStateException unused2) {
            }
        }
        if (!NetworkUserEntityData$$ExternalSyntheticLambda4) {
            return super.getAuthRequestContext(context);
        }
        if (Build.VERSION.SDK_INT >= 17) {
            Configuration configuration2 = new Configuration();
            configuration2.uiMode = -1;
            configuration2.fontScale = 0.0f;
            Configuration configuration3 = context.createConfigurationContext(configuration2).getResources().getConfiguration();
            Configuration configuration4 = context.getResources().getConfiguration();
            configuration3.uiMode = configuration4.uiMode;
            if (!configuration3.equals(configuration4)) {
                configuration = MyBillsEntityDataFactory(configuration3, configuration4);
            }
        }
        Configuration BuiltInFictitiousFunctionClassFactory = BuiltInFictitiousFunctionClassFactory(context, KClassImpl$Data$declaredNonStaticMembers$2, configuration, true);
        androidx.appcompat.view.ContextThemeWrapper contextThemeWrapper = new androidx.appcompat.view.ContextThemeWrapper(context, R.style.KClassImpl$Data$declaredNonStaticMembers$2);
        contextThemeWrapper.getAuthRequestContext(BuiltInFictitiousFunctionClassFactory);
        try {
            z = context.getTheme() != null;
        } catch (NullPointerException unused3) {
        }
        if (z) {
            ResourcesCompat.ThemeCompat.BuiltInFictitiousFunctionClassFactory(contextThemeWrapper.getTheme());
        }
        return super.getAuthRequestContext(contextThemeWrapper);
    }

    /* loaded from: classes.dex */
    static class ContextThemeWrapperCompatApi17Impl {
        private ContextThemeWrapperCompatApi17Impl() {
        }

        static void MyBillsEntityDataFactory(ContextThemeWrapper contextThemeWrapper, Configuration configuration) {
            contextThemeWrapper.applyOverrideConfiguration(configuration);
        }
    }

    @Override // androidx.appcompat.app.AppCompatDelegate
    public void MyBillsEntityDataFactory(Bundle bundle) {
        this.BottomSheetCardBindingView$watcherCardNumberView$1 = true;
        getAuthRequestContext(false);
        whenAvailable();
        Object obj = this.scheduleImpl;
        if (obj instanceof Activity) {
            String str = null;
            try {
                str = NavUtils.KClassImpl$Data$declaredNonStaticMembers$2((Activity) obj);
            } catch (IllegalArgumentException unused) {
            }
            if (str != null) {
                ActionBar PrepareContext = PrepareContext();
                if (PrepareContext == null) {
                    this.getOnBoardingScenario = true;
                } else {
                    PrepareContext.getAuthRequestContext(true);
                }
            }
            MyBillsEntityDataFactory(this);
        }
        this.VerifyPinStateManager$executeRiskChallenge$2$2 = new Configuration(this.NetworkUserEntityData$$ExternalSyntheticLambda0.getResources().getConfiguration());
        this.getValueOfTouchPositionAbsolute = true;
    }

    @Override // androidx.appcompat.app.AppCompatDelegate
    public void KClassImpl$Data$declaredNonStaticMembers$2(Bundle bundle) {
        readMicros();
    }

    @Override // androidx.appcompat.app.AppCompatDelegate
    public ActionBar KClassImpl$Data$declaredNonStaticMembers$2() {
        getCallingPid();
        return this.getAuthRequestContext;
    }

    final ActionBar PrepareContext() {
        return this.getAuthRequestContext;
    }

    final Window.Callback newProxyInstance() {
        return this.PrepareContext.getCallback();
    }

    private void getCallingPid() {
        readMicros();
        if (this.lookAheadTest && this.getAuthRequestContext == null) {
            Object obj = this.scheduleImpl;
            if (obj instanceof Activity) {
                this.getAuthRequestContext = new WindowDecorActionBar((Activity) this.scheduleImpl, this.DatabaseTableConfigUtil);
            } else if (obj instanceof Dialog) {
                this.getAuthRequestContext = new WindowDecorActionBar((Dialog) this.scheduleImpl);
            }
            ActionBar actionBar = this.getAuthRequestContext;
            if (actionBar != null) {
                actionBar.getAuthRequestContext(this.getOnBoardingScenario);
            }
        }
    }

    @Override // androidx.appcompat.app.AppCompatDelegate
    public void PlaceComponentResult(Toolbar toolbar) {
        if (this.scheduleImpl instanceof Activity) {
            ActionBar KClassImpl$Data$declaredNonStaticMembers$2 = KClassImpl$Data$declaredNonStaticMembers$2();
            if (KClassImpl$Data$declaredNonStaticMembers$2 instanceof WindowDecorActionBar) {
                throw new IllegalStateException("This Activity already has an action bar supplied by the window decor. Do not request Window.FEATURE_SUPPORT_ACTION_BAR and set windowActionBar to false in your theme to use a Toolbar instead.");
            }
            this.NetworkUserEntityData$$ExternalSyntheticLambda2 = null;
            if (KClassImpl$Data$declaredNonStaticMembers$2 != null) {
                KClassImpl$Data$declaredNonStaticMembers$2.NetworkUserEntityData$$ExternalSyntheticLambda0();
            }
            this.getAuthRequestContext = null;
            if (toolbar != null) {
                ToolbarActionBar toolbarActionBar = new ToolbarActionBar(toolbar, NetworkUserEntityData$$ExternalSyntheticLambda8(), this.C);
                this.getAuthRequestContext = toolbarActionBar;
                this.C.PlaceComponentResult(toolbarActionBar.MyBillsEntityDataFactory);
            } else {
                this.C.PlaceComponentResult(null);
            }
            scheduleImpl();
        }
    }

    final Context initRecordTimeStamp() {
        ActionBar KClassImpl$Data$declaredNonStaticMembers$2 = KClassImpl$Data$declaredNonStaticMembers$2();
        Context BuiltInFictitiousFunctionClassFactory = KClassImpl$Data$declaredNonStaticMembers$2 != null ? KClassImpl$Data$declaredNonStaticMembers$2.BuiltInFictitiousFunctionClassFactory() : null;
        return BuiltInFictitiousFunctionClassFactory == null ? this.NetworkUserEntityData$$ExternalSyntheticLambda0 : BuiltInFictitiousFunctionClassFactory;
    }

    @Override // androidx.appcompat.app.AppCompatDelegate
    public MenuInflater getAuthRequestContext() {
        if (this.NetworkUserEntityData$$ExternalSyntheticLambda2 == null) {
            getCallingPid();
            ActionBar actionBar = this.getAuthRequestContext;
            this.NetworkUserEntityData$$ExternalSyntheticLambda2 = new SupportMenuInflater(actionBar != null ? actionBar.BuiltInFictitiousFunctionClassFactory() : this.NetworkUserEntityData$$ExternalSyntheticLambda0);
        }
        return this.NetworkUserEntityData$$ExternalSyntheticLambda2;
    }

    @Override // androidx.appcompat.app.AppCompatDelegate
    public <T extends View> T BuiltInFictitiousFunctionClassFactory(int i) {
        readMicros();
        return (T) this.PrepareContext.findViewById(i);
    }

    @Override // androidx.appcompat.app.AppCompatDelegate
    public void MyBillsEntityDataFactory(Configuration configuration) {
        ActionBar KClassImpl$Data$declaredNonStaticMembers$2;
        if (this.lookAheadTest && this.Q && (KClassImpl$Data$declaredNonStaticMembers$2 = KClassImpl$Data$declaredNonStaticMembers$2()) != null) {
            KClassImpl$Data$declaredNonStaticMembers$2.PlaceComponentResult(configuration);
        }
        AppCompatDrawableManager.KClassImpl$Data$declaredNonStaticMembers$2().BuiltInFictitiousFunctionClassFactory(this.NetworkUserEntityData$$ExternalSyntheticLambda0);
        this.VerifyPinStateManager$executeRiskChallenge$2$2 = new Configuration(this.NetworkUserEntityData$$ExternalSyntheticLambda0.getResources().getConfiguration());
        getAuthRequestContext(false);
        configuration.updateFrom(this.NetworkUserEntityData$$ExternalSyntheticLambda0.getResources().getConfiguration());
    }

    @Override // androidx.appcompat.app.AppCompatDelegate
    public void getErrorConfigVersion() {
        GetContactSyncConfig();
    }

    @Override // androidx.appcompat.app.AppCompatDelegate
    public void NetworkUserEntityData$$ExternalSyntheticLambda2() {
        ActionBar KClassImpl$Data$declaredNonStaticMembers$2 = KClassImpl$Data$declaredNonStaticMembers$2();
        if (KClassImpl$Data$declaredNonStaticMembers$2 != null) {
            KClassImpl$Data$declaredNonStaticMembers$2.BuiltInFictitiousFunctionClassFactory(false);
        }
    }

    @Override // androidx.appcompat.app.AppCompatDelegate
    public void lookAheadTest() {
        ActionBar KClassImpl$Data$declaredNonStaticMembers$2 = KClassImpl$Data$declaredNonStaticMembers$2();
        if (KClassImpl$Data$declaredNonStaticMembers$2 != null) {
            KClassImpl$Data$declaredNonStaticMembers$2.BuiltInFictitiousFunctionClassFactory(true);
        }
    }

    @Override // androidx.appcompat.app.AppCompatDelegate
    public void KClassImpl$Data$declaredNonStaticMembers$2(View view) {
        readMicros();
        ViewGroup viewGroup = (ViewGroup) this.NetworkUserEntityData$$ExternalSyntheticLambda8.findViewById(16908290);
        viewGroup.removeAllViews();
        viewGroup.addView(view);
        this.C.KClassImpl$Data$declaredNonStaticMembers$2(this.PrepareContext.getCallback());
    }

    @Override // androidx.appcompat.app.AppCompatDelegate
    public void getAuthRequestContext(int i) {
        readMicros();
        ViewGroup viewGroup = (ViewGroup) this.NetworkUserEntityData$$ExternalSyntheticLambda8.findViewById(16908290);
        viewGroup.removeAllViews();
        LayoutInflater.from(this.NetworkUserEntityData$$ExternalSyntheticLambda0).inflate(i, viewGroup);
        this.C.KClassImpl$Data$declaredNonStaticMembers$2(this.PrepareContext.getCallback());
    }

    @Override // androidx.appcompat.app.AppCompatDelegate
    public void MyBillsEntityDataFactory(View view, ViewGroup.LayoutParams layoutParams) {
        readMicros();
        ViewGroup viewGroup = (ViewGroup) this.NetworkUserEntityData$$ExternalSyntheticLambda8.findViewById(16908290);
        viewGroup.removeAllViews();
        viewGroup.addView(view, layoutParams);
        this.C.KClassImpl$Data$declaredNonStaticMembers$2(this.PrepareContext.getCallback());
    }

    @Override // androidx.appcompat.app.AppCompatDelegate
    public void BuiltInFictitiousFunctionClassFactory(View view, ViewGroup.LayoutParams layoutParams) {
        readMicros();
        ((ViewGroup) this.NetworkUserEntityData$$ExternalSyntheticLambda8.findViewById(16908290)).addView(view, layoutParams);
        this.C.KClassImpl$Data$declaredNonStaticMembers$2(this.PrepareContext.getCallback());
    }

    /* JADX WARN: Removed duplicated region for block: B:39:0x0058  */
    @Override // androidx.appcompat.app.AppCompatDelegate
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void moveToNextValue() {
        /*
            r3 = this;
            java.lang.Object r0 = r3.scheduleImpl
            boolean r0 = r0 instanceof android.app.Activity
            if (r0 == 0) goto L9
            BuiltInFictitiousFunctionClassFactory(r3)
        L9:
            boolean r0 = r3.initRecordTimeStamp
            if (r0 == 0) goto L18
            android.view.Window r0 = r3.PrepareContext
            android.view.View r0 = r0.getDecorView()
            java.lang.Runnable r1 = r3.G
            r0.removeCallbacks(r1)
        L18:
            r0 = 1
            r3.moveToNextValue = r0
            int r0 = r3.I
            r1 = -100
            if (r0 == r1) goto L45
            java.lang.Object r0 = r3.scheduleImpl
            boolean r1 = r0 instanceof android.app.Activity
            if (r1 == 0) goto L45
            android.app.Activity r0 = (android.app.Activity) r0
            boolean r0 = r0.isChangingConfigurations()
            if (r0 == 0) goto L45
            androidx.collection.SimpleArrayMap<java.lang.String, java.lang.Integer> r0 = androidx.appcompat.app.AppCompatDelegateImpl.FragmentBottomSheetPaymentSettingBinding
            java.lang.Object r1 = r3.scheduleImpl
            java.lang.Class r1 = r1.getClass()
            java.lang.String r1 = r1.getName()
            int r2 = r3.I
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
            r0.put(r1, r2)
            goto L54
        L45:
            androidx.collection.SimpleArrayMap<java.lang.String, java.lang.Integer> r0 = androidx.appcompat.app.AppCompatDelegateImpl.FragmentBottomSheetPaymentSettingBinding
            java.lang.Object r1 = r3.scheduleImpl
            java.lang.Class r1 = r1.getClass()
            java.lang.String r1 = r1.getName()
            r0.remove(r1)
        L54:
            androidx.appcompat.app.ActionBar r0 = r3.getAuthRequestContext
            if (r0 == 0) goto L5b
            r0.NetworkUserEntityData$$ExternalSyntheticLambda0()
        L5b:
            r3.NetworkUserEntityData$$ExternalSyntheticLambda3()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.app.AppCompatDelegateImpl.moveToNextValue():void");
    }

    private void NetworkUserEntityData$$ExternalSyntheticLambda3() {
        AutoNightModeManager autoNightModeManager = this.VerifyPinStateManager$executeRiskChallenge$2$1;
        if (autoNightModeManager != null) {
            autoNightModeManager.BuiltInFictitiousFunctionClassFactory();
        }
        AutoNightModeManager autoNightModeManager2 = this.B;
        if (autoNightModeManager2 != null) {
            autoNightModeManager2.BuiltInFictitiousFunctionClassFactory();
        }
    }

    @Override // androidx.appcompat.app.AppCompatDelegate
    public void PlaceComponentResult(int i) {
        this.P = i;
    }

    private void whenAvailable() {
        if (this.PrepareContext == null) {
            Object obj = this.scheduleImpl;
            if (obj instanceof Activity) {
                MyBillsEntityDataFactory(((Activity) obj).getWindow());
            }
        }
        if (this.PrepareContext == null) {
            throw new IllegalStateException("We have not been given a Window");
        }
    }

    private void MyBillsEntityDataFactory(Window window) {
        if (this.PrepareContext != null) {
            throw new IllegalStateException("AppCompat has already installed itself into the Window");
        }
        Window.Callback callback = window.getCallback();
        if (callback instanceof AppCompatWindowCallback) {
            throw new IllegalStateException("AppCompat has already installed itself into the Window");
        }
        AppCompatWindowCallback appCompatWindowCallback = new AppCompatWindowCallback(callback);
        this.C = appCompatWindowCallback;
        window.setCallback(appCompatWindowCallback);
        InstrumentInjector.trackWindow(window);
        TintTypedArray MyBillsEntityDataFactory = TintTypedArray.MyBillsEntityDataFactory(this.NetworkUserEntityData$$ExternalSyntheticLambda0, null, getSupportButtonTintMode);
        Drawable MyBillsEntityDataFactory2 = MyBillsEntityDataFactory.MyBillsEntityDataFactory(0);
        if (MyBillsEntityDataFactory2 != null) {
            window.setBackgroundDrawable(MyBillsEntityDataFactory2);
        }
        MyBillsEntityDataFactory.BuiltInFictitiousFunctionClassFactory.recycle();
        this.PrepareContext = window;
    }

    private void readMicros() {
        if (this.Q) {
            return;
        }
        this.NetworkUserEntityData$$ExternalSyntheticLambda8 = FragmentBottomSheetPaymentSettingBinding();
        CharSequence NetworkUserEntityData$$ExternalSyntheticLambda8 = NetworkUserEntityData$$ExternalSyntheticLambda8();
        if (!TextUtils.isEmpty(NetworkUserEntityData$$ExternalSyntheticLambda8)) {
            DecorContentParent decorContentParent = this.E;
            if (decorContentParent != null) {
                decorContentParent.setWindowTitle(NetworkUserEntityData$$ExternalSyntheticLambda8);
            } else if (PrepareContext() != null) {
                PrepareContext().KClassImpl$Data$declaredNonStaticMembers$2(NetworkUserEntityData$$ExternalSyntheticLambda8);
            } else {
                TextView textView = this.SummaryVoucherView$$ExternalSyntheticLambda1;
                if (textView != null) {
                    textView.setText(NetworkUserEntityData$$ExternalSyntheticLambda8);
                }
            }
        }
        NetworkUserEntityData$$ExternalSyntheticLambda4();
        getAuthRequestContext(this.NetworkUserEntityData$$ExternalSyntheticLambda8);
        this.Q = true;
        PanelFeatureState MyBillsEntityDataFactory = MyBillsEntityDataFactory(0, false);
        if (this.moveToNextValue) {
            return;
        }
        if (MyBillsEntityDataFactory == null || MyBillsEntityDataFactory.NetworkUserEntityData$$ExternalSyntheticLambda1 == null) {
            NetworkUserEntityData$$ExternalSyntheticLambda0(108);
        }
    }

    private ViewGroup FragmentBottomSheetPaymentSettingBinding() {
        ViewGroup viewGroup;
        Context context;
        TypedArray obtainStyledAttributes = this.NetworkUserEntityData$$ExternalSyntheticLambda0.obtainStyledAttributes(R.styleable.g);
        if (!obtainStyledAttributes.hasValue(R.styleable.i)) {
            obtainStyledAttributes.recycle();
            throw new IllegalStateException("You need to use a Theme.AppCompat theme (or descendant) with this activity.");
        }
        if (obtainStyledAttributes.getBoolean(R.styleable.DaggerUserBankCardComponent$UserBankCardComponentImpl$PostExecutionThreadProvider, false)) {
            MyBillsEntityDataFactory(1);
        } else if (obtainStyledAttributes.getBoolean(R.styleable.i, false)) {
            MyBillsEntityDataFactory(108);
        }
        if (obtainStyledAttributes.getBoolean(R.styleable.FlowViewUtil$textChanges$1, false)) {
            MyBillsEntityDataFactory(109);
        }
        if (obtainStyledAttributes.getBoolean(R.styleable.j, false)) {
            MyBillsEntityDataFactory(10);
        }
        this.GetContactSyncConfig = obtainStyledAttributes.getBoolean(R.styleable.FlowViewUtil$textChanges$2, false);
        obtainStyledAttributes.recycle();
        whenAvailable();
        this.PrepareContext.getDecorView();
        LayoutInflater from = LayoutInflater.from(this.NetworkUserEntityData$$ExternalSyntheticLambda0);
        if (!this.NetworkUserEntityData$$ExternalSyntheticLambda7) {
            if (this.GetContactSyncConfig) {
                viewGroup = (ViewGroup) from.inflate(R.layout.scheduleImpl, (ViewGroup) null);
                this.DatabaseTableConfigUtil = false;
                this.lookAheadTest = false;
            } else if (this.lookAheadTest) {
                TypedValue typedValue = new TypedValue();
                this.NetworkUserEntityData$$ExternalSyntheticLambda0.getTheme().resolveAttribute(R.attr.moveToNextValue, typedValue, true);
                if (typedValue.resourceId != 0) {
                    context = new androidx.appcompat.view.ContextThemeWrapper(this.NetworkUserEntityData$$ExternalSyntheticLambda0, typedValue.resourceId);
                } else {
                    context = this.NetworkUserEntityData$$ExternalSyntheticLambda0;
                }
                viewGroup = (ViewGroup) LayoutInflater.from(context).inflate(R.layout.isLayoutRequested, (ViewGroup) null);
                DecorContentParent decorContentParent = (DecorContentParent) viewGroup.findViewById(R.id.isLayoutRequested);
                this.E = decorContentParent;
                decorContentParent.setWindowCallback(newProxyInstance());
                if (this.DatabaseTableConfigUtil) {
                    this.E.initFeature(109);
                }
                if (this.H) {
                    this.E.initFeature(2);
                }
                if (this.D) {
                    this.E.initFeature(5);
                }
            } else {
                viewGroup = null;
            }
        } else {
            viewGroup = this.isLayoutRequested ? (ViewGroup) from.inflate(R.layout.PrepareContext, (ViewGroup) null) : (ViewGroup) from.inflate(R.layout.newProxyInstance, (ViewGroup) null);
        }
        if (viewGroup == null) {
            StringBuilder sb = new StringBuilder();
            sb.append("AppCompat does not support the current theme features: { windowActionBar: ");
            sb.append(this.lookAheadTest);
            sb.append(", windowActionBarOverlay: ");
            sb.append(this.DatabaseTableConfigUtil);
            sb.append(", android:windowIsFloating: ");
            sb.append(this.GetContactSyncConfig);
            sb.append(", windowActionModeOverlay: ");
            sb.append(this.isLayoutRequested);
            sb.append(", windowNoTitle: ");
            sb.append(this.NetworkUserEntityData$$ExternalSyntheticLambda7);
            sb.append(" }");
            throw new IllegalArgumentException(sb.toString());
        }
        if (Build.VERSION.SDK_INT >= 21) {
            ViewCompat.MyBillsEntityDataFactory(viewGroup, new OnApplyWindowInsetsListener() { // from class: androidx.appcompat.app.AppCompatDelegateImpl.3
                {
                    AppCompatDelegateImpl.this = this;
                }

                @Override // androidx.core.view.OnApplyWindowInsetsListener
                public WindowInsetsCompat onApplyWindowInsets(View view, WindowInsetsCompat windowInsetsCompat) {
                    int initRecordTimeStamp = windowInsetsCompat.initRecordTimeStamp();
                    int authRequestContext = AppCompatDelegateImpl.this.getAuthRequestContext(windowInsetsCompat, (Rect) null);
                    if (initRecordTimeStamp != authRequestContext) {
                        windowInsetsCompat = windowInsetsCompat.MyBillsEntityDataFactory(windowInsetsCompat.lookAheadTest(), authRequestContext, windowInsetsCompat.getErrorConfigVersion(), windowInsetsCompat.moveToNextValue());
                    }
                    return ViewCompat.KClassImpl$Data$declaredNonStaticMembers$2(view, windowInsetsCompat);
                }
            });
        } else if (viewGroup instanceof FitWindowsViewGroup) {
            ((FitWindowsViewGroup) viewGroup).setOnFitSystemWindowsListener(new FitWindowsViewGroup.OnFitSystemWindowsListener() { // from class: androidx.appcompat.app.AppCompatDelegateImpl.4
                {
                    AppCompatDelegateImpl.this = this;
                }

                @Override // androidx.appcompat.widget.FitWindowsViewGroup.OnFitSystemWindowsListener
                public void BuiltInFictitiousFunctionClassFactory(Rect rect) {
                    rect.top = AppCompatDelegateImpl.this.getAuthRequestContext((WindowInsetsCompat) null, rect);
                }
            });
        }
        if (this.E == null) {
            this.SummaryVoucherView$$ExternalSyntheticLambda1 = (TextView) viewGroup.findViewById(R.id.AppCompatEmojiTextHelper);
        }
        ViewUtils.PlaceComponentResult(viewGroup);
        ContentFrameLayout contentFrameLayout = (ContentFrameLayout) viewGroup.findViewById(R.id.getAuthRequestContext);
        ViewGroup viewGroup2 = (ViewGroup) this.PrepareContext.findViewById(16908290);
        if (viewGroup2 != null) {
            while (viewGroup2.getChildCount() > 0) {
                View childAt = viewGroup2.getChildAt(0);
                viewGroup2.removeViewAt(0);
                contentFrameLayout.addView(childAt);
            }
            viewGroup2.setId(-1);
            contentFrameLayout.setId(16908290);
            if (viewGroup2 instanceof FrameLayout) {
                ((FrameLayout) viewGroup2).setForeground(null);
            }
        }
        this.PrepareContext.setContentView(viewGroup);
        contentFrameLayout.setAttachListener(new ContentFrameLayout.OnAttachListener() { // from class: androidx.appcompat.app.AppCompatDelegateImpl.5
            @Override // androidx.appcompat.widget.ContentFrameLayout.OnAttachListener
            public void BuiltInFictitiousFunctionClassFactory() {
            }

            {
                AppCompatDelegateImpl.this = this;
            }

            @Override // androidx.appcompat.widget.ContentFrameLayout.OnAttachListener
            public void PlaceComponentResult() {
                AppCompatDelegateImpl.this.DatabaseTableConfigUtil();
            }
        });
        return viewGroup;
    }

    private void NetworkUserEntityData$$ExternalSyntheticLambda4() {
        ContentFrameLayout contentFrameLayout = (ContentFrameLayout) this.NetworkUserEntityData$$ExternalSyntheticLambda8.findViewById(16908290);
        View decorView = this.PrepareContext.getDecorView();
        contentFrameLayout.setDecorPadding(decorView.getPaddingLeft(), decorView.getPaddingTop(), decorView.getPaddingRight(), decorView.getPaddingBottom());
        TypedArray obtainStyledAttributes = this.NetworkUserEntityData$$ExternalSyntheticLambda0.obtainStyledAttributes(R.styleable.g);
        obtainStyledAttributes.getValue(R.styleable.f5938o, contentFrameLayout.getMinWidthMajor());
        obtainStyledAttributes.getValue(R.styleable.p, contentFrameLayout.getMinWidthMinor());
        if (obtainStyledAttributes.hasValue(R.styleable.access$throwIllegalArgumentType)) {
            obtainStyledAttributes.getValue(R.styleable.access$throwIllegalArgumentType, contentFrameLayout.getFixedWidthMajor());
        }
        if (obtainStyledAttributes.hasValue(R.styleable.m)) {
            obtainStyledAttributes.getValue(R.styleable.m, contentFrameLayout.getFixedWidthMinor());
        }
        if (obtainStyledAttributes.hasValue(R.styleable.l)) {
            obtainStyledAttributes.getValue(R.styleable.l, contentFrameLayout.getFixedHeightMajor());
        }
        if (obtainStyledAttributes.hasValue(R.styleable.k)) {
            obtainStyledAttributes.getValue(R.styleable.k, contentFrameLayout.getFixedHeightMinor());
        }
        obtainStyledAttributes.recycle();
        contentFrameLayout.requestLayout();
    }

    @Override // androidx.appcompat.app.AppCompatDelegate
    public boolean MyBillsEntityDataFactory(int i) {
        int errorConfigVersion = getErrorConfigVersion(i);
        if (this.NetworkUserEntityData$$ExternalSyntheticLambda7 && errorConfigVersion == 108) {
            return false;
        }
        if (this.lookAheadTest && errorConfigVersion == 1) {
            this.lookAheadTest = false;
        }
        if (errorConfigVersion == 1) {
            getSupportButtonTintMode();
            this.NetworkUserEntityData$$ExternalSyntheticLambda7 = true;
            return true;
        } else if (errorConfigVersion == 2) {
            getSupportButtonTintMode();
            this.H = true;
            return true;
        } else if (errorConfigVersion == 5) {
            getSupportButtonTintMode();
            this.D = true;
            return true;
        } else if (errorConfigVersion == 10) {
            getSupportButtonTintMode();
            this.isLayoutRequested = true;
            return true;
        } else if (errorConfigVersion == 108) {
            getSupportButtonTintMode();
            this.lookAheadTest = true;
            return true;
        } else if (errorConfigVersion == 109) {
            getSupportButtonTintMode();
            this.DatabaseTableConfigUtil = true;
            return true;
        } else {
            return this.PrepareContext.requestFeature(errorConfigVersion);
        }
    }

    @Override // androidx.appcompat.app.AppCompatDelegate
    public final void KClassImpl$Data$declaredNonStaticMembers$2(CharSequence charSequence) {
        this.N = charSequence;
        DecorContentParent decorContentParent = this.E;
        if (decorContentParent != null) {
            decorContentParent.setWindowTitle(charSequence);
        } else if (PrepareContext() != null) {
            PrepareContext().KClassImpl$Data$declaredNonStaticMembers$2(charSequence);
        } else {
            TextView textView = this.SummaryVoucherView$$ExternalSyntheticLambda1;
            if (textView != null) {
                textView.setText(charSequence);
            }
        }
    }

    final CharSequence NetworkUserEntityData$$ExternalSyntheticLambda8() {
        Object obj = this.scheduleImpl;
        if (obj instanceof Activity) {
            return ((Activity) obj).getTitle();
        }
        return this.N;
    }

    void lookAheadTest(int i) {
        if (i == 108) {
            ActionBar KClassImpl$Data$declaredNonStaticMembers$2 = KClassImpl$Data$declaredNonStaticMembers$2();
            if (KClassImpl$Data$declaredNonStaticMembers$2 != null) {
                KClassImpl$Data$declaredNonStaticMembers$2.PlaceComponentResult(false);
            }
        } else if (i == 0) {
            PanelFeatureState MyBillsEntityDataFactory = MyBillsEntityDataFactory(i, true);
            if (MyBillsEntityDataFactory.scheduleImpl) {
                getAuthRequestContext(MyBillsEntityDataFactory, false);
            }
        }
    }

    void moveToNextValue(int i) {
        ActionBar KClassImpl$Data$declaredNonStaticMembers$2;
        if (i != 108 || (KClassImpl$Data$declaredNonStaticMembers$2 = KClassImpl$Data$declaredNonStaticMembers$2()) == null) {
            return;
        }
        KClassImpl$Data$declaredNonStaticMembers$2.PlaceComponentResult(true);
    }

    @Override // androidx.appcompat.view.menu.MenuBuilder.Callback
    public boolean onMenuItemSelected(MenuBuilder menuBuilder, MenuItem menuItem) {
        PanelFeatureState BuiltInFictitiousFunctionClassFactory;
        Window.Callback newProxyInstance = newProxyInstance();
        if (newProxyInstance == null || this.moveToNextValue || (BuiltInFictitiousFunctionClassFactory = BuiltInFictitiousFunctionClassFactory(menuBuilder.getRootMenu())) == null) {
            return false;
        }
        return newProxyInstance.onMenuItemSelected(BuiltInFictitiousFunctionClassFactory.MyBillsEntityDataFactory, menuItem);
    }

    @Override // androidx.appcompat.view.menu.MenuBuilder.Callback
    public void onMenuModeChange(MenuBuilder menuBuilder) {
        KClassImpl$Data$declaredNonStaticMembers$2(true);
    }

    @Override // androidx.appcompat.app.AppCompatDelegate
    public ActionMode PlaceComponentResult(ActionMode.Callback callback) {
        AppCompatCallback appCompatCallback;
        if (callback == null) {
            throw new IllegalArgumentException("ActionMode callback can not be null.");
        }
        ActionMode actionMode = this.PlaceComponentResult;
        if (actionMode != null) {
            actionMode.BuiltInFictitiousFunctionClassFactory();
        }
        ActionModeCallbackWrapperV9 actionModeCallbackWrapperV9 = new ActionModeCallbackWrapperV9(callback);
        ActionBar KClassImpl$Data$declaredNonStaticMembers$2 = KClassImpl$Data$declaredNonStaticMembers$2();
        if (KClassImpl$Data$declaredNonStaticMembers$2 != null) {
            ActionMode KClassImpl$Data$declaredNonStaticMembers$22 = KClassImpl$Data$declaredNonStaticMembers$2.KClassImpl$Data$declaredNonStaticMembers$2(actionModeCallbackWrapperV9);
            this.PlaceComponentResult = KClassImpl$Data$declaredNonStaticMembers$22;
            if (KClassImpl$Data$declaredNonStaticMembers$22 != null && (appCompatCallback = this.KClassImpl$Data$declaredNonStaticMembers$2) != null) {
                appCompatCallback.onSupportActionModeStarted(KClassImpl$Data$declaredNonStaticMembers$22);
            }
        }
        if (this.PlaceComponentResult == null) {
            this.PlaceComponentResult = KClassImpl$Data$declaredNonStaticMembers$2(actionModeCallbackWrapperV9);
        }
        return this.PlaceComponentResult;
    }

    @Override // androidx.appcompat.app.AppCompatDelegate
    public void scheduleImpl() {
        if (PrepareContext() == null || KClassImpl$Data$declaredNonStaticMembers$2().lookAheadTest()) {
            return;
        }
        NetworkUserEntityData$$ExternalSyntheticLambda0(0);
    }

    /* JADX WARN: Removed duplicated region for block: B:72:0x0025  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x0029  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    androidx.appcompat.view.ActionMode KClassImpl$Data$declaredNonStaticMembers$2(androidx.appcompat.view.ActionMode.Callback r8) {
        /*
            Method dump skipped, instructions count: 360
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.app.AppCompatDelegateImpl.KClassImpl$Data$declaredNonStaticMembers$2(androidx.appcompat.view.ActionMode$Callback):androidx.appcompat.view.ActionMode");
    }

    final boolean NetworkUserEntityData$$ExternalSyntheticLambda5() {
        ViewGroup viewGroup;
        return this.Q && (viewGroup = this.NetworkUserEntityData$$ExternalSyntheticLambda8) != null && ViewCompat.getValueOfTouchPositionAbsolute(viewGroup);
    }

    public boolean NetworkUserEntityData$$ExternalSyntheticLambda7() {
        return this.F;
    }

    void NetworkUserEntityData$$ExternalSyntheticLambda1() {
        ViewPropertyAnimatorCompat viewPropertyAnimatorCompat = this.getErrorConfigVersion;
        if (viewPropertyAnimatorCompat != null) {
            viewPropertyAnimatorCompat.BuiltInFictitiousFunctionClassFactory();
        }
    }

    boolean isLayoutRequested() {
        ActionMode actionMode = this.PlaceComponentResult;
        if (actionMode != null) {
            actionMode.BuiltInFictitiousFunctionClassFactory();
            return true;
        }
        ActionBar KClassImpl$Data$declaredNonStaticMembers$2 = KClassImpl$Data$declaredNonStaticMembers$2();
        return KClassImpl$Data$declaredNonStaticMembers$2 != null && KClassImpl$Data$declaredNonStaticMembers$2.MyBillsEntityDataFactory();
    }

    boolean PlaceComponentResult(int i, KeyEvent keyEvent) {
        ActionBar KClassImpl$Data$declaredNonStaticMembers$2 = KClassImpl$Data$declaredNonStaticMembers$2();
        if (KClassImpl$Data$declaredNonStaticMembers$2 == null || !KClassImpl$Data$declaredNonStaticMembers$2.KClassImpl$Data$declaredNonStaticMembers$2(i, keyEvent)) {
            PanelFeatureState panelFeatureState = this.getNameOrBuilderList;
            if (panelFeatureState != null && getAuthRequestContext(panelFeatureState, keyEvent.getKeyCode(), keyEvent, 1)) {
                PanelFeatureState panelFeatureState2 = this.getNameOrBuilderList;
                if (panelFeatureState2 != null) {
                    panelFeatureState2.NetworkUserEntityData$$ExternalSyntheticLambda0 = true;
                }
                return true;
            }
            if (this.getNameOrBuilderList == null) {
                PanelFeatureState MyBillsEntityDataFactory = MyBillsEntityDataFactory(0, true);
                BuiltInFictitiousFunctionClassFactory(MyBillsEntityDataFactory, keyEvent);
                boolean authRequestContext = getAuthRequestContext(MyBillsEntityDataFactory, keyEvent.getKeyCode(), keyEvent, 1);
                MyBillsEntityDataFactory.moveToNextValue = false;
                if (authRequestContext) {
                    return true;
                }
            }
            return false;
        }
        return true;
    }

    boolean getAuthRequestContext(KeyEvent keyEvent) {
        View decorView;
        boolean BuiltInFictitiousFunctionClassFactory;
        Object obj = this.scheduleImpl;
        if (((obj instanceof KeyEventDispatcher.Component) || (obj instanceof AppCompatDialog)) && (decorView = this.PrepareContext.getDecorView()) != null) {
            BuiltInFictitiousFunctionClassFactory = ViewCompat.BuiltInFictitiousFunctionClassFactory(decorView, keyEvent);
            if (BuiltInFictitiousFunctionClassFactory) {
                return true;
            }
        }
        if (keyEvent.getKeyCode() == 82 && this.C.MyBillsEntityDataFactory(this.PrepareContext.getCallback(), keyEvent)) {
            return true;
        }
        int keyCode = keyEvent.getKeyCode();
        return keyEvent.getAction() == 0 ? KClassImpl$Data$declaredNonStaticMembers$2(keyCode, keyEvent) : BuiltInFictitiousFunctionClassFactory(keyCode, keyEvent);
    }

    boolean BuiltInFictitiousFunctionClassFactory(int i, KeyEvent keyEvent) {
        if (i == 4) {
            boolean z = this.J;
            this.J = false;
            PanelFeatureState MyBillsEntityDataFactory = MyBillsEntityDataFactory(0, false);
            if (MyBillsEntityDataFactory != null && MyBillsEntityDataFactory.scheduleImpl) {
                if (!z) {
                    getAuthRequestContext(MyBillsEntityDataFactory, true);
                }
                return true;
            } else if (isLayoutRequested()) {
                return true;
            }
        } else if (i == 82) {
            getAuthRequestContext(0, keyEvent);
            return true;
        }
        return false;
    }

    boolean KClassImpl$Data$declaredNonStaticMembers$2(int i, KeyEvent keyEvent) {
        if (i == 4) {
            this.J = (keyEvent.getFlags() & 128) != 0;
        } else if (i == 82) {
            MyBillsEntityDataFactory(0, keyEvent);
            return true;
        }
        return false;
    }

    /* JADX WARN: Code restructure failed: missing block: B:53:0x0080, code lost:
    
        if (((org.xmlpull.v1.XmlPullParser) r15).getDepth() > 1) goto L49;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public android.view.View getAuthRequestContext(android.view.View r12, java.lang.String r13, android.content.Context r14, android.util.AttributeSet r15) {
        /*
            r11 = this;
            androidx.appcompat.app.AppCompatViewInflater r0 = r11.readMicros
            r1 = 0
            if (r0 != 0) goto L5b
            android.content.Context r0 = r11.NetworkUserEntityData$$ExternalSyntheticLambda0
            int[] r2 = androidx.appcompat.R.styleable.g
            android.content.res.TypedArray r0 = r0.obtainStyledAttributes(r2)
            int r2 = androidx.appcompat.R.styleable.h
            java.lang.String r0 = r0.getString(r2)
            if (r0 != 0) goto L1d
            androidx.appcompat.app.AppCompatViewInflater r0 = new androidx.appcompat.app.AppCompatViewInflater
            r0.<init>()
            r11.readMicros = r0
            goto L5b
        L1d:
            android.content.Context r2 = r11.NetworkUserEntityData$$ExternalSyntheticLambda0     // Catch: java.lang.Throwable -> L38
            java.lang.ClassLoader r2 = r2.getClassLoader()     // Catch: java.lang.Throwable -> L38
            java.lang.Class r2 = r2.loadClass(r0)     // Catch: java.lang.Throwable -> L38
            java.lang.Class[] r3 = new java.lang.Class[r1]     // Catch: java.lang.Throwable -> L38
            java.lang.reflect.Constructor r2 = r2.getDeclaredConstructor(r3)     // Catch: java.lang.Throwable -> L38
            java.lang.Object[] r3 = new java.lang.Object[r1]     // Catch: java.lang.Throwable -> L38
            java.lang.Object r2 = r2.newInstance(r3)     // Catch: java.lang.Throwable -> L38
            androidx.appcompat.app.AppCompatViewInflater r2 = (androidx.appcompat.app.AppCompatViewInflater) r2     // Catch: java.lang.Throwable -> L38
            r11.readMicros = r2     // Catch: java.lang.Throwable -> L38
            goto L5b
        L38:
            r2 = move-exception
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r4 = "Failed to instantiate custom view inflater "
            r3.append(r4)
            r3.append(r0)
            java.lang.String r0 = ". Falling back to default."
            r3.append(r0)
            java.lang.String r0 = r3.toString()
            java.lang.String r3 = "AppCompatDelegate"
            com.fullstory.instrumentation.InstrumentInjector.log_i(r3, r0, r2)
            androidx.appcompat.app.AppCompatViewInflater r0 = new androidx.appcompat.app.AppCompatViewInflater
            r0.<init>()
            r11.readMicros = r0
        L5b:
            boolean r8 = androidx.appcompat.app.AppCompatDelegateImpl.NetworkUserEntityData$$ExternalSyntheticLambda6
            r0 = 1
            if (r8 == 0) goto L8c
            androidx.appcompat.app.LayoutIncludeDetector r2 = r11.AppCompatEmojiTextHelper
            if (r2 != 0) goto L6b
            androidx.appcompat.app.LayoutIncludeDetector r2 = new androidx.appcompat.app.LayoutIncludeDetector
            r2.<init>()
            r11.AppCompatEmojiTextHelper = r2
        L6b:
            androidx.appcompat.app.LayoutIncludeDetector r2 = r11.AppCompatEmojiTextHelper
            boolean r2 = r2.BuiltInFictitiousFunctionClassFactory(r15)
            if (r2 == 0) goto L75
        L73:
            r7 = 1
            goto L8d
        L75:
            boolean r2 = r15 instanceof org.xmlpull.v1.XmlPullParser
            if (r2 == 0) goto L83
            r2 = r15
            org.xmlpull.v1.XmlPullParser r2 = (org.xmlpull.v1.XmlPullParser) r2
            int r2 = r2.getDepth()
            if (r2 <= r0) goto L8a
            goto L73
        L83:
            r0 = r12
            android.view.ViewParent r0 = (android.view.ViewParent) r0
            boolean r1 = r11.BuiltInFictitiousFunctionClassFactory(r0)
        L8a:
            r7 = r1
            goto L8d
        L8c:
            r7 = 0
        L8d:
            androidx.appcompat.app.AppCompatViewInflater r2 = r11.readMicros
            boolean r10 = androidx.appcompat.widget.VectorEnabledTintResources.getAuthRequestContext()
            r9 = 1
            r3 = r12
            r4 = r13
            r5 = r14
            r6 = r15
            android.view.View r12 = r2.createView(r3, r4, r5, r6, r7, r8, r9, r10)
            return r12
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.app.AppCompatDelegateImpl.getAuthRequestContext(android.view.View, java.lang.String, android.content.Context, android.util.AttributeSet):android.view.View");
    }

    private boolean BuiltInFictitiousFunctionClassFactory(ViewParent viewParent) {
        if (viewParent == null) {
            return false;
        }
        View decorView = this.PrepareContext.getDecorView();
        while (viewParent != null) {
            if (viewParent == decorView || !(viewParent instanceof View) || ViewCompat.C((View) viewParent)) {
                return false;
            }
            viewParent = viewParent.getParent();
        }
        return true;
    }

    @Override // androidx.appcompat.app.AppCompatDelegate
    public void NetworkUserEntityData$$ExternalSyntheticLambda0() {
        LayoutInflater from = LayoutInflater.from(this.NetworkUserEntityData$$ExternalSyntheticLambda0);
        if (from.getFactory() == null) {
            LayoutInflaterCompat.BuiltInFictitiousFunctionClassFactory(from, this);
        } else if (from.getFactory2() instanceof AppCompatDelegateImpl) {
        } else {
            InstrumentInjector.log_i("AppCompatDelegate", "The Activity's LayoutInflater already has a Factory installed so we can not install AppCompat's");
        }
    }

    @Override // android.view.LayoutInflater.Factory2
    public final View onCreateView(View view, String str, Context context, AttributeSet attributeSet) {
        return getAuthRequestContext(view, str, context, attributeSet);
    }

    @Override // android.view.LayoutInflater.Factory
    public View onCreateView(String str, Context context, AttributeSet attributeSet) {
        return onCreateView(null, str, context, attributeSet);
    }

    private AppCompatActivity SubSequence() {
        for (Context context = this.NetworkUserEntityData$$ExternalSyntheticLambda0; context != null; context = ((ContextWrapper) context).getBaseContext()) {
            if (context instanceof AppCompatActivity) {
                return (AppCompatActivity) context;
            }
            if (!(context instanceof ContextWrapper)) {
                return null;
            }
        }
        return null;
    }

    private void getAuthRequestContext(PanelFeatureState panelFeatureState, KeyEvent keyEvent) {
        int i;
        ViewGroup.LayoutParams layoutParams;
        if (panelFeatureState.scheduleImpl || this.moveToNextValue) {
            return;
        }
        if (panelFeatureState.MyBillsEntityDataFactory == 0) {
            if ((this.NetworkUserEntityData$$ExternalSyntheticLambda0.getResources().getConfiguration().screenLayout & 15) == 4) {
                return;
            }
        }
        Window.Callback newProxyInstance = newProxyInstance();
        if (newProxyInstance != null && !newProxyInstance.onMenuOpened(panelFeatureState.MyBillsEntityDataFactory, panelFeatureState.NetworkUserEntityData$$ExternalSyntheticLambda1)) {
            getAuthRequestContext(panelFeatureState, true);
            return;
        }
        WindowManager windowManager = (WindowManager) this.NetworkUserEntityData$$ExternalSyntheticLambda0.getSystemService("window");
        if (windowManager != null && BuiltInFictitiousFunctionClassFactory(panelFeatureState, keyEvent)) {
            if (panelFeatureState.BuiltInFictitiousFunctionClassFactory == null || panelFeatureState.initRecordTimeStamp) {
                if (panelFeatureState.BuiltInFictitiousFunctionClassFactory == null) {
                    if (!KClassImpl$Data$declaredNonStaticMembers$2(panelFeatureState) || panelFeatureState.BuiltInFictitiousFunctionClassFactory == null) {
                        return;
                    }
                } else if (panelFeatureState.initRecordTimeStamp && panelFeatureState.BuiltInFictitiousFunctionClassFactory.getChildCount() > 0) {
                    panelFeatureState.BuiltInFictitiousFunctionClassFactory.removeAllViews();
                }
                if (!PlaceComponentResult(panelFeatureState) || !panelFeatureState.MyBillsEntityDataFactory()) {
                    panelFeatureState.initRecordTimeStamp = true;
                    return;
                }
                ViewGroup.LayoutParams layoutParams2 = panelFeatureState.NetworkUserEntityData$$ExternalSyntheticLambda7.getLayoutParams();
                if (layoutParams2 == null) {
                    layoutParams2 = new ViewGroup.LayoutParams(-2, -2);
                }
                panelFeatureState.BuiltInFictitiousFunctionClassFactory.setBackgroundResource(panelFeatureState.KClassImpl$Data$declaredNonStaticMembers$2);
                ViewParent parent = panelFeatureState.NetworkUserEntityData$$ExternalSyntheticLambda7.getParent();
                if (parent instanceof ViewGroup) {
                    ((ViewGroup) parent).removeView(panelFeatureState.NetworkUserEntityData$$ExternalSyntheticLambda7);
                }
                panelFeatureState.BuiltInFictitiousFunctionClassFactory.addView(panelFeatureState.NetworkUserEntityData$$ExternalSyntheticLambda7, layoutParams2);
                if (!panelFeatureState.NetworkUserEntityData$$ExternalSyntheticLambda7.hasFocus()) {
                    panelFeatureState.NetworkUserEntityData$$ExternalSyntheticLambda7.requestFocus();
                }
            } else if (panelFeatureState.getAuthRequestContext != null && (layoutParams = panelFeatureState.getAuthRequestContext.getLayoutParams()) != null && layoutParams.width == -1) {
                i = -1;
                panelFeatureState.NetworkUserEntityData$$ExternalSyntheticLambda0 = false;
                WindowManager.LayoutParams layoutParams3 = new WindowManager.LayoutParams(i, -2, panelFeatureState.NetworkUserEntityData$$ExternalSyntheticLambda8, panelFeatureState.isLayoutRequested, 1002, 8519680, -3);
                layoutParams3.gravity = panelFeatureState.lookAheadTest;
                layoutParams3.windowAnimations = panelFeatureState.PrepareContext;
                windowManager.addView(panelFeatureState.BuiltInFictitiousFunctionClassFactory, layoutParams3);
                panelFeatureState.scheduleImpl = true;
            }
            i = -2;
            panelFeatureState.NetworkUserEntityData$$ExternalSyntheticLambda0 = false;
            WindowManager.LayoutParams layoutParams32 = new WindowManager.LayoutParams(i, -2, panelFeatureState.NetworkUserEntityData$$ExternalSyntheticLambda8, panelFeatureState.isLayoutRequested, 1002, 8519680, -3);
            layoutParams32.gravity = panelFeatureState.lookAheadTest;
            layoutParams32.windowAnimations = panelFeatureState.PrepareContext;
            windowManager.addView(panelFeatureState.BuiltInFictitiousFunctionClassFactory, layoutParams32);
            panelFeatureState.scheduleImpl = true;
        }
    }

    private boolean KClassImpl$Data$declaredNonStaticMembers$2(PanelFeatureState panelFeatureState) {
        panelFeatureState.KClassImpl$Data$declaredNonStaticMembers$2(initRecordTimeStamp());
        panelFeatureState.BuiltInFictitiousFunctionClassFactory = new ListMenuDecorView(panelFeatureState.NetworkUserEntityData$$ExternalSyntheticLambda2);
        panelFeatureState.lookAheadTest = 81;
        return true;
    }

    private void KClassImpl$Data$declaredNonStaticMembers$2(boolean z) {
        DecorContentParent decorContentParent = this.E;
        if (decorContentParent != null && decorContentParent.canShowOverflowMenu() && (!ViewConfiguration.get(this.NetworkUserEntityData$$ExternalSyntheticLambda0).hasPermanentMenuKey() || this.E.isOverflowMenuShowPending())) {
            Window.Callback newProxyInstance = newProxyInstance();
            if (!this.E.isOverflowMenuShowing() || !z) {
                if (newProxyInstance == null || this.moveToNextValue) {
                    return;
                }
                if (this.initRecordTimeStamp && (this.NetworkUserEntityData$$ExternalSyntheticLambda1 & 1) != 0) {
                    this.PrepareContext.getDecorView().removeCallbacks(this.G);
                    this.G.run();
                }
                PanelFeatureState MyBillsEntityDataFactory = MyBillsEntityDataFactory(0, true);
                if (MyBillsEntityDataFactory.NetworkUserEntityData$$ExternalSyntheticLambda1 == null || MyBillsEntityDataFactory.DatabaseTableConfigUtil || !newProxyInstance.onPreparePanel(0, MyBillsEntityDataFactory.getAuthRequestContext, MyBillsEntityDataFactory.NetworkUserEntityData$$ExternalSyntheticLambda1)) {
                    return;
                }
                newProxyInstance.onMenuOpened(108, MyBillsEntityDataFactory.NetworkUserEntityData$$ExternalSyntheticLambda1);
                this.E.showOverflowMenu();
                return;
            }
            this.E.hideOverflowMenu();
            if (this.moveToNextValue) {
                return;
            }
            newProxyInstance.onPanelClosed(108, MyBillsEntityDataFactory(0, true).NetworkUserEntityData$$ExternalSyntheticLambda1);
            return;
        }
        PanelFeatureState MyBillsEntityDataFactory2 = MyBillsEntityDataFactory(0, true);
        MyBillsEntityDataFactory2.initRecordTimeStamp = true;
        getAuthRequestContext(MyBillsEntityDataFactory2, false);
        getAuthRequestContext(MyBillsEntityDataFactory2, (KeyEvent) null);
    }

    private boolean getAuthRequestContext(PanelFeatureState panelFeatureState) {
        Context context = this.NetworkUserEntityData$$ExternalSyntheticLambda0;
        if ((panelFeatureState.MyBillsEntityDataFactory == 0 || panelFeatureState.MyBillsEntityDataFactory == 108) && this.E != null) {
            TypedValue typedValue = new TypedValue();
            Resources.Theme theme = context.getTheme();
            theme.resolveAttribute(R.attr.moveToNextValue, typedValue, true);
            Resources.Theme theme2 = null;
            if (typedValue.resourceId != 0) {
                theme2 = context.getResources().newTheme();
                theme2.setTo(theme);
                theme2.applyStyle(typedValue.resourceId, true);
                theme2.resolveAttribute(R.attr.lookAheadTest, typedValue, true);
            } else {
                theme.resolveAttribute(R.attr.lookAheadTest, typedValue, true);
            }
            if (typedValue.resourceId != 0) {
                if (theme2 == null) {
                    theme2 = context.getResources().newTheme();
                    theme2.setTo(theme);
                }
                theme2.applyStyle(typedValue.resourceId, true);
            }
            if (theme2 != null) {
                androidx.appcompat.view.ContextThemeWrapper contextThemeWrapper = new androidx.appcompat.view.ContextThemeWrapper(context, 0);
                contextThemeWrapper.getTheme().setTo(theme2);
                context = contextThemeWrapper;
            }
        }
        MenuBuilder menuBuilder = new MenuBuilder(context);
        menuBuilder.setCallback(this);
        panelFeatureState.KClassImpl$Data$declaredNonStaticMembers$2(menuBuilder);
        return true;
    }

    private boolean PlaceComponentResult(PanelFeatureState panelFeatureState) {
        if (panelFeatureState.getAuthRequestContext != null) {
            panelFeatureState.NetworkUserEntityData$$ExternalSyntheticLambda7 = panelFeatureState.getAuthRequestContext;
            return true;
        } else if (panelFeatureState.NetworkUserEntityData$$ExternalSyntheticLambda1 == null) {
            return false;
        } else {
            if (this.M == null) {
                this.M = new PanelMenuPresenterCallback();
            }
            panelFeatureState.NetworkUserEntityData$$ExternalSyntheticLambda7 = (View) panelFeatureState.getAuthRequestContext(this.M);
            return panelFeatureState.NetworkUserEntityData$$ExternalSyntheticLambda7 != null;
        }
    }

    private boolean BuiltInFictitiousFunctionClassFactory(PanelFeatureState panelFeatureState, KeyEvent keyEvent) {
        DecorContentParent decorContentParent;
        DecorContentParent decorContentParent2;
        DecorContentParent decorContentParent3;
        if (this.moveToNextValue) {
            return false;
        }
        if (panelFeatureState.moveToNextValue) {
            return true;
        }
        PanelFeatureState panelFeatureState2 = this.getNameOrBuilderList;
        if (panelFeatureState2 != null && panelFeatureState2 != panelFeatureState) {
            getAuthRequestContext(panelFeatureState2, false);
        }
        Window.Callback newProxyInstance = newProxyInstance();
        if (newProxyInstance != null) {
            panelFeatureState.getAuthRequestContext = newProxyInstance.onCreatePanelView(panelFeatureState.MyBillsEntityDataFactory);
        }
        boolean z = panelFeatureState.MyBillsEntityDataFactory == 0 || panelFeatureState.MyBillsEntityDataFactory == 108;
        if (z && (decorContentParent3 = this.E) != null) {
            decorContentParent3.setMenuPrepared();
        }
        if (panelFeatureState.getAuthRequestContext == null && (!z || !(PrepareContext() instanceof ToolbarActionBar))) {
            if (panelFeatureState.NetworkUserEntityData$$ExternalSyntheticLambda1 == null || panelFeatureState.DatabaseTableConfigUtil) {
                if (panelFeatureState.NetworkUserEntityData$$ExternalSyntheticLambda1 == null && (!getAuthRequestContext(panelFeatureState) || panelFeatureState.NetworkUserEntityData$$ExternalSyntheticLambda1 == null)) {
                    return false;
                }
                if (z && this.E != null) {
                    if (this.whenAvailable == null) {
                        this.whenAvailable = new ActionMenuPresenterCallback();
                    }
                    this.E.setMenu(panelFeatureState.NetworkUserEntityData$$ExternalSyntheticLambda1, this.whenAvailable);
                }
                panelFeatureState.NetworkUserEntityData$$ExternalSyntheticLambda1.stopDispatchingItemsChanged();
                if (!newProxyInstance.onCreatePanelMenu(panelFeatureState.MyBillsEntityDataFactory, panelFeatureState.NetworkUserEntityData$$ExternalSyntheticLambda1)) {
                    panelFeatureState.KClassImpl$Data$declaredNonStaticMembers$2((MenuBuilder) null);
                    if (z && (decorContentParent = this.E) != null) {
                        decorContentParent.setMenu(null, this.whenAvailable);
                    }
                    return false;
                }
                panelFeatureState.DatabaseTableConfigUtil = false;
            }
            panelFeatureState.NetworkUserEntityData$$ExternalSyntheticLambda1.stopDispatchingItemsChanged();
            if (panelFeatureState.PlaceComponentResult != null) {
                panelFeatureState.NetworkUserEntityData$$ExternalSyntheticLambda1.restoreActionViewStates(panelFeatureState.PlaceComponentResult);
                panelFeatureState.PlaceComponentResult = null;
            }
            if (!newProxyInstance.onPreparePanel(0, panelFeatureState.getAuthRequestContext, panelFeatureState.NetworkUserEntityData$$ExternalSyntheticLambda1)) {
                if (z && (decorContentParent2 = this.E) != null) {
                    decorContentParent2.setMenu(null, this.whenAvailable);
                }
                panelFeatureState.NetworkUserEntityData$$ExternalSyntheticLambda1.startDispatchingItemsChanged();
                return false;
            }
            panelFeatureState.GetContactSyncConfig = KeyCharacterMap.load(keyEvent != null ? keyEvent.getDeviceId() : -1).getKeyboardType() != 1;
            panelFeatureState.NetworkUserEntityData$$ExternalSyntheticLambda1.setQwertyMode(panelFeatureState.GetContactSyncConfig);
            panelFeatureState.NetworkUserEntityData$$ExternalSyntheticLambda1.startDispatchingItemsChanged();
        }
        panelFeatureState.moveToNextValue = true;
        panelFeatureState.NetworkUserEntityData$$ExternalSyntheticLambda0 = false;
        this.getNameOrBuilderList = panelFeatureState;
        return true;
    }

    void getAuthRequestContext(MenuBuilder menuBuilder) {
        if (this.A) {
            return;
        }
        this.A = true;
        this.E.dismissPopups();
        Window.Callback newProxyInstance = newProxyInstance();
        if (newProxyInstance != null && !this.moveToNextValue) {
            newProxyInstance.onPanelClosed(108, menuBuilder);
        }
        this.A = false;
    }

    void KClassImpl$Data$declaredNonStaticMembers$2(int i) {
        getAuthRequestContext(MyBillsEntityDataFactory(i, true), true);
    }

    void getAuthRequestContext(PanelFeatureState panelFeatureState, boolean z) {
        DecorContentParent decorContentParent;
        if (z && panelFeatureState.MyBillsEntityDataFactory == 0 && (decorContentParent = this.E) != null && decorContentParent.isOverflowMenuShowing()) {
            getAuthRequestContext(panelFeatureState.NetworkUserEntityData$$ExternalSyntheticLambda1);
            return;
        }
        WindowManager windowManager = (WindowManager) this.NetworkUserEntityData$$ExternalSyntheticLambda0.getSystemService("window");
        if (windowManager != null && panelFeatureState.scheduleImpl && panelFeatureState.BuiltInFictitiousFunctionClassFactory != null) {
            windowManager.removeView(panelFeatureState.BuiltInFictitiousFunctionClassFactory);
            if (z) {
                PlaceComponentResult(panelFeatureState.MyBillsEntityDataFactory, panelFeatureState, null);
            }
        }
        panelFeatureState.moveToNextValue = false;
        panelFeatureState.NetworkUserEntityData$$ExternalSyntheticLambda0 = false;
        panelFeatureState.scheduleImpl = false;
        panelFeatureState.NetworkUserEntityData$$ExternalSyntheticLambda7 = null;
        panelFeatureState.initRecordTimeStamp = true;
        if (this.getNameOrBuilderList == panelFeatureState) {
            this.getNameOrBuilderList = null;
        }
    }

    private boolean MyBillsEntityDataFactory(int i, KeyEvent keyEvent) {
        if (keyEvent.getRepeatCount() == 0) {
            PanelFeatureState MyBillsEntityDataFactory = MyBillsEntityDataFactory(i, true);
            if (MyBillsEntityDataFactory.scheduleImpl) {
                return false;
            }
            return BuiltInFictitiousFunctionClassFactory(MyBillsEntityDataFactory, keyEvent);
        }
        return false;
    }

    private boolean getAuthRequestContext(int i, KeyEvent keyEvent) {
        boolean z;
        DecorContentParent decorContentParent;
        if (this.PlaceComponentResult != null) {
            return false;
        }
        boolean z2 = true;
        PanelFeatureState MyBillsEntityDataFactory = MyBillsEntityDataFactory(i, true);
        if (i == 0 && (decorContentParent = this.E) != null && decorContentParent.canShowOverflowMenu() && !ViewConfiguration.get(this.NetworkUserEntityData$$ExternalSyntheticLambda0).hasPermanentMenuKey()) {
            if (!this.E.isOverflowMenuShowing()) {
                if (!this.moveToNextValue && BuiltInFictitiousFunctionClassFactory(MyBillsEntityDataFactory, keyEvent)) {
                    z2 = this.E.showOverflowMenu();
                }
                z2 = false;
            } else {
                z2 = this.E.hideOverflowMenu();
            }
        } else if (MyBillsEntityDataFactory.scheduleImpl || MyBillsEntityDataFactory.NetworkUserEntityData$$ExternalSyntheticLambda0) {
            boolean z3 = MyBillsEntityDataFactory.scheduleImpl;
            getAuthRequestContext(MyBillsEntityDataFactory, true);
            z2 = z3;
        } else {
            if (MyBillsEntityDataFactory.moveToNextValue) {
                if (MyBillsEntityDataFactory.DatabaseTableConfigUtil) {
                    MyBillsEntityDataFactory.moveToNextValue = false;
                    z = BuiltInFictitiousFunctionClassFactory(MyBillsEntityDataFactory, keyEvent);
                } else {
                    z = true;
                }
                if (z) {
                    getAuthRequestContext(MyBillsEntityDataFactory, keyEvent);
                }
            }
            z2 = false;
        }
        if (z2) {
            AudioManager audioManager = (AudioManager) this.NetworkUserEntityData$$ExternalSyntheticLambda0.getApplicationContext().getSystemService(H5ResourceHandlerUtil.AUDIO);
            if (audioManager != null) {
                audioManager.playSoundEffect(0);
            } else {
                InstrumentInjector.log_w("AppCompatDelegate", "Couldn't get audio manager");
            }
        }
        return z2;
    }

    void PlaceComponentResult(int i, PanelFeatureState panelFeatureState, Menu menu) {
        if (menu == null) {
            if (panelFeatureState == null && i >= 0) {
                PanelFeatureState[] panelFeatureStateArr = this.K;
                if (i < panelFeatureStateArr.length) {
                    panelFeatureState = panelFeatureStateArr[i];
                }
            }
            if (panelFeatureState != null) {
                menu = panelFeatureState.NetworkUserEntityData$$ExternalSyntheticLambda1;
            }
        }
        if ((panelFeatureState == null || panelFeatureState.scheduleImpl) && !this.moveToNextValue) {
            this.C.PlaceComponentResult(this.PrepareContext.getCallback(), i, menu);
        }
    }

    PanelFeatureState BuiltInFictitiousFunctionClassFactory(Menu menu) {
        PanelFeatureState[] panelFeatureStateArr = this.K;
        int length = panelFeatureStateArr != null ? panelFeatureStateArr.length : 0;
        for (int i = 0; i < length; i++) {
            PanelFeatureState panelFeatureState = panelFeatureStateArr[i];
            if (panelFeatureState != null && panelFeatureState.NetworkUserEntityData$$ExternalSyntheticLambda1 == menu) {
                return panelFeatureState;
            }
        }
        return null;
    }

    protected PanelFeatureState MyBillsEntityDataFactory(int i, boolean z) {
        PanelFeatureState[] panelFeatureStateArr = this.K;
        if (panelFeatureStateArr == null || panelFeatureStateArr.length <= i) {
            PanelFeatureState[] panelFeatureStateArr2 = new PanelFeatureState[i + 1];
            if (panelFeatureStateArr != null) {
                System.arraycopy(panelFeatureStateArr, 0, panelFeatureStateArr2, 0, panelFeatureStateArr.length);
            }
            this.K = panelFeatureStateArr2;
            panelFeatureStateArr = panelFeatureStateArr2;
        }
        PanelFeatureState panelFeatureState = panelFeatureStateArr[i];
        if (panelFeatureState == null) {
            PanelFeatureState panelFeatureState2 = new PanelFeatureState(i);
            panelFeatureStateArr[i] = panelFeatureState2;
            return panelFeatureState2;
        }
        return panelFeatureState;
    }

    private boolean getAuthRequestContext(PanelFeatureState panelFeatureState, int i, KeyEvent keyEvent, int i2) {
        boolean z = false;
        if (keyEvent.isSystem()) {
            return false;
        }
        if ((panelFeatureState.moveToNextValue || BuiltInFictitiousFunctionClassFactory(panelFeatureState, keyEvent)) && panelFeatureState.NetworkUserEntityData$$ExternalSyntheticLambda1 != null) {
            z = panelFeatureState.NetworkUserEntityData$$ExternalSyntheticLambda1.performShortcut(i, keyEvent, i2);
        }
        if (z && (i2 & 1) == 0 && this.E == null) {
            getAuthRequestContext(panelFeatureState, true);
        }
        return z;
    }

    private void NetworkUserEntityData$$ExternalSyntheticLambda0(int i) {
        this.NetworkUserEntityData$$ExternalSyntheticLambda1 = (1 << i) | this.NetworkUserEntityData$$ExternalSyntheticLambda1;
        if (this.initRecordTimeStamp) {
            return;
        }
        ViewCompat.PlaceComponentResult(this.PrepareContext.getDecorView(), this.G);
        this.initRecordTimeStamp = true;
    }

    void scheduleImpl(int i) {
        PanelFeatureState MyBillsEntityDataFactory;
        PanelFeatureState MyBillsEntityDataFactory2 = MyBillsEntityDataFactory(i, true);
        if (MyBillsEntityDataFactory2.NetworkUserEntityData$$ExternalSyntheticLambda1 != null) {
            Bundle bundle = new Bundle();
            MyBillsEntityDataFactory2.NetworkUserEntityData$$ExternalSyntheticLambda1.saveActionViewStates(bundle);
            if (bundle.size() > 0) {
                MyBillsEntityDataFactory2.PlaceComponentResult = bundle;
            }
            MyBillsEntityDataFactory2.NetworkUserEntityData$$ExternalSyntheticLambda1.stopDispatchingItemsChanged();
            MyBillsEntityDataFactory2.NetworkUserEntityData$$ExternalSyntheticLambda1.clear();
        }
        MyBillsEntityDataFactory2.DatabaseTableConfigUtil = true;
        MyBillsEntityDataFactory2.initRecordTimeStamp = true;
        if ((i != 108 && i != 0) || this.E == null || (MyBillsEntityDataFactory = MyBillsEntityDataFactory(0, false)) == null) {
            return;
        }
        MyBillsEntityDataFactory.moveToNextValue = false;
        BuiltInFictitiousFunctionClassFactory(MyBillsEntityDataFactory, (KeyEvent) null);
    }

    final int getAuthRequestContext(WindowInsetsCompat windowInsetsCompat, Rect rect) {
        int i;
        boolean z;
        boolean z2;
        if (windowInsetsCompat != null) {
            i = windowInsetsCompat.initRecordTimeStamp();
        } else {
            i = rect != null ? rect.top : 0;
        }
        ActionBarContextView actionBarContextView = this.BuiltInFictitiousFunctionClassFactory;
        if (actionBarContextView == null || !(actionBarContextView.getLayoutParams() instanceof ViewGroup.MarginLayoutParams)) {
            z = false;
        } else {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.BuiltInFictitiousFunctionClassFactory.getLayoutParams();
            if (this.BuiltInFictitiousFunctionClassFactory.isShown()) {
                if (this.SummaryVoucherView$$ExternalSyntheticLambda0 == null) {
                    this.SummaryVoucherView$$ExternalSyntheticLambda0 = new Rect();
                    this.O = new Rect();
                }
                Rect rect2 = this.SummaryVoucherView$$ExternalSyntheticLambda0;
                Rect rect3 = this.O;
                if (windowInsetsCompat == null) {
                    rect2.set(rect);
                } else {
                    rect2.set(windowInsetsCompat.lookAheadTest(), windowInsetsCompat.initRecordTimeStamp(), windowInsetsCompat.getErrorConfigVersion(), windowInsetsCompat.moveToNextValue());
                }
                ViewUtils.KClassImpl$Data$declaredNonStaticMembers$2(this.NetworkUserEntityData$$ExternalSyntheticLambda8, rect2, rect3);
                int i2 = rect2.top;
                int i3 = rect2.left;
                int i4 = rect2.right;
                WindowInsetsCompat NetworkUserEntityData$$ExternalSyntheticLambda32 = ViewCompat.NetworkUserEntityData$$ExternalSyntheticLambda3(this.NetworkUserEntityData$$ExternalSyntheticLambda8);
                int lookAheadTest = NetworkUserEntityData$$ExternalSyntheticLambda32 == null ? 0 : NetworkUserEntityData$$ExternalSyntheticLambda32.lookAheadTest();
                int errorConfigVersion = NetworkUserEntityData$$ExternalSyntheticLambda32 == null ? 0 : NetworkUserEntityData$$ExternalSyntheticLambda32.getErrorConfigVersion();
                if (marginLayoutParams.topMargin == i2 && marginLayoutParams.leftMargin == i3 && marginLayoutParams.rightMargin == i4) {
                    z2 = false;
                } else {
                    marginLayoutParams.topMargin = i2;
                    marginLayoutParams.leftMargin = i3;
                    marginLayoutParams.rightMargin = i4;
                    z2 = true;
                }
                if (i2 > 0 && this.L == null) {
                    View view = new View(this.NetworkUserEntityData$$ExternalSyntheticLambda0);
                    this.L = view;
                    view.setVisibility(8);
                    FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, marginLayoutParams.topMargin, 51);
                    layoutParams.leftMargin = lookAheadTest;
                    layoutParams.rightMargin = errorConfigVersion;
                    this.NetworkUserEntityData$$ExternalSyntheticLambda8.addView(this.L, -1, layoutParams);
                } else {
                    View view2 = this.L;
                    if (view2 != null) {
                        ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) view2.getLayoutParams();
                        if (marginLayoutParams2.height != marginLayoutParams.topMargin || marginLayoutParams2.leftMargin != lookAheadTest || marginLayoutParams2.rightMargin != errorConfigVersion) {
                            marginLayoutParams2.height = marginLayoutParams.topMargin;
                            marginLayoutParams2.leftMargin = lookAheadTest;
                            marginLayoutParams2.rightMargin = errorConfigVersion;
                            this.L.setLayoutParams(marginLayoutParams2);
                        }
                    }
                }
                View view3 = this.L;
                z = view3 != null;
                if (z && view3.getVisibility() != 0) {
                    PlaceComponentResult(this.L);
                }
                if (!this.isLayoutRequested && z) {
                    i = 0;
                }
            } else {
                if (marginLayoutParams.topMargin != 0) {
                    marginLayoutParams.topMargin = 0;
                    z2 = true;
                } else {
                    z2 = false;
                }
                z = false;
            }
            if (z2) {
                this.BuiltInFictitiousFunctionClassFactory.setLayoutParams(marginLayoutParams);
            }
        }
        View view4 = this.L;
        if (view4 != null) {
            view4.setVisibility(z ? 0 : 8);
        }
        return i;
    }

    private void PlaceComponentResult(View view) {
        int BuiltInFictitiousFunctionClassFactory;
        if ((ViewCompat.whenAvailable(view) & 8192) != 0) {
            BuiltInFictitiousFunctionClassFactory = ContextCompat.BuiltInFictitiousFunctionClassFactory(this.NetworkUserEntityData$$ExternalSyntheticLambda0, R.color.PlaceComponentResult);
        } else {
            BuiltInFictitiousFunctionClassFactory = ContextCompat.BuiltInFictitiousFunctionClassFactory(this.NetworkUserEntityData$$ExternalSyntheticLambda0, R.color.BuiltInFictitiousFunctionClassFactory);
        }
        view.setBackgroundColor(BuiltInFictitiousFunctionClassFactory);
    }

    private void getSupportButtonTintMode() {
        if (this.Q) {
            throw new AndroidRuntimeException("Window feature must be requested before adding content");
        }
    }

    private int getErrorConfigVersion(int i) {
        if (i == 8) {
            InstrumentInjector.log_i("AppCompatDelegate", "You should now use the AppCompatDelegate.FEATURE_SUPPORT_ACTION_BAR id when requesting this feature.");
            return 108;
        } else if (i == 9) {
            InstrumentInjector.log_i("AppCompatDelegate", "You should now use the AppCompatDelegate.FEATURE_SUPPORT_ACTION_BAR_OVERLAY id when requesting this feature.");
            return 109;
        } else {
            return i;
        }
    }

    void DatabaseTableConfigUtil() {
        DecorContentParent decorContentParent = this.E;
        if (decorContentParent != null) {
            decorContentParent.dismissPopups();
        }
        if (this.MyBillsEntityDataFactory != null) {
            this.PrepareContext.getDecorView().removeCallbacks(this.newProxyInstance);
            if (this.MyBillsEntityDataFactory.isShowing()) {
                try {
                    this.MyBillsEntityDataFactory.dismiss();
                } catch (IllegalArgumentException unused) {
                }
            }
            this.MyBillsEntityDataFactory = null;
        }
        NetworkUserEntityData$$ExternalSyntheticLambda1();
        PanelFeatureState MyBillsEntityDataFactory = MyBillsEntityDataFactory(0, false);
        if (MyBillsEntityDataFactory == null || MyBillsEntityDataFactory.NetworkUserEntityData$$ExternalSyntheticLambda1 == null) {
            return;
        }
        MyBillsEntityDataFactory.NetworkUserEntityData$$ExternalSyntheticLambda1.close();
    }

    public boolean GetContactSyncConfig() {
        return getAuthRequestContext(true);
    }

    private boolean getAuthRequestContext(boolean z) {
        if (this.moveToNextValue) {
            return false;
        }
        int NetworkUserEntityData$$ExternalSyntheticLambda62 = NetworkUserEntityData$$ExternalSyntheticLambda6();
        boolean PlaceComponentResult = PlaceComponentResult(KClassImpl$Data$declaredNonStaticMembers$2(this.NetworkUserEntityData$$ExternalSyntheticLambda0, NetworkUserEntityData$$ExternalSyntheticLambda62), z);
        if (NetworkUserEntityData$$ExternalSyntheticLambda62 == 0) {
            PlaceComponentResult(this.NetworkUserEntityData$$ExternalSyntheticLambda0).PlaceComponentResult();
        } else {
            AutoNightModeManager autoNightModeManager = this.VerifyPinStateManager$executeRiskChallenge$2$1;
            if (autoNightModeManager != null) {
                autoNightModeManager.BuiltInFictitiousFunctionClassFactory();
            }
        }
        if (NetworkUserEntityData$$ExternalSyntheticLambda62 == 3) {
            MyBillsEntityDataFactory(this.NetworkUserEntityData$$ExternalSyntheticLambda0).PlaceComponentResult();
        } else {
            AutoNightModeManager autoNightModeManager2 = this.B;
            if (autoNightModeManager2 != null) {
                autoNightModeManager2.BuiltInFictitiousFunctionClassFactory();
            }
        }
        return PlaceComponentResult;
    }

    @Override // androidx.appcompat.app.AppCompatDelegate
    public int MyBillsEntityDataFactory() {
        return this.I;
    }

    int KClassImpl$Data$declaredNonStaticMembers$2(Context context, int i) {
        if (i != -100) {
            if (i != -1) {
                if (i == 0) {
                    if (Build.VERSION.SDK_INT < 23 || ((UiModeManager) context.getApplicationContext().getSystemService("uimode")).getNightMode() != 0) {
                        return PlaceComponentResult(context).getAuthRequestContext();
                    }
                    return -1;
                } else if (i != 1 && i != 2) {
                    if (i == 3) {
                        return MyBillsEntityDataFactory(context).getAuthRequestContext();
                    }
                    throw new IllegalStateException("Unknown value set for night mode. Please use one of the MODE_NIGHT values from AppCompatDelegate.");
                }
            }
            return i;
        }
        return -1;
    }

    private int NetworkUserEntityData$$ExternalSyntheticLambda6() {
        int i = this.I;
        return i == -100 ? PlaceComponentResult() : i;
    }

    private Configuration BuiltInFictitiousFunctionClassFactory(Context context, int i, Configuration configuration, boolean z) {
        int i2;
        if (i == 1) {
            i2 = 16;
        } else if (i != 2) {
            i2 = z ? 0 : context.getApplicationContext().getResources().getConfiguration().uiMode & 48;
        } else {
            i2 = 32;
        }
        Configuration configuration2 = new Configuration();
        configuration2.fontScale = 0.0f;
        if (configuration != null) {
            configuration2.setTo(configuration);
        }
        configuration2.uiMode = i2 | (configuration2.uiMode & (-49));
        return configuration2;
    }

    private boolean PlaceComponentResult(int i, boolean z) {
        boolean z2 = false;
        Configuration BuiltInFictitiousFunctionClassFactory = BuiltInFictitiousFunctionClassFactory(this.NetworkUserEntityData$$ExternalSyntheticLambda0, i, null, false);
        boolean KClassImpl$Data$declaredNonStaticMembers$2 = KClassImpl$Data$declaredNonStaticMembers$2(this.NetworkUserEntityData$$ExternalSyntheticLambda0);
        Configuration configuration = this.VerifyPinStateManager$executeRiskChallenge$2$2;
        if (configuration == null) {
            configuration = this.NetworkUserEntityData$$ExternalSyntheticLambda0.getResources().getConfiguration();
        }
        int i2 = configuration.uiMode & 48;
        int i3 = BuiltInFictitiousFunctionClassFactory.uiMode & 48;
        boolean z3 = true;
        if (i2 != i3 && z && !KClassImpl$Data$declaredNonStaticMembers$2 && this.BottomSheetCardBindingView$watcherCardNumberView$1 && (NetworkUserEntityData$$ExternalSyntheticLambda4 || this.getValueOfTouchPositionAbsolute)) {
            Object obj = this.scheduleImpl;
            if ((obj instanceof Activity) && !((Activity) obj).isChild()) {
                ActivityCompat.getErrorConfigVersion((Activity) this.scheduleImpl);
                z2 = true;
            }
        }
        if (z2 || i2 == i3) {
            z3 = z2;
        } else {
            getAuthRequestContext(i3, KClassImpl$Data$declaredNonStaticMembers$2, null);
        }
        if (z3) {
            Object obj2 = this.scheduleImpl;
            if (obj2 instanceof AppCompatActivity) {
                ((AppCompatActivity) obj2).onNightModeChanged(i);
            }
        }
        return z3;
    }

    private void getAuthRequestContext(int i, boolean z, Configuration configuration) {
        Resources resources = this.NetworkUserEntityData$$ExternalSyntheticLambda0.getResources();
        Configuration configuration2 = new Configuration(resources.getConfiguration());
        if (configuration != null) {
            configuration2.updateFrom(configuration);
        }
        configuration2.uiMode = i | (resources.getConfiguration().uiMode & (-49));
        resources.updateConfiguration(configuration2, null);
        if (Build.VERSION.SDK_INT < 26) {
            ResourcesFlusher.KClassImpl$Data$declaredNonStaticMembers$2(resources);
        }
        int i2 = this.P;
        if (i2 != 0) {
            this.NetworkUserEntityData$$ExternalSyntheticLambda0.setTheme(i2);
            if (Build.VERSION.SDK_INT >= 23) {
                this.NetworkUserEntityData$$ExternalSyntheticLambda0.getTheme().applyStyle(this.P, true);
            }
        }
        if (z) {
            Object obj = this.scheduleImpl;
            if (obj instanceof Activity) {
                Activity activity = (Activity) obj;
                if (activity instanceof LifecycleOwner) {
                    if (((LifecycleOwner) activity).getLifecycle().PlaceComponentResult().isAtLeast(Lifecycle.State.CREATED)) {
                        activity.onConfigurationChanged(configuration2);
                    }
                } else if (!this.getValueOfTouchPositionAbsolute || this.moveToNextValue) {
                } else {
                    activity.onConfigurationChanged(configuration2);
                }
            }
        }
    }

    private AutoNightModeManager PlaceComponentResult(Context context) {
        if (this.VerifyPinStateManager$executeRiskChallenge$2$1 == null) {
            this.VerifyPinStateManager$executeRiskChallenge$2$1 = new AutoTimeNightModeManager(TwilightManager.PlaceComponentResult(context));
        }
        return this.VerifyPinStateManager$executeRiskChallenge$2$1;
    }

    private AutoNightModeManager MyBillsEntityDataFactory(Context context) {
        if (this.B == null) {
            this.B = new AutoBatteryNightModeManager(context);
        }
        return this.B;
    }

    private boolean KClassImpl$Data$declaredNonStaticMembers$2(Context context) {
        int i;
        if (!this.getCallingPid && (this.scheduleImpl instanceof Activity)) {
            PackageManager packageManager = context.getPackageManager();
            if (packageManager == null) {
                return false;
            }
            try {
                if (Build.VERSION.SDK_INT >= 29) {
                    i = 269221888;
                } else {
                    i = Build.VERSION.SDK_INT >= 24 ? 786432 : 0;
                }
                ActivityInfo activityInfo = packageManager.getActivityInfo(new ComponentName(context, this.scheduleImpl.getClass()), i);
                this.SubSequence = (activityInfo == null || (activityInfo.configChanges & 512) == 0) ? false : true;
            } catch (PackageManager.NameNotFoundException e) {
                InstrumentInjector.log_d("AppCompatDelegate", "Exception while getting ActivityInfo", e);
                this.SubSequence = false;
            }
        }
        this.getCallingPid = true;
        return this.SubSequence;
    }

    /* loaded from: classes.dex */
    public class ActionModeCallbackWrapperV9 implements ActionMode.Callback {
        private ActionMode.Callback getAuthRequestContext;

        public ActionModeCallbackWrapperV9(ActionMode.Callback callback) {
            AppCompatDelegateImpl.this = r1;
            this.getAuthRequestContext = callback;
        }

        @Override // androidx.appcompat.view.ActionMode.Callback
        public boolean getAuthRequestContext(ActionMode actionMode, Menu menu) {
            return this.getAuthRequestContext.getAuthRequestContext(actionMode, menu);
        }

        @Override // androidx.appcompat.view.ActionMode.Callback
        public boolean BuiltInFictitiousFunctionClassFactory(ActionMode actionMode, Menu menu) {
            ViewCompat.I(AppCompatDelegateImpl.this.NetworkUserEntityData$$ExternalSyntheticLambda8);
            return this.getAuthRequestContext.BuiltInFictitiousFunctionClassFactory(actionMode, menu);
        }

        @Override // androidx.appcompat.view.ActionMode.Callback
        public boolean getAuthRequestContext(ActionMode actionMode, MenuItem menuItem) {
            return this.getAuthRequestContext.getAuthRequestContext(actionMode, menuItem);
        }

        @Override // androidx.appcompat.view.ActionMode.Callback
        public void KClassImpl$Data$declaredNonStaticMembers$2(ActionMode actionMode) {
            this.getAuthRequestContext.KClassImpl$Data$declaredNonStaticMembers$2(actionMode);
            if (AppCompatDelegateImpl.this.MyBillsEntityDataFactory != null) {
                AppCompatDelegateImpl.this.PrepareContext.getDecorView().removeCallbacks(AppCompatDelegateImpl.this.newProxyInstance);
            }
            if (AppCompatDelegateImpl.this.BuiltInFictitiousFunctionClassFactory != null) {
                AppCompatDelegateImpl.this.NetworkUserEntityData$$ExternalSyntheticLambda1();
                AppCompatDelegateImpl appCompatDelegateImpl = AppCompatDelegateImpl.this;
                appCompatDelegateImpl.getErrorConfigVersion = ViewCompat.MyBillsEntityDataFactory(appCompatDelegateImpl.BuiltInFictitiousFunctionClassFactory).getAuthRequestContext(0.0f);
                AppCompatDelegateImpl.this.getErrorConfigVersion.KClassImpl$Data$declaredNonStaticMembers$2(new ViewPropertyAnimatorListenerAdapter() { // from class: androidx.appcompat.app.AppCompatDelegateImpl.ActionModeCallbackWrapperV9.1
                    {
                        ActionModeCallbackWrapperV9.this = this;
                    }

                    @Override // androidx.core.view.ViewPropertyAnimatorListenerAdapter, androidx.core.view.ViewPropertyAnimatorListener
                    public void getAuthRequestContext(View view) {
                        AppCompatDelegateImpl.this.BuiltInFictitiousFunctionClassFactory.setVisibility(8);
                        if (AppCompatDelegateImpl.this.MyBillsEntityDataFactory != null) {
                            AppCompatDelegateImpl.this.MyBillsEntityDataFactory.dismiss();
                        } else if (AppCompatDelegateImpl.this.BuiltInFictitiousFunctionClassFactory.getParent() instanceof View) {
                            ViewCompat.I((View) AppCompatDelegateImpl.this.BuiltInFictitiousFunctionClassFactory.getParent());
                        }
                        AppCompatDelegateImpl.this.BuiltInFictitiousFunctionClassFactory.killMode();
                        AppCompatDelegateImpl.this.getErrorConfigVersion.KClassImpl$Data$declaredNonStaticMembers$2((ViewPropertyAnimatorListener) null);
                        AppCompatDelegateImpl.this.getErrorConfigVersion = null;
                        ViewCompat.I(AppCompatDelegateImpl.this.NetworkUserEntityData$$ExternalSyntheticLambda8);
                    }
                });
            }
            if (AppCompatDelegateImpl.this.KClassImpl$Data$declaredNonStaticMembers$2 != null) {
                AppCompatDelegateImpl.this.KClassImpl$Data$declaredNonStaticMembers$2.onSupportActionModeFinished(AppCompatDelegateImpl.this.PlaceComponentResult);
            }
            AppCompatDelegateImpl.this.PlaceComponentResult = null;
            ViewCompat.I(AppCompatDelegateImpl.this.NetworkUserEntityData$$ExternalSyntheticLambda8);
        }
    }

    /* loaded from: classes.dex */
    public final class PanelMenuPresenterCallback implements MenuPresenter.Callback {
        PanelMenuPresenterCallback() {
            AppCompatDelegateImpl.this = r1;
        }

        @Override // androidx.appcompat.view.menu.MenuPresenter.Callback
        public final void MyBillsEntityDataFactory(MenuBuilder menuBuilder, boolean z) {
            MenuBuilder rootMenu = menuBuilder.getRootMenu();
            boolean z2 = rootMenu != menuBuilder;
            AppCompatDelegateImpl appCompatDelegateImpl = AppCompatDelegateImpl.this;
            if (z2) {
                menuBuilder = rootMenu;
            }
            PanelFeatureState BuiltInFictitiousFunctionClassFactory = appCompatDelegateImpl.BuiltInFictitiousFunctionClassFactory(menuBuilder);
            if (BuiltInFictitiousFunctionClassFactory != null) {
                if (z2) {
                    AppCompatDelegateImpl.this.PlaceComponentResult(BuiltInFictitiousFunctionClassFactory.MyBillsEntityDataFactory, BuiltInFictitiousFunctionClassFactory, rootMenu);
                    AppCompatDelegateImpl.this.getAuthRequestContext(BuiltInFictitiousFunctionClassFactory, true);
                    return;
                }
                AppCompatDelegateImpl.this.getAuthRequestContext(BuiltInFictitiousFunctionClassFactory, z);
            }
        }

        @Override // androidx.appcompat.view.menu.MenuPresenter.Callback
        public final boolean getAuthRequestContext(MenuBuilder menuBuilder) {
            Window.Callback newProxyInstance;
            if (menuBuilder != menuBuilder.getRootMenu() || !AppCompatDelegateImpl.this.lookAheadTest || (newProxyInstance = AppCompatDelegateImpl.this.newProxyInstance()) == null || AppCompatDelegateImpl.this.moveToNextValue) {
                return true;
            }
            newProxyInstance.onMenuOpened(108, menuBuilder);
            return true;
        }
    }

    /* loaded from: classes.dex */
    public final class ActionMenuPresenterCallback implements MenuPresenter.Callback {
        ActionMenuPresenterCallback() {
            AppCompatDelegateImpl.this = r1;
        }

        @Override // androidx.appcompat.view.menu.MenuPresenter.Callback
        public final boolean getAuthRequestContext(MenuBuilder menuBuilder) {
            Window.Callback newProxyInstance = AppCompatDelegateImpl.this.newProxyInstance();
            if (newProxyInstance != null) {
                newProxyInstance.onMenuOpened(108, menuBuilder);
                return true;
            }
            return true;
        }

        @Override // androidx.appcompat.view.menu.MenuPresenter.Callback
        public final void MyBillsEntityDataFactory(MenuBuilder menuBuilder, boolean z) {
            AppCompatDelegateImpl.this.getAuthRequestContext(menuBuilder);
        }
    }

    /* loaded from: classes.dex */
    public static final class PanelFeatureState {
        ViewGroup BuiltInFictitiousFunctionClassFactory;
        boolean DatabaseTableConfigUtil;
        public boolean GetContactSyncConfig;
        int KClassImpl$Data$declaredNonStaticMembers$2;
        int MyBillsEntityDataFactory;
        boolean NetworkUserEntityData$$ExternalSyntheticLambda0;
        MenuBuilder NetworkUserEntityData$$ExternalSyntheticLambda1;
        Context NetworkUserEntityData$$ExternalSyntheticLambda2;
        View NetworkUserEntityData$$ExternalSyntheticLambda7;
        int NetworkUserEntityData$$ExternalSyntheticLambda8;
        Bundle PlaceComponentResult;
        int PrepareContext;
        View getAuthRequestContext;
        ListMenuPresenter getErrorConfigVersion;
        boolean initRecordTimeStamp = false;
        int isLayoutRequested;
        int lookAheadTest;
        boolean moveToNextValue;
        boolean scheduleImpl;

        PanelFeatureState(int i) {
            this.MyBillsEntityDataFactory = i;
        }

        public final boolean MyBillsEntityDataFactory() {
            if (this.NetworkUserEntityData$$ExternalSyntheticLambda7 == null) {
                return false;
            }
            if (this.getAuthRequestContext != null) {
                return true;
            }
            ListMenuPresenter listMenuPresenter = this.getErrorConfigVersion;
            if (listMenuPresenter.PlaceComponentResult == null) {
                listMenuPresenter.PlaceComponentResult = new ListMenuPresenter.MenuAdapter();
            }
            return listMenuPresenter.PlaceComponentResult.getCount() > 0;
        }

        final void KClassImpl$Data$declaredNonStaticMembers$2(Context context) {
            TypedValue typedValue = new TypedValue();
            Resources.Theme newTheme = context.getResources().newTheme();
            newTheme.setTo(context.getTheme());
            newTheme.resolveAttribute(R.attr.BuiltInFictitiousFunctionClassFactory, typedValue, true);
            if (typedValue.resourceId != 0) {
                newTheme.applyStyle(typedValue.resourceId, true);
            }
            newTheme.resolveAttribute(R.attr.E, typedValue, true);
            if (typedValue.resourceId != 0) {
                newTheme.applyStyle(typedValue.resourceId, true);
            } else {
                newTheme.applyStyle(R.style.getAuthRequestContext, true);
            }
            androidx.appcompat.view.ContextThemeWrapper contextThemeWrapper = new androidx.appcompat.view.ContextThemeWrapper(context, 0);
            contextThemeWrapper.getTheme().setTo(newTheme);
            this.NetworkUserEntityData$$ExternalSyntheticLambda2 = contextThemeWrapper;
            TypedArray obtainStyledAttributes = contextThemeWrapper.obtainStyledAttributes(R.styleable.g);
            this.KClassImpl$Data$declaredNonStaticMembers$2 = obtainStyledAttributes.getResourceId(R.styleable.connectForeground, 0);
            this.PrepareContext = obtainStyledAttributes.getResourceId(R.styleable.e, 0);
            obtainStyledAttributes.recycle();
        }

        final void KClassImpl$Data$declaredNonStaticMembers$2(MenuBuilder menuBuilder) {
            ListMenuPresenter listMenuPresenter;
            MenuBuilder menuBuilder2 = this.NetworkUserEntityData$$ExternalSyntheticLambda1;
            if (menuBuilder == menuBuilder2) {
                return;
            }
            if (menuBuilder2 != null) {
                menuBuilder2.removeMenuPresenter(this.getErrorConfigVersion);
            }
            this.NetworkUserEntityData$$ExternalSyntheticLambda1 = menuBuilder;
            if (menuBuilder == null || (listMenuPresenter = this.getErrorConfigVersion) == null) {
                return;
            }
            menuBuilder.addMenuPresenter(listMenuPresenter);
        }

        final MenuView getAuthRequestContext(MenuPresenter.Callback callback) {
            if (this.NetworkUserEntityData$$ExternalSyntheticLambda1 == null) {
                return null;
            }
            if (this.getErrorConfigVersion == null) {
                ListMenuPresenter listMenuPresenter = new ListMenuPresenter(this.NetworkUserEntityData$$ExternalSyntheticLambda2, R.layout.NetworkUserEntityData$$ExternalSyntheticLambda2);
                this.getErrorConfigVersion = listMenuPresenter;
                listMenuPresenter.setCallback(callback);
                this.NetworkUserEntityData$$ExternalSyntheticLambda1.addMenuPresenter(this.getErrorConfigVersion);
            }
            ListMenuPresenter listMenuPresenter2 = this.getErrorConfigVersion;
            ViewGroup viewGroup = this.BuiltInFictitiousFunctionClassFactory;
            if (listMenuPresenter2.getErrorConfigVersion == null) {
                listMenuPresenter2.getErrorConfigVersion = (ExpandedMenuView) listMenuPresenter2.MyBillsEntityDataFactory.inflate(R.layout.NetworkUserEntityData$$ExternalSyntheticLambda0, viewGroup, false);
                if (listMenuPresenter2.PlaceComponentResult == null) {
                    listMenuPresenter2.PlaceComponentResult = new ListMenuPresenter.MenuAdapter();
                }
                listMenuPresenter2.getErrorConfigVersion.setAdapter((ListAdapter) listMenuPresenter2.PlaceComponentResult);
                listMenuPresenter2.getErrorConfigVersion.setOnItemClickListener(listMenuPresenter2);
            }
            return listMenuPresenter2.getErrorConfigVersion;
        }

        /* loaded from: classes.dex */
        public static class SavedState implements Parcelable {
            public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.ClassLoaderCreator<SavedState>() { // from class: androidx.appcompat.app.AppCompatDelegateImpl.PanelFeatureState.SavedState.1
                @Override // android.os.Parcelable.ClassLoaderCreator
                /* renamed from: MyBillsEntityDataFactory */
                public SavedState createFromParcel(Parcel parcel, ClassLoader classLoader) {
                    return SavedState.getAuthRequestContext(parcel, classLoader);
                }

                @Override // android.os.Parcelable.Creator
                /* renamed from: BuiltInFictitiousFunctionClassFactory */
                public SavedState createFromParcel(Parcel parcel) {
                    return SavedState.getAuthRequestContext(parcel, null);
                }

                @Override // android.os.Parcelable.Creator
                /* renamed from: MyBillsEntityDataFactory */
                public SavedState[] newArray(int i) {
                    return new SavedState[i];
                }
            };
            Bundle BuiltInFictitiousFunctionClassFactory;
            boolean PlaceComponentResult;
            int getAuthRequestContext;

            @Override // android.os.Parcelable
            public int describeContents() {
                return 0;
            }

            SavedState() {
            }

            @Override // android.os.Parcelable
            public void writeToParcel(Parcel parcel, int i) {
                parcel.writeInt(this.getAuthRequestContext);
                parcel.writeInt(this.PlaceComponentResult ? 1 : 0);
                if (this.PlaceComponentResult) {
                    parcel.writeBundle(this.BuiltInFictitiousFunctionClassFactory);
                }
            }

            static SavedState getAuthRequestContext(Parcel parcel, ClassLoader classLoader) {
                SavedState savedState = new SavedState();
                savedState.getAuthRequestContext = parcel.readInt();
                boolean z = parcel.readInt() == 1;
                savedState.PlaceComponentResult = z;
                if (z) {
                    savedState.BuiltInFictitiousFunctionClassFactory = parcel.readBundle(classLoader);
                }
                return savedState;
            }
        }
    }

    /* loaded from: classes.dex */
    public class ListMenuDecorView extends ContentFrameLayout {
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ListMenuDecorView(Context context) {
            super(context);
            AppCompatDelegateImpl.this = r1;
        }

        @Override // android.view.ViewGroup, android.view.View
        public boolean dispatchKeyEvent(KeyEvent keyEvent) {
            return AppCompatDelegateImpl.this.getAuthRequestContext(keyEvent) || super.dispatchKeyEvent(keyEvent);
        }

        @Override // android.view.ViewGroup
        public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
            if (motionEvent.getAction() == 0 && MyBillsEntityDataFactory((int) motionEvent.getX(), (int) motionEvent.getY())) {
                AppCompatDelegateImpl.this.KClassImpl$Data$declaredNonStaticMembers$2(0);
                return true;
            }
            return super.onInterceptTouchEvent(motionEvent);
        }

        @Override // android.view.View
        public void setBackgroundResource(int i) {
            Drawable BuiltInFictitiousFunctionClassFactory;
            BuiltInFictitiousFunctionClassFactory = ResourceManagerInternal.KClassImpl$Data$declaredNonStaticMembers$2().BuiltInFictitiousFunctionClassFactory(getContext(), i);
            setBackgroundDrawable(BuiltInFictitiousFunctionClassFactory);
        }

        private boolean MyBillsEntityDataFactory(int i, int i2) {
            return i < -5 || i2 < -5 || i > getWidth() + 5 || i2 > getHeight() + 5;
        }
    }

    /* loaded from: classes.dex */
    public class AppCompatWindowCallback extends WindowCallbackWrapper {
        private boolean KClassImpl$Data$declaredNonStaticMembers$2;
        private ActionBarMenuCallback PlaceComponentResult;
        private boolean getAuthRequestContext;
        private boolean getErrorConfigVersion;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AppCompatWindowCallback(Window.Callback callback) {
            super(callback);
            AppCompatDelegateImpl.this = r1;
        }

        void PlaceComponentResult(ActionBarMenuCallback actionBarMenuCallback) {
            this.PlaceComponentResult = actionBarMenuCallback;
        }

        @Override // androidx.appcompat.view.WindowCallbackWrapper, android.view.Window.Callback
        public boolean dispatchKeyEvent(KeyEvent keyEvent) {
            if (this.KClassImpl$Data$declaredNonStaticMembers$2) {
                return BuiltInFictitiousFunctionClassFactory().dispatchKeyEvent(keyEvent);
            }
            return AppCompatDelegateImpl.this.getAuthRequestContext(keyEvent) || super.dispatchKeyEvent(keyEvent);
        }

        @Override // androidx.appcompat.view.WindowCallbackWrapper, android.view.Window.Callback
        public boolean dispatchKeyShortcutEvent(KeyEvent keyEvent) {
            return super.dispatchKeyShortcutEvent(keyEvent) || AppCompatDelegateImpl.this.PlaceComponentResult(keyEvent.getKeyCode(), keyEvent);
        }

        @Override // androidx.appcompat.view.WindowCallbackWrapper, android.view.Window.Callback
        public boolean onCreatePanelMenu(int i, Menu menu) {
            if (i != 0 || (menu instanceof MenuBuilder)) {
                return super.onCreatePanelMenu(i, menu);
            }
            return false;
        }

        @Override // androidx.appcompat.view.WindowCallbackWrapper, android.view.Window.Callback
        public View onCreatePanelView(int i) {
            View MyBillsEntityDataFactory;
            ActionBarMenuCallback actionBarMenuCallback = this.PlaceComponentResult;
            return (actionBarMenuCallback == null || (MyBillsEntityDataFactory = actionBarMenuCallback.MyBillsEntityDataFactory(i)) == null) ? super.onCreatePanelView(i) : MyBillsEntityDataFactory;
        }

        @Override // androidx.appcompat.view.WindowCallbackWrapper, android.view.Window.Callback
        public void onContentChanged() {
            if (this.getAuthRequestContext) {
                BuiltInFictitiousFunctionClassFactory().onContentChanged();
            }
        }

        @Override // androidx.appcompat.view.WindowCallbackWrapper, android.view.Window.Callback
        public boolean onPreparePanel(int i, View view, Menu menu) {
            MenuBuilder menuBuilder = menu instanceof MenuBuilder ? (MenuBuilder) menu : null;
            if (i == 0 && menuBuilder == null) {
                return false;
            }
            if (menuBuilder != null) {
                menuBuilder.setOverrideVisibleItems(true);
            }
            ActionBarMenuCallback actionBarMenuCallback = this.PlaceComponentResult;
            boolean z = actionBarMenuCallback != null && actionBarMenuCallback.PlaceComponentResult(i);
            if (!z) {
                z = super.onPreparePanel(i, view, menu);
            }
            if (menuBuilder != null) {
                menuBuilder.setOverrideVisibleItems(false);
            }
            return z;
        }

        @Override // androidx.appcompat.view.WindowCallbackWrapper, android.view.Window.Callback
        public boolean onMenuOpened(int i, Menu menu) {
            super.onMenuOpened(i, menu);
            AppCompatDelegateImpl.this.moveToNextValue(i);
            return true;
        }

        @Override // androidx.appcompat.view.WindowCallbackWrapper, android.view.Window.Callback
        public void onPanelClosed(int i, Menu menu) {
            if (this.getErrorConfigVersion) {
                BuiltInFictitiousFunctionClassFactory().onPanelClosed(i, menu);
                return;
            }
            super.onPanelClosed(i, menu);
            AppCompatDelegateImpl.this.lookAheadTest(i);
        }

        @Override // androidx.appcompat.view.WindowCallbackWrapper, android.view.Window.Callback
        public android.view.ActionMode onWindowStartingActionMode(ActionMode.Callback callback) {
            if (Build.VERSION.SDK_INT >= 23) {
                return null;
            }
            if (AppCompatDelegateImpl.this.NetworkUserEntityData$$ExternalSyntheticLambda7()) {
                return BuiltInFictitiousFunctionClassFactory(callback);
            }
            return super.onWindowStartingActionMode(callback);
        }

        final android.view.ActionMode BuiltInFictitiousFunctionClassFactory(ActionMode.Callback callback) {
            SupportActionModeWrapper.CallbackWrapper callbackWrapper = new SupportActionModeWrapper.CallbackWrapper(AppCompatDelegateImpl.this.NetworkUserEntityData$$ExternalSyntheticLambda0, callback);
            androidx.appcompat.view.ActionMode PlaceComponentResult = AppCompatDelegateImpl.this.PlaceComponentResult(callbackWrapper);
            if (PlaceComponentResult != null) {
                return callbackWrapper.MyBillsEntityDataFactory(PlaceComponentResult);
            }
            return null;
        }

        @Override // androidx.appcompat.view.WindowCallbackWrapper, android.view.Window.Callback
        public android.view.ActionMode onWindowStartingActionMode(ActionMode.Callback callback, int i) {
            if (AppCompatDelegateImpl.this.NetworkUserEntityData$$ExternalSyntheticLambda7() && i == 0) {
                return BuiltInFictitiousFunctionClassFactory(callback);
            }
            return super.onWindowStartingActionMode(callback, i);
        }

        @Override // androidx.appcompat.view.WindowCallbackWrapper, android.view.Window.Callback
        public void onProvideKeyboardShortcuts(List<KeyboardShortcutGroup> list, Menu menu, int i) {
            PanelFeatureState MyBillsEntityDataFactory = AppCompatDelegateImpl.this.MyBillsEntityDataFactory(0, true);
            if (MyBillsEntityDataFactory != null && MyBillsEntityDataFactory.NetworkUserEntityData$$ExternalSyntheticLambda1 != null) {
                super.onProvideKeyboardShortcuts(list, MyBillsEntityDataFactory.NetworkUserEntityData$$ExternalSyntheticLambda1, i);
            } else {
                super.onProvideKeyboardShortcuts(list, menu, i);
            }
        }

        public void KClassImpl$Data$declaredNonStaticMembers$2(Window.Callback callback) {
            try {
                this.getAuthRequestContext = true;
                callback.onContentChanged();
            } finally {
                this.getAuthRequestContext = false;
            }
        }

        public boolean MyBillsEntityDataFactory(Window.Callback callback, KeyEvent keyEvent) {
            try {
                this.KClassImpl$Data$declaredNonStaticMembers$2 = true;
                return callback.dispatchKeyEvent(keyEvent);
            } finally {
                this.KClassImpl$Data$declaredNonStaticMembers$2 = false;
            }
        }

        public void PlaceComponentResult(Window.Callback callback, int i, Menu menu) {
            try {
                this.getErrorConfigVersion = true;
                callback.onPanelClosed(i, menu);
            } finally {
                this.getErrorConfigVersion = false;
            }
        }
    }

    /* loaded from: classes.dex */
    public abstract class AutoNightModeManager {
        private BroadcastReceiver BuiltInFictitiousFunctionClassFactory;

        abstract IntentFilter KClassImpl$Data$declaredNonStaticMembers$2();

        abstract void MyBillsEntityDataFactory();

        abstract int getAuthRequestContext();

        AutoNightModeManager() {
            AppCompatDelegateImpl.this = r1;
        }

        void PlaceComponentResult() {
            BuiltInFictitiousFunctionClassFactory();
            IntentFilter KClassImpl$Data$declaredNonStaticMembers$2 = KClassImpl$Data$declaredNonStaticMembers$2();
            if (KClassImpl$Data$declaredNonStaticMembers$2 == null || KClassImpl$Data$declaredNonStaticMembers$2.countActions() == 0) {
                return;
            }
            if (this.BuiltInFictitiousFunctionClassFactory == null) {
                this.BuiltInFictitiousFunctionClassFactory = new BroadcastReceiver() { // from class: androidx.appcompat.app.AppCompatDelegateImpl.AutoNightModeManager.1
                    {
                        AutoNightModeManager.this = this;
                    }

                    @Override // android.content.BroadcastReceiver
                    public void onReceive(Context context, Intent intent) {
                        AutoNightModeManager.this.MyBillsEntityDataFactory();
                    }
                };
            }
            AppCompatDelegateImpl.this.NetworkUserEntityData$$ExternalSyntheticLambda0.registerReceiver(this.BuiltInFictitiousFunctionClassFactory, KClassImpl$Data$declaredNonStaticMembers$2);
        }

        void BuiltInFictitiousFunctionClassFactory() {
            if (this.BuiltInFictitiousFunctionClassFactory != null) {
                try {
                    AppCompatDelegateImpl.this.NetworkUserEntityData$$ExternalSyntheticLambda0.unregisterReceiver(this.BuiltInFictitiousFunctionClassFactory);
                } catch (IllegalArgumentException unused) {
                }
                this.BuiltInFictitiousFunctionClassFactory = null;
            }
        }
    }

    /* loaded from: classes.dex */
    public class AutoTimeNightModeManager extends AutoNightModeManager {
        private final TwilightManager MyBillsEntityDataFactory;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AutoTimeNightModeManager(TwilightManager twilightManager) {
            super();
            AppCompatDelegateImpl.this = r1;
            this.MyBillsEntityDataFactory = twilightManager;
        }

        @Override // androidx.appcompat.app.AppCompatDelegateImpl.AutoNightModeManager
        public int getAuthRequestContext() {
            return this.MyBillsEntityDataFactory.MyBillsEntityDataFactory() ? 2 : 1;
        }

        @Override // androidx.appcompat.app.AppCompatDelegateImpl.AutoNightModeManager
        public void MyBillsEntityDataFactory() {
            AppCompatDelegateImpl.this.GetContactSyncConfig();
        }

        @Override // androidx.appcompat.app.AppCompatDelegateImpl.AutoNightModeManager
        IntentFilter KClassImpl$Data$declaredNonStaticMembers$2() {
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.intent.action.TIME_SET");
            intentFilter.addAction("android.intent.action.TIMEZONE_CHANGED");
            intentFilter.addAction("android.intent.action.TIME_TICK");
            return intentFilter;
        }
    }

    /* loaded from: classes.dex */
    public class AutoBatteryNightModeManager extends AutoNightModeManager {
        private final PowerManager PlaceComponentResult;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AutoBatteryNightModeManager(Context context) {
            super();
            AppCompatDelegateImpl.this = r1;
            this.PlaceComponentResult = (PowerManager) context.getApplicationContext().getSystemService("power");
        }

        @Override // androidx.appcompat.app.AppCompatDelegateImpl.AutoNightModeManager
        public int getAuthRequestContext() {
            return (Build.VERSION.SDK_INT < 21 || !Api21Impl.PlaceComponentResult(this.PlaceComponentResult)) ? 1 : 2;
        }

        @Override // androidx.appcompat.app.AppCompatDelegateImpl.AutoNightModeManager
        public void MyBillsEntityDataFactory() {
            AppCompatDelegateImpl.this.GetContactSyncConfig();
        }

        @Override // androidx.appcompat.app.AppCompatDelegateImpl.AutoNightModeManager
        IntentFilter KClassImpl$Data$declaredNonStaticMembers$2() {
            if (Build.VERSION.SDK_INT >= 21) {
                IntentFilter intentFilter = new IntentFilter();
                intentFilter.addAction("android.os.action.POWER_SAVE_MODE_CHANGED");
                return intentFilter;
            }
            return null;
        }
    }

    @Override // androidx.appcompat.app.AppCompatDelegate
    public final ActionBarDrawerToggle.Delegate BuiltInFictitiousFunctionClassFactory() {
        return new ActionBarDrawableToggleImpl();
    }

    /* loaded from: classes.dex */
    class ActionBarDrawableToggleImpl implements ActionBarDrawerToggle.Delegate {
        ActionBarDrawableToggleImpl() {
            AppCompatDelegateImpl.this = r1;
        }

        @Override // androidx.appcompat.app.ActionBarDrawerToggle.Delegate
        public void BuiltInFictitiousFunctionClassFactory(Drawable drawable, int i) {
            ActionBar KClassImpl$Data$declaredNonStaticMembers$2 = AppCompatDelegateImpl.this.KClassImpl$Data$declaredNonStaticMembers$2();
            if (KClassImpl$Data$declaredNonStaticMembers$2 != null) {
                KClassImpl$Data$declaredNonStaticMembers$2.KClassImpl$Data$declaredNonStaticMembers$2(drawable);
                KClassImpl$Data$declaredNonStaticMembers$2.KClassImpl$Data$declaredNonStaticMembers$2(i);
            }
        }

        @Override // androidx.appcompat.app.ActionBarDrawerToggle.Delegate
        public void getAuthRequestContext(int i) {
            ActionBar KClassImpl$Data$declaredNonStaticMembers$2 = AppCompatDelegateImpl.this.KClassImpl$Data$declaredNonStaticMembers$2();
            if (KClassImpl$Data$declaredNonStaticMembers$2 != null) {
                KClassImpl$Data$declaredNonStaticMembers$2.KClassImpl$Data$declaredNonStaticMembers$2(i);
            }
        }
    }

    private static Configuration MyBillsEntityDataFactory(Configuration configuration, Configuration configuration2) {
        Configuration configuration3 = new Configuration();
        configuration3.fontScale = 0.0f;
        if (configuration2 != null && configuration.diff(configuration2) != 0) {
            if (configuration.fontScale != configuration2.fontScale) {
                configuration3.fontScale = configuration2.fontScale;
            }
            if (configuration.mcc != configuration2.mcc) {
                configuration3.mcc = configuration2.mcc;
            }
            if (configuration.mnc != configuration2.mnc) {
                configuration3.mnc = configuration2.mnc;
            }
            if (Build.VERSION.SDK_INT >= 24) {
                Api24Impl.BuiltInFictitiousFunctionClassFactory(configuration, configuration2, configuration3);
            } else if (!ObjectsCompat.MyBillsEntityDataFactory(configuration.locale, configuration2.locale)) {
                configuration3.locale = configuration2.locale;
            }
            if (configuration.touchscreen != configuration2.touchscreen) {
                configuration3.touchscreen = configuration2.touchscreen;
            }
            if (configuration.keyboard != configuration2.keyboard) {
                configuration3.keyboard = configuration2.keyboard;
            }
            if (configuration.keyboardHidden != configuration2.keyboardHidden) {
                configuration3.keyboardHidden = configuration2.keyboardHidden;
            }
            if (configuration.navigation != configuration2.navigation) {
                configuration3.navigation = configuration2.navigation;
            }
            if (configuration.navigationHidden != configuration2.navigationHidden) {
                configuration3.navigationHidden = configuration2.navigationHidden;
            }
            if (configuration.orientation != configuration2.orientation) {
                configuration3.orientation = configuration2.orientation;
            }
            if ((configuration.screenLayout & 15) != (configuration2.screenLayout & 15)) {
                configuration3.screenLayout |= configuration2.screenLayout & 15;
            }
            if ((configuration.screenLayout & 192) != (configuration2.screenLayout & 192)) {
                configuration3.screenLayout |= configuration2.screenLayout & 192;
            }
            if ((configuration.screenLayout & 48) != (configuration2.screenLayout & 48)) {
                configuration3.screenLayout |= configuration2.screenLayout & 48;
            }
            if ((configuration.screenLayout & 768) != (configuration2.screenLayout & 768)) {
                configuration3.screenLayout |= configuration2.screenLayout & 768;
            }
            if (Build.VERSION.SDK_INT >= 26) {
                Api26Impl.MyBillsEntityDataFactory(configuration, configuration2, configuration3);
            }
            if ((configuration.uiMode & 15) != (configuration2.uiMode & 15)) {
                configuration3.uiMode |= configuration2.uiMode & 15;
            }
            if ((configuration.uiMode & 48) != (configuration2.uiMode & 48)) {
                configuration3.uiMode |= configuration2.uiMode & 48;
            }
            if (configuration.screenWidthDp != configuration2.screenWidthDp) {
                configuration3.screenWidthDp = configuration2.screenWidthDp;
            }
            if (configuration.screenHeightDp != configuration2.screenHeightDp) {
                configuration3.screenHeightDp = configuration2.screenHeightDp;
            }
            if (configuration.smallestScreenWidthDp != configuration2.smallestScreenWidthDp) {
                configuration3.smallestScreenWidthDp = configuration2.smallestScreenWidthDp;
            }
            if (Build.VERSION.SDK_INT >= 17) {
                Api17Impl.KClassImpl$Data$declaredNonStaticMembers$2(configuration, configuration2, configuration3);
            }
        }
        return configuration3;
    }

    /* loaded from: classes.dex */
    public static class Api17Impl {
        private Api17Impl() {
        }

        static void KClassImpl$Data$declaredNonStaticMembers$2(Configuration configuration, Configuration configuration2, Configuration configuration3) {
            if (configuration.densityDpi != configuration2.densityDpi) {
                configuration3.densityDpi = configuration2.densityDpi;
            }
        }
    }

    /* loaded from: classes.dex */
    static class Api21Impl {
        private Api21Impl() {
        }

        static boolean PlaceComponentResult(PowerManager powerManager) {
            return powerManager.isPowerSaveMode();
        }
    }

    /* loaded from: classes.dex */
    public static class Api24Impl {
        private Api24Impl() {
        }

        static void BuiltInFictitiousFunctionClassFactory(Configuration configuration, Configuration configuration2, Configuration configuration3) {
            LocaleList locales = configuration.getLocales();
            LocaleList locales2 = configuration2.getLocales();
            if (locales.equals(locales2)) {
                return;
            }
            configuration3.setLocales(locales2);
            configuration3.locale = configuration2.locale;
        }
    }

    /* loaded from: classes.dex */
    public static class Api26Impl {
        private Api26Impl() {
        }

        static void MyBillsEntityDataFactory(Configuration configuration, Configuration configuration2, Configuration configuration3) {
            if ((configuration.colorMode & 3) != (configuration2.colorMode & 3)) {
                configuration3.colorMode |= configuration2.colorMode & 3;
            }
            if ((configuration.colorMode & 12) != (configuration2.colorMode & 12)) {
                configuration3.colorMode |= configuration2.colorMode & 12;
            }
        }
    }
}
