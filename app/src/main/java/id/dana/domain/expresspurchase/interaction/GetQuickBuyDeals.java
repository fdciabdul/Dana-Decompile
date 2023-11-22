package id.dana.domain.expresspurchase.interaction;

import id.dana.data.constant.UrlParam;
import id.dana.domain.core.usecase.BaseUseCase;
import id.dana.domain.expresspurchase.constant.TemplateType;
import id.dana.domain.expresspurchase.interaction.model.QuickBuyDeals;
import id.dana.domain.expresspurchase.repository.ExpressPurchaseRepository;
import io.reactivex.Observable;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001\rB\u0011\b\u0007\u0012\u0006\u0010\t\u001a\u00020\b¢\u0006\u0004\b\u000b\u0010\fJ\u001d\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0006\u0010\u0007R\u0014\u0010\t\u001a\u00020\b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\t\u0010\n"}, d2 = {"Lid/dana/domain/expresspurchase/interaction/GetQuickBuyDeals;", "Lid/dana/domain/core/usecase/BaseUseCase;", "Lid/dana/domain/expresspurchase/interaction/model/QuickBuyDeals;", "Lid/dana/domain/expresspurchase/interaction/GetQuickBuyDeals$Param;", "params", "Lio/reactivex/Observable;", "buildUseCase", "(Lid/dana/domain/expresspurchase/interaction/GetQuickBuyDeals$Param;)Lio/reactivex/Observable;", "Lid/dana/domain/expresspurchase/repository/ExpressPurchaseRepository;", "expressPurchaseRepository", "Lid/dana/domain/expresspurchase/repository/ExpressPurchaseRepository;", "<init>", "(Lid/dana/domain/expresspurchase/repository/ExpressPurchaseRepository;)V", "Param"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class GetQuickBuyDeals extends BaseUseCase<QuickBuyDeals, Param> {
    private final ExpressPurchaseRepository expressPurchaseRepository;

    @Inject
    public GetQuickBuyDeals(ExpressPurchaseRepository expressPurchaseRepository) {
        Intrinsics.checkNotNullParameter(expressPurchaseRepository, "");
        this.expressPurchaseRepository = expressPurchaseRepository;
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\f\u0018\u00002\u00020\u0001B)\u0012\b\b\u0001\u0010\u000b\u001a\u00020\u0002\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\t\u001a\u00020\u0002¢\u0006\u0004\b\r\u0010\u000eR\u0017\u0010\u0003\u001a\u00020\u00028\u0007¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\u0007\u001a\u00020\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006R\u001a\u0010\t\u001a\u00020\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006R\u001a\u0010\u000b\u001a\u00020\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u000b\u0010\u0004\u001a\u0004\b\f\u0010\u0006"}, d2 = {"Lid/dana/domain/expresspurchase/interaction/GetQuickBuyDeals$Param;", "", "", "aggregatorGoodsId", "Ljava/lang/String;", "getAggregatorGoodsId", "()Ljava/lang/String;", "goodsId", "getGoodsId", UrlParam.REQUEST_ID, "getRequestId", "templateType", "getTemplateType", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes4.dex */
    public static final class Param {
        private final String aggregatorGoodsId;
        private final String goodsId;
        private final String requestId;
        private final String templateType;

        public Param(@TemplateType String str, String str2, String str3, String str4) {
            Intrinsics.checkNotNullParameter(str, "");
            Intrinsics.checkNotNullParameter(str2, "");
            Intrinsics.checkNotNullParameter(str3, "");
            Intrinsics.checkNotNullParameter(str4, "");
            this.templateType = str;
            this.goodsId = str2;
            this.aggregatorGoodsId = str3;
            this.requestId = str4;
        }

        @JvmName(name = "getTemplateType")
        public final String getTemplateType() {
            return this.templateType;
        }

        @JvmName(name = "getGoodsId")
        public final String getGoodsId() {
            return this.goodsId;
        }

        @JvmName(name = "getAggregatorGoodsId")
        public final String getAggregatorGoodsId() {
            return this.aggregatorGoodsId;
        }

        @JvmName(name = "getRequestId")
        public final String getRequestId() {
            return this.requestId;
        }
    }

    @Override // id.dana.domain.core.usecase.BaseUseCase
    public final Observable<QuickBuyDeals> buildUseCase(Param params) {
        Intrinsics.checkNotNullParameter(params, "");
        return this.expressPurchaseRepository.getQuickBuyDeals(params.getTemplateType(), params.getGoodsId(), params.getAggregatorGoodsId(), params.getRequestId());
    }
}
