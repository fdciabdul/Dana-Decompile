package androidx.appcompat.app;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.TypedValue;
import android.view.ContextThemeWrapper;
import android.view.KeyCharacterMap;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import androidx.appcompat.R;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.view.ActionBarPolicy;
import androidx.appcompat.view.ActionMode;
import androidx.appcompat.view.SupportMenuInflater;
import androidx.appcompat.view.ViewPropertyAnimatorCompatSet;
import androidx.appcompat.view.menu.MenuBuilder;
import androidx.appcompat.widget.ActionBarContainer;
import androidx.appcompat.widget.ActionBarContextView;
import androidx.appcompat.widget.ActionBarOverlayLayout;
import androidx.appcompat.widget.DecorToolbar;
import androidx.appcompat.widget.ScrollingTabContainerView;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.ViewCompat;
import androidx.core.view.ViewPropertyAnimatorCompat;
import androidx.core.view.ViewPropertyAnimatorListener;
import androidx.core.view.ViewPropertyAnimatorListenerAdapter;
import androidx.core.view.ViewPropertyAnimatorUpdateListener;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentTransaction;
import java.lang.ref.WeakReference;
import java.util.ArrayList;

/* loaded from: classes.dex */
public class WindowDecorActionBar extends ActionBar implements ActionBarOverlayLayout.ActionBarVisibilityCallback {
    private static final Interpolator NetworkUserEntityData$$ExternalSyntheticLambda4 = new AccelerateInterpolator();
    private static final Interpolator NetworkUserEntityData$$ExternalSyntheticLambda5 = new DecelerateInterpolator();
    private Context A;
    private boolean BottomSheetCardBindingView$watcherCardNumberView$1;
    View BuiltInFictitiousFunctionClassFactory;
    boolean GetContactSyncConfig;
    Activity KClassImpl$Data$declaredNonStaticMembers$2;
    ActionBarContainer MyBillsEntityDataFactory;
    ActionBarContextView NetworkUserEntityData$$ExternalSyntheticLambda0;
    boolean NetworkUserEntityData$$ExternalSyntheticLambda1;
    boolean NetworkUserEntityData$$ExternalSyntheticLambda2;
    private boolean NetworkUserEntityData$$ExternalSyntheticLambda6;
    ActionBarOverlayLayout NetworkUserEntityData$$ExternalSyntheticLambda7;
    TabImpl NetworkUserEntityData$$ExternalSyntheticLambda8;
    ActionModeImpl PlaceComponentResult;
    ViewPropertyAnimatorCompatSet getErrorConfigVersion;
    private boolean getSupportButtonTintMode;
    ActionMode.Callback initRecordTimeStamp;
    ActionMode lookAheadTest;
    DecorToolbar moveToNextValue;
    ScrollingTabContainerView newProxyInstance;
    private boolean readMicros;
    Context scheduleImpl;
    private boolean whenAvailable;
    private ArrayList<TabImpl> VerifyPinStateManager$executeRiskChallenge$2$1 = new ArrayList<>();
    int PrepareContext = -1;
    private ArrayList<ActionBar.OnMenuVisibilityListener> getCallingPid = new ArrayList<>();
    private int FragmentBottomSheetPaymentSettingBinding = 0;
    boolean getAuthRequestContext = true;
    private boolean SubSequence = true;
    final ViewPropertyAnimatorListener DatabaseTableConfigUtil = new ViewPropertyAnimatorListenerAdapter() { // from class: androidx.appcompat.app.WindowDecorActionBar.1
        {
            WindowDecorActionBar.this = this;
        }

        @Override // androidx.core.view.ViewPropertyAnimatorListenerAdapter, androidx.core.view.ViewPropertyAnimatorListener
        public void getAuthRequestContext(View view) {
            if (WindowDecorActionBar.this.getAuthRequestContext && WindowDecorActionBar.this.BuiltInFictitiousFunctionClassFactory != null) {
                WindowDecorActionBar.this.BuiltInFictitiousFunctionClassFactory.setTranslationY(0.0f);
                WindowDecorActionBar.this.MyBillsEntityDataFactory.setTranslationY(0.0f);
            }
            WindowDecorActionBar.this.MyBillsEntityDataFactory.setVisibility(8);
            WindowDecorActionBar.this.MyBillsEntityDataFactory.setTransitioning(false);
            WindowDecorActionBar.this.getErrorConfigVersion = null;
            WindowDecorActionBar windowDecorActionBar = WindowDecorActionBar.this;
            ActionMode.Callback callback = windowDecorActionBar.initRecordTimeStamp;
            if (callback != null) {
                callback.KClassImpl$Data$declaredNonStaticMembers$2(windowDecorActionBar.lookAheadTest);
                windowDecorActionBar.lookAheadTest = null;
                windowDecorActionBar.initRecordTimeStamp = null;
            }
            if (WindowDecorActionBar.this.NetworkUserEntityData$$ExternalSyntheticLambda7 != null) {
                ViewCompat.I(WindowDecorActionBar.this.NetworkUserEntityData$$ExternalSyntheticLambda7);
            }
        }
    };
    final ViewPropertyAnimatorListener isLayoutRequested = new ViewPropertyAnimatorListenerAdapter() { // from class: androidx.appcompat.app.WindowDecorActionBar.2
        {
            WindowDecorActionBar.this = this;
        }

        @Override // androidx.core.view.ViewPropertyAnimatorListenerAdapter, androidx.core.view.ViewPropertyAnimatorListener
        public void getAuthRequestContext(View view) {
            WindowDecorActionBar.this.getErrorConfigVersion = null;
            WindowDecorActionBar.this.MyBillsEntityDataFactory.requestLayout();
        }
    };
    final ViewPropertyAnimatorUpdateListener NetworkUserEntityData$$ExternalSyntheticLambda3 = new ViewPropertyAnimatorUpdateListener() { // from class: androidx.appcompat.app.WindowDecorActionBar.3
        {
            WindowDecorActionBar.this = this;
        }

        @Override // androidx.core.view.ViewPropertyAnimatorUpdateListener
        public final void PlaceComponentResult() {
            ((View) WindowDecorActionBar.this.MyBillsEntityDataFactory.getParent()).invalidate();
        }
    };

