package retrofit2;

import com.google.common.net.HttpHeaders;
import com.google.firebase.perf.FirebasePerformance;
import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.reflect.Array;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.net.URI;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.annotation.Nullable;
import kotlin.coroutines.Continuation;
import okhttp3.Headers;
import okhttp3.HttpUrl;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import retrofit2.ParameterHandler;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.Field;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.HEAD;
import retrofit2.http.HTTP;
import retrofit2.http.Header;
import retrofit2.http.HeaderMap;
import retrofit2.http.Multipart;
import retrofit2.http.OPTIONS;
import retrofit2.http.PATCH;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Part;
import retrofit2.http.PartMap;
import retrofit2.http.Path;
import retrofit2.http.Query;
import retrofit2.http.QueryMap;
import retrofit2.http.QueryName;
import retrofit2.http.Tag;
import retrofit2.http.Url;

/* loaded from: classes6.dex */
public final class RequestFactory {
    @Nullable
    final Headers BuiltInFictitiousFunctionClassFactory;
    @Nullable
    final MediaType KClassImpl$Data$declaredNonStaticMembers$2;
    final HttpUrl MyBillsEntityDataFactory;
    final boolean NetworkUserEntityData$$ExternalSyntheticLambda0;
    final String PlaceComponentResult;
    final boolean getAuthRequestContext;
    final boolean getErrorConfigVersion;
    @Nullable
    final String initRecordTimeStamp;
    final boolean lookAheadTest;
    final ParameterHandler<?>[] moveToNextValue;
    final Method scheduleImpl;

    public static RequestFactory KClassImpl$Data$declaredNonStaticMembers$2(Retrofit retrofit, Method method) {
        Builder builder = new Builder(retrofit, method);
        for (Annotation annotation : builder.newProxyInstance) {
            if (annotation instanceof DELETE) {
                builder.KClassImpl$Data$declaredNonStaticMembers$2("DELETE", ((DELETE) annotation).value(), false);
            } else if (annotation instanceof GET) {
                builder.KClassImpl$Data$declaredNonStaticMembers$2("GET", ((GET) annotation).value(), false);
            } else if (annotation instanceof HEAD) {
                builder.KClassImpl$Data$declaredNonStaticMembers$2(FirebasePerformance.HttpMethod.HEAD, ((HEAD) annotation).value(), false);
            } else if (annotation instanceof PATCH) {
                builder.KClassImpl$Data$declaredNonStaticMembers$2(FirebasePerformance.HttpMethod.PATCH, ((PATCH) annotation).value(), true);
            } else if (annotation instanceof POST) {
                builder.KClassImpl$Data$declaredNonStaticMembers$2("POST", ((POST) annotation).value(), true);
            } else if (annotation instanceof PUT) {
                builder.KClassImpl$Data$declaredNonStaticMembers$2(FirebasePerformance.HttpMethod.PUT, ((PUT) annotation).value(), true);
            } else if (annotation instanceof OPTIONS) {
                builder.KClassImpl$Data$declaredNonStaticMembers$2(FirebasePerformance.HttpMethod.OPTIONS, ((OPTIONS) annotation).value(), false);
            } else if (annotation instanceof HTTP) {
                HTTP http = (HTTP) annotation;
                builder.KClassImpl$Data$declaredNonStaticMembers$2(http.method(), http.path(), http.hasBody());
            } else if (annotation instanceof retrofit2.http.Headers) {
                String[] value = ((retrofit2.http.Headers) annotation).value();
                if (value.length == 0) {
                    throw Utils.BuiltInFictitiousFunctionClassFactory(builder.isLayoutRequested, "@Headers annotation is empty.", new Object[0]);
                }
                builder.GetContactSyncConfig = builder.getAuthRequestContext(value);
            } else if (annotation instanceof Multipart) {
                if (builder.NetworkUserEntityData$$ExternalSyntheticLambda2) {
                    throw Utils.BuiltInFictitiousFunctionClassFactory(builder.isLayoutRequested, "Only one encoding annotation is allowed.", new Object[0]);
                }
                builder.NetworkUserEntityData$$ExternalSyntheticLambda1 = true;
            } else if (!(annotation instanceof FormUrlEncoded)) {
                continue;
            } else if (builder.NetworkUserEntityData$$ExternalSyntheticLambda1) {
                throw Utils.BuiltInFictitiousFunctionClassFactory(builder.isLayoutRequested, "Only one encoding annotation is allowed.", new Object[0]);
            } else {
                builder.NetworkUserEntityData$$ExternalSyntheticLambda2 = true;
            }
        }
        if (builder.DatabaseTableConfigUtil == null) {
            throw Utils.BuiltInFictitiousFunctionClassFactory(builder.isLayoutRequested, "HTTP method annotation is required (e.g., @GET, @POST, etc.).", new Object[0]);
        }
        if (!builder.scheduleImpl) {
            if (builder.NetworkUserEntityData$$ExternalSyntheticLambda1) {
                throw Utils.BuiltInFictitiousFunctionClassFactory(builder.isLayoutRequested, "Multipart can only be specified on HTTP methods with request body (e.g., @POST).", new Object[0]);
            }
            if (builder.NetworkUserEntityData$$ExternalSyntheticLambda2) {
                throw Utils.BuiltInFictitiousFunctionClassFactory(builder.isLayoutRequested, "FormUrlEncoded can only be specified on HTTP methods with request body (e.g., @POST).", new Object[0]);
            }
        }
        int length = builder.NetworkUserEntityData$$ExternalSyntheticLambda8.length;
        builder.NetworkUserEntityData$$ExternalSyntheticLambda7 = new ParameterHandler[length];
        int i = 0;
        while (i < length) {
            builder.NetworkUserEntityData$$ExternalSyntheticLambda7[i] = builder.PlaceComponentResult(i, builder.PrepareContext[i], builder.NetworkUserEntityData$$ExternalSyntheticLambda8[i], i == length + (-1));
            i++;
        }
        if (builder.NetworkUserEntityData$$ExternalSyntheticLambda4 != null || builder.NetworkUserEntityData$$ExternalSyntheticLambda0) {
            boolean z = builder.NetworkUserEntityData$$ExternalSyntheticLambda2;
            if (!z && !builder.NetworkUserEntityData$$ExternalSyntheticLambda1 && !builder.scheduleImpl && builder.KClassImpl$Data$declaredNonStaticMembers$2) {
                throw Utils.BuiltInFictitiousFunctionClassFactory(builder.isLayoutRequested, "Non-body HTTP method cannot contain @Body.", new Object[0]);
            }
            if (z && !builder.PlaceComponentResult) {
                throw Utils.BuiltInFictitiousFunctionClassFactory(builder.isLayoutRequested, "Form-encoded method must contain at least one @Field.", new Object[0]);
            }
            if (builder.NetworkUserEntityData$$ExternalSyntheticLambda1 && !builder.BuiltInFictitiousFunctionClassFactory) {
                throw Utils.BuiltInFictitiousFunctionClassFactory(builder.isLayoutRequested, "Multipart method must contain at least one @Part.", new Object[0]);
            }
            return new RequestFactory(builder);
        }
        throw Utils.BuiltInFictitiousFunctionClassFactory(builder.isLayoutRequested, "Missing either @%s URL or @Url parameter.", builder.DatabaseTableConfigUtil);
    }

