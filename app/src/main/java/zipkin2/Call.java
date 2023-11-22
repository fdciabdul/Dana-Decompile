package zipkin2;

import java.io.IOException;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes6.dex */
public abstract class Call<V> implements Cloneable {

    /* loaded from: classes9.dex */
    public interface ErrorHandler<V> {
    }

    /* loaded from: classes9.dex */
    public interface FlatMapper<V1, V2> {
        Call<V2> BuiltInFictitiousFunctionClassFactory();
    }

    /* loaded from: classes9.dex */
    public interface Mapper<V1, V2> {
        V2 map(V1 v1);
    }

    @Override // 
    /* renamed from: MyBillsEntityDataFactory  reason: merged with bridge method [inline-methods] */
    public abstract Call<V> clone();

    public abstract V PlaceComponentResult() throws IOException;

    public abstract void getAuthRequestContext(Callback<V> callback);

    public static <V> Call<V> getAuthRequestContext() {
        return new Constant(null);
    }

    public static void KClassImpl$Data$declaredNonStaticMembers$2(Throwable th) {
        if (th instanceof VirtualMachineError) {
            throw ((VirtualMachineError) th);
        }
        if (th instanceof ThreadDeath) {
            throw ((ThreadDeath) th);
        }
        if (th instanceof LinkageError) {
            throw ((LinkageError) th);
        }
    }

    /* loaded from: classes6.dex */
    static class Constant<V> extends Base<V> {
        final V BuiltInFictitiousFunctionClassFactory;

        Constant(V v) {
            this.BuiltInFictitiousFunctionClassFactory = v;
        }

        @Override // zipkin2.Call.Base
        protected final V KClassImpl$Data$declaredNonStaticMembers$2() {
            return this.BuiltInFictitiousFunctionClassFactory;
        }

        @Override // zipkin2.Call.Base
        protected final void PlaceComponentResult(Callback<V> callback) {
            callback.onSuccess(this.BuiltInFictitiousFunctionClassFactory);
        }

        @Override // zipkin2.Call
        /* renamed from: MyBillsEntityDataFactory */
        public final Call<V> clone() {
            return new Constant(this.BuiltInFictitiousFunctionClassFactory);
        }

        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("ConstantCall{value=");
            sb.append(this.BuiltInFictitiousFunctionClassFactory);
            sb.append("}");
            return sb.toString();
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (obj instanceof Constant) {
                V v = this.BuiltInFictitiousFunctionClassFactory;
                V v2 = ((Constant) obj).BuiltInFictitiousFunctionClassFactory;
                return v == null ? v2 == null : v.equals(v2);
            }
            return false;
        }

        public int hashCode() {
            V v = this.BuiltInFictitiousFunctionClassFactory;
            return (v == null ? 0 : v.hashCode()) ^ 1000003;
        }

