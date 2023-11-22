package com.huawei.hms.opendevice;

import android.content.Context;
import com.huawei.hms.aaid.constant.ErrorEnum;
import com.huawei.hms.aaid.entity.AAIDResult;
import java.util.concurrent.Callable;

/* loaded from: classes8.dex */
public class j implements Callable<AAIDResult> {
    public Context MyBillsEntityDataFactory;

    @Override // java.util.concurrent.Callable
    public /* synthetic */ AAIDResult call() throws Exception {
        Context context = this.MyBillsEntityDataFactory;
        if (context != null) {
            String MyBillsEntityDataFactory = o.MyBillsEntityDataFactory(context);
            AAIDResult aAIDResult = new AAIDResult();
            aAIDResult.setId(MyBillsEntityDataFactory);
            return aAIDResult;
        }
        throw ErrorEnum.ERROR_ARGUMENTS_INVALID.toApiException();
    }
}
