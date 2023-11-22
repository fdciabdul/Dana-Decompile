package id.dana.cashier.fragment;

import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Group;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.viewbinding.ViewBinding;
import com.jakewharton.rxbinding2.widget.RxTextView;
import dagger.internal.Preconditions;
import id.dana.R;
import id.dana.base.AbstractContract;
import id.dana.cashier.CashierAddOnModule;
import id.dana.cashier.CashierAddOnViewListener;
import id.dana.cashier.CashierCardBindingModule;
import id.dana.cashier.CashierContract;
import id.dana.cashier.CashierHighlightModule;
import id.dana.cashier.CashierHighlightViewListener;
import id.dana.cashier.CashierPayLaterModule;
import id.dana.cashier.CashierPayLaterViewListener;
import id.dana.cashier.CashierUserRelatedModule;
import id.dana.cashier.CashierUserRelatedViewListener;
import id.dana.cashier.CashierViewListener;
import id.dana.cashier.RiskParamsFactory;
import id.dana.cashier.fragment.PaymentResultFragment;
import id.dana.cashier.helper.CashierErrorState;
import id.dana.cashier.helper.CashierErrorType;
import id.dana.cashier.model.AttributeCashierPayModel;
import id.dana.cashier.model.CashierPayChannelModel;
import id.dana.cashier.model.CashierPayChannelModelKt;
import id.dana.cashier.model.CashierPayMethodModel;
import id.dana.cashier.model.CashierPayModel;
import id.dana.cashier.model.ExtendCashierModel;
import id.dana.cashier.model.OneKlikPhonesModel;
import id.dana.cashier.model.PayResultModel;
import id.dana.cashier.model.ProcessingMilestoneModel;
import id.dana.cashier.model.RiskVerificationMethodModel;
import id.dana.cashier.model.VoucherCashierModel;
import id.dana.cashier.utils.CashierKeyParams;
import id.dana.component.customtoastcomponent.CustomToast;
import id.dana.core.ui.richview.PinEntryEditText;
import id.dana.core.ui.util.LocaleUtil;
import id.dana.databinding.FragmentCashierCvvChallengeBinding;
import id.dana.di.component.ApplicationComponent;
import id.dana.di.component.DaggerCashierComponent;
import id.dana.di.modules.CashierAnalyticModule;
import id.dana.di.modules.CashierModule;
import id.dana.di.modules.CashierRiskChallengeModule;
import id.dana.di.modules.TopUpAndPayModule;
import id.dana.dialog.CVVInfoDialog;
import id.dana.extension.view.InputExtKt;
import id.dana.nearbyme.merchantdetail.model.MoneyViewModel;
import id.dana.pay.PayActivity;
import id.dana.utils.KeyboardHelper;
import id.dana.utils.LocationUtil;
import id.dana.utils.SizeUtil;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Predicate;
import java.text.NumberFormat;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmName;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 *2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001*B\u0007¢\u0006\u0004\b)\u0010\u0012J\u0017\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0014¢\u0006\u0004\b\u0006\u0010\u0007JC\u0010\u000f\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\b2\b\u0010\n\u001a\u0004\u0018\u00010\b2\u0006\u0010\u000b\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\rH\u0014¢\u0006\u0004\b\u000f\u0010\u0010J\u000f\u0010\u0011\u001a\u00020\u0005H\u0014¢\u0006\u0004\b\u0011\u0010\u0012J\u000f\u0010\u0013\u001a\u00020\u0005H\u0014¢\u0006\u0004\b\u0013\u0010\u0012J\u000f\u0010\u0014\u001a\u00020\u0005H\u0014¢\u0006\u0004\b\u0014\u0010\u0012J\u000f\u0010\u0015\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\u0015\u0010\u0012R\u0012\u0010\u0017\u001a\u00020\u0016X\u0087\"¢\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u0016\u0010\u0006\u001a\u00020\u00198\u0002@\u0002X\u0083.¢\u0006\u0006\n\u0004\b\u001a\u0010\u001bR*\u0010 \u001a\u00020\r2\u0006\u0010\u0004\u001a\u00020\r8\u0015@UX\u0095\u000e¢\u0006\u0012\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R\u0016\u0010\u000f\u001a\u00020\"8\u0002@\u0002X\u0083.¢\u0006\u0006\n\u0004\b#\u0010$R\u0016\u0010'\u001a\u00020\b8\u0002@\u0002X\u0083.¢\u0006\u0006\n\u0004\b%\u0010&R\u0016\u0010(\u001a\u00020\b8\u0002@\u0002X\u0083.¢\u0006\u0006\n\u0004\b\u0013\u0010&"}, d2 = {"Lid/dana/cashier/fragment/CashierCvvChallengeFragment;", "Lid/dana/cashier/fragment/BaseCashierRiskFragment;", "Lid/dana/databinding/FragmentCashierCvvChallengeBinding;", "Lid/dana/cashier/helper/CashierErrorState;", "p0", "", "PlaceComponentResult", "(Lid/dana/cashier/helper/CashierErrorState;)V", "", "p1", "p2", "p3", "p4", "", "p5", "getAuthRequestContext", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Z)V", "NetworkUserEntityData$$ExternalSyntheticLambda3", "()V", "NetworkUserEntityData$$ExternalSyntheticLambda4", "whenAvailable", "VerifyPinStateManager$executeRiskChallenge$2$1", "Lid/dana/cashier/CashierContract$Presenter;", "cashierPresenter", "Lid/dana/cashier/CashierContract$Presenter;", "Lid/dana/dialog/CVVInfoDialog;", "GetContactSyncConfig", "Lid/dana/dialog/CVVInfoDialog;", "NetworkUserEntityData$$ExternalSyntheticLambda1", "Z", "moveToNextValue", "()Z", "KClassImpl$Data$declaredNonStaticMembers$2", "(Z)V", "Lid/dana/cashier/model/CashierPayMethodModel;", "NetworkUserEntityData$$ExternalSyntheticLambda7", "Lid/dana/cashier/model/CashierPayMethodModel;", "isLayoutRequested", "Ljava/lang/String;", "MyBillsEntityDataFactory", "BuiltInFictitiousFunctionClassFactory", "<init>", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class CashierCvvChallengeFragment extends BaseCashierRiskFragment<FragmentCashierCvvChallengeBinding> {

    /* renamed from: Companion  reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: GetContactSyncConfig  reason: from kotlin metadata */
    private CVVInfoDialog PlaceComponentResult;

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda1  reason: from kotlin metadata */
    private boolean KClassImpl$Data$declaredNonStaticMembers$2;

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda4  reason: from kotlin metadata */
    private String BuiltInFictitiousFunctionClassFactory;

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda7  reason: from kotlin metadata */
    private CashierPayMethodModel getAuthRequestContext;
    @Inject
    public CashierContract.Presenter cashierPresenter;
    public Map<Integer, View> initRecordTimeStamp = new LinkedHashMap();

    /* renamed from: isLayoutRequested  reason: from kotlin metadata */
    private String MyBillsEntityDataFactory;

    public static /* synthetic */ void BottomSheetCardBindingView$watcherCardNumberView$1() {
    }

    @Override // id.dana.cashier.fragment.BaseCashierRiskFragment, id.dana.cashier.fragment.BaseVBCashierFragment, id.dana.core.ui.BaseViewBindingFragment
    public final View getAuthRequestContext(int i) {
        View findViewById;
        Map<Integer, View> map = this.initRecordTimeStamp;
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
        this.initRecordTimeStamp.clear();
    }

    @Override // id.dana.core.ui.BaseViewBindingFragment
    public final /* synthetic */ ViewBinding MyBillsEntityDataFactory(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        Intrinsics.checkNotNullParameter(layoutInflater, "");
        FragmentCashierCvvChallengeBinding PlaceComponentResult = FragmentCashierCvvChallengeBinding.PlaceComponentResult(layoutInflater);
        Intrinsics.checkNotNullExpressionValue(PlaceComponentResult, "");
        return PlaceComponentResult;
    }

    @Override // id.dana.cashier.fragment.BaseCashierRiskFragment
    @JvmName(name = "moveToNextValue")
    /* renamed from: moveToNextValue  reason: from getter */
    protected final boolean getKClassImpl$Data$declaredNonStaticMembers$2() {
        return this.KClassImpl$Data$declaredNonStaticMembers$2;
    }

    @Override // id.dana.cashier.fragment.BaseCashierRiskFragment
    @JvmName(name = "KClassImpl$Data$declaredNonStaticMembers$2")
    protected final void KClassImpl$Data$declaredNonStaticMembers$2(boolean z) {
        this.KClassImpl$Data$declaredNonStaticMembers$2 = z;
        if (!getKClassImpl$Data$declaredNonStaticMembers$2() || ((BaseCashierRiskFragment) this).BuiltInFictitiousFunctionClassFactory == null) {
            return;
        }
        NetworkUserEntityData$$ExternalSyntheticLambda0();
        VB vb = this.PlaceComponentResult;
        if (vb != 0) {
            Group group = ((FragmentCashierCvvChallengeBinding) vb).getErrorConfigVersion.BuiltInFictitiousFunctionClassFactory;
            Intrinsics.checkNotNullExpressionValue(group, "");
            group.setVisibility(0);
            return;
        }
        throw new IllegalArgumentException("Required value was null.".toString());
    }

    @Override // id.dana.cashier.fragment.BaseVBCashierFragment
    protected final void NetworkUserEntityData$$ExternalSyntheticLambda3() {
        DaggerCashierComponent.Builder MyBillsEntityDataFactory = DaggerCashierComponent.MyBillsEntityDataFactory();
        MyBillsEntityDataFactory.BuiltInFictitiousFunctionClassFactory = (ApplicationComponent) Preconditions.getAuthRequestContext(initRecordTimeStamp());
        MyBillsEntityDataFactory.scheduleImpl = (CashierModule) Preconditions.getAuthRequestContext(new CashierModule(new CashierViewListener() { // from class: id.dana.cashier.fragment.CashierCvvChallengeFragment$cashierModule$1
            @Override // id.dana.cashier.CashierViewListener, id.dana.cashier.CashierContract.View
            public final void getAuthRequestContext(CashierErrorState p0) {
                Intrinsics.checkNotNullParameter(p0, "");
                CashierCvvChallengeFragment.this.PlaceComponentResult(p0);
            }

            @Override // id.dana.cashier.CashierViewListener, id.dana.cashier.CashierContract.View, id.dana.cashier.TopUpAndPayContract.View
            public final void BuiltInFictitiousFunctionClassFactory(CashierErrorState p0) {
                Intrinsics.checkNotNullParameter(p0, "");
                CashierCvvChallengeFragment.this.PlaceComponentResult(p0);
            }

            @Override // id.dana.cashier.CashierViewListener, id.dana.base.AbstractContractKt.AbstractView, id.dana.base.AbstractContract.AbstractView
            public final void showProgress() {
                CashierCvvChallengeFragment.this.SubSequence();
            }

            @Override // id.dana.cashier.CashierViewListener, id.dana.base.AbstractContractKt.AbstractView, id.dana.base.AbstractContract.AbstractView
            public final void dismissProgress() {
                CashierCvvChallengeFragment.this.GetContactSyncConfig();
            }

            @Override // id.dana.cashier.CashierViewListener, id.dana.base.AbstractContractKt.AbstractView, id.dana.base.AbstractContract.AbstractView
            public final void onError(String p0) {
                CashierCvvChallengeFragment cashierCvvChallengeFragment = CashierCvvChallengeFragment.this;
                if (p0 == null) {
                    p0 = "";
                }
                FragmentActivity activity = cashierCvvChallengeFragment.getActivity();
                if (activity != null) {
                    CustomToast.BuiltInFictitiousFunctionClassFactory(activity, R.drawable.ic_warning_24, R.drawable.bg_rounded_toast_payment_auth, p0, 72, true, null);
                }
                VB vb = CashierCvvChallengeFragment.this.PlaceComponentResult;
                if (vb != 0) {
                    PinEntryEditText pinEntryEditText = ((FragmentCashierCvvChallengeBinding) vb).BuiltInFictitiousFunctionClassFactory;
                    Intrinsics.checkNotNullExpressionValue(pinEntryEditText, "");
                    InputExtKt.MyBillsEntityDataFactory(pinEntryEditText);
                    CashierCvvChallengeFragment.KClassImpl$Data$declaredNonStaticMembers$2(CashierCvvChallengeFragment.this);
                    return;
                }
                throw new IllegalArgumentException("Required value was null.".toString());
            }

            @Override // id.dana.cashier.CashierViewListener, id.dana.cashier.CashierContract.View, id.dana.cashier.TopUpAndPayContract.View
            public final boolean KClassImpl$Data$declaredNonStaticMembers$2() {
                return LocationUtil.getAuthRequestContext(CashierCvvChallengeFragment.this.getContext());
            }

            @Override // id.dana.cashier.CashierViewListener, id.dana.cashier.CashierContract.View
            public final void KClassImpl$Data$declaredNonStaticMembers$2(CashierPayModel p0) {
                Intrinsics.checkNotNullParameter(p0, "");
                if (Intrinsics.areEqual(p0.BuiltInFictitiousFunctionClassFactory, Boolean.TRUE)) {
                    CashierContract.Presenter presenter = CashierCvvChallengeFragment.this.cashierPresenter;
                    if (presenter == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("");
                        presenter = null;
                    }
                    CashierContract.Presenter presenter2 = presenter;
                    String str = p0.MyBillsEntityDataFactory;
                    presenter2.KClassImpl$Data$declaredNonStaticMembers$2(str == null ? "" : str, null, (r12 & 4) != 0 ? false : false, (r12 & 8) != 0 ? null : null, (r12 & 16) != 0 ? null : null);
                    return;
                }
                VB vb = CashierCvvChallengeFragment.this.PlaceComponentResult;
                if (vb != 0) {
                    PinEntryEditText pinEntryEditText = ((FragmentCashierCvvChallengeBinding) vb).BuiltInFictitiousFunctionClassFactory;
                    Intrinsics.checkNotNullExpressionValue(pinEntryEditText, "");
                    InputExtKt.MyBillsEntityDataFactory(pinEntryEditText);
                    CashierCvvChallengeFragment cashierCvvChallengeFragment = CashierCvvChallengeFragment.this;
                    String str2 = p0.getAuthRequestContext;
                    String str3 = str2 != null ? str2 : "";
                    FragmentActivity activity = cashierCvvChallengeFragment.getActivity();
                    if (activity != null) {
                        CustomToast.BuiltInFictitiousFunctionClassFactory(activity, R.drawable.ic_warning_24, R.drawable.bg_rounded_toast_payment_auth, str3, 72, true, null);
                        return;
                    }
                    return;
                }
                throw new IllegalArgumentException("Required value was null.".toString());
            }

            @Override // id.dana.cashier.CashierViewListener, id.dana.cashier.CashierContract.View, id.dana.cashier.TopUpAndPayContract.View
            public final void MyBillsEntityDataFactory(CashierPayModel p0) {
                CashierPayChannelModel cashierPayChannelModel;
                ExtendCashierModel extendCashierModel;
                String str;
                String format;
                Intrinsics.checkNotNullParameter(p0, "");
                if (Intrinsics.areEqual(p0.BuiltInFictitiousFunctionClassFactory, Boolean.TRUE)) {
                    AttributeCashierPayModel attributeCashierPayModel = p0.KClassImpl$Data$declaredNonStaticMembers$2;
                    if (attributeCashierPayModel != null) {
                        CashierCvvChallengeFragment cashierCvvChallengeFragment = CashierCvvChallengeFragment.this;
                        CashierCvvChallengeFragment.MyBillsEntityDataFactory(cashierCvvChallengeFragment);
                        PayResultModel payResultModel = ((BaseCashierRiskFragment) cashierCvvChallengeFragment).BuiltInFictitiousFunctionClassFactory;
                        if (payResultModel != null) {
                            String str2 = attributeCashierPayModel.SubSequence;
                            if (str2 == null) {
                                str2 = "";
                            }
                            Intrinsics.checkNotNullParameter(str2, "");
                            payResultModel.PrepareContext = str2;
                        }
                        PayResultModel payResultModel2 = ((BaseCashierRiskFragment) cashierCvvChallengeFragment).BuiltInFictitiousFunctionClassFactory;
                        if (payResultModel2 != null) {
                            MoneyViewModel moneyViewModel = attributeCashierPayModel.X;
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
                            payResultModel2.AppCompatEmojiTextHelper = str;
                        }
                        PayResultModel payResultModel3 = ((BaseCashierRiskFragment) cashierCvvChallengeFragment).BuiltInFictitiousFunctionClassFactory;
                        if (payResultModel3 != null) {
                            String str3 = attributeCashierPayModel.com.alibaba.griver.image.photo.utils.DiskFormatter.GB java.lang.String;
                            if (str3 == null) {
                                str3 = "";
                            }
                            Intrinsics.checkNotNullParameter(str3, "");
                            payResultModel3.com.alibaba.griver.image.photo.utils.DiskFormatter.B java.lang.String = str3;
                        }
                        PayResultModel payResultModel4 = ((BaseCashierRiskFragment) cashierCvvChallengeFragment).BuiltInFictitiousFunctionClassFactory;
                        if (payResultModel4 != null) {
                            List<CashierPayChannelModel> list = attributeCashierPayModel.I;
                            String str4 = (list == null || (cashierPayChannelModel = (CashierPayChannelModel) CollectionsKt.getOrNull(list, 0)) == null || (extendCashierModel = cashierPayChannelModel.newProxyInstance) == null) ? null : extendCashierModel.NetworkUserEntityData$$ExternalSyntheticLambda0;
                            if (str4 == null) {
                                str4 = "";
                            }
                            Intrinsics.checkNotNullParameter(str4, "");
                            payResultModel4.A = str4;
                        }
                        PayResultModel payResultModel5 = ((BaseCashierRiskFragment) cashierCvvChallengeFragment).BuiltInFictitiousFunctionClassFactory;
                        if (payResultModel5 != null) {
                            String str5 = attributeCashierPayModel.KClassImpl$Data$declaredNonStaticMembers$2;
                            if (str5 == null) {
                                str5 = "";
                            }
                            Intrinsics.checkNotNullParameter(str5, "");
                            payResultModel5.BuiltInFictitiousFunctionClassFactory = str5;
                        }
                        PayResultModel payResultModel6 = ((BaseCashierRiskFragment) cashierCvvChallengeFragment).BuiltInFictitiousFunctionClassFactory;
                        if (payResultModel6 != null) {
                            String str6 = attributeCashierPayModel.C;
                            if (str6 == null) {
                                str6 = "";
                            }
                            Intrinsics.checkNotNullParameter(str6, "");
                            payResultModel6.NetworkUserEntityData$$ExternalSyntheticLambda4 = str6;
                        }
                        PayResultModel payResultModel7 = ((BaseCashierRiskFragment) cashierCvvChallengeFragment).BuiltInFictitiousFunctionClassFactory;
                        if (payResultModel7 != null) {
                            String str7 = attributeCashierPayModel.E;
                            if (str7 == null) {
                                str7 = "";
                            }
                            payResultModel7.L = str7;
                        }
                        PayResultModel payResultModel8 = ((BaseCashierRiskFragment) cashierCvvChallengeFragment).BuiltInFictitiousFunctionClassFactory;
                        if (payResultModel8 != null) {
                            payResultModel8.getAuthRequestContext = attributeCashierPayModel.getAuthRequestContext();
                        }
                        PayResultModel payResultModel9 = ((BaseCashierRiskFragment) cashierCvvChallengeFragment).BuiltInFictitiousFunctionClassFactory;
                        if (payResultModel9 != null) {
                            payResultModel9.moveToNextValue = attributeCashierPayModel.NetworkUserEntityData$$ExternalSyntheticLambda0;
                        }
                        PayResultModel payResultModel10 = ((BaseCashierRiskFragment) cashierCvvChallengeFragment).BuiltInFictitiousFunctionClassFactory;
                        if (payResultModel10 != null) {
                            String str8 = attributeCashierPayModel.BottomSheetCardBindingView$watcherCardNumberView$1;
                            if (str8 == null) {
                                str8 = "";
                            }
                            Intrinsics.checkNotNullParameter(str8, "");
                            payResultModel10.readMicros = str8;
                        }
                        PayResultModel payResultModel11 = ((BaseCashierRiskFragment) cashierCvvChallengeFragment).BuiltInFictitiousFunctionClassFactory;
                        if (payResultModel11 != null) {
                            payResultModel11.isLayoutRequested = attributeCashierPayModel.NetworkUserEntityData$$ExternalSyntheticLambda8;
                        }
                        PayResultModel payResultModel12 = ((BaseCashierRiskFragment) cashierCvvChallengeFragment).BuiltInFictitiousFunctionClassFactory;
                        if (payResultModel12 != null) {
                            ProcessingMilestoneModel processingMilestoneModel = attributeCashierPayModel.L;
                            payResultModel12.getCallingPid = processingMilestoneModel != null ? processingMilestoneModel.PlaceComponentResult : null;
                        }
                        PayResultModel payResultModel13 = ((BaseCashierRiskFragment) cashierCvvChallengeFragment).BuiltInFictitiousFunctionClassFactory;
                        if (payResultModel13 != null) {
                            String str9 = attributeCashierPayModel.id.dana.sendmoney.summary.SummaryActivity.DAYS java.lang.String;
                            if (str9 == null) {
                                str9 = "";
                            }
                            payResultModel13.VerifyPinStateManager$executeRiskChallenge$2$1 = str9;
                        }
                        PayResultModel payResultModel14 = ((BaseCashierRiskFragment) cashierCvvChallengeFragment).BuiltInFictitiousFunctionClassFactory;
                        if (payResultModel14 != null) {
                            payResultModel14.getSupportButtonTintMode = attributeCashierPayModel.getOnBoardingScenario;
                        }
                        PayResultModel payResultModel15 = ((BaseCashierRiskFragment) cashierCvvChallengeFragment).BuiltInFictitiousFunctionClassFactory;
                        if (payResultModel15 != null) {
                            String str10 = attributeCashierPayModel.SummaryVoucherView$$ExternalSyntheticLambda0;
                            if (str10 == null) {
                                str10 = "";
                            }
                            payResultModel15.VerifyPinStateManager$executeRiskChallenge$2$2 = str10;
                        }
                        PayResultModel payResultModel16 = ((BaseCashierRiskFragment) cashierCvvChallengeFragment).BuiltInFictitiousFunctionClassFactory;
                        if (payResultModel16 != null) {
                            String str11 = attributeCashierPayModel.GetContactSyncConfig;
                            if (str11 == null) {
                                str11 = "";
                            }
                            payResultModel16.NetworkUserEntityData$$ExternalSyntheticLambda2 = str11;
                        }
                        PayResultModel payResultModel17 = ((BaseCashierRiskFragment) cashierCvvChallengeFragment).BuiltInFictitiousFunctionClassFactory;
                        if (payResultModel17 != null) {
                            String str12 = attributeCashierPayModel.getSupportButtonTintMode;
                            if (str12 == null) {
                                str12 = "";
                            }
                            payResultModel17.FragmentBottomSheetPaymentSettingBinding = str12;
                        }
                        PayResultModel payResultModel18 = ((BaseCashierRiskFragment) cashierCvvChallengeFragment).BuiltInFictitiousFunctionClassFactory;
                        if (payResultModel18 != null) {
                            String str13 = attributeCashierPayModel.A;
                            if (str13 == null) {
                                str13 = "";
                            }
                            payResultModel18.NetworkUserEntityData$$ExternalSyntheticLambda3 = str13;
                        }
                        PayResultModel payResultModel19 = ((BaseCashierRiskFragment) cashierCvvChallengeFragment).BuiltInFictitiousFunctionClassFactory;
                        if (payResultModel19 != null) {
                            String str14 = attributeCashierPayModel.NetworkUserEntityData$$ExternalSyntheticLambda6;
                            if (str14 == null) {
                                str14 = "";
                            }
                            payResultModel19.NetworkUserEntityData$$ExternalSyntheticLambda8 = str14;
                        }
                        PayResultModel payResultModel20 = ((BaseCashierRiskFragment) cashierCvvChallengeFragment).BuiltInFictitiousFunctionClassFactory;
                        if (payResultModel20 != null) {
                            payResultModel20.getOnBoardingScenario = attributeCashierPayModel.J;
                        }
                        PayResultModel payResultModel21 = ((BaseCashierRiskFragment) cashierCvvChallengeFragment).BuiltInFictitiousFunctionClassFactory;
                        if (payResultModel21 != null) {
                            payResultModel21.K = attributeCashierPayModel.V;
                        }
                        PayResultModel payResultModel22 = ((BaseCashierRiskFragment) cashierCvvChallengeFragment).BuiltInFictitiousFunctionClassFactory;
                        if (payResultModel22 != null) {
                            String BuiltInFictitiousFunctionClassFactory = attributeCashierPayModel.BuiltInFictitiousFunctionClassFactory();
                            Intrinsics.checkNotNullParameter(BuiltInFictitiousFunctionClassFactory, "");
                            payResultModel22.NetworkUserEntityData$$ExternalSyntheticLambda1 = BuiltInFictitiousFunctionClassFactory;
                        }
                        PayResultModel payResultModel23 = ((BaseCashierRiskFragment) cashierCvvChallengeFragment).BuiltInFictitiousFunctionClassFactory;
                        if (payResultModel23 != null) {
                            Boolean bool = attributeCashierPayModel.VerifyPinStateManager$executeRiskChallenge$2$1;
                            payResultModel23.NetworkUserEntityData$$ExternalSyntheticLambda6 = bool != null ? bool.booleanValue() : false;
                        }
                        PayResultModel payResultModel24 = ((BaseCashierRiskFragment) cashierCvvChallengeFragment).BuiltInFictitiousFunctionClassFactory;
                        if (payResultModel24 != null) {
                            Boolean bool2 = attributeCashierPayModel.NetworkUserEntityData$$ExternalSyntheticLambda4;
                            payResultModel24.newProxyInstance = bool2 != null ? bool2.booleanValue() : false;
                        }
                        PayResultModel payResultModel25 = ((BaseCashierRiskFragment) cashierCvvChallengeFragment).BuiltInFictitiousFunctionClassFactory;
                        if (payResultModel25 != null) {
                            payResultModel25.C = p0.KClassImpl$Data$declaredNonStaticMembers$2.I;
                        }
                        PayResultModel payResultModel26 = ((BaseCashierRiskFragment) cashierCvvChallengeFragment).BuiltInFictitiousFunctionClassFactory;
                        if (payResultModel26 != null) {
                            payResultModel26.id.dana.sendmoney.summary.SummaryActivity.HOURS java.lang.String = p0.KClassImpl$Data$declaredNonStaticMembers$2.W;
                        }
                        PayResultModel payResultModel27 = ((BaseCashierRiskFragment) cashierCvvChallengeFragment).BuiltInFictitiousFunctionClassFactory;
                        if (payResultModel27 != null) {
                            payResultModel27.whenAvailable = p0.KClassImpl$Data$declaredNonStaticMembers$2.getValueOfTouchPositionAbsolute;
                        }
                        PayResultModel payResultModel28 = ((BaseCashierRiskFragment) cashierCvvChallengeFragment).BuiltInFictitiousFunctionClassFactory;
                        if (payResultModel28 != null) {
                            payResultModel28.MyBillsEntityDataFactory = attributeCashierPayModel.BuiltInFictitiousFunctionClassFactory;
                        }
                        if (attributeCashierPayModel.KClassImpl$Data$declaredNonStaticMembers$2()) {
                            CashierCvvChallengeFragment.getAuthRequestContext(cashierCvvChallengeFragment, attributeCashierPayModel);
                            return;
                        }
                        CashierCvvChallengeFragment cashierCvvChallengeFragment2 = cashierCvvChallengeFragment;
                        String str15 = attributeCashierPayModel.O;
                        String str16 = str15 == null ? "" : str15;
                        String str17 = attributeCashierPayModel.getAuthRequestContext;
                        String str18 = attributeCashierPayModel.flip;
                        BaseVBCashierFragment.getAuthRequestContext(cashierCvvChallengeFragment2, str16, null, null, str17, str18 == null ? "" : str18, CashierPayChannelModelKt.KClassImpl$Data$declaredNonStaticMembers$2(attributeCashierPayModel.I), 6);
                        return;
                    }
                    return;
                }
                VB vb = CashierCvvChallengeFragment.this.PlaceComponentResult;
                if (vb != 0) {
                    PinEntryEditText pinEntryEditText = ((FragmentCashierCvvChallengeBinding) vb).BuiltInFictitiousFunctionClassFactory;
                    Intrinsics.checkNotNullExpressionValue(pinEntryEditText, "");
                    InputExtKt.MyBillsEntityDataFactory(pinEntryEditText);
                    CashierCvvChallengeFragment cashierCvvChallengeFragment3 = CashierCvvChallengeFragment.this;
                    String str19 = p0.getAuthRequestContext;
                    String str20 = str19 != null ? str19 : "";
                    FragmentActivity activity = cashierCvvChallengeFragment3.getActivity();
                    if (activity != null) {
                        CustomToast.BuiltInFictitiousFunctionClassFactory(activity, R.drawable.ic_warning_24, R.drawable.bg_rounded_toast_payment_auth, str20, 72, true, null);
                        return;
                    }
                    return;
                }
                throw new IllegalArgumentException("Required value was null.".toString());
            }
        }));
        MyBillsEntityDataFactory.NetworkUserEntityData$$ExternalSyntheticLambda0 = (CashierRiskChallengeModule) Preconditions.getAuthRequestContext(new CashierRiskChallengeModule(new CashierViewListener() { // from class: id.dana.cashier.fragment.CashierCvvChallengeFragment$cashierRiskChallengeModule$1
            @Override // id.dana.cashier.CashierViewListener, id.dana.cashier.CashierContract.View, id.dana.cashier.TopUpAndPayContract.View
            public final boolean KClassImpl$Data$declaredNonStaticMembers$2() {
                return LocationUtil.getAuthRequestContext(CashierCvvChallengeFragment.this.getContext());
            }
        }));
        MyBillsEntityDataFactory.getErrorConfigVersion = (TopUpAndPayModule) Preconditions.getAuthRequestContext(new TopUpAndPayModule(new CashierViewListener() { // from class: id.dana.cashier.fragment.CashierCvvChallengeFragment$topUpAndPayModule$1
        }));
        MyBillsEntityDataFactory.MyBillsEntityDataFactory = (CashierAnalyticModule) Preconditions.getAuthRequestContext(new CashierAnalyticModule());
        MyBillsEntityDataFactory.PlaceComponentResult = (CashierCardBindingModule) Preconditions.getAuthRequestContext(new CashierCardBindingModule(new CashierViewListener() { // from class: id.dana.cashier.fragment.CashierCvvChallengeFragment$cashierCardBindingModule$1
        }));
        MyBillsEntityDataFactory.moveToNextValue = (CashierPayLaterModule) Preconditions.getAuthRequestContext(new CashierPayLaterModule(new CashierPayLaterViewListener() { // from class: id.dana.cashier.fragment.CashierCvvChallengeFragment$cashierPayLaterModule$1
        }));
        MyBillsEntityDataFactory.KClassImpl$Data$declaredNonStaticMembers$2 = (CashierAddOnModule) Preconditions.getAuthRequestContext(new CashierAddOnModule(new CashierAddOnViewListener() { // from class: id.dana.cashier.fragment.CashierCvvChallengeFragment$cashierAddOnModule$1
        }));
        MyBillsEntityDataFactory.lookAheadTest = (CashierUserRelatedModule) Preconditions.getAuthRequestContext(new CashierUserRelatedModule(new CashierUserRelatedViewListener() { // from class: id.dana.cashier.fragment.CashierCvvChallengeFragment$cashierUserRelatedModule$1
        }));
        MyBillsEntityDataFactory.getAuthRequestContext = (CashierHighlightModule) Preconditions.getAuthRequestContext(new CashierHighlightModule(new CashierHighlightViewListener() { // from class: id.dana.cashier.fragment.CashierCvvChallengeFragment$cashierHighlightModule$1
        }));
        MyBillsEntityDataFactory.MyBillsEntityDataFactory().MyBillsEntityDataFactory(this);
        AbstractContract.AbstractPresenter[] abstractPresenterArr = new AbstractContract.AbstractPresenter[1];
        CashierContract.Presenter presenter = this.cashierPresenter;
        if (presenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            presenter = null;
        }
        abstractPresenterArr[0] = presenter;
        BuiltInFictitiousFunctionClassFactory(abstractPresenterArr);
    }

    @Override // id.dana.cashier.fragment.BaseVBCashierFragment
    protected final void whenAvailable() {
        Bundle arguments = getArguments();
        if (arguments != null) {
            PayResultModel payResultModel = ((BaseCashierRiskFragment) this).BuiltInFictitiousFunctionClassFactory;
            if (payResultModel != null) {
                String string = arguments.getString(CashierKeyParams.CASHIER_ORDER_ID);
                if (string == null) {
                    string = "";
                }
                Intrinsics.checkNotNullParameter(string, "");
                payResultModel.getErrorConfigVersion = string;
            }
            ((BaseCashierRiskFragment) this).NetworkUserEntityData$$ExternalSyntheticLambda0 = (CashierPayMethodModel) arguments.getParcelable(CashierKeyParams.CASHIER_PAY_METHOD);
            String string2 = arguments.getString(CashierKeyParams.VERIFICATION_METHOD, "");
            Intrinsics.checkNotNullExpressionValue(string2, "");
            this.BuiltInFictitiousFunctionClassFactory = string2;
            MyBillsEntityDataFactory((PayResultModel) arguments.getParcelable(CashierKeyParams.PAY_RESULT_MODEL));
            KClassImpl$Data$declaredNonStaticMembers$2(arguments.getBoolean(CashierKeyParams.IS_BINDING_PAY));
            String string3 = arguments.getString(CashierKeyParams.TOTAL_AMOUNT);
            if (string3 == null) {
                string3 = "";
            }
            this.MyBillsEntityDataFactory = string3;
            Bundle arguments2 = getArguments();
            MyBillsEntityDataFactory(arguments2 != null ? (VoucherCashierModel) arguments2.getParcelable(CashierKeyParams.VOUCHER_PROMO) : null);
            String[] stringArray = arguments.getStringArray(CashierKeyParams.CASHIER_ORDER_GOODS);
            BuiltInFictitiousFunctionClassFactory(stringArray != null ? ArraysKt.toList(stringArray) : null);
            CashierPayMethodModel cashierPayMethodModel = (CashierPayMethodModel) arguments.getParcelable(CashierKeyParams.BALANCE_MIX_PAY_MODEL);
            if (cashierPayMethodModel != null) {
                Intrinsics.checkNotNullExpressionValue(cashierPayMethodModel, "");
                this.getAuthRequestContext = cashierPayMethodModel;
            }
        }
    }

    public static final boolean KClassImpl$Data$declaredNonStaticMembers$2(CashierCvvChallengeFragment cashierCvvChallengeFragment, CharSequence charSequence) {
        Intrinsics.checkNotNullParameter(cashierCvvChallengeFragment, "");
        Intrinsics.checkNotNullParameter(charSequence, "");
        int length = charSequence.length();
        VB vb = cashierCvvChallengeFragment.PlaceComponentResult;
        if (vb != 0) {
            return length == ((FragmentCashierCvvChallengeBinding) vb).BuiltInFictitiousFunctionClassFactory.getMaxLength();
        }
        throw new IllegalArgumentException("Required value was null.".toString());
    }

    private final void VerifyPinStateManager$executeRiskChallenge$2$1() {
        Window window;
        FragmentActivity activity = getActivity();
        KeyboardHelper.PlaceComponentResult((activity == null || (window = activity.getWindow()) == null) ? null : window.getDecorView(), new KeyboardHelper.KeyboardVisibilityListener() { // from class: id.dana.cashier.fragment.CashierCvvChallengeFragment$setupKeyboardListener$1
            @Override // id.dana.utils.KeyboardHelper.KeyboardVisibilityListener
            public final void KClassImpl$Data$declaredNonStaticMembers$2() {
                View getAuthRequestContext = CashierCvvChallengeFragment.this.getGetAuthRequestContext();
                if (getAuthRequestContext != null) {
                    CashierCvvChallengeFragment.PlaceComponentResult(CashierCvvChallengeFragment.this, KeyboardHelper.getAuthRequestContext(getAuthRequestContext));
                }
            }

            @Override // id.dana.utils.KeyboardHelper.KeyboardVisibilityListener
            public final void MyBillsEntityDataFactory() {
                CashierCvvChallengeFragment.PlaceComponentResult(CashierCvvChallengeFragment.this, 0);
            }
        });
    }

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0007¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"Lid/dana/cashier/fragment/CashierCvvChallengeFragment$Companion;", "", "Landroid/os/Bundle;", "p0", "Lid/dana/cashier/fragment/CashierCvvChallengeFragment;", "KClassImpl$Data$declaredNonStaticMembers$2", "(Landroid/os/Bundle;)Lid/dana/cashier/fragment/CashierCvvChallengeFragment;", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes4.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public static CashierCvvChallengeFragment KClassImpl$Data$declaredNonStaticMembers$2(Bundle p0) {
            Intrinsics.checkNotNullParameter(p0, "");
            CashierCvvChallengeFragment cashierCvvChallengeFragment = new CashierCvvChallengeFragment();
            cashierCvvChallengeFragment.setArguments(p0);
            return cashierCvvChallengeFragment;
        }
    }

    public static /* synthetic */ void PlaceComponentResult(CashierCvvChallengeFragment cashierCvvChallengeFragment) {
        Intrinsics.checkNotNullParameter(cashierCvvChallengeFragment, "");
        VB vb = cashierCvvChallengeFragment.PlaceComponentResult;
        if (vb != 0) {
            KeyboardHelper.BuiltInFictitiousFunctionClassFactory(((FragmentCashierCvvChallengeBinding) vb).BuiltInFictitiousFunctionClassFactory);
            Context context = cashierCvvChallengeFragment.getContext();
            if (context != null) {
                CVVInfoDialog.Builder builder = new CVVInfoDialog.Builder(context, new DialogInterface.OnDismissListener() { // from class: id.dana.cashier.fragment.CashierCvvChallengeFragment$$ExternalSyntheticLambda2
                    @Override // android.content.DialogInterface.OnDismissListener
                    public final void onDismiss(DialogInterface dialogInterface) {
                        CashierCvvChallengeFragment.BottomSheetCardBindingView$watcherCardNumberView$1();
                    }
                });
                String string = context.getString(R.string.dialog_cvv_info_title);
                Intrinsics.checkNotNullExpressionValue(string, "");
                Intrinsics.checkNotNullParameter(string, "");
                builder.MyBillsEntityDataFactory = string;
                String string2 = context.getString(R.string.dialog_cvv_info_description);
                Intrinsics.checkNotNullExpressionValue(string2, "");
                Intrinsics.checkNotNullParameter(string2, "");
                builder.KClassImpl$Data$declaredNonStaticMembers$2 = string2;
                View.OnClickListener onClickListener = new View.OnClickListener() { // from class: id.dana.cashier.fragment.CashierCvvChallengeFragment$$ExternalSyntheticLambda3
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        CashierCvvChallengeFragment.getAuthRequestContext(CashierCvvChallengeFragment.this);
                    }
                };
                Intrinsics.checkNotNullParameter(onClickListener, "");
                builder.getAuthRequestContext = onClickListener;
                CVVInfoDialog.Builder BuiltInFictitiousFunctionClassFactory = builder.BuiltInFictitiousFunctionClassFactory();
                CVVInfoDialog cVVInfoDialog = new CVVInfoDialog(BuiltInFictitiousFunctionClassFactory.PlaceComponentResult, BuiltInFictitiousFunctionClassFactory, BuiltInFictitiousFunctionClassFactory.BuiltInFictitiousFunctionClassFactory, null);
                cashierCvvChallengeFragment.PlaceComponentResult = cVVInfoDialog;
                cVVInfoDialog.MyBillsEntityDataFactory();
                return;
            }
            return;
        }
        throw new IllegalArgumentException("Required value was null.".toString());
    }

    public static /* synthetic */ void getAuthRequestContext(CashierCvvChallengeFragment cashierCvvChallengeFragment) {
        Intrinsics.checkNotNullParameter(cashierCvvChallengeFragment, "");
        CVVInfoDialog cVVInfoDialog = cashierCvvChallengeFragment.PlaceComponentResult;
        if (cVVInfoDialog == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            cVVInfoDialog = null;
        }
        cVVInfoDialog.getAuthRequestContext();
    }

    public static /* synthetic */ void BuiltInFictitiousFunctionClassFactory(CashierCvvChallengeFragment cashierCvvChallengeFragment) {
        FragmentActivity activity;
        FragmentManager supportFragmentManager;
        Intrinsics.checkNotNullParameter(cashierCvvChallengeFragment, "");
        VB vb = cashierCvvChallengeFragment.PlaceComponentResult;
        if (vb != 0) {
            KeyboardHelper.BuiltInFictitiousFunctionClassFactory(((FragmentCashierCvvChallengeBinding) vb).BuiltInFictitiousFunctionClassFactory);
            if (!cashierCvvChallengeFragment.isVisible() || (activity = cashierCvvChallengeFragment.getActivity()) == null || (supportFragmentManager = activity.getSupportFragmentManager()) == null) {
                return;
            }
            supportFragmentManager.popBackStack();
            return;
        }
        throw new IllegalArgumentException("Required value was null.".toString());
    }

    public static /* synthetic */ void getAuthRequestContext(CashierCvvChallengeFragment cashierCvvChallengeFragment, CharSequence charSequence) {
        Intrinsics.checkNotNullParameter(cashierCvvChallengeFragment, "");
        String obj = charSequence.toString();
        CashierPayMethodModel cashierPayMethodModel = ((BaseCashierRiskFragment) cashierCvvChallengeFragment).NetworkUserEntityData$$ExternalSyntheticLambda0;
        if (cashierPayMethodModel != null) {
            CashierContract.Presenter presenter = cashierCvvChallengeFragment.cashierPresenter;
            if (presenter == null) {
                Intrinsics.throwUninitializedPropertyAccessException("");
                presenter = null;
            }
            PayResultModel payResultModel = ((BaseCashierRiskFragment) cashierCvvChallengeFragment).BuiltInFictitiousFunctionClassFactory;
            String str = payResultModel != null ? payResultModel.getErrorConfigVersion : null;
            if (str == null) {
                str = "";
            }
            CashierPayMethodModel cashierPayMethodModel2 = cashierCvvChallengeFragment.getAuthRequestContext;
            if (cashierPayMethodModel2 == null) {
                cashierPayMethodModel2 = cashierPayMethodModel;
            } else if (cashierPayMethodModel2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("");
                cashierPayMethodModel2 = null;
            }
            String str2 = cashierCvvChallengeFragment.BuiltInFictitiousFunctionClassFactory;
            if (str2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("");
                str2 = null;
            }
            presenter.MyBillsEntityDataFactory(str, cashierPayMethodModel2, obj, str2, cashierCvvChallengeFragment.getNetworkUserEntityData$$ExternalSyntheticLambda7(), (r24 & 32) != 0 ? false : true, cashierCvvChallengeFragment.BuiltInFictitiousFunctionClassFactory(), (r24 & 128) != 0 ? null : null, (r24 & 256) != 0 ? null : cashierCvvChallengeFragment.getAuthRequestContext == null ? null : cashierPayMethodModel, (r24 & 512) != 0 ? null : cashierCvvChallengeFragment.getNetworkUserEntityData$$ExternalSyntheticLambda6());
        }
        VB vb = cashierCvvChallengeFragment.PlaceComponentResult;
        if (vb != 0) {
            TextView textView = ((FragmentCashierCvvChallengeBinding) vb).scheduleImpl;
            Intrinsics.checkNotNullExpressionValue(textView, "");
            textView.setVisibility(8);
            VB vb2 = cashierCvvChallengeFragment.PlaceComponentResult;
            if (vb2 != 0) {
                KeyboardHelper.BuiltInFictitiousFunctionClassFactory(((FragmentCashierCvvChallengeBinding) vb2).BuiltInFictitiousFunctionClassFactory);
                return;
            }
            throw new IllegalArgumentException("Required value was null.".toString());
        }
        throw new IllegalArgumentException("Required value was null.".toString());
    }

    public static final /* synthetic */ void getAuthRequestContext(CashierCvvChallengeFragment cashierCvvChallengeFragment, AttributeCashierPayModel attributeCashierPayModel) {
        String[] strArr;
        List<OneKlikPhonesModel> list;
        RiskVerificationMethodModel riskVerificationMethodModel;
        RiskVerificationMethodModel riskVerificationMethodModel2;
        List<OneKlikPhonesModel> list2;
        RiskVerificationMethodModel riskVerificationMethodModel3;
        RiskVerificationMethodModel riskVerificationMethodModel4;
        if (cashierCvvChallengeFragment.getActivity() instanceof PayActivity) {
            String str = (attributeCashierPayModel == null || (riskVerificationMethodModel4 = attributeCashierPayModel.P) == null) ? null : riskVerificationMethodModel4.scheduleImpl;
            String str2 = str == null ? "" : str;
            List<String> list3 = (attributeCashierPayModel == null || (riskVerificationMethodModel3 = attributeCashierPayModel.P) == null) ? null : riskVerificationMethodModel3.lookAheadTest;
            PayResultModel payResultModel = ((BaseCashierRiskFragment) cashierCvvChallengeFragment).BuiltInFictitiousFunctionClassFactory;
            String str3 = payResultModel != null ? payResultModel.getErrorConfigVersion : null;
            String str4 = str3 == null ? "" : str3;
            CashierPayMethodModel cashierPayMethodModel = ((BaseCashierRiskFragment) cashierCvvChallengeFragment).NetworkUserEntityData$$ExternalSyntheticLambda0;
            List<String> BuiltInFictitiousFunctionClassFactory = cashierCvvChallengeFragment.BuiltInFictitiousFunctionClassFactory();
            if (BuiltInFictitiousFunctionClassFactory != null) {
                Object[] array = BuiltInFictitiousFunctionClassFactory.toArray(new String[0]);
                if (array == null) {
                    throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
                }
                strArr = (String[]) array;
            } else {
                strArr = null;
            }
            RiskParamsFactory riskParamsFactory = new RiskParamsFactory(attributeCashierPayModel, str4, cashierPayMethodModel, false, cashierCvvChallengeFragment.getNetworkUserEntityData$$ExternalSyntheticLambda7(), ((BaseCashierRiskFragment) cashierCvvChallengeFragment).BuiltInFictitiousFunctionClassFactory, strArr, ((BaseCashierRiskFragment) cashierCvvChallengeFragment).moveToNextValue, null, null, null, null, null, null, list3, 16136, null);
            FragmentActivity activity = cashierCvvChallengeFragment.getActivity();
            PayActivity payActivity = activity instanceof PayActivity ? (PayActivity) activity : null;
            if (payActivity != null) {
                if (attributeCashierPayModel == null || (riskVerificationMethodModel2 = attributeCashierPayModel.com.alibaba.griver.image.photo.utils.DiskFormatter.KB java.lang.String) == null || (list2 = riskVerificationMethodModel2.getAuthRequestContext) == null) {
                    list = (attributeCashierPayModel == null || (riskVerificationMethodModel = attributeCashierPayModel.P) == null) ? null : riskVerificationMethodModel.getAuthRequestContext;
                } else {
                    list = list2;
                }
                PayActivity.handleCashierRiskPhase$default(payActivity, str2, riskParamsFactory, list, null, 8, null);
            }
        }
    }

    public static final /* synthetic */ void MyBillsEntityDataFactory(CashierCvvChallengeFragment cashierCvvChallengeFragment) {
        VB vb = cashierCvvChallengeFragment.PlaceComponentResult;
        if (vb != 0) {
            KeyboardHelper.BuiltInFictitiousFunctionClassFactory(((FragmentCashierCvvChallengeBinding) vb).BuiltInFictitiousFunctionClassFactory);
            return;
        }
        throw new IllegalArgumentException("Required value was null.".toString());
    }

    public static final /* synthetic */ void KClassImpl$Data$declaredNonStaticMembers$2(CashierCvvChallengeFragment cashierCvvChallengeFragment) {
        cashierCvvChallengeFragment.getErrorConfigVersion();
        VB vb = cashierCvvChallengeFragment.PlaceComponentResult;
        if (vb != 0) {
            ((FragmentCashierCvvChallengeBinding) vb).BuiltInFictitiousFunctionClassFactory.requestFocus();
            cashierCvvChallengeFragment.VerifyPinStateManager$executeRiskChallenge$2$1();
            return;
        }
        throw new IllegalArgumentException("Required value was null.".toString());
    }

    public static final /* synthetic */ void PlaceComponentResult(CashierCvvChallengeFragment cashierCvvChallengeFragment, int i) {
        VB vb = cashierCvvChallengeFragment.PlaceComponentResult;
        if (vb != 0) {
            ConstraintLayout.LayoutParams layoutParams = (ConstraintLayout.LayoutParams) ((FragmentCashierCvvChallengeBinding) vb).KClassImpl$Data$declaredNonStaticMembers$2.getLayoutParams();
            int authRequestContext = SizeUtil.getAuthRequestContext(32);
            int authRequestContext2 = SizeUtil.getAuthRequestContext(28);
            if (layoutParams != null) {
                layoutParams.setMargins(authRequestContext, 0, authRequestContext, authRequestContext2 + i);
            }
            VB vb2 = cashierCvvChallengeFragment.PlaceComponentResult;
            if (vb2 != 0) {
                ((FragmentCashierCvvChallengeBinding) vb2).KClassImpl$Data$declaredNonStaticMembers$2.setLayoutParams(layoutParams);
                return;
            }
            throw new IllegalArgumentException("Required value was null.".toString());
        }
        throw new IllegalArgumentException("Required value was null.".toString());
    }

    @Override // id.dana.cashier.fragment.BaseVBCashierFragment
    public final void PlaceComponentResult(CashierErrorState p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        if (Intrinsics.areEqual(p0.MyBillsEntityDataFactory, CashierErrorType.RETRYABLE_RISK_CHALLENGE)) {
            String asString = p0.getAuthRequestContext.asString(getContext());
            VB vb = this.PlaceComponentResult;
            if (vb != 0) {
                TextView textView = ((FragmentCashierCvvChallengeBinding) vb).scheduleImpl;
                Intrinsics.checkNotNullExpressionValue(textView, "");
                textView.setVisibility(0);
                textView.setText(asString);
                return;
            }
            throw new IllegalArgumentException("Required value was null.".toString());
        }
        BaseVBCashierFragment.getAuthRequestContext(this, "fail", p0.getAuthRequestContext.asString(getContext()), p0.KClassImpl$Data$declaredNonStaticMembers$2, null, null, false, 56);
    }

    @Override // id.dana.cashier.fragment.BaseVBCashierFragment
    protected final void getAuthRequestContext(String p0, String p1, String p2, String p3, String p4, boolean p5) {
        Intrinsics.checkNotNullParameter(p0, "");
        Intrinsics.checkNotNullParameter(p3, "");
        Intrinsics.checkNotNullParameter(p4, "");
        PayResultModel payResultModel = ((BaseCashierRiskFragment) this).BuiltInFictitiousFunctionClassFactory;
        if (payResultModel != null) {
            payResultModel.getValueOfTouchPositionAbsolute = p0;
            payResultModel.GetContactSyncConfig = p1;
            payResultModel.scheduleImpl = p2;
            Intrinsics.checkNotNullParameter(p3, "");
            payResultModel.PlaceComponentResult = p3;
            Intrinsics.checkNotNullParameter(p4, "");
            payResultModel.J = p4;
            payResultModel.G = BuiltInFictitiousFunctionClassFactory();
            FragmentActivity activity = getActivity();
            PayActivity payActivity = activity instanceof PayActivity ? (PayActivity) activity : null;
            if (payActivity != null) {
                PaymentResultFragment.Companion companion = PaymentResultFragment.KClassImpl$Data$declaredNonStaticMembers$2;
                payActivity.addFragment(PaymentResultFragment.Companion.BuiltInFictitiousFunctionClassFactory(payResultModel, p5));
            }
        }
    }

    @Override // id.dana.cashier.fragment.BaseVBCashierFragment
    protected final void NetworkUserEntityData$$ExternalSyntheticLambda4() {
        getErrorConfigVersion();
        VB vb = this.PlaceComponentResult;
        if (vb != 0) {
            ((FragmentCashierCvvChallengeBinding) vb).BuiltInFictitiousFunctionClassFactory.requestFocus();
            VerifyPinStateManager$executeRiskChallenge$2$1();
            VB vb2 = this.PlaceComponentResult;
            if (vb2 != 0) {
                ((FragmentCashierCvvChallengeBinding) vb2).lookAheadTest.setOnClickListener(new View.OnClickListener() { // from class: id.dana.cashier.fragment.CashierCvvChallengeFragment$$ExternalSyntheticLambda4
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        CashierCvvChallengeFragment.PlaceComponentResult(CashierCvvChallengeFragment.this);
                    }
                });
                VB vb3 = this.PlaceComponentResult;
                if (vb3 != 0) {
                    ((FragmentCashierCvvChallengeBinding) vb3).moveToNextValue.setOnClickListener(new View.OnClickListener() { // from class: id.dana.cashier.fragment.CashierCvvChallengeFragment$$ExternalSyntheticLambda5
                        @Override // android.view.View.OnClickListener
                        public final void onClick(View view) {
                            CashierCvvChallengeFragment.BuiltInFictitiousFunctionClassFactory(CashierCvvChallengeFragment.this);
                        }
                    });
                    VB vb4 = this.PlaceComponentResult;
                    if (vb4 != 0) {
                        PlaceComponentResult(RxTextView.textChanges(((FragmentCashierCvvChallengeBinding) vb4).BuiltInFictitiousFunctionClassFactory).filter(new Predicate() { // from class: id.dana.cashier.fragment.CashierCvvChallengeFragment$$ExternalSyntheticLambda0
                            @Override // io.reactivex.functions.Predicate
                            public final boolean test(Object obj) {
                                boolean KClassImpl$Data$declaredNonStaticMembers$2;
                                KClassImpl$Data$declaredNonStaticMembers$2 = CashierCvvChallengeFragment.KClassImpl$Data$declaredNonStaticMembers$2(CashierCvvChallengeFragment.this, (CharSequence) obj);
                                return KClassImpl$Data$declaredNonStaticMembers$2;
                            }
                        }).subscribe(new Consumer() { // from class: id.dana.cashier.fragment.CashierCvvChallengeFragment$$ExternalSyntheticLambda1
                            @Override // io.reactivex.functions.Consumer
                            public final void accept(Object obj) {
                                CashierCvvChallengeFragment.getAuthRequestContext(CashierCvvChallengeFragment.this, (CharSequence) obj);
                            }
                        }));
                        return;
                    }
                    throw new IllegalArgumentException("Required value was null.".toString());
                }
                throw new IllegalArgumentException("Required value was null.".toString());
            }
            throw new IllegalArgumentException("Required value was null.".toString());
        }
        throw new IllegalArgumentException("Required value was null.".toString());
    }

    @Override // id.dana.cashier.fragment.BaseCashierRiskFragment, id.dana.cashier.fragment.BaseVBCashierFragment, id.dana.core.ui.BaseViewBindingFragment, androidx.fragment.app.Fragment
    public final /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        this.initRecordTimeStamp.clear();
    }
}
