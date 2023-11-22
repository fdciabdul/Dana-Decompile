package id.dana.cashier.domain.interactor;

import com.alibaba.griver.beehive.lottie.player.TimeUtils;
import id.dana.cashier.domain.CashierRepository;
import id.dana.cashier.domain.interactor.GetCashierHighlightCache;
import id.dana.cashier.domain.model.CashierHighlightCache;
import id.dana.domain.core.usecase.BaseUseCase;
import io.reactivex.Observable;
import io.reactivex.functions.BiFunction;
import java.util.Calendar;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \u001a2\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0002\u001a\u001bB\u0011\b\u0007\u0012\u0006\u0010\u0016\u001a\u00020\u0015¢\u0006\u0004\b\u0018\u0010\u0019J\u001d\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J'\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\fH\u0002¢\u0006\u0004\b\u000f\u0010\u0010J#\u0010\u0013\u001a\u00020\u000e*\u00020\n2\u0006\u0010\u0011\u001a\u00020\n2\u0006\u0010\u0012\u001a\u00020\fH\u0002¢\u0006\u0004\b\u0013\u0010\u0014R\u0014\u0010\u0016\u001a\u00020\u00158\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017"}, d2 = {"Lid/dana/cashier/domain/interactor/GetCashierHighlightCache;", "Lid/dana/domain/core/usecase/BaseUseCase;", "Lid/dana/cashier/domain/model/CashierHighlightCache;", "Lid/dana/cashier/domain/interactor/GetCashierHighlightCache$Params;", "params", "Lio/reactivex/Observable;", "buildUseCase", "(Lid/dana/cashier/domain/interactor/GetCashierHighlightCache$Params;)Lio/reactivex/Observable;", "", "mode", "", "cacheTimeShow", "", "timeShowDurationInDays", "", "isNeedToShowHighlight", "(Ljava/lang/String;JI)Z", "cacheTime", "dayThreshold", "isInTheThreshold", "(JJI)Z", "Lid/dana/cashier/domain/CashierRepository;", "cashierRepository", "Lid/dana/cashier/domain/CashierRepository;", "<init>", "(Lid/dana/cashier/domain/CashierRepository;)V", "Companion", "Params"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class GetCashierHighlightCache extends BaseUseCase<CashierHighlightCache, Params> {

    /* renamed from: Companion  reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final CashierRepository cashierRepository;

    @Inject
    public GetCashierHighlightCache(CashierRepository cashierRepository) {
        Intrinsics.checkNotNullParameter(cashierRepository, "");
        this.cashierRepository = cashierRepository;
    }

    @Override // id.dana.domain.core.usecase.BaseUseCase
    public final Observable<CashierHighlightCache> buildUseCase(final Params params) {
        Intrinsics.checkNotNullParameter(params, "");
        Observable<CashierHighlightCache> zip = Observable.zip(this.cashierRepository.getHighlightVersion(params.getInstId()), this.cashierRepository.getHighlightTimeShown(params.getMode(), params.getInstId()), new BiFunction() { // from class: id.dana.cashier.domain.interactor.GetCashierHighlightCache$$ExternalSyntheticLambda0
            @Override // io.reactivex.functions.BiFunction
            public final Object apply(Object obj, Object obj2) {
                CashierHighlightCache m575buildUseCase$lambda0;
                m575buildUseCase$lambda0 = GetCashierHighlightCache.m575buildUseCase$lambda0(GetCashierHighlightCache.Params.this, this, (Integer) obj, (Long) obj2);
                return m575buildUseCase$lambda0;
            }
        });
        Intrinsics.checkNotNullExpressionValue(zip, "");
        return zip;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: buildUseCase$lambda-0  reason: not valid java name */
    public static final CashierHighlightCache m575buildUseCase$lambda0(Params params, GetCashierHighlightCache getCashierHighlightCache, Integer num, Long l) {
        Intrinsics.checkNotNullParameter(params, "");
        Intrinsics.checkNotNullParameter(getCashierHighlightCache, "");
        Intrinsics.checkNotNullParameter(num, "");
        Intrinsics.checkNotNullParameter(l, "");
        if (params.getVersion() > num.intValue()) {
            return new CashierHighlightCache(num.intValue(), true, true);
        }
        return new CashierHighlightCache(num.intValue(), getCashierHighlightCache.isNeedToShowHighlight(params.getMode(), l.longValue(), params.getTimeShowDurationInDays()), false);
    }

    private final boolean isNeedToShowHighlight(String mode, long cacheTimeShow, int timeShowDurationInDays) {
        long timeInMillis;
        if (Intrinsics.areEqual(mode, "ribbon")) {
            timeInMillis = Calendar.getInstance().getTimeInMillis();
            return isInTheThreshold(timeInMillis, cacheTimeShow, timeShowDurationInDays);
        }
        return Intrinsics.areEqual(mode, "tooltip");
    }

    private final boolean isInTheThreshold(long j, long j2, int i) {
        return j2 <= j && j < j2 + INSTANCE.toMillis$feature_cashier_productionRelease(i);
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\b\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u0012\u0006\u0010\u000e\u001a\u00020\t\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\n\u001a\u00020\t¢\u0006\u0004\b\u0010\u0010\u0011R\u0017\u0010\u0003\u001a\u00020\u00028\u0007¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\u0007\u001a\u00020\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006R\u001a\u0010\n\u001a\u00020\t8\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u001a\u0010\u000e\u001a\u00020\t8\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u000e\u0010\u000b\u001a\u0004\b\u000f\u0010\r"}, d2 = {"Lid/dana/cashier/domain/interactor/GetCashierHighlightCache$Params;", "", "", "instId", "Ljava/lang/String;", "getInstId", "()Ljava/lang/String;", "mode", "getMode", "", "timeShowDurationInDays", "I", "getTimeShowDurationInDays", "()I", "version", "getVersion", "<init>", "(Ljava/lang/String;ILjava/lang/String;I)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes4.dex */
    public static final class Params {
        private final String instId;
        private final String mode;
        private final int timeShowDurationInDays;
        private final int version;

        public Params(String str, int i, String str2, int i2) {
            Intrinsics.checkNotNullParameter(str, "");
            Intrinsics.checkNotNullParameter(str2, "");
            this.mode = str;
            this.version = i;
            this.instId = str2;
            this.timeShowDurationInDays = i2;
        }

        @JvmName(name = "getMode")
        public final String getMode() {
            return this.mode;
        }

        @JvmName(name = "getVersion")
        public final int getVersion() {
            return this.version;
        }

        @JvmName(name = "getInstId")
        public final String getInstId() {
            return this.instId;
        }

        @JvmName(name = "getTimeShowDurationInDays")
        public final int getTimeShowDurationInDays() {
            return this.timeShowDurationInDays;
        }
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\u0010\t\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0006\u0010\u0007J\u0013\u0010\u0004\u001a\u00020\u0003*\u00020\u0002H\u0000¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Lid/dana/cashier/domain/interactor/GetCashierHighlightCache$Companion;", "", "", "", "toMillis$feature_cashier_productionRelease", "(I)J", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes4.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final long toMillis$feature_cashier_productionRelease(int i) {
            return i * TimeUtils.DAY_TO_SECOND * 1000;
        }

        private Companion() {
        }
    }
}
