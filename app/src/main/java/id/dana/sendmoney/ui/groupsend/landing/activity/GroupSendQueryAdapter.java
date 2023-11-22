package id.dana.sendmoney.ui.groupsend.landing.activity;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.recyclerview.widget.RecyclerView;
import de.hdodenhof.circleimageview.CircleImageView;
import id.dana.component.buttoncomponent.DanaButtonSecondaryView;
import id.dana.core.ui.glide.GlideApp;
import id.dana.sendmoney.R;
import id.dana.sendmoney.databinding.ItemGroupSendBinding;
import id.dana.sendmoney.ui.groupsend.landing.activity.GroupSendQueryAdapter;
import id.dana.sendmoney.ui.groupsend.landing.model.GroupModel;
import id.dana.sendmoney.ui.groupsend.landing.view.GroupCircleImageRichView;
import id.dana.sendmoney.ui.groupsend.summary.model.ParticipantInfoSubmitModel;
import id.dana.sendmoney.ui.groupsend.summary.model.ParticipantSubmitModel;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\f\u0012\b\u0012\u00060\u0002R\u00020\u00000\u0001:\u0002\u0014\u0015B\u001f\u0012\u0006\u0010\u0010\u001a\u00020\u0006\u0012\u000e\b\u0002\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u000e0\r¢\u0006\u0004\b\u0012\u0010\u0013J\u000f\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\t\u001a\u00020\u0006X\u0006¢\u0006\u0006\n\u0004\b\u0007\u0010\bR\u0014\u0010\u000b\u001a\u0004\u0018\u00010\nX\u0086\u0002¢\u0006\u0006\n\u0004\b\u000b\u0010\fR\u001c\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u000e0\r8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\t\u0010\u000f"}, d2 = {"Lid/dana/sendmoney/ui/groupsend/landing/activity/GroupSendQueryAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lid/dana/sendmoney/ui/groupsend/landing/activity/GroupSendQueryAdapter$GroupSendQueryViewHolder;", "", "getItemCount", "()I", "Landroid/content/Context;", "MyBillsEntityDataFactory", "Landroid/content/Context;", "KClassImpl$Data$declaredNonStaticMembers$2", "Lid/dana/sendmoney/ui/groupsend/landing/activity/GroupSendQueryAdapter$GroupQueryListener;", "getAuthRequestContext", "Lid/dana/sendmoney/ui/groupsend/landing/activity/GroupSendQueryAdapter$GroupQueryListener;", "", "Lid/dana/sendmoney/ui/groupsend/landing/model/GroupModel;", "Ljava/util/List;", "p0", "p1", "<init>", "(Landroid/content/Context;Ljava/util/List;)V", "GroupQueryListener", "GroupSendQueryViewHolder"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class GroupSendQueryAdapter extends RecyclerView.Adapter<GroupSendQueryViewHolder> {

    /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
    List<GroupModel> MyBillsEntityDataFactory;

    /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
    final Context KClassImpl$Data$declaredNonStaticMembers$2;
    GroupQueryListener getAuthRequestContext;

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0007\u0010\u0006ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001À\u0006\u0001"}, d2 = {"Lid/dana/sendmoney/ui/groupsend/landing/activity/GroupSendQueryAdapter$GroupQueryListener;", "", "", "p0", "", "MyBillsEntityDataFactory", "(Ljava/lang/String;)V", "getAuthRequestContext"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public interface GroupQueryListener {
        void MyBillsEntityDataFactory(String p0);

        void getAuthRequestContext(String p0);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final /* synthetic */ void onBindViewHolder(GroupSendQueryViewHolder groupSendQueryViewHolder, int i) {
        GroupSendQueryViewHolder groupSendQueryViewHolder2 = groupSendQueryViewHolder;
        Intrinsics.checkNotNullParameter(groupSendQueryViewHolder2, "");
        final GroupModel groupModel = this.MyBillsEntityDataFactory.get(i);
        Intrinsics.checkNotNullParameter(groupModel, "");
        GroupCircleImageRichView groupCircleImageRichView = groupSendQueryViewHolder2.MyBillsEntityDataFactory.KClassImpl$Data$declaredNonStaticMembers$2;
        List<ParticipantSubmitModel> list = groupModel.KClassImpl$Data$declaredNonStaticMembers$2;
        ArrayList arrayList = new ArrayList();
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            ParticipantInfoSubmitModel participantInfoSubmitModel = ((ParticipantSubmitModel) it.next()).getAuthRequestContext;
            String str = participantInfoSubmitModel != null ? participantInfoSubmitModel.BuiltInFictitiousFunctionClassFactory : null;
            if (str == null) {
                str = "";
            }
            arrayList.add(str);
        }
        groupCircleImageRichView.setGroupImages(arrayList);
        GroupSendQueryAdapter groupSendQueryAdapter = groupSendQueryViewHolder2.PlaceComponentResult;
        CircleImageView circleImageView = groupSendQueryViewHolder2.MyBillsEntityDataFactory.MyBillsEntityDataFactory;
        Intrinsics.checkNotNullExpressionValue(circleImageView, "");
        GlideApp.getAuthRequestContext(circleImageView.getContext()).PlaceComponentResult(groupModel.MyBillsEntityDataFactory).getErrorConfigVersion(R.drawable.ic_user_default_placeholder).PlaceComponentResult(R.drawable.ic_user_default_placeholder).MyBillsEntityDataFactory((ImageView) circleImageView);
        TextView textView = groupSendQueryViewHolder2.MyBillsEntityDataFactory.getErrorConfigVersion;
        textView.setText(groupModel.getAuthRequestContext);
        textView.setContentDescription(textView.getContext().getString(R.string.lbl_group_name_position, Integer.valueOf(groupSendQueryViewHolder2.getAbsoluteAdapterPosition())));
        TextView textView2 = groupSendQueryViewHolder2.MyBillsEntityDataFactory.moveToNextValue;
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        String string = groupSendQueryViewHolder2.PlaceComponentResult.KClassImpl$Data$declaredNonStaticMembers$2.getString(R.string.group_item_total_member);
        Intrinsics.checkNotNullExpressionValue(string, "");
        String format = String.format(string, Arrays.copyOf(new Object[]{String.valueOf(groupModel.scheduleImpl)}, 1));
        Intrinsics.checkNotNullExpressionValue(format, "");
        textView2.setText(format);
        AppCompatImageView appCompatImageView = groupSendQueryViewHolder2.MyBillsEntityDataFactory.getAuthRequestContext;
        final GroupSendQueryAdapter groupSendQueryAdapter2 = groupSendQueryViewHolder2.PlaceComponentResult;
        appCompatImageView.setOnClickListener(new View.OnClickListener() { // from class: id.dana.sendmoney.ui.groupsend.landing.activity.GroupSendQueryAdapter$GroupSendQueryViewHolder$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                GroupSendQueryAdapter.GroupSendQueryViewHolder.getAuthRequestContext(GroupSendQueryAdapter.this, groupModel);
            }
        });
        appCompatImageView.setContentDescription(appCompatImageView.getContext().getString(R.string.res_0x7f13030f_networkuserentitydata_externalsyntheticlambda4, Integer.valueOf(groupSendQueryViewHolder2.getAbsoluteAdapterPosition())));
        DanaButtonSecondaryView danaButtonSecondaryView = groupSendQueryViewHolder2.MyBillsEntityDataFactory.BuiltInFictitiousFunctionClassFactory;
        final GroupSendQueryAdapter groupSendQueryAdapter3 = groupSendQueryViewHolder2.PlaceComponentResult;
        danaButtonSecondaryView.setOnClickListener(new View.OnClickListener() { // from class: id.dana.sendmoney.ui.groupsend.landing.activity.GroupSendQueryAdapter$GroupSendQueryViewHolder$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                GroupSendQueryAdapter.GroupSendQueryViewHolder.KClassImpl$Data$declaredNonStaticMembers$2(GroupSendQueryAdapter.this, groupModel);
            }
        });
        danaButtonSecondaryView.setContentDescription(danaButtonSecondaryView.getContext().getString(R.string.btn_send_to_existing_group_position, Integer.valueOf(groupSendQueryViewHolder2.getAbsoluteAdapterPosition())));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final /* synthetic */ GroupSendQueryViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        Intrinsics.checkNotNullParameter(viewGroup, "");
        ItemGroupSendBinding MyBillsEntityDataFactory = ItemGroupSendBinding.MyBillsEntityDataFactory(LayoutInflater.from(viewGroup.getContext()), viewGroup);
        Intrinsics.checkNotNullExpressionValue(MyBillsEntityDataFactory, "");
        return new GroupSendQueryViewHolder(this, MyBillsEntityDataFactory);
    }

    public /* synthetic */ GroupSendQueryAdapter(Context context, ArrayList arrayList, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i & 2) != 0 ? new ArrayList() : arrayList);
    }

    private GroupSendQueryAdapter(Context context, List<GroupModel> list) {
        Intrinsics.checkNotNullParameter(context, "");
        Intrinsics.checkNotNullParameter(list, "");
        this.KClassImpl$Data$declaredNonStaticMembers$2 = context;
        this.MyBillsEntityDataFactory = list;
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0005\u001a\u00020\u0002¢\u0006\u0004\b\u0006\u0010\u0007R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004"}, d2 = {"Lid/dana/sendmoney/ui/groupsend/landing/activity/GroupSendQueryAdapter$GroupSendQueryViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Lid/dana/sendmoney/databinding/ItemGroupSendBinding;", "MyBillsEntityDataFactory", "Lid/dana/sendmoney/databinding/ItemGroupSendBinding;", "p0", "<init>", "(Lid/dana/sendmoney/ui/groupsend/landing/activity/GroupSendQueryAdapter;Lid/dana/sendmoney/databinding/ItemGroupSendBinding;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public final class GroupSendQueryViewHolder extends RecyclerView.ViewHolder {
        final ItemGroupSendBinding MyBillsEntityDataFactory;
        final /* synthetic */ GroupSendQueryAdapter PlaceComponentResult;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public GroupSendQueryViewHolder(GroupSendQueryAdapter groupSendQueryAdapter, ItemGroupSendBinding itemGroupSendBinding) {
            super(itemGroupSendBinding.NetworkUserEntityData$$ExternalSyntheticLambda0);
            Intrinsics.checkNotNullParameter(itemGroupSendBinding, "");
            this.PlaceComponentResult = groupSendQueryAdapter;
            this.MyBillsEntityDataFactory = itemGroupSendBinding;
        }

        public static /* synthetic */ void getAuthRequestContext(GroupSendQueryAdapter groupSendQueryAdapter, GroupModel groupModel) {
            Intrinsics.checkNotNullParameter(groupSendQueryAdapter, "");
            Intrinsics.checkNotNullParameter(groupModel, "");
            GroupQueryListener groupQueryListener = groupSendQueryAdapter.getAuthRequestContext;
            if (groupQueryListener != null) {
                groupQueryListener.getAuthRequestContext(groupModel.BuiltInFictitiousFunctionClassFactory);
            }
        }

        public static /* synthetic */ void KClassImpl$Data$declaredNonStaticMembers$2(GroupSendQueryAdapter groupSendQueryAdapter, GroupModel groupModel) {
            Intrinsics.checkNotNullParameter(groupSendQueryAdapter, "");
            Intrinsics.checkNotNullParameter(groupModel, "");
            GroupQueryListener groupQueryListener = groupSendQueryAdapter.getAuthRequestContext;
            if (groupQueryListener != null) {
                groupQueryListener.MyBillsEntityDataFactory(groupModel.BuiltInFictitiousFunctionClassFactory);
            }
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final int getItemCount() {
        return this.MyBillsEntityDataFactory.size();
    }
}
