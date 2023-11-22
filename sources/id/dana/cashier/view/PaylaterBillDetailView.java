package id.dana.cashier.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.ap.zoloz.hummer.biz.HummerConstants;
import com.ethanhua.skeleton.SkeletonScreen;
import com.ethanhua.skeleton.ViewSkeletonScreen;
import id.dana.R;
import id.dana.base.viewbinding.ViewBindingRichView;
import id.dana.cashier.adapter.PaylaterBillDetailAdapter;
import id.dana.cashier.model.PaylaterBillDetailModel;
import id.dana.cashier.model.RepaymentInfoModel;
import id.dana.cashier.model.RepaymentPlanModel;
import id.dana.databinding.ViewPaylaterBillDetailBinding;
import id.dana.extension.view.ViewExtKt;
import id.dana.utils.DateTimeUtil;
import id.dana.utils.ShimmeringUtil;
import id.dana.utils.foundation.logger.log.DanaLog;
import id.dana.utils.foundation.logger.log.DanaLogConstants;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 22\b\u0012\u0004\u0012\u00020\u00020\u0001:\u00012B'\b\u0016\u0012\u0006\u0010)\u001a\u00020(\u0012\n\b\u0002\u0010+\u001a\u0004\u0018\u00010*\u0012\b\b\u0002\u0010,\u001a\u00020\u0006¢\u0006\u0004\b-\u0010.B+\b\u0016\u0012\u0006\u0010)\u001a\u00020(\u0012\b\u0010+\u001a\u0004\u0018\u00010*\u0012\u0006\u0010/\u001a\u00020\u0006\u0012\u0006\u00100\u001a\u00020\u0006¢\u0006\u0004\b-\u00101J\r\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\u000b\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\tH\u0014¢\u0006\u0004\b\u000b\u0010\fJ\u001d\u0010\u0010\u001a\u00020\u00032\u000e\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\r¢\u0006\u0004\b\u0010\u0010\u0011J\u000f\u0010\u0012\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0012\u0010\u0005J\u001d\u0010\u0017\u001a\u00020\u00032\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0016\u001a\u00020\u0015¢\u0006\u0004\b\u0017\u0010\u0018J\r\u0010\u0019\u001a\u00020\u0003¢\u0006\u0004\b\u0019\u0010\u0005R\u0018\u0010\u001d\u001a\u0004\u0018\u00010\u001a8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001b\u0010\u001cR\u001e\u0010!\u001a\n\u0012\u0004\u0012\u00020\u001e\u0018\u00010\r8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001f\u0010 R\"\u0010$\u001a\u00020\u00138\u0007@\u0007X\u0086\u000e¢\u0006\u0012\n\u0004\b\"\u0010#\u001a\u0004\b$\u0010%\"\u0004\b&\u0010'"}, d2 = {"Lid/dana/cashier/view/PaylaterBillDetailView;", "Lid/dana/base/viewbinding/ViewBindingRichView;", "Lid/dana/databinding/ViewPaylaterBillDetailBinding;", "", "dismissShimmerBillDetail", "()V", "", "getLayout", "()I", "Landroid/view/View;", "view", "initViewBinding", "(Landroid/view/View;)Lid/dana/databinding/ViewPaylaterBillDetailBinding;", "", "Lid/dana/cashier/model/RepaymentPlanModel;", "repaymentPlan", "setItemBillDetail", "(Ljava/util/List;)V", "setup", "", "isInterestFeeZero", "", "ribbonText", "showPaylaterPromoRibbon", "(ZLjava/lang/String;)V", "showShimmerBillDetail", "Lid/dana/cashier/adapter/PaylaterBillDetailAdapter;", "getAuthRequestContext", "Lid/dana/cashier/adapter/PaylaterBillDetailAdapter;", "PlaceComponentResult", "Lcom/ethanhua/skeleton/SkeletonScreen;", "MyBillsEntityDataFactory", "Ljava/util/List;", "BuiltInFictitiousFunctionClassFactory", "KClassImpl$Data$declaredNonStaticMembers$2", "Z", "isShowPaylaterPromoRibbon", "()Z", "setShowPaylaterPromoRibbon", "(Z)V", "Landroid/content/Context;", HummerConstants.CONTEXT, "Landroid/util/AttributeSet;", "attrs", "defStyleAttrs", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "defStyleAttr", "defStyleRes", "(Landroid/content/Context;Landroid/util/AttributeSet;II)V", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class PaylaterBillDetailView extends ViewBindingRichView<ViewPaylaterBillDetailBinding> {

    /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
    private boolean isShowPaylaterPromoRibbon;

    /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
    private List<? extends SkeletonScreen> BuiltInFictitiousFunctionClassFactory;
    public Map<Integer, View> _$_findViewCache;

    /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
    private PaylaterBillDetailAdapter PlaceComponentResult;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public PaylaterBillDetailView(Context context) {
        this(context, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(context, "");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public PaylaterBillDetailView(Context context, AttributeSet attributeSet) {
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
        return R.layout.view_paylater_bill_detail;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PaylaterBillDetailView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "");
        this._$_findViewCache = new LinkedHashMap();
    }

    public /* synthetic */ PaylaterBillDetailView(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PaylaterBillDetailView(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        Intrinsics.checkNotNullParameter(context, "");
        this._$_findViewCache = new LinkedHashMap();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // id.dana.base.viewbinding.ViewBindingRichView
    public final ViewPaylaterBillDetailBinding initViewBinding(View view) {
        Intrinsics.checkNotNullParameter(view, "");
        ViewPaylaterBillDetailBinding authRequestContext = ViewPaylaterBillDetailBinding.getAuthRequestContext(view);
        Intrinsics.checkNotNullExpressionValue(authRequestContext, "");
        return authRequestContext;
    }

    @JvmName(name = "isShowPaylaterPromoRibbon")
    /* renamed from: isShowPaylaterPromoRibbon  reason: from getter */
    public final boolean getIsShowPaylaterPromoRibbon() {
        return this.isShowPaylaterPromoRibbon;
    }

    @JvmName(name = "setShowPaylaterPromoRibbon")
    public final void setShowPaylaterPromoRibbon(boolean z) {
        this.isShowPaylaterPromoRibbon = z;
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x002a  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x002c  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x003c  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x003e  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0041  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x006c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void showPaylaterPromoRibbon(boolean r7, java.lang.String r8) {
        /*
            r6 = this;
            java.lang.String r0 = ""
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r8, r0)
            androidx.viewbinding.ViewBinding r1 = r6.getBinding()
            id.dana.databinding.ViewPaylaterBillDetailBinding r1 = (id.dana.databinding.ViewPaylaterBillDetailBinding) r1
            androidx.appcompat.widget.AppCompatTextView r1 = r1.NetworkUserEntityData$$ExternalSyntheticLambda0
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r0)
            r2 = r1
            android.view.View r2 = (android.view.View) r2
            r3 = 1
            r4 = 0
            if (r7 == 0) goto L27
            r7 = r8
            java.lang.CharSequence r7 = (java.lang.CharSequence) r7
            int r7 = r7.length()
            if (r7 <= 0) goto L22
            r7 = 1
            goto L23
        L22:
            r7 = 0
        L23:
            if (r7 == 0) goto L27
            r7 = 1
            goto L28
        L27:
            r7 = 0
        L28:
            if (r7 == 0) goto L2c
            r7 = 0
            goto L2e
        L2c:
            r7 = 8
        L2e:
            r2.setVisibility(r7)
            java.lang.CharSequence r8 = (java.lang.CharSequence) r8
            r1.setText(r8)
            int r7 = r2.getVisibility()
            if (r7 != 0) goto L3e
            r7 = 1
            goto L3f
        L3e:
            r7 = 0
        L3f:
            if (r7 == 0) goto L65
            androidx.viewbinding.ViewBinding r7 = r6.getBinding()
            id.dana.databinding.ViewPaylaterBillDetailBinding r7 = (id.dana.databinding.ViewPaylaterBillDetailBinding) r7
            android.widget.LinearLayout r7 = r7.BuiltInFictitiousFunctionClassFactory
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r7, r0)
            android.view.View r7 = (android.view.View) r7
            r8 = 1098907648(0x41800000, float:16.0)
            java.lang.Float r0 = java.lang.Float.valueOf(r8)
            r1 = 1090519040(0x41000000, float:8.0)
            java.lang.Float r1 = java.lang.Float.valueOf(r1)
            java.lang.Float r5 = java.lang.Float.valueOf(r8)
            java.lang.Float r8 = java.lang.Float.valueOf(r8)
            id.dana.extension.view.ViewExtKt.MyBillsEntityDataFactory(r7, r0, r1, r5, r8)
        L65:
            int r7 = r2.getVisibility()
            if (r7 != 0) goto L6c
            goto L6d
        L6c:
            r3 = 0
        L6d:
            r6.isShowPaylaterPromoRibbon = r3
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.cashier.view.PaylaterBillDetailView.showPaylaterPromoRibbon(boolean, java.lang.String):void");
    }

    public final void setItemBillDetail(List<RepaymentPlanModel> repaymentPlan) {
        RepaymentPlanModel repaymentPlanModel;
        String str;
        Locale locale;
        Date parse;
        Locale locale2;
        ArrayList arrayList = new ArrayList();
        if (repaymentPlan != null) {
            try {
                List<RepaymentPlanModel> list = repaymentPlan.isEmpty() ^ true ? repaymentPlan : null;
                if (list != null && (repaymentPlanModel = (RepaymentPlanModel) CollectionsKt.firstOrNull((List) list)) != null) {
                    List<RepaymentInfoModel> list2 = repaymentPlanModel.MyBillsEntityDataFactory;
                    if ((!list2.isEmpty()) == false) {
                        list2 = null;
                    }
                    if (list2 != null) {
                        int i = 0;
                        for (Object obj : list2) {
                            int i2 = i + 1;
                            if (i < 0) {
                                CollectionsKt.throwIndexOverflow();
                            }
                            RepaymentInfoModel repaymentInfoModel = (RepaymentInfoModel) obj;
                            String str2 = repaymentInfoModel.scheduleImpl;
                            if (!(str2.length() > 0)) {
                                str2 = null;
                            }
                            if (str2 != null) {
                                locale = Locale.getDefault();
                                parse = new SimpleDateFormat("yyyy-MM-dd", locale).parse(str2);
                                locale2 = Locale.getDefault();
                                str = DateTimeUtil.MyBillsEntityDataFactory(parse, "dd MMM yyyy", locale2);
                            } else {
                                str = null;
                            }
                            if (str == null) {
                                str = "";
                            }
                            String string = getContext().getString(R.string.paylater_bill, String.valueOf(i2));
                            Intrinsics.checkNotNullExpressionValue(string, "");
                            String string2 = getContext().getString(R.string.paylater_due_date, str);
                            Intrinsics.checkNotNullExpressionValue(string2, "");
                            arrayList.add(new PaylaterBillDetailModel(string, string2, repaymentInfoModel.getAuthRequestContext, 0, 0, 24, null));
                            i = i2;
                        }
                    }
                }
            } catch (Exception e) {
                StringBuilder sb = new StringBuilder();
                sb.append("[LoanCredit]: cashier_native_fail");
                sb.append(e.getMessage());
                DanaLog.BuiltInFictitiousFunctionClassFactory(DanaLogConstants.TAG.PAYLATER_BILL_DETAIL_VIEW, sb.toString(), e);
            }
        }
        PaylaterBillDetailAdapter paylaterBillDetailAdapter = new PaylaterBillDetailAdapter();
        this.PlaceComponentResult = paylaterBillDetailAdapter;
        paylaterBillDetailAdapter.setItems(arrayList);
        getBinding().getAuthRequestContext.setAdapter(this.PlaceComponentResult);
    }

    public final void showShimmerBillDetail() {
        List<ViewSkeletonScreen> MyBillsEntityDataFactory = ShimmeringUtil.MyBillsEntityDataFactory(MapsKt.hashMapOf(new Pair(getBinding().BuiltInFictitiousFunctionClassFactory, Integer.valueOf((int) R.layout.view_skeleton_paylater_bill_detail))), R.color.res_0x7f060349_networkuserentitydata_externalsyntheticlambda2);
        this.BuiltInFictitiousFunctionClassFactory = MyBillsEntityDataFactory;
        ShimmeringUtil.KClassImpl$Data$declaredNonStaticMembers$2(MyBillsEntityDataFactory);
    }

    public final void dismissShimmerBillDetail() {
        ShimmeringUtil.getAuthRequestContext(this.BuiltInFictitiousFunctionClassFactory);
    }

    @Override // id.dana.base.BaseRichView
    public final void setup() {
        RecyclerView recyclerView = getBinding().getAuthRequestContext;
        recyclerView.setLayoutManager(new LinearLayoutManager(recyclerView.getContext(), 1, false));
        recyclerView.setOverScrollMode(2);
        LinearLayout linearLayout = getBinding().BuiltInFictitiousFunctionClassFactory;
        Intrinsics.checkNotNullExpressionValue(linearLayout, "");
        Float valueOf = Float.valueOf(16.0f);
        ViewExtKt.MyBillsEntityDataFactory(linearLayout, valueOf, valueOf, valueOf, valueOf);
    }
}
