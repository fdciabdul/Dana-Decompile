package org.greenrobot.eventbus.util;

import java.lang.reflect.Constructor;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.logging.Level;
import org.greenrobot.eventbus.EventBus;

/* loaded from: classes9.dex */
public class AsyncExecutor {
    private final EventBus eventBus;
    private final Constructor<?> failureEventConstructor;
    private final Object scope;
    private final Executor threadPool;

    /* loaded from: classes9.dex */
    public interface RunnableEx {
        void run() throws Exception;
    }

    /* loaded from: classes9.dex */
    public static class Builder {
        private EventBus eventBus;
        private Class<?> failureEventType;
        private Executor threadPool;

        private Builder() {
        }

        public Builder threadPool(Executor executor) {
            this.threadPool = executor;
            return this;
        }

        public Builder failureEventType(Class<?> cls) {
            this.failureEventType = cls;
            return this;
        }

        public Builder eventBus(EventBus eventBus) {
            this.eventBus = eventBus;
            return this;
        }

        public AsyncExecutor build() {
            return buildForScope(null);
        }

        public AsyncExecutor buildForScope(Object obj) {
            if (this.eventBus == null) {
                this.eventBus = EventBus.getDefault();
            }
            if (this.threadPool == null) {
                this.threadPool = Executors.newCachedThreadPool();
            }
            if (this.failureEventType == null) {
                this.failureEventType = ThrowableFailureEvent.class;
            }
            return new AsyncExecutor(this.threadPool, this.eventBus, this.failureEventType, obj);
        }
    }

    public static Builder builder() {
        return new Builder();
    }

    public static AsyncExecutor create() {
        return new Builder().build();
    }

    private AsyncExecutor(Executor executor, EventBus eventBus, Class<?> cls, Object obj) {
        this.threadPool = executor;
        this.eventBus = eventBus;
        this.scope = obj;
        try {
            this.failureEventConstructor = cls.getConstructor(Throwable.class);
        } catch (NoSuchMethodException e) {
            throw new RuntimeException("Failure event class must have a constructor with one parameter of type Throwable", e);
        }
    }

    public void execute(final RunnableEx runnableEx) {
        this.threadPool.execute(new Runnable() { // from class: org.greenrobot.eventbus.util.AsyncExecutor$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                AsyncExecutor.this.m4682lambda$execute$0$orggreenroboteventbusutilAsyncExecutor(runnableEx);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: lambda$execute$0$org-greenrobot-eventbus-util-AsyncExecutor  reason: not valid java name */
    public /* synthetic */ void m4682lambda$execute$0$orggreenroboteventbusutilAsyncExecutor(RunnableEx runnableEx) {
        try {
            runnableEx.run();
        } catch (Exception e) {
            try {
                Object newInstance = this.failureEventConstructor.newInstance(e);
                if (newInstance instanceof HasExecutionScope) {
                    ((HasExecutionScope) newInstance).setExecutionScope(this.scope);
                }
                this.eventBus.post(newInstance);
            } catch (Exception e2) {
                this.eventBus.getLogger().log(Level.SEVERE, "Original exception:", e);
                throw new RuntimeException("Could not create failure event", e2);
            }
        }
    }
}
