package id.dana.kybcpm;

import id.dana.data.constant.DanaUrl;
import id.dana.kyb.data.KybCpmException;
import id.dana.kyb.domain.interactor.CreatePaymentOrderCpm;
import id.dana.kyb.domain.model.PaymentOrderCpm;
import id.dana.kybcpm.KybCpmContract;
import id.dana.kybcpm.constant.KybCpmConstants;
import id.dana.kybcpm.tracker.KybCpmTracker;
import id.dana.utils.DateTimeUtil;
import id.dana.utils.LocaleUtil;
import id.dana.utils.TagFormat;
import java.util.Arrays;
import java.util.Date;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B!\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0010\u0012\u0006\u0010\u0004\u001a\u00020\n\u0012\u0006\u0010\u0013\u001a\u00020\r¢\u0006\u0004\b\u0014\u0010\u0015J\u001f\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\b\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\b\u0010\tR\u0014\u0010\u000b\u001a\u00020\n8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010\fR\u0014\u0010\u0006\u001a\u00020\r8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0012\u001a\u00020\u00108\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0006\u0010\u0011"}, d2 = {"Lid/dana/kybcpm/KybCpmPresenter;", "Lid/dana/kybcpm/KybCpmContract$Presenter;", "", "p0", "p1", "", "getAuthRequestContext", "(Ljava/lang/String;Ljava/lang/String;)V", "onDestroy", "()V", "Lid/dana/kyb/domain/interactor/CreatePaymentOrderCpm;", "PlaceComponentResult", "Lid/dana/kyb/domain/interactor/CreatePaymentOrderCpm;", "Lid/dana/kybcpm/tracker/KybCpmTracker;", "MyBillsEntityDataFactory", "Lid/dana/kybcpm/tracker/KybCpmTracker;", "Lid/dana/kybcpm/KybCpmContract$View;", "Lid/dana/kybcpm/KybCpmContract$View;", "KClassImpl$Data$declaredNonStaticMembers$2", "p2", "<init>", "(Lid/dana/kybcpm/KybCpmContract$View;Lid/dana/kyb/domain/interactor/CreatePaymentOrderCpm;Lid/dana/kybcpm/tracker/KybCpmTracker;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class KybCpmPresenter implements KybCpmContract.Presenter {

    /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
    private final KybCpmTracker getAuthRequestContext;
    private final CreatePaymentOrderCpm PlaceComponentResult;

    /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
    private final KybCpmContract.View KClassImpl$Data$declaredNonStaticMembers$2;

    @Inject
    public KybCpmPresenter(KybCpmContract.View view, CreatePaymentOrderCpm createPaymentOrderCpm, KybCpmTracker kybCpmTracker) {
        Intrinsics.checkNotNullParameter(view, "");
        Intrinsics.checkNotNullParameter(createPaymentOrderCpm, "");
        Intrinsics.checkNotNullParameter(kybCpmTracker, "");
        this.KClassImpl$Data$declaredNonStaticMembers$2 = view;
        this.PlaceComponentResult = createPaymentOrderCpm;
        this.getAuthRequestContext = kybCpmTracker;
    }

    @Override // id.dana.kybcpm.KybCpmContract.Presenter
    public final void getAuthRequestContext(final String p0, String p1) {
        Intrinsics.checkNotNullParameter(p0, "");
        Intrinsics.checkNotNullParameter(p1, "");
        this.PlaceComponentResult.execute(new CreatePaymentOrderCpm.Params(p0, p1), new Function1<PaymentOrderCpm, Unit>() { // from class: id.dana.kybcpm.KybCpmPresenter$createPaymentOrderCpm$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final /* bridge */ /* synthetic */ Unit invoke(PaymentOrderCpm paymentOrderCpm) {
                invoke2(paymentOrderCpm);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(PaymentOrderCpm paymentOrderCpm) {
                KybCpmContract.View view;
                Intrinsics.checkNotNullParameter(paymentOrderCpm, "");
                view = KybCpmPresenter.this.KClassImpl$Data$declaredNonStaticMembers$2;
                view.PlaceComponentResult(KybCpmPresenter.getAuthRequestContext(paymentOrderCpm.getAcquirementId()));
            }
        }, new Function1<Throwable, Unit>() { // from class: id.dana.kybcpm.KybCpmPresenter$createPaymentOrderCpm$2
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
                invoke2(th);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(Throwable th) {
                KybCpmTracker kybCpmTracker;
                KybCpmContract.View view;
                KybCpmContract.View view2;
                Intrinsics.checkNotNullParameter(th, "");
                if (th instanceof KybCpmException) {
                    view2 = KybCpmPresenter.this.KClassImpl$Data$declaredNonStaticMembers$2;
                    view2.PlaceComponentResult(KybCpmPresenter.MyBillsEntityDataFactory(p0));
                    return;
                }
                kybCpmTracker = KybCpmPresenter.this.getAuthRequestContext;
                kybCpmTracker.PlaceComponentResult(th);
                view = KybCpmPresenter.this.KClassImpl$Data$declaredNonStaticMembers$2;
                view.onError(th.getMessage());
            }
        });
    }

    @Override // id.dana.base.AbstractContract.AbstractPresenter
    public final void onDestroy() {
        this.PlaceComponentResult.dispose();
    }

    public static final /* synthetic */ String MyBillsEntityDataFactory(String str) {
        StringBuilder sb = new StringBuilder();
        sb.append("https://m.dana.id");
        TagFormat PlaceComponentResult = TagFormat.MyBillsEntityDataFactory(DanaUrl.KYB_CPM_IN_PROGRESS_PAGE).PlaceComponentResult("amount", str).PlaceComponentResult("title", KybCpmConstants.TITLE_IN_PROGRESS_PAGE);
        String BuiltInFictitiousFunctionClassFactory = DateTimeUtil.BuiltInFictitiousFunctionClassFactory("yyyy-MM-dd'T'HH:mm:ssZ", LocaleUtil.getAuthRequestContext(), new Date().getTime());
        Intrinsics.checkNotNullExpressionValue(BuiltInFictitiousFunctionClassFactory, "");
        sb.append(PlaceComponentResult.PlaceComponentResult(KybCpmConstants.TRANSACTION_DATE_PARAM, BuiltInFictitiousFunctionClassFactory).MyBillsEntityDataFactory());
        return sb.toString();
    }

    public static final /* synthetic */ String getAuthRequestContext(String str) {
        StringBuilder sb = new StringBuilder();
        sb.append("https://m.dana.id");
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        String format = String.format(DanaUrl.KYB_CPM_RESULT_PAGE, Arrays.copyOf(new Object[]{str}, 1));
        Intrinsics.checkNotNullExpressionValue(format, "");
        sb.append(format);
        return sb.toString();
    }
}
