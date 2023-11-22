package org.greenrobot.eventbus.android;

import android.os.Looper;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.HandlerPoster;
import org.greenrobot.eventbus.MainThreadSupport;
import org.greenrobot.eventbus.Poster;

/* loaded from: classes6.dex */
public class DefaultAndroidMainThreadSupport implements MainThreadSupport {
    @Override // org.greenrobot.eventbus.MainThreadSupport
    public boolean isMainThread() {
        return Looper.getMainLooper() == Looper.myLooper();
    }

    @Override // org.greenrobot.eventbus.MainThreadSupport
    public Poster createPoster(EventBus eventBus) {
        return new HandlerPoster(eventBus, Looper.getMainLooper(), 10);
    }
}
