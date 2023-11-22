package com.iap.ac.android.diagnoselog.a;

import com.alipay.iap.android.f2fpay.components.defaults.DefaultInitializeComponent;
import com.iap.ac.android.common.json.JsonUtils;
import com.iap.ac.android.common.rpc.RPCProxyHost;
import com.iap.ac.android.diagnoselog.api.OnLogUploadListener;
import com.iap.ac.android.diagnoselog.core.DiagnoseLogContext;
import com.iap.ac.android.diagnoselog.core.UserDiagnosing;
import com.iap.ac.android.diagnoselog.rpc.marmotconfig.DiagnoseTask;
import com.iap.ac.android.diagnoselog.rpc.marmotconfig.FetchMarmotConfigFacade;
import com.iap.ac.android.diagnoselog.rpc.marmotconfig.MarmotConfigRequest;
import com.iap.ac.android.diagnoselog.rpc.marmotconfig.MarmotConfigResult;
import com.iap.ac.android.loglite.utils.LoggerWrapper;
import java.util.Calendar;
import java.util.Date;

/* loaded from: classes8.dex */
public class b implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Date f7566a;
    public final /* synthetic */ OnLogUploadListener b;
    public final /* synthetic */ DiagnoseLogContext c;

    public b(DiagnoseLogContext diagnoseLogContext, Date date, OnLogUploadListener onLogUploadListener) {
        this.c = diagnoseLogContext;
        this.f7566a = date;
        this.b = onLogUploadListener;
    }

    @Override // java.lang.Runnable
    public void run() {
        MarmotConfigResult marmotConfigResult;
        Date date = this.f7566a;
        try {
            FetchMarmotConfigFacade fetchMarmotConfigFacade = (FetchMarmotConfigFacade) RPCProxyHost.getInterfaceProxy(FetchMarmotConfigFacade.class, "diagnoselog_biz");
            MarmotConfigRequest marmotConfigRequest = new MarmotConfigRequest();
            marmotConfigRequest.platform = DefaultInitializeComponent.PLATFORM_TYPE;
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(date);
            calendar.set(11, 0);
            calendar.set(12, 0);
            calendar.set(13, 0);
            calendar.set(14, 0);
            marmotConfigRequest.startTime = calendar.getTimeInMillis();
            calendar.add(10, 24);
            marmotConfigRequest.endTime = calendar.getTimeInMillis();
            marmotConfigResult = fetchMarmotConfigFacade.fetchMarmotConfig(marmotConfigRequest);
        } catch (Exception e) {
            LoggerWrapper.w("DiagnoseLogContext", e);
            marmotConfigResult = null;
        }
        if (marmotConfigResult != null && marmotConfigResult.success.booleanValue()) {
            DiagnoseLogContext diagnoseLogContext = this.c;
            UserDiagnosing userDiagnosing = new UserDiagnosing(diagnoseLogContext.d, diagnoseLogContext.c, this.b);
            Date date2 = this.f7566a;
            DiagnoseTask diagnoseTask = new DiagnoseTask();
            Calendar calendar2 = Calendar.getInstance();
            calendar2.setTime(date2);
            calendar2.set(11, 0);
            calendar2.set(12, 0);
            calendar2.set(13, 0);
            calendar2.set(14, 0);
            diagnoseTask.startTime = calendar2.getTimeInMillis();
            calendar2.add(10, 24);
            diagnoseTask.endTime = calendar2.getTimeInMillis();
            diagnoseTask.taskId = marmotConfigResult.taskId;
            diagnoseTask.uploadUrl = marmotConfigResult.uploadUrl;
            DiagnoseTask.UploadParams uploadParams = new DiagnoseTask.UploadParams();
            diagnoseTask.uploadParams = uploadParams;
            uploadParams.OSSAccessKeyId = marmotConfigResult.OSSAccessKeyId;
            uploadParams.Signature = marmotConfigResult.Signature;
            uploadParams.key = marmotConfigResult.key;
            uploadParams.policy = marmotConfigResult.policy;
            userDiagnosing.a(JsonUtils.toJson(diagnoseTask));
            return;
        }
        OnLogUploadListener onLogUploadListener = this.b;
        if (onLogUploadListener != null) {
            onLogUploadListener.onFinished(false, "");
        }
    }
}
