package id.dana.pay.screen;

import android.view.View;
import android.widget.ImageView;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import id.dana.R;
import id.dana.pay.BasePayFragment_ViewBinding;
import id.dana.richview.DanaProtectionView;

/* loaded from: classes9.dex */
public class AddNewCardFragment_ViewBinding extends BasePayFragment_ViewBinding {
    private AddNewCardFragment BuiltInFictitiousFunctionClassFactory;
    private View KClassImpl$Data$declaredNonStaticMembers$2;

    public AddNewCardFragment_ViewBinding(final AddNewCardFragment addNewCardFragment, View view) {
        super(addNewCardFragment, view);
        this.BuiltInFictitiousFunctionClassFactory = addNewCardFragment;
        addNewCardFragment.expressPayView = (ImageView) Utils.KClassImpl$Data$declaredNonStaticMembers$2(view, R.id.iv_expresspay, "field 'expressPayView'", ImageView.class);
        addNewCardFragment.danaProtectionView = (DanaProtectionView) Utils.KClassImpl$Data$declaredNonStaticMembers$2(view, R.id.view_dana_protection, "field 'danaProtectionView'", DanaProtectionView.class);
        View BuiltInFictitiousFunctionClassFactory = Utils.BuiltInFictitiousFunctionClassFactory(view, R.id.card_add, "method 'onParentLayoutClicked'");
        this.KClassImpl$Data$declaredNonStaticMembers$2 = BuiltInFictitiousFunctionClassFactory;
        BuiltInFictitiousFunctionClassFactory.setOnClickListener(new DebouncingOnClickListener() { // from class: id.dana.pay.screen.AddNewCardFragment_ViewBinding.1
            @Override // butterknife.internal.DebouncingOnClickListener
            public final void KClassImpl$Data$declaredNonStaticMembers$2(View view2) {
                addNewCardFragment.onParentLayoutClicked();
            }
        });
    }

    @Override // id.dana.pay.BasePayFragment_ViewBinding, butterknife.Unbinder
    public final void getAuthRequestContext() {
        AddNewCardFragment addNewCardFragment = this.BuiltInFictitiousFunctionClassFactory;
        if (addNewCardFragment == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.BuiltInFictitiousFunctionClassFactory = null;
        addNewCardFragment.expressPayView = null;
        addNewCardFragment.danaProtectionView = null;
        this.KClassImpl$Data$declaredNonStaticMembers$2.setOnClickListener(null);
        this.KClassImpl$Data$declaredNonStaticMembers$2 = null;
        super.getAuthRequestContext();
    }
}
