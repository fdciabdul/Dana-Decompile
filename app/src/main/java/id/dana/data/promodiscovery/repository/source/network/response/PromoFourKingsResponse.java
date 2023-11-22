package id.dana.data.promodiscovery.repository.source.network.response;

import com.alipayplus.mobile.component.domain.model.result.BaseRpcResult;
import com.google.gson.annotations.SerializedName;
import id.dana.domain.promodiscovery.model.FourKingsPromoModel;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0086\b\u0018\u00002\u00020\u0001B\u0019\u0012\u0010\b\u0002\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002¢\u0006\u0004\b\u0018\u0010\u0019J\u0018\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\"\u0010\u0007\u001a\u00020\u00002\u0010\b\u0002\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002HÆ\u0001¢\u0006\u0004\b\u0007\u0010\bJ\u001a\u0010\f\u001a\u00020\u000b2\b\u0010\n\u001a\u0004\u0018\u00010\tHÖ\u0003¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u000f\u001a\u00020\u000eHÖ\u0001¢\u0006\u0004\b\u000f\u0010\u0010J\u0013\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00110\u0002¢\u0006\u0004\b\u0012\u0010\u0005J\u0010\u0010\u0014\u001a\u00020\u0013HÖ\u0001¢\u0006\u0004\b\u0014\u0010\u0015R\"\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0006\u0010\u0016\u001a\u0004\b\u0017\u0010\u0005"}, d2 = {"Lid/dana/data/promodiscovery/repository/source/network/response/PromoFourKingsResponse;", "Lcom/alipayplus/mobile/component/domain/model/result/BaseRpcResult;", "", "Lid/dana/data/promodiscovery/repository/source/network/response/PromoFourKingsEntity;", "component1", "()Ljava/util/List;", "promoCenterPillarListDTOs", "copy", "(Ljava/util/List;)Lid/dana/data/promodiscovery/repository/source/network/response/PromoFourKingsResponse;", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "Lid/dana/domain/promodiscovery/model/FourKingsPromoModel;", "toListFourKingsPromoModel", "", "toString", "()Ljava/lang/String;", "Ljava/util/List;", "getPromoCenterPillarListDTOs", "<init>", "(Ljava/util/List;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final /* data */ class PromoFourKingsResponse extends BaseRpcResult {
    @SerializedName("promoCenterPillarListDTOs")
    private final List<PromoFourKingsEntity> promoCenterPillarListDTOs;

    /* JADX WARN: Illegal instructions before constructor call */
    /* JADX WARN: Type inference failed for: r0v0, types: [java.util.List, kotlin.jvm.internal.DefaultConstructorMarker] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public PromoFourKingsResponse() {
        /*
            r2 = this;
            r0 = 0
            r1 = 1
            r2.<init>(r0, r1, r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.data.promodiscovery.repository.source.network.response.PromoFourKingsResponse.<init>():void");
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ PromoFourKingsResponse copy$default(PromoFourKingsResponse promoFourKingsResponse, List list, int i, Object obj) {
        if ((i & 1) != 0) {
            list = promoFourKingsResponse.promoCenterPillarListDTOs;
        }
        return promoFourKingsResponse.copy(list);
    }

    public final List<PromoFourKingsEntity> component1() {
        return this.promoCenterPillarListDTOs;
    }

    public final PromoFourKingsResponse copy(List<PromoFourKingsEntity> promoCenterPillarListDTOs) {
        return new PromoFourKingsResponse(promoCenterPillarListDTOs);
    }

    public final boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        return (other instanceof PromoFourKingsResponse) && Intrinsics.areEqual(this.promoCenterPillarListDTOs, ((PromoFourKingsResponse) other).promoCenterPillarListDTOs);
    }

    public final int hashCode() {
        List<PromoFourKingsEntity> list = this.promoCenterPillarListDTOs;
        if (list == null) {
            return 0;
        }
        return list.hashCode();
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("PromoFourKingsResponse(promoCenterPillarListDTOs=");
        sb.append(this.promoCenterPillarListDTOs);
        sb.append(')');
        return sb.toString();
    }

    public /* synthetic */ PromoFourKingsResponse(List list, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? CollectionsKt.emptyList() : list);
    }

    @JvmName(name = "getPromoCenterPillarListDTOs")
    public final List<PromoFourKingsEntity> getPromoCenterPillarListDTOs() {
        return this.promoCenterPillarListDTOs;
    }

    public PromoFourKingsResponse(List<PromoFourKingsEntity> list) {
        this.promoCenterPillarListDTOs = list;
    }

    public final List<FourKingsPromoModel> toListFourKingsPromoModel() {
        List<PromoFourKingsEntity> list = this.promoCenterPillarListDTOs;
        if (list == null) {
            return CollectionsKt.emptyList();
        }
        List<PromoFourKingsEntity> list2 = list;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list2, 10));
        for (PromoFourKingsEntity promoFourKingsEntity : list2) {
            String pillarType = promoFourKingsEntity.getPillarType();
            if (pillarType == null) {
                pillarType = "";
            }
            Integer amount = promoFourKingsEntity.getAmount();
            arrayList.add(new FourKingsPromoModel(pillarType, amount != null ? amount.intValue() : 0, false));
        }
        return arrayList;
    }
}
