package id.dana.domain.expresspurchase.interaction.model;

import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B7\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u000b\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0010\u0010\u0011R\u0019\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0007¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006R\u001c\u0010\t\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006R\u001c\u0010\f\u001a\u0004\u0018\u00010\u000b8\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000f"}, d2 = {"Lid/dana/domain/expresspurchase/interaction/model/QuickBuyGold;", "", "", "acquirementId", "Ljava/lang/String;", "getAcquirementId", "()Ljava/lang/String;", "billId", "getBillId", "errorCode", "getErrorCode", "Lid/dana/domain/expresspurchase/interaction/model/GoldValidationInfo;", "goldValidationInfo", "Lid/dana/domain/expresspurchase/interaction/model/GoldValidationInfo;", "getGoldValidationInfo", "()Lid/dana/domain/expresspurchase/interaction/model/GoldValidationInfo;", "<init>", "(Lid/dana/domain/expresspurchase/interaction/model/GoldValidationInfo;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class QuickBuyGold {
    private final String acquirementId;
    private final String billId;
    private final String errorCode;
    private final GoldValidationInfo goldValidationInfo;

    public QuickBuyGold() {
        this(null, null, null, null, 15, null);
    }

    public QuickBuyGold(GoldValidationInfo goldValidationInfo, String str, String str2, String str3) {
        this.goldValidationInfo = goldValidationInfo;
        this.billId = str;
        this.acquirementId = str2;
        this.errorCode = str3;
    }

    public /* synthetic */ QuickBuyGold(GoldValidationInfo goldValidationInfo, String str, String str2, String str3, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : goldValidationInfo, (i & 2) != 0 ? "" : str, (i & 4) != 0 ? "" : str2, (i & 8) != 0 ? "" : str3);
    }

    @JvmName(name = "getGoldValidationInfo")
    public final GoldValidationInfo getGoldValidationInfo() {
        return this.goldValidationInfo;
    }

    @JvmName(name = "getBillId")
    public final String getBillId() {
        return this.billId;
    }

    @JvmName(name = "getAcquirementId")
    public final String getAcquirementId() {
        return this.acquirementId;
    }

    @JvmName(name = "getErrorCode")
    public final String getErrorCode() {
        return this.errorCode;
    }
}
