package id.dana.core.ui;

import android.content.Context;
import android.content.DialogInterface;
import android.graphics.drawable.ColorDrawable;
import android.view.Window;
import androidx.viewbinding.ViewBinding;
import com.afollestad.materialdialogs.MaterialDialog;
import com.afollestad.materialdialogs.customview.DialogCustomViewExtKt;
import id.dana.core.ui.util.ContextUtil;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\f\b&\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u0001*\u0004\b\u0001\u0010\u00032\u00020\u0004:\u0001!B#\b\u0016\u0012\u0006\u0010\u000e\u001a\u00020\r\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\u000f\u0012\u0006\u0010\u0012\u001a\u00028\u0001¢\u0006\u0004\b\u001f\u0010 B-\b\u0016\u0012\u0006\u0010\u000e\u001a\u00020\r\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\u000f\u0012\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011\u0012\u0006\u0010\u0013\u001a\u00028\u0001¢\u0006\u0004\b\u001f\u0010\u0014J\r\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\t\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\u000b\u001a\u00028\u0000H&¢\u0006\u0004\b\u000b\u0010\fJ3\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\r2\b\u0010\u0010\u001a\u0004\u0018\u00010\u000f2\b\u0010\u0012\u001a\u0004\u0018\u00010\u00112\u0006\u0010\u0013\u001a\u00028\u0001H\u0002¢\u0006\u0004\b\u0006\u0010\u0014J\r\u0010\u0016\u001a\u00020\u0015¢\u0006\u0004\b\u0016\u0010\u0017J\u000f\u0010\u0018\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\u0018\u0010\u0007J\u0017\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00028\u0001H&¢\u0006\u0004\b\u0006\u0010\u0019J\u000f\u0010\u001a\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u001a\u0010\u0007R\u0013\u0010\u0018\u001a\u00028\u0000X\u0084\u0080\u0002¢\u0006\u0006\n\u0004\b\u0006\u0010\u001bR\u0016\u0010\u000b\u001a\u00020\r8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b\u000b\u0010\u001cR\u001c\u0010\t\u001a\u0004\u0018\u00010\b8\u0005X\u0084\u0006¢\u0006\f\n\u0004\b\u0018\u0010\u001d\u001a\u0004\b\u001e\u0010\n"}, d2 = {"Lid/dana/core/ui/BaseViewBindingMaterialDialog;", "Landroidx/viewbinding/ViewBinding;", "VB", "E", "", "", "PlaceComponentResult", "()V", "Lcom/afollestad/materialdialogs/MaterialDialog;", "getAuthRequestContext", "()Lcom/afollestad/materialdialogs/MaterialDialog;", "MyBillsEntityDataFactory", "()Landroidx/viewbinding/ViewBinding;", "Landroid/content/Context;", "p0", "Landroid/content/DialogInterface$OnDismissListener;", "p1", "Landroid/content/DialogInterface$OnCancelListener;", "p2", "p3", "(Landroid/content/Context;Landroid/content/DialogInterface$OnDismissListener;Landroid/content/DialogInterface$OnCancelListener;Ljava/lang/Object;)V", "", "NetworkUserEntityData$$ExternalSyntheticLambda0", "()Z", "KClassImpl$Data$declaredNonStaticMembers$2", "(Ljava/lang/Object;)V", "moveToNextValue", "Lkotlin/Lazy;", "Landroid/content/Context;", "Lcom/afollestad/materialdialogs/MaterialDialog;", "BuiltInFictitiousFunctionClassFactory", "<init>", "(Landroid/content/Context;Landroid/content/DialogInterface$OnDismissListener;Ljava/lang/Object;)V", "Cancellation"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public abstract class BaseViewBindingMaterialDialog<VB extends ViewBinding, E> {

    /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
    private MaterialDialog getAuthRequestContext;
    public Context MyBillsEntityDataFactory;

    /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
    public final Lazy KClassImpl$Data$declaredNonStaticMembers$2;

    public abstract VB MyBillsEntityDataFactory();

    public abstract void PlaceComponentResult(E p0);

    /* JADX INFO: Access modifiers changed from: protected */
    @JvmName(name = "BuiltInFictitiousFunctionClassFactory")
    /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from getter */
    public final MaterialDialog getGetAuthRequestContext() {
        return this.getAuthRequestContext;
    }

    public BaseViewBindingMaterialDialog(Context context, DialogInterface.OnDismissListener onDismissListener, E e) {
        Intrinsics.checkNotNullParameter(context, "");
        this.KClassImpl$Data$declaredNonStaticMembers$2 = LazyKt.lazy(LazyThreadSafetyMode.NONE, new Function0<VB>(this) { // from class: id.dana.core.ui.BaseViewBindingMaterialDialog$binding$2
            final /* synthetic */ BaseViewBindingMaterialDialog<VB, E> this$0;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
                this.this$0 = this;
            }

            /* JADX WARN: Incorrect return type in method signature: ()TVB; */
            @Override // kotlin.jvm.functions.Function0
            public final ViewBinding invoke() {
                return this.this$0.MyBillsEntityDataFactory();
            }
        });
        PlaceComponentResult(context, onDismissListener, null, e);
    }

    public BaseViewBindingMaterialDialog(Context context, DialogInterface.OnDismissListener onDismissListener, DialogInterface.OnCancelListener onCancelListener, E e) {
        Intrinsics.checkNotNullParameter(context, "");
        this.KClassImpl$Data$declaredNonStaticMembers$2 = LazyKt.lazy(LazyThreadSafetyMode.NONE, new Function0<VB>(this) { // from class: id.dana.core.ui.BaseViewBindingMaterialDialog$binding$2
            final /* synthetic */ BaseViewBindingMaterialDialog<VB, E> this$0;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
                this.this$0 = this;
            }

            /* JADX WARN: Incorrect return type in method signature: ()TVB; */
            @Override // kotlin.jvm.functions.Function0
            public final ViewBinding invoke() {
                return this.this$0.MyBillsEntityDataFactory();
            }
        });
        PlaceComponentResult(context, onDismissListener, onCancelListener, e);
    }

    private final void PlaceComponentResult(Context p0, DialogInterface.OnDismissListener p1, DialogInterface.OnCancelListener p2, E p3) {
        MaterialDialog cancelable;
        this.MyBillsEntityDataFactory = p0;
        MaterialDialog materialDialog = new MaterialDialog(p0, MaterialDialog.INSTANCE.getDEFAULT_BEHAVIOR());
        this.getAuthRequestContext = materialDialog;
        materialDialog.setOnDismissListener(p1);
        MaterialDialog materialDialog2 = this.getAuthRequestContext;
        if (materialDialog2 != null) {
            materialDialog2.setOnCancelListener(p2);
        }
        MaterialDialog materialDialog3 = this.getAuthRequestContext;
        if (materialDialog3 != null) {
            DialogCustomViewExtKt.customView(materialDialog3, null, ((ViewBinding) this.KClassImpl$Data$declaredNonStaticMembers$2.getValue()).KClassImpl$Data$declaredNonStaticMembers$2(), false, true, false, false);
        }
        if (p3 instanceof Cancellation) {
            Cancellation cancellation = (Cancellation) p3;
            MaterialDialog materialDialog4 = this.getAuthRequestContext;
            if (materialDialog4 != null && (cancelable = materialDialog4.cancelable(cancellation.getBuiltInFictitiousFunctionClassFactory())) != null) {
                cancelable.cancelOnTouchOutside(cancellation.getKClassImpl$Data$declaredNonStaticMembers$2());
            }
        }
        PlaceComponentResult(p3);
        KClassImpl$Data$declaredNonStaticMembers$2();
    }

    private final void KClassImpl$Data$declaredNonStaticMembers$2() {
        MaterialDialog materialDialog = this.getAuthRequestContext;
        Window window = materialDialog != null ? materialDialog.getWindow() : null;
        if (window != null) {
            window.setBackgroundDrawable(new ColorDrawable(0));
        }
    }

    public void moveToNextValue() {
        MaterialDialog materialDialog;
        MaterialDialog materialDialog2 = this.getAuthRequestContext;
        boolean z = false;
        if (materialDialog2 != null && !materialDialog2.isShowing()) {
            z = true;
        }
        if (z) {
            ContextUtil contextUtil = ContextUtil.INSTANCE;
            Context context = this.MyBillsEntityDataFactory;
            if (context == null) {
                Intrinsics.throwUninitializedPropertyAccessException("");
                context = null;
            }
            if (!ContextUtil.getAuthRequestContext(context) || (materialDialog = this.getAuthRequestContext) == null) {
                return;
            }
            materialDialog.show();
        }
    }

    public final void PlaceComponentResult() {
        MaterialDialog materialDialog;
        ContextUtil contextUtil = ContextUtil.INSTANCE;
        Context context = this.MyBillsEntityDataFactory;
        if (context == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            context = null;
        }
        if (!ContextUtil.getAuthRequestContext(context) || (materialDialog = this.getAuthRequestContext) == null) {
            return;
        }
        materialDialog.dismiss();
    }

    public final boolean NetworkUserEntityData$$ExternalSyntheticLambda0() {
        MaterialDialog materialDialog = this.getAuthRequestContext;
        return materialDialog != null && materialDialog.isShowing();
    }

    public final MaterialDialog getAuthRequestContext() {
        return this.getAuthRequestContext;
    }

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\n\b\u0016\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\r\u0010\u000eJ\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0004¢\u0006\u0004\b\u0007\u0010\u0006R\u001a\u0010\u0005\u001a\u00020\u00028\u0007X\u0086\u0006¢\u0006\f\n\u0004\b\u0005\u0010\b\u001a\u0004\b\t\u0010\nR\u001a\u0010\f\u001a\u00020\u00028\u0007X\u0087\u0006¢\u0006\f\n\u0004\b\u000b\u0010\b\u001a\u0004\b\u0005\u0010\n"}, d2 = {"Lid/dana/core/ui/BaseViewBindingMaterialDialog$Cancellation;", "", "", "p0", "", "KClassImpl$Data$declaredNonStaticMembers$2", "(Z)V", "PlaceComponentResult", "Z", "MyBillsEntityDataFactory", "()Z", "getAuthRequestContext", "BuiltInFictitiousFunctionClassFactory", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes4.dex */
    public static class Cancellation {
        private boolean KClassImpl$Data$declaredNonStaticMembers$2 = true;

        /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
        private boolean BuiltInFictitiousFunctionClassFactory = true;

        @JvmName(name = "MyBillsEntityDataFactory")
        /* renamed from: MyBillsEntityDataFactory  reason: from getter */
        public final boolean getKClassImpl$Data$declaredNonStaticMembers$2() {
            return this.KClassImpl$Data$declaredNonStaticMembers$2;
        }

        @JvmName(name = "KClassImpl$Data$declaredNonStaticMembers$2")
        /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from getter */
        public final boolean getBuiltInFictitiousFunctionClassFactory() {
            return this.BuiltInFictitiousFunctionClassFactory;
        }

        public final void KClassImpl$Data$declaredNonStaticMembers$2(boolean p0) {
            this.KClassImpl$Data$declaredNonStaticMembers$2 = p0;
        }

        public final void PlaceComponentResult(boolean p0) {
            this.BuiltInFictitiousFunctionClassFactory = p0;
        }
    }
}
