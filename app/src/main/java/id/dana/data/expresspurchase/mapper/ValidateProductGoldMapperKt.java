package id.dana.data.expresspurchase.mapper;

import id.dana.data.nearbyme.model.MoneyViewEntityMapperKt;
import id.dana.domain.expresspurchase.interaction.model.GoldValidationInfo;
import id.dana.domain.nearbyme.model.MoneyView;
import id.dana.network.response.expresspurchase.ProductValidateStatusInfoResponse;
import id.dana.network.response.expresspurchase.ValidateProductGoldResponse;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0011\u0010\u0002\u001a\u00020\u0001*\u00020\u0000¢\u0006\u0004\b\u0002\u0010\u0003\u001a\u0013\u0010\u0006\u001a\u00020\u0005*\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u0006\u0010\u0007"}, d2 = {"Lid/dana/network/response/expresspurchase/ValidateProductGoldResponse;", "Lid/dana/domain/expresspurchase/interaction/model/GoldValidationInfo;", "toGoldValidationInfo", "(Lid/dana/network/response/expresspurchase/ValidateProductGoldResponse;)Lid/dana/domain/expresspurchase/interaction/model/GoldValidationInfo;", "Lid/dana/network/response/expresspurchase/ProductValidateStatusInfoResponse;", "Lid/dana/domain/expresspurchase/interaction/model/GoldValidationInfo$ProductStatusInfo;", "toProductStatusInfo", "(Lid/dana/network/response/expresspurchase/ProductValidateStatusInfoResponse;)Lid/dana/domain/expresspurchase/interaction/model/GoldValidationInfo$ProductStatusInfo;"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class ValidateProductGoldMapperKt {
    public static final GoldValidationInfo toGoldValidationInfo(ValidateProductGoldResponse validateProductGoldResponse) {
        Intrinsics.checkNotNullParameter(validateProductGoldResponse, "");
        GoldValidationInfo.ProductStatusInfo productStatusInfo = toProductStatusInfo(validateProductGoldResponse.getProductValidateStatusInfo());
        List<String> validationTypes = validateProductGoldResponse.getValidationTypes();
        if (validationTypes == null) {
            validationTypes = CollectionsKt.emptyList();
        }
        Map<String, Object> validationInfo = validateProductGoldResponse.getValidationInfo();
        if (validationInfo == null) {
            validationInfo = MapsKt.emptyMap();
        }
        return new GoldValidationInfo(productStatusInfo, validationTypes, validationInfo, validateProductGoldResponse.errorCode);
    }

    public static final GoldValidationInfo.ProductStatusInfo toProductStatusInfo(ProductValidateStatusInfoResponse productValidateStatusInfoResponse) {
        MoneyView moneyView = MoneyViewEntityMapperKt.toMoneyView(productValidateStatusInfoResponse != null ? productValidateStatusInfoResponse.getNewPrice() : null);
        String thirdRefId = productValidateStatusInfoResponse != null ? productValidateStatusInfoResponse.getThirdRefId() : null;
        if (thirdRefId == null) {
            thirdRefId = "";
        }
        return new GoldValidationInfo.ProductStatusInfo(moneyView, thirdRefId);
    }
}
