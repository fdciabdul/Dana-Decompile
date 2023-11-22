package id.dana.cashier.domain.interactor;

import id.dana.cashier.domain.CashierRepository;
import id.dana.cashier.domain.interactor.GetCashierAddOnInfo;
import id.dana.cashier.domain.model.CashierAddOnCdnTooltip;
import id.dana.cashier.domain.model.CashierAddOnInfo;
import id.dana.cashier.domain.model.CashierAddOnModalContent;
import id.dana.cashier.domain.model.CashierAddOnModalTooltip;
import id.dana.cashier.domain.model.CashierAddOnModalTooltipRequest;
import id.dana.domain.core.usecase.BaseUseCase;
import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.functions.BiFunction;
import io.reactivex.functions.Function;
import java.util.List;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001\rB\u0011\b\u0007\u0012\u0006\u0010\t\u001a\u00020\b¢\u0006\u0004\b\u000b\u0010\fJ\u001d\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0006\u0010\u0007R\u0014\u0010\t\u001a\u00020\b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\t\u0010\n"}, d2 = {"Lid/dana/cashier/domain/interactor/GetCashierAddOnInfo;", "Lid/dana/domain/core/usecase/BaseUseCase;", "Lid/dana/cashier/domain/model/CashierAddOnInfo;", "Lid/dana/cashier/domain/interactor/GetCashierAddOnInfo$Params;", "params", "Lio/reactivex/Observable;", "buildUseCase", "(Lid/dana/cashier/domain/interactor/GetCashierAddOnInfo$Params;)Lio/reactivex/Observable;", "Lid/dana/cashier/domain/CashierRepository;", "cashierRepository", "Lid/dana/cashier/domain/CashierRepository;", "<init>", "(Lid/dana/cashier/domain/CashierRepository;)V", "Params"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class GetCashierAddOnInfo extends BaseUseCase<CashierAddOnInfo, Params> {
    private final CashierRepository cashierRepository;

    @Inject
    public GetCashierAddOnInfo(CashierRepository cashierRepository) {
        Intrinsics.checkNotNullParameter(cashierRepository, "");
        this.cashierRepository = cashierRepository;
    }

    @Override // id.dana.domain.core.usecase.BaseUseCase
    public final Observable<CashierAddOnInfo> buildUseCase(final Params params) {
        Intrinsics.checkNotNullParameter(params, "");
        Observable<CashierAddOnInfo> flatMap = this.cashierRepository.getModalContent().zipWith(this.cashierRepository.getModalCategory(), new BiFunction() { // from class: id.dana.cashier.domain.interactor.GetCashierAddOnInfo$$ExternalSyntheticLambda0
            @Override // io.reactivex.functions.BiFunction
            public final Object apply(Object obj, Object obj2) {
                Observable m570buildUseCase$lambda2;
                m570buildUseCase$lambda2 = GetCashierAddOnInfo.m570buildUseCase$lambda2(GetCashierAddOnInfo.Params.this, this, (CashierAddOnModalContent) obj, (List) obj2);
                return m570buildUseCase$lambda2;
            }
        }).flatMap(new Function() { // from class: id.dana.cashier.domain.interactor.GetCashierAddOnInfo$$ExternalSyntheticLambda1
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                ObservableSource m573buildUseCase$lambda3;
                m573buildUseCase$lambda3 = GetCashierAddOnInfo.m573buildUseCase$lambda3((Observable) obj);
                return m573buildUseCase$lambda3;
            }
        });
        Intrinsics.checkNotNullExpressionValue(flatMap, "");
        return flatMap;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: buildUseCase$lambda-2  reason: not valid java name */
    public static final Observable m570buildUseCase$lambda2(Params params, GetCashierAddOnInfo getCashierAddOnInfo, final CashierAddOnModalContent cashierAddOnModalContent, List list) {
        Intrinsics.checkNotNullParameter(params, "");
        Intrinsics.checkNotNullParameter(getCashierAddOnInfo, "");
        Intrinsics.checkNotNullParameter(cashierAddOnModalContent, "");
        Intrinsics.checkNotNullParameter(list, "");
        if (list.contains(params.getCategory())) {
            return getCashierAddOnInfo.cashierRepository.getTooltipContent(new CashierAddOnModalTooltipRequest(params.getGoodsId(), params.getGoodsType(), params.getCategory(), Boolean.valueOf(params.getStackInsurance()))).map(new Function() { // from class: id.dana.cashier.domain.interactor.GetCashierAddOnInfo$$ExternalSyntheticLambda2
                @Override // io.reactivex.functions.Function
                public final Object apply(Object obj) {
                    CashierAddOnInfo.FromApi m571buildUseCase$lambda2$lambda0;
                    m571buildUseCase$lambda2$lambda0 = GetCashierAddOnInfo.m571buildUseCase$lambda2$lambda0(CashierAddOnModalContent.this, (CashierAddOnModalTooltip) obj);
                    return m571buildUseCase$lambda2$lambda0;
                }
            });
        }
        return getCashierAddOnInfo.cashierRepository.getTooltipFromCdn(params.getTooltip()).map(new Function() { // from class: id.dana.cashier.domain.interactor.GetCashierAddOnInfo$$ExternalSyntheticLambda3
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                CashierAddOnInfo.FromCdn m572buildUseCase$lambda2$lambda1;
                m572buildUseCase$lambda2$lambda1 = GetCashierAddOnInfo.m572buildUseCase$lambda2$lambda1((CashierAddOnCdnTooltip) obj);
                return m572buildUseCase$lambda2$lambda1;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: buildUseCase$lambda-2$lambda-0  reason: not valid java name */
    public static final CashierAddOnInfo.FromApi m571buildUseCase$lambda2$lambda0(CashierAddOnModalContent cashierAddOnModalContent, CashierAddOnModalTooltip cashierAddOnModalTooltip) {
        Intrinsics.checkNotNullParameter(cashierAddOnModalContent, "");
        Intrinsics.checkNotNullParameter(cashierAddOnModalTooltip, "");
        return new CashierAddOnInfo.FromApi(cashierAddOnModalTooltip, cashierAddOnModalContent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: buildUseCase$lambda-2$lambda-1  reason: not valid java name */
    public static final CashierAddOnInfo.FromCdn m572buildUseCase$lambda2$lambda1(CashierAddOnCdnTooltip cashierAddOnCdnTooltip) {
        Intrinsics.checkNotNullParameter(cashierAddOnCdnTooltip, "");
        return new CashierAddOnInfo.FromCdn(cashierAddOnCdnTooltip.getImage(), cashierAddOnCdnTooltip.getTitle(), cashierAddOnCdnTooltip.getContent());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: buildUseCase$lambda-3  reason: not valid java name */
    public static final ObservableSource m573buildUseCase$lambda3(Observable observable) {
        Intrinsics.checkNotNullParameter(observable, "");
        return observable;
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\b\u0018\u00002\u00020\u0001B/\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u0012\u0006\u0010\t\u001a\u00020\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\f\u001a\u00020\u000b\u0012\u0006\u0010\u0010\u001a\u00020\u0002¢\u0006\u0004\b\u0012\u0010\u0013R\u0017\u0010\u0003\u001a\u00020\u00028\u0007¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\u0007\u001a\u00020\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006R\u001a\u0010\t\u001a\u00020\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006R\u001a\u0010\f\u001a\u00020\u000b8\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0010\u001a\u00020\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0010\u0010\u0004\u001a\u0004\b\u0011\u0010\u0006"}, d2 = {"Lid/dana/cashier/domain/interactor/GetCashierAddOnInfo$Params;", "", "", "category", "Ljava/lang/String;", "getCategory", "()Ljava/lang/String;", "goodsId", "getGoodsId", "goodsType", "getGoodsType", "", "stackInsurance", "Z", "getStackInsurance", "()Z", "tooltip", "getTooltip", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZLjava/lang/String;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes4.dex */
    public static final class Params {
        private final String category;
        private final String goodsId;
        private final String goodsType;
        private final boolean stackInsurance;
        private final String tooltip;

        public Params(String str, String str2, String str3, boolean z, String str4) {
            Intrinsics.checkNotNullParameter(str, "");
            Intrinsics.checkNotNullParameter(str2, "");
            Intrinsics.checkNotNullParameter(str3, "");
            Intrinsics.checkNotNullParameter(str4, "");
            this.goodsId = str;
            this.goodsType = str2;
            this.category = str3;
            this.stackInsurance = z;
            this.tooltip = str4;
        }

        @JvmName(name = "getGoodsId")
        public final String getGoodsId() {
            return this.goodsId;
        }

        @JvmName(name = "getGoodsType")
        public final String getGoodsType() {
            return this.goodsType;
        }

        @JvmName(name = "getCategory")
        public final String getCategory() {
            return this.category;
        }

        @JvmName(name = "getStackInsurance")
        public final boolean getStackInsurance() {
            return this.stackInsurance;
        }

        @JvmName(name = "getTooltip")
        public final String getTooltip() {
            return this.tooltip;
        }
    }
}
