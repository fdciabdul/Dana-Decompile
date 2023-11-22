package com.zhuinden.simplestack;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import android.view.View;
import com.zhuinden.simplestack.Backstack;
import com.zhuinden.simplestack.GlobalServices;
import com.zhuinden.statebundle.StateBundle;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;

@Deprecated
/* loaded from: classes2.dex */
public class BackstackDelegate {
    private static final String HISTORY = "simplestack.HISTORY";
    private static final String UNINITIALIZED = "";
    private Activity activity;
    private boolean activityWasDestroyed;
    private Backstack backstack;
    private GlobalServices.Factory globalServiceFactory;
    private GlobalServices globalServices;
    private KeyFilter keyFilter;
    private KeyParceler keyParceler;
    private String persistenceTag;
    private ScopedServices scopedServices;
    private List<Backstack.CompletionListener> stateChangeCompletionListeners;
    private StateChanger stateChanger;
    private Backstack.StateClearStrategy stateClearStrategy;

    public void setKeyFilter(@Nonnull KeyFilter keyFilter) {
        Backstack backstack = this.backstack;
        if (backstack != null && backstack.isInitialized()) {
            throw new IllegalStateException("If set, key filter must be set before calling `onCreate()`");
        }
        if (keyFilter == null) {
            throw new IllegalArgumentException("Specified custom key filter should not be null!");
        }
        this.keyFilter = keyFilter;
    }

    public void setKeyParceler(@Nonnull KeyParceler keyParceler) {
        Backstack backstack = this.backstack;
        if (backstack != null && backstack.isInitialized()) {
            throw new IllegalStateException("If set, key parceler must set before calling `onCreate()`");
        }
        if (keyParceler == null) {
            throw new IllegalArgumentException("Specified custom key parceler should not be null!");
        }
        this.keyParceler = keyParceler;
    }

    public void setStateClearStrategy(@Nonnull Backstack.StateClearStrategy stateClearStrategy) {
        Backstack backstack = this.backstack;
        if (backstack != null && backstack.isInitialized()) {
            throw new IllegalStateException("If set, state clear strategy must be set before calling `onCreate()`");
        }
        if (stateClearStrategy == null) {
            throw new IllegalArgumentException("Specified state clear strategy should not be null!");
        }
        this.stateClearStrategy = stateClearStrategy;
    }

    public void setScopedServices(@Nullable Activity activity, @Nonnull ScopedServices scopedServices) {
        Backstack backstack;
        this.activity = activity;
        if (scopedServices == null) {
            throw new IllegalArgumentException("Specified scoped services should not be null!");
        }
        if (!this.activityWasDestroyed && (backstack = this.backstack) != null && backstack.isInitialized()) {
            throw new IllegalStateException("If set, scoped services must set before calling `onCreate()`");
        }
        this.activityWasDestroyed = false;
        this.scopedServices = scopedServices;
    }

    public void setGlobalServices(@Nullable Activity activity, @Nonnull GlobalServices globalServices) {
        Backstack backstack;
        this.activity = activity;
        if (globalServices == null) {
            throw new IllegalArgumentException("Specified global services should not be null!");
        }
        if (!this.activityWasDestroyed && (backstack = this.backstack) != null && backstack.isInitialized()) {
            throw new IllegalStateException("If set, global services must set before calling `onCreate()`");
        }
        this.activityWasDestroyed = false;
        this.globalServices = globalServices;
    }

    public void setGlobalServices(@Nullable Activity activity, @Nonnull GlobalServices.Factory factory) {
        Backstack backstack;
        this.activity = activity;
        if (factory == null) {
            throw new IllegalArgumentException("Specified global service factory should not be null!");
        }
        if (!this.activityWasDestroyed && (backstack = this.backstack) != null && backstack.isInitialized()) {
            throw new IllegalStateException("If set, global service factory must set before calling `onCreate()`");
        }
        this.activityWasDestroyed = false;
        this.globalServiceFactory = factory;
    }

    public void addStateChangeCompletionListener(@Nonnull Backstack.CompletionListener completionListener) {
        Backstack backstack = this.backstack;
        if (backstack != null && backstack.isInitialized()) {
            throw new IllegalStateException("If adding, completion listener must be added before calling `onCreate()`");
        }
        if (completionListener == null) {
            throw new IllegalArgumentException("Specified state change completion listener should not be null!");
        }
        this.stateChangeCompletionListeners.add(completionListener);
    }

