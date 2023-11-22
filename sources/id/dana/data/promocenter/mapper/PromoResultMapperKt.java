package id.dana.data.promocenter.mapper;

import id.dana.data.config.model.PromoAdsConfigResponse;
import id.dana.data.promocenter.repository.source.network.model.CallToActionDTO;
import id.dana.data.promocenter.repository.source.network.model.DisplayPromoResponse;
import id.dana.domain.promocenter.model.Promo;
import id.dana.domain.promocenter.model.PromoAction;
import id.dana.domain.promocenter.model.PromoAdsConfig;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u0011\u0010\u0002\u001a\u00020\u0001*\u00020\u0000¢\u0006\u0004\b\u0002\u0010\u0003\u001a\u0011\u0010\u0006\u001a\u00020\u0005*\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007\u001a\u001d\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00050\b*\b\u0012\u0004\u0012\u00020\u00040\b¢\u0006\u0004\b\t\u0010\n\u001a\u0011\u0010\r\u001a\u00020\f*\u00020\u000b¢\u0006\u0004\b\r\u0010\u000e\u001a!\u0010\u000f\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\b*\n\u0012\u0006\u0012\u0004\u0018\u00010\u00000\b¢\u0006\u0004\b\u000f\u0010\n"}, d2 = {"Lid/dana/data/promocenter/repository/source/network/model/DisplayPromoResponse;", "Lid/dana/domain/promocenter/model/Promo;", "toPromo", "(Lid/dana/data/promocenter/repository/source/network/model/DisplayPromoResponse;)Lid/dana/domain/promocenter/model/Promo;", "Lid/dana/data/promocenter/repository/source/network/model/CallToActionDTO;", "Lid/dana/domain/promocenter/model/PromoAction;", "toPromoAction", "(Lid/dana/data/promocenter/repository/source/network/model/CallToActionDTO;)Lid/dana/domain/promocenter/model/PromoAction;", "", "toPromoActions", "(Ljava/util/List;)Ljava/util/List;", "Lid/dana/data/config/model/PromoAdsConfigResponse;", "Lid/dana/domain/promocenter/model/PromoAdsConfig;", "toPromoAdsConfig", "(Lid/dana/data/config/model/PromoAdsConfigResponse;)Lid/dana/domain/promocenter/model/PromoAdsConfig;", "toPromos"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class PromoResultMapperKt {
    public static final List<Promo> toPromos(List<DisplayPromoResponse> list) {
        Intrinsics.checkNotNullParameter(list, "");
        List<DisplayPromoResponse> list2 = list;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list2, 10));
        for (DisplayPromoResponse displayPromoResponse : list2) {
            arrayList.add(displayPromoResponse != null ? toPromo(displayPromoResponse) : null);
        }
        return arrayList;
    }

    public static final PromoAdsConfig toPromoAdsConfig(PromoAdsConfigResponse promoAdsConfigResponse) {
        Intrinsics.checkNotNullParameter(promoAdsConfigResponse, "");
        return new PromoAdsConfig(promoAdsConfigResponse.getEnable(), promoAdsConfigResponse.getNumberOfItemBatch());
    }

    public static final Promo toPromo(DisplayPromoResponse displayPromoResponse) {
        List<PromoAction> emptyList;
        Intrinsics.checkNotNullParameter(displayPromoResponse, "");
        Promo promo = new Promo();
        promo.setId(displayPromoResponse.getPromoContentId());
        promo.setBannerUrl(displayPromoResponse.getPromoBannerImageUrl());
        promo.setExpiryDate(displayPromoResponse.getPromoEndDate());
        promo.setName(displayPromoResponse.getPromoName());
        List<CallToActionDTO> promoCallToActions = displayPromoResponse.getPromoCallToActions();
        if (promoCallToActions == null || (emptyList = toPromoActions(promoCallToActions)) == null) {
            emptyList = CollectionsKt.emptyList();
        }
        promo.setPromoActions(emptyList);
        promo.setPromoPriority(displayPromoResponse.getPromoPriority());
        promo.setPromoIndexId(displayPromoResponse.getPromoIndexId());
        promo.setPromoBannerVerticalImageUrl(displayPromoResponse.getPromoBannerVerticalImageUrl());
        promo.setMerchantType(displayPromoResponse.getMerchantType());
        return promo;
    }

    public static final List<PromoAction> toPromoActions(List<? extends CallToActionDTO> list) {
        Intrinsics.checkNotNullParameter(list, "");
        List<? extends CallToActionDTO> list2 = list;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list2, 10));
        Iterator<T> it = list2.iterator();
        while (it.hasNext()) {
            arrayList.add(toPromoAction((CallToActionDTO) it.next()));
        }
        return arrayList;
    }

    public static final PromoAction toPromoAction(CallToActionDTO callToActionDTO) {
        Intrinsics.checkNotNullParameter(callToActionDTO, "");
        PromoAction promoAction = new PromoAction();
        promoAction.setName(callToActionDTO.getLabel());
        promoAction.setRedirectUrl(callToActionDTO.getRedirectUrl());
        promoAction.setType(callToActionDTO.getType());
        return promoAction;
    }
}
