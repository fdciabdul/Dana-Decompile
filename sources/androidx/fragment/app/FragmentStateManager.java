package androidx.fragment.app;

import android.app.Activity;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.core.view.ViewCompat;
import androidx.fragment.R;
import androidx.fragment.app.SpecialEffectsController;
import androidx.fragment.app.strictmode.FragmentStrictMode;
import androidx.view.Lifecycle;
import androidx.view.LifecycleOwner;
import androidx.view.MutableLiveData;
import androidx.view.SavedStateRegistryController;
import androidx.view.ViewModelStoreOwner;
import com.fullstory.instrumentation.InstrumentInjector;
import java.util.Iterator;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes.dex */
public class FragmentStateManager {
    private final FragmentLifecycleCallbacksDispatcher BuiltInFictitiousFunctionClassFactory;
    final FragmentStore KClassImpl$Data$declaredNonStaticMembers$2;
    final Fragment PlaceComponentResult;
    private boolean getAuthRequestContext = false;
    int MyBillsEntityDataFactory = -1;

    public FragmentStateManager(FragmentLifecycleCallbacksDispatcher fragmentLifecycleCallbacksDispatcher, FragmentStore fragmentStore, Fragment fragment) {
        this.BuiltInFictitiousFunctionClassFactory = fragmentLifecycleCallbacksDispatcher;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = fragmentStore;
        this.PlaceComponentResult = fragment;
    }

    public FragmentStateManager(FragmentLifecycleCallbacksDispatcher fragmentLifecycleCallbacksDispatcher, FragmentStore fragmentStore, ClassLoader classLoader, FragmentFactory fragmentFactory, FragmentState fragmentState) {
        this.BuiltInFictitiousFunctionClassFactory = fragmentLifecycleCallbacksDispatcher;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = fragmentStore;
        Fragment KClassImpl$Data$declaredNonStaticMembers$2 = fragmentState.KClassImpl$Data$declaredNonStaticMembers$2(fragmentFactory, classLoader);
        this.PlaceComponentResult = KClassImpl$Data$declaredNonStaticMembers$2;
        if (FragmentManager.isLoggingEnabled(2)) {
            StringBuilder sb = new StringBuilder();
            sb.append("Instantiated fragment ");
            sb.append(KClassImpl$Data$declaredNonStaticMembers$2);
            InstrumentInjector.log_v(FragmentManager.TAG, sb.toString());
        }
    }

