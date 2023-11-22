package retrofit2.converter.scalars;

import java.io.IOException;
import okhttp3.MediaType;
import okhttp3.RequestBody;
import retrofit2.Converter;

/* loaded from: classes9.dex */
final class ScalarRequestBodyConverter<T> implements Converter<T, RequestBody> {
    static final ScalarRequestBodyConverter<Object> getAuthRequestContext = new ScalarRequestBodyConverter<>();
    private static final MediaType MyBillsEntityDataFactory = MediaType.get("text/plain; charset=UTF-8");

    private ScalarRequestBodyConverter() {
    }

    @Override // retrofit2.Converter
    public final /* synthetic */ RequestBody getAuthRequestContext(Object obj) throws IOException {
        return RequestBody.create(MyBillsEntityDataFactory, String.valueOf(obj));
    }
}
