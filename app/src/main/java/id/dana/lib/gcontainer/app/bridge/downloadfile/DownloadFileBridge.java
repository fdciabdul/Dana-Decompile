package id.dana.lib.gcontainer.app.bridge.downloadfile;

import android.app.Activity;
import android.os.Build;
import com.alibaba.ariver.app.api.Page;
import com.alibaba.ariver.engine.api.bridge.extension.BridgeCallback;
import com.alibaba.ariver.engine.api.bridge.extension.annotation.BindingCallback;
import com.alibaba.ariver.engine.api.bridge.extension.annotation.BindingNode;
import com.alibaba.ariver.engine.api.bridge.extension.annotation.BindingParam;
import com.alibaba.ariver.kernel.api.annotation.ActionFilter;
import com.alibaba.ariver.kernel.api.annotation.ThreadType;
import com.alibaba.ariver.kernel.common.service.executor.ExecutorType;
import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.TypeReference;
import com.alibaba.fastjson.parser.Feature;
import com.anggrayudi.storage.file.DocumentFileCompat;
import com.anggrayudi.storage.permission.PermissionCallback;
import com.anggrayudi.storage.permission.PermissionRequest;
import com.anggrayudi.storage.permission.PermissionResult;
import id.dana.danah5.akulaku.AkuEventParamsKey;
import id.dana.lib.gcontainer.app.bridge.constant.BridgeKey;
import id.dana.lib.gcontainer.app.bridge.core.BaseBridge;
import id.dana.lib.gcontainer.app.bridge.downloadfile.businessaccount.model.DownloadResult;
import id.dana.lib.gcontainer.extension.BridgeExtensionExtKt;
import id.dana.lib.logger.DANALog;
import id.dana.promocenter.model.PromoActionType;
import io.reactivex.Observable;
import java.net.MalformedURLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 *2\u00020\u0001:\u0001*B\u0007¢\u0006\u0004\b(\u0010)J\u0019\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\b\u0010\u0006J7\u0010\u0010\u001a\u00020\u000f2\b\b\u0001\u0010\n\u001a\u00020\t2\b\b\u0001\u0010\u000b\u001a\u00020\u00022\b\b\u0001\u0010\f\u001a\u00020\u00042\b\b\u0001\u0010\u000e\u001a\u00020\rH\u0007¢\u0006\u0004\b\u0010\u0010\u0011J7\u0010\u0012\u001a\u00020\u000f2\b\b\u0001\u0010\n\u001a\u00020\t2\b\b\u0001\u0010\u000b\u001a\u00020\u00022\b\b\u0001\u0010\f\u001a\u00020\u00042\b\b\u0001\u0010\u000e\u001a\u00020\rH\u0007¢\u0006\u0004\b\u0012\u0010\u0011J\u000f\u0010\u0013\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0013\u0010\u0014J\u000f\u0010\u0015\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0015\u0010\u0014J\u000f\u0010\u0016\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0016\u0010\u0014J\u0017\u0010\u0019\u001a\u00020\u000f2\u0006\u0010\u0018\u001a\u00020\u0017H\u0002¢\u0006\u0004\b\u0019\u0010\u001aJ\u0017\u0010\u001b\u001a\u00020\u000f2\u0006\u0010\u0018\u001a\u00020\u0017H\u0002¢\u0006\u0004\b\u001b\u0010\u001aJ\u0017\u0010\u001e\u001a\u00020\u000f2\u0006\u0010\u001d\u001a\u00020\u001cH\u0002¢\u0006\u0004\b\u001e\u0010\u001fJ\u0017\u0010 \u001a\u00020\u000f2\u0006\u0010\u0018\u001a\u00020\u0017H\u0002¢\u0006\u0004\b \u0010\u001aR\u0016\u0010\u000e\u001a\u00020\r8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b\u000e\u0010!R\u0016\u0010#\u001a\u00020\"8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b#\u0010$R\u0016\u0010%\u001a\u00020\u00028\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b%\u0010&R\u0016\u0010'\u001a\u00020\u00028\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b'\u0010&"}, d2 = {"Lid/dana/lib/gcontainer/app/bridge/downloadfile/DownloadFileBridge;", "Lid/dana/lib/gcontainer/app/bridge/core/BaseBridge;", "", "errorType", "Lcom/alibaba/fastjson/JSONObject;", "createErrorResult", "(Ljava/lang/String;)Lcom/alibaba/fastjson/JSONObject;", BridgeKey.FILE_PATH, "createSuccessResult", "Lcom/alibaba/ariver/app/api/Page;", "page", "event", "info", "Lcom/alibaba/ariver/engine/api/bridge/extension/BridgeCallback;", "bridgeCallback", "", "download", "(Lcom/alibaba/ariver/app/api/Page;Ljava/lang/String;Lcom/alibaba/fastjson/JSONObject;Lcom/alibaba/ariver/engine/api/bridge/extension/BridgeCallback;)V", "downloadFile", "generateTimeFormat", "()Ljava/lang/String;", "getGeneralFileFormat", "getGeneralMimeType", "Landroid/app/Activity;", AkuEventParamsKey.KEY_ACTIVITY, "handleDownloadFile", "(Landroid/app/Activity;)V", "handleFile", "Lid/dana/lib/gcontainer/app/bridge/downloadfile/businessaccount/model/DownloadResult;", "downloadResult", "mapDownloadResult", "(Lid/dana/lib/gcontainer/app/bridge/downloadfile/businessaccount/model/DownloadResult;)V", "processDownload", "Lcom/alibaba/ariver/engine/api/bridge/extension/BridgeCallback;", "Lid/dana/lib/gcontainer/app/bridge/downloadfile/DownloadFileEntity;", "downloadFileEntity", "Lid/dana/lib/gcontainer/app/bridge/downloadfile/DownloadFileEntity;", "fileFormat", "Ljava/lang/String;", "mimeType", "<init>", "()V", "Companion"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes2.dex */
public final class DownloadFileBridge extends BaseBridge {
    public static final int MINIMUM_STORAGE_AVAILABLE = 104857600;
    private static final String PDF_FILE_FORMAT = ".pdf";
    private static final String PDF_MIME_TYPE = "application/pdf";
    private static final String PNG_FILE_FORMAT = ".png";
    private static final String PNG_MIME_TYPE = "image/png";
    private BridgeCallback bridgeCallback;
    private DownloadFileEntity downloadFileEntity;
    private String fileFormat;
    private String mimeType;
    private static final String TAG = "DownloadFileBridge";

