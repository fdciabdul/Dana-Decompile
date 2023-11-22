package id.dana.feeds.data.detail.source.network.request;

import com.alipayplus.mobile.component.domain.model.request.BaseRpcRequest;
import id.dana.data.here.model.HereUrlConstant;
import id.dana.domain.social.ExtendInfoUtilKt;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\b\u0018\u00002\u00020\u0001B-\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\n\u001a\u0004\u0018\u00010\t¢\u0006\u0004\b\u0010\u0010\u0011R\u0017\u0010\u0003\u001a\u00020\u00028\u0007¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006R\u001c\u0010\n\u001a\u0004\u0018\u00010\t8\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u001c\u0010\u000e\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u000e\u0010\u0004\u001a\u0004\b\u000f\u0010\u0006"}, d2 = {"Lid/dana/feeds/data/detail/source/network/request/FetchCommentRequest;", "Lcom/alipayplus/mobile/component/domain/model/request/BaseRpcRequest;", "", ExtendInfoUtilKt.EXTEND_INFO_ACTIVITY_ID, "Ljava/lang/String;", "getActivityId", "()Ljava/lang/String;", "idLT", "getIdLT", "", HereUrlConstant.LIMIT, "Ljava/lang/Integer;", "getLimit", "()Ljava/lang/Integer;", "parentCommentId", "getParentCommentId", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class FetchCommentRequest extends BaseRpcRequest {
    private final String activityId;
    private final String idLT;
    private final Integer limit;
    private final String parentCommentId;

    @JvmName(name = "getActivityId")
    public final String getActivityId() {
        return this.activityId;
    }

    @JvmName(name = "getParentCommentId")
    public final String getParentCommentId() {
        return this.parentCommentId;
    }

    @JvmName(name = "getIdLT")
    public final String getIdLT() {
        return this.idLT;
    }

    @JvmName(name = "getLimit")
    public final Integer getLimit() {
        return this.limit;
    }

    public FetchCommentRequest(String str, String str2, String str3, Integer num) {
        Intrinsics.checkNotNullParameter(str, "");
        this.activityId = str;
        this.parentCommentId = str2;
        this.idLT = str3;
        this.limit = num;
    }
}
