package id.dana.sendmoney.remarks;

import android.view.View;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import id.dana.R;

/* loaded from: classes9.dex */
public final class NoteView_ViewBinding implements Unbinder {
    private NoteView MyBillsEntityDataFactory;
    private View getAuthRequestContext;

    public NoteView_ViewBinding(final NoteView noteView, View view) {
        this.MyBillsEntityDataFactory = noteView;
        View BuiltInFictitiousFunctionClassFactory = Utils.BuiltInFictitiousFunctionClassFactory(view, R.id.btn_action, "method 'onBtnActionClicked'");
        this.getAuthRequestContext = BuiltInFictitiousFunctionClassFactory;
        BuiltInFictitiousFunctionClassFactory.setOnClickListener(new DebouncingOnClickListener() { // from class: id.dana.sendmoney.remarks.NoteView_ViewBinding.1
            @Override // butterknife.internal.DebouncingOnClickListener
            public final void KClassImpl$Data$declaredNonStaticMembers$2(View view2) {
                noteView.onBtnActionClicked();
            }
        });
    }

    @Override // butterknife.Unbinder
    public final void getAuthRequestContext() {
        if (this.MyBillsEntityDataFactory == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.MyBillsEntityDataFactory = null;
        this.getAuthRequestContext.setOnClickListener(null);
        this.getAuthRequestContext = null;
    }
}
