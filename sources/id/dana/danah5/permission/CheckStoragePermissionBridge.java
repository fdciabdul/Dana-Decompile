package id.dana.danah5.permission;

import android.app.Activity;
import androidx.core.content.ContextCompat;
import com.alibaba.ariver.app.api.Page;
import com.alibaba.ariver.engine.api.bridge.extension.BridgeCallback;
import com.alibaba.ariver.engine.api.bridge.extension.annotation.BindingCallback;
import com.alibaba.ariver.engine.api.bridge.extension.annotation.BindingNode;
import com.alibaba.ariver.engine.api.bridge.extension.annotation.BindingParam;
import com.alibaba.ariver.kernel.api.annotation.ActionFilter;
import com.alibaba.ariver.kernel.api.annotation.ThreadType;
import com.alibaba.ariver.kernel.common.service.executor.ExecutorType;
import com.alibaba.ariver.kernel.ipc.IpcMessageConstants;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.griver.core.jsapi.device.location.RequestPermission;
import com.anggrayudi.storage.permission.PermissionCallback;
import com.anggrayudi.storage.permission.PermissionReport;
import com.anggrayudi.storage.permission.PermissionRequest;
import com.anggrayudi.storage.permission.PermissionResult;
import id.dana.analytics.tracker.TrackerKey;
import id.dana.danah5.akulaku.AkuEventParamsKey;
import id.dana.danah5.constant.BridgeName;
import id.dana.lib.gcontainer.app.bridge.core.BaseBridge;
import id.dana.lib.gcontainer.extension.BridgeExtensionExtKt;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \u001e2\u00020\u0001:\u0001\u001eB\u0007¢\u0006\u0004\b\u001c\u0010\u001dJ\u001d\u0010\u0006\u001a\u00020\u00052\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0002¢\u0006\u0004\b\u0006\u0010\u0007J\u0017\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\n\u0010\u000bJ\u0017\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\r\u001a\u00020\fH\u0002¢\u0006\u0004\b\u000f\u0010\u0010J-\u0010\u0016\u001a\u00020\u000e2\b\b\u0001\u0010\u0011\u001a\u00020\u00032\b\b\u0001\u0010\u0013\u001a\u00020\u00122\b\b\u0001\u0010\u0015\u001a\u00020\u0014H\u0007¢\u0006\u0004\b\u0016\u0010\u0017R\u0016\u0010\u0019\u001a\u00020\u00188\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u0016\u0010\u0013\u001a\u00020\u00128\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b\u0013\u0010\u001b"}, d2 = {"Lid/dana/danah5/permission/CheckStoragePermissionBridge;", "Lid/dana/lib/gcontainer/app/bridge/core/BaseBridge;", "", "", RequestPermission.PERMISSIONS, "", "arePermissionsGranted", "(Ljava/util/List;)Z", TrackerKey.Property.IS_SUCCESS, "Lcom/alibaba/fastjson/JSONObject;", "assembleCheckStoragePermissionResponse", "(Z)Lcom/alibaba/fastjson/JSONObject;", "Lcom/anggrayudi/storage/permission/PermissionResult;", "result", "", "checkPermissionResult", "(Lcom/anggrayudi/storage/permission/PermissionResult;)V", IpcMessageConstants.EXTRA_EVENT, "Lcom/alibaba/ariver/engine/api/bridge/extension/BridgeCallback;", "bridgeCallback", "Lcom/alibaba/ariver/app/api/Page;", "page", BridgeName.CHECK_STORAGE_PERMISSION, "(Ljava/lang/String;Lcom/alibaba/ariver/engine/api/bridge/extension/BridgeCallback;Lcom/alibaba/ariver/app/api/Page;)V", "Landroid/app/Activity;", AkuEventParamsKey.KEY_ACTIVITY, "Landroid/app/Activity;", "Lcom/alibaba/ariver/engine/api/bridge/extension/BridgeCallback;", "<init>", "()V", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class CheckStoragePermissionBridge extends BaseBridge {
    private static final int REQUEST_CODE_STORAGE_PERMISSION = 100;
    private Activity activity;
    private BridgeCallback bridgeCallback;

    @ThreadType(ExecutorType.NORMAL)
    @ActionFilter(canOverride = false)
    public final void checkStoragePermission(@BindingParam(name = {"event"}) String eventName, @BindingCallback BridgeCallback bridgeCallback, @BindingNode(Page.class) Page page) {
        Intrinsics.checkNotNullParameter(eventName, "");
        Intrinsics.checkNotNullParameter(bridgeCallback, "");
        Intrinsics.checkNotNullParameter(page, "");
        Activity activity = BridgeExtensionExtKt.getActivity(page);
        if (activity == null) {
            return;
        }
        this.activity = activity;
        this.bridgeCallback = bridgeCallback;
        List<String> listOf = CollectionsKt.listOf((Object[]) new String[]{"android.permission.READ_EXTERNAL_STORAGE", "android.permission.WRITE_EXTERNAL_STORAGE"});
        if (Intrinsics.areEqual(eventName, CheckStoragePermissionKey.CHECK_ONLY.getKey())) {
            bridgeCallback.sendJSONResponse(assembleCheckStoragePermissionResponse(arePermissionsGranted(listOf)));
        } else if (Intrinsics.areEqual(eventName, CheckStoragePermissionKey.CHECK_WITH_GRANT_PERMISSION.getKey())) {
            if (arePermissionsGranted(listOf)) {
                bridgeCallback.sendJSONResponse(assembleCheckStoragePermissionResponse(true));
                return;
            }
            Activity activity2 = this.activity;
            if (activity2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("");
                activity2 = null;
            }
            requestPermissions(activity2, listOf, new PermissionCallback() { // from class: id.dana.danah5.permission.CheckStoragePermissionBridge$checkStoragePermission$1
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
                    CheckStoragePermissionBridge.this.checkPermissionResult(result);
                }
            });
        }
    }

    private final boolean arePermissionsGranted(List<String> permissions) {
        for (String str : permissions) {
            Activity activity = this.activity;
            if (activity == null) {
                Intrinsics.throwUninitializedPropertyAccessException("");
                activity = null;
            }
            if (ContextCompat.KClassImpl$Data$declaredNonStaticMembers$2(activity, str) == -1) {
                return false;
            }
        }
        return true;
    }

    private final JSONObject assembleCheckStoragePermissionResponse(boolean isSuccess) {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("success", (Object) Boolean.valueOf(isSuccess));
        return jSONObject;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void checkPermissionResult(PermissionResult result) {
        BridgeCallback bridgeCallback;
        Iterator<T> it = result.BuiltInFictitiousFunctionClassFactory.iterator();
        do {
            bridgeCallback = null;
            if (!it.hasNext()) {
                BridgeCallback bridgeCallback2 = this.bridgeCallback;
                if (bridgeCallback2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("");
                } else {
                    bridgeCallback = bridgeCallback2;
                }
                bridgeCallback.sendJSONResponse(assembleCheckStoragePermissionResponse(true));
                return;
            }
        } while (((PermissionReport) it.next()).getBuiltInFictitiousFunctionClassFactory());
        BridgeCallback bridgeCallback3 = this.bridgeCallback;
        if (bridgeCallback3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
        } else {
            bridgeCallback = bridgeCallback3;
        }
        bridgeCallback.sendJSONResponse(assembleCheckStoragePermissionResponse(false));
    }
}
