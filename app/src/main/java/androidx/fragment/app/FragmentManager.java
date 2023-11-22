package androidx.fragment.app;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.Intent;
import android.content.IntentSender;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.Looper;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.core.app.ActivityCompat;
import androidx.core.app.MultiWindowModeChangedInfo;
import androidx.core.app.OnMultiWindowModeChangedProvider;
import androidx.core.app.OnPictureInPictureModeChangedProvider;
import androidx.core.app.PictureInPictureModeChangedInfo;
import androidx.core.content.ContextCompat;
import androidx.core.content.OnConfigurationChangedProvider;
import androidx.core.content.OnTrimMemoryProvider;
import androidx.core.util.Consumer;
import androidx.core.view.MenuHost;
import androidx.core.view.MenuProvider;
import androidx.fragment.R;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentLifecycleCallbacksDispatcher;
import androidx.fragment.app.FragmentTransaction;
import androidx.fragment.app.strictmode.FragmentStrictMode;
import androidx.view.Lifecycle;
import androidx.view.LifecycleEventObserver;
import androidx.view.LifecycleOwner;
import androidx.view.OnBackPressedCallback;
import androidx.view.OnBackPressedDispatcher;
import androidx.view.OnBackPressedDispatcherOwner;
import androidx.view.SavedStateRegistry;
import androidx.view.SavedStateRegistryOwner;
import androidx.view.ViewModelStore;
import androidx.view.ViewModelStoreOwner;
import androidx.view.result.ActivityResult;
import androidx.view.result.ActivityResultCallback;
import androidx.view.result.ActivityResultLauncher;
import androidx.view.result.ActivityResultRegistry;
import androidx.view.result.ActivityResultRegistryOwner;
import androidx.view.result.IntentSenderRequest;
import androidx.view.result.contract.ActivityResultContract;
import androidx.view.result.contract.ActivityResultContracts;
import com.alibaba.ariver.resource.parser.tar.TarHeader;
import com.fullstory.instrumentation.InstrumentInjector;
import com.google.common.base.Ascii;
import j$.util.DesugarCollections;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: classes.dex */
public abstract class FragmentManager implements FragmentResultOwner {
    private static boolean DEBUG = false;
    private static final String EXTRA_CREATED_FILLIN_INTENT = "androidx.fragment.extra.ACTIVITY_OPTIONS_BUNDLE";
    static final String FRAGMENT_MANAGER_STATE_TAG = "state";
    static final String FRAGMENT_NAME_PREFIX = "fragment_";
    static final String FRAGMENT_STATE_TAG = "state";
    public static final int POP_BACK_STACK_INCLUSIVE = 1;
    static final String RESULT_NAME_PREFIX = "result_";
    static final String SAVED_STATE_TAG = "android:support:fragments";
    public static final String TAG = "FragmentManager";
    ArrayList<BackStackRecord> mBackStack;
    private ArrayList<OnBackStackChangedListener> mBackStackChangeListeners;
    private FragmentContainer mContainer;
    private ArrayList<Fragment> mCreatedMenus;
    private boolean mDestroyed;
    private boolean mExecutingActions;
    private boolean mHavePendingDeferredStart;
    private FragmentHostCallback<?> mHost;
    private boolean mNeedMenuInvalidate;
    private FragmentManagerViewModel mNonConfig;
    private OnBackPressedDispatcher mOnBackPressedDispatcher;
    private Fragment mParent;
    Fragment mPrimaryNav;
    private ActivityResultLauncher<String[]> mRequestPermissions;
    private ActivityResultLauncher<Intent> mStartActivityForResult;
    private ActivityResultLauncher<IntentSenderRequest> mStartIntentSenderForResult;
    private boolean mStateSaved;
    private boolean mStopped;
    private FragmentStrictMode.Policy mStrictModePolicy;
    private ArrayList<Fragment> mTmpAddedFragments;
    private ArrayList<Boolean> mTmpIsPop;
    private ArrayList<BackStackRecord> mTmpRecords;
    public static final byte[] MyBillsEntityDataFactory = {116, 15, TarHeader.LF_BLK, -20, 7, 1, -7, -4, 13, -9, -3, TarHeader.LF_CHR, -23, -16, 13, 39, -42, 13, 1, 11, -19, Ascii.ETB, TarHeader.LF_DIR, -60, 13, -11, 9, 59, -35, -36, 8, 1, 17, -6};
    public static final int BuiltInFictitiousFunctionClassFactory = 254;
    private final ArrayList<OpGenerator> mPendingActions = new ArrayList<>();
    private final FragmentStore mFragmentStore = new FragmentStore();
    private final FragmentLayoutInflaterFactory mLayoutInflaterFactory = new FragmentLayoutInflaterFactory(this);
    private final OnBackPressedCallback mOnBackPressedCallback = new OnBackPressedCallback() { // from class: androidx.fragment.app.FragmentManager.1
        {
            FragmentManager.this = this;
        }

        @Override // androidx.view.OnBackPressedCallback
        public void handleOnBackPressed() {
            FragmentManager.this.handleOnBackPressed();
        }
    };
    private final AtomicInteger mBackStackIndex = new AtomicInteger();
    private final Map<String, BackStackState> mBackStackStates = DesugarCollections.MyBillsEntityDataFactory(new HashMap());
    private final Map<String, Bundle> mResults = DesugarCollections.MyBillsEntityDataFactory(new HashMap());
    private final Map<String, LifecycleAwareResultListener> mResultListeners = DesugarCollections.MyBillsEntityDataFactory(new HashMap());
    private final FragmentLifecycleCallbacksDispatcher mLifecycleCallbacksDispatcher = new FragmentLifecycleCallbacksDispatcher(this);
    private final CopyOnWriteArrayList<FragmentOnAttachListener> mOnAttachListeners = new CopyOnWriteArrayList<>();
    private final Consumer<Configuration> mOnConfigurationChangedListener = new Consumer() { // from class: androidx.fragment.app.FragmentManager$$ExternalSyntheticLambda0
        @Override // androidx.core.util.Consumer
        public final void accept(Object obj) {
            FragmentManager.this.m38lambda$new$0$androidxfragmentappFragmentManager((Configuration) obj);
        }
    };
    private final Consumer<Integer> mOnTrimMemoryListener = new Consumer() { // from class: androidx.fragment.app.FragmentManager$$ExternalSyntheticLambda1
        @Override // androidx.core.util.Consumer
        public final void accept(Object obj) {
            FragmentManager.this.m39lambda$new$1$androidxfragmentappFragmentManager((Integer) obj);
        }
    };
    private final Consumer<MultiWindowModeChangedInfo> mOnMultiWindowModeChangedListener = new Consumer() { // from class: androidx.fragment.app.FragmentManager$$ExternalSyntheticLambda2
        @Override // androidx.core.util.Consumer
        public final void accept(Object obj) {
            FragmentManager.this.m40lambda$new$2$androidxfragmentappFragmentManager((MultiWindowModeChangedInfo) obj);
        }
    };
    private final Consumer<PictureInPictureModeChangedInfo> mOnPictureInPictureModeChangedListener = new Consumer() { // from class: androidx.fragment.app.FragmentManager$$ExternalSyntheticLambda3
        @Override // androidx.core.util.Consumer
        public final void accept(Object obj) {
            FragmentManager.this.m41lambda$new$3$androidxfragmentappFragmentManager((PictureInPictureModeChangedInfo) obj);
        }
    };
    private final MenuProvider mMenuProvider = new MenuProvider() { // from class: androidx.fragment.app.FragmentManager.2
        {
            FragmentManager.this = this;
        }

        @Override // androidx.core.view.MenuProvider
        public final void BuiltInFictitiousFunctionClassFactory(Menu menu) {
            FragmentManager.this.dispatchPrepareOptionsMenu(menu);
        }

        @Override // androidx.core.view.MenuProvider
        public final void getAuthRequestContext(Menu menu, MenuInflater menuInflater) {
            FragmentManager.this.dispatchCreateOptionsMenu(menu, menuInflater);
        }

        @Override // androidx.core.view.MenuProvider
        public final boolean KClassImpl$Data$declaredNonStaticMembers$2(MenuItem menuItem) {
            return FragmentManager.this.dispatchOptionsItemSelected(menuItem);
        }

        @Override // androidx.core.view.MenuProvider
        public final void PlaceComponentResult(Menu menu) {
            FragmentManager.this.dispatchOptionsMenuClosed(menu);
        }
    };
    int mCurState = -1;
    private FragmentFactory mFragmentFactory = null;
    private FragmentFactory mHostFragmentFactory = new FragmentFactory() { // from class: androidx.fragment.app.FragmentManager.3
        {
            FragmentManager.this = this;
        }

        @Override // androidx.fragment.app.FragmentFactory
        public final Fragment getAuthRequestContext(ClassLoader classLoader, String str) {
            FragmentManager.this.getHost();
            return FragmentHostCallback.getAuthRequestContext(FragmentManager.this.getHost().MyBillsEntityDataFactory, str);
        }
    };
    private SpecialEffectsControllerFactory mSpecialEffectsControllerFactory = null;
    private SpecialEffectsControllerFactory mDefaultSpecialEffectsControllerFactory = new SpecialEffectsControllerFactory() { // from class: androidx.fragment.app.FragmentManager.4
        {
            FragmentManager.this = this;
        }

        @Override // androidx.fragment.app.SpecialEffectsControllerFactory
        public final SpecialEffectsController MyBillsEntityDataFactory(ViewGroup viewGroup) {
            return new DefaultSpecialEffectsController(viewGroup);
        }
    };
    ArrayDeque<LaunchedFragmentInfo> mLaunchedFragments = new ArrayDeque<>();
    private Runnable mExecCommit = new Runnable() { // from class: androidx.fragment.app.FragmentManager.5
        {
            FragmentManager.this = this;
        }

        @Override // java.lang.Runnable
        public void run() {
            FragmentManager.this.execPendingActions(true);
        }
    };

    /* loaded from: classes.dex */
    public interface BackStackEntry {
        int PlaceComponentResult();
    }

    /* loaded from: classes.dex */
    public static abstract class FragmentLifecycleCallbacks {
        @Deprecated
        public void onFragmentActivityCreated(FragmentManager fragmentManager, Fragment fragment, Bundle bundle) {
        }

        public void onFragmentAttached(FragmentManager fragmentManager, Fragment fragment, Context context) {
        }

        public void onFragmentCreated(FragmentManager fragmentManager, Fragment fragment, Bundle bundle) {
        }

        public void onFragmentDestroyed(FragmentManager fragmentManager, Fragment fragment) {
        }

        public void onFragmentDetached(FragmentManager fragmentManager, Fragment fragment) {
        }

        public void onFragmentPaused(FragmentManager fragmentManager, Fragment fragment) {
        }

        public void onFragmentPreAttached(FragmentManager fragmentManager, Fragment fragment, Context context) {
        }

        public void onFragmentPreCreated(FragmentManager fragmentManager, Fragment fragment, Bundle bundle) {
        }

        public void onFragmentResumed(FragmentManager fragmentManager, Fragment fragment) {
        }

        public void onFragmentSaveInstanceState(FragmentManager fragmentManager, Fragment fragment, Bundle bundle) {
        }

        public void onFragmentStarted(FragmentManager fragmentManager, Fragment fragment) {
        }

        public void onFragmentStopped(FragmentManager fragmentManager, Fragment fragment) {
        }

        public void onFragmentViewCreated(FragmentManager fragmentManager, Fragment fragment, View view, Bundle bundle) {
        }

        public void onFragmentViewDestroyed(FragmentManager fragmentManager, Fragment fragment) {
        }
    }

    /* loaded from: classes.dex */
    public interface OnBackStackChangedListener {
        void KClassImpl$Data$declaredNonStaticMembers$2();
    }

    /* loaded from: classes.dex */
    public interface OpGenerator {
        boolean MyBillsEntityDataFactory(ArrayList<BackStackRecord> arrayList, ArrayList<Boolean> arrayList2);
    }

    /* JADX WARN: Removed duplicated region for block: B:32:0x001e  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0026  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:34:0x0026 -> B:35:0x002e). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void a(short r6, int r7, byte r8, java.lang.Object[] r9) {
        /*
            int r7 = r7 * 2
            int r7 = r7 + 16
            int r8 = 106 - r8
            int r6 = r6 + 4
            byte[] r0 = androidx.fragment.app.FragmentManager.MyBillsEntityDataFactory
            byte[] r1 = new byte[r7]
            int r7 = r7 + (-1)
            r2 = 0
            if (r0 != 0) goto L16
            r8 = r7
            r4 = r8
            r3 = 0
            r7 = r6
            goto L2e
        L16:
            r3 = 0
        L17:
            int r6 = r6 + 1
            byte r4 = (byte) r8
            r1[r3] = r4
            if (r3 != r7) goto L26
            java.lang.String r6 = new java.lang.String
            r6.<init>(r1, r2)
            r9[r2] = r6
            return
        L26:
            int r3 = r3 + 1
            r4 = r0[r6]
            r5 = r7
            r7 = r6
            r6 = r8
            r8 = r5
        L2e:
            int r4 = -r4
            int r6 = r6 + r4
            int r6 = r6 + 2
            r5 = r8
            r8 = r6
            r6 = r7
            r7 = r5
            goto L17
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.fragment.app.FragmentManager.a(short, int, byte, java.lang.Object[]):void");
    }

    static int reverseTransit(int i) {
        if (i != 4097) {
            if (i != 8194) {
                if (i != 8197) {
                    if (i != 4099) {
                        return i != 4100 ? 0 : 8197;
                    }
                    return 4099;
                }
                return 4100;
            }
            return 4097;
        }
        return 8194;
    }

    @Deprecated
    public static void enableDebugLogging(boolean z) {
        DEBUG = z;
    }

    public static boolean isLoggingEnabled(int i) {
        return DEBUG || Log.isLoggable(TAG, i);
    }

    /* loaded from: classes.dex */
    public static class LifecycleAwareResultListener implements FragmentResultListener {
        private final FragmentResultListener BuiltInFictitiousFunctionClassFactory;
        final LifecycleEventObserver KClassImpl$Data$declaredNonStaticMembers$2;
        final Lifecycle MyBillsEntityDataFactory;

        LifecycleAwareResultListener(Lifecycle lifecycle, FragmentResultListener fragmentResultListener, LifecycleEventObserver lifecycleEventObserver) {
            this.MyBillsEntityDataFactory = lifecycle;
            this.BuiltInFictitiousFunctionClassFactory = fragmentResultListener;
            this.KClassImpl$Data$declaredNonStaticMembers$2 = lifecycleEventObserver;
        }

        public final boolean KClassImpl$Data$declaredNonStaticMembers$2(Lifecycle.State state) {
            return this.MyBillsEntityDataFactory.PlaceComponentResult().isAtLeast(state);
        }

        @Override // androidx.fragment.app.FragmentResultListener
        public void onFragmentResult(String str, Bundle bundle) {
            this.BuiltInFictitiousFunctionClassFactory.onFragmentResult(str, bundle);
        }
    }

    /* renamed from: lambda$new$0$androidx-fragment-app-FragmentManager */
    public /* synthetic */ void m38lambda$new$0$androidxfragmentappFragmentManager(Configuration configuration) {
        if (isParentAdded()) {
            dispatchConfigurationChanged(configuration, false);
        }
    }

    /* renamed from: lambda$new$1$androidx-fragment-app-FragmentManager */
    public /* synthetic */ void m39lambda$new$1$androidxfragmentappFragmentManager(Integer num) {
        if (isParentAdded() && num.intValue() == 80) {
            dispatchLowMemory(false);
        }
    }

    /* renamed from: lambda$new$2$androidx-fragment-app-FragmentManager */
    public /* synthetic */ void m40lambda$new$2$androidxfragmentappFragmentManager(MultiWindowModeChangedInfo multiWindowModeChangedInfo) {
        if (isParentAdded()) {
            dispatchMultiWindowModeChanged(multiWindowModeChangedInfo.getAuthRequestContext(), false);
        }
    }

    /* renamed from: lambda$new$3$androidx-fragment-app-FragmentManager */
    public /* synthetic */ void m41lambda$new$3$androidxfragmentappFragmentManager(PictureInPictureModeChangedInfo pictureInPictureModeChangedInfo) {
        if (isParentAdded()) {
            dispatchPictureInPictureModeChanged(pictureInPictureModeChangedInfo.MyBillsEntityDataFactory(), false);
        }
    }

    private void throwException(RuntimeException runtimeException) {
        InstrumentInjector.log_e(TAG, runtimeException.getMessage());
        InstrumentInjector.log_e(TAG, "Activity state:");
        PrintWriter printWriter = new PrintWriter(new LogWriter(TAG));
        FragmentHostCallback<?> fragmentHostCallback = this.mHost;
        if (fragmentHostCallback != null) {
            try {
                fragmentHostCallback.BuiltInFictitiousFunctionClassFactory("  ", printWriter, new String[0]);
                throw runtimeException;
            } catch (Exception e) {
                InstrumentInjector.log_e(TAG, "Failed dumping state", e);
                throw runtimeException;
            }
        }
        try {
            dump("  ", null, printWriter, new String[0]);
            throw runtimeException;
        } catch (Exception e2) {
            InstrumentInjector.log_e(TAG, "Failed dumping state", e2);
            throw runtimeException;
        }
    }

    @Deprecated
    public FragmentTransaction openTransaction() {
        return beginTransaction();
    }

    public FragmentTransaction beginTransaction() {
        return new BackStackRecord(this);
    }

    public boolean executePendingTransactions() {
        boolean execPendingActions = execPendingActions(true);
        forcePostponedTransactions();
        return execPendingActions;
    }

    private void updateOnBackPressedCallbackEnabled() {
        synchronized (this.mPendingActions) {
            if (!this.mPendingActions.isEmpty()) {
                this.mOnBackPressedCallback.setEnabled(true);
            } else {
                this.mOnBackPressedCallback.setEnabled(getBackStackEntryCount() > 0 && isPrimaryNavigation(this.mParent));
            }
        }
    }

