package com.alibaba.ariver.kernel.api.extension;

import com.alibaba.ariver.kernel.api.extension.Action;
import com.alibaba.ariver.kernel.common.RVProxy;
import com.alibaba.ariver.kernel.common.service.executor.ExecutorType;
import com.alibaba.ariver.kernel.common.service.executor.RVExecutorService;
import com.alibaba.exthub.common.ExtHubLogger;
import java.util.List;
import java.util.Map;

/* loaded from: classes3.dex */
public class ActionCallback<T> implements ExtensionCallback<T> {

    /* renamed from: a  reason: collision with root package name */
    private final Map<Action, ExecutorType> f6079a;
    private final RVExecutorService b = (RVExecutorService) RVProxy.get(RVExecutorService.class);
    private final T c;

    @Override // com.alibaba.ariver.kernel.api.invoke.ExtensionInvoker.InvokeCallback
    public void onFail(Throwable th) {
    }

    public ActionCallback(Map<Action, ExecutorType> map, T t) {
        this.f6079a = map;
        this.c = t;
    }

    @Override // com.alibaba.ariver.kernel.api.extension.ExtensionCallback
    public void onStart(final List<Extension> list) {
        for (final Action action : this.f6079a.keySet()) {
            final long currentTimeMillis = System.currentTimeMillis();
            if (action instanceof Action.Start) {
                this.b.getExecutor(this.f6079a.get(action)).execute(new Runnable() { // from class: com.alibaba.ariver.kernel.api.extension.ActionCallback.1
                    @Override // java.lang.Runnable
                    public void run() {
                        StringBuilder sb = new StringBuilder();
                        sb.append("onComplete for ");
                        sb.append(action.getClass().getName());
                        sb.append(" schedule ");
                        sb.append(System.currentTimeMillis() - currentTimeMillis);
                        ExtHubLogger.d("AriverKernel:ActionCallback", sb.toString());
                        ((Action.Start) action).onStart(list);
                    }
                });
            }
        }
    }

    @Override // com.alibaba.ariver.kernel.api.extension.ExtensionCallback
    public void onProgress(final Extension extension, final T t) {
        for (final Action action : this.f6079a.keySet()) {
            if (action instanceof Action.Progress) {
                this.b.getExecutor(this.f6079a.get(action)).execute(new Runnable() { // from class: com.alibaba.ariver.kernel.api.extension.ActionCallback.2
                    /* JADX WARN: Multi-variable type inference failed */
                    @Override // java.lang.Runnable
                    public void run() {
                        ((Action.Progress) action).onProgress(extension, t);
                    }
                });
            }
        }
    }

    @Override // com.alibaba.ariver.kernel.api.extension.ExtensionCallback
    public void onException(final Extension extension, final Throwable th) {
        for (final Action action : this.f6079a.keySet()) {
            if (action instanceof Action.Exception) {
                this.b.getExecutor(this.f6079a.get(action)).execute(new Runnable() { // from class: com.alibaba.ariver.kernel.api.extension.ActionCallback.3
                    @Override // java.lang.Runnable
                    public void run() {
                        ((Action.Exception) action).onException(extension, th);
                    }
                });
            }
        }
    }

    @Override // com.alibaba.ariver.kernel.api.extension.ExtensionCallback
    public void onInterrupt(final Extension extension) {
        for (final Action action : this.f6079a.keySet()) {
            if (action instanceof Action.Interrupt) {
                this.b.getExecutor(this.f6079a.get(action)).execute(new Runnable() { // from class: com.alibaba.ariver.kernel.api.extension.ActionCallback.4
                    @Override // java.lang.Runnable
                    public void run() {
                        ((Action.Interrupt) action).onInterrupt(extension);
                    }
                });
            }
        }
    }

    @Override // com.alibaba.ariver.kernel.api.invoke.ExtensionInvoker.InvokeCallback
    public void onComplete(T t) {
        if (t == null) {
            t = this.c;
        }
        for (final Action action : this.f6079a.keySet()) {
            if (action instanceof Action.Complete) {
                final long currentTimeMillis = System.currentTimeMillis();
                final T t2 = t;
                this.b.getExecutor(this.f6079a.get(action)).execute(new Runnable() { // from class: com.alibaba.ariver.kernel.api.extension.ActionCallback.5
                    /* JADX WARN: Multi-variable type inference failed */
                    @Override // java.lang.Runnable
                    public void run() {
                        StringBuilder sb = new StringBuilder();
                        sb.append("onComplete for ");
                        sb.append(action.getClass().getName());
                        sb.append(" schedule ");
                        sb.append(System.currentTimeMillis() - currentTimeMillis);
                        ExtHubLogger.d("AriverKernel:ActionCallback", sb.toString());
                        ((Action.Complete) action).onComplete(t2);
                    }
                });
            }
        }
    }
}
