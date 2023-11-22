package com.zhuinden.simplestack.navigator;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.view.View;
import android.view.ViewGroup;
import com.zhuinden.simplestack.Backstack;
import com.zhuinden.simplestack.DefaultKeyFilter;
import com.zhuinden.simplestack.DefaultKeyParceler;
import com.zhuinden.simplestack.DefaultStateClearStrategy;
import com.zhuinden.simplestack.GlobalServices;
import com.zhuinden.simplestack.KeyFilter;
import com.zhuinden.simplestack.KeyParceler;
import com.zhuinden.simplestack.SavedState;
import com.zhuinden.simplestack.ScopeKey;
import com.zhuinden.simplestack.ScopeLookupMode;
import com.zhuinden.simplestack.ScopedServices;
import com.zhuinden.simplestack.StateChanger;
import java.util.LinkedList;
import java.util.List;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;

/* loaded from: classes2.dex */
public class Navigator {
    private Navigator() {
    }

    /* loaded from: classes2.dex */
    public static class Installer {
        StateChanger stateChanger;
        KeyFilter keyFilter = new DefaultKeyFilter();
        KeyParceler keyParceler = new DefaultKeyParceler();
        Backstack.StateClearStrategy stateClearStrategy = new DefaultStateClearStrategy();
        ScopedServices scopedServices = null;
        GlobalServices globalServices = null;
        GlobalServices.Factory globalServiceFactory = null;
        boolean isInitializeDeferred = false;
        boolean shouldPersistContainerChild = false;
        List<Backstack.CompletionListener> stateChangeCompletionListeners = new LinkedList();

        @Nonnull
        public Installer setStateChanger(@Nonnull StateChanger stateChanger) {
            if (stateChanger == null) {
                throw new IllegalArgumentException("If set, StateChanger cannot be null!");
            }
            this.stateChanger = stateChanger;
            return this;
        }

        @Nonnull
        public Installer setKeyFilter(@Nonnull KeyFilter keyFilter) {
            if (keyFilter == null) {
                throw new IllegalArgumentException("If set, KeyFilter cannot be null!");
            }
            this.keyFilter = keyFilter;
            return this;
        }

        @Nonnull
        public Installer setKeyParceler(@Nonnull KeyParceler keyParceler) {
            if (keyParceler == null) {
                throw new IllegalArgumentException("If set, KeyParceler cannot be null!");
            }
            this.keyParceler = keyParceler;
            return this;
        }

        @Nonnull
        public Installer setStateClearStrategy(@Nonnull Backstack.StateClearStrategy stateClearStrategy) {
            if (stateClearStrategy == null) {
                throw new IllegalArgumentException("If set, StateClearStrategy cannot be null!");
            }
            this.stateClearStrategy = stateClearStrategy;
            return this;
        }

        @Nonnull
        public Installer setScopedServices(@Nonnull ScopedServices scopedServices) {
            if (scopedServices == null) {
                throw new IllegalArgumentException("If set, scoped services cannot be null!");
            }
            this.scopedServices = scopedServices;
            return this;
        }

        @Nonnull
        public Installer setGlobalServices(@Nonnull GlobalServices globalServices) {
            if (globalServices == null) {
                throw new IllegalArgumentException("If set, global services cannot be null!");
            }
            this.globalServices = globalServices;
            return this;
        }

        @Nonnull
        public Installer setGlobalServices(@Nonnull GlobalServices.Factory factory) {
            if (factory == null) {
                throw new IllegalArgumentException("If set, global service factory cannot be null!");
            }
            this.globalServiceFactory = factory;
            return this;
        }

        @Nonnull
        public Installer setDeferredInitialization(boolean z) {
            this.isInitializeDeferred = z;
            return this;
        }

        @Nonnull
        public Installer setShouldPersistContainerChild(boolean z) {
            this.shouldPersistContainerChild = z;
            return this;
        }

        @Nonnull
        public Installer addStateChangeCompletionListener(@Nonnull Backstack.CompletionListener completionListener) {
            if (completionListener == null) {
                throw new IllegalArgumentException("If added, state change completion listener cannot be null!");
            }
            this.stateChangeCompletionListeners.add(completionListener);
            return this;
        }

        @Nonnull
        public Backstack install(@Nonnull Activity activity, @Nonnull ViewGroup viewGroup, @Nonnull List<?> list) {
            if (this.stateChanger == null) {
                this.shouldPersistContainerChild = true;
                this.stateChanger = DefaultStateChanger.create(activity, viewGroup);
            }
            return Navigator.install(this, activity, viewGroup, list);
        }
    }

    @Nonnull
    public static Installer configure() {
        return new Installer();
    }

