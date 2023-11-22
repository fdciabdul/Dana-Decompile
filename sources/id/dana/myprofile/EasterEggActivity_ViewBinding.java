package id.dana.myprofile;

import android.view.View;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import id.dana.R;

/* loaded from: classes9.dex */
public class EasterEggActivity_ViewBinding implements Unbinder {
    private View BuiltInFictitiousFunctionClassFactory;
    private View KClassImpl$Data$declaredNonStaticMembers$2;
    private View MyBillsEntityDataFactory;
    private EasterEggActivity getAuthRequestContext;

    public EasterEggActivity_ViewBinding(final EasterEggActivity easterEggActivity, View view) {
        this.getAuthRequestContext = easterEggActivity;
        View BuiltInFictitiousFunctionClassFactory = Utils.BuiltInFictitiousFunctionClassFactory(view, R.id.activity_egg_text, "field 'contentDisplay' and method 'onTextLongClick'");
        easterEggActivity.contentDisplay = (TextView) Utils.BuiltInFictitiousFunctionClassFactory(BuiltInFictitiousFunctionClassFactory, R.id.activity_egg_text, "field 'contentDisplay'", TextView.class);
        this.BuiltInFictitiousFunctionClassFactory = BuiltInFictitiousFunctionClassFactory;
        BuiltInFictitiousFunctionClassFactory.setOnClickListener(new DebouncingOnClickListener() { // from class: id.dana.myprofile.EasterEggActivity_ViewBinding.1
            @Override // butterknife.internal.DebouncingOnClickListener
            public final void KClassImpl$Data$declaredNonStaticMembers$2(View view2) {
                easterEggActivity.onTextLongClick();
            }
        });
        View BuiltInFictitiousFunctionClassFactory2 = Utils.BuiltInFictitiousFunctionClassFactory(view, R.id.activity_egg_confirm, "method 'onConfirmButtonClick'");
        this.KClassImpl$Data$declaredNonStaticMembers$2 = BuiltInFictitiousFunctionClassFactory2;
        BuiltInFictitiousFunctionClassFactory2.setOnClickListener(new DebouncingOnClickListener() { // from class: id.dana.myprofile.EasterEggActivity_ViewBinding.2
            @Override // butterknife.internal.DebouncingOnClickListener
            public final void KClassImpl$Data$declaredNonStaticMembers$2(View view2) {
                easterEggActivity.onConfirmButtonClick();
            }
        });
        View BuiltInFictitiousFunctionClassFactory3 = Utils.BuiltInFictitiousFunctionClassFactory(view, R.id.activity_egg_copy, "method 'onCopyButtonClick'");
        this.MyBillsEntityDataFactory = BuiltInFictitiousFunctionClassFactory3;
        BuiltInFictitiousFunctionClassFactory3.setOnClickListener(new DebouncingOnClickListener() { // from class: id.dana.myprofile.EasterEggActivity_ViewBinding.3
            @Override // butterknife.internal.DebouncingOnClickListener
            public final void KClassImpl$Data$declaredNonStaticMembers$2(View view2) {
                easterEggActivity.onCopyButtonClick();
            }
        });
    }

    @Override // butterknife.Unbinder
    public final void getAuthRequestContext() {
        EasterEggActivity easterEggActivity = this.getAuthRequestContext;
        if (easterEggActivity == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.getAuthRequestContext = null;
        easterEggActivity.contentDisplay = null;
        this.BuiltInFictitiousFunctionClassFactory.setOnClickListener(null);
        this.BuiltInFictitiousFunctionClassFactory = null;
        this.KClassImpl$Data$declaredNonStaticMembers$2.setOnClickListener(null);
        this.KClassImpl$Data$declaredNonStaticMembers$2 = null;
        this.MyBillsEntityDataFactory.setOnClickListener(null);
        this.MyBillsEntityDataFactory = null;
    }
}
