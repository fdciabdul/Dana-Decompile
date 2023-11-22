package id.dana.cardbinding.view;

import android.app.Activity;
import android.content.Context;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import androidx.appcompat.widget.AppCompatEditText;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.view.C0207ViewKt;
import androidx.view.LifecycleCoroutineScope;
import androidx.view.LifecycleOwner;
import androidx.view.LifecycleOwnerKt;
import com.ap.zoloz.hummer.biz.HummerConstants;
import id.dana.R;
import id.dana.analytics.tracker.TrackerKey;
import id.dana.cardbinding.activity.CardBindingCameraActivity;
import id.dana.cardbinding.model.BankCardInfoModel;
import id.dana.cardbinding.model.CashierPayParamModel;
import id.dana.cardbinding.model.SupportedCardValidationExtKt;
import id.dana.cardbinding.viewmodel.CardBindingViewModel;
import id.dana.cashier.CardAssetUtils;
import id.dana.cashier.adapter.AddNewCardAdapter;
import id.dana.cashier.adapter.OnInsertVerifyElementsListener;
import id.dana.cashier.addCard.factory.CashierAddCardVerifyElementsFactory;
import id.dana.cashier.addCard.model.QueryCardVerifyElementModel;
import id.dana.cashier.model.AssetCardModel;
import id.dana.cashier.model.AttributeModel;
import id.dana.cashier.model.CashierCheckoutModel;
import id.dana.cashier.model.CashierPayChannelModel;
import id.dana.cashier.model.CashierPayMethodModel;
import id.dana.cashier.model.QueryCardPolicyInfoModel;
import id.dana.cashier.model.SendBankOtpModel;
import id.dana.cashier.view.ExpirationDateInputView;
import id.dana.cashier.view.InputCardNumberView;
import id.dana.component.buttoncomponent.DanaButtonPrimaryView;
import id.dana.core.ui.BaseViewBindingRichView;
import id.dana.databinding.ViewBottomSheetCardBindingBinding;
import id.dana.databinding.ViewCardBindingBinding;
import id.dana.domain.payasset.model.Institution;
import id.dana.tracker.mixpanel.MixPanelTracker;
import id.dana.utils.KeyboardHelper;
import io.reactivex.Observable;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.BiFunction;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function4;
import io.reactivex.subjects.PublishSubject;
import io.reactivex.subjects.Subject;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmName;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.CharsKt;

