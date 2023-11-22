package id.dana.cashier.fragment;

import android.os.Handler;
import android.os.Looper;
import androidx.appcompat.widget.AppCompatTextView;
import com.alibaba.ariver.kernel.api.extension.bridge.BridgeDSL;
import id.dana.R;
import id.dana.base.BaseActivity;
import id.dana.cashier.CashierContract;
import id.dana.cashier.adapter.CashierPayMethodAdapter;
import id.dana.cashier.helper.CashierPayMethodModelExt;
import id.dana.cashier.model.CashierPayMethodModel;
import id.dana.cashier.model.CashierPayMethodModelKt;
import id.dana.cashier.tracker.PaylaterAnalyticTracker;
import id.dana.cashier.view.ExpandablePaymentMethod;
import id.dana.data.usereducation.repository.source.local.UserEducationPreference;
import id.dana.showcase.AbstractOnShowcaseStateListener;
import id.dana.showcase.Content;
import id.dana.showcase.SimpleShowcaseBuilder;
import id.dana.showcase.SimpleShowcaseWithShadowBuilder;
import id.dana.utils.SizeUtil;
import java.util.List;
import java.util.Queue;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u0000\b\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", BridgeDSL.INVOKE, "()V"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class PayConfirmationFragment$launchPayMethodShowcase$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ Content $$content;
    final /* synthetic */ String $$scenario;
    final /* synthetic */ PayConfirmationFragment this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PayConfirmationFragment$launchPayMethodShowcase$1(PayConfirmationFragment payConfirmationFragment, Content content, String str) {
        super(0);
        this.this$0 = payConfirmationFragment;
        this.$$content = content;
        this.$$scenario = str;
    }

    @Override // kotlin.jvm.functions.Function0
    public final /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.INSTANCE;
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2() {
        BaseActivity baseActivity = this.this$0.getBaseActivity();
        Intrinsics.checkNotNullExpressionValue(baseActivity, "");
        SimpleShowcaseWithShadowBuilder simpleShowcaseWithShadowBuilder = new SimpleShowcaseWithShadowBuilder(baseActivity);
        AppCompatTextView appCompatTextView = (AppCompatTextView) this.this$0.BuiltInFictitiousFunctionClassFactory(R.id.res_0x7f0a157d_access_getreferralbanneradapter_p);
        simpleShowcaseWithShadowBuilder.NetworkUserEntityData$$ExternalSyntheticLambda2 = appCompatTextView != null ? PayConfirmationFragment.BuiltInFictitiousFunctionClassFactory(this.this$0, appCompatTextView, this.$$content) : null;
        SimpleShowcaseBuilder authRequestContext = simpleShowcaseWithShadowBuilder.PlaceComponentResult(PayConfirmationFragment.KClassImpl$Data$declaredNonStaticMembers$2(this.this$0, this.$$scenario)).BuiltInFictitiousFunctionClassFactory(true).KClassImpl$Data$declaredNonStaticMembers$2(R.color.res_0x7f060353_networkuserentitydata_externalsyntheticlambda0).getAuthRequestContext(SizeUtil.getAuthRequestContext(16));
        Content content = this.$$content;
        SimpleShowcaseBuilder MyBillsEntityDataFactory = authRequestContext.MyBillsEntityDataFactory(content != null ? content.NetworkUserEntityData$$ExternalSyntheticLambda0 : null);
        Content content2 = this.$$content;
        SimpleShowcaseBuilder BuiltInFictitiousFunctionClassFactory = MyBillsEntityDataFactory.BuiltInFictitiousFunctionClassFactory(content2 != null ? content2.MyBillsEntityDataFactory : null);
        final PayConfirmationFragment payConfirmationFragment = this.this$0;
        final String str = this.$$scenario;
        BuiltInFictitiousFunctionClassFactory.BuiltInFictitiousFunctionClassFactory(new AbstractOnShowcaseStateListener() { // from class: id.dana.cashier.fragment.PayConfirmationFragment$launchPayMethodShowcase$1.1
            @Override // id.dana.showcase.AbstractOnShowcaseStateListener, id.dana.showcase.OnShowcaseStateListener
            public final void onFinished(int p0) {
                Queue queue;
                Content MyBillsEntityDataFactory2;
                CashierPayMethodAdapter cashierPayMethodAdapter;
                CashierPayMethodModel cashierPayMethodModel;
                CashierPayMethodAdapter cashierPayMethodAdapter2;
                CashierPayMethodModel cashierPayMethodModel2;
                CashierContract.Presenter presenter = PayConfirmationFragment.this.cashierPresenter;
                PaylaterAnalyticTracker paylaterAnalyticTracker = null;
                if (presenter == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("");
                    presenter = null;
                }
                presenter.getAuthRequestContext(str);
                if (Intrinsics.areEqual(str, UserEducationPreference.CASHIER_SMARTPAY_AVAILABLE_TOOLTIP)) {
                    PayConfirmationFragment.P(PayConfirmationFragment.this);
                } else if (Intrinsics.areEqual(str, UserEducationPreference.CASHIER_AVAILABLE_DANA_CICIL_TOOLTIP)) {
                    cashierPayMethodAdapter = PayConfirmationFragment.this.NetworkUserEntityData$$ExternalSyntheticLambda7;
                    if (cashierPayMethodAdapter == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("");
                        cashierPayMethodAdapter = null;
                    }
                    List<CashierPayMethodModel> items = cashierPayMethodAdapter.getItems();
                    if (!(items != null ? Intrinsics.areEqual(CashierPayMethodModelKt.BuiltInFictitiousFunctionClassFactory(items), Boolean.TRUE) : false)) {
                        cashierPayMethodModel = PayConfirmationFragment.this.c;
                        if (cashierPayMethodModel != null) {
                            cashierPayMethodModel.NetworkUserEntityData$$ExternalSyntheticLambda0 = false;
                        }
                        PayConfirmationFragment payConfirmationFragment2 = PayConfirmationFragment.this;
                        cashierPayMethodAdapter2 = payConfirmationFragment2.NetworkUserEntityData$$ExternalSyntheticLambda7;
                        if (cashierPayMethodAdapter2 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("");
                            cashierPayMethodAdapter2 = null;
                        }
                        List<CashierPayMethodModel> items2 = cashierPayMethodAdapter2.getItems();
                        if (items2 != null) {
                            CashierPayMethodModelExt cashierPayMethodModelExt = CashierPayMethodModelExt.INSTANCE;
                            cashierPayMethodModel2 = CashierPayMethodModelExt.KClassImpl$Data$declaredNonStaticMembers$2(items2);
                            if (cashierPayMethodModel2 != null) {
                                cashierPayMethodModel2.NetworkUserEntityData$$ExternalSyntheticLambda0 = true;
                                payConfirmationFragment2.NetworkUserEntityData$$ExternalSyntheticLambda1(cashierPayMethodModel2);
                            }
                        }
                        cashierPayMethodModel2 = null;
                        payConfirmationFragment2.NetworkUserEntityData$$ExternalSyntheticLambda1(cashierPayMethodModel2);
                    } else {
                        ExpandablePaymentMethod expandablePaymentMethod = (ExpandablePaymentMethod) PayConfirmationFragment.this.BuiltInFictitiousFunctionClassFactory(R.id.DefaultBehaviorComponent);
                        if (expandablePaymentMethod != null) {
                            expandablePaymentMethod.expandView(true);
                        }
                    }
                    PaylaterAnalyticTracker paylaterAnalyticTracker2 = PayConfirmationFragment.this.paylaterAnalyticTracker;
                    if (paylaterAnalyticTracker2 != null) {
                        paylaterAnalyticTracker = paylaterAnalyticTracker2;
                    } else {
                        Intrinsics.throwUninitializedPropertyAccessException("");
                    }
                    paylaterAnalyticTracker.scheduleImpl();
                } else {
                    queue = PayConfirmationFragment.this.initRecordTimeStamp;
                    String str2 = (String) queue.poll();
                    if (str2 != null) {
                        PayConfirmationFragment payConfirmationFragment3 = PayConfirmationFragment.this;
                        MyBillsEntityDataFactory2 = payConfirmationFragment3.MyBillsEntityDataFactory(str2);
                        new Handler(Looper.getMainLooper()).postDelayed(new PayConfirmationFragment$$ExternalSyntheticLambda17(new PayConfirmationFragment$launchPayMethodShowcase$1(payConfirmationFragment3, MyBillsEntityDataFactory2, str2)), 600L);
                    }
                }
            }
        }).PlaceComponentResult();
    }
}
