package id.dana.sendmoney.ui.groupsend.recipient.viewholder;

import android.content.Context;
import android.view.View;
import id.dana.component.formcomponent.DanaCheckboxButtonView;
import id.dana.core.ui.util.NumberUtil;
import id.dana.sendmoney.R;
import id.dana.sendmoney.databinding.ItemAddNewPhoneNumberBinding;
import id.dana.sendmoney.ui.groupsend.recipient.model.viewmodel.RecipientViewModel;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0010\b\n\u0002\b\u0006\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B/\u0012\u0006\u0010\u0004\u001a\u00020\u0002\u0012\u001e\u0010\u000e\u001a\u001a\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u00050\b¢\u0006\u0004\b\u000f\u0010\u0010J\u0017\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0006\u0010\u0007R,\u0010\r\u001a\u001a\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u00050\b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010\f"}, d2 = {"Lid/dana/sendmoney/ui/groupsend/recipient/viewholder/AddNewPhoneNumberViewHolder;", "Lid/dana/sendmoney/ui/groupsend/recipient/viewholder/BaseRecipientViewHolder;", "Lid/dana/sendmoney/databinding/ItemAddNewPhoneNumberBinding;", "Lid/dana/sendmoney/ui/groupsend/recipient/model/viewmodel/RecipientViewModel;", "p0", "", "MyBillsEntityDataFactory", "(Lid/dana/sendmoney/ui/groupsend/recipient/model/viewmodel/RecipientViewModel;)V", "Lkotlin/Function3;", "", "", "BuiltInFictitiousFunctionClassFactory", "Lkotlin/jvm/functions/Function3;", "getAuthRequestContext", "p1", "<init>", "(Lid/dana/sendmoney/databinding/ItemAddNewPhoneNumberBinding;Lkotlin/jvm/functions/Function3;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class AddNewPhoneNumberViewHolder extends BaseRecipientViewHolder<ItemAddNewPhoneNumberBinding> {

    /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
    private final Function3<RecipientViewModel, Boolean, Integer, Unit> getAuthRequestContext;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public AddNewPhoneNumberViewHolder(ItemAddNewPhoneNumberBinding itemAddNewPhoneNumberBinding, Function3<? super RecipientViewModel, ? super Boolean, ? super Integer, Unit> function3) {
        super(itemAddNewPhoneNumberBinding);
        Intrinsics.checkNotNullParameter(itemAddNewPhoneNumberBinding, "");
        Intrinsics.checkNotNullParameter(function3, "");
        this.getAuthRequestContext = function3;
    }

    @Override // id.dana.sendmoney.ui.groupsend.recipient.viewholder.BaseRecipientViewHolder
    public final void MyBillsEntityDataFactory(final RecipientViewModel p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        Context context = PlaceComponentResult().PlaceComponentResult.getContext();
        final ItemAddNewPhoneNumberBinding PlaceComponentResult = PlaceComponentResult();
        p0.PlaceComponentResult = p0.DatabaseTableConfigUtil;
        p0.initRecordTimeStamp = context.getString(R.string.res_0x7f1312c9_securitysettingsactivity_createpinlauncher_2_1);
        PlaceComponentResult.getAuthRequestContext.setText(p0.DatabaseTableConfigUtil);
        PlaceComponentResult.KClassImpl$Data$declaredNonStaticMembers$2.setChecked(p0.BuiltInFictitiousFunctionClassFactory());
        PlaceComponentResult.KClassImpl$Data$declaredNonStaticMembers$2.setOnClickListener(new View.OnClickListener() { // from class: id.dana.sendmoney.ui.groupsend.recipient.viewholder.AddNewPhoneNumberViewHolder$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                AddNewPhoneNumberViewHolder.KClassImpl$Data$declaredNonStaticMembers$2(AddNewPhoneNumberViewHolder.this, p0, PlaceComponentResult);
            }
        });
        DanaCheckboxButtonView danaCheckboxButtonView = PlaceComponentResult.KClassImpl$Data$declaredNonStaticMembers$2;
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        String string = context.getString(R.string.checkbox_contact);
        Intrinsics.checkNotNullExpressionValue(string, "");
        NumberUtil numberUtil = NumberUtil.INSTANCE;
        String format = String.format(string, Arrays.copyOf(new Object[]{NumberUtil.PlaceComponentResult(p0.DatabaseTableConfigUtil, "+62")}, 1));
        Intrinsics.checkNotNullExpressionValue(format, "");
        danaCheckboxButtonView.setContentDescription(format);
        PlaceComponentResult.PlaceComponentResult.setOnClickListener(new View.OnClickListener() { // from class: id.dana.sendmoney.ui.groupsend.recipient.viewholder.AddNewPhoneNumberViewHolder$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                AddNewPhoneNumberViewHolder.MyBillsEntityDataFactory(ItemAddNewPhoneNumberBinding.this, this, p0);
            }
        });
    }

    public static /* synthetic */ void MyBillsEntityDataFactory(ItemAddNewPhoneNumberBinding itemAddNewPhoneNumberBinding, AddNewPhoneNumberViewHolder addNewPhoneNumberViewHolder, RecipientViewModel recipientViewModel) {
        Intrinsics.checkNotNullParameter(itemAddNewPhoneNumberBinding, "");
        Intrinsics.checkNotNullParameter(addNewPhoneNumberViewHolder, "");
        Intrinsics.checkNotNullParameter(recipientViewModel, "");
        itemAddNewPhoneNumberBinding.KClassImpl$Data$declaredNonStaticMembers$2.setChecked(!itemAddNewPhoneNumberBinding.KClassImpl$Data$declaredNonStaticMembers$2.isChecked());
        addNewPhoneNumberViewHolder.getAuthRequestContext.invoke(recipientViewModel, Boolean.valueOf(itemAddNewPhoneNumberBinding.KClassImpl$Data$declaredNonStaticMembers$2.isChecked()), Integer.valueOf(addNewPhoneNumberViewHolder.getAbsoluteAdapterPosition()));
    }

    public static /* synthetic */ void KClassImpl$Data$declaredNonStaticMembers$2(AddNewPhoneNumberViewHolder addNewPhoneNumberViewHolder, RecipientViewModel recipientViewModel, ItemAddNewPhoneNumberBinding itemAddNewPhoneNumberBinding) {
        Intrinsics.checkNotNullParameter(addNewPhoneNumberViewHolder, "");
        Intrinsics.checkNotNullParameter(recipientViewModel, "");
        Intrinsics.checkNotNullParameter(itemAddNewPhoneNumberBinding, "");
        addNewPhoneNumberViewHolder.getAuthRequestContext.invoke(recipientViewModel, Boolean.valueOf(itemAddNewPhoneNumberBinding.KClassImpl$Data$declaredNonStaticMembers$2.isChecked()), Integer.valueOf(addNewPhoneNumberViewHolder.getAbsoluteAdapterPosition()));
    }
}
