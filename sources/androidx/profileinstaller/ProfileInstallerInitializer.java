package androidx.profileinstaller;

import android.content.Context;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.view.Choreographer;
import androidx.profileinstaller.ProfileInstallerInitializer;
import androidx.startup.Initializer;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* loaded from: classes6.dex */
public class ProfileInstallerInitializer implements Initializer<Result> {

    /* loaded from: classes6.dex */
    public static class Result {
    }

    @Override // androidx.startup.Initializer
    public List<Class<? extends Initializer<?>>> PlaceComponentResult() {
        return Collections.emptyList();
    }

    /* loaded from: classes6.dex */
    static class Choreographer16Impl {
        private Choreographer16Impl() {
        }

        public static void MyBillsEntityDataFactory(final Runnable runnable) {
            Choreographer.getInstance().postFrameCallback(new Choreographer.FrameCallback() { // from class: androidx.profileinstaller.ProfileInstallerInitializer$Choreographer16Impl$$ExternalSyntheticLambda0
                @Override // android.view.Choreographer.FrameCallback
                public final void doFrame(long j) {
                    runnable.run();
                }
            });
        }
    }

    /* loaded from: classes6.dex */
    static class Handler28Impl {
        private Handler28Impl() {
        }

        public static Handler getAuthRequestContext(Looper looper) {
            return Handler.createAsync(looper);
        }
    }

    @Override // androidx.startup.Initializer
    public /* synthetic */ Result getAuthRequestContext(Context context) {
        if (Build.VERSION.SDK_INT < 24) {
            return new Result();
        }
        final Context applicationContext = context.getApplicationContext();
        Choreographer16Impl.MyBillsEntityDataFactory(new Runnable() { // from class: androidx.profileinstaller.ProfileInstallerInitializer$$ExternalSyntheticLambda1
            @Override // java.lang.Runnable
            public final void run() {
                Handler handler;
                final Context context2 = applicationContext;
                if (Build.VERSION.SDK_INT >= 28) {
                    handler = ProfileInstallerInitializer.Handler28Impl.getAuthRequestContext(Looper.getMainLooper());
                } else {
                    handler = new Handler(Looper.getMainLooper());
                }
                handler.postDelayed(new Runnable() { // from class: androidx.profileinstaller.ProfileInstallerInitializer$$ExternalSyntheticLambda0
                    @Override // java.lang.Runnable
                    public final void run() {
                        new ThreadPoolExecutor(0, 1, 0L, TimeUnit.MILLISECONDS, new LinkedBlockingQueue()).execute(new Runnable() { // from class: androidx.profileinstaller.ProfileInstallerInitializer$$ExternalSyntheticLambda2
                            @Override // java.lang.Runnable
                            public final void run() {
                                ProfileInstaller.PlaceComponentResult(r1);
                            }
                        });
                    }
                }, new Random().nextInt(Math.max(1000, 1)) + 5000);
            }
        });
        return new Result();
    }
}
