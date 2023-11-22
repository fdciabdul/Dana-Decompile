package id.dana.cashier;

import android.content.Context;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import androidx.appcompat.widget.AppCompatCheckBox;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.core.content.ContextCompat;
import androidx.viewbinding.ViewBinding;
import com.ethanhua.skeleton.Skeleton;
import com.ethanhua.skeleton.SkeletonScreen;
import com.ethanhua.skeleton.ViewSkeletonScreen;
import id.dana.component.buttoncomponent.DanaButtonPrimaryView;
import id.dana.core.ui.BaseViewBindingMaterialDialog;
import id.dana.databinding.DialogPaylaterCicilOnboardingBinding;
import id.dana.extension.view.InputExtKt;
import id.dana.utils.LocaleUtil;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001\u0018B)\b\u0002\u0012\u0006\u0010\t\u001a\u00020\u0013\u0012\u0006\u0010\n\u001a\u00020\u0014\u0012\u0006\u0010\u000b\u001a\u00020\u0015\u0012\u0006\u0010\u000e\u001a\u00020\u0003¢\u0006\u0004\b\u0016\u0010\u0017J\u000f\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0005\u0010\u0006JC\u0010\u0005\u001a\u00020\r*\u00020\u00072\b\u0010\t\u001a\u0004\u0018\u00010\b2\u0006\u0010\n\u001a\u00020\b2\b\u0010\u000b\u001a\u0004\u0018\u00010\b2\u0012\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\r0\fH\u0002¢\u0006\u0004\b\u0005\u0010\u000fR\u0018\u0010\u0012\u001a\u0004\u0018\u00010\u00108\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0005\u0010\u0011"}, d2 = {"Lid/dana/cashier/PaylaterCicilOnboardingDialog;", "Lid/dana/core/ui/BaseViewBindingMaterialDialog;", "Lid/dana/databinding/DialogPaylaterCicilOnboardingBinding;", "Lid/dana/cashier/PaylaterCicilOnboardingDialog$Builder;", "", "KClassImpl$Data$declaredNonStaticMembers$2", "()I", "Landroidx/appcompat/widget/AppCompatTextView;", "", "p0", "p1", "p2", "Lkotlin/Function1;", "", "p3", "(Landroidx/appcompat/widget/AppCompatTextView;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkotlin/jvm/functions/Function1;)V", "Lcom/ethanhua/skeleton/SkeletonScreen;", "Lcom/ethanhua/skeleton/SkeletonScreen;", "getAuthRequestContext", "Landroid/content/Context;", "Landroid/content/DialogInterface$OnDismissListener;", "Landroid/content/DialogInterface$OnCancelListener;", "<init>", "(Landroid/content/Context;Landroid/content/DialogInterface$OnDismissListener;Landroid/content/DialogInterface$OnCancelListener;Lid/dana/cashier/PaylaterCicilOnboardingDialog$Builder;)V", "Builder"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class PaylaterCicilOnboardingDialog extends BaseViewBindingMaterialDialog<DialogPaylaterCicilOnboardingBinding, Builder> {

    /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
    public SkeletonScreen getAuthRequestContext;

    public /* synthetic */ PaylaterCicilOnboardingDialog(Context context, DialogInterface.OnDismissListener onDismissListener, DialogInterface.OnCancelListener onCancelListener, Builder builder, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, onDismissListener, onCancelListener, builder);
    }

    @Override // id.dana.core.ui.BaseViewBindingMaterialDialog
    public final /* synthetic */ void PlaceComponentResult(Builder builder) {
        Intrinsics.checkNotNullParameter(builder, "");
        SkeletonScreen skeletonScreen = this.getAuthRequestContext;
        if (skeletonScreen == null) {
            byte b = 0;
            if (skeletonScreen == null) {
                ViewSkeletonScreen.Builder BuiltInFictitiousFunctionClassFactory = Skeleton.BuiltInFictitiousFunctionClassFactory(((DialogPaylaterCicilOnboardingBinding) ((ViewBinding) this.KClassImpl$Data$declaredNonStaticMembers$2.getValue())).MyBillsEntityDataFactory);
                BuiltInFictitiousFunctionClassFactory.getAuthRequestContext = id.dana.R.layout.view_skeleton_paylater_onboarding_dialog;
                BuiltInFictitiousFunctionClassFactory.PlaceComponentResult = 1000;
                BuiltInFictitiousFunctionClassFactory.KClassImpl$Data$declaredNonStaticMembers$2 = true;
                BuiltInFictitiousFunctionClassFactory.MyBillsEntityDataFactory = ContextCompat.BuiltInFictitiousFunctionClassFactory(BuiltInFictitiousFunctionClassFactory.lookAheadTest.getContext(), id.dana.R.color.res_0x7f060349_networkuserentitydata_externalsyntheticlambda2);
                ViewSkeletonScreen viewSkeletonScreen = new ViewSkeletonScreen(BuiltInFictitiousFunctionClassFactory, b);
                viewSkeletonScreen.MyBillsEntityDataFactory();
                this.getAuthRequestContext = viewSkeletonScreen;
            } else if (skeletonScreen != null) {
                skeletonScreen.MyBillsEntityDataFactory();
            }
            DialogPaylaterCicilOnboardingBinding dialogPaylaterCicilOnboardingBinding = (DialogPaylaterCicilOnboardingBinding) ((ViewBinding) this.KClassImpl$Data$declaredNonStaticMembers$2.getValue());
            dialogPaylaterCicilOnboardingBinding.BuiltInFictitiousFunctionClassFactory.setEnabled(false);
            AppCompatTextView appCompatTextView = dialogPaylaterCicilOnboardingBinding.scheduleImpl;
            Intrinsics.checkNotNullExpressionValue(appCompatTextView, "");
            Context context = this.MyBillsEntityDataFactory;
            Context context2 = null;
            if (context == null) {
                Intrinsics.throwUninitializedPropertyAccessException("");
                context = null;
            }
            String string = context.getString(id.dana.R.string.paylater_tnc_onboarding);
            Context context3 = this.MyBillsEntityDataFactory;
            if (context3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("");
                context3 = null;
            }
            String string2 = context3.getString(id.dana.R.string.tnc);
            Intrinsics.checkNotNullExpressionValue(string2, "");
            KClassImpl$Data$declaredNonStaticMembers$2(appCompatTextView, string, string2, "", new Function1<String, Unit>() { // from class: id.dana.cashier.PaylaterCicilOnboardingDialog$setSpanText$1
                /* renamed from: invoke  reason: avoid collision after fix types in other method */
                public final void invoke2(String str) {
                    Intrinsics.checkNotNullParameter(str, "");
                }

                @Override // kotlin.jvm.functions.Function1
                public final /* bridge */ /* synthetic */ Unit invoke(String str) {
                    invoke2(str);
                    return Unit.INSTANCE;
                }
            });
            DanaButtonPrimaryView danaButtonPrimaryView = dialogPaylaterCicilOnboardingBinding.KClassImpl$Data$declaredNonStaticMembers$2;
            Context context4 = this.MyBillsEntityDataFactory;
            if (context4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("");
            } else {
                context2 = context4;
            }
            danaButtonPrimaryView.setDisabled(context2.getString(id.dana.R.string.btn_activate_onboarding_paylater_cicil));
            AppCompatImageView appCompatImageView = dialogPaylaterCicilOnboardingBinding.getAuthRequestContext;
            Intrinsics.checkNotNullExpressionValue(appCompatImageView, "");
            appCompatImageView.setVisibility(8);
        }
    }

    private PaylaterCicilOnboardingDialog(Context context, DialogInterface.OnDismissListener onDismissListener, DialogInterface.OnCancelListener onCancelListener, Builder builder) {
        super(context, onDismissListener, onCancelListener, builder);
    }

    public static void KClassImpl$Data$declaredNonStaticMembers$2(AppCompatTextView appCompatTextView, String str, String str2, final String str3, final Function1<? super String, Unit> function1) {
        appCompatTextView.setText(str);
        appCompatTextView.setClickable(true);
        appCompatTextView.setFocusable(true);
        InputExtKt.getAuthRequestContext(appCompatTextView, id.dana.R.color.f22912131099753, str2, false, new Function0<Unit>() { // from class: id.dana.cashier.PaylaterCicilOnboardingDialog$setSpanText$2$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2() {
                String str4 = str3;
                boolean z = false;
                if (str4 != null) {
                    if (str4.length() > 0) {
                        z = true;
                    }
                }
                if (z) {
                    function1.invoke(str3);
                }
            }
        });
    }

    public static int KClassImpl$Data$declaredNonStaticMembers$2() {
        return LocaleUtil.BuiltInFictitiousFunctionClassFactory() ? id.dana.R.drawable.ic_dana_cicil_onboarding_id : id.dana.R.drawable.ic_dana_cicil_onboarding_en;
    }

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\f\u001a\u00020\u0002\u0012\u0006\u0010\r\u001a\u00020\t\u0012\u0006\u0010\u000e\u001a\u00020\u0006¢\u0006\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0005\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0003\u001a\u00020\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\bR\u0014\u0010\n\u001a\u00020\t8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\n\u0010\u000b"}, d2 = {"Lid/dana/cashier/PaylaterCicilOnboardingDialog$Builder;", "Lid/dana/core/ui/BaseViewBindingMaterialDialog$Cancellation;", "Landroid/content/Context;", "getAuthRequestContext", "Landroid/content/Context;", "KClassImpl$Data$declaredNonStaticMembers$2", "Landroid/content/DialogInterface$OnCancelListener;", "MyBillsEntityDataFactory", "Landroid/content/DialogInterface$OnCancelListener;", "Landroid/content/DialogInterface$OnDismissListener;", "PlaceComponentResult", "Landroid/content/DialogInterface$OnDismissListener;", "p0", "p1", "p2", "<init>", "(Landroid/content/Context;Landroid/content/DialogInterface$OnDismissListener;Landroid/content/DialogInterface$OnCancelListener;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes4.dex */
    public static final class Builder extends BaseViewBindingMaterialDialog.Cancellation {

        /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
        public final DialogInterface.OnCancelListener getAuthRequestContext;
        public final DialogInterface.OnDismissListener PlaceComponentResult;

        /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
        public final Context KClassImpl$Data$declaredNonStaticMembers$2;

        public Builder(Context context, DialogInterface.OnDismissListener onDismissListener, DialogInterface.OnCancelListener onCancelListener) {
            Intrinsics.checkNotNullParameter(context, "");
            Intrinsics.checkNotNullParameter(onDismissListener, "");
            Intrinsics.checkNotNullParameter(onCancelListener, "");
            this.KClassImpl$Data$declaredNonStaticMembers$2 = context;
            this.PlaceComponentResult = onDismissListener;
            this.getAuthRequestContext = onCancelListener;
            PlaceComponentResult(false);
            KClassImpl$Data$declaredNonStaticMembers$2(true);
        }
    }

    public static /* synthetic */ void BuiltInFictitiousFunctionClassFactory(View.OnClickListener onClickListener, View view) {
        if (onClickListener != null) {
            onClickListener.onClick(view);
        }
    }

    public static /* synthetic */ void PlaceComponentResult(AppCompatCheckBox appCompatCheckBox, DialogPaylaterCicilOnboardingBinding dialogPaylaterCicilOnboardingBinding) {
        Intrinsics.checkNotNullParameter(appCompatCheckBox, "");
        Intrinsics.checkNotNullParameter(dialogPaylaterCicilOnboardingBinding, "");
        if (appCompatCheckBox.isChecked()) {
            dialogPaylaterCicilOnboardingBinding.KClassImpl$Data$declaredNonStaticMembers$2.setActiveButton(appCompatCheckBox.getContext().getString(id.dana.R.string.btn_activate_onboarding_paylater_cicil), null);
        } else {
            dialogPaylaterCicilOnboardingBinding.KClassImpl$Data$declaredNonStaticMembers$2.setDisabled(appCompatCheckBox.getContext().getString(id.dana.R.string.btn_activate_onboarding_paylater_cicil));
        }
        dialogPaylaterCicilOnboardingBinding.KClassImpl$Data$declaredNonStaticMembers$2.setEnabled(appCompatCheckBox.isChecked());
    }

    public static /* synthetic */ void KClassImpl$Data$declaredNonStaticMembers$2(View.OnClickListener onClickListener, View view) {
        if (onClickListener != null) {
            onClickListener.onClick(view);
        }
    }

    @Override // id.dana.core.ui.BaseViewBindingMaterialDialog
    public final /* synthetic */ DialogPaylaterCicilOnboardingBinding MyBillsEntityDataFactory() {
        Context context = this.MyBillsEntityDataFactory;
        if (context == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            context = null;
        }
        DialogPaylaterCicilOnboardingBinding MyBillsEntityDataFactory = DialogPaylaterCicilOnboardingBinding.MyBillsEntityDataFactory(LayoutInflater.from(context));
        Intrinsics.checkNotNullExpressionValue(MyBillsEntityDataFactory, "");
        return MyBillsEntityDataFactory;
    }
}
