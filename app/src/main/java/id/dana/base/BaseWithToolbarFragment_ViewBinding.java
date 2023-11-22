package id.dana.base;

import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import id.dana.R;

/* loaded from: classes8.dex */
public class BaseWithToolbarFragment_ViewBinding implements Unbinder {
    private View BuiltInFictitiousFunctionClassFactory;
    private View MyBillsEntityDataFactory;
    private BaseWithToolbarFragment getAuthRequestContext;

    public BaseWithToolbarFragment_ViewBinding(final BaseWithToolbarFragment baseWithToolbarFragment, View view) {
        this.getAuthRequestContext = baseWithToolbarFragment;
        View findViewById = view.findViewById(R.id.left_button);
        baseWithToolbarFragment.leftButton = (TextView) Utils.BuiltInFictitiousFunctionClassFactory(findViewById, R.id.left_button, "field 'leftButton'", TextView.class);
        if (findViewById != null) {
            this.BuiltInFictitiousFunctionClassFactory = findViewById;
            findViewById.setOnClickListener(new DebouncingOnClickListener() { // from class: id.dana.base.BaseWithToolbarFragment_ViewBinding.1
                @Override // butterknife.internal.DebouncingOnClickListener
                public final void KClassImpl$Data$declaredNonStaticMembers$2(View view2) {
                    baseWithToolbarFragment.onClickLeftMenuButton(view2);
                }
            });
        }
        View findViewById2 = view.findViewById(R.id.right_button);
        baseWithToolbarFragment.rightButton = (TextView) Utils.BuiltInFictitiousFunctionClassFactory(findViewById2, R.id.right_button, "field 'rightButton'", TextView.class);
        if (findViewById2 != null) {
            this.MyBillsEntityDataFactory = findViewById2;
            findViewById2.setOnClickListener(new DebouncingOnClickListener() { // from class: id.dana.base.BaseWithToolbarFragment_ViewBinding.2
                @Override // butterknife.internal.DebouncingOnClickListener
                public final void KClassImpl$Data$declaredNonStaticMembers$2(View view2) {
                    baseWithToolbarFragment.onClickRightMenuButton(view2);
                }
            });
        }
        baseWithToolbarFragment.rlToolbar = (RelativeLayout) Utils.PlaceComponentResult(view, R.id.rl_toolbar, "field 'rlToolbar'", RelativeLayout.class);
        baseWithToolbarFragment.toolbar = (Toolbar) Utils.PlaceComponentResult(view, R.id.toolbar, "field 'toolbar'", Toolbar.class);
        baseWithToolbarFragment.toolbarImage = (ImageView) Utils.PlaceComponentResult(view, R.id.iv_title_image, "field 'toolbarImage'", ImageView.class);
        baseWithToolbarFragment.toolbarTitle = (TextView) Utils.PlaceComponentResult(view, R.id.toolbar_title, "field 'toolbarTitle'", TextView.class);
    }

    @Override // butterknife.Unbinder
    public void getAuthRequestContext() {
        BaseWithToolbarFragment baseWithToolbarFragment = this.getAuthRequestContext;
        if (baseWithToolbarFragment == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.getAuthRequestContext = null;
        baseWithToolbarFragment.leftButton = null;
        baseWithToolbarFragment.rightButton = null;
        baseWithToolbarFragment.rlToolbar = null;
        baseWithToolbarFragment.toolbar = null;
        baseWithToolbarFragment.toolbarImage = null;
        baseWithToolbarFragment.toolbarTitle = null;
        View view = this.BuiltInFictitiousFunctionClassFactory;
        if (view != null) {
            view.setOnClickListener(null);
            this.BuiltInFictitiousFunctionClassFactory = null;
        }
        View view2 = this.MyBillsEntityDataFactory;
        if (view2 != null) {
            view2.setOnClickListener(null);
            this.MyBillsEntityDataFactory = null;
        }
    }
}