    public boolean isPrimaryNavigation(Fragment fragment) {
        if (fragment == null) {
            return true;
        }
        FragmentManager fragmentManager = fragment.mFragmentManager;
        return fragment.equals(fragmentManager.getPrimaryNavigationFragment()) && isPrimaryNavigation(fragmentManager.mParent);
    }

    public boolean isParentMenuVisible(Fragment fragment) {
        if (fragment == null) {
            return true;
        }
        return fragment.isMenuVisible();
    }

    public boolean isParentHidden(Fragment fragment) {
        if (fragment == null) {
            return false;
        }
        return fragment.isHidden();
    }

    void handleOnBackPressed() {
        execPendingActions(true);
        if (this.mOnBackPressedCallback.isEnabled()) {
            popBackStackImmediate();
        } else {
            this.mOnBackPressedDispatcher.KClassImpl$Data$declaredNonStaticMembers$2();
        }
    }

    public void restoreBackStack(String str) {
        enqueueAction(new RestoreBackStackState(str), false);
    }

    public void saveBackStack(String str) {
        enqueueAction(new SaveBackStackState(str), false);
    }

    public void clearBackStack(String str) {
        enqueueAction(new ClearBackStackState(str), false);
    }

    public void popBackStack() {
        enqueueAction(new PopBackStackState(null, -1, 0), false);
    }

    public boolean popBackStackImmediate() {
        return popBackStackImmediate(null, -1, 0);
    }

    public void popBackStack(String str, int i) {
        enqueueAction(new PopBackStackState(str, -1, i), false);
    }

    public boolean popBackStackImmediate(String str, int i) {
        return popBackStackImmediate(str, -1, i);
    }

    public void popBackStack(int i, int i2) {
        popBackStack(i, i2, false);
    }

    public void popBackStack(int i, int i2, boolean z) {
        if (i < 0) {
            StringBuilder sb = new StringBuilder();
            sb.append("Bad id: ");
            sb.append(i);
            throw new IllegalArgumentException(sb.toString());
        }
        enqueueAction(new PopBackStackState(null, i, i2), z);
    }

    public boolean popBackStackImmediate(int i, int i2) {
        if (i < 0) {
            StringBuilder sb = new StringBuilder();
            sb.append("Bad id: ");
            sb.append(i);
            throw new IllegalArgumentException(sb.toString());
        }
        return popBackStackImmediate(null, i, i2);
    }

    private boolean popBackStackImmediate(String str, int i, int i2) {
        execPendingActions(false);
        ensureExecReady(true);
        Fragment fragment = this.mPrimaryNav;
        if (fragment == null || i >= 0 || str != null || !fragment.getChildFragmentManager().popBackStackImmediate()) {
            boolean popBackStackState = popBackStackState(this.mTmpRecords, this.mTmpIsPop, str, i, i2);
            if (popBackStackState) {
                this.mExecutingActions = true;
                try {
                    removeRedundantOperationsAndExecute(this.mTmpRecords, this.mTmpIsPop);
                } finally {
                    cleanupExec();
                }
            }
            updateOnBackPressedCallbackEnabled();
            doPendingDeferredStart();
            this.mFragmentStore.KClassImpl$Data$declaredNonStaticMembers$2.values().removeAll(Collections.singleton(null));
            return popBackStackState;
        }
        return true;
    }

    public int getBackStackEntryCount() {
        ArrayList<BackStackRecord> arrayList = this.mBackStack;
        if (arrayList != null) {
            return arrayList.size();
        }
        return 0;
    }

    public BackStackEntry getBackStackEntryAt(int i) {
        return this.mBackStack.get(i);
    }

    public void addOnBackStackChangedListener(OnBackStackChangedListener onBackStackChangedListener) {
        if (this.mBackStackChangeListeners == null) {
            this.mBackStackChangeListeners = new ArrayList<>();
        }
        this.mBackStackChangeListeners.add(onBackStackChangedListener);
    }

    public void removeOnBackStackChangedListener(OnBackStackChangedListener onBackStackChangedListener) {
        ArrayList<OnBackStackChangedListener> arrayList = this.mBackStackChangeListeners;
        if (arrayList != null) {
            arrayList.remove(onBackStackChangedListener);
        }
    }

    public final void setFragmentResult(String str, Bundle bundle) {
        LifecycleAwareResultListener lifecycleAwareResultListener = this.mResultListeners.get(str);
        if (lifecycleAwareResultListener != null && lifecycleAwareResultListener.KClassImpl$Data$declaredNonStaticMembers$2(Lifecycle.State.STARTED)) {
            lifecycleAwareResultListener.onFragmentResult(str, bundle);
        } else {
            this.mResults.put(str, bundle);
        }
        if (isLoggingEnabled(2)) {
            StringBuilder sb = new StringBuilder();
            sb.append("Setting fragment result with key ");
            sb.append(str);
            sb.append(" and result ");
            sb.append(bundle);
            InstrumentInjector.log_v(TAG, sb.toString());
        }
    }

    public final void clearFragmentResult(String str) {
        this.mResults.remove(str);
        if (isLoggingEnabled(2)) {
            StringBuilder sb = new StringBuilder();
            sb.append("Clearing fragment result with key ");
            sb.append(str);
            InstrumentInjector.log_v(TAG, sb.toString());
        }
    }

    public final void setFragmentResultListener(final String str, LifecycleOwner lifecycleOwner, final FragmentResultListener fragmentResultListener) {
        final Lifecycle lifecycle = lifecycleOwner.getLifecycle();
        if (lifecycle.PlaceComponentResult() == Lifecycle.State.DESTROYED) {
            return;
        }
        LifecycleEventObserver lifecycleEventObserver = new LifecycleEventObserver() { // from class: androidx.fragment.app.FragmentManager.6
            {
                FragmentManager.this = this;
            }

            @Override // androidx.view.LifecycleEventObserver
            public void BuiltInFictitiousFunctionClassFactory(LifecycleOwner lifecycleOwner2, Lifecycle.Event event) {
                Bundle bundle;
                if (event == Lifecycle.Event.ON_START && (bundle = (Bundle) FragmentManager.this.mResults.get(str)) != null) {
                    fragmentResultListener.onFragmentResult(str, bundle);
                    FragmentManager.this.clearFragmentResult(str);
                }
                if (event == Lifecycle.Event.ON_DESTROY) {
                    lifecycle.KClassImpl$Data$declaredNonStaticMembers$2(this);
                    FragmentManager.this.mResultListeners.remove(str);
                }
            }
        };
        LifecycleAwareResultListener put = this.mResultListeners.put(str, new LifecycleAwareResultListener(lifecycle, fragmentResultListener, lifecycleEventObserver));
        if (put != null) {
            put.MyBillsEntityDataFactory.KClassImpl$Data$declaredNonStaticMembers$2(put.KClassImpl$Data$declaredNonStaticMembers$2);
        }
        if (isLoggingEnabled(2)) {
            StringBuilder sb = new StringBuilder();
            sb.append("Setting FragmentResultListener with key ");
            sb.append(str);
            sb.append(" lifecycleOwner ");
            sb.append(lifecycle);
            sb.append(" and listener ");
            sb.append(fragmentResultListener);
            InstrumentInjector.log_v(TAG, sb.toString());
        }
        lifecycle.BuiltInFictitiousFunctionClassFactory(lifecycleEventObserver);
    }

    public final void clearFragmentResultListener(String str) {
        LifecycleAwareResultListener remove = this.mResultListeners.remove(str);
        if (remove != null) {
            remove.MyBillsEntityDataFactory.KClassImpl$Data$declaredNonStaticMembers$2(remove.KClassImpl$Data$declaredNonStaticMembers$2);
        }
        if (isLoggingEnabled(2)) {
            StringBuilder sb = new StringBuilder();
            sb.append("Clearing FragmentResultListener for key ");
            sb.append(str);
            InstrumentInjector.log_v(TAG, sb.toString());
        }
    }

    public void putFragment(Bundle bundle, String str, Fragment fragment) {
        if (fragment.mFragmentManager != this) {
            StringBuilder sb = new StringBuilder();
            sb.append("Fragment ");
            sb.append(fragment);
            sb.append(" is not currently in the FragmentManager");
            throwException(new IllegalStateException(sb.toString()));
        }
        bundle.putString(str, fragment.mWho);
    }

    public Fragment getFragment(Bundle bundle, String str) {
        String string = bundle.getString(str);
        if (string == null) {
            return null;
        }
        Fragment findActiveFragment = findActiveFragment(string);
        if (findActiveFragment == null) {
            StringBuilder sb = new StringBuilder();
            sb.append("Fragment no longer exists for key ");
            sb.append(str);
            sb.append(": unique id ");
            sb.append(string);
            throwException(new IllegalStateException(sb.toString()));
        }
        return findActiveFragment;
    }

