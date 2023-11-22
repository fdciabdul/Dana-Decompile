package id.dana.domain.featureconfig.model;

import com.alibaba.fastjson.annotation.JSONField;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B7\u0012\b\b\u0002\u0010\b\u001a\u00020\u0007\u0012\b\b\u0003\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0003\u0010\f\u001a\u00020\u0002\u0012\u0010\b\u0003\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000e¢\u0006\u0004\b\u0014\u0010\u0015R\u0017\u0010\u0003\u001a\u00020\u00028\u0007¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\b\u001a\u00020\u00078\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u001a\u0010\f\u001a\u00020\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\f\u0010\u0004\u001a\u0004\b\r\u0010\u0006R\"\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000e8\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013"}, d2 = {"Lid/dana/domain/featureconfig/model/OnboardingWarningTextConfig;", "", "", "enTitle", "Ljava/lang/String;", "getEnTitle", "()Ljava/lang/String;", "", "enable", "Z", "getEnable", "()Z", "idTitle", "getIdTitle", "", "Lid/dana/domain/featureconfig/model/LinkInfo;", "linkInfo", "Ljava/util/List;", "getLinkInfo", "()Ljava/util/List;", "<init>", "(ZLjava/lang/String;Ljava/lang/String;Ljava/util/List;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class OnboardingWarningTextConfig {
    public String enTitle;
    public boolean enable;
    public String idTitle;
    public List<LinkInfo> linkInfo;

    public OnboardingWarningTextConfig() {
        this(false, null, null, null, 15, null);
    }

    public OnboardingWarningTextConfig(boolean z, @JSONField(name = "en_title") String str, @JSONField(name = "id_title") String str2, @JSONField(name = "link_info") List<LinkInfo> list) {
        Intrinsics.checkNotNullParameter(str, "");
        Intrinsics.checkNotNullParameter(str2, "");
        this.enable = z;
        this.enTitle = str;
        this.idTitle = str2;
        this.linkInfo = list;
    }

    @JvmName(name = "getEnable")
    public final boolean getEnable() {
        return this.enable;
    }

    @JvmName(name = "getEnTitle")
    public final String getEnTitle() {
        return this.enTitle;
    }

    @JvmName(name = "getIdTitle")
    public final String getIdTitle() {
        return this.idTitle;
    }

    public /* synthetic */ OnboardingWarningTextConfig(boolean z, String str, String str2, List list, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? false : z, (i & 2) != 0 ? "" : str, (i & 4) != 0 ? "" : str2, (i & 8) != 0 ? CollectionsKt.emptyList() : list);
    }

    @JvmName(name = "getLinkInfo")
    public final List<LinkInfo> getLinkInfo() {
        return this.linkInfo;
    }
}
