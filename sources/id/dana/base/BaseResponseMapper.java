package id.dana.base;

import id.dana.utils.rpc.response.BaseRpcResponse;
import javax.inject.Inject;

/* loaded from: classes4.dex */
public class BaseResponseMapper {
    @Inject
    public BaseResponseMapper() {
    }

    public static BaseResponse MyBillsEntityDataFactory(BaseResponse baseResponse, BaseRpcResponse baseRpcResponse) {
        if (baseRpcResponse != null) {
            baseResponse.setSuccess(baseRpcResponse.isSuccess());
            baseResponse.setErrorCode(baseRpcResponse.getErrorCode());
            baseResponse.setErrorMessage(baseRpcResponse.getErrorMessage());
        }
        return baseResponse;
    }
}
