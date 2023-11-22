package id.dana.data.social.common;

import android.database.Cursor;
import id.dana.data.social.model.FeedsContactEntity;
import id.dana.sendmoney.contact.provider.ContactProvider;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010%\n\u0002\b\u0003\u001a\u0017\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0000¢\u0006\u0004\b\u0003\u0010\u0004\u001a\u0015\u0010\u0006\u001a\u0006*\u00020\u00050\u0005*\u00020\u0000¢\u0006\u0004\b\u0006\u0010\u0007\u001a\u0011\u0010\t\u001a\u00020\b*\u00020\u0000¢\u0006\u0004\b\t\u0010\n\u001a\u0015\u0010\u000b\u001a\u0006*\u00020\u00050\u0005*\u00020\u0000¢\u0006\u0004\b\u000b\u0010\u0007\u001a\u0015\u0010\f\u001a\u0006*\u00020\u00050\u0005*\u00020\u0000¢\u0006\u0004\b\f\u0010\u0007\u001a\u0015\u0010\r\u001a\u0006*\u00020\u00050\u0005*\u00020\u0000¢\u0006\u0004\b\r\u0010\u0007\u001a1\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u000e*\u00020\u00002\u0012\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u000e¢\u0006\u0004\b\u0010\u0010\u0011"}, d2 = {"Landroid/database/Cursor;", "", "Lid/dana/data/social/model/FeedsContactEntity;", "getContactListFromCursor", "(Landroid/database/Cursor;)Ljava/util/List;", "", "parseContactDisplayId", "(Landroid/database/Cursor;)Ljava/lang/String;", "", "parseContactId", "(Landroid/database/Cursor;)I", "parseContactRawId", "parseLastUpdatedTime", "parsePhoneNumber", "", "mapResult", "toPhoneNumberAndContactNameMap", "(Landroid/database/Cursor;Ljava/util/Map;)Ljava/util/Map;"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class CursorExtensionKt {
    public static final int parseContactId(Cursor cursor) {
        Intrinsics.checkNotNullParameter(cursor, "");
        return cursor.getInt(cursor.getColumnIndex(ContactProvider.Column.CONTACT_ID));
    }

    public static final String parseContactDisplayId(Cursor cursor) {
        Intrinsics.checkNotNullParameter(cursor, "");
        return cursor.getString(cursor.getColumnIndex(ContactProvider.Column.DISPLAY_NAME));
    }

    public static final String parsePhoneNumber(Cursor cursor) {
        Intrinsics.checkNotNullParameter(cursor, "");
        return cursor.getString(cursor.getColumnIndex(ContactProvider.Column.PHONENUMBER));
    }

    public static final String parseContactRawId(Cursor cursor) {
        Intrinsics.checkNotNullParameter(cursor, "");
        return cursor.getString(cursor.getColumnIndex(ContactProvider.Column.CONTACT_RAW_ID));
    }

    public static final String parseLastUpdatedTime(Cursor cursor) {
        Intrinsics.checkNotNullParameter(cursor, "");
        return cursor.getString(cursor.getColumnIndex(ContactProvider.ColumnSpecial.LAST_UPDATED_TIME));
    }

    public static final Map<String, String> toPhoneNumberAndContactNameMap(Cursor cursor, Map<String, String> map) {
        Intrinsics.checkNotNullParameter(cursor, "");
        Intrinsics.checkNotNullParameter(map, "");
        while (cursor.moveToNext()) {
            String parsePhoneNumber = parsePhoneNumber(cursor);
            Intrinsics.checkNotNullExpressionValue(parsePhoneNumber, "");
            String parseContactDisplayId = parseContactDisplayId(cursor);
            Intrinsics.checkNotNullExpressionValue(parseContactDisplayId, "");
            map.put(parsePhoneNumber, parseContactDisplayId);
        }
        return map;
    }

    public static final List<FeedsContactEntity> getContactListFromCursor(Cursor cursor) {
        Intrinsics.checkNotNullParameter(cursor, "");
        ArrayList arrayList = new ArrayList();
        while (cursor.moveToNext()) {
            arrayList.add(FeedsContactEntity.INSTANCE.fromCursorWithoutPhoto(cursor));
        }
        return arrayList;
    }
}
