package id.dana.contract.deeplink.path;

import android.app.Activity;
import android.content.Intent;
import id.dana.analytics.tracker.TrackerKey;
import id.dana.domain.promoquest.interactor.GetMissionDetail;
import id.dana.promoquest.activity.MissionDetailActivity;
import id.dana.promoquest.activity.MissionListActivity;
import id.dana.promoquest.mapper.PromoQuestMapper;
import id.dana.promoquest.model.MissionModel;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0019\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0007\u0012\u0006\u0010\u000e\u001a\u00020\u000b¢\u0006\u0004\b\u000f\u0010\u0010J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\n\u001a\u00020\u00078\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\b\u0010\tR\u0014\u0010\r\u001a\u00020\u000b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\f"}, d2 = {"Lid/dana/contract/deeplink/path/FeaturePromoQuest;", "", "Landroid/app/Activity;", "p0", "", "MyBillsEntityDataFactory", "(Landroid/app/Activity;)V", "Lid/dana/domain/promoquest/interactor/GetMissionDetail;", "KClassImpl$Data$declaredNonStaticMembers$2", "Lid/dana/domain/promoquest/interactor/GetMissionDetail;", "BuiltInFictitiousFunctionClassFactory", "Lid/dana/promoquest/mapper/PromoQuestMapper;", "Lid/dana/promoquest/mapper/PromoQuestMapper;", "getAuthRequestContext", "p1", "<init>", "(Lid/dana/domain/promoquest/interactor/GetMissionDetail;Lid/dana/promoquest/mapper/PromoQuestMapper;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class FeaturePromoQuest {

    /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
    final GetMissionDetail BuiltInFictitiousFunctionClassFactory;

    /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
    private final PromoQuestMapper getAuthRequestContext;

    @Inject
    public FeaturePromoQuest(GetMissionDetail getMissionDetail, PromoQuestMapper promoQuestMapper) {
        Intrinsics.checkNotNullParameter(getMissionDetail, "");
        Intrinsics.checkNotNullParameter(promoQuestMapper, "");
        this.BuiltInFictitiousFunctionClassFactory = getMissionDetail;
        this.getAuthRequestContext = promoQuestMapper;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void MyBillsEntityDataFactory(Activity p0) {
        Intent intent = new Intent(p0, MissionListActivity.class);
        intent.putExtra("source", TrackerKey.SourceType.PROMO_QUEST_DEEPLINK);
        p0.startActivity(intent);
    }

    public static final /* synthetic */ void PlaceComponentResult(Activity activity, MissionModel missionModel) {
        MissionDetailActivity.Companion companion = MissionDetailActivity.INSTANCE;
        Intrinsics.checkNotNullParameter(activity, "");
        Intrinsics.checkNotNullParameter(missionModel, "");
        activity.startActivity(MissionDetailActivity.Companion.BuiltInFictitiousFunctionClassFactory(activity, missionModel));
    }

    public static final /* synthetic */ void PlaceComponentResult(Activity activity) {
        Intent intent = new Intent(activity, MissionListActivity.class);
        intent.putExtra("source", TrackerKey.SourceType.PROMO_QUEST_DEEPLINK);
        activity.startActivity(intent);
    }
}
