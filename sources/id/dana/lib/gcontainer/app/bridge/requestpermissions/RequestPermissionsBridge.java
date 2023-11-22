package id.dana.lib.gcontainer.app.bridge.requestpermissions;

import android.app.Activity;
import android.os.Build;
import androidx.core.content.ContextCompat;
import com.alibaba.ariver.app.api.Page;
import com.alibaba.ariver.engine.api.bridge.extension.BridgeCallback;
import com.alibaba.ariver.engine.api.bridge.extension.annotation.BindingCallback;
import com.alibaba.ariver.engine.api.bridge.extension.annotation.BindingNode;
import com.alibaba.ariver.engine.api.bridge.extension.annotation.BindingParam;
import com.alibaba.ariver.kernel.api.annotation.ActionFilter;
import com.alibaba.ariver.kernel.api.annotation.ThreadType;
import com.alibaba.ariver.kernel.common.service.executor.ExecutorType;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.griver.core.jsapi.device.location.RequestPermission;
import com.anggrayudi.storage.permission.PermissionCallback;
import com.anggrayudi.storage.permission.PermissionReport;
import com.anggrayudi.storage.permission.PermissionRequest;
import com.anggrayudi.storage.permission.PermissionResult;
import id.dana.danah5.akulaku.AkuEventParamsKey;
import id.dana.lib.gcontainer.app.bridge.core.BaseBridge;
import id.dana.lib.gcontainer.extension.BridgeExtensionExtKt;
import id.dana.util.permission.ManifestPermission;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u001e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\"\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010$\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b(\u0010\"J+\u0010\u0007\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0010\b\u0002\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0004H\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u0015\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00020\tH\u0002¢\u0006\u0004\b\n\u0010\u000bJ#\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00020\t2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00020\tH\u0002¢\u0006\u0004\b\r\u0010\u000eJ%\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0010\u001a\u00020\u000f2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00020\tH\u0002¢\u0006\u0004\b\u0012\u0010\u0013J%\u0010\u0014\u001a\u00020\u00112\u0006\u0010\u0010\u001a\u00020\u000f2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00020\tH\u0002¢\u0006\u0004\b\u0014\u0010\u0013J#\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00020\u00162\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00020\tH\u0002¢\u0006\u0004\b\u0017\u0010\u0018J7\u0010\u001f\u001a\u00020\u00112\b\b\u0001\u0010\u001a\u001a\u00020\u00192\b\b\u0001\u0010\u001b\u001a\u00020\u00022\b\b\u0001\u0010\u001c\u001a\u00020\u00062\b\b\u0001\u0010\u001e\u001a\u00020\u001dH\u0007¢\u0006\u0004\b\u001f\u0010 J\u000f\u0010!\u001a\u00020\u0011H\u0002¢\u0006\u0004\b!\u0010\"R\u0016\u0010\u001e\u001a\u00020\u001d8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b\u001e\u0010#R&\u0010'\u001a\u0014\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\t0$8CX\u0082\u0004¢\u0006\u0006\u001a\u0004\b%\u0010&"}, d2 = {"Lid/dana/lib/gcontainer/app/bridge/requestpermissions/RequestPermissionsBridge;", "Lid/dana/lib/gcontainer/app/bridge/core/BaseBridge;", "", "errorType", "", RequestPermission.PERMISSIONS, "Lcom/alibaba/fastjson/JSONObject;", "getErrorResult", "(Ljava/lang/String;Ljava/util/Collection;)Lcom/alibaba/fastjson/JSONObject;", "", "getStoragePermissionIds", "()Ljava/util/List;", "groups", "groupsToPermissionIds", "(Ljava/util/List;)Ljava/util/List;", "Landroid/app/Activity;", AkuEventParamsKey.KEY_ACTIVITY, "", "handleCheckPermissions", "(Landroid/app/Activity;Ljava/util/List;)V", "handleRequestPermissions", "permissionIds", "", "permissionIdsToGroup", "(Ljava/util/List;)Ljava/util/Set;", "Lcom/alibaba/ariver/app/api/Page;", "page", "event", "info", "Lcom/alibaba/ariver/engine/api/bridge/extension/BridgeCallback;", "bridgeCallback", "requestPermissions", "(Lcom/alibaba/ariver/app/api/Page;Ljava/lang/String;Lcom/alibaba/fastjson/JSONObject;Lcom/alibaba/ariver/engine/api/bridge/extension/BridgeCallback;)V", "sendGeneralError", "()V", "Lcom/alibaba/ariver/engine/api/bridge/extension/BridgeCallback;", "", "getPermissionGroups", "()Ljava/util/Map;", "permissionGroups", "<init>"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes2.dex */
public final class RequestPermissionsBridge extends BaseBridge {
    private BridgeCallback bridgeCallback;

    @ThreadType(ExecutorType.UI)
    @ActionFilter(canOverride = false)
    public final void requestPermissions(@BindingNode(Page.class) Page page, @BindingParam(name = {"event"}) String event, @BindingParam(name = {"info"}) JSONObject info, @BindingCallback BridgeCallback bridgeCallback) {
        Intrinsics.checkNotNullParameter(page, "");
        Intrinsics.checkNotNullParameter(event, "");
        Intrinsics.checkNotNullParameter(info, "");
        Intrinsics.checkNotNullParameter(bridgeCallback, "");
        this.bridgeCallback = bridgeCallback;
        try {
            JSONArray jSONArray = info.getJSONArray(RequestPermission.PERMISSIONS);
            Intrinsics.checkNotNullExpressionValue(jSONArray, "");
            ArrayList arrayList = new ArrayList();
            int i = 0;
            int size = jSONArray.size();
            if (size > 0) {
                while (true) {
                    int i2 = i + 1;
                    Object obj = jSONArray.get(i);
                    if (obj == null) {
                        throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
                    }
                    arrayList.add((String) obj);
                    if (i2 >= size) {
                        break;
                    }
                    i = i2;
                }
            }
            if (arrayList.isEmpty()) {
                sendGeneralError();
            } else if (Intrinsics.areEqual(event, "check")) {
                Activity activity = BridgeExtensionExtKt.getActivity(page);
                if (activity == null) {
                    return;
                }
                handleCheckPermissions(activity, arrayList);
            } else {
                Activity activity2 = BridgeExtensionExtKt.getActivity(page);
                if (activity2 == null) {
                    return;
                }
                handleRequestPermissions(activity2, arrayList);
            }
        } catch (JSONException unused) {
            sendGeneralError();
        }
    }

    private final List<String> groupsToPermissionIds(List<String> groups) {
        Map<String, List<String>> permissionGroups = getPermissionGroups();
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Map.Entry<String, List<String>> entry : permissionGroups.entrySet()) {
            if (groups.contains(entry.getKey())) {
                linkedHashMap.put(entry.getKey(), entry.getValue());
            }
        }
        ArrayList arrayList = new ArrayList(linkedHashMap.size());
        Iterator it = linkedHashMap.entrySet().iterator();
        while (it.hasNext()) {
            arrayList.add((List) ((Map.Entry) it.next()).getValue());
        }
        return CollectionsKt.flatten(arrayList);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Set<String> permissionIdsToGroup(List<String> permissionIds) {
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        for (Map.Entry<String, List<String>> entry : getPermissionGroups().entrySet()) {
            String key = entry.getKey();
            Iterator<T> it = entry.getValue().iterator();
            while (it.hasNext()) {
                if (permissionIds.contains((String) it.next())) {
                    linkedHashSet.add(key);
                }
            }
        }
        return linkedHashSet;
    }

    private final void handleCheckPermissions(Activity activity, List<String> groups) {
        if (groups.isEmpty()) {
            sendGeneralError();
            return;
        }
        List<String> groupsToPermissionIds = groupsToPermissionIds(groups);
        LinkedHashMap linkedHashMap = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(groupsToPermissionIds, 10)), 16));
        Iterator<T> it = groupsToPermissionIds.iterator();
        while (true) {
            boolean z = true;
            if (!it.hasNext()) {
                break;
            }
            Object next = it.next();
            LinkedHashMap linkedHashMap2 = linkedHashMap;
            if (ContextCompat.KClassImpl$Data$declaredNonStaticMembers$2(activity, (String) next) != 0) {
                z = false;
            }
            linkedHashMap2.put(next, Boolean.valueOf(z));
        }
        LinkedHashMap linkedHashMap3 = new LinkedHashMap();
        for (Map.Entry entry : linkedHashMap.entrySet()) {
            if ((!((Boolean) entry.getValue()).booleanValue()) != false) {
                linkedHashMap3.put(entry.getKey(), entry.getValue());
            }
        }
        LinkedHashMap linkedHashMap4 = linkedHashMap3;
        BridgeCallback bridgeCallback = null;
        if (linkedHashMap4.isEmpty()) {
            BridgeCallback bridgeCallback2 = this.bridgeCallback;
            if (bridgeCallback2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("");
            } else {
                bridgeCallback = bridgeCallback2;
            }
            JSONObject jSONObject = new JSONObject();
            jSONObject.put((JSONObject) "success", (String) Boolean.TRUE);
            Unit unit = Unit.INSTANCE;
            bridgeCallback.sendJSONResponse(jSONObject);
            return;
        }
        ArrayList arrayList = new ArrayList(linkedHashMap4.size());
        Iterator it2 = linkedHashMap4.entrySet().iterator();
        while (it2.hasNext()) {
            arrayList.add((String) ((Map.Entry) it2.next()).getKey());
        }
        Set<String> permissionIdsToGroup = permissionIdsToGroup(arrayList);
        BridgeCallback bridgeCallback3 = this.bridgeCallback;
        if (bridgeCallback3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
        } else {
            bridgeCallback = bridgeCallback3;
        }
        bridgeCallback.sendJSONResponse(getErrorResult("002", permissionIdsToGroup));
    }

    private final void handleRequestPermissions(Activity activity, List<String> groups) {
        if (groups.isEmpty()) {
            sendGeneralError();
            return;
        }
        requestPermissions(activity, groupsToPermissionIds(groups), new PermissionCallback() { // from class: id.dana.lib.gcontainer.app.bridge.requestpermissions.RequestPermissionsBridge$handleRequestPermissions$1
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
                Set permissionIdsToGroup;
                BridgeCallback bridgeCallback;
                JSONObject errorResult;
                BridgeCallback bridgeCallback2;
                Intrinsics.checkNotNullParameter(result, "");
                List<PermissionReport> list = result.BuiltInFictitiousFunctionClassFactory;
                ArrayList arrayList = new ArrayList();
                for (Object obj : list) {
                    if ((!((PermissionReport) obj).getBuiltInFictitiousFunctionClassFactory()) != false) {
                        arrayList.add(obj);
                    }
                }
                ArrayList arrayList2 = arrayList;
                BridgeCallback bridgeCallback3 = null;
                if (arrayList2.isEmpty()) {
                    bridgeCallback2 = RequestPermissionsBridge.this.bridgeCallback;
                    if (bridgeCallback2 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("");
                    } else {
                        bridgeCallback3 = bridgeCallback2;
                    }
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put((JSONObject) "success", (String) Boolean.TRUE);
                    Unit unit = Unit.INSTANCE;
                    bridgeCallback3.sendJSONResponse(jSONObject);
                    return;
                }
                RequestPermissionsBridge requestPermissionsBridge = RequestPermissionsBridge.this;
                ArrayList arrayList3 = arrayList2;
                ArrayList arrayList4 = new ArrayList(CollectionsKt.collectionSizeOrDefault(arrayList3, 10));
                Iterator it = arrayList3.iterator();
                while (it.hasNext()) {
                    arrayList4.add(((PermissionReport) it.next()).KClassImpl$Data$declaredNonStaticMembers$2);
                }
                permissionIdsToGroup = requestPermissionsBridge.permissionIdsToGroup(arrayList4);
                bridgeCallback = RequestPermissionsBridge.this.bridgeCallback;
                if (bridgeCallback == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("");
                } else {
                    bridgeCallback3 = bridgeCallback;
                }
                errorResult = RequestPermissionsBridge.this.getErrorResult("004", permissionIdsToGroup);
                bridgeCallback3.sendJSONResponse(errorResult);
            }
        });
        if (Build.VERSION.SDK_INT < 29 || !groups.contains("STORAGE")) {
            return;
        }
        BridgeCallback bridgeCallback = this.bridgeCallback;
        if (bridgeCallback == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            bridgeCallback = null;
        }
        JSONObject jSONObject = new JSONObject();
        jSONObject.put((JSONObject) "success", (String) Boolean.TRUE);
        Unit unit = Unit.INSTANCE;
        bridgeCallback.sendJSONResponse(jSONObject);
    }

    private final void sendGeneralError() {
        BridgeCallback bridgeCallback = this.bridgeCallback;
        if (bridgeCallback == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            bridgeCallback = null;
        }
        bridgeCallback.sendJSONResponse(getErrorResult$default(this, "001", null, 2, null));
    }

    /* JADX WARN: Multi-variable type inference failed */
    static /* synthetic */ JSONObject getErrorResult$default(RequestPermissionsBridge requestPermissionsBridge, String str, Collection collection, int i, Object obj) {
        if ((i & 2) != 0) {
            collection = null;
        }
        return requestPermissionsBridge.getErrorResult(str, collection);
    }

    @JvmName(name = "getPermissionGroups")
    private final Map<String, List<String>> getPermissionGroups() {
        return MapsKt.mapOf(TuplesKt.to("CALENDAR", CollectionsKt.listOf(ManifestPermission.WRITE_CALENDAR)), TuplesKt.to("CAMERA", CollectionsKt.listOf("android.permission.CAMERA")), TuplesKt.to("CONTACT", CollectionsKt.listOf((Object[]) new String[]{"android.permission.READ_CONTACTS", "android.permission.WRITE_CONTACTS"})), TuplesKt.to("LOCATION", CollectionsKt.listOf("android.permission.ACCESS_FINE_LOCATION")), TuplesKt.to("PHONE", CollectionsKt.listOf("android.permission.CALL_PHONE")), TuplesKt.to("PHONE_STATE", CollectionsKt.listOf("android.permission.READ_PHONE_STATE")), TuplesKt.to("STORAGE", getStoragePermissionIds()), TuplesKt.to("MICROPHONE", CollectionsKt.listOf(ManifestPermission.RECORD_AUDIO)));
    }

    private final List<String> getStoragePermissionIds() {
        if (Build.VERSION.SDK_INT < 29) {
            return CollectionsKt.listOf((Object[]) new String[]{"android.permission.WRITE_EXTERNAL_STORAGE", "android.permission.READ_EXTERNAL_STORAGE"});
        }
        return CollectionsKt.emptyList();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final JSONObject getErrorResult(String errorType, Collection<String> permissions) {
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = jSONObject;
        jSONObject2.put((JSONObject) "success", (String) Boolean.FALSE);
        jSONObject2.put((JSONObject) "data", (String) permissions);
        if (errorType == null) {
            errorType = "001";
        }
        jSONObject2.put((JSONObject) "error", errorType);
        return jSONObject;
    }
}
