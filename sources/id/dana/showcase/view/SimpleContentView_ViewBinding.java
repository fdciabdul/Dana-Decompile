package id.dana.showcase.view;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import id.dana.R;

/* loaded from: classes9.dex */
public class SimpleContentView_ViewBinding implements Unbinder {
    private SimpleContentView KClassImpl$Data$declaredNonStaticMembers$2;
    private View getAuthRequestContext;

    public SimpleContentView_ViewBinding(final SimpleContentView simpleContentView, View view) {
        this.KClassImpl$Data$declaredNonStaticMembers$2 = simpleContentView;
        View BuiltInFictitiousFunctionClassFactory = Utils.BuiltInFictitiousFunctionClassFactory(view, R.id.getAuthRequestContext_res_0x7f0a025a, "field 'button' and method 'onButtonClick'");
        simpleContentView.button = (Button) Utils.BuiltInFictitiousFunctionClassFactory(BuiltInFictitiousFunctionClassFactory, R.id.getAuthRequestContext_res_0x7f0a025a, "field 'button'", Button.class);
        this.getAuthRequestContext = BuiltInFictitiousFunctionClassFactory;
        BuiltInFictitiousFunctionClassFactory.setOnClickListener(new DebouncingOnClickListener() { // from class: id.dana.showcase.view.SimpleContentView_ViewBinding.1
            @Override // butterknife.internal.DebouncingOnClickListener
            public final void KClassImpl$Data$declaredNonStaticMembers$2(View view2) {
                simpleContentView.onButtonClick();
            }
        });
        simpleContentView.title = (TextView) Utils.KClassImpl$Data$declaredNonStaticMembers$2(view, R.id.title, "field 'title'", TextView.class);
        simpleContentView.description = (TextView) Utils.KClassImpl$Data$declaredNonStaticMembers$2(view, R.id.description, "field 'description'", TextView.class);
    }

    @Override // butterknife.Unbinder
    public final void getAuthRequestContext() {
        SimpleContentView simpleContentView = this.KClassImpl$Data$declaredNonStaticMembers$2;
        if (simpleContentView == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.KClassImpl$Data$declaredNonStaticMembers$2 = null;
        simpleContentView.button = null;
        simpleContentView.title = null;
        simpleContentView.description = null;
        this.getAuthRequestContext.setOnClickListener(null);
        this.getAuthRequestContext = null;
    }
}
