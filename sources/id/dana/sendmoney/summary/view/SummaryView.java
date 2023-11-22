package id.dana.sendmoney.summary.view;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatEditText;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.core.content.ContextCompat;
import androidx.core.view.ViewCompat;
import androidx.view.C0207ViewKt;
import androidx.view.LifecycleOwner;
import androidx.view.LifecycleOwnerKt;
import com.ap.zoloz.hummer.biz.HummerConstants;
import com.iap.ac.android.region.cdp.util.CdpConstants;
import dagger.internal.Preconditions;
import id.dana.R;
import id.dana.analytics.tracker.TrackerDataKey;
import id.dana.analytics.tracker.TrackerKey;
import id.dana.cashier.utils.CashierKeyParams;
import id.dana.component.customtoastcomponent.CustomToast;
import id.dana.component.edittextcomponent.DanaTextBoxView;
import id.dana.contract.sendmoney.SendMoneyContract;
import id.dana.core.ui.BaseViewBindingRichView;
import id.dana.core.ui.glide.BaseImageAttacher;
import id.dana.core.ui.glide.ImageAttacherFactory;
import id.dana.core.ui.richview.CurrencyEditText;
import id.dana.core.ui.util.NumberUtil;
import id.dana.data.util.NumberUtils;
import id.dana.databinding.ViewSendmoneySummaryBinding;
import id.dana.di.ComponentHolder;
import id.dana.di.component.ApplicationComponent;
import id.dana.di.component.DaggerCalculatorComponent;
import id.dana.di.modules.SendMoneyModule;
import id.dana.domain.sendmoney.model.SmartFrictionConfig;
import id.dana.domain.sendmoney.model.TransferInit;
import id.dana.lib.gcontainer.extension.NumberExtKt;
import id.dana.model.CurrencyAmountModel;
import id.dana.model.PayMethodModel;
import id.dana.sendmoney.Amount;
import id.dana.sendmoney.di.module.SendMoneyCoreModule;
import id.dana.sendmoney.mapper.TransferBankMapper;
import id.dana.sendmoney.model.RecipientModel;
import id.dana.sendmoney.model.TransferAmountConfig;
import id.dana.sendmoney.summary.SummaryActivity;
import id.dana.sendmoney.ui.core.model.SendMoneyApiMigrationConfigModel;
import id.dana.sendmoney.ui.core.model.TransferInitResultModel;
import id.dana.sendmoney.ui.core.model.TransferUserInfoModel;
import id.dana.sendmoney.ui.core.presenter.SendMoneyCoreContract;
import id.dana.sendmoney_v2.landing.di.module.SendMoneyTrackerModule;
import id.dana.sendmoney_v2.landing.view.RecipientRibbonView;
import id.dana.sendmoney_v2.tracker.SendMoneyAnalyticTracker;
import id.dana.sendmoney_v2.tracker.SendMoneyFeatureTime;
import id.dana.utils.DateTimeUtil;
import id.dana.utils.ImageResize;
import id.dana.utils.LocaleUtil;
import id.dana.utils.MaskedTextUtil;
import id.dana.utils.NumberFormatterUtil;
import id.dana.utils.SafeClickListenerExtensionKt;
import id.dana.utils.ViewUtil;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import javax.inject.Inject;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.jvm.JvmName;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.random.Random;
import kotlin.text.StringsKt;
import kotlinx.coroutines.flow.FlowKt;

