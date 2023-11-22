package id.dana.data.useremailaddress;

import id.dana.data.useremailaddress.repository.source.network.result.UserEmailAddressEntityResult;
import io.reactivex.Observable;

/* loaded from: classes2.dex */
public interface UserEmailAddressEntityData {
    Observable<UserEmailAddressEntityResult> getEmailAddress(String str);
}