    public FragmentStateManager(FragmentLifecycleCallbacksDispatcher fragmentLifecycleCallbacksDispatcher, FragmentStore fragmentStore, Fragment fragment, FragmentState fragmentState) {
        this.BuiltInFictitiousFunctionClassFactory = fragmentLifecycleCallbacksDispatcher;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = fragmentStore;
        this.PlaceComponentResult = fragment;
        fragment.mSavedViewState = null;
        fragment.mSavedViewRegistryState = null;
        fragment.mBackStackNesting = 0;
        fragment.mInLayout = false;
        fragment.mAdded = false;
        fragment.mTargetWho = fragment.mTarget != null ? fragment.mTarget.mWho : null;
        fragment.mTarget = null;
        if (fragmentState.GetContactSyncConfig != null) {
            fragment.mSavedFragmentState = fragmentState.GetContactSyncConfig;
        } else {
            fragment.mSavedFragmentState = new Bundle();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v27, types: [androidx.fragment.app.SpecialEffectsController$Operation$LifecycleImpact] */
    /* JADX WARN: Type inference failed for: r9v6, types: [androidx.fragment.app.SpecialEffectsController$Operation$LifecycleImpact] */
    private int lookAheadTest() {
        if (this.PlaceComponentResult.mFragmentManager == null) {
            return this.PlaceComponentResult.mState;
        }
        int i = this.MyBillsEntityDataFactory;
        int i2 = AnonymousClass2.getAuthRequestContext[this.PlaceComponentResult.mMaxState.ordinal()];
        if (i2 != 1) {
            if (i2 == 2) {
                i = Math.min(i, 5);
            } else if (i2 == 3) {
                i = Math.min(i, 1);
            } else if (i2 == 4) {
                i = Math.min(i, 0);
            } else {
                i = Math.min(i, -1);
            }
        }
        if (this.PlaceComponentResult.mFromLayout) {
            if (this.PlaceComponentResult.mInLayout) {
                i = Math.max(this.MyBillsEntityDataFactory, 2);
                if (this.PlaceComponentResult.mView != null && this.PlaceComponentResult.mView.getParent() == null) {
                    i = Math.min(i, 2);
                }
            } else {
                i = this.MyBillsEntityDataFactory < 4 ? Math.min(i, this.PlaceComponentResult.mState) : Math.min(i, 1);
            }
        }
        if (!this.PlaceComponentResult.mAdded) {
            i = Math.min(i, 1);
        }
        SpecialEffectsController.Operation operation = null;
        if (this.PlaceComponentResult.mContainer != null) {
            SpecialEffectsController MyBillsEntityDataFactory = SpecialEffectsController.MyBillsEntityDataFactory(this.PlaceComponentResult.mContainer, this.PlaceComponentResult.getParentFragmentManager());
            SpecialEffectsController.Operation authRequestContext = MyBillsEntityDataFactory.getAuthRequestContext(this.PlaceComponentResult);
            SpecialEffectsController.Operation operation2 = authRequestContext != null ? authRequestContext.getAuthRequestContext : null;
            Fragment fragment = this.PlaceComponentResult;
            Iterator<SpecialEffectsController.Operation> it = MyBillsEntityDataFactory.BuiltInFictitiousFunctionClassFactory.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                SpecialEffectsController.Operation next = it.next();
                if (next.MyBillsEntityDataFactory.equals(fragment) && !next.MyBillsEntityDataFactory()) {
                    operation = next;
                    break;
                }
            }
            operation = (operation == null || !(operation2 == null || operation2 == SpecialEffectsController.Operation.LifecycleImpact.NONE)) ? operation2 : operation.getAuthRequestContext;
        }
        if (operation == SpecialEffectsController.Operation.LifecycleImpact.ADDING) {
            i = Math.min(i, 6);
        } else if (operation == SpecialEffectsController.Operation.LifecycleImpact.REMOVING) {
            i = Math.max(i, 3);
        } else if (this.PlaceComponentResult.mRemoving) {
            if (this.PlaceComponentResult.isInBackStack()) {
                i = Math.min(i, 1);
            } else {
                i = Math.min(i, -1);
            }
        }
        if (this.PlaceComponentResult.mDeferStart && this.PlaceComponentResult.mState < 5) {
            i = Math.min(i, 4);
        }
        if (FragmentManager.isLoggingEnabled(2)) {
            StringBuilder sb = new StringBuilder();
            sb.append("computeExpectedState() of ");
            sb.append(i);
            sb.append(" for ");
            sb.append(this.PlaceComponentResult);
            InstrumentInjector.log_v(FragmentManager.TAG, sb.toString());
        }
        return i;
    }

    /* renamed from: androidx.fragment.app.FragmentStateManager$2 */
    /* loaded from: classes.dex */
    public static /* synthetic */ class AnonymousClass2 {
        static final /* synthetic */ int[] getAuthRequestContext;

        static {
            int[] iArr = new int[Lifecycle.State.values().length];
            getAuthRequestContext = iArr;
            try {
                iArr[Lifecycle.State.RESUMED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                getAuthRequestContext[Lifecycle.State.STARTED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                getAuthRequestContext[Lifecycle.State.CREATED.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                getAuthRequestContext[Lifecycle.State.INITIALIZED.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    public final void PlaceComponentResult() {
        if (this.getAuthRequestContext) {
            if (FragmentManager.isLoggingEnabled(2)) {
                StringBuilder sb = new StringBuilder();
                sb.append("Ignoring re-entrant call to moveToExpectedState() for ");
                sb.append(this.PlaceComponentResult);
                InstrumentInjector.log_v(FragmentManager.TAG, sb.toString());
                return;
            }
            return;
        }
        try {
            this.getAuthRequestContext = true;
            boolean z = false;
            while (true) {
                int lookAheadTest = lookAheadTest();
                if (lookAheadTest != this.PlaceComponentResult.mState) {
                    if (lookAheadTest > this.PlaceComponentResult.mState) {
                        switch (this.PlaceComponentResult.mState + 1) {
                            case 0:
                                NetworkUserEntityData$$ExternalSyntheticLambda0();
                                continue;
                            case 1:
                                getErrorConfigVersion();
                                continue;
                            case 2:
                                getAuthRequestContext();
                                scheduleImpl();
                                continue;
                            case 3:
                                KClassImpl$Data$declaredNonStaticMembers$2();
                                continue;
                            case 4:
                                if (this.PlaceComponentResult.mView != null && this.PlaceComponentResult.mContainer != null) {
                                    SpecialEffectsController.MyBillsEntityDataFactory(this.PlaceComponentResult.mContainer, this.PlaceComponentResult.getParentFragmentManager()).PlaceComponentResult(SpecialEffectsController.Operation.State.from(this.PlaceComponentResult.mView.getVisibility()), this);
                                }
                                this.PlaceComponentResult.mState = 4;
                                continue;
                            case 5:
                                NetworkUserEntityData$$ExternalSyntheticLambda8();
                                continue;
                            case 6:
                                this.PlaceComponentResult.mState = 6;
                                continue;
                            case 7:
                                NetworkUserEntityData$$ExternalSyntheticLambda1();
                                continue;
                            default:
                                continue;
                        }
                    } else {
                        switch (this.PlaceComponentResult.mState - 1) {
                            case -1:
                                initRecordTimeStamp();
                                continue;
                            case 0:
                                if (this.PlaceComponentResult.mBeingSaved) {
                                    FragmentStore fragmentStore = this.KClassImpl$Data$declaredNonStaticMembers$2;
                                    if (fragmentStore.MyBillsEntityDataFactory.get(this.PlaceComponentResult.mWho) == null) {
                                        MyBillsEntityDataFactory();
                                    }
                                }
                                moveToNextValue();
                                continue;
                            case 1:
                                NetworkUserEntityData$$ExternalSyntheticLambda2();
                                this.PlaceComponentResult.mState = 1;
                                continue;
                            case 2:
                                this.PlaceComponentResult.mInLayout = false;
                                this.PlaceComponentResult.mState = 2;
                                continue;
                            case 3:
                                if (FragmentManager.isLoggingEnabled(3)) {
                                    StringBuilder sb2 = new StringBuilder();
                                    sb2.append("movefrom ACTIVITY_CREATED: ");
                                    sb2.append(this.PlaceComponentResult);
                                    InstrumentInjector.log_d(FragmentManager.TAG, sb2.toString());
                                }
                                if (this.PlaceComponentResult.mBeingSaved) {
                                    MyBillsEntityDataFactory();
                                } else if (this.PlaceComponentResult.mView != null && this.PlaceComponentResult.mSavedViewState == null) {
                                    GetContactSyncConfig();
                                }
                                if (this.PlaceComponentResult.mView != null && this.PlaceComponentResult.mContainer != null) {
                                    SpecialEffectsController.MyBillsEntityDataFactory(this.PlaceComponentResult.mContainer, this.PlaceComponentResult.getParentFragmentManager()).KClassImpl$Data$declaredNonStaticMembers$2(this);
                                }
                                this.PlaceComponentResult.mState = 3;
                                continue;
                            case 4:
                                PrepareContext();
                                continue;
                            case 5:
                                this.PlaceComponentResult.mState = 5;
                                continue;
                            case 6:
                                DatabaseTableConfigUtil();
                                continue;
                            default:
                                continue;
                        }
                    }
                    z = true;
                } else {
                    if (!z && this.PlaceComponentResult.mState == -1 && this.PlaceComponentResult.mRemoving && !this.PlaceComponentResult.isInBackStack() && !this.PlaceComponentResult.mBeingSaved) {
                        if (FragmentManager.isLoggingEnabled(3)) {
                            StringBuilder sb3 = new StringBuilder();
                            sb3.append("Cleaning up state of never attached fragment: ");
                            sb3.append(this.PlaceComponentResult);
                            InstrumentInjector.log_d(FragmentManager.TAG, sb3.toString());
                        }
                        this.KClassImpl$Data$declaredNonStaticMembers$2.BuiltInFictitiousFunctionClassFactory.PlaceComponentResult(this.PlaceComponentResult);
                        this.KClassImpl$Data$declaredNonStaticMembers$2.MyBillsEntityDataFactory(this);
                        if (FragmentManager.isLoggingEnabled(3)) {
                            StringBuilder sb4 = new StringBuilder();
                            sb4.append("initState called for fragment: ");
                            sb4.append(this.PlaceComponentResult);
                            InstrumentInjector.log_d(FragmentManager.TAG, sb4.toString());
                        }
                        this.PlaceComponentResult.initState();
                    }
                    if (this.PlaceComponentResult.mHiddenChanged) {
                        if (this.PlaceComponentResult.mView != null && this.PlaceComponentResult.mContainer != null) {
                            SpecialEffectsController MyBillsEntityDataFactory = SpecialEffectsController.MyBillsEntityDataFactory(this.PlaceComponentResult.mContainer, this.PlaceComponentResult.getParentFragmentManager());
                            if (this.PlaceComponentResult.mHidden) {
                                MyBillsEntityDataFactory.getAuthRequestContext(this);
                            } else {
                                MyBillsEntityDataFactory.BuiltInFictitiousFunctionClassFactory(this);
                            }
                        }
                        if (this.PlaceComponentResult.mFragmentManager != null) {
                            this.PlaceComponentResult.mFragmentManager.invalidateMenuForFragment(this.PlaceComponentResult);
                        }
                        this.PlaceComponentResult.mHiddenChanged = false;
                        Fragment fragment = this.PlaceComponentResult;
                        fragment.onHiddenChanged(fragment.mHidden);
                        this.PlaceComponentResult.mChildFragmentManager.dispatchOnHiddenChanged();
                    }
                    return;
                }
            }
        } finally {
            this.getAuthRequestContext = false;
        }
    }

    public final void getAuthRequestContext() {
        if (this.PlaceComponentResult.mFromLayout && this.PlaceComponentResult.mInLayout && !this.PlaceComponentResult.mPerformedCreateView) {
            if (FragmentManager.isLoggingEnabled(3)) {
                StringBuilder sb = new StringBuilder();
                sb.append("moveto CREATE_VIEW: ");
                sb.append(this.PlaceComponentResult);
                InstrumentInjector.log_d(FragmentManager.TAG, sb.toString());
            }
            Fragment fragment = this.PlaceComponentResult;
            fragment.performCreateView(fragment.performGetLayoutInflater(fragment.mSavedFragmentState), null, this.PlaceComponentResult.mSavedFragmentState);
            if (this.PlaceComponentResult.mView != null) {
                this.PlaceComponentResult.mView.setSaveFromParentEnabled(false);
                this.PlaceComponentResult.mView.setTag(R.id.KClassImpl$Data$declaredNonStaticMembers$2, this.PlaceComponentResult);
                if (this.PlaceComponentResult.mHidden) {
                    this.PlaceComponentResult.mView.setVisibility(8);
                }
                this.PlaceComponentResult.performViewCreated();
                FragmentLifecycleCallbacksDispatcher fragmentLifecycleCallbacksDispatcher = this.BuiltInFictitiousFunctionClassFactory;
                Fragment fragment2 = this.PlaceComponentResult;
                fragmentLifecycleCallbacksDispatcher.getAuthRequestContext(fragment2, fragment2.mView, this.PlaceComponentResult.mSavedFragmentState, false);
                this.PlaceComponentResult.mState = 2;
            }
        }
    }

    public final void BuiltInFictitiousFunctionClassFactory(ClassLoader classLoader) {
        if (this.PlaceComponentResult.mSavedFragmentState == null) {
            return;
        }
        this.PlaceComponentResult.mSavedFragmentState.setClassLoader(classLoader);
        Fragment fragment = this.PlaceComponentResult;
        fragment.mSavedViewState = fragment.mSavedFragmentState.getSparseParcelableArray("android:view_state");
        Fragment fragment2 = this.PlaceComponentResult;
        fragment2.mSavedViewRegistryState = fragment2.mSavedFragmentState.getBundle("android:view_registry_state");
        Fragment fragment3 = this.PlaceComponentResult;
        fragment3.mTargetWho = fragment3.mSavedFragmentState.getString("android:target_state");
        if (this.PlaceComponentResult.mTargetWho != null) {
            Fragment fragment4 = this.PlaceComponentResult;
            fragment4.mTargetRequestCode = fragment4.mSavedFragmentState.getInt("android:target_req_state", 0);
        }
        if (this.PlaceComponentResult.mSavedUserVisibleHint != null) {
            Fragment fragment5 = this.PlaceComponentResult;
            fragment5.mUserVisibleHint = fragment5.mSavedUserVisibleHint.booleanValue();
            this.PlaceComponentResult.mSavedUserVisibleHint = null;
        } else {
            Fragment fragment6 = this.PlaceComponentResult;
            fragment6.mUserVisibleHint = fragment6.mSavedFragmentState.getBoolean("android:user_visible_hint", true);
        }
        if (this.PlaceComponentResult.mUserVisibleHint) {
            return;
        }
        this.PlaceComponentResult.mDeferStart = true;
    }

    private void NetworkUserEntityData$$ExternalSyntheticLambda0() {
        if (FragmentManager.isLoggingEnabled(3)) {
            StringBuilder sb = new StringBuilder();
            sb.append("moveto ATTACHED: ");
            sb.append(this.PlaceComponentResult);
            InstrumentInjector.log_d(FragmentManager.TAG, sb.toString());
        }
        FragmentStateManager fragmentStateManager = null;
        if (this.PlaceComponentResult.mTarget != null) {
            FragmentStore fragmentStore = this.KClassImpl$Data$declaredNonStaticMembers$2;
            FragmentStateManager fragmentStateManager2 = fragmentStore.KClassImpl$Data$declaredNonStaticMembers$2.get(this.PlaceComponentResult.mTarget.mWho);
            if (fragmentStateManager2 == null) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("Fragment ");
                sb2.append(this.PlaceComponentResult);
                sb2.append(" declared target fragment ");
                sb2.append(this.PlaceComponentResult.mTarget);
                sb2.append(" that does not belong to this FragmentManager!");
                throw new IllegalStateException(sb2.toString());
            }
            Fragment fragment = this.PlaceComponentResult;
            fragment.mTargetWho = fragment.mTarget.mWho;
            this.PlaceComponentResult.mTarget = null;
            fragmentStateManager = fragmentStateManager2;
        } else if (this.PlaceComponentResult.mTargetWho != null) {
            FragmentStore fragmentStore2 = this.KClassImpl$Data$declaredNonStaticMembers$2;
            fragmentStateManager = fragmentStore2.KClassImpl$Data$declaredNonStaticMembers$2.get(this.PlaceComponentResult.mTargetWho);
            if (fragmentStateManager == null) {
                StringBuilder sb3 = new StringBuilder();
                sb3.append("Fragment ");
                sb3.append(this.PlaceComponentResult);
                sb3.append(" declared target fragment ");
                sb3.append(this.PlaceComponentResult.mTargetWho);
                sb3.append(" that does not belong to this FragmentManager!");
                throw new IllegalStateException(sb3.toString());
            }
        }
        if (fragmentStateManager != null) {
            fragmentStateManager.PlaceComponentResult();
        }
        Fragment fragment2 = this.PlaceComponentResult;
        fragment2.mHost = fragment2.mFragmentManager.getHost();
        Fragment fragment3 = this.PlaceComponentResult;
        fragment3.mParentFragment = fragment3.mFragmentManager.getParent();
        this.BuiltInFictitiousFunctionClassFactory.getAuthRequestContext(this.PlaceComponentResult, false);
        this.PlaceComponentResult.performAttach();
        this.BuiltInFictitiousFunctionClassFactory.MyBillsEntityDataFactory(this.PlaceComponentResult, false);
    }

    private void getErrorConfigVersion() {
        if (FragmentManager.isLoggingEnabled(3)) {
            StringBuilder sb = new StringBuilder();
            sb.append("moveto CREATED: ");
            sb.append(this.PlaceComponentResult);
            InstrumentInjector.log_d(FragmentManager.TAG, sb.toString());
        }
        if (!this.PlaceComponentResult.mIsCreated) {
            FragmentLifecycleCallbacksDispatcher fragmentLifecycleCallbacksDispatcher = this.BuiltInFictitiousFunctionClassFactory;
            Fragment fragment = this.PlaceComponentResult;
            fragmentLifecycleCallbacksDispatcher.KClassImpl$Data$declaredNonStaticMembers$2(fragment, fragment.mSavedFragmentState, false);
            Fragment fragment2 = this.PlaceComponentResult;
            fragment2.performCreate(fragment2.mSavedFragmentState);
            FragmentLifecycleCallbacksDispatcher fragmentLifecycleCallbacksDispatcher2 = this.BuiltInFictitiousFunctionClassFactory;
            Fragment fragment3 = this.PlaceComponentResult;
            fragmentLifecycleCallbacksDispatcher2.BuiltInFictitiousFunctionClassFactory(fragment3, fragment3.mSavedFragmentState, false);
            return;
        }
        Fragment fragment4 = this.PlaceComponentResult;
        fragment4.restoreChildFragmentState(fragment4.mSavedFragmentState);
        this.PlaceComponentResult.mState = 1;
    }

    private void scheduleImpl() {
        String str;
        if (this.PlaceComponentResult.mFromLayout) {
            return;
        }
        if (FragmentManager.isLoggingEnabled(3)) {
            StringBuilder sb = new StringBuilder();
            sb.append("moveto CREATE_VIEW: ");
            sb.append(this.PlaceComponentResult);
            InstrumentInjector.log_d(FragmentManager.TAG, sb.toString());
        }
        Fragment fragment = this.PlaceComponentResult;
        LayoutInflater performGetLayoutInflater = fragment.performGetLayoutInflater(fragment.mSavedFragmentState);
        ViewGroup viewGroup = null;
        if (this.PlaceComponentResult.mContainer != null) {
            viewGroup = this.PlaceComponentResult.mContainer;
        } else if (this.PlaceComponentResult.mContainerId != 0) {
            if (this.PlaceComponentResult.mContainerId == -1) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("Cannot create fragment ");
                sb2.append(this.PlaceComponentResult);
                sb2.append(" for a container view with no id");
                throw new IllegalArgumentException(sb2.toString());
            }
            viewGroup = (ViewGroup) this.PlaceComponentResult.mFragmentManager.getContainer().getAuthRequestContext(this.PlaceComponentResult.mContainerId);
            if (viewGroup == null) {
                if (!this.PlaceComponentResult.mRestored) {
                    try {
                        str = this.PlaceComponentResult.getResources().getResourceName(this.PlaceComponentResult.mContainerId);
                    } catch (Resources.NotFoundException unused) {
                        str = "unknown";
                    }
                    StringBuilder sb3 = new StringBuilder();
                    sb3.append("No view found for id 0x");
                    sb3.append(Integer.toHexString(this.PlaceComponentResult.mContainerId));
                    sb3.append(" (");
                    sb3.append(str);
                    sb3.append(") for fragment ");
                    sb3.append(this.PlaceComponentResult);
                    throw new IllegalArgumentException(sb3.toString());
                }
            } else if (!(viewGroup instanceof FragmentContainerView)) {
                FragmentStrictMode.PlaceComponentResult(this.PlaceComponentResult, viewGroup);
            }
        }
        this.PlaceComponentResult.mContainer = viewGroup;
        Fragment fragment2 = this.PlaceComponentResult;
        fragment2.performCreateView(performGetLayoutInflater, viewGroup, fragment2.mSavedFragmentState);
        if (this.PlaceComponentResult.mView != null) {
            this.PlaceComponentResult.mView.setSaveFromParentEnabled(false);
            this.PlaceComponentResult.mView.setTag(R.id.KClassImpl$Data$declaredNonStaticMembers$2, this.PlaceComponentResult);
            if (viewGroup != null) {
                this.PlaceComponentResult.mContainer.addView(this.PlaceComponentResult.mView, this.KClassImpl$Data$declaredNonStaticMembers$2.PlaceComponentResult(this.PlaceComponentResult));
            }
            if (this.PlaceComponentResult.mHidden) {
                this.PlaceComponentResult.mView.setVisibility(8);
            }
            if (ViewCompat.C(this.PlaceComponentResult.mView)) {
                ViewCompat.I(this.PlaceComponentResult.mView);
            } else {
                final View view = this.PlaceComponentResult.mView;
                view.addOnAttachStateChangeListener(new View.OnAttachStateChangeListener() { // from class: androidx.fragment.app.FragmentStateManager.1
                    @Override // android.view.View.OnAttachStateChangeListener
                    public void onViewDetachedFromWindow(View view2) {
                    }

                    {
                        FragmentStateManager.this = this;
                    }

                    @Override // android.view.View.OnAttachStateChangeListener
                    public void onViewAttachedToWindow(View view2) {
                        view.removeOnAttachStateChangeListener(this);
                        ViewCompat.I(view);
                    }
                });
            }
            this.PlaceComponentResult.performViewCreated();
            FragmentLifecycleCallbacksDispatcher fragmentLifecycleCallbacksDispatcher = this.BuiltInFictitiousFunctionClassFactory;
            Fragment fragment3 = this.PlaceComponentResult;
            fragmentLifecycleCallbacksDispatcher.getAuthRequestContext(fragment3, fragment3.mView, this.PlaceComponentResult.mSavedFragmentState, false);
            int visibility = this.PlaceComponentResult.mView.getVisibility();
            this.PlaceComponentResult.setPostOnViewCreatedAlpha(this.PlaceComponentResult.mView.getAlpha());
            if (this.PlaceComponentResult.mContainer != null && visibility == 0) {
                View findFocus = this.PlaceComponentResult.mView.findFocus();
                if (findFocus != null) {
                    this.PlaceComponentResult.setFocusedView(findFocus);
                    if (FragmentManager.isLoggingEnabled(2)) {
                        StringBuilder sb4 = new StringBuilder();
                        sb4.append("requestFocus: Saved focused view ");
                        sb4.append(findFocus);
                        sb4.append(" for Fragment ");
                        sb4.append(this.PlaceComponentResult);
                        InstrumentInjector.log_v(FragmentManager.TAG, sb4.toString());
                    }
                }
                this.PlaceComponentResult.mView.setAlpha(0.0f);
            }
        }
        this.PlaceComponentResult.mState = 2;
    }

    private void KClassImpl$Data$declaredNonStaticMembers$2() {
        if (FragmentManager.isLoggingEnabled(3)) {
            StringBuilder sb = new StringBuilder();
            sb.append("moveto ACTIVITY_CREATED: ");
            sb.append(this.PlaceComponentResult);
            InstrumentInjector.log_d(FragmentManager.TAG, sb.toString());
        }
        Fragment fragment = this.PlaceComponentResult;
        fragment.performActivityCreated(fragment.mSavedFragmentState);
        FragmentLifecycleCallbacksDispatcher fragmentLifecycleCallbacksDispatcher = this.BuiltInFictitiousFunctionClassFactory;
        Fragment fragment2 = this.PlaceComponentResult;
        fragmentLifecycleCallbacksDispatcher.getAuthRequestContext(fragment2, fragment2.mSavedFragmentState, false);
    }

    private void NetworkUserEntityData$$ExternalSyntheticLambda8() {
        if (FragmentManager.isLoggingEnabled(3)) {
            StringBuilder sb = new StringBuilder();
            sb.append("moveto STARTED: ");
            sb.append(this.PlaceComponentResult);
            InstrumentInjector.log_d(FragmentManager.TAG, sb.toString());
        }
        this.PlaceComponentResult.performStart();
        this.BuiltInFictitiousFunctionClassFactory.scheduleImpl(this.PlaceComponentResult, false);
    }

    private void NetworkUserEntityData$$ExternalSyntheticLambda1() {
        if (FragmentManager.isLoggingEnabled(3)) {
            StringBuilder sb = new StringBuilder();
            sb.append("moveto RESUMED: ");
            sb.append(this.PlaceComponentResult);
            InstrumentInjector.log_d(FragmentManager.TAG, sb.toString());
        }
        View focusedView = this.PlaceComponentResult.getFocusedView();
        if (focusedView != null && BuiltInFictitiousFunctionClassFactory(focusedView)) {
            boolean requestFocus = focusedView.requestFocus();
            if (FragmentManager.isLoggingEnabled(2)) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("requestFocus: Restoring focused view ");
                sb2.append(focusedView);
                sb2.append(" ");
                sb2.append(requestFocus ? "succeeded" : "failed");
                sb2.append(" on Fragment ");
                sb2.append(this.PlaceComponentResult);
                sb2.append(" resulting in focused view ");
                sb2.append(this.PlaceComponentResult.mView.findFocus());
                InstrumentInjector.log_v(FragmentManager.TAG, sb2.toString());
            }
        }
        this.PlaceComponentResult.setFocusedView(null);
        this.PlaceComponentResult.performResume();
        this.BuiltInFictitiousFunctionClassFactory.lookAheadTest(this.PlaceComponentResult, false);
        this.PlaceComponentResult.mSavedFragmentState = null;
        this.PlaceComponentResult.mSavedViewState = null;
        this.PlaceComponentResult.mSavedViewRegistryState = null;
    }

    private boolean BuiltInFictitiousFunctionClassFactory(View view) {
        if (view == this.PlaceComponentResult.mView) {
            return true;
        }
        for (ViewParent parent = view.getParent(); parent != null; parent = parent.getParent()) {
            if (parent == this.PlaceComponentResult.mView) {
                return true;
            }
        }
        return false;
    }

    private void DatabaseTableConfigUtil() {
        if (FragmentManager.isLoggingEnabled(3)) {
            StringBuilder sb = new StringBuilder();
            sb.append("movefrom RESUMED: ");
            sb.append(this.PlaceComponentResult);
            InstrumentInjector.log_d(FragmentManager.TAG, sb.toString());
        }
        this.PlaceComponentResult.performPause();
        this.BuiltInFictitiousFunctionClassFactory.PlaceComponentResult(this.PlaceComponentResult, false);
    }

    private void PrepareContext() {
        if (FragmentManager.isLoggingEnabled(3)) {
            StringBuilder sb = new StringBuilder();
            sb.append("movefrom STARTED: ");
            sb.append(this.PlaceComponentResult);
            InstrumentInjector.log_d(FragmentManager.TAG, sb.toString());
        }
        this.PlaceComponentResult.performStop();
        this.BuiltInFictitiousFunctionClassFactory.moveToNextValue(this.PlaceComponentResult, false);
    }

    public final void MyBillsEntityDataFactory() {
        FragmentState fragmentState = new FragmentState(this.PlaceComponentResult);
        if (this.PlaceComponentResult.mState >= 0 && fragmentState.GetContactSyncConfig == null) {
            fragmentState.GetContactSyncConfig = BuiltInFictitiousFunctionClassFactory();
            if (this.PlaceComponentResult.mTargetWho != null) {
                if (fragmentState.GetContactSyncConfig == null) {
                    fragmentState.GetContactSyncConfig = new Bundle();
                }
                fragmentState.GetContactSyncConfig.putString("android:target_state", this.PlaceComponentResult.mTargetWho);
                if (this.PlaceComponentResult.mTargetRequestCode != 0) {
                    fragmentState.GetContactSyncConfig.putInt("android:target_req_state", this.PlaceComponentResult.mTargetRequestCode);
                }
            }
        } else {
            fragmentState.GetContactSyncConfig = this.PlaceComponentResult.mSavedFragmentState;
        }
        FragmentStore fragmentStore = this.KClassImpl$Data$declaredNonStaticMembers$2;
        fragmentStore.MyBillsEntityDataFactory.put(this.PlaceComponentResult.mWho, fragmentState);
    }

    public final Bundle BuiltInFictitiousFunctionClassFactory() {
        Bundle bundle = new Bundle();
        this.PlaceComponentResult.performSaveInstanceState(bundle);
        this.BuiltInFictitiousFunctionClassFactory.MyBillsEntityDataFactory(this.PlaceComponentResult, bundle, false);
        if (bundle.isEmpty()) {
            bundle = null;
        }
        if (this.PlaceComponentResult.mView != null) {
            GetContactSyncConfig();
        }
        if (this.PlaceComponentResult.mSavedViewState != null) {
            if (bundle == null) {
                bundle = new Bundle();
            }
            bundle.putSparseParcelableArray("android:view_state", this.PlaceComponentResult.mSavedViewState);
        }
        if (this.PlaceComponentResult.mSavedViewRegistryState != null) {
            if (bundle == null) {
                bundle = new Bundle();
            }
            bundle.putBundle("android:view_registry_state", this.PlaceComponentResult.mSavedViewRegistryState);
        }
        if (!this.PlaceComponentResult.mUserVisibleHint) {
            if (bundle == null) {
                bundle = new Bundle();
            }
            bundle.putBoolean("android:user_visible_hint", this.PlaceComponentResult.mUserVisibleHint);
        }
        return bundle;
    }

    private void GetContactSyncConfig() {
        if (this.PlaceComponentResult.mView == null) {
            return;
        }
        if (FragmentManager.isLoggingEnabled(2)) {
            StringBuilder sb = new StringBuilder();
            sb.append("Saving view state for fragment ");
            sb.append(this.PlaceComponentResult);
            sb.append(" with view ");
            sb.append(this.PlaceComponentResult.mView);
            InstrumentInjector.log_v(FragmentManager.TAG, sb.toString());
        }
        SparseArray<Parcelable> sparseArray = new SparseArray<>();
        this.PlaceComponentResult.mView.saveHierarchyState(sparseArray);
        if (sparseArray.size() > 0) {
            this.PlaceComponentResult.mSavedViewState = sparseArray;
        }
        Bundle bundle = new Bundle();
        SavedStateRegistryController savedStateRegistryController = this.PlaceComponentResult.mViewLifecycleOwner.KClassImpl$Data$declaredNonStaticMembers$2;
        Intrinsics.checkNotNullParameter(bundle, "");
        savedStateRegistryController.MyBillsEntityDataFactory.KClassImpl$Data$declaredNonStaticMembers$2(bundle);
        if (bundle.isEmpty()) {
            return;
        }
        this.PlaceComponentResult.mSavedViewRegistryState = bundle;
    }

    private void NetworkUserEntityData$$ExternalSyntheticLambda2() {
        if (FragmentManager.isLoggingEnabled(3)) {
            StringBuilder sb = new StringBuilder();
            sb.append("movefrom CREATE_VIEW: ");
            sb.append(this.PlaceComponentResult);
            InstrumentInjector.log_d(FragmentManager.TAG, sb.toString());
        }
        if (this.PlaceComponentResult.mContainer != null && this.PlaceComponentResult.mView != null) {
            this.PlaceComponentResult.mContainer.removeView(this.PlaceComponentResult.mView);
        }
        this.PlaceComponentResult.performDestroyView();
        this.BuiltInFictitiousFunctionClassFactory.NetworkUserEntityData$$ExternalSyntheticLambda0(this.PlaceComponentResult, false);
        this.PlaceComponentResult.mContainer = null;
        this.PlaceComponentResult.mView = null;
        this.PlaceComponentResult.mViewLifecycleOwner = null;
        this.PlaceComponentResult.mViewLifecycleOwnerLiveData.PlaceComponentResult((MutableLiveData<LifecycleOwner>) null);
        this.PlaceComponentResult.mInLayout = false;
    }

    private void moveToNextValue() {
        if (FragmentManager.isLoggingEnabled(3)) {
            StringBuilder sb = new StringBuilder();
            sb.append("movefrom CREATED: ");
            sb.append(this.PlaceComponentResult);
            InstrumentInjector.log_d(FragmentManager.TAG, sb.toString());
        }
        boolean z = true;
        boolean z2 = this.PlaceComponentResult.mRemoving && !this.PlaceComponentResult.isInBackStack();
        if (z2 && !this.PlaceComponentResult.mBeingSaved) {
            this.KClassImpl$Data$declaredNonStaticMembers$2.MyBillsEntityDataFactory.remove(this.PlaceComponentResult.mWho);
        }
        if (z2 || this.KClassImpl$Data$declaredNonStaticMembers$2.BuiltInFictitiousFunctionClassFactory.KClassImpl$Data$declaredNonStaticMembers$2(this.PlaceComponentResult)) {
            FragmentHostCallback<?> fragmentHostCallback = this.PlaceComponentResult.mHost;
            if (fragmentHostCallback instanceof ViewModelStoreOwner) {
                z = this.KClassImpl$Data$declaredNonStaticMembers$2.BuiltInFictitiousFunctionClassFactory.PlaceComponentResult();
            } else if (fragmentHostCallback.MyBillsEntityDataFactory instanceof Activity) {
                z = true ^ ((Activity) fragmentHostCallback.MyBillsEntityDataFactory).isChangingConfigurations();
            }
            if ((z2 && !this.PlaceComponentResult.mBeingSaved) || z) {
                this.KClassImpl$Data$declaredNonStaticMembers$2.BuiltInFictitiousFunctionClassFactory.PlaceComponentResult(this.PlaceComponentResult);
            }
            this.PlaceComponentResult.performDestroy();
            this.BuiltInFictitiousFunctionClassFactory.BuiltInFictitiousFunctionClassFactory(this.PlaceComponentResult, false);
            for (FragmentStateManager fragmentStateManager : this.KClassImpl$Data$declaredNonStaticMembers$2.KClassImpl$Data$declaredNonStaticMembers$2()) {
                if (fragmentStateManager != null) {
                    Fragment fragment = fragmentStateManager.PlaceComponentResult;
                    if (this.PlaceComponentResult.mWho.equals(fragment.mTargetWho)) {
                        fragment.mTarget = this.PlaceComponentResult;
                        fragment.mTargetWho = null;
                    }
                }
            }
            if (this.PlaceComponentResult.mTargetWho != null) {
                Fragment fragment2 = this.PlaceComponentResult;
                FragmentStateManager fragmentStateManager2 = this.KClassImpl$Data$declaredNonStaticMembers$2.KClassImpl$Data$declaredNonStaticMembers$2.get(fragment2.mTargetWho);
                fragment2.mTarget = fragmentStateManager2 != null ? fragmentStateManager2.PlaceComponentResult : null;
            }
            this.KClassImpl$Data$declaredNonStaticMembers$2.MyBillsEntityDataFactory(this);
            return;
        }
        if (this.PlaceComponentResult.mTargetWho != null) {
            FragmentStateManager fragmentStateManager3 = this.KClassImpl$Data$declaredNonStaticMembers$2.KClassImpl$Data$declaredNonStaticMembers$2.get(this.PlaceComponentResult.mTargetWho);
            Fragment fragment3 = fragmentStateManager3 != null ? fragmentStateManager3.PlaceComponentResult : null;
            if (fragment3 != null && fragment3.mRetainInstance) {
                this.PlaceComponentResult.mTarget = fragment3;
            }
        }
        this.PlaceComponentResult.mState = 0;
    }

    private void initRecordTimeStamp() {
        if (FragmentManager.isLoggingEnabled(3)) {
            StringBuilder sb = new StringBuilder();
            sb.append("movefrom ATTACHED: ");
            sb.append(this.PlaceComponentResult);
            InstrumentInjector.log_d(FragmentManager.TAG, sb.toString());
        }
        this.PlaceComponentResult.performDetach();
        boolean z = false;
        this.BuiltInFictitiousFunctionClassFactory.KClassImpl$Data$declaredNonStaticMembers$2(this.PlaceComponentResult, false);
        this.PlaceComponentResult.mState = -1;
        this.PlaceComponentResult.mHost = null;
        this.PlaceComponentResult.mParentFragment = null;
        this.PlaceComponentResult.mFragmentManager = null;
        if (this.PlaceComponentResult.mRemoving && !this.PlaceComponentResult.isInBackStack()) {
            z = true;
        }
        if (z || this.KClassImpl$Data$declaredNonStaticMembers$2.BuiltInFictitiousFunctionClassFactory.KClassImpl$Data$declaredNonStaticMembers$2(this.PlaceComponentResult)) {
            if (FragmentManager.isLoggingEnabled(3)) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("initState called for fragment: ");
                sb2.append(this.PlaceComponentResult);
                InstrumentInjector.log_d(FragmentManager.TAG, sb2.toString());
            }
            this.PlaceComponentResult.initState();
        }
    }
}
