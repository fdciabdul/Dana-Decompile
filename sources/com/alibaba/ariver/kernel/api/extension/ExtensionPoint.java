package com.alibaba.ariver.kernel.api.extension;

import androidx.collection.LruCache;
import com.alibaba.ariver.kernel.api.annotation.DefaultImpl;
import com.alibaba.ariver.kernel.api.extension.Extension;
import com.alibaba.ariver.kernel.api.extension.resolver.ResultResolver;
import com.alibaba.ariver.kernel.api.invoke.ExtensionInvoker;
import com.alibaba.ariver.kernel.api.invoke.ExtensionInvokerFactory;
import com.alibaba.ariver.kernel.api.invoke.InvocationHandlerWrapper;
import com.alibaba.ariver.kernel.api.node.Node;
import com.alibaba.ariver.kernel.api.node.ValueStore;
import com.alibaba.ariver.kernel.common.RVProxy;
import com.alibaba.ariver.kernel.common.service.RVConfigService;
import com.alibaba.ariver.kernel.common.service.executor.ExecutorType;
import com.alibaba.ariver.kernel.common.utils.ProcessUtils;
import com.alibaba.ariver.kernel.common.utils.RVKernelUtils;
import com.alibaba.ariver.kernel.common.utils.ReflectUtils;
import com.alibaba.ariver.kernel.common.utils.TypeUtils;
import com.alibaba.exthub.common.ExtHubLogger;
import j$.util.concurrent.ConcurrentHashMap;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: classes2.dex */
public class ExtensionPoint<T extends Extension> {

    /* renamed from: a  reason: collision with root package name */
    private static ExtensionManager f6082a;
    private static AtomicBoolean b = new AtomicBoolean(false);
    private static int c = 10;
    private static boolean d = false;
    private static final Map<Long, LruCache<Class<? extends Extension>, Extension>> e = new ConcurrentHashMap();
    private static Map<Class, ProxyGenerator> q = new ConcurrentHashMap();
    private static Map<Class<? extends Extension>, Extension> r = new ConcurrentHashMap();
    private Node f;
    private Class<T> g;
    private Object h;
    private ResultResolver i;
    private boolean j;
    private ExtensionManager m;
    private boolean k = true;
    private ExecutorType l = ExecutorType.SYNC;
    private Map<Action, ExecutorType> n = new HashMap();

    /* renamed from: o  reason: collision with root package name */
    private Object f6083o = new Object();
    private InvocationHandler p = new InvocationHandler() { // from class: com.alibaba.ariver.kernel.api.extension.ExtensionPoint.1
        @Override // java.lang.reflect.InvocationHandler
        public Object invoke(Object obj, Method method, Object[] objArr) throws InvocationTargetException, IllegalAccessException {
            if (method.getDeclaringClass() == Object.class) {
                return method.invoke(ExtensionPoint.this.f6083o, objArr);
            }
            Object obj2 = ExtensionPoint.this.h;
            if (obj2 == null) {
                obj2 = ReflectUtils.getDefaultValue(method.getReturnType());
            }
            ActionCallback actionCallback = new ActionCallback(ExtensionPoint.this.n, obj2);
            actionCallback.onStart(null);
            actionCallback.onComplete(null);
            return obj2;
        }
    };

    /* loaded from: classes3.dex */
    public interface ProxyGenerator<T> {
        T createProxyInstance(InvocationHandler invocationHandler);
    }

    public static <T extends Extension> ExtensionPoint<T> as(Class<T> cls) {
        return new ExtensionPoint<>(cls);
    }

    public static void bind(ExtensionManager extensionManager) {
        f6082a = extensionManager;
    }

    private ExtensionPoint(Class<T> cls) {
        this.g = cls;
    }

    public ExtensionPoint<T> defaultValue(Object obj) {
        this.h = obj;
        return this;
    }

    public ExtensionPoint<T> useCache(boolean z) {
        this.k = z;
        return this;
    }

    public ExtensionPoint<T> actionOn(ExecutorType executorType) {
        this.l = executorType;
        return this;
    }

    public ExtensionPoint<T> when(Action action) {
        this.n.put(action, this.l);
        return this;
    }

    public ExtensionPoint<T> node(Node node) {
        this.f = node;
        return this;
    }

