package id.dana.data.usercredential.mapper;

import id.dana.data.usercredential.model.QueryCredentialInfoResult;
import id.dana.domain.usercredential.model.QueryCredentialInfoModel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0019\u0010\u0004\u001a\u00020\u0003*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Lid/dana/data/usercredential/model/QueryCredentialInfoResult;", "", "p0", "Lid/dana/domain/usercredential/model/QueryCredentialInfoModel;", "BuiltInFictitiousFunctionClassFactory", "(Lid/dana/data/usercredential/model/QueryCredentialInfoResult;I)Lid/dana/domain/usercredential/model/QueryCredentialInfoModel;"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class QueryCredentialInfoMapperKt {
    public static final QueryCredentialInfoModel BuiltInFictitiousFunctionClassFactory(QueryCredentialInfoResult queryCredentialInfoResult, int i) {
        Intrinsics.checkNotNullParameter(queryCredentialInfoResult, "");
        return new QueryCredentialInfoModel(queryCredentialInfoResult.getPasswordLastModifiedInEpoch(), queryCredentialInfoResult.getPasswordLastModifiedCheck(), i);
    }
}
