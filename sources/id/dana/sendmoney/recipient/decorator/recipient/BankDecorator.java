package id.dana.sendmoney.recipient.decorator.recipient;

import id.dana.sendmoney.model.RecipientViewModel;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes9.dex */
public class BankDecorator extends RecipientDecorator {
    private Recipient BuiltInFictitiousFunctionClassFactory;

    @Override // id.dana.sendmoney.recipient.decorator.recipient.Recipient
    public final List<RecipientViewModel> KClassImpl$Data$declaredNonStaticMembers$2() {
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(this.BuiltInFictitiousFunctionClassFactory.KClassImpl$Data$declaredNonStaticMembers$2());
        arrayList.addAll(this.PlaceComponentResult);
        return arrayList;
    }
}
