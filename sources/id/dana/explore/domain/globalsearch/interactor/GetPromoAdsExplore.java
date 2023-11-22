package id.dana.explore.domain.globalsearch.interactor;

import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import id.dana.domain.core.usecase.BaseUseCase;
import id.dana.domain.featureconfig.FeatureConfigRepository;
import id.dana.domain.promocenter.model.PromoAds;
import id.dana.domain.promocenter.repository.PromoCenterRepository;
import id.dana.explore.domain.globalsearch.GlobalSearchRepository;
import id.dana.explore.domain.globalsearch.model.GlobalSearchConfig;
import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.functions.BiFunction;
import io.reactivex.functions.Function;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001\u0013B!\b\u0007\u0012\u0006\u0010\u000e\u001a\u00020\u000b\u0012\u0006\u0010\u000f\u001a\u00020\u0004\u0012\u0006\u0010\u0010\u001a\u00020\b¢\u0006\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0007\u001a\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\u0006R\u0014\u0010\t\u001a\u00020\b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\t\u0010\nR\u0014\u0010\u0005\u001a\u00020\u000b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\f\u0010\r"}, d2 = {"Lid/dana/explore/domain/globalsearch/interactor/GetPromoAdsExplore;", "Lid/dana/domain/core/usecase/BaseUseCase;", "Lid/dana/domain/promocenter/model/PromoAds;", "Lid/dana/explore/domain/globalsearch/interactor/GetPromoAdsExplore$PromoAdsExploreParams;", "Lid/dana/domain/featureconfig/FeatureConfigRepository;", "PlaceComponentResult", "Lid/dana/domain/featureconfig/FeatureConfigRepository;", "MyBillsEntityDataFactory", "Lid/dana/explore/domain/globalsearch/GlobalSearchRepository;", "getAuthRequestContext", "Lid/dana/explore/domain/globalsearch/GlobalSearchRepository;", "Lid/dana/domain/promocenter/repository/PromoCenterRepository;", "BuiltInFictitiousFunctionClassFactory", "Lid/dana/domain/promocenter/repository/PromoCenterRepository;", "p0", "p1", "p2", "<init>", "(Lid/dana/domain/promocenter/repository/PromoCenterRepository;Lid/dana/domain/featureconfig/FeatureConfigRepository;Lid/dana/explore/domain/globalsearch/GlobalSearchRepository;)V", "PromoAdsExploreParams"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class GetPromoAdsExplore extends BaseUseCase<PromoAds, PromoAdsExploreParams> {

    /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
    private final PromoCenterRepository PlaceComponentResult;

    /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
    private final FeatureConfigRepository MyBillsEntityDataFactory;
    private final GlobalSearchRepository getAuthRequestContext;

    @Override // id.dana.domain.core.usecase.BaseUseCase
    public final /* synthetic */ Observable<PromoAds> buildUseCase(PromoAdsExploreParams promoAdsExploreParams) {
        final PromoAdsExploreParams promoAdsExploreParams2 = promoAdsExploreParams;
        Intrinsics.checkNotNullParameter(promoAdsExploreParams2, "");
        Observable onErrorReturnItem = Observable.zip(this.getAuthRequestContext.BuiltInFictitiousFunctionClassFactory(), this.MyBillsEntityDataFactory.isPromoCenterEnable(), new BiFunction() { // from class: id.dana.explore.domain.globalsearch.interactor.GetPromoAdsExplore$$ExternalSyntheticLambda0
            @Override // io.reactivex.functions.BiFunction
            public final Object apply(Object obj, Object obj2) {
                return GetPromoAdsExplore.KClassImpl$Data$declaredNonStaticMembers$2((GlobalSearchConfig) obj, (Boolean) obj2);
            }
        }).onErrorReturnItem(new GlobalSearchConfig(false, null, false, false, false, null, false, null, 255, null));
        Intrinsics.checkNotNullExpressionValue(onErrorReturnItem, "");
        Observable<PromoAds> flatMap = onErrorReturnItem.flatMap(new Function() { // from class: id.dana.explore.domain.globalsearch.interactor.GetPromoAdsExplore$$ExternalSyntheticLambda1
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                return GetPromoAdsExplore.BuiltInFictitiousFunctionClassFactory(GetPromoAdsExplore.this, promoAdsExploreParams2, (GlobalSearchConfig) obj);
            }
        });
        Intrinsics.checkNotNullExpressionValue(flatMap, "");
        return flatMap;
    }

    @Inject
    public GetPromoAdsExplore(PromoCenterRepository promoCenterRepository, FeatureConfigRepository featureConfigRepository, GlobalSearchRepository globalSearchRepository) {
        Intrinsics.checkNotNullParameter(promoCenterRepository, "");
        Intrinsics.checkNotNullParameter(featureConfigRepository, "");
        Intrinsics.checkNotNullParameter(globalSearchRepository, "");
        this.PlaceComponentResult = promoCenterRepository;
        this.MyBillsEntityDataFactory = featureConfigRepository;
        this.getAuthRequestContext = globalSearchRepository;
    }

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0002\b\n\b\u0086\b\u0018\u00002\u00020\u0001B#\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\f\u0012\b\u0010\u0013\u001a\u0004\u0018\u00010\f\u0012\u0006\u0010\u0014\u001a\u00020\t¢\u0006\u0004\b\u0015\u0010\u0016J\u001a\u0010\u0004\u001a\u00020\u00032\b\u0010\u0002\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0007\u001a\u00020\u0006HÖ\u0001¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\n\u001a\u00020\tHÖ\u0001¢\u0006\u0004\b\n\u0010\u000bR\u0013\u0010\u000f\u001a\u0004\u0018\u00010\fX\u0006¢\u0006\u0006\n\u0004\b\r\u0010\u000eR\u0013\u0010\r\u001a\u0004\u0018\u00010\fX\u0006¢\u0006\u0006\n\u0004\b\u0010\u0010\u000eR\u0011\u0010\u0010\u001a\u00020\tX\u0006¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012"}, d2 = {"Lid/dana/explore/domain/globalsearch/interactor/GetPromoAdsExplore$PromoAdsExploreParams;", "", "p0", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "", "toString", "()Ljava/lang/String;", "", "getAuthRequestContext", "Ljava/lang/Double;", "MyBillsEntityDataFactory", "KClassImpl$Data$declaredNonStaticMembers$2", "PlaceComponentResult", "Ljava/lang/String;", "p1", "p2", "<init>", "(Ljava/lang/Double;Ljava/lang/Double;Ljava/lang/String;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final /* data */ class PromoAdsExploreParams {

        /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
        final Double getAuthRequestContext;

        /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
        final String KClassImpl$Data$declaredNonStaticMembers$2;

        /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
        final Double MyBillsEntityDataFactory;

        public final boolean equals(Object p0) {
            if (this == p0) {
                return true;
            }
            if (p0 instanceof PromoAdsExploreParams) {
                PromoAdsExploreParams promoAdsExploreParams = (PromoAdsExploreParams) p0;
                return Intrinsics.areEqual((Object) this.MyBillsEntityDataFactory, (Object) promoAdsExploreParams.MyBillsEntityDataFactory) && Intrinsics.areEqual((Object) this.getAuthRequestContext, (Object) promoAdsExploreParams.getAuthRequestContext) && Intrinsics.areEqual(this.KClassImpl$Data$declaredNonStaticMembers$2, promoAdsExploreParams.KClassImpl$Data$declaredNonStaticMembers$2);
            }
            return false;
        }

        public final int hashCode() {
            Double d = this.MyBillsEntityDataFactory;
            int hashCode = d == null ? 0 : d.hashCode();
            Double d2 = this.getAuthRequestContext;
            return (((hashCode * 31) + (d2 != null ? d2.hashCode() : 0)) * 31) + this.KClassImpl$Data$declaredNonStaticMembers$2.hashCode();
        }

        public final String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("PromoAdsExploreParams(MyBillsEntityDataFactory=");
            sb.append(this.MyBillsEntityDataFactory);
            sb.append(", getAuthRequestContext=");
            sb.append(this.getAuthRequestContext);
            sb.append(", KClassImpl$Data$declaredNonStaticMembers$2=");
            sb.append(this.KClassImpl$Data$declaredNonStaticMembers$2);
            sb.append(')');
            return sb.toString();
        }

        public PromoAdsExploreParams(Double d, Double d2, String str) {
            Intrinsics.checkNotNullParameter(str, "");
            this.MyBillsEntityDataFactory = d;
            this.getAuthRequestContext = d2;
            this.KClassImpl$Data$declaredNonStaticMembers$2 = str;
        }
    }

    public static /* synthetic */ ObservableSource BuiltInFictitiousFunctionClassFactory(GetPromoAdsExplore getPromoAdsExplore, PromoAdsExploreParams promoAdsExploreParams, GlobalSearchConfig globalSearchConfig) {
        Observable<PromoAds> just;
        Intrinsics.checkNotNullParameter(getPromoAdsExplore, "");
        Intrinsics.checkNotNullParameter(promoAdsExploreParams, "");
        Intrinsics.checkNotNullParameter(globalSearchConfig, "");
        if (globalSearchConfig.getExplorePromoWidget()) {
            PromoCenterRepository promoCenterRepository = getPromoAdsExplore.PlaceComponentResult;
            int promoBannerLimit = globalSearchConfig.getExplorePromoConfig().getPromoBannerLimit();
            Double d = promoAdsExploreParams.MyBillsEntityDataFactory;
            double d2 = FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE;
            double doubleValue = d != null ? d.doubleValue() : 0.0d;
            Double d3 = promoAdsExploreParams.getAuthRequestContext;
            if (d3 != null) {
                d2 = d3.doubleValue();
            }
            just = promoCenterRepository.getPromoAds(promoBannerLimit, doubleValue, d2, promoAdsExploreParams.KClassImpl$Data$declaredNonStaticMembers$2);
        } else {
            just = Observable.just(new PromoAds(CollectionsKt.emptyList(), false));
            Intrinsics.checkNotNullExpressionValue(just, "");
        }
        return just;
    }

    public static /* synthetic */ GlobalSearchConfig KClassImpl$Data$declaredNonStaticMembers$2(GlobalSearchConfig globalSearchConfig, Boolean bool) {
        Intrinsics.checkNotNullParameter(globalSearchConfig, "");
        Intrinsics.checkNotNullParameter(bool, "");
        globalSearchConfig.setExplorePromoWidget(globalSearchConfig.getExplorePromoWidget() && bool.booleanValue());
        return globalSearchConfig;
    }
}
