package androidx.dynamicanimation.animation;

import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.view.Choreographer;
import androidx.collection.SimpleArrayMap;
import java.util.ArrayList;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes3.dex */
public class AnimationHandler {
    public static final ThreadLocal<AnimationHandler> MyBillsEntityDataFactory = new ThreadLocal<>();
    private AnimationFrameCallbackProvider scheduleImpl;
    final SimpleArrayMap<AnimationFrameCallback, Long> PlaceComponentResult = new SimpleArrayMap<>();
    final ArrayList<AnimationFrameCallback> KClassImpl$Data$declaredNonStaticMembers$2 = new ArrayList<>();
    private final AnimationCallbackDispatcher getErrorConfigVersion = new AnimationCallbackDispatcher();
    long getAuthRequestContext = 0;
    boolean BuiltInFictitiousFunctionClassFactory = false;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public interface AnimationFrameCallback {
        boolean getAuthRequestContext(long j);
    }

    AnimationHandler() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public class AnimationCallbackDispatcher {
        AnimationCallbackDispatcher() {
        }

        final void PlaceComponentResult() {
            AnimationHandler.this.getAuthRequestContext = SystemClock.uptimeMillis();
            AnimationHandler animationHandler = AnimationHandler.this;
            long j = animationHandler.getAuthRequestContext;
            long uptimeMillis = SystemClock.uptimeMillis();
            for (int i = 0; i < animationHandler.KClassImpl$Data$declaredNonStaticMembers$2.size(); i++) {
                AnimationFrameCallback animationFrameCallback = animationHandler.KClassImpl$Data$declaredNonStaticMembers$2.get(i);
                if (animationFrameCallback != null && animationHandler.KClassImpl$Data$declaredNonStaticMembers$2(animationFrameCallback, uptimeMillis)) {
                    animationFrameCallback.getAuthRequestContext(j);
                }
            }
            if (animationHandler.BuiltInFictitiousFunctionClassFactory) {
                for (int size = animationHandler.KClassImpl$Data$declaredNonStaticMembers$2.size() - 1; size >= 0; size--) {
                    if (animationHandler.KClassImpl$Data$declaredNonStaticMembers$2.get(size) == null) {
                        animationHandler.KClassImpl$Data$declaredNonStaticMembers$2.remove(size);
                    }
                }
                animationHandler.BuiltInFictitiousFunctionClassFactory = false;
            }
            if (AnimationHandler.this.KClassImpl$Data$declaredNonStaticMembers$2.size() > 0) {
                AnimationHandler.this.KClassImpl$Data$declaredNonStaticMembers$2().getAuthRequestContext();
            }
        }
    }

    public static AnimationHandler BuiltInFictitiousFunctionClassFactory() {
        ThreadLocal<AnimationHandler> threadLocal = MyBillsEntityDataFactory;
        if (threadLocal.get() == null) {
            threadLocal.set(new AnimationHandler());
        }
        return threadLocal.get();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final AnimationFrameCallbackProvider KClassImpl$Data$declaredNonStaticMembers$2() {
        if (this.scheduleImpl == null) {
            if (Build.VERSION.SDK_INT >= 16) {
                this.scheduleImpl = new FrameCallbackProvider16(this.getErrorConfigVersion);
            } else {
                this.scheduleImpl = new FrameCallbackProvider14(this.getErrorConfigVersion);
            }
        }
        return this.scheduleImpl;
    }

    final boolean KClassImpl$Data$declaredNonStaticMembers$2(AnimationFrameCallback animationFrameCallback, long j) {
        Long l = this.PlaceComponentResult.get(animationFrameCallback);
        if (l == null) {
            return true;
        }
        if (l.longValue() < j) {
            this.PlaceComponentResult.remove(animationFrameCallback);
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public static class FrameCallbackProvider16 extends AnimationFrameCallbackProvider {
        private final Choreographer.FrameCallback BuiltInFictitiousFunctionClassFactory;
        private final Choreographer PlaceComponentResult;

        FrameCallbackProvider16(AnimationCallbackDispatcher animationCallbackDispatcher) {
            super(animationCallbackDispatcher);
            this.PlaceComponentResult = Choreographer.getInstance();
            this.BuiltInFictitiousFunctionClassFactory = new Choreographer.FrameCallback() { // from class: androidx.dynamicanimation.animation.AnimationHandler.FrameCallbackProvider16.1
                @Override // android.view.Choreographer.FrameCallback
                public void doFrame(long j) {
                    FrameCallbackProvider16.this.MyBillsEntityDataFactory.PlaceComponentResult();
                }
            };
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // androidx.dynamicanimation.animation.AnimationHandler.AnimationFrameCallbackProvider
        public final void getAuthRequestContext() {
            this.PlaceComponentResult.postFrameCallback(this.BuiltInFictitiousFunctionClassFactory);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public static class FrameCallbackProvider14 extends AnimationFrameCallbackProvider {
        long KClassImpl$Data$declaredNonStaticMembers$2;
        private final Runnable PlaceComponentResult;
        private final Handler getAuthRequestContext;

        FrameCallbackProvider14(AnimationCallbackDispatcher animationCallbackDispatcher) {
            super(animationCallbackDispatcher);
            this.KClassImpl$Data$declaredNonStaticMembers$2 = -1L;
            this.PlaceComponentResult = new Runnable() { // from class: androidx.dynamicanimation.animation.AnimationHandler.FrameCallbackProvider14.1
                @Override // java.lang.Runnable
                public void run() {
                    FrameCallbackProvider14.this.KClassImpl$Data$declaredNonStaticMembers$2 = SystemClock.uptimeMillis();
                    FrameCallbackProvider14.this.MyBillsEntityDataFactory.PlaceComponentResult();
                }
            };
            this.getAuthRequestContext = new Handler(Looper.myLooper());
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // androidx.dynamicanimation.animation.AnimationHandler.AnimationFrameCallbackProvider
        public final void getAuthRequestContext() {
            this.getAuthRequestContext.postDelayed(this.PlaceComponentResult, Math.max(10 - (SystemClock.uptimeMillis() - this.KClassImpl$Data$declaredNonStaticMembers$2), 0L));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public static abstract class AnimationFrameCallbackProvider {
        final AnimationCallbackDispatcher MyBillsEntityDataFactory;

        /* JADX INFO: Access modifiers changed from: package-private */
        public abstract void getAuthRequestContext();

        AnimationFrameCallbackProvider(AnimationCallbackDispatcher animationCallbackDispatcher) {
            this.MyBillsEntityDataFactory = animationCallbackDispatcher;
        }
    }
}
