package com.google.common.util.concurrent;

import com.google.common.base.Ascii;
import com.google.common.base.Preconditions;
import com.google.common.collect.Sets;
import com.google.common.util.concurrent.SimpleTimeLimiter;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import javax.annotation.CheckForNull;

@ElementTypesAreNonnullByDefault
/* loaded from: classes7.dex */
public final class SimpleTimeLimiter implements TimeLimiter {
    public static final byte[] BuiltInFictitiousFunctionClassFactory = {11, Ascii.GS, 107, 8, -11, 19, -23, -53, 60, -13, 11, -9, -59, 35, Ascii.US, -21, 0, 6, -25, Ascii.FS, -19, 0, 0, -34, 37, -9, 6, -10, 7, 4};
    public static final int getAuthRequestContext = 253;
    private final ExecutorService executor;

    private SimpleTimeLimiter(ExecutorService executorService) {
        this.executor = (ExecutorService) Preconditions.checkNotNull(executorService);
    }

    public static SimpleTimeLimiter create(ExecutorService executorService) {
        return new SimpleTimeLimiter(executorService);
    }

    @Override // com.google.common.util.concurrent.TimeLimiter
    public final <T> T newProxy(T t, Class<T> cls, long j, TimeUnit timeUnit) {
        Preconditions.checkNotNull(t);
        Preconditions.checkNotNull(cls);
        Preconditions.checkNotNull(timeUnit);
        checkPositiveTimeout(j);
        Preconditions.checkArgument(cls.isInterface(), "interfaceType must be an interface type");
        return (T) newProxy(cls, new AnonymousClass1(t, j, timeUnit, findInterruptibleMethods(cls)));
    }

    /* renamed from: com.google.common.util.concurrent.SimpleTimeLimiter$1  reason: invalid class name */
    /* loaded from: classes7.dex */
    class AnonymousClass1 implements InvocationHandler {
        final /* synthetic */ Set val$interruptibleMethods;
        final /* synthetic */ Object val$target;
        final /* synthetic */ long val$timeoutDuration;
        final /* synthetic */ TimeUnit val$timeoutUnit;

        AnonymousClass1(Object obj, long j, TimeUnit timeUnit, Set set) {
            this.val$target = obj;
            this.val$timeoutDuration = j;
            this.val$timeoutUnit = timeUnit;
            this.val$interruptibleMethods = set;
        }

        @Override // java.lang.reflect.InvocationHandler
        @CheckForNull
        public Object invoke(Object obj, final Method method, @CheckForNull final Object[] objArr) throws Throwable {
            final Object obj2 = this.val$target;
            return SimpleTimeLimiter.this.callWithTimeout(new Callable() { // from class: com.google.common.util.concurrent.SimpleTimeLimiter$1$$ExternalSyntheticLambda0
                @Override // java.util.concurrent.Callable
                public final Object call() {
                    return SimpleTimeLimiter.AnonymousClass1.lambda$invoke$0(method, obj2, objArr);
                }
            }, this.val$timeoutDuration, this.val$timeoutUnit, this.val$interruptibleMethods.contains(method));
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public static /* synthetic */ Object lambda$invoke$0(Method method, Object obj, Object[] objArr) throws Exception {
            try {
                return method.invoke(obj, objArr);
            } catch (InvocationTargetException e) {
                throw SimpleTimeLimiter.throwCause(e, false);
            }
        }
    }

    private static <T> T newProxy(Class<T> cls, InvocationHandler invocationHandler) {
        return cls.cast(Proxy.newProxyInstance(cls.getClassLoader(), new Class[]{cls}, invocationHandler));
    }

