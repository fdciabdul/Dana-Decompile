package id.dana.data.paylater.mapper;

import id.dana.data.paylater.repository.source.network.result.LoanInfoResult;
import id.dana.data.paylater.repository.source.network.result.LoanWhitelistResult;
import id.dana.domain.paylater.model.LoanInfo;
import id.dana.domain.paylater.model.LoanWhitelist;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Iterator;
import java.util.List;
import javax.inject.Inject;
import javax.inject.Singleton;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

@Singleton
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B\t\b\u0007¢\u0006\u0004\b\u000f\u0010\u0010J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u0019\u0010\u0005\u001a\u0004\u0018\u00010\t2\b\u0010\b\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\u0005\u0010\nJ%\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00040\u000b2\u000e\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u000bH\u0002¢\u0006\u0004\b\r\u0010\u000e"}, d2 = {"Lid/dana/data/paylater/mapper/PayLaterResultMapper;", "", "Lid/dana/data/paylater/repository/source/network/result/LoanInfoResult;", "loanInfoResult", "Lid/dana/domain/paylater/model/LoanInfo;", "transform", "(Lid/dana/data/paylater/repository/source/network/result/LoanInfoResult;)Lid/dana/domain/paylater/model/LoanInfo;", "Lid/dana/data/paylater/repository/source/network/result/LoanWhitelistResult;", "loanWhitelistResult", "Lid/dana/domain/paylater/model/LoanWhitelist;", "(Lid/dana/data/paylater/repository/source/network/result/LoanWhitelistResult;)Lid/dana/domain/paylater/model/LoanWhitelist;", "", "loanInfoResults", "transformLoanInfoResultList", "(Ljava/util/List;)Ljava/util/List;", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class PayLaterResultMapper {
    @Inject
    public PayLaterResultMapper() {
    }

    public final LoanWhitelist transform(LoanWhitelistResult loanWhitelistResult) {
        if (loanWhitelistResult != null) {
            return new LoanWhitelist(transformLoanInfoResultList(loanWhitelistResult.getLoanInfo()), Calendar.getInstance().getTimeInMillis());
        }
        return null;
    }

    private final List<LoanInfo> transformLoanInfoResultList(List<LoanInfoResult> loanInfoResults) {
        ArrayList arrayList;
        if (loanInfoResults != null) {
            List<LoanInfoResult> list = loanInfoResults;
            ArrayList arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
            Iterator<T> it = list.iterator();
            while (it.hasNext()) {
                arrayList2.add(transform((LoanInfoResult) it.next()));
            }
            arrayList = arrayList2;
        } else {
            arrayList = null;
        }
        return arrayList == null ? CollectionsKt.emptyList() : arrayList;
    }

    private final LoanInfo transform(LoanInfoResult loanInfoResult) {
        boolean areEqual = Intrinsics.areEqual(loanInfoResult.getWhitelist(), Boolean.TRUE);
        String type = loanInfoResult.getType();
        if (type == null) {
            type = "";
        }
        return new LoanInfo(areEqual, type, loanInfoResult.getRegistered(), loanInfoResult.getBillDueDate());
    }
}
