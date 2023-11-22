package androidx.concurrent.futures;

import com.alibaba.ariver.resource.parser.tar.TarHeader;
import com.google.common.base.Ascii;
import com.google.common.util.concurrent.ListenableFuture;
import id.dana.cashier.model.constants.PaymentResultBackToHomeStatus;
import java.util.Locale;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import java.util.concurrent.locks.LockSupport;
import java.util.logging.Level;
import java.util.logging.Logger;

/* loaded from: classes6.dex */
public abstract class AbstractResolvableFuture<V> implements ListenableFuture<V> {
    static final AtomicHelper PlaceComponentResult;
    private static final Object lookAheadTest;
    volatile Listener BuiltInFictitiousFunctionClassFactory;
    volatile Waiter KClassImpl$Data$declaredNonStaticMembers$2;
    volatile Object MyBillsEntityDataFactory;
    public static final byte[] getErrorConfigVersion = {105, Ascii.NAK, -43, 101, 16, -5, -2, -15, 7, 4, -34, 18, 8, -15, -6, 1, -11, 19, -23, -53, 60, -13, 11, -9, -59, 36, 18, 8, -15, -6, 1};
    public static final int moveToNextValue = 54;
    static final boolean getAuthRequestContext = Boolean.parseBoolean(System.getProperty("guava.concurrent.generate_cancellation_cause", "false"));
    private static final Logger scheduleImpl = Logger.getLogger(AbstractResolvableFuture.class.getName());

