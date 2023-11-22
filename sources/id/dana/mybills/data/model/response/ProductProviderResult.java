package id.dana.mybills.data.model.response;

import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u001f\u0012\b\u0010\t\u001a\u0004\u0018\u00010\b\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002¢\u0006\u0004\b\r\u0010\u000eR\u001d\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0007¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007R\u001c\u0010\t\u001a\u0004\u0018\u00010\b8\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\f"}, d2 = {"Lid/dana/mybills/data/model/response/ProductProviderResult;", "", "", "Lid/dana/mybills/data/model/response/ProviderPackageResult;", "packages", "Ljava/util/List;", "getPackages", "()Ljava/util/List;", "", "providerName", "Ljava/lang/String;", "getProviderName", "()Ljava/lang/String;", "<init>", "(Ljava/lang/String;Ljava/util/List;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class ProductProviderResult {
    private final List<ProviderPackageResult> packages;
    private final String providerName;

    public ProductProviderResult(String str, List<ProviderPackageResult> list) {
        Intrinsics.checkNotNullParameter(list, "");
        this.providerName = str;
        this.packages = list;
    }

    @JvmName(name = "getProviderName")
    public final String getProviderName() {
        return this.providerName;
    }

    @JvmName(name = "getPackages")
    public final List<ProviderPackageResult> getPackages() {
        return this.packages;
    }
}
