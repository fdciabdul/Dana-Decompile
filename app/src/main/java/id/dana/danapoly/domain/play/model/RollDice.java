package id.dana.danapoly.domain.play.model;

import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0006\u0018\u00002\u00020\u0001B=\u0012\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u0007\u0012\u0006\u0010\u0017\u001a\u00020\u0016\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u000e\u001a\u00020\r\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\r¢\u0006\u0004\b\u001b\u0010\u001cR\u0017\u0010\u0003\u001a\u00020\u00028\u0007¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R \u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u00078\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u001a\u0010\u000e\u001a\u00020\r8\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R\u001c\u0010\u0012\u001a\u0004\u0018\u00010\r8\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015R\u001a\u0010\u0017\u001a\u00020\u00168\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001a"}, d2 = {"Lid/dana/danapoly/domain/play/model/RollDice;", "", "", "currencyType", "Ljava/lang/String;", "getCurrencyType", "()Ljava/lang/String;", "", "Lid/dana/danapoly/domain/play/model/Play;", "results", "Ljava/util/List;", "getResults", "()Ljava/util/List;", "", "userCurrentFund", "I", "getUserCurrentFund", "()I", "userCurrentLap", "Ljava/lang/Integer;", "getUserCurrentLap", "()Ljava/lang/Integer;", "", "usingFreeAttempt", "Z", "getUsingFreeAttempt", "()Z", "<init>", "(Ljava/util/List;ZLjava/lang/String;ILjava/lang/Integer;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class RollDice {
    private final String currencyType;
    private final List<Play> results;
    private final int userCurrentFund;
    private final Integer userCurrentLap;
    private final boolean usingFreeAttempt;

    public RollDice(List<Play> list, boolean z, String str, int i, Integer num) {
        Intrinsics.checkNotNullParameter(list, "");
        Intrinsics.checkNotNullParameter(str, "");
        this.results = list;
        this.usingFreeAttempt = z;
        this.currencyType = str;
        this.userCurrentFund = i;
        this.userCurrentLap = num;
    }

    public /* synthetic */ RollDice(List list, boolean z, String str, int i, Integer num, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(list, z, (i2 & 4) != 0 ? "" : str, (i2 & 8) != 0 ? 0 : i, (i2 & 16) != 0 ? null : num);
    }

    @JvmName(name = "getResults")
    public final List<Play> getResults() {
        return this.results;
    }

    @JvmName(name = "getUsingFreeAttempt")
    public final boolean getUsingFreeAttempt() {
        return this.usingFreeAttempt;
    }

    @JvmName(name = "getCurrencyType")
    public final String getCurrencyType() {
        return this.currencyType;
    }

    @JvmName(name = "getUserCurrentFund")
    public final int getUserCurrentFund() {
        return this.userCurrentFund;
    }

    @JvmName(name = "getUserCurrentLap")
    public final Integer getUserCurrentLap() {
        return this.userCurrentLap;
    }
}