        @Override // zipkin2.Call.Base, zipkin2.Call
        public /* synthetic */ Object clone() throws CloneNotSupportedException {
            return new Constant(this.BuiltInFictitiousFunctionClassFactory);
        }
    }

    /* loaded from: classes9.dex */
    static final class Mapping<R, V> extends Base<R> {
        final Mapper<V, R> BuiltInFictitiousFunctionClassFactory;
        final Call<V> MyBillsEntityDataFactory;

        private Mapping(Mapper<V, R> mapper, Call<V> call) {
            this.BuiltInFictitiousFunctionClassFactory = mapper;
            this.MyBillsEntityDataFactory = call;
        }

        @Override // zipkin2.Call.Base
        protected final R KClassImpl$Data$declaredNonStaticMembers$2() throws IOException {
            return this.BuiltInFictitiousFunctionClassFactory.map(this.MyBillsEntityDataFactory.PlaceComponentResult());
        }

        @Override // zipkin2.Call.Base
        protected final void PlaceComponentResult(final Callback<R> callback) {
            this.MyBillsEntityDataFactory.getAuthRequestContext(new Callback<V>() { // from class: zipkin2.Call.Mapping.1
                @Override // zipkin2.Callback
                public void onSuccess(V v) {
                    try {
                        callback.onSuccess(Mapping.this.BuiltInFictitiousFunctionClassFactory.map(v));
                    } catch (Throwable th) {
                        callback.onError(th);
                    }
                }

                @Override // zipkin2.Callback
                public void onError(Throwable th) {
                    callback.onError(th);
                }
            });
        }

        public final String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("Mapping{call=");
            sb.append(this.MyBillsEntityDataFactory);
            sb.append(", mapper=");
            sb.append(this.BuiltInFictitiousFunctionClassFactory);
            sb.append("}");
            return sb.toString();
        }

        @Override // zipkin2.Call
        /* renamed from: MyBillsEntityDataFactory */
        public final Call<R> clone() {
            return new Mapping(this.BuiltInFictitiousFunctionClassFactory, this.MyBillsEntityDataFactory.clone());
        }

        @Override // zipkin2.Call.Base, zipkin2.Call
        public final /* synthetic */ Object clone() throws CloneNotSupportedException {
            return new Mapping(this.BuiltInFictitiousFunctionClassFactory, this.MyBillsEntityDataFactory.clone());
        }
    }

    /* loaded from: classes9.dex */
    static final class FlatMapping<R, V> extends Base<R> {
        volatile Call<R> BuiltInFictitiousFunctionClassFactory;
        final FlatMapper<V, R> MyBillsEntityDataFactory;
        final Call<V> getAuthRequestContext;

        private FlatMapping(FlatMapper<V, R> flatMapper, Call<V> call) {
            this.MyBillsEntityDataFactory = flatMapper;
            this.getAuthRequestContext = call;
        }

        @Override // zipkin2.Call.Base
        protected final R KClassImpl$Data$declaredNonStaticMembers$2() throws IOException {
            FlatMapper<V, R> flatMapper = this.MyBillsEntityDataFactory;
            this.getAuthRequestContext.PlaceComponentResult();
            Call<R> BuiltInFictitiousFunctionClassFactory = flatMapper.BuiltInFictitiousFunctionClassFactory();
            this.BuiltInFictitiousFunctionClassFactory = BuiltInFictitiousFunctionClassFactory;
            return BuiltInFictitiousFunctionClassFactory.PlaceComponentResult();
        }

        @Override // zipkin2.Call.Base
        protected final void PlaceComponentResult(final Callback<R> callback) {
            this.getAuthRequestContext.getAuthRequestContext(new Callback<V>() { // from class: zipkin2.Call.FlatMapping.1
                @Override // zipkin2.Callback
                public void onSuccess(V v) {
                    try {
                        FlatMapping flatMapping = FlatMapping.this;
                        Call<R> BuiltInFictitiousFunctionClassFactory = flatMapping.MyBillsEntityDataFactory.BuiltInFictitiousFunctionClassFactory();
                        flatMapping.BuiltInFictitiousFunctionClassFactory = BuiltInFictitiousFunctionClassFactory;
                        BuiltInFictitiousFunctionClassFactory.getAuthRequestContext(callback);
                    } catch (Throwable th) {
                        Call.KClassImpl$Data$declaredNonStaticMembers$2(th);
                        callback.onError(th);
                    }
                }

                @Override // zipkin2.Callback
                public void onError(Throwable th) {
                    callback.onError(th);
                }
            });
        }

        public final String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("FlatMapping{call=");
            sb.append(this.getAuthRequestContext);
            sb.append(", flatMapper=");
            sb.append(this.MyBillsEntityDataFactory);
            sb.append("}");
            return sb.toString();
        }

        @Override // zipkin2.Call
        /* renamed from: MyBillsEntityDataFactory */
        public final Call<R> clone() {
            return new FlatMapping(this.MyBillsEntityDataFactory, this.getAuthRequestContext.clone());
        }

        @Override // zipkin2.Call.Base, zipkin2.Call
        public final /* synthetic */ Object clone() throws CloneNotSupportedException {
            return new FlatMapping(this.MyBillsEntityDataFactory, this.getAuthRequestContext.clone());
        }
    }

    /* loaded from: classes9.dex */
    static final class ErrorHandling<V> extends Base<V> {
        static final Object BuiltInFictitiousFunctionClassFactory = new Object();
        final ErrorHandler<V> MyBillsEntityDataFactory;
        final Call<V> getAuthRequestContext;

        private ErrorHandling(ErrorHandler<V> errorHandler, Call<V> call) {
            this.MyBillsEntityDataFactory = errorHandler;
            this.getAuthRequestContext = call;
        }

        @Override // zipkin2.Call.Base
        protected final V KClassImpl$Data$declaredNonStaticMembers$2() throws IOException {
            try {
                return this.getAuthRequestContext.PlaceComponentResult();
            } catch (IOException e) {
                return MyBillsEntityDataFactory(e);
            } catch (Error e2) {
                Call.KClassImpl$Data$declaredNonStaticMembers$2(e2);
                return MyBillsEntityDataFactory(e2);
            } catch (RuntimeException e3) {
                return MyBillsEntityDataFactory(e3);
            }
        }

        private <T extends Throwable> V MyBillsEntityDataFactory(T t) throws Throwable {
            Object obj = BuiltInFictitiousFunctionClassFactory;
            final AtomicReference atomicReference = new AtomicReference(obj);
            new Callback<V>() { // from class: zipkin2.Call.ErrorHandling.1
                @Override // zipkin2.Callback
                public void onError(Throwable th) {
                }

                @Override // zipkin2.Callback
                public void onSuccess(V v) {
                    atomicReference.set(v);
                }
            };
            V v = (V) atomicReference.get();
            if (obj != v) {
                return v;
            }
            throw t;
        }

        @Override // zipkin2.Call.Base
        protected final void PlaceComponentResult(final Callback<V> callback) {
            this.getAuthRequestContext.getAuthRequestContext(new Callback<V>() { // from class: zipkin2.Call.ErrorHandling.2
                @Override // zipkin2.Callback
                public void onSuccess(V v) {
                    callback.onSuccess(v);
                }

                @Override // zipkin2.Callback
                public void onError(Throwable th) {
                    ErrorHandler<V> errorHandler = ErrorHandling.this.MyBillsEntityDataFactory;
                }
            });
        }

        public final String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("ErrorHandling{call=");
            sb.append(this.getAuthRequestContext);
            sb.append(", errorHandler=");
            sb.append(this.MyBillsEntityDataFactory);
            sb.append("}");
            return sb.toString();
        }

        @Override // zipkin2.Call
        /* renamed from: MyBillsEntityDataFactory */
        public final Call<V> clone() {
            return new ErrorHandling(this.MyBillsEntityDataFactory, this.getAuthRequestContext.clone());
        }

        @Override // zipkin2.Call.Base, zipkin2.Call
        public final /* synthetic */ Object clone() throws CloneNotSupportedException {
            return new ErrorHandling(this.MyBillsEntityDataFactory, this.getAuthRequestContext.clone());
        }
    }

    /* loaded from: classes6.dex */
    public static abstract class Base<V> extends Call<V> {
        volatile boolean KClassImpl$Data$declaredNonStaticMembers$2;
        boolean PlaceComponentResult;

        protected abstract V KClassImpl$Data$declaredNonStaticMembers$2() throws IOException;

        protected abstract void PlaceComponentResult(Callback<V> callback);

        @Override // zipkin2.Call
        public /* synthetic */ Object clone() throws CloneNotSupportedException {
            return super.clone();
        }

        @Override // zipkin2.Call
        public final V PlaceComponentResult() throws IOException {
            synchronized (this) {
                if (this.PlaceComponentResult) {
                    throw new IllegalStateException("Already Executed");
                }
                this.PlaceComponentResult = true;
            }
            if (BuiltInFictitiousFunctionClassFactory()) {
                throw new IOException("Canceled");
            }
            return KClassImpl$Data$declaredNonStaticMembers$2();
        }

        @Override // zipkin2.Call
        public final void getAuthRequestContext(Callback<V> callback) {
            synchronized (this) {
                if (this.PlaceComponentResult) {
                    throw new IllegalStateException("Already Executed");
                }
                this.PlaceComponentResult = true;
            }
            if (BuiltInFictitiousFunctionClassFactory()) {
                callback.onError(new IOException("Canceled"));
            } else {
                PlaceComponentResult(callback);
            }
        }

        private boolean BuiltInFictitiousFunctionClassFactory() {
            return this.KClassImpl$Data$declaredNonStaticMembers$2;
        }
    }
}
