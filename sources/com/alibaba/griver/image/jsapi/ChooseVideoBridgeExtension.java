package com.alibaba.griver.image.jsapi;

import android.content.DialogInterface;
import android.os.Bundle;
import android.text.TextUtils;
import com.alibaba.ariver.app.api.Page;
import com.alibaba.ariver.app.api.permission.IPermissionRequestCallback;
import com.alibaba.ariver.engine.api.bridge.extension.BridgeCallback;
import com.alibaba.ariver.engine.api.bridge.extension.annotation.BindingApiContext;
import com.alibaba.ariver.engine.api.bridge.extension.annotation.BindingCallback;
import com.alibaba.ariver.engine.api.bridge.extension.annotation.BindingNode;
import com.alibaba.ariver.engine.api.bridge.extension.annotation.BindingParam;
import com.alibaba.ariver.engine.api.bridge.extension.annotation.BindingRequest;
import com.alibaba.ariver.engine.api.bridge.model.ApiContext;
import com.alibaba.ariver.kernel.api.annotation.ActionFilter;
import com.alibaba.ariver.kernel.api.annotation.ThreadType;
import com.alibaba.ariver.kernel.api.extension.bridge.SimpleBridgeExtension;
import com.alibaba.ariver.kernel.common.RVProxy;
import com.alibaba.ariver.kernel.common.service.RVAccountService;
import com.alibaba.ariver.kernel.common.service.executor.ExecutorType;
import com.alibaba.ariver.kernel.common.storage.KVStorageProxy;
import com.alibaba.ariver.kernel.common.utils.RVLogger;
import com.alibaba.ariver.permission.service.LocalAuthPermissionManager;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.griver.api.common.monitor.GriverMonitorConstants;
import com.alibaba.griver.base.common.monitor.GriverMonitor;
import com.alibaba.griver.base.common.monitor.MonitorMap;
import com.alibaba.griver.base.common.utils.PermissionUtils;
import com.alibaba.griver.image.capture.CaptureServiceImpl;
import com.alibaba.griver.image.capture.listener.CaptureListener;
import com.alibaba.griver.image.capture.meta.CaptureParam;
import com.alibaba.griver.image.capture.meta.MediaInfo;
import com.alibaba.griver.image.photo.PhotoServiceImpl;
import com.alibaba.griver.image.photo.listener.PhotoSelectListener;
import com.alibaba.griver.image.photo.meta.PhotoInfo;
import com.alibaba.griver.image.photo.meta.PhotoParam;
import com.alibaba.griver.ui.ant.dialog.AUListDialog;
import com.alibaba.griver.ui.ant.model.PopMenuItem;
import com.alipay.mobile.zebra.data.ZebraData;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes2.dex */
public class ChooseVideoBridgeExtension extends SimpleBridgeExtension {
    public static final int ERROR_INTERNAL = 40;
    public static final int ERROR_USER_CANCEL = 10;

    /* renamed from: a  reason: collision with root package name */
    private static final String[] f6597a = {"album", "camera"};
    private static final String[] b = {"front", "back"};
    private PhotoSelectListener c;
    private CaptureListener d;

    private void a(String str, JSONObject jSONObject) {
    }

    @ThreadType(ExecutorType.UI)
    @ActionFilter
    public void chooseVideo(@BindingNode(Page.class) Page page, @BindingApiContext ApiContext apiContext, @BindingParam({"sourceType"}) String[] strArr, @BindingParam({"camera"}) String[] strArr2, @BindingParam({"enableEdit"}) boolean z, @BindingParam({"compressed"}) boolean z2, @BindingParam({"maxDuration"}) int i, @BindingParam({"isShowVideoTimeIndicator"}) boolean z3, @BindingRequest JSONObject jSONObject, @BindingCallback BridgeCallback bridgeCallback) {
        String[] strArr3 = strArr;
        String[] strArr4 = strArr2;
        if (strArr3 == null || strArr3.length == 0) {
            strArr3 = f6597a;
        }
        if (strArr4 == null || strArr4.length == 0) {
            strArr4 = b;
        }
        String[] strArr5 = strArr4;
        StringBuilder sb = new StringBuilder();
        sb.append("onVideoSelectCalled :params = ");
        sb.append(jSONObject);
        RVLogger.w("ChooseVideoBridgeExtension", sb.toString());
        int i2 = i;
        if (i2 > 60) {
            i2 = 60;
        }
        if (i2 <= 0) {
            i2 = 60;
        }
        if (strArr3.length > 1) {
            if (TextUtils.equals(((KVStorageProxy) RVProxy.get(KVStorageProxy.class)).getString(page.getApp().getAppId(), a(page.getApp().getAppId(), LocalAuthPermissionManager.SCOPE.CONST_SCOPE_WRITE_PHOTOS_ALBUM)), "-1")) {
                a(page, bridgeCallback, strArr5, i2);
            } else {
                a(page, bridgeCallback, z, i2, z2, z3, strArr5);
            }
        } else if (TextUtils.equals("album", strArr3[0])) {
            a(page, bridgeCallback, z, i2, z2, z3);
        } else if (TextUtils.equals("camera", strArr3[0])) {
            a(page, bridgeCallback, strArr5, i2);
        } else {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("Invalid  param : sourceType = ");
            sb2.append(strArr3[0]);
            a("fail", sb2.toString(), page.getApp().getAppId());
            StringBuilder sb3 = new StringBuilder();
            sb3.append("Invalid  param : sourceType = ");
            sb3.append(strArr3[0]);
            notifyFail(bridgeCallback, 2, sb3.toString());
        }
    }

