package retrofit2;

import java.lang.annotation.Annotation;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.concurrent.CompletableFuture;
import javax.annotation.Nullable;
import retrofit2.CallAdapter;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes6.dex */
public final class CompletableFutureCallAdapterFactory extends CallAdapter.Factory {
    static final CallAdapter.Factory MyBillsEntityDataFactory = new CompletableFutureCallAdapterFactory();

    CompletableFutureCallAdapterFactory() {
    }

    /* loaded from: classes6.dex */
    static final class BodyCallAdapter<R> implements CallAdapter<R, CompletableFuture<R>> {
        private final Type MyBillsEntityDataFactory;

        BodyCallAdapter(Type type) {
            this.MyBillsEntityDataFactory = type;
        }

        @Override // retrofit2.CallAdapter
        public final Type getAuthRequestContext() {
            return this.MyBillsEntityDataFactory;
        }

        /* loaded from: classes6.dex */
        class BodyCallback implements Callback<R> {
            private final CompletableFuture<R> MyBillsEntityDataFactory;

            public BodyCallback(CompletableFuture<R> completableFuture) {
                this.MyBillsEntityDataFactory = completableFuture;
            }

            @Override // retrofit2.Callback
            public final void PlaceComponentResult(Call<R> call, Response<R> response) {
                if (response.MyBillsEntityDataFactory()) {
                    this.MyBillsEntityDataFactory.complete(response.KClassImpl$Data$declaredNonStaticMembers$2);
                } else {
                    this.MyBillsEntityDataFactory.completeExceptionally(new HttpException(response));
                }
            }

            @Override // retrofit2.Callback
            public final void KClassImpl$Data$declaredNonStaticMembers$2(Call<R> call, Throwable th) {
                this.MyBillsEntityDataFactory.completeExceptionally(th);
            }
        }

        @Override // retrofit2.CallAdapter
        public final /* synthetic */ Object KClassImpl$Data$declaredNonStaticMembers$2(Call call) {
            CallCancelCompletableFuture callCancelCompletableFuture = new CallCancelCompletableFuture(call);
            call.MyBillsEntityDataFactory(new BodyCallback(callCancelCompletableFuture));
            return callCancelCompletableFuture;
        }
    }

    /* loaded from: classes6.dex */
    static final class ResponseCallAdapter<R> implements CallAdapter<R, CompletableFuture<Response<R>>> {
        private final Type KClassImpl$Data$declaredNonStaticMembers$2;

        ResponseCallAdapter(Type type) {
            this.KClassImpl$Data$declaredNonStaticMembers$2 = type;
        }

        @Override // retrofit2.CallAdapter
        public final Type getAuthRequestContext() {
            return this.KClassImpl$Data$declaredNonStaticMembers$2;
        }

        /* loaded from: classes6.dex */
        class ResponseCallback implements Callback<R> {
            private final CompletableFuture<Response<R>> PlaceComponentResult;

            public ResponseCallback(CompletableFuture<Response<R>> completableFuture) {
                this.PlaceComponentResult = completableFuture;
            }

            @Override // retrofit2.Callback
            public final void PlaceComponentResult(Call<R> call, Response<R> response) {
                this.PlaceComponentResult.complete(response);
            }

            @Override // retrofit2.Callback
            public final void KClassImpl$Data$declaredNonStaticMembers$2(Call<R> call, Throwable th) {
                this.PlaceComponentResult.completeExceptionally(th);
            }
        }

        @Override // retrofit2.CallAdapter
        public final /* synthetic */ Object KClassImpl$Data$declaredNonStaticMembers$2(Call call) {
            CallCancelCompletableFuture callCancelCompletableFuture = new CallCancelCompletableFuture(call);
            call.MyBillsEntityDataFactory(new ResponseCallback(callCancelCompletableFuture));
            return callCancelCompletableFuture;
        }
    }

    /* loaded from: classes6.dex */
    static final class CallCancelCompletableFuture<T> extends CompletableFuture<T> {
        private final Call<?> KClassImpl$Data$declaredNonStaticMembers$2;

        CallCancelCompletableFuture(Call<?> call) {
            this.KClassImpl$Data$declaredNonStaticMembers$2 = call;
        }

        @Override // java.util.concurrent.CompletableFuture, java.util.concurrent.Future
        public final boolean cancel(boolean z) {
            if (z) {
                this.KClassImpl$Data$declaredNonStaticMembers$2.getAuthRequestContext();
            }
            return super.cancel(z);
        }
    }

    @Override // retrofit2.CallAdapter.Factory
    @Nullable
    public final CallAdapter<?, ?> KClassImpl$Data$declaredNonStaticMembers$2(Type type, Annotation[] annotationArr) {
        if (Utils.BuiltInFictitiousFunctionClassFactory(type) != CompletableFuture.class) {
            return null;
        }
        if (!(type instanceof ParameterizedType)) {
            throw new IllegalStateException("CompletableFuture return type must be parameterized as CompletableFuture<Foo> or CompletableFuture<? extends Foo>");
        }
        Type MyBillsEntityDataFactory2 = Utils.MyBillsEntityDataFactory(0, (ParameterizedType) type);
        if (Utils.BuiltInFictitiousFunctionClassFactory(MyBillsEntityDataFactory2) != Response.class) {
            return new BodyCallAdapter(MyBillsEntityDataFactory2);
        }
        if (!(MyBillsEntityDataFactory2 instanceof ParameterizedType)) {
            throw new IllegalStateException("Response must be parameterized as Response<Foo> or Response<? extends Foo>");
        }
        return new ResponseCallAdapter(Utils.MyBillsEntityDataFactory(0, (ParameterizedType) MyBillsEntityDataFactory2));
    }
}
