package retrofit2;

import com.google.firebase.perf.FirebasePerformance;
import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Objects;
import javax.annotation.Nullable;
import kotlin.coroutines.Continuation;
import okhttp3.Call;
import okhttp3.ResponseBody;
import retrofit2.Utils;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes6.dex */
public abstract class HttpServiceMethod<ResponseT, ReturnT> extends ServiceMethod<ReturnT> {
    private final Converter<ResponseBody, ResponseT> KClassImpl$Data$declaredNonStaticMembers$2;
    private final RequestFactory MyBillsEntityDataFactory;
    private final Call.Factory PlaceComponentResult;

    @Nullable
    protected abstract ReturnT KClassImpl$Data$declaredNonStaticMembers$2(Call<ResponseT> call, Object[] objArr);

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <ResponseT, ReturnT> HttpServiceMethod<ResponseT, ReturnT> MyBillsEntityDataFactory(Retrofit retrofit, Method method, RequestFactory requestFactory) {
        Type genericReturnType;
        boolean z;
        boolean z2 = requestFactory.NetworkUserEntityData$$ExternalSyntheticLambda0;
        Annotation[] annotations = method.getAnnotations();
        if (z2) {
            Type[] genericParameterTypes = method.getGenericParameterTypes();
            Type authRequestContext = Utils.getAuthRequestContext((ParameterizedType) genericParameterTypes[genericParameterTypes.length - 1]);
            if (Utils.BuiltInFictitiousFunctionClassFactory(authRequestContext) == Response.class && (authRequestContext instanceof ParameterizedType)) {
                authRequestContext = Utils.MyBillsEntityDataFactory(0, (ParameterizedType) authRequestContext);
                z = true;
            } else {
                z = false;
            }
            genericReturnType = new Utils.ParameterizedTypeImpl(null, Call.class, authRequestContext);
            annotations = SkipCallbackExecutorImpl.ensurePresent(annotations);
        } else {
            genericReturnType = method.getGenericReturnType();
            z = false;
        }
        CallAdapter authRequestContext2 = getAuthRequestContext(retrofit, method, genericReturnType, annotations);
        Type authRequestContext3 = authRequestContext2.getAuthRequestContext();
        if (authRequestContext3 == okhttp3.Response.class) {
            StringBuilder sb = new StringBuilder();
            sb.append("'");
            sb.append(Utils.BuiltInFictitiousFunctionClassFactory(authRequestContext3).getName());
            sb.append("' is not a valid response body type. Did you mean ResponseBody?");
            throw Utils.BuiltInFictitiousFunctionClassFactory(method, sb.toString(), new Object[0]);
        } else if (authRequestContext3 == Response.class) {
            throw Utils.BuiltInFictitiousFunctionClassFactory(method, "Response must include generic type (e.g., Response<String>)", new Object[0]);
        } else {
            if (requestFactory.PlaceComponentResult.equals(FirebasePerformance.HttpMethod.HEAD) && !Void.class.equals(authRequestContext3)) {
                throw Utils.BuiltInFictitiousFunctionClassFactory(method, "HEAD method must use Void as response type.", new Object[0]);
            }
            Converter authRequestContext4 = getAuthRequestContext(retrofit, method, authRequestContext3);
            Call.Factory factory = retrofit.MyBillsEntityDataFactory;
            if (z2) {
                if (z) {
                    return new SuspendForResponse(requestFactory, factory, authRequestContext4, authRequestContext2);
                }
                return new SuspendForBody(requestFactory, factory, authRequestContext4, authRequestContext2);
            }
            return new CallAdapted(requestFactory, factory, authRequestContext4, authRequestContext2);
        }
    }

    private static <ResponseT> Converter<ResponseBody, ResponseT> getAuthRequestContext(Retrofit retrofit, Method method, Type type) {
        try {
            return retrofit.MyBillsEntityDataFactory(type, method.getAnnotations());
        } catch (RuntimeException e) {
            throw Utils.PlaceComponentResult(method, e, "Unable to create converter for %s", type);
        }
    }

