package id.dana.danapoly.ui.leaderboard;

import android.content.Context;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import id.dana.core.ui.BaseViewBindingMaterialDialog;
import id.dana.danapoly.databinding.ViewCustomDanapolyDialogBinding;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0002\u000b\fB#\b\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\t\u0010\n"}, d2 = {"Lid/dana/danapoly/ui/leaderboard/DanapolyCustomDialog;", "Lid/dana/core/ui/BaseViewBindingMaterialDialog;", "Lid/dana/danapoly/databinding/ViewCustomDanapolyDialogBinding;", "Lid/dana/danapoly/ui/leaderboard/DanapolyCustomDialog$Builder;", "Landroid/content/Context;", "p0", "p1", "Landroid/content/DialogInterface$OnDismissListener;", "p2", "<init>", "(Landroid/content/Context;Lid/dana/danapoly/ui/leaderboard/DanapolyCustomDialog$Builder;Landroid/content/DialogInterface$OnDismissListener;)V", "Builder", "DialogType"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class DanapolyCustomDialog extends BaseViewBindingMaterialDialog<ViewCustomDanapolyDialogBinding, Builder> {

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006"}, d2 = {"Lid/dana/danapoly/ui/leaderboard/DanapolyCustomDialog$DialogType;", "", "<init>", "(Ljava/lang/String;I)V", "DEFAULT", "RIBBON", "RIBBON_WITH_MEDAL"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes4.dex */
    public enum DialogType {
        DEFAULT,
        RIBBON,
        RIBBON_WITH_MEDAL
    }

    public /* synthetic */ DanapolyCustomDialog(Context context, Builder builder, DialogInterface.OnDismissListener onDismissListener, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, builder, onDismissListener);
    }

    /* JADX WARN: Removed duplicated region for block: B:439:0x0289  */
    /* JADX WARN: Removed duplicated region for block: B:441:0x028c  */
    /* JADX WARN: Removed duplicated region for block: B:442:0x02a0  */
    /* JADX WARN: Removed duplicated region for block: B:444:0x02a3  */
    /* JADX WARN: Removed duplicated region for block: B:447:0x02b7  */
    /* JADX WARN: Removed duplicated region for block: B:448:0x02b9  */
    /* JADX WARN: Removed duplicated region for block: B:450:0x02bc  */
    /* JADX WARN: Removed duplicated region for block: B:458:0x02ec  */
    /* JADX WARN: Removed duplicated region for block: B:466:0x0309  */
    /* JADX WARN: Removed duplicated region for block: B:474:0x0338  */
    @Override // id.dana.core.ui.BaseViewBindingMaterialDialog
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final /* synthetic */ void PlaceComponentResult(id.dana.danapoly.ui.leaderboard.DanapolyCustomDialog.Builder r12) {
        /*
            Method dump skipped, instructions count: 874
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.danapoly.ui.leaderboard.DanapolyCustomDialog.PlaceComponentResult(java.lang.Object):void");
    }

    private DanapolyCustomDialog(Context context, Builder builder, DialogInterface.OnDismissListener onDismissListener) {
        super(context, onDismissListener, builder);
    }

    @Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0007\u0012\u0006\u0010\u0004\u001a\u00020\n¢\u0006\u0004\b\u001e\u0010\u001fJ\u001d\u0010\u0005\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006R\u0011\u0010\t\u001a\u00020\u0007X\u0006¢\u0006\u0006\n\u0004\b\u0005\u0010\bR\u0011\u0010\r\u001a\u00020\nX\u0006¢\u0006\u0006\n\u0004\b\u000b\u0010\fR\u0014\u0010\u0010\u001a\u0004\u0018\u00010\u000eX\u0080\u0002¢\u0006\u0006\n\u0004\b\t\u0010\u000fR\u0012\u0010\u000b\u001a\u00020\u0011X\u0080\u0002¢\u0006\u0006\n\u0004\b\u0010\u0010\u0012R\u0014\u0010\u0005\u001a\u0004\u0018\u00010\u0011X\u0080\u0002¢\u0006\u0006\n\u0004\b\r\u0010\u0012R\u0014\u0010\u0014\u001a\u0004\u0018\u00010\u0011X\u0080\u0002¢\u0006\u0006\n\u0004\b\u0013\u0010\u0012R\u0014\u0010\u0015\u001a\u0004\u0018\u00010\u0011X\u0080\u0002¢\u0006\u0006\n\u0004\b\u0015\u0010\u0012R\u0014\u0010\u0013\u001a\u0004\u0018\u00010\u0016X\u0080\u0002¢\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u0012\u0010\u0017\u001a\u00020\u0019X\u0080\u0002¢\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u0012\u0010\u001a\u001a\u00020\u0011X\u0080\u0002¢\u0006\u0006\n\u0004\b\u0014\u0010\u0012R\u0014\u0010\u001c\u001a\u0004\u0018\u00010\u0016X\u0080\u0002¢\u0006\u0006\n\u0004\b\u001c\u0010\u0018R\u0014\u0010\u001d\u001a\u0004\u0018\u00010\u0011X\u0080\u0002¢\u0006\u0006\n\u0004\b\u001d\u0010\u0012"}, d2 = {"Lid/dana/danapoly/ui/leaderboard/DanapolyCustomDialog$Builder;", "Lid/dana/core/ui/BaseViewBindingMaterialDialog$Cancellation;", "", "p0", "p1", "PlaceComponentResult", "(ZZ)Lid/dana/danapoly/ui/leaderboard/DanapolyCustomDialog$Builder;", "Landroid/content/Context;", "Landroid/content/Context;", "BuiltInFictitiousFunctionClassFactory", "Lid/dana/danapoly/ui/leaderboard/DanapolyCustomDialog$DialogType;", "getAuthRequestContext", "Lid/dana/danapoly/ui/leaderboard/DanapolyCustomDialog$DialogType;", "MyBillsEntityDataFactory", "Landroid/content/DialogInterface$OnDismissListener;", "Landroid/content/DialogInterface$OnDismissListener;", "KClassImpl$Data$declaredNonStaticMembers$2", "", "Ljava/lang/String;", "moveToNextValue", "getErrorConfigVersion", "lookAheadTest", "Landroid/view/View$OnClickListener;", "NetworkUserEntityData$$ExternalSyntheticLambda0", "Landroid/view/View$OnClickListener;", "", "scheduleImpl", "I", "initRecordTimeStamp", "NetworkUserEntityData$$ExternalSyntheticLambda2", "<init>", "(Landroid/content/Context;Lid/dana/danapoly/ui/leaderboard/DanapolyCustomDialog$DialogType;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes4.dex */
    public static final class Builder extends BaseViewBindingMaterialDialog.Cancellation {

        /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
        public DialogInterface.OnDismissListener KClassImpl$Data$declaredNonStaticMembers$2;

        /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
        public String getAuthRequestContext;

        /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
        String PlaceComponentResult;

        /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda0  reason: from kotlin metadata */
        public View.OnClickListener moveToNextValue;
        public String NetworkUserEntityData$$ExternalSyntheticLambda2;

        /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
        public final Context BuiltInFictitiousFunctionClassFactory;

        /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
        final DialogType MyBillsEntityDataFactory;

        /* renamed from: getErrorConfigVersion  reason: from kotlin metadata */
        public String scheduleImpl;
        public View.OnClickListener initRecordTimeStamp;
        public String lookAheadTest;

        /* renamed from: moveToNextValue  reason: from kotlin metadata */
        public String getErrorConfigVersion;

        /* renamed from: scheduleImpl  reason: from kotlin metadata */
        public int NetworkUserEntityData$$ExternalSyntheticLambda0;

        public Builder(Context context, DialogType dialogType) {
            Intrinsics.checkNotNullParameter(context, "");
            Intrinsics.checkNotNullParameter(dialogType, "");
            this.BuiltInFictitiousFunctionClassFactory = context;
            this.MyBillsEntityDataFactory = dialogType;
            this.getAuthRequestContext = "";
            this.scheduleImpl = "";
        }

        public final Builder PlaceComponentResult(boolean p0, boolean p1) {
            super.PlaceComponentResult(p0);
            super.KClassImpl$Data$declaredNonStaticMembers$2(p1);
            return this;
        }

        public static /* synthetic */ Builder BuiltInFictitiousFunctionClassFactory(Builder builder, String str) {
            Intrinsics.checkNotNullParameter(str, "");
            builder.getAuthRequestContext = str;
            builder.NetworkUserEntityData$$ExternalSyntheticLambda0 = 0;
            return builder;
        }
    }

    public static /* synthetic */ void MyBillsEntityDataFactory(View.OnClickListener onClickListener, DanapolyCustomDialog danapolyCustomDialog, View view) {
        Intrinsics.checkNotNullParameter(onClickListener, "");
        Intrinsics.checkNotNullParameter(danapolyCustomDialog, "");
        onClickListener.onClick(view);
        danapolyCustomDialog.PlaceComponentResult();
    }

    public static /* synthetic */ void PlaceComponentResult(View.OnClickListener onClickListener, DanapolyCustomDialog danapolyCustomDialog, View view) {
        Intrinsics.checkNotNullParameter(onClickListener, "");
        Intrinsics.checkNotNullParameter(danapolyCustomDialog, "");
        onClickListener.onClick(view);
        danapolyCustomDialog.PlaceComponentResult();
    }

    @Override // id.dana.core.ui.BaseViewBindingMaterialDialog
    public final /* synthetic */ ViewCustomDanapolyDialogBinding MyBillsEntityDataFactory() {
        Context context = this.MyBillsEntityDataFactory;
        if (context == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            context = null;
        }
        ViewCustomDanapolyDialogBinding PlaceComponentResult = ViewCustomDanapolyDialogBinding.PlaceComponentResult(LayoutInflater.from(context));
        Intrinsics.checkNotNullExpressionValue(PlaceComponentResult, "");
        return PlaceComponentResult;
    }
}