    @ThreadType(ExecutorType.NORMAL)
    @ActionFilter(canOverride = false)
    public final void downloadFile(@BindingNode(Page.class) Page page, @BindingParam(name = {"event"}) String event, @BindingParam(name = {"info"}) JSONObject info, @BindingCallback BridgeCallback bridgeCallback) {
        Intrinsics.checkNotNullParameter(page, "");
        Intrinsics.checkNotNullParameter(event, "");
        Intrinsics.checkNotNullParameter(info, "");
        Intrinsics.checkNotNullParameter(bridgeCallback, "");
        Activity activity = BridgeExtensionExtKt.getActivity(page);
        if (activity == null) {
            return;
        }
        this.bridgeCallback = bridgeCallback;
        Object obj = null;
        try {
            obj = JSONObject.parseObject(info.toJSONString(), new TypeReference<DownloadFileEntity>() { // from class: id.dana.lib.gcontainer.app.bridge.downloadfile.DownloadFileBridge$downloadFile$$inlined$toObject$default$1
            }, new Feature[0]);
        } catch (JSONException | NullPointerException unused) {
        }
        DownloadFileEntity downloadFileEntity = (DownloadFileEntity) obj;
        if (downloadFileEntity == null) {
            return;
        }
        this.downloadFileEntity = downloadFileEntity;
        int hashCode = event.hashCode();
        if (hashCode != -1934963312) {
            if (hashCode != -1124766330) {
                if (hashCode == 3143036 && event.equals("file")) {
                    this.fileFormat = ".png";
                    this.mimeType = PNG_MIME_TYPE;
                    handleDownloadFile(activity);
                    return;
                }
            } else if (event.equals("downloadBusinessAccountQR")) {
                this.fileFormat = ".pdf";
                this.mimeType = "application/pdf";
                handleDownloadFile(activity);
                return;
            }
        } else if (event.equals("generalDownload")) {
            this.fileFormat = getGeneralFileFormat();
            this.mimeType = getGeneralMimeType();
            handleDownloadFile(activity);
            return;
        }
        createErrorResult("001");
    }