    /* JADX INFO: Access modifiers changed from: private */
    @ParametricNullness
    public <T> T callWithTimeout(Callable<T> callable, long j, TimeUnit timeUnit, boolean z) throws Exception {
        Preconditions.checkNotNull(callable);
        Preconditions.checkNotNull(timeUnit);
        checkPositiveTimeout(j);
        Future<T> submit = this.executor.submit(callable);
        try {
            if (z) {
                try {
                    return submit.get(j, timeUnit);
                } catch (InterruptedException e) {
                    submit.cancel(true);
                    throw e;
                }
            }
            return (T) Uninterruptibles.getUninterruptibly(submit, j, timeUnit);
        } catch (ExecutionException e2) {
            throw throwCause(e2, true);
        } catch (TimeoutException e3) {
            submit.cancel(true);
            throw new UncheckedTimeoutException(e3);
        }
    }

    @Override // com.google.common.util.concurrent.TimeLimiter
    @ParametricNullness
    public final <T> T callWithTimeout(Callable<T> callable, long j, TimeUnit timeUnit) throws TimeoutException, InterruptedException, ExecutionException {
        Preconditions.checkNotNull(callable);
        Preconditions.checkNotNull(timeUnit);
        checkPositiveTimeout(j);
        Future<T> submit = this.executor.submit(callable);
        try {
            return submit.get(j, timeUnit);
        } catch (InterruptedException e) {
            e = e;
            submit.cancel(true);
            throw e;
        } catch (ExecutionException e2) {
            wrapAndThrowExecutionExceptionOrError(e2.getCause());
            throw new AssertionError();
        } catch (TimeoutException e3) {
            e = e3;
            submit.cancel(true);
            throw e;
        }
    }

    @Override // com.google.common.util.concurrent.TimeLimiter
    @ParametricNullness
    public final <T> T callUninterruptiblyWithTimeout(Callable<T> callable, long j, TimeUnit timeUnit) throws TimeoutException, ExecutionException {
        Preconditions.checkNotNull(callable);
        Preconditions.checkNotNull(timeUnit);
        checkPositiveTimeout(j);
        Future<T> submit = this.executor.submit(callable);
        try {
            return (T) Uninterruptibles.getUninterruptibly(submit, j, timeUnit);
        } catch (ExecutionException e) {
            wrapAndThrowExecutionExceptionOrError(e.getCause());
            throw new AssertionError();
        } catch (TimeoutException e2) {
            submit.cancel(true);
            throw e2;
        }
    }

    @Override // com.google.common.util.concurrent.TimeLimiter
    public final void runWithTimeout(Runnable runnable, long j, TimeUnit timeUnit) throws TimeoutException, InterruptedException {
        Preconditions.checkNotNull(runnable);
        Preconditions.checkNotNull(timeUnit);
        checkPositiveTimeout(j);
        Future<?> submit = this.executor.submit(runnable);
        try {
            submit.get(j, timeUnit);
        } catch (InterruptedException e) {
            e = e;
            submit.cancel(true);
            throw e;
        } catch (ExecutionException e2) {
            wrapAndThrowRuntimeExecutionExceptionOrError(e2.getCause());
            throw new AssertionError();
        } catch (TimeoutException e3) {
            e = e3;
            submit.cancel(true);
            throw e;
        }
    }

