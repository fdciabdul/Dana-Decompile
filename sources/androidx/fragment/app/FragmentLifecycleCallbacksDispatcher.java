package androidx.fragment.app;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import androidx.fragment.app.FragmentManager;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

/* loaded from: classes.dex */
public class FragmentLifecycleCallbacksDispatcher {
    final CopyOnWriteArrayList<FragmentLifecycleCallbacksHolder> MyBillsEntityDataFactory = new CopyOnWriteArrayList<>();
    private final FragmentManager PlaceComponentResult;

    /* loaded from: classes.dex */
    public static final class FragmentLifecycleCallbacksHolder {
        final FragmentManager.FragmentLifecycleCallbacks MyBillsEntityDataFactory;
        final boolean getAuthRequestContext;

        public FragmentLifecycleCallbacksHolder(FragmentManager.FragmentLifecycleCallbacks fragmentLifecycleCallbacks, boolean z) {
            this.MyBillsEntityDataFactory = fragmentLifecycleCallbacks;
            this.getAuthRequestContext = z;
        }
    }

    public FragmentLifecycleCallbacksDispatcher(FragmentManager fragmentManager) {
        this.PlaceComponentResult = fragmentManager;
    }

    public final void getAuthRequestContext(Fragment fragment, boolean z) {
        Context context = this.PlaceComponentResult.getHost().MyBillsEntityDataFactory;
        Fragment parent = this.PlaceComponentResult.getParent();
        if (parent != null) {
            parent.getParentFragmentManager().getLifecycleCallbacksDispatcher().getAuthRequestContext(fragment, true);
        }
        Iterator<FragmentLifecycleCallbacksHolder> it = this.MyBillsEntityDataFactory.iterator();
        while (it.hasNext()) {
            FragmentLifecycleCallbacksHolder next = it.next();
            if (!z || next.getAuthRequestContext) {
                next.MyBillsEntityDataFactory.onFragmentPreAttached(this.PlaceComponentResult, fragment, context);
            }
        }
    }

    public final void MyBillsEntityDataFactory(Fragment fragment, boolean z) {
        Context context = this.PlaceComponentResult.getHost().MyBillsEntityDataFactory;
        Fragment parent = this.PlaceComponentResult.getParent();
        if (parent != null) {
            parent.getParentFragmentManager().getLifecycleCallbacksDispatcher().MyBillsEntityDataFactory(fragment, true);
        }
        Iterator<FragmentLifecycleCallbacksHolder> it = this.MyBillsEntityDataFactory.iterator();
        while (it.hasNext()) {
            FragmentLifecycleCallbacksHolder next = it.next();
            if (!z || next.getAuthRequestContext) {
                next.MyBillsEntityDataFactory.onFragmentAttached(this.PlaceComponentResult, fragment, context);
            }
        }
    }

    public final void KClassImpl$Data$declaredNonStaticMembers$2(Fragment fragment, Bundle bundle, boolean z) {
        Fragment parent = this.PlaceComponentResult.getParent();
        if (parent != null) {
            parent.getParentFragmentManager().getLifecycleCallbacksDispatcher().KClassImpl$Data$declaredNonStaticMembers$2(fragment, bundle, true);
        }
        Iterator<FragmentLifecycleCallbacksHolder> it = this.MyBillsEntityDataFactory.iterator();
        while (it.hasNext()) {
            FragmentLifecycleCallbacksHolder next = it.next();
            if (!z || next.getAuthRequestContext) {
                next.MyBillsEntityDataFactory.onFragmentPreCreated(this.PlaceComponentResult, fragment, bundle);
            }
        }
    }

    public final void BuiltInFictitiousFunctionClassFactory(Fragment fragment, Bundle bundle, boolean z) {
        Fragment parent = this.PlaceComponentResult.getParent();
        if (parent != null) {
            parent.getParentFragmentManager().getLifecycleCallbacksDispatcher().BuiltInFictitiousFunctionClassFactory(fragment, bundle, true);
        }
        Iterator<FragmentLifecycleCallbacksHolder> it = this.MyBillsEntityDataFactory.iterator();
        while (it.hasNext()) {
            FragmentLifecycleCallbacksHolder next = it.next();
            if (!z || next.getAuthRequestContext) {
                next.MyBillsEntityDataFactory.onFragmentCreated(this.PlaceComponentResult, fragment, bundle);
            }
        }
    }

    public final void getAuthRequestContext(Fragment fragment, Bundle bundle, boolean z) {
        Fragment parent = this.PlaceComponentResult.getParent();
        if (parent != null) {
            parent.getParentFragmentManager().getLifecycleCallbacksDispatcher().getAuthRequestContext(fragment, bundle, true);
        }
        Iterator<FragmentLifecycleCallbacksHolder> it = this.MyBillsEntityDataFactory.iterator();
        while (it.hasNext()) {
            FragmentLifecycleCallbacksHolder next = it.next();
            if (!z || next.getAuthRequestContext) {
                next.MyBillsEntityDataFactory.onFragmentActivityCreated(this.PlaceComponentResult, fragment, bundle);
            }
        }
    }

    public final void getAuthRequestContext(Fragment fragment, View view, Bundle bundle, boolean z) {
        Fragment parent = this.PlaceComponentResult.getParent();
        if (parent != null) {
            parent.getParentFragmentManager().getLifecycleCallbacksDispatcher().getAuthRequestContext(fragment, view, bundle, true);
        }
        Iterator<FragmentLifecycleCallbacksHolder> it = this.MyBillsEntityDataFactory.iterator();
        while (it.hasNext()) {
            FragmentLifecycleCallbacksHolder next = it.next();
            if (!z || next.getAuthRequestContext) {
                next.MyBillsEntityDataFactory.onFragmentViewCreated(this.PlaceComponentResult, fragment, view, bundle);
            }
        }
    }

