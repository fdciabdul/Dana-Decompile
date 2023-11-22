package com.alibaba.ariver.kernel.api.invoke;

import com.alibaba.ariver.kernel.api.extension.resolver.ResultResolver;
import com.alibaba.ariver.kernel.api.scheduler.Interruptor;
import com.alibaba.ariver.kernel.common.utils.RVLogger;
import j$.util.concurrent.ConcurrentHashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;

/* loaded from: classes6.dex */
public class ResolveExtensionInvoker extends ExtensionInvoker {

    /* renamed from: a  reason: collision with root package name */
    private static final ResultResolver f6096a = new ResultResolver() { // from class: com.alibaba.ariver.kernel.api.invoke.ResolveExtensionInvoker.1
        @Override // com.alibaba.ariver.kernel.api.extension.resolver.ResultResolver
        public final Object resolve(List list) {
            if (list == null) {
                return null;
            }
            for (int size = list.size() - 1; size >= 0; size--) {
                if (list.get(size) != null) {
                    return list.get(size);
                }
            }
            return null;
        }
    };
    private static Map<Integer, Stack<Interruptor>> c = new ConcurrentHashMap();
    private ResultResolver b;

    public ResolveExtensionInvoker(ResultResolver resultResolver, ExtensionInvoker extensionInvoker) {
        super(extensionInvoker);
        this.b = resultResolver;
        if (resultResolver == null) {
            RVLogger.d("AriverKernel:ExtensionInvoker:Resolve", "use default resolver!");
            this.b = f6096a;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:72:0x01b7  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x01c6  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x01cc  */
    @Override // com.alibaba.ariver.kernel.api.invoke.ExtensionInvoker
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    protected com.alibaba.ariver.kernel.api.invoke.ExtensionInvoker.InvokeResult onInvoke(com.alibaba.ariver.kernel.common.immutable.ImmutableList<com.alibaba.ariver.kernel.api.extension.Extension> r22, java.lang.Object r23, java.lang.reflect.Method r24, java.lang.Object[] r25) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 501
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.ariver.kernel.api.invoke.ResolveExtensionInvoker.onInvoke(com.alibaba.ariver.kernel.common.immutable.ImmutableList, java.lang.Object, java.lang.reflect.Method, java.lang.Object[]):com.alibaba.ariver.kernel.api.invoke.ExtensionInvoker$InvokeResult");
    }
}
