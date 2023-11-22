package io.opentelemetry.context;

import io.opentelemetry.context.Context;
import io.opentelemetry.context.ContextStorage;
import j$.util.function.BiConsumer;
import j$.util.function.BiFunction;
import j$.util.function.Consumer;
import j$.util.function.Function;
import j$.util.function.Supplier;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ScheduledExecutorService;
import javax.annotation.Nullable;

/* loaded from: classes2.dex */
public interface Context {
    @Nullable
    <V> V get(ContextKey<V> contextKey);

    Scope makeCurrent();

    <V> Context with(ContextKey<V> contextKey, V v);

    Context with(ImplicitContextKeyed implicitContextKeyed);

    Runnable wrap(Runnable runnable);

    <T> Callable<T> wrap(Callable<T> callable);

    Executor wrap(Executor executor);

    ExecutorService wrap(ExecutorService executorService);

    ScheduledExecutorService wrap(ScheduledExecutorService scheduledExecutorService);

    <T, U> BiConsumer<T, U> wrapConsumer(BiConsumer<T, U> biConsumer);

    <T> Consumer<T> wrapConsumer(Consumer<T> consumer);

    <T, U, V> BiFunction<T, U, V> wrapFunction(BiFunction<T, U, V> biFunction);

    <T, U> Function<T, U> wrapFunction(Function<T, U> function);

    <T> Supplier<T> wrapSupplier(Supplier<T> supplier);

