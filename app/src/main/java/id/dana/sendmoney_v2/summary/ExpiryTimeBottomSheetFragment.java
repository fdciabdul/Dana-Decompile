package id.dana.sendmoney_v2.summary;

import android.app.Dialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.alibaba.ariver.kernel.api.extension.bridge.BridgeDSL;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import id.dana.base.BaseRecyclerViewHolder;
import id.dana.core.ui.BaseViewBindingBottomSheetDialogFragment;
import id.dana.core.ui.BaseViewBindingBottomSheetDialogFragment$$ExternalSyntheticLambda2;
import id.dana.databinding.ViewBottomSheetExpiryTimeBinding;
import id.dana.domain.featureconfig.model.ExpiryTimeConfig;
import id.dana.sendmoney_v2.summary.adapter.ExpiryTimeAdapter;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B2\u0012\u001b\b\u0002\u0010\u0019\u001a\u0015\u0012\u000b\u0012\t\u0018\u00010\u0015¢\u0006\u0002\b\u0016\u0012\u0004\u0012\u00020\t0\u0014\u0012\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00120\u0011¢\u0006\u0004\b\u001b\u0010\u001cJ\u000f\u0010\u0004\u001a\u00020\u0003H\u0014¢\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\u0007\u001a\u00020\u0006H\u0014¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\n\u001a\u00020\tH\u0014¢\u0006\u0004\b\n\u0010\u000bJ\u000f\u0010\f\u001a\u00020\tH\u0014¢\u0006\u0004\b\f\u0010\u000bJ\u000f\u0010\r\u001a\u00020\tH\u0016¢\u0006\u0004\b\r\u0010\u000bR\u0016\u0010\u0010\u001a\u00020\u000e8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b\f\u0010\u000fR\u0018\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00120\u0011X\u0086\u0002¢\u0006\u0006\n\u0004\b\u0010\u0010\u0013R)\u0010\f\u001a\u0015\u0012\u000b\u0012\t\u0018\u00010\u0015¢\u0006\u0002\b\u0016\u0012\u0004\u0012\u00020\t0\u00148\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0017\u0010\u0018"}, d2 = {"Lid/dana/sendmoney_v2/summary/ExpiryTimeBottomSheetFragment;", "Lid/dana/core/ui/BaseViewBindingBottomSheetDialogFragment;", "Lid/dana/databinding/ViewBottomSheetExpiryTimeBinding;", "", "BuiltInFictitiousFunctionClassFactory", "()F", "Landroid/view/View;", "KClassImpl$Data$declaredNonStaticMembers$2", "()Landroid/view/View;", "", "getAuthRequestContext", "()V", "MyBillsEntityDataFactory", "onStart", "Lid/dana/sendmoney_v2/summary/adapter/ExpiryTimeAdapter;", "Lid/dana/sendmoney_v2/summary/adapter/ExpiryTimeAdapter;", "PlaceComponentResult", "", "Lid/dana/domain/featureconfig/model/ExpiryTimeConfig;", "Ljava/util/List;", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "DatabaseTableConfigUtil", "Lkotlin/jvm/functions/Function1;", "p0", "p1", "<init>", "(Lkotlin/jvm/functions/Function1;Ljava/util/List;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class ExpiryTimeBottomSheetFragment extends BaseViewBindingBottomSheetDialogFragment<ViewBottomSheetExpiryTimeBinding> {

    /* renamed from: DatabaseTableConfigUtil  reason: from kotlin metadata */
    private Function1<? super Integer, Unit> MyBillsEntityDataFactory;
    public Map<Integer, View> KClassImpl$Data$declaredNonStaticMembers$2;

    /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
    private ExpiryTimeAdapter PlaceComponentResult;

    /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
    public List<ExpiryTimeConfig> KClassImpl$Data$declaredNonStaticMembers$2;

    @Override // id.dana.core.ui.BaseViewBindingBottomSheetDialogFragment
    public final float BuiltInFictitiousFunctionClassFactory() {
        return 0.48f;
    }

    @Override // id.dana.core.ui.BaseViewBindingBottomSheetDialogFragment
    public final void PlaceComponentResult() {
        this.KClassImpl$Data$declaredNonStaticMembers$2.clear();
    }

    @Metadata(d1 = {"\u0000\u000e\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"", "it", "", BridgeDSL.INVOKE, "(I)V"}, k = 3, mv = {1, 6, 0}, xi = 48)
    /* renamed from: id.dana.sendmoney_v2.summary.ExpiryTimeBottomSheetFragment$1  reason: invalid class name */
    /* loaded from: classes5.dex */
    static final class AnonymousClass1 extends Lambda implements Function1<Integer, Unit> {
        public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

        AnonymousClass1() {
            super(1);
        }

        public final void invoke(int i) {
        }

        @Override // kotlin.jvm.functions.Function1
        public final /* synthetic */ Unit invoke(Integer num) {
            invoke(num.intValue());
            return Unit.INSTANCE;
        }
    }

    public ExpiryTimeBottomSheetFragment(Function1<? super Integer, Unit> function1, List<ExpiryTimeConfig> list) {
        Intrinsics.checkNotNullParameter(function1, "");
        Intrinsics.checkNotNullParameter(list, "");
        this.KClassImpl$Data$declaredNonStaticMembers$2 = new LinkedHashMap();
        this.MyBillsEntityDataFactory = function1;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = list;
    }

    @Override // id.dana.core.ui.BaseViewBindingBottomSheetDialogFragment
    public final /* synthetic */ ViewBottomSheetExpiryTimeBinding BuiltInFictitiousFunctionClassFactory(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        Intrinsics.checkNotNullParameter(layoutInflater, "");
        ViewBottomSheetExpiryTimeBinding authRequestContext = ViewBottomSheetExpiryTimeBinding.getAuthRequestContext(LayoutInflater.from(getContext()));
        Intrinsics.checkNotNullExpressionValue(authRequestContext, "");
        return authRequestContext;
    }

    @Override // id.dana.core.ui.BaseViewBindingBottomSheetDialogFragment
    public final void getAuthRequestContext() {
        super.getAuthRequestContext();
        VB vb = this.MyBillsEntityDataFactory;
        if (vb != 0) {
            ((ViewBottomSheetExpiryTimeBinding) vb).PlaceComponentResult.setOnClickListener(new View.OnClickListener() { // from class: id.dana.sendmoney_v2.summary.ExpiryTimeBottomSheetFragment$$ExternalSyntheticLambda1
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    ExpiryTimeBottomSheetFragment.MyBillsEntityDataFactory(ExpiryTimeBottomSheetFragment.this);
                }
            });
            ExpiryTimeAdapter expiryTimeAdapter = new ExpiryTimeAdapter();
            this.PlaceComponentResult = expiryTimeAdapter;
            expiryTimeAdapter.setItems(this.KClassImpl$Data$declaredNonStaticMembers$2);
            ExpiryTimeAdapter expiryTimeAdapter2 = this.PlaceComponentResult;
            ExpiryTimeAdapter expiryTimeAdapter3 = null;
            if (expiryTimeAdapter2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("");
                expiryTimeAdapter2 = null;
            }
            expiryTimeAdapter2.setOnItemClickListener(new BaseRecyclerViewHolder.OnItemClickListener() { // from class: id.dana.sendmoney_v2.summary.ExpiryTimeBottomSheetFragment$$ExternalSyntheticLambda0
                @Override // id.dana.base.BaseRecyclerViewHolder.OnItemClickListener
                public final void onItemClick(int i) {
                    ExpiryTimeBottomSheetFragment.PlaceComponentResult(ExpiryTimeBottomSheetFragment.this, i);
                }
            });
            VB vb2 = this.MyBillsEntityDataFactory;
            if (vb2 != 0) {
                RecyclerView recyclerView = ((ViewBottomSheetExpiryTimeBinding) vb2).getAuthRequestContext;
                ExpiryTimeAdapter expiryTimeAdapter4 = this.PlaceComponentResult;
                if (expiryTimeAdapter4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("");
                } else {
                    expiryTimeAdapter3 = expiryTimeAdapter4;
                }
                recyclerView.setAdapter(expiryTimeAdapter3);
                recyclerView.setLayoutManager(new LinearLayoutManager(recyclerView.getContext()));
                return;
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
            BottomSheetBehavior<View> o_ = o_();
            if (o_ != null) {
                o_.setDraggable(false);
            }
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

    public static /* synthetic */ void MyBillsEntityDataFactory(ExpiryTimeBottomSheetFragment expiryTimeBottomSheetFragment) {
        Intrinsics.checkNotNullParameter(expiryTimeBottomSheetFragment, "");
        expiryTimeBottomSheetFragment.dismissAllowingStateLoss();
    }

    public static /* synthetic */ void PlaceComponentResult(ExpiryTimeBottomSheetFragment expiryTimeBottomSheetFragment, int i) {
        Intrinsics.checkNotNullParameter(expiryTimeBottomSheetFragment, "");
        expiryTimeBottomSheetFragment.MyBillsEntityDataFactory.invoke(Integer.valueOf(i));
        expiryTimeBottomSheetFragment.dismissAllowingStateLoss();
    }

    @Override // id.dana.core.ui.BaseViewBindingBottomSheetDialogFragment
    public final View KClassImpl$Data$declaredNonStaticMembers$2() {
        VB vb = this.MyBillsEntityDataFactory;
        if (vb != 0) {
            FrameLayout frameLayout = ((ViewBottomSheetExpiryTimeBinding) vb).PlaceComponentResult;
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
