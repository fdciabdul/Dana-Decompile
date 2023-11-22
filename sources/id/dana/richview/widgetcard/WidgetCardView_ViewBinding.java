package id.dana.richview.widgetcard;

import android.view.View;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import id.dana.R;

/* loaded from: classes9.dex */
public final class WidgetCardView_ViewBinding implements Unbinder {
    private WidgetCardView KClassImpl$Data$declaredNonStaticMembers$2;
    private View getAuthRequestContext;

    public WidgetCardView_ViewBinding(final WidgetCardView widgetCardView, View view) {
        this.KClassImpl$Data$declaredNonStaticMembers$2 = widgetCardView;
        View BuiltInFictitiousFunctionClassFactory = Utils.BuiltInFictitiousFunctionClassFactory(view, R.id.btn_widget_view_all, "method 'onViewAllClicked'");
        this.getAuthRequestContext = BuiltInFictitiousFunctionClassFactory;
        BuiltInFictitiousFunctionClassFactory.setOnClickListener(new DebouncingOnClickListener() { // from class: id.dana.richview.widgetcard.WidgetCardView_ViewBinding.1
            @Override // butterknife.internal.DebouncingOnClickListener
            public final void KClassImpl$Data$declaredNonStaticMembers$2(View view2) {
                widgetCardView.onViewAllClicked(view2);
            }
        });
    }

    @Override // butterknife.Unbinder
    public final void getAuthRequestContext() {
        if (this.KClassImpl$Data$declaredNonStaticMembers$2 == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.KClassImpl$Data$declaredNonStaticMembers$2 = null;
        this.getAuthRequestContext.setOnClickListener(null);
        this.getAuthRequestContext = null;
    }
}