    public static <F extends Fragment> F findFragment(View view) {
        F f = (F) findViewFragment(view);
        if (f != null) {
            return f;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("View ");
        sb.append(view);
        sb.append(" does not have a Fragment set");
        throw new IllegalStateException(sb.toString());
    }

    private static Fragment findViewFragment(View view) {
        while (view != null) {
            Fragment viewFragment = getViewFragment(view);
            if (viewFragment != null) {
                return viewFragment;
            }
            ViewParent parent = view.getParent();
            view = parent instanceof View ? (View) parent : null;
        }
        return null;
    }

    public static Fragment getViewFragment(View view) {
        Object tag = view.getTag(R.id.KClassImpl$Data$declaredNonStaticMembers$2);
        if (tag instanceof Fragment) {
            return (Fragment) tag;
        }
        return null;
    }

    public void onContainerAvailable(FragmentContainerView fragmentContainerView) {
        for (FragmentStateManager fragmentStateManager : this.mFragmentStore.KClassImpl$Data$declaredNonStaticMembers$2()) {
            Fragment fragment = fragmentStateManager.PlaceComponentResult;
            if (fragment.mContainerId == fragmentContainerView.getId() && fragment.mView != null && fragment.mView.getParent() == null) {
                fragment.mContainer = fragmentContainerView;
                fragmentStateManager.PlaceComponentResult.mContainer.addView(fragmentStateManager.PlaceComponentResult.mView, fragmentStateManager.KClassImpl$Data$declaredNonStaticMembers$2.PlaceComponentResult(fragmentStateManager.PlaceComponentResult));
            }
        }
    }

    public static FragmentManager findFragmentManager(View view) {
        FragmentActivity fragmentActivity;
        Fragment findViewFragment = findViewFragment(view);
        if (findViewFragment != null) {
            if (!findViewFragment.isAdded()) {
                StringBuilder sb = new StringBuilder();
                sb.append("The Fragment ");
                sb.append(findViewFragment);
                sb.append(" that owns View ");
                sb.append(view);
                sb.append(" has already been destroyed. Nested fragments should always use the child FragmentManager.");
                throw new IllegalStateException(sb.toString());
            }
            return findViewFragment.getChildFragmentManager();
        }
        Context context = view.getContext();
        while (true) {
            fragmentActivity = null;
            if (!(context instanceof ContextWrapper)) {
                break;
            } else if (context instanceof FragmentActivity) {
                fragmentActivity = (FragmentActivity) context;
                break;
            } else {
                context = ((ContextWrapper) context).getBaseContext();
            }
        }
        if (fragmentActivity != null) {
            return fragmentActivity.getSupportFragmentManager();
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append("View ");
        sb2.append(view);
        sb2.append(" is not within a subclass of FragmentActivity.");
        throw new IllegalStateException(sb2.toString());
    }

    public List<Fragment> getFragments() {
        return this.mFragmentStore.getAuthRequestContext();
    }

    public ViewModelStore getViewModelStore(Fragment fragment) {
        FragmentManagerViewModel fragmentManagerViewModel = this.mNonConfig;
        ViewModelStore viewModelStore = fragmentManagerViewModel.getAuthRequestContext.get(fragment.mWho);
        if (viewModelStore == null) {
            ViewModelStore viewModelStore2 = new ViewModelStore();
            fragmentManagerViewModel.getAuthRequestContext.put(fragment.mWho, viewModelStore2);
            return viewModelStore2;
        }
        return viewModelStore;
    }

    private FragmentManagerViewModel getChildNonConfig(Fragment fragment) {
        FragmentManagerViewModel fragmentManagerViewModel = this.mNonConfig;
        FragmentManagerViewModel fragmentManagerViewModel2 = fragmentManagerViewModel.PlaceComponentResult.get(fragment.mWho);
        if (fragmentManagerViewModel2 == null) {
            FragmentManagerViewModel fragmentManagerViewModel3 = new FragmentManagerViewModel(fragmentManagerViewModel.MyBillsEntityDataFactory);
            fragmentManagerViewModel.PlaceComponentResult.put(fragment.mWho, fragmentManagerViewModel3);
            return fragmentManagerViewModel3;
        }
        return fragmentManagerViewModel2;
    }

    public void addRetainedFragment(Fragment fragment) {
        this.mNonConfig.MyBillsEntityDataFactory(fragment);
    }

    public void removeRetainedFragment(Fragment fragment) {
        this.mNonConfig.BuiltInFictitiousFunctionClassFactory(fragment);
    }

    List<Fragment> getActiveFragments() {
        return this.mFragmentStore.PlaceComponentResult();
    }

    int getActiveFragmentCount() {
        return this.mFragmentStore.KClassImpl$Data$declaredNonStaticMembers$2.size();
    }

    public Fragment.SavedState saveFragmentInstanceState(Fragment fragment) {
        Bundle BuiltInFictitiousFunctionClassFactory2;
        FragmentStateManager fragmentStateManager = this.mFragmentStore.KClassImpl$Data$declaredNonStaticMembers$2.get(fragment.mWho);
        if (fragmentStateManager == null || !fragmentStateManager.PlaceComponentResult.equals(fragment)) {
            StringBuilder sb = new StringBuilder();
            sb.append("Fragment ");
            sb.append(fragment);
            sb.append(" is not currently in the FragmentManager");
            throwException(new IllegalStateException(sb.toString()));
        }
        if (fragmentStateManager.PlaceComponentResult.mState < 0 || (BuiltInFictitiousFunctionClassFactory2 = fragmentStateManager.BuiltInFictitiousFunctionClassFactory()) == null) {
            return null;
        }
        return new Fragment.SavedState(BuiltInFictitiousFunctionClassFactory2);
    }

    private void clearBackStackStateViewModels() {
        FragmentHostCallback<?> fragmentHostCallback = this.mHost;
        boolean z = true;
        if (fragmentHostCallback instanceof ViewModelStoreOwner) {
            z = this.mFragmentStore.BuiltInFictitiousFunctionClassFactory.PlaceComponentResult();
        } else if (fragmentHostCallback.MyBillsEntityDataFactory instanceof Activity) {
            z = true ^ ((Activity) this.mHost.MyBillsEntityDataFactory).isChangingConfigurations();
        }
        if (z) {
            Iterator<BackStackState> it = this.mBackStackStates.values().iterator();
            while (it.hasNext()) {
                for (String str : it.next().BuiltInFictitiousFunctionClassFactory) {
                    FragmentManagerViewModel fragmentManagerViewModel = this.mFragmentStore.BuiltInFictitiousFunctionClassFactory;
                    if (isLoggingEnabled(3)) {
                        StringBuilder sb = new StringBuilder();
                        sb.append("Clearing non-config state for saved state of Fragment ");
                        sb.append(str);
                        InstrumentInjector.log_d(TAG, sb.toString());
                    }
                    fragmentManagerViewModel.MyBillsEntityDataFactory(str);
                }
            }
        }
    }

    public boolean isDestroyed() {
        return this.mDestroyed;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(128);
        sb.append("FragmentManager{");
        try {
            Object[] objArr = {this};
            byte b = (byte) (BuiltInFictitiousFunctionClassFactory & 15);
            byte b2 = (byte) (MyBillsEntityDataFactory[5] - 1);
            Object[] objArr2 = new Object[1];
            a(b, b2, b2, objArr2);
            Class<?> cls = Class.forName((String) objArr2[0]);
            byte b3 = (byte) (-MyBillsEntityDataFactory[5]);
            Object[] objArr3 = new Object[1];
            a(b3, (byte) (b3 + 1), MyBillsEntityDataFactory[5], objArr3);
            sb.append(Integer.toHexString(((Integer) cls.getMethod((String) objArr3[0], Object.class).invoke(null, objArr)).intValue()));
            sb.append(" in ");
            Fragment fragment = this.mParent;
            if (fragment != null) {
                sb.append(fragment.getClass().getSimpleName());
                sb.append("{");
                try {
                    Object[] objArr4 = {this.mParent};
                    byte b4 = (byte) (BuiltInFictitiousFunctionClassFactory & 15);
                    byte b5 = (byte) (MyBillsEntityDataFactory[5] - 1);
                    Object[] objArr5 = new Object[1];
                    a(b4, b5, b5, objArr5);
                    Class<?> cls2 = Class.forName((String) objArr5[0]);
                    byte b6 = (byte) (-MyBillsEntityDataFactory[5]);
                    Object[] objArr6 = new Object[1];
                    a(b6, (byte) (b6 + 1), MyBillsEntityDataFactory[5], objArr6);
                    sb.append(Integer.toHexString(((Integer) cls2.getMethod((String) objArr6[0], Object.class).invoke(null, objArr4)).intValue()));
                    sb.append("}");
                } catch (Throwable th) {
                    Throwable cause = th.getCause();
                    if (cause != null) {
                        throw cause;
                    }
                    throw th;
                }
            } else {
                FragmentHostCallback<?> fragmentHostCallback = this.mHost;
                if (fragmentHostCallback != null) {
                    sb.append(fragmentHostCallback.getClass().getSimpleName());
                    sb.append("{");
                    try {
                        Object[] objArr7 = {this.mHost};
                        byte b7 = (byte) (BuiltInFictitiousFunctionClassFactory & 15);
                        byte b8 = (byte) (MyBillsEntityDataFactory[5] - 1);
                        Object[] objArr8 = new Object[1];
                        a(b7, b8, b8, objArr8);
                        Class<?> cls3 = Class.forName((String) objArr8[0]);
                        byte b9 = (byte) (-MyBillsEntityDataFactory[5]);
                        Object[] objArr9 = new Object[1];
                        a(b9, (byte) (b9 + 1), MyBillsEntityDataFactory[5], objArr9);
                        sb.append(Integer.toHexString(((Integer) cls3.getMethod((String) objArr9[0], Object.class).invoke(null, objArr7)).intValue()));
                        sb.append("}");
                    } catch (Throwable th2) {
                        Throwable cause2 = th2.getCause();
                        if (cause2 != null) {
                            throw cause2;
                        }
                        throw th2;
                    }
                } else {
                    sb.append("null");
                }
            }
            sb.append("}}");
            return sb.toString();
        } catch (Throwable th3) {
            Throwable cause3 = th3.getCause();
            if (cause3 != null) {
                throw cause3;
            }
            throw th3;
        }
    }

    public void dump(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        int size;
        int size2;
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        sb.append("    ");
        String obj = sb.toString();
        FragmentStore fragmentStore = this.mFragmentStore;
        StringBuilder sb2 = new StringBuilder();
        sb2.append(str);
        sb2.append("    ");
        String obj2 = sb2.toString();
        if (!fragmentStore.KClassImpl$Data$declaredNonStaticMembers$2.isEmpty()) {
            printWriter.print(str);
            printWriter.println("Active Fragments:");
            for (FragmentStateManager fragmentStateManager : fragmentStore.KClassImpl$Data$declaredNonStaticMembers$2.values()) {
                printWriter.print(str);
                if (fragmentStateManager == null) {
                    printWriter.println("null");
                } else {
                    Fragment fragment = fragmentStateManager.PlaceComponentResult;
                    printWriter.println(fragment);
                    fragment.dump(obj2, fileDescriptor, printWriter, strArr);
                }
            }
        }
        int size3 = fragmentStore.PlaceComponentResult.size();
        if (size3 > 0) {
            printWriter.print(str);
            printWriter.println("Added Fragments:");
            for (int i = 0; i < size3; i++) {
                Fragment fragment2 = fragmentStore.PlaceComponentResult.get(i);
                printWriter.print(str);
                printWriter.print("  #");
                printWriter.print(i);
                printWriter.print(": ");
                printWriter.println(fragment2.toString());
            }
        }
        ArrayList<Fragment> arrayList = this.mCreatedMenus;
        if (arrayList != null && (size2 = arrayList.size()) > 0) {
            printWriter.print(str);
            printWriter.println("Fragments Created Menus:");
            for (int i2 = 0; i2 < size2; i2++) {
                Fragment fragment3 = this.mCreatedMenus.get(i2);
                printWriter.print(str);
                printWriter.print("  #");
                printWriter.print(i2);
                printWriter.print(": ");
                printWriter.println(fragment3.toString());
            }
        }
        ArrayList<BackStackRecord> arrayList2 = this.mBackStack;
        if (arrayList2 != null && (size = arrayList2.size()) > 0) {
            printWriter.print(str);
            printWriter.println("Back Stack:");
            for (int i3 = 0; i3 < size; i3++) {
                BackStackRecord backStackRecord = this.mBackStack.get(i3);
                printWriter.print(str);
                printWriter.print("  #");
                printWriter.print(i3);
                printWriter.print(": ");
                printWriter.println(backStackRecord.toString());
                backStackRecord.KClassImpl$Data$declaredNonStaticMembers$2(obj, printWriter, true);
            }
        }
        printWriter.print(str);
        StringBuilder sb3 = new StringBuilder();
        sb3.append("Back Stack Index: ");
        sb3.append(this.mBackStackIndex.get());
        printWriter.println(sb3.toString());
        synchronized (this.mPendingActions) {
            int size4 = this.mPendingActions.size();
            if (size4 > 0) {
                printWriter.print(str);
                printWriter.println("Pending Actions:");
                for (int i4 = 0; i4 < size4; i4++) {
                    Object obj3 = (OpGenerator) this.mPendingActions.get(i4);
                    printWriter.print(str);
                    printWriter.print("  #");
                    printWriter.print(i4);
                    printWriter.print(": ");
                    printWriter.println(obj3);
                }
            }
        }
        printWriter.print(str);
        printWriter.println("FragmentManager misc state:");
        printWriter.print(str);
        printWriter.print("  mHost=");
        printWriter.println(this.mHost);
        printWriter.print(str);
        printWriter.print("  mContainer=");
        printWriter.println(this.mContainer);
        if (this.mParent != null) {
            printWriter.print(str);
            printWriter.print("  mParent=");
            printWriter.println(this.mParent);
        }
        printWriter.print(str);
        printWriter.print("  mCurState=");
        printWriter.print(this.mCurState);
        printWriter.print(" mStateSaved=");
        printWriter.print(this.mStateSaved);
        printWriter.print(" mStopped=");
        printWriter.print(this.mStopped);
        printWriter.print(" mDestroyed=");
        printWriter.println(this.mDestroyed);
        if (this.mNeedMenuInvalidate) {
            printWriter.print(str);
            printWriter.print("  mNeedMenuInvalidate=");
            printWriter.println(this.mNeedMenuInvalidate);
        }
    }

    public boolean isStateAtLeast(int i) {
        return this.mCurState >= i;
    }

    void setExitAnimationOrder(Fragment fragment, boolean z) {
        ViewGroup fragmentContainer = getFragmentContainer(fragment);
        if (fragmentContainer == null || !(fragmentContainer instanceof FragmentContainerView)) {
            return;
        }
        ((FragmentContainerView) fragmentContainer).setDrawDisappearingViewsLast(!z);
    }

    void moveToState(int i, boolean z) {
        FragmentHostCallback<?> fragmentHostCallback;
        if (this.mHost == null && i != -1) {
            throw new IllegalStateException("No activity");
        }
        if (z || i != this.mCurState) {
            this.mCurState = i;
            FragmentStore fragmentStore = this.mFragmentStore;
            Iterator<Fragment> it = fragmentStore.PlaceComponentResult.iterator();
            while (it.hasNext()) {
                FragmentStateManager fragmentStateManager = fragmentStore.KClassImpl$Data$declaredNonStaticMembers$2.get(it.next().mWho);
                if (fragmentStateManager != null) {
                    fragmentStateManager.PlaceComponentResult();
                }
            }
            Iterator<FragmentStateManager> it2 = fragmentStore.KClassImpl$Data$declaredNonStaticMembers$2.values().iterator();
            while (true) {
                boolean z2 = false;
                if (!it2.hasNext()) {
                    break;
                }
                FragmentStateManager next = it2.next();
                if (next != null) {
                    next.PlaceComponentResult();
                    Fragment fragment = next.PlaceComponentResult;
                    if (fragment.mRemoving && !fragment.isInBackStack()) {
                        z2 = true;
                    }
                    if (z2) {
                        if (fragment.mBeingSaved && !fragmentStore.MyBillsEntityDataFactory.containsKey(fragment.mWho)) {
                            next.MyBillsEntityDataFactory();
                        }
                        fragmentStore.MyBillsEntityDataFactory(next);
                    }
                }
            }
            startPendingDeferredFragments();
            if (this.mNeedMenuInvalidate && (fragmentHostCallback = this.mHost) != null && this.mCurState == 7) {
                fragmentHostCallback.KClassImpl$Data$declaredNonStaticMembers$2();
                this.mNeedMenuInvalidate = false;
            }
        }
    }

    private void startPendingDeferredFragments() {
        Iterator<FragmentStateManager> it = this.mFragmentStore.KClassImpl$Data$declaredNonStaticMembers$2().iterator();
        while (it.hasNext()) {
            performPendingDeferredStart(it.next());
        }
    }

    public FragmentStateManager createOrGetFragmentStateManager(Fragment fragment) {
        FragmentStore fragmentStore = this.mFragmentStore;
        FragmentStateManager fragmentStateManager = fragmentStore.KClassImpl$Data$declaredNonStaticMembers$2.get(fragment.mWho);
        if (fragmentStateManager != null) {
            return fragmentStateManager;
        }
        FragmentStateManager fragmentStateManager2 = new FragmentStateManager(this.mLifecycleCallbacksDispatcher, this.mFragmentStore, fragment);
        fragmentStateManager2.BuiltInFictitiousFunctionClassFactory(this.mHost.MyBillsEntityDataFactory.getClassLoader());
        fragmentStateManager2.MyBillsEntityDataFactory = this.mCurState;
        return fragmentStateManager2;
    }

    public FragmentStateManager addFragment(Fragment fragment) {
        if (fragment.mPreviousWho != null) {
            FragmentStrictMode.BuiltInFictitiousFunctionClassFactory(fragment, fragment.mPreviousWho);
        }
        if (isLoggingEnabled(2)) {
            StringBuilder sb = new StringBuilder();
            sb.append("add: ");
            sb.append(fragment);
            InstrumentInjector.log_v(TAG, sb.toString());
        }
        FragmentStateManager createOrGetFragmentStateManager = createOrGetFragmentStateManager(fragment);
        fragment.mFragmentManager = this;
        this.mFragmentStore.BuiltInFictitiousFunctionClassFactory(createOrGetFragmentStateManager);
        if (!fragment.mDetached) {
            this.mFragmentStore.KClassImpl$Data$declaredNonStaticMembers$2(fragment);
            fragment.mRemoving = false;
            if (fragment.mView == null) {
                fragment.mHiddenChanged = false;
            }
            if (isMenuAvailable(fragment)) {
                this.mNeedMenuInvalidate = true;
            }
        }
        return createOrGetFragmentStateManager;
    }

    void removeFragment(Fragment fragment) {
        if (isLoggingEnabled(2)) {
            StringBuilder sb = new StringBuilder();
            sb.append("remove: ");
            sb.append(fragment);
            sb.append(" nesting=");
            sb.append(fragment.mBackStackNesting);
            InstrumentInjector.log_v(TAG, sb.toString());
        }
        boolean isInBackStack = fragment.isInBackStack();
        if (!fragment.mDetached || (!isInBackStack) == true) {
            FragmentStore fragmentStore = this.mFragmentStore;
            synchronized (fragmentStore.PlaceComponentResult) {
                fragmentStore.PlaceComponentResult.remove(fragment);
            }
            fragment.mAdded = false;
            if (isMenuAvailable(fragment)) {
                this.mNeedMenuInvalidate = true;
            }
            fragment.mRemoving = true;
            setVisibleRemovingFragment(fragment);
        }
    }

    void hideFragment(Fragment fragment) {
        if (isLoggingEnabled(2)) {
            StringBuilder sb = new StringBuilder();
            sb.append("hide: ");
            sb.append(fragment);
            InstrumentInjector.log_v(TAG, sb.toString());
        }
        if (fragment.mHidden) {
            return;
        }
        fragment.mHidden = true;
        fragment.mHiddenChanged = true ^ fragment.mHiddenChanged;
        setVisibleRemovingFragment(fragment);
    }

    void showFragment(Fragment fragment) {
        if (isLoggingEnabled(2)) {
            StringBuilder sb = new StringBuilder();
            sb.append("show: ");
            sb.append(fragment);
            InstrumentInjector.log_v(TAG, sb.toString());
        }
        if (fragment.mHidden) {
            fragment.mHidden = false;
            fragment.mHiddenChanged = !fragment.mHiddenChanged;
        }
    }

    void detachFragment(Fragment fragment) {
        if (isLoggingEnabled(2)) {
            StringBuilder sb = new StringBuilder();
            sb.append("detach: ");
            sb.append(fragment);
            InstrumentInjector.log_v(TAG, sb.toString());
        }
        if (fragment.mDetached) {
            return;
        }
        fragment.mDetached = true;
        if (fragment.mAdded) {
            if (isLoggingEnabled(2)) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("remove from detach: ");
                sb2.append(fragment);
                InstrumentInjector.log_v(TAG, sb2.toString());
            }
            FragmentStore fragmentStore = this.mFragmentStore;
            synchronized (fragmentStore.PlaceComponentResult) {
                fragmentStore.PlaceComponentResult.remove(fragment);
            }
            fragment.mAdded = false;
            if (isMenuAvailable(fragment)) {
                this.mNeedMenuInvalidate = true;
            }
            setVisibleRemovingFragment(fragment);
        }
    }

    void attachFragment(Fragment fragment) {
        if (isLoggingEnabled(2)) {
            StringBuilder sb = new StringBuilder();
            sb.append("attach: ");
            sb.append(fragment);
            InstrumentInjector.log_v(TAG, sb.toString());
        }
        if (fragment.mDetached) {
            fragment.mDetached = false;
            if (fragment.mAdded) {
                return;
            }
            this.mFragmentStore.KClassImpl$Data$declaredNonStaticMembers$2(fragment);
            if (isLoggingEnabled(2)) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("add from attach: ");
                sb2.append(fragment);
                InstrumentInjector.log_v(TAG, sb2.toString());
            }
            if (isMenuAvailable(fragment)) {
                this.mNeedMenuInvalidate = true;
            }
        }
    }

    public Fragment findFragmentById(int i) {
        FragmentStore fragmentStore = this.mFragmentStore;
        for (int size = fragmentStore.PlaceComponentResult.size() - 1; size >= 0; size--) {
            Fragment fragment = fragmentStore.PlaceComponentResult.get(size);
            if (fragment != null && fragment.mFragmentId == i) {
                return fragment;
            }
        }
        for (FragmentStateManager fragmentStateManager : fragmentStore.KClassImpl$Data$declaredNonStaticMembers$2.values()) {
            if (fragmentStateManager != null) {
                Fragment fragment2 = fragmentStateManager.PlaceComponentResult;
                if (fragment2.mFragmentId == i) {
                    return fragment2;
                }
            }
        }
        return null;
    }

    public Fragment findFragmentByTag(String str) {
        FragmentStore fragmentStore = this.mFragmentStore;
        if (str != null) {
            for (int size = fragmentStore.PlaceComponentResult.size() - 1; size >= 0; size--) {
                Fragment fragment = fragmentStore.PlaceComponentResult.get(size);
                if (fragment != null && str.equals(fragment.mTag)) {
                    return fragment;
                }
            }
        }
        if (str != null) {
            for (FragmentStateManager fragmentStateManager : fragmentStore.KClassImpl$Data$declaredNonStaticMembers$2.values()) {
                if (fragmentStateManager != null) {
                    Fragment fragment2 = fragmentStateManager.PlaceComponentResult;
                    if (str.equals(fragment2.mTag)) {
                        return fragment2;
                    }
                }
            }
            return null;
        }
        return null;
    }

    public Fragment findFragmentByWho(String str) {
        return this.mFragmentStore.BuiltInFictitiousFunctionClassFactory(str);
    }

    public Fragment findActiveFragment(String str) {
        FragmentStateManager fragmentStateManager = this.mFragmentStore.KClassImpl$Data$declaredNonStaticMembers$2.get(str);
        if (fragmentStateManager != null) {
            return fragmentStateManager.PlaceComponentResult;
        }
        return null;
    }

    private void checkStateLoss() {
        if (isStateSaved()) {
            throw new IllegalStateException("Can not perform this action after onSaveInstanceState");
        }
    }

    public boolean isStateSaved() {
        return this.mStateSaved || this.mStopped;
    }

    public void enqueueAction(OpGenerator opGenerator, boolean z) {
        if (!z) {
            if (this.mHost == null) {
                if (this.mDestroyed) {
                    throw new IllegalStateException("FragmentManager has been destroyed");
                }
                throw new IllegalStateException("FragmentManager has not been attached to a host.");
            }
            checkStateLoss();
        }
        synchronized (this.mPendingActions) {
            if (this.mHost == null) {
                if (!z) {
                    throw new IllegalStateException("Activity has been destroyed");
                }
                return;
            }
            this.mPendingActions.add(opGenerator);
            scheduleCommit();
        }
    }

    void scheduleCommit() {
        synchronized (this.mPendingActions) {
            if (this.mPendingActions.size() == 1) {
                this.mHost.getAuthRequestContext.removeCallbacks(this.mExecCommit);
                this.mHost.getAuthRequestContext.post(this.mExecCommit);
                updateOnBackPressedCallbackEnabled();
            }
        }
    }

    public int allocBackStackIndex() {
        return this.mBackStackIndex.getAndIncrement();
    }

    private void ensureExecReady(boolean z) {
        if (this.mExecutingActions) {
            throw new IllegalStateException("FragmentManager is already executing transactions");
        }
        if (this.mHost == null) {
            if (this.mDestroyed) {
                throw new IllegalStateException("FragmentManager has been destroyed");
            }
            throw new IllegalStateException("FragmentManager has not been attached to a host.");
        } else if (Looper.myLooper() != this.mHost.getAuthRequestContext.getLooper()) {
            throw new IllegalStateException("Must be called from main thread of fragment host");
        } else {
            if (!z) {
                checkStateLoss();
            }
            if (this.mTmpRecords == null) {
                this.mTmpRecords = new ArrayList<>();
                this.mTmpIsPop = new ArrayList<>();
            }
        }
    }

    public void execSingleAction(OpGenerator opGenerator, boolean z) {
        if (z && (this.mHost == null || this.mDestroyed)) {
            return;
        }
        ensureExecReady(z);
        if (opGenerator.MyBillsEntityDataFactory(this.mTmpRecords, this.mTmpIsPop)) {
            this.mExecutingActions = true;
            try {
                removeRedundantOperationsAndExecute(this.mTmpRecords, this.mTmpIsPop);
            } finally {
                cleanupExec();
            }
        }
        updateOnBackPressedCallbackEnabled();
        doPendingDeferredStart();
        this.mFragmentStore.KClassImpl$Data$declaredNonStaticMembers$2.values().removeAll(Collections.singleton(null));
    }

    private void cleanupExec() {
        this.mExecutingActions = false;
        this.mTmpIsPop.clear();
        this.mTmpRecords.clear();
    }

