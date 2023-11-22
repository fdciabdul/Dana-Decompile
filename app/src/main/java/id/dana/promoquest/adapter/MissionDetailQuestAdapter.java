package id.dana.promoquest.adapter;

import android.content.Context;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import id.dana.base.BaseRecyclerViewAdapter;
import id.dana.promoquest.PromoQuestListener;
import id.dana.promoquest.handler.PromoQuestActionFactory;
import id.dana.promoquest.model.QuestModel;
import id.dana.promoquest.views.QuestViewHolder;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001\u0017B'\u0012\u0006\u0010\u0011\u001a\u00020\u0004\u0012\u0006\u0010\u0012\u001a\u00020\u000b\u0012\u0006\u0010\u0013\u001a\u00020\u000e\u0012\u0006\u0010\u0014\u001a\u00020\b¢\u0006\u0004\b\u0015\u0010\u0016R\u0014\u0010\u0007\u001a\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\u0006R\u0014\u0010\n\u001a\u00020\b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\tR\u0014\u0010\f\u001a\u00020\u000b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\f\u0010\rR\u0014\u0010\u000f\u001a\u00020\u000e8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010"}, d2 = {"Lid/dana/promoquest/adapter/MissionDetailQuestAdapter;", "Lid/dana/base/BaseRecyclerViewAdapter;", "Lid/dana/promoquest/views/QuestViewHolder;", "Lid/dana/promoquest/model/QuestModel;", "Lid/dana/promoquest/handler/PromoQuestActionFactory;", "PlaceComponentResult", "Lid/dana/promoquest/handler/PromoQuestActionFactory;", "BuiltInFictitiousFunctionClassFactory", "", "Z", "KClassImpl$Data$declaredNonStaticMembers$2", "Lid/dana/promoquest/PromoQuestListener$QuestAction;", "getAuthRequestContext", "Lid/dana/promoquest/PromoQuestListener$QuestAction;", "Lid/dana/promoquest/adapter/MissionDetailQuestAdapter$RedeemQuestListener;", "MyBillsEntityDataFactory", "Lid/dana/promoquest/adapter/MissionDetailQuestAdapter$RedeemQuestListener;", "p0", "p1", "p2", "p3", "<init>", "(Lid/dana/promoquest/handler/PromoQuestActionFactory;Lid/dana/promoquest/PromoQuestListener$QuestAction;Lid/dana/promoquest/adapter/MissionDetailQuestAdapter$RedeemQuestListener;Z)V", "RedeemQuestListener"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class MissionDetailQuestAdapter extends BaseRecyclerViewAdapter<QuestViewHolder, QuestModel> {

    /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
    private final boolean KClassImpl$Data$declaredNonStaticMembers$2;
    private final RedeemQuestListener MyBillsEntityDataFactory;

    /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
    private final PromoQuestActionFactory BuiltInFictitiousFunctionClassFactory;
    private final PromoQuestListener.QuestAction getAuthRequestContext;

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001À\u0006\u0001"}, d2 = {"Lid/dana/promoquest/adapter/MissionDetailQuestAdapter$RedeemQuestListener;", "", "", "p0", "", "getAuthRequestContext", "(Ljava/lang/String;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public interface RedeemQuestListener {
        void getAuthRequestContext(String p0);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final /* synthetic */ RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        Intrinsics.checkNotNullParameter(viewGroup, "");
        Context context = viewGroup.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "");
        int itemCount = getItemCount();
        List<QuestModel> items = getItems();
        Intrinsics.checkNotNullExpressionValue(items, "");
        return new QuestViewHolder(context, viewGroup, itemCount, items, this.BuiltInFictitiousFunctionClassFactory, this.getAuthRequestContext, this.MyBillsEntityDataFactory, this.KClassImpl$Data$declaredNonStaticMembers$2);
    }

    public MissionDetailQuestAdapter(PromoQuestActionFactory promoQuestActionFactory, PromoQuestListener.QuestAction questAction, RedeemQuestListener redeemQuestListener, boolean z) {
        Intrinsics.checkNotNullParameter(promoQuestActionFactory, "");
        Intrinsics.checkNotNullParameter(questAction, "");
        Intrinsics.checkNotNullParameter(redeemQuestListener, "");
        this.BuiltInFictitiousFunctionClassFactory = promoQuestActionFactory;
        this.getAuthRequestContext = questAction;
        this.MyBillsEntityDataFactory = redeemQuestListener;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = z;
    }
}
