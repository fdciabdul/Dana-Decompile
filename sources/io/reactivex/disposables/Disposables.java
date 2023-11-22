package io.reactivex.disposables;

import io.reactivex.functions.Action;
import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.internal.functions.Functions;
import io.reactivex.internal.functions.ObjectHelper;

/* loaded from: classes.dex */
public final class Disposables {
    private Disposables() {
        throw new IllegalStateException("No instances!");
    }

    public static Disposable getAuthRequestContext(Runnable runnable) {
        ObjectHelper.PlaceComponentResult(runnable, "run is null");
        return new RunnableDisposable(runnable);
    }

    public static Disposable BuiltInFictitiousFunctionClassFactory(Action action) {
        ObjectHelper.PlaceComponentResult(action, "run is null");
        return new ActionDisposable(action);
    }

    public static Disposable getAuthRequestContext() {
        Runnable runnable = Functions.getErrorConfigVersion;
        ObjectHelper.PlaceComponentResult(runnable, "run is null");
        return new RunnableDisposable(runnable);
    }

    public static Disposable BuiltInFictitiousFunctionClassFactory() {
        return EmptyDisposable.INSTANCE;
    }
}
