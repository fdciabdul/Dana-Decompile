package com.huawei.hms.push.ups;

import com.huawei.hmf.tasks.OnCompleteListener;
import com.huawei.hmf.tasks.Task;
import com.huawei.hms.common.ApiException;
import com.huawei.hms.push.ups.entity.CodeResult;
import com.huawei.hms.push.ups.entity.UPSTurnCallBack;

/* loaded from: classes8.dex */
public final class UPSService {

    /* renamed from: com.huawei.hms.push.ups.UPSService$1  reason: invalid class name */
    /* loaded from: classes8.dex */
    public static final class AnonymousClass1 implements OnCompleteListener<Void> {
        public final /* synthetic */ UPSTurnCallBack PlaceComponentResult;

        @Override // com.huawei.hmf.tasks.OnCompleteListener
        public final void MyBillsEntityDataFactory(Task<Void> task) {
            if (task.MyBillsEntityDataFactory()) {
                new CodeResult();
                return;
            }
            ApiException apiException = (ApiException) task.BuiltInFictitiousFunctionClassFactory();
            new CodeResult(apiException.getStatusCode(), apiException.getMessage());
        }
    }

    /* renamed from: com.huawei.hms.push.ups.UPSService$2  reason: invalid class name */
    /* loaded from: classes8.dex */
    public static final class AnonymousClass2 implements OnCompleteListener<Void> {
        public final /* synthetic */ UPSTurnCallBack getAuthRequestContext;

        @Override // com.huawei.hmf.tasks.OnCompleteListener
        public final void MyBillsEntityDataFactory(Task<Void> task) {
            if (task.MyBillsEntityDataFactory()) {
                new CodeResult();
                return;
            }
            ApiException apiException = (ApiException) task.BuiltInFictitiousFunctionClassFactory();
            new CodeResult(apiException.getStatusCode(), apiException.getMessage());
        }
    }
}