    private RequestFactory(Builder builder) {
        this.scheduleImpl = builder.isLayoutRequested;
        this.MyBillsEntityDataFactory = builder.FragmentBottomSheetPaymentSettingBinding.getAuthRequestContext;
        this.PlaceComponentResult = builder.DatabaseTableConfigUtil;
        this.initRecordTimeStamp = builder.NetworkUserEntityData$$ExternalSyntheticLambda4;
        this.BuiltInFictitiousFunctionClassFactory = builder.GetContactSyncConfig;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = builder.MyBillsEntityDataFactory;
        this.getAuthRequestContext = builder.scheduleImpl;
        this.lookAheadTest = builder.NetworkUserEntityData$$ExternalSyntheticLambda2;
        this.getErrorConfigVersion = builder.NetworkUserEntityData$$ExternalSyntheticLambda1;
        this.moveToNextValue = builder.NetworkUserEntityData$$ExternalSyntheticLambda7;
        this.NetworkUserEntityData$$ExternalSyntheticLambda0 = builder.initRecordTimeStamp;
    }

    /* loaded from: classes6.dex */
    public static final class Builder {
        private static final Pattern NetworkUserEntityData$$ExternalSyntheticLambda3 = Pattern.compile("\\{([a-zA-Z][a-zA-Z0-9_-]*)\\}");
        private static final Pattern NetworkUserEntityData$$ExternalSyntheticLambda6 = Pattern.compile("[a-zA-Z][a-zA-Z0-9_-]*");
        boolean BuiltInFictitiousFunctionClassFactory;
        @Nullable
        String DatabaseTableConfigUtil;
        final Retrofit FragmentBottomSheetPaymentSettingBinding;
        @Nullable
        Headers GetContactSyncConfig;
        boolean KClassImpl$Data$declaredNonStaticMembers$2;
        @Nullable
        MediaType MyBillsEntityDataFactory;
        boolean NetworkUserEntityData$$ExternalSyntheticLambda0;
        boolean NetworkUserEntityData$$ExternalSyntheticLambda1;
        boolean NetworkUserEntityData$$ExternalSyntheticLambda2;
        @Nullable
        String NetworkUserEntityData$$ExternalSyntheticLambda4;
        @Nullable
        Set<String> NetworkUserEntityData$$ExternalSyntheticLambda5;
        @Nullable
        ParameterHandler<?>[] NetworkUserEntityData$$ExternalSyntheticLambda7;
        final Annotation[][] NetworkUserEntityData$$ExternalSyntheticLambda8;
        boolean PlaceComponentResult;
        final Type[] PrepareContext;
        boolean getAuthRequestContext;
        boolean getErrorConfigVersion;
        boolean initRecordTimeStamp;
        final Method isLayoutRequested;
        boolean lookAheadTest;
        boolean moveToNextValue;
        final Annotation[] newProxyInstance;
        boolean scheduleImpl;

        Builder(Retrofit retrofit, Method method) {
            this.FragmentBottomSheetPaymentSettingBinding = retrofit;
            this.isLayoutRequested = method;
            this.newProxyInstance = method.getAnnotations();
            this.PrepareContext = method.getGenericParameterTypes();
            this.NetworkUserEntityData$$ExternalSyntheticLambda8 = method.getParameterAnnotations();
        }

        final void KClassImpl$Data$declaredNonStaticMembers$2(String str, String str2, boolean z) {
            String str3 = this.DatabaseTableConfigUtil;
            if (str3 != null) {
                throw Utils.BuiltInFictitiousFunctionClassFactory(this.isLayoutRequested, "Only one HTTP method is allowed. Found: %s and %s.", str3, str);
            }
            this.DatabaseTableConfigUtil = str;
            this.scheduleImpl = z;
            if (str2.isEmpty()) {
                return;
            }
            int indexOf = str2.indexOf(63);
            if (indexOf != -1 && indexOf < str2.length() - 1) {
                String substring = str2.substring(indexOf + 1);
                if (NetworkUserEntityData$$ExternalSyntheticLambda3.matcher(substring).find()) {
                    throw Utils.BuiltInFictitiousFunctionClassFactory(this.isLayoutRequested, "URL query string \"%s\" must not have replace block. For dynamic query parameters use @Query.", substring);
                }
            }
            this.NetworkUserEntityData$$ExternalSyntheticLambda4 = str2;
            this.NetworkUserEntityData$$ExternalSyntheticLambda5 = KClassImpl$Data$declaredNonStaticMembers$2(str2);
        }

        final Headers getAuthRequestContext(String[] strArr) {
            Headers.Builder builder = new Headers.Builder();
            for (String str : strArr) {
                int indexOf = str.indexOf(58);
                if (indexOf == -1 || indexOf == 0 || indexOf == str.length() - 1) {
                    throw Utils.BuiltInFictitiousFunctionClassFactory(this.isLayoutRequested, "@Headers value must be in the form \"Name: Value\". Found: \"%s\"", str);
                }
                String substring = str.substring(0, indexOf);
                String trim = str.substring(indexOf + 1).trim();
                if ("Content-Type".equalsIgnoreCase(substring)) {
                    try {
                        this.MyBillsEntityDataFactory = MediaType.get(trim);
                    } catch (IllegalArgumentException e) {
                        throw Utils.PlaceComponentResult(this.isLayoutRequested, e, "Malformed content type: %s", trim);
                    }
                } else {
                    builder.add(substring, trim);
                }
            }
            return builder.build();
        }

