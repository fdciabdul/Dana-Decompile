package id.dana.data.config.source.sharedpreference;

import com.alipay.imobile.network.quake.transport.http.constant.HeaderConstant;
import com.ap.zoloz.hummer.h5.ZolozEkycH5Handler;
import java.util.Date;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u001a\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0010\b\n\u0002\b\u0010\u0018\u00002\u00020\u0001B\u0091\u0002\u0012\b\u0010\u0018\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\u001a\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\u001c\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\u001e\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010 \u001a\u0004\u0018\u00010\u0007\u0012\b\u0010#\u001a\u0004\u0018\u00010\"\u0012\b\u0010'\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010)\u001a\u0004\u0018\u00010\"\u0012\b\u0010-\u001a\u0004\u0018\u00010\"\u0012\b\u0010/\u001a\u0004\u0018\u00010\"\u0012\b\u00101\u001a\u0004\u0018\u00010\u0007\u0012\b\b\u0002\u00104\u001a\u000203\u0012\b\u00108\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010:\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010<\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010>\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010@\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\u0014\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\u0012\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\f\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\u0016\u001a\u0004\u0018\u00010\u0007\u0012\u000e\u0010\u0003\u001a\n\u0012\u0004\u0012\u00020\u0000\u0018\u00010\u0002\u0012\b\u0010+\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\bB\u0010CR\u001f\u0010\u0003\u001a\n\u0012\u0004\u0012\u00020\u0000\u0018\u00010\u00028\u0007¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\b\u001a\u0004\u0018\u00010\u00078\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u001c\u0010\f\u001a\u0004\u0018\u00010\u00078\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\f\u0010\t\u001a\u0004\b\r\u0010\u000bR\u001c\u0010\u000e\u001a\u0004\u0018\u00010\u00078\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u000e\u0010\t\u001a\u0004\b\u000f\u0010\u000bR\u001c\u0010\u0010\u001a\u0004\u0018\u00010\u00078\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0010\u0010\t\u001a\u0004\b\u0011\u0010\u000bR\u001c\u0010\u0012\u001a\u0004\u0018\u00010\u00078\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0012\u0010\t\u001a\u0004\b\u0013\u0010\u000bR\u001c\u0010\u0014\u001a\u0004\u0018\u00010\u00078\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0014\u0010\t\u001a\u0004\b\u0015\u0010\u000bR\u001c\u0010\u0016\u001a\u0004\u0018\u00010\u00078\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0016\u0010\t\u001a\u0004\b\u0017\u0010\u000bR\u001c\u0010\u0018\u001a\u0004\u0018\u00010\u00078\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0018\u0010\t\u001a\u0004\b\u0019\u0010\u000bR\u001c\u0010\u001a\u001a\u0004\u0018\u00010\u00078\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u001a\u0010\t\u001a\u0004\b\u001b\u0010\u000bR\u001c\u0010\u001c\u001a\u0004\u0018\u00010\u00078\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u001c\u0010\t\u001a\u0004\b\u001d\u0010\u000bR\u001c\u0010\u001e\u001a\u0004\u0018\u00010\u00078\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u001e\u0010\t\u001a\u0004\b\u001f\u0010\u000bR\u001c\u0010 \u001a\u0004\u0018\u00010\u00078\u0007X\u0087\u0004¢\u0006\f\n\u0004\b \u0010\t\u001a\u0004\b!\u0010\u000bR\u001c\u0010#\u001a\u0004\u0018\u00010\"8\u0007X\u0087\u0004¢\u0006\f\n\u0004\b#\u0010$\u001a\u0004\b%\u0010&R\u001c\u0010'\u001a\u0004\u0018\u00010\u00078\u0007X\u0087\u0004¢\u0006\f\n\u0004\b'\u0010\t\u001a\u0004\b(\u0010\u000bR\u001c\u0010)\u001a\u0004\u0018\u00010\"8\u0007X\u0087\u0004¢\u0006\f\n\u0004\b)\u0010$\u001a\u0004\b*\u0010&R\u001c\u0010+\u001a\u0004\u0018\u00010\u00078\u0007X\u0087\u0004¢\u0006\f\n\u0004\b+\u0010\t\u001a\u0004\b,\u0010\u000bR\u001c\u0010-\u001a\u0004\u0018\u00010\"8\u0007X\u0087\u0004¢\u0006\f\n\u0004\b-\u0010$\u001a\u0004\b.\u0010&R\u001c\u0010/\u001a\u0004\u0018\u00010\"8\u0007X\u0087\u0004¢\u0006\f\n\u0004\b/\u0010$\u001a\u0004\b0\u0010&R\u001c\u00101\u001a\u0004\u0018\u00010\u00078\u0007X\u0087\u0004¢\u0006\f\n\u0004\b1\u0010\t\u001a\u0004\b2\u0010\u000bR\u001a\u00104\u001a\u0002038\u0007X\u0087\u0004¢\u0006\f\n\u0004\b4\u00105\u001a\u0004\b6\u00107R\u001c\u00108\u001a\u0004\u0018\u00010\u00078\u0007X\u0087\u0004¢\u0006\f\n\u0004\b8\u0010\t\u001a\u0004\b9\u0010\u000bR\u001c\u0010:\u001a\u0004\u0018\u00010\u00078\u0007X\u0087\u0004¢\u0006\f\n\u0004\b:\u0010\t\u001a\u0004\b;\u0010\u000bR\u001c\u0010<\u001a\u0004\u0018\u00010\u00078\u0007X\u0087\u0004¢\u0006\f\n\u0004\b<\u0010\t\u001a\u0004\b=\u0010\u000bR\u001c\u0010>\u001a\u0004\u0018\u00010\u00078\u0007X\u0087\u0004¢\u0006\f\n\u0004\b>\u0010\t\u001a\u0004\b?\u0010\u000bR\u001c\u0010@\u001a\u0004\u0018\u00010\u00078\u0007X\u0087\u0004¢\u0006\f\n\u0004\b@\u0010\t\u001a\u0004\bA\u0010\u000b"}, d2 = {"Lid/dana/data/config/source/sharedpreference/CdpContentModelEntityData;", "", "", "announcementCdpContentModels", "Ljava/util/List;", "getAnnouncementCdpContentModels", "()Ljava/util/List;", "", "announcementGoodsName", "Ljava/lang/String;", "getAnnouncementGoodsName", "()Ljava/lang/String;", "announcementPaymentStatus", "getAnnouncementPaymentStatus", "announcementSubMerchantId", "getAnnouncementSubMerchantId", "announcementSubscriptionDueDate", "getAnnouncementSubscriptionDueDate", "announcementSubtitle", "getAnnouncementSubtitle", "announcementTitle", "getAnnouncementTitle", "announcementTotalAmount", "getAnnouncementTotalAmount", "bizType", "getBizType", "contentId", "getContentId", "contentName", "getContentName", "contentType", "getContentType", "contentValue", "getContentValue", "Ljava/util/Date;", "effectiveDate", "Ljava/util/Date;", "getEffectiveDate", "()Ljava/util/Date;", "envType", "getEnvType", "expireDate", "getExpireDate", "extendInfo", "getExtendInfo", "gmtCreate", "getGmtCreate", "gmtModified", "getGmtModified", "language", ZolozEkycH5Handler.HUMMER_FOUNDATION_GET_LANGUAGE, "", "priority", "I", "getPriority", "()I", "redirectUrl", "getRedirectUrl", "selectRule", "getSelectRule", "spaceCode", "getSpaceCode", "status", "getStatus", HeaderConstant.HEADER_KEY_TENANT_ID, "getTenantId", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/Date;Ljava/lang/String;Ljava/util/Date;Ljava/util/Date;Ljava/util/Date;Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/lang/String;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes8.dex */
public final class CdpContentModelEntityData {
    private final List<CdpContentModelEntityData> announcementCdpContentModels;
    private final String announcementGoodsName;
    private final String announcementPaymentStatus;
    private final String announcementSubMerchantId;
    private final String announcementSubscriptionDueDate;
    private final String announcementSubtitle;
    private final String announcementTitle;
    private final String announcementTotalAmount;
    private final String bizType;
    private final String contentId;
    private final String contentName;
    private final String contentType;
    private final String contentValue;
    private final Date effectiveDate;
    private final String envType;
    private final Date expireDate;
    private final String extendInfo;
    private final Date gmtCreate;
    private final Date gmtModified;
    private final String language;
    private final int priority;
    private final String redirectUrl;
    private final String selectRule;
    private final String spaceCode;
    private final String status;
    private final String tenantId;

