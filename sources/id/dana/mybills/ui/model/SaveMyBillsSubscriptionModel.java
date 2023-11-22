package id.dana.mybills.ui.model;

import id.dana.danah5.bioutility.BioUtilityBridge;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0011\b\u0086\b\u0018\u00002\u00020\u0001B;\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0002\u0012\u0010\b\u0002\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0006\u0012\b\b\u0002\u0010\r\u001a\u00020\u0002¢\u0006\u0004\b$\u0010%J\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0004J\u0018\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0006HÆ\u0003¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\t\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\t\u0010\u0004JD\u0010\u000e\u001a\u00020\u00002\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00022\u0010\b\u0002\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u00062\b\b\u0002\u0010\r\u001a\u00020\u0002HÆ\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ\u001a\u0010\u0012\u001a\u00020\u00112\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0012\u0010\u0013J\u0010\u0010\u0015\u001a\u00020\u0014HÖ\u0001¢\u0006\u0004\b\u0015\u0010\u0016J\u0010\u0010\u0017\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0017\u0010\u0004R\"\u0010\r\u001a\u00020\u00028\u0007@\u0007X\u0086\u000e¢\u0006\u0012\n\u0004\b\r\u0010\u0018\u001a\u0004\b\u0019\u0010\u0004\"\u0004\b\u001a\u0010\u001bR$\u0010\u000b\u001a\u0004\u0018\u00010\u00028\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b\u000b\u0010\u0018\u001a\u0004\b\u001c\u0010\u0004\"\u0004\b\u001d\u0010\u001bR$\u0010\n\u001a\u0004\u0018\u00010\u00028\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u0018\u001a\u0004\b\u001e\u0010\u0004\"\u0004\b\u001f\u0010\u001bR*\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u00068\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b\f\u0010 \u001a\u0004\b!\u0010\b\"\u0004\b\"\u0010#"}, d2 = {"Lid/dana/mybills/ui/model/SaveMyBillsSubscriptionModel;", "", "", "component1", "()Ljava/lang/String;", "component2", "", "component3", "()Ljava/util/List;", "component4", "subscriptionId", BioUtilityBridge.SECURITY_ID, "verificationMethods", "recurringType", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/lang/String;)Lid/dana/mybills/ui/model/SaveMyBillsSubscriptionModel;", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "toString", "Ljava/lang/String;", "getRecurringType", "setRecurringType", "(Ljava/lang/String;)V", "getSecurityId", "setSecurityId", "getSubscriptionId", "setSubscriptionId", "Ljava/util/List;", "getVerificationMethods", "setVerificationMethods", "(Ljava/util/List;)V", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/lang/String;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes9.dex */
public final /* data */ class SaveMyBillsSubscriptionModel {
    private String recurringType;
    private String securityId;
    private String subscriptionId;
    private List<String> verificationMethods;

    public SaveMyBillsSubscriptionModel() {
        this(null, null, null, null, 15, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ SaveMyBillsSubscriptionModel copy$default(SaveMyBillsSubscriptionModel saveMyBillsSubscriptionModel, String str, String str2, List list, String str3, int i, Object obj) {
        if ((i & 1) != 0) {
            str = saveMyBillsSubscriptionModel.subscriptionId;
        }
        if ((i & 2) != 0) {
            str2 = saveMyBillsSubscriptionModel.securityId;
        }
        if ((i & 4) != 0) {
            list = saveMyBillsSubscriptionModel.verificationMethods;
        }
        if ((i & 8) != 0) {
            str3 = saveMyBillsSubscriptionModel.recurringType;
        }
        return saveMyBillsSubscriptionModel.copy(str, str2, list, str3);
    }

    /* renamed from: component1  reason: from getter */
    public final String getSubscriptionId() {
        return this.subscriptionId;
    }

    /* renamed from: component2  reason: from getter */
    public final String getSecurityId() {
        return this.securityId;
    }

    public final List<String> component3() {
        return this.verificationMethods;
    }

    /* renamed from: component4  reason: from getter */
    public final String getRecurringType() {
        return this.recurringType;
    }

    public final SaveMyBillsSubscriptionModel copy(String subscriptionId, String securityId, List<String> verificationMethods, String recurringType) {
        Intrinsics.checkNotNullParameter(recurringType, "");
        return new SaveMyBillsSubscriptionModel(subscriptionId, securityId, verificationMethods, recurringType);
    }

    public final boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other instanceof SaveMyBillsSubscriptionModel) {
            SaveMyBillsSubscriptionModel saveMyBillsSubscriptionModel = (SaveMyBillsSubscriptionModel) other;
            return Intrinsics.areEqual(this.subscriptionId, saveMyBillsSubscriptionModel.subscriptionId) && Intrinsics.areEqual(this.securityId, saveMyBillsSubscriptionModel.securityId) && Intrinsics.areEqual(this.verificationMethods, saveMyBillsSubscriptionModel.verificationMethods) && Intrinsics.areEqual(this.recurringType, saveMyBillsSubscriptionModel.recurringType);
        }
        return false;
    }

    public final int hashCode() {
        String str = this.subscriptionId;
        int hashCode = str == null ? 0 : str.hashCode();
        String str2 = this.securityId;
        int hashCode2 = str2 == null ? 0 : str2.hashCode();
        List<String> list = this.verificationMethods;
        return (((((hashCode * 31) + hashCode2) * 31) + (list != null ? list.hashCode() : 0)) * 31) + this.recurringType.hashCode();
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("SaveMyBillsSubscriptionModel(subscriptionId=");
        sb.append(this.subscriptionId);
        sb.append(", securityId=");
        sb.append(this.securityId);
        sb.append(", verificationMethods=");
        sb.append(this.verificationMethods);
        sb.append(", recurringType=");
        sb.append(this.recurringType);
        sb.append(')');
        return sb.toString();
    }

    public SaveMyBillsSubscriptionModel(String str, String str2, List<String> list, String str3) {
        Intrinsics.checkNotNullParameter(str3, "");
        this.subscriptionId = str;
        this.securityId = str2;
        this.verificationMethods = list;
        this.recurringType = str3;
    }

    @JvmName(name = "getSubscriptionId")
    public final String getSubscriptionId() {
        return this.subscriptionId;
    }

    @JvmName(name = "setSubscriptionId")
    public final void setSubscriptionId(String str) {
        this.subscriptionId = str;
    }

    @JvmName(name = "getSecurityId")
    public final String getSecurityId() {
        return this.securityId;
    }

    @JvmName(name = "setSecurityId")
    public final void setSecurityId(String str) {
        this.securityId = str;
    }

    public /* synthetic */ SaveMyBillsSubscriptionModel(String str, String str2, ArrayList arrayList, String str3, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? "" : str, (i & 2) != 0 ? "" : str2, (i & 4) != 0 ? new ArrayList() : arrayList, (i & 8) != 0 ? "" : str3);
    }

    @JvmName(name = "getVerificationMethods")
    public final List<String> getVerificationMethods() {
        return this.verificationMethods;
    }

    @JvmName(name = "setVerificationMethods")
    public final void setVerificationMethods(List<String> list) {
        this.verificationMethods = list;
    }

    @JvmName(name = "getRecurringType")
    public final String getRecurringType() {
        return this.recurringType;
    }

    @JvmName(name = "setRecurringType")
    public final void setRecurringType(String str) {
        Intrinsics.checkNotNullParameter(str, "");
        this.recurringType = str;
    }
}
