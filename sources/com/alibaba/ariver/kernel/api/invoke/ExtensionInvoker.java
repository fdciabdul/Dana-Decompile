package com.alibaba.ariver.kernel.api.invoke;

import com.alibaba.ariver.kernel.api.extension.Extension;
import com.alibaba.ariver.kernel.api.extension.ExtensionOpt;
import com.alibaba.ariver.kernel.api.node.Node;
import com.alibaba.ariver.kernel.common.immutable.ImmutableList;
import com.alibaba.ariver.kernel.common.utils.RVKernelUtils;
import com.alibaba.ariver.kernel.common.utils.RVTraceUtils;
import com.alibaba.ariver.kernel.common.utils.ReflectUtils;
import com.alibaba.exthub.common.ExtHubLogger;
import com.alibaba.griver.ui.ant.utils.AUScreenAdaptTool;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: classes3.dex */
public abstract class ExtensionInvoker implements InvocationHandler {

    /* renamed from: a  reason: collision with root package name */
    private ImmutableList<Extension> f6092a;
    private AtomicBoolean b;
    protected final InvokeCallback invokeCallback;
    protected boolean nativeCall;
    protected final ExtensionInvoker nextInvoker;
    protected Class<? extends Extension> targetExtensionClazz;
    protected final Node targetNode;

    /* loaded from: classes3.dex */
    public interface InvokeCallback<T> {
        void onComplete(T t);

        void onFail(Throwable th);
    }

    protected abstract InvokeResult onInvoke(ImmutableList<Extension> immutableList, Object obj, Method method, Object[] objArr) throws Throwable;

    /* loaded from: classes3.dex */
    public static class InvokeResult<T> {

        /* renamed from: a  reason: collision with root package name */
        private boolean f6093a;
        private T b;

        public static InvokeResult proceed() {
            return null;
        }

        public static InvokeResult decide(Object obj) {
            return new InvokeResult(false, obj);
        }

        public static InvokeResult pending() {
            return new InvokeResult(true, null);
        }

