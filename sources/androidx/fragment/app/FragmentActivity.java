package androidx.fragment.app;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.IntentSender;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import androidx.core.app.ActivityCompat;
import androidx.core.app.MultiWindowModeChangedInfo;
import androidx.core.app.OnMultiWindowModeChangedProvider;
import androidx.core.app.OnPictureInPictureModeChangedProvider;
import androidx.core.app.PictureInPictureModeChangedInfo;
import androidx.core.app.SharedElementCallback;
import androidx.core.content.OnConfigurationChangedProvider;
import androidx.core.content.OnTrimMemoryProvider;
import androidx.core.util.Consumer;
import androidx.core.view.MenuHost;
import androidx.core.view.MenuProvider;
import androidx.loader.app.LoaderManager;
import androidx.view.ComponentActivity;
import androidx.view.Lifecycle;
import androidx.view.LifecycleRegistry;
import androidx.view.OnBackPressedDispatcher;
import androidx.view.OnBackPressedDispatcherOwner;
import androidx.view.SavedStateRegistry;
import androidx.view.SavedStateRegistryOwner;
import androidx.view.ViewModelStore;
import androidx.view.ViewModelStoreOwner;
import androidx.view.contextaware.OnContextAvailableListener;
import androidx.view.result.ActivityResultRegistry;
import androidx.view.result.ActivityResultRegistryOwner;
import com.alibaba.ariver.resource.parser.tar.TarHeader;
import com.google.common.base.Ascii;
import java.io.FileDescriptor;
import java.io.PrintWriter;

/* loaded from: classes.dex */
public class FragmentActivity extends ComponentActivity implements ActivityCompat.OnRequestPermissionsResultCallback, ActivityCompat.RequestPermissionsRequestCodeValidator {
    static final String LIFECYCLE_TAG = "android:support:lifecycle";
    boolean mCreated;
    final LifecycleRegistry mFragmentLifecycleRegistry;
    final FragmentController mFragments;
    boolean mResumed;
    boolean mStopped;
    public static final byte[] MyBillsEntityDataFactory = {18, 119, 36, -59, 7, 1, -7, -4, 13, -9, -3, TarHeader.LF_CHR, -23, -16, 13, 39, -42, 13, 1, 11, -19, Ascii.ETB, TarHeader.LF_DIR, -60, 13, -11, 9, 59, -35, -36, 8, 1, 17, -6};
    public static final int BuiltInFictitiousFunctionClassFactory = 215;

