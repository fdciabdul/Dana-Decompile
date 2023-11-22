package id.dana.data.homeinfo.mapper;

import id.dana.data.homeinfo.model.BannerLottieEntity;
import id.dana.data.homeinfo.model.BannerLottieEntityKt;
import id.dana.data.homeinfo.model.KycEntity;
import id.dana.data.homeinfo.model.ProcessingTransactionEntity;
import id.dana.data.homeinfo.model.SkuAttributeEntity;
import id.dana.data.homeinfo.model.SkuAttributeEntityKt;
import id.dana.data.homeinfo.model.SurveyInfo;
import id.dana.data.homeinfo.model.ThirdPartyEntity;
import id.dana.data.homeinfo.repository.source.network.result.HomeInfoResult;
import id.dana.data.model.CurrencyAmountResult;
import id.dana.data.services.repository.source.model.CategoryServices;
import id.dana.data.storage.Serializer;
import id.dana.domain.homeinfo.HomeInfoResponse;
import id.dana.domain.homeinfo.KycResponse;
import id.dana.domain.homeinfo.ProcessingTransactionResponse;
import id.dana.domain.homeinfo.SurveyInfoResponse;
import id.dana.domain.homeinfo.ThirdPartyServiceResponse;
import id.dana.domain.services.model.CategoryServicesModel;
import id.dana.domain.services.model.ThirdPartyCategoryService;
import id.dana.domain.user.CurrencyAmount;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.inject.Inject;
import javax.inject.Singleton;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

