package id.dana.data.wallet_v3.mapper;

import id.dana.data.pocket.mapper.ShareableRpcInfoMapperKt;
import id.dana.data.pocket.model.ShareableRpcInfoEntity;
import id.dana.data.wallet_v3.model.UserPocketAssetEntity;
import id.dana.data.wallet_v3.model.UserPocketAssetResult;
import id.dana.domain.pocket.model.AssetCategory;
import id.dana.domain.pocket.model.ShareableRpcInfo;
import id.dana.domain.wallet_v3.model.AssetType;
import id.dana.domain.wallet_v3.model.UserPocketAssetListModel;
import id.dana.domain.wallet_v3.model.UserPocketAssetModel;
import id.dana.mybills.ui.constant.FormValidatorKey;
import id.dana.nearbyme.NearbyMePromoType;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;
import org.json.JSONArray;

@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u001a\u001d\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\u0002¢\u0006\u0004\b\u0004\u0010\u0005\u001a'\u0010\t\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006\u0018\u00010\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0002¢\u0006\u0004\b\t\u0010\n\u001a#\u0010\u000e\u001a\u00020\r*\u00020\u00002\u0006\u0010\u000b\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u000e\u0010\u000f\u001a\u0013\u0010\u0010\u001a\u00020\r*\u00020\u0000H\u0002¢\u0006\u0004\b\u0010\u0010\u0011\u001a)\u0010\u0014\u001a\u00020\r*\u00020\u00002\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u000b\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\u0006¢\u0006\u0004\b\u0014\u0010\u0015\u001a1\u0010\u001b\u001a\b\u0012\u0004\u0012\u00028\u00000\u001a\"\u0004\b\u0000\u0010\u0016*\u00020\u00172\u0012\u0010\u0019\u001a\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00028\u00000\u0018¢\u0006\u0004\b\u001b\u0010\u001c\u001a\u0011\u0010\u001d\u001a\u00020\r*\u00020\u0000¢\u0006\u0004\b\u001d\u0010\u0011\u001a)\u0010\u001f\u001a\u00020\r*\u00020\u00002\u0006\u0010\u001e\u001a\u00020\u00122\u0006\u0010\u000b\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\u0006¢\u0006\u0004\b\u001f\u0010\u0015"}, d2 = {"Lid/dana/data/wallet_v3/model/UserPocketAssetEntity;", "asset", "", "Lid/dana/domain/pocket/model/AssetCategory;", "convertToCategory", "(Lid/dana/data/wallet_v3/model/UserPocketAssetEntity;)Ljava/util/List;", "", "data", "", "convertToKeyValueData", "(Ljava/lang/String;)Ljava/util/Map;", "defaultBackgroundColor", "defaultFontColor", "Lid/dana/domain/wallet_v3/model/UserPocketAssetModel;", "mapModelToDealsAsset", "(Lid/dana/data/wallet_v3/model/UserPocketAssetEntity;Ljava/lang/String;Ljava/lang/String;)Lid/dana/domain/wallet_v3/model/UserPocketAssetModel;", "mapModelToVoucherAsset", "(Lid/dana/data/wallet_v3/model/UserPocketAssetEntity;)Lid/dana/domain/wallet_v3/model/UserPocketAssetModel;", "", "discountCouponVersion", "toUserPocketAssetDiscountVoucherModel", "(Lid/dana/data/wallet_v3/model/UserPocketAssetEntity;ILjava/lang/String;Ljava/lang/String;)Lid/dana/domain/wallet_v3/model/UserPocketAssetModel;", "R", "Lid/dana/data/wallet_v3/model/UserPocketAssetResult;", "Lkotlin/Function1;", "mapper", "Lid/dana/domain/wallet_v3/model/UserPocketAssetListModel;", "toUserPocketAssetListModel", "(Lid/dana/data/wallet_v3/model/UserPocketAssetResult;Lkotlin/jvm/functions/Function1;)Lid/dana/domain/wallet_v3/model/UserPocketAssetListModel;", "toUserPocketAssetModel", "danaDealsVersion", "toUserPocketAssetVoucherModel"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class UserPocketAssetListMapperKt {
    /* JADX WARN: Multi-variable type inference failed */
    public static final <R> UserPocketAssetListModel<R> toUserPocketAssetListModel(UserPocketAssetResult userPocketAssetResult, Function1<? super UserPocketAssetEntity, ? extends R> function1) {
        Intrinsics.checkNotNullParameter(userPocketAssetResult, "");
        Intrinsics.checkNotNullParameter(function1, "");
        boolean hasMore = userPocketAssetResult.getHasMore();
        List<UserPocketAssetEntity> pockets = userPocketAssetResult.getPockets();
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(pockets, 10));
        Iterator<T> it = pockets.iterator();
        while (it.hasNext()) {
            arrayList.add(function1.invoke(it.next()));
        }
        return new UserPocketAssetListModel<>(hasMore, arrayList, userPocketAssetResult.getTotalCount());
    }

    /* JADX WARN: Code restructure failed: missing block: B:38:0x0085, code lost:
    
        if ((r1 == null || r1.length() == 0) == false) goto L39;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final id.dana.domain.wallet_v3.model.UserPocketAssetModel toUserPocketAssetVoucherModel(id.dana.data.wallet_v3.model.UserPocketAssetEntity r33, int r34, java.lang.String r35, java.lang.String r36) {
        /*
            Method dump skipped, instructions count: 396
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.data.wallet_v3.mapper.UserPocketAssetListMapperKt.toUserPocketAssetVoucherModel(id.dana.data.wallet_v3.model.UserPocketAssetEntity, int, java.lang.String, java.lang.String):id.dana.domain.wallet_v3.model.UserPocketAssetModel");
    }

    public static final UserPocketAssetModel toUserPocketAssetDiscountVoucherModel(UserPocketAssetEntity userPocketAssetEntity, int i, String str, String str2) {
        Intrinsics.checkNotNullParameter(userPocketAssetEntity, "");
        Intrinsics.checkNotNullParameter(str, "");
        Intrinsics.checkNotNullParameter(str2, "");
        if (i == 2) {
            return mapModelToDealsAsset(userPocketAssetEntity, str, str2);
        }
        return mapModelToVoucherAsset(userPocketAssetEntity);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r37v0, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r8v1 */
    /* JADX WARN: Type inference failed for: r8v13 */
    public static final UserPocketAssetModel toUserPocketAssetModel(UserPocketAssetEntity userPocketAssetEntity) {
        Intrinsics.checkNotNullParameter(userPocketAssetEntity, "");
        String pocketType = userPocketAssetEntity.getPocketType();
        if (Intrinsics.areEqual(pocketType, AssetType.TRAVEL_TICKET.getAsset())) {
            String backgroundUrl = userPocketAssetEntity.getBackgroundUrl();
            String createdDate = userPocketAssetEntity.getCreatedDate();
            String iconUrl = userPocketAssetEntity.getIconUrl();
            String logoUrl = userPocketAssetEntity.getLogoUrl();
            String pocketId = userPocketAssetEntity.getPocketId();
            String pocketStatus = userPocketAssetEntity.getPocketStatus();
            String pocketType2 = userPocketAssetEntity.getPocketType();
            Map<String, Object> extInfo = userPocketAssetEntity.getExtInfo();
            Object obj = extInfo != null ? extInfo.get(FormValidatorKey.CUSTOMER_NAME) : null;
            String str = obj instanceof String ? (String) obj : null;
            Map<String, Object> extInfo2 = userPocketAssetEntity.getExtInfo();
            Object obj2 = extInfo2 != null ? extInfo2.get("TICKET_CLASS") : null;
            String str2 = obj2 instanceof String ? (String) obj2 : null;
            Map<String, Object> extInfo3 = userPocketAssetEntity.getExtInfo();
            Object obj3 = extInfo3 != null ? extInfo3.get("BIZ_TYPE") : null;
            String str3 = obj3 instanceof String ? (String) obj3 : null;
            Map<String, Object> extInfo4 = userPocketAssetEntity.getExtInfo();
            Object obj4 = extInfo4 != null ? extInfo4.get("TICKET_NAME") : null;
            String str4 = obj4 instanceof String ? (String) obj4 : null;
            Map<String, Object> extInfo5 = userPocketAssetEntity.getExtInfo();
            Object obj5 = extInfo5 != null ? extInfo5.get("DEPARTURE") : null;
            String str5 = obj5 instanceof String ? (String) obj5 : null;
            Map<String, Object> extInfo6 = userPocketAssetEntity.getExtInfo();
            Object obj6 = extInfo6 != null ? extInfo6.get("DESTINATION") : null;
            String str6 = obj6 instanceof String ? (String) obj6 : null;
            Map<String, Object> extInfo7 = userPocketAssetEntity.getExtInfo();
            Object obj7 = extInfo7 != null ? extInfo7.get("TRANSPORT_LOGO_URL") : null;
            String str7 = obj7 instanceof String ? (String) obj7 : null;
            Map<String, Object> extInfo8 = userPocketAssetEntity.getExtInfo();
            Object obj8 = extInfo8 != null ? extInfo8.get("DEPARTURE_TIME") : null;
            String str8 = obj8 instanceof String ? (String) obj8 : null;
            Map<String, Object> extInfo9 = userPocketAssetEntity.getExtInfo();
            Object obj9 = extInfo9 != null ? extInfo9.get("ARRIVAL_TIME") : null;
            String str9 = obj9 instanceof String ? (String) obj9 : null;
            Map<String, Object> extInfo10 = userPocketAssetEntity.getExtInfo();
            Object obj10 = extInfo10 != null ? extInfo10.get("NOTES") : null;
            String str10 = obj10 instanceof String ? (String) obj10 : null;
            Map<String, Object> extInfo11 = userPocketAssetEntity.getExtInfo();
            Object obj11 = extInfo11 != null ? extInfo11.get("BOOKING_CODE") : null;
            String str11 = obj11 instanceof String ? (String) obj11 : null;
            Map<String, Object> extInfo12 = userPocketAssetEntity.getExtInfo();
            Object obj12 = extInfo12 != null ? extInfo12.get("SEAT_NUMBER") : null;
            String str12 = obj12 instanceof String ? (String) obj12 : null;
            Map<String, Object> extInfo13 = userPocketAssetEntity.getExtInfo();
            Object obj13 = extInfo13 != null ? extInfo13.get("TRANSPORT_NAME") : null;
            String str13 = obj13 instanceof String ? (String) obj13 : null;
            Map<String, Object> extInfo14 = userPocketAssetEntity.getExtInfo();
            Object obj14 = extInfo14 != null ? extInfo14.get("OTHER") : null;
            Map<String, String> convertToKeyValueData = convertToKeyValueData(obj14 instanceof String ? (String) obj14 : null);
            Map<String, Object> extInfo15 = userPocketAssetEntity.getExtInfo();
            Object obj15 = extInfo15 != null ? extInfo15.get("HEX_CODE") : null;
            String str14 = obj15 instanceof String ? (String) obj15 : null;
            String primaryCTA = userPocketAssetEntity.getPrimaryCTA();
            Map<String, Object> extInfo16 = userPocketAssetEntity.getExtInfo();
            Object obj16 = extInfo16 != null ? extInfo16.get("GATE_NUMBER") : null;
            ?? r37 = obj16 instanceof String ? (String) obj16 : 0;
            Long cacheTimestamp = userPocketAssetEntity.getCacheTimestamp();
            return new UserPocketAssetModel.UserTravelTicketAsset(pocketId, pocketStatus, iconUrl, backgroundUrl, pocketType2, cacheTimestamp != null ? cacheTimestamp.longValue() : -1L, createdDate, logoUrl, str, str2, str3, str4, str5, str6, str7, str8, str9, str10, convertToKeyValueData, str11, str12, str13, str14, primaryCTA, r37);
        } else if (Intrinsics.areEqual(pocketType, AssetType.PARKING.getAsset())) {
            String backgroundUrl2 = userPocketAssetEntity.getBackgroundUrl();
            String createdDate2 = userPocketAssetEntity.getCreatedDate();
            String iconUrl2 = userPocketAssetEntity.getIconUrl();
            String logoUrl2 = userPocketAssetEntity.getLogoUrl();
            String pocketId2 = userPocketAssetEntity.getPocketId();
            String pocketStatus2 = userPocketAssetEntity.getPocketStatus();
            String pocketType3 = userPocketAssetEntity.getPocketType();
            Map<String, Object> extInfo17 = userPocketAssetEntity.getExtInfo();
            Object obj17 = extInfo17 != null ? extInfo17.get("TICKET_ID") : null;
            String str15 = obj17 instanceof String ? (String) obj17 : null;
            Map<String, Object> extInfo18 = userPocketAssetEntity.getExtInfo();
            Object obj18 = extInfo18 != null ? extInfo18.get(NearbyMePromoType.LimitType.MERCHANT_ID) : null;
            String str16 = obj18 instanceof String ? (String) obj18 : null;
            Map<String, Object> extInfo19 = userPocketAssetEntity.getExtInfo();
            Object obj19 = extInfo19 != null ? extInfo19.get("LOCATION") : null;
            String str17 = obj19 instanceof String ? (String) obj19 : null;
            Map<String, Object> extInfo20 = userPocketAssetEntity.getExtInfo();
            Object obj20 = extInfo20 != null ? extInfo20.get("BENEFIT") : null;
            String str18 = obj20 instanceof String ? (String) obj20 : null;
            Map<String, Object> extInfo21 = userPocketAssetEntity.getExtInfo();
            Object obj21 = extInfo21 != null ? extInfo21.get("ENTER_TIME") : null;
            String str19 = obj21 instanceof String ? (String) obj21 : null;
            Map<String, Object> extInfo22 = userPocketAssetEntity.getExtInfo();
            Object obj22 = extInfo22 != null ? extInfo22.get("QR_URL") : null;
            String str20 = obj22 instanceof String ? (String) obj22 : null;
            Map<String, Object> extInfo23 = userPocketAssetEntity.getExtInfo();
            Object obj23 = extInfo23 != null ? extInfo23.get("MERCHANT_NAME") : null;
            String str21 = obj23 instanceof String ? (String) obj23 : null;
            Map<String, Object> extInfo24 = userPocketAssetEntity.getExtInfo();
            Object obj24 = extInfo24 != null ? extInfo24.get("OTHER") : null;
            Object obj25 = obj24 instanceof Map ? (Map) obj24 : 0;
            Long cacheTimestamp2 = userPocketAssetEntity.getCacheTimestamp();
            return new UserPocketAssetModel.UserParkingTicketAsset(pocketId2, pocketStatus2, iconUrl2, backgroundUrl2, pocketType3, cacheTimestamp2 != null ? cacheTimestamp2.longValue() : -1L, createdDate2, logoUrl2, str15, str16, str17, str18, str19, str20, str21, obj25);
        } else if (Intrinsics.areEqual(pocketType, AssetType.LOYALTY.getAsset())) {
            String pocketId3 = userPocketAssetEntity.getPocketId();
            String pocketStatus3 = userPocketAssetEntity.getPocketStatus();
            String userPocketStatus = userPocketAssetEntity.getUserPocketStatus();
            String str22 = userPocketStatus == null ? "" : userPocketStatus;
            String pocketType4 = userPocketAssetEntity.getPocketType();
            String merchantId = userPocketAssetEntity.getMerchantId();
            String str23 = merchantId == null ? "" : merchantId;
            String iconUrl3 = userPocketAssetEntity.getIconUrl();
            String backgroundUrl3 = userPocketAssetEntity.getBackgroundUrl();
            String createdDate3 = userPocketAssetEntity.getCreatedDate();
            Map<String, Object> extInfo25 = userPocketAssetEntity.getExtInfo();
            Object obj26 = extInfo25 != null ? extInfo25.get("POINT") : null;
            String str24 = obj26 instanceof String ? (String) obj26 : null;
            String str25 = str24 == null ? "" : str24;
            Map<String, Object> extInfo26 = userPocketAssetEntity.getExtInfo();
            Object obj27 = extInfo26 != null ? extInfo26.get("MERCHANT_NAME") : null;
            String str26 = obj27 instanceof String ? (String) obj27 : null;
            String str27 = str26 == null ? "" : str26;
            Map<String, Object> extInfo27 = userPocketAssetEntity.getExtInfo();
            Object obj28 = extInfo27 != null ? extInfo27.get("CARD_NUMBER") : null;
            Object obj29 = obj28 instanceof String ? (String) obj28 : 0;
            String str28 = obj29 == null ? "" : obj29;
            String logoUrl3 = userPocketAssetEntity.getLogoUrl();
            String str29 = logoUrl3 == null ? "" : logoUrl3;
            List<AssetCategory> convertToCategory = convertToCategory(userPocketAssetEntity);
            Long cacheTimestamp3 = userPocketAssetEntity.getCacheTimestamp();
            return new UserPocketAssetModel.UserLoyaltyAsset(pocketId3, pocketStatus3, iconUrl3, backgroundUrl3, pocketType4, cacheTimestamp3 != null ? cacheTimestamp3.longValue() : -1L, createdDate3, str25, str27, str28, str29, str23, convertToCategory, str22);
        } else if (Intrinsics.areEqual(pocketType, AssetType.TICKET.getAsset())) {
            String backgroundUrl4 = userPocketAssetEntity.getBackgroundUrl();
            String createdDate4 = userPocketAssetEntity.getCreatedDate();
            String iconUrl4 = userPocketAssetEntity.getIconUrl();
            String logoUrl4 = userPocketAssetEntity.getLogoUrl();
            String pocketId4 = userPocketAssetEntity.getPocketId();
            String pocketStatus4 = userPocketAssetEntity.getPocketStatus();
            String pocketType5 = userPocketAssetEntity.getPocketType();
            Long expirationDate = userPocketAssetEntity.getExpirationDate();
            Map<String, Object> extInfo28 = userPocketAssetEntity.getExtInfo();
            Object obj30 = extInfo28 != null ? extInfo28.get("LOCATION_NAME") : null;
            String str30 = obj30 instanceof String ? (String) obj30 : null;
            String str31 = str30 == null ? "" : str30;
            Map<String, Object> extInfo29 = userPocketAssetEntity.getExtInfo();
            Object obj31 = extInfo29 != null ? extInfo29.get("TICKET_CLASS") : null;
            String str32 = obj31 instanceof String ? (String) obj31 : null;
            String str33 = str32 == null ? "" : str32;
            Map<String, Object> extInfo30 = userPocketAssetEntity.getExtInfo();
            Object obj32 = extInfo30 != null ? extInfo30.get("SHOW_NAME") : null;
            String str34 = obj32 instanceof String ? (String) obj32 : null;
            String str35 = str34 == null ? "" : str34;
            Map<String, Object> extInfo31 = userPocketAssetEntity.getExtInfo();
            Object obj33 = extInfo31 != null ? extInfo31.get("SEAT_NUMBER") : null;
            String str36 = obj33 instanceof String ? (String) obj33 : null;
            String str37 = str36 == null ? "" : str36;
            Map<String, Object> extInfo32 = userPocketAssetEntity.getExtInfo();
            Object obj34 = extInfo32 != null ? extInfo32.get("SHOW_TIME") : null;
            String str38 = obj34 instanceof String ? (String) obj34 : null;
            String str39 = str38 == null ? "" : str38;
            Map<String, Object> extInfo33 = userPocketAssetEntity.getExtInfo();
            Object obj35 = extInfo33 != null ? extInfo33.get("STUDIO_NUMBER") : null;
            String str40 = obj35 instanceof String ? (String) obj35 : null;
            String str41 = str40 == null ? "" : str40;
            Map<String, Object> extInfo34 = userPocketAssetEntity.getExtInfo();
            Object obj36 = extInfo34 != null ? extInfo34.get("IMG_URL") : null;
            String str42 = obj36 instanceof String ? (String) obj36 : null;
            String str43 = str42 == null ? "" : str42;
            Map<String, Object> extInfo35 = userPocketAssetEntity.getExtInfo();
            Object obj37 = extInfo35 != null ? extInfo35.get("LOCATION_NAME") : null;
            String str44 = obj37 instanceof String ? (String) obj37 : null;
            String str45 = str44 == null ? "" : str44;
            Map<String, Object> extInfo36 = userPocketAssetEntity.getExtInfo();
            Object obj38 = extInfo36 != null ? extInfo36.get("BIZ_TYPE") : null;
            String str46 = obj38 instanceof String ? (String) obj38 : null;
            String str47 = str46 == null ? "" : str46;
            Map<String, Object> extInfo37 = userPocketAssetEntity.getExtInfo();
            Object obj39 = extInfo37 != null ? extInfo37.get("OTHER") : null;
            Map map = obj39 instanceof Map ? (Map) obj39 : 0;
            String primaryCTA2 = userPocketAssetEntity.getPrimaryCTA();
            Long cacheTimestamp4 = userPocketAssetEntity.getCacheTimestamp();
            return new UserPocketAssetModel.UserMovieTicketAsset(pocketId4, pocketStatus4, iconUrl4, backgroundUrl4, pocketType5, cacheTimestamp4 != null ? cacheTimestamp4.longValue() : -1L, createdDate4, expirationDate, str31, str33, str35, str37, str39, str41, str43, str45, str47, map, logoUrl4, primaryCTA2);
        } else {
            return mapModelToVoucherAsset(userPocketAssetEntity);
        }
    }

    private static final UserPocketAssetModel mapModelToDealsAsset(UserPocketAssetEntity userPocketAssetEntity, String str, String str2) {
        String fontColor = userPocketAssetEntity.getFontColor();
        boolean z = true;
        String fontColor2 = !(fontColor == null || fontColor.length() == 0) ? userPocketAssetEntity.getFontColor() : str2;
        String backgroundColor = userPocketAssetEntity.getBackgroundColor();
        if (backgroundColor != null && backgroundColor.length() != 0) {
            z = false;
        }
        String backgroundColor2 = z ? str : userPocketAssetEntity.getBackgroundColor();
        Long activateDate = userPocketAssetEntity.getActivateDate();
        long longValue = activateDate != null ? activateDate.longValue() : -1L;
        Map<String, Object> extInfo = userPocketAssetEntity.getExtInfo();
        Object obj = extInfo != null ? extInfo.get("amount") : null;
        String str3 = obj instanceof String ? (String) obj : null;
        String str4 = str3 == null ? "" : str3;
        Map<String, Object> extInfo2 = userPocketAssetEntity.getExtInfo();
        Object obj2 = extInfo2 != null ? extInfo2.get("SHORT_DESC") : null;
        String str5 = obj2 instanceof String ? (String) obj2 : null;
        String str6 = str5 == null ? "" : str5;
        Map<String, Object> extInfo3 = userPocketAssetEntity.getExtInfo();
        Object obj3 = extInfo3 != null ? extInfo3.get("templateId") : null;
        String str7 = obj3 instanceof String ? (String) obj3 : null;
        String str8 = str7 == null ? "" : str7;
        Map<String, Object> extInfo4 = userPocketAssetEntity.getExtInfo();
        Object obj4 = extInfo4 != null ? extInfo4.get("uniqueId") : null;
        String str9 = obj4 instanceof String ? (String) obj4 : null;
        String str10 = str9 == null ? "" : str9;
        String howTo = userPocketAssetEntity.getHowTo();
        String str11 = howTo == null ? "" : howTo;
        String pocketId = userPocketAssetEntity.getPocketId();
        String pocketStatus = userPocketAssetEntity.getPocketStatus();
        String userPocketStatus = userPocketAssetEntity.getUserPocketStatus();
        String str12 = userPocketStatus == null ? "" : userPocketStatus;
        String pocketType = userPocketAssetEntity.getPocketType();
        String str13 = pocketType == null ? "" : pocketType;
        String merchantId = userPocketAssetEntity.getMerchantId();
        String str14 = merchantId == null ? "" : merchantId;
        String label = userPocketAssetEntity.getLabel();
        String str15 = label == null ? "" : label;
        String subLabel = userPocketAssetEntity.getSubLabel();
        String str16 = subLabel == null ? "" : subLabel;
        String iconUrl = userPocketAssetEntity.getIconUrl();
        String logoUrl = userPocketAssetEntity.getLogoUrl();
        String str17 = logoUrl == null ? "" : logoUrl;
        String backgroundUrl = userPocketAssetEntity.getBackgroundUrl();
        Boolean usable = userPocketAssetEntity.getUsable();
        boolean booleanValue = usable != null ? usable.booleanValue() : false;
        Boolean shareable = userPocketAssetEntity.getShareable();
        boolean booleanValue2 = shareable != null ? shareable.booleanValue() : false;
        Long expirationDate = userPocketAssetEntity.getExpirationDate();
        long longValue2 = expirationDate != null ? expirationDate.longValue() : -1L;
        ShareableRpcInfoEntity shareableRpcInfo = userPocketAssetEntity.getShareableRpcInfo();
        ShareableRpcInfo shareableRpcInfo2 = shareableRpcInfo != null ? ShareableRpcInfoMapperKt.toShareableRpcInfo(shareableRpcInfo) : null;
        Map<String, Object> extInfo5 = userPocketAssetEntity.getExtInfo();
        Object obj5 = extInfo5 != null ? extInfo5.get("minTransaction") : null;
        String str18 = obj5 instanceof String ? (String) obj5 : null;
        String str19 = str18 == null ? "" : str18;
        String categoryIconUrl = userPocketAssetEntity.getCategoryIconUrl();
        String str20 = categoryIconUrl == null ? "" : categoryIconUrl;
        Map<String, Object> bizInfo = userPocketAssetEntity.getBizInfo();
        Object obj6 = bizInfo != null ? bizInfo.get("bizType") : null;
        String str21 = obj6 instanceof String ? (String) obj6 : null;
        String str22 = str21 == null ? "" : str21;
        Map<String, Object> bizInfo2 = userPocketAssetEntity.getBizInfo();
        Object obj7 = bizInfo2 != null ? bizInfo2.get("isOnlineMerchant") : null;
        Boolean bool = obj7 instanceof Boolean ? (Boolean) obj7 : null;
        boolean booleanValue3 = bool != null ? bool.booleanValue() : false;
        Map<String, Object> bizInfo3 = userPocketAssetEntity.getBizInfo();
        Object obj8 = bizInfo3 != null ? bizInfo3.get("redemptionType") : null;
        String str23 = obj8 instanceof String ? (String) obj8 : null;
        String str24 = str23 == null ? "" : str23;
        Map<String, Object> bizInfo4 = userPocketAssetEntity.getBizInfo();
        Object obj9 = bizInfo4 != null ? bizInfo4.get("providerCategory") : null;
        String str25 = obj9 instanceof String ? (String) obj9 : null;
        String str26 = str25 == null ? "" : str25;
        Long cacheTimestamp = userPocketAssetEntity.getCacheTimestamp();
        long longValue3 = cacheTimestamp != null ? cacheTimestamp.longValue() : -1L;
        Map<String, Object> extInfo6 = userPocketAssetEntity.getExtInfo();
        Object obj10 = extInfo6 != null ? extInfo6.get("discountRate") : null;
        String str27 = obj10 instanceof String ? (String) obj10 : null;
        return new UserPocketAssetModel.DealsAsset(pocketId, pocketStatus, iconUrl, backgroundUrl, str13, longValue3, longValue, str4, str6, str8, str10, str11, str12, str14, str15, str16, str17, booleanValue, booleanValue2, longValue2, backgroundColor2, fontColor2, str19, str20, str22, booleanValue3, str24, str26, str27 == null ? "" : str27, shareableRpcInfo2);
    }

    private static final UserPocketAssetModel mapModelToVoucherAsset(UserPocketAssetEntity userPocketAssetEntity) {
        Long activateDate = userPocketAssetEntity.getActivateDate();
        long longValue = activateDate != null ? activateDate.longValue() : -1L;
        Map<String, Object> extInfo = userPocketAssetEntity.getExtInfo();
        Object obj = extInfo != null ? extInfo.get("amount") : null;
        String str = obj instanceof String ? (String) obj : null;
        String str2 = str == null ? "" : str;
        Map<String, Object> extInfo2 = userPocketAssetEntity.getExtInfo();
        Object obj2 = extInfo2 != null ? extInfo2.get("SHORT_DESC") : null;
        String str3 = obj2 instanceof String ? (String) obj2 : null;
        String str4 = str3 == null ? "" : str3;
        Map<String, Object> extInfo3 = userPocketAssetEntity.getExtInfo();
        Object obj3 = extInfo3 != null ? extInfo3.get("templateId") : null;
        String str5 = obj3 instanceof String ? (String) obj3 : null;
        String str6 = str5 == null ? "" : str5;
        Map<String, Object> extInfo4 = userPocketAssetEntity.getExtInfo();
        Object obj4 = extInfo4 != null ? extInfo4.get("uniqueId") : null;
        String str7 = obj4 instanceof String ? (String) obj4 : null;
        String str8 = str7 == null ? "" : str7;
        String howTo = userPocketAssetEntity.getHowTo();
        String str9 = howTo == null ? "" : howTo;
        String pocketId = userPocketAssetEntity.getPocketId();
        String pocketStatus = userPocketAssetEntity.getPocketStatus();
        String userPocketStatus = userPocketAssetEntity.getUserPocketStatus();
        String str10 = userPocketStatus == null ? "" : userPocketStatus;
        String pocketType = userPocketAssetEntity.getPocketType();
        String str11 = pocketType == null ? "" : pocketType;
        String merchantId = userPocketAssetEntity.getMerchantId();
        String str12 = merchantId == null ? "" : merchantId;
        String label = userPocketAssetEntity.getLabel();
        String str13 = label == null ? "" : label;
        String subLabel = userPocketAssetEntity.getSubLabel();
        String str14 = subLabel == null ? "" : subLabel;
        String iconUrl = userPocketAssetEntity.getIconUrl();
        String logoUrl = userPocketAssetEntity.getLogoUrl();
        String str15 = logoUrl == null ? "" : logoUrl;
        String backgroundUrl = userPocketAssetEntity.getBackgroundUrl();
        Boolean usable = userPocketAssetEntity.getUsable();
        boolean booleanValue = usable != null ? usable.booleanValue() : false;
        Boolean shareable = userPocketAssetEntity.getShareable();
        boolean booleanValue2 = shareable != null ? shareable.booleanValue() : false;
        Long expirationDate = userPocketAssetEntity.getExpirationDate();
        long longValue2 = expirationDate != null ? expirationDate.longValue() : -1L;
        ShareableRpcInfoEntity shareableRpcInfo = userPocketAssetEntity.getShareableRpcInfo();
        ShareableRpcInfo shareableRpcInfo2 = shareableRpcInfo != null ? ShareableRpcInfoMapperKt.toShareableRpcInfo(shareableRpcInfo) : null;
        Long cacheTimestamp = userPocketAssetEntity.getCacheTimestamp();
        return new UserPocketAssetModel.UserVoucherAsset(pocketId, pocketStatus, iconUrl, backgroundUrl, str11, cacheTimestamp != null ? cacheTimestamp.longValue() : -1L, longValue, str2, str4, str6, str8, str9, str10, str12, str13, str14, str15, booleanValue, booleanValue2, longValue2, shareableRpcInfo2);
    }

    private static final List<AssetCategory> convertToCategory(UserPocketAssetEntity userPocketAssetEntity) {
        Object obj;
        try {
            Map<String, Object> extInfo = userPocketAssetEntity.getExtInfo();
            if (extInfo == null || (obj = extInfo.get("CATEGORIES")) == null) {
                obj = "[]";
            }
            JSONArray jSONArray = new JSONArray(obj);
            ArrayList arrayList = new ArrayList();
            int length = jSONArray.length();
            for (int i = 0; i < length; i++) {
                String string = jSONArray.getJSONObject(i).getString("category");
                Intrinsics.checkNotNullExpressionValue(string, "");
                arrayList.add(new AssetCategory(string, jSONArray.getJSONObject(i).getInt("order")));
            }
            return arrayList;
        } catch (Exception unused) {
            return CollectionsKt.emptyList();
        }
    }

    private static final Map<String, String> convertToKeyValueData(String str) {
        if (str != null) {
            String substring = str.substring(1, str.length() - 1);
            Intrinsics.checkNotNullExpressionValue(substring, "");
            List split$default = StringsKt.split$default((CharSequence) StringsKt.replace$default(substring, "\"", "", false, 4, (Object) null), new String[]{","}, false, 0, 6, (Object) null);
            ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(split$default, 10));
            Iterator it = split$default.iterator();
            while (it.hasNext()) {
                arrayList.add(StringsKt.split$default((CharSequence) ((String) it.next()), new String[]{":"}, false, 0, 6, (Object) null));
            }
            ArrayList<List> arrayList2 = arrayList;
            LinkedHashMap linkedHashMap = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(arrayList2, 10)), 16));
            for (List list : arrayList2) {
                Pair pair = TuplesKt.to(CollectionsKt.first(list), CollectionsKt.last(list));
                linkedHashMap.put(pair.getFirst(), pair.getSecond());
            }
            return linkedHashMap;
        }
        return null;
    }
}
