package id.dana.sendmoney.ui.globalsend.form.viewholder.receiver;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.bumptech.glide.load.Transformation;
import com.bumptech.glide.load.resource.bitmap.CircleCrop;
import de.hdodenhof.circleimageview.CircleImageView;
import id.dana.core.ui.glide.GlideApp;
import id.dana.core.ui.util.LocaleUtil;
import id.dana.core.ui.util.NumberFormatterUtil;
import id.dana.sendmoney.R;
import id.dana.sendmoney.databinding.ItemCountryFormBinding;
import id.dana.sendmoney.ui.globalsend.form.model.common.GlobalSendFormModel;
import id.dana.sendmoney.ui.globalsend.form.model.form.receiver.CountryFormModel;
import id.dana.sendmoney.ui.globalsend.form.viewholder.BaseGlobalSendFormViewHolder;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;

@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 \u00072\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001\u0007B\u000f\u0012\u0006\u0010\u0004\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"Lid/dana/sendmoney/ui/globalsend/form/viewholder/receiver/CountryFormViewHolder;", "Lid/dana/sendmoney/ui/globalsend/form/viewholder/BaseGlobalSendFormViewHolder;", "Lid/dana/sendmoney/databinding/ItemCountryFormBinding;", "Lid/dana/sendmoney/ui/globalsend/form/model/common/GlobalSendFormModel;", "p0", "<init>", "(Lid/dana/sendmoney/databinding/ItemCountryFormBinding;)V", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class CountryFormViewHolder extends BaseGlobalSendFormViewHolder<ItemCountryFormBinding, GlobalSendFormModel> {

    /* renamed from: Companion  reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    @Override // id.dana.sendmoney.ui.globalsend.form.viewholder.BaseGlobalSendFormViewHolder
    public final /* synthetic */ void getAuthRequestContext(GlobalSendFormModel globalSendFormModel) {
        GlobalSendFormModel globalSendFormModel2 = globalSendFormModel;
        Intrinsics.checkNotNullParameter(globalSendFormModel2, "");
        CountryFormModel countryFormModel = (CountryFormModel) globalSendFormModel2;
        Context context = ((ItemCountryFormBinding) this.MyBillsEntityDataFactory).KClassImpl$Data$declaredNonStaticMembers$2.getContext();
        ItemCountryFormBinding itemCountryFormBinding = (ItemCountryFormBinding) this.MyBillsEntityDataFactory;
        CircleImageView circleImageView = itemCountryFormBinding.BuiltInFictitiousFunctionClassFactory;
        Intrinsics.checkNotNullExpressionValue(circleImageView, "");
        CircleImageView circleImageView2 = circleImageView;
        GlideApp.getAuthRequestContext(circleImageView2.getContext()).PlaceComponentResult(countryFormModel.BuiltInFictitiousFunctionClassFactory.BuiltInFictitiousFunctionClassFactory()).getErrorConfigVersion(R.drawable.bg_circle_grey_20).BuiltInFictitiousFunctionClassFactory((Transformation<Bitmap>) new CircleCrop()).PlaceComponentResult(R.drawable.bg_circle_grey_20).MyBillsEntityDataFactory((ImageView) circleImageView2);
        itemCountryFormBinding.lookAheadTest.setText(countryFormModel.BuiltInFictitiousFunctionClassFactory.getAuthRequestContext());
        String MyBillsEntityDataFactory = NumberFormatterUtil.MyBillsEntityDataFactory(LocaleUtil.BuiltInFictitiousFunctionClassFactory(), (int) Math.ceil(Double.parseDouble(countryFormModel.MyBillsEntityDataFactory.BuiltInFictitiousFunctionClassFactory) / 100.0d));
        TextView textView = itemCountryFormBinding.moveToNextValue;
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        String string = context.getString(R.string.BannerEntityDataFactory_Factory);
        Intrinsics.checkNotNullExpressionValue(string, "");
        String format = String.format(string, Arrays.copyOf(new Object[]{countryFormModel.MyBillsEntityDataFactory.KClassImpl$Data$declaredNonStaticMembers$2.getCurrency(), Integer.valueOf((int) (Double.parseDouble(countryFormModel.MyBillsEntityDataFactory.getAuthRequestContext) / 100.0d))}, 2));
        Intrinsics.checkNotNullExpressionValue(format, "");
        textView.setText(format);
        TextView textView2 = itemCountryFormBinding.getErrorConfigVersion;
        StringCompanionObject stringCompanionObject2 = StringCompanionObject.INSTANCE;
        String string2 = context.getString(R.string.BannerEntityDataFactory_Factory);
        Intrinsics.checkNotNullExpressionValue(string2, "");
        String format2 = String.format(string2, Arrays.copyOf(new Object[]{countryFormModel.MyBillsEntityDataFactory.PlaceComponentResult.getCurrency(), MyBillsEntityDataFactory}, 2));
        Intrinsics.checkNotNullExpressionValue(format2, "");
        textView2.setText(format2);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CountryFormViewHolder(ItemCountryFormBinding itemCountryFormBinding) {
        super(itemCountryFormBinding);
        Intrinsics.checkNotNullParameter(itemCountryFormBinding, "");
    }

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u0015\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"Lid/dana/sendmoney/ui/globalsend/form/viewholder/receiver/CountryFormViewHolder$Companion;", "", "Landroid/view/ViewGroup;", "p0", "Lid/dana/sendmoney/databinding/ItemCountryFormBinding;", "getAuthRequestContext", "(Landroid/view/ViewGroup;)Lid/dana/sendmoney/databinding/ItemCountryFormBinding;", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public static ItemCountryFormBinding getAuthRequestContext(ViewGroup p0) {
            Intrinsics.checkNotNullParameter(p0, "");
            ItemCountryFormBinding PlaceComponentResult = ItemCountryFormBinding.PlaceComponentResult(LayoutInflater.from(p0.getContext()), p0);
            Intrinsics.checkNotNullExpressionValue(PlaceComponentResult, "");
            return PlaceComponentResult;
        }
    }
}
