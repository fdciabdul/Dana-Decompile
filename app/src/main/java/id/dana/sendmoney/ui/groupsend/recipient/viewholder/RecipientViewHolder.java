package id.dana.sendmoney.ui.groupsend.recipient.viewholder;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.View;
import android.widget.ImageView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import com.bumptech.glide.load.Transformation;
import com.bumptech.glide.load.resource.bitmap.CircleCrop;
import de.hdodenhof.circleimageview.CircleImageView;
import id.dana.component.formcomponent.DanaCheckboxButtonView;
import id.dana.core.ui.glide.GlideApp;
import id.dana.core.ui.util.NumberUtil;
import id.dana.sendmoney.R;
import id.dana.sendmoney.databinding.ItemGroupRecipientBinding;
import id.dana.sendmoney.ui.groupsend.recipient.model.viewmodel.RecipientViewModel;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0010\b\n\u0002\b\u0005\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B/\u0012\u0006\u0010\u0004\u001a\u00020\u0002\u0012\u001e\u0010\r\u001a\u001a\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u00050\b¢\u0006\u0004\b\u000e\u0010\u000fJ\u0017\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0006\u0010\u0007R,\u0010\u0006\u001a\u001a\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u00050\b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010\f"}, d2 = {"Lid/dana/sendmoney/ui/groupsend/recipient/viewholder/RecipientViewHolder;", "Lid/dana/sendmoney/ui/groupsend/recipient/viewholder/BaseRecipientViewHolder;", "Lid/dana/sendmoney/databinding/ItemGroupRecipientBinding;", "Lid/dana/sendmoney/ui/groupsend/recipient/model/viewmodel/RecipientViewModel;", "p0", "", "MyBillsEntityDataFactory", "(Lid/dana/sendmoney/ui/groupsend/recipient/model/viewmodel/RecipientViewModel;)V", "Lkotlin/Function3;", "", "", "BuiltInFictitiousFunctionClassFactory", "Lkotlin/jvm/functions/Function3;", "p1", "<init>", "(Lid/dana/sendmoney/databinding/ItemGroupRecipientBinding;Lkotlin/jvm/functions/Function3;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class RecipientViewHolder extends BaseRecipientViewHolder<ItemGroupRecipientBinding> {

    /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
    private final Function3<RecipientViewModel, Boolean, Integer, Unit> MyBillsEntityDataFactory;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public RecipientViewHolder(ItemGroupRecipientBinding itemGroupRecipientBinding, Function3<? super RecipientViewModel, ? super Boolean, ? super Integer, Unit> function3) {
        super(itemGroupRecipientBinding);
        Intrinsics.checkNotNullParameter(itemGroupRecipientBinding, "");
        Intrinsics.checkNotNullParameter(function3, "");
        this.MyBillsEntityDataFactory = function3;
    }

    @Override // id.dana.sendmoney.ui.groupsend.recipient.viewholder.BaseRecipientViewHolder
    public final void MyBillsEntityDataFactory(final RecipientViewModel p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        Context context = PlaceComponentResult().NetworkUserEntityData$$ExternalSyntheticLambda0.getContext();
        final ItemGroupRecipientBinding PlaceComponentResult = PlaceComponentResult();
        String str = p0.scheduleImpl;
        if (str != null) {
            Intrinsics.checkNotNullExpressionValue(str, "");
            CircleImageView circleImageView = PlaceComponentResult.MyBillsEntityDataFactory;
            Intrinsics.checkNotNullExpressionValue(circleImageView, "");
            GlideApp.getAuthRequestContext(PlaceComponentResult().NetworkUserEntityData$$ExternalSyntheticLambda0.getContext()).PlaceComponentResult(str).getErrorConfigVersion(R.drawable.ic_user_default_placeholder).BuiltInFictitiousFunctionClassFactory((Transformation<Bitmap>) new CircleCrop()).PlaceComponentResult(R.drawable.ic_user_default_placeholder).MyBillsEntityDataFactory((ImageView) circleImageView);
        }
        PlaceComponentResult.scheduleImpl.setText(p0.initRecordTimeStamp);
        PlaceComponentResult.getErrorConfigVersion.setText(p0.DatabaseTableConfigUtil);
        AppCompatTextView appCompatTextView = PlaceComponentResult.getErrorConfigVersion;
        NumberUtil numberUtil = NumberUtil.INSTANCE;
        String str2 = p0.DatabaseTableConfigUtil;
        Intrinsics.checkNotNullExpressionValue(str2, "");
        appCompatTextView.setText(NumberUtil.MyBillsEntityDataFactory(str2));
        AppCompatImageView appCompatImageView = PlaceComponentResult.getAuthRequestContext;
        Intrinsics.checkNotNullExpressionValue(appCompatImageView, "");
        appCompatImageView.setVisibility(p0.KClassImpl$Data$declaredNonStaticMembers$2() ? 0 : 8);
        PlaceComponentResult.getAuthRequestContext.setContentDescription(context.getString(R.string.img_logo_dana_user));
        PlaceComponentResult.KClassImpl$Data$declaredNonStaticMembers$2.setChecked(p0.BuiltInFictitiousFunctionClassFactory());
        DanaCheckboxButtonView danaCheckboxButtonView = PlaceComponentResult.KClassImpl$Data$declaredNonStaticMembers$2;
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        String string = context.getString(R.string.checkbox_contact);
        Intrinsics.checkNotNullExpressionValue(string, "");
        NumberUtil numberUtil2 = NumberUtil.INSTANCE;
        String format = String.format(string, Arrays.copyOf(new Object[]{NumberUtil.PlaceComponentResult(p0.DatabaseTableConfigUtil, "+62")}, 1));
        Intrinsics.checkNotNullExpressionValue(format, "");
        danaCheckboxButtonView.setContentDescription(format);
        PlaceComponentResult.KClassImpl$Data$declaredNonStaticMembers$2.setOnClickListener(new View.OnClickListener() { // from class: id.dana.sendmoney.ui.groupsend.recipient.viewholder.RecipientViewHolder$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                RecipientViewHolder.MyBillsEntityDataFactory(RecipientViewHolder.this, p0, PlaceComponentResult);
            }
        });
        PlaceComponentResult.NetworkUserEntityData$$ExternalSyntheticLambda0.setOnClickListener(new View.OnClickListener() { // from class: id.dana.sendmoney.ui.groupsend.recipient.viewholder.RecipientViewHolder$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                RecipientViewHolder.PlaceComponentResult(ItemGroupRecipientBinding.this, this, p0);
            }
        });
    }

    public static /* synthetic */ void PlaceComponentResult(ItemGroupRecipientBinding itemGroupRecipientBinding, RecipientViewHolder recipientViewHolder, RecipientViewModel recipientViewModel) {
        Intrinsics.checkNotNullParameter(itemGroupRecipientBinding, "");
        Intrinsics.checkNotNullParameter(recipientViewHolder, "");
        Intrinsics.checkNotNullParameter(recipientViewModel, "");
        itemGroupRecipientBinding.KClassImpl$Data$declaredNonStaticMembers$2.setChecked(!itemGroupRecipientBinding.KClassImpl$Data$declaredNonStaticMembers$2.isChecked());
        recipientViewHolder.MyBillsEntityDataFactory.invoke(recipientViewModel, Boolean.valueOf(itemGroupRecipientBinding.KClassImpl$Data$declaredNonStaticMembers$2.isChecked()), Integer.valueOf(recipientViewHolder.getAbsoluteAdapterPosition()));
    }

    public static /* synthetic */ void MyBillsEntityDataFactory(RecipientViewHolder recipientViewHolder, RecipientViewModel recipientViewModel, ItemGroupRecipientBinding itemGroupRecipientBinding) {
        Intrinsics.checkNotNullParameter(recipientViewHolder, "");
        Intrinsics.checkNotNullParameter(recipientViewModel, "");
        Intrinsics.checkNotNullParameter(itemGroupRecipientBinding, "");
        recipientViewHolder.MyBillsEntityDataFactory.invoke(recipientViewModel, Boolean.valueOf(itemGroupRecipientBinding.KClassImpl$Data$declaredNonStaticMembers$2.isChecked()), Integer.valueOf(recipientViewHolder.getAbsoluteAdapterPosition()));
    }
}
