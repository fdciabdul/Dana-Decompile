package id.dana.dialog;

import android.app.Dialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import androidx.appcompat.app.AppCompatDialogFragment;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import id.dana.R;
import id.dana.component.BaseMaterialDialog;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 \u00112\u00020\u0001:\u0002\u0012\u0011B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u000b¢\u0006\u0004\b\u000f\u0010\u0010J-\u0010\t\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016¢\u0006\u0004\b\t\u0010\nR\u0014\u0010\u000e\u001a\u00020\u000b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\f\u0010\r"}, d2 = {"Lid/dana/dialog/DialogContactUs;", "Landroidx/appcompat/app/AppCompatDialogFragment;", "Landroid/view/LayoutInflater;", "p0", "Landroid/view/ViewGroup;", "p1", "Landroid/os/Bundle;", "p2", "Landroid/view/View;", "onCreateView", "(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;", "Lid/dana/dialog/DialogContactUs$Builder;", "KClassImpl$Data$declaredNonStaticMembers$2", "Lid/dana/dialog/DialogContactUs$Builder;", "BuiltInFictitiousFunctionClassFactory", "<init>", "(Lid/dana/dialog/DialogContactUs$Builder;)V", "Companion", "Builder"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class DialogContactUs extends AppCompatDialogFragment {

    /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
    private final Builder BuiltInFictitiousFunctionClassFactory;
    public Map<Integer, View> MyBillsEntityDataFactory;

    public DialogContactUs(Builder builder) {
        Intrinsics.checkNotNullParameter(builder, "");
        this.MyBillsEntityDataFactory = new LinkedHashMap();
        this.BuiltInFictitiousFunctionClassFactory = builder;
    }

    @Override // androidx.fragment.app.Fragment
    public final View onCreateView(LayoutInflater p0, ViewGroup p1, Bundle p2) {
        Window window;
        Intrinsics.checkNotNullParameter(p0, "");
        View inflate = p0.inflate(R.layout.dialog_contact_us, p1, false);
        if (inflate != null) {
            Dialog dialog = getDialog();
            if (dialog != null && (window = dialog.getWindow()) != null) {
                window.setBackgroundDrawableResource(R.drawable.bg_white);
            }
            AppCompatTextView appCompatTextView = (AppCompatTextView) inflate.findViewById(R.id.tv_call_number);
            if (appCompatTextView != null) {
                appCompatTextView.setText(this.BuiltInFictitiousFunctionClassFactory.getAuthRequestContext);
            }
            AppCompatTextView appCompatTextView2 = (AppCompatTextView) inflate.findViewById(R.id.tv_message_number);
            if (appCompatTextView2 != null) {
                appCompatTextView2.setText(this.BuiltInFictitiousFunctionClassFactory.PlaceComponentResult);
            }
            ConstraintLayout constraintLayout = (ConstraintLayout) inflate.findViewById(R.id.res_0x7f0a0412_access_showkycamledddialog);
            if (constraintLayout != null) {
                constraintLayout.setOnClickListener(new View.OnClickListener() { // from class: id.dana.dialog.DialogContactUs$$ExternalSyntheticLambda0
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        DialogContactUs.BuiltInFictitiousFunctionClassFactory(DialogContactUs.this);
                    }
                });
            }
            ConstraintLayout constraintLayout2 = (ConstraintLayout) inflate.findViewById(R.id.res_0x7f0a0478_r8_lambda_ety6o3gegb0b1iza0yd7hbzukmy);
            if (constraintLayout2 != null) {
                constraintLayout2.setOnClickListener(new View.OnClickListener() { // from class: id.dana.dialog.DialogContactUs$$ExternalSyntheticLambda1
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        DialogContactUs.getAuthRequestContext(DialogContactUs.this);
                    }
                });
            }
            AppCompatTextView appCompatTextView3 = (AppCompatTextView) inflate.findViewById(R.id.access$throwIllegalArgumentType);
            if (appCompatTextView3 != null) {
                appCompatTextView3.setOnClickListener(new View.OnClickListener() { // from class: id.dana.dialog.DialogContactUs$$ExternalSyntheticLambda2
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        DialogContactUs.PlaceComponentResult(DialogContactUs.this);
                    }
                });
                return inflate;
            }
            return inflate;
        }
        return null;
    }

    @Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001BO\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\r\u0012\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\r\u0012\u0016\b\u0002\u0010\u0019\u001a\u0010\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u0015\u0018\u00010\u0014\u0012\u0016\b\u0002\u0010\u001a\u001a\u0010\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u0015\u0018\u00010\u0014¢\u0006\u0004\b\u001b\u0010\u001cJ\r\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u001a\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005HÖ\u0003¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\u000b\u001a\u00020\nHÖ\u0001¢\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\u000e\u001a\u00020\rHÖ\u0001¢\u0006\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0011\u001a\u0004\u0018\u00010\rX\u0086\u0002¢\u0006\u0006\n\u0004\b\u0003\u0010\u0010R\u0014\u0010\u0013\u001a\u0004\u0018\u00010\rX\u0086\u0002¢\u0006\u0006\n\u0004\b\u0012\u0010\u0010R \u0010\u0017\u001a\u0010\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u0015\u0018\u00010\u0014X\u0086\u0002¢\u0006\u0006\n\u0004\b\u0013\u0010\u0016R \u0010\u0012\u001a\u0010\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u0015\u0018\u00010\u0014X\u0086\u0002¢\u0006\u0006\n\u0004\b\u0011\u0010\u0016"}, d2 = {"Lid/dana/dialog/DialogContactUs$Builder;", "Lid/dana/component/BaseMaterialDialog$Cancellation;", "Lid/dana/dialog/DialogContactUs;", "MyBillsEntityDataFactory", "()Lid/dana/dialog/DialogContactUs;", "", "p0", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "", "toString", "()Ljava/lang/String;", "Ljava/lang/String;", "getAuthRequestContext", "BuiltInFictitiousFunctionClassFactory", "PlaceComponentResult", "Lkotlin/Function1;", "", "Lkotlin/jvm/functions/Function1;", "KClassImpl$Data$declaredNonStaticMembers$2", "p1", "p2", "p3", "<init>", "(Ljava/lang/String;Ljava/lang/String;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes4.dex */
    public static final /* data */ class Builder extends BaseMaterialDialog.Cancellation {

        /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
        public String PlaceComponentResult;

        /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
        public String getAuthRequestContext;

        /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
        public Function1<? super String, Unit> KClassImpl$Data$declaredNonStaticMembers$2;

        /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
        public Function1<? super String, Unit> BuiltInFictitiousFunctionClassFactory;

        public Builder() {
            this(null, null, null, null, 15, null);
        }

        public final boolean equals(Object p0) {
            if (this == p0) {
                return true;
            }
            if (p0 instanceof Builder) {
                Builder builder = (Builder) p0;
                return Intrinsics.areEqual(this.getAuthRequestContext, builder.getAuthRequestContext) && Intrinsics.areEqual(this.PlaceComponentResult, builder.PlaceComponentResult) && Intrinsics.areEqual(this.KClassImpl$Data$declaredNonStaticMembers$2, builder.KClassImpl$Data$declaredNonStaticMembers$2) && Intrinsics.areEqual(this.BuiltInFictitiousFunctionClassFactory, builder.BuiltInFictitiousFunctionClassFactory);
            }
            return false;
        }

        public final int hashCode() {
            String str = this.getAuthRequestContext;
            int hashCode = str == null ? 0 : str.hashCode();
            String str2 = this.PlaceComponentResult;
            int hashCode2 = str2 == null ? 0 : str2.hashCode();
            Function1<? super String, Unit> function1 = this.KClassImpl$Data$declaredNonStaticMembers$2;
            int hashCode3 = function1 == null ? 0 : function1.hashCode();
            Function1<? super String, Unit> function12 = this.BuiltInFictitiousFunctionClassFactory;
            return (((((hashCode * 31) + hashCode2) * 31) + hashCode3) * 31) + (function12 != null ? function12.hashCode() : 0);
        }

        public final String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("Builder(getAuthRequestContext=");
            sb.append(this.getAuthRequestContext);
            sb.append(", PlaceComponentResult=");
            sb.append(this.PlaceComponentResult);
            sb.append(", KClassImpl$Data$declaredNonStaticMembers$2=");
            sb.append(this.KClassImpl$Data$declaredNonStaticMembers$2);
            sb.append(", BuiltInFictitiousFunctionClassFactory=");
            sb.append(this.BuiltInFictitiousFunctionClassFactory);
            sb.append(')');
            return sb.toString();
        }

        public /* synthetic */ Builder(String str, String str2, Function1 function1, Function1 function12, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : str2, (i & 4) != 0 ? null : function1, (i & 8) != 0 ? null : function12);
        }

        private Builder(String str, String str2, Function1<? super String, Unit> function1, Function1<? super String, Unit> function12) {
            this.getAuthRequestContext = str;
            this.PlaceComponentResult = str2;
            this.KClassImpl$Data$declaredNonStaticMembers$2 = function1;
            this.BuiltInFictitiousFunctionClassFactory = function12;
        }

        public final DialogContactUs MyBillsEntityDataFactory() {
            return new DialogContactUs(new Builder(this.getAuthRequestContext, this.PlaceComponentResult, this.KClassImpl$Data$declaredNonStaticMembers$2, this.BuiltInFictitiousFunctionClassFactory));
        }
    }

    public static /* synthetic */ void getAuthRequestContext(DialogContactUs dialogContactUs) {
        Intrinsics.checkNotNullParameter(dialogContactUs, "");
        Function1<? super String, Unit> function1 = dialogContactUs.BuiltInFictitiousFunctionClassFactory.BuiltInFictitiousFunctionClassFactory;
        if (function1 != null) {
            String str = dialogContactUs.BuiltInFictitiousFunctionClassFactory.PlaceComponentResult;
            function1.invoke(str != null ? str : "");
        }
    }

    public static /* synthetic */ void BuiltInFictitiousFunctionClassFactory(DialogContactUs dialogContactUs) {
        Intrinsics.checkNotNullParameter(dialogContactUs, "");
        Function1<? super String, Unit> function1 = dialogContactUs.BuiltInFictitiousFunctionClassFactory.KClassImpl$Data$declaredNonStaticMembers$2;
        if (function1 != null) {
            String str = dialogContactUs.BuiltInFictitiousFunctionClassFactory.getAuthRequestContext;
            function1.invoke(str != null ? str : "");
        }
    }

    public static /* synthetic */ void PlaceComponentResult(DialogContactUs dialogContactUs) {
        Intrinsics.checkNotNullParameter(dialogContactUs, "");
        dialogContactUs.dismiss();
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public final /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        this.MyBillsEntityDataFactory.clear();
    }
}
