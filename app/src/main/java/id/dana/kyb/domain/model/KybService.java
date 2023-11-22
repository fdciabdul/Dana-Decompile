package id.dana.kyb.domain.model;

import id.dana.danah5.share.ShareToFeedBridge;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\b\n\u0002\b\u000e\b\u0086\b\u0018\u00002\u00020\u0001BK\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u000b¢\u0006\u0004\b&\u0010'J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0012\u0010\b\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0004\b\b\u0010\u0007J\u0010\u0010\t\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\t\u0010\u0007J\u0012\u0010\n\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0004\b\n\u0010\u0007J\u0012\u0010\f\u001a\u0004\u0018\u00010\u000bHÆ\u0003¢\u0006\u0004\b\f\u0010\rJT\u0010\u0014\u001a\u00020\u00002\b\b\u0002\u0010\u000e\u001a\u00020\u00022\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0011\u001a\u00020\u00052\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u000bHÆ\u0001¢\u0006\u0004\b\u0014\u0010\u0015J\u001a\u0010\u0017\u001a\u00020\u00022\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0017\u0010\u0018J\u0010\u0010\u001a\u001a\u00020\u0019HÖ\u0001¢\u0006\u0004\b\u001a\u0010\u001bJ\u0010\u0010\u001c\u001a\u00020\u0005HÖ\u0001¢\u0006\u0004\b\u001c\u0010\u0007R\u0017\u0010\u0011\u001a\u00020\u00058\u0007¢\u0006\f\n\u0004\b\u0011\u0010\u001d\u001a\u0004\b\u001e\u0010\u0007R\u001a\u0010\u000e\u001a\u00020\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u000e\u0010\u001f\u001a\u0004\b \u0010\u0004R\u001c\u0010\u000f\u001a\u0004\u0018\u00010\u00058\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u000f\u0010\u001d\u001a\u0004\b!\u0010\u0007R\u001c\u0010\u0010\u001a\u0004\u0018\u00010\u00058\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0010\u0010\u001d\u001a\u0004\b\"\u0010\u0007R\u001c\u0010\u0012\u001a\u0004\u0018\u00010\u00058\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0012\u0010\u001d\u001a\u0004\b#\u0010\u0007R\u001c\u0010\u0013\u001a\u0004\u0018\u00010\u000b8\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0013\u0010$\u001a\u0004\b%\u0010\r"}, d2 = {"Lid/dana/kyb/domain/model/KybService;", "", "", "component1", "()Z", "", "component2", "()Ljava/lang/String;", "component3", "component4", "component5", "Lid/dana/kyb/domain/model/KybServiceRedirectValue;", "component6", "()Lid/dana/kyb/domain/model/KybServiceRedirectValue;", "enable", "icon", "name", "categoryName", "redirectType", ShareToFeedBridge.REDIRECT_VALUE, "copy", "(ZLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lid/dana/kyb/domain/model/KybServiceRedirectValue;)Lid/dana/kyb/domain/model/KybService;", "other", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "toString", "Ljava/lang/String;", "getCategoryName", "Z", "getEnable", "getIcon", "getName", "getRedirectType", "Lid/dana/kyb/domain/model/KybServiceRedirectValue;", "getRedirectValue", "<init>", "(ZLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lid/dana/kyb/domain/model/KybServiceRedirectValue;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final /* data */ class KybService {
    private final String categoryName;
    private final boolean enable;
    private final String icon;
    private final String name;
    private final String redirectType;
    private final KybServiceRedirectValue redirectValue;

    public KybService() {
        this(false, null, null, null, null, null, 63, null);
    }

    public static /* synthetic */ KybService copy$default(KybService kybService, boolean z, String str, String str2, String str3, String str4, KybServiceRedirectValue kybServiceRedirectValue, int i, Object obj) {
        if ((i & 1) != 0) {
            z = kybService.enable;
        }
        if ((i & 2) != 0) {
            str = kybService.icon;
        }
        String str5 = str;
        if ((i & 4) != 0) {
            str2 = kybService.name;
        }
        String str6 = str2;
        if ((i & 8) != 0) {
            str3 = kybService.categoryName;
        }
        String str7 = str3;
        if ((i & 16) != 0) {
            str4 = kybService.redirectType;
        }
        String str8 = str4;
        if ((i & 32) != 0) {
            kybServiceRedirectValue = kybService.redirectValue;
        }
        return kybService.copy(z, str5, str6, str7, str8, kybServiceRedirectValue);
    }

    /* renamed from: component1  reason: from getter */
    public final boolean getEnable() {
        return this.enable;
    }

    /* renamed from: component2  reason: from getter */
    public final String getIcon() {
        return this.icon;
    }

    /* renamed from: component3  reason: from getter */
    public final String getName() {
        return this.name;
    }

    /* renamed from: component4  reason: from getter */
    public final String getCategoryName() {
        return this.categoryName;
    }

    /* renamed from: component5  reason: from getter */
    public final String getRedirectType() {
        return this.redirectType;
    }

    /* renamed from: component6  reason: from getter */
    public final KybServiceRedirectValue getRedirectValue() {
        return this.redirectValue;
    }

    public final KybService copy(boolean enable, String icon, String name, String categoryName, String redirectType, KybServiceRedirectValue redirectValue) {
        Intrinsics.checkNotNullParameter(categoryName, "");
        return new KybService(enable, icon, name, categoryName, redirectType, redirectValue);
    }

    public final boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other instanceof KybService) {
            KybService kybService = (KybService) other;
            return this.enable == kybService.enable && Intrinsics.areEqual(this.icon, kybService.icon) && Intrinsics.areEqual(this.name, kybService.name) && Intrinsics.areEqual(this.categoryName, kybService.categoryName) && Intrinsics.areEqual(this.redirectType, kybService.redirectType) && Intrinsics.areEqual(this.redirectValue, kybService.redirectValue);
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v12 */
    /* JADX WARN: Type inference failed for: r0v13 */
    public final int hashCode() {
        boolean z = this.enable;
        ?? r0 = z;
        if (z) {
            r0 = 1;
        }
        String str = this.icon;
        int hashCode = str == null ? 0 : str.hashCode();
        String str2 = this.name;
        int hashCode2 = str2 == null ? 0 : str2.hashCode();
        int hashCode3 = this.categoryName.hashCode();
        String str3 = this.redirectType;
        int hashCode4 = str3 == null ? 0 : str3.hashCode();
        KybServiceRedirectValue kybServiceRedirectValue = this.redirectValue;
        return (((((((((r0 * 31) + hashCode) * 31) + hashCode2) * 31) + hashCode3) * 31) + hashCode4) * 31) + (kybServiceRedirectValue != null ? kybServiceRedirectValue.hashCode() : 0);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("KybService(enable=");
        sb.append(this.enable);
        sb.append(", icon=");
        sb.append(this.icon);
        sb.append(", name=");
        sb.append(this.name);
        sb.append(", categoryName=");
        sb.append(this.categoryName);
        sb.append(", redirectType=");
        sb.append(this.redirectType);
        sb.append(", redirectValue=");
        sb.append(this.redirectValue);
        sb.append(')');
        return sb.toString();
    }

    public KybService(boolean z, String str, String str2, String str3, String str4, KybServiceRedirectValue kybServiceRedirectValue) {
        Intrinsics.checkNotNullParameter(str3, "");
        this.enable = z;
        this.icon = str;
        this.name = str2;
        this.categoryName = str3;
        this.redirectType = str4;
        this.redirectValue = kybServiceRedirectValue;
    }

    public /* synthetic */ KybService(boolean z, String str, String str2, String str3, String str4, KybServiceRedirectValue kybServiceRedirectValue, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? false : z, (i & 2) != 0 ? null : str, (i & 4) != 0 ? null : str2, (i & 8) != 0 ? "" : str3, (i & 16) != 0 ? null : str4, (i & 32) == 0 ? kybServiceRedirectValue : null);
    }

    @JvmName(name = "getEnable")
    public final boolean getEnable() {
        return this.enable;
    }

    @JvmName(name = "getIcon")
    public final String getIcon() {
        return this.icon;
    }

    @JvmName(name = "getName")
    public final String getName() {
        return this.name;
    }

    @JvmName(name = "getCategoryName")
    public final String getCategoryName() {
        return this.categoryName;
    }

    @JvmName(name = "getRedirectType")
    public final String getRedirectType() {
        return this.redirectType;
    }

    @JvmName(name = "getRedirectValue")
    public final KybServiceRedirectValue getRedirectValue() {
        return this.redirectValue;
    }
}
