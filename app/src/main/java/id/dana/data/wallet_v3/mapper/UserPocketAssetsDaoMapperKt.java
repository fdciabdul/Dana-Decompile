package id.dana.data.wallet_v3.mapper;

import id.dana.data.pocket.model.AssetType;
import id.dana.data.pocket.model.ShareableRpcInfoEntity;
import id.dana.data.wallet_v3.model.UserPocketAssetEntity;
import id.dana.data.wallet_v3.repository.source.persistence.entity.UserPocketAssetsDaoEntity;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\u001a\u0015\u0010\u0002\u001a\u0004\u0018\u00010\u0001*\u00020\u0000H\u0002¢\u0006\u0004\b\u0002\u0010\u0003\u001a\u001d\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00000\u0004*\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\u0004\b\u0006\u0010\u0007\u001a\u001d\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004*\b\u0012\u0004\u0012\u00020\u00000\u0004¢\u0006\u0004\b\b\u0010\u0007\u001a\u0011\u0010\t\u001a\u00020\u0005*\u00020\u0000¢\u0006\u0004\b\t\u0010\n\u001a\u0011\u0010\t\u001a\u00020\u0000*\u00020\u0005¢\u0006\u0004\b\t\u0010\u000b"}, d2 = {"Lid/dana/data/wallet_v3/model/UserPocketAssetEntity;", "", "generateLabel", "(Lid/dana/data/wallet_v3/model/UserPocketAssetEntity;)Ljava/lang/String;", "", "Lid/dana/data/wallet_v3/repository/source/persistence/entity/UserPocketAssetsDaoEntity;", "toUserPocketAssetEntityList", "(Ljava/util/List;)Ljava/util/List;", "toUserPocketAssetsDaoEntities", "toUserPocketAssetsDaoEntity", "(Lid/dana/data/wallet_v3/model/UserPocketAssetEntity;)Lid/dana/data/wallet_v3/repository/source/persistence/entity/UserPocketAssetsDaoEntity;", "(Lid/dana/data/wallet_v3/repository/source/persistence/entity/UserPocketAssetsDaoEntity;)Lid/dana/data/wallet_v3/model/UserPocketAssetEntity;"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class UserPocketAssetsDaoMapperKt {
    public static final List<UserPocketAssetEntity> toUserPocketAssetEntityList(List<UserPocketAssetsDaoEntity> list) {
        Intrinsics.checkNotNullParameter(list, "");
        List<UserPocketAssetsDaoEntity> list2 = list;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list2, 10));
        Iterator<T> it = list2.iterator();
        while (it.hasNext()) {
            arrayList.add(toUserPocketAssetsDaoEntity((UserPocketAssetsDaoEntity) it.next()));
        }
        return arrayList;
    }

    public static final UserPocketAssetEntity toUserPocketAssetsDaoEntity(UserPocketAssetsDaoEntity userPocketAssetsDaoEntity) {
        Intrinsics.checkNotNullParameter(userPocketAssetsDaoEntity, "");
        String pocketId = userPocketAssetsDaoEntity.getPocketId();
        String pocketStatus = userPocketAssetsDaoEntity.getPocketStatus();
        String iconUrl = userPocketAssetsDaoEntity.getIconUrl();
        String backgroundUrl = userPocketAssetsDaoEntity.getBackgroundUrl();
        String pocketType = userPocketAssetsDaoEntity.getPocketType();
        String userPocketStatus = userPocketAssetsDaoEntity.getUserPocketStatus();
        Long activateDate = userPocketAssetsDaoEntity.getActivateDate();
        String howTo = userPocketAssetsDaoEntity.getHowTo();
        String merchantId = userPocketAssetsDaoEntity.getMerchantId();
        String label = userPocketAssetsDaoEntity.getLabel();
        String subLabel = userPocketAssetsDaoEntity.getSubLabel();
        String logoUrl = userPocketAssetsDaoEntity.getLogoUrl();
        Boolean usable = userPocketAssetsDaoEntity.getUsable();
        Boolean shareable = userPocketAssetsDaoEntity.getShareable();
        String goodsId = userPocketAssetsDaoEntity.getGoodsId();
        String tcUrl = userPocketAssetsDaoEntity.getTcUrl();
        Long expirationDate = userPocketAssetsDaoEntity.getExpirationDate();
        String createdDate = userPocketAssetsDaoEntity.getCreatedDate();
        String shareableRpcInfoReceiverInfo = userPocketAssetsDaoEntity.getShareableRpcInfoReceiverInfo();
        if (shareableRpcInfoReceiverInfo == null) {
            shareableRpcInfoReceiverInfo = "";
        }
        String shareableRpcInfoReceiverUserId = userPocketAssetsDaoEntity.getShareableRpcInfoReceiverUserId();
        String str = shareableRpcInfoReceiverUserId != null ? shareableRpcInfoReceiverUserId : "";
        Long shareableRpcInfoSharedDate = userPocketAssetsDaoEntity.getShareableRpcInfoSharedDate();
        return new UserPocketAssetEntity(pocketId, pocketStatus, iconUrl, backgroundUrl, pocketType, userPocketStatus, activateDate, howTo, merchantId, label, subLabel, logoUrl, usable, shareable, goodsId, tcUrl, expirationDate, createdDate, new ShareableRpcInfoEntity(shareableRpcInfoReceiverInfo, str, shareableRpcInfoSharedDate != null ? shareableRpcInfoSharedDate.longValue() : 0L), userPocketAssetsDaoEntity.getExtendInfo(), userPocketAssetsDaoEntity.getPrimaryCTA(), userPocketAssetsDaoEntity.getBackgroundColor(), userPocketAssetsDaoEntity.getFontColor(), userPocketAssetsDaoEntity.getMinTransaction(), userPocketAssetsDaoEntity.getCategoryIconUrl(), userPocketAssetsDaoEntity.getBizInfo(), userPocketAssetsDaoEntity.getCacheTimestamp());
    }

    public static final List<UserPocketAssetsDaoEntity> toUserPocketAssetsDaoEntities(List<UserPocketAssetEntity> list) {
        Intrinsics.checkNotNullParameter(list, "");
        List<UserPocketAssetEntity> list2 = list;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list2, 10));
        Iterator<T> it = list2.iterator();
        while (it.hasNext()) {
            arrayList.add(toUserPocketAssetsDaoEntity((UserPocketAssetEntity) it.next()));
        }
        return arrayList;
    }

    public static final UserPocketAssetsDaoEntity toUserPocketAssetsDaoEntity(UserPocketAssetEntity userPocketAssetEntity) {
        Intrinsics.checkNotNullParameter(userPocketAssetEntity, "");
        String pocketId = userPocketAssetEntity.getPocketId();
        String pocketStatus = userPocketAssetEntity.getPocketStatus();
        String iconUrl = userPocketAssetEntity.getIconUrl();
        String backgroundUrl = userPocketAssetEntity.getBackgroundUrl();
        String pocketType = userPocketAssetEntity.getPocketType();
        String userPocketStatus = userPocketAssetEntity.getUserPocketStatus();
        Long activateDate = userPocketAssetEntity.getActivateDate();
        String howTo = userPocketAssetEntity.getHowTo();
        String merchantId = userPocketAssetEntity.getMerchantId();
        String generateLabel = generateLabel(userPocketAssetEntity);
        String subLabel = userPocketAssetEntity.getSubLabel();
        String logoUrl = userPocketAssetEntity.getLogoUrl();
        Boolean usable = userPocketAssetEntity.getUsable();
        Boolean shareable = userPocketAssetEntity.getShareable();
        String goodsId = userPocketAssetEntity.getGoodsId();
        String tcUrl = userPocketAssetEntity.getTcUrl();
        Long expirationDate = userPocketAssetEntity.getExpirationDate();
        String createdDate = userPocketAssetEntity.getCreatedDate();
        ShareableRpcInfoEntity shareableRpcInfo = userPocketAssetEntity.getShareableRpcInfo();
        String receiverInfo = shareableRpcInfo != null ? shareableRpcInfo.getReceiverInfo() : null;
        ShareableRpcInfoEntity shareableRpcInfo2 = userPocketAssetEntity.getShareableRpcInfo();
        String receiverUserId = shareableRpcInfo2 != null ? shareableRpcInfo2.getReceiverUserId() : null;
        ShareableRpcInfoEntity shareableRpcInfo3 = userPocketAssetEntity.getShareableRpcInfo();
        return new UserPocketAssetsDaoEntity(pocketId, pocketStatus, iconUrl, backgroundUrl, pocketType, userPocketStatus, activateDate, howTo, merchantId, generateLabel, subLabel, logoUrl, usable, shareable, goodsId, tcUrl, expirationDate, createdDate, receiverInfo, receiverUserId, shareableRpcInfo3 != null ? Long.valueOf(shareableRpcInfo3.getSharedDate()) : null, userPocketAssetEntity.getExtInfo(), userPocketAssetEntity.getPrimaryCTA(), userPocketAssetEntity.getBackgroundColor(), userPocketAssetEntity.getFontColor(), userPocketAssetEntity.getMinTransaction(), userPocketAssetEntity.getCategoryIconUrl(), userPocketAssetEntity.getBizInfo(), userPocketAssetEntity.getCacheTimestamp());
    }

    private static final String generateLabel(UserPocketAssetEntity userPocketAssetEntity) {
        Object obj;
        String pocketType = userPocketAssetEntity.getPocketType();
        if (Intrinsics.areEqual(pocketType, AssetType.LOYALTY.getValue())) {
            Map<String, Object> extInfo = userPocketAssetEntity.getExtInfo();
            obj = extInfo != null ? extInfo.get("MERCHANT_NAME") : null;
            if (obj != null) {
                return (String) obj;
            }
            throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
        } else if (Intrinsics.areEqual(pocketType, AssetType.TICKET.getValue())) {
            Map<String, Object> extInfo2 = userPocketAssetEntity.getExtInfo();
            obj = extInfo2 != null ? extInfo2.get("SHOW_NAME") : null;
            if (obj != null) {
                return (String) obj;
            }
            throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
        } else {
            return userPocketAssetEntity.getLabel();
        }
    }
}
