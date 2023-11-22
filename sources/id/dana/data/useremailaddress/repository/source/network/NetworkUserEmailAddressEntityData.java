package id.dana.data.useremailaddress.repository.source.network;

import id.dana.data.useremailaddress.UserEmailAddressEntityData;
import id.dana.data.useremailaddress.repository.source.network.result.UserEmailAddressEntityResult;
import id.dana.network.base.ExceptionParserAphome;
import id.dana.network.base.ResultResponse;
import io.reactivex.Observable;
import io.reactivex.functions.Function;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* loaded from: classes2.dex */
public class NetworkUserEmailAddressEntityData implements UserEmailAddressEntityData {
    private final UserEmailAddressApi userEmailAddressApi;

    @Inject
    public NetworkUserEmailAddressEntityData(UserEmailAddressApi userEmailAddressApi) {
        this.userEmailAddressApi = userEmailAddressApi;
    }

    @Override // id.dana.data.useremailaddress.UserEmailAddressEntityData
    public Observable<UserEmailAddressEntityResult> getEmailAddress(String str) {
        return this.userEmailAddressApi.getEmailAddress(str).map(new Function() { // from class: id.dana.data.useremailaddress.repository.source.network.NetworkUserEmailAddressEntityData$$ExternalSyntheticLambda0
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                return (UserEmailAddressEntityResult) ((ResultResponse) obj).getResult();
            }
        }).flatMap(new ExceptionParserAphome());
    }
}
