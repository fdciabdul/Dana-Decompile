package id.dana.base;

import android.content.Context;
import android.content.DialogInterface;
import android.graphics.drawable.ColorDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import butterknife.Unbinder;
import com.afollestad.materialdialogs.MaterialDialog;
import com.afollestad.materialdialogs.customview.DialogCustomViewExtKt;
import id.dana.base.BaseButterKnife;
import id.dana.utils.ContextUtil;

/* loaded from: classes.dex */
public abstract class BaseMaterialDialog<E> implements BaseButterKnife {
    protected MaterialDialog BuiltInFictitiousFunctionClassFactory;
    protected final E KClassImpl$Data$declaredNonStaticMembers$2;
    public final Context MyBillsEntityDataFactory;
    private boolean NetworkUserEntityData$$ExternalSyntheticLambda0;
    private final View PlaceComponentResult;
    private boolean getAuthRequestContext;
    private Unbinder lookAheadTest;

    /* JADX INFO: Access modifiers changed from: protected */
    public void getAuthRequestContext(View view, E e) {
    }

    public BaseMaterialDialog(Context context, DialogInterface.OnDismissListener onDismissListener, Integer num, E e) {
        this(context, onDismissListener, null, num, e);
    }

    public BaseMaterialDialog(Context context, DialogInterface.OnDismissListener onDismissListener, DialogInterface.OnCancelListener onCancelListener, Integer num, E e) {
        this.KClassImpl$Data$declaredNonStaticMembers$2 = e;
        View inflate = LayoutInflater.from(context).inflate(num.intValue(), (ViewGroup) null);
        this.PlaceComponentResult = inflate;
        this.MyBillsEntityDataFactory = context;
        MaterialDialog materialDialog = new MaterialDialog(context, MaterialDialog.getDEFAULT_BEHAVIOR());
        this.BuiltInFictitiousFunctionClassFactory = materialDialog;
        materialDialog.setOnDismissListener(onDismissListener);
        this.BuiltInFictitiousFunctionClassFactory.setOnCancelListener(onCancelListener);
        if (e instanceof PaddingViews) {
            PaddingViews paddingViews = (PaddingViews) e;
            this.NetworkUserEntityData$$ExternalSyntheticLambda0 = paddingViews.PlaceComponentResult;
            this.getAuthRequestContext = paddingViews.MyBillsEntityDataFactory;
        }
        DialogCustomViewExtKt.customView(this.BuiltInFictitiousFunctionClassFactory, null, inflate, false, this.NetworkUserEntityData$$ExternalSyntheticLambda0, this.getAuthRequestContext, false);
        if (e instanceof Cancellation) {
            Cancellation cancellation = (Cancellation) e;
            this.BuiltInFictitiousFunctionClassFactory.cancelable(cancellation.BuiltInFictitiousFunctionClassFactory).cancelOnTouchOutside(cancellation.getAuthRequestContext);
        }
        BuiltInFictitiousFunctionClassFactory(inflate);
        Window window = this.BuiltInFictitiousFunctionClassFactory.getWindow();
        if (window != null) {
            window.setBackgroundDrawable(new ColorDrawable(0));
        }
    }

    protected void BuiltInFictitiousFunctionClassFactory(View view) {
        if (this.lookAheadTest == null) {
            BaseButterKnife.CC.BuiltInFictitiousFunctionClassFactory(this, this, view);
        }
        getAuthRequestContext(view, this.KClassImpl$Data$declaredNonStaticMembers$2);
    }

    @Override // id.dana.base.BaseButterKnife
    public Unbinder getUnbinder() {
        return this.lookAheadTest;
    }

    @Override // id.dana.base.BaseButterKnife
    public void setUnbinder(Unbinder unbinder) {
        this.lookAheadTest = unbinder;
    }

    public void MyBillsEntityDataFactory() {
        View view = this.PlaceComponentResult;
        if (view != null) {
            BuiltInFictitiousFunctionClassFactory(view);
        }
        if (this.BuiltInFictitiousFunctionClassFactory.isShowing()) {
            return;
        }
        this.BuiltInFictitiousFunctionClassFactory.show();
    }

    public final void getAuthRequestContext() {
        if (ContextUtil.BuiltInFictitiousFunctionClassFactory(this.MyBillsEntityDataFactory)) {
            this.BuiltInFictitiousFunctionClassFactory.dismiss();
            BaseButterKnife.CC.BuiltInFictitiousFunctionClassFactory(this);
        }
    }

    public final boolean PlaceComponentResult() {
        MaterialDialog materialDialog = this.BuiltInFictitiousFunctionClassFactory;
        return materialDialog != null && materialDialog.isShowing();
    }

    public final MaterialDialog KClassImpl$Data$declaredNonStaticMembers$2() {
        return this.BuiltInFictitiousFunctionClassFactory;
    }

    /* loaded from: classes.dex */
    public static class Cancellation extends PaddingViews {
        private boolean getAuthRequestContext = true;
        private boolean BuiltInFictitiousFunctionClassFactory = true;

        /* JADX INFO: Access modifiers changed from: protected */
        public final void BuiltInFictitiousFunctionClassFactory(boolean z) {
            this.getAuthRequestContext = z;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        public final void getAuthRequestContext(boolean z) {
            this.BuiltInFictitiousFunctionClassFactory = z;
        }
    }

    /* loaded from: classes.dex */
    public static class PaddingViews {
        private boolean PlaceComponentResult = false;
        private boolean MyBillsEntityDataFactory = false;

        /* JADX INFO: Access modifiers changed from: protected */
        public final void getAuthRequestContext() {
            this.PlaceComponentResult = true;
        }
    }
}
