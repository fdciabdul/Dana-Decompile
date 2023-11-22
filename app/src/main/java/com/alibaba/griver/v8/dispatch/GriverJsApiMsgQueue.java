package com.alibaba.griver.v8.dispatch;

import com.alibaba.ariver.engine.api.bridge.model.NativeCallContext;
import com.alibaba.ariver.engine.api.bridge.model.SendToNativeCallback;
import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/* loaded from: classes6.dex */
public class GriverJsApiMsgQueue {

    /* renamed from: a  reason: collision with root package name */
    private final ReentrantLock f6778a;
    private final Condition b;
    private final AtomicInteger c;
    private Queue<JsApiCallItem> d;
    private Queue<JsApiCallItem> e;
    private Queue<JsApiCallItem> f;

    public GriverJsApiMsgQueue() {
        ReentrantLock reentrantLock = new ReentrantLock();
        this.f6778a = reentrantLock;
        this.b = reentrantLock.newCondition();
        this.c = new AtomicInteger();
        this.d = new LinkedList();
        this.e = new LinkedList();
        this.f = new LinkedList();
    }

    private void a() {
        ReentrantLock reentrantLock = this.f6778a;
        reentrantLock.lock();
        try {
            this.b.signal();
        } finally {
            reentrantLock.unlock();
        }
    }

    private void a(JsApiCallItem jsApiCallItem, int i) {
        if (i == 0) {
            this.e.add(jsApiCallItem);
        } else if (i > 0) {
            this.d.add(jsApiCallItem);
        } else {
            this.f.add(jsApiCallItem);
        }
    }

    public void add2Queue(JsApiCallItem jsApiCallItem, int i) {
        ReentrantLock reentrantLock = this.f6778a;
        AtomicInteger atomicInteger = this.c;
        reentrantLock.lock();
        try {
            a(jsApiCallItem, i);
            if (atomicInteger.getAndIncrement() == 0) {
                a();
            }
        } finally {
            reentrantLock.unlock();
        }
    }

    public JsApiCallItem take() throws InterruptedException {
        AtomicInteger atomicInteger = this.c;
        ReentrantLock reentrantLock = this.f6778a;
        reentrantLock.lockInterruptibly();
        while (atomicInteger.get() == 0) {
            try {
                this.b.await();
            } finally {
                reentrantLock.unlock();
            }
        }
        JsApiCallItem b = b();
        if (atomicInteger.getAndDecrement() > 1) {
            this.b.signal();
        }
        return b;
    }

    private JsApiCallItem b() {
        if (!this.d.isEmpty()) {
            return this.d.poll();
        }
        if (!this.e.isEmpty()) {
            return this.e.poll();
        }
        if (this.f.isEmpty()) {
            return null;
        }
        return this.f.poll();
    }

    public void clear() {
        if (!this.d.isEmpty()) {
            this.d.clear();
        }
        if (!this.e.isEmpty()) {
            this.e.clear();
        }
        if (this.f.isEmpty()) {
            return;
        }
        this.f.clear();
    }

    /* loaded from: classes6.dex */
    public static class JsApiCallItem {

        /* renamed from: a  reason: collision with root package name */
        private NativeCallContext f6779a;
        private SendToNativeCallback b;
        private boolean c;

        public JsApiCallItem(NativeCallContext nativeCallContext, SendToNativeCallback sendToNativeCallback) {
            this.f6779a = nativeCallContext;
            this.b = sendToNativeCallback;
            this.c = true;
        }

        public JsApiCallItem(NativeCallContext nativeCallContext, SendToNativeCallback sendToNativeCallback, boolean z) {
            this.f6779a = nativeCallContext;
            this.b = sendToNativeCallback;
            this.c = z;
        }

        public NativeCallContext getCallContext() {
            return this.f6779a;
        }

        public SendToNativeCallback getCallback() {
            return this.b;
        }

        public boolean isNeedPermission() {
            return this.c;
        }
    }
}
