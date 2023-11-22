package com.alibaba.ariver.app.api.permission;

import android.app.Activity;
import android.os.Build;
import androidx.collection.SparseArrayCompat;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: classes6.dex */
public class RVNativePermissionRequestManager implements RVNativePermissionRequestProxy {
    protected SparseArrayCompat<IPermissionRequestCallback> callbackArray = new SparseArrayCompat<>();
    protected AtomicInteger lastRequestCode = new AtomicInteger(1024);

    @Override // com.alibaba.ariver.app.api.permission.RVNativePermissionRequestProxy
    public void addPermRequstCallback(int i, IPermissionRequestCallback iPermissionRequestCallback) {
        SparseArrayCompat<IPermissionRequestCallback> sparseArrayCompat = this.callbackArray;
        if (sparseArrayCompat != null) {
            sparseArrayCompat.PlaceComponentResult(i, iPermissionRequestCallback);
        }
    }

    @Override // com.alibaba.ariver.app.api.permission.RVNativePermissionRequestProxy
    public void onRequestPermissionResult(int i, String[] strArr, int[] iArr) {
        IPermissionRequestCallback BuiltInFictitiousFunctionClassFactory;
        SparseArrayCompat<IPermissionRequestCallback> sparseArrayCompat = this.callbackArray;
        if (sparseArrayCompat == null || (BuiltInFictitiousFunctionClassFactory = sparseArrayCompat.BuiltInFictitiousFunctionClassFactory(i)) == null) {
            return;
        }
        BuiltInFictitiousFunctionClassFactory.onRequestPermissionResult(i, strArr, iArr);
        this.callbackArray.getAuthRequestContext(i);
    }

    @Override // com.alibaba.ariver.app.api.permission.RVNativePermissionRequestProxy
    public int getRequestCode() {
        return this.lastRequestCode.addAndGet(1) & 255;
    }

    @Override // com.alibaba.ariver.app.api.permission.RVNativePermissionRequestProxy
    public void requestPermissions(Activity activity, String[] strArr, int i) {
        if (Build.VERSION.SDK_INT < 23 || activity == null) {
            return;
        }
        activity.requestPermissions(strArr, i);
    }
}