        @Nullable
        final ParameterHandler<?> PlaceComponentResult(int i, Type type, @Nullable Annotation[] annotationArr, boolean z) {
            ParameterHandler<?> parameterHandler;
            if (annotationArr != null) {
                parameterHandler = null;
                for (Annotation annotation : annotationArr) {
                    ParameterHandler<?> BuiltInFictitiousFunctionClassFactory = BuiltInFictitiousFunctionClassFactory(i, type, annotationArr, annotation);
                    if (BuiltInFictitiousFunctionClassFactory != null) {
                        if (parameterHandler != null) {
                            throw Utils.BuiltInFictitiousFunctionClassFactory(this.isLayoutRequested, i, "Multiple Retrofit annotations found, only one allowed.", new Object[0]);
                        }
                        parameterHandler = BuiltInFictitiousFunctionClassFactory;
                    }
                }
            } else {
                parameterHandler = null;
            }
            if (parameterHandler == null) {
                if (z) {
                    try {
                        if (Utils.BuiltInFictitiousFunctionClassFactory(type) == Continuation.class) {
                            this.initRecordTimeStamp = true;
                            return null;
                        }
                    } catch (NoClassDefFoundError unused) {
                    }
                }
                throw Utils.BuiltInFictitiousFunctionClassFactory(this.isLayoutRequested, i, "No Retrofit annotation found.", new Object[0]);
            }
            return parameterHandler;
        }

