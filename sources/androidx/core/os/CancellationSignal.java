package androidx.core.os;

import android.os.Build;

/* loaded from: classes.dex */
public final class CancellationSignal {
    private boolean KClassImpl$Data$declaredNonStaticMembers$2;
    private boolean MyBillsEntityDataFactory;
    private Object PlaceComponentResult;
    private OnCancelListener getAuthRequestContext;

    /* loaded from: classes.dex */
    public interface OnCancelListener {
        void MyBillsEntityDataFactory();
    }

    public final boolean MyBillsEntityDataFactory() {
        boolean z;
        synchronized (this) {
            z = this.MyBillsEntityDataFactory;
        }
        return z;
    }

    public final void PlaceComponentResult() {
        synchronized (this) {
            if (this.MyBillsEntityDataFactory) {
                return;
            }
            this.MyBillsEntityDataFactory = true;
            this.KClassImpl$Data$declaredNonStaticMembers$2 = true;
            OnCancelListener onCancelListener = this.getAuthRequestContext;
            Object obj = this.PlaceComponentResult;
            if (onCancelListener != null) {
                try {
                    onCancelListener.MyBillsEntityDataFactory();
                } catch (Throwable th) {
                    synchronized (this) {
                        this.KClassImpl$Data$declaredNonStaticMembers$2 = false;
                        notifyAll();
                        throw th;
                    }
                }
            }
            if (obj != null && Build.VERSION.SDK_INT >= 16) {
                Api16Impl.BuiltInFictitiousFunctionClassFactory(obj);
            }
            synchronized (this) {
                this.KClassImpl$Data$declaredNonStaticMembers$2 = false;
                notifyAll();
            }
        }
    }

    public final void MyBillsEntityDataFactory(OnCancelListener onCancelListener) {
        synchronized (this) {
            while (this.KClassImpl$Data$declaredNonStaticMembers$2) {
                try {
                    wait();
                } catch (InterruptedException unused) {
                }
            }
            if (this.getAuthRequestContext == onCancelListener) {
                return;
            }
            this.getAuthRequestContext = onCancelListener;
            if (this.MyBillsEntityDataFactory) {
                onCancelListener.MyBillsEntityDataFactory();
            }
        }
    }

    public final Object KClassImpl$Data$declaredNonStaticMembers$2() {
        Object obj;
        if (Build.VERSION.SDK_INT < 16) {
            return null;
        }
        synchronized (this) {
            if (this.PlaceComponentResult == null) {
                android.os.CancellationSignal MyBillsEntityDataFactory = Api16Impl.MyBillsEntityDataFactory();
                this.PlaceComponentResult = MyBillsEntityDataFactory;
                if (this.MyBillsEntityDataFactory) {
                    Api16Impl.BuiltInFictitiousFunctionClassFactory(MyBillsEntityDataFactory);
                }
            }
            obj = this.PlaceComponentResult;
        }
        return obj;
    }

    /* loaded from: classes.dex */
    static class Api16Impl {
        private Api16Impl() {
        }

        static void BuiltInFictitiousFunctionClassFactory(Object obj) {
            ((android.os.CancellationSignal) obj).cancel();
        }

        static android.os.CancellationSignal MyBillsEntityDataFactory() {
            return new android.os.CancellationSignal();
        }
    }
}
