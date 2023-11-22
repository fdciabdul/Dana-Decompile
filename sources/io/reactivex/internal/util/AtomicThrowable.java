package io.reactivex.internal.util;

import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes6.dex */
public final class AtomicThrowable extends AtomicReference<Throwable> {
    private static final long serialVersionUID = 3949248817947090603L;

    public final boolean addThrowable(Throwable th) {
        return ExceptionHelper.getAuthRequestContext(this, th);
    }

    public final Throwable terminate() {
        return ExceptionHelper.getAuthRequestContext(this);
    }

    public final boolean isTerminated() {
        return get() == ExceptionHelper.KClassImpl$Data$declaredNonStaticMembers$2;
    }
}
