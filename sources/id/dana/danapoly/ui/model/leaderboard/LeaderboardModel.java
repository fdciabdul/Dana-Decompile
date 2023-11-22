package id.dana.danapoly.ui.model.leaderboard;

import id.dana.data.account.repository.AccountEntityRepository;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0012\u0018\u0000 \u001d2\u00020\u0001:\u0001\u001dBM\u0012\b\b\u0002\u0010\u0015\u001a\u00020\u000b\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0013\u001a\u00020\u0006\u0012\b\b\u0002\u0010\f\u001a\u00020\u000b\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0019\u001a\u00020\u000b\u0012\b\b\u0002\u0010\u0017\u001a\u00020\u000b¢\u0006\u0004\b\u001b\u0010\u001cJ\r\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\r\u0010\u0005\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0004R\u0017\u0010\u0007\u001a\u00020\u00068\u0007¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\t\u0010\nR\u001a\u0010\f\u001a\u00020\u000b8\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0010\u001a\u00020\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0004R\u001a\u0010\u0013\u001a\u00020\u00068\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0013\u0010\b\u001a\u0004\b\u0014\u0010\nR\u001a\u0010\u0015\u001a\u00020\u000b8\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0015\u0010\r\u001a\u0004\b\u0016\u0010\u000fR\u001a\u0010\u0017\u001a\u00020\u000b8\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0017\u0010\r\u001a\u0004\b\u0018\u0010\u000fR\u001a\u0010\u0019\u001a\u00020\u000b8\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0019\u0010\r\u001a\u0004\b\u001a\u0010\u000f"}, d2 = {"Lid/dana/danapoly/ui/model/leaderboard/LeaderboardModel;", "", "", "myselfNotBig10", "()Z", "shouldShowBottomDivider", "", AccountEntityRepository.UpdateType.AVATAR, "Ljava/lang/String;", "getAvatarUrl", "()Ljava/lang/String;", "", "laps", "I", "getLaps", "()I", "myself", "Z", "getMyself", "name", "getName", "rank", "getRank", "type", "getType", "usersAboveMe", "getUsersAboveMe", "<init>", "(ILjava/lang/String;Ljava/lang/String;IZII)V", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class LeaderboardModel {

    /* renamed from: Companion  reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final String avatarUrl;
    private final int laps;
    private final boolean myself;
    private final String name;
    private final int rank;
    private final int type;
    private final int usersAboveMe;

    public LeaderboardModel() {
        this(0, null, null, 0, false, 0, 0, 127, null);
    }

    public LeaderboardModel(int i, String str, String str2, int i2, boolean z, int i3, int i4) {
        Intrinsics.checkNotNullParameter(str, "");
        Intrinsics.checkNotNullParameter(str2, "");
        this.rank = i;
        this.avatarUrl = str;
        this.name = str2;
        this.laps = i2;
        this.myself = z;
        this.usersAboveMe = i3;
        this.type = i4;
    }

    public /* synthetic */ LeaderboardModel(int i, String str, String str2, int i2, boolean z, int i3, int i4, int i5, DefaultConstructorMarker defaultConstructorMarker) {
        this((i5 & 1) != 0 ? 0 : i, (i5 & 2) != 0 ? "" : str, (i5 & 4) == 0 ? str2 : "", (i5 & 8) != 0 ? 0 : i2, (i5 & 16) != 0 ? false : z, (i5 & 32) != 0 ? 0 : i3, (i5 & 64) != 0 ? 0 : i4);
    }

    @JvmName(name = "getRank")
    public final int getRank() {
        return this.rank;
    }

    @JvmName(name = "getAvatarUrl")
    public final String getAvatarUrl() {
        return this.avatarUrl;
    }

    @JvmName(name = "getName")
    public final String getName() {
        return this.name;
    }

    @JvmName(name = "getLaps")
    public final int getLaps() {
        return this.laps;
    }

    @JvmName(name = "getMyself")
    public final boolean getMyself() {
        return this.myself;
    }

    @JvmName(name = "getUsersAboveMe")
    public final int getUsersAboveMe() {
        return this.usersAboveMe;
    }

    @JvmName(name = "getType")
    public final int getType() {
        return this.type;
    }

    public final boolean shouldShowBottomDivider() {
        return this.rank == 10;
    }

    public final boolean myselfNotBig10() {
        return this.myself && this.rank > 11;
    }

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u0015\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"Lid/dana/danapoly/ui/model/leaderboard/LeaderboardModel$Companion;", "", "", "usersAboveMe", "Lid/dana/danapoly/ui/model/leaderboard/LeaderboardModel;", "generateDivider", "(I)Lid/dana/danapoly/ui/model/leaderboard/LeaderboardModel;", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes4.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final LeaderboardModel generateDivider(int usersAboveMe) {
            return new LeaderboardModel(0, null, null, 0, false, usersAboveMe, 1, 31, null);
        }
    }
}
