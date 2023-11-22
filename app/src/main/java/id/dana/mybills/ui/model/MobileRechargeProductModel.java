package id.dana.mybills.ui.model;

import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\r\b\u0086\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\t\u001a\u00020\u0002\u0012\u000e\u0010\n\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005¢\u0006\u0004\b\u001d\u0010\u001eJ\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0018\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005HÆ\u0003¢\u0006\u0004\b\u0007\u0010\bJ,\u0010\u000b\u001a\u00020\u00002\b\b\u0002\u0010\t\u001a\u00020\u00022\u0010\b\u0002\u0010\n\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005HÆ\u0001¢\u0006\u0004\b\u000b\u0010\fJ\u001a\u0010\u000f\u001a\u00020\u000e2\b\u0010\r\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u000f\u0010\u0010J\u0010\u0010\u0012\u001a\u00020\u0011HÖ\u0001¢\u0006\u0004\b\u0012\u0010\u0013J\u0010\u0010\u0014\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0014\u0010\u0004R*\u0010\n\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00058\u0007@\u0007X\u0086\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u0015\u001a\u0004\b\u0016\u0010\b\"\u0004\b\u0017\u0010\u0018R\"\u0010\t\u001a\u00020\u00028\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b\t\u0010\u0019\u001a\u0004\b\u001a\u0010\u0004\"\u0004\b\u001b\u0010\u001c"}, d2 = {"Lid/dana/mybills/ui/model/MobileRechargeProductModel;", "", "", "component1", "()Ljava/lang/String;", "", "Lid/dana/mybills/ui/model/ProviderPackageModel;", "component2", "()Ljava/util/List;", "providerName", "packages", "copy", "(Ljava/lang/String;Ljava/util/List;)Lid/dana/mybills/ui/model/MobileRechargeProductModel;", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "toString", "Ljava/util/List;", "getPackages", "setPackages", "(Ljava/util/List;)V", "Ljava/lang/String;", "getProviderName", "setProviderName", "(Ljava/lang/String;)V", "<init>", "(Ljava/lang/String;Ljava/util/List;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public final /* data */ class MobileRechargeProductModel {
    private List<ProviderPackageModel> packages;
    private String providerName;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ MobileRechargeProductModel copy$default(MobileRechargeProductModel mobileRechargeProductModel, String str, List list, int i, Object obj) {
        if ((i & 1) != 0) {
            str = mobileRechargeProductModel.providerName;
        }
        if ((i & 2) != 0) {
            list = mobileRechargeProductModel.packages;
        }
        return mobileRechargeProductModel.copy(str, list);
    }

    /* renamed from: component1  reason: from getter */
    public final String getProviderName() {
        return this.providerName;
    }

    public final List<ProviderPackageModel> component2() {
        return this.packages;
    }

    public final MobileRechargeProductModel copy(String providerName, List<ProviderPackageModel> packages) {
        Intrinsics.checkNotNullParameter(providerName, "");
        return new MobileRechargeProductModel(providerName, packages);
    }

    public final boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other instanceof MobileRechargeProductModel) {
            MobileRechargeProductModel mobileRechargeProductModel = (MobileRechargeProductModel) other;
            return Intrinsics.areEqual(this.providerName, mobileRechargeProductModel.providerName) && Intrinsics.areEqual(this.packages, mobileRechargeProductModel.packages);
        }
        return false;
    }

    public final int hashCode() {
        int hashCode = this.providerName.hashCode();
        List<ProviderPackageModel> list = this.packages;
        return (hashCode * 31) + (list == null ? 0 : list.hashCode());
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("MobileRechargeProductModel(providerName=");
        sb.append(this.providerName);
        sb.append(", packages=");
        sb.append(this.packages);
        sb.append(')');
        return sb.toString();
    }

    public MobileRechargeProductModel(String str, List<ProviderPackageModel> list) {
        Intrinsics.checkNotNullParameter(str, "");
        this.providerName = str;
        this.packages = list;
    }

    @JvmName(name = "getProviderName")
    public final String getProviderName() {
        return this.providerName;
    }

    @JvmName(name = "setProviderName")
    public final void setProviderName(String str) {
        Intrinsics.checkNotNullParameter(str, "");
        this.providerName = str;
    }

    @JvmName(name = "getPackages")
    public final List<ProviderPackageModel> getPackages() {
        return this.packages;
    }

    @JvmName(name = "setPackages")
    public final void setPackages(List<ProviderPackageModel> list) {
        this.packages = list;
    }
}
