package id.dana.danah5.contact;

import dagger.MembersInjector;
import id.dana.sync_engine.domain.interactor.GetContactByPhoneNumber;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class ContactBridge_MembersInjector implements MembersInjector<ContactBridge> {
    private final Provider<GetContactByPhoneNumber> getContactByPhoneNumberProvider;

    public ContactBridge_MembersInjector(Provider<GetContactByPhoneNumber> provider) {
        this.getContactByPhoneNumberProvider = provider;
    }

    public static MembersInjector<ContactBridge> create(Provider<GetContactByPhoneNumber> provider) {
        return new ContactBridge_MembersInjector(provider);
    }

    public final void injectMembers(ContactBridge contactBridge) {
        injectGetContactByPhoneNumber(contactBridge, this.getContactByPhoneNumberProvider.get());
    }

    public static void injectGetContactByPhoneNumber(ContactBridge contactBridge, GetContactByPhoneNumber getContactByPhoneNumber) {
        contactBridge.getContactByPhoneNumber = getContactByPhoneNumber;
    }
}
