package com.alibaba.griver.device.jsapi.screen;

import android.app.Activity;
import android.content.ContentResolver;
import android.content.ContentValues;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.media.MediaScannerConnection;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.provider.MediaStore;
import android.text.TextUtils;
import android.view.View;
import com.alibaba.ariver.app.api.Page;
import com.alibaba.ariver.app.api.permission.IPermissionRequestCallback;
import com.alibaba.ariver.app.api.point.biz.SnapshotPoint;
import com.alibaba.ariver.engine.api.Render;
import com.alibaba.ariver.engine.api.bridge.extension.BridgeCallback;
import com.alibaba.ariver.engine.api.bridge.extension.BridgeResponse;
import com.alibaba.ariver.engine.api.bridge.extension.annotation.BindingCallback;
import com.alibaba.ariver.engine.api.bridge.extension.annotation.BindingNode;
import com.alibaba.ariver.engine.api.bridge.extension.annotation.BindingParam;
import com.alibaba.ariver.kernel.api.annotation.ActionFilter;
import com.alibaba.ariver.kernel.api.annotation.ThreadType;
import com.alibaba.ariver.kernel.api.extension.ExtensionPoint;
import com.alibaba.ariver.kernel.api.extension.bridge.BridgeExtension;
import com.alibaba.ariver.kernel.api.security.Permission;
import com.alibaba.ariver.kernel.common.RVProxy;
import com.alibaba.ariver.kernel.common.service.executor.ExecutorType;
import com.alibaba.ariver.kernel.common.utils.FileUtils;
import com.alibaba.ariver.kernel.common.utils.RVLogger;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.griver.base.common.env.GriverEnv;
import com.alibaba.griver.base.common.executor.GriverExecutors;
import com.alibaba.griver.base.common.logger.GriverLogger;
import com.alibaba.griver.base.common.utils.AndroidVersionUtils;
import com.alibaba.griver.base.common.utils.ImageUtils;
import com.alibaba.griver.base.common.utils.PermissionUtils;
import com.alibaba.griver.base.common.utils.ToastUtils;
import com.alibaba.griver.device.R;
import com.alibaba.griver.device.proxy.GriverImagePathProxy;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.lang.ref.WeakReference;

/* loaded from: classes2.dex */
public class SnapshotBridgeExtension implements BridgeExtension {
    private static final String DATAURL = "dataURL";
    private static final String FILEURL = "fileURL";
    private static final String RANGE_DOCUMENT = "document";
    private static final String RANGE_EMBEDVIEW = "embedview";
    private static final String RANGE_SCREEN = "screen";
    private static final String RANGE_VIEWPORT = "viewport";
    private static final int REQUEST_READ_EXTERNAL_STORAGE_PERMISSION = 2001;
    private static final String SNOPSHOT_JPG = "jpg";
    public static final String TAG = "SnapshotBridgeExtension";
    private String imagePath;

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
    public void snapshot(@BindingNode(Page.class) Page page, @BindingParam(intDefault = -1, value = {"maxWidth"}) int i, @BindingParam(intDefault = -1, value = {"maxHeight"}) int i2, @BindingParam(stringDefault = "screen", value = {"range"}) String str, @BindingParam(booleanDefault = true, value = {"handleSaveToGallery"}) boolean z, @BindingParam(stringDefault = "none", value = {"dataType"}) String str2, @BindingParam(stringDefault = "jpg", value = {"imageFormat"}) String str3, @BindingParam(intDefault = 75, value = {"quality"}) int i3, @BindingParam({"hasMapTitleBar"}) boolean z2, @BindingCallback BridgeCallback bridgeCallback) {
        Bitmap bitmap;
        Bitmap captureNXView;
        if (page == null) {
            return;
        }
        Activity activity = page.getPageContext() != null ? page.getPageContext().getActivity() : null;
        JSONObject jSONObject = new JSONObject();
        if (TextUtils.equals(str, RANGE_SCREEN)) {
            captureNXView = captureScreen(activity);
        } else if (TextUtils.equals(str, RANGE_VIEWPORT)) {
            if (page.getRender() != null) {
                captureNXView = captureNXView(0, page.getRender(), activity);
            } else {
                bridgeCallback.sendBridgeResponse(new BridgeResponse.Error(2, "no webview"));
                return;
            }
        } else if (TextUtils.equals(str, "document")) {
            if (page.getRender() != null) {
                captureNXView = captureNXView(1, page.getRender(), activity);
            } else {
                bridgeCallback.sendBridgeResponse(new BridgeResponse.Error(2, "no webview"));
                return;
            }
        } else if (TextUtils.equals(str, RANGE_EMBEDVIEW)) {
            captureEmbedView(page, activity, bridgeCallback, jSONObject, i, i2, z, str2, str3, i3, z2);
            return;
        } else {
            bitmap = null;
            handleSnapshot(bridgeCallback, activity, jSONObject, i, i2, z, str2, str3, i3, bitmap);
        }
        bitmap = captureNXView;
        handleSnapshot(bridgeCallback, activity, jSONObject, i, i2, z, str2, str3, i3, bitmap);
    }

