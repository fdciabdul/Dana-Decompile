package id.dana.lib.gcontainer.app.bridge.share;

import android.app.Activity;
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
import id.dana.danah5.akulaku.AkuEventParamsKey;
import id.dana.danah5.share.file.businessaccount.ShareBusinessAccountFileEvent;
import id.dana.lib.gcontainer.app.bridge.constant.BridgeKey;
import id.dana.lib.gcontainer.app.bridge.core.BaseBridge;
import id.dana.lib.gcontainer.app.bridge.downloadfile.DownloadFileEntity;
import id.dana.lib.gcontainer.app.bridge.downloadfile.DownloadUtil;
import id.dana.lib.gcontainer.app.bridge.downloadfile.IDownloadListener;
import id.dana.lib.gcontainer.app.bridge.downloadfile.businessaccount.model.DownloadResult;
import id.dana.lib.gcontainer.app.bridge.share.text.ShareTextEntity;
import id.dana.lib.gcontainer.app.bridge.share.text.ShareTextManager;
import id.dana.lib.gcontainer.extension.BridgeExtensionExtKt;
import io.reactivex.Observable;
import java.net.MalformedURLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b#\u0010$J\u0019\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\b\u0010\u0006J\u000f\u0010\t\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\t\u0010\nJ'\u0010\u0011\u001a\u00020\u00102\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u000eH\u0002¢\u0006\u0004\b\u0011\u0010\u0012J'\u0010\u0013\u001a\u00020\u00102\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u000eH\u0002¢\u0006\u0004\b\u0013\u0010\u0012J\u0017\u0010\u0016\u001a\u00020\u00102\u0006\u0010\u0015\u001a\u00020\u0014H\u0002¢\u0006\u0004\b\u0016\u0010\u0017J7\u0010\u001b\u001a\u00020\u00102\b\b\u0001\u0010\u0019\u001a\u00020\u00182\b\b\u0001\u0010\u001a\u001a\u00020\u00022\b\b\u0001\u0010\r\u001a\u00020\u00042\b\b\u0001\u0010\u000f\u001a\u00020\u000eH\u0007¢\u0006\u0004\b\u001b\u0010\u001cJ7\u0010\u001d\u001a\u00020\u00102\b\b\u0001\u0010\u0019\u001a\u00020\u00182\b\b\u0001\u0010\u001a\u001a\u00020\u00022\b\b\u0001\u0010\r\u001a\u00020\u00042\b\b\u0001\u0010\u000f\u001a\u00020\u000eH\u0007¢\u0006\u0004\b\u001d\u0010\u001cR\u0016\u0010\f\u001a\u00020\u000b8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b\f\u0010\u001eR\u0016\u0010\u000f\u001a\u00020\u000e8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b\u000f\u0010\u001fR\u0016\u0010!\u001a\u00020 8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b!\u0010\""}, d2 = {"Lid/dana/lib/gcontainer/app/bridge/share/ShareBridge;", "Lid/dana/lib/gcontainer/app/bridge/core/BaseBridge;", "", "errorType", "Lcom/alibaba/fastjson/JSONObject;", "createErrorResult", "(Ljava/lang/String;)Lcom/alibaba/fastjson/JSONObject;", BridgeKey.FILE_PATH, "createSuccessResult", "generateTimeFormat", "()Ljava/lang/String;", "Landroid/app/Activity;", AkuEventParamsKey.KEY_ACTIVITY, "info", "Lcom/alibaba/ariver/engine/api/bridge/extension/BridgeCallback;", "bridgeCallback", "", "handleEventShareFile", "(Landroid/app/Activity;Lcom/alibaba/fastjson/JSONObject;Lcom/alibaba/ariver/engine/api/bridge/extension/BridgeCallback;)V", "handleEventShareText", "Lid/dana/lib/gcontainer/app/bridge/downloadfile/businessaccount/model/DownloadResult;", "downloadResult", "mapDownloadResult", "(Lid/dana/lib/gcontainer/app/bridge/downloadfile/businessaccount/model/DownloadResult;)V", "Lcom/alibaba/ariver/app/api/Page;", "page", "event", "share", "(Lcom/alibaba/ariver/app/api/Page;Ljava/lang/String;Lcom/alibaba/fastjson/JSONObject;Lcom/alibaba/ariver/engine/api/bridge/extension/BridgeCallback;)V", "shareFile", "Landroid/app/Activity;", "Lcom/alibaba/ariver/engine/api/bridge/extension/BridgeCallback;", "Lid/dana/lib/gcontainer/app/bridge/downloadfile/DownloadFileEntity;", "downloadFileEntity", "Lid/dana/lib/gcontainer/app/bridge/downloadfile/DownloadFileEntity;", "<init>", "()V"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes2.dex */
public final class ShareBridge extends BaseBridge {
    private Activity activity;
    private BridgeCallback bridgeCallback;
    private DownloadFileEntity downloadFileEntity;