    /* renamed from: io.opentelemetry.context.Context$-CC  reason: invalid class name */
    /* loaded from: classes2.dex */
    public final /* synthetic */ class CC {
        public static Context current() {
            Context current = ContextStorage.CC.get().current();
            return current == null ? root() : current;
        }

        public static Context root() {
            return ContextStorage.CC.get().root();
        }

        public static Executor taskWrapping(final Executor executor) {
            return new Executor() { // from class: io.opentelemetry.context.Context$$ExternalSyntheticLambda7
                @Override // java.util.concurrent.Executor
                public final void execute(Runnable runnable) {
                    executor.execute(Context.CC.current().wrap(runnable));
                }
            };
        }

        public static ExecutorService taskWrapping(ExecutorService executorService) {
            return new CurrentContextExecutorService(executorService);
        }

        public static Runnable $default$wrap(final Context context, final Runnable runnable) {
            return new Runnable() { // from class: io.opentelemetry.context.Context$$ExternalSyntheticLambda4
                @Override // java.lang.Runnable
                public final void run() {
                    Context.CC.$private$lambda$wrap$1(Context.this, runnable);
                }
            };
        }

        public static /* synthetic */ void $private$lambda$wrap$1(Context context, Runnable runnable) {
            Scope makeCurrent = context.makeCurrent();
            try {
                runnable.run();
                if (makeCurrent != null) {
                    makeCurrent.close();
                }
            } catch (Throwable th) {
                if (makeCurrent != null) {
                    try {
                        makeCurrent.close();
                    } catch (Throwable th2) {
                        th.addSuppressed(th2);
                    }
                }
                throw th;
            }
        }

        public static Callable $default$wrap(final Context context, final Callable callable) {
            return new Callable() { // from class: io.opentelemetry.context.Context$$ExternalSyntheticLambda8
                @Override // java.util.concurrent.Callable
                public final Object call() {
                    return Context.CC.$private$lambda$wrap$2(Context.this, callable);
                }
            };
        }

        public static /* synthetic */ Object $private$lambda$wrap$2(Context context, Callable callable) throws Exception {
            Scope makeCurrent = context.makeCurrent();
            try {
                Object call = callable.call();
                if (makeCurrent != null) {
                    makeCurrent.close();
                }
                return call;
            } catch (Throwable th) {
                if (makeCurrent != null) {
                    try {
                        makeCurrent.close();
                    } catch (Throwable th2) {
                        th.addSuppressed(th2);
                    }
                }
                throw th;
            }
        }

        public static Executor $default$wrap(final Context context, final Executor executor) {
            return new Executor() { // from class: io.opentelemetry.context.Context$$ExternalSyntheticLambda2
                @Override // java.util.concurrent.Executor
                public final void execute(Runnable runnable) {
                    executor.execute(Context.this.wrap(runnable));
                }
            };
        }

        public static ExecutorService $default$wrap(Context context, ExecutorService executorService) {
            return new ContextExecutorService(context, executorService);
        }

        public static ScheduledExecutorService $default$wrap(Context context, ScheduledExecutorService scheduledExecutorService) {
            return new ContextScheduledExecutorService(context, scheduledExecutorService);
        }

        public static Function $default$wrapFunction(final Context context, final Function function) {
            return new Function() { // from class: io.opentelemetry.context.Context$$ExternalSyntheticLambda5
                @Override // j$.util.function.Function
                /* renamed from: andThen */
                public final /* synthetic */ Function mo3169andThen(Function function2) {
                    return Function.CC.getAuthRequestContext(this, function2);
                }

                @Override // j$.util.function.Function
                public final Object apply(Object obj) {
                    return Context.CC.$private$lambda$wrapFunction$4(Context.this, function, obj);
                }

                @Override // j$.util.function.Function
                public final /* synthetic */ Function compose(Function function2) {
                    return Function.CC.KClassImpl$Data$declaredNonStaticMembers$2(this, function2);
                }
            };
        }

        public static /* synthetic */ Object $private$lambda$wrapFunction$4(Context context, Function function, Object obj) {
            Scope makeCurrent = context.makeCurrent();
            try {
                Object apply = function.apply(obj);
                if (makeCurrent != null) {
                    makeCurrent.close();
                }
                return apply;
            } catch (Throwable th) {
                if (makeCurrent != null) {
                    try {
                        makeCurrent.close();
                    } catch (Throwable th2) {
                        th.addSuppressed(th2);
                    }
                }
                throw th;
            }
        }

        public static BiFunction $default$wrapFunction(final Context context, final BiFunction biFunction) {
            return new BiFunction() { // from class: io.opentelemetry.context.Context$$ExternalSyntheticLambda1
                @Override // j$.util.function.BiFunction
                public final /* synthetic */ BiFunction andThen(Function function) {
                    return BiFunction.CC.MyBillsEntityDataFactory(this, function);
                }

                @Override // j$.util.function.BiFunction
                public final Object apply(Object obj, Object obj2) {
                    return Context.CC.$private$lambda$wrapFunction$5(Context.this, biFunction, obj, obj2);
                }
            };
        }

        public static /* synthetic */ Object $private$lambda$wrapFunction$5(Context context, BiFunction biFunction, Object obj, Object obj2) {
            Scope makeCurrent = context.makeCurrent();
            try {
                Object apply = biFunction.apply(obj, obj2);
                if (makeCurrent != null) {
                    makeCurrent.close();
                }
                return apply;
            } catch (Throwable th) {
                if (makeCurrent != null) {
                    try {
                        makeCurrent.close();
                    } catch (Throwable th2) {
                        th.addSuppressed(th2);
                    }
                }
                throw th;
            }
        }

        public static Consumer $default$wrapConsumer(final Context context, final Consumer consumer) {
            return new Consumer() { // from class: io.opentelemetry.context.Context$$ExternalSyntheticLambda6
                @Override // j$.util.function.Consumer
                public final void accept(Object obj) {
                    Context.CC.$private$lambda$wrapConsumer$6(Context.this, consumer, obj);
                }

                @Override // j$.util.function.Consumer
                public final /* synthetic */ Consumer andThen(Consumer consumer2) {
                    return Consumer.CC.PlaceComponentResult(this, consumer2);
                }
            };
        }

        public static /* synthetic */ void $private$lambda$wrapConsumer$6(Context context, Consumer consumer, Object obj) {
            Scope makeCurrent = context.makeCurrent();
            try {
                consumer.accept(obj);
                if (makeCurrent != null) {
                    makeCurrent.close();
                }
            } catch (Throwable th) {
                if (makeCurrent != null) {
                    try {
                        makeCurrent.close();
                    } catch (Throwable th2) {
                        th.addSuppressed(th2);
                    }
                }
                throw th;
            }
        }

        public static BiConsumer $default$wrapConsumer(final Context context, final BiConsumer biConsumer) {
            return new BiConsumer() { // from class: io.opentelemetry.context.Context$$ExternalSyntheticLambda3
                @Override // j$.util.function.BiConsumer
                public final void accept(Object obj, Object obj2) {
                    Context.CC.$private$lambda$wrapConsumer$7(Context.this, biConsumer, obj, obj2);
                }

                @Override // j$.util.function.BiConsumer
                public final /* synthetic */ BiConsumer andThen(BiConsumer biConsumer2) {
                    return BiConsumer.CC.getAuthRequestContext(this, biConsumer2);
                }
            };
        }

        public static /* synthetic */ void $private$lambda$wrapConsumer$7(Context context, BiConsumer biConsumer, Object obj, Object obj2) {
            Scope makeCurrent = context.makeCurrent();
            try {
                biConsumer.accept(obj, obj2);
                if (makeCurrent != null) {
                    makeCurrent.close();
                }
            } catch (Throwable th) {
                if (makeCurrent != null) {
                    try {
                        makeCurrent.close();
                    } catch (Throwable th2) {
                        th.addSuppressed(th2);
                    }
                }
                throw th;
            }
        }

        public static Supplier $default$wrapSupplier(final Context context, final Supplier supplier) {
            return new Supplier() { // from class: io.opentelemetry.context.Context$$ExternalSyntheticLambda0
                @Override // j$.util.function.Supplier
                public final Object get() {
                    return Context.CC.$private$lambda$wrapSupplier$8(Context.this, supplier);
                }
            };
        }

        public static /* synthetic */ Object $private$lambda$wrapSupplier$8(Context context, Supplier supplier) {
            Scope makeCurrent = context.makeCurrent();
            try {
                Object obj = supplier.get();
                if (makeCurrent != null) {
                    makeCurrent.close();
                }
                return obj;
            } catch (Throwable th) {
                if (makeCurrent != null) {
                    try {
                        makeCurrent.close();
                    } catch (Throwable th2) {
                        th.addSuppressed(th2);
                    }
                }
                throw th;
            }
        }
    }
}
