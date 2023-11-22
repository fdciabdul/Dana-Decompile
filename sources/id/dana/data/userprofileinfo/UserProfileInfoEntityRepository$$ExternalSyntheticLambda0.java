package id.dana.data.userprofileinfo;

import id.dana.data.userprofileinfo.mapper.UserProfileInfoMapper;
import id.dana.data.userprofileinfo.source.network.result.UserProfileInfoResult;
import io.reactivex.functions.Function;

/* loaded from: classes4.dex */
public final /* synthetic */ class UserProfileInfoEntityRepository$$ExternalSyntheticLambda0 implements Function {
    public final /* synthetic */ UserProfileInfoMapper f$0;

    @Override // io.reactivex.functions.Function
    public final Object apply(Object obj) {
        return this.f$0.transform((UserProfileInfoResult) obj);
    }
}
