package id.dana.cashier.topupandpay.fragment;

import android.os.Bundle;
import android.view.View;
import androidx.fragment.app.FragmentActivity;
import com.anggrayudi.storage.permission.FragmentPermissionRequest;
import dagger.internal.Preconditions;
import id.dana.R;
import id.dana.analytics.tracker.TrackerKey;
import id.dana.base.AbstractContract;
import id.dana.base.BaseActivity;
import id.dana.cashier.CashierViewListener;
import id.dana.cashier.RiskParamsFactory;
import id.dana.cashier.TopUpAndPayContract;
import id.dana.cashier.domain.model.CashierPayRequest;
import id.dana.cashier.fragment.BaseCashierFragment;
import id.dana.cashier.fragment.PaymentResultFragment;
import id.dana.cashier.helper.CashierErrorState;
import id.dana.cashier.helper.CashierVariables;
import id.dana.cashier.model.AddOnTrackingModel;
import id.dana.cashier.model.AssetCardModel;
import id.dana.cashier.model.AttributeCashierPayModel;
import id.dana.cashier.model.CashierPayChannelModel;
import id.dana.cashier.model.CashierPayMethodModel;
import id.dana.cashier.model.CashierPayMethodModelKt;
import id.dana.cashier.model.CashierPayModel;
import id.dana.cashier.model.FaceAuthModel;
import id.dana.cashier.model.OneKlikPhonesModel;
import id.dana.cashier.model.PayMethodViewDtoModel;
import id.dana.cashier.model.PayResultModel;
import id.dana.cashier.model.ProcessingMilestoneModel;
import id.dana.cashier.model.RiskVerificationMethodModel;
import id.dana.cashier.model.TopUpConsultModel;
import id.dana.cashier.model.TopUpPayModel;
import id.dana.cashier.model.TopUpSubmitRequestModel;
import id.dana.cashier.model.TopUpVerifyRequestModel;
import id.dana.cashier.model.tracker.PaymentExecutionTrackerParams;
import id.dana.cashier.tracker.CashierAnalyticTracker;
import id.dana.cashier.utils.CashierKeyParams;
import id.dana.cashier.view.CashierInputAmountView;
import id.dana.cashier.view.CashierPayWithCvvView;
import id.dana.component.buttoncomponent.DanaButtonPrimaryView;
import id.dana.core.ui.util.LocaleUtil;
import id.dana.data.config.DeviceInformationProvider;
import id.dana.di.component.ApplicationComponent;
import id.dana.di.component.DaggerTopUpAndPayComponent;
import id.dana.di.modules.CashierAnalyticModule;
import id.dana.di.modules.CashierModule;
import id.dana.di.modules.TopUpAndPayModule;
import id.dana.domain.nearbyme.model.MoneyView;
import id.dana.lib.gcontainer.util.UserAgentFactory;
import id.dana.nearbyme.merchantdetail.model.MoneyViewModel;
import id.dana.pay.PayActivity;
import id.dana.utils.LocationUtil;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import javax.inject.Inject;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(d1 = {"\u0000\u0090\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 H2\u00020\u0001:\u0001HB\u0007¢\u0006\u0004\bG\u0010\u0004J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J\u0019\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0002¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\u000b\u001a\u00020\nH\u0014¢\u0006\u0004\b\u000b\u0010\fJC\u0010\u0013\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00052\b\u0010\r\u001a\u0004\u0018\u00010\u00052\b\u0010\u000e\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u000f\u001a\u00020\u00052\u0006\u0010\u0010\u001a\u00020\u00052\u0006\u0010\u0012\u001a\u00020\u0011H\u0014¢\u0006\u0004\b\u0013\u0010\u0014J\u0019\u0010\u0016\u001a\u00020\u00022\b\u0010\u0006\u001a\u0004\u0018\u00010\u0015H\u0002¢\u0006\u0004\b\u0016\u0010\u0017J\u000f\u0010\u0013\u001a\u00020\u0002H\u0014¢\u0006\u0004\b\u0013\u0010\u0004J\u000f\u0010\b\u001a\u00020\u0002H\u0014¢\u0006\u0004\b\b\u0010\u0004J\u000f\u0010\u0018\u001a\u00020\u0002H\u0014¢\u0006\u0004\b\u0018\u0010\u0004J\u000f\u0010\u0019\u001a\u00020\u0002H\u0014¢\u0006\u0004\b\u0019\u0010\u0004J\u0017\u0010\u001b\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u001aH\u0016¢\u0006\u0004\b\u001b\u0010\u001cJ\u000f\u0010\u001d\u001a\u00020\u0002H\u0014¢\u0006\u0004\b\u001d\u0010\u0004J\u000f\u0010\u001e\u001a\u00020\u0002H\u0014¢\u0006\u0004\b\u001e\u0010\u0004J\u0017\u0010\u0016\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0011H\u0014¢\u0006\u0004\b\u0016\u0010\u001fR\u0018\u0010\u0013\u001a\u0004\u0018\u00010 8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001e\u0010!R\u0012\u0010#\u001a\u00020\"X\u0087\"¢\u0006\u0006\n\u0004\b#\u0010$R\u0016\u0010\b\u001a\u00020\u00058\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\b\u001d\u0010%R\u0012\u0010'\u001a\u00020&X\u0087\"¢\u0006\u0006\n\u0004\b'\u0010(R\u0016\u0010\u001b\u001a\u00020\u00118\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\b)\u0010*R\u0016\u0010\u0016\u001a\u00020\u00118\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\b+\u0010*R\u0016\u0010\u0003\u001a\u00020\u00118\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\b,\u0010*R$\u0010\u0019\u001a\u0010\u0012\u0004\u0012\u00020.\u0012\u0004\u0012\u00020\u0005\u0018\u00010-8\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\b/\u00100R\u0016\u0010\u001d\u001a\u00020.8\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\b1\u00102R\u0013\u0010\u0018\u001a\u000203X\u0083\u0080\u0002¢\u0006\u0006\n\u0004\b4\u00105R\u0018\u0010\u001e\u001a\u0004\u0018\u0001068\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\b7\u00108R\u0016\u0010<\u001a\u0004\u0018\u0001098\u0002X\u0083\u0006¢\u0006\u0006\n\u0004\b:\u0010;R\u0018\u0010)\u001a\u0004\u0018\u00010 8\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\b=\u0010!R\u0012\u0010?\u001a\u00020>X\u0087\"¢\u0006\u0006\n\u0004\b?\u0010@R\u0018\u0010,\u001a\u0004\u0018\u00010A8\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\bB\u0010CR\u0018\u0010+\u001a\u0004\u0018\u00010D8\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\bE\u0010F"}, d2 = {"Lid/dana/cashier/topupandpay/fragment/TopUpAndPayInputFragment;", "Lid/dana/cashier/fragment/BaseCashierFragment;", "", "getAuthRequestContext", "()V", "", "p0", "Lid/dana/cashier/model/TopUpVerifyRequestModel;", "PlaceComponentResult", "(Ljava/lang/String;)Lid/dana/cashier/model/TopUpVerifyRequestModel;", "", "getLayout", "()I", "p1", "p2", "p3", "p4", "", "p5", "BuiltInFictitiousFunctionClassFactory", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Z)V", "Lid/dana/cashier/model/AttributeCashierPayModel;", "MyBillsEntityDataFactory", "(Lid/dana/cashier/model/AttributeCashierPayModel;)V", "getErrorConfigVersion", "lookAheadTest", "Lid/dana/cashier/RiskParamsFactory;", "KClassImpl$Data$declaredNonStaticMembers$2", "(Lid/dana/cashier/RiskParamsFactory;)V", "NetworkUserEntityData$$ExternalSyntheticLambda0", "moveToNextValue", "(Z)V", "Lid/dana/nearbyme/merchantdetail/model/MoneyViewModel;", "Lid/dana/nearbyme/merchantdetail/model/MoneyViewModel;", "Lid/dana/cashier/tracker/CashierAnalyticTracker;", "cashierAnalyticTracker", "Lid/dana/cashier/tracker/CashierAnalyticTracker;", "Ljava/lang/String;", "Lid/dana/data/config/DeviceInformationProvider;", "deviceInformationProvider", "Lid/dana/data/config/DeviceInformationProvider;", "NetworkUserEntityData$$ExternalSyntheticLambda1", "Z", "NetworkUserEntityData$$ExternalSyntheticLambda2", "DatabaseTableConfigUtil", "Lkotlin/Pair;", "", "GetContactSyncConfig", "Lkotlin/Pair;", "initRecordTimeStamp", "J", "Lid/dana/cashier/model/PayResultModel;", "isLayoutRequested", "Lkotlin/Lazy;", "Lid/dana/cashier/model/CashierPayChannelModel;", "NetworkUserEntityData$$ExternalSyntheticLambda7", "Lid/dana/cashier/model/CashierPayChannelModel;", "Lid/dana/cashier/model/CashierPayMethodModel$CardPayMethod;", "NetworkUserEntityData$$ExternalSyntheticLambda8", "Lid/dana/cashier/model/CashierPayMethodModel$CardPayMethod;", "scheduleImpl", "newProxyInstance", "Lid/dana/cashier/TopUpAndPayContract$Presenter;", "topUpAndPayPresenter", "Lid/dana/cashier/TopUpAndPayContract$Presenter;", "Lid/dana/cashier/model/TopUpConsultModel;", "PrepareContext", "Lid/dana/cashier/model/TopUpConsultModel;", "Lid/dana/cashier/model/TopUpPayModel;", "NetworkUserEntityData$$ExternalSyntheticLambda4", "Lid/dana/cashier/model/TopUpPayModel;", "<init>", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class TopUpAndPayInputFragment extends BaseCashierFragment {

    /* renamed from: Companion  reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static ArrayList<String> PlaceComponentResult;

    /* renamed from: DatabaseTableConfigUtil  reason: from kotlin metadata */
    private boolean getAuthRequestContext;

    /* renamed from: GetContactSyncConfig  reason: from kotlin metadata */
    private Pair<Long, String> lookAheadTest;

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda1  reason: from kotlin metadata */
    private boolean KClassImpl$Data$declaredNonStaticMembers$2;

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda2  reason: from kotlin metadata */
    private boolean MyBillsEntityDataFactory;

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda4  reason: from kotlin metadata */
    private TopUpPayModel NetworkUserEntityData$$ExternalSyntheticLambda2;

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda7  reason: from kotlin metadata */
    private CashierPayChannelModel moveToNextValue;

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda8  reason: from kotlin metadata */
    private CashierPayMethodModel.CardPayMethod scheduleImpl;

    /* renamed from: PrepareContext  reason: from kotlin metadata */
    private TopUpConsultModel DatabaseTableConfigUtil;
    @Inject
    public CashierAnalyticTracker cashierAnalyticTracker;
    @Inject
    public DeviceInformationProvider deviceInformationProvider;

    /* renamed from: moveToNextValue  reason: from kotlin metadata */
    private MoneyViewModel BuiltInFictitiousFunctionClassFactory;

    /* renamed from: newProxyInstance  reason: from kotlin metadata */
    private MoneyViewModel NetworkUserEntityData$$ExternalSyntheticLambda1;
    @Inject
    public TopUpAndPayContract.Presenter topUpAndPayPresenter;
    public Map<Integer, View> KClassImpl$Data$declaredNonStaticMembers$2 = new LinkedHashMap();

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda0  reason: from kotlin metadata */
    private String PlaceComponentResult = "";

    /* renamed from: initRecordTimeStamp  reason: from kotlin metadata */
    private long NetworkUserEntityData$$ExternalSyntheticLambda0 = 10000;

    /* renamed from: isLayoutRequested  reason: from kotlin metadata */
    private final Lazy getErrorConfigVersion = LazyKt.lazy(new Function0<PayResultModel>() { // from class: id.dana.cashier.topupandpay.fragment.TopUpAndPayInputFragment$payResultModel$2
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final PayResultModel invoke() {
            return new PayResultModel(null, null, null, null, null, null, null, null, null, null, false, false, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, false, null, null, null, false, null, null, null, null, false, null, null, null, null, null, null, null, null, null, null, -1, 524287, null);
        }
    });

    @Override // id.dana.cashier.fragment.BaseCashierFragment
    public final View BuiltInFictitiousFunctionClassFactory(int i) {
        View findViewById;
        Map<Integer, View> map = this.KClassImpl$Data$declaredNonStaticMembers$2;
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
        this.KClassImpl$Data$declaredNonStaticMembers$2.clear();
    }

    @Override // id.dana.base.BaseFragment
    public final int getLayout() {
        return R.layout.fragment_topup_and_pay_input;
    }

    public static final /* synthetic */ void MyBillsEntityDataFactory(TopUpAndPayInputFragment topUpAndPayInputFragment, String str) {
        Intrinsics.checkNotNullParameter(str, "");
        topUpAndPayInputFragment.scheduleImpl = str;
    }

    @Override // id.dana.cashier.fragment.BaseCashierFragment
    public final void PlaceComponentResult() {
        DaggerTopUpAndPayComponent.Builder MyBillsEntityDataFactory = DaggerTopUpAndPayComponent.MyBillsEntityDataFactory();
        MyBillsEntityDataFactory.getAuthRequestContext = (ApplicationComponent) Preconditions.getAuthRequestContext(getApplicationComponent());
        MyBillsEntityDataFactory.PlaceComponentResult = (TopUpAndPayModule) Preconditions.getAuthRequestContext(new TopUpAndPayModule(new CashierViewListener() { // from class: id.dana.cashier.topupandpay.fragment.TopUpAndPayInputFragment$topUpAndPayModule$1
            @Override // id.dana.cashier.CashierViewListener, id.dana.cashier.TopUpAndPayContract.View
            public final void BuiltInFictitiousFunctionClassFactory(CashierPayModel cashierPayModel) {
                Intrinsics.checkNotNullParameter(cashierPayModel, "");
                TopUpAndPayInputFragment topUpAndPayInputFragment = TopUpAndPayInputFragment.this;
                AttributeCashierPayModel attributeCashierPayModel = cashierPayModel.KClassImpl$Data$declaredNonStaticMembers$2;
                String str = attributeCashierPayModel != null ? attributeCashierPayModel.KClassImpl$Data$declaredNonStaticMembers$2 : null;
                TopUpAndPayInputFragment.MyBillsEntityDataFactory(topUpAndPayInputFragment, str != null ? str : "");
                TopUpAndPayInputFragment.MyBillsEntityDataFactory(TopUpAndPayInputFragment.this);
            }

            @Override // id.dana.cashier.CashierViewListener, id.dana.cashier.TopUpAndPayContract.View
            public final void getAuthRequestContext(TopUpPayModel p0) {
                Intrinsics.checkNotNullParameter(p0, "");
                TopUpAndPayInputFragment.this.NetworkUserEntityData$$ExternalSyntheticLambda2 = p0;
                TopUpAndPayInputFragment.PlaceComponentResult(TopUpAndPayInputFragment.this, p0);
            }

            @Override // id.dana.cashier.CashierViewListener, id.dana.cashier.TopUpAndPayContract.View
            public final void MyBillsEntityDataFactory(TopUpPayModel p0) {
                Intrinsics.checkNotNullParameter(p0, "");
                TopUpAndPayInputFragment.PlaceComponentResult(TopUpAndPayInputFragment.this, p0);
            }

            @Override // id.dana.cashier.CashierViewListener, id.dana.base.AbstractContractKt.AbstractView, id.dana.base.AbstractContract.AbstractView
            public final void showProgress() {
                TopUpAndPayInputFragment.this.readMicros();
            }

            @Override // id.dana.cashier.CashierViewListener, id.dana.base.AbstractContractKt.AbstractView, id.dana.base.AbstractContract.AbstractView
            public final void dismissProgress() {
                TopUpAndPayInputFragment.this.scheduleImpl();
            }

            @Override // id.dana.cashier.CashierViewListener, id.dana.cashier.TopUpAndPayContract.View
            public final void lookAheadTest(CashierErrorState p0) {
                Intrinsics.checkNotNullParameter(p0, "");
                TopUpAndPayInputFragment.this.KClassImpl$Data$declaredNonStaticMembers$2(p0);
            }

            @Override // id.dana.cashier.CashierViewListener, id.dana.cashier.CashierContract.View, id.dana.cashier.TopUpAndPayContract.View
            public final void BuiltInFictitiousFunctionClassFactory(CashierErrorState p0) {
                Intrinsics.checkNotNullParameter(p0, "");
                TopUpAndPayInputFragment.this.KClassImpl$Data$declaredNonStaticMembers$2(p0);
            }

            @Override // id.dana.cashier.CashierViewListener, id.dana.cashier.TopUpAndPayContract.View
            public final void lookAheadTest(String str) {
                BaseCashierFragment.KClassImpl$Data$declaredNonStaticMembers$2(TopUpAndPayInputFragment.this, str);
            }

            @Override // id.dana.cashier.CashierViewListener, id.dana.cashier.CashierContract.View, id.dana.cashier.TopUpAndPayContract.View
            public final void getErrorConfigVersion() {
                TopUpAndPayInputFragment.this.MyBillsEntityDataFactory(true);
            }

            @Override // id.dana.cashier.CashierViewListener, id.dana.cashier.CashierContract.View, id.dana.cashier.TopUpAndPayContract.View
            public final void scheduleImpl() {
                TopUpAndPayInputFragment.this.getErrorConfigVersion = true;
                TopUpAndPayInputFragment.this.MyBillsEntityDataFactory(false);
            }

            @Override // id.dana.cashier.CashierViewListener, id.dana.cashier.CashierContract.View, id.dana.cashier.TopUpAndPayContract.View
            public final void getAuthRequestContext() {
                TopUpAndPayInputFragment.this.MyBillsEntityDataFactory(false);
            }

            @Override // id.dana.cashier.CashierViewListener, id.dana.base.AbstractContractKt.AbstractView, id.dana.base.AbstractContract.AbstractView
            public final void onError(String p0) {
                BaseCashierFragment.KClassImpl$Data$declaredNonStaticMembers$2(TopUpAndPayInputFragment.this, p0);
            }

            @Override // id.dana.cashier.CashierViewListener, id.dana.cashier.CashierContract.View, id.dana.cashier.TopUpAndPayContract.View
            public final boolean KClassImpl$Data$declaredNonStaticMembers$2() {
                return LocationUtil.getAuthRequestContext(TopUpAndPayInputFragment.this.getContext());
            }

            @Override // id.dana.cashier.CashierViewListener, id.dana.cashier.CashierContract.View, id.dana.cashier.TopUpAndPayContract.View
            public final void MyBillsEntityDataFactory(CashierPayModel p0) {
                Intrinsics.checkNotNullParameter(p0, "");
                AttributeCashierPayModel attributeCashierPayModel = p0.KClassImpl$Data$declaredNonStaticMembers$2;
                if (attributeCashierPayModel != null) {
                    TopUpAndPayInputFragment topUpAndPayInputFragment = TopUpAndPayInputFragment.this;
                    if (attributeCashierPayModel.KClassImpl$Data$declaredNonStaticMembers$2()) {
                        topUpAndPayInputFragment.MyBillsEntityDataFactory(attributeCashierPayModel);
                    } else {
                        TopUpAndPayInputFragment.getAuthRequestContext(topUpAndPayInputFragment, p0);
                    }
                }
            }
        }));
        MyBillsEntityDataFactory.KClassImpl$Data$declaredNonStaticMembers$2 = (CashierModule) Preconditions.getAuthRequestContext(new CashierModule(new CashierViewListener() { // from class: id.dana.cashier.topupandpay.fragment.TopUpAndPayInputFragment$cashierModule$1
        }));
        MyBillsEntityDataFactory.BuiltInFictitiousFunctionClassFactory = (CashierAnalyticModule) Preconditions.getAuthRequestContext(new CashierAnalyticModule());
        MyBillsEntityDataFactory.MyBillsEntityDataFactory().getAuthRequestContext(this);
        AbstractContract.AbstractPresenter[] abstractPresenterArr = new AbstractContract.AbstractPresenter[1];
        TopUpAndPayContract.Presenter presenter = this.topUpAndPayPresenter;
        if (presenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            presenter = null;
        }
        abstractPresenterArr[0] = presenter;
        registerPresenter(abstractPresenterArr);
    }

    @Override // id.dana.cashier.fragment.BaseCashierFragment
    public final void getAuthRequestContext() {
        String string = getString(R.string.topup_and_pay_input_title);
        Intrinsics.checkNotNullExpressionValue(string, "");
        getAuthRequestContext(string);
    }

    /* JADX WARN: Removed duplicated region for block: B:113:0x0207  */
    /* JADX WARN: Removed duplicated region for block: B:116:0x0215  */
    /* JADX WARN: Removed duplicated region for block: B:199:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0078  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x008f  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0091  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0094  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x00d3  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x00dc  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x00f2  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x0106  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x0115  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x0117  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x0155  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x0170  */
    /* JADX WARN: Removed duplicated region for block: B:83:0x0176  */
    /* JADX WARN: Removed duplicated region for block: B:86:0x018b  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x0199  */
    /* JADX WARN: Removed duplicated region for block: B:96:0x01ae  */
    @Override // id.dana.cashier.fragment.BaseCashierFragment
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void getErrorConfigVersion() {
        /*
            Method dump skipped, instructions count: 891
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.cashier.topupandpay.fragment.TopUpAndPayInputFragment.getErrorConfigVersion():void");
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // id.dana.cashier.fragment.BaseCashierFragment
    public final void moveToNextValue() {
        List<PayMethodViewDtoModel> list;
        Object obj;
        List<CashierPayChannelModel> list2;
        AssetCardModel assetCardModel;
        AssetCardModel assetCardModel2;
        AssetCardModel assetCardModel3;
        List<String> list3;
        Bundle arguments = getArguments();
        if (arguments != null) {
            String string = arguments.getString(CashierKeyParams.CASHIER_ORDER_ID, "");
            Intrinsics.checkNotNullExpressionValue(string, "");
            this.PlaceComponentResult = string;
            CashierPayMethodModel.CardPayMethod cardPayMethod = (CashierPayMethodModel.CardPayMethod) arguments.getParcelable("SELECTED_CASHIER_PAY_METHOD_MODEL");
            this.scheduleImpl = cardPayMethod;
            this.getAuthRequestContext = (cardPayMethod == null || (assetCardModel3 = cardPayMethod.KClassImpl$Data$declaredNonStaticMembers$2) == null || (list3 = assetCardModel3.readMicros) == null || !list3.contains("cvv2")) ? false : true;
            ((PayResultModel) this.getErrorConfigVersion.getValue()).I = cardPayMethod;
            this.DatabaseTableConfigUtil = (TopUpConsultModel) arguments.getParcelable("TOP_UP_CONSULT_MODEL");
            this.NetworkUserEntityData$$ExternalSyntheticLambda1 = (MoneyViewModel) arguments.getParcelable("TOP_UP_VALUE");
            CashierVariables cashierVariables = CashierVariables.INSTANCE;
            String string2 = arguments.getString("MERCHANT_NAME", "");
            Intrinsics.checkNotNullExpressionValue(string2, "");
            CashierVariables.PlaceComponentResult(string2);
            this.BuiltInFictitiousFunctionClassFactory = (MoneyViewModel) arguments.getParcelable("balance");
        }
        TopUpConsultModel topUpConsultModel = this.DatabaseTableConfigUtil;
        CashierPayChannelModel cashierPayChannelModel = null;
        if (topUpConsultModel != null && (list = topUpConsultModel.NetworkUserEntityData$$ExternalSyntheticLambda2) != null) {
            Iterator<T> it = list.iterator();
            while (true) {
                if (!it.hasNext()) {
                    obj = null;
                    break;
                }
                obj = it.next();
                String str = ((PayMethodViewDtoModel) obj).BuiltInFictitiousFunctionClassFactory;
                CashierPayMethodModel.CardPayMethod cardPayMethod2 = this.scheduleImpl;
                if (StringsKt.equals$default(str, (cardPayMethod2 == null || (assetCardModel2 = cardPayMethod2.KClassImpl$Data$declaredNonStaticMembers$2) == null) ? null : assetCardModel2.getSupportButtonTintMode, false, 2, null)) {
                    break;
                }
            }
            PayMethodViewDtoModel payMethodViewDtoModel = (PayMethodViewDtoModel) obj;
            if (payMethodViewDtoModel != null && (list2 = payMethodViewDtoModel.MyBillsEntityDataFactory) != null) {
                Iterator<T> it2 = list2.iterator();
                while (true) {
                    if (!it2.hasNext()) {
                        break;
                    }
                    Object next = it2.next();
                    String str2 = ((CashierPayChannelModel) next).PrepareContext;
                    CashierPayMethodModel.CardPayMethod cardPayMethod3 = this.scheduleImpl;
                    if (StringsKt.equals$default(str2, (cardPayMethod3 == null || (assetCardModel = cardPayMethod3.KClassImpl$Data$declaredNonStaticMembers$2) == null) ? null : assetCardModel.NetworkUserEntityData$$ExternalSyntheticLambda7, false, 2, null)) {
                        cashierPayChannelModel = next;
                        break;
                    }
                }
                cashierPayChannelModel = cashierPayChannelModel;
            }
        }
        this.moveToNextValue = cashierPayChannelModel;
    }

    @Override // id.dana.cashier.fragment.BaseCashierFragment
    public final void BuiltInFictitiousFunctionClassFactory() {
        BaseActivity baseActivity = getBaseActivity();
        PayActivity payActivity = baseActivity instanceof PayActivity ? (PayActivity) baseActivity : null;
        if (payActivity != null) {
            payActivity.setCashierRiskListener(new PayActivity.CashierRiskListener() { // from class: id.dana.cashier.topupandpay.fragment.TopUpAndPayInputFragment$initCashierListener$1
                @Override // id.dana.pay.PayActivity.CashierRiskListener
                public final void MyBillsEntityDataFactory(String p0) {
                    String str;
                    TopUpPayModel topUpPayModel;
                    String str2;
                    TopUpPayModel topUpPayModel2;
                    str = TopUpAndPayInputFragment.this.PlaceComponentResult;
                    if (StringsKt.equals$default(p0, "redirectCallback", false, 2, null)) {
                        topUpPayModel2 = TopUpAndPayInputFragment.this.NetworkUserEntityData$$ExternalSyntheticLambda2;
                        str = topUpPayModel2 != null ? topUpPayModel2.getAuthRequestContext : null;
                        if (str == null) {
                            str = "";
                        }
                    }
                    TopUpAndPayContract.Presenter presenter = TopUpAndPayInputFragment.this.topUpAndPayPresenter;
                    if (presenter == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("");
                        presenter = null;
                    }
                    topUpPayModel = TopUpAndPayInputFragment.this.NetworkUserEntityData$$ExternalSyntheticLambda2;
                    String str3 = topUpPayModel != null ? topUpPayModel.getAuthRequestContext : null;
                    String str4 = str3 != null ? str3 : "";
                    str2 = TopUpAndPayInputFragment.this.scheduleImpl;
                    presenter.PlaceComponentResult(str, str4, p0, str2);
                }
            });
        }
    }

    @Override // id.dana.cashier.fragment.BaseCashierFragment
    public final void KClassImpl$Data$declaredNonStaticMembers$2(RiskParamsFactory p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        BuiltInFictitiousFunctionClassFactory(p0);
        FragmentPermissionRequest NetworkUserEntityData$$ExternalSyntheticLambda2 = getPlaceComponentResult();
        if (NetworkUserEntityData$$ExternalSyntheticLambda2 != null) {
            NetworkUserEntityData$$ExternalSyntheticLambda2.check();
        }
    }

    @Override // id.dana.cashier.fragment.BaseCashierFragment
    public final void lookAheadTest() {
        AttributeCashierPayModel attributeCashierPayModel;
        CashierPayMethodModel.CardPayMethod cardPayMethod = this.scheduleImpl;
        if (cardPayMethod != null) {
            TopUpPayModel topUpPayModel = this.NetworkUserEntityData$$ExternalSyntheticLambda2;
            TopUpAndPayContract.Presenter presenter = null;
            String str = topUpPayModel != null ? topUpPayModel.getAuthRequestContext : null;
            String str2 = str == null ? "" : str;
            String NetworkUserEntityData$$ExternalSyntheticLambda1 = getInitRecordTimeStamp();
            DeviceInformationProvider deviceInformationProvider = this.deviceInformationProvider;
            if (deviceInformationProvider == null) {
                Intrinsics.throwUninitializedPropertyAccessException("");
                deviceInformationProvider = null;
            }
            String deviceUUID = deviceInformationProvider.getDeviceUUID();
            TopUpPayModel topUpPayModel2 = this.NetworkUserEntityData$$ExternalSyntheticLambda2;
            String str3 = (topUpPayModel2 == null || (attributeCashierPayModel = topUpPayModel2.BuiltInFictitiousFunctionClassFactory) == null) ? null : attributeCashierPayModel.getErrorConfigVersion;
            String str4 = cardPayMethod.KClassImpl$Data$declaredNonStaticMembers$2.getSupportButtonTintMode;
            String str5 = str4 == null ? "" : str4;
            String str6 = cardPayMethod.KClassImpl$Data$declaredNonStaticMembers$2.whenAvailable;
            BaseActivity baseActivity = getBaseActivity();
            Intrinsics.checkNotNullExpressionValue(baseActivity, "");
            FaceAuthModel faceAuthModel = new FaceAuthModel(str2, NetworkUserEntityData$$ExternalSyntheticLambda1, "MIC_FACE", deviceUUID, str3, str5, str6, baseActivity);
            TopUpAndPayContract.Presenter presenter2 = this.topUpAndPayPresenter;
            if (presenter2 != null) {
                presenter = presenter2;
            } else {
                Intrinsics.throwUninitializedPropertyAccessException("");
            }
            presenter.getAuthRequestContext(faceAuthModel);
        }
    }

    @Override // id.dana.cashier.fragment.BaseCashierFragment
    public final void NetworkUserEntityData$$ExternalSyntheticLambda0() {
        RiskParamsFactory GetContactSyncConfig = getNetworkUserEntityData$$ExternalSyntheticLambda2();
        if (GetContactSyncConfig != null) {
            String PlaceComponentResult2 = GetContactSyncConfig.PlaceComponentResult();
            BaseActivity baseActivity = getBaseActivity();
            PayActivity payActivity = baseActivity instanceof PayActivity ? (PayActivity) baseActivity : null;
            if (payActivity != null) {
                if (PlaceComponentResult2 == null) {
                    PlaceComponentResult2 = "";
                }
                PayActivity.handleCashierRiskPhase$default(payActivity, PlaceComponentResult2, GetContactSyncConfig, null, null, 12, null);
            }
            BuiltInFictitiousFunctionClassFactory((RiskParamsFactory) null);
        }
    }

    private final TopUpVerifyRequestModel PlaceComponentResult(String p0) {
        String str;
        AttributeCashierPayModel attributeCashierPayModel;
        AssetCardModel assetCardModel;
        CashierPayMethodModel.CardPayMethod cardPayMethod = this.scheduleImpl;
        if (cardPayMethod != null) {
            String str2 = cardPayMethod.KClassImpl$Data$declaredNonStaticMembers$2.getSupportButtonTintMode;
            if (str2 == null) {
                str2 = "";
            }
            str = str2;
        } else {
            str = null;
        }
        CashierPayMethodModel.CardPayMethod cardPayMethod2 = this.scheduleImpl;
        String str3 = (cardPayMethod2 == null || (assetCardModel = cardPayMethod2.KClassImpl$Data$declaredNonStaticMembers$2) == null) ? null : assetCardModel.whenAvailable;
        TopUpPayModel topUpPayModel = this.NetworkUserEntityData$$ExternalSyntheticLambda2;
        String str4 = (topUpPayModel == null || (attributeCashierPayModel = topUpPayModel.BuiltInFictitiousFunctionClassFactory) == null) ? null : attributeCashierPayModel.getErrorConfigVersion;
        DeviceInformationProvider deviceInformationProvider = this.deviceInformationProvider;
        if (deviceInformationProvider == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            deviceInformationProvider = null;
        }
        String deviceUUID = deviceInformationProvider.getDeviceUUID();
        TopUpPayModel topUpPayModel2 = this.NetworkUserEntityData$$ExternalSyntheticLambda2;
        String str5 = topUpPayModel2 != null ? topUpPayModel2.getAuthRequestContext : null;
        String str6 = str5 == null ? "" : str5;
        TopUpPayModel topUpPayModel3 = this.NetworkUserEntityData$$ExternalSyntheticLambda2;
        String str7 = topUpPayModel3 != null ? topUpPayModel3.moveToNextValue : null;
        TopUpPayModel topUpPayModel4 = this.NetworkUserEntityData$$ExternalSyntheticLambda2;
        String str8 = topUpPayModel4 != null ? topUpPayModel4.NetworkUserEntityData$$ExternalSyntheticLambda0 : null;
        TopUpPayModel topUpPayModel5 = this.NetworkUserEntityData$$ExternalSyntheticLambda2;
        return new TopUpVerifyRequestModel(str, str3, str4, p0, "", deviceUUID, str6, str7, str8, topUpPayModel5 != null ? topUpPayModel5.getErrorConfigVersion : null);
    }

    @Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0015\u0010\u0016JK\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\t\u001a\u00020\b2\b\u0010\n\u001a\u0004\u0018\u00010\u00062\u000e\u0010\f\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u000bH\u0007¢\u0006\u0004\b\u000e\u0010\u000fR*\u0010\u0014\u001a\u0016\u0012\u0004\u0012\u00020\b\u0018\u00010\u0010j\n\u0012\u0004\u0012\u00020\b\u0018\u0001`\u00118\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013"}, d2 = {"Lid/dana/cashier/topupandpay/fragment/TopUpAndPayInputFragment$Companion;", "", "Lid/dana/cashier/model/TopUpConsultModel;", "p0", "Lid/dana/cashier/model/CashierPayMethodModel$CardPayMethod;", "p1", "Lid/dana/nearbyme/merchantdetail/model/MoneyViewModel;", "p2", "", "p3", "p4", "", "p5", "Lid/dana/cashier/topupandpay/fragment/TopUpAndPayInputFragment;", "getAuthRequestContext", "(Lid/dana/cashier/model/TopUpConsultModel;Lid/dana/cashier/model/CashierPayMethodModel$CardPayMethod;Lid/dana/nearbyme/merchantdetail/model/MoneyViewModel;Ljava/lang/String;Lid/dana/nearbyme/merchantdetail/model/MoneyViewModel;Ljava/util/List;)Lid/dana/cashier/topupandpay/fragment/TopUpAndPayInputFragment;", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "PlaceComponentResult", "Ljava/util/ArrayList;", "MyBillsEntityDataFactory", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes4.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public static TopUpAndPayInputFragment getAuthRequestContext(TopUpConsultModel p0, CashierPayMethodModel.CardPayMethod p1, MoneyViewModel p2, String p3, MoneyViewModel p4, List<String> p5) {
            Intrinsics.checkNotNullParameter(p0, "");
            Intrinsics.checkNotNullParameter(p1, "");
            Intrinsics.checkNotNullParameter(p3, "");
            if (p5 != null) {
                TopUpAndPayInputFragment.PlaceComponentResult = new ArrayList();
                ArrayList arrayList = TopUpAndPayInputFragment.PlaceComponentResult;
                if (arrayList != null) {
                    arrayList.addAll(p5);
                }
            }
            TopUpAndPayInputFragment topUpAndPayInputFragment = new TopUpAndPayInputFragment();
            Bundle bundle = new Bundle();
            bundle.putParcelable("TOP_UP_CONSULT_MODEL", p0);
            bundle.putParcelable("SELECTED_CASHIER_PAY_METHOD_MODEL", p1);
            bundle.putParcelable("TOP_UP_VALUE", p2);
            bundle.putString(CashierKeyParams.CASHIER_ORDER_ID, p3);
            bundle.putParcelable("balance", p4);
            topUpAndPayInputFragment.setArguments(bundle);
            return topUpAndPayInputFragment;
        }
    }

    public static /* synthetic */ void PlaceComponentResult(TopUpAndPayInputFragment topUpAndPayInputFragment) {
        AssetCardModel assetCardModel;
        AssetCardModel assetCardModel2;
        AssetCardModel assetCardModel3;
        AssetCardModel assetCardModel4;
        AssetCardModel assetCardModel5;
        Intrinsics.checkNotNullParameter(topUpAndPayInputFragment, "");
        CashierPayMethodModel.CardPayMethod cardPayMethod = topUpAndPayInputFragment.scheduleImpl;
        if (cardPayMethod != null) {
            TopUpAndPayContract.Presenter presenter = topUpAndPayInputFragment.topUpAndPayPresenter;
            String str = null;
            if (presenter == null) {
                Intrinsics.throwUninitializedPropertyAccessException("");
                presenter = null;
            }
            CashierPayMethodModel.CardPayMethod cardPayMethod2 = cardPayMethod;
            String str2 = topUpAndPayInputFragment.PlaceComponentResult;
            CashierPayMethodModel.CardPayMethod MyBillsEntityDataFactory = CashierPayMethodModelKt.MyBillsEntityDataFactory(cardPayMethod2);
            String str3 = (MyBillsEntityDataFactory == null || (assetCardModel5 = MyBillsEntityDataFactory.KClassImpl$Data$declaredNonStaticMembers$2) == null) ? null : assetCardModel5.whenAvailable;
            String initRecordTimeStamp = cardPayMethod2.initRecordTimeStamp();
            CashierPayMethodModel.CardPayMethod MyBillsEntityDataFactory2 = CashierPayMethodModelKt.MyBillsEntityDataFactory(cardPayMethod2);
            String str4 = (MyBillsEntityDataFactory2 == null || (assetCardModel4 = MyBillsEntityDataFactory2.KClassImpl$Data$declaredNonStaticMembers$2) == null) ? null : assetCardModel4.scheduleImpl;
            CashierPayMethodModel.CardPayMethod MyBillsEntityDataFactory3 = CashierPayMethodModelKt.MyBillsEntityDataFactory(cardPayMethod2);
            String str5 = (MyBillsEntityDataFactory3 == null || (assetCardModel3 = MyBillsEntityDataFactory3.KClassImpl$Data$declaredNonStaticMembers$2) == null) ? null : assetCardModel3.KClassImpl$Data$declaredNonStaticMembers$2;
            CashierPayMethodModel.CardPayMethod MyBillsEntityDataFactory4 = CashierPayMethodModelKt.MyBillsEntityDataFactory(cardPayMethod2);
            String str6 = (MyBillsEntityDataFactory4 == null || (assetCardModel2 = MyBillsEntityDataFactory4.KClassImpl$Data$declaredNonStaticMembers$2) == null) ? null : assetCardModel2.NetworkUserEntityData$$ExternalSyntheticLambda8;
            CashierPayMethodModel.CardPayMethod MyBillsEntityDataFactory5 = CashierPayMethodModelKt.MyBillsEntityDataFactory(cardPayMethod2);
            if (MyBillsEntityDataFactory5 != null && (assetCardModel = MyBillsEntityDataFactory5.KClassImpl$Data$declaredNonStaticMembers$2) != null) {
                str = assetCardModel.isLayoutRequested;
            }
            presenter.BuiltInFictitiousFunctionClassFactory(new CashierPayRequest("topupPay", initRecordTimeStamp, str2, null, str3, str, str6, null, null, str4, str5, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, PlaceComponentResult, null, null, null, null, null, null, null, null, null, -1656, 1022, null), cardPayMethod.BuiltInFictitiousFunctionClassFactory, true);
        }
    }

    public static final /* synthetic */ void KClassImpl$Data$declaredNonStaticMembers$2(TopUpAndPayInputFragment topUpAndPayInputFragment) {
        DanaButtonPrimaryView danaButtonPrimaryView = (DanaButtonPrimaryView) topUpAndPayInputFragment.BuiltInFictitiousFunctionClassFactory(R.id.R);
        if (danaButtonPrimaryView != null) {
            int i = 0;
            danaButtonPrimaryView.setEnabled(topUpAndPayInputFragment.MyBillsEntityDataFactory && topUpAndPayInputFragment.KClassImpl$Data$declaredNonStaticMembers$2);
            if (topUpAndPayInputFragment.MyBillsEntityDataFactory && topUpAndPayInputFragment.KClassImpl$Data$declaredNonStaticMembers$2) {
                i = 1;
            }
            danaButtonPrimaryView.setDanaButtonView(i, topUpAndPayInputFragment.getString(R.string.pay), null, null);
        }
    }

    public static final /* synthetic */ void PlaceComponentResult(TopUpAndPayInputFragment topUpAndPayInputFragment, TopUpPayModel topUpPayModel) {
        CashierAnalyticTracker cashierAnalyticTracker;
        AttributeCashierPayModel attributeCashierPayModel = topUpPayModel.BuiltInFictitiousFunctionClassFactory;
        if (attributeCashierPayModel != null) {
            if (attributeCashierPayModel.KClassImpl$Data$declaredNonStaticMembers$2()) {
                topUpAndPayInputFragment.MyBillsEntityDataFactory(attributeCashierPayModel);
                return;
            }
            CashierPayMethodModel.CardPayMethod cardPayMethod = topUpAndPayInputFragment.scheduleImpl;
            if (cardPayMethod != null) {
                CashierPayMethodModel.CardPayMethod cardPayMethod2 = cardPayMethod;
                ArrayList<String> arrayList = PlaceComponentResult;
                String initRecordTimeStamp = cardPayMethod2.initRecordTimeStamp();
                CashierAnalyticTracker cashierAnalyticTracker2 = topUpAndPayInputFragment.cashierAnalyticTracker;
                if (cashierAnalyticTracker2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("");
                    cashierAnalyticTracker2 = null;
                }
                cashierAnalyticTracker2.getAuthRequestContext(CollectionsKt.listOf(initRecordTimeStamp).toString());
                CashierAnalyticTracker cashierAnalyticTracker3 = topUpAndPayInputFragment.cashierAnalyticTracker;
                if (cashierAnalyticTracker3 != null) {
                    cashierAnalyticTracker = cashierAnalyticTracker3;
                } else {
                    Intrinsics.throwUninitializedPropertyAccessException("");
                    cashierAnalyticTracker = null;
                }
                String str = topUpAndPayInputFragment.PlaceComponentResult;
                cardPayMethod2.lookAheadTest = true;
                Unit unit = Unit.INSTANCE;
                if (arrayList == null) {
                    arrayList = CollectionsKt.emptyList();
                }
                List list = arrayList;
                FragmentActivity activity = topUpAndPayInputFragment.getActivity();
                PayActivity payActivity = activity instanceof PayActivity ? (PayActivity) activity : null;
                AddOnTrackingModel addOnTrackingModel = payActivity != null ? payActivity.getAddOnTrackingModel() : null;
                String str2 = ((PayResultModel) topUpAndPayInputFragment.getErrorConfigVersion.getValue()).VerifyPinStateManager$executeRiskChallenge$2$2;
                String source = topUpAndPayInputFragment.getBaseActivity().getSource();
                Intrinsics.checkNotNullExpressionValue(source, "");
                BaseActivity baseActivity = topUpAndPayInputFragment.getBaseActivity();
                PayActivity payActivity2 = baseActivity instanceof PayActivity ? (PayActivity) baseActivity : null;
                cashierAnalyticTracker.MyBillsEntityDataFactory(new PaymentExecutionTrackerParams(str, cardPayMethod2, list, addOnTrackingModel, str2, source, null, payActivity2 != null ? payActivity2.getFeatureTimeModel() : null, 64, null));
            }
            TopUpAndPayContract.Presenter presenter = topUpAndPayInputFragment.topUpAndPayPresenter;
            if (presenter == null) {
                Intrinsics.throwUninitializedPropertyAccessException("");
                presenter = null;
            }
            String str3 = topUpAndPayInputFragment.PlaceComponentResult;
            String str4 = topUpPayModel.getAuthRequestContext;
            presenter.PlaceComponentResult(str3, str4 != null ? str4 : "", null, topUpAndPayInputFragment.scheduleImpl);
        }
    }

    public static final /* synthetic */ void MyBillsEntityDataFactory(TopUpAndPayInputFragment topUpAndPayInputFragment) {
        TopUpAndPayContract.Presenter presenter;
        String str;
        AssetCardModel assetCardModel;
        HashMap hashMap = new HashMap();
        hashMap.put("bizOrderId", topUpAndPayInputFragment.scheduleImpl);
        hashMap.put(CashierKeyParams.CASHIER_ORDER_ID, topUpAndPayInputFragment.PlaceComponentResult);
        CashierPayMethodModel.CardPayMethod cardPayMethod = topUpAndPayInputFragment.scheduleImpl;
        if (cardPayMethod != null) {
            CashierPayMethodModel.CardPayMethod cardPayMethod2 = cardPayMethod;
            if (CashierPayMethodModelKt.readMicros(cardPayMethod2)) {
                BaseActivity baseActivity = topUpAndPayInputFragment.getBaseActivity();
                PayActivity payActivity = baseActivity instanceof PayActivity ? (PayActivity) baseActivity : null;
                if (payActivity != null) {
                    CashierPayMethodModel.CardPayMethod MyBillsEntityDataFactory = CashierPayMethodModelKt.MyBillsEntityDataFactory(cardPayMethod2);
                    String str2 = (MyBillsEntityDataFactory == null || (assetCardModel = MyBillsEntityDataFactory.KClassImpl$Data$declaredNonStaticMembers$2) == null) ? null : assetCardModel.getAuthRequestContext;
                    if (str2 == null) {
                        str2 = "";
                    }
                    payActivity.setOneKlikPhoneNumer(str2);
                }
            }
            AssetCardModel assetCardModel2 = cardPayMethod.KClassImpl$Data$declaredNonStaticMembers$2;
            TopUpAndPayContract.Presenter presenter2 = topUpAndPayInputFragment.topUpAndPayPresenter;
            if (presenter2 != null) {
                presenter = presenter2;
            } else {
                Intrinsics.throwUninitializedPropertyAccessException("");
                presenter = null;
            }
            String str3 = assetCardModel2.getSupportButtonTintMode;
            if (assetCardModel2.getAuthRequestContext()) {
                DeviceInformationProvider deviceInformationProvider = topUpAndPayInputFragment.deviceInformationProvider;
                if (deviceInformationProvider == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("");
                    deviceInformationProvider = null;
                }
                String androidId = deviceInformationProvider.getAndroidId(topUpAndPayInputFragment.requireContext());
                if (androidId == null) {
                    androidId = "";
                }
                StringBuilder sb = new StringBuilder();
                sb.append(androidId);
                sb.append("||");
                sb.append(UserAgentFactory.getUserAgent());
                sb.append("||127.0.0.1");
                str = sb.toString();
            } else {
                str = assetCardModel2.GetContactSyncConfig;
            }
            String str4 = str;
            String str5 = assetCardModel2.getAuthRequestContext() ? assetCardModel2.VerifyPinStateManager$executeRiskChallenge$2$2 : null;
            String str6 = assetCardModel2.whenAvailable;
            MoneyView moneyView = new MoneyView(((CashierInputAmountView) topUpAndPayInputFragment.BuiltInFictitiousFunctionClassFactory(R.id.topupInputField)).getAmount(), "Rp", null, 4, null);
            DeviceInformationProvider deviceInformationProvider2 = topUpAndPayInputFragment.deviceInformationProvider;
            if (deviceInformationProvider2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("");
                deviceInformationProvider2 = null;
            }
            String deviceUUID = deviceInformationProvider2.getDeviceUUID();
            TopUpConsultModel topUpConsultModel = topUpAndPayInputFragment.DatabaseTableConfigUtil;
            presenter.PlaceComponentResult(new TopUpSubmitRequestModel(str3, Boolean.FALSE, str6, moneyView, deviceUUID, topUpConsultModel != null ? topUpConsultModel.getErrorConfigVersion : null, assetCardModel2.scheduleImpl, assetCardModel2.KClassImpl$Data$declaredNonStaticMembers$2, assetCardModel2.NetworkUserEntityData$$ExternalSyntheticLambda8, assetCardModel2.isLayoutRequested, assetCardModel2.getCallingPid, topUpAndPayInputFragment.getAuthRequestContext ? ((CashierPayWithCvvView) topUpAndPayInputFragment.BuiltInFictitiousFunctionClassFactory(R.id.isAdvancedMarkersAvailable)).getText() : null, assetCardModel2.getAuthRequestContext() ? assetCardModel2.getAuthRequestContext : null, str4, str5, hashMap));
        }
    }

    public static final /* synthetic */ void getAuthRequestContext(TopUpAndPayInputFragment topUpAndPayInputFragment, CashierPayModel cashierPayModel) {
        PaymentResultFragment BuiltInFictitiousFunctionClassFactory;
        String str;
        String str2;
        String format;
        String format2;
        AttributeCashierPayModel attributeCashierPayModel = cashierPayModel.KClassImpl$Data$declaredNonStaticMembers$2;
        if (attributeCashierPayModel != null) {
            PayResultModel payResultModel = (PayResultModel) topUpAndPayInputFragment.getErrorConfigVersion.getValue();
            String str3 = attributeCashierPayModel.T;
            if (str3 == null) {
                str3 = "";
            }
            payResultModel.com.alibaba.griver.image.photo.utils.DiskFormatter.MB java.lang.String = str3;
            payResultModel.isLayoutRequested = attributeCashierPayModel.NetworkUserEntityData$$ExternalSyntheticLambda8;
            String str4 = attributeCashierPayModel.SubSequence;
            if (str4 == null) {
                str4 = "";
            }
            Intrinsics.checkNotNullParameter(str4, "");
            payResultModel.PrepareContext = str4;
            MoneyViewModel moneyViewModel = attributeCashierPayModel.getValueOfTouchPositionAbsolute;
            if (moneyViewModel != null) {
                StringBuilder sb = new StringBuilder();
                sb.append(moneyViewModel.KClassImpl$Data$declaredNonStaticMembers$2);
                format2 = NumberFormat.getNumberInstance(LocaleUtil.BuiltInFictitiousFunctionClassFactory()).format(moneyViewModel.MyBillsEntityDataFactory());
                if (format2 == null) {
                    format2 = "";
                }
                sb.append(format2);
                str = sb.toString();
            } else {
                str = null;
            }
            if (str == null) {
                str = "";
            }
            Intrinsics.checkNotNullParameter(str, "");
            payResultModel.SubSequence = str;
            MoneyViewModel moneyViewModel2 = attributeCashierPayModel.X;
            if (moneyViewModel2 != null) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append(moneyViewModel2.KClassImpl$Data$declaredNonStaticMembers$2);
                format = NumberFormat.getNumberInstance(LocaleUtil.BuiltInFictitiousFunctionClassFactory()).format(moneyViewModel2.MyBillsEntityDataFactory());
                if (format == null) {
                    format = "";
                }
                sb2.append(format);
                str2 = sb2.toString();
            } else {
                str2 = null;
            }
            if (str2 == null) {
                str2 = "";
            }
            payResultModel.AppCompatEmojiTextHelper = str2;
            String str5 = attributeCashierPayModel.KClassImpl$Data$declaredNonStaticMembers$2;
            if (str5 == null) {
                str5 = "";
            }
            Intrinsics.checkNotNullParameter(str5, "");
            payResultModel.BuiltInFictitiousFunctionClassFactory = str5;
            String str6 = attributeCashierPayModel.C;
            if (str6 == null) {
                str6 = "";
            }
            Intrinsics.checkNotNullParameter(str6, "");
            payResultModel.NetworkUserEntityData$$ExternalSyntheticLambda4 = str6;
            payResultModel.VerifyPinStateManager$executeRiskChallenge$2$1 = attributeCashierPayModel.id.dana.sendmoney.summary.SummaryActivity.DAYS java.lang.String;
            String str7 = cashierPayModel.MyBillsEntityDataFactory;
            if (str7 == null) {
                str7 = "";
            }
            Intrinsics.checkNotNullParameter(str7, "");
            payResultModel.getErrorConfigVersion = str7;
            String str8 = attributeCashierPayModel.O;
            if (str8 == null) {
                str8 = "fail";
            }
            payResultModel.getValueOfTouchPositionAbsolute = str8;
            String str9 = attributeCashierPayModel.flip;
            if (str9 == null) {
                str9 = "";
            }
            Intrinsics.checkNotNullParameter(str9, "");
            payResultModel.J = str9;
            payResultModel.moveToNextValue = attributeCashierPayModel.NetworkUserEntityData$$ExternalSyntheticLambda0;
            payResultModel.NetworkUserEntityData$$ExternalSyntheticLambda7 = true;
            ProcessingMilestoneModel processingMilestoneModel = attributeCashierPayModel.L;
            payResultModel.getCallingPid = processingMilestoneModel != null ? processingMilestoneModel.PlaceComponentResult : null;
            payResultModel.getSupportButtonTintMode = attributeCashierPayModel.getOnBoardingScenario;
            payResultModel.VerifyPinStateManager$executeRiskChallenge$2$2 = attributeCashierPayModel.SummaryVoucherView$$ExternalSyntheticLambda0;
            payResultModel.NetworkUserEntityData$$ExternalSyntheticLambda2 = attributeCashierPayModel.GetContactSyncConfig;
            payResultModel.FragmentBottomSheetPaymentSettingBinding = attributeCashierPayModel.getSupportButtonTintMode;
            payResultModel.K = attributeCashierPayModel.V;
            String BuiltInFictitiousFunctionClassFactory2 = attributeCashierPayModel.BuiltInFictitiousFunctionClassFactory();
            Intrinsics.checkNotNullParameter(BuiltInFictitiousFunctionClassFactory2, "");
            payResultModel.NetworkUserEntityData$$ExternalSyntheticLambda1 = BuiltInFictitiousFunctionClassFactory2;
            payResultModel.MyBillsEntityDataFactory = attributeCashierPayModel.BuiltInFictitiousFunctionClassFactory;
        }
        BaseActivity baseActivity = topUpAndPayInputFragment.getBaseActivity();
        PayActivity payActivity = baseActivity instanceof PayActivity ? (PayActivity) baseActivity : null;
        if (payActivity != null) {
            PaymentResultFragment.Companion companion = PaymentResultFragment.KClassImpl$Data$declaredNonStaticMembers$2;
            BuiltInFictitiousFunctionClassFactory = PaymentResultFragment.Companion.BuiltInFictitiousFunctionClassFactory((PayResultModel) topUpAndPayInputFragment.getErrorConfigVersion.getValue(), false);
            payActivity.addFragment(BuiltInFictitiousFunctionClassFactory);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Type inference failed for: r17v0, types: [id.dana.cashier.model.CashierPayMethodModel, java.lang.String] */
    public final void MyBillsEntityDataFactory(AttributeCashierPayModel p0) {
        String str;
        List<String> list;
        List<OneKlikPhonesModel> list2;
        RiskVerificationMethodModel riskVerificationMethodModel;
        RiskVerificationMethodModel riskVerificationMethodModel2;
        List<OneKlikPhonesModel> list3;
        List<String> list4;
        String str2;
        if (p0 != null) {
            List<RiskVerificationMethodModel> list5 = p0.SummaryVoucherView$$ExternalSyntheticLambda1;
            if (list5 == null || list5.isEmpty()) {
                RiskVerificationMethodModel riskVerificationMethodModel3 = p0.com.alibaba.griver.image.photo.utils.DiskFormatter.KB java.lang.String;
                if (riskVerificationMethodModel3 == null || (str2 = riskVerificationMethodModel3.scheduleImpl) == null) {
                    RiskVerificationMethodModel riskVerificationMethodModel4 = p0.P;
                    str2 = riskVerificationMethodModel4 != null ? riskVerificationMethodModel4.scheduleImpl : null;
                }
            } else {
                str2 = ((RiskVerificationMethodModel) CollectionsKt.first((List) p0.SummaryVoucherView$$ExternalSyntheticLambda1)).scheduleImpl;
            }
            str = str2;
        } else {
            str = null;
        }
        if (p0 != null) {
            List<RiskVerificationMethodModel> list6 = p0.SummaryVoucherView$$ExternalSyntheticLambda1;
            if (!(list6 == null || list6.isEmpty())) {
                RiskVerificationMethodModel riskVerificationMethodModel5 = (RiskVerificationMethodModel) CollectionsKt.firstOrNull((List) p0.SummaryVoucherView$$ExternalSyntheticLambda1);
                if (riskVerificationMethodModel5 != null) {
                    list4 = riskVerificationMethodModel5.lookAheadTest;
                    list = list4;
                }
                list4 = null;
                list = list4;
            } else {
                RiskVerificationMethodModel riskVerificationMethodModel6 = p0.com.alibaba.griver.image.photo.utils.DiskFormatter.KB java.lang.String;
                if (riskVerificationMethodModel6 == null || (list4 = riskVerificationMethodModel6.lookAheadTest) == null) {
                    RiskVerificationMethodModel riskVerificationMethodModel7 = p0.P;
                    if (riskVerificationMethodModel7 != null) {
                        list4 = riskVerificationMethodModel7.lookAheadTest;
                    }
                    list4 = null;
                }
                list = list4;
            }
        } else {
            list = null;
        }
        String str3 = p0 != null ? p0.N : null;
        if (str3 == null) {
            str3 = "";
        }
        KClassImpl$Data$declaredNonStaticMembers$2(str3);
        if (p0 != null) {
            p0.X = this.NetworkUserEntityData$$ExternalSyntheticLambda1;
        }
        if (p0 != null) {
            p0.KClassImpl$Data$declaredNonStaticMembers$2 = this.scheduleImpl;
        }
        TopUpVerifyRequestModel PlaceComponentResult2 = PlaceComponentResult(str);
        BaseActivity baseActivity = getBaseActivity();
        PayActivity payActivity = baseActivity instanceof PayActivity ? (PayActivity) baseActivity : null;
        if (payActivity != null) {
            payActivity.setTopUpPayInputFragmentParameter(PlaceComponentResult2, this.scheduleImpl);
        }
        ?? r17 = 0;
        String str4 = str;
        RiskParamsFactory riskParamsFactory = new RiskParamsFactory(p0, this.PlaceComponentResult, this.scheduleImpl, false, null, null, null, PlaceComponentResult2, null, null, null, null, r17, r17, list, 16248, null);
        BaseActivity baseActivity2 = getBaseActivity();
        PayActivity payActivity2 = baseActivity2 instanceof PayActivity ? (PayActivity) baseActivity2 : null;
        if (payActivity2 != null) {
            String str5 = str4 == null ? "" : str4;
            if (p0 == null || (riskVerificationMethodModel2 = p0.com.alibaba.griver.image.photo.utils.DiskFormatter.KB java.lang.String) == null || (list3 = riskVerificationMethodModel2.getAuthRequestContext) == null) {
                list2 = (p0 == null || (riskVerificationMethodModel = p0.P) == null) ? null : riskVerificationMethodModel.getAuthRequestContext;
            } else {
                list2 = list3;
            }
            payActivity2.handleCashierRiskPhase(str5, riskParamsFactory, list2, this);
        }
    }

    @Override // id.dana.cashier.fragment.BaseCashierFragment
    public final void BuiltInFictitiousFunctionClassFactory(String p0, String p1, String p2, String p3, String p4, boolean p5) {
        String str;
        String format;
        Intrinsics.checkNotNullParameter(p0, "");
        Intrinsics.checkNotNullParameter(p3, "");
        Intrinsics.checkNotNullParameter(p4, "");
        PayResultModel payResultModel = (PayResultModel) this.getErrorConfigVersion.getValue();
        MoneyViewModel moneyViewModel = this.NetworkUserEntityData$$ExternalSyntheticLambda1;
        if (moneyViewModel != null) {
            StringBuilder sb = new StringBuilder();
            sb.append(moneyViewModel.KClassImpl$Data$declaredNonStaticMembers$2);
            format = NumberFormat.getNumberInstance(LocaleUtil.BuiltInFictitiousFunctionClassFactory()).format(moneyViewModel.MyBillsEntityDataFactory());
            if (format == null) {
                format = "";
            }
            sb.append(format);
            str = sb.toString();
        } else {
            str = null;
        }
        payResultModel.AppCompatEmojiTextHelper = str;
        payResultModel.getValueOfTouchPositionAbsolute = p0;
        String str2 = this.PlaceComponentResult;
        Intrinsics.checkNotNullParameter(str2, "");
        payResultModel.getErrorConfigVersion = str2;
        payResultModel.GetContactSyncConfig = p1;
        payResultModel.scheduleImpl = p2;
        payResultModel.NetworkUserEntityData$$ExternalSyntheticLambda7 = true;
        payResultModel.G = PlaceComponentResult;
        BaseActivity baseActivity = getBaseActivity();
        PayActivity payActivity = baseActivity instanceof PayActivity ? (PayActivity) baseActivity : null;
        if (payActivity != null) {
            PaymentResultFragment.Companion companion = PaymentResultFragment.KClassImpl$Data$declaredNonStaticMembers$2;
            payActivity.addFragment(PaymentResultFragment.Companion.BuiltInFictitiousFunctionClassFactory(payResultModel, p5));
        }
    }

    @Override // id.dana.cashier.fragment.BaseCashierFragment, id.dana.base.BaseFragment, androidx.fragment.app.Fragment
    public final /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        this.KClassImpl$Data$declaredNonStaticMembers$2.clear();
    }

    @Override // id.dana.cashier.fragment.BaseCashierFragment
    public final void MyBillsEntityDataFactory(boolean p0) {
        CashierAnalyticTracker cashierAnalyticTracker = this.cashierAnalyticTracker;
        if (cashierAnalyticTracker == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            cashierAnalyticTracker = null;
        }
        CashierAnalyticTracker.CC.BuiltInFictitiousFunctionClassFactory(cashierAnalyticTracker, this.PlaceComponentResult, TrackerKey.CashierRiskType.FACE_VERIFICATION_CASHIER, Boolean.valueOf(p0), 4);
    }
}
