package id.dana.explore.domain.sku.mapper;

import id.dana.domain.homeinfo.ThirdPartyServiceResponse;
import id.dana.domain.services.model.ThirdPartyCategoryService;
import id.dana.explore.domain.sku.model.ExploreServiceModel;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0011\u0010\u0002\u001a\u00020\u0001*\u00020\u0000¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lid/dana/domain/services/model/ThirdPartyCategoryService;", "Lid/dana/explore/domain/sku/model/ExploreServiceModel;", "BuiltInFictitiousFunctionClassFactory", "(Lid/dana/domain/services/model/ThirdPartyCategoryService;)Lid/dana/explore/domain/sku/model/ExploreServiceModel;"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class ExploreServiceMapperKt {
    public static final ExploreServiceModel BuiltInFictitiousFunctionClassFactory(ThirdPartyCategoryService thirdPartyCategoryService) {
        Intrinsics.checkNotNullParameter(thirdPartyCategoryService, "");
        List<ThirdPartyServiceResponse> thirdPartyServices = thirdPartyCategoryService.getThirdPartyServices();
        Intrinsics.checkNotNullExpressionValue(thirdPartyServices, "");
        String key = ((ThirdPartyServiceResponse) CollectionsKt.first((List) thirdPartyServices)).getKey();
        List<ThirdPartyServiceResponse> thirdPartyServices2 = thirdPartyCategoryService.getThirdPartyServices();
        Intrinsics.checkNotNullExpressionValue(thirdPartyServices2, "");
        String name = ((ThirdPartyServiceResponse) CollectionsKt.first((List) thirdPartyServices2)).getName();
        String str = name == null ? "" : name;
        List<ThirdPartyServiceResponse> thirdPartyServices3 = thirdPartyCategoryService.getThirdPartyServices();
        Intrinsics.checkNotNullExpressionValue(thirdPartyServices3, "");
        String description = ((ThirdPartyServiceResponse) CollectionsKt.first((List) thirdPartyServices3)).getDescription();
        String str2 = description == null ? "" : description;
        List<ThirdPartyServiceResponse> thirdPartyServices4 = thirdPartyCategoryService.getThirdPartyServices();
        Intrinsics.checkNotNullExpressionValue(thirdPartyServices4, "");
        String icon = ((ThirdPartyServiceResponse) CollectionsKt.first((List) thirdPartyServices4)).getIcon();
        return new ExploreServiceModel(key, str, str2, icon == null ? "" : icon, false, 16, null);
    }
}
