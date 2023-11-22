package retrofit2.converter.scalars;

import java.lang.annotation.Annotation;
import java.lang.reflect.Type;
import javax.annotation.Nullable;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.Converter;
import retrofit2.Retrofit;
import retrofit2.converter.scalars.ScalarResponseBodyConverters;

/* loaded from: classes9.dex */
public final class ScalarsConverterFactory extends Converter.Factory {
    public static ScalarsConverterFactory getAuthRequestContext() {
        return new ScalarsConverterFactory();
    }

    private ScalarsConverterFactory() {
    }

    @Override // retrofit2.Converter.Factory
    @Nullable
    public final Converter<?, RequestBody> BuiltInFictitiousFunctionClassFactory(Type type) {
        if (type == String.class || type == Boolean.TYPE || type == Boolean.class || type == Byte.TYPE || type == Byte.class || type == Character.TYPE || type == Character.class || type == Double.TYPE || type == Double.class || type == Float.TYPE || type == Float.class || type == Integer.TYPE || type == Integer.class || type == Long.TYPE || type == Long.class || type == Short.TYPE || type == Short.class) {
            return ScalarRequestBodyConverter.getAuthRequestContext;
        }
        return null;
    }

    @Override // retrofit2.Converter.Factory
    @Nullable
    public final Converter<ResponseBody, ?> getAuthRequestContext(Type type, Annotation[] annotationArr, Retrofit retrofit) {
        if (type == String.class) {
            return ScalarResponseBodyConverters.StringResponseBodyConverter.MyBillsEntityDataFactory;
        }
        if (type == Boolean.class || type == Boolean.TYPE) {
            return ScalarResponseBodyConverters.BooleanResponseBodyConverter.BuiltInFictitiousFunctionClassFactory;
        }
        if (type == Byte.class || type == Byte.TYPE) {
            return ScalarResponseBodyConverters.ByteResponseBodyConverter.PlaceComponentResult;
        }
        if (type == Character.class || type == Character.TYPE) {
            return ScalarResponseBodyConverters.CharacterResponseBodyConverter.PlaceComponentResult;
        }
        if (type == Double.class || type == Double.TYPE) {
            return ScalarResponseBodyConverters.DoubleResponseBodyConverter.MyBillsEntityDataFactory;
        }
        if (type == Float.class || type == Float.TYPE) {
            return ScalarResponseBodyConverters.FloatResponseBodyConverter.PlaceComponentResult;
        }
        if (type == Integer.class || type == Integer.TYPE) {
            return ScalarResponseBodyConverters.IntegerResponseBodyConverter.KClassImpl$Data$declaredNonStaticMembers$2;
        }
        if (type == Long.class || type == Long.TYPE) {
            return ScalarResponseBodyConverters.LongResponseBodyConverter.BuiltInFictitiousFunctionClassFactory;
        }
        if (type == Short.class || type == Short.TYPE) {
            return ScalarResponseBodyConverters.ShortResponseBodyConverter.KClassImpl$Data$declaredNonStaticMembers$2;
        }
        return null;
    }
}
