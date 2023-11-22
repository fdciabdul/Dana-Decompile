package retrofit2.adapter.rxjava2;

import javax.annotation.Nullable;
import retrofit2.Response;

/* loaded from: classes6.dex */
public final class Result<T> {
    @Nullable
    private final Response<T> KClassImpl$Data$declaredNonStaticMembers$2;
    @Nullable
    private final Throwable MyBillsEntityDataFactory;

    public static <T> Result<T> PlaceComponentResult(Throwable th) {
        if (th == null) {
            throw new NullPointerException("error == null");
        }
        return new Result<>(null, th);
    }

    public static <T> Result<T> PlaceComponentResult(Response<T> response) {
        if (response == null) {
            throw new NullPointerException("response == null");
        }
        return new Result<>(response, null);
    }

    private Result(@Nullable Response<T> response, @Nullable Throwable th) {
        this.KClassImpl$Data$declaredNonStaticMembers$2 = response;
        this.MyBillsEntityDataFactory = th;
    }
}
