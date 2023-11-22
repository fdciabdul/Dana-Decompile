package id.dana.data.synccontact.mapper;

import id.dana.data.base.BaseMapper;
import id.dana.data.synccontact.model.ContactEntity;
import id.dana.domain.synccontact.model.Contact;
import javax.inject.Inject;

/* loaded from: classes4.dex */
public class ContactEntityMapper extends BaseMapper<ContactEntity, Contact> {
    @Inject
    public ContactEntityMapper() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // id.dana.data.base.BaseMapper
    public Contact map(ContactEntity contactEntity) {
        if (contactEntity != null) {
            Contact contact = new Contact();
            contact.setRawId(contactEntity.getRawId());
            contact.setPhoneNumber(contactEntity.getPhoneNumber());
            contact.setLastUpdatedTime(contactEntity.getLastUpdatedTime());
            return contact;
        }
        return null;
    }
}
