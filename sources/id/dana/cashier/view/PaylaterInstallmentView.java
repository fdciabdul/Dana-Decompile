package id.dana.cashier.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.ap.zoloz.hummer.biz.HummerConstants;
import id.dana.R;
import id.dana.base.ThrottledOnItemClickListener;
import id.dana.base.viewbinding.ViewBindingRichView;
import id.dana.cashier.OnlineCreditType;
import id.dana.cashier.adapter.PaylaterInstallmentOptionAdapter;
import id.dana.cashier.model.RepaymentInfoModel;
import id.dana.cashier.model.RepaymentPlanModel;
import id.dana.core.ui.util.LocaleUtil;
import id.dana.databinding.ViewPaylaterInstallmentBinding;
import id.dana.nearbyme.merchantdetail.model.MoneyViewModel;
import id.dana.utils.ResourceUtils;
import java.text.NumberFormat;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmName;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 ;2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001;B'\b\u0016\u0012\u0006\u00102\u001a\u000201\u0012\n\b\u0002\u00104\u001a\u0004\u0018\u000103\u0012\b\b\u0002\u00105\u001a\u00020\u0003¢\u0006\u0004\b6\u00107B+\b\u0016\u0012\u0006\u00102\u001a\u000201\u0012\b\u00104\u001a\u0004\u0018\u000103\u0012\u0006\u00108\u001a\u00020\u0003\u0012\u0006\u00109\u001a\u00020\u0003¢\u0006\u0004\b6\u0010:J\u000f\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0004\u0010\u0005J\u0017\u0010\b\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0006H\u0014¢\u0006\u0004\b\b\u0010\tJ\u001f\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\fH\u0002¢\u0006\u0004\b\u000f\u0010\u0010J\u0017\u0010\u0012\u001a\u00020\u000e2\u0006\u0010\u000b\u001a\u00020\u0011H\u0002¢\u0006\u0004\b\u0012\u0010\u0013J\u0015\u0010\u0016\u001a\u00020\u000e2\u0006\u0010\u0015\u001a\u00020\u0014¢\u0006\u0004\b\u0016\u0010\u0017J\u001b\u0010\u001a\u001a\u00020\u000e2\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\f0\u0018¢\u0006\u0004\b\u001a\u0010\u001bJ\u000f\u0010\u001c\u001a\u00020\u000eH\u0016¢\u0006\u0004\b\u001c\u0010\u001dR\"\u0010\"\u001a\u00020\u00148\u0007@\u0007X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0012\u0010\u001e\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\u0017R\"\u0010\u0015\u001a\u00020\u00148\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b#\u0010\u001e\u001a\u0004\b$\u0010 \"\u0004\b%\u0010\u0017R\u0016\u0010\u000f\u001a\u00020\n8\u0002@\u0002X\u0083.¢\u0006\u0006\n\u0004\b&\u0010'R.\u0010/\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u000e0(8\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b)\u0010*\u001a\u0004\b+\u0010,\"\u0004\b-\u0010.R\u0018\u0010#\u001a\u0004\u0018\u00010\f8\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\b\u000f\u00100"}, d2 = {"Lid/dana/cashier/view/PaylaterInstallmentView;", "Lid/dana/base/viewbinding/ViewBindingRichView;", "Lid/dana/databinding/ViewPaylaterInstallmentBinding;", "", "getLayout", "()I", "Landroid/view/View;", "view", "initViewBinding", "(Landroid/view/View;)Lid/dana/databinding/ViewPaylaterInstallmentBinding;", "Lid/dana/cashier/adapter/PaylaterInstallmentOptionAdapter;", "p0", "Lid/dana/cashier/model/RepaymentPlanModel;", "p1", "", "MyBillsEntityDataFactory", "(Lid/dana/cashier/adapter/PaylaterInstallmentOptionAdapter;Lid/dana/cashier/model/RepaymentPlanModel;)V", "Lid/dana/nearbyme/merchantdetail/model/MoneyViewModel;", "PlaceComponentResult", "(Lid/dana/nearbyme/merchantdetail/model/MoneyViewModel;)V", "", "channelIndex", "setChannelIdx", "(Ljava/lang/String;)V", "", "repaymentPlans", "setInstallmentOptionItems", "(Ljava/util/List;)V", "setup", "()V", "Ljava/lang/String;", "getAdditionalInfo", "()Ljava/lang/String;", "setAdditionalInfo", "additionalInfo", "BuiltInFictitiousFunctionClassFactory", "getChannelIndex", "setChannelIndex", "getAuthRequestContext", "Lid/dana/cashier/adapter/PaylaterInstallmentOptionAdapter;", "Lkotlin/Function1;", "KClassImpl$Data$declaredNonStaticMembers$2", "Lkotlin/jvm/functions/Function1;", "getOnInstallmentOptionClicked", "()Lkotlin/jvm/functions/Function1;", "setOnInstallmentOptionClicked", "(Lkotlin/jvm/functions/Function1;)V", "onInstallmentOptionClicked", "Lid/dana/cashier/model/RepaymentPlanModel;", "Landroid/content/Context;", HummerConstants.CONTEXT, "Landroid/util/AttributeSet;", "attrs", "defStyleAttrs", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "defStyleAttr", "defStyleRes", "(Landroid/content/Context;Landroid/util/AttributeSet;II)V", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class PaylaterInstallmentView extends ViewBindingRichView<ViewPaylaterInstallmentBinding> {
    public static final String AMOUNT_AND_INTEREST = "%@";

    /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
    private String channelIndex;

    /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
    private Function1<? super RepaymentPlanModel, Unit> onInstallmentOptionClicked;

    /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
    private RepaymentPlanModel BuiltInFictitiousFunctionClassFactory;

    /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
    private String additionalInfo;
    public Map<Integer, View> _$_findViewCache;

    /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
    private PaylaterInstallmentOptionAdapter MyBillsEntityDataFactory;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public PaylaterInstallmentView(Context context) {
        this(context, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(context, "");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public PaylaterInstallmentView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        Intrinsics.checkNotNullParameter(context, "");
    }

    @Override // id.dana.base.viewbinding.ViewBindingRichView
    public final void _$_clearFindViewByIdCache() {
        this._$_findViewCache.clear();
    }

    @Override // id.dana.base.viewbinding.ViewBindingRichView
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

    @Override // id.dana.base.BaseRichView
    public final int getLayout() {
        return R.layout.view_paylater_installment;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PaylaterInstallmentView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "");
        this._$_findViewCache = new LinkedHashMap();
        this.channelIndex = "";
        this.additionalInfo = "";
        this.onInstallmentOptionClicked = PaylaterInstallmentView$onInstallmentOptionClicked$1.INSTANCE;
    }

    public /* synthetic */ PaylaterInstallmentView(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PaylaterInstallmentView(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        Intrinsics.checkNotNullParameter(context, "");
        this._$_findViewCache = new LinkedHashMap();
        this.channelIndex = "";
        this.additionalInfo = "";
        this.onInstallmentOptionClicked = PaylaterInstallmentView$onInstallmentOptionClicked$1.INSTANCE;
    }

    @JvmName(name = "getChannelIndex")
    public final String getChannelIndex() {
        return this.channelIndex;
    }

    @JvmName(name = "setChannelIndex")
    public final void setChannelIndex(String str) {
        Intrinsics.checkNotNullParameter(str, "");
        this.channelIndex = str;
    }

    @JvmName(name = "getAdditionalInfo")
    public final String getAdditionalInfo() {
        return this.additionalInfo;
    }

    @JvmName(name = "setAdditionalInfo")
    public final void setAdditionalInfo(String str) {
        Intrinsics.checkNotNullParameter(str, "");
        this.additionalInfo = str;
    }

    @JvmName(name = "getOnInstallmentOptionClicked")
    public final Function1<RepaymentPlanModel, Unit> getOnInstallmentOptionClicked() {
        return this.onInstallmentOptionClicked;
    }

    @JvmName(name = "setOnInstallmentOptionClicked")
    public final void setOnInstallmentOptionClicked(Function1<? super RepaymentPlanModel, Unit> function1) {
        Intrinsics.checkNotNullParameter(function1, "");
        this.onInstallmentOptionClicked = function1;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // id.dana.base.viewbinding.ViewBindingRichView
    public final ViewPaylaterInstallmentBinding initViewBinding(View view) {
        Intrinsics.checkNotNullParameter(view, "");
        ViewPaylaterInstallmentBinding MyBillsEntityDataFactory = ViewPaylaterInstallmentBinding.MyBillsEntityDataFactory(view);
        Intrinsics.checkNotNullExpressionValue(MyBillsEntityDataFactory, "");
        return MyBillsEntityDataFactory;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void MyBillsEntityDataFactory(final PaylaterInstallmentOptionAdapter p0, RepaymentPlanModel p1) {
        RepaymentPlanModel repaymentPlanModel = this.BuiltInFictitiousFunctionClassFactory;
        if (repaymentPlanModel != null) {
            repaymentPlanModel.PlaceComponentResult = false;
        }
        p1.PlaceComponentResult = true;
        this.BuiltInFictitiousFunctionClassFactory = p1;
        List<RepaymentInfoModel> list = p1.MyBillsEntityDataFactory;
        PaylaterInstallmentSimulationView paylaterInstallmentSimulationView = getBinding().moveToNextValue;
        Intrinsics.checkNotNullExpressionValue(paylaterInstallmentSimulationView, "");
        paylaterInstallmentSimulationView.setVisibility(Intrinsics.areEqual(this.channelIndex, OnlineCreditType.ONLINE_CREDIT_AKULAKU) ? 0 : 8);
        paylaterInstallmentSimulationView.setInstallmentSimulationItems(list);
        MoneyViewModel moneyViewModel = p1.MyBillsEntityDataFactory.get(0).KClassImpl$Data$declaredNonStaticMembers$2;
        if (moneyViewModel != null) {
            PlaceComponentResult(moneyViewModel);
        }
        this.onInstallmentOptionClicked.invoke(p1);
        getBinding().PlaceComponentResult.post(new Runnable() { // from class: id.dana.cashier.view.PaylaterInstallmentView$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                PaylaterInstallmentView.$r8$lambda$WGjaRo9x7UHCFgUWOfUz3r4BXqM(PaylaterInstallmentOptionAdapter.this);
            }
        });
    }

    private final void PlaceComponentResult(MoneyViewModel p0) {
        String format;
        LinearLayout linearLayout = getBinding().BuiltInFictitiousFunctionClassFactory;
        Intrinsics.checkNotNullExpressionValue(linearLayout, "");
        linearLayout.setVisibility(StringsKt.isBlank(this.additionalInfo) ^ true ? 0 : 8);
        if (Intrinsics.areEqual(this.channelIndex, OnlineCreditType.ONLINE_CREDIT_ADAKAMI)) {
            AppCompatTextView appCompatTextView = getBinding().getAuthRequestContext;
            Context context = getContext();
            Intrinsics.checkNotNullExpressionValue(context, "");
            String str = this.additionalInfo;
            String PlaceComponentResult = ResourceUtils.PlaceComponentResult(context, str, str);
            StringBuilder sb = new StringBuilder();
            sb.append(p0.KClassImpl$Data$declaredNonStaticMembers$2);
            format = NumberFormat.getNumberInstance(LocaleUtil.BuiltInFictitiousFunctionClassFactory()).format(p0.MyBillsEntityDataFactory());
            sb.append(format != null ? format : "");
            appCompatTextView.setText(StringsKt.replace$default(PlaceComponentResult, AMOUNT_AND_INTEREST, sb.toString(), false, 4, (Object) null));
            return;
        }
        AppCompatTextView appCompatTextView2 = getBinding().getAuthRequestContext;
        Context context2 = getContext();
        Intrinsics.checkNotNullExpressionValue(context2, "");
        String str2 = this.additionalInfo;
        appCompatTextView2.setText(ResourceUtils.PlaceComponentResult(context2, str2, str2));
    }

    public final void setInstallmentOptionItems(List<RepaymentPlanModel> repaymentPlans) {
        Intrinsics.checkNotNullParameter(repaymentPlans, "");
        PaylaterInstallmentOptionAdapter paylaterInstallmentOptionAdapter = this.MyBillsEntityDataFactory;
        PaylaterInstallmentOptionAdapter paylaterInstallmentOptionAdapter2 = null;
        if (paylaterInstallmentOptionAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            paylaterInstallmentOptionAdapter = null;
        }
        paylaterInstallmentOptionAdapter.setItems(repaymentPlans);
        PaylaterInstallmentOptionAdapter paylaterInstallmentOptionAdapter3 = this.MyBillsEntityDataFactory;
        if (paylaterInstallmentOptionAdapter3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
        } else {
            paylaterInstallmentOptionAdapter2 = paylaterInstallmentOptionAdapter3;
        }
        paylaterInstallmentOptionAdapter2.notifyDataSetChanged();
    }

    public final void setChannelIdx(String channelIndex) {
        Intrinsics.checkNotNullParameter(channelIndex, "");
        this.channelIndex = channelIndex;
    }

    public static /* synthetic */ void $r8$lambda$WGjaRo9x7UHCFgUWOfUz3r4BXqM(PaylaterInstallmentOptionAdapter paylaterInstallmentOptionAdapter) {
        Intrinsics.checkNotNullParameter(paylaterInstallmentOptionAdapter, "");
        paylaterInstallmentOptionAdapter.notifyDataSetChanged();
    }

    public static final /* synthetic */ void access$onClickInstallmentOption(PaylaterInstallmentView paylaterInstallmentView, PaylaterInstallmentOptionAdapter paylaterInstallmentOptionAdapter, int i) {
        RepaymentPlanModel item = paylaterInstallmentOptionAdapter.getItem(i);
        Intrinsics.checkNotNullExpressionValue(item, "");
        paylaterInstallmentView.MyBillsEntityDataFactory(paylaterInstallmentOptionAdapter, item);
    }

    @Override // id.dana.base.BaseRichView
    public final void setup() {
        RecyclerView recyclerView = getBinding().PlaceComponentResult;
        final PaylaterInstallmentOptionAdapter paylaterInstallmentOptionAdapter = new PaylaterInstallmentOptionAdapter();
        recyclerView.setAdapter(paylaterInstallmentOptionAdapter);
        paylaterInstallmentOptionAdapter.setOnItemClickListener(new ThrottledOnItemClickListener(300L, new Function1<Integer, Unit>() { // from class: id.dana.cashier.view.PaylaterInstallmentView$getOnItemClickListener$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final /* synthetic */ Unit invoke(Integer num) {
                invoke(num.intValue());
                return Unit.INSTANCE;
            }

            public final void invoke(int i) {
                PaylaterInstallmentView.access$onClickInstallmentOption(PaylaterInstallmentView.this, paylaterInstallmentOptionAdapter, i);
            }
        }));
        paylaterInstallmentOptionAdapter.PlaceComponentResult = new Function1<RepaymentPlanModel, Unit>() { // from class: id.dana.cashier.view.PaylaterInstallmentView$initInstallmentOptionRecyclerView$1$1$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final /* bridge */ /* synthetic */ Unit invoke(RepaymentPlanModel repaymentPlanModel) {
                invoke2(repaymentPlanModel);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(RepaymentPlanModel repaymentPlanModel) {
                Intrinsics.checkNotNullParameter(repaymentPlanModel, "");
                PaylaterInstallmentView.this.MyBillsEntityDataFactory(paylaterInstallmentOptionAdapter, repaymentPlanModel);
            }
        };
        this.MyBillsEntityDataFactory = paylaterInstallmentOptionAdapter;
        recyclerView.setLayoutManager(new GridLayoutManager(recyclerView.getContext(), 3));
        recyclerView.addItemDecoration(new InstallmentItemDecoration(recyclerView.getContext()));
        PaylaterInstallmentSimulationView paylaterInstallmentSimulationView = getBinding().moveToNextValue;
        Intrinsics.checkNotNullExpressionValue(paylaterInstallmentSimulationView, "");
        paylaterInstallmentSimulationView.setVisibility(8);
        LinearLayout linearLayout = getBinding().BuiltInFictitiousFunctionClassFactory;
        Intrinsics.checkNotNullExpressionValue(linearLayout, "");
        linearLayout.setVisibility(8);
    }
}
