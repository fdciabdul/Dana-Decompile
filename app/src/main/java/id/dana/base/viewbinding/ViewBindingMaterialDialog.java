package id.dana.base.viewbinding;

import android.content.Context;
import android.content.DialogInterface;
import android.view.View;
import androidx.viewbinding.ViewBinding;
import id.dana.base.BaseMaterialDialog;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\b&\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u0001*\u0004\b\u0001\u0010\u00032\b\u0012\u0004\u0012\u00028\u00010\u0004B+\b\u0016\u0012\u0006\u0010\u0006\u001a\u00020\u0010\u0012\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011\u0012\u0006\u0010\u0014\u001a\u00020\u0013\u0012\u0006\u0010\u0015\u001a\u00028\u0001¢\u0006\u0004\b\u0016\u0010\u0017J\u0017\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0005H\u0014¢\u0006\u0004\b\b\u0010\tJ\u0017\u0010\n\u001a\u00028\u00002\u0006\u0010\u0006\u001a\u00020\u0005H$¢\u0006\u0004\b\n\u0010\u000bR\u001a\u0010\u000f\u001a\u00028\u00008\u0005X\u0084&¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\b\u0010\u000e"}, d2 = {"Lid/dana/base/viewbinding/ViewBindingMaterialDialog;", "Landroidx/viewbinding/ViewBinding;", "V", "E", "Lid/dana/base/BaseMaterialDialog;", "Landroid/view/View;", "p0", "", "BuiltInFictitiousFunctionClassFactory", "(Landroid/view/View;)V", "PlaceComponentResult", "(Landroid/view/View;)Landroidx/viewbinding/ViewBinding;", "getAuthRequestContext", "Landroidx/viewbinding/ViewBinding;", "()Landroidx/viewbinding/ViewBinding;", "MyBillsEntityDataFactory", "Landroid/content/Context;", "Landroid/content/DialogInterface$OnDismissListener;", "p1", "", "p2", "p3", "<init>", "(Landroid/content/Context;Landroid/content/DialogInterface$OnDismissListener;ILjava/lang/Object;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes.dex */
public abstract class ViewBindingMaterialDialog<V extends ViewBinding, E> extends BaseMaterialDialog<E> {

    /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
    protected V MyBillsEntityDataFactory;

    protected abstract V PlaceComponentResult(View p0);

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ViewBindingMaterialDialog(Context context, DialogInterface.OnDismissListener onDismissListener, int i, E e) {
        super(context, onDismissListener, Integer.valueOf(i), e);
        Intrinsics.checkNotNullParameter(context, "");
    }

    @Override // id.dana.base.BaseMaterialDialog
    public final void BuiltInFictitiousFunctionClassFactory(View p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        V PlaceComponentResult = PlaceComponentResult(p0);
        Intrinsics.checkNotNullParameter(PlaceComponentResult, "");
        this.MyBillsEntityDataFactory = PlaceComponentResult;
        if (PlaceComponentResult == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            PlaceComponentResult = null;
        }
        getAuthRequestContext(PlaceComponentResult.KClassImpl$Data$declaredNonStaticMembers$2(), this.KClassImpl$Data$declaredNonStaticMembers$2);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @JvmName(name = "BuiltInFictitiousFunctionClassFactory")
    public final V BuiltInFictitiousFunctionClassFactory() {
        V v = this.MyBillsEntityDataFactory;
        if (v != null) {
            return v;
        }
        Intrinsics.throwUninitializedPropertyAccessException("");
        return null;
    }
}
