package io.opentelemetry.context;

import io.opentelemetry.context.Context;
import io.opentelemetry.context.ContextStorage;
import j$.util.function.BiConsumer;
import j$.util.function.BiFunction;
import j$.util.function.Consumer;
import j$.util.function.Function;
import j$.util.function.Supplier;
import java.util.Arrays;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ScheduledExecutorService;
import javax.annotation.Nullable;

/* loaded from: classes6.dex */
final class ArrayBasedContext implements Context {
    private static final Context ROOT = new ArrayBasedContext(new Object[0]);
    private final Object[] entries;

    @Override // io.opentelemetry.context.Context
    public final /* synthetic */ Scope makeCurrent() {
        Scope attach;
        attach = ContextStorage.CC.get().attach(this);
        return attach;
    }

    @Override // io.opentelemetry.context.Context
    public final /* synthetic */ Context with(ImplicitContextKeyed implicitContextKeyed) {
        Context storeInContext;
        storeInContext = implicitContextKeyed.storeInContext(this);
        return storeInContext;
    }

    @Override // io.opentelemetry.context.Context
    public final /* synthetic */ Runnable wrap(Runnable runnable) {
        return Context.CC.$default$wrap(this, runnable);
    }

    @Override // io.opentelemetry.context.Context
    public final /* synthetic */ Callable wrap(Callable callable) {
        return Context.CC.$default$wrap(this, callable);
    }

    @Override // io.opentelemetry.context.Context
    public final /* synthetic */ Executor wrap(Executor executor) {
        return Context.CC.$default$wrap(this, executor);
    }

    @Override // io.opentelemetry.context.Context
    public final /* synthetic */ ExecutorService wrap(ExecutorService executorService) {
        return Context.CC.$default$wrap((Context) this, executorService);
    }

    @Override // io.opentelemetry.context.Context
    public final /* synthetic */ ScheduledExecutorService wrap(ScheduledExecutorService scheduledExecutorService) {
        return Context.CC.$default$wrap((Context) this, scheduledExecutorService);
    }

    @Override // io.opentelemetry.context.Context
    public final /* synthetic */ BiConsumer wrapConsumer(BiConsumer biConsumer) {
        return Context.CC.$default$wrapConsumer(this, biConsumer);
    }

    @Override // io.opentelemetry.context.Context
    public final /* synthetic */ Consumer wrapConsumer(Consumer consumer) {
        return Context.CC.$default$wrapConsumer(this, consumer);
    }

    @Override // io.opentelemetry.context.Context
    public final /* synthetic */ BiFunction wrapFunction(BiFunction biFunction) {
        return Context.CC.$default$wrapFunction(this, biFunction);
    }

    @Override // io.opentelemetry.context.Context
    public final /* synthetic */ Function wrapFunction(Function function) {
        return Context.CC.$default$wrapFunction(this, function);
    }

    @Override // io.opentelemetry.context.Context
    public final /* synthetic */ Supplier wrapSupplier(Supplier supplier) {
        return Context.CC.$default$wrapSupplier(this, supplier);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Context root() {
        return ROOT;
    }

    private ArrayBasedContext(Object[] objArr) {
        this.entries = objArr;
    }

    @Override // io.opentelemetry.context.Context
    @Nullable
    public final <V> V get(ContextKey<V> contextKey) {
        int i = 0;
        while (true) {
            Object[] objArr = this.entries;
            if (i >= objArr.length) {
                return null;
            }
            if (objArr[i] == contextKey) {
                return (V) objArr[i + 1];
            }
            i += 2;
        }
    }

    @Override // io.opentelemetry.context.Context
    public final <V> Context with(ContextKey<V> contextKey, V v) {
        int i = 0;
        while (true) {
            Object[] objArr = this.entries;
            if (i < objArr.length) {
                if (objArr[i] == contextKey) {
                    int i2 = i + 1;
                    if (objArr[i2] == v) {
                        return this;
                    }
                    Object[] objArr2 = (Object[]) objArr.clone();
                    objArr2[i2] = v;
                    return new ArrayBasedContext(objArr2);
                }
                i += 2;
            } else {
                Object[] copyOf = Arrays.copyOf(objArr, objArr.length + 2);
                copyOf[copyOf.length - 2] = contextKey;
                copyOf[copyOf.length - 1] = v;
                return new ArrayBasedContext(copyOf);
            }
        }
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("{");
        int i = 0;
        while (true) {
            Object[] objArr = this.entries;
            if (i >= objArr.length) {
                break;
            }
            sb.append(objArr[i]);
            sb.append('=');
            sb.append(this.entries[i + 1]);
            sb.append(", ");
            i += 2;
        }
        if (sb.length() > 1) {
            sb.setLength(sb.length() - 2);
        }
        sb.append('}');
        return sb.toString();
    }
}