    public boolean execPendingActions(boolean z) {
        ensureExecReady(z);
        boolean z2 = false;
        while (generateOpsForPendingActions(this.mTmpRecords, this.mTmpIsPop)) {
            this.mExecutingActions = true;
            try {
                removeRedundantOperationsAndExecute(this.mTmpRecords, this.mTmpIsPop);
                cleanupExec();
                z2 = true;
            } catch (Throwable th) {
                cleanupExec();
                throw th;
            }
        }
        updateOnBackPressedCallbackEnabled();
        doPendingDeferredStart();
        this.mFragmentStore.KClassImpl$Data$declaredNonStaticMembers$2.values().removeAll(Collections.singleton(null));
        return z2;
    }

    private void removeRedundantOperationsAndExecute(ArrayList<BackStackRecord> arrayList, ArrayList<Boolean> arrayList2) {
        if (arrayList.isEmpty()) {
            return;
        }
        if (arrayList.size() != arrayList2.size()) {
            throw new IllegalStateException("Internal error with the back stack records");
        }
        int size = arrayList.size();
        int i = 0;
        int i2 = 0;
        while (i < size) {
            if (!arrayList.get(i).isLayoutRequested) {
                if (i2 != i) {
                    executeOpsTogether(arrayList, arrayList2, i2, i);
                }
                i2 = i + 1;
                if (arrayList2.get(i).booleanValue()) {
                    while (i2 < size && arrayList2.get(i2).booleanValue() && !arrayList.get(i2).isLayoutRequested) {
                        i2++;
                    }
                }
                executeOpsTogether(arrayList, arrayList2, i, i2);
                i = i2 - 1;
            }
            i++;
        }
        if (i2 != size) {
            executeOpsTogether(arrayList, arrayList2, i2, size);
        }
    }

    private void executeOpsTogether(ArrayList<BackStackRecord> arrayList, ArrayList<Boolean> arrayList2, int i, int i2) {
        int i3;
        int i4;
        byte b;
        ArrayList<BackStackRecord> arrayList3 = arrayList;
        ArrayList<Boolean> arrayList4 = arrayList2;
        boolean z = arrayList3.get(i).isLayoutRequested;
        ArrayList<Fragment> arrayList5 = this.mTmpAddedFragments;
        if (arrayList5 == null) {
            this.mTmpAddedFragments = new ArrayList<>();
        } else {
            arrayList5.clear();
        }
        this.mTmpAddedFragments.addAll(this.mFragmentStore.getAuthRequestContext());
        Fragment primaryNavigationFragment = getPrimaryNavigationFragment();
        int i5 = i;
        boolean z2 = false;
        while (true) {
            int i6 = 1;
            if (i5 < i2) {
                BackStackRecord backStackRecord = arrayList3.get(i5);
                int i7 = 3;
                if (!arrayList4.get(i5).booleanValue()) {
                    ArrayList<Fragment> arrayList6 = this.mTmpAddedFragments;
                    int i8 = 0;
                    while (i8 < backStackRecord.NetworkUserEntityData$$ExternalSyntheticLambda7.size()) {
                        FragmentTransaction.Op op = backStackRecord.NetworkUserEntityData$$ExternalSyntheticLambda7.get(i8);
                        int i9 = op.PlaceComponentResult;
                        if (i9 != i6) {
                            if (i9 != 2) {
                                if (i9 == i7 || i9 == 6) {
                                    arrayList6.remove(op.BuiltInFictitiousFunctionClassFactory);
                                    if (op.BuiltInFictitiousFunctionClassFactory == primaryNavigationFragment) {
                                        backStackRecord.NetworkUserEntityData$$ExternalSyntheticLambda7.add(i8, new FragmentTransaction.Op(9, op.BuiltInFictitiousFunctionClassFactory));
                                        i8++;
                                        i3 = 1;
                                        primaryNavigationFragment = null;
                                    }
                                } else if (i9 != 7) {
                                    if (i9 == 8) {
                                        backStackRecord.NetworkUserEntityData$$ExternalSyntheticLambda7.add(i8, new FragmentTransaction.Op(9, primaryNavigationFragment, (byte) 0));
                                        op.NetworkUserEntityData$$ExternalSyntheticLambda0 = true;
                                        i8++;
                                        primaryNavigationFragment = op.BuiltInFictitiousFunctionClassFactory;
                                    }
                                }
                                i3 = 1;
                            } else {
                                Fragment fragment = op.BuiltInFictitiousFunctionClassFactory;
                                int i10 = fragment.mContainerId;
                                int size = arrayList6.size() - 1;
                                boolean z3 = false;
                                while (size >= 0) {
                                    Fragment fragment2 = arrayList6.get(size);
                                    if (fragment2.mContainerId != i10) {
                                        i4 = i10;
                                    } else if (fragment2 == fragment) {
                                        i4 = i10;
                                        z3 = true;
                                    } else {
                                        if (fragment2 == primaryNavigationFragment) {
                                            i4 = i10;
                                            b = 0;
                                            backStackRecord.NetworkUserEntityData$$ExternalSyntheticLambda7.add(i8, new FragmentTransaction.Op(9, fragment2, (byte) 0));
                                            i8++;
                                            primaryNavigationFragment = null;
                                        } else {
                                            i4 = i10;
                                            b = 0;
                                        }
                                        FragmentTransaction.Op op2 = new FragmentTransaction.Op(3, fragment2, b);
                                        op2.getAuthRequestContext = op.getAuthRequestContext;
                                        op2.scheduleImpl = op.scheduleImpl;
                                        op2.MyBillsEntityDataFactory = op.MyBillsEntityDataFactory;
                                        op2.moveToNextValue = op.moveToNextValue;
                                        backStackRecord.NetworkUserEntityData$$ExternalSyntheticLambda7.add(i8, op2);
                                        arrayList6.remove(fragment2);
                                        i8++;
                                    }
                                    size--;
                                    i10 = i4;
                                }
                                if (z3) {
                                    backStackRecord.NetworkUserEntityData$$ExternalSyntheticLambda7.remove(i8);
                                    i8--;
                                    i3 = 1;
                                } else {
                                    i3 = 1;
                                    op.PlaceComponentResult = 1;
                                    op.NetworkUserEntityData$$ExternalSyntheticLambda0 = true;
                                    arrayList6.add(fragment);
                                }
                            }
                            i8 += i3;
                            i6 = 1;
                            i7 = 3;
                        }
                        i3 = 1;
                        arrayList6.add(op.BuiltInFictitiousFunctionClassFactory);
                        i8 += i3;
                        i6 = 1;
                        i7 = 3;
                    }
                } else {
                    int i11 = 1;
                    ArrayList<Fragment> arrayList7 = this.mTmpAddedFragments;
                    int size2 = backStackRecord.NetworkUserEntityData$$ExternalSyntheticLambda7.size() - 1;
                    while (size2 >= 0) {
                        FragmentTransaction.Op op3 = backStackRecord.NetworkUserEntityData$$ExternalSyntheticLambda7.get(size2);
                        int i12 = op3.PlaceComponentResult;
                        if (i12 != i11) {
                            if (i12 != 3) {
                                switch (i12) {
                                    case 8:
                                        primaryNavigationFragment = null;
                                        break;
                                    case 9:
                                        primaryNavigationFragment = op3.BuiltInFictitiousFunctionClassFactory;
                                        break;
                                    case 10:
                                        op3.KClassImpl$Data$declaredNonStaticMembers$2 = op3.lookAheadTest;
                                        break;
                                }
                                size2--;
                                i11 = 1;
                            }
                            arrayList7.add(op3.BuiltInFictitiousFunctionClassFactory);
                            size2--;
                            i11 = 1;
                        }
                        arrayList7.remove(op3.BuiltInFictitiousFunctionClassFactory);
                        size2--;
                        i11 = 1;
                    }
                }
                z2 = z2 || backStackRecord.scheduleImpl;
                i5++;
                arrayList3 = arrayList;
                arrayList4 = arrayList2;
            } else {
                this.mTmpAddedFragments.clear();
                if (!z && this.mCurState > 0) {
                    for (int i13 = i; i13 < i2; i13++) {
                        Iterator<FragmentTransaction.Op> it = arrayList.get(i13).NetworkUserEntityData$$ExternalSyntheticLambda7.iterator();
                        while (it.hasNext()) {
                            Fragment fragment3 = it.next().BuiltInFictitiousFunctionClassFactory;
                            if (fragment3 != null && fragment3.mFragmentManager != null) {
                                this.mFragmentStore.BuiltInFictitiousFunctionClassFactory(createOrGetFragmentStateManager(fragment3));
                            }
                        }
                    }
                }
                executeOps(arrayList, arrayList2, i, i2);
                boolean booleanValue = arrayList2.get(i2 - 1).booleanValue();
                for (int i14 = i; i14 < i2; i14++) {
                    BackStackRecord backStackRecord2 = arrayList.get(i14);
                    if (booleanValue) {
                        for (int size3 = backStackRecord2.NetworkUserEntityData$$ExternalSyntheticLambda7.size() - 1; size3 >= 0; size3--) {
                            Fragment fragment4 = backStackRecord2.NetworkUserEntityData$$ExternalSyntheticLambda7.get(size3).BuiltInFictitiousFunctionClassFactory;
                            if (fragment4 != null) {
                                createOrGetFragmentStateManager(fragment4).PlaceComponentResult();
                            }
                        }
                    } else {
                        Iterator<FragmentTransaction.Op> it2 = backStackRecord2.NetworkUserEntityData$$ExternalSyntheticLambda7.iterator();
                        while (it2.hasNext()) {
                            Fragment fragment5 = it2.next().BuiltInFictitiousFunctionClassFactory;
                            if (fragment5 != null) {
                                createOrGetFragmentStateManager(fragment5).PlaceComponentResult();
                            }
                        }
                    }
                }
                moveToState(this.mCurState, true);
                int i15 = i;
                for (SpecialEffectsController specialEffectsController : collectChangedControllers(arrayList, i15, i2)) {
                    specialEffectsController.getAuthRequestContext = booleanValue;
                    specialEffectsController.BuiltInFictitiousFunctionClassFactory();
                    specialEffectsController.MyBillsEntityDataFactory();
                }
                while (i15 < i2) {
                    BackStackRecord backStackRecord3 = arrayList.get(i15);
                    if (arrayList2.get(i15).booleanValue() && backStackRecord3.BuiltInFictitiousFunctionClassFactory >= 0) {
                        backStackRecord3.BuiltInFictitiousFunctionClassFactory = -1;
                    }
                    if (backStackRecord3.NetworkUserEntityData$$ExternalSyntheticLambda1 != null) {
                        for (int i16 = 0; i16 < backStackRecord3.NetworkUserEntityData$$ExternalSyntheticLambda1.size(); i16++) {
                            backStackRecord3.NetworkUserEntityData$$ExternalSyntheticLambda1.get(i16).run();
                        }
                        backStackRecord3.NetworkUserEntityData$$ExternalSyntheticLambda1 = null;
                    }
                    i15++;
                }
                if (z2) {
                    reportBackStackChanged();
                    return;
                }
                return;
            }
        }
    }

    private Set<SpecialEffectsController> collectChangedControllers(ArrayList<BackStackRecord> arrayList, int i, int i2) {
        ViewGroup viewGroup;
        HashSet hashSet = new HashSet();
        while (i < i2) {
            Iterator<FragmentTransaction.Op> it = arrayList.get(i).NetworkUserEntityData$$ExternalSyntheticLambda7.iterator();
            while (it.hasNext()) {
                Fragment fragment = it.next().BuiltInFictitiousFunctionClassFactory;
                if (fragment != null && (viewGroup = fragment.mContainer) != null) {
                    hashSet.add(SpecialEffectsController.MyBillsEntityDataFactory(viewGroup, this));
                }
            }
            i++;
        }
        return hashSet;
    }

    private static void executeOps(ArrayList<BackStackRecord> arrayList, ArrayList<Boolean> arrayList2, int i, int i2) {
        while (i < i2) {
            BackStackRecord backStackRecord = arrayList.get(i);
            if (arrayList2.get(i).booleanValue()) {
                backStackRecord.MyBillsEntityDataFactory(-1);
                for (int size = backStackRecord.NetworkUserEntityData$$ExternalSyntheticLambda7.size() - 1; size >= 0; size--) {
                    FragmentTransaction.Op op = backStackRecord.NetworkUserEntityData$$ExternalSyntheticLambda7.get(size);
                    Fragment fragment = op.BuiltInFictitiousFunctionClassFactory;
                    if (fragment != null) {
                        fragment.mBeingSaved = backStackRecord.MyBillsEntityDataFactory;
                        fragment.setPopDirection(true);
                        fragment.setNextTransition(reverseTransit(backStackRecord.FragmentBottomSheetPaymentSettingBinding));
                        fragment.setSharedElementNames(backStackRecord.NetworkUserEntityData$$ExternalSyntheticLambda5, backStackRecord.NetworkUserEntityData$$ExternalSyntheticLambda4);
                    }
                    switch (op.PlaceComponentResult) {
                        case 1:
                            fragment.setAnimations(op.getAuthRequestContext, op.MyBillsEntityDataFactory, op.scheduleImpl, op.moveToNextValue);
                            backStackRecord.PlaceComponentResult.setExitAnimationOrder(fragment, true);
                            backStackRecord.PlaceComponentResult.removeFragment(fragment);
                            break;
                        case 2:
                        default:
                            StringBuilder sb = new StringBuilder();
                            sb.append("Unknown cmd: ");
                            sb.append(op.PlaceComponentResult);
                            throw new IllegalArgumentException(sb.toString());
                        case 3:
                            fragment.setAnimations(op.getAuthRequestContext, op.MyBillsEntityDataFactory, op.scheduleImpl, op.moveToNextValue);
                            backStackRecord.PlaceComponentResult.addFragment(fragment);
                            break;
                        case 4:
                            fragment.setAnimations(op.getAuthRequestContext, op.MyBillsEntityDataFactory, op.scheduleImpl, op.moveToNextValue);
                            backStackRecord.PlaceComponentResult.showFragment(fragment);
                            break;
                        case 5:
                            fragment.setAnimations(op.getAuthRequestContext, op.MyBillsEntityDataFactory, op.scheduleImpl, op.moveToNextValue);
                            backStackRecord.PlaceComponentResult.setExitAnimationOrder(fragment, true);
                            backStackRecord.PlaceComponentResult.hideFragment(fragment);
                            break;
                        case 6:
                            fragment.setAnimations(op.getAuthRequestContext, op.MyBillsEntityDataFactory, op.scheduleImpl, op.moveToNextValue);
                            backStackRecord.PlaceComponentResult.attachFragment(fragment);
                            break;
                        case 7:
                            fragment.setAnimations(op.getAuthRequestContext, op.MyBillsEntityDataFactory, op.scheduleImpl, op.moveToNextValue);
                            backStackRecord.PlaceComponentResult.setExitAnimationOrder(fragment, true);
                            backStackRecord.PlaceComponentResult.detachFragment(fragment);
                            break;
                        case 8:
                            backStackRecord.PlaceComponentResult.setPrimaryNavigationFragment(null);
                            break;
                        case 9:
                            backStackRecord.PlaceComponentResult.setPrimaryNavigationFragment(fragment);
                            break;
                        case 10:
                            backStackRecord.PlaceComponentResult.setMaxLifecycle(fragment, op.lookAheadTest);
                            break;
                    }
                }
            } else {
                backStackRecord.MyBillsEntityDataFactory(1);
                int size2 = backStackRecord.NetworkUserEntityData$$ExternalSyntheticLambda7.size();
                for (int i3 = 0; i3 < size2; i3++) {
                    FragmentTransaction.Op op2 = backStackRecord.NetworkUserEntityData$$ExternalSyntheticLambda7.get(i3);
                    Fragment fragment2 = op2.BuiltInFictitiousFunctionClassFactory;
                    if (fragment2 != null) {
                        fragment2.mBeingSaved = backStackRecord.MyBillsEntityDataFactory;
                        fragment2.setPopDirection(false);
                        fragment2.setNextTransition(backStackRecord.FragmentBottomSheetPaymentSettingBinding);
                        fragment2.setSharedElementNames(backStackRecord.NetworkUserEntityData$$ExternalSyntheticLambda4, backStackRecord.NetworkUserEntityData$$ExternalSyntheticLambda5);
                    }
                    switch (op2.PlaceComponentResult) {
                        case 1:
                            fragment2.setAnimations(op2.getAuthRequestContext, op2.MyBillsEntityDataFactory, op2.scheduleImpl, op2.moveToNextValue);
                            backStackRecord.PlaceComponentResult.setExitAnimationOrder(fragment2, false);
                            backStackRecord.PlaceComponentResult.addFragment(fragment2);
                            break;
                        case 2:
                        default:
                            StringBuilder sb2 = new StringBuilder();
                            sb2.append("Unknown cmd: ");
                            sb2.append(op2.PlaceComponentResult);
                            throw new IllegalArgumentException(sb2.toString());
                        case 3:
                            fragment2.setAnimations(op2.getAuthRequestContext, op2.MyBillsEntityDataFactory, op2.scheduleImpl, op2.moveToNextValue);
                            backStackRecord.PlaceComponentResult.removeFragment(fragment2);
                            break;
                        case 4:
                            fragment2.setAnimations(op2.getAuthRequestContext, op2.MyBillsEntityDataFactory, op2.scheduleImpl, op2.moveToNextValue);
                            backStackRecord.PlaceComponentResult.hideFragment(fragment2);
                            break;
                        case 5:
                            fragment2.setAnimations(op2.getAuthRequestContext, op2.MyBillsEntityDataFactory, op2.scheduleImpl, op2.moveToNextValue);
                            backStackRecord.PlaceComponentResult.setExitAnimationOrder(fragment2, false);
                            backStackRecord.PlaceComponentResult.showFragment(fragment2);
                            break;
                        case 6:
                            fragment2.setAnimations(op2.getAuthRequestContext, op2.MyBillsEntityDataFactory, op2.scheduleImpl, op2.moveToNextValue);
                            backStackRecord.PlaceComponentResult.detachFragment(fragment2);
                            break;
                        case 7:
                            fragment2.setAnimations(op2.getAuthRequestContext, op2.MyBillsEntityDataFactory, op2.scheduleImpl, op2.moveToNextValue);
                            backStackRecord.PlaceComponentResult.setExitAnimationOrder(fragment2, false);
                            backStackRecord.PlaceComponentResult.attachFragment(fragment2);
                            break;
                        case 8:
                            backStackRecord.PlaceComponentResult.setPrimaryNavigationFragment(fragment2);
                            break;
                        case 9:
                            backStackRecord.PlaceComponentResult.setPrimaryNavigationFragment(null);
                            break;
                        case 10:
                            backStackRecord.PlaceComponentResult.setMaxLifecycle(fragment2, op2.KClassImpl$Data$declaredNonStaticMembers$2);
                            break;
                    }
                }
            }
            i++;
        }
    }