    @ThreadType(ExecutorType.NORMAL)
    @ActionFilter(canOverride = false)
    public final void download(@BindingNode(Page.class) Page page, @BindingParam(name = {"event"}) String event, @BindingParam(name = {"info"}) JSONObject info, @BindingCallback BridgeCallback bridgeCallback) {
        Intrinsics.checkNotNullParameter(page, "");
        Intrinsics.checkNotNullParameter(event, "");
        Intrinsics.checkNotNullParameter(info, "");
        Intrinsics.checkNotNullParameter(bridgeCallback, "");
        Activity activity = BridgeExtensionExtKt.getActivity(page);
        if (activity == null) {
            return;
        }
        this.bridgeCallback = bridgeCallback;
        Object obj = null;
        try {
            obj = JSONObject.parseObject(info.toJSONString(), new TypeReference<DownloadFileEntity>() { // from class: id.dana.lib.gcontainer.app.bridge.downloadfile.DownloadFileBridge$download$$inlined$toObject$default$1
            }, new Feature[0]);
        } catch (JSONException | NullPointerException unused) {
        }
        DownloadFileEntity downloadFileEntity = (DownloadFileEntity) obj;
        if (downloadFileEntity == null) {
            return;
        }
        this.downloadFileEntity = downloadFileEntity;
        int hashCode = event.hashCode();
        if (hashCode != -1934963312) {
            if (hashCode != -1124766330) {
                if (hashCode == 3143036 && event.equals("file")) {
                    this.fileFormat = ".png";
                    this.mimeType = PNG_MIME_TYPE;
                    handleDownloadFile(activity);
                    return;
                }
            } else if (event.equals("downloadBusinessAccountQR")) {
                this.fileFormat = ".pdf";
                this.mimeType = "application/pdf";
                handleDownloadFile(activity);
                return;
            }
        } else if (event.equals("generalDownload")) {
            this.fileFormat = getGeneralFileFormat();
            this.mimeType = getGeneralMimeType();
            handleDownloadFile(activity);
            return;
        }
        createErrorResult("001");
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v0, types: [kotlin.jvm.internal.DefaultConstructorMarker, java.lang.String] */
    /* JADX WARN: Type inference failed for: r2v1 */
    private final void handleFile(Activity r8) {
        String obj;
        DownloadFileEntity downloadFileEntity = this.downloadFileEntity;
        String str = 0;
        if (downloadFileEntity == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            downloadFileEntity = null;
        }
        String filePath = downloadFileEntity.getFilePath();
        if (filePath == null) {
            DownloadFileEntity downloadFileEntity2 = this.downloadFileEntity;
            if (downloadFileEntity2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("");
                downloadFileEntity2 = null;
            }
            filePath = downloadFileEntity2.getSource();
            if (filePath == null) {
                DownloadFileEntity downloadFileEntity3 = this.downloadFileEntity;
                if (downloadFileEntity3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("");
                    downloadFileEntity3 = null;
                }
                filePath = downloadFileEntity3.getUrl();
            }
        }
        String str2 = filePath;
        if (str2 == null || str2.length() == 0) {
            mapDownloadResult(new DownloadResult("GENERAL_ERROR", str, 2, str));
            return;
        }
        DownloadFileEntity downloadFileEntity4 = this.downloadFileEntity;
        if (downloadFileEntity4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            downloadFileEntity4 = null;
        }
        String fileName = downloadFileEntity4.getFileName();
        if (!(fileName == null || fileName.length() == 0)) {
            StringBuilder sb = new StringBuilder();
            DownloadFileEntity downloadFileEntity5 = this.downloadFileEntity;
            if (downloadFileEntity5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("");
                downloadFileEntity5 = null;
            }
            sb.append((Object) downloadFileEntity5.getFileName());
            sb.append('_');
            sb.append(generateTimeFormat());
            obj = sb.toString();
        } else {
            DownloadFileEntity downloadFileEntity6 = this.downloadFileEntity;
            if (downloadFileEntity6 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("");
                downloadFileEntity6 = null;
            }
            String businessName = downloadFileEntity6.getBusinessName();
            if (businessName == null || businessName.length() == 0) {
                obj = Intrinsics.stringPlus("DANA_", Long.valueOf(System.currentTimeMillis()));
            } else {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("QR_");
                DownloadFileEntity downloadFileEntity7 = this.downloadFileEntity;
                if (downloadFileEntity7 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("");
                    downloadFileEntity7 = null;
                }
                sb2.append((Object) downloadFileEntity7.getBusinessName());
                sb2.append('_');
                sb2.append(generateTimeFormat());
                obj = sb2.toString();
            }
        }
        BridgeCallback bridgeCallback = this.bridgeCallback;
        if (bridgeCallback == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            bridgeCallback = null;
        }
        DownloadFileManager downloadFileManager = new DownloadFileManager(r8, bridgeCallback, new IDownloadListener() { // from class: id.dana.lib.gcontainer.app.bridge.downloadfile.DownloadFileBridge$$ExternalSyntheticLambda0
            {
                DownloadFileBridge.this = this;
            }

            @Override // id.dana.lib.gcontainer.app.bridge.downloadfile.IDownloadListener
            public final Observable download(String str3, String str4, String str5) {
                Observable m2646handleFile$lambda0;
                m2646handleFile$lambda0 = DownloadFileBridge.m2646handleFile$lambda0(DownloadFileBridge.this, str3, str4, str5);
                return m2646handleFile$lambda0;
            }
        });
        String str3 = this.fileFormat;
        if (str3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            str3 = null;
        }
        String str4 = this.mimeType;
        if (str4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
        } else {
            str = str4;
        }
        downloadFileManager.processEvent(filePath, obj, str3, str);
    }

    /* renamed from: handleFile$lambda-0 */
    public static final Observable m2646handleFile$lambda0(DownloadFileBridge downloadFileBridge, String str, String str2, String str3) {
        Intrinsics.checkNotNullParameter(downloadFileBridge, "");
        Intrinsics.checkNotNullParameter(str, "");
        Intrinsics.checkNotNullParameter(str2, "");
        Intrinsics.checkNotNullParameter(str3, "");
        try {
            DownloadUtil downloadUtil = DownloadUtil.INSTANCE;
            String str4 = downloadFileBridge.fileFormat;
            if (str4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("");
                str4 = null;
            }
            return downloadUtil.downloadFile(str, str2, str4);
        } catch (MalformedURLException e) {
            return Observable.error(e);
        }
    }

    private final void handleDownloadFile(final Activity r3) {
        if (Build.VERSION.SDK_INT < 29) {
            requestPermissions(r3, new String[]{"android.permission.READ_EXTERNAL_STORAGE", "android.permission.WRITE_EXTERNAL_STORAGE"}, new PermissionCallback() { // from class: id.dana.lib.gcontainer.app.bridge.downloadfile.DownloadFileBridge$handleDownloadFile$1
                @Override // com.anggrayudi.storage.permission.PermissionCallback
                public final /* synthetic */ void onDisplayConsentDialog(PermissionRequest permissionRequest) {
                    PermissionCallback.CC.getAuthRequestContext(permissionRequest);
                }

                @Override // com.anggrayudi.storage.permission.PermissionCallback
                public final /* synthetic */ void onShouldRedirectToSystemSettings(List list) {
                    PermissionCallback.CC.BuiltInFictitiousFunctionClassFactory(list);
                }

                {
                    DownloadFileBridge.this = this;
                }

                /* JADX WARN: Type inference failed for: r1v0, types: [kotlin.jvm.internal.DefaultConstructorMarker, java.lang.String] */
                @Override // com.anggrayudi.storage.permission.PermissionCallback
                public final void onPermissionsChecked(PermissionResult result, boolean fromSystemDialog) {
                    String str;
                    Intrinsics.checkNotNullParameter(result, "");
                    if (result.MyBillsEntityDataFactory()) {
                        DownloadFileBridge.this.processDownload(r3);
                        return;
                    }
                    ?? r1 = 0;
                    DownloadFileBridge.this.mapDownloadResult(new DownloadResult("NO_PERMISSION", r1, 2, r1));
                    str = DownloadFileBridge.TAG;
                    DANALog.MyBillsEntityDataFactory(str, "onExternalStoragePermissionResult User not authorized");
                }
            });
        } else {
            processDownload(r3);
        }
    }

    /* JADX WARN: Type inference failed for: r1v1, types: [kotlin.jvm.internal.DefaultConstructorMarker, java.lang.String] */
    public final void processDownload(Activity r6) {
        if (DocumentFileCompat.BuiltInFictitiousFunctionClassFactory(r6, PromoActionType.PRIMARY) <= 104857600) {
            ?? r1 = 0;
            mapDownloadResult(new DownloadResult("STORAGE_LOW", r1, 2, r1));
            DANALog.MyBillsEntityDataFactory(TAG, "Insufficient memory, free up the space in your device");
            return;
        }
        handleFile(r6);
    }

    public final void mapDownloadResult(DownloadResult downloadResult) {
        JSONObject createErrorResult;
        if (Intrinsics.areEqual("SUCCESS", downloadResult.getType())) {
            String filePath = downloadResult.getFilePath();
            if (filePath == null) {
                filePath = "";
            }
            createErrorResult = createSuccessResult(filePath);
        } else {
            createErrorResult = createErrorResult(downloadResult.getType());
        }
        BridgeCallback bridgeCallback = this.bridgeCallback;
        if (bridgeCallback == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            bridgeCallback = null;
        }
        bridgeCallback.sendJSONResponse(createErrorResult);
    }

    private final String generateTimeFormat() {
        String format = new SimpleDateFormat("ddMMyy_HHmmss").format(new Date());
        Intrinsics.checkNotNullExpressionValue(format, "");
        return format;
    }

    private final String getGeneralFileFormat() {
        DownloadFileEntity downloadFileEntity = this.downloadFileEntity;
        if (downloadFileEntity == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            downloadFileEntity = null;
        }
        String fileFormat = downloadFileEntity.getFileFormat();
        return Intrinsics.stringPlus(".", fileFormat != null ? fileFormat : "");
    }

    private final String getGeneralMimeType() {
        DownloadFileEntity downloadFileEntity = this.downloadFileEntity;
        if (downloadFileEntity == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            downloadFileEntity = null;
        }
        String fileFormat = downloadFileEntity.getFileFormat();
        return Intrinsics.stringPlus("application/", fileFormat != null ? fileFormat : "");
    }

    private final JSONObject createSuccessResult(String r5) {
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = jSONObject;
        jSONObject2.put((JSONObject) "success", (String) Boolean.TRUE);
        jSONObject2.put((JSONObject) BridgeKey.FILE_PATH, r5);
        return jSONObject;
    }

    private final JSONObject createErrorResult(String errorType) {
        String str;
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = jSONObject;
        jSONObject2.put((JSONObject) "success", (String) Boolean.FALSE);
        if (Intrinsics.areEqual(errorType, "STORAGE_LOW")) {
            str = "002";
        } else {
            str = Intrinsics.areEqual(errorType, "NO_PERMISSION") ? "003" : "001";
        }
        jSONObject2.put((JSONObject) "error", str);
        return jSONObject;
    }
}
