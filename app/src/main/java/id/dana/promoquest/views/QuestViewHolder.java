package id.dana.promoquest.views;

import android.content.Context;
import android.view.ViewGroup;
import id.dana.R;
import id.dana.base.BaseRecyclerViewHolder;
import id.dana.promoquest.PromoQuestListener;
import id.dana.promoquest.adapter.MissionDetailQuestAdapter;
import id.dana.promoquest.handler.PromoQuestActionFactory;
import id.dana.promoquest.model.QuestModel;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001BU\u0012\u0006\u0010\u001f\u001a\u00020\u001e\u0012\u0006\u0010 \u001a\u00020\u000e\u0012\u0006\u0010!\u001a\u00020\u0012\u0012\u0006\u0010\"\u001a\u00020\u000e\u0012\f\u0010#\u001a\b\u0012\u0004\u0012\u00020\u00020\u0010\u0012\u0006\u0010$\u001a\u00020\b\u0012\u0006\u0010%\u001a\u00020\u0014\u0012\u0006\u0010&\u001a\u00020\u001c\u0012\u0006\u0010'\u001a\u00020\u0003¢\u0006\u0004\b(\u0010)J\u000f\u0010\u0004\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\u0006\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\u0006\u0010\u0005J\u000f\u0010\u0007\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\u0007\u0010\u0005R\u0014\u0010\u000b\u001a\u00020\b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\t\u0010\nR\u0014\u0010\u0007\u001a\u00020\u00038\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\f\u0010\rR\u0011\u0010\u0006\u001a\u00020\u000eX\u0006¢\u0006\u0006\n\u0004\b\u0004\u0010\u000fR\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00020\u0010X\u0006¢\u0006\u0006\n\u0004\b\u0006\u0010\u0011R\u0011\u0010\t\u001a\u00020\u0012X\u0006¢\u0006\u0006\n\u0004\b\u0007\u0010\u0013R\u0014\u0010\u0017\u001a\u00020\u00148\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u0014\u0010\u001b\u001a\u00020\u00188\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u0014\u0010\u0019\u001a\u00020\u001c8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0017\u0010\u001dR\u0011\u0010\f\u001a\u00020\u000eX\u0006¢\u0006\u0006\n\u0004\b\u000b\u0010\u000f"}, d2 = {"Lid/dana/promoquest/views/QuestViewHolder;", "Lid/dana/base/BaseRecyclerViewHolder;", "Lid/dana/promoquest/model/QuestModel;", "", "KClassImpl$Data$declaredNonStaticMembers$2", "()Z", "MyBillsEntityDataFactory", "BuiltInFictitiousFunctionClassFactory", "Lid/dana/promoquest/handler/PromoQuestActionFactory;", "PlaceComponentResult", "Lid/dana/promoquest/handler/PromoQuestActionFactory;", "getAuthRequestContext", "moveToNextValue", "Z", "", "I", "", "Ljava/util/List;", "Landroid/view/ViewGroup;", "Landroid/view/ViewGroup;", "Lid/dana/promoquest/PromoQuestListener$QuestAction;", "getErrorConfigVersion", "Lid/dana/promoquest/PromoQuestListener$QuestAction;", "lookAheadTest", "Lid/dana/promoquest/views/QuestView;", "NetworkUserEntityData$$ExternalSyntheticLambda0", "Lid/dana/promoquest/views/QuestView;", "scheduleImpl", "Lid/dana/promoquest/adapter/MissionDetailQuestAdapter$RedeemQuestListener;", "Lid/dana/promoquest/adapter/MissionDetailQuestAdapter$RedeemQuestListener;", "Landroid/content/Context;", "p0", "p1", "p2", "p3", "p4", "p5", "p6", "p7", "p8", "<init>", "(Landroid/content/Context;Landroid/view/ViewGroup;ILjava/util/List;Lid/dana/promoquest/handler/PromoQuestActionFactory;Lid/dana/promoquest/PromoQuestListener$QuestAction;Lid/dana/promoquest/adapter/MissionDetailQuestAdapter$RedeemQuestListener;Z)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class QuestViewHolder extends BaseRecyclerViewHolder<QuestModel> {

    /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
    public final ViewGroup PlaceComponentResult;

    /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
    public final int MyBillsEntityDataFactory;

    /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
    public final List<QuestModel> KClassImpl$Data$declaredNonStaticMembers$2;

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda0  reason: from kotlin metadata */
    private final QuestView scheduleImpl;

    /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
    private final PromoQuestActionFactory getAuthRequestContext;

    /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
    public final int moveToNextValue;

    /* renamed from: getErrorConfigVersion  reason: from kotlin metadata */
    private final PromoQuestListener.QuestAction lookAheadTest;

    /* renamed from: lookAheadTest  reason: from kotlin metadata */
    private final MissionDetailQuestAdapter.RedeemQuestListener NetworkUserEntityData$$ExternalSyntheticLambda0;

    /* renamed from: moveToNextValue  reason: from kotlin metadata */
    private final boolean BuiltInFictitiousFunctionClassFactory;

    @Override // id.dana.base.BaseRecyclerViewHolder
    public final /* synthetic */ void bindData(QuestModel questModel) {
        QuestModel questModel2 = questModel;
        if (questModel2 != null) {
            this.scheduleImpl.setActionFactory(this.getAuthRequestContext);
            this.scheduleImpl.setQuest(questModel2, getAdapterPosition() + 1, this.lookAheadTest);
            this.scheduleImpl.setRedeemQuestListener(this.NetworkUserEntityData$$ExternalSyntheticLambda0);
            this.scheduleImpl.setCardBehavior(BuiltInFictitiousFunctionClassFactory(), getAdapterPosition() + 1, this.MyBillsEntityDataFactory, this.BuiltInFictitiousFunctionClassFactory);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public QuestViewHolder(Context context, ViewGroup viewGroup, int i, List<QuestModel> list, PromoQuestActionFactory promoQuestActionFactory, PromoQuestListener.QuestAction questAction, MissionDetailQuestAdapter.RedeemQuestListener redeemQuestListener, boolean z) {
        super(context, R.layout.view_quest_mission_detail_holder, viewGroup);
        Intrinsics.checkNotNullParameter(context, "");
        Intrinsics.checkNotNullParameter(viewGroup, "");
        Intrinsics.checkNotNullParameter(list, "");
        Intrinsics.checkNotNullParameter(promoQuestActionFactory, "");
        Intrinsics.checkNotNullParameter(questAction, "");
        Intrinsics.checkNotNullParameter(redeemQuestListener, "");
        this.moveToNextValue = R.layout.view_quest_mission_detail_holder;
        this.PlaceComponentResult = viewGroup;
        this.MyBillsEntityDataFactory = i;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = list;
        this.getAuthRequestContext = promoQuestActionFactory;
        this.lookAheadTest = questAction;
        this.NetworkUserEntityData$$ExternalSyntheticLambda0 = redeemQuestListener;
        this.BuiltInFictitiousFunctionClassFactory = z;
        QuestView questView = (QuestView) this.itemView.findViewById(R.id.qv_quest_new);
        Intrinsics.checkNotNullExpressionValue(questView, "");
        this.scheduleImpl = questView;
    }

    private final boolean BuiltInFictitiousFunctionClassFactory() {
        return MyBillsEntityDataFactory() && KClassImpl$Data$declaredNonStaticMembers$2();
    }

    private final boolean KClassImpl$Data$declaredNonStaticMembers$2() {
        return Intrinsics.areEqual("COMPLETE", this.KClassImpl$Data$declaredNonStaticMembers$2.get(getAdapterPosition() + 1).NetworkUserEntityData$$ExternalSyntheticLambda0) || Intrinsics.areEqual("FINISH", this.KClassImpl$Data$declaredNonStaticMembers$2.get(getAdapterPosition() + 1).NetworkUserEntityData$$ExternalSyntheticLambda0);
    }

    private final boolean MyBillsEntityDataFactory() {
        return getAdapterPosition() + 1 < this.MyBillsEntityDataFactory && this.KClassImpl$Data$declaredNonStaticMembers$2.get(getAdapterPosition() + 1).NetworkUserEntityData$$ExternalSyntheticLambda0 != null;
    }
}
