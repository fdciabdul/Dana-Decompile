package id.dana.data.config.model;

import kotlin.Metadata;
import kotlin.jvm.JvmName;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\n\u001a\u00020\t¢\u0006\u0004\b\u0010\u0010\u0011R\"\u0010\u0003\u001a\u00020\u00028\u0007@\u0007X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\n\u001a\u00020\t8\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000f"}, d2 = {"Lid/dana/data/config/model/FullstoryConfigModel;", "", "", "enable", "Z", "getEnable", "()Z", "setEnable", "(Z)V", "", "maxSessionPerDay", "I", "getMaxSessionPerDay", "()I", "setMaxSessionPerDay", "(I)V", "<init>", "(ZI)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class FullstoryConfigModel {
    private boolean enable;
    private int maxSessionPerDay;

    public FullstoryConfigModel(boolean z, int i) {
        this.enable = z;
        this.maxSessionPerDay = i;
    }

    @JvmName(name = "getEnable")
    public final boolean getEnable() {
        return this.enable;
    }

    @JvmName(name = "setEnable")
    public final void setEnable(boolean z) {
        this.enable = z;
    }

    @JvmName(name = "getMaxSessionPerDay")
    public final int getMaxSessionPerDay() {
        return this.maxSessionPerDay;
    }

    @JvmName(name = "setMaxSessionPerDay")
    public final void setMaxSessionPerDay(int i) {
        this.maxSessionPerDay = i;
    }
}
