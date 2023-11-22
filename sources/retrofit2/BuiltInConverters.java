package retrofit2;

import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;
import javax.annotation.Nullable;
import kotlin.Unit;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.Converter;
import retrofit2.http.Streaming;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes6.dex */
public final class BuiltInConverters extends Converter.Factory {
    private boolean BuiltInFictitiousFunctionClassFactory = true;

    @Override // retrofit2.Converter.Factory
    @Nullable
    public final Converter<ResponseBody, ?> getAuthRequestContext(Type type, Annotation[] annotationArr, Retrofit retrofit) {
        if (type == ResponseBody.class) {
            if (Utils.KClassImpl$Data$declaredNonStaticMembers$2(annotationArr, Streaming.class)) {
                return StreamingResponseBodyConverter.getAuthRequestContext;
            }
            return BufferingResponseBodyConverter.PlaceComponentResult;
        } else if (type == Void.class) {
            return VoidResponseBodyConverter.PlaceComponentResult;
        } else {
            if (this.BuiltInFictitiousFunctionClassFactory && type == Unit.class) {
                try {
                    return UnitResponseBodyConverter.PlaceComponentResult;
                } catch (NoClassDefFoundError unused) {
                    this.BuiltInFictitiousFunctionClassFactory = false;
                    return null;
                }
            }
            return null;
        }
    }

    @Override // retrofit2.Converter.Factory
    @Nullable
    public final Converter<?, RequestBody> BuiltInFictitiousFunctionClassFactory(Type type) {
        if (RequestBody.class.isAssignableFrom(Utils.BuiltInFictitiousFunctionClassFactory(type))) {
            return RequestBodyConverter.getAuthRequestContext;
        }
        return null;
    }

    /* loaded from: classes6.dex */
    static final class VoidResponseBodyConverter implements Converter<ResponseBody, Void> {
        static final VoidResponseBodyConverter PlaceComponentResult = new VoidResponseBodyConverter();

        VoidResponseBodyConverter() {
        }

        @Override // retrofit2.Converter
        public final /* synthetic */ Void getAuthRequestContext(ResponseBody responseBody) throws IOException {
            responseBody.close();
            return null;
        }
    }

    /* loaded from: classes6.dex */
    static final class UnitResponseBodyConverter implements Converter<ResponseBody, Unit> {
        static final UnitResponseBodyConverter PlaceComponentResult = new UnitResponseBodyConverter();

        UnitResponseBodyConverter() {
        }

        @Override // retrofit2.Converter
        public final /* synthetic */ Unit getAuthRequestContext(ResponseBody responseBody) throws IOException {
            responseBody.close();
            return Unit.INSTANCE;
        }
    }

    /* loaded from: classes6.dex */
    static final class RequestBodyConverter implements Converter<RequestBody, RequestBody> {
        static final RequestBodyConverter getAuthRequestContext = new RequestBodyConverter();

        RequestBodyConverter() {
        }

        @Override // retrofit2.Converter
        public final /* bridge */ /* synthetic */ RequestBody getAuthRequestContext(RequestBody requestBody) throws IOException {
            return requestBody;
        }
    }

    /* loaded from: classes6.dex */
    static final class StreamingResponseBodyConverter implements Converter<ResponseBody, ResponseBody> {
        static final StreamingResponseBodyConverter getAuthRequestContext = new StreamingResponseBodyConverter();

        StreamingResponseBodyConverter() {
        }

        @Override // retrofit2.Converter
        public final /* bridge */ /* synthetic */ ResponseBody getAuthRequestContext(ResponseBody responseBody) throws IOException {
            return responseBody;
        }
    }

    /* loaded from: classes6.dex */
    static final class BufferingResponseBodyConverter implements Converter<ResponseBody, ResponseBody> {
        static final BufferingResponseBodyConverter PlaceComponentResult = new BufferingResponseBodyConverter();

        BufferingResponseBodyConverter() {
        }

        @Override // retrofit2.Converter
        public final /* bridge */ /* synthetic */ ResponseBody getAuthRequestContext(ResponseBody responseBody) throws IOException {
            return getAuthRequestContext2(responseBody);
        }

        /* renamed from: getAuthRequestContext  reason: avoid collision after fix types in other method */
        private static ResponseBody getAuthRequestContext2(ResponseBody responseBody) throws IOException {
            try {
                return Utils.BuiltInFictitiousFunctionClassFactory(responseBody);
            } finally {
                responseBody.close();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes6.dex */
    public static final class ToStringConverter implements Converter<Object, String> {
        static final ToStringConverter PlaceComponentResult = new ToStringConverter();

        ToStringConverter() {
        }

        @Override // retrofit2.Converter
        public final /* synthetic */ String getAuthRequestContext(Object obj) throws IOException {
            return obj.toString();
        }
    }
}
