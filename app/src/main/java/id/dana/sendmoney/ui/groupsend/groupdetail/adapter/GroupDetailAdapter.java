package id.dana.sendmoney.ui.groupsend.groupdetail.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import id.dana.core.ui.util.MaskedTextUtil;
import id.dana.data.login.source.network.model.LoginIdType;
import id.dana.sendmoney.databinding.ItemEditGridviewBinding;
import id.dana.sendmoney.databinding.ItemMemberGridviewBinding;
import id.dana.sendmoney.databinding.ItemSeeDetailGridviewBinding;
import id.dana.sendmoney.ui.groupsend.groupdetail.model.GroupDetailModel;
import id.dana.sendmoney.ui.groupsend.groupdetail.model.ParticipantDetailModel;
import id.dana.sendmoney.ui.groupsend.groupdetail.viewholder.BaseGroupDetailViewHolder;
import id.dana.sendmoney.ui.groupsend.groupdetail.viewholder.GridEditViewHolder;
import id.dana.sendmoney.ui.groupsend.groupdetail.viewholder.GridMemberViewHolder;
import id.dana.sendmoney.ui.groupsend.groupdetail.viewholder.GridSeeDetailViewHolder;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u0000 \u001b2\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00020\u0001:\u0001\u001bB\u0017\u0012\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00110\u0013¢\u0006\u0004\b\u0019\u0010\u001aJ\u000f\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0004\u0010\u0005J\u0017\u0010\u0007\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0006\u001a\u00020\tH\u0002¢\u0006\u0004\b\u000b\u0010\fJ\u0017\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0006\u001a\u00020\nH\u0002¢\u0006\u0004\b\u000e\u0010\u000fR\u001c\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00110\u00108\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u000b\u0010\u0012R\u001c\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00110\u00138\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0014\u0010\u0012R\u001c\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00170\u00168\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u000e\u0010\u0018"}, d2 = {"Lid/dana/sendmoney/ui/groupsend/groupdetail/adapter/GroupDetailAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lid/dana/sendmoney/ui/groupsend/groupdetail/viewholder/BaseGroupDetailViewHolder;", "", "getItemCount", "()I", "p0", "getItemViewType", "(I)I", "Lid/dana/sendmoney/ui/groupsend/groupdetail/model/ParticipantDetailModel;", "", "KClassImpl$Data$declaredNonStaticMembers$2", "(Lid/dana/sendmoney/ui/groupsend/groupdetail/model/ParticipantDetailModel;)Ljava/lang/String;", "", "getAuthRequestContext", "(Ljava/lang/String;)Z", "", "Lid/dana/sendmoney/ui/groupsend/groupdetail/model/GroupDetailModel;", "Ljava/util/List;", "", "MyBillsEntityDataFactory", "BuiltInFictitiousFunctionClassFactory", "Lkotlin/Function0;", "", "Lkotlin/jvm/functions/Function0;", "<init>", "(Ljava/util/List;)V", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class GroupDetailAdapter extends RecyclerView.Adapter<BaseGroupDetailViewHolder<?>> {
    public List<GroupDetailModel> KClassImpl$Data$declaredNonStaticMembers$2;

    /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
    public List<GroupDetailModel> BuiltInFictitiousFunctionClassFactory;

    /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
    public Function0<Unit> MyBillsEntityDataFactory;

    /* JADX WARN: Illegal instructions before constructor call */
    /* JADX WARN: Type inference failed for: r0v0, types: [java.util.List, kotlin.jvm.internal.DefaultConstructorMarker] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public GroupDetailAdapter() {
        /*
            r2 = this;
            r0 = 0
            r1 = 1
            r2.<init>(r0, r1, r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.sendmoney.ui.groupsend.groupdetail.adapter.GroupDetailAdapter.<init>():void");
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final /* synthetic */ void onBindViewHolder(BaseGroupDetailViewHolder<?> baseGroupDetailViewHolder, int i) {
        BaseGroupDetailViewHolder<?> baseGroupDetailViewHolder2 = baseGroupDetailViewHolder;
        Intrinsics.checkNotNullParameter(baseGroupDetailViewHolder2, "");
        baseGroupDetailViewHolder2.KClassImpl$Data$declaredNonStaticMembers$2(this.KClassImpl$Data$declaredNonStaticMembers$2.get(i));
    }

    /* JADX WARN: Type inference failed for: r1v5, types: [androidx.recyclerview.widget.RecyclerView$ViewHolder, id.dana.sendmoney.ui.groupsend.groupdetail.viewholder.BaseGroupDetailViewHolder<?>] */
    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final /* synthetic */ BaseGroupDetailViewHolder<?> onCreateViewHolder(ViewGroup viewGroup, int i) {
        RecyclerView.ViewHolder viewHolder;
        Intrinsics.checkNotNullParameter(viewGroup, "");
        if (i == 0) {
            Context context = viewGroup.getContext();
            Intrinsics.checkNotNullExpressionValue(context, "");
            ItemEditGridviewBinding KClassImpl$Data$declaredNonStaticMembers$2 = ItemEditGridviewBinding.KClassImpl$Data$declaredNonStaticMembers$2(LayoutInflater.from(viewGroup.getContext()), viewGroup);
            Intrinsics.checkNotNullExpressionValue(KClassImpl$Data$declaredNonStaticMembers$2, "");
            viewHolder = (BaseGroupDetailViewHolder) new GridEditViewHolder(context, KClassImpl$Data$declaredNonStaticMembers$2, this.MyBillsEntityDataFactory);
        } else if (i == 1) {
            Context context2 = viewGroup.getContext();
            Intrinsics.checkNotNullExpressionValue(context2, "");
            ItemMemberGridviewBinding KClassImpl$Data$declaredNonStaticMembers$22 = ItemMemberGridviewBinding.KClassImpl$Data$declaredNonStaticMembers$2(LayoutInflater.from(viewGroup.getContext()), viewGroup);
            Intrinsics.checkNotNullExpressionValue(KClassImpl$Data$declaredNonStaticMembers$22, "");
            viewHolder = (BaseGroupDetailViewHolder) new GridMemberViewHolder(context2, KClassImpl$Data$declaredNonStaticMembers$22);
        } else {
            Context context3 = viewGroup.getContext();
            Intrinsics.checkNotNullExpressionValue(context3, "");
            ItemSeeDetailGridviewBinding MyBillsEntityDataFactory = ItemSeeDetailGridviewBinding.MyBillsEntityDataFactory(LayoutInflater.from(viewGroup.getContext()), viewGroup);
            Intrinsics.checkNotNullExpressionValue(MyBillsEntityDataFactory, "");
            viewHolder = (BaseGroupDetailViewHolder) new GridSeeDetailViewHolder(context3, MyBillsEntityDataFactory, this.BuiltInFictitiousFunctionClassFactory);
        }
        return viewHolder;
    }

    public /* synthetic */ GroupDetailAdapter(ArrayList arrayList, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? new ArrayList() : arrayList);
    }

    private GroupDetailAdapter(List<GroupDetailModel> list) {
        Intrinsics.checkNotNullParameter(list, "");
        this.BuiltInFictitiousFunctionClassFactory = list;
        this.MyBillsEntityDataFactory = new Function0<Unit>() { // from class: id.dana.sendmoney.ui.groupsend.groupdetail.adapter.GroupDetailAdapter$onEditViewHolderClickListener$1
            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2() {
            }

            @Override // kotlin.jvm.functions.Function0
            public final /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }
        };
        this.KClassImpl$Data$declaredNonStaticMembers$2 = CollectionsKt.mutableListOf(new GroupDetailModel(0, null, null, null, null, 30, null), new GroupDetailModel(2, null, null, null, null, 30, null));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: getItemCount */
    public final int getPlaceComponentResult() {
        return this.KClassImpl$Data$declaredNonStaticMembers$2.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final int getItemViewType(int p0) {
        return this.KClassImpl$Data$declaredNonStaticMembers$2.get(p0).getAuthRequestContext;
    }

    public static boolean getAuthRequestContext(String p0) {
        return Intrinsics.areEqual(p0, "USER_ID");
    }

    public static String KClassImpl$Data$declaredNonStaticMembers$2(ParticipantDetailModel p0) {
        String str = p0.getAuthRequestContext;
        if (Intrinsics.areEqual(str, "USER_ID") ? true : Intrinsics.areEqual(str, LoginIdType.MOBILE_NO)) {
            MaskedTextUtil maskedTextUtil = MaskedTextUtil.INSTANCE;
            return MaskedTextUtil.PlaceComponentResult(p0.BuiltInFictitiousFunctionClassFactory.MyBillsEntityDataFactory);
        }
        return p0.BuiltInFictitiousFunctionClassFactory.NetworkUserEntityData$$ExternalSyntheticLambda8;
    }
}
