package id.dana.domain.home.model;

import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b!\n\u0002\u0010\u000b\n\u0002\b\u0019\b\u0086\b\u0018\u00002\u00020\u0001BÇ\u0001\u0012\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010 \u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010!\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\"\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010#\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010$\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010%\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\bA\u0010BJ\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0004J\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0004J\u0012\u0010\b\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0004\b\b\u0010\tJ\u0012\u0010\n\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0004\b\n\u0010\tJ\u0012\u0010\u000b\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u000b\u0010\u0004J\u0012\u0010\f\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0004\b\f\u0010\tJ\u0012\u0010\r\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\r\u0010\u0004J\u0012\u0010\u000e\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u000e\u0010\u0004J\u0012\u0010\u000f\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u000f\u0010\u0004J\u0012\u0010\u0010\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0010\u0010\u0004J\u0012\u0010\u0011\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0011\u0010\u0004J\u0012\u0010\u0012\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0012\u0010\u0004J\u0012\u0010\u0013\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0013\u0010\u0004J\u0012\u0010\u0014\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0014\u0010\u0004J\u0012\u0010\u0015\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0015\u0010\u0004JÐ\u0001\u0010&\u001a\u00020\u00002\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010 \u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010!\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\"\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010#\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010$\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010%\u001a\u0004\u0018\u00010\u0002HÆ\u0001¢\u0006\u0004\b&\u0010'J\u001a\u0010*\u001a\u00020)2\b\u0010(\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b*\u0010+J\u0010\u0010,\u001a\u00020\u0007HÖ\u0001¢\u0006\u0004\b,\u0010-J\u0010\u0010.\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b.\u0010\u0004R\u0019\u0010#\u001a\u0004\u0018\u00010\u00028\u0007¢\u0006\f\n\u0004\b#\u0010/\u001a\u0004\b0\u0010\u0004R\u001c\u0010\u0016\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0016\u0010/\u001a\u0004\b1\u0010\u0004R\u001c\u0010\u001d\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u001d\u0010/\u001a\u0004\b2\u0010\u0004R\u001c\u0010\u001e\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u001e\u0010/\u001a\u0004\b3\u0010\u0004R\u001c\u0010\u001f\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u001f\u0010/\u001a\u0004\b4\u0010\u0004R\u001c\u0010\"\u001a\u0004\u0018\u00010\u00078\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\"\u00105\u001a\u0004\b6\u0010\tR\u001c\u0010%\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b%\u0010/\u001a\u0004\b7\u0010\u0004R\u001c\u0010\u0019\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0019\u0010/\u001a\u0004\b8\u0010\u0004R\u001c\u0010$\u001a\u0004\u0018\u00010\u00078\u0007X\u0087\u0004¢\u0006\f\n\u0004\b$\u00105\u001a\u0004\b9\u0010\tR\u001c\u0010!\u001a\u0004\u0018\u00010\u00078\u0007X\u0087\u0004¢\u0006\f\n\u0004\b!\u00105\u001a\u0004\b:\u0010\tR\u001c\u0010\u0018\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0018\u0010/\u001a\u0004\b;\u0010\u0004R\u001c\u0010\u001c\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u001c\u0010/\u001a\u0004\b<\u0010\u0004R\u001c\u0010\u0017\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0017\u0010/\u001a\u0004\b=\u0010\u0004R\u001c\u0010 \u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b \u0010/\u001a\u0004\b>\u0010\u0004R\u001c\u0010\u001b\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u001b\u0010/\u001a\u0004\b?\u0010\u0004R\u001c\u0010\u001a\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u001a\u0010/\u001a\u0004\b@\u0010\u0004"}, d2 = {"Lid/dana/domain/home/model/MoreForYouData;", "", "", "component1", "()Ljava/lang/String;", "component10", "component11", "", "component12", "()Ljava/lang/Integer;", "component13", "component14", "component15", "component16", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "clientId", "scopes", "redirectType", "icon", "title", "subtitle", "redirectUrl", "contentId", "contentName", "contentType", "spaceCode", "priority", "createdDate", "bizScenario", "localIconId", "expireDate", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;)Lid/dana/domain/home/model/MoreForYouData;", "other", "", "equals", "(Ljava/lang/Object;)Z", "hashCode", "()I", "toString", "Ljava/lang/String;", "getBizScenario", "getClientId", "getContentId", "getContentName", "getContentType", "Ljava/lang/Integer;", "getCreatedDate", "getExpireDate", "getIcon", "getLocalIconId", "getPriority", "getRedirectType", "getRedirectUrl", "getScopes", "getSpaceCode", "getSubtitle", "getTitle", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final /* data */ class MoreForYouData {
    private final String bizScenario;
    private final String clientId;
    private final String contentId;
    private final String contentName;
    private final String contentType;
    private final Integer createdDate;
    private final String expireDate;
    private final String icon;
    private final Integer localIconId;
    private final Integer priority;
    private final String redirectType;
    private final String redirectUrl;
    private final String scopes;
    private final String spaceCode;
    private final String subtitle;
    private final String title;

    public MoreForYouData() {
        this(null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, 65535, null);
    }

    /* renamed from: component1  reason: from getter */
    public final String getClientId() {
        return this.clientId;
    }

    /* renamed from: component10  reason: from getter */
    public final String getContentType() {
        return this.contentType;
    }

    /* renamed from: component11  reason: from getter */
    public final String getSpaceCode() {
        return this.spaceCode;
    }

    /* renamed from: component12  reason: from getter */
    public final Integer getPriority() {
        return this.priority;
    }

    /* renamed from: component13  reason: from getter */
    public final Integer getCreatedDate() {
        return this.createdDate;
    }

    /* renamed from: component14  reason: from getter */
    public final String getBizScenario() {
        return this.bizScenario;
    }

    /* renamed from: component15  reason: from getter */
    public final Integer getLocalIconId() {
        return this.localIconId;
    }

    /* renamed from: component16  reason: from getter */
    public final String getExpireDate() {
        return this.expireDate;
    }

    /* renamed from: component2  reason: from getter */
    public final String getScopes() {
        return this.scopes;
    }

    /* renamed from: component3  reason: from getter */
    public final String getRedirectType() {
        return this.redirectType;
    }

    /* renamed from: component4  reason: from getter */
    public final String getIcon() {
        return this.icon;
    }

    /* renamed from: component5  reason: from getter */
    public final String getTitle() {
        return this.title;
    }

    /* renamed from: component6  reason: from getter */
    public final String getSubtitle() {
        return this.subtitle;
    }

    /* renamed from: component7  reason: from getter */
    public final String getRedirectUrl() {
        return this.redirectUrl;
    }

    /* renamed from: component8  reason: from getter */
    public final String getContentId() {
        return this.contentId;
    }

    /* renamed from: component9  reason: from getter */
    public final String getContentName() {
        return this.contentName;
    }

    public final MoreForYouData copy(String clientId, String scopes, String redirectType, String icon, String title, String subtitle, String redirectUrl, String contentId, String contentName, String contentType, String spaceCode, Integer priority, Integer createdDate, String bizScenario, Integer localIconId, String expireDate) {
        return new MoreForYouData(clientId, scopes, redirectType, icon, title, subtitle, redirectUrl, contentId, contentName, contentType, spaceCode, priority, createdDate, bizScenario, localIconId, expireDate);
    }

    public final boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other instanceof MoreForYouData) {
            MoreForYouData moreForYouData = (MoreForYouData) other;
            return Intrinsics.areEqual(this.clientId, moreForYouData.clientId) && Intrinsics.areEqual(this.scopes, moreForYouData.scopes) && Intrinsics.areEqual(this.redirectType, moreForYouData.redirectType) && Intrinsics.areEqual(this.icon, moreForYouData.icon) && Intrinsics.areEqual(this.title, moreForYouData.title) && Intrinsics.areEqual(this.subtitle, moreForYouData.subtitle) && Intrinsics.areEqual(this.redirectUrl, moreForYouData.redirectUrl) && Intrinsics.areEqual(this.contentId, moreForYouData.contentId) && Intrinsics.areEqual(this.contentName, moreForYouData.contentName) && Intrinsics.areEqual(this.contentType, moreForYouData.contentType) && Intrinsics.areEqual(this.spaceCode, moreForYouData.spaceCode) && Intrinsics.areEqual(this.priority, moreForYouData.priority) && Intrinsics.areEqual(this.createdDate, moreForYouData.createdDate) && Intrinsics.areEqual(this.bizScenario, moreForYouData.bizScenario) && Intrinsics.areEqual(this.localIconId, moreForYouData.localIconId) && Intrinsics.areEqual(this.expireDate, moreForYouData.expireDate);
        }
        return false;
    }

    public final int hashCode() {
        String str = this.clientId;
        int hashCode = str == null ? 0 : str.hashCode();
        String str2 = this.scopes;
        int hashCode2 = str2 == null ? 0 : str2.hashCode();
        String str3 = this.redirectType;
        int hashCode3 = str3 == null ? 0 : str3.hashCode();
        String str4 = this.icon;
        int hashCode4 = str4 == null ? 0 : str4.hashCode();
        String str5 = this.title;
        int hashCode5 = str5 == null ? 0 : str5.hashCode();
        String str6 = this.subtitle;
        int hashCode6 = str6 == null ? 0 : str6.hashCode();
        String str7 = this.redirectUrl;
        int hashCode7 = str7 == null ? 0 : str7.hashCode();
        String str8 = this.contentId;
        int hashCode8 = str8 == null ? 0 : str8.hashCode();
        String str9 = this.contentName;
        int hashCode9 = str9 == null ? 0 : str9.hashCode();
        String str10 = this.contentType;
        int hashCode10 = str10 == null ? 0 : str10.hashCode();
        String str11 = this.spaceCode;
        int hashCode11 = str11 == null ? 0 : str11.hashCode();
        Integer num = this.priority;
        int hashCode12 = num == null ? 0 : num.hashCode();
        Integer num2 = this.createdDate;
        int hashCode13 = num2 == null ? 0 : num2.hashCode();
        String str12 = this.bizScenario;
        int hashCode14 = str12 == null ? 0 : str12.hashCode();
        Integer num3 = this.localIconId;
        int hashCode15 = num3 == null ? 0 : num3.hashCode();
        String str13 = this.expireDate;
        return (((((((((((((((((((((((((((((hashCode * 31) + hashCode2) * 31) + hashCode3) * 31) + hashCode4) * 31) + hashCode5) * 31) + hashCode6) * 31) + hashCode7) * 31) + hashCode8) * 31) + hashCode9) * 31) + hashCode10) * 31) + hashCode11) * 31) + hashCode12) * 31) + hashCode13) * 31) + hashCode14) * 31) + hashCode15) * 31) + (str13 != null ? str13.hashCode() : 0);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("MoreForYouData(clientId=");
        sb.append(this.clientId);
        sb.append(", scopes=");
        sb.append(this.scopes);
        sb.append(", redirectType=");
        sb.append(this.redirectType);
        sb.append(", icon=");
        sb.append(this.icon);
        sb.append(", title=");
        sb.append(this.title);
        sb.append(", subtitle=");
        sb.append(this.subtitle);
        sb.append(", redirectUrl=");
        sb.append(this.redirectUrl);
        sb.append(", contentId=");
        sb.append(this.contentId);
        sb.append(", contentName=");
        sb.append(this.contentName);
        sb.append(", contentType=");
        sb.append(this.contentType);
        sb.append(", spaceCode=");
        sb.append(this.spaceCode);
        sb.append(", priority=");
        sb.append(this.priority);
        sb.append(", createdDate=");
        sb.append(this.createdDate);
        sb.append(", bizScenario=");
        sb.append(this.bizScenario);
        sb.append(", localIconId=");
        sb.append(this.localIconId);
        sb.append(", expireDate=");
        sb.append(this.expireDate);
        sb.append(')');
        return sb.toString();
    }

    public MoreForYouData(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11, Integer num, Integer num2, String str12, Integer num3, String str13) {
        this.clientId = str;
        this.scopes = str2;
        this.redirectType = str3;
        this.icon = str4;
        this.title = str5;
        this.subtitle = str6;
        this.redirectUrl = str7;
        this.contentId = str8;
        this.contentName = str9;
        this.contentType = str10;
        this.spaceCode = str11;
        this.priority = num;
        this.createdDate = num2;
        this.bizScenario = str12;
        this.localIconId = num3;
        this.expireDate = str13;
    }

    @JvmName(name = "getClientId")
    public final String getClientId() {
        return this.clientId;
    }

    @JvmName(name = "getScopes")
    public final String getScopes() {
        return this.scopes;
    }

    @JvmName(name = "getRedirectType")
    public final String getRedirectType() {
        return this.redirectType;
    }

    @JvmName(name = "getIcon")
    public final String getIcon() {
        return this.icon;
    }

    @JvmName(name = "getTitle")
    public final String getTitle() {
        return this.title;
    }

    @JvmName(name = "getSubtitle")
    public final String getSubtitle() {
        return this.subtitle;
    }

    @JvmName(name = "getRedirectUrl")
    public final String getRedirectUrl() {
        return this.redirectUrl;
    }

    @JvmName(name = "getContentId")
    public final String getContentId() {
        return this.contentId;
    }

    @JvmName(name = "getContentName")
    public final String getContentName() {
        return this.contentName;
    }

    @JvmName(name = "getContentType")
    public final String getContentType() {
        return this.contentType;
    }

    @JvmName(name = "getSpaceCode")
    public final String getSpaceCode() {
        return this.spaceCode;
    }

    public /* synthetic */ MoreForYouData(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11, Integer num, Integer num2, String str12, Integer num3, String str13, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? "" : str, (i & 2) != 0 ? "" : str2, (i & 4) != 0 ? "" : str3, (i & 8) != 0 ? "" : str4, (i & 16) != 0 ? "" : str5, (i & 32) != 0 ? "" : str6, (i & 64) != 0 ? "" : str7, (i & 128) != 0 ? "" : str8, (i & 256) != 0 ? "" : str9, (i & 512) != 0 ? "" : str10, (i & 1024) != 0 ? "" : str11, (i & 2048) != 0 ? 0 : num, (i & 4096) != 0 ? 0 : num2, (i & 8192) == 0 ? str12 : "", (i & 16384) != 0 ? -1 : num3, (i & 32768) != 0 ? null : str13);
    }

    @JvmName(name = "getPriority")
    public final Integer getPriority() {
        return this.priority;
    }

    @JvmName(name = "getCreatedDate")
    public final Integer getCreatedDate() {
        return this.createdDate;
    }

    @JvmName(name = "getBizScenario")
    public final String getBizScenario() {
        return this.bizScenario;
    }

    @JvmName(name = "getLocalIconId")
    public final Integer getLocalIconId() {
        return this.localIconId;
    }

    @JvmName(name = "getExpireDate")
    public final String getExpireDate() {
        return this.expireDate;
    }
}
