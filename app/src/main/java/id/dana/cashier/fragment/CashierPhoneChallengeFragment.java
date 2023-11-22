package id.dana.cashier.fragment;

import android.graphics.Rect;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.Window;
import androidx.appcompat.widget.AppCompatEditText;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Group;
import androidx.fragment.app.FragmentActivity;
import androidx.viewbinding.ViewBinding;
import com.alibaba.griver.image.photo.utils.DiskFormatter;
import com.iap.ac.android.biz.common.utils.log.LogConstants;
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
import id.dana.cashier.fragment.CashierOtpChallengeFragment;
import id.dana.cashier.model.CashierPayMethodModel;
import id.dana.cashier.model.CashierPayMethodModelKt;
import id.dana.cashier.model.PayResultModel;
import id.dana.cashier.model.SendBankOtpModel;
import id.dana.cashier.presenter.CashierRiskChallengePresenter;
import id.dana.cashier.utils.CashierKeyParams;
import id.dana.component.buttoncomponent.DanaButtonSecondaryView;
import id.dana.component.customtoastcomponent.CustomToast;
import id.dana.data.util.NumberUtils;
import id.dana.databinding.FragmentCashierVerifyEktpPhoneNumberBinding;
import id.dana.di.component.ApplicationComponent;
import id.dana.di.component.DaggerCashierComponent;
import id.dana.di.modules.CashierAnalyticModule;
import id.dana.di.modules.CashierModule;
import id.dana.di.modules.CashierRiskChallengeModule;
import id.dana.di.modules.TopUpAndPayModule;
import id.dana.extension.view.InputExtKt;
import id.dana.extension.view.ViewExtKt;
import id.dana.pay.PayActivity;
import id.dana.sendmoney.summary.SummaryActivity;
import id.dana.textbehavior.InvalidReason;
import id.dana.textbehavior.OnValidatedListener;
import id.dana.textbehavior.TextBehavior;
import id.dana.textbehavior.manipulate.NoZeroFirstManipulator;
import id.dana.textbehavior.validate.Validator;
import id.dana.utils.KeyboardHelper;
import id.dana.utils.SizeUtil;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0016\u0018\u0000 &2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001&B\u0007¢\u0006\u0004\b%\u0010\u000fJ\u0017\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0014¢\u0006\u0004\b\u0006\u0010\u0007J\u0017\u0010\u0006\u001a\u00020\t2\u0006\u0010\u0004\u001a\u00020\bH\u0004¢\u0006\u0004\b\u0006\u0010\nJ\u000f\u0010\f\u001a\u00020\u000bH\u0004¢\u0006\u0004\b\f\u0010\rJ\u000f\u0010\u000e\u001a\u00020\tH\u0014¢\u0006\u0004\b\u000e\u0010\u000fJ\u000f\u0010\u0010\u001a\u00020\tH\u0014¢\u0006\u0004\b\u0010\u0010\u000fJ\u000f\u0010\u0011\u001a\u00020\bH\u0004¢\u0006\u0004\b\u0011\u0010\u0012J\u000f\u0010\u0013\u001a\u00020\tH\u0002¢\u0006\u0004\b\u0013\u0010\u000fJ\u000f\u0010\u0014\u001a\u00020\tH\u0014¢\u0006\u0004\b\u0014\u0010\u000fJ\u000f\u0010\u0015\u001a\u00020\tH\u0014¢\u0006\u0004\b\u0015\u0010\u000fJ\u000f\u0010\u0016\u001a\u00020\tH\u0014¢\u0006\u0004\b\u0016\u0010\u000fJ\u0017\u0010\u0018\u001a\u00020\t2\u0006\u0010\u0004\u001a\u00020\u0017H\u0002¢\u0006\u0004\b\u0018\u0010\u0019J\u000f\u0010\u001a\u001a\u00020\tH\u0000¢\u0006\u0004\b\u001a\u0010\u000fJ\u000f\u0010\u001b\u001a\u00020\tH\u0014¢\u0006\u0004\b\u001b\u0010\u000fJ\u000f\u0010\u001c\u001a\u00020\tH\u0014¢\u0006\u0004\b\u001c\u0010\u000fJ\u0013\u0010\u001e\u001a\u00020\t*\u00020\u001dH\u0004¢\u0006\u0004\b\u001e\u0010\u001fR\u0012\u0010!\u001a\u00020 X\u0087\"¢\u0006\u0006\n\u0004\b!\u0010\"R\u0014\u0010\u0018\u001a\u00020\b8\u0002X\u0083\u0006¢\u0006\u0006\n\u0004\b#\u0010$"}, d2 = {"Lid/dana/cashier/fragment/CashierPhoneChallengeFragment;", "Lid/dana/cashier/fragment/BaseCashierRiskFragment;", "Lid/dana/databinding/FragmentCashierVerifyEktpPhoneNumberBinding;", "Lid/dana/cashier/model/CashierPayMethodModel$CardPayMethod;", "p0", "Lid/dana/cashier/model/SendBankOtpModel;", "MyBillsEntityDataFactory", "(Lid/dana/cashier/model/CashierPayMethodModel$CardPayMethod;)Lid/dana/cashier/model/SendBankOtpModel;", "", "", "(Z)V", "", SummaryActivity.DAYS, "()Ljava/lang/String;", "NetworkUserEntityData$$ExternalSyntheticLambda3", "()V", "NetworkUserEntityData$$ExternalSyntheticLambda4", "VerifyPinStateManager$executeRiskChallenge$2$2", "()Z", LogConstants.RESULT_FALSE, "whenAvailable", "C", "VerifyPinStateManager$executeRiskChallenge$2$1", "", "KClassImpl$Data$declaredNonStaticMembers$2", "(I)V", DiskFormatter.GB, DiskFormatter.B, "BottomSheetCardBindingView$watcherCardNumberView$1", "Landroidx/appcompat/widget/AppCompatEditText;", "getAuthRequestContext", "(Landroidx/appcompat/widget/AppCompatEditText;)V", "Lid/dana/cashier/presenter/CashierRiskChallengePresenter;", "cashierRiskChallengePresenter", "Lid/dana/cashier/presenter/CashierRiskChallengePresenter;", "initRecordTimeStamp", "Z", "<init>", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public class CashierPhoneChallengeFragment extends BaseCashierRiskFragment<FragmentCashierVerifyEktpPhoneNumberBinding> {

    /* renamed from: Companion  reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public Map<Integer, View> NetworkUserEntityData$$ExternalSyntheticLambda1 = new LinkedHashMap();
    @Inject
    public CashierRiskChallengePresenter cashierRiskChallengePresenter;

    /* renamed from: initRecordTimeStamp  reason: from kotlin metadata */
    private boolean KClassImpl$Data$declaredNonStaticMembers$2;

    @Override // id.dana.cashier.fragment.BaseCashierRiskFragment, id.dana.cashier.fragment.BaseVBCashierFragment, id.dana.core.ui.BaseViewBindingFragment
    public View getAuthRequestContext(int i) {
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
    public void getAuthRequestContext() {
        this.NetworkUserEntityData$$ExternalSyntheticLambda1.clear();
    }

    @Override // id.dana.cashier.fragment.BaseCashierRiskFragment, id.dana.cashier.fragment.BaseVBCashierFragment, id.dana.core.ui.BaseViewBindingFragment, androidx.fragment.app.Fragment
    public /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        getAuthRequestContext();
    }

    @Override // id.dana.core.ui.BaseViewBindingFragment
    public final /* synthetic */ ViewBinding MyBillsEntityDataFactory(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        Intrinsics.checkNotNullParameter(layoutInflater, "");
        FragmentCashierVerifyEktpPhoneNumberBinding PlaceComponentResult = FragmentCashierVerifyEktpPhoneNumberBinding.PlaceComponentResult(layoutInflater);
        Intrinsics.checkNotNullExpressionValue(PlaceComponentResult, "");
        return PlaceComponentResult;
    }

    @Override // id.dana.cashier.fragment.BaseVBCashierFragment
    protected final void NetworkUserEntityData$$ExternalSyntheticLambda3() {
        DaggerCashierComponent.Builder MyBillsEntityDataFactory = DaggerCashierComponent.MyBillsEntityDataFactory();
        MyBillsEntityDataFactory.BuiltInFictitiousFunctionClassFactory = (ApplicationComponent) Preconditions.getAuthRequestContext(initRecordTimeStamp());
        MyBillsEntityDataFactory.NetworkUserEntityData$$ExternalSyntheticLambda0 = (CashierRiskChallengeModule) Preconditions.getAuthRequestContext(new CashierRiskChallengeModule(new CashierViewListener() { // from class: id.dana.cashier.fragment.CashierPhoneChallengeFragment$cashierRiskChallengeModule$1
            @Override // id.dana.cashier.CashierViewListener, id.dana.cashier.CashierRiskChallengeContract.View
            public final void getAuthRequestContext(int i, int i2) {
                CashierPhoneChallengeFragment.getAuthRequestContext(CashierPhoneChallengeFragment.this, i, i2);
            }

            @Override // id.dana.cashier.CashierViewListener, id.dana.base.AbstractContractKt.AbstractView, id.dana.base.AbstractContract.AbstractView
            public final void showProgress() {
                KeyboardHelper.BuiltInFictitiousFunctionClassFactory(CashierPhoneChallengeFragment.this.getActivity());
                CashierPhoneChallengeFragment.this.SubSequence();
            }

            @Override // id.dana.cashier.CashierViewListener, id.dana.base.AbstractContractKt.AbstractView, id.dana.base.AbstractContract.AbstractView
            public final void dismissProgress() {
                CashierPhoneChallengeFragment.this.GetContactSyncConfig();
                CashierPhoneChallengeFragment.this.C();
            }

            @Override // id.dana.cashier.CashierViewListener, id.dana.base.AbstractContractKt.AbstractView, id.dana.base.AbstractContract.AbstractView
            public final void onError(String p0) {
                FragmentActivity activity = CashierPhoneChallengeFragment.this.getActivity();
                if (activity != null) {
                    CustomToast.BuiltInFictitiousFunctionClassFactory(activity, R.drawable.ic_warning_24, R.drawable.bg_rounded_toast_payment_auth, p0, 72, true, null);
                }
                CashierPhoneChallengeFragment.this.C();
            }

            @Override // id.dana.cashier.CashierViewListener, id.dana.cashier.CashierContract.View, id.dana.cashier.CashierRiskChallengeContract.View
            public final void MyBillsEntityDataFactory(String p0, String p1, Throwable p2) {
                Intrinsics.checkNotNullParameter(p0, "");
                Intrinsics.checkNotNullParameter(p1, "");
                Intrinsics.checkNotNullParameter(p2, "");
                CashierPhoneChallengeFragment.this.KClassImpl$Data$declaredNonStaticMembers$2(p0, p1, p2);
            }
        }));
        MyBillsEntityDataFactory.scheduleImpl = (CashierModule) Preconditions.getAuthRequestContext(new CashierModule(new CashierViewListener() { // from class: id.dana.cashier.fragment.CashierPhoneChallengeFragment$cashierModule$1
        }));
        MyBillsEntityDataFactory.getErrorConfigVersion = (TopUpAndPayModule) Preconditions.getAuthRequestContext(new TopUpAndPayModule(new CashierViewListener() { // from class: id.dana.cashier.fragment.CashierPhoneChallengeFragment$topUpAndPayModule$1
        }));
        MyBillsEntityDataFactory.MyBillsEntityDataFactory = (CashierAnalyticModule) Preconditions.getAuthRequestContext(new CashierAnalyticModule());
        MyBillsEntityDataFactory.PlaceComponentResult = (CashierCardBindingModule) Preconditions.getAuthRequestContext(new CashierCardBindingModule(new CashierViewListener() { // from class: id.dana.cashier.fragment.CashierPhoneChallengeFragment$cashierCardBindingModule$1
        }));
        MyBillsEntityDataFactory.moveToNextValue = (CashierPayLaterModule) Preconditions.getAuthRequestContext(new CashierPayLaterModule(new CashierPayLaterViewListener() { // from class: id.dana.cashier.fragment.CashierPhoneChallengeFragment$cashierPayLaterModule$1
        }));
        MyBillsEntityDataFactory.KClassImpl$Data$declaredNonStaticMembers$2 = (CashierAddOnModule) Preconditions.getAuthRequestContext(new CashierAddOnModule(new CashierAddOnViewListener() { // from class: id.dana.cashier.fragment.CashierPhoneChallengeFragment$cashierAddOnModule$1
        }));
        MyBillsEntityDataFactory.lookAheadTest = (CashierUserRelatedModule) Preconditions.getAuthRequestContext(new CashierUserRelatedModule(new CashierUserRelatedViewListener() { // from class: id.dana.cashier.fragment.CashierPhoneChallengeFragment$cashierUserRelatedModule$1
        }));
        MyBillsEntityDataFactory.getAuthRequestContext = (CashierHighlightModule) Preconditions.getAuthRequestContext(new CashierHighlightModule(new CashierHighlightViewListener() { // from class: id.dana.cashier.fragment.CashierPhoneChallengeFragment$cashierHighlightModule$1
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
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // id.dana.cashier.fragment.BaseVBCashierFragment
    public void NetworkUserEntityData$$ExternalSyntheticLambda4() {
        B();
        C();
        VerifyPinStateManager$executeRiskChallenge$2$1();
        VB vb = this.PlaceComponentResult;
        if (vb != 0) {
            DanaButtonSecondaryView danaButtonSecondaryView = ((FragmentCashierVerifyEktpPhoneNumberBinding) vb).BuiltInFictitiousFunctionClassFactory;
            Intrinsics.checkNotNullExpressionValue(danaButtonSecondaryView, "");
            ThrottledOnClickListenerKt.PlaceComponentResult(danaButtonSecondaryView, new Function1<View, Unit>() { // from class: id.dana.cashier.fragment.CashierPhoneChallengeFragment$onClickVerifyBankPhoneOtp$1
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public final /* bridge */ /* synthetic */ Unit invoke(View view) {
                    invoke2(view);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke  reason: avoid collision after fix types in other method */
                public final void invoke2(View view) {
                    CashierPayMethodModel.CardPayMethod MyBillsEntityDataFactory;
                    Intrinsics.checkNotNullParameter(view, "");
                    CashierPayMethodModel cashierPayMethodModel = ((BaseCashierRiskFragment) CashierPhoneChallengeFragment.this).NetworkUserEntityData$$ExternalSyntheticLambda0;
                    if (cashierPayMethodModel == null || (MyBillsEntityDataFactory = CashierPayMethodModelKt.MyBillsEntityDataFactory(cashierPayMethodModel)) == null) {
                        return;
                    }
                    CashierPhoneChallengeFragment cashierPhoneChallengeFragment = CashierPhoneChallengeFragment.this;
                    CashierRiskChallengePresenter cashierRiskChallengePresenter = cashierPhoneChallengeFragment.cashierRiskChallengePresenter;
                    if (cashierRiskChallengePresenter == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("");
                        cashierRiskChallengePresenter = null;
                    }
                    cashierRiskChallengePresenter.PlaceComponentResult(cashierPhoneChallengeFragment.MyBillsEntityDataFactory(MyBillsEntityDataFactory));
                }
            });
            return;
        }
        throw new IllegalArgumentException("Required value was null.".toString());
    }

    @Override // id.dana.cashier.fragment.BaseVBCashierFragment
    protected final void whenAvailable() {
        Bundle arguments = getArguments();
        if (arguments != null) {
            MyBillsEntityDataFactory((PayResultModel) arguments.getParcelable(CashierKeyParams.PAY_RESULT_MODEL));
            ((BaseCashierRiskFragment) this).NetworkUserEntityData$$ExternalSyntheticLambda0 = (CashierPayMethodModel) arguments.getParcelable(CashierKeyParams.CASHIER_PAY_METHOD);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void getAuthRequestContext(AppCompatEditText appCompatEditText) {
        Intrinsics.checkNotNullParameter(appCompatEditText, "");
        appCompatEditText.requestFocus();
        getErrorConfigVersion();
        G();
        F();
    }

    private void G() {
        Window window;
        FragmentActivity activity = getActivity();
        KeyboardHelper.PlaceComponentResult((activity == null || (window = activity.getWindow()) == null) ? null : window.getDecorView(), new KeyboardHelper.KeyboardVisibilityListener() { // from class: id.dana.cashier.fragment.CashierPhoneChallengeFragment$setupKeyboardListener$1
            @Override // id.dana.utils.KeyboardHelper.KeyboardVisibilityListener
            public final void KClassImpl$Data$declaredNonStaticMembers$2() {
                VB vb = CashierPhoneChallengeFragment.this.PlaceComponentResult;
                if (vb != 0) {
                    if (((FragmentCashierVerifyEktpPhoneNumberBinding) vb).PlaceComponentResult != null) {
                        CashierPhoneChallengeFragment cashierPhoneChallengeFragment = CashierPhoneChallengeFragment.this;
                        VB vb2 = cashierPhoneChallengeFragment.PlaceComponentResult;
                        if (vb2 != 0) {
                            AppCompatEditText appCompatEditText = ((FragmentCashierVerifyEktpPhoneNumberBinding) vb2).PlaceComponentResult;
                            Intrinsics.checkNotNullExpressionValue(appCompatEditText, "");
                            cashierPhoneChallengeFragment.KClassImpl$Data$declaredNonStaticMembers$2(KeyboardHelper.getAuthRequestContext(appCompatEditText));
                            return;
                        }
                        throw new IllegalArgumentException("Required value was null.".toString());
                    }
                    return;
                }
                throw new IllegalArgumentException("Required value was null.".toString());
            }

            @Override // id.dana.utils.KeyboardHelper.KeyboardVisibilityListener
            public final void MyBillsEntityDataFactory() {
                CashierPhoneChallengeFragment.this.KClassImpl$Data$declaredNonStaticMembers$2(0);
            }
        });
    }

    private final void F() {
        ViewTreeObserver viewTreeObserver;
        View decorView;
        FragmentActivity activity = getActivity();
        final View view = null;
        final Window window = activity != null ? activity.getWindow() : null;
        if (window != null && (decorView = window.getDecorView()) != null) {
            view = decorView.findViewById(16908290);
        }
        if (view == null || (viewTreeObserver = view.getViewTreeObserver()) == null) {
            return;
        }
        viewTreeObserver.addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: id.dana.cashier.fragment.CashierPhoneChallengeFragment$$ExternalSyntheticLambda0
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public final void onGlobalLayout() {
                CashierPhoneChallengeFragment.PlaceComponentResult(window, view, this);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final boolean VerifyPinStateManager$executeRiskChallenge$2$2() {
        if (this.KClassImpl$Data$declaredNonStaticMembers$2) {
            VB vb = this.PlaceComponentResult;
            if (vb != 0) {
                Editable text = ((FragmentCashierVerifyEktpPhoneNumberBinding) vb).PlaceComponentResult.getText();
                return (text != null ? text.length() : 0) > 0;
            }
            throw new IllegalArgumentException("Required value was null.".toString());
        }
        return false;
    }

    protected void BottomSheetCardBindingView$watcherCardNumberView$1() {
        MyBillsEntityDataFactory(VerifyPinStateManager$executeRiskChallenge$2$2());
    }

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\t\u0010\nJ\u001d\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\b"}, d2 = {"Lid/dana/cashier/fragment/CashierPhoneChallengeFragment$Companion;", "", "Lid/dana/cashier/model/CashierPayMethodModel$CardPayMethod;", "p0", "Lid/dana/cashier/model/PayResultModel;", "p1", "Lid/dana/cashier/fragment/CashierPhoneChallengeFragment;", "PlaceComponentResult", "(Lid/dana/cashier/model/CashierPayMethodModel$CardPayMethod;Lid/dana/cashier/model/PayResultModel;)Lid/dana/cashier/fragment/CashierPhoneChallengeFragment;", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes4.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public static CashierPhoneChallengeFragment PlaceComponentResult(CashierPayMethodModel.CardPayMethod p0, PayResultModel p1) {
            Intrinsics.checkNotNullParameter(p0, "");
            Intrinsics.checkNotNullParameter(p1, "");
            CashierPhoneChallengeFragment cashierPhoneChallengeFragment = new CashierPhoneChallengeFragment();
            Bundle bundle = new Bundle();
            bundle.putParcelable(CashierKeyParams.CASHIER_PAY_METHOD, p0);
            bundle.putParcelable(CashierKeyParams.PAY_RESULT_MODEL, p1);
            cashierPhoneChallengeFragment.setArguments(bundle);
            return cashierPhoneChallengeFragment;
        }
    }

    public static /* synthetic */ void PlaceComponentResult(Window window, View view, CashierPhoneChallengeFragment cashierPhoneChallengeFragment) {
        Intrinsics.checkNotNullParameter(cashierPhoneChallengeFragment, "");
        Rect rect = new Rect();
        View decorView = window != null ? window.getDecorView() : null;
        Intrinsics.checkNotNullExpressionValue(decorView, "");
        decorView.getWindowVisibleDisplayFrame(rect);
        cashierPhoneChallengeFragment.KClassImpl$Data$declaredNonStaticMembers$2(view.getHeight() - rect.bottom);
    }

    public static /* synthetic */ void PlaceComponentResult(CashierPhoneChallengeFragment cashierPhoneChallengeFragment) {
        Intrinsics.checkNotNullParameter(cashierPhoneChallengeFragment, "");
        VB vb = cashierPhoneChallengeFragment.PlaceComponentResult;
        if (vb != 0) {
            AppCompatEditText appCompatEditText = ((FragmentCashierVerifyEktpPhoneNumberBinding) vb).PlaceComponentResult;
            Intrinsics.checkNotNullExpressionValue(appCompatEditText, "");
            InputExtKt.MyBillsEntityDataFactory(appCompatEditText);
            return;
        }
        throw new IllegalArgumentException("Required value was null.".toString());
    }

    public static final /* synthetic */ void getAuthRequestContext(CashierPhoneChallengeFragment cashierPhoneChallengeFragment, int i, int i2) {
        if (cashierPhoneChallengeFragment.getActivity() instanceof PayActivity) {
            Bundle bundle = new Bundle();
            PayResultModel payResultModel = ((BaseCashierRiskFragment) cashierPhoneChallengeFragment).BuiltInFictitiousFunctionClassFactory;
            String str = payResultModel != null ? payResultModel.getErrorConfigVersion : null;
            if (str == null) {
                str = "";
            }
            bundle.putString(CashierKeyParams.CASHIER_ORDER_ID, str);
            bundle.putParcelable(CashierKeyParams.CASHIER_PAY_METHOD, ((BaseCashierRiskFragment) cashierPhoneChallengeFragment).NetworkUserEntityData$$ExternalSyntheticLambda0);
            bundle.putInt("retrySendSeconds", i);
            bundle.putInt("otpCodeLength", i2);
            bundle.putParcelable(CashierKeyParams.PAY_RESULT_MODEL, ((BaseCashierRiskFragment) cashierPhoneChallengeFragment).BuiltInFictitiousFunctionClassFactory);
            bundle.putBoolean(CashierKeyParams.IS_VERIFY_BANK_PHONE_OTP, true);
            VB vb = cashierPhoneChallengeFragment.PlaceComponentResult;
            if (vb != 0) {
                Editable text = ((FragmentCashierVerifyEktpPhoneNumberBinding) vb).getAuthRequestContext.getText();
                String obj = text != null ? text.toString() : null;
                if (obj == null) {
                    obj = "";
                }
                bundle.putString("ektp", obj);
                VB vb2 = cashierPhoneChallengeFragment.PlaceComponentResult;
                if (vb2 != 0) {
                    Editable text2 = ((FragmentCashierVerifyEktpPhoneNumberBinding) vb2).PlaceComponentResult.getText();
                    String obj2 = text2 != null ? text2.toString() : null;
                    bundle.putString("phoneNumber", obj2 != null ? obj2 : "");
                    FragmentActivity activity = cashierPhoneChallengeFragment.getActivity();
                    if (activity == null) {
                        throw new NullPointerException("null cannot be cast to non-null type id.dana.pay.PayActivity");
                    }
                    PayActivity payActivity = (PayActivity) activity;
                    CashierOtpChallengeFragment.Companion companion = CashierOtpChallengeFragment.INSTANCE;
                    PayActivity.addAndRemoveStackedFragment$default(payActivity, CashierOtpChallengeFragment.Companion.KClassImpl$Data$declaredNonStaticMembers$2(bundle), false, false, 6, null);
                    return;
                }
                throw new IllegalArgumentException("Required value was null.".toString());
            }
            throw new IllegalArgumentException("Required value was null.".toString());
        }
    }

    public static final /* synthetic */ void getAuthRequestContext(CashierPhoneChallengeFragment cashierPhoneChallengeFragment, boolean z) {
        cashierPhoneChallengeFragment.KClassImpl$Data$declaredNonStaticMembers$2 = z;
        cashierPhoneChallengeFragment.BottomSheetCardBindingView$watcherCardNumberView$1();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void KClassImpl$Data$declaredNonStaticMembers$2(int p0) {
        VB vb = this.PlaceComponentResult;
        if (vb != 0) {
            DanaButtonSecondaryView danaButtonSecondaryView = ((FragmentCashierVerifyEktpPhoneNumberBinding) vb).BuiltInFictitiousFunctionClassFactory;
            ViewGroup.LayoutParams layoutParams = danaButtonSecondaryView != null ? danaButtonSecondaryView.getLayoutParams() : null;
            ConstraintLayout.LayoutParams layoutParams2 = layoutParams instanceof ConstraintLayout.LayoutParams ? (ConstraintLayout.LayoutParams) layoutParams : null;
            if (layoutParams2 != null) {
                int authRequestContext = SizeUtil.getAuthRequestContext(32);
                int authRequestContext2 = SizeUtil.getAuthRequestContext(41);
                VB vb2 = this.PlaceComponentResult;
                if (vb2 != 0) {
                    DanaButtonSecondaryView danaButtonSecondaryView2 = ((FragmentCashierVerifyEktpPhoneNumberBinding) vb2).BuiltInFictitiousFunctionClassFactory;
                    if (danaButtonSecondaryView2 != null) {
                        Intrinsics.checkNotNullExpressionValue(danaButtonSecondaryView2, "");
                        ViewExtKt.PlaceComponentResult(danaButtonSecondaryView2, Integer.valueOf(authRequestContext), 0, Integer.valueOf(authRequestContext), Integer.valueOf(authRequestContext2 + p0));
                    }
                    VB vb3 = this.PlaceComponentResult;
                    if (vb3 != 0) {
                        DanaButtonSecondaryView danaButtonSecondaryView3 = ((FragmentCashierVerifyEktpPhoneNumberBinding) vb3).BuiltInFictitiousFunctionClassFactory;
                        if (danaButtonSecondaryView3 != null) {
                            danaButtonSecondaryView3.setLayoutParams(layoutParams2);
                            return;
                        }
                        return;
                    }
                    throw new IllegalArgumentException("Required value was null.".toString());
                }
                throw new IllegalArgumentException("Required value was null.".toString());
            }
            return;
        }
        throw new IllegalArgumentException("Required value was null.".toString());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public SendBankOtpModel MyBillsEntityDataFactory(CashierPayMethodModel.CardPayMethod p0) {
        String str;
        String str2;
        String str3;
        String str4;
        String str5 = "";
        Intrinsics.checkNotNullParameter(p0, "");
        PayResultModel payResultModel = ((BaseCashierRiskFragment) this).BuiltInFictitiousFunctionClassFactory;
        String str6 = payResultModel != null ? payResultModel.getErrorConfigVersion : null;
        String str7 = str6 == null ? "" : str6;
        String D = D();
        CashierPayMethodModel.NewCardData newCardData = p0.getAuthRequestContext;
        if (newCardData == null || (str = newCardData.MyBillsEntityDataFactory) == null) {
            str = p0.KClassImpl$Data$declaredNonStaticMembers$2.KClassImpl$Data$declaredNonStaticMembers$2;
        }
        String str8 = str;
        CashierPayMethodModel.NewCardData newCardData2 = p0.getAuthRequestContext;
        if (newCardData2 == null || (str2 = newCardData2.BuiltInFictitiousFunctionClassFactory) == null) {
            str2 = p0.KClassImpl$Data$declaredNonStaticMembers$2.scheduleImpl;
        }
        String str9 = str2;
        CashierPayMethodModel.NewCardData newCardData3 = p0.getAuthRequestContext;
        String str10 = ((newCardData3 == null || (str3 = newCardData3.getAuthRequestContext) == null) && (str3 = p0.KClassImpl$Data$declaredNonStaticMembers$2.NetworkUserEntityData$$ExternalSyntheticLambda8) == null) ? "" : str3;
        CashierPayMethodModel.NewCardData newCardData4 = p0.getAuthRequestContext;
        if (newCardData4 == null || (str4 = newCardData4.KClassImpl$Data$declaredNonStaticMembers$2) == null) {
            String str11 = p0.KClassImpl$Data$declaredNonStaticMembers$2.isLayoutRequested;
            if (str11 != null) {
                str5 = str11;
            }
        } else {
            str5 = str4;
        }
        return new SendBankOtpModel(str9, str7, str8, D, null, null, null, null, str10, str5, null, null, null, null, 15600, null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void MyBillsEntityDataFactory(boolean p0) {
        VB vb = this.PlaceComponentResult;
        if (vb != 0) {
            DanaButtonSecondaryView danaButtonSecondaryView = ((FragmentCashierVerifyEktpPhoneNumberBinding) vb).BuiltInFictitiousFunctionClassFactory;
            danaButtonSecondaryView.setEnabled(p0);
            if (p0) {
                danaButtonSecondaryView.setActiveButton(getString(R.string.intro_next), null);
                return;
            } else {
                danaButtonSecondaryView.setDisabled(getString(R.string.intro_next));
                return;
            }
        }
        throw new IllegalArgumentException("Required value was null.".toString());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final String D() {
        String str;
        String obj;
        VB vb = this.PlaceComponentResult;
        if (vb != 0) {
            Editable text = ((FragmentCashierVerifyEktpPhoneNumberBinding) vb).PlaceComponentResult.getText();
            if (text == null || (obj = text.toString()) == null) {
                str = null;
            } else {
                StringBuilder sb = new StringBuilder();
                sb.append('0');
                sb.append(obj);
                str = sb.toString();
            }
            return str == null ? "" : str;
        }
        throw new IllegalArgumentException("Required value was null.".toString());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void C() {
        VB vb = this.PlaceComponentResult;
        if (vb != 0) {
            AppCompatEditText appCompatEditText = ((FragmentCashierVerifyEktpPhoneNumberBinding) vb).PlaceComponentResult;
            Intrinsics.checkNotNullExpressionValue(appCompatEditText, "");
            Intrinsics.checkNotNullParameter(appCompatEditText, "");
            appCompatEditText.requestFocus();
            getErrorConfigVersion();
            G();
            F();
            return;
        }
        throw new IllegalArgumentException("Required value was null.".toString());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void VerifyPinStateManager$executeRiskChallenge$2$1() {
        VB vb = this.PlaceComponentResult;
        if (vb != 0) {
            AppCompatEditText appCompatEditText = ((FragmentCashierVerifyEktpPhoneNumberBinding) vb).PlaceComponentResult;
            TextBehavior.EditTextBehaviorBuilder PlaceComponentResult = TextBehavior.Builder.PlaceComponentResult(appCompatEditText);
            PlaceComponentResult.getAuthRequestContext = new NoZeroFirstManipulator();
            Validator validator = new Validator() { // from class: id.dana.cashier.fragment.CashierPhoneChallengeFragment$createPhoneNumberValidator$1
                @Override // id.dana.textbehavior.validate.Validator
                public final boolean MyBillsEntityDataFactory(String p0) {
                    int length = p0 != null ? p0.length() : 0;
                    if (length != 0) {
                        if (length < 9) {
                            return false;
                        }
                        StringBuilder sb = new StringBuilder();
                        sb.append('0');
                        sb.append(p0);
                        if (!NumberUtils.isValidIndoPhoneNumber(NumberUtils.getIndoPhoneNumber(sb.toString()))) {
                            return false;
                        }
                    }
                    return true;
                }

                @Override // id.dana.textbehavior.validate.Validator
                public final String KClassImpl$Data$declaredNonStaticMembers$2() {
                    String string = CashierPhoneChallengeFragment.this.getString(R.string.invalid_phone_number);
                    Intrinsics.checkNotNullExpressionValue(string, "");
                    return string;
                }
            };
            if (PlaceComponentResult.BuiltInFictitiousFunctionClassFactory == null) {
                PlaceComponentResult.BuiltInFictitiousFunctionClassFactory = new ArrayList();
            }
            PlaceComponentResult.BuiltInFictitiousFunctionClassFactory.add(validator);
            PlaceComponentResult.MyBillsEntityDataFactory = new OnValidatedListener() { // from class: id.dana.cashier.fragment.CashierPhoneChallengeFragment$createValidatedPhoneNumberListener$1
                @Override // id.dana.textbehavior.OnValidatedListener
                public final void getAuthRequestContext(String p0) {
                    CashierPhoneChallengeFragment.getAuthRequestContext(CashierPhoneChallengeFragment.this, true);
                    VB vb2 = CashierPhoneChallengeFragment.this.PlaceComponentResult;
                    if (vb2 != 0) {
                        AppCompatTextView appCompatTextView = ((FragmentCashierVerifyEktpPhoneNumberBinding) vb2).initRecordTimeStamp;
                        Intrinsics.checkNotNullExpressionValue(appCompatTextView, "");
                        appCompatTextView.setVisibility(4);
                        appCompatTextView.setText("");
                        return;
                    }
                    throw new IllegalArgumentException("Required value was null.".toString());
                }

                @Override // id.dana.textbehavior.OnValidatedListener
                public final void MyBillsEntityDataFactory(String p0, List<InvalidReason> p1) {
                    InvalidReason invalidReason;
                    Validator validator2;
                    CashierPhoneChallengeFragment.getAuthRequestContext(CashierPhoneChallengeFragment.this, false);
                    VB vb2 = CashierPhoneChallengeFragment.this.PlaceComponentResult;
                    if (vb2 != 0) {
                        AppCompatTextView appCompatTextView = ((FragmentCashierVerifyEktpPhoneNumberBinding) vb2).initRecordTimeStamp;
                        Intrinsics.checkNotNullExpressionValue(appCompatTextView, "");
                        appCompatTextView.setVisibility(0);
                        String KClassImpl$Data$declaredNonStaticMembers$2 = (p1 == null || (invalidReason = (InvalidReason) CollectionsKt.getOrNull(p1, 0)) == null || (validator2 = invalidReason.KClassImpl$Data$declaredNonStaticMembers$2) == null) ? null : validator2.KClassImpl$Data$declaredNonStaticMembers$2();
                        appCompatTextView.setText(KClassImpl$Data$declaredNonStaticMembers$2 != null ? KClassImpl$Data$declaredNonStaticMembers$2 : "");
                        return;
                    }
                    throw new IllegalArgumentException("Required value was null.".toString());
                }
            };
            PlaceComponentResult.KClassImpl$Data$declaredNonStaticMembers$2();
            Intrinsics.checkNotNullExpressionValue(appCompatEditText, "");
            appCompatEditText.addTextChangedListener(new TextWatcher() { // from class: id.dana.cashier.fragment.CashierPhoneChallengeFragment$setPhoneInputListener$lambda-4$$inlined$doAfterTextChanged$1
                @Override // android.text.TextWatcher
                public final void beforeTextChanged(CharSequence p0, int p1, int p2, int p3) {
                }

                @Override // android.text.TextWatcher
                public final void onTextChanged(CharSequence p0, int p1, int p2, int p3) {
                }

                @Override // android.text.TextWatcher
                public final void afterTextChanged(Editable p0) {
                    VB vb2 = CashierPhoneChallengeFragment.this.PlaceComponentResult;
                    if (vb2 != 0) {
                        AppCompatImageView appCompatImageView = ((FragmentCashierVerifyEktpPhoneNumberBinding) vb2).moveToNextValue;
                        if (appCompatImageView != null) {
                            Intrinsics.checkNotNullExpressionValue(appCompatImageView, "");
                            AppCompatImageView appCompatImageView2 = appCompatImageView;
                            VB vb3 = CashierPhoneChallengeFragment.this.PlaceComponentResult;
                            if (vb3 != 0) {
                                Editable text = ((FragmentCashierVerifyEktpPhoneNumberBinding) vb3).PlaceComponentResult.getText();
                                appCompatImageView2.setVisibility((text != null ? text.length() : 0) > 0 ? 0 : 8);
                                return;
                            }
                            throw new IllegalArgumentException("Required value was null.".toString());
                        }
                        return;
                    }
                    throw new IllegalArgumentException("Required value was null.".toString());
                }
            });
            VB vb2 = this.PlaceComponentResult;
            if (vb2 != 0) {
                ((FragmentCashierVerifyEktpPhoneNumberBinding) vb2).moveToNextValue.setOnClickListener(new View.OnClickListener() { // from class: id.dana.cashier.fragment.CashierPhoneChallengeFragment$$ExternalSyntheticLambda1
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        CashierPhoneChallengeFragment.PlaceComponentResult(CashierPhoneChallengeFragment.this);
                    }
                });
                return;
            }
            throw new IllegalArgumentException("Required value was null.".toString());
        }
        throw new IllegalArgumentException("Required value was null.".toString());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void B() {
        VB vb = this.PlaceComponentResult;
        if (vb != 0) {
            Group group = ((FragmentCashierVerifyEktpPhoneNumberBinding) vb).getErrorConfigVersion;
            Intrinsics.checkNotNullExpressionValue(group, "");
            group.setVisibility(0);
            VB vb2 = this.PlaceComponentResult;
            if (vb2 != 0) {
                AppCompatTextView appCompatTextView = ((FragmentCashierVerifyEktpPhoneNumberBinding) vb2).initRecordTimeStamp;
                Intrinsics.checkNotNullExpressionValue(appCompatTextView, "");
                appCompatTextView.setVisibility(4);
                return;
            }
            throw new IllegalArgumentException("Required value was null.".toString());
        }
        throw new IllegalArgumentException("Required value was null.".toString());
    }
}
