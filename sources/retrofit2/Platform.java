package retrofit2;

import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import java.lang.invoke.MethodHandles;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Executor;
import javax.annotation.Nullable;
import retrofit2.CallAdapter;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes6.dex */
public class Platform {
    private static final Platform getAuthRequestContext;
    final boolean BuiltInFictitiousFunctionClassFactory;
    @Nullable
    private final Constructor<MethodHandles.Lookup> KClassImpl$Data$declaredNonStaticMembers$2;

    /* JADX INFO: Access modifiers changed from: package-private */
    @Nullable
    public Executor getAuthRequestContext() {
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Platform MyBillsEntityDataFactory() {
        return getAuthRequestContext;
    }

    Platform(boolean z) {
        this.BuiltInFictitiousFunctionClassFactory = z;
        Constructor<MethodHandles.Lookup> constructor = null;
        if (z) {
            try {
                constructor = MethodHandles.Lookup.class.getDeclaredConstructor(Class.class, Integer.TYPE);
                constructor.setAccessible(true);
            } catch (NoClassDefFoundError | NoSuchMethodException unused) {
            }
        }
        this.KClassImpl$Data$declaredNonStaticMembers$2 = constructor;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final List<? extends CallAdapter.Factory> getAuthRequestContext(@Nullable Executor executor) {
        DefaultCallAdapterFactory defaultCallAdapterFactory = new DefaultCallAdapterFactory(executor);
        return this.BuiltInFictitiousFunctionClassFactory ? Arrays.asList(CompletableFutureCallAdapterFactory.MyBillsEntityDataFactory, defaultCallAdapterFactory) : Collections.singletonList(defaultCallAdapterFactory);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean PlaceComponentResult(Method method) {
        return this.BuiltInFictitiousFunctionClassFactory && method.isDefault();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Nullable
    public Object MyBillsEntityDataFactory(Method method, Class<?> cls, Object obj, Object... objArr) throws Throwable {
        Constructor<MethodHandles.Lookup> constructor = this.KClassImpl$Data$declaredNonStaticMembers$2;
        return (constructor != null ? constructor.newInstance(cls, -1) : MethodHandles.lookup()).unreflectSpecial(method, cls).bindTo(obj).invokeWithArguments(objArr);
    }

    /* loaded from: classes6.dex */
    static final class Android extends Platform {
        Android() {
            super(Build.VERSION.SDK_INT >= 24);
        }

        @Override // retrofit2.Platform
        public final Executor getAuthRequestContext() {
            return new MainThreadExecutor();
        }

        @Override // retrofit2.Platform
        @Nullable
        final Object MyBillsEntityDataFactory(Method method, Class<?> cls, Object obj, Object... objArr) throws Throwable {
            if (Build.VERSION.SDK_INT < 26) {
                throw new UnsupportedOperationException("Calling default methods on API 24 and 25 is not supported");
            }
            return super.MyBillsEntityDataFactory(method, cls, obj, objArr);
        }

        /* loaded from: classes6.dex */
        static final class MainThreadExecutor implements Executor {
            private final Handler MyBillsEntityDataFactory = new Handler(Looper.getMainLooper());

            MainThreadExecutor() {
            }

            @Override // java.util.concurrent.Executor
            public final void execute(Runnable runnable) {
                this.MyBillsEntityDataFactory.post(runnable);
            }
        }
    }

    static {
        Platform platform;
        if ("Dalvik".equals(System.getProperty("java.vm.name"))) {
            platform = new Android();
        } else {
            platform = new Platform(true);
        }
        getAuthRequestContext = platform;
    }
}
