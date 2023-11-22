package id.dana.sendmoney.contact.provider;

import android.content.ContentResolver;
import android.database.Cursor;
import android.provider.ContactsContract;
import android.text.TextUtils;
import id.dana.data.util.NumberUtils;
import id.dana.utils.OSUtil;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;

/* loaded from: classes5.dex */
public class ContactProvider {
    String BuiltInFictitiousFunctionClassFactory;
    private ContentResolver MyBillsEntityDataFactory;
    private static final String[] getAuthRequestContext = {Column.CONTACT_ID, Column.DISPLAY_NAME, Column.DISPLAY_PHOTO, Column.PHONENUMBER, Column.MIMETYPE};
    private static final String[] PlaceComponentResult = {Column.CONTACT_ID, Column.PHONENUMBER, Column.MIMETYPE, Column.CONTACT_RAW_ID};
    private static final String[] KClassImpl$Data$declaredNonStaticMembers$2 = {Column.CONTACT_ID, Column.DISPLAY_NAME, Column.PHONENUMBER, Column.MIMETYPE, Column.CONTACT_RAW_ID, ColumnSpecial.LAST_UPDATED_TIME};

    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes3.dex */
    @interface Column {
        public static final String CONTACT_ID = "contact_id";
        public static final String CONTACT_RAW_ID = "raw_contact_id";
        public static final String DISPLAY_NAME = "display_name";
        public static final String DISPLAY_PHOTO = "photo_uri";
        public static final String MIMETYPE = "mimetype";
        public static final String MIMETYPE_PHONENUMBER = "vnd.android.cursor.item/phone_v2";
        public static final String PHONENUMBER = "data1";
    }

    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes3.dex */
    @interface ColumnSpecial {
        public static final String LAST_UPDATED_TIME = "contact_last_updated_timestamp";
    }

    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes3.dex */
    @interface Selection {
        public static final String FILTER_CONTACT_RAW_ID = "mimetype = ? AND raw_contact_id > ?";
        public static final String FILTER_DISPLAY_NAME = "mimetype = ? AND LOWER(display_name) LIKE ?";
        public static final String FILTER_PHONENUMBER = "mimetype = ? AND REPLACE(data1, '-','') LIKE ?";
        public static final String SELECT_ALL = "mimetype = ?";
    }

    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes3.dex */
    @interface SelectionSpecial {
        public static final String FILTER_LAST_UPDATED_TIME = "mimetype = ? AND contact_last_updated_timestamp > ?";
    }

    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes3.dex */
    @interface SortOrder {
        public static final String SORT_ORDER_ASCENDING = "%s COLLATE NOCASE ASC";
        public static final String SORT_ORDER_ASCENDING_WITH_LIMIT = "%s COLLATE NOCASE ASC LIMIT %s OFFSET %s";
    }

    @Inject
    public ContactProvider(ContentResolver contentResolver) {
        this(contentResolver, "");
    }

    public ContactProvider(ContentResolver contentResolver, String str) {
        this.MyBillsEntityDataFactory = contentResolver;
        if (str != null) {
            this.BuiltInFictitiousFunctionClassFactory = str.toLowerCase();
        }
    }

    public final boolean KClassImpl$Data$declaredNonStaticMembers$2() {
        return BuiltInFictitiousFunctionClassFactory(1, 0).isEmpty();
    }

