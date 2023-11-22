package io.reactivex.observers;

import androidx.view.LifecycleKt$$ExternalSyntheticBackportWithForwarding0;
import com.alibaba.ariver.resource.parser.tar.TarHeader;
import com.google.common.base.Ascii;
import io.reactivex.CompletableObserver;
import io.reactivex.MaybeObserver;
import io.reactivex.Observer;
import io.reactivex.SingleObserver;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.fuseable.QueueDisposable;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes2.dex */
public class TestObserver<T> extends BaseTestConsumer<T, TestObserver<T>> implements Observer<T>, Disposable, MaybeObserver<T>, SingleObserver<T>, CompletableObserver {
    public static final byte[] NetworkUserEntityData$$ExternalSyntheticLambda0 = {Ascii.DC4, -68, -64, 70, -16, 5, 2, 15, -7, -4, 34, -18, -8, 15, 6, -1, 11, -19, Ascii.ETB, TarHeader.LF_DIR, -60, 13, -11, 9, 59, -36, -18, -8, 15, 6, -1};
    public static final int lookAheadTest = 255;
    private final Observer<? super T> GetContactSyncConfig;
    private QueueDisposable<T> NetworkUserEntityData$$ExternalSyntheticLambda1;
    private final AtomicReference<Disposable> NetworkUserEntityData$$ExternalSyntheticLambda2;

    /* loaded from: classes9.dex */
    enum EmptyObserver implements Observer<Object> {
        INSTANCE;

        @Override // io.reactivex.Observer
        public final void onComplete() {
        }

        @Override // io.reactivex.Observer
        public final void onError(Throwable th) {
        }

        @Override // io.reactivex.Observer
        public final void onNext(Object obj) {
        }

        @Override // io.reactivex.Observer
        public final void onSubscribe(Disposable disposable) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x002b  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0023  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x002b -> B:11:0x0033). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void a(byte r6, short r7, int r8, java.lang.Object[] r9) {
        /*
            int r6 = r6 * 3
            int r6 = 16 - r6
            byte[] r0 = io.reactivex.observers.TestObserver.NetworkUserEntityData$$ExternalSyntheticLambda0
            int r7 = r7 * 7
            int r7 = r7 + 99
            int r8 = r8 * 12
            int r8 = 16 - r8
            byte[] r1 = new byte[r6]
            int r6 = r6 + (-1)
            r2 = 0
            if (r0 != 0) goto L1b
            r3 = r1
            r4 = 0
            r1 = r0
            r0 = r9
            r9 = r8
            goto L33
        L1b:
            r3 = 0
        L1c:
            byte r4 = (byte) r7
            r1[r3] = r4
            int r4 = r3 + 1
            if (r3 != r6) goto L2b
            java.lang.String r6 = new java.lang.String
            r6.<init>(r1, r2)
            r9[r2] = r6
            return
        L2b:
            r3 = r0[r8]
            r5 = r9
            r9 = r8
            r8 = r3
            r3 = r1
            r1 = r0
            r0 = r5
        L33:
            int r8 = -r8
            int r7 = r7 + r8
            int r7 = r7 + 2
            int r8 = r9 + 1
            r9 = r0
            r0 = r1
            r1 = r3
            r3 = r4
            goto L1c
        */
        throw new UnsupportedOperationException("Method not decompiled: io.reactivex.observers.TestObserver.a(byte, short, int, java.lang.Object[]):void");
    }

    public TestObserver() {
        this(EmptyObserver.INSTANCE);
    }

    private TestObserver(Observer<? super T> observer) {
        this.NetworkUserEntityData$$ExternalSyntheticLambda2 = new AtomicReference<>();
        this.GetContactSyncConfig = observer;
    }