    static boolean getAuthRequestContext(boolean z, boolean z2, boolean z3) {
        if (z3) {
            return true;
        }
        return (z || z2) ? false : true;
    }

    public WindowDecorActionBar(Activity activity, boolean z) {
        this.KClassImpl$Data$declaredNonStaticMembers$2 = activity;
        View decorView = activity.getWindow().getDecorView();
        MyBillsEntityDataFactory(decorView);
        if (z) {
            return;
        }
        this.BuiltInFictitiousFunctionClassFactory = decorView.findViewById(16908290);
    }

    public WindowDecorActionBar(Dialog dialog) {
        MyBillsEntityDataFactory(dialog.getWindow().getDecorView());
    }

    private void MyBillsEntityDataFactory(View view) {
        ActionBarOverlayLayout actionBarOverlayLayout = (ActionBarOverlayLayout) view.findViewById(R.id.isLayoutRequested);
        this.NetworkUserEntityData$$ExternalSyntheticLambda7 = actionBarOverlayLayout;
        if (actionBarOverlayLayout != null) {
            actionBarOverlayLayout.setActionBarVisibilityCallback(this);
        }
        this.moveToNextValue = KClassImpl$Data$declaredNonStaticMembers$2(view.findViewById(R.id.KClassImpl$Data$declaredNonStaticMembers$2));
        this.NetworkUserEntityData$$ExternalSyntheticLambda0 = (ActionBarContextView) view.findViewById(R.id.scheduleImpl);
        ActionBarContainer actionBarContainer = (ActionBarContainer) view.findViewById(R.id.PlaceComponentResult);
        this.MyBillsEntityDataFactory = actionBarContainer;
        DecorToolbar decorToolbar = this.moveToNextValue;
        if (decorToolbar == null || this.NetworkUserEntityData$$ExternalSyntheticLambda0 == null || actionBarContainer == null) {
            StringBuilder sb = new StringBuilder();
            sb.append(getClass().getSimpleName());
            sb.append(" can only be used with a compatible window decor layout");
            throw new IllegalStateException(sb.toString());
        }
        this.scheduleImpl = decorToolbar.BuiltInFictitiousFunctionClassFactory();
        if ((this.moveToNextValue.KClassImpl$Data$declaredNonStaticMembers$2() & 4) != 0) {
            this.NetworkUserEntityData$$ExternalSyntheticLambda6 = true;
        }
        ActionBarPolicy PlaceComponentResult = ActionBarPolicy.PlaceComponentResult(this.scheduleImpl);
        PlaceComponentResult.BuiltInFictitiousFunctionClassFactory();
        getErrorConfigVersion(PlaceComponentResult.KClassImpl$Data$declaredNonStaticMembers$2());
        TypedArray obtainStyledAttributes = this.scheduleImpl.obtainStyledAttributes(null, R.styleable.KClassImpl$Data$declaredNonStaticMembers$2, R.attr.KClassImpl$Data$declaredNonStaticMembers$2, 0);
        if (obtainStyledAttributes.getBoolean(R.styleable.initRecordTimeStamp, false)) {
            DatabaseTableConfigUtil();
        }
        int dimensionPixelSize = obtainStyledAttributes.getDimensionPixelSize(R.styleable.DatabaseTableConfigUtil, 0);
        if (dimensionPixelSize != 0) {
            ViewCompat.MyBillsEntityDataFactory(this.MyBillsEntityDataFactory, dimensionPixelSize);
        }
        obtainStyledAttributes.recycle();
    }

