package id.dana.cashier.view;

import android.content.Context;
import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.util.AttributeSet;
import android.view.View;
import android.widget.CompoundButton;
import com.ap.zoloz.hummer.biz.HummerConstants;
import com.ethanhua.skeleton.SkeletonScreen;
import com.ethanhua.skeleton.ViewSkeletonScreen;
import id.dana.R;
import id.dana.base.viewbinding.ViewBindingRichView;
import id.dana.cashier.CashierPaylaterTnCActivity;
import id.dana.cashier.model.QueryInstallmentModel;
import id.dana.danah5.DanaH5;
import id.dana.danah5.customdialog.CustomDialogKey;
import id.dana.databinding.ViewPaylaterAgreementBinding;
import id.dana.utils.ShimmeringUtil;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B'\b\u0016\u0012\u0006\u0010$\u001a\u00020#\u0012\n\b\u0002\u0010&\u001a\u0004\u0018\u00010%\u0012\b\b\u0002\u0010'\u001a\u00020\u0006¢\u0006\u0004\b(\u0010)B+\b\u0016\u0012\u0006\u0010$\u001a\u00020#\u0012\b\u0010&\u001a\u0004\u0018\u00010%\u0012\u0006\u0010*\u001a\u00020\u0006\u0012\u0006\u0010+\u001a\u00020\u0006¢\u0006\u0004\b(\u0010,J\r\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\r\u0010\t\u001a\u00020\u0003¢\u0006\u0004\b\t\u0010\u0005J\u0017\u0010\f\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\nH\u0014¢\u0006\u0004\b\f\u0010\rJ\u0015\u0010\u0010\u001a\u00020\u00032\u0006\u0010\u000f\u001a\u00020\u000e¢\u0006\u0004\b\u0010\u0010\u0011J!\u0010\u0014\u001a\u00020\u00032\u0012\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u00030\u0012¢\u0006\u0004\b\u0014\u0010\u0015J7\u0010\u001b\u001a\u00020\u00032\b\u0010\u0017\u001a\u0004\u0018\u00010\u00162\u000e\b\u0002\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00030\u00182\u000e\b\u0002\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00030\u0018¢\u0006\u0004\b\u001b\u0010\u001cJ\r\u0010\u001d\u001a\u00020\u0003¢\u0006\u0004\b\u001d\u0010\u0005R\u001e\u0010\"\u001a\n\u0012\u0004\u0012\u00020\u001f\u0018\u00010\u001e8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b \u0010!"}, d2 = {"Lid/dana/cashier/view/PaylaterAgreementView;", "Lid/dana/base/viewbinding/ViewBindingRichView;", "Lid/dana/databinding/ViewPaylaterAgreementBinding;", "", "dismissShimmerAgreement", "()V", "", "getLayout", "()I", "initPaylaterAgreementCheckbox", "Landroid/view/View;", "view", "initViewBinding", "(Landroid/view/View;)Lid/dana/databinding/ViewPaylaterAgreementBinding;", "", CustomDialogKey.Response.IS_CHECKED, "setCheckboxChecked", "(Z)V", "Lkotlin/Function1;", "onCheckboxChecked", "setOnCheckboxCheckedListener", "(Lkotlin/jvm/functions/Function1;)V", "Lid/dana/cashier/model/QueryInstallmentModel;", "queryInstallmentModel", "Lkotlin/Function0;", "onTrackLoanAgreement", "onTrackTnc", "setTncAgreementTextView", "(Lid/dana/cashier/model/QueryInstallmentModel;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;)V", "showShimmerAgreement", "", "Lcom/ethanhua/skeleton/SkeletonScreen;", "MyBillsEntityDataFactory", "Ljava/util/List;", "getAuthRequestContext", "Landroid/content/Context;", HummerConstants.CONTEXT, "Landroid/util/AttributeSet;", "attrs", "defStyleAttrs", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "defStyleAttr", "defStyleRes", "(Landroid/content/Context;Landroid/util/AttributeSet;II)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class PaylaterAgreementView extends ViewBindingRichView<ViewPaylaterAgreementBinding> {

    /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
    private List<? extends SkeletonScreen> getAuthRequestContext;
    public Map<Integer, View> _$_findViewCache;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public PaylaterAgreementView(Context context) {
        this(context, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(context, "");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public PaylaterAgreementView(Context context, AttributeSet attributeSet) {
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
        return R.layout.view_paylater_agreement;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PaylaterAgreementView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "");
        this._$_findViewCache = new LinkedHashMap();
    }

    public /* synthetic */ PaylaterAgreementView(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PaylaterAgreementView(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        Intrinsics.checkNotNullParameter(context, "");
        this._$_findViewCache = new LinkedHashMap();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // id.dana.base.viewbinding.ViewBindingRichView
    public final ViewPaylaterAgreementBinding initViewBinding(View view) {
        Intrinsics.checkNotNullParameter(view, "");
        ViewPaylaterAgreementBinding PlaceComponentResult = ViewPaylaterAgreementBinding.PlaceComponentResult(view);
        Intrinsics.checkNotNullExpressionValue(PlaceComponentResult, "");
        return PlaceComponentResult;
    }

    public final void setOnCheckboxCheckedListener(final Function1<? super Boolean, Unit> onCheckboxChecked) {
        Intrinsics.checkNotNullParameter(onCheckboxChecked, "");
        getBinding().PlaceComponentResult.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: id.dana.cashier.view.PaylaterAgreementView$$ExternalSyntheticLambda0
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                PaylaterAgreementView.$r8$lambda$VLdTqOFpTYMlMDqEES8JB6xZLSM(Function1.this, compoundButton, z);
            }
        });
    }

    public final void setCheckboxChecked(boolean isChecked) {
        getBinding().PlaceComponentResult.setChecked(isChecked);
    }

    public final void initPaylaterAgreementCheckbox() {
        getBinding().PlaceComponentResult.setChecked(true);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void setTncAgreementTextView$default(PaylaterAgreementView paylaterAgreementView, QueryInstallmentModel queryInstallmentModel, Function0 function0, Function0 function02, int i, Object obj) {
        if ((i & 2) != 0) {
            function0 = new Function0<Unit>() { // from class: id.dana.cashier.view.PaylaterAgreementView$setTncAgreementTextView$1
                /* renamed from: invoke  reason: avoid collision after fix types in other method */
                public final void invoke2() {
                }

                @Override // kotlin.jvm.functions.Function0
                public final /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }
            };
        }
        if ((i & 4) != 0) {
            function02 = new Function0<Unit>() { // from class: id.dana.cashier.view.PaylaterAgreementView$setTncAgreementTextView$2
                /* renamed from: invoke  reason: avoid collision after fix types in other method */
                public final void invoke2() {
                }

                @Override // kotlin.jvm.functions.Function0
                public final /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }
            };
        }
        paylaterAgreementView.setTncAgreementTextView(queryInstallmentModel, function0, function02);
    }

    /* JADX WARN: Code restructure failed: missing block: B:20:0x0039, code lost:
    
        if ((r4 != null && r4.getMyBillsEntityDataFactory()) != false) goto L21;
     */
    /* JADX WARN: Removed duplicated region for block: B:25:0x004d  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x004f  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x009e  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x00a0  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x00b3  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x00b6  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x00ba  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x00bc  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x00e7  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x00f8  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void setTncAgreementTextView(id.dana.cashier.model.QueryInstallmentModel r18, kotlin.jvm.functions.Function0<kotlin.Unit> r19, kotlin.jvm.functions.Function0<kotlin.Unit> r20) {
        /*
            Method dump skipped, instructions count: 291
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.cashier.view.PaylaterAgreementView.setTncAgreementTextView(id.dana.cashier.model.QueryInstallmentModel, kotlin.jvm.functions.Function0, kotlin.jvm.functions.Function0):void");
    }

    /* JADX WARN: Type inference failed for: r8v4, types: [id.dana.cashier.view.PaylaterAgreementView$setClickableSpan$3] */
    static /* synthetic */ PaylaterAgreementView$setClickableSpan$3 setClickableSpan$default(final PaylaterAgreementView paylaterAgreementView, String str, String str2, Function0 function0, Function0 function02, int i, Object obj) {
        final String str3 = (i & 1) != 0 ? "" : str;
        final String str4 = (i & 2) != 0 ? "" : str2;
        if ((i & 4) != 0) {
            function0 = new Function0<Unit>() { // from class: id.dana.cashier.view.PaylaterAgreementView$setClickableSpan$1
                /* renamed from: invoke  reason: avoid collision after fix types in other method */
                public final void invoke2() {
                }

                @Override // kotlin.jvm.functions.Function0
                public final /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }
            };
        }
        final Function0 function03 = function0;
        if ((i & 8) != 0) {
            function02 = new Function0<Unit>() { // from class: id.dana.cashier.view.PaylaterAgreementView$setClickableSpan$2
                /* renamed from: invoke  reason: avoid collision after fix types in other method */
                public final void invoke2() {
                }

                @Override // kotlin.jvm.functions.Function0
                public final /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }
            };
        }
        final Function0 function04 = function02;
        return new ClickableSpan() { // from class: id.dana.cashier.view.PaylaterAgreementView$setClickableSpan$3
            @Override // android.text.style.ClickableSpan
            public final void onClick(View p0) {
                Intrinsics.checkNotNullParameter(p0, "");
                if (str3.length() > 0) {
                    DanaH5.startContainerFullUrl(str3);
                    function03.invoke();
                    return;
                }
                if (str4.length() > 0) {
                    Context context = paylaterAgreementView.getContext();
                    String str5 = str4;
                    CashierPaylaterTnCActivity.Companion companion = CashierPaylaterTnCActivity.INSTANCE;
                    Intrinsics.checkNotNullExpressionValue(context, "");
                    context.startActivity(CashierPaylaterTnCActivity.Companion.PlaceComponentResult(context, str5));
                    function04.invoke();
                }
            }

            @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
            public final void updateDrawState(TextPaint p0) {
                Intrinsics.checkNotNullParameter(p0, "");
                super.updateDrawState(p0);
                p0.setUnderlineText(false);
            }
        };
    }

    public final void showShimmerAgreement() {
        List<ViewSkeletonScreen> MyBillsEntityDataFactory = ShimmeringUtil.MyBillsEntityDataFactory(MapsKt.hashMapOf(new Pair(getBinding().MyBillsEntityDataFactory, Integer.valueOf((int) R.layout.view_skeleton_paylater_agreement))), R.color.res_0x7f060349_networkuserentitydata_externalsyntheticlambda2);
        this.getAuthRequestContext = MyBillsEntityDataFactory;
        ShimmeringUtil.KClassImpl$Data$declaredNonStaticMembers$2(MyBillsEntityDataFactory);
    }

    public final void dismissShimmerAgreement() {
        ShimmeringUtil.getAuthRequestContext(this.getAuthRequestContext);
    }

    public static /* synthetic */ void $r8$lambda$VLdTqOFpTYMlMDqEES8JB6xZLSM(Function1 function1, CompoundButton compoundButton, boolean z) {
        Intrinsics.checkNotNullParameter(function1, "");
        function1.invoke(Boolean.valueOf(z));
    }
}
