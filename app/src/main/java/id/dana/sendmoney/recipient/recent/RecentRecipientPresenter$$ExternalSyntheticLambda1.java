package id.dana.sendmoney.recipient.recent;

import id.dana.sendmoney.mapper.RecentRecipientModelMapper;
import id.dana.sendmoney.recipient.recent.RecentRecipientContract;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* loaded from: classes9.dex */
public final /* synthetic */ class RecentRecipientPresenter$$ExternalSyntheticLambda1 implements Function1 {
    public final /* synthetic */ RecentRecipientPresenter KClassImpl$Data$declaredNonStaticMembers$2;
    public final /* synthetic */ int MyBillsEntityDataFactory;

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        RecentRecipientPresenter recentRecipientPresenter = this.KClassImpl$Data$declaredNonStaticMembers$2;
        int i = this.MyBillsEntityDataFactory;
        RecentRecipientContract.View view = recentRecipientPresenter.KClassImpl$Data$declaredNonStaticMembers$2;
        RecentRecipientModelMapper recentRecipientModelMapper = recentRecipientPresenter.MyBillsEntityDataFactory;
        RecentRecipientModelMapper.MyBillsEntityDataFactory((List) obj, i);
        return Unit.INSTANCE;
    }
}
