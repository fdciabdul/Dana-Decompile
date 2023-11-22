package id.dana.cashier.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.Transformation;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.core.content.ContextCompat;
import com.ap.zoloz.hummer.biz.HummerConstants;
import com.bumptech.glide.Glide;
import id.dana.R;
import id.dana.cashier.model.VoucherCashierModel;
import id.dana.cashier.utils.CashierKeyParams;
import id.dana.core.ui.BaseViewBindingRichView;
import id.dana.databinding.ViewCashierPromoBinding;
import id.dana.extension.view.ViewExtKt;
import id.dana.model.CurrencyAmountModel;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmName;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function7;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0092\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000f\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0011\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 Z2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001ZB/\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b\u0012\b\b\u0002\u0010\t\u001a\u00020\b¢\u0006\u0002\u0010\nJ\u0010\u00104\u001a\u00020$2\u0006\u00105\u001a\u000206H\u0002J#\u00107\u001a\u00020$2\b\u00108\u001a\u0004\u0018\u00010\u001a2\n\b\u0002\u00109\u001a\u0004\u0018\u00010\u0010H\u0002¢\u0006\u0002\u0010:J\u0010\u0010;\u001a\u00020$2\u0006\u00105\u001a\u000206H\u0002J\b\u0010<\u001a\u00020\u0002H\u0016J\b\u0010=\u001a\u00020$H\u0002J\b\u0010>\u001a\u00020$H\u0002J\u000e\u0010?\u001a\u00020$2\u0006\u0010\u000e\u001a\u00020\fJ\u000e\u0010@\u001a\u00020$2\u0006\u0010\u000f\u001a\u00020\u0010J\u001e\u0010A\u001a\u00020$2\f\u0010B\u001a\b\u0012\u0002\b\u0003\u0018\u00010C2\u0006\u0010D\u001a\u00020EH\u0002J\u000e\u0010F\u001a\u00020$2\u0006\u0010\"\u001a\u00020!J/\u0010G\u001a\u00020$2\b\u0010H\u001a\u0004\u0018\u0001062\u0016\u0010I\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u0001060J\"\u0004\u0018\u000106H\u0002¢\u0006\u0002\u0010KJQ\u0010L\u001a\u00020$2\b\u0010M\u001a\u0004\u0018\u00010\u001a2\f\u0010N\u001a\b\u0012\u0004\u0012\u00020\u001a0O2\n\b\u0002\u00109\u001a\u0004\u0018\u00010\u00102\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\f2\b\b\u0002\u0010#\u001a\u00020\u0010¢\u0006\u0002\u0010PJ\b\u0010Q\u001a\u00020$H\u0016J\b\u0010R\u001a\u00020$H\u0002J\u0012\u0010S\u001a\u00020$2\b\u00108\u001a\u0004\u0018\u00010\u001aH\u0002J\b\u0010T\u001a\u00020$H\u0002J\u0012\u0010U\u001a\u00020$2\b\u00108\u001a\u0004\u0018\u00010\u001aH\u0002J\u001e\u0010V\u001a\u00020$*\u00020W2\u0006\u0010X\u001a\u00020\f2\b\b\u0002\u0010Y\u001a\u00020\u0010H\u0002R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0011\u001a\u00020\u0010X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u000e\u0010\u0015\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000RÈ\u0001\u0010\u0018\u001a¯\u0001\u0012\u0015\u0012\u0013\u0018\u00010\u001a¢\u0006\f\b\u001b\u0012\b\b\u001c\u0012\u0004\b\b(\u001d\u0012#\u0012!\u0012\u0004\u0012\u00020\u001a0\u001ej\b\u0012\u0004\u0012\u00020\u001a`\u001f¢\u0006\f\b\u001b\u0012\b\b\u001c\u0012\u0004\b\b( \u0012\u0013\u0012\u00110\f¢\u0006\f\b\u001b\u0012\b\b\u001c\u0012\u0004\b\b(\u000e\u0012\u0015\u0012\u0013\u0018\u00010\f¢\u0006\f\b\u001b\u0012\b\b\u001c\u0012\u0004\b\b(\u000b\u0012\u0013\u0012\u00110\u0010¢\u0006\f\b\u001b\u0012\b\b\u001c\u0012\u0004\b\b(\u000f\u0012\u0013\u0012\u00110!¢\u0006\f\b\u001b\u0012\b\b\u001c\u0012\u0004\b\b(\"\u0012\u0013\u0012\u00110\u0010¢\u0006\f\b\u001b\u0012\b\b\u001c\u0012\u0004\b\b(#\u0012\u0004\u0012\u00020$0\u0019X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010&\"\u0004\b'\u0010(R\u000e\u0010\"\u001a\u00020!X\u0082\u000e¢\u0006\u0002\n\u0000R(\u0010\u001d\u001a\u0004\u0018\u00010\u001a2\b\u0010)\u001a\u0004\u0018\u00010\u001a@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b*\u0010+\"\u0004\b,\u0010-R.\u0010.\u001a\u0016\u0012\u0006\u0012\u0004\u0018\u00010\u001a\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020$0/X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b0\u00101\"\u0004\b2\u00103R\u001e\u0010 \u001a\u0012\u0012\u0004\u0012\u00020\u001a0\u001ej\b\u0012\u0004\u0012\u00020\u001a`\u001fX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006["}, d2 = {"Lid/dana/cashier/view/CashierPromoView;", "Lid/dana/core/ui/BaseViewBindingRichView;", "Lid/dana/databinding/ViewCashierPromoBinding;", HummerConstants.CONTEXT, "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "defStyleRes", "(Landroid/content/Context;Landroid/util/AttributeSet;II)V", "cardBin", "", "cardType", CashierKeyParams.CASHIER_ORDER_ID, "isCheckBoxMixPayBalanceChecked", "", "isNeedToChangeCheckBoxMixPayBalance", "()Z", "setNeedToChangeCheckBoxMixPayBalance", "(Z)V", "isOneKlikPayMethod", "isPromoExpanded", "isPromoNotEligible", "onClickChangePromoListener", "Lkotlin/Function7;", "Lid/dana/cashier/model/VoucherCashierModel;", "Lkotlin/ParameterName;", "name", "selectedCashierPromo", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "voucherCashierModels", "", "remainingAmount", "isOneKlik", "", "getOnClickChangePromoListener", "()Lkotlin/jvm/functions/Function7;", "setOnClickChangePromoListener", "(Lkotlin/jvm/functions/Function7;)V", "value", "getSelectedCashierPromo", "()Lid/dana/cashier/model/VoucherCashierModel;", "setSelectedCashierPromo", "(Lid/dana/cashier/model/VoucherCashierModel;)V", "selectedCashierPromoListener", "Lkotlin/Function2;", "getSelectedCashierPromoListener", "()Lkotlin/jvm/functions/Function2;", "setSelectedCashierPromoListener", "(Lkotlin/jvm/functions/Function2;)V", "collapseAction", "view", "Landroid/view/View;", "displaySelectedVoucherCashier", "voucherCashierModel", "isCouponRejectedByRisk", "(Lid/dana/cashier/model/VoucherCashierModel;Ljava/lang/Boolean;)V", "expandAction", "inflateViewBinding", "onClickChangePromo", "onClickExpandVoucherPromo", "setCashierOrderId", "setCheckBoxMixPayBalance", "setPromoIcon", "promoIcon", "", "iconView", "Landroidx/appcompat/widget/AppCompatImageView;", "setRemainingAmount", "setVisibilityPromoStatus", "showView", "hideView", "", "(Landroid/view/View;[Landroid/view/View;)V", "setVoucherCashiers", "selectedPromo", "voucherCashierList", "", "(Lid/dana/cashier/model/VoucherCashierModel;Ljava/util/List;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/String;Z)V", "setup", "showCouponRejectedByRisk", "showNotEligiblePromo", "showNotSelectedPromo", "showSelectedPromo", "setTextPromoValue", "Landroidx/appcompat/widget/AppCompatTextView;", "promoAmount", "isPromoAvailable", "Companion", "app_productionRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class CashierPromoView extends BaseViewBindingRichView<ViewCashierPromoBinding> {
    private String BuiltInFictitiousFunctionClassFactory;
    private VoucherCashierModel DatabaseTableConfigUtil;
    private String KClassImpl$Data$declaredNonStaticMembers$2;
    private String MyBillsEntityDataFactory;
    private boolean NetworkUserEntityData$$ExternalSyntheticLambda0;
    private Function2<? super VoucherCashierModel, ? super Boolean, Unit> NetworkUserEntityData$$ExternalSyntheticLambda1;
    private ArrayList<VoucherCashierModel> NetworkUserEntityData$$ExternalSyntheticLambda2;
    private boolean PlaceComponentResult;
    public Map<Integer, View> _$_findViewCache;
    private boolean getAuthRequestContext;
    private long getErrorConfigVersion;
    private boolean lookAheadTest;
    private Function7<? super VoucherCashierModel, ? super ArrayList<VoucherCashierModel>, ? super String, ? super String, ? super Boolean, ? super Long, ? super Boolean, Unit> moveToNextValue;
    private boolean scheduleImpl;

    public static /* synthetic */ void $r8$lambda$mqHi7AmWlCOvSvZ7tja9q_mrDdQ(View view) {
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public CashierPromoView(Context context) {
        this(context, null, 0, 0, 14, null);
        Intrinsics.checkNotNullParameter(context, "");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public CashierPromoView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 0, 12, null);
        Intrinsics.checkNotNullParameter(context, "");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public CashierPromoView(Context context, AttributeSet attributeSet, int i) {
        this(context, attributeSet, i, 0, 8, null);
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
    public CashierPromoView(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        Intrinsics.checkNotNullParameter(context, "");
        this._$_findViewCache = new LinkedHashMap();
        this.NetworkUserEntityData$$ExternalSyntheticLambda1 = new Function2<VoucherCashierModel, Boolean, Unit>() { // from class: id.dana.cashier.view.CashierPromoView$selectedCashierPromoListener$1
            public final void invoke(VoucherCashierModel voucherCashierModel, boolean z) {
            }

            @Override // kotlin.jvm.functions.Function2
            public final /* synthetic */ Unit invoke(VoucherCashierModel voucherCashierModel, Boolean bool) {
                invoke(voucherCashierModel, bool.booleanValue());
                return Unit.INSTANCE;
            }
        };
        this.moveToNextValue = new Function7<VoucherCashierModel, ArrayList<VoucherCashierModel>, String, String, Boolean, Long, Boolean, Unit>() { // from class: id.dana.cashier.view.CashierPromoView$onClickChangePromoListener$1
            public final void invoke(VoucherCashierModel voucherCashierModel, ArrayList<VoucherCashierModel> arrayList, String str, String str2, boolean z, long j, boolean z2) {
                Intrinsics.checkNotNullParameter(arrayList, "");
                Intrinsics.checkNotNullParameter(str, "");
            }

            @Override // kotlin.jvm.functions.Function7
            public final /* synthetic */ Unit invoke(VoucherCashierModel voucherCashierModel, ArrayList<VoucherCashierModel> arrayList, String str, String str2, Boolean bool, Long l, Boolean bool2) {
                invoke(voucherCashierModel, arrayList, str, str2, bool.booleanValue(), l.longValue(), bool2.booleanValue());
                return Unit.INSTANCE;
            }
        };
        this.lookAheadTest = true;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = "";
        this.NetworkUserEntityData$$ExternalSyntheticLambda2 = new ArrayList<>();
    }

    public /* synthetic */ CashierPromoView(Context context, AttributeSet attributeSet, int i, int i2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i3 & 2) != 0 ? null : attributeSet, (i3 & 4) != 0 ? 0 : i, (i3 & 8) != 0 ? 0 : i2);
    }

    @JvmName(name = "getSelectedCashierPromoListener")
    public final Function2<VoucherCashierModel, Boolean, Unit> getSelectedCashierPromoListener() {
        return this.NetworkUserEntityData$$ExternalSyntheticLambda1;
    }

    @JvmName(name = "setSelectedCashierPromoListener")
    public final void setSelectedCashierPromoListener(Function2<? super VoucherCashierModel, ? super Boolean, Unit> function2) {
        Intrinsics.checkNotNullParameter(function2, "");
        this.NetworkUserEntityData$$ExternalSyntheticLambda1 = function2;
    }

    @JvmName(name = "getOnClickChangePromoListener")
    public final Function7<VoucherCashierModel, ArrayList<VoucherCashierModel>, String, String, Boolean, Long, Boolean, Unit> getOnClickChangePromoListener() {
        return this.moveToNextValue;
    }

    @JvmName(name = "setOnClickChangePromoListener")
    public final void setOnClickChangePromoListener(Function7<? super VoucherCashierModel, ? super ArrayList<VoucherCashierModel>, ? super String, ? super String, ? super Boolean, ? super Long, ? super Boolean, Unit> function7) {
        Intrinsics.checkNotNullParameter(function7, "");
        this.moveToNextValue = function7;
    }

    @JvmName(name = "isNeedToChangeCheckBoxMixPayBalance")
    /* renamed from: isNeedToChangeCheckBoxMixPayBalance  reason: from getter */
    public final boolean getPlaceComponentResult() {
        return this.PlaceComponentResult;
    }

    @JvmName(name = "setNeedToChangeCheckBoxMixPayBalance")
    public final void setNeedToChangeCheckBoxMixPayBalance(boolean z) {
        this.PlaceComponentResult = z;
    }

    @JvmName(name = "getSelectedCashierPromo")
    /* renamed from: getSelectedCashierPromo  reason: from getter */
    public final VoucherCashierModel getDatabaseTableConfigUtil() {
        return this.DatabaseTableConfigUtil;
    }

    @JvmName(name = "setSelectedCashierPromo")
    public final void setSelectedCashierPromo(VoucherCashierModel voucherCashierModel) {
        this.DatabaseTableConfigUtil = voucherCashierModel;
        if (voucherCashierModel != null) {
            voucherCashierModel.KClassImpl$Data$declaredNonStaticMembers$2 = this.MyBillsEntityDataFactory;
        }
        this.NetworkUserEntityData$$ExternalSyntheticLambda1.invoke(this.DatabaseTableConfigUtil, Boolean.valueOf(this.PlaceComponentResult));
        displaySelectedVoucherCashier$default(this, this.DatabaseTableConfigUtil, null, 2, null);
    }

    @Override // id.dana.core.ui.BaseViewBindingRichView
    public final ViewCashierPromoBinding inflateViewBinding() {
        ViewCashierPromoBinding authRequestContext = ViewCashierPromoBinding.getAuthRequestContext(LayoutInflater.from(getContext()));
        Intrinsics.checkNotNullExpressionValue(authRequestContext, "");
        return authRequestContext;
    }

    public final void setVoucherCashiers(VoucherCashierModel selectedPromo, List<VoucherCashierModel> voucherCashierList, Boolean isCouponRejectedByRisk, String cardBin, String cardType, boolean isOneKlik) {
        Object obj;
        Intrinsics.checkNotNullParameter(voucherCashierList, "");
        this.MyBillsEntityDataFactory = cardBin;
        this.BuiltInFictitiousFunctionClassFactory = cardType;
        this.scheduleImpl = isOneKlik;
        List<VoucherCashierModel> list = voucherCashierList;
        Iterator<T> it = list.iterator();
        while (true) {
            if (!it.hasNext()) {
                obj = null;
                break;
            }
            obj = it.next();
            if (((VoucherCashierModel) obj).getNetworkUserEntityData$$ExternalSyntheticLambda1()) {
                break;
            }
        }
        VoucherCashierModel voucherCashierModel = (VoucherCashierModel) obj;
        this.NetworkUserEntityData$$ExternalSyntheticLambda0 = voucherCashierModel == null;
        this.NetworkUserEntityData$$ExternalSyntheticLambda2.clear();
        ArrayList<VoucherCashierModel> arrayList = this.NetworkUserEntityData$$ExternalSyntheticLambda2;
        Iterator<T> it2 = list.iterator();
        while (it2.hasNext()) {
            ((VoucherCashierModel) it2.next()).KClassImpl$Data$declaredNonStaticMembers$2 = cardBin;
        }
        arrayList.addAll(list);
        if (isCouponRejectedByRisk != null && isCouponRejectedByRisk.booleanValue()) {
            MyBillsEntityDataFactory(null, isCouponRejectedByRisk);
        } else if (this.PlaceComponentResult) {
            this.PlaceComponentResult = false;
        } else {
            if (selectedPromo == null) {
                selectedPromo = (this.getAuthRequestContext && isOneKlik) ? null : voucherCashierModel;
            }
            setSelectedCashierPromo(selectedPromo);
        }
    }

    public final void setCashierOrderId(String cashierOrderId) {
        Intrinsics.checkNotNullParameter(cashierOrderId, "");
        this.KClassImpl$Data$declaredNonStaticMembers$2 = cashierOrderId;
    }

    public final void setRemainingAmount(long remainingAmount) {
        this.getErrorConfigVersion = remainingAmount;
    }

    public final void setCheckBoxMixPayBalance(boolean isCheckBoxMixPayBalanceChecked) {
        this.getAuthRequestContext = isCheckBoxMixPayBalanceChecked;
    }

    static /* synthetic */ void displaySelectedVoucherCashier$default(CashierPromoView cashierPromoView, VoucherCashierModel voucherCashierModel, Boolean bool, int i, Object obj) {
        if ((i & 2) != 0) {
            bool = null;
        }
        cashierPromoView.MyBillsEntityDataFactory(voucherCashierModel, bool);
    }

    private final void MyBillsEntityDataFactory(VoucherCashierModel voucherCashierModel, Boolean bool) {
        String string;
        Comparable valueOf;
        String str;
        CurrencyAmountModel BuiltInFictitiousFunctionClassFactory;
        Comparable valueOf2;
        if (!Intrinsics.areEqual(bool, Boolean.TRUE)) {
            if (this.NetworkUserEntityData$$ExternalSyntheticLambda0) {
                ViewCashierPromoBinding binding = getBinding();
                if (!(voucherCashierModel != null ? Intrinsics.areEqual(voucherCashierModel.NetworkUserEntityData$$ExternalSyntheticLambda0, Boolean.TRUE) : false)) {
                    valueOf2 = Integer.valueOf((int) R.drawable.ic_cashier_voucher);
                } else {
                    valueOf2 = voucherCashierModel.GetContactSyncConfig;
                }
                Comparable comparable = valueOf2;
                AppCompatTextView appCompatTextView = binding.scheduleImpl;
                Intrinsics.checkNotNullExpressionValue(appCompatTextView, "");
                Context context = getContext();
                r3 = context != null ? context.getString(R.string.not_available) : null;
                setTextPromoValue$default(this, appCompatTextView, r3 == null ? "" : r3, false, 2, null);
                AppCompatImageView appCompatImageView = binding.NetworkUserEntityData$$ExternalSyntheticLambda1.getAuthRequestContext;
                Intrinsics.checkNotNullExpressionValue(appCompatImageView, "");
                Glide.getAuthRequestContext(this).getAuthRequestContext(comparable).BuiltInFictitiousFunctionClassFactory((int) R.drawable.ic_cashier_promo).MyBillsEntityDataFactory((ImageView) appCompatImageView);
                PlaceComponentResult(binding.NetworkUserEntityData$$ExternalSyntheticLambda1.PlaceComponentResult, binding.initRecordTimeStamp.PlaceComponentResult, binding.newProxyInstance.KClassImpl$Data$declaredNonStaticMembers$2, binding.KClassImpl$Data$declaredNonStaticMembers$2);
                return;
            } else if (voucherCashierModel != null) {
                ViewCashierPromoBinding binding2 = getBinding();
                binding2.NetworkUserEntityData$$ExternalSyntheticLambda2.setText(voucherCashierModel != null ? voucherCashierModel.scheduleImpl : null);
                StringBuilder sb = new StringBuilder();
                sb.append('-');
                if (voucherCashierModel != null && (BuiltInFictitiousFunctionClassFactory = VoucherCashierModel.BuiltInFictitiousFunctionClassFactory(voucherCashierModel, null, false, this.BuiltInFictitiousFunctionClassFactory, 3)) != null) {
                    r3 = BuiltInFictitiousFunctionClassFactory.getAuthRequestContext();
                }
                sb.append(r3);
                String obj = sb.toString();
                AppCompatTextView appCompatTextView2 = binding2.scheduleImpl;
                Intrinsics.checkNotNullExpressionValue(appCompatTextView2, "");
                KClassImpl$Data$declaredNonStaticMembers$2(appCompatTextView2, obj, true);
                AppCompatTextView appCompatTextView3 = binding2.GetContactSyncConfig;
                if (voucherCashierModel != null && (str = voucherCashierModel.lookAheadTest) != null) {
                    string = str;
                } else {
                    string = getContext().getString(R.string.voucher_description_default_value);
                }
                appCompatTextView3.setText(string);
                if (!(voucherCashierModel != null ? Intrinsics.areEqual(voucherCashierModel.NetworkUserEntityData$$ExternalSyntheticLambda0, Boolean.TRUE) : false)) {
                    valueOf = Integer.valueOf((int) R.drawable.ic_cashier_voucher);
                } else {
                    valueOf = voucherCashierModel.GetContactSyncConfig;
                }
                AppCompatImageView appCompatImageView2 = binding2.moveToNextValue;
                Intrinsics.checkNotNullExpressionValue(appCompatImageView2, "");
                Glide.getAuthRequestContext(this).getAuthRequestContext(valueOf).BuiltInFictitiousFunctionClassFactory((int) R.drawable.ic_cashier_promo).MyBillsEntityDataFactory((ImageView) appCompatImageView2);
                PlaceComponentResult(binding2.KClassImpl$Data$declaredNonStaticMembers$2, binding2.initRecordTimeStamp.PlaceComponentResult, binding2.NetworkUserEntityData$$ExternalSyntheticLambda1.PlaceComponentResult, binding2.newProxyInstance.KClassImpl$Data$declaredNonStaticMembers$2);
                return;
            } else {
                ViewCashierPromoBinding binding3 = getBinding();
                AppCompatTextView appCompatTextView4 = binding3.scheduleImpl;
                Intrinsics.checkNotNullExpressionValue(appCompatTextView4, "");
                Context context2 = getContext();
                r3 = context2 != null ? context2.getString(R.string.none) : null;
                setTextPromoValue$default(this, appCompatTextView4, r3 == null ? "" : r3, false, 2, null);
                PlaceComponentResult(binding3.initRecordTimeStamp.PlaceComponentResult, binding3.newProxyInstance.KClassImpl$Data$declaredNonStaticMembers$2, binding3.NetworkUserEntityData$$ExternalSyntheticLambda1.PlaceComponentResult, binding3.KClassImpl$Data$declaredNonStaticMembers$2);
                return;
            }
        }
        ViewCashierPromoBinding binding4 = getBinding();
        AppCompatTextView appCompatTextView5 = binding4.scheduleImpl;
        Intrinsics.checkNotNullExpressionValue(appCompatTextView5, "");
        Context context3 = getContext();
        r3 = context3 != null ? context3.getString(R.string.not_available) : null;
        setTextPromoValue$default(this, appCompatTextView5, r3 == null ? "" : r3, false, 2, null);
        AppCompatImageView appCompatImageView3 = binding4.newProxyInstance.BuiltInFictitiousFunctionClassFactory;
        Intrinsics.checkNotNullExpressionValue(appCompatImageView3, "");
        ViewExtKt.KClassImpl$Data$declaredNonStaticMembers$2(appCompatImageView3);
        binding4.PlaceComponentResult.setOnClickListener(new View.OnClickListener() { // from class: id.dana.cashier.view.CashierPromoView$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                CashierPromoView.$r8$lambda$mqHi7AmWlCOvSvZ7tja9q_mrDdQ(view);
            }
        });
        PlaceComponentResult(binding4.newProxyInstance.KClassImpl$Data$declaredNonStaticMembers$2, binding4.NetworkUserEntityData$$ExternalSyntheticLambda1.PlaceComponentResult, binding4.initRecordTimeStamp.PlaceComponentResult, binding4.KClassImpl$Data$declaredNonStaticMembers$2);
    }

    static /* synthetic */ void setTextPromoValue$default(CashierPromoView cashierPromoView, AppCompatTextView appCompatTextView, String str, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            z = false;
        }
        KClassImpl$Data$declaredNonStaticMembers$2(appCompatTextView, str, z);
    }

    private static void KClassImpl$Data$declaredNonStaticMembers$2(AppCompatTextView appCompatTextView, String str, boolean z) {
        int i = z ? R.color.f25442131100151 : R.color.f26762131100391;
        appCompatTextView.setText(str);
        appCompatTextView.setTextColor(ContextCompat.BuiltInFictitiousFunctionClassFactory(appCompatTextView.getContext(), i));
    }

    private static void PlaceComponentResult(View view, View... viewArr) {
        if (view != null) {
            view.setVisibility(0);
        }
        int length = viewArr.length;
        for (int i = 0; i < 3; i++) {
            View view2 = viewArr[i];
            if (view2 != null) {
                view2.setVisibility(8);
            }
        }
    }

    public static /* synthetic */ void $r8$lambda$jdUFuLZ3mVUGT6_drCNRy8VSNeo(CashierPromoView cashierPromoView, View view) {
        Intrinsics.checkNotNullParameter(cashierPromoView, "");
        cashierPromoView.moveToNextValue.invoke(cashierPromoView.DatabaseTableConfigUtil, cashierPromoView.NetworkUserEntityData$$ExternalSyntheticLambda2, cashierPromoView.KClassImpl$Data$declaredNonStaticMembers$2, cashierPromoView.MyBillsEntityDataFactory, Boolean.valueOf(cashierPromoView.getAuthRequestContext), Long.valueOf(cashierPromoView.getErrorConfigVersion), Boolean.valueOf(cashierPromoView.scheduleImpl));
    }

    public static /* synthetic */ void $r8$lambda$mIM5I0OjrIf7BSAYDNxO5JB_bdE(CashierPromoView cashierPromoView, ViewCashierPromoBinding viewCashierPromoBinding, View view) {
        Intrinsics.checkNotNullParameter(cashierPromoView, "");
        Intrinsics.checkNotNullParameter(viewCashierPromoBinding, "");
        if (cashierPromoView.lookAheadTest) {
            viewCashierPromoBinding.lookAheadTest.animate().setDuration(200L).rotation(180.0f);
            FrameLayout frameLayout = viewCashierPromoBinding.PlaceComponentResult;
            Intrinsics.checkNotNullExpressionValue(frameLayout, "");
            final FrameLayout frameLayout2 = frameLayout;
            final int measuredHeight = frameLayout2.getMeasuredHeight();
            Animation animation = new Animation() { // from class: id.dana.cashier.view.CashierPromoView$collapseAction$animation$1
                @Override // android.view.animation.Animation
                protected final void applyTransformation(float p0, Transformation p1) {
                    if (p0 == 1.0f) {
                        frameLayout2.setVisibility(8);
                        return;
                    }
                    ViewGroup.LayoutParams layoutParams = frameLayout2.getLayoutParams();
                    int i = measuredHeight;
                    layoutParams.height = i - ((int) (i * p0));
                    frameLayout2.requestLayout();
                }
            };
            animation.setDuration(measuredHeight / frameLayout2.getContext().getResources().getDisplayMetrics().density);
            frameLayout2.startAnimation(animation);
        } else {
            viewCashierPromoBinding.lookAheadTest.animate().setDuration(200L).rotation(0.0f);
            FrameLayout frameLayout3 = viewCashierPromoBinding.PlaceComponentResult;
            Intrinsics.checkNotNullExpressionValue(frameLayout3, "");
            final FrameLayout frameLayout4 = frameLayout3;
            frameLayout4.measure(-1, -2);
            int measuredHeight2 = frameLayout4.getMeasuredHeight();
            frameLayout4.getLayoutParams().height = 0;
            frameLayout4.setVisibility(0);
            Animation animation2 = new Animation() { // from class: id.dana.cashier.view.CashierPromoView$expandAction$animation$1
                @Override // android.view.animation.Animation
                protected final void applyTransformation(float p0, Transformation p1) {
                    frameLayout4.getLayoutParams().height = -2;
                    frameLayout4.requestLayout();
                }
            };
            animation2.setDuration(measuredHeight2 / frameLayout4.getContext().getResources().getDisplayMetrics().density);
            frameLayout4.startAnimation(animation2);
        }
        cashierPromoView.lookAheadTest = !cashierPromoView.lookAheadTest;
    }

    @Override // id.dana.core.ui.BaseViewBindingRichView
    public final void setup() {
        getBinding().PlaceComponentResult.setOnClickListener(new View.OnClickListener() { // from class: id.dana.cashier.view.CashierPromoView$$ExternalSyntheticLambda2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                CashierPromoView.$r8$lambda$jdUFuLZ3mVUGT6_drCNRy8VSNeo(CashierPromoView.this, view);
            }
        });
        final ViewCashierPromoBinding binding = getBinding();
        binding.getErrorConfigVersion.setOnClickListener(new View.OnClickListener() { // from class: id.dana.cashier.view.CashierPromoView$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                CashierPromoView.$r8$lambda$mIM5I0OjrIf7BSAYDNxO5JB_bdE(CashierPromoView.this, binding, view);
            }
        });
    }
}
