package com.huawei.hms.push.task;

import android.content.Context;
import android.content.Intent;
import com.huawei.hms.aaid.constant.ErrorEnum;
import com.huawei.hms.push.utils.PushBiUtil;
import com.huawei.hms.support.api.entity.push.PushNaming;
import java.util.concurrent.Callable;

/* loaded from: classes8.dex */
public class IntentCallable implements Callable<Void> {
    public String MyBillsEntityDataFactory;
    public Context PlaceComponentResult;
    public Intent getAuthRequestContext;

    @Override // java.util.concurrent.Callable
    public /* synthetic */ Void call() throws Exception {
        this.PlaceComponentResult.sendBroadcast(this.getAuthRequestContext);
        PushBiUtil.BuiltInFictitiousFunctionClassFactory(this.PlaceComponentResult, PushNaming.SET_NOTIFY_FLAG, this.MyBillsEntityDataFactory, ErrorEnum.SUCCESS);
        return null;
    }
}
