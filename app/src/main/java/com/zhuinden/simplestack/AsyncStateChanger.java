package com.zhuinden.simplestack;

import com.zhuinden.simplestack.StateChanger;
import javax.annotation.Nonnull;

/* loaded from: classes2.dex */
public class AsyncStateChanger implements StateChanger {
    private final NavigationHandler navigationHandler;

    /* loaded from: classes2.dex */
    public interface NavigationHandler {
        void onNavigationEvent(@Nonnull StateChange stateChange, @Nonnull StateChanger.Callback callback);
    }

    public AsyncStateChanger(@Nonnull NavigationHandler navigationHandler) {
        if (navigationHandler == null) {
            throw new NullPointerException("navigationHandler should not be null!");
        }
        this.navigationHandler = navigationHandler;
    }

    @Override // com.zhuinden.simplestack.StateChanger
    public void handleStateChange(@Nonnull StateChange stateChange, @Nonnull StateChanger.Callback callback) {
        if (stateChange.isTopNewKeyEqualToPrevious()) {
            callback.stateChangeComplete();
        } else {
            this.navigationHandler.onNavigationEvent(stateChange, callback);
        }
    }
}