@Singleton
@Metadata(d1 = {"\u0000t\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001B\u0011\b\u0007\u0012\u0006\u0010%\u001a\u00020$¢\u0006\u0004\b'\u0010(J\u0019\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u001b\u0010\t\u001a\u0004\u0018\u00010\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u0007H\u0002¢\u0006\u0004\b\t\u0010\nJ\u001b\u0010\t\u001a\u0004\u0018\u00010\f2\b\u0010\u0003\u001a\u0004\u0018\u00010\u000bH\u0002¢\u0006\u0004\b\t\u0010\rJ\u001b\u0010\t\u001a\u0004\u0018\u00010\u000f2\b\u0010\u0003\u001a\u0004\u0018\u00010\u000eH\u0002¢\u0006\u0004\b\t\u0010\u0010J\u0019\u0010\t\u001a\u0004\u0018\u00010\u00112\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\t\u0010\u0012J\u0019\u0010\t\u001a\u0004\u0018\u00010\u00142\b\u0010\u0003\u001a\u0004\u0018\u00010\u0013¢\u0006\u0004\b\t\u0010\u0015J\u001b\u0010\t\u001a\u0004\u0018\u00010\u00172\b\u0010\u0003\u001a\u0004\u0018\u00010\u0016H\u0002¢\u0006\u0004\b\t\u0010\u0018J%\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00110\u00192\u0010\u0010\u001a\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0018\u00010\u0019¢\u0006\u0004\b\t\u0010\u001bJ)\u0010\t\u001a\u00020\u001f2\u0010\u0010\u001c\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0011\u0018\u00010\u00192\b\u0010\u001e\u001a\u0004\u0018\u00010\u001d¢\u0006\u0004\b\t\u0010 J)\u0010\t\u001a\u00020\u001f2\u0010\u0010\u001c\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0011\u0018\u00010\u00192\b\u0010\"\u001a\u0004\u0018\u00010!¢\u0006\u0004\b\t\u0010#R\u0014\u0010%\u001a\u00020$8\u0002X\u0083\u0004¢\u0006\u0006\n\u0004\b%\u0010&"}, d2 = {"Lid/dana/data/homeinfo/mapper/HomeInfoResultMapper;", "", "Lid/dana/data/homeinfo/model/ThirdPartyEntity;", "entity", "Lid/dana/domain/homeinfo/ThirdPartyServiceResponse$SpmId;", "getSpmId", "(Lid/dana/data/homeinfo/model/ThirdPartyEntity;)Lid/dana/domain/homeinfo/ThirdPartyServiceResponse$SpmId;", "Lid/dana/data/homeinfo/model/KycEntity;", "Lid/dana/domain/homeinfo/KycResponse;", "transform", "(Lid/dana/data/homeinfo/model/KycEntity;)Lid/dana/domain/homeinfo/KycResponse;", "Lid/dana/data/homeinfo/model/ProcessingTransactionEntity;", "Lid/dana/domain/homeinfo/ProcessingTransactionResponse;", "(Lid/dana/data/homeinfo/model/ProcessingTransactionEntity;)Lid/dana/domain/homeinfo/ProcessingTransactionResponse;", "Lid/dana/data/homeinfo/model/SurveyInfo;", "Lid/dana/domain/homeinfo/SurveyInfoResponse;", "(Lid/dana/data/homeinfo/model/SurveyInfo;)Lid/dana/domain/homeinfo/SurveyInfoResponse;", "Lid/dana/domain/homeinfo/ThirdPartyServiceResponse;", "(Lid/dana/data/homeinfo/model/ThirdPartyEntity;)Lid/dana/domain/homeinfo/ThirdPartyServiceResponse;", "Lid/dana/data/homeinfo/repository/source/network/result/HomeInfoResult;", "Lid/dana/domain/homeinfo/HomeInfoResponse;", "(Lid/dana/data/homeinfo/repository/source/network/result/HomeInfoResult;)Lid/dana/domain/homeinfo/HomeInfoResponse;", "Lid/dana/data/model/CurrencyAmountResult;", "Lid/dana/domain/user/CurrencyAmount;", "(Lid/dana/data/model/CurrencyAmountResult;)Lid/dana/domain/user/CurrencyAmount;", "", "entities", "(Ljava/util/List;)Ljava/util/List;", "thirdPartyServices", "Lid/dana/data/services/repository/source/model/CategoryServices;", "categoryServices", "Lid/dana/domain/services/model/ThirdPartyCategoryService;", "(Ljava/util/List;Lid/dana/data/services/repository/source/model/CategoryServices;)Lid/dana/domain/services/model/ThirdPartyCategoryService;", "", "key", "(Ljava/util/List;Ljava/lang/String;)Lid/dana/domain/services/model/ThirdPartyCategoryService;", "Lid/dana/data/storage/Serializer;", "serializer", "Lid/dana/data/storage/Serializer;", "<init>", "(Lid/dana/data/storage/Serializer;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class HomeInfoResultMapper {
    private final Serializer serializer;

    @Inject
    public HomeInfoResultMapper(Serializer serializer) {
        Intrinsics.checkNotNullParameter(serializer, "");
        this.serializer = serializer;
    }

    public final HomeInfoResponse transform(HomeInfoResult entity) {
        if (entity != null) {
            HomeInfoResponse homeInfoResponse = new HomeInfoResponse();
            homeInfoResponse.setMobileNo(entity.getMobileNo());
            homeInfoResponse.setBalance(transform(entity.getBalance()));
            homeInfoResponse.setAvatarUrl(entity.getAvatarUrl());
            homeInfoResponse.setNickname(entity.getNickname());
            homeInfoResponse.setProcessingTrans(transform(entity.getProcessingTrans()));
            homeInfoResponse.setThirdPartyLinks(transform(entity.getThirdPartyLinks()));
            homeInfoResponse.setKyc(transform(entity.getKyc()));
            homeInfoResponse.setSurveyInfo(transform(entity.getSurveyInfo()));
            homeInfoResponse.setAkuInfo(entity.getAkuInfo());
            homeInfoResponse.setPaylaterChannel(entity.paylaterChannel);
            return homeInfoResponse;
        }
        return null;
    }

    private final CurrencyAmount transform(CurrencyAmountResult entity) {
        if (entity != null) {
            return new CurrencyAmount(entity.getAmount(), entity.getCurrency());
        }
        return null;
    }

    private final ProcessingTransactionResponse transform(ProcessingTransactionEntity entity) {
        if (entity != null) {
            ProcessingTransactionResponse processingTransactionResponse = new ProcessingTransactionResponse();
            processingTransactionResponse.setCount(entity.count);
            processingTransactionResponse.setHasMore(entity.hasMore);
            return processingTransactionResponse;
        }
        return null;
    }

    public final List<ThirdPartyServiceResponse> transform(List<ThirdPartyEntity> entities) {
        ArrayList arrayList;
        if (entities != null) {
            ArrayList arrayList2 = new ArrayList();
            Iterator<T> it = entities.iterator();
            while (it.hasNext()) {
                ThirdPartyServiceResponse transform = transform((ThirdPartyEntity) it.next());
                if (transform != null) {
                    arrayList2.add(transform);
                }
            }
            arrayList = arrayList2;
        } else {
            arrayList = null;
        }
        return arrayList == null ? CollectionsKt.emptyList() : arrayList;
    }

    public final ThirdPartyCategoryService transform(List<ThirdPartyServiceResponse> thirdPartyServices, String key) {
        ThirdPartyCategoryService thirdPartyCategoryService = new ThirdPartyCategoryService();
        thirdPartyCategoryService.setKey(key);
        thirdPartyCategoryService.setThirdPartyServices(thirdPartyServices);
        return thirdPartyCategoryService;
    }

    public final ThirdPartyCategoryService transform(List<ThirdPartyServiceResponse> thirdPartyServices, CategoryServices categoryServices) {
        ThirdPartyCategoryService thirdPartyCategoryService = new ThirdPartyCategoryService();
        thirdPartyCategoryService.setKey(categoryServices != null ? categoryServices.getCategory() : null);
        thirdPartyCategoryService.setCategoryServicesModel(categoryServices != null ? new CategoryServicesModel(categoryServices.getCategory(), categoryServices.getEn(), categoryServices.getId()) : null);
        thirdPartyCategoryService.setThirdPartyServices(thirdPartyServices);
        return thirdPartyCategoryService;
    }

    private final KycResponse transform(KycEntity entity) {
        if (entity != null) {
            KycResponse kycResponse = new KycResponse();
            kycResponse.setLevel(entity.level);
            kycResponse.setOrderStatus(entity.orderStatus);
            return kycResponse;
        }
        return null;
    }

    private final SurveyInfoResponse transform(SurveyInfo entity) {
        if (entity != null) {
            SurveyInfoResponse surveyInfoResponse = new SurveyInfoResponse();
            surveyInfoResponse.setHasActiveSurvey(entity.hasActiveSurvey);
            surveyInfoResponse.setInnerUrl(entity.innerUrl);
            return surveyInfoResponse;
        }
        return null;
    }

    public final ThirdPartyServiceResponse transform(ThirdPartyEntity entity) {
        if (entity != null) {
            String str = null;
            ThirdPartyServiceResponse thirdPartyServiceResponse = new ThirdPartyServiceResponse(null, null, null, null, false, null, null, null, null, null, null, null, null, str, str, null, null, null, null, null, false, null, false, null, null, null, null, null, null, null, false, null, null, null, null, null, null, -1, 31, null);
            String key = entity.getKey();
            if (key == null) {
                key = "";
            }
            thirdPartyServiceResponse.setKey(key);
            thirdPartyServiceResponse.setIcon(entity.getIcon());
            thirdPartyServiceResponse.setLink(entity.getLink());
            thirdPartyServiceResponse.setName(entity.getName());
            thirdPartyServiceResponse.setNameInd(entity.getNameInd());
            thirdPartyServiceResponse.setNameTag(entity.getNameTag());
            thirdPartyServiceResponse.setEnable(entity.getEnable());
            thirdPartyServiceResponse.setAction(entity.getAction());
            thirdPartyServiceResponse.setOperationType(entity.getOperationType());
            thirdPartyServiceResponse.setRedirectUrl(entity.getRedirectUrl());
            thirdPartyServiceResponse.setClientId(entity.getClientId());
            thirdPartyServiceResponse.setAppId(entity.getAppId());
            thirdPartyServiceResponse.setScopes(entity.getScopes());
            thirdPartyServiceResponse.setUserAction(entity.getUserAction());
            thirdPartyServiceResponse.setDescription(entity.getDescription());
            thirdPartyServiceResponse.setSubtitleColor(entity.getSubtitleColor());
            thirdPartyServiceResponse.setButtonTitle(entity.getButtonTitle());
            thirdPartyServiceResponse.setSubtitleBorderColor(entity.getSubtitleBorderColor());
            thirdPartyServiceResponse.setKeyword(entity.getKeyword());
            thirdPartyServiceResponse.setRibbonText(entity.getRibbonText());
            thirdPartyServiceResponse.setHasRedDot(entity.getHasRedDot());
            thirdPartyServiceResponse.setSpmId(getSpmId(entity));
            SkuAttributeEntity skuAttr = entity.getSkuAttr();
            thirdPartyServiceResponse.setSkuAttr(skuAttr != null ? SkuAttributeEntityKt.toSkuAttribute(skuAttr) : null);
            thirdPartyServiceResponse.setSpaceCodes(entity.getSpaceCodes());
            thirdPartyServiceResponse.setNeedConsult(entity.getNeedConsult());
            thirdPartyServiceResponse.setScreenOrientation(entity.getScreenOrientation());
            thirdPartyServiceResponse.setNeedOauth(entity.getNeedOauth());
            thirdPartyServiceResponse.setBizType(entity.getBizType());
            thirdPartyServiceResponse.setBiller(entity.isBiller());
            thirdPartyServiceResponse.setRotationDelayTime(entity.getRotationDelayTime());
            thirdPartyServiceResponse.setDirectOpen(entity.getDirectOpen());
            BannerLottieEntity bannerLottie = entity.getBannerLottie();
            thirdPartyServiceResponse.setBannerLottie(bannerLottie != null ? BannerLottieEntityKt.toBannerLottie(bannerLottie) : null);
            thirdPartyServiceResponse.setIconLottie(entity.getIconLottie());
            thirdPartyServiceResponse.setHeaderBackgroundColor(entity.getHeaderBackgroundColor());
            thirdPartyServiceResponse.setAlwaysConsult(entity.getAlwaysConsult());
            return thirdPartyServiceResponse;
        }
        return null;
    }

    private final ThirdPartyServiceResponse.SpmId getSpmId(ThirdPartyEntity entity) {
        if (entity.getSpmId() != null) {
            return (ThirdPartyServiceResponse.SpmId) this.serializer.deserialize(entity.getSpmId(), ThirdPartyServiceResponse.SpmId.class);
        }
        return null;
    }
}
