package id.dana.sendmoney.ui.globalsend.form.viewholder.receiver;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.afollestad.materialdialogs.MaterialDialog;
import com.bumptech.glide.load.Transformation;
import com.bumptech.glide.load.resource.bitmap.CircleCrop;
import de.hdodenhof.circleimageview.CircleImageView;
import id.dana.component.dialogcomponent.CustomDialog;
import id.dana.core.ui.glide.GlideApp;
import id.dana.sendmoney.R;
import id.dana.sendmoney.databinding.ItemEnabledTransferToDebitBinding;
import id.dana.sendmoney.ui.globalsend.form.model.common.GlobalSendFormModel;
import id.dana.sendmoney.ui.globalsend.form.model.form.receiver.DefaultFormModel;
import id.dana.sendmoney.ui.globalsend.form.model.form.receiver.EnabledTransferToDebitModel;
import id.dana.sendmoney.ui.globalsend.form.view.EditTextFormView;
import id.dana.sendmoney.ui.globalsend.form.viewholder.RadioGlobalSendFormViewHolder;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0007\u0018\u0000 \u00182\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001\u0018B-\u0012\u0006\u0010\u0005\u001a\u00020\u0002\u0012\u0012\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u00060\u0010\u0012\b\b\u0002\u0010\u0015\u001a\u00020\t¢\u0006\u0004\b\u0016\u0010\u0017J\u0017\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bR\u0014\u0010\f\u001a\u00020\t8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\n\u0010\u000bR\u0013\u0010\n\u001a\u00020\rX\u0082\u0080\u0002¢\u0006\u0006\n\u0004\b\u000e\u0010\u000fR \u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u00060\u00108\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013"}, d2 = {"Lid/dana/sendmoney/ui/globalsend/form/viewholder/receiver/EnabledTransferToDebitViewHolder;", "Lid/dana/sendmoney/ui/globalsend/form/viewholder/RadioGlobalSendFormViewHolder;", "Lid/dana/sendmoney/databinding/ItemEnabledTransferToDebitBinding;", "Lid/dana/sendmoney/ui/globalsend/form/model/common/GlobalSendFormModel;", "", "p0", "", "BuiltInFictitiousFunctionClassFactory", "(Z)V", "Landroid/content/Context;", "getAuthRequestContext", "Landroid/content/Context;", "MyBillsEntityDataFactory", "Lcom/afollestad/materialdialogs/MaterialDialog;", "KClassImpl$Data$declaredNonStaticMembers$2", "Lkotlin/Lazy;", "Lkotlin/Function1;", "", "PlaceComponentResult", "Lkotlin/jvm/functions/Function1;", "p1", "p2", "<init>", "(Lid/dana/sendmoney/databinding/ItemEnabledTransferToDebitBinding;Lkotlin/jvm/functions/Function1;Landroid/content/Context;)V", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class EnabledTransferToDebitViewHolder extends RadioGlobalSendFormViewHolder<ItemEnabledTransferToDebitBinding, GlobalSendFormModel> {

    /* renamed from: Companion  reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
    private final Lazy getAuthRequestContext;
    private final Function1<Integer, Unit> PlaceComponentResult;

    /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
    private final Context MyBillsEntityDataFactory;

    @Override // id.dana.sendmoney.ui.globalsend.form.viewholder.BaseGlobalSendFormViewHolder
    public final /* synthetic */ void getAuthRequestContext(Object obj) {
        GlobalSendFormModel globalSendFormModel = (GlobalSendFormModel) obj;
        Intrinsics.checkNotNullParameter(globalSendFormModel, "");
        EnabledTransferToDebitModel enabledTransferToDebitModel = (EnabledTransferToDebitModel) globalSendFormModel;
        ItemEnabledTransferToDebitBinding itemEnabledTransferToDebitBinding = (ItemEnabledTransferToDebitBinding) this.MyBillsEntityDataFactory;
        CircleImageView circleImageView = itemEnabledTransferToDebitBinding.NetworkUserEntityData$$ExternalSyntheticLambda0;
        Intrinsics.checkNotNullExpressionValue(circleImageView, "");
        CircleImageView circleImageView2 = circleImageView;
        GlideApp.getAuthRequestContext(circleImageView2.getContext()).PlaceComponentResult(Integer.valueOf(enabledTransferToDebitModel.MyBillsEntityDataFactory)).getErrorConfigVersion(R.drawable.ic_user_default_placeholder).BuiltInFictitiousFunctionClassFactory((Transformation<Bitmap>) new CircleCrop()).PlaceComponentResult(R.drawable.ic_user_default_placeholder).MyBillsEntityDataFactory((ImageView) circleImageView2);
        itemEnabledTransferToDebitBinding.lookAheadTest.setText(this.MyBillsEntityDataFactory.getString(enabledTransferToDebitModel.BuiltInFictitiousFunctionClassFactory));
        itemEnabledTransferToDebitBinding.getErrorConfigVersion.setText(this.MyBillsEntityDataFactory.getString(enabledTransferToDebitModel.getAuthRequestContext));
        EditTextFormView editTextFormView = itemEnabledTransferToDebitBinding.moveToNextValue;
        DefaultFormModel defaultFormModel = enabledTransferToDebitModel.KClassImpl$Data$declaredNonStaticMembers$2;
        editTextFormView.setEditTextAccessibilityId(defaultFormModel.BuiltInFictitiousFunctionClassFactory);
        editTextFormView.setHeaderText(defaultFormModel.PlaceComponentResult);
        editTextFormView.setHintText(defaultFormModel.KClassImpl$Data$declaredNonStaticMembers$2);
        editTextFormView.setFormInputType(4);
        editTextFormView.setSecondaryAdditionalInfoText(R.string.additional_info_form_debit_card);
        editTextFormView.setErrorMessageString(defaultFormModel.MyBillsEntityDataFactory);
        editTextFormView.setOnTextFormChanged(defaultFormModel.lookAheadTest);
        editTextFormView.showErrorText(defaultFormModel.getGetErrorConfigVersion());
        editTextFormView.setValidationRuleList(defaultFormModel.scheduleImpl);
        editTextFormView.setOnImeButtonClickListener(new Function0<Unit>() { // from class: id.dana.sendmoney.ui.globalsend.form.viewholder.receiver.EnabledTransferToDebitViewHolder$bindData$1$1$1$1$1
            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2() {
            }

            @Override // kotlin.jvm.functions.Function0
            public final /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }
        });
        ((ItemEnabledTransferToDebitBinding) this.MyBillsEntityDataFactory).MyBillsEntityDataFactory.setOnClickListener(new View.OnClickListener() { // from class: id.dana.sendmoney.ui.globalsend.form.viewholder.receiver.EnabledTransferToDebitViewHolder$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                EnabledTransferToDebitViewHolder.BuiltInFictitiousFunctionClassFactory(EnabledTransferToDebitViewHolder.this);
            }
        });
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    private EnabledTransferToDebitViewHolder(final ItemEnabledTransferToDebitBinding itemEnabledTransferToDebitBinding, Function1<? super Integer, Unit> function1, Context context) {
        super(itemEnabledTransferToDebitBinding);
        Intrinsics.checkNotNullParameter(itemEnabledTransferToDebitBinding, "");
        Intrinsics.checkNotNullParameter(function1, "");
        Intrinsics.checkNotNullParameter(context, "");
        this.PlaceComponentResult = function1;
        this.MyBillsEntityDataFactory = context;
        this.getAuthRequestContext = LazyKt.lazy(new Function0<MaterialDialog>() { // from class: id.dana.sendmoney.ui.globalsend.form.viewholder.receiver.EnabledTransferToDebitViewHolder$debitInfoDialog$2
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final MaterialDialog invoke() {
                Context context2;
                Context context3;
                Context context4;
                Context context5;
                Context context6;
                Context context7;
                Context context8 = ItemEnabledTransferToDebitBinding.this.scheduleImpl.getContext();
                Intrinsics.checkNotNullExpressionValue(context8, "");
                CustomDialog.Builder builder = new CustomDialog.Builder(context8);
                builder.DatabaseTableConfigUtil = R.drawable.ic_debit_cards;
                context2 = this.MyBillsEntityDataFactory;
                builder.SubSequence = context2.getString(R.string.title_dialog_debit_visa);
                context3 = this.MyBillsEntityDataFactory;
                builder.whenAvailable = context3.getString(R.string.lbl_help_send_to_card_title);
                context4 = this.MyBillsEntityDataFactory;
                builder.GetContactSyncConfig = context4.getString(R.string.desc_dialog_debit_visa);
                context5 = this.MyBillsEntityDataFactory;
                builder.isLayoutRequested = context5.getString(R.string.lbl_help_send_to_card_description);
                context6 = this.MyBillsEntityDataFactory;
                CustomDialog.Builder BuiltInFictitiousFunctionClassFactory = builder.BuiltInFictitiousFunctionClassFactory(context6.getString(R.string.res_0x7f130398_verifypinstatemanager_executeriskchallenge_2_1), new Function1<View, Unit>() { // from class: id.dana.sendmoney.ui.globalsend.form.viewholder.receiver.EnabledTransferToDebitViewHolder$debitInfoDialog$2.1
                    /* renamed from: invoke  reason: avoid collision after fix types in other method */
                    public final void invoke2(View view) {
                        Intrinsics.checkNotNullParameter(view, "");
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final /* bridge */ /* synthetic */ Unit invoke(View view) {
                        invoke2(view);
                        return Unit.INSTANCE;
                    }
                });
                context7 = this.MyBillsEntityDataFactory;
                BuiltInFictitiousFunctionClassFactory.NetworkUserEntityData$$ExternalSyntheticLambda4 = context7.getString(R.string.res_0x7f13030b_networkuserentitydata_externalsyntheticlambda6);
                return BuiltInFictitiousFunctionClassFactory.KClassImpl$Data$declaredNonStaticMembers$2(false).PlaceComponentResult(false).BuiltInFictitiousFunctionClassFactory();
            }
        });
    }

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u0015\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"Lid/dana/sendmoney/ui/globalsend/form/viewholder/receiver/EnabledTransferToDebitViewHolder$Companion;", "", "Landroid/view/ViewGroup;", "p0", "Lid/dana/sendmoney/databinding/ItemEnabledTransferToDebitBinding;", "KClassImpl$Data$declaredNonStaticMembers$2", "(Landroid/view/ViewGroup;)Lid/dana/sendmoney/databinding/ItemEnabledTransferToDebitBinding;", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public static ItemEnabledTransferToDebitBinding KClassImpl$Data$declaredNonStaticMembers$2(ViewGroup p0) {
            Intrinsics.checkNotNullParameter(p0, "");
            ItemEnabledTransferToDebitBinding BuiltInFictitiousFunctionClassFactory = ItemEnabledTransferToDebitBinding.BuiltInFictitiousFunctionClassFactory(LayoutInflater.from(p0.getContext()), p0);
            Intrinsics.checkNotNullExpressionValue(BuiltInFictitiousFunctionClassFactory, "");
            return BuiltInFictitiousFunctionClassFactory;
        }
    }

    public static /* synthetic */ void BuiltInFictitiousFunctionClassFactory(EnabledTransferToDebitViewHolder enabledTransferToDebitViewHolder) {
        Intrinsics.checkNotNullParameter(enabledTransferToDebitViewHolder, "");
        ((MaterialDialog) enabledTransferToDebitViewHolder.getAuthRequestContext.getValue()).show();
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public /* synthetic */ EnabledTransferToDebitViewHolder(id.dana.sendmoney.databinding.ItemEnabledTransferToDebitBinding r1, kotlin.jvm.functions.Function1 r2, android.content.Context r3, int r4, kotlin.jvm.internal.DefaultConstructorMarker r5) {
        /*
            r0 = this;
            r4 = r4 & 4
            if (r4 == 0) goto Lf
            androidx.cardview.widget.CardView r3 = r1.scheduleImpl
            android.content.Context r3 = r3.getContext()
            java.lang.String r4 = ""
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r3, r4)
        Lf:
            r0.<init>(r1, r2, r3)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.sendmoney.ui.globalsend.form.viewholder.receiver.EnabledTransferToDebitViewHolder.<init>(id.dana.sendmoney.databinding.ItemEnabledTransferToDebitBinding, kotlin.jvm.functions.Function1, android.content.Context, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }

    @Override // id.dana.sendmoney.ui.globalsend.form.viewholder.RadioGlobalSendFormViewHolder
    public final void BuiltInFictitiousFunctionClassFactory(boolean p0) {
        ((ItemEnabledTransferToDebitBinding) this.MyBillsEntityDataFactory).DatabaseTableConfigUtil.setChecked(p0);
        ConstraintLayout constraintLayout = ((ItemEnabledTransferToDebitBinding) this.MyBillsEntityDataFactory).KClassImpl$Data$declaredNonStaticMembers$2;
        Intrinsics.checkNotNullExpressionValue(constraintLayout, "");
        constraintLayout.setVisibility(p0 ? 0 : 8);
    }
}
