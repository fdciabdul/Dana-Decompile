package id.dana.data.investment.repository.source;

import id.dana.data.investment.repository.source.network.response.AccountInvestmentResult;
import id.dana.data.investment.repository.source.split.response.DanaPlusMethodConfigResult;
import io.reactivex.Observable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u000e\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\u0016J\u001e\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00060\u00032\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\bH\u0016ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\nÀ\u0006\u0001"}, d2 = {"Lid/dana/data/investment/repository/source/InvestmentEntityData;", "", "getDanaPlusMethodConfig", "Lio/reactivex/Observable;", "Lid/dana/data/investment/repository/source/split/response/DanaPlusMethodConfigResult;", "getUserInvestmentAccount", "Lid/dana/data/investment/repository/source/network/response/AccountInvestmentResult;", "userId", "", "goodsId", "data_productionRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public interface InvestmentEntityData {
    Observable<DanaPlusMethodConfigResult> KClassImpl$Data$declaredNonStaticMembers$2();

    Observable<AccountInvestmentResult> MyBillsEntityDataFactory(String str, String str2);

    /* renamed from: id.dana.data.investment.repository.source.InvestmentEntityData$-CC  reason: invalid class name */
    /* loaded from: classes4.dex */
    public final /* synthetic */ class CC {
        public static Observable PlaceComponentResult(String str, String str2) {
            Intrinsics.checkNotNullParameter(str, "");
            Intrinsics.checkNotNullParameter(str2, "");
            throw new UnsupportedOperationException();
        }

        public static Observable MyBillsEntityDataFactory() {
            throw new UnsupportedOperationException();
        }
    }
}
