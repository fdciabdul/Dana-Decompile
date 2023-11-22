package id.dana.richview.moreforyou.model;

import com.alibaba.griver.api.constants.GriverEvents;
import java.util.Date;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u001d\n\u0002\u0010\u000b\n\u0002\b-\b\u0086\b\u0018\u00002\u00020\u0001BÇ\u0001\u0012\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010 \u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010!\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\"\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010#\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010$\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010%\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010&\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010'\u001a\u0004\u0018\u00010\r¢\u0006\u0004\bW\u0010XJ\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0004J\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0004J\u0012\u0010\b\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0004\b\b\u0010\tJ\u0012\u0010\n\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0004\b\n\u0010\tJ\u0012\u0010\u000b\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u000b\u0010\u0004J\u0012\u0010\f\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0004\b\f\u0010\tJ\u0012\u0010\u000e\u001a\u0004\u0018\u00010\rHÆ\u0003¢\u0006\u0004\b\u000e\u0010\u000fJ\u0012\u0010\u0010\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0010\u0010\u0004J\u0012\u0010\u0011\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0011\u0010\u0004J\u0012\u0010\u0012\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0012\u0010\u0004J\u0012\u0010\u0013\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0013\u0010\u0004J\u0012\u0010\u0014\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0014\u0010\u0004J\u0012\u0010\u0015\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0015\u0010\u0004J\u0012\u0010\u0016\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0016\u0010\u0004J\u0012\u0010\u0017\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0017\u0010\u0004JÐ\u0001\u0010(\u001a\u00020\u00002\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010 \u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010!\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\"\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010#\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010$\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010%\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010&\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010'\u001a\u0004\u0018\u00010\rHÆ\u0001¢\u0006\u0004\b(\u0010)J\u001a\u0010,\u001a\u00020+2\b\u0010*\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b,\u0010-J\u0010\u0010.\u001a\u00020\u0007HÖ\u0001¢\u0006\u0004\b.\u0010/J\u0010\u00100\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b0\u0010\u0004R$\u0010%\u001a\u0004\u0018\u00010\u00028\u0007@\u0007X\u0086\u000e¢\u0006\u0012\n\u0004\b%\u00101\u001a\u0004\b2\u0010\u0004\"\u0004\b3\u00104R$\u0010\u0018\u001a\u0004\u0018\u00010\u00028\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0018\u00101\u001a\u0004\b5\u0010\u0004\"\u0004\b6\u00104R$\u0010\u001f\u001a\u0004\u0018\u00010\u00028\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001f\u00101\u001a\u0004\b7\u0010\u0004\"\u0004\b8\u00104R$\u0010 \u001a\u0004\u0018\u00010\u00028\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b \u00101\u001a\u0004\b9\u0010\u0004\"\u0004\b:\u00104R$\u0010!\u001a\u0004\u0018\u00010\u00028\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b!\u00101\u001a\u0004\b;\u0010\u0004\"\u0004\b<\u00104R$\u0010$\u001a\u0004\u0018\u00010\u00078\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b$\u0010=\u001a\u0004\b>\u0010\t\"\u0004\b?\u0010@R$\u0010'\u001a\u0004\u0018\u00010\r8\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b'\u0010A\u001a\u0004\bB\u0010\u000f\"\u0004\bC\u0010DR$\u0010\u001b\u001a\u0004\u0018\u00010\u00028\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001b\u00101\u001a\u0004\bE\u0010\u0004\"\u0004\bF\u00104R$\u0010&\u001a\u0004\u0018\u00010\u00078\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b&\u0010=\u001a\u0004\bG\u0010\t\"\u0004\bH\u0010@R$\u0010#\u001a\u0004\u0018\u00010\u00078\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b#\u0010=\u001a\u0004\bI\u0010\t\"\u0004\bJ\u0010@R$\u0010\u001a\u001a\u0004\u0018\u00010\u00028\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001a\u00101\u001a\u0004\bK\u0010\u0004\"\u0004\bL\u00104R$\u0010\u001e\u001a\u0004\u0018\u00010\u00028\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001e\u00101\u001a\u0004\bM\u0010\u0004\"\u0004\bN\u00104R$\u0010\u0019\u001a\u0004\u0018\u00010\u00028\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0019\u00101\u001a\u0004\bO\u0010\u0004\"\u0004\bP\u00104R$\u0010\"\u001a\u0004\u0018\u00010\u00028\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b\"\u00101\u001a\u0004\bQ\u0010\u0004\"\u0004\bR\u00104R$\u0010\u001d\u001a\u0004\u0018\u00010\u00028\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001d\u00101\u001a\u0004\bS\u0010\u0004\"\u0004\bT\u00104R$\u0010\u001c\u001a\u0004\u0018\u00010\u00028\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001c\u00101\u001a\u0004\bU\u0010\u0004\"\u0004\bV\u00104"}, d2 = {"Lid/dana/richview/moreforyou/model/MoreForYouModel;", "", "", "component1", "()Ljava/lang/String;", "component10", "component11", "", "component12", "()Ljava/lang/Integer;", "component13", "component14", "component15", "Ljava/util/Date;", "component16", "()Ljava/util/Date;", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "clientId", "scopes", "redirectType", "icon", "title", "subtitle", "redirectUrl", "contentId", "contentName", "contentType", "spaceCode", "priority", "createdDate", "bizScenario", "localIconId", "expireDate", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Integer;Ljava/util/Date;)Lid/dana/richview/moreforyou/model/MoreForYouModel;", "other", "", "equals", "(Ljava/lang/Object;)Z", "hashCode", "()I", "toString", "Ljava/lang/String;", "getBizScenario", "setBizScenario", "(Ljava/lang/String;)V", "getClientId", "setClientId", "getContentId", "setContentId", "getContentName", "setContentName", "getContentType", "setContentType", "Ljava/lang/Integer;", "getCreatedDate", "setCreatedDate", "(Ljava/lang/Integer;)V", "Ljava/util/Date;", "getExpireDate", "setExpireDate", "(Ljava/util/Date;)V", "getIcon", "setIcon", "getLocalIconId", "setLocalIconId", "getPriority", "setPriority", "getRedirectType", "setRedirectType", "getRedirectUrl", "setRedirectUrl", "getScopes", "setScopes", "getSpaceCode", "setSpaceCode", "getSubtitle", "setSubtitle", "getTitle", GriverEvents.EVENT_SET_TITLE, "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Integer;Ljava/util/Date;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final /* data */ class MoreForYouModel {
    private String bizScenario;
    private String clientId;
    private String contentId;
    private String contentName;
    private String contentType;
    private Integer createdDate;
    private Date expireDate;
    private String icon;
    private Integer localIconId;
    private Integer priority;
    private String redirectType;
    private String redirectUrl;
    private String scopes;
    private String spaceCode;
    private String subtitle;
    private String title;

    public MoreForYouModel() {
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
    public final Date getExpireDate() {
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

    public final MoreForYouModel copy(String clientId, String scopes, String redirectType, String icon, String title, String subtitle, String redirectUrl, String contentId, String contentName, String contentType, String spaceCode, Integer priority, Integer createdDate, String bizScenario, Integer localIconId, Date expireDate) {
        return new MoreForYouModel(clientId, scopes, redirectType, icon, title, subtitle, redirectUrl, contentId, contentName, contentType, spaceCode, priority, createdDate, bizScenario, localIconId, expireDate);
    }

    public final boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other instanceof MoreForYouModel) {
            MoreForYouModel moreForYouModel = (MoreForYouModel) other;
            return Intrinsics.areEqual(this.clientId, moreForYouModel.clientId) && Intrinsics.areEqual(this.scopes, moreForYouModel.scopes) && Intrinsics.areEqual(this.redirectType, moreForYouModel.redirectType) && Intrinsics.areEqual(this.icon, moreForYouModel.icon) && Intrinsics.areEqual(this.title, moreForYouModel.title) && Intrinsics.areEqual(this.subtitle, moreForYouModel.subtitle) && Intrinsics.areEqual(this.redirectUrl, moreForYouModel.redirectUrl) && Intrinsics.areEqual(this.contentId, moreForYouModel.contentId) && Intrinsics.areEqual(this.contentName, moreForYouModel.contentName) && Intrinsics.areEqual(this.contentType, moreForYouModel.contentType) && Intrinsics.areEqual(this.spaceCode, moreForYouModel.spaceCode) && Intrinsics.areEqual(this.priority, moreForYouModel.priority) && Intrinsics.areEqual(this.createdDate, moreForYouModel.createdDate) && Intrinsics.areEqual(this.bizScenario, moreForYouModel.bizScenario) && Intrinsics.areEqual(this.localIconId, moreForYouModel.localIconId) && Intrinsics.areEqual(this.expireDate, moreForYouModel.expireDate);
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
        Date date = this.expireDate;
        return (((((((((((((((((((((((((((((hashCode * 31) + hashCode2) * 31) + hashCode3) * 31) + hashCode4) * 31) + hashCode5) * 31) + hashCode6) * 31) + hashCode7) * 31) + hashCode8) * 31) + hashCode9) * 31) + hashCode10) * 31) + hashCode11) * 31) + hashCode12) * 31) + hashCode13) * 31) + hashCode14) * 31) + hashCode15) * 31) + (date != null ? date.hashCode() : 0);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("MoreForYouModel(clientId=");
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

    public MoreForYouModel(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11, Integer num, Integer num2, String str12, Integer num3, Date date) {
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
        this.expireDate = date;
    }

    @JvmName(name = "getClientId")
    public final String getClientId() {
        return this.clientId;
    }

    @JvmName(name = "setClientId")
    public final void setClientId(String str) {
        this.clientId = str;
    }

    @JvmName(name = "getScopes")
    public final String getScopes() {
        return this.scopes;
    }

    @JvmName(name = "setScopes")
    public final void setScopes(String str) {
        this.scopes = str;
    }

    @JvmName(name = "getRedirectType")
    public final String getRedirectType() {
        return this.redirectType;
    }

    @JvmName(name = "setRedirectType")
    public final void setRedirectType(String str) {
        this.redirectType = str;
    }

    @JvmName(name = "getIcon")
    public final String getIcon() {
        return this.icon;
    }

    @JvmName(name = "setIcon")
    public final void setIcon(String str) {
        this.icon = str;
    }

    @JvmName(name = "getTitle")
    public final String getTitle() {
        return this.title;
    }

    @JvmName(name = GriverEvents.EVENT_SET_TITLE)
    public final void setTitle(String str) {
        this.title = str;
    }

    @JvmName(name = "getSubtitle")
    public final String getSubtitle() {
        return this.subtitle;
    }

    @JvmName(name = "setSubtitle")
    public final void setSubtitle(String str) {
        this.subtitle = str;
    }

    @JvmName(name = "getRedirectUrl")
    public final String getRedirectUrl() {
        return this.redirectUrl;
    }

    @JvmName(name = "setRedirectUrl")
    public final void setRedirectUrl(String str) {
        this.redirectUrl = str;
    }

    @JvmName(name = "getContentId")
    public final String getContentId() {
        return this.contentId;
    }

    @JvmName(name = "setContentId")
    public final void setContentId(String str) {
        this.contentId = str;
    }

    @JvmName(name = "getContentName")
    public final String getContentName() {
        return this.contentName;
    }

    @JvmName(name = "setContentName")
    public final void setContentName(String str) {
        this.contentName = str;
    }

    @JvmName(name = "getContentType")
    public final String getContentType() {
        return this.contentType;
    }

    @JvmName(name = "setContentType")
    public final void setContentType(String str) {
        this.contentType = str;
    }

    @JvmName(name = "getSpaceCode")
    public final String getSpaceCode() {
        return this.spaceCode;
    }

    @JvmName(name = "setSpaceCode")
    public final void setSpaceCode(String str) {
        this.spaceCode = str;
    }

    public /* synthetic */ MoreForYouModel(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11, Integer num, Integer num2, String str12, Integer num3, Date date, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? "" : str, (i & 2) != 0 ? "" : str2, (i & 4) != 0 ? "" : str3, (i & 8) != 0 ? "" : str4, (i & 16) != 0 ? "" : str5, (i & 32) != 0 ? "" : str6, (i & 64) != 0 ? "" : str7, (i & 128) != 0 ? "" : str8, (i & 256) != 0 ? "" : str9, (i & 512) != 0 ? "" : str10, (i & 1024) != 0 ? "" : str11, (i & 2048) != 0 ? 0 : num, (i & 4096) != 0 ? 0 : num2, (i & 8192) == 0 ? str12 : "", (i & 16384) != 0 ? -1 : num3, (i & 32768) != 0 ? null : date);
    }

    @JvmName(name = "getPriority")
    public final Integer getPriority() {
        return this.priority;
    }

    @JvmName(name = "setPriority")
    public final void setPriority(Integer num) {
        this.priority = num;
    }

    @JvmName(name = "getCreatedDate")
    public final Integer getCreatedDate() {
        return this.createdDate;
    }

    @JvmName(name = "setCreatedDate")
    public final void setCreatedDate(Integer num) {
        this.createdDate = num;
    }

    @JvmName(name = "getBizScenario")
    public final String getBizScenario() {
        return this.bizScenario;
    }

    @JvmName(name = "setBizScenario")
    public final void setBizScenario(String str) {
        this.bizScenario = str;
    }

    @JvmName(name = "getLocalIconId")
    public final Integer getLocalIconId() {
        return this.localIconId;
    }

    @JvmName(name = "setLocalIconId")
    public final void setLocalIconId(Integer num) {
        this.localIconId = num;
    }

    @JvmName(name = "getExpireDate")
    public final Date getExpireDate() {
        return this.expireDate;
    }

    @JvmName(name = "setExpireDate")
    public final void setExpireDate(Date date) {
        this.expireDate = date;
    }
}
