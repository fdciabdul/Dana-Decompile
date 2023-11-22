package com.huawei.hms.opendevice;

import com.huawei.hmf.tasks.TaskCompletionSource;
import com.huawei.hms.common.ApiException;
import com.huawei.hms.common.internal.ResponseErrorCode;
import com.huawei.hms.common.internal.TaskApiCall;
import com.huawei.hms.support.api.client.Status;
import com.huawei.hms.support.api.entity.opendevice.OdidResp;
import com.huawei.hms.support.api.opendevice.OdidResult;
import com.huawei.hms.support.hianalytics.HiAnalyticsClient;
import com.huawei.hms.support.log.HMSLog;
import com.huawei.hms.utils.JsonUtil;

/* loaded from: classes8.dex */
public class OpenDeviceTaskApiCall extends TaskApiCall<OpenDeviceHmsClient, OdidResult> {
    @Override // com.huawei.hms.common.internal.TaskApiCall
    public /* synthetic */ void doExecute(OpenDeviceHmsClient openDeviceHmsClient, ResponseErrorCode responseErrorCode, String str, TaskCompletionSource<OdidResult> taskCompletionSource) {
        OpenDeviceHmsClient openDeviceHmsClient2 = openDeviceHmsClient;
        if (responseErrorCode == null) {
            taskCompletionSource.MyBillsEntityDataFactory.KClassImpl$Data$declaredNonStaticMembers$2(new ApiException(new Status(1)));
            return;
        }
        HiAnalyticsClient.reportExit(openDeviceHmsClient2.getContext(), getUri(), getTransactionId(), responseErrorCode.getStatusCode(), responseErrorCode.getErrorCode(), 60300305);
        if (responseErrorCode.getErrorCode() == 0) {
            HMSLog.i("OpenDeviceTaskApiCall", "onResult, success");
            OdidResp odidResp = new OdidResp();
            JsonUtil.jsonToEntity(str, odidResp);
            OdidResult odidResult = new OdidResult();
            odidResult.BuiltInFictitiousFunctionClassFactory = odidResp.getId();
            odidResult.setStatus(new Status(0));
            taskCompletionSource.MyBillsEntityDataFactory.KClassImpl$Data$declaredNonStaticMembers$2((com.huawei.hmf.tasks.a.i<OdidResult>) odidResult);
            return;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("onResult, returnCode: ");
        sb.append(responseErrorCode.getErrorCode());
        HMSLog.i("OpenDeviceTaskApiCall", sb.toString());
        taskCompletionSource.MyBillsEntityDataFactory.KClassImpl$Data$declaredNonStaticMembers$2(new ApiException(new Status(responseErrorCode.getErrorCode(), responseErrorCode.getErrorReason())));
    }

    @Override // com.huawei.hms.common.internal.TaskApiCall
    public int getApiLevel() {
        return 2;
    }

    @Override // com.huawei.hms.common.internal.TaskApiCall
    public int getMinApkVersion() {
        return 50002300;
    }
}
