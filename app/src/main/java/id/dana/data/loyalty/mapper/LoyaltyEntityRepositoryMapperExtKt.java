package id.dana.data.loyalty.mapper;

import id.dana.data.loyalty.repository.source.local.entity.LoyaltyReceiptEntity;
import id.dana.data.loyalty.repository.source.network.request.SubmitReceiptRequest;
import id.dana.data.loyalty.repository.source.network.response.SubmitReceiptResponse;
import id.dana.domain.loyalty.model.Base64ReceiptLoyalty;
import id.dana.domain.loyalty.model.FileOcrReceiptLoyalty;
import id.dana.domain.loyalty.model.SubmitReceiptResult;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0013\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u0000¢\u0006\u0004\b\u0002\u0010\u0003\u001a\u0013\u0010\u0004\u001a\u00020\u0000*\u00020\u0001H\u0000¢\u0006\u0004\b\u0004\u0010\u0005\u001a\u0013\u0010\b\u001a\u00020\u0007*\u00020\u0006H\u0000¢\u0006\u0004\b\b\u0010\t\u001a\u0013\u0010\f\u001a\u00020\u000b*\u00020\nH\u0000¢\u0006\u0004\b\f\u0010\r"}, d2 = {"Lid/dana/domain/loyalty/model/FileOcrReceiptLoyalty;", "Lid/dana/data/loyalty/repository/source/local/entity/LoyaltyReceiptEntity;", "toLoyaltyReceiptEntity", "(Lid/dana/domain/loyalty/model/FileOcrReceiptLoyalty;)Lid/dana/data/loyalty/repository/source/local/entity/LoyaltyReceiptEntity;", "toOcrReceiptLoyalty", "(Lid/dana/data/loyalty/repository/source/local/entity/LoyaltyReceiptEntity;)Lid/dana/domain/loyalty/model/FileOcrReceiptLoyalty;", "Lid/dana/domain/loyalty/model/Base64ReceiptLoyalty;", "Lid/dana/data/loyalty/repository/source/network/request/SubmitReceiptRequest;", "toSubmitReceiptRequest", "(Lid/dana/domain/loyalty/model/Base64ReceiptLoyalty;)Lid/dana/data/loyalty/repository/source/network/request/SubmitReceiptRequest;", "Lid/dana/data/loyalty/repository/source/network/response/SubmitReceiptResponse;", "Lid/dana/domain/loyalty/model/SubmitReceiptResult;", "toSubmitReceiptResult", "(Lid/dana/data/loyalty/repository/source/network/response/SubmitReceiptResponse;)Lid/dana/domain/loyalty/model/SubmitReceiptResult;"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes8.dex */
public final class LoyaltyEntityRepositoryMapperExtKt {
    public static final SubmitReceiptResult toSubmitReceiptResult(SubmitReceiptResponse submitReceiptResponse) {
        Intrinsics.checkNotNullParameter(submitReceiptResponse, "");
        String id2 = submitReceiptResponse.getId();
        String createdDate = submitReceiptResponse.getCreatedDate();
        String modifiedDate = submitReceiptResponse.getModifiedDate();
        String orderId = submitReceiptResponse.getOrderId();
        if (orderId == null) {
            orderId = "";
        }
        String merchantId = submitReceiptResponse.getMerchantId();
        if (merchantId == null) {
            merchantId = "";
        }
        String merchantName = submitReceiptResponse.getMerchantName();
        if (merchantName == null) {
            merchantName = "";
        }
        String loyaltyMerchantName = submitReceiptResponse.getLoyaltyMerchantName();
        if (loyaltyMerchantName == null) {
            loyaltyMerchantName = "";
        }
        String originalMerchantName = submitReceiptResponse.getOriginalMerchantName();
        if (originalMerchantName == null) {
            originalMerchantName = "";
        }
        String orderDate = submitReceiptResponse.getOrderDate();
        if (orderDate == null) {
            orderDate = "";
        }
        String orderAmount = submitReceiptResponse.getOrderAmount();
        if (orderAmount == null) {
            orderAmount = "";
        }
        String imageAssetUrl = submitReceiptResponse.getImageAssetUrl();
        if (imageAssetUrl == null) {
            imageAssetUrl = "";
        }
        String userLoyaltyId = submitReceiptResponse.getUserLoyaltyId();
        if (userLoyaltyId == null) {
            userLoyaltyId = "";
        }
        String receiptStatus = submitReceiptResponse.getReceiptStatus();
        if (receiptStatus == null) {
            receiptStatus = "";
        }
        String receiptResultType = submitReceiptResponse.getReceiptResultType();
        if (receiptResultType == null) {
            receiptResultType = "";
        }
        String receiptApprovalStatus = submitReceiptResponse.getReceiptApprovalStatus();
        if (receiptApprovalStatus == null) {
            receiptApprovalStatus = "";
        }
        String pointGenerated = submitReceiptResponse.getPointGenerated();
        if (pointGenerated == null) {
            pointGenerated = "";
        }
        String reasonId = submitReceiptResponse.getReasonId();
        if (reasonId == null) {
            reasonId = "";
        }
        String reasonEn = submitReceiptResponse.getReasonEn();
        return new SubmitReceiptResult(id2, createdDate, modifiedDate, orderId, merchantId, merchantName, loyaltyMerchantName, originalMerchantName, orderDate, orderAmount, imageAssetUrl, userLoyaltyId, receiptStatus, receiptResultType, receiptApprovalStatus, pointGenerated, reasonId, reasonEn == null ? "" : reasonEn);
    }

