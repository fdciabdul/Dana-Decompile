package id.dana.data.contactinjection;

import android.content.ContentProviderOperation;
import android.content.Context;
import android.provider.ContactsContract;
import id.dana.sendmoney.contact.provider.ContactProvider;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u000b\u0010\fJ+\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00040\u0006¢\u0006\u0004\b\t\u0010\n"}, d2 = {"Lid/dana/data/contactinjection/AddContact;", "", "Landroid/content/Context;", "p0", "", "p1", "", "p2", "", "getAuthRequestContext", "(Landroid/content/Context;Ljava/lang/String;Ljava/util/List;)Z", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class AddContact {
    public static final AddContact INSTANCE = new AddContact();

    private AddContact() {
    }

    public static boolean getAuthRequestContext(Context p0, String p1, List<String> p2) {
        Intrinsics.checkNotNullParameter(p0, "");
        Intrinsics.checkNotNullParameter(p1, "");
        Intrinsics.checkNotNullParameter(p2, "");
        if (p2.isEmpty()) {
            throw new Exception("Phone Cannot Be Null");
        }
        ArrayList<ContentProviderOperation> arrayList = new ArrayList<>();
        int size = arrayList.size();
        ArrayList<ContentProviderOperation> arrayList2 = new ArrayList<>();
        arrayList2.add(ContentProviderOperation.newDelete(ContactsContract.Data.CONTENT_URI).withSelection("display_name = ?", new String[]{p1}).build());
        p0.getContentResolver().applyBatch("com.android.contacts", arrayList2);
        arrayList.add(ContentProviderOperation.newInsert(ContactsContract.RawContacts.CONTENT_URI).withValue("account_type", null).withValue("account_name", null).withYieldAllowed(true).build());
        arrayList.add(ContentProviderOperation.newInsert(ContactsContract.Data.CONTENT_URI).withValueBackReference(ContactProvider.Column.CONTACT_RAW_ID, size).withValue(ContactProvider.Column.MIMETYPE, "vnd.android.cursor.item/name").withValue(ContactProvider.Column.PHONENUMBER, p1).withYieldAllowed(true).build());
        Iterator<T> it = p2.iterator();
        while (it.hasNext()) {
            arrayList.add(ContentProviderOperation.newInsert(ContactsContract.Data.CONTENT_URI).withValueBackReference(ContactProvider.Column.CONTACT_RAW_ID, size).withValue(ContactProvider.Column.MIMETYPE, ContactProvider.Column.MIMETYPE_PHONENUMBER).withValue(ContactProvider.Column.PHONENUMBER, (String) it.next()).withValue("data2", 0).withValue("data3", "").withYieldAllowed(true).build());
        }
        if (arrayList.size() != 0) {
            p0.getContentResolver().applyBatch("com.android.contacts", arrayList);
        }
        return true;
    }
}
