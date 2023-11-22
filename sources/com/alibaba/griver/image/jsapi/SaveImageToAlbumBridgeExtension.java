package com.alibaba.griver.image.jsapi;

import android.app.Activity;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Build;
import android.text.TextUtils;
import com.alibaba.ariver.app.api.Page;
import com.alibaba.ariver.app.api.permission.IPermissionRequestCallback;
import com.alibaba.ariver.app.api.point.dialog.CreateDialogParam;
import com.alibaba.ariver.app.api.point.dialog.DialogPoint;
import com.alibaba.ariver.engine.api.bridge.extension.BridgeCallback;
import com.alibaba.ariver.engine.api.bridge.extension.BridgeResponse;
import com.alibaba.ariver.engine.api.bridge.extension.annotation.BindingCallback;
import com.alibaba.ariver.engine.api.bridge.extension.annotation.BindingNode;
import com.alibaba.ariver.engine.api.bridge.extension.annotation.BindingParam;
import com.alibaba.ariver.engine.api.bridge.extension.annotation.BindingRequest;
import com.alibaba.ariver.engine.api.extensions.resources.model.ResourceLoadContext;
import com.alibaba.ariver.engine.api.resources.Resource;
import com.alibaba.ariver.engine.api.resources.ResourceLoadPoint;
import com.alibaba.ariver.kernel.api.annotation.ActionFilter;
import com.alibaba.ariver.kernel.api.annotation.ThreadType;
import com.alibaba.ariver.kernel.api.extension.ExtensionPoint;
import com.alibaba.ariver.kernel.api.extension.bridge.BridgeExtension;
import com.alibaba.ariver.kernel.api.security.Permission;
import com.alibaba.ariver.kernel.common.service.executor.ExecutorType;
import com.alibaba.ariver.kernel.common.utils.ExecutorUtils;
import com.alibaba.ariver.kernel.common.utils.RVLogger;
import com.alibaba.griver.api.common.monitor.GriverMonitorConstants;
import com.alibaba.griver.base.common.env.GriverEnv;
import com.alibaba.griver.base.common.executor.GriverExecutors;
import com.alibaba.griver.base.common.monitor.GriverMonitor;
import com.alibaba.griver.base.common.monitor.MonitorManager;
import com.alibaba.griver.base.common.monitor.MonitorMap;
import com.alibaba.griver.base.common.utils.PermissionUtils;
import com.alibaba.griver.image.R;
import com.fullstory.instrumentation.InstrumentInjector;
import com.google.firebase.perf.network.FirebasePerfUrlConnection;
import java.io.InputStream;
import java.lang.ref.WeakReference;
import java.net.URL;
import java.net.URLConnection;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public class SaveImageToAlbumBridgeExtension implements BridgeExtension {
    public static final String TAG = "SaveImageToAlbumBridgeExtension";

    /* renamed from: a  reason: collision with root package name */
    private WeakReference<Activity> f6600a;

    @Override // com.alibaba.ariver.kernel.api.extension.Extension
    public void onFinalized() {
    }

    @Override // com.alibaba.ariver.kernel.api.extension.Extension
    public void onInitialized() {
    }

    @Override // com.alibaba.ariver.kernel.api.security.Guard
    public Permission permit() {
        return null;
    }

    @ThreadType(ExecutorType.UI)
    @ActionFilter
    public void saveImageToPhotosAlbum(@BindingParam({"filePath"}) String str, @BindingRequest JSONObject jSONObject, @BindingCallback BridgeCallback bridgeCallback) {
    }

    @ThreadType(ExecutorType.UI)
    @ActionFilter
    public void saveImage(@BindingNode(Page.class) final Page page, @BindingParam({"src"}) final String str, @BindingParam(booleanDefault = true, value = {"showActionSheet"}) boolean z, @BindingCallback final BridgeCallback bridgeCallback) {
        if (TextUtils.isEmpty(str)) {
            bridgeCallback.sendBridgeResponse(BridgeResponse.INVALID_PARAM);
        } else if (str.contains("../")) {
            bridgeCallback.sendBridgeResponse(BridgeResponse.INVALID_PARAM);
            StringBuilder sb = new StringBuilder();
            sb.append("Path invalid :");
            sb.append(str);
            RVLogger.w(TAG, sb.toString());
        } else {
            this.f6600a = new WeakReference<>(page.getPageContext().getActivity());
            if (z) {
                CreateDialogParam createDialogParam = new CreateDialogParam("", GriverEnv.getResources().getString(R.string.griver_image_save_to_phone), GriverEnv.getResources().getString(R.string.griver_base_confirm), GriverEnv.getResources().getString(R.string.griver_base_cancel), "");
                createDialogParam.positiveListener = new DialogInterface.OnClickListener() { // from class: com.alibaba.griver.image.jsapi.SaveImageToAlbumBridgeExtension.1
                    @Override // android.content.DialogInterface.OnClickListener
                    public void onClick(DialogInterface dialogInterface, int i) {
                        if (dialogInterface != null) {
                            dialogInterface.dismiss();
                        }
                        SaveImageToAlbumBridgeExtension.this.a(page, str, bridgeCallback);
                    }
                };
                createDialogParam.cancelListener = new DialogInterface.OnCancelListener() { // from class: com.alibaba.griver.image.jsapi.SaveImageToAlbumBridgeExtension.2
                    @Override // android.content.DialogInterface.OnCancelListener
                    public void onCancel(DialogInterface dialogInterface) {
                        if (dialogInterface != null) {
                            dialogInterface.dismiss();
                        }
                    }
                };
                Dialog createDialog = ((DialogPoint) ExtensionPoint.as(DialogPoint.class).create()).createDialog(page.getPageContext().getActivity(), createDialogParam);
                if (createDialog != null) {
                    createDialog.show();
                    return;
                }
                return;
            }
            a(page, str, bridgeCallback);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(final Page page, final String str, final BridgeCallback bridgeCallback) {
        String[] strArr;
        if (Build.VERSION.SDK_INT >= 33) {
            strArr = new String[]{"android.permission.READ_MEDIA_IMAGES"};
        } else if (Build.VERSION.SDK_INT >= 30) {
            strArr = new String[]{"android.permission.READ_EXTERNAL_STORAGE"};
        } else {
            strArr = new String[]{"android.permission.READ_EXTERNAL_STORAGE", "android.permission.WRITE_EXTERNAL_STORAGE"};
        }
        if (!PermissionUtils.hasPermission(strArr)) {
            PermissionUtils.requestPermissions(strArr, 2002, new IPermissionRequestCallback() { // from class: com.alibaba.griver.image.jsapi.SaveImageToAlbumBridgeExtension.3
                @Override // com.alibaba.ariver.app.api.permission.IPermissionRequestCallback
                public void onRequestPermissionResult(int i, String[] strArr2, int[] iArr) {
                    if (!PermissionUtils.positivePermissionResult(iArr) && bridgeCallback != null) {
                        com.alibaba.fastjson.JSONObject jSONObject = new com.alibaba.fastjson.JSONObject();
                        jSONObject.put("error", (Object) "17");
                        bridgeCallback.sendJSONResponse(jSONObject);
                        bridgeCallback.sendJSONResponse(jSONObject);
                        return;
                    }
                    GriverExecutors.getExecutor(ExecutorType.URGENT).execute(new ImageSaveRunner(page, str, bridgeCallback));
                }
            });
        } else {
            GriverExecutors.getExecutor(ExecutorType.URGENT).execute(new ImageSaveRunner(page, str, bridgeCallback));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class ImageSaveRunner implements Runnable {
        BridgeCallback callback;
        String filePath;
        Page page;
        String toastPath;
        String url;

        public ImageSaveRunner(Page page, String str, BridgeCallback bridgeCallback) {
            this.url = str;
            this.callback = bridgeCallback;
            this.page = page;
        }

        @Override // java.lang.Runnable
        public void run() {
            final boolean a2 = a();
            ExecutorUtils.runOnMain(new Runnable() { // from class: com.alibaba.griver.image.jsapi.SaveImageToAlbumBridgeExtension.ImageSaveRunner.1
                @Override // java.lang.Runnable
                public void run() {
                    if (SaveImageToAlbumBridgeExtension.this.f6600a == null || SaveImageToAlbumBridgeExtension.this.f6600a.get() == null) {
                        return;
                    }
                    if (a2) {
                        if (ImageSaveRunner.this.callback != null) {
                            ImageSaveRunner.this.callback.sendBridgeResponse(BridgeResponse.SUCCESS);
                        }
                    } else if (ImageSaveRunner.this.callback != null) {
                        com.alibaba.fastjson.JSONObject jSONObject = new com.alibaba.fastjson.JSONObject();
                        jSONObject.put("error", (Object) "17");
                        ImageSaveRunner.this.callback.sendJSONResponse(jSONObject);
                    }
                }
            });
        }

        private InputStream a(String str) {
            Resource load;
            if (this.page != null && (load = ((ResourceLoadPoint) ExtensionPoint.as(ResourceLoadPoint.class).node(this.page).create()).load(ResourceLoadContext.newBuilder().originUrl(str).build())) != null) {
                return load.getStream();
            }
            try {
                RVLogger.d(SaveImageToAlbumBridgeExtension.TAG, "load response from net");
                URLConnection uRLConnection = (URLConnection) FirebasePerfUrlConnection.instrument(InstrumentInjector.urlconnection_wrapInstance(new URL(str).openConnection()));
                uRLConnection.setConnectTimeout(10000);
                uRLConnection.setReadTimeout(10000);
                StringBuilder sb = new StringBuilder();
                sb.append("load response length ");
                sb.append(uRLConnection.getContentLength());
                RVLogger.d(SaveImageToAlbumBridgeExtension.TAG, sb.toString());
                return uRLConnection.getInputStream();
            } catch (Throwable th) {
                a(GriverMonitorConstants.MESSAGE_SAVE_IMAGE_HTTP_ERROR, th);
                StringBuilder sb2 = new StringBuilder();
                sb2.append("load response exception:");
                sb2.append(th.getMessage());
                RVLogger.e(SaveImageToAlbumBridgeExtension.TAG, sb2.toString());
                a(GriverMonitorConstants.MESSAGE_SAVE_IMAGE_HTTP_ERROR, null);
                return null;
            }
        }

        private void a(String str, Throwable th) {
            a(str, th, 0L);
        }

        private void a(String str, Throwable th, long j) {
            MonitorMap.Builder builder = new MonitorMap.Builder();
            Page page = this.page;
            if (page != null && page.getApp() != null) {
                builder.appId(this.page.getApp().getAppId()).version(this.page.getApp()).needAsynAppType(true);
            }
            if (j > 0) {
                builder.size(String.valueOf(j)).threshold(String.valueOf(MonitorManager.getThreshold(GriverMonitorConstants.ERROR_SAVE_IMAGE_EXCEPTION)));
            }
            builder.message(str).exception(th).url(this.url).requestUrl(this.url).pageUrl(this.page.getOriginalURI());
            GriverMonitor.error(GriverMonitorConstants.ERROR_SAVE_IMAGE_EXCEPTION, "GriverAppContainer", builder.build());
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Removed duplicated region for block: B:34:0x0092  */
        /* JADX WARN: Removed duplicated region for block: B:36:0x0099  */
        /* JADX WARN: Type inference failed for: r0v0, types: [java.lang.String] */
        /* JADX WARN: Type inference failed for: r0v11, types: [java.io.Closeable, java.io.InputStream] */
        /* JADX WARN: Type inference failed for: r0v2 */
        /* JADX WARN: Type inference failed for: r0v22 */
        /* JADX WARN: Type inference failed for: r0v23 */
        /* JADX WARN: Type inference failed for: r0v24 */
        /* JADX WARN: Type inference failed for: r0v25 */
        /* JADX WARN: Type inference failed for: r0v26 */
        /* JADX WARN: Type inference failed for: r0v4 */
        /* JADX WARN: Type inference failed for: r0v5 */
        /* JADX WARN: Type inference failed for: r0v6, types: [java.io.Closeable] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        private boolean a() {
            /*
                Method dump skipped, instructions count: 577
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: com.alibaba.griver.image.jsapi.SaveImageToAlbumBridgeExtension.ImageSaveRunner.a():boolean");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String a(String str, String str2) {
        int lastIndexOf = str2.lastIndexOf(".");
        return (lastIndexOf <= 0 || lastIndexOf >= str2.length()) ? str : str2.substring(lastIndexOf + 1);
    }
}
