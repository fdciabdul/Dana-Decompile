package id.dana.danah5.akulaku;

import android.app.Activity;
import android.content.Context;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import com.alibaba.ariver.app.api.Page;
import com.alibaba.ariver.engine.api.bridge.extension.BridgeCallback;
import com.alibaba.ariver.engine.api.bridge.extension.annotation.BindingCallback;
import com.alibaba.ariver.engine.api.bridge.extension.annotation.BindingNode;
import com.alibaba.ariver.kernel.api.annotation.ActionFilter;
import com.alibaba.ariver.kernel.api.annotation.ThreadType;
import com.alibaba.ariver.kernel.api.extension.bridge.SimpleBridgeExtension;
import com.alibaba.ariver.kernel.common.service.executor.ExecutorType;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.griver.base.api.H5Event;
import com.alipay.iap.android.lbs.LBSLocation;
import com.alipay.iap.android.lbs.LBSLocationErrorCode;
import com.ap.zoloz.hummer.biz.HummerConstants;
import id.dana.danah5.akulaku.model.DeviceInfo;
import id.dana.danah5.constant.BridgeName;
import id.dana.lib.gcontainer.GContainer;
import id.dana.lib.gcontainer.extension.BridgeExtensionExtKt;
import id.dana.utils.foundation.facede.LbsFacade;
import id.dana.utils.permission.ManifestPermission;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\t\u0018\u0000 \u001c2\u00020\u0001:\u0001\u001cB\u0007¢\u0006\u0004\b\u001a\u0010\u001bJ\u0019\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\n\u0010\u000bJ#\u0010\u0011\u001a\u00020\u00102\b\b\u0001\u0010\r\u001a\u00020\f2\b\b\u0001\u0010\u000f\u001a\u00020\u000eH\u0007¢\u0006\u0004\b\u0011\u0010\u0012J\u0017\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0014\u0010\u0015J\u0017\u0010\u0016\u001a\u00020\u00102\u0006\u0010\u000f\u001a\u00020\u000eH\u0002¢\u0006\u0004\b\u0016\u0010\u0017J\u0017\u0010\u0018\u001a\u00020\u00102\u0006\u0010\r\u001a\u00020\fH\u0002¢\u0006\u0004\b\u0018\u0010\u0019"}, d2 = {"Lid/dana/danah5/akulaku/LocationInfoBridge;", "Lcom/alibaba/ariver/kernel/api/extension/bridge/SimpleBridgeExtension;", "Landroid/content/Context;", HummerConstants.CONTEXT, "Lid/dana/danah5/akulaku/model/DeviceInfo$Gps;", "assembleGpsInfo", "(Landroid/content/Context;)Lid/dana/danah5/akulaku/model/DeviceInfo$Gps;", "Lcom/alipay/iap/android/lbs/LBSLocation;", "lbsLocation", "", "getGpsErrorCode", "(Lcom/alipay/iap/android/lbs/LBSLocation;)I", "Lcom/alibaba/ariver/engine/api/bridge/extension/BridgeCallback;", "bridgeCallback", "Lcom/alibaba/ariver/app/api/Page;", "page", "", BridgeName.GET_LOCATION_INFO, "(Lcom/alibaba/ariver/engine/api/bridge/extension/BridgeCallback;Lcom/alibaba/ariver/app/api/Page;)V", "", "isPermissionGranted", "(Landroid/content/Context;)Z", "requestPermission", "(Lcom/alibaba/ariver/app/api/Page;)V", "sendCallbackError", "(Lcom/alibaba/ariver/engine/api/bridge/extension/BridgeCallback;)V", "<init>", "()V", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class LocationInfoBridge extends SimpleBridgeExtension {
    public static final String GPS_PERMISSION_ERROR = "user doesn't have GPS permission";

    @ThreadType(ExecutorType.NORMAL)
    @ActionFilter(canOverride = false)
    public final void getLocationInfo(@BindingCallback BridgeCallback bridgeCallback, @BindingNode(Page.class) Page page) {
        Intrinsics.checkNotNullParameter(bridgeCallback, "");
        Intrinsics.checkNotNullParameter(page, "");
        try {
            if (!isPermissionGranted(GContainer.getApplicationContext())) {
                requestPermission(page);
                sendCallbackError(bridgeCallback);
                return;
            }
            Object json = JSON.toJSON(assembleGpsInfo(GContainer.getApplicationContext()));
            if (json == null) {
                throw new NullPointerException("null cannot be cast to non-null type com.alibaba.fastjson.JSONObject");
            }
            bridgeCallback.sendJSONResponse((JSONObject) json);
        } catch (Exception unused) {
            sendCallbackError(bridgeCallback);
        }
    }

    private final DeviceInfo.Gps assembleGpsInfo(Context context) {
        DeviceInfo.Gps gps = new DeviceInfo.Gps();
        try {
            LBSLocation authRequestContext = LbsFacade.getAuthRequestContext(context);
            gps.latitude = String.valueOf(authRequestContext.getLatitude());
            gps.longitude = String.valueOf(authRequestContext.getLongitude());
            gps.time = authRequestContext.getTime();
            Intrinsics.checkNotNullExpressionValue(authRequestContext, "");
            gps.error = getGpsErrorCode(authRequestContext);
        } catch (Exception e) {
        }
        return gps;
    }

    private final int getGpsErrorCode(LBSLocation lbsLocation) {
        int errorCode = lbsLocation.getErrorCode();
        if (errorCode == LBSLocationErrorCode.LocationErrorSuccess.getErrorCode() || errorCode == LBSLocationErrorCode.LocationErrorExpired.getErrorCode()) {
            return 0;
        }
        if (errorCode == LBSLocationErrorCode.LocationErrorNoAuthorization.getErrorCode() || errorCode == LBSLocationErrorCode.LocationErrorPositionDisabled.getErrorCode()) {
            return 11;
        }
        if (errorCode != LBSLocationErrorCode.LocationErrorParamInvalid.getErrorCode() && errorCode != LBSLocationErrorCode.LocationErrorSystem.getErrorCode() && errorCode != LBSLocationErrorCode.LocationErrorCancelled.getErrorCode()) {
            if (errorCode == LBSLocationErrorCode.LocationErrorNullLocation.getErrorCode()) {
                return 12;
            }
            if (errorCode == LBSLocationErrorCode.LocationErrorTimeout.getErrorCode()) {
                return 14;
            }
        }
        return 13;
    }

    private final boolean isPermissionGranted(Context context) {
        return ContextCompat.KClassImpl$Data$declaredNonStaticMembers$2(context, "android.permission.ACCESS_FINE_LOCATION") == 0;
    }

    private final void requestPermission(Page page) {
        ArrayList arrayList = new ArrayList();
        arrayList.add("android.permission.ACCESS_FINE_LOCATION");
        arrayList.add(ManifestPermission.ACCESS_COARSE_LOCATION);
        Activity activity = BridgeExtensionExtKt.getActivity(page);
        Intrinsics.checkNotNull(activity);
        Object[] array = arrayList.toArray(new String[0]);
        if (array != null) {
            ActivityCompat.BuiltInFictitiousFunctionClassFactory(activity, (String[]) array, 1);
            return;
        }
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
    }

    private final void sendCallbackError(BridgeCallback bridgeCallback) {
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = jSONObject;
        jSONObject2.put((JSONObject) "success", (String) Boolean.FALSE);
        jSONObject2.put((JSONObject) "message", GPS_PERMISSION_ERROR);
        jSONObject2.put((JSONObject) "error", (String) H5Event.Error.UNKNOWN_ERROR);
        bridgeCallback.sendJSONResponse(jSONObject);
    }
}