    @ThreadType(ExecutorType.UI)
    @ActionFilter(canOverride = false)
    public final void share(@BindingNode(Page.class) Page page, @BindingParam(name = {"event"}) String event, @BindingParam(name = {"info"}) JSONObject info, @BindingCallback BridgeCallback bridgeCallback) {
        Intrinsics.checkNotNullParameter(page, "");
        Intrinsics.checkNotNullParameter(event, "");
        Intrinsics.checkNotNullParameter(info, "");
        Intrinsics.checkNotNullParameter(bridgeCallback, "");
        Activity activity = BridgeExtensionExtKt.getActivity(page);
        if (activity == null) {
            return;
        }
        this.activity = activity;
        this.bridgeCallback = bridgeCallback;
        Object obj = null;
        try {
            obj = JSONObject.parseObject(info.toJSONString(), new TypeReference<DownloadFileEntity>() { // from class: id.dana.lib.gcontainer.app.bridge.share.ShareBridge$share$$inlined$toObject$default$1
            }, new Feature[0]);
        } catch (JSONException | NullPointerException unused) {
        }
        DownloadFileEntity downloadFileEntity = (DownloadFileEntity) obj;
        if (downloadFileEntity == null) {
            return;
        }
        this.downloadFileEntity = downloadFileEntity;
        Activity activity2 = BridgeExtensionExtKt.getActivity(page);
        if (activity2 == null) {
            return;
        }
        if (Intrinsics.areEqual(event, "text")) {
            handleEventShareText(activity2, info, bridgeCallback);
        } else if (Intrinsics.areEqual(event, "file")) {
            handleEventShareFile(activity2, info, bridgeCallback);
        }
    }

