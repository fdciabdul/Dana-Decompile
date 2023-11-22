package id.dana.cashier.domain.interactor;

import com.afollestad.materialdialogs.utils.MDUtil;
import com.alibaba.griver.video.H5Constants;
import id.dana.cashier.domain.CashierRepository;
import id.dana.domain.core.usecase.BaseUseCase;
import id.dana.domain.featureconfig.FeatureConfigRepository;
import id.dana.domain.featureconfig.model.CashierPaymentAutorouteConfig;
import io.reactivex.Observable;
import io.reactivex.functions.BiFunction;
import java.util.concurrent.TimeUnit;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001\u0017B\u0019\b\u0007\u0012\u0006\u0010\u0013\u001a\u00020\u0012\u0012\u0006\u0010\u0010\u001a\u00020\u000f¢\u0006\u0004\b\u0015\u0010\u0016J\u001d\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J\u0017\u0010\u000b\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\bH\u0002¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\r\u001a\u00020\bH\u0002¢\u0006\u0004\b\r\u0010\u000eR\u0014\u0010\u0010\u001a\u00020\u000f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u0014\u0010\u0013\u001a\u00020\u00128\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014"}, d2 = {"Lid/dana/cashier/domain/interactor/CheckNeedToShowSmartpayDialog;", "Lid/dana/domain/core/usecase/BaseUseCase;", "", "Lid/dana/cashier/domain/interactor/CheckNeedToShowSmartpayDialog$Params;", "params", "Lio/reactivex/Observable;", "buildUseCase", "(Lid/dana/cashier/domain/interactor/CheckNeedToShowSmartpayDialog$Params;)Lio/reactivex/Observable;", "", "lastTime", "", "countDays", "(J)I", H5Constants.ACTION_GET_CURRENT_TIME, "()J", "Lid/dana/cashier/domain/CashierRepository;", "cashierRepository", "Lid/dana/cashier/domain/CashierRepository;", "Lid/dana/domain/featureconfig/FeatureConfigRepository;", "featureConfigRepository", "Lid/dana/domain/featureconfig/FeatureConfigRepository;", "<init>", "(Lid/dana/domain/featureconfig/FeatureConfigRepository;Lid/dana/cashier/domain/CashierRepository;)V", "Params"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class CheckNeedToShowSmartpayDialog extends BaseUseCase<Boolean, Params> {
    private final CashierRepository cashierRepository;
    private final FeatureConfigRepository featureConfigRepository;

    @Inject
    public CheckNeedToShowSmartpayDialog(FeatureConfigRepository featureConfigRepository, CashierRepository cashierRepository) {
        Intrinsics.checkNotNullParameter(featureConfigRepository, "");
        Intrinsics.checkNotNullParameter(cashierRepository, "");
        this.featureConfigRepository = featureConfigRepository;
        this.cashierRepository = cashierRepository;
    }

    @Override // id.dana.domain.core.usecase.BaseUseCase
    public final Observable<Boolean> buildUseCase(final Params params) {
        Intrinsics.checkNotNullParameter(params, "");
        final Ref.BooleanRef booleanRef = new Ref.BooleanRef();
        Observable<Boolean> zip = Observable.zip(this.featureConfigRepository.getCashierAutorouteConfig(), this.cashierRepository.getLastTimeSmartPayActivationShow(), new BiFunction() { // from class: id.dana.cashier.domain.interactor.CheckNeedToShowSmartpayDialog$$ExternalSyntheticLambda0
            @Override // io.reactivex.functions.BiFunction
            public final Object apply(Object obj, Object obj2) {
                Boolean m567buildUseCase$lambda1;
                m567buildUseCase$lambda1 = CheckNeedToShowSmartpayDialog.m567buildUseCase$lambda1(Ref.BooleanRef.this, params, this, (CashierPaymentAutorouteConfig) obj, (Long) obj2);
                return m567buildUseCase$lambda1;
            }
        });
        Intrinsics.checkNotNullExpressionValue(zip, "");
        return zip;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: buildUseCase$lambda-1  reason: not valid java name */
    public static final Boolean m567buildUseCase$lambda1(Ref.BooleanRef booleanRef, Params params, CheckNeedToShowSmartpayDialog checkNeedToShowSmartpayDialog, CashierPaymentAutorouteConfig cashierPaymentAutorouteConfig, Long l) {
        Intrinsics.checkNotNullParameter(booleanRef, "");
        Intrinsics.checkNotNullParameter(params, "");
        Intrinsics.checkNotNullParameter(checkNeedToShowSmartpayDialog, "");
        Intrinsics.checkNotNullParameter(cashierPaymentAutorouteConfig, "");
        Intrinsics.checkNotNullParameter(l, "");
        MDUtil mDUtil = MDUtil.INSTANCE;
        int cooldownPeriod = cashierPaymentAutorouteConfig.getCooldownPeriod();
        if (cooldownPeriod != 0) {
            booleanRef.element = params.getShowAutorouteSwitch() && cooldownPeriod < checkNeedToShowSmartpayDialog.countDays(l.longValue());
        }
        return Boolean.valueOf(booleanRef.element);
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0007\u0010\bR\u0017\u0010\u0003\u001a\u00020\u00028\u0007¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006"}, d2 = {"Lid/dana/cashier/domain/interactor/CheckNeedToShowSmartpayDialog$Params;", "", "", "showAutorouteSwitch", "Z", "getShowAutorouteSwitch", "()Z", "<init>", "(Z)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes4.dex */
    public static final class Params {
        private final boolean showAutorouteSwitch;

        public Params(boolean z) {
            this.showAutorouteSwitch = z;
        }

        @JvmName(name = "getShowAutorouteSwitch")
        public final boolean getShowAutorouteSwitch() {
            return this.showAutorouteSwitch;
        }
    }

    private final int countDays(long lastTime) {
        return (int) TimeUnit.MILLISECONDS.toDays(getCurrentTime() - lastTime);
    }

    private final long getCurrentTime() {
        return System.currentTimeMillis();
    }
}
