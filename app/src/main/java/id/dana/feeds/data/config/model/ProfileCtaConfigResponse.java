package id.dana.feeds.data.config.model;

import com.google.gson.annotations.SerializedName;
import id.dana.feeds.domain.config.model.ProfileCtaConfig;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u000e\u0018\u00002\u00020\u0001BO\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\f\u0012\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\f\u0012\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\f\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\f\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\f\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0019\u0010\u001aJ\r\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0003\u0010\u0004R$\u0010\u0006\u001a\u0004\u0018\u00010\u00058\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0006\u0010\u0007\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001c\u0010\r\u001a\u0004\u0018\u00010\f8\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R\u001c\u0010\u0011\u001a\u0004\u0018\u00010\f8\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0011\u0010\u000e\u001a\u0004\b\u0012\u0010\u0010R\u001c\u0010\u0013\u001a\u0004\u0018\u00010\f8\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0013\u0010\u000e\u001a\u0004\b\u0014\u0010\u0010R\u001c\u0010\u0015\u001a\u0004\u0018\u00010\f8\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0015\u0010\u000e\u001a\u0004\b\u0016\u0010\u0010R\u001c\u0010\u0017\u001a\u0004\u0018\u00010\f8\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0017\u0010\u000e\u001a\u0004\b\u0018\u0010\u0010"}, d2 = {"Lid/dana/feeds/data/config/model/ProfileCtaConfigResponse;", "", "Lid/dana/feeds/domain/config/model/ProfileCtaConfig;", "toProfileCtaConfig", "()Lid/dana/feeds/domain/config/model/ProfileCtaConfig;", "", "enable", "Ljava/lang/Boolean;", "getEnable", "()Ljava/lang/Boolean;", "setEnable", "(Ljava/lang/Boolean;)V", "", "icon", "Ljava/lang/String;", "getIcon", "()Ljava/lang/String;", "key", "getKey", "redirectUrl", "getRedirectUrl", "titleEn", "getTitleEn", "titleId", "getTitleId", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class ProfileCtaConfigResponse {
    @SerializedName("enable")
    private Boolean enable;
    @SerializedName("icon")
    private final String icon;
    @SerializedName("key")
    private final String key;
    @SerializedName("redirectUrl")
    private final String redirectUrl;
    @SerializedName("title_en")
    private final String titleEn;
    @SerializedName("title_id")
    private final String titleId;

    public ProfileCtaConfigResponse() {
        this(null, null, null, null, null, null, 63, null);
    }

    public ProfileCtaConfigResponse(String str, String str2, String str3, String str4, String str5, Boolean bool) {
        this.key = str;
        this.titleId = str2;
        this.titleEn = str3;
        this.icon = str4;
        this.redirectUrl = str5;
        this.enable = bool;
    }

    @JvmName(name = "getKey")
    public final String getKey() {
        return this.key;
    }

    @JvmName(name = "getTitleId")
    public final String getTitleId() {
        return this.titleId;
    }

    @JvmName(name = "getTitleEn")
    public final String getTitleEn() {
        return this.titleEn;
    }

    @JvmName(name = "getIcon")
    public final String getIcon() {
        return this.icon;
    }

    @JvmName(name = "getRedirectUrl")
    public final String getRedirectUrl() {
        return this.redirectUrl;
    }

    public /* synthetic */ ProfileCtaConfigResponse(String str, String str2, String str3, String str4, String str5, Boolean bool, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? "" : str, (i & 2) != 0 ? "" : str2, (i & 4) != 0 ? "" : str3, (i & 8) != 0 ? "" : str4, (i & 16) == 0 ? str5 : "", (i & 32) != 0 ? Boolean.FALSE : bool);
    }

    @JvmName(name = "getEnable")
    public final Boolean getEnable() {
        return this.enable;
    }

    @JvmName(name = "setEnable")
    public final void setEnable(Boolean bool) {
        this.enable = bool;
    }

    public final ProfileCtaConfig toProfileCtaConfig() {
        String str = this.key;
        String str2 = str == null ? "" : str;
        String str3 = this.titleId;
        String str4 = str3 == null ? "" : str3;
        String str5 = this.titleEn;
        String str6 = str5 == null ? "" : str5;
        String str7 = this.icon;
        String str8 = str7 == null ? "" : str7;
        String str9 = this.redirectUrl;
        String str10 = str9 == null ? "" : str9;
        Boolean bool = this.enable;
        return new ProfileCtaConfig(str2, str4, str6, str8, str10, bool != null ? bool.booleanValue() : false);
    }
}
