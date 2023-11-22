package com.zhuinden.simplestack.navigator;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.zhuinden.simplestack.StateChange;
import com.zhuinden.simplestack.StateChanger;
import com.zhuinden.simplestack.navigator.ViewChangeHandler;
import com.zhuinden.simplestack.navigator.changehandlers.FadeViewChangeHandler;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;

/* loaded from: classes2.dex */
public final class DefaultStateChanger implements StateChanger {
    private static final FadeViewChangeHandler FADE_VIEW_CHANGE_HANDLER = new FadeViewChangeHandler();
    private Context baseContext;
    private ViewGroup container;
    private ContextCreationStrategy contextCreationStrategy;
    private StateChanger externalStateChanger;
    private GetPreviousViewStrategy getPreviousViewStrategy;
    private GetViewChangeHandlerStrategy getViewChangeHandlerStrategy;
    private LayoutInflationStrategy layoutInflationStrategy;
    private StatePersistenceStrategy statePersistenceStrategy;
    private ViewChangeCompletionListener viewChangeCompletionListener;
    private ViewChangeStartListener viewChangeStartListener;

    /* loaded from: classes2.dex */
    public interface ContextCreationStrategy {
        @Nonnull
        Context createContext(@Nonnull Context context, @Nonnull Object obj, @Nonnull ViewGroup viewGroup, @Nonnull StateChange stateChange);
    }

    /* loaded from: classes2.dex */
    public interface GetPreviousViewStrategy {
        @Nullable
        View getPreviousView(@Nonnull ViewGroup viewGroup, @Nonnull StateChange stateChange, @Nullable Object obj);
    }

    /* loaded from: classes2.dex */
    public interface GetViewChangeHandlerStrategy {
        @Nonnull
        ViewChangeHandler getViewChangeHandler(@Nonnull StateChange stateChange, @Nonnull ViewGroup viewGroup, @Nonnull Object obj, @Nonnull Object obj2, @Nonnull View view, @Nonnull View view2, int i);
    }

    /* loaded from: classes2.dex */
    public interface LayoutInflationStrategy {

        /* loaded from: classes2.dex */
        public interface Callback {
            void layoutInflationComplete(@Nonnull View view);
        }

        void inflateLayout(@Nonnull StateChange stateChange, @Nonnull Object obj, @Nonnull Context context, @Nonnull ViewGroup viewGroup, @Nonnull Callback callback);
    }

    /* loaded from: classes2.dex */
    public interface StatePersistenceStrategy {
        void persistViewToState(@Nonnull Object obj, @Nonnull View view);

        void restoreViewFromState(@Nonnull Object obj, @Nonnull View view);
    }

    /* loaded from: classes2.dex */
    public interface ViewChangeCompletionListener {

        /* loaded from: classes2.dex */
        public interface Callback {
            void viewChangeComplete();
        }

        void handleViewChangeComplete(@Nonnull StateChange stateChange, @Nonnull ViewGroup viewGroup, @Nullable View view, @Nonnull View view2, @Nonnull Callback callback);
    }

    /* loaded from: classes2.dex */
    public interface ViewChangeStartListener {

        /* loaded from: classes2.dex */
        public interface Callback {
            void startViewChange();
        }

        void handleViewChangeStart(@Nonnull StateChange stateChange, @Nonnull ViewGroup viewGroup, @Nullable View view, @Nonnull View view2, @Nonnull Callback callback);
    }

    /* loaded from: classes2.dex */
    static class NoOpStateChanger implements StateChanger {
        private NoOpStateChanger() {
        }

        @Override // com.zhuinden.simplestack.StateChanger
        public void handleStateChange(@Nonnull StateChange stateChange, @Nonnull StateChanger.Callback callback) {
            callback.stateChangeComplete();
        }
    }

    /* loaded from: classes2.dex */
    static class NoOpViewChangeStartListener implements ViewChangeStartListener {
        private NoOpViewChangeStartListener() {
        }

