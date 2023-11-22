package id.dana.donation.mapper;

import id.dana.domain.donation.model.DonationCampaign;
import id.dana.donation.model.DonationCampaignModel;
import id.dana.richview.widgetcard.WidgetItem;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001a\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u001a\u001d\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002*\b\u0012\u0004\u0012\u00020\u00010\u0000¢\u0006\u0004\b\u0004\u0010\u0005\u001a\u001d\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u0000*\b\u0012\u0004\u0012\u00020\u00030\u0000¢\u0006\u0004\b\u0007\u0010\u0005"}, d2 = {"", "Lid/dana/domain/donation/model/DonationCampaign;", "", "Lid/dana/donation/model/DonationCampaignModel;", "getAuthRequestContext", "(Ljava/util/List;)Ljava/util/List;", "Lid/dana/richview/widgetcard/WidgetItem;", "PlaceComponentResult"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes8.dex */
public final class DonationCampaignModelMapperKt {
    public static final List<DonationCampaignModel> getAuthRequestContext(List<DonationCampaign> list) {
        Intrinsics.checkNotNullParameter(list, "");
        List<DonationCampaign> list2 = list;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list2, 10));
        for (DonationCampaign donationCampaign : list2) {
            Intrinsics.checkNotNullParameter(donationCampaign, "");
            arrayList.add(new DonationCampaignModel(donationCampaign.getAggregator(), donationCampaign.getFundRaiserName(), donationCampaign.getVerified(), donationCampaign.getBackgroundImage(), donationCampaign.getRedirectType(), donationCampaign.getTitle(), donationCampaign.getRedirectValue().getCliendId(), donationCampaign.getRedirectValue().getScopes(), donationCampaign.getRedirectValue().getAgreed(), donationCampaign.getRedirectValue().getUrl(), null, 1024, null));
        }
        return CollectionsKt.toMutableList((Collection) arrayList);
    }

    public static final List<WidgetItem> PlaceComponentResult(List<DonationCampaignModel> list) {
        Intrinsics.checkNotNullParameter(list, "");
        List<DonationCampaignModel> list2 = list;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list2, 10));
        for (DonationCampaignModel donationCampaignModel : list2) {
            String str = donationCampaignModel.getAuthRequestContext;
            Intrinsics.checkNotNullParameter(donationCampaignModel, "");
            Intrinsics.checkNotNullParameter(str, "");
            String str2 = donationCampaignModel.KClassImpl$Data$declaredNonStaticMembers$2;
            String str3 = donationCampaignModel.moveToNextValue;
            boolean getContactSyncConfig = donationCampaignModel.getGetContactSyncConfig();
            arrayList.add(new WidgetItem(str, str2, str3, Boolean.valueOf(getContactSyncConfig), donationCampaignModel.MyBillsEntityDataFactory));
        }
        return arrayList;
    }
}
