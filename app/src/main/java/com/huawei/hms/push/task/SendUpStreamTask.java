package com.huawei.hms.push.task;

import android.content.Intent;
import android.os.Bundle;
import com.google.firebase.messaging.Constants;
import com.huawei.hmf.tasks.TaskCompletionSource;
import com.huawei.hmf.tasks.a.i;
import com.huawei.hms.aaid.constant.ErrorEnum;
import com.huawei.hms.aaid.task.PushClient;
import com.huawei.hms.common.ApiException;
import com.huawei.hms.common.internal.ResponseErrorCode;
import com.huawei.hms.common.internal.TaskApiCall;
import com.huawei.hms.push.h;
import com.huawei.hms.push.utils.PushBiUtil;
import com.huawei.hms.support.api.client.Status;
import com.huawei.hms.support.log.HMSLog;

/* loaded from: classes8.dex */
public class SendUpStreamTask extends TaskApiCall<PushClient, BaseVoidTask> {
    public String MyBillsEntityDataFactory;
    public String getAuthRequestContext;

    @Override // com.huawei.hms.common.internal.TaskApiCall
    public /* synthetic */ void doExecute(PushClient pushClient, ResponseErrorCode responseErrorCode, String str, TaskCompletionSource<BaseVoidTask> taskCompletionSource) {
        PushClient pushClient2 = pushClient;
        if (responseErrorCode.getErrorCode() == 0) {
            HMSLog.i("SendUpStreamTask", "send up stream task,Operate succeed");
            taskCompletionSource.MyBillsEntityDataFactory.KClassImpl$Data$declaredNonStaticMembers$2((i<BaseVoidTask>) null);
        } else {
            StringBuilder sb = new StringBuilder();
            sb.append("send up stream task,Operate failed with ret=");
            sb.append(responseErrorCode.getErrorCode());
            HMSLog.e("SendUpStreamTask", sb.toString());
            ErrorEnum fromCode = ErrorEnum.fromCode(responseErrorCode.getErrorCode());
            if (fromCode != ErrorEnum.ERROR_UNKNOWN) {
                taskCompletionSource.MyBillsEntityDataFactory.KClassImpl$Data$declaredNonStaticMembers$2(fromCode.toApiException());
            } else {
                taskCompletionSource.MyBillsEntityDataFactory.KClassImpl$Data$declaredNonStaticMembers$2(new ApiException(new Status(responseErrorCode.getErrorCode(), responseErrorCode.getErrorReason())));
            }
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append("receive upstream, msgId :");
        sb2.append(this.getAuthRequestContext);
        sb2.append(" , packageName = ");
        sb2.append(this.MyBillsEntityDataFactory);
        sb2.append(" , errorCode = ");
        sb2.append(responseErrorCode.getErrorCode());
        HMSLog.i("SendUpStreamTask", sb2.toString());
        Intent intent = new Intent("com.huawei.push.action.MESSAGING_EVENT");
        intent.setPackage(this.MyBillsEntityDataFactory);
        Bundle bundle = new Bundle();
        bundle.putString(Constants.MessagePayloadKeys.MSGID_SERVER, this.getAuthRequestContext);
        bundle.putInt("error", responseErrorCode.getErrorCode());
        if (ErrorEnum.SUCCESS.getInternalCode() == responseErrorCode.getErrorCode()) {
            bundle.putString(Constants.MessagePayloadKeys.MESSAGE_TYPE, "sent_message");
        } else {
            bundle.putString(Constants.MessagePayloadKeys.MESSAGE_TYPE, Constants.MessageTypes.SEND_ERROR);
        }
        if (new h().MyBillsEntityDataFactory(pushClient2.getContext(), bundle, intent)) {
            HMSLog.i("SendUpStreamTask", "receive upstream, start service success");
            PushBiUtil.getAuthRequestContext(pushClient2.getContext(), getUri(), responseErrorCode);
            return;
        }
        HMSLog.w("SendUpStreamTask", "receive upstream, start service failed");
        PushBiUtil.BuiltInFictitiousFunctionClassFactory(pushClient2.getContext(), getUri(), responseErrorCode.getTransactionId(), ErrorEnum.ERROR_BIND_SERVICE_SELF_MAPPING);
    }

    @Override // com.huawei.hms.common.internal.TaskApiCall
    public int getMinApkVersion() {
        return 40003000;
    }
}
