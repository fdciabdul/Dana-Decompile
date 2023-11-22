package id.dana.core.ui.constant;

import id.dana.core.ui.R;
import kotlin.Metadata;
import kotlin.jvm.JvmName;

@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\r\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0007\u0010\bR\u0017\u0010\u0003\u001a\u00020\u00028\u0007¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000f"}, d2 = {"Lid/dana/core/ui/constant/DialogType;", "", "", "icon", "I", "getIcon", "()I", "<init>", "(Ljava/lang/String;II)V", "SUCCESS", "WAITING", "WARNING", "ACCOUNT_LOCK", "FAILED", "PIN_LOCK", "EMPTY"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes.dex */
public enum DialogType {
    SUCCESS(R.drawable.SubSequence),
    WAITING(R.drawable.ic_loading_bg),
    WARNING(R.drawable.ic_warning_14),
    ACCOUNT_LOCK(R.drawable.res_0x7f080a0e_networkuserentitydata_externalsyntheticlambda5),
    FAILED(R.drawable.res_0x7f08065e_networkuserentitydata_externalsyntheticlambda1),
    PIN_LOCK(R.drawable.res_0x7f080a0f_networkuserentitydata_externalsyntheticlambda6),
    EMPTY(0);

    private final int icon;

    DialogType(int i) {
        this.icon = i;
    }

    @JvmName(name = "getIcon")
    public final int getIcon() {
        return this.icon;
    }
}
