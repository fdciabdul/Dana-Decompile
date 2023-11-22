package id.dana.familyaccount.adapter;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.core.content.ContextCompat;
import com.bumptech.glide.Glide;
import id.dana.R;
import id.dana.core.ui.recyclerview.BaseRecyclerViewDiffUtilAdapter;
import id.dana.core.ui.recyclerview.BaseViewBindingViewHolder;
import id.dana.databinding.ItemMemberAvailableServicesBinding;
import id.dana.domain.familyaccount.model.AvailableServicesConfig;
import id.dana.familyaccount.model.LimitInfoModel;
import id.dana.promoquest.handler.nativepage.NativePageType;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 \u000b2\u0012\u0012\u0004\u0012\u00020\u0002\u0012\b\u0012\u00060\u0003R\u00020\u00000\u0001:\u0002\u000b\fB\u000f\u0012\u0006\u0010\b\u001a\u00020\u0004¢\u0006\u0004\b\t\u0010\nR\u0014\u0010\u0007\u001a\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\u0006"}, d2 = {"Lid/dana/familyaccount/adapter/MemberAvailableServiceAdapter;", "Lid/dana/core/ui/recyclerview/BaseRecyclerViewDiffUtilAdapter;", "Lid/dana/domain/familyaccount/model/AvailableServicesConfig;", "Lid/dana/familyaccount/adapter/MemberAvailableServiceAdapter$MembersServicesViewHolder;", "Lid/dana/familyaccount/model/LimitInfoModel;", "getAuthRequestContext", "Lid/dana/familyaccount/model/LimitInfoModel;", "MyBillsEntityDataFactory", "p0", "<init>", "(Lid/dana/familyaccount/model/LimitInfoModel;)V", "Companion", "MembersServicesViewHolder"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class MemberAvailableServiceAdapter extends BaseRecyclerViewDiffUtilAdapter<AvailableServicesConfig, MembersServicesViewHolder> {

    /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
    private final LimitInfoModel MyBillsEntityDataFactory;

    @Override // id.dana.core.ui.recyclerview.BaseRecyclerViewDiffUtilAdapter
    public final /* synthetic */ MembersServicesViewHolder PlaceComponentResult(LayoutInflater layoutInflater, ViewGroup viewGroup, int i) {
        Intrinsics.checkNotNullParameter(layoutInflater, "");
        Intrinsics.checkNotNullParameter(viewGroup, "");
        ItemMemberAvailableServicesBinding PlaceComponentResult = ItemMemberAvailableServicesBinding.PlaceComponentResult(LayoutInflater.from(viewGroup.getContext()), viewGroup);
        Intrinsics.checkNotNullExpressionValue(PlaceComponentResult, "");
        return new MembersServicesViewHolder(this, PlaceComponentResult, this.MyBillsEntityDataFactory);
    }

    public MemberAvailableServiceAdapter(LimitInfoModel limitInfoModel) {
        Intrinsics.checkNotNullParameter(limitInfoModel, "");
        this.MyBillsEntityDataFactory = limitInfoModel;
    }

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0086\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0017\u0012\u0006\u0010\n\u001a\u00020\u0003\u0012\u0006\u0010\u000b\u001a\u00020\u0007¢\u0006\u0004\b\f\u0010\rR\u0014\u0010\u0006\u001a\u00020\u00038\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010\u0005R\u0014\u0010\t\u001a\u00020\u00078\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0006\u0010\b"}, d2 = {"Lid/dana/familyaccount/adapter/MemberAvailableServiceAdapter$MembersServicesViewHolder;", "Lid/dana/core/ui/recyclerview/BaseViewBindingViewHolder;", "Lid/dana/domain/familyaccount/model/AvailableServicesConfig;", "Lid/dana/databinding/ItemMemberAvailableServicesBinding;", "MyBillsEntityDataFactory", "Lid/dana/databinding/ItemMemberAvailableServicesBinding;", "getAuthRequestContext", "Lid/dana/familyaccount/model/LimitInfoModel;", "Lid/dana/familyaccount/model/LimitInfoModel;", "KClassImpl$Data$declaredNonStaticMembers$2", "p0", "p1", "<init>", "(Lid/dana/familyaccount/adapter/MemberAvailableServiceAdapter;Lid/dana/databinding/ItemMemberAvailableServicesBinding;Lid/dana/familyaccount/model/LimitInfoModel;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public final class MembersServicesViewHolder extends BaseViewBindingViewHolder<AvailableServicesConfig> {
        final /* synthetic */ MemberAvailableServiceAdapter BuiltInFictitiousFunctionClassFactory;

        /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
        private final ItemMemberAvailableServicesBinding getAuthRequestContext;

        /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
        private final LimitInfoModel KClassImpl$Data$declaredNonStaticMembers$2;

        /* JADX WARN: Illegal instructions before constructor call */
        /* JADX WARN: Type inference failed for: r0v1, types: [kotlin.jvm.internal.DefaultConstructorMarker, kotlin.jvm.functions.Function2] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public MembersServicesViewHolder(id.dana.familyaccount.adapter.MemberAvailableServiceAdapter r3, id.dana.databinding.ItemMemberAvailableServicesBinding r4, id.dana.familyaccount.model.LimitInfoModel r5) {
            /*
                r2 = this;
                java.lang.String r0 = ""
                kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r4, r0)
                kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r5, r0)
                r2.BuiltInFictitiousFunctionClassFactory = r3
                r3 = r4
                androidx.viewbinding.ViewBinding r3 = (androidx.viewbinding.ViewBinding) r3
                r0 = 0
                r1 = 2
                r2.<init>(r3, r0, r1, r0)
                r2.getAuthRequestContext = r4
                r2.KClassImpl$Data$declaredNonStaticMembers$2 = r5
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: id.dana.familyaccount.adapter.MemberAvailableServiceAdapter.MembersServicesViewHolder.<init>(id.dana.familyaccount.adapter.MemberAvailableServiceAdapter, id.dana.databinding.ItemMemberAvailableServicesBinding, id.dana.familyaccount.model.LimitInfoModel):void");
        }

        @Override // id.dana.core.ui.recyclerview.BaseViewBindingViewHolder
        public final /* synthetic */ void KClassImpl$Data$declaredNonStaticMembers$2(AvailableServicesConfig availableServicesConfig, int i) {
            AvailableServicesConfig availableServicesConfig2 = availableServicesConfig;
            Intrinsics.checkNotNullParameter(availableServicesConfig2, "");
            super.KClassImpl$Data$declaredNonStaticMembers$2((MembersServicesViewHolder) availableServicesConfig2, i);
            ItemMemberAvailableServicesBinding itemMemberAvailableServicesBinding = this.getAuthRequestContext;
            if (this.KClassImpl$Data$declaredNonStaticMembers$2.BuiltInFictitiousFunctionClassFactory.contains(availableServicesConfig2.getUseCase())) {
                ImageView imageView = itemMemberAvailableServicesBinding.KClassImpl$Data$declaredNonStaticMembers$2;
                Glide.KClassImpl$Data$declaredNonStaticMembers$2(imageView.getContext()).getAuthRequestContext(availableServicesConfig2.getIcon()).MyBillsEntityDataFactory(imageView);
                String useCase = availableServicesConfig2.getUseCase();
                if (Intrinsics.areEqual(useCase, NativePageType.SEND_MONEY)) {
                    itemMemberAvailableServicesBinding.BuiltInFictitiousFunctionClassFactory.setCardBackgroundColor(ContextCompat.BuiltInFictitiousFunctionClassFactory(itemMemberAvailableServicesBinding.getAuthRequestContext.getContext(), R.color.f22892131099749));
                } else if (Intrinsics.areEqual(useCase, "PAYMENT")) {
                    itemMemberAvailableServicesBinding.BuiltInFictitiousFunctionClassFactory.setCardBackgroundColor(ContextCompat.BuiltInFictitiousFunctionClassFactory(itemMemberAvailableServicesBinding.getAuthRequestContext.getContext(), R.color.f26682131100365));
                }
            }
        }
    }
}