    public ExtensionPoint<T> resolve(ResultResolver resultResolver) {
        this.i = resultResolver;
        return this;
    }

    public ExtensionPoint<T> extensionManager(ExtensionManager extensionManager) {
        this.m = extensionManager;
        return this;
    }

    public ExtensionPoint<T> nullable() {
        this.j = true;
        return this;
    }

    private void a() {
        if (b.getAndSet(true)) {
            return;
        }
        c = TypeUtils.parseInt(((RVConfigService) RVProxy.get(RVConfigService.class)).getConfig("ariver_extensionPointCacheCount", "10", new RVConfigService.OnConfigChangeListener() { // from class: com.alibaba.ariver.kernel.api.extension.ExtensionPoint.2
            @Override // com.alibaba.ariver.kernel.common.service.RVConfigService.OnConfigChangeListener
            public void onChange(String str) {
                int unused = ExtensionPoint.c = TypeUtils.parseInt(str);
                StringBuilder sb = new StringBuilder();
                sb.append("onChange sMasCacheCount: ");
                sb.append(ExtensionPoint.c);
                ExtHubLogger.d("AriverKernel:ExtensionPoint", sb.toString());
            }
        }));
        d = ((RVConfigService) RVProxy.get(RVConfigService.class)).getConfigBoolean("ariver_createExtWhenFinalized", true);
        StringBuilder sb = new StringBuilder();
        sb.append("initConfig sMasCacheCount: ");
        sb.append(c);
        ExtHubLogger.d("AriverKernel:ExtensionPoint", sb.toString());
    }

    protected static LruCache<Class<? extends Extension>, Extension> getExtensionCache(Node node) {
        if (node == null) {
            return null;
        }
        return e.get(Long.valueOf(node.getNodeId()));
    }

    public static void invalidateExtensionCache() {
        ExtHubLogger.d("AriverKernel:ExtensionPoint", "invalidateAllExtensionCache");
        e.clear();
    }

    public static void invalidateExtensionCache(Class<? extends Extension> cls) {
        StringBuilder sb = new StringBuilder();
        sb.append("invalidateExtensionCache ");
        sb.append(cls);
        ExtHubLogger.d("AriverKernel:ExtensionPoint", sb.toString());
        Iterator<LruCache<Class<? extends Extension>, Extension>> it = e.values().iterator();
        while (it.hasNext()) {
            it.next().remove(cls);
        }
    }

    public static void invalidateExtensionCache(Node node, Class<? extends Extension> cls) {
        StringBuilder sb = new StringBuilder();
        sb.append("invalidateExtensionCache node: ");
        sb.append(node);
        sb.append(" extension: ");
        sb.append(cls);
        ExtHubLogger.d("AriverKernel:ExtensionPoint", sb.toString());
        LruCache<Class<? extends Extension>, Extension> lruCache = e.get(Long.valueOf(node.getNodeId()));
        if (lruCache != null) {
            lruCache.remove(cls);
        }
    }

