package id.dana.data;

import com.alipayplus.mobile.component.domain.model.result.BaseRpcResult;
import id.dana.utils.rpc.response.BaseRpcResponse;

/* loaded from: classes4.dex */
public class BaseMapper {
    public static void transform(BaseRpcResponse baseRpcResponse, BaseRpcResult baseRpcResult) {
        if (baseRpcResponse != null) {
            baseRpcResponse.setSuccess(baseRpcResult.success);
            baseRpcResponse.setErrorCode(baseRpcResult.errorCode);
            baseRpcResponse.setErrorMessage(baseRpcResult.errorMessage);
        }
    }
}
