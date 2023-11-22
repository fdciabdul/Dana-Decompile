package androidx.startup;

import android.content.Context;
import androidx.tracing.Trace;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* loaded from: classes.dex */
public final class AppInitializer {
    private static final Object BuiltInFictitiousFunctionClassFactory = new Object();
    private static volatile AppInitializer MyBillsEntityDataFactory;
    final Context getAuthRequestContext;
    final Set<Class<? extends Initializer<?>>> PlaceComponentResult = new HashSet();
    final Map<Class<?>, Object> KClassImpl$Data$declaredNonStaticMembers$2 = new HashMap();

    private AppInitializer(Context context) {
        this.getAuthRequestContext = context.getApplicationContext();
    }

    public static AppInitializer KClassImpl$Data$declaredNonStaticMembers$2(Context context) {
        if (MyBillsEntityDataFactory == null) {
            synchronized (BuiltInFictitiousFunctionClassFactory) {
                if (MyBillsEntityDataFactory == null) {
                    MyBillsEntityDataFactory = new AppInitializer(context);
                }
            }
        }
        return MyBillsEntityDataFactory;
    }

    public final boolean MyBillsEntityDataFactory(Class<? extends Initializer<?>> cls) {
        return this.PlaceComponentResult.contains(cls);
    }

    public final <T> T BuiltInFictitiousFunctionClassFactory(Class<? extends Initializer<?>> cls) {
        T t;
        synchronized (BuiltInFictitiousFunctionClassFactory) {
            t = (T) this.KClassImpl$Data$declaredNonStaticMembers$2.get(cls);
            if (t == null) {
                t = (T) PlaceComponentResult(cls, new HashSet());
            }
        }
        return t;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final <T> T PlaceComponentResult(Class<? extends Initializer<?>> cls, Set<Class<?>> set) {
        T t;
        if (Trace.PlaceComponentResult()) {
            try {
                Trace.KClassImpl$Data$declaredNonStaticMembers$2(cls.getSimpleName());
            } finally {
                Trace.MyBillsEntityDataFactory();
            }
        }
        if (set.contains(cls)) {
            throw new IllegalStateException(String.format("Cannot initialize %s. Cycle detected.", cls.getName()));
        }
        if (!this.KClassImpl$Data$declaredNonStaticMembers$2.containsKey(cls)) {
            set.add(cls);
            try {
                Initializer<?> newInstance = cls.getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
                List<Class<? extends Initializer<?>>> PlaceComponentResult = newInstance.PlaceComponentResult();
                if (!PlaceComponentResult.isEmpty()) {
                    for (Class<? extends Initializer<?>> cls2 : PlaceComponentResult) {
                        if (!this.KClassImpl$Data$declaredNonStaticMembers$2.containsKey(cls2)) {
                            PlaceComponentResult(cls2, set);
                        }
                    }
                }
                t = (T) newInstance.getAuthRequestContext(this.getAuthRequestContext);
                set.remove(cls);
                this.KClassImpl$Data$declaredNonStaticMembers$2.put(cls, t);
            } catch (Throwable th) {
                throw new StartupException(th);
            }
        } else {
            t = (T) this.KClassImpl$Data$declaredNonStaticMembers$2.get(cls);
        }
        return t;
    }
}
