package id.dana.globalnetworkproxy.mapper;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alipay.imobile.network.quake.transport.http.constant.HeaderConstant;
import com.iap.ac.android.biz.common.proxy.NetworkProxy;
import com.iap.ac.android.common.rpc.model.HttpResponse;
import id.dana.domain.globalnetwork.model.GnConsultInfo;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u000b\u0010\fJ\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u0007H\u0007¢\u0006\u0004\b\t\u0010\n"}, d2 = {"Lid/dana/globalnetworkproxy/mapper/GlobalNetworkProxyMapper;", "", "", "p0", "", "KClassImpl$Data$declaredNonStaticMembers$2", "(Ljava/lang/String;)[B", "Lid/dana/domain/globalnetwork/model/GnConsultInfo;", "Lcom/iap/ac/android/common/rpc/model/HttpResponse;", "MyBillsEntityDataFactory", "(Lid/dana/domain/globalnetwork/model/GnConsultInfo;)Lcom/iap/ac/android/common/rpc/model/HttpResponse;", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class GlobalNetworkProxyMapper {
    public static final GlobalNetworkProxyMapper INSTANCE = new GlobalNetworkProxyMapper();

    private GlobalNetworkProxyMapper() {
    }

    @JvmStatic
    public static final HttpResponse MyBillsEntityDataFactory(GnConsultInfo p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        int i = Intrinsics.areEqual(JSON.parseObject(p0.getResult()).getString("resultStatus"), "S") ? 200 : 0;
        String string = JSON.parseObject(p0.getResult()).getString("resultMessage");
        Intrinsics.checkNotNullExpressionValue(string, "");
        byte[] KClassImpl$Data$declaredNonStaticMembers$2 = KClassImpl$Data$declaredNonStaticMembers$2(p0.getSdkResponseData());
        String sdkResponseHeader = p0.getSdkResponseHeader();
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        JSONObject parseObject = JSON.parseObject(sdkResponseHeader);
        List singletonList = Collections.singletonList(parseObject.getString("Server-Time"));
        Intrinsics.checkNotNullExpressionValue(singletonList, "");
        linkedHashMap.put("Server-Time", singletonList);
        List singletonList2 = Collections.singletonList(parseObject.getString("Mgw-TraceId"));
        Intrinsics.checkNotNullExpressionValue(singletonList2, "");
        linkedHashMap.put("Mgw-TraceId", singletonList2);
        List singletonList3 = Collections.singletonList(parseObject.getString(NetworkProxy.HTTP_HEADER_KEY_AC_USER_ID));
        Intrinsics.checkNotNullExpressionValue(singletonList3, "");
        linkedHashMap.put(NetworkProxy.HTTP_HEADER_KEY_AC_USER_ID, singletonList3);
        List singletonList4 = Collections.singletonList(parseObject.getString(HeaderConstant.HEADER_KEY_RESULT_STATUS));
        Intrinsics.checkNotNullExpressionValue(singletonList4, "");
        linkedHashMap.put(HeaderConstant.HEADER_KEY_RESULT_STATUS, singletonList4);
        return new HttpResponse(i, string, KClassImpl$Data$declaredNonStaticMembers$2, linkedHashMap);
    }

    @JvmStatic
    private static final byte[] KClassImpl$Data$declaredNonStaticMembers$2(String p0) {
        byte[] bytes = JSON.toJSON(p0).toString().getBytes(Charsets.UTF_8);
        Intrinsics.checkNotNullExpressionValue(bytes, "");
        return bytes;
    }
}
