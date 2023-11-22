package id.dana.social.contract;

import id.dana.base.AbstractContractKt;
import id.dana.domain.social.model.FeedConfig;
import id.dana.feeds.ui.model.ActivityReactionsUserModel;
import id.dana.feeds.ui.model.AddActivityCommentModel;
import id.dana.feeds.ui.model.FeedCommentModel;
import id.dana.social.model.FeedCommentResultModel;
import id.dana.social.model.FeedViewHolderModel;
import id.dana.social.view.activity.detail.SocialActivityDetail;
import java.util.List;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001:\u0002\u0002\u0003ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001À\u0006\u0001"}, d2 = {"Lid/dana/social/contract/FeedCommentContract;", "", "Presenter", "View"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public interface FeedCommentContract {

    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u000f\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0003\u0010\u0004J\u0017\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005H&¢\u0006\u0004\b\u0007\u0010\bJ\u001d\u0010\u0003\u001a\u00020\u00022\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\tH&¢\u0006\u0004\b\u0003\u0010\nJ\u000f\u0010\u0007\u001a\u00020\u0005H&¢\u0006\u0004\b\u0007\u0010\u000bJ\u0017\u0010\f\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005H&¢\u0006\u0004\b\f\u0010\bJ\u000f\u0010\f\u001a\u00020\u0002H&¢\u0006\u0004\b\f\u0010\u0004J\u001f\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\u0005H&¢\u0006\u0004\b\u0003\u0010\u000eJ\u000f\u0010\u000f\u001a\u00020\u0002H&¢\u0006\u0004\b\u000f\u0010\u0004J\u000f\u0010\u0011\u001a\u00020\u0010H&¢\u0006\u0004\b\u0011\u0010\u0012J\u0017\u0010\u000f\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005H&¢\u0006\u0004\b\u000f\u0010\bJ\u001f\u0010\u000f\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00132\u0006\u0010\r\u001a\u00020\u0005H&¢\u0006\u0004\b\u000f\u0010\u0014J'\u0010\u0011\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\u00052\u0006\u0010\u0015\u001a\u00020\u0005H&¢\u0006\u0004\b\u0011\u0010\u0016ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001À\u0006\u0001"}, d2 = {"Lid/dana/social/contract/FeedCommentContract$Presenter;", "Lid/dana/base/AbstractContractKt$AbstractPresenter;", "", "getAuthRequestContext", "()V", "", "p0", "KClassImpl$Data$declaredNonStaticMembers$2", "(Ljava/lang/String;)V", "", "(Ljava/util/List;)V", "()Ljava/lang/String;", "MyBillsEntityDataFactory", "p1", "(Ljava/lang/String;Ljava/lang/String;)V", "BuiltInFictitiousFunctionClassFactory", "", "PlaceComponentResult", "()Z", "Lid/dana/feeds/ui/model/FeedCommentModel;", "(Lid/dana/feeds/ui/model/FeedCommentModel;Ljava/lang/String;)V", "p2", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public interface Presenter extends AbstractContractKt.AbstractPresenter {
        void BuiltInFictitiousFunctionClassFactory();

        void BuiltInFictitiousFunctionClassFactory(FeedCommentModel p0, String p1);

        void BuiltInFictitiousFunctionClassFactory(String p0);

        String KClassImpl$Data$declaredNonStaticMembers$2();

        void KClassImpl$Data$declaredNonStaticMembers$2(String p0);

        void MyBillsEntityDataFactory();

        void MyBillsEntityDataFactory(String p0);

        void PlaceComponentResult(String p0, String p1, String p2);

        boolean PlaceComponentResult();

        void getAuthRequestContext();

        void getAuthRequestContext(String p0, String p1);

        void getAuthRequestContext(List<String> p0);
    }

    @Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u001b\u0010\u0006\u001a\u00060\u0004j\u0002`\u00052\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0006\u0010\u0007J\u001b\u0010\t\u001a\u00060\u0004j\u0002`\u00052\u0006\u0010\u0003\u001a\u00020\bH&¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\u000b\u001a\u00020\u0004H&¢\u0006\u0004\b\u000b\u0010\fJ\u001f\u0010\u000b\u001a\u00020\u000f2\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\rH&¢\u0006\u0004\b\u000b\u0010\u0010J\u0017\u0010\t\u001a\u00020\u000f2\u0006\u0010\u0003\u001a\u00020\u0011H&¢\u0006\u0004\b\t\u0010\u0012J\u0017\u0010\u0013\u001a\u00020\u000f2\u0006\u0010\u0003\u001a\u00020\u0011H&¢\u0006\u0004\b\u0013\u0010\u0012J\u000f\u0010\t\u001a\u00020\u000fH&¢\u0006\u0004\b\t\u0010\u0014J\u000f\u0010\u0015\u001a\u00020\u000fH&¢\u0006\u0004\b\u0015\u0010\u0014J\u0017\u0010\u0006\u001a\u00020\u000f2\u0006\u0010\u0003\u001a\u00020\u0016H&¢\u0006\u0004\b\u0006\u0010\u0017J\u000f\u0010\u0006\u001a\u00020\u000fH&¢\u0006\u0004\b\u0006\u0010\u0014J\u0017\u0010\t\u001a\u00020\u000f2\u0006\u0010\u0003\u001a\u00020\u0018H&¢\u0006\u0004\b\t\u0010\u0019J\u0017\u0010\u000b\u001a\u00020\u000f2\u0006\u0010\u0003\u001a\u00020\u001aH&¢\u0006\u0004\b\u000b\u0010\u001bJ\u0017\u0010\u0013\u001a\u00020\u000f2\u0006\u0010\u0003\u001a\u00020\u001cH&¢\u0006\u0004\b\u0013\u0010\u001dJ%\u0010\u0006\u001a\u00020\u000f2\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00160\u001e2\u0006\u0010\u000e\u001a\u00020\rH&¢\u0006\u0004\b\u0006\u0010\u001fJ\u0017\u0010\u000b\u001a\u00020\u000f2\u0006\u0010\u0003\u001a\u00020 H&¢\u0006\u0004\b\u000b\u0010!J\u000f\u0010\u0013\u001a\u00020\u000fH&¢\u0006\u0004\b\u0013\u0010\u0014J\u000f\u0010\"\u001a\u00020\u000fH&¢\u0006\u0004\b\"\u0010\u0014J\u001f\u0010\u0013\u001a\u00020\u000f2\u0006\u0010\u0003\u001a\u00020\u00162\u0006\u0010\u000e\u001a\u00020#H&¢\u0006\u0004\b\u0013\u0010$ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001À\u0006\u0001"}, d2 = {"Lid/dana/social/contract/FeedCommentContract$View;", "Lid/dana/base/AbstractContractKt$AbstractView;", "", "p0", "", "Lid/dana/utils/DisplayedErrorMessage;", "BuiltInFictitiousFunctionClassFactory", "(Z)Ljava/lang/String;", "Lid/dana/social/view/activity/detail/SocialActivityDetail$ActivityDetailErrorType;", "KClassImpl$Data$declaredNonStaticMembers$2", "(Lid/dana/social/view/activity/detail/SocialActivityDetail$ActivityDetailErrorType;)Ljava/lang/String;", "MyBillsEntityDataFactory", "()Ljava/lang/String;", "", "p1", "", "(Ljava/lang/String;I)V", "", "(Ljava/lang/Throwable;)V", "PlaceComponentResult", "()V", "getAuthRequestContext", "Lid/dana/feeds/ui/model/FeedCommentModel;", "(Lid/dana/feeds/ui/model/FeedCommentModel;)V", "Lid/dana/social/model/FeedViewHolderModel;", "(Lid/dana/social/model/FeedViewHolderModel;)V", "Lid/dana/social/model/FeedCommentResultModel;", "(Lid/dana/social/model/FeedCommentResultModel;)V", "Lid/dana/domain/social/model/FeedConfig;", "(Lid/dana/domain/social/model/FeedConfig;)V", "", "(Ljava/util/List;I)V", "Lid/dana/feeds/ui/model/ActivityReactionsUserModel;", "(Lid/dana/feeds/ui/model/ActivityReactionsUserModel;)V", "NetworkUserEntityData$$ExternalSyntheticLambda0", "Lid/dana/feeds/ui/model/AddActivityCommentModel;", "(Lid/dana/feeds/ui/model/FeedCommentModel;Lid/dana/feeds/ui/model/AddActivityCommentModel;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public interface View extends AbstractContractKt.AbstractView {
        String BuiltInFictitiousFunctionClassFactory(boolean p0);

        void BuiltInFictitiousFunctionClassFactory();

        void BuiltInFictitiousFunctionClassFactory(FeedCommentModel p0);

        void BuiltInFictitiousFunctionClassFactory(List<FeedCommentModel> p0, int p1);

        String KClassImpl$Data$declaredNonStaticMembers$2(SocialActivityDetail.ActivityDetailErrorType p0);

        void KClassImpl$Data$declaredNonStaticMembers$2();

        void KClassImpl$Data$declaredNonStaticMembers$2(FeedViewHolderModel p0);

        void KClassImpl$Data$declaredNonStaticMembers$2(Throwable p0);

        String MyBillsEntityDataFactory();

        void MyBillsEntityDataFactory(ActivityReactionsUserModel p0);

        void MyBillsEntityDataFactory(FeedCommentResultModel p0);

        void MyBillsEntityDataFactory(String p0, int p1);

        void NetworkUserEntityData$$ExternalSyntheticLambda0();

        void PlaceComponentResult();

        void PlaceComponentResult(FeedConfig p0);

        void PlaceComponentResult(FeedCommentModel p0, AddActivityCommentModel p1);

        void PlaceComponentResult(Throwable p0);

        void getAuthRequestContext();
    }
}
