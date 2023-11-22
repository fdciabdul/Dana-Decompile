package androidx.core.view;

import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import androidx.view.Lifecycle;
import androidx.view.LifecycleEventObserver;
import androidx.view.LifecycleOwner;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;

/* loaded from: classes.dex */
public class MenuHostHelper {
    public final CopyOnWriteArrayList<MenuProvider> BuiltInFictitiousFunctionClassFactory = new CopyOnWriteArrayList<>();
    private final Map<MenuProvider, LifecycleContainer> KClassImpl$Data$declaredNonStaticMembers$2 = new HashMap();
    public final Runnable getAuthRequestContext;

    public MenuHostHelper(Runnable runnable) {
        this.getAuthRequestContext = runnable;
    }

    public final void PlaceComponentResult(Menu menu) {
        Iterator<MenuProvider> it = this.BuiltInFictitiousFunctionClassFactory.iterator();
        while (it.hasNext()) {
            it.next().BuiltInFictitiousFunctionClassFactory(menu);
        }
    }

    public final void BuiltInFictitiousFunctionClassFactory(Menu menu, MenuInflater menuInflater) {
        Iterator<MenuProvider> it = this.BuiltInFictitiousFunctionClassFactory.iterator();
        while (it.hasNext()) {
            it.next().getAuthRequestContext(menu, menuInflater);
        }
    }

    public final boolean getAuthRequestContext(MenuItem menuItem) {
        Iterator<MenuProvider> it = this.BuiltInFictitiousFunctionClassFactory.iterator();
        while (it.hasNext()) {
            if (it.next().KClassImpl$Data$declaredNonStaticMembers$2(menuItem)) {
                return true;
            }
        }
        return false;
    }

    public final void MyBillsEntityDataFactory(final MenuProvider menuProvider, LifecycleOwner lifecycleOwner, final Lifecycle.State state) {
        Lifecycle lifecycle = lifecycleOwner.getLifecycle();
        LifecycleContainer remove = this.KClassImpl$Data$declaredNonStaticMembers$2.remove(menuProvider);
        if (remove != null) {
            remove.MyBillsEntityDataFactory.KClassImpl$Data$declaredNonStaticMembers$2(remove.PlaceComponentResult);
            remove.PlaceComponentResult = null;
        }
        this.KClassImpl$Data$declaredNonStaticMembers$2.put(menuProvider, new LifecycleContainer(lifecycle, new LifecycleEventObserver() { // from class: androidx.core.view.MenuHostHelper$$ExternalSyntheticLambda1
            @Override // androidx.view.LifecycleEventObserver
            public final void BuiltInFictitiousFunctionClassFactory(LifecycleOwner lifecycleOwner2, Lifecycle.Event event) {
                MenuHostHelper menuHostHelper = MenuHostHelper.this;
                Lifecycle.State state2 = state;
                MenuProvider menuProvider2 = menuProvider;
                if (event != Lifecycle.Event.upTo(state2)) {
                    if (event == Lifecycle.Event.ON_DESTROY) {
                        menuHostHelper.PlaceComponentResult(menuProvider2);
                        return;
                    } else if (event == Lifecycle.Event.downFrom(state2)) {
                        menuHostHelper.BuiltInFictitiousFunctionClassFactory.remove(menuProvider2);
                        menuHostHelper.getAuthRequestContext.run();
                        return;
                    } else {
                        return;
                    }
                }
                menuHostHelper.BuiltInFictitiousFunctionClassFactory.add(menuProvider2);
                menuHostHelper.getAuthRequestContext.run();
            }
        }));
    }

    public final void PlaceComponentResult(MenuProvider menuProvider) {
        this.BuiltInFictitiousFunctionClassFactory.remove(menuProvider);
        LifecycleContainer remove = this.KClassImpl$Data$declaredNonStaticMembers$2.remove(menuProvider);
        if (remove != null) {
            remove.MyBillsEntityDataFactory.KClassImpl$Data$declaredNonStaticMembers$2(remove.PlaceComponentResult);
            remove.PlaceComponentResult = null;
        }
        this.getAuthRequestContext.run();
    }

    /* loaded from: classes.dex */
    static class LifecycleContainer {
        final Lifecycle MyBillsEntityDataFactory;
        LifecycleEventObserver PlaceComponentResult;

        LifecycleContainer(Lifecycle lifecycle, LifecycleEventObserver lifecycleEventObserver) {
            this.MyBillsEntityDataFactory = lifecycle;
            this.PlaceComponentResult = lifecycleEventObserver;
            lifecycle.BuiltInFictitiousFunctionClassFactory(lifecycleEventObserver);
        }
    }

    public final void BuiltInFictitiousFunctionClassFactory(final MenuProvider menuProvider, LifecycleOwner lifecycleOwner) {
        this.BuiltInFictitiousFunctionClassFactory.add(menuProvider);
        this.getAuthRequestContext.run();
        Lifecycle lifecycle = lifecycleOwner.getLifecycle();
        LifecycleContainer remove = this.KClassImpl$Data$declaredNonStaticMembers$2.remove(menuProvider);
        if (remove != null) {
            remove.MyBillsEntityDataFactory.KClassImpl$Data$declaredNonStaticMembers$2(remove.PlaceComponentResult);
            remove.PlaceComponentResult = null;
        }
        this.KClassImpl$Data$declaredNonStaticMembers$2.put(menuProvider, new LifecycleContainer(lifecycle, new LifecycleEventObserver() { // from class: androidx.core.view.MenuHostHelper$$ExternalSyntheticLambda0
            @Override // androidx.view.LifecycleEventObserver
            public final void BuiltInFictitiousFunctionClassFactory(LifecycleOwner lifecycleOwner2, Lifecycle.Event event) {
                MenuHostHelper menuHostHelper = MenuHostHelper.this;
                MenuProvider menuProvider2 = menuProvider;
                if (event == Lifecycle.Event.ON_DESTROY) {
                    menuHostHelper.PlaceComponentResult(menuProvider2);
                }
            }
        }));
    }
}
