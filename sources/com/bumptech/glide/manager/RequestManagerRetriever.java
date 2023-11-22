package com.bumptech.glide.manager;

import android.app.Activity;
import android.app.Application;
import android.app.FragmentManager;
import android.content.Context;
import android.content.ContextWrapper;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import android.view.View;
import androidx.collection.ArrayMap;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentTransaction;
import com.bumptech.glide.Glide;
import com.bumptech.glide.GlideBuilder;
import com.bumptech.glide.GlideExperiments;
import com.bumptech.glide.RequestManager;
import com.bumptech.glide.load.resource.bitmap.HardwareConfigState;
import com.bumptech.glide.util.Preconditions;
import com.bumptech.glide.util.Util;
import com.fullstory.instrumentation.InstrumentInjector;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes3.dex */
public class RequestManagerRetriever implements Handler.Callback {
    private static final RequestManagerFactory scheduleImpl = new RequestManagerFactory() { // from class: com.bumptech.glide.manager.RequestManagerRetriever.1
        @Override // com.bumptech.glide.manager.RequestManagerRetriever.RequestManagerFactory
        public final RequestManager getAuthRequestContext(Glide glide, Lifecycle lifecycle, RequestManagerTreeNode requestManagerTreeNode, Context context) {
            return new RequestManager(glide, lifecycle, requestManagerTreeNode, context);
        }
    };
    public final FrameWaiter MyBillsEntityDataFactory;
    private final RequestManagerFactory NetworkUserEntityData$$ExternalSyntheticLambda0;
    private volatile RequestManager lookAheadTest;
    private final Handler moveToNextValue;
    final Map<FragmentManager, RequestManagerFragment> BuiltInFictitiousFunctionClassFactory = new HashMap();
    final Map<androidx.fragment.app.FragmentManager, SupportRequestManagerFragment> getAuthRequestContext = new HashMap();
    public final ArrayMap<View, Fragment> KClassImpl$Data$declaredNonStaticMembers$2 = new ArrayMap<>();
    public final ArrayMap<View, android.app.Fragment> PlaceComponentResult = new ArrayMap<>();
    private final Bundle getErrorConfigVersion = new Bundle();

    /* loaded from: classes3.dex */
    public interface RequestManagerFactory {
        RequestManager getAuthRequestContext(Glide glide, Lifecycle lifecycle, RequestManagerTreeNode requestManagerTreeNode, Context context);
    }

    public RequestManagerRetriever(RequestManagerFactory requestManagerFactory, GlideExperiments glideExperiments) {
        FrameWaiter doNothingFirstFrameWaiter;
        this.NetworkUserEntityData$$ExternalSyntheticLambda0 = requestManagerFactory == null ? scheduleImpl : requestManagerFactory;
        this.moveToNextValue = new Handler(Looper.getMainLooper(), this);
        if (!HardwareConfigState.PlaceComponentResult || !HardwareConfigState.MyBillsEntityDataFactory) {
            doNothingFirstFrameWaiter = new DoNothingFirstFrameWaiter();
        } else if (glideExperiments.MyBillsEntityDataFactory(GlideBuilder.WaitForFramesAfterTrimMemory.class)) {
            doNothingFirstFrameWaiter = new FirstFrameAndAfterTrimMemoryWaiter();
        } else {
            doNothingFirstFrameWaiter = new FirstFrameWaiter();
        }
        this.MyBillsEntityDataFactory = doNothingFirstFrameWaiter;
    }

    private RequestManager KClassImpl$Data$declaredNonStaticMembers$2(Context context) {
        if (this.lookAheadTest == null) {
            synchronized (this) {
                if (this.lookAheadTest == null) {
                    this.lookAheadTest = this.NetworkUserEntityData$$ExternalSyntheticLambda0.getAuthRequestContext(Glide.BuiltInFictitiousFunctionClassFactory(context.getApplicationContext()), new ApplicationLifecycle(), new EmptyRequestManagerTreeNode(), context.getApplicationContext());
                }
            }
        }
        return this.lookAheadTest;
    }

    public final RequestManager MyBillsEntityDataFactory(Context context) {
        while (context != null) {
            if (Util.MyBillsEntityDataFactory() && !(context instanceof Application)) {
                if (context instanceof FragmentActivity) {
                    return KClassImpl$Data$declaredNonStaticMembers$2((FragmentActivity) context);
                }
                if (context instanceof Activity) {
                    return KClassImpl$Data$declaredNonStaticMembers$2((Activity) context);
                }
                if (context instanceof ContextWrapper) {
                    ContextWrapper contextWrapper = (ContextWrapper) context;
                    if (contextWrapper.getBaseContext().getApplicationContext() != null) {
                        context = contextWrapper.getBaseContext();
                    }
                }
            }
            return KClassImpl$Data$declaredNonStaticMembers$2(context);
        }
        throw new IllegalArgumentException("You cannot start a load on a null Context");
    }

