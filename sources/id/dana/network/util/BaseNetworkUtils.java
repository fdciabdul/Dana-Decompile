package id.dana.network.util;

import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Build;
import com.alipay.iap.android.lbs.LBSLocation;
import com.alipay.mobile.common.rpc.RpcException;
import com.alipayplus.mobile.component.common.facade.base.MobileEnvInfo;
import com.alipayplus.mobile.component.common.facade.base.MobileEnvLocationInfo;
import com.alipayplus.mobile.component.domain.model.result.BaseRpcResult;
import id.dana.network.exception.DeserializeFailureException;
import id.dana.utils.LocationUtils;
import id.dana.utils.extension.JSONExtKt;
import id.dana.utils.foundation.facede.ApSecurity;
import id.dana.utils.foundation.facede.LbsFacade;
import java.util.HashMap;

/* loaded from: classes5.dex */
public class BaseNetworkUtils {
    public static MobileEnvInfo generateMobileEnvInfo(ApSecurity apSecurity, Context context) {
        MobileEnvInfo mobileEnvInfo = new MobileEnvInfo();
        mobileEnvInfo.tokenId = apSecurity.BuiltInFictitiousFunctionClassFactory();
        String str = "";
        mobileEnvInfo.clientIp = "";
        mobileEnvInfo.terminalType = "APP";
        mobileEnvInfo.osType = "android";
        mobileEnvInfo.sourcePlatForm = "MAIN_APP";
        mobileEnvInfo.osVersion = Build.VERSION.RELEASE;
        mobileEnvInfo.locationInfo = generateMobileEnvLocationInfo(context);
        try {
            str = context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionName;
        } catch (PackageManager.NameNotFoundException unused) {
        }
        mobileEnvInfo.appVersion = str;
        HashMap hashMap = new HashMap();
        hashMap.put(EnvInfoConstant.LOCATION_MOCKED, isMockedLocation(context).toString());
        hashMap.put("utdid", apSecurity.KClassImpl$Data$declaredNonStaticMembers$2());
        hashMap.put(EnvInfoConstant.LOGIN_DEVICE_NAME, getDeviceModel());
        hashMap.put(EnvInfoConstant.DEVICE_NAME, getDeviceModel());
        hashMap.put(EnvInfoConstant.ADS_ID, apSecurity.PlaceComponentResult());
        mobileEnvInfo.extendInfo = hashMap;
        return mobileEnvInfo;
    }

    private static MobileEnvLocationInfo generateMobileEnvLocationInfo(Context context) {
        LBSLocation authRequestContext = LbsFacade.getAuthRequestContext(context);
        MobileEnvLocationInfo mobileEnvLocationInfo = new MobileEnvLocationInfo();
        try {
            mobileEnvLocationInfo.latitude = String.valueOf(authRequestContext.getLatitude());
            mobileEnvLocationInfo.longitude = String.valueOf(authRequestContext.getLongitude());
            mobileEnvLocationInfo.updateTime = authRequestContext.getTime();
            mobileEnvLocationInfo.type = authRequestContext.getType();
            mobileEnvLocationInfo.status = String.valueOf(authRequestContext.getErrorCode());
        } catch (Exception unused) {
        }
        return mobileEnvLocationInfo;
    }

    private static Boolean isMockedLocation(Context context) {
        return Boolean.valueOf(LocationUtils.BuiltInFictitiousFunctionClassFactory(LbsFacade.getAuthRequestContext(context)));
    }

    public static <S extends BaseRpcResult> S onDeserializeFailure(Class<S> cls, Throwable th) throws Throwable {
        if (cls != null) {
            if (!(th instanceof RpcException)) {
                throw th;
            }
            RpcException rpcException = (RpcException) th;
            if (10 == rpcException.getCode()) {
                if (rpcException.getMessage() == null) {
                    throw th;
                }
                try {
                    S s = (S) deserializeFailure(cls, th);
                    if (s != null) {
                        return s;
                    }
                    throw new DeserializeFailureException("failed to deserialize");
                } catch (Exception e) {
                    StringBuilder sb = new StringBuilder();
                    sb.append(th.getMessage());
                    sb.append(" | Code: ");
                    sb.append(rpcException.getCode());
                    sb.append(" | Error: ");
                    sb.append(e.getMessage());
                    throw new DeserializeFailureException(sb.toString(), e);
                }
            }
            throw th;
        }
        throw th;
    }

    private static <S extends BaseRpcResult> S deserializeFailure(Class<S> cls, Throwable th) {
        String message = th.getMessage();
        if (message != null) {
            return (S) JSONExtKt.PlaceComponentResult().fromJson(message.substring(message.indexOf("{"), message.indexOf("}:") + 1), (Class) cls);
        }
        return null;
    }

    private static String getDeviceModel() {
        StringBuilder sb = new StringBuilder();
        sb.append(Build.MANUFACTURER);
        sb.append(" ");
        sb.append(Build.MODEL);
        return sb.toString();
    }
}
