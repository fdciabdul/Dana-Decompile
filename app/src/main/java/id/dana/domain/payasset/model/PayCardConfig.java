package id.dana.domain.payasset.model;

import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\n\u0018\u00002\u00020\u0001B%\u0012\b\b\u0002\u0010\t\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u000b\u0010\fR\u0017\u0010\u0003\u001a\u00020\u00028\u0007¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\u0007\u001a\u00020\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006R\u001a\u0010\t\u001a\u00020\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006"}, d2 = {"Lid/dana/domain/payasset/model/PayCardConfig;", "", "", "enableAddNewCard", "Z", "getEnableAddNewCard", "()Z", "focusFirstCard", "getFocusFirstCard", "scannerEnable", "getScannerEnable", "<init>", "(ZZZ)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class PayCardConfig {
    private final boolean enableAddNewCard;
    private final boolean focusFirstCard;
    private final boolean scannerEnable;

    public PayCardConfig() {
        this(false, false, false, 7, null);
    }

    public PayCardConfig(boolean z, boolean z2, boolean z3) {
        this.scannerEnable = z;
        this.focusFirstCard = z2;
        this.enableAddNewCard = z3;
    }

    public /* synthetic */ PayCardConfig(boolean z, boolean z2, boolean z3, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? true : z, (i & 2) != 0 ? true : z2, (i & 4) != 0 ? false : z3);
    }

    @JvmName(name = "getScannerEnable")
    public final boolean getScannerEnable() {
        return this.scannerEnable;
    }

    @JvmName(name = "getFocusFirstCard")
    public final boolean getFocusFirstCard() {
        return this.focusFirstCard;
    }

    @JvmName(name = "getEnableAddNewCard")
    public final boolean getEnableAddNewCard() {
        return this.enableAddNewCard;
    }
}
