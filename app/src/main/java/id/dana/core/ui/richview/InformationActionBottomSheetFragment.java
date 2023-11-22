package id.dana.core.ui.richview;

import android.app.Dialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.appcompat.widget.AppCompatImageView;
import com.alibaba.ariver.kernel.api.extension.bridge.BridgeDSL;
import com.fullstory.instrumentation.InstrumentInjector;
import id.dana.R;
import id.dana.core.ui.BaseViewBindingBottomSheetDialogFragment;
import id.dana.core.ui.BaseViewBindingBottomSheetDialogFragment$$ExternalSyntheticLambda2;
import id.dana.core.ui.databinding.FragmentInformationActionBottomSheetBinding;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\f\u0018\u0000 \u001d2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u001dB7\u0012\u0006\u0010\u0016\u001a\u00020\u000e\u0012\u0006\u0010\u0017\u001a\u00020\u000e\u0012\u0006\u0010\u0018\u001a\u00020\u000e\u0012\u0006\u0010\u0019\u001a\u00020\u000e\u0012\u000e\b\u0002\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\t0\u0011¢\u0006\u0004\b\u001b\u0010\u001cJ\u000f\u0010\u0004\u001a\u00020\u0003H\u0014¢\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\u0007\u001a\u00020\u0006H\u0014¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\n\u001a\u00020\tH\u0014¢\u0006\u0004\b\n\u0010\u000bJ\u000f\u0010\f\u001a\u00020\tH\u0014¢\u0006\u0004\b\f\u0010\u000bJ\u000f\u0010\r\u001a\u00020\tH\u0016¢\u0006\u0004\b\r\u0010\u000bR\u0014\u0010\f\u001a\u00020\u000e8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\f\u0010\u000fR\u0014\u0010\u0004\u001a\u00020\u000e8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0010\u0010\u000fR\u001a\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\u00118\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u0014\u0010\n\u001a\u00020\u000e8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0014\u0010\u000fR\u0014\u0010\u0010\u001a\u00020\u000e8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0015\u0010\u000f"}, d2 = {"Lid/dana/core/ui/richview/InformationActionBottomSheetFragment;", "Lid/dana/core/ui/BaseViewBindingBottomSheetDialogFragment;", "Lid/dana/core/ui/databinding/FragmentInformationActionBottomSheetBinding;", "", "BuiltInFictitiousFunctionClassFactory", "()F", "Landroid/view/View;", "KClassImpl$Data$declaredNonStaticMembers$2", "()Landroid/view/View;", "", "getAuthRequestContext", "()V", "MyBillsEntityDataFactory", "onStart", "", "I", "PlaceComponentResult", "Lkotlin/Function0;", "NetworkUserEntityData$$ExternalSyntheticLambda1", "Lkotlin/jvm/functions/Function0;", "initRecordTimeStamp", "DatabaseTableConfigUtil", "p0", "p1", "p2", "p3", "p4", "<init>", "(Lkotlin/jvm/functions/Function0;)V", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class InformationActionBottomSheetFragment extends BaseViewBindingBottomSheetDialogFragment<FragmentInformationActionBottomSheetBinding> {

    /* renamed from: DatabaseTableConfigUtil  reason: from kotlin metadata */
    private final int PlaceComponentResult;
    public Map<Integer, View> KClassImpl$Data$declaredNonStaticMembers$2;
    private final int MyBillsEntityDataFactory;

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda1  reason: from kotlin metadata */
    private final Function0<Unit> KClassImpl$Data$declaredNonStaticMembers$2;

    /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
    private final int BuiltInFictitiousFunctionClassFactory;

    /* renamed from: initRecordTimeStamp  reason: from kotlin metadata */
    private final int getAuthRequestContext;

    @Override // id.dana.core.ui.BaseViewBindingBottomSheetDialogFragment
    public final float BuiltInFictitiousFunctionClassFactory() {
        return 0.4f;
    }

    @Override // id.dana.core.ui.BaseViewBindingBottomSheetDialogFragment
    public final void PlaceComponentResult() {
        this.KClassImpl$Data$declaredNonStaticMembers$2.clear();
    }

    public InformationActionBottomSheetFragment(Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(function0, "");
        this.KClassImpl$Data$declaredNonStaticMembers$2 = new LinkedHashMap();
        this.BuiltInFictitiousFunctionClassFactory = R.drawable.ic_data_on_verified;
        this.PlaceComponentResult = R.string.title_bottom_sheet_on_verify;
        this.MyBillsEntityDataFactory = R.string.desc_bottom_sheet_on_verify;
        this.getAuthRequestContext = R.string.button_bottom_sheet_on_verify;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = function0;
    }

    @Override // id.dana.core.ui.BaseViewBindingBottomSheetDialogFragment
    public final /* synthetic */ FragmentInformationActionBottomSheetBinding BuiltInFictitiousFunctionClassFactory(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        Intrinsics.checkNotNullParameter(layoutInflater, "");
        FragmentInformationActionBottomSheetBinding KClassImpl$Data$declaredNonStaticMembers$2 = FragmentInformationActionBottomSheetBinding.KClassImpl$Data$declaredNonStaticMembers$2(layoutInflater, viewGroup);
        Intrinsics.checkNotNullExpressionValue(KClassImpl$Data$declaredNonStaticMembers$2, "");
        return KClassImpl$Data$declaredNonStaticMembers$2;
    }

    @Metadata(d1 = {"\u0000\b\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", BridgeDSL.INVOKE, "()V"}, k = 3, mv = {1, 6, 0}, xi = 48)
    /* renamed from: id.dana.core.ui.richview.InformationActionBottomSheetFragment$1  reason: invalid class name */
    /* loaded from: classes4.dex */
    static final class AnonymousClass1 extends Lambda implements Function0<Unit> {
        public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

        AnonymousClass1() {
            super(0);
        }

        /* renamed from: invoke  reason: avoid collision after fix types in other method */
        public final void invoke2() {
        }

        @Override // kotlin.jvm.functions.Function0
        public final /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.INSTANCE;
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
    public final void getAuthRequestContext() {
        super.getAuthRequestContext();
        VB vb = this.MyBillsEntityDataFactory;
        if (vb != 0) {
            AppCompatImageView appCompatImageView = ((FragmentInformationActionBottomSheetBinding) vb).MyBillsEntityDataFactory;
            int i = this.BuiltInFictitiousFunctionClassFactory;
            if (appCompatImageView instanceof ImageView) {
                InstrumentInjector.Resources_setImageResource(appCompatImageView, i);
            } else {
                appCompatImageView.setImageResource(i);
            }
            VB vb2 = this.MyBillsEntityDataFactory;
            if (vb2 != 0) {
                ((FragmentInformationActionBottomSheetBinding) vb2).scheduleImpl.setText(getString(this.PlaceComponentResult));
                VB vb3 = this.MyBillsEntityDataFactory;
                if (vb3 != 0) {
                    ((FragmentInformationActionBottomSheetBinding) vb3).PlaceComponentResult.setText(getString(this.MyBillsEntityDataFactory));
                    VB vb4 = this.MyBillsEntityDataFactory;
                    if (vb4 != 0) {
                        ((FragmentInformationActionBottomSheetBinding) vb4).KClassImpl$Data$declaredNonStaticMembers$2.setActiveButton(getString(this.getAuthRequestContext), null);
                        VB vb5 = this.MyBillsEntityDataFactory;
                        if (vb5 != 0) {
                            ((FragmentInformationActionBottomSheetBinding) vb5).KClassImpl$Data$declaredNonStaticMembers$2.setOnClickListener(new View.OnClickListener() { // from class: id.dana.core.ui.richview.InformationActionBottomSheetFragment$$ExternalSyntheticLambda0
                                @Override // android.view.View.OnClickListener
                                public final void onClick(View view) {
                                    InformationActionBottomSheetFragment.PlaceComponentResult(InformationActionBottomSheetFragment.this);
                                }
                            });
                            VB vb6 = this.MyBillsEntityDataFactory;
                            if (vb6 != 0) {
                                ((FragmentInformationActionBottomSheetBinding) vb6).BuiltInFictitiousFunctionClassFactory.setOnClickListener(new View.OnClickListener() { // from class: id.dana.core.ui.richview.InformationActionBottomSheetFragment$$ExternalSyntheticLambda1
                                    @Override // android.view.View.OnClickListener
                                    public final void onClick(View view) {
                                        InformationActionBottomSheetFragment.getAuthRequestContext(InformationActionBottomSheetFragment.this);
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

    public static /* synthetic */ void getAuthRequestContext(InformationActionBottomSheetFragment informationActionBottomSheetFragment) {
        Intrinsics.checkNotNullParameter(informationActionBottomSheetFragment, "");
        informationActionBottomSheetFragment.dismiss();
    }

    public static /* synthetic */ void PlaceComponentResult(InformationActionBottomSheetFragment informationActionBottomSheetFragment) {
        Intrinsics.checkNotNullParameter(informationActionBottomSheetFragment, "");
        informationActionBottomSheetFragment.KClassImpl$Data$declaredNonStaticMembers$2.invoke();
        informationActionBottomSheetFragment.dismiss();
    }

    @Override // id.dana.core.ui.BaseViewBindingBottomSheetDialogFragment
    public final View KClassImpl$Data$declaredNonStaticMembers$2() {
        VB vb = this.MyBillsEntityDataFactory;
        if (vb != 0) {
            FrameLayout frameLayout = ((FragmentInformationActionBottomSheetBinding) vb).getAuthRequestContext;
            Intrinsics.checkNotNullExpressionValue(frameLayout, "");
            return frameLayout;
        }
        throw new IllegalArgumentException("Required value was null.".toString());
    }

    @Override // id.dana.core.ui.BaseViewBindingBottomSheetDialogFragment, androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public final /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        this.KClassImpl$Data$declaredNonStaticMembers$2.clear();
    }
}
