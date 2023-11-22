package io.reactivex.android.schedulers;

import android.os.Handler;
import android.os.Looper;
import io.reactivex.Scheduler;
import io.reactivex.android.plugins.RxAndroidPlugins;
import java.util.concurrent.Callable;

/* loaded from: classes.dex */
public final class AndroidSchedulers {
    private static final Scheduler BuiltInFictitiousFunctionClassFactory = RxAndroidPlugins.PlaceComponentResult(new Callable<Scheduler>() { // from class: io.reactivex.android.schedulers.AndroidSchedulers.1
        @Override // java.util.concurrent.Callable
        public final /* bridge */ /* synthetic */ Scheduler call() throws Exception {
            return MainHolder.MyBillsEntityDataFactory;
        }
    });

    /* loaded from: classes.dex */
    static final class MainHolder {
        static final Scheduler MyBillsEntityDataFactory = new HandlerScheduler(new Handler(Looper.getMainLooper()));

        private MainHolder() {
        }
    }

    public static Scheduler PlaceComponentResult() {
        return RxAndroidPlugins.getAuthRequestContext(BuiltInFictitiousFunctionClassFactory);
    }

    private AndroidSchedulers() {
        throw new AssertionError("No instances.");
    }
}
