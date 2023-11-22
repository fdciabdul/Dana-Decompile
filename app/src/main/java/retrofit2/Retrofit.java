package retrofit2;

import j$.util.concurrent.ConcurrentHashMap;
import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.Proxy;
import java.lang.reflect.Type;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.Executor;
import javax.annotation.Nullable;
import okhttp3.Call;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.BuiltInConverters;
import retrofit2.CallAdapter;
import retrofit2.Converter;

/* loaded from: classes2.dex */
public final class Retrofit {
    @Nullable
    final Executor BuiltInFictitiousFunctionClassFactory;
    final List<Converter.Factory> KClassImpl$Data$declaredNonStaticMembers$2;
    final Call.Factory MyBillsEntityDataFactory;
    final boolean NetworkUserEntityData$$ExternalSyntheticLambda0;
    final List<CallAdapter.Factory> PlaceComponentResult;
    final HttpUrl getAuthRequestContext;
    private final Map<Method, ServiceMethod<?>> lookAheadTest = new ConcurrentHashMap();

    Retrofit(Call.Factory factory, HttpUrl httpUrl, List<Converter.Factory> list, List<CallAdapter.Factory> list2, @Nullable Executor executor, boolean z) {
        this.MyBillsEntityDataFactory = factory;
        this.getAuthRequestContext = httpUrl;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = list;
        this.PlaceComponentResult = list2;
        this.BuiltInFictitiousFunctionClassFactory = executor;
        this.NetworkUserEntityData$$ExternalSyntheticLambda0 = z;
    }

    public final <T> T PlaceComponentResult(final Class<T> cls) {
        BuiltInFictitiousFunctionClassFactory(cls);
        return (T) Proxy.newProxyInstance(cls.getClassLoader(), new Class[]{cls}, new InvocationHandler() { // from class: retrofit2.Retrofit.1
            private final Platform PlaceComponentResult = Platform.MyBillsEntityDataFactory();
            private final Object[] MyBillsEntityDataFactory = new Object[0];

            @Override // java.lang.reflect.InvocationHandler
            @Nullable
            public Object invoke(Object obj, Method method, @Nullable Object[] objArr) throws Throwable {
                if (method.getDeclaringClass() == Object.class) {
                    return method.invoke(this, objArr);
                }
                if (objArr == null) {
                    objArr = this.MyBillsEntityDataFactory;
                }
                if (this.PlaceComponentResult.PlaceComponentResult(method)) {
                    return this.PlaceComponentResult.MyBillsEntityDataFactory(method, cls, obj, objArr);
                }
                return Retrofit.this.KClassImpl$Data$declaredNonStaticMembers$2(method).PlaceComponentResult(objArr);
            }
        });
    }

    private void BuiltInFictitiousFunctionClassFactory(Class<?> cls) {
        if (!cls.isInterface()) {
            throw new IllegalArgumentException("API declarations must be interfaces.");
        }
        ArrayDeque arrayDeque = new ArrayDeque(1);
        arrayDeque.add(cls);
        while (!arrayDeque.isEmpty()) {
            Class<?> cls2 = (Class) arrayDeque.removeFirst();
            if (cls2.getTypeParameters().length != 0) {
                StringBuilder sb = new StringBuilder("Type parameters are unsupported on ");
                sb.append(cls2.getName());
                if (cls2 != cls) {
                    sb.append(" which is an interface of ");
                    sb.append(cls.getName());
                }
                throw new IllegalArgumentException(sb.toString());
            }
            Collections.addAll(arrayDeque, cls2.getInterfaces());
        }
        if (this.NetworkUserEntityData$$ExternalSyntheticLambda0) {
            Platform MyBillsEntityDataFactory = Platform.MyBillsEntityDataFactory();
            for (Method method : cls.getDeclaredMethods()) {
                if (!MyBillsEntityDataFactory.PlaceComponentResult(method) && !Modifier.isStatic(method.getModifiers())) {
                    KClassImpl$Data$declaredNonStaticMembers$2(method);
                }
            }
        }
    }

    final ServiceMethod<?> KClassImpl$Data$declaredNonStaticMembers$2(Method method) {
        ServiceMethod<?> serviceMethod;
        ServiceMethod<?> serviceMethod2 = this.lookAheadTest.get(method);
        if (serviceMethod2 != null) {
            return serviceMethod2;
        }
        synchronized (this.lookAheadTest) {
            serviceMethod = this.lookAheadTest.get(method);
            if (serviceMethod == null) {
                serviceMethod = ServiceMethod.KClassImpl$Data$declaredNonStaticMembers$2(this, method);
                this.lookAheadTest.put(method, serviceMethod);
            }
        }
        return serviceMethod;
    }

