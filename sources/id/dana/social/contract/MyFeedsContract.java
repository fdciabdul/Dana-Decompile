package id.dana.social.contract;

import id.dana.social.contract.BaseSocialFeedContract;
import id.dana.social.model.FeedViewHolderModel;
import id.dana.social.model.MyFeedHighlightModel;
import java.util.List;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001:\u0002\u0002\u0003ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001À\u0006\u0001"}, d2 = {"Lid/dana/social/contract/MyFeedsContract;", "", "Presenter", "View"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public interface MyFeedsContract {

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u000f\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0003\u0010\u0004J\u0017\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005H&¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\u0007\u001a\u00020\u0002H&¢\u0006\u0004\b\u0007\u0010\u0004J\u0017\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\tH&¢\u0006\u0004\b\u0007\u0010\nJ\u000f\u0010\u000b\u001a\u00020\u0002H&¢\u0006\u0004\b\u000b\u0010\u0004ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001À\u0006\u0001"}, d2 = {"Lid/dana/social/contract/MyFeedsContract$Presenter;", "Lid/dana/social/contract/BaseSocialFeedContract$Presenter;", "", "getAuthRequestContext", "()V", "", "p0", "MyBillsEntityDataFactory", "(Ljava/lang/String;)V", "Lid/dana/social/model/FeedViewHolderModel;", "(Lid/dana/social/model/FeedViewHolderModel;)V", "KClassImpl$Data$declaredNonStaticMembers$2"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public interface Presenter extends BaseSocialFeedContract.Presenter {
        void KClassImpl$Data$declaredNonStaticMembers$2();

        void MyBillsEntityDataFactory();

        void MyBillsEntityDataFactory(FeedViewHolderModel p0);

        void MyBillsEntityDataFactory(String p0);

        void getAuthRequestContext();
    }

    @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u0013\u0010\u0004\u001a\u00060\u0002j\u0002`\u0003H&¢\u0006\u0004\b\u0004\u0010\u0005J\u0017\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H&¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\u000b\u001a\u00020\bH&¢\u0006\u0004\b\u000b\u0010\fJ\u001f\u0010\t\u001a\u00020\b2\u000e\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\rH&¢\u0006\u0004\b\t\u0010\u000fJ\u0017\u0010\u000b\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0010H&¢\u0006\u0004\b\u000b\u0010\u0011J\u0017\u0010\u0012\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u000eH&¢\u0006\u0004\b\u0012\u0010\u0013ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001À\u0006\u0001"}, d2 = {"Lid/dana/social/contract/MyFeedsContract$View;", "", "", "Lid/dana/utils/DisplayedErrorMessage;", "BuiltInFictitiousFunctionClassFactory", "()Ljava/lang/String;", "", "p0", "", "MyBillsEntityDataFactory", "(Z)V", "PlaceComponentResult", "()V", "", "Lid/dana/social/model/FeedViewHolderModel;", "(Ljava/util/List;)V", "Lid/dana/social/model/MyFeedHighlightModel;", "(Lid/dana/social/model/MyFeedHighlightModel;)V", "KClassImpl$Data$declaredNonStaticMembers$2", "(Lid/dana/social/model/FeedViewHolderModel;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public interface View {
        String BuiltInFictitiousFunctionClassFactory();

        void KClassImpl$Data$declaredNonStaticMembers$2(FeedViewHolderModel p0);

        void MyBillsEntityDataFactory(List<FeedViewHolderModel> p0);

        void MyBillsEntityDataFactory(boolean p0);

        void PlaceComponentResult();

        void PlaceComponentResult(MyFeedHighlightModel p0);
    }
}
