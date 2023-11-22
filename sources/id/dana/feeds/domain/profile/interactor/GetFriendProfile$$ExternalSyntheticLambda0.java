package id.dana.feeds.domain.profile.interactor;

import id.dana.domain.account.Account;
import io.reactivex.functions.Function;

/* loaded from: classes5.dex */
public final /* synthetic */ class GetFriendProfile$$ExternalSyntheticLambda0 implements Function {
    public final /* synthetic */ GetFriendProfile MyBillsEntityDataFactory;
    public final /* synthetic */ int getAuthRequestContext;

    public /* synthetic */ GetFriendProfile$$ExternalSyntheticLambda0(GetFriendProfile getFriendProfile, int i) {
        this.MyBillsEntityDataFactory = getFriendProfile;
        this.getAuthRequestContext = i;
    }

    @Override // io.reactivex.functions.Function
    public final Object apply(Object obj) {
        return GetFriendProfile.PlaceComponentResult(this.MyBillsEntityDataFactory, this.getAuthRequestContext, (Account) obj);
    }
}
