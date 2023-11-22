package id.dana.social.contract;

import id.dana.base.AbstractContract;
import id.dana.domain.social.ModifyRelationOperationType;
import id.dana.feeds.ui.model.RelationshipItemModel;
import io.reactivex.subjects.PublishSubject;
import java.util.List;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001:\u0002\u0002\u0003ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001À\u0006\u0001"}, d2 = {"Lid/dana/social/contract/FriendshipContract;", "", "Presenter", "View"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public interface FriendshipContract {

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001J\u001d\u0010\u0006\u001a\u00020\u00052\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H&¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\b\u001a\u00020\u0005H&¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\u0006\u001a\u00020\u0005H&¢\u0006\u0004\b\u0006\u0010\tJ\u001f\u0010\f\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\nH&¢\u0006\u0004\b\f\u0010\rJ\u001f\u0010\u000e\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\nH&¢\u0006\u0004\b\u000e\u0010\rJ\u000f\u0010\u000f\u001a\u00020\u0005H&¢\u0006\u0004\b\u000f\u0010\tJ\u000f\u0010\f\u001a\u00020\u0005H&¢\u0006\u0004\b\f\u0010\tø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001À\u0006\u0001"}, d2 = {"Lid/dana/social/contract/FriendshipContract$Presenter;", "Lid/dana/base/AbstractContract$AbstractPresenter;", "Lio/reactivex/subjects/PublishSubject;", "", "p0", "", "BuiltInFictitiousFunctionClassFactory", "(Lio/reactivex/subjects/PublishSubject;)V", "PlaceComponentResult", "()V", "Lid/dana/domain/social/ModifyRelationOperationType;", "p1", "getAuthRequestContext", "(Ljava/lang/String;Lid/dana/domain/social/ModifyRelationOperationType;)V", "MyBillsEntityDataFactory", "KClassImpl$Data$declaredNonStaticMembers$2"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public interface Presenter extends AbstractContract.AbstractPresenter {
        void BuiltInFictitiousFunctionClassFactory();

        void BuiltInFictitiousFunctionClassFactory(PublishSubject<String> p0);

        void KClassImpl$Data$declaredNonStaticMembers$2();

        void MyBillsEntityDataFactory(String p0, ModifyRelationOperationType p1);

        void PlaceComponentResult();

        void getAuthRequestContext();

        void getAuthRequestContext(String p0, ModifyRelationOperationType p1);
    }

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u001d\u0010\u0006\u001a\u00020\u00052\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H&¢\u0006\u0004\b\u0006\u0010\u0007J\u001d\u0010\b\u001a\u00020\u00052\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H&¢\u0006\u0004\b\b\u0010\u0007ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001À\u0006\u0001"}, d2 = {"Lid/dana/social/contract/FriendshipContract$View;", "Lid/dana/base/AbstractContract$AbstractView;", "", "Lid/dana/feeds/ui/model/RelationshipItemModel;", "p0", "", "MyBillsEntityDataFactory", "(Ljava/util/List;)V", "KClassImpl$Data$declaredNonStaticMembers$2"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public interface View extends AbstractContract.AbstractView {
        void KClassImpl$Data$declaredNonStaticMembers$2(List<RelationshipItemModel> p0);

        void MyBillsEntityDataFactory(List<RelationshipItemModel> p0);
    }
}
