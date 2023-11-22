package id.dana.danapoly.data.play.model.response;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0006\u0018\u00002\u00020\u0001B7\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u000e\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0013\u0010\u0014R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\b\u001a\u0004\u0018\u00010\u00078\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u001c\u0010\f\u001a\u0004\u0018\u00010\u00078\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\f\u0010\t\u001a\u0004\b\r\u0010\u000bR\u001c\u0010\u000f\u001a\u0004\u0018\u00010\u000e8\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012"}, d2 = {"Lid/dana/danapoly/data/play/model/response/LeaderboardResponse;", "", "", "myself", "Ljava/lang/Boolean;", "getMyself", "()Ljava/lang/Boolean;", "", "name", "Ljava/lang/String;", "getName", "()Ljava/lang/String;", "photoUrl", "getPhotoUrl", "", "rankIdentifierValue", "Ljava/lang/Integer;", "getRankIdentifierValue", "()Ljava/lang/Integer;", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Boolean;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class LeaderboardResponse {
    @SerializedName("myself")
    private final Boolean myself;
    @SerializedName("name")
    private final String name;
    @SerializedName("photoUrl")
    private final String photoUrl;
    @SerializedName("rankIdentifierValue")
    private final Integer rankIdentifierValue;

    public LeaderboardResponse() {
        this(null, null, null, null, 15, null);
    }

    public LeaderboardResponse(String str, String str2, Integer num, Boolean bool) {
        this.name = str;
        this.photoUrl = str2;
        this.rankIdentifierValue = num;
        this.myself = bool;
    }

    @JvmName(name = "getName")
    public final String getName() {
        return this.name;
    }

    @JvmName(name = "getPhotoUrl")
    public final String getPhotoUrl() {
        return this.photoUrl;
    }

    public /* synthetic */ LeaderboardResponse(String str, String str2, Integer num, Boolean bool, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? "" : str, (i & 2) != 0 ? "" : str2, (i & 4) != 0 ? 0 : num, (i & 8) != 0 ? Boolean.FALSE : bool);
    }

    @JvmName(name = "getRankIdentifierValue")
    public final Integer getRankIdentifierValue() {
        return this.rankIdentifierValue;
    }

    @JvmName(name = "getMyself")
    public final Boolean getMyself() {
        return this.myself;
    }
}
