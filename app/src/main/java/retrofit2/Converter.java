package retrofit2;

import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;
import javax.annotation.Nullable;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;

/* loaded from: classes6.dex */
public interface Converter<F, T> {

    /* loaded from: classes2.dex */
    public static abstract class Factory {
        @Nullable
        public Converter<?, RequestBody> BuiltInFictitiousFunctionClassFactory(Type type) {
            return null;
        }

        @Nullable
        public Converter<ResponseBody, ?> getAuthRequestContext(Type type, Annotation[] annotationArr, Retrofit retrofit) {
            return null;
        }
    }

    @Nullable
    T getAuthRequestContext(F f) throws IOException;
}
