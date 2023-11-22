package id.dana.data.cancelsurvey.model;

import id.dana.domain.cancelsurvey.model.CancellationSurveyConfig;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\b\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u000b\u001a\u00020\n\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0011\u0010\u0012J\r\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0003\u0010\u0004R\u0019\u0010\u0006\u001a\u0004\u0018\u00010\u00058\u0007¢\u0006\f\n\u0004\b\u0006\u0010\u0007\u001a\u0004\b\b\u0010\tR\u001a\u0010\u000b\u001a\u00020\n8\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000eR\u001c\u0010\u000f\u001a\u0004\u0018\u00010\u00058\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u000f\u0010\u0007\u001a\u0004\b\u0010\u0010\t"}, d2 = {"Lid/dana/data/cancelsurvey/model/CancellationSurveyConfigModel;", "Ljava/io/Serializable;", "Lid/dana/domain/cancelsurvey/model/CancellationSurveyConfig;", "toCancellationSurveyConfig", "()Lid/dana/domain/cancelsurvey/model/CancellationSurveyConfig;", "", "ctaText", "Ljava/lang/String;", "getCtaText", "()Ljava/lang/String;", "", "enable", "Z", "getEnable", "()Z", "headerText", "getHeaderText", "<init>", "(ZLjava/lang/String;Ljava/lang/String;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class CancellationSurveyConfigModel implements Serializable {
    public String ctaText;
    public boolean enable;
    public String headerText;

    public /* synthetic */ CancellationSurveyConfigModel() {
    }

    public CancellationSurveyConfigModel(boolean z, String str, String str2) {
        this.enable = z;
        this.headerText = str;
        this.ctaText = str2;
    }

    public /* synthetic */ CancellationSurveyConfigModel(boolean z, String str, String str2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(z, (i & 2) != 0 ? null : str, (i & 4) != 0 ? null : str2);
    }

    @JvmName(name = "getEnable")
    public final boolean getEnable() {
        return this.enable;
    }

    @JvmName(name = "getHeaderText")
    public final String getHeaderText() {
        return this.headerText;
    }

    @JvmName(name = "getCtaText")
    public final String getCtaText() {
        return this.ctaText;
    }

    public final CancellationSurveyConfig toCancellationSurveyConfig() {
        boolean z = this.enable;
        String str = this.headerText;
        if (str == null) {
            str = "";
        }
        String str2 = this.ctaText;
        return new CancellationSurveyConfig(z, str, str2 != null ? str2 : "");
    }
}
