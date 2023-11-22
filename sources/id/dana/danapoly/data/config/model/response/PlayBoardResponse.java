package id.dana.danapoly.data.config.model.response;

import com.alipayplus.mobile.component.domain.model.result.BaseRpcResult;
import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.JvmName;

@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0017\u0012\u000e\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002¢\u0006\u0004\b\b\u0010\tR\"\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007"}, d2 = {"Lid/dana/danapoly/data/config/model/response/PlayBoardResponse;", "Lcom/alipayplus/mobile/component/domain/model/result/BaseRpcResult;", "", "Lid/dana/danapoly/data/config/model/response/BoardResponse;", "boards", "Ljava/util/List;", "getBoards", "()Ljava/util/List;", "<init>", "(Ljava/util/List;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class PlayBoardResponse extends BaseRpcResult {
    @SerializedName("boards")
    private final List<BoardResponse> boards;

    @JvmName(name = "getBoards")
    public final List<BoardResponse> getBoards() {
        return this.boards;
    }

    public PlayBoardResponse(List<BoardResponse> list) {
        this.boards = list;
    }
}
