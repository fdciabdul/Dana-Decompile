package id.dana.databinding;

import android.view.View;
import android.widget.ImageButton;
import android.widget.RelativeLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import id.dana.R;
import id.dana.popup.LockableViewPager;

/* loaded from: classes4.dex */
public final class ViewPopupInputBinding implements ViewBinding {
    public final RelativeLayout BuiltInFictitiousFunctionClassFactory;
    public final ImageButton KClassImpl$Data$declaredNonStaticMembers$2;
    public final LockableViewPager MyBillsEntityDataFactory;
    public final RelativeLayout getAuthRequestContext;

    private ViewPopupInputBinding(RelativeLayout relativeLayout, ImageButton imageButton, RelativeLayout relativeLayout2, LockableViewPager lockableViewPager) {
        this.getAuthRequestContext = relativeLayout;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = imageButton;
        this.BuiltInFictitiousFunctionClassFactory = relativeLayout2;
        this.MyBillsEntityDataFactory = lockableViewPager;
    }

    public static ViewPopupInputBinding BuiltInFictitiousFunctionClassFactory(View view) {
        int i = R.id.forEach;
        ImageButton imageButton = (ImageButton) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, R.id.forEach);
        if (imageButton != null) {
            RelativeLayout relativeLayout = (RelativeLayout) view;
            LockableViewPager lockableViewPager = (LockableViewPager) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, R.id.f4070popup_view);
            if (lockableViewPager != null) {
                return new ViewPopupInputBinding(relativeLayout, imageButton, relativeLayout, lockableViewPager);
            }
            i = R.id.f4070popup_view;
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    @Override // androidx.viewbinding.ViewBinding
    public final /* bridge */ /* synthetic */ View KClassImpl$Data$declaredNonStaticMembers$2() {
        return this.getAuthRequestContext;
    }
}
