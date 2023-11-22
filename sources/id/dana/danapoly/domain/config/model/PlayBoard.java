package id.dana.danapoly.domain.config.model;

import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\b\u0018\u00002\u00020\u0001B/\u0012\u0006\u0010\u000e\u001a\u00020\r\u0012\u0006\u0010\t\u001a\u00020\b\u0012\b\b\u0002\u0010\u0012\u001a\u00020\b\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002¢\u0006\u0004\b\u0014\u0010\u0015R\u001d\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0007¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007R\u001a\u0010\t\u001a\u00020\b8\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u001a\u0010\u000e\u001a\u00020\r8\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0012\u001a\u00020\b8\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0012\u0010\n\u001a\u0004\b\u0013\u0010\f"}, d2 = {"Lid/dana/danapoly/domain/config/model/PlayBoard;", "", "", "Lid/dana/danapoly/domain/config/model/Board;", "boards", "Ljava/util/List;", "getBoards", "()Ljava/util/List;", "", "eventId", "Ljava/lang/String;", "getEventId", "()Ljava/lang/String;", "", "hasActiveEvent", "Z", "getHasActiveEvent", "()Z", "lastActiveEventId", "getLastActiveEventId", "<init>", "(ZLjava/lang/String;Ljava/lang/String;Ljava/util/List;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class PlayBoard {
    private final List<Board> boards;
    private final String eventId;
    private final boolean hasActiveEvent;
    private final String lastActiveEventId;

    public PlayBoard(boolean z, String str, String str2, List<Board> list) {
        Intrinsics.checkNotNullParameter(str, "");
        Intrinsics.checkNotNullParameter(str2, "");
        Intrinsics.checkNotNullParameter(list, "");
        this.hasActiveEvent = z;
        this.eventId = str;
        this.lastActiveEventId = str2;
        this.boards = list;
    }

    public /* synthetic */ PlayBoard(boolean z, String str, String str2, List list, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(z, str, (i & 4) != 0 ? "" : str2, list);
    }

    @JvmName(name = "getHasActiveEvent")
    public final boolean getHasActiveEvent() {
        return this.hasActiveEvent;
    }

    @JvmName(name = "getEventId")
    public final String getEventId() {
        return this.eventId;
    }

    @JvmName(name = "getLastActiveEventId")
    public final String getLastActiveEventId() {
        return this.lastActiveEventId;
    }

    @JvmName(name = "getBoards")
    public final List<Board> getBoards() {
        return this.boards;
    }
}
