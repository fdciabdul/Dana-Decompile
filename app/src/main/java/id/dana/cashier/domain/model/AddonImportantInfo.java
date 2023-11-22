package id.dana.cashier.domain.model;

import kotlin.Metadata;
import kotlin.jvm.JvmName;

@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\b\u0018\u00002\u00020\u0001B\u001b\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\t\u0010\nR\u0019\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0007¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006"}, d2 = {"Lid/dana/cashier/domain/model/AddonImportantInfo;", "", "", "infoIcon", "Ljava/lang/String;", "getInfoIcon", "()Ljava/lang/String;", "infoValue", "getInfoValue", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class AddonImportantInfo {
    private final String infoIcon;
    private final String infoValue;

    public AddonImportantInfo(String str, String str2) {
        this.infoIcon = str;
        this.infoValue = str2;
    }

    @JvmName(name = "getInfoIcon")
    public final String getInfoIcon() {
        return this.infoIcon;
    }

    @JvmName(name = "getInfoValue")
    public final String getInfoValue() {
        return this.infoValue;
    }
}
