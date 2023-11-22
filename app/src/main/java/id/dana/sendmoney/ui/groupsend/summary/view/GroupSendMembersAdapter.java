package id.dana.sendmoney.ui.groupsend.summary.view;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.recyclerview.widget.RecyclerView;
import de.hdodenhof.circleimageview.CircleImageView;
import id.dana.core.ui.glide.GlideApp;
import id.dana.sendmoney.R;
import id.dana.sendmoney.databinding.ItemViewMembersBinding;
import id.dana.sendmoney.ui.groupsend.recipient.model.viewmodel.RecipientViewModel;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0012B\u0015\u0012\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u000b0\n¢\u0006\u0004\b\u0010\u0010\u0011J\u000f\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0004\u0010\u0005R\u0014\u0010\t\u001a\u0004\u0018\u00010\u0006X\u0086\u0002¢\u0006\u0006\n\u0004\b\u0007\u0010\bR\u0018\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u000b0\nX\u0086\u0002¢\u0006\u0006\n\u0004\b\f\u0010\r"}, d2 = {"Lid/dana/sendmoney/ui/groupsend/summary/view/GroupSendMembersAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lid/dana/sendmoney/ui/groupsend/summary/view/GroupSendMembersAdapter$GroupSendMemberViewHolder;", "", "getItemCount", "()I", "Lid/dana/sendmoney/ui/groupsend/summary/view/InputAmountListener;", "PlaceComponentResult", "Lid/dana/sendmoney/ui/groupsend/summary/view/InputAmountListener;", "KClassImpl$Data$declaredNonStaticMembers$2", "", "Lid/dana/sendmoney/ui/groupsend/recipient/model/viewmodel/RecipientViewModel;", "getAuthRequestContext", "Ljava/util/List;", "BuiltInFictitiousFunctionClassFactory", "p0", "<init>", "(Ljava/util/List;)V", "GroupSendMemberViewHolder"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class GroupSendMembersAdapter extends RecyclerView.Adapter<GroupSendMemberViewHolder> {

    /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
    public InputAmountListener KClassImpl$Data$declaredNonStaticMembers$2;

    /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
    public List<? extends RecipientViewModel> BuiltInFictitiousFunctionClassFactory;

    /* JADX WARN: Removed duplicated region for block: B:135:0x00f9  */
    /* JADX WARN: Removed duplicated region for block: B:144:0x0131  */
    /* JADX WARN: Removed duplicated region for block: B:145:0x0133  */
    /* JADX WARN: Removed duplicated region for block: B:148:0x0145  */
    /* JADX WARN: Removed duplicated region for block: B:149:0x0147  */
    /* JADX WARN: Removed duplicated region for block: B:152:0x01b8  */
    /* JADX WARN: Removed duplicated region for block: B:153:0x01bb  */
    /* JADX WARN: Removed duplicated region for block: B:156:0x01d2  */
    /* JADX WARN: Removed duplicated region for block: B:159:0x01e3  */
    /* JADX WARN: Removed duplicated region for block: B:160:0x01e9  */
    /* JADX WARN: Removed duplicated region for block: B:163:0x01f7  */
    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final /* synthetic */ void onBindViewHolder(id.dana.sendmoney.ui.groupsend.summary.view.GroupSendMembersAdapter.GroupSendMemberViewHolder r14, int r15) {
        /*
            Method dump skipped, instructions count: 509
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.sendmoney.ui.groupsend.summary.view.GroupSendMembersAdapter.onBindViewHolder(androidx.recyclerview.widget.RecyclerView$ViewHolder, int):void");
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final /* synthetic */ GroupSendMemberViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        Intrinsics.checkNotNullParameter(viewGroup, "");
        ItemViewMembersBinding PlaceComponentResult = ItemViewMembersBinding.PlaceComponentResult(LayoutInflater.from(viewGroup.getContext()), viewGroup);
        Intrinsics.checkNotNullExpressionValue(PlaceComponentResult, "");
        return new GroupSendMemberViewHolder(PlaceComponentResult, this.KClassImpl$Data$declaredNonStaticMembers$2);
    }

    public GroupSendMembersAdapter(List<? extends RecipientViewModel> list) {
        Intrinsics.checkNotNullParameter(list, "");
        this.BuiltInFictitiousFunctionClassFactory = list;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: getItemCount */
    public final int getPlaceComponentResult() {
        return this.BuiltInFictitiousFunctionClassFactory.size();
    }

    @Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u0004\u001a\u00020\b\u0012\b\u0010\u0014\u001a\u0004\u0018\u00010\u0012¢\u0006\u0004\b\u0015\u0010\u0016J\u0019\u0010\u0006\u001a\u00020\u0005*\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0006\u0010\u0007R\u0014\u0010\n\u001a\u00020\b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0006\u0010\tR\u0016\u0010\u0006\u001a\u00020\u000b8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b\f\u0010\rR\u0012\u0010\u0011\u001a\u00020\u000eX\u0086\u0002¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u0016\u0010\u000f\u001a\u0004\u0018\u00010\u00128\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\n\u0010\u0013"}, d2 = {"Lid/dana/sendmoney/ui/groupsend/summary/view/GroupSendMembersAdapter$GroupSendMemberViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Lde/hdodenhof/circleimageview/CircleImageView;", "", "p0", "", "MyBillsEntityDataFactory", "(Lde/hdodenhof/circleimageview/CircleImageView;Ljava/lang/String;)V", "Lid/dana/sendmoney/databinding/ItemViewMembersBinding;", "Lid/dana/sendmoney/databinding/ItemViewMembersBinding;", "PlaceComponentResult", "Lid/dana/sendmoney/ui/groupsend/recipient/model/viewmodel/RecipientViewModel;", "KClassImpl$Data$declaredNonStaticMembers$2", "Lid/dana/sendmoney/ui/groupsend/recipient/model/viewmodel/RecipientViewModel;", "", "getAuthRequestContext", "Z", "BuiltInFictitiousFunctionClassFactory", "Lid/dana/sendmoney/ui/groupsend/summary/view/InputAmountListener;", "Lid/dana/sendmoney/ui/groupsend/summary/view/InputAmountListener;", "p1", "<init>", "(Lid/dana/sendmoney/databinding/ItemViewMembersBinding;Lid/dana/sendmoney/ui/groupsend/summary/view/InputAmountListener;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class GroupSendMemberViewHolder extends RecyclerView.ViewHolder {

        /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
        RecipientViewModel MyBillsEntityDataFactory;

        /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
        final ItemViewMembersBinding PlaceComponentResult;

        /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
        private final InputAmountListener getAuthRequestContext;

        /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
        boolean BuiltInFictitiousFunctionClassFactory;

        public static void MyBillsEntityDataFactory(CircleImageView circleImageView, String str) {
            Intrinsics.checkNotNullParameter(circleImageView, "");
            Intrinsics.checkNotNullParameter(str, "");
            GlideApp.getAuthRequestContext(circleImageView.getContext()).PlaceComponentResult(str).getErrorConfigVersion(R.drawable.ic_user_default_placeholder).PlaceComponentResult(R.drawable.ic_user_default_placeholder).MyBillsEntityDataFactory((ImageView) circleImageView);
        }

        public static /* synthetic */ void BuiltInFictitiousFunctionClassFactory(GroupSendMemberViewHolder groupSendMemberViewHolder, ItemViewMembersBinding itemViewMembersBinding) {
            Intrinsics.checkNotNullParameter(groupSendMemberViewHolder, "");
            Intrinsics.checkNotNullParameter(itemViewMembersBinding, "");
            InputAmountListener inputAmountListener = groupSendMemberViewHolder.getAuthRequestContext;
            if (inputAmountListener != null) {
                inputAmountListener.MyBillsEntityDataFactory(itemViewMembersBinding.lookAheadTest.getText().toString(), groupSendMemberViewHolder.getBindingAdapterPosition());
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public GroupSendMemberViewHolder(ItemViewMembersBinding itemViewMembersBinding, InputAmountListener inputAmountListener) {
            super(itemViewMembersBinding.KClassImpl$Data$declaredNonStaticMembers$2);
            Intrinsics.checkNotNullParameter(itemViewMembersBinding, "");
            this.PlaceComponentResult = itemViewMembersBinding;
            this.getAuthRequestContext = inputAmountListener;
        }
    }
}
