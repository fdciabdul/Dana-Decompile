package id.dana.cashier.data.mapper;

import com.alipayplus.mobile.component.common.facade.base.MobileEnvInfo;
import id.dana.cashier.data.repository.source.network.request.MobileEnvInfoWithCity;
import id.dana.cashier.data.repository.source.network.request.MobileLocationInfoWithCity;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u001d\u0010\u0004\u001a\u00020\u0003*\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0001¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Lcom/alipayplus/mobile/component/common/facade/base/MobileEnvInfo;", "", "cityName", "Lid/dana/cashier/data/repository/source/network/request/MobileEnvInfoWithCity;", "toMobileEnvInfoWithCity", "(Lcom/alipayplus/mobile/component/common/facade/base/MobileEnvInfo;Ljava/lang/String;)Lid/dana/cashier/data/repository/source/network/request/MobileEnvInfoWithCity;"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class MobileEnvInfoMapperKt {
    public static /* synthetic */ MobileEnvInfoWithCity toMobileEnvInfoWithCity$default(MobileEnvInfo mobileEnvInfo, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            str = null;
        }
        return toMobileEnvInfoWithCity(mobileEnvInfo, str);
    }

    public static final MobileEnvInfoWithCity toMobileEnvInfoWithCity(MobileEnvInfo mobileEnvInfo, String str) {
        Intrinsics.checkNotNullParameter(mobileEnvInfo, "");
        MobileEnvInfoWithCity mobileEnvInfoWithCity = new MobileEnvInfoWithCity(str);
        mobileEnvInfoWithCity.sourcePlatForm = mobileEnvInfo.sourcePlatForm;
        mobileEnvInfoWithCity.tokenId = mobileEnvInfo.tokenId;
        mobileEnvInfoWithCity.clientIp = mobileEnvInfo.clientIp;
        mobileEnvInfoWithCity.terminalType = mobileEnvInfo.terminalType;
        mobileEnvInfoWithCity.orderTerminalType = mobileEnvInfo.orderTerminalType;
        mobileEnvInfoWithCity.osType = mobileEnvInfo.osType;
        mobileEnvInfoWithCity.osVersion = mobileEnvInfo.osVersion;
        mobileEnvInfoWithCity.sdkVersion = mobileEnvInfo.sdkVersion;
        mobileEnvInfoWithCity.cashierSdkVersion = mobileEnvInfo.cashierSdkVersion;
        mobileEnvInfoWithCity.appVersion = mobileEnvInfo.appVersion;
        mobileEnvInfoWithCity.clientKey = mobileEnvInfo.clientKey;
        mobileEnvInfoWithCity.locale = mobileEnvInfo.locale;
        mobileEnvInfoWithCity.deliveryToken = mobileEnvInfo.deliveryToken;
        mobileEnvInfoWithCity.channel = mobileEnvInfo.channel;
        mobileEnvInfoWithCity.networkType = mobileEnvInfo.networkType;
        mobileEnvInfoWithCity.imei = mobileEnvInfo.imei;
        mobileEnvInfoWithCity.imsi = mobileEnvInfo.imsi;
        mobileEnvInfoWithCity.model = mobileEnvInfo.model;
        mobileEnvInfoWithCity.longitude = mobileEnvInfo.longitude;
        mobileEnvInfoWithCity.latitude = mobileEnvInfo.latitude;
        mobileEnvInfoWithCity.LBSType = mobileEnvInfo.LBSType;
        mobileEnvInfoWithCity.LBSUpdateTime = mobileEnvInfo.LBSUpdateTime;
        mobileEnvInfoWithCity.thirdChannelDeviceToken = mobileEnvInfo.thirdChannelDeviceToken;
        mobileEnvInfoWithCity.thirdChannel = mobileEnvInfo.thirdChannel;
        mobileEnvInfoWithCity.extendInfo = mobileEnvInfo.extendInfo;
        MobileLocationInfoWithCity mobileLocationInfoWithCity = new MobileLocationInfoWithCity(str);
        mobileLocationInfoWithCity.latitude = mobileEnvInfo.locationInfo.latitude;
        mobileLocationInfoWithCity.longitude = mobileEnvInfo.locationInfo.longitude;
        mobileLocationInfoWithCity.type = mobileEnvInfo.locationInfo.type;
        mobileLocationInfoWithCity.status = mobileEnvInfo.locationInfo.status;
        mobileLocationInfoWithCity.updateTime = mobileEnvInfo.locationInfo.updateTime;
        mobileEnvInfoWithCity.locationInfo = mobileLocationInfoWithCity;
        return mobileEnvInfoWithCity;
    }
}
