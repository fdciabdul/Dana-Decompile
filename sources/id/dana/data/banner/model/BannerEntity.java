package id.dana.data.banner.model;

import java.util.Date;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\n\u0018\u00002\u00020\u0001B\u008b\u0001\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u000f\u0012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u000f\u0012\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u0018¢\u0006\u0004\b!\u0010\"R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006R\u001c\u0010\t\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006R\u001c\u0010\u000b\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u000b\u0010\u0004\u001a\u0004\b\f\u0010\u0006R\u001c\u0010\r\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\r\u0010\u0004\u001a\u0004\b\u000e\u0010\u0006R\u001c\u0010\u0010\u001a\u0004\u0018\u00010\u000f8\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013R\u001c\u0010\u0014\u001a\u0004\u0018\u00010\u000f8\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0014\u0010\u0011\u001a\u0004\b\u0015\u0010\u0013R\u001c\u0010\u0016\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0016\u0010\u0004\u001a\u0004\b\u0017\u0010\u0006R\u001c\u0010\u0019\u001a\u0004\u0018\u00010\u00188\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u001cR\u001c\u0010\u001d\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u001d\u0010\u0004\u001a\u0004\b\u001e\u0010\u0006R\u001c\u0010\u001f\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u001f\u0010\u0004\u001a\u0004\b \u0010\u0006"}, d2 = {"Lid/dana/data/banner/model/BannerEntity;", "", "", "bizType", "Ljava/lang/String;", "getBizType", "()Ljava/lang/String;", "contentId", "getContentId", "contentName", "getContentName", "contentType", "getContentType", "contentValue", "getContentValue", "Ljava/util/Date;", "effectiveDate", "Ljava/util/Date;", "getEffectiveDate", "()Ljava/util/Date;", "expireDate", "getExpireDate", "extendInfo", "getExtendInfo", "", "priority", "Ljava/lang/Integer;", "getPriority", "()Ljava/lang/Integer;", "redirectUrl", "getRedirectUrl", "status", "getStatus", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/Date;Ljava/util/Date;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class BannerEntity {
    public String bizType;
    public String contentId;
    public String contentName;
    public String contentType;
    public String contentValue;
    public Date effectiveDate;
    public Date expireDate;
    public String extendInfo;
    public Integer priority;
    public String redirectUrl;
    public String status;

    public BannerEntity() {
        this(null, null, null, null, null, null, null, null, null, null, null, 2047, null);
    }

    public BannerEntity(String str, String str2, String str3, String str4, String str5, Date date, Date date2, String str6, String str7, String str8, Integer num) {
        this.bizType = str;
        this.contentId = str2;
        this.contentName = str3;
        this.contentType = str4;
        this.contentValue = str5;
        this.effectiveDate = date;
        this.expireDate = date2;
        this.extendInfo = str6;
        this.redirectUrl = str7;
        this.status = str8;
        this.priority = num;
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

    @JvmName(name = "getExpireDate")
    public final Date getExpireDate() {
        return this.expireDate;
    }

    @JvmName(name = "getExtendInfo")
    public final String getExtendInfo() {
        return this.extendInfo;
    }

    @JvmName(name = "getRedirectUrl")
    public final String getRedirectUrl() {
        return this.redirectUrl;
    }

    @JvmName(name = "getStatus")
    public final String getStatus() {
        return this.status;
    }

    public /* synthetic */ BannerEntity(String str, String str2, String str3, String str4, String str5, Date date, Date date2, String str6, String str7, String str8, Integer num, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? "" : str, (i & 2) != 0 ? "" : str2, (i & 4) != 0 ? "" : str3, (i & 8) != 0 ? "" : str4, (i & 16) != 0 ? "" : str5, (i & 32) != 0 ? null : date, (i & 64) == 0 ? date2 : null, (i & 128) != 0 ? "" : str6, (i & 256) != 0 ? "" : str7, (i & 512) == 0 ? str8 : "", (i & 1024) != 0 ? 0 : num);
    }

    @JvmName(name = "getPriority")
    public final Integer getPriority() {
        return this.priority;
    }
}
