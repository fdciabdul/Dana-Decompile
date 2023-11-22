package id.dana.explore.data.globalsearch.source.network.request;

import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\r\b\u0086\b\u0018\u00002\u00020\u0001B\u001d\u0012\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002\u0012\u0006\u0010\t\u001a\u00020\u0003¢\u0006\u0004\b\u001c\u0010\u001dJ\u0016\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002HÆ\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0006\u001a\u00020\u0003HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J*\u0010\n\u001a\u00020\u00002\u000e\b\u0002\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\b\b\u0002\u0010\t\u001a\u00020\u0003HÆ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u001a\u0010\u000e\u001a\u00020\r2\b\u0010\f\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\u0011\u001a\u00020\u0010HÖ\u0001¢\u0006\u0004\b\u0011\u0010\u0012J\u0010\u0010\u0013\u001a\u00020\u0003HÖ\u0001¢\u0006\u0004\b\u0013\u0010\u0007R\"\u0010\t\u001a\u00020\u00038\u0007@\u0007X\u0086\u000e¢\u0006\u0012\n\u0004\b\t\u0010\u0014\u001a\u0004\b\u0015\u0010\u0007\"\u0004\b\u0016\u0010\u0017R(\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b\b\u0010\u0018\u001a\u0004\b\u0019\u0010\u0005\"\u0004\b\u001a\u0010\u001b"}, d2 = {"Lid/dana/explore/data/globalsearch/source/network/request/ContextConditionEntity;", "", "", "", "component1", "()Ljava/util/List;", "component2", "()Ljava/lang/String;", "keyword", "contextType", "copy", "(Ljava/util/List;Ljava/lang/String;)Lid/dana/explore/data/globalsearch/source/network/request/ContextConditionEntity;", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "toString", "Ljava/lang/String;", "getContextType", "setContextType", "(Ljava/lang/String;)V", "Ljava/util/List;", "getKeyword", "setKeyword", "(Ljava/util/List;)V", "<init>", "(Ljava/util/List;Ljava/lang/String;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final /* data */ class ContextConditionEntity {
    private String contextType;
    private List<String> keyword;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ ContextConditionEntity copy$default(ContextConditionEntity contextConditionEntity, List list, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            list = contextConditionEntity.keyword;
        }
        if ((i & 2) != 0) {
            str = contextConditionEntity.contextType;
        }
        return contextConditionEntity.copy(list, str);
    }

    public final List<String> component1() {
        return this.keyword;
    }

    /* renamed from: component2  reason: from getter */
    public final String getContextType() {
        return this.contextType;
    }

    public final ContextConditionEntity copy(List<String> keyword, String contextType) {
        Intrinsics.checkNotNullParameter(keyword, "");
        Intrinsics.checkNotNullParameter(contextType, "");
        return new ContextConditionEntity(keyword, contextType);
    }

    public final boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other instanceof ContextConditionEntity) {
            ContextConditionEntity contextConditionEntity = (ContextConditionEntity) other;
            return Intrinsics.areEqual(this.keyword, contextConditionEntity.keyword) && Intrinsics.areEqual(this.contextType, contextConditionEntity.contextType);
        }
        return false;
    }

    public final int hashCode() {
        return (this.keyword.hashCode() * 31) + this.contextType.hashCode();
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("ContextConditionEntity(keyword=");
        sb.append(this.keyword);
        sb.append(", contextType=");
        sb.append(this.contextType);
        sb.append(')');
        return sb.toString();
    }

    public ContextConditionEntity(List<String> list, String str) {
        Intrinsics.checkNotNullParameter(list, "");
        Intrinsics.checkNotNullParameter(str, "");
        this.keyword = list;
        this.contextType = str;
    }

    @JvmName(name = "getKeyword")
    public final List<String> getKeyword() {
        return this.keyword;
    }

    @JvmName(name = "setKeyword")
    public final void setKeyword(List<String> list) {
        Intrinsics.checkNotNullParameter(list, "");
        this.keyword = list;
    }

    @JvmName(name = "getContextType")
    public final String getContextType() {
        return this.contextType;
    }

    @JvmName(name = "setContextType")
    public final void setContextType(String str) {
        Intrinsics.checkNotNullParameter(str, "");
        this.contextType = str;
    }
}
