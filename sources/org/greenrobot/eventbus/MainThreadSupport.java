package org.greenrobot.eventbus;

/* loaded from: classes2.dex */
public interface MainThreadSupport {
    Poster createPoster(EventBus eventBus);

    boolean isMainThread();
}