    public final List<ContactModel> MyBillsEntityDataFactory(int i, String str) {
        String[] strArr;
        if (!TextUtils.isEmpty(str)) {
            return PlaceComponentResult(i, str);
        }
        if (OSUtil.getAuthRequestContext()) {
            strArr = KClassImpl$Data$declaredNonStaticMembers$2;
        } else {
            strArr = PlaceComponentResult;
        }
        String[] strArr2 = strArr;
        String[] strArr3 = new String[1];
        System.arraycopy(new String[]{Column.MIMETYPE_PHONENUMBER}, 0, strArr3, 0, 1);
        Cursor query = this.MyBillsEntityDataFactory.query(ContactsContract.Data.CONTENT_URI, strArr2, Selection.SELECT_ALL, strArr3, String.format(SortOrder.SORT_ORDER_ASCENDING_WITH_LIMIT, OSUtil.getAuthRequestContext() ? ColumnSpecial.LAST_UPDATED_TIME : Column.CONTACT_RAW_ID, Integer.valueOf(i), 0));
        try {
            List<ContactModel> authRequestContext = getAuthRequestContext(query);
            if (query != null) {
                query.close();
            }
            return authRequestContext;
        } catch (Throwable th) {
            if (query != null) {
                try {
                    query.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
            }
            throw th;
        }
    }

    public final List<ContactModel> PlaceComponentResult(int i, String str) {
        Cursor query;
        if (OSUtil.getAuthRequestContext()) {
            String[] strArr = KClassImpl$Data$declaredNonStaticMembers$2;
            String[] strArr2 = new String[2];
            System.arraycopy(new String[]{Column.MIMETYPE_PHONENUMBER, str}, 0, strArr2, 0, 2);
            query = this.MyBillsEntityDataFactory.query(ContactsContract.Data.CONTENT_URI, strArr, SelectionSpecial.FILTER_LAST_UPDATED_TIME, strArr2, String.format(SortOrder.SORT_ORDER_ASCENDING_WITH_LIMIT, ColumnSpecial.LAST_UPDATED_TIME, Integer.valueOf(i), 0));
            try {
                List<ContactModel> authRequestContext = getAuthRequestContext(query);
                if (query != null) {
                    query.close();
                }
                return authRequestContext;
            } finally {
            }
        } else {
            String[] strArr3 = PlaceComponentResult;
            String[] strArr4 = new String[2];
            System.arraycopy(new String[]{Column.MIMETYPE_PHONENUMBER, str}, 0, strArr4, 0, 2);
            query = this.MyBillsEntityDataFactory.query(ContactsContract.Data.CONTENT_URI, strArr3, Selection.FILTER_CONTACT_RAW_ID, strArr4, String.format(SortOrder.SORT_ORDER_ASCENDING_WITH_LIMIT, Column.CONTACT_RAW_ID, Integer.valueOf(i), 0));
            try {
                List<ContactModel> authRequestContext2 = getAuthRequestContext(query);
                if (query != null) {
                    query.close();
                }
                return authRequestContext2;
            } finally {
            }
        }
    }

    private static List<ContactModel> getAuthRequestContext(Cursor cursor) {
        if (cursor == null) {
            return new ArrayList();
        }
        ArrayList arrayList = new ArrayList();
        int columnIndex = cursor.getColumnIndex(Column.CONTACT_ID);
        int columnIndex2 = cursor.getColumnIndex(Column.PHONENUMBER);
        int columnIndex3 = cursor.getColumnIndex(Column.MIMETYPE);
        int columnIndex4 = cursor.getColumnIndex(Column.CONTACT_RAW_ID);
        int columnIndex5 = cursor.getColumnIndex(Column.DISPLAY_NAME);
        int columnIndex6 = OSUtil.getAuthRequestContext() ? cursor.getColumnIndex(ColumnSpecial.LAST_UPDATED_TIME) : 0;
        while (cursor.moveToNext()) {
            int i = cursor.getInt(columnIndex);
            String string = cursor.getString(columnIndex2);
            String string2 = cursor.getString(columnIndex3);
            String string3 = cursor.getString(columnIndex4);
            String string4 = columnIndex6 != 0 ? cursor.getString(columnIndex6) : "";
            String string5 = cursor.getString(columnIndex5);
            if (string2.equals(Column.MIMETYPE_PHONENUMBER)) {
                arrayList.add(new ContactModel(i, string5, NumberUtils.getCleanSpaceAndDash(string), string3, string4));
            }
        }
        cursor.close();
        return arrayList;
    }

    public final int BuiltInFictitiousFunctionClassFactory() {
        try {
            Cursor query = this.MyBillsEntityDataFactory.query(ContactsContract.CommonDataKinds.Phone.CONTENT_URI, null, null, null, null);
            try {
                int count = query.getCount();
                if (query != null) {
                    query.close();
                }
                return count;
            } finally {
            }
        } catch (Exception unused) {
            return 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Deprecated
    public final List<ContactModel> BuiltInFictitiousFunctionClassFactory(int i, int i2) {
        Cursor query;
        ArrayList arrayList;
        if (TextUtils.isEmpty(this.BuiltInFictitiousFunctionClassFactory)) {
            String[] strArr = getAuthRequestContext;
            String[] strArr2 = new String[1];
            System.arraycopy(new String[]{Column.MIMETYPE_PHONENUMBER}, 0, strArr2, 0, 1);
            query = this.MyBillsEntityDataFactory.query(ContactsContract.Data.CONTENT_URI, strArr, Selection.SELECT_ALL, strArr2, String.format(SortOrder.SORT_ORDER_ASCENDING_WITH_LIMIT, Column.DISPLAY_NAME, Integer.valueOf(i), Integer.valueOf(i2)));
        } else if (NumberUtils.isPhoneNumberPrefix(this.BuiltInFictitiousFunctionClassFactory)) {
            String[] strArr3 = getAuthRequestContext;
            StringBuilder sb = new StringBuilder();
            sb.append("%");
            sb.append(this.BuiltInFictitiousFunctionClassFactory);
            sb.append("%");
            String[] strArr4 = new String[2];
            System.arraycopy(new String[]{Column.MIMETYPE_PHONENUMBER, sb.toString()}, 0, strArr4, 0, 2);
            query = this.MyBillsEntityDataFactory.query(ContactsContract.Data.CONTENT_URI, strArr3, Selection.FILTER_PHONENUMBER, strArr4, String.format(SortOrder.SORT_ORDER_ASCENDING_WITH_LIMIT, Column.DISPLAY_NAME, Integer.valueOf(i), Integer.valueOf(i2)));
        } else {
            String[] strArr5 = getAuthRequestContext;
            StringBuilder sb2 = new StringBuilder();
            sb2.append("%");
            sb2.append(this.BuiltInFictitiousFunctionClassFactory);
            sb2.append("%");
            String[] strArr6 = {Column.MIMETYPE_PHONENUMBER, sb2.toString()};
            String[] strArr7 = new String[2];
            System.arraycopy(strArr6, 0, strArr7, 0, 2);
            query = this.MyBillsEntityDataFactory.query(ContactsContract.Data.CONTENT_URI, strArr5, Selection.FILTER_DISPLAY_NAME, strArr7, String.format(SortOrder.SORT_ORDER_ASCENDING_WITH_LIMIT, Column.DISPLAY_NAME, Integer.valueOf(i), Integer.valueOf(i2)));
        }
        Cursor cursor = query;
        try {
            if (cursor == null) {
                arrayList = new ArrayList();
            } else {
                arrayList = new ArrayList();
                int columnIndex = cursor.getColumnIndex(Column.CONTACT_ID);
                int columnIndex2 = cursor.getColumnIndex(Column.DISPLAY_NAME);
                int columnIndex3 = cursor.getColumnIndex(Column.DISPLAY_PHOTO);
                int columnIndex4 = cursor.getColumnIndex(Column.PHONENUMBER);
                int columnIndex5 = cursor.getColumnIndex(Column.MIMETYPE);
                while (cursor.moveToNext()) {
                    int i3 = cursor.getInt(columnIndex);
                    String string = cursor.getString(columnIndex2);
                    String string2 = cursor.getString(columnIndex3);
                    String string3 = cursor.getString(columnIndex4);
                    if (cursor.getString(columnIndex5).equals(Column.MIMETYPE_PHONENUMBER)) {
                        ContactModel contactModel = new ContactModel(i3, string, string2, NumberUtils.getCleanSpaceAndDash(string3));
                        if (!arrayList.contains(contactModel)) {
                            arrayList.add(contactModel);
                        }
                    }
                }
                cursor.close();
            }
            if (cursor != null) {
                cursor.close();
            }
            return arrayList;
        } finally {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ Integer PlaceComponentResult() throws Exception {
        String[] strArr = getAuthRequestContext;
        String[] strArr2 = new String[1];
        System.arraycopy(new String[]{Column.MIMETYPE_PHONENUMBER}, 0, strArr2, 0, 1);
        Cursor query = this.MyBillsEntityDataFactory.query(ContactsContract.Data.CONTENT_URI, strArr, Selection.SELECT_ALL, strArr2, null);
        try {
            query.moveToFirst();
            int count = query.getCount();
            if (query != null) {
                query.close();
            }
            return Integer.valueOf(count);
        } catch (Throwable th) {
            if (query != null) {
                try {
                    query.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
            }
            throw th;
        }
    }
}
