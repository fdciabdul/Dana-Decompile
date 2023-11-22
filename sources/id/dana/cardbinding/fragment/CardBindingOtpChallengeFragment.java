package id.dana.cardbinding.fragment;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.text.Editable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.ConstraintSet;
import androidx.view.LifecycleOwnerKt;
import androidx.view.ViewModelKt;
import androidx.view.ViewModelProvider;
import com.alipay.iap.android.common.syncintegration.api.IAPSyncCommand;
import com.google.android.gms.auth.api.phone.SmsRetriever;
import com.jakewharton.rxbinding2.widget.RxTextView;
import dagger.internal.Preconditions;
import id.dana.R;
import id.dana.base.BaseActivity;
import id.dana.base.BaseFragment;
import id.dana.cardbinding.di.component.DaggerCardBindingComponent;
import id.dana.cardbinding.di.module.ViewModelFactory;
import id.dana.cardbinding.model.CashierPayParamModel;
import id.dana.cardbinding.viewmodel.CardBindingViewModel;
import id.dana.cardbinding.viewmodel.OtpCardBindingUiState;
import id.dana.cardbinding.viewmodel.OtpCardBindingViewModel;
import id.dana.cashier.VerificationMethod;
import id.dana.cashier.domain.interactor.CreateCashierAgreement;
import id.dana.cashier.domain.model.CashierAgreementResponse;
import id.dana.cashier.helper.CashierErrorHelper;
import id.dana.cashier.mapper.CashierAgreementModelMapper;
import id.dana.cashier.model.CashierPayMethodModel;
import id.dana.cashier.model.SendBankOtpModel;
import id.dana.cashier.utils.CashierOtpUtil;
import id.dana.challenge.ChallengeControl;
import id.dana.challenge.ChallengeScenarioListener;
import id.dana.core.ui.richview.PinEntryEditText;
import id.dana.di.component.ApplicationComponent;
import id.dana.domain.core.usecase.BaseFlowUseCase;
import id.dana.domain.core.usecase.NoParams;
import id.dana.extension.view.InputExtKt;
import id.dana.network.exception.NetworkException;
import id.dana.richview.LogoProgressView;
import id.dana.utils.KeyboardHelper;
import id.dana.utils.SizeUtil;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Predicate;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.flow.MutableStateFlow;

