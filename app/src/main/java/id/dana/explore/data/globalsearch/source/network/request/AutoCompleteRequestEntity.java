package id.dana.explore.data.globalsearch.source.network.request;

import com.alibaba.griver.api.common.monitor.GriverMonitorConstants;
import com.alipayplus.mobile.component.domain.model.request.BaseRpcRequest;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000e\b\u0086\b\u0018\u00002\u00020\u0001B7\u0012\u000e\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002\u0012\u0006\u0010\u000f\u001a\u00020\u0006\u0012\u0006\u0010\u0010\u001a\u00020\u0006\u0012\u0006\u0010\u0011\u001a\u00020\n\u0012\u0006\u0010\u0012\u001a\u00020\n¢\u0006\u0004\b$\u0010%J\u0018\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0007\u001a\u00020\u0006HÆ\u0003¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\t\u001a\u00020\u0006HÆ\u0003¢\u0006\u0004\b\t\u0010\bJ\u0010\u0010\u000b\u001a\u00020\nHÆ\u0003¢\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\r\u001a\u00020\nHÆ\u0003¢\u0006\u0004\b\r\u0010\fJJ\u0010\u0013\u001a\u00020\u00002\u0010\b\u0002\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00022\b\b\u0002\u0010\u000f\u001a\u00020\u00062\b\b\u0002\u0010\u0010\u001a\u00020\u00062\b\b\u0002\u0010\u0011\u001a\u00020\n2\b\b\u0002\u0010\u0012\u001a\u00020\nHÆ\u0001¢\u0006\u0004\b\u0013\u0010\u0014J\u001a\u0010\u0018\u001a\u00020\u00172\b\u0010\u0016\u001a\u0004\u0018\u00010\u0015HÖ\u0003¢\u0006\u0004\b\u0018\u0010\u0019J\u0010\u0010\u001a\u001a\u00020\nHÖ\u0001¢\u0006\u0004\b\u001a\u0010\fJ\u0010\u0010\u001b\u001a\u00020\u0006HÖ\u0001¢\u0006\u0004\b\u001b\u0010\bR\u001f\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00028\u0007¢\u0006\f\n\u0004\b\u000e\u0010\u001c\u001a\u0004\b\u001d\u0010\u0005R\u001a\u0010\u0011\u001a\u00020\n8\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0011\u0010\u001e\u001a\u0004\b\u001f\u0010\fR\u001a\u0010\u000f\u001a\u00020\u00068\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u000f\u0010 \u001a\u0004\b!\u0010\bR\u001a\u0010\u0012\u001a\u00020\n8\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0012\u0010\u001e\u001a\u0004\b\"\u0010\fR\u001a\u0010\u0010\u001a\u00020\u00068\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0010\u0010 \u001a\u0004\b#\u0010\b"}, d2 = {"Lid/dana/explore/data/globalsearch/source/network/request/AutoCompleteRequestEntity;", "Lcom/alipayplus/mobile/component/domain/model/request/BaseRpcRequest;", "", "Lid/dana/explore/data/globalsearch/source/network/request/ContextConditionEntity;", "component1", "()Ljava/util/List;", "", "component2", "()Ljava/lang/String;", "component3", "", "component4", "()I", "component5", "contextConditions", "searchType", "suggestKeyword", "page", GriverMonitorConstants.KEY_SIZE, "copy", "(Ljava/util/List;Ljava/lang/String;Ljava/lang/String;II)Lid/dana/explore/data/globalsearch/source/network/request/AutoCompleteRequestEntity;", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "hashCode", "toString", "Ljava/util/List;", "getContextConditions", "I", "getPage", "Ljava/lang/String;", "getSearchType", "getSize", "getSuggestKeyword", "<init>", "(Ljava/util/List;Ljava/lang/String;Ljava/lang/String;II)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final /* data */ class AutoCompleteRequestEntity extends BaseRpcRequest {
    private final List<ContextConditionEntity> contextConditions;
    private final int page;
    private final String searchType;
    private final int size;
    private final String suggestKeyword;

    public static /* synthetic */ AutoCompleteRequestEntity copy$default(AutoCompleteRequestEntity autoCompleteRequestEntity, List list, String str, String str2, int i, int i2, int i3, Object obj) {
        List<ContextConditionEntity> list2 = list;
        if ((i3 & 1) != 0) {
            list2 = autoCompleteRequestEntity.contextConditions;
        }
        if ((i3 & 2) != 0) {
            str = autoCompleteRequestEntity.searchType;
        }
        String str3 = str;
        if ((i3 & 4) != 0) {
            str2 = autoCompleteRequestEntity.suggestKeyword;
        }
        String str4 = str2;
        if ((i3 & 8) != 0) {
            i = autoCompleteRequestEntity.page;
        }
        int i4 = i;
        if ((i3 & 16) != 0) {
            i2 = autoCompleteRequestEntity.size;
        }
        return autoCompleteRequestEntity.copy(list2, str3, str4, i4, i2);
    }

    public final List<ContextConditionEntity> component1() {
        return this.contextConditions;
    }

    /* renamed from: component2  reason: from getter */
    public final String getSearchType() {
        return this.searchType;
    }

    /* renamed from: component3  reason: from getter */
    public final String getSuggestKeyword() {
        return this.suggestKeyword;
    }

    /* renamed from: component4  reason: from getter */
    public final int getPage() {
        return this.page;
    }

    /* renamed from: component5  reason: from getter */
    public final int getSize() {
        return this.size;
    }

    public final AutoCompleteRequestEntity copy(List<ContextConditionEntity> contextConditions, String searchType, String suggestKeyword, int page, int size) {
        Intrinsics.checkNotNullParameter(searchType, "");
        Intrinsics.checkNotNullParameter(suggestKeyword, "");
        return new AutoCompleteRequestEntity(contextConditions, searchType, suggestKeyword, page, size);
    }

    public final boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other instanceof AutoCompleteRequestEntity) {
            AutoCompleteRequestEntity autoCompleteRequestEntity = (AutoCompleteRequestEntity) other;
            return Intrinsics.areEqual(this.contextConditions, autoCompleteRequestEntity.contextConditions) && Intrinsics.areEqual(this.searchType, autoCompleteRequestEntity.searchType) && Intrinsics.areEqual(this.suggestKeyword, autoCompleteRequestEntity.suggestKeyword) && this.page == autoCompleteRequestEntity.page && this.size == autoCompleteRequestEntity.size;
        }
        return false;
    }

    public final int hashCode() {
        List<ContextConditionEntity> list = this.contextConditions;
        return ((((((((list == null ? 0 : list.hashCode()) * 31) + this.searchType.hashCode()) * 31) + this.suggestKeyword.hashCode()) * 31) + this.page) * 31) + this.size;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("AutoCompleteRequestEntity(contextConditions=");
        sb.append(this.contextConditions);
        sb.append(", searchType=");
        sb.append(this.searchType);
        sb.append(", suggestKeyword=");
        sb.append(this.suggestKeyword);
        sb.append(", page=");
        sb.append(this.page);
        sb.append(", size=");
        sb.append(this.size);
        sb.append(')');
        return sb.toString();
    }

    @JvmName(name = "getContextConditions")
    public final List<ContextConditionEntity> getContextConditions() {
        return this.contextConditions;
    }

    @JvmName(name = "getSearchType")
    public final String getSearchType() {
        return this.searchType;
    }

    @JvmName(name = "getSuggestKeyword")
    public final String getSuggestKeyword() {
        return this.suggestKeyword;
    }

    @JvmName(name = "getPage")
    public final int getPage() {
        return this.page;
    }

    @JvmName(name = "getSize")
    public final int getSize() {
        return this.size;
    }

    public AutoCompleteRequestEntity(List<ContextConditionEntity> list, String str, String str2, int i, int i2) {
        Intrinsics.checkNotNullParameter(str, "");
        Intrinsics.checkNotNullParameter(str2, "");
        this.contextConditions = list;
        this.searchType = str;
        this.suggestKeyword = str2;
        this.page = i;
        this.size = i2;
    }
}
