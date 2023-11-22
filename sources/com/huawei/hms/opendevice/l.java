package com.huawei.hms.opendevice;

import android.content.Context;
import android.text.TextUtils;
import com.huawei.hmf.tasks.TaskCompletionSource;
import com.huawei.hms.aaid.HmsInstanceId;
import com.huawei.hms.aaid.constant.ErrorEnum;
import com.huawei.hms.aaid.entity.TokenReq;
import com.huawei.hms.aaid.entity.TokenResp;
import com.huawei.hms.aaid.entity.TokenResult;
import com.huawei.hms.aaid.task.PushClient;
import com.huawei.hms.common.ApiException;
import com.huawei.hms.common.internal.ResponseErrorCode;
import com.huawei.hms.common.internal.TaskApiCall;
import com.huawei.hms.support.api.client.Status;
import com.huawei.hms.support.log.HMSLog;
import com.huawei.hms.utils.JsonUtil;

/* loaded from: classes8.dex */
public class l extends TaskApiCall<PushClient, TokenResult> {
    public TokenReq KClassImpl$Data$declaredNonStaticMembers$2;
    public Context MyBillsEntityDataFactory;

    public l(String str, TokenReq tokenReq, Context context, String str2) {
        super(str, JsonUtil.createJsonString(tokenReq), str2);
        this.MyBillsEntityDataFactory = context;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = tokenReq;
    }

    @Override // com.huawei.hms.common.internal.TaskApiCall
    public /* synthetic */ void doExecute(PushClient pushClient, ResponseErrorCode responseErrorCode, String str, TaskCompletionSource<TokenResult> taskCompletionSource) {
        PushClient pushClient2 = pushClient;
        if (responseErrorCode.getErrorCode() != 0) {
            String str2 = HmsInstanceId.KClassImpl$Data$declaredNonStaticMembers$2;
            StringBuilder sb = new StringBuilder();
            sb.append("TokenTask failed, ErrorCode:");
            sb.append(responseErrorCode.getErrorCode());
            HMSLog.e(str2, sb.toString());
            ErrorEnum fromCode = ErrorEnum.fromCode(responseErrorCode.getErrorCode());
            if (fromCode != ErrorEnum.ERROR_UNKNOWN) {
                taskCompletionSource.MyBillsEntityDataFactory.KClassImpl$Data$declaredNonStaticMembers$2(fromCode.toApiException());
            } else {
                taskCompletionSource.MyBillsEntityDataFactory.KClassImpl$Data$declaredNonStaticMembers$2(new ApiException(new Status(responseErrorCode.getErrorCode(), responseErrorCode.getErrorReason())));
            }
        } else {
            TokenResp tokenResp = (TokenResp) JsonUtil.jsonToEntity(str, new TokenResp());
            ErrorEnum fromCode2 = ErrorEnum.fromCode(tokenResp.getRetCode());
            if (fromCode2 != ErrorEnum.SUCCESS) {
                taskCompletionSource.MyBillsEntityDataFactory.KClassImpl$Data$declaredNonStaticMembers$2(fromCode2.toApiException());
                String str3 = HmsInstanceId.KClassImpl$Data$declaredNonStaticMembers$2;
                StringBuilder sb2 = new StringBuilder();
                sb2.append("TokenTask failed, StatusCode:");
                sb2.append(fromCode2.getExternalCode());
                HMSLog.e(str3, sb2.toString());
            } else {
                TokenResult tokenResult = new TokenResult();
                tokenResult.setToken(tokenResp.getToken());
                tokenResult.setBelongId(tokenResp.getBelongId());
                tokenResult.setRetCode(ErrorEnum.fromCode(tokenResp.getRetCode()).getExternalCode());
                taskCompletionSource.MyBillsEntityDataFactory.KClassImpl$Data$declaredNonStaticMembers$2((com.huawei.hmf.tasks.a.i<TokenResult>) tokenResult);
                String token = tokenResp.getToken();
                if (TextUtils.isEmpty(token)) {
                    HMSLog.i(HmsInstanceId.KClassImpl$Data$declaredNonStaticMembers$2, "GetTokenTask receive a empty token, please check HmsMessageService.onNewToken receive result.");
                } else {
                    String subjectId = this.KClassImpl$Data$declaredNonStaticMembers$2.getSubjectId();
                    if (!i.BuiltInFictitiousFunctionClassFactory(this.MyBillsEntityDataFactory).BuiltInFictitiousFunctionClassFactory(subjectId).equals(token)) {
                        HMSLog.i(HmsInstanceId.KClassImpl$Data$declaredNonStaticMembers$2, "receive a token, refresh the local token");
                        i.BuiltInFictitiousFunctionClassFactory(this.MyBillsEntityDataFactory).getAuthRequestContext(subjectId, token);
                    }
                    n.BuiltInFictitiousFunctionClassFactory(this.MyBillsEntityDataFactory, token);
                }
            }
        }
        q.BuiltInFictitiousFunctionClassFactory(pushClient2.getContext(), getUri(), responseErrorCode);
    }

    @Override // com.huawei.hms.common.internal.TaskApiCall
    public int getMinApkVersion() {
        return this.KClassImpl$Data$declaredNonStaticMembers$2.isMultiSender() ? 50004300 : 30000000;
    }
}
