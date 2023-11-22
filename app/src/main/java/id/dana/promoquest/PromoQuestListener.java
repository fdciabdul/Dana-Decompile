package id.dana.promoquest;

import kotlin.Metadata;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001:\u0004\u0002\u0003\u0004\u0005ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001À\u0006\u0001"}, d2 = {"Lid/dana/promoquest/PromoQuestListener;", "", "QuestAction", "RedeemMissionResultListener", "RedeemQuestResult", "TrackQuestResultListener"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public interface PromoQuestListener {

    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J)\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H&¢\u0006\u0004\b\t\u0010\nJ)\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u000b2\b\u0010\u0007\u001a\u0004\u0018\u00010\fH&¢\u0006\u0004\b\t\u0010\rø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001À\u0006\u0001"}, d2 = {"Lid/dana/promoquest/PromoQuestListener$QuestAction;", "", "", "p0", "", "p1", "Lid/dana/promoquest/PromoQuestListener$RedeemQuestResult;", "p2", "", "KClassImpl$Data$declaredNonStaticMembers$2", "(Ljava/lang/String;ILid/dana/promoquest/PromoQuestListener$RedeemQuestResult;)V", "", "Lid/dana/promoquest/PromoQuestListener$TrackQuestResultListener;", "(Ljava/lang/String;ZLid/dana/promoquest/PromoQuestListener$TrackQuestResultListener;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public interface QuestAction {
        void KClassImpl$Data$declaredNonStaticMembers$2(String p0, int p1, RedeemQuestResult p2);

        void KClassImpl$Data$declaredNonStaticMembers$2(String p0, boolean p1, TrackQuestResultListener p2);
    }

    @Metadata(d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\u0010\u0000\bf\u0018\u00002\u00020\u0001ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001À\u0006\u0001"}, d2 = {"Lid/dana/promoquest/PromoQuestListener$RedeemMissionResultListener;", ""}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public interface RedeemMissionResultListener {
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u000f\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0005\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0004ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001À\u0006\u0001"}, d2 = {"Lid/dana/promoquest/PromoQuestListener$RedeemQuestResult;", "", "", "MyBillsEntityDataFactory", "()V", "KClassImpl$Data$declaredNonStaticMembers$2"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public interface RedeemQuestResult {
        void KClassImpl$Data$declaredNonStaticMembers$2();

        void MyBillsEntityDataFactory();
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\u000f\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0003\u0010\u0004J\u0019\u0010\u0007\u001a\u00020\u00022\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H&¢\u0006\u0004\b\u0007\u0010\u0004J\u000f\u0010\b\u001a\u00020\u0002H&¢\u0006\u0004\b\b\u0010\u0004J\u000f\u0010\t\u001a\u00020\u0002H&¢\u0006\u0004\b\t\u0010\u0004ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001À\u0006\u0001"}, d2 = {"Lid/dana/promoquest/PromoQuestListener$TrackQuestResultListener;", "", "", "MyBillsEntityDataFactory", "()V", "", "p0", "KClassImpl$Data$declaredNonStaticMembers$2", "getAuthRequestContext", "PlaceComponentResult"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public interface TrackQuestResultListener {
        void KClassImpl$Data$declaredNonStaticMembers$2();

        void MyBillsEntityDataFactory();

        void PlaceComponentResult();

        void getAuthRequestContext();
    }
}
