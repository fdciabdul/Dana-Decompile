package id.dana.cashier.topupandpay.fragment;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import dagger.internal.Preconditions;
import id.dana.R;
import id.dana.base.AbstractContract;
import id.dana.base.BaseActivity;
import id.dana.cashier.CashierViewListener;
import id.dana.cashier.TopUpAndPayContract;
import id.dana.cashier.domain.interactor.GetTopUpConsult;
import id.dana.cashier.domain.model.CashierPayRequest;
import id.dana.cashier.domain.model.TopUpConsult;
import id.dana.cashier.fragment.BaseCashierFragment;
import id.dana.cashier.fragment.PaymentResultFragment;
import id.dana.cashier.mapper.TopUpConsultModelMapper;
import id.dana.cashier.model.AddOnTrackingModel;
import id.dana.cashier.model.AttributeCashierPayModel;
import id.dana.cashier.model.CashierCheckoutModel;
import id.dana.cashier.model.CashierCheckoutRequestModel;
import id.dana.cashier.model.CashierPayChannelModel;
import id.dana.cashier.model.CashierPayMethodModel;
import id.dana.cashier.model.CashierPayMethodModelKt;
import id.dana.cashier.model.CashierPayModel;
import id.dana.cashier.model.PayMethodViewDtoModelKt;
import id.dana.cashier.model.PayResultModel;
import id.dana.cashier.model.TopUpConsultModel;
import id.dana.cashier.model.TopUpPayModel;
import id.dana.cashier.model.tracker.PaymentExecutionTrackerParams;
import id.dana.cashier.presenter.CashierPresenter;
import id.dana.cashier.presenter.TopUpAndPayPresenter;
import id.dana.cashier.topupandpay.fragment.TopUpAndPayInputFragment;
import id.dana.cashier.tracker.CashierAnalyticTracker;
import id.dana.cashier.utils.CashierKeyParams;
import id.dana.cashier.view.TopUpAndPayMethodView;
import id.dana.core.ui.util.LocaleUtil;
import id.dana.di.component.ApplicationComponent;
import id.dana.di.component.DaggerTopUpAndPayComponent;
import id.dana.di.modules.CashierAnalyticModule;
import id.dana.di.modules.CashierModule;
import id.dana.di.modules.TopUpAndPayModule;
import id.dana.nearbyme.merchantdetail.model.MoneyViewModel;
import id.dana.pay.PayActivity;
import id.dana.promoquest.handler.nativepage.NativePageType;
import id.dana.utils.ErrorUtil;
import id.dana.utils.LocationUtil;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import javax.inject.Inject;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 +2\u00020\u0001:\u0001+B\u0007¢\u0006\u0004\b*\u0010\u0004J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0006\u001a\u00020\u0005H\u0014¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\b\u001a\u00020\u0002H\u0014¢\u0006\u0004\b\b\u0010\u0004J\u000f\u0010\t\u001a\u00020\u0002H\u0014¢\u0006\u0004\b\t\u0010\u0004J\u000f\u0010\n\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\n\u0010\u0004J\u000f\u0010\u000b\u001a\u00020\u0002H\u0014¢\u0006\u0004\b\u000b\u0010\u0004J\u0013\u0010\b\u001a\u00020\r*\u00020\fH\u0002¢\u0006\u0004\b\b\u0010\u000eR\u0018\u0010\u0011\u001a\u0004\u0018\u00010\u000f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u000b\u0010\u0010R\u0012\u0010\u0013\u001a\u00020\u0012X\u0087\"¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u0016\u0010\u0003\u001a\u00020\u00158\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u0012\u0010\u0019\u001a\u00020\u0018X\u0087\"¢\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u0013\u0010\u001e\u001a\u00020\u001bX\u0083\u0080\u0002¢\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\u0016\u0010 \u001a\u00020\u00158\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\b\u001f\u0010\u0017R\u0013\u0010\b\u001a\u00020!X\u0083\u0080\u0002¢\u0006\u0006\n\u0004\b\"\u0010\u001dR\u0018\u0010\u0016\u001a\u0004\u0018\u00010\u000f8\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\b#\u0010\u0010R\u0012\u0010%\u001a\u00020$X\u0087\"¢\u0006\u0006\n\u0004\b%\u0010&R\u0018\u0010\t\u001a\u0004\u0018\u00010'8\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\b(\u0010)"}, d2 = {"Lid/dana/cashier/topupandpay/fragment/TopUpAndPaySourceFragment;", "Lid/dana/cashier/fragment/BaseCashierFragment;", "", "getAuthRequestContext", "()V", "", "getLayout", "()I", "PlaceComponentResult", "getErrorConfigVersion", "onStart", "moveToNextValue", "Lid/dana/cashier/model/CashierPayMethodModel;", "Lid/dana/cashier/domain/model/CashierPayRequest;", "(Lid/dana/cashier/model/CashierPayMethodModel;)Lid/dana/cashier/domain/model/CashierPayRequest;", "Lid/dana/nearbyme/merchantdetail/model/MoneyViewModel;", "Lid/dana/nearbyme/merchantdetail/model/MoneyViewModel;", "BuiltInFictitiousFunctionClassFactory", "Lid/dana/cashier/tracker/CashierAnalyticTracker;", "cashierAnalyticTracker", "Lid/dana/cashier/tracker/CashierAnalyticTracker;", "", "NetworkUserEntityData$$ExternalSyntheticLambda0", "Ljava/lang/String;", "Lid/dana/cashier/presenter/CashierPresenter;", "cashierPresenter", "Lid/dana/cashier/presenter/CashierPresenter;", "Lid/dana/cashier/model/CashierCheckoutRequestModel;", "NetworkUserEntityData$$ExternalSyntheticLambda2", "Lkotlin/Lazy;", "KClassImpl$Data$declaredNonStaticMembers$2", "NetworkUserEntityData$$ExternalSyntheticLambda1", "MyBillsEntityDataFactory", "Lid/dana/cashier/model/PayResultModel;", "initRecordTimeStamp", "GetContactSyncConfig", "Lid/dana/cashier/presenter/TopUpAndPayPresenter;", "topUpAndPayPresenter", "Lid/dana/cashier/presenter/TopUpAndPayPresenter;", "Lid/dana/cashier/model/TopUpConsultModel;", "DatabaseTableConfigUtil", "Lid/dana/cashier/model/TopUpConsultModel;", "<init>", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class TopUpAndPaySourceFragment extends BaseCashierFragment {

    /* renamed from: Companion  reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static ArrayList<String> KClassImpl$Data$declaredNonStaticMembers$2;

    /* renamed from: DatabaseTableConfigUtil  reason: from kotlin metadata */
    private TopUpConsultModel getErrorConfigVersion;

    /* renamed from: GetContactSyncConfig  reason: from kotlin metadata */
    private MoneyViewModel NetworkUserEntityData$$ExternalSyntheticLambda0;
    @Inject
    public CashierAnalyticTracker cashierAnalyticTracker;
    @Inject
    public CashierPresenter cashierPresenter;

    /* renamed from: moveToNextValue  reason: from kotlin metadata */
    private MoneyViewModel BuiltInFictitiousFunctionClassFactory;
    @Inject
    public TopUpAndPayPresenter topUpAndPayPresenter;
    public Map<Integer, View> PlaceComponentResult = new LinkedHashMap();

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda0  reason: from kotlin metadata */
    private String getAuthRequestContext = "";

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda1  reason: from kotlin metadata */
    private String MyBillsEntityDataFactory = "";

    /* renamed from: initRecordTimeStamp  reason: from kotlin metadata */
    private final Lazy PlaceComponentResult = LazyKt.lazy(new Function0<PayResultModel>() { // from class: id.dana.cashier.topupandpay.fragment.TopUpAndPaySourceFragment$payResultModel$2
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final PayResultModel invoke() {
            return new PayResultModel(null, null, null, null, null, null, null, null, null, null, false, false, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, false, null, null, null, false, null, null, null, null, false, null, null, null, null, null, null, null, null, null, null, -1, 524287, null);
        }
    });

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda2  reason: from kotlin metadata */
    private final Lazy KClassImpl$Data$declaredNonStaticMembers$2 = LazyKt.lazy(new Function0<CashierCheckoutRequestModel>() { // from class: id.dana.cashier.topupandpay.fragment.TopUpAndPaySourceFragment$cashierRequestModel$2
        /* JADX INFO: Access modifiers changed from: package-private */
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final CashierCheckoutRequestModel invoke() {
            String str;
            str = TopUpAndPaySourceFragment.this.getAuthRequestContext;
            return new CashierCheckoutRequestModel(str, null, null, null, null, null, null, null, null, null, null, false, null, 8190, null);
        }
    });

    @Override // id.dana.cashier.fragment.BaseCashierFragment
    public final View BuiltInFictitiousFunctionClassFactory(int i) {
        View findViewById;
        Map<Integer, View> map = this.PlaceComponentResult;
        View view = map.get(Integer.valueOf(i));
        if (view == null) {
            View getAuthRequestContext = getGetAuthRequestContext();
            if (getAuthRequestContext == null || (findViewById = getAuthRequestContext.findViewById(i)) == null) {
                return null;
            }
            map.put(Integer.valueOf(i), findViewById);
            return findViewById;
        }
        return view;
    }

    @Override // id.dana.cashier.fragment.BaseCashierFragment
    public final void KClassImpl$Data$declaredNonStaticMembers$2() {
        this.PlaceComponentResult.clear();
    }

    @Override // id.dana.base.BaseFragment
    public final int getLayout() {
        return R.layout.fragment_topup_and_pay_source;
    }

    @Override // id.dana.cashier.fragment.BaseCashierFragment
    public final void getAuthRequestContext() {
        String string = getString(R.string.topup_and_pay_title);
        Intrinsics.checkNotNullExpressionValue(string, "");
        getAuthRequestContext(string);
    }

    @Override // androidx.fragment.app.Fragment
    public final void onStart() {
        super.onStart();
        CashierAnalyticTracker cashierAnalyticTracker = this.cashierAnalyticTracker;
        if (cashierAnalyticTracker == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            cashierAnalyticTracker = null;
        }
        cashierAnalyticTracker.BuiltInFictitiousFunctionClassFactory(this.getAuthRequestContext);
    }

    @Override // id.dana.cashier.fragment.BaseCashierFragment
    public final void moveToNextValue() {
        Bundle arguments = getArguments();
        if (arguments != null) {
            String string = arguments.getString("arg_pay_method_filter", "");
            Intrinsics.checkNotNullExpressionValue(string, "");
            this.MyBillsEntityDataFactory = string;
            String string2 = arguments.getString(CashierKeyParams.CASHIER_ORDER_ID, "");
            Intrinsics.checkNotNullExpressionValue(string2, "");
            this.getAuthRequestContext = string2;
            final TopUpAndPayPresenter topUpAndPayPresenter = this.topUpAndPayPresenter;
            if (topUpAndPayPresenter == null) {
                Intrinsics.throwUninitializedPropertyAccessException("");
                topUpAndPayPresenter = null;
            }
            String str = this.MyBillsEntityDataFactory;
            String str2 = this.getAuthRequestContext;
            Intrinsics.checkNotNullParameter(str, "");
            Intrinsics.checkNotNullParameter(str2, "");
            topUpAndPayPresenter.GetContactSyncConfig.showProgress();
            topUpAndPayPresenter.moveToNextValue.execute(GetTopUpConsult.Params.INSTANCE.createTopUpConsultParams(str, str2), new Function1<TopUpConsult, Unit>() { // from class: id.dana.cashier.presenter.TopUpAndPayPresenter$getTopUpConsult$1
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public final /* bridge */ /* synthetic */ Unit invoke(TopUpConsult topUpConsult) {
                    invoke2(topUpConsult);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke  reason: avoid collision after fix types in other method */
                public final void invoke2(TopUpConsult topUpConsult) {
                    TopUpConsultModelMapper topUpConsultModelMapper;
                    TopUpAndPayContract.View view;
                    TopUpAndPayContract.View view2;
                    TopUpAndPayContract.View view3;
                    Intrinsics.checkNotNullParameter(topUpConsult, "");
                    topUpConsultModelMapper = TopUpAndPayPresenter.this.lookAheadTest;
                    TopUpConsultModel apply = topUpConsultModelMapper.apply(topUpConsult);
                    if (!Intrinsics.areEqual(apply.isLayoutRequested, Boolean.TRUE)) {
                        view = TopUpAndPayPresenter.this.GetContactSyncConfig;
                        view.scheduleImpl(apply.moveToNextValue);
                    } else {
                        List<CashierPayMethodModel> KClassImpl$Data$declaredNonStaticMembers$22 = PayMethodViewDtoModelKt.KClassImpl$Data$declaredNonStaticMembers$2(apply.NetworkUserEntityData$$ExternalSyntheticLambda2);
                        view3 = TopUpAndPayPresenter.this.GetContactSyncConfig;
                        Intrinsics.checkNotNullExpressionValue(apply, "");
                        view3.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$22, apply);
                    }
                    view2 = TopUpAndPayPresenter.this.GetContactSyncConfig;
                    view2.dismissProgress();
                }
            }, new Function1<Throwable, Unit>() { // from class: id.dana.cashier.presenter.TopUpAndPayPresenter$getTopUpConsult$2
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
                    TopUpAndPayContract.View view;
                    Context context;
                    TopUpAndPayContract.View view2;
                    Intrinsics.checkNotNullParameter(th, "");
                    view = TopUpAndPayPresenter.this.GetContactSyncConfig;
                    context = TopUpAndPayPresenter.this.KClassImpl$Data$declaredNonStaticMembers$2;
                    view.scheduleImpl(ErrorUtil.PlaceComponentResult(th, context));
                    view2 = TopUpAndPayPresenter.this.GetContactSyncConfig;
                    view2.dismissProgress();
                }
            });
            this.BuiltInFictitiousFunctionClassFactory = (MoneyViewModel) arguments.getParcelable("balance");
            this.NetworkUserEntityData$$ExternalSyntheticLambda0 = (MoneyViewModel) arguments.getParcelable(CashierKeyParams.TOTAL_AMOUNT);
        }
    }

    @Override // id.dana.cashier.fragment.BaseCashierFragment
    public final void PlaceComponentResult() {
        DaggerTopUpAndPayComponent.Builder MyBillsEntityDataFactory = DaggerTopUpAndPayComponent.MyBillsEntityDataFactory();
        MyBillsEntityDataFactory.getAuthRequestContext = (ApplicationComponent) Preconditions.getAuthRequestContext(getApplicationComponent());
        MyBillsEntityDataFactory.PlaceComponentResult = (TopUpAndPayModule) Preconditions.getAuthRequestContext(new TopUpAndPayModule(new CashierViewListener() { // from class: id.dana.cashier.topupandpay.fragment.TopUpAndPaySourceFragment$topUpAndPayModule$1
            @Override // id.dana.cashier.CashierViewListener, id.dana.cashier.TopUpAndPayContract.View
            public final void getAuthRequestContext(TopUpPayModel p0) {
                Intrinsics.checkNotNullParameter(p0, "");
            }

            @Override // id.dana.cashier.CashierViewListener, id.dana.cashier.TopUpAndPayContract.View
            public final void getAuthRequestContext(List<? extends CashierPayMethodModel> p0, TopUpConsultModel p1) {
                Intrinsics.checkNotNullParameter(p1, "");
                ArrayList arrayList = new ArrayList();
                ArrayList arrayList2 = new ArrayList();
                ArrayList arrayList3 = new ArrayList();
                if (p0 != null) {
                    for (CashierPayMethodModel cashierPayMethodModel : p0) {
                        int scheduleImpl = cashierPayMethodModel.getScheduleImpl();
                        if (scheduleImpl == 0) {
                            arrayList.add(cashierPayMethodModel);
                        } else if (scheduleImpl == 3) {
                            arrayList2.add(cashierPayMethodModel);
                        } else if (scheduleImpl == 4) {
                            arrayList3.add(cashierPayMethodModel);
                        }
                    }
                }
                TopUpAndPayMethodView topUpAndPayMethodView = (TopUpAndPayMethodView) TopUpAndPaySourceFragment.this.BuiltInFictitiousFunctionClassFactory(R.id.res_0x7f0a1372_shareactivitybottomsheetdialog_setavatar_1);
                if (topUpAndPayMethodView != null) {
                    topUpAndPayMethodView.setItems(arrayList, 0);
                }
                TopUpAndPayMethodView topUpAndPayMethodView2 = (TopUpAndPayMethodView) TopUpAndPaySourceFragment.this.BuiltInFictitiousFunctionClassFactory(R.id.res_0x7f0a1373_flowkt__zipkt_combinetransform_7);
                if (topUpAndPayMethodView2 != null) {
                    topUpAndPayMethodView2.setItems(arrayList2, 3);
                }
                TopUpAndPayMethodView topUpAndPayMethodView3 = (TopUpAndPayMethodView) TopUpAndPaySourceFragment.this.BuiltInFictitiousFunctionClassFactory(R.id.res_0x7f0a1371_shareactivitybottomsheetdialog_setavatar_2);
                if (topUpAndPayMethodView3 != null) {
                    topUpAndPayMethodView3.setItems(arrayList3, 4);
                }
                TopUpAndPaySourceFragment.this.getErrorConfigVersion = p1;
            }

            @Override // id.dana.cashier.CashierViewListener, id.dana.cashier.TopUpAndPayContract.View
            public final void BuiltInFictitiousFunctionClassFactory(CashierPayModel cashierPayModel) {
                Intrinsics.checkNotNullParameter(cashierPayModel, "");
                TopUpAndPaySourceFragment.KClassImpl$Data$declaredNonStaticMembers$2(TopUpAndPaySourceFragment.this, cashierPayModel);
            }

            @Override // id.dana.cashier.CashierViewListener, id.dana.cashier.CashierContract.View, id.dana.cashier.TopUpAndPayContract.View
            public final boolean KClassImpl$Data$declaredNonStaticMembers$2() {
                return LocationUtil.getAuthRequestContext(TopUpAndPaySourceFragment.this.getContext());
            }

            @Override // id.dana.cashier.CashierViewListener, id.dana.base.AbstractContractKt.AbstractView, id.dana.base.AbstractContract.AbstractView
            public final void showProgress() {
                TopUpAndPaySourceFragment.this.readMicros();
            }

            @Override // id.dana.cashier.CashierViewListener, id.dana.base.AbstractContractKt.AbstractView, id.dana.base.AbstractContract.AbstractView
            public final void dismissProgress() {
                TopUpAndPaySourceFragment.this.scheduleImpl();
            }

            @Override // id.dana.cashier.CashierViewListener, id.dana.base.AbstractContractKt.AbstractView, id.dana.base.AbstractContract.AbstractView
            public final void onError(String p0) {
                BaseCashierFragment.KClassImpl$Data$declaredNonStaticMembers$2(TopUpAndPaySourceFragment.this, p0);
            }

            @Override // id.dana.cashier.CashierViewListener, id.dana.cashier.TopUpAndPayContract.View
            public final void lookAheadTest(String str) {
                BaseCashierFragment.KClassImpl$Data$declaredNonStaticMembers$2(TopUpAndPaySourceFragment.this, str);
            }

            @Override // id.dana.cashier.CashierViewListener, id.dana.cashier.TopUpAndPayContract.View
            public final void scheduleImpl(String p0) {
                BaseCashierFragment.KClassImpl$Data$declaredNonStaticMembers$2(TopUpAndPaySourceFragment.this, p0);
                TopUpAndPaySourceFragment.PlaceComponentResult(TopUpAndPaySourceFragment.this);
            }
        }));
        MyBillsEntityDataFactory.KClassImpl$Data$declaredNonStaticMembers$2 = (CashierModule) Preconditions.getAuthRequestContext(new CashierModule(new CashierViewListener() { // from class: id.dana.cashier.topupandpay.fragment.TopUpAndPaySourceFragment$cashierModule$1
            @Override // id.dana.cashier.CashierViewListener, id.dana.cashier.CashierContract.View
            public final void MyBillsEntityDataFactory(CashierCheckoutModel p0) {
                Intrinsics.checkNotNullParameter(p0, "");
                CashierPayMethodModel cashierPayMethodModel = TopUpAndPaySourceFragment.MyBillsEntityDataFactory(TopUpAndPaySourceFragment.this).I;
                if (cashierPayMethodModel != null) {
                    TopUpAndPaySourceFragment topUpAndPaySourceFragment = TopUpAndPaySourceFragment.this;
                    if (cashierPayMethodModel instanceof CashierPayMethodModel.VirtualAccountPayMethod) {
                        TopUpAndPaySourceFragment.BuiltInFictitiousFunctionClassFactory(topUpAndPaySourceFragment, cashierPayMethodModel);
                    } else if (cashierPayMethodModel instanceof CashierPayMethodModel.OTCPayMethod) {
                        TopUpAndPaySourceFragment.MyBillsEntityDataFactory(topUpAndPaySourceFragment, cashierPayMethodModel);
                    } else {
                        TopUpAndPaySourceFragment.PlaceComponentResult(topUpAndPaySourceFragment, cashierPayMethodModel);
                    }
                }
            }

            @Override // id.dana.cashier.CashierViewListener, id.dana.base.AbstractContractKt.AbstractView, id.dana.base.AbstractContract.AbstractView
            public final void showProgress() {
                TopUpAndPaySourceFragment.this.readMicros();
            }

            @Override // id.dana.cashier.CashierViewListener, id.dana.base.AbstractContractKt.AbstractView, id.dana.base.AbstractContract.AbstractView
            public final void dismissProgress() {
                TopUpAndPaySourceFragment.this.scheduleImpl();
            }

            @Override // id.dana.cashier.CashierViewListener, id.dana.base.AbstractContractKt.AbstractView, id.dana.base.AbstractContract.AbstractView
            public final void onError(String p0) {
                BaseCashierFragment.KClassImpl$Data$declaredNonStaticMembers$2(TopUpAndPaySourceFragment.this, p0);
            }
        }));
        MyBillsEntityDataFactory.BuiltInFictitiousFunctionClassFactory = (CashierAnalyticModule) Preconditions.getAuthRequestContext(new CashierAnalyticModule());
        MyBillsEntityDataFactory.MyBillsEntityDataFactory().BuiltInFictitiousFunctionClassFactory(this);
        AbstractContract.AbstractPresenter[] abstractPresenterArr = new AbstractContract.AbstractPresenter[2];
        TopUpAndPayPresenter topUpAndPayPresenter = this.topUpAndPayPresenter;
        CashierPresenter cashierPresenter = null;
        if (topUpAndPayPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            topUpAndPayPresenter = null;
        }
        abstractPresenterArr[0] = topUpAndPayPresenter;
        CashierPresenter cashierPresenter2 = this.cashierPresenter;
        if (cashierPresenter2 != null) {
            cashierPresenter = cashierPresenter2;
        } else {
            Intrinsics.throwUninitializedPropertyAccessException("");
        }
        abstractPresenterArr[1] = cashierPresenter;
        registerPresenter(abstractPresenterArr);
    }

    private final CashierPayRequest PlaceComponentResult(CashierPayMethodModel cashierPayMethodModel) {
        CashierPayChannelModel cashierPayChannelModel;
        CashierPayChannelModel cashierPayChannelModel2;
        CashierPayChannelModel cashierPayChannelModel3;
        String str = this.getAuthRequestContext;
        CashierPayMethodModel.VirtualAccountPayMethod errorConfigVersion = CashierPayMethodModelKt.getErrorConfigVersion(cashierPayMethodModel);
        String str2 = (errorConfigVersion == null || (cashierPayChannelModel3 = errorConfigVersion.MyBillsEntityDataFactory) == null) ? null : cashierPayChannelModel3.BottomSheetCardBindingView$watcherCardNumberView$1;
        CashierPayMethodModel.VirtualAccountPayMethod errorConfigVersion2 = CashierPayMethodModelKt.getErrorConfigVersion(cashierPayMethodModel);
        String str3 = (errorConfigVersion2 == null || (cashierPayChannelModel2 = errorConfigVersion2.MyBillsEntityDataFactory) == null) ? null : cashierPayChannelModel2.B;
        CashierPayMethodModel.VirtualAccountPayMethod errorConfigVersion3 = CashierPayMethodModelKt.getErrorConfigVersion(cashierPayMethodModel);
        return new CashierPayRequest("topupPay", str3, str, null, str2, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, Intrinsics.areEqual(getBaseActivity().getSource(), "Send Money") ? NativePageType.SEND_MONEY : null, null, null, (errorConfigVersion3 == null || (cashierPayChannelModel = errorConfigVersion3.MyBillsEntityDataFactory) == null) ? null : cashierPayChannelModel.PrepareContext, null, null, null, "1.0", null, KClassImpl$Data$declaredNonStaticMembers$2, null, null, null, null, null, null, null, null, null, -1149239320, 1022, null);
    }

    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0012\u0010\u0013JE\u0010\u000b\u001a\u00020\n2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0004\u001a\u00020\u00022\b\u0010\u0006\u001a\u0004\u0018\u00010\u00052\b\u0010\u0007\u001a\u0004\u0018\u00010\u00052\u000e\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\bH\u0007¢\u0006\u0004\b\u000b\u0010\fR*\u0010\u0011\u001a\u0016\u0012\u0004\u0012\u00020\u0002\u0018\u00010\rj\n\u0012\u0004\u0012\u00020\u0002\u0018\u0001`\u000e8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010"}, d2 = {"Lid/dana/cashier/topupandpay/fragment/TopUpAndPaySourceFragment$Companion;", "", "", "p0", "p1", "Lid/dana/nearbyme/merchantdetail/model/MoneyViewModel;", "p2", "p3", "", "p4", "Lid/dana/cashier/topupandpay/fragment/TopUpAndPaySourceFragment;", "MyBillsEntityDataFactory", "(Ljava/lang/String;Ljava/lang/String;Lid/dana/nearbyme/merchantdetail/model/MoneyViewModel;Lid/dana/nearbyme/merchantdetail/model/MoneyViewModel;Ljava/util/List;)Lid/dana/cashier/topupandpay/fragment/TopUpAndPaySourceFragment;", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "KClassImpl$Data$declaredNonStaticMembers$2", "Ljava/util/ArrayList;", "PlaceComponentResult", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes4.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public static TopUpAndPaySourceFragment MyBillsEntityDataFactory(String p0, String p1, MoneyViewModel p2, MoneyViewModel p3, List<String> p4) {
            Intrinsics.checkNotNullParameter(p1, "");
            if (p4 != null) {
                TopUpAndPaySourceFragment.KClassImpl$Data$declaredNonStaticMembers$2 = new ArrayList();
                ArrayList arrayList = TopUpAndPaySourceFragment.KClassImpl$Data$declaredNonStaticMembers$2;
                if (arrayList != null) {
                    arrayList.addAll(p4);
                }
            }
            TopUpAndPaySourceFragment topUpAndPaySourceFragment = new TopUpAndPaySourceFragment();
            Bundle bundle = new Bundle();
            bundle.putString("arg_pay_method_filter", p0);
            bundle.putString(CashierKeyParams.CASHIER_ORDER_ID, p1);
            bundle.putParcelable("balance", p2);
            bundle.putParcelable(CashierKeyParams.TOTAL_AMOUNT, p3);
            topUpAndPaySourceFragment.setArguments(bundle);
            return topUpAndPaySourceFragment;
        }
    }

    public static final /* synthetic */ PayResultModel MyBillsEntityDataFactory(TopUpAndPaySourceFragment topUpAndPaySourceFragment) {
        return (PayResultModel) topUpAndPaySourceFragment.PlaceComponentResult.getValue();
    }

    public static final /* synthetic */ void PlaceComponentResult(TopUpAndPaySourceFragment topUpAndPaySourceFragment, CashierPayMethodModel cashierPayMethodModel) {
        TopUpConsultModel topUpConsultModel;
        CashierPayMethodModel.CardPayMethod MyBillsEntityDataFactory = CashierPayMethodModelKt.MyBillsEntityDataFactory(cashierPayMethodModel);
        if (MyBillsEntityDataFactory == null || (topUpConsultModel = topUpAndPaySourceFragment.getErrorConfigVersion) == null) {
            return;
        }
        BaseActivity baseActivity = topUpAndPaySourceFragment.getBaseActivity();
        PayActivity payActivity = baseActivity instanceof PayActivity ? (PayActivity) baseActivity : null;
        if (payActivity != null) {
            TopUpAndPayInputFragment.Companion companion = TopUpAndPayInputFragment.INSTANCE;
            payActivity.addFragment(TopUpAndPayInputFragment.Companion.getAuthRequestContext(topUpConsultModel, MyBillsEntityDataFactory, topUpAndPaySourceFragment.NetworkUserEntityData$$ExternalSyntheticLambda0, topUpAndPaySourceFragment.getAuthRequestContext, topUpAndPaySourceFragment.BuiltInFictitiousFunctionClassFactory, KClassImpl$Data$declaredNonStaticMembers$2));
        }
    }

    public static final /* synthetic */ void KClassImpl$Data$declaredNonStaticMembers$2(TopUpAndPaySourceFragment topUpAndPaySourceFragment, CashierPayModel cashierPayModel) {
        PaymentResultFragment BuiltInFictitiousFunctionClassFactory;
        String str;
        String str2;
        String format;
        CashierAnalyticTracker cashierAnalyticTracker;
        AttributeCashierPayModel attributeCashierPayModel = cashierPayModel.KClassImpl$Data$declaredNonStaticMembers$2;
        if (attributeCashierPayModel != null) {
            CashierPayMethodModel cashierPayMethodModel = ((PayResultModel) topUpAndPaySourceFragment.PlaceComponentResult.getValue()).I;
            if (cashierPayMethodModel != null) {
                String initRecordTimeStamp = cashierPayMethodModel.initRecordTimeStamp();
                CashierAnalyticTracker cashierAnalyticTracker2 = topUpAndPaySourceFragment.cashierAnalyticTracker;
                if (cashierAnalyticTracker2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("");
                    cashierAnalyticTracker2 = null;
                }
                cashierAnalyticTracker2.getAuthRequestContext(CollectionsKt.listOf(initRecordTimeStamp).toString());
                CashierAnalyticTracker cashierAnalyticTracker3 = topUpAndPaySourceFragment.cashierAnalyticTracker;
                if (cashierAnalyticTracker3 != null) {
                    cashierAnalyticTracker = cashierAnalyticTracker3;
                } else {
                    Intrinsics.throwUninitializedPropertyAccessException("");
                    cashierAnalyticTracker = null;
                }
                String str3 = topUpAndPaySourceFragment.getAuthRequestContext;
                cashierPayMethodModel.lookAheadTest = true;
                Unit unit = Unit.INSTANCE;
                ArrayList<String> arrayList = KClassImpl$Data$declaredNonStaticMembers$2;
                if (arrayList == null) {
                    arrayList = CollectionsKt.emptyList();
                }
                List list = arrayList;
                BaseActivity baseActivity = topUpAndPaySourceFragment.getBaseActivity();
                PayActivity payActivity = baseActivity instanceof PayActivity ? (PayActivity) baseActivity : null;
                AddOnTrackingModel addOnTrackingModel = payActivity != null ? payActivity.getAddOnTrackingModel() : null;
                String str4 = ((PayResultModel) topUpAndPaySourceFragment.PlaceComponentResult.getValue()).VerifyPinStateManager$executeRiskChallenge$2$2;
                String source = topUpAndPaySourceFragment.getBaseActivity().getSource();
                Intrinsics.checkNotNullExpressionValue(source, "");
                BaseActivity baseActivity2 = topUpAndPaySourceFragment.getBaseActivity();
                PayActivity payActivity2 = baseActivity2 instanceof PayActivity ? (PayActivity) baseActivity2 : null;
                str = "";
                cashierAnalyticTracker.MyBillsEntityDataFactory(new PaymentExecutionTrackerParams(str3, cashierPayMethodModel, list, addOnTrackingModel, str4, source, null, payActivity2 != null ? payActivity2.getFeatureTimeModel() : null, 64, null));
            } else {
                str = "";
            }
            PayResultModel payResultModel = (PayResultModel) topUpAndPaySourceFragment.PlaceComponentResult.getValue();
            MoneyViewModel moneyViewModel = attributeCashierPayModel.X;
            if (moneyViewModel != null) {
                StringBuilder sb = new StringBuilder();
                sb.append(moneyViewModel.KClassImpl$Data$declaredNonStaticMembers$2);
                format = NumberFormat.getNumberInstance(LocaleUtil.BuiltInFictitiousFunctionClassFactory()).format(moneyViewModel.MyBillsEntityDataFactory());
                if (format == null) {
                    format = str;
                }
                sb.append(format);
                str2 = sb.toString();
            } else {
                str2 = null;
            }
            if (str2 == null) {
                str2 = str;
            }
            payResultModel.AppCompatEmojiTextHelper = str2;
            String str5 = attributeCashierPayModel.com.alibaba.griver.image.photo.utils.DiskFormatter.GB java.lang.String;
            if (str5 == null) {
                str5 = str;
            }
            Intrinsics.checkNotNullParameter(str5, str);
            payResultModel.com.alibaba.griver.image.photo.utils.DiskFormatter.B java.lang.String = str5;
            String str6 = attributeCashierPayModel.KClassImpl$Data$declaredNonStaticMembers$2;
            if (str6 == null) {
                str6 = str;
            }
            Intrinsics.checkNotNullParameter(str6, str);
            payResultModel.BuiltInFictitiousFunctionClassFactory = str6;
            payResultModel.VerifyPinStateManager$executeRiskChallenge$2$1 = attributeCashierPayModel.id.dana.sendmoney.summary.SummaryActivity.DAYS java.lang.String;
            String str7 = attributeCashierPayModel.DatabaseTableConfigUtil;
            if (str7 == null) {
                str7 = str;
            }
            Intrinsics.checkNotNullParameter(str7, str);
            payResultModel.A = str7;
            payResultModel.getValueOfTouchPositionAbsolute = "redirect";
            String str8 = str;
            String str9 = cashierPayModel.MyBillsEntityDataFactory;
            if (str9 == null) {
                str9 = topUpAndPaySourceFragment.getAuthRequestContext;
            }
            Intrinsics.checkNotNullParameter(str9, str8);
            payResultModel.getErrorConfigVersion = str9;
            payResultModel.NetworkUserEntityData$$ExternalSyntheticLambda7 = true;
            payResultModel.G = KClassImpl$Data$declaredNonStaticMembers$2;
            payResultModel.FragmentBottomSheetPaymentSettingBinding = attributeCashierPayModel.getSupportButtonTintMode;
        }
        PayResultModel payResultModel2 = (PayResultModel) topUpAndPaySourceFragment.PlaceComponentResult.getValue();
        BaseActivity baseActivity3 = topUpAndPaySourceFragment.getBaseActivity();
        PayActivity payActivity3 = baseActivity3 instanceof PayActivity ? (PayActivity) baseActivity3 : null;
        if (payActivity3 != null) {
            PaymentResultFragment.Companion companion = PaymentResultFragment.KClassImpl$Data$declaredNonStaticMembers$2;
            BuiltInFictitiousFunctionClassFactory = PaymentResultFragment.Companion.BuiltInFictitiousFunctionClassFactory(payResultModel2, false);
            payActivity3.addFragment(BuiltInFictitiousFunctionClassFactory);
        }
    }

    public static final /* synthetic */ void PlaceComponentResult(TopUpAndPaySourceFragment topUpAndPaySourceFragment) {
        BaseActivity baseActivity = topUpAndPaySourceFragment.getBaseActivity();
        PayActivity payActivity = baseActivity instanceof PayActivity ? (PayActivity) baseActivity : null;
        if (payActivity != null) {
            payActivity.onBackPressed();
        }
    }

    public static final /* synthetic */ void MyBillsEntityDataFactory(TopUpAndPaySourceFragment topUpAndPaySourceFragment, CashierPayMethodModel cashierPayMethodModel) {
        CashierPayMethodModel cashierPayMethodModel2;
        CashierPayChannelModel cashierPayChannelModel;
        CashierPayChannelModel cashierPayChannelModel2;
        CashierPayChannelModel cashierPayChannelModel3;
        TopUpAndPayPresenter topUpAndPayPresenter = topUpAndPaySourceFragment.topUpAndPayPresenter;
        if (topUpAndPayPresenter != null) {
            cashierPayMethodModel2 = cashierPayMethodModel;
        } else {
            Intrinsics.throwUninitializedPropertyAccessException("");
            cashierPayMethodModel2 = cashierPayMethodModel;
            topUpAndPayPresenter = null;
        }
        Intrinsics.checkNotNullParameter(cashierPayMethodModel2, "");
        String str = topUpAndPaySourceFragment.getAuthRequestContext;
        CashierPayMethodModel.OTCPayMethod PlaceComponentResult = CashierPayMethodModelKt.PlaceComponentResult(cashierPayMethodModel);
        String str2 = (PlaceComponentResult == null || (cashierPayChannelModel3 = PlaceComponentResult.BuiltInFictitiousFunctionClassFactory) == null) ? null : cashierPayChannelModel3.BottomSheetCardBindingView$watcherCardNumberView$1;
        CashierPayMethodModel.OTCPayMethod PlaceComponentResult2 = CashierPayMethodModelKt.PlaceComponentResult(cashierPayMethodModel);
        String str3 = (PlaceComponentResult2 == null || (cashierPayChannelModel2 = PlaceComponentResult2.BuiltInFictitiousFunctionClassFactory) == null) ? null : cashierPayChannelModel2.B;
        CashierPayMethodModel.OTCPayMethod PlaceComponentResult3 = CashierPayMethodModelKt.PlaceComponentResult(cashierPayMethodModel);
        topUpAndPayPresenter.KClassImpl$Data$declaredNonStaticMembers$2(new CashierPayRequest("topupPay", str3, str, null, str2, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, Intrinsics.areEqual(topUpAndPaySourceFragment.getBaseActivity().getSource(), "Send Money") ? NativePageType.SEND_MONEY : null, null, null, (PlaceComponentResult3 == null || (cashierPayChannelModel = PlaceComponentResult3.BuiltInFictitiousFunctionClassFactory) == null) ? null : cashierPayChannelModel.PrepareContext, null, null, null, "1.0", null, KClassImpl$Data$declaredNonStaticMembers$2, null, null, null, null, null, null, null, null, null, -1149239320, 1022, null), cashierPayMethodModel.getScheduleImpl());
    }

    public static final /* synthetic */ void BuiltInFictitiousFunctionClassFactory(TopUpAndPaySourceFragment topUpAndPaySourceFragment, CashierPayMethodModel cashierPayMethodModel) {
        CashierPayMethodModel.VirtualAccountPayMethod errorConfigVersion = CashierPayMethodModelKt.getErrorConfigVersion(cashierPayMethodModel);
        TopUpAndPayPresenter topUpAndPayPresenter = null;
        String str = errorConfigVersion != null ? errorConfigVersion.getAuthRequestContext : null;
        if (str == null || str.length() == 0) {
            TopUpAndPayPresenter topUpAndPayPresenter2 = topUpAndPaySourceFragment.topUpAndPayPresenter;
            if (topUpAndPayPresenter2 != null) {
                topUpAndPayPresenter = topUpAndPayPresenter2;
            } else {
                Intrinsics.throwUninitializedPropertyAccessException("");
            }
            topUpAndPayPresenter.KClassImpl$Data$declaredNonStaticMembers$2(topUpAndPaySourceFragment.PlaceComponentResult(cashierPayMethodModel), cashierPayMethodModel.getScheduleImpl());
            return;
        }
        TopUpAndPayPresenter topUpAndPayPresenter3 = topUpAndPaySourceFragment.topUpAndPayPresenter;
        if (topUpAndPayPresenter3 != null) {
            topUpAndPayPresenter = topUpAndPayPresenter3;
        } else {
            Intrinsics.throwUninitializedPropertyAccessException("");
        }
        topUpAndPayPresenter.BuiltInFictitiousFunctionClassFactory(topUpAndPaySourceFragment.PlaceComponentResult(cashierPayMethodModel), cashierPayMethodModel.getScheduleImpl(), true);
    }

    public static final /* synthetic */ void lookAheadTest(TopUpAndPaySourceFragment topUpAndPaySourceFragment) {
        CashierCheckoutRequestModel cashierCheckoutRequestModel = (CashierCheckoutRequestModel) topUpAndPaySourceFragment.KClassImpl$Data$declaredNonStaticMembers$2.getValue();
        cashierCheckoutRequestModel.initRecordTimeStamp = Boolean.TRUE;
        cashierCheckoutRequestModel.GetContactSyncConfig = KClassImpl$Data$declaredNonStaticMembers$2;
        CashierPresenter cashierPresenter = topUpAndPaySourceFragment.cashierPresenter;
        if (cashierPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            cashierPresenter = null;
        }
        cashierPresenter.PlaceComponentResult(cashierCheckoutRequestModel, false);
    }

    @Override // id.dana.cashier.fragment.BaseCashierFragment
    public final void getErrorConfigVersion() {
        TopUpAndPayMethodView topUpAndPayMethodView = (TopUpAndPayMethodView) BuiltInFictitiousFunctionClassFactory(R.id.res_0x7f0a1371_shareactivitybottomsheetdialog_setavatar_2);
        if (topUpAndPayMethodView != null) {
            topUpAndPayMethodView.setOnClickTopUpAndPayMethodListener(new Function1<CashierPayMethodModel, Unit>() { // from class: id.dana.cashier.topupandpay.fragment.TopUpAndPaySourceFragment$setClickTopUpAndPayAgentListener$1
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public final /* bridge */ /* synthetic */ Unit invoke(CashierPayMethodModel cashierPayMethodModel) {
                    invoke2(cashierPayMethodModel);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke  reason: avoid collision after fix types in other method */
                public final void invoke2(CashierPayMethodModel cashierPayMethodModel) {
                    Intrinsics.checkNotNullParameter(cashierPayMethodModel, "");
                    TopUpAndPaySourceFragment.MyBillsEntityDataFactory(TopUpAndPaySourceFragment.this).I = cashierPayMethodModel;
                    ArrayList arrayList = TopUpAndPaySourceFragment.KClassImpl$Data$declaredNonStaticMembers$2;
                    if (!(arrayList == null || arrayList.isEmpty())) {
                        TopUpAndPaySourceFragment.lookAheadTest(TopUpAndPaySourceFragment.this);
                    } else {
                        TopUpAndPaySourceFragment.MyBillsEntityDataFactory(TopUpAndPaySourceFragment.this, cashierPayMethodModel);
                    }
                }
            });
        }
        TopUpAndPayMethodView topUpAndPayMethodView2 = (TopUpAndPayMethodView) BuiltInFictitiousFunctionClassFactory(R.id.res_0x7f0a1372_shareactivitybottomsheetdialog_setavatar_1);
        if (topUpAndPayMethodView2 != null) {
            topUpAndPayMethodView2.setOnClickTopUpAndPayMethodListener(new Function1<CashierPayMethodModel, Unit>() { // from class: id.dana.cashier.topupandpay.fragment.TopUpAndPaySourceFragment$setClickTopUpAndPayBankCardListener$1
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public final /* bridge */ /* synthetic */ Unit invoke(CashierPayMethodModel cashierPayMethodModel) {
                    invoke2(cashierPayMethodModel);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke  reason: avoid collision after fix types in other method */
                public final void invoke2(CashierPayMethodModel cashierPayMethodModel) {
                    Intrinsics.checkNotNullParameter(cashierPayMethodModel, "");
                    TopUpAndPaySourceFragment.MyBillsEntityDataFactory(TopUpAndPaySourceFragment.this).I = cashierPayMethodModel;
                    ArrayList arrayList = TopUpAndPaySourceFragment.KClassImpl$Data$declaredNonStaticMembers$2;
                    if (!(arrayList == null || arrayList.isEmpty())) {
                        TopUpAndPaySourceFragment.lookAheadTest(TopUpAndPaySourceFragment.this);
                    } else {
                        TopUpAndPaySourceFragment.PlaceComponentResult(TopUpAndPaySourceFragment.this, cashierPayMethodModel);
                    }
                }
            });
        }
        TopUpAndPayMethodView topUpAndPayMethodView3 = (TopUpAndPayMethodView) BuiltInFictitiousFunctionClassFactory(R.id.res_0x7f0a1373_flowkt__zipkt_combinetransform_7);
        if (topUpAndPayMethodView3 != null) {
            topUpAndPayMethodView3.setOnClickTopUpAndPayMethodListener(new Function1<CashierPayMethodModel, Unit>() { // from class: id.dana.cashier.topupandpay.fragment.TopUpAndPaySourceFragment$setClickTopUpAndPayVirtualAccountListener$1
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public final /* bridge */ /* synthetic */ Unit invoke(CashierPayMethodModel cashierPayMethodModel) {
                    invoke2(cashierPayMethodModel);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke  reason: avoid collision after fix types in other method */
                public final void invoke2(CashierPayMethodModel cashierPayMethodModel) {
                    Intrinsics.checkNotNullParameter(cashierPayMethodModel, "");
                    TopUpAndPaySourceFragment.MyBillsEntityDataFactory(TopUpAndPaySourceFragment.this).I = cashierPayMethodModel;
                    ArrayList arrayList = TopUpAndPaySourceFragment.KClassImpl$Data$declaredNonStaticMembers$2;
                    if (!(arrayList == null || arrayList.isEmpty())) {
                        TopUpAndPaySourceFragment.lookAheadTest(TopUpAndPaySourceFragment.this);
                    } else {
                        TopUpAndPaySourceFragment.BuiltInFictitiousFunctionClassFactory(TopUpAndPaySourceFragment.this, cashierPayMethodModel);
                    }
                }
            });
        }
    }

    @Override // id.dana.cashier.fragment.BaseCashierFragment, id.dana.base.BaseFragment, androidx.fragment.app.Fragment
    public final /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        this.PlaceComponentResult.clear();
    }
}
