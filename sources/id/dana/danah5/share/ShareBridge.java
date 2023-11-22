package id.dana.danah5.share;

import android.app.Activity;
import android.app.Application;
import com.alibaba.ariver.app.api.Page;
import com.alibaba.ariver.engine.api.bridge.extension.BridgeCallback;
import com.alibaba.ariver.engine.api.bridge.extension.annotation.BindingCallback;
import com.alibaba.ariver.engine.api.bridge.extension.annotation.BindingNode;
import com.alibaba.ariver.engine.api.bridge.extension.annotation.BindingParam;
import com.alibaba.ariver.kernel.api.annotation.ActionFilter;
import com.alibaba.ariver.kernel.api.annotation.ThreadType;
import com.alibaba.ariver.kernel.common.service.executor.ExecutorType;
import com.alibaba.ariver.kernel.ipc.IpcMessageConstants;
import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.TypeReference;
import com.alibaba.fastjson.parser.Feature;
import com.alibaba.griver.base.common.env.GriverEnv;
import dagger.internal.Preconditions;
import id.dana.DanaApplication;
import id.dana.danah5.akulaku.AkuEventParamsKey;
import id.dana.danah5.share.binary.ShareBinaryEntity;
import id.dana.danah5.share.binary.ShareBinaryManager;
import id.dana.danah5.share.directtext.ShareDirectTextEntity;
import id.dana.danah5.share.file.businessaccount.ShareBusinessAccountFileEntity;
import id.dana.danah5.share.file.businessaccount.ShareBusinessAccountFileEvent;
import id.dana.danah5.share.file.businessaccount.ShareBusinessAccountManager;
import id.dana.danah5.share.file.generic.ShareFileEntity;
import id.dana.danah5.share.file.generic.ShareFileManager;
import id.dana.danah5.share.text.ShareTextManager;
import id.dana.data.risk.riskevent.sharetextbroadcast.ShareTextBroadcastReceiver;
import id.dana.data.util.download.DownloadUtil;
import id.dana.di.component.ApplicationComponent;
import id.dana.di.component.DaggerGContainerComponent;
import id.dana.di.modules.GContainerModule;
import id.dana.lib.gcontainer.app.bridge.core.BaseBridge;
import id.dana.lib.gcontainer.app.bridge.downloadfile.IDownloadListener;
import id.dana.lib.gcontainer.app.bridge.share.text.ShareTextEntity;
import id.dana.lib.gcontainer.extension.BridgeExtensionExtKt;
import io.reactivex.Observable;
import java.net.MalformedURLException;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000  2\u00020\u0001:\u0001 B\u0007¢\u0006\u0004\b\u001f\u0010\u0010J'\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\t\u0010\nJ'\u0010\u000b\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u000b\u0010\nJ'\u0010\f\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\f\u0010\nJ'\u0010\r\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\r\u0010\nJ'\u0010\u000e\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u000e\u0010\nJ\u000f\u0010\u000f\u001a\u00020\bH\u0016¢\u0006\u0004\b\u000f\u0010\u0010J9\u0010\u0015\u001a\u00020\b2\n\b\u0001\u0010\u0012\u001a\u0004\u0018\u00010\u00112\b\b\u0001\u0010\u0005\u001a\u00020\u00042\b\b\u0001\u0010\u0007\u001a\u00020\u00062\b\b\u0001\u0010\u0014\u001a\u00020\u0013H\u0007¢\u0006\u0004\b\u0015\u0010\u0016J9\u0010\u0017\u001a\u00020\b2\n\b\u0001\u0010\u0012\u001a\u0004\u0018\u00010\u00112\b\b\u0001\u0010\u0005\u001a\u00020\u00042\b\b\u0001\u0010\u0007\u001a\u00020\u00062\b\b\u0001\u0010\u0014\u001a\u00020\u0013H\u0007¢\u0006\u0004\b\u0017\u0010\u0016R\"\u0010\u0019\u001a\u00020\u00188\u0007@\u0007X\u0087.¢\u0006\u0012\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001e"}, d2 = {"Lid/dana/danah5/share/ShareBridge;", "Lid/dana/lib/gcontainer/app/bridge/core/BaseBridge;", "Landroid/app/Activity;", AkuEventParamsKey.KEY_ACTIVITY, "Lcom/alibaba/fastjson/JSONObject;", "info", "Lcom/alibaba/ariver/engine/api/bridge/extension/BridgeCallback;", "bridgeCallback", "", "handleEventShareDirectText", "(Landroid/app/Activity;Lcom/alibaba/fastjson/JSONObject;Lcom/alibaba/ariver/engine/api/bridge/extension/BridgeCallback;)V", "handleEventShareText", "handleShareBinary", "handleShareFile", "handleShareQrEvent", "onInitialized", "()V", "", IpcMessageConstants.EXTRA_EVENT, "Lcom/alibaba/ariver/app/api/Page;", "page", "share", "(Ljava/lang/String;Lcom/alibaba/fastjson/JSONObject;Lcom/alibaba/ariver/engine/api/bridge/extension/BridgeCallback;Lcom/alibaba/ariver/app/api/Page;)V", "shareFile", "Lid/dana/data/risk/riskevent/sharetextbroadcast/ShareTextBroadcastReceiver;", "shareTextBroadcastReceiver", "Lid/dana/data/risk/riskevent/sharetextbroadcast/ShareTextBroadcastReceiver;", "getShareTextBroadcastReceiver", "()Lid/dana/data/risk/riskevent/sharetextbroadcast/ShareTextBroadcastReceiver;", "setShareTextBroadcastReceiver", "(Lid/dana/data/risk/riskevent/sharetextbroadcast/ShareTextBroadcastReceiver;)V", "<init>", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class ShareBridge extends BaseBridge {
    private static final String SHARE_BINARY = "binary";
    @Inject
    public ShareTextBroadcastReceiver shareTextBroadcastReceiver;

    @JvmName(name = "getShareTextBroadcastReceiver")
    public final ShareTextBroadcastReceiver getShareTextBroadcastReceiver() {
        ShareTextBroadcastReceiver shareTextBroadcastReceiver = this.shareTextBroadcastReceiver;
        if (shareTextBroadcastReceiver != null) {
            return shareTextBroadcastReceiver;
        }
        Intrinsics.throwUninitializedPropertyAccessException("");
        return null;
    }

    @JvmName(name = "setShareTextBroadcastReceiver")
    public final void setShareTextBroadcastReceiver(ShareTextBroadcastReceiver shareTextBroadcastReceiver) {
        Intrinsics.checkNotNullParameter(shareTextBroadcastReceiver, "");
        this.shareTextBroadcastReceiver = shareTextBroadcastReceiver;
    }

    @ThreadType(ExecutorType.NORMAL)
    @ActionFilter(canOverride = false)
    public final void share(@BindingParam(name = {"event"}) String eventName, @BindingParam(name = {"info"}) JSONObject info, @BindingCallback BridgeCallback bridgeCallback, @BindingNode(Page.class) Page page) {
        Intrinsics.checkNotNullParameter(info, "");
        Intrinsics.checkNotNullParameter(bridgeCallback, "");
        Intrinsics.checkNotNullParameter(page, "");
        Activity activity = BridgeExtensionExtKt.getActivity(page);
        if (activity == null || eventName == null) {
            return;
        }
        switch (eventName.hashCode()) {
            case -1388966911:
                if (eventName.equals(SHARE_BINARY)) {
                    handleShareBinary(activity, info, bridgeCallback);
                    return;
                }
                return;
            case 3143036:
                if (eventName.equals("file")) {
                    handleShareFile(activity, info, bridgeCallback);
                    return;
                }
                return;
            case 3556653:
                if (eventName.equals("text")) {
                    handleEventShareText(activity, info, bridgeCallback);
                    return;
                }
                return;
            case 223819958:
                if (eventName.equals("directText")) {
                    handleEventShareDirectText(activity, info, bridgeCallback);
                    return;
                }
                return;
            default:
                return;
        }
    }

    @Override // id.dana.lib.gcontainer.app.bridge.core.BaseBridge, com.alibaba.ariver.kernel.api.extension.bridge.SimpleBridgeExtension, com.alibaba.ariver.kernel.api.extension.Extension
    public final void onInitialized() {
        super.onInitialized();
        DaggerGContainerComponent.Builder PlaceComponentResult = DaggerGContainerComponent.PlaceComponentResult();
        Application applicationContext = GriverEnv.getApplicationContext();
        if (applicationContext == null) {
            throw new NullPointerException("null cannot be cast to non-null type id.dana.DanaApplication");
        }
        PlaceComponentResult.PlaceComponentResult = (ApplicationComponent) Preconditions.getAuthRequestContext(((DanaApplication) applicationContext).getApplicationComponent());
        PlaceComponentResult.getAuthRequestContext = (GContainerModule) Preconditions.getAuthRequestContext(new GContainerModule());
        PlaceComponentResult.KClassImpl$Data$declaredNonStaticMembers$2().BuiltInFictitiousFunctionClassFactory(this);
    }

    @ThreadType(ExecutorType.NORMAL)
    @ActionFilter(canOverride = false)
    public final void shareFile(@BindingParam(name = {"event"}) String eventName, @BindingParam(name = {"info"}) JSONObject info, @BindingCallback BridgeCallback bridgeCallback, @BindingNode(Page.class) Page page) {
        Activity activity;
        Intrinsics.checkNotNullParameter(info, "");
        Intrinsics.checkNotNullParameter(bridgeCallback, "");
        Intrinsics.checkNotNullParameter(page, "");
        if (!Intrinsics.areEqual(ShareBusinessAccountFileEvent.BUSINESS_ACCOUNT_QR, eventName) || (activity = BridgeExtensionExtKt.getActivity(page)) == null) {
            return;
        }
        handleShareQrEvent(activity, info, bridgeCallback);
    }

    private final void handleEventShareDirectText(Activity activity, JSONObject info, BridgeCallback bridgeCallback) {
        Object obj;
        ShareTextManager shareTextManager = new ShareTextManager(activity, bridgeCallback, getShareTextBroadcastReceiver());
        try {
            obj = JSONObject.parseObject(info.toJSONString(), new TypeReference<ShareDirectTextEntity>() { // from class: id.dana.danah5.share.ShareBridge$handleEventShareDirectText$$inlined$toObject$default$1
            }, new Feature[0]);
        } catch (JSONException | NullPointerException unused) {
            obj = null;
        }
        shareTextManager.processEvent((ShareDirectTextEntity) obj);
    }

    private final void handleEventShareText(Activity activity, JSONObject info, BridgeCallback bridgeCallback) {
        Object obj;
        ShareTextManager shareTextManager = new ShareTextManager(activity, bridgeCallback, getShareTextBroadcastReceiver());
        try {
            obj = JSONObject.parseObject(info.toJSONString(), new TypeReference<ShareTextEntity>() { // from class: id.dana.danah5.share.ShareBridge$handleEventShareText$$inlined$toObject$default$1
            }, new Feature[0]);
        } catch (JSONException | NullPointerException unused) {
            obj = null;
        }
        shareTextManager.processEvent((ShareTextEntity) obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: handleShareFile$lambda-0  reason: not valid java name */
    public static final Observable m717handleShareFile$lambda0(ShareFileEntity shareFileEntity, String str, String str2, String str3) {
        String fileType;
        String str4 = "";
        Intrinsics.checkNotNullParameter(str, "");
        Intrinsics.checkNotNullParameter(str2, "");
        Intrinsics.checkNotNullParameter(str3, "");
        if (shareFileEntity != null) {
            try {
                fileType = shareFileEntity.getFileType();
            } catch (MalformedURLException e) {
                return Observable.error(e);
            }
        } else {
            fileType = null;
        }
        if (fileType != null) {
            str4 = fileType;
        }
        return DownloadUtil.downloadFile(str, str2, str4);
    }

    private final void handleShareQrEvent(Activity activity, JSONObject info, BridgeCallback bridgeCallback) {
        Object obj;
        try {
            obj = JSONObject.parseObject(info.toJSONString(), new TypeReference<ShareBusinessAccountFileEntity>() { // from class: id.dana.danah5.share.ShareBridge$handleShareQrEvent$$inlined$toObject$default$1
            }, new Feature[0]);
        } catch (JSONException | NullPointerException unused) {
            obj = null;
        }
        new ShareBusinessAccountManager(activity, (ShareBusinessAccountFileEntity) obj, bridgeCallback).processEvent();
    }

    private final void handleShareFile(Activity activity, JSONObject info, BridgeCallback bridgeCallback) {
        Object obj;
        try {
            obj = JSONObject.parseObject(info.toJSONString(), new TypeReference<ShareFileEntity>() { // from class: id.dana.danah5.share.ShareBridge$handleShareFile$$inlined$toObject$default$1
            }, new Feature[0]);
        } catch (JSONException | NullPointerException unused) {
            obj = null;
        }
        final ShareFileEntity shareFileEntity = (ShareFileEntity) obj;
        ShareFileManager shareFileManager = new ShareFileManager(bridgeCallback, activity, new IDownloadListener() { // from class: id.dana.danah5.share.ShareBridge$$ExternalSyntheticLambda0
            @Override // id.dana.lib.gcontainer.app.bridge.downloadfile.IDownloadListener
            public final Observable download(String str, String str2, String str3) {
                Observable m717handleShareFile$lambda0;
                m717handleShareFile$lambda0 = ShareBridge.m717handleShareFile$lambda0(ShareFileEntity.this, str, str2, str3);
                return m717handleShareFile$lambda0;
            }
        });
        shareFileManager.setInfo(shareFileEntity);
        shareFileManager.processEvent();
    }

    private final void handleShareBinary(Activity activity, JSONObject info, BridgeCallback bridgeCallback) {
        Object obj;
        try {
            obj = JSONObject.parseObject(info.toJSONString(), new TypeReference<ShareBinaryEntity>() { // from class: id.dana.danah5.share.ShareBridge$handleShareBinary$$inlined$toObject$default$1
            }, new Feature[0]);
        } catch (JSONException | NullPointerException unused) {
            obj = null;
        }
        new ShareBinaryManager(activity, bridgeCallback).processEvent((ShareBinaryEntity) obj);
    }
}
