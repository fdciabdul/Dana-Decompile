package id.dana.core.ui.dialog;

import android.content.Context;
import android.content.DialogInterface;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.LinearInterpolator;
import android.widget.ImageView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.viewbinding.ViewBinding;
import com.afollestad.materialdialogs.MaterialDialog;
import com.fullstory.instrumentation.InstrumentInjector;
import id.dana.core.ui.BaseViewBindingMaterialDialog;
import id.dana.core.ui.R;
import id.dana.core.ui.constant.DialogType;
import id.dana.core.ui.databinding.ViewCommonDialogBinding;
import id.dana.core.ui.dialog.CommonDialog;
import id.dana.core.ui.util.QuickTap;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmName;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001\u0016B+\u0012\u0006\u0010\u000e\u001a\u00020\r\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\u000f\u0012\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011\u0012\u0006\u0010\u0013\u001a\u00020\u0003¢\u0006\u0004\b\u0014\u0010\u0015J\u000f\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0005\u0010\u0006R\u0016\u0010\t\u001a\u00020\u00038\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0007\u0010\bR\u0018\u0010\u0007\u001a\u0004\u0018\u00010\n8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u000b\u0010\f"}, d2 = {"Lid/dana/core/ui/dialog/CommonDialog;", "Lid/dana/core/ui/BaseViewBindingMaterialDialog;", "Lid/dana/core/ui/databinding/ViewCommonDialogBinding;", "Lid/dana/core/ui/dialog/CommonDialog$Builder;", "", "moveToNextValue", "()V", "BuiltInFictitiousFunctionClassFactory", "Lid/dana/core/ui/dialog/CommonDialog$Builder;", "MyBillsEntityDataFactory", "Lid/dana/core/ui/constant/DialogType;", "KClassImpl$Data$declaredNonStaticMembers$2", "Lid/dana/core/ui/constant/DialogType;", "Landroid/content/Context;", "p0", "Landroid/content/DialogInterface$OnDismissListener;", "p1", "Landroid/content/DialogInterface$OnCancelListener;", "p2", "p3", "<init>", "(Landroid/content/Context;Landroid/content/DialogInterface$OnDismissListener;Landroid/content/DialogInterface$OnCancelListener;Lid/dana/core/ui/dialog/CommonDialog$Builder;)V", "Builder"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class CommonDialog extends BaseViewBindingMaterialDialog<ViewCommonDialogBinding, Builder> {

    /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
    private Builder MyBillsEntityDataFactory;

    /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
    private DialogType BuiltInFictitiousFunctionClassFactory;

    @Override // id.dana.core.ui.BaseViewBindingMaterialDialog
    public final /* synthetic */ void PlaceComponentResult(Builder builder) {
        MaterialDialog cancelable;
        View findViewById;
        MaterialDialog authRequestContext;
        MaterialDialog authRequestContext2;
        final Builder builder2 = builder;
        Intrinsics.checkNotNullParameter(builder2, "");
        DialogType dialogType = builder2.DatabaseTableConfigUtil;
        this.BuiltInFictitiousFunctionClassFactory = dialogType;
        if (dialogType == null) {
            ((ViewCommonDialogBinding) ((ViewBinding) this.KClassImpl$Data$declaredNonStaticMembers$2.getValue())).KClassImpl$Data$declaredNonStaticMembers$2.setVisibility(8);
        } else if (dialogType != null) {
            AppCompatImageView appCompatImageView = ((ViewCommonDialogBinding) ((ViewBinding) this.KClassImpl$Data$declaredNonStaticMembers$2.getValue())).KClassImpl$Data$declaredNonStaticMembers$2;
            int icon = dialogType.getIcon();
            if (appCompatImageView instanceof ImageView) {
                InstrumentInjector.Resources_setImageResource(appCompatImageView, icon);
            } else {
                appCompatImageView.setImageResource(icon);
            }
        }
        ((ViewCommonDialogBinding) ((ViewBinding) this.KClassImpl$Data$declaredNonStaticMembers$2.getValue())).BuiltInFictitiousFunctionClassFactory.setText(builder2.lookAheadTest);
        ((ViewCommonDialogBinding) ((ViewBinding) this.KClassImpl$Data$declaredNonStaticMembers$2.getValue())).lookAheadTest.setText(builder2.NetworkUserEntityData$$ExternalSyntheticLambda1);
        if (!TextUtils.isEmpty(builder2.moveToNextValue) && (authRequestContext2 = getAuthRequestContext()) != null) {
            authRequestContext2.positiveButton(null, builder2.moveToNextValue, new Function1<MaterialDialog, Unit>() { // from class: id.dana.core.ui.dialog.CommonDialog$setup$2
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public final /* bridge */ /* synthetic */ Unit invoke(MaterialDialog materialDialog) {
                    invoke2(materialDialog);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke  reason: avoid collision after fix types in other method */
                public final void invoke2(MaterialDialog materialDialog) {
                    View.OnClickListener onClickListener;
                    if (CommonDialog.Builder.this.scheduleImpl == null || (onClickListener = CommonDialog.Builder.this.scheduleImpl) == null) {
                        return;
                    }
                    onClickListener.onClick(CommonDialog.BuiltInFictitiousFunctionClassFactory(this).MyBillsEntityDataFactory);
                }
            });
        }
        if (!TextUtils.isEmpty(builder2.NetworkUserEntityData$$ExternalSyntheticLambda0) && (authRequestContext = getAuthRequestContext()) != null) {
            authRequestContext.negativeButton(null, builder2.NetworkUserEntityData$$ExternalSyntheticLambda0, new Function1<MaterialDialog, Unit>() { // from class: id.dana.core.ui.dialog.CommonDialog$setup$3
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public final /* bridge */ /* synthetic */ Unit invoke(MaterialDialog materialDialog) {
                    invoke2(materialDialog);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke  reason: avoid collision after fix types in other method */
                public final void invoke2(MaterialDialog materialDialog) {
                    View.OnClickListener onClickListener;
                    if (CommonDialog.Builder.this.getErrorConfigVersion == null || (onClickListener = CommonDialog.Builder.this.getErrorConfigVersion) == null) {
                        return;
                    }
                    onClickListener.onClick(CommonDialog.BuiltInFictitiousFunctionClassFactory(this).MyBillsEntityDataFactory);
                }
            });
        }
        final QuickTap quickTap = builder2.GetContactSyncConfig;
        if (quickTap != null) {
            ((ViewCommonDialogBinding) ((ViewBinding) this.KClassImpl$Data$declaredNonStaticMembers$2.getValue())).getAuthRequestContext.setOnClickListener(new View.OnClickListener() { // from class: id.dana.core.ui.dialog.CommonDialog$$ExternalSyntheticLambda2
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    QuickTap.this.KClassImpl$Data$declaredNonStaticMembers$2();
                }
            });
        }
        if (builder2.initRecordTimeStamp != 0 && (findViewById = ((ViewCommonDialogBinding) ((ViewBinding) this.KClassImpl$Data$declaredNonStaticMembers$2.getValue())).MyBillsEntityDataFactory.findViewById(builder2.initRecordTimeStamp)) != null) {
            findViewById.setOnClickListener(new View.OnClickListener() { // from class: id.dana.core.ui.dialog.CommonDialog$$ExternalSyntheticLambda0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    CommonDialog.getAuthRequestContext(CommonDialog.this);
                }
            });
        }
        ((ViewCommonDialogBinding) ((ViewBinding) this.KClassImpl$Data$declaredNonStaticMembers$2.getValue())).lookAheadTest.setVisibility(TextUtils.isEmpty(((ViewCommonDialogBinding) ((ViewBinding) this.KClassImpl$Data$declaredNonStaticMembers$2.getValue())).lookAheadTest.getText()) ? 8 : 0);
        MaterialDialog authRequestContext3 = getAuthRequestContext();
        if (authRequestContext3 == null || (cancelable = authRequestContext3.cancelable(builder2.getBuiltInFictitiousFunctionClassFactory())) == null) {
            return;
        }
        cancelable.cancelOnTouchOutside(builder2.getKClassImpl$Data$declaredNonStaticMembers$2());
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CommonDialog(Context context, DialogInterface.OnDismissListener onDismissListener, DialogInterface.OnCancelListener onCancelListener, Builder builder) {
        super(context, onDismissListener, onCancelListener, builder);
        Intrinsics.checkNotNullParameter(context, "");
        Intrinsics.checkNotNullParameter(builder, "");
        this.MyBillsEntityDataFactory = builder;
    }

    @Override // id.dana.core.ui.BaseViewBindingMaterialDialog
    public final void moveToNextValue() {
        if (this.BuiltInFictitiousFunctionClassFactory == DialogType.WAITING) {
            Context context = this.MyBillsEntityDataFactory;
            if (context == null) {
                Intrinsics.throwUninitializedPropertyAccessException("");
                context = null;
            }
            Animation loadAnimation = AnimationUtils.loadAnimation(context, R.anim.res_0x7f010050_kclassimpl_data_declarednonstaticmembers_2);
            loadAnimation.setInterpolator(new LinearInterpolator());
            ((ViewCommonDialogBinding) ((ViewBinding) this.KClassImpl$Data$declaredNonStaticMembers$2.getValue())).PlaceComponentResult.startAnimation(loadAnimation);
        }
        ((ViewCommonDialogBinding) ((ViewBinding) this.KClassImpl$Data$declaredNonStaticMembers$2.getValue())).PlaceComponentResult.setVisibility(this.BuiltInFictitiousFunctionClassFactory == DialogType.WAITING ? 0 : 4);
        super.moveToNextValue();
        if (!this.MyBillsEntityDataFactory.getGetAuthRequestContext() || this.MyBillsEntityDataFactory.KClassImpl$Data$declaredNonStaticMembers$2 <= 0) {
            return;
        }
        new Handler(Looper.getMainLooper()).postDelayed(new Runnable() { // from class: id.dana.core.ui.dialog.CommonDialog$$ExternalSyntheticLambda1
            @Override // java.lang.Runnable
            public final void run() {
                CommonDialog.KClassImpl$Data$declaredNonStaticMembers$2(CommonDialog.this);
            }
        }, this.MyBillsEntityDataFactory.KClassImpl$Data$declaredNonStaticMembers$2);
    }

    @Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010$\u001a\u00020\u000b¢\u0006\u0004\b%\u0010&R\u001a\u0010\u0007\u001a\u00020\u00028\u0007X\u0086\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0013\u0010\n\u001a\u0004\u0018\u00010\bX\u0007¢\u0006\u0006\n\u0004\b\u0007\u0010\tR\u0014\u0010\r\u001a\u00020\u000b8\u0002X\u0083\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\fR\u0012\u0010\u0003\u001a\u00020\u000eX\u0087\u0002¢\u0006\u0006\n\u0004\b\r\u0010\u000fR\u0014\u0010\u0005\u001a\u0004\u0018\u00010\u0010X\u0087\u0002¢\u0006\u0006\n\u0004\b\n\u0010\u0011R\u0014\u0010\u0013\u001a\u0004\u0018\u00010\u0012X\u0087\u0002¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u0014\u0010\u0015\u001a\u0004\u0018\u00010\u0012X\u0087\u0002¢\u0006\u0006\n\u0004\b\u0015\u0010\u0014R\u0014\u0010\u0019\u001a\u0004\u0018\u00010\u0016X\u0087\u0002¢\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u0014\u0010\u0017\u001a\u0004\u0018\u00010\u0012X\u0087\u0002¢\u0006\u0006\n\u0004\b\u0019\u0010\u0014R\u0014\u0010\u001a\u001a\u0004\u0018\u00010\u0016X\u0087\u0002¢\u0006\u0006\n\u0004\b\u001a\u0010\u0018R\u0014\u0010\u001e\u001a\u0004\u0018\u00010\u001bX\u0087\u0002¢\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\u0012\u0010 \u001a\u00020\u000eX\u0087\u0002¢\u0006\u0006\n\u0004\b\u001f\u0010\u000fR\u0014\u0010\u001f\u001a\u0004\u0018\u00010!X\u0087\u0002¢\u0006\u0006\n\u0004\b\"\u0010#R\u0014\u0010\"\u001a\u0004\u0018\u00010\u0012X\u0087\u0002¢\u0006\u0006\n\u0004\b\u001e\u0010\u0014R\u0012\u0010\u001c\u001a\u00020\u000eX\u0087\u0002¢\u0006\u0006\n\u0004\b \u0010\u000f"}, d2 = {"Lid/dana/core/ui/dialog/CommonDialog$Builder;", "Lid/dana/core/ui/BaseViewBindingMaterialDialog$Cancellation;", "", "KClassImpl$Data$declaredNonStaticMembers$2", "Z", "BuiltInFictitiousFunctionClassFactory", "()Z", "getAuthRequestContext", "Landroid/content/DialogInterface$OnCancelListener;", "Landroid/content/DialogInterface$OnCancelListener;", "MyBillsEntityDataFactory", "Landroid/content/Context;", "Landroid/content/Context;", "PlaceComponentResult", "", "I", "Landroid/content/DialogInterface$OnDismissListener;", "Landroid/content/DialogInterface$OnDismissListener;", "", "lookAheadTest", "Ljava/lang/String;", "NetworkUserEntityData$$ExternalSyntheticLambda0", "Landroid/view/View$OnClickListener;", "moveToNextValue", "Landroid/view/View$OnClickListener;", "getErrorConfigVersion", "scheduleImpl", "Lid/dana/core/ui/util/QuickTap;", "initRecordTimeStamp", "Lid/dana/core/ui/util/QuickTap;", "GetContactSyncConfig", "DatabaseTableConfigUtil", "NetworkUserEntityData$$ExternalSyntheticLambda2", "Lid/dana/core/ui/constant/DialogType;", "NetworkUserEntityData$$ExternalSyntheticLambda1", "Lid/dana/core/ui/constant/DialogType;", "p0", "<init>", "(Landroid/content/Context;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes4.dex */
    public static final class Builder extends BaseViewBindingMaterialDialog.Cancellation {

        /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
        public final Context PlaceComponentResult;

        /* renamed from: DatabaseTableConfigUtil  reason: from kotlin metadata */
        public int NetworkUserEntityData$$ExternalSyntheticLambda2;

        /* renamed from: GetContactSyncConfig  reason: from kotlin metadata */
        String NetworkUserEntityData$$ExternalSyntheticLambda1;

        /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
        public boolean getAuthRequestContext;

        /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
        public DialogInterface.OnDismissListener BuiltInFictitiousFunctionClassFactory;
        String NetworkUserEntityData$$ExternalSyntheticLambda0;

        /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda1  reason: from kotlin metadata */
        public DialogType DatabaseTableConfigUtil;

        /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda2  reason: from kotlin metadata */
        int initRecordTimeStamp;

        /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
        int KClassImpl$Data$declaredNonStaticMembers$2;

        /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
        public final DialogInterface.OnCancelListener MyBillsEntityDataFactory;

        /* renamed from: getErrorConfigVersion  reason: from kotlin metadata */
        String moveToNextValue;

        /* renamed from: initRecordTimeStamp  reason: from kotlin metadata */
        QuickTap GetContactSyncConfig;
        public String lookAheadTest;

        /* renamed from: moveToNextValue  reason: from kotlin metadata */
        View.OnClickListener getErrorConfigVersion;
        View.OnClickListener scheduleImpl;

        public Builder(Context context) {
            Intrinsics.checkNotNullParameter(context, "");
            this.PlaceComponentResult = context;
            this.NetworkUserEntityData$$ExternalSyntheticLambda2 = R.layout.view_common_dialog;
            this.getAuthRequestContext = true;
            this.KClassImpl$Data$declaredNonStaticMembers$2 = 3000;
        }

        @JvmName(name = "BuiltInFictitiousFunctionClassFactory")
        /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from getter */
        public final boolean getGetAuthRequestContext() {
            return this.getAuthRequestContext;
        }
    }

    public static /* synthetic */ void getAuthRequestContext(CommonDialog commonDialog) {
        Intrinsics.checkNotNullParameter(commonDialog, "");
        commonDialog.PlaceComponentResult();
    }

    public static /* synthetic */ void KClassImpl$Data$declaredNonStaticMembers$2(CommonDialog commonDialog) {
        Intrinsics.checkNotNullParameter(commonDialog, "");
        commonDialog.PlaceComponentResult();
    }

    public static final /* synthetic */ ViewCommonDialogBinding BuiltInFictitiousFunctionClassFactory(CommonDialog commonDialog) {
        return (ViewCommonDialogBinding) ((ViewBinding) commonDialog.KClassImpl$Data$declaredNonStaticMembers$2.getValue());
    }

    @Override // id.dana.core.ui.BaseViewBindingMaterialDialog
    public final /* synthetic */ ViewCommonDialogBinding MyBillsEntityDataFactory() {
        Context context = this.MyBillsEntityDataFactory;
        if (context == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            context = null;
        }
        ViewCommonDialogBinding MyBillsEntityDataFactory = ViewCommonDialogBinding.MyBillsEntityDataFactory(LayoutInflater.from(context));
        Intrinsics.checkNotNullExpressionValue(MyBillsEntityDataFactory, "");
        return MyBillsEntityDataFactory;
    }
}
