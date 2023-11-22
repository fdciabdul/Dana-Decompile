package id.dana.sendmoney.contact.all;

import android.view.View;
import android.view.ViewGroup;
import butterknife.BindView;
import id.dana.R;
import id.dana.base.BaseRecyclerViewHolder;
import id.dana.sendmoney.model.RecipientViewModel;
import id.dana.sendmoney.recipient.view.ContactRichView;
import id.dana.sendmoney.view.BaseRecipientListener;
import io.reactivex.functions.Consumer;
import io.reactivex.subjects.PublishSubject;
import java.util.List;

/* loaded from: classes5.dex */
public class ContactViewHolder extends BaseRecyclerViewHolder<RecipientViewModel> {
    private List<String> BuiltInFictitiousFunctionClassFactory;
    final BaseRecipientListener KClassImpl$Data$declaredNonStaticMembers$2;
    List<String> MyBillsEntityDataFactory;
    private String PlaceComponentResult;
    @BindView(R.id.crv_contact)
    ContactRichView contactRichView;
    private PublishSubject<List<String>> getAuthRequestContext;

    public ContactViewHolder(ViewGroup viewGroup, BaseRecipientListener baseRecipientListener, List<String> list) {
        this(viewGroup, baseRecipientListener, list, null, null);
    }

    public ContactViewHolder(ViewGroup viewGroup, BaseRecipientListener baseRecipientListener, List<String> list, PublishSubject<List<String>> publishSubject, List<String> list2) {
        super(viewGroup.getContext(), R.layout.item_contact, viewGroup);
        this.KClassImpl$Data$declaredNonStaticMembers$2 = baseRecipientListener;
        this.BuiltInFictitiousFunctionClassFactory = list;
        this.getAuthRequestContext = publishSubject;
        this.MyBillsEntityDataFactory = list2;
    }

    public final List<String> getAuthRequestContext() {
        return this.BuiltInFictitiousFunctionClassFactory;
    }

    @Override // id.dana.base.BaseRecyclerViewHolder
    /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: merged with bridge method [inline-methods] */
    public void bindData(RecipientViewModel recipientViewModel) {
        this.contactRichView.enableArrow();
        this.contactRichView.init(recipientViewModel, this.BuiltInFictitiousFunctionClassFactory);
        this.contactRichView.setOnClickListener(new View.OnClickListener() { // from class: id.dana.sendmoney.contact.all.ContactViewHolder$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ContactViewHolder contactViewHolder = ContactViewHolder.this;
                contactViewHolder.KClassImpl$Data$declaredNonStaticMembers$2.onRecipientSelected(contactViewHolder.contactRichView.getSelectedRecipient());
            }
        });
        this.contactRichView.setSelectedState(this.MyBillsEntityDataFactory);
        PublishSubject<List<String>> publishSubject = this.getAuthRequestContext;
        if (publishSubject != null) {
            addDisposable(publishSubject.subscribe(new Consumer() { // from class: id.dana.sendmoney.contact.all.ContactViewHolder$$ExternalSyntheticLambda1
                @Override // io.reactivex.functions.Consumer
                public final void accept(Object obj) {
                    ContactViewHolder contactViewHolder = ContactViewHolder.this;
                    List<String> list = (List) obj;
                    contactViewHolder.contactRichView.setSelectedState(list);
                    contactViewHolder.MyBillsEntityDataFactory = list;
                }
            }));
        }
    }

    public ContactViewHolder getAuthRequestContext(String str) {
        this.PlaceComponentResult = str;
        return this;
    }
}
