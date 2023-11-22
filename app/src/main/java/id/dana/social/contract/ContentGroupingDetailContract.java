package id.dana.social.contract;

import id.dana.base.AbstractContractKt;
import id.dana.social.contract.BaseSocialFeedContract;
import id.dana.social.model.FeedViewHolderModel;
import java.util.List;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001:\u0002\u0002\u0003ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001À\u0006\u0001"}, d2 = {"Lid/dana/social/contract/ContentGroupingDetailContract;", "", "Presenter", "View"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public interface ContentGroupingDetailContract {

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u000f\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0006\u001a\u00020\u0005H&¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\t\u001a\u00020\bH&¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\u000b\u001a\u00020\bH&¢\u0006\u0004\b\u000b\u0010\nJ\u001d\u0010\u000b\u001a\u00020\u00022\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00050\fH&¢\u0006\u0004\b\u000b\u0010\u000eJ\u0017\u0010\u0006\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\bH&¢\u0006\u0004\b\u0006\u0010\u000fø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001À\u0006\u0001"}, d2 = {"Lid/dana/social/contract/ContentGroupingDetailContract$Presenter;", "Lid/dana/social/contract/BaseSocialFeedContract$Presenter;", "", "PlaceComponentResult", "()V", "", "KClassImpl$Data$declaredNonStaticMembers$2", "()Ljava/lang/String;", "", "getAuthRequestContext", "()Z", "MyBillsEntityDataFactory", "", "p0", "(Ljava/util/List;)V", "(Z)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public interface Presenter extends BaseSocialFeedContract.Presenter {
        String KClassImpl$Data$declaredNonStaticMembers$2();

        void KClassImpl$Data$declaredNonStaticMembers$2(boolean p0);

        void MyBillsEntityDataFactory(List<String> p0);

        boolean MyBillsEntityDataFactory();

        void PlaceComponentResult();

        boolean getAuthRequestContext();
    }

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u0013\u0010\u0004\u001a\u00060\u0002j\u0002`\u0003H&¢\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\u0007\u001a\u00020\u0006H&¢\u0006\u0004\b\u0007\u0010\bJ\u001d\u0010\f\u001a\u00020\u00062\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\tH&¢\u0006\u0004\b\f\u0010\rø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001À\u0006\u0001"}, d2 = {"Lid/dana/social/contract/ContentGroupingDetailContract$View;", "Lid/dana/base/AbstractContractKt$AbstractView;", "", "Lid/dana/utils/DisplayedErrorMessage;", "BuiltInFictitiousFunctionClassFactory", "()Ljava/lang/String;", "", "PlaceComponentResult", "()V", "", "Lid/dana/social/model/FeedViewHolderModel;", "p0", "MyBillsEntityDataFactory", "(Ljava/util/List;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public interface View extends AbstractContractKt.AbstractView {
        String BuiltInFictitiousFunctionClassFactory();

        void MyBillsEntityDataFactory(List<FeedViewHolderModel> p0);

        void PlaceComponentResult();
    }
}
