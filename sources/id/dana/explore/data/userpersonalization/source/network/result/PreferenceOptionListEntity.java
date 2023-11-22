package id.dana.explore.data.userpersonalization.source.network.result;

import com.alipayplus.mobile.component.domain.model.result.BaseRpcResult;
import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0086\b\u0018\u00002\u00020\u0001B\u0019\u0012\u0010\b\u0002\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002¢\u0006\u0004\b\u0016\u0010\u0017J\u0018\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\"\u0010\u0007\u001a\u00020\u00002\u0010\b\u0002\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002HÆ\u0001¢\u0006\u0004\b\u0007\u0010\bJ\u001a\u0010\f\u001a\u00020\u000b2\b\u0010\n\u001a\u0004\u0018\u00010\tHÖ\u0003¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u000f\u001a\u00020\u000eHÖ\u0001¢\u0006\u0004\b\u000f\u0010\u0010J\u0010\u0010\u0012\u001a\u00020\u0011HÖ\u0001¢\u0006\u0004\b\u0012\u0010\u0013R\"\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0006\u0010\u0014\u001a\u0004\b\u0015\u0010\u0005"}, d2 = {"Lid/dana/explore/data/userpersonalization/source/network/result/PreferenceOptionListEntity;", "Lcom/alipayplus/mobile/component/domain/model/result/BaseRpcResult;", "", "Lid/dana/explore/data/userpersonalization/source/network/result/PreferenceOptionInfoEntity;", "component1", "()Ljava/util/List;", "preferenceOptions", "copy", "(Ljava/util/List;)Lid/dana/explore/data/userpersonalization/source/network/result/PreferenceOptionListEntity;", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "", "toString", "()Ljava/lang/String;", "Ljava/util/List;", "getPreferenceOptions", "<init>", "(Ljava/util/List;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final /* data */ class PreferenceOptionListEntity extends BaseRpcResult {
    @SerializedName("preferenceOptions")
    private final List<PreferenceOptionInfoEntity> preferenceOptions;

    /* JADX WARN: Illegal instructions before constructor call */
    /* JADX WARN: Type inference failed for: r0v0, types: [java.util.List, kotlin.jvm.internal.DefaultConstructorMarker] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public PreferenceOptionListEntity() {
        /*
            r2 = this;
            r0 = 0
            r1 = 1
            r2.<init>(r0, r1, r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.explore.data.userpersonalization.source.network.result.PreferenceOptionListEntity.<init>():void");
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ PreferenceOptionListEntity copy$default(PreferenceOptionListEntity preferenceOptionListEntity, List list, int i, Object obj) {
        if ((i & 1) != 0) {
            list = preferenceOptionListEntity.preferenceOptions;
        }
        return preferenceOptionListEntity.copy(list);
    }

    public final List<PreferenceOptionInfoEntity> component1() {
        return this.preferenceOptions;
    }

    public final PreferenceOptionListEntity copy(List<PreferenceOptionInfoEntity> preferenceOptions) {
        return new PreferenceOptionListEntity(preferenceOptions);
    }

    public final boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        return (other instanceof PreferenceOptionListEntity) && Intrinsics.areEqual(this.preferenceOptions, ((PreferenceOptionListEntity) other).preferenceOptions);
    }

    public final int hashCode() {
        List<PreferenceOptionInfoEntity> list = this.preferenceOptions;
        if (list == null) {
            return 0;
        }
        return list.hashCode();
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("PreferenceOptionListEntity(preferenceOptions=");
        sb.append(this.preferenceOptions);
        sb.append(')');
        return sb.toString();
    }

    public /* synthetic */ PreferenceOptionListEntity(List list, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? CollectionsKt.emptyList() : list);
    }

    @JvmName(name = "getPreferenceOptions")
    public final List<PreferenceOptionInfoEntity> getPreferenceOptions() {
        return this.preferenceOptions;
    }

    public PreferenceOptionListEntity(List<PreferenceOptionInfoEntity> list) {
        this.preferenceOptions = list;
    }
}
