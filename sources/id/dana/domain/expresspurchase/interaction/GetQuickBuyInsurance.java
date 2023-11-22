package id.dana.domain.expresspurchase.interaction;

import id.dana.domain.core.usecase.BaseUseCase;
import id.dana.domain.expresspurchase.interaction.model.QuickBuyInsurance;
import id.dana.domain.expresspurchase.repository.ExpressPurchaseRepository;
import io.reactivex.Observable;
import java.util.Map;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001\rB\u0011\b\u0007\u0012\u0006\u0010\t\u001a\u00020\b¢\u0006\u0004\b\u000b\u0010\fJ\u001d\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0006\u0010\u0007R\u0014\u0010\t\u001a\u00020\b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\t\u0010\n"}, d2 = {"Lid/dana/domain/expresspurchase/interaction/GetQuickBuyInsurance;", "Lid/dana/domain/core/usecase/BaseUseCase;", "Lid/dana/domain/expresspurchase/interaction/model/QuickBuyInsurance;", "Lid/dana/domain/expresspurchase/interaction/GetQuickBuyInsurance$Param;", "params", "Lio/reactivex/Observable;", "buildUseCase", "(Lid/dana/domain/expresspurchase/interaction/GetQuickBuyInsurance$Param;)Lio/reactivex/Observable;", "Lid/dana/domain/expresspurchase/repository/ExpressPurchaseRepository;", "expressPurchaseRepository", "Lid/dana/domain/expresspurchase/repository/ExpressPurchaseRepository;", "<init>", "(Lid/dana/domain/expresspurchase/repository/ExpressPurchaseRepository;)V", "Param"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class GetQuickBuyInsurance extends BaseUseCase<QuickBuyInsurance, Param> {
    private final ExpressPurchaseRepository expressPurchaseRepository;

    @Inject
    public GetQuickBuyInsurance(ExpressPurchaseRepository expressPurchaseRepository) {
        Intrinsics.checkNotNullParameter(expressPurchaseRepository, "");
        this.expressPurchaseRepository = expressPurchaseRepository;
    }

    @Override // id.dana.domain.core.usecase.BaseUseCase
    public final Observable<QuickBuyInsurance> buildUseCase(Param params) {
        Intrinsics.checkNotNullParameter(params, "");
        return this.expressPurchaseRepository.getQuickBuyInsurance(params.getGoodsId(), params.getAggregatorGoodsId(), params.getExtendInfo());
    }

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\n\b\u0086\b\u0018\u00002\u00020\u0001B+\u0012\u0006\u0010\t\u001a\u00020\u0002\u0012\u0006\u0010\n\u001a\u00020\u0002\u0012\u0012\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u0006¢\u0006\u0004\b\u001b\u0010\u001cJ\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0004J\u001c\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u0006HÆ\u0003¢\u0006\u0004\b\u0007\u0010\bJ:\u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\t\u001a\u00020\u00022\b\b\u0002\u0010\n\u001a\u00020\u00022\u0014\b\u0002\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u0006HÆ\u0001¢\u0006\u0004\b\f\u0010\rJ\u001a\u0010\u0010\u001a\u00020\u000f2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0010\u0010\u0011J\u0010\u0010\u0013\u001a\u00020\u0012HÖ\u0001¢\u0006\u0004\b\u0013\u0010\u0014J\u0010\u0010\u0015\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0015\u0010\u0004R\u0017\u0010\n\u001a\u00020\u00028\u0007¢\u0006\f\n\u0004\b\n\u0010\u0016\u001a\u0004\b\u0017\u0010\u0004R&\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u00068\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u000b\u0010\u0018\u001a\u0004\b\u0019\u0010\bR\u001a\u0010\t\u001a\u00020\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010\u0016\u001a\u0004\b\u001a\u0010\u0004"}, d2 = {"Lid/dana/domain/expresspurchase/interaction/GetQuickBuyInsurance$Param;", "", "", "component1", "()Ljava/lang/String;", "component2", "", "component3", "()Ljava/util/Map;", "goodsId", "aggregatorGoodsId", "extendInfo", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/util/Map;)Lid/dana/domain/expresspurchase/interaction/GetQuickBuyInsurance$Param;", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "toString", "Ljava/lang/String;", "getAggregatorGoodsId", "Ljava/util/Map;", "getExtendInfo", "getGoodsId", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/util/Map;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes4.dex */
    public static final /* data */ class Param {
        private final String aggregatorGoodsId;
        private final Map<String, String> extendInfo;
        private final String goodsId;

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ Param copy$default(Param param, String str, String str2, Map map, int i, Object obj) {
            if ((i & 1) != 0) {
                str = param.goodsId;
            }
            if ((i & 2) != 0) {
                str2 = param.aggregatorGoodsId;
            }
            if ((i & 4) != 0) {
                map = param.extendInfo;
            }
            return param.copy(str, str2, map);
        }

        /* renamed from: component1  reason: from getter */
        public final String getGoodsId() {
            return this.goodsId;
        }

        /* renamed from: component2  reason: from getter */
        public final String getAggregatorGoodsId() {
            return this.aggregatorGoodsId;
        }

        public final Map<String, String> component3() {
            return this.extendInfo;
        }

        public final Param copy(String goodsId, String aggregatorGoodsId, Map<String, String> extendInfo) {
            Intrinsics.checkNotNullParameter(goodsId, "");
            Intrinsics.checkNotNullParameter(aggregatorGoodsId, "");
            Intrinsics.checkNotNullParameter(extendInfo, "");
            return new Param(goodsId, aggregatorGoodsId, extendInfo);
        }

        public final boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (other instanceof Param) {
                Param param = (Param) other;
                return Intrinsics.areEqual(this.goodsId, param.goodsId) && Intrinsics.areEqual(this.aggregatorGoodsId, param.aggregatorGoodsId) && Intrinsics.areEqual(this.extendInfo, param.extendInfo);
            }
            return false;
        }

        public final int hashCode() {
            return (((this.goodsId.hashCode() * 31) + this.aggregatorGoodsId.hashCode()) * 31) + this.extendInfo.hashCode();
        }

        public final String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("Param(goodsId=");
            sb.append(this.goodsId);
            sb.append(", aggregatorGoodsId=");
            sb.append(this.aggregatorGoodsId);
            sb.append(", extendInfo=");
            sb.append(this.extendInfo);
            sb.append(')');
            return sb.toString();
        }

        public Param(String str, String str2, Map<String, String> map) {
            Intrinsics.checkNotNullParameter(str, "");
            Intrinsics.checkNotNullParameter(str2, "");
            Intrinsics.checkNotNullParameter(map, "");
            this.goodsId = str;
            this.aggregatorGoodsId = str2;
            this.extendInfo = map;
        }

        @JvmName(name = "getGoodsId")
        public final String getGoodsId() {
            return this.goodsId;
        }

        @JvmName(name = "getAggregatorGoodsId")
        public final String getAggregatorGoodsId() {
            return this.aggregatorGoodsId;
        }

        @JvmName(name = "getExtendInfo")
        public final Map<String, String> getExtendInfo() {
            return this.extendInfo;
        }
    }
}
