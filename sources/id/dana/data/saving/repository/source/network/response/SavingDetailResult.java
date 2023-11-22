package id.dana.data.saving.repository.source.network.response;

import com.alipayplus.mobile.component.domain.model.result.BaseRpcResult;
import id.dana.data.saving.model.SavingView;
import id.dana.data.saving.model.TopUpViewEntity;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\n\b\u0086\b\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\f\u001a\u00020\u0002\u0012\u000e\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005\u0012\u0006\u0010\u000e\u001a\u00020\t¢\u0006\u0004\b!\u0010\"J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0018\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005HÆ\u0003¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\n\u001a\u00020\tHÆ\u0003¢\u0006\u0004\b\n\u0010\u000bJ6\u0010\u000f\u001a\u00020\u00002\b\b\u0002\u0010\f\u001a\u00020\u00022\u0010\b\u0002\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00052\b\b\u0002\u0010\u000e\u001a\u00020\tHÆ\u0001¢\u0006\u0004\b\u000f\u0010\u0010J\u001a\u0010\u0013\u001a\u00020\t2\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011HÖ\u0003¢\u0006\u0004\b\u0013\u0010\u0014J\u0010\u0010\u0016\u001a\u00020\u0015HÖ\u0001¢\u0006\u0004\b\u0016\u0010\u0017J\u0010\u0010\u0019\u001a\u00020\u0018HÖ\u0001¢\u0006\u0004\b\u0019\u0010\u001aR\u0017\u0010\u000e\u001a\u00020\t8\u0007¢\u0006\f\n\u0004\b\u000e\u0010\u001b\u001a\u0004\b\u001c\u0010\u000bR\u001a\u0010\f\u001a\u00020\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\f\u0010\u001d\u001a\u0004\b\u001e\u0010\u0004R\"\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00058\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\r\u0010\u001f\u001a\u0004\b \u0010\b"}, d2 = {"Lid/dana/data/saving/repository/source/network/response/SavingDetailResult;", "Lcom/alipayplus/mobile/component/domain/model/result/BaseRpcResult;", "Lid/dana/data/saving/model/SavingView;", "component1", "()Lid/dana/data/saving/model/SavingView;", "", "Lid/dana/data/saving/model/TopUpViewEntity;", "component2", "()Ljava/util/List;", "", "component3", "()Z", "savingView", "topUpViews", "hasNext", "copy", "(Lid/dana/data/saving/model/SavingView;Ljava/util/List;Z)Lid/dana/data/saving/repository/source/network/response/SavingDetailResult;", "", "other", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "", "toString", "()Ljava/lang/String;", "Z", "getHasNext", "Lid/dana/data/saving/model/SavingView;", "getSavingView", "Ljava/util/List;", "getTopUpViews", "<init>", "(Lid/dana/data/saving/model/SavingView;Ljava/util/List;Z)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final /* data */ class SavingDetailResult extends BaseRpcResult {
    private final boolean hasNext;
    private final SavingView savingView;
    private final List<TopUpViewEntity> topUpViews;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ SavingDetailResult copy$default(SavingDetailResult savingDetailResult, SavingView savingView, List list, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            savingView = savingDetailResult.savingView;
        }
        if ((i & 2) != 0) {
            list = savingDetailResult.topUpViews;
        }
        if ((i & 4) != 0) {
            z = savingDetailResult.hasNext;
        }
        return savingDetailResult.copy(savingView, list, z);
    }

    /* renamed from: component1  reason: from getter */
    public final SavingView getSavingView() {
        return this.savingView;
    }

    public final List<TopUpViewEntity> component2() {
        return this.topUpViews;
    }

    /* renamed from: component3  reason: from getter */
    public final boolean getHasNext() {
        return this.hasNext;
    }

    public final SavingDetailResult copy(SavingView savingView, List<TopUpViewEntity> topUpViews, boolean hasNext) {
        Intrinsics.checkNotNullParameter(savingView, "");
        return new SavingDetailResult(savingView, topUpViews, hasNext);
    }

    public final boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other instanceof SavingDetailResult) {
            SavingDetailResult savingDetailResult = (SavingDetailResult) other;
            return Intrinsics.areEqual(this.savingView, savingDetailResult.savingView) && Intrinsics.areEqual(this.topUpViews, savingDetailResult.topUpViews) && this.hasNext == savingDetailResult.hasNext;
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final int hashCode() {
        int hashCode = this.savingView.hashCode();
        List<TopUpViewEntity> list = this.topUpViews;
        int hashCode2 = list == null ? 0 : list.hashCode();
        boolean z = this.hasNext;
        int i = z;
        if (z != 0) {
            i = 1;
        }
        return (((hashCode * 31) + hashCode2) * 31) + i;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("SavingDetailResult(savingView=");
        sb.append(this.savingView);
        sb.append(", topUpViews=");
        sb.append(this.topUpViews);
        sb.append(", hasNext=");
        sb.append(this.hasNext);
        sb.append(')');
        return sb.toString();
    }

    @JvmName(name = "getSavingView")
    public final SavingView getSavingView() {
        return this.savingView;
    }

    @JvmName(name = "getTopUpViews")
    public final List<TopUpViewEntity> getTopUpViews() {
        return this.topUpViews;
    }

    @JvmName(name = "getHasNext")
    public final boolean getHasNext() {
        return this.hasNext;
    }

    public SavingDetailResult(SavingView savingView, List<TopUpViewEntity> list, boolean z) {
        Intrinsics.checkNotNullParameter(savingView, "");
        this.savingView = savingView;
        this.topUpViews = list;
        this.hasNext = z;
    }
}
