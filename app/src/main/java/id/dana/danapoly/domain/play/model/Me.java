package id.dana.danapoly.domain.play.model;

import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\n\u0018\u00002\u00020\u0001B9\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\n\u001a\u00020\t\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u000e\u001a\u00020\t\u0012\b\b\u0002\u0010\u0010\u001a\u00020\t¢\u0006\u0004\b\u0012\u0010\u0013R\u0017\u0010\u0003\u001a\u00020\u00028\u0007¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\u0007\u001a\u00020\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006R\u001a\u0010\n\u001a\u00020\t8\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u001a\u0010\u000e\u001a\u00020\t8\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u000e\u0010\u000b\u001a\u0004\b\u000f\u0010\rR\u001a\u0010\u0010\u001a\u00020\t8\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0010\u0010\u000b\u001a\u0004\b\u0011\u0010\r"}, d2 = {"Lid/dana/danapoly/domain/play/model/Me;", "", "", "name", "Ljava/lang/String;", "getName", "()Ljava/lang/String;", "photoUrl", "getPhotoUrl", "", "rank", "I", "getRank", "()I", "rankIdentifierValue", "getRankIdentifierValue", "usersAboveMe", "getUsersAboveMe", "<init>", "(Ljava/lang/String;ILjava/lang/String;II)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class Me {
    private final String name;
    private final String photoUrl;
    private final int rank;
    private final int rankIdentifierValue;
    private final int usersAboveMe;

    public Me() {
        this(null, 0, null, 0, 0, 31, null);
    }

    public Me(String str, int i, String str2, int i2, int i3) {
        Intrinsics.checkNotNullParameter(str, "");
        Intrinsics.checkNotNullParameter(str2, "");
        this.name = str;
        this.rank = i;
        this.photoUrl = str2;
        this.rankIdentifierValue = i2;
        this.usersAboveMe = i3;
    }

    public /* synthetic */ Me(String str, int i, String str2, int i2, int i3, int i4, DefaultConstructorMarker defaultConstructorMarker) {
        this((i4 & 1) != 0 ? "" : str, (i4 & 2) != 0 ? 0 : i, (i4 & 4) == 0 ? str2 : "", (i4 & 8) != 0 ? 0 : i2, (i4 & 16) != 0 ? 0 : i3);
    }

    @JvmName(name = "getName")
    public final String getName() {
        return this.name;
    }

    @JvmName(name = "getRank")
    public final int getRank() {
        return this.rank;
    }

    @JvmName(name = "getPhotoUrl")
    public final String getPhotoUrl() {
        return this.photoUrl;
    }

    @JvmName(name = "getRankIdentifierValue")
    public final int getRankIdentifierValue() {
        return this.rankIdentifierValue;
    }

    @JvmName(name = "getUsersAboveMe")
    public final int getUsersAboveMe() {
        return this.usersAboveMe;
    }
}
