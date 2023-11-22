package com.alibaba.griver.device.jsapi.phone.contact;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import com.alibaba.ariver.app.api.point.activity.ActivityResultPoint;
import com.alibaba.ariver.kernel.common.utils.RVLogger;
import id.dana.sendmoney.contact.provider.ContactProvider;

/* loaded from: classes6.dex */
public class ContactActivityResultPoint implements ActivityResultPoint {
    @Override // com.alibaba.ariver.kernel.api.extension.Extension
    public void onFinalized() {
    }

    @Override // com.alibaba.ariver.kernel.api.extension.Extension
    public void onInitialized() {
    }

    @Override // com.alibaba.ariver.app.api.point.activity.ActivityResultPoint
    public void onActivityResult(int i, int i2, Intent intent) {
        if (i == 10721) {
            if (i2 == -1) {
                try {
                    a(intent.getData());
                    return;
                } catch (SecurityException unused) {
                    ContactUtils.setResultAccount(new ContactAccount());
                    return;
                } catch (Exception unused2) {
                    ContactUtils.setResultAccount(new ContactAccount());
                    return;
                }
            }
            ContactUtils.setResultAccount(null);
        }
    }

    private void a(Uri uri) {
        Activity activity;
        Cursor query;
        ContactAccount contactAccount = new ContactAccount();
        if (uri != null && (activity = ContactUtils.getActivity()) != null && (query = activity.getContentResolver().query(uri, new String[]{ContactProvider.Column.PHONENUMBER, ContactProvider.Column.DISPLAY_NAME}, null, null, null)) != null) {
            try {
                if (query.moveToNext()) {
                    String string = query.getString(query.getColumnIndex(ContactProvider.Column.PHONENUMBER));
                    String string2 = query.getString(query.getColumnIndex(ContactProvider.Column.DISPLAY_NAME));
                    if (string != null) {
                        contactAccount.name = string2;
                        contactAccount.phoneNumber = string;
                    }
                }
            } catch (Throwable th) {
                StringBuilder sb = new StringBuilder();
                sb.append("processSystemContactCallback ");
                sb.append(uri);
                RVLogger.e("ContactActivityResultPoint", sb.toString(), th);
                if (query != null) {
                    query.close();
                }
            }
        }
        ContactUtils.setResultAccount(contactAccount);
    }
}
