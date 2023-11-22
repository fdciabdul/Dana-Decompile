package com.alibaba.griver.core.rpc;

import com.alibaba.griver.core.model.aboutinfo.GetAboutInfoRequest;
import com.alibaba.griver.core.model.aboutinfo.GetAboutInfoResult;
import com.alibaba.griver.core.model.applist.FetchAppListResult;
import com.alibaba.griver.core.model.applist.FetchAppsByIdsRequest;
import com.alibaba.griver.core.model.applist.FetchAppsByKeyWordsRequest;
import com.alibaba.griver.core.model.applist.FetchAppsRequest;
import com.alibaba.griver.core.model.applist.FetchAppsResult;
import com.alibaba.griver.core.model.codec.UrlCodecRequest;
import com.alibaba.griver.core.model.codec.UrlCodecResult;
import com.alibaba.griver.core.model.codec.cancodec.UrlCanCodecRequest;
import com.alibaba.griver.core.model.codec.cancodec.UrlCanCodecResult;
import com.alibaba.griver.core.model.share.ShareShortUrlRequest;
import com.alibaba.griver.core.model.share.ShareShortUrlResult;
import com.alipay.mobile.framework.service.annotation.OperationType;
import com.alipay.mobile.framework.service.annotation.SignCheck;

/* loaded from: classes3.dex */
public interface MiniProgramFacade {
    @OperationType(GriverRpcContants.FETCH_APP_LIST)
    @SignCheck
    FetchAppListResult fetchAppInfoListByIds(FetchAppsByIdsRequest fetchAppsByIdsRequest);

    @OperationType(GriverRpcContants.SEARCH_APP_LIST_BY_KEYWORD)
    @SignCheck
    FetchAppListResult fetchAppInfoListByKeyword(FetchAppsByKeyWordsRequest fetchAppsByKeyWordsRequest);

    @OperationType(GriverRpcContants.FETCH_APP_LIST)
    @SignCheck
    FetchAppsResult fetchAppList(FetchAppsRequest fetchAppsRequest);

    @OperationType(GriverRpcContants.GET_ABOUT_INFO)
    @SignCheck
    GetAboutInfoResult getAboutInfo(GetAboutInfoRequest getAboutInfoRequest);

    @OperationType(GriverRpcContants.SHARE_SHORTEN_URL)
    @SignCheck
    ShareShortUrlResult getShareShortUrl(ShareShortUrlRequest shareShortUrlRequest);

    @OperationType(GriverRpcContants.APP_CAN_DECODE_ROUTE)
    @SignCheck
    UrlCanCodecResult getUrlCanCodec(UrlCanCodecRequest urlCanCodecRequest);

    @OperationType(GriverRpcContants.APP_CODEC_ROUTE)
    @SignCheck
    UrlCodecResult getUrlCodec(UrlCodecRequest urlCodecRequest);
}
