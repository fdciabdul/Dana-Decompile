package id.dana.lib.gcontainer.app.bridge.imagepicker;

import android.app.Activity;
import android.content.Intent;
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
import com.alibaba.griver.core.jsapi.device.location.RequestPermission;
import com.anggrayudi.storage.file.DocumentFileCompat;
import com.anggrayudi.storage.permission.PermissionCallback;
import com.anggrayudi.storage.permission.PermissionReport;
import com.anggrayudi.storage.permission.PermissionRequest;
import com.anggrayudi.storage.permission.PermissionResult;
import id.dana.danah5.akulaku.AkuEventParamsKey;
import id.dana.lib.gcontainer.app.bridge.core.BaseBridge;
import id.dana.lib.gcontainer.extension.BridgeExtensionExtKt;
import id.dana.lib.gcontainer.util.handpicked.HandPicked;
import id.dana.promocenter.model.PromoActionType;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 !2\u00020\u0001:\u0001!B\u0007¢\u0006\u0004\b\u001f\u0010 J9\u0010\u000b\u001a\u00020\n2\b\b\u0001\u0010\u0003\u001a\u00020\u00022\n\b\u0001\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\b\u0001\u0010\u0007\u001a\u00020\u00062\b\b\u0001\u0010\t\u001a\u00020\bH\u0007¢\u0006\u0004\b\u000b\u0010\fJ)\u0010\u0012\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\r2\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010H\u0016¢\u0006\u0004\b\u0012\u0010\u0013J!\u0010\u0016\u001a\u00020\n2\u0006\u0010\u0015\u001a\u00020\u00142\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0002¢\u0006\u0004\b\u0016\u0010\u0017R\u0016\u0010\t\u001a\u00020\b8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b\t\u0010\u0018R\u0018\u0010\u001a\u001a\u0004\u0018\u00010\u00198\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u0016\u0010\u001d\u001a\u00020\u001c8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b\u001d\u0010\u001e"}, d2 = {"Lid/dana/lib/gcontainer/app/bridge/imagepicker/ImagePickerBridge;", "Lid/dana/lib/gcontainer/app/bridge/core/BaseBridge;", "Lcom/alibaba/ariver/app/api/Page;", "page", "", "event", "Lcom/alibaba/fastjson/JSONObject;", "info", "Lcom/alibaba/ariver/engine/api/bridge/extension/BridgeCallback;", "bridgeCallback", "", "imagePicker", "(Lcom/alibaba/ariver/app/api/Page;Ljava/lang/String;Lcom/alibaba/fastjson/JSONObject;Lcom/alibaba/ariver/engine/api/bridge/extension/BridgeCallback;)V", "", RequestPermission.REQUEST_CODE, "resultCode", "Landroid/content/Intent;", "data", "onActivityResult", "(IILandroid/content/Intent;)V", "Landroid/app/Activity;", AkuEventParamsKey.KEY_ACTIVITY, "pickImage", "(Landroid/app/Activity;Ljava/lang/String;)V", "Lcom/alibaba/ariver/engine/api/bridge/extension/BridgeCallback;", "Lid/dana/lib/gcontainer/util/handpicked/HandPicked;", "handPicked", "Lid/dana/lib/gcontainer/util/handpicked/HandPicked;", "Lid/dana/lib/gcontainer/app/bridge/imagepicker/ImagePickerEntity;", "imageEntity", "Lid/dana/lib/gcontainer/app/bridge/imagepicker/ImagePickerEntity;", "<init>", "()V", "Companion"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes2.dex */
public final class ImagePickerBridge extends BaseBridge {
    public static final String CAMERA_WITH_FRAME = "cameraWithFrame";

