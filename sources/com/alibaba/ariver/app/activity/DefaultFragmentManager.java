package com.alibaba.ariver.app.activity;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import com.alibaba.ariver.app.api.App;
import com.alibaba.ariver.app.api.AppUIContext;
import com.alibaba.ariver.app.api.Page;
import com.alibaba.ariver.app.api.R;
import com.alibaba.ariver.app.api.activity.AnimUtils;
import com.alibaba.ariver.app.api.ui.fragment.IFragmentManager;
import com.alibaba.ariver.app.api.ui.fragment.RVFragment;
import com.alibaba.ariver.app.api.ui.tabbar.TabBar;
import com.alibaba.ariver.kernel.RVConstants;
import com.alibaba.ariver.kernel.RVParams;
import com.alibaba.ariver.kernel.common.utils.BundleUtils;
import com.alibaba.ariver.kernel.common.utils.ExecutorUtils;
import com.alibaba.ariver.kernel.common.utils.RVKernelUtils;
import com.alibaba.ariver.kernel.common.utils.RVLogger;
import com.alibaba.ariver.kernel.common.utils.RVTraceKey;
import com.alibaba.ariver.kernel.common.utils.RVTraceUtils;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.Stack;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: classes3.dex */
public class DefaultFragmentManager implements IFragmentManager {
    protected static final String READY_TAG = "mReadyFragment";
    private static final String TAG = "AriverInt:FragmentManager";
    protected FragmentActivity mActivity;
    protected App mApp;
    protected int mContentId;
    protected FragmentManager mFragmentManager;
    protected final Stack<RVFragment> mFragmentStack;
    protected Map<Page, RVFragment> mPageFragmentMap;
    protected final AtomicInteger mReadyCounter;
    protected RVFragment mReadyFragment;

    public DefaultFragmentManager(App app, int i, FragmentActivity fragmentActivity) {
        AtomicInteger atomicInteger = new AtomicInteger(0);
        this.mReadyCounter = atomicInteger;
        this.mPageFragmentMap = new HashMap();
        this.mFragmentStack = new Stack<>();
        RVTraceUtils.traceBeginSection(RVTraceKey.RV_FragmentManager_constructor);
        if (RVKernelUtils.isDebug()) {
            FragmentManager.enableDebugLogging(true);
        }
        this.mApp = app;
        this.mActivity = fragmentActivity;
        this.mFragmentManager = fragmentActivity.getSupportFragmentManager();
        this.mContentId = i;
        this.mReadyFragment = createFragment();
        Bundle bundle = new Bundle();
        bundle.putLong(RVConstants.EXTRA_APP_INSTANCE_ID, app.getNodeId());
        this.mReadyFragment.setArguments(bundle);
        this.mReadyFragment.setAlreadyScheduleAdded(true);
        FragmentTransaction beginTransaction = this.mFragmentManager.beginTransaction();
        RVFragment rVFragment = this.mReadyFragment;
        StringBuilder sb = new StringBuilder();
        sb.append(READY_TAG);
        sb.append(atomicInteger.addAndGet(1));
        beginTransaction.KClassImpl$Data$declaredNonStaticMembers$2(i, rVFragment, sb.toString(), 1);
        beginTransaction.PlaceComponentResult(this.mReadyFragment).KClassImpl$Data$declaredNonStaticMembers$2();
        RVTraceUtils.traceEndSection(RVTraceKey.RV_FragmentManager_constructor);
    }

    public DefaultFragmentManager(App app, int i, Fragment fragment) {
        AtomicInteger atomicInteger = new AtomicInteger(0);
        this.mReadyCounter = atomicInteger;
        this.mPageFragmentMap = new HashMap();
        this.mFragmentStack = new Stack<>();
        this.mApp = app;
        this.mActivity = fragment.getActivity();
        this.mFragmentManager = fragment.getChildFragmentManager();
        this.mContentId = i;
        this.mReadyFragment = createFragment();
        Bundle bundle = new Bundle();
        bundle.putLong(RVConstants.EXTRA_APP_INSTANCE_ID, app.getNodeId());
        this.mReadyFragment.setArguments(bundle);
        this.mReadyFragment.setAlreadyScheduleAdded(true);
        FragmentTransaction beginTransaction = this.mFragmentManager.beginTransaction();
        RVFragment rVFragment = this.mReadyFragment;
        StringBuilder sb = new StringBuilder();
        sb.append(READY_TAG);
        sb.append(atomicInteger.addAndGet(1));
        beginTransaction.KClassImpl$Data$declaredNonStaticMembers$2(i, rVFragment, sb.toString(), 1);
        beginTransaction.PlaceComponentResult(this.mReadyFragment).KClassImpl$Data$declaredNonStaticMembers$2();
    }

