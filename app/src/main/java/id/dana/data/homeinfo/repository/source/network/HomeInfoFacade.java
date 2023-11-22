package id.dana.data.homeinfo.repository.source.network;

import com.alipay.mobile.framework.service.annotation.OperationType;
import com.alipay.mobile.framework.service.annotation.SignCheck;
import id.dana.data.homeinfo.repository.source.network.request.HomeInfoRequest;
import id.dana.data.homeinfo.repository.source.network.result.HomeInfoResult;

/* loaded from: classes4.dex */
public interface HomeInfoFacade {
    public static final String MOBILE_WALLET_TAB_HOME = "alipayplus.mobilewallet.wallet.tab.home";

    @OperationType(MOBILE_WALLET_TAB_HOME)
    @SignCheck
    HomeInfoResult getHomeInfo(HomeInfoRequest homeInfoRequest);
}
