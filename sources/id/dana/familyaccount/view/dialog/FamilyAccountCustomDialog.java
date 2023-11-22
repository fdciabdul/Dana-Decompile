package id.dana.familyaccount.view.dialog;

import android.content.Context;
import android.content.DialogInterface;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import id.dana.R;
import id.dana.base.BaseMaterialDialog;
import id.dana.base.viewbinding.ViewBindingMaterialDialog;
import id.dana.core.ui.constant.DialogType;
import id.dana.databinding.ViewDialogDeleteMemberBinding;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0005\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001\u0017B+\b\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0010\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0011\u0012\u0006\u0010\u0013\u001a\u00020\u0012\u0012\u0006\u0010\u0014\u001a\u00020\u0003¢\u0006\u0004\b\u0015\u0010\u0016J\u001f\u0010\t\u001a\u00020\b2\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\u000b\u001a\u00020\bH\u0016¢\u0006\u0004\b\u000b\u0010\fR\u0011\u0010\u000b\u001a\u00020\rX\u0006¢\u0006\u0006\n\u0004\b\u000e\u0010\u000f"}, d2 = {"Lid/dana/familyaccount/view/dialog/FamilyAccountCustomDialog;", "Lid/dana/base/viewbinding/ViewBindingMaterialDialog;", "Lid/dana/databinding/ViewDialogDeleteMemberBinding;", "Lid/dana/familyaccount/view/dialog/FamilyAccountCustomDialog$Builder;", "Landroid/widget/TextView;", "p0", "", "p1", "", "getAuthRequestContext", "(Landroid/widget/TextView;Ljava/lang/String;)V", "MyBillsEntityDataFactory", "()V", "Lid/dana/core/ui/constant/DialogType;", "PlaceComponentResult", "Lid/dana/core/ui/constant/DialogType;", "Landroid/content/Context;", "Landroid/content/DialogInterface$OnDismissListener;", "", "p2", "p3", "<init>", "(Landroid/content/Context;Landroid/content/DialogInterface$OnDismissListener;ILid/dana/familyaccount/view/dialog/FamilyAccountCustomDialog$Builder;)V", "Builder"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class FamilyAccountCustomDialog extends ViewBindingMaterialDialog<ViewDialogDeleteMemberBinding, Builder> {

    /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
    public final DialogType MyBillsEntityDataFactory;

    public /* synthetic */ FamilyAccountCustomDialog(Context context, DialogInterface.OnDismissListener onDismissListener, int i, Builder builder, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, onDismissListener, i, builder);
    }

    @Override // id.dana.base.viewbinding.ViewBindingMaterialDialog
    public final /* synthetic */ ViewDialogDeleteMemberBinding PlaceComponentResult(View view) {
        Intrinsics.checkNotNullParameter(view, "");
        ViewDialogDeleteMemberBinding PlaceComponentResult = ViewDialogDeleteMemberBinding.PlaceComponentResult(view);
        Intrinsics.checkNotNullExpressionValue(PlaceComponentResult, "");
        return PlaceComponentResult;
    }

    @Override // id.dana.base.BaseMaterialDialog
    public final /* synthetic */ void getAuthRequestContext(View view, Object obj) {
        Builder builder = (Builder) obj;
        Intrinsics.checkNotNullParameter(view, "");
        Intrinsics.checkNotNullParameter(builder, "");
        getAuthRequestContext(BuiltInFictitiousFunctionClassFactory().KClassImpl$Data$declaredNonStaticMembers$2, builder.PlaceComponentResult);
        getAuthRequestContext(BuiltInFictitiousFunctionClassFactory().scheduleImpl, builder.NetworkUserEntityData$$ExternalSyntheticLambda2);
        final View.OnClickListener onClickListener = builder.NetworkUserEntityData$$ExternalSyntheticLambda0;
        Boolean bool = builder.MyBillsEntityDataFactory;
        String str = builder.getAuthRequestContext;
        Button button = BuiltInFictitiousFunctionClassFactory().MyBillsEntityDataFactory;
        Intrinsics.checkNotNullExpressionValue(button, "");
        button.setVisibility(bool != null ? bool.booleanValue() : true ? 0 : 8);
        button.setOnClickListener(new View.OnClickListener() { // from class: id.dana.familyaccount.view.dialog.FamilyAccountCustomDialog$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                FamilyAccountCustomDialog.getAuthRequestContext(FamilyAccountCustomDialog.this, onClickListener, view2);
            }
        });
        button.setText(str);
        final View.OnClickListener onClickListener2 = builder.scheduleImpl;
        Boolean bool2 = builder.lookAheadTest;
        String str2 = builder.moveToNextValue;
        Button button2 = BuiltInFictitiousFunctionClassFactory().PlaceComponentResult;
        Intrinsics.checkNotNullExpressionValue(button2, "");
        button2.setVisibility(bool2 != null ? bool2.booleanValue() : true ? 0 : 8);
        button2.setOnClickListener(new View.OnClickListener() { // from class: id.dana.familyaccount.view.dialog.FamilyAccountCustomDialog$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                FamilyAccountCustomDialog.BuiltInFictitiousFunctionClassFactory(FamilyAccountCustomDialog.this, onClickListener2, view2);
            }
        });
        button2.setText(str2);
        BuiltInFictitiousFunctionClassFactory().PlaceComponentResult.setContentDescription(builder.getErrorConfigVersion);
        BuiltInFictitiousFunctionClassFactory().scheduleImpl.setContentDescription(builder.DatabaseTableConfigUtil);
    }

    private FamilyAccountCustomDialog(Context context, DialogInterface.OnDismissListener onDismissListener, int i, Builder builder) {
        super(context, onDismissListener, i, builder);
        this.MyBillsEntityDataFactory = DialogType.EMPTY;
    }

    private static void getAuthRequestContext(TextView p0, String p1) {
        Intrinsics.checkNotNullParameter(p1, "");
        if (p0 != null) {
            p0.setText(p1);
            p0.setVisibility(TextUtils.isEmpty(p0.getText()) ? 8 : 0);
        }
    }

    @Override // id.dana.base.BaseMaterialDialog
    public final void MyBillsEntityDataFactory() {
        super.MyBillsEntityDataFactory();
    }

    @Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\b¢\u0006\u0004\b\u001e\u0010\u001fJ\u0015\u0010\u0004\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0015\u0010\u0006\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0006\u0010\u0005J\u0015\u0010\u0007\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0007\u0010\u0005R\u0014\u0010\u0006\u001a\u00020\b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0006\u0010\tR\u0014\u0010\u0004\u001a\u0004\u0018\u00010\nX\u0086\u0002¢\u0006\u0006\n\u0004\b\u000b\u0010\fR\u0012\u0010\u000b\u001a\u00020\rX\u0086\u0002¢\u0006\u0006\n\u0004\b\u0004\u0010\u000eR\u0014\u0010\u000f\u001a\u0004\u0018\u00010\rX\u0086\u0002¢\u0006\u0006\n\u0004\b\u000f\u0010\u000eR\u0014\u0010\u0007\u001a\u0004\u0018\u00010\u0002X\u0086\u0002¢\u0006\u0006\n\u0004\b\u0007\u0010\u0010R\u0014\u0010\u0014\u001a\u0004\u0018\u00010\u0011X\u0086\u0002¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u0014\u0010\u0015\u001a\u0004\u0018\u00010\rX\u0086\u0002¢\u0006\u0006\n\u0004\b\u0014\u0010\u000eR\u0014\u0010\u0016\u001a\u0004\u0018\u00010\rX\u0086\u0002¢\u0006\u0006\n\u0004\b\u0015\u0010\u000eR\u0014\u0010\u0012\u001a\u0004\u0018\u00010\u0002X\u0086\u0002¢\u0006\u0006\n\u0004\b\u0016\u0010\u0010R\u0014\u0010\u0017\u001a\u0004\u0018\u00010\u0011X\u0086\u0002¢\u0006\u0006\n\u0004\b\u0017\u0010\u0013R\u0012\u0010\u0019\u001a\u00020\u0018X\u0086\u0002¢\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u0012\u0010\u001c\u001a\u00020\rX\u0086\u0002¢\u0006\u0006\n\u0004\b\u001b\u0010\u000eR\u0014\u0010\u001b\u001a\u0004\u0018\u00010\rX\u0086\u0002¢\u0006\u0006\n\u0004\b\u001d\u0010\u000e"}, d2 = {"Lid/dana/familyaccount/view/dialog/FamilyAccountCustomDialog$Builder;", "Lid/dana/base/BaseMaterialDialog$Cancellation;", "", "p0", "KClassImpl$Data$declaredNonStaticMembers$2", "()Lid/dana/familyaccount/view/dialog/FamilyAccountCustomDialog$Builder;", "BuiltInFictitiousFunctionClassFactory", "MyBillsEntityDataFactory", "Landroid/content/Context;", "Landroid/content/Context;", "Landroid/content/DialogInterface$OnDismissListener;", "PlaceComponentResult", "Landroid/content/DialogInterface$OnDismissListener;", "", "Ljava/lang/String;", "getAuthRequestContext", "Ljava/lang/Boolean;", "Landroid/view/View$OnClickListener;", "lookAheadTest", "Landroid/view/View$OnClickListener;", "NetworkUserEntityData$$ExternalSyntheticLambda0", "moveToNextValue", "getErrorConfigVersion", "scheduleImpl", "", "GetContactSyncConfig", "I", "DatabaseTableConfigUtil", "NetworkUserEntityData$$ExternalSyntheticLambda2", "NetworkUserEntityData$$ExternalSyntheticLambda1", "<init>", "(Landroid/content/Context;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class Builder extends BaseMaterialDialog.Cancellation {
        public final Context BuiltInFictitiousFunctionClassFactory;

        /* renamed from: DatabaseTableConfigUtil  reason: from kotlin metadata */
        public String NetworkUserEntityData$$ExternalSyntheticLambda2;
        public int GetContactSyncConfig;

        /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
        public String PlaceComponentResult;
        Boolean MyBillsEntityDataFactory;

        /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda0  reason: from kotlin metadata */
        public String moveToNextValue;

        /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda1  reason: from kotlin metadata */
        public String DatabaseTableConfigUtil;

        /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
        public DialogInterface.OnDismissListener KClassImpl$Data$declaredNonStaticMembers$2;
        String getAuthRequestContext;

        /* renamed from: getErrorConfigVersion  reason: from kotlin metadata */
        public Boolean lookAheadTest;

        /* renamed from: lookAheadTest  reason: from kotlin metadata */
        View.OnClickListener NetworkUserEntityData$$ExternalSyntheticLambda0;

        /* renamed from: moveToNextValue  reason: from kotlin metadata */
        public String getErrorConfigVersion;
        public View.OnClickListener scheduleImpl;

        public Builder(Context context) {
            Intrinsics.checkNotNullParameter(context, "");
            this.BuiltInFictitiousFunctionClassFactory = context;
            this.GetContactSyncConfig = R.layout.view_dialog_delete_member;
            this.PlaceComponentResult = "";
            this.NetworkUserEntityData$$ExternalSyntheticLambda2 = "";
        }

        public final Builder MyBillsEntityDataFactory() {
            getAuthRequestContext();
            return this;
        }

        public static /* synthetic */ Builder KClassImpl$Data$declaredNonStaticMembers$2(Builder builder, String str, View.OnClickListener onClickListener) {
            Boolean bool = Boolean.TRUE;
            builder.moveToNextValue = str;
            builder.scheduleImpl = onClickListener;
            builder.lookAheadTest = bool;
            return builder;
        }

        public static /* synthetic */ Builder MyBillsEntityDataFactory(Builder builder, String str, Boolean bool, View.OnClickListener onClickListener, int i) {
            if ((i & 1) != 0) {
                str = null;
            }
            if ((i & 2) != 0) {
                bool = Boolean.TRUE;
            }
            if ((i & 4) != 0) {
                onClickListener = null;
            }
            builder.getAuthRequestContext = str;
            builder.NetworkUserEntityData$$ExternalSyntheticLambda0 = onClickListener;
            builder.MyBillsEntityDataFactory = bool;
            return builder;
        }

        public final Builder KClassImpl$Data$declaredNonStaticMembers$2() {
            BuiltInFictitiousFunctionClassFactory(false);
            return this;
        }

        public final Builder BuiltInFictitiousFunctionClassFactory() {
            getAuthRequestContext(false);
            return this;
        }
    }

    public static /* synthetic */ void getAuthRequestContext(FamilyAccountCustomDialog familyAccountCustomDialog, View.OnClickListener onClickListener, View view) {
        Intrinsics.checkNotNullParameter(familyAccountCustomDialog, "");
        familyAccountCustomDialog.getAuthRequestContext();
        if (onClickListener != null) {
            onClickListener.onClick(view);
        }
    }

    public static /* synthetic */ void BuiltInFictitiousFunctionClassFactory(FamilyAccountCustomDialog familyAccountCustomDialog, View.OnClickListener onClickListener, View view) {
        Intrinsics.checkNotNullParameter(familyAccountCustomDialog, "");
        familyAccountCustomDialog.getAuthRequestContext();
        if (onClickListener != null) {
            onClickListener.onClick(view);
        }
    }
}