    /* renamed from: Companion  reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final String IMAGE_CAPTURE_EVENT = "image_capture_event";
    public static final int IMAGE_CAPTURE_REQUEST_CODE = 99;
    private BridgeCallback bridgeCallback;
    private HandPicked handPicked;
    private ImagePickerEntity imageEntity;

    @ThreadType(ExecutorType.UI)
    @ActionFilter(canOverride = false)
    public final void imagePicker(@BindingNode(Page.class) Page page, @BindingParam(name = {"event"}) final String event, @BindingParam(name = {"info"}) JSONObject info, @BindingCallback final BridgeCallback bridgeCallback) {
        String[] strArr;
        Intrinsics.checkNotNullParameter(page, "");
        Intrinsics.checkNotNullParameter(info, "");
        Intrinsics.checkNotNullParameter(bridgeCallback, "");
        final Activity activity = BridgeExtensionExtKt.getActivity(page);
        if (activity == null) {
            return;
        }
        if (DocumentFileCompat.BuiltInFictitiousFunctionClassFactory(activity, PromoActionType.PRIMARY) <= 104857600) {
            bridgeCallback.sendJSONResponse(INSTANCE.getErrorResult("GENERAL_ERROR"));
            return;
        }
        Object obj = null;
        try {
            obj = JSONObject.parseObject(info.toJSONString(), new TypeReference<ImagePickerEntity>() { // from class: id.dana.lib.gcontainer.app.bridge.imagepicker.ImagePickerBridge$imagePicker$$inlined$toObject$default$1
            }, new Feature[0]);
        } catch (JSONException | NullPointerException unused) {
        }
        ImagePickerEntity imagePickerEntity = (ImagePickerEntity) obj;
        if (imagePickerEntity == null) {
            return;
        }
        this.imageEntity = imagePickerEntity;
        this.bridgeCallback = bridgeCallback;
        if (Build.VERSION.SDK_INT < 29) {
            strArr = new String[]{"android.permission.CAMERA", "android.permission.WRITE_EXTERNAL_STORAGE", "android.permission.READ_EXTERNAL_STORAGE"};
        } else {
            strArr = new String[]{"android.permission.CAMERA"};
        }
        requestPermissions(activity, strArr, new PermissionCallback() { // from class: id.dana.lib.gcontainer.app.bridge.imagepicker.ImagePickerBridge$imagePicker$1
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
                Intrinsics.checkNotNullParameter(result, "");
                List<PermissionReport> list = result.BuiltInFictitiousFunctionClassFactory;
                ArrayList arrayList = new ArrayList();
                for (Object obj2 : list) {
                    if ((!((PermissionReport) obj2).getBuiltInFictitiousFunctionClassFactory()) != false) {
                        arrayList.add(obj2);
                    }
                }
                ArrayList arrayList2 = arrayList;
                if (arrayList2.isEmpty()) {
                    ImagePickerBridge.this.pickImage(activity, event);
                    return;
                }
                String str = ((PermissionReport) CollectionsKt.first((List) arrayList2)).KClassImpl$Data$declaredNonStaticMembers$2;
                int hashCode = str.hashCode();
                if (hashCode != -406040016) {
                    if (hashCode == 463403621) {
                        if (str.equals("android.permission.CAMERA")) {
                            bridgeCallback.sendJSONResponse(ImagePickerBridge.INSTANCE.getErrorResult("ERR_CAMERA_PERMISSION_NOT_GRANTED"));
                            return;
                        }
                        return;
                    } else if (hashCode != 1365911975 || !str.equals("android.permission.WRITE_EXTERNAL_STORAGE")) {
                        return;
                    }
                } else if (!str.equals("android.permission.READ_EXTERNAL_STORAGE")) {
                    return;
                }
                bridgeCallback.sendJSONResponse(ImagePickerBridge.INSTANCE.getErrorResult("ERR_GALLERY_PERMISSION_NOT_GRANTED"));
            }
        });
    }

    @Override // id.dana.lib.gcontainer.app.bridge.core.BaseBridge
    public final void onActivityResult(int requestCode, int resultCode, Intent data) {
        HandPicked handPicked;
        ImagePickerEntity imagePickerEntity;
        BridgeCallback bridgeCallback;
        BridgeCallback bridgeCallback2 = null;
        if (requestCode == 99 && resultCode == -1) {
            HandPicked handPicked2 = this.handPicked;
            if (handPicked2 != null) {
                ImagePickerEntity imagePickerEntity2 = this.imageEntity;
                if (imagePickerEntity2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("");
                    imagePickerEntity2 = null;
                }
                BridgeCallback bridgeCallback3 = this.bridgeCallback;
                if (bridgeCallback3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("");
                } else {
                    bridgeCallback2 = bridgeCallback3;
                }
                handPicked2.onActivityResult(data, imagePickerEntity2, bridgeCallback2, "cameraWithFrame");
            }
        } else if (resultCode != -1 || (handPicked = this.handPicked) == null) {
        } else {
            ImagePickerEntity imagePickerEntity3 = this.imageEntity;
            if (imagePickerEntity3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("");
                imagePickerEntity = null;
            } else {
                imagePickerEntity = imagePickerEntity3;
            }
            BridgeCallback bridgeCallback4 = this.bridgeCallback;
            if (bridgeCallback4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("");
                bridgeCallback = null;
            } else {
                bridgeCallback = bridgeCallback4;
            }
            HandPicked.onActivityResult$default(handPicked, data, imagePickerEntity, bridgeCallback, null, 8, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0097  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x00a3  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void pickImage(android.app.Activity r10, java.lang.String r11) {
        /*
            Method dump skipped, instructions count: 254
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.lib.gcontainer.app.bridge.imagepicker.ImagePickerBridge.pickImage(android.app.Activity, java.lang.String):void");
    }

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\r\u0010\u000eJ\u0017\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0007\u001a\u00020\u00028\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0007\u0010\bR\u0014\u0010\t\u001a\u00020\u00028\u0006X\u0086T¢\u0006\u0006\n\u0004\b\t\u0010\bR\u0014\u0010\u000b\u001a\u00020\n8\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u000b\u0010\f"}, d2 = {"Lid/dana/lib/gcontainer/app/bridge/imagepicker/ImagePickerBridge$Companion;", "", "", "errorType", "Lcom/alibaba/fastjson/JSONObject;", "getErrorResult", "(Ljava/lang/String;)Lcom/alibaba/fastjson/JSONObject;", "CAMERA_WITH_FRAME", "Ljava/lang/String;", "IMAGE_CAPTURE_EVENT", "", "IMAGE_CAPTURE_REQUEST_CODE", "I", "<init>", "()V"}, k = 1, mv = {1, 5, 1}, xi = 48)
    /* loaded from: classes2.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
        /* JADX WARN: Code restructure failed: missing block: B:14:0x0039, code lost:
        
            if (r6.equals("ERR_FAILED_CREATING_IMAGE") == false) goto L29;
         */
        /* JADX WARN: Code restructure failed: missing block: B:17:0x0040, code lost:
        
            if (r6.equals("006") == false) goto L29;
         */
        /* JADX WARN: Code restructure failed: missing block: B:20:0x0047, code lost:
        
            if (r6.equals("004") != false) goto L30;
         */
        /* JADX WARN: Code restructure failed: missing block: B:26:0x005b, code lost:
        
            if (r6.equals("ERR_FAILED_COMPRESS_IMAGE") == false) goto L29;
         */
        /* JADX WARN: Code restructure failed: missing block: B:28:0x005e, code lost:
        
            r2 = "006";
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final com.alibaba.fastjson.JSONObject getErrorResult(java.lang.String r6) {
            /*
                r5 = this;
                com.alibaba.fastjson.JSONObject r0 = new com.alibaba.fastjson.JSONObject
                r0.<init>()
                r1 = r0
                java.util.Map r1 = (java.util.Map) r1
                java.lang.Boolean r2 = java.lang.Boolean.FALSE
                java.lang.String r3 = "success"
                r1.put(r3, r2)
                java.lang.String r2 = "004"
                java.lang.String r3 = "006"
                if (r6 == 0) goto L60
                int r4 = r6.hashCode()
                switch(r4) {
                    case -1928266010: goto L55;
                    case -398546049: goto L4a;
                    case 47668: goto L43;
                    case 47670: goto L3c;
                    case 421160189: goto L33;
                    case 848626822: goto L28;
                    case 1822982328: goto L1d;
                    default: goto L1c;
                }
            L1c:
                goto L60
            L1d:
                java.lang.String r2 = "ERR_FAILED_RESIZE_IMAGE"
                boolean r6 = r6.equals(r2)
                if (r6 == 0) goto L60
                java.lang.String r2 = "005"
                goto L62
            L28:
                java.lang.String r2 = "ERR_GALLERY_PERMISSION_NOT_GRANTED"
                boolean r6 = r6.equals(r2)
                if (r6 == 0) goto L60
                java.lang.String r2 = "003"
                goto L62
            L33:
                java.lang.String r3 = "ERR_FAILED_CREATING_IMAGE"
                boolean r6 = r6.equals(r3)
                if (r6 != 0) goto L62
                goto L60
            L3c:
                boolean r6 = r6.equals(r3)
                if (r6 != 0) goto L5e
                goto L60
            L43:
                boolean r6 = r6.equals(r2)
                if (r6 == 0) goto L60
                goto L62
            L4a:
                java.lang.String r2 = "ERR_CAMERA_PERMISSION_NOT_GRANTED"
                boolean r6 = r6.equals(r2)
                if (r6 == 0) goto L60
                java.lang.String r2 = "002"
                goto L62
            L55:
                java.lang.String r2 = "ERR_FAILED_COMPRESS_IMAGE"
                boolean r6 = r6.equals(r2)
                if (r6 != 0) goto L5e
                goto L60
            L5e:
                r2 = r3
                goto L62
            L60:
                java.lang.String r2 = "001"
            L62:
                java.lang.String r6 = "error"
                r1.put(r6, r2)
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: id.dana.lib.gcontainer.app.bridge.imagepicker.ImagePickerBridge.Companion.getErrorResult(java.lang.String):com.alibaba.fastjson.JSONObject");
        }
    }
}
