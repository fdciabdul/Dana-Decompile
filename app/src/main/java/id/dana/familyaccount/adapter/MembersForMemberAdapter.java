package id.dana.familyaccount.adapter;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import id.dana.R;
import id.dana.core.ui.recyclerview.BaseRecyclerViewDiffUtilAdapter;
import id.dana.core.ui.recyclerview.BaseViewBindingViewHolder;
import id.dana.databinding.ItemSectionMemberListBinding;
import id.dana.familyaccount.constants.FamilyAccountInvitationStatusType;
import id.dana.familyaccount.model.FamilyMemberInfoModel;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001\u0006B\u0007¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Lid/dana/familyaccount/adapter/MembersForMemberAdapter;", "Lid/dana/core/ui/recyclerview/BaseRecyclerViewDiffUtilAdapter;", "Lid/dana/familyaccount/model/FamilyMemberInfoModel;", "Lid/dana/familyaccount/adapter/MembersForMemberAdapter$MembersForMemberViewHolder;", "<init>", "()V", "MembersForMemberViewHolder"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class MembersForMemberAdapter extends BaseRecyclerViewDiffUtilAdapter<FamilyMemberInfoModel, MembersForMemberViewHolder> {
    @Override // id.dana.core.ui.recyclerview.BaseRecyclerViewDiffUtilAdapter
    public final /* synthetic */ MembersForMemberViewHolder PlaceComponentResult(LayoutInflater layoutInflater, ViewGroup viewGroup, int i) {
        Intrinsics.checkNotNullParameter(layoutInflater, "");
        Intrinsics.checkNotNullParameter(viewGroup, "");
        ItemSectionMemberListBinding BuiltInFictitiousFunctionClassFactory = ItemSectionMemberListBinding.BuiltInFictitiousFunctionClassFactory(LayoutInflater.from(viewGroup.getContext()), viewGroup);
        Intrinsics.checkNotNullExpressionValue(BuiltInFictitiousFunctionClassFactory, "");
        return new MembersForMemberViewHolder(BuiltInFictitiousFunctionClassFactory);
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\u0012\u0006\u0010\u0007\u001a\u00020\u0003¢\u0006\u0004\b\b\u0010\tR\u0014\u0010\u0006\u001a\u00020\u00038\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010\u0005"}, d2 = {"Lid/dana/familyaccount/adapter/MembersForMemberAdapter$MembersForMemberViewHolder;", "Lid/dana/core/ui/recyclerview/BaseViewBindingViewHolder;", "Lid/dana/familyaccount/model/FamilyMemberInfoModel;", "Lid/dana/databinding/ItemSectionMemberListBinding;", "BuiltInFictitiousFunctionClassFactory", "Lid/dana/databinding/ItemSectionMemberListBinding;", "KClassImpl$Data$declaredNonStaticMembers$2", "p0", "<init>", "(Lid/dana/databinding/ItemSectionMemberListBinding;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class MembersForMemberViewHolder extends BaseViewBindingViewHolder<FamilyMemberInfoModel> {

        /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
        private final ItemSectionMemberListBinding KClassImpl$Data$declaredNonStaticMembers$2;

        @Override // id.dana.core.ui.recyclerview.BaseViewBindingViewHolder
        public final /* synthetic */ void KClassImpl$Data$declaredNonStaticMembers$2(FamilyMemberInfoModel familyMemberInfoModel, int i) {
            FamilyMemberInfoModel familyMemberInfoModel2 = familyMemberInfoModel;
            Intrinsics.checkNotNullParameter(familyMemberInfoModel2, "");
            super.KClassImpl$Data$declaredNonStaticMembers$2((MembersForMemberViewHolder) familyMemberInfoModel2, i);
            ItemSectionMemberListBinding itemSectionMemberListBinding = this.KClassImpl$Data$declaredNonStaticMembers$2;
            itemSectionMemberListBinding.getAuthRequestContext.loadImage(familyMemberInfoModel2.getAuthRequestContext.KClassImpl$Data$declaredNonStaticMembers$2, R.drawable.ic_avatar_grey_default);
            itemSectionMemberListBinding.getAuthRequestContext.setBorderColor(R.drawable.bg_grey_circle);
            TextView textView = itemSectionMemberListBinding.getErrorConfigVersion;
            String str = familyMemberInfoModel2.getAuthRequestContext.getAuthRequestContext;
            if (str.length() == 0) {
                str = familyMemberInfoModel2.getAuthRequestContext.PlaceComponentResult;
            }
            textView.setText(str);
            String str2 = familyMemberInfoModel2.MyBillsEntityDataFactory;
            Locale locale = Locale.getDefault();
            Intrinsics.checkNotNullExpressionValue(locale, "");
            String upperCase = str2.toUpperCase(locale);
            Intrinsics.checkNotNullExpressionValue(upperCase, "");
            if (Intrinsics.areEqual(upperCase, FamilyAccountInvitationStatusType.ACCOUNT_OWNER)) {
                TextView textView2 = this.KClassImpl$Data$declaredNonStaticMembers$2.NetworkUserEntityData$$ExternalSyntheticLambda0;
                textView2.setText(textView2.getContext().getString(R.string.family_account_member_as_owner));
            } else if (Intrinsics.areEqual(upperCase, "MEMBER")) {
                TextView textView3 = this.KClassImpl$Data$declaredNonStaticMembers$2.NetworkUserEntityData$$ExternalSyntheticLambda0;
                textView3.setText(textView3.getContext().getString(R.string.family_account_member_as_member));
            } else {
                ConstraintLayout constraintLayout = this.KClassImpl$Data$declaredNonStaticMembers$2.PlaceComponentResult;
                Intrinsics.checkNotNullExpressionValue(constraintLayout, "");
                constraintLayout.setVisibility(8);
            }
        }

        /* JADX WARN: Illegal instructions before constructor call */
        /* JADX WARN: Type inference failed for: r1v0, types: [kotlin.jvm.internal.DefaultConstructorMarker, kotlin.jvm.functions.Function2] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public MembersForMemberViewHolder(id.dana.databinding.ItemSectionMemberListBinding r4) {
            /*
                r3 = this;
                java.lang.String r0 = ""
                kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r4, r0)
                r0 = r4
                androidx.viewbinding.ViewBinding r0 = (androidx.viewbinding.ViewBinding) r0
                r1 = 0
                r2 = 2
                r3.<init>(r0, r1, r2, r1)
                r3.KClassImpl$Data$declaredNonStaticMembers$2 = r4
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: id.dana.familyaccount.adapter.MembersForMemberAdapter.MembersForMemberViewHolder.<init>(id.dana.databinding.ItemSectionMemberListBinding):void");
        }
    }
}