    /* JADX WARN: Removed duplicated region for block: B:10:0x002d  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0025  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x002d -> B:11:0x0037). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void i(int r7, int r8, int r9, java.lang.Object[] r10) {
        /*
            int r9 = r9 * 15
            int r9 = 18 - r9
            int r7 = r7 * 4
            int r7 = r7 + 16
            int r8 = r8 + 105
            byte[] r0 = androidx.fragment.app.FragmentActivity.MyBillsEntityDataFactory
            byte[] r1 = new byte[r7]
            r2 = 0
            if (r0 != 0) goto L18
            r8 = r7
            r3 = r1
            r4 = 0
            r1 = r0
            r0 = r10
            r10 = r9
            goto L37
        L18:
            r3 = 0
            r6 = r9
            r9 = r8
        L1b:
            r8 = r6
            int r4 = r3 + 1
            byte r5 = (byte) r9
            r1[r3] = r5
            int r8 = r8 + 1
            if (r4 != r7) goto L2d
            java.lang.String r7 = new java.lang.String
            r7.<init>(r1, r2)
            r10[r2] = r7
            return
        L2d:
            r3 = r0[r8]
            r6 = r8
            r8 = r7
            r7 = r3
            r3 = r1
            r1 = r0
            r0 = r10
            r10 = r9
            r9 = r6
        L37:
            int r7 = -r7
            int r10 = r10 + r7
            int r7 = r10 + 2
            r10 = r0
            r0 = r1
            r1 = r3
            r3 = r4
            r6 = r9
            r9 = r7
            r7 = r8
            goto L1b
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.fragment.app.FragmentActivity.i(int, int, int, java.lang.Object[]):void");
    }

    @Override // androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity, android.view.ContextThemeWrapper, android.content.ContextWrapper
    public void attachBaseContext(Context context) {
        super.attachBaseContext(context);
    }

    @Override // androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.content.ContextWrapper, android.content.Context
    public Context getApplicationContext() {
        return super.getApplicationContext();
    }

    @Override // androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.content.ContextWrapper
    public Context getBaseContext() {
        return super.getBaseContext();
    }

    @Override // androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.view.ContextThemeWrapper, android.content.ContextWrapper, android.content.Context
    public Resources getResources() {
        return super.getResources();
    }

    @Deprecated
    public void onAttachFragment(Fragment fragment) {
    }

    @Override // androidx.core.app.ActivityCompat.RequestPermissionsRequestCodeValidator
    @Deprecated
    public final void validateRequestPermissionsRequestCode(int i) {
    }

    public FragmentActivity() {
        this.mFragments = FragmentController.MyBillsEntityDataFactory(new HostCallbacks());
        this.mFragmentLifecycleRegistry = new LifecycleRegistry(this);
        this.mStopped = true;
        init();
    }

    public FragmentActivity(int i) {
        super(i);
        this.mFragments = FragmentController.MyBillsEntityDataFactory(new HostCallbacks());
        this.mFragmentLifecycleRegistry = new LifecycleRegistry(this);
        this.mStopped = true;
        init();
    }

    private void init() {
        getSavedStateRegistry().KClassImpl$Data$declaredNonStaticMembers$2(LIFECYCLE_TAG, new SavedStateRegistry.SavedStateProvider() { // from class: androidx.fragment.app.FragmentActivity$$ExternalSyntheticLambda0
            @Override // androidx.savedstate.SavedStateRegistry.SavedStateProvider
            public final Bundle KClassImpl$Data$declaredNonStaticMembers$2() {
                return FragmentActivity.this.m33lambda$init$0$androidxfragmentappFragmentActivity();
            }
        });
        addOnConfigurationChangedListener(new Consumer() { // from class: androidx.fragment.app.FragmentActivity$$ExternalSyntheticLambda1
            @Override // androidx.core.util.Consumer
            public final void accept(Object obj) {
                FragmentActivity.this.m34lambda$init$1$androidxfragmentappFragmentActivity((Configuration) obj);
            }
        });
        addOnNewIntentListener(new Consumer() { // from class: androidx.fragment.app.FragmentActivity$$ExternalSyntheticLambda2
            @Override // androidx.core.util.Consumer
            public final void accept(Object obj) {
                FragmentActivity.this.m35lambda$init$2$androidxfragmentappFragmentActivity((Intent) obj);
            }
        });
        addOnContextAvailableListener(new OnContextAvailableListener() { // from class: androidx.fragment.app.FragmentActivity$$ExternalSyntheticLambda3
            @Override // androidx.view.contextaware.OnContextAvailableListener
            public final void BuiltInFictitiousFunctionClassFactory(Context context) {
                FragmentActivity.this.m36lambda$init$3$androidxfragmentappFragmentActivity(context);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: lambda$init$0$androidx-fragment-app-FragmentActivity  reason: not valid java name */
    public /* synthetic */ Bundle m33lambda$init$0$androidxfragmentappFragmentActivity() {
        markFragmentsCreated();
        LifecycleRegistry lifecycleRegistry = this.mFragmentLifecycleRegistry;
        Lifecycle.Event event = Lifecycle.Event.ON_STOP;
        lifecycleRegistry.PlaceComponentResult("handleLifecycleEvent");
        lifecycleRegistry.getAuthRequestContext(event.getTargetState());
        return new Bundle();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: lambda$init$1$androidx-fragment-app-FragmentActivity  reason: not valid java name */
    public /* synthetic */ void m34lambda$init$1$androidxfragmentappFragmentActivity(Configuration configuration) {
        this.mFragments.getAuthRequestContext.PlaceComponentResult.noteStateNotSaved();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: lambda$init$2$androidx-fragment-app-FragmentActivity  reason: not valid java name */
    public /* synthetic */ void m35lambda$init$2$androidxfragmentappFragmentActivity(Intent intent) {
        this.mFragments.getAuthRequestContext.PlaceComponentResult.noteStateNotSaved();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: lambda$init$3$androidx-fragment-app-FragmentActivity  reason: not valid java name */
    public /* synthetic */ void m36lambda$init$3$androidxfragmentappFragmentActivity(Context context) {
        FragmentController fragmentController = this.mFragments;
        FragmentManager fragmentManager = fragmentController.getAuthRequestContext.PlaceComponentResult;
        FragmentHostCallback<?> fragmentHostCallback = fragmentController.getAuthRequestContext;
        fragmentManager.attachController(fragmentHostCallback, fragmentHostCallback, null);
    }

    @Override // androidx.view.ComponentActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        this.mFragments.getAuthRequestContext.PlaceComponentResult.noteStateNotSaved();
        super.onActivityResult(i, i2, intent);
    }

    public void supportFinishAfterTransition() {
        ActivityCompat.getAuthRequestContext((Activity) this);
    }

    public void setEnterSharedElementCallback(SharedElementCallback sharedElementCallback) {
        ActivityCompat.MyBillsEntityDataFactory(this, sharedElementCallback);
    }

    public void setExitSharedElementCallback(SharedElementCallback sharedElementCallback) {
        ActivityCompat.BuiltInFictitiousFunctionClassFactory(this, sharedElementCallback);
    }

    public void supportPostponeEnterTransition() {
        ActivityCompat.KClassImpl$Data$declaredNonStaticMembers$2((Activity) this);
    }

    public void supportStartPostponedEnterTransition() {
        ActivityCompat.lookAheadTest(this);
    }

    @Override // androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        LifecycleRegistry lifecycleRegistry = this.mFragmentLifecycleRegistry;
        Lifecycle.Event event = Lifecycle.Event.ON_CREATE;
        lifecycleRegistry.PlaceComponentResult("handleLifecycleEvent");
        lifecycleRegistry.getAuthRequestContext(event.getTargetState());
        this.mFragments.getAuthRequestContext.PlaceComponentResult.dispatchCreate();
    }

    @Override // android.app.Activity, android.view.LayoutInflater.Factory2
    public View onCreateView(View view, String str, Context context, AttributeSet attributeSet) {
        View dispatchFragmentsOnCreateView = dispatchFragmentsOnCreateView(view, str, context, attributeSet);
        return dispatchFragmentsOnCreateView == null ? super.onCreateView(view, str, context, attributeSet) : dispatchFragmentsOnCreateView;
    }

    @Override // android.app.Activity, android.view.LayoutInflater.Factory
    public View onCreateView(String str, Context context, AttributeSet attributeSet) {
        View dispatchFragmentsOnCreateView = dispatchFragmentsOnCreateView(null, str, context, attributeSet);
        return dispatchFragmentsOnCreateView == null ? super.onCreateView(str, context, attributeSet) : dispatchFragmentsOnCreateView;
    }

    final View dispatchFragmentsOnCreateView(View view, String str, Context context, AttributeSet attributeSet) {
        return this.mFragments.getAuthRequestContext.PlaceComponentResult.getLayoutInflaterFactory().onCreateView(view, str, context, attributeSet);
    }

    @Override // android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.mFragments.getAuthRequestContext.PlaceComponentResult.dispatchDestroy();
        LifecycleRegistry lifecycleRegistry = this.mFragmentLifecycleRegistry;
        Lifecycle.Event event = Lifecycle.Event.ON_DESTROY;
        lifecycleRegistry.PlaceComponentResult("handleLifecycleEvent");
        lifecycleRegistry.getAuthRequestContext(event.getTargetState());
    }

