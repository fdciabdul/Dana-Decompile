package com.alibaba.griver.device.jsapi.phone.contact;

import android.app.Activity;
import android.content.Intent;
import android.provider.ContactsContract;
import com.alibaba.ariver.app.api.App;
import com.alibaba.ariver.app.api.permission.IPermissionRequestCallback;
import com.alibaba.ariver.kernel.common.RVProxy;
import com.alibaba.ariver.kernel.common.service.RVEnvironmentService;
import com.alibaba.ariver.kernel.common.utils.RVLogger;
import com.alibaba.griver.base.common.utils.PermissionUtils;

/* loaded from: classes2.dex */
public class ContactUtils {
    public static final int REQUEST_CODE_CONTACTS = 10721;

    /* renamed from: a  reason: collision with root package name */
    private static ContactPickerCallback f6514a;

    public static void setResultAccount(ContactAccount contactAccount) {
        ContactPickerCallback contactPickerCallback = f6514a;
        if (contactPickerCallback != null) {
            contactPickerCallback.onAccountReturned(contactAccount);
        }
        f6514a = null;
    }

    public static void pickFromContactsList(App app, final ContactPickerCallback contactPickerCallback) {
        RVLogger.d("ContactUtils", "pickFromContactsList");
        final Activity activity = getActivity();
        if (activity == null) {
            return;
        }
        if (!PermissionUtils.hasPermission("android.permission.READ_CONTACTS")) {
            PermissionUtils.requestPermission("android.permission.READ_CONTACTS", 3001, new IPermissionRequestCallback() { // from class: com.alibaba.griver.device.jsapi.phone.contact.ContactUtils.1
                @Override // com.alibaba.ariver.app.api.permission.IPermissionRequestCallback
                public final void onRequestPermissionResult(int i, String[] strArr, int[] iArr) {
                    if (PermissionUtils.positivePermissionResult(iArr)) {
                        ContactUtils.a(activity, contactPickerCallback);
                        return;
                    }
                    RVLogger.d("ContactUtils", "no permission to read contact");
                    contactPickerCallback.onAccountReturned(null);
                }
            });
        } else {
            a(activity, contactPickerCallback);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void a(Activity activity, ContactPickerCallback contactPickerCallback) {
        try {
            Intent intent = new Intent("android.intent.action.PICK", ContactsContract.CommonDataKinds.Phone.CONTENT_URI);
            intent.setFlags(67108864);
            activity.startActivityForResult(intent, REQUEST_CODE_CONTACTS);
            f6514a = contactPickerCallback;
        } catch (Exception e) {
            RVLogger.e("ContactUtils", e);
        }
    }

    public static Activity getActivity() {
        RVEnvironmentService rVEnvironmentService = (RVEnvironmentService) RVProxy.get(RVEnvironmentService.class);
        if (rVEnvironmentService == null) {
            RVLogger.e("ContactUtils", "RVEnvironmentService is null");
            return null;
        }
        Activity activity = rVEnvironmentService.getTopActivity() != null ? rVEnvironmentService.getTopActivity().get() : null;
        if (activity == null) {
            RVLogger.e("ContactUtils", "activity is null");
        }
        return activity;
    }
}
