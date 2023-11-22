package id.dana.data.transferaccount;

import id.dana.data.transferaccount.source.network.DeletionChangeNumberResult;
import id.dana.data.transferaccount.source.network.TransferAccountQueryType;
import id.dana.data.transferaccount.source.network.TransferAccountStatusResult;
import io.reactivex.Observable;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u001d\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0006\u0010\u0007J%\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\bH&¢\u0006\u0004\b\u000b\u0010\fø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001À\u0006\u0001"}, d2 = {"Lid/dana/data/transferaccount/TransferAccountEntityData;", "", "", "p0", "Lio/reactivex/Observable;", "Lid/dana/data/transferaccount/source/network/DeletionChangeNumberResult;", "BuiltInFictitiousFunctionClassFactory", "(Ljava/lang/String;)Lio/reactivex/Observable;", "Lid/dana/data/transferaccount/source/network/TransferAccountQueryType;", "p1", "Lid/dana/data/transferaccount/source/network/TransferAccountStatusResult;", "KClassImpl$Data$declaredNonStaticMembers$2", "(Ljava/lang/String;Lid/dana/data/transferaccount/source/network/TransferAccountQueryType;)Lio/reactivex/Observable;"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public interface TransferAccountEntityData {
    Observable<DeletionChangeNumberResult> BuiltInFictitiousFunctionClassFactory(String p0);

    Observable<TransferAccountStatusResult> KClassImpl$Data$declaredNonStaticMembers$2(String p0, TransferAccountQueryType p1);
}
