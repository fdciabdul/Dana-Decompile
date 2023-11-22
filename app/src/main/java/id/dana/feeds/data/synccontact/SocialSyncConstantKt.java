package id.dana.feeds.data.synccontact;

import id.dana.sendmoney.contact.provider.ContactProvider;
import kotlin.Metadata;
import kotlin.jvm.JvmName;

@Metadata(d1 = {"\u0000\f\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\u0006\" \u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u00008\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0002\u0010\u0003\u001a\u0004\b\u0002\u0010\u0004\" \u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00010\u00008\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0005\u0010\u0003\u001a\u0004\b\u0006\u0010\u0004"}, d2 = {"", "", "KClassImpl$Data$declaredNonStaticMembers$2", "[Ljava/lang/String;", "()[Ljava/lang/String;", "getAuthRequestContext", "MyBillsEntityDataFactory", "PlaceComponentResult"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class SocialSyncConstantKt {
    private static final String[] getAuthRequestContext = {ContactProvider.Column.CONTACT_ID, ContactProvider.Column.PHONENUMBER, ContactProvider.Column.DISPLAY_NAME, ContactProvider.Column.CONTACT_RAW_ID, ContactProvider.ColumnSpecial.LAST_UPDATED_TIME};
    private static final String[] KClassImpl$Data$declaredNonStaticMembers$2 = {ContactProvider.Column.PHONENUMBER, ContactProvider.Column.DISPLAY_NAME};

    @JvmName(name = "MyBillsEntityDataFactory")
    public static final String[] MyBillsEntityDataFactory() {
        return getAuthRequestContext;
    }
}
