package com.huawei.hms.opendevice;

import com.huawei.hmf.tasks.TaskCompletionSource;
import com.huawei.hms.aaid.HmsInstanceId;
import com.huawei.hms.aaid.constant.ErrorEnum;
import com.huawei.hms.aaid.entity.DeleteTokenReq;
import com.huawei.hms.aaid.entity.DeleteTokenResp;
import com.huawei.hms.aaid.task.PushClient;
import com.huawei.hms.common.ApiException;
import com.huawei.hms.common.internal.ResponseErrorCode;
import com.huawei.hms.common.internal.TaskApiCall;
import com.huawei.hms.support.api.client.Status;
import com.huawei.hms.support.log.HMSLog;
import com.huawei.hms.utils.JsonUtil;

/* loaded from: classes8.dex */
public class k extends TaskApiCall<PushClient, Void> {
    public DeleteTokenReq getAuthRequestContext;

    @Override // com.huawei.hms.common.internal.TaskApiCall
    public /* synthetic */ void doExecute(PushClient pushClient, ResponseErrorCode responseErrorCode, String str, TaskCompletionSource<Void> taskCompletionSource) {
        PushClient pushClient2 = pushClient;
        if (responseErrorCode.getErrorCode() != 0) {
            String str2 = HmsInstanceId.KClassImpl$Data$declaredNonStaticMembers$2;
            StringBuilder sb = new StringBuilder();
            sb.append("DeleteTokenTask failed, ErrorCode: ");
            sb.append(responseErrorCode.getErrorCode());
            HMSLog.e(str2, sb.toString());
            ErrorEnum fromCode = ErrorEnum.fromCode(responseErrorCode.getErrorCode());
            if (fromCode != ErrorEnum.ERROR_UNKNOWN) {
                taskCompletionSource.MyBillsEntityDataFactory.KClassImpl$Data$declaredNonStaticMembers$2(fromCode.toApiException());
                return;
            }
            taskCompletionSource.MyBillsEntityDataFactory.KClassImpl$Data$declaredNonStaticMembers$2(new ApiException(new Status(responseErrorCode.getErrorCode(), responseErrorCode.getErrorReason())));
            return;
        }
        ErrorEnum fromCode2 = ErrorEnum.fromCode(((DeleteTokenResp) JsonUtil.jsonToEntity(str, new DeleteTokenResp())).getRetCode());
        if (fromCode2 != ErrorEnum.SUCCESS) {
            taskCompletionSource.MyBillsEntityDataFactory.KClassImpl$Data$declaredNonStaticMembers$2(fromCode2.toApiException());
            return;
        }
        taskCompletionSource.MyBillsEntityDataFactory.KClassImpl$Data$declaredNonStaticMembers$2((com.huawei.hmf.tasks.a.i<Void>) null);
        q.BuiltInFictitiousFunctionClassFactory(pushClient2.getContext(), getUri(), responseErrorCode);
    }

    @Override // com.huawei.hms.common.internal.TaskApiCall
    public int getMinApkVersion() {
        return this.getAuthRequestContext.isMultiSender() ? 50004300 : 30000000;
    }
}
