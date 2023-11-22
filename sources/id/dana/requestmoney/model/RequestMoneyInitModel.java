package id.dana.requestmoney.model;

import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\n\u001a\u00020\u0002\u0012\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\u0004\b\f\u0010\rR\u0011\u0010\u0005\u001a\u00020\u0002X\u0006¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0017\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0006¢\u0006\u0006\n\u0004\b\b\u0010\t"}, d2 = {"Lid/dana/requestmoney/model/RequestMoneyInitModel;", "", "", "KClassImpl$Data$declaredNonStaticMembers$2", "I", "getAuthRequestContext", "", "Lid/dana/requestmoney/model/UserBankModel;", "MyBillsEntityDataFactory", "Ljava/util/List;", "p0", "p1", "<init>", "(ILjava/util/List;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class RequestMoneyInitModel {

    /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
    public final int getAuthRequestContext;
    public final List<UserBankModel> MyBillsEntityDataFactory;

    public RequestMoneyInitModel(int i, List<UserBankModel> list) {
        Intrinsics.checkNotNullParameter(list, "");
        this.getAuthRequestContext = i;
        this.MyBillsEntityDataFactory = list;
    }
}
