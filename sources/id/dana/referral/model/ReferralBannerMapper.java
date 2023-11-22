package id.dana.referral.model;

import id.dana.data.base.BaseMapper;
import id.dana.domain.promotion.CdpContent;
import java.util.Date;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\t\b\u0007¢\u0006\u0004\b\n\u0010\u000bJ\u0017\u0010\u0005\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0002H\u0014¢\u0006\u0004\b\u0005\u0010\u0006R\u0018\u0010\b\u001a\u0004\u0018\u00010\u00078\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\b\u0010\t"}, d2 = {"Lid/dana/referral/model/ReferralBannerMapper;", "Lid/dana/data/base/BaseMapper;", "Lid/dana/domain/promotion/CdpContent;", "Lid/dana/referral/model/ReferralBannerContent;", "p0", "KClassImpl$Data$declaredNonStaticMembers$2", "(Lid/dana/domain/promotion/CdpContent;)Lid/dana/referral/model/ReferralBannerContent;", "", "MyBillsEntityDataFactory", "Ljava/lang/String;", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class ReferralBannerMapper extends BaseMapper<CdpContent, ReferralBannerContent> {
    public String MyBillsEntityDataFactory = "";

    @Override // id.dana.data.base.BaseMapper
    public final /* synthetic */ ReferralBannerContent apply(CdpContent cdpContent) {
        CdpContent cdpContent2 = cdpContent;
        Intrinsics.checkNotNullParameter(cdpContent2, "");
        return map(cdpContent2);
    }

    @Inject
    public ReferralBannerMapper() {
    }

    @Override // id.dana.data.base.BaseMapper
    /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: merged with bridge method [inline-methods] */
    public final ReferralBannerContent map(CdpContent p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        String contentId = p0.getContentId();
        String str = contentId == null ? "" : contentId;
        String contentName = p0.getContentName();
        String str2 = contentName == null ? "" : contentName;
        String contentType = p0.getContentType();
        String str3 = contentType == null ? "" : contentType;
        String contentValue = p0.getContentValue();
        String str4 = contentValue == null ? "" : contentValue;
        Date expireDate = p0.getExpireDate();
        String redirectUrl = p0.getRedirectUrl();
        String str5 = redirectUrl == null ? "" : redirectUrl;
        String str6 = this.MyBillsEntityDataFactory;
        return new ReferralBannerContent(str, str2, str3, str4, expireDate, str5, str6 == null ? "" : str6);
    }
}