    static <T> T MyBillsEntityDataFactory(T t) {
        return t;
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x002a  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0022  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x002a -> B:11:0x0038). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void a(short r7, int r8, int r9, java.lang.Object[] r10) {
        /*
            int r9 = r9 * 3
            int r9 = 16 - r9
            int r8 = r8 * 7
            int r8 = r8 + 99
            byte[] r0 = androidx.concurrent.futures.AbstractResolvableFuture.getErrorConfigVersion
            int r7 = r7 * 12
            int r7 = 16 - r7
            byte[] r1 = new byte[r9]
            int r9 = r9 + (-1)
            r2 = 0
            if (r0 != 0) goto L1c
            r8 = r7
            r3 = r1
            r4 = 0
            r1 = r0
            r0 = r10
            r10 = r9
            goto L38
        L1c:
            r3 = 0
        L1d:
            byte r4 = (byte) r8
            r1[r3] = r4
            if (r3 != r9) goto L2a
            java.lang.String r7 = new java.lang.String
            r7.<init>(r1, r2)
            r10[r2] = r7
            return
        L2a:
            int r3 = r3 + 1
            r4 = r0[r7]
            r5 = r8
            r8 = r7
            r7 = r5
            r6 = r10
            r10 = r9
            r9 = r4
            r4 = r3
            r3 = r1
            r1 = r0
            r0 = r6
        L38:
            int r7 = r7 + r9
            int r8 = r8 + 1
            int r7 = r7 + 2
            r9 = r10
            r10 = r0
            r0 = r1
            r1 = r3
            r3 = r4
            r5 = r8
            r8 = r7
            r7 = r5
            goto L1d
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.concurrent.futures.AbstractResolvableFuture.a(short, int, int, java.lang.Object[]):void");
    }

    static {
        AtomicHelper synchronizedHelper;
        try {
            byte b = (byte) (getErrorConfigVersion[15] - 1);
            byte b2 = getErrorConfigVersion[15];
            Object[] objArr = new Object[1];
            a(b, b2, (byte) (b2 - 1), objArr);
            synchronizedHelper = new SafeAtomicHelper(AtomicReferenceFieldUpdater.newUpdater(Waiter.class, Class.forName((String) objArr[0]), "getAuthRequestContext"), AtomicReferenceFieldUpdater.newUpdater(Waiter.class, Waiter.class, "MyBillsEntityDataFactory"), AtomicReferenceFieldUpdater.newUpdater(AbstractResolvableFuture.class, Waiter.class, "KClassImpl$Data$declaredNonStaticMembers$2"), AtomicReferenceFieldUpdater.newUpdater(AbstractResolvableFuture.class, Listener.class, "BuiltInFictitiousFunctionClassFactory"), AtomicReferenceFieldUpdater.newUpdater(AbstractResolvableFuture.class, Object.class, "MyBillsEntityDataFactory"));
            th = null;
        } catch (Throwable th) {
            th = th;
            synchronizedHelper = new SynchronizedHelper();
        }
        PlaceComponentResult = synchronizedHelper;
        if (th != null) {
            scheduleImpl.log(Level.SEVERE, "SafeAtomicHelper is broken!", th);
        }
        lookAheadTest = new Object();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes6.dex */
    public static final class Waiter {
        public static final byte[] BuiltInFictitiousFunctionClassFactory = {56, -119, 46, TarHeader.LF_CONTIG, -16, 5, 2, 15, -7, -4, 34, -18, -8, 15, 6, -1, 11, -19, Ascii.ETB, TarHeader.LF_DIR, -60, 13, -11, 9, 59, -36, -18, -8, 15, 6, -1};
        public static final int KClassImpl$Data$declaredNonStaticMembers$2 = 90;
        static final Waiter PlaceComponentResult = new Waiter((byte) 0);
        volatile Waiter MyBillsEntityDataFactory;
        volatile Thread getAuthRequestContext;

        /* JADX WARN: Removed duplicated region for block: B:10:0x002b  */
        /* JADX WARN: Removed duplicated region for block: B:8:0x0023  */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x002b -> B:11:0x0038). Please submit an issue!!! */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        private static void a(short r6, short r7, int r8, java.lang.Object[] r9) {
            /*
                int r7 = r7 * 7
                int r7 = r7 + 99
                byte[] r0 = androidx.concurrent.futures.AbstractResolvableFuture.Waiter.BuiltInFictitiousFunctionClassFactory
                int r6 = r6 * 3
                int r6 = 16 - r6
                int r8 = r8 * 12
                int r8 = 16 - r8
                byte[] r1 = new byte[r6]
                int r6 = r6 + (-1)
                r2 = 0
                if (r0 != 0) goto L1d
                r3 = r1
                r4 = 0
                r1 = r0
                r0 = r9
                r9 = r8
                r8 = r7
                r7 = r6
                goto L38
            L1d:
                r3 = 0
            L1e:
                byte r4 = (byte) r7
                r1[r3] = r4
                if (r3 != r6) goto L2b
                java.lang.String r6 = new java.lang.String
                r6.<init>(r1, r2)
                r9[r2] = r6
                return
            L2b:
                int r3 = r3 + 1
                r4 = r0[r8]
                r5 = r7
                r7 = r6
                r6 = r4
                r4 = r3
                r3 = r1
                r1 = r0
                r0 = r9
                r9 = r8
                r8 = r5
            L38:
                int r6 = -r6
                int r8 = r8 + r6
                int r6 = r8 + 2
                int r8 = r9 + 1
                r9 = r0
                r0 = r1
                r1 = r3
                r3 = r4
                r5 = r7
                r7 = r6
                r6 = r5
                goto L1e
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.concurrent.futures.AbstractResolvableFuture.Waiter.a(short, short, int, java.lang.Object[]):void");
        }

        private Waiter(byte b) {
        }

        Waiter() {
            AtomicHelper atomicHelper = AbstractResolvableFuture.PlaceComponentResult;
            try {
                byte b = (byte) (BuiltInFictitiousFunctionClassFactory[15] + 1);
                byte b2 = (byte) (-BuiltInFictitiousFunctionClassFactory[15]);
                Object[] objArr = new Object[1];
                a(b, b2, (byte) (b2 - 1), objArr);
                Class<?> cls = Class.forName((String) objArr[0]);
                byte b3 = (byte) (-BuiltInFictitiousFunctionClassFactory[15]);
                Object[] objArr2 = new Object[1];
                a(b3, (byte) (b3 - 1), (byte) (-BuiltInFictitiousFunctionClassFactory[15]), objArr2);
                atomicHelper.BuiltInFictitiousFunctionClassFactory(this, (Thread) cls.getMethod((String) objArr2[0], null).invoke(null, null));
            } catch (Throwable th) {
                Throwable cause = th.getCause();
                if (cause == null) {
                    throw th;
                }
                throw cause;
            }
        }
    }

    private void KClassImpl$Data$declaredNonStaticMembers$2(Waiter waiter) {
        waiter.getAuthRequestContext = null;
        while (true) {
            Waiter waiter2 = this.KClassImpl$Data$declaredNonStaticMembers$2;
            if (waiter2 == Waiter.PlaceComponentResult) {
                return;
            }
            Waiter waiter3 = null;
            while (waiter2 != null) {
                Waiter waiter4 = waiter2.MyBillsEntityDataFactory;
                if (waiter2.getAuthRequestContext != null) {
                    waiter3 = waiter2;
                } else if (waiter3 != null) {
                    waiter3.MyBillsEntityDataFactory = waiter4;
                    if (waiter3.getAuthRequestContext == null) {
                        break;
                    }
                } else if (PlaceComponentResult.BuiltInFictitiousFunctionClassFactory((AbstractResolvableFuture<?>) this, waiter2, waiter4)) {
                }
                waiter2 = waiter4;
            }
            return;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes6.dex */
    public static final class Listener {
        static final Listener PlaceComponentResult = new Listener(null, null);
        final Executor BuiltInFictitiousFunctionClassFactory;
        final Runnable KClassImpl$Data$declaredNonStaticMembers$2;
        Listener MyBillsEntityDataFactory;

        Listener(Runnable runnable, Executor executor) {
            this.KClassImpl$Data$declaredNonStaticMembers$2 = runnable;
            this.BuiltInFictitiousFunctionClassFactory = executor;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes6.dex */
    public static final class Failure {
        static final Failure getAuthRequestContext = new Failure(new Throwable("Failure occurred while trying to finish a future.") { // from class: androidx.concurrent.futures.AbstractResolvableFuture.Failure.1
            @Override // java.lang.Throwable
            public final Throwable fillInStackTrace() {
                synchronized (this) {
                }
                return this;
            }
        });
        final Throwable MyBillsEntityDataFactory;

        Failure(Throwable th) {
            this.MyBillsEntityDataFactory = (Throwable) AbstractResolvableFuture.MyBillsEntityDataFactory(th);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes6.dex */
    public static final class Cancellation {
        static final Cancellation BuiltInFictitiousFunctionClassFactory;
        static final Cancellation MyBillsEntityDataFactory;
        final Throwable KClassImpl$Data$declaredNonStaticMembers$2;
        final boolean PlaceComponentResult;

        static {
            if (AbstractResolvableFuture.getAuthRequestContext) {
                MyBillsEntityDataFactory = null;
                BuiltInFictitiousFunctionClassFactory = null;
                return;
            }
            MyBillsEntityDataFactory = new Cancellation(false, null);
            BuiltInFictitiousFunctionClassFactory = new Cancellation(true, null);
        }

        Cancellation(boolean z, Throwable th) {
            this.PlaceComponentResult = z;
            this.KClassImpl$Data$declaredNonStaticMembers$2 = th;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes6.dex */
    public static final class SetFuture<V> implements Runnable {
        final AbstractResolvableFuture<V> MyBillsEntityDataFactory;
        final ListenableFuture<? extends V> getAuthRequestContext;

        @Override // java.lang.Runnable
        public final void run() {
            if (this.MyBillsEntityDataFactory.MyBillsEntityDataFactory != this) {
                return;
            }
            if (AbstractResolvableFuture.PlaceComponentResult.BuiltInFictitiousFunctionClassFactory((AbstractResolvableFuture<?>) this.MyBillsEntityDataFactory, (Object) this, AbstractResolvableFuture.getAuthRequestContext(this.getAuthRequestContext))) {
                AbstractResolvableFuture.getAuthRequestContext((AbstractResolvableFuture<?>) this.MyBillsEntityDataFactory);
            }
        }
    }

    @Override // java.util.concurrent.Future
    public final V get(long j, TimeUnit timeUnit) throws InterruptedException, TimeoutException, ExecutionException {
        long nanos = timeUnit.toNanos(j);
        if (Thread.interrupted()) {
            throw new InterruptedException();
        }
        Object obj = this.MyBillsEntityDataFactory;
        if ((obj != null) & (!(obj instanceof SetFuture))) {
            return (V) PlaceComponentResult(obj);
        }
        long nanoTime = nanos > 0 ? System.nanoTime() + nanos : 0L;
        if (nanos >= 1000) {
            Waiter waiter = this.KClassImpl$Data$declaredNonStaticMembers$2;
            if (waiter != Waiter.PlaceComponentResult) {
                Waiter waiter2 = new Waiter();
                do {
                    PlaceComponentResult.getAuthRequestContext(waiter2, waiter);
                    if (PlaceComponentResult.BuiltInFictitiousFunctionClassFactory((AbstractResolvableFuture<?>) this, waiter, waiter2)) {
                        do {
                            LockSupport.parkNanos(this, nanos);
                            if (Thread.interrupted()) {
                                KClassImpl$Data$declaredNonStaticMembers$2(waiter2);
                                throw new InterruptedException();
                            }
                            Object obj2 = this.MyBillsEntityDataFactory;
                            if ((obj2 != null) & (!(obj2 instanceof SetFuture))) {
                                return (V) PlaceComponentResult(obj2);
                            }
                            nanos = nanoTime - System.nanoTime();
                        } while (nanos >= 1000);
                        KClassImpl$Data$declaredNonStaticMembers$2(waiter2);
                    } else {
                        waiter = this.KClassImpl$Data$declaredNonStaticMembers$2;
                    }
                } while (waiter != Waiter.PlaceComponentResult);
            }
            return (V) PlaceComponentResult(this.MyBillsEntityDataFactory);
        }
        while (nanos > 0) {
            Object obj3 = this.MyBillsEntityDataFactory;
            if ((obj3 != null) & (!(obj3 instanceof SetFuture))) {
                return (V) PlaceComponentResult(obj3);
            }
            if (Thread.interrupted()) {
                throw new InterruptedException();
            }
            nanos = nanoTime - System.nanoTime();
        }
        String obj4 = toString();
        String lowerCase = timeUnit.toString().toLowerCase(Locale.ROOT);
        StringBuilder sb = new StringBuilder();
        sb.append("Waited ");
        sb.append(j);
        sb.append(" ");
        sb.append(timeUnit.toString().toLowerCase(Locale.ROOT));
        String obj5 = sb.toString();
        if (nanos + 1000 < 0) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append(obj5);
            sb2.append(" (plus ");
            String obj6 = sb2.toString();
            long j2 = -nanos;
            long convert = timeUnit.convert(j2, TimeUnit.NANOSECONDS);
            long nanos2 = j2 - timeUnit.toNanos(convert);
            boolean z = convert == 0 || nanos2 > 1000;
            if (convert > 0) {
                StringBuilder sb3 = new StringBuilder();
                sb3.append(obj6);
                sb3.append(convert);
                sb3.append(" ");
                sb3.append(lowerCase);
                String obj7 = sb3.toString();
                if (z) {
                    StringBuilder sb4 = new StringBuilder();
                    sb4.append(obj7);
                    sb4.append(",");
                    obj7 = sb4.toString();
                }
                StringBuilder sb5 = new StringBuilder();
                sb5.append(obj7);
                sb5.append(" ");
                obj6 = sb5.toString();
            }
            if (z) {
                StringBuilder sb6 = new StringBuilder();
                sb6.append(obj6);
                sb6.append(nanos2);
                sb6.append(" nanoseconds ");
                obj6 = sb6.toString();
            }
            StringBuilder sb7 = new StringBuilder();
            sb7.append(obj6);
            sb7.append("delay)");
            obj5 = sb7.toString();
        }
        if (isDone()) {
            StringBuilder sb8 = new StringBuilder();
            sb8.append(obj5);
            sb8.append(" but future completed as timeout expired");
            throw new TimeoutException(sb8.toString());
        }
        StringBuilder sb9 = new StringBuilder();
        sb9.append(obj5);
        sb9.append(" for ");
        sb9.append(obj4);
        throw new TimeoutException(sb9.toString());
    }

    @Override // java.util.concurrent.Future
    public final V get() throws InterruptedException, ExecutionException {
        Object obj;
        if (Thread.interrupted()) {
            throw new InterruptedException();
        }
        Object obj2 = this.MyBillsEntityDataFactory;
        if ((obj2 != null) & (!(obj2 instanceof SetFuture))) {
            return (V) PlaceComponentResult(obj2);
        }
        Waiter waiter = this.KClassImpl$Data$declaredNonStaticMembers$2;
        if (waiter != Waiter.PlaceComponentResult) {
            Waiter waiter2 = new Waiter();
            do {
                PlaceComponentResult.getAuthRequestContext(waiter2, waiter);
                if (PlaceComponentResult.BuiltInFictitiousFunctionClassFactory((AbstractResolvableFuture<?>) this, waiter, waiter2)) {
                    do {
                        LockSupport.park(this);
                        if (Thread.interrupted()) {
                            KClassImpl$Data$declaredNonStaticMembers$2(waiter2);
                            throw new InterruptedException();
                        }
                        obj = this.MyBillsEntityDataFactory;
                    } while (!((obj != null) & (!(obj instanceof SetFuture))));
                    return (V) PlaceComponentResult(obj);
                }
                waiter = this.KClassImpl$Data$declaredNonStaticMembers$2;
            } while (waiter != Waiter.PlaceComponentResult);
        }
        return (V) PlaceComponentResult(this.MyBillsEntityDataFactory);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static V PlaceComponentResult(Object obj) throws ExecutionException {
        if (obj instanceof Cancellation) {
            Throwable th = ((Cancellation) obj).KClassImpl$Data$declaredNonStaticMembers$2;
            CancellationException cancellationException = new CancellationException("Task was cancelled.");
            cancellationException.initCause(th);
            throw cancellationException;
        } else if (obj instanceof Failure) {
            throw new ExecutionException(((Failure) obj).MyBillsEntityDataFactory);
        } else {
            if (obj == lookAheadTest) {
                return null;
            }
            return obj;
        }
    }

    @Override // java.util.concurrent.Future
    public final boolean isDone() {
        return (!(r0 instanceof SetFuture)) & (this.MyBillsEntityDataFactory != null);
    }

    @Override // java.util.concurrent.Future
    public final boolean isCancelled() {
        return this.MyBillsEntityDataFactory instanceof Cancellation;
    }

    @Override // java.util.concurrent.Future
    public final boolean cancel(boolean z) {
        Object obj = this.MyBillsEntityDataFactory;
        if ((obj == null) || (obj instanceof SetFuture)) {
            Cancellation cancellation = getAuthRequestContext ? new Cancellation(z, new CancellationException("Future.cancel() was called.")) : z ? Cancellation.BuiltInFictitiousFunctionClassFactory : Cancellation.MyBillsEntityDataFactory;
            boolean z2 = false;
            AbstractResolvableFuture<V> abstractResolvableFuture = this;
            while (true) {
                if (PlaceComponentResult.BuiltInFictitiousFunctionClassFactory((AbstractResolvableFuture<?>) abstractResolvableFuture, obj, (Object) cancellation)) {
                    getAuthRequestContext((AbstractResolvableFuture<?>) abstractResolvableFuture);
                    if (!(obj instanceof SetFuture)) {
                        break;
                    }
                    ListenableFuture<? extends V> listenableFuture = ((SetFuture) obj).getAuthRequestContext;
                    if (listenableFuture instanceof AbstractResolvableFuture) {
                        abstractResolvableFuture = (AbstractResolvableFuture) listenableFuture;
                        obj = abstractResolvableFuture.MyBillsEntityDataFactory;
                        if (!(obj == null) && !(obj instanceof SetFuture)) {
                            break;
                        }
                        z2 = true;
                    } else {
                        listenableFuture.cancel(z);
                        break;
                    }
                } else {
                    obj = abstractResolvableFuture.MyBillsEntityDataFactory;
                    if (!(obj instanceof SetFuture)) {
                        return z2;
                    }
                }
            }
            return true;
        }
        return false;
    }

    @Override // com.google.common.util.concurrent.ListenableFuture
    public final void addListener(Runnable runnable, Executor executor) {
        Listener listener = this.BuiltInFictitiousFunctionClassFactory;
        if (listener != Listener.PlaceComponentResult) {
            Listener listener2 = new Listener(runnable, executor);
            do {
                listener2.MyBillsEntityDataFactory = listener;
                if (PlaceComponentResult.MyBillsEntityDataFactory(this, listener, listener2)) {
                    return;
                }
                listener = this.BuiltInFictitiousFunctionClassFactory;
            } while (listener != Listener.PlaceComponentResult);
        }
        KClassImpl$Data$declaredNonStaticMembers$2(runnable, executor);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean BuiltInFictitiousFunctionClassFactory(V v) {
        if (v == null) {
            v = (V) lookAheadTest;
        }
        if (PlaceComponentResult.BuiltInFictitiousFunctionClassFactory((AbstractResolvableFuture<?>) this, (Object) null, (Object) v)) {
            getAuthRequestContext((AbstractResolvableFuture<?>) this);
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean KClassImpl$Data$declaredNonStaticMembers$2(Throwable th) {
        if (PlaceComponentResult.BuiltInFictitiousFunctionClassFactory((AbstractResolvableFuture<?>) this, (Object) null, (Object) new Failure(th))) {
            getAuthRequestContext((AbstractResolvableFuture<?>) this);
            return true;
        }
        return false;
    }

    static Object getAuthRequestContext(ListenableFuture<?> listenableFuture) {
        if (listenableFuture instanceof AbstractResolvableFuture) {
            Object obj = ((AbstractResolvableFuture) listenableFuture).MyBillsEntityDataFactory;
            if (obj instanceof Cancellation) {
                Cancellation cancellation = (Cancellation) obj;
                return cancellation.PlaceComponentResult ? cancellation.KClassImpl$Data$declaredNonStaticMembers$2 != null ? new Cancellation(false, cancellation.KClassImpl$Data$declaredNonStaticMembers$2) : Cancellation.MyBillsEntityDataFactory : obj;
            }
            return obj;
        }
        boolean isCancelled = listenableFuture.isCancelled();
        if ((!getAuthRequestContext) & isCancelled) {
            return Cancellation.MyBillsEntityDataFactory;
        }
        try {
            Object MyBillsEntityDataFactory = MyBillsEntityDataFactory((Future<Object>) listenableFuture);
            return MyBillsEntityDataFactory == null ? lookAheadTest : MyBillsEntityDataFactory;
        } catch (CancellationException e) {
            if (!isCancelled) {
                StringBuilder sb = new StringBuilder();
                sb.append("get() threw CancellationException, despite reporting isCancelled() == false: ");
                sb.append(listenableFuture);
                return new Failure(new IllegalArgumentException(sb.toString(), e));
            }
            return new Cancellation(false, e);
        } catch (ExecutionException e2) {
            return new Failure(e2.getCause());
        } catch (Throwable th) {
            return new Failure(th);
        }
    }

    private static <V> V MyBillsEntityDataFactory(Future<V> future) throws ExecutionException {
        V v;
        boolean z = false;
        while (true) {
            try {
                v = future.get();
                break;
            } catch (InterruptedException unused) {
                z = true;
            } catch (Throwable th) {
                if (z) {
                    try {
                        byte b = (byte) (getErrorConfigVersion[15] - 1);
                        byte b2 = getErrorConfigVersion[15];
                        Object[] objArr = new Object[1];
                        a(b, b2, (byte) (b2 - 1), objArr);
                        Class<?> cls = Class.forName((String) objArr[0]);
                        byte b3 = getErrorConfigVersion[15];
                        Object[] objArr2 = new Object[1];
                        a(b3, (byte) (b3 - 1), getErrorConfigVersion[15], objArr2);
                        ((Thread) cls.getMethod((String) objArr2[0], null).invoke(null, null)).interrupt();
                    } catch (Throwable th2) {
                        Throwable cause = th2.getCause();
                        if (cause != null) {
                            throw cause;
                        }
                        throw th2;
                    }
                }
                throw th;
            }
        }
        if (z) {
            try {
                byte b4 = (byte) (getErrorConfigVersion[15] - 1);
                byte b5 = getErrorConfigVersion[15];
                Object[] objArr3 = new Object[1];
                a(b4, b5, (byte) (b5 - 1), objArr3);
                Class<?> cls2 = Class.forName((String) objArr3[0]);
                byte b6 = getErrorConfigVersion[15];
                Object[] objArr4 = new Object[1];
                a(b6, (byte) (b6 - 1), getErrorConfigVersion[15], objArr4);
                ((Thread) cls2.getMethod((String) objArr4[0], null).invoke(null, null)).interrupt();
            } catch (Throwable th3) {
                Throwable cause2 = th3.getCause();
                if (cause2 != null) {
                    throw cause2;
                }
                throw th3;
            }
        }
        return v;
    }

    public String toString() {
        String obj;
        StringBuilder sb = new StringBuilder();
        sb.append(super.toString());
        sb.append("[status=");
        if (isCancelled()) {
            sb.append(PaymentResultBackToHomeStatus.CANCELLED);
        } else if (isDone()) {
            PlaceComponentResult(sb);
        } else {
            try {
                obj = PlaceComponentResult();
            } catch (RuntimeException e) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("Exception thrown from implementation: ");
                sb2.append(e.getClass());
                obj = sb2.toString();
            }
            if (obj != null && !obj.isEmpty()) {
                sb.append("PENDING, info=[");
                sb.append(obj);
                sb.append("]");
            } else if (isDone()) {
                PlaceComponentResult(sb);
            } else {
                sb.append("PENDING");
            }
        }
        sb.append("]");
        return sb.toString();
    }

    protected String PlaceComponentResult() {
        Object obj = this.MyBillsEntityDataFactory;
        if (obj instanceof SetFuture) {
            StringBuilder sb = new StringBuilder();
            sb.append("setFuture=[");
            ListenableFuture<? extends V> listenableFuture = ((SetFuture) obj).getAuthRequestContext;
            sb.append(listenableFuture == this ? "this future" : String.valueOf(listenableFuture));
            sb.append("]");
            return sb.toString();
        } else if (this instanceof ScheduledFuture) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("remaining delay=[");
            sb2.append(((ScheduledFuture) this).getDelay(TimeUnit.MILLISECONDS));
            sb2.append(" ms]");
            return sb2.toString();
        } else {
            return null;
        }
    }

    private void PlaceComponentResult(StringBuilder sb) {
        try {
            Object MyBillsEntityDataFactory = MyBillsEntityDataFactory((Future<Object>) this);
            sb.append("SUCCESS, result=[");
            sb.append(MyBillsEntityDataFactory == this ? "this future" : String.valueOf(MyBillsEntityDataFactory));
            sb.append("]");
        } catch (CancellationException unused) {
            sb.append(PaymentResultBackToHomeStatus.CANCELLED);
        } catch (RuntimeException e) {
            sb.append("UNKNOWN, cause=[");
            sb.append(e.getClass());
            sb.append(" thrown from get()]");
        } catch (ExecutionException e2) {
            sb.append("FAILURE, cause=[");
            sb.append(e2.getCause());
            sb.append("]");
        }
    }

    private static void KClassImpl$Data$declaredNonStaticMembers$2(Runnable runnable, Executor executor) {
        try {
            executor.execute(runnable);
        } catch (RuntimeException e) {
            Logger logger = scheduleImpl;
            Level level = Level.SEVERE;
            StringBuilder sb = new StringBuilder();
            sb.append("RuntimeException while executing runnable ");
            sb.append(runnable);
            sb.append(" with executor ");
            sb.append(executor);
            logger.log(level, sb.toString(), (Throwable) e);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes6.dex */
    public static abstract class AtomicHelper {
        abstract void BuiltInFictitiousFunctionClassFactory(Waiter waiter, Thread thread);

        abstract boolean BuiltInFictitiousFunctionClassFactory(AbstractResolvableFuture<?> abstractResolvableFuture, Waiter waiter, Waiter waiter2);

        abstract boolean BuiltInFictitiousFunctionClassFactory(AbstractResolvableFuture<?> abstractResolvableFuture, Object obj, Object obj2);

        abstract boolean MyBillsEntityDataFactory(AbstractResolvableFuture<?> abstractResolvableFuture, Listener listener, Listener listener2);

        abstract void getAuthRequestContext(Waiter waiter, Waiter waiter2);

        private AtomicHelper() {
        }

        /* synthetic */ AtomicHelper(byte b) {
            this();
        }
    }

    /* loaded from: classes6.dex */
    static final class SafeAtomicHelper extends AtomicHelper {
        final AtomicReferenceFieldUpdater<AbstractResolvableFuture, Object> BuiltInFictitiousFunctionClassFactory;
        final AtomicReferenceFieldUpdater<Waiter, Waiter> KClassImpl$Data$declaredNonStaticMembers$2;
        final AtomicReferenceFieldUpdater<AbstractResolvableFuture, Waiter> MyBillsEntityDataFactory;
        final AtomicReferenceFieldUpdater<AbstractResolvableFuture, Listener> PlaceComponentResult;
        final AtomicReferenceFieldUpdater<Waiter, Thread> getAuthRequestContext;

        SafeAtomicHelper(AtomicReferenceFieldUpdater<Waiter, Thread> atomicReferenceFieldUpdater, AtomicReferenceFieldUpdater<Waiter, Waiter> atomicReferenceFieldUpdater2, AtomicReferenceFieldUpdater<AbstractResolvableFuture, Waiter> atomicReferenceFieldUpdater3, AtomicReferenceFieldUpdater<AbstractResolvableFuture, Listener> atomicReferenceFieldUpdater4, AtomicReferenceFieldUpdater<AbstractResolvableFuture, Object> atomicReferenceFieldUpdater5) {
            super((byte) 0);
            this.getAuthRequestContext = atomicReferenceFieldUpdater;
            this.KClassImpl$Data$declaredNonStaticMembers$2 = atomicReferenceFieldUpdater2;
            this.MyBillsEntityDataFactory = atomicReferenceFieldUpdater3;
            this.PlaceComponentResult = atomicReferenceFieldUpdater4;
            this.BuiltInFictitiousFunctionClassFactory = atomicReferenceFieldUpdater5;
        }

        @Override // androidx.concurrent.futures.AbstractResolvableFuture.AtomicHelper
        final void BuiltInFictitiousFunctionClassFactory(Waiter waiter, Thread thread) {
            this.getAuthRequestContext.lazySet(waiter, thread);
        }

        @Override // androidx.concurrent.futures.AbstractResolvableFuture.AtomicHelper
        final void getAuthRequestContext(Waiter waiter, Waiter waiter2) {
            this.KClassImpl$Data$declaredNonStaticMembers$2.lazySet(waiter, waiter2);
        }

        @Override // androidx.concurrent.futures.AbstractResolvableFuture.AtomicHelper
        final boolean BuiltInFictitiousFunctionClassFactory(AbstractResolvableFuture<?> abstractResolvableFuture, Waiter waiter, Waiter waiter2) {
            return AbstractResolvableFuture$SafeAtomicHelper$$ExternalSyntheticBackportWithForwarding0.MyBillsEntityDataFactory(this.MyBillsEntityDataFactory, abstractResolvableFuture, waiter, waiter2);
        }

        @Override // androidx.concurrent.futures.AbstractResolvableFuture.AtomicHelper
        final boolean MyBillsEntityDataFactory(AbstractResolvableFuture<?> abstractResolvableFuture, Listener listener, Listener listener2) {
            return AbstractResolvableFuture$SafeAtomicHelper$$ExternalSyntheticBackportWithForwarding0.MyBillsEntityDataFactory(this.PlaceComponentResult, abstractResolvableFuture, listener, listener2);
        }

        @Override // androidx.concurrent.futures.AbstractResolvableFuture.AtomicHelper
        final boolean BuiltInFictitiousFunctionClassFactory(AbstractResolvableFuture<?> abstractResolvableFuture, Object obj, Object obj2) {
            return AbstractResolvableFuture$SafeAtomicHelper$$ExternalSyntheticBackportWithForwarding0.MyBillsEntityDataFactory(this.BuiltInFictitiousFunctionClassFactory, abstractResolvableFuture, obj, obj2);
        }
    }

    /* loaded from: classes6.dex */
    static final class SynchronizedHelper extends AtomicHelper {
        SynchronizedHelper() {
            super((byte) 0);
        }

        @Override // androidx.concurrent.futures.AbstractResolvableFuture.AtomicHelper
        final void BuiltInFictitiousFunctionClassFactory(Waiter waiter, Thread thread) {
            waiter.getAuthRequestContext = thread;
        }

        @Override // androidx.concurrent.futures.AbstractResolvableFuture.AtomicHelper
        final void getAuthRequestContext(Waiter waiter, Waiter waiter2) {
            waiter.MyBillsEntityDataFactory = waiter2;
        }

        @Override // androidx.concurrent.futures.AbstractResolvableFuture.AtomicHelper
        final boolean BuiltInFictitiousFunctionClassFactory(AbstractResolvableFuture<?> abstractResolvableFuture, Waiter waiter, Waiter waiter2) {
            synchronized (abstractResolvableFuture) {
                if (abstractResolvableFuture.KClassImpl$Data$declaredNonStaticMembers$2 == waiter) {
                    abstractResolvableFuture.KClassImpl$Data$declaredNonStaticMembers$2 = waiter2;
                    return true;
                }
                return false;
            }
        }

        @Override // androidx.concurrent.futures.AbstractResolvableFuture.AtomicHelper
        final boolean MyBillsEntityDataFactory(AbstractResolvableFuture<?> abstractResolvableFuture, Listener listener, Listener listener2) {
            synchronized (abstractResolvableFuture) {
                if (abstractResolvableFuture.BuiltInFictitiousFunctionClassFactory == listener) {
                    abstractResolvableFuture.BuiltInFictitiousFunctionClassFactory = listener2;
                    return true;
                }
                return false;
            }
        }

        @Override // androidx.concurrent.futures.AbstractResolvableFuture.AtomicHelper
        final boolean BuiltInFictitiousFunctionClassFactory(AbstractResolvableFuture<?> abstractResolvableFuture, Object obj, Object obj2) {
            synchronized (abstractResolvableFuture) {
                if (abstractResolvableFuture.MyBillsEntityDataFactory == obj) {
                    abstractResolvableFuture.MyBillsEntityDataFactory = obj2;
                    return true;
                }
                return false;
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v2, types: [androidx.concurrent.futures.AbstractResolvableFuture$AtomicHelper] */
    /* JADX WARN: Type inference failed for: r5v0, types: [androidx.concurrent.futures.AbstractResolvableFuture<?>] */
    /* JADX WARN: Type inference failed for: r5v1, types: [androidx.concurrent.futures.AbstractResolvableFuture] */
    /* JADX WARN: Type inference failed for: r5v2 */
    /* JADX WARN: Type inference failed for: r5v7, types: [androidx.concurrent.futures.AbstractResolvableFuture, androidx.concurrent.futures.AbstractResolvableFuture<V>] */
    static void getAuthRequestContext(AbstractResolvableFuture<?> abstractResolvableFuture) {
        Listener listener;
        Listener listener2;
        Listener listener3 = null;
        while (true) {
            Waiter waiter = ((AbstractResolvableFuture) abstractResolvableFuture).KClassImpl$Data$declaredNonStaticMembers$2;
            if (PlaceComponentResult.BuiltInFictitiousFunctionClassFactory((AbstractResolvableFuture) abstractResolvableFuture, waiter, Waiter.PlaceComponentResult)) {
                while (waiter != null) {
                    Thread thread = waiter.getAuthRequestContext;
                    if (thread != null) {
                        waiter.getAuthRequestContext = null;
                        LockSupport.unpark(thread);
                    }
                    waiter = waiter.MyBillsEntityDataFactory;
                }
                do {
                    listener = ((AbstractResolvableFuture) abstractResolvableFuture).BuiltInFictitiousFunctionClassFactory;
                } while (!PlaceComponentResult.MyBillsEntityDataFactory((AbstractResolvableFuture) abstractResolvableFuture, listener, Listener.PlaceComponentResult));
                while (true) {
                    listener2 = listener3;
                    listener3 = listener;
                    if (listener3 == null) {
                        break;
                    }
                    listener = listener3.MyBillsEntityDataFactory;
                    listener3.MyBillsEntityDataFactory = listener2;
                }
                while (listener2 != null) {
                    listener3 = listener2.MyBillsEntityDataFactory;
                    Runnable runnable = listener2.KClassImpl$Data$declaredNonStaticMembers$2;
                    if (runnable instanceof SetFuture) {
                        SetFuture setFuture = (SetFuture) runnable;
                        abstractResolvableFuture = setFuture.MyBillsEntityDataFactory;
                        if (abstractResolvableFuture.MyBillsEntityDataFactory == setFuture) {
                            if (PlaceComponentResult.BuiltInFictitiousFunctionClassFactory(abstractResolvableFuture, setFuture, getAuthRequestContext(setFuture.getAuthRequestContext))) {
                                break;
                            }
                        } else {
                            continue;
                        }
                    } else {
                        KClassImpl$Data$declaredNonStaticMembers$2(runnable, listener2.BuiltInFictitiousFunctionClassFactory);
                    }
                    listener2 = listener3;
                }
                return;
            }
        }
    }
}
