package id.dana.cashier.domain.interactor;

import android.content.Context;
import com.ap.zoloz.hummer.biz.HummerConstants;
import id.dana.data.h5event.sendmoney.CheckoutFinishEntity;
import id.dana.data.h5event.sendmoney.CheckoutFinishEventManager;
import id.dana.data.toggle.SplitFacade;
import id.dana.domain.account.interactor.SaveLastTransaction;
import id.dana.domain.core.usecase.BaseUseCase;
import io.reactivex.Observable;
import java.util.concurrent.Callable;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmName;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001\u0013B!\b\u0007\u0012\u0006\u0010\t\u001a\u00020\b\u0012\u0006\u0010\u000f\u001a\u00020\u000e\u0012\u0006\u0010\f\u001a\u00020\u000b¢\u0006\u0004\b\u0011\u0010\u0012J\u001d\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0006\u0010\u0007R\u0014\u0010\t\u001a\u00020\b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\t\u0010\nR\u0014\u0010\f\u001a\u00020\u000b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\f\u0010\rR\u0014\u0010\u000f\u001a\u00020\u000e8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010"}, d2 = {"Lid/dana/cashier/domain/interactor/ProcessEventCheckoutFinish;", "Lid/dana/domain/core/usecase/BaseUseCase;", "", "Lid/dana/cashier/domain/interactor/ProcessEventCheckoutFinish$Params;", "params", "Lio/reactivex/Observable;", "buildUseCase", "(Lid/dana/cashier/domain/interactor/ProcessEventCheckoutFinish$Params;)Lio/reactivex/Observable;", "Landroid/content/Context;", HummerConstants.CONTEXT, "Landroid/content/Context;", "Lid/dana/domain/account/interactor/SaveLastTransaction;", "saveLastTransaction", "Lid/dana/domain/account/interactor/SaveLastTransaction;", "Lid/dana/data/toggle/SplitFacade;", "splitFacade", "Lid/dana/data/toggle/SplitFacade;", "<init>", "(Landroid/content/Context;Lid/dana/data/toggle/SplitFacade;Lid/dana/domain/account/interactor/SaveLastTransaction;)V", "Params"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class ProcessEventCheckoutFinish extends BaseUseCase<Unit, Params> {
    private final Context context;
    private final SaveLastTransaction saveLastTransaction;
    private final SplitFacade splitFacade;

    @Inject
    public ProcessEventCheckoutFinish(Context context, SplitFacade splitFacade, SaveLastTransaction saveLastTransaction) {
        Intrinsics.checkNotNullParameter(context, "");
        Intrinsics.checkNotNullParameter(splitFacade, "");
        Intrinsics.checkNotNullParameter(saveLastTransaction, "");
        this.context = context;
        this.splitFacade = splitFacade;
        this.saveLastTransaction = saveLastTransaction;
    }

    @Override // id.dana.domain.core.usecase.BaseUseCase
    public final Observable<Unit> buildUseCase(final Params params) {
        Intrinsics.checkNotNullParameter(params, "");
        Observable<Unit> fromCallable = Observable.fromCallable(new Callable() { // from class: id.dana.cashier.domain.interactor.ProcessEventCheckoutFinish$$ExternalSyntheticLambda0
            @Override // java.util.concurrent.Callable
            public final Object call() {
                Unit m589buildUseCase$lambda0;
                m589buildUseCase$lambda0 = ProcessEventCheckoutFinish.m589buildUseCase$lambda0(ProcessEventCheckoutFinish.this, params);
                return m589buildUseCase$lambda0;
            }
        });
        Intrinsics.checkNotNullExpressionValue(fromCallable, "");
        return fromCallable;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: buildUseCase$lambda-0  reason: not valid java name */
    public static final Unit m589buildUseCase$lambda0(ProcessEventCheckoutFinish processEventCheckoutFinish, Params params) {
        Intrinsics.checkNotNullParameter(processEventCheckoutFinish, "");
        Intrinsics.checkNotNullParameter(params, "");
        CheckoutFinishEventManager.processEvent(processEventCheckoutFinish.context, processEventCheckoutFinish.splitFacade, processEventCheckoutFinish.saveLastTransaction, params.getCheckoutFinishEntity());
        return Unit.INSTANCE;
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 \t2\u00020\u0001:\u0001\tB\u0011\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0007\u0010\bR\u001a\u0010\u0003\u001a\u00020\u00028\u0001X\u0080\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006"}, d2 = {"Lid/dana/cashier/domain/interactor/ProcessEventCheckoutFinish$Params;", "", "Lid/dana/data/h5event/sendmoney/CheckoutFinishEntity;", "checkoutFinishEntity", "Lid/dana/data/h5event/sendmoney/CheckoutFinishEntity;", "getCheckoutFinishEntity$feature_cashier_productionRelease", "()Lid/dana/data/h5event/sendmoney/CheckoutFinishEntity;", "<init>", "(Lid/dana/data/h5event/sendmoney/CheckoutFinishEntity;)V", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes4.dex */
    public static final class Params {

        /* renamed from: Companion  reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private final CheckoutFinishEntity checkoutFinishEntity;

        public /* synthetic */ Params(CheckoutFinishEntity checkoutFinishEntity, DefaultConstructorMarker defaultConstructorMarker) {
            this(checkoutFinishEntity);
        }

        @JvmStatic
        public static final Params createCheckoutFinishEntity(boolean z, String str, String str2, String str3) {
            return INSTANCE.createCheckoutFinishEntity(z, str, str2, str3);
        }

        private Params(CheckoutFinishEntity checkoutFinishEntity) {
            this.checkoutFinishEntity = checkoutFinishEntity;
        }

        @JvmName(name = "getCheckoutFinishEntity$feature_cashier_productionRelease")
        /* renamed from: getCheckoutFinishEntity$feature_cashier_productionRelease  reason: from getter */
        public final CheckoutFinishEntity getCheckoutFinishEntity() {
            return this.checkoutFinishEntity;
        }

        @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u000b\u0010\fJ/\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0004H\u0007¢\u0006\u0004\b\t\u0010\n"}, d2 = {"Lid/dana/cashier/domain/interactor/ProcessEventCheckoutFinish$Params$Companion;", "", "", "apiSuccess", "", "processingStatus", "transType", "transScenario", "Lid/dana/cashier/domain/interactor/ProcessEventCheckoutFinish$Params;", "createCheckoutFinishEntity", "(ZLjava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lid/dana/cashier/domain/interactor/ProcessEventCheckoutFinish$Params;", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
        /* loaded from: classes4.dex */
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            @JvmStatic
            public final Params createCheckoutFinishEntity(boolean apiSuccess, String processingStatus, String transType, String transScenario) {
                Intrinsics.checkNotNullParameter(processingStatus, "");
                Intrinsics.checkNotNullParameter(transType, "");
                Intrinsics.checkNotNullParameter(transScenario, "");
                return new Params(new CheckoutFinishEntity(apiSuccess, processingStatus, transType, null, transScenario, 8, null), null);
            }
        }
    }
}