    HttpServiceMethod(RequestFactory requestFactory, Call.Factory factory, Converter<ResponseBody, ResponseT> converter) {
        this.MyBillsEntityDataFactory = requestFactory;
        this.PlaceComponentResult = factory;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = converter;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // retrofit2.ServiceMethod
    @Nullable
    public final ReturnT PlaceComponentResult(Object[] objArr) {
        return KClassImpl$Data$declaredNonStaticMembers$2(new OkHttpCall(this.MyBillsEntityDataFactory, objArr, this.PlaceComponentResult, this.KClassImpl$Data$declaredNonStaticMembers$2), objArr);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes6.dex */
    public static final class CallAdapted<ResponseT, ReturnT> extends HttpServiceMethod<ResponseT, ReturnT> {
        private final CallAdapter<ResponseT, ReturnT> MyBillsEntityDataFactory;

        CallAdapted(RequestFactory requestFactory, Call.Factory factory, Converter<ResponseBody, ResponseT> converter, CallAdapter<ResponseT, ReturnT> callAdapter) {
            super(requestFactory, factory, converter);
            this.MyBillsEntityDataFactory = callAdapter;
        }

        @Override // retrofit2.HttpServiceMethod
        protected final ReturnT KClassImpl$Data$declaredNonStaticMembers$2(Call<ResponseT> call, Object[] objArr) {
            return this.MyBillsEntityDataFactory.KClassImpl$Data$declaredNonStaticMembers$2(call);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes6.dex */
    public static final class SuspendForResponse<ResponseT> extends HttpServiceMethod<ResponseT, Object> {
        private final CallAdapter<ResponseT, Call<ResponseT>> MyBillsEntityDataFactory;

        SuspendForResponse(RequestFactory requestFactory, Call.Factory factory, Converter<ResponseBody, ResponseT> converter, CallAdapter<ResponseT, Call<ResponseT>> callAdapter) {
            super(requestFactory, factory, converter);
            this.MyBillsEntityDataFactory = callAdapter;
        }

        @Override // retrofit2.HttpServiceMethod
        protected final Object KClassImpl$Data$declaredNonStaticMembers$2(Call<ResponseT> call, Object[] objArr) {
            Call<ResponseT> KClassImpl$Data$declaredNonStaticMembers$2 = this.MyBillsEntityDataFactory.KClassImpl$Data$declaredNonStaticMembers$2(call);
            Continuation continuation = (Continuation) objArr[objArr.length - 1];
            try {
                return KotlinExtensions.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$2, continuation);
            } catch (Exception e) {
                return KotlinExtensions.PlaceComponentResult(e, continuation);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes6.dex */
    public static final class SuspendForBody<ResponseT> extends HttpServiceMethod<ResponseT, Object> {
        private final CallAdapter<ResponseT, Call<ResponseT>> BuiltInFictitiousFunctionClassFactory;
        private final boolean KClassImpl$Data$declaredNonStaticMembers$2;

        SuspendForBody(RequestFactory requestFactory, Call.Factory factory, Converter<ResponseBody, ResponseT> converter, CallAdapter<ResponseT, Call<ResponseT>> callAdapter) {
            super(requestFactory, factory, converter);
            this.BuiltInFictitiousFunctionClassFactory = callAdapter;
            this.KClassImpl$Data$declaredNonStaticMembers$2 = false;
        }

        @Override // retrofit2.HttpServiceMethod
        protected final Object KClassImpl$Data$declaredNonStaticMembers$2(Call<ResponseT> call, Object[] objArr) {
            Call<ResponseT> KClassImpl$Data$declaredNonStaticMembers$2 = this.BuiltInFictitiousFunctionClassFactory.KClassImpl$Data$declaredNonStaticMembers$2(call);
            Continuation continuation = (Continuation) objArr[objArr.length - 1];
            try {
                if (this.KClassImpl$Data$declaredNonStaticMembers$2) {
                    return KotlinExtensions.PlaceComponentResult(KClassImpl$Data$declaredNonStaticMembers$2, continuation);
                }
                return KotlinExtensions.MyBillsEntityDataFactory(KClassImpl$Data$declaredNonStaticMembers$2, continuation);
            } catch (Exception e) {
                return KotlinExtensions.PlaceComponentResult(e, continuation);
            }
        }
    }

    private static <ResponseT, ReturnT> CallAdapter<ResponseT, ReturnT> getAuthRequestContext(Retrofit retrofit, Method method, Type type, Annotation[] annotationArr) {
        try {
            Objects.requireNonNull(type, "returnType == null");
            Objects.requireNonNull(annotationArr, "annotations == null");
            int indexOf = retrofit.PlaceComponentResult.indexOf(null) + 1;
            int size = retrofit.PlaceComponentResult.size();
            for (int i = indexOf; i < size; i++) {
                CallAdapter<ResponseT, ReturnT> callAdapter = (CallAdapter<ResponseT, ReturnT>) retrofit.PlaceComponentResult.get(i).KClassImpl$Data$declaredNonStaticMembers$2(type, annotationArr);
                if (callAdapter != null) {
                    return callAdapter;
                }
            }
            StringBuilder sb = new StringBuilder("Could not locate call adapter for ");
            sb.append(type);
            sb.append(".\n");
            sb.append("  Tried:");
            int size2 = retrofit.PlaceComponentResult.size();
            while (indexOf < size2) {
                sb.append("\n   * ");
                sb.append(retrofit.PlaceComponentResult.get(indexOf).getClass().getName());
                indexOf++;
            }
            throw new IllegalArgumentException(sb.toString());
        } catch (RuntimeException e) {
            throw Utils.PlaceComponentResult(method, e, "Unable to create call adapter for %s", type);
        }
    }
}