    public final RequestManager KClassImpl$Data$declaredNonStaticMembers$2(FragmentActivity fragmentActivity) {
        if (Util.PlaceComponentResult()) {
            return MyBillsEntityDataFactory(fragmentActivity.getApplicationContext());
        }
        if (Build.VERSION.SDK_INT < 17 || !fragmentActivity.isDestroyed()) {
            return BuiltInFictitiousFunctionClassFactory(fragmentActivity, fragmentActivity.getSupportFragmentManager(), null, PlaceComponentResult(fragmentActivity));
        }
        throw new IllegalArgumentException("You cannot start a load for a destroyed activity");
    }

    public final RequestManager getAuthRequestContext(Fragment fragment) {
        Preconditions.BuiltInFictitiousFunctionClassFactory(fragment.getContext(), "You cannot start a load on a fragment before it is attached or after it is destroyed");
        if (Util.PlaceComponentResult()) {
            return MyBillsEntityDataFactory(fragment.getContext().getApplicationContext());
        }
        if (fragment.getActivity() != null) {
            fragment.getActivity();
        }
        return BuiltInFictitiousFunctionClassFactory(fragment.getContext(), fragment.getChildFragmentManager(), fragment, fragment.isVisible());
    }

    public final RequestManager KClassImpl$Data$declaredNonStaticMembers$2(Activity activity) {
        if (Util.PlaceComponentResult()) {
            return MyBillsEntityDataFactory(activity.getApplicationContext());
        }
        if (activity instanceof FragmentActivity) {
            return KClassImpl$Data$declaredNonStaticMembers$2((FragmentActivity) activity);
        }
        if (Build.VERSION.SDK_INT < 17 || !activity.isDestroyed()) {
            return KClassImpl$Data$declaredNonStaticMembers$2(activity, activity.getFragmentManager(), null, PlaceComponentResult(activity));
        }
        throw new IllegalArgumentException("You cannot start a load for a destroyed activity");
    }

    public static void BuiltInFictitiousFunctionClassFactory(Collection<Fragment> collection, Map<View, Fragment> map) {
        if (collection == null) {
            return;
        }
        for (Fragment fragment : collection) {
            if (fragment != null && fragment.getView() != null) {
                map.put(fragment.getView(), fragment);
                BuiltInFictitiousFunctionClassFactory(fragment.getChildFragmentManager().getFragments(), map);
            }
        }
    }

    @Deprecated
    public final void BuiltInFictitiousFunctionClassFactory(FragmentManager fragmentManager, ArrayMap<View, android.app.Fragment> arrayMap) {
        if (Build.VERSION.SDK_INT >= 26) {
            for (android.app.Fragment fragment : fragmentManager.getFragments()) {
                if (fragment.getView() != null) {
                    arrayMap.put(fragment.getView(), fragment);
                    BuiltInFictitiousFunctionClassFactory(fragment.getChildFragmentManager(), arrayMap);
                }
            }
            return;
        }
        PlaceComponentResult(fragmentManager, arrayMap);
    }

    @Deprecated
    private void PlaceComponentResult(FragmentManager fragmentManager, ArrayMap<View, android.app.Fragment> arrayMap) {
        int i = 0;
        while (true) {
            this.getErrorConfigVersion.putInt("key", i);
            android.app.Fragment fragment = null;
            try {
                fragment = fragmentManager.getFragment(this.getErrorConfigVersion, "key");
            } catch (Exception unused) {
            }
            if (fragment == null) {
                return;
            }
            if (fragment.getView() != null) {
                arrayMap.put(fragment.getView(), fragment);
                if (Build.VERSION.SDK_INT >= 17) {
                    BuiltInFictitiousFunctionClassFactory(fragment.getChildFragmentManager(), arrayMap);
                }
            }
            i++;
        }
    }

