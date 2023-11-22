package id.dana.explore.data.userpersonalization.source.network.result;

import com.google.gson.annotations.SerializedName;
import id.dana.domain.social.ExtendInfoUtilKt;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\b\n\u0018\u00002\u00020\u0001BO\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\u0010\b\u0002\u0010\n\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\t\u0012\u0010\b\u0002\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\t¢\u0006\u0004\b\u0012\u0010\u0013R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006R\"\u0010\n\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\t8\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u001c\u0010\u000e\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u000e\u0010\u0004\u001a\u0004\b\u000f\u0010\u0006R\"\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\t8\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0010\u0010\u000b\u001a\u0004\b\u0011\u0010\r"}, d2 = {"Lid/dana/explore/data/userpersonalization/source/network/result/PreferenceOptionInfoEntity;", "", "", ExtendInfoUtilKt.DISPLAY_NAME_KEY, "Ljava/lang/String;", "getDisplayName", "()Ljava/lang/String;", "iconUrl", "getIconUrl", "", "merchantMccList", "Ljava/util/List;", "getMerchantMccList", "()Ljava/util/List;", "preferenceId", "getPreferenceId", "serviceCodeList", "getServiceCodeList", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/util/List;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class PreferenceOptionInfoEntity {
    @SerializedName(ExtendInfoUtilKt.DISPLAY_NAME_KEY)
    private final String displayName;
    @SerializedName("iconUrl")
    private final String iconUrl;
    @SerializedName("merchantMccList")
    private final List<String> merchantMccList;
    @SerializedName("preferenceId")
    private final String preferenceId;
    @SerializedName("serviceCodeList")
    private final List<String> serviceCodeList;

    public PreferenceOptionInfoEntity() {
        this(null, null, null, null, null, 31, null);
    }

    public PreferenceOptionInfoEntity(String str, String str2, String str3, List<String> list, List<String> list2) {
        this.preferenceId = str;
        this.iconUrl = str2;
        this.displayName = str3;
        this.merchantMccList = list;
        this.serviceCodeList = list2;
    }

    @JvmName(name = "getPreferenceId")
    public final String getPreferenceId() {
        return this.preferenceId;
    }

    @JvmName(name = "getIconUrl")
    public final String getIconUrl() {
        return this.iconUrl;
    }

    @JvmName(name = "getDisplayName")
    public final String getDisplayName() {
        return this.displayName;
    }

    public /* synthetic */ PreferenceOptionInfoEntity(String str, String str2, String str3, List list, List list2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? "" : str, (i & 2) != 0 ? "" : str2, (i & 4) == 0 ? str3 : "", (i & 8) != 0 ? CollectionsKt.emptyList() : list, (i & 16) != 0 ? CollectionsKt.emptyList() : list2);
    }

    @JvmName(name = "getMerchantMccList")
    public final List<String> getMerchantMccList() {
        return this.merchantMccList;
    }

    @JvmName(name = "getServiceCodeList")
    public final List<String> getServiceCodeList() {
        return this.serviceCodeList;
    }
}
