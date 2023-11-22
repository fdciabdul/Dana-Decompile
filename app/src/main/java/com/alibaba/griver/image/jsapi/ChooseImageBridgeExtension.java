package com.alibaba.griver.image.jsapi;

import android.content.DialogInterface;
import android.os.Bundle;
import android.text.TextUtils;
import com.alibaba.ariver.app.api.Page;
import com.alibaba.ariver.engine.api.bridge.extension.BridgeCallback;
import com.alibaba.ariver.engine.api.bridge.extension.annotation.BindingCallback;
import com.alibaba.ariver.engine.api.bridge.extension.annotation.BindingNode;
import com.alibaba.ariver.engine.api.bridge.extension.annotation.BindingParam;
import com.alibaba.ariver.engine.api.bridge.extension.annotation.BindingRequest;
import com.alibaba.ariver.kernel.api.annotation.ActionFilter;
import com.alibaba.ariver.kernel.api.annotation.ThreadType;
import com.alibaba.ariver.kernel.api.extension.bridge.SimpleBridgeExtension;
import com.alibaba.ariver.kernel.common.RVProxy;
import com.alibaba.ariver.kernel.common.service.RVAccountService;
import com.alibaba.ariver.kernel.common.service.executor.ExecutorType;
import com.alibaba.ariver.kernel.common.storage.KVStorageProxy;
import com.alibaba.ariver.kernel.common.utils.JSONUtils;
import com.alibaba.ariver.kernel.common.utils.RVLogger;
import com.alibaba.ariver.permission.service.LocalAuthPermissionManager;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.griver.api.common.monitor.GriverMonitorConstants;
import com.alibaba.griver.base.api.H5Event;
import com.alibaba.griver.base.common.env.GriverEnv;
import com.alibaba.griver.image.R;
import com.alibaba.griver.image.capture.CaptureServiceImpl;
import com.alibaba.griver.image.capture.listener.CaptureListener;
import com.alibaba.griver.image.capture.meta.CaptureParam;
import com.alibaba.griver.image.capture.meta.MediaInfo;
import com.alibaba.griver.image.framework.utils.PathToLocalUtil;
import com.alibaba.griver.image.photo.PhotoServiceImpl;
import com.alibaba.griver.image.photo.listener.PhotoSelectListener;
import com.alibaba.griver.image.photo.meta.PhotoInfo;
import com.alibaba.griver.image.photo.meta.PhotoParam;
import com.alibaba.griver.ui.ant.dialog.AUListDialog;
import com.alibaba.griver.ui.ant.model.PopMenuItem;
import id.dana.contract.payasset.SceneType;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/* loaded from: classes2.dex */
public class ChooseImageBridgeExtension extends SimpleBridgeExtension {
    public static final int ERROR_INTERNAL = 40;

    /* renamed from: a  reason: collision with root package name */
    private static CaptureListener f6596a;
    private PhotoSelectListener b;
    private boolean c;
    private float d;

    @ThreadType(ExecutorType.UI)
    @ActionFilter
    public void chooseImage(@BindingNode(Page.class) Page page, @BindingParam({"sourceType"}) String[] strArr, @BindingParam({"sizeType"}) String[] strArr2, @BindingParam(intDefault = 1, value = {"count"}) int i, @BindingRequest JSONObject jSONObject, @BindingCallback BridgeCallback bridgeCallback) {
        boolean z;
        if (strArr2 == null || strArr2.length <= 0) {
            z = false;
        } else {
            z = false;
            for (String str : strArr2) {
                if ("compressed".equalsIgnoreCase(str)) {
                    z = true;
                }
            }
        }
        boolean z2 = strArr2 != null && strArr2.length > 1;
        this.c = JSONUtils.getBoolean(jSONObject, "useFrontCamera", false);
        this.d = JSONUtils.getFloat(jSONObject, "beautyLevel");
        if (strArr == null || strArr.length != 1) {
            if (TextUtils.equals(((KVStorageProxy) RVProxy.get(KVStorageProxy.class)).getString(page.getApp().getAppId(), a(page.getApp().getAppId(), LocalAuthPermissionManager.SCOPE.CONST_SCOPE_WRITE_PHOTOS_ALBUM)), "-1")) {
                a(page, bridgeCallback);
            } else {
                a(page, bridgeCallback, i, z, z2);
            }
        } else if (TextUtils.equals("album", strArr[0])) {
            b(page, bridgeCallback, i, z, z2);
        } else if (TextUtils.equals("camera", strArr[0])) {
            a(page, bridgeCallback);
        } else {
            int ordinal = H5Event.Error.INVALID_PARAM.ordinal();
            StringBuilder sb = new StringBuilder();
            sb.append("Invalid  param : sourceType = ");
            sb.append(strArr[0]);
            notifyFail(bridgeCallback, ordinal, sb.toString(), null);
        }
    }

