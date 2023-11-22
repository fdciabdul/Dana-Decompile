package id.dana.danapoly.data.config.model.response;

import com.alibaba.fastjson.annotation.JSONField;
import com.alibaba.griver.core.GriverParams;
import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.JvmName;

@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\u0010\b\n\u0002\b\u0006\u0018\u00002\u00020\u0001B-\u0012\u000e\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\t\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0001\u0010\u0007\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u000f\u0010\u0010R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006R\"\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\t8\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e"}, d2 = {"Lid/dana/danapoly/data/config/model/response/BoardResponse;", "", "", "cardType", "Ljava/lang/String;", "getCardType", "()Ljava/lang/String;", "iconUrl", "getIconUrl", "", "", "positions", "Ljava/util/List;", "getPositions", "()Ljava/util/List;", "<init>", "(Ljava/util/List;Ljava/lang/String;Ljava/lang/String;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class BoardResponse {
    @SerializedName("cardType")
    private final String cardType;
    @SerializedName(GriverParams.ShareParams.IMAGE_URL)
    private final String iconUrl;
    @SerializedName("positions")
    private final List<Integer> positions;

    public BoardResponse(List<Integer> list, String str, @JSONField(name = "imageUrl") String str2) {
        this.positions = list;
        this.cardType = str;
        this.iconUrl = str2;
    }

    @JvmName(name = "getPositions")
    public final List<Integer> getPositions() {
        return this.positions;
    }

    @JvmName(name = "getCardType")
    public final String getCardType() {
        return this.cardType;
    }

    @JvmName(name = "getIconUrl")
    public final String getIconUrl() {
        return this.iconUrl;
    }
}
