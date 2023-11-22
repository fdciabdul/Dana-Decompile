package retrofit2.converter.gson;

import com.google.gson.Gson;
import com.google.gson.JsonIOException;
import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import java.io.IOException;
import okhttp3.ResponseBody;
import retrofit2.Converter;

/* loaded from: classes6.dex */
final class GsonResponseBodyConverter<T> implements Converter<ResponseBody, T> {
    private final TypeAdapter<T> KClassImpl$Data$declaredNonStaticMembers$2;
    private final Gson getAuthRequestContext;

    /* JADX INFO: Access modifiers changed from: package-private */
    public GsonResponseBodyConverter(Gson gson, TypeAdapter<T> typeAdapter) {
        this.getAuthRequestContext = gson;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = typeAdapter;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // retrofit2.Converter
    /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: merged with bridge method [inline-methods] */
    public T getAuthRequestContext(ResponseBody responseBody) throws IOException {
        JsonReader newJsonReader = this.getAuthRequestContext.newJsonReader(responseBody.charStream());
        try {
            T read2 = this.KClassImpl$Data$declaredNonStaticMembers$2.read2(newJsonReader);
            if (newJsonReader.peek() == JsonToken.END_DOCUMENT) {
                return read2;
            }
            throw new JsonIOException("JSON document was not fully consumed.");
        } finally {
            responseBody.close();
        }
    }
}
