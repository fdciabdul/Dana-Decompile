package id.dana.sendmoney.data.config.groupsend.model;

import com.alibaba.ariver.kernel.RVParams;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0011\n\u0002\u0010\b\n\u0002\b\u000f\b\u0086\b\u0018\u00002\u00020\u0001B]\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0011\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0012\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0013\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0014\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0015\u001a\u0004\u0018\u00010\u0002\u0012\u0006\u0010\u0016\u001a\u00020\u000b\u0012\u0006\u0010\u0017\u001a\u00020\u000b¢\u0006\u0004\b+\u0010,J\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0004J\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0004J\u0012\u0010\u0007\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0007\u0010\u0004J\u0012\u0010\b\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\b\u0010\u0004J\u0012\u0010\t\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\t\u0010\u0004J\u0012\u0010\n\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\n\u0010\u0004J\u0010\u0010\f\u001a\u00020\u000bHÆ\u0003¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u000e\u001a\u00020\u000bHÆ\u0003¢\u0006\u0004\b\u000e\u0010\rJx\u0010\u0018\u001a\u00020\u00002\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u00022\b\b\u0002\u0010\u0016\u001a\u00020\u000b2\b\b\u0002\u0010\u0017\u001a\u00020\u000bHÆ\u0001¢\u0006\u0004\b\u0018\u0010\u0019J\u001a\u0010\u001b\u001a\u00020\u000b2\b\u0010\u001a\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u001b\u0010\u001cJ\u0010\u0010\u001e\u001a\u00020\u001dHÖ\u0001¢\u0006\u0004\b\u001e\u0010\u001fJ\u0010\u0010 \u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b \u0010\u0004R\u0019\u0010\u0011\u001a\u0004\u0018\u00010\u00028\u0007¢\u0006\f\n\u0004\b\u0011\u0010!\u001a\u0004\b\"\u0010\u0004R\u001c\u0010\u0012\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0012\u0010!\u001a\u0004\b#\u0010\u0004R\u001c\u0010\u0013\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0013\u0010!\u001a\u0004\b$\u0010\u0004R\u001a\u0010\u0017\u001a\u00020\u000b8\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0017\u0010%\u001a\u0004\b\u0017\u0010\rR\u001a\u0010\u0016\u001a\u00020\u000b8\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0016\u0010%\u001a\u0004\b&\u0010\rR\u001c\u0010\u0015\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0015\u0010!\u001a\u0004\b'\u0010\u0004R\u001c\u0010\u0014\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0014\u0010!\u001a\u0004\b(\u0010\u0004R\u001c\u0010\u0010\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0010\u0010!\u001a\u0004\b)\u0010\u0004R\u001c\u0010\u000f\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u000f\u0010!\u001a\u0004\b*\u0010\u0004"}, d2 = {"Lid/dana/sendmoney/data/config/groupsend/model/GroupSendScenarioConfigEntity;", "", "", "component1", "()Ljava/lang/String;", "component2", "component3", "component4", "component5", "component6", "component7", "", "component8", "()Z", "component9", "title", RVParams.LONG_SUB_TITLE, "action", "backgroundImg", "icon", "promoTitle", "promoDesc", "promoActive", "isEnable", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZZ)Lid/dana/sendmoney/data/config/groupsend/model/GroupSendScenarioConfigEntity;", "other", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "toString", "Ljava/lang/String;", "getAction", "getBackgroundImg", "getIcon", "Z", "getPromoActive", "getPromoDesc", "getPromoTitle", "getSubTitle", "getTitle", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZZ)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final /* data */ class GroupSendScenarioConfigEntity {
    private final String action;
    private final String backgroundImg;
    private final String icon;
    private final boolean isEnable;
    private final boolean promoActive;
    private final String promoDesc;
    private final String promoTitle;
    private final String subTitle;
    private final String title;

    /* renamed from: component1  reason: from getter */
    public final String getTitle() {
        return this.title;
    }

    /* renamed from: component2  reason: from getter */
    public final String getSubTitle() {
        return this.subTitle;
    }

    /* renamed from: component3  reason: from getter */
    public final String getAction() {
        return this.action;
    }

    /* renamed from: component4  reason: from getter */
    public final String getBackgroundImg() {
        return this.backgroundImg;
    }

    /* renamed from: component5  reason: from getter */
    public final String getIcon() {
        return this.icon;
    }

    /* renamed from: component6  reason: from getter */
    public final String getPromoTitle() {
        return this.promoTitle;
    }

    /* renamed from: component7  reason: from getter */
    public final String getPromoDesc() {
        return this.promoDesc;
    }

    /* renamed from: component8  reason: from getter */
    public final boolean getPromoActive() {
        return this.promoActive;
    }

    /* renamed from: component9  reason: from getter */
    public final boolean getIsEnable() {
        return this.isEnable;
    }

    public final GroupSendScenarioConfigEntity copy(String title, String subTitle, String action, String backgroundImg, String icon, String promoTitle, String promoDesc, boolean promoActive, boolean isEnable) {
        return new GroupSendScenarioConfigEntity(title, subTitle, action, backgroundImg, icon, promoTitle, promoDesc, promoActive, isEnable);
    }

    public final boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other instanceof GroupSendScenarioConfigEntity) {
            GroupSendScenarioConfigEntity groupSendScenarioConfigEntity = (GroupSendScenarioConfigEntity) other;
            return Intrinsics.areEqual(this.title, groupSendScenarioConfigEntity.title) && Intrinsics.areEqual(this.subTitle, groupSendScenarioConfigEntity.subTitle) && Intrinsics.areEqual(this.action, groupSendScenarioConfigEntity.action) && Intrinsics.areEqual(this.backgroundImg, groupSendScenarioConfigEntity.backgroundImg) && Intrinsics.areEqual(this.icon, groupSendScenarioConfigEntity.icon) && Intrinsics.areEqual(this.promoTitle, groupSendScenarioConfigEntity.promoTitle) && Intrinsics.areEqual(this.promoDesc, groupSendScenarioConfigEntity.promoDesc) && this.promoActive == groupSendScenarioConfigEntity.promoActive && this.isEnable == groupSendScenarioConfigEntity.isEnable;
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final int hashCode() {
        String str = this.title;
        int hashCode = str == null ? 0 : str.hashCode();
        String str2 = this.subTitle;
        int hashCode2 = str2 == null ? 0 : str2.hashCode();
        String str3 = this.action;
        int hashCode3 = str3 == null ? 0 : str3.hashCode();
        String str4 = this.backgroundImg;
        int hashCode4 = str4 == null ? 0 : str4.hashCode();
        String str5 = this.icon;
        int hashCode5 = str5 == null ? 0 : str5.hashCode();
        String str6 = this.promoTitle;
        int hashCode6 = str6 == null ? 0 : str6.hashCode();
        String str7 = this.promoDesc;
        int hashCode7 = str7 != null ? str7.hashCode() : 0;
        boolean z = this.promoActive;
        int i = z;
        if (z != 0) {
            i = 1;
        }
        boolean z2 = this.isEnable;
        return (((((((((((((((hashCode * 31) + hashCode2) * 31) + hashCode3) * 31) + hashCode4) * 31) + hashCode5) * 31) + hashCode6) * 31) + hashCode7) * 31) + i) * 31) + (z2 ? 1 : z2 ? 1 : 0);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("GroupSendScenarioConfigEntity(title=");
        sb.append(this.title);
        sb.append(", subTitle=");
        sb.append(this.subTitle);
        sb.append(", action=");
        sb.append(this.action);
        sb.append(", backgroundImg=");
        sb.append(this.backgroundImg);
        sb.append(", icon=");
        sb.append(this.icon);
        sb.append(", promoTitle=");
        sb.append(this.promoTitle);
        sb.append(", promoDesc=");
        sb.append(this.promoDesc);
        sb.append(", promoActive=");
        sb.append(this.promoActive);
        sb.append(", isEnable=");
        sb.append(this.isEnable);
        sb.append(')');
        return sb.toString();
    }

    public GroupSendScenarioConfigEntity(String str, String str2, String str3, String str4, String str5, String str6, String str7, boolean z, boolean z2) {
        this.title = str;
        this.subTitle = str2;
        this.action = str3;
        this.backgroundImg = str4;
        this.icon = str5;
        this.promoTitle = str6;
        this.promoDesc = str7;
        this.promoActive = z;
        this.isEnable = z2;
    }

    @JvmName(name = "getTitle")
    public final String getTitle() {
        return this.title;
    }

    @JvmName(name = "getSubTitle")
    public final String getSubTitle() {
        return this.subTitle;
    }

    @JvmName(name = "getAction")
    public final String getAction() {
        return this.action;
    }

    @JvmName(name = "getBackgroundImg")
    public final String getBackgroundImg() {
        return this.backgroundImg;
    }

    @JvmName(name = "getIcon")
    public final String getIcon() {
        return this.icon;
    }

    @JvmName(name = "getPromoTitle")
    public final String getPromoTitle() {
        return this.promoTitle;
    }

    @JvmName(name = "getPromoDesc")
    public final String getPromoDesc() {
        return this.promoDesc;
    }

    @JvmName(name = "getPromoActive")
    public final boolean getPromoActive() {
        return this.promoActive;
    }

    @JvmName(name = "isEnable")
    public final boolean isEnable() {
        return this.isEnable;
    }
}
