package id.dana.danapoly.data.play.model.response;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\n\u0018\u00002\u00020\u0001BC\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\t¢\u0006\u0004\b\u0012\u0010\u0013R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006R\u001c\u0010\n\u001a\u0004\u0018\u00010\t8\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u001c\u0010\u000e\u001a\u0004\u0018\u00010\t8\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u000e\u0010\u000b\u001a\u0004\b\u000f\u0010\rR\u001c\u0010\u0010\u001a\u0004\u0018\u00010\t8\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0010\u0010\u000b\u001a\u0004\b\u0011\u0010\r"}, d2 = {"Lid/dana/danapoly/data/play/model/response/MeResponse;", "", "", "name", "Ljava/lang/String;", "getName", "()Ljava/lang/String;", "photoUrl", "getPhotoUrl", "", "rank", "Ljava/lang/Integer;", "getRank", "()Ljava/lang/Integer;", "rankIdentifierValue", "getRankIdentifierValue", "usersAboveMe", "getUsersAboveMe", "<init>", "(Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class MeResponse {
    @SerializedName("name")
    private final String name;
    @SerializedName("photoUrl")
    private final String photoUrl;
    @SerializedName("rank")
    private final Integer rank;
    @SerializedName("rankIdentifierValue")
    private final Integer rankIdentifierValue;
    @SerializedName("usersAboveMe")
    private final Integer usersAboveMe;

    public MeResponse() {
        this(null, null, null, null, null, 31, null);
    }

    public MeResponse(String str, Integer num, String str2, Integer num2, Integer num3) {
        this.name = str;
        this.rank = num;
        this.photoUrl = str2;
        this.rankIdentifierValue = num2;
        this.usersAboveMe = num3;
    }

    @JvmName(name = "getName")
    public final String getName() {
        return this.name;
    }

    public /* synthetic */ MeResponse(String str, Integer num, String str2, Integer num2, Integer num3, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? "" : str, (i & 2) != 0 ? 0 : num, (i & 4) == 0 ? str2 : "", (i & 8) != 0 ? 0 : num2, (i & 16) != 0 ? 0 : num3);
    }

    @JvmName(name = "getRank")
    public final Integer getRank() {
        return this.rank;
    }

    @JvmName(name = "getPhotoUrl")
    public final String getPhotoUrl() {
        return this.photoUrl;
    }

    @JvmName(name = "getRankIdentifierValue")
    public final Integer getRankIdentifierValue() {
        return this.rankIdentifierValue;
    }

    @JvmName(name = "getUsersAboveMe")
    public final Integer getUsersAboveMe() {
        return this.usersAboveMe;
    }
}
