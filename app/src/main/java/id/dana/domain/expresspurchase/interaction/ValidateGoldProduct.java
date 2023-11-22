package id.dana.domain.expresspurchase.interaction;

import com.alibaba.ariver.engine.common.track.watchdog.ARiverTrackWatchDogEventConstant;
import id.dana.domain.core.usecase.BaseUseCase;
import id.dana.domain.expresspurchase.interaction.model.GoldValidationInfo;
import id.dana.domain.expresspurchase.repository.ExpressPurchaseRepository;
import io.reactivex.Observable;
import java.util.List;
import java.util.Map;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001\rB\u0011\b\u0007\u0012\u0006\u0010\t\u001a\u00020\b¢\u0006\u0004\b\u000b\u0010\fJ\u001d\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0006\u0010\u0007R\u0014\u0010\t\u001a\u00020\b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\t\u0010\n"}, d2 = {"Lid/dana/domain/expresspurchase/interaction/ValidateGoldProduct;", "Lid/dana/domain/core/usecase/BaseUseCase;", "Lid/dana/domain/expresspurchase/interaction/model/GoldValidationInfo;", "Lid/dana/domain/expresspurchase/interaction/ValidateGoldProduct$Params;", "params", "Lio/reactivex/Observable;", "buildUseCase", "(Lid/dana/domain/expresspurchase/interaction/ValidateGoldProduct$Params;)Lio/reactivex/Observable;", "Lid/dana/domain/expresspurchase/repository/ExpressPurchaseRepository;", "expressPurchaseRepository", "Lid/dana/domain/expresspurchase/repository/ExpressPurchaseRepository;", "<init>", "(Lid/dana/domain/expresspurchase/repository/ExpressPurchaseRepository;)V", "Params"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class ValidateGoldProduct extends BaseUseCase<GoldValidationInfo, Params> {
    private final ExpressPurchaseRepository expressPurchaseRepository;

    @Inject
    public ValidateGoldProduct(ExpressPurchaseRepository expressPurchaseRepository) {
        Intrinsics.checkNotNullParameter(expressPurchaseRepository, "");
        this.expressPurchaseRepository = expressPurchaseRepository;
    }

    @Override // id.dana.domain.core.usecase.BaseUseCase
    public final Observable<GoldValidationInfo> buildUseCase(Params params) {
        Intrinsics.checkNotNullParameter(params, "");
        return this.expressPurchaseRepository.validateGoldProduct(params.getGoodsId(), params.getValidationTypes$domain_productionRelease(), params.getValidationInfo$domain_productionRelease());
    }

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010$\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\b\u0007\u0018\u0000 \u00132\u00020\u0001:\u0001\u0013B3\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00020\f\u0012\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00010\u0007¢\u0006\u0004\b\u0011\u0010\u0012R\u001a\u0010\u0003\u001a\u00020\u00028\u0001X\u0080\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R&\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00010\u00078\u0001X\u0081\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR \u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00020\f8\u0001X\u0081\u0004¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010"}, d2 = {"Lid/dana/domain/expresspurchase/interaction/ValidateGoldProduct$Params;", "", "", "goodsId", "Ljava/lang/String;", "getGoodsId$domain_productionRelease", "()Ljava/lang/String;", "", "validationInfo", "Ljava/util/Map;", "getValidationInfo$domain_productionRelease", "()Ljava/util/Map;", "", "validationTypes", "Ljava/util/List;", "getValidationTypes$domain_productionRelease", "()Ljava/util/List;", "<init>", "(Ljava/lang/String;Ljava/util/List;Ljava/util/Map;)V", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes4.dex */
    public static final class Params {

        /* renamed from: Companion  reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private final String goodsId;
        private final Map<String, Object> validationInfo;
        private final List<String> validationTypes;

        public /* synthetic */ Params(String str, List list, Map map, DefaultConstructorMarker defaultConstructorMarker) {
            this(str, list, map);
        }

        @JvmStatic
        public static final Params create(String str, List<String> list, Map<String, ? extends Object> map) {
            return INSTANCE.create(str, list, map);
        }

        private Params(String str, List<String> list, Map<String, ? extends Object> map) {
            this.goodsId = str;
            this.validationTypes = list;
            this.validationInfo = map;
        }

        @JvmName(name = "getGoodsId$domain_productionRelease")
        /* renamed from: getGoodsId$domain_productionRelease  reason: from getter */
        public final String getGoodsId() {
            return this.goodsId;
        }

        @JvmName(name = "getValidationTypes$domain_productionRelease")
        public final List<String> getValidationTypes$domain_productionRelease() {
            return this.validationTypes;
        }

        @JvmName(name = "getValidationInfo$domain_productionRelease")
        public final Map<String, Object> getValidationInfo$domain_productionRelease() {
            return this.validationInfo;
        }

        @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0010$\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u000b\u0010\fJ9\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00020\u00042\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00010\u0006H\u0007¢\u0006\u0004\b\t\u0010\n"}, d2 = {"Lid/dana/domain/expresspurchase/interaction/ValidateGoldProduct$Params$Companion;", "", "", "goodsId", "", "validationTypes", "", "validationInfo", "Lid/dana/domain/expresspurchase/interaction/ValidateGoldProduct$Params;", ARiverTrackWatchDogEventConstant.FLAG_START_UP_CREATE, "(Ljava/lang/String;Ljava/util/List;Ljava/util/Map;)Lid/dana/domain/expresspurchase/interaction/ValidateGoldProduct$Params;", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
        /* loaded from: classes4.dex */
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            @JvmStatic
            public final Params create(String goodsId, List<String> validationTypes, Map<String, ? extends Object> validationInfo) {
                Intrinsics.checkNotNullParameter(goodsId, "");
                Intrinsics.checkNotNullParameter(validationTypes, "");
                Intrinsics.checkNotNullParameter(validationInfo, "");
                return new Params(goodsId, validationTypes, validationInfo, null);
            }
        }
    }
}
