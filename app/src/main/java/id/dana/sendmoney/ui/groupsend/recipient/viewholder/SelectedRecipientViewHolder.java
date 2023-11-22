package id.dana.sendmoney.ui.groupsend.recipient.viewholder;

import android.graphics.Bitmap;
import android.widget.ImageView;
import androidx.recyclerview.widget.RecyclerView;
import com.bumptech.glide.load.Transformation;
import com.bumptech.glide.load.resource.bitmap.CircleCrop;
import id.dana.core.ui.glide.GlideApp;
import id.dana.sendmoney.R;
import id.dana.sendmoney.databinding.ItemSelectedContactBinding;
import id.dana.sendmoney.ui.groupsend.recipient.model.viewmodel.RecipientViewModel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B#\u0012\u0006\u0010\u0004\u001a\u00020\b\u0012\u0012\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u00050\u000b¢\u0006\u0004\b\u0011\u0010\u0012J\u001d\u0010\u0006\u001a\u00020\u0005*\u00020\u00022\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0002¢\u0006\u0004\b\u0006\u0010\u0007R\u0014\u0010\u0006\u001a\u00020\b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\t\u0010\nR \u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u00050\u000b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u000e"}, d2 = {"Lid/dana/sendmoney/ui/groupsend/recipient/viewholder/SelectedRecipientViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Landroid/widget/ImageView;", "", "p0", "", "PlaceComponentResult", "(Landroid/widget/ImageView;Ljava/lang/String;)V", "Lid/dana/sendmoney/databinding/ItemSelectedContactBinding;", "MyBillsEntityDataFactory", "Lid/dana/sendmoney/databinding/ItemSelectedContactBinding;", "Lkotlin/Function1;", "Lid/dana/sendmoney/ui/groupsend/recipient/model/viewmodel/RecipientViewModel;", "getAuthRequestContext", "Lkotlin/jvm/functions/Function1;", "BuiltInFictitiousFunctionClassFactory", "p1", "<init>", "(Lid/dana/sendmoney/databinding/ItemSelectedContactBinding;Lkotlin/jvm/functions/Function1;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class SelectedRecipientViewHolder extends RecyclerView.ViewHolder {

    /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
    public final ItemSelectedContactBinding PlaceComponentResult;

    /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
    private final Function1<RecipientViewModel, Unit> BuiltInFictitiousFunctionClassFactory;

    public static void PlaceComponentResult(ImageView imageView, String str) {
        GlideApp.getAuthRequestContext(imageView.getContext()).PlaceComponentResult(str).getErrorConfigVersion(R.drawable.ic_user_default_placeholder).BuiltInFictitiousFunctionClassFactory((Transformation<Bitmap>) new CircleCrop()).PlaceComponentResult(R.drawable.ic_user_default_placeholder).MyBillsEntityDataFactory(imageView);
    }

    public static /* synthetic */ void BuiltInFictitiousFunctionClassFactory(SelectedRecipientViewHolder selectedRecipientViewHolder, RecipientViewModel recipientViewModel) {
        Intrinsics.checkNotNullParameter(selectedRecipientViewHolder, "");
        Intrinsics.checkNotNullParameter(recipientViewModel, "");
        selectedRecipientViewHolder.BuiltInFictitiousFunctionClassFactory.invoke(recipientViewModel);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public SelectedRecipientViewHolder(ItemSelectedContactBinding itemSelectedContactBinding, Function1<? super RecipientViewModel, Unit> function1) {
        super(itemSelectedContactBinding.MyBillsEntityDataFactory);
        Intrinsics.checkNotNullParameter(itemSelectedContactBinding, "");
        Intrinsics.checkNotNullParameter(function1, "");
        this.PlaceComponentResult = itemSelectedContactBinding;
        this.BuiltInFictitiousFunctionClassFactory = function1;
    }
}
