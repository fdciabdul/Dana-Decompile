package id.dana.familyaccount.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import id.dana.R;
import id.dana.core.ui.recyclerview.BaseRecyclerViewDiffUtilAdapter;
import id.dana.core.ui.recyclerview.BaseViewBindingViewHolder;
import id.dana.databinding.ItemIntroContentFamilyAccountBinding;
import id.dana.familyaccount.model.IntroContentModel;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001\bB\u000f\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007"}, d2 = {"Lid/dana/familyaccount/adapter/FamilyAccountIntroContentAdapter;", "Lid/dana/core/ui/recyclerview/BaseRecyclerViewDiffUtilAdapter;", "Lid/dana/familyaccount/model/IntroContentModel;", "Lid/dana/familyaccount/adapter/FamilyAccountIntroContentAdapter$FamilyAccountIntroViewHolder;", "Landroid/content/Context;", "p0", "<init>", "(Landroid/content/Context;)V", "FamilyAccountIntroViewHolder"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class FamilyAccountIntroContentAdapter extends BaseRecyclerViewDiffUtilAdapter<IntroContentModel, FamilyAccountIntroViewHolder> {
    @Override // id.dana.core.ui.recyclerview.BaseRecyclerViewDiffUtilAdapter
    public final /* synthetic */ FamilyAccountIntroViewHolder PlaceComponentResult(LayoutInflater layoutInflater, ViewGroup viewGroup, int i) {
        Intrinsics.checkNotNullParameter(layoutInflater, "");
        Intrinsics.checkNotNullParameter(viewGroup, "");
        ItemIntroContentFamilyAccountBinding PlaceComponentResult = ItemIntroContentFamilyAccountBinding.PlaceComponentResult(LayoutInflater.from(viewGroup.getContext()), viewGroup);
        Intrinsics.checkNotNullExpressionValue(PlaceComponentResult, "");
        return new FamilyAccountIntroViewHolder(PlaceComponentResult);
    }

    public FamilyAccountIntroContentAdapter(Context context) {
        Intrinsics.checkNotNullParameter(context, "");
        String string = context.getString(R.string.family_account_text_title_intro_1);
        Intrinsics.checkNotNullExpressionValue(string, "");
        String string2 = context.getString(R.string.family_account_text_desc_intro_1);
        Intrinsics.checkNotNullExpressionValue(string2, "");
        String string3 = context.getString(R.string.img_onboarding_family_account_1);
        Intrinsics.checkNotNullExpressionValue(string3, "");
        String string4 = context.getString(R.string.family_account_text_title_intro_2);
        Intrinsics.checkNotNullExpressionValue(string4, "");
        String string5 = context.getString(R.string.family_account_text_desc_intro_2);
        Intrinsics.checkNotNullExpressionValue(string5, "");
        String string6 = context.getString(R.string.img_onboarding_family_account_2);
        Intrinsics.checkNotNullExpressionValue(string6, "");
        String string7 = context.getString(R.string.family_account_text_title_intro_3);
        Intrinsics.checkNotNullExpressionValue(string7, "");
        String string8 = context.getString(R.string.family_account_text_desc_intro_3);
        Intrinsics.checkNotNullExpressionValue(string8, "");
        String string9 = context.getString(R.string.img_onboarding_family_account_3);
        Intrinsics.checkNotNullExpressionValue(string9, "");
        String string10 = context.getString(R.string.family_account_text_title_intro_4);
        Intrinsics.checkNotNullExpressionValue(string10, "");
        String string11 = context.getString(R.string.family_account_text_desc_intro_4);
        Intrinsics.checkNotNullExpressionValue(string11, "");
        String string12 = context.getString(R.string.img_onboarding_family_account_4);
        Intrinsics.checkNotNullExpressionValue(string12, "");
        BaseRecyclerViewDiffUtilAdapter.getAuthRequestContext(this, CollectionsKt.listOf((Object[]) new IntroContentModel[]{new IntroContentModel(R.raw.f46992131886100, string, string2, string3), new IntroContentModel(R.raw.f47002131886101, string4, string5, string6), new IntroContentModel(R.raw.f47012131886102, string7, string8, string9), new IntroContentModel(R.raw.f47022131886103, string10, string11, string12)}));
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\u0012\u0006\u0010\u0007\u001a\u00020\u0003¢\u0006\u0004\b\b\u0010\tR\u0014\u0010\u0006\u001a\u00020\u00038\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010\u0005"}, d2 = {"Lid/dana/familyaccount/adapter/FamilyAccountIntroContentAdapter$FamilyAccountIntroViewHolder;", "Lid/dana/core/ui/recyclerview/BaseViewBindingViewHolder;", "Lid/dana/familyaccount/model/IntroContentModel;", "Lid/dana/databinding/ItemIntroContentFamilyAccountBinding;", "MyBillsEntityDataFactory", "Lid/dana/databinding/ItemIntroContentFamilyAccountBinding;", "PlaceComponentResult", "p0", "<init>", "(Lid/dana/databinding/ItemIntroContentFamilyAccountBinding;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class FamilyAccountIntroViewHolder extends BaseViewBindingViewHolder<IntroContentModel> {

        /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
        private final ItemIntroContentFamilyAccountBinding PlaceComponentResult;

        @Override // id.dana.core.ui.recyclerview.BaseViewBindingViewHolder
        public final /* synthetic */ void KClassImpl$Data$declaredNonStaticMembers$2(IntroContentModel introContentModel, int i) {
            IntroContentModel introContentModel2 = introContentModel;
            Intrinsics.checkNotNullParameter(introContentModel2, "");
            super.KClassImpl$Data$declaredNonStaticMembers$2((FamilyAccountIntroViewHolder) introContentModel2, i);
            ItemIntroContentFamilyAccountBinding itemIntroContentFamilyAccountBinding = this.PlaceComponentResult;
            itemIntroContentFamilyAccountBinding.getAuthRequestContext.setAnimation(introContentModel2.MyBillsEntityDataFactory);
            itemIntroContentFamilyAccountBinding.getAuthRequestContext.setContentDescription(introContentModel2.KClassImpl$Data$declaredNonStaticMembers$2);
            itemIntroContentFamilyAccountBinding.PlaceComponentResult.setText(introContentModel2.PlaceComponentResult);
            itemIntroContentFamilyAccountBinding.BuiltInFictitiousFunctionClassFactory.setText(introContentModel2.BuiltInFictitiousFunctionClassFactory);
        }

        /* JADX WARN: Illegal instructions before constructor call */
        /* JADX WARN: Type inference failed for: r1v0, types: [kotlin.jvm.internal.DefaultConstructorMarker, kotlin.jvm.functions.Function2] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public FamilyAccountIntroViewHolder(id.dana.databinding.ItemIntroContentFamilyAccountBinding r4) {
            /*
                r3 = this;
                java.lang.String r0 = ""
                kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r4, r0)
                r0 = r4
                androidx.viewbinding.ViewBinding r0 = (androidx.viewbinding.ViewBinding) r0
                r1 = 0
                r2 = 2
                r3.<init>(r0, r1, r2, r1)
                r3.PlaceComponentResult = r4
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: id.dana.familyaccount.adapter.FamilyAccountIntroContentAdapter.FamilyAccountIntroViewHolder.<init>(id.dana.databinding.ItemIntroContentFamilyAccountBinding):void");
        }
    }
}
