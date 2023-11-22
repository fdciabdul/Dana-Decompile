package retrofit2;

import com.google.common.net.HttpHeaders;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.Map;
import java.util.Objects;
import javax.annotation.Nullable;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes6.dex */
public abstract class ParameterHandler<T> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract void MyBillsEntityDataFactory(RequestBuilder requestBuilder, @Nullable T t) throws IOException;

    ParameterHandler() {
    }

    /* loaded from: classes6.dex */
    static final class RelativeUrl extends ParameterHandler<Object> {
        private final int KClassImpl$Data$declaredNonStaticMembers$2;
        private final Method MyBillsEntityDataFactory;

        /* JADX INFO: Access modifiers changed from: package-private */
        public RelativeUrl(Method method, int i) {
            this.MyBillsEntityDataFactory = method;
            this.KClassImpl$Data$declaredNonStaticMembers$2 = i;
        }

        @Override // retrofit2.ParameterHandler
        final void MyBillsEntityDataFactory(RequestBuilder requestBuilder, @Nullable Object obj) {
            if (obj == null) {
                throw Utils.BuiltInFictitiousFunctionClassFactory(this.MyBillsEntityDataFactory, this.KClassImpl$Data$declaredNonStaticMembers$2, "@Url parameter is null.", new Object[0]);
            }
            requestBuilder.getErrorConfigVersion = obj.toString();
        }
    }

    /* loaded from: classes6.dex */
    static final class Header<T> extends ParameterHandler<T> {
        private final String BuiltInFictitiousFunctionClassFactory;
        private final Converter<T, String> PlaceComponentResult;

        /* JADX INFO: Access modifiers changed from: package-private */
        public Header(String str, Converter<T, String> converter) {
            this.BuiltInFictitiousFunctionClassFactory = (String) Objects.requireNonNull(str, "name == null");
            this.PlaceComponentResult = converter;
        }

        @Override // retrofit2.ParameterHandler
        final void MyBillsEntityDataFactory(RequestBuilder requestBuilder, @Nullable T t) throws IOException {
            String authRequestContext;
            if (t == null || (authRequestContext = this.PlaceComponentResult.getAuthRequestContext(t)) == null) {
                return;
            }
            requestBuilder.getAuthRequestContext(this.BuiltInFictitiousFunctionClassFactory, authRequestContext);
        }
    }

    /* loaded from: classes6.dex */
    static final class Path<T> extends ParameterHandler<T> {
        private final int BuiltInFictitiousFunctionClassFactory;
        private final String KClassImpl$Data$declaredNonStaticMembers$2;
        private final Converter<T, String> MyBillsEntityDataFactory;
        private final boolean PlaceComponentResult;
        private final Method getAuthRequestContext;

        /* JADX INFO: Access modifiers changed from: package-private */
        public Path(Method method, int i, String str, Converter<T, String> converter, boolean z) {
            this.getAuthRequestContext = method;
            this.BuiltInFictitiousFunctionClassFactory = i;
            this.KClassImpl$Data$declaredNonStaticMembers$2 = (String) Objects.requireNonNull(str, "name == null");
            this.MyBillsEntityDataFactory = converter;
            this.PlaceComponentResult = z;
        }

        @Override // retrofit2.ParameterHandler
        final void MyBillsEntityDataFactory(RequestBuilder requestBuilder, @Nullable T t) throws IOException {
            if (t == null) {
                Method method = this.getAuthRequestContext;
                int i = this.BuiltInFictitiousFunctionClassFactory;
                StringBuilder sb = new StringBuilder();
                sb.append("Path parameter \"");
                sb.append(this.KClassImpl$Data$declaredNonStaticMembers$2);
                sb.append("\" value must not be null.");
                throw Utils.BuiltInFictitiousFunctionClassFactory(method, i, sb.toString(), new Object[0]);
            }
            String str = this.KClassImpl$Data$declaredNonStaticMembers$2;
            String authRequestContext = this.MyBillsEntityDataFactory.getAuthRequestContext(t);
            boolean z = this.PlaceComponentResult;
            if (requestBuilder.getErrorConfigVersion == null) {
                throw new AssertionError();
            }
            String PlaceComponentResult = RequestBuilder.PlaceComponentResult(authRequestContext, z);
            String str2 = requestBuilder.getErrorConfigVersion;
            StringBuilder sb2 = new StringBuilder();
            sb2.append("{");
            sb2.append(str);
            sb2.append("}");
            String replace = str2.replace(sb2.toString(), PlaceComponentResult);
            if (RequestBuilder.BuiltInFictitiousFunctionClassFactory.matcher(replace).matches()) {
                StringBuilder sb3 = new StringBuilder();
                sb3.append("@Path parameters shouldn't perform path traversal ('.' or '..'): ");
                sb3.append(authRequestContext);
                throw new IllegalArgumentException(sb3.toString());
            }
            requestBuilder.getErrorConfigVersion = replace;
        }
    }

    /* loaded from: classes6.dex */
    static final class Query<T> extends ParameterHandler<T> {
        private final Converter<T, String> BuiltInFictitiousFunctionClassFactory;
        private final boolean KClassImpl$Data$declaredNonStaticMembers$2;
        private final String PlaceComponentResult;

        /* JADX INFO: Access modifiers changed from: package-private */
        public Query(String str, Converter<T, String> converter, boolean z) {
            this.PlaceComponentResult = (String) Objects.requireNonNull(str, "name == null");
            this.BuiltInFictitiousFunctionClassFactory = converter;
            this.KClassImpl$Data$declaredNonStaticMembers$2 = z;
        }

        @Override // retrofit2.ParameterHandler
        final void MyBillsEntityDataFactory(RequestBuilder requestBuilder, @Nullable T t) throws IOException {
            String authRequestContext;
            if (t == null || (authRequestContext = this.BuiltInFictitiousFunctionClassFactory.getAuthRequestContext(t)) == null) {
                return;
            }
            requestBuilder.BuiltInFictitiousFunctionClassFactory(this.PlaceComponentResult, authRequestContext, this.KClassImpl$Data$declaredNonStaticMembers$2);
        }
    }

    /* loaded from: classes6.dex */
    static final class QueryName<T> extends ParameterHandler<T> {
        private final Converter<T, String> BuiltInFictitiousFunctionClassFactory;
        private final boolean MyBillsEntityDataFactory;

        /* JADX INFO: Access modifiers changed from: package-private */
        public QueryName(Converter<T, String> converter, boolean z) {
            this.BuiltInFictitiousFunctionClassFactory = converter;
            this.MyBillsEntityDataFactory = z;
        }

        @Override // retrofit2.ParameterHandler
        final void MyBillsEntityDataFactory(RequestBuilder requestBuilder, @Nullable T t) throws IOException {
            if (t == null) {
                return;
            }
            requestBuilder.BuiltInFictitiousFunctionClassFactory(this.BuiltInFictitiousFunctionClassFactory.getAuthRequestContext(t), null, this.MyBillsEntityDataFactory);
        }
    }

    /* loaded from: classes6.dex */
    static final class QueryMap<T> extends ParameterHandler<Map<String, T>> {
        private final int BuiltInFictitiousFunctionClassFactory;
        private final Converter<T, String> KClassImpl$Data$declaredNonStaticMembers$2;
        private final Method MyBillsEntityDataFactory;
        private final boolean getAuthRequestContext;

        /* JADX WARN: Multi-variable type inference failed */
        @Override // retrofit2.ParameterHandler
        final /* synthetic */ void MyBillsEntityDataFactory(RequestBuilder requestBuilder, @Nullable Object obj) throws IOException {
            Map map = (Map) obj;
            if (map == null) {
                throw Utils.BuiltInFictitiousFunctionClassFactory(this.MyBillsEntityDataFactory, this.BuiltInFictitiousFunctionClassFactory, "Query map was null", new Object[0]);
            }
            for (Map.Entry entry : map.entrySet()) {
                String str = (String) entry.getKey();
                if (str == null) {
                    throw Utils.BuiltInFictitiousFunctionClassFactory(this.MyBillsEntityDataFactory, this.BuiltInFictitiousFunctionClassFactory, "Query map contained null key.", new Object[0]);
                }
                Object value = entry.getValue();
                if (value == null) {
                    Method method = this.MyBillsEntityDataFactory;
                    int i = this.BuiltInFictitiousFunctionClassFactory;
                    StringBuilder sb = new StringBuilder();
                    sb.append("Query map contained null value for key '");
                    sb.append(str);
                    sb.append("'.");
                    throw Utils.BuiltInFictitiousFunctionClassFactory(method, i, sb.toString(), new Object[0]);
                }
                String str2 = (String) this.KClassImpl$Data$declaredNonStaticMembers$2.getAuthRequestContext(value);
                if (str2 == null) {
                    Method method2 = this.MyBillsEntityDataFactory;
                    int i2 = this.BuiltInFictitiousFunctionClassFactory;
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("Query map value '");
                    sb2.append(value);
                    sb2.append("' converted to null by ");
                    sb2.append(this.KClassImpl$Data$declaredNonStaticMembers$2.getClass().getName());
                    sb2.append(" for key '");
                    sb2.append(str);
                    sb2.append("'.");
                    throw Utils.BuiltInFictitiousFunctionClassFactory(method2, i2, sb2.toString(), new Object[0]);
                }
                requestBuilder.BuiltInFictitiousFunctionClassFactory(str, str2, this.getAuthRequestContext);
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public QueryMap(Method method, int i, Converter<T, String> converter, boolean z) {
            this.MyBillsEntityDataFactory = method;
            this.BuiltInFictitiousFunctionClassFactory = i;
            this.KClassImpl$Data$declaredNonStaticMembers$2 = converter;
            this.getAuthRequestContext = z;
        }
    }

    /* loaded from: classes6.dex */
    static final class HeaderMap<T> extends ParameterHandler<Map<String, T>> {
        private final int BuiltInFictitiousFunctionClassFactory;
        private final Method KClassImpl$Data$declaredNonStaticMembers$2;
        private final Converter<T, String> PlaceComponentResult;

        /* JADX WARN: Multi-variable type inference failed */
        @Override // retrofit2.ParameterHandler
        final /* synthetic */ void MyBillsEntityDataFactory(RequestBuilder requestBuilder, @Nullable Object obj) throws IOException {
            Map map = (Map) obj;
            if (map == null) {
                throw Utils.BuiltInFictitiousFunctionClassFactory(this.KClassImpl$Data$declaredNonStaticMembers$2, this.BuiltInFictitiousFunctionClassFactory, "Header map was null.", new Object[0]);
            }
            for (Map.Entry entry : map.entrySet()) {
                String str = (String) entry.getKey();
                if (str == null) {
                    throw Utils.BuiltInFictitiousFunctionClassFactory(this.KClassImpl$Data$declaredNonStaticMembers$2, this.BuiltInFictitiousFunctionClassFactory, "Header map contained null key.", new Object[0]);
                }
                Object value = entry.getValue();
                if (value == null) {
                    Method method = this.KClassImpl$Data$declaredNonStaticMembers$2;
                    int i = this.BuiltInFictitiousFunctionClassFactory;
                    StringBuilder sb = new StringBuilder();
                    sb.append("Header map contained null value for key '");
                    sb.append(str);
                    sb.append("'.");
                    throw Utils.BuiltInFictitiousFunctionClassFactory(method, i, sb.toString(), new Object[0]);
                }
                requestBuilder.getAuthRequestContext(str, (String) this.PlaceComponentResult.getAuthRequestContext(value));
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public HeaderMap(Method method, int i, Converter<T, String> converter) {
            this.KClassImpl$Data$declaredNonStaticMembers$2 = method;
            this.BuiltInFictitiousFunctionClassFactory = i;
            this.PlaceComponentResult = converter;
        }
    }

    /* loaded from: classes6.dex */
    static final class Headers extends ParameterHandler<okhttp3.Headers> {
        private final Method BuiltInFictitiousFunctionClassFactory;
        private final int PlaceComponentResult;

        @Override // retrofit2.ParameterHandler
        final /* synthetic */ void MyBillsEntityDataFactory(RequestBuilder requestBuilder, @Nullable okhttp3.Headers headers) throws IOException {
            okhttp3.Headers headers2 = headers;
            if (headers2 == null) {
                throw Utils.BuiltInFictitiousFunctionClassFactory(this.BuiltInFictitiousFunctionClassFactory, this.PlaceComponentResult, "Headers parameter must not be null.", new Object[0]);
            }
            requestBuilder.scheduleImpl.addAll(headers2);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public Headers(Method method, int i) {
            this.BuiltInFictitiousFunctionClassFactory = method;
            this.PlaceComponentResult = i;
        }
    }

    /* loaded from: classes6.dex */
    static final class Field<T> extends ParameterHandler<T> {
        private final String KClassImpl$Data$declaredNonStaticMembers$2;
        private final boolean MyBillsEntityDataFactory;
        private final Converter<T, String> getAuthRequestContext;

        /* JADX INFO: Access modifiers changed from: package-private */
        public Field(String str, Converter<T, String> converter, boolean z) {
            this.KClassImpl$Data$declaredNonStaticMembers$2 = (String) Objects.requireNonNull(str, "name == null");
            this.getAuthRequestContext = converter;
            this.MyBillsEntityDataFactory = z;
        }

        @Override // retrofit2.ParameterHandler
        final void MyBillsEntityDataFactory(RequestBuilder requestBuilder, @Nullable T t) throws IOException {
            String authRequestContext;
            if (t == null || (authRequestContext = this.getAuthRequestContext.getAuthRequestContext(t)) == null) {
                return;
            }
            String str = this.KClassImpl$Data$declaredNonStaticMembers$2;
            if (this.MyBillsEntityDataFactory) {
                requestBuilder.MyBillsEntityDataFactory.addEncoded(str, authRequestContext);
            } else {
                requestBuilder.MyBillsEntityDataFactory.add(str, authRequestContext);
            }
        }
    }

    /* loaded from: classes6.dex */
    static final class FieldMap<T> extends ParameterHandler<Map<String, T>> {
        private final boolean BuiltInFictitiousFunctionClassFactory;
        private final Method KClassImpl$Data$declaredNonStaticMembers$2;
        private final int MyBillsEntityDataFactory;
        private final Converter<T, String> PlaceComponentResult;

        /* JADX WARN: Multi-variable type inference failed */
        @Override // retrofit2.ParameterHandler
        final /* synthetic */ void MyBillsEntityDataFactory(RequestBuilder requestBuilder, @Nullable Object obj) throws IOException {
            Map map = (Map) obj;
            if (map == null) {
                throw Utils.BuiltInFictitiousFunctionClassFactory(this.KClassImpl$Data$declaredNonStaticMembers$2, this.MyBillsEntityDataFactory, "Field map was null.", new Object[0]);
            }
            for (Map.Entry entry : map.entrySet()) {
                String str = (String) entry.getKey();
                if (str == null) {
                    throw Utils.BuiltInFictitiousFunctionClassFactory(this.KClassImpl$Data$declaredNonStaticMembers$2, this.MyBillsEntityDataFactory, "Field map contained null key.", new Object[0]);
                }
                Object value = entry.getValue();
                if (value == null) {
                    Method method = this.KClassImpl$Data$declaredNonStaticMembers$2;
                    int i = this.MyBillsEntityDataFactory;
                    StringBuilder sb = new StringBuilder();
                    sb.append("Field map contained null value for key '");
                    sb.append(str);
                    sb.append("'.");
                    throw Utils.BuiltInFictitiousFunctionClassFactory(method, i, sb.toString(), new Object[0]);
                }
                String str2 = (String) this.PlaceComponentResult.getAuthRequestContext(value);
                if (str2 == null) {
                    Method method2 = this.KClassImpl$Data$declaredNonStaticMembers$2;
                    int i2 = this.MyBillsEntityDataFactory;
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("Field map value '");
                    sb2.append(value);
                    sb2.append("' converted to null by ");
                    sb2.append(this.PlaceComponentResult.getClass().getName());
                    sb2.append(" for key '");
                    sb2.append(str);
                    sb2.append("'.");
                    throw Utils.BuiltInFictitiousFunctionClassFactory(method2, i2, sb2.toString(), new Object[0]);
                } else if (this.BuiltInFictitiousFunctionClassFactory) {
                    requestBuilder.MyBillsEntityDataFactory.addEncoded(str, str2);
                } else {
                    requestBuilder.MyBillsEntityDataFactory.add(str, str2);
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public FieldMap(Method method, int i, Converter<T, String> converter, boolean z) {
            this.KClassImpl$Data$declaredNonStaticMembers$2 = method;
            this.MyBillsEntityDataFactory = i;
            this.PlaceComponentResult = converter;
            this.BuiltInFictitiousFunctionClassFactory = z;
        }
    }

    /* loaded from: classes6.dex */
    static final class Part<T> extends ParameterHandler<T> {
        private final Method BuiltInFictitiousFunctionClassFactory;
        private final Converter<T, RequestBody> KClassImpl$Data$declaredNonStaticMembers$2;
        private final int PlaceComponentResult;
        private final okhttp3.Headers getAuthRequestContext;

        /* JADX INFO: Access modifiers changed from: package-private */
        public Part(Method method, int i, okhttp3.Headers headers, Converter<T, RequestBody> converter) {
            this.BuiltInFictitiousFunctionClassFactory = method;
            this.PlaceComponentResult = i;
            this.getAuthRequestContext = headers;
            this.KClassImpl$Data$declaredNonStaticMembers$2 = converter;
        }

        @Override // retrofit2.ParameterHandler
        final void MyBillsEntityDataFactory(RequestBuilder requestBuilder, @Nullable T t) {
            if (t == null) {
                return;
            }
            try {
                requestBuilder.NetworkUserEntityData$$ExternalSyntheticLambda0.addPart(this.getAuthRequestContext, this.KClassImpl$Data$declaredNonStaticMembers$2.getAuthRequestContext(t));
            } catch (IOException e) {
                Method method = this.BuiltInFictitiousFunctionClassFactory;
                int i = this.PlaceComponentResult;
                StringBuilder sb = new StringBuilder();
                sb.append("Unable to convert ");
                sb.append(t);
                sb.append(" to RequestBody");
                throw Utils.BuiltInFictitiousFunctionClassFactory(method, i, sb.toString(), e);
            }
        }
    }

    /* loaded from: classes6.dex */
    static final class RawPart extends ParameterHandler<MultipartBody.Part> {
        static final RawPart PlaceComponentResult = new RawPart();

        @Override // retrofit2.ParameterHandler
        final /* synthetic */ void MyBillsEntityDataFactory(RequestBuilder requestBuilder, @Nullable MultipartBody.Part part) throws IOException {
            MultipartBody.Part part2 = part;
            if (part2 != null) {
                requestBuilder.NetworkUserEntityData$$ExternalSyntheticLambda0.addPart(part2);
            }
        }

        private RawPart() {
        }
    }

    /* loaded from: classes6.dex */
    static final class PartMap<T> extends ParameterHandler<Map<String, T>> {
        private final String BuiltInFictitiousFunctionClassFactory;
        private final Converter<T, RequestBody> KClassImpl$Data$declaredNonStaticMembers$2;
        private final Method MyBillsEntityDataFactory;
        private final int getAuthRequestContext;

        /* JADX WARN: Multi-variable type inference failed */
        @Override // retrofit2.ParameterHandler
        final /* synthetic */ void MyBillsEntityDataFactory(RequestBuilder requestBuilder, @Nullable Object obj) throws IOException {
            Map map = (Map) obj;
            if (map == null) {
                throw Utils.BuiltInFictitiousFunctionClassFactory(this.MyBillsEntityDataFactory, this.getAuthRequestContext, "Part map was null.", new Object[0]);
            }
            for (Map.Entry entry : map.entrySet()) {
                String str = (String) entry.getKey();
                if (str == null) {
                    throw Utils.BuiltInFictitiousFunctionClassFactory(this.MyBillsEntityDataFactory, this.getAuthRequestContext, "Part map contained null key.", new Object[0]);
                }
                Object value = entry.getValue();
                if (value == null) {
                    Method method = this.MyBillsEntityDataFactory;
                    int i = this.getAuthRequestContext;
                    StringBuilder sb = new StringBuilder();
                    sb.append("Part map contained null value for key '");
                    sb.append(str);
                    sb.append("'.");
                    throw Utils.BuiltInFictitiousFunctionClassFactory(method, i, sb.toString(), new Object[0]);
                }
                StringBuilder sb2 = new StringBuilder();
                sb2.append("form-data; name=\"");
                sb2.append(str);
                sb2.append("\"");
                requestBuilder.NetworkUserEntityData$$ExternalSyntheticLambda0.addPart(okhttp3.Headers.of(HttpHeaders.CONTENT_DISPOSITION, sb2.toString(), "Content-Transfer-Encoding", this.BuiltInFictitiousFunctionClassFactory), (RequestBody) this.KClassImpl$Data$declaredNonStaticMembers$2.getAuthRequestContext(value));
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public PartMap(Method method, int i, Converter<T, RequestBody> converter, String str) {
            this.MyBillsEntityDataFactory = method;
            this.getAuthRequestContext = i;
            this.KClassImpl$Data$declaredNonStaticMembers$2 = converter;
            this.BuiltInFictitiousFunctionClassFactory = str;
        }
    }

    /* loaded from: classes6.dex */
    static final class Body<T> extends ParameterHandler<T> {
        private final Converter<T, RequestBody> BuiltInFictitiousFunctionClassFactory;
        private final Method MyBillsEntityDataFactory;
        private final int PlaceComponentResult;

        /* JADX INFO: Access modifiers changed from: package-private */
        public Body(Method method, int i, Converter<T, RequestBody> converter) {
            this.MyBillsEntityDataFactory = method;
            this.PlaceComponentResult = i;
            this.BuiltInFictitiousFunctionClassFactory = converter;
        }

        @Override // retrofit2.ParameterHandler
        final void MyBillsEntityDataFactory(RequestBuilder requestBuilder, @Nullable T t) {
            if (t == null) {
                throw Utils.BuiltInFictitiousFunctionClassFactory(this.MyBillsEntityDataFactory, this.PlaceComponentResult, "Body parameter value must not be null.", new Object[0]);
            }
            try {
                requestBuilder.getAuthRequestContext = this.BuiltInFictitiousFunctionClassFactory.getAuthRequestContext(t);
            } catch (IOException e) {
                Method method = this.MyBillsEntityDataFactory;
                int i = this.PlaceComponentResult;
                StringBuilder sb = new StringBuilder();
                sb.append("Unable to convert ");
                sb.append(t);
                sb.append(" to RequestBody");
                throw Utils.PlaceComponentResult(method, e, i, sb.toString(), new Object[0]);
            }
        }
    }

    /* loaded from: classes6.dex */
    static final class Tag<T> extends ParameterHandler<T> {
        final Class<T> getAuthRequestContext;

        /* JADX INFO: Access modifiers changed from: package-private */
        public Tag(Class<T> cls) {
            this.getAuthRequestContext = cls;
        }

        @Override // retrofit2.ParameterHandler
        final void MyBillsEntityDataFactory(RequestBuilder requestBuilder, @Nullable T t) {
            requestBuilder.initRecordTimeStamp.tag(this.getAuthRequestContext, t);
        }
    }
}