    @Override // com.alibaba.ariver.app.api.ui.fragment.IFragmentManager
    public RVFragment createFragment() {
        return new RVFragment();
    }

    @Override // com.alibaba.ariver.app.api.ui.fragment.IFragmentManager
    public FragmentManager getInnerManager() {
        return this.mFragmentManager;
    }

    @Override // com.alibaba.ariver.app.api.ui.fragment.IFragmentManager
    public RVFragment findFragmentForPage(Page page) {
        return this.mPageFragmentMap.get(page);
    }

    @Override // com.alibaba.ariver.app.api.ui.fragment.IFragmentManager
    public void resetFragmentToTop(RVFragment rVFragment) {
        synchronized (this) {
            if (!this.mFragmentStack.empty() && this.mFragmentStack.remove(rVFragment)) {
                this.mFragmentStack.push(rVFragment);
            }
        }
    }

    @Override // com.alibaba.ariver.app.api.ui.fragment.IFragmentManager
    public void pushPage(Page page, RVFragment rVFragment, boolean z) {
        synchronized (this) {
            pushPage(page, rVFragment, this.mContentId, z);
        }
    }

    protected void pushPage(final Page page, RVFragment rVFragment, int i, boolean z) {
        if (this.mApp.getAppContext() == null || this.mActivity.isFinishing() || rVFragment == null || this.mFragmentStack.contains(rVFragment)) {
            RVLogger.e(TAG, "pushPage with illegal state!!!");
            return;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("pushPage: ");
        sb.append(page);
        sb.append(" ");
        sb.append(rVFragment);
        sb.append(" useTranslateAnim: ");
        sb.append(z);
        RVLogger.d(TAG, sb.toString());
        this.mPageFragmentMap.put(page, rVFragment);
        if (!this.mFragmentStack.isEmpty()) {
            RVFragment peek = this.mFragmentStack.peek();
            peek.pauseRender();
            detachFragment(peek, z);
        }
        if (!this.mFragmentStack.contains(rVFragment)) {
            this.mFragmentStack.push(rVFragment);
        }
        if (this.mActivity.isFinishing()) {
            return;
        }
        RVTraceUtils.traceBeginSection(RVTraceKey.RV_FragmentManager_addFragment);
        FragmentTransaction beginTransaction = this.mFragmentManager.beginTransaction();
        RVLogger.d(TAG, "add fragment");
        if (z) {
            try {
                RVLogger.d(TAG, "fragment use translate anim.");
                rVFragment.setShouldResumeWebView(true);
                int animResId = AnimUtils.getAnimResId(this.mActivity, RVFragment.TRANSLATE_IN_LEFT_ID);
                if (animResId == 0) {
                    animResId = R.anim.ariver_fragment_translate_in_left_default;
                }
                beginTransaction.NetworkUserEntityData$$ExternalSyntheticLambda2 = animResId;
                beginTransaction.GetContactSyncConfig = 0;
                beginTransaction.newProxyInstance = 0;
                beginTransaction.PrepareContext = 0;
            } finally {
                try {
                } finally {
                }
            }
        }
        if (!rVFragment.isAdded() && !rVFragment.isAlreadyScheduleAdded()) {
            beginTransaction.KClassImpl$Data$declaredNonStaticMembers$2(i, rVFragment, null, 1);
            beginTransaction.KClassImpl$Data$declaredNonStaticMembers$2();
            ExecutorUtils.runOnMain(new Runnable() { // from class: com.alibaba.ariver.app.activity.DefaultFragmentManager.1
                {
                    DefaultFragmentManager.this = this;
                }

                @Override // java.lang.Runnable
                public void run() {
                    if (DefaultFragmentManager.this.mApp.isDestroyed()) {
                        return;
                    }
                    DefaultFragmentManager.this.checkTabBar(page);
                }
            });
        }
        beginTransaction.BuiltInFictitiousFunctionClassFactory(rVFragment);
        beginTransaction.KClassImpl$Data$declaredNonStaticMembers$2();
        ExecutorUtils.runOnMain(new Runnable() { // from class: com.alibaba.ariver.app.activity.DefaultFragmentManager.1
            {
                DefaultFragmentManager.this = this;
            }

            @Override // java.lang.Runnable
            public void run() {
                if (DefaultFragmentManager.this.mApp.isDestroyed()) {
                    return;
                }
                DefaultFragmentManager.this.checkTabBar(page);
            }
        });
    }

    @Override // com.alibaba.ariver.app.api.ui.fragment.IFragmentManager
    public boolean exitPage(Page page, boolean z, boolean z2) {
        synchronized (this) {
            if (this.mApp.getAppContext() != null && !this.mActivity.isFinishing() && !this.mFragmentManager.isDestroyed()) {
                RVFragment remove = this.mPageFragmentMap.remove(page);
                if (remove == null) {
                    return false;
                }
                if (this.mFragmentStack.size() > 1 || !z2) {
                    if (remove.getActivity() == null || !remove.getActivity().isFinishing()) {
                        StringBuilder sb = new StringBuilder();
                        sb.append("exitPage: ");
                        sb.append(page);
                        sb.append(" ");
                        sb.append(remove);
                        sb.append(" fragmentStack: ");
                        sb.append(this.mFragmentStack.size());
                        sb.append(" useTranslateAnim: ");
                        sb.append(z);
                        RVLogger.d(TAG, sb.toString());
                        boolean z3 = remove == this.mFragmentStack.peek();
                        this.mFragmentStack.remove(remove);
                        FragmentTransaction beginTransaction = this.mFragmentManager.beginTransaction();
                        if (z) {
                            if (!BundleUtils.getBoolean(page.getStartParams(), RVParams.LONG_PUSHWINDOW_WITH_CUSTOM_TRANS_ANIM, false)) {
                                int animResId = AnimUtils.getAnimResId(this.mActivity, RVFragment.TRANSLATE_OUT_RIGHT_ID);
                                if (animResId == 0) {
                                    animResId = R.anim.ariver_fragment_translate_out_right_default;
                                }
                                int animResId2 = AnimUtils.getAnimResId(this.mActivity, RVFragment.TRANSLATE_IN_RIGHT_ID);
                                if (animResId2 == 0) {
                                    animResId2 = R.anim.ariver_fragment_translate_in_right_default;
                                }
                                beginTransaction.NetworkUserEntityData$$ExternalSyntheticLambda2 = animResId2;
                                beginTransaction.GetContactSyncConfig = animResId;
                                beginTransaction.newProxyInstance = 0;
                                beginTransaction.PrepareContext = 0;
                            } else {
                                beginTransaction.NetworkUserEntityData$$ExternalSyntheticLambda2 = 0;
                                beginTransaction.GetContactSyncConfig = 17432577;
                                beginTransaction.newProxyInstance = 0;
                                beginTransaction.PrepareContext = 0;
                            }
                        }
                        if (this.mFragmentStack.size() > 0) {
                            RVFragment peek = this.mFragmentStack.peek();
                            if (z) {
                                peek.setShouldResumeWebView(true);
                            }
                            beginTransaction.BuiltInFictitiousFunctionClassFactory(new FragmentTransaction.Op(7, peek));
                        }
                        beginTransaction.KClassImpl$Data$declaredNonStaticMembers$2(remove);
                        beginTransaction.KClassImpl$Data$declaredNonStaticMembers$2();
                        Page activePage = this.mApp.getActivePage();
                        if (activePage != null && z3 && !this.mFragmentStack.isEmpty()) {
                            checkTabBar(activePage);
                        }
                        return true;
                    }
                    return true;
                }
                return false;
            }
            RVLogger.d(TAG, "activity is finishing");
            return false;
        }
    }

    @Override // com.alibaba.ariver.app.api.ui.fragment.IFragmentManager
    public void release() {
        synchronized (this) {
            this.mPageFragmentMap.clear();
            this.mFragmentStack.clear();
            this.mReadyFragment = null;
        }
    }

    @Override // com.alibaba.ariver.app.api.ui.fragment.IFragmentManager
    public RVFragment getReadyFragment() {
        synchronized (this) {
            Fragment fragment = null;
            if (this.mReadyFragment != null) {
                StringBuilder sb = new StringBuilder();
                sb.append(READY_TAG);
                sb.append(this.mReadyCounter.get());
                if (sb.toString().equals(this.mReadyFragment.getTag())) {
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("getReadyFragment hit field: ");
                    sb2.append(this.mReadyCounter);
                    sb2.append(" ");
                    sb2.append(this.mReadyFragment != null);
                    RVLogger.d(TAG, sb2.toString());
                    RVFragment rVFragment = this.mReadyFragment;
                    this.mReadyFragment = null;
                    fragment = rVFragment;
                }
            }
            if (fragment == null) {
                FragmentManager fragmentManager = this.mFragmentManager;
                StringBuilder sb3 = new StringBuilder();
                sb3.append(READY_TAG);
                sb3.append(this.mReadyCounter.get());
                fragment = fragmentManager.findFragmentByTag(sb3.toString());
            }
            if (fragment != null) {
                StringBuilder sb4 = new StringBuilder();
                sb4.append("getReadyFragment hit! mReadyCounter: ");
                sb4.append(this.mReadyCounter);
                RVLogger.d(TAG, sb4.toString());
                this.mReadyCounter.incrementAndGet();
                return (RVFragment) fragment;
            }
            StringBuilder sb5 = new StringBuilder();
            sb5.append("getReadyFragment miss! mReadyCounter: ");
            sb5.append(this.mReadyCounter);
            RVLogger.d(TAG, sb5.toString());
            return createFragment();
        }
    }

    @Override // com.alibaba.ariver.app.api.ui.fragment.IFragmentManager
    public Set<RVFragment> getFragments() {
        return new HashSet(this.mFragmentStack);
    }

    protected void checkTabBar(Page page) {
        TabBar tabBar;
        if (this.mApp.getAppContext() == null || (tabBar = ((AppUIContext) this.mApp.getAppContext()).getTabBar()) == null || page == null) {
            return;
        }
        boolean isTabPage = tabBar.isTabPage(page);
        if (isTabPage && !tabBar.isShowing() && tabBar.isAutoShow()) {
            if (!tabBar.isCreated()) {
                tabBar.show(page, null);
            } else {
                tabBar.show(null, null);
            }
        } else if (isTabPage || !tabBar.isShowing()) {
        } else {
            tabBar.hide(null);
        }
    }

    @Override // com.alibaba.ariver.app.api.ui.fragment.IFragmentManager
    public boolean attachFragment(RVFragment rVFragment, boolean z) {
        synchronized (this) {
            if (!this.mActivity.isFinishing() && this.mApp.getAppContext() != null) {
                if (rVFragment != null && !rVFragment.isVisible()) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("attachFragment: ");
                    sb.append(rVFragment);
                    RVLogger.d(TAG, sb.toString());
                    checkTabBar(rVFragment.getPage());
                    FragmentTransaction beginTransaction = this.mFragmentManager.beginTransaction();
                    if (z) {
                        rVFragment.setShouldResumeWebView(true);
                        int animResId = AnimUtils.getAnimResId(this.mActivity, RVFragment.TRANSLATE_IN_RIGHT_ID);
                        if (animResId == 0) {
                            animResId = R.anim.ariver_fragment_translate_in_right_default;
                        }
                        beginTransaction.NetworkUserEntityData$$ExternalSyntheticLambda2 = animResId;
                        beginTransaction.GetContactSyncConfig = 0;
                        beginTransaction.newProxyInstance = 0;
                        beginTransaction.PrepareContext = 0;
                    }
                    beginTransaction.BuiltInFictitiousFunctionClassFactory(new FragmentTransaction.Op(7, rVFragment));
                    beginTransaction.KClassImpl$Data$declaredNonStaticMembers$2();
                    return true;
                }
                return false;
            }
            RVLogger.d(TAG, "activity is finishing");
            return false;
        }
    }