        @Override // com.zhuinden.simplestack.navigator.DefaultStateChanger.ViewChangeStartListener
        public void handleViewChangeStart(@Nonnull StateChange stateChange, @Nonnull ViewGroup viewGroup, @Nullable View view, @Nonnull View view2, @Nonnull ViewChangeStartListener.Callback callback) {
            callback.startViewChange();
        }
    }

    /* loaded from: classes2.dex */
    static class NoOpViewChangeCompletionListener implements ViewChangeCompletionListener {
        private NoOpViewChangeCompletionListener() {
        }

        @Override // com.zhuinden.simplestack.navigator.DefaultStateChanger.ViewChangeCompletionListener
        public void handleViewChangeComplete(@Nonnull StateChange stateChange, @Nonnull ViewGroup viewGroup, @Nullable View view, @Nonnull View view2, @Nonnull ViewChangeCompletionListener.Callback callback) {
            callback.viewChangeComplete();
        }
    }

    /* loaded from: classes2.dex */
    static class DefaultLayoutInflationStrategy implements LayoutInflationStrategy {
        private DefaultLayoutInflationStrategy() {
        }

        @Override // com.zhuinden.simplestack.navigator.DefaultStateChanger.LayoutInflationStrategy
        public void inflateLayout(@Nonnull StateChange stateChange, @Nonnull Object obj, @Nonnull Context context, @Nonnull ViewGroup viewGroup, @Nonnull LayoutInflationStrategy.Callback callback) {
            callback.layoutInflationComplete(LayoutInflater.from(context).inflate(((DefaultViewKey) obj).getGetAuthRequestContext(), viewGroup, false));
        }
    }

    /* loaded from: classes2.dex */
    static class NavigatorStatePersistenceStrategy implements StatePersistenceStrategy {
        private NavigatorStatePersistenceStrategy() {
        }

        @Override // com.zhuinden.simplestack.navigator.DefaultStateChanger.StatePersistenceStrategy
        public void persistViewToState(@Nonnull Object obj, @Nonnull View view) {
            Navigator.persistViewToState(view);
        }

        @Override // com.zhuinden.simplestack.navigator.DefaultStateChanger.StatePersistenceStrategy
        public void restoreViewFromState(@Nonnull Object obj, @Nonnull View view) {
            Navigator.restoreViewFromState(view);
        }
    }

    /* loaded from: classes2.dex */
    static class DefaultGetPreviousViewStrategy implements GetPreviousViewStrategy {
        private DefaultGetPreviousViewStrategy() {
        }

        @Override // com.zhuinden.simplestack.navigator.DefaultStateChanger.GetPreviousViewStrategy
        @Nullable
        public View getPreviousView(@Nonnull ViewGroup viewGroup, @Nonnull StateChange stateChange, @Nullable Object obj) {
            return viewGroup.getChildAt(0);
        }
    }

    /* loaded from: classes2.dex */
    static class DefaultContextCreationStrategy implements ContextCreationStrategy {
        private DefaultContextCreationStrategy() {
        }

        @Override // com.zhuinden.simplestack.navigator.DefaultStateChanger.ContextCreationStrategy
        @Nonnull
        public Context createContext(@Nonnull Context context, @Nonnull Object obj, @Nonnull ViewGroup viewGroup, @Nonnull StateChange stateChange) {
            return stateChange.createContext(context, obj);
        }
    }

    /* loaded from: classes2.dex */
    static class DefaultGetViewChangeHandlerStrategy implements GetViewChangeHandlerStrategy {
        private DefaultGetViewChangeHandlerStrategy() {
        }

        @Override // com.zhuinden.simplestack.navigator.DefaultStateChanger.GetViewChangeHandlerStrategy
        @Nonnull
        public ViewChangeHandler getViewChangeHandler(@Nonnull StateChange stateChange, @Nonnull ViewGroup viewGroup, @Nonnull Object obj, @Nonnull Object obj2, @Nonnull View view, @Nonnull View view2, int i) {
            if (i == 1) {
                return ((DefaultViewKey) obj2).viewChangeHandler();
            }
            if (i != -1) {
                return DefaultStateChanger.FADE_VIEW_CHANGE_HANDLER;
            }
            return ((DefaultViewKey) obj).viewChangeHandler();
        }
    }

