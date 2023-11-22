package id.dana.data.config.source.sharedpreference;

import com.alibaba.ariver.remotedebug.utils.TinyAppLogUtil;
import java.util.Date;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.JvmName;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u0014\u0018\u00002\u00020\u0001B\u00ad\u0001\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\u000e\u0010\t\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\r\u0012\b\u0010\u0012\u001a\u0004\u0018\u00010\r\u0012\b\u0010\u0014\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0016\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0019\u001a\u0004\u0018\u00010\u0018\u0012\b\u0010\u001d\u001a\u0004\u0018\u00010\u0018\u0012\b\u0010 \u001a\u0004\u0018\u00010\u001f\u0012\b\u0010$\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010&\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010(\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010*\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010,\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010.\u001a\u0004\u0018\u00010\u0002\u0012\b\u00100\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b2\u00103R\u0019\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0007¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\"\u0010\t\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u00078\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u001c\u0010\u000e\u001a\u0004\u0018\u00010\r8\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R\u001c\u0010\u0012\u001a\u0004\u0018\u00010\r8\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0012\u0010\u000f\u001a\u0004\b\u0013\u0010\u0011R\u001c\u0010\u0014\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0014\u0010\u0004\u001a\u0004\b\u0015\u0010\u0006R\u001c\u0010\u0016\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0016\u0010\u0004\u001a\u0004\b\u0017\u0010\u0006R\u001c\u0010\u0019\u001a\u0004\u0018\u00010\u00188\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u001cR\u001c\u0010\u001d\u001a\u0004\u0018\u00010\u00188\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u001d\u0010\u001a\u001a\u0004\b\u001e\u0010\u001cR\u001c\u0010 \u001a\u0004\u0018\u00010\u001f8\u0007X\u0087\u0004¢\u0006\f\n\u0004\b \u0010!\u001a\u0004\b\"\u0010#R\u001c\u0010$\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b$\u0010\u0004\u001a\u0004\b%\u0010\u0006R\u001c\u0010&\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b&\u0010\u0004\u001a\u0004\b'\u0010\u0006R\u001c\u0010(\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b(\u0010\u0004\u001a\u0004\b)\u0010\u0006R\u001c\u0010*\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b*\u0010\u0004\u001a\u0004\b+\u0010\u0006R\u001c\u0010,\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b,\u0010\u0004\u001a\u0004\b-\u0010\u0006R\u001c\u0010.\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b.\u0010\u0004\u001a\u0004\b/\u0010\u0006R\u001c\u00100\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b0\u0010\u0004\u001a\u0004\b1\u0010\u0006"}, d2 = {"Lid/dana/data/config/source/sharedpreference/PromotionModelEntityData;", "", "", "allowedContent", "Ljava/lang/String;", "getAllowedContent", "()Ljava/lang/String;", "", "Lid/dana/data/config/source/sharedpreference/CdpContentModelEntityData;", "cdpContentModels", "Ljava/util/List;", "getCdpContentModels", "()Ljava/util/List;", "", "contentNumLimit", "Ljava/lang/Integer;", "getContentNumLimit", "()Ljava/lang/Integer;", "contentTextLimit", "getContentTextLimit", "defaultLang", "getDefaultLang", "displayStrategy", "getDisplayStrategy", "Ljava/util/Date;", "gmtCreate", "Ljava/util/Date;", "getGmtCreate", "()Ljava/util/Date;", "gmtModified", "getGmtModified", "", "marqueeTime", "Ljava/lang/Long;", "getMarqueeTime", "()Ljava/lang/Long;", TinyAppLogUtil.TINY_APP_STANDARD_EXTRA_PLATFORM, "getPlatform", "spaceCode", "getSpaceCode", "spaceName", "getSpaceName", "spaceType", "getSpaceType", "spm", "getSpm", "status", "getStatus", "whiteList", "getWhiteList", "<init>", "(Ljava/lang/String;Ljava/util/List;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/util/Date;Ljava/util/Date;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes8.dex */
public final class PromotionModelEntityData {
    private final String allowedContent;
    private final List<CdpContentModelEntityData> cdpContentModels;
    private final Integer contentNumLimit;
    private final Integer contentTextLimit;
    private final String defaultLang;
    private final String displayStrategy;
    private final Date gmtCreate;
    private final Date gmtModified;
    private final Long marqueeTime;
    private final String platform;
    private final String spaceCode;
    private final String spaceName;
    private final String spaceType;
    private final String spm;
    private final String status;
    private final String whiteList;

    public PromotionModelEntityData(String str, List<CdpContentModelEntityData> list, Integer num, Integer num2, String str2, String str3, Date date, Date date2, Long l, String str4, String str5, String str6, String str7, String str8, String str9, String str10) {
        this.allowedContent = str;
        this.cdpContentModels = list;
        this.contentNumLimit = num;
        this.contentTextLimit = num2;
        this.defaultLang = str2;
        this.displayStrategy = str3;
        this.gmtCreate = date;
        this.gmtModified = date2;
        this.marqueeTime = l;
        this.platform = str4;
        this.spaceCode = str5;
        this.spaceName = str6;
        this.spaceType = str7;
        this.spm = str8;
        this.status = str9;
        this.whiteList = str10;
    }

    @JvmName(name = "getAllowedContent")
    public final String getAllowedContent() {
        return this.allowedContent;
    }

    @JvmName(name = "getCdpContentModels")
    public final List<CdpContentModelEntityData> getCdpContentModels() {
        return this.cdpContentModels;
    }

    @JvmName(name = "getContentNumLimit")
    public final Integer getContentNumLimit() {
        return this.contentNumLimit;
    }

    @JvmName(name = "getContentTextLimit")
    public final Integer getContentTextLimit() {
        return this.contentTextLimit;
    }

    @JvmName(name = "getDefaultLang")
    public final String getDefaultLang() {
        return this.defaultLang;
    }

    @JvmName(name = "getDisplayStrategy")
    public final String getDisplayStrategy() {
        return this.displayStrategy;
    }

    @JvmName(name = "getGmtCreate")
    public final Date getGmtCreate() {
        return this.gmtCreate;
    }

    @JvmName(name = "getGmtModified")
    public final Date getGmtModified() {
        return this.gmtModified;
    }

    @JvmName(name = "getMarqueeTime")
    public final Long getMarqueeTime() {
        return this.marqueeTime;
    }

    @JvmName(name = "getPlatform")
    public final String getPlatform() {
        return this.platform;
    }

    @JvmName(name = "getSpaceCode")
    public final String getSpaceCode() {
        return this.spaceCode;
    }

    @JvmName(name = "getSpaceName")
    public final String getSpaceName() {
        return this.spaceName;
    }

    @JvmName(name = "getSpaceType")
    public final String getSpaceType() {
        return this.spaceType;
    }

    @JvmName(name = "getSpm")
    public final String getSpm() {
        return this.spm;
    }

    @JvmName(name = "getStatus")
    public final String getStatus() {
        return this.status;
    }

    @JvmName(name = "getWhiteList")
    public final String getWhiteList() {
        return this.whiteList;
    }
}