    public static final FileOcrReceiptLoyalty toOcrReceiptLoyalty(LoyaltyReceiptEntity loyaltyReceiptEntity) {
        Intrinsics.checkNotNullParameter(loyaltyReceiptEntity, "");
        return new FileOcrReceiptLoyalty(loyaltyReceiptEntity.getOrderId(), loyaltyReceiptEntity.getMerchantName(), loyaltyReceiptEntity.getOrderAmount(), loyaltyReceiptEntity.getTimestamp(), loyaltyReceiptEntity.getRawText(), loyaltyReceiptEntity.getMerchantId(), loyaltyReceiptEntity.getUserLoyaltyId(), loyaltyReceiptEntity.getFilePath());
    }

    public static final LoyaltyReceiptEntity toLoyaltyReceiptEntity(FileOcrReceiptLoyalty fileOcrReceiptLoyalty) {
        Intrinsics.checkNotNullParameter(fileOcrReceiptLoyalty, "");
        return new LoyaltyReceiptEntity(fileOcrReceiptLoyalty.getUserLoyaltyId(), fileOcrReceiptLoyalty.getMerchantId(), fileOcrReceiptLoyalty.getOrderId(), fileOcrReceiptLoyalty.getMerchantName(), fileOcrReceiptLoyalty.getOrderAmount(), fileOcrReceiptLoyalty.getTimestamp(), fileOcrReceiptLoyalty.getFilePath(), fileOcrReceiptLoyalty.getRawText());
    }

    public static final SubmitReceiptRequest toSubmitReceiptRequest(Base64ReceiptLoyalty base64ReceiptLoyalty) {
        Intrinsics.checkNotNullParameter(base64ReceiptLoyalty, "");
        return new SubmitReceiptRequest(base64ReceiptLoyalty.getOrderId(), base64ReceiptLoyalty.getMerchantName(), base64ReceiptLoyalty.getOrderAmount(), base64ReceiptLoyalty.getTimestamp(), base64ReceiptLoyalty.getBase64Receipt(), base64ReceiptLoyalty.getRawText(), base64ReceiptLoyalty.getMerchantId(), base64ReceiptLoyalty.getUserLoyaltyId());
    }
}
