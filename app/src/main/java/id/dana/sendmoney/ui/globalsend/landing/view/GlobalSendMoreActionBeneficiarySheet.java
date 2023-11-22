package id.dana.sendmoney.ui.globalsend.landing.view;

import android.app.Dialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.fragment.app.FragmentManager;
import id.dana.core.ui.BaseViewBindingBottomSheetDialogFragment;
import id.dana.core.ui.BaseViewBindingBottomSheetDialogFragment$$ExternalSyntheticLambda2;
import id.dana.core.ui.util.MaskedTextUtil;
import id.dana.sendmoney.databinding.ViewGlobalSendMoreActionBottomSheetBinding;
import id.dana.sendmoney.ui.globalsend.form.model.BeneficiaryInfoModel;
import id.dana.sendmoney.ui.globalsend.landing.constant.MoreActionType;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 \u001b2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u001bB/\u0012&\u0010\u000f\u001a\"\u0012\u000b\u0012\t\u0018\u00010\u0016¢\u0006\u0002\b\u0017\u0012\u000b\u0012\t\u0018\u00010\u0016¢\u0006\u0002\b\u0017\u0012\u0004\u0012\u00020\t0\u0015¢\u0006\u0004\b\u0019\u0010\u001aJ\u000f\u0010\u0004\u001a\u00020\u0003H\u0014¢\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\u0007\u001a\u00020\u0006H\u0014¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\n\u001a\u00020\tH\u0014¢\u0006\u0004\b\n\u0010\u000bJ\u000f\u0010\f\u001a\u00020\tH\u0014¢\u0006\u0004\b\f\u0010\u000bJ\u000f\u0010\r\u001a\u00020\tH\u0016¢\u0006\u0004\b\r\u0010\u000bJ\u001d\u0010\f\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u0010¢\u0006\u0004\b\f\u0010\u0012R\u0016\u0010\f\u001a\u00020\u00108\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014R6\u0010\n\u001a\"\u0012\u000b\u0012\t\u0018\u00010\u0016¢\u0006\u0002\b\u0017\u0012\u000b\u0012\t\u0018\u00010\u0016¢\u0006\u0002\b\u0017\u0012\u0004\u0012\u00020\t0\u00158\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\f\u0010\u0018"}, d2 = {"Lid/dana/sendmoney/ui/globalsend/landing/view/GlobalSendMoreActionBeneficiarySheet;", "Lid/dana/core/ui/BaseViewBindingBottomSheetDialogFragment;", "Lid/dana/sendmoney/databinding/ViewGlobalSendMoreActionBottomSheetBinding;", "", "BuiltInFictitiousFunctionClassFactory", "()F", "Landroid/view/View;", "KClassImpl$Data$declaredNonStaticMembers$2", "()Landroid/view/View;", "", "getAuthRequestContext", "()V", "MyBillsEntityDataFactory", "onStart", "Landroidx/fragment/app/FragmentManager;", "p0", "Lid/dana/sendmoney/ui/globalsend/form/model/BeneficiaryInfoModel;", "p1", "(Landroidx/fragment/app/FragmentManager;Lid/dana/sendmoney/ui/globalsend/form/model/BeneficiaryInfoModel;)V", "PlaceComponentResult", "Lid/dana/sendmoney/ui/globalsend/form/model/BeneficiaryInfoModel;", "Lkotlin/Function2;", "", "Lkotlin/ParameterName;", "Lkotlin/jvm/functions/Function2;", "<init>", "(Lkotlin/jvm/functions/Function2;)V", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class GlobalSendMoreActionBeneficiarySheet extends BaseViewBindingBottomSheetDialogFragment<ViewGlobalSendMoreActionBottomSheetBinding> {

    /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
    private Function2<? super String, ? super String, Unit> getAuthRequestContext;

    /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
    private BeneficiaryInfoModel MyBillsEntityDataFactory;

    @Override // id.dana.core.ui.BaseViewBindingBottomSheetDialogFragment
    public final float BuiltInFictitiousFunctionClassFactory() {
        return 0.48f;
    }

    @Override // id.dana.core.ui.BaseViewBindingBottomSheetDialogFragment
    public final /* synthetic */ ViewGlobalSendMoreActionBottomSheetBinding BuiltInFictitiousFunctionClassFactory(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        Intrinsics.checkNotNullParameter(layoutInflater, "");
        ViewGlobalSendMoreActionBottomSheetBinding authRequestContext = ViewGlobalSendMoreActionBottomSheetBinding.getAuthRequestContext(layoutInflater, viewGroup);
        Intrinsics.checkNotNullExpressionValue(authRequestContext, "");
        return authRequestContext;
    }

    public GlobalSendMoreActionBeneficiarySheet(Function2<? super String, ? super String, Unit> function2) {
        Intrinsics.checkNotNullParameter(function2, "");
        this.getAuthRequestContext = function2;
    }

    @Override // id.dana.core.ui.BaseViewBindingBottomSheetDialogFragment
    public final void getAuthRequestContext() {
        super.getAuthRequestContext();
        VB vb = this.MyBillsEntityDataFactory;
        if (vb != 0) {
            TextView textView = ((ViewGlobalSendMoreActionBottomSheetBinding) vb).moveToNextValue;
            BeneficiaryInfoModel beneficiaryInfoModel = this.MyBillsEntityDataFactory;
            BeneficiaryInfoModel beneficiaryInfoModel2 = null;
            if (beneficiaryInfoModel == null) {
                Intrinsics.throwUninitializedPropertyAccessException("");
                beneficiaryInfoModel = null;
            }
            textView.setText(beneficiaryInfoModel.KClassImpl$Data$declaredNonStaticMembers$2());
            VB vb2 = this.MyBillsEntityDataFactory;
            if (vb2 != 0) {
                TextView textView2 = ((ViewGlobalSendMoreActionBottomSheetBinding) vb2).NetworkUserEntityData$$ExternalSyntheticLambda0;
                BeneficiaryInfoModel beneficiaryInfoModel3 = this.MyBillsEntityDataFactory;
                if (beneficiaryInfoModel3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("");
                    beneficiaryInfoModel3 = null;
                }
                textView2.setText(beneficiaryInfoModel3.MyBillsEntityDataFactory());
                VB vb3 = this.MyBillsEntityDataFactory;
                if (vb3 != 0) {
                    TextView textView3 = ((ViewGlobalSendMoreActionBottomSheetBinding) vb3).KClassImpl$Data$declaredNonStaticMembers$2;
                    MaskedTextUtil maskedTextUtil = MaskedTextUtil.INSTANCE;
                    MaskedTextUtil maskedTextUtil2 = MaskedTextUtil.INSTANCE;
                    BeneficiaryInfoModel beneficiaryInfoModel4 = this.MyBillsEntityDataFactory;
                    if (beneficiaryInfoModel4 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("");
                    } else {
                        beneficiaryInfoModel2 = beneficiaryInfoModel4;
                    }
                    textView3.setText(MaskedTextUtil.getAuthRequestContext(MaskedTextUtil.MyBillsEntityDataFactory(beneficiaryInfoModel2.NetworkUserEntityData$$ExternalSyntheticLambda7)));
                    VB vb4 = this.MyBillsEntityDataFactory;
                    if (vb4 != 0) {
                        ((ViewGlobalSendMoreActionBottomSheetBinding) vb4).getAuthRequestContext.setOnClickListener(new View.OnClickListener() { // from class: id.dana.sendmoney.ui.globalsend.landing.view.GlobalSendMoreActionBeneficiarySheet$$ExternalSyntheticLambda0
                            @Override // android.view.View.OnClickListener
                            public final void onClick(View view) {
                                GlobalSendMoreActionBeneficiarySheet.PlaceComponentResult(GlobalSendMoreActionBeneficiarySheet.this);
                            }
                        });
                        VB vb5 = this.MyBillsEntityDataFactory;
                        if (vb5 != 0) {
                            ((ViewGlobalSendMoreActionBottomSheetBinding) vb5).PlaceComponentResult.setOnClickListener(new View.OnClickListener() { // from class: id.dana.sendmoney.ui.globalsend.landing.view.GlobalSendMoreActionBeneficiarySheet$$ExternalSyntheticLambda1
                                @Override // android.view.View.OnClickListener
                                public final void onClick(View view) {
                                    GlobalSendMoreActionBeneficiarySheet.getAuthRequestContext(GlobalSendMoreActionBeneficiarySheet.this);
                                }
                            });
                            VB vb6 = this.MyBillsEntityDataFactory;
                            if (vb6 != 0) {
                                ((ViewGlobalSendMoreActionBottomSheetBinding) vb6).BuiltInFictitiousFunctionClassFactory.setOnClickListener(new View.OnClickListener() { // from class: id.dana.sendmoney.ui.globalsend.landing.view.GlobalSendMoreActionBeneficiarySheet$$ExternalSyntheticLambda2
                                    @Override // android.view.View.OnClickListener
                                    public final void onClick(View view) {
                                        GlobalSendMoreActionBeneficiarySheet.BuiltInFictitiousFunctionClassFactory(GlobalSendMoreActionBeneficiarySheet.this);
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
        throw new IllegalArgumentException("Required value was null.".toString());
    }

    @Override // id.dana.core.ui.BaseViewBindingBottomSheetDialogFragment
    public final void MyBillsEntityDataFactory() {
        super.MyBillsEntityDataFactory();
        Dialog dialog = getDialog();
        if (dialog != null) {
            a_(PlaceComponentResult(dialog));
        }
    }

    public final void MyBillsEntityDataFactory(FragmentManager p0, BeneficiaryInfoModel p1) {
        Intrinsics.checkNotNullParameter(p0, "");
        Intrinsics.checkNotNullParameter(p1, "");
        super.show(p0, "MoreActionBeneficiaryGlobalSendBottomSheet");
        this.MyBillsEntityDataFactory = p1;
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

    public static /* synthetic */ void PlaceComponentResult(GlobalSendMoreActionBeneficiarySheet globalSendMoreActionBeneficiarySheet) {
        Intrinsics.checkNotNullParameter(globalSendMoreActionBeneficiarySheet, "");
        Function2<? super String, ? super String, Unit> function2 = globalSendMoreActionBeneficiarySheet.getAuthRequestContext;
        BeneficiaryInfoModel beneficiaryInfoModel = globalSendMoreActionBeneficiarySheet.MyBillsEntityDataFactory;
        if (beneficiaryInfoModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            beneficiaryInfoModel = null;
        }
        function2.invoke(MoreActionType.FAVORITE, beneficiaryInfoModel.MyBillsEntityDataFactory);
        globalSendMoreActionBeneficiarySheet.dismissAllowingStateLoss();
    }

    public static /* synthetic */ void BuiltInFictitiousFunctionClassFactory(GlobalSendMoreActionBeneficiarySheet globalSendMoreActionBeneficiarySheet) {
        Intrinsics.checkNotNullParameter(globalSendMoreActionBeneficiarySheet, "");
        globalSendMoreActionBeneficiarySheet.dismissAllowingStateLoss();
    }

    public static /* synthetic */ void getAuthRequestContext(GlobalSendMoreActionBeneficiarySheet globalSendMoreActionBeneficiarySheet) {
        Intrinsics.checkNotNullParameter(globalSendMoreActionBeneficiarySheet, "");
        Function2<? super String, ? super String, Unit> function2 = globalSendMoreActionBeneficiarySheet.getAuthRequestContext;
        BeneficiaryInfoModel beneficiaryInfoModel = globalSendMoreActionBeneficiarySheet.MyBillsEntityDataFactory;
        if (beneficiaryInfoModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            beneficiaryInfoModel = null;
        }
        function2.invoke("DELETE", beneficiaryInfoModel.MyBillsEntityDataFactory);
        globalSendMoreActionBeneficiarySheet.dismissAllowingStateLoss();
    }

    @Override // id.dana.core.ui.BaseViewBindingBottomSheetDialogFragment
    public final View KClassImpl$Data$declaredNonStaticMembers$2() {
        VB vb = this.MyBillsEntityDataFactory;
        if (vb != 0) {
            FrameLayout frameLayout = ((ViewGlobalSendMoreActionBottomSheetBinding) vb).MyBillsEntityDataFactory;
            Intrinsics.checkNotNullExpressionValue(frameLayout, "");
            return frameLayout;
        }
        throw new IllegalArgumentException("Required value was null.".toString());
    }
}