    @Override // com.alibaba.ariver.app.api.ui.fragment.IFragmentManager
    public boolean detachFragment(RVFragment rVFragment, boolean z) {
        synchronized (this) {
            if (this.mActivity.isFinishing()) {
                RVLogger.d(TAG, "activity is finishing");
                return false;
            }
            if (rVFragment != null && !rVFragment.isHidden()) {
                StringBuilder sb = new StringBuilder();
                sb.append("attachFragment: ");
                sb.append(rVFragment);
                RVLogger.d(TAG, sb.toString());
                FragmentTransaction beginTransaction = this.mFragmentManager.beginTransaction();
                if (z) {
                    try {
                        int animResId = AnimUtils.getAnimResId(this.mActivity, RVFragment.TRANSLATE_OUT_LEFT_ID);
                        if (animResId == 0) {
                            animResId = R.anim.ariver_fragment_translate_out_left_default;
                        }
                        beginTransaction.NetworkUserEntityData$$ExternalSyntheticLambda2 = 0;
                        beginTransaction.GetContactSyncConfig = animResId;
                        beginTransaction.newProxyInstance = 0;
                        beginTransaction.PrepareContext = 0;
                    } catch (Throwable th) {
                        RVLogger.e(TAG, th);
                    }
                }
                beginTransaction.getAuthRequestContext(rVFragment).KClassImpl$Data$declaredNonStaticMembers$2();
                return true;
            }
            return false;
        }
    }
}
