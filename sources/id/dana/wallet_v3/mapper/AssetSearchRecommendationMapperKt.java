package id.dana.wallet_v3.mapper;

import id.dana.domain.homeinfo.ThirdPartyServiceResponse;
import id.dana.domain.wallet_v3.model.AssetRecommendation;
import id.dana.model.ThirdPartyService;
import id.dana.utils.StringWrapper;
import id.dana.wallet_v3.model.AssetSearchRecommendationModel;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a)\u0010\u0006\u001a\u00020\u0005*\u00020\u00002\u0016\u0010\u0004\u001a\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u0001¢\u0006\u0004\b\u0006\u0010\u0007"}, d2 = {"Lid/dana/domain/wallet_v3/model/AssetRecommendation;", "Lkotlin/Function1;", "Lid/dana/domain/homeinfo/ThirdPartyServiceResponse;", "Lid/dana/model/ThirdPartyService;", "toThirdPartyService", "Lid/dana/wallet_v3/model/AssetSearchRecommendationModel;", "toAssetSearchRecommendation", "(Lid/dana/domain/wallet_v3/model/AssetRecommendation;Lkotlin/jvm/functions/Function1;)Lid/dana/wallet_v3/model/AssetSearchRecommendationModel;"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class AssetSearchRecommendationMapperKt {
    public static final AssetSearchRecommendationModel toAssetSearchRecommendation(AssetRecommendation assetRecommendation, Function1<? super ThirdPartyServiceResponse, ThirdPartyService> function1) {
        Intrinsics.checkNotNullParameter(assetRecommendation, "");
        Intrinsics.checkNotNullParameter(function1, "");
        String service = assetRecommendation.getService();
        String imageUrl = assetRecommendation.getImageUrl();
        StringWrapper title = assetRecommendation.getTitle();
        StringWrapper desc = assetRecommendation.getDesc();
        StringWrapper btnTitle = assetRecommendation.getBtnTitle();
        ThirdPartyService invoke = function1.invoke(assetRecommendation.getThirdPartyServiceResponse());
        String upperCase = assetRecommendation.getSectionType().toUpperCase(Locale.ROOT);
        Intrinsics.checkNotNullExpressionValue(upperCase, "");
        return new AssetSearchRecommendationModel(service, imageUrl, title, desc, btnTitle, invoke, upperCase);
    }
}
