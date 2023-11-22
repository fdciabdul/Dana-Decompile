package id.dana.data.promocenter.mapper;

import id.dana.data.base.BaseMapper;
import id.dana.data.promocenter.repository.source.network.model.CallToActionDTO;
import id.dana.data.promocenter.repository.source.network.model.DisplayPromoResponse;
import id.dana.data.promocenter.repository.source.network.result.PromoCenterFetchResult;
import id.dana.domain.promocenter.model.Promo;
import id.dana.domain.promocenter.model.PromoAction;
import id.dana.domain.promocenter.model.PromoResult;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.inject.Inject;

/* loaded from: classes4.dex */
public class PromoEntityMapper extends BaseMapper<PromoCenterFetchResult, PromoResult> {
    @Inject
    public PromoEntityMapper() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // id.dana.data.base.BaseMapper
    public PromoResult map(PromoCenterFetchResult promoCenterFetchResult) {
        if (promoCenterFetchResult != null) {
            PromoResult promoResult = new PromoResult();
            promoResult.setHasMore(promoCenterFetchResult.isHasMore());
            promoResult.setPromoList(toPromo(promoCenterFetchResult.getListOfPromo()));
            return promoResult;
        }
        return null;
    }

    private List<Promo> toPromo(List<DisplayPromoResponse> list) {
        ArrayList arrayList = new ArrayList();
        Iterator<DisplayPromoResponse> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(transform(it.next()));
        }
        return arrayList;
    }

    private Promo transform(DisplayPromoResponse displayPromoResponse) {
        Promo promo = new Promo();
        promo.setId(displayPromoResponse.getPromoContentId());
        promo.setBannerUrl(displayPromoResponse.getPromoBannerImageUrl());
        promo.setExpiryDate(displayPromoResponse.getPromoEndDate());
        promo.setName(displayPromoResponse.getPromoName());
        promo.setPromoActions(transform(displayPromoResponse.getPromoCallToActions()));
        promo.setPromoPriority(displayPromoResponse.getPromoPriority());
        promo.setPromoIndexId(displayPromoResponse.getPromoIndexId());
        promo.setPromoBannerVerticalImageUrl(displayPromoResponse.getPromoBannerVerticalImageUrl());
        return promo;
    }

    private List<PromoAction> transform(List<CallToActionDTO> list) {
        if (list != null) {
            ArrayList arrayList = new ArrayList();
            for (CallToActionDTO callToActionDTO : list) {
                PromoAction promoAction = new PromoAction();
                promoAction.setName(callToActionDTO.getLabel());
                promoAction.setRedirectUrl(callToActionDTO.getRedirectUrl());
                promoAction.setType(callToActionDTO.getType());
                arrayList.add(promoAction);
            }
            return arrayList;
        }
        return new ArrayList();
    }
}