    /* loaded from: classes2.dex */
    public static class Configurer {
        ContextCreationStrategy contextCreationStrategy;
        StateChanger externalStateChanger;
        GetPreviousViewStrategy getPreviousViewStrategy;
        GetViewChangeHandlerStrategy getViewChangeHandlerStrategy;
        LayoutInflationStrategy layoutInflationStrategy;
        StatePersistenceStrategy statePersistenceStrategy;
        ViewChangeCompletionListener viewChangeCompletionListener;
        ViewChangeStartListener viewChangeStartListener;

        private Configurer() {
            this.externalStateChanger = null;
            this.viewChangeStartListener = null;
            this.viewChangeCompletionListener = null;
            this.layoutInflationStrategy = null;
            this.statePersistenceStrategy = null;
            this.getPreviousViewStrategy = null;
            this.contextCreationStrategy = null;
            this.getViewChangeHandlerStrategy = null;
        }

        @Nonnull
        public Configurer setExternalStateChanger(@Nonnull StateChanger stateChanger) {
            if (stateChanger == null) {
                throw new NullPointerException("If set, external state changer cannot be null!");
            }
            this.externalStateChanger = stateChanger;
            return this;
        }

        @Nonnull
        public Configurer setViewChangeStartListener(@Nonnull ViewChangeStartListener viewChangeStartListener) {
            if (viewChangeStartListener == null) {
                throw new NullPointerException("If set, view change start listener cannot be null!");
            }
            this.viewChangeStartListener = viewChangeStartListener;
            return this;
        }

        @Nonnull
        public Configurer setViewChangeCompletionListener(@Nonnull ViewChangeCompletionListener viewChangeCompletionListener) {
            if (viewChangeCompletionListener == null) {
                throw new NullPointerException("If set, view change completion listener cannot be null!");
            }
            this.viewChangeCompletionListener = viewChangeCompletionListener;
            return this;
        }

        @Nonnull
        public Configurer setStatePersistenceStrategy(@Nonnull StatePersistenceStrategy statePersistenceStrategy) {
            if (statePersistenceStrategy == null) {
                throw new NullPointerException("If set, state persistence strategy cannot be null!");
            }
            this.statePersistenceStrategy = statePersistenceStrategy;
            return this;
        }

        @Nonnull
        public Configurer setLayoutInflationStrategy(@Nonnull LayoutInflationStrategy layoutInflationStrategy) {
            if (layoutInflationStrategy == null) {
                throw new NullPointerException("If set, layout inflation strategy cannot be null!");
            }
            this.layoutInflationStrategy = layoutInflationStrategy;
            return this;
        }

        @Nonnull
        public Configurer setGetPreviousViewStrategy(GetPreviousViewStrategy getPreviousViewStrategy) {
            if (getPreviousViewStrategy == null) {
                throw new NullPointerException("If set, get previous view strategy cannot be null!");
            }
            this.getPreviousViewStrategy = getPreviousViewStrategy;
            return this;
        }

        @Nonnull
        public Configurer setContextCreationStrategy(ContextCreationStrategy contextCreationStrategy) {
            if (contextCreationStrategy == null) {
                throw new NullPointerException("If set, create context strategy cannot be null!");
            }
            this.contextCreationStrategy = contextCreationStrategy;
            return this;
        }

        @Nonnull
        public Configurer setGetViewChangeHandlerStrategy(GetViewChangeHandlerStrategy getViewChangeHandlerStrategy) {
            if (getViewChangeHandlerStrategy == null) {
                throw new NullPointerException("If set, get view change handler strategy cannot be null!");
            }
            this.getViewChangeHandlerStrategy = getViewChangeHandlerStrategy;
            return this;
        }

