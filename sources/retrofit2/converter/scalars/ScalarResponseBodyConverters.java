package retrofit2.converter.scalars;

import java.io.IOException;
import okhttp3.ResponseBody;
import retrofit2.Converter;

/* loaded from: classes9.dex */
final class ScalarResponseBodyConverters {
    private ScalarResponseBodyConverters() {
    }

    /* loaded from: classes9.dex */
    static final class StringResponseBodyConverter implements Converter<ResponseBody, String> {
        static final StringResponseBodyConverter MyBillsEntityDataFactory = new StringResponseBodyConverter();

        StringResponseBodyConverter() {
        }

        @Override // retrofit2.Converter
        public final /* synthetic */ String getAuthRequestContext(ResponseBody responseBody) throws IOException {
            return responseBody.string();
        }
    }

    /* loaded from: classes9.dex */
    static final class BooleanResponseBodyConverter implements Converter<ResponseBody, Boolean> {
        static final BooleanResponseBodyConverter BuiltInFictitiousFunctionClassFactory = new BooleanResponseBodyConverter();

        BooleanResponseBodyConverter() {
        }

        @Override // retrofit2.Converter
        public final /* synthetic */ Boolean getAuthRequestContext(ResponseBody responseBody) throws IOException {
            return Boolean.valueOf(responseBody.string());
        }
    }

    /* loaded from: classes9.dex */
    static final class ByteResponseBodyConverter implements Converter<ResponseBody, Byte> {
        static final ByteResponseBodyConverter PlaceComponentResult = new ByteResponseBodyConverter();

        ByteResponseBodyConverter() {
        }

        @Override // retrofit2.Converter
        public final /* synthetic */ Byte getAuthRequestContext(ResponseBody responseBody) throws IOException {
            return Byte.valueOf(responseBody.string());
        }
    }

    /* loaded from: classes9.dex */
    static final class CharacterResponseBodyConverter implements Converter<ResponseBody, Character> {
        static final CharacterResponseBodyConverter PlaceComponentResult = new CharacterResponseBodyConverter();

        CharacterResponseBodyConverter() {
        }

        @Override // retrofit2.Converter
        public final /* synthetic */ Character getAuthRequestContext(ResponseBody responseBody) throws IOException {
            String string = responseBody.string();
            if (string.length() != 1) {
                StringBuilder sb = new StringBuilder();
                sb.append("Expected body of length 1 for Character conversion but was ");
                sb.append(string.length());
                throw new IOException(sb.toString());
            }
            return Character.valueOf(string.charAt(0));
        }
    }

    /* loaded from: classes9.dex */
    static final class DoubleResponseBodyConverter implements Converter<ResponseBody, Double> {
        static final DoubleResponseBodyConverter MyBillsEntityDataFactory = new DoubleResponseBodyConverter();

        DoubleResponseBodyConverter() {
        }

        @Override // retrofit2.Converter
        public final /* synthetic */ Double getAuthRequestContext(ResponseBody responseBody) throws IOException {
            return Double.valueOf(responseBody.string());
        }
    }

    /* loaded from: classes9.dex */
    static final class FloatResponseBodyConverter implements Converter<ResponseBody, Float> {
        static final FloatResponseBodyConverter PlaceComponentResult = new FloatResponseBodyConverter();

        FloatResponseBodyConverter() {
        }

        @Override // retrofit2.Converter
        public final /* synthetic */ Float getAuthRequestContext(ResponseBody responseBody) throws IOException {
            return Float.valueOf(responseBody.string());
        }
    }

    /* loaded from: classes9.dex */
    static final class IntegerResponseBodyConverter implements Converter<ResponseBody, Integer> {
        static final IntegerResponseBodyConverter KClassImpl$Data$declaredNonStaticMembers$2 = new IntegerResponseBodyConverter();

        IntegerResponseBodyConverter() {
        }

        @Override // retrofit2.Converter
        public final /* synthetic */ Integer getAuthRequestContext(ResponseBody responseBody) throws IOException {
            return Integer.valueOf(responseBody.string());
        }
    }

    /* loaded from: classes9.dex */
    static final class LongResponseBodyConverter implements Converter<ResponseBody, Long> {
        static final LongResponseBodyConverter BuiltInFictitiousFunctionClassFactory = new LongResponseBodyConverter();

        LongResponseBodyConverter() {
        }

        @Override // retrofit2.Converter
        public final /* synthetic */ Long getAuthRequestContext(ResponseBody responseBody) throws IOException {
            return Long.valueOf(responseBody.string());
        }
    }

    /* loaded from: classes9.dex */
    static final class ShortResponseBodyConverter implements Converter<ResponseBody, Short> {
        static final ShortResponseBodyConverter KClassImpl$Data$declaredNonStaticMembers$2 = new ShortResponseBodyConverter();

        ShortResponseBodyConverter() {
        }

        @Override // retrofit2.Converter
        public final /* synthetic */ Short getAuthRequestContext(ResponseBody responseBody) throws IOException {
            return Short.valueOf(responseBody.string());
        }
    }
}
