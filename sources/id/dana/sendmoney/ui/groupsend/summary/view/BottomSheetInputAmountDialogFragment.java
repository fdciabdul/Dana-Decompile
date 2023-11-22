package id.dana.sendmoney.ui.groupsend.summary.view;

import android.app.Dialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.FrameLayout;
import id.dana.core.ui.BaseViewBindingBottomSheetDialogFragment;
import id.dana.core.ui.BaseViewBindingBottomSheetDialogFragment$$ExternalSyntheticLambda2;
import id.dana.core.ui.model.CurrencyAmountModel;
import id.dana.core.ui.richview.NumpadView;
import id.dana.sendmoney.R;
import id.dana.sendmoney.databinding.BottomSheetInputAmountDialogBinding;
import id.dana.sendmoney.ui.groupsend.summary.view.GroupSendInputAmountView;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u000f\u0018\u0000 +2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001+BS\u0012\b\b\u0002\u0010\"\u001a\u00020\u001c\u0012\u0006\u0010#\u001a\u00020\u000e\u0012\u0006\u0010$\u001a\u00020\u000e\u0012\u0006\u0010%\u001a\u00020\u000e\u0012\u0006\u0010&\u001a\u00020\u000e\u0012\u0006\u0010'\u001a\u00020\u0011\u0012\u0018\u0010(\u001a\u0014\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\t0\u0016¢\u0006\u0004\b)\u0010*J\u000f\u0010\u0004\u001a\u00020\u0003H\u0014¢\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\u0007\u001a\u00020\u0006H\u0014¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\n\u001a\u00020\tH\u0014¢\u0006\u0004\b\n\u0010\u000bJ\u000f\u0010\f\u001a\u00020\tH\u0014¢\u0006\u0004\b\f\u0010\u000bJ\u000f\u0010\r\u001a\u00020\tH\u0016¢\u0006\u0004\b\r\u0010\u000bR\u0014\u0010\f\u001a\u00020\u000e8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u0014\u0010\u000f\u001a\u00020\u00118\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\f\u0010\u0012R\u0014\u0010\n\u001a\u00020\u000e8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\u0010R\u0016\u0010\u0004\u001a\u00020\u00138\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015R&\u0010\u0007\u001a\u0014\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\t0\u00168\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u0014\u0010\u001b\u001a\u00020\u000e8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001a\u0010\u0010R\u0014\u0010\u001f\u001a\u00020\u001c8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\u0014\u0010!\u001a\u00020\u000e8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b \u0010\u0010"}, d2 = {"Lid/dana/sendmoney/ui/groupsend/summary/view/BottomSheetInputAmountDialogFragment;", "Lid/dana/core/ui/BaseViewBindingBottomSheetDialogFragment;", "Lid/dana/sendmoney/databinding/BottomSheetInputAmountDialogBinding;", "", "BuiltInFictitiousFunctionClassFactory", "()F", "Landroid/view/View;", "KClassImpl$Data$declaredNonStaticMembers$2", "()Landroid/view/View;", "", "getAuthRequestContext", "()V", "MyBillsEntityDataFactory", "onStart", "Lid/dana/core/ui/model/CurrencyAmountModel;", "PlaceComponentResult", "Lid/dana/core/ui/model/CurrencyAmountModel;", "", "I", "", "initRecordTimeStamp", "Ljava/lang/String;", "Lkotlin/Function2;", "", "NetworkUserEntityData$$ExternalSyntheticLambda2", "Lkotlin/jvm/functions/Function2;", "GetContactSyncConfig", "lookAheadTest", "", "DatabaseTableConfigUtil", "J", "NetworkUserEntityData$$ExternalSyntheticLambda0", "NetworkUserEntityData$$ExternalSyntheticLambda1", "getErrorConfigVersion", "p0", "p1", "p2", "p3", "p4", "p5", "p6", "<init>", "(JLid/dana/core/ui/model/CurrencyAmountModel;Lid/dana/core/ui/model/CurrencyAmountModel;Lid/dana/core/ui/model/CurrencyAmountModel;Lid/dana/core/ui/model/CurrencyAmountModel;ILkotlin/jvm/functions/Function2;)V", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class BottomSheetInputAmountDialogFragment extends BaseViewBindingBottomSheetDialogFragment<BottomSheetInputAmountDialogBinding> {

    /* renamed from: DatabaseTableConfigUtil  reason: from kotlin metadata */
    private final long NetworkUserEntityData$$ExternalSyntheticLambda0;

    /* renamed from: GetContactSyncConfig  reason: from kotlin metadata */
    private final CurrencyAmountModel lookAheadTest;

    /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
    private final CurrencyAmountModel getAuthRequestContext;

    /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
    private final int PlaceComponentResult;

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda1  reason: from kotlin metadata */
    private final CurrencyAmountModel getErrorConfigVersion;

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda2  reason: from kotlin metadata */
    private final Function2<String, Boolean, Unit> KClassImpl$Data$declaredNonStaticMembers$2;

    /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
    private final CurrencyAmountModel MyBillsEntityDataFactory;

    /* renamed from: initRecordTimeStamp  reason: from kotlin metadata */
    private String BuiltInFictitiousFunctionClassFactory;

    @Override // id.dana.core.ui.BaseViewBindingBottomSheetDialogFragment
    public final float BuiltInFictitiousFunctionClassFactory() {
        return 0.48f;
    }

    @Override // id.dana.core.ui.BaseViewBindingBottomSheetDialogFragment
    public final /* synthetic */ BottomSheetInputAmountDialogBinding BuiltInFictitiousFunctionClassFactory(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        Intrinsics.checkNotNullParameter(layoutInflater, "");
        BottomSheetInputAmountDialogBinding MyBillsEntityDataFactory = BottomSheetInputAmountDialogBinding.MyBillsEntityDataFactory(layoutInflater, viewGroup);
        Intrinsics.checkNotNullExpressionValue(MyBillsEntityDataFactory, "");
        return MyBillsEntityDataFactory;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public BottomSheetInputAmountDialogFragment(long j, CurrencyAmountModel currencyAmountModel, CurrencyAmountModel currencyAmountModel2, CurrencyAmountModel currencyAmountModel3, CurrencyAmountModel currencyAmountModel4, int i, Function2<? super String, ? super Boolean, Unit> function2) {
        Intrinsics.checkNotNullParameter(currencyAmountModel, "");
        Intrinsics.checkNotNullParameter(currencyAmountModel2, "");
        Intrinsics.checkNotNullParameter(currencyAmountModel3, "");
        Intrinsics.checkNotNullParameter(currencyAmountModel4, "");
        Intrinsics.checkNotNullParameter(function2, "");
        this.NetworkUserEntityData$$ExternalSyntheticLambda0 = j;
        this.getAuthRequestContext = currencyAmountModel;
        this.MyBillsEntityDataFactory = currencyAmountModel2;
        this.getErrorConfigVersion = currencyAmountModel3;
        this.lookAheadTest = currencyAmountModel4;
        this.PlaceComponentResult = i;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = function2;
        this.BuiltInFictitiousFunctionClassFactory = "";
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public final void onStart() {
        super.onStart();
        Dialog dialog = getDialog();
        if (dialog != null) {
            View getAuthRequestContext = getGetAuthRequestContext();
            if (getAuthRequestContext != null) {
                getAuthRequestContext.post(new BaseViewBindingBottomSheetDialogFragment$$ExternalSyntheticLambda2(getAuthRequestContext, this));
            }
            MyBillsEntityDataFactory(dialog);
        }
    }

    @Override // id.dana.core.ui.BaseViewBindingBottomSheetDialogFragment
    public final void MyBillsEntityDataFactory() {
        super.MyBillsEntityDataFactory();
        Dialog dialog = getDialog();
        if (dialog != null) {
            a_(PlaceComponentResult(dialog));
        }
    }

    @Override // id.dana.core.ui.BaseViewBindingBottomSheetDialogFragment
    public final void getAuthRequestContext() {
        super.getAuthRequestContext();
        VB vb = this.MyBillsEntityDataFactory;
        if (vb != 0) {
            GroupSendInputAmountView groupSendInputAmountView = ((BottomSheetInputAmountDialogBinding) vb).getErrorConfigVersion;
            groupSendInputAmountView.setPrefixedAmount(this.NetworkUserEntityData$$ExternalSyntheticLambda0);
            groupSendInputAmountView.setListener(new GroupSendInputAmountView.OnAmountChangeListener() { // from class: id.dana.sendmoney.ui.groupsend.summary.view.BottomSheetInputAmountDialogFragment$setAmountListener$1$1
                @Override // id.dana.sendmoney.ui.groupsend.summary.view.GroupSendInputAmountView.OnAmountChangeListener
                public final void PlaceComponentResult(boolean p0, CurrencyAmountModel p1) {
                    Intrinsics.checkNotNullParameter(p1, "");
                    BottomSheetInputAmountDialogFragment.MyBillsEntityDataFactory(BottomSheetInputAmountDialogFragment.this, p0);
                    BottomSheetInputAmountDialogFragment.this.BuiltInFictitiousFunctionClassFactory = String.valueOf(p1.getUnformatedAmount());
                }
            });
            groupSendInputAmountView.setLimit(this.getAuthRequestContext, this.MyBillsEntityDataFactory, this.getErrorConfigVersion, new CurrencyAmountModel(String.valueOf(Long.parseLong(StringsKt.replace$default(StringsKt.replace$default(this.lookAheadTest.getAmount(), "Rp", "", false, 4, (Object) null), ".", "", false, 4, (Object) null)) + this.NetworkUserEntityData$$ExternalSyntheticLambda0), "Rp", false, 4, null));
            groupSendInputAmountView.setMemberCount(this.PlaceComponentResult);
            VB vb2 = this.MyBillsEntityDataFactory;
            if (vb2 != 0) {
                ((BottomSheetInputAmountDialogBinding) vb2).lookAheadTest.setListener(new NumpadView.NumpadClickListener() { // from class: id.dana.sendmoney.ui.groupsend.summary.view.BottomSheetInputAmountDialogFragment$setAmountListener$2$1
                    @Override // id.dana.core.ui.richview.NumpadView.NumpadClickListener
                    public final void MyBillsEntityDataFactory(String p0) {
                        Intrinsics.checkNotNullParameter(p0, "");
                        VB vb3 = BottomSheetInputAmountDialogFragment.this.MyBillsEntityDataFactory;
                        if (vb3 != 0) {
                            ((BottomSheetInputAmountDialogBinding) vb3).getErrorConfigVersion.setPrefixedAmount(p0.length() == 0 ? 0L : Long.parseLong(p0));
                            return;
                        }
                        throw new IllegalArgumentException("Required value was null.".toString());
                    }
                });
                VB vb3 = this.MyBillsEntityDataFactory;
                if (vb3 != 0) {
                    ((BottomSheetInputAmountDialogBinding) vb3).MyBillsEntityDataFactory.setOnClickListener(new View.OnClickListener() { // from class: id.dana.sendmoney.ui.groupsend.summary.view.BottomSheetInputAmountDialogFragment$$ExternalSyntheticLambda0
                        @Override // android.view.View.OnClickListener
                        public final void onClick(View view) {
                            BottomSheetInputAmountDialogFragment.BuiltInFictitiousFunctionClassFactory(BottomSheetInputAmountDialogFragment.this);
                        }
                    });
                    VB vb4 = this.MyBillsEntityDataFactory;
                    if (vb4 != 0) {
                        ((BottomSheetInputAmountDialogBinding) vb4).PlaceComponentResult.setOnClickListener(new View.OnClickListener() { // from class: id.dana.sendmoney.ui.groupsend.summary.view.BottomSheetInputAmountDialogFragment$$ExternalSyntheticLambda1
                            @Override // android.view.View.OnClickListener
                            public final void onClick(View view) {
                                BottomSheetInputAmountDialogFragment.MyBillsEntityDataFactory(BottomSheetInputAmountDialogFragment.this);
                            }
                        });
                        VB vb5 = this.MyBillsEntityDataFactory;
                        if (vb5 != 0) {
                            ((BottomSheetInputAmountDialogBinding) vb5).KClassImpl$Data$declaredNonStaticMembers$2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: id.dana.sendmoney.ui.groupsend.summary.view.BottomSheetInputAmountDialogFragment$$ExternalSyntheticLambda2
                                @Override // android.widget.CompoundButton.OnCheckedChangeListener
                                public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                                    BottomSheetInputAmountDialogFragment.PlaceComponentResult(BottomSheetInputAmountDialogFragment.this, z);
                                }
                            });
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
        throw new IllegalArgumentException("Required value was null.".toString());
    }

    public static /* synthetic */ void BuiltInFictitiousFunctionClassFactory(BottomSheetInputAmountDialogFragment bottomSheetInputAmountDialogFragment) {
        Intrinsics.checkNotNullParameter(bottomSheetInputAmountDialogFragment, "");
        bottomSheetInputAmountDialogFragment.dismiss();
    }

    public static /* synthetic */ void MyBillsEntityDataFactory(BottomSheetInputAmountDialogFragment bottomSheetInputAmountDialogFragment) {
        Intrinsics.checkNotNullParameter(bottomSheetInputAmountDialogFragment, "");
        Function2<String, Boolean, Unit> function2 = bottomSheetInputAmountDialogFragment.KClassImpl$Data$declaredNonStaticMembers$2;
        String str = bottomSheetInputAmountDialogFragment.BuiltInFictitiousFunctionClassFactory;
        VB vb = bottomSheetInputAmountDialogFragment.MyBillsEntityDataFactory;
        if (vb != 0) {
            function2.invoke(str, Boolean.valueOf(((BottomSheetInputAmountDialogBinding) vb).KClassImpl$Data$declaredNonStaticMembers$2.isChecked()));
            bottomSheetInputAmountDialogFragment.dismiss();
            return;
        }
        throw new IllegalArgumentException("Required value was null.".toString());
    }

    public static /* synthetic */ void PlaceComponentResult(BottomSheetInputAmountDialogFragment bottomSheetInputAmountDialogFragment, boolean z) {
        Intrinsics.checkNotNullParameter(bottomSheetInputAmountDialogFragment, "");
        VB vb = bottomSheetInputAmountDialogFragment.MyBillsEntityDataFactory;
        if (vb != 0) {
            ((BottomSheetInputAmountDialogBinding) vb).getErrorConfigVersion.setSameAmount(z);
            return;
        }
        throw new IllegalArgumentException("Required value was null.".toString());
    }

    public static final /* synthetic */ void MyBillsEntityDataFactory(BottomSheetInputAmountDialogFragment bottomSheetInputAmountDialogFragment, boolean z) {
        VB vb = bottomSheetInputAmountDialogFragment.MyBillsEntityDataFactory;
        if (vb != 0) {
            ((BottomSheetInputAmountDialogBinding) vb).PlaceComponentResult.setEnabled(z);
            if (z) {
                VB vb2 = bottomSheetInputAmountDialogFragment.MyBillsEntityDataFactory;
                if (vb2 != 0) {
                    ((BottomSheetInputAmountDialogBinding) vb2).PlaceComponentResult.setActiveButton(bottomSheetInputAmountDialogFragment.getString(R.string.res_0x7f1313a5_securitysettingsactivity_createpinlauncher_2_2), null);
                    return;
                }
                throw new IllegalArgumentException("Required value was null.".toString());
            }
            VB vb3 = bottomSheetInputAmountDialogFragment.MyBillsEntityDataFactory;
            if (vb3 != 0) {
                ((BottomSheetInputAmountDialogBinding) vb3).PlaceComponentResult.setDisabled(bottomSheetInputAmountDialogFragment.getString(R.string.res_0x7f1313a5_securitysettingsactivity_createpinlauncher_2_2));
                return;
            }
            throw new IllegalArgumentException("Required value was null.".toString());
        }
        throw new IllegalArgumentException("Required value was null.".toString());
    }

    @Override // id.dana.core.ui.BaseViewBindingBottomSheetDialogFragment
    public final View KClassImpl$Data$declaredNonStaticMembers$2() {
        VB vb = this.MyBillsEntityDataFactory;
        if (vb != 0) {
            FrameLayout frameLayout = ((BottomSheetInputAmountDialogBinding) vb).BuiltInFictitiousFunctionClassFactory;
            Intrinsics.checkNotNullExpressionValue(frameLayout, "");
            return frameLayout;
        }
        throw new IllegalArgumentException("Required value was null.".toString());
    }
}
