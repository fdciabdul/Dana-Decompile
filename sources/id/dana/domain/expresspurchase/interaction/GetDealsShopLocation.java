package id.dana.domain.expresspurchase.interaction;

import id.dana.domain.core.usecase.BaseUseCase;
import id.dana.domain.expresspurchase.interaction.model.DealsShopInfo;
import id.dana.domain.expresspurchase.repository.ExpressPurchaseRepository;
import io.reactivex.Observable;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001\rB\u0011\b\u0007\u0012\u0006\u0010\t\u001a\u00020\b¢\u0006\u0004\b\u000b\u0010\fJ\u001d\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0006\u0010\u0007R\u0014\u0010\t\u001a\u00020\b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\t\u0010\n"}, d2 = {"Lid/dana/domain/expresspurchase/interaction/GetDealsShopLocation;", "Lid/dana/domain/core/usecase/BaseUseCase;", "Lid/dana/domain/expresspurchase/interaction/model/DealsShopInfo;", "Lid/dana/domain/expresspurchase/interaction/GetDealsShopLocation$Param;", "params", "Lio/reactivex/Observable;", "buildUseCase", "(Lid/dana/domain/expresspurchase/interaction/GetDealsShopLocation$Param;)Lio/reactivex/Observable;", "Lid/dana/domain/expresspurchase/repository/ExpressPurchaseRepository;", "expressPurchaseRepository", "Lid/dana/domain/expresspurchase/repository/ExpressPurchaseRepository;", "<init>", "(Lid/dana/domain/expresspurchase/repository/ExpressPurchaseRepository;)V", "Param"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class GetDealsShopLocation extends BaseUseCase<DealsShopInfo, Param> {
    private final ExpressPurchaseRepository expressPurchaseRepository;

    @Inject
    public GetDealsShopLocation(ExpressPurchaseRepository expressPurchaseRepository) {
        Intrinsics.checkNotNullParameter(expressPurchaseRepository, "");
        this.expressPurchaseRepository = expressPurchaseRepository;
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\n\u0018\u00002\u00020\u0001B#\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0002\u0012\b\b\u0002\u0010\t\u001a\u00020\u0002¢\u0006\u0004\b\u000b\u0010\fR\u0017\u0010\u0003\u001a\u00020\u00028\u0007¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\u0007\u001a\u00020\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006R\u001a\u0010\t\u001a\u00020\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006"}, d2 = {"Lid/dana/domain/expresspurchase/interaction/GetDealsShopLocation$Param;", "", "", "goodsId", "Ljava/lang/String;", "getGoodsId", "()Ljava/lang/String;", "latitude", "getLatitude", "longitude", "getLongitude", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes4.dex */
    public static final class Param {
        private final String goodsId;
        private final String latitude;
        private final String longitude;

        public Param(String str, String str2, String str3) {
            Intrinsics.checkNotNullParameter(str, "");
            Intrinsics.checkNotNullParameter(str2, "");
            Intrinsics.checkNotNullParameter(str3, "");
            this.goodsId = str;
            this.latitude = str2;
            this.longitude = str3;
        }

        public /* synthetic */ Param(String str, String str2, String str3, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(str, (i & 2) != 0 ? "" : str2, (i & 4) != 0 ? "" : str3);
        }

        @JvmName(name = "getGoodsId")
        public final String getGoodsId() {
            return this.goodsId;
        }

        @JvmName(name = "getLatitude")
        public final String getLatitude() {
            return this.latitude;
        }

        @JvmName(name = "getLongitude")
        public final String getLongitude() {
            return this.longitude;
        }
    }

    @Override // id.dana.domain.core.usecase.BaseUseCase
    public final Observable<DealsShopInfo> buildUseCase(Param params) {
        Intrinsics.checkNotNullParameter(params, "");
        return this.expressPurchaseRepository.dealsQueryShopLocation(params.getGoodsId(), params.getLatitude(), params.getLongitude());
    }
}
