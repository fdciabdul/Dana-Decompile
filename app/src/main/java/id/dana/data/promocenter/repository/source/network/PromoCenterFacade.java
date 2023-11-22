package id.dana.data.promocenter.repository.source.network;

import com.alipay.mobile.framework.service.annotation.OperationType;
import com.alipay.mobile.framework.service.annotation.SignCheck;
import id.dana.data.promocenter.repository.source.network.request.PromoCenterAdsQueryRequest;
import id.dana.data.promocenter.repository.source.network.request.PromoCenterCategorizedRequest;
import id.dana.data.promocenter.repository.source.network.request.PromoCenterCategoryRequest;
import id.dana.data.promocenter.repository.source.network.request.PromoCenterFetchRequest;
import id.dana.data.promocenter.repository.source.network.result.PromoCenterAdsQueryResult;
import id.dana.data.promocenter.repository.source.network.result.PromoCenterCategorizedResult;
import id.dana.data.promocenter.repository.source.network.result.PromoCenterCategoryResult;
import id.dana.data.promocenter.repository.source.network.result.PromoCenterFetchResult;

/* loaded from: classes4.dex */
public interface PromoCenterFacade {
    @OperationType("alipayplus.mobilewallet.promocenter.fetch")
    @SignCheck
    PromoCenterFetchResult queryAllPromo(PromoCenterFetchRequest promoCenterFetchRequest);

    @OperationType("alipayplus.mobilewallet.promocenter.categorized")
    @SignCheck
    PromoCenterCategorizedResult queryCategorizedPromo(PromoCenterCategorizedRequest promoCenterCategorizedRequest);

    @OperationType("alipayplus.mobilewallet.promocenter.groupcategory")
    @SignCheck
    PromoCenterCategoryResult queryCategory(PromoCenterCategoryRequest promoCenterCategoryRequest);

    @OperationType("alipayplus.mobilewallet.promocenter.ads.query")
    @SignCheck
    PromoCenterAdsQueryResult queryPromoCenterAds(PromoCenterAdsQueryRequest promoCenterAdsQueryRequest);
}