    public CdpContentModelEntityData(String str, String str2, String str3, String str4, String str5, Date date, String str6, Date date2, Date date3, Date date4, String str7, int i, String str8, String str9, String str10, String str11, String str12, String str13, String str14, String str15, String str16, String str17, String str18, String str19, List<CdpContentModelEntityData> list, String str20) {
        this.bizType = str;
        this.contentId = str2;
        this.contentName = str3;
        this.contentType = str4;
        this.contentValue = str5;
        this.effectiveDate = date;
        this.envType = str6;
        this.expireDate = date2;
        this.gmtCreate = date3;
        this.gmtModified = date4;
        this.language = str7;
        this.priority = i;
        this.redirectUrl = str8;
        this.selectRule = str9;
        this.spaceCode = str10;
        this.status = str11;
        this.tenantId = str12;
        this.announcementSubMerchantId = str13;
        this.announcementTitle = str14;
        this.announcementSubtitle = str15;
        this.announcementGoodsName = str16;
        this.announcementSubscriptionDueDate = str17;
        this.announcementPaymentStatus = str18;
        this.announcementTotalAmount = str19;
        this.announcementCdpContentModels = list;
        this.extendInfo = str20;
    }

    public /* synthetic */ CdpContentModelEntityData(String str, String str2, String str3, String str4, String str5, Date date, String str6, Date date2, Date date3, Date date4, String str7, int i, String str8, String str9, String str10, String str11, String str12, String str13, String str14, String str15, String str16, String str17, String str18, String str19, List list, String str20, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, str3, str4, str5, date, str6, date2, date3, date4, str7, (i2 & 2048) != 0 ? 0 : i, str8, str9, str10, str11, str12, str13, str14, str15, str16, str17, str18, str19, list, str20);
    }

    @JvmName(name = "getBizType")
    public final String getBizType() {
        return this.bizType;
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

    @JvmName(name = "getContentValue")
    public final String getContentValue() {
        return this.contentValue;
    }

    @JvmName(name = "getEffectiveDate")
    public final Date getEffectiveDate() {
        return this.effectiveDate;
    }

    @JvmName(name = "getEnvType")
    public final String getEnvType() {
        return this.envType;
    }

    @JvmName(name = "getExpireDate")
    public final Date getExpireDate() {
        return this.expireDate;
    }

    @JvmName(name = "getGmtCreate")
    public final Date getGmtCreate() {
        return this.gmtCreate;
    }

    @JvmName(name = "getGmtModified")
    public final Date getGmtModified() {
        return this.gmtModified;
    }

    @JvmName(name = ZolozEkycH5Handler.HUMMER_FOUNDATION_GET_LANGUAGE)
    public final String getLanguage() {
        return this.language;
    }

    @JvmName(name = "getPriority")
    public final int getPriority() {
        return this.priority;
    }

    @JvmName(name = "getRedirectUrl")
    public final String getRedirectUrl() {
        return this.redirectUrl;
    }

    @JvmName(name = "getSelectRule")
    public final String getSelectRule() {
        return this.selectRule;
    }

    @JvmName(name = "getSpaceCode")
    public final String getSpaceCode() {
        return this.spaceCode;
    }

    @JvmName(name = "getStatus")
    public final String getStatus() {
        return this.status;
    }

    @JvmName(name = "getTenantId")
    public final String getTenantId() {
        return this.tenantId;
    }

    @JvmName(name = "getAnnouncementSubMerchantId")
    public final String getAnnouncementSubMerchantId() {
        return this.announcementSubMerchantId;
    }

    @JvmName(name = "getAnnouncementTitle")
    public final String getAnnouncementTitle() {
        return this.announcementTitle;
    }

    @JvmName(name = "getAnnouncementSubtitle")
    public final String getAnnouncementSubtitle() {
        return this.announcementSubtitle;
    }

    @JvmName(name = "getAnnouncementGoodsName")
    public final String getAnnouncementGoodsName() {
        return this.announcementGoodsName;
    }

    @JvmName(name = "getAnnouncementSubscriptionDueDate")
    public final String getAnnouncementSubscriptionDueDate() {
        return this.announcementSubscriptionDueDate;
    }

    @JvmName(name = "getAnnouncementPaymentStatus")
    public final String getAnnouncementPaymentStatus() {
        return this.announcementPaymentStatus;
    }

    @JvmName(name = "getAnnouncementTotalAmount")
    public final String getAnnouncementTotalAmount() {
        return this.announcementTotalAmount;
    }

    @JvmName(name = "getAnnouncementCdpContentModels")
    public final List<CdpContentModelEntityData> getAnnouncementCdpContentModels() {
        return this.announcementCdpContentModels;
    }

    @JvmName(name = "getExtendInfo")
    public final String getExtendInfo() {
        return this.extendInfo;
    }
}
