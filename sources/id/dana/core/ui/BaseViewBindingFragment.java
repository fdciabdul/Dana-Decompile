package id.dana.core.ui;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.view.OnBackPressedCallback;
import androidx.viewbinding.ViewBinding;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\b&\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u00012\u00020\u0003B\u0007¢\u0006\u0004\b*\u0010\u0006J\u000f\u0010\u0005\u001a\u00020\u0004H\u0014¢\u0006\u0004\b\u0005\u0010\u0006J!\u0010\u000b\u001a\u00028\u00002\u0006\u0010\b\u001a\u00020\u00072\b\u0010\n\u001a\u0004\u0018\u00010\tH&¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\r\u001a\u00020\u0004H\u0014¢\u0006\u0004\b\r\u0010\u0006J\u0017\u0010\u000f\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u000eH\u0016¢\u0006\u0004\b\u000f\u0010\u0010J\u000f\u0010\u0011\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0011\u0010\u0006J-\u0010\u0015\u001a\u0004\u0018\u00010\u00142\u0006\u0010\b\u001a\u00020\u00072\b\u0010\n\u001a\u0004\u0018\u00010\t2\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012H\u0016¢\u0006\u0004\b\u0015\u0010\u0016J\u000f\u0010\u0017\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0017\u0010\u0006J\u000f\u0010\u0018\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0018\u0010\u0006J!\u0010\u0019\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00142\b\u0010\n\u001a\u0004\u0018\u00010\u0012H\u0016¢\u0006\u0004\b\u0019\u0010\u001aR\u0018\u0010\u001d\u001a\u0004\u0018\u00018\u00008\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001b\u0010\u001cR\u001a\u0010\"\u001a\u00020\u001e8\u0017X\u0096\u0006¢\u0006\f\n\u0004\b\u000b\u0010\u001f\u001a\u0004\b \u0010!R\"\u0010(\u001a\u00020#8\u0005@\u0005X\u0085.¢\u0006\u0012\n\u0004\b$\u0010%\u001a\u0004\b&\u0010'\"\u0004\b(\u0010)"}, d2 = {"Lid/dana/core/ui/BaseViewBindingFragment;", "Landroidx/viewbinding/ViewBinding;", "VB", "Landroidx/fragment/app/Fragment;", "", "KClassImpl$Data$declaredNonStaticMembers$2", "()V", "Landroid/view/LayoutInflater;", "p0", "Landroid/view/ViewGroup;", "p1", "MyBillsEntityDataFactory", "(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;)Landroidx/viewbinding/ViewBinding;", "FragmentBottomSheetPaymentSettingBinding", "Landroid/content/Context;", "onAttach", "(Landroid/content/Context;)V", "lookAheadTest", "Landroid/os/Bundle;", "p2", "Landroid/view/View;", "onCreateView", "(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;", "onDestroyView", "getOnBoardingScenario", "onViewCreated", "(Landroid/view/View;Landroid/os/Bundle;)V", "PrepareContext", "Landroidx/viewbinding/ViewBinding;", "PlaceComponentResult", "Landroidx/activity/OnBackPressedCallback;", "Landroidx/activity/OnBackPressedCallback;", "E", "()Landroidx/activity/OnBackPressedCallback;", "BuiltInFictitiousFunctionClassFactory", "Landroidx/appcompat/widget/Toolbar;", "newProxyInstance", "Landroidx/appcompat/widget/Toolbar;", "getValueOfTouchPositionAbsolute", "()Landroidx/appcompat/widget/Toolbar;", "getAuthRequestContext", "(Landroidx/appcompat/widget/Toolbar;)V", "<init>"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public abstract class BaseViewBindingFragment<VB extends ViewBinding> extends Fragment {

    /* renamed from: PrepareContext  reason: from kotlin metadata */
    public VB PlaceComponentResult;

    /* renamed from: newProxyInstance  reason: from kotlin metadata */
    protected Toolbar getAuthRequestContext;
    public Map<Integer, View> NetworkUserEntityData$$ExternalSyntheticLambda8 = new LinkedHashMap();

    /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
    private OnBackPressedCallback BuiltInFictitiousFunctionClassFactory = new OnBackPressedCallback(this) { // from class: id.dana.core.ui.BaseViewBindingFragment$onBackPressedCallback$1
        final /* synthetic */ BaseViewBindingFragment<VB> MyBillsEntityDataFactory;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        {
            super(true);
            this.MyBillsEntityDataFactory = this;
        }

        @Override // androidx.view.OnBackPressedCallback
        public final void handleOnBackPressed() {
            this.MyBillsEntityDataFactory.lookAheadTest();
        }
    };

    public void FragmentBottomSheetPaymentSettingBinding() {
    }

    public void KClassImpl$Data$declaredNonStaticMembers$2() {
    }

    public abstract VB MyBillsEntityDataFactory(LayoutInflater p0, ViewGroup p1);

    public View getAuthRequestContext(int i) {
        View findViewById;
        Map<Integer, View> map = this.NetworkUserEntityData$$ExternalSyntheticLambda8;
        View view = map.get(Integer.valueOf(i));
        if (view == null) {
            View view2 = getView();
            if (view2 == null || (findViewById = view2.findViewById(i)) == null) {
                return null;
            }
            map.put(Integer.valueOf(i), findViewById);
            return findViewById;
        }
        return view;
    }

    public void getAuthRequestContext() {
        this.NetworkUserEntityData$$ExternalSyntheticLambda8.clear();
    }

    public void getOnBoardingScenario() {
    }

    public void lookAheadTest() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @JvmName(name = "getAuthRequestContext")
    public final void getAuthRequestContext(Toolbar toolbar) {
        Intrinsics.checkNotNullParameter(toolbar, "");
        this.getAuthRequestContext = toolbar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @JvmName(name = "getValueOfTouchPositionAbsolute")
    public final Toolbar getValueOfTouchPositionAbsolute() {
        Toolbar toolbar = this.getAuthRequestContext;
        if (toolbar != null) {
            return toolbar;
        }
        Intrinsics.throwUninitializedPropertyAccessException("");
        return null;
    }

    @JvmName(name = "E")
    /* renamed from: E  reason: from getter */
    public OnBackPressedCallback getBuiltInFictitiousFunctionClassFactory() {
        return this.BuiltInFictitiousFunctionClassFactory;
    }

    @Override // androidx.fragment.app.Fragment
    public void onAttach(Context p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        super.onAttach(p0);
        requireActivity().getOnBackPressedDispatcher().PlaceComponentResult(this, getBuiltInFictitiousFunctionClassFactory());
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater p0, ViewGroup p1, Bundle p2) {
        Intrinsics.checkNotNullParameter(p0, "");
        VB MyBillsEntityDataFactory = MyBillsEntityDataFactory(p0, p1);
        this.PlaceComponentResult = MyBillsEntityDataFactory;
        if (MyBillsEntityDataFactory != null) {
            return MyBillsEntityDataFactory.KClassImpl$Data$declaredNonStaticMembers$2();
        }
        throw new IllegalArgumentException("Required value was null.".toString());
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View p0, Bundle p1) {
        Intrinsics.checkNotNullParameter(p0, "");
        super.onViewCreated(p0, p1);
        FragmentBottomSheetPaymentSettingBinding();
        KClassImpl$Data$declaredNonStaticMembers$2();
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        this.PlaceComponentResult = null;
        getAuthRequestContext();
    }
}
