package zipkin2.internal;

import androidx.view.LifecycleKt$$ExternalSyntheticBackportWithForwarding0;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import java.util.logging.Level;
import java.util.logging.Logger;
import zipkin2.Call;
import zipkin2.Callback;

/* loaded from: classes9.dex */
public abstract class AggregateCall<I, O> extends Call.Base<O> {
    final Logger MyBillsEntityDataFactory = Logger.getLogger(getClass().getName());
    final List<Call<I>> getAuthRequestContext;

    protected static O KClassImpl$Data$declaredNonStaticMembers$2(O o2) {
        return o2;
    }

    protected abstract void getAuthRequestContext(I i, O o2);

    protected abstract O scheduleImpl();

    /* loaded from: classes9.dex */
    static final class AggregateVoidCall extends AggregateCall<Void, Void> {
        volatile boolean BuiltInFictitiousFunctionClassFactory;

        @Override // zipkin2.internal.AggregateCall
        protected final /* bridge */ /* synthetic */ Void scheduleImpl() {
            return null;
        }

        @Override // zipkin2.internal.AggregateCall
        protected final /* bridge */ /* synthetic */ void getAuthRequestContext(Void r1, Void r2) {
            this.BuiltInFictitiousFunctionClassFactory = false;
        }

        private AggregateVoidCall(List<Call<Void>> list) {
            super(list);
            this.BuiltInFictitiousFunctionClassFactory = true;
        }

        @Override // zipkin2.Call.Base, zipkin2.Call
        public final /* synthetic */ Object clone() throws CloneNotSupportedException {
            return new AggregateVoidCall(BuiltInFictitiousFunctionClassFactory());
        }

        @Override // zipkin2.Call
        /* renamed from: MyBillsEntityDataFactory */
        public final /* synthetic */ Call clone() {
            return new AggregateVoidCall(BuiltInFictitiousFunctionClassFactory());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public AggregateCall(List<Call<I>> list) {
        this.getAuthRequestContext = list;
    }

    @Override // zipkin2.Call.Base
    public final O KClassImpl$Data$declaredNonStaticMembers$2() throws IOException {
        int size = this.getAuthRequestContext.size();
        O scheduleImpl = scheduleImpl();
        RuntimeException runtimeException = null;
        for (int i = 0; i < size; i++) {
            Call<I> call = this.getAuthRequestContext.get(i);
            try {
                getAuthRequestContext(call.PlaceComponentResult(), scheduleImpl);
            } catch (Throwable th) {
                if (runtimeException == null) {
                    runtimeException = th;
                } else if (this.MyBillsEntityDataFactory.isLoggable(Level.INFO)) {
                    Logger logger = this.MyBillsEntityDataFactory;
                    Level level = Level.INFO;
                    StringBuilder sb = new StringBuilder();
                    sb.append("error from ");
                    sb.append(call);
                    logger.log(level, sb.toString(), (Throwable) th);
                }
            }
        }
        if (runtimeException == null) {
            return scheduleImpl;
        }
        if (runtimeException instanceof Error) {
            throw ((Error) runtimeException);
        }
        if (runtimeException instanceof RuntimeException) {
            throw runtimeException;
        }
        throw ((IOException) runtimeException);
    }

    @Override // zipkin2.Call.Base
    public final void PlaceComponentResult(Callback<O> callback) {
        int size = this.getAuthRequestContext.size();
        AtomicInteger atomicInteger = new AtomicInteger(size);
        AtomicReference atomicReference = new AtomicReference();
        O scheduleImpl = scheduleImpl();
        for (int i = 0; i < size; i++) {
            Call<I> call = this.getAuthRequestContext.get(i);
            call.getAuthRequestContext(new CountdownCallback(call, atomicInteger, atomicReference, scheduleImpl, callback));
        }
    }

    /* loaded from: classes9.dex */
    class CountdownCallback implements Callback<I> {
        final AtomicInteger BuiltInFictitiousFunctionClassFactory;
        final Callback<O> KClassImpl$Data$declaredNonStaticMembers$2;
        final AtomicReference<Throwable> MyBillsEntityDataFactory;
        @Nullable
        final O PlaceComponentResult;
        final Call<I> getAuthRequestContext;

        CountdownCallback(Call<I> call, AtomicInteger atomicInteger, AtomicReference<Throwable> atomicReference, O o2, Callback<O> callback) {
            this.getAuthRequestContext = call;
            this.BuiltInFictitiousFunctionClassFactory = atomicInteger;
            this.MyBillsEntityDataFactory = atomicReference;
            this.PlaceComponentResult = o2;
            this.KClassImpl$Data$declaredNonStaticMembers$2 = callback;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // zipkin2.Callback
        public void onSuccess(I i) {
            synchronized (this.KClassImpl$Data$declaredNonStaticMembers$2) {
                AggregateCall.this.getAuthRequestContext(i, this.PlaceComponentResult);
                if (this.BuiltInFictitiousFunctionClassFactory.decrementAndGet() > 0) {
                    return;
                }
                Throwable th = this.MyBillsEntityDataFactory.get();
                if (th != null) {
                    this.KClassImpl$Data$declaredNonStaticMembers$2.onError(th);
                } else {
                    this.KClassImpl$Data$declaredNonStaticMembers$2.onSuccess(AggregateCall.KClassImpl$Data$declaredNonStaticMembers$2(this.PlaceComponentResult));
                }
            }
        }

        @Override // zipkin2.Callback
        public void onError(Throwable th) {
            synchronized (this) {
                if (AggregateCall.this.MyBillsEntityDataFactory.isLoggable(Level.INFO)) {
                    Logger logger = AggregateCall.this.MyBillsEntityDataFactory;
                    Level level = Level.INFO;
                    StringBuilder sb = new StringBuilder();
                    sb.append("error from ");
                    sb.append(this.getAuthRequestContext);
                    logger.log(level, sb.toString(), th);
                }
                synchronized (this.KClassImpl$Data$declaredNonStaticMembers$2) {
                    LifecycleKt$$ExternalSyntheticBackportWithForwarding0.KClassImpl$Data$declaredNonStaticMembers$2(this.MyBillsEntityDataFactory, null, th);
                    if (this.BuiltInFictitiousFunctionClassFactory.decrementAndGet() > 0) {
                        return;
                    }
                    this.KClassImpl$Data$declaredNonStaticMembers$2.onError(this.MyBillsEntityDataFactory.get());
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final List<Call<I>> BuiltInFictitiousFunctionClassFactory() {
        int size = this.getAuthRequestContext.size();
        ArrayList arrayList = new ArrayList(size);
        for (int i = 0; i < size; i++) {
            arrayList.add(this.getAuthRequestContext.get(i).clone());
        }
        return arrayList;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("AggregateCall{");
        sb.append(this.getAuthRequestContext);
        sb.append("}");
        return sb.toString();
    }
}
