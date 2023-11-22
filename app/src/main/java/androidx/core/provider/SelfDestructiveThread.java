package androidx.core.provider;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

@Deprecated
/* loaded from: classes6.dex */
public class SelfDestructiveThread {
    Handler BuiltInFictitiousFunctionClassFactory;
    final int KClassImpl$Data$declaredNonStaticMembers$2;
    HandlerThread MyBillsEntityDataFactory;
    final Object getAuthRequestContext;

    /* loaded from: classes6.dex */
    public interface ReplyCallback<T> {
    }

    /* renamed from: androidx.core.provider.SelfDestructiveThread$1  reason: invalid class name */
    /* loaded from: classes6.dex */
    class AnonymousClass1 implements Handler.Callback {
        final /* synthetic */ SelfDestructiveThread KClassImpl$Data$declaredNonStaticMembers$2;

        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            int i = message.what;
            if (i == 0) {
                SelfDestructiveThread selfDestructiveThread = this.KClassImpl$Data$declaredNonStaticMembers$2;
                synchronized (selfDestructiveThread.getAuthRequestContext) {
                    if (!selfDestructiveThread.BuiltInFictitiousFunctionClassFactory.hasMessages(1)) {
                        selfDestructiveThread.MyBillsEntityDataFactory.quit();
                        selfDestructiveThread.MyBillsEntityDataFactory = null;
                        selfDestructiveThread.BuiltInFictitiousFunctionClassFactory = null;
                    }
                }
                return true;
            } else if (i != 1) {
                return true;
            } else {
                SelfDestructiveThread selfDestructiveThread2 = this.KClassImpl$Data$declaredNonStaticMembers$2;
                ((Runnable) message.obj).run();
                synchronized (selfDestructiveThread2.getAuthRequestContext) {
                    selfDestructiveThread2.BuiltInFictitiousFunctionClassFactory.removeMessages(0);
                    Handler handler = selfDestructiveThread2.BuiltInFictitiousFunctionClassFactory;
                    handler.sendMessageDelayed(handler.obtainMessage(0), selfDestructiveThread2.KClassImpl$Data$declaredNonStaticMembers$2);
                }
                return true;
            }
        }
    }

    /* renamed from: androidx.core.provider.SelfDestructiveThread$2  reason: invalid class name */
    /* loaded from: classes6.dex */
    class AnonymousClass2 implements Runnable {
        final /* synthetic */ ReplyCallback BuiltInFictitiousFunctionClassFactory;
        final /* synthetic */ Callable KClassImpl$Data$declaredNonStaticMembers$2;
        final /* synthetic */ Handler PlaceComponentResult;

        @Override // java.lang.Runnable
        public void run() {
            final Object obj;
            try {
                obj = this.KClassImpl$Data$declaredNonStaticMembers$2.call();
            } catch (Exception unused) {
                obj = null;
            }
            this.PlaceComponentResult.post(new Runnable() { // from class: androidx.core.provider.SelfDestructiveThread.2.1
                @Override // java.lang.Runnable
                public void run() {
                    ReplyCallback replyCallback = AnonymousClass2.this.BuiltInFictitiousFunctionClassFactory;
                }
            });
        }
    }

    /* renamed from: androidx.core.provider.SelfDestructiveThread$3  reason: invalid class name */
    /* loaded from: classes6.dex */
    class AnonymousClass3 implements Runnable {
        final /* synthetic */ AtomicBoolean BuiltInFictitiousFunctionClassFactory;
        final /* synthetic */ Condition KClassImpl$Data$declaredNonStaticMembers$2;
        final /* synthetic */ Callable MyBillsEntityDataFactory;
        final /* synthetic */ ReentrantLock PlaceComponentResult;
        final /* synthetic */ AtomicReference getAuthRequestContext;

        @Override // java.lang.Runnable
        public void run() {
            try {
                this.getAuthRequestContext.set(this.MyBillsEntityDataFactory.call());
            } catch (Exception unused) {
            }
            this.PlaceComponentResult.lock();
            try {
                this.BuiltInFictitiousFunctionClassFactory.set(false);
                this.KClassImpl$Data$declaredNonStaticMembers$2.signal();
            } finally {
                this.PlaceComponentResult.unlock();
            }
        }
    }
}
