package id.dana.sendmoney.recipient.decorator.recipient;

import id.dana.sendmoney.model.RecipientViewModel;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes5.dex */
public class Recipient {
    protected List<RecipientViewModel> PlaceComponentResult = new ArrayList();

    public List<RecipientViewModel> KClassImpl$Data$declaredNonStaticMembers$2() {
        return this.PlaceComponentResult;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void KClassImpl$Data$declaredNonStaticMembers$2(RecipientViewModel recipientViewModel) {
        this.PlaceComponentResult.add(recipientViewModel);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void getAuthRequestContext(List<RecipientViewModel> list) {
        this.PlaceComponentResult.addAll(list);
    }
}
