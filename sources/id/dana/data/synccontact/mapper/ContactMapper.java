package id.dana.data.synccontact.mapper;

import id.dana.data.base.BaseMapper;
import id.dana.data.synccontact.model.ContactEntity;
import id.dana.domain.synccontact.model.Contact;
import javax.inject.Inject;

/* loaded from: classes4.dex */
public class ContactMapper extends BaseMapper<Contact, ContactEntity> {
    @Inject
    public ContactMapper() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // id.dana.data.base.BaseMapper
    public ContactEntity map(Contact contact) {
        if (contact != null) {
            ContactEntity contactEntity = new ContactEntity();
            contactEntity.setRawId(contact.getRawId());
            contactEntity.setPhoneNumber(contact.getPhoneNumber());
            contactEntity.setLastUpdatedTime(contact.getLastUpdatedTime());
            return contactEntity;
        }
        return null;
    }
}
