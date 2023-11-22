package id.dana.sendmoney.ui.groupsend.groupdetail.adapter;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import de.hdodenhof.circleimageview.CircleImageView;
import id.dana.component.formcomponent.DanaCheckboxButtonView;
import id.dana.core.ui.glide.GlideApp;
import id.dana.core.ui.util.MaskedTextUtil;
import id.dana.data.social.common.PhoneNumberUtilKt;
import id.dana.sendmoney.R;
import id.dana.sendmoney.databinding.ItemGroupRecipientBinding;
import id.dana.sendmoney.ui.groupsend.groupdetail.model.GroupDetailModel;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.text.StringsKt;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u000eB\u0017\u0012\u000e\b\u0002\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\u0004\b\f\u0010\rJ\u000f\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0004\u0010\u0005R\u001c\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00070\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\b\u0010\t"}, d2 = {"Lid/dana/sendmoney/ui/groupsend/groupdetail/adapter/MemberListAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lid/dana/sendmoney/ui/groupsend/groupdetail/adapter/MemberListAdapter$MemberListAdapterViewHolder;", "", "getItemCount", "()I", "", "Lid/dana/sendmoney/ui/groupsend/groupdetail/model/GroupDetailModel;", "getAuthRequestContext", "Ljava/util/List;", "KClassImpl$Data$declaredNonStaticMembers$2", "p0", "<init>", "(Ljava/util/List;)V", "MemberListAdapterViewHolder"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class MemberListAdapter extends RecyclerView.Adapter<MemberListAdapterViewHolder> {

    /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
    private List<GroupDetailModel> KClassImpl$Data$declaredNonStaticMembers$2;

    /* JADX WARN: Illegal instructions before constructor call */
    /* JADX WARN: Type inference failed for: r0v0, types: [java.util.List, kotlin.jvm.internal.DefaultConstructorMarker] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public MemberListAdapter() {
        /*
            r2 = this;
            r0 = 0
            r1 = 1
            r2.<init>(r0, r1, r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.sendmoney.ui.groupsend.groupdetail.adapter.MemberListAdapter.<init>():void");
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final /* synthetic */ void onBindViewHolder(MemberListAdapterViewHolder memberListAdapterViewHolder, int i) {
        MemberListAdapterViewHolder memberListAdapterViewHolder2 = memberListAdapterViewHolder;
        Intrinsics.checkNotNullParameter(memberListAdapterViewHolder2, "");
        GroupDetailModel groupDetailModel = this.KClassImpl$Data$declaredNonStaticMembers$2.get(i);
        Intrinsics.checkNotNullParameter(groupDetailModel, "");
        memberListAdapterViewHolder2.KClassImpl$Data$declaredNonStaticMembers$2 = groupDetailModel;
        ItemGroupRecipientBinding itemGroupRecipientBinding = memberListAdapterViewHolder2.getAuthRequestContext;
        ConstraintLayout constraintLayout = itemGroupRecipientBinding.PlaceComponentResult;
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        String string = memberListAdapterViewHolder2.itemView.getContext().getString(R.string.res_0x7f130d13_promocategorypresenter_1);
        Intrinsics.checkNotNullExpressionValue(string, "");
        String format = String.format(string, Arrays.copyOf(new Object[]{String.valueOf(memberListAdapterViewHolder2.getAbsoluteAdapterPosition())}, 1));
        Intrinsics.checkNotNullExpressionValue(format, "");
        constraintLayout.setContentDescription(format);
        DanaCheckboxButtonView danaCheckboxButtonView = itemGroupRecipientBinding.KClassImpl$Data$declaredNonStaticMembers$2;
        Intrinsics.checkNotNullExpressionValue(danaCheckboxButtonView, "");
        danaCheckboxButtonView.setVisibility(8);
        CircleImageView circleImageView = itemGroupRecipientBinding.MyBillsEntityDataFactory;
        Intrinsics.checkNotNullExpressionValue(circleImageView, "");
        MemberListAdapterViewHolder.PlaceComponentResult(circleImageView, groupDetailModel.MyBillsEntityDataFactory);
        itemGroupRecipientBinding.scheduleImpl.setText(groupDetailModel.PlaceComponentResult);
        AppCompatTextView appCompatTextView = itemGroupRecipientBinding.getErrorConfigVersion;
        MaskedTextUtil maskedTextUtil = MaskedTextUtil.INSTANCE;
        appCompatTextView.setText(MaskedTextUtil.BuiltInFictitiousFunctionClassFactory(groupDetailModel.BuiltInFictitiousFunctionClassFactory));
        AppCompatImageView appCompatImageView = itemGroupRecipientBinding.getAuthRequestContext;
        Intrinsics.checkNotNullExpressionValue(appCompatImageView, "");
        appCompatImageView.setVisibility(Intrinsics.areEqual(groupDetailModel.KClassImpl$Data$declaredNonStaticMembers$2, Boolean.TRUE) ? 0 : 8);
        itemGroupRecipientBinding.getAuthRequestContext.setContentDescription(memberListAdapterViewHolder2.itemView.getContext().getString(R.string.img_logo_dana_user));
        if (StringsKt.contains$default((CharSequence) groupDetailModel.PlaceComponentResult, (CharSequence) "-", false, 2, (Object) null) || PhoneNumberUtilKt.isDigitsOnly(groupDetailModel.PlaceComponentResult)) {
            AppCompatTextView appCompatTextView2 = itemGroupRecipientBinding.getErrorConfigVersion;
            Intrinsics.checkNotNullExpressionValue(appCompatTextView2, "");
            appCompatTextView2.setVisibility(8);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final /* synthetic */ MemberListAdapterViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        Intrinsics.checkNotNullParameter(viewGroup, "");
        ItemGroupRecipientBinding MyBillsEntityDataFactory = ItemGroupRecipientBinding.MyBillsEntityDataFactory(LayoutInflater.from(viewGroup.getContext()), viewGroup);
        Intrinsics.checkNotNullExpressionValue(MyBillsEntityDataFactory, "");
        return new MemberListAdapterViewHolder(MyBillsEntityDataFactory);
    }

    public /* synthetic */ MemberListAdapter(ArrayList arrayList, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? new ArrayList() : arrayList);
    }

    public MemberListAdapter(List<GroupDetailModel> list) {
        Intrinsics.checkNotNullParameter(list, "");
        this.KClassImpl$Data$declaredNonStaticMembers$2 = list;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: getItemCount */
    public final int getPlaceComponentResult() {
        return this.KClassImpl$Data$declaredNonStaticMembers$2.size();
    }

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0004\u001a\u00020\b¢\u0006\u0004\b\u000f\u0010\u0010J\u0019\u0010\u0006\u001a\u00020\u0005*\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0006\u0010\u0007R\u0014\u0010\n\u001a\u00020\b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0006\u0010\tR\u0016\u0010\u000e\u001a\u00020\u000b8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b\f\u0010\r"}, d2 = {"Lid/dana/sendmoney/ui/groupsend/groupdetail/adapter/MemberListAdapter$MemberListAdapterViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Lde/hdodenhof/circleimageview/CircleImageView;", "", "p0", "", "PlaceComponentResult", "(Lde/hdodenhof/circleimageview/CircleImageView;Ljava/lang/String;)V", "Lid/dana/sendmoney/databinding/ItemGroupRecipientBinding;", "Lid/dana/sendmoney/databinding/ItemGroupRecipientBinding;", "getAuthRequestContext", "Lid/dana/sendmoney/ui/groupsend/groupdetail/model/GroupDetailModel;", "MyBillsEntityDataFactory", "Lid/dana/sendmoney/ui/groupsend/groupdetail/model/GroupDetailModel;", "KClassImpl$Data$declaredNonStaticMembers$2", "<init>", "(Lid/dana/sendmoney/databinding/ItemGroupRecipientBinding;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class MemberListAdapterViewHolder extends RecyclerView.ViewHolder {

        /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
        GroupDetailModel KClassImpl$Data$declaredNonStaticMembers$2;

        /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
        final ItemGroupRecipientBinding getAuthRequestContext;

        public static void PlaceComponentResult(CircleImageView circleImageView, String str) {
            Intrinsics.checkNotNullParameter(circleImageView, "");
            Intrinsics.checkNotNullParameter(str, "");
            GlideApp.getAuthRequestContext(circleImageView.getContext()).PlaceComponentResult(str).getErrorConfigVersion(R.drawable.ic_user_default_placeholder).PlaceComponentResult(R.drawable.ic_user_default_placeholder).MyBillsEntityDataFactory((ImageView) circleImageView);
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public MemberListAdapterViewHolder(ItemGroupRecipientBinding itemGroupRecipientBinding) {
            super(itemGroupRecipientBinding.NetworkUserEntityData$$ExternalSyntheticLambda0);
            Intrinsics.checkNotNullParameter(itemGroupRecipientBinding, "");
            this.getAuthRequestContext = itemGroupRecipientBinding;
        }
    }
}
