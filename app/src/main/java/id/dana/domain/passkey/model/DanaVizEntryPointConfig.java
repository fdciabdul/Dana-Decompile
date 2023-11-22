package id.dana.domain.passkey.model;

import com.alibaba.fastjson.annotation.JSONField;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\b\u0018\u00002\u00020\u0001B\u001b\u0012\b\b\u0003\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0003\u0010\u0007\u001a\u00020\u0002¢\u0006\u0004\b\t\u0010\nR\u001a\u0010\u0003\u001a\u00020\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\u0007\u001a\u00020\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006"}, d2 = {"Lid/dana/domain/passkey/model/DanaVizEntryPointConfig;", "", "", "danaVizPromptPage", "Z", "getDanaVizPromptPage", "()Z", "passkeyEnrollment", "getPasskeyEnrollment", "<init>", "(ZZ)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class DanaVizEntryPointConfig {
    @SerializedName("dana_viz_prompt_page")
    private final boolean danaVizPromptPage;
    @SerializedName("passkey_enrollment")
    private final boolean passkeyEnrollment;

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public DanaVizEntryPointConfig() {
        /*
            r3 = this;
            r0 = 0
            r1 = 3
            r2 = 0
            r3.<init>(r0, r0, r1, r2)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.domain.passkey.model.DanaVizEntryPointConfig.<init>():void");
    }

    public DanaVizEntryPointConfig(@JSONField(name = "dana_viz_prompt_page") boolean z, @JSONField(name = "passkey_enrollment") boolean z2) {
        this.danaVizPromptPage = z;
        this.passkeyEnrollment = z2;
    }

    public /* synthetic */ DanaVizEntryPointConfig(boolean z, boolean z2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? false : z, (i & 2) != 0 ? false : z2);
    }

    @JvmName(name = "getDanaVizPromptPage")
    public final boolean getDanaVizPromptPage() {
        return this.danaVizPromptPage;
    }

    @JvmName(name = "getPasskeyEnrollment")
    public final boolean getPasskeyEnrollment() {
        return this.passkeyEnrollment;
    }
}
