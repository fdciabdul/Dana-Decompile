package id.dana.sendmoney.ui.globalsend.form.viewholder.receiver;

import android.graphics.Bitmap;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.bumptech.glide.load.Transformation;
import com.bumptech.glide.load.resource.bitmap.CircleCrop;
import de.hdodenhof.circleimageview.CircleImageView;
import id.dana.core.ui.extension.ViewExtKt;
import id.dana.core.ui.glide.GlideApp;
import id.dana.sendmoney.R;
import id.dana.sendmoney.databinding.ItemDisabledTransferDestinationBinding;
import id.dana.sendmoney.ui.globalsend.form.model.common.GlobalSendFormModel;
import id.dana.sendmoney.ui.globalsend.form.model.form.receiver.DisabledTransferDestinationFormModel;
import id.dana.sendmoney.ui.globalsend.form.viewholder.BaseGlobalSendFormViewHolder;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 \u00072\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001\u0007B\u000f\u0012\u0006\u0010\u0004\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"Lid/dana/sendmoney/ui/globalsend/form/viewholder/receiver/DisabledTransferDestinationViewHolder;", "Lid/dana/sendmoney/ui/globalsend/form/viewholder/BaseGlobalSendFormViewHolder;", "Lid/dana/sendmoney/databinding/ItemDisabledTransferDestinationBinding;", "Lid/dana/sendmoney/ui/globalsend/form/model/common/GlobalSendFormModel;", "p0", "<init>", "(Lid/dana/sendmoney/databinding/ItemDisabledTransferDestinationBinding;)V", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class DisabledTransferDestinationViewHolder extends BaseGlobalSendFormViewHolder<ItemDisabledTransferDestinationBinding, GlobalSendFormModel> {

    /* renamed from: Companion  reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    @Override // id.dana.sendmoney.ui.globalsend.form.viewholder.BaseGlobalSendFormViewHolder
    public final /* synthetic */ void getAuthRequestContext(GlobalSendFormModel globalSendFormModel) {
        GlobalSendFormModel globalSendFormModel2 = globalSendFormModel;
        Intrinsics.checkNotNullParameter(globalSendFormModel2, "");
        DisabledTransferDestinationFormModel disabledTransferDestinationFormModel = (DisabledTransferDestinationFormModel) globalSendFormModel2;
        ItemDisabledTransferDestinationBinding itemDisabledTransferDestinationBinding = (ItemDisabledTransferDestinationBinding) this.MyBillsEntityDataFactory;
        CircleImageView circleImageView = itemDisabledTransferDestinationBinding.MyBillsEntityDataFactory;
        Intrinsics.checkNotNullExpressionValue(circleImageView, "");
        CircleImageView circleImageView2 = circleImageView;
        GlideApp.getAuthRequestContext(circleImageView2.getContext()).PlaceComponentResult(Integer.valueOf(disabledTransferDestinationFormModel.getAuthRequestContext)).getErrorConfigVersion(R.drawable.ic_user_default_placeholder).BuiltInFictitiousFunctionClassFactory((Transformation<Bitmap>) new CircleCrop()).PlaceComponentResult(R.drawable.ic_user_default_placeholder).MyBillsEntityDataFactory((ImageView) circleImageView2);
        ViewExtKt.MyBillsEntityDataFactory((ImageView) circleImageView2, true);
        itemDisabledTransferDestinationBinding.BuiltInFictitiousFunctionClassFactory.setText(itemDisabledTransferDestinationBinding.KClassImpl$Data$declaredNonStaticMembers$2.getContext().getString(disabledTransferDestinationFormModel.BuiltInFictitiousFunctionClassFactory));
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DisabledTransferDestinationViewHolder(ItemDisabledTransferDestinationBinding itemDisabledTransferDestinationBinding) {
        super(itemDisabledTransferDestinationBinding);
        Intrinsics.checkNotNullParameter(itemDisabledTransferDestinationBinding, "");
    }

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u0015\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"Lid/dana/sendmoney/ui/globalsend/form/viewholder/receiver/DisabledTransferDestinationViewHolder$Companion;", "", "Landroid/view/ViewGroup;", "p0", "Lid/dana/sendmoney/databinding/ItemDisabledTransferDestinationBinding;", "PlaceComponentResult", "(Landroid/view/ViewGroup;)Lid/dana/sendmoney/databinding/ItemDisabledTransferDestinationBinding;", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public static ItemDisabledTransferDestinationBinding PlaceComponentResult(ViewGroup p0) {
            Intrinsics.checkNotNullParameter(p0, "");
            ItemDisabledTransferDestinationBinding KClassImpl$Data$declaredNonStaticMembers$2 = ItemDisabledTransferDestinationBinding.KClassImpl$Data$declaredNonStaticMembers$2(LayoutInflater.from(p0.getContext()), p0);
            Intrinsics.checkNotNullExpressionValue(KClassImpl$Data$declaredNonStaticMembers$2, "");
            return KClassImpl$Data$declaredNonStaticMembers$2;
        }
    }
}