    public T create() {
        T t;
        Node node;
        LruCache<Class<? extends Extension>, Extension> lruCache;
        T t2;
        a();
        if (this.n.size() > 0 || this.i != null) {
            this.k = false;
        }
        if (this.k && (node = this.f) != null && c > 0 && (lruCache = e.get(Long.valueOf(node.getNodeId()))) != null && (t2 = (T) lruCache.get(this.g)) != null) {
            StringBuilder sb = new StringBuilder();
            sb.append("find Extension ");
            sb.append(this.g);
            sb.append(" cache hit : ");
            sb.append(t2);
            ExtHubLogger.d("AriverKernel:ExtensionPoint", sb.toString());
            return t2;
        }
        InvocationHandler b2 = b();
        if (b2 == null) {
            return null;
        }
        ProxyGenerator proxyGenerator = q.get(this.g);
        if (proxyGenerator != null) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("use proxy generator for ");
            sb2.append(this.g);
            ExtHubLogger.d("AriverKernel:ExtensionPoint", sb2.toString());
            t = (T) proxyGenerator.createProxyInstance(b2);
        } else {
            t = (T) Proxy.newProxyInstance(getClass().getClassLoader(), new Class[]{this.g}, b2);
        }
        if (this.k && c > 0 && c()) {
            Map<Long, LruCache<Class<? extends Extension>, Extension>> map = e;
            LruCache<Class<? extends Extension>, Extension> lruCache2 = map.get(Long.valueOf(this.f.getNodeId()));
            if (lruCache2 == null) {
                lruCache2 = new LruCache<>(c);
                map.put(Long.valueOf(this.f.getNodeId()), lruCache2);
            }
            lruCache2.put(this.g, t);
        }
        return t;
    }

    public static void registerProxyGenerator(Class cls, ProxyGenerator proxyGenerator) {
        q.put(cls, proxyGenerator);
    }

    public static void clearProxyGenerator() {
        q.clear();
    }

    public static void reportException(Throwable th) {
        if (RVKernelUtils.isDebug()) {
            throw new RuntimeException(th);
        }
        ExtHubLogger.e("AriverKernel:ExtensionPoint", "reportException", th);
    }

    private InvocationHandler b() {
        T d2;
        if (!c()) {
            StringBuilder sb = new StringBuilder();
            sb.append("create extension: ");
            sb.append(this.g);
            sb.append(" when node isFinalized! can create? ");
            sb.append(d);
            ExtHubLogger.w("AriverKernel:ExtensionPoint", sb.toString());
            if (!d) {
                if (this.j) {
                    return null;
                }
                return this.p;
            }
        }
        ExtensionManager extensionManager = this.m;
        if (extensionManager == null) {
            extensionManager = f6082a;
        }
        List<Extension> extensionByPoint = extensionManager.getExtensionByPoint(this.f, this.g);
        if ((extensionByPoint == null || extensionByPoint.size() == 0) && (d2 = d()) != null) {
            extensionByPoint = Collections.singletonList(d2);
        }
        if (extensionByPoint == null || extensionByPoint.isEmpty()) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("cannot find extension for ");
            sb2.append(this.g);
            ExtHubLogger.w("AriverKernel", sb2.toString());
            if (this.j) {
                return null;
            }
            return this.p;
        }
        ExtensionInvoker a2 = a(extensionManager);
        a2.attacheTargetExtensions(extensionByPoint);
        return new InvocationHandlerWrapper(this.g, a2);
    }

    private boolean c() {
        Node node = this.f;
        if (node == null) {
            ExtHubLogger.w("AriverKernel:ExtensionPoint", "validateNode but is null!");
            return false;
        } else if ((node instanceof ValueStore) && ((ValueStore) node).getBooleanValue(Node.KEY_IS_FINALIZED)) {
            ExtHubLogger.w("AriverKernel:ExtensionPoint", "validateNode but is finalized!");
            return false;
        } else {
            return true;
        }
    }

    private ExtensionInvoker a(ExtensionManager extensionManager) {
        ExtensionInvokerFactory extensionInvokerFactory = (ExtensionInvokerFactory) RVProxy.get(ExtensionInvokerFactory.class);
        ExtensionInvoker createAwareExtensionInvoker = extensionInvokerFactory.createAwareExtensionInvoker(this.f, new ActionCallback(this.n, this.h), this.g);
        if (!ProcessUtils.isMainProcess()) {
            createAwareExtensionInvoker = extensionInvokerFactory.createRemoteBridgeExtensionInvoker(extensionManager.getRemoteController(), createAwareExtensionInvoker);
        }
        return extensionInvokerFactory.createScheduleExtensionInvoker(extensionInvokerFactory.createResolveExtensionInvoker(this.i, createAwareExtensionInvoker));
    }

    private T d() {
        try {
        } catch (Throwable th) {
            ExtHubLogger.e("AriverKernel", "getDefaultImpl exception!", th);
        }
        if (r.containsKey(this.g)) {
            return (T) r.get(this.g);
        }
        DefaultImpl defaultImpl = (DefaultImpl) this.g.getAnnotation(DefaultImpl.class);
        if (defaultImpl != null) {
            String value = defaultImpl.value();
            StringBuilder sb = new StringBuilder();
            sb.append("newInstance for ");
            sb.append(this.g);
            sb.append(" to defaultImpl: ");
            sb.append(value);
            ExtHubLogger.d("AriverKernel", sb.toString());
            Class<?> cls = Class.forName(value);
            T t = cls != null ? (T) cls.newInstance() : null;
            r.put(this.g, t);
            return t;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void exitNode(Node node) {
        if (node != null) {
            e.remove(Long.valueOf(node.getNodeId()));
        }
    }
}