    public static Activity getAuthRequestContext(Context context) {
        while (!(context instanceof Activity)) {
            if (!(context instanceof ContextWrapper)) {
                return null;
            }
            context = ((ContextWrapper) context).getBaseContext();
        }
        return (Activity) context;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final RequestManagerFragment getAuthRequestContext(FragmentManager fragmentManager, android.app.Fragment fragment) {
        RequestManagerFragment requestManagerFragment = (RequestManagerFragment) fragmentManager.findFragmentByTag("com.bumptech.glide.manager");
        if (requestManagerFragment == null && (requestManagerFragment = this.BuiltInFictitiousFunctionClassFactory.get(fragmentManager)) == null) {
            requestManagerFragment = new RequestManagerFragment();
            requestManagerFragment.MyBillsEntityDataFactory = fragment;
            if (fragment != null && fragment.getActivity() != null) {
                requestManagerFragment.MyBillsEntityDataFactory(fragment.getActivity());
            }
            this.BuiltInFictitiousFunctionClassFactory.put(fragmentManager, requestManagerFragment);
            fragmentManager.beginTransaction().add(requestManagerFragment, "com.bumptech.glide.manager").commitAllowingStateLoss();
            this.moveToNextValue.obtainMessage(1, fragmentManager).sendToTarget();
        }
        return requestManagerFragment;
    }

    @Deprecated
    public final RequestManager KClassImpl$Data$declaredNonStaticMembers$2(Context context, FragmentManager fragmentManager, android.app.Fragment fragment, boolean z) {
        RequestManagerFragment authRequestContext = getAuthRequestContext(fragmentManager, fragment);
        RequestManager requestManager = authRequestContext.BuiltInFictitiousFunctionClassFactory;
        if (requestManager == null) {
            requestManager = this.NetworkUserEntityData$$ExternalSyntheticLambda0.getAuthRequestContext(Glide.BuiltInFictitiousFunctionClassFactory(context), authRequestContext.PlaceComponentResult, authRequestContext.getAuthRequestContext, context);
            if (z) {
                requestManager.onStart();
            }
            authRequestContext.BuiltInFictitiousFunctionClassFactory = requestManager;
        }
        return requestManager;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final SupportRequestManagerFragment getAuthRequestContext(androidx.fragment.app.FragmentManager fragmentManager, Fragment fragment) {
        androidx.fragment.app.FragmentManager BuiltInFictitiousFunctionClassFactory;
        SupportRequestManagerFragment supportRequestManagerFragment = (SupportRequestManagerFragment) fragmentManager.findFragmentByTag("com.bumptech.glide.manager");
        if (supportRequestManagerFragment == null && (supportRequestManagerFragment = this.getAuthRequestContext.get(fragmentManager)) == null) {
            supportRequestManagerFragment = new SupportRequestManagerFragment();
            supportRequestManagerFragment.PlaceComponentResult = fragment;
            if (fragment != null && fragment.getContext() != null && (BuiltInFictitiousFunctionClassFactory = SupportRequestManagerFragment.BuiltInFictitiousFunctionClassFactory(fragment)) != null) {
                supportRequestManagerFragment.PlaceComponentResult(fragment.getContext(), BuiltInFictitiousFunctionClassFactory);
            }
            this.getAuthRequestContext.put(fragmentManager, supportRequestManagerFragment);
            FragmentTransaction beginTransaction = fragmentManager.beginTransaction();
            beginTransaction.KClassImpl$Data$declaredNonStaticMembers$2(0, supportRequestManagerFragment, "com.bumptech.glide.manager", 1);
            beginTransaction.KClassImpl$Data$declaredNonStaticMembers$2();
            this.moveToNextValue.obtainMessage(2, fragmentManager).sendToTarget();
        }
        return supportRequestManagerFragment;
    }

    private RequestManager BuiltInFictitiousFunctionClassFactory(Context context, androidx.fragment.app.FragmentManager fragmentManager, Fragment fragment, boolean z) {
        SupportRequestManagerFragment authRequestContext = getAuthRequestContext(fragmentManager, fragment);
        RequestManager requestManager = authRequestContext.KClassImpl$Data$declaredNonStaticMembers$2;
        if (requestManager == null) {
            requestManager = this.NetworkUserEntityData$$ExternalSyntheticLambda0.getAuthRequestContext(Glide.BuiltInFictitiousFunctionClassFactory(context), authRequestContext.MyBillsEntityDataFactory, authRequestContext.NetworkUserEntityData$$ExternalSyntheticLambda0, context);
            if (z) {
                requestManager.onStart();
            }
            authRequestContext.KClassImpl$Data$declaredNonStaticMembers$2 = requestManager;
        }
        return requestManager;
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        Object obj;
        Object remove;
        Object obj2;
        int i = message.what;
        boolean z = true;
        Object obj3 = null;
        if (i == 1) {
            obj = (FragmentManager) message.obj;
            remove = this.BuiltInFictitiousFunctionClassFactory.remove(obj);
        } else if (i == 2) {
            obj = (androidx.fragment.app.FragmentManager) message.obj;
            remove = this.getAuthRequestContext.remove(obj);
        } else {
            z = false;
            obj2 = null;
            if (z && obj3 == null && Log.isLoggable("RMRetriever", 5)) {
                StringBuilder sb = new StringBuilder();
                sb.append("Failed to remove expected request manager fragment, manager: ");
                sb.append(obj2);
                InstrumentInjector.log_w("RMRetriever", sb.toString());
            }
            return z;
        }
        Object obj4 = obj;
        obj3 = remove;
        obj2 = obj4;
        if (z) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("Failed to remove expected request manager fragment, manager: ");
            sb2.append(obj2);
            InstrumentInjector.log_w("RMRetriever", sb2.toString());
        }
        return z;
    }

    private static boolean PlaceComponentResult(Context context) {
        Activity activity = null;
        if (context instanceof Activity) {
            activity = (Activity) context;
        } else if (context instanceof ContextWrapper) {
            Context baseContext = ((ContextWrapper) context).getBaseContext();
            while (true) {
                if (baseContext instanceof Activity) {
                    activity = baseContext;
                    break;
                } else if (!(baseContext instanceof ContextWrapper)) {
                    break;
                } else {
                    baseContext = ((ContextWrapper) baseContext).getBaseContext();
                }
            }
        }
        return activity == null || !activity.isFinishing();
    }
}