        private InvokeResult(boolean z, T t) {
            this.f6093a = z;
            this.b = t;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean hasNext() {
        return this.nextInvoker != null;
    }

    public ExtensionInvoker(ExtensionInvoker extensionInvoker) {
        this.b = new AtomicBoolean(false);
        this.nativeCall = false;
        this.nextInvoker = extensionInvoker;
        if (extensionInvoker != null) {
            this.invokeCallback = extensionInvoker.invokeCallback;
            this.targetNode = extensionInvoker.targetNode;
            return;
        }
        this.invokeCallback = null;
        this.targetNode = null;
    }

    public ExtensionInvoker(Node node, InvokeCallback invokeCallback, Class<? extends Extension> cls) {
        this.b = new AtomicBoolean(false);
        this.nativeCall = false;
        this.targetNode = node;
        this.invokeCallback = invokeCallback;
        this.targetExtensionClazz = cls;
        this.nextInvoker = null;
    }

    public void attacheTargetExtensions(List<Extension> list) {
        this.f6092a = new ImmutableList<>((List) list);
        this.b.set(true);
    }

    public void attacheTargetExtensions(Extension extension) {
        this.f6092a = new ImmutableList<>(extension);
        this.b.set(true);
    }

    public final Object proceedSafe(ImmutableList<Extension> immutableList, Object obj, Method method, Object[] objArr) {
        try {
            return proceed(immutableList, obj, method, objArr);
        } catch (Throwable th) {
            ExtHubLogger.e("AriverKernel:ExtensionInvoker", "extension invoke exception!", th);
            return ReflectUtils.getDefaultValue(method.getReturnType());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final Object proceed(ImmutableList<Extension> immutableList, Object obj, Method method, Object[] objArr) throws InvokeException {
        if (!hasNext()) {
            if (immutableList.size() != 1) {
                throw new IllegalStateException("only single extension is accepted in last invoker");
            }
            Extension extension = immutableList.get(0);
            StringBuilder sb = new StringBuilder();
            sb.append("RV_Extension_invoke_");
            sb.append(extension.getClass().getSimpleName());
            sb.append("_");
            sb.append(method.getName());
            String obj2 = sb.toString();
            RVTraceUtils.traceBeginSection(obj2);
            try {
                try {
                    try {
                        Object a2 = a(method, extension, objArr);
                        RVTraceUtils.traceEndSection(obj2);
                        return a2;
                    } catch (InvocationTargetException e) {
                        throw new InvokeException(e.getCause());
                    } catch (Throwable th) {
                        throw new InvokeException(th);
                    }
                } catch (InvokeException e2) {
                    throw e2;
                }
            } catch (Throwable th2) {
                RVTraceUtils.traceEndSection(obj2);
                throw th2;
            }
        }
        if (this.b.compareAndSet(true, false)) {
            this.nextInvoker.b.set(true);
        }
        try {
            return this.nextInvoker.invokeWithTargetExtensions(immutableList, obj, method, objArr);
        } catch (InvokeException e3) {
            throw e3;
        } catch (Throwable th3) {
            throw new InvokeException(th3);
        }
    }

    protected ExtensionOpt.MethodInvokeOptimizer getMethodInvokeOptimizer(Class<? extends Extension> cls) {
        return ExtensionOpt.getMethodInvokeOptimizer(cls, false);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private Object a(Method method, Extension extension, Object[] objArr) throws InvokeException, InvocationTargetException, IllegalAccessException {
        ExtensionOpt.MethodInvokeOptimizer methodInvokeOptimizer;
        Class<?> cls = this.targetExtensionClazz;
        if (cls == null && method != null) {
            try {
                cls = method.getDeclaringClass();
            } catch (Throwable th) {
                ExtHubLogger.w("AriverKernel:ExtensionInvoker", "getDeclaringClass error!", th);
            }
        }
        if (cls != null && method != null && extension != null && (methodInvokeOptimizer = getMethodInvokeOptimizer(cls)) != null) {
            try {
                return methodInvokeOptimizer.doMethodInvoke(method.getName(), extension, objArr);
            } catch (ExtensionOpt.MismatchMethodException e) {
                StringBuilder sb = new StringBuilder();
                sb.append("optimizer.doMethodInvoke occur MismatchMethodException: ");
                sb.append(cls.getName());
                sb.append("#");
                sb.append(method.getName());
                sb.append(AUScreenAdaptTool.PREFIX_ID);
                sb.append(extension.getClass().getName());
                sb.append(", ");
                sb.append(e);
                String obj = sb.toString();
                ExtHubLogger.e("AriverKernel:ExtensionInvoker", obj);
                ExtensionOpt.reportException(e, "BIZ_ARIVER", "doMethodInvoke", "MismatchMethod", null);
                if (RVKernelUtils.isDebug()) {
                    throw new InvokeException(obj, e);
                }
                if (ExtensionOpt.shouldThrowOut(e, "doMethodInvoke", "MismatchMethod")) {
                    throw new InvokeException(obj, e);
                }
            } catch (ClassCastException e2) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("optimizer.doMethodInvoke occur ClassCastException: ");
                sb2.append(cls.getName());
                sb2.append("#");
                sb2.append(method.getName());
                sb2.append(AUScreenAdaptTool.PREFIX_ID);
                sb2.append(extension.getClass().getName());
                sb2.append(", ");
                sb2.append(e2);
                String obj2 = sb2.toString();
                ExtHubLogger.e("AriverKernel:ExtensionInvoker", obj2);
                ExtensionOpt.reportException(e2, "BIZ_ARIVER", "doMethodInvoke", "ClassCast", null);
                if (RVKernelUtils.isDebug()) {
                    throw new InvokeException(obj2, e2);
                }
                if (ExtensionOpt.shouldThrowOut(e2, "doMethodInvoke", "ClassCast")) {
                    throw new InvokeException(obj2, e2);
                }
            } catch (IndexOutOfBoundsException e3) {
                StringBuilder sb3 = new StringBuilder();
                sb3.append("optimizer.doMethodInvoke occur IndexOutOfBoundsException: ");
                sb3.append(cls.getName());
                sb3.append("#");
                sb3.append(method.getName());
                sb3.append(AUScreenAdaptTool.PREFIX_ID);
                sb3.append(extension.getClass().getName());
                sb3.append(", ");
                sb3.append(e3);
                String obj3 = sb3.toString();
                ExtHubLogger.e("AriverKernel:ExtensionInvoker", obj3);
                ExtensionOpt.reportException(e3, "BIZ_ARIVER", "doMethodInvoke", "IndexOutOfBounds", null);
                if (RVKernelUtils.isDebug()) {
                    throw new InvokeException(obj3, e3);
                }
                if (ExtensionOpt.shouldThrowOut(e3, "doMethodInvoke", "IndexOutOfBounds")) {
                    throw new InvokeException(obj3, e3);
                }
            } catch (Throwable th2) {
                StringBuilder sb4 = new StringBuilder();
                sb4.append("optimizer.doMethodInvoke occur existing Exception: ");
                sb4.append(cls.getName());
                sb4.append("#");
                sb4.append(method.getName());
                sb4.append(AUScreenAdaptTool.PREFIX_ID);
                sb4.append(extension.getClass().getName());
                sb4.append(", ");
                sb4.append(th2);
                String obj4 = sb4.toString();
                ExtHubLogger.e("AriverKernel:ExtensionInvoker", obj4);
                ExtensionOpt.reportException(th2, "BIZ_ARIVER", "doMethodInvoke", "FinalCatch", null);
                if (ExtensionOpt.shouldThrowOut(th2, "doMethodInvoke", "FinalCatch")) {
                    throw new InvokeException(obj4, th2);
                }
            }
        }
        if (RVKernelUtils.isDebug()) {
            String name = cls == null ? "ClazzName" : cls.getName();
            if (method != null && extension != null && cls != null) {
                StringBuilder sb5 = new StringBuilder();
                sb5.append("optimizer.doMethodInvoke is not work, and actually do method.invoke: ");
                sb5.append(name);
                sb5.append("#");
                sb5.append(method.getName());
                sb5.append(AUScreenAdaptTool.PREFIX_ID);
                sb5.append(extension.getClass().getName());
                ExtHubLogger.w("AriverKernel:ExtensionInvoker", sb5.toString());
            }
        }
        return method.invoke(extension, objArr);
    }

    @Override // java.lang.reflect.InvocationHandler
    public final Object invoke(Object obj, Method method, Object[] objArr) throws Throwable {
        return invokeWithTargetExtensions(this.f6092a, obj, method, objArr);
    }

    public final Object invokeWithTargetExtensions(ImmutableList<Extension> immutableList, Object obj, Method method, Object[] objArr) throws Throwable {
        InvokeCallback invokeCallback;
        InvokeCallback invokeCallback2;
        try {
            InvokeResult onInvoke = onInvoke(immutableList, obj, method, objArr);
            if (onInvoke != null) {
                if (onInvoke.f6093a) {
                    if (onInvoke.b == null) {
                        onInvoke.b = ReflectUtils.getDefaultValue(method.getReturnType());
                    }
                    return onInvoke.b;
                }
                if (this.b.get() && (invokeCallback2 = this.invokeCallback) != null) {
                    invokeCallback2.onComplete(onInvoke.b);
                }
                return onInvoke.b;
            }
            return proceed(immutableList, obj, method, objArr);
        } catch (Throwable th) {
            StringBuilder sb = new StringBuilder();
            sb.append("Java exception happened!\nExtension: ");
            sb.append(immutableList.get(0));
            sb.append("\nMethod: ");
            sb.append(method);
            ExtHubLogger.e("AriverKernel:ExtensionInvoker", sb.toString(), th);
            if (this.b.get() && (invokeCallback = this.invokeCallback) != null) {
                invokeCallback.onFail(th);
            }
            throw th;
        }
    }
}