        @Nullable
        private ParameterHandler<?> BuiltInFictitiousFunctionClassFactory(int i, Type type, Annotation[] annotationArr, Annotation annotation) {
            if (annotation instanceof Url) {
                BuiltInFictitiousFunctionClassFactory(i, type);
                if (this.NetworkUserEntityData$$ExternalSyntheticLambda0) {
                    throw Utils.BuiltInFictitiousFunctionClassFactory(this.isLayoutRequested, i, "Multiple @Url method annotations found.", new Object[0]);
                }
                if (this.getAuthRequestContext) {
                    throw Utils.BuiltInFictitiousFunctionClassFactory(this.isLayoutRequested, i, "@Path parameters may not be used with @Url.", new Object[0]);
                }
                if (this.moveToNextValue) {
                    throw Utils.BuiltInFictitiousFunctionClassFactory(this.isLayoutRequested, i, "A @Url parameter must not come after a @Query.", new Object[0]);
                }
                if (this.getErrorConfigVersion) {
                    throw Utils.BuiltInFictitiousFunctionClassFactory(this.isLayoutRequested, i, "A @Url parameter must not come after a @QueryName.", new Object[0]);
                }
                if (this.lookAheadTest) {
                    throw Utils.BuiltInFictitiousFunctionClassFactory(this.isLayoutRequested, i, "A @Url parameter must not come after a @QueryMap.", new Object[0]);
                }
                if (this.NetworkUserEntityData$$ExternalSyntheticLambda4 == null) {
                    this.NetworkUserEntityData$$ExternalSyntheticLambda0 = true;
                    if (type == HttpUrl.class || type == String.class || type == URI.class || ((type instanceof Class) && "android.net.Uri".equals(((Class) type).getName()))) {
                        return new ParameterHandler.RelativeUrl(this.isLayoutRequested, i);
                    }
                    throw Utils.BuiltInFictitiousFunctionClassFactory(this.isLayoutRequested, i, "@Url must be okhttp3.HttpUrl, String, java.net.URI, or android.net.Uri type.", new Object[0]);
                }
                throw Utils.BuiltInFictitiousFunctionClassFactory(this.isLayoutRequested, i, "@Url cannot be used with @%s URL", this.DatabaseTableConfigUtil);
            } else if (annotation instanceof Path) {
                BuiltInFictitiousFunctionClassFactory(i, type);
                if (this.moveToNextValue) {
                    throw Utils.BuiltInFictitiousFunctionClassFactory(this.isLayoutRequested, i, "A @Path parameter must not come after a @Query.", new Object[0]);
                }
                if (this.getErrorConfigVersion) {
                    throw Utils.BuiltInFictitiousFunctionClassFactory(this.isLayoutRequested, i, "A @Path parameter must not come after a @QueryName.", new Object[0]);
                }
                if (this.lookAheadTest) {
                    throw Utils.BuiltInFictitiousFunctionClassFactory(this.isLayoutRequested, i, "A @Path parameter must not come after a @QueryMap.", new Object[0]);
                }
                if (this.NetworkUserEntityData$$ExternalSyntheticLambda0) {
                    throw Utils.BuiltInFictitiousFunctionClassFactory(this.isLayoutRequested, i, "@Path parameters may not be used with @Url.", new Object[0]);
                }
                if (this.NetworkUserEntityData$$ExternalSyntheticLambda4 != null) {
                    this.getAuthRequestContext = true;
                    Path path = (Path) annotation;
                    String value = path.value();
                    if (!NetworkUserEntityData$$ExternalSyntheticLambda6.matcher(value).matches()) {
                        throw Utils.BuiltInFictitiousFunctionClassFactory(this.isLayoutRequested, i, "@Path parameter name must match %s. Found: %s", NetworkUserEntityData$$ExternalSyntheticLambda3.pattern(), value);
                    }
                    if (this.NetworkUserEntityData$$ExternalSyntheticLambda5.contains(value)) {
                        return new ParameterHandler.Path(this.isLayoutRequested, i, value, this.FragmentBottomSheetPaymentSettingBinding.getAuthRequestContext(type, annotationArr), path.encoded());
                    }
                    throw Utils.BuiltInFictitiousFunctionClassFactory(this.isLayoutRequested, i, "URL \"%s\" does not contain \"{%s}\".", this.NetworkUserEntityData$$ExternalSyntheticLambda4, value);
                }
                throw Utils.BuiltInFictitiousFunctionClassFactory(this.isLayoutRequested, i, "@Path can only be used with relative url on @%s", this.DatabaseTableConfigUtil);
            } else if (annotation instanceof Query) {
                BuiltInFictitiousFunctionClassFactory(i, type);
                Query query = (Query) annotation;
                String value2 = query.value();
                boolean encoded = query.encoded();
                Class<?> BuiltInFictitiousFunctionClassFactory = Utils.BuiltInFictitiousFunctionClassFactory(type);
                this.moveToNextValue = true;
                if (Iterable.class.isAssignableFrom(BuiltInFictitiousFunctionClassFactory)) {
                    if (!(type instanceof ParameterizedType)) {
                        Method method = this.isLayoutRequested;
                        StringBuilder sb = new StringBuilder();
                        sb.append(BuiltInFictitiousFunctionClassFactory.getSimpleName());
                        sb.append(" must include generic type (e.g., ");
                        sb.append(BuiltInFictitiousFunctionClassFactory.getSimpleName());
                        sb.append("<String>)");
                        throw Utils.BuiltInFictitiousFunctionClassFactory(method, i, sb.toString(), new Object[0]);
                    }
                    final ParameterHandler.Query query2 = new ParameterHandler.Query(value2, this.FragmentBottomSheetPaymentSettingBinding.getAuthRequestContext(Utils.MyBillsEntityDataFactory(0, (ParameterizedType) type), annotationArr), encoded);
                    return new ParameterHandler<Iterable<T>>() { // from class: retrofit2.ParameterHandler.1
                        /* JADX INFO: Access modifiers changed from: package-private */
                        @Override // retrofit2.ParameterHandler
                        public final /* synthetic */ void MyBillsEntityDataFactory(RequestBuilder requestBuilder, @Nullable Object obj) throws IOException {
                            Iterable iterable = (Iterable) obj;
                            if (iterable != null) {
                                Iterator<T> it = iterable.iterator();
                                while (it.hasNext()) {
                                    query2.MyBillsEntityDataFactory(requestBuilder, it.next());
                                }
                            }
                        }
                    };
                } else if (BuiltInFictitiousFunctionClassFactory.isArray()) {
                    final ParameterHandler.Query query3 = new ParameterHandler.Query(value2, this.FragmentBottomSheetPaymentSettingBinding.getAuthRequestContext(MyBillsEntityDataFactory(BuiltInFictitiousFunctionClassFactory.getComponentType()), annotationArr), encoded);
                    return new ParameterHandler<Object>() { // from class: retrofit2.ParameterHandler.2
                        /* JADX INFO: Access modifiers changed from: package-private */
                        /* JADX WARN: Multi-variable type inference failed */
                        @Override // retrofit2.ParameterHandler
                        public final void MyBillsEntityDataFactory(RequestBuilder requestBuilder, @Nullable Object obj) throws IOException {
                            if (obj == null) {
                                return;
                            }
                            int length = Array.getLength(obj);
                            for (int i2 = 0; i2 < length; i2++) {
                                query3.MyBillsEntityDataFactory(requestBuilder, Array.get(obj, i2));
                            }
                        }
                    };
                } else {
                    return new ParameterHandler.Query(value2, this.FragmentBottomSheetPaymentSettingBinding.getAuthRequestContext(type, annotationArr), encoded);
                }
            } else if (annotation instanceof QueryName) {
                BuiltInFictitiousFunctionClassFactory(i, type);
                boolean encoded2 = ((QueryName) annotation).encoded();
                Class<?> BuiltInFictitiousFunctionClassFactory2 = Utils.BuiltInFictitiousFunctionClassFactory(type);
                this.getErrorConfigVersion = true;
                if (Iterable.class.isAssignableFrom(BuiltInFictitiousFunctionClassFactory2)) {
                    if (!(type instanceof ParameterizedType)) {
                        Method method2 = this.isLayoutRequested;
                        StringBuilder sb2 = new StringBuilder();
                        sb2.append(BuiltInFictitiousFunctionClassFactory2.getSimpleName());
                        sb2.append(" must include generic type (e.g., ");
                        sb2.append(BuiltInFictitiousFunctionClassFactory2.getSimpleName());
                        sb2.append("<String>)");
                        throw Utils.BuiltInFictitiousFunctionClassFactory(method2, i, sb2.toString(), new Object[0]);
                    }
                    final ParameterHandler.QueryName queryName = new ParameterHandler.QueryName(this.FragmentBottomSheetPaymentSettingBinding.getAuthRequestContext(Utils.MyBillsEntityDataFactory(0, (ParameterizedType) type), annotationArr), encoded2);
                    return new ParameterHandler<Iterable<T>>() { // from class: retrofit2.ParameterHandler.1
                        /* JADX INFO: Access modifiers changed from: package-private */
                        @Override // retrofit2.ParameterHandler
                        public final /* synthetic */ void MyBillsEntityDataFactory(RequestBuilder requestBuilder, @Nullable Object obj) throws IOException {
                            Iterable iterable = (Iterable) obj;
                            if (iterable != null) {
                                Iterator<T> it = iterable.iterator();
                                while (it.hasNext()) {
                                    queryName.MyBillsEntityDataFactory(requestBuilder, it.next());
                                }
                            }
                        }
                    };
                } else if (BuiltInFictitiousFunctionClassFactory2.isArray()) {
                    final ParameterHandler.QueryName queryName2 = new ParameterHandler.QueryName(this.FragmentBottomSheetPaymentSettingBinding.getAuthRequestContext(MyBillsEntityDataFactory(BuiltInFictitiousFunctionClassFactory2.getComponentType()), annotationArr), encoded2);
                    return new ParameterHandler<Object>() { // from class: retrofit2.ParameterHandler.2
                        /* JADX INFO: Access modifiers changed from: package-private */
                        /* JADX WARN: Multi-variable type inference failed */
                        @Override // retrofit2.ParameterHandler
                        public final void MyBillsEntityDataFactory(RequestBuilder requestBuilder, @Nullable Object obj) throws IOException {
                            if (obj == null) {
                                return;
                            }
                            int length = Array.getLength(obj);
                            for (int i2 = 0; i2 < length; i2++) {
                                queryName2.MyBillsEntityDataFactory(requestBuilder, Array.get(obj, i2));
                            }
                        }
                    };
                } else {
                    return new ParameterHandler.QueryName(this.FragmentBottomSheetPaymentSettingBinding.getAuthRequestContext(type, annotationArr), encoded2);
                }
            } else if (annotation instanceof QueryMap) {
                BuiltInFictitiousFunctionClassFactory(i, type);
                Class<?> BuiltInFictitiousFunctionClassFactory3 = Utils.BuiltInFictitiousFunctionClassFactory(type);
                this.lookAheadTest = true;
                if (!Map.class.isAssignableFrom(BuiltInFictitiousFunctionClassFactory3)) {
                    throw Utils.BuiltInFictitiousFunctionClassFactory(this.isLayoutRequested, i, "@QueryMap parameter type must be Map.", new Object[0]);
                }
                Type authRequestContext = Utils.getAuthRequestContext(type, BuiltInFictitiousFunctionClassFactory3, (Class<?>) Map.class);
                if (!(authRequestContext instanceof ParameterizedType)) {
                    throw Utils.BuiltInFictitiousFunctionClassFactory(this.isLayoutRequested, i, "Map must include generic types (e.g., Map<String, String>)", new Object[0]);
                }
                ParameterizedType parameterizedType = (ParameterizedType) authRequestContext;
                Type MyBillsEntityDataFactory = Utils.MyBillsEntityDataFactory(0, parameterizedType);
                if (String.class != MyBillsEntityDataFactory) {
                    Method method3 = this.isLayoutRequested;
                    StringBuilder sb3 = new StringBuilder();
                    sb3.append("@QueryMap keys must be of type String: ");
                    sb3.append(MyBillsEntityDataFactory);
                    throw Utils.BuiltInFictitiousFunctionClassFactory(method3, i, sb3.toString(), new Object[0]);
                }
                return new ParameterHandler.QueryMap(this.isLayoutRequested, i, this.FragmentBottomSheetPaymentSettingBinding.getAuthRequestContext(Utils.MyBillsEntityDataFactory(1, parameterizedType), annotationArr), ((QueryMap) annotation).encoded());
            } else if (annotation instanceof Header) {
                BuiltInFictitiousFunctionClassFactory(i, type);
                String value3 = ((Header) annotation).value();
                Class<?> BuiltInFictitiousFunctionClassFactory4 = Utils.BuiltInFictitiousFunctionClassFactory(type);
                if (Iterable.class.isAssignableFrom(BuiltInFictitiousFunctionClassFactory4)) {
                    if (!(type instanceof ParameterizedType)) {
                        Method method4 = this.isLayoutRequested;
                        StringBuilder sb4 = new StringBuilder();
                        sb4.append(BuiltInFictitiousFunctionClassFactory4.getSimpleName());
                        sb4.append(" must include generic type (e.g., ");
                        sb4.append(BuiltInFictitiousFunctionClassFactory4.getSimpleName());
                        sb4.append("<String>)");
                        throw Utils.BuiltInFictitiousFunctionClassFactory(method4, i, sb4.toString(), new Object[0]);
                    }
                    final ParameterHandler.Header header = new ParameterHandler.Header(value3, this.FragmentBottomSheetPaymentSettingBinding.getAuthRequestContext(Utils.MyBillsEntityDataFactory(0, (ParameterizedType) type), annotationArr));
                    return new ParameterHandler<Iterable<T>>() { // from class: retrofit2.ParameterHandler.1
                        /* JADX INFO: Access modifiers changed from: package-private */
                        @Override // retrofit2.ParameterHandler
                        public final /* synthetic */ void MyBillsEntityDataFactory(RequestBuilder requestBuilder, @Nullable Object obj) throws IOException {
                            Iterable iterable = (Iterable) obj;
                            if (iterable != null) {
                                Iterator<T> it = iterable.iterator();
                                while (it.hasNext()) {
                                    header.MyBillsEntityDataFactory(requestBuilder, it.next());
                                }
                            }
                        }
                    };
                } else if (BuiltInFictitiousFunctionClassFactory4.isArray()) {
                    final ParameterHandler.Header header2 = new ParameterHandler.Header(value3, this.FragmentBottomSheetPaymentSettingBinding.getAuthRequestContext(MyBillsEntityDataFactory(BuiltInFictitiousFunctionClassFactory4.getComponentType()), annotationArr));
                    return new ParameterHandler<Object>() { // from class: retrofit2.ParameterHandler.2
                        /* JADX INFO: Access modifiers changed from: package-private */
                        /* JADX WARN: Multi-variable type inference failed */
                        @Override // retrofit2.ParameterHandler
                        public final void MyBillsEntityDataFactory(RequestBuilder requestBuilder, @Nullable Object obj) throws IOException {
                            if (obj == null) {
                                return;
                            }
                            int length = Array.getLength(obj);
                            for (int i2 = 0; i2 < length; i2++) {
                                header2.MyBillsEntityDataFactory(requestBuilder, Array.get(obj, i2));
                            }
                        }
                    };
                } else {
                    return new ParameterHandler.Header(value3, this.FragmentBottomSheetPaymentSettingBinding.getAuthRequestContext(type, annotationArr));
                }
            } else if (annotation instanceof HeaderMap) {
                if (type == Headers.class) {
                    return new ParameterHandler.Headers(this.isLayoutRequested, i);
                }
                BuiltInFictitiousFunctionClassFactory(i, type);
                Class<?> BuiltInFictitiousFunctionClassFactory5 = Utils.BuiltInFictitiousFunctionClassFactory(type);
                if (!Map.class.isAssignableFrom(BuiltInFictitiousFunctionClassFactory5)) {
                    throw Utils.BuiltInFictitiousFunctionClassFactory(this.isLayoutRequested, i, "@HeaderMap parameter type must be Map.", new Object[0]);
                }
                Type authRequestContext2 = Utils.getAuthRequestContext(type, BuiltInFictitiousFunctionClassFactory5, (Class<?>) Map.class);
                if (!(authRequestContext2 instanceof ParameterizedType)) {
                    throw Utils.BuiltInFictitiousFunctionClassFactory(this.isLayoutRequested, i, "Map must include generic types (e.g., Map<String, String>)", new Object[0]);
                }
                ParameterizedType parameterizedType2 = (ParameterizedType) authRequestContext2;
                Type MyBillsEntityDataFactory2 = Utils.MyBillsEntityDataFactory(0, parameterizedType2);
                if (String.class != MyBillsEntityDataFactory2) {
                    Method method5 = this.isLayoutRequested;
                    StringBuilder sb5 = new StringBuilder();
                    sb5.append("@HeaderMap keys must be of type String: ");
                    sb5.append(MyBillsEntityDataFactory2);
                    throw Utils.BuiltInFictitiousFunctionClassFactory(method5, i, sb5.toString(), new Object[0]);
                }
                return new ParameterHandler.HeaderMap(this.isLayoutRequested, i, this.FragmentBottomSheetPaymentSettingBinding.getAuthRequestContext(Utils.MyBillsEntityDataFactory(1, parameterizedType2), annotationArr));
            } else if (annotation instanceof Field) {
                BuiltInFictitiousFunctionClassFactory(i, type);
                if (!this.NetworkUserEntityData$$ExternalSyntheticLambda2) {
                    throw Utils.BuiltInFictitiousFunctionClassFactory(this.isLayoutRequested, i, "@Field parameters can only be used with form encoding.", new Object[0]);
                }
                Field field = (Field) annotation;
                String value4 = field.value();
                boolean encoded3 = field.encoded();
                this.PlaceComponentResult = true;
                Class<?> BuiltInFictitiousFunctionClassFactory6 = Utils.BuiltInFictitiousFunctionClassFactory(type);
                if (Iterable.class.isAssignableFrom(BuiltInFictitiousFunctionClassFactory6)) {
                    if (!(type instanceof ParameterizedType)) {
                        Method method6 = this.isLayoutRequested;
                        StringBuilder sb6 = new StringBuilder();
                        sb6.append(BuiltInFictitiousFunctionClassFactory6.getSimpleName());
                        sb6.append(" must include generic type (e.g., ");
                        sb6.append(BuiltInFictitiousFunctionClassFactory6.getSimpleName());
                        sb6.append("<String>)");
                        throw Utils.BuiltInFictitiousFunctionClassFactory(method6, i, sb6.toString(), new Object[0]);
                    }
                    final ParameterHandler.Field field2 = new ParameterHandler.Field(value4, this.FragmentBottomSheetPaymentSettingBinding.getAuthRequestContext(Utils.MyBillsEntityDataFactory(0, (ParameterizedType) type), annotationArr), encoded3);
                    return new ParameterHandler<Iterable<T>>() { // from class: retrofit2.ParameterHandler.1
                        /* JADX INFO: Access modifiers changed from: package-private */
                        @Override // retrofit2.ParameterHandler
                        public final /* synthetic */ void MyBillsEntityDataFactory(RequestBuilder requestBuilder, @Nullable Object obj) throws IOException {
                            Iterable iterable = (Iterable) obj;
                            if (iterable != null) {
                                Iterator<T> it = iterable.iterator();
                                while (it.hasNext()) {
                                    field2.MyBillsEntityDataFactory(requestBuilder, it.next());
                                }
                            }
                        }
                    };
                } else if (BuiltInFictitiousFunctionClassFactory6.isArray()) {
                    final ParameterHandler.Field field3 = new ParameterHandler.Field(value4, this.FragmentBottomSheetPaymentSettingBinding.getAuthRequestContext(MyBillsEntityDataFactory(BuiltInFictitiousFunctionClassFactory6.getComponentType()), annotationArr), encoded3);
                    return new ParameterHandler<Object>() { // from class: retrofit2.ParameterHandler.2
                        /* JADX INFO: Access modifiers changed from: package-private */
                        /* JADX WARN: Multi-variable type inference failed */
                        @Override // retrofit2.ParameterHandler
                        public final void MyBillsEntityDataFactory(RequestBuilder requestBuilder, @Nullable Object obj) throws IOException {
                            if (obj == null) {
                                return;
                            }
                            int length = Array.getLength(obj);
                            for (int i2 = 0; i2 < length; i2++) {
                                field3.MyBillsEntityDataFactory(requestBuilder, Array.get(obj, i2));
                            }
                        }
                    };
                } else {
                    return new ParameterHandler.Field(value4, this.FragmentBottomSheetPaymentSettingBinding.getAuthRequestContext(type, annotationArr), encoded3);
                }
            } else if (annotation instanceof FieldMap) {
                BuiltInFictitiousFunctionClassFactory(i, type);
                if (!this.NetworkUserEntityData$$ExternalSyntheticLambda2) {
                    throw Utils.BuiltInFictitiousFunctionClassFactory(this.isLayoutRequested, i, "@FieldMap parameters can only be used with form encoding.", new Object[0]);
                }
                Class<?> BuiltInFictitiousFunctionClassFactory7 = Utils.BuiltInFictitiousFunctionClassFactory(type);
                if (!Map.class.isAssignableFrom(BuiltInFictitiousFunctionClassFactory7)) {
                    throw Utils.BuiltInFictitiousFunctionClassFactory(this.isLayoutRequested, i, "@FieldMap parameter type must be Map.", new Object[0]);
                }
                Type authRequestContext3 = Utils.getAuthRequestContext(type, BuiltInFictitiousFunctionClassFactory7, (Class<?>) Map.class);
                if (!(authRequestContext3 instanceof ParameterizedType)) {
                    throw Utils.BuiltInFictitiousFunctionClassFactory(this.isLayoutRequested, i, "Map must include generic types (e.g., Map<String, String>)", new Object[0]);
                }
                ParameterizedType parameterizedType3 = (ParameterizedType) authRequestContext3;
                Type MyBillsEntityDataFactory3 = Utils.MyBillsEntityDataFactory(0, parameterizedType3);
                if (String.class != MyBillsEntityDataFactory3) {
                    Method method7 = this.isLayoutRequested;
                    StringBuilder sb7 = new StringBuilder();
                    sb7.append("@FieldMap keys must be of type String: ");
                    sb7.append(MyBillsEntityDataFactory3);
                    throw Utils.BuiltInFictitiousFunctionClassFactory(method7, i, sb7.toString(), new Object[0]);
                }
                Converter authRequestContext4 = this.FragmentBottomSheetPaymentSettingBinding.getAuthRequestContext(Utils.MyBillsEntityDataFactory(1, parameterizedType3), annotationArr);
                this.PlaceComponentResult = true;
                return new ParameterHandler.FieldMap(this.isLayoutRequested, i, authRequestContext4, ((FieldMap) annotation).encoded());
            } else if (annotation instanceof Part) {
                BuiltInFictitiousFunctionClassFactory(i, type);
                if (!this.NetworkUserEntityData$$ExternalSyntheticLambda1) {
                    throw Utils.BuiltInFictitiousFunctionClassFactory(this.isLayoutRequested, i, "@Part parameters can only be used with multipart encoding.", new Object[0]);
                }
                Part part = (Part) annotation;
                this.BuiltInFictitiousFunctionClassFactory = true;
                String value5 = part.value();
                Class<?> BuiltInFictitiousFunctionClassFactory8 = Utils.BuiltInFictitiousFunctionClassFactory(type);
                if (value5.isEmpty()) {
                    if (Iterable.class.isAssignableFrom(BuiltInFictitiousFunctionClassFactory8)) {
                        if (!(type instanceof ParameterizedType)) {
                            Method method8 = this.isLayoutRequested;
                            StringBuilder sb8 = new StringBuilder();
                            sb8.append(BuiltInFictitiousFunctionClassFactory8.getSimpleName());
                            sb8.append(" must include generic type (e.g., ");
                            sb8.append(BuiltInFictitiousFunctionClassFactory8.getSimpleName());
                            sb8.append("<String>)");
                            throw Utils.BuiltInFictitiousFunctionClassFactory(method8, i, sb8.toString(), new Object[0]);
                        } else if (!MultipartBody.Part.class.isAssignableFrom(Utils.BuiltInFictitiousFunctionClassFactory(Utils.MyBillsEntityDataFactory(0, (ParameterizedType) type)))) {
                            throw Utils.BuiltInFictitiousFunctionClassFactory(this.isLayoutRequested, i, "@Part annotation must supply a name or use MultipartBody.Part parameter type.", new Object[0]);
                        } else {
                            final ParameterHandler.RawPart rawPart = ParameterHandler.RawPart.PlaceComponentResult;
                            return new ParameterHandler<Iterable<T>>() { // from class: retrofit2.ParameterHandler.1
                                /* JADX INFO: Access modifiers changed from: package-private */
                                @Override // retrofit2.ParameterHandler
                                public final /* synthetic */ void MyBillsEntityDataFactory(RequestBuilder requestBuilder, @Nullable Object obj) throws IOException {
                                    Iterable iterable = (Iterable) obj;
                                    if (iterable != null) {
                                        Iterator<T> it = iterable.iterator();
                                        while (it.hasNext()) {
                                            rawPart.MyBillsEntityDataFactory(requestBuilder, it.next());
                                        }
                                    }
                                }
                            };
                        }
                    } else if (BuiltInFictitiousFunctionClassFactory8.isArray()) {
                        if (!MultipartBody.Part.class.isAssignableFrom(BuiltInFictitiousFunctionClassFactory8.getComponentType())) {
                            throw Utils.BuiltInFictitiousFunctionClassFactory(this.isLayoutRequested, i, "@Part annotation must supply a name or use MultipartBody.Part parameter type.", new Object[0]);
                        }
                        final ParameterHandler.RawPart rawPart2 = ParameterHandler.RawPart.PlaceComponentResult;
                        return new ParameterHandler<Object>() { // from class: retrofit2.ParameterHandler.2
                            /* JADX INFO: Access modifiers changed from: package-private */
                            /* JADX WARN: Multi-variable type inference failed */
                            @Override // retrofit2.ParameterHandler
                            public final void MyBillsEntityDataFactory(RequestBuilder requestBuilder, @Nullable Object obj) throws IOException {
                                if (obj == null) {
                                    return;
                                }
                                int length = Array.getLength(obj);
                                for (int i2 = 0; i2 < length; i2++) {
                                    rawPart2.MyBillsEntityDataFactory(requestBuilder, Array.get(obj, i2));
                                }
                            }
                        };
                    } else if (MultipartBody.Part.class.isAssignableFrom(BuiltInFictitiousFunctionClassFactory8)) {
                        return ParameterHandler.RawPart.PlaceComponentResult;
                    } else {
                        throw Utils.BuiltInFictitiousFunctionClassFactory(this.isLayoutRequested, i, "@Part annotation must supply a name or use MultipartBody.Part parameter type.", new Object[0]);
                    }
                }
                StringBuilder sb9 = new StringBuilder();
                sb9.append("form-data; name=\"");
                sb9.append(value5);
                sb9.append("\"");
                Headers of = Headers.of(HttpHeaders.CONTENT_DISPOSITION, sb9.toString(), "Content-Transfer-Encoding", part.encoding());
                if (Iterable.class.isAssignableFrom(BuiltInFictitiousFunctionClassFactory8)) {
                    if (!(type instanceof ParameterizedType)) {
                        Method method9 = this.isLayoutRequested;
                        StringBuilder sb10 = new StringBuilder();
                        sb10.append(BuiltInFictitiousFunctionClassFactory8.getSimpleName());
                        sb10.append(" must include generic type (e.g., ");
                        sb10.append(BuiltInFictitiousFunctionClassFactory8.getSimpleName());
                        sb10.append("<String>)");
                        throw Utils.BuiltInFictitiousFunctionClassFactory(method9, i, sb10.toString(), new Object[0]);
                    }
                    Type MyBillsEntityDataFactory4 = Utils.MyBillsEntityDataFactory(0, (ParameterizedType) type);
                    if (MultipartBody.Part.class.isAssignableFrom(Utils.BuiltInFictitiousFunctionClassFactory(MyBillsEntityDataFactory4))) {
                        throw Utils.BuiltInFictitiousFunctionClassFactory(this.isLayoutRequested, i, "@Part parameters using the MultipartBody.Part must not include a part name in the annotation.", new Object[0]);
                    }
                    final ParameterHandler.Part part2 = new ParameterHandler.Part(this.isLayoutRequested, i, of, this.FragmentBottomSheetPaymentSettingBinding.BuiltInFictitiousFunctionClassFactory(MyBillsEntityDataFactory4, annotationArr, this.newProxyInstance));
                    return new ParameterHandler<Iterable<T>>() { // from class: retrofit2.ParameterHandler.1
                        /* JADX INFO: Access modifiers changed from: package-private */
                        @Override // retrofit2.ParameterHandler
                        public final /* synthetic */ void MyBillsEntityDataFactory(RequestBuilder requestBuilder, @Nullable Object obj) throws IOException {
                            Iterable iterable = (Iterable) obj;
                            if (iterable != null) {
                                Iterator<T> it = iterable.iterator();
                                while (it.hasNext()) {
                                    part2.MyBillsEntityDataFactory(requestBuilder, it.next());
                                }
                            }
                        }
                    };
                } else if (BuiltInFictitiousFunctionClassFactory8.isArray()) {
                    Class<?> MyBillsEntityDataFactory5 = MyBillsEntityDataFactory(BuiltInFictitiousFunctionClassFactory8.getComponentType());
                    if (MultipartBody.Part.class.isAssignableFrom(MyBillsEntityDataFactory5)) {
                        throw Utils.BuiltInFictitiousFunctionClassFactory(this.isLayoutRequested, i, "@Part parameters using the MultipartBody.Part must not include a part name in the annotation.", new Object[0]);
                    }
                    final ParameterHandler.Part part3 = new ParameterHandler.Part(this.isLayoutRequested, i, of, this.FragmentBottomSheetPaymentSettingBinding.BuiltInFictitiousFunctionClassFactory(MyBillsEntityDataFactory5, annotationArr, this.newProxyInstance));
                    return new ParameterHandler<Object>() { // from class: retrofit2.ParameterHandler.2
                        /* JADX INFO: Access modifiers changed from: package-private */
                        /* JADX WARN: Multi-variable type inference failed */
                        @Override // retrofit2.ParameterHandler
                        public final void MyBillsEntityDataFactory(RequestBuilder requestBuilder, @Nullable Object obj) throws IOException {
                            if (obj == null) {
                                return;
                            }
                            int length = Array.getLength(obj);
                            for (int i2 = 0; i2 < length; i2++) {
                                part3.MyBillsEntityDataFactory(requestBuilder, Array.get(obj, i2));
                            }
                        }
                    };
                } else if (MultipartBody.Part.class.isAssignableFrom(BuiltInFictitiousFunctionClassFactory8)) {
                    throw Utils.BuiltInFictitiousFunctionClassFactory(this.isLayoutRequested, i, "@Part parameters using the MultipartBody.Part must not include a part name in the annotation.", new Object[0]);
                } else {
                    return new ParameterHandler.Part(this.isLayoutRequested, i, of, this.FragmentBottomSheetPaymentSettingBinding.BuiltInFictitiousFunctionClassFactory(type, annotationArr, this.newProxyInstance));
                }
            } else if (annotation instanceof PartMap) {
                BuiltInFictitiousFunctionClassFactory(i, type);
                if (!this.NetworkUserEntityData$$ExternalSyntheticLambda1) {
                    throw Utils.BuiltInFictitiousFunctionClassFactory(this.isLayoutRequested, i, "@PartMap parameters can only be used with multipart encoding.", new Object[0]);
                }
                this.BuiltInFictitiousFunctionClassFactory = true;
                Class<?> BuiltInFictitiousFunctionClassFactory9 = Utils.BuiltInFictitiousFunctionClassFactory(type);
                if (!Map.class.isAssignableFrom(BuiltInFictitiousFunctionClassFactory9)) {
                    throw Utils.BuiltInFictitiousFunctionClassFactory(this.isLayoutRequested, i, "@PartMap parameter type must be Map.", new Object[0]);
                }
                Type authRequestContext5 = Utils.getAuthRequestContext(type, BuiltInFictitiousFunctionClassFactory9, (Class<?>) Map.class);
                if (!(authRequestContext5 instanceof ParameterizedType)) {
                    throw Utils.BuiltInFictitiousFunctionClassFactory(this.isLayoutRequested, i, "Map must include generic types (e.g., Map<String, String>)", new Object[0]);
                }
                ParameterizedType parameterizedType4 = (ParameterizedType) authRequestContext5;
                Type MyBillsEntityDataFactory6 = Utils.MyBillsEntityDataFactory(0, parameterizedType4);
                if (String.class != MyBillsEntityDataFactory6) {
                    Method method10 = this.isLayoutRequested;
                    StringBuilder sb11 = new StringBuilder();
                    sb11.append("@PartMap keys must be of type String: ");
                    sb11.append(MyBillsEntityDataFactory6);
                    throw Utils.BuiltInFictitiousFunctionClassFactory(method10, i, sb11.toString(), new Object[0]);
                }
                Type MyBillsEntityDataFactory7 = Utils.MyBillsEntityDataFactory(1, parameterizedType4);
                if (MultipartBody.Part.class.isAssignableFrom(Utils.BuiltInFictitiousFunctionClassFactory(MyBillsEntityDataFactory7))) {
                    throw Utils.BuiltInFictitiousFunctionClassFactory(this.isLayoutRequested, i, "@PartMap values cannot be MultipartBody.Part. Use @Part List<Part> or a different value type instead.", new Object[0]);
                }
                return new ParameterHandler.PartMap(this.isLayoutRequested, i, this.FragmentBottomSheetPaymentSettingBinding.BuiltInFictitiousFunctionClassFactory(MyBillsEntityDataFactory7, annotationArr, this.newProxyInstance), ((PartMap) annotation).encoding());
            } else if (annotation instanceof Body) {
                BuiltInFictitiousFunctionClassFactory(i, type);
                if (this.NetworkUserEntityData$$ExternalSyntheticLambda2 || this.NetworkUserEntityData$$ExternalSyntheticLambda1) {
                    throw Utils.BuiltInFictitiousFunctionClassFactory(this.isLayoutRequested, i, "@Body parameters cannot be used with form or multi-part encoding.", new Object[0]);
                }
                if (this.KClassImpl$Data$declaredNonStaticMembers$2) {
                    throw Utils.BuiltInFictitiousFunctionClassFactory(this.isLayoutRequested, i, "Multiple @Body method annotations found.", new Object[0]);
                }
                try {
                    Converter BuiltInFictitiousFunctionClassFactory10 = this.FragmentBottomSheetPaymentSettingBinding.BuiltInFictitiousFunctionClassFactory(type, annotationArr, this.newProxyInstance);
                    this.KClassImpl$Data$declaredNonStaticMembers$2 = true;
                    return new ParameterHandler.Body(this.isLayoutRequested, i, BuiltInFictitiousFunctionClassFactory10);
                } catch (RuntimeException e) {
                    throw Utils.PlaceComponentResult(this.isLayoutRequested, e, i, "Unable to create @Body converter for %s", type);
                }
            } else if (annotation instanceof Tag) {
                BuiltInFictitiousFunctionClassFactory(i, type);
                Class<?> BuiltInFictitiousFunctionClassFactory11 = Utils.BuiltInFictitiousFunctionClassFactory(type);
                for (int i2 = i - 1; i2 >= 0; i2--) {
                    ParameterHandler<?> parameterHandler = this.NetworkUserEntityData$$ExternalSyntheticLambda7[i2];
                    if ((parameterHandler instanceof ParameterHandler.Tag) && ((ParameterHandler.Tag) parameterHandler).getAuthRequestContext.equals(BuiltInFictitiousFunctionClassFactory11)) {
                        Method method11 = this.isLayoutRequested;
                        StringBuilder sb12 = new StringBuilder();
                        sb12.append("@Tag type ");
                        sb12.append(BuiltInFictitiousFunctionClassFactory11.getName());
                        sb12.append(" is duplicate of parameter #");
                        sb12.append(i2 + 1);
                        sb12.append(" and would always overwrite its value.");
                        throw Utils.BuiltInFictitiousFunctionClassFactory(method11, i, sb12.toString(), new Object[0]);
                    }
                }
                return new ParameterHandler.Tag(BuiltInFictitiousFunctionClassFactory11);
            } else {
                return null;
            }
        }

        private void BuiltInFictitiousFunctionClassFactory(int i, Type type) {
            if (Utils.MyBillsEntityDataFactory(type)) {
                throw Utils.BuiltInFictitiousFunctionClassFactory(this.isLayoutRequested, i, "Parameter type must not include a type variable or wildcard: %s", type);
            }
        }

        private static Set<String> KClassImpl$Data$declaredNonStaticMembers$2(String str) {
            Matcher matcher = NetworkUserEntityData$$ExternalSyntheticLambda3.matcher(str);
            LinkedHashSet linkedHashSet = new LinkedHashSet();
            while (matcher.find()) {
                linkedHashSet.add(matcher.group(1));
            }
            return linkedHashSet;
        }

        private static Class<?> MyBillsEntityDataFactory(Class<?> cls) {
            return Boolean.TYPE == cls ? Boolean.class : Byte.TYPE == cls ? Byte.class : Character.TYPE == cls ? Character.class : Double.TYPE == cls ? Double.class : Float.TYPE == cls ? Float.class : Integer.TYPE == cls ? Integer.class : Long.TYPE == cls ? Long.class : Short.TYPE == cls ? Short.class : cls;
        }
    }
}