    private void a(final Page page, final BridgeCallback bridgeCallback, final boolean z, final int i, final boolean z2, final boolean z3, final String[] strArr) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new PopMenuItem("choose from album"));
        arrayList.add(new PopMenuItem("record video"));
        AUListDialog aUListDialog = new AUListDialog(arrayList, page.getPageContext().getActivity());
        aUListDialog.setOnCancelListener(new DialogInterface.OnCancelListener() { // from class: com.alibaba.griver.image.jsapi.ChooseVideoBridgeExtension.1
            @Override // android.content.DialogInterface.OnCancelListener
            public void onCancel(DialogInterface dialogInterface) {
                ChooseVideoBridgeExtension.this.a("fail", "User cancel select action.", page.getApp().getAppId());
                ChooseVideoBridgeExtension.this.notifyFail(bridgeCallback, 10, "User cancel select action.");
            }
        });
        aUListDialog.setOnItemClickListener(new AUListDialog.OnItemClickListener() { // from class: com.alibaba.griver.image.jsapi.ChooseVideoBridgeExtension.2
            @Override // com.alibaba.griver.ui.ant.dialog.AUListDialog.OnItemClickListener
            public void onItemClick(int i2) {
                if (i2 == 0) {
                    ChooseVideoBridgeExtension.this.a(page, bridgeCallback, z, i, z2, z3);
                } else if (i2 == 1) {
                    ChooseVideoBridgeExtension.this.a(page, bridgeCallback, strArr, i);
                }
            }
        });
        aUListDialog.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(final Page page, final BridgeCallback bridgeCallback, boolean z, int i, boolean z2, boolean z3) {
        this.c = new PhotoSelectListener() { // from class: com.alibaba.griver.image.jsapi.ChooseVideoBridgeExtension.3
            @Override // com.alibaba.griver.image.photo.listener.PhotoSelectListener
            public void onPhotoSelected(List<PhotoInfo> list, Bundle bundle) {
                ChooseVideoBridgeExtension.this.c = null;
                if (list == null || list.size() <= 0) {
                    ChooseVideoBridgeExtension.this.a("fail", "PhotoService selected return invalid!", page.getApp().getAppId());
                    ChooseVideoBridgeExtension.this.notifyFail(bridgeCallback, 40, "PhotoService selected return invalid!");
                    return;
                }
                PhotoInfo photoInfo = list.get(0);
                ChooseVideoBridgeExtension.this.a("success", "", page.getApp().getAppId());
                ChooseVideoBridgeExtension.this.a(bridgeCallback, photoInfo.getVideoPath(), (int) photoInfo.getVideoDuration(), photoInfo.getPhotoSize(), photoInfo.getVideoHeight(), photoInfo.getVideoWidth(), "album");
            }

            @Override // com.alibaba.griver.image.photo.listener.PhotoSelectListener
            public void onSelectCanceled() {
                ChooseVideoBridgeExtension.this.c = null;
                ChooseVideoBridgeExtension.this.a("fail", "User cancel select video.", page.getApp().getAppId());
                ChooseVideoBridgeExtension.this.notifyFail(bridgeCallback, 10, "User cancel select video.");
            }
        };
        Bundle bundle = new Bundle();
        bundle.putInt(PhotoParam.MAX_SELECT, 1);
        bundle.putBoolean(PhotoParam.ENABLE_CAMERA, false);
        bundle.putBoolean(PhotoParam.SELECT_VIDEO_ONLY, true);
        bundle.putString("businessId", "VIDEO_SELECT_PLUGIN_BUSINESS_ID");
        try {
            bundle.putString(PhotoParam.FINISH_TEXT, "确定");
        } catch (Throwable th) {
            StringBuilder sb = new StringBuilder();
            sb.append("Get string res exception.");
            sb.append(th.getMessage());
            RVLogger.w("ChooseVideoBridgeExtension", sb.toString());
        }
        new PhotoServiceImpl().selectPhoto(page.getApp(), bundle, this.c);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(final Page page, final BridgeCallback bridgeCallback, final String[] strArr, final int i) {
        if (!PermissionUtils.hasPermission("android.permission.CAMERA")) {
            PermissionUtils.requestPermission("android.permission.CAMERA", 2002, new IPermissionRequestCallback() { // from class: com.alibaba.griver.image.jsapi.ChooseVideoBridgeExtension.4
                @Override // com.alibaba.ariver.app.api.permission.IPermissionRequestCallback
                public void onRequestPermissionResult(int i2, String[] strArr2, int[] iArr) {
                    if (PermissionUtils.positivePermissionResult(iArr)) {
                        ChooseVideoBridgeExtension.this.b(page, bridgeCallback, strArr, i);
                    } else {
                        ChooseVideoBridgeExtension.this.notifyFail(bridgeCallback, 2001, "No camera or album access rights");
                    }
                }
            });
        } else {
            b(page, bridgeCallback, strArr, i);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(final Page page, final BridgeCallback bridgeCallback, String[] strArr, int i) {
        this.d = new CaptureListener() { // from class: com.alibaba.griver.image.jsapi.ChooseVideoBridgeExtension.5
            @Override // com.alibaba.griver.image.capture.listener.CaptureListener
            public void onAction(boolean z, MediaInfo mediaInfo) {
                if (z) {
                    ChooseVideoBridgeExtension.this.a("fail", "User cancel record video.", page.getApp().getAppId());
                    ChooseVideoBridgeExtension.this.notifyFail(bridgeCallback, 10, "User cancel record video.");
                } else if (mediaInfo == null || TextUtils.isEmpty(mediaInfo.path)) {
                    ChooseVideoBridgeExtension.this.a("fail", "CaptureService return invalid mediaInfo!", page.getApp().getAppId());
                    ChooseVideoBridgeExtension.this.notifyFail(bridgeCallback, 40, "CaptureService return invalid mediaInfo!");
                    return;
                } else {
                    ChooseVideoBridgeExtension.this.a(mediaInfo);
                    ChooseVideoBridgeExtension.this.a("success", "", page.getApp().getAppId());
                    ChooseVideoBridgeExtension.this.a(bridgeCallback, mediaInfo.path, (int) (mediaInfo.durationMs / 1000), mediaInfo.mediaFileSize, mediaInfo.heightPx, mediaInfo.widthPx, "camera");
                }
                ChooseVideoBridgeExtension.this.d = null;
            }
        };
        Bundle bundle = new Bundle();
        bundle.putInt(CaptureParam.KEY_MAX_DURATION, i);
        bundle.putInt(CaptureParam.CAPTURE_MODE, 1);
        if (strArr.length < 2) {
            bundle.putBoolean(CaptureParam.ENABLE_SWITCH_CAMERA, false);
            if (TextUtils.equals(strArr[0], "front")) {
                bundle.putInt(CaptureParam.INIT_CAMERA_FACING, 1);
            } else {
                bundle.putInt(CaptureParam.INIT_CAMERA_FACING, 0);
            }
        }
        new CaptureServiceImpl().capture(page.getApp(), this.d, "VIDEO_SELECT_PLUGIN_BUSINESS_ID", bundle);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(MediaInfo mediaInfo) {
        if (mediaInfo.rotation == 90 || mediaInfo.rotation == 270) {
            int i = mediaInfo.widthPx;
            mediaInfo.widthPx = mediaInfo.heightPx;
            mediaInfo.heightPx = i;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(BridgeCallback bridgeCallback, String str, int i, long j, int i2, int i3, String str2) {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("success", (Object) Boolean.TRUE);
        jSONObject.put("scene", (Object) str2);
        jSONObject.put("tempFilePath", (Object) str);
        if (!TextUtils.isEmpty(str)) {
            jSONObject.put("localId", (Object) str);
            a(str, jSONObject);
        }
        jSONObject.put("duration", (Object) Integer.valueOf(i));
        jSONObject.put(GriverMonitorConstants.KEY_SIZE, (Object) Long.valueOf(j));
        jSONObject.put(ZebraData.ATTR_HEIGHT, (Object) Integer.valueOf(i2));
        jSONObject.put(ZebraData.ATTR_WIDTH, (Object) Integer.valueOf(i3));
        bridgeCallback.sendJSONResponse(jSONObject);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, String str2, String str3) {
        MonitorMap.Builder needAsynAppType = new MonitorMap.Builder().appId(str3).needAsynAppType(true);
        needAsynAppType.append("result", str);
        needAsynAppType.append("errormsg", str2);
        GriverMonitor.event("choose_video_jsapi_event", "GriverAppContainer", needAsynAppType.build());
    }

    protected void notifyFail(BridgeCallback bridgeCallback, int i, String str) {
        StringBuilder sb = new StringBuilder();
        sb.append("fail reason: ");
        sb.append(str);
        RVLogger.debug("ChooseVideoBridgeExtension", sb.toString());
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("success", (Object) Boolean.FALSE);
        jSONObject.put("errorCode", (Object) Integer.valueOf(i));
        jSONObject.put("errorDesc", (Object) str);
        bridgeCallback.sendJSONResponse(jSONObject);
    }

    private String a(String str, String str2) {
        String userId = ((RVAccountService) RVProxy.get(RVAccountService.class)).getUserId();
        StringBuilder sb = new StringBuilder();
        sb.append(userId);
        sb.append("_");
        sb.append(str);
        sb.append("_");
        sb.append(str2.substring(str2.indexOf(".") + 1, str2.length()));
        return sb.toString();
    }
}
