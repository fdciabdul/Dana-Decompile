package id.dana.familyaccount.adapter;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.core.content.ContextCompat;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.google.android.material.switchmaterial.SwitchMaterial;
import id.dana.R;
import id.dana.core.ui.glide.GlideApp;
import id.dana.core.ui.recyclerview.BaseRecyclerViewDiffUtilAdapter;
import id.dana.core.ui.recyclerview.BaseViewBindingViewHolder;
import id.dana.databinding.ItemListManageAvailableServiceBinding;
import id.dana.domain.familyaccount.model.AvailableServicesConfig;
import id.dana.extension.view.ViewExtKt;
import id.dana.familyaccount.adapter.FamilyManageAvailableServicesAdapter;
import id.dana.familyaccount.model.LimitInfoModel;
import id.dana.familyaccount.model.LimitInfoModelKt;
import java.util.Arrays;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010\u000b\n\u0002\u0010\b\n\u0002\u0010\u0002\n\u0002\b\u0007\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001\u0013B/\u0012\u0006\u0010\u000f\u001a\u00020\u0004\u0012\u001e\u0010\u0010\u001a\u001a\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\f0\b¢\u0006\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0007\u001a\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\u0006R,\u0010\r\u001a\u001a\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\f0\b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u000e"}, d2 = {"Lid/dana/familyaccount/adapter/FamilyManageAvailableServicesAdapter;", "Lid/dana/core/ui/recyclerview/BaseRecyclerViewDiffUtilAdapter;", "Lid/dana/domain/familyaccount/model/AvailableServicesConfig;", "Lid/dana/familyaccount/adapter/FamilyManageAvailableServicesAdapter$FamilyManageAvailableServiceViewHolder;", "Lid/dana/familyaccount/model/LimitInfoModel;", "MyBillsEntityDataFactory", "Lid/dana/familyaccount/model/LimitInfoModel;", "getAuthRequestContext", "Lkotlin/Function3;", "", "", "", "", "KClassImpl$Data$declaredNonStaticMembers$2", "Lkotlin/jvm/functions/Function3;", "p0", "p1", "<init>", "(Lid/dana/familyaccount/model/LimitInfoModel;Lkotlin/jvm/functions/Function3;)V", "FamilyManageAvailableServiceViewHolder"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class FamilyManageAvailableServicesAdapter extends BaseRecyclerViewDiffUtilAdapter<AvailableServicesConfig, FamilyManageAvailableServiceViewHolder> {
    private final Function3<String, Boolean, Integer, Unit> KClassImpl$Data$declaredNonStaticMembers$2;

    /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
    private final LimitInfoModel getAuthRequestContext;

    @Override // id.dana.core.ui.recyclerview.BaseRecyclerViewDiffUtilAdapter
    public final /* synthetic */ FamilyManageAvailableServiceViewHolder PlaceComponentResult(LayoutInflater layoutInflater, ViewGroup viewGroup, int i) {
        Intrinsics.checkNotNullParameter(layoutInflater, "");
        Intrinsics.checkNotNullParameter(viewGroup, "");
        ItemListManageAvailableServiceBinding MyBillsEntityDataFactory = ItemListManageAvailableServiceBinding.MyBillsEntityDataFactory(LayoutInflater.from(viewGroup.getContext()), viewGroup);
        Intrinsics.checkNotNullExpressionValue(MyBillsEntityDataFactory, "");
        return new FamilyManageAvailableServiceViewHolder(MyBillsEntityDataFactory, this.getAuthRequestContext, this.KClassImpl$Data$declaredNonStaticMembers$2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public FamilyManageAvailableServicesAdapter(LimitInfoModel limitInfoModel, Function3<? super String, ? super Boolean, ? super Integer, Unit> function3) {
        Intrinsics.checkNotNullParameter(limitInfoModel, "");
        Intrinsics.checkNotNullParameter(function3, "");
        this.getAuthRequestContext = limitInfoModel;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = function3;
    }

    @Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010\u0002\n\u0002\b\u0005\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B7\u0012\u0006\u0010\u0004\u001a\u00020\u000b\u0012\u0006\u0010\u0005\u001a\u00020\u000f\u0012\u001e\u0010\u0016\u001a\u001a\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00130\u0011¢\u0006\u0004\b\u0017\u0010\u0018J\u001f\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\u0006\u0010\u0007J\u0017\u0010\t\u001a\u00020\b2\u0006\u0010\u0004\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\t\u0010\nR\u0014\u0010\u000e\u001a\u00020\u000b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\f\u0010\rR\u0014\u0010\u0006\u001a\u00020\u000f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\t\u0010\u0010R,\u0010\u0014\u001a\u001a\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00130\u00118\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015"}, d2 = {"Lid/dana/familyaccount/adapter/FamilyManageAvailableServicesAdapter$FamilyManageAvailableServiceViewHolder;", "Lid/dana/core/ui/recyclerview/BaseViewBindingViewHolder;", "Lid/dana/domain/familyaccount/model/AvailableServicesConfig;", "", "p0", "p1", "KClassImpl$Data$declaredNonStaticMembers$2", "(ZZ)Z", "", "getAuthRequestContext", "(Z)I", "Lid/dana/databinding/ItemListManageAvailableServiceBinding;", "BuiltInFictitiousFunctionClassFactory", "Lid/dana/databinding/ItemListManageAvailableServiceBinding;", "PlaceComponentResult", "Lid/dana/familyaccount/model/LimitInfoModel;", "Lid/dana/familyaccount/model/LimitInfoModel;", "Lkotlin/Function3;", "", "", "MyBillsEntityDataFactory", "Lkotlin/jvm/functions/Function3;", "p2", "<init>", "(Lid/dana/databinding/ItemListManageAvailableServiceBinding;Lid/dana/familyaccount/model/LimitInfoModel;Lkotlin/jvm/functions/Function3;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class FamilyManageAvailableServiceViewHolder extends BaseViewBindingViewHolder<AvailableServicesConfig> {

        /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
        private final ItemListManageAvailableServiceBinding PlaceComponentResult;
        private final Function3<String, Boolean, Integer, Unit> MyBillsEntityDataFactory;

        /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
        private final LimitInfoModel KClassImpl$Data$declaredNonStaticMembers$2;

        private static boolean KClassImpl$Data$declaredNonStaticMembers$2(boolean p0, boolean p1) {
            return p0 || !p1;
        }

        @Override // id.dana.core.ui.recyclerview.BaseViewBindingViewHolder
        public final /* synthetic */ void KClassImpl$Data$declaredNonStaticMembers$2(AvailableServicesConfig availableServicesConfig, final int i) {
            boolean contains;
            final AvailableServicesConfig availableServicesConfig2 = availableServicesConfig;
            Intrinsics.checkNotNullParameter(availableServicesConfig2, "");
            ItemListManageAvailableServiceBinding itemListManageAvailableServiceBinding = this.PlaceComponentResult;
            boolean KClassImpl$Data$declaredNonStaticMembers$2 = KClassImpl$Data$declaredNonStaticMembers$2(LimitInfoModelKt.BuiltInFictitiousFunctionClassFactory(this.KClassImpl$Data$declaredNonStaticMembers$2), availableServicesConfig2.isEnable());
            SwitchMaterial switchMaterial = itemListManageAvailableServiceBinding.MyBillsEntityDataFactory;
            switchMaterial.setEnabled(!KClassImpl$Data$declaredNonStaticMembers$2);
            if (KClassImpl$Data$declaredNonStaticMembers$2) {
                contains = availableServicesConfig2.getDefaultAvailability();
            } else {
                contains = this.KClassImpl$Data$declaredNonStaticMembers$2.BuiltInFictitiousFunctionClassFactory.contains(availableServicesConfig2.getUseCase());
            }
            switchMaterial.setChecked(contains);
            AppCompatImageView appCompatImageView = itemListManageAvailableServiceBinding.BuiltInFictitiousFunctionClassFactory;
            AppCompatImageView appCompatImageView2 = appCompatImageView;
            GlideApp.getAuthRequestContext(appCompatImageView.getContext()).PlaceComponentResult(availableServicesConfig2.getIcon()).getErrorConfigVersion((int) R.drawable.dana_coin).PlaceComponentResult((int) R.drawable.dana_coin).MyBillsEntityDataFactory(DiskCacheStrategy.getAuthRequestContext).MyBillsEntityDataFactory((ImageView) appCompatImageView2);
            Intrinsics.checkNotNullExpressionValue(appCompatImageView, "");
            if ((!this.PlaceComponentResult.MyBillsEntityDataFactory.isChecked()) == true) {
                ViewExtKt.KClassImpl$Data$declaredNonStaticMembers$2(appCompatImageView2);
            } else {
                ViewExtKt.getAuthRequestContext((ImageView) appCompatImageView2);
            }
            TextView textView = itemListManageAvailableServiceBinding.getAuthRequestContext;
            textView.setText(availableServicesConfig2.getServiceName());
            textView.setTextColor(getAuthRequestContext(!this.PlaceComponentResult.MyBillsEntityDataFactory.isChecked()));
            String string = textView.getContext().getString(R.string.btn_manage_service);
            Intrinsics.checkNotNullExpressionValue(string, "");
            String lowerCase = availableServicesConfig2.getServiceName().toLowerCase(Locale.ROOT);
            Intrinsics.checkNotNullExpressionValue(lowerCase, "");
            String format = String.format(string, Arrays.copyOf(new Object[]{new Regex("[\\s]+").replace(lowerCase, "-")}, 1));
            Intrinsics.checkNotNullExpressionValue(format, "");
            textView.setContentDescription(format);
            itemListManageAvailableServiceBinding.MyBillsEntityDataFactory.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: id.dana.familyaccount.adapter.FamilyManageAvailableServicesAdapter$FamilyManageAvailableServiceViewHolder$$ExternalSyntheticLambda0
                @Override // android.widget.CompoundButton.OnCheckedChangeListener
                public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                    FamilyManageAvailableServicesAdapter.FamilyManageAvailableServiceViewHolder.BuiltInFictitiousFunctionClassFactory(FamilyManageAvailableServicesAdapter.FamilyManageAvailableServiceViewHolder.this, availableServicesConfig2, i, z);
                }
            });
        }

        /* JADX WARN: Illegal instructions before constructor call */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r1v0, types: [kotlin.jvm.internal.DefaultConstructorMarker, kotlin.jvm.functions.Function2] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public FamilyManageAvailableServiceViewHolder(id.dana.databinding.ItemListManageAvailableServiceBinding r4, id.dana.familyaccount.model.LimitInfoModel r5, kotlin.jvm.functions.Function3<? super java.lang.String, ? super java.lang.Boolean, ? super java.lang.Integer, kotlin.Unit> r6) {
            /*
                r3 = this;
                java.lang.String r0 = ""
                kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r4, r0)
                kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r5, r0)
                kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r6, r0)
                r0 = r4
                androidx.viewbinding.ViewBinding r0 = (androidx.viewbinding.ViewBinding) r0
                r1 = 0
                r2 = 2
                r3.<init>(r0, r1, r2, r1)
                r3.PlaceComponentResult = r4
                r3.KClassImpl$Data$declaredNonStaticMembers$2 = r5
                r3.MyBillsEntityDataFactory = r6
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: id.dana.familyaccount.adapter.FamilyManageAvailableServicesAdapter.FamilyManageAvailableServiceViewHolder.<init>(id.dana.databinding.ItemListManageAvailableServiceBinding, id.dana.familyaccount.model.LimitInfoModel, kotlin.jvm.functions.Function3):void");
        }

        private final int getAuthRequestContext(boolean p0) {
            if (p0) {
                return ContextCompat.BuiltInFictitiousFunctionClassFactory(this.PlaceComponentResult.KClassImpl$Data$declaredNonStaticMembers$2.getContext(), R.color.f23972131099993);
            }
            return ContextCompat.BuiltInFictitiousFunctionClassFactory(this.PlaceComponentResult.KClassImpl$Data$declaredNonStaticMembers$2.getContext(), R.color.f24002131099997);
        }

        public static /* synthetic */ void BuiltInFictitiousFunctionClassFactory(FamilyManageAvailableServiceViewHolder familyManageAvailableServiceViewHolder, AvailableServicesConfig availableServicesConfig, int i, boolean z) {
            Intrinsics.checkNotNullParameter(familyManageAvailableServiceViewHolder, "");
            Intrinsics.checkNotNullParameter(availableServicesConfig, "");
            AppCompatImageView appCompatImageView = familyManageAvailableServiceViewHolder.PlaceComponentResult.BuiltInFictitiousFunctionClassFactory;
            Intrinsics.checkNotNullExpressionValue(appCompatImageView, "");
            AppCompatImageView appCompatImageView2 = appCompatImageView;
            boolean z2 = !z;
            if (z2) {
                ViewExtKt.KClassImpl$Data$declaredNonStaticMembers$2(appCompatImageView2);
            } else {
                ViewExtKt.getAuthRequestContext((ImageView) appCompatImageView2);
            }
            familyManageAvailableServiceViewHolder.PlaceComponentResult.getAuthRequestContext.setTextColor(familyManageAvailableServiceViewHolder.getAuthRequestContext(z2));
            familyManageAvailableServiceViewHolder.MyBillsEntityDataFactory.invoke(availableServicesConfig.getUseCase(), Boolean.valueOf(z), Integer.valueOf(i));
        }
    }
}