    @ActionFilter
    public void addScreenshotListener(@BindingNode(Page.class) final Page page, @BindingCallback final BridgeCallback bridgeCallback) {
        String[] strArr;
        WeakReference<Activity> topActivity = GriverEnv.getTopActivity();
        if (topActivity == null || topActivity.get() == null) {
            bridgeCallback.sendBridgeResponse(BridgeResponse.UNKNOWN_ERROR);
            return;
        }
        if (Build.VERSION.SDK_INT >= 33) {
            strArr = new String[]{"android.permission.READ_MEDIA_IMAGES"};
        } else if (Build.VERSION.SDK_INT >= 30) {
            strArr = new String[]{"android.permission.READ_EXTERNAL_STORAGE"};
        } else {
            strArr = new String[]{"android.permission.READ_EXTERNAL_STORAGE", "android.permission.WRITE_EXTERNAL_STORAGE"};
        }
        if (!PermissionUtils.hasPermission(strArr)) {
            PermissionUtils.requestPermissions(strArr, 2001, new IPermissionRequestCallback() { // from class: com.alibaba.griver.device.jsapi.screen.SnapshotBridgeExtension.1
                @Override // com.alibaba.ariver.app.api.permission.IPermissionRequestCallback
                public void onRequestPermissionResult(int i, String[] strArr2, int[] iArr) {
                    if (PermissionUtils.positivePermissionResult(iArr)) {
                        SnapshotBridgeExtension.this.startListenScreenshot(page, bridgeCallback);
                    } else {
                        bridgeCallback.sendBridgeResponse(BridgeResponse.UNKNOWN_ERROR);
                    }
                }
            });
        } else {
            startListenScreenshot(page, bridgeCallback);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void startListenScreenshot(Page page, BridgeCallback bridgeCallback) {
        ((SnapshotPoint) ExtensionPoint.as(SnapshotPoint.class).node(page).create()).addScreenshotListener(page);
        bridgeCallback.sendBridgeResponse(BridgeResponse.SUCCESS);
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x0049  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x00a5  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void handleSnapshot(final com.alibaba.ariver.engine.api.bridge.extension.BridgeCallback r12, final android.app.Activity r13, final com.alibaba.fastjson.JSONObject r14, int r15, int r16, boolean r17, final java.lang.String r18, final java.lang.String r19, int r20, android.graphics.Bitmap r21) {
        /*
            Method dump skipped, instructions count: 211
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.griver.device.jsapi.screen.SnapshotBridgeExtension.handleSnapshot(com.alibaba.ariver.engine.api.bridge.extension.BridgeCallback, android.app.Activity, com.alibaba.fastjson.JSONObject, int, int, boolean, java.lang.String, java.lang.String, int, android.graphics.Bitmap):void");
    }

    private void handleSave(final BridgeCallback bridgeCallback, JSONObject jSONObject, String str, final String str2, final Bitmap bitmap) {
        if (FILEURL.equals(str)) {
            String imageTempDir = ImageUtils.getImageTempDir(GriverEnv.getApplicationContext());
            StringBuilder sb = new StringBuilder();
            sb.append(System.currentTimeMillis());
            sb.append(".");
            sb.append(str2);
            String obj = sb.toString();
            FileUtils.mkdirs(imageTempDir, true);
            Bitmap.CompressFormat compressFormat = str2.equals("jpg") ? Bitmap.CompressFormat.JPEG : Bitmap.CompressFormat.PNG;
            StringBuilder sb2 = new StringBuilder();
            sb2.append(imageTempDir);
            sb2.append(obj);
            ImageUtils.writeImage(bitmap, compressFormat, sb2.toString());
            StringBuilder sb3 = new StringBuilder();
            sb3.append(imageTempDir);
            sb3.append(obj);
            if (!FileUtils.exists(sb3.toString())) {
                jSONObject.put("success", (Object) Boolean.FALSE);
                jSONObject.put("error", (Object) 11);
                jSONObject.put("errorMessage", (Object) GriverEnv.getResources().getString(R.string.griver_save_pic_failed));
            } else {
                jSONObject.put("success", (Object) Boolean.TRUE);
                StringBuilder sb4 = new StringBuilder();
                sb4.append(imageTempDir);
                sb4.append(obj);
                jSONObject.put(FILEURL, (Object) sb4.toString());
            }
            bridgeCallback.sendJSONResponse(jSONObject);
            if (bitmap == null || bitmap.isRecycled()) {
                return;
            }
            bitmap.recycle();
        } else if (DATAURL.equals(str)) {
            GriverExecutors.getExecutor(ExecutorType.URGENT).execute(new Runnable() { // from class: com.alibaba.griver.device.jsapi.screen.SnapshotBridgeExtension.3
                @Override // java.lang.Runnable
                public void run() {
                    String bitmapToString = ImageUtils.bitmapToString(bitmap, str2);
                    JSONObject jSONObject2 = new JSONObject();
                    jSONObject2.put(SnapshotBridgeExtension.DATAURL, (Object) bitmapToString);
                    jSONObject2.put("success", (Object) Boolean.TRUE);
                    bridgeCallback.sendJSONResponse(jSONObject2);
                    Bitmap bitmap2 = bitmap;
                    if (bitmap2 != null) {
                        bitmap2.recycle();
                    }
                }
            });
        } else {
            bridgeCallback.sendBridgeResponse(BridgeResponse.SUCCESS);
            if (bitmap == null || bitmap.isRecycled()) {
                return;
            }
            bitmap.recycle();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleSaveToGallery(BridgeCallback bridgeCallback, Activity activity, JSONObject jSONObject, String str, String str2, Bitmap bitmap) {
        String string;
        int saveImageToGallery = saveImageToGallery(bitmap, str2);
        if (saveImageToGallery == 0) {
            if (activity != null && !activity.isFinishing()) {
                String string2 = GriverEnv.getResources().getString(R.string.griver_save_image_to, this.imagePath);
                StringBuilder sb = new StringBuilder();
                sb.append("save to gallery success: ");
                sb.append(string2);
                GriverLogger.d("SnapshotBridgeExtension", sb.toString());
            }
            handleSave(bridgeCallback, jSONObject, str, str2, bitmap);
            return;
        }
        String string3 = GriverEnv.getResources().getString(R.string.griver_save_image_failed);
        if (activity != null && !activity.isFinishing()) {
            if (saveImageToGallery == 1) {
                string = GriverEnv.getResources().getString(R.string.griver_snap_sd_error);
            } else {
                if (saveImageToGallery == 10 || saveImageToGallery == 3) {
                    string = GriverEnv.getResources().getString(R.string.h5_snap_error);
                }
                ToastUtils.showToast(GriverEnv.getApplicationContext(), string3, 0);
            }
            string3 = string;
            ToastUtils.showToast(GriverEnv.getApplicationContext(), string3, 0);
        }
        jSONObject.put("success", Boolean.FALSE);
        jSONObject.put("error", Integer.valueOf(saveImageToGallery));
        jSONObject.put("errorMsg", (Object) string3);
        bridgeCallback.sendJSONResponse(jSONObject);
    }

    private int saveImageToGallery(Bitmap bitmap, String str) {
        String str2;
        if (TextUtils.equals(Environment.getExternalStorageState(), "mounted")) {
            str2 = "/Screenshots/";
            if (AndroidVersionUtils.isQAndAbove()) {
                GriverLogger.d("SnapshotBridgeExtension", "snapshot in Android Q and above");
                ContentResolver contentResolver = GriverEnv.getApplicationContext().getContentResolver();
                ContentValues contentValues = new ContentValues();
                StringBuilder sb = new StringBuilder();
                sb.append(System.currentTimeMillis() + 46);
                sb.append(str);
                contentValues.put("_display_name", sb.toString());
                contentValues.put("mime_type", "image/jpeg");
                String snapShotImagePath = ((GriverImagePathProxy) RVProxy.get(GriverImagePathProxy.class)).getSnapShotImagePath();
                str2 = TextUtils.isEmpty(snapShotImagePath) ? "/Screenshots/" : snapShotImagePath;
                if (!str2.startsWith("/")) {
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("/");
                    sb2.append(str2);
                    str2 = sb2.toString();
                }
                if (!str2.endsWith("/")) {
                    StringBuilder sb3 = new StringBuilder();
                    sb3.append(str2);
                    sb3.append("/");
                    str2 = sb3.toString();
                }
                StringBuilder sb4 = new StringBuilder();
                sb4.append("DCIM");
                sb4.append(str2);
                contentValues.put("relative_path", sb4.toString());
                Uri insert = contentResolver.insert(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, contentValues);
                if (insert == null) {
                    return 10;
                }
                try {
                    OutputStream openOutputStream = contentResolver.openOutputStream(insert);
                    if (openOutputStream == null) {
                        return 10;
                    }
                    StringBuilder sb5 = new StringBuilder();
                    sb5.append("path: ");
                    sb5.append(insert.toString());
                    GriverLogger.d("SnapshotBridgeExtension", sb5.toString());
                    boolean compress = bitmap.compress("jpg".equals(str) ? Bitmap.CompressFormat.JPEG : Bitmap.CompressFormat.PNG, 100, openOutputStream);
                    openOutputStream.close();
                    if (!compress) {
                        GriverLogger.e("SnapshotBridgeExtension", "snapshot bitmap to file failed");
                        return 10;
                    }
                } catch (Exception e) {
                    GriverLogger.e("SnapshotBridgeExtension", "snapshot in Android Q and above failed", e);
                    return 1;
                }
            } else {
                try {
                    GriverImagePathProxy griverImagePathProxy = (GriverImagePathProxy) RVProxy.get(GriverImagePathProxy.class);
                    String snapShotImagePath2 = griverImagePathProxy != null ? griverImagePathProxy.getSnapShotImagePath() : null;
                    if (!TextUtils.isEmpty(snapShotImagePath2)) {
                        str2 = snapShotImagePath2;
                    }
                    if (!str2.startsWith("/")) {
                        StringBuilder sb6 = new StringBuilder();
                        sb6.append("/");
                        sb6.append(str2);
                        str2 = sb6.toString();
                    }
                    if (!str2.endsWith("/")) {
                        StringBuilder sb7 = new StringBuilder();
                        sb7.append(str2);
                        sb7.append("/");
                        str2 = sb7.toString();
                    }
                    StringBuilder sb8 = new StringBuilder();
                    sb8.append(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DCIM));
                    sb8.append(str2);
                    sb8.append(System.currentTimeMillis());
                    sb8.append(".");
                    sb8.append(str);
                    String obj = sb8.toString();
                    this.imagePath = obj;
                    FileUtils.create(obj);
                    FileOutputStream fileOutputStream = new FileOutputStream(this.imagePath);
                    boolean compress2 = bitmap.compress("jpg".equals(str) ? Bitmap.CompressFormat.JPEG : Bitmap.CompressFormat.PNG, 100, fileOutputStream);
                    fileOutputStream.close();
                    if (!compress2) {
                        return 10;
                    }
                    MediaScannerConnection.scanFile(GriverEnv.getApplicationContext(), new String[]{this.imagePath}, new String[]{"image/*"}, null);
                } catch (Exception e2) {
                    RVLogger.e("SnapshotBridgeExtension", "saveImageToGallery exception.", e2);
                    return 3;
                }
            }
            return 0;
        }
        return 1;
    }

    public Bitmap captureScreen(Activity activity) {
        try {
            View decorView = activity.getWindow().getDecorView();
            decorView.buildDrawingCache();
            Rect rect = new Rect();
            decorView.getWindowVisibleDisplayFrame(rect);
            int i = rect.top;
            decorView.setDrawingCacheEnabled(true);
            Bitmap drawingCache = decorView.getDrawingCache();
            Bitmap createBitmap = Bitmap.createBitmap(drawingCache, 0, i, drawingCache.getWidth(), drawingCache.getHeight() - i);
            decorView.destroyDrawingCache();
            return createBitmap;
        } catch (Exception e) {
            RVLogger.e("SnapshotBridgeExtension", e);
            return null;
        }
    }

    private Bitmap captureNXView(int i, Render render, Activity activity) {
        Bitmap capture = render.getCapture(i);
        if (capture == null) {
            RVLogger.w("SnapshotBridgeExtension", "captureNXView got null bitmap!");
            return captureScreen(activity);
        }
        return capture;
    }

    public void captureEmbedView(Page page, Activity activity, BridgeCallback bridgeCallback, JSONObject jSONObject, int i, int i2, boolean z, String str, String str2, int i3, boolean z2) {
        try {
            handleSnapshot(bridgeCallback, activity, jSONObject, i, i2, z, str, str2, i3, captureScreen(activity));
        } catch (Exception e) {
            RVLogger.e("SnapshotBridgeExtension", e);
        }
    }
}
