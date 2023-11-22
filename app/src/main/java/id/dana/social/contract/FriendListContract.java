package id.dana.social.contract;

import id.dana.base.AbstractContractKt;
import id.dana.feeds.ui.model.FriendModel;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001:\u0002\u0002\u0003ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001À\u0006\u0001"}, d2 = {"Lid/dana/social/contract/FriendListContract;", "", "Presenter", "View"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public interface FriendListContract {

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0007\u0010\u0006J\u001f\u0010\n\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\bH&¢\u0006\u0004\b\n\u0010\u0006ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001À\u0006\u0001"}, d2 = {"Lid/dana/social/contract/FriendListContract$Presenter;", "Lid/dana/base/AbstractContractKt$AbstractPresenter;", "", "p0", "", "MyBillsEntityDataFactory", "(Ljava/lang/String;)V", "KClassImpl$Data$declaredNonStaticMembers$2", "", "p1", "BuiltInFictitiousFunctionClassFactory"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public interface Presenter extends AbstractContractKt.AbstractPresenter {
        void BuiltInFictitiousFunctionClassFactory(String str);

        void KClassImpl$Data$declaredNonStaticMembers$2(String p0);

        void MyBillsEntityDataFactory(String p0);
    }

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0013\u0010\u0004\u001a\u00060\u0002j\u0002`\u0003H&¢\u0006\u0004\b\u0004\u0010\u0005J\u0017\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0002H&¢\u0006\u0004\b\b\u0010\tJ\u0017\u0010\n\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0002H&¢\u0006\u0004\b\n\u0010\tJ\u0017\u0010\u000b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0002H&¢\u0006\u0004\b\u000b\u0010\tJ\u0017\u0010\u0004\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0002H&¢\u0006\u0004\b\u0004\u0010\tJ\u0017\u0010\f\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0002H&¢\u0006\u0004\b\f\u0010\rJ\u000f\u0010\f\u001a\u00020\u0002H&¢\u0006\u0004\b\f\u0010\u0005J\u0017\u0010\u0004\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u000eH&¢\u0006\u0004\b\u0004\u0010\u000fø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001À\u0006\u0001"}, d2 = {"Lid/dana/social/contract/FriendListContract$View;", "Lid/dana/base/AbstractContractKt$AbstractView;", "", "Lid/dana/utils/DisplayedErrorMessage;", "getAuthRequestContext", "()Ljava/lang/String;", "p0", "", "BuiltInFictitiousFunctionClassFactory", "(Ljava/lang/String;)V", "MyBillsEntityDataFactory", "PlaceComponentResult", "KClassImpl$Data$declaredNonStaticMembers$2", "(Ljava/lang/String;)Ljava/lang/String;", "Lid/dana/feeds/ui/model/FriendModel;", "(Lid/dana/feeds/ui/model/FriendModel;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public interface View extends AbstractContractKt.AbstractView {
        void BuiltInFictitiousFunctionClassFactory(String p0);

        String KClassImpl$Data$declaredNonStaticMembers$2();

        String KClassImpl$Data$declaredNonStaticMembers$2(String p0);

        void MyBillsEntityDataFactory(String p0);

        void PlaceComponentResult(String p0);

        String getAuthRequestContext();

        void getAuthRequestContext(FriendModel p0);

        void getAuthRequestContext(String p0);
    }
}
