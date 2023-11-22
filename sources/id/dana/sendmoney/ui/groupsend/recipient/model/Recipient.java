package id.dana.sendmoney.ui.groupsend.recipient.model;

import id.dana.sendmoney.ui.groupsend.recipient.model.viewmodel.RecipientViewModel;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes5.dex */
public class Recipient {
    protected List<RecipientViewModel> getAuthRequestContext = new ArrayList();

    public List<RecipientViewModel> MyBillsEntityDataFactory() {
        return this.getAuthRequestContext;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void MyBillsEntityDataFactory(RecipientViewModel recipientViewModel) {
        this.getAuthRequestContext.add(recipientViewModel);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void MyBillsEntityDataFactory(List<RecipientViewModel> list) {
        this.getAuthRequestContext.addAll(list);
    }
}