    @Nonnull
    public static void install(@Nonnull Activity activity, @Nonnull ViewGroup viewGroup, @Nonnull List<?> list) {
        configure().install(activity, viewGroup, list);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static Backstack install(Installer installer, @Nonnull Activity activity, @Nonnull ViewGroup viewGroup, @Nonnull List<?> list) {
        if (activity != null) {
            if (viewGroup == null) {
                throw new IllegalArgumentException("Container cannot be null!");
            }
            if (list == null || list.isEmpty()) {
                throw new IllegalArgumentException("Initial keys cannot be null!");
            }
            BackstackHost findBackstackHost = findBackstackHost(activity);
            if (findBackstackHost == null) {
                findBackstackHost = new BackstackHost();
                activity.getFragmentManager().beginTransaction().add(findBackstackHost, "NAVIGATOR_BACKSTACK_HOST").commit();
                activity.getFragmentManager().executePendingTransactions();
            }
            findBackstackHost.stateChanger = installer.stateChanger;
            findBackstackHost.keyFilter = installer.keyFilter;
            findBackstackHost.keyParceler = installer.keyParceler;
            findBackstackHost.stateClearStrategy = installer.stateClearStrategy;
            findBackstackHost.scopedServices = installer.scopedServices;
            findBackstackHost.globalServices = installer.globalServices;
            findBackstackHost.globalServiceFactory = installer.globalServiceFactory;
            findBackstackHost.stateChangeCompletionListeners = installer.stateChangeCompletionListeners;
            findBackstackHost.shouldPersistContainerChild = installer.shouldPersistContainerChild;
            findBackstackHost.container = viewGroup;
            findBackstackHost.initialKeys = list;
            return findBackstackHost.initialize(installer.isInitializeDeferred);
        }
        throw new IllegalArgumentException("Activity cannot be null!");
    }

    public static void executeDeferredInitialization(@Nonnull Context context) {
        findBackstackHost(findActivity(context)).initialize(false);
    }

    public static boolean onBackPressed(@Nonnull Context context) {
        return getBackstack(context).goBack();
    }

    public static boolean hasScope(@Nonnull Context context, @Nonnull String str) {
        return getBackstack(context).hasScope(str);
    }

    public static boolean hasService(@Nonnull Context context, @Nonnull ScopeKey scopeKey, @Nonnull String str) {
        return getBackstack(context).hasService(scopeKey, str);
    }

    public static boolean hasService(@Nonnull Context context, @Nonnull String str, @Nonnull String str2) {
        return getBackstack(context).hasService(str, str2);
    }

    @Nonnull
    public static <T> T getService(@Nonnull Context context, @Nonnull ScopeKey scopeKey, @Nonnull String str) {
        return (T) getBackstack(context).getService(scopeKey, str);
    }

    @Nonnull
    public static <T> T getService(@Nonnull Context context, @Nonnull String str, @Nonnull String str2) {
        return (T) getBackstack(context).getService(str, str2);
    }

    public static boolean canFindService(@Nonnull Context context, @Nonnull String str) {
        return getBackstack(context).canFindService(str);
    }

    @Nonnull
    public static <T> T lookupService(@Nonnull Context context, @Nonnull String str) {
        return (T) getBackstack(context).lookupService(str);
    }

    @Nonnull
    public static List<String> findScopesForKey(@Nonnull Context context, @Nonnull Object obj, @Nonnull ScopeLookupMode scopeLookupMode) {
        return getBackstack(context).findScopesForKey(obj, scopeLookupMode);
    }

    public static boolean canFindFromScope(@Nonnull Context context, @Nonnull String str, @Nonnull String str2) {
        return getBackstack(context).canFindFromScope(str, str2);
    }

    public static boolean canFindFromScope(@Nonnull Context context, @Nonnull String str, @Nonnull String str2, @Nonnull ScopeLookupMode scopeLookupMode) {
        return getBackstack(context).canFindFromScope(str, str2, scopeLookupMode);
    }

    @Nonnull
    public static <T> T lookupFromScope(@Nonnull Context context, @Nonnull String str, @Nonnull String str2) {
        return (T) getBackstack(context).lookupFromScope(str, str2);
    }

    @Nonnull
    public static <T> T lookupFromScope(@Nonnull Context context, @Nonnull String str, @Nonnull String str2, @Nonnull ScopeLookupMode scopeLookupMode) {
        return (T) getBackstack(context).lookupFromScope(str, str2, scopeLookupMode);
    }

    @Nonnull
    public static Backstack getBackstack(@Nonnull Context context) {
        return getBackstackHost(context).getBackstack();
    }

    public static void persistViewToState(@Nullable View view) {
        if (view != null) {
            getBackstackHost(view.getContext()).getBackstack().persistViewToState(view);
        }
    }

    public static void restoreViewFromState(@Nonnull View view) {
        if (view == null) {
            throw new NullPointerException("You cannot restore state into null view!");
        }
        getBackstackHost(view.getContext()).getBackstack().restoreViewFromState(view);
    }

    @Nonnull
    public static SavedState getSavedState(@Nonnull Context context, @Nonnull Object obj) {
        if (context != null) {
            if (obj == null) {
                throw new NullPointerException("key cannot be null");
            }
            return getBackstackHost(context).getBackstack().getSavedState(obj);
        }
        throw new NullPointerException("context cannot be null");
    }

    public static boolean isNavigatorAvailable(@Nonnull Activity activity) {
        return findBackstackHost(activity) != null;
    }

    private static BackstackHost findBackstackHost(Activity activity) {
        return (BackstackHost) activity.getFragmentManager().findFragmentByTag("NAVIGATOR_BACKSTACK_HOST");
    }

    @Nonnull
    public static <T extends Activity> T findActivity(@Nonnull Context context) {
        while (context != null) {
            if (context instanceof Activity) {
                return (T) context;
            }
            context = ((ContextWrapper) context).getBaseContext();
            if (context == null) {
                throw new IllegalStateException("Activity was not found as base context of view!");
            }
        }
        throw new IllegalArgumentException("Context cannot be null!");
    }

    private static BackstackHost getBackstackHost(Context context) {
        return findBackstackHost(findActivity(context));
    }
}