    private void setVisibleRemovingFragment(Fragment fragment) {
        ViewGroup fragmentContainer = getFragmentContainer(fragment);
        if (fragmentContainer == null || fragment.getEnterAnim() + fragment.getExitAnim() + fragment.getPopEnterAnim() + fragment.getPopExitAnim() <= 0) {
            return;
        }
        if (fragmentContainer.getTag(R.id.MyBillsEntityDataFactory) == null) {
            fragmentContainer.setTag(R.id.MyBillsEntityDataFactory, fragment);
        }
        ((Fragment) fragmentContainer.getTag(R.id.MyBillsEntityDataFactory)).setPopDirection(fragment.getPopDirection());
    }

    private ViewGroup getFragmentContainer(Fragment fragment) {
        if (fragment.mContainer != null) {
            return fragment.mContainer;
        }
        if (fragment.mContainerId > 0 && this.mContainer.MyBillsEntityDataFactory()) {
            View authRequestContext = this.mContainer.getAuthRequestContext(fragment.mContainerId);
            if (authRequestContext instanceof ViewGroup) {
                return (ViewGroup) authRequestContext;
            }
        }
        return null;
    }

    private void forcePostponedTransactions() {
        for (SpecialEffectsController specialEffectsController : collectAllSpecialEffectsController()) {
            if (specialEffectsController.MyBillsEntityDataFactory) {
                if (isLoggingEnabled(2)) {
                    InstrumentInjector.log_v(TAG, "SpecialEffectsController: Forcing postponed operations");
                }
                specialEffectsController.MyBillsEntityDataFactory = false;
                specialEffectsController.MyBillsEntityDataFactory();
            }
        }
    }

    private void endAnimatingAwayFragments() {
        Iterator<SpecialEffectsController> it = collectAllSpecialEffectsController().iterator();
        while (it.hasNext()) {
            it.next().getAuthRequestContext();
        }
    }

    private Set<SpecialEffectsController> collectAllSpecialEffectsController() {
        HashSet hashSet = new HashSet();
        Iterator<FragmentStateManager> it = this.mFragmentStore.KClassImpl$Data$declaredNonStaticMembers$2().iterator();
        while (it.hasNext()) {
            ViewGroup viewGroup = it.next().PlaceComponentResult.mContainer;
            if (viewGroup != null) {
                hashSet.add(SpecialEffectsController.KClassImpl$Data$declaredNonStaticMembers$2(viewGroup, getSpecialEffectsControllerFactory()));
            }
        }
        return hashSet;
    }

    private boolean generateOpsForPendingActions(ArrayList<BackStackRecord> arrayList, ArrayList<Boolean> arrayList2) {
        synchronized (this.mPendingActions) {
            if (this.mPendingActions.isEmpty()) {
                return false;
            }
            try {
                int size = this.mPendingActions.size();
                boolean z = false;
                for (int i = 0; i < size; i++) {
                    z |= this.mPendingActions.get(i).MyBillsEntityDataFactory(arrayList, arrayList2);
                }
                return z;
            } finally {
                this.mPendingActions.clear();
                this.mHost.getAuthRequestContext.removeCallbacks(this.mExecCommit);
            }
        }
    }

    private void doPendingDeferredStart() {
        if (this.mHavePendingDeferredStart) {
            this.mHavePendingDeferredStart = false;
            startPendingDeferredFragments();
        }
    }

    private void reportBackStackChanged() {
        if (this.mBackStackChangeListeners != null) {
            for (int i = 0; i < this.mBackStackChangeListeners.size(); i++) {
                this.mBackStackChangeListeners.get(i).KClassImpl$Data$declaredNonStaticMembers$2();
            }
        }
    }

    public void addBackStackState(BackStackRecord backStackRecord) {
        if (this.mBackStack == null) {
            this.mBackStack = new ArrayList<>();
        }
        this.mBackStack.add(backStackRecord);
    }

    boolean restoreBackStackState(ArrayList<BackStackRecord> arrayList, ArrayList<Boolean> arrayList2, String str) {
        boolean z;
        BackStackState remove = this.mBackStackStates.remove(str);
        if (remove == null) {
            return false;
        }
        HashMap hashMap = new HashMap();
        Iterator<BackStackRecord> it = arrayList.iterator();
        while (it.hasNext()) {
            BackStackRecord next = it.next();
            if (next.MyBillsEntityDataFactory) {
                Iterator<FragmentTransaction.Op> it2 = next.NetworkUserEntityData$$ExternalSyntheticLambda7.iterator();
                while (it2.hasNext()) {
                    FragmentTransaction.Op next2 = it2.next();
                    if (next2.BuiltInFictitiousFunctionClassFactory != null) {
                        hashMap.put(next2.BuiltInFictitiousFunctionClassFactory.mWho, next2.BuiltInFictitiousFunctionClassFactory);
                    }
                }
            }
        }
        HashMap hashMap2 = new HashMap(remove.BuiltInFictitiousFunctionClassFactory.size());
        for (String str2 : remove.BuiltInFictitiousFunctionClassFactory) {
            Fragment fragment = (Fragment) hashMap.get(str2);
            if (fragment != null) {
                hashMap2.put(fragment.mWho, fragment);
            } else {
                FragmentState remove2 = getFragmentStore().MyBillsEntityDataFactory.remove(str2);
                if (remove2 != null) {
                    Fragment KClassImpl$Data$declaredNonStaticMembers$2 = remove2.KClassImpl$Data$declaredNonStaticMembers$2(getFragmentFactory(), getHost().MyBillsEntityDataFactory.getClassLoader());
                    hashMap2.put(KClassImpl$Data$declaredNonStaticMembers$2.mWho, KClassImpl$Data$declaredNonStaticMembers$2);
                }
            }
        }
        ArrayList arrayList3 = new ArrayList();
        for (BackStackRecordState backStackRecordState : remove.PlaceComponentResult) {
            BackStackRecord backStackRecord = new BackStackRecord(this);
            backStackRecordState.KClassImpl$Data$declaredNonStaticMembers$2(backStackRecord);
            for (int i = 0; i < backStackRecordState.NetworkUserEntityData$$ExternalSyntheticLambda0.size(); i++) {
                String str3 = backStackRecordState.NetworkUserEntityData$$ExternalSyntheticLambda0.get(i);
                if (str3 != null) {
                    Fragment fragment2 = (Fragment) hashMap2.get(str3);
                    if (fragment2 != null) {
                        backStackRecord.NetworkUserEntityData$$ExternalSyntheticLambda7.get(i).BuiltInFictitiousFunctionClassFactory = fragment2;
                    } else {
                        StringBuilder sb = new StringBuilder();
                        sb.append("Restoring FragmentTransaction ");
                        sb.append(backStackRecordState.scheduleImpl);
                        sb.append(" failed due to missing saved state for Fragment (");
                        sb.append(str3);
                        sb.append(")");
                        throw new IllegalStateException(sb.toString());
                    }
                }
            }
            arrayList3.add(backStackRecord);
        }
        Iterator it3 = arrayList3.iterator();
        while (true) {
            while (it3.hasNext()) {
                z = ((BackStackRecord) it3.next()).MyBillsEntityDataFactory(arrayList, arrayList2) || z;
            }
            return z;
        }
    }