    @Override // io.reactivex.Observer
    public void onSubscribe(Disposable disposable) {
        try {
            byte b = (byte) (NetworkUserEntityData$$ExternalSyntheticLambda0[15] + 1);
            byte b2 = (byte) (-NetworkUserEntityData$$ExternalSyntheticLambda0[15]);
            Object[] objArr = new Object[1];
            a(b, b2, (byte) (b2 - 1), objArr);
            Class<?> cls = Class.forName((String) objArr[0]);
            byte b3 = (byte) (-NetworkUserEntityData$$ExternalSyntheticLambda0[15]);
            Object[] objArr2 = new Object[1];
            a(b3, (byte) (b3 - 1), (byte) (-NetworkUserEntityData$$ExternalSyntheticLambda0[15]), objArr2);
            this.getErrorConfigVersion = (Thread) cls.getMethod((String) objArr2[0], null).invoke(null, null);
            if (disposable == null) {
                this.getAuthRequestContext.add(new NullPointerException("onSubscribe received a null Subscription"));
            } else if (!LifecycleKt$$ExternalSyntheticBackportWithForwarding0.KClassImpl$Data$declaredNonStaticMembers$2(this.NetworkUserEntityData$$ExternalSyntheticLambda2, null, disposable)) {
                disposable.dispose();
                if (this.NetworkUserEntityData$$ExternalSyntheticLambda2.get() != DisposableHelper.DISPOSED) {
                    List<Throwable> list = this.getAuthRequestContext;
                    StringBuilder sb = new StringBuilder();
                    sb.append("onSubscribe received multiple subscriptions: ");
                    sb.append(disposable);
                    list.add(new IllegalStateException(sb.toString()));
                }
            } else {
                if (this.scheduleImpl != 0 && (disposable instanceof QueueDisposable)) {
                    QueueDisposable<T> queueDisposable = (QueueDisposable) disposable;
                    this.NetworkUserEntityData$$ExternalSyntheticLambda1 = queueDisposable;
                    int requestFusion = queueDisposable.requestFusion(this.scheduleImpl);
                    this.KClassImpl$Data$declaredNonStaticMembers$2 = requestFusion;
                    if (requestFusion == 1) {
                        this.BuiltInFictitiousFunctionClassFactory = true;
                        try {
                            byte b4 = (byte) (NetworkUserEntityData$$ExternalSyntheticLambda0[15] + 1);
                            byte b5 = (byte) (-NetworkUserEntityData$$ExternalSyntheticLambda0[15]);
                            Object[] objArr3 = new Object[1];
                            a(b4, b5, (byte) (b5 - 1), objArr3);
                            Class<?> cls2 = Class.forName((String) objArr3[0]);
                            byte b6 = (byte) (-NetworkUserEntityData$$ExternalSyntheticLambda0[15]);
                            Object[] objArr4 = new Object[1];
                            a(b6, (byte) (b6 - 1), (byte) (-NetworkUserEntityData$$ExternalSyntheticLambda0[15]), objArr4);
                            this.getErrorConfigVersion = (Thread) cls2.getMethod((String) objArr4[0], null).invoke(null, null);
                            while (true) {
                                try {
                                    T poll = this.NetworkUserEntityData$$ExternalSyntheticLambda1.poll();
                                    if (poll != null) {
                                        this.moveToNextValue.add(poll);
                                    } else {
                                        this.PlaceComponentResult++;
                                        this.NetworkUserEntityData$$ExternalSyntheticLambda2.lazySet(DisposableHelper.DISPOSED);
                                        return;
                                    }
                                } catch (Throwable th) {
                                    this.getAuthRequestContext.add(th);
                                    return;
                                }
                            }
                        } catch (Throwable th2) {
                            Throwable cause = th2.getCause();
                            if (cause == null) {
                                throw th2;
                            }
                            throw cause;
                        }
                    }
                }
                this.GetContactSyncConfig.onSubscribe(disposable);
            }
        } catch (Throwable th3) {
            Throwable cause2 = th3.getCause();
            if (cause2 == null) {
                throw th3;
            }
            throw cause2;
        }
    }

    @Override // io.reactivex.Observer
    public void onNext(T t) {
        if (!this.BuiltInFictitiousFunctionClassFactory) {
            this.BuiltInFictitiousFunctionClassFactory = true;
            if (this.NetworkUserEntityData$$ExternalSyntheticLambda2.get() == null) {
                this.getAuthRequestContext.add(new IllegalStateException("onSubscribe not called in proper order"));
            }
        }
        try {
            byte b = (byte) (NetworkUserEntityData$$ExternalSyntheticLambda0[15] + 1);
            byte b2 = (byte) (-NetworkUserEntityData$$ExternalSyntheticLambda0[15]);
            Object[] objArr = new Object[1];
            a(b, b2, (byte) (b2 - 1), objArr);
            Class<?> cls = Class.forName((String) objArr[0]);
            byte b3 = (byte) (-NetworkUserEntityData$$ExternalSyntheticLambda0[15]);
            Object[] objArr2 = new Object[1];
            a(b3, (byte) (b3 - 1), (byte) (-NetworkUserEntityData$$ExternalSyntheticLambda0[15]), objArr2);
            this.getErrorConfigVersion = (Thread) cls.getMethod((String) objArr2[0], null).invoke(null, null);
            if (this.KClassImpl$Data$declaredNonStaticMembers$2 != 2) {
                this.moveToNextValue.add(t);
                if (t == null) {
                    this.getAuthRequestContext.add(new NullPointerException("onNext received a null value"));
                }
                this.GetContactSyncConfig.onNext(t);
                return;
            }
            while (true) {
                try {
                    T poll = this.NetworkUserEntityData$$ExternalSyntheticLambda1.poll();
                    if (poll == null) {
                        return;
                    }
                    this.moveToNextValue.add(poll);
                } catch (Throwable th) {
                    this.getAuthRequestContext.add(th);
                    this.NetworkUserEntityData$$ExternalSyntheticLambda1.dispose();
                    return;
                }
            }
        } catch (Throwable th2) {
            Throwable cause = th2.getCause();
            if (cause == null) {
                throw th2;
            }
            throw cause;
        }
    }