    public void setPersistenceTag(@Nonnull String str) {
        Backstack backstack = this.backstack;
        if (backstack != null && backstack.isInitialized()) {
            throw new IllegalStateException("Persistence tag should be set before calling `onCreate()`");
        }
        if (str == null) {
            throw new IllegalArgumentException("Null persistence tag is not allowed!");
        }
        String str2 = this.persistenceTag;
        if (str2 == "") {
            this.persistenceTag = str;
        } else if (!str2.equals(str)) {
            throw new IllegalStateException("The persistence tag cannot be set to a new value once it's already set!");
        }
    }

    String getHistoryTag() {
        if ("".equals(this.persistenceTag)) {
            return HISTORY;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(HISTORY);
        sb.append(this.persistenceTag);
        return sb.toString();
    }

    public BackstackDelegate() {
        this(null);
    }

    public BackstackDelegate(@Nullable StateChanger stateChanger) {
        this.persistenceTag = "";
        this.activityWasDestroyed = false;
        this.keyFilter = new DefaultKeyFilter();
        this.keyParceler = new DefaultKeyParceler();
        this.scopedServices = null;
        this.globalServices = null;
        this.globalServiceFactory = null;
        this.stateClearStrategy = new DefaultStateClearStrategy();
        this.stateChangeCompletionListeners = new LinkedList();
        this.stateChanger = stateChanger;
    }

    public void registerForLifecycleCallbacks(@Nonnull final Activity activity) {
        if (activity == null) {
            throw new NullPointerException("Activity is null");
        }
        getBackstack();
        final Application application = activity.getApplication();
        application.registerActivityLifecycleCallbacks(new Application.ActivityLifecycleCallbacks() { // from class: com.zhuinden.simplestack.BackstackDelegate.1
            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivityCreated(Activity activity2, Bundle bundle) {
            }

            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivityStarted(Activity activity2) {
            }

            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivityStopped(Activity activity2) {
            }

            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivityResumed(Activity activity2) {
                if (activity == activity2) {
                    BackstackDelegate.this.onPostResume();
                }
            }

            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivityPaused(Activity activity2) {
                if (activity == activity2) {
                    BackstackDelegate.this.onPause();
                }
            }

            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivitySaveInstanceState(Activity activity2, Bundle bundle) {
                if (activity == activity2) {
                    BackstackDelegate.this.onSaveInstanceState(bundle);
                }
            }

            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivityDestroyed(Activity activity2) {
                if (activity == activity2) {
                    BackstackDelegate.this.onDestroy();
                    application.unregisterActivityLifecycleCallbacks(this);
                }
            }
        });
    }

    public void onCreate(@Nullable Bundle bundle, @Nullable Object obj, @Nonnull List<?> list) {
        if (obj != null && !(obj instanceof NonConfigurationInstance)) {
            throw new IllegalArgumentException("The provided non configuration instance must be of type BackstackDelegate.NonConfigurationInstance!");
        }
        NonConfigurationInstance nonConfigurationInstance = (NonConfigurationInstance) obj;
        if (nonConfigurationInstance != null) {
            this.backstack = nonConfigurationInstance.getBackstack();
        }
        if (this.backstack == null) {
            Backstack backstack = new Backstack();
            this.backstack = backstack;
            backstack.setKeyFilter(this.keyFilter);
            this.backstack.setKeyParceler(this.keyParceler);
            this.backstack.setStateClearStrategy(this.stateClearStrategy);
            ScopedServices scopedServices = this.scopedServices;
            if (scopedServices != null) {
                this.backstack.setScopedServices(scopedServices);
            }
            GlobalServices globalServices = this.globalServices;
            if (globalServices != null) {
                this.backstack.setGlobalServices(globalServices);
            }
            GlobalServices.Factory factory = this.globalServiceFactory;
            if (factory != null) {
                this.backstack.setGlobalServices(factory);
            }
            this.backstack.setup(list);
            Iterator<Backstack.CompletionListener> it = this.stateChangeCompletionListeners.iterator();
            while (it.hasNext()) {
                this.backstack.addStateChangeCompletionListener(it.next());
            }
            if (bundle != null) {
                this.backstack.fromBundle((StateBundle) bundle.getParcelable(getHistoryTag()));
            }
        }
        this.backstack.setStateChanger(this.stateChanger);
    }

    public void setStateChanger(@Nullable StateChanger stateChanger) {
        this.stateChanger = stateChanger;
        Backstack backstack = this.backstack;
        if (backstack != null) {
            backstack.setStateChanger(stateChanger);
        }
    }

    public NonConfigurationInstance onRetainCustomNonConfigurationInstance() {
        return new NonConfigurationInstance(this.backstack);
    }

    public boolean onBackPressed() {
        return getBackstack().goBack();
    }

    public void onSaveInstanceState(@Nonnull Bundle bundle) {
        bundle.putParcelable(getHistoryTag(), getBackstack().toBundle());
    }

    public void onPostResume() {
        if (this.stateChanger == null) {
            throw new IllegalStateException("State changer is still not set in `onPostResume`!");
        }
        getBackstack().reattachStateChanger();
    }

    public void onPause() {
        getBackstack().detachStateChanger();
    }

    public void onDestroy() {
        this.activityWasDestroyed = true;
        getBackstack().executePendingStateChange();
        Activity activity = this.activity;
        if (activity == null || (activity != null && activity.isFinishing())) {
            getBackstack().finalizeScopes();
        }
        this.activity = null;
    }

    public void persistViewToState(@Nullable View view) {
        getBackstack().persistViewToState(view);
    }

    public void restoreViewFromState(@Nonnull View view) {
        getBackstack().restoreViewFromState(view);
    }

    @Nonnull
    public SavedState getSavedState(@Nonnull Object obj) {
        return getBackstack().getSavedState(obj);
    }

    public boolean hasScope(@Nonnull String str) {
        return getBackstack().hasScope(str);
    }

    public boolean hasService(@Nonnull ScopeKey scopeKey, @Nonnull String str) {
        return getBackstack().hasService(scopeKey, str);
    }

    public boolean hasService(@Nonnull String str, @Nonnull String str2) {
        return getBackstack().hasService(str, str2);
    }

    @Nonnull
    public <T> T getService(@Nonnull ScopeKey scopeKey, @Nonnull String str) {
        return (T) getBackstack().getService(scopeKey, str);
    }

    @Nonnull
    public <T> T getService(@Nonnull String str, @Nonnull String str2) {
        return (T) getBackstack().getService(str, str2);
    }

    public boolean canFindService(@Nonnull String str) {
        return getBackstack().canFindService(str);
    }

    @Nonnull
    public <T> T lookupService(@Nonnull String str) {
        return (T) getBackstack().lookupService(str);
    }

    @Nonnull
    public List<String> findScopesForKey(@Nonnull Object obj, @Nonnull ScopeLookupMode scopeLookupMode) {
        return getBackstack().findScopesForKey(obj, scopeLookupMode);
    }

    public boolean canFindFromScope(@Nonnull String str, @Nonnull String str2) {
        return getBackstack().canFindFromScope(str, str2);
    }

    public boolean canFindFromScope(@Nonnull String str, @Nonnull String str2, @Nonnull ScopeLookupMode scopeLookupMode) {
        return getBackstack().canFindFromScope(str, str2, scopeLookupMode);
    }

    @Nonnull
    public <T> T lookupFromScope(@Nonnull String str, @Nonnull String str2) {
        return (T) getBackstack().lookupFromScope(str, str2);
    }

    @Nonnull
    public <T> T lookupFromScope(@Nonnull String str, @Nonnull String str2, @Nonnull ScopeLookupMode scopeLookupMode) {
        return (T) getBackstack().lookupFromScope(str, str2, scopeLookupMode);
    }

    @Nonnull
    public Backstack getBackstack() {
        Backstack backstack = this.backstack;
        if (backstack != null) {
            return backstack;
        }
        throw new IllegalStateException("This method can only be called after calling `onCreate()`");
    }

    /* loaded from: classes2.dex */
    public static class NonConfigurationInstance {
        private Backstack backstack;

        NonConfigurationInstance(Backstack backstack) {
            this.backstack = backstack;
        }

        Backstack getBackstack() {
            return this.backstack;
        }
    }
}
