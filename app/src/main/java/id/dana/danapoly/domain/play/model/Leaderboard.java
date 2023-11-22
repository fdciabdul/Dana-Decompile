package id.dana.danapoly.domain.play.model;

import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0006\u0018\u00002\u00020\u0001B/\u0012\b\b\u0002\u0010\b\u001a\u00020\u0007\u0012\b\b\u0002\u0010\f\u001a\u00020\u0007\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u000e\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0013\u0010\u0014R\u0017\u0010\u0003\u001a\u00020\u00028\u0007¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\b\u001a\u00020\u00078\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u001a\u0010\f\u001a\u00020\u00078\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\f\u0010\t\u001a\u0004\b\r\u0010\u000bR\u001a\u0010\u000f\u001a\u00020\u000e8\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012"}, d2 = {"Lid/dana/danapoly/domain/play/model/Leaderboard;", "", "", "myself", "Z", "getMyself", "()Z", "", "name", "Ljava/lang/String;", "getName", "()Ljava/lang/String;", "photoUrl", "getPhotoUrl", "", "rankIdentifierValue", "I", "getRankIdentifierValue", "()I", "<init>", "(Ljava/lang/String;Ljava/lang/String;IZ)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class Leaderboard {
    private final boolean myself;
    private final String name;
    private final String photoUrl;
    private final int rankIdentifierValue;

    public Leaderboard() {
        this(null, null, 0, false, 15, null);
    }

    public Leaderboard(String str, String str2, int i, boolean z) {
        Intrinsics.checkNotNullParameter(str, "");
        Intrinsics.checkNotNullParameter(str2, "");
        this.name = str;
        this.photoUrl = str2;
        this.rankIdentifierValue = i;
        this.myself = z;
    }

    public /* synthetic */ Leaderboard(String str, String str2, int i, boolean z, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? "" : str, (i2 & 2) != 0 ? "" : str2, (i2 & 4) != 0 ? 0 : i, (i2 & 8) != 0 ? false : z);
    }

    @JvmName(name = "getName")
    public final String getName() {
        return this.name;
    }

    @JvmName(name = "getPhotoUrl")
    public final String getPhotoUrl() {
        return this.photoUrl;
    }

    @JvmName(name = "getRankIdentifierValue")
    public final int getRankIdentifierValue() {
        return this.rankIdentifierValue;
    }

    @JvmName(name = "getMyself")
    public final boolean getMyself() {
        return this.myself;
    }
}