@Metadata(d1 = {"\u0000\u008e\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u001a\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010!\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B'\b\u0016\u0012\u0006\u0010c\u001a\u00020b\u0012\n\b\u0002\u0010e\u001a\u0004\u0018\u00010d\u0012\b\b\u0002\u0010f\u001a\u00020[¢\u0006\u0004\bg\u0010hB+\b\u0016\u0012\u0006\u0010c\u001a\u00020b\u0012\b\u0010e\u001a\u0004\u0018\u00010d\u0012\u0006\u0010f\u001a\u00020[\u0012\u0006\u0010i\u001a\u00020[¢\u0006\u0004\bg\u0010jJ\u0017\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\u0006\u0010\u0007J\r\u0010\t\u001a\u00020\b¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\f\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u000bH\u0002¢\u0006\u0004\b\f\u0010\rJ\u001d\u0010\u0011\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u000b¢\u0006\u0004\b\u0011\u0010\u0012J\u000f\u0010\u0013\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0013\u0010\u0014J\u000f\u0010\u0015\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\u0015\u0010\u0016J\u000f\u0010\u0017\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\u0017\u0010\u0016J\r\u0010\u0018\u001a\u00020\u0005¢\u0006\u0004\b\u0018\u0010\u0016J\u000f\u0010\f\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\f\u0010\u0016J\u000f\u0010\u0019\u001a\u00020\u0005H\u0014¢\u0006\u0004\b\u0019\u0010\u0016J\u000f\u0010\u001b\u001a\u00020\u001aH\u0002¢\u0006\u0004\b\u001b\u0010\u001cJ\u000f\u0010\u0006\u001a\u00020\u001aH\u0002¢\u0006\u0004\b\u0006\u0010\u001cJ\u0017\u0010\u001f\u001a\u00020\u00052\b\u0010\u001e\u001a\u0004\u0018\u00010\u001d¢\u0006\u0004\b\u001f\u0010 J\u0017\u0010\u0015\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u000bH\u0002¢\u0006\u0004\b\u0015\u0010!J\u000f\u0010\"\u001a\u00020\u0005H\u0000¢\u0006\u0004\b\"\u0010\u0016R\u0018\u0010\f\u001a\u0004\u0018\u00010#8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\f\u0010$R\u0016\u0010\u0017\u001a\u00020\u000b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001b\u0010%R\u001c\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00030&8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0015\u0010'R\u0014\u0010\u0006\u001a\u00020(8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0006\u0010)R\u0016\u0010\u001b\u001a\u00020\u000b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0017\u0010%R\u0016\u0010+\u001a\u00020\u000b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b*\u0010%R\u0016\u0010-\u001a\u00020\u000b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b,\u0010%R\u0016\u0010,\u001a\u00020\u000b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b+\u0010%R\u0016\u0010.\u001a\u00020\u000b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b-\u0010%R\u0016\u0010*\u001a\u00020\u00038\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b.\u0010/R*\u00102\u001a\u00020\u00032\u0006\u00100\u001a\u00020\u00038\u0007@GX\u0086\u000e¢\u0006\u0012\n\u0004\b1\u0010/\u001a\u0004\b2\u00103\"\u0004\b4\u0010\u0007R\"\u00106\u001a\u00020\u00038\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b5\u0010/\u001a\u0004\b6\u00103\"\u0004\b7\u0010\u0007R\"\u00109\u001a\u00020\u00038\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b8\u0010/\u001a\u0004\b9\u00103\"\u0004\b:\u0010\u0007R\u001c\u0010;\u001a\b\u0012\u0004\u0012\u00020\u00030&8\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\b;\u0010'R\u001c\u00108\u001a\b\u0012\u0004\u0012\u00020\u00030&8\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\b<\u0010'R\"\u0010>\u001a\u00020\u00038\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b=\u0010/\u001a\u0004\b>\u00103\"\u0004\b?\u0010\u0007R\u001c\u00105\u001a\b\u0012\u0004\u0012\u00020\u00030&8\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\b@\u0010'R\u0016\u00101\u001a\u00020\u00038\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\bA\u0010/R\u001c\u0010<\u001a\b\u0012\u0004\u0012\u00020\u00030&8\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\bB\u0010'R$\u0010J\u001a\u0004\u0018\u00010C8\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\bD\u0010E\u001a\u0004\bF\u0010G\"\u0004\bH\u0010IR.\u0010Q\u001a\u0004\u0018\u00010\u000e2\b\u00100\u001a\u0004\u0018\u00010\u000e8\u0007@GX\u0087\u000e¢\u0006\u0012\n\u0004\bK\u0010L\u001a\u0004\bM\u0010N\"\u0004\bO\u0010PR$\u0010Y\u001a\u0004\u0018\u00010R8\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\bS\u0010T\u001a\u0004\bU\u0010V\"\u0004\bW\u0010XR\u001a\u0010D\u001a\b\u0012\u0004\u0012\u00020[0Z8\u0002X\u0083\u0006¢\u0006\u0006\n\u0004\b\\\u0010]R2\u0010=\u001a\u001e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u00030^j\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u0003`_8\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\b`\u0010a"}, d2 = {"Lid/dana/cardbinding/view/BottomSheetCardBindingView;", "Lid/dana/core/ui/BaseViewBindingRichView;", "Lid/dana/databinding/ViewBottomSheetCardBindingBinding;", "", "p0", "", "KClassImpl$Data$declaredNonStaticMembers$2", "(Z)V", "Lid/dana/cashier/view/InputCardNumberView;", "getCardNumberView", "()Lid/dana/cashier/view/InputCardNumberView;", "", "BuiltInFictitiousFunctionClassFactory", "(Ljava/lang/String;)Z", "Lid/dana/cashier/model/QueryCardPolicyInfoModel;", "queryCardResult", "cardNumber", "handleQueryCardResult", "(Lid/dana/cashier/model/QueryCardPolicyInfoModel;Ljava/lang/String;)V", "inflateViewBinding", "()Lid/dana/databinding/ViewBottomSheetCardBindingBinding;", "PlaceComponentResult", "()V", "MyBillsEntityDataFactory", "initViews", "onDetachedFromWindow", "Lio/reactivex/disposables/Disposable;", "getAuthRequestContext", "()Lio/reactivex/disposables/Disposable;", "Lid/dana/cardbinding/model/BankCardInfoModel;", "bankCardInfoModel", "setBottomSheetModel", "(Lid/dana/cardbinding/model/BankCardInfoModel;)V", "(Ljava/lang/String;)V", "setupKeyboardListener$app_productionRelease", "Lid/dana/cashier/adapter/AddNewCardAdapter;", "Lid/dana/cashier/adapter/AddNewCardAdapter;", "Ljava/lang/String;", "Lio/reactivex/subjects/Subject;", "Lio/reactivex/subjects/Subject;", "Lio/reactivex/disposables/CompositeDisposable;", "Lio/reactivex/disposables/CompositeDisposable;", "NetworkUserEntityData$$ExternalSyntheticLambda0", "moveToNextValue", "scheduleImpl", "lookAheadTest", "getErrorConfigVersion", "Z", "value", "NetworkUserEntityData$$ExternalSyntheticLambda1", "isCardBcaOneKlik", "()Z", "setCardBcaOneKlik", "DatabaseTableConfigUtil", "isCardNoFromOcr", "setCardNoFromOcr", "NetworkUserEntityData$$ExternalSyntheticLambda2", "isDirectDebit", "setDirectDebit", "GetContactSyncConfig", "initRecordTimeStamp", "PrepareContext", "isExpDateFromOcr", "setExpDateFromOcr", "NetworkUserEntityData$$ExternalSyntheticLambda7", "newProxyInstance", "isLayoutRequested", "Lid/dana/cashier/model/CashierPayMethodModel$CardPayMethod;", "NetworkUserEntityData$$ExternalSyntheticLambda8", "Lid/dana/cashier/model/CashierPayMethodModel$CardPayMethod;", "getPayMethod", "()Lid/dana/cashier/model/CashierPayMethodModel$CardPayMethod;", "setPayMethod", "(Lid/dana/cashier/model/CashierPayMethodModel$CardPayMethod;)V", "payMethod", "FragmentBottomSheetPaymentSettingBinding", "Lid/dana/cashier/model/QueryCardPolicyInfoModel;", "getQueryCardPolicyInfoModel", "()Lid/dana/cashier/model/QueryCardPolicyInfoModel;", "setQueryCardPolicyInfoModel", "(Lid/dana/cashier/model/QueryCardPolicyInfoModel;)V", "queryCardPolicyInfoModel", "Lid/dana/cashier/model/SendBankOtpModel;", "NetworkUserEntityData$$ExternalSyntheticLambda6", "Lid/dana/cashier/model/SendBankOtpModel;", "getSendBankOtpModel", "()Lid/dana/cashier/model/SendBankOtpModel;", "setSendBankOtpModel", "(Lid/dana/cashier/model/SendBankOtpModel;)V", "sendBankOtpModel", "", "", "NetworkUserEntityData$$ExternalSyntheticLambda5", "Ljava/util/List;", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "NetworkUserEntityData$$ExternalSyntheticLambda3", "Ljava/util/HashMap;", "Landroid/content/Context;", HummerConstants.CONTEXT, "Landroid/util/AttributeSet;", "attrs", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "defStyleRes", "(Landroid/content/Context;Landroid/util/AttributeSet;II)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes8.dex */
public final class BottomSheetCardBindingView extends BaseViewBindingRichView<ViewBottomSheetCardBindingBinding> {
    private AddNewCardAdapter BuiltInFictitiousFunctionClassFactory;

    /* renamed from: DatabaseTableConfigUtil  reason: from kotlin metadata */
    private boolean isCardNoFromOcr;

    /* renamed from: FragmentBottomSheetPaymentSettingBinding  reason: from kotlin metadata */
    private QueryCardPolicyInfoModel queryCardPolicyInfoModel;
    private Subject<Boolean> GetContactSyncConfig;
    private final CompositeDisposable KClassImpl$Data$declaredNonStaticMembers$2;

    /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
    private String getAuthRequestContext;

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda0  reason: from kotlin metadata */
    private String moveToNextValue;

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda1  reason: from kotlin metadata */
    private boolean isCardBcaOneKlik;

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda2  reason: from kotlin metadata */
    private boolean isDirectDebit;

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda3  reason: from kotlin metadata */
    private HashMap<String, Boolean> PrepareContext;

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda5  reason: from kotlin metadata */
    private List<Integer> NetworkUserEntityData$$ExternalSyntheticLambda8;

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda6  reason: from kotlin metadata */
    private SendBankOtpModel sendBankOtpModel;

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda7  reason: from kotlin metadata */
    private Subject<Boolean> DatabaseTableConfigUtil;

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda8  reason: from kotlin metadata */
    private CashierPayMethodModel.CardPayMethod payMethod;
    private Subject<Boolean> PlaceComponentResult;

    /* renamed from: PrepareContext  reason: from kotlin metadata */
    private boolean isExpDateFromOcr;
    public Map<Integer, View> _$_findViewCache;

    /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
    private String MyBillsEntityDataFactory;

    /* renamed from: getErrorConfigVersion  reason: from kotlin metadata */
    private boolean NetworkUserEntityData$$ExternalSyntheticLambda0;

    /* renamed from: initRecordTimeStamp  reason: from kotlin metadata */
    private Subject<Boolean> NetworkUserEntityData$$ExternalSyntheticLambda2;

    /* renamed from: isLayoutRequested  reason: from kotlin metadata */
    private Subject<Boolean> initRecordTimeStamp;

    /* renamed from: lookAheadTest  reason: from kotlin metadata */
    private String getErrorConfigVersion;

    /* renamed from: moveToNextValue  reason: from kotlin metadata */
    private String scheduleImpl;

    /* renamed from: newProxyInstance  reason: from kotlin metadata */
    private boolean NetworkUserEntityData$$ExternalSyntheticLambda1;

    /* renamed from: scheduleImpl  reason: from kotlin metadata */
    private String lookAheadTest;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public BottomSheetCardBindingView(Context context) {
        this(context, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(context, "");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public BottomSheetCardBindingView(Context context, AttributeSet attributeSet) {
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
    public BottomSheetCardBindingView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "");
        this._$_findViewCache = new LinkedHashMap();
        this.KClassImpl$Data$declaredNonStaticMembers$2 = new CompositeDisposable();
        PublishSubject PlaceComponentResult = PublishSubject.PlaceComponentResult();
        Intrinsics.checkNotNullExpressionValue(PlaceComponentResult, "");
        this.DatabaseTableConfigUtil = PlaceComponentResult;
        PublishSubject PlaceComponentResult2 = PublishSubject.PlaceComponentResult();
        Intrinsics.checkNotNullExpressionValue(PlaceComponentResult2, "");
        this.initRecordTimeStamp = PlaceComponentResult2;
        PublishSubject PlaceComponentResult3 = PublishSubject.PlaceComponentResult();
        Intrinsics.checkNotNullExpressionValue(PlaceComponentResult3, "");
        this.GetContactSyncConfig = PlaceComponentResult3;
        PublishSubject PlaceComponentResult4 = PublishSubject.PlaceComponentResult();
        Intrinsics.checkNotNullExpressionValue(PlaceComponentResult4, "");
        this.PlaceComponentResult = PlaceComponentResult4;
        PublishSubject PlaceComponentResult5 = PublishSubject.PlaceComponentResult();
        Intrinsics.checkNotNullExpressionValue(PlaceComponentResult5, "");
        this.NetworkUserEntityData$$ExternalSyntheticLambda2 = PlaceComponentResult5;
        this.PrepareContext = new HashMap<>();
        this.scheduleImpl = "";
        this.getErrorConfigVersion = "";
        this.getAuthRequestContext = "";
        this.lookAheadTest = "";
        this.MyBillsEntityDataFactory = "";
        this.moveToNextValue = "";
        this.NetworkUserEntityData$$ExternalSyntheticLambda8 = new ArrayList();
        MyBillsEntityDataFactory();
        initViews();
        BuiltInFictitiousFunctionClassFactory();
        PlaceComponentResult();
        getCardNumberView().setIconCardErrorHandlingListener(new Function1<String, Unit>() { // from class: id.dana.cardbinding.view.BottomSheetCardBindingView$setCardErrorHandlingListener$1
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
                Subject subject;
                Subject subject2;
                boolean z;
                Intrinsics.checkNotNullParameter(str, "");
                if (str.length() >= 6) {
                    subject = BottomSheetCardBindingView.this.PlaceComponentResult;
                    subject.onNext(Boolean.TRUE);
                } else {
                    BottomSheetCardBindingView.access$resetAllState(BottomSheetCardBindingView.this);
                    if (str.length() < 6) {
                        if (BottomSheetCardBindingView.access$getContentView(BottomSheetCardBindingView.this).KClassImpl$Data$declaredNonStaticMembers$2.getCurrentBankBackground().length() > 0) {
                            BottomSheetCardBindingView.access$getContentView(BottomSheetCardBindingView.this).KClassImpl$Data$declaredNonStaticMembers$2.setCardBankToDefault();
                        }
                    }
                }
                QueryCardPolicyInfoModel queryCardPolicyInfoModel = BottomSheetCardBindingView.this.getQueryCardPolicyInfoModel();
                InputCardNumberView cardNumberView = BottomSheetCardBindingView.this.getCardNumberView();
                Context context2 = BottomSheetCardBindingView.this.getContext();
                Intrinsics.checkNotNullExpressionValue(context2, "");
                subject2 = BottomSheetCardBindingView.this.PlaceComponentResult;
                z = BottomSheetCardBindingView.this.NetworkUserEntityData$$ExternalSyntheticLambda1;
                SupportedCardValidationExtKt.BuiltInFictitiousFunctionClassFactory(str, queryCardPolicyInfoModel, cardNumberView, context2, subject2, z);
            }
        });
        setupKeyboardListener$app_productionRelease();
        ((DisclaimerView) _$_findCachedViewById(R.id.GetPersonalizationOptions)).setCheckboxListener(new BottomSheetCardBindingView$initDisclaimerView$1(this));
    }

    public /* synthetic */ BottomSheetCardBindingView(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BottomSheetCardBindingView(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        Intrinsics.checkNotNullParameter(context, "");
        this._$_findViewCache = new LinkedHashMap();
        this.KClassImpl$Data$declaredNonStaticMembers$2 = new CompositeDisposable();
        PublishSubject PlaceComponentResult = PublishSubject.PlaceComponentResult();
        Intrinsics.checkNotNullExpressionValue(PlaceComponentResult, "");
        this.DatabaseTableConfigUtil = PlaceComponentResult;
        PublishSubject PlaceComponentResult2 = PublishSubject.PlaceComponentResult();
        Intrinsics.checkNotNullExpressionValue(PlaceComponentResult2, "");
        this.initRecordTimeStamp = PlaceComponentResult2;
        PublishSubject PlaceComponentResult3 = PublishSubject.PlaceComponentResult();
        Intrinsics.checkNotNullExpressionValue(PlaceComponentResult3, "");
        this.GetContactSyncConfig = PlaceComponentResult3;
        PublishSubject PlaceComponentResult4 = PublishSubject.PlaceComponentResult();
        Intrinsics.checkNotNullExpressionValue(PlaceComponentResult4, "");
        this.PlaceComponentResult = PlaceComponentResult4;
        PublishSubject PlaceComponentResult5 = PublishSubject.PlaceComponentResult();
        Intrinsics.checkNotNullExpressionValue(PlaceComponentResult5, "");
        this.NetworkUserEntityData$$ExternalSyntheticLambda2 = PlaceComponentResult5;
        this.PrepareContext = new HashMap<>();
        this.scheduleImpl = "";
        this.getErrorConfigVersion = "";
        this.getAuthRequestContext = "";
        this.lookAheadTest = "";
        this.MyBillsEntityDataFactory = "";
        this.moveToNextValue = "";
        this.NetworkUserEntityData$$ExternalSyntheticLambda8 = new ArrayList();
        MyBillsEntityDataFactory();
        initViews();
        BuiltInFictitiousFunctionClassFactory();
        PlaceComponentResult();
        getCardNumberView().setIconCardErrorHandlingListener(new Function1<String, Unit>() { // from class: id.dana.cardbinding.view.BottomSheetCardBindingView$setCardErrorHandlingListener$1
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
                Subject subject;
                Subject subject2;
                boolean z;
                Intrinsics.checkNotNullParameter(str, "");
                if (str.length() >= 6) {
                    subject = BottomSheetCardBindingView.this.PlaceComponentResult;
                    subject.onNext(Boolean.TRUE);
                } else {
                    BottomSheetCardBindingView.access$resetAllState(BottomSheetCardBindingView.this);
                    if (str.length() < 6) {
                        if (BottomSheetCardBindingView.access$getContentView(BottomSheetCardBindingView.this).KClassImpl$Data$declaredNonStaticMembers$2.getCurrentBankBackground().length() > 0) {
                            BottomSheetCardBindingView.access$getContentView(BottomSheetCardBindingView.this).KClassImpl$Data$declaredNonStaticMembers$2.setCardBankToDefault();
                        }
                    }
                }
                QueryCardPolicyInfoModel queryCardPolicyInfoModel = BottomSheetCardBindingView.this.getQueryCardPolicyInfoModel();
                InputCardNumberView cardNumberView = BottomSheetCardBindingView.this.getCardNumberView();
                Context context2 = BottomSheetCardBindingView.this.getContext();
                Intrinsics.checkNotNullExpressionValue(context2, "");
                subject2 = BottomSheetCardBindingView.this.PlaceComponentResult;
                z = BottomSheetCardBindingView.this.NetworkUserEntityData$$ExternalSyntheticLambda1;
                SupportedCardValidationExtKt.BuiltInFictitiousFunctionClassFactory(str, queryCardPolicyInfoModel, cardNumberView, context2, subject2, z);
            }
        });
        setupKeyboardListener$app_productionRelease();
        ((DisclaimerView) _$_findCachedViewById(R.id.GetPersonalizationOptions)).setCheckboxListener(new BottomSheetCardBindingView$initDisclaimerView$1(this));
    }

    @JvmName(name = "getSendBankOtpModel")
    public final SendBankOtpModel getSendBankOtpModel() {
        return this.sendBankOtpModel;
    }

    @JvmName(name = "setSendBankOtpModel")
    public final void setSendBankOtpModel(SendBankOtpModel sendBankOtpModel) {
        this.sendBankOtpModel = sendBankOtpModel;
    }

    @JvmName(name = "isDirectDebit")
    /* renamed from: isDirectDebit  reason: from getter */
    public final boolean getIsDirectDebit() {
        return this.isDirectDebit;
    }

    @JvmName(name = "setDirectDebit")
    public final void setDirectDebit(boolean z) {
        this.isDirectDebit = z;
    }

    @JvmName(name = "getPayMethod")
    public final CashierPayMethodModel.CardPayMethod getPayMethod() {
        return this.payMethod;
    }

    @JvmName(name = "setPayMethod")
    public final void setPayMethod(CashierPayMethodModel.CardPayMethod cardPayMethod) {
        this.payMethod = cardPayMethod;
    }

    @JvmName(name = "isCardNoFromOcr")
    /* renamed from: isCardNoFromOcr  reason: from getter */
    public final boolean getIsCardNoFromOcr() {
        return this.isCardNoFromOcr;
    }

    @JvmName(name = "setCardNoFromOcr")
    public final void setCardNoFromOcr(boolean z) {
        this.isCardNoFromOcr = z;
    }

    @JvmName(name = "isExpDateFromOcr")
    /* renamed from: isExpDateFromOcr  reason: from getter */
    public final boolean getIsExpDateFromOcr() {
        return this.isExpDateFromOcr;
    }

    @JvmName(name = "setExpDateFromOcr")
    public final void setExpDateFromOcr(boolean z) {
        this.isExpDateFromOcr = z;
    }

    @JvmName(name = "isCardBcaOneKlik")
    /* renamed from: isCardBcaOneKlik  reason: from getter */
    public final boolean getIsCardBcaOneKlik() {
        return this.isCardBcaOneKlik;
    }

    @JvmName(name = "setCardBcaOneKlik")
    public final void setCardBcaOneKlik(boolean z) {
        if (this.isCardBcaOneKlik != z) {
            this.NetworkUserEntityData$$ExternalSyntheticLambda0 = false;
        }
        this.isCardBcaOneKlik = z;
        ViewCardBindingBinding viewCardBindingBinding = getBinding().KClassImpl$Data$declaredNonStaticMembers$2;
        Intrinsics.checkNotNullExpressionValue(viewCardBindingBinding, "");
        RecyclerView recyclerView = viewCardBindingBinding.getAuthRequestContext;
        Intrinsics.checkNotNullExpressionValue(recyclerView, "");
        recyclerView.setVisibility(this.isCardBcaOneKlik ^ true ? 0 : 8);
        ViewCardBindingBinding viewCardBindingBinding2 = getBinding().KClassImpl$Data$declaredNonStaticMembers$2;
        Intrinsics.checkNotNullExpressionValue(viewCardBindingBinding2, "");
        ConstraintLayout constraintLayout = viewCardBindingBinding2.BuiltInFictitiousFunctionClassFactory.getAuthRequestContext;
        Intrinsics.checkNotNullExpressionValue(constraintLayout, "");
        constraintLayout.setVisibility(this.isCardBcaOneKlik ? 0 : 8);
    }

    @JvmName(name = "getQueryCardPolicyInfoModel")
    public final QueryCardPolicyInfoModel getQueryCardPolicyInfoModel() {
        return this.queryCardPolicyInfoModel;
    }

    @Override // id.dana.core.ui.BaseViewBindingRichView
    public final ViewBottomSheetCardBindingBinding inflateViewBinding() {
        ViewBottomSheetCardBindingBinding authRequestContext = ViewBottomSheetCardBindingBinding.getAuthRequestContext(LayoutInflater.from(getContext()));
        Intrinsics.checkNotNullExpressionValue(authRequestContext, "");
        return authRequestContext;
    }

    public final void initViews() {
        InputCardNumberView cardNumberView = getCardNumberView();
        String string = getContext().getString(R.string.card_binding_title);
        Intrinsics.checkNotNullExpressionValue(string, "");
        cardNumberView.setTitle(string);
        InputCardNumberView cardNumberView2 = getCardNumberView();
        String string2 = getContext().getString(R.string.card_binding_hint);
        Intrinsics.checkNotNullExpressionValue(string2, "");
        cardNumberView2.setCardHint(string2);
        ViewCardBindingBinding viewCardBindingBinding = getBinding().KClassImpl$Data$declaredNonStaticMembers$2;
        Intrinsics.checkNotNullExpressionValue(viewCardBindingBinding, "");
        CardView cardView = viewCardBindingBinding.KClassImpl$Data$declaredNonStaticMembers$2;
        QueryCardPolicyInfoModel queryCardPolicyInfoModel = this.queryCardPolicyInfoModel;
        cardView.setCardBankLogo(queryCardPolicyInfoModel != null ? queryCardPolicyInfoModel.moveToNextValue : null);
    }

    public final void setBottomSheetModel(BankCardInfoModel bankCardInfoModel) {
        getCardNumberView().setCardNumberOCR("");
        if (bankCardInfoModel != null) {
            getCardNumberView().setCardNumberOCR(bankCardInfoModel.PlaceComponentResult);
            if (bankCardInfoModel.getBuiltInFictitiousFunctionClassFactory()) {
                ExpirationDateInputView expirationDateInputView = (ExpirationDateInputView) _$_findCachedViewById(R.id.res_0x7f0a06b7_networkexpresspurchaseentitydata_orderquerybycondition_1);
                if (expirationDateInputView != null) {
                    expirationDateInputView.setCardDateOCR(bankCardInfoModel.KClassImpl$Data$declaredNonStaticMembers$2);
                }
                this.isExpDateFromOcr = true;
            }
            this.isCardNoFromOcr = true;
        }
    }

    private final void BuiltInFictitiousFunctionClassFactory() {
        Subject<Boolean> subject = this.DatabaseTableConfigUtil;
        Boolean bool = Boolean.FALSE;
        subject.onNext(bool);
        this.initRecordTimeStamp.onNext(bool);
        this.PlaceComponentResult.onNext(bool);
        this.GetContactSyncConfig.onNext(bool);
        this.NetworkUserEntityData$$ExternalSyntheticLambda2.onNext(bool);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void PlaceComponentResult(String p0) {
        if (p0.length() < 6 || this.NetworkUserEntityData$$ExternalSyntheticLambda0) {
            return;
        }
        this.KClassImpl$Data$declaredNonStaticMembers$2.MyBillsEntityDataFactory();
        if (this.isCardBcaOneKlik) {
            this.KClassImpl$Data$declaredNonStaticMembers$2.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$2());
        } else {
            this.KClassImpl$Data$declaredNonStaticMembers$2.getAuthRequestContext(getAuthRequestContext());
        }
        this.NetworkUserEntityData$$ExternalSyntheticLambda0 = true;
    }

    private final void MyBillsEntityDataFactory() {
        this.BuiltInFictitiousFunctionClassFactory = new AddNewCardAdapter(new OnInsertVerifyElementsListener() { // from class: id.dana.cardbinding.view.BottomSheetCardBindingView$initRecyclerView$1
            @Override // id.dana.cashier.adapter.OnInsertVerifyElementsListener
            public final void KClassImpl$Data$declaredNonStaticMembers$2(String p0, int p1) {
                Intrinsics.checkNotNullParameter(p0, "");
            }

            @Override // id.dana.cashier.adapter.OnInsertVerifyElementsListener
            public final void KClassImpl$Data$declaredNonStaticMembers$2(boolean p0) {
            }

            @Override // id.dana.cashier.adapter.OnInsertVerifyElementsListener
            public final void MyBillsEntityDataFactory(boolean p0) {
            }

            @Override // id.dana.cashier.adapter.OnInsertVerifyElementsListener
            public final void KClassImpl$Data$declaredNonStaticMembers$2(String p0, String p1) {
                Subject subject;
                HashMap hashMap;
                Intrinsics.checkNotNullParameter(p0, "");
                Intrinsics.checkNotNullParameter(p1, "");
                BottomSheetCardBindingView.this.getErrorConfigVersion = p1;
                BottomSheetCardBindingView.this.scheduleImpl = p0;
                subject = BottomSheetCardBindingView.this.initRecordTimeStamp;
                hashMap = BottomSheetCardBindingView.this.PrepareContext;
                subject.onNext(Boolean.valueOf(!hashMap.containsValue(Boolean.FALSE)));
            }

            @Override // id.dana.cashier.adapter.OnInsertVerifyElementsListener
            public final void MyBillsEntityDataFactory(String p0) {
                Intrinsics.checkNotNullParameter(p0, "");
                BottomSheetCardBindingView.this.getAuthRequestContext = p0;
            }

            @Override // id.dana.cashier.adapter.OnInsertVerifyElementsListener
            public final void PlaceComponentResult(String p0, int p1) {
                Intrinsics.checkNotNullParameter(p0, "");
                if (p1 != -1) {
                    BottomSheetCardBindingView.this.moveToNextValue = p0;
                }
            }

            @Override // id.dana.cashier.adapter.OnInsertVerifyElementsListener
            public final void MyBillsEntityDataFactory(String p0, int p1) {
                Intrinsics.checkNotNullParameter(p0, "");
                BottomSheetCardBindingView.this.MyBillsEntityDataFactory = p0;
            }

            @Override // id.dana.cashier.adapter.OnInsertVerifyElementsListener
            public final void BuiltInFictitiousFunctionClassFactory(String p0, int p1) {
                Intrinsics.checkNotNullParameter(p0, "");
                BottomSheetCardBindingView.this.lookAheadTest = p0;
            }

            @Override // id.dana.cashier.adapter.OnInsertVerifyElementsListener
            public final void lookAheadTest(boolean p0) {
                Subject subject;
                BottomSheetCardBindingView.this.PlaceComponentResult(BottomSheetCardBindingView.this.getCardNumberView().getCardNumberOCR());
                subject = BottomSheetCardBindingView.this.DatabaseTableConfigUtil;
                subject.onNext(Boolean.valueOf(p0));
            }

            @Override // id.dana.cashier.adapter.OnInsertVerifyElementsListener
            public final void BuiltInFictitiousFunctionClassFactory(boolean p0) {
                BottomSheetCardBindingView.access$setVerifyElementsValidation(BottomSheetCardBindingView.this, "cvv2", p0);
            }

            @Override // id.dana.cashier.adapter.OnInsertVerifyElementsListener
            public final void PlaceComponentResult(boolean p0) {
                BottomSheetCardBindingView.access$setVerifyElementsValidation(BottomSheetCardBindingView.this, "limitAmountDaily", p0);
            }

            @Override // id.dana.cashier.adapter.OnInsertVerifyElementsListener
            public final void getAuthRequestContext(boolean p0) {
                BottomSheetCardBindingView.access$setVerifyElementsValidation(BottomSheetCardBindingView.this, "bankPhoneNo", p0);
            }

            @Override // id.dana.cashier.adapter.OnInsertVerifyElementsListener
            public final void moveToNextValue(boolean p0) {
                BottomSheetCardBindingView.access$setVerifyElementsValidation(BottomSheetCardBindingView.this, "ektp", p0);
            }

            @Override // id.dana.cashier.adapter.OnInsertVerifyElementsListener
            public final void BuiltInFictitiousFunctionClassFactory(String p0) {
                Intrinsics.checkNotNullParameter(p0, "");
                BottomSheetCardBindingView.access$getContentView(BottomSheetCardBindingView.this).KClassImpl$Data$declaredNonStaticMembers$2.setTextViewCardDate(p0);
            }
        });
        ViewCardBindingBinding viewCardBindingBinding = getBinding().KClassImpl$Data$declaredNonStaticMembers$2;
        Intrinsics.checkNotNullExpressionValue(viewCardBindingBinding, "");
        RecyclerView recyclerView = viewCardBindingBinding.getAuthRequestContext;
        recyclerView.setLayoutManager(new LinearLayoutManager(recyclerView.getContext(), 1, false));
        recyclerView.setAdapter(this.BuiltInFictitiousFunctionClassFactory);
    }

    public final void setupKeyboardListener$app_productionRelease() {
        Window window;
        Context context = getContext();
        View view = null;
        Activity activity = context instanceof Activity ? (Activity) context : null;
        if (activity != null && (window = activity.getWindow()) != null) {
            view = window.getDecorView();
        }
        KeyboardHelper.PlaceComponentResult(view, new KeyboardHelper.KeyboardVisibilityListener() { // from class: id.dana.cardbinding.view.BottomSheetCardBindingView$setupKeyboardListener$1
            @Override // id.dana.utils.KeyboardHelper.KeyboardVisibilityListener
            public final void KClassImpl$Data$declaredNonStaticMembers$2() {
                ((DisclaimerView) BottomSheetCardBindingView.this._$_findCachedViewById(R.id.GetPersonalizationOptions)).setVisibility(8);
            }

            @Override // id.dana.utils.KeyboardHelper.KeyboardVisibilityListener
            public final void MyBillsEntityDataFactory() {
                ((DisclaimerView) BottomSheetCardBindingView.this._$_findCachedViewById(R.id.GetPersonalizationOptions)).setVisibility(0);
            }
        });
    }

    private final void KClassImpl$Data$declaredNonStaticMembers$2(final boolean p0) {
        DanaButtonPrimaryView danaButtonPrimaryView = getBinding().PlaceComponentResult;
        danaButtonPrimaryView.setEnabled(p0);
        danaButtonPrimaryView.setClickable(p0);
        Context context = danaButtonPrimaryView.getContext();
        danaButtonPrimaryView.setDanaButtonView(p0 ? 1 : 0, context != null ? context.getString(R.string.card_binding_add_new_card_button) : null, "", null);
        danaButtonPrimaryView.setContentDescription(danaButtonPrimaryView.getContext().getString(R.string.btn_continue_cashier));
        getBinding().PlaceComponentResult.setOnClickListener(new View.OnClickListener() { // from class: id.dana.cardbinding.view.BottomSheetCardBindingView$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                BottomSheetCardBindingView.m482$r8$lambda$JCJytmBRBHXh2Igisqp0b7rXk0(p0, this, view);
            }
        });
    }

    private final Disposable KClassImpl$Data$declaredNonStaticMembers$2() {
        Disposable subscribe = Observable.combineLatest(this.PlaceComponentResult, this.NetworkUserEntityData$$ExternalSyntheticLambda2, new BiFunction() { // from class: id.dana.cardbinding.view.BottomSheetCardBindingView$$ExternalSyntheticLambda1
            @Override // io.reactivex.functions.BiFunction
            public final Object apply(Object obj, Object obj2) {
                Boolean valueOf;
                ((Boolean) obj).booleanValue();
                ((Boolean) obj2).booleanValue();
                valueOf = Boolean.valueOf(r0 && r1);
                return valueOf;
            }
        }).subscribe(new Consumer() { // from class: id.dana.cardbinding.view.BottomSheetCardBindingView$$ExternalSyntheticLambda2
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                BottomSheetCardBindingView.$r8$lambda$BSyxFrhN59Rzz6VyOXRdXl29mJk(BottomSheetCardBindingView.this, ((Boolean) obj).booleanValue());
            }
        });
        Intrinsics.checkNotNullExpressionValue(subscribe, "");
        return subscribe;
    }

    private final Disposable getAuthRequestContext() {
        Disposable subscribe = Observable.combineLatest(this.initRecordTimeStamp, this.DatabaseTableConfigUtil, this.PlaceComponentResult, this.GetContactSyncConfig, new Function4() { // from class: id.dana.cardbinding.view.BottomSheetCardBindingView$$ExternalSyntheticLambda3
            @Override // io.reactivex.functions.Function4
            public final Object apply(Object obj, Object obj2, Object obj3, Object obj4) {
                Boolean valueOf;
                ((Boolean) obj).booleanValue();
                ((Boolean) obj2).booleanValue();
                ((Boolean) obj3).booleanValue();
                ((Boolean) obj4).booleanValue();
                valueOf = Boolean.valueOf(r2 && r1 && r0 && r3);
                return valueOf;
            }
        }).subscribe(new Consumer() { // from class: id.dana.cardbinding.view.BottomSheetCardBindingView$$ExternalSyntheticLambda4
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                BottomSheetCardBindingView.$r8$lambda$dcKx_XsQwAwOWGOeV9SSwbhpP4g(BottomSheetCardBindingView.this, ((Boolean) obj).booleanValue());
            }
        });
        Intrinsics.checkNotNullExpressionValue(subscribe, "");
        return subscribe;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.KClassImpl$Data$declaredNonStaticMembers$2.dispose();
        this.isCardNoFromOcr = false;
        this.isExpDateFromOcr = false;
    }

    public static /* synthetic */ void $r8$lambda$BSyxFrhN59Rzz6VyOXRdXl29mJk(BottomSheetCardBindingView bottomSheetCardBindingView, boolean z) {
        Intrinsics.checkNotNullParameter(bottomSheetCardBindingView, "");
        bottomSheetCardBindingView.KClassImpl$Data$declaredNonStaticMembers$2(z);
    }

    /* renamed from: $r8$lambda$JCJytmBRBHXh2Igisqp0b7rXk-0  reason: not valid java name */
    public static /* synthetic */ void m482$r8$lambda$JCJytmBRBHXh2Igisqp0b7rXk0(boolean z, BottomSheetCardBindingView bottomSheetCardBindingView, View view) {
        CardBindingViewModel cardBindingVm;
        CashierCheckoutModel cashierMainResult;
        CashierPayMethodModel.NewCardData newCardData;
        CashierPayMethodModel.NewCardData newCardData2;
        Intrinsics.checkNotNullParameter(bottomSheetCardBindingView, "");
        if (z) {
            String str = bottomSheetCardBindingView.scheduleImpl;
            StringBuilder sb = new StringBuilder();
            sb.append("20");
            sb.append(bottomSheetCardBindingView.getErrorConfigVersion);
            String obj = sb.toString();
            String cleanCardNumber = bottomSheetCardBindingView.getCardNumberView().getCleanCardNumber();
            String str2 = bottomSheetCardBindingView.getAuthRequestContext;
            QueryCardPolicyInfoModel queryCardPolicyInfoModel = bottomSheetCardBindingView.queryCardPolicyInfoModel;
            String str3 = queryCardPolicyInfoModel != null ? queryCardPolicyInfoModel.MyBillsEntityDataFactory : null;
            QueryCardPolicyInfoModel queryCardPolicyInfoModel2 = bottomSheetCardBindingView.queryCardPolicyInfoModel;
            CashierPayMethodModel.NewCardData newCardData3 = new CashierPayMethodModel.NewCardData(cleanCardNumber, str, obj, str2, str3, queryCardPolicyInfoModel2 != null ? queryCardPolicyInfoModel2.getAuthRequestContext : null, true, null, null, 384, null);
            QueryCardPolicyInfoModel queryCardPolicyInfoModel3 = bottomSheetCardBindingView.queryCardPolicyInfoModel;
            String str4 = queryCardPolicyInfoModel3 != null ? queryCardPolicyInfoModel3.PlaceComponentResult : null;
            QueryCardPolicyInfoModel queryCardPolicyInfoModel4 = bottomSheetCardBindingView.queryCardPolicyInfoModel;
            String str5 = queryCardPolicyInfoModel4 != null ? queryCardPolicyInfoModel4.BuiltInFictitiousFunctionClassFactory : null;
            QueryCardPolicyInfoModel queryCardPolicyInfoModel5 = bottomSheetCardBindingView.queryCardPolicyInfoModel;
            String str6 = queryCardPolicyInfoModel5 != null ? queryCardPolicyInfoModel5.getAuthRequestContext : null;
            QueryCardPolicyInfoModel queryCardPolicyInfoModel6 = bottomSheetCardBindingView.queryCardPolicyInfoModel;
            Boolean bool = queryCardPolicyInfoModel6 != null ? queryCardPolicyInfoModel6.scheduleImpl : null;
            QueryCardPolicyInfoModel queryCardPolicyInfoModel7 = bottomSheetCardBindingView.queryCardPolicyInfoModel;
            String str7 = queryCardPolicyInfoModel7 != null ? queryCardPolicyInfoModel7.moveToNextValue : null;
            QueryCardPolicyInfoModel queryCardPolicyInfoModel8 = bottomSheetCardBindingView.queryCardPolicyInfoModel;
            String str8 = queryCardPolicyInfoModel8 != null ? queryCardPolicyInfoModel8.getErrorConfigVersion : null;
            QueryCardPolicyInfoModel queryCardPolicyInfoModel9 = bottomSheetCardBindingView.queryCardPolicyInfoModel;
            String str9 = queryCardPolicyInfoModel9 != null ? queryCardPolicyInfoModel9.NetworkUserEntityData$$ExternalSyntheticLambda1 : null;
            QueryCardPolicyInfoModel queryCardPolicyInfoModel10 = bottomSheetCardBindingView.queryCardPolicyInfoModel;
            String str10 = queryCardPolicyInfoModel10 != null ? queryCardPolicyInfoModel10.initRecordTimeStamp : null;
            QueryCardPolicyInfoModel queryCardPolicyInfoModel11 = bottomSheetCardBindingView.queryCardPolicyInfoModel;
            List<String> list = queryCardPolicyInfoModel11 != null ? queryCardPolicyInfoModel11.GetContactSyncConfig : null;
            QueryCardPolicyInfoModel queryCardPolicyInfoModel12 = bottomSheetCardBindingView.queryCardPolicyInfoModel;
            CashierPayMethodModel.CardPayMethod cardPayMethod = new CashierPayMethodModel.CardPayMethod(new AssetCardModel(null, null, null, null, str4, null, null, str5, null, null, bool, null, null, newCardData3.getAuthRequestContext, newCardData3.KClassImpl$Data$declaredNonStaticMembers$2, str7, str8, null, null, null, null, null, str10, str9, null, null, null, str6, list, null, queryCardPolicyInfoModel12 != null ? queryCardPolicyInfoModel12.NetworkUserEntityData$$ExternalSyntheticLambda0 : null, null, null, null, null, null, null, null, -1489101969, 63, null), null, null, 6, null);
            cardPayMethod.getAuthRequestContext = newCardData3;
            bottomSheetCardBindingView.payMethod = cardPayMethod;
            CashierPayMethodModel.NewCardData newCardData4 = cardPayMethod.getAuthRequestContext;
            String str11 = newCardData4 != null ? newCardData4.PlaceComponentResult : null;
            CashierPayMethodModel.CardPayMethod cardPayMethod2 = bottomSheetCardBindingView.payMethod;
            String str12 = (cardPayMethod2 == null || (newCardData2 = cardPayMethod2.getAuthRequestContext) == null) ? null : newCardData2.getAuthRequestContext;
            String str13 = str12 == null ? "" : str12;
            CashierPayMethodModel.CardPayMethod cardPayMethod3 = bottomSheetCardBindingView.payMethod;
            String str14 = (cardPayMethod3 == null || (newCardData = cardPayMethod3.getAuthRequestContext) == null) ? null : newCardData.KClassImpl$Data$declaredNonStaticMembers$2;
            String str15 = str14 == null ? "" : str14;
            QueryCardPolicyInfoModel queryCardPolicyInfoModel13 = bottomSheetCardBindingView.queryCardPolicyInfoModel;
            String str16 = queryCardPolicyInfoModel13 != null ? queryCardPolicyInfoModel13.getAuthRequestContext : null;
            QueryCardPolicyInfoModel queryCardPolicyInfoModel14 = bottomSheetCardBindingView.queryCardPolicyInfoModel;
            String str17 = queryCardPolicyInfoModel14 != null ? queryCardPolicyInfoModel14.moveToNextValue : null;
            String str18 = bottomSheetCardBindingView.MyBillsEntityDataFactory;
            Context context = bottomSheetCardBindingView.getContext();
            CardBindingCameraActivity cardBindingCameraActivity = context instanceof CardBindingCameraActivity ? (CardBindingCameraActivity) context : null;
            bottomSheetCardBindingView.sendBankOtpModel = new SendBankOtpModel(null, (cardBindingCameraActivity == null || (cashierMainResult = cardBindingCameraActivity.getCashierMainResult()) == null) ? null : cashierMainResult.PlaceComponentResult, null, str18, bottomSheetCardBindingView.lookAheadTest, str11, str16, str17, str13, str15, bottomSheetCardBindingView.moveToNextValue, null, null, null, 14336, null);
            if (!bottomSheetCardBindingView.isCardBcaOneKlik) {
                QueryCardPolicyInfoModel queryCardPolicyInfoModel15 = bottomSheetCardBindingView.queryCardPolicyInfoModel;
                if (queryCardPolicyInfoModel15 != null && queryCardPolicyInfoModel15.BuiltInFictitiousFunctionClassFactory()) {
                    if (bottomSheetCardBindingView.sendBankOtpModel != null) {
                        Context context2 = bottomSheetCardBindingView.getContext();
                        CardBindingCameraActivity cardBindingCameraActivity2 = context2 instanceof CardBindingCameraActivity ? (CardBindingCameraActivity) context2 : null;
                        if (cardBindingCameraActivity2 != null) {
                            cardBindingCameraActivity2.sendBankOtp();
                        }
                    }
                } else {
                    CashierPayMethodModel.CardPayMethod cardPayMethod4 = bottomSheetCardBindingView.payMethod;
                    if (cardPayMethod4 != null) {
                        Context context3 = bottomSheetCardBindingView.getContext();
                        CardBindingCameraActivity cardBindingCameraActivity3 = context3 instanceof CardBindingCameraActivity ? (CardBindingCameraActivity) context3 : null;
                        if (cardBindingCameraActivity3 != null) {
                            CashierCheckoutModel cashierMainResult2 = cardBindingCameraActivity3.getCashierMainResult();
                            String str19 = cashierMainResult2 != null ? cashierMainResult2.PlaceComponentResult : null;
                            cardBindingCameraActivity3.getCardBindingVm().MyBillsEntityDataFactory(new CashierPayParamModel(str19 == null ? "" : str19, null, null, false, null, null, cardPayMethod4, false, 190, null));
                        }
                    }
                }
            } else {
                Context context4 = bottomSheetCardBindingView.getContext();
                CardBindingCameraActivity cardBindingCameraActivity4 = context4 instanceof CardBindingCameraActivity ? (CardBindingCameraActivity) context4 : null;
                if (cardBindingCameraActivity4 != null && (cardBindingVm = cardBindingCameraActivity4.getCardBindingVm()) != null) {
                    Context context5 = bottomSheetCardBindingView.getContext();
                    Intrinsics.checkNotNullExpressionValue(context5, "");
                    cardBindingVm.KClassImpl$Data$declaredNonStaticMembers$2(context5);
                }
            }
            MixPanelTracker.getAuthRequestContext(TrackerKey.Event.ADD_CARD_RESULT);
            Context context6 = bottomSheetCardBindingView.getContext();
            CardBindingCameraActivity cardBindingCameraActivity5 = context6 instanceof CardBindingCameraActivity ? (CardBindingCameraActivity) context6 : null;
            if (cardBindingCameraActivity5 != null) {
                cardBindingCameraActivity5.trackAddCardExecution();
            }
        }
    }

    public static /* synthetic */ void $r8$lambda$dcKx_XsQwAwOWGOeV9SSwbhpP4g(BottomSheetCardBindingView bottomSheetCardBindingView, boolean z) {
        Intrinsics.checkNotNullParameter(bottomSheetCardBindingView, "");
        bottomSheetCardBindingView.KClassImpl$Data$declaredNonStaticMembers$2(z);
    }

    public static final /* synthetic */ ViewCardBindingBinding access$getContentView(BottomSheetCardBindingView bottomSheetCardBindingView) {
        ViewCardBindingBinding viewCardBindingBinding = bottomSheetCardBindingView.getBinding().KClassImpl$Data$declaredNonStaticMembers$2;
        Intrinsics.checkNotNullExpressionValue(viewCardBindingBinding, "");
        return viewCardBindingBinding;
    }

    public static final /* synthetic */ void access$getQueryCardPolicy(BottomSheetCardBindingView bottomSheetCardBindingView, String str) {
        Context context = bottomSheetCardBindingView.getContext();
        CardBindingCameraActivity cardBindingCameraActivity = context instanceof CardBindingCameraActivity ? (CardBindingCameraActivity) context : null;
        if (cardBindingCameraActivity != null) {
            CardBindingViewModel cardBindingVm = cardBindingCameraActivity.getCardBindingVm();
            CashierCheckoutModel cashierMainResult = cardBindingCameraActivity.getCashierMainResult();
            cardBindingVm.PlaceComponentResult(str, String.valueOf(cashierMainResult != null ? cashierMainResult.PlaceComponentResult : null));
        }
    }

    public static final /* synthetic */ void access$resetAllState(BottomSheetCardBindingView bottomSheetCardBindingView) {
        bottomSheetCardBindingView.KClassImpl$Data$declaredNonStaticMembers$2.MyBillsEntityDataFactory();
        bottomSheetCardBindingView.KClassImpl$Data$declaredNonStaticMembers$2(false);
        bottomSheetCardBindingView.NetworkUserEntityData$$ExternalSyntheticLambda0 = false;
        bottomSheetCardBindingView.getCardNumberView().clearCardIcon();
        bottomSheetCardBindingView.setQueryCardPolicyInfoModel(null);
        AddNewCardAdapter addNewCardAdapter = bottomSheetCardBindingView.BuiltInFictitiousFunctionClassFactory;
        if (addNewCardAdapter != null) {
            addNewCardAdapter.removeAllItems();
        }
        bottomSheetCardBindingView.BuiltInFictitiousFunctionClassFactory();
        bottomSheetCardBindingView.BuiltInFictitiousFunctionClassFactory = null;
        bottomSheetCardBindingView.MyBillsEntityDataFactory();
        bottomSheetCardBindingView.getAuthRequestContext = "";
        bottomSheetCardBindingView.scheduleImpl = "";
        bottomSheetCardBindingView.getErrorConfigVersion = "";
        bottomSheetCardBindingView.MyBillsEntityDataFactory = "";
        bottomSheetCardBindingView.moveToNextValue = "";
        bottomSheetCardBindingView.lookAheadTest = "";
        bottomSheetCardBindingView.PrepareContext.clear();
        DisclaimerView disclaimerView = (DisclaimerView) bottomSheetCardBindingView._$_findCachedViewById(R.id.GetPersonalizationOptions);
        Intrinsics.checkNotNullExpressionValue(disclaimerView, "");
        DisclaimerView.setDataBankCard$default(disclaimerView, null, false, 2, null);
        ((DisclaimerView) bottomSheetCardBindingView._$_findCachedViewById(R.id.GetPersonalizationOptions)).setCheckboxListener(new BottomSheetCardBindingView$initDisclaimerView$1(bottomSheetCardBindingView));
        bottomSheetCardBindingView.setCardBcaOneKlik(false);
    }

    public static final /* synthetic */ void access$setVerifyElementsValidation(BottomSheetCardBindingView bottomSheetCardBindingView, String str, boolean z) {
        if (bottomSheetCardBindingView.PrepareContext.remove(str) != null) {
            bottomSheetCardBindingView.PrepareContext.put(str, Boolean.valueOf(z));
        }
        bottomSheetCardBindingView.initRecordTimeStamp.onNext(Boolean.valueOf(!bottomSheetCardBindingView.PrepareContext.containsValue(Boolean.FALSE)));
    }

    private final boolean BuiltInFictitiousFunctionClassFactory(String p0) {
        CashierCheckoutModel cashierMainResult;
        AttributeModel attributeModel;
        List<CashierPayChannelModel> list;
        Context context = getContext();
        Object obj = null;
        CardBindingCameraActivity cardBindingCameraActivity = context instanceof CardBindingCameraActivity ? (CardBindingCameraActivity) context : null;
        if (cardBindingCameraActivity != null && (cashierMainResult = cardBindingCameraActivity.getCashierMainResult()) != null && (attributeModel = cashierMainResult.getAuthRequestContext) != null && (list = attributeModel.SummaryVoucherView$$ExternalSyntheticLambda1) != null) {
            Iterator<T> it = list.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                Object next = it.next();
                CashierPayChannelModel cashierPayChannelModel = (CashierPayChannelModel) next;
                if (Intrinsics.areEqual(cashierPayChannelModel.B, p0) && cashierPayChannelModel.lookAheadTest() && Intrinsics.areEqual(cashierPayChannelModel.getErrorConfigVersion, Boolean.TRUE)) {
                    obj = next;
                    break;
                }
            }
            obj = (CashierPayChannelModel) obj;
        }
        return obj != null;
    }

    private final void PlaceComponentResult() {
        LifecycleCoroutineScope PlaceComponentResult;
        ((AppCompatEditText) getCardNumberView()._$_findCachedViewById(R.id.GetFriendsFeedWithInitFeedAndFeatureCheck_res_0x7f0a0671)).addTextChangedListener(new TextWatcher() { // from class: id.dana.cardbinding.view.BottomSheetCardBindingView$watcherCardNumberView$1
            @Override // android.text.TextWatcher
            public final void afterTextChanged(Editable p0) {
            }

            @Override // android.text.TextWatcher
            public final void beforeTextChanged(CharSequence p0, int p1, int p2, int p3) {
            }

            @Override // android.text.TextWatcher
            public final void onTextChanged(CharSequence p0, int p1, int p2, int p3) {
                CardView cardView = BottomSheetCardBindingView.access$getContentView(BottomSheetCardBindingView.this).KClassImpl$Data$declaredNonStaticMembers$2;
                String valueOf = String.valueOf(p0);
                StringBuilder sb = new StringBuilder();
                for (int i = 0; i < valueOf.length(); i++) {
                    char charAt = valueOf.charAt(i);
                    if (!CharsKt.isWhitespace(charAt)) {
                        sb.append(charAt);
                    }
                }
                String obj = sb.toString();
                Intrinsics.checkNotNullExpressionValue(obj, "");
                cardView.setTextViewCardNumber(obj);
            }
        });
        LifecycleOwner PlaceComponentResult2 = C0207ViewKt.PlaceComponentResult(this);
        if (PlaceComponentResult2 == null || (PlaceComponentResult = LifecycleOwnerKt.PlaceComponentResult(PlaceComponentResult2)) == null) {
            return;
        }
        getCardNumberView().addInputCardListener(PlaceComponentResult, new Function1<String, Unit>() { // from class: id.dana.cardbinding.view.BottomSheetCardBindingView$initCardNumberListener$1$1
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
                Intrinsics.checkNotNullParameter(str, "");
                BottomSheetCardBindingView.access$getQueryCardPolicy(BottomSheetCardBindingView.this, str);
            }
        });
    }

    public final InputCardNumberView getCardNumberView() {
        ViewCardBindingBinding viewCardBindingBinding = getBinding().KClassImpl$Data$declaredNonStaticMembers$2;
        Intrinsics.checkNotNullExpressionValue(viewCardBindingBinding, "");
        InputCardNumberView inputCardNumberView = viewCardBindingBinding.MyBillsEntityDataFactory;
        Intrinsics.checkNotNullExpressionValue(inputCardNumberView, "");
        return inputCardNumberView;
    }

    public final void handleQueryCardResult(QueryCardPolicyInfoModel queryCardResult, String cardNumber) {
        List<String> list;
        Intrinsics.checkNotNullParameter(queryCardResult, "");
        Intrinsics.checkNotNullParameter(cardNumber, "");
        String str = queryCardResult.initRecordTimeStamp;
        if (str == null) {
            str = queryCardResult.getAuthRequestContext;
        }
        if (str == null) {
            str = "";
        }
        this.NetworkUserEntityData$$ExternalSyntheticLambda1 = BuiltInFictitiousFunctionClassFactory(str);
        if (Intrinsics.areEqual(queryCardResult.moveToNextValue, Institution.BCA_ONEKLIK)) {
            setCardBcaOneKlik(true);
            DisclaimerView disclaimerView = (DisclaimerView) _$_findCachedViewById(R.id.GetPersonalizationOptions);
            Intrinsics.checkNotNullExpressionValue(disclaimerView, "");
            DisclaimerView.setDataBankCard$default(disclaimerView, "BCA_ONE_KLIK", false, 2, null);
        }
        setQueryCardPolicyInfoModel(queryCardResult);
        PlaceComponentResult(cardNumber);
        if (!this.isCardBcaOneKlik) {
            QueryCardPolicyInfoModel queryCardPolicyInfoModel = this.queryCardPolicyInfoModel;
            if (queryCardPolicyInfoModel != null && (list = queryCardPolicyInfoModel.GetContactSyncConfig) != null) {
                CashierAddCardVerifyElementsFactory cashierAddCardVerifyElementsFactory = CashierAddCardVerifyElementsFactory.INSTANCE;
                this.NetworkUserEntityData$$ExternalSyntheticLambda8 = CashierAddCardVerifyElementsFactory.getAuthRequestContext(list);
                CashierAddCardVerifyElementsFactory cashierAddCardVerifyElementsFactory2 = CashierAddCardVerifyElementsFactory.INSTANCE;
                List<Integer> list2 = this.NetworkUserEntityData$$ExternalSyntheticLambda8;
                QueryCardPolicyInfoModel queryCardPolicyInfoModel2 = this.queryCardPolicyInfoModel;
                List<QueryCardVerifyElementModel> PlaceComponentResult = CashierAddCardVerifyElementsFactory.PlaceComponentResult(list2, queryCardPolicyInfoModel2 != null ? queryCardPolicyInfoModel2.NetworkUserEntityData$$ExternalSyntheticLambda0 : null);
                AddNewCardAdapter addNewCardAdapter = this.BuiltInFictitiousFunctionClassFactory;
                if (addNewCardAdapter != null) {
                    addNewCardAdapter.setItems(PlaceComponentResult);
                }
                List<String> list3 = list;
                ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list3, 10));
                Iterator<T> it = list3.iterator();
                while (it.hasNext()) {
                    this.PrepareContext.put((String) it.next(), Boolean.FALSE);
                    arrayList.add(Unit.INSTANCE);
                }
            }
            String str2 = queryCardResult.getAuthRequestContext;
            DisclaimerView disclaimerView2 = (DisclaimerView) _$_findCachedViewById(R.id.GetPersonalizationOptions);
            Intrinsics.checkNotNullExpressionValue(disclaimerView2, "");
            DisclaimerView.setDataBankCard$default(disclaimerView2, str2, false, 2, null);
        }
        getCardNumberView().getIconCardErrorHandlingListener().invoke(cardNumber);
    }

    @JvmName(name = "setQueryCardPolicyInfoModel")
    public final void setQueryCardPolicyInfoModel(QueryCardPolicyInfoModel queryCardPolicyInfoModel) {
        String str = queryCardPolicyInfoModel != null ? queryCardPolicyInfoModel.PlaceComponentResult : null;
        QueryCardPolicyInfoModel queryCardPolicyInfoModel2 = this.queryCardPolicyInfoModel;
        if (!Intrinsics.areEqual(str, queryCardPolicyInfoModel2 != null ? queryCardPolicyInfoModel2.PlaceComponentResult : null) || queryCardPolicyInfoModel == null) {
            this.queryCardPolicyInfoModel = queryCardPolicyInfoModel;
            if (queryCardPolicyInfoModel != null) {
                InputCardNumberView cardNumberView = getCardNumberView();
                CardAssetUtils cardAssetUtils = CardAssetUtils.INSTANCE;
                Integer BuiltInFictitiousFunctionClassFactory = CardAssetUtils.BuiltInFictitiousFunctionClassFactory(queryCardPolicyInfoModel.BuiltInFictitiousFunctionClassFactory);
                CardAssetUtils cardAssetUtils2 = CardAssetUtils.INSTANCE;
                cardNumberView.setCardIcon(BuiltInFictitiousFunctionClassFactory, CardAssetUtils.PlaceComponentResult(queryCardPolicyInfoModel.getAuthRequestContext));
                ViewCardBindingBinding viewCardBindingBinding = getBinding().KClassImpl$Data$declaredNonStaticMembers$2;
                Intrinsics.checkNotNullExpressionValue(viewCardBindingBinding, "");
                final CardView cardView = viewCardBindingBinding.KClassImpl$Data$declaredNonStaticMembers$2;
                final QueryCardPolicyInfoModel queryCardPolicyInfoModel3 = this.queryCardPolicyInfoModel;
                if (queryCardPolicyInfoModel3 != null) {
                    String str2 = queryCardPolicyInfoModel3.moveToNextValue;
                    if (str2 != null) {
                        cardView.setCardBankTextColor(str2.length() == 0);
                        cardView.setCardBankLogo(str2);
                    }
                    if (!cardView.getHasPerfromCardAnimate()) {
                        cardView.performCardAnimation(false, new Function0<Unit>() { // from class: id.dana.cardbinding.view.BottomSheetCardBindingView$setupCardBankPreview$1$1$2
                            /* JADX INFO: Access modifiers changed from: package-private */
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
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
                                CardView.this.setCardBankBackground(queryCardPolicyInfoModel3);
                            }
                        });
                        cardView.setHasPerfromCardAnimate(true);
                    }
                    cardView.setCardScheme(queryCardPolicyInfoModel3.BuiltInFictitiousFunctionClassFactory, this.isCardBcaOneKlik);
                }
                Boolean bool = queryCardPolicyInfoModel.scheduleImpl;
                this.isDirectDebit = bool != null ? bool.booleanValue() : false;
            }
        }
    }
}