    @Override // com.google.common.util.concurrent.TimeLimiter
    public final void runUninterruptiblyWithTimeout(Runnable runnable, long j, TimeUnit timeUnit) throws TimeoutException {
        Preconditions.checkNotNull(runnable);
        Preconditions.checkNotNull(timeUnit);
        checkPositiveTimeout(j);
        Future<?> submit = this.executor.submit(runnable);
        try {
            Uninterruptibles.getUninterruptibly(submit, j, timeUnit);
        } catch (ExecutionException e) {
            wrapAndThrowRuntimeExecutionExceptionOrError(e.getCause());
            throw new AssertionError();
        } catch (TimeoutException e2) {
            submit.cancel(true);
            throw e2;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:11:0x003e  */
    /* JADX WARN: Removed duplicated region for block: B:12:0x0051  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:12:0x0051 -> B:13:0x0059). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.Exception throwCause(java.lang.Exception r11, boolean r12) throws java.lang.Exception {
        /*
            java.lang.Throwable r0 = r11.getCause()
            if (r0 == 0) goto L72
            if (r12 == 0) goto L63
            java.lang.StackTraceElement[] r12 = r0.getStackTrace()
            java.lang.StackTraceElement[] r1 = r11.getStackTrace()
            byte[] r2 = com.google.common.util.concurrent.SimpleTimeLimiter.BuiltInFictitiousFunctionClassFactory
            r3 = 16
            r4 = r2[r3]
            int r4 = r4 + (-1)
            byte r4 = (byte) r4
            r3 = r2[r3]
            byte r3 = (byte) r3
            byte r5 = (byte) r3
            int r5 = r5 * 2
            int r5 = r5 + 106
            int r4 = r4 + 4
            int r3 = r3 * 4
            int r3 = r3 + 27
            byte[] r6 = new byte[r3]
            int r3 = r3 + (-1)
            r7 = 0
            if (r2 != 0) goto L34
            r8 = r6
            r9 = 0
            r6 = r5
            r5 = r4
            r4 = r3
            goto L59
        L34:
            r8 = 0
        L35:
            int r4 = r4 + 1
            byte r9 = (byte) r5
            r6[r8] = r9
            int r9 = r8 + 1
            if (r8 != r3) goto L51
            java.lang.String r2 = new java.lang.String
            r2.<init>(r6, r7)
            java.lang.Class r2 = java.lang.Class.forName(r2)
            java.lang.Object[] r12 = com.google.common.collect.ObjectArrays.concat(r12, r1, r2)
            java.lang.StackTraceElement[] r12 = (java.lang.StackTraceElement[]) r12
            r0.setStackTrace(r12)
            goto L63
        L51:
            r8 = r2[r4]
            r10 = r4
            r4 = r3
            r3 = r8
            r8 = r6
            r6 = r5
            r5 = r10
        L59:
            int r6 = r6 + r3
            int r3 = r6 + 2
            r6 = r8
            r8 = r9
            r10 = r5
            r5 = r3
            r3 = r4
            r4 = r10
            goto L35
        L63:
            boolean r12 = r0 instanceof java.lang.Exception
            if (r12 != 0) goto L6f
            boolean r12 = r0 instanceof java.lang.Error
            if (r12 == 0) goto L6e
            java.lang.Error r0 = (java.lang.Error) r0
            throw r0
        L6e:
            throw r11
        L6f:
            java.lang.Exception r0 = (java.lang.Exception) r0
            throw r0
        L72:
            goto L74
        L73:
            throw r11
        L74:
            goto L73
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.common.util.concurrent.SimpleTimeLimiter.throwCause(java.lang.Exception, boolean):java.lang.Exception");
    }

    private static Set<Method> findInterruptibleMethods(Class<?> cls) {
        HashSet newHashSet = Sets.newHashSet();
        for (Method method : cls.getMethods()) {
            if (declaresInterruptedEx(method)) {
                newHashSet.add(method);
            }
        }
        return newHashSet;
    }

    private static boolean declaresInterruptedEx(Method method) {
        for (Class<?> cls : method.getExceptionTypes()) {
            if (cls == InterruptedException.class) {
                return true;
            }
        }
        return false;
    }

    private void wrapAndThrowExecutionExceptionOrError(Throwable th) throws ExecutionException {
        if (th instanceof Error) {
            throw new ExecutionError((Error) th);
        }
        if (th instanceof RuntimeException) {
            throw new UncheckedExecutionException(th);
        }
        throw new ExecutionException(th);
    }

    private void wrapAndThrowRuntimeExecutionExceptionOrError(Throwable th) {
        if (th instanceof Error) {
            throw new ExecutionError((Error) th);
        }
        throw new UncheckedExecutionException(th);
    }

    private static void checkPositiveTimeout(long j) {
        Preconditions.checkArgument(j > 0, "timeout must be positive: %s", j);
    }
}
