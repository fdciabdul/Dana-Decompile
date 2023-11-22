package androidx.work.impl.utils.futures;

import androidx.concurrent.futures.AbstractResolvableFuture$SafeAtomicHelper$$ExternalSyntheticBackportWithForwarding0;
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

/* loaded from: classes3.dex */
public abstract class AbstractFuture<V> implements ListenableFuture<V> {
    static final AtomicHelper BuiltInFictitiousFunctionClassFactory;
    private static final Object NetworkUserEntityData$$ExternalSyntheticLambda0;
    volatile Object KClassImpl$Data$declaredNonStaticMembers$2;
    volatile Listener MyBillsEntityDataFactory;
    volatile Waiter getAuthRequestContext;
    public static final byte[] moveToNextValue = {93, 18, 67, -65, 16, -5, -2, -15, 7, 4, -34, 18, 8, -15, -6, 1, -11, 19, -23, -53, 60, -13, 11, -9, -59, 36, 18, 8, -15, -6, 1};
    public static final int scheduleImpl = 105;
    static final boolean PlaceComponentResult = Boolean.parseBoolean(System.getProperty("guava.concurrent.generate_cancellation_cause", "false"));
    private static final Logger lookAheadTest = Logger.getLogger(AbstractFuture.class.getName());

    static <T> T MyBillsEntityDataFactory(T t) {
        return t;
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0029  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0021  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x0029 -> B:11:0x0030). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void a(byte r6, int r7, int r8, java.lang.Object[] r9) {
        /*
            int r8 = r8 * 7
            int r8 = 106 - r8
            int r7 = r7 * 3
            int r7 = 16 - r7
            int r6 = r6 * 12
            int r6 = 15 - r6
            byte[] r0 = androidx.work.impl.utils.futures.AbstractFuture.moveToNextValue
            byte[] r1 = new byte[r7]
            int r7 = r7 + (-1)
            r2 = 0
            if (r0 != 0) goto L19
            r4 = r8
            r3 = 0
            r8 = r7
            goto L30
        L19:
            r3 = 0
        L1a:
            int r6 = r6 + 1
            byte r4 = (byte) r8
            r1[r3] = r4
            if (r3 != r7) goto L29
            java.lang.String r6 = new java.lang.String
            r6.<init>(r1, r2)
            r9[r2] = r6
            return
        L29:
            int r3 = r3 + 1
            r4 = r0[r6]
            r5 = r8
            r8 = r7
            r7 = r5
        L30:
            int r7 = r7 + r4
            int r7 = r7 + 2
            r5 = r8
            r8 = r7
            r7 = r5
            goto L1a
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.work.impl.utils.futures.AbstractFuture.a(byte, int, int, java.lang.Object[]):void");
    }

    static {
        AtomicHelper synchronizedHelper;
        try {
            byte b = (byte) (moveToNextValue[15] - 1);
            byte b2 = b;
            Object[] objArr = new Object[1];
            a(b, b2, b2, objArr);
            synchronizedHelper = new SafeAtomicHelper(AtomicReferenceFieldUpdater.newUpdater(Waiter.class, Class.forName((String) objArr[0]), "getAuthRequestContext"), AtomicReferenceFieldUpdater.newUpdater(Waiter.class, Waiter.class, "PlaceComponentResult"), AtomicReferenceFieldUpdater.newUpdater(AbstractFuture.class, Waiter.class, "getAuthRequestContext"), AtomicReferenceFieldUpdater.newUpdater(AbstractFuture.class, Listener.class, "MyBillsEntityDataFactory"), AtomicReferenceFieldUpdater.newUpdater(AbstractFuture.class, Object.class, "KClassImpl$Data$declaredNonStaticMembers$2"));
            th = null;
        } catch (Throwable th) {
            th = th;
            synchronizedHelper = new SynchronizedHelper();
        }
        BuiltInFictitiousFunctionClassFactory = synchronizedHelper;
        if (th != null) {
            lookAheadTest.log(Level.SEVERE, "SafeAtomicHelper is broken!", th);
        }
        NetworkUserEntityData$$ExternalSyntheticLambda0 = new Object();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public static final class Waiter {
        volatile Waiter PlaceComponentResult;
        volatile Thread getAuthRequestContext;
        public static final byte[] MyBillsEntityDataFactory = {Ascii.RS, 119, -63, 113, -16, 5, 2, 15, -7, -4, 34, -18, -8, 15, 6, -1, 11, -19, Ascii.ETB, TarHeader.LF_DIR, -60, 13, -11, 9, 59, -36, -18, -8, 15, 6, -1};
        public static final int BuiltInFictitiousFunctionClassFactory = 100;
        static final Waiter KClassImpl$Data$declaredNonStaticMembers$2 = new Waiter((byte) 0);

        /* JADX WARN: Removed duplicated region for block: B:10:0x002a  */
        /* JADX WARN: Removed duplicated region for block: B:8:0x0022  */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x002a -> B:11:0x0035). Please submit an issue!!! */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        private static void a(byte r8, short r9, byte r10, java.lang.Object[] r11) {
            /*
                int r8 = r8 + 4
                byte[] r0 = androidx.work.impl.utils.futures.AbstractFuture.Waiter.MyBillsEntityDataFactory
                int r10 = r10 * 3
                int r10 = 16 - r10
                int r9 = r9 * 7
                int r9 = 106 - r9
                byte[] r1 = new byte[r10]
                r2 = 0
                if (r0 != 0) goto L18
                r9 = r8
                r3 = r1
                r5 = 0
                r1 = r0
                r0 = r11
                r11 = r10
                goto L35
            L18:
                r3 = 0
            L19:
                int r8 = r8 + 1
                byte r4 = (byte) r9
                int r5 = r3 + 1
                r1[r3] = r4
                if (r5 != r10) goto L2a
                java.lang.String r8 = new java.lang.String
                r8.<init>(r1, r2)
                r11[r2] = r8
                return
            L2a:
                r3 = r0[r8]
                r6 = r9
                r9 = r8
                r8 = r6
                r7 = r11
                r11 = r10
                r10 = r3
                r3 = r1
                r1 = r0
                r0 = r7
            L35:
                int r10 = -r10
                int r8 = r8 + r10
                int r8 = r8 + 2
                r10 = r11
                r11 = r0
                r0 = r1
                r1 = r3
                r3 = r5
                r6 = r9
                r9 = r8
                r8 = r6
                goto L19
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.work.impl.utils.futures.AbstractFuture.Waiter.a(byte, short, byte, java.lang.Object[]):void");
        }

        private Waiter(byte b) {
        }

        Waiter() {
            AtomicHelper atomicHelper = AbstractFuture.BuiltInFictitiousFunctionClassFactory;
            try {
                byte b = MyBillsEntityDataFactory[16];
                byte b2 = (byte) (MyBillsEntityDataFactory[15] + 1);
                Object[] objArr = new Object[1];
                a(b, b2, b2, objArr);
                Class<?> cls = Class.forName((String) objArr[0]);
                byte b3 = MyBillsEntityDataFactory[15];
                byte b4 = (byte) (-b3);
                Object[] objArr2 = new Object[1];
                a(b3, b4, b4, objArr2);
                atomicHelper.getAuthRequestContext(this, (Thread) cls.getMethod((String) objArr2[0], null).invoke(null, null));
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
            Waiter waiter2 = this.getAuthRequestContext;
            if (waiter2 == Waiter.KClassImpl$Data$declaredNonStaticMembers$2) {
                return;
            }
            Waiter waiter3 = null;
            while (waiter2 != null) {
                Waiter waiter4 = waiter2.PlaceComponentResult;
                if (waiter2.getAuthRequestContext != null) {
                    waiter3 = waiter2;
                } else if (waiter3 != null) {
                    waiter3.PlaceComponentResult = waiter4;
                    if (waiter3.getAuthRequestContext == null) {
                        break;
                    }
                } else if (BuiltInFictitiousFunctionClassFactory.PlaceComponentResult(this, waiter2, waiter4)) {
                }
                waiter2 = waiter4;
            }
            return;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public static final class Listener {
        static final Listener KClassImpl$Data$declaredNonStaticMembers$2 = new Listener(null, null);
        final Runnable BuiltInFictitiousFunctionClassFactory;
        final Executor MyBillsEntityDataFactory;
        Listener PlaceComponentResult;

        Listener(Runnable runnable, Executor executor) {
            this.BuiltInFictitiousFunctionClassFactory = runnable;
            this.MyBillsEntityDataFactory = executor;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public static final class Failure {
        static final Failure KClassImpl$Data$declaredNonStaticMembers$2 = new Failure(new Throwable("Failure occurred while trying to finish a future.") { // from class: androidx.work.impl.utils.futures.AbstractFuture.Failure.1
            @Override // java.lang.Throwable
            public Throwable fillInStackTrace() {
                synchronized (this) {
                }
                return this;
            }
        });
        final Throwable MyBillsEntityDataFactory;

        Failure(Throwable th) {
            this.MyBillsEntityDataFactory = (Throwable) AbstractFuture.MyBillsEntityDataFactory(th);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public static final class Cancellation {
        static final Cancellation MyBillsEntityDataFactory;
        static final Cancellation getAuthRequestContext;
        final Throwable BuiltInFictitiousFunctionClassFactory;
        final boolean KClassImpl$Data$declaredNonStaticMembers$2;

        static {
            if (AbstractFuture.PlaceComponentResult) {
                MyBillsEntityDataFactory = null;
                getAuthRequestContext = null;
                return;
            }
            MyBillsEntityDataFactory = new Cancellation(false, null);
            getAuthRequestContext = new Cancellation(true, null);
        }

        Cancellation(boolean z, Throwable th) {
            this.KClassImpl$Data$declaredNonStaticMembers$2 = z;
            this.BuiltInFictitiousFunctionClassFactory = th;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public static final class SetFuture<V> implements Runnable {
        final ListenableFuture<? extends V> PlaceComponentResult;
        final AbstractFuture<V> getAuthRequestContext;

        SetFuture(AbstractFuture<V> abstractFuture, ListenableFuture<? extends V> listenableFuture) {
            this.getAuthRequestContext = abstractFuture;
            this.PlaceComponentResult = listenableFuture;
        }

        @Override // java.lang.Runnable
        public final void run() {
            if (this.getAuthRequestContext.KClassImpl$Data$declaredNonStaticMembers$2 != this) {
                return;
            }
            if (AbstractFuture.BuiltInFictitiousFunctionClassFactory.getAuthRequestContext(this.getAuthRequestContext, this, AbstractFuture.getAuthRequestContext((ListenableFuture<?>) this.PlaceComponentResult))) {
                AbstractFuture.getAuthRequestContext((AbstractFuture<?>) this.getAuthRequestContext);
            }
        }
    }

    @Override // java.util.concurrent.Future
    public final V get(long j, TimeUnit timeUnit) throws InterruptedException, TimeoutException, ExecutionException {
        long nanos = timeUnit.toNanos(j);
        if (Thread.interrupted()) {
            throw new InterruptedException();
        }
        Object obj = this.KClassImpl$Data$declaredNonStaticMembers$2;
        if ((obj != null) & (!(obj instanceof SetFuture))) {
            return (V) BuiltInFictitiousFunctionClassFactory(obj);
        }
        long nanoTime = nanos > 0 ? System.nanoTime() + nanos : 0L;
        if (nanos >= 1000) {
            Waiter waiter = this.getAuthRequestContext;
            if (waiter != Waiter.KClassImpl$Data$declaredNonStaticMembers$2) {
                Waiter waiter2 = new Waiter();
                do {
                    BuiltInFictitiousFunctionClassFactory.MyBillsEntityDataFactory(waiter2, waiter);
                    if (BuiltInFictitiousFunctionClassFactory.PlaceComponentResult(this, waiter, waiter2)) {
                        do {
                            LockSupport.parkNanos(this, nanos);
                            if (Thread.interrupted()) {
                                KClassImpl$Data$declaredNonStaticMembers$2(waiter2);
                                throw new InterruptedException();
                            }
                            Object obj2 = this.KClassImpl$Data$declaredNonStaticMembers$2;
                            if ((obj2 != null) & (!(obj2 instanceof SetFuture))) {
                                return (V) BuiltInFictitiousFunctionClassFactory(obj2);
                            }
                            nanos = nanoTime - System.nanoTime();
                        } while (nanos >= 1000);
                        KClassImpl$Data$declaredNonStaticMembers$2(waiter2);
                    } else {
                        waiter = this.getAuthRequestContext;
                    }
                } while (waiter != Waiter.KClassImpl$Data$declaredNonStaticMembers$2);
            }
            return (V) BuiltInFictitiousFunctionClassFactory(this.KClassImpl$Data$declaredNonStaticMembers$2);
        }
        while (nanos > 0) {
            Object obj3 = this.KClassImpl$Data$declaredNonStaticMembers$2;
            if ((obj3 != null) & (!(obj3 instanceof SetFuture))) {
                return (V) BuiltInFictitiousFunctionClassFactory(obj3);
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
        Object obj2 = this.KClassImpl$Data$declaredNonStaticMembers$2;
        if ((obj2 != null) & (!(obj2 instanceof SetFuture))) {
            return (V) BuiltInFictitiousFunctionClassFactory(obj2);
        }
        Waiter waiter = this.getAuthRequestContext;
        if (waiter != Waiter.KClassImpl$Data$declaredNonStaticMembers$2) {
            Waiter waiter2 = new Waiter();
            do {
                BuiltInFictitiousFunctionClassFactory.MyBillsEntityDataFactory(waiter2, waiter);
                if (BuiltInFictitiousFunctionClassFactory.PlaceComponentResult(this, waiter, waiter2)) {
                    do {
                        LockSupport.park(this);
                        if (Thread.interrupted()) {
                            KClassImpl$Data$declaredNonStaticMembers$2(waiter2);
                            throw new InterruptedException();
                        }
                        obj = this.KClassImpl$Data$declaredNonStaticMembers$2;
                    } while (!((obj != null) & (!(obj instanceof SetFuture))));
                    return (V) BuiltInFictitiousFunctionClassFactory(obj);
                }
                waiter = this.getAuthRequestContext;
            } while (waiter != Waiter.KClassImpl$Data$declaredNonStaticMembers$2);
        }
        return (V) BuiltInFictitiousFunctionClassFactory(this.KClassImpl$Data$declaredNonStaticMembers$2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static V BuiltInFictitiousFunctionClassFactory(Object obj) throws ExecutionException {
        if (obj instanceof Cancellation) {
            Throwable th = ((Cancellation) obj).BuiltInFictitiousFunctionClassFactory;
            CancellationException cancellationException = new CancellationException("Task was cancelled.");
            cancellationException.initCause(th);
            throw cancellationException;
        } else if (obj instanceof Failure) {
            throw new ExecutionException(((Failure) obj).MyBillsEntityDataFactory);
        } else {
            if (obj == NetworkUserEntityData$$ExternalSyntheticLambda0) {
                return null;
            }
            return obj;
        }
    }

    @Override // java.util.concurrent.Future
    public final boolean isDone() {
        return (!(r0 instanceof SetFuture)) & (this.KClassImpl$Data$declaredNonStaticMembers$2 != null);
    }

    @Override // java.util.concurrent.Future
    public final boolean isCancelled() {
        return this.KClassImpl$Data$declaredNonStaticMembers$2 instanceof Cancellation;
    }

    @Override // java.util.concurrent.Future
    public final boolean cancel(boolean z) {
        Cancellation cancellation;
        Object obj = this.KClassImpl$Data$declaredNonStaticMembers$2;
        if ((obj == null) || (obj instanceof SetFuture)) {
            if (PlaceComponentResult) {
                cancellation = new Cancellation(z, new CancellationException("Future.cancel() was called."));
            } else if (z) {
                cancellation = Cancellation.getAuthRequestContext;
            } else {
                cancellation = Cancellation.MyBillsEntityDataFactory;
            }
            boolean z2 = false;
            AbstractFuture<V> abstractFuture = this;
            while (true) {
                if (BuiltInFictitiousFunctionClassFactory.getAuthRequestContext(abstractFuture, obj, cancellation)) {
                    getAuthRequestContext((AbstractFuture<?>) abstractFuture);
                    if (!(obj instanceof SetFuture)) {
                        break;
                    }
                    ListenableFuture<? extends V> listenableFuture = ((SetFuture) obj).PlaceComponentResult;
                    if (listenableFuture instanceof AbstractFuture) {
                        abstractFuture = (AbstractFuture) listenableFuture;
                        obj = abstractFuture.KClassImpl$Data$declaredNonStaticMembers$2;
                        if (!(obj == null) && !(obj instanceof SetFuture)) {
                            break;
                        }
                        z2 = true;
                    } else {
                        listenableFuture.cancel(z);
                        break;
                    }
                } else {
                    obj = abstractFuture.KClassImpl$Data$declaredNonStaticMembers$2;
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
        Listener listener = this.MyBillsEntityDataFactory;
        if (listener != Listener.KClassImpl$Data$declaredNonStaticMembers$2) {
            Listener listener2 = new Listener(runnable, executor);
            do {
                listener2.PlaceComponentResult = listener;
                if (BuiltInFictitiousFunctionClassFactory.KClassImpl$Data$declaredNonStaticMembers$2(this, listener, listener2)) {
                    return;
                }
                listener = this.MyBillsEntityDataFactory;
            } while (listener != Listener.KClassImpl$Data$declaredNonStaticMembers$2);
        }
        BuiltInFictitiousFunctionClassFactory(runnable, executor);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean getAuthRequestContext(V v) {
        if (v == null) {
            v = (V) NetworkUserEntityData$$ExternalSyntheticLambda0;
        }
        if (BuiltInFictitiousFunctionClassFactory.getAuthRequestContext(this, null, v)) {
            getAuthRequestContext((AbstractFuture<?>) this);
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean BuiltInFictitiousFunctionClassFactory(Throwable th) {
        if (BuiltInFictitiousFunctionClassFactory.getAuthRequestContext(this, null, new Failure(th))) {
            getAuthRequestContext((AbstractFuture<?>) this);
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean PlaceComponentResult(ListenableFuture<? extends V> listenableFuture) {
        Failure failure;
        Object obj = this.KClassImpl$Data$declaredNonStaticMembers$2;
        if (obj == null) {
            if (listenableFuture.isDone()) {
                if (BuiltInFictitiousFunctionClassFactory.getAuthRequestContext(this, null, getAuthRequestContext((ListenableFuture<?>) listenableFuture))) {
                    getAuthRequestContext((AbstractFuture<?>) this);
                    return true;
                }
                return false;
            }
            SetFuture setFuture = new SetFuture(this, listenableFuture);
            if (BuiltInFictitiousFunctionClassFactory.getAuthRequestContext(this, null, setFuture)) {
                try {
                    listenableFuture.addListener(setFuture, DirectExecutor.INSTANCE);
                } catch (Throwable th) {
                    try {
                        failure = new Failure(th);
                    } catch (Throwable unused) {
                        failure = Failure.KClassImpl$Data$declaredNonStaticMembers$2;
                    }
                    BuiltInFictitiousFunctionClassFactory.getAuthRequestContext(this, setFuture, failure);
                }
                return true;
            }
            obj = this.KClassImpl$Data$declaredNonStaticMembers$2;
        }
        if (obj instanceof Cancellation) {
            listenableFuture.cancel(((Cancellation) obj).KClassImpl$Data$declaredNonStaticMembers$2);
        }
        return false;
    }

    static Object getAuthRequestContext(ListenableFuture<?> listenableFuture) {
        if (listenableFuture instanceof AbstractFuture) {
            Object obj = ((AbstractFuture) listenableFuture).KClassImpl$Data$declaredNonStaticMembers$2;
            if (obj instanceof Cancellation) {
                Cancellation cancellation = (Cancellation) obj;
                return cancellation.KClassImpl$Data$declaredNonStaticMembers$2 ? cancellation.BuiltInFictitiousFunctionClassFactory != null ? new Cancellation(false, cancellation.BuiltInFictitiousFunctionClassFactory) : Cancellation.MyBillsEntityDataFactory : obj;
            }
            return obj;
        }
        boolean isCancelled = listenableFuture.isCancelled();
        if ((!PlaceComponentResult) & isCancelled) {
            return Cancellation.MyBillsEntityDataFactory;
        }
        try {
            Object MyBillsEntityDataFactory = MyBillsEntityDataFactory((Future<Object>) listenableFuture);
            return MyBillsEntityDataFactory == null ? NetworkUserEntityData$$ExternalSyntheticLambda0 : MyBillsEntityDataFactory;
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
                        byte b = (byte) (moveToNextValue[15] - 1);
                        byte b2 = b;
                        Object[] objArr = new Object[1];
                        a(b, b2, b2, objArr);
                        Class<?> cls = Class.forName((String) objArr[0]);
                        byte b3 = moveToNextValue[15];
                        byte b4 = b3;
                        Object[] objArr2 = new Object[1];
                        a(b3, b4, b4, objArr2);
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
                byte b5 = (byte) (moveToNextValue[15] - 1);
                byte b6 = b5;
                Object[] objArr3 = new Object[1];
                a(b5, b6, b6, objArr3);
                Class<?> cls2 = Class.forName((String) objArr3[0]);
                byte b7 = moveToNextValue[15];
                byte b8 = b7;
                Object[] objArr4 = new Object[1];
                a(b7, b8, b8, objArr4);
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
            BuiltInFictitiousFunctionClassFactory(sb);
        } else {
            try {
                Object obj2 = this.KClassImpl$Data$declaredNonStaticMembers$2;
                if (obj2 instanceof SetFuture) {
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("setFuture=[");
                    ListenableFuture<? extends V> listenableFuture = ((SetFuture) obj2).PlaceComponentResult;
                    sb2.append(listenableFuture == this ? "this future" : String.valueOf(listenableFuture));
                    sb2.append("]");
                    obj = sb2.toString();
                } else if (this instanceof ScheduledFuture) {
                    StringBuilder sb3 = new StringBuilder();
                    sb3.append("remaining delay=[");
                    sb3.append(((ScheduledFuture) this).getDelay(TimeUnit.MILLISECONDS));
                    sb3.append(" ms]");
                    obj = sb3.toString();
                } else {
                    obj = null;
                }
            } catch (RuntimeException e) {
                StringBuilder sb4 = new StringBuilder();
                sb4.append("Exception thrown from implementation: ");
                sb4.append(e.getClass());
                obj = sb4.toString();
            }
            if (obj != null && !obj.isEmpty()) {
                sb.append("PENDING, info=[");
                sb.append(obj);
                sb.append("]");
            } else if (isDone()) {
                BuiltInFictitiousFunctionClassFactory(sb);
            } else {
                sb.append("PENDING");
            }
        }
        sb.append("]");
        return sb.toString();
    }

    private void BuiltInFictitiousFunctionClassFactory(StringBuilder sb) {
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

    private static void BuiltInFictitiousFunctionClassFactory(Runnable runnable, Executor executor) {
        try {
            executor.execute(runnable);
        } catch (RuntimeException e) {
            Logger logger = lookAheadTest;
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
    /* loaded from: classes3.dex */
    public static abstract class AtomicHelper {
        abstract boolean KClassImpl$Data$declaredNonStaticMembers$2(AbstractFuture<?> abstractFuture, Listener listener, Listener listener2);

        abstract void MyBillsEntityDataFactory(Waiter waiter, Waiter waiter2);

        abstract boolean PlaceComponentResult(AbstractFuture<?> abstractFuture, Waiter waiter, Waiter waiter2);

        abstract void getAuthRequestContext(Waiter waiter, Thread thread);

        abstract boolean getAuthRequestContext(AbstractFuture<?> abstractFuture, Object obj, Object obj2);

        private AtomicHelper() {
        }

        /* synthetic */ AtomicHelper(byte b) {
            this();
        }
    }

    /* loaded from: classes3.dex */
    static final class SafeAtomicHelper extends AtomicHelper {
        final AtomicReferenceFieldUpdater<Waiter, Waiter> BuiltInFictitiousFunctionClassFactory;
        final AtomicReferenceFieldUpdater<Waiter, Thread> KClassImpl$Data$declaredNonStaticMembers$2;
        final AtomicReferenceFieldUpdater<AbstractFuture, Listener> MyBillsEntityDataFactory;
        final AtomicReferenceFieldUpdater<AbstractFuture, Object> PlaceComponentResult;
        final AtomicReferenceFieldUpdater<AbstractFuture, Waiter> getAuthRequestContext;

        SafeAtomicHelper(AtomicReferenceFieldUpdater<Waiter, Thread> atomicReferenceFieldUpdater, AtomicReferenceFieldUpdater<Waiter, Waiter> atomicReferenceFieldUpdater2, AtomicReferenceFieldUpdater<AbstractFuture, Waiter> atomicReferenceFieldUpdater3, AtomicReferenceFieldUpdater<AbstractFuture, Listener> atomicReferenceFieldUpdater4, AtomicReferenceFieldUpdater<AbstractFuture, Object> atomicReferenceFieldUpdater5) {
            super((byte) 0);
            this.KClassImpl$Data$declaredNonStaticMembers$2 = atomicReferenceFieldUpdater;
            this.BuiltInFictitiousFunctionClassFactory = atomicReferenceFieldUpdater2;
            this.getAuthRequestContext = atomicReferenceFieldUpdater3;
            this.MyBillsEntityDataFactory = atomicReferenceFieldUpdater4;
            this.PlaceComponentResult = atomicReferenceFieldUpdater5;
        }

        @Override // androidx.work.impl.utils.futures.AbstractFuture.AtomicHelper
        final void getAuthRequestContext(Waiter waiter, Thread thread) {
            this.KClassImpl$Data$declaredNonStaticMembers$2.lazySet(waiter, thread);
        }

        @Override // androidx.work.impl.utils.futures.AbstractFuture.AtomicHelper
        final void MyBillsEntityDataFactory(Waiter waiter, Waiter waiter2) {
            this.BuiltInFictitiousFunctionClassFactory.lazySet(waiter, waiter2);
        }

        @Override // androidx.work.impl.utils.futures.AbstractFuture.AtomicHelper
        final boolean PlaceComponentResult(AbstractFuture<?> abstractFuture, Waiter waiter, Waiter waiter2) {
            return AbstractResolvableFuture$SafeAtomicHelper$$ExternalSyntheticBackportWithForwarding0.MyBillsEntityDataFactory(this.getAuthRequestContext, abstractFuture, waiter, waiter2);
        }

        @Override // androidx.work.impl.utils.futures.AbstractFuture.AtomicHelper
        final boolean KClassImpl$Data$declaredNonStaticMembers$2(AbstractFuture<?> abstractFuture, Listener listener, Listener listener2) {
            return AbstractResolvableFuture$SafeAtomicHelper$$ExternalSyntheticBackportWithForwarding0.MyBillsEntityDataFactory(this.MyBillsEntityDataFactory, abstractFuture, listener, listener2);
        }

        @Override // androidx.work.impl.utils.futures.AbstractFuture.AtomicHelper
        final boolean getAuthRequestContext(AbstractFuture<?> abstractFuture, Object obj, Object obj2) {
            return AbstractResolvableFuture$SafeAtomicHelper$$ExternalSyntheticBackportWithForwarding0.MyBillsEntityDataFactory(this.PlaceComponentResult, abstractFuture, obj, obj2);
        }
    }

    /* loaded from: classes3.dex */
    static final class SynchronizedHelper extends AtomicHelper {
        SynchronizedHelper() {
            super((byte) 0);
        }

        @Override // androidx.work.impl.utils.futures.AbstractFuture.AtomicHelper
        final void getAuthRequestContext(Waiter waiter, Thread thread) {
            waiter.getAuthRequestContext = thread;
        }

        @Override // androidx.work.impl.utils.futures.AbstractFuture.AtomicHelper
        final void MyBillsEntityDataFactory(Waiter waiter, Waiter waiter2) {
            waiter.PlaceComponentResult = waiter2;
        }

        @Override // androidx.work.impl.utils.futures.AbstractFuture.AtomicHelper
        final boolean PlaceComponentResult(AbstractFuture<?> abstractFuture, Waiter waiter, Waiter waiter2) {
            synchronized (abstractFuture) {
                if (abstractFuture.getAuthRequestContext == waiter) {
                    abstractFuture.getAuthRequestContext = waiter2;
                    return true;
                }
                return false;
            }
        }

        @Override // androidx.work.impl.utils.futures.AbstractFuture.AtomicHelper
        final boolean KClassImpl$Data$declaredNonStaticMembers$2(AbstractFuture<?> abstractFuture, Listener listener, Listener listener2) {
            synchronized (abstractFuture) {
                if (abstractFuture.MyBillsEntityDataFactory == listener) {
                    abstractFuture.MyBillsEntityDataFactory = listener2;
                    return true;
                }
                return false;
            }
        }

        @Override // androidx.work.impl.utils.futures.AbstractFuture.AtomicHelper
        final boolean getAuthRequestContext(AbstractFuture<?> abstractFuture, Object obj, Object obj2) {
            synchronized (abstractFuture) {
                if (abstractFuture.KClassImpl$Data$declaredNonStaticMembers$2 == obj) {
                    abstractFuture.KClassImpl$Data$declaredNonStaticMembers$2 = obj2;
                    return true;
                }
                return false;
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v2, types: [androidx.work.impl.utils.futures.AbstractFuture$AtomicHelper] */
    /* JADX WARN: Type inference failed for: r5v0, types: [androidx.work.impl.utils.futures.AbstractFuture<?>] */
    /* JADX WARN: Type inference failed for: r5v1, types: [androidx.work.impl.utils.futures.AbstractFuture] */
    /* JADX WARN: Type inference failed for: r5v2 */
    /* JADX WARN: Type inference failed for: r5v7, types: [androidx.work.impl.utils.futures.AbstractFuture, androidx.work.impl.utils.futures.AbstractFuture<V>] */
    static void getAuthRequestContext(AbstractFuture<?> abstractFuture) {
        Listener listener;
        Listener listener2;
        Listener listener3 = null;
        while (true) {
            Waiter waiter = ((AbstractFuture) abstractFuture).getAuthRequestContext;
            if (BuiltInFictitiousFunctionClassFactory.PlaceComponentResult((AbstractFuture) abstractFuture, waiter, Waiter.KClassImpl$Data$declaredNonStaticMembers$2)) {
                while (waiter != null) {
                    Thread thread = waiter.getAuthRequestContext;
                    if (thread != null) {
                        waiter.getAuthRequestContext = null;
                        LockSupport.unpark(thread);
                    }
                    waiter = waiter.PlaceComponentResult;
                }
                do {
                    listener = ((AbstractFuture) abstractFuture).MyBillsEntityDataFactory;
                } while (!BuiltInFictitiousFunctionClassFactory.KClassImpl$Data$declaredNonStaticMembers$2((AbstractFuture) abstractFuture, listener, Listener.KClassImpl$Data$declaredNonStaticMembers$2));
                while (true) {
                    listener2 = listener3;
                    listener3 = listener;
                    if (listener3 == null) {
                        break;
                    }
                    listener = listener3.PlaceComponentResult;
                    listener3.PlaceComponentResult = listener2;
                }
                while (listener2 != null) {
                    listener3 = listener2.PlaceComponentResult;
                    Runnable runnable = listener2.BuiltInFictitiousFunctionClassFactory;
                    if (runnable instanceof SetFuture) {
                        SetFuture setFuture = (SetFuture) runnable;
                        abstractFuture = setFuture.getAuthRequestContext;
                        if (abstractFuture.KClassImpl$Data$declaredNonStaticMembers$2 == setFuture) {
                            if (BuiltInFictitiousFunctionClassFactory.getAuthRequestContext(abstractFuture, setFuture, getAuthRequestContext((ListenableFuture<?>) setFuture.PlaceComponentResult))) {
                                break;
                            }
                        } else {
                            continue;
                        }
                    } else {
                        BuiltInFictitiousFunctionClassFactory(runnable, listener2.MyBillsEntityDataFactory);
                    }
                    listener2 = listener3;
                }
                return;
            }
        }
    }
}