    public final <T> Converter<T, RequestBody> BuiltInFictitiousFunctionClassFactory(Type type, Annotation[] annotationArr, Annotation[] annotationArr2) {
        Objects.requireNonNull(type, "type == null");
        Objects.requireNonNull(annotationArr, "parameterAnnotations == null");
        Objects.requireNonNull(annotationArr2, "methodAnnotations == null");
        int indexOf = this.KClassImpl$Data$declaredNonStaticMembers$2.indexOf(null) + 1;
        int size = this.KClassImpl$Data$declaredNonStaticMembers$2.size();
        for (int i = indexOf; i < size; i++) {
            Converter<T, RequestBody> converter = (Converter<T, RequestBody>) this.KClassImpl$Data$declaredNonStaticMembers$2.get(i).BuiltInFictitiousFunctionClassFactory(type);
            if (converter != null) {
                return converter;
            }
        }
        StringBuilder sb = new StringBuilder("Could not locate RequestBody converter for ");
        sb.append(type);
        sb.append(".\n");
        sb.append("  Tried:");
        int size2 = this.KClassImpl$Data$declaredNonStaticMembers$2.size();
        while (indexOf < size2) {
            sb.append("\n   * ");
            sb.append(this.KClassImpl$Data$declaredNonStaticMembers$2.get(indexOf).getClass().getName());
            indexOf++;
        }
        throw new IllegalArgumentException(sb.toString());
    }

    public final <T> Converter<ResponseBody, T> MyBillsEntityDataFactory(Type type, Annotation[] annotationArr) {
        Objects.requireNonNull(type, "type == null");
        Objects.requireNonNull(annotationArr, "annotations == null");
        int indexOf = this.KClassImpl$Data$declaredNonStaticMembers$2.indexOf(null) + 1;
        int size = this.KClassImpl$Data$declaredNonStaticMembers$2.size();
        for (int i = indexOf; i < size; i++) {
            Converter<ResponseBody, T> converter = (Converter<ResponseBody, T>) this.KClassImpl$Data$declaredNonStaticMembers$2.get(i).getAuthRequestContext(type, annotationArr, this);
            if (converter != null) {
                return converter;
            }
        }
        StringBuilder sb = new StringBuilder("Could not locate ResponseBody converter for ");
        sb.append(type);
        sb.append(".\n");
        sb.append("  Tried:");
        int size2 = this.KClassImpl$Data$declaredNonStaticMembers$2.size();
        while (indexOf < size2) {
            sb.append("\n   * ");
            sb.append(this.KClassImpl$Data$declaredNonStaticMembers$2.get(indexOf).getClass().getName());
            indexOf++;
        }
        throw new IllegalArgumentException(sb.toString());
    }

    public final <T> Converter<T, String> getAuthRequestContext(Type type, Annotation[] annotationArr) {
        Objects.requireNonNull(type, "type == null");
        Objects.requireNonNull(annotationArr, "annotations == null");
        int size = this.KClassImpl$Data$declaredNonStaticMembers$2.size();
        for (int i = 0; i < size; i++) {
            this.KClassImpl$Data$declaredNonStaticMembers$2.get(i);
        }
        return BuiltInConverters.ToStringConverter.PlaceComponentResult;
    }

    /* loaded from: classes2.dex */
    public static final class Builder {
        public final List<Converter.Factory> BuiltInFictitiousFunctionClassFactory;
        @Nullable
        private Executor KClassImpl$Data$declaredNonStaticMembers$2;
        @Nullable
        public Call.Factory MyBillsEntityDataFactory;
        public final List<CallAdapter.Factory> PlaceComponentResult;
        @Nullable
        private HttpUrl getAuthRequestContext;
        private boolean getErrorConfigVersion;
        private final Platform lookAheadTest;

        private Builder(Platform platform) {
            this.BuiltInFictitiousFunctionClassFactory = new ArrayList();
            this.PlaceComponentResult = new ArrayList();
            this.lookAheadTest = platform;
        }

        public Builder() {
            this(Platform.MyBillsEntityDataFactory());
        }

        public final Builder BuiltInFictitiousFunctionClassFactory(HttpUrl httpUrl) {
            Objects.requireNonNull(httpUrl, "baseUrl == null");
            if (!"".equals(httpUrl.pathSegments().get(r0.size() - 1))) {
                StringBuilder sb = new StringBuilder();
                sb.append("baseUrl must end in /: ");
                sb.append(httpUrl);
                throw new IllegalArgumentException(sb.toString());
            }
            this.getAuthRequestContext = httpUrl;
            return this;
        }

        public final Retrofit BuiltInFictitiousFunctionClassFactory() {
            if (this.getAuthRequestContext == null) {
                throw new IllegalStateException("Base URL required.");
            }
            Call.Factory factory = this.MyBillsEntityDataFactory;
            if (factory == null) {
                factory = new OkHttpClient();
            }
            Call.Factory factory2 = factory;
            Executor executor = this.KClassImpl$Data$declaredNonStaticMembers$2;
            if (executor == null) {
                executor = this.lookAheadTest.getAuthRequestContext();
            }
            Executor executor2 = executor;
            ArrayList arrayList = new ArrayList(this.PlaceComponentResult);
            arrayList.addAll(this.lookAheadTest.getAuthRequestContext(executor2));
            ArrayList arrayList2 = new ArrayList(this.BuiltInFictitiousFunctionClassFactory.size() + 1 + (this.lookAheadTest.BuiltInFictitiousFunctionClassFactory ? 1 : 0));
            arrayList2.add(new BuiltInConverters());
            arrayList2.addAll(this.BuiltInFictitiousFunctionClassFactory);
            arrayList2.addAll(this.lookAheadTest.BuiltInFictitiousFunctionClassFactory ? Collections.singletonList(OptionalConverterFactory.getAuthRequestContext) : Collections.emptyList());
            return new Retrofit(factory2, this.getAuthRequestContext, Collections.unmodifiableList(arrayList2), Collections.unmodifiableList(arrayList), executor2, this.getErrorConfigVersion);
        }
    }
}
