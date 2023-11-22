package androidx.view;

import androidx.view.Lifecycle;
import androidx.view.LifecycleEventObserver;
import androidx.view.LifecycleOwner;
import java.util.ArrayDeque;
import java.util.Iterator;

/* loaded from: classes.dex */
public final class OnBackPressedDispatcher {
    public final ArrayDeque<OnBackPressedCallback> KClassImpl$Data$declaredNonStaticMembers$2;
    private final Runnable getAuthRequestContext;

    public OnBackPressedDispatcher() {
        this(null);
    }

    public OnBackPressedDispatcher(Runnable runnable) {
        this.KClassImpl$Data$declaredNonStaticMembers$2 = new ArrayDeque<>();
        this.getAuthRequestContext = runnable;
    }

    public final void PlaceComponentResult(LifecycleOwner lifecycleOwner, OnBackPressedCallback onBackPressedCallback) {
        Lifecycle lifecycle = lifecycleOwner.getLifecycle();
        if (lifecycle.PlaceComponentResult() == Lifecycle.State.DESTROYED) {
            return;
        }
        onBackPressedCallback.addCancellable(new LifecycleOnBackPressedCancellable(lifecycle, onBackPressedCallback));
    }

    public final boolean getAuthRequestContext() {
        Iterator<OnBackPressedCallback> descendingIterator = this.KClassImpl$Data$declaredNonStaticMembers$2.descendingIterator();
        while (descendingIterator.hasNext()) {
            if (descendingIterator.next().isEnabled()) {
                return true;
            }
        }
        return false;
    }

    public final void KClassImpl$Data$declaredNonStaticMembers$2() {
        Iterator<OnBackPressedCallback> descendingIterator = this.KClassImpl$Data$declaredNonStaticMembers$2.descendingIterator();
        while (descendingIterator.hasNext()) {
            OnBackPressedCallback next = descendingIterator.next();
            if (next.isEnabled()) {
                next.handleOnBackPressed();
                return;
            }
        }
        Runnable runnable = this.getAuthRequestContext;
        if (runnable != null) {
            runnable.run();
        }
    }

    /* loaded from: classes.dex */
    public class OnBackPressedCancellable implements Cancellable {
        private final OnBackPressedCallback BuiltInFictitiousFunctionClassFactory;

        public OnBackPressedCancellable(OnBackPressedCallback onBackPressedCallback) {
            this.BuiltInFictitiousFunctionClassFactory = onBackPressedCallback;
        }

        @Override // androidx.view.Cancellable
        public final void getAuthRequestContext() {
            OnBackPressedDispatcher.this.KClassImpl$Data$declaredNonStaticMembers$2.remove(this.BuiltInFictitiousFunctionClassFactory);
            this.BuiltInFictitiousFunctionClassFactory.removeCancellable(this);
        }
    }

    /* loaded from: classes.dex */
    class LifecycleOnBackPressedCancellable implements LifecycleEventObserver, Cancellable {
        private Cancellable BuiltInFictitiousFunctionClassFactory;
        private final OnBackPressedCallback PlaceComponentResult;
        private final Lifecycle getAuthRequestContext;

        LifecycleOnBackPressedCancellable(Lifecycle lifecycle, OnBackPressedCallback onBackPressedCallback) {
            this.getAuthRequestContext = lifecycle;
            this.PlaceComponentResult = onBackPressedCallback;
            lifecycle.BuiltInFictitiousFunctionClassFactory(this);
        }

        @Override // androidx.view.LifecycleEventObserver
        public void BuiltInFictitiousFunctionClassFactory(LifecycleOwner lifecycleOwner, Lifecycle.Event event) {
            if (event == Lifecycle.Event.ON_START) {
                OnBackPressedDispatcher onBackPressedDispatcher = OnBackPressedDispatcher.this;
                OnBackPressedCallback onBackPressedCallback = this.PlaceComponentResult;
                onBackPressedDispatcher.KClassImpl$Data$declaredNonStaticMembers$2.add(onBackPressedCallback);
                OnBackPressedCancellable onBackPressedCancellable = new OnBackPressedCancellable(onBackPressedCallback);
                onBackPressedCallback.addCancellable(onBackPressedCancellable);
                this.BuiltInFictitiousFunctionClassFactory = onBackPressedCancellable;
            } else if (event == Lifecycle.Event.ON_STOP) {
                Cancellable cancellable = this.BuiltInFictitiousFunctionClassFactory;
                if (cancellable != null) {
                    cancellable.getAuthRequestContext();
                }
            } else if (event == Lifecycle.Event.ON_DESTROY) {
                getAuthRequestContext();
            }
        }

        @Override // androidx.view.Cancellable
        public final void getAuthRequestContext() {
            this.getAuthRequestContext.KClassImpl$Data$declaredNonStaticMembers$2(this);
            this.PlaceComponentResult.removeCancellable(this);
            Cancellable cancellable = this.BuiltInFictitiousFunctionClassFactory;
            if (cancellable != null) {
                cancellable.getAuthRequestContext();
                this.BuiltInFictitiousFunctionClassFactory = null;
            }
        }
    }
}