@Metadata(d1 = {"\u0000Æ\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010!\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u0003\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0002\u008c\u0001B.\b\u0016\u0012\b\u0010\u0084\u0001\u001a\u00030\u0083\u0001\u0012\f\b\u0002\u0010\u0086\u0001\u001a\u0005\u0018\u00010\u0085\u0001\u0012\t\b\u0002\u0010\u0087\u0001\u001a\u00020=¢\u0006\u0006\b\u0088\u0001\u0010\u0089\u0001B3\b\u0016\u0012\b\u0010\u0084\u0001\u001a\u00030\u0083\u0001\u0012\n\u0010\u0086\u0001\u001a\u0005\u0018\u00010\u0085\u0001\u0012\u0007\u0010\u0087\u0001\u001a\u00020=\u0012\u0007\u0010\u008a\u0001\u001a\u00020=¢\u0006\u0006\b\u0088\u0001\u0010\u008b\u0001J\u0017\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\t\u001a\u00020\bH\u0002¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\t\u001a\u00020\b2\u0006\u0010\u0004\u001a\u00020\u000bH\u0002¢\u0006\u0004\b\t\u0010\fJ\u000f\u0010\r\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\r\u0010\u000eJ\u001f\u0010\u0012\u001a\u00020\b2\u0006\u0010\u000f\u001a\u00020\u00052\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010¢\u0006\u0004\b\u0012\u0010\u0013J\u0017\u0010\u0016\u001a\u00020\b2\b\u0010\u0015\u001a\u0004\u0018\u00010\u0014¢\u0006\u0004\b\u0016\u0010\u0017J\u000f\u0010\u0019\u001a\u00020\u0018H\u0002¢\u0006\u0004\b\u0019\u0010\u001aJ\u0017\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u0004\u001a\u00020\u0018H\u0002¢\u0006\u0004\b\u0019\u0010\u001bJ\u0017\u0010\t\u001a\u00020\u00182\u0006\u0010\u0004\u001a\u00020\u0018H\u0002¢\u0006\u0004\b\t\u0010\u001bJ\u000f\u0010\u001c\u001a\u00020\bH\u0014¢\u0006\u0004\b\u001c\u0010\nJA\u0010!\u001a\u00020\b2\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u001d\u001a\u0004\u0018\u00010\u00052\b\u0010\u001e\u001a\u0004\u0018\u00010\u00052\b\u0010\u001f\u001a\u0004\u0018\u00010\u00052\b\u0010 \u001a\u0004\u0018\u00010\u0005H\u0002¢\u0006\u0004\b!\u0010\"J\u0015\u0010%\u001a\u00020\b2\u0006\u0010$\u001a\u00020#¢\u0006\u0004\b%\u0010&J\u0015\u0010)\u001a\u00020\b2\u0006\u0010(\u001a\u00020'¢\u0006\u0004\b)\u0010*J\u0015\u0010+\u001a\u00020\b2\u0006\u0010\u0011\u001a\u00020\u0010¢\u0006\u0004\b+\u0010,J\u0015\u0010.\u001a\u00020\b2\u0006\u0010-\u001a\u00020\u0005¢\u0006\u0004\b.\u0010/J\u0015\u00102\u001a\u00020\b2\u0006\u00101\u001a\u000200¢\u0006\u0004\b2\u00103J\u0015\u00105\u001a\u00020\b2\u0006\u00104\u001a\u00020\u000b¢\u0006\u0004\b5\u0010\fJ\u0015\u00107\u001a\u00020\b2\u0006\u00106\u001a\u00020\u0005¢\u0006\u0004\b7\u0010/J\u0017\u00108\u001a\u00020\b2\u0006\u0010\u0004\u001a\u00020\u000bH\u0002¢\u0006\u0004\b8\u0010\fJ\u000f\u00109\u001a\u00020\bH\u0016¢\u0006\u0004\b9\u0010\nJ\u0015\u0010;\u001a\u00020\b2\u0006\u0010:\u001a\u00020\u0005¢\u0006\u0004\b;\u0010/J5\u0010@\u001a\u00020\b2\b\b\u0002\u0010<\u001a\u00020\u00052\b\b\u0002\u0010:\u001a\u00020\u00052\b\b\u0002\u0010>\u001a\u00020=2\b\b\u0002\u0010?\u001a\u00020=¢\u0006\u0004\b@\u0010AJ\u0017\u0010\t\u001a\u00020\b2\u0006\u0010\u0004\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\t\u0010/J\u0017\u0010\t\u001a\u00020\b2\u0006\u0010\u0004\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\t\u0010BJ\u0017\u0010\t\u001a\u00020\b2\u0006\u0010\u0004\u001a\u00020CH\u0002¢\u0006\u0004\b\t\u0010DJ\u0011\u0010F\u001a\u00020\b*\u00020E¢\u0006\u0004\bF\u0010GJ\u001b\u0010\t\u001a\u00020\b*\u00020H2\u0006\u0010\u0004\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\t\u0010IJ+\u00108\u001a\u0006*\u00020\u00050\u0005*\u00020E2\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u001d\u001a\u0004\u0018\u00010\u0005H\u0002¢\u0006\u0004\b8\u0010JJ\u0013\u00108\u001a\u00020\b*\u00020EH\u0002¢\u0006\u0004\b8\u0010GJ\u0013\u0010\u0006\u001a\u00020\b*\u00020EH\u0002¢\u0006\u0004\b\u0006\u0010GJ\u0019\u0010M\u001a\u00020\b*\u00020E2\u0006\u0010L\u001a\u00020K¢\u0006\u0004\bM\u0010NJ\u001d\u00108\u001a\u00020\u0018*\u00020E2\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0002¢\u0006\u0004\b8\u0010OJ\u0013\u0010\t\u001a\u00020\b*\u00020EH\u0002¢\u0006\u0004\b\t\u0010GJ\u0013\u0010\u0019\u001a\u00020\b*\u00020EH\u0002¢\u0006\u0004\b\u0019\u0010GJ\u0013\u0010!\u001a\u00020\b*\u00020EH\u0002¢\u0006\u0004\b!\u0010GR\u0016\u00108\u001a\u0002008\u0002@\u0002X\u0083.¢\u0006\u0006\n\u0004\b!\u0010PR\u0016\u0010\u0006\u001a\u00020\u00058\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\b\u0006\u0010QR\u0016\u0010\u0019\u001a\u00020\u00058\u0002@\u0002X\u0083.¢\u0006\u0006\n\u0004\b\t\u0010QR\u001c\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00050R8\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\b\u0019\u0010SR\u0018\u0010!\u001a\u0004\u0018\u00010'8\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\b8\u0010TR\"\u0010V\u001a\u00020U8\u0007@\u0007X\u0087.¢\u0006\u0012\n\u0004\bV\u0010W\u001a\u0004\bX\u0010Y\"\u0004\bZ\u0010[R\u0018\u0010^\u001a\u0004\u0018\u00010\u00108\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\b\\\u0010]R\"\u0010`\u001a\u00020_8\u0007@\u0007X\u0087.¢\u0006\u0012\n\u0004\b`\u0010a\u001a\u0004\bb\u0010c\"\u0004\bd\u0010eR\"\u0010g\u001a\u00020f8\u0007@\u0007X\u0087.¢\u0006\u0012\n\u0004\bg\u0010h\u001a\u0004\bi\u0010j\"\u0004\bk\u0010lR\u0013\u0010p\u001a\u00020mX\u0083\u0080\u0002¢\u0006\u0006\n\u0004\bn\u0010oR\u0016\u0010n\u001a\u00020#8\u0002@\u0002X\u0083.¢\u0006\u0006\n\u0004\bp\u0010qR\u0016\u0010\\\u001a\u00020\u00058\u0002@\u0002X\u0083.¢\u0006\u0006\n\u0004\b^\u0010QR.\u0010x\u001a\u0004\u0018\u00010E2\b\u0010r\u001a\u0004\u0018\u00010E8\u0007@GX\u0087\u000e¢\u0006\u0012\n\u0004\bs\u0010t\u001a\u0004\bu\u0010v\"\u0004\bw\u0010GR\u0016\u0010s\u001a\u00020y8\u0002@\u0002X\u0083.¢\u0006\u0006\n\u0004\bz\u0010{R\u0016\u0010z\u001a\u00020\u000b8\u0002@\u0002X\u0083.¢\u0006\u0006\n\u0004\b|\u0010}R\u0015\u0010\u007f\u001a\u00020~8\u0002X\u0083\u0004¢\u0006\u0007\n\u0005\b\u007f\u0010\u0080\u0001R\u0018\u0010\u0082\u0001\u001a\u00020\u00058\u0002@\u0002X\u0083.¢\u0006\u0007\n\u0005\b\u0081\u0001\u0010Q"}, d2 = {"Lid/dana/sendmoney/summary/view/SummaryView;", "Lid/dana/core/ui/BaseViewBindingRichView;", "Lid/dana/databinding/ViewSendmoneySummaryBinding;", "Landroid/view/View;", "p0", "", "MyBillsEntityDataFactory", "(Landroid/view/View;)Ljava/lang/String;", "", "BuiltInFictitiousFunctionClassFactory", "()V", "Lid/dana/sendmoney/ui/core/model/TransferInitResultModel;", "(Lid/dana/sendmoney/ui/core/model/TransferInitResultModel;)V", "inflateViewBinding", "()Lid/dana/databinding/ViewSendmoneySummaryBinding;", CashierKeyParams.TRANSFER_TYPE, "Lid/dana/sendmoney/model/RecipientModel;", "recipientModel", "initSummaryBiztransfer", "(Ljava/lang/String;Lid/dana/sendmoney/model/RecipientModel;)V", "Lid/dana/di/component/ApplicationComponent;", "applicationComponent", "injectComponent", "(Lid/dana/di/component/ApplicationComponent;)V", "", "getAuthRequestContext", "()Z", "(Z)Z", "onDetachedFromWindow", "p1", "p2", "p3", "p4", "KClassImpl$Data$declaredNonStaticMembers$2", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "Lid/dana/domain/sendmoney/model/SmartFrictionConfig;", "smartFrictionConfig", "setSmartFrictionEnable", "(Lid/dana/domain/sendmoney/model/SmartFrictionConfig;)V", "Lid/dana/sendmoney/summary/view/SummaryView$SummaryListener;", "summaryListener", "setSummaryListener", "(Lid/dana/sendmoney/summary/view/SummaryView$SummaryListener;)V", "setSummaryViewRecipientModel", "(Lid/dana/sendmoney/model/RecipientModel;)V", "source", "setSummaryViewSource", "(Ljava/lang/String;)V", "Lid/dana/domain/sendmoney/model/TransferInit;", "transferInit", "setSummaryViewTransferInit", "(Lid/dana/domain/sendmoney/model/TransferInit;)V", "transferInitResultModel", "setSummaryViewTransferInitResultModel", "version", "setSummaryViewVersion", "PlaceComponentResult", "setup", "message", "showAmountInfoMessage", "amount", "", "drawableRes", CdpConstants.CONTENT_TEXT_COLOR, "showAmountWarningMessage", "(Ljava/lang/String;Ljava/lang/String;II)V", "(Landroid/view/View;)V", "Lid/dana/sendmoney/ui/core/model/TransferUserInfoModel;", "(Lid/dana/sendmoney/ui/core/model/TransferUserInfoModel;)V", "Lid/dana/sendmoney/summary/view/SummaryViewState;", "checkEnableTransferInit", "(Lid/dana/sendmoney/summary/view/SummaryViewState;)V", "Landroidx/appcompat/widget/AppCompatEditText;", "(Landroidx/appcompat/widget/AppCompatEditText;Ljava/lang/String;)V", "(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;", "Lid/dana/sendmoney/ui/core/model/SendMoneyApiMigrationConfigModel;", "sendMoneyApiMigrationConfigModel", "initTransfer", "(Lid/dana/sendmoney/summary/view/SummaryViewState;Lid/dana/sendmoney/ui/core/model/SendMoneyApiMigrationConfigModel;)V", "(Ljava/lang/String;)Z", "Lid/dana/domain/sendmoney/model/TransferInit;", "Ljava/lang/String;", "", "Ljava/util/List;", "Lid/dana/sendmoney/summary/view/SummaryView$SummaryListener;", "Lid/dana/contract/sendmoney/SendMoneyContract$Presenter;", "presenter", "Lid/dana/contract/sendmoney/SendMoneyContract$Presenter;", "getPresenter", "()Lid/dana/contract/sendmoney/SendMoneyContract$Presenter;", "setPresenter", "(Lid/dana/contract/sendmoney/SendMoneyContract$Presenter;)V", "scheduleImpl", "Lid/dana/sendmoney/model/RecipientModel;", "getErrorConfigVersion", "Lid/dana/sendmoney_v2/tracker/SendMoneyAnalyticTracker;", "sendMoneyAnalyticalTracker", "Lid/dana/sendmoney_v2/tracker/SendMoneyAnalyticTracker;", "getSendMoneyAnalyticalTracker", "()Lid/dana/sendmoney_v2/tracker/SendMoneyAnalyticTracker;", "setSendMoneyAnalyticalTracker", "(Lid/dana/sendmoney_v2/tracker/SendMoneyAnalyticTracker;)V", "Lid/dana/sendmoney/ui/core/presenter/SendMoneyCoreContract$Presenter;", "sendMoneyCorePresenter", "Lid/dana/sendmoney/ui/core/presenter/SendMoneyCoreContract$Presenter;", "getSendMoneyCorePresenter", "()Lid/dana/sendmoney/ui/core/presenter/SendMoneyCoreContract$Presenter;", "setSendMoneyCorePresenter", "(Lid/dana/sendmoney/ui/core/presenter/SendMoneyCoreContract$Presenter;)V", "Lid/dana/sendmoney_v2/tracker/SendMoneyFeatureTime;", "NetworkUserEntityData$$ExternalSyntheticLambda0", "Lkotlin/Lazy;", "moveToNextValue", "Lid/dana/domain/sendmoney/model/SmartFrictionConfig;", "value", "lookAheadTest", "Lid/dana/sendmoney/summary/view/SummaryViewState;", "getSummaryViewState", "()Lid/dana/sendmoney/summary/view/SummaryViewState;", "setSummaryViewState", "summaryViewState", "", "NetworkUserEntityData$$ExternalSyntheticLambda1", "Ljava/lang/Throwable;", "DatabaseTableConfigUtil", "Lid/dana/sendmoney/ui/core/model/TransferInitResultModel;", "Lid/dana/sendmoney/mapper/TransferBankMapper;", "GetContactSyncConfig", "Lid/dana/sendmoney/mapper/TransferBankMapper;", "initRecordTimeStamp", "NetworkUserEntityData$$ExternalSyntheticLambda2", "Landroid/content/Context;", HummerConstants.CONTEXT, "Landroid/util/AttributeSet;", "attrs", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "defStyleRes", "(Landroid/content/Context;Landroid/util/AttributeSet;II)V", "SummaryListener"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class SummaryView extends BaseViewBindingRichView<ViewSendmoneySummaryBinding> {

    /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
    private String getAuthRequestContext;

    /* renamed from: DatabaseTableConfigUtil  reason: from kotlin metadata */
    private TransferInitResultModel NetworkUserEntityData$$ExternalSyntheticLambda1;
    private final TransferBankMapper GetContactSyncConfig;

    /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
    private TransferInit PlaceComponentResult;
    private String MyBillsEntityDataFactory;

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda0  reason: from kotlin metadata */
    private final Lazy moveToNextValue;

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda1  reason: from kotlin metadata */
    private Throwable lookAheadTest;

    /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
    private SummaryListener KClassImpl$Data$declaredNonStaticMembers$2;
    public Map<Integer, View> _$_findViewCache;

    /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
    private List<String> BuiltInFictitiousFunctionClassFactory;

    /* renamed from: getErrorConfigVersion  reason: from kotlin metadata */
    private String scheduleImpl;

    /* renamed from: initRecordTimeStamp  reason: from kotlin metadata */
    private String NetworkUserEntityData$$ExternalSyntheticLambda2;

    /* renamed from: lookAheadTest  reason: from kotlin metadata */
    private SummaryViewState summaryViewState;

    /* renamed from: moveToNextValue  reason: from kotlin metadata */
    private SmartFrictionConfig NetworkUserEntityData$$ExternalSyntheticLambda0;
    @Inject
    public SendMoneyContract.Presenter presenter;

    /* renamed from: scheduleImpl  reason: from kotlin metadata */
    private RecipientModel getErrorConfigVersion;
    @Inject
    public SendMoneyAnalyticTracker sendMoneyAnalyticalTracker;
    @Inject
    public SendMoneyCoreContract.Presenter sendMoneyCorePresenter;

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006J\u001f\u0010\b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0002H&¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\u0005\u001a\u00020\u0004H&¢\u0006\u0004\b\u0005\u0010\nJ\u000f\u0010\u000b\u001a\u00020\u0004H&¢\u0006\u0004\b\u000b\u0010\nJ\u000f\u0010\f\u001a\u00020\u0004H&¢\u0006\u0004\b\f\u0010\nJ\u001f\u0010\f\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0002H&¢\u0006\u0004\b\f\u0010\tJ\u0019\u0010\u000e\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\rH&¢\u0006\u0004\b\u000e\u0010\u000fø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001À\u0006\u0001"}, d2 = {"Lid/dana/sendmoney/summary/view/SummaryView$SummaryListener;", "", "", "p0", "", "PlaceComponentResult", "(Ljava/lang/String;)V", "p1", "BuiltInFictitiousFunctionClassFactory", "(Ljava/lang/String;Ljava/lang/String;)V", "()V", "MyBillsEntityDataFactory", "getAuthRequestContext", "Lid/dana/sendmoney/model/RecipientModel;", "KClassImpl$Data$declaredNonStaticMembers$2", "(Lid/dana/sendmoney/model/RecipientModel;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public interface SummaryListener {
        void BuiltInFictitiousFunctionClassFactory(String p0, String p1);

        void KClassImpl$Data$declaredNonStaticMembers$2(RecipientModel p0);

        void MyBillsEntityDataFactory();

        void PlaceComponentResult();

        void PlaceComponentResult(String p0);

        void getAuthRequestContext();

        void getAuthRequestContext(String p0, String p1);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public SummaryView(Context context) {
        this(context, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(context, "");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public SummaryView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        Intrinsics.checkNotNullParameter(context, "");
    }

    @Override // id.dana.core.ui.BaseViewBindingRichView
    public final void _$_clearFindViewByIdCache() {
        this._$_findViewCache.clear();
    }

    @Override // id.dana.core.ui.BaseViewBindingRichView
    public final View _$_findCachedViewById(int i) {
        Map<Integer, View> map = this._$_findViewCache;
        View view = map.get(Integer.valueOf(i));
        if (view == null) {
            View findViewById = findViewById(i);
            if (findViewById != null) {
                map.put(Integer.valueOf(i), findViewById);
                return findViewById;
            }
            return null;
        }
        return view;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SummaryView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "");
        this._$_findViewCache = new LinkedHashMap();
        this.MyBillsEntityDataFactory = "";
        this.BuiltInFictitiousFunctionClassFactory = new ArrayList();
        this.moveToNextValue = LazyKt.lazy(SummaryView$sendMoneyFeatureTime$2.INSTANCE);
        this.GetContactSyncConfig = new TransferBankMapper();
    }

    public /* synthetic */ SummaryView(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    @Override // id.dana.core.ui.BaseViewBindingRichView
    public final ViewSendmoneySummaryBinding inflateViewBinding() {
        ViewSendmoneySummaryBinding MyBillsEntityDataFactory = ViewSendmoneySummaryBinding.MyBillsEntityDataFactory(LayoutInflater.from(getContext()));
        Intrinsics.checkNotNullExpressionValue(MyBillsEntityDataFactory, "");
        return MyBillsEntityDataFactory;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SummaryView(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        Intrinsics.checkNotNullParameter(context, "");
        this._$_findViewCache = new LinkedHashMap();
        this.MyBillsEntityDataFactory = "";
        this.BuiltInFictitiousFunctionClassFactory = new ArrayList();
        this.moveToNextValue = LazyKt.lazy(SummaryView$sendMoneyFeatureTime$2.INSTANCE);
        this.GetContactSyncConfig = new TransferBankMapper();
    }

    @JvmName(name = "getPresenter")
    public final SendMoneyContract.Presenter getPresenter() {
        SendMoneyContract.Presenter presenter = this.presenter;
        if (presenter != null) {
            return presenter;
        }
        Intrinsics.throwUninitializedPropertyAccessException("");
        return null;
    }

    @JvmName(name = "setPresenter")
    public final void setPresenter(SendMoneyContract.Presenter presenter) {
        Intrinsics.checkNotNullParameter(presenter, "");
        this.presenter = presenter;
    }

    @JvmName(name = "getSendMoneyCorePresenter")
    public final SendMoneyCoreContract.Presenter getSendMoneyCorePresenter() {
        SendMoneyCoreContract.Presenter presenter = this.sendMoneyCorePresenter;
        if (presenter != null) {
            return presenter;
        }
        Intrinsics.throwUninitializedPropertyAccessException("");
        return null;
    }

    @JvmName(name = "setSendMoneyCorePresenter")
    public final void setSendMoneyCorePresenter(SendMoneyCoreContract.Presenter presenter) {
        Intrinsics.checkNotNullParameter(presenter, "");
        this.sendMoneyCorePresenter = presenter;
    }

    @JvmName(name = "getSummaryViewState")
    public final SummaryViewState getSummaryViewState() {
        return this.summaryViewState;
    }

    @JvmName(name = "setSummaryViewState")
    public final void setSummaryViewState(SummaryViewState summaryViewState) {
        this.summaryViewState = summaryViewState;
    }

    @JvmName(name = "getSendMoneyAnalyticalTracker")
    public final SendMoneyAnalyticTracker getSendMoneyAnalyticalTracker() {
        SendMoneyAnalyticTracker sendMoneyAnalyticTracker = this.sendMoneyAnalyticalTracker;
        if (sendMoneyAnalyticTracker != null) {
            return sendMoneyAnalyticTracker;
        }
        Intrinsics.throwUninitializedPropertyAccessException("");
        return null;
    }

    @JvmName(name = "setSendMoneyAnalyticalTracker")
    public final void setSendMoneyAnalyticalTracker(SendMoneyAnalyticTracker sendMoneyAnalyticTracker) {
        Intrinsics.checkNotNullParameter(sendMoneyAnalyticTracker, "");
        this.sendMoneyAnalyticalTracker = sendMoneyAnalyticTracker;
    }

    @Override // id.dana.core.ui.BaseViewBindingRichView
    public final void setup() {
        injectComponent(ComponentHolder.getAuthRequestContext());
        final CurrencyEditText currencyEditText = getBinding().getAuthRequestContext.MyBillsEntityDataFactory;
        currencyEditText.requestFocus();
        currencyEditText.setFocusableInTouchMode(true);
        currencyEditText.disableSoftKeyboard();
        currencyEditText.setTextHint(currencyEditText.getContext().getString(R.string.amount_default));
        currencyEditText.setTextHintColor(R.color.f23962131099992);
        currencyEditText.removeUnderline();
        currencyEditText.setAllowEmpty(true);
        Intrinsics.checkNotNullExpressionValue(currencyEditText, "");
        final CurrencyEditText currencyEditText2 = currencyEditText;
        if (ViewCompat.C(currencyEditText2)) {
            LifecycleOwner PlaceComponentResult = C0207ViewKt.PlaceComponentResult(currencyEditText2);
            if (PlaceComponentResult != null) {
                FlowKt.launchIn(FlowKt.onEach(currencyEditText.listenOriginalValue(), new SummaryView$initEditText$1$1$1$1(this, currencyEditText, null)), LifecycleOwnerKt.PlaceComponentResult(PlaceComponentResult));
            }
        } else {
            currencyEditText2.addOnAttachStateChangeListener(new View.OnAttachStateChangeListener() { // from class: id.dana.sendmoney.summary.view.SummaryView$initEditText$lambda-15$$inlined$doOnAttach$1
                @Override // android.view.View.OnAttachStateChangeListener
                public final void onViewDetachedFromWindow(View p0) {
                    Intrinsics.checkNotNullParameter(p0, "");
                }

                @Override // android.view.View.OnAttachStateChangeListener
                public final void onViewAttachedToWindow(View p0) {
                    Intrinsics.checkNotNullParameter(p0, "");
                    currencyEditText2.removeOnAttachStateChangeListener(this);
                    Intrinsics.checkNotNullExpressionValue(currencyEditText, "");
                    LifecycleOwner PlaceComponentResult2 = C0207ViewKt.PlaceComponentResult(currencyEditText);
                    if (PlaceComponentResult2 != null) {
                        FlowKt.launchIn(FlowKt.onEach(currencyEditText.listenOriginalValue(), new SummaryView$initEditText$1$1$1$1(this, currencyEditText, null)), LifecycleOwnerKt.PlaceComponentResult(PlaceComponentResult2));
                    }
                }
            });
        }
        currencyEditText.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: id.dana.sendmoney.summary.view.SummaryView$$ExternalSyntheticLambda0
            @Override // android.view.View.OnFocusChangeListener
            public final void onFocusChange(View view, boolean z) {
                SummaryView.m2912$r8$lambda$pPqq6rlLDXuf8tcLCD4YkKMRwM(CurrencyEditText.this, view, z);
            }
        });
        getBinding().getAuthRequestContext.PlaceComponentResult.setOnClickListener(new View.OnClickListener() { // from class: id.dana.sendmoney.summary.view.SummaryView$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                SummaryView.$r8$lambda$WxYxtP1mJgTl378Eekl5J1qS8M8(SummaryView.this, view);
            }
        });
        final DanaTextBoxView danaTextBoxView = getBinding().MyBillsEntityDataFactory;
        String[] stringArray = danaTextBoxView.getResources().getStringArray(R.array.notes_hint_feed_send_money);
        Intrinsics.checkNotNullExpressionValue(stringArray, "");
        danaTextBoxView.setHint((CharSequence) ArraysKt.random(stringArray, Random.INSTANCE));
        danaTextBoxView.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: id.dana.sendmoney.summary.view.SummaryView$$ExternalSyntheticLambda2
            @Override // android.view.View.OnFocusChangeListener
            public final void onFocusChange(View view, boolean z) {
                SummaryView.$r8$lambda$49oSw9DynRzkhwBIIrcCVXvJh0s(DanaTextBoxView.this, view, z);
            }
        });
        danaTextBoxView.setOnEditorActionListener(new TextView.OnEditorActionListener() { // from class: id.dana.sendmoney.summary.view.SummaryView$$ExternalSyntheticLambda3
            @Override // android.widget.TextView.OnEditorActionListener
            public final boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                boolean BuiltInFictitiousFunctionClassFactory;
                BuiltInFictitiousFunctionClassFactory = SummaryView.BuiltInFictitiousFunctionClassFactory(SummaryView.this, i);
                return BuiltInFictitiousFunctionClassFactory;
            }
        });
    }

    public final void injectComponent(ApplicationComponent applicationComponent) {
        DaggerCalculatorComponent.Builder KClassImpl$Data$declaredNonStaticMembers$2 = DaggerCalculatorComponent.KClassImpl$Data$declaredNonStaticMembers$2();
        KClassImpl$Data$declaredNonStaticMembers$2.PlaceComponentResult = (ApplicationComponent) Preconditions.getAuthRequestContext(applicationComponent);
        KClassImpl$Data$declaredNonStaticMembers$2.KClassImpl$Data$declaredNonStaticMembers$2 = (SendMoneyModule) Preconditions.getAuthRequestContext(new SendMoneyModule(new SummaryView$injectComponent$1(this)));
        KClassImpl$Data$declaredNonStaticMembers$2.BuiltInFictitiousFunctionClassFactory = (SendMoneyCoreModule) Preconditions.getAuthRequestContext(new SendMoneyCoreModule(new SummaryView$getSendMoneyCoreModule$1(this)));
        Preconditions.KClassImpl$Data$declaredNonStaticMembers$2(KClassImpl$Data$declaredNonStaticMembers$2.KClassImpl$Data$declaredNonStaticMembers$2, SendMoneyModule.class);
        if (KClassImpl$Data$declaredNonStaticMembers$2.MyBillsEntityDataFactory == null) {
            KClassImpl$Data$declaredNonStaticMembers$2.MyBillsEntityDataFactory = new SendMoneyTrackerModule();
        }
        Preconditions.KClassImpl$Data$declaredNonStaticMembers$2(KClassImpl$Data$declaredNonStaticMembers$2.BuiltInFictitiousFunctionClassFactory, SendMoneyCoreModule.class);
        Preconditions.KClassImpl$Data$declaredNonStaticMembers$2(KClassImpl$Data$declaredNonStaticMembers$2.PlaceComponentResult, ApplicationComponent.class);
        new DaggerCalculatorComponent.CalculatorComponentImpl(KClassImpl$Data$declaredNonStaticMembers$2.KClassImpl$Data$declaredNonStaticMembers$2, KClassImpl$Data$declaredNonStaticMembers$2.MyBillsEntityDataFactory, KClassImpl$Data$declaredNonStaticMembers$2.BuiltInFictitiousFunctionClassFactory, KClassImpl$Data$declaredNonStaticMembers$2.PlaceComponentResult, (byte) 0).PlaceComponentResult(this);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        getPresenter().onDestroy();
        getSendMoneyCorePresenter().PlaceComponentResult();
    }

    /* JADX WARN: Removed duplicated region for block: B:60:0x00bb  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x00bd  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final void PlaceComponentResult(id.dana.sendmoney.summary.view.SummaryViewState r7) {
        /*
            r6 = this;
            java.lang.String r0 = r6.getAuthRequestContext
            java.lang.String r1 = ""
            if (r0 == 0) goto L16
            id.dana.sendmoney.summary.view.SummaryViewState r0 = r6.summaryViewState
            if (r0 == 0) goto L16
            id.dana.sendmoney.model.RecipientModel r0 = r0.scheduleImpl
            java.lang.String r2 = r6.getAuthRequestContext
            if (r2 != 0) goto L14
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r1)
            r2 = 0
        L14:
            r0.getErrorConfigVersion = r2
        L16:
            androidx.viewbinding.ViewBinding r0 = r6.getBinding()
            id.dana.databinding.ViewSendmoneySummaryBinding r0 = (id.dana.databinding.ViewSendmoneySummaryBinding) r0
            id.dana.databinding.LayoutSenderViewBinding r0 = r0.KClassImpl$Data$declaredNonStaticMembers$2
            androidx.appcompat.widget.AppCompatTextView r0 = r0.scheduleImpl
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r1)
            r2 = r0
            android.view.View r2 = (android.view.View) r2
            r3 = 0
            r2.setVisibility(r3)
            id.dana.sendmoney.model.RecipientModel r2 = r7.scheduleImpl
            java.lang.String r2 = r2.PlaceComponentResult()
            java.lang.String r4 = "-"
            boolean r2 = kotlin.jvm.internal.Intrinsics.areEqual(r2, r4)
            if (r2 == 0) goto L49
            android.content.Context r2 = r0.getContext()
            java.lang.String r2 = r7.MyBillsEntityDataFactory(r2)
            id.dana.sendmoney.model.RecipientModel r5 = r7.scheduleImpl
            java.lang.String r5 = r5.getErrorConfigVersion
            java.lang.String r2 = PlaceComponentResult(r2, r5)
            goto L61
        L49:
            android.content.Context r2 = r0.getContext()
            java.lang.String r2 = r7.MyBillsEntityDataFactory(r2)
            java.lang.String r5 = r7.BuiltInFictitiousFunctionClassFactory()
            boolean r2 = PlaceComponentResult(r2)
            if (r2 == 0) goto L5d
            r2 = r1
            goto L61
        L5d:
            java.lang.String r2 = id.dana.utils.MaskedTextUtil.MyBillsEntityDataFactory(r5)
        L61:
            id.dana.core.ui.util.NumberUtil r5 = id.dana.core.ui.util.NumberUtil.INSTANCE
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r2, r1)
            boolean r5 = id.dana.core.ui.util.NumberUtil.lookAheadTest(r2)
            if (r5 == 0) goto L72
            id.dana.core.ui.util.NumberUtil r5 = id.dana.core.ui.util.NumberUtil.INSTANCE
            java.lang.String r2 = id.dana.core.ui.util.NumberUtil.MyBillsEntityDataFactory(r2)
        L72:
            java.lang.CharSequence r2 = (java.lang.CharSequence) r2
            r0.setText(r2)
            androidx.viewbinding.ViewBinding r0 = r6.getBinding()
            id.dana.databinding.ViewSendmoneySummaryBinding r0 = (id.dana.databinding.ViewSendmoneySummaryBinding) r0
            id.dana.databinding.LayoutSenderViewBinding r0 = r0.KClassImpl$Data$declaredNonStaticMembers$2
            androidx.appcompat.widget.AppCompatTextView r0 = r0.NetworkUserEntityData$$ExternalSyntheticLambda0
            android.content.Context r2 = r0.getContext()
            java.lang.String r2 = r7.MyBillsEntityDataFactory(r2)
            id.dana.sendmoney.model.RecipientModel r5 = r7.scheduleImpl
            java.lang.String r5 = r5.getErrorConfigVersion
            java.lang.String r2 = PlaceComponentResult(r2, r5)
            java.lang.CharSequence r2 = (java.lang.CharSequence) r2
            r0.setText(r2)
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r1)
            r2 = r0
            android.view.View r2 = (android.view.View) r2
            id.dana.sendmoney.model.RecipientModel r7 = r7.scheduleImpl
            java.lang.String r7 = r7.PlaceComponentResult()
            boolean r7 = kotlin.jvm.internal.Intrinsics.areEqual(r7, r4)
            if (r7 == 0) goto La9
            goto Lb8
        La9:
            java.lang.CharSequence r7 = r0.getText()
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r7, r1)
            boolean r7 = kotlin.text.StringsKt.isBlank(r7)
            if (r7 != 0) goto Lb8
            r7 = 1
            goto Lb9
        Lb8:
            r7 = 0
        Lb9:
            if (r7 == 0) goto Lbd
            r7 = 0
            goto Lbf
        Lbd:
            r7 = 8
        Lbf:
            r2.setVisibility(r7)
            androidx.viewbinding.ViewBinding r7 = r6.getBinding()
            id.dana.databinding.ViewSendmoneySummaryBinding r7 = (id.dana.databinding.ViewSendmoneySummaryBinding) r7
            id.dana.databinding.LayoutSenderViewBinding r7 = r7.KClassImpl$Data$declaredNonStaticMembers$2
            android.widget.TextView r7 = r7.getErrorConfigVersion
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r7, r1)
            android.view.View r7 = (android.view.View) r7
            r7.setVisibility(r3)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.sendmoney.summary.view.SummaryView.PlaceComponentResult(id.dana.sendmoney.summary.view.SummaryViewState):void");
    }

    private final void MyBillsEntityDataFactory(SummaryViewState summaryViewState) {
        AppCompatTextView appCompatTextView = getBinding().KClassImpl$Data$declaredNonStaticMembers$2.lookAheadTest;
        Intrinsics.checkNotNullExpressionValue(appCompatTextView, "");
        appCompatTextView.setVisibility(0);
        appCompatTextView.setText(PlaceComponentResult(summaryViewState.MyBillsEntityDataFactory(appCompatTextView.getContext()), summaryViewState.scheduleImpl.getErrorConfigVersion));
        AppCompatTextView appCompatTextView2 = getBinding().KClassImpl$Data$declaredNonStaticMembers$2.moveToNextValue;
        Intrinsics.checkNotNullExpressionValue(appCompatTextView2, "");
        AppCompatTextView appCompatTextView3 = appCompatTextView2;
        appCompatTextView3.setVisibility(0);
        String MyBillsEntityDataFactory = PlaceComponentResult(summaryViewState.MyBillsEntityDataFactory(appCompatTextView2.getContext())) ? "" : MaskedTextUtil.MyBillsEntityDataFactory(summaryViewState.BuiltInFictitiousFunctionClassFactory());
        NumberUtil numberUtil = NumberUtil.INSTANCE;
        Intrinsics.checkNotNullExpressionValue(MyBillsEntityDataFactory, "");
        if (NumberUtil.lookAheadTest(MyBillsEntityDataFactory)) {
            NumberUtil numberUtil2 = NumberUtil.INSTANCE;
            MyBillsEntityDataFactory = NumberUtil.MyBillsEntityDataFactory(MyBillsEntityDataFactory);
        }
        appCompatTextView2.setText(MyBillsEntityDataFactory);
        CharSequence text = appCompatTextView2.getText();
        Intrinsics.checkNotNullExpressionValue(text, "");
        appCompatTextView3.setVisibility(StringsKt.isBlank(text) ^ true ? 0 : 8);
    }

    private final boolean BuiltInFictitiousFunctionClassFactory(boolean p0) {
        SmartFrictionConfig smartFrictionConfig = this.NetworkUserEntityData$$ExternalSyntheticLambda0;
        if (smartFrictionConfig == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            smartFrictionConfig = null;
        }
        return smartFrictionConfig.getNotContactListRecent() && p0 && this.NetworkUserEntityData$$ExternalSyntheticLambda0 != null;
    }

    private final boolean getAuthRequestContext(boolean p0) {
        SmartFrictionConfig smartFrictionConfig = this.NetworkUserEntityData$$ExternalSyntheticLambda0;
        if (smartFrictionConfig == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            smartFrictionConfig = null;
        }
        return smartFrictionConfig.getNotBankListRecent() && p0 && this.NetworkUserEntityData$$ExternalSyntheticLambda0 != null;
    }

    private static boolean PlaceComponentResult(String p0) {
        return Intrinsics.areEqual(p0, "-") || NumberUtils.isValidIndoPhoneNumberPrefix(p0);
    }

    private static String PlaceComponentResult(String p0, String p1) {
        if (PlaceComponentResult(p0)) {
            return NumberUtils.replaceAsteriskWithDot(MaskedTextUtil.MyBillsEntityDataFactory(p1));
        }
        if (p0 == null) {
            p0 = "-";
        }
        return MaskedTextUtil.PlaceComponentResult(p0);
    }

    public final void BuiltInFictitiousFunctionClassFactory(TransferInitResultModel p0) {
        SmartFrictionConfig smartFrictionConfig = null;
        if (this.NetworkUserEntityData$$ExternalSyntheticLambda1 != null) {
            getSendMoneyCorePresenter().BuiltInFictitiousFunctionClassFactory(p0.PlaceComponentResult.newProxyInstance, p0.PlaceComponentResult.FragmentBottomSheetPaymentSettingBinding);
            SummaryViewState summaryViewState = this.summaryViewState;
            if (summaryViewState != null) {
                KClassImpl$Data$declaredNonStaticMembers$2(summaryViewState);
            }
            ((SendMoneyFeatureTime) this.moveToNextValue.getValue()).moveToNextValue = DateTimeUtil.BuiltInFictitiousFunctionClassFactory();
            SendMoneyAnalyticTracker sendMoneyAnalyticalTracker = getSendMoneyAnalyticalTracker();
            RecipientModel recipientModel = this.getErrorConfigVersion;
            boolean errorConfigVersion = recipientModel != null ? recipientModel.getErrorConfigVersion() : false;
            String str = this.scheduleImpl;
            if (str == null) {
                Intrinsics.throwUninitializedPropertyAccessException("");
                str = null;
            }
            sendMoneyAnalyticalTracker.getAuthRequestContext(errorConfigVersion, str, this.BuiltInFictitiousFunctionClassFactory);
        }
        PlaceComponentResult(p0);
        BuiltInFictitiousFunctionClassFactory(p0.PlaceComponentResult);
        SummaryViewState summaryViewState2 = this.summaryViewState;
        if (summaryViewState2 != null) {
            getAuthRequestContext(summaryViewState2);
        }
        Context context = getContext();
        SummaryActivity summaryActivity = context instanceof SummaryActivity ? (SummaryActivity) context : null;
        if (summaryActivity != null) {
            summaryActivity.getTransferBalanceInitCallback(p0);
        }
        CurrencyEditText currencyEditText = getBinding().getAuthRequestContext.MyBillsEntityDataFactory;
        if ((currencyEditText.getAmountModel().getAmount().length() > 0) && !currencyEditText.getAmountModel().isAmountLessThanOne() && !getAuthRequestContext() && this.NetworkUserEntityData$$ExternalSyntheticLambda0 != null) {
            SendMoneyContract.Presenter presenter = getPresenter();
            String amount = currencyEditText.getAmount();
            SmartFrictionConfig smartFrictionConfig2 = this.NetworkUserEntityData$$ExternalSyntheticLambda0;
            if (smartFrictionConfig2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("");
            } else {
                smartFrictionConfig = smartFrictionConfig2;
            }
            presenter.MyBillsEntityDataFactory(amount, smartFrictionConfig.getReachLimit());
        }
        SummaryViewState summaryViewState3 = this.summaryViewState;
        if (summaryViewState3 != null) {
            String str2 = p0.PlaceComponentResult.KClassImpl$Data$declaredNonStaticMembers$2;
            Intrinsics.checkNotNullParameter(str2, "");
            summaryViewState3.NetworkUserEntityData$$ExternalSyntheticLambda0 = str2;
        }
        BuiltInFictitiousFunctionClassFactory(p0.PlaceComponentResult.KClassImpl$Data$declaredNonStaticMembers$2);
    }

    /* JADX WARN: Code restructure failed: missing block: B:106:0x0030, code lost:
    
        if (r0 == null) goto L107;
     */
    /* JADX WARN: Code restructure failed: missing block: B:113:0x003f, code lost:
    
        if (r4 == null) goto L114;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void BuiltInFictitiousFunctionClassFactory() {
        /*
            Method dump skipped, instructions count: 300
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.sendmoney.summary.view.SummaryView.BuiltInFictitiousFunctionClassFactory():void");
    }

    public static final boolean BuiltInFictitiousFunctionClassFactory(SummaryView summaryView, int i) {
        Intrinsics.checkNotNullParameter(summaryView, "");
        if (i == 6) {
            summaryView.getBinding().MyBillsEntityDataFactory.clearFocus();
            return false;
        }
        return false;
    }

    public final void checkEnableTransferInit(SummaryViewState summaryViewState) {
        Intrinsics.checkNotNullParameter(summaryViewState, "");
        String authRequestContext = summaryViewState.getAuthRequestContext();
        if (authRequestContext.length() > 0) {
            if (Intrinsics.areEqual(authRequestContext, "BALANCE")) {
                getSendMoneyCorePresenter().KClassImpl$Data$declaredNonStaticMembers$2();
            } else if (this.PlaceComponentResult != null) {
                BuiltInFictitiousFunctionClassFactory();
            } else {
                initSummaryBiztransfer(authRequestContext, summaryViewState.scheduleImpl);
            }
        }
        if (summaryViewState.PlaceComponentResult()) {
            CurrencyEditText currencyEditText = getBinding().getAuthRequestContext.MyBillsEntityDataFactory;
            Intrinsics.checkNotNullExpressionValue(currencyEditText, "");
            String authRequestContext2 = new CurrencyAmountModel(summaryViewState.scheduleImpl.PrepareContext, "Rp").getAuthRequestContext();
            Intrinsics.checkNotNullExpressionValue(authRequestContext2, "");
            BuiltInFictitiousFunctionClassFactory(currencyEditText, authRequestContext2);
            DanaTextBoxView danaTextBoxView = getBinding().MyBillsEntityDataFactory;
            Intrinsics.checkNotNullExpressionValue(danaTextBoxView, "");
            BuiltInFictitiousFunctionClassFactory(danaTextBoxView, summaryViewState.lookAheadTest);
            Context context = getContext();
            SummaryActivity summaryActivity = context instanceof SummaryActivity ? (SummaryActivity) context : null;
            if (summaryActivity != null) {
                summaryActivity.setCustomKeyboardVisibility(false);
            }
            Context context2 = getContext();
            SummaryActivity summaryActivity2 = context2 instanceof SummaryActivity ? (SummaryActivity) context2 : null;
            if (summaryActivity2 != null) {
                String str = summaryViewState.scheduleImpl.PrepareContext;
                Intrinsics.checkNotNullExpressionValue(str, "");
                summaryActivity2.setEnableButtonWithAmount(str);
            }
        }
    }

    public final void initTransfer(SummaryViewState summaryViewState, SendMoneyApiMigrationConfigModel sendMoneyApiMigrationConfigModel) {
        Intrinsics.checkNotNullParameter(summaryViewState, "");
        Intrinsics.checkNotNullParameter(sendMoneyApiMigrationConfigModel, "");
        String authRequestContext = summaryViewState.getAuthRequestContext();
        if (!Intrinsics.areEqual(authRequestContext, "BALANCE") || !sendMoneyApiMigrationConfigModel.getGetAuthRequestContext()) {
            if (this.PlaceComponentResult != null) {
                BuiltInFictitiousFunctionClassFactory();
                return;
            } else {
                initSummaryBiztransfer(authRequestContext, summaryViewState.scheduleImpl);
                return;
            }
        }
        ((SendMoneyFeatureTime) this.moveToNextValue.getValue()).BuiltInFictitiousFunctionClassFactory = DateTimeUtil.BuiltInFictitiousFunctionClassFactory();
        TransferInitResultModel transferInitResultModel = this.NetworkUserEntityData$$ExternalSyntheticLambda1;
        if (transferInitResultModel != null) {
            if (transferInitResultModel == null) {
                Intrinsics.throwUninitializedPropertyAccessException("");
                transferInitResultModel = null;
            }
            BuiltInFictitiousFunctionClassFactory(transferInitResultModel);
            return;
        }
        String str = summaryViewState.scheduleImpl.NetworkUserEntityData$$ExternalSyntheticLambda6;
        if (Intrinsics.areEqual(str, "phonenumber")) {
            SendMoneyCoreContract.Presenter sendMoneyCorePresenter = getSendMoneyCorePresenter();
            String KClassImpl$Data$declaredNonStaticMembers$2 = summaryViewState.scheduleImpl.KClassImpl$Data$declaredNonStaticMembers$2();
            Intrinsics.checkNotNullExpressionValue(KClassImpl$Data$declaredNonStaticMembers$2, "");
            String string = getContext().getString(R.string.SchedulerPoolFactory);
            Intrinsics.checkNotNullExpressionValue(string, "");
            sendMoneyCorePresenter.KClassImpl$Data$declaredNonStaticMembers$2(KClassImpl$Data$declaredNonStaticMembers$2, "", TrackerDataKey.Source.SEND_MONEY_SUMMARY_OPEN, string);
        } else if (Intrinsics.areEqual(str, "userid")) {
            SendMoneyCoreContract.Presenter sendMoneyCorePresenter2 = getSendMoneyCorePresenter();
            String KClassImpl$Data$declaredNonStaticMembers$22 = summaryViewState.scheduleImpl.KClassImpl$Data$declaredNonStaticMembers$2();
            Intrinsics.checkNotNullExpressionValue(KClassImpl$Data$declaredNonStaticMembers$22, "");
            String string2 = getContext().getString(R.string.SchedulerPoolFactory);
            Intrinsics.checkNotNullExpressionValue(string2, "");
            sendMoneyCorePresenter2.KClassImpl$Data$declaredNonStaticMembers$2("", KClassImpl$Data$declaredNonStaticMembers$22, TrackerDataKey.Source.SEND_MONEY_SUMMARY_OPEN, string2);
        }
    }

    public final void setSummaryViewTransferInitResultModel(TransferInitResultModel transferInitResultModel) {
        Intrinsics.checkNotNullParameter(transferInitResultModel, "");
        this.NetworkUserEntityData$$ExternalSyntheticLambda1 = transferInitResultModel;
    }

    public final void setSummaryViewTransferInit(TransferInit transferInit) {
        Intrinsics.checkNotNullParameter(transferInit, "");
        this.PlaceComponentResult = transferInit;
    }

    private final void BuiltInFictitiousFunctionClassFactory(SummaryViewState summaryViewState) {
        AppCompatImageView appCompatImageView = getBinding().KClassImpl$Data$declaredNonStaticMembers$2.KClassImpl$Data$declaredNonStaticMembers$2;
        Context context = getContext();
        if (!(context instanceof Activity) || !((Activity) context).isDestroyed()) {
            ImageAttacherFactory imageAttacherFactory = new ImageAttacherFactory();
            Context context2 = getContext();
            AppCompatImageView appCompatImageView2 = appCompatImageView;
            String BuiltInFictitiousFunctionClassFactory = summaryViewState.scheduleImpl.BuiltInFictitiousFunctionClassFactory();
            String str = BuiltInFictitiousFunctionClassFactory == null ? "" : BuiltInFictitiousFunctionClassFactory;
            int KClassImpl$Data$declaredNonStaticMembers$2 = summaryViewState.KClassImpl$Data$declaredNonStaticMembers$2();
            BaseImageAttacher.AdditionalData additionalData = new BaseImageAttacher.AdditionalData();
            additionalData.KClassImpl$Data$declaredNonStaticMembers$2 = ImageResize.getAuthRequestContext();
            additionalData.PlaceComponentResult = summaryViewState.KClassImpl$Data$declaredNonStaticMembers$2();
            imageAttacherFactory.PlaceComponentResult(context2, appCompatImageView2, str, KClassImpl$Data$declaredNonStaticMembers$2, additionalData);
        }
        AppCompatImageView appCompatImageView3 = getBinding().KClassImpl$Data$declaredNonStaticMembers$2.BuiltInFictitiousFunctionClassFactory;
        Intrinsics.checkNotNullExpressionValue(appCompatImageView3, "");
        appCompatImageView3.setVisibility(summaryViewState.NetworkUserEntityData$$ExternalSyntheticLambda0() ? 0 : 8);
    }

    private final void BuiltInFictitiousFunctionClassFactory(AppCompatEditText appCompatEditText, String str) {
        appCompatEditText.setFocusable(false);
        appCompatEditText.setClickable(false);
        appCompatEditText.setInputType(0);
        appCompatEditText.setText(str);
        SafeClickListenerExtensionKt.MyBillsEntityDataFactory(appCompatEditText, new Function1<View, Unit>() { // from class: id.dana.sendmoney.summary.view.SummaryView$disableEditText$1
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
                Intrinsics.checkNotNullParameter(view, "");
                SummaryView.this.BuiltInFictitiousFunctionClassFactory(view);
            }
        });
    }

    public final void BuiltInFictitiousFunctionClassFactory(View p0) {
        Context context = getContext();
        if (context != null) {
            CustomToast.BuiltInFictitiousFunctionClassFactory((SummaryActivity) context, 0, R.drawable.bg_rounded_8dp_yellow50, MyBillsEntityDataFactory(p0), 24, true, null);
            return;
        }
        throw new NullPointerException("null cannot be cast to non-null type id.dana.sendmoney.summary.SummaryActivity");
    }

    private final String MyBillsEntityDataFactory(View p0) {
        String string;
        int id2 = p0.getId();
        if (id2 == R.id.f3562res_0x7f0a02e2_basesocialfeedcontract_presenter) {
            string = getResources().getString(R.string.amount_not_editable);
            Intrinsics.checkNotNullExpressionValue(string, "");
        } else if (id2 != R.id.f3749res_0x7f0a0684_r8_lambda_7v3kt_ajfljz89nrm_iclzm3mwc) {
            return "";
        } else {
            string = getResources().getString(R.string.remarks_not_editable);
            Intrinsics.checkNotNullExpressionValue(string, "");
        }
        return string;
    }

    public static /* synthetic */ void showAmountWarningMessage$default(SummaryView summaryView, String str, String str2, int i, int i2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            str = "";
        }
        if ((i3 & 2) != 0) {
            str2 = "";
        }
        if ((i3 & 4) != 0) {
            i = 0;
        }
        if ((i3 & 8) != 0) {
            i2 = 0;
        }
        summaryView.showAmountWarningMessage(str, str2, i, i2);
    }

    public final void showAmountWarningMessage(String amount, String message, int drawableRes, int r10) {
        Intrinsics.checkNotNullParameter(amount, "");
        Intrinsics.checkNotNullParameter(message, "");
        if (!TextUtils.isEmpty(amount)) {
            String BuiltInFictitiousFunctionClassFactory = NumberFormatterUtil.BuiltInFictitiousFunctionClassFactory(LocaleUtil.getAuthRequestContext(), new Amount(amount).getAuthRequestContext, "Rp");
            AppCompatTextView appCompatTextView = getBinding().getAuthRequestContext.KClassImpl$Data$declaredNonStaticMembers$2;
            ViewUtil.PlaceComponentResult(ContextCompat.BuiltInFictitiousFunctionClassFactory(appCompatTextView.getContext(), r10), appCompatTextView);
            getBinding().getAuthRequestContext.KClassImpl$Data$declaredNonStaticMembers$2.setCompoundDrawablesWithIntrinsicBounds(0, 0, drawableRes, 0);
            StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
            String format = String.format(message, Arrays.copyOf(new Object[]{BuiltInFictitiousFunctionClassFactory}, 1));
            Intrinsics.checkNotNullExpressionValue(format, "");
            appCompatTextView.setText(format);
            Intrinsics.checkNotNullExpressionValue(appCompatTextView, "");
            appCompatTextView.setVisibility(0);
            return;
        }
        AppCompatTextView appCompatTextView2 = getBinding().getAuthRequestContext.KClassImpl$Data$declaredNonStaticMembers$2;
        Intrinsics.checkNotNullExpressionValue(appCompatTextView2, "");
        appCompatTextView2.setVisibility(4);
        TextView textView = getBinding().getAuthRequestContext.scheduleImpl;
        Intrinsics.checkNotNullExpressionValue(textView, "");
        textView.setVisibility(4);
    }

    public final void showAmountInfoMessage(String message) {
        Intrinsics.checkNotNullParameter(message, "");
        AppCompatTextView appCompatTextView = getBinding().getAuthRequestContext.KClassImpl$Data$declaredNonStaticMembers$2;
        appCompatTextView.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.ic_warning_16, 0);
        appCompatTextView.setText(message);
        appCompatTextView.setTextColor(ContextCompat.BuiltInFictitiousFunctionClassFactory(appCompatTextView.getContext(), R.color.f26712131100373));
        Intrinsics.checkNotNullExpressionValue(appCompatTextView, "");
        appCompatTextView.setVisibility(0);
        TextView textView = getBinding().getAuthRequestContext.scheduleImpl;
        Intrinsics.checkNotNullExpressionValue(textView, "");
        textView.setVisibility(0);
    }

    public final void setSummaryListener(SummaryListener summaryListener) {
        Intrinsics.checkNotNullParameter(summaryListener, "");
        this.KClassImpl$Data$declaredNonStaticMembers$2 = summaryListener;
    }

    public final void setSummaryViewVersion(String version) {
        Intrinsics.checkNotNullParameter(version, "");
        this.NetworkUserEntityData$$ExternalSyntheticLambda2 = version;
    }

    public final void setSummaryViewSource(String source) {
        Intrinsics.checkNotNullParameter(source, "");
        this.scheduleImpl = source;
    }

    public final void setSummaryViewRecipientModel(RecipientModel recipientModel) {
        Intrinsics.checkNotNullParameter(recipientModel, "");
        this.getErrorConfigVersion = recipientModel;
    }

    public final void setSmartFrictionEnable(SmartFrictionConfig smartFrictionConfig) {
        Intrinsics.checkNotNullParameter(smartFrictionConfig, "");
        this.NetworkUserEntityData$$ExternalSyntheticLambda0 = smartFrictionConfig;
    }

    public final boolean getAuthRequestContext() {
        String str = this.NetworkUserEntityData$$ExternalSyntheticLambda2;
        if (str != null) {
            if (str == null) {
                Intrinsics.throwUninitializedPropertyAccessException("");
                str = null;
            }
            if (Intrinsics.areEqual(str, "3.0")) {
                return true;
            }
        }
        return false;
    }

    public final void KClassImpl$Data$declaredNonStaticMembers$2(SummaryViewState summaryViewState) {
        if (summaryViewState.getErrorConfigVersion() && !summaryViewState.NetworkUserEntityData$$ExternalSyntheticLambda0()) {
            this.BuiltInFictitiousFunctionClassFactory.add(TrackerKey.SmartFrictionProperties.NON_DANA_USER);
        }
        if (summaryViewState.getErrorConfigVersion() && BuiltInFictitiousFunctionClassFactory(summaryViewState.getPlaceComponentResult())) {
            this.BuiltInFictitiousFunctionClassFactory.add(TrackerKey.SmartFrictionProperties.NOT_IN_CONTACT_LIST);
        }
        if (summaryViewState.lookAheadTest() && getAuthRequestContext(summaryViewState.getPlaceComponentResult())) {
            this.BuiltInFictitiousFunctionClassFactory.add(TrackerKey.SmartFrictionProperties.NOT_IN_RECENT_BANK);
        }
    }

    private final void BuiltInFictitiousFunctionClassFactory(TransferUserInfoModel p0) {
        SummaryViewState summaryViewState = this.summaryViewState;
        if (summaryViewState != null) {
            if (p0.MyBillsEntityDataFactory()) {
                if (Intrinsics.areEqual(summaryViewState.scheduleImpl.SubSequence, "Manual Input")) {
                    String str = summaryViewState.scheduleImpl.getErrorConfigVersion;
                    Intrinsics.checkNotNullExpressionValue(str, "");
                    this.getAuthRequestContext = str;
                }
                RecipientModel recipientModel = summaryViewState.scheduleImpl;
                recipientModel.MyBillsEntityDataFactory = p0.FragmentBottomSheetPaymentSettingBinding;
                recipientModel.NetworkUserEntityData$$ExternalSyntheticLambda6 = "userid";
                String str2 = recipientModel.getErrorConfigVersion;
                Intrinsics.checkNotNullExpressionValue(str2, "");
                Intrinsics.checkNotNullParameter(str2, "");
                if (!NumberUtils.isValidIndoPhoneNumberPrefix(str2)) {
                    str2 = p0.GetContactSyncConfig;
                }
                recipientModel.getErrorConfigVersion = str2;
                recipientModel.PlaceComponentResult = p0.BuiltInFictitiousFunctionClassFactory;
                String PlaceComponentResult = recipientModel.PlaceComponentResult();
                Intrinsics.checkNotNullExpressionValue(PlaceComponentResult, "");
                recipientModel.scheduleImpl = p0.BuiltInFictitiousFunctionClassFactory(PlaceComponentResult, recipientModel.NetworkUserEntityData$$ExternalSyntheticLambda2());
            } else {
                RecipientModel recipientModel2 = summaryViewState.scheduleImpl;
                recipientModel2.NetworkUserEntityData$$ExternalSyntheticLambda6 = "phonenumber";
                recipientModel2.PlaceComponentResult = p0.BuiltInFictitiousFunctionClassFactory;
            }
            getPresenter().getAuthRequestContext(summaryViewState.scheduleImpl, summaryViewState.getAuthRequestContext());
            if (summaryViewState.scheduleImpl.scheduleImpl()) {
                KClassImpl$Data$declaredNonStaticMembers$2(p0.FragmentBottomSheetPaymentSettingBinding, summaryViewState.scheduleImpl.KClassImpl$Data$declaredNonStaticMembers$2(), p0.NetworkUserEntityData$$ExternalSyntheticLambda2, p0.GetContactSyncConfig, p0.BuiltInFictitiousFunctionClassFactory);
            }
        }
    }

    public final void KClassImpl$Data$declaredNonStaticMembers$2(String p0, String p1, String p2, String p3, String p4) {
        getPresenter().MyBillsEntityDataFactory(p0, p1);
        SummaryListener summaryListener = this.KClassImpl$Data$declaredNonStaticMembers$2;
        if (summaryListener != null) {
            summaryListener.MyBillsEntityDataFactory();
        }
        SummaryViewState summaryViewState = this.summaryViewState;
        if (summaryViewState != null) {
            String MyBillsEntityDataFactory = summaryViewState.MyBillsEntityDataFactory(getContext());
            String str = MyBillsEntityDataFactory;
            if ((str.length() == 0) || Intrinsics.areEqual(MyBillsEntityDataFactory, "-") || StringsKt.contains$default((CharSequence) str, (CharSequence) "*", false, 2, (Object) null)) {
                summaryViewState.scheduleImpl.getAuthRequestContext = p2;
                summaryViewState.scheduleImpl.scheduleImpl = p2;
                summaryViewState.scheduleImpl.NetworkUserEntityData$$ExternalSyntheticLambda5 = p2;
            }
            summaryViewState.scheduleImpl.getErrorConfigVersion = p3;
            summaryViewState.scheduleImpl.GetContactSyncConfig = true;
            String BuiltInFictitiousFunctionClassFactory = summaryViewState.scheduleImpl.BuiltInFictitiousFunctionClassFactory();
            if (BuiltInFictitiousFunctionClassFactory == null || BuiltInFictitiousFunctionClassFactory.length() == 0) {
                summaryViewState.scheduleImpl.PlaceComponentResult = p4;
            }
        }
    }

    private final void PlaceComponentResult(TransferInitResultModel p0) {
        TransferAmountConfig transferAmountConfig = new TransferAmountConfig();
        transferAmountConfig.MyBillsEntityDataFactory = new CurrencyAmountModel(p0.MyBillsEntityDataFactory.getCleanAmount(), p0.MyBillsEntityDataFactory.getCurrency());
        transferAmountConfig.PlaceComponentResult = new CurrencyAmountModel(p0.KClassImpl$Data$declaredNonStaticMembers$2.getCleanAmount(), p0.KClassImpl$Data$declaredNonStaticMembers$2.getCurrency());
        transferAmountConfig.NetworkUserEntityData$$ExternalSyntheticLambda0 = new CurrencyAmountModel(p0.BuiltInFictitiousFunctionClassFactory.getCleanAmount(), p0.BuiltInFictitiousFunctionClassFactory.getCurrency());
        transferAmountConfig.scheduleImpl = new CurrencyAmountModel(p0.PlaceComponentResult.NetworkUserEntityData$$ExternalSyntheticLambda8.getCleanAmount(), p0.PlaceComponentResult.NetworkUserEntityData$$ExternalSyntheticLambda8.getCurrency());
        getPresenter().PlaceComponentResult(transferAmountConfig);
    }

    private final void BuiltInFictitiousFunctionClassFactory(String p0) {
        if (Intrinsics.areEqual(p0, "Medium")) {
            LinearLayout linearLayout = getBinding().BuiltInFictitiousFunctionClassFactory;
            Intrinsics.checkNotNullExpressionValue(linearLayout, "");
            linearLayout.setVisibility(0);
            linearLayout.setBackground(ContextCompat.PlaceComponentResult(linearLayout.getContext(), (int) R.drawable.bg_rounded_8dp_red_10));
            getBinding().scheduleImpl.setTextColor(ContextCompat.BuiltInFictitiousFunctionClassFactory(getContext(), R.color.f24002131099997));
        } else if (Intrinsics.areEqual(p0, "High")) {
            LinearLayout linearLayout2 = getBinding().BuiltInFictitiousFunctionClassFactory;
            Intrinsics.checkNotNullExpressionValue(linearLayout2, "");
            linearLayout2.setVisibility(0);
            linearLayout2.setBackground(ContextCompat.PlaceComponentResult(linearLayout2.getContext(), (int) R.drawable.bg_rounded_8dp_blue_80));
            getBinding().scheduleImpl.setTextColor(ContextCompat.BuiltInFictitiousFunctionClassFactory(getContext(), R.color.f27072131100488));
        } else {
            LinearLayout linearLayout3 = getBinding().BuiltInFictitiousFunctionClassFactory;
            Intrinsics.checkNotNullExpressionValue(linearLayout3, "");
            linearLayout3.setVisibility(8);
        }
    }

    public static /* synthetic */ void $r8$lambda$49oSw9DynRzkhwBIIrcCVXvJh0s(DanaTextBoxView danaTextBoxView, View view, boolean z) {
        Intrinsics.checkNotNullParameter(danaTextBoxView, "");
        if (z) {
            Context context = danaTextBoxView.getContext();
            SummaryActivity summaryActivity = context instanceof SummaryActivity ? (SummaryActivity) context : null;
            if (summaryActivity != null) {
                summaryActivity.setCustomKeyboardVisibility(false);
            }
        }
    }

    public static /* synthetic */ void $r8$lambda$WxYxtP1mJgTl378Eekl5J1qS8M8(SummaryView summaryView, View view) {
        Intrinsics.checkNotNullParameter(summaryView, "");
        SummaryViewState summaryViewState = summaryView.summaryViewState;
        if (summaryViewState != null) {
            if (summaryViewState.PlaceComponentResult()) {
                CurrencyEditText currencyEditText = summaryView.getBinding().getAuthRequestContext.MyBillsEntityDataFactory;
                Intrinsics.checkNotNullExpressionValue(currencyEditText, "");
                summaryView.BuiltInFictitiousFunctionClassFactory(currencyEditText);
                Context context = summaryView.getContext();
                SummaryActivity summaryActivity = context instanceof SummaryActivity ? (SummaryActivity) context : null;
                if (summaryActivity != null) {
                    summaryActivity.setCustomKeyboardVisibility(false);
                    return;
                }
                return;
            }
            summaryView.getBinding().getAuthRequestContext.MyBillsEntityDataFactory.setFocusableInTouchMode(true);
            summaryView.getBinding().getAuthRequestContext.MyBillsEntityDataFactory.requestFocus();
        }
    }

    /* renamed from: $r8$lambda$pPq-q6rlLDXuf8tcLCD4YkKMRwM */
    public static /* synthetic */ void m2912$r8$lambda$pPqq6rlLDXuf8tcLCD4YkKMRwM(CurrencyEditText currencyEditText, View view, boolean z) {
        Intrinsics.checkNotNullParameter(currencyEditText, "");
        if (z) {
            Object systemService = currencyEditText.getContext().getSystemService("input_method");
            if (systemService == null) {
                throw new NullPointerException("null cannot be cast to non-null type android.view.inputmethod.InputMethodManager");
            }
            ((InputMethodManager) systemService).hideSoftInputFromWindow(currencyEditText.getWindowToken(), 0);
            Context context = currencyEditText.getContext();
            SummaryActivity summaryActivity = context instanceof SummaryActivity ? (SummaryActivity) context : null;
            if (summaryActivity != null) {
                summaryActivity.setCustomKeyboardVisibility(true);
            }
        }
    }

    public static final /* synthetic */ String access$getMaxErrorAmountToSend(SummaryView summaryView, String str) {
        PayMethodModel payMethodModel;
        CurrencyAmountModel currencyAmountModel;
        String cleanAll;
        Context context = summaryView.getContext();
        SummaryActivity summaryActivity = context instanceof SummaryActivity ? (SummaryActivity) context : null;
        if (summaryActivity == null || (payMethodModel = summaryActivity.getPayMethodModel()) == null || (currencyAmountModel = payMethodModel.GetContactSyncConfig) == null || (cleanAll = NumberUtils.getCleanAll(currencyAmountModel.MyBillsEntityDataFactory)) == null) {
            return str;
        }
        boolean z = false;
        int safeInt = NumberExtKt.toSafeInt(cleanAll, 0);
        if (safeInt > 0 && safeInt < NumberExtKt.toSafeInt(NumberUtils.getCleanAll(str), 0)) {
            z = true;
        }
        String str2 = z ? cleanAll : null;
        return str2 == null ? str : str2;
    }

    public static final /* synthetic */ SendMoneyFeatureTime access$getSendMoneyFeatureTime(SummaryView summaryView) {
        return (SendMoneyFeatureTime) summaryView.moveToNextValue.getValue();
    }

    public static final /* synthetic */ void access$renderFreeTransfer(SummaryView summaryView, SummaryViewState summaryViewState, boolean z) {
        RecipientRibbonView recipientRibbonView = summaryView.getBinding().getAuthRequestContext.getErrorConfigVersion;
        if (summaryViewState.lookAheadTest()) {
            StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
            String string = recipientRibbonView.getContext().getString(R.string.sendmoney_bank_promo_desc_v2);
            Intrinsics.checkNotNullExpressionValue(string, "");
            String format = String.format(string, Arrays.copyOf(new Object[]{String.valueOf(summaryViewState.scheduleImpl.A)}, 1));
            Intrinsics.checkNotNullExpressionValue(format, "");
            recipientRibbonView.setContent(format);
        }
        Intrinsics.checkNotNullExpressionValue(recipientRibbonView, "");
        recipientRibbonView.setVisibility(summaryViewState.lookAheadTest() && summaryViewState.scheduleImpl.A > 0 && !z ? 0 : 8);
    }

    public static final /* synthetic */ void access$setFreezeProperty(SummaryView summaryView, TransferInit transferInit) {
        SmartFrictionConfig smartFrictionConfig = summaryView.NetworkUserEntityData$$ExternalSyntheticLambda0;
        if (smartFrictionConfig == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            smartFrictionConfig = null;
        }
        if (smartFrictionConfig.getAccountFreeze() && transferInit.isAccountFrozen() && summaryView.NetworkUserEntityData$$ExternalSyntheticLambda0 != null) {
            summaryView.BuiltInFictitiousFunctionClassFactory.add(TrackerKey.SmartFrictionProperties.ACCOUNT_FREEZE);
        }
    }

    public final void getAuthRequestContext(SummaryViewState summaryViewState) {
        if (Intrinsics.areEqual(summaryViewState.scheduleImpl.readMicros, "contact") && BuiltInFictitiousFunctionClassFactory(summaryViewState.getPlaceComponentResult())) {
            PlaceComponentResult(summaryViewState);
        } else if (Intrinsics.areEqual(summaryViewState.scheduleImpl.readMicros, "bank") && getAuthRequestContext(summaryViewState.getPlaceComponentResult())) {
            PlaceComponentResult(summaryViewState);
        } else {
            MyBillsEntityDataFactory(summaryViewState);
        }
        BuiltInFictitiousFunctionClassFactory(summaryViewState);
    }

    public final void initSummaryBiztransfer(String r5, RecipientModel recipientModel) {
        Intrinsics.checkNotNullParameter(r5, "");
        ((SendMoneyFeatureTime) this.moveToNextValue.getValue()).BuiltInFictitiousFunctionClassFactory = DateTimeUtil.BuiltInFictitiousFunctionClassFactory();
        SendMoneyContract.Presenter presenter = getPresenter();
        String str = this.NetworkUserEntityData$$ExternalSyntheticLambda2;
        if (str == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            str = null;
        }
        presenter.PlaceComponentResult(r5, recipientModel, str, "default");
    }
}
