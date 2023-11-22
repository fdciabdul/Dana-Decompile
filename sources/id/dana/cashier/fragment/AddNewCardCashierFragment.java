package id.dana.cashier.fragment;

import android.content.Context;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.method.LinkMovementMethod;
import android.text.style.ForegroundColorSpan;
import android.text.style.StyleSpan;
import android.view.View;
import android.widget.CompoundButton;
import androidx.appcompat.widget.AppCompatCheckBox;
import androidx.appcompat.widget.AppCompatEditText;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.view.LifecycleOwnerKt;
import com.alibaba.griver.image.photo.utils.DiskFormatter;
import com.alipay.iap.android.common.syncintegration.api.IAPSyncCommand;
import com.jakewharton.rxbinding2.widget.RxTextView;
import dagger.Lazy;
import dagger.internal.Preconditions;
import id.dana.R;
import id.dana.analytics.tracker.TrackerKey;
import id.dana.base.AbstractContract;
import id.dana.base.AbstractContractKt;
import id.dana.base.BaseActivity;
import id.dana.cardbinding.view.CardBindingDialogExtKt;
import id.dana.cashier.CardAssetUtils;
import id.dana.cashier.CashierAddOnContract;
import id.dana.cashier.CashierAddOnModule;
import id.dana.cashier.CashierCardBindingContract;
import id.dana.cashier.CashierCardBindingModule;
import id.dana.cashier.CashierContract;
import id.dana.cashier.CashierHighlightModule;
import id.dana.cashier.CashierHighlightViewListener;
import id.dana.cashier.CashierPayLaterModule;
import id.dana.cashier.CashierPayLaterViewListener;
import id.dana.cashier.CashierUserRelatedModule;
import id.dana.cashier.CashierUserRelatedViewListener;
import id.dana.cashier.CashierViewListener;
import id.dana.cashier.OneklikAnnotations;
import id.dana.cashier.RiskParamsFactory;
import id.dana.cashier.adapter.AddNewCardAdapter;
import id.dana.cashier.adapter.OnInsertVerifyElementsListener;
import id.dana.cashier.addCard.factory.CashierAddCardVerifyElementsFactory;
import id.dana.cashier.addCard.model.QueryCardVerifyElementModel;
import id.dana.cashier.domain.interactor.GetOneklikRedirectUrl;
import id.dana.cashier.domain.interactor.GetQueryCardPolicy;
import id.dana.cashier.domain.model.CheckoutExternalInfo;
import id.dana.cashier.domain.model.QueryCardPolicyInfo;
import id.dana.cashier.fragment.CashierOtpChallengeFragment;
import id.dana.cashier.fragment.LinkingOneKlikConfirmationFragment;
import id.dana.cashier.fragment.PaymentResultFragment;
import id.dana.cashier.helper.CashierErrorState;
import id.dana.cashier.helper.CashierErrorType;
import id.dana.cashier.mapper.QueryCardPolicyInfoModelMapperKt;
import id.dana.cashier.model.AddOnTrackingModel;
import id.dana.cashier.model.AssetCardModel;
import id.dana.cashier.model.AttributeCashierPayModel;
import id.dana.cashier.model.CashierAddOnModalContentModel;
import id.dana.cashier.model.CashierAddOnModalTooltipModel;
import id.dana.cashier.model.CashierCheckoutRequestModel;
import id.dana.cashier.model.CashierFaceAuthModel;
import id.dana.cashier.model.CashierOrderGoodModel;
import id.dana.cashier.model.CashierOrderGoodModelKt;
import id.dana.cashier.model.CashierPayChannelModel;
import id.dana.cashier.model.CashierPayChannelModelKt;
import id.dana.cashier.model.CashierPayMethodModel;
import id.dana.cashier.model.CashierPayModel;
import id.dana.cashier.model.ExtendCashierModel;
import id.dana.cashier.model.PayResultModel;
import id.dana.cashier.model.ProcessingMilestoneModel;
import id.dana.cashier.model.ProcessingStatus;
import id.dana.cashier.model.QueryCardPolicyInfoModel;
import id.dana.cashier.model.QueryPromotionModel;
import id.dana.cashier.model.VoucherCashierModel;
import id.dana.cashier.model.tracker.PaymentExecutionTrackerParams;
import id.dana.cashier.presenter.CashierCardBindingPresenter;
import id.dana.cashier.presenter.CashierRiskChallengePresenter;
import id.dana.cashier.tracker.CashierAnalyticTracker;
import id.dana.cashier.utils.CashierKeyParams;
import id.dana.cashier.utils.CashierPriceUtils;
import id.dana.cashier.view.CashierAddOnView;
import id.dana.cashier.view.CashierPromoView;
import id.dana.cashier.view.InputCardNumberView;
import id.dana.component.buttoncomponent.DanaButtonPrimaryView;
import id.dana.component.customtoastcomponent.CustomToast;
import id.dana.core.ui.model.UiTextModel;
import id.dana.core.ui.util.LocaleUtil;
import id.dana.di.component.ApplicationComponent;
import id.dana.di.component.CashierComponent;
import id.dana.di.component.DaggerCashierComponent;
import id.dana.di.modules.CashierAnalyticModule;
import id.dana.di.modules.CashierModule;
import id.dana.di.modules.CashierRiskChallengeModule;
import id.dana.di.modules.TopUpAndPayModule;
import id.dana.domain.payasset.model.Institution;
import id.dana.model.CurrencyAmountModel;
import id.dana.nearbyme.merchantdetail.model.MoneyViewModel;
import id.dana.pay.PayActivity;
import id.dana.richview.DanaProtectionLoadingView;
import id.dana.sendmoney.summary.SummaryActivity;
import id.dana.utils.NoUnderlineClickableSpan;
import id.dana.utils.TextUtil;
import id.dana.utils.UrlUtil;
import id.dana.webview.WebViewActivity;
import io.reactivex.Observable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.BiFunction;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.functions.Function8;
import io.reactivex.subjects.PublishSubject;
import io.reactivex.subjects.Subject;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmName;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function5;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(d1 = {"\u0000Ú\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0015\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\b\u0003\u0018\u0000 u2\u00020\u0001:\u0001uB\u0007¢\u0006\u0004\bt\u0010\u0004J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0005\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0005\u0010\u0004J\u0017\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u0003\u0010\bJ\u000f\u0010\n\u001a\u00020\tH\u0014¢\u0006\u0004\b\n\u0010\u000bJ\u0017\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\fH\u0002¢\u0006\u0004\b\u000e\u0010\u000fJ\u000f\u0010\u0011\u001a\u00020\u0010H\u0002¢\u0006\u0004\b\u0011\u0010\u0012JC\u0010\u0018\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\r2\b\u0010\u0013\u001a\u0004\u0018\u00010\r2\b\u0010\u0014\u001a\u0004\u0018\u00010\r2\u0006\u0010\u0015\u001a\u00020\r2\u0006\u0010\u0016\u001a\u00020\r2\u0006\u0010\u0017\u001a\u00020\u0006H\u0014¢\u0006\u0004\b\u0018\u0010\u0019J\u000f\u0010\u001a\u001a\u00020\u0002H\u0014¢\u0006\u0004\b\u001a\u0010\u0004J\u000f\u0010\u0018\u001a\u00020\u0002H\u0014¢\u0006\u0004\b\u0018\u0010\u0004J\u000f\u0010\u001b\u001a\u00020\u0002H\u0014¢\u0006\u0004\b\u001b\u0010\u0004J\u000f\u0010\u001c\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u001c\u0010\u0004J\u000f\u0010\u001d\u001a\u00020\u0002H\u0014¢\u0006\u0004\b\u001d\u0010\u0004J\u000f\u0010\u001e\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u001e\u0010\u0004JG\u0010 \u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0013\u001a\u00020\u00062\u0006\u0010\u0014\u001a\u00020\u00062\u0006\u0010\u0015\u001a\u00020\u00062\u0006\u0010\u0016\u001a\u00020\u00062\u0006\u0010\u0017\u001a\u00020\u00062\u0006\u0010\u001f\u001a\u00020\u0006H\u0002¢\u0006\u0004\b \u0010!J\u000f\u0010\"\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\"\u0010#J\u000f\u0010$\u001a\u00020\u0002H\u0016¢\u0006\u0004\b$\u0010\u0004J\u000f\u0010%\u001a\u00020\u0002H\u0014¢\u0006\u0004\b%\u0010\u0004J\u0017\u0010 \u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020&H\u0016¢\u0006\u0004\b \u0010'J\u000f\u0010(\u001a\u00020\u0002H\u0014¢\u0006\u0004\b(\u0010\u0004J\u000f\u0010)\u001a\u00020\u0002H\u0014¢\u0006\u0004\b)\u0010\u0004J\u0017\u0010\u0018\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020*H\u0002¢\u0006\u0004\b\u0018\u0010+J!\u0010 \u001a\u00020\u00022\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0013\u001a\u00020\u0006H\u0002¢\u0006\u0004\b \u0010,J\u0017\u0010 \u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020-H\u0014¢\u0006\u0004\b \u0010.J\u0017\u0010/\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0006H\u0014¢\u0006\u0004\b/\u0010\bJ\u001d\u0010\u001b\u001a\u00020\u00022\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u0002000\fH\u0002¢\u0006\u0004\b\u001b\u00101J\u0019\u0010 \u001a\u00020\u0002*\b\u0012\u0004\u0012\u0002000\fH\u0002¢\u0006\u0004\b \u00101R\u0018\u0010\u001b\u001a\u0004\u0018\u0001028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b)\u00103R\u0016\u0010/\u001a\u00020\r8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b(\u00104R\u001c\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u0006058\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b6\u00107R\u0016\u0010 \u001a\u00020\r8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b8\u00104R\u001c\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u0006058\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b9\u00107R\u001c\u0010;\u001a\b\u0012\u0004\u0012\u00020\u0006058\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b:\u00107R\u0012\u0010=\u001a\u00020<X\u0087\"¢\u0006\u0006\n\u0004\b=\u0010>R\u0012\u0010@\u001a\u00020?X\u0087\"¢\u0006\u0006\n\u0004\b@\u0010AR\u0012\u0010C\u001a\u00020BX\u0087\"¢\u0006\u0006\n\u0004\bC\u0010DR\u0016\u0010%\u001a\u00020E8\u0002@\u0002X\u0083.¢\u0006\u0006\n\u0004\bF\u0010GR\u001a\u0010(\u001a\b\u0012\u0004\u0012\u00020H0\f8\u0002X\u0083\u0006¢\u0006\u0006\n\u0004\bI\u0010JR\u0016\u0010)\u001a\u00020\r8\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\bK\u00104R\u0012\u0010M\u001a\u00020LX\u0087\"¢\u0006\u0006\n\u0004\bM\u0010NR\u0012\u0010P\u001a\u00020OX\u0087\"¢\u0006\u0006\n\u0004\bP\u0010QR\u0018\u0010\u001d\u001a\u0004\u0018\u00010R8\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\bS\u0010TR\u0016\u0010:\u001a\u00020\r8\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\bU\u00104R\u001c\u0010F\u001a\b\u0012\u0004\u0012\u00020\u0006058\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\bV\u00107R\u0016\u00106\u001a\u00020\r8\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\bW\u00104R\u001c\u00109\u001a\b\u0012\u0004\u0012\u00020\u0006058\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\bX\u00107R\u0016\u00108\u001a\u00020\r8\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\bY\u00104R\u001c\u0010U\u001a\b\u0012\u0004\u0012\u00020\u0006058\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\bZ\u00107R\u001c\u0010V\u001a\b\u0012\u0004\u0012\u00020\u0006058\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\b[\u00107R\u0016\u0010S\u001a\u00020\r8\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\b\\\u00104R\u0016\u0010K\u001a\u00020\r8\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\b]\u00104R\u0016\u0010I\u001a\u00020\u00068\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\b\u0005\u0010^R\u0014\u0010W\u001a\u00020_8\u0002X\u0083\u0004¢\u0006\u0006\n\u0004\b`\u0010aR\u0016\u0010Y\u001a\u00020b8\u0002@\u0002X\u0083.¢\u0006\u0006\n\u0004\bc\u0010dR\u0016\u0010Z\u001a\u0004\u0018\u00010e8\u0002X\u0083\u0006¢\u0006\u0006\n\u0004\b\u001c\u0010fR(\u0010[\u001a\u0004\u0018\u00010*2\b\u0010\u0007\u001a\u0004\u0018\u00010*8\u0002@CX\u0083\u000e¢\u0006\f\n\u0004\b\u001e\u0010g\"\u0004\b\u001b\u0010+R\u0018\u0010X\u001a\u0004\u0018\u00010h8\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\b\"\u0010iR\u001c\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u0006058\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\b\u0011\u00107R\u0016\u0010`\u001a\u00020-8\u0002@\u0002X\u0083.¢\u0006\u0006\n\u0004\b\u000e\u0010jR.\u0010\\\u001a\u0004\u0018\u00010k2\b\u0010\u0007\u001a\u0004\u0018\u00010k8\u0015@UX\u0095\u000e¢\u0006\u0012\n\u0004\b\u001b\u0010l\u001a\u0004\b/\u0010m\"\u0004\b\u0003\u0010nR\u0018\u0010]\u001a\u0004\u0018\u00010o8\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\bp\u0010qR0\u0010c\u001a\b\u0012\u0004\u0012\u00020\t0r2\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0r8\u0002@CX\u0083\u000e¢\u0006\f\n\u0004\bs\u0010J\"\u0004\b\u0003\u00101"}, d2 = {"Lid/dana/cashier/fragment/AddNewCardCashierFragment;", "Lid/dana/cashier/fragment/BaseCashierFragment;", "", "getAuthRequestContext", "()V", "getCallingPid", "", "p0", "(Z)V", "", "getLayout", "()I", "", "", "VerifyPinStateManager$executeRiskChallenge$2$1", "()Ljava/util/List;", "Landroid/text/SpannableString;", "A", "()Landroid/text/SpannableString;", "p1", "p2", "p3", "p4", "p5", "BuiltInFictitiousFunctionClassFactory", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Z)V", IAPSyncCommand.COMMAND_INIT, "PlaceComponentResult", "C", "getErrorConfigVersion", "BottomSheetCardBindingView$watcherCardNumberView$1", "p6", "KClassImpl$Data$declaredNonStaticMembers$2", "(ZZZZZZZ)Z", DiskFormatter.B, "()Z", "onDestroy", "lookAheadTest", "Lid/dana/cashier/RiskParamsFactory;", "(Lid/dana/cashier/RiskParamsFactory;)V", "NetworkUserEntityData$$ExternalSyntheticLambda0", "moveToNextValue", "Lid/dana/cashier/model/QueryCardPolicyInfoModel;", "(Lid/dana/cashier/model/QueryCardPolicyInfoModel;)V", "(Ljava/lang/Boolean;Z)V", "Lid/dana/cashier/model/CashierPayMethodModel;", "(Lid/dana/cashier/model/CashierPayMethodModel;)V", "MyBillsEntityDataFactory", "Lid/dana/cashier/addCard/model/QueryCardVerifyElementModel;", "(Ljava/util/List;)V", "Lid/dana/cashier/adapter/AddNewCardAdapter;", "Lid/dana/cashier/adapter/AddNewCardAdapter;", "Ljava/lang/String;", "Lio/reactivex/subjects/Subject;", "NetworkUserEntityData$$ExternalSyntheticLambda1", "Lio/reactivex/subjects/Subject;", "DatabaseTableConfigUtil", "initRecordTimeStamp", "NetworkUserEntityData$$ExternalSyntheticLambda2", "scheduleImpl", "Lid/dana/cashier/CashierAddOnContract$Presenter;", "cashierAddOnPresenter", "Lid/dana/cashier/CashierAddOnContract$Presenter;", "Lid/dana/cashier/tracker/CashierAnalyticTracker;", "cashierAnalyticTracker", "Lid/dana/cashier/tracker/CashierAnalyticTracker;", "Lid/dana/cashier/presenter/CashierCardBindingPresenter;", "cashierCardBindingPresenter", "Lid/dana/cashier/presenter/CashierCardBindingPresenter;", "Lid/dana/di/component/CashierComponent;", "GetContactSyncConfig", "Lid/dana/di/component/CashierComponent;", "Lid/dana/cashier/model/CashierOrderGoodModel;", "isLayoutRequested", "Ljava/util/List;", "NetworkUserEntityData$$ExternalSyntheticLambda8", "Lid/dana/cashier/CashierContract$Presenter;", "cashierPresenter", "Lid/dana/cashier/CashierContract$Presenter;", "Lid/dana/cashier/presenter/CashierRiskChallengePresenter;", "cashierRiskChallengePresenter", "Lid/dana/cashier/presenter/CashierRiskChallengePresenter;", "Lid/dana/cashier/domain/model/CheckoutExternalInfo;", "NetworkUserEntityData$$ExternalSyntheticLambda7", "Lid/dana/cashier/domain/model/CheckoutExternalInfo;", "newProxyInstance", "PrepareContext", "NetworkUserEntityData$$ExternalSyntheticLambda5", "NetworkUserEntityData$$ExternalSyntheticLambda6", "FragmentBottomSheetPaymentSettingBinding", "NetworkUserEntityData$$ExternalSyntheticLambda3", "NetworkUserEntityData$$ExternalSyntheticLambda4", "getSupportButtonTintMode", "SubSequence", "Z", "Lid/dana/cashier/fragment/AddNewCardCashierFragment$onInsertVerifyElementsListener$1;", "whenAvailable", "Lid/dana/cashier/fragment/AddNewCardCashierFragment$onInsertVerifyElementsListener$1;", "Lid/dana/cashier/model/CashierPayMethodModel$CardPayMethod;", "readMicros", "Lid/dana/cashier/model/CashierPayMethodModel$CardPayMethod;", "Lid/dana/cashier/model/PayResultModel;", "Lid/dana/cashier/model/PayResultModel;", "Lid/dana/cashier/model/QueryCardPolicyInfoModel;", "Lid/dana/cashier/model/QueryPromotionModel;", "Lid/dana/cashier/model/QueryPromotionModel;", "Lid/dana/cashier/model/CashierPayMethodModel;", "Lid/dana/cashier/model/VoucherCashierModel;", "Lid/dana/cashier/model/VoucherCashierModel;", "()Lid/dana/cashier/model/VoucherCashierModel;", "(Lid/dana/cashier/model/VoucherCashierModel;)V", "Lid/dana/model/CurrencyAmountModel;", SummaryActivity.DAYS, "Lid/dana/model/CurrencyAmountModel;", "", "getOnBoardingScenario", "<init>", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class AddNewCardCashierFragment extends BaseCashierFragment {

    /* renamed from: Companion  reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: A  reason: from kotlin metadata */
    private Subject<Boolean> getCallingPid;

    /* renamed from: B  reason: from kotlin metadata */
    private QueryPromotionModel NetworkUserEntityData$$ExternalSyntheticLambda6;

    /* renamed from: BottomSheetCardBindingView$watcherCardNumberView$1  reason: from kotlin metadata */
    private QueryCardPolicyInfoModel NetworkUserEntityData$$ExternalSyntheticLambda4;

    /* renamed from: C  reason: from kotlin metadata */
    private PayResultModel NetworkUserEntityData$$ExternalSyntheticLambda3;

    /* renamed from: D  reason: from kotlin metadata */
    private CurrencyAmountModel SubSequence;

    /* renamed from: GetContactSyncConfig  reason: from kotlin metadata */
    private CashierComponent lookAheadTest;

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda1  reason: from kotlin metadata */
    private Subject<Boolean> getAuthRequestContext;

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda2  reason: from kotlin metadata */
    private Subject<Boolean> scheduleImpl;

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda3  reason: from kotlin metadata */
    private Subject<Boolean> newProxyInstance;

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda4  reason: from kotlin metadata */
    private Subject<Boolean> PrepareContext;

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda6  reason: from kotlin metadata */
    private Subject<Boolean> initRecordTimeStamp;

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda7  reason: from kotlin metadata */
    private CheckoutExternalInfo getErrorConfigVersion;

    /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
    VoucherCashierModel getSupportButtonTintMode;

    /* renamed from: PrepareContext  reason: from kotlin metadata */
    private Subject<Boolean> GetContactSyncConfig;

    /* renamed from: VerifyPinStateManager$executeRiskChallenge$2$1  reason: from kotlin metadata */
    private CashierPayMethodModel whenAvailable;
    @Inject
    public CashierAddOnContract.Presenter cashierAddOnPresenter;
    @Inject
    public CashierAnalyticTracker cashierAnalyticTracker;
    @Inject
    public CashierCardBindingPresenter cashierCardBindingPresenter;
    @Inject
    public CashierContract.Presenter cashierPresenter;
    @Inject
    public CashierRiskChallengePresenter cashierRiskChallengePresenter;

    /* renamed from: getCallingPid  reason: from kotlin metadata */
    private boolean isLayoutRequested;

    /* renamed from: getOnBoardingScenario  reason: from kotlin metadata */
    private List<Integer> readMicros;

    /* renamed from: initRecordTimeStamp  reason: from kotlin metadata */
    private Subject<Boolean> BuiltInFictitiousFunctionClassFactory;

    /* renamed from: isLayoutRequested  reason: from kotlin metadata */
    private List<CashierOrderGoodModel> NetworkUserEntityData$$ExternalSyntheticLambda0;

    /* renamed from: moveToNextValue  reason: from kotlin metadata */
    private AddNewCardAdapter PlaceComponentResult;

    /* renamed from: readMicros  reason: from kotlin metadata */
    private CashierPayMethodModel.CardPayMethod FragmentBottomSheetPaymentSettingBinding;

    /* renamed from: whenAvailable  reason: from kotlin metadata */
    private final AddNewCardCashierFragment$onInsertVerifyElementsListener$1 NetworkUserEntityData$$ExternalSyntheticLambda5;
    public Map<Integer, View> KClassImpl$Data$declaredNonStaticMembers$2 = new LinkedHashMap();

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda8  reason: from kotlin metadata */
    private String moveToNextValue = "";

    /* renamed from: getSupportButtonTintMode  reason: from kotlin metadata */
    private String NetworkUserEntityData$$ExternalSyntheticLambda7 = "";

    /* renamed from: SubSequence  reason: from kotlin metadata */
    private String NetworkUserEntityData$$ExternalSyntheticLambda8 = "";

    /* renamed from: FragmentBottomSheetPaymentSettingBinding  reason: from kotlin metadata */
    private String DatabaseTableConfigUtil = "";

    /* renamed from: DatabaseTableConfigUtil  reason: from kotlin metadata */
    private String KClassImpl$Data$declaredNonStaticMembers$2 = "";

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda0  reason: from kotlin metadata */
    private String MyBillsEntityDataFactory = "";

    /* renamed from: newProxyInstance  reason: from kotlin metadata */
    private String NetworkUserEntityData$$ExternalSyntheticLambda2 = "";

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda5  reason: from kotlin metadata */
    private String NetworkUserEntityData$$ExternalSyntheticLambda1 = "";

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
        return R.layout.fragment_add_new_card_cashier;
    }

    /* JADX WARN: Type inference failed for: r0v6, types: [id.dana.cashier.fragment.AddNewCardCashierFragment$onInsertVerifyElementsListener$1] */
    public AddNewCardCashierFragment() {
        PublishSubject PlaceComponentResult = PublishSubject.PlaceComponentResult();
        Intrinsics.checkNotNullExpressionValue(PlaceComponentResult, "");
        this.PrepareContext = PlaceComponentResult;
        PublishSubject PlaceComponentResult2 = PublishSubject.PlaceComponentResult();
        Intrinsics.checkNotNullExpressionValue(PlaceComponentResult2, "");
        this.GetContactSyncConfig = PlaceComponentResult2;
        PublishSubject PlaceComponentResult3 = PublishSubject.PlaceComponentResult();
        Intrinsics.checkNotNullExpressionValue(PlaceComponentResult3, "");
        this.scheduleImpl = PlaceComponentResult3;
        PublishSubject PlaceComponentResult4 = PublishSubject.PlaceComponentResult();
        Intrinsics.checkNotNullExpressionValue(PlaceComponentResult4, "");
        this.initRecordTimeStamp = PlaceComponentResult4;
        PublishSubject PlaceComponentResult5 = PublishSubject.PlaceComponentResult();
        Intrinsics.checkNotNullExpressionValue(PlaceComponentResult5, "");
        this.BuiltInFictitiousFunctionClassFactory = PlaceComponentResult5;
        PublishSubject PlaceComponentResult6 = PublishSubject.PlaceComponentResult();
        Intrinsics.checkNotNullExpressionValue(PlaceComponentResult6, "");
        this.newProxyInstance = PlaceComponentResult6;
        PublishSubject PlaceComponentResult7 = PublishSubject.PlaceComponentResult();
        Intrinsics.checkNotNullExpressionValue(PlaceComponentResult7, "");
        this.getCallingPid = PlaceComponentResult7;
        PublishSubject PlaceComponentResult8 = PublishSubject.PlaceComponentResult();
        Intrinsics.checkNotNullExpressionValue(PlaceComponentResult8, "");
        this.getAuthRequestContext = PlaceComponentResult8;
        this.NetworkUserEntityData$$ExternalSyntheticLambda0 = CollectionsKt.emptyList();
        this.readMicros = new ArrayList();
        this.NetworkUserEntityData$$ExternalSyntheticLambda5 = new OnInsertVerifyElementsListener() { // from class: id.dana.cashier.fragment.AddNewCardCashierFragment$onInsertVerifyElementsListener$1
            @Override // id.dana.cashier.adapter.OnInsertVerifyElementsListener
            public final /* synthetic */ void BuiltInFictitiousFunctionClassFactory(String str) {
                OnInsertVerifyElementsListener.CC.BuiltInFictitiousFunctionClassFactory(str);
            }

            @Override // id.dana.cashier.adapter.OnInsertVerifyElementsListener
            public final void KClassImpl$Data$declaredNonStaticMembers$2(boolean p0) {
            }

            @Override // id.dana.cashier.adapter.OnInsertVerifyElementsListener
            public final void KClassImpl$Data$declaredNonStaticMembers$2(String p0, String p1) {
                Intrinsics.checkNotNullParameter(p0, "");
                Intrinsics.checkNotNullParameter(p1, "");
                AddNewCardCashierFragment.this.NetworkUserEntityData$$ExternalSyntheticLambda7 = p0;
                AddNewCardCashierFragment.this.NetworkUserEntityData$$ExternalSyntheticLambda8 = p1;
            }

            @Override // id.dana.cashier.adapter.OnInsertVerifyElementsListener
            public final void MyBillsEntityDataFactory(String p0) {
                Intrinsics.checkNotNullParameter(p0, "");
                AddNewCardCashierFragment.this.NetworkUserEntityData$$ExternalSyntheticLambda2 = p0;
            }

            @Override // id.dana.cashier.adapter.OnInsertVerifyElementsListener
            public final void PlaceComponentResult(String p0, int p1) {
                Intrinsics.checkNotNullParameter(p0, "");
                if (p1 != -1) {
                    AddNewCardCashierFragment.this.NetworkUserEntityData$$ExternalSyntheticLambda1 = p0;
                }
            }

            @Override // id.dana.cashier.adapter.OnInsertVerifyElementsListener
            public final void MyBillsEntityDataFactory(String p0, int p1) {
                Intrinsics.checkNotNullParameter(p0, "");
                AddNewCardCashierFragment.this.KClassImpl$Data$declaredNonStaticMembers$2 = p0;
            }

            @Override // id.dana.cashier.adapter.OnInsertVerifyElementsListener
            public final void BuiltInFictitiousFunctionClassFactory(String p0, int p1) {
                Intrinsics.checkNotNullParameter(p0, "");
                AddNewCardCashierFragment.this.DatabaseTableConfigUtil = p0;
            }

            @Override // id.dana.cashier.adapter.OnInsertVerifyElementsListener
            public final void KClassImpl$Data$declaredNonStaticMembers$2(String p0, int p1) {
                Intrinsics.checkNotNullParameter(p0, "");
                AddNewCardCashierFragment.this.MyBillsEntityDataFactory = p0;
            }

            @Override // id.dana.cashier.adapter.OnInsertVerifyElementsListener
            public final void lookAheadTest(boolean p0) {
                Subject subject;
                subject = AddNewCardCashierFragment.this.PrepareContext;
                subject.onNext(Boolean.valueOf(p0));
            }

            @Override // id.dana.cashier.adapter.OnInsertVerifyElementsListener
            public final void BuiltInFictitiousFunctionClassFactory(boolean p0) {
                Subject subject;
                subject = AddNewCardCashierFragment.this.GetContactSyncConfig;
                subject.onNext(Boolean.valueOf(p0));
            }

            @Override // id.dana.cashier.adapter.OnInsertVerifyElementsListener
            public final void PlaceComponentResult(boolean p0) {
                Subject subject;
                subject = AddNewCardCashierFragment.this.initRecordTimeStamp;
                subject.onNext(Boolean.valueOf(p0));
            }

            @Override // id.dana.cashier.adapter.OnInsertVerifyElementsListener
            public final void getAuthRequestContext(boolean p0) {
                Subject subject;
                subject = AddNewCardCashierFragment.this.BuiltInFictitiousFunctionClassFactory;
                subject.onNext(Boolean.valueOf(p0));
            }

            @Override // id.dana.cashier.adapter.OnInsertVerifyElementsListener
            public final void moveToNextValue(boolean p0) {
                Subject subject;
                subject = AddNewCardCashierFragment.this.newProxyInstance;
                subject.onNext(Boolean.valueOf(p0));
            }

            @Override // id.dana.cashier.adapter.OnInsertVerifyElementsListener
            public final void MyBillsEntityDataFactory(boolean p0) {
                Subject subject;
                subject = AddNewCardCashierFragment.this.getAuthRequestContext;
                subject.onNext(Boolean.valueOf(p0));
                if (p0) {
                    AddNewCardCashierFragment.moveToNextValue(AddNewCardCashierFragment.this, "");
                }
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // id.dana.cashier.fragment.BaseCashierFragment
    @JvmName(name = "MyBillsEntityDataFactory")
    /* renamed from: MyBillsEntityDataFactory  reason: from getter */
    public final VoucherCashierModel getGetSupportButtonTintMode() {
        return this.getSupportButtonTintMode;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // id.dana.cashier.fragment.BaseCashierFragment
    @JvmName(name = "getAuthRequestContext")
    public final void getAuthRequestContext(VoucherCashierModel voucherCashierModel) {
        CurrencyAmountModel currencyAmountModel;
        VoucherCashierModel voucherCashierModel2 = this.getSupportButtonTintMode;
        CurrencyAmountModel currencyAmountModel2 = null;
        if (voucherCashierModel2 != null) {
            QueryCardPolicyInfoModel queryCardPolicyInfoModel = this.NetworkUserEntityData$$ExternalSyntheticLambda4;
            currencyAmountModel = VoucherCashierModel.BuiltInFictitiousFunctionClassFactory(voucherCashierModel2, null, false, queryCardPolicyInfoModel != null ? queryCardPolicyInfoModel.getAuthRequestContext : null, 3);
        } else {
            currencyAmountModel = null;
        }
        CurrencyAmountModel BuiltInFictitiousFunctionClassFactory = voucherCashierModel != null ? VoucherCashierModel.BuiltInFictitiousFunctionClassFactory(voucherCashierModel, null, false, null, 7) : null;
        CurrencyAmountModel currencyAmountModel3 = this.SubSequence;
        if (currencyAmountModel3 != null) {
            CashierPriceUtils cashierPriceUtils = CashierPriceUtils.INSTANCE;
            currencyAmountModel2 = CashierPriceUtils.BuiltInFictitiousFunctionClassFactory(currencyAmountModel3, currencyAmountModel, BuiltInFictitiousFunctionClassFactory);
        }
        this.SubSequence = currencyAmountModel2;
        this.getSupportButtonTintMode = voucherCashierModel;
    }

    @JvmName(name = "getAuthRequestContext")
    private final void getAuthRequestContext(List<Integer> list) {
        this.readMicros = list;
        CashierAddCardVerifyElementsFactory cashierAddCardVerifyElementsFactory = CashierAddCardVerifyElementsFactory.INSTANCE;
        List<Integer> list2 = this.readMicros;
        QueryCardPolicyInfoModel queryCardPolicyInfoModel = this.NetworkUserEntityData$$ExternalSyntheticLambda4;
        PlaceComponentResult(CashierAddCardVerifyElementsFactory.PlaceComponentResult(list2, queryCardPolicyInfoModel != null ? queryCardPolicyInfoModel.NetworkUserEntityData$$ExternalSyntheticLambda0 : null));
    }

    private final void PlaceComponentResult(List<? extends QueryCardVerifyElementModel> p0) {
        AddNewCardAdapter addNewCardAdapter = this.PlaceComponentResult;
        if (addNewCardAdapter != null) {
            KClassImpl$Data$declaredNonStaticMembers$2(p0);
            addNewCardAdapter.setItems(p0);
            QueryCardPolicyInfoModel queryCardPolicyInfoModel = this.NetworkUserEntityData$$ExternalSyntheticLambda4;
            addNewCardAdapter.BuiltInFictitiousFunctionClassFactory = queryCardPolicyInfoModel != null ? queryCardPolicyInfoModel.MyBillsEntityDataFactory() : false;
        }
    }

    @Override // id.dana.cashier.fragment.BaseCashierFragment, id.dana.base.BaseFragment
    public final void init() {
        super.init();
        InputCardNumberView inputCardNumberView = (InputCardNumberView) BuiltInFictitiousFunctionClassFactory(R.id.inputCardNumberView);
        if (inputCardNumberView != null) {
            inputCardNumberView.addInputCardListener(LifecycleOwnerKt.PlaceComponentResult(this), new Function1<String, Unit>() { // from class: id.dana.cashier.fragment.AddNewCardCashierFragment$setInputCardChangeListener$1
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public final /* bridge */ /* synthetic */ Unit invoke(String str) {
                    invoke2(str);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke  reason: avoid collision after fix types in other method */
                public final void invoke2(final String str) {
                    String str2;
                    Intrinsics.checkNotNullParameter(str, "");
                    final CashierCardBindingPresenter cashierCardBindingPresenter = AddNewCardCashierFragment.this.cashierCardBindingPresenter;
                    if (cashierCardBindingPresenter == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("");
                        cashierCardBindingPresenter = null;
                    }
                    str2 = AddNewCardCashierFragment.this.moveToNextValue;
                    Intrinsics.checkNotNullParameter(str, "");
                    Intrinsics.checkNotNullParameter(str2, "");
                    cashierCardBindingPresenter.MyBillsEntityDataFactory.get().execute(GetQueryCardPolicy.Params.Companion.createQueryCardPolicy$default(GetQueryCardPolicy.Params.INSTANCE, null, str2, str, 1, null), new Function1<QueryCardPolicyInfo, Unit>() { // from class: id.dana.cashier.presenter.CashierCardBindingPresenter$getQueryCardPolicy$1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public final /* bridge */ /* synthetic */ Unit invoke(QueryCardPolicyInfo queryCardPolicyInfo) {
                            invoke2(queryCardPolicyInfo);
                            return Unit.INSTANCE;
                        }

                        /* renamed from: invoke  reason: avoid collision after fix types in other method */
                        public final void invoke2(QueryCardPolicyInfo queryCardPolicyInfo) {
                            Lazy lazy;
                            Intrinsics.checkNotNullParameter(queryCardPolicyInfo, "");
                            lazy = CashierCardBindingPresenter.this.lookAheadTest;
                            ((CashierCardBindingContract.View) lazy.get()).KClassImpl$Data$declaredNonStaticMembers$2(QueryCardPolicyInfoModelMapperKt.PlaceComponentResult(queryCardPolicyInfo), str);
                        }
                    }, new Function1<Throwable, Unit>() { // from class: id.dana.cashier.presenter.CashierCardBindingPresenter$getQueryCardPolicy$2
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
                            Lazy lazy;
                            Intrinsics.checkNotNullParameter(th, "");
                            lazy = CashierCardBindingPresenter.this.lookAheadTest;
                            ((CashierCardBindingContract.View) lazy.get()).BuiltInFictitiousFunctionClassFactory(th.getMessage());
                        }
                    });
                }
            });
        }
        InputCardNumberView inputCardNumberView2 = (InputCardNumberView) BuiltInFictitiousFunctionClassFactory(R.id.inputCardNumberView);
        if (inputCardNumberView2 != null) {
            inputCardNumberView2.setIconCardErrorHandlingListener(new Function1<String, Unit>() { // from class: id.dana.cashier.fragment.AddNewCardCashierFragment$setCardErrorHandlingListener$1
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public final /* bridge */ /* synthetic */ Unit invoke(String str) {
                    invoke2(str);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke  reason: avoid collision after fix types in other method */
                public final void invoke2(String str) {
                    AddNewCardAdapter addNewCardAdapter;
                    Intrinsics.checkNotNullParameter(str, "");
                    if (str.length() < 6) {
                        InputCardNumberView inputCardNumberView3 = (InputCardNumberView) AddNewCardCashierFragment.this.BuiltInFictitiousFunctionClassFactory(R.id.inputCardNumberView);
                        if (inputCardNumberView3 != null) {
                            inputCardNumberView3.clearCardIcon();
                        }
                        AddNewCardCashierFragment.this.PlaceComponentResult((QueryCardPolicyInfoModel) null);
                        addNewCardAdapter = AddNewCardCashierFragment.this.PlaceComponentResult;
                        if (addNewCardAdapter != null) {
                            addNewCardAdapter.removeAllItems();
                        }
                        ConstraintLayout constraintLayout = (ConstraintLayout) AddNewCardCashierFragment.this.BuiltInFictitiousFunctionClassFactory(R.id.res_0x7f0a032d_playbackstatecompat_mediakeyaction);
                        if (constraintLayout != null) {
                            constraintLayout.setVisibility(8);
                        }
                        AddNewCardCashierFragment.this.NetworkUserEntityData$$ExternalSyntheticLambda8 = "";
                        AddNewCardCashierFragment.this.NetworkUserEntityData$$ExternalSyntheticLambda7 = "";
                        AddNewCardCashierFragment.initRecordTimeStamp(AddNewCardCashierFragment.this);
                    }
                    AddNewCardCashierFragment.getErrorConfigVersion(AddNewCardCashierFragment.this, str);
                }
            });
        }
        BottomSheetCardBindingView$watcherCardNumberView$1();
        CashierAddOnView cashierAddOnView = (CashierAddOnView) BuiltInFictitiousFunctionClassFactory(R.id.res_0x7f0a029c_cyfmonitor_challengeactioncallback);
        if (cashierAddOnView != null) {
            cashierAddOnView.setOnCheckBoxAddOnClicked(new Function2<String, Boolean, Unit>() { // from class: id.dana.cashier.fragment.AddNewCardCashierFragment$onClickCashierAddOnCheckBox$1
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public final /* synthetic */ Unit invoke(String str, Boolean bool) {
                    invoke(str, bool.booleanValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(String str, boolean z) {
                    String str2;
                    CheckoutExternalInfo checkoutExternalInfo;
                    QueryCardPolicyInfoModel queryCardPolicyInfoModel;
                    List listOf;
                    CashierPayMethodModel.CardPayMethod cardPayMethod;
                    Intrinsics.checkNotNullParameter(str, "");
                    str2 = AddNewCardCashierFragment.this.moveToNextValue;
                    CheckoutExternalInfo checkoutExternalInfo2 = new CheckoutExternalInfo(null, null, null, null, null, null, 63, null);
                    AddNewCardCashierFragment addNewCardCashierFragment = AddNewCardCashierFragment.this;
                    checkoutExternalInfo = addNewCardCashierFragment.getErrorConfigVersion;
                    CashierPayMethodModel.CardPayMethod cardPayMethod2 = null;
                    checkoutExternalInfo2.setAddOn(checkoutExternalInfo != null ? checkoutExternalInfo.getAddOn() : null);
                    queryCardPolicyInfoModel = addNewCardCashierFragment.NetworkUserEntityData$$ExternalSyntheticLambda4;
                    checkoutExternalInfo2.setSelectedPayOption(queryCardPolicyInfoModel != null ? queryCardPolicyInfoModel.NetworkUserEntityData$$ExternalSyntheticLambda1 : null);
                    Unit unit = Unit.INSTANCE;
                    if (AddNewCardCashierFragment.this.getSupportButtonTintMode == null) {
                        listOf = null;
                    } else {
                        VoucherCashierModel voucherCashierModel = AddNewCardCashierFragment.this.getSupportButtonTintMode;
                        String str3 = voucherCashierModel != null ? voucherCashierModel.BuiltInFictitiousFunctionClassFactory : null;
                        if (str3 == null) {
                            str3 = "";
                        }
                        listOf = CollectionsKt.listOf(str3);
                    }
                    CashierCheckoutRequestModel cashierCheckoutRequestModel = new CashierCheckoutRequestModel(str2, Boolean.TRUE, checkoutExternalInfo2, null, null, null, null, null, listOf, null, AddNewCardCashierFragment.this.lookAheadTest, false, null, 6904, null);
                    AddNewCardCashierFragment.this.getCallingPid();
                    CashierContract.Presenter presenter = AddNewCardCashierFragment.this.cashierPresenter;
                    if (presenter == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("");
                        presenter = null;
                    }
                    cardPayMethod = AddNewCardCashierFragment.this.FragmentBottomSheetPaymentSettingBinding;
                    if (cardPayMethod == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("");
                    } else {
                        cardPayMethod2 = cardPayMethod;
                    }
                    presenter.MyBillsEntityDataFactory(cashierCheckoutRequestModel, z, str, cardPayMethod2);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // id.dana.cashier.fragment.BaseCashierFragment
    public final void getErrorConfigVersion() {
        C();
        AppCompatTextView appCompatTextView = (AppCompatTextView) BuiltInFictitiousFunctionClassFactory(R.id.res_0x7f0a15af_cameraengine_11);
        if (appCompatTextView != null) {
            appCompatTextView.setText(getString(R.string.add_new_bank_card));
        }
        InputCardNumberView inputCardNumberView = (InputCardNumberView) BuiltInFictitiousFunctionClassFactory(R.id.inputCardNumberView);
        if (inputCardNumberView != null) {
            String string = getString(R.string.input_card_number_title);
            Intrinsics.checkNotNullExpressionValue(string, "");
            inputCardNumberView.setTitle(string);
        }
        CashierPromoView cashierPromoView = (CashierPromoView) BuiltInFictitiousFunctionClassFactory(R.id.cashierPromoView);
        if (cashierPromoView != null) {
            cashierPromoView.setSelectedCashierPromoListener(new Function2<VoucherCashierModel, Boolean, Unit>() { // from class: id.dana.cashier.fragment.AddNewCardCashierFragment$initCashierPromoSelectedListener$1
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public final /* synthetic */ Unit invoke(VoucherCashierModel voucherCashierModel, Boolean bool) {
                    invoke(voucherCashierModel, bool.booleanValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(VoucherCashierModel voucherCashierModel, boolean z) {
                    AddNewCardCashierFragment.this.getAuthRequestContext(voucherCashierModel);
                }
            });
        }
        AppCompatCheckBox appCompatCheckBox = (AppCompatCheckBox) BuiltInFictitiousFunctionClassFactory(R.id.useDaemonThreadFactory_res_0x7f0a02a9);
        if (appCompatCheckBox != null) {
            appCompatCheckBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: id.dana.cashier.fragment.AddNewCardCashierFragment$$ExternalSyntheticLambda0
                @Override // android.widget.CompoundButton.OnCheckedChangeListener
                public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                    AddNewCardCashierFragment.PlaceComponentResult(AddNewCardCashierFragment.this, z);
                }
            });
        }
        CashierAddOnView cashierAddOnView = (CashierAddOnView) BuiltInFictitiousFunctionClassFactory(R.id.res_0x7f0a029c_cyfmonitor_challengeactioncallback);
        if (cashierAddOnView != null) {
            cashierAddOnView.setOnClickCashierAddOnInfo(new Function5<String, String, String, Boolean, String, Unit>() { // from class: id.dana.cashier.fragment.AddNewCardCashierFragment$setOnClickCashierAddOnInfo$1
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(5);
                }

                @Override // kotlin.jvm.functions.Function5
                public final /* synthetic */ Unit invoke(String str, String str2, String str3, Boolean bool, String str4) {
                    invoke(str, str2, str3, bool.booleanValue(), str4);
                    return Unit.INSTANCE;
                }

                public final void invoke(String str, String str2, String str3, boolean z, String str4) {
                    Intrinsics.checkNotNullParameter(str, "");
                    Intrinsics.checkNotNullParameter(str2, "");
                    Intrinsics.checkNotNullParameter(str3, "");
                    Intrinsics.checkNotNullParameter(str4, "");
                    CashierAddOnContract.Presenter presenter = AddNewCardCashierFragment.this.cashierAddOnPresenter;
                    if (presenter == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("");
                        presenter = null;
                    }
                    presenter.KClassImpl$Data$declaredNonStaticMembers$2(str2, str3, str, z, str4);
                }
            });
        }
        DanaProtectionLoadingView danaProtectionLoadingView = (DanaProtectionLoadingView) BuiltInFictitiousFunctionClassFactory(R.id.danaProtectLoadingView);
        if (danaProtectionLoadingView != null) {
            danaProtectionLoadingView.setLoadingListener(new DanaProtectionLoadingView.DanaProtectionLoadingListener() { // from class: id.dana.cashier.fragment.AddNewCardCashierFragment$initDanaProtectionLoading$1
                @Override // id.dana.richview.DanaProtectionLoadingView.DanaProtectionLoadingListener
                public final void getAuthRequestContext() {
                    BaseActivity baseActivity = AddNewCardCashierFragment.this.getBaseActivity();
                    PayActivity payActivity = baseActivity instanceof PayActivity ? (PayActivity) baseActivity : null;
                    if (payActivity != null) {
                        payActivity.enableDisableActivityTouchEvent(false);
                    }
                }

                @Override // id.dana.richview.DanaProtectionLoadingView.DanaProtectionLoadingListener
                public final void KClassImpl$Data$declaredNonStaticMembers$2() {
                    BaseActivity baseActivity = AddNewCardCashierFragment.this.getBaseActivity();
                    PayActivity payActivity = baseActivity instanceof PayActivity ? (PayActivity) baseActivity : null;
                    if (payActivity != null) {
                        payActivity.enableDisableActivityTouchEvent(true);
                    }
                }
            });
        }
    }

    private final void getAuthRequestContext(boolean p0) {
        List<Integer> mutableListOf;
        CashierAddCardVerifyElementsFactory cashierAddCardVerifyElementsFactory = CashierAddCardVerifyElementsFactory.INSTANCE;
        QueryCardPolicyInfoModel queryCardPolicyInfoModel = this.NetworkUserEntityData$$ExternalSyntheticLambda4;
        List<String> list = queryCardPolicyInfoModel != null ? queryCardPolicyInfoModel.GetContactSyncConfig : null;
        if (p0) {
            mutableListOf = CashierAddCardVerifyElementsFactory.getAuthRequestContext(list);
        } else {
            mutableListOf = CollectionsKt.mutableListOf(1);
        }
        getAuthRequestContext(mutableListOf);
    }

    @Override // id.dana.cashier.fragment.BaseCashierFragment
    public final void getAuthRequestContext() {
        String string = getString(R.string.add_new_card);
        Intrinsics.checkNotNullExpressionValue(string, "");
        getAuthRequestContext(string);
    }

    private final void BottomSheetCardBindingView$watcherCardNumberView$1() {
        Subject<Boolean> subject = this.scheduleImpl;
        Boolean bool = Boolean.FALSE;
        subject.onNext(bool);
        this.PrepareContext.onNext(bool);
        this.GetContactSyncConfig.onNext(bool);
        this.initRecordTimeStamp.onNext(bool);
        this.BuiltInFictitiousFunctionClassFactory.onNext(bool);
        this.newProxyInstance.onNext(bool);
        this.getCallingPid.onNext(bool);
        this.getAuthRequestContext.onNext(bool);
    }

    private final void C() {
        this.PlaceComponentResult = new AddNewCardAdapter(this.NetworkUserEntityData$$ExternalSyntheticLambda5);
        RecyclerView recyclerView = (RecyclerView) BuiltInFictitiousFunctionClassFactory(R.id.res_0x7f0a112b_protoserializer_externalsyntheticlambda1);
        if (recyclerView != null) {
            recyclerView.setLayoutManager(new LinearLayoutManager(recyclerView.getContext(), 1, false));
            recyclerView.setAdapter(this.PlaceComponentResult);
        }
    }

    @Override // id.dana.cashier.fragment.BaseCashierFragment
    protected final void PlaceComponentResult() {
        DaggerCashierComponent.Builder MyBillsEntityDataFactory = DaggerCashierComponent.MyBillsEntityDataFactory();
        MyBillsEntityDataFactory.BuiltInFictitiousFunctionClassFactory = (ApplicationComponent) Preconditions.getAuthRequestContext(getApplicationComponent());
        MyBillsEntityDataFactory.scheduleImpl = (CashierModule) Preconditions.getAuthRequestContext(new CashierModule(new CashierViewListener() { // from class: id.dana.cashier.fragment.AddNewCardCashierFragment$cashierModule$1
            @Override // id.dana.cashier.CashierViewListener, id.dana.cashier.CashierContract.View
            public final void KClassImpl$Data$declaredNonStaticMembers$2(CashierPayModel p0) {
                PayResultModel payResultModel;
                PayResultModel payResultModel2;
                PayResultModel payResultModel3;
                PayResultModel payResultModel4;
                PayResultModel payResultModel5;
                PayResultModel payResultModel6;
                PayResultModel payResultModel7;
                CashierContract.Presenter presenter;
                String str;
                CashierPayMethodModel.CardPayMethod cardPayMethod;
                Intrinsics.checkNotNullParameter(p0, "");
                payResultModel = AddNewCardCashierFragment.this.NetworkUserEntityData$$ExternalSyntheticLambda3;
                if (payResultModel != null) {
                    AttributeCashierPayModel attributeCashierPayModel = p0.KClassImpl$Data$declaredNonStaticMembers$2;
                    String str2 = attributeCashierPayModel != null ? attributeCashierPayModel.T : null;
                    if (str2 == null) {
                        str2 = "";
                    }
                    payResultModel.com.alibaba.griver.image.photo.utils.DiskFormatter.MB java.lang.String = str2;
                }
                payResultModel2 = AddNewCardCashierFragment.this.NetworkUserEntityData$$ExternalSyntheticLambda3;
                if (payResultModel2 != null) {
                    cardPayMethod = AddNewCardCashierFragment.this.FragmentBottomSheetPaymentSettingBinding;
                    if (cardPayMethod == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("");
                        cardPayMethod = null;
                    }
                    payResultModel2.I = cardPayMethod;
                }
                payResultModel3 = AddNewCardCashierFragment.this.NetworkUserEntityData$$ExternalSyntheticLambda3;
                if (payResultModel3 != null) {
                    AttributeCashierPayModel attributeCashierPayModel2 = p0.KClassImpl$Data$declaredNonStaticMembers$2;
                    payResultModel3.FragmentBottomSheetPaymentSettingBinding = attributeCashierPayModel2 != null ? attributeCashierPayModel2.getSupportButtonTintMode : null;
                }
                payResultModel4 = AddNewCardCashierFragment.this.NetworkUserEntityData$$ExternalSyntheticLambda3;
                if (payResultModel4 != null) {
                    AttributeCashierPayModel attributeCashierPayModel3 = p0.KClassImpl$Data$declaredNonStaticMembers$2;
                    payResultModel4.VerifyPinStateManager$executeRiskChallenge$2$2 = attributeCashierPayModel3 != null ? attributeCashierPayModel3.SummaryVoucherView$$ExternalSyntheticLambda0 : null;
                }
                payResultModel5 = AddNewCardCashierFragment.this.NetworkUserEntityData$$ExternalSyntheticLambda3;
                if (payResultModel5 != null) {
                    AttributeCashierPayModel attributeCashierPayModel4 = p0.KClassImpl$Data$declaredNonStaticMembers$2;
                    payResultModel5.C = attributeCashierPayModel4 != null ? attributeCashierPayModel4.I : null;
                }
                payResultModel6 = AddNewCardCashierFragment.this.NetworkUserEntityData$$ExternalSyntheticLambda3;
                if (payResultModel6 != null) {
                    AttributeCashierPayModel attributeCashierPayModel5 = p0.KClassImpl$Data$declaredNonStaticMembers$2;
                    payResultModel6.id.dana.sendmoney.summary.SummaryActivity.HOURS java.lang.String = attributeCashierPayModel5 != null ? attributeCashierPayModel5.W : null;
                }
                payResultModel7 = AddNewCardCashierFragment.this.NetworkUserEntityData$$ExternalSyntheticLambda3;
                if (payResultModel7 != null) {
                    AttributeCashierPayModel attributeCashierPayModel6 = p0.KClassImpl$Data$declaredNonStaticMembers$2;
                    payResultModel7.whenAvailable = attributeCashierPayModel6 != null ? attributeCashierPayModel6.getValueOfTouchPositionAbsolute : null;
                }
                final AttributeCashierPayModel attributeCashierPayModel7 = p0.KClassImpl$Data$declaredNonStaticMembers$2;
                if (attributeCashierPayModel7 != null) {
                    final AddNewCardCashierFragment addNewCardCashierFragment = AddNewCardCashierFragment.this;
                    if (attributeCashierPayModel7.MyBillsEntityDataFactory()) {
                        addNewCardCashierFragment.PlaceComponentResult(new Function1<View, Unit>() { // from class: id.dana.cashier.fragment.AddNewCardCashierFragment$cashierModule$1$onSuccessPayCashier$1$1
                            /* JADX INFO: Access modifiers changed from: package-private */
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
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
                                Intrinsics.checkNotNullParameter(view, "");
                                AddNewCardCashierFragment.this.PlaceComponentResult(attributeCashierPayModel7);
                            }
                        });
                    } else if (attributeCashierPayModel7.KClassImpl$Data$declaredNonStaticMembers$2()) {
                        AddNewCardCashierFragment.KClassImpl$Data$declaredNonStaticMembers$2(addNewCardCashierFragment, attributeCashierPayModel7);
                    } else {
                        CashierContract.Presenter presenter2 = addNewCardCashierFragment.cashierPresenter;
                        if (presenter2 != null) {
                            presenter = presenter2;
                        } else {
                            Intrinsics.throwUninitializedPropertyAccessException("");
                            presenter = null;
                        }
                        str = addNewCardCashierFragment.moveToNextValue;
                        presenter.KClassImpl$Data$declaredNonStaticMembers$2(str, null, (r12 & 4) != 0 ? false : false, (r12 & 8) != 0 ? null : null, (r12 & 16) != 0 ? null : null);
                    }
                }
            }

            @Override // id.dana.cashier.CashierViewListener, id.dana.cashier.CashierContract.View
            public final void PlaceComponentResult(QueryPromotionModel p0) {
                Intrinsics.checkNotNullParameter(p0, "");
                AddNewCardCashierFragment.this.NetworkUserEntityData$$ExternalSyntheticLambda6 = p0;
            }

            @Override // id.dana.cashier.CashierViewListener, id.dana.cashier.CashierContract.View
            public final void getAuthRequestContext(String p0, String p1, boolean p2) {
                Intrinsics.checkNotNullParameter(p0, "");
                CashierAddOnView cashierAddOnView = (CashierAddOnView) AddNewCardCashierFragment.this.BuiltInFictitiousFunctionClassFactory(R.id.res_0x7f0a029c_cyfmonitor_challengeactioncallback);
                if (cashierAddOnView != null) {
                    cashierAddOnView.doFallbackAddOnCheckBox(p0);
                }
                String str = p1;
                if (!(str == null || str.length() == 0)) {
                    BaseCashierFragment.KClassImpl$Data$declaredNonStaticMembers$2(AddNewCardCashierFragment.this, p1);
                    return;
                }
                AddNewCardCashierFragment addNewCardCashierFragment = AddNewCardCashierFragment.this;
                String string = addNewCardCashierFragment.getString(R.string.warning_add_on_not_supported);
                BaseActivity baseActivity = addNewCardCashierFragment.getBaseActivity();
                Intrinsics.checkNotNullExpressionValue(baseActivity, "");
                CustomToast.BuiltInFictitiousFunctionClassFactory(baseActivity, R.drawable.ic_warning_24_yellow50, R.drawable.bg_rounded_toast_payment_auth, string, 72, true, null);
            }

            @Override // id.dana.cashier.CashierViewListener, id.dana.base.AbstractContractKt.AbstractView, id.dana.base.AbstractContract.AbstractView
            public final void showProgress() {
                AddNewCardCashierFragment.this.readMicros();
            }

            @Override // id.dana.cashier.CashierViewListener, id.dana.base.AbstractContractKt.AbstractView, id.dana.base.AbstractContract.AbstractView
            public final void dismissProgress() {
                AddNewCardCashierFragment.this.scheduleImpl();
            }

            @Override // id.dana.cashier.CashierViewListener, id.dana.cashier.CashierContract.View
            public final void getAuthRequestContext(CashierErrorState p0) {
                Intrinsics.checkNotNullParameter(p0, "");
                AddNewCardCashierFragment.this.KClassImpl$Data$declaredNonStaticMembers$2(p0);
            }

            @Override // id.dana.cashier.CashierViewListener, id.dana.cashier.CashierContract.View, id.dana.cashier.TopUpAndPayContract.View
            public final void BuiltInFictitiousFunctionClassFactory(CashierErrorState p0) {
                Intrinsics.checkNotNullParameter(p0, "");
                AddNewCardCashierFragment.this.KClassImpl$Data$declaredNonStaticMembers$2(p0);
            }

            @Override // id.dana.cashier.CashierViewListener, id.dana.cashier.CashierContract.View, id.dana.cashier.TopUpAndPayContract.View
            public final void getErrorConfigVersion() {
                AddNewCardCashierFragment.this.MyBillsEntityDataFactory(true);
            }

            /* JADX WARN: Type inference failed for: r4v0, types: [kotlin.jvm.internal.DefaultConstructorMarker, java.lang.Object[]] */
            @Override // id.dana.cashier.CashierViewListener, id.dana.cashier.CashierContract.View, id.dana.cashier.TopUpAndPayContract.View
            public final void scheduleImpl() {
                if (AddNewCardCashierFragment.this.getMoveToNextValue()) {
                    ?? r4 = 0;
                    AddNewCardCashierFragment.this.KClassImpl$Data$declaredNonStaticMembers$2(new CashierErrorState(CashierErrorType.FORCE_FACE_AUTH_ERROR, new UiTextModel.StringResource(R.string.force_face_auth_error_message, r4, 2, r4), CashierErrorType.FORCE_FACE_AUTH_ERROR));
                } else {
                    AddNewCardCashierFragment.this.getErrorConfigVersion = true;
                }
                AddNewCardCashierFragment.this.MyBillsEntityDataFactory(false);
            }

            @Override // id.dana.cashier.CashierViewListener, id.dana.cashier.CashierContract.View, id.dana.cashier.TopUpAndPayContract.View
            public final void getAuthRequestContext() {
                PayResultModel payResultModel;
                PayResultModel payResultModel2;
                if (AddNewCardCashierFragment.this.getMoveToNextValue()) {
                    payResultModel = AddNewCardCashierFragment.this.NetworkUserEntityData$$ExternalSyntheticLambda3;
                    if (payResultModel != null) {
                        String str = AddNewCardCashierFragment.this.scheduleImpl;
                        Intrinsics.checkNotNullParameter(str, "");
                        payResultModel.BuiltInFictitiousFunctionClassFactory = str;
                    }
                    payResultModel2 = AddNewCardCashierFragment.this.NetworkUserEntityData$$ExternalSyntheticLambda3;
                    if (payResultModel2 != null) {
                        payResultModel2.DatabaseTableConfigUtil = true;
                    }
                    BaseCashierFragment.KClassImpl$Data$declaredNonStaticMembers$2(AddNewCardCashierFragment.this, ProcessingStatus.PROCESSING, null, null, null, null, false, 62);
                }
                AddNewCardCashierFragment.this.MyBillsEntityDataFactory(false);
            }

            @Override // id.dana.cashier.CashierViewListener, id.dana.base.AbstractContractKt.AbstractView, id.dana.base.AbstractContract.AbstractView
            public final void onError(String p0) {
                AddNewCardCashierFragment addNewCardCashierFragment = AddNewCardCashierFragment.this;
                if (p0 == null) {
                    p0 = "";
                }
                BaseCashierFragment.KClassImpl$Data$declaredNonStaticMembers$2(addNewCardCashierFragment, p0);
            }

            @Override // id.dana.cashier.CashierViewListener, id.dana.cashier.CashierCardBindingContract.View
            public final void PlaceComponentResult(String p0) {
                Intrinsics.checkNotNullParameter(p0, "");
                AddNewCardCashierFragment.KClassImpl$Data$declaredNonStaticMembers$2(AddNewCardCashierFragment.this, p0);
            }

            @Override // id.dana.cashier.CashierViewListener, id.dana.cashier.CashierContract.View, id.dana.cashier.TopUpAndPayContract.View
            public final void MyBillsEntityDataFactory(CashierPayModel p0) {
                PayResultModel payResultModel;
                String str;
                String str2;
                CashierPayMethodModel.CardPayMethod cardPayMethod;
                CashierPayChannelModel cashierPayChannelModel;
                ExtendCashierModel extendCashierModel;
                String format;
                String format2;
                Intrinsics.checkNotNullParameter(p0, "");
                AttributeCashierPayModel attributeCashierPayModel = p0.KClassImpl$Data$declaredNonStaticMembers$2;
                if (attributeCashierPayModel != null) {
                    AddNewCardCashierFragment addNewCardCashierFragment = AddNewCardCashierFragment.this;
                    if (!attributeCashierPayModel.KClassImpl$Data$declaredNonStaticMembers$2()) {
                        payResultModel = addNewCardCashierFragment.NetworkUserEntityData$$ExternalSyntheticLambda3;
                        if (payResultModel != null) {
                            String str3 = attributeCashierPayModel.SubSequence;
                            if (str3 == null) {
                                str3 = "";
                            }
                            Intrinsics.checkNotNullParameter(str3, "");
                            payResultModel.PrepareContext = str3;
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
                            payResultModel.KClassImpl$Data$declaredNonStaticMembers$2(str2);
                            List<CashierPayChannelModel> list = attributeCashierPayModel.I;
                            String str4 = (list == null || (cashierPayChannelModel = (CashierPayChannelModel) CollectionsKt.getOrNull(list, 0)) == null || (extendCashierModel = cashierPayChannelModel.newProxyInstance) == null) ? null : extendCashierModel.NetworkUserEntityData$$ExternalSyntheticLambda0;
                            if (str4 == null) {
                                str4 = "";
                            }
                            Intrinsics.checkNotNullParameter(str4, "");
                            payResultModel.A = str4;
                            String str5 = attributeCashierPayModel.com.alibaba.griver.image.photo.utils.DiskFormatter.GB java.lang.String;
                            if (str5 == null) {
                                str5 = "";
                            }
                            Intrinsics.checkNotNullParameter(str5, "");
                            payResultModel.com.alibaba.griver.image.photo.utils.DiskFormatter.B java.lang.String = str5;
                            String str6 = attributeCashierPayModel.KClassImpl$Data$declaredNonStaticMembers$2;
                            if (str6 == null) {
                                str6 = "";
                            }
                            Intrinsics.checkNotNullParameter(str6, "");
                            payResultModel.BuiltInFictitiousFunctionClassFactory = str6;
                            String str7 = attributeCashierPayModel.E;
                            if (str7 == null) {
                                str7 = "";
                            }
                            payResultModel.L = str7;
                            payResultModel.getAuthRequestContext = attributeCashierPayModel.getAuthRequestContext();
                            cardPayMethod = addNewCardCashierFragment.FragmentBottomSheetPaymentSettingBinding;
                            if (cardPayMethod == null) {
                                Intrinsics.throwUninitializedPropertyAccessException("");
                                cardPayMethod = null;
                            }
                            payResultModel.I = cardPayMethod;
                            payResultModel.moveToNextValue = attributeCashierPayModel.NetworkUserEntityData$$ExternalSyntheticLambda0;
                            String str8 = attributeCashierPayModel.BottomSheetCardBindingView$watcherCardNumberView$1;
                            if (str8 == null) {
                                str8 = "";
                            }
                            Intrinsics.checkNotNullParameter(str8, "");
                            payResultModel.readMicros = str8;
                            payResultModel.isLayoutRequested = p0.KClassImpl$Data$declaredNonStaticMembers$2.NetworkUserEntityData$$ExternalSyntheticLambda8;
                            ProcessingMilestoneModel processingMilestoneModel = attributeCashierPayModel.L;
                            payResultModel.getCallingPid = processingMilestoneModel != null ? processingMilestoneModel.PlaceComponentResult : null;
                            payResultModel.getSupportButtonTintMode = attributeCashierPayModel.getOnBoardingScenario;
                            payResultModel.VerifyPinStateManager$executeRiskChallenge$2$2 = attributeCashierPayModel.SummaryVoucherView$$ExternalSyntheticLambda0;
                            payResultModel.NetworkUserEntityData$$ExternalSyntheticLambda2 = attributeCashierPayModel.GetContactSyncConfig;
                            payResultModel.FragmentBottomSheetPaymentSettingBinding = attributeCashierPayModel.getSupportButtonTintMode;
                            payResultModel.NetworkUserEntityData$$ExternalSyntheticLambda8 = attributeCashierPayModel.NetworkUserEntityData$$ExternalSyntheticLambda6;
                            payResultModel.NetworkUserEntityData$$ExternalSyntheticLambda3 = attributeCashierPayModel.A;
                            payResultModel.getOnBoardingScenario = attributeCashierPayModel.J;
                            payResultModel.K = attributeCashierPayModel.V;
                            String BuiltInFictitiousFunctionClassFactory = attributeCashierPayModel.BuiltInFictitiousFunctionClassFactory();
                            Intrinsics.checkNotNullParameter(BuiltInFictitiousFunctionClassFactory, "");
                            payResultModel.NetworkUserEntityData$$ExternalSyntheticLambda1 = BuiltInFictitiousFunctionClassFactory;
                            Boolean bool = attributeCashierPayModel.NetworkUserEntityData$$ExternalSyntheticLambda4;
                            payResultModel.newProxyInstance = bool != null ? bool.booleanValue() : false;
                            Boolean bool2 = attributeCashierPayModel.VerifyPinStateManager$executeRiskChallenge$2$1;
                            payResultModel.NetworkUserEntityData$$ExternalSyntheticLambda6 = bool2 != null ? bool2.booleanValue() : false;
                            payResultModel.MyBillsEntityDataFactory = attributeCashierPayModel.BuiltInFictitiousFunctionClassFactory;
                        }
                        AddNewCardCashierFragment addNewCardCashierFragment2 = addNewCardCashierFragment;
                        String str9 = attributeCashierPayModel.O;
                        BaseCashierFragment.KClassImpl$Data$declaredNonStaticMembers$2(addNewCardCashierFragment2, str9 == null ? "" : str9, null, null, null, null, CashierPayChannelModelKt.KClassImpl$Data$declaredNonStaticMembers$2(attributeCashierPayModel.I), 30);
                        return;
                    }
                    AddNewCardCashierFragment.KClassImpl$Data$declaredNonStaticMembers$2(addNewCardCashierFragment, p0.KClassImpl$Data$declaredNonStaticMembers$2);
                }
            }

            /* JADX WARN: Removed duplicated region for block: B:19:0x0038  */
            @Override // id.dana.cashier.CashierViewListener, id.dana.cashier.CashierContract.View
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public final void getAuthRequestContext(id.dana.cashier.model.AttributeModel r3, boolean r4, java.lang.String r5, java.util.List<? extends id.dana.cashier.model.CashierPayMethodModel> r6) {
                /*
                    r2 = this;
                    java.lang.String r0 = ""
                    kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r5, r0)
                    kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r6, r0)
                    r6 = 0
                    if (r3 == 0) goto L33
                    java.util.List<id.dana.cashier.model.CashierOrderGoodModel> r3 = r3.NetworkUserEntityData$$ExternalSyntheticLambda0
                    if (r3 == 0) goto L33
                    java.lang.Iterable r3 = (java.lang.Iterable) r3
                    java.util.Iterator r3 = r3.iterator()
                L15:
                    boolean r0 = r3.hasNext()
                    if (r0 == 0) goto L2b
                    java.lang.Object r0 = r3.next()
                    r1 = r0
                    id.dana.cashier.model.CashierOrderGoodModel r1 = (id.dana.cashier.model.CashierOrderGoodModel) r1
                    java.lang.String r1 = r1.MyBillsEntityDataFactory
                    boolean r1 = kotlin.jvm.internal.Intrinsics.areEqual(r1, r5)
                    if (r1 == 0) goto L15
                    goto L2c
                L2b:
                    r0 = r6
                L2c:
                    id.dana.cashier.model.CashierOrderGoodModel r0 = (id.dana.cashier.model.CashierOrderGoodModel) r0
                    if (r0 == 0) goto L33
                    id.dana.nearbyme.merchantdetail.model.MoneyViewModel r3 = r0.getAuthRequestContext
                    goto L34
                L33:
                    r3 = r6
                L34:
                    id.dana.cashier.fragment.AddNewCardCashierFragment r5 = id.dana.cashier.fragment.AddNewCardCashierFragment.this
                    if (r3 == 0) goto L3e
                    id.dana.nearbyme.merchantdetail.model.MoneyViewModel$Companion r6 = id.dana.nearbyme.merchantdetail.model.MoneyViewModel.INSTANCE
                    id.dana.model.CurrencyAmountModel r6 = id.dana.nearbyme.merchantdetail.model.MoneyViewModel.Companion.PlaceComponentResult(r3)
                L3e:
                    id.dana.cashier.fragment.AddNewCardCashierFragment.KClassImpl$Data$declaredNonStaticMembers$2(r5, r6, r4)
                    return
                */
                throw new UnsupportedOperationException("Method not decompiled: id.dana.cashier.fragment.AddNewCardCashierFragment$cashierModule$1.getAuthRequestContext(id.dana.cashier.model.AttributeModel, boolean, java.lang.String, java.util.List):void");
            }
        }));
        MyBillsEntityDataFactory.NetworkUserEntityData$$ExternalSyntheticLambda0 = (CashierRiskChallengeModule) Preconditions.getAuthRequestContext(new CashierRiskChallengeModule(new CashierViewListener() { // from class: id.dana.cashier.fragment.AddNewCardCashierFragment$cashierRiskChallengeModule$1
            @Override // id.dana.cashier.CashierViewListener, id.dana.cashier.CashierRiskChallengeContract.View
            public final void getAuthRequestContext(int i, int i2) {
                if (i2 == 0) {
                    CardBindingDialogExtKt.BuiltInFictitiousFunctionClassFactory(AddNewCardCashierFragment.this.getContext());
                } else {
                    AddNewCardCashierFragment.MyBillsEntityDataFactory(AddNewCardCashierFragment.this, i, i2);
                }
            }

            @Override // id.dana.cashier.CashierViewListener, id.dana.base.AbstractContractKt.AbstractView, id.dana.base.AbstractContract.AbstractView
            public final void showProgress() {
                AddNewCardCashierFragment.this.readMicros();
            }

            @Override // id.dana.cashier.CashierViewListener, id.dana.base.AbstractContractKt.AbstractView, id.dana.base.AbstractContract.AbstractView
            public final void dismissProgress() {
                AddNewCardCashierFragment.this.scheduleImpl();
            }

            @Override // id.dana.cashier.CashierViewListener, id.dana.cashier.CashierRiskChallengeContract.View
            public final void getErrorConfigVersion(CashierErrorState p0) {
                Intrinsics.checkNotNullParameter(p0, "");
                if (Intrinsics.areEqual(p0.KClassImpl$Data$declaredNonStaticMembers$2, "AE11112060030102")) {
                    AddNewCardCashierFragment addNewCardCashierFragment = AddNewCardCashierFragment.this;
                    String string = addNewCardCashierFragment.getString(R.string.bank_account_number_invalid);
                    Intrinsics.checkNotNullExpressionValue(string, "");
                    AddNewCardCashierFragment.moveToNextValue(addNewCardCashierFragment, string);
                    return;
                }
                BaseCashierFragment.KClassImpl$Data$declaredNonStaticMembers$2(AddNewCardCashierFragment.this, p0.getAuthRequestContext.asString(AddNewCardCashierFragment.this.getContext()));
            }
        }));
        MyBillsEntityDataFactory.getErrorConfigVersion = (TopUpAndPayModule) Preconditions.getAuthRequestContext(new TopUpAndPayModule(new CashierViewListener() { // from class: id.dana.cashier.fragment.AddNewCardCashierFragment$topUpAndPayModule$1
        }));
        MyBillsEntityDataFactory.PlaceComponentResult = (CashierCardBindingModule) Preconditions.getAuthRequestContext(new CashierCardBindingModule(new CashierViewListener() { // from class: id.dana.cashier.fragment.AddNewCardCashierFragment$cashierCardBindingModule$1
            @Override // id.dana.cashier.CashierViewListener, id.dana.cashier.CashierCardBindingContract.View
            public final void KClassImpl$Data$declaredNonStaticMembers$2(QueryCardPolicyInfoModel p0, String p1) {
                Intrinsics.checkNotNullParameter(p0, "");
                Intrinsics.checkNotNullParameter(p1, "");
                AddNewCardCashierFragment.MyBillsEntityDataFactory(AddNewCardCashierFragment.this, p0, p1);
            }

            @Override // id.dana.cashier.CashierViewListener, id.dana.cashier.CashierCardBindingContract.View
            public final void BuiltInFictitiousFunctionClassFactory(String p0) {
                InputCardNumberView inputCardNumberView = (InputCardNumberView) AddNewCardCashierFragment.this.BuiltInFictitiousFunctionClassFactory(R.id.inputCardNumberView);
                if (inputCardNumberView != null) {
                    if (p0 == null) {
                        p0 = "";
                    }
                    inputCardNumberView.setErrorMessage(TextUtil.lookAheadTest(p0));
                }
            }
        }));
        MyBillsEntityDataFactory.MyBillsEntityDataFactory = (CashierAnalyticModule) Preconditions.getAuthRequestContext(new CashierAnalyticModule());
        MyBillsEntityDataFactory.moveToNextValue = (CashierPayLaterModule) Preconditions.getAuthRequestContext(new CashierPayLaterModule(new CashierPayLaterViewListener() { // from class: id.dana.cashier.fragment.AddNewCardCashierFragment$cashierPayLaterModule$1
        }));
        MyBillsEntityDataFactory.KClassImpl$Data$declaredNonStaticMembers$2 = (CashierAddOnModule) Preconditions.getAuthRequestContext(new CashierAddOnModule(new CashierAddOnContract.View() { // from class: id.dana.cashier.fragment.AddNewCardCashierFragment$cashierAddOnModule$1
            @Override // id.dana.base.AbstractContractKt.AbstractView
            public final /* synthetic */ String getErrorSource() {
                return AbstractContractKt.AbstractView.CC.getAuthRequestContext();
            }

            @Override // id.dana.cashier.CashierAddOnContract.View
            public final void KClassImpl$Data$declaredNonStaticMembers$2(CashierAddOnModalTooltipModel p0, CashierAddOnModalContentModel p1) {
                CashierAddOnView cashierAddOnView = (CashierAddOnView) AddNewCardCashierFragment.this.BuiltInFictitiousFunctionClassFactory(R.id.res_0x7f0a029c_cyfmonitor_challengeactioncallback);
                if (cashierAddOnView != null) {
                    cashierAddOnView.initCashierAddOnInfoDialog(p0, p1);
                }
            }

            @Override // id.dana.cashier.CashierAddOnContract.View
            public final void BuiltInFictitiousFunctionClassFactory(String p0, String p1, String p2) {
                Intrinsics.checkNotNullParameter(p0, "");
                Intrinsics.checkNotNullParameter(p1, "");
                Intrinsics.checkNotNullParameter(p2, "");
                CashierAddOnView cashierAddOnView = (CashierAddOnView) AddNewCardCashierFragment.this.BuiltInFictitiousFunctionClassFactory(R.id.res_0x7f0a029c_cyfmonitor_challengeactioncallback);
                if (cashierAddOnView != null) {
                    cashierAddOnView.initcashierAddOnInfoDialogFromCdn(p0, p1, p2);
                }
            }

            @Override // id.dana.base.AbstractContractKt.AbstractView, id.dana.base.AbstractContract.AbstractView
            public final void showProgress() {
                AddNewCardCashierFragment.this.readMicros();
            }

            @Override // id.dana.base.AbstractContractKt.AbstractView, id.dana.base.AbstractContract.AbstractView
            public final void dismissProgress() {
                AddNewCardCashierFragment.this.scheduleImpl();
            }

            @Override // id.dana.base.AbstractContractKt.AbstractView, id.dana.base.AbstractContract.AbstractView
            public final void onError(String p0) {
                BaseCashierFragment.KClassImpl$Data$declaredNonStaticMembers$2(AddNewCardCashierFragment.this, p0);
            }
        }));
        MyBillsEntityDataFactory.lookAheadTest = (CashierUserRelatedModule) Preconditions.getAuthRequestContext(new CashierUserRelatedModule(new CashierUserRelatedViewListener() { // from class: id.dana.cashier.fragment.AddNewCardCashierFragment$cashierUserRelatedModule$1
        }));
        MyBillsEntityDataFactory.getAuthRequestContext = (CashierHighlightModule) Preconditions.getAuthRequestContext(new CashierHighlightModule(new CashierHighlightViewListener() { // from class: id.dana.cashier.fragment.AddNewCardCashierFragment$cashierHighlightModule$1
        }));
        CashierComponent MyBillsEntityDataFactory2 = MyBillsEntityDataFactory.MyBillsEntityDataFactory();
        Intrinsics.checkNotNullExpressionValue(MyBillsEntityDataFactory2, "");
        this.lookAheadTest = MyBillsEntityDataFactory2;
        MyBillsEntityDataFactory2.BuiltInFictitiousFunctionClassFactory(this);
        AbstractContract.AbstractPresenter[] abstractPresenterArr = new AbstractContract.AbstractPresenter[4];
        CashierContract.Presenter presenter = this.cashierPresenter;
        CashierRiskChallengePresenter cashierRiskChallengePresenter = null;
        if (presenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            presenter = null;
        }
        abstractPresenterArr[0] = presenter;
        CashierRiskChallengePresenter cashierRiskChallengePresenter2 = this.cashierRiskChallengePresenter;
        if (cashierRiskChallengePresenter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            cashierRiskChallengePresenter2 = null;
        }
        abstractPresenterArr[1] = cashierRiskChallengePresenter2;
        CashierCardBindingPresenter cashierCardBindingPresenter = this.cashierCardBindingPresenter;
        if (cashierCardBindingPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            cashierCardBindingPresenter = null;
        }
        abstractPresenterArr[2] = cashierCardBindingPresenter;
        CashierRiskChallengePresenter cashierRiskChallengePresenter3 = this.cashierRiskChallengePresenter;
        if (cashierRiskChallengePresenter3 != null) {
            cashierRiskChallengePresenter = cashierRiskChallengePresenter3;
        } else {
            Intrinsics.throwUninitializedPropertyAccessException("");
        }
        abstractPresenterArr[3] = cashierRiskChallengePresenter;
        registerPresenter(abstractPresenterArr);
        Observable combineLatest = Observable.combineLatest(RxTextView.textChanges((AppCompatEditText) ((InputCardNumberView) BuiltInFictitiousFunctionClassFactory(R.id.inputCardNumberView))._$_findCachedViewById(R.id.GetFriendsFeedWithInitFeedAndFeatureCheck_res_0x7f0a0671)).map(new Function() { // from class: id.dana.cashier.fragment.AddNewCardCashierFragment$$ExternalSyntheticLambda4
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                return AddNewCardCashierFragment.getAuthRequestContext((CharSequence) obj);
            }
        }), this.scheduleImpl, new BiFunction() { // from class: id.dana.cashier.fragment.AddNewCardCashierFragment$$ExternalSyntheticLambda5
            @Override // io.reactivex.functions.BiFunction
            public final Object apply(Object obj, Object obj2) {
                Boolean valueOf;
                ((Boolean) obj).booleanValue();
                ((Boolean) obj2).booleanValue();
                valueOf = Boolean.valueOf(r0 && r1);
                return valueOf;
            }
        });
        Intrinsics.checkNotNullExpressionValue(combineLatest, "");
        Disposable subscribe = Observable.combineLatest(combineLatest, this.PrepareContext, this.GetContactSyncConfig, this.initRecordTimeStamp, this.BuiltInFictitiousFunctionClassFactory, this.newProxyInstance, this.getCallingPid, this.getAuthRequestContext, new Function8() { // from class: id.dana.cashier.fragment.AddNewCardCashierFragment$$ExternalSyntheticLambda2
            @Override // io.reactivex.functions.Function8
            public final Object apply(Object obj, Object obj2, Object obj3, Object obj4, Object obj5, Object obj6, Object obj7, Object obj8) {
                return AddNewCardCashierFragment.getAuthRequestContext(AddNewCardCashierFragment.this, ((Boolean) obj).booleanValue(), ((Boolean) obj2).booleanValue(), ((Boolean) obj3).booleanValue(), ((Boolean) obj4).booleanValue(), (Boolean) obj5, (Boolean) obj6, (Boolean) obj7, (Boolean) obj8);
            }
        }).subscribe(new Consumer() { // from class: id.dana.cashier.fragment.AddNewCardCashierFragment$$ExternalSyntheticLambda3
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                AddNewCardCashierFragment.MyBillsEntityDataFactory(AddNewCardCashierFragment.this, ((Boolean) obj).booleanValue());
            }
        });
        Intrinsics.checkNotNullExpressionValue(subscribe, "");
        addDisposable(subscribe);
    }

    @Override // id.dana.cashier.fragment.BaseCashierFragment
    protected final void moveToNextValue() {
        Bundle arguments = getArguments();
        if (arguments != null) {
            String string = arguments.getString(CashierKeyParams.CASHIER_ORDER_ID, "");
            Intrinsics.checkNotNullExpressionValue(string, "");
            this.moveToNextValue = string;
            String string2 = arguments.getString("bizOrderId", "");
            Intrinsics.checkNotNullExpressionValue(string2, "");
            Intrinsics.checkNotNullParameter(string2, "");
            this.scheduleImpl = string2;
            PayResultModel payResultModel = (PayResultModel) arguments.getParcelable(CashierKeyParams.PAY_RESULT_MODEL);
            this.NetworkUserEntityData$$ExternalSyntheticLambda3 = payResultModel;
            this.SubSequence = new CurrencyAmountModel(payResultModel != null ? payResultModel.AppCompatEmojiTextHelper : null, "Rp");
            ArrayList parcelableArrayList = arguments.getParcelableArrayList(CashierKeyParams.CASHIER_ORDER_GOODS);
            final List<CashierOrderGoodModel> list = parcelableArrayList != null ? CollectionsKt.toList(parcelableArrayList) : null;
            if (list == null) {
                list = CollectionsKt.emptyList();
            }
            CashierContract.Presenter presenter = this.cashierPresenter;
            if (presenter == null) {
                Intrinsics.throwUninitializedPropertyAccessException("");
                presenter = null;
            }
            presenter.KClassImpl$Data$declaredNonStaticMembers$2(CashierOrderGoodModelKt.KClassImpl$Data$declaredNonStaticMembers$2(list));
            CashierContract.Presenter presenter2 = this.cashierPresenter;
            if (presenter2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("");
                presenter2 = null;
            }
            presenter2.BuiltInFictitiousFunctionClassFactory(list);
            this.isLayoutRequested = !list.isEmpty();
            CashierAddOnView cashierAddOnView = (CashierAddOnView) BuiltInFictitiousFunctionClassFactory(R.id.res_0x7f0a029c_cyfmonitor_challengeactioncallback);
            if (cashierAddOnView != null) {
                cashierAddOnView.setItems(list);
            }
            KClassImpl$Data$declaredNonStaticMembers$2(new Function1<Boolean, Unit>() { // from class: id.dana.cashier.fragment.AddNewCardCashierFragment$cashierOrderGoods$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public final /* synthetic */ Unit invoke(Boolean bool) {
                    invoke(bool.booleanValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(boolean z) {
                    CashierAddOnView cashierAddOnView2 = (CashierAddOnView) AddNewCardCashierFragment.this.BuiltInFictitiousFunctionClassFactory(R.id.res_0x7f0a029c_cyfmonitor_challengeactioncallback);
                    if (cashierAddOnView2 != null) {
                        cashierAddOnView2.setVisibility((list.isEmpty() ^ true) && z ? 0 : 8);
                    }
                }
            });
            for (CashierOrderGoodModel cashierOrderGoodModel : list) {
                if (Intrinsics.areEqual(cashierOrderGoodModel.getErrorConfigVersion, Boolean.TRUE)) {
                    CashierContract.Presenter presenter3 = this.cashierPresenter;
                    if (presenter3 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("");
                        presenter3 = null;
                    }
                    String str = cashierOrderGoodModel.MyBillsEntityDataFactory;
                    if (str == null) {
                        str = "";
                    }
                    presenter3.BuiltInFictitiousFunctionClassFactory(str);
                }
            }
            this.getErrorConfigVersion = (CheckoutExternalInfo) arguments.getParcelable(CashierKeyParams.CHECKOUT_EXTERNAL_INFO);
            CashierPayMethodModel cashierPayMethodModel = (CashierPayMethodModel) arguments.getParcelable(CashierKeyParams.BALANCE_MIX_PAY_MODEL);
            if (cashierPayMethodModel != null) {
                Intrinsics.checkNotNullExpressionValue(cashierPayMethodModel, "");
                this.whenAvailable = cashierPayMethodModel;
            }
        }
    }

    @Override // id.dana.cashier.fragment.BaseCashierFragment
    protected final void BuiltInFictitiousFunctionClassFactory() {
        BaseActivity baseActivity = getBaseActivity();
        PayActivity payActivity = baseActivity instanceof PayActivity ? (PayActivity) baseActivity : null;
        if (payActivity != null) {
            payActivity.setCashierRiskListener(new PayActivity.CashierRiskListener() { // from class: id.dana.cashier.fragment.AddNewCardCashierFragment$initCashierListener$1
                @Override // id.dana.pay.PayActivity.CashierRiskListener
                public final void MyBillsEntityDataFactory(String p0) {
                    String str;
                    CashierContract.Presenter presenter = AddNewCardCashierFragment.this.cashierPresenter;
                    if (presenter == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("");
                        presenter = null;
                    }
                    str = AddNewCardCashierFragment.this.moveToNextValue;
                    presenter.KClassImpl$Data$declaredNonStaticMembers$2(str, p0, (r12 & 4) != 0 ? false : false, (r12 & 8) != 0 ? null : null, (r12 & 16) != 0 ? null : null);
                }
            });
        }
    }

    @Override // id.dana.cashier.fragment.BaseCashierFragment
    public final void KClassImpl$Data$declaredNonStaticMembers$2(RiskParamsFactory p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        BuiltInFictitiousFunctionClassFactory(p0);
        getPlaceComponentResult().check();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // id.dana.cashier.fragment.BaseCashierFragment
    public final void lookAheadTest() {
        String str = this.moveToNextValue;
        CashierPayMethodModel.CardPayMethod cardPayMethod = this.FragmentBottomSheetPaymentSettingBinding;
        CashierContract.Presenter presenter = null;
        if (cardPayMethod == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            cardPayMethod = null;
        }
        CashierPayMethodModel.CardPayMethod cardPayMethod2 = cardPayMethod;
        String NetworkUserEntityData$$ExternalSyntheticLambda1 = getInitRecordTimeStamp();
        VoucherCashierModel voucherCashierModel = this.getSupportButtonTintMode;
        List<String> VerifyPinStateManager$executeRiskChallenge$2$1 = VerifyPinStateManager$executeRiskChallenge$2$1();
        String str2 = this.lookAheadTest;
        BaseActivity baseActivity = getBaseActivity();
        Intrinsics.checkNotNullExpressionValue(baseActivity, "");
        CashierFaceAuthModel cashierFaceAuthModel = new CashierFaceAuthModel(str, cardPayMethod2, NetworkUserEntityData$$ExternalSyntheticLambda1, "MIC_FACE", voucherCashierModel, VerifyPinStateManager$executeRiskChallenge$2$1, null, str2, baseActivity, 64, null);
        CashierContract.Presenter presenter2 = this.cashierPresenter;
        if (presenter2 != null) {
            presenter = presenter2;
        } else {
            Intrinsics.throwUninitializedPropertyAccessException("");
        }
        presenter.BuiltInFictitiousFunctionClassFactory(cashierFaceAuthModel);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // id.dana.cashier.fragment.BaseCashierFragment
    public final void NetworkUserEntityData$$ExternalSyntheticLambda0() {
        RiskParamsFactory GetContactSyncConfig = getNetworkUserEntityData$$ExternalSyntheticLambda2();
        if (GetContactSyncConfig != null) {
            String PlaceComponentResult = GetContactSyncConfig.PlaceComponentResult();
            BaseActivity baseActivity = getBaseActivity();
            PayActivity payActivity = baseActivity instanceof PayActivity ? (PayActivity) baseActivity : null;
            if (payActivity != null) {
                if (PlaceComponentResult == null) {
                    PlaceComponentResult = "";
                }
                PayActivity.handleCashierRiskPhase$default(payActivity, PlaceComponentResult, GetContactSyncConfig, null, null, 12, null);
            }
            BuiltInFictitiousFunctionClassFactory((RiskParamsFactory) null);
        }
    }

    @Override // id.dana.cashier.fragment.BaseCashierFragment
    protected final void BuiltInFictitiousFunctionClassFactory(String p0, String p1, String p2, String p3, String p4, boolean p5) {
        Intrinsics.checkNotNullParameter(p0, "");
        Intrinsics.checkNotNullParameter(p3, "");
        Intrinsics.checkNotNullParameter(p4, "");
        PayResultModel payResultModel = this.NetworkUserEntityData$$ExternalSyntheticLambda3;
        if (payResultModel != null) {
            payResultModel.getValueOfTouchPositionAbsolute = p0;
            String str = this.moveToNextValue;
            Intrinsics.checkNotNullParameter(str, "");
            payResultModel.getErrorConfigVersion = str;
            payResultModel.GetContactSyncConfig = p1;
            payResultModel.scheduleImpl = p2;
            payResultModel.G = VerifyPinStateManager$executeRiskChallenge$2$1();
            BaseActivity baseActivity = getBaseActivity();
            PayActivity payActivity = baseActivity instanceof PayActivity ? (PayActivity) baseActivity : null;
            if (payActivity != null) {
                PaymentResultFragment.Companion companion = PaymentResultFragment.KClassImpl$Data$declaredNonStaticMembers$2;
                payActivity.addFragment(PaymentResultFragment.Companion.BuiltInFictitiousFunctionClassFactory(payResultModel, p5));
            }
        }
    }

    private final void BuiltInFictitiousFunctionClassFactory(QueryCardPolicyInfoModel p0) {
        InputCardNumberView inputCardNumberView = (InputCardNumberView) BuiltInFictitiousFunctionClassFactory(R.id.inputCardNumberView);
        if (inputCardNumberView != null) {
            CardAssetUtils cardAssetUtils = CardAssetUtils.INSTANCE;
            Integer BuiltInFictitiousFunctionClassFactory = CardAssetUtils.BuiltInFictitiousFunctionClassFactory(p0.BuiltInFictitiousFunctionClassFactory);
            CardAssetUtils cardAssetUtils2 = CardAssetUtils.INSTANCE;
            inputCardNumberView.setCardIcon(BuiltInFictitiousFunctionClassFactory, CardAssetUtils.PlaceComponentResult(p0.getAuthRequestContext));
        }
    }

    private final void KClassImpl$Data$declaredNonStaticMembers$2(Boolean p0, boolean p1) {
        if (p0 != null) {
            boolean booleanValue = p0.booleanValue();
            ConstraintLayout constraintLayout = (ConstraintLayout) BuiltInFictitiousFunctionClassFactory(R.id.res_0x7f0a032d_playbackstatecompat_mediakeyaction);
            if (constraintLayout != null) {
                Intrinsics.checkNotNullExpressionValue(constraintLayout, "");
                constraintLayout.setVisibility(0);
            }
            AppCompatTextView appCompatTextView = (AppCompatTextView) BuiltInFictitiousFunctionClassFactory(R.id.tvAddCardTitleExpressPay);
            if (appCompatTextView != null) {
                Intrinsics.checkNotNullExpressionValue(appCompatTextView, "");
                appCompatTextView.setVisibility(booleanValue ^ true ? 4 : 0);
            }
            AppCompatTextView appCompatTextView2 = (AppCompatTextView) BuiltInFictitiousFunctionClassFactory(R.id.applyChangesToServices);
            if (appCompatTextView2 != null) {
                Intrinsics.checkNotNullExpressionValue(appCompatTextView2, "");
                appCompatTextView2.setVisibility(booleanValue ? 4 : 0);
            }
            ConstraintLayout constraintLayout2 = (ConstraintLayout) BuiltInFictitiousFunctionClassFactory(R.id.SplitSavingConfigEntityData_res_0x7f0a037a);
            if (constraintLayout2 != null) {
                Intrinsics.checkNotNullExpressionValue(constraintLayout2, "");
                constraintLayout2.setVisibility(booleanValue ? 0 : 8);
            }
            AppCompatTextView appCompatTextView3 = (AppCompatTextView) BuiltInFictitiousFunctionClassFactory(R.id.FilteredKeyListMultimap);
            if (appCompatTextView3 != null) {
                appCompatTextView3.setText(p1 ? getString(R.string.express_pay_desc_gpn) : getString(R.string.express_pay_desc));
            }
            AppCompatCheckBox appCompatCheckBox = (AppCompatCheckBox) BuiltInFictitiousFunctionClassFactory(R.id.useDaemonThreadFactory_res_0x7f0a02a9);
            if (appCompatCheckBox != null) {
                Intrinsics.checkNotNullExpressionValue(appCompatCheckBox, "");
                appCompatCheckBox.setEnabled(!p1);
                appCompatCheckBox.setChecked(p1 || booleanValue);
                appCompatCheckBox.setContentDescription(appCompatCheckBox.getContext().getString(R.string.checkbox_bind_card));
            }
            AppCompatTextView appCompatTextView4 = (AppCompatTextView) BuiltInFictitiousFunctionClassFactory(R.id.isUnsignedClass);
            if (appCompatTextView4 != null) {
                Intrinsics.checkNotNullExpressionValue(appCompatTextView4, "");
                appCompatTextView4.setMovementMethod(LinkMovementMethod.getInstance());
                appCompatTextView4.setText(booleanValue ? A() : getString(R.string.you_bank_card_secured));
            }
        }
    }

    private final SpannableString A() {
        Context context = getContext();
        String string = context != null ? context.getString(R.string.by_continuing_you_agree) : null;
        if (string == null) {
            string = "";
        }
        Context context2 = getContext();
        String string2 = context2 != null ? context2.getString(R.string.tnc) : null;
        String str = string2 != null ? string2 : "";
        String str2 = string;
        int indexOf$default = StringsKt.indexOf$default((CharSequence) str2, str, 0, false, 6, (Object) null);
        NoUnderlineClickableSpan noUnderlineClickableSpan = new NoUnderlineClickableSpan(getContext(), WebViewActivity.ContentBuilder(getContext(), str, UrlUtil.getAuthRequestContext(id.dana.utils.LocaleUtil.BuiltInFictitiousFunctionClassFactory() ? "https://a.m.dana.id/resource/htmls/tnc/directdebit_id_ID.html" : "https://a.m.dana.id/resource/htmls/tnc/directdebit_en_US.html")));
        SpannableString spannableString = new SpannableString(str2);
        spannableString.setSpan(noUnderlineClickableSpan, indexOf$default, str.length() + indexOf$default, 33);
        spannableString.setSpan(new ForegroundColorSpan(ContextCompat.BuiltInFictitiousFunctionClassFactory(requireContext(), R.color.f22912131099753)), indexOf$default, str.length() + indexOf$default, 33);
        spannableString.setSpan(new StyleSpan(0), indexOf$default, str.length() + indexOf$default, 33);
        return spannableString;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Type inference failed for: r19v0, types: [kotlin.jvm.internal.DefaultConstructorMarker, java.lang.String] */
    public final void getCallingPid() {
        String str = this.NetworkUserEntityData$$ExternalSyntheticLambda7;
        StringBuilder sb = new StringBuilder();
        sb.append("20");
        sb.append(this.NetworkUserEntityData$$ExternalSyntheticLambda8);
        String obj = sb.toString();
        InputCardNumberView inputCardNumberView = (InputCardNumberView) BuiltInFictitiousFunctionClassFactory(R.id.inputCardNumberView);
        String cleanCardNumber = inputCardNumberView != null ? inputCardNumberView.getCleanCardNumber() : null;
        String str2 = this.NetworkUserEntityData$$ExternalSyntheticLambda2;
        QueryCardPolicyInfoModel queryCardPolicyInfoModel = this.NetworkUserEntityData$$ExternalSyntheticLambda4;
        String str3 = queryCardPolicyInfoModel != null ? queryCardPolicyInfoModel.MyBillsEntityDataFactory : null;
        QueryCardPolicyInfoModel queryCardPolicyInfoModel2 = this.NetworkUserEntityData$$ExternalSyntheticLambda4;
        String str4 = queryCardPolicyInfoModel2 != null ? queryCardPolicyInfoModel2.getAuthRequestContext : null;
        AppCompatCheckBox appCompatCheckBox = (AppCompatCheckBox) BuiltInFictitiousFunctionClassFactory(R.id.useDaemonThreadFactory_res_0x7f0a02a9);
        CashierPayMethodModel.NewCardData newCardData = new CashierPayMethodModel.NewCardData(cleanCardNumber, str, obj, str2, str3, str4, appCompatCheckBox != null ? appCompatCheckBox.isChecked() : false, null, null, 384, null);
        QueryCardPolicyInfoModel queryCardPolicyInfoModel3 = this.NetworkUserEntityData$$ExternalSyntheticLambda4;
        String str5 = queryCardPolicyInfoModel3 != null ? queryCardPolicyInfoModel3.PlaceComponentResult : null;
        QueryCardPolicyInfoModel queryCardPolicyInfoModel4 = this.NetworkUserEntityData$$ExternalSyntheticLambda4;
        String str6 = queryCardPolicyInfoModel4 != null ? queryCardPolicyInfoModel4.BuiltInFictitiousFunctionClassFactory : null;
        QueryCardPolicyInfoModel queryCardPolicyInfoModel5 = this.NetworkUserEntityData$$ExternalSyntheticLambda4;
        String str7 = queryCardPolicyInfoModel5 != null ? queryCardPolicyInfoModel5.getAuthRequestContext : null;
        QueryCardPolicyInfoModel queryCardPolicyInfoModel6 = this.NetworkUserEntityData$$ExternalSyntheticLambda4;
        Boolean bool = queryCardPolicyInfoModel6 != null ? queryCardPolicyInfoModel6.scheduleImpl : null;
        QueryCardPolicyInfoModel queryCardPolicyInfoModel7 = this.NetworkUserEntityData$$ExternalSyntheticLambda4;
        String str8 = queryCardPolicyInfoModel7 != null ? queryCardPolicyInfoModel7.moveToNextValue : null;
        QueryCardPolicyInfoModel queryCardPolicyInfoModel8 = this.NetworkUserEntityData$$ExternalSyntheticLambda4;
        String str9 = queryCardPolicyInfoModel8 != null ? queryCardPolicyInfoModel8.getErrorConfigVersion : null;
        QueryCardPolicyInfoModel queryCardPolicyInfoModel9 = this.NetworkUserEntityData$$ExternalSyntheticLambda4;
        String str10 = queryCardPolicyInfoModel9 != null ? queryCardPolicyInfoModel9.NetworkUserEntityData$$ExternalSyntheticLambda1 : null;
        QueryCardPolicyInfoModel queryCardPolicyInfoModel10 = this.NetworkUserEntityData$$ExternalSyntheticLambda4;
        String str11 = queryCardPolicyInfoModel10 != null ? queryCardPolicyInfoModel10.initRecordTimeStamp : null;
        QueryCardPolicyInfoModel queryCardPolicyInfoModel11 = this.NetworkUserEntityData$$ExternalSyntheticLambda4;
        List<String> list = queryCardPolicyInfoModel11 != null ? queryCardPolicyInfoModel11.GetContactSyncConfig : null;
        QueryCardPolicyInfoModel queryCardPolicyInfoModel12 = this.NetworkUserEntityData$$ExternalSyntheticLambda4;
        ?? r19 = 0;
        this.FragmentBottomSheetPaymentSettingBinding = new CashierPayMethodModel.CardPayMethod(new AssetCardModel(null, null, r19, null, str5, null, null, str6, null, null, bool, null, null, newCardData.getAuthRequestContext, newCardData.KClassImpl$Data$declaredNonStaticMembers$2, str8, str9, null, null, null, null, null, str11, str10, null, null, null, str7, list, null, queryCardPolicyInfoModel12 != null ? queryCardPolicyInfoModel12.NetworkUserEntityData$$ExternalSyntheticLambda0 : null, null, null, null, null, null, null, null, -1489101969, 63, null), null, newCardData, 2, r19);
    }

    private final boolean KClassImpl$Data$declaredNonStaticMembers$2(boolean p0, boolean p1, boolean p2, boolean p3, boolean p4, boolean p5, boolean p6) {
        List<Integer> list = this.readMicros;
        if (!p2 && !list.contains(1)) {
            p2 = true;
        }
        if (!p3 && !list.contains(3)) {
            p3 = true;
        }
        if (!p4 && !list.contains(0)) {
            p4 = true;
        }
        if (!p5 && !list.contains(2)) {
            p5 = true;
        }
        if (!p6 && !list.contains(5)) {
            p6 = true;
        }
        return p0 && p1 && p2 && p3 && p4 && p5 && p6;
    }

    private final void KClassImpl$Data$declaredNonStaticMembers$2(List<? extends QueryCardVerifyElementModel> list) {
        String str;
        List<? extends QueryCardVerifyElementModel> list2 = list;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list2, 10));
        for (QueryCardVerifyElementModel queryCardVerifyElementModel : list2) {
            if (queryCardVerifyElementModel.KClassImpl$Data$declaredNonStaticMembers$2 == 4 || queryCardVerifyElementModel.KClassImpl$Data$declaredNonStaticMembers$2 == 1) {
                if (this.NetworkUserEntityData$$ExternalSyntheticLambda7.length() > 0) {
                    if (this.NetworkUserEntityData$$ExternalSyntheticLambda8.length() > 0) {
                        StringBuilder sb = new StringBuilder();
                        sb.append(this.NetworkUserEntityData$$ExternalSyntheticLambda7);
                        sb.append(this.NetworkUserEntityData$$ExternalSyntheticLambda8);
                        str = sb.toString();
                        queryCardVerifyElementModel.PlaceComponentResult = str;
                    }
                }
                str = null;
                queryCardVerifyElementModel.PlaceComponentResult = str;
            }
            arrayList.add(queryCardVerifyElementModel);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x001f  */
    @Override // androidx.fragment.app.Fragment
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void onDestroy() {
        /*
            r3 = this;
            boolean r0 = r3.isLayoutRequested
            if (r0 == 0) goto L1c
            id.dana.base.BaseActivity r0 = r3.getBaseActivity()
            if (r0 == 0) goto L14
            id.dana.pay.PayActivity r0 = (id.dana.pay.PayActivity) r0
            boolean r0 = r0.getIsInPaymentResult()
            if (r0 != 0) goto L1c
            r0 = 1
            goto L1d
        L14:
            java.lang.NullPointerException r0 = new java.lang.NullPointerException
            java.lang.String r1 = "null cannot be cast to non-null type id.dana.pay.PayActivity"
            r0.<init>(r1)
            throw r0
        L1c:
            r0 = 0
        L1d:
            if (r0 == 0) goto L31
            id.dana.cashier.CashierContract$Presenter r0 = r3.cashierPresenter
            if (r0 == 0) goto L24
            goto L2a
        L24:
            java.lang.String r0 = ""
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r0)
            r0 = 0
        L2a:
            java.lang.String r1 = r3.moveToNextValue
            java.lang.String r2 = r3.lookAheadTest
            r0.KClassImpl$Data$declaredNonStaticMembers$2(r1, r2)
        L31:
            super.onDestroy()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.cashier.fragment.AddNewCardCashierFragment.onDestroy():void");
    }

    private final boolean B() {
        QueryCardPolicyInfoModel queryCardPolicyInfoModel = this.NetworkUserEntityData$$ExternalSyntheticLambda4;
        return StringsKt.equals(queryCardPolicyInfoModel != null ? queryCardPolicyInfoModel.moveToNextValue : null, Institution.BCA_ONEKLIK, true);
    }

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0007¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"Lid/dana/cashier/fragment/AddNewCardCashierFragment$Companion;", "", "Landroid/os/Bundle;", "p0", "Lid/dana/cashier/fragment/AddNewCardCashierFragment;", "PlaceComponentResult", "(Landroid/os/Bundle;)Lid/dana/cashier/fragment/AddNewCardCashierFragment;", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes4.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public static AddNewCardCashierFragment PlaceComponentResult(Bundle p0) {
            Intrinsics.checkNotNullParameter(p0, "");
            AddNewCardCashierFragment addNewCardCashierFragment = new AddNewCardCashierFragment();
            addNewCardCashierFragment.setArguments(p0);
            return addNewCardCashierFragment;
        }
    }

    public static /* synthetic */ void MyBillsEntityDataFactory(final AddNewCardCashierFragment addNewCardCashierFragment, final boolean z) {
        List<VoucherCashierModel> list;
        CashierPromoView cashierPromoView;
        Intrinsics.checkNotNullParameter(addNewCardCashierFragment, "");
        DanaButtonPrimaryView danaButtonPrimaryView = (DanaButtonPrimaryView) addNewCardCashierFragment.BuiltInFictitiousFunctionClassFactory(R.id.res_0x7f0a0140_verifypinstatemanager_executeriskchallenge_2_1);
        CashierContract.Presenter presenter = null;
        if (danaButtonPrimaryView != null) {
            danaButtonPrimaryView.setEnabled(z);
            danaButtonPrimaryView.setClickable(z);
            Context context = danaButtonPrimaryView.getContext();
            danaButtonPrimaryView.setDanaButtonView(z ? 1 : 0, context != null ? context.getString(R.string.pay) : null, "", null);
            danaButtonPrimaryView.setContentDescription(danaButtonPrimaryView.getContext().getString(R.string.btn_continue_cashier));
        }
        DanaButtonPrimaryView danaButtonPrimaryView2 = (DanaButtonPrimaryView) addNewCardCashierFragment.BuiltInFictitiousFunctionClassFactory(R.id.res_0x7f0a0140_verifypinstatemanager_executeriskchallenge_2_1);
        if (danaButtonPrimaryView2 != null) {
            danaButtonPrimaryView2.setOnClickListener(new View.OnClickListener() { // from class: id.dana.cashier.fragment.AddNewCardCashierFragment$$ExternalSyntheticLambda1
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    AddNewCardCashierFragment.BuiltInFictitiousFunctionClassFactory(z, addNewCardCashierFragment);
                }
            });
        }
        QueryPromotionModel queryPromotionModel = addNewCardCashierFragment.NetworkUserEntityData$$ExternalSyntheticLambda6;
        boolean z2 = false;
        if (queryPromotionModel != null && (list = queryPromotionModel.MyBillsEntityDataFactory) != null && (cashierPromoView = (CashierPromoView) addNewCardCashierFragment.BuiltInFictitiousFunctionClassFactory(R.id.cashierPromoView)) != null) {
            Intrinsics.checkNotNullExpressionValue(cashierPromoView, "");
            VoucherCashierModel databaseTableConfigUtil = cashierPromoView.getDatabaseTableConfigUtil();
            QueryCardPolicyInfoModel queryCardPolicyInfoModel = addNewCardCashierFragment.NetworkUserEntityData$$ExternalSyntheticLambda4;
            String str = queryCardPolicyInfoModel != null ? queryCardPolicyInfoModel.PlaceComponentResult : null;
            QueryCardPolicyInfoModel queryCardPolicyInfoModel2 = addNewCardCashierFragment.NetworkUserEntityData$$ExternalSyntheticLambda4;
            cashierPromoView.setVoucherCashiers(databaseTableConfigUtil, list, (r16 & 4) != 0 ? null : null, (r16 & 8) != 0 ? null : str, (r16 & 16) != 0 ? null : queryCardPolicyInfoModel2 != null ? queryCardPolicyInfoModel2.getAuthRequestContext : null, (r16 & 32) != 0 ? false : false);
            cashierPromoView.setVisibility((list.isEmpty() ^ true) && z ? 0 : 8);
        }
        if (!z) {
            CashierAddOnView cashierAddOnView = (CashierAddOnView) addNewCardCashierFragment.BuiltInFictitiousFunctionClassFactory(R.id.res_0x7f0a029c_cyfmonitor_challengeactioncallback);
            if (cashierAddOnView != null) {
                if (cashierAddOnView.getVisibility() == 0) {
                    z2 = true;
                }
            }
            if (z2) {
                CashierAddOnView cashierAddOnView2 = (CashierAddOnView) addNewCardCashierFragment.BuiltInFictitiousFunctionClassFactory(R.id.res_0x7f0a029c_cyfmonitor_challengeactioncallback);
                if (cashierAddOnView2 != null) {
                    cashierAddOnView2.resetCheckboxState();
                }
                CashierContract.Presenter presenter2 = addNewCardCashierFragment.cashierPresenter;
                if (presenter2 != null) {
                    presenter = presenter2;
                } else {
                    Intrinsics.throwUninitializedPropertyAccessException("");
                }
                presenter.MyBillsEntityDataFactory();
            }
        }
        addNewCardCashierFragment.isLayoutRequested().invoke(Boolean.valueOf(z));
    }

    public static /* synthetic */ Boolean getAuthRequestContext(CharSequence charSequence) {
        boolean z = false;
        if (charSequence != null) {
            if (charSequence.length() > 0) {
                z = true;
            }
        }
        return Boolean.valueOf(z);
    }

    public static /* synthetic */ void PlaceComponentResult(AddNewCardCashierFragment addNewCardCashierFragment, boolean z) {
        Intrinsics.checkNotNullParameter(addNewCardCashierFragment, "");
        addNewCardCashierFragment.getAuthRequestContext(z);
        addNewCardCashierFragment.getCallingPid.onNext(Boolean.valueOf(z));
    }

    public static /* synthetic */ Boolean getAuthRequestContext(AddNewCardCashierFragment addNewCardCashierFragment, boolean z, boolean z2, boolean z3, boolean z4, Boolean bool, Boolean bool2, Boolean bool3, Boolean bool4) {
        Intrinsics.checkNotNullParameter(addNewCardCashierFragment, "");
        Intrinsics.checkNotNullParameter(bool, "");
        Intrinsics.checkNotNullParameter(bool2, "");
        Intrinsics.checkNotNullParameter(bool3, "");
        Intrinsics.checkNotNullParameter(bool4, "");
        return Boolean.valueOf(addNewCardCashierFragment.NetworkUserEntityData$$ExternalSyntheticLambda4 != null ? addNewCardCashierFragment.KClassImpl$Data$declaredNonStaticMembers$2(z, z2, z3, z4, bool.booleanValue(), bool2.booleanValue(), bool4.booleanValue()) : false);
    }

    /* JADX WARN: Removed duplicated region for block: B:120:0x0198  */
    /* JADX WARN: Removed duplicated region for block: B:92:0x013e  */
    /* JADX WARN: Removed duplicated region for block: B:95:0x014e  */
    /* JADX WARN: Removed duplicated region for block: B:98:0x0158  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static /* synthetic */ void BuiltInFictitiousFunctionClassFactory(boolean r23, id.dana.cashier.fragment.AddNewCardCashierFragment r24) {
        /*
            Method dump skipped, instructions count: 434
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.cashier.fragment.AddNewCardCashierFragment.BuiltInFictitiousFunctionClassFactory(boolean, id.dana.cashier.fragment.AddNewCardCashierFragment):void");
    }

    public static final /* synthetic */ void MyBillsEntityDataFactory(AddNewCardCashierFragment addNewCardCashierFragment, int i, int i2) {
        String[] strArr;
        Bundle bundle = new Bundle();
        PayResultModel payResultModel = addNewCardCashierFragment.NetworkUserEntityData$$ExternalSyntheticLambda3;
        if (payResultModel != null) {
            CurrencyAmountModel currencyAmountModel = addNewCardCashierFragment.SubSequence;
            payResultModel.AppCompatEmojiTextHelper = currencyAmountModel != null ? currencyAmountModel.getAuthRequestContext() : null;
        }
        bundle.putString(CashierKeyParams.CASHIER_ORDER_ID, addNewCardCashierFragment.moveToNextValue);
        bundle.putString("ektp", addNewCardCashierFragment.DatabaseTableConfigUtil);
        bundle.putString("phoneNumber", addNewCardCashierFragment.KClassImpl$Data$declaredNonStaticMembers$2);
        CashierContract.Presenter presenter = addNewCardCashierFragment.cashierPresenter;
        if (presenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            presenter = null;
        }
        List<String> KClassImpl$Data$declaredNonStaticMembers$2 = presenter.KClassImpl$Data$declaredNonStaticMembers$2();
        if (KClassImpl$Data$declaredNonStaticMembers$2.isEmpty()) {
            KClassImpl$Data$declaredNonStaticMembers$2 = null;
        }
        List<String> list = KClassImpl$Data$declaredNonStaticMembers$2;
        bundle.putBoolean("isRefreshCashierInfoAndPay", !(list == null || list.isEmpty()));
        bundle.putInt("retrySendSeconds", i);
        bundle.putInt("otpCodeLength", i2);
        CashierPayMethodModel.CardPayMethod cardPayMethod = addNewCardCashierFragment.FragmentBottomSheetPaymentSettingBinding;
        if (cardPayMethod == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            cardPayMethod = null;
        }
        bundle.putParcelable(CashierKeyParams.CASHIER_PAY_METHOD, cardPayMethod);
        bundle.putParcelable(CashierKeyParams.PAY_RESULT_MODEL, addNewCardCashierFragment.NetworkUserEntityData$$ExternalSyntheticLambda3);
        bundle.putParcelable(CashierKeyParams.VOUCHER_PROMO, addNewCardCashierFragment.getSupportButtonTintMode);
        CashierContract.Presenter presenter2 = addNewCardCashierFragment.cashierPresenter;
        if (presenter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            presenter2 = null;
        }
        List<String> KClassImpl$Data$declaredNonStaticMembers$22 = presenter2.KClassImpl$Data$declaredNonStaticMembers$2();
        if (KClassImpl$Data$declaredNonStaticMembers$22.isEmpty()) {
            KClassImpl$Data$declaredNonStaticMembers$22 = null;
        }
        List<String> list2 = KClassImpl$Data$declaredNonStaticMembers$22;
        if (list2 != null) {
            Object[] array = list2.toArray(new String[0]);
            if (array == null) {
                throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
            }
            strArr = (String[]) array;
        } else {
            strArr = null;
        }
        bundle.putStringArray(CashierKeyParams.CASHIER_ORDER_GOODS, strArr);
        bundle.putBoolean(CashierKeyParams.IS_BINDING_PAY, true);
        bundle.putBoolean(CashierKeyParams.IS_VERIFY_BANK_PHONE_OTP, true);
        CashierContract.Presenter presenter3 = addNewCardCashierFragment.cashierPresenter;
        if (presenter3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            presenter3 = null;
        }
        Object[] array2 = presenter3.getAuthRequestContext().toArray(new String[0]);
        if (array2 != null) {
            bundle.putStringArray("selectedAddonsName", (String[]) array2);
            CashierPayMethodModel cashierPayMethodModel = addNewCardCashierFragment.whenAvailable;
            if (cashierPayMethodModel != null) {
                if (cashierPayMethodModel == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("");
                    cashierPayMethodModel = null;
                }
                bundle.putParcelable(CashierKeyParams.BALANCE_MIX_PAY_MODEL, cashierPayMethodModel);
            }
            BaseActivity baseActivity = addNewCardCashierFragment.getBaseActivity();
            PayActivity payActivity = baseActivity instanceof PayActivity ? (PayActivity) baseActivity : null;
            if (payActivity != null) {
                CashierOtpChallengeFragment.Companion companion = CashierOtpChallengeFragment.INSTANCE;
                PayActivity.addAndRemoveStackedFragment$default(payActivity, CashierOtpChallengeFragment.Companion.KClassImpl$Data$declaredNonStaticMembers$2(bundle), false, false, 6, null);
                return;
            }
            return;
        }
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
    }

    public static final /* synthetic */ void MyBillsEntityDataFactory(AddNewCardCashierFragment addNewCardCashierFragment, QueryCardPolicyInfoModel queryCardPolicyInfoModel, String str) {
        Function1<String, Unit> iconCardErrorHandlingListener;
        if (addNewCardCashierFragment.B()) {
            Bundle arguments = addNewCardCashierFragment.getArguments();
            if (!(arguments != null && arguments.getBoolean(CashierKeyParams.ALLOW_ONEKLIK_TRANSACTION))) {
                InputCardNumberView inputCardNumberView = (InputCardNumberView) addNewCardCashierFragment.BuiltInFictitiousFunctionClassFactory(R.id.inputCardNumberView);
                if (inputCardNumberView != null) {
                    inputCardNumberView.setErrorMessage(addNewCardCashierFragment.getString(R.string.input_card_oneklik_error));
                    return;
                }
                return;
            }
            final CashierCardBindingPresenter cashierCardBindingPresenter = addNewCardCashierFragment.cashierCardBindingPresenter;
            if (cashierCardBindingPresenter == null) {
                Intrinsics.throwUninitializedPropertyAccessException("");
                cashierCardBindingPresenter = null;
            }
            String androidId = cashierCardBindingPresenter.BuiltInFictitiousFunctionClassFactory.get().getAndroidId(cashierCardBindingPresenter.getAuthRequestContext);
            String str2 = androidId;
            if (!(str2 == null || str2.length() == 0)) {
                cashierCardBindingPresenter.KClassImpl$Data$declaredNonStaticMembers$2.get().execute(GetOneklikRedirectUrl.Params.INSTANCE.createPayCashierRequest(OneklikAnnotations.ONEKLIK_SCENARIO, CashierCardBindingPresenter.BuiltInFictitiousFunctionClassFactory(androidId)), new Function1<String, Unit>() { // from class: id.dana.cashier.presenter.CashierCardBindingPresenter$getOneklikRedirectUrl$1
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final /* bridge */ /* synthetic */ Unit invoke(String str3) {
                        invoke2(str3);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke  reason: avoid collision after fix types in other method */
                    public final void invoke2(String str3) {
                        Lazy lazy;
                        Intrinsics.checkNotNullParameter(str3, "");
                        lazy = CashierCardBindingPresenter.this.lookAheadTest;
                        ((CashierCardBindingContract.View) lazy.get()).PlaceComponentResult(str3);
                    }
                }, new Function1<Throwable, Unit>() { // from class: id.dana.cashier.presenter.CashierCardBindingPresenter$getOneklikRedirectUrl$2
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
                        Lazy lazy;
                        Intrinsics.checkNotNullParameter(th, "");
                        lazy = CashierCardBindingPresenter.this.lookAheadTest;
                        ((CashierCardBindingContract.View) lazy.get()).MyBillsEntityDataFactory(th);
                    }
                });
                return;
            } else {
                cashierCardBindingPresenter.lookAheadTest.get().MyBillsEntityDataFactory(new Throwable());
                return;
            }
        }
        addNewCardCashierFragment.PlaceComponentResult(queryCardPolicyInfoModel);
        InputCardNumberView inputCardNumberView2 = (InputCardNumberView) addNewCardCashierFragment.BuiltInFictitiousFunctionClassFactory(R.id.inputCardNumberView);
        if (inputCardNumberView2 == null || (iconCardErrorHandlingListener = inputCardNumberView2.getIconCardErrorHandlingListener()) == null) {
            return;
        }
        iconCardErrorHandlingListener.invoke(str);
    }

    /* JADX WARN: Removed duplicated region for block: B:106:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:85:0x0113  */
    /* JADX WARN: Removed duplicated region for block: B:86:0x0116  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x011a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final /* synthetic */ void KClassImpl$Data$declaredNonStaticMembers$2(id.dana.cashier.fragment.AddNewCardCashierFragment r24, id.dana.cashier.model.AttributeCashierPayModel r25) {
        /*
            Method dump skipped, instructions count: 323
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.cashier.fragment.AddNewCardCashierFragment.KClassImpl$Data$declaredNonStaticMembers$2(id.dana.cashier.fragment.AddNewCardCashierFragment, id.dana.cashier.model.AttributeCashierPayModel):void");
    }

    public static final /* synthetic */ void KClassImpl$Data$declaredNonStaticMembers$2(final AddNewCardCashierFragment addNewCardCashierFragment, String str) {
        LinkingOneKlikConfirmationFragment.Companion companion = LinkingOneKlikConfirmationFragment.INSTANCE;
        LinkingOneKlikConfirmationFragment.Companion.getAuthRequestContext(new Function0<Unit>() { // from class: id.dana.cashier.fragment.AddNewCardCashierFragment$openOneklikBottomsheetConfirmation$1
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
                InputCardNumberView inputCardNumberView = (InputCardNumberView) AddNewCardCashierFragment.this.BuiltInFictitiousFunctionClassFactory(R.id.inputCardNumberView);
                if (inputCardNumberView != null) {
                    inputCardNumberView.clearText();
                }
            }
        }, str).show(addNewCardCashierFragment.getBaseActivity().getSupportFragmentManager(), "");
    }

    public static final /* synthetic */ void initRecordTimeStamp(AddNewCardCashierFragment addNewCardCashierFragment) {
        addNewCardCashierFragment.BottomSheetCardBindingView$watcherCardNumberView$1();
        addNewCardCashierFragment.PlaceComponentResult = null;
        addNewCardCashierFragment.C();
        addNewCardCashierFragment.NetworkUserEntityData$$ExternalSyntheticLambda2 = "";
        addNewCardCashierFragment.NetworkUserEntityData$$ExternalSyntheticLambda7 = "";
        addNewCardCashierFragment.NetworkUserEntityData$$ExternalSyntheticLambda8 = "";
        addNewCardCashierFragment.KClassImpl$Data$declaredNonStaticMembers$2 = "";
        addNewCardCashierFragment.NetworkUserEntityData$$ExternalSyntheticLambda1 = "";
        addNewCardCashierFragment.DatabaseTableConfigUtil = "";
    }

    public static final /* synthetic */ void moveToNextValue(AddNewCardCashierFragment addNewCardCashierFragment, String str) {
        Object obj;
        Iterator<T> it = addNewCardCashierFragment.readMicros.iterator();
        while (true) {
            if (!it.hasNext()) {
                obj = null;
                break;
            }
            obj = it.next();
            if (((Number) obj).intValue() == 5) {
                break;
            }
        }
        Integer num = (Integer) obj;
        if (num != null) {
            int indexOf = addNewCardCashierFragment.readMicros.indexOf(num);
            AddNewCardAdapter addNewCardAdapter = addNewCardCashierFragment.PlaceComponentResult;
            if (addNewCardAdapter != null) {
                Intrinsics.checkNotNullParameter(str, "");
                if (addNewCardAdapter.getItem(indexOf) == null || Intrinsics.areEqual(addNewCardAdapter.getItem(indexOf).MyBillsEntityDataFactory, str)) {
                    return;
                }
                addNewCardAdapter.getItem(indexOf).MyBillsEntityDataFactory = str;
                addNewCardAdapter.notifyItemChanged(indexOf, "ERROR_MESSAGE");
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0028  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0048  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x005d  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x0065  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x0078  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x007d  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x0082  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x008d  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x00a7  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x00ca  */
    /* JADX WARN: Type inference failed for: r0v1, types: [id.dana.cashier.model.CashierPayMethodModel$CardPayMethod] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final /* synthetic */ void getErrorConfigVersion(id.dana.cashier.fragment.AddNewCardCashierFragment r19, java.lang.String r20) {
        /*
            Method dump skipped, instructions count: 475
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.cashier.fragment.AddNewCardCashierFragment.getErrorConfigVersion(id.dana.cashier.fragment.AddNewCardCashierFragment, java.lang.String):void");
    }

    public static final /* synthetic */ void KClassImpl$Data$declaredNonStaticMembers$2(AddNewCardCashierFragment addNewCardCashierFragment, CurrencyAmountModel currencyAmountModel, boolean z) {
        CurrencyAmountModel currencyAmountModel2;
        CurrencyAmountModel currencyAmountModel3 = addNewCardCashierFragment.SubSequence;
        if (currencyAmountModel3 != null) {
            CashierPriceUtils cashierPriceUtils = CashierPriceUtils.INSTANCE;
            currencyAmountModel2 = CashierPriceUtils.PlaceComponentResult(currencyAmountModel3, currencyAmountModel, z);
        } else {
            currencyAmountModel2 = null;
        }
        addNewCardCashierFragment.SubSequence = currencyAmountModel2;
    }

    private final List<String> VerifyPinStateManager$executeRiskChallenge$2$1() {
        CashierContract.Presenter presenter = this.cashierPresenter;
        if (presenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            presenter = null;
        }
        List<String> KClassImpl$Data$declaredNonStaticMembers$2 = presenter.KClassImpl$Data$declaredNonStaticMembers$2();
        return KClassImpl$Data$declaredNonStaticMembers$2.isEmpty() ? null : KClassImpl$Data$declaredNonStaticMembers$2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x0028, code lost:
    
        if (kotlin.jvm.internal.Intrinsics.areEqual(r1, r4 != null ? r4.PlaceComponentResult : null) != false) goto L21;
     */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0064  */
    /* JADX WARN: Removed duplicated region for block: B:44:? A[RETURN, SYNTHETIC] */
    @kotlin.jvm.JvmName(name = "PlaceComponentResult")
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void PlaceComponentResult(id.dana.cashier.model.QueryCardPolicyInfoModel r7) {
        /*
            r6 = this;
            r0 = 0
            if (r7 == 0) goto L6
            java.lang.String r1 = r7.PlaceComponentResult
            goto L7
        L6:
            r1 = r0
        L7:
            java.lang.CharSequence r1 = (java.lang.CharSequence) r1
            r2 = 0
            r3 = 1
            if (r1 == 0) goto L15
            int r1 = r1.length()
            if (r1 == 0) goto L15
            r1 = 0
            goto L16
        L15:
            r1 = 1
        L16:
            if (r1 != 0) goto L2a
            if (r7 == 0) goto L1d
            java.lang.String r1 = r7.PlaceComponentResult
            goto L1e
        L1d:
            r1 = r0
        L1e:
            id.dana.cashier.model.QueryCardPolicyInfoModel r4 = r6.NetworkUserEntityData$$ExternalSyntheticLambda4
            if (r4 == 0) goto L24
            java.lang.String r0 = r4.PlaceComponentResult
        L24:
            boolean r0 = kotlin.jvm.internal.Intrinsics.areEqual(r1, r0)
            if (r0 == 0) goto L2c
        L2a:
            if (r7 != 0) goto L74
        L2c:
            r6.NetworkUserEntityData$$ExternalSyntheticLambda4 = r7
            if (r7 == 0) goto L74
            r6.BuiltInFictitiousFunctionClassFactory(r7)
            java.lang.String r0 = r7.BuiltInFictitiousFunctionClassFactory
            java.lang.String r1 = "GPN"
            boolean r0 = kotlin.jvm.internal.Intrinsics.areEqual(r0, r1)
            java.lang.Boolean r1 = r7.scheduleImpl
            r6.KClassImpl$Data$declaredNonStaticMembers$2(r1, r0)
            int r1 = id.dana.R.id.useDaemonThreadFactory_res_0x7f0a02a9
            android.view.View r1 = r6.BuiltInFictitiousFunctionClassFactory(r1)
            androidx.appcompat.widget.AppCompatCheckBox r1 = (androidx.appcompat.widget.AppCompatCheckBox) r1
            if (r1 == 0) goto L61
            if (r0 != 0) goto L58
            java.lang.Boolean r4 = r7.scheduleImpl
            java.lang.Boolean r5 = java.lang.Boolean.TRUE
            boolean r4 = kotlin.jvm.internal.Intrinsics.areEqual(r4, r5)
            if (r4 != 0) goto L58
            r4 = 0
            goto L59
        L58:
            r4 = 1
        L59:
            boolean r1 = r1.isChecked()
            if (r4 != r1) goto L61
            r1 = 1
            goto L62
        L61:
            r1 = 0
        L62:
            if (r1 == 0) goto L74
            if (r0 != 0) goto L70
            java.lang.Boolean r7 = r7.scheduleImpl
            java.lang.Boolean r0 = java.lang.Boolean.TRUE
            boolean r7 = kotlin.jvm.internal.Intrinsics.areEqual(r7, r0)
            if (r7 == 0) goto L71
        L70:
            r2 = 1
        L71:
            r6.getAuthRequestContext(r2)
        L74:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.cashier.fragment.AddNewCardCashierFragment.PlaceComponentResult(id.dana.cashier.model.QueryCardPolicyInfoModel):void");
    }

    @Override // id.dana.cashier.fragment.BaseCashierFragment, id.dana.base.BaseFragment, androidx.fragment.app.Fragment
    public final /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        this.KClassImpl$Data$declaredNonStaticMembers$2.clear();
    }

    @Override // id.dana.cashier.fragment.BaseCashierFragment
    protected final void KClassImpl$Data$declaredNonStaticMembers$2(CashierPayMethodModel p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        CashierAnalyticTracker cashierAnalyticTracker = this.cashierAnalyticTracker;
        if (cashierAnalyticTracker == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            cashierAnalyticTracker = null;
        }
        cashierAnalyticTracker.getAuthRequestContext(p0.initRecordTimeStamp());
        CashierAnalyticTracker cashierAnalyticTracker2 = this.cashierAnalyticTracker;
        if (cashierAnalyticTracker2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            cashierAnalyticTracker2 = null;
        }
        String str = this.moveToNextValue;
        p0.MyBillsEntityDataFactory = this.whenAvailable != null;
        Unit unit = Unit.INSTANCE;
        CashierContract.Presenter presenter = this.cashierPresenter;
        if (presenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            presenter = null;
        }
        List<String> KClassImpl$Data$declaredNonStaticMembers$2 = presenter.KClassImpl$Data$declaredNonStaticMembers$2();
        FragmentActivity activity = getActivity();
        PayActivity payActivity = activity instanceof PayActivity ? (PayActivity) activity : null;
        AddOnTrackingModel addOnTrackingModel = payActivity != null ? payActivity.getAddOnTrackingModel() : null;
        PayResultModel payResultModel = this.NetworkUserEntityData$$ExternalSyntheticLambda3;
        String str2 = payResultModel != null ? payResultModel.VerifyPinStateManager$executeRiskChallenge$2$2 : null;
        String source = getBaseActivity().getSource();
        Intrinsics.checkNotNullExpressionValue(source, "");
        PayResultModel payResultModel2 = this.NetworkUserEntityData$$ExternalSyntheticLambda3;
        String str3 = payResultModel2 != null ? payResultModel2.id.dana.sendmoney.summary.SummaryActivity.DAYS java.lang.String : null;
        BaseActivity baseActivity = getBaseActivity();
        PayActivity payActivity2 = baseActivity instanceof PayActivity ? (PayActivity) baseActivity : null;
        cashierAnalyticTracker2.MyBillsEntityDataFactory(new PaymentExecutionTrackerParams(str, p0, KClassImpl$Data$declaredNonStaticMembers$2, addOnTrackingModel, str2, source, str3, payActivity2 != null ? payActivity2.getFeatureTimeModel() : null));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // id.dana.cashier.fragment.BaseCashierFragment
    public final void MyBillsEntityDataFactory(boolean p0) {
        CashierAnalyticTracker cashierAnalyticTracker = this.cashierAnalyticTracker;
        if (cashierAnalyticTracker == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            cashierAnalyticTracker = null;
        }
        CashierAnalyticTracker.CC.BuiltInFictitiousFunctionClassFactory(cashierAnalyticTracker, this.moveToNextValue, TrackerKey.CashierRiskType.FACE_VERIFICATION_CASHIER, Boolean.valueOf(p0), 4);
    }
}
