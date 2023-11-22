package com.alibaba.griver.h5.extension;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.database.Cursor;
import android.net.Uri;
import android.text.TextUtils;
import android.webkit.ValueCallback;
import android.webkit.WebChromeClient;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import com.alibaba.ariver.app.api.Page;
import com.alibaba.ariver.kernel.common.RVProxy;
import com.alibaba.ariver.kernel.common.service.RVEnvironmentService;
import com.alibaba.ariver.kernel.common.utils.BundleUtils;
import com.alibaba.ariver.kernel.common.utils.ProcessUtils;
import com.alibaba.ariver.kernel.common.utils.RVLogger;
import com.alibaba.griver.api.h5.file.GriverChooseFileExtension;
import com.alibaba.griver.base.common.config.GriverConfig;
import com.alibaba.griver.core.render.NXWebChromeClient;
import com.alibaba.griver.core.ui.activity.GriverFileChooserActivity;
import com.alibaba.griver.file.jsapi.ChooseFileBridgeExtension;
import id.dana.danah5.constant.BridgeName;

/* loaded from: classes6.dex */
public class GriverChooseFileExtensionImpl implements GriverChooseFileExtension {

    /* renamed from: a  reason: collision with root package name */
    private BroadcastReceiver f6545a;

    @Override // com.alibaba.griver.api.h5.file.GriverChooseFileExtension
    public void openFileChooser(Page page, ValueCallback<Uri> valueCallback, String str, String str2) {
        a(page, valueCallback, new String[]{str}, str2, false, false);
    }

    @Override // com.alibaba.griver.api.h5.file.GriverChooseFileExtension
    public boolean onShowFileChooser(Page page, ValueCallback<Uri[]> valueCallback, WebChromeClient.FileChooserParams fileChooserParams) {
        return a(page, valueCallback, fileChooserParams.getAcceptTypes(), fileChooserParams.isCaptureEnabled() ? BridgeName.CAPTURE : null, fileChooserParams.getMode() == 1, true);
    }

    private boolean a(Page page, final ValueCallback valueCallback, String[] strArr, String str, boolean z, final boolean z2) {
        if (page != null && page.getRender() != null && page.getRender().getView() != null && page.getPageContext() != null) {
            try {
                final Activity activity = page.getPageContext().getActivity();
                if (activity == null) {
                    return false;
                }
                final LocalBroadcastManager localBroadcastManager = LocalBroadcastManager.getInstance(((RVEnvironmentService) RVProxy.get(RVEnvironmentService.class)).getApplicationContext());
                IntentFilter intentFilter = new IntentFilter();
                intentFilter.addAction(NXWebChromeClient.FILE_CHOOSER_RESULT);
                BroadcastReceiver broadcastReceiver = this.f6545a;
                if (broadcastReceiver != null) {
                    localBroadcastManager.unregisterReceiver(broadcastReceiver);
                    this.f6545a = null;
                }
                BroadcastReceiver broadcastReceiver2 = new BroadcastReceiver() { // from class: com.alibaba.griver.h5.extension.GriverChooseFileExtensionImpl.1
                    @Override // android.content.BroadcastReceiver
                    public void onReceive(Context context, Intent intent) {
                        LocalBroadcastManager localBroadcastManager2;
                        if (intent == null || intent.getAction() == null || intent.getExtras() == null || (localBroadcastManager2 = localBroadcastManager) == null) {
                            return;
                        }
                        localBroadcastManager2.unregisterReceiver(this);
                        Cursor cursor = null;
                        GriverChooseFileExtensionImpl.this.f6545a = null;
                        String action = intent.getAction();
                        StringBuilder sb = new StringBuilder();
                        sb.append("onReceive action ");
                        sb.append(action);
                        RVLogger.d("GriverChooseFileExtensionImpl", sb.toString());
                        if (NXWebChromeClient.FILE_CHOOSER_RESULT.equals(action)) {
                            try {
                                Uri[] uriArr = (Uri[]) intent.getExtras().get(ChooseFileBridgeExtension.CHOOSE_FILE_RESULT_DATA_KEY);
                                Uri[] uriArr2 = uriArr;
                                if (uriArr == null) {
                                    uriArr2 = new Uri[]{Uri.parse("")};
                                }
                                Activity activity2 = activity;
                                if (activity2 != null && !activity2.isFinishing() && uriArr2 != null) {
                                    for (Uri uri : uriArr2) {
                                        cursor = activity.getContentResolver().query(uri, null, null, null, null);
                                        StringBuilder sb2 = new StringBuilder();
                                        sb2.append("onReceive result ");
                                        sb2.append(uri);
                                        RVLogger.d("GriverChooseFileExtensionImpl", sb2.toString());
                                    }
                                }
                                ValueCallback valueCallback2 = valueCallback;
                                if (valueCallback2 != null) {
                                    Uri[] uriArr3 = uriArr2;
                                    if (!z2) {
                                        uriArr3 = uriArr2[0];
                                    }
                                    valueCallback2.onReceiveValue(uriArr3);
                                }
                                if (cursor == null) {
                                    return;
                                }
                            } catch (Throwable th) {
                                try {
                                    RVLogger.e("GriverChooseFileExtensionImpl", "exception detail", th);
                                    Uri parse = Uri.parse("");
                                    Uri[] uriArr4 = {parse};
                                    ValueCallback valueCallback3 = valueCallback;
                                    if (valueCallback3 != null) {
                                        if (!z2) {
                                            uriArr4 = parse;
                                        }
                                        valueCallback3.onReceiveValue(uriArr4);
                                    }
                                    if (cursor == null) {
                                        return;
                                    }
                                } catch (Throwable th2) {
                                    if (cursor != null) {
                                        cursor.close();
                                    }
                                    throw th2;
                                }
                            }
                            cursor.close();
                        }
                    }
                };
                this.f6545a = broadcastReceiver2;
                localBroadcastManager.registerReceiver(broadcastReceiver2, intentFilter);
                Intent intent = new Intent(activity, GriverFileChooserActivity.class);
                intent.putExtra("acceptType", strArr);
                intent.putExtra(BridgeName.CAPTURE, str);
                intent.putExtra("multiple", z);
                if (ProcessUtils.isTinyProcess() && !"yes".equalsIgnoreCase(GriverConfig.getConfig("h5_notSupportTinyChooseFile", ""))) {
                    String string = BundleUtils.getString(page.getStartParams(), "appId");
                    if (TextUtils.isEmpty(string)) {
                        string = BundleUtils.getString(page.getStartParams(), "MINI-PROGRAM-WEB-VIEW-TAG");
                    }
                    if (!TextUtils.isEmpty(string)) {
                        intent.putExtra("appId", string);
                    }
                }
                activity.startActivity(intent);
                return true;
            } catch (ActivityNotFoundException e) {
                RVLogger.e("GriverChooseFileExtensionImpl", "exception detail", e);
                return false;
            } catch (ClassCastException e2) {
                RVLogger.e("GriverChooseFileExtensionImpl", "exception detail", e2);
            } catch (Exception e3) {
                RVLogger.e("GriverChooseFileExtensionImpl", "exception detail", e3);
                return false;
            }
        }
        return false;
    }
}
