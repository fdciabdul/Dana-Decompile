package id.dana.myprofile;

import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import id.dana.R;

/* loaded from: classes9.dex */
public class H5InputDialog_ViewBinding implements Unbinder {
    private H5InputDialog BuiltInFictitiousFunctionClassFactory;
    private View KClassImpl$Data$declaredNonStaticMembers$2;
    private View MyBillsEntityDataFactory;

    public H5InputDialog_ViewBinding(final H5InputDialog h5InputDialog, View view) {
        this.BuiltInFictitiousFunctionClassFactory = h5InputDialog;
        h5InputDialog.etInputUrl = (EditText) Utils.KClassImpl$Data$declaredNonStaticMembers$2(view, R.id.et_inputUrl, "field 'etInputUrl'", EditText.class);
        View BuiltInFictitiousFunctionClassFactory = Utils.BuiltInFictitiousFunctionClassFactory(view, R.id.tv_cancel, "field 'tvCancel' and method 'onCancelClick'");
        h5InputDialog.tvCancel = (TextView) Utils.BuiltInFictitiousFunctionClassFactory(BuiltInFictitiousFunctionClassFactory, R.id.tv_cancel, "field 'tvCancel'", TextView.class);
        this.KClassImpl$Data$declaredNonStaticMembers$2 = BuiltInFictitiousFunctionClassFactory;
        BuiltInFictitiousFunctionClassFactory.setOnClickListener(new DebouncingOnClickListener() { // from class: id.dana.myprofile.H5InputDialog_ViewBinding.1
            @Override // butterknife.internal.DebouncingOnClickListener
            public final void KClassImpl$Data$declaredNonStaticMembers$2(View view2) {
                h5InputDialog.onCancelClick();
            }
        });
        View BuiltInFictitiousFunctionClassFactory2 = Utils.BuiltInFictitiousFunctionClassFactory(view, R.id.tv_go, "field 'tvGo' and method 'onGoClick'");
        h5InputDialog.tvGo = (TextView) Utils.BuiltInFictitiousFunctionClassFactory(BuiltInFictitiousFunctionClassFactory2, R.id.tv_go, "field 'tvGo'", TextView.class);
        this.MyBillsEntityDataFactory = BuiltInFictitiousFunctionClassFactory2;
        BuiltInFictitiousFunctionClassFactory2.setOnClickListener(new DebouncingOnClickListener() { // from class: id.dana.myprofile.H5InputDialog_ViewBinding.2
            @Override // butterknife.internal.DebouncingOnClickListener
            public final void KClassImpl$Data$declaredNonStaticMembers$2(View view2) {
                h5InputDialog.onGoClick();
            }
        });
        h5InputDialog.tvTitle = (TextView) Utils.KClassImpl$Data$declaredNonStaticMembers$2(view, R.id.tv_title, "field 'tvTitle'", TextView.class);
    }

    @Override // butterknife.Unbinder
    public final void getAuthRequestContext() {
        H5InputDialog h5InputDialog = this.BuiltInFictitiousFunctionClassFactory;
        if (h5InputDialog == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.BuiltInFictitiousFunctionClassFactory = null;
        h5InputDialog.etInputUrl = null;
        h5InputDialog.tvCancel = null;
        h5InputDialog.tvGo = null;
        h5InputDialog.tvTitle = null;
        this.KClassImpl$Data$declaredNonStaticMembers$2.setOnClickListener(null);
        this.KClassImpl$Data$declaredNonStaticMembers$2 = null;
        this.MyBillsEntityDataFactory.setOnClickListener(null);
        this.MyBillsEntityDataFactory = null;
    }
}
