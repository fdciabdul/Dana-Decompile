package id.dana.data.content.mapper;

import id.dana.data.banner.model.BannerEntity;
import id.dana.data.banner.model.BannerListEntity;
import id.dana.data.banner.repository.source.network.response.BannerDetailEntityResponse;
import id.dana.data.banner.repository.source.network.response.BannerListEntityResponse;
import id.dana.data.content.source.network.result.CdpContentEntity;
import id.dana.data.content.source.network.result.SpaceRpcResult;
import id.dana.domain.promotion.model.Banner;
import id.dana.domain.promotion.model.BannerCollection;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0007¢\u0006\u0004\b\u0018\u0010\u0019J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\t\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\t\u0010\nJ\u0015\u0010\u000e\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\u000b¢\u0006\u0004\b\u000e\u0010\u000fJ\u0015\u0010\u0012\u001a\u00020\u000b2\u0006\u0010\u0011\u001a\u00020\u0010¢\u0006\u0004\b\u0012\u0010\u0013J\u0015\u0010\u0012\u001a\u00020\u000b2\u0006\u0010\u0011\u001a\u00020\u0014¢\u0006\u0004\b\u0012\u0010\u0015J\u0013\u0010\t\u001a\u00020\u0002*\u00020\u0016H\u0002¢\u0006\u0004\b\t\u0010\u0017"}, d2 = {"Lid/dana/data/content/mapper/BannerListEntityMapper;", "", "Lid/dana/data/banner/model/BannerEntity;", "bannerEntity", "Lid/dana/domain/promotion/model/Banner;", "toBanner", "(Lid/dana/data/banner/model/BannerEntity;)Lid/dana/domain/promotion/model/Banner;", "Lid/dana/data/content/source/network/result/CdpContentEntity;", "cdpContentEntity", "toBannerEntity", "(Lid/dana/data/content/source/network/result/CdpContentEntity;)Lid/dana/data/banner/model/BannerEntity;", "Lid/dana/data/banner/model/BannerListEntity;", "bannerListEntity", "Lid/dana/domain/promotion/model/BannerCollection;", "transformToBannerCollection", "(Lid/dana/data/banner/model/BannerListEntity;)Lid/dana/domain/promotion/model/BannerCollection;", "Lid/dana/data/banner/repository/source/network/response/BannerListEntityResponse;", "response", "transformToBannerListEntity", "(Lid/dana/data/banner/repository/source/network/response/BannerListEntityResponse;)Lid/dana/data/banner/model/BannerListEntity;", "Lid/dana/data/content/source/network/result/SpaceRpcResult;", "(Lid/dana/data/content/source/network/result/SpaceRpcResult;)Lid/dana/data/banner/model/BannerListEntity;", "Lid/dana/data/banner/repository/source/network/response/BannerDetailEntityResponse;", "(Lid/dana/data/banner/repository/source/network/response/BannerDetailEntityResponse;)Lid/dana/data/banner/model/BannerEntity;", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class BannerListEntityMapper {
    @Inject
    public BannerListEntityMapper() {
    }

    public final BannerListEntity transformToBannerListEntity(BannerListEntityResponse response) {
        ArrayList emptyList;
        BannerDetailEntityResponse bannerDetailEntityResponse;
        String placement;
        Intrinsics.checkNotNullParameter(response, "");
        List<BannerDetailEntityResponse> banners = response.getBanners();
        String str = (banners == null || (bannerDetailEntityResponse = (BannerDetailEntityResponse) CollectionsKt.firstOrNull((List) banners)) == null || (placement = bannerDetailEntityResponse.getPlacement()) == null) ? "" : placement;
        List<BannerDetailEntityResponse> banners2 = response.getBanners();
        if (banners2 == null) {
            emptyList = CollectionsKt.emptyList();
        } else {
            List<BannerDetailEntityResponse> list = banners2;
            ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
            Iterator<T> it = list.iterator();
            while (it.hasNext()) {
                arrayList.add(toBannerEntity((BannerDetailEntityResponse) it.next()));
            }
            emptyList = arrayList;
        }
        return new BannerListEntity(str, null, null, emptyList, 6, null);
    }

    private final BannerEntity toBannerEntity(BannerDetailEntityResponse bannerDetailEntityResponse) {
        String bannerId = bannerDetailEntityResponse.getBannerId();
        String str = bannerId == null ? "" : bannerId;
        String bannerName = bannerDetailEntityResponse.getBannerName();
        String str2 = bannerName == null ? "" : bannerName;
        String imageBannerUrl = bannerDetailEntityResponse.getImageBannerUrl();
        String str3 = imageBannerUrl == null ? "" : imageBannerUrl;
        Integer priority = bannerDetailEntityResponse.getPriority();
        int intValue = priority != null ? priority.intValue() : 0;
        String redirectUrl = bannerDetailEntityResponse.getRedirectUrl();
        String str4 = redirectUrl == null ? "" : redirectUrl;
        String status = bannerDetailEntityResponse.getStatus();
        return new BannerEntity(null, str, str2, null, str3, null, null, null, str4, status == null ? "" : status, Integer.valueOf(intValue), 233, null);
    }

    public final BannerListEntity transformToBannerListEntity(SpaceRpcResult response) {
        ArrayList emptyList;
        Intrinsics.checkNotNullParameter(response, "");
        String spaceCode = response.getSpaceCode();
        String str = spaceCode == null ? "" : spaceCode;
        String spaceName = response.getSpaceName();
        String str2 = spaceName == null ? "" : spaceName;
        List<CdpContentEntity> cdpContents = response.getCdpContents();
        List<CdpContentEntity> list = cdpContents;
        if ((!(list == null || list.isEmpty())) == false) {
            cdpContents = null;
        }
        if (cdpContents == null) {
            emptyList = CollectionsKt.emptyList();
        } else {
            List<CdpContentEntity> list2 = cdpContents;
            ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list2, 10));
            for (CdpContentEntity cdpContentEntity : list2) {
                Intrinsics.checkNotNullExpressionValue(cdpContentEntity, "");
                arrayList.add(toBannerEntity(cdpContentEntity));
            }
            emptyList = arrayList;
        }
        return new BannerListEntity(str, str2, null, emptyList, 4, null);
    }

    private final BannerEntity toBannerEntity(CdpContentEntity cdpContentEntity) {
        String bizType = cdpContentEntity.getBizType();
        String str = bizType == null ? "" : bizType;
        String contentId = cdpContentEntity.getContentId();
        String str2 = contentId == null ? "" : contentId;
        String contentName = cdpContentEntity.getContentName();
        String str3 = contentName == null ? "" : contentName;
        String contentType = cdpContentEntity.getContentType();
        String str4 = contentType == null ? "" : contentType;
        String contentValue = cdpContentEntity.getContentValue();
        String str5 = contentValue == null ? "" : contentValue;
        Date effectiveDate = cdpContentEntity.getEffectiveDate();
        Date expireDate = cdpContentEntity.getExpireDate();
        String extendInfo = cdpContentEntity.getExtendInfo();
        String str6 = extendInfo == null ? "" : extendInfo;
        String redirectUrl = cdpContentEntity.getRedirectUrl();
        String str7 = redirectUrl == null ? "" : redirectUrl;
        String status = cdpContentEntity.getStatus();
        return new BannerEntity(str, str2, str3, str4, str5, effectiveDate, expireDate, str6, str7, status == null ? "" : status, null, 1024, null);
    }

    public final BannerCollection transformToBannerCollection(BannerListEntity bannerListEntity) {
        ArrayList emptyList;
        Intrinsics.checkNotNullParameter(bannerListEntity, "");
        String spaceCode = bannerListEntity.getSpaceCode();
        if (spaceCode == null) {
            spaceCode = "";
        }
        String spaceName = bannerListEntity.getSpaceName();
        if (spaceName == null) {
            spaceName = "";
        }
        String spaceType = bannerListEntity.getSpaceType();
        String str = spaceType != null ? spaceType : "";
        List<BannerEntity> contents = bannerListEntity.getContents();
        if ((!contents.isEmpty()) == false) {
            contents = null;
        }
        if (contents == null) {
            emptyList = CollectionsKt.emptyList();
        } else {
            List<BannerEntity> list = contents;
            ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
            Iterator<T> it = list.iterator();
            while (it.hasNext()) {
                arrayList.add(toBanner((BannerEntity) it.next()));
            }
            emptyList = arrayList;
        }
        return new BannerCollection(spaceCode, spaceName, str, emptyList);
    }

    private final Banner toBanner(BannerEntity bannerEntity) {
        String bizType = bannerEntity.getBizType();
        String str = bizType == null ? "" : bizType;
        String contentId = bannerEntity.getContentId();
        String str2 = contentId == null ? "" : contentId;
        String contentName = bannerEntity.getContentName();
        String str3 = contentName == null ? "" : contentName;
        String contentValue = bannerEntity.getContentValue();
        String str4 = contentValue == null ? "" : contentValue;
        String contentType = bannerEntity.getContentType();
        String str5 = contentType == null ? "" : contentType;
        Date effectiveDate = bannerEntity.getEffectiveDate();
        Date expireDate = bannerEntity.getExpireDate();
        String redirectUrl = bannerEntity.getRedirectUrl();
        String str6 = redirectUrl == null ? "" : redirectUrl;
        String status = bannerEntity.getStatus();
        String str7 = status == null ? "" : status;
        Integer priority = bannerEntity.getPriority();
        return new Banner(str, str2, str3, str4, str5, effectiveDate, expireDate, null, str6, str7, priority != null ? priority.intValue() : 0, 128, null);
    }
}
