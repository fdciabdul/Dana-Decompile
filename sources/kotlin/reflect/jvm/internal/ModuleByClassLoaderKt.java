package kotlin.reflect.jvm.internal;

import j$.util.concurrent.ConcurrentHashMap;
import java.lang.ref.WeakReference;
import java.util.concurrent.ConcurrentMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.runtime.components.RuntimeModuleData;
import kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.ReflectClassUtilKt;

@Metadata(d1 = {"\u0000$\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u000f\u0010\u0001\u001a\u00020\u0000H\u0000¢\u0006\u0004\b\u0001\u0010\u0002\u001a\u0017\u0010\u0005\u001a\u00020\u0004*\u0006\u0012\u0002\b\u00030\u0003H\u0000¢\u0006\u0004\b\u0005\u0010\u0006\"&\u0010\n\u001a\u0014\u0012\u0004\u0012\u00020\b\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\t0\u00078\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\n\u0010\u000b"}, d2 = {"", "clearModuleByClassLoaderCache", "()V", "Ljava/lang/Class;", "Lkotlin/reflect/jvm/internal/impl/descriptors/runtime/components/RuntimeModuleData;", "getOrCreateModule", "(Ljava/lang/Class;)Lkotlin/reflect/jvm/internal/impl/descriptors/runtime/components/RuntimeModuleData;", "Ljava/util/concurrent/ConcurrentMap;", "Lkotlin/reflect/jvm/internal/WeakClassLoaderBox;", "Ljava/lang/ref/WeakReference;", "moduleByClassLoader", "Ljava/util/concurrent/ConcurrentMap;"}, k = 2, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes.dex */
public final class ModuleByClassLoaderKt {
    private static final ConcurrentMap<WeakClassLoaderBox, WeakReference<RuntimeModuleData>> moduleByClassLoader = new ConcurrentHashMap();

    public static final RuntimeModuleData getOrCreateModule(Class<?> cls) {
        Intrinsics.checkNotNullParameter(cls, "");
        ClassLoader safeClassLoader = ReflectClassUtilKt.getSafeClassLoader(cls);
        WeakClassLoaderBox weakClassLoaderBox = new WeakClassLoaderBox(safeClassLoader);
        ConcurrentMap<WeakClassLoaderBox, WeakReference<RuntimeModuleData>> concurrentMap = moduleByClassLoader;
        WeakReference<RuntimeModuleData> weakReference = concurrentMap.get(weakClassLoaderBox);
        if (weakReference != null) {
            RuntimeModuleData runtimeModuleData = weakReference.get();
            if (runtimeModuleData != null) {
                return runtimeModuleData;
            }
            concurrentMap.remove(weakClassLoaderBox, weakReference);
        }
        RuntimeModuleData create = RuntimeModuleData.Companion.create(safeClassLoader);
        while (true) {
            try {
                ConcurrentMap<WeakClassLoaderBox, WeakReference<RuntimeModuleData>> concurrentMap2 = moduleByClassLoader;
                WeakReference<RuntimeModuleData> putIfAbsent = concurrentMap2.putIfAbsent(weakClassLoaderBox, new WeakReference<>(create));
                if (putIfAbsent == null) {
                    return create;
                }
                RuntimeModuleData runtimeModuleData2 = putIfAbsent.get();
                if (runtimeModuleData2 != null) {
                    return runtimeModuleData2;
                }
                concurrentMap2.remove(weakClassLoaderBox, putIfAbsent);
            } finally {
                weakClassLoaderBox.setTemporaryStrongRef(null);
            }
        }
    }

    public static final void clearModuleByClassLoaderCache() {
        moduleByClassLoader.clear();
    }
}
