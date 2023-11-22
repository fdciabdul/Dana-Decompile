package id.dana.core.ui.dialog;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.FragmentManager;
import com.iap.ac.android.common.container.provider.ui.ContainerUIProvider;
import id.dana.core.ui.R;
import id.dana.core.ui.databinding.DialogDanaLoadingBinding;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \u001c2\u00020\u0001:\u0001\u001cB\u0007¢\u0006\u0004\b\u001b\u0010\u0010J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J+\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0006\u001a\u00020\u00052\b\u0010\b\u001a\u0004\u0018\u00010\u00072\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0016¢\u0006\u0004\b\f\u0010\rJ\u000f\u0010\u000f\u001a\u00020\u000eH\u0016¢\u0006\u0004\b\u000f\u0010\u0010J\u000f\u0010\u0011\u001a\u00020\u000eH\u0016¢\u0006\u0004\b\u0011\u0010\u0010J!\u0010\u0014\u001a\u00020\u000e2\u0006\u0010\u0006\u001a\u00020\u00122\b\u0010\b\u001a\u0004\u0018\u00010\u0013H\u0016¢\u0006\u0004\b\u0014\u0010\u0015J!\u0010\u0016\u001a\u00020\u000e2\u0006\u0010\u0006\u001a\u00020\u00122\b\u0010\b\u001a\u0004\u0018\u00010\u0013H\u0016¢\u0006\u0004\b\u0016\u0010\u0015R\u0016\u0010\u001a\u001a\u00020\u00178\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b\u0018\u0010\u0019"}, d2 = {"Lid/dana/core/ui/dialog/DanaLoadingDialogFragment;", "Landroidx/fragment/app/DialogFragment;", "", "getTheme", "()I", "Landroid/view/LayoutInflater;", "p0", "Landroid/view/ViewGroup;", "p1", "Landroid/os/Bundle;", "p2", "Landroid/view/View;", "onCreateView", "(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;", "", "onPause", "()V", "onResume", "Landroidx/fragment/app/FragmentManager;", "", ContainerUIProvider.KEY_SHOW, "(Landroidx/fragment/app/FragmentManager;Ljava/lang/String;)V", "showNow", "Lid/dana/core/ui/databinding/DialogDanaLoadingBinding;", "MyBillsEntityDataFactory", "Lid/dana/core/ui/databinding/DialogDanaLoadingBinding;", "PlaceComponentResult", "<init>", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class DanaLoadingDialogFragment extends DialogFragment {

    /* renamed from: Companion  reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
    private DialogDanaLoadingBinding PlaceComponentResult;
    public Map<Integer, View> PlaceComponentResult = new LinkedHashMap();

    @Override // androidx.fragment.app.Fragment
    public final void onResume() {
        super.onResume();
        DialogDanaLoadingBinding dialogDanaLoadingBinding = this.PlaceComponentResult;
        if (dialogDanaLoadingBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            dialogDanaLoadingBinding = null;
        }
        dialogDanaLoadingBinding.MyBillsEntityDataFactory.startRefresh();
    }

    @Override // androidx.fragment.app.Fragment
    public final void onPause() {
        super.onPause();
        DialogDanaLoadingBinding dialogDanaLoadingBinding = this.PlaceComponentResult;
        if (dialogDanaLoadingBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            dialogDanaLoadingBinding = null;
        }
        dialogDanaLoadingBinding.MyBillsEntityDataFactory.stopRefresh();
    }

    @Override // androidx.fragment.app.Fragment
    public final View onCreateView(LayoutInflater p0, ViewGroup p1, Bundle p2) {
        Intrinsics.checkNotNullParameter(p0, "");
        setCancelable(false);
        DialogDanaLoadingBinding MyBillsEntityDataFactory = DialogDanaLoadingBinding.MyBillsEntityDataFactory(p0, p1);
        Intrinsics.checkNotNullExpressionValue(MyBillsEntityDataFactory, "");
        this.PlaceComponentResult = MyBillsEntityDataFactory;
        DanaLogoProgressView danaLogoProgressView = MyBillsEntityDataFactory.KClassImpl$Data$declaredNonStaticMembers$2;
        Intrinsics.checkNotNullExpressionValue(danaLogoProgressView, "");
        return danaLogoProgressView;
    }

    @Override // androidx.fragment.app.DialogFragment
    public final int getTheme() {
        return R.style.KClassImpl$Data$declaredNonStaticMembers$2;
    }

    @Override // androidx.fragment.app.DialogFragment
    public final void show(FragmentManager p0, String p1) {
        Intrinsics.checkNotNullParameter(p0, "");
        try {
            Result.Companion companion = Result.INSTANCE;
            DanaLoadingDialogFragment danaLoadingDialogFragment = this;
            if (isAdded() && p0.isStateSaved()) {
                return;
            }
            super.show(p0, p1);
            Result.m3179constructorimpl(Unit.INSTANCE);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            Result.m3179constructorimpl(ResultKt.createFailure(th));
        }
    }

    @Override // androidx.fragment.app.DialogFragment
    public final void showNow(FragmentManager p0, String p1) {
        Intrinsics.checkNotNullParameter(p0, "");
        try {
            Result.Companion companion = Result.INSTANCE;
            DanaLoadingDialogFragment danaLoadingDialogFragment = this;
            if (isAdded() && p0.isStateSaved()) {
                return;
            }
            super.showNow(p0, p1);
            Result.m3179constructorimpl(Unit.INSTANCE);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            Result.m3179constructorimpl(ResultKt.createFailure(th));
        }
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\r\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lid/dana/core/ui/dialog/DanaLoadingDialogFragment$Companion;", "", "Lid/dana/core/ui/dialog/DanaLoadingDialogFragment;", "BuiltInFictitiousFunctionClassFactory", "()Lid/dana/core/ui/dialog/DanaLoadingDialogFragment;", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes4.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public static DanaLoadingDialogFragment BuiltInFictitiousFunctionClassFactory() {
            return new DanaLoadingDialogFragment();
        }
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public final /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        this.PlaceComponentResult.clear();
    }
}
