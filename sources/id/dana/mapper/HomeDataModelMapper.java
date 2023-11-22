package id.dana.mapper;

import id.dana.data.base.BaseMapper;
import id.dana.domain.homeinfo.HomeData;
import id.dana.feeds.mapper.FeedsModelMapper;
import id.dana.model.HomeDataModel;
import javax.inject.Inject;

/* loaded from: classes5.dex */
public class HomeDataModelMapper extends BaseMapper<HomeData, HomeDataModel> {
    private PromotionMapper BuiltInFictitiousFunctionClassFactory;
    private HomeInfoMapper KClassImpl$Data$declaredNonStaticMembers$2;
    private FeedsModelMapper PlaceComponentResult;
    private HasNewModelMapper getAuthRequestContext;

    @Override // id.dana.data.base.BaseMapper
    public /* synthetic */ HomeDataModel map(HomeData homeData) {
        HomeData homeData2 = homeData;
        if (homeData2 != null) {
            HomeDataModel homeDataModel = new HomeDataModel();
            homeDataModel.BuiltInFictitiousFunctionClassFactory = this.KClassImpl$Data$declaredNonStaticMembers$2.KClassImpl$Data$declaredNonStaticMembers$2(homeData2.getHomeInfoResponse());
            homeDataModel.PlaceComponentResult = BannerModelMapperKt.getAuthRequestContext(homeData2.getSpace());
            homeDataModel.KClassImpl$Data$declaredNonStaticMembers$2 = FeedsModelMapper.PlaceComponentResult(homeData2.getFeeds());
            homeDataModel.MyBillsEntityDataFactory = this.getAuthRequestContext.apply(homeData2.getHasNewResponse());
            return homeDataModel;
        }
        return null;
    }

    @Inject
    public HomeDataModelMapper(HomeInfoMapper homeInfoMapper, PromotionMapper promotionMapper, FeedsModelMapper feedsModelMapper, HasNewModelMapper hasNewModelMapper) {
        this.KClassImpl$Data$declaredNonStaticMembers$2 = homeInfoMapper;
        this.BuiltInFictitiousFunctionClassFactory = promotionMapper;
        this.PlaceComponentResult = feedsModelMapper;
        this.getAuthRequestContext = hasNewModelMapper;
    }
}
