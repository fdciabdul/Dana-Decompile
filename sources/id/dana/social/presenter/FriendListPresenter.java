package id.dana.social.presenter;

import com.alipay.mobile.common.rpc.RpcException;
import id.dana.feeds.domain.friend.interactor.AddFriend;
import id.dana.feeds.domain.friend.interactor.CancelAddFriend;
import id.dana.feeds.domain.friend.interactor.FindFriends;
import id.dana.feeds.domain.friend.model.Friend;
import id.dana.feeds.ui.model.FriendModel;
import id.dana.network.exception.NetworkException;
import id.dana.social.contract.FriendListContract;
import java.util.List;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B)\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0015\u0012\u0006\u0010\t\u001a\u00020\u0013\u0012\u0006\u0010\u0017\u001a\u00020\r\u0012\u0006\u0010\u0018\u001a\u00020\u0010¢\u0006\u0004\b\u0019\u0010\u001aJ\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0007\u0010\u0006J\u001f\u0010\n\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\bH\u0016¢\u0006\u0004\b\n\u0010\u0006J\u000f\u0010\u000b\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u000b\u0010\fR\u0014\u0010\u000f\u001a\u00020\r8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\u000eR\u0014\u0010\u0011\u001a\u00020\u00108\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0007\u001a\u00020\u00138\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\u0014R\u0014\u0010\n\u001a\u00020\u00158\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\n\u0010\u0016"}, d2 = {"Lid/dana/social/presenter/FriendListPresenter;", "Lid/dana/social/contract/FriendListContract$Presenter;", "", "p0", "", "MyBillsEntityDataFactory", "(Ljava/lang/String;)V", "KClassImpl$Data$declaredNonStaticMembers$2", "", "p1", "BuiltInFictitiousFunctionClassFactory", "onDestroy", "()V", "Lid/dana/feeds/domain/friend/interactor/AddFriend;", "Lid/dana/feeds/domain/friend/interactor/AddFriend;", "PlaceComponentResult", "Lid/dana/feeds/domain/friend/interactor/CancelAddFriend;", "getAuthRequestContext", "Lid/dana/feeds/domain/friend/interactor/CancelAddFriend;", "Lid/dana/feeds/domain/friend/interactor/FindFriends;", "Lid/dana/feeds/domain/friend/interactor/FindFriends;", "Lid/dana/social/contract/FriendListContract$View;", "Lid/dana/social/contract/FriendListContract$View;", "p2", "p3", "<init>", "(Lid/dana/social/contract/FriendListContract$View;Lid/dana/feeds/domain/friend/interactor/FindFriends;Lid/dana/feeds/domain/friend/interactor/AddFriend;Lid/dana/feeds/domain/friend/interactor/CancelAddFriend;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class FriendListPresenter implements FriendListContract.Presenter {
    private final FriendListContract.View BuiltInFictitiousFunctionClassFactory;
    private final FindFriends KClassImpl$Data$declaredNonStaticMembers$2;

    /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
    private final AddFriend PlaceComponentResult;
    private final CancelAddFriend getAuthRequestContext;

    @Inject
    public FriendListPresenter(FriendListContract.View view, FindFriends findFriends, AddFriend addFriend, CancelAddFriend cancelAddFriend) {
        Intrinsics.checkNotNullParameter(view, "");
        Intrinsics.checkNotNullParameter(findFriends, "");
        Intrinsics.checkNotNullParameter(addFriend, "");
        Intrinsics.checkNotNullParameter(cancelAddFriend, "");
        this.BuiltInFictitiousFunctionClassFactory = view;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = findFriends;
        this.PlaceComponentResult = addFriend;
        this.getAuthRequestContext = cancelAddFriend;
    }

    @Override // id.dana.social.contract.FriendListContract.Presenter
    public final void BuiltInFictitiousFunctionClassFactory(final String str) {
        Intrinsics.checkNotNullParameter(str, "");
        this.KClassImpl$Data$declaredNonStaticMembers$2.executeJava1(new FindFriends.Params(str, false), new Function1<List<? extends Friend>, Unit>() { // from class: id.dana.social.presenter.FriendListPresenter$findFriend$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final /* bridge */ /* synthetic */ Unit invoke(List<? extends Friend> list) {
                invoke2((List<Friend>) list);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(List<Friend> list) {
                FriendListContract.View view;
                FriendListContract.View view2;
                Intrinsics.checkNotNullParameter(list, "");
                if (list.isEmpty()) {
                    view2 = FriendListPresenter.this.BuiltInFictitiousFunctionClassFactory;
                    view2.KClassImpl$Data$declaredNonStaticMembers$2(str);
                    return;
                }
                view = FriendListPresenter.this.BuiltInFictitiousFunctionClassFactory;
                FriendModel.Companion companion = FriendModel.INSTANCE;
                view.getAuthRequestContext(FriendModel.Companion.BuiltInFictitiousFunctionClassFactory((Friend) CollectionsKt.first((List) list)));
            }
        }, new Function1<Throwable, String>() { // from class: id.dana.social.presenter.FriendListPresenter$findFriend$2
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final String invoke(Throwable th) {
                FriendListContract.View view;
                FriendListContract.View view2;
                Intrinsics.checkNotNullParameter(th, "");
                if ((th instanceof NetworkException) || (th instanceof RpcException)) {
                    view = FriendListPresenter.this.BuiltInFictitiousFunctionClassFactory;
                    return view.KClassImpl$Data$declaredNonStaticMembers$2();
                }
                view2 = FriendListPresenter.this.BuiltInFictitiousFunctionClassFactory;
                return view2.KClassImpl$Data$declaredNonStaticMembers$2(str);
            }
        }, this.BuiltInFictitiousFunctionClassFactory.getErrorSource());
    }

    @Override // id.dana.social.contract.FriendListContract.Presenter
    public final void MyBillsEntityDataFactory(final String p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        this.PlaceComponentResult.executeJava1(p0, new Function1<Boolean, Unit>() { // from class: id.dana.social.presenter.FriendListPresenter$addFriend$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final /* synthetic */ Unit invoke(Boolean bool) {
                invoke(bool.booleanValue());
                return Unit.INSTANCE;
            }

            public final void invoke(boolean z) {
                FriendListContract.View view;
                FriendListContract.View view2;
                if (z) {
                    view2 = FriendListPresenter.this.BuiltInFictitiousFunctionClassFactory;
                    view2.MyBillsEntityDataFactory(p0);
                    return;
                }
                view = FriendListPresenter.this.BuiltInFictitiousFunctionClassFactory;
                view.BuiltInFictitiousFunctionClassFactory(p0);
            }
        }, new Function1<Throwable, String>() { // from class: id.dana.social.presenter.FriendListPresenter$addFriend$2
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final String invoke(Throwable th) {
                FriendListContract.View view;
                FriendListContract.View view2;
                Intrinsics.checkNotNullParameter(th, "");
                view = FriendListPresenter.this.BuiltInFictitiousFunctionClassFactory;
                view.BuiltInFictitiousFunctionClassFactory(p0);
                view2 = FriendListPresenter.this.BuiltInFictitiousFunctionClassFactory;
                return view2.getAuthRequestContext();
            }
        }, this.BuiltInFictitiousFunctionClassFactory.getErrorSource());
    }

    @Override // id.dana.social.contract.FriendListContract.Presenter
    public final void KClassImpl$Data$declaredNonStaticMembers$2(final String p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        this.getAuthRequestContext.executeJava1(new CancelAddFriend.Params(p0), new Function1<Boolean, Unit>() { // from class: id.dana.social.presenter.FriendListPresenter$cancelFriend$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final /* synthetic */ Unit invoke(Boolean bool) {
                invoke(bool.booleanValue());
                return Unit.INSTANCE;
            }

            public final void invoke(boolean z) {
                FriendListContract.View view;
                FriendListContract.View view2;
                if (z) {
                    view2 = FriendListPresenter.this.BuiltInFictitiousFunctionClassFactory;
                    view2.getAuthRequestContext(p0);
                    return;
                }
                view = FriendListPresenter.this.BuiltInFictitiousFunctionClassFactory;
                view.PlaceComponentResult(p0);
            }
        }, new Function1<Throwable, String>() { // from class: id.dana.social.presenter.FriendListPresenter$cancelFriend$2
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final String invoke(Throwable th) {
                FriendListContract.View view;
                FriendListContract.View view2;
                Intrinsics.checkNotNullParameter(th, "");
                view = FriendListPresenter.this.BuiltInFictitiousFunctionClassFactory;
                view.PlaceComponentResult(p0);
                view2 = FriendListPresenter.this.BuiltInFictitiousFunctionClassFactory;
                return view2.getAuthRequestContext();
            }
        }, this.BuiltInFictitiousFunctionClassFactory.getErrorSource());
    }

    @Override // id.dana.base.AbstractContractKt.AbstractPresenter, id.dana.base.AbstractContract.AbstractPresenter
    public final void onDestroy() {
        this.KClassImpl$Data$declaredNonStaticMembers$2.dispose();
        this.PlaceComponentResult.dispose();
        this.getAuthRequestContext.dispose();
    }
}
