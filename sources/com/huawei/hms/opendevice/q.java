package com.huawei.hms.opendevice;

import android.content.Context;
import com.huawei.hms.aaid.constant.ErrorEnum;
import com.huawei.hms.common.internal.ResponseErrorCode;
import com.huawei.hms.support.api.client.Status;
import com.huawei.hms.support.hianalytics.HiAnalyticsClient;

/* loaded from: classes8.dex */
public final class q {
    public static String KClassImpl$Data$declaredNonStaticMembers$2(Context context, String str) {
        return HiAnalyticsClient.reportEntry(context, str, 60300305);
    }

    public static void BuiltInFictitiousFunctionClassFactory(Context context, String str, ResponseErrorCode responseErrorCode) {
        HiAnalyticsClient.reportExit(context, str, responseErrorCode.getTransactionId(), responseErrorCode.getStatusCode(), responseErrorCode.getErrorCode(), 60300305);
    }

    public static void KClassImpl$Data$declaredNonStaticMembers$2(Context context, String str, String str2, ErrorEnum errorEnum) {
        HiAnalyticsClient.reportExit(context, str, str2, Status.SUCCESS.getStatusCode(), errorEnum.getExternalCode(), 60300305);
    }

    public static void MyBillsEntityDataFactory(Context context, String str, String str2, int i) {
        HiAnalyticsClient.reportExit(context, str, str2, Status.SUCCESS.getStatusCode(), i, 60300305);
    }
}
