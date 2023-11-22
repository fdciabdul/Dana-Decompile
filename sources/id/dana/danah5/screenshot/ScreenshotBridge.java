package id.dana.danah5.screenshot;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.view.View;
import com.alibaba.ariver.app.api.Page;
import com.alibaba.ariver.engine.api.bridge.extension.BridgeCallback;
import com.alibaba.ariver.engine.api.bridge.extension.annotation.BindingCallback;
import com.alibaba.ariver.engine.api.bridge.extension.annotation.BindingNode;
import com.alibaba.ariver.engine.api.bridge.extension.annotation.BindingParam;
import com.alibaba.ariver.kernel.api.annotation.ActionFilter;
import com.alibaba.ariver.kernel.api.annotation.ThreadType;
import com.alibaba.ariver.kernel.common.service.executor.ExecutorType;
import com.alibaba.ariver.kernel.common.utils.RVLogger;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.griver.base.common.executor.GriverExecutors;
import com.alibaba.griver.base.common.utils.ImageUtils;
import com.alibaba.griver.device.R;
import com.anggrayudi.storage.SimpleStorage;
import com.anggrayudi.storage.extension.UriUtils;
import com.anggrayudi.storage.media.FileDescription;
import com.anggrayudi.storage.media.MediaFile;
import com.anggrayudi.storage.media.MediaStoreCompat;
import com.anggrayudi.storage.permission.PermissionCallback;
import com.anggrayudi.storage.permission.PermissionRequest;
import com.anggrayudi.storage.permission.PermissionResult;
import com.ap.zoloz.hummer.biz.HummerConstants;
import id.dana.analytics.tracker.TrackerKey;
import id.dana.danah5.akulaku.AkuEventParamsKey;
import id.dana.lib.gcontainer.app.bridge.core.BaseBridge;
import id.dana.lib.gcontainer.extension.BridgeExtensionExtKt;
import java.io.OutputStream;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.io.CloseableKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;

