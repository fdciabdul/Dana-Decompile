package id.dana.cashier.fragment;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.text.Editable;
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
import com.alibaba.griver.image.photo.utils.DiskFormatter;
import com.anggrayudi.storage.permission.FragmentPermissionRequest;
import com.ethanhua.skeleton.SkeletonScreen;
import com.ethanhua.skeleton.ViewSkeletonScreen;
import com.google.android.gms.auth.api.phone.SmsRetriever;
import com.jakewharton.rxbinding2.widget.RxTextView;
import dagger.internal.Preconditions;
import id.dana.R;
import id.dana.analytics.tracker.TrackerKey;
import id.dana.base.AbstractContract;
import id.dana.cashier.CashierAddOnModule;
import id.dana.cashier.CashierAddOnViewListener;
import id.dana.cashier.CashierCardBindingModule;
import id.dana.cashier.CashierHighlightModule;
import id.dana.cashier.CashierHighlightViewListener;
import id.dana.cashier.CashierPayLaterModule;
import id.dana.cashier.CashierPayLaterViewListener;
import id.dana.cashier.CashierRiskChallengeContract;
import id.dana.cashier.CashierUserRelatedModule;
import id.dana.cashier.CashierUserRelatedViewListener;
import id.dana.cashier.CashierViewListener;
import id.dana.cashier.RiskParamsFactory;
import id.dana.cashier.TopUpAndPayContract;
import id.dana.cashier.VerificationMethod;
import id.dana.cashier.domain.interactor.CreateCashierAgreement;
import id.dana.cashier.domain.model.CashierAgreementResponse;
import id.dana.cashier.domain.model.CheckoutExternalInfo;
import id.dana.cashier.fragment.PaymentResultFragment;
import id.dana.cashier.helper.CashierErrorHelper;
import id.dana.cashier.helper.CashierErrorState;
import id.dana.cashier.helper.CashierErrorType;
import id.dana.cashier.mapper.CashierAgreementModelMapper;
import id.dana.cashier.model.AddOnTrackingModel;
import id.dana.cashier.model.AttributeCashierPayModel;
import id.dana.cashier.model.CashierAgreementModel;
import id.dana.cashier.model.CashierCheckoutRequestModel;
import id.dana.cashier.model.CashierFaceAuthModel;
import id.dana.cashier.model.CashierPayMethodModel;
import id.dana.cashier.model.CashierPayMethodModelKt;
import id.dana.cashier.model.CashierPayModel;
import id.dana.cashier.model.PayResultModel;
import id.dana.cashier.model.PaylaterCashierRequestCheckoutModel;
import id.dana.cashier.model.SendBankOtpModel;
import id.dana.cashier.model.TopUpPayModel;
import id.dana.cashier.model.TopUpVerifyRequestModel;
import id.dana.cashier.model.VoucherCashierModel;
import id.dana.cashier.model.tracker.PaymentExecutionTrackerParams;
import id.dana.cashier.presenter.CashierPresenter;
import id.dana.cashier.presenter.CashierRiskChallengePresenter;
import id.dana.cashier.tracker.CashierAnalyticTracker;
import id.dana.cashier.utils.CashierKeyParams;
import id.dana.cashier.utils.CashierOtpUtil;
import id.dana.component.customtoastcomponent.CustomToast;
import id.dana.component.dialogcomponent.CustomDialog;
import id.dana.component.dialogcomponent.CustomDialog$sam$android_view_View_OnClickListener$0;
import id.dana.core.ui.richview.PinEntryEditText;
import id.dana.databinding.FragmentCashierOtpChallengeBinding;
import id.dana.di.component.ApplicationComponent;
import id.dana.di.component.DaggerCashierComponent;
import id.dana.di.modules.CashierAnalyticModule;
import id.dana.di.modules.CashierModule;
import id.dana.di.modules.CashierRiskChallengeModule;
import id.dana.di.modules.TopUpAndPayModule;
import id.dana.domain.useragreement.model.AgreementInfo;
import id.dana.extension.view.InputExtKt;
import id.dana.network.exception.NetworkException;
import id.dana.pay.PayActivity;
import id.dana.richview.DanaProtectionLoadingView;
import id.dana.sendmoney.summary.SummaryActivity;
import id.dana.utils.KeyboardHelper;
import id.dana.utils.LocationUtil;
import id.dana.utils.ShimmeringUtil;
import id.dana.utils.SizeUtil;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Predicate;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.JvmName;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0092\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\t\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 `2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001`B\u0007¢\u0006\u0004\b_\u0010\u0012J\u0017\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0014¢\u0006\u0004\b\u0006\u0010\u0007JC\u0010\u000f\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\b2\b\u0010\n\u001a\u0004\u0018\u00010\b2\u0006\u0010\u000b\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\rH\u0014¢\u0006\u0004\b\u000f\u0010\u0010J\u000f\u0010\u0011\u001a\u00020\u0005H\u0014¢\u0006\u0004\b\u0011\u0010\u0012J\u000f\u0010\u0013\u001a\u00020\u0005H\u0014¢\u0006\u0004\b\u0013\u0010\u0012J\u000f\u0010\u0014\u001a\u00020\u0005H\u0014¢\u0006\u0004\b\u0014\u0010\u0012J\u000f\u0010\u0015\u001a\u00020\u0005H\u0014¢\u0006\u0004\b\u0015\u0010\u0012J)\u0010\u0018\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u00162\u0006\u0010\t\u001a\u00020\u00162\b\u0010\n\u001a\u0004\u0018\u00010\u0017H\u0016¢\u0006\u0004\b\u0018\u0010\u0019J\u000f\u0010\u001a\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u001a\u0010\u0012J\u000f\u0010\u001b\u001a\u00020\u0005H\u0014¢\u0006\u0004\b\u001b\u0010\u0012J\u0017\u0010\u000f\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u001cH\u0016¢\u0006\u0004\b\u000f\u0010\u001dJ\u000f\u0010\u001e\u001a\u00020\u0005H\u0014¢\u0006\u0004\b\u001e\u0010\u0012J\u000f\u0010\u001f\u001a\u00020\u0005H\u0014¢\u0006\u0004\b\u001f\u0010\u0012J\u000f\u0010 \u001a\u00020\u0005H\u0002¢\u0006\u0004\b \u0010\u0012J\u0017\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\rH\u0002¢\u0006\u0004\b\u0006\u0010!J\u000f\u0010\"\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\"\u0010\u0012J\u000f\u0010#\u001a\u00020\u0005H\u0002¢\u0006\u0004\b#\u0010\u0012J\u0017\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\bH\u0002¢\u0006\u0004\b\u0006\u0010$J\u000f\u0010%\u001a\u00020\u0005H\u0016¢\u0006\u0004\b%\u0010\u0012J\u0017\u0010&\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\rH\u0002¢\u0006\u0004\b&\u0010!J\u0017\u0010\u000f\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\rH\u0014¢\u0006\u0004\b\u000f\u0010!R\u0018\u0010\u0006\u001a\u0004\u0018\u00010'8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b(\u0010)R\u0016\u0010\u000f\u001a\u0004\u0018\u00010*8\u0002X\u0082\u0006¢\u0006\u0006\n\u0004\b+\u0010,R\u0016\u0010/\u001a\u00020\b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b-\u0010.R\u0012\u00101\u001a\u000200X\u0087\"¢\u0006\u0006\n\u0004\b1\u00102R\u0016\u00103\u001a\u00020\b8\u0002@\u0002X\u0083.¢\u0006\u0006\n\u0004\b\u0014\u0010.R\u0012\u00105\u001a\u000204X\u0087\"¢\u0006\u0006\n\u0004\b5\u00106R\u0012\u00108\u001a\u000207X\u0087\"¢\u0006\u0006\n\u0004\b8\u00109R\u001e\u0010&\u001a\n\u0012\u0004\u0012\u00020;\u0018\u00010:8\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\b<\u0010=R\u0018\u0010@\u001a\u0004\u0018\u00010>8\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\b\u0013\u0010?R\u0016\u0010B\u001a\u00020\b8\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\bA\u0010.R\u0018\u0010D\u001a\u0004\u0018\u00010\u00168\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\b\u0015\u0010CR\u0018\u0010E\u001a\u0004\u0018\u00010\b8\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\b\u0011\u0010.R*\u0010H\u001a\u00020\r2\u0006\u0010\u0004\u001a\u00020\r8\u0015@UX\u0095\u000e¢\u0006\u0012\n\u0004\b\u001e\u0010F\u001a\u0004\bD\u0010G\"\u0004\b/\u0010!R\u0016\u0010I\u001a\u00020\r8\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\b\u001f\u0010FR\u0016\u0010<\u001a\u00020\r8\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\bJ\u0010FR\u0016\u0010K\u001a\u00020\r8\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\b\u001b\u0010FR\u0016\u0010(\u001a\u00020\r8\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\bL\u0010FR\u0018\u0010O\u001a\u0004\u0018\u00010M8\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\b#\u0010NR\u0018\u0010+\u001a\u0004\u0018\u00010\b8\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\bP\u0010.R\u0016\u0010-\u001a\u00020\b8\u0002@\u0002X\u0083.¢\u0006\u0006\n\u0004\b%\u0010.R\u0016\u0010Q\u001a\u00020\b8\u0002@\u0002X\u0083.¢\u0006\u0006\n\u0004\b\"\u0010.R\u0014\u0010S\u001a\u00020\u00168\u0002X\u0083\u0006¢\u0006\u0006\n\u0004\b \u0010RR\u0016\u0010U\u001a\u00020\b8\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\bT\u0010.R\u0016\u0010A\u001a\u00020\u00168\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\bV\u0010RR\u001c\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\b0:8\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\bW\u0010=R\u0016\u0010\u0014\u001a\u00020X8\u0002@\u0002X\u0083.¢\u0006\u0006\n\u0004\bY\u0010ZR\u0012\u0010\\\u001a\u00020[X\u0087\"¢\u0006\u0006\n\u0004\b\\\u0010]R\u0016\u0010\u0011\u001a\u00020\b8\u0002@\u0002X\u0083.¢\u0006\u0006\n\u0004\b^\u0010."}, d2 = {"Lid/dana/cashier/fragment/CashierOtpChallengeFragment;", "Lid/dana/cashier/fragment/BaseCashierRiskFragment;", "Lid/dana/databinding/FragmentCashierOtpChallengeBinding;", "Lid/dana/cashier/helper/CashierErrorState;", "p0", "", "PlaceComponentResult", "(Lid/dana/cashier/helper/CashierErrorState;)V", "", "p1", "p2", "p3", "p4", "", "p5", "getAuthRequestContext", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Z)V", "FragmentBottomSheetPaymentSettingBinding", "()V", "NetworkUserEntityData$$ExternalSyntheticLambda6", "NetworkUserEntityData$$ExternalSyntheticLambda3", "NetworkUserEntityData$$ExternalSyntheticLambda4", "", "Landroid/content/Intent;", "onActivityResult", "(IILandroid/content/Intent;)V", "onDestroyView", "getCallingPid", "Lid/dana/cashier/RiskParamsFactory;", "(Lid/dana/cashier/RiskParamsFactory;)V", "readMicros", "whenAvailable", DiskFormatter.B, "(Z)V", "VerifyPinStateManager$executeRiskChallenge$2$1", "C", "(Ljava/lang/String;)V", "A", "MyBillsEntityDataFactory", "Lid/dana/domain/useragreement/model/AgreementInfo;", "NetworkUserEntityData$$ExternalSyntheticLambda1", "Lid/dana/domain/useragreement/model/AgreementInfo;", "Lid/dana/cashier/model/AttributeCashierPayModel;", "NetworkUserEntityData$$ExternalSyntheticLambda7", "Lid/dana/cashier/model/AttributeCashierPayModel;", "isLayoutRequested", "Ljava/lang/String;", "KClassImpl$Data$declaredNonStaticMembers$2", "Lid/dana/cashier/tracker/CashierAnalyticTracker;", "cashierAnalyticTracker", "Lid/dana/cashier/tracker/CashierAnalyticTracker;", "BuiltInFictitiousFunctionClassFactory", "Lid/dana/cashier/presenter/CashierPresenter;", "cashierPresenter", "Lid/dana/cashier/presenter/CashierPresenter;", "Lid/dana/cashier/presenter/CashierRiskChallengePresenter;", "cashierRiskChallengePresenter", "Lid/dana/cashier/presenter/CashierRiskChallengePresenter;", "", "Lcom/ethanhua/skeleton/SkeletonScreen;", "initRecordTimeStamp", "Ljava/util/List;", "Landroid/os/CountDownTimer;", "Landroid/os/CountDownTimer;", "scheduleImpl", "NetworkUserEntityData$$ExternalSyntheticLambda5", "NetworkUserEntityData$$ExternalSyntheticLambda0", "Ljava/lang/Integer;", "moveToNextValue", "lookAheadTest", "Z", "()Z", "getErrorConfigVersion", "GetContactSyncConfig", "SubSequence", "NetworkUserEntityData$$ExternalSyntheticLambda2", "getSupportButtonTintMode", "", "Ljava/lang/Long;", "DatabaseTableConfigUtil", "BottomSheetCardBindingView$watcherCardNumberView$1", "NetworkUserEntityData$$ExternalSyntheticLambda8", "I", "newProxyInstance", "VerifyPinStateManager$executeRiskChallenge$2$2", "PrepareContext", SummaryActivity.DAYS, "getValueOfTouchPositionAbsolute", "Lid/dana/cashier/model/CashierPayMethodModel;", "getOnBoardingScenario", "Lid/dana/cashier/model/CashierPayMethodModel;", "Lid/dana/cashier/TopUpAndPayContract$Presenter;", "topUpAndPayPresenter", "Lid/dana/cashier/TopUpAndPayContract$Presenter;", "E", "<init>", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class CashierOtpChallengeFragment extends BaseCashierRiskFragment<FragmentCashierOtpChallengeBinding> {

    /* renamed from: Companion  reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: A  reason: from kotlin metadata */
    private String isLayoutRequested;

    /* renamed from: BottomSheetCardBindingView$watcherCardNumberView$1  reason: from kotlin metadata */
    private String NetworkUserEntityData$$ExternalSyntheticLambda7;

    /* renamed from: C  reason: from kotlin metadata */
    private Long DatabaseTableConfigUtil;

    /* renamed from: D */
    private int NetworkUserEntityData$$ExternalSyntheticLambda5;

    /* renamed from: E  reason: from kotlin metadata */
    private String FragmentBottomSheetPaymentSettingBinding;

    /* renamed from: FragmentBottomSheetPaymentSettingBinding  reason: from kotlin metadata */
    private String lookAheadTest;

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda1  reason: from kotlin metadata */
    private AgreementInfo PlaceComponentResult;

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda3  reason: from kotlin metadata */
    private String BuiltInFictitiousFunctionClassFactory;

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda4  reason: from kotlin metadata */
    private Integer moveToNextValue;

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda6  reason: from kotlin metadata */
    private CountDownTimer scheduleImpl;

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda7  reason: from kotlin metadata */
    private AttributeCashierPayModel getAuthRequestContext;

    /* renamed from: SubSequence  reason: from kotlin metadata */
    private boolean initRecordTimeStamp;

    /* renamed from: VerifyPinStateManager$executeRiskChallenge$2$1  reason: from kotlin metadata */
    private String NetworkUserEntityData$$ExternalSyntheticLambda8;
    @Inject
    public CashierAnalyticTracker cashierAnalyticTracker;
    @Inject
    public CashierPresenter cashierPresenter;
    @Inject
    public CashierRiskChallengePresenter cashierRiskChallengePresenter;

    /* renamed from: getCallingPid  reason: from kotlin metadata */
    private boolean NetworkUserEntityData$$ExternalSyntheticLambda2;

    /* renamed from: getOnBoardingScenario  reason: from kotlin metadata */
    private CashierPayMethodModel NetworkUserEntityData$$ExternalSyntheticLambda3;

    /* renamed from: getSupportButtonTintMode  reason: from kotlin metadata */
    private boolean NetworkUserEntityData$$ExternalSyntheticLambda1;

    /* renamed from: initRecordTimeStamp  reason: from kotlin metadata */
    List<? extends SkeletonScreen> MyBillsEntityDataFactory;

    /* renamed from: readMicros  reason: from kotlin metadata */
    private boolean getErrorConfigVersion;
    @Inject
    public TopUpAndPayContract.Presenter topUpAndPayPresenter;

    /* renamed from: whenAvailable  reason: from kotlin metadata */
    private boolean GetContactSyncConfig;
    public Map<Integer, View> GetContactSyncConfig = new LinkedHashMap();

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda5  reason: from kotlin metadata */
    private String NetworkUserEntityData$$ExternalSyntheticLambda0 = "";

    /* renamed from: VerifyPinStateManager$executeRiskChallenge$2$2  reason: from kotlin metadata */
    private String PrepareContext = "";

    /* renamed from: isLayoutRequested  reason: from kotlin metadata */
    private String KClassImpl$Data$declaredNonStaticMembers$2 = "";

    /* renamed from: B */
    private int newProxyInstance = 6;

    /* renamed from: getValueOfTouchPositionAbsolute  reason: from kotlin metadata */
    private List<String> NetworkUserEntityData$$ExternalSyntheticLambda4 = CollectionsKt.emptyList();

    @Override // id.dana.cashier.fragment.BaseCashierRiskFragment, id.dana.cashier.fragment.BaseVBCashierFragment, id.dana.core.ui.BaseViewBindingFragment
    public final View getAuthRequestContext(int i) {
        View findViewById;
        Map<Integer, View> map = this.GetContactSyncConfig;
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
        this.GetContactSyncConfig.clear();
    }

    @Override // id.dana.core.ui.BaseViewBindingFragment
    public final /* synthetic */ ViewBinding MyBillsEntityDataFactory(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        Intrinsics.checkNotNullParameter(layoutInflater, "");
        FragmentCashierOtpChallengeBinding BuiltInFictitiousFunctionClassFactory = FragmentCashierOtpChallengeBinding.BuiltInFictitiousFunctionClassFactory(layoutInflater);
        Intrinsics.checkNotNullExpressionValue(BuiltInFictitiousFunctionClassFactory, "");
        return BuiltInFictitiousFunctionClassFactory;
    }

    @Override // id.dana.cashier.fragment.BaseCashierRiskFragment
    @JvmName(name = "moveToNextValue")
    /* renamed from: moveToNextValue  reason: from getter */
    public final boolean getGetErrorConfigVersion() {
        return this.getErrorConfigVersion;
    }

    @Override // id.dana.cashier.fragment.BaseCashierRiskFragment
    @JvmName(name = "KClassImpl$Data$declaredNonStaticMembers$2")
    protected final void KClassImpl$Data$declaredNonStaticMembers$2(boolean z) {
        this.getErrorConfigVersion = z;
        if (!getGetErrorConfigVersion() || ((BaseCashierRiskFragment) this).BuiltInFictitiousFunctionClassFactory == null) {
            return;
        }
        NetworkUserEntityData$$ExternalSyntheticLambda0();
        VB vb = this.PlaceComponentResult;
        if (vb != 0) {
            Group group = ((FragmentCashierOtpChallengeBinding) vb).getErrorConfigVersion.BuiltInFictitiousFunctionClassFactory;
            if (group != null) {
                Intrinsics.checkNotNullExpressionValue(group, "");
                group.setVisibility(0);
                return;
            }
            return;
        }
        throw new IllegalArgumentException("Required value was null.".toString());
    }

    @Override // id.dana.cashier.fragment.BaseVBCashierFragment, id.dana.core.ui.BaseViewBindingFragment
    public final void FragmentBottomSheetPaymentSettingBinding() {
        super.FragmentBottomSheetPaymentSettingBinding();
        if (!this.NetworkUserEntityData$$ExternalSyntheticLambda1) {
            PlaceComponentResult(true);
            return;
        }
        FragmentActivity activity = getActivity();
        if (activity != null) {
            CashierOtpUtil cashierOtpUtil = CashierOtpUtil.INSTANCE;
            CashierOtpUtil.BuiltInFictitiousFunctionClassFactory(activity, new CashierOtpChallengeFragment$listenSmsReceiver$1$1(this));
        }
        C();
        B();
        MyBillsEntityDataFactory(true);
        CashierOtpChallengeFragment$getCountdownTimer$1 cashierOtpChallengeFragment$getCountdownTimer$1 = new CashierOtpChallengeFragment$getCountdownTimer$1(this, TimeUnit.SECONDS.toMillis(this.NetworkUserEntityData$$ExternalSyntheticLambda5), TimeUnit.SECONDS.toMillis(1L));
        this.scheduleImpl = cashierOtpChallengeFragment$getCountdownTimer$1;
        cashierOtpChallengeFragment$getCountdownTimer$1.start();
    }

    @Override // androidx.fragment.app.Fragment
    public final void onActivityResult(int p0, int p1, Intent p2) {
        super.onActivityResult(p0, p1, p2);
        if (p0 == 1 && p1 == -1 && p2 != null) {
            String stringExtra = p2.getStringExtra(SmsRetriever.EXTRA_SMS_MESSAGE);
            CashierOtpUtil cashierOtpUtil = CashierOtpUtil.INSTANCE;
            String MyBillsEntityDataFactory = CashierOtpUtil.MyBillsEntityDataFactory(stringExtra);
            VB vb = this.PlaceComponentResult;
            if (vb != 0) {
                ((FragmentCashierOtpChallengeBinding) vb).KClassImpl$Data$declaredNonStaticMembers$2.setText(MyBillsEntityDataFactory);
                return;
            }
            throw new IllegalArgumentException("Required value was null.".toString());
        }
    }

    @Override // id.dana.cashier.fragment.BaseCashierRiskFragment, id.dana.cashier.fragment.BaseVBCashierFragment, id.dana.core.ui.BaseViewBindingFragment, androidx.fragment.app.Fragment
    public final void onDestroyView() {
        super.onDestroyView();
        CountDownTimer countDownTimer = this.scheduleImpl;
        if (countDownTimer != null) {
            if (countDownTimer != null) {
                countDownTimer.cancel();
            }
            this.scheduleImpl = null;
        }
        this.GetContactSyncConfig.clear();
    }

    @Override // id.dana.cashier.fragment.BaseVBCashierFragment
    protected final void whenAvailable() {
        List<String> list;
        Bundle arguments = getArguments();
        if (arguments != null) {
            String string = arguments.getString(CashierKeyParams.CASHIER_ORDER_ID);
            if (string == null) {
                string = "";
            }
            this.BuiltInFictitiousFunctionClassFactory = string;
            AttributeCashierPayModel attributeCashierPayModel = (AttributeCashierPayModel) arguments.getParcelable(CashierKeyParams.ATTRIBUTE_CASHIER_PAY);
            this.getAuthRequestContext = attributeCashierPayModel;
            List<String> list2 = null;
            String str = attributeCashierPayModel != null ? attributeCashierPayModel.KClassImpl$Data$declaredNonStaticMembers$2 : null;
            if (str == null) {
                str = "";
            }
            Intrinsics.checkNotNullParameter(str, "");
            this.getErrorConfigVersion = str;
            ((BaseCashierRiskFragment) this).NetworkUserEntityData$$ExternalSyntheticLambda0 = (CashierPayMethodModel) arguments.getParcelable(CashierKeyParams.CASHIER_PAY_METHOD);
            String string2 = arguments.getString(CashierKeyParams.MASKED_PHONE_NO, "");
            Intrinsics.checkNotNullExpressionValue(string2, "");
            this.isLayoutRequested = string2;
            String string3 = arguments.getString(CashierKeyParams.VERIFICATION_METHOD, "");
            Intrinsics.checkNotNullExpressionValue(string3, "");
            this.FragmentBottomSheetPaymentSettingBinding = string3;
            this.initRecordTimeStamp = arguments.getBoolean(CashierKeyParams.RISK_PHASE_2);
            String string4 = arguments.getString("ektp");
            if (string4 == null) {
                string4 = "";
            }
            this.NetworkUserEntityData$$ExternalSyntheticLambda0 = string4;
            String string5 = arguments.getString("phoneNumber");
            if (string5 == null) {
                string5 = "";
            }
            this.PrepareContext = string5;
            String string6 = arguments.getString("bankAccountNo");
            if (string6 == null) {
                string6 = "";
            }
            this.KClassImpl$Data$declaredNonStaticMembers$2 = string6;
            this.NetworkUserEntityData$$ExternalSyntheticLambda5 = arguments.getInt("retrySendSeconds", -1);
            this.DatabaseTableConfigUtil = Long.valueOf(arguments.getLong("limitAmountDaily", 0L));
            MyBillsEntityDataFactory((PayResultModel) arguments.getParcelable(CashierKeyParams.PAY_RESULT_MODEL));
            KClassImpl$Data$declaredNonStaticMembers$2(arguments.getBoolean(CashierKeyParams.IS_BINDING_PAY));
            MyBillsEntityDataFactory((VoucherCashierModel) arguments.getParcelable(CashierKeyParams.VOUCHER_PROMO));
            this.NetworkUserEntityData$$ExternalSyntheticLambda1 = arguments.getBoolean(CashierKeyParams.IS_VERIFY_BANK_PHONE_OTP);
            int i = arguments.getInt("otpCodeLength");
            if (i > 0) {
                this.newProxyInstance = i;
            }
            String[] stringArray = arguments.getStringArray(CashierKeyParams.CASHIER_ORDER_GOODS);
            if (stringArray != null) {
                Intrinsics.checkNotNullExpressionValue(stringArray, "");
                list = ArraysKt.toList(stringArray);
            } else {
                list = null;
            }
            BuiltInFictitiousFunctionClassFactory(list);
            this.NetworkUserEntityData$$ExternalSyntheticLambda2 = arguments.getBoolean("isRefreshCashierInfoAndPay", false);
            String[] stringArray2 = arguments.getStringArray("selectedAddonsName");
            if (stringArray2 != null) {
                Intrinsics.checkNotNullExpressionValue(stringArray2, "");
                list2 = ArraysKt.toList(stringArray2);
            }
            if (list2 == null) {
                list2 = CollectionsKt.emptyList();
            }
            this.NetworkUserEntityData$$ExternalSyntheticLambda4 = list2;
            MyBillsEntityDataFactory((TopUpVerifyRequestModel) arguments.getParcelable(CashierKeyParams.TOP_UP_VERIFY_REQUEST_MODEL));
            BuiltInFictitiousFunctionClassFactory(((BaseCashierRiskFragment) this).moveToNextValue != null);
            this.moveToNextValue = Integer.valueOf(arguments.getInt(CashierKeyParams.INSTALLMENT_PERIOD));
            this.PlaceComponentResult = (AgreementInfo) arguments.getParcelable(CashierKeyParams.AGREEMENT_INFO);
            this.lookAheadTest = arguments.getString(CashierKeyParams.INSTALLMENT_PLAN_ID);
            this.NetworkUserEntityData$$ExternalSyntheticLambda7 = arguments.getString(CashierKeyParams.LOAN_AGREEMENT_URL);
            this.GetContactSyncConfig = arguments.getBoolean("isDoneCashierPay");
            CashierPayMethodModel cashierPayMethodModel = (CashierPayMethodModel) arguments.getParcelable(CashierKeyParams.BALANCE_MIX_PAY_MODEL);
            if (cashierPayMethodModel != null) {
                this.NetworkUserEntityData$$ExternalSyntheticLambda3 = cashierPayMethodModel;
            }
            String string7 = arguments.getString("merchantId", "");
            Intrinsics.checkNotNullExpressionValue(string7, "");
            this.NetworkUserEntityData$$ExternalSyntheticLambda8 = string7;
        }
    }

    @Override // id.dana.cashier.fragment.BaseVBCashierFragment
    protected final void NetworkUserEntityData$$ExternalSyntheticLambda3() {
        DaggerCashierComponent.Builder MyBillsEntityDataFactory = DaggerCashierComponent.MyBillsEntityDataFactory();
        MyBillsEntityDataFactory.BuiltInFictitiousFunctionClassFactory = (ApplicationComponent) Preconditions.getAuthRequestContext(initRecordTimeStamp());
        MyBillsEntityDataFactory.NetworkUserEntityData$$ExternalSyntheticLambda0 = (CashierRiskChallengeModule) Preconditions.getAuthRequestContext(new CashierRiskChallengeModule(new CashierViewListener() { // from class: id.dana.cashier.fragment.CashierOtpChallengeFragment$cashierRiskChallengeModule$1
            {
                CashierOtpChallengeFragment.this = this;
            }

            @Override // id.dana.cashier.CashierViewListener, id.dana.cashier.CashierRiskChallengeContract.View
            public final void KClassImpl$Data$declaredNonStaticMembers$2(CashierAgreementModel p0) {
                boolean z;
                String str;
                String str2;
                String str3;
                CashierPayMethodModel.CardPayMethod MyBillsEntityDataFactory2;
                Intrinsics.checkNotNullParameter(p0, "");
                CashierPayMethodModel cashierPayMethodModel = ((BaseCashierRiskFragment) CashierOtpChallengeFragment.this).NetworkUserEntityData$$ExternalSyntheticLambda0;
                if (cashierPayMethodModel != null && (MyBillsEntityDataFactory2 = CashierPayMethodModelKt.MyBillsEntityDataFactory(cashierPayMethodModel)) != null) {
                    CashierOtpChallengeFragment cashierOtpChallengeFragment = CashierOtpChallengeFragment.this;
                    CashierOtpChallengeFragment.MyBillsEntityDataFactory(cashierOtpChallengeFragment, MyBillsEntityDataFactory2);
                    if (MyBillsEntityDataFactory2.getAuthRequestContext == null) {
                        MyBillsEntityDataFactory2.getAuthRequestContext = new CashierPayMethodModel.NewCardData(null, null, null, null, null, null, false, null, null, 511, null);
                    }
                    CashierPayMethodModel.NewCardData newCardData = MyBillsEntityDataFactory2.getAuthRequestContext;
                    if (newCardData != null) {
                        newCardData.MyBillsEntityDataFactory = p0.KClassImpl$Data$declaredNonStaticMembers$2;
                        newCardData.BuiltInFictitiousFunctionClassFactory = p0.PlaceComponentResult;
                        newCardData.scheduleImpl = p0.getErrorConfigVersion;
                        newCardData.lookAheadTest = p0.scheduleImpl;
                        newCardData.moveToNextValue = cashierOtpChallengeFragment.getGetErrorConfigVersion();
                    }
                }
                z = CashierOtpChallengeFragment.this.GetContactSyncConfig;
                if (z) {
                    str = CashierOtpChallengeFragment.this.BuiltInFictitiousFunctionClassFactory;
                    if (str != null) {
                        CashierPresenter cashierPresenter = CashierOtpChallengeFragment.this.cashierPresenter;
                        if (cashierPresenter == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("");
                            cashierPresenter = null;
                        }
                        CashierPresenter cashierPresenter2 = cashierPresenter;
                        str2 = CashierOtpChallengeFragment.this.BuiltInFictitiousFunctionClassFactory;
                        if (str2 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("");
                            str3 = null;
                        } else {
                            str3 = str2;
                        }
                        cashierPresenter2.KClassImpl$Data$declaredNonStaticMembers$2(str3, null, (r12 & 4) != 0 ? false : false, (r12 & 8) != 0 ? null : null, (r12 & 16) != 0 ? null : null);
                        return;
                    }
                    return;
                }
                CashierOtpChallengeFragment.scheduleImpl(CashierOtpChallengeFragment.this);
            }

            @Override // id.dana.cashier.CashierViewListener, id.dana.cashier.CashierRiskChallengeContract.View
            public final void KClassImpl$Data$declaredNonStaticMembers$2(int i, int i2) {
                CashierOtpChallengeFragment.this.NetworkUserEntityData$$ExternalSyntheticLambda5 = i;
                CashierOtpChallengeFragment.MyBillsEntityDataFactory(CashierOtpChallengeFragment.this, i2);
                CashierOtpChallengeFragment.moveToNextValue(CashierOtpChallengeFragment.this);
                CashierOtpChallengeFragment.this.C();
                CashierOtpChallengeFragment.NetworkUserEntityData$$ExternalSyntheticLambda2(CashierOtpChallengeFragment.this);
                CashierOtpChallengeFragment.this.B();
            }

            @Override // id.dana.cashier.CashierViewListener, id.dana.cashier.CashierRiskChallengeContract.View
            public final void PlaceComponentResult(Bundle p0) {
                Intrinsics.checkNotNullParameter(p0, "");
                CashierOtpChallengeFragment.this.startActivityForResult((Intent) p0.getParcelable("com.google.android.gms.auth.api.phone.EXTRA_CONSENT_INTENT"), 1);
                VB vb = CashierOtpChallengeFragment.this.PlaceComponentResult;
                if (vb != 0) {
                    KeyboardHelper.BuiltInFictitiousFunctionClassFactory(((FragmentCashierOtpChallengeBinding) vb).KClassImpl$Data$declaredNonStaticMembers$2);
                    return;
                }
                throw new IllegalArgumentException("Required value was null.".toString());
            }

            @Override // id.dana.cashier.CashierViewListener, id.dana.cashier.CashierRiskChallengeContract.View
            public final void getAuthRequestContext(int i, int i2) {
                CashierOtpChallengeFragment.this.NetworkUserEntityData$$ExternalSyntheticLambda5 = i;
                CashierOtpChallengeFragment.MyBillsEntityDataFactory(CashierOtpChallengeFragment.this, i2);
                CashierOtpChallengeFragment.moveToNextValue(CashierOtpChallengeFragment.this);
                CashierOtpChallengeFragment.this.C();
                CashierOtpChallengeFragment.NetworkUserEntityData$$ExternalSyntheticLambda2(CashierOtpChallengeFragment.this);
            }

            @Override // id.dana.cashier.CashierViewListener, id.dana.cashier.CashierRiskChallengeContract.View
            public final void MyBillsEntityDataFactory(CashierErrorState p0) {
                FragmentActivity activity;
                FragmentManager supportFragmentManager;
                Intrinsics.checkNotNullParameter(p0, "");
                CashierOtpChallengeFragment cashierOtpChallengeFragment = CashierOtpChallengeFragment.this;
                String asString = p0.getAuthRequestContext.asString(CashierOtpChallengeFragment.this.getContext());
                FragmentActivity activity2 = cashierOtpChallengeFragment.getActivity();
                if (activity2 != null) {
                    CustomToast.BuiltInFictitiousFunctionClassFactory(activity2, R.drawable.ic_warning_24, R.drawable.bg_rounded_toast_payment_auth, asString, 72, true, null);
                }
                CashierOtpChallengeFragment cashierOtpChallengeFragment2 = CashierOtpChallengeFragment.this;
                if (!cashierOtpChallengeFragment2.isVisible() || (activity = cashierOtpChallengeFragment2.getActivity()) == null || (supportFragmentManager = activity.getSupportFragmentManager()) == null) {
                    return;
                }
                supportFragmentManager.popBackStack();
            }

            @Override // id.dana.cashier.CashierViewListener, id.dana.base.AbstractContractKt.AbstractView, id.dana.base.AbstractContract.AbstractView
            public final void showProgress() {
                CashierOtpChallengeFragment.this.SubSequence();
            }

            @Override // id.dana.cashier.CashierViewListener, id.dana.base.AbstractContractKt.AbstractView, id.dana.base.AbstractContract.AbstractView
            public final void dismissProgress() {
                CashierOtpChallengeFragment.this.GetContactSyncConfig();
                ShimmeringUtil.getAuthRequestContext(CashierOtpChallengeFragment.this.MyBillsEntityDataFactory);
            }

            @Override // id.dana.cashier.CashierViewListener, id.dana.base.AbstractContractKt.AbstractView, id.dana.base.AbstractContract.AbstractView
            public final void onError(String str) {
                CashierOtpChallengeFragment cashierOtpChallengeFragment = CashierOtpChallengeFragment.this;
                if (str == null) {
                    str = "";
                }
                FragmentActivity activity = cashierOtpChallengeFragment.getActivity();
                if (activity != null) {
                    CustomToast.BuiltInFictitiousFunctionClassFactory(activity, R.drawable.ic_warning_24, R.drawable.bg_rounded_toast_payment_auth, str, 72, true, null);
                }
            }

            @Override // id.dana.cashier.CashierViewListener, id.dana.cashier.CashierRiskChallengeContract.View
            public final void NetworkUserEntityData$$ExternalSyntheticLambda0(String p0) {
                CashierOtpChallengeFragment cashierOtpChallengeFragment = CashierOtpChallengeFragment.this;
                if (p0 == null) {
                    p0 = "";
                }
                FragmentActivity activity = cashierOtpChallengeFragment.getActivity();
                if (activity != null) {
                    CustomToast.BuiltInFictitiousFunctionClassFactory(activity, R.drawable.ic_warning_24, R.drawable.bg_rounded_toast_payment_auth, p0, 72, true, null);
                }
                VB vb = CashierOtpChallengeFragment.this.PlaceComponentResult;
                if (vb != 0) {
                    TextView textView = ((FragmentCashierOtpChallengeBinding) vb).scheduleImpl;
                    Intrinsics.checkNotNullExpressionValue(textView, "");
                    textView.setVisibility(8);
                    VB vb2 = CashierOtpChallengeFragment.this.PlaceComponentResult;
                    if (vb2 != 0) {
                        TextView textView2 = ((FragmentCashierOtpChallengeBinding) vb2).lookAheadTest;
                        Intrinsics.checkNotNullExpressionValue(textView2, "");
                        textView2.setVisibility(8);
                        CashierOtpChallengeFragment.NetworkUserEntityData$$ExternalSyntheticLambda1(CashierOtpChallengeFragment.this);
                        return;
                    }
                    throw new IllegalArgumentException("Required value was null.".toString());
                }
                throw new IllegalArgumentException("Required value was null.".toString());
            }

            @Override // id.dana.cashier.CashierViewListener, id.dana.cashier.CashierContract.View, id.dana.cashier.TopUpAndPayContract.View
            public final boolean KClassImpl$Data$declaredNonStaticMembers$2() {
                return LocationUtil.getAuthRequestContext(CashierOtpChallengeFragment.this.getContext());
            }

            @Override // id.dana.cashier.CashierViewListener, id.dana.cashier.CashierContract.View, id.dana.cashier.CashierRiskChallengeContract.View
            public final void DatabaseTableConfigUtil() {
                CashierOtpChallengeFragment.this.A();
            }

            @Override // id.dana.cashier.CashierViewListener, id.dana.cashier.CashierContract.View, id.dana.cashier.CashierRiskChallengeContract.View
            public final void MyBillsEntityDataFactory(String p0, String p1, Throwable p2) {
                Intrinsics.checkNotNullParameter(p0, "");
                Intrinsics.checkNotNullParameter(p1, "");
                Intrinsics.checkNotNullParameter(p2, "");
                CashierOtpChallengeFragment.this.KClassImpl$Data$declaredNonStaticMembers$2(p0, p1, p2);
            }

            @Override // id.dana.cashier.CashierViewListener, id.dana.cashier.CashierRiskChallengeContract.View
            public final void KClassImpl$Data$declaredNonStaticMembers$2(CashierErrorState p0) {
                FragmentActivity activity;
                FragmentManager supportFragmentManager;
                Intrinsics.checkNotNullParameter(p0, "");
                if (Intrinsics.areEqual(p0.MyBillsEntityDataFactory, "OTP_LIMITED")) {
                    CashierOtpChallengeFragment cashierOtpChallengeFragment = CashierOtpChallengeFragment.this;
                    FragmentActivity activity2 = cashierOtpChallengeFragment.getActivity();
                    final PayActivity payActivity = activity2 instanceof PayActivity ? (PayActivity) activity2 : null;
                    Context context = cashierOtpChallengeFragment.getContext();
                    if (context != null) {
                        CustomDialog.Builder builder = new CustomDialog.Builder(context);
                        builder.DatabaseTableConfigUtil = R.drawable.illustration_account_freeze;
                        builder.SubSequence = cashierOtpChallengeFragment.getString(R.string.otp_limited_dialog_title);
                        builder.GetContactSyncConfig = cashierOtpChallengeFragment.getString(R.string.otp_limited_dialog_desc);
                        String string = cashierOtpChallengeFragment.getString(R.string.ok_got_it);
                        Function1<View, Unit> function1 = new Function1<View, Unit>() { // from class: id.dana.cashier.fragment.BaseVBCashierFragment$showOtpLimitedDialog$1$1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final /* bridge */ /* synthetic */ Unit invoke(View view) {
                                invoke2(view);
                                return Unit.INSTANCE;
                            }

                            /* renamed from: invoke */
                            public final void invoke2(View view) {
                                Intrinsics.checkNotNullParameter(view, "");
                                PayActivity payActivity2 = payActivity;
                                if (payActivity2 != null) {
                                    payActivity2.needToBackHomeOnDestroy(true);
                                }
                                PayActivity payActivity3 = payActivity;
                                if (payActivity3 != null) {
                                    payActivity3.finish();
                                }
                            }
                        };
                        Intrinsics.checkNotNullParameter(function1, "");
                        CustomDialog$sam$android_view_View_OnClickListener$0 customDialog$sam$android_view_View_OnClickListener$0 = new CustomDialog$sam$android_view_View_OnClickListener$0(function1);
                        builder.NetworkUserEntityData$$ExternalSyntheticLambda6 = string;
                        builder.getSupportButtonTintMode = customDialog$sam$android_view_View_OnClickListener$0;
                        CustomDialog.Builder KClassImpl$Data$declaredNonStaticMembers$2 = builder.PlaceComponentResult(true).KClassImpl$Data$declaredNonStaticMembers$2(true);
                        KClassImpl$Data$declaredNonStaticMembers$2.moveToNextValue = 0L;
                        KClassImpl$Data$declaredNonStaticMembers$2.BuiltInFictitiousFunctionClassFactory().show();
                    }
                } else {
                    CashierOtpChallengeFragment cashierOtpChallengeFragment2 = CashierOtpChallengeFragment.this;
                    String asString = p0.getAuthRequestContext.asString(CashierOtpChallengeFragment.this.getContext());
                    FragmentActivity activity3 = cashierOtpChallengeFragment2.getActivity();
                    if (activity3 != null) {
                        CustomToast.BuiltInFictitiousFunctionClassFactory(activity3, R.drawable.ic_warning_24, R.drawable.bg_rounded_toast_payment_auth, asString, 72, true, null);
                    }
                }
                CashierOtpChallengeFragment cashierOtpChallengeFragment3 = CashierOtpChallengeFragment.this;
                if (!cashierOtpChallengeFragment3.isVisible() || (activity = cashierOtpChallengeFragment3.getActivity()) == null || (supportFragmentManager = activity.getSupportFragmentManager()) == null) {
                    return;
                }
                supportFragmentManager.popBackStack();
            }
        }));
        MyBillsEntityDataFactory.scheduleImpl = (CashierModule) Preconditions.getAuthRequestContext(new CashierModule(new CashierViewListener() { // from class: id.dana.cashier.fragment.CashierOtpChallengeFragment$cashierModule$1
            {
                CashierOtpChallengeFragment.this = this;
            }

            @Override // id.dana.cashier.CashierViewListener, id.dana.cashier.CashierContract.View, id.dana.cashier.TopUpAndPayContract.View
            public final void MyBillsEntityDataFactory(CashierPayModel p0) {
                Intrinsics.checkNotNullParameter(p0, "");
                CashierOtpChallengeFragment.BuiltInFictitiousFunctionClassFactory(CashierOtpChallengeFragment.this, p0);
            }

            @Override // id.dana.cashier.CashierViewListener, id.dana.cashier.CashierContract.View
            public final void getAuthRequestContext(CashierErrorState p0) {
                Intrinsics.checkNotNullParameter(p0, "");
                CashierOtpChallengeFragment.this.PlaceComponentResult(p0);
            }

            @Override // id.dana.cashier.CashierViewListener, id.dana.cashier.CashierContract.View, id.dana.cashier.TopUpAndPayContract.View
            public final void BuiltInFictitiousFunctionClassFactory(CashierErrorState p0) {
                Intrinsics.checkNotNullParameter(p0, "");
                CashierOtpChallengeFragment.this.PlaceComponentResult(p0);
            }

            @Override // id.dana.cashier.CashierViewListener, id.dana.base.AbstractContractKt.AbstractView, id.dana.base.AbstractContract.AbstractView
            public final void showProgress() {
                CashierOtpChallengeFragment.this.SubSequence();
                VB vb = CashierOtpChallengeFragment.this.PlaceComponentResult;
                if (vb != 0) {
                    TextView textView = ((FragmentCashierOtpChallengeBinding) vb).moveToNextValue;
                    Intrinsics.checkNotNullExpressionValue(textView, "");
                    textView.setVisibility(8);
                    return;
                }
                throw new IllegalArgumentException("Required value was null.".toString());
            }

            @Override // id.dana.cashier.CashierViewListener, id.dana.base.AbstractContractKt.AbstractView, id.dana.base.AbstractContract.AbstractView
            public final void dismissProgress() {
                CashierOtpChallengeFragment.this.GetContactSyncConfig();
            }

            @Override // id.dana.cashier.CashierViewListener, id.dana.base.AbstractContractKt.AbstractView, id.dana.base.AbstractContract.AbstractView
            public final void onError(String str) {
                CashierOtpChallengeFragment cashierOtpChallengeFragment = CashierOtpChallengeFragment.this;
                if (str == null) {
                    str = "";
                }
                FragmentActivity activity = cashierOtpChallengeFragment.getActivity();
                if (activity != null) {
                    CustomToast.BuiltInFictitiousFunctionClassFactory(activity, R.drawable.ic_warning_24, R.drawable.bg_rounded_toast_payment_auth, str, 72, true, null);
                }
                VB vb = CashierOtpChallengeFragment.this.PlaceComponentResult;
                if (vb != 0) {
                    PinEntryEditText pinEntryEditText = ((FragmentCashierOtpChallengeBinding) vb).KClassImpl$Data$declaredNonStaticMembers$2;
                    Intrinsics.checkNotNullExpressionValue(pinEntryEditText, "");
                    InputExtKt.MyBillsEntityDataFactory(pinEntryEditText);
                    CashierOtpChallengeFragment.this.B();
                    return;
                }
                throw new IllegalArgumentException("Required value was null.".toString());
            }

            @Override // id.dana.cashier.CashierViewListener, id.dana.cashier.CashierContract.View, id.dana.cashier.TopUpAndPayContract.View
            public final void getErrorConfigVersion() {
                CashierOtpChallengeFragment.this.getAuthRequestContext(true);
            }

            @Override // id.dana.cashier.CashierViewListener, id.dana.cashier.CashierContract.View, id.dana.cashier.TopUpAndPayContract.View
            public final void scheduleImpl() {
                CashierOtpChallengeFragment.MyBillsEntityDataFactory(CashierOtpChallengeFragment.this);
            }

            @Override // id.dana.cashier.CashierViewListener, id.dana.cashier.CashierContract.View, id.dana.cashier.TopUpAndPayContract.View
            public final void getAuthRequestContext() {
                CashierOtpChallengeFragment.MyBillsEntityDataFactory(CashierOtpChallengeFragment.this);
            }

            @Override // id.dana.cashier.CashierViewListener, id.dana.cashier.CashierContract.View, id.dana.cashier.TopUpAndPayContract.View
            public final boolean KClassImpl$Data$declaredNonStaticMembers$2() {
                return LocationUtil.getAuthRequestContext(CashierOtpChallengeFragment.this.getContext());
            }

            @Override // id.dana.cashier.CashierViewListener, id.dana.cashier.CashierContract.View
            public final void KClassImpl$Data$declaredNonStaticMembers$2(CashierPayModel p0) {
                Intrinsics.checkNotNullParameter(p0, "");
                if (Intrinsics.areEqual(p0.BuiltInFictitiousFunctionClassFactory, Boolean.TRUE)) {
                    PayResultModel payResultModel = ((BaseCashierRiskFragment) CashierOtpChallengeFragment.this).BuiltInFictitiousFunctionClassFactory;
                    CashierPresenter cashierPresenter = null;
                    if (payResultModel != null) {
                        AttributeCashierPayModel attributeCashierPayModel = p0.KClassImpl$Data$declaredNonStaticMembers$2;
                        String str = attributeCashierPayModel != null ? attributeCashierPayModel.T : null;
                        if (str == null) {
                            str = "";
                        }
                        payResultModel.com.alibaba.griver.image.photo.utils.DiskFormatter.MB java.lang.String = str;
                    }
                    PayResultModel payResultModel2 = ((BaseCashierRiskFragment) CashierOtpChallengeFragment.this).BuiltInFictitiousFunctionClassFactory;
                    if (payResultModel2 != null) {
                        payResultModel2.I = ((BaseCashierRiskFragment) CashierOtpChallengeFragment.this).NetworkUserEntityData$$ExternalSyntheticLambda0;
                    }
                    PayResultModel payResultModel3 = ((BaseCashierRiskFragment) CashierOtpChallengeFragment.this).BuiltInFictitiousFunctionClassFactory;
                    if (payResultModel3 != null) {
                        AttributeCashierPayModel attributeCashierPayModel2 = p0.KClassImpl$Data$declaredNonStaticMembers$2;
                        payResultModel3.FragmentBottomSheetPaymentSettingBinding = attributeCashierPayModel2 != null ? attributeCashierPayModel2.getSupportButtonTintMode : null;
                    }
                    PayResultModel payResultModel4 = ((BaseCashierRiskFragment) CashierOtpChallengeFragment.this).BuiltInFictitiousFunctionClassFactory;
                    if (payResultModel4 != null) {
                        AttributeCashierPayModel attributeCashierPayModel3 = p0.KClassImpl$Data$declaredNonStaticMembers$2;
                        payResultModel4.VerifyPinStateManager$executeRiskChallenge$2$2 = attributeCashierPayModel3 != null ? attributeCashierPayModel3.SummaryVoucherView$$ExternalSyntheticLambda0 : null;
                    }
                    AttributeCashierPayModel attributeCashierPayModel4 = p0.KClassImpl$Data$declaredNonStaticMembers$2;
                    if (attributeCashierPayModel4 != null) {
                        CashierOtpChallengeFragment cashierOtpChallengeFragment = CashierOtpChallengeFragment.this;
                        if (attributeCashierPayModel4.KClassImpl$Data$declaredNonStaticMembers$2()) {
                            CashierOtpChallengeFragment.PlaceComponentResult(cashierOtpChallengeFragment, attributeCashierPayModel4);
                            return;
                        }
                        CashierPresenter cashierPresenter2 = cashierOtpChallengeFragment.cashierPresenter;
                        if (cashierPresenter2 != null) {
                            cashierPresenter = cashierPresenter2;
                        } else {
                            Intrinsics.throwUninitializedPropertyAccessException("");
                        }
                        CashierPresenter cashierPresenter3 = cashierPresenter;
                        String str2 = p0.MyBillsEntityDataFactory;
                        cashierPresenter3.KClassImpl$Data$declaredNonStaticMembers$2(str2 == null ? "" : str2, null, (r12 & 4) != 0 ? false : false, (r12 & 8) != 0 ? null : null, (r12 & 16) != 0 ? null : null);
                        return;
                    }
                    return;
                }
                VB vb = CashierOtpChallengeFragment.this.PlaceComponentResult;
                if (vb != 0) {
                    PinEntryEditText pinEntryEditText = ((FragmentCashierOtpChallengeBinding) vb).KClassImpl$Data$declaredNonStaticMembers$2;
                    Intrinsics.checkNotNullExpressionValue(pinEntryEditText, "");
                    InputExtKt.MyBillsEntityDataFactory(pinEntryEditText);
                    CashierOtpChallengeFragment cashierOtpChallengeFragment2 = CashierOtpChallengeFragment.this;
                    String str3 = p0.getAuthRequestContext;
                    cashierOtpChallengeFragment2.PlaceComponentResult(str3 != null ? str3 : "");
                    return;
                }
                throw new IllegalArgumentException("Required value was null.".toString());
            }
        }));
        MyBillsEntityDataFactory.getErrorConfigVersion = (TopUpAndPayModule) Preconditions.getAuthRequestContext(new TopUpAndPayModule(new CashierViewListener() { // from class: id.dana.cashier.fragment.CashierOtpChallengeFragment$topUpAndPayModule$1
            {
                CashierOtpChallengeFragment.this = this;
            }

            @Override // id.dana.cashier.CashierViewListener, id.dana.cashier.CashierContract.View, id.dana.cashier.TopUpAndPayContract.View
            public final void MyBillsEntityDataFactory(CashierPayModel p0) {
                Intrinsics.checkNotNullParameter(p0, "");
                CashierOtpChallengeFragment.BuiltInFictitiousFunctionClassFactory(CashierOtpChallengeFragment.this, p0);
            }

            @Override // id.dana.cashier.CashierViewListener, id.dana.base.AbstractContractKt.AbstractView, id.dana.base.AbstractContract.AbstractView
            public final void showProgress() {
                CashierOtpChallengeFragment.this.SubSequence();
                VB vb = CashierOtpChallengeFragment.this.PlaceComponentResult;
                if (vb != 0) {
                    TextView textView = ((FragmentCashierOtpChallengeBinding) vb).moveToNextValue;
                    Intrinsics.checkNotNullExpressionValue(textView, "");
                    textView.setVisibility(8);
                    return;
                }
                throw new IllegalArgumentException("Required value was null.".toString());
            }

            @Override // id.dana.cashier.CashierViewListener, id.dana.base.AbstractContractKt.AbstractView, id.dana.base.AbstractContract.AbstractView
            public final void dismissProgress() {
                CashierOtpChallengeFragment.this.GetContactSyncConfig();
            }

            @Override // id.dana.cashier.CashierViewListener, id.dana.cashier.TopUpAndPayContract.View
            public final void lookAheadTest(CashierErrorState p0) {
                Intrinsics.checkNotNullParameter(p0, "");
                CashierOtpChallengeFragment.this.PlaceComponentResult(p0);
            }

            @Override // id.dana.cashier.CashierViewListener, id.dana.cashier.CashierContract.View, id.dana.cashier.TopUpAndPayContract.View
            public final void BuiltInFictitiousFunctionClassFactory(CashierErrorState p0) {
                Intrinsics.checkNotNullParameter(p0, "");
                CashierOtpChallengeFragment.this.PlaceComponentResult(p0);
            }

            @Override // id.dana.cashier.CashierViewListener, id.dana.base.AbstractContractKt.AbstractView, id.dana.base.AbstractContract.AbstractView
            public final void onError(String str) {
                CashierOtpChallengeFragment cashierOtpChallengeFragment = CashierOtpChallengeFragment.this;
                if (str == null) {
                    str = "";
                }
                FragmentActivity activity = cashierOtpChallengeFragment.getActivity();
                if (activity != null) {
                    CustomToast.BuiltInFictitiousFunctionClassFactory(activity, R.drawable.ic_warning_24, R.drawable.bg_rounded_toast_payment_auth, str, 72, true, null);
                }
            }

            @Override // id.dana.cashier.CashierViewListener, id.dana.cashier.CashierContract.View, id.dana.cashier.TopUpAndPayContract.View
            public final boolean KClassImpl$Data$declaredNonStaticMembers$2() {
                return LocationUtil.getAuthRequestContext(CashierOtpChallengeFragment.this.getContext());
            }

            @Override // id.dana.cashier.CashierViewListener, id.dana.cashier.TopUpAndPayContract.View
            public final void MyBillsEntityDataFactory(TopUpPayModel p0) {
                String str;
                Intrinsics.checkNotNullParameter(p0, "");
                if (Intrinsics.areEqual(p0.lookAheadTest, Boolean.TRUE)) {
                    PayResultModel payResultModel = ((BaseCashierRiskFragment) CashierOtpChallengeFragment.this).BuiltInFictitiousFunctionClassFactory;
                    if (payResultModel != null) {
                        AttributeCashierPayModel attributeCashierPayModel = p0.BuiltInFictitiousFunctionClassFactory;
                        String str2 = attributeCashierPayModel != null ? attributeCashierPayModel.T : null;
                        if (str2 == null) {
                            str2 = "";
                        }
                        payResultModel.com.alibaba.griver.image.photo.utils.DiskFormatter.MB java.lang.String = str2;
                    }
                    PayResultModel payResultModel2 = ((BaseCashierRiskFragment) CashierOtpChallengeFragment.this).BuiltInFictitiousFunctionClassFactory;
                    if (payResultModel2 != null) {
                        AttributeCashierPayModel attributeCashierPayModel2 = p0.BuiltInFictitiousFunctionClassFactory;
                        payResultModel2.FragmentBottomSheetPaymentSettingBinding = attributeCashierPayModel2 != null ? attributeCashierPayModel2.getSupportButtonTintMode : null;
                    }
                    PayResultModel payResultModel3 = ((BaseCashierRiskFragment) CashierOtpChallengeFragment.this).BuiltInFictitiousFunctionClassFactory;
                    if (payResultModel3 != null) {
                        AttributeCashierPayModel attributeCashierPayModel3 = p0.BuiltInFictitiousFunctionClassFactory;
                        payResultModel3.VerifyPinStateManager$executeRiskChallenge$2$2 = attributeCashierPayModel3 != null ? attributeCashierPayModel3.SummaryVoucherView$$ExternalSyntheticLambda0 : null;
                    }
                    TopUpAndPayContract.Presenter presenter = CashierOtpChallengeFragment.this.topUpAndPayPresenter;
                    if (presenter == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("");
                        presenter = null;
                    }
                    str = CashierOtpChallengeFragment.this.BuiltInFictitiousFunctionClassFactory;
                    if (str == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("");
                        str = null;
                    }
                    TopUpVerifyRequestModel topUpVerifyRequestModel = ((BaseCashierRiskFragment) CashierOtpChallengeFragment.this).moveToNextValue;
                    String str3 = topUpVerifyRequestModel != null ? topUpVerifyRequestModel.getAuthRequestContext : null;
                    presenter.PlaceComponentResult(str, str3 != null ? str3 : "", null, CashierOtpChallengeFragment.this.getErrorConfigVersion);
                    return;
                }
                VB vb = CashierOtpChallengeFragment.this.PlaceComponentResult;
                if (vb != 0) {
                    PinEntryEditText pinEntryEditText = ((FragmentCashierOtpChallengeBinding) vb).KClassImpl$Data$declaredNonStaticMembers$2;
                    Intrinsics.checkNotNullExpressionValue(pinEntryEditText, "");
                    InputExtKt.MyBillsEntityDataFactory(pinEntryEditText);
                    CashierOtpChallengeFragment cashierOtpChallengeFragment = CashierOtpChallengeFragment.this;
                    String str4 = p0.KClassImpl$Data$declaredNonStaticMembers$2;
                    cashierOtpChallengeFragment.PlaceComponentResult(str4 != null ? str4 : "");
                    return;
                }
                throw new IllegalArgumentException("Required value was null.".toString());
            }
        }));
        MyBillsEntityDataFactory.MyBillsEntityDataFactory = (CashierAnalyticModule) Preconditions.getAuthRequestContext(new CashierAnalyticModule());
        MyBillsEntityDataFactory.PlaceComponentResult = (CashierCardBindingModule) Preconditions.getAuthRequestContext(new CashierCardBindingModule(new CashierViewListener() { // from class: id.dana.cashier.fragment.CashierOtpChallengeFragment$cashierCardBindingModule$1
        }));
        MyBillsEntityDataFactory.moveToNextValue = (CashierPayLaterModule) Preconditions.getAuthRequestContext(new CashierPayLaterModule(new CashierPayLaterViewListener() { // from class: id.dana.cashier.fragment.CashierOtpChallengeFragment$cashierPayLaterModule$1
        }));
        MyBillsEntityDataFactory.KClassImpl$Data$declaredNonStaticMembers$2 = (CashierAddOnModule) Preconditions.getAuthRequestContext(new CashierAddOnModule(new CashierAddOnViewListener() { // from class: id.dana.cashier.fragment.CashierOtpChallengeFragment$cashierAddOnModule$1
        }));
        MyBillsEntityDataFactory.lookAheadTest = (CashierUserRelatedModule) Preconditions.getAuthRequestContext(new CashierUserRelatedModule(new CashierUserRelatedViewListener() { // from class: id.dana.cashier.fragment.CashierOtpChallengeFragment$cashierUserRelatedModule$1
        }));
        MyBillsEntityDataFactory.getAuthRequestContext = (CashierHighlightModule) Preconditions.getAuthRequestContext(new CashierHighlightModule(new CashierHighlightViewListener() { // from class: id.dana.cashier.fragment.CashierOtpChallengeFragment$cashierHighlightModule$1
        }));
        MyBillsEntityDataFactory.MyBillsEntityDataFactory().MyBillsEntityDataFactory(this);
        AbstractContract.AbstractPresenter[] abstractPresenterArr = new AbstractContract.AbstractPresenter[3];
        CashierRiskChallengePresenter cashierRiskChallengePresenter = this.cashierRiskChallengePresenter;
        TopUpAndPayContract.Presenter presenter = null;
        if (cashierRiskChallengePresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            cashierRiskChallengePresenter = null;
        }
        abstractPresenterArr[0] = cashierRiskChallengePresenter;
        CashierPresenter cashierPresenter = this.cashierPresenter;
        if (cashierPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            cashierPresenter = null;
        }
        abstractPresenterArr[1] = cashierPresenter;
        TopUpAndPayContract.Presenter presenter2 = this.topUpAndPayPresenter;
        if (presenter2 != null) {
            presenter = presenter2;
        } else {
            Intrinsics.throwUninitializedPropertyAccessException("");
        }
        abstractPresenterArr[2] = presenter;
        BuiltInFictitiousFunctionClassFactory(abstractPresenterArr);
    }

    @Override // id.dana.cashier.fragment.BaseVBCashierFragment
    protected final void NetworkUserEntityData$$ExternalSyntheticLambda6() {
        FragmentActivity activity = getActivity();
        PayActivity payActivity = activity instanceof PayActivity ? (PayActivity) activity : null;
        if (payActivity != null) {
            payActivity.setCashierRiskListener(new PayActivity.CashierRiskListener() { // from class: id.dana.cashier.fragment.CashierOtpChallengeFragment$initCashierListener$1
                {
                    CashierOtpChallengeFragment.this = this;
                }

                @Override // id.dana.pay.PayActivity.CashierRiskListener
                public final void MyBillsEntityDataFactory(String p0) {
                    String str;
                    String str2;
                    String str3;
                    CashierOtpChallengeFragment.this.SubSequence();
                    if (CashierOtpChallengeFragment.this.getKClassImpl$Data$declaredNonStaticMembers$2()) {
                        TopUpAndPayContract.Presenter presenter = CashierOtpChallengeFragment.this.topUpAndPayPresenter;
                        if (presenter == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("");
                            presenter = null;
                        }
                        str3 = CashierOtpChallengeFragment.this.BuiltInFictitiousFunctionClassFactory;
                        if (str3 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("");
                            str3 = null;
                        }
                        TopUpVerifyRequestModel topUpVerifyRequestModel = ((BaseCashierRiskFragment) CashierOtpChallengeFragment.this).moveToNextValue;
                        String str4 = topUpVerifyRequestModel != null ? topUpVerifyRequestModel.getAuthRequestContext : null;
                        presenter.PlaceComponentResult(str3, str4 != null ? str4 : "", p0, CashierOtpChallengeFragment.this.getErrorConfigVersion);
                        return;
                    }
                    CashierPresenter cashierPresenter = CashierOtpChallengeFragment.this.cashierPresenter;
                    if (cashierPresenter == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("");
                        cashierPresenter = null;
                    }
                    CashierPresenter cashierPresenter2 = cashierPresenter;
                    str = CashierOtpChallengeFragment.this.BuiltInFictitiousFunctionClassFactory;
                    if (str == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("");
                        str2 = null;
                    } else {
                        str2 = str;
                    }
                    cashierPresenter2.KClassImpl$Data$declaredNonStaticMembers$2(str2, p0, (r12 & 4) != 0 ? false : false, (r12 & 8) != 0 ? null : null, (r12 & 16) != 0 ? null : null);
                }
            });
        }
    }

    @Override // id.dana.cashier.fragment.BaseVBCashierFragment
    public final void getAuthRequestContext(RiskParamsFactory p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        KClassImpl$Data$declaredNonStaticMembers$2(p0);
        FragmentPermissionRequest NetworkUserEntityData$$ExternalSyntheticLambda2 = getMyBillsEntityDataFactory();
        if (NetworkUserEntityData$$ExternalSyntheticLambda2 != null) {
            NetworkUserEntityData$$ExternalSyntheticLambda2.check();
        }
    }

    @Override // id.dana.cashier.fragment.BaseVBCashierFragment
    public final void getCallingPid() {
        CashierPayMethodModel cashierPayMethodModel;
        String str;
        FragmentActivity activity = getActivity();
        if (activity == null || (cashierPayMethodModel = ((BaseCashierRiskFragment) this).NetworkUserEntityData$$ExternalSyntheticLambda0) == null) {
            return;
        }
        String str2 = this.BuiltInFictitiousFunctionClassFactory;
        CashierPresenter cashierPresenter = null;
        if (str2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            str = null;
        } else {
            str = str2;
        }
        CashierFaceAuthModel cashierFaceAuthModel = new CashierFaceAuthModel(str, cashierPayMethodModel, getIsLayoutRequested(), "MIC_FACE", getNetworkUserEntityData$$ExternalSyntheticLambda7(), BuiltInFictitiousFunctionClassFactory(), this.moveToNextValue, getNetworkUserEntityData$$ExternalSyntheticLambda6(), activity);
        CashierPresenter cashierPresenter2 = this.cashierPresenter;
        if (cashierPresenter2 != null) {
            cashierPresenter = cashierPresenter2;
        } else {
            Intrinsics.throwUninitializedPropertyAccessException("");
        }
        cashierPresenter.BuiltInFictitiousFunctionClassFactory(cashierFaceAuthModel);
    }

    @Override // id.dana.cashier.fragment.BaseVBCashierFragment
    public final void readMicros() {
        RiskParamsFactory NetworkUserEntityData$$ExternalSyntheticLambda1 = getNetworkUserEntityData$$ExternalSyntheticLambda1();
        if (NetworkUserEntityData$$ExternalSyntheticLambda1 != null) {
            String PlaceComponentResult = NetworkUserEntityData$$ExternalSyntheticLambda1.PlaceComponentResult();
            FragmentActivity activity = getActivity();
            PayActivity payActivity = activity instanceof PayActivity ? (PayActivity) activity : null;
            if (payActivity != null) {
                if (PlaceComponentResult == null) {
                    PlaceComponentResult = "";
                }
                PayActivity.handleCashierRiskPhase$default(payActivity, PlaceComponentResult, NetworkUserEntityData$$ExternalSyntheticLambda1, null, null, 12, null);
            }
            KClassImpl$Data$declaredNonStaticMembers$2((RiskParamsFactory) null);
        }
    }

    public static final boolean MyBillsEntityDataFactory(CashierOtpChallengeFragment cashierOtpChallengeFragment, CharSequence charSequence) {
        Intrinsics.checkNotNullParameter(cashierOtpChallengeFragment, "");
        Intrinsics.checkNotNullParameter(charSequence, "");
        int length = charSequence.length();
        VB vb = cashierOtpChallengeFragment.PlaceComponentResult;
        if (vb != 0) {
            return length == ((FragmentCashierOtpChallengeBinding) vb).KClassImpl$Data$declaredNonStaticMembers$2.getMaxLength();
        }
        throw new IllegalArgumentException("Required value was null.".toString());
    }

    /* JADX WARN: Removed duplicated region for block: B:289:0x00b6  */
    /* JADX WARN: Removed duplicated region for block: B:295:0x00c1  */
    /* JADX WARN: Removed duplicated region for block: B:300:0x00cb  */
    /* JADX WARN: Removed duplicated region for block: B:303:0x00d2  */
    /* JADX WARN: Removed duplicated region for block: B:310:0x00e0  */
    /* JADX WARN: Removed duplicated region for block: B:314:0x00e8  */
    /* JADX WARN: Removed duplicated region for block: B:315:0x00eb  */
    /* JADX WARN: Removed duplicated region for block: B:318:0x0106  */
    /* JADX WARN: Removed duplicated region for block: B:319:0x010d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final void PlaceComponentResult(boolean r25) {
        /*
            Method dump skipped, instructions count: 274
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.cashier.fragment.CashierOtpChallengeFragment.PlaceComponentResult(boolean):void");
    }

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0007¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"Lid/dana/cashier/fragment/CashierOtpChallengeFragment$Companion;", "", "Landroid/os/Bundle;", "p0", "Lid/dana/cashier/fragment/CashierOtpChallengeFragment;", "KClassImpl$Data$declaredNonStaticMembers$2", "(Landroid/os/Bundle;)Lid/dana/cashier/fragment/CashierOtpChallengeFragment;", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes4.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public static CashierOtpChallengeFragment KClassImpl$Data$declaredNonStaticMembers$2(Bundle p0) {
            Intrinsics.checkNotNullParameter(p0, "");
            CashierOtpChallengeFragment cashierOtpChallengeFragment = new CashierOtpChallengeFragment();
            cashierOtpChallengeFragment.setArguments(p0);
            return cashierOtpChallengeFragment;
        }
    }

    public static /* synthetic */ void BuiltInFictitiousFunctionClassFactory(CashierOtpChallengeFragment cashierOtpChallengeFragment) {
        CashierPayMethodModel cashierPayMethodModel;
        CashierPayMethodModel.CardPayMethod MyBillsEntityDataFactory;
        String str;
        String str2;
        String str3;
        String str4;
        String str5;
        Intrinsics.checkNotNullParameter(cashierOtpChallengeFragment, "");
        if (!cashierOtpChallengeFragment.NetworkUserEntityData$$ExternalSyntheticLambda1) {
            cashierOtpChallengeFragment.PlaceComponentResult(false);
        } else if (((BaseCashierRiskFragment) cashierOtpChallengeFragment).NetworkUserEntityData$$ExternalSyntheticLambda0 == null || (cashierPayMethodModel = ((BaseCashierRiskFragment) cashierOtpChallengeFragment).NetworkUserEntityData$$ExternalSyntheticLambda0) == null || (MyBillsEntityDataFactory = CashierPayMethodModelKt.MyBillsEntityDataFactory(cashierPayMethodModel)) == null) {
        } else {
            CashierRiskChallengePresenter cashierRiskChallengePresenter = cashierOtpChallengeFragment.cashierRiskChallengePresenter;
            if (cashierRiskChallengePresenter == null) {
                Intrinsics.throwUninitializedPropertyAccessException("");
                cashierRiskChallengePresenter = null;
            }
            String str6 = cashierOtpChallengeFragment.BuiltInFictitiousFunctionClassFactory;
            if (str6 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("");
                str = null;
            } else {
                str = str6;
            }
            String str7 = cashierOtpChallengeFragment.PrepareContext;
            String valueOf = String.valueOf(cashierOtpChallengeFragment.DatabaseTableConfigUtil);
            CashierPayMethodModel.NewCardData newCardData = MyBillsEntityDataFactory.getAuthRequestContext;
            if (newCardData == null || (str2 = newCardData.MyBillsEntityDataFactory) == null) {
                str2 = MyBillsEntityDataFactory.KClassImpl$Data$declaredNonStaticMembers$2.KClassImpl$Data$declaredNonStaticMembers$2;
            }
            String str8 = str2;
            CashierPayMethodModel.NewCardData newCardData2 = MyBillsEntityDataFactory.getAuthRequestContext;
            if (newCardData2 == null || (str3 = newCardData2.MyBillsEntityDataFactory) == null) {
                str3 = MyBillsEntityDataFactory.KClassImpl$Data$declaredNonStaticMembers$2.KClassImpl$Data$declaredNonStaticMembers$2;
            }
            String str9 = str3;
            CashierPayMethodModel.NewCardData newCardData3 = MyBillsEntityDataFactory.getAuthRequestContext;
            String str10 = ((newCardData3 == null || (str4 = newCardData3.getAuthRequestContext) == null) && (str4 = MyBillsEntityDataFactory.KClassImpl$Data$declaredNonStaticMembers$2.NetworkUserEntityData$$ExternalSyntheticLambda8) == null) ? "" : str4;
            CashierPayMethodModel.NewCardData newCardData4 = MyBillsEntityDataFactory.getAuthRequestContext;
            String str11 = ((newCardData4 == null || (str5 = newCardData4.KClassImpl$Data$declaredNonStaticMembers$2) == null) && (str5 = MyBillsEntityDataFactory.KClassImpl$Data$declaredNonStaticMembers$2.isLayoutRequested) == null) ? "" : str5;
            CashierPayMethodModel.NewCardData newCardData5 = MyBillsEntityDataFactory.getAuthRequestContext;
            cashierRiskChallengePresenter.PlaceComponentResult(new SendBankOtpModel(str9, str, str8, str7, cashierOtpChallengeFragment.NetworkUserEntityData$$ExternalSyntheticLambda0, newCardData5 != null ? newCardData5.PlaceComponentResult : null, null, null, str10, str11, valueOf, null, null, cashierOtpChallengeFragment.KClassImpl$Data$declaredNonStaticMembers$2, 6336, null));
        }
    }

    public static /* synthetic */ void PlaceComponentResult(CashierOtpChallengeFragment cashierOtpChallengeFragment) {
        Intrinsics.checkNotNullParameter(cashierOtpChallengeFragment, "");
        cashierOtpChallengeFragment.MyBillsEntityDataFactory(false);
    }

    public static /* synthetic */ void KClassImpl$Data$declaredNonStaticMembers$2(CashierOtpChallengeFragment cashierOtpChallengeFragment, CharSequence charSequence) {
        TopUpAndPayContract.Presenter presenter;
        String str;
        String str2;
        String str3;
        CashierPayMethodModel cashierPayMethodModel;
        String NetworkUserEntityData$$ExternalSyntheticLambda7;
        Intrinsics.checkNotNullParameter(cashierOtpChallengeFragment, "");
        cashierOtpChallengeFragment.PlaceComponentResult();
        TopUpAndPayContract.Presenter presenter2 = null;
        String str4 = null;
        if (!cashierOtpChallengeFragment.NetworkUserEntityData$$ExternalSyntheticLambda1) {
            String obj = charSequence.toString();
            CashierAnalyticTracker cashierAnalyticTracker = cashierOtpChallengeFragment.cashierAnalyticTracker;
            if (cashierAnalyticTracker == null) {
                Intrinsics.throwUninitializedPropertyAccessException("");
                cashierAnalyticTracker = null;
            }
            String str5 = cashierOtpChallengeFragment.BuiltInFictitiousFunctionClassFactory;
            if (str5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("");
                str5 = null;
            }
            CashierAnalyticTracker.CC.BuiltInFictitiousFunctionClassFactory(cashierAnalyticTracker, str5, "OTP", null, 12);
            if (cashierOtpChallengeFragment.initRecordTimeStamp) {
                if (cashierOtpChallengeFragment.getKClassImpl$Data$declaredNonStaticMembers$2()) {
                    TopUpVerifyRequestModel topUpVerifyRequestModel = ((BaseCashierRiskFragment) cashierOtpChallengeFragment).moveToNextValue;
                    if (topUpVerifyRequestModel != null) {
                        topUpVerifyRequestModel.moveToNextValue = obj;
                        topUpVerifyRequestModel.getErrorConfigVersion = "OTP_SMS";
                    }
                    TopUpVerifyRequestModel topUpVerifyRequestModel2 = ((BaseCashierRiskFragment) cashierOtpChallengeFragment).moveToNextValue;
                    if (topUpVerifyRequestModel2 != null) {
                        TopUpAndPayContract.Presenter presenter3 = cashierOtpChallengeFragment.topUpAndPayPresenter;
                        if (presenter3 != null) {
                            presenter2 = presenter3;
                        } else {
                            Intrinsics.throwUninitializedPropertyAccessException("");
                        }
                        presenter2.KClassImpl$Data$declaredNonStaticMembers$2(topUpVerifyRequestModel2);
                    }
                } else {
                    CashierPayMethodModel cashierPayMethodModel2 = ((BaseCashierRiskFragment) cashierOtpChallengeFragment).NetworkUserEntityData$$ExternalSyntheticLambda0;
                    if (cashierPayMethodModel2 != null) {
                        CashierPresenter cashierPresenter = cashierOtpChallengeFragment.cashierPresenter;
                        if (cashierPresenter == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("");
                            cashierPresenter = null;
                        }
                        CashierPresenter cashierPresenter2 = cashierPresenter;
                        String str6 = cashierOtpChallengeFragment.BuiltInFictitiousFunctionClassFactory;
                        if (str6 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("");
                            str6 = null;
                        }
                        CashierPayMethodModel cashierPayMethodModel3 = cashierOtpChallengeFragment.NetworkUserEntityData$$ExternalSyntheticLambda3;
                        if (cashierPayMethodModel3 == null) {
                            cashierPayMethodModel3 = cashierPayMethodModel2;
                        } else if (cashierPayMethodModel3 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("");
                            cashierPayMethodModel3 = null;
                        }
                        String str7 = cashierOtpChallengeFragment.FragmentBottomSheetPaymentSettingBinding;
                        if (str7 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("");
                            str3 = null;
                        } else {
                            str3 = str7;
                        }
                        VoucherCashierModel PrepareContext = cashierOtpChallengeFragment.getNetworkUserEntityData$$ExternalSyntheticLambda7();
                        List<String> BuiltInFictitiousFunctionClassFactory = cashierOtpChallengeFragment.BuiltInFictitiousFunctionClassFactory();
                        PaylaterCashierRequestCheckoutModel paylaterCashierRequestCheckoutModel = new PaylaterCashierRequestCheckoutModel(cashierOtpChallengeFragment.moveToNextValue, cashierOtpChallengeFragment.PlaceComponentResult, cashierOtpChallengeFragment.lookAheadTest, cashierOtpChallengeFragment.NetworkUserEntityData$$ExternalSyntheticLambda7);
                        if (cashierOtpChallengeFragment.NetworkUserEntityData$$ExternalSyntheticLambda3 != null) {
                            cashierPayMethodModel2.getKClassImpl$Data$declaredNonStaticMembers$2();
                            Unit unit = Unit.INSTANCE;
                            cashierPayMethodModel = cashierPayMethodModel2;
                        } else {
                            cashierPayMethodModel = null;
                        }
                        AttributeCashierPayModel attributeCashierPayModel = cashierOtpChallengeFragment.getAuthRequestContext;
                        if (attributeCashierPayModel == null || (NetworkUserEntityData$$ExternalSyntheticLambda7 = attributeCashierPayModel.T) == null) {
                            NetworkUserEntityData$$ExternalSyntheticLambda7 = cashierOtpChallengeFragment.getNetworkUserEntityData$$ExternalSyntheticLambda6();
                        }
                        cashierPresenter2.MyBillsEntityDataFactory(str6, cashierPayMethodModel3, obj, str3, PrepareContext, (r24 & 32) != 0 ? false : false, BuiltInFictitiousFunctionClassFactory, (r24 & 128) != 0 ? null : paylaterCashierRequestCheckoutModel, (r24 & 256) != 0 ? null : cashierPayMethodModel, (r24 & 512) != 0 ? null : NetworkUserEntityData$$ExternalSyntheticLambda7);
                    }
                }
            } else if (cashierOtpChallengeFragment.getKClassImpl$Data$declaredNonStaticMembers$2()) {
                TopUpAndPayContract.Presenter presenter4 = cashierOtpChallengeFragment.topUpAndPayPresenter;
                if (presenter4 != null) {
                    presenter = presenter4;
                } else {
                    Intrinsics.throwUninitializedPropertyAccessException("");
                    presenter = null;
                }
                String str8 = cashierOtpChallengeFragment.BuiltInFictitiousFunctionClassFactory;
                if (str8 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("");
                    str = null;
                } else {
                    str = str8;
                }
                TopUpVerifyRequestModel topUpVerifyRequestModel3 = ((BaseCashierRiskFragment) cashierOtpChallengeFragment).moveToNextValue;
                String str9 = topUpVerifyRequestModel3 != null ? topUpVerifyRequestModel3.getAuthRequestContext : null;
                String str10 = str9 == null ? "" : str9;
                String str11 = cashierOtpChallengeFragment.getErrorConfigVersion;
                String str12 = cashierOtpChallengeFragment.FragmentBottomSheetPaymentSettingBinding;
                if (str12 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("");
                    str2 = null;
                } else {
                    str2 = str12;
                }
                presenter.BuiltInFictitiousFunctionClassFactory(str, str10, str11, obj, str2);
            } else {
                CashierPresenter cashierPresenter3 = cashierOtpChallengeFragment.cashierPresenter;
                if (cashierPresenter3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("");
                    cashierPresenter3 = null;
                }
                String str13 = cashierOtpChallengeFragment.BuiltInFictitiousFunctionClassFactory;
                if (str13 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("");
                    str13 = null;
                }
                String str14 = cashierOtpChallengeFragment.FragmentBottomSheetPaymentSettingBinding;
                if (str14 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("");
                } else {
                    str4 = str14;
                }
                cashierPresenter3.KClassImpl$Data$declaredNonStaticMembers$2(str13, obj, str4);
            }
            VB vb = cashierOtpChallengeFragment.PlaceComponentResult;
            if (vb != 0) {
                KeyboardHelper.BuiltInFictitiousFunctionClassFactory(((FragmentCashierOtpChallengeBinding) vb).KClassImpl$Data$declaredNonStaticMembers$2);
                return;
            }
            throw new IllegalArgumentException("Required value was null.".toString());
        }
        KeyboardHelper.BuiltInFictitiousFunctionClassFactory(cashierOtpChallengeFragment.getActivity());
        if (charSequence.toString().length() > 0) {
            final CashierRiskChallengePresenter cashierRiskChallengePresenter = cashierOtpChallengeFragment.cashierRiskChallengePresenter;
            if (cashierRiskChallengePresenter == null) {
                Intrinsics.throwUninitializedPropertyAccessException("");
                cashierRiskChallengePresenter = null;
            }
            String str15 = cashierOtpChallengeFragment.BuiltInFictitiousFunctionClassFactory;
            if (str15 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("");
                str15 = null;
            }
            String str16 = cashierOtpChallengeFragment.PrepareContext;
            VB vb2 = cashierOtpChallengeFragment.PlaceComponentResult;
            if (vb2 != 0) {
                Editable text = ((FragmentCashierOtpChallengeBinding) vb2).KClassImpl$Data$declaredNonStaticMembers$2.getText();
                String obj2 = text != null ? text.toString() : null;
                if (obj2 == null) {
                    obj2 = "";
                }
                Intrinsics.checkNotNullParameter(str15, "");
                Intrinsics.checkNotNullParameter(str16, "");
                Intrinsics.checkNotNullParameter(obj2, "");
                cashierRiskChallengePresenter.getErrorConfigVersion.showProgress();
                cashierRiskChallengePresenter.MyBillsEntityDataFactory.execute(CreateCashierAgreement.Params.INSTANCE.createSendBankOtpParam(str15, str16, obj2), new Function1<CashierAgreementResponse, Unit>() { // from class: id.dana.cashier.presenter.CashierRiskChallengePresenter$createCashierAgreement$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final /* bridge */ /* synthetic */ Unit invoke(CashierAgreementResponse cashierAgreementResponse) {
                        invoke2(cashierAgreementResponse);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke */
                    public final void invoke2(CashierAgreementResponse cashierAgreementResponse) {
                        CashierRiskChallengeContract.View view;
                        CashierRiskChallengeContract.View view2;
                        Intrinsics.checkNotNullParameter(cashierAgreementResponse, "");
                        view = cashierRiskChallengePresenter.getErrorConfigVersion;
                        view.dismissProgress();
                        view2 = cashierRiskChallengePresenter.getErrorConfigVersion;
                        CashierAgreementModelMapper cashierAgreementModelMapper = CashierAgreementModelMapper.INSTANCE;
                        view2.KClassImpl$Data$declaredNonStaticMembers$2(CashierAgreementModelMapper.MyBillsEntityDataFactory(cashierAgreementResponse));
                    }
                }, new Function1<Throwable, Unit>() { // from class: id.dana.cashier.presenter.CashierRiskChallengePresenter$createCashierAgreement$2
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
                        invoke2(th);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke */
                    public final void invoke2(Throwable th) {
                        CashierRiskChallengeContract.View view;
                        CashierRiskChallengeContract.View view2;
                        boolean contains;
                        CashierRiskChallengeContract.View view3;
                        Intrinsics.checkNotNullParameter(th, "");
                        view = cashierRiskChallengePresenter.getErrorConfigVersion;
                        view.dismissProgress();
                        if (th instanceof NetworkException) {
                            CashierErrorHelper cashierErrorHelper = CashierErrorHelper.INSTANCE;
                            contains = CollectionsKt.contains(CashierErrorHelper.initRecordTimeStamp, ((NetworkException) th).getErrorCode());
                            if (contains) {
                                view3 = cashierRiskChallengePresenter.getErrorConfigVersion;
                                view3.NetworkUserEntityData$$ExternalSyntheticLambda0(th.getMessage());
                                return;
                            }
                        }
                        view2 = cashierRiskChallengePresenter.getErrorConfigVersion;
                        view2.onError(th.getMessage());
                    }
                });
                return;
            }
            throw new IllegalArgumentException("Required value was null.".toString());
        }
    }

    public static final /* synthetic */ void MyBillsEntityDataFactory(CashierOtpChallengeFragment cashierOtpChallengeFragment, CashierPayMethodModel cashierPayMethodModel) {
        if (cashierOtpChallengeFragment.getGetErrorConfigVersion()) {
            return;
        }
        cashierPayMethodModel.moveToNextValue = true;
    }

    /* JADX WARN: Code restructure failed: missing block: B:557:0x0176, code lost:
    
        if (r6 == null) goto L558;
     */
    /* JADX WARN: Removed duplicated region for block: B:624:0x0294  */
    /* JADX WARN: Removed duplicated region for block: B:625:0x0298  */
    /* JADX WARN: Removed duplicated region for block: B:627:0x029b  */
    /* JADX WARN: Removed duplicated region for block: B:664:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final /* synthetic */ void BuiltInFictitiousFunctionClassFactory(id.dana.cashier.fragment.CashierOtpChallengeFragment r23, id.dana.cashier.model.CashierPayModel r24) {
        /*
            Method dump skipped, instructions count: 783
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.cashier.fragment.CashierOtpChallengeFragment.BuiltInFictitiousFunctionClassFactory(id.dana.cashier.fragment.CashierOtpChallengeFragment, id.dana.cashier.model.CashierPayModel):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:305:0x0139  */
    /* JADX WARN: Removed duplicated region for block: B:306:0x013c  */
    /* JADX WARN: Removed duplicated region for block: B:308:0x0140  */
    /* JADX WARN: Removed duplicated region for block: B:326:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final /* synthetic */ void PlaceComponentResult(id.dana.cashier.fragment.CashierOtpChallengeFragment r25, id.dana.cashier.model.AttributeCashierPayModel r26) {
        /*
            Method dump skipped, instructions count: 361
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.cashier.fragment.CashierOtpChallengeFragment.PlaceComponentResult(id.dana.cashier.fragment.CashierOtpChallengeFragment, id.dana.cashier.model.AttributeCashierPayModel):void");
    }

    public static final /* synthetic */ void MyBillsEntityDataFactory(CashierOtpChallengeFragment cashierOtpChallengeFragment) {
        cashierOtpChallengeFragment.NetworkUserEntityData$$ExternalSyntheticLambda0 = true;
        cashierOtpChallengeFragment.getSupportButtonTintMode();
        cashierOtpChallengeFragment.getAuthRequestContext(false);
    }

    public static final /* synthetic */ void moveToNextValue(CashierOtpChallengeFragment cashierOtpChallengeFragment) {
        FragmentActivity activity = cashierOtpChallengeFragment.getActivity();
        if (activity != null) {
            CashierOtpUtil cashierOtpUtil = CashierOtpUtil.INSTANCE;
            CashierOtpUtil.BuiltInFictitiousFunctionClassFactory(activity, new CashierOtpChallengeFragment$listenSmsReceiver$1$1(cashierOtpChallengeFragment));
        }
    }

    public static final /* synthetic */ void getErrorConfigVersion(CashierOtpChallengeFragment cashierOtpChallengeFragment) {
        VB vb = cashierOtpChallengeFragment.PlaceComponentResult;
        if (vb != 0) {
            ((FragmentCashierOtpChallengeBinding) vb).lookAheadTest.postDelayed(new Runnable() { // from class: id.dana.cashier.fragment.CashierOtpChallengeFragment$$ExternalSyntheticLambda0
                {
                    CashierOtpChallengeFragment.this = cashierOtpChallengeFragment;
                }

                @Override // java.lang.Runnable
                public final void run() {
                    CashierOtpChallengeFragment.PlaceComponentResult(CashierOtpChallengeFragment.this);
                }
            }, 300L);
            return;
        }
        throw new IllegalArgumentException("Required value was null.".toString());
    }

    public static final /* synthetic */ void scheduleImpl(CashierOtpChallengeFragment cashierOtpChallengeFragment) {
        CashierPayMethodModel cashierPayMethodModel;
        String str;
        CashierPayMethodModel cashierPayMethodModel2;
        CashierAnalyticTracker cashierAnalyticTracker;
        String str2;
        CashierPayMethodModel cashierPayMethodModel3 = ((BaseCashierRiskFragment) cashierOtpChallengeFragment).NetworkUserEntityData$$ExternalSyntheticLambda0;
        if (cashierPayMethodModel3 != null) {
            Intrinsics.checkNotNullParameter(cashierPayMethodModel3, "");
            if (!cashierOtpChallengeFragment.NetworkUserEntityData$$ExternalSyntheticLambda5()) {
                CashierAnalyticTracker cashierAnalyticTracker2 = cashierOtpChallengeFragment.cashierAnalyticTracker;
                if (cashierAnalyticTracker2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("");
                    cashierAnalyticTracker2 = null;
                }
                CashierPayMethodModel.NewCardData scheduleImpl = CashierPayMethodModelKt.scheduleImpl(cashierPayMethodModel3);
                String str3 = scheduleImpl != null ? scheduleImpl.lookAheadTest : null;
                if (str3 == null) {
                    str3 = "";
                }
                cashierAnalyticTracker2.getAuthRequestContext(str3);
                CashierAnalyticTracker cashierAnalyticTracker3 = cashierOtpChallengeFragment.cashierAnalyticTracker;
                if (cashierAnalyticTracker3 != null) {
                    cashierAnalyticTracker = cashierAnalyticTracker3;
                } else {
                    Intrinsics.throwUninitializedPropertyAccessException("");
                    cashierAnalyticTracker = null;
                }
                String str4 = cashierOtpChallengeFragment.BuiltInFictitiousFunctionClassFactory;
                if (str4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("");
                    str2 = null;
                } else {
                    str2 = str4;
                }
                cashierPayMethodModel3.MyBillsEntityDataFactory = cashierOtpChallengeFragment.NetworkUserEntityData$$ExternalSyntheticLambda3 != null;
                cashierPayMethodModel3.lookAheadTest = cashierOtpChallengeFragment.getKClassImpl$Data$declaredNonStaticMembers$2();
                List<String> BuiltInFictitiousFunctionClassFactory = cashierOtpChallengeFragment.BuiltInFictitiousFunctionClassFactory();
                if (BuiltInFictitiousFunctionClassFactory == null) {
                    BuiltInFictitiousFunctionClassFactory = CollectionsKt.emptyList();
                }
                List<String> list = BuiltInFictitiousFunctionClassFactory;
                FragmentActivity activity = cashierOtpChallengeFragment.getActivity();
                PayActivity payActivity = activity instanceof PayActivity ? (PayActivity) activity : null;
                AddOnTrackingModel addOnTrackingModel = payActivity != null ? payActivity.getAddOnTrackingModel() : null;
                PayResultModel payResultModel = ((BaseCashierRiskFragment) cashierOtpChallengeFragment).BuiltInFictitiousFunctionClassFactory;
                String str5 = payResultModel != null ? payResultModel.VerifyPinStateManager$executeRiskChallenge$2$2 : null;
                FragmentActivity activity2 = cashierOtpChallengeFragment.getActivity();
                PayActivity payActivity2 = activity2 instanceof PayActivity ? (PayActivity) activity2 : null;
                cashierAnalyticTracker.MyBillsEntityDataFactory(new PaymentExecutionTrackerParams(str2, cashierPayMethodModel3, list, addOnTrackingModel, str5, cashierOtpChallengeFragment.NetworkUserEntityData$$ExternalSyntheticLambda8(), null, payActivity2 != null ? payActivity2.getFeatureTimeModel() : null, 64, null));
            }
            if (cashierOtpChallengeFragment.NetworkUserEntityData$$ExternalSyntheticLambda2) {
                String str6 = cashierOtpChallengeFragment.BuiltInFictitiousFunctionClassFactory;
                if (str6 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("");
                    str = null;
                } else {
                    str = str6;
                }
                CashierCheckoutRequestModel cashierCheckoutRequestModel = new CashierCheckoutRequestModel(str, Boolean.TRUE, new CheckoutExternalInfo(null, null, null, null, Boolean.TRUE, null, 47, null), null, null, null, null, null, null, null, cashierOtpChallengeFragment.getNetworkUserEntityData$$ExternalSyntheticLambda6(), false, null, 7160, null);
                CashierPresenter cashierPresenter = cashierOtpChallengeFragment.cashierPresenter;
                if (cashierPresenter == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("");
                    cashierPresenter = null;
                }
                String str7 = cashierOtpChallengeFragment.BuiltInFictitiousFunctionClassFactory;
                if (str7 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("");
                    str7 = null;
                }
                CashierPayMethodModel cashierPayMethodModel4 = cashierOtpChallengeFragment.NetworkUserEntityData$$ExternalSyntheticLambda3;
                if (cashierPayMethodModel4 == null) {
                    cashierPayMethodModel4 = cashierPayMethodModel3;
                } else if (cashierPayMethodModel4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("");
                    cashierPayMethodModel4 = null;
                }
                List<String> BuiltInFictitiousFunctionClassFactory2 = cashierOtpChallengeFragment.BuiltInFictitiousFunctionClassFactory();
                if (BuiltInFictitiousFunctionClassFactory2 == null) {
                    BuiltInFictitiousFunctionClassFactory2 = CollectionsKt.emptyList();
                }
                VoucherCashierModel PrepareContext = cashierOtpChallengeFragment.getNetworkUserEntityData$$ExternalSyntheticLambda7();
                PaylaterCashierRequestCheckoutModel paylaterCashierRequestCheckoutModel = new PaylaterCashierRequestCheckoutModel(cashierOtpChallengeFragment.moveToNextValue, cashierOtpChallengeFragment.PlaceComponentResult, cashierOtpChallengeFragment.lookAheadTest, cashierOtpChallengeFragment.NetworkUserEntityData$$ExternalSyntheticLambda7);
                if (cashierOtpChallengeFragment.NetworkUserEntityData$$ExternalSyntheticLambda3 != null) {
                    cashierPayMethodModel3.KClassImpl$Data$declaredNonStaticMembers$2 = true;
                    Unit unit = Unit.INSTANCE;
                    cashierPayMethodModel2 = cashierPayMethodModel3;
                } else {
                    cashierPayMethodModel2 = null;
                }
                cashierPresenter.KClassImpl$Data$declaredNonStaticMembers$2(str7, cashierCheckoutRequestModel, cashierPayMethodModel4, BuiltInFictitiousFunctionClassFactory2, PrepareContext, paylaterCashierRequestCheckoutModel, cashierPayMethodModel2, cashierOtpChallengeFragment.getNetworkUserEntityData$$ExternalSyntheticLambda6());
            } else if (cashierOtpChallengeFragment.NetworkUserEntityData$$ExternalSyntheticLambda3 != null) {
                CashierPresenter cashierPresenter2 = cashierOtpChallengeFragment.cashierPresenter;
                if (cashierPresenter2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("");
                    cashierPresenter2 = null;
                }
                CashierPresenter cashierPresenter3 = cashierPresenter2;
                String str8 = cashierOtpChallengeFragment.BuiltInFictitiousFunctionClassFactory;
                if (str8 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("");
                    str8 = null;
                }
                CashierPayMethodModel cashierPayMethodModel5 = cashierOtpChallengeFragment.NetworkUserEntityData$$ExternalSyntheticLambda3;
                if (cashierPayMethodModel5 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("");
                    cashierPayMethodModel = null;
                } else {
                    cashierPayMethodModel = cashierPayMethodModel5;
                }
                VoucherCashierModel PrepareContext2 = cashierOtpChallengeFragment.getNetworkUserEntityData$$ExternalSyntheticLambda7();
                cashierPayMethodModel3.KClassImpl$Data$declaredNonStaticMembers$2 = true;
                Unit unit2 = Unit.INSTANCE;
                cashierPresenter3.PlaceComponentResult(str8, cashierPayMethodModel, (r20 & 4) != 0 ? null : PrepareContext2, false, (r20 & 16) != 0 ? null : null, (r20 & 32) != 0 ? null : cashierPayMethodModel3, (r20 & 64) != 0 ? null : cashierOtpChallengeFragment.getNetworkUserEntityData$$ExternalSyntheticLambda6(), (r20 & 128) != 0 ? null : null);
            } else {
                CashierPresenter cashierPresenter4 = cashierOtpChallengeFragment.cashierPresenter;
                if (cashierPresenter4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("");
                    cashierPresenter4 = null;
                }
                CashierPresenter cashierPresenter5 = cashierPresenter4;
                String str9 = cashierOtpChallengeFragment.BuiltInFictitiousFunctionClassFactory;
                if (str9 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("");
                    str9 = null;
                }
                VoucherCashierModel PrepareContext3 = cashierOtpChallengeFragment.getNetworkUserEntityData$$ExternalSyntheticLambda7();
                if (PrepareContext3 == null) {
                    PayResultModel payResultModel2 = ((BaseCashierRiskFragment) cashierOtpChallengeFragment).BuiltInFictitiousFunctionClassFactory;
                    PrepareContext3 = payResultModel2 != null ? payResultModel2.com.iap.ac.android.biz.common.utils.log.LogConstants.RESULT_FALSE java.lang.String : null;
                }
                cashierPresenter5.PlaceComponentResult(str9, cashierPayMethodModel3, (r20 & 4) != 0 ? null : PrepareContext3, false, (r20 & 16) != 0 ? null : null, (r20 & 32) != 0 ? null : null, (r20 & 64) != 0 ? null : cashierOtpChallengeFragment.getNetworkUserEntityData$$ExternalSyntheticLambda6(), (r20 & 128) != 0 ? null : new PaylaterCashierRequestCheckoutModel(cashierOtpChallengeFragment.moveToNextValue, cashierOtpChallengeFragment.PlaceComponentResult, cashierOtpChallengeFragment.lookAheadTest, cashierOtpChallengeFragment.NetworkUserEntityData$$ExternalSyntheticLambda7));
            }
        }
    }

    public static final /* synthetic */ void MyBillsEntityDataFactory(CashierOtpChallengeFragment cashierOtpChallengeFragment, int i) {
        if (i > 0) {
            cashierOtpChallengeFragment.newProxyInstance = i;
        }
    }

    public static final /* synthetic */ void NetworkUserEntityData$$ExternalSyntheticLambda2(CashierOtpChallengeFragment cashierOtpChallengeFragment) {
        cashierOtpChallengeFragment.MyBillsEntityDataFactory(true);
        CashierOtpChallengeFragment$getCountdownTimer$1 cashierOtpChallengeFragment$getCountdownTimer$1 = new CashierOtpChallengeFragment$getCountdownTimer$1(cashierOtpChallengeFragment, TimeUnit.SECONDS.toMillis(cashierOtpChallengeFragment.NetworkUserEntityData$$ExternalSyntheticLambda5), TimeUnit.SECONDS.toMillis(1L));
        cashierOtpChallengeFragment.scheduleImpl = cashierOtpChallengeFragment$getCountdownTimer$1;
        cashierOtpChallengeFragment$getCountdownTimer$1.start();
    }

    public static final /* synthetic */ void NetworkUserEntityData$$ExternalSyntheticLambda1(CashierOtpChallengeFragment cashierOtpChallengeFragment) {
        CountDownTimer countDownTimer = cashierOtpChallengeFragment.scheduleImpl;
        if (countDownTimer != null) {
            if (countDownTimer != null) {
                countDownTimer.cancel();
            }
            cashierOtpChallengeFragment.scheduleImpl = null;
        }
    }

    public final void B() {
        try {
            VB vb = this.PlaceComponentResult;
            if (vb != 0) {
                ((FragmentCashierOtpChallengeBinding) vb).KClassImpl$Data$declaredNonStaticMembers$2.requestFocus();
                FragmentActivity activity = getActivity();
                if (activity != null) {
                    KeyboardHelper.getAuthRequestContext(activity);
                    return;
                }
                return;
            }
            throw new IllegalArgumentException("Required value was null.".toString());
        } catch (IllegalArgumentException unused) {
        }
    }

    private final void VerifyPinStateManager$executeRiskChallenge$2$1() {
        VB vb = this.PlaceComponentResult;
        if (vb != 0) {
            TextView textView = ((FragmentCashierOtpChallengeBinding) vb).NetworkUserEntityData$$ExternalSyntheticLambda0;
            String str = this.FragmentBottomSheetPaymentSettingBinding;
            String str2 = null;
            if (str == null) {
                Intrinsics.throwUninitializedPropertyAccessException("");
                str = null;
            }
            if (!Intrinsics.areEqual(str, VerificationMethod.SEND_OTP)) {
                String str3 = this.FragmentBottomSheetPaymentSettingBinding;
                if (str3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("");
                } else {
                    str2 = str3;
                }
                if (!Intrinsics.areEqual(str2, VerificationMethod.BANK_OTP) && !this.NetworkUserEntityData$$ExternalSyntheticLambda1) {
                    Intrinsics.checkNotNullExpressionValue(textView, "");
                    textView.setVisibility(8);
                    return;
                }
            }
            Intrinsics.checkNotNullExpressionValue(textView, "");
            textView.setVisibility(0);
            textView.setText(getString(R.string.otp_sent_to_your_bank_number));
            return;
        }
        throw new IllegalArgumentException("Required value was null.".toString());
    }

    public final void C() {
        int authRequestContext;
        VB vb = this.PlaceComponentResult;
        if (vb != 0) {
            PinEntryEditText pinEntryEditText = ((FragmentCashierOtpChallengeBinding) vb).KClassImpl$Data$declaredNonStaticMembers$2;
            pinEntryEditText.setMaxLength(this.newProxyInstance);
            ConstraintLayout.LayoutParams layoutParams = (ConstraintLayout.LayoutParams) pinEntryEditText.getLayoutParams();
            int maxLength = pinEntryEditText.getMaxLength();
            if (maxLength == 4) {
                authRequestContext = SizeUtil.getAuthRequestContext(112);
            } else if (maxLength == 6) {
                authRequestContext = SizeUtil.getAuthRequestContext(63);
            } else if (maxLength == 8) {
                authRequestContext = SizeUtil.getAuthRequestContext(16);
            } else {
                authRequestContext = SizeUtil.getAuthRequestContext(16);
            }
            if (layoutParams != null) {
                Intrinsics.checkNotNullExpressionValue(pinEntryEditText, "");
                PinEntryEditText pinEntryEditText2 = pinEntryEditText;
                ViewGroup.LayoutParams layoutParams2 = pinEntryEditText2.getLayoutParams();
                ViewGroup.MarginLayoutParams marginLayoutParams = layoutParams2 instanceof ViewGroup.MarginLayoutParams ? (ViewGroup.MarginLayoutParams) layoutParams2 : null;
                int i = marginLayoutParams != null ? marginLayoutParams.topMargin : 0;
                ViewGroup.LayoutParams layoutParams3 = pinEntryEditText2.getLayoutParams();
                ViewGroup.MarginLayoutParams marginLayoutParams2 = layoutParams3 instanceof ViewGroup.MarginLayoutParams ? (ViewGroup.MarginLayoutParams) layoutParams3 : null;
                layoutParams.setMargins(authRequestContext, i, authRequestContext, marginLayoutParams2 != null ? marginLayoutParams2.bottomMargin : 0);
            }
            pinEntryEditText.setLayoutParams(layoutParams);
            VerifyPinStateManager$executeRiskChallenge$2$1();
            return;
        }
        throw new IllegalArgumentException("Required value was null.".toString());
    }

    public final void PlaceComponentResult(String p0) {
        VB vb = this.PlaceComponentResult;
        if (vb != 0) {
            TextView textView = ((FragmentCashierOtpChallengeBinding) vb).moveToNextValue;
            textView.setText(p0);
            Intrinsics.checkNotNullExpressionValue(textView, "");
            textView.setVisibility(0);
            return;
        }
        throw new IllegalArgumentException("Required value was null.".toString());
    }

    private final void MyBillsEntityDataFactory(boolean p0) {
        VB vb = this.PlaceComponentResult;
        if (vb != 0) {
            TextView textView = ((FragmentCashierOtpChallengeBinding) vb).lookAheadTest;
            Intrinsics.checkNotNullExpressionValue(textView, "");
            textView.setVisibility(p0 ? 0 : 8);
            VB vb2 = this.PlaceComponentResult;
            if (vb2 != 0) {
                TextView textView2 = ((FragmentCashierOtpChallengeBinding) vb2).scheduleImpl;
                Intrinsics.checkNotNullExpressionValue(textView2, "");
                textView2.setVisibility(p0 ^ true ? 0 : 8);
                return;
            }
            throw new IllegalArgumentException("Required value was null.".toString());
        }
        throw new IllegalArgumentException("Required value was null.".toString());
    }

    @Override // id.dana.cashier.fragment.BaseVBCashierFragment
    public final void PlaceComponentResult(CashierErrorState p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        String str = p0.MyBillsEntityDataFactory;
        int hashCode = str.hashCode();
        if (hashCode == -2080396080) {
            if (str.equals(CashierErrorType.RETRYABLE_RISK_CHALLENGE)) {
                PlaceComponentResult(p0.getAuthRequestContext.asString(getContext()));
                DatabaseTableConfigUtil();
            }
            BaseVBCashierFragment.getAuthRequestContext(this, "fail", p0.getAuthRequestContext.asString(getContext()), p0.KClassImpl$Data$declaredNonStaticMembers$2, null, null, false, 56);
        } else if (hashCode == -1464512787) {
            if (str.equals(CashierErrorType.ACCOUNT_ON_HOLD)) {
                BuiltInFictitiousFunctionClassFactory(p0.KClassImpl$Data$declaredNonStaticMembers$2, p0.getAuthRequestContext.asString(getContext()));
            }
            BaseVBCashierFragment.getAuthRequestContext(this, "fail", p0.getAuthRequestContext.asString(getContext()), p0.KClassImpl$Data$declaredNonStaticMembers$2, null, null, false, 56);
        } else {
            if (hashCode == 646849033 && str.equals("SYSTEM_BUSY")) {
                String asString = p0.getAuthRequestContext.asString(getContext());
                FragmentActivity activity = getActivity();
                if (activity != null) {
                    CustomToast.BuiltInFictitiousFunctionClassFactory(activity, R.drawable.ic_warning_24, R.drawable.bg_rounded_toast_payment_auth, asString, 72, true, null);
                }
            }
            BaseVBCashierFragment.getAuthRequestContext(this, "fail", p0.getAuthRequestContext.asString(getContext()), p0.KClassImpl$Data$declaredNonStaticMembers$2, null, null, false, 56);
        }
        VB vb = this.PlaceComponentResult;
        if (vb != 0) {
            PinEntryEditText pinEntryEditText = ((FragmentCashierOtpChallengeBinding) vb).KClassImpl$Data$declaredNonStaticMembers$2;
            Intrinsics.checkNotNullExpressionValue(pinEntryEditText, "");
            InputExtKt.MyBillsEntityDataFactory(pinEntryEditText);
            return;
        }
        throw new IllegalArgumentException("Required value was null.".toString());
    }

    @Override // id.dana.cashier.fragment.BaseVBCashierFragment
    protected final void getAuthRequestContext(String p0, String p1, String p2, String p3, String p4, boolean p5) {
        Intrinsics.checkNotNullParameter(p0, "");
        Intrinsics.checkNotNullParameter(p3, "");
        Intrinsics.checkNotNullParameter(p4, "");
        PayResultModel payResultModel = ((BaseCashierRiskFragment) this).BuiltInFictitiousFunctionClassFactory;
        if (payResultModel != null) {
            String str = this.BuiltInFictitiousFunctionClassFactory;
            if (str == null) {
                Intrinsics.throwUninitializedPropertyAccessException("");
                str = null;
            }
            Intrinsics.checkNotNullParameter(str, "");
            payResultModel.getErrorConfigVersion = str;
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
        Window window;
        VB vb = this.PlaceComponentResult;
        if (vb != 0) {
            ((FragmentCashierOtpChallengeBinding) vb).scheduleImpl.setOnClickListener(new View.OnClickListener() { // from class: id.dana.cashier.fragment.CashierOtpChallengeFragment$$ExternalSyntheticLambda1
                {
                    CashierOtpChallengeFragment.this = this;
                }

                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    CashierOtpChallengeFragment.BuiltInFictitiousFunctionClassFactory(CashierOtpChallengeFragment.this);
                }
            });
            FragmentActivity activity = getActivity();
            KeyboardHelper.PlaceComponentResult((activity == null || (window = activity.getWindow()) == null) ? null : window.getDecorView(), new KeyboardHelper.KeyboardVisibilityListener() { // from class: id.dana.cashier.fragment.CashierOtpChallengeFragment$setupKeyboardListener$1
                {
                    CashierOtpChallengeFragment.this = this;
                }

                @Override // id.dana.utils.KeyboardHelper.KeyboardVisibilityListener
                public final void KClassImpl$Data$declaredNonStaticMembers$2() {
                    CashierOtpChallengeFragment cashierOtpChallengeFragment = CashierOtpChallengeFragment.this;
                    if (cashierOtpChallengeFragment.getActivity() instanceof PayActivity) {
                        FragmentActivity activity2 = cashierOtpChallengeFragment.getActivity();
                        PayActivity payActivity = activity2 instanceof PayActivity ? (PayActivity) activity2 : null;
                        if (payActivity != null) {
                            payActivity.expandBottomSheet();
                        }
                    }
                }

                @Override // id.dana.utils.KeyboardHelper.KeyboardVisibilityListener
                public final void MyBillsEntityDataFactory() {
                    FragmentActivity activity2 = CashierOtpChallengeFragment.this.getActivity();
                    PayActivity payActivity = activity2 instanceof PayActivity ? (PayActivity) activity2 : null;
                    if (payActivity != null) {
                        payActivity.setHalfScreenBottomSheet();
                    }
                }
            });
            VB vb2 = this.PlaceComponentResult;
            if (vb2 != 0) {
                ((FragmentCashierOtpChallengeBinding) vb2).BuiltInFictitiousFunctionClassFactory.setLoadingListener(new DanaProtectionLoadingView.DanaProtectionLoadingListener() { // from class: id.dana.cashier.fragment.CashierOtpChallengeFragment$initDanaProtectionLoading$1
                    {
                        CashierOtpChallengeFragment.this = this;
                    }

                    @Override // id.dana.richview.DanaProtectionLoadingView.DanaProtectionLoadingListener
                    public final void getAuthRequestContext() {
                        FragmentActivity activity2 = CashierOtpChallengeFragment.this.getActivity();
                        PayActivity payActivity = activity2 instanceof PayActivity ? (PayActivity) activity2 : null;
                        if (payActivity != null) {
                            payActivity.enableDisableActivityTouchEvent(false);
                        }
                    }

                    @Override // id.dana.richview.DanaProtectionLoadingView.DanaProtectionLoadingListener
                    public final void KClassImpl$Data$declaredNonStaticMembers$2() {
                        FragmentActivity activity2 = CashierOtpChallengeFragment.this.getActivity();
                        PayActivity payActivity = activity2 instanceof PayActivity ? (PayActivity) activity2 : null;
                        if (payActivity != null) {
                            payActivity.enableDisableActivityTouchEvent(true);
                        }
                    }
                });
                VB vb3 = this.PlaceComponentResult;
                if (vb3 != 0) {
                    PlaceComponentResult(RxTextView.textChanges(((FragmentCashierOtpChallengeBinding) vb3).KClassImpl$Data$declaredNonStaticMembers$2).filter(new Predicate() { // from class: id.dana.cashier.fragment.CashierOtpChallengeFragment$$ExternalSyntheticLambda2
                        {
                            CashierOtpChallengeFragment.this = this;
                        }

                        @Override // io.reactivex.functions.Predicate
                        public final boolean test(Object obj) {
                            boolean MyBillsEntityDataFactory;
                            MyBillsEntityDataFactory = CashierOtpChallengeFragment.MyBillsEntityDataFactory(CashierOtpChallengeFragment.this, (CharSequence) obj);
                            return MyBillsEntityDataFactory;
                        }
                    }).subscribe(new Consumer() { // from class: id.dana.cashier.fragment.CashierOtpChallengeFragment$$ExternalSyntheticLambda3
                        {
                            CashierOtpChallengeFragment.this = this;
                        }

                        @Override // io.reactivex.functions.Consumer
                        public final void accept(Object obj) {
                            CashierOtpChallengeFragment.KClassImpl$Data$declaredNonStaticMembers$2(CashierOtpChallengeFragment.this, (CharSequence) obj);
                        }
                    }));
                    B();
                    DatabaseTableConfigUtil();
                    return;
                }
                throw new IllegalArgumentException("Required value was null.".toString());
            }
            throw new IllegalArgumentException("Required value was null.".toString());
        }
        throw new IllegalArgumentException("Required value was null.".toString());
    }

    @Override // id.dana.cashier.fragment.BaseVBCashierFragment
    public final void A() {
        Pair[] pairArr = new Pair[3];
        VB vb = this.PlaceComponentResult;
        if (vb != 0) {
            View view = ((FragmentCashierOtpChallengeBinding) vb).NetworkUserEntityData$$ExternalSyntheticLambda2;
            Integer valueOf = Integer.valueOf((int) R.layout.view_skeleton_cashier_text_w24dp);
            pairArr[0] = new Pair(view, valueOf);
            VB vb2 = this.PlaceComponentResult;
            if (vb2 != 0) {
                pairArr[1] = new Pair(((FragmentCashierOtpChallengeBinding) vb2).DatabaseTableConfigUtil, Integer.valueOf((int) R.layout.view_skeleton_cashier_risk_field));
                VB vb3 = this.PlaceComponentResult;
                if (vb3 != 0) {
                    pairArr[2] = new Pair(((FragmentCashierOtpChallengeBinding) vb3).GetContactSyncConfig, valueOf);
                    List<ViewSkeletonScreen> MyBillsEntityDataFactory = ShimmeringUtil.MyBillsEntityDataFactory(MapsKt.hashMapOf(pairArr), 0);
                    this.MyBillsEntityDataFactory = MyBillsEntityDataFactory;
                    ShimmeringUtil.KClassImpl$Data$declaredNonStaticMembers$2(MyBillsEntityDataFactory);
                    return;
                }
                throw new IllegalArgumentException("Required value was null.".toString());
            }
            throw new IllegalArgumentException("Required value was null.".toString());
        }
        throw new IllegalArgumentException("Required value was null.".toString());
    }

    @Override // id.dana.cashier.fragment.BaseVBCashierFragment
    public final void getAuthRequestContext(boolean p0) {
        CashierAnalyticTracker cashierAnalyticTracker = this.cashierAnalyticTracker;
        String str = null;
        if (cashierAnalyticTracker == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            cashierAnalyticTracker = null;
        }
        String str2 = this.BuiltInFictitiousFunctionClassFactory;
        if (str2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
        } else {
            str = str2;
        }
        CashierAnalyticTracker.CC.BuiltInFictitiousFunctionClassFactory(cashierAnalyticTracker, str, TrackerKey.CashierRiskType.FACE_VERIFICATION_CASHIER, Boolean.valueOf(p0), 4);
    }
}