    boolean saveBackStackState(ArrayList<BackStackRecord> arrayList, ArrayList<Boolean> arrayList2, String str) {
        int i;
        String obj;
        int findBackStackIndex = findBackStackIndex(str, -1, true);
        if (findBackStackIndex < 0) {
            return false;
        }
        for (int i2 = findBackStackIndex; i2 < this.mBackStack.size(); i2++) {
            BackStackRecord backStackRecord = this.mBackStack.get(i2);
            if (!backStackRecord.isLayoutRequested) {
                StringBuilder sb = new StringBuilder();
                sb.append("saveBackStack(\"");
                sb.append(str);
                sb.append("\") included FragmentTransactions must use setReorderingAllowed(true) to ensure that the back stack can be restored as an atomic operation. Found ");
                sb.append(backStackRecord);
                sb.append(" that did not use setReorderingAllowed(true).");
                throwException(new IllegalArgumentException(sb.toString()));
            }
        }
        HashSet hashSet = new HashSet();
        int i3 = findBackStackIndex;
        while (true) {
            i = 8;
            if (i3 >= this.mBackStack.size()) {
                break;
            }
            BackStackRecord backStackRecord2 = this.mBackStack.get(i3);
            HashSet hashSet2 = new HashSet();
            HashSet hashSet3 = new HashSet();
            Iterator<FragmentTransaction.Op> it = backStackRecord2.NetworkUserEntityData$$ExternalSyntheticLambda7.iterator();
            while (it.hasNext()) {
                FragmentTransaction.Op next = it.next();
                Fragment fragment = next.BuiltInFictitiousFunctionClassFactory;
                if (fragment != null) {
                    if (!next.NetworkUserEntityData$$ExternalSyntheticLambda0 || next.PlaceComponentResult == 1 || next.PlaceComponentResult == 2 || next.PlaceComponentResult == 8) {
                        hashSet.add(fragment);
                        hashSet2.add(fragment);
                    }
                    if (next.PlaceComponentResult == 1 || next.PlaceComponentResult == 2) {
                        hashSet3.add(fragment);
                    }
                }
            }
            hashSet2.removeAll(hashSet3);
            if (!hashSet2.isEmpty()) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("saveBackStack(\"");
                sb2.append(str);
                sb2.append("\") must be self contained and not reference fragments from non-saved FragmentTransactions. Found reference to fragment");
                if (hashSet2.size() == 1) {
                    StringBuilder sb3 = new StringBuilder();
                    sb3.append(" ");
                    sb3.append(hashSet2.iterator().next());
                    obj = sb3.toString();
                } else {
                    StringBuilder sb4 = new StringBuilder();
                    sb4.append("s ");
                    sb4.append(hashSet2);
                    obj = sb4.toString();
                }
                sb2.append(obj);
                sb2.append(" in ");
                sb2.append(backStackRecord2);
                sb2.append(" that were previously added to the FragmentManager through a separate FragmentTransaction.");
                throwException(new IllegalArgumentException(sb2.toString()));
            }
            i3++;
        }
        ArrayDeque arrayDeque = new ArrayDeque(hashSet);
        while (!arrayDeque.isEmpty()) {
            Fragment fragment2 = (Fragment) arrayDeque.removeFirst();
            if (fragment2.mRetainInstance) {
                StringBuilder sb5 = new StringBuilder();
                sb5.append("saveBackStack(\"");
                sb5.append(str);
                sb5.append("\") must not contain retained fragments. Found ");
                sb5.append(hashSet.contains(fragment2) ? "direct reference to retained " : "retained child ");
                sb5.append("fragment ");
                sb5.append(fragment2);
                throwException(new IllegalArgumentException(sb5.toString()));
            }
            for (Fragment fragment3 : fragment2.mChildFragmentManager.getActiveFragments()) {
                if (fragment3 != null) {
                    arrayDeque.addLast(fragment3);
                }
            }
        }
        ArrayList arrayList3 = new ArrayList();
        Iterator it2 = hashSet.iterator();
        while (it2.hasNext()) {
            arrayList3.add(((Fragment) it2.next()).mWho);
        }
        ArrayList arrayList4 = new ArrayList(this.mBackStack.size() - findBackStackIndex);
        for (int i4 = findBackStackIndex; i4 < this.mBackStack.size(); i4++) {
            arrayList4.add(null);
        }
        BackStackState backStackState = new BackStackState(arrayList3, arrayList4);
        int size = this.mBackStack.size() - 1;
        while (size >= findBackStackIndex) {
            BackStackRecord remove = this.mBackStack.remove(size);
            BackStackRecord backStackRecord3 = new BackStackRecord(remove);
            int size2 = backStackRecord3.NetworkUserEntityData$$ExternalSyntheticLambda7.size() - 1;
            while (size2 >= 0) {
                FragmentTransaction.Op op = backStackRecord3.NetworkUserEntityData$$ExternalSyntheticLambda7.get(size2);
                if (op.NetworkUserEntityData$$ExternalSyntheticLambda0) {
                    if (op.PlaceComponentResult == i) {
                        op.NetworkUserEntityData$$ExternalSyntheticLambda0 = false;
                        size2--;
                        backStackRecord3.NetworkUserEntityData$$ExternalSyntheticLambda7.remove(size2);
                    } else {
                        int i5 = op.BuiltInFictitiousFunctionClassFactory.mContainerId;
                        op.PlaceComponentResult = 2;
                        op.NetworkUserEntityData$$ExternalSyntheticLambda0 = false;
                        for (int i6 = size2 - 1; i6 >= 0; i6--) {
                            FragmentTransaction.Op op2 = backStackRecord3.NetworkUserEntityData$$ExternalSyntheticLambda7.get(i6);
                            if (op2.NetworkUserEntityData$$ExternalSyntheticLambda0 && op2.BuiltInFictitiousFunctionClassFactory.mContainerId == i5) {
                                backStackRecord3.NetworkUserEntityData$$ExternalSyntheticLambda7.remove(i6);
                                size2--;
                            }
                        }
                    }
                }
                size2--;
                i = 8;
            }
            arrayList4.set(size - findBackStackIndex, new BackStackRecordState(backStackRecord3));
            remove.MyBillsEntityDataFactory = true;
            arrayList.add(remove);
            arrayList2.add(Boolean.TRUE);
            size--;
            i = 8;
        }
        this.mBackStackStates.put(str, backStackState);
        return true;
    }

    boolean clearBackStackState(ArrayList<BackStackRecord> arrayList, ArrayList<Boolean> arrayList2, String str) {
        if (restoreBackStackState(arrayList, arrayList2, str)) {
            return popBackStackState(arrayList, arrayList2, str, -1, 1);
        }
        return false;
    }

    boolean popBackStackState(ArrayList<BackStackRecord> arrayList, ArrayList<Boolean> arrayList2, String str, int i, int i2) {
        int findBackStackIndex = findBackStackIndex(str, i, (i2 & 1) != 0);
        if (findBackStackIndex < 0) {
            return false;
        }
        for (int size = this.mBackStack.size() - 1; size >= findBackStackIndex; size--) {
            arrayList.add(this.mBackStack.remove(size));
            arrayList2.add(Boolean.TRUE);
        }
        return true;
    }

    private int findBackStackIndex(String str, int i, boolean z) {
        ArrayList<BackStackRecord> arrayList = this.mBackStack;
        if (arrayList == null || arrayList.isEmpty()) {
            return -1;
        }
        if (str == null && i < 0) {
            if (z) {
                return 0;
            }
            return this.mBackStack.size() - 1;
        }
        int size = this.mBackStack.size() - 1;
        while (size >= 0) {
            BackStackRecord backStackRecord = this.mBackStack.get(size);
            if ((str != null && str.equals(backStackRecord.NetworkUserEntityData$$ExternalSyntheticLambda8)) || (i >= 0 && i == backStackRecord.BuiltInFictitiousFunctionClassFactory)) {
                break;
            }
            size--;
        }
        if (size < 0) {
            return size;
        }
        if (!z) {
            if (size == this.mBackStack.size() - 1) {
                return -1;
            }
            return size + 1;
        }
        while (size > 0) {
            BackStackRecord backStackRecord2 = this.mBackStack.get(size - 1);
            if ((str == null || !str.equals(backStackRecord2.NetworkUserEntityData$$ExternalSyntheticLambda8)) && (i < 0 || i != backStackRecord2.BuiltInFictitiousFunctionClassFactory)) {
                return size;
            }
            size--;
        }
        return size;
    }

    @Deprecated
    FragmentManagerNonConfig retainNonConfig() {
        if (this.mHost instanceof ViewModelStoreOwner) {
            throwException(new IllegalStateException("You cannot use retainNonConfig when your FragmentHostCallback implements ViewModelStoreOwner."));
        }
        return this.mNonConfig.MyBillsEntityDataFactory();
    }

    Parcelable saveAllState() {
        if (this.mHost instanceof SavedStateRegistryOwner) {
            throwException(new IllegalStateException("You cannot use saveAllState when your FragmentHostCallback implements SavedStateRegistryOwner."));
        }
        Bundle m37lambda$attachController$4$androidxfragmentappFragmentManager = m37lambda$attachController$4$androidxfragmentappFragmentManager();
        if (m37lambda$attachController$4$androidxfragmentappFragmentManager.isEmpty()) {
            return null;
        }
        return m37lambda$attachController$4$androidxfragmentappFragmentManager;
    }

    /* renamed from: saveAllStateInternal */
    public Bundle m37lambda$attachController$4$androidxfragmentappFragmentManager() {
        int size;
        Bundle bundle = new Bundle();
        forcePostponedTransactions();
        endAnimatingAwayFragments();
        execPendingActions(true);
        this.mStateSaved = true;
        this.mNonConfig.KClassImpl$Data$declaredNonStaticMembers$2 = true;
        FragmentStore fragmentStore = this.mFragmentStore;
        ArrayList<String> arrayList = new ArrayList<>(fragmentStore.KClassImpl$Data$declaredNonStaticMembers$2.size());
        for (FragmentStateManager fragmentStateManager : fragmentStore.KClassImpl$Data$declaredNonStaticMembers$2.values()) {
            if (fragmentStateManager != null) {
                Fragment fragment = fragmentStateManager.PlaceComponentResult;
                fragmentStateManager.MyBillsEntityDataFactory();
                arrayList.add(fragment.mWho);
                if (isLoggingEnabled(2)) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("Saved state of ");
                    sb.append(fragment);
                    sb.append(": ");
                    sb.append(fragment.mSavedFragmentState);
                    InstrumentInjector.log_v(TAG, sb.toString());
                }
            }
        }
        ArrayList arrayList2 = new ArrayList(this.mFragmentStore.MyBillsEntityDataFactory.values());
        if (arrayList2.isEmpty()) {
            if (isLoggingEnabled(2)) {
                InstrumentInjector.log_v(TAG, "saveAllState: no fragments!");
            }
        } else {
            ArrayList<String> MyBillsEntityDataFactory2 = this.mFragmentStore.MyBillsEntityDataFactory();
            ArrayList<BackStackRecord> arrayList3 = this.mBackStack;
            BackStackRecordState[] backStackRecordStateArr = null;
            if (arrayList3 != null && (size = arrayList3.size()) > 0) {
                backStackRecordStateArr = new BackStackRecordState[size];
                for (int i = 0; i < size; i++) {
                    backStackRecordStateArr[i] = new BackStackRecordState(this.mBackStack.get(i));
                    if (isLoggingEnabled(2)) {
                        StringBuilder sb2 = new StringBuilder();
                        sb2.append("saveAllState: adding back stack #");
                        sb2.append(i);
                        sb2.append(": ");
                        sb2.append(this.mBackStack.get(i));
                        InstrumentInjector.log_v(TAG, sb2.toString());
                    }
                }
            }
            FragmentManagerState fragmentManagerState = new FragmentManagerState();
            fragmentManagerState.KClassImpl$Data$declaredNonStaticMembers$2 = arrayList;
            fragmentManagerState.PlaceComponentResult = MyBillsEntityDataFactory2;
            fragmentManagerState.getAuthRequestContext = backStackRecordStateArr;
            fragmentManagerState.MyBillsEntityDataFactory = this.mBackStackIndex.get();
            Fragment fragment2 = this.mPrimaryNav;
            if (fragment2 != null) {
                fragmentManagerState.lookAheadTest = fragment2.mWho;
            }
            fragmentManagerState.BuiltInFictitiousFunctionClassFactory.addAll(this.mBackStackStates.keySet());
            fragmentManagerState.scheduleImpl.addAll(this.mBackStackStates.values());
            fragmentManagerState.getErrorConfigVersion = new ArrayList<>(this.mLaunchedFragments);
            bundle.putParcelable("state", fragmentManagerState);
            for (String str : this.mResults.keySet()) {
                StringBuilder sb3 = new StringBuilder();
                sb3.append(RESULT_NAME_PREFIX);
                sb3.append(str);
                bundle.putBundle(sb3.toString(), this.mResults.get(str));
            }
            Iterator it = arrayList2.iterator();
            while (it.hasNext()) {
                FragmentState fragmentState = (FragmentState) it.next();
                Bundle bundle2 = new Bundle();
                bundle2.putParcelable("state", fragmentState);
                StringBuilder sb4 = new StringBuilder();
                sb4.append(FRAGMENT_NAME_PREFIX);
                sb4.append(fragmentState.initRecordTimeStamp);
                bundle.putBundle(sb4.toString(), bundle2);
            }
        }
        return bundle;
    }

    void restoreAllState(Parcelable parcelable, FragmentManagerNonConfig fragmentManagerNonConfig) {
        if (this.mHost instanceof ViewModelStoreOwner) {
            throwException(new IllegalStateException("You must use restoreSaveState when your FragmentHostCallback implements ViewModelStoreOwner"));
        }
        this.mNonConfig.MyBillsEntityDataFactory(fragmentManagerNonConfig);
        restoreSaveStateInternal(parcelable);
    }

    void restoreSaveState(Parcelable parcelable) {
        if (this.mHost instanceof SavedStateRegistryOwner) {
            throwException(new IllegalStateException("You cannot use restoreSaveState when your FragmentHostCallback implements SavedStateRegistryOwner."));
        }
        restoreSaveStateInternal(parcelable);
    }

    public void restoreSaveStateInternal(Parcelable parcelable) {
        FragmentStateManager fragmentStateManager;
        Bundle bundle;
        Bundle bundle2;
        if (parcelable == null) {
            return;
        }
        Bundle bundle3 = (Bundle) parcelable;
        for (String str : bundle3.keySet()) {
            if (str.startsWith(RESULT_NAME_PREFIX) && (bundle2 = bundle3.getBundle(str)) != null) {
                bundle2.setClassLoader(this.mHost.MyBillsEntityDataFactory.getClassLoader());
                this.mResults.put(str.substring(7), bundle2);
            }
        }
        ArrayList arrayList = new ArrayList();
        for (String str2 : bundle3.keySet()) {
            if (str2.startsWith(FRAGMENT_NAME_PREFIX) && (bundle = bundle3.getBundle(str2)) != null) {
                bundle.setClassLoader(this.mHost.MyBillsEntityDataFactory.getClassLoader());
                arrayList.add((FragmentState) bundle.getParcelable("state"));
            }
        }
        FragmentStore fragmentStore = this.mFragmentStore;
        fragmentStore.MyBillsEntityDataFactory.clear();
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            FragmentState fragmentState = (FragmentState) it.next();
            fragmentStore.MyBillsEntityDataFactory.put(fragmentState.initRecordTimeStamp, fragmentState);
        }
        FragmentManagerState fragmentManagerState = (FragmentManagerState) bundle3.getParcelable("state");
        if (fragmentManagerState == null) {
            return;
        }
        this.mFragmentStore.KClassImpl$Data$declaredNonStaticMembers$2.clear();
        Iterator<String> it2 = fragmentManagerState.KClassImpl$Data$declaredNonStaticMembers$2.iterator();
        while (it2.hasNext()) {
            FragmentState remove = this.mFragmentStore.MyBillsEntityDataFactory.remove(it2.next());
            if (remove != null) {
                Fragment fragment = this.mNonConfig.BuiltInFictitiousFunctionClassFactory.get(remove.initRecordTimeStamp);
                if (fragment != null) {
                    if (isLoggingEnabled(2)) {
                        StringBuilder sb = new StringBuilder();
                        sb.append("restoreSaveState: re-attaching retained ");
                        sb.append(fragment);
                        InstrumentInjector.log_v(TAG, sb.toString());
                    }
                    fragmentStateManager = new FragmentStateManager(this.mLifecycleCallbacksDispatcher, this.mFragmentStore, fragment, remove);
                } else {
                    fragmentStateManager = new FragmentStateManager(this.mLifecycleCallbacksDispatcher, this.mFragmentStore, this.mHost.MyBillsEntityDataFactory.getClassLoader(), getFragmentFactory(), remove);
                }
                Fragment fragment2 = fragmentStateManager.PlaceComponentResult;
                fragment2.mFragmentManager = this;
                if (isLoggingEnabled(2)) {
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("restoreSaveState: active (");
                    sb2.append(fragment2.mWho);
                    sb2.append("): ");
                    sb2.append(fragment2);
                    InstrumentInjector.log_v(TAG, sb2.toString());
                }
                fragmentStateManager.BuiltInFictitiousFunctionClassFactory(this.mHost.MyBillsEntityDataFactory.getClassLoader());
                this.mFragmentStore.BuiltInFictitiousFunctionClassFactory(fragmentStateManager);
                fragmentStateManager.MyBillsEntityDataFactory = this.mCurState;
            }
        }
        for (Fragment fragment3 : new ArrayList(this.mNonConfig.BuiltInFictitiousFunctionClassFactory.values())) {
            if (!this.mFragmentStore.KClassImpl$Data$declaredNonStaticMembers$2(fragment3.mWho)) {
                if (isLoggingEnabled(2)) {
                    StringBuilder sb3 = new StringBuilder();
                    sb3.append("Discarding retained Fragment ");
                    sb3.append(fragment3);
                    sb3.append(" that was not found in the set of active Fragments ");
                    sb3.append(fragmentManagerState.KClassImpl$Data$declaredNonStaticMembers$2);
                    InstrumentInjector.log_v(TAG, sb3.toString());
                }
                this.mNonConfig.BuiltInFictitiousFunctionClassFactory(fragment3);
                fragment3.mFragmentManager = this;
                FragmentStateManager fragmentStateManager2 = new FragmentStateManager(this.mLifecycleCallbacksDispatcher, this.mFragmentStore, fragment3);
                fragmentStateManager2.MyBillsEntityDataFactory = 1;
                fragmentStateManager2.PlaceComponentResult();
                fragment3.mRemoving = true;
                fragmentStateManager2.PlaceComponentResult();
            }
        }
        FragmentStore fragmentStore2 = this.mFragmentStore;
        ArrayList<String> arrayList2 = fragmentManagerState.PlaceComponentResult;
        fragmentStore2.PlaceComponentResult.clear();
        if (arrayList2 != null) {
            for (String str3 : arrayList2) {
                FragmentStateManager fragmentStateManager3 = fragmentStore2.KClassImpl$Data$declaredNonStaticMembers$2.get(str3);
                Fragment fragment4 = fragmentStateManager3 != null ? fragmentStateManager3.PlaceComponentResult : null;
                if (fragment4 == null) {
                    StringBuilder sb4 = new StringBuilder();
                    sb4.append("No instantiated fragment for (");
                    sb4.append(str3);
                    sb4.append(")");
                    throw new IllegalStateException(sb4.toString());
                }
                if (isLoggingEnabled(2)) {
                    StringBuilder sb5 = new StringBuilder();
                    sb5.append("restoreSaveState: added (");
                    sb5.append(str3);
                    sb5.append("): ");
                    sb5.append(fragment4);
                    InstrumentInjector.log_v(TAG, sb5.toString());
                }
                fragmentStore2.KClassImpl$Data$declaredNonStaticMembers$2(fragment4);
            }
        }
        if (fragmentManagerState.getAuthRequestContext != null) {
            this.mBackStack = new ArrayList<>(fragmentManagerState.getAuthRequestContext.length);
            for (int i = 0; i < fragmentManagerState.getAuthRequestContext.length; i++) {
                BackStackRecordState backStackRecordState = fragmentManagerState.getAuthRequestContext[i];
                BackStackRecord backStackRecord = new BackStackRecord(this);
                backStackRecordState.KClassImpl$Data$declaredNonStaticMembers$2(backStackRecord);
                backStackRecord.BuiltInFictitiousFunctionClassFactory = backStackRecordState.getErrorConfigVersion;
                for (int i2 = 0; i2 < backStackRecordState.NetworkUserEntityData$$ExternalSyntheticLambda0.size(); i2++) {
                    String str4 = backStackRecordState.NetworkUserEntityData$$ExternalSyntheticLambda0.get(i2);
                    if (str4 != null) {
                        backStackRecord.NetworkUserEntityData$$ExternalSyntheticLambda7.get(i2).BuiltInFictitiousFunctionClassFactory = findActiveFragment(str4);
                    }
                }
                backStackRecord.MyBillsEntityDataFactory(1);
                if (isLoggingEnabled(2)) {
                    StringBuilder sb6 = new StringBuilder();
                    sb6.append("restoreAllState: back stack #");
                    sb6.append(i);
                    sb6.append(" (index ");
                    sb6.append(backStackRecord.BuiltInFictitiousFunctionClassFactory);
                    sb6.append("): ");
                    sb6.append(backStackRecord);
                    InstrumentInjector.log_v(TAG, sb6.toString());
                    PrintWriter printWriter = new PrintWriter(new LogWriter(TAG));
                    backStackRecord.KClassImpl$Data$declaredNonStaticMembers$2("  ", printWriter, false);
                    printWriter.close();
                }
                this.mBackStack.add(backStackRecord);
            }
        } else {
            this.mBackStack = null;
        }
        this.mBackStackIndex.set(fragmentManagerState.MyBillsEntityDataFactory);
        if (fragmentManagerState.lookAheadTest != null) {
            Fragment findActiveFragment = findActiveFragment(fragmentManagerState.lookAheadTest);
            this.mPrimaryNav = findActiveFragment;
            dispatchParentPrimaryNavigationFragmentChanged(findActiveFragment);
        }
        ArrayList<String> arrayList3 = fragmentManagerState.BuiltInFictitiousFunctionClassFactory;
        if (arrayList3 != null) {
            for (int i3 = 0; i3 < arrayList3.size(); i3++) {
                this.mBackStackStates.put(arrayList3.get(i3), fragmentManagerState.scheduleImpl.get(i3));
            }
        }
        this.mLaunchedFragments = new ArrayDeque<>(fragmentManagerState.getErrorConfigVersion);
    }

    public FragmentHostCallback<?> getHost() {
        return this.mHost;
    }

    public Fragment getParent() {
        return this.mParent;
    }

    public FragmentContainer getContainer() {
        return this.mContainer;
    }

    FragmentStore getFragmentStore() {
        return this.mFragmentStore;
    }

    public void attachController(FragmentHostCallback<?> fragmentHostCallback, FragmentContainer fragmentContainer, final Fragment fragment) {
        String str;
        if (this.mHost != null) {
            throw new IllegalStateException("Already attached");
        }
        this.mHost = fragmentHostCallback;
        this.mContainer = fragmentContainer;
        this.mParent = fragment;
        if (fragment != null) {
            addFragmentOnAttachListener(new FragmentOnAttachListener() { // from class: androidx.fragment.app.FragmentManager.7
                {
                    FragmentManager.this = this;
                }

                @Override // androidx.fragment.app.FragmentOnAttachListener
                public final void KClassImpl$Data$declaredNonStaticMembers$2(FragmentManager fragmentManager, Fragment fragment2) {
                    fragment.onAttachFragment(fragment2);
                }
            });
        } else if (fragmentHostCallback instanceof FragmentOnAttachListener) {
            addFragmentOnAttachListener((FragmentOnAttachListener) fragmentHostCallback);
        }
        if (this.mParent != null) {
            updateOnBackPressedCallbackEnabled();
        }
        if (fragmentHostCallback instanceof OnBackPressedDispatcherOwner) {
            OnBackPressedDispatcherOwner onBackPressedDispatcherOwner = (OnBackPressedDispatcherOwner) fragmentHostCallback;
            OnBackPressedDispatcher onBackPressedDispatcher = onBackPressedDispatcherOwner.getOnBackPressedDispatcher();
            this.mOnBackPressedDispatcher = onBackPressedDispatcher;
            LifecycleOwner lifecycleOwner = onBackPressedDispatcherOwner;
            if (fragment != null) {
                lifecycleOwner = fragment;
            }
            onBackPressedDispatcher.PlaceComponentResult(lifecycleOwner, this.mOnBackPressedCallback);
        }
        if (fragment != null) {
            this.mNonConfig = fragment.mFragmentManager.getChildNonConfig(fragment);
        } else if (fragmentHostCallback instanceof ViewModelStoreOwner) {
            this.mNonConfig = FragmentManagerViewModel.KClassImpl$Data$declaredNonStaticMembers$2(((ViewModelStoreOwner) fragmentHostCallback).getViewModelStore());
        } else {
            this.mNonConfig = new FragmentManagerViewModel(false);
        }
        this.mNonConfig.KClassImpl$Data$declaredNonStaticMembers$2 = isStateSaved();
        this.mFragmentStore.BuiltInFictitiousFunctionClassFactory = this.mNonConfig;
        FragmentHostCallback<?> fragmentHostCallback2 = this.mHost;
        if ((fragmentHostCallback2 instanceof SavedStateRegistryOwner) && fragment == null) {
            SavedStateRegistry savedStateRegistry = ((SavedStateRegistryOwner) fragmentHostCallback2).getSavedStateRegistry();
            savedStateRegistry.KClassImpl$Data$declaredNonStaticMembers$2(SAVED_STATE_TAG, new SavedStateRegistry.SavedStateProvider() { // from class: androidx.fragment.app.FragmentManager$$ExternalSyntheticLambda4
                @Override // androidx.savedstate.SavedStateRegistry.SavedStateProvider
                public final Bundle KClassImpl$Data$declaredNonStaticMembers$2() {
                    return FragmentManager.this.m37lambda$attachController$4$androidxfragmentappFragmentManager();
                }
            });
            Bundle PlaceComponentResult = savedStateRegistry.PlaceComponentResult(SAVED_STATE_TAG);
            if (PlaceComponentResult != null) {
                restoreSaveStateInternal(PlaceComponentResult);
            }
        }
        FragmentHostCallback<?> fragmentHostCallback3 = this.mHost;
        if (fragmentHostCallback3 instanceof ActivityResultRegistryOwner) {
            ActivityResultRegistry activityResultRegistry = ((ActivityResultRegistryOwner) fragmentHostCallback3).getActivityResultRegistry();
            if (fragment != null) {
                StringBuilder sb = new StringBuilder();
                sb.append(fragment.mWho);
                sb.append(":");
                str = sb.toString();
            } else {
                str = "";
            }
            StringBuilder sb2 = new StringBuilder();
            sb2.append("FragmentManager:");
            sb2.append(str);
            String obj = sb2.toString();
            StringBuilder sb3 = new StringBuilder();
            sb3.append(obj);
            sb3.append("StartActivityForResult");
            this.mStartActivityForResult = activityResultRegistry.getAuthRequestContext(sb3.toString(), new ActivityResultContracts.StartActivityForResult(), new ActivityResultCallback<ActivityResult>() { // from class: androidx.fragment.app.FragmentManager.8
                {
                    FragmentManager.this = this;
                }

                @Override // androidx.view.result.ActivityResultCallback
                public /* synthetic */ void onActivityResult(ActivityResult activityResult) {
                    ActivityResult activityResult2 = activityResult;
                    LaunchedFragmentInfo pollFirst = FragmentManager.this.mLaunchedFragments.pollFirst();
                    if (pollFirst == null) {
                        StringBuilder sb4 = new StringBuilder();
                        sb4.append("No Activities were started for result for ");
                        sb4.append(this);
                        InstrumentInjector.log_w(FragmentManager.TAG, sb4.toString());
                        return;
                    }
                    String str2 = pollFirst.MyBillsEntityDataFactory;
                    int i = pollFirst.BuiltInFictitiousFunctionClassFactory;
                    Fragment BuiltInFictitiousFunctionClassFactory2 = FragmentManager.this.mFragmentStore.BuiltInFictitiousFunctionClassFactory(str2);
                    if (BuiltInFictitiousFunctionClassFactory2 == null) {
                        StringBuilder sb5 = new StringBuilder();
                        sb5.append("Activity result delivered for unknown Fragment ");
                        sb5.append(str2);
                        InstrumentInjector.log_w(FragmentManager.TAG, sb5.toString());
                        return;
                    }
                    BuiltInFictitiousFunctionClassFactory2.onActivityResult(i, activityResult2.BuiltInFictitiousFunctionClassFactory, activityResult2.MyBillsEntityDataFactory);
                }
            });
            StringBuilder sb4 = new StringBuilder();
            sb4.append(obj);
            sb4.append("StartIntentSenderForResult");
            this.mStartIntentSenderForResult = activityResultRegistry.getAuthRequestContext(sb4.toString(), new FragmentIntentSenderContract(), new ActivityResultCallback<ActivityResult>() { // from class: androidx.fragment.app.FragmentManager.9
                {
                    FragmentManager.this = this;
                }

                @Override // androidx.view.result.ActivityResultCallback
                public /* synthetic */ void onActivityResult(ActivityResult activityResult) {
                    ActivityResult activityResult2 = activityResult;
                    LaunchedFragmentInfo pollFirst = FragmentManager.this.mLaunchedFragments.pollFirst();
                    if (pollFirst == null) {
                        StringBuilder sb5 = new StringBuilder();
                        sb5.append("No IntentSenders were started for ");
                        sb5.append(this);
                        InstrumentInjector.log_w(FragmentManager.TAG, sb5.toString());
                        return;
                    }
                    String str2 = pollFirst.MyBillsEntityDataFactory;
                    int i = pollFirst.BuiltInFictitiousFunctionClassFactory;
                    Fragment BuiltInFictitiousFunctionClassFactory2 = FragmentManager.this.mFragmentStore.BuiltInFictitiousFunctionClassFactory(str2);
                    if (BuiltInFictitiousFunctionClassFactory2 == null) {
                        StringBuilder sb6 = new StringBuilder();
                        sb6.append("Intent Sender result delivered for unknown Fragment ");
                        sb6.append(str2);
                        InstrumentInjector.log_w(FragmentManager.TAG, sb6.toString());
                        return;
                    }
                    BuiltInFictitiousFunctionClassFactory2.onActivityResult(i, activityResult2.BuiltInFictitiousFunctionClassFactory, activityResult2.MyBillsEntityDataFactory);
                }
            });
            StringBuilder sb5 = new StringBuilder();
            sb5.append(obj);
            sb5.append("RequestPermissions");
            this.mRequestPermissions = activityResultRegistry.getAuthRequestContext(sb5.toString(), new ActivityResultContracts.RequestMultiplePermissions(), new ActivityResultCallback<Map<String, Boolean>>() { // from class: androidx.fragment.app.FragmentManager.10
                {
                    FragmentManager.this = this;
                }

                @Override // androidx.view.result.ActivityResultCallback
                public /* synthetic */ void onActivityResult(Map<String, Boolean> map) {
                    Map<String, Boolean> map2 = map;
                    String[] strArr = (String[]) map2.keySet().toArray(new String[0]);
                    ArrayList arrayList = new ArrayList(map2.values());
                    int[] iArr = new int[arrayList.size()];
                    for (int i = 0; i < arrayList.size(); i++) {
                        iArr[i] = ((Boolean) arrayList.get(i)).booleanValue() ? 0 : -1;
                    }
                    LaunchedFragmentInfo pollFirst = FragmentManager.this.mLaunchedFragments.pollFirst();
                    if (pollFirst == null) {
                        StringBuilder sb6 = new StringBuilder();
                        sb6.append("No permissions were requested for ");
                        sb6.append(this);
                        InstrumentInjector.log_w(FragmentManager.TAG, sb6.toString());
                        return;
                    }
                    String str2 = pollFirst.MyBillsEntityDataFactory;
                    int i2 = pollFirst.BuiltInFictitiousFunctionClassFactory;
                    Fragment BuiltInFictitiousFunctionClassFactory2 = FragmentManager.this.mFragmentStore.BuiltInFictitiousFunctionClassFactory(str2);
                    if (BuiltInFictitiousFunctionClassFactory2 == null) {
                        StringBuilder sb7 = new StringBuilder();
                        sb7.append("Permission request result delivered for unknown Fragment ");
                        sb7.append(str2);
                        InstrumentInjector.log_w(FragmentManager.TAG, sb7.toString());
                        return;
                    }
                    BuiltInFictitiousFunctionClassFactory2.onRequestPermissionsResult(i2, strArr, iArr);
                }
            });
        }
        FragmentHostCallback<?> fragmentHostCallback4 = this.mHost;
        if (fragmentHostCallback4 instanceof OnConfigurationChangedProvider) {
            ((OnConfigurationChangedProvider) fragmentHostCallback4).addOnConfigurationChangedListener(this.mOnConfigurationChangedListener);
        }
        FragmentHostCallback<?> fragmentHostCallback5 = this.mHost;
        if (fragmentHostCallback5 instanceof OnTrimMemoryProvider) {
            ((OnTrimMemoryProvider) fragmentHostCallback5).addOnTrimMemoryListener(this.mOnTrimMemoryListener);
        }
        FragmentHostCallback<?> fragmentHostCallback6 = this.mHost;
        if (fragmentHostCallback6 instanceof OnMultiWindowModeChangedProvider) {
            ((OnMultiWindowModeChangedProvider) fragmentHostCallback6).addOnMultiWindowModeChangedListener(this.mOnMultiWindowModeChangedListener);
        }
        FragmentHostCallback<?> fragmentHostCallback7 = this.mHost;
        if (fragmentHostCallback7 instanceof OnPictureInPictureModeChangedProvider) {
            ((OnPictureInPictureModeChangedProvider) fragmentHostCallback7).addOnPictureInPictureModeChangedListener(this.mOnPictureInPictureModeChangedListener);
        }
        FragmentHostCallback<?> fragmentHostCallback8 = this.mHost;
        if ((fragmentHostCallback8 instanceof MenuHost) && fragment == null) {
            ((MenuHost) fragmentHostCallback8).addMenuProvider(this.mMenuProvider);
        }
    }

    public void noteStateNotSaved() {
        if (this.mHost == null) {
            return;
        }
        this.mStateSaved = false;
        this.mStopped = false;
        this.mNonConfig.KClassImpl$Data$declaredNonStaticMembers$2 = false;
        for (Fragment fragment : this.mFragmentStore.getAuthRequestContext()) {
            if (fragment != null) {
                fragment.noteStateNotSaved();
            }
        }
    }

    public void launchStartActivityForResult(Fragment fragment, Intent intent, int i, Bundle bundle) {
        if (this.mStartActivityForResult != null) {
            this.mLaunchedFragments.addLast(new LaunchedFragmentInfo(fragment.mWho, i));
            if (intent != null && bundle != null) {
                intent.putExtra("androidx.activity.result.contract.extra.ACTIVITY_OPTIONS_BUNDLE", bundle);
            }
            this.mStartActivityForResult.MyBillsEntityDataFactory(intent, null);
            return;
        }
        FragmentHostCallback<?> fragmentHostCallback = this.mHost;
        if (i != -1) {
            throw new IllegalStateException("Starting activity with a requestCode requires a FragmentActivity host");
        }
        ContextCompat.MyBillsEntityDataFactory(fragmentHostCallback.MyBillsEntityDataFactory, intent, bundle);
    }

    public void launchStartIntentSenderForResult(Fragment fragment, IntentSender intentSender, int i, Intent intent, int i2, int i3, int i4, Bundle bundle) throws IntentSender.SendIntentException {
        Intent intent2;
        if (this.mStartIntentSenderForResult != null) {
            if (bundle != null) {
                if (intent == null) {
                    intent2 = new Intent();
                    intent2.putExtra(EXTRA_CREATED_FILLIN_INTENT, true);
                } else {
                    intent2 = intent;
                }
                if (isLoggingEnabled(2)) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("ActivityOptions ");
                    sb.append(bundle);
                    sb.append(" were added to fillInIntent ");
                    sb.append(intent2);
                    sb.append(" for fragment ");
                    sb.append(fragment);
                    InstrumentInjector.log_v(TAG, sb.toString());
                }
                intent2.putExtra("androidx.activity.result.contract.extra.ACTIVITY_OPTIONS_BUNDLE", bundle);
            } else {
                intent2 = intent;
            }
            IntentSenderRequest.Builder builder = new IntentSenderRequest.Builder(intentSender);
            builder.MyBillsEntityDataFactory = intent2;
            builder.KClassImpl$Data$declaredNonStaticMembers$2 = i3;
            builder.BuiltInFictitiousFunctionClassFactory = i2;
            IntentSenderRequest intentSenderRequest = new IntentSenderRequest(builder.PlaceComponentResult, builder.MyBillsEntityDataFactory, builder.BuiltInFictitiousFunctionClassFactory, builder.KClassImpl$Data$declaredNonStaticMembers$2);
            this.mLaunchedFragments.addLast(new LaunchedFragmentInfo(fragment.mWho, i));
            if (isLoggingEnabled(2)) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("Fragment ");
                sb2.append(fragment);
                sb2.append("is launching an IntentSender for result ");
                InstrumentInjector.log_v(TAG, sb2.toString());
            }
            this.mStartIntentSenderForResult.MyBillsEntityDataFactory(intentSenderRequest, null);
            return;
        }
        FragmentHostCallback<?> fragmentHostCallback = this.mHost;
        if (i != -1) {
            throw new IllegalStateException("Starting intent sender with a requestCode requires a FragmentActivity host");
        }
        ActivityCompat.PlaceComponentResult(fragmentHostCallback.KClassImpl$Data$declaredNonStaticMembers$2, intentSender, i, intent, i2, i3, i4, bundle);
    }

    public void launchRequestPermissions(Fragment fragment, String[] strArr, int i) {
        if (this.mRequestPermissions != null) {
            this.mLaunchedFragments.addLast(new LaunchedFragmentInfo(fragment.mWho, i));
            this.mRequestPermissions.MyBillsEntityDataFactory(strArr, null);
        }
    }

    public void dispatchAttach() {
        this.mStateSaved = false;
        this.mStopped = false;
        this.mNonConfig.KClassImpl$Data$declaredNonStaticMembers$2 = false;
        dispatchStateChange(0);
    }

    public void dispatchCreate() {
        this.mStateSaved = false;
        this.mStopped = false;
        this.mNonConfig.KClassImpl$Data$declaredNonStaticMembers$2 = false;
        dispatchStateChange(1);
    }

    public void dispatchViewCreated() {
        dispatchStateChange(2);
    }

    public void dispatchActivityCreated() {
        this.mStateSaved = false;
        this.mStopped = false;
        this.mNonConfig.KClassImpl$Data$declaredNonStaticMembers$2 = false;
        dispatchStateChange(4);
    }

    public void dispatchStart() {
        this.mStateSaved = false;
        this.mStopped = false;
        this.mNonConfig.KClassImpl$Data$declaredNonStaticMembers$2 = false;
        dispatchStateChange(5);
    }

    public void dispatchResume() {
        this.mStateSaved = false;
        this.mStopped = false;
        this.mNonConfig.KClassImpl$Data$declaredNonStaticMembers$2 = false;
        dispatchStateChange(7);
    }

    public void dispatchPause() {
        dispatchStateChange(5);
    }

    public void dispatchStop() {
        this.mStopped = true;
        this.mNonConfig.KClassImpl$Data$declaredNonStaticMembers$2 = true;
        dispatchStateChange(4);
    }

    public void dispatchDestroyView() {
        dispatchStateChange(1);
    }

    public void dispatchDestroy() {
        this.mDestroyed = true;
        execPendingActions(true);
        endAnimatingAwayFragments();
        clearBackStackStateViewModels();
        dispatchStateChange(-1);
        FragmentHostCallback<?> fragmentHostCallback = this.mHost;
        if (fragmentHostCallback instanceof OnTrimMemoryProvider) {
            ((OnTrimMemoryProvider) fragmentHostCallback).removeOnTrimMemoryListener(this.mOnTrimMemoryListener);
        }
        FragmentHostCallback<?> fragmentHostCallback2 = this.mHost;
        if (fragmentHostCallback2 instanceof OnConfigurationChangedProvider) {
            ((OnConfigurationChangedProvider) fragmentHostCallback2).removeOnConfigurationChangedListener(this.mOnConfigurationChangedListener);
        }
        FragmentHostCallback<?> fragmentHostCallback3 = this.mHost;
        if (fragmentHostCallback3 instanceof OnMultiWindowModeChangedProvider) {
            ((OnMultiWindowModeChangedProvider) fragmentHostCallback3).removeOnMultiWindowModeChangedListener(this.mOnMultiWindowModeChangedListener);
        }
        FragmentHostCallback<?> fragmentHostCallback4 = this.mHost;
        if (fragmentHostCallback4 instanceof OnPictureInPictureModeChangedProvider) {
            ((OnPictureInPictureModeChangedProvider) fragmentHostCallback4).removeOnPictureInPictureModeChangedListener(this.mOnPictureInPictureModeChangedListener);
        }
        FragmentHostCallback<?> fragmentHostCallback5 = this.mHost;
        if ((fragmentHostCallback5 instanceof MenuHost) && this.mParent == null) {
            ((MenuHost) fragmentHostCallback5).removeMenuProvider(this.mMenuProvider);
        }
        this.mHost = null;
        this.mContainer = null;
        this.mParent = null;
        if (this.mOnBackPressedDispatcher != null) {
            this.mOnBackPressedCallback.remove();
            this.mOnBackPressedDispatcher = null;
        }
        ActivityResultLauncher<Intent> activityResultLauncher = this.mStartActivityForResult;
        if (activityResultLauncher != null) {
            activityResultLauncher.getAuthRequestContext();
            this.mStartIntentSenderForResult.getAuthRequestContext();
            this.mRequestPermissions.getAuthRequestContext();
        }
    }

    private void dispatchStateChange(int i) {
        try {
            this.mExecutingActions = true;
            for (FragmentStateManager fragmentStateManager : this.mFragmentStore.KClassImpl$Data$declaredNonStaticMembers$2.values()) {
                if (fragmentStateManager != null) {
                    fragmentStateManager.MyBillsEntityDataFactory = i;
                }
            }
            moveToState(i, false);
            Iterator<SpecialEffectsController> it = collectAllSpecialEffectsController().iterator();
            while (it.hasNext()) {
                it.next().getAuthRequestContext();
            }
            this.mExecutingActions = false;
            execPendingActions(true);
        } catch (Throwable th) {
            this.mExecutingActions = false;
            throw th;
        }
    }

    void dispatchMultiWindowModeChanged(boolean z, boolean z2) {
        if (z2 && (this.mHost instanceof OnMultiWindowModeChangedProvider)) {
            throwException(new IllegalStateException("Do not call dispatchMultiWindowModeChanged() on host. Host implements OnMultiWindowModeChangedProvider and automatically dispatches multi-window mode changes to fragments."));
        }
        for (Fragment fragment : this.mFragmentStore.getAuthRequestContext()) {
            if (fragment != null) {
                fragment.performMultiWindowModeChanged(z);
                if (z2) {
                    fragment.mChildFragmentManager.dispatchMultiWindowModeChanged(z, true);
                }
            }
        }
    }

    void dispatchPictureInPictureModeChanged(boolean z, boolean z2) {
        if (z2 && (this.mHost instanceof OnPictureInPictureModeChangedProvider)) {
            throwException(new IllegalStateException("Do not call dispatchPictureInPictureModeChanged() on host. Host implements OnPictureInPictureModeChangedProvider and automatically dispatches picture-in-picture mode changes to fragments."));
        }
        for (Fragment fragment : this.mFragmentStore.getAuthRequestContext()) {
            if (fragment != null) {
                fragment.performPictureInPictureModeChanged(z);
                if (z2) {
                    fragment.mChildFragmentManager.dispatchPictureInPictureModeChanged(z, true);
                }
            }
        }
    }

    void dispatchConfigurationChanged(Configuration configuration, boolean z) {
        if (z && (this.mHost instanceof OnConfigurationChangedProvider)) {
            throwException(new IllegalStateException("Do not call dispatchConfigurationChanged() on host. Host implements OnConfigurationChangedProvider and automatically dispatches configuration changes to fragments."));
        }
        for (Fragment fragment : this.mFragmentStore.getAuthRequestContext()) {
            if (fragment != null) {
                fragment.performConfigurationChanged(configuration);
                if (z) {
                    fragment.mChildFragmentManager.dispatchConfigurationChanged(configuration, true);
                }
            }
        }
    }

    void dispatchLowMemory(boolean z) {
        if (z && (this.mHost instanceof OnTrimMemoryProvider)) {
            throwException(new IllegalStateException("Do not call dispatchLowMemory() on host. Host implements OnTrimMemoryProvider and automatically dispatches low memory callbacks to fragments."));
        }
        for (Fragment fragment : this.mFragmentStore.getAuthRequestContext()) {
            if (fragment != null) {
                fragment.performLowMemory();
                if (z) {
                    fragment.mChildFragmentManager.dispatchLowMemory(true);
                }
            }
        }
    }

    public boolean dispatchCreateOptionsMenu(Menu menu, MenuInflater menuInflater) {
        if (this.mCurState <= 0) {
            return false;
        }
        ArrayList<Fragment> arrayList = null;
        boolean z = false;
        for (Fragment fragment : this.mFragmentStore.getAuthRequestContext()) {
            if (fragment != null && isParentMenuVisible(fragment) && fragment.performCreateOptionsMenu(menu, menuInflater)) {
                if (arrayList == null) {
                    arrayList = new ArrayList<>();
                }
                arrayList.add(fragment);
                z = true;
            }
        }
        if (this.mCreatedMenus != null) {
            for (int i = 0; i < this.mCreatedMenus.size(); i++) {
                Fragment fragment2 = this.mCreatedMenus.get(i);
                if (arrayList == null || !arrayList.contains(fragment2)) {
                    fragment2.onDestroyOptionsMenu();
                }
            }
        }
        this.mCreatedMenus = arrayList;
        return z;
    }

    public boolean dispatchPrepareOptionsMenu(Menu menu) {
        boolean z = false;
        if (this.mCurState <= 0) {
            return false;
        }
        for (Fragment fragment : this.mFragmentStore.getAuthRequestContext()) {
            if (fragment != null && isParentMenuVisible(fragment) && fragment.performPrepareOptionsMenu(menu)) {
                z = true;
            }
        }
        return z;
    }

    public boolean dispatchOptionsItemSelected(MenuItem menuItem) {
        if (this.mCurState <= 0) {
            return false;
        }
        for (Fragment fragment : this.mFragmentStore.getAuthRequestContext()) {
            if (fragment != null && fragment.performOptionsItemSelected(menuItem)) {
                return true;
            }
        }
        return false;
    }

    public boolean dispatchContextItemSelected(MenuItem menuItem) {
        if (this.mCurState <= 0) {
            return false;
        }
        for (Fragment fragment : this.mFragmentStore.getAuthRequestContext()) {
            if (fragment != null && fragment.performContextItemSelected(menuItem)) {
                return true;
            }
        }
        return false;
    }

    public void dispatchOptionsMenuClosed(Menu menu) {
        if (this.mCurState <= 0) {
            return;
        }
        for (Fragment fragment : this.mFragmentStore.getAuthRequestContext()) {
            if (fragment != null) {
                fragment.performOptionsMenuClosed(menu);
            }
        }
    }

    void setPrimaryNavigationFragment(Fragment fragment) {
        if (fragment != null && (!fragment.equals(findActiveFragment(fragment.mWho)) || (fragment.mHost != null && fragment.mFragmentManager != this))) {
            StringBuilder sb = new StringBuilder();
            sb.append("Fragment ");
            sb.append(fragment);
            sb.append(" is not an active fragment of FragmentManager ");
            sb.append(this);
            throw new IllegalArgumentException(sb.toString());
        }
        Fragment fragment2 = this.mPrimaryNav;
        this.mPrimaryNav = fragment;
        dispatchParentPrimaryNavigationFragmentChanged(fragment2);
        dispatchParentPrimaryNavigationFragmentChanged(this.mPrimaryNav);
    }

    private void dispatchParentPrimaryNavigationFragmentChanged(Fragment fragment) {
        if (fragment == null || !fragment.equals(findActiveFragment(fragment.mWho))) {
            return;
        }
        fragment.performPrimaryNavigationFragmentChanged();
    }

    public void dispatchPrimaryNavigationFragmentChanged() {
        updateOnBackPressedCallbackEnabled();
        dispatchParentPrimaryNavigationFragmentChanged(this.mPrimaryNav);
    }

    public Fragment getPrimaryNavigationFragment() {
        return this.mPrimaryNav;
    }

    void setMaxLifecycle(Fragment fragment, Lifecycle.State state) {
        if (!fragment.equals(findActiveFragment(fragment.mWho)) || (fragment.mHost != null && fragment.mFragmentManager != this)) {
            StringBuilder sb = new StringBuilder();
            sb.append("Fragment ");
            sb.append(fragment);
            sb.append(" is not an active fragment of FragmentManager ");
            sb.append(this);
            throw new IllegalArgumentException(sb.toString());
        }
        fragment.mMaxState = state;
    }

    public void setFragmentFactory(FragmentFactory fragmentFactory) {
        this.mFragmentFactory = fragmentFactory;
    }

    public FragmentFactory getFragmentFactory() {
        FragmentFactory fragmentFactory = this.mFragmentFactory;
        if (fragmentFactory != null) {
            return fragmentFactory;
        }
        Fragment fragment = this.mParent;
        if (fragment != null) {
            return fragment.mFragmentManager.getFragmentFactory();
        }
        return this.mHostFragmentFactory;
    }

    void setSpecialEffectsControllerFactory(SpecialEffectsControllerFactory specialEffectsControllerFactory) {
        this.mSpecialEffectsControllerFactory = specialEffectsControllerFactory;
    }

    public SpecialEffectsControllerFactory getSpecialEffectsControllerFactory() {
        SpecialEffectsControllerFactory specialEffectsControllerFactory = this.mSpecialEffectsControllerFactory;
        if (specialEffectsControllerFactory != null) {
            return specialEffectsControllerFactory;
        }
        Fragment fragment = this.mParent;
        if (fragment != null) {
            return fragment.mFragmentManager.getSpecialEffectsControllerFactory();
        }
        return this.mDefaultSpecialEffectsControllerFactory;
    }

    public FragmentLifecycleCallbacksDispatcher getLifecycleCallbacksDispatcher() {
        return this.mLifecycleCallbacksDispatcher;
    }

    public void registerFragmentLifecycleCallbacks(FragmentLifecycleCallbacks fragmentLifecycleCallbacks, boolean z) {
        this.mLifecycleCallbacksDispatcher.MyBillsEntityDataFactory.add(new FragmentLifecycleCallbacksDispatcher.FragmentLifecycleCallbacksHolder(fragmentLifecycleCallbacks, z));
    }

    /* JADX WARN: Code restructure failed: missing block: B:52:0x001a, code lost:
    
        r0.MyBillsEntityDataFactory.remove(r3);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void unregisterFragmentLifecycleCallbacks(androidx.fragment.app.FragmentManager.FragmentLifecycleCallbacks r6) {
        /*
            r5 = this;
            androidx.fragment.app.FragmentLifecycleCallbacksDispatcher r0 = r5.mLifecycleCallbacksDispatcher
            java.util.concurrent.CopyOnWriteArrayList<androidx.fragment.app.FragmentLifecycleCallbacksDispatcher$FragmentLifecycleCallbacksHolder> r1 = r0.MyBillsEntityDataFactory
            monitor-enter(r1)
            java.util.concurrent.CopyOnWriteArrayList<androidx.fragment.app.FragmentLifecycleCallbacksDispatcher$FragmentLifecycleCallbacksHolder> r2 = r0.MyBillsEntityDataFactory     // Catch: java.lang.Throwable -> L25
            int r2 = r2.size()     // Catch: java.lang.Throwable -> L25
            r3 = 0
        Lc:
            if (r3 >= r2) goto L23
            java.util.concurrent.CopyOnWriteArrayList<androidx.fragment.app.FragmentLifecycleCallbacksDispatcher$FragmentLifecycleCallbacksHolder> r4 = r0.MyBillsEntityDataFactory     // Catch: java.lang.Throwable -> L25
            java.lang.Object r4 = r4.get(r3)     // Catch: java.lang.Throwable -> L25
            androidx.fragment.app.FragmentLifecycleCallbacksDispatcher$FragmentLifecycleCallbacksHolder r4 = (androidx.fragment.app.FragmentLifecycleCallbacksDispatcher.FragmentLifecycleCallbacksHolder) r4     // Catch: java.lang.Throwable -> L25
            androidx.fragment.app.FragmentManager$FragmentLifecycleCallbacks r4 = r4.MyBillsEntityDataFactory     // Catch: java.lang.Throwable -> L25
            if (r4 != r6) goto L20
            java.util.concurrent.CopyOnWriteArrayList<androidx.fragment.app.FragmentLifecycleCallbacksDispatcher$FragmentLifecycleCallbacksHolder> r6 = r0.MyBillsEntityDataFactory     // Catch: java.lang.Throwable -> L25
            r6.remove(r3)     // Catch: java.lang.Throwable -> L25
            goto L23
        L20:
            int r3 = r3 + 1
            goto Lc
        L23:
            monitor-exit(r1)
            return
        L25:
            r6 = move-exception
            monitor-exit(r1)
            goto L29
        L28:
            throw r6
        L29:
            goto L28
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.fragment.app.FragmentManager.unregisterFragmentLifecycleCallbacks(androidx.fragment.app.FragmentManager$FragmentLifecycleCallbacks):void");
    }

    public void addFragmentOnAttachListener(FragmentOnAttachListener fragmentOnAttachListener) {
        this.mOnAttachListeners.add(fragmentOnAttachListener);
    }

    public void dispatchOnAttachFragment(Fragment fragment) {
        Iterator<FragmentOnAttachListener> it = this.mOnAttachListeners.iterator();
        while (it.hasNext()) {
            it.next().KClassImpl$Data$declaredNonStaticMembers$2(this, fragment);
        }
    }

    public void removeFragmentOnAttachListener(FragmentOnAttachListener fragmentOnAttachListener) {
        this.mOnAttachListeners.remove(fragmentOnAttachListener);
    }

    public void dispatchOnHiddenChanged() {
        for (Fragment fragment : this.mFragmentStore.PlaceComponentResult()) {
            if (fragment != null) {
                fragment.onHiddenChanged(fragment.isHidden());
                fragment.mChildFragmentManager.dispatchOnHiddenChanged();
            }
        }
    }

    boolean checkForMenus() {
        boolean z = false;
        for (Fragment fragment : this.mFragmentStore.PlaceComponentResult()) {
            if (fragment != null) {
                z = isMenuAvailable(fragment);
            }
            if (z) {
                return true;
            }
        }
        return false;
    }

    private boolean isMenuAvailable(Fragment fragment) {
        return (fragment.mHasMenu && fragment.mMenuVisible) || fragment.mChildFragmentManager.checkForMenus();
    }

    public void invalidateMenuForFragment(Fragment fragment) {
        if (fragment.mAdded && isMenuAvailable(fragment)) {
            this.mNeedMenuInvalidate = true;
        }
    }

    private boolean isParentAdded() {
        Fragment fragment = this.mParent;
        if (fragment == null) {
            return true;
        }
        return fragment.isAdded() && this.mParent.getParentFragmentManager().isParentAdded();
    }

    public LayoutInflater.Factory2 getLayoutInflaterFactory() {
        return this.mLayoutInflaterFactory;
    }

    public FragmentStrictMode.Policy getStrictModePolicy() {
        return this.mStrictModePolicy;
    }

    public void setStrictModePolicy(FragmentStrictMode.Policy policy) {
        this.mStrictModePolicy = policy;
    }

    /* loaded from: classes.dex */
    public class PopBackStackState implements OpGenerator {
        final String BuiltInFictitiousFunctionClassFactory;
        final int PlaceComponentResult;
        final int getAuthRequestContext;

        PopBackStackState(String str, int i, int i2) {
            FragmentManager.this = r1;
            this.BuiltInFictitiousFunctionClassFactory = str;
            this.getAuthRequestContext = i;
            this.PlaceComponentResult = i2;
        }

        @Override // androidx.fragment.app.FragmentManager.OpGenerator
        public final boolean MyBillsEntityDataFactory(ArrayList<BackStackRecord> arrayList, ArrayList<Boolean> arrayList2) {
            if (FragmentManager.this.mPrimaryNav == null || this.getAuthRequestContext >= 0 || this.BuiltInFictitiousFunctionClassFactory != null || !FragmentManager.this.mPrimaryNav.getChildFragmentManager().popBackStackImmediate()) {
                return FragmentManager.this.popBackStackState(arrayList, arrayList2, this.BuiltInFictitiousFunctionClassFactory, this.getAuthRequestContext, this.PlaceComponentResult);
            }
            return false;
        }
    }

    /* loaded from: classes.dex */
    public class RestoreBackStackState implements OpGenerator {
        private final String BuiltInFictitiousFunctionClassFactory;

        RestoreBackStackState(String str) {
            FragmentManager.this = r1;
            this.BuiltInFictitiousFunctionClassFactory = str;
        }

        @Override // androidx.fragment.app.FragmentManager.OpGenerator
        public final boolean MyBillsEntityDataFactory(ArrayList<BackStackRecord> arrayList, ArrayList<Boolean> arrayList2) {
            return FragmentManager.this.restoreBackStackState(arrayList, arrayList2, this.BuiltInFictitiousFunctionClassFactory);
        }
    }

    /* loaded from: classes.dex */
    public class SaveBackStackState implements OpGenerator {
        private final String BuiltInFictitiousFunctionClassFactory;

        SaveBackStackState(String str) {
            FragmentManager.this = r1;
            this.BuiltInFictitiousFunctionClassFactory = str;
        }

        @Override // androidx.fragment.app.FragmentManager.OpGenerator
        public final boolean MyBillsEntityDataFactory(ArrayList<BackStackRecord> arrayList, ArrayList<Boolean> arrayList2) {
            return FragmentManager.this.saveBackStackState(arrayList, arrayList2, this.BuiltInFictitiousFunctionClassFactory);
        }
    }

    /* loaded from: classes.dex */
    class ClearBackStackState implements OpGenerator {
        private final String KClassImpl$Data$declaredNonStaticMembers$2;

        ClearBackStackState(String str) {
            FragmentManager.this = r1;
            this.KClassImpl$Data$declaredNonStaticMembers$2 = str;
        }

        @Override // androidx.fragment.app.FragmentManager.OpGenerator
        public final boolean MyBillsEntityDataFactory(ArrayList<BackStackRecord> arrayList, ArrayList<Boolean> arrayList2) {
            return FragmentManager.this.clearBackStackState(arrayList, arrayList2, this.KClassImpl$Data$declaredNonStaticMembers$2);
        }
    }

    /* loaded from: classes.dex */
    public static class LaunchedFragmentInfo implements Parcelable {
        public static final Parcelable.Creator<LaunchedFragmentInfo> CREATOR = new Parcelable.Creator<LaunchedFragmentInfo>() { // from class: androidx.fragment.app.FragmentManager.LaunchedFragmentInfo.1
            @Override // android.os.Parcelable.Creator
            public /* synthetic */ LaunchedFragmentInfo createFromParcel(Parcel parcel) {
                return new LaunchedFragmentInfo(parcel);
            }

            @Override // android.os.Parcelable.Creator
            public /* bridge */ /* synthetic */ LaunchedFragmentInfo[] newArray(int i) {
                return new LaunchedFragmentInfo[i];
            }
        };
        int BuiltInFictitiousFunctionClassFactory;
        String MyBillsEntityDataFactory;

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        LaunchedFragmentInfo(String str, int i) {
            this.MyBillsEntityDataFactory = str;
            this.BuiltInFictitiousFunctionClassFactory = i;
        }

        LaunchedFragmentInfo(Parcel parcel) {
            this.MyBillsEntityDataFactory = parcel.readString();
            this.BuiltInFictitiousFunctionClassFactory = parcel.readInt();
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeString(this.MyBillsEntityDataFactory);
            parcel.writeInt(this.BuiltInFictitiousFunctionClassFactory);
        }
    }

    /* loaded from: classes.dex */
    public static class FragmentIntentSenderContract extends ActivityResultContract<IntentSenderRequest, ActivityResult> {
        FragmentIntentSenderContract() {
        }

        @Override // androidx.view.result.contract.ActivityResultContract
        public /* synthetic */ Intent createIntent(Context context, IntentSenderRequest intentSenderRequest) {
            Bundle bundleExtra;
            IntentSenderRequest intentSenderRequest2 = intentSenderRequest;
            Intent intent = new Intent("androidx.activity.result.contract.action.INTENT_SENDER_REQUEST");
            Intent intent2 = intentSenderRequest2.getAuthRequestContext;
            if (intent2 != null && (bundleExtra = intent2.getBundleExtra("androidx.activity.result.contract.extra.ACTIVITY_OPTIONS_BUNDLE")) != null) {
                intent.putExtra("androidx.activity.result.contract.extra.ACTIVITY_OPTIONS_BUNDLE", bundleExtra);
                intent2.removeExtra("androidx.activity.result.contract.extra.ACTIVITY_OPTIONS_BUNDLE");
                if (intent2.getBooleanExtra(FragmentManager.EXTRA_CREATED_FILLIN_INTENT, false)) {
                    IntentSenderRequest.Builder builder = new IntentSenderRequest.Builder(intentSenderRequest2.BuiltInFictitiousFunctionClassFactory);
                    builder.MyBillsEntityDataFactory = null;
                    int i = intentSenderRequest2.MyBillsEntityDataFactory;
                    int i2 = intentSenderRequest2.PlaceComponentResult;
                    builder.KClassImpl$Data$declaredNonStaticMembers$2 = i;
                    builder.BuiltInFictitiousFunctionClassFactory = i2;
                    intentSenderRequest2 = new IntentSenderRequest(builder.PlaceComponentResult, builder.MyBillsEntityDataFactory, builder.BuiltInFictitiousFunctionClassFactory, builder.KClassImpl$Data$declaredNonStaticMembers$2);
                }
            }
            intent.putExtra("androidx.activity.result.contract.extra.INTENT_SENDER_REQUEST", intentSenderRequest2);
            if (FragmentManager.isLoggingEnabled(2)) {
                StringBuilder sb = new StringBuilder();
                sb.append("CreateIntent created the following intent: ");
                sb.append(intent);
                InstrumentInjector.log_v(FragmentManager.TAG, sb.toString());
            }
            return intent;
        }

        @Override // androidx.view.result.contract.ActivityResultContract
        public /* synthetic */ ActivityResult parseResult(int i, Intent intent) {
            return new ActivityResult(i, intent);
        }
    }

    public void performPendingDeferredStart(FragmentStateManager fragmentStateManager) {
        Fragment fragment = fragmentStateManager.PlaceComponentResult;
        if (fragment.mDeferStart) {
            if (this.mExecutingActions) {
                this.mHavePendingDeferredStart = true;
                return;
            }
            fragment.mDeferStart = false;
            fragmentStateManager.PlaceComponentResult();
        }
    }
}
