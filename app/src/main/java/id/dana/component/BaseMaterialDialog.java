package id.dana.component;

import android.content.Context;
import android.content.DialogInterface;
import android.view.View;
import com.afollestad.materialdialogs.MaterialDialog;
import com.afollestad.materialdialogs.customview.DialogCustomViewExtKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\b\b&\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002:\u0001\u001fB)\u0012\u0006\u0010\u0007\u001a\u00020\u000f\u0012\u0006\u0010\b\u001a\u00020\u0017\u0012\u0006\u0010\u001b\u001a\u00028\u0000\u0012\b\u0010\u001c\u001a\u0004\u0018\u00010\u0015¢\u0006\u0004\b\u001d\u0010\u001eJ\r\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u001f\u0010\n\u001a\u00020\t2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00028\u0000H$¢\u0006\u0004\b\n\u0010\u000bR\u0014\u0010\u000e\u001a\u00028\u00008\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\f\u0010\rR\u0011\u0010\u0004\u001a\u00020\u000fX\u0006¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u0018\u0010\n\u001a\u0004\u0018\u00010\u00038\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0004\u0010\u0012R\u001a\u0010\u0010\u001a\u00020\u00068\u0005X\u0084&¢\u0006\f\n\u0004\b\n\u0010\u0013\u001a\u0004\b\u0010\u0010\u0014R\u0016\u0010\f\u001a\u0004\u0018\u00010\u00158\u0002X\u0083\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\u0016R\u0014\u0010\u001a\u001a\u00020\u00178\u0002X\u0083\u0004¢\u0006\u0006\n\u0004\b\u0018\u0010\u0019"}, d2 = {"Lid/dana/component/BaseMaterialDialog;", "E", "", "Lcom/afollestad/materialdialogs/MaterialDialog;", "PlaceComponentResult", "()Lcom/afollestad/materialdialogs/MaterialDialog;", "Landroid/view/View;", "p0", "p1", "", "KClassImpl$Data$declaredNonStaticMembers$2", "(Landroid/view/View;Ljava/lang/Object;)V", "MyBillsEntityDataFactory", "Ljava/lang/Object;", "getAuthRequestContext", "Landroid/content/Context;", "BuiltInFictitiousFunctionClassFactory", "Landroid/content/Context;", "Lcom/afollestad/materialdialogs/MaterialDialog;", "Landroid/view/View;", "()Landroid/view/View;", "Landroid/content/DialogInterface$OnDismissListener;", "Landroid/content/DialogInterface$OnDismissListener;", "", "lookAheadTest", "I", "moveToNextValue", "p2", "p3", "<init>", "(Landroid/content/Context;ILjava/lang/Object;Landroid/content/DialogInterface$OnDismissListener;)V", "Cancellation"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes4.dex */
public abstract class BaseMaterialDialog<E> {

    /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
    public final Context PlaceComponentResult;

    /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
    protected View BuiltInFictitiousFunctionClassFactory;

    /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
    private final E getAuthRequestContext;

    /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
    public MaterialDialog KClassImpl$Data$declaredNonStaticMembers$2;

    /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
    private final DialogInterface.OnDismissListener MyBillsEntityDataFactory;

    /* renamed from: lookAheadTest  reason: from kotlin metadata */
    private final int moveToNextValue;

    protected abstract void KClassImpl$Data$declaredNonStaticMembers$2(View p0, E p1);

    public BaseMaterialDialog(Context context, int i, E e, DialogInterface.OnDismissListener onDismissListener) {
        Intrinsics.checkNotNullParameter(context, "");
        this.PlaceComponentResult = context;
        this.moveToNextValue = i;
        this.getAuthRequestContext = e;
        this.MyBillsEntityDataFactory = onDismissListener;
    }

    @JvmName(name = "BuiltInFictitiousFunctionClassFactory")
    public final View BuiltInFictitiousFunctionClassFactory() {
        View view = this.BuiltInFictitiousFunctionClassFactory;
        if (view == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
        }
        return view;
    }