@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 .2\u00020\u0001:\u0001.B\u0007¢\u0006\u0004\b,\u0010-J'\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\t\u0010\nJ7\u0010\u000f\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\rH\u0002¢\u0006\u0004\b\u000f\u0010\u0010J+\u0010\u0011\u001a\u0004\u0018\u00010\r2\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\u000e\u001a\u0004\u0018\u00010\r2\u0006\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0011\u0010\u0012J7\u0010\u0017\u001a\u00020\b2\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0015\u001a\u00020\u00042\u0006\u0010\u0016\u001a\u00020\u000b2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\rH\u0002¢\u0006\u0004\b\u0017\u0010\u0018J7\u0010\u0019\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0015\u001a\u00020\u00042\u0006\u0010\u0016\u001a\u00020\u000b2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\rH\u0002¢\u0006\u0004\b\u0019\u0010\u0010J1\u0010\u001a\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0002¢\u0006\u0004\b\u001a\u0010\u001bJ\u001f\u0010\u001e\u001a\u00020\b2\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u001d\u001a\u00020\u001cH\u0002¢\u0006\u0004\b\u001e\u0010\u001fJ/\u0010$\u001a\u00020#2\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010!\u001a\u00020 2\u0006\u0010\"\u001a\u00020 H\u0002¢\u0006\u0004\b$\u0010%J/\u0010)\u001a\u00020\b2\b\b\u0001\u0010'\u001a\u00020&2\n\b\u0001\u0010(\u001a\u0004\u0018\u00010 2\b\b\u0001\u0010\u0005\u001a\u00020\u0004H\u0007¢\u0006\u0004\b)\u0010*R\u0016\u0010\u001d\u001a\u00020\u001c8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b\u001d\u0010+"}, d2 = {"Lid/dana/danah5/screenshot/ScreenshotBridge;", "Lid/dana/lib/gcontainer/app/bridge/core/BaseBridge;", "Landroid/app/Activity;", AkuEventParamsKey.KEY_ACTIVITY, "Lcom/alibaba/ariver/engine/api/bridge/extension/BridgeCallback;", "callback", "Lid/dana/danah5/screenshot/ScreenshotBridgeModel;", "params", "", "captureScreen", "(Landroid/app/Activity;Lcom/alibaba/ariver/engine/api/bridge/extension/BridgeCallback;Lid/dana/danah5/screenshot/ScreenshotBridgeModel;)V", "Lcom/alibaba/fastjson/JSONObject;", "jsonResult", "Landroid/graphics/Bitmap;", "bitmap", "checkPermissionsBeforeProcess", "(Landroid/app/Activity;Lcom/alibaba/ariver/engine/api/bridge/extension/BridgeCallback;Lcom/alibaba/fastjson/JSONObject;Lid/dana/danah5/screenshot/ScreenshotBridgeModel;Landroid/graphics/Bitmap;)V", "createNewBitmap", "(Lid/dana/danah5/screenshot/ScreenshotBridgeModel;Landroid/graphics/Bitmap;Lcom/alibaba/ariver/engine/api/bridge/extension/BridgeCallback;)Landroid/graphics/Bitmap;", "Landroid/content/Context;", HummerConstants.CONTEXT, "bridgeContext", "result", "handleSave", "(Landroid/content/Context;Lcom/alibaba/ariver/engine/api/bridge/extension/BridgeCallback;Lcom/alibaba/fastjson/JSONObject;Lid/dana/danah5/screenshot/ScreenshotBridgeModel;Landroid/graphics/Bitmap;)V", "handleSaveToGallery", "handleSnapshot", "(Landroid/app/Activity;Lcom/alibaba/ariver/engine/api/bridge/extension/BridgeCallback;Lid/dana/danah5/screenshot/ScreenshotBridgeModel;Landroid/graphics/Bitmap;)V", "Landroid/net/Uri;", "imageUri", "notifyGallery", "(Landroid/content/Context;Landroid/net/Uri;)V", "", "baseFileName", "format", "", "saveImageToGallery", "(Landroid/content/Context;Landroid/graphics/Bitmap;Ljava/lang/String;Ljava/lang/String;)I", "Lcom/alibaba/ariver/app/api/Page;", "page", "name", "screenshot", "(Lcom/alibaba/ariver/app/api/Page;Ljava/lang/String;Lcom/alibaba/ariver/engine/api/bridge/extension/BridgeCallback;)V", "Landroid/net/Uri;", "<init>", "()V", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class ScreenshotBridge extends BaseBridge {
    private static final String DATAURL = "dataURL";
    private static final String DEFAULT_SCREENSHOT_FORMAT = "jpeg";
    private static final String FILEURL = "fileURL";
    private static final String INVALID_CHARACTER_REGEX = "[\\\\/:*?\"<>|]";
    public static final String TAG = "SnapshotBridgeExtension";
    private static final String UNDERSCORE_REGEX = "_";
    private Uri imageUri;

    @ThreadType(ExecutorType.UI)
    @ActionFilter
    public final void screenshot(@BindingNode(Page.class) Page page, @BindingParam({"name"}) String name, @BindingCallback BridgeCallback callback) {
        Intrinsics.checkNotNullParameter(page, "");
        Intrinsics.checkNotNullParameter(callback, "");
        ScreenshotBridgeModel screenshotBridgeModel = new ScreenshotBridgeModel(name, -1, -1, true, FILEURL, DEFAULT_SCREENSHOT_FORMAT, 75);
        Activity activity = BridgeExtensionExtKt.getActivity(page);
        if (activity == null) {
            return;
        }
        captureScreen(activity, callback, screenshotBridgeModel);
    }

    private final void handleSnapshot(Activity activity, BridgeCallback callback, ScreenshotBridgeModel params, Bitmap bitmap) {
        if (bitmap != null && !bitmap.isRecycled()) {
            BuildersKt__Builders_commonKt.launch$default(getIoScope(), null, null, new ScreenshotBridge$handleSnapshot$1(params, bitmap, this, callback, activity, null), 3, null);
        } else {
            callback.sendJSONResponse(ScreenshotPluginResultFactory.getResult("003"));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Bitmap createNewBitmap(ScreenshotBridgeModel params, Bitmap bitmap, BridgeCallback callback) {
        if (bitmap == null) {
            return null;
        }
        if (params.getMaxHeight() != bitmap.getHeight() || params.getMaxWidth() != bitmap.getWidth()) {
            bitmap = ImageUtils.scaleBitmap(bitmap, params.getMaxWidth(), params.getMaxHeight());
        }
        if (bitmap != null && Intrinsics.areEqual(DEFAULT_SCREENSHOT_FORMAT, params.getImageFormat()) && params.getQuality() != 100) {
            bitmap = ImageUtils.imageQuality(bitmap, params.getQuality());
        }
        if (bitmap == null) {
            callback.sendJSONResponse(ScreenshotPluginResultFactory.getResult("003"));
        }
        return bitmap;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void checkPermissionsBeforeProcess(final Activity activity, final BridgeCallback callback, final JSONObject jsonResult, final ScreenshotBridgeModel params, final Bitmap bitmap) {
        if (Build.VERSION.SDK_INT < 29) {
            SimpleStorage.Companion companion = SimpleStorage.INSTANCE;
            if (!SimpleStorage.Companion.getAuthRequestContext(activity)) {
                requestPermissions(activity, new String[]{"android.permission.WRITE_EXTERNAL_STORAGE", "android.permission.READ_EXTERNAL_STORAGE"}, new PermissionCallback() { // from class: id.dana.danah5.screenshot.ScreenshotBridge$checkPermissionsBeforeProcess$2
                    @Override // com.anggrayudi.storage.permission.PermissionCallback
                    public final /* synthetic */ void onDisplayConsentDialog(PermissionRequest permissionRequest) {
                        PermissionCallback.CC.getAuthRequestContext(permissionRequest);
                    }

                    @Override // com.anggrayudi.storage.permission.PermissionCallback
                    public final /* synthetic */ void onShouldRedirectToSystemSettings(List list) {
                        PermissionCallback.CC.BuiltInFictitiousFunctionClassFactory(list);
                    }

                    @Override // com.anggrayudi.storage.permission.PermissionCallback
                    public final void onPermissionsChecked(PermissionResult result, boolean fromSystemDialog) {
                        CoroutineScope ioScope;
                        Intrinsics.checkNotNullParameter(result, "");
                        if (result.MyBillsEntityDataFactory()) {
                            ioScope = ScreenshotBridge.this.getIoScope();
                            BuildersKt__Builders_commonKt.launch$default(ioScope, null, null, new ScreenshotBridge$checkPermissionsBeforeProcess$2$onPermissionsChecked$1(ScreenshotBridge.this, activity, callback, jsonResult, params, bitmap, null), 3, null);
                            return;
                        }
                        callback.sendJSONResponse(ScreenshotPluginResultFactory.getResult("002"));
                    }
                });
                return;
            }
        }
        BuildersKt__Builders_commonKt.launch$default(getIoScope(), null, null, new ScreenshotBridge$checkPermissionsBeforeProcess$1(this, activity, callback, jsonResult, params, bitmap, null), 3, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void handleSave(Context context, final BridgeCallback bridgeContext, JSONObject result, final ScreenshotBridgeModel params, final Bitmap bitmap) {
        String dataType = params.getDataType();
        if (Intrinsics.areEqual(dataType, DATAURL)) {
            GriverExecutors.getExecutor(ExecutorType.URGENT).execute(new Runnable() { // from class: id.dana.danah5.screenshot.ScreenshotBridge$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    ScreenshotBridge.m716handleSave$lambda1(bitmap, params, bridgeContext);
                }
            });
        } else {
            if (Intrinsics.areEqual(dataType, FILEURL)) {
                StringBuilder sb = new StringBuilder();
                sb.append(params.getFilename());
                sb.append('_');
                sb.append(System.currentTimeMillis());
                String replace = new Regex(INVALID_CHARACTER_REGEX).replace(sb.toString(), "_");
                String imageFormat = params.getImageFormat();
                Intrinsics.checkNotNullExpressionValue(imageFormat, "");
                boolean z = saveImageToGallery(context, bitmap, replace, imageFormat) == 0;
                JSONObject jSONObject = result;
                jSONObject.put((JSONObject) "success", (String) Boolean.valueOf(z));
                jSONObject.put((JSONObject) "error", z ? "001" : "003");
                if (z) {
                    Uri uri = this.imageUri;
                    if (uri == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("");
                        uri = null;
                    }
                    jSONObject.put((JSONObject) FILEURL, uri.toString());
                } else {
                    jSONObject.put((JSONObject) "errorMessage", context.getString(R.string.griver_save_pic_failed));
                }
                bridgeContext.sendJSONResponse(result);
            } else {
                bridgeContext.sendJSONResponse(ScreenshotPluginResultFactory.getResult("001"));
            }
        }
        if (bitmap.isRecycled()) {
            return;
        }
        bitmap.recycle();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: handleSave$lambda-1  reason: not valid java name */
    public static final void m716handleSave$lambda1(Bitmap bitmap, ScreenshotBridgeModel screenshotBridgeModel, BridgeCallback bridgeCallback) {
        Intrinsics.checkNotNullParameter(bitmap, "");
        Intrinsics.checkNotNullParameter(screenshotBridgeModel, "");
        Intrinsics.checkNotNullParameter(bridgeCallback, "");
        String bitmapToString = ImageUtils.bitmapToString(bitmap, screenshotBridgeModel.getImageFormat());
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = jSONObject;
        jSONObject2.put((JSONObject) DATAURL, bitmapToString);
        jSONObject2.put((JSONObject) "success", (String) Boolean.TRUE);
        jSONObject2.put((JSONObject) "error", "001");
        bridgeCallback.sendJSONResponse(jSONObject);
        bitmap.recycle();
    }

    private final void notifyGallery(Context context, Uri imageUri) {
        if (Build.VERSION.SDK_INT < 29) {
            context.sendBroadcast(new Intent("android.intent.action.MEDIA_SCANNER_SCAN_FILE", imageUri));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x005f, code lost:
    
        if (r2 == null) goto L16;
     */
    /* JADX WARN: Type inference failed for: r10v1, types: [T, java.lang.Object, java.lang.String] */
    /* JADX WARN: Type inference failed for: r2v6, types: [T, java.lang.Object, java.lang.String] */
    /* JADX WARN: Type inference failed for: r2v9, types: [T, java.lang.Object, java.lang.String] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void handleSaveToGallery(android.app.Activity r17, com.alibaba.ariver.engine.api.bridge.extension.BridgeCallback r18, com.alibaba.fastjson.JSONObject r19, id.dana.danah5.screenshot.ScreenshotBridgeModel r20, android.graphics.Bitmap r21) {
        /*
            Method dump skipped, instructions count: 298
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.danah5.screenshot.ScreenshotBridge.handleSaveToGallery(android.app.Activity, com.alibaba.ariver.engine.api.bridge.extension.BridgeCallback, com.alibaba.fastjson.JSONObject, id.dana.danah5.screenshot.ScreenshotBridgeModel, android.graphics.Bitmap):void");
    }

    private final int saveImageToGallery(Context context, Bitmap bitmap, String baseFileName, String format) {
        Uri uri;
        OutputStream authRequestContext;
        Bitmap.CompressFormat compressFormat;
        if (Intrinsics.areEqual(Environment.getExternalStorageState(), "mounted")) {
            StringBuilder sb = new StringBuilder();
            sb.append(baseFileName);
            sb.append('.');
            sb.append(format);
            String obj = sb.toString();
            StringBuilder sb2 = new StringBuilder();
            sb2.append("image/");
            sb2.append(format);
            MediaFile BuiltInFictitiousFunctionClassFactory = MediaStoreCompat.BuiltInFictitiousFunctionClassFactory(context, new FileDescription(obj, TrackerKey.DanaBalanceRecipientTypeProperty.DANA, sb2.toString()));
            if (BuiltInFictitiousFunctionClassFactory != null && (uri = BuiltInFictitiousFunctionClassFactory.moveToNextValue) != null) {
                this.imageUri = uri;
                if (uri == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("");
                    uri = null;
                }
                authRequestContext = UriUtils.getAuthRequestContext(uri, context, true);
                if (authRequestContext == null) {
                    return 3;
                }
                try {
                    OutputStream outputStream = authRequestContext;
                    try {
                        OutputStream outputStream2 = outputStream;
                        if (Intrinsics.areEqual(DEFAULT_SCREENSHOT_FORMAT, format)) {
                            compressFormat = Bitmap.CompressFormat.JPEG;
                        } else {
                            compressFormat = Bitmap.CompressFormat.PNG;
                        }
                        if (bitmap.compress(compressFormat, 100, authRequestContext)) {
                            Uri uri2 = this.imageUri;
                            if (uri2 == null) {
                                Intrinsics.throwUninitializedPropertyAccessException("");
                                uri2 = null;
                            }
                            notifyGallery(context, uri2);
                            Unit unit = Unit.INSTANCE;
                            CloseableKt.closeFinally(outputStream, null);
                            return 0;
                        }
                        CloseableKt.closeFinally(outputStream, null);
                        return 10;
                    } finally {
                    }
                } catch (Exception e) {
                    RVLogger.e("SnapshotBridgeExtension", "saveImageToGallery exception.", e);
                }
            }
            return 3;
        }
        return 1;
    }

    private final void captureScreen(Activity activity, BridgeCallback callback, ScreenshotBridgeModel params) {
        try {
            Rect rect = new Rect();
            int i = rect.top;
            View decorView = activity.getWindow().getDecorView();
            decorView.buildDrawingCache();
            decorView.getWindowVisibleDisplayFrame(rect);
            decorView.setDrawingCacheEnabled(true);
            Intrinsics.checkNotNullExpressionValue(decorView, "");
            Bitmap drawingCache = decorView.getDrawingCache();
            Bitmap createBitmap = Bitmap.createBitmap(drawingCache, 0, i, drawingCache.getWidth(), drawingCache.getHeight() - i);
            Intrinsics.checkNotNullExpressionValue(createBitmap, "");
            decorView.destroyDrawingCache();
            handleSnapshot(activity, callback, params, createBitmap);
        } catch (Exception e) {
            RVLogger.e("SnapshotBridgeExtension", e);
        }
    }
}
