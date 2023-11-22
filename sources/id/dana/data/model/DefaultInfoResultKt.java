package id.dana.data.model;

import id.dana.utils.rpc.response.DefaultResponse;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0011\u0010\u0002\u001a\u00020\u0001*\u00020\u0000¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lid/dana/data/model/DefaultInfoResult;", "Lid/dana/utils/rpc/response/DefaultResponse;", "toDefaultResponse", "(Lid/dana/data/model/DefaultInfoResult;)Lid/dana/utils/rpc/response/DefaultResponse;"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class DefaultInfoResultKt {
    public static final DefaultResponse toDefaultResponse(DefaultInfoResult defaultInfoResult) {
        Intrinsics.checkNotNullParameter(defaultInfoResult, "");
        DefaultResponse defaultResponse = new DefaultResponse();
        defaultResponse.setErrorCode(defaultInfoResult.errorCode);
        defaultResponse.setErrorMessage(defaultInfoResult.getErrorMsg());
        defaultResponse.setSuccess(defaultInfoResult.success);
        return defaultResponse;
    }
}