    @ThreadType(ExecutorType.UI)
    @ActionFilter(canOverride = false)
    public final void shareFile(@BindingNode(Page.class) Page page, @BindingParam(name = {"event"}) String event, @BindingParam(name = {"info"}) JSONObject info, @BindingCallback BridgeCallback bridgeCallback) {
        Intrinsics.checkNotNullParameter(page, "");
        Intrinsics.checkNotNullParameter(event, "");
        Intrinsics.checkNotNullParameter(info, "");
        Intrinsics.checkNotNullParameter(bridgeCallback, "");
        Activity activity = BridgeExtensionExtKt.getActivity(page);
        if (activity == null) {
            return;
        }
        this.activity = activity;
        this.bridgeCallback = bridgeCallback;
        Object obj = null;
        try {
            obj = JSONObject.parseObject(info.toJSONString(), new TypeReference<DownloadFileEntity>() { // from class: id.dana.lib.gcontainer.app.bridge.share.ShareBridge$shareFile$$inlined$toObject$default$1
            }, new Feature[0]);
        } catch (JSONException | NullPointerException unused) {
        }
        DownloadFileEntity downloadFileEntity = (DownloadFileEntity) obj;
        if (downloadFileEntity == null) {
            return;
        }
        this.downloadFileEntity = downloadFileEntity;
        Activity activity2 = BridgeExtensionExtKt.getActivity(page);
        if (activity2 != null && Intrinsics.areEqual(event, ShareBusinessAccountFileEvent.BUSINESS_ACCOUNT_QR)) {
            handleEventShareFile(activity2, info, bridgeCallback);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: handleEventShareFile$lambda-0  reason: not valid java name */
    public static final Observable m2656handleEventShareFile$lambda0(DownloadFileEntity downloadFileEntity, String str, String str2, String str3) {
        String str4 = "";
        Intrinsics.checkNotNullParameter(str, "");
        Intrinsics.checkNotNullParameter(str2, "");
        Intrinsics.checkNotNullParameter(str3, "");
        try {
            DownloadUtil downloadUtil = DownloadUtil.INSTANCE;
            String fileType = downloadFileEntity == null ? null : downloadFileEntity.getFileType();
            if (fileType != null) {
                str4 = fileType;
            }
            return downloadUtil.downloadFile(str, str2, str4);
        } catch (MalformedURLException e) {
            return Observable.error(e);
        }
    }

    private final String generateTimeFormat() {
        String format = new SimpleDateFormat("ddMMyy_HHmmss").format(new Date());
        Intrinsics.checkNotNullExpressionValue(format, "");
        return format;
    }

    private final void mapDownloadResult(DownloadResult downloadResult) {
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

    private final void handleEventShareText(Activity activity, JSONObject info, BridgeCallback bridgeCallback) {
        Object obj;
        try {
            obj = JSONObject.parseObject(info.toJSONString(), new TypeReference<ShareTextEntity>() { // from class: id.dana.lib.gcontainer.app.bridge.share.ShareBridge$handleEventShareText$$inlined$toObject$default$1
            }, new Feature[0]);
        } catch (JSONException | NullPointerException unused) {
            obj = null;
        }
        new ShareTextManager(activity, (ShareTextEntity) obj, bridgeCallback).processEvent();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v0, types: [kotlin.jvm.internal.DefaultConstructorMarker, java.lang.String] */
    /* JADX WARN: Type inference failed for: r1v7 */
    private final void handleEventShareFile(Activity activity, JSONObject info, BridgeCallback bridgeCallback) {
        Object obj;
        String stringPlus;
        try {
            obj = JSONObject.parseObject(info.toJSONString(), new TypeReference<DownloadFileEntity>() { // from class: id.dana.lib.gcontainer.app.bridge.share.ShareBridge$handleEventShareFile$$inlined$toObject$default$1
            }, new Feature[0]);
        } catch (JSONException | NullPointerException unused) {
            obj = null;
        }
        final DownloadFileEntity downloadFileEntity = (DownloadFileEntity) obj;
        String filePath = downloadFileEntity == null ? null : downloadFileEntity.getFilePath();
        if (filePath == null) {
            filePath = downloadFileEntity == null ? null : downloadFileEntity.getSource();
            if (filePath == null) {
                filePath = downloadFileEntity == null ? null : downloadFileEntity.getUrl();
            }
        }
        String str = filePath;
        if (str == null || str.length() == 0) {
            mapDownloadResult(new DownloadResult("GENERAL_ERROR", r1, 2, r1));
            return;
        }
        String businessName = downloadFileEntity == null ? null : downloadFileEntity.getBusinessName();
        if (businessName == null) {
            businessName = "";
        }
        if (businessName.length() > 0) {
            StringBuilder sb = new StringBuilder();
            sb.append(downloadFileEntity != null ? downloadFileEntity.getBusinessName() : 0);
            sb.append('_');
            sb.append(generateTimeFormat());
            stringPlus = sb.toString();
        } else {
            stringPlus = Intrinsics.stringPlus("DANA_", Long.valueOf(System.currentTimeMillis()));
        }
        new ShareFileManager(activity, bridgeCallback, new IDownloadListener() { // from class: id.dana.lib.gcontainer.app.bridge.share.ShareBridge$$ExternalSyntheticLambda0
            @Override // id.dana.lib.gcontainer.app.bridge.downloadfile.IDownloadListener
            public final Observable download(String str2, String str3, String str4) {
                Observable m2656handleEventShareFile$lambda0;
                m2656handleEventShareFile$lambda0 = ShareBridge.m2656handleEventShareFile$lambda0(DownloadFileEntity.this, str2, str3, str4);
                return m2656handleEventShareFile$lambda0;
            }
        }).processEvent(filePath, stringPlus, ".jpg", "image/jpeg");
    }

    private final JSONObject createSuccessResult(String filePath) {
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = jSONObject;
        jSONObject2.put((JSONObject) "success", (String) Boolean.TRUE);
        jSONObject2.put((JSONObject) BridgeKey.FILE_PATH, filePath);
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