@Metadata(d1 = {"\u0000x\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 >2\u00020\u0001:\u0001>B\u0007¢\u0006\u0004\b=\u0010\nJ\u0011\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0006\u001a\u00020\u0005H\u0014¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\t\u001a\u00020\bH\u0014¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\u000b\u001a\u00020\bH\u0002¢\u0006\u0004\b\u000b\u0010\nJ)\u0010\u0010\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\u00052\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eH\u0016¢\u0006\u0004\b\u0010\u0010\u0011J\u0017\u0010\u0013\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\u0012H\u0016¢\u0006\u0004\b\u0013\u0010\u0014J\u000f\u0010\u0015\u001a\u00020\bH\u0016¢\u0006\u0004\b\u0015\u0010\nJ\u000f\u0010\u0016\u001a\u00020\bH\u0002¢\u0006\u0004\b\u0016\u0010\nJ\u000f\u0010\u0017\u001a\u00020\bH\u0002¢\u0006\u0004\b\u0017\u0010\nJ\u000f\u0010\u0018\u001a\u00020\bH\u0002¢\u0006\u0004\b\u0018\u0010\nJ\u0019\u0010\u0016\u001a\u00020\b2\b\u0010\f\u001a\u0004\u0018\u00010\u0019H\u0002¢\u0006\u0004\b\u0016\u0010\u001aJ\u0017\u0010\u000b\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\u001bH\u0002¢\u0006\u0004\b\u000b\u0010\u001cR\u0012\u0010\u0003\u001a\u00020\u001dX\u0086\"¢\u0006\u0006\n\u0004\b\u0018\u0010\u001eR\u0018\u0010\u0016\u001a\u0004\u0018\u00010\u001f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b \u0010!R\u0016\u0010\u000b\u001a\u00020\u001b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\"\u0010#R\u0016\u0010\u0017\u001a\u00020\u001b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b$\u0010#R\u0014\u0010\u0018\u001a\u00020%8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b&\u0010'R\u0014\u0010$\u001a\u00020%8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b(\u0010'R\u0014\u0010\"\u001a\u00020\u00058\u0002X\u0082\u0006¢\u0006\u0006\n\u0004\b)\u0010*R\u0012\u0010 \u001a\u00020+X\u0086\"¢\u0006\u0006\n\u0004\b\u000b\u0010,R\u0018\u0010&\u001a\u0004\u0018\u00010-8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b.\u0010/R\u0016\u0010(\u001a\u00020\u00198\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b0\u00101R\u0016\u0010.\u001a\u00020\u00058\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b2\u0010*R\u0016\u00104\u001a\u0002038\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b4\u00105R\u0018\u00102\u001a\u0004\u0018\u0001068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b7\u00108R\u0016\u00100\u001a\u00020\u00198\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b9\u00101R\u0012\u0010;\u001a\u00020:X\u0087\"¢\u0006\u0006\n\u0004\b;\u0010<"}, d2 = {"Lid/dana/cardbinding/fragment/CardBindingOtpChallengeFragment;", "Lid/dana/base/BaseFragment;", "Lio/reactivex/disposables/Disposable;", "KClassImpl$Data$declaredNonStaticMembers$2", "()Lio/reactivex/disposables/Disposable;", "", "getLayout", "()I", "", IAPSyncCommand.COMMAND_INIT, "()V", "PlaceComponentResult", "p0", "p1", "Landroid/content/Intent;", "p2", "onActivityResult", "(IILandroid/content/Intent;)V", "Landroid/content/Context;", "onAttach", "(Landroid/content/Context;)V", "onDestroy", "getAuthRequestContext", "BuiltInFictitiousFunctionClassFactory", "MyBillsEntityDataFactory", "", "(Ljava/lang/String;)V", "", "(Z)V", "Lid/dana/cardbinding/viewmodel/CardBindingViewModel;", "Lid/dana/cardbinding/viewmodel/CardBindingViewModel;", "Landroid/os/CountDownTimer;", "moveToNextValue", "Landroid/os/CountDownTimer;", "scheduleImpl", "Z", "lookAheadTest", "Lkotlinx/coroutines/Job;", "getErrorConfigVersion", "Lkotlinx/coroutines/Job;", "NetworkUserEntityData$$ExternalSyntheticLambda0", "GetContactSyncConfig", "I", "Lid/dana/cardbinding/viewmodel/OtpCardBindingViewModel;", "Lid/dana/cardbinding/viewmodel/OtpCardBindingViewModel;", "Lid/dana/cashier/model/CashierPayMethodModel$CardPayMethod;", "initRecordTimeStamp", "Lid/dana/cashier/model/CashierPayMethodModel$CardPayMethod;", "DatabaseTableConfigUtil", "Ljava/lang/String;", "NetworkUserEntityData$$ExternalSyntheticLambda1", "Lid/dana/challenge/ChallengeScenarioListener;", "NetworkUserEntityData$$ExternalSyntheticLambda2", "Lid/dana/challenge/ChallengeScenarioListener;", "Lid/dana/cashier/model/SendBankOtpModel;", "NetworkUserEntityData$$ExternalSyntheticLambda7", "Lid/dana/cashier/model/SendBankOtpModel;", "isLayoutRequested", "Lid/dana/cardbinding/di/module/ViewModelFactory;", "viewModelFactory", "Lid/dana/cardbinding/di/module/ViewModelFactory;", "<init>", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class CardBindingOtpChallengeFragment extends BaseFragment {

    /* renamed from: Companion  reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
    public CardBindingViewModel KClassImpl$Data$declaredNonStaticMembers$2;

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda0  reason: from kotlin metadata */
    private final Job lookAheadTest;

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda1  reason: from kotlin metadata */
    private int initRecordTimeStamp;
    private ChallengeScenarioListener NetworkUserEntityData$$ExternalSyntheticLambda2;

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda7  reason: from kotlin metadata */
    private SendBankOtpModel NetworkUserEntityData$$ExternalSyntheticLambda1;

    /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
    public OtpCardBindingViewModel moveToNextValue;

    /* renamed from: getErrorConfigVersion  reason: from kotlin metadata */
    private final Job MyBillsEntityDataFactory;

    /* renamed from: initRecordTimeStamp  reason: from kotlin metadata */
    private CashierPayMethodModel.CardPayMethod getErrorConfigVersion;

    /* renamed from: isLayoutRequested  reason: from kotlin metadata */
    private String DatabaseTableConfigUtil;

    /* renamed from: lookAheadTest  reason: from kotlin metadata */
    private boolean BuiltInFictitiousFunctionClassFactory;

    /* renamed from: moveToNextValue  reason: from kotlin metadata */
    private CountDownTimer getAuthRequestContext;

    /* renamed from: scheduleImpl  reason: from kotlin metadata */
    private boolean PlaceComponentResult;
    @Inject
    public ViewModelFactory viewModelFactory;
    public Map<Integer, View> KClassImpl$Data$declaredNonStaticMembers$2 = new LinkedHashMap();

    /* renamed from: GetContactSyncConfig  reason: from kotlin metadata */
    private int scheduleImpl = 6;

    /* renamed from: DatabaseTableConfigUtil  reason: from kotlin metadata */
    private String NetworkUserEntityData$$ExternalSyntheticLambda0 = "";

    public final View BuiltInFictitiousFunctionClassFactory(int i) {
        View findViewById;
        Map<Integer, View> map = this.KClassImpl$Data$declaredNonStaticMembers$2;
        View view = map.get(Integer.valueOf(i));
        if (view == null) {
            View view2 = getView();
            if (view2 == null || (findViewById = view2.findViewById(i)) == null) {
                return null;
            }
            map.put(Integer.valueOf(i), findViewById);
            return findViewById;
        }
        return view;
    }

    @Override // id.dana.base.BaseFragment
    public final int getLayout() {
        return R.layout.fragment_card_binding_otp_challenge;
    }

    public CardBindingOtpChallengeFragment() {
        Job launch$default;
        Job launch$default2;
        CardBindingOtpChallengeFragment cardBindingOtpChallengeFragment = this;
        launch$default = BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.PlaceComponentResult(cardBindingOtpChallengeFragment), null, null, new CardBindingOtpChallengeFragment$observeCardBindingUiState$1(this, null), 3, null);
        this.MyBillsEntityDataFactory = launch$default;
        launch$default2 = BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.PlaceComponentResult(cardBindingOtpChallengeFragment), null, null, new CardBindingOtpChallengeFragment$observeOtpUiState$1(this, null), 3, null);
        this.lookAheadTest = launch$default2;
    }

    @Override // id.dana.base.BaseFragment, androidx.fragment.app.Fragment
    public final void onAttach(Context p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        super.onAttach(p0);
        try {
            BaseActivity baseActivity = getBaseActivity();
            if (baseActivity != null) {
                this.NetworkUserEntityData$$ExternalSyntheticLambda2 = (ChallengeScenarioListener) baseActivity;
                return;
            }
            throw new NullPointerException("null cannot be cast to non-null type id.dana.challenge.ChallengeScenarioListener");
        } catch (ClassCastException e) {
            StringBuilder sb = new StringBuilder();
            sb.append(p0);
            sb.append("must implement ChallengeScenarioListener");
            throw new ClassCastException(sb.toString());
        }
    }

    private final void MyBillsEntityDataFactory() {
        int authRequestContext;
        PinEntryEditText pinEntryEditText = (PinEntryEditText) BuiltInFictitiousFunctionClassFactory(R.id.res_0x7f0a067f_r8_lambda_tgidiae_3l8as7qvhbz6_rxba0k);
        if (pinEntryEditText != null) {
            pinEntryEditText.setMaxLength(this.scheduleImpl);
            ConstraintLayout.LayoutParams layoutParams = (ConstraintLayout.LayoutParams) pinEntryEditText.getLayoutParams();
            int maxLength = pinEntryEditText.getMaxLength();
            if (maxLength == 4) {
                authRequestContext = SizeUtil.getAuthRequestContext(100);
            } else if (maxLength == 6) {
                authRequestContext = SizeUtil.getAuthRequestContext(60);
            } else if (maxLength == 8) {
                authRequestContext = SizeUtil.getAuthRequestContext(16);
            } else {
                authRequestContext = SizeUtil.getAuthRequestContext(16);
            }
            if (layoutParams != null) {
                PinEntryEditText pinEntryEditText2 = pinEntryEditText;
                ViewGroup.LayoutParams layoutParams2 = pinEntryEditText2.getLayoutParams();
                ViewGroup.MarginLayoutParams marginLayoutParams = layoutParams2 instanceof ViewGroup.MarginLayoutParams ? (ViewGroup.MarginLayoutParams) layoutParams2 : null;
                int i = marginLayoutParams != null ? marginLayoutParams.topMargin : 0;
                ViewGroup.LayoutParams layoutParams3 = pinEntryEditText2.getLayoutParams();
                ViewGroup.MarginLayoutParams marginLayoutParams2 = layoutParams3 instanceof ViewGroup.MarginLayoutParams ? (ViewGroup.MarginLayoutParams) layoutParams3 : null;
                layoutParams.setMargins(authRequestContext, i, authRequestContext, marginLayoutParams2 != null ? marginLayoutParams2.bottomMargin : 0);
            }
            pinEntryEditText.setLayoutParams(layoutParams);
        }
        ConstraintLayout constraintLayout = (ConstraintLayout) BuiltInFictitiousFunctionClassFactory(R.id.res_0x7f0a03af_r8_lambda_zxhmsujxtx99vyz6bmhxqp1wkc8);
        Intrinsics.checkNotNullExpressionValue(constraintLayout, "");
        ConstraintSet constraintSet = new ConstraintSet();
        constraintSet.getAuthRequestContext(constraintLayout);
        constraintSet.KClassImpl$Data$declaredNonStaticMembers$2(((ConstraintLayout) BuiltInFictitiousFunctionClassFactory(R.id.setAkuEntranceOpen_res_0x7f0a03c1)).getId(), 3, ((PinEntryEditText) BuiltInFictitiousFunctionClassFactory(R.id.res_0x7f0a067f_r8_lambda_tgidiae_3l8as7qvhbz6_rxba0k)).getId(), 4, SizeUtil.getAuthRequestContext(42));
        constraintSet.KClassImpl$Data$declaredNonStaticMembers$2(((ConstraintLayout) BuiltInFictitiousFunctionClassFactory(R.id.setAkuEntranceOpen_res_0x7f0a03c1)).getId(), 4, ((ConstraintLayout) BuiltInFictitiousFunctionClassFactory(R.id.res_0x7f0a03af_r8_lambda_zxhmsujxtx99vyz6bmhxqp1wkc8)).getId(), 4, SizeUtil.getAuthRequestContext(24));
        constraintSet.KClassImpl$Data$declaredNonStaticMembers$2(constraintLayout);
        BuiltInFictitiousFunctionClassFactory();
        getAuthRequestContext();
    }

    private final Disposable KClassImpl$Data$declaredNonStaticMembers$2() {
        return RxTextView.textChanges((PinEntryEditText) BuiltInFictitiousFunctionClassFactory(R.id.res_0x7f0a067f_r8_lambda_tgidiae_3l8as7qvhbz6_rxba0k)).filter(new Predicate() { // from class: id.dana.cardbinding.fragment.CardBindingOtpChallengeFragment$$ExternalSyntheticLambda2
            @Override // io.reactivex.functions.Predicate
            public final boolean test(Object obj) {
                boolean BuiltInFictitiousFunctionClassFactory;
                BuiltInFictitiousFunctionClassFactory = CardBindingOtpChallengeFragment.BuiltInFictitiousFunctionClassFactory(CardBindingOtpChallengeFragment.this, (CharSequence) obj);
                return BuiltInFictitiousFunctionClassFactory;
            }
        }).subscribe(new Consumer() { // from class: id.dana.cardbinding.fragment.CardBindingOtpChallengeFragment$$ExternalSyntheticLambda3
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                CardBindingOtpChallengeFragment.MyBillsEntityDataFactory(CardBindingOtpChallengeFragment.this, (CharSequence) obj);
            }
        });
    }

    public static final boolean BuiltInFictitiousFunctionClassFactory(CardBindingOtpChallengeFragment cardBindingOtpChallengeFragment, CharSequence charSequence) {
        Intrinsics.checkNotNullParameter(cardBindingOtpChallengeFragment, "");
        Intrinsics.checkNotNullParameter(charSequence, "");
        return charSequence.length() == ((PinEntryEditText) cardBindingOtpChallengeFragment.BuiltInFictitiousFunctionClassFactory(R.id.res_0x7f0a067f_r8_lambda_tgidiae_3l8as7qvhbz6_rxba0k)).getMaxLength();
    }

    private final void getAuthRequestContext() {
        Context requireContext = requireContext();
        Intrinsics.checkNotNullExpressionValue(requireContext, "");
        PinEntryEditText pinEntryEditText = (PinEntryEditText) BuiltInFictitiousFunctionClassFactory(R.id.res_0x7f0a067f_r8_lambda_tgidiae_3l8as7qvhbz6_rxba0k);
        Intrinsics.checkNotNullExpressionValue(pinEntryEditText, "");
        KeyboardHelper.BuiltInFictitiousFunctionClassFactory(requireContext, pinEntryEditText);
    }

    private final void BuiltInFictitiousFunctionClassFactory() {
        TextView textView = (TextView) BuiltInFictitiousFunctionClassFactory(R.id.setupWithViewPager);
        if (textView != null) {
            String str = this.DatabaseTableConfigUtil;
            String str2 = null;
            if (str == null) {
                Intrinsics.throwUninitializedPropertyAccessException("");
                str = null;
            }
            if (!Intrinsics.areEqual(str, VerificationMethod.SEND_OTP)) {
                String str3 = this.DatabaseTableConfigUtil;
                if (str3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("");
                } else {
                    str2 = str3;
                }
                if (!Intrinsics.areEqual(str2, VerificationMethod.BANK_OTP) && !this.PlaceComponentResult) {
                    textView.setVisibility(8);
                    return;
                }
            }
            textView.setVisibility(0);
            textView.setText(getString(R.string.otp_sent_to_your_bank_number));
        }
    }

    private final void PlaceComponentResult() {
        CashierOtpUtil cashierOtpUtil = CashierOtpUtil.INSTANCE;
        BaseActivity baseActivity = getBaseActivity();
        Intrinsics.checkNotNullExpressionValue(baseActivity, "");
        CashierOtpUtil.BuiltInFictitiousFunctionClassFactory(baseActivity, new Function0<Unit>() { // from class: id.dana.cardbinding.fragment.CardBindingOtpChallengeFragment$listenSmsReceiver$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2() {
                final OtpCardBindingViewModel otpCardBindingViewModel = CardBindingOtpChallengeFragment.this.moveToNextValue;
                if (otpCardBindingViewModel == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("");
                    otpCardBindingViewModel = null;
                }
                BaseFlowUseCase.execute$default(otpCardBindingViewModel.BuiltInFictitiousFunctionClassFactory, NoParams.INSTANCE, null, new Function1<Bundle, Unit>() { // from class: id.dana.cardbinding.viewmodel.OtpCardBindingViewModel$receiveSms$1
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final /* bridge */ /* synthetic */ Unit invoke(Bundle bundle) {
                        invoke2(bundle);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke  reason: avoid collision after fix types in other method */
                    public final void invoke2(Bundle bundle) {
                        MutableStateFlow mutableStateFlow;
                        Object value;
                        Intrinsics.checkNotNullParameter(bundle, "");
                        mutableStateFlow = OtpCardBindingViewModel.this.PlaceComponentResult;
                        do {
                            value = mutableStateFlow.getValue();
                            OtpCardBindingUiState otpCardBindingUiState = (OtpCardBindingUiState) value;
                        } while (!mutableStateFlow.compareAndSet(value, new OtpCardBindingUiState.OnSmsReceived(bundle)));
                    }
                }, new Function1<Throwable, Unit>() { // from class: id.dana.cardbinding.viewmodel.OtpCardBindingViewModel$receiveSms$2
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
                        MutableStateFlow mutableStateFlow;
                        Object value;
                        Intrinsics.checkNotNullParameter(th, "");
                        mutableStateFlow = OtpCardBindingViewModel.this.PlaceComponentResult;
                        do {
                            value = mutableStateFlow.getValue();
                            OtpCardBindingUiState otpCardBindingUiState = (OtpCardBindingUiState) value;
                        } while (!mutableStateFlow.compareAndSet(value, new OtpCardBindingUiState.OnError(th.getMessage())));
                    }
                }, null, ViewModelKt.PlaceComponentResult(otpCardBindingViewModel), 18, null);
            }
        });
    }

    @Override // androidx.fragment.app.Fragment
    public final void onActivityResult(int p0, int p1, Intent p2) {
        super.onActivityResult(p0, p1, p2);
        if (p0 == 1 && p1 == -1 && p2 != null) {
            String stringExtra = p2.getStringExtra(SmsRetriever.EXTRA_SMS_MESSAGE);
            CashierOtpUtil cashierOtpUtil = CashierOtpUtil.INSTANCE;
            String MyBillsEntityDataFactory = CashierOtpUtil.MyBillsEntityDataFactory(stringExtra);
            PinEntryEditText pinEntryEditText = (PinEntryEditText) BuiltInFictitiousFunctionClassFactory(R.id.res_0x7f0a067f_r8_lambda_tgidiae_3l8as7qvhbz6_rxba0k);
            if (pinEntryEditText != null) {
                pinEntryEditText.setText(MyBillsEntityDataFactory);
            }
        }
    }

    private final void PlaceComponentResult(boolean p0) {
        TextView textView = (TextView) BuiltInFictitiousFunctionClassFactory(R.id.setMinusSignString);
        if (textView != null) {
            textView.setVisibility(p0 ? 0 : 8);
        }
        TextView textView2 = (TextView) BuiltInFictitiousFunctionClassFactory(R.id.ViewholderFriendListEmptyBinding);
        if (textView2 != null) {
            textView2.setVisibility(p0 ^ true ? 0 : 8);
        }
    }

    public final void getAuthRequestContext(String p0) {
        TextView textView = (TextView) BuiltInFictitiousFunctionClassFactory(R.id.getLogSourceName);
        if (textView != null) {
            String str = p0;
            textView.setVisibility((str == null || str.length() == 0) ^ true ? 4 : 0);
        }
        TextView textView2 = (TextView) BuiltInFictitiousFunctionClassFactory(R.id.getContext);
        if (textView2 != null) {
            String str2 = p0;
            textView2.setVisibility(true ^ (str2 == null || str2.length() == 0) ? 0 : 8);
            textView2.setText(str2);
        }
        PinEntryEditText pinEntryEditText = (PinEntryEditText) BuiltInFictitiousFunctionClassFactory(R.id.res_0x7f0a067f_r8_lambda_tgidiae_3l8as7qvhbz6_rxba0k);
        if (pinEntryEditText != null) {
            InputExtKt.MyBillsEntityDataFactory(pinEntryEditText);
        }
        getAuthRequestContext();
    }

    @Override // androidx.fragment.app.Fragment
    public final void onDestroy() {
        super.onDestroy();
        CountDownTimer countDownTimer = this.getAuthRequestContext;
        if (countDownTimer != null) {
            if (countDownTimer != null) {
                countDownTimer.cancel();
            }
            this.getAuthRequestContext = null;
        }
    }

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"Lid/dana/cardbinding/fragment/CardBindingOtpChallengeFragment$Companion;", "", "Landroid/os/Bundle;", "p0", "Lid/dana/cardbinding/fragment/CardBindingOtpChallengeFragment;", "MyBillsEntityDataFactory", "(Landroid/os/Bundle;)Lid/dana/cardbinding/fragment/CardBindingOtpChallengeFragment;", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes4.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public static CardBindingOtpChallengeFragment MyBillsEntityDataFactory(Bundle p0) {
            CardBindingOtpChallengeFragment cardBindingOtpChallengeFragment = new CardBindingOtpChallengeFragment();
            cardBindingOtpChallengeFragment.setArguments(p0);
            return cardBindingOtpChallengeFragment;
        }
    }

    public static /* synthetic */ void MyBillsEntityDataFactory(CardBindingOtpChallengeFragment cardBindingOtpChallengeFragment) {
        Intrinsics.checkNotNullParameter(cardBindingOtpChallengeFragment, "");
        String str = cardBindingOtpChallengeFragment.DatabaseTableConfigUtil;
        OtpCardBindingViewModel otpCardBindingViewModel = null;
        if (str == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            str = null;
        }
        int hashCode = str.hashCode();
        if (hashCode != -1075191160) {
            if (hashCode == -420010491) {
                if (str.equals("OTP_SMS")) {
                    OtpCardBindingViewModel otpCardBindingViewModel2 = cardBindingOtpChallengeFragment.moveToNextValue;
                    if (otpCardBindingViewModel2 != null) {
                        otpCardBindingViewModel = otpCardBindingViewModel2;
                    } else {
                        Intrinsics.throwUninitializedPropertyAccessException("");
                    }
                    OtpCardBindingViewModel.PlaceComponentResult(otpCardBindingViewModel, "AP_PAYMENT", "");
                    return;
                }
                return;
            } else if (hashCode != 2031363540 || !str.equals(VerificationMethod.SEND_OTP)) {
                return;
            }
        } else if (!str.equals(VerificationMethod.BANK_OTP)) {
            return;
        }
        SendBankOtpModel sendBankOtpModel = cardBindingOtpChallengeFragment.NetworkUserEntityData$$ExternalSyntheticLambda1;
        if (sendBankOtpModel != null) {
            if (cardBindingOtpChallengeFragment.PlaceComponentResult) {
                OtpCardBindingViewModel otpCardBindingViewModel3 = cardBindingOtpChallengeFragment.moveToNextValue;
                if (otpCardBindingViewModel3 != null) {
                    otpCardBindingViewModel = otpCardBindingViewModel3;
                } else {
                    Intrinsics.throwUninitializedPropertyAccessException("");
                }
                otpCardBindingViewModel.BuiltInFictitiousFunctionClassFactory(sendBankOtpModel);
                return;
            }
            OtpCardBindingViewModel otpCardBindingViewModel4 = cardBindingOtpChallengeFragment.moveToNextValue;
            if (otpCardBindingViewModel4 != null) {
                otpCardBindingViewModel = otpCardBindingViewModel4;
            } else {
                Intrinsics.throwUninitializedPropertyAccessException("");
            }
            OtpCardBindingViewModel.PlaceComponentResult(otpCardBindingViewModel, sendBankOtpModel);
        }
    }

    public static /* synthetic */ void getAuthRequestContext(CardBindingOtpChallengeFragment cardBindingOtpChallengeFragment) {
        Intrinsics.checkNotNullParameter(cardBindingOtpChallengeFragment, "");
        cardBindingOtpChallengeFragment.PlaceComponentResult(false);
    }

    public static /* synthetic */ void MyBillsEntityDataFactory(CardBindingOtpChallengeFragment cardBindingOtpChallengeFragment, CharSequence charSequence) {
        String str;
        Editable text;
        Intrinsics.checkNotNullParameter(cardBindingOtpChallengeFragment, "");
        String obj = charSequence.toString();
        CardBindingViewModel cardBindingViewModel = null;
        r12 = null;
        String str2 = null;
        CardBindingViewModel cardBindingViewModel2 = null;
        if (!cardBindingOtpChallengeFragment.PlaceComponentResult) {
            CashierPayMethodModel.CardPayMethod cardPayMethod = cardBindingOtpChallengeFragment.getErrorConfigVersion;
            if (cardPayMethod != null) {
                CashierPayMethodModel.CardPayMethod cardPayMethod2 = cardPayMethod;
                SendBankOtpModel sendBankOtpModel = cardBindingOtpChallengeFragment.NetworkUserEntityData$$ExternalSyntheticLambda1;
                String str3 = sendBankOtpModel != null ? sendBankOtpModel.moveToNextValue : null;
                String str4 = str3 == null ? "" : str3;
                String str5 = cardBindingOtpChallengeFragment.DatabaseTableConfigUtil;
                if (str5 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("");
                    str = null;
                } else {
                    str = str5;
                }
                CashierPayParamModel cashierPayParamModel = new CashierPayParamModel(str4, null, null, false, obj, str, cardPayMethod2, false, 142, null);
                if (cardBindingOtpChallengeFragment.BuiltInFictitiousFunctionClassFactory) {
                    CardBindingViewModel cardBindingViewModel3 = cardBindingOtpChallengeFragment.KClassImpl$Data$declaredNonStaticMembers$2;
                    if (cardBindingViewModel3 != null) {
                        cardBindingViewModel2 = cardBindingViewModel3;
                    } else {
                        Intrinsics.throwUninitializedPropertyAccessException("");
                    }
                    cardBindingViewModel2.MyBillsEntityDataFactory(cashierPayParamModel);
                    return;
                }
                CardBindingViewModel cardBindingViewModel4 = cardBindingOtpChallengeFragment.KClassImpl$Data$declaredNonStaticMembers$2;
                if (cardBindingViewModel4 != null) {
                    cardBindingViewModel = cardBindingViewModel4;
                } else {
                    Intrinsics.throwUninitializedPropertyAccessException("");
                }
                cardBindingViewModel.KClassImpl$Data$declaredNonStaticMembers$2(cashierPayParamModel);
                return;
            }
            return;
        }
        if (obj.length() > 0) {
            final OtpCardBindingViewModel otpCardBindingViewModel = cardBindingOtpChallengeFragment.moveToNextValue;
            if (otpCardBindingViewModel == null) {
                Intrinsics.throwUninitializedPropertyAccessException("");
                otpCardBindingViewModel = null;
            }
            SendBankOtpModel sendBankOtpModel2 = cardBindingOtpChallengeFragment.NetworkUserEntityData$$ExternalSyntheticLambda1;
            String str6 = sendBankOtpModel2 != null ? sendBankOtpModel2.moveToNextValue : null;
            if (str6 == null) {
                str6 = "";
            }
            String str7 = cardBindingOtpChallengeFragment.NetworkUserEntityData$$ExternalSyntheticLambda0;
            PinEntryEditText pinEntryEditText = (PinEntryEditText) cardBindingOtpChallengeFragment.BuiltInFictitiousFunctionClassFactory(R.id.res_0x7f0a067f_r8_lambda_tgidiae_3l8as7qvhbz6_rxba0k);
            if (pinEntryEditText != null && (text = pinEntryEditText.getText()) != null) {
                str2 = text.toString();
            }
            if (str2 == null) {
                str2 = "";
            }
            Intrinsics.checkNotNullParameter(str6, "");
            Intrinsics.checkNotNullParameter(str7, "");
            Intrinsics.checkNotNullParameter(str2, "");
            otpCardBindingViewModel.MyBillsEntityDataFactory.execute(CreateCashierAgreement.Params.INSTANCE.createSendBankOtpParam(str6, str7, str2), new Function0<Unit>() { // from class: id.dana.cardbinding.viewmodel.OtpCardBindingViewModel$createCashierAgreement$1
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public final /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke  reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    MutableStateFlow mutableStateFlow;
                    Object value;
                    mutableStateFlow = OtpCardBindingViewModel.this.PlaceComponentResult;
                    do {
                        value = mutableStateFlow.getValue();
                        OtpCardBindingUiState otpCardBindingUiState = (OtpCardBindingUiState) value;
                    } while (!mutableStateFlow.compareAndSet(value, OtpCardBindingUiState.ShowProgress.INSTANCE));
                }
            }, new Function1<CashierAgreementResponse, Unit>() { // from class: id.dana.cardbinding.viewmodel.OtpCardBindingViewModel$createCashierAgreement$2
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public final /* bridge */ /* synthetic */ Unit invoke(CashierAgreementResponse cashierAgreementResponse) {
                    invoke2(cashierAgreementResponse);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke  reason: avoid collision after fix types in other method */
                public final void invoke2(CashierAgreementResponse cashierAgreementResponse) {
                    MutableStateFlow mutableStateFlow;
                    Object value;
                    Intrinsics.checkNotNullParameter(cashierAgreementResponse, "");
                    mutableStateFlow = OtpCardBindingViewModel.this.PlaceComponentResult;
                    do {
                        value = mutableStateFlow.getValue();
                        OtpCardBindingUiState otpCardBindingUiState = (OtpCardBindingUiState) value;
                        CashierAgreementModelMapper cashierAgreementModelMapper = CashierAgreementModelMapper.INSTANCE;
                    } while (!mutableStateFlow.compareAndSet(value, new OtpCardBindingUiState.OnSuccessCashierAgreement(CashierAgreementModelMapper.MyBillsEntityDataFactory(cashierAgreementResponse))));
                }
            }, new Function1<Throwable, Unit>() { // from class: id.dana.cardbinding.viewmodel.OtpCardBindingViewModel$createCashierAgreement$3
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
                    MutableStateFlow mutableStateFlow;
                    Object value;
                    boolean contains;
                    MutableStateFlow mutableStateFlow2;
                    Object value2;
                    Intrinsics.checkNotNullParameter(th, "");
                    if (th instanceof NetworkException) {
                        CashierErrorHelper cashierErrorHelper = CashierErrorHelper.INSTANCE;
                        contains = CollectionsKt.contains(CashierErrorHelper.initRecordTimeStamp, ((NetworkException) th).getErrorCode());
                        if (contains) {
                            mutableStateFlow2 = OtpCardBindingViewModel.this.PlaceComponentResult;
                            do {
                                value2 = mutableStateFlow2.getValue();
                                OtpCardBindingUiState otpCardBindingUiState = (OtpCardBindingUiState) value2;
                            } while (!mutableStateFlow2.compareAndSet(value2, new OtpCardBindingUiState.OnCreateAgreementError(th.getMessage())));
                            return;
                        }
                    }
                    mutableStateFlow = OtpCardBindingViewModel.this.PlaceComponentResult;
                    do {
                        value = mutableStateFlow.getValue();
                        OtpCardBindingUiState otpCardBindingUiState2 = (OtpCardBindingUiState) value;
                    } while (!mutableStateFlow.compareAndSet(value, new OtpCardBindingUiState.OnError(th.getMessage())));
                }
            }, new Function0<Unit>() { // from class: id.dana.cardbinding.viewmodel.OtpCardBindingViewModel$createCashierAgreement$4
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public final /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke  reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    MutableStateFlow mutableStateFlow;
                    Object value;
                    mutableStateFlow = OtpCardBindingViewModel.this.PlaceComponentResult;
                    do {
                        value = mutableStateFlow.getValue();
                        OtpCardBindingUiState otpCardBindingUiState = (OtpCardBindingUiState) value;
                    } while (!mutableStateFlow.compareAndSet(value, OtpCardBindingUiState.DismissProgress.INSTANCE));
                }
            }, ViewModelKt.PlaceComponentResult(otpCardBindingViewModel));
        }
    }

    public static final /* synthetic */ void PlaceComponentResult(CardBindingOtpChallengeFragment cardBindingOtpChallengeFragment) {
        LogoProgressView logoProgressView = (LogoProgressView) cardBindingOtpChallengeFragment.BuiltInFictitiousFunctionClassFactory(R.id.lpvLoading);
        if (logoProgressView != null) {
            logoProgressView.setVisibility(8);
            logoProgressView.stopRefresh();
        }
        ChallengeScenarioListener challengeScenarioListener = cardBindingOtpChallengeFragment.NetworkUserEntityData$$ExternalSyntheticLambda2;
        if (challengeScenarioListener == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            challengeScenarioListener = null;
        }
        challengeScenarioListener.showClose();
    }

    public static final /* synthetic */ void BuiltInFictitiousFunctionClassFactory(CardBindingOtpChallengeFragment cardBindingOtpChallengeFragment) {
        ChallengeScenarioListener challengeScenarioListener = cardBindingOtpChallengeFragment.NetworkUserEntityData$$ExternalSyntheticLambda2;
        if (challengeScenarioListener == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            challengeScenarioListener = null;
        }
        challengeScenarioListener.onNext(null, null);
    }

    public static final /* synthetic */ void NetworkUserEntityData$$ExternalSyntheticLambda0(CardBindingOtpChallengeFragment cardBindingOtpChallengeFragment) {
        TextView textView = (TextView) cardBindingOtpChallengeFragment.BuiltInFictitiousFunctionClassFactory(R.id.ViewholderFriendListEmptyBinding);
        if (textView != null) {
            textView.setOnClickListener(new CardBindingOtpChallengeFragment$$ExternalSyntheticLambda1(cardBindingOtpChallengeFragment));
        }
        cardBindingOtpChallengeFragment.PlaceComponentResult();
        cardBindingOtpChallengeFragment.MyBillsEntityDataFactory();
        cardBindingOtpChallengeFragment.PlaceComponentResult(true);
        CardBindingOtpChallengeFragment$getCountdownTimer$1 cardBindingOtpChallengeFragment$getCountdownTimer$1 = new CardBindingOtpChallengeFragment$getCountdownTimer$1(cardBindingOtpChallengeFragment, TimeUnit.SECONDS.toMillis(cardBindingOtpChallengeFragment.initRecordTimeStamp), TimeUnit.SECONDS.toMillis(1L));
        cardBindingOtpChallengeFragment.getAuthRequestContext = cardBindingOtpChallengeFragment$getCountdownTimer$1;
        cardBindingOtpChallengeFragment$getCountdownTimer$1.start();
        cardBindingOtpChallengeFragment.addDisposable(cardBindingOtpChallengeFragment.KClassImpl$Data$declaredNonStaticMembers$2());
    }

    public static final /* synthetic */ void scheduleImpl(CardBindingOtpChallengeFragment cardBindingOtpChallengeFragment) {
        TextView textView = (TextView) cardBindingOtpChallengeFragment.BuiltInFictitiousFunctionClassFactory(R.id.setMinusSignString);
        if (textView != null) {
            textView.postDelayed(new Runnable() { // from class: id.dana.cardbinding.fragment.CardBindingOtpChallengeFragment$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    CardBindingOtpChallengeFragment.getAuthRequestContext(CardBindingOtpChallengeFragment.this);
                }
            }, 300L);
        }
    }

    public static final /* synthetic */ void getAuthRequestContext(CardBindingOtpChallengeFragment cardBindingOtpChallengeFragment, int i) {
        if (i > 0) {
            cardBindingOtpChallengeFragment.scheduleImpl = i;
        }
    }

    public static final /* synthetic */ void getErrorConfigVersion(CardBindingOtpChallengeFragment cardBindingOtpChallengeFragment) {
        ChallengeScenarioListener challengeScenarioListener = null;
        cardBindingOtpChallengeFragment.getAuthRequestContext((String) null);
        PinEntryEditText pinEntryEditText = (PinEntryEditText) cardBindingOtpChallengeFragment.BuiltInFictitiousFunctionClassFactory(R.id.res_0x7f0a067f_r8_lambda_tgidiae_3l8as7qvhbz6_rxba0k);
        if (pinEntryEditText != null) {
            pinEntryEditText.setVisibility(4);
        }
        LogoProgressView logoProgressView = (LogoProgressView) cardBindingOtpChallengeFragment.BuiltInFictitiousFunctionClassFactory(R.id.lpvLoading);
        if (logoProgressView != null) {
            logoProgressView.setVisibility(0);
            logoProgressView.startRefresh();
        }
        ChallengeScenarioListener challengeScenarioListener2 = cardBindingOtpChallengeFragment.NetworkUserEntityData$$ExternalSyntheticLambda2;
        if (challengeScenarioListener2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
        } else {
            challengeScenarioListener = challengeScenarioListener2;
        }
        challengeScenarioListener.hideClose();
    }

    public static final /* synthetic */ void lookAheadTest(CardBindingOtpChallengeFragment cardBindingOtpChallengeFragment) {
        PinEntryEditText pinEntryEditText = (PinEntryEditText) cardBindingOtpChallengeFragment.BuiltInFictitiousFunctionClassFactory(R.id.res_0x7f0a067f_r8_lambda_tgidiae_3l8as7qvhbz6_rxba0k);
        if (pinEntryEditText != null) {
            pinEntryEditText.setVisibility(4);
        }
        ImageView imageView = (ImageView) cardBindingOtpChallengeFragment.BuiltInFictitiousFunctionClassFactory(R.id.SharedPreferencesUtils);
        if (imageView != null) {
            imageView.setVisibility(0);
        }
    }

    @Override // id.dana.base.BaseFragment
    public final void init() {
        DaggerCardBindingComponent.Builder MyBillsEntityDataFactory = DaggerCardBindingComponent.MyBillsEntityDataFactory();
        MyBillsEntityDataFactory.KClassImpl$Data$declaredNonStaticMembers$2 = (ApplicationComponent) Preconditions.getAuthRequestContext(getApplicationComponent());
        MyBillsEntityDataFactory.BuiltInFictitiousFunctionClassFactory().MyBillsEntityDataFactory(this);
        Bundle arguments = getArguments();
        if (arguments != null) {
            String string = arguments.getString(ChallengeControl.Key.VERIFICATION_METHOD);
            if (string == null) {
                string = "";
            }
            this.DatabaseTableConfigUtil = string;
            this.NetworkUserEntityData$$ExternalSyntheticLambda1 = (SendBankOtpModel) arguments.getParcelable(ChallengeControl.Key.BANK_OTP_MODEL);
            int i = arguments.getInt(ChallengeControl.Key.OTP_CODE_LENGTH);
            if (i > 0) {
                this.scheduleImpl = i;
            }
            this.initRecordTimeStamp = arguments.getInt(ChallengeControl.Key.RETRY_SEND_SECONDS);
            String string2 = arguments.getString(ChallengeControl.Key.PHONE_NUMBER);
            if (string2 == null) {
                string2 = "";
            }
            this.NetworkUserEntityData$$ExternalSyntheticLambda0 = string2;
            this.BuiltInFictitiousFunctionClassFactory = arguments.getBoolean(ChallengeControl.Key.IS_RISK_PHASE_2);
            this.PlaceComponentResult = arguments.getBoolean(ChallengeControl.Key.IS_BINDING_DIRECT_DEBIT);
            this.getErrorConfigVersion = (CashierPayMethodModel.CardPayMethod) arguments.getParcelable(ChallengeControl.Key.PAY_METHOD_MODEL);
        }
        CardBindingOtpChallengeFragment cardBindingOtpChallengeFragment = this;
        ViewModelFactory viewModelFactory = this.viewModelFactory;
        ViewModelFactory viewModelFactory2 = null;
        if (viewModelFactory == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            viewModelFactory = null;
        }
        CardBindingViewModel cardBindingViewModel = (CardBindingViewModel) new ViewModelProvider(cardBindingOtpChallengeFragment, viewModelFactory).MyBillsEntityDataFactory(CardBindingViewModel.class);
        Intrinsics.checkNotNullParameter(cardBindingViewModel, "");
        this.KClassImpl$Data$declaredNonStaticMembers$2 = cardBindingViewModel;
        ViewModelFactory viewModelFactory3 = this.viewModelFactory;
        if (viewModelFactory3 != null) {
            viewModelFactory2 = viewModelFactory3;
        } else {
            Intrinsics.throwUninitializedPropertyAccessException("");
        }
        OtpCardBindingViewModel otpCardBindingViewModel = (OtpCardBindingViewModel) new ViewModelProvider(cardBindingOtpChallengeFragment, viewModelFactory2).MyBillsEntityDataFactory(OtpCardBindingViewModel.class);
        Intrinsics.checkNotNullParameter(otpCardBindingViewModel, "");
        this.moveToNextValue = otpCardBindingViewModel;
        TextView textView = (TextView) BuiltInFictitiousFunctionClassFactory(R.id.ViewholderFriendListEmptyBinding);
        if (textView != null) {
            textView.setOnClickListener(new CardBindingOtpChallengeFragment$$ExternalSyntheticLambda1(this));
        }
        PlaceComponentResult();
        MyBillsEntityDataFactory();
        PlaceComponentResult(true);
        CardBindingOtpChallengeFragment$getCountdownTimer$1 cardBindingOtpChallengeFragment$getCountdownTimer$1 = new CardBindingOtpChallengeFragment$getCountdownTimer$1(this, TimeUnit.SECONDS.toMillis(this.initRecordTimeStamp), TimeUnit.SECONDS.toMillis(1L));
        this.getAuthRequestContext = cardBindingOtpChallengeFragment$getCountdownTimer$1;
        cardBindingOtpChallengeFragment$getCountdownTimer$1.start();
        addDisposable(KClassImpl$Data$declaredNonStaticMembers$2());
    }

    @Override // id.dana.base.BaseFragment, androidx.fragment.app.Fragment
    public final /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        this.KClassImpl$Data$declaredNonStaticMembers$2.clear();
    }
}
