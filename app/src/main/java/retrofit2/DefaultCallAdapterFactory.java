package retrofit2;

import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Objects;
import java.util.concurrent.Executor;
import javax.annotation.Nullable;
import okhttp3.Request;
import retrofit2.CallAdapter;
import retrofit2.DefaultCallAdapterFactory;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes6.dex */
public final class DefaultCallAdapterFactory extends CallAdapter.Factory {
    @Nullable
    private final Executor MyBillsEntityDataFactory;

    /* JADX INFO: Access modifiers changed from: package-private */
    public DefaultCallAdapterFactory(@Nullable Executor executor) {
        this.MyBillsEntityDataFactory = executor;
    }

    /* loaded from: classes6.dex */
    static final class ExecutorCallbackCall<T> implements Call<T> {
        final Executor BuiltInFictitiousFunctionClassFactory;
        final Call<T> MyBillsEntityDataFactory;

        ExecutorCallbackCall(Executor executor, Call<T> call) {
            this.BuiltInFictitiousFunctionClassFactory = executor;
            this.MyBillsEntityDataFactory = call;
        }

        @Override // retrofit2.Call
        public final void MyBillsEntityDataFactory(Callback<T> callback) {
            Objects.requireNonNull(callback, "callback == null");
            this.MyBillsEntityDataFactory.MyBillsEntityDataFactory(new AnonymousClass1(callback));
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* renamed from: retrofit2.DefaultCallAdapterFactory$ExecutorCallbackCall$1  reason: invalid class name */
        /* loaded from: classes6.dex */
        public class AnonymousClass1 implements Callback<T> {
            final /* synthetic */ Callback KClassImpl$Data$declaredNonStaticMembers$2;

            AnonymousClass1(Callback callback) {
                this.KClassImpl$Data$declaredNonStaticMembers$2 = callback;
            }

            @Override // retrofit2.Callback
            public final void PlaceComponentResult(Call<T> call, final Response<T> response) {
                Executor executor = ExecutorCallbackCall.this.BuiltInFictitiousFunctionClassFactory;
                final Callback callback = this.KClassImpl$Data$declaredNonStaticMembers$2;
                executor.execute(new Runnable() { // from class: retrofit2.DefaultCallAdapterFactory$ExecutorCallbackCall$1$$ExternalSyntheticLambda0
                    @Override // java.lang.Runnable
                    public final void run() {
                        DefaultCallAdapterFactory.ExecutorCallbackCall.AnonymousClass1 anonymousClass1 = DefaultCallAdapterFactory.ExecutorCallbackCall.AnonymousClass1.this;
                        Callback callback2 = callback;
                        Response response2 = response;
                        if (DefaultCallAdapterFactory.ExecutorCallbackCall.this.MyBillsEntityDataFactory.MyBillsEntityDataFactory()) {
                            callback2.KClassImpl$Data$declaredNonStaticMembers$2(DefaultCallAdapterFactory.ExecutorCallbackCall.this, new IOException("Canceled"));
                        } else {
                            callback2.PlaceComponentResult(DefaultCallAdapterFactory.ExecutorCallbackCall.this, response2);
                        }
                    }
                });
            }

            @Override // retrofit2.Callback
            public final void KClassImpl$Data$declaredNonStaticMembers$2(Call<T> call, final Throwable th) {
                Executor executor = ExecutorCallbackCall.this.BuiltInFictitiousFunctionClassFactory;
                final Callback callback = this.KClassImpl$Data$declaredNonStaticMembers$2;
                executor.execute(new Runnable() { // from class: retrofit2.DefaultCallAdapterFactory$ExecutorCallbackCall$1$$ExternalSyntheticLambda1
                    @Override // java.lang.Runnable
                    public final void run() {
                        DefaultCallAdapterFactory.ExecutorCallbackCall.AnonymousClass1 anonymousClass1 = DefaultCallAdapterFactory.ExecutorCallbackCall.AnonymousClass1.this;
                        callback.KClassImpl$Data$declaredNonStaticMembers$2(DefaultCallAdapterFactory.ExecutorCallbackCall.this, th);
                    }
                });
            }
        }

        @Override // retrofit2.Call
        public final Response<T> PlaceComponentResult() throws IOException {
            return this.MyBillsEntityDataFactory.PlaceComponentResult();
        }

        @Override // retrofit2.Call
        public final void getAuthRequestContext() {
            this.MyBillsEntityDataFactory.getAuthRequestContext();
        }

        @Override // retrofit2.Call
        public final boolean MyBillsEntityDataFactory() {
            return this.MyBillsEntityDataFactory.MyBillsEntityDataFactory();
        }

        @Override // retrofit2.Call
        public final Call<T> BuiltInFictitiousFunctionClassFactory() {
            return new ExecutorCallbackCall(this.BuiltInFictitiousFunctionClassFactory, this.MyBillsEntityDataFactory.BuiltInFictitiousFunctionClassFactory());
        }

        @Override // retrofit2.Call
        public final Request KClassImpl$Data$declaredNonStaticMembers$2() {
            return this.MyBillsEntityDataFactory.KClassImpl$Data$declaredNonStaticMembers$2();
        }

        public final /* synthetic */ Object clone() throws CloneNotSupportedException {
            return new ExecutorCallbackCall(this.BuiltInFictitiousFunctionClassFactory, this.MyBillsEntityDataFactory.BuiltInFictitiousFunctionClassFactory());
        }
    }

    @Override // retrofit2.CallAdapter.Factory
    @Nullable
    public final CallAdapter<?, ?> KClassImpl$Data$declaredNonStaticMembers$2(Type type, Annotation[] annotationArr) {
        if (Utils.BuiltInFictitiousFunctionClassFactory(type) != Call.class) {
            return null;
        }
        if (!(type instanceof ParameterizedType)) {
            throw new IllegalArgumentException("Call return type must be parameterized as Call<Foo> or Call<? extends Foo>");
        }
        final Type MyBillsEntityDataFactory = Utils.MyBillsEntityDataFactory(0, (ParameterizedType) type);
        final Executor executor = Utils.KClassImpl$Data$declaredNonStaticMembers$2(annotationArr, SkipCallbackExecutor.class) ? null : this.MyBillsEntityDataFactory;
        return new CallAdapter<Object, Call<?>>() { // from class: retrofit2.DefaultCallAdapterFactory.1
            @Override // retrofit2.CallAdapter
            public final Type getAuthRequestContext() {
                return MyBillsEntityDataFactory;
            }

            @Override // retrofit2.CallAdapter
            public final /* synthetic */ Call<?> KClassImpl$Data$declaredNonStaticMembers$2(Call<Object> call) {
                Executor executor2 = executor;
                return executor2 != null ? new ExecutorCallbackCall(executor2, call) : call;
            }
        };
    }
}