    private void a(final Page page, final BridgeCallback bridgeCallback, final int i, final boolean z, final boolean z2) {
        ArrayList arrayList = new ArrayList();
        String string = GriverEnv.getResources().getString(R.string.griver_image_h5p_select_photo_from_album);
        String string2 = GriverEnv.getResources().getString(R.string.griver_image_h5p_take_picture);
        arrayList.add(new PopMenuItem(string));
        arrayList.add(new PopMenuItem(string2));
        AUListDialog aUListDialog = new AUListDialog(arrayList, page.getPageContext().getActivity());
        aUListDialog.setOnCancelListener(new DialogInterface.OnCancelListener() { // from class: com.alibaba.griver.image.jsapi.ChooseImageBridgeExtension.1
            @Override // android.content.DialogInterface.OnCancelListener
            public void onCancel(DialogInterface dialogInterface) {
                ChooseImageBridgeExtension.this.notifyFail(bridgeCallback, 11, "User cancel select action.", null);
            }
        });
        aUListDialog.setOnItemClickListener(new AUListDialog.OnItemClickListener() { // from class: com.alibaba.griver.image.jsapi.ChooseImageBridgeExtension.2
            @Override // com.alibaba.griver.ui.ant.dialog.AUListDialog.OnItemClickListener
            public void onItemClick(int i2) {
                if (i2 == 0) {
                    ChooseImageBridgeExtension.this.b(page, bridgeCallback, i, z, z2);
                } else if (i2 == 1) {
                    ChooseImageBridgeExtension.this.a(page, bridgeCallback);
                }
            }
        });
        aUListDialog.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(Page page, final BridgeCallback bridgeCallback, int i, boolean z, boolean z2) {
        this.b = new PhotoSelectListener() { // from class: com.alibaba.griver.image.jsapi.ChooseImageBridgeExtension.3
            @Override // com.alibaba.griver.image.photo.listener.PhotoSelectListener
            public void onPhotoSelected(List<PhotoInfo> list, Bundle bundle) {
                ChooseImageBridgeExtension.this.b = null;
                if (list != null && !list.isEmpty()) {
                    ChooseImageBridgeExtension.this.a(list, bridgeCallback);
                } else {
                    ChooseImageBridgeExtension.this.notifyFail(bridgeCallback, 40, "PhotoService selected return invalid!", null);
                }
            }

            @Override // com.alibaba.griver.image.photo.listener.PhotoSelectListener
            public void onSelectCanceled() {
                ChooseImageBridgeExtension.this.b = null;
                ChooseImageBridgeExtension.this.notifyFail(bridgeCallback, 11, "User cancel select video.", null);
            }
        };
        Bundle bundle = new Bundle();
        bundle.putInt(PhotoParam.MAX_SELECT, i);
        bundle.putBoolean(PhotoParam.ENABLE_CAMERA, false);
        bundle.putBoolean(PhotoParam.ENABLE_SELECT_ORIGIN, z2);
        bundle.putString("businessId", "beehive_photo_select_plugin");
        if (z) {
            bundle.putInt(PhotoParam.COMPRESS_IMAGE_QUALITY, 0);
        }
        try {
            bundle.putString(PhotoParam.FINISH_TEXT, GriverEnv.getResources().getString(R.string.griver_image_str_default_choose_img));
        } catch (Throwable th) {
            StringBuilder sb = new StringBuilder();
            sb.append("Get string res exception.");
            sb.append(th.getMessage());
            RVLogger.w("ChooseImagePlugin", sb.toString());
        }
        bundle.putFloat(PhotoParam.BEAUTY_IMAGE_LEVEL, this.d);
        new PhotoServiceImpl().selectPhoto(page.getApp(), bundle, this.b);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Page page, final BridgeCallback bridgeCallback) {
        f6596a = new CaptureListener() { // from class: com.alibaba.griver.image.jsapi.ChooseImageBridgeExtension.4
            @Override // com.alibaba.griver.image.capture.listener.CaptureListener
            public void onAction(boolean z, MediaInfo mediaInfo) {
                if (!z) {
                    if (mediaInfo == null || TextUtils.isEmpty(mediaInfo.path)) {
                        ChooseImageBridgeExtension.this.notifyFail(bridgeCallback, 40, "CaptureService return invalid mediaInfo!", null);
                        return;
                    }
                    LinkedList linkedList = new LinkedList();
                    linkedList.add(mediaInfo.path);
                    LinkedList linkedList2 = new LinkedList();
                    PhotoInfo photoInfo = new PhotoInfo(mediaInfo.path);
                    photoInfo.setPhotoSize(mediaInfo.mediaFileSize);
                    if (mediaInfo.rotation == 90 || mediaInfo.rotation == 270) {
                        int i = mediaInfo.widthPx;
                        mediaInfo.widthPx = mediaInfo.heightPx;
                        mediaInfo.heightPx = i;
                    }
                    photoInfo.setPhotoHeight(mediaInfo.heightPx);
                    photoInfo.setPhotoWidth(mediaInfo.widthPx);
                    ChooseImageBridgeExtension.this.a(bridgeCallback, linkedList, mediaInfo.isTakenByFrontCamera, linkedList2);
                } else {
                    ChooseImageBridgeExtension.this.notifyFail(bridgeCallback, 11, "User cancel take picture.", null);
                }
                CaptureListener unused = ChooseImageBridgeExtension.f6596a = null;
            }
        };
        Bundle bundle = new Bundle();
        bundle.putBoolean(CaptureParam.CAPTURE_ORIENTATION_BY_SENSOR, true);
        bundle.putInt(CaptureParam.CAPTURE_MODE, 2);
        bundle.putBoolean(CaptureParam.ENABLE_SET_BEAUTY, false);
        bundle.putBoolean(CaptureParam.ENABLE_SET_FILTER, false);
        bundle.putBoolean(CaptureParam.ENABLE_SET_WATER_MARK, false);
        bundle.putInt(CaptureParam.INIT_CAMERA_FACING, this.c ? 1 : 0);
        new CaptureServiceImpl().capture(page.getApp(), f6596a, "beehive_photo_select_plugin", bundle);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(List<PhotoInfo> list, BridgeCallback bridgeCallback) {
        LinkedList linkedList = new LinkedList();
        Iterator<PhotoInfo> it = list.iterator();
        while (it.hasNext()) {
            linkedList.add(it.next().getPhotoPath());
        }
        a(bridgeCallback, linkedList, list);
    }

    private void a(BridgeCallback bridgeCallback, List<String> list, List<PhotoInfo> list2) {
        JSONObject a2 = a(list, list2);
        a2.put("scene", SceneType.ASSETS);
        bridgeCallback.sendJSONResponse(a2);
    }

    protected void notifyFail(BridgeCallback bridgeCallback, int i, String str, Runnable runnable) {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("success", (Object) Boolean.FALSE);
        jSONObject.put("errorCode", (Object) Integer.valueOf(i));
        jSONObject.put("errorDesc", (Object) str);
        bridgeCallback.sendJSONResponse(jSONObject);
        if (runnable != null) {
            runnable.run();
        }
    }

    private JSONObject a(List<String> list, List<PhotoInfo> list2) {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("success", (Object) Boolean.TRUE);
        jSONObject.put("tempFilePaths", (Object) JSONArray.toJSONString(list));
        a(list2, jSONObject, PathToLocalUtil.mapImageFilePathToLocalIds(jSONObject, list, false));
        return jSONObject;
    }

    private void a(List<PhotoInfo> list, JSONObject jSONObject, Map<String, String> map) {
        if (list == null || list.isEmpty() || map == null || map.isEmpty()) {
            return;
        }
        JSONArray jSONArray = new JSONArray();
        for (PhotoInfo photoInfo : list) {
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("path", (Object) map.get(photoInfo.getPhotoPath()));
            jSONObject2.put(GriverMonitorConstants.KEY_SIZE, (Object) Long.valueOf(photoInfo.getPhotoSize()));
            jSONArray.add(jSONObject2);
        }
        jSONObject.put("tempFiles", (Object) jSONArray);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(BridgeCallback bridgeCallback, List<String> list, boolean z, List<PhotoInfo> list2) {
        JSONObject a2 = a(list, list2);
        a2.put("useFrontCamera", (Object) Boolean.valueOf(z));
        a2.put("scene", "camera");
        bridgeCallback.sendJSONResponse(a2);
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
