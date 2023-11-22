package id.dana.wallet_v3.mapper;

import id.dana.domain.pocket.model.AssetCategory;
import id.dana.domain.pocket.model.ShareableRpcInfo;
import id.dana.domain.wallet_v3.model.UserPocketAssetListModel;
import id.dana.domain.wallet_v3.model.UserPocketAssetModel;
import id.dana.utils.DateTimeUtil;
import id.dana.wallet_v3.model.AssetCategoryModel;
import id.dana.wallet_v3.model.LoyaltyCardModel;
import id.dana.wallet_v3.model.NewPocketQueryListModel;
import id.dana.wallet_v3.model.TravelTicketStatus;
import id.dana.wallet_v3.model.VoucherAndTicketCardModel;
import id.dana.wallet_v3.model.WalletV3CardModel;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0013\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u0002¢\u0006\u0004\b\u0002\u0010\u0003\u001a\u0019\u0010\b\u001a\u00020\u0007*\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\b\u0010\t\u001a=\u0010\u0010\u001a\b\u0012\u0004\u0012\u00028\u00010\u000f\"\u0004\b\u0000\u0010\n\"\u0004\b\u0001\u0010\u000b*\b\u0012\u0004\u0012\u00028\u00000\f2\u0012\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\r¢\u0006\u0004\b\u0010\u0010\u0011\u001a\u0019\u0010\u0013\u001a\u00020\u0012*\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0013\u0010\u0014\u001a\u0019\u0010\u0016\u001a\u00020\u0015*\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0016\u0010\u0017"}, d2 = {"Lid/dana/domain/pocket/model/AssetCategory;", "Lid/dana/wallet_v3/model/AssetCategoryModel;", "toAssetCategoryModel", "(Lid/dana/domain/pocket/model/AssetCategory;)Lid/dana/wallet_v3/model/AssetCategoryModel;", "Lid/dana/domain/wallet_v3/model/UserPocketAssetModel;", "", "isUsed", "Lid/dana/wallet_v3/model/LoyaltyCardModel;", "toLoyaltyCardModel", "(Lid/dana/domain/wallet_v3/model/UserPocketAssetModel;Z)Lid/dana/wallet_v3/model/LoyaltyCardModel;", "T", "R", "Lid/dana/domain/wallet_v3/model/UserPocketAssetListModel;", "Lkotlin/Function1;", "mapper", "Lid/dana/wallet_v3/model/NewPocketQueryListModel;", "toNewPocketQueryListModel", "(Lid/dana/domain/wallet_v3/model/UserPocketAssetListModel;Lkotlin/jvm/functions/Function1;)Lid/dana/wallet_v3/model/NewPocketQueryListModel;", "Lid/dana/wallet_v3/model/VoucherAndTicketCardModel;", "toVoucherAndTicketCardModel", "(Lid/dana/domain/wallet_v3/model/UserPocketAssetModel;Z)Lid/dana/wallet_v3/model/VoucherAndTicketCardModel;", "Lid/dana/wallet_v3/model/WalletV3CardModel;", "toVoucherAndTicketOrLoyaltyCardModel", "(Lid/dana/domain/wallet_v3/model/UserPocketAssetModel;Z)Lid/dana/wallet_v3/model/WalletV3CardModel;"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class UserPocketAssetsMapperKt {
    public static final <T, R> NewPocketQueryListModel<R> toNewPocketQueryListModel(UserPocketAssetListModel<T> userPocketAssetListModel, Function1<? super T, ? extends R> function1) {
        Intrinsics.checkNotNullParameter(userPocketAssetListModel, "");
        Intrinsics.checkNotNullParameter(function1, "");
        boolean hasMore = userPocketAssetListModel.getHasMore();
        List<T> pockets = userPocketAssetListModel.getPockets();
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(pockets, 10));
        Iterator<T> it = pockets.iterator();
        while (it.hasNext()) {
            arrayList.add(function1.invoke((T) it.next()));
        }
        return new NewPocketQueryListModel<>(hasMore, arrayList, userPocketAssetListModel.getTotalCount());
    }

    public static final WalletV3CardModel toVoucherAndTicketOrLoyaltyCardModel(UserPocketAssetModel userPocketAssetModel, boolean z) {
        Intrinsics.checkNotNullParameter(userPocketAssetModel, "");
        return userPocketAssetModel instanceof UserPocketAssetModel.UserLoyaltyAsset ? toLoyaltyCardModel(userPocketAssetModel, z) : toVoucherAndTicketCardModel(userPocketAssetModel, z);
    }

    public static final VoucherAndTicketCardModel toVoucherAndTicketCardModel(UserPocketAssetModel userPocketAssetModel, boolean z) {
        Intrinsics.checkNotNullParameter(userPocketAssetModel, "");
        String enterTime = null;
        if (userPocketAssetModel instanceof UserPocketAssetModel.DealsAsset) {
            UserPocketAssetModel.DealsAsset dealsAsset = (UserPocketAssetModel.DealsAsset) userPocketAssetModel;
            long activateDate = dealsAsset.getActivateDate();
            String amount = dealsAsset.getAmount();
            String shortDescription = dealsAsset.getShortDescription();
            String templateId = dealsAsset.getTemplateId();
            String uniqueId = dealsAsset.getUniqueId();
            String howTo = dealsAsset.getHowTo();
            String pocketId = userPocketAssetModel.getPocketId();
            String pocketStatus = userPocketAssetModel.getPocketStatus();
            String userPocketStatus = dealsAsset.getUserPocketStatus();
            String pocketType = userPocketAssetModel.getPocketType();
            String merchantId = dealsAsset.getMerchantId();
            String label = dealsAsset.getLabel();
            String subLabel = dealsAsset.getSubLabel();
            String iconUrl = userPocketAssetModel.getIconUrl();
            String logoUrl = dealsAsset.getLogoUrl();
            String backgroundUrl = userPocketAssetModel.getBackgroundUrl();
            boolean usable = dealsAsset.getUsable();
            boolean shareable = dealsAsset.getShareable();
            long expirationDate = dealsAsset.getExpirationDate();
            ShareableRpcInfo shareableRpcInfo = dealsAsset.getShareableRpcInfo();
            return new VoucherAndTicketCardModel.DealsCard(pocketId, pocketStatus, pocketType, z, activateDate, amount, shortDescription, templateId, uniqueId, howTo, userPocketStatus, merchantId, label, subLabel, iconUrl, logoUrl, backgroundUrl, usable, shareable, Long.valueOf(expirationDate), shareableRpcInfo != null ? ShareableRpcInfoModelMapperKt.toShareableRpcInfoModel(shareableRpcInfo) : null, null, null, dealsAsset.getBackgroundColor(), dealsAsset.getFontColor(), dealsAsset.getMinTransaction(), dealsAsset.getCategoryIconUrl(), dealsAsset.getBizType(), dealsAsset.isOnlineMerchant(), dealsAsset.getRedemptionType(), dealsAsset.getProviderCategory(), dealsAsset.getDiscountRate(), 6291456, null);
        } else if (userPocketAssetModel instanceof UserPocketAssetModel.UserVoucherAsset) {
            UserPocketAssetModel.UserVoucherAsset userVoucherAsset = (UserPocketAssetModel.UserVoucherAsset) userPocketAssetModel;
            long activateDate2 = userVoucherAsset.getActivateDate();
            String amount2 = userVoucherAsset.getAmount();
            String shortDescription2 = userVoucherAsset.getShortDescription();
            String templateId2 = userVoucherAsset.getTemplateId();
            String uniqueId2 = userVoucherAsset.getUniqueId();
            String howTo2 = userVoucherAsset.getHowTo();
            String pocketId2 = userPocketAssetModel.getPocketId();
            String pocketStatus2 = userPocketAssetModel.getPocketStatus();
            String userPocketStatus2 = userVoucherAsset.getUserPocketStatus();
            String pocketType2 = userPocketAssetModel.getPocketType();
            String merchantId2 = userVoucherAsset.getMerchantId();
            String label2 = userVoucherAsset.getLabel();
            String subLabel2 = userVoucherAsset.getSubLabel();
            String iconUrl2 = userPocketAssetModel.getIconUrl();
            String logoUrl2 = userVoucherAsset.getLogoUrl();
            String backgroundUrl2 = userPocketAssetModel.getBackgroundUrl();
            boolean usable2 = userVoucherAsset.getUsable();
            boolean shareable2 = userVoucherAsset.getShareable();
            long expirationDate2 = userVoucherAsset.getExpirationDate();
            ShareableRpcInfo shareableRpcInfo2 = userVoucherAsset.getShareableRpcInfo();
            return new VoucherAndTicketCardModel.VoucherCard(pocketId2, pocketStatus2, pocketType2, z, activateDate2, amount2, shortDescription2, templateId2, uniqueId2, howTo2, userPocketStatus2, merchantId2, label2, subLabel2, iconUrl2, logoUrl2, backgroundUrl2, usable2, shareable2, Long.valueOf(expirationDate2), shareableRpcInfo2 != null ? ShareableRpcInfoModelMapperKt.toShareableRpcInfoModel(shareableRpcInfo2) : null, null, null, 6291456, null);
        } else if (userPocketAssetModel instanceof UserPocketAssetModel.UserVoucherCodeAsset) {
            UserPocketAssetModel.UserVoucherCodeAsset userVoucherCodeAsset = (UserPocketAssetModel.UserVoucherCodeAsset) userPocketAssetModel;
            String shortDescription3 = userVoucherCodeAsset.getShortDescription();
            String howTo3 = userVoucherCodeAsset.getHowTo();
            String pocketId3 = userPocketAssetModel.getPocketId();
            String pocketStatus3 = userPocketAssetModel.getPocketStatus();
            String userPocketStatus3 = userVoucherCodeAsset.getUserPocketStatus();
            String pocketType3 = userPocketAssetModel.getPocketType();
            String merchantId3 = userVoucherCodeAsset.getMerchantId();
            String label3 = userVoucherCodeAsset.getLabel();
            String subLabel3 = userVoucherCodeAsset.getSubLabel();
            String iconUrl3 = userPocketAssetModel.getIconUrl();
            String backgroundUrl3 = userPocketAssetModel.getBackgroundUrl();
            Long expirationDate3 = userVoucherCodeAsset.getExpirationDate();
            ShareableRpcInfo shareableRpcInfo3 = userVoucherCodeAsset.getShareableRpcInfo();
            return new VoucherAndTicketCardModel.VoucherCard(pocketId3, pocketStatus3, pocketType3, z, 0L, null, shortDescription3, null, null, howTo3, userPocketStatus3, merchantId3, label3, subLabel3, iconUrl3, null, backgroundUrl3, false, false, expirationDate3, shareableRpcInfo3 != null ? ShareableRpcInfoModelMapperKt.toShareableRpcInfoModel(shareableRpcInfo3) : null, null, userVoucherCodeAsset.getCouponCode(), 2523568, null);
        } else if (userPocketAssetModel instanceof UserPocketAssetModel.UserParkingTicketAsset) {
            UserPocketAssetModel.UserParkingTicketAsset userParkingTicketAsset = (UserPocketAssetModel.UserParkingTicketAsset) userPocketAssetModel;
            String enterTime2 = userParkingTicketAsset.getEnterTime();
            boolean z2 = false;
            if (enterTime2 != null && StringsKt.contains$default((CharSequence) enterTime2, (CharSequence) ".", false, 2, (Object) null)) {
                z2 = true;
            }
            if (z2) {
                String enterTime3 = userParkingTicketAsset.getEnterTime();
                if (enterTime3 != null) {
                    enterTime = StringsKt.substringBefore$default(enterTime3, ".", (String) null, 2, (Object) null);
                }
            } else {
                enterTime = userParkingTicketAsset.getEnterTime();
            }
            long PlaceComponentResult = DateTimeUtil.PlaceComponentResult(enterTime, "yyyy-MM-dd HH:mm:ss", Locale.getDefault());
            long currentTimeMillis = System.currentTimeMillis();
            String ticketId = userParkingTicketAsset.getTicketId();
            return new VoucherAndTicketCardModel.ParkingTicketCard(ticketId == null ? "" : ticketId, userPocketAssetModel.getPocketStatus(), userPocketAssetModel.getPocketType(), z, null, null, userParkingTicketAsset.getLocation(), userParkingTicketAsset.getMerchantName(), userParkingTicketAsset.getQrUrl(), PlaceComponentResult, currentTimeMillis - PlaceComponentResult, 0L, 2096, null);
        } else if (userPocketAssetModel instanceof UserPocketAssetModel.UserTravelTicketAsset) {
            String pocketId4 = userPocketAssetModel.getPocketId();
            String pocketStatus4 = userPocketAssetModel.getPocketStatus();
            String pocketType4 = userPocketAssetModel.getPocketType();
            UserPocketAssetModel.UserTravelTicketAsset userTravelTicketAsset = (UserPocketAssetModel.UserTravelTicketAsset) userPocketAssetModel;
            String passengerName = userTravelTicketAsset.getPassengerName();
            String passengerType = userTravelTicketAsset.getPassengerType();
            String subPocketType = userTravelTicketAsset.getSubPocketType();
            String departure = userTravelTicketAsset.getDeparture();
            String arrival = userTravelTicketAsset.getArrival();
            String transportLogoUrl = userTravelTicketAsset.getTransportLogoUrl();
            String departureTime = userTravelTicketAsset.getDepartureTime();
            String arrivalTime = userTravelTicketAsset.getArrivalTime();
            String bookingCode = userTravelTicketAsset.getBookingCode();
            String transportName = userTravelTicketAsset.getTransportName();
            Map<String, String> other = userTravelTicketAsset.getOther();
            String str = other != null ? other.get(TravelTicketStatus.DEPARTURE_CODE.getValue()) : null;
            Map<String, String> other2 = userTravelTicketAsset.getOther();
            String str2 = other2 != null ? other2.get(TravelTicketStatus.ARRIVAL_CODE.getValue()) : null;
            Map<String, String> other3 = userTravelTicketAsset.getOther();
            String str3 = other3 != null ? other3.get(TravelTicketStatus.DEPARTURE_AIRPORT.getValue()) : null;
            Map<String, String> other4 = userTravelTicketAsset.getOther();
            String str4 = other4 != null ? other4.get(TravelTicketStatus.ARRIVAL_AIRPORT.getValue()) : null;
            Map<String, String> other5 = userTravelTicketAsset.getOther();
            String str5 = other5 != null ? other5.get(TravelTicketStatus.DEPARTURE_TERMINAL.getValue()) : null;
            Map<String, String> other6 = userTravelTicketAsset.getOther();
            return new VoucherAndTicketCardModel.TravelTicketCard(pocketId4, pocketStatus4, pocketType4, z, passengerName, passengerType, subPocketType, departure, arrival, transportLogoUrl, departureTime, arrivalTime, bookingCode, transportName, userTravelTicketAsset.getSeatNumber(), str, str2, str3, str4, str5, other6 != null ? other6.get(TravelTicketStatus.ARRIVAL_TERMINAL.getValue()) : null, userTravelTicketAsset.getPrimaryCTA(), userTravelTicketAsset.getHexCode(), userPocketAssetModel.getBackgroundUrl(), userPocketAssetModel.getIconUrl(), userTravelTicketAsset.getGateNumber(), userTravelTicketAsset.getLogoUrl());
        } else if (userPocketAssetModel instanceof UserPocketAssetModel.UserMovieTicketAsset) {
            UserPocketAssetModel.UserMovieTicketAsset userMovieTicketAsset = (UserPocketAssetModel.UserMovieTicketAsset) userPocketAssetModel;
            return new VoucherAndTicketCardModel.MovieTicketCard(userPocketAssetModel.getPocketId(), userPocketAssetModel.getPocketStatus(), userPocketAssetModel.getPocketType(), z, userMovieTicketAsset.getPosterUrl(), userMovieTicketAsset.getLogoUrl(), userPocketAssetModel.getBackgroundUrl(), userMovieTicketAsset.getShowName(), userMovieTicketAsset.getLocationName(), userMovieTicketAsset.getTicketClass(), userMovieTicketAsset.getShowTime(), userMovieTicketAsset.getStudioNumber(), userMovieTicketAsset.getSeatNumber(), userMovieTicketAsset.getPrimaryCTA());
        } else {
            return new VoucherAndTicketCardModel.TravelTicketCard(userPocketAssetModel.getPocketId(), userPocketAssetModel.getPocketStatus(), userPocketAssetModel.getPocketType(), false, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, 134217712, null);
        }
    }

    public static final LoyaltyCardModel toLoyaltyCardModel(UserPocketAssetModel userPocketAssetModel, boolean z) {
        Intrinsics.checkNotNullParameter(userPocketAssetModel, "");
        if (userPocketAssetModel instanceof UserPocketAssetModel.UserLoyaltyAsset) {
            String pocketId = userPocketAssetModel.getPocketId();
            String pocketStatus = userPocketAssetModel.getPocketStatus();
            String pocketType = userPocketAssetModel.getPocketType();
            String backgroundUrl = userPocketAssetModel.getBackgroundUrl();
            UserPocketAssetModel.UserLoyaltyAsset userLoyaltyAsset = (UserPocketAssetModel.UserLoyaltyAsset) userPocketAssetModel;
            String createdDate = userLoyaltyAsset.getCreatedDate();
            String point = userLoyaltyAsset.getPoint();
            String merchantName = userLoyaltyAsset.getMerchantName();
            String cardNumber = userLoyaltyAsset.getCardNumber();
            String iconUrl = userPocketAssetModel.getIconUrl();
            String logoUrl = userLoyaltyAsset.getLogoUrl();
            String merchantId = userLoyaltyAsset.getMerchantId();
            List<AssetCategory> categories = userLoyaltyAsset.getCategories();
            ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(categories, 10));
            Iterator<T> it = categories.iterator();
            while (it.hasNext()) {
                arrayList.add(toAssetCategoryModel((AssetCategory) it.next()));
            }
            return new LoyaltyCardModel.LoyaltyCard(pocketId, pocketStatus, pocketType, z, 0, backgroundUrl, createdDate, point, merchantName, cardNumber, iconUrl, logoUrl, merchantId, arrayList, null, 16400, null);
        }
        return new LoyaltyCardModel.LoyaltyCard("", "", "", false, 0, null, null, null, null, null, null, null, null, null, null, 32752, null);
    }

    private static final AssetCategoryModel toAssetCategoryModel(AssetCategory assetCategory) {
        return new AssetCategoryModel(assetCategory.getCategory(), assetCategory.getOrder());
    }
}