    @Override // io.reactivex.Observer
    public void onError(Throwable th) {
        if (!this.BuiltInFictitiousFunctionClassFactory) {
            this.BuiltInFictitiousFunctionClassFactory = true;
            if (this.NetworkUserEntityData$$ExternalSyntheticLambda2.get() == null) {
                this.getAuthRequestContext.add(new IllegalStateException("onSubscribe not called in proper order"));
            }
        }
        try {
            try {
                byte b = (byte) (NetworkUserEntityData$$ExternalSyntheticLambda0[15] + 1);
                byte b2 = (byte) (-NetworkUserEntityData$$ExternalSyntheticLambda0[15]);
                Object[] objArr = new Object[1];
                a(b, b2, (byte) (b2 - 1), objArr);
                Class<?> cls = Class.forName((String) objArr[0]);
                byte b3 = (byte) (-NetworkUserEntityData$$ExternalSyntheticLambda0[15]);
                Object[] objArr2 = new Object[1];
                a(b3, (byte) (b3 - 1), (byte) (-NetworkUserEntityData$$ExternalSyntheticLambda0[15]), objArr2);
                this.getErrorConfigVersion = (Thread) cls.getMethod((String) objArr2[0], null).invoke(null, null);
                if (th == null) {
                    this.getAuthRequestContext.add(new NullPointerException("onError received a null Throwable"));
                } else {
                    this.getAuthRequestContext.add(th);
                }
                this.GetContactSyncConfig.onError(th);
            } catch (Throwable th2) {
                Throwable cause = th2.getCause();
                if (cause == null) {
                    throw th2;
                }
                throw cause;
            }
        } finally {
            this.MyBillsEntityDataFactory.countDown();
        }
    }

    @Override // io.reactivex.Observer
    public void onComplete() {
        if (!this.BuiltInFictitiousFunctionClassFactory) {
            this.BuiltInFictitiousFunctionClassFactory = true;
            if (this.NetworkUserEntityData$$ExternalSyntheticLambda2.get() == null) {
                this.getAuthRequestContext.add(new IllegalStateException("onSubscribe not called in proper order"));
            }
        }
        try {
            try {
                byte b = (byte) (NetworkUserEntityData$$ExternalSyntheticLambda0[15] + 1);
                byte b2 = (byte) (-NetworkUserEntityData$$ExternalSyntheticLambda0[15]);
                Object[] objArr = new Object[1];
                a(b, b2, (byte) (b2 - 1), objArr);
                Class<?> cls = Class.forName((String) objArr[0]);
                byte b3 = (byte) (-NetworkUserEntityData$$ExternalSyntheticLambda0[15]);
                Object[] objArr2 = new Object[1];
                a(b3, (byte) (b3 - 1), (byte) (-NetworkUserEntityData$$ExternalSyntheticLambda0[15]), objArr2);
                this.getErrorConfigVersion = (Thread) cls.getMethod((String) objArr2[0], null).invoke(null, null);
                this.PlaceComponentResult++;
                this.GetContactSyncConfig.onComplete();
            } catch (Throwable th) {
                Throwable cause = th.getCause();
                if (cause == null) {
                    throw th;
                }
                throw cause;
            }
        } finally {
            this.MyBillsEntityDataFactory.countDown();
        }
    }

    @Override // io.reactivex.disposables.Disposable
    public final void dispose() {
        DisposableHelper.dispose(this.NetworkUserEntityData$$ExternalSyntheticLambda2);
    }

    @Override // io.reactivex.disposables.Disposable
    public final boolean isDisposed() {
        return DisposableHelper.isDisposed(this.NetworkUserEntityData$$ExternalSyntheticLambda2.get());
    }

    @Override // io.reactivex.MaybeObserver
    public void onSuccess(T t) {
        onNext(t);
        onComplete();
    }
}
