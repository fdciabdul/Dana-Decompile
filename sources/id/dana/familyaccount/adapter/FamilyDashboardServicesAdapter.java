package id.dana.familyaccount.adapter;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import id.dana.R;
import id.dana.cashier.view.InputCardNumberView;
import id.dana.core.ui.glide.GlideApp;
import id.dana.core.ui.recyclerview.BaseRecyclerViewDiffUtilAdapter;
import id.dana.core.ui.recyclerview.BaseViewBindingViewHolder;
import id.dana.databinding.ItemListAvailableServiceMemberFamilyAccountBinding;
import id.dana.domain.familyaccount.model.AvailableServicesConfig;
import id.dana.utils.ImageUtil;
import java.util.Arrays;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001\u0006B\u0007¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Lid/dana/familyaccount/adapter/FamilyDashboardServicesAdapter;", "Lid/dana/core/ui/recyclerview/BaseRecyclerViewDiffUtilAdapter;", "Lid/dana/domain/familyaccount/model/AvailableServicesConfig;", "Lid/dana/familyaccount/adapter/FamilyDashboardServicesAdapter$FamilyAccountAvailableServiceViewHolder;", "<init>", "()V", "FamilyAccountAvailableServiceViewHolder"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class FamilyDashboardServicesAdapter extends BaseRecyclerViewDiffUtilAdapter<AvailableServicesConfig, FamilyAccountAvailableServiceViewHolder> {
    @Override // id.dana.core.ui.recyclerview.BaseRecyclerViewDiffUtilAdapter
    public final /* synthetic */ FamilyAccountAvailableServiceViewHolder PlaceComponentResult(LayoutInflater layoutInflater, ViewGroup viewGroup, int i) {
        Intrinsics.checkNotNullParameter(layoutInflater, "");
        Intrinsics.checkNotNullParameter(viewGroup, "");
        ItemListAvailableServiceMemberFamilyAccountBinding authRequestContext = ItemListAvailableServiceMemberFamilyAccountBinding.getAuthRequestContext(LayoutInflater.from(viewGroup.getContext()), viewGroup);
        Intrinsics.checkNotNullExpressionValue(authRequestContext, "");
        return new FamilyAccountAvailableServiceViewHolder(authRequestContext);
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\u0012\u0006\u0010\u0007\u001a\u00020\u0003¢\u0006\u0004\b\b\u0010\tR\u0014\u0010\u0006\u001a\u00020\u00038\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010\u0005"}, d2 = {"Lid/dana/familyaccount/adapter/FamilyDashboardServicesAdapter$FamilyAccountAvailableServiceViewHolder;", "Lid/dana/core/ui/recyclerview/BaseViewBindingViewHolder;", "Lid/dana/domain/familyaccount/model/AvailableServicesConfig;", "Lid/dana/databinding/ItemListAvailableServiceMemberFamilyAccountBinding;", "getAuthRequestContext", "Lid/dana/databinding/ItemListAvailableServiceMemberFamilyAccountBinding;", "BuiltInFictitiousFunctionClassFactory", "p0", "<init>", "(Lid/dana/databinding/ItemListAvailableServiceMemberFamilyAccountBinding;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class FamilyAccountAvailableServiceViewHolder extends BaseViewBindingViewHolder<AvailableServicesConfig> {

        /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
        private final ItemListAvailableServiceMemberFamilyAccountBinding BuiltInFictitiousFunctionClassFactory;

        @Override // id.dana.core.ui.recyclerview.BaseViewBindingViewHolder
        public final /* synthetic */ void KClassImpl$Data$declaredNonStaticMembers$2(AvailableServicesConfig availableServicesConfig, int i) {
            AvailableServicesConfig availableServicesConfig2 = availableServicesConfig;
            Intrinsics.checkNotNullParameter(availableServicesConfig2, "");
            AppCompatImageView appCompatImageView = this.BuiltInFictitiousFunctionClassFactory.MyBillsEntityDataFactory;
            GlideApp.getAuthRequestContext(appCompatImageView.getContext()).PlaceComponentResult(availableServicesConfig2.getIcon()).getErrorConfigVersion((int) R.drawable.dana_coin).PlaceComponentResult((int) R.drawable.dana_coin).MyBillsEntityDataFactory(DiskCacheStrategy.getAuthRequestContext).MyBillsEntityDataFactory((ImageView) appCompatImageView);
            this.BuiltInFictitiousFunctionClassFactory.BuiltInFictitiousFunctionClassFactory.setText(availableServicesConfig2.getServiceName());
            if (!availableServicesConfig2.isEnable()) {
                ImageUtil imageUtil = ImageUtil.PlaceComponentResult;
                AppCompatImageView appCompatImageView2 = this.BuiltInFictitiousFunctionClassFactory.MyBillsEntityDataFactory;
                Intrinsics.checkNotNullExpressionValue(appCompatImageView2, "");
                ImageUtil.BuiltInFictitiousFunctionClassFactory(appCompatImageView2);
            }
            String serviceName = availableServicesConfig2.getServiceName();
            ConstraintLayout constraintLayout = this.BuiltInFictitiousFunctionClassFactory.getAuthRequestContext;
            String string = constraintLayout.getContext().getString(R.string.txt_services_family);
            Intrinsics.checkNotNullExpressionValue(string, "");
            String replace$default = StringsKt.replace$default(serviceName, (char) InputCardNumberView.DIVIDER, '-', false, 4, (Object) null);
            Locale locale = Locale.ROOT;
            Intrinsics.checkNotNullExpressionValue(locale, "");
            String lowerCase = replace$default.toLowerCase(locale);
            Intrinsics.checkNotNullExpressionValue(lowerCase, "");
            String format = String.format(string, Arrays.copyOf(new Object[]{lowerCase}, 1));
            Intrinsics.checkNotNullExpressionValue(format, "");
            constraintLayout.setContentDescription(format);
        }

        /* JADX WARN: Illegal instructions before constructor call */
        /* JADX WARN: Type inference failed for: r1v0, types: [kotlin.jvm.internal.DefaultConstructorMarker, kotlin.jvm.functions.Function2] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public FamilyAccountAvailableServiceViewHolder(id.dana.databinding.ItemListAvailableServiceMemberFamilyAccountBinding r4) {
            /*
                r3 = this;
                java.lang.String r0 = ""
                kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r4, r0)
                r0 = r4
                androidx.viewbinding.ViewBinding r0 = (androidx.viewbinding.ViewBinding) r0
                r1 = 0
                r2 = 2
                r3.<init>(r0, r1, r2, r1)
                r3.BuiltInFictitiousFunctionClassFactory = r4
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: id.dana.familyaccount.adapter.FamilyDashboardServicesAdapter.FamilyAccountAvailableServiceViewHolder.<init>(id.dana.databinding.ItemListAvailableServiceMemberFamilyAccountBinding):void");
        }
    }
}
