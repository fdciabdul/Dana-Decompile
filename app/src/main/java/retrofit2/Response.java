package retrofit2;

import java.util.Objects;
import javax.annotation.Nullable;
import okhttp3.ResponseBody;

/* loaded from: classes6.dex */
public final class Response<T> {
    @Nullable
    public final ResponseBody BuiltInFictitiousFunctionClassFactory;
    @Nullable
    public final T KClassImpl$Data$declaredNonStaticMembers$2;
    public final okhttp3.Response getAuthRequestContext;

    public static <T> Response<T> getAuthRequestContext(@Nullable T t, okhttp3.Response response) {
        Objects.requireNonNull(response, "rawResponse == null");
        if (!response.isSuccessful()) {
            throw new IllegalArgumentException("rawResponse must be successful response");
        }
        return new Response<>(response, t, null);
    }

    public static <T> Response<T> PlaceComponentResult(ResponseBody responseBody, okhttp3.Response response) {
        Objects.requireNonNull(responseBody, "body == null");
        Objects.requireNonNull(response, "rawResponse == null");
        if (response.isSuccessful()) {
            throw new IllegalArgumentException("rawResponse should not be successful response");
        }
        return new Response<>(response, null, responseBody);
    }

    private Response(okhttp3.Response response, @Nullable T t, @Nullable ResponseBody responseBody) {
        this.getAuthRequestContext = response;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = t;
        this.BuiltInFictitiousFunctionClassFactory = responseBody;
    }

    public final boolean MyBillsEntityDataFactory() {
        return this.getAuthRequestContext.isSuccessful();
    }

    public final String toString() {
        return this.getAuthRequestContext.toString();
    }
}