    private static DecorToolbar KClassImpl$Data$declaredNonStaticMembers$2(View view) {
        if (view instanceof DecorToolbar) {
            return (DecorToolbar) view;
        }
        if (view instanceof Toolbar) {
            return ((Toolbar) view).getWrapper();
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Can't make a decor toolbar out of ");
        sb.append(view != null ? view.getClass().getSimpleName() : "null");
        throw new IllegalStateException(sb.toString());
    }

    @Override // androidx.appcompat.app.ActionBar
    public final void PlaceComponentResult(Configuration configuration) {
        getErrorConfigVersion(ActionBarPolicy.PlaceComponentResult(this.scheduleImpl).KClassImpl$Data$declaredNonStaticMembers$2());
    }

    private void getErrorConfigVersion(boolean z) {
        this.readMicros = z;
        if (!z) {
            this.moveToNextValue.PlaceComponentResult((ScrollingTabContainerView) null);
            this.MyBillsEntityDataFactory.setTabContainer(this.newProxyInstance);
        } else {
            this.MyBillsEntityDataFactory.setTabContainer(null);
            this.moveToNextValue.PlaceComponentResult(this.newProxyInstance);
        }
        boolean z2 = this.moveToNextValue.moveToNextValue() == 2;
        ScrollingTabContainerView scrollingTabContainerView = this.newProxyInstance;
        if (scrollingTabContainerView != null) {
            if (z2) {
                scrollingTabContainerView.setVisibility(0);
                ActionBarOverlayLayout actionBarOverlayLayout = this.NetworkUserEntityData$$ExternalSyntheticLambda7;
                if (actionBarOverlayLayout != null) {
                    ViewCompat.I(actionBarOverlayLayout);
                }
            } else {
                scrollingTabContainerView.setVisibility(8);
            }
        }
        this.moveToNextValue.MyBillsEntityDataFactory(!this.readMicros && z2);
        this.NetworkUserEntityData$$ExternalSyntheticLambda7.setHasNonEmbeddedTabs(!this.readMicros && z2);
    }

    @Override // androidx.appcompat.widget.ActionBarOverlayLayout.ActionBarVisibilityCallback
    public final void BuiltInFictitiousFunctionClassFactory(int i) {
        this.FragmentBottomSheetPaymentSettingBinding = i;
    }

    @Override // androidx.appcompat.app.ActionBar
    public final void BuiltInFictitiousFunctionClassFactory(boolean z) {
        ViewPropertyAnimatorCompatSet viewPropertyAnimatorCompatSet;
        this.getSupportButtonTintMode = z;
        if (z || (viewPropertyAnimatorCompatSet = this.getErrorConfigVersion) == null) {
            return;
        }
        viewPropertyAnimatorCompatSet.BuiltInFictitiousFunctionClassFactory();
    }

    @Override // androidx.appcompat.app.ActionBar
    public final void PlaceComponentResult(boolean z) {
        if (z == this.whenAvailable) {
            return;
        }
        this.whenAvailable = z;
        int size = this.getCallingPid.size();
        for (int i = 0; i < size; i++) {
            this.getCallingPid.get(i);
        }
    }

    @Override // androidx.appcompat.app.ActionBar
    public final void KClassImpl$Data$declaredNonStaticMembers$2(boolean z) {
        MyBillsEntityDataFactory(z ? 4 : 0, 4);
    }

    @Override // androidx.appcompat.app.ActionBar
    public final void getErrorConfigVersion() {
        MyBillsEntityDataFactory(0, 8);
    }

    @Override // androidx.appcompat.app.ActionBar
    public final void BuiltInFictitiousFunctionClassFactory(CharSequence charSequence) {
        this.moveToNextValue.KClassImpl$Data$declaredNonStaticMembers$2(charSequence);
    }

    @Override // androidx.appcompat.app.ActionBar
    public final void KClassImpl$Data$declaredNonStaticMembers$2(CharSequence charSequence) {
        this.moveToNextValue.getAuthRequestContext(charSequence);
    }

    private void MyBillsEntityDataFactory(int i, int i2) {
        int KClassImpl$Data$declaredNonStaticMembers$2 = this.moveToNextValue.KClassImpl$Data$declaredNonStaticMembers$2();
        if ((i2 & 4) != 0) {
            this.NetworkUserEntityData$$ExternalSyntheticLambda6 = true;
        }
        this.moveToNextValue.getAuthRequestContext((i & i2) | ((i2 ^ (-1)) & KClassImpl$Data$declaredNonStaticMembers$2));
    }

    @Override // androidx.appcompat.app.ActionBar
    public final int KClassImpl$Data$declaredNonStaticMembers$2() {
        return this.moveToNextValue.KClassImpl$Data$declaredNonStaticMembers$2();
    }

    @Override // androidx.appcompat.app.ActionBar
    public final ActionMode KClassImpl$Data$declaredNonStaticMembers$2(ActionMode.Callback callback) {
        ActionModeImpl actionModeImpl = this.PlaceComponentResult;
        if (actionModeImpl != null) {
            actionModeImpl.BuiltInFictitiousFunctionClassFactory();
        }
        this.NetworkUserEntityData$$ExternalSyntheticLambda7.setHideOnContentScrollEnabled(false);
        this.NetworkUserEntityData$$ExternalSyntheticLambda0.killMode();
        ActionModeImpl actionModeImpl2 = new ActionModeImpl(this.NetworkUserEntityData$$ExternalSyntheticLambda0.getContext(), callback);
        if (actionModeImpl2.getAuthRequestContext()) {
            this.PlaceComponentResult = actionModeImpl2;
            actionModeImpl2.lookAheadTest();
            this.NetworkUserEntityData$$ExternalSyntheticLambda0.initForMode(actionModeImpl2);
            MyBillsEntityDataFactory(true);
            return actionModeImpl2;
        }
        return null;
    }

    @Override // androidx.appcompat.app.ActionBar
    public final int getAuthRequestContext() {
        return this.MyBillsEntityDataFactory.getHeight();
    }

    @Override // androidx.appcompat.widget.ActionBarOverlayLayout.ActionBarVisibilityCallback
    public final void moveToNextValue(boolean z) {
        this.getAuthRequestContext = z;
    }

    @Override // androidx.appcompat.widget.ActionBarOverlayLayout.ActionBarVisibilityCallback
    public final void NetworkUserEntityData$$ExternalSyntheticLambda1() {
        if (this.GetContactSyncConfig) {
            this.GetContactSyncConfig = false;
            scheduleImpl(true);
        }
    }

    @Override // androidx.appcompat.app.ActionBar
    public final void scheduleImpl() {
        if (this.NetworkUserEntityData$$ExternalSyntheticLambda2) {
            return;
        }
        this.NetworkUserEntityData$$ExternalSyntheticLambda2 = true;
        scheduleImpl(false);
    }

    @Override // androidx.appcompat.widget.ActionBarOverlayLayout.ActionBarVisibilityCallback
    public final void GetContactSyncConfig() {
        if (this.GetContactSyncConfig) {
            return;
        }
        this.GetContactSyncConfig = true;
        scheduleImpl(true);
    }

    @Override // androidx.appcompat.app.ActionBar
    public final void DatabaseTableConfigUtil() {
        if (!this.NetworkUserEntityData$$ExternalSyntheticLambda7.isInOverlayMode()) {
            throw new IllegalStateException("Action bar must be in overlay mode (Window.FEATURE_OVERLAY_ACTION_BAR) to enable hide on content scroll");
        }
        this.NetworkUserEntityData$$ExternalSyntheticLambda1 = true;
        this.NetworkUserEntityData$$ExternalSyntheticLambda7.setHideOnContentScrollEnabled(true);
    }

    private void scheduleImpl(boolean z) {
        View view;
        View view2;
        View view3;
        if (getAuthRequestContext(this.NetworkUserEntityData$$ExternalSyntheticLambda2, this.GetContactSyncConfig, this.BottomSheetCardBindingView$watcherCardNumberView$1)) {
            if (this.SubSequence) {
                return;
            }
            this.SubSequence = true;
            ViewPropertyAnimatorCompatSet viewPropertyAnimatorCompatSet = this.getErrorConfigVersion;
            if (viewPropertyAnimatorCompatSet != null) {
                viewPropertyAnimatorCompatSet.BuiltInFictitiousFunctionClassFactory();
            }
            this.MyBillsEntityDataFactory.setVisibility(0);
            if (this.FragmentBottomSheetPaymentSettingBinding == 0 && (this.getSupportButtonTintMode || z)) {
                this.MyBillsEntityDataFactory.setTranslationY(0.0f);
                float f = -this.MyBillsEntityDataFactory.getHeight();
                if (z) {
                    this.MyBillsEntityDataFactory.getLocationInWindow(new int[]{0, 0});
                    f -= r9[1];
                }
                this.MyBillsEntityDataFactory.setTranslationY(f);
                ViewPropertyAnimatorCompatSet viewPropertyAnimatorCompatSet2 = new ViewPropertyAnimatorCompatSet();
                ViewPropertyAnimatorCompat PlaceComponentResult = ViewCompat.MyBillsEntityDataFactory(this.MyBillsEntityDataFactory).PlaceComponentResult(0.0f);
                PlaceComponentResult.PlaceComponentResult(this.NetworkUserEntityData$$ExternalSyntheticLambda3);
                viewPropertyAnimatorCompatSet2.PlaceComponentResult(PlaceComponentResult);
                if (this.getAuthRequestContext && (view3 = this.BuiltInFictitiousFunctionClassFactory) != null) {
                    view3.setTranslationY(f);
                    viewPropertyAnimatorCompatSet2.PlaceComponentResult(ViewCompat.MyBillsEntityDataFactory(this.BuiltInFictitiousFunctionClassFactory).PlaceComponentResult(0.0f));
                }
                viewPropertyAnimatorCompatSet2.PlaceComponentResult(NetworkUserEntityData$$ExternalSyntheticLambda5);
                viewPropertyAnimatorCompatSet2.BuiltInFictitiousFunctionClassFactory(250L);
                viewPropertyAnimatorCompatSet2.KClassImpl$Data$declaredNonStaticMembers$2(this.isLayoutRequested);
                this.getErrorConfigVersion = viewPropertyAnimatorCompatSet2;
                viewPropertyAnimatorCompatSet2.MyBillsEntityDataFactory();
            } else {
                this.MyBillsEntityDataFactory.setAlpha(1.0f);
                this.MyBillsEntityDataFactory.setTranslationY(0.0f);
                if (this.getAuthRequestContext && (view2 = this.BuiltInFictitiousFunctionClassFactory) != null) {
                    view2.setTranslationY(0.0f);
                }
                this.isLayoutRequested.getAuthRequestContext(null);
            }
            ActionBarOverlayLayout actionBarOverlayLayout = this.NetworkUserEntityData$$ExternalSyntheticLambda7;
            if (actionBarOverlayLayout != null) {
                ViewCompat.I(actionBarOverlayLayout);
            }
        } else if (this.SubSequence) {
            this.SubSequence = false;
            ViewPropertyAnimatorCompatSet viewPropertyAnimatorCompatSet3 = this.getErrorConfigVersion;
            if (viewPropertyAnimatorCompatSet3 != null) {
                viewPropertyAnimatorCompatSet3.BuiltInFictitiousFunctionClassFactory();
            }
            if (this.FragmentBottomSheetPaymentSettingBinding == 0 && (this.getSupportButtonTintMode || z)) {
                this.MyBillsEntityDataFactory.setAlpha(1.0f);
                this.MyBillsEntityDataFactory.setTransitioning(true);
                ViewPropertyAnimatorCompatSet viewPropertyAnimatorCompatSet4 = new ViewPropertyAnimatorCompatSet();
                float f2 = -this.MyBillsEntityDataFactory.getHeight();
                if (z) {
                    this.MyBillsEntityDataFactory.getLocationInWindow(new int[]{0, 0});
                    f2 -= r9[1];
                }
                ViewPropertyAnimatorCompat PlaceComponentResult2 = ViewCompat.MyBillsEntityDataFactory(this.MyBillsEntityDataFactory).PlaceComponentResult(f2);
                PlaceComponentResult2.PlaceComponentResult(this.NetworkUserEntityData$$ExternalSyntheticLambda3);
                viewPropertyAnimatorCompatSet4.PlaceComponentResult(PlaceComponentResult2);
                if (this.getAuthRequestContext && (view = this.BuiltInFictitiousFunctionClassFactory) != null) {
                    viewPropertyAnimatorCompatSet4.PlaceComponentResult(ViewCompat.MyBillsEntityDataFactory(view).PlaceComponentResult(f2));
                }
                viewPropertyAnimatorCompatSet4.PlaceComponentResult(NetworkUserEntityData$$ExternalSyntheticLambda4);
                viewPropertyAnimatorCompatSet4.BuiltInFictitiousFunctionClassFactory(250L);
                viewPropertyAnimatorCompatSet4.KClassImpl$Data$declaredNonStaticMembers$2(this.DatabaseTableConfigUtil);
                this.getErrorConfigVersion = viewPropertyAnimatorCompatSet4;
                viewPropertyAnimatorCompatSet4.MyBillsEntityDataFactory();
                return;
            }
            this.DatabaseTableConfigUtil.getAuthRequestContext(null);
        }
    }

    private boolean initRecordTimeStamp() {
        return ViewCompat.getValueOfTouchPositionAbsolute(this.MyBillsEntityDataFactory);
    }

    @Override // androidx.appcompat.app.ActionBar
    public final Context BuiltInFictitiousFunctionClassFactory() {
        if (this.A == null) {
            TypedValue typedValue = new TypedValue();
            this.scheduleImpl.getTheme().resolveAttribute(R.attr.lookAheadTest, typedValue, true);
            int i = typedValue.resourceId;
            if (i != 0) {
                this.A = new ContextThemeWrapper(this.scheduleImpl, i);
            } else {
                this.A = this.scheduleImpl;
            }
        }
        return this.A;
    }

    @Override // androidx.appcompat.app.ActionBar
    public final void KClassImpl$Data$declaredNonStaticMembers$2(Drawable drawable) {
        this.moveToNextValue.PlaceComponentResult(drawable);
    }

    @Override // androidx.appcompat.app.ActionBar
    public final void KClassImpl$Data$declaredNonStaticMembers$2(int i) {
        this.moveToNextValue.MyBillsEntityDataFactory(i);
    }

    @Override // androidx.appcompat.widget.ActionBarOverlayLayout.ActionBarVisibilityCallback
    public final void NetworkUserEntityData$$ExternalSyntheticLambda2() {
        ViewPropertyAnimatorCompatSet viewPropertyAnimatorCompatSet = this.getErrorConfigVersion;
        if (viewPropertyAnimatorCompatSet != null) {
            viewPropertyAnimatorCompatSet.BuiltInFictitiousFunctionClassFactory();
            this.getErrorConfigVersion = null;
        }
    }

    @Override // androidx.appcompat.app.ActionBar
    public final boolean MyBillsEntityDataFactory() {
        DecorToolbar decorToolbar = this.moveToNextValue;
        if (decorToolbar == null || !decorToolbar.DatabaseTableConfigUtil()) {
            return false;
        }
        this.moveToNextValue.MyBillsEntityDataFactory();
        return true;
    }

    /* loaded from: classes.dex */
    public class ActionModeImpl extends ActionMode implements MenuBuilder.Callback {
        private final Context BuiltInFictitiousFunctionClassFactory;
        private ActionMode.Callback MyBillsEntityDataFactory;
        final MenuBuilder getAuthRequestContext;
        private WeakReference<View> moveToNextValue;

        public ActionModeImpl(Context context, ActionMode.Callback callback) {
            WindowDecorActionBar.this = r1;
            this.BuiltInFictitiousFunctionClassFactory = context;
            this.MyBillsEntityDataFactory = callback;
            MenuBuilder defaultShowAsAction = new MenuBuilder(context).setDefaultShowAsAction(1);
            this.getAuthRequestContext = defaultShowAsAction;
            defaultShowAsAction.setCallback(this);
        }

        @Override // androidx.appcompat.view.ActionMode
        public final MenuInflater MyBillsEntityDataFactory() {
            return new SupportMenuInflater(this.BuiltInFictitiousFunctionClassFactory);
        }

        @Override // androidx.appcompat.view.ActionMode
        public final Menu PlaceComponentResult() {
            return this.getAuthRequestContext;
        }

        @Override // androidx.appcompat.view.ActionMode
        public final void BuiltInFictitiousFunctionClassFactory() {
            if (WindowDecorActionBar.this.PlaceComponentResult != this) {
                return;
            }
            if (!WindowDecorActionBar.getAuthRequestContext(WindowDecorActionBar.this.NetworkUserEntityData$$ExternalSyntheticLambda2, WindowDecorActionBar.this.GetContactSyncConfig, false)) {
                WindowDecorActionBar.this.lookAheadTest = this;
                WindowDecorActionBar.this.initRecordTimeStamp = this.MyBillsEntityDataFactory;
            } else {
                this.MyBillsEntityDataFactory.KClassImpl$Data$declaredNonStaticMembers$2(this);
            }
            this.MyBillsEntityDataFactory = null;
            WindowDecorActionBar.this.MyBillsEntityDataFactory(false);
            WindowDecorActionBar.this.NetworkUserEntityData$$ExternalSyntheticLambda0.closeMode();
            WindowDecorActionBar.this.NetworkUserEntityData$$ExternalSyntheticLambda7.setHideOnContentScrollEnabled(WindowDecorActionBar.this.NetworkUserEntityData$$ExternalSyntheticLambda1);
            WindowDecorActionBar.this.PlaceComponentResult = null;
        }

        @Override // androidx.appcompat.view.ActionMode
        public final void lookAheadTest() {
            if (WindowDecorActionBar.this.PlaceComponentResult != this) {
                return;
            }
            this.getAuthRequestContext.stopDispatchingItemsChanged();
            try {
                this.MyBillsEntityDataFactory.BuiltInFictitiousFunctionClassFactory(this, this.getAuthRequestContext);
            } finally {
                this.getAuthRequestContext.startDispatchingItemsChanged();
            }
        }

        public final boolean getAuthRequestContext() {
            this.getAuthRequestContext.stopDispatchingItemsChanged();
            try {
                return this.MyBillsEntityDataFactory.getAuthRequestContext(this, this.getAuthRequestContext);
            } finally {
                this.getAuthRequestContext.startDispatchingItemsChanged();
            }
        }

        @Override // androidx.appcompat.view.ActionMode
        public final void MyBillsEntityDataFactory(View view) {
            WindowDecorActionBar.this.NetworkUserEntityData$$ExternalSyntheticLambda0.setCustomView(view);
            this.moveToNextValue = new WeakReference<>(view);
        }

        @Override // androidx.appcompat.view.ActionMode
        public final void KClassImpl$Data$declaredNonStaticMembers$2(CharSequence charSequence) {
            WindowDecorActionBar.this.NetworkUserEntityData$$ExternalSyntheticLambda0.setSubtitle(charSequence);
        }

        @Override // androidx.appcompat.view.ActionMode
        public final void MyBillsEntityDataFactory(CharSequence charSequence) {
            WindowDecorActionBar.this.NetworkUserEntityData$$ExternalSyntheticLambda0.setTitle(charSequence);
        }

        @Override // androidx.appcompat.view.ActionMode
        public final void PlaceComponentResult(int i) {
            WindowDecorActionBar.this.NetworkUserEntityData$$ExternalSyntheticLambda0.setTitle(WindowDecorActionBar.this.scheduleImpl.getResources().getString(i));
        }

        @Override // androidx.appcompat.view.ActionMode
        public final void getAuthRequestContext(int i) {
            WindowDecorActionBar.this.NetworkUserEntityData$$ExternalSyntheticLambda0.setSubtitle(WindowDecorActionBar.this.scheduleImpl.getResources().getString(i));
        }

        @Override // androidx.appcompat.view.ActionMode
        public final CharSequence getErrorConfigVersion() {
            return WindowDecorActionBar.this.NetworkUserEntityData$$ExternalSyntheticLambda0.getTitle();
        }

        @Override // androidx.appcompat.view.ActionMode
        public final CharSequence NetworkUserEntityData$$ExternalSyntheticLambda0() {
            return WindowDecorActionBar.this.NetworkUserEntityData$$ExternalSyntheticLambda0.getSubtitle();
        }

        @Override // androidx.appcompat.view.ActionMode
        public final void MyBillsEntityDataFactory(boolean z) {
            super.MyBillsEntityDataFactory(z);
            WindowDecorActionBar.this.NetworkUserEntityData$$ExternalSyntheticLambda0.setTitleOptional(z);
        }

        @Override // androidx.appcompat.view.ActionMode
        public final boolean scheduleImpl() {
            return WindowDecorActionBar.this.NetworkUserEntityData$$ExternalSyntheticLambda0.isTitleOptional();
        }

        @Override // androidx.appcompat.view.ActionMode
        public final View KClassImpl$Data$declaredNonStaticMembers$2() {
            WeakReference<View> weakReference = this.moveToNextValue;
            if (weakReference != null) {
                return weakReference.get();
            }
            return null;
        }

        @Override // androidx.appcompat.view.menu.MenuBuilder.Callback
        public boolean onMenuItemSelected(MenuBuilder menuBuilder, MenuItem menuItem) {
            ActionMode.Callback callback = this.MyBillsEntityDataFactory;
            if (callback != null) {
                return callback.getAuthRequestContext(this, menuItem);
            }
            return false;
        }

        @Override // androidx.appcompat.view.menu.MenuBuilder.Callback
        public void onMenuModeChange(MenuBuilder menuBuilder) {
            if (this.MyBillsEntityDataFactory == null) {
                return;
            }
            lookAheadTest();
            WindowDecorActionBar.this.NetworkUserEntityData$$ExternalSyntheticLambda0.showOverflowMenu();
        }
    }

    /* loaded from: classes.dex */
    public class TabImpl extends ActionBar.Tab {
        private CharSequence BuiltInFictitiousFunctionClassFactory;
        private View KClassImpl$Data$declaredNonStaticMembers$2;
        private Drawable MyBillsEntityDataFactory;
        final /* synthetic */ WindowDecorActionBar PlaceComponentResult;
        ActionBar.TabListener getAuthRequestContext;
        private CharSequence getErrorConfigVersion;
        private int scheduleImpl;

        @Override // androidx.appcompat.app.ActionBar.Tab
        public final View PlaceComponentResult() {
            return this.KClassImpl$Data$declaredNonStaticMembers$2;
        }

        @Override // androidx.appcompat.app.ActionBar.Tab
        public final Drawable BuiltInFictitiousFunctionClassFactory() {
            return this.MyBillsEntityDataFactory;
        }

        @Override // androidx.appcompat.app.ActionBar.Tab
        public final int getAuthRequestContext() {
            return this.scheduleImpl;
        }

        @Override // androidx.appcompat.app.ActionBar.Tab
        public final CharSequence MyBillsEntityDataFactory() {
            return this.getErrorConfigVersion;
        }

        @Override // androidx.appcompat.app.ActionBar.Tab
        public final void moveToNextValue() {
            FragmentTransaction fragmentTransaction;
            WindowDecorActionBar windowDecorActionBar = this.PlaceComponentResult;
            if (windowDecorActionBar.moveToNextValue.moveToNextValue() != 2) {
                windowDecorActionBar.PrepareContext = getAuthRequestContext();
                return;
            }
            if (!(windowDecorActionBar.KClassImpl$Data$declaredNonStaticMembers$2 instanceof FragmentActivity) || windowDecorActionBar.moveToNextValue.getErrorConfigVersion().isInEditMode()) {
                fragmentTransaction = null;
            } else {
                fragmentTransaction = ((FragmentActivity) windowDecorActionBar.KClassImpl$Data$declaredNonStaticMembers$2).getSupportFragmentManager().beginTransaction();
                if (fragmentTransaction.scheduleImpl) {
                    throw new IllegalStateException("This transaction is already being added to the back stack");
                }
                fragmentTransaction.NetworkUserEntityData$$ExternalSyntheticLambda0 = false;
            }
            TabImpl tabImpl = windowDecorActionBar.NetworkUserEntityData$$ExternalSyntheticLambda8;
            if (tabImpl != this) {
                windowDecorActionBar.newProxyInstance.setTabSelected(getAuthRequestContext());
                TabImpl tabImpl2 = windowDecorActionBar.NetworkUserEntityData$$ExternalSyntheticLambda8;
                if (tabImpl2 != null) {
                    ActionBar.TabListener tabListener = tabImpl2.getAuthRequestContext;
                    TabImpl tabImpl3 = windowDecorActionBar.NetworkUserEntityData$$ExternalSyntheticLambda8;
                }
                windowDecorActionBar.NetworkUserEntityData$$ExternalSyntheticLambda8 = this;
                TabImpl tabImpl4 = windowDecorActionBar.NetworkUserEntityData$$ExternalSyntheticLambda8;
            } else if (tabImpl != null) {
                ActionBar.TabListener tabListener2 = tabImpl.getAuthRequestContext;
                TabImpl tabImpl5 = windowDecorActionBar.NetworkUserEntityData$$ExternalSyntheticLambda8;
                windowDecorActionBar.newProxyInstance.animateToTab(getAuthRequestContext());
            }
            if (fragmentTransaction == null || fragmentTransaction.NetworkUserEntityData$$ExternalSyntheticLambda0()) {
                return;
            }
            fragmentTransaction.getAuthRequestContext();
        }

        @Override // androidx.appcompat.app.ActionBar.Tab
        public final CharSequence KClassImpl$Data$declaredNonStaticMembers$2() {
            return this.BuiltInFictitiousFunctionClassFactory;
        }
    }

    @Override // androidx.appcompat.app.ActionBar
    public final void getAuthRequestContext(boolean z) {
        if (this.NetworkUserEntityData$$ExternalSyntheticLambda6) {
            return;
        }
        MyBillsEntityDataFactory(z ? 4 : 0, 4);
    }

    @Override // androidx.appcompat.app.ActionBar
    public final boolean KClassImpl$Data$declaredNonStaticMembers$2(int i, KeyEvent keyEvent) {
        MenuBuilder menuBuilder;
        ActionModeImpl actionModeImpl = this.PlaceComponentResult;
        if (actionModeImpl == null || (menuBuilder = actionModeImpl.getAuthRequestContext) == null) {
            return false;
        }
        menuBuilder.setQwertyMode(KeyCharacterMap.load(keyEvent != null ? keyEvent.getDeviceId() : -1).getKeyboardType() != 1);
        return menuBuilder.performShortcut(i, keyEvent, 0);
    }

    public final void MyBillsEntityDataFactory(boolean z) {
        ViewPropertyAnimatorCompat PlaceComponentResult;
        ViewPropertyAnimatorCompat viewPropertyAnimatorCompat;
        if (z) {
            if (!this.BottomSheetCardBindingView$watcherCardNumberView$1) {
                this.BottomSheetCardBindingView$watcherCardNumberView$1 = true;
                ActionBarOverlayLayout actionBarOverlayLayout = this.NetworkUserEntityData$$ExternalSyntheticLambda7;
                if (actionBarOverlayLayout != null) {
                    actionBarOverlayLayout.setShowingForActionMode(true);
                }
                scheduleImpl(false);
            }
        } else if (this.BottomSheetCardBindingView$watcherCardNumberView$1) {
            this.BottomSheetCardBindingView$watcherCardNumberView$1 = false;
            ActionBarOverlayLayout actionBarOverlayLayout2 = this.NetworkUserEntityData$$ExternalSyntheticLambda7;
            if (actionBarOverlayLayout2 != null) {
                actionBarOverlayLayout2.setShowingForActionMode(false);
            }
            scheduleImpl(false);
        }
        if (!initRecordTimeStamp()) {
            if (z) {
                this.moveToNextValue.KClassImpl$Data$declaredNonStaticMembers$2(4);
                this.NetworkUserEntityData$$ExternalSyntheticLambda0.setVisibility(0);
                return;
            }
            this.moveToNextValue.KClassImpl$Data$declaredNonStaticMembers$2(0);
            this.NetworkUserEntityData$$ExternalSyntheticLambda0.setVisibility(8);
            return;
        }
        if (z) {
            viewPropertyAnimatorCompat = this.moveToNextValue.PlaceComponentResult(4, 100L);
            PlaceComponentResult = this.NetworkUserEntityData$$ExternalSyntheticLambda0.setupAnimatorToVisibility(0, 200L);
        } else {
            PlaceComponentResult = this.moveToNextValue.PlaceComponentResult(0, 200L);
            viewPropertyAnimatorCompat = this.NetworkUserEntityData$$ExternalSyntheticLambda0.setupAnimatorToVisibility(8, 100L);
        }
        ViewPropertyAnimatorCompatSet viewPropertyAnimatorCompatSet = new ViewPropertyAnimatorCompatSet();
        viewPropertyAnimatorCompatSet.KClassImpl$Data$declaredNonStaticMembers$2(viewPropertyAnimatorCompat, PlaceComponentResult);
        viewPropertyAnimatorCompatSet.MyBillsEntityDataFactory();
    }
}
