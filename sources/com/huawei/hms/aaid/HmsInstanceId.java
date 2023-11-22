package com.huawei.hms.aaid;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.huawei.hmf.tasks.Tasks;
import com.huawei.hms.aaid.constant.ErrorEnum;
import com.huawei.hms.aaid.entity.TokenReq;
import com.huawei.hms.aaid.entity.TokenResult;
import com.huawei.hms.aaid.plugin.ProxyCenter;
import com.huawei.hms.aaid.plugin.PushProxy;
import com.huawei.hms.aaid.task.PushClientBuilder;
import com.huawei.hms.aaid.utils.PushPreferences;
import com.huawei.hms.api.Api;
import com.huawei.hms.api.HuaweiApiAvailability;
import com.huawei.hms.common.ApiException;
import com.huawei.hms.common.HuaweiApi;
import com.huawei.hms.common.internal.Preconditions;
import com.huawei.hms.opendevice.c;
import com.huawei.hms.opendevice.i;
import com.huawei.hms.opendevice.l;
import com.huawei.hms.opendevice.p;
import com.huawei.hms.opendevice.q;
import com.huawei.hms.support.api.client.Status;
import com.huawei.hms.support.hianalytics.HiAnalyticsClient;
import com.huawei.hms.support.log.HMSLog;

/* loaded from: classes7.dex */
public class HmsInstanceId {
    public static final String KClassImpl$Data$declaredNonStaticMembers$2 = "HmsInstanceId";
    public HuaweiApi<Api.ApiOptions.NoOptions> MyBillsEntityDataFactory;
    public Context PlaceComponentResult;
    public PushPreferences getAuthRequestContext;

    private HmsInstanceId(Context context) {
        this.PlaceComponentResult = context.getApplicationContext();
        this.getAuthRequestContext = new PushPreferences(context, "aaid");
        HuaweiApi<Api.ApiOptions.NoOptions> huaweiApi = new HuaweiApi<>(context, new Api(HuaweiApiAvailability.HMS_API_NAME_PUSH), (Api.ApiOptions) null, new PushClientBuilder());
        this.MyBillsEntityDataFactory = huaweiApi;
        huaweiApi.setKitSdkVersion(60300305);
    }

    public static HmsInstanceId getAuthRequestContext(Context context) {
        Preconditions.checkNotNull(context);
        c.PlaceComponentResult(context);
        return new HmsInstanceId(context);
    }

    public final String MyBillsEntityDataFactory(TokenReq tokenReq) throws ApiException {
        PushProxy pushProxy;
        String reportEntry;
        PushProxy unused;
        pushProxy = ProxyCenter.a.getAuthRequestContext.KClassImpl$Data$declaredNonStaticMembers$2;
        if (pushProxy != null) {
            HMSLog.i(KClassImpl$Data$declaredNonStaticMembers$2, "use proxy get token, please check HmsMessageService.onNewToken receive result.");
            unused = ProxyCenter.a.getAuthRequestContext.KClassImpl$Data$declaredNonStaticMembers$2;
            tokenReq.getSubjectId();
            return null;
        }
        String subjectId = tokenReq.getSubjectId();
        if (!TextUtils.isEmpty(subjectId)) {
            if (!p.MyBillsEntityDataFactory(this.PlaceComponentResult)) {
                i.BuiltInFictitiousFunctionClassFactory(this.PlaceComponentResult).MyBillsEntityDataFactory("subjectId");
            } else {
                SharedPreferences sharedPreferences = i.BuiltInFictitiousFunctionClassFactory(this.PlaceComponentResult).getAuthRequestContext;
                String string = sharedPreferences != null ? sharedPreferences.getString("subjectId", "") : "";
                if (TextUtils.isEmpty(string)) {
                    i.BuiltInFictitiousFunctionClassFactory(this.PlaceComponentResult).MyBillsEntityDataFactory("subjectId", subjectId);
                } else if (!string.contains(subjectId)) {
                    i BuiltInFictitiousFunctionClassFactory = i.BuiltInFictitiousFunctionClassFactory(this.PlaceComponentResult);
                    StringBuilder sb = new StringBuilder();
                    sb.append(string);
                    sb.append(",");
                    sb.append(subjectId);
                    BuiltInFictitiousFunctionClassFactory.MyBillsEntityDataFactory("subjectId", sb.toString());
                }
            }
        }
        reportEntry = HiAnalyticsClient.reportEntry(this.PlaceComponentResult, "push.gettoken", 60300305);
        try {
            String str = KClassImpl$Data$declaredNonStaticMembers$2;
            StringBuilder sb2 = new StringBuilder();
            sb2.append("getToken req :");
            sb2.append(tokenReq.toString());
            HMSLog.d(str, sb2.toString());
            l lVar = new l("push.gettoken", tokenReq, this.PlaceComponentResult, reportEntry);
            lVar.setApiLevel(1);
            return ((TokenResult) Tasks.KClassImpl$Data$declaredNonStaticMembers$2(this.MyBillsEntityDataFactory.doWrite(lVar))).getToken();
        } catch (Exception e) {
            if (!(e.getCause() instanceof ApiException)) {
                HiAnalyticsClient.reportExit(this.PlaceComponentResult, "push.gettoken", reportEntry, Status.SUCCESS.getStatusCode(), ErrorEnum.ERROR_INTERNAL_ERROR.getExternalCode(), 60300305);
                throw ErrorEnum.ERROR_INTERNAL_ERROR.toApiException();
            }
            ApiException apiException = (ApiException) e.getCause();
            q.MyBillsEntityDataFactory(this.PlaceComponentResult, "push.gettoken", reportEntry, apiException.getStatusCode());
            throw apiException;
        }
    }
}
