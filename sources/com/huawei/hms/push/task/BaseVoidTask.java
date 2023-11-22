package com.huawei.hms.push.task;

import com.huawei.hmf.tasks.TaskCompletionSource;
import com.huawei.hmf.tasks.a.i;
import com.huawei.hms.aaid.constant.ErrorEnum;
import com.huawei.hms.aaid.task.PushClient;
import com.huawei.hms.common.ApiException;
import com.huawei.hms.common.internal.ResponseErrorCode;
import com.huawei.hms.common.internal.TaskApiCall;
import com.huawei.hms.push.utils.PushBiUtil;
import com.huawei.hms.support.api.client.Status;
import com.huawei.hms.support.log.HMSLog;

/* loaded from: classes8.dex */
public class BaseVoidTask extends TaskApiCall<PushClient, Void> {
    @Override // com.huawei.hms.common.internal.TaskApiCall
    public /* synthetic */ void doExecute(PushClient pushClient, ResponseErrorCode responseErrorCode, String str, TaskCompletionSource<Void> taskCompletionSource) {
        PushClient pushClient2 = pushClient;
        if (responseErrorCode.getErrorCode() == 0) {
            HMSLog.i("BaseVoidTask", "Operate succeed");
            taskCompletionSource.MyBillsEntityDataFactory.KClassImpl$Data$declaredNonStaticMembers$2((i<Void>) null);
        } else {
            StringBuilder sb = new StringBuilder();
            sb.append("Operate failed with ret=");
            sb.append(responseErrorCode.getErrorCode());
            HMSLog.e("BaseVoidTask", sb.toString());
            ErrorEnum fromCode = ErrorEnum.fromCode(responseErrorCode.getErrorCode());
            if (fromCode != ErrorEnum.ERROR_UNKNOWN) {
                taskCompletionSource.MyBillsEntityDataFactory.KClassImpl$Data$declaredNonStaticMembers$2(fromCode.toApiException());
            } else {
                taskCompletionSource.MyBillsEntityDataFactory.KClassImpl$Data$declaredNonStaticMembers$2(new ApiException(new Status(responseErrorCode.getErrorCode(), responseErrorCode.getErrorReason())));
            }
        }
        PushBiUtil.getAuthRequestContext(pushClient2.getContext(), getUri(), responseErrorCode);
    }

    @Override // com.huawei.hms.common.internal.TaskApiCall
    public int getMinApkVersion() {
        return 30000000;
    }
}
