package id.dana.data.donation.mapper;

import id.dana.data.donation.model.DonationCampaignsEntity;
import id.dana.data.donation.model.RedirectValueEntity;
import id.dana.data.donation.repository.source.network.result.DonationCampaignResult;
import id.dana.domain.donation.model.DonationCampaign;
import id.dana.domain.donation.model.RedirectValue;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010!\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0011\u0010\u0002\u001a\u00020\u0001*\u00020\u0000¢\u0006\u0004\b\u0002\u0010\u0003\u001a\u0017\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00010\u0005*\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007\u001a\u0011\u0010\n\u001a\u00020\t*\u00020\b¢\u0006\u0004\b\n\u0010\u000b"}, d2 = {"Lid/dana/data/donation/model/DonationCampaignsEntity;", "Lid/dana/domain/donation/model/DonationCampaign;", "toDonationCampaign", "(Lid/dana/data/donation/model/DonationCampaignsEntity;)Lid/dana/domain/donation/model/DonationCampaign;", "Lid/dana/data/donation/repository/source/network/result/DonationCampaignResult;", "", "toDonationList", "(Lid/dana/data/donation/repository/source/network/result/DonationCampaignResult;)Ljava/util/List;", "Lid/dana/data/donation/model/RedirectValueEntity;", "Lid/dana/domain/donation/model/RedirectValue;", "toRedirectValue", "(Lid/dana/data/donation/model/RedirectValueEntity;)Lid/dana/domain/donation/model/RedirectValue;"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes8.dex */
public final class DonationCampaignMapperKt {
    public static final List<DonationCampaign> toDonationList(DonationCampaignResult donationCampaignResult) {
        Intrinsics.checkNotNullParameter(donationCampaignResult, "");
        List<DonationCampaignsEntity> donationCampaigns = donationCampaignResult.getDonationCampaigns();
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(donationCampaigns, 10));
        Iterator<T> it = donationCampaigns.iterator();
        while (it.hasNext()) {
            arrayList.add(toDonationCampaign((DonationCampaignsEntity) it.next()));
        }
        return CollectionsKt.toMutableList((Collection) arrayList);
    }

    public static final DonationCampaign toDonationCampaign(DonationCampaignsEntity donationCampaignsEntity) {
        Intrinsics.checkNotNullParameter(donationCampaignsEntity, "");
        return new DonationCampaign(donationCampaignsEntity.getAggregator(), donationCampaignsEntity.getFundRaiserName(), donationCampaignsEntity.getVerified(), donationCampaignsEntity.getBackgroundImage(), donationCampaignsEntity.getRedirectType(), donationCampaignsEntity.getTitle(), toRedirectValue(donationCampaignsEntity.getRedirectValue()));
    }

    public static final RedirectValue toRedirectValue(RedirectValueEntity redirectValueEntity) {
        Intrinsics.checkNotNullParameter(redirectValueEntity, "");
        return new RedirectValue(redirectValueEntity.getClientId(), redirectValueEntity.getScopes(), redirectValueEntity.getAgreed(), redirectValueEntity.getUrl());
    }
}
