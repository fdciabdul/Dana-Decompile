package id.dana.explore.data.globalsearch.source.network.result;

import com.alibaba.griver.api.jsapi.diagnostic.RecordError;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\b\b\u0086\b\u0018\u00002\u00020\u0001B\u0015\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002¢\u0006\u0004\b\u0014\u0010\u0015J\u0016\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002HÆ\u0003¢\u0006\u0004\b\u0004\u0010\u0005J \u0010\u0007\u001a\u00020\u00002\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002HÆ\u0001¢\u0006\u0004\b\u0007\u0010\bJ\u001a\u0010\u000b\u001a\u00020\n2\b\u0010\t\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\u000e\u001a\u00020\rHÖ\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\u0010\u001a\u00020\u0003HÖ\u0001¢\u0006\u0004\b\u0010\u0010\u0011R\u001d\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0007¢\u0006\f\n\u0004\b\u0006\u0010\u0012\u001a\u0004\b\u0013\u0010\u0005"}, d2 = {"Lid/dana/explore/data/globalsearch/source/network/result/ErrorContextEntity;", "", "", "", "component1", "()Ljava/util/List;", RecordError.KEY_ERROR_STACK, "copy", "(Ljava/util/List;)Lid/dana/explore/data/globalsearch/source/network/result/ErrorContextEntity;", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "toString", "()Ljava/lang/String;", "Ljava/util/List;", "getErrorStack", "<init>", "(Ljava/util/List;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes8.dex */
public final /* data */ class ErrorContextEntity {
    private final List<String> errorStack;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ ErrorContextEntity copy$default(ErrorContextEntity errorContextEntity, List list, int i, Object obj) {
        if ((i & 1) != 0) {
            list = errorContextEntity.errorStack;
        }
        return errorContextEntity.copy(list);
    }

    public final List<String> component1() {
        return this.errorStack;
    }

    public final ErrorContextEntity copy(List<String> errorStack) {
        Intrinsics.checkNotNullParameter(errorStack, "");
        return new ErrorContextEntity(errorStack);
    }

    public final boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        return (other instanceof ErrorContextEntity) && Intrinsics.areEqual(this.errorStack, ((ErrorContextEntity) other).errorStack);
    }

    public final int hashCode() {
        return this.errorStack.hashCode();
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("ErrorContextEntity(errorStack=");
        sb.append(this.errorStack);
        sb.append(')');
        return sb.toString();
    }

    public ErrorContextEntity(List<String> list) {
        Intrinsics.checkNotNullParameter(list, "");
        this.errorStack = list;
    }

    @JvmName(name = "getErrorStack")
    public final List<String> getErrorStack() {
        return this.errorStack;
    }
}