    /* JADX WARN: Type inference failed for: r2v0, types: [com.afollestad.materialdialogs.DialogBehavior, kotlin.jvm.internal.DefaultConstructorMarker] */
    public final MaterialDialog PlaceComponentResult() {
        ?? r2 = 0;
        View inflate = View.inflate(this.PlaceComponentResult, this.moveToNextValue, null);
        Intrinsics.checkNotNullExpressionValue(inflate, "");
        this.BuiltInFictitiousFunctionClassFactory = inflate;
        MaterialDialog materialDialog = new MaterialDialog(this.PlaceComponentResult, r2, 2, r2);
        E e = this.getAuthRequestContext;
        MaterialDialog cancelable = materialDialog.cancelable((e instanceof Cancellation) && ((Cancellation) e).getMyBillsEntityDataFactory());
        E e2 = this.getAuthRequestContext;
        MaterialDialog cornerRadius$default = MaterialDialog.cornerRadius$default(cancelable.cancelOnTouchOutside((e2 instanceof Cancellation) && ((Cancellation) e2).getKClassImpl$Data$declaredNonStaticMembers$2()), Float.valueOf(8.0f), null, 2, null);
        View view = this.BuiltInFictitiousFunctionClassFactory;
        if (view == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
        }
        MaterialDialog customView$default = DialogCustomViewExtKt.customView$default(cornerRadius$default, null, view, false, false, false, false, 61, null);
        customView$default.setOnDismissListener(this.MyBillsEntityDataFactory);
        Unit unit = Unit.INSTANCE;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = customView$default;
        View view2 = this.BuiltInFictitiousFunctionClassFactory;
        if (view2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
        }
        KClassImpl$Data$declaredNonStaticMembers$2(view2, this.getAuthRequestContext);
        MaterialDialog materialDialog2 = this.KClassImpl$Data$declaredNonStaticMembers$2;
        Intrinsics.checkNotNull(materialDialog2);
        return materialDialog2;
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\n\b\u0016\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u000b\u0010\fJ\u0017\u0010\u0004\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0004\u0010\u0005J\u0017\u0010\u0006\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0006\u0010\u0005R\u001a\u0010\n\u001a\u00020\u00028\u0001X\u0080\u0006¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\u0007\u0010\tR\u001a\u0010\u0004\u001a\u00020\u00028\u0001X\u0081\u0006¢\u0006\f\n\u0004\b\u0004\u0010\b\u001a\u0004\b\n\u0010\t"}, d2 = {"Lid/dana/component/BaseMaterialDialog$Cancellation;", "", "", "p0", "MyBillsEntityDataFactory", "(Z)Lid/dana/component/BaseMaterialDialog$Cancellation;", "BuiltInFictitiousFunctionClassFactory", "getAuthRequestContext", "Z", "()Z", "KClassImpl$Data$declaredNonStaticMembers$2", "<init>", "()V"}, k = 1, mv = {1, 4, 2})
    /* loaded from: classes.dex */
    public static class Cancellation {

        /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
        private boolean KClassImpl$Data$declaredNonStaticMembers$2 = true;
        private boolean MyBillsEntityDataFactory = true;

        @JvmName(name = "getAuthRequestContext")
        /* renamed from: getAuthRequestContext  reason: from getter */
        public final boolean getKClassImpl$Data$declaredNonStaticMembers$2() {
            return this.KClassImpl$Data$declaredNonStaticMembers$2;
        }

        @JvmName(name = "KClassImpl$Data$declaredNonStaticMembers$2")
        /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from getter */
        public final boolean getMyBillsEntityDataFactory() {
            return this.MyBillsEntityDataFactory;
        }

        public Cancellation MyBillsEntityDataFactory(boolean p0) {
            this.KClassImpl$Data$declaredNonStaticMembers$2 = p0;
            return this;
        }

        public Cancellation BuiltInFictitiousFunctionClassFactory(boolean p0) {
            this.MyBillsEntityDataFactory = p0;
            return this;
        }
    }
}
