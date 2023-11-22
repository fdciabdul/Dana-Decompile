package com.alibaba.griver.device.jsapi.auth;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.location.LocationManager;
import android.net.Uri;
import android.os.Build;
import android.text.TextUtils;
import com.alibaba.ariver.app.api.point.dialog.CreateDialogParam;
import com.alibaba.ariver.kernel.common.RVProxy;
import com.alibaba.ariver.kernel.common.service.RVEnvironmentService;
import com.alibaba.ariver.permission.api.extension.PermissionGuildePoint;
import com.alibaba.griver.api.jsapi.auth.GriverAuthGuideContentExtension;
import com.alibaba.griver.api.ui.dialog.GriverDialogExtension;
import com.alibaba.griver.base.common.env.GriverEnv;
import com.alibaba.griver.base.common.logger.GriverLogger;
import com.alibaba.griver.base.common.utils.PermissionUtils;
import com.alibaba.griver.device.R;
import id.dana.utils.permission.ManifestPermission;

/* loaded from: classes6.dex */
public class AuthGuideExtension implements PermissionGuildePoint {
    @Override // com.alibaba.ariver.kernel.api.extension.Extension
    public void onFinalized() {
    }

    @Override // com.alibaba.ariver.kernel.api.extension.Extension
    public void onInitialized() {
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.alibaba.ariver.permission.api.extension.PermissionGuildePoint
    public int startPermissionGuide(final String str, String str2) {
        String[] strArr;
        String str3;
        String str4;
        String str5;
        String str6;
        String str7;
        Context applicationContext = GriverEnv.getApplicationContext();
        boolean z = false;
        if (applicationContext == null || str == null) {
            return 0;
        }
        str.hashCode();
        char c = 65535;
        switch (str.hashCode()) {
            case -1382453013:
                if (str.equals("NOTIFICATION")) {
                    c = 0;
                    break;
                }
                break;
            case 75165:
                if (str.equals("LBS")) {
                    c = 1;
                    break;
                }
                break;
            case 76105234:
                if (str.equals("PHOTO")) {
                    c = 2;
                    break;
                }
                break;
            case 243470936:
                if (str.equals("LBSSERVICE")) {
                    c = 3;
                    break;
                }
                break;
            case 440126534:
                if (str.equals("SHORTCUT")) {
                    c = 4;
                    break;
                }
                break;
            case 776097981:
                if (str.equals("ADDRESSBOOK")) {
                    c = 5;
                    break;
                }
                break;
            case 1856013610:
                if (str.equals("MICROPHONE")) {
                    c = 6;
                    break;
                }
                break;
            case 1980544805:
                if (str.equals("CAMERA")) {
                    c = 7;
                    break;
                }
                break;
        }
        String str8 = "";
        String str9 = null;
        switch (c) {
            case 0:
                str8 = applicationContext.getString(R.string.griver_notification);
                strArr = null;
                break;
            case 1:
                strArr = new String[]{"android.permission.ACCESS_FINE_LOCATION", ManifestPermission.ACCESS_COARSE_LOCATION};
                str8 = applicationContext.getString(R.string.griver_location);
                break;
            case 2:
                if (Build.VERSION.SDK_INT >= 33) {
                    strArr = new String[]{"android.permission.READ_MEDIA_VIDEO", "android.permission.READ_MEDIA_IMAGES"};
                } else if (Build.VERSION.SDK_INT >= 30) {
                    strArr = new String[]{"android.permission.READ_EXTERNAL_STORAGE"};
                } else {
                    strArr = new String[]{"android.permission.READ_EXTERNAL_STORAGE", "android.permission.WRITE_EXTERNAL_STORAGE"};
                }
                str8 = applicationContext.getString(R.string.griver_device_storage);
                break;
            case 3:
                str8 = applicationContext.getString(R.string.griver_location_service);
                strArr = null;
                break;
            case 4:
                strArr = new String[]{"com.android.launcher.permission.INSTALL_SHORTCUT", "com.android.launcher.permission.UNINSTALL_SHORTCUT"};
                break;
            case 5:
                strArr = new String[]{"android.permission.READ_CONTACTS", "android.permission.WRITE_CONTACTS"};
                str8 = applicationContext.getString(R.string.griver_contact);
                break;
            case 6:
                str8 = applicationContext.getString(R.string.griver_microphone);
                strArr = new String[]{id.dana.util.permission.ManifestPermission.RECORD_AUDIO};
                break;
            case 7:
                strArr = new String[]{"android.permission.CAMERA"};
                str8 = applicationContext.getString(R.string.griver_camera);
                break;
            default:
                strArr = null;
                break;
        }
        if (TextUtils.equals(str, "LBSSERVICE")) {
            if (a(applicationContext)) {
                return 0;
            }
        } else if (a(strArr)) {
            return 0;
        }
        final Activity activity = ((RVEnvironmentService) RVProxy.get(RVEnvironmentService.class)).getTopActivity().get();
        if (TextUtils.isEmpty(str8) || activity == null) {
            return 0;
        }
        GriverAuthGuideContentExtension.AuthGuideContent authGuideContent = ((GriverAuthGuideContentExtension) RVProxy.get(GriverAuthGuideContentExtension.class)).getAuthGuideContent(str);
        String string = applicationContext.getString(R.string.griver_open_specific_permission, str8);
        String string2 = applicationContext.getString(R.string.griver_device_go_to_specific_permission, str8);
        String string3 = applicationContext.getString(R.string.griver_go_to_enable_permission);
        String string4 = applicationContext.getString(R.string.griver_base_cancel);
        if (authGuideContent != null) {
            String a2 = a(authGuideContent.title, string);
            String a3 = a(authGuideContent.message, string2);
            String a4 = a(authGuideContent.positiveButtonText, string3);
            String a5 = a(authGuideContent.negativeButtonText, string4);
            String a6 = a(authGuideContent.positiveButtonColor, null);
            str3 = a5;
            str4 = a3;
            str5 = a(authGuideContent.negativeButtonColor, null);
            str6 = a2;
            str7 = a4;
            str9 = a6;
            z = authGuideContent.cancelable;
        } else {
            str3 = string4;
            str4 = string2;
            str5 = null;
            str6 = string;
            str7 = string3;
        }
        CreateDialogParam createDialogParam = new CreateDialogParam(str6, str4, str7, str3, null);
        createDialogParam.positiveTextColor = str9;
        createDialogParam.negativeTextColor = str5;
        createDialogParam.cancelable = z;
        createDialogParam.positiveListener = new DialogInterface.OnClickListener() { // from class: com.alibaba.griver.device.jsapi.auth.AuthGuideExtension.1
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                if (TextUtils.equals("LBSSERVICE", str)) {
                    AuthGuideExtension.this.a(activity);
                } else {
                    AuthGuideExtension.this.b(activity);
                }
            }
        };
        Dialog createDialog = ((GriverDialogExtension) RVProxy.get(GriverDialogExtension.class)).createDialog(activity, createDialogParam);
        if (createDialog != null) {
            createDialog.show();
            ((GriverDialogExtension) RVProxy.get(GriverDialogExtension.class)).applyShow(createDialog, createDialogParam);
        }
        return 1;
    }

    private String a(String str, String str2) {
        return TextUtils.isEmpty(str) ? str2 : str;
    }

    private boolean a(Context context) {
        LocationManager locationManager = (LocationManager) context.getSystemService("location");
        if (locationManager == null || !locationManager.isProviderEnabled("gps")) {
            return false;
        }
        GriverLogger.d("TAG", "lbs service is enabled");
        return true;
    }

    private boolean a(String[] strArr) {
        if (strArr != null) {
            for (String str : strArr) {
                if (!PermissionUtils.hasPermission(str)) {
                    return false;
                }
            }
            return true;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Activity activity) {
        try {
            activity.startActivity(new Intent("android.settings.LOCATION_SOURCE_SETTINGS"));
        } catch (Exception e) {
            GriverLogger.e("TAG", "go to system setting failed", e);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(Activity activity) {
        Intent intent = new Intent("android.settings.APPLICATION_DETAILS_SETTINGS");
        intent.setData(Uri.fromParts("package", activity.getPackageName(), null));
        try {
            activity.startActivity(intent);
        } catch (Exception e) {
            GriverLogger.e("TAG", "go to app setting failed", e);
        }
    }
}
