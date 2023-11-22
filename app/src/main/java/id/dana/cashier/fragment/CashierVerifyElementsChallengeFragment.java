package id.dana.cashier.fragment;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.inputmethod.InputMethodManager;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import dagger.internal.Preconditions;
import id.dana.R;
import id.dana.base.AbstractContract;
import id.dana.base.ThrottledOnClickListenerKt;
import id.dana.cashier.CashierAddOnModule;
import id.dana.cashier.CashierAddOnViewListener;
import id.dana.cashier.CashierCardBindingModule;
import id.dana.cashier.CashierHighlightModule;
import id.dana.cashier.CashierHighlightViewListener;
import id.dana.cashier.CashierPayLaterModule;
import id.dana.cashier.CashierPayLaterViewListener;
import id.dana.cashier.CashierUserRelatedModule;
import id.dana.cashier.CashierUserRelatedViewListener;
import id.dana.cashier.CashierViewListener;
import id.dana.cashier.adapter.OnInsertVerifyElementsListener;
import id.dana.cashier.adapter.VerifyElementsChallengeAdapter;
import id.dana.cashier.addCard.factory.CashierAddCardVerifyElementsFactory;
import id.dana.cashier.fragment.CashierOtpChallengeFragment;
import id.dana.cashier.model.AssetCardModel;
import id.dana.cashier.model.CashierPayMethodModel;
import id.dana.cashier.model.CashierPayMethodModelKt;
import id.dana.cashier.model.PayResultModel;
import id.dana.cashier.model.SendBankOtpModel;
import id.dana.cashier.presenter.CashierRiskChallengePresenter;
import id.dana.cashier.utils.CashierKeyParams;
import id.dana.component.buttoncomponent.DanaButtonSecondaryView;
import id.dana.data.util.NumberUtils;
import id.dana.databinding.FragmentCashierVerifyElementsChallengeBinding;
import id.dana.di.component.ApplicationComponent;
import id.dana.di.component.DaggerCashierComponent;
import id.dana.di.modules.CashierAnalyticModule;
import id.dana.di.modules.CashierModule;
import id.dana.di.modules.CashierRiskChallengeModule;
import id.dana.di.modules.TopUpAndPayModule;
import id.dana.nearbyme.merchantdetail.model.MoneyViewModel;
import id.dana.pay.PayActivity;
import id.dana.utils.KeyboardHelper;
import io.reactivex.Observable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function4;
import io.reactivex.subjects.PublishSubject;
import io.reactivex.subjects.Subject;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import javax.inject.Inject;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmName;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 82\b\u0012\u0004\u0012\u00020\u00020\u0001:\u00018B\u0007¢\u0006\u0004\b7\u0010\u0005J\u000f\u0010\u0004\u001a\u00020\u0003H\u0014¢\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\u0006\u001a\u00020\u0003H\u0014¢\u0006\u0004\b\u0006\u0010\u0005J/\u0010\f\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\f\u0010\rJ\u000f\u0010\u000e\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u000e\u0010\u0005J\u000f\u0010\u000f\u001a\u00020\u0003H\u0014¢\u0006\u0004\b\u000f\u0010\u0005R\u0016\u0010\u0013\u001a\u00020\u00108\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u001c\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00070\u00148\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u0016\u0010\u0019\u001a\u00020\u00108\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0018\u0010\u0012R\u001c\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00070\u00148\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001a\u0010\u0016R\u0018\u0010\f\u001a\u0004\u0018\u00010\u001c8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0004\u0010\u001dR\u0012\u0010\u001f\u001a\u00020\u001eX\u0087\"¢\u0006\u0006\n\u0004\b\u001f\u0010 R\u0016\u0010\"\u001a\u00020\u00108\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\b!\u0010\u0012R\u001c\u0010#\u001a\b\u0012\u0004\u0012\u00020\u00070\u00148\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\b\u0006\u0010\u0016R\u0016\u0010%\u001a\u00020\u00108\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\b$\u0010\u0012R\u001c\u0010'\u001a\b\u0012\u0004\u0012\u00020\u00070\u00148\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\b&\u0010\u0016R\u001b\u0010,\u001a\u00020\u00078CX\u0083\u0084\u0002¢\u0006\f\n\u0004\b(\u0010)\u001a\u0004\b*\u0010+R\u001b\u0010/\u001a\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010-X\u0083\u0080\u0002¢\u0006\u0006\n\u0004\b.\u0010)R0\u0010\u0015\u001a\b\u0012\u0004\u0012\u000201002\f\u0010\b\u001a\b\u0012\u0004\u0012\u000201008\u0002@CX\u0083\u000e¢\u0006\f\n\u0004\b\u000f\u00102\"\u0004\b\u0017\u00103R\u0016\u0010\u0011\u001a\u0002048\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\b5\u00106"}, d2 = {"Lid/dana/cashier/fragment/CashierVerifyElementsChallengeFragment;", "Lid/dana/cashier/fragment/BaseCashierRiskFragment;", "Lid/dana/databinding/FragmentCashierVerifyElementsChallengeBinding;", "", "NetworkUserEntityData$$ExternalSyntheticLambda3", "()V", "NetworkUserEntityData$$ExternalSyntheticLambda4", "", "p0", "p1", "p2", "p3", "BuiltInFictitiousFunctionClassFactory", "(ZZZZ)Z", "onDestroyView", "whenAvailable", "", "GetContactSyncConfig", "Ljava/lang/String;", "PlaceComponentResult", "Lio/reactivex/subjects/Subject;", "initRecordTimeStamp", "Lio/reactivex/subjects/Subject;", "getAuthRequestContext", "NetworkUserEntityData$$ExternalSyntheticLambda7", "MyBillsEntityDataFactory", "isLayoutRequested", "KClassImpl$Data$declaredNonStaticMembers$2", "Lid/dana/cashier/model/CashierPayMethodModel$CardPayMethod;", "Lid/dana/cashier/model/CashierPayMethodModel$CardPayMethod;", "Lid/dana/cashier/presenter/CashierRiskChallengePresenter;", "cashierRiskChallengePresenter", "Lid/dana/cashier/presenter/CashierRiskChallengePresenter;", "FragmentBottomSheetPaymentSettingBinding", "NetworkUserEntityData$$ExternalSyntheticLambda0", "lookAheadTest", "NetworkUserEntityData$$ExternalSyntheticLambda5", "scheduleImpl", "NetworkUserEntityData$$ExternalSyntheticLambda6", "moveToNextValue", "SubSequence", "Lkotlin/Lazy;", "C", "()Z", "getErrorConfigVersion", "", "readMicros", "NetworkUserEntityData$$ExternalSyntheticLambda1", "", "", "Ljava/util/List;", "(Ljava/util/List;)V", "Lid/dana/cashier/adapter/VerifyElementsChallengeAdapter;", "getCallingPid", "Lid/dana/cashier/adapter/VerifyElementsChallengeAdapter;", "<init>", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class CashierVerifyElementsChallengeFragment extends BaseCashierRiskFragment<FragmentCashierVerifyElementsChallengeBinding> {

    /* renamed from: Companion  reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda3  reason: from kotlin metadata */
    private CashierPayMethodModel.CardPayMethod BuiltInFictitiousFunctionClassFactory;

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda4  reason: from kotlin metadata */
    private Subject<Boolean> lookAheadTest;

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda6  reason: from kotlin metadata */
    private Subject<Boolean> moveToNextValue;
    @Inject
    public CashierRiskChallengePresenter cashierRiskChallengePresenter;

    /* renamed from: initRecordTimeStamp  reason: from kotlin metadata */
    private Subject<Boolean> getAuthRequestContext;

    /* renamed from: isLayoutRequested  reason: from kotlin metadata */
    private Subject<Boolean> KClassImpl$Data$declaredNonStaticMembers$2;

    /* renamed from: whenAvailable  reason: from kotlin metadata */
    private List<Integer> initRecordTimeStamp;
    public Map<Integer, View> NetworkUserEntityData$$ExternalSyntheticLambda1 = new LinkedHashMap();

    /* renamed from: SubSequence  reason: from kotlin metadata */
    private final Lazy getErrorConfigVersion = LazyKt.lazy(new Function0<Boolean>() { // from class: id.dana.cashier.fragment.CashierVerifyElementsChallengeFragment$isCardRebinding$2
        /* JADX INFO: Access modifiers changed from: package-private */
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final Boolean invoke() {
            Bundle arguments = CashierVerifyElementsChallengeFragment.this.getArguments();
            return Boolean.valueOf(arguments != null ? arguments.getBoolean(CashierKeyParams.IS_CARD_REBINDING) : false);
        }
    });

    /* renamed from: readMicros  reason: from kotlin metadata */
    private final Lazy NetworkUserEntityData$$ExternalSyntheticLambda1 = LazyKt.lazy(new Function0<ArrayList<String>>() { // from class: id.dana.cashier.fragment.CashierVerifyElementsChallengeFragment$rebindingVerifyElements$2
        /* JADX INFO: Access modifiers changed from: package-private */
        {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public final ArrayList<String> invoke() {
            Bundle arguments = CashierVerifyElementsChallengeFragment.this.getArguments();
            if (arguments != null) {
                return arguments.getStringArrayList(CashierKeyParams.REBINDING_VERIFY_ELEMENTS);
            }
            return null;
        }
    });

    /* renamed from: getCallingPid  reason: from kotlin metadata */
    private VerifyElementsChallengeAdapter GetContactSyncConfig = new VerifyElementsChallengeAdapter(new OnInsertVerifyElementsListener() { // from class: id.dana.cashier.fragment.CashierVerifyElementsChallengeFragment$verifyElementsChallengeAdapter$1
        @Override // id.dana.cashier.adapter.OnInsertVerifyElementsListener
        public final /* synthetic */ void BuiltInFictitiousFunctionClassFactory(String str) {
            OnInsertVerifyElementsListener.CC.BuiltInFictitiousFunctionClassFactory(str);
        }

        @Override // id.dana.cashier.adapter.OnInsertVerifyElementsListener
        public final void BuiltInFictitiousFunctionClassFactory(boolean p0) {
        }

        @Override // id.dana.cashier.adapter.OnInsertVerifyElementsListener
        public final void KClassImpl$Data$declaredNonStaticMembers$2(String p0, String p1) {
            Intrinsics.checkNotNullParameter(p0, "");
            Intrinsics.checkNotNullParameter(p1, "");
        }

        @Override // id.dana.cashier.adapter.OnInsertVerifyElementsListener
        public final void KClassImpl$Data$declaredNonStaticMembers$2(boolean p0) {
        }

        @Override // id.dana.cashier.adapter.OnInsertVerifyElementsListener
        public final void MyBillsEntityDataFactory(String p0) {
            Intrinsics.checkNotNullParameter(p0, "");
        }

        @Override // id.dana.cashier.adapter.OnInsertVerifyElementsListener
        public final void lookAheadTest(boolean p0) {
        }

        @Override // id.dana.cashier.adapter.OnInsertVerifyElementsListener
        public final void PlaceComponentResult(String p0, int p1) {
            Intrinsics.checkNotNullParameter(p0, "");
            if (p1 != -1) {
                CashierVerifyElementsChallengeFragment.this.NetworkUserEntityData$$ExternalSyntheticLambda0 = p0;
            }
        }

        @Override // id.dana.cashier.adapter.OnInsertVerifyElementsListener
        public final void MyBillsEntityDataFactory(String p0, int p1) {
            Intrinsics.checkNotNullParameter(p0, "");
            if (p1 != -1) {
                CashierVerifyElementsChallengeFragment.this.MyBillsEntityDataFactory = p0;
            }
        }

        @Override // id.dana.cashier.adapter.OnInsertVerifyElementsListener
        public final void BuiltInFictitiousFunctionClassFactory(String p0, int p1) {
            Intrinsics.checkNotNullParameter(p0, "");
            if (p1 != -1) {
                CashierVerifyElementsChallengeFragment.this.scheduleImpl = p0;
            }
        }

        @Override // id.dana.cashier.adapter.OnInsertVerifyElementsListener
        public final void KClassImpl$Data$declaredNonStaticMembers$2(String p0, int p1) {
            Intrinsics.checkNotNullParameter(p0, "");
            if (p1 != -1) {
                CashierVerifyElementsChallengeFragment.this.PlaceComponentResult = p0;
            }
        }

        @Override // id.dana.cashier.adapter.OnInsertVerifyElementsListener
        public final void PlaceComponentResult(boolean p0) {
            Subject subject;
            subject = CashierVerifyElementsChallengeFragment.this.lookAheadTest;
            subject.onNext(Boolean.valueOf(p0));
        }

        @Override // id.dana.cashier.adapter.OnInsertVerifyElementsListener
        public final void getAuthRequestContext(boolean p0) {
            Subject subject;
            subject = CashierVerifyElementsChallengeFragment.this.KClassImpl$Data$declaredNonStaticMembers$2;
            subject.onNext(Boolean.valueOf(p0));
        }

        @Override // id.dana.cashier.adapter.OnInsertVerifyElementsListener
        public final void moveToNextValue(boolean p0) {
            Subject subject;
            subject = CashierVerifyElementsChallengeFragment.this.moveToNextValue;
            subject.onNext(Boolean.valueOf(p0));
        }

        @Override // id.dana.cashier.adapter.OnInsertVerifyElementsListener
        public final void MyBillsEntityDataFactory(boolean p0) {
            Subject subject;
            subject = CashierVerifyElementsChallengeFragment.this.getAuthRequestContext;
            subject.onNext(Boolean.valueOf(p0));
        }
    });

    /* renamed from: GetContactSyncConfig  reason: from kotlin metadata */
    private String PlaceComponentResult = "";

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda7  reason: from kotlin metadata */
    private String MyBillsEntityDataFactory = "";

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda5  reason: from kotlin metadata */
    private String scheduleImpl = "";

    /* renamed from: FragmentBottomSheetPaymentSettingBinding  reason: from kotlin metadata */
    private String NetworkUserEntityData$$ExternalSyntheticLambda0 = "";

    @Override // id.dana.cashier.fragment.BaseCashierRiskFragment, id.dana.cashier.fragment.BaseVBCashierFragment, id.dana.core.ui.BaseViewBindingFragment
    public final View getAuthRequestContext(int i) {
        View findViewById;
        Map<Integer, View> map = this.NetworkUserEntityData$$ExternalSyntheticLambda1;
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

    @Override // id.dana.cashier.fragment.BaseCashierRiskFragment, id.dana.cashier.fragment.BaseVBCashierFragment, id.dana.core.ui.BaseViewBindingFragment
    public final void getAuthRequestContext() {
        this.NetworkUserEntityData$$ExternalSyntheticLambda1.clear();
    }

    public CashierVerifyElementsChallengeFragment() {
        PublishSubject PlaceComponentResult = PublishSubject.PlaceComponentResult();
        Intrinsics.checkNotNullExpressionValue(PlaceComponentResult, "");
        this.lookAheadTest = PlaceComponentResult;
        PublishSubject PlaceComponentResult2 = PublishSubject.PlaceComponentResult();
        Intrinsics.checkNotNullExpressionValue(PlaceComponentResult2, "");
        this.getAuthRequestContext = PlaceComponentResult2;
        PublishSubject PlaceComponentResult3 = PublishSubject.PlaceComponentResult();
        Intrinsics.checkNotNullExpressionValue(PlaceComponentResult3, "");
        this.KClassImpl$Data$declaredNonStaticMembers$2 = PlaceComponentResult3;
        PublishSubject PlaceComponentResult4 = PublishSubject.PlaceComponentResult();
        Intrinsics.checkNotNullExpressionValue(PlaceComponentResult4, "");
        this.moveToNextValue = PlaceComponentResult4;
        this.initRecordTimeStamp = new ArrayList();
    }

    @Override // id.dana.core.ui.BaseViewBindingFragment
    public final /* synthetic */ ViewBinding MyBillsEntityDataFactory(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        Intrinsics.checkNotNullParameter(layoutInflater, "");
        FragmentCashierVerifyElementsChallengeBinding MyBillsEntityDataFactory = FragmentCashierVerifyElementsChallengeBinding.MyBillsEntityDataFactory(layoutInflater);
        Intrinsics.checkNotNullExpressionValue(MyBillsEntityDataFactory, "");
        return MyBillsEntityDataFactory;
    }

    @JvmName(name = "C")
    private final boolean C() {
        return ((Boolean) this.getErrorConfigVersion.getValue()).booleanValue();
    }

    @JvmName(name = "getAuthRequestContext")
    private final void getAuthRequestContext(List<Integer> list) {
        AssetCardModel assetCardModel;
        this.initRecordTimeStamp = list;
        CashierAddCardVerifyElementsFactory cashierAddCardVerifyElementsFactory = CashierAddCardVerifyElementsFactory.INSTANCE;
        List<Integer> list2 = this.initRecordTimeStamp;
        CashierPayMethodModel.CardPayMethod cardPayMethod = this.BuiltInFictitiousFunctionClassFactory;
        this.GetContactSyncConfig.setItems(CashierAddCardVerifyElementsFactory.PlaceComponentResult(list2, (cardPayMethod == null || (assetCardModel = cardPayMethod.KClassImpl$Data$declaredNonStaticMembers$2) == null) ? null : assetCardModel.moveToNextValue));
    }

    @Override // id.dana.cashier.fragment.BaseVBCashierFragment
    protected final void NetworkUserEntityData$$ExternalSyntheticLambda4() {
        Context applicationContext;
        Window window;
        Window window2;
        FragmentActivity activity = getActivity();
        if (activity != null && (window2 = activity.getWindow()) != null) {
            window2.setSoftInputMode(16);
        }
        FragmentActivity activity2 = getActivity();
        KeyboardHelper.PlaceComponentResult((activity2 == null || (window = activity2.getWindow()) == null) ? null : window.getDecorView(), new KeyboardHelper.KeyboardVisibilityListener() { // from class: id.dana.cashier.fragment.CashierVerifyElementsChallengeFragment$setupKeyboardListener$1
            @Override // id.dana.utils.KeyboardHelper.KeyboardVisibilityListener
            public final void KClassImpl$Data$declaredNonStaticMembers$2() {
                FragmentActivity activity3 = CashierVerifyElementsChallengeFragment.this.getActivity();
                PayActivity payActivity = activity3 instanceof PayActivity ? (PayActivity) activity3 : null;
                if (payActivity != null) {
                    payActivity.expandBottomSheet();
                }
            }

            @Override // id.dana.utils.KeyboardHelper.KeyboardVisibilityListener
            public final void MyBillsEntityDataFactory() {
                FragmentActivity activity3 = CashierVerifyElementsChallengeFragment.this.getActivity();
                PayActivity payActivity = activity3 instanceof PayActivity ? (PayActivity) activity3 : null;
                if (payActivity != null) {
                    payActivity.setHalfScreenBottomSheet();
                }
            }
        });
        if (C()) {
            FragmentActivity activity3 = getActivity();
            PayActivity payActivity = activity3 instanceof PayActivity ? (PayActivity) activity3 : null;
            if (payActivity != null) {
                payActivity.setNeedExpandPayMethodOnBack(true);
                payActivity.setNeedBackConfirmation(true);
            }
        }
        VB vb = this.PlaceComponentResult;
        if (vb != 0) {
            RecyclerView recyclerView = ((FragmentCashierVerifyElementsChallengeBinding) vb).KClassImpl$Data$declaredNonStaticMembers$2;
            recyclerView.setLayoutManager(new LinearLayoutManager(recyclerView.getContext(), 1, false));
            recyclerView.setAdapter(this.GetContactSyncConfig);
            RecyclerView recyclerView2 = recyclerView;
            if (recyclerView2 != null) {
                recyclerView2.requestFocus();
                Context context = recyclerView2.getContext();
                Object systemService = (context == null || (applicationContext = context.getApplicationContext()) == null) ? null : applicationContext.getSystemService("input_method");
                InputMethodManager inputMethodManager = systemService instanceof InputMethodManager ? systemService : null;
                if (inputMethodManager != null) {
                    inputMethodManager.showSoftInput(recyclerView2, 1);
                }
            }
            VB vb2 = this.PlaceComponentResult;
            if (vb2 != 0) {
                DanaButtonSecondaryView danaButtonSecondaryView = ((FragmentCashierVerifyElementsChallengeBinding) vb2).getAuthRequestContext;
                Intrinsics.checkNotNullExpressionValue(danaButtonSecondaryView, "");
                ThrottledOnClickListenerKt.PlaceComponentResult(danaButtonSecondaryView, new Function1<View, Unit>() { // from class: id.dana.cashier.fragment.CashierVerifyElementsChallengeFragment$onClickNext$1
                    /* JADX INFO: Access modifiers changed from: package-private */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final /* bridge */ /* synthetic */ Unit invoke(View view) {
                        invoke2(view);
                        return Unit.INSTANCE;
                    }

                    /* JADX WARN: Code restructure failed: missing block: B:5:0x000c, code lost:
                    
                        r4 = r3.this$0.BuiltInFictitiousFunctionClassFactory;
                     */
                    /* renamed from: invoke  reason: avoid collision after fix types in other method */
                    /*
                        Code decompiled incorrectly, please refer to instructions dump.
                        To view partially-correct code enable 'Show inconsistent code' option in preferences
                    */
                    public final void invoke2(android.view.View r4) {
                        /*
                            r3 = this;
                            java.lang.String r0 = ""
                            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r4, r0)
                            boolean r4 = r4.isEnabled()
                            if (r4 != 0) goto Lc
                            return
                        Lc:
                            id.dana.cashier.fragment.CashierVerifyElementsChallengeFragment r4 = id.dana.cashier.fragment.CashierVerifyElementsChallengeFragment.this
                            id.dana.cashier.model.CashierPayMethodModel$CardPayMethod r4 = id.dana.cashier.fragment.CashierVerifyElementsChallengeFragment.getAuthRequestContext(r4)
                            if (r4 == 0) goto L26
                            id.dana.cashier.fragment.CashierVerifyElementsChallengeFragment r1 = id.dana.cashier.fragment.CashierVerifyElementsChallengeFragment.this
                            id.dana.cashier.presenter.CashierRiskChallengePresenter r2 = r1.cashierRiskChallengePresenter
                            if (r2 == 0) goto L1b
                            goto L1f
                        L1b:
                            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r0)
                            r2 = 0
                        L1f:
                            id.dana.cashier.model.SendBankOtpModel r4 = id.dana.cashier.fragment.CashierVerifyElementsChallengeFragment.getAuthRequestContext(r1, r4)
                            r2.PlaceComponentResult(r4)
                        L26:
                            return
                        */
                        throw new UnsupportedOperationException("Method not decompiled: id.dana.cashier.fragment.CashierVerifyElementsChallengeFragment$onClickNext$1.invoke2(android.view.View):void");
                    }
                });
                Subject<Boolean> subject = this.lookAheadTest;
                Boolean bool = Boolean.FALSE;
                subject.onNext(bool);
                this.getAuthRequestContext.onNext(bool);
                this.KClassImpl$Data$declaredNonStaticMembers$2.onNext(bool);
                this.moveToNextValue.onNext(bool);
                return;
            }
            throw new IllegalArgumentException("Required value was null.".toString());
        }
        throw new IllegalArgumentException("Required value was null.".toString());
    }

    @Override // id.dana.cashier.fragment.BaseVBCashierFragment
    protected final void NetworkUserEntityData$$ExternalSyntheticLambda3() {
        DaggerCashierComponent.Builder MyBillsEntityDataFactory = DaggerCashierComponent.MyBillsEntityDataFactory();
        MyBillsEntityDataFactory.BuiltInFictitiousFunctionClassFactory = (ApplicationComponent) Preconditions.getAuthRequestContext(initRecordTimeStamp());
        MyBillsEntityDataFactory.NetworkUserEntityData$$ExternalSyntheticLambda0 = (CashierRiskChallengeModule) Preconditions.getAuthRequestContext(new CashierRiskChallengeModule(new CashierViewListener() { // from class: id.dana.cashier.fragment.CashierVerifyElementsChallengeFragment$cashierRiskChallengeModule$1
            @Override // id.dana.cashier.CashierViewListener, id.dana.base.AbstractContractKt.AbstractView, id.dana.base.AbstractContract.AbstractView
            public final void onError(String p0) {
            }

            @Override // id.dana.cashier.CashierViewListener, id.dana.cashier.CashierRiskChallengeContract.View
            public final void getAuthRequestContext(int i, int i2) {
                CashierVerifyElementsChallengeFragment.BuiltInFictitiousFunctionClassFactory(CashierVerifyElementsChallengeFragment.this, i, i2);
            }

            @Override // id.dana.cashier.CashierViewListener, id.dana.base.AbstractContractKt.AbstractView, id.dana.base.AbstractContract.AbstractView
            public final void showProgress() {
                KeyboardHelper.BuiltInFictitiousFunctionClassFactory(CashierVerifyElementsChallengeFragment.this.getActivity());
                CashierVerifyElementsChallengeFragment.this.SubSequence();
            }

            @Override // id.dana.cashier.CashierViewListener, id.dana.base.AbstractContractKt.AbstractView, id.dana.base.AbstractContract.AbstractView
            public final void dismissProgress() {
                CashierVerifyElementsChallengeFragment.this.GetContactSyncConfig();
            }
        }));
        MyBillsEntityDataFactory.scheduleImpl = (CashierModule) Preconditions.getAuthRequestContext(new CashierModule(new CashierViewListener() { // from class: id.dana.cashier.fragment.CashierVerifyElementsChallengeFragment$cashierModule$1
        }));
        MyBillsEntityDataFactory.getErrorConfigVersion = (TopUpAndPayModule) Preconditions.getAuthRequestContext(new TopUpAndPayModule(new CashierViewListener() { // from class: id.dana.cashier.fragment.CashierVerifyElementsChallengeFragment$topUpAndPayModule$1
        }));
        MyBillsEntityDataFactory.MyBillsEntityDataFactory = (CashierAnalyticModule) Preconditions.getAuthRequestContext(new CashierAnalyticModule());
        MyBillsEntityDataFactory.PlaceComponentResult = (CashierCardBindingModule) Preconditions.getAuthRequestContext(new CashierCardBindingModule(new CashierViewListener() { // from class: id.dana.cashier.fragment.CashierVerifyElementsChallengeFragment$cashierCardBindingModule$1
        }));
        MyBillsEntityDataFactory.moveToNextValue = (CashierPayLaterModule) Preconditions.getAuthRequestContext(new CashierPayLaterModule(new CashierPayLaterViewListener() { // from class: id.dana.cashier.fragment.CashierVerifyElementsChallengeFragment$cashierPayLaterModule$1
        }));
        MyBillsEntityDataFactory.KClassImpl$Data$declaredNonStaticMembers$2 = (CashierAddOnModule) Preconditions.getAuthRequestContext(new CashierAddOnModule(new CashierAddOnViewListener() { // from class: id.dana.cashier.fragment.CashierVerifyElementsChallengeFragment$cashierAddOnModule$1
        }));
        MyBillsEntityDataFactory.lookAheadTest = (CashierUserRelatedModule) Preconditions.getAuthRequestContext(new CashierUserRelatedModule(new CashierUserRelatedViewListener() { // from class: id.dana.cashier.fragment.CashierVerifyElementsChallengeFragment$cashierUserRelatedModule$1
        }));
        MyBillsEntityDataFactory.getAuthRequestContext = (CashierHighlightModule) Preconditions.getAuthRequestContext(new CashierHighlightModule(new CashierHighlightViewListener() { // from class: id.dana.cashier.fragment.CashierVerifyElementsChallengeFragment$cashierHighlightModule$1
        }));
        MyBillsEntityDataFactory.MyBillsEntityDataFactory().getAuthRequestContext(this);
        AbstractContract.AbstractPresenter[] abstractPresenterArr = new AbstractContract.AbstractPresenter[1];
        CashierRiskChallengePresenter cashierRiskChallengePresenter = this.cashierRiskChallengePresenter;
        if (cashierRiskChallengePresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            cashierRiskChallengePresenter = null;
        }
        abstractPresenterArr[0] = cashierRiskChallengePresenter;
        BuiltInFictitiousFunctionClassFactory(abstractPresenterArr);
        Disposable subscribe = Observable.combineLatest(this.lookAheadTest, this.getAuthRequestContext, this.KClassImpl$Data$declaredNonStaticMembers$2, this.moveToNextValue, new Function4() { // from class: id.dana.cashier.fragment.CashierVerifyElementsChallengeFragment$$ExternalSyntheticLambda0
            @Override // io.reactivex.functions.Function4
            public final Object apply(Object obj, Object obj2, Object obj3, Object obj4) {
                return CashierVerifyElementsChallengeFragment.PlaceComponentResult(CashierVerifyElementsChallengeFragment.this, ((Boolean) obj).booleanValue(), (Boolean) obj2, (Boolean) obj3, (Boolean) obj4);
            }
        }).subscribe(new Consumer() { // from class: id.dana.cashier.fragment.CashierVerifyElementsChallengeFragment$$ExternalSyntheticLambda1
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                CashierVerifyElementsChallengeFragment.BuiltInFictitiousFunctionClassFactory(CashierVerifyElementsChallengeFragment.this, ((Boolean) obj).booleanValue());
            }
        });
        Intrinsics.checkNotNullExpressionValue(subscribe, "");
        PlaceComponentResult(subscribe);
    }

    @Override // id.dana.cashier.fragment.BaseVBCashierFragment
    protected final void whenAvailable() {
        CashierPayMethodModel.CardPayMethod MyBillsEntityDataFactory;
        List<String> list;
        Bundle arguments = getArguments();
        if (arguments != null) {
            this.BuiltInFictitiousFunctionClassFactory = (CashierPayMethodModel.CardPayMethod) arguments.getParcelable(CashierKeyParams.CASHIER_PAY_METHOD);
            MyBillsEntityDataFactory((PayResultModel) arguments.getParcelable(CashierKeyParams.PAY_RESULT_MODEL));
            if (!C()) {
                CashierPayMethodModel.CardPayMethod cardPayMethod = this.BuiltInFictitiousFunctionClassFactory;
                if (cardPayMethod == null || (MyBillsEntityDataFactory = CashierPayMethodModelKt.MyBillsEntityDataFactory(cardPayMethod)) == null || (list = MyBillsEntityDataFactory.KClassImpl$Data$declaredNonStaticMembers$2.E) == null) {
                    return;
                }
                if ((!list.isEmpty()) == false) {
                    list = null;
                }
                if (list != null) {
                    CashierAddCardVerifyElementsFactory cashierAddCardVerifyElementsFactory = CashierAddCardVerifyElementsFactory.INSTANCE;
                    getAuthRequestContext(CashierAddCardVerifyElementsFactory.getAuthRequestContext(list));
                    return;
                }
                return;
            }
            List list2 = (List) this.NetworkUserEntityData$$ExternalSyntheticLambda1.getValue();
            if (list2 != null) {
                CashierAddCardVerifyElementsFactory cashierAddCardVerifyElementsFactory2 = CashierAddCardVerifyElementsFactory.INSTANCE;
                getAuthRequestContext(CashierAddCardVerifyElementsFactory.getAuthRequestContext(list2));
            }
        }
    }

    private final boolean BuiltInFictitiousFunctionClassFactory(boolean p0, boolean p1, boolean p2, boolean p3) {
        List<Integer> list = this.initRecordTimeStamp;
        if (!p0 && !list.contains(3)) {
            p0 = true;
        }
        if (!p1 && !list.contains(5)) {
            p1 = true;
        }
        if (!p2 && !list.contains(0)) {
            p2 = true;
        }
        if (!p3 && !list.contains(2)) {
            p3 = true;
        }
        return p0 && p1 && p2 && p3;
    }

    @Override // id.dana.cashier.fragment.BaseCashierRiskFragment, id.dana.cashier.fragment.BaseVBCashierFragment, id.dana.core.ui.BaseViewBindingFragment, androidx.fragment.app.Fragment
    public final void onDestroyView() {
        Window window;
        FragmentActivity activity = getActivity();
        if (activity != null && (window = activity.getWindow()) != null) {
            window.setSoftInputMode(32);
        }
        super.onDestroyView();
        this.NetworkUserEntityData$$ExternalSyntheticLambda1.clear();
    }

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0007¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"Lid/dana/cashier/fragment/CashierVerifyElementsChallengeFragment$Companion;", "", "Landroid/os/Bundle;", "p0", "Lid/dana/cashier/fragment/CashierVerifyElementsChallengeFragment;", "getAuthRequestContext", "(Landroid/os/Bundle;)Lid/dana/cashier/fragment/CashierVerifyElementsChallengeFragment;", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes4.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public static /* synthetic */ CashierVerifyElementsChallengeFragment PlaceComponentResult(CashierPayMethodModel.CardPayMethod cardPayMethod, PayResultModel payResultModel) {
            Intrinsics.checkNotNullParameter(cardPayMethod, "");
            Intrinsics.checkNotNullParameter(payResultModel, "");
            CashierVerifyElementsChallengeFragment cashierVerifyElementsChallengeFragment = new CashierVerifyElementsChallengeFragment();
            Bundle bundle = new Bundle();
            bundle.putParcelable(CashierKeyParams.CASHIER_PAY_METHOD, cardPayMethod);
            bundle.putParcelable(CashierKeyParams.PAY_RESULT_MODEL, payResultModel);
            bundle.putBoolean(CashierKeyParams.IS_CARD_REBINDING, false);
            cashierVerifyElementsChallengeFragment.setArguments(bundle);
            return cashierVerifyElementsChallengeFragment;
        }

        @JvmStatic
        public static CashierVerifyElementsChallengeFragment getAuthRequestContext(Bundle p0) {
            Intrinsics.checkNotNullParameter(p0, "");
            CashierVerifyElementsChallengeFragment cashierVerifyElementsChallengeFragment = new CashierVerifyElementsChallengeFragment();
            cashierVerifyElementsChallengeFragment.setArguments(p0);
            return cashierVerifyElementsChallengeFragment;
        }
    }

    public static /* synthetic */ Boolean PlaceComponentResult(CashierVerifyElementsChallengeFragment cashierVerifyElementsChallengeFragment, boolean z, Boolean bool, Boolean bool2, Boolean bool3) {
        Intrinsics.checkNotNullParameter(cashierVerifyElementsChallengeFragment, "");
        Intrinsics.checkNotNullParameter(bool, "");
        Intrinsics.checkNotNullParameter(bool2, "");
        Intrinsics.checkNotNullParameter(bool3, "");
        return Boolean.valueOf(cashierVerifyElementsChallengeFragment.BuiltInFictitiousFunctionClassFactory(z, bool.booleanValue(), bool2.booleanValue(), bool3.booleanValue()));
    }

    public static /* synthetic */ void BuiltInFictitiousFunctionClassFactory(CashierVerifyElementsChallengeFragment cashierVerifyElementsChallengeFragment, boolean z) {
        Intrinsics.checkNotNullParameter(cashierVerifyElementsChallengeFragment, "");
        VB vb = cashierVerifyElementsChallengeFragment.PlaceComponentResult;
        if (vb != 0) {
            DanaButtonSecondaryView danaButtonSecondaryView = ((FragmentCashierVerifyElementsChallengeBinding) vb).getAuthRequestContext;
            danaButtonSecondaryView.setEnabled(z);
            if (z) {
                danaButtonSecondaryView.setActiveButton(cashierVerifyElementsChallengeFragment.getString(R.string.btn_continue), null);
                return;
            } else {
                danaButtonSecondaryView.setDisabled(cashierVerifyElementsChallengeFragment.getString(R.string.btn_continue));
                return;
            }
        }
        throw new IllegalArgumentException("Required value was null.".toString());
    }

    public static final /* synthetic */ void BuiltInFictitiousFunctionClassFactory(CashierVerifyElementsChallengeFragment cashierVerifyElementsChallengeFragment, int i, int i2) {
        if (cashierVerifyElementsChallengeFragment.getActivity() instanceof PayActivity) {
            Bundle bundle = new Bundle();
            PayResultModel payResultModel = ((BaseCashierRiskFragment) cashierVerifyElementsChallengeFragment).BuiltInFictitiousFunctionClassFactory;
            String str = payResultModel != null ? payResultModel.getErrorConfigVersion : null;
            if (str == null) {
                str = "";
            }
            bundle.putString(CashierKeyParams.CASHIER_ORDER_ID, str);
            bundle.putParcelable(CashierKeyParams.CASHIER_PAY_METHOD, cashierVerifyElementsChallengeFragment.BuiltInFictitiousFunctionClassFactory);
            bundle.putInt("retrySendSeconds", i);
            bundle.putInt("otpCodeLength", i2);
            bundle.putParcelable(CashierKeyParams.PAY_RESULT_MODEL, ((BaseCashierRiskFragment) cashierVerifyElementsChallengeFragment).BuiltInFictitiousFunctionClassFactory);
            bundle.putBoolean(CashierKeyParams.IS_VERIFY_BANK_PHONE_OTP, true);
            String cleanAll = NumberUtils.getCleanAll(new MoneyViewModel(cashierVerifyElementsChallengeFragment.NetworkUserEntityData$$ExternalSyntheticLambda0, null, null, 6, null).PlaceComponentResult);
            if (cleanAll == null) {
                cleanAll = "0";
            }
            Long longOrNull = StringsKt.toLongOrNull(cleanAll);
            bundle.putLong("limitAmountDaily", longOrNull != null ? longOrNull.longValue() : 0L);
            bundle.putString("bankAccountNo", cashierVerifyElementsChallengeFragment.PlaceComponentResult);
            bundle.putString("phoneNumber", cashierVerifyElementsChallengeFragment.MyBillsEntityDataFactory);
            bundle.putString("ektp", cashierVerifyElementsChallengeFragment.scheduleImpl);
            bundle.putBoolean("isDoneCashierPay", cashierVerifyElementsChallengeFragment.C());
            if (cashierVerifyElementsChallengeFragment.C()) {
                FragmentActivity activity = cashierVerifyElementsChallengeFragment.getActivity();
                PayActivity payActivity = activity instanceof PayActivity ? (PayActivity) activity : null;
                if (payActivity != null) {
                    payActivity.setNeedExpandPayMethodOnBack(false);
                    payActivity.setNeedBackConfirmation(false);
                }
            }
            FragmentActivity activity2 = cashierVerifyElementsChallengeFragment.getActivity();
            PayActivity payActivity2 = activity2 instanceof PayActivity ? (PayActivity) activity2 : null;
            if (payActivity2 != null) {
                CashierOtpChallengeFragment.Companion companion = CashierOtpChallengeFragment.INSTANCE;
                PayActivity.addAndRemoveStackedFragment$default(payActivity2, CashierOtpChallengeFragment.Companion.KClassImpl$Data$declaredNonStaticMembers$2(bundle), false, false, 6, null);
            }
        }
    }

    public static final /* synthetic */ SendBankOtpModel getAuthRequestContext(CashierVerifyElementsChallengeFragment cashierVerifyElementsChallengeFragment, CashierPayMethodModel.CardPayMethod cardPayMethod) {
        String str;
        String str2;
        String str3;
        String str4;
        PayResultModel payResultModel = ((BaseCashierRiskFragment) cashierVerifyElementsChallengeFragment).BuiltInFictitiousFunctionClassFactory;
        String str5 = payResultModel != null ? payResultModel.getErrorConfigVersion : null;
        String str6 = "";
        String str7 = str5 == null ? "" : str5;
        CashierPayMethodModel.NewCardData newCardData = cardPayMethod.getAuthRequestContext;
        String str8 = ((newCardData == null || (str = newCardData.BuiltInFictitiousFunctionClassFactory) == null) && (str = cardPayMethod.KClassImpl$Data$declaredNonStaticMembers$2.scheduleImpl) == null) ? "" : str;
        CashierPayMethodModel.NewCardData newCardData2 = cardPayMethod.getAuthRequestContext;
        String str9 = ((newCardData2 == null || (str2 = newCardData2.MyBillsEntityDataFactory) == null) && (str2 = cardPayMethod.KClassImpl$Data$declaredNonStaticMembers$2.KClassImpl$Data$declaredNonStaticMembers$2) == null) ? "" : str2;
        CashierPayMethodModel.NewCardData newCardData3 = cardPayMethod.getAuthRequestContext;
        String str10 = ((newCardData3 == null || (str3 = newCardData3.getAuthRequestContext) == null) && (str3 = cardPayMethod.KClassImpl$Data$declaredNonStaticMembers$2.NetworkUserEntityData$$ExternalSyntheticLambda8) == null) ? "" : str3;
        CashierPayMethodModel.NewCardData newCardData4 = cardPayMethod.getAuthRequestContext;
        if (newCardData4 == null || (str4 = newCardData4.KClassImpl$Data$declaredNonStaticMembers$2) == null) {
            String str11 = cardPayMethod.KClassImpl$Data$declaredNonStaticMembers$2.isLayoutRequested;
            if (str11 != null) {
                str6 = str11;
            }
        } else {
            str6 = str4;
        }
        String str12 = str6;
        String cleanAll = NumberUtils.getCleanAll(new MoneyViewModel(cashierVerifyElementsChallengeFragment.NetworkUserEntityData$$ExternalSyntheticLambda0, null, null, 6, null).PlaceComponentResult);
        if (cleanAll == null) {
            cleanAll = "0";
        }
        Long longOrNull = StringsKt.toLongOrNull(cleanAll);
        String valueOf = String.valueOf(longOrNull != null ? longOrNull.longValue() : 0L);
        if (valueOf.length() == 0) {
            valueOf = null;
        }
        String str13 = valueOf;
        String str14 = cashierVerifyElementsChallengeFragment.PlaceComponentResult;
        if (str14.length() == 0) {
            str14 = null;
        }
        String str15 = str14;
        String str16 = cashierVerifyElementsChallengeFragment.MyBillsEntityDataFactory;
        if (str16.length() == 0) {
            str16 = null;
        }
        String str17 = str16;
        String str18 = cashierVerifyElementsChallengeFragment.scheduleImpl;
        return new SendBankOtpModel(str8, str7, str9, str17, str18.length() == 0 ? null : str18, null, null, null, str10, str12, str13, null, null, str15, 6368, null);
    }
}