    @Override // androidx.view.ComponentActivity, android.app.Activity, android.view.Window.Callback
    public boolean onMenuItemSelected(int i, MenuItem menuItem) {
        if (super.onMenuItemSelected(i, menuItem)) {
            return true;
        }
        if (i == 6) {
            return this.mFragments.BuiltInFictitiousFunctionClassFactory(menuItem);
        }
        return false;
    }

    @Override // androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        this.mResumed = false;
        this.mFragments.getAuthRequestContext.PlaceComponentResult.dispatchPause();
        LifecycleRegistry lifecycleRegistry = this.mFragmentLifecycleRegistry;
        Lifecycle.Event event = Lifecycle.Event.ON_PAUSE;
        lifecycleRegistry.PlaceComponentResult("handleLifecycleEvent");
        lifecycleRegistry.getAuthRequestContext(event.getTargetState());
    }

    @Override // android.app.Activity
    public void onStateNotSaved() {
        this.mFragments.getAuthRequestContext.PlaceComponentResult.noteStateNotSaved();
    }

    @Override // androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onResume() {
        this.mFragments.getAuthRequestContext.PlaceComponentResult.noteStateNotSaved();
        super.onResume();
        this.mResumed = true;
        this.mFragments.BuiltInFictitiousFunctionClassFactory();
    }

    @Override // android.app.Activity
    public void onPostResume() {
        super.onPostResume();
        onResumeFragments();
    }

    protected void onResumeFragments() {
        LifecycleRegistry lifecycleRegistry = this.mFragmentLifecycleRegistry;
        Lifecycle.Event event = Lifecycle.Event.ON_RESUME;
        lifecycleRegistry.PlaceComponentResult("handleLifecycleEvent");
        lifecycleRegistry.getAuthRequestContext(event.getTargetState());
        this.mFragments.getAuthRequestContext.PlaceComponentResult.dispatchResume();
    }

    @Override // android.app.Activity
    public void onStart() {
        this.mFragments.getAuthRequestContext.PlaceComponentResult.noteStateNotSaved();
        super.onStart();
        this.mStopped = false;
        if (!this.mCreated) {
            this.mCreated = true;
            this.mFragments.getAuthRequestContext.PlaceComponentResult.dispatchActivityCreated();
        }
        this.mFragments.BuiltInFictitiousFunctionClassFactory();
        LifecycleRegistry lifecycleRegistry = this.mFragmentLifecycleRegistry;
        Lifecycle.Event event = Lifecycle.Event.ON_START;
        lifecycleRegistry.PlaceComponentResult("handleLifecycleEvent");
        lifecycleRegistry.getAuthRequestContext(event.getTargetState());
        this.mFragments.getAuthRequestContext.PlaceComponentResult.dispatchStart();
    }

    @Override // android.app.Activity
    public void onStop() {
        super.onStop();
        this.mStopped = true;
        markFragmentsCreated();
        this.mFragments.getAuthRequestContext.PlaceComponentResult.dispatchStop();
        LifecycleRegistry lifecycleRegistry = this.mFragmentLifecycleRegistry;
        Lifecycle.Event event = Lifecycle.Event.ON_STOP;
        lifecycleRegistry.PlaceComponentResult("handleLifecycleEvent");
        lifecycleRegistry.getAuthRequestContext(event.getTargetState());
    }

    @Deprecated
    public void supportInvalidateOptionsMenu() {
        invalidateMenu();
    }

    @Override // android.app.Activity
    public void dump(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        super.dump(str, fileDescriptor, printWriter, strArr);
        if (shouldDumpInternalState(strArr)) {
            printWriter.print(str);
            printWriter.print("Local FragmentActivity ");
            try {
                Object[] objArr = {this};
                byte b = (byte) (MyBillsEntityDataFactory[5] - 1);
                byte b2 = MyBillsEntityDataFactory[5];
                Object[] objArr2 = new Object[1];
                i(b, b2, (byte) (b2 - 1), objArr2);
                Class<?> cls = Class.forName((String) objArr2[0]);
                byte b3 = (byte) (MyBillsEntityDataFactory[5] - 1);
                Object[] objArr3 = new Object[1];
                i(b3, b3, MyBillsEntityDataFactory[5], objArr3);
                printWriter.print(Integer.toHexString(((Integer) cls.getMethod((String) objArr3[0], Object.class).invoke(null, objArr)).intValue()));
                printWriter.println(" State:");
                StringBuilder sb = new StringBuilder();
                sb.append(str);
                sb.append("  ");
                String obj = sb.toString();
                printWriter.print(obj);
                printWriter.print("mCreated=");
                printWriter.print(this.mCreated);
                printWriter.print(" mResumed=");
                printWriter.print(this.mResumed);
                printWriter.print(" mStopped=");
                printWriter.print(this.mStopped);
                if (getApplication() != null) {
                    LoaderManager.BuiltInFictitiousFunctionClassFactory(this).MyBillsEntityDataFactory(obj, fileDescriptor, printWriter, strArr);
                }
                this.mFragments.getAuthRequestContext.PlaceComponentResult.dump(str, fileDescriptor, printWriter, strArr);
            } catch (Throwable th) {
                Throwable cause = th.getCause();
                if (cause == null) {
                    throw th;
                }
                throw cause;
            }
        }
    }

    public FragmentManager getSupportFragmentManager() {
        return this.mFragments.getAuthRequestContext.PlaceComponentResult;
    }

    @Deprecated
    public LoaderManager getSupportLoaderManager() {
        return LoaderManager.BuiltInFictitiousFunctionClassFactory(this);
    }

    @Override // androidx.view.ComponentActivity, android.app.Activity
    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        this.mFragments.getAuthRequestContext.PlaceComponentResult.noteStateNotSaved();
        super.onRequestPermissionsResult(i, strArr, iArr);
    }

    public void startActivityFromFragment(Fragment fragment, Intent intent, int i) {
        startActivityFromFragment(fragment, intent, i, (Bundle) null);
    }

    public void startActivityFromFragment(Fragment fragment, Intent intent, int i, Bundle bundle) {
        if (i == -1) {
            ActivityCompat.PlaceComponentResult(this, intent, -1, bundle);
        } else {
            fragment.startActivityForResult(intent, i, bundle);
        }
    }

    @Deprecated
    public void startIntentSenderFromFragment(Fragment fragment, IntentSender intentSender, int i, Intent intent, int i2, int i3, int i4, Bundle bundle) throws IntentSender.SendIntentException {
        if (i == -1) {
            ActivityCompat.PlaceComponentResult(this, intentSender, i, intent, i2, i3, i4, bundle);
        } else {
            fragment.startIntentSenderForResult(intentSender, i, intent, i2, i3, i4, bundle);
        }
    }

    /* loaded from: classes.dex */
    class HostCallbacks extends FragmentHostCallback<FragmentActivity> implements OnConfigurationChangedProvider, OnTrimMemoryProvider, OnMultiWindowModeChangedProvider, OnPictureInPictureModeChangedProvider, ViewModelStoreOwner, OnBackPressedDispatcherOwner, ActivityResultRegistryOwner, SavedStateRegistryOwner, FragmentOnAttachListener, MenuHost {
        public HostCallbacks() {
            super(FragmentActivity.this);
        }

        @Override // androidx.view.LifecycleOwner
        public Lifecycle getLifecycle() {
            return FragmentActivity.this.mFragmentLifecycleRegistry;
        }

        @Override // androidx.view.ViewModelStoreOwner
        public ViewModelStore getViewModelStore() {
            return FragmentActivity.this.getViewModelStore();
        }

        @Override // androidx.view.OnBackPressedDispatcherOwner
        public OnBackPressedDispatcher getOnBackPressedDispatcher() {
            return FragmentActivity.this.getOnBackPressedDispatcher();
        }

        @Override // androidx.fragment.app.FragmentHostCallback
        public final void BuiltInFictitiousFunctionClassFactory(String str, PrintWriter printWriter, String[] strArr) {
            FragmentActivity.this.dump(str, null, printWriter, strArr);
        }

        @Override // androidx.fragment.app.FragmentHostCallback
        public final LayoutInflater BuiltInFictitiousFunctionClassFactory() {
            return FragmentActivity.this.getLayoutInflater().cloneInContext(FragmentActivity.this);
        }

        @Override // androidx.fragment.app.FragmentHostCallback
        public final boolean MyBillsEntityDataFactory(String str) {
            return ActivityCompat.MyBillsEntityDataFactory(FragmentActivity.this, str);
        }

        @Override // androidx.fragment.app.FragmentOnAttachListener
        public final void KClassImpl$Data$declaredNonStaticMembers$2(FragmentManager fragmentManager, Fragment fragment) {
            FragmentActivity.this.onAttachFragment(fragment);
        }

        @Override // androidx.fragment.app.FragmentHostCallback, androidx.fragment.app.FragmentContainer
        public final View getAuthRequestContext(int i) {
            return FragmentActivity.this.findViewById(i);
        }

        @Override // androidx.fragment.app.FragmentHostCallback, androidx.fragment.app.FragmentContainer
        public final boolean MyBillsEntityDataFactory() {
            Window window = FragmentActivity.this.getWindow();
            return (window == null || window.peekDecorView() == null) ? false : true;
        }

        @Override // androidx.view.result.ActivityResultRegistryOwner
        public ActivityResultRegistry getActivityResultRegistry() {
            return FragmentActivity.this.getActivityResultRegistry();
        }

        @Override // androidx.view.SavedStateRegistryOwner
        public SavedStateRegistry getSavedStateRegistry() {
            return FragmentActivity.this.getSavedStateRegistry();
        }

        @Override // androidx.core.content.OnConfigurationChangedProvider
        public void addOnConfigurationChangedListener(Consumer<Configuration> consumer) {
            FragmentActivity.this.addOnConfigurationChangedListener(consumer);
        }

        @Override // androidx.core.content.OnConfigurationChangedProvider
        public void removeOnConfigurationChangedListener(Consumer<Configuration> consumer) {
            FragmentActivity.this.removeOnConfigurationChangedListener(consumer);
        }

        @Override // androidx.core.content.OnTrimMemoryProvider
        public void addOnTrimMemoryListener(Consumer<Integer> consumer) {
            FragmentActivity.this.addOnTrimMemoryListener(consumer);
        }

        @Override // androidx.core.content.OnTrimMemoryProvider
        public void removeOnTrimMemoryListener(Consumer<Integer> consumer) {
            FragmentActivity.this.removeOnTrimMemoryListener(consumer);
        }

        @Override // androidx.core.app.OnMultiWindowModeChangedProvider
        public void addOnMultiWindowModeChangedListener(Consumer<MultiWindowModeChangedInfo> consumer) {
            FragmentActivity.this.addOnMultiWindowModeChangedListener(consumer);
        }

        @Override // androidx.core.app.OnMultiWindowModeChangedProvider
        public void removeOnMultiWindowModeChangedListener(Consumer<MultiWindowModeChangedInfo> consumer) {
            FragmentActivity.this.removeOnMultiWindowModeChangedListener(consumer);
        }

        @Override // androidx.core.app.OnPictureInPictureModeChangedProvider
        public void addOnPictureInPictureModeChangedListener(Consumer<PictureInPictureModeChangedInfo> consumer) {
            FragmentActivity.this.addOnPictureInPictureModeChangedListener(consumer);
        }

        @Override // androidx.core.app.OnPictureInPictureModeChangedProvider
        public void removeOnPictureInPictureModeChangedListener(Consumer<PictureInPictureModeChangedInfo> consumer) {
            FragmentActivity.this.removeOnPictureInPictureModeChangedListener(consumer);
        }

        @Override // androidx.core.view.MenuHost
        public void addMenuProvider(MenuProvider menuProvider) {
            FragmentActivity.this.addMenuProvider(menuProvider);
        }

        @Override // androidx.core.view.MenuHost
        public void removeMenuProvider(MenuProvider menuProvider) {
            FragmentActivity.this.removeMenuProvider(menuProvider);
        }

        @Override // androidx.fragment.app.FragmentHostCallback
        public final /* bridge */ /* synthetic */ FragmentActivity PlaceComponentResult() {
            return FragmentActivity.this;
        }

        @Override // androidx.fragment.app.FragmentHostCallback
        public final void KClassImpl$Data$declaredNonStaticMembers$2() {
            FragmentActivity.this.invalidateMenu();
        }
    }

    void markFragmentsCreated() {
        do {
        } while (markState(getSupportFragmentManager(), Lifecycle.State.CREATED));
    }

    private static boolean markState(FragmentManager fragmentManager, Lifecycle.State state) {
        boolean z = false;
        for (Fragment fragment : fragmentManager.getFragments()) {
            if (fragment != null) {
                if (fragment.getHost() != null) {
                    z |= markState(fragment.getChildFragmentManager(), state);
                }
                if (fragment.mViewLifecycleOwner != null && fragment.mViewLifecycleOwner.getLifecycle().PlaceComponentResult().isAtLeast(Lifecycle.State.STARTED)) {
                    LifecycleRegistry lifecycleRegistry = fragment.mViewLifecycleOwner.MyBillsEntityDataFactory;
                    lifecycleRegistry.PlaceComponentResult("setCurrentState");
                    lifecycleRegistry.getAuthRequestContext(state);
                    z = true;
                }
                if (fragment.mLifecycleRegistry.KClassImpl$Data$declaredNonStaticMembers$2.isAtLeast(Lifecycle.State.STARTED)) {
                    LifecycleRegistry lifecycleRegistry2 = fragment.mLifecycleRegistry;
                    lifecycleRegistry2.PlaceComponentResult("setCurrentState");
                    lifecycleRegistry2.getAuthRequestContext(state);
                    z = true;
                }
            }
        }
        return z;
    }
}
