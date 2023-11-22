package id.dana.social.contract.notification;

import id.dana.base.AbstractContractKt;
import id.dana.social.model.FeedViewHolderModel;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.JvmName;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001:\u0002\u0002\u0003ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001À\u0006\u0001"}, d2 = {"Lid/dana/social/contract/notification/FeedNotificationContract;", "", "Presenter", "View"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public interface FeedNotificationContract {

    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u000f\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0005\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0004J\u0017\u0010\b\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0006H&¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\b\u001a\u00020\u0002H&¢\u0006\u0004\b\b\u0010\u0004R\u0014\u0010\b\u001a\u00020\n8'X¦\u0006¢\u0006\u0006\u001a\u0004\b\u000b\u0010\fR\u001a\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u000e0\r8'X¦\u0006¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0010ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001À\u0006\u0001"}, d2 = {"Lid/dana/social/contract/notification/FeedNotificationContract$Presenter;", "Lid/dana/base/AbstractContractKt$AbstractPresenter;", "", "KClassImpl$Data$declaredNonStaticMembers$2", "()V", "getAuthRequestContext", "", "p0", "PlaceComponentResult", "(Ljava/lang/String;)V", "", "BuiltInFictitiousFunctionClassFactory", "()Z", "", "Lid/dana/social/model/FeedViewHolderModel;", "MyBillsEntityDataFactory", "()Ljava/util/List;"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public interface Presenter extends AbstractContractKt.AbstractPresenter {
        @JvmName(name = "BuiltInFictitiousFunctionClassFactory")
        boolean BuiltInFictitiousFunctionClassFactory();

        void KClassImpl$Data$declaredNonStaticMembers$2();

        @JvmName(name = "MyBillsEntityDataFactory")
        List<FeedViewHolderModel> MyBillsEntityDataFactory();

        void PlaceComponentResult();

        void PlaceComponentResult(String p0);

        void getAuthRequestContext();
    }

    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001J\u0013\u0010\u0004\u001a\u00060\u0002j\u0002`\u0003H&¢\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\u0006\u001a\u00020\u0002H&¢\u0006\u0004\b\u0006\u0010\u0005J-\u0010\u000e\u001a\u00020\r2\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\nH&¢\u0006\u0004\b\u000e\u0010\u000fJ\u000f\u0010\u000e\u001a\u00020\rH&¢\u0006\u0004\b\u000e\u0010\u0010J\u000f\u0010\u0011\u001a\u00020\rH&¢\u0006\u0004\b\u0011\u0010\u0010J%\u0010\u0004\u001a\u00020\r2\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\u0006\u0010\u000b\u001a\u00020\nH&¢\u0006\u0004\b\u0004\u0010\u0012ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001À\u0006\u0001"}, d2 = {"Lid/dana/social/contract/notification/FeedNotificationContract$View;", "Lid/dana/base/AbstractContractKt$AbstractView;", "", "Lid/dana/utils/DisplayedErrorMessage;", "BuiltInFictitiousFunctionClassFactory", "()Ljava/lang/String;", "KClassImpl$Data$declaredNonStaticMembers$2", "", "Lid/dana/social/model/FeedViewHolderModel;", "p0", "", "p1", "p2", "", "PlaceComponentResult", "(Ljava/util/List;ZZ)V", "()V", "MyBillsEntityDataFactory", "(Ljava/util/List;Z)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public interface View extends AbstractContractKt.AbstractView {
        String BuiltInFictitiousFunctionClassFactory();

        void BuiltInFictitiousFunctionClassFactory(List<FeedViewHolderModel> p0, boolean p1);

        String KClassImpl$Data$declaredNonStaticMembers$2();

        void MyBillsEntityDataFactory();

        void PlaceComponentResult();

        void PlaceComponentResult(List<FeedViewHolderModel> p0, boolean p1, boolean p2);
    }
}
