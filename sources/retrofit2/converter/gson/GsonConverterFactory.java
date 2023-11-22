package retrofit2.converter.gson;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.Converter;
import retrofit2.Retrofit;

/* loaded from: classes2.dex */
public final class GsonConverterFactory extends Converter.Factory {
    private final Gson BuiltInFictitiousFunctionClassFactory;

    public static GsonConverterFactory BuiltInFictitiousFunctionClassFactory() {
        return new GsonConverterFactory(new Gson());
    }

    public static GsonConverterFactory BuiltInFictitiousFunctionClassFactory(Gson gson) {
        if (gson == null) {
            throw new NullPointerException("gson == null");
        }
        return new GsonConverterFactory(gson);
    }

    private GsonConverterFactory(Gson gson) {
        this.BuiltInFictitiousFunctionClassFactory = gson;
    }

    @Override // retrofit2.Converter.Factory
    public final Converter<ResponseBody, ?> getAuthRequestContext(Type type, Annotation[] annotationArr, Retrofit retrofit) {
        return new GsonResponseBodyConverter(this.BuiltInFictitiousFunctionClassFactory, this.BuiltInFictitiousFunctionClassFactory.getAdapter(TypeToken.get(type)));
    }

    @Override // retrofit2.Converter.Factory
    public final Converter<?, RequestBody> BuiltInFictitiousFunctionClassFactory(Type type) {
        return new GsonRequestBodyConverter(this.BuiltInFictitiousFunctionClassFactory, this.BuiltInFictitiousFunctionClassFactory.getAdapter(TypeToken.get(type)));
    }
}