        @Nonnull
        public DefaultStateChanger create(@Nonnull Context context, @Nonnull ViewGroup viewGroup) {
            return new DefaultStateChanger(context, viewGroup, this.externalStateChanger, this.viewChangeStartListener, this.viewChangeCompletionListener, this.layoutInflationStrategy, this.statePersistenceStrategy, this.getPreviousViewStrategy, this.contextCreationStrategy, this.getViewChangeHandlerStrategy);
        }
    }

    public static Configurer configure() {
        return new Configurer();
    }

    @Nonnull
    public static DefaultStateChanger create(Context context, ViewGroup viewGroup) {
        return new DefaultStateChanger(context, viewGroup, null, null, null, null, null, null, null, null);
    }

    DefaultStateChanger(@Nonnull Context context, @Nonnull ViewGroup viewGroup, @Nullable StateChanger stateChanger, ViewChangeStartListener viewChangeStartListener, @Nullable ViewChangeCompletionListener viewChangeCompletionListener, @Nullable LayoutInflationStrategy layoutInflationStrategy, @Nullable StatePersistenceStrategy statePersistenceStrategy, @Nullable GetPreviousViewStrategy getPreviousViewStrategy, @Nullable ContextCreationStrategy contextCreationStrategy, GetViewChangeHandlerStrategy getViewChangeHandlerStrategy) {
        if (context == null) {
            throw new NullPointerException("baseContext cannot be null");
        }
        if (viewGroup == null) {
            throw new NullPointerException("container cannot be null");
        }
        this.baseContext = context;
        this.container = viewGroup;
        this.externalStateChanger = stateChanger == null ? new NoOpStateChanger() : stateChanger;
        this.viewChangeStartListener = viewChangeStartListener == null ? new NoOpViewChangeStartListener() : viewChangeStartListener;
        this.viewChangeCompletionListener = viewChangeCompletionListener == null ? new NoOpViewChangeCompletionListener() : viewChangeCompletionListener;
        this.layoutInflationStrategy = layoutInflationStrategy == null ? new DefaultLayoutInflationStrategy() : layoutInflationStrategy;
        this.statePersistenceStrategy = statePersistenceStrategy == null ? new NavigatorStatePersistenceStrategy() : statePersistenceStrategy;
        this.getPreviousViewStrategy = getPreviousViewStrategy == null ? new DefaultGetPreviousViewStrategy() : getPreviousViewStrategy;
        this.contextCreationStrategy = contextCreationStrategy == null ? new DefaultContextCreationStrategy() : contextCreationStrategy;
        this.getViewChangeHandlerStrategy = getViewChangeHandlerStrategy == null ? new DefaultGetViewChangeHandlerStrategy() : getViewChangeHandlerStrategy;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void finishStateChange(StateChange stateChange, ViewGroup viewGroup, View view, View view2, final StateChanger.Callback callback) {
        this.viewChangeCompletionListener.handleViewChangeComplete(stateChange, viewGroup, view, view2, new ViewChangeCompletionListener.Callback() { // from class: com.zhuinden.simplestack.navigator.DefaultStateChanger.1
            @Override // com.zhuinden.simplestack.navigator.DefaultStateChanger.ViewChangeCompletionListener.Callback
            public void viewChangeComplete() {
                callback.stateChangeComplete();
            }
        });
    }

    @Override // com.zhuinden.simplestack.StateChanger
    public final void handleStateChange(@Nonnull final StateChange stateChange, @Nonnull final StateChanger.Callback callback) {
        this.externalStateChanger.handleStateChange(stateChange, new StateChanger.Callback() { // from class: com.zhuinden.simplestack.navigator.DefaultStateChanger.2
            @Override // com.zhuinden.simplestack.StateChanger.Callback
            public void stateChangeComplete() {
                if (stateChange.isTopNewKeyEqualToPrevious()) {
                    callback.stateChangeComplete();
                } else {
                    DefaultStateChanger.this.performViewChange(stateChange.topPreviousKey(), stateChange.topNewKey(), stateChange, callback);
                }
            }
        });
    }

    public final void performViewChange(@Nullable Object obj, @Nonnull Object obj2, @Nonnull StateChange stateChange, @Nonnull StateChanger.Callback callback) {
        performViewChange(obj, obj2, stateChange, stateChange.getDirection(), callback);
    }

    public final void performViewChange(@Nullable Object obj, @Nonnull Object obj2, @Nonnull StateChange stateChange, int i, @Nonnull StateChanger.Callback callback) {
        View previousView = this.getPreviousViewStrategy.getPreviousView(this.container, stateChange, obj);
        if (previousView != null && obj != null) {
            this.statePersistenceStrategy.persistViewToState(obj, previousView);
        }
        this.layoutInflationStrategy.inflateLayout(stateChange, obj2, this.contextCreationStrategy.createContext(stateChange.createContext(this.baseContext, obj2), obj2, this.container, stateChange), this.container, new AnonymousClass3(obj2, stateChange, previousView, callback, obj, i));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.zhuinden.simplestack.navigator.DefaultStateChanger$3  reason: invalid class name */
    /* loaded from: classes2.dex */
    public class AnonymousClass3 implements LayoutInflationStrategy.Callback {
        final /* synthetic */ StateChanger.Callback val$completionCallback;
        final /* synthetic */ int val$direction;
        final /* synthetic */ Object val$newKey;
        final /* synthetic */ Object val$previousKey;
        final /* synthetic */ View val$previousView;
        final /* synthetic */ StateChange val$stateChange;

        AnonymousClass3(Object obj, StateChange stateChange, View view, StateChanger.Callback callback, Object obj2, int i) {
            this.val$newKey = obj;
            this.val$stateChange = stateChange;
            this.val$previousView = view;
            this.val$completionCallback = callback;
            this.val$previousKey = obj2;
            this.val$direction = i;
        }

        @Override // com.zhuinden.simplestack.navigator.DefaultStateChanger.LayoutInflationStrategy.Callback
        public void layoutInflationComplete(@Nonnull final View view) {
            DefaultStateChanger.this.statePersistenceStrategy.restoreViewFromState(this.val$newKey, view);
            DefaultStateChanger.this.viewChangeStartListener.handleViewChangeStart(this.val$stateChange, DefaultStateChanger.this.container, this.val$previousView, view, new ViewChangeStartListener.Callback() { // from class: com.zhuinden.simplestack.navigator.DefaultStateChanger.3.1
                @Override // com.zhuinden.simplestack.navigator.DefaultStateChanger.ViewChangeStartListener.Callback
                public void startViewChange() {
                    if (AnonymousClass3.this.val$previousView == null) {
                        DefaultStateChanger.this.container.addView(view);
                        DefaultStateChanger.this.finishStateChange(AnonymousClass3.this.val$stateChange, DefaultStateChanger.this.container, AnonymousClass3.this.val$previousView, view, AnonymousClass3.this.val$completionCallback);
                        return;
                    }
                    DefaultStateChanger.this.getViewChangeHandlerStrategy.getViewChangeHandler(AnonymousClass3.this.val$stateChange, DefaultStateChanger.this.container, AnonymousClass3.this.val$previousKey, AnonymousClass3.this.val$newKey, AnonymousClass3.this.val$previousView, view, AnonymousClass3.this.val$direction).performViewChange(DefaultStateChanger.this.container, AnonymousClass3.this.val$previousView, view, AnonymousClass3.this.val$direction, new ViewChangeHandler.ViewChangeCallback() { // from class: com.zhuinden.simplestack.navigator.DefaultStateChanger.3.1.1
                        @Override // com.zhuinden.simplestack.navigator.ViewChangeHandler.ViewChangeCallback
                        public void onCompleted() {
                            DefaultStateChanger.this.finishStateChange(AnonymousClass3.this.val$stateChange, DefaultStateChanger.this.container, AnonymousClass3.this.val$previousView, view, AnonymousClass3.this.val$completionCallback);
                        }
                    });
                }
            });
        }
    }
}
