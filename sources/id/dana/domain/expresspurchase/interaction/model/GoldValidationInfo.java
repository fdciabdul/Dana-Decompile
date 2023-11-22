package id.dana.domain.expresspurchase.interaction.model;

import id.dana.domain.nearbyme.model.MoneyView;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010$\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\b\u0007\u0018\u00002\u00020\u0001:\u0001\u0018B=\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00020\u0011\u0012\u0012\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00010\f\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0016\u0010\u0017R\u0019\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0007¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\b\u001a\u00020\u00078\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR&\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00010\f8\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R \u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00020\u00118\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015"}, d2 = {"Lid/dana/domain/expresspurchase/interaction/model/GoldValidationInfo;", "", "", "errorCode", "Ljava/lang/String;", "getErrorCode", "()Ljava/lang/String;", "Lid/dana/domain/expresspurchase/interaction/model/GoldValidationInfo$ProductStatusInfo;", "productValidateStatusInfo", "Lid/dana/domain/expresspurchase/interaction/model/GoldValidationInfo$ProductStatusInfo;", "getProductValidateStatusInfo", "()Lid/dana/domain/expresspurchase/interaction/model/GoldValidationInfo$ProductStatusInfo;", "", "validationInfo", "Ljava/util/Map;", "getValidationInfo", "()Ljava/util/Map;", "", "validationTypes", "Ljava/util/List;", "getValidationTypes", "()Ljava/util/List;", "<init>", "(Lid/dana/domain/expresspurchase/interaction/model/GoldValidationInfo$ProductStatusInfo;Ljava/util/List;Ljava/util/Map;Ljava/lang/String;)V", "ProductStatusInfo"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class GoldValidationInfo {
    private final String errorCode;
    private final ProductStatusInfo productValidateStatusInfo;
    private final Map<String, Object> validationInfo;
    private final List<String> validationTypes;

    public GoldValidationInfo(ProductStatusInfo productStatusInfo, List<String> list, Map<String, ? extends Object> map, String str) {
        Intrinsics.checkNotNullParameter(productStatusInfo, "");
        Intrinsics.checkNotNullParameter(list, "");
        Intrinsics.checkNotNullParameter(map, "");
        this.productValidateStatusInfo = productStatusInfo;
        this.validationTypes = list;
        this.validationInfo = map;
        this.errorCode = str;
    }

    public /* synthetic */ GoldValidationInfo(ProductStatusInfo productStatusInfo, List list, Map map, String str, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(productStatusInfo, list, map, (i & 8) != 0 ? "" : str);
    }

    @JvmName(name = "getProductValidateStatusInfo")
    public final ProductStatusInfo getProductValidateStatusInfo() {
        return this.productValidateStatusInfo;
    }

    @JvmName(name = "getValidationTypes")
    public final List<String> getValidationTypes() {
        return this.validationTypes;
    }

    @JvmName(name = "getValidationInfo")
    public final Map<String, Object> getValidationInfo() {
        return this.validationInfo;
    }

    @JvmName(name = "getErrorCode")
    public final String getErrorCode() {
        return this.errorCode;
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\f\u0010\rR\u0017\u0010\u0003\u001a\u00020\u00028\u0007¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\b\u001a\u00020\u00078\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000b"}, d2 = {"Lid/dana/domain/expresspurchase/interaction/model/GoldValidationInfo$ProductStatusInfo;", "", "Lid/dana/domain/nearbyme/model/MoneyView;", "newPrice", "Lid/dana/domain/nearbyme/model/MoneyView;", "getNewPrice", "()Lid/dana/domain/nearbyme/model/MoneyView;", "", "thirdRefId", "Ljava/lang/String;", "getThirdRefId", "()Ljava/lang/String;", "<init>", "(Lid/dana/domain/nearbyme/model/MoneyView;Ljava/lang/String;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes4.dex */
    public static final class ProductStatusInfo {
        private final MoneyView newPrice;
        private final String thirdRefId;

        public ProductStatusInfo(MoneyView moneyView, String str) {
            Intrinsics.checkNotNullParameter(moneyView, "");
            Intrinsics.checkNotNullParameter(str, "");
            this.newPrice = moneyView;
            this.thirdRefId = str;
        }

        @JvmName(name = "getNewPrice")
        public final MoneyView getNewPrice() {
            return this.newPrice;
        }

        @JvmName(name = "getThirdRefId")
        public final String getThirdRefId() {
            return this.thirdRefId;
        }
    }
}
