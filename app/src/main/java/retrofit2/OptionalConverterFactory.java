package retrofit2;

import j$.util.Optional;
import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import javax.annotation.Nullable;
import okhttp3.ResponseBody;
import retrofit2.Converter;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes6.dex */
public final class OptionalConverterFactory extends Converter.Factory {
    static final Converter.Factory getAuthRequestContext = new OptionalConverterFactory();

    OptionalConverterFactory() {
    }

    /* loaded from: classes6.dex */
    static final class OptionalConverter<T> implements Converter<ResponseBody, Optional<T>> {
        final Converter<ResponseBody, T> getAuthRequestContext;

        @Override // retrofit2.Converter
        public final /* synthetic */ Object getAuthRequestContext(ResponseBody responseBody) throws IOException {
            return Optional.BuiltInFictitiousFunctionClassFactory(this.getAuthRequestContext.getAuthRequestContext(responseBody));
        }

        OptionalConverter(Converter<ResponseBody, T> converter) {
            this.getAuthRequestContext = converter;
        }
    }

    @Override // retrofit2.Converter.Factory
    @Nullable
    public final Converter<ResponseBody, ?> getAuthRequestContext(Type type, Annotation[] annotationArr, Retrofit retrofit) {
        if (Utils.BuiltInFictitiousFunctionClassFactory(type) != Optional.class) {
            return null;
        }
        return new OptionalConverter(retrofit.MyBillsEntityDataFactory(Utils.MyBillsEntityDataFactory(0, (ParameterizedType) type), annotationArr));
    }
}