    public final void scheduleImpl(Fragment fragment, boolean z) {
        Fragment parent = this.PlaceComponentResult.getParent();
        if (parent != null) {
            parent.getParentFragmentManager().getLifecycleCallbacksDispatcher().scheduleImpl(fragment, true);
        }
        Iterator<FragmentLifecycleCallbacksHolder> it = this.MyBillsEntityDataFactory.iterator();
        while (it.hasNext()) {
            FragmentLifecycleCallbacksHolder next = it.next();
            if (!z || next.getAuthRequestContext) {
                next.MyBillsEntityDataFactory.onFragmentStarted(this.PlaceComponentResult, fragment);
            }
        }
    }

    public final void lookAheadTest(Fragment fragment, boolean z) {
        Fragment parent = this.PlaceComponentResult.getParent();
        if (parent != null) {
            parent.getParentFragmentManager().getLifecycleCallbacksDispatcher().lookAheadTest(fragment, true);
        }
        Iterator<FragmentLifecycleCallbacksHolder> it = this.MyBillsEntityDataFactory.iterator();
        while (it.hasNext()) {
            FragmentLifecycleCallbacksHolder next = it.next();
            if (!z || next.getAuthRequestContext) {
                next.MyBillsEntityDataFactory.onFragmentResumed(this.PlaceComponentResult, fragment);
            }
        }
    }

    public final void PlaceComponentResult(Fragment fragment, boolean z) {
        Fragment parent = this.PlaceComponentResult.getParent();
        if (parent != null) {
            parent.getParentFragmentManager().getLifecycleCallbacksDispatcher().PlaceComponentResult(fragment, true);
        }
        Iterator<FragmentLifecycleCallbacksHolder> it = this.MyBillsEntityDataFactory.iterator();
        while (it.hasNext()) {
            FragmentLifecycleCallbacksHolder next = it.next();
            if (!z || next.getAuthRequestContext) {
                next.MyBillsEntityDataFactory.onFragmentPaused(this.PlaceComponentResult, fragment);
            }
        }
    }

    public final void moveToNextValue(Fragment fragment, boolean z) {
        Fragment parent = this.PlaceComponentResult.getParent();
        if (parent != null) {
            parent.getParentFragmentManager().getLifecycleCallbacksDispatcher().moveToNextValue(fragment, true);
        }
        Iterator<FragmentLifecycleCallbacksHolder> it = this.MyBillsEntityDataFactory.iterator();
        while (it.hasNext()) {
            FragmentLifecycleCallbacksHolder next = it.next();
            if (!z || next.getAuthRequestContext) {
                next.MyBillsEntityDataFactory.onFragmentStopped(this.PlaceComponentResult, fragment);
            }
        }
    }

    public final void MyBillsEntityDataFactory(Fragment fragment, Bundle bundle, boolean z) {
        Fragment parent = this.PlaceComponentResult.getParent();
        if (parent != null) {
            parent.getParentFragmentManager().getLifecycleCallbacksDispatcher().MyBillsEntityDataFactory(fragment, bundle, true);
        }
        Iterator<FragmentLifecycleCallbacksHolder> it = this.MyBillsEntityDataFactory.iterator();
        while (it.hasNext()) {
            FragmentLifecycleCallbacksHolder next = it.next();
            if (!z || next.getAuthRequestContext) {
                next.MyBillsEntityDataFactory.onFragmentSaveInstanceState(this.PlaceComponentResult, fragment, bundle);
            }
        }
    }

    public final void NetworkUserEntityData$$ExternalSyntheticLambda0(Fragment fragment, boolean z) {
        Fragment parent = this.PlaceComponentResult.getParent();
        if (parent != null) {
            parent.getParentFragmentManager().getLifecycleCallbacksDispatcher().NetworkUserEntityData$$ExternalSyntheticLambda0(fragment, true);
        }
        Iterator<FragmentLifecycleCallbacksHolder> it = this.MyBillsEntityDataFactory.iterator();
        while (it.hasNext()) {
            FragmentLifecycleCallbacksHolder next = it.next();
            if (!z || next.getAuthRequestContext) {
                next.MyBillsEntityDataFactory.onFragmentViewDestroyed(this.PlaceComponentResult, fragment);
            }
        }
    }

    public final void BuiltInFictitiousFunctionClassFactory(Fragment fragment, boolean z) {
        Fragment parent = this.PlaceComponentResult.getParent();
        if (parent != null) {
            parent.getParentFragmentManager().getLifecycleCallbacksDispatcher().BuiltInFictitiousFunctionClassFactory(fragment, true);
        }
        Iterator<FragmentLifecycleCallbacksHolder> it = this.MyBillsEntityDataFactory.iterator();
        while (it.hasNext()) {
            FragmentLifecycleCallbacksHolder next = it.next();
            if (!z || next.getAuthRequestContext) {
                next.MyBillsEntityDataFactory.onFragmentDestroyed(this.PlaceComponentResult, fragment);
            }
        }
    }

    public final void KClassImpl$Data$declaredNonStaticMembers$2(Fragment fragment, boolean z) {
        Fragment parent = this.PlaceComponentResult.getParent();
        if (parent != null) {
            parent.getParentFragmentManager().getLifecycleCallbacksDispatcher().KClassImpl$Data$declaredNonStaticMembers$2(fragment, true);
        }
        Iterator<FragmentLifecycleCallbacksHolder> it = this.MyBillsEntityDataFactory.iterator();
        while (it.hasNext()) {
            FragmentLifecycleCallbacksHolder next = it.next();
            if (!z || next.getAuthRequestContext) {
                next.MyBillsEntityDataFactory.onFragmentDetached(this.PlaceComponentResult, fragment);
            }
        }
    }
}
