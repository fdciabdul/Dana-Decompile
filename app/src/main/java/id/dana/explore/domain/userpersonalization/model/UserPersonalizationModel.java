package id.dana.explore.domain.userpersonalization.model;

import id.dana.domain.social.ExtendInfoUtilKt;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\f\b\u0086\b\u0018\u00002\u00020\u0001BE\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0002\u0012\b\b\u0002\u0010\f\u001a\u00020\u0002\u0012\b\b\u0002\u0010\r\u001a\u00020\u0002\u0012\u000e\b\u0002\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00020\u0007\u0012\u000e\b\u0002\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00020\u0007¢\u0006\u0004\b!\u0010\"J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0004J\u0016\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00020\u0007HÆ\u0003¢\u0006\u0004\b\b\u0010\tJ\u0016\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00020\u0007HÆ\u0003¢\u0006\u0004\b\n\u0010\tJN\u0010\u0010\u001a\u00020\u00002\b\b\u0002\u0010\u000b\u001a\u00020\u00022\b\b\u0002\u0010\f\u001a\u00020\u00022\b\b\u0002\u0010\r\u001a\u00020\u00022\u000e\b\u0002\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00020\u00072\u000e\b\u0002\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00020\u0007HÆ\u0001¢\u0006\u0004\b\u0010\u0010\u0011J\u001a\u0010\u0014\u001a\u00020\u00132\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0014\u0010\u0015J\u0010\u0010\u0017\u001a\u00020\u0016HÖ\u0001¢\u0006\u0004\b\u0017\u0010\u0018J\u0010\u0010\u0019\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0019\u0010\u0004R\u0017\u0010\f\u001a\u00020\u00028\u0007¢\u0006\f\n\u0004\b\f\u0010\u001a\u001a\u0004\b\u001b\u0010\u0004R\u001a\u0010\u000b\u001a\u00020\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u000b\u0010\u001a\u001a\u0004\b\u001c\u0010\u0004R \u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00020\u00078\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u000e\u0010\u001d\u001a\u0004\b\u001e\u0010\tR\u001a\u0010\r\u001a\u00020\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\r\u0010\u001a\u001a\u0004\b\u001f\u0010\u0004R \u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00020\u00078\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u000f\u0010\u001d\u001a\u0004\b \u0010\t"}, d2 = {"Lid/dana/explore/domain/userpersonalization/model/UserPersonalizationModel;", "", "", "component1", "()Ljava/lang/String;", "component2", "component3", "", "component4", "()Ljava/util/List;", "component5", "iconUrl", ExtendInfoUtilKt.DISPLAY_NAME_KEY, "preferenceId", "merchantMcclist", "serviceCodeList", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/util/List;)Lid/dana/explore/domain/userpersonalization/model/UserPersonalizationModel;", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "toString", "Ljava/lang/String;", "getDisplayName", "getIconUrl", "Ljava/util/List;", "getMerchantMcclist", "getPreferenceId", "getServiceCodeList", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/util/List;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final /* data */ class UserPersonalizationModel {
    private final String displayName;
    private final String iconUrl;
    private final List<String> merchantMcclist;
    private final String preferenceId;
    private final List<String> serviceCodeList;

    public UserPersonalizationModel() {
        this(null, null, null, null, null, 31, null);
    }

    public static /* synthetic */ UserPersonalizationModel copy$default(UserPersonalizationModel userPersonalizationModel, String str, String str2, String str3, List list, List list2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = userPersonalizationModel.iconUrl;
        }
        if ((i & 2) != 0) {
            str2 = userPersonalizationModel.displayName;
        }
        String str4 = str2;
        if ((i & 4) != 0) {
            str3 = userPersonalizationModel.preferenceId;
        }
        String str5 = str3;
        List<String> list3 = list;
        if ((i & 8) != 0) {
            list3 = userPersonalizationModel.merchantMcclist;
        }
        List list4 = list3;
        List<String> list5 = list2;
        if ((i & 16) != 0) {
            list5 = userPersonalizationModel.serviceCodeList;
        }
        return userPersonalizationModel.copy(str, str4, str5, list4, list5);
    }

    /* renamed from: component1  reason: from getter */
    public final String getIconUrl() {
        return this.iconUrl;
    }

    /* renamed from: component2  reason: from getter */
    public final String getDisplayName() {
        return this.displayName;
    }

    /* renamed from: component3  reason: from getter */
    public final String getPreferenceId() {
        return this.preferenceId;
    }

    public final List<String> component4() {
        return this.merchantMcclist;
    }

    public final List<String> component5() {
        return this.serviceCodeList;
    }

    public final UserPersonalizationModel copy(String iconUrl, String displayName, String preferenceId, List<String> merchantMcclist, List<String> serviceCodeList) {
        Intrinsics.checkNotNullParameter(iconUrl, "");
        Intrinsics.checkNotNullParameter(displayName, "");
        Intrinsics.checkNotNullParameter(preferenceId, "");
        Intrinsics.checkNotNullParameter(merchantMcclist, "");
        Intrinsics.checkNotNullParameter(serviceCodeList, "");
        return new UserPersonalizationModel(iconUrl, displayName, preferenceId, merchantMcclist, serviceCodeList);
    }

    public final boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other instanceof UserPersonalizationModel) {
            UserPersonalizationModel userPersonalizationModel = (UserPersonalizationModel) other;
            return Intrinsics.areEqual(this.iconUrl, userPersonalizationModel.iconUrl) && Intrinsics.areEqual(this.displayName, userPersonalizationModel.displayName) && Intrinsics.areEqual(this.preferenceId, userPersonalizationModel.preferenceId) && Intrinsics.areEqual(this.merchantMcclist, userPersonalizationModel.merchantMcclist) && Intrinsics.areEqual(this.serviceCodeList, userPersonalizationModel.serviceCodeList);
        }
        return false;
    }

    public final int hashCode() {
        return (((((((this.iconUrl.hashCode() * 31) + this.displayName.hashCode()) * 31) + this.preferenceId.hashCode()) * 31) + this.merchantMcclist.hashCode()) * 31) + this.serviceCodeList.hashCode();
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("UserPersonalizationModel(iconUrl=");
        sb.append(this.iconUrl);
        sb.append(", displayName=");
        sb.append(this.displayName);
        sb.append(", preferenceId=");
        sb.append(this.preferenceId);
        sb.append(", merchantMcclist=");
        sb.append(this.merchantMcclist);
        sb.append(", serviceCodeList=");
        sb.append(this.serviceCodeList);
        sb.append(')');
        return sb.toString();
    }

    public UserPersonalizationModel(String str, String str2, String str3, List<String> list, List<String> list2) {
        Intrinsics.checkNotNullParameter(str, "");
        Intrinsics.checkNotNullParameter(str2, "");
        Intrinsics.checkNotNullParameter(str3, "");
        Intrinsics.checkNotNullParameter(list, "");
        Intrinsics.checkNotNullParameter(list2, "");
        this.iconUrl = str;
        this.displayName = str2;
        this.preferenceId = str3;
        this.merchantMcclist = list;
        this.serviceCodeList = list2;
    }

    @JvmName(name = "getIconUrl")
    public final String getIconUrl() {
        return this.iconUrl;
    }

    @JvmName(name = "getDisplayName")
    public final String getDisplayName() {
        return this.displayName;
    }

    @JvmName(name = "getPreferenceId")
    public final String getPreferenceId() {
        return this.preferenceId;
    }

    public /* synthetic */ UserPersonalizationModel(String str, String str2, String str3, List list, List list2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? "" : str, (i & 2) != 0 ? "" : str2, (i & 4) == 0 ? str3 : "", (i & 8) != 0 ? CollectionsKt.emptyList() : list, (i & 16) != 0 ? CollectionsKt.emptyList() : list2);
    }

    @JvmName(name = "getMerchantMcclist")
    public final List<String> getMerchantMcclist() {
        return this.merchantMcclist;
    }

    @JvmName(name = "getServiceCodeList")
    public final List<String> getServiceCodeList() {
        return this.serviceCodeList;
    }
}
