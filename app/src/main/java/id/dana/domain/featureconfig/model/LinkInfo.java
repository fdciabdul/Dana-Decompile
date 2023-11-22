package id.dana.domain.featureconfig.model;

import com.alibaba.fastjson.annotation.JSONField;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u000e\u0018\u00002\u00020\u0001BA\u0012\b\b\u0003\u0010\u000b\u001a\u00020\u0002\u0012\n\b\u0003\u0010\u0007\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0003\u0010\t\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0003\u0010\r\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0003\u0010\u0003\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u000f\u0010\u0010R\u0019\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0007¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006R\u001c\u0010\t\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006R\u001a\u0010\u000b\u001a\u00020\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u000b\u0010\u0004\u001a\u0004\b\f\u0010\u0006R\u001c\u0010\r\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\r\u0010\u0004\u001a\u0004\b\u000e\u0010\u0006"}, d2 = {"Lid/dana/domain/featureconfig/model/LinkInfo;", "", "", "closedTagHyperlink", "Ljava/lang/String;", "getClosedTagHyperlink", "()Ljava/lang/String;", "enHyperlink", "getEnHyperlink", "idHyperlink", "getIdHyperlink", "link", "getLink", "openTagHyperlink", "getOpenTagHyperlink", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class LinkInfo {
    public String closedTagHyperlink;
    public String enHyperlink;
    public String idHyperlink;
    public String link;
    public String openTagHyperlink;

    public LinkInfo() {
        this(null, null, null, null, null, 31, null);
    }

    public LinkInfo(@JSONField(name = "link") String str, @JSONField(name = "en_hyperlink") String str2, @JSONField(name = "id_hyperlink") String str3, @JSONField(name = "open_tag_hyperlink") String str4, @JSONField(name = "closed_tag_hyperlink") String str5) {
        Intrinsics.checkNotNullParameter(str, "");
        this.link = str;
        this.enHyperlink = str2;
        this.idHyperlink = str3;
        this.openTagHyperlink = str4;
        this.closedTagHyperlink = str5;
    }

    public /* synthetic */ LinkInfo(String str, String str2, String str3, String str4, String str5, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? "" : str, (i & 2) != 0 ? "" : str2, (i & 4) != 0 ? "" : str3, (i & 8) != 0 ? "" : str4, (i & 16) != 0 ? "" : str5);
    }

    @JvmName(name = "getLink")
    public final String getLink() {
        return this.link;
    }

    @JvmName(name = "getEnHyperlink")
    public final String getEnHyperlink() {
        return this.enHyperlink;
    }

    @JvmName(name = "getIdHyperlink")
    public final String getIdHyperlink() {
        return this.idHyperlink;
    }

    @JvmName(name = "getOpenTagHyperlink")
    public final String getOpenTagHyperlink() {
        return this.openTagHyperlink;
    }

    @JvmName(name = "getClosedTagHyperlink")
    public final String getClosedTagHyperlink() {
        return this.closedTagHyperlink;
    }
}
