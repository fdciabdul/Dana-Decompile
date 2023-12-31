package com.alibaba.griver.core.extensions;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.webkit.GeolocationPermissions;
import androidx.core.app.ActivityCompat;
import com.alibaba.ariver.app.api.Page;
import com.alibaba.ariver.app.api.permission.IPermissionRequestCallback;
import com.alibaba.ariver.app.api.point.dialog.CreateDialogParam;
import com.alibaba.ariver.kernel.common.RVProxy;
import com.alibaba.griver.api.ui.dialog.GriverDialogExtension;
import com.alibaba.griver.api.webview.GriverGeoLocationExtension;
import com.alibaba.griver.base.common.env.GriverEnv;
import com.alibaba.griver.base.common.utils.PermissionUtils;
import com.alibaba.griver.core.R;

/* loaded from: classes6.dex */
public class GriverGeoLocationExtensionImpl implements GriverGeoLocationExtension {
    @Override // com.alibaba.griver.api.webview.GriverGeoLocationExtension
    public void onGeolocationPermissionsHidePrompt(Page page) {
    }

    @Override // com.alibaba.griver.api.webview.GriverGeoLocationExtension
    public void onGeolocationPermissionsShowPrompt(Page page, final String str, final GeolocationPermissions.Callback callback) {
        if (Build.VERSION.SDK_INT < 23 || GriverEnv.getApplicationContext().checkSelfPermission("android.permission.ACCESS_FINE_LOCATION") == 0) {
            callback.invoke(str, true, false);
            return;
        }
        final Activity activity = page.getPageContext().getActivity();
        if (ActivityCompat.MyBillsEntityDataFactory(activity, "android.permission.ACCESS_FINE_LOCATION")) {
            CreateDialogParam createDialogParam = new CreateDialogParam(activity.getString(R.string.griver_core_hint), activity.getString(R.string.griver_core_location_need_permission), activity.getString(R.string.griver_core_enable), activity.getString(R.string.griver_core_cancel), null);
            createDialogParam.positiveListener = new DialogInterface.OnClickListener() { // from class: com.alibaba.griver.core.extensions.GriverGeoLocationExtensionImpl.1
                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i) {
                    dialogInterface.dismiss();
                    Intent intent = new Intent();
                    intent.setAction("android.settings.APPLICATION_DETAILS_SETTINGS");
                    intent.setData(Uri.fromParts("package", activity.getPackageName(), null));
                    activity.startActivity(intent);
                    callback.invoke(str, false, false);
                }
            };
            createDialogParam.negativeListener = new DialogInterface.OnClickListener() { // from class: com.alibaba.griver.core.extensions.GriverGeoLocationExtensionImpl.2
                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i) {
                    dialogInterface.dismiss();
                    callback.invoke(str, false, false);
                }
            };
            ((GriverDialogExtension) RVProxy.get(GriverDialogExtension.class)).createDialog(activity, createDialogParam).show();
            return;
        }
        PermissionUtils.requestPermission("android.permission.ACCESS_FINE_LOCATION", 100, new IPermissionRequestCallback() { // from class: com.alibaba.griver.core.extensions.GriverGeoLocationExtensionImpl.3
            @Override // com.alibaba.ariver.app.api.permission.IPermissionRequestCallback
            public void onRequestPermissionResult(int i, String[] strArr, int[] iArr) {
                if (PermissionUtils.positivePermissionResult(iArr)) {
                    callback.invoke(str, true, false);
                } else {
                    callback.invoke(str, false, false);
                }
            }
        });
    }
}
