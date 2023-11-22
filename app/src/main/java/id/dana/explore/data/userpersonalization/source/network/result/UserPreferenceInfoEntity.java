package id.dana.explore.data.userpersonalization.source.network.result;

import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\b\n\u0002\u0010 \n\u0002\b\u000e\u0018\u00002\u00020\u0001B\u008b\u0001\u0012\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0002\u0012\u0010\b\u0002\u0010\u0013\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0012\u0012\u0010\b\u0002\u0010\u001b\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0012\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\t¢\u0006\u0004\b\u001f\u0010 R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006R\u001c\u0010\n\u001a\u0004\u0018\u00010\t8\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u001c\u0010\u000e\u001a\u0004\u0018\u00010\t8\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u000e\u0010\u000b\u001a\u0004\b\u000f\u0010\rR\u001c\u0010\u0010\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0010\u0010\u0004\u001a\u0004\b\u0011\u0010\u0006R\"\u0010\u0013\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u00128\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016R\u001c\u0010\u0017\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0017\u0010\u0004\u001a\u0004\b\u0018\u0010\u0006R\u001c\u0010\u0019\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0019\u0010\u0004\u001a\u0004\b\u001a\u0010\u0006R\"\u0010\u001b\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u00128\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u001b\u0010\u0014\u001a\u0004\b\u001c\u0010\u0016R\u001c\u0010\u001d\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u001d\u0010\u0004\u001a\u0004\b\u001e\u0010\u0006"}, d2 = {"Lid/dana/explore/data/userpersonalization/source/network/result/UserPreferenceInfoEntity;", "", "", "displayNameEnglish", "Ljava/lang/String;", "getDisplayNameEnglish", "()Ljava/lang/String;", "displayNameIndonesia", "getDisplayNameIndonesia", "", "gmtCreate", "Ljava/lang/Long;", "getGmtCreate", "()Ljava/lang/Long;", "gmtModified", "getGmtModified", "iconUrl", "getIconUrl", "", "merchantMccList", "Ljava/util/List;", "getMerchantMccList", "()Ljava/util/List;", "preferenceId", "getPreferenceId", "searchId", "getSearchId", "serviceCodeList", "getServiceCodeList", "userId", "getUserId", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/util/List;Ljava/lang/Long;Ljava/lang/Long;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class UserPreferenceInfoEntity {
    @SerializedName("displayNameEnglish")
    private final String displayNameEnglish;
    @SerializedName("displayNameIndonesia")
    private final String displayNameIndonesia;
    @SerializedName("gmtCreate")
    private final Long gmtCreate;
    @SerializedName("gmtModified")
    private final Long gmtModified;
    @SerializedName("iconUrl")
    private final String iconUrl;
    @SerializedName("merchantMccList")
    private final List<String> merchantMccList;
    @SerializedName("preferenceId")
    private final String preferenceId;
    @SerializedName("searchId")
    private final String searchId;
    @SerializedName("serviceCodeList")
    private final List<String> serviceCodeList;
    @SerializedName("userId")
    private final String userId;

    public UserPreferenceInfoEntity() {
        this(null, null, null, null, null, null, null, null, null, null, 1023, null);
    }

    public UserPreferenceInfoEntity(String str, String str2, String str3, String str4, String str5, String str6, List<String> list, List<String> list2, Long l, Long l2) {
        this.searchId = str;
        this.userId = str2;
        this.preferenceId = str3;
        this.iconUrl = str4;
        this.displayNameEnglish = str5;
        this.displayNameIndonesia = str6;
        this.merchantMccList = list;
        this.serviceCodeList = list2;
        this.gmtCreate = l;
        this.gmtModified = l2;
    }

    @JvmName(name = "getSearchId")
    public final String getSearchId() {
        return this.searchId;
    }

    @JvmName(name = "getUserId")
    public final String getUserId() {
        return this.userId;
    }

    @JvmName(name = "getPreferenceId")
    public final String getPreferenceId() {
        return this.preferenceId;
    }

    @JvmName(name = "getIconUrl")
    public final String getIconUrl() {
        return this.iconUrl;
    }

    @JvmName(name = "getDisplayNameEnglish")
    public final String getDisplayNameEnglish() {
        return this.displayNameEnglish;
    }

    @JvmName(name = "getDisplayNameIndonesia")
    public final String getDisplayNameIndonesia() {
        return this.displayNameIndonesia;
    }

    public /* synthetic */ UserPreferenceInfoEntity(String str, String str2, String str3, String str4, String str5, String str6, List list, List list2, Long l, Long l2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? "" : str, (i & 2) != 0 ? "" : str2, (i & 4) != 0 ? "" : str3, (i & 8) != 0 ? "" : str4, (i & 16) != 0 ? "" : str5, (i & 32) == 0 ? str6 : "", (i & 64) != 0 ? CollectionsKt.emptyList() : list, (i & 128) != 0 ? CollectionsKt.emptyList() : list2, (i & 256) != 0 ? null : l, (i & 512) == 0 ? l2 : null);
    }

    @JvmName(name = "getMerchantMccList")
    public final List<String> getMerchantMccList() {
        return this.merchantMccList;
    }

    @JvmName(name = "getServiceCodeList")
    public final List<String> getServiceCodeList() {
        return this.serviceCodeList;
    }

    @JvmName(name = "getGmtCreate")
    public final Long getGmtCreate() {
        return this.gmtCreate;
    }

    @JvmName(name = "getGmtModified")
    public final Long getGmtModified() {
        return this.gmtModified;
    }
}
