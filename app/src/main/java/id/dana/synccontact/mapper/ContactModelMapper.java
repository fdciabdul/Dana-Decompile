package id.dana.synccontact.mapper;

import id.dana.data.base.BaseMapper;
import id.dana.domain.synccontact.model.Contact;
import id.dana.sendmoney.contact.provider.ContactModel;
import javax.inject.Inject;

/* loaded from: classes5.dex */
public class ContactModelMapper extends BaseMapper<ContactModel, Contact> {
    @Override // id.dana.data.base.BaseMapper
    public /* synthetic */ Contact map(ContactModel contactModel) {
        ContactModel contactModel2 = contactModel;
        if (contactModel2 != null) {
            Contact contact = new Contact();
            contact.setRawId(contactModel2.BuiltInFictitiousFunctionClassFactory);
            contact.setLastUpdatedTime(contactModel2.NetworkUserEntityData$$ExternalSyntheticLambda0);
            contact.setPhoneNumber(contactModel2.getErrorConfigVersion);
            return contact;
        }
        return null;
    }

    @Inject
    public ContactModelMapper() {
    }
}
