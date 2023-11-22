package net.sqlcipher;

import android.content.ContentValues;
import android.content.OperationApplicationException;
import android.os.Parcel;
import android.text.TextUtils;
import com.fullstory.instrumentation.InstrumentInjector;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.text.Collator;
import java.util.HashMap;
import java.util.Map;
import net.sqlcipher.database.SQLiteAbortException;
import net.sqlcipher.database.SQLiteConstraintException;
import net.sqlcipher.database.SQLiteDatabase;
import net.sqlcipher.database.SQLiteDatabaseCorruptException;
import net.sqlcipher.database.SQLiteDiskIOException;
import net.sqlcipher.database.SQLiteException;
import net.sqlcipher.database.SQLiteFullException;
import net.sqlcipher.database.SQLiteProgram;
import net.sqlcipher.database.SQLiteStatement;

/* loaded from: classes6.dex */
public class DatabaseUtils {
    private static final boolean DEBUG = false;
    private static final boolean LOCAL_LOGV = false;
    private static final String TAG = "DatabaseUtils";
    private static final String[] countProjection = {"count(*)"};
    private static final char[] HEX_DIGITS_LOWER = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
    private static Collator mColl = null;

    public static final void writeExceptionToParcel(Parcel parcel, Exception exc) {
        boolean z;
        int i = 1;
        if (exc instanceof FileNotFoundException) {
            z = false;
        } else if (exc instanceof IllegalArgumentException) {
            z = true;
            i = 2;
        } else if (exc instanceof UnsupportedOperationException) {
            z = true;
            i = 3;
        } else if (exc instanceof SQLiteAbortException) {
            z = true;
            i = 4;
        } else if (exc instanceof SQLiteConstraintException) {
            z = true;
            i = 5;
        } else if (exc instanceof SQLiteDatabaseCorruptException) {
            z = true;
            i = 6;
        } else if (exc instanceof SQLiteFullException) {
            z = true;
            i = 7;
        } else if (exc instanceof SQLiteDiskIOException) {
            z = true;
            i = 8;
        } else if (exc instanceof SQLiteException) {
            z = true;
            i = 9;
        } else if (!(exc instanceof OperationApplicationException)) {
            parcel.writeException(exc);
            InstrumentInjector.log_e(TAG, "Writing exception to parcel", exc);
            return;
        } else {
            z = true;
            i = 10;
        }
        parcel.writeInt(i);
        parcel.writeString(exc.getMessage());
        if (z) {
            InstrumentInjector.log_e(TAG, "Writing exception to parcel", exc);
        }
    }

    public static final void readExceptionFromParcel(Parcel parcel) {
        int readInt = parcel.readInt();
        if (readInt == 0) {
            return;
        }
        readExceptionFromParcel(parcel, parcel.readString(), readInt);
    }

    public static void readExceptionWithFileNotFoundExceptionFromParcel(Parcel parcel) throws FileNotFoundException {
        int readInt = parcel.readInt();
        if (readInt == 0) {
            return;
        }
        String readString = parcel.readString();
        if (readInt == 1) {
            throw new FileNotFoundException(readString);
        }
        readExceptionFromParcel(parcel, readString, readInt);
    }

    public static void readExceptionWithOperationApplicationExceptionFromParcel(Parcel parcel) throws OperationApplicationException {
        int readInt = parcel.readInt();
        if (readInt == 0) {
            return;
        }
        String readString = parcel.readString();
        if (readInt == 10) {
            throw new OperationApplicationException(readString);
        }
        readExceptionFromParcel(parcel, readString, readInt);
    }

    private static final void readExceptionFromParcel(Parcel parcel, String str, int i) {
        switch (i) {
            case 2:
                throw new IllegalArgumentException(str);
            case 3:
                throw new UnsupportedOperationException(str);
            case 4:
                throw new SQLiteAbortException(str);
            case 5:
                throw new SQLiteConstraintException(str);
            case 6:
                throw new SQLiteDatabaseCorruptException(str);
            case 7:
                throw new SQLiteFullException(str);
            case 8:
                throw new SQLiteDiskIOException(str);
            case 9:
                throw new SQLiteException(str);
            default:
                parcel.readException(i, str);
                return;
        }
    }

    public static void bindObjectToProgram(SQLiteProgram sQLiteProgram, int i, Object obj) {
        if (obj == null) {
            sQLiteProgram.bindNull(i);
        } else if ((obj instanceof Double) || (obj instanceof Float)) {
            sQLiteProgram.bindDouble(i, ((Number) obj).doubleValue());
        } else if (obj instanceof Number) {
            sQLiteProgram.bindLong(i, ((Number) obj).longValue());
        } else if (obj instanceof Boolean) {
            if (((Boolean) obj).booleanValue()) {
                sQLiteProgram.bindLong(i, 1L);
            } else {
                sQLiteProgram.bindLong(i, 0L);
            }
        } else if (obj instanceof byte[]) {
            sQLiteProgram.bindBlob(i, (byte[]) obj);
        } else {
            sQLiteProgram.bindString(i, obj.toString());
        }
    }

    public static int getTypeOfObject(Object obj) {
        if (obj == null) {
            return 0;
        }
        if (obj instanceof byte[]) {
            return 4;
        }
        if ((obj instanceof Float) || (obj instanceof Double)) {
            return 2;
        }
        return ((obj instanceof Long) || (obj instanceof Integer)) ? 1 : 3;
    }

    public static void appendEscapedSQLString(StringBuilder sb, String str) {
        sb.append('\'');
        if (str.indexOf(39) != -1) {
            int length = str.length();
            for (int i = 0; i < length; i++) {
                char charAt = str.charAt(i);
                if (charAt == '\'') {
                    sb.append('\'');
                }
                sb.append(charAt);
            }
        } else {
            sb.append(str);
        }
        sb.append('\'');
    }

    public static String sqlEscapeString(String str) {
        StringBuilder sb = new StringBuilder();
        appendEscapedSQLString(sb, str);
        return sb.toString();
    }

    public static final void appendValueToSql(StringBuilder sb, Object obj) {
        if (obj == null) {
            sb.append("NULL");
        } else if (obj instanceof Boolean) {
            if (((Boolean) obj).booleanValue()) {
                sb.append('1');
            } else {
                sb.append('0');
            }
        } else {
            appendEscapedSQLString(sb, obj.toString());
        }
    }

    public static String concatenateWhere(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            return str2;
        }
        if (TextUtils.isEmpty(str2)) {
            return str;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("(");
        sb.append(str);
        sb.append(") AND (");
        sb.append(str2);
        sb.append(")");
        return sb.toString();
    }

    public static String getCollationKey(String str) {
        byte[] collationKeyInBytes = getCollationKeyInBytes(str);
        try {
            return new String(collationKeyInBytes, 0, getKeyLen(collationKeyInBytes), "ISO8859_1");
        } catch (Exception unused) {
            return "";
        }
    }

    public static String getHexCollationKey(String str) {
        byte[] collationKeyInBytes = getCollationKeyInBytes(str);
        return new String(encodeHex(collationKeyInBytes, HEX_DIGITS_LOWER), 0, getKeyLen(collationKeyInBytes) * 2);
    }

    private static char[] encodeHex(byte[] bArr, char[] cArr) {
        char[] cArr2 = new char[bArr.length << 1];
        int i = 0;
        for (byte b : bArr) {
            int i2 = i + 1;
            cArr2[i] = cArr[(b & 240) >>> 4];
            i = i2 + 1;
            cArr2[i2] = cArr[b & 15];
        }
        return cArr2;
    }

    private static int getKeyLen(byte[] bArr) {
        if (bArr[bArr.length - 1] != 0) {
            return bArr.length;
        }
        return bArr.length - 1;
    }

    private static byte[] getCollationKeyInBytes(String str) {
        if (mColl == null) {
            Collator collator = Collator.getInstance();
            mColl = collator;
            collator.setStrength(0);
        }
        return mColl.getCollationKey(str).toByteArray();
    }

    public static void dumpCursor(Cursor cursor) {
        dumpCursor(cursor, System.out);
    }

    public static void dumpCursor(Cursor cursor, PrintStream printStream) {
        StringBuilder sb = new StringBuilder();
        sb.append(">>>>> Dumping cursor ");
        sb.append(cursor);
        printStream.println(sb.toString());
        if (cursor != null) {
            int position = cursor.getPosition();
            cursor.moveToPosition(-1);
            while (cursor.moveToNext()) {
                dumpCurrentRow(cursor, printStream);
            }
            cursor.moveToPosition(position);
        }
        printStream.println("<<<<<");
    }

    public static void dumpCursor(Cursor cursor, StringBuilder sb) {
        StringBuilder sb2 = new StringBuilder();
        sb2.append(">>>>> Dumping cursor ");
        sb2.append(cursor);
        sb2.append("\n");
        sb.append(sb2.toString());
        if (cursor != null) {
            int position = cursor.getPosition();
            cursor.moveToPosition(-1);
            while (cursor.moveToNext()) {
                dumpCurrentRow(cursor, sb);
            }
            cursor.moveToPosition(position);
        }
        sb.append("<<<<<\n");
    }

    public static String dumpCursorToString(Cursor cursor) {
        StringBuilder sb = new StringBuilder();
        dumpCursor(cursor, sb);
        return sb.toString();
    }

    public static void dumpCurrentRow(Cursor cursor) {
        dumpCurrentRow(cursor, System.out);
    }

    public static void dumpCurrentRow(Cursor cursor, PrintStream printStream) {
        String str;
        String[] columnNames = cursor.getColumnNames();
        StringBuilder sb = new StringBuilder();
        sb.append(cursor.getPosition());
        sb.append(" {");
        printStream.println(sb.toString());
        int length = columnNames.length;
        for (int i = 0; i < length; i++) {
            try {
                str = cursor.getString(i);
            } catch (SQLiteException unused) {
                str = "<unprintable>";
            }
            StringBuilder sb2 = new StringBuilder();
            sb2.append("   ");
            sb2.append(columnNames[i]);
            sb2.append('=');
            sb2.append(str);
            printStream.println(sb2.toString());
        }
        printStream.println("}");
    }

    public static void dumpCurrentRow(Cursor cursor, StringBuilder sb) {
        String str;
        String[] columnNames = cursor.getColumnNames();
        StringBuilder sb2 = new StringBuilder();
        sb2.append(cursor.getPosition());
        sb2.append(" {\n");
        sb.append(sb2.toString());
        int length = columnNames.length;
        for (int i = 0; i < length; i++) {
            try {
                str = cursor.getString(i);
            } catch (SQLiteException unused) {
                str = "<unprintable>";
            }
            StringBuilder sb3 = new StringBuilder();
            sb3.append("   ");
            sb3.append(columnNames[i]);
            sb3.append('=');
            sb3.append(str);
            sb3.append("\n");
            sb.append(sb3.toString());
        }
        sb.append("}\n");
    }

    public static String dumpCurrentRowToString(Cursor cursor) {
        StringBuilder sb = new StringBuilder();
        dumpCurrentRow(cursor, sb);
        return sb.toString();
    }

    public static void cursorStringToContentValues(Cursor cursor, String str, ContentValues contentValues) {
        cursorStringToContentValues(cursor, str, contentValues, str);
    }

    public static void cursorStringToInsertHelper(Cursor cursor, String str, InsertHelper insertHelper, int i) {
        insertHelper.bind(i, cursor.getString(cursor.getColumnIndexOrThrow(str)));
    }

    public static void cursorStringToContentValues(Cursor cursor, String str, ContentValues contentValues, String str2) {
        contentValues.put(str2, cursor.getString(cursor.getColumnIndexOrThrow(str)));
    }

    public static void cursorIntToContentValues(Cursor cursor, String str, ContentValues contentValues) {
        cursorIntToContentValues(cursor, str, contentValues, str);
    }

    public static void cursorIntToContentValues(Cursor cursor, String str, ContentValues contentValues, String str2) {
        int columnIndex = cursor.getColumnIndex(str);
        if (!cursor.isNull(columnIndex)) {
            contentValues.put(str2, Integer.valueOf(cursor.getInt(columnIndex)));
        } else {
            contentValues.put(str2, (Integer) null);
        }
    }

    public static void cursorLongToContentValues(Cursor cursor, String str, ContentValues contentValues) {
        cursorLongToContentValues(cursor, str, contentValues, str);
    }

    public static void cursorLongToContentValues(Cursor cursor, String str, ContentValues contentValues, String str2) {
        int columnIndex = cursor.getColumnIndex(str);
        if (!cursor.isNull(columnIndex)) {
            contentValues.put(str2, Long.valueOf(cursor.getLong(columnIndex)));
        } else {
            contentValues.put(str2, (Long) null);
        }
    }

    public static void cursorDoubleToCursorValues(Cursor cursor, String str, ContentValues contentValues) {
        cursorDoubleToContentValues(cursor, str, contentValues, str);
    }

    public static void cursorDoubleToContentValues(Cursor cursor, String str, ContentValues contentValues, String str2) {
        int columnIndex = cursor.getColumnIndex(str);
        if (!cursor.isNull(columnIndex)) {
            contentValues.put(str2, Double.valueOf(cursor.getDouble(columnIndex)));
        } else {
            contentValues.put(str2, (Double) null);
        }
    }

    public static void cursorRowToContentValues(Cursor cursor, ContentValues contentValues) {
        AbstractWindowedCursor abstractWindowedCursor = cursor instanceof AbstractWindowedCursor ? (AbstractWindowedCursor) cursor : null;
        String[] columnNames = cursor.getColumnNames();
        int length = columnNames.length;
        for (int i = 0; i < length; i++) {
            if (abstractWindowedCursor != null && abstractWindowedCursor.isBlob(i)) {
                contentValues.put(columnNames[i], cursor.getBlob(i));
            } else {
                contentValues.put(columnNames[i], cursor.getString(i));
            }
        }
    }

    public static long queryNumEntries(SQLiteDatabase sQLiteDatabase, String str) {
        Cursor query = sQLiteDatabase.query(str, countProjection, null, null, null, null, null);
        try {
            query.moveToFirst();
            return query.getLong(0);
        } finally {
            query.close();
        }
    }

    public static long longForQuery(SQLiteDatabase sQLiteDatabase, String str, String[] strArr) {
        SQLiteStatement compileStatement = sQLiteDatabase.compileStatement(str);
        try {
            return longForQuery(compileStatement, strArr);
        } finally {
            compileStatement.close();
        }
    }

    public static long longForQuery(SQLiteStatement sQLiteStatement, String[] strArr) {
        if (strArr != null) {
            int length = strArr.length;
            int i = 0;
            while (i < length) {
                int i2 = i + 1;
                bindObjectToProgram(sQLiteStatement, i2, strArr[i]);
                i = i2;
            }
        }
        return sQLiteStatement.simpleQueryForLong();
    }

    public static String stringForQuery(SQLiteDatabase sQLiteDatabase, String str, String[] strArr) {
        SQLiteStatement compileStatement = sQLiteDatabase.compileStatement(str);
        try {
            return stringForQuery(compileStatement, strArr);
        } finally {
            compileStatement.close();
        }
    }

    public static String stringForQuery(SQLiteStatement sQLiteStatement, String[] strArr) {
        if (strArr != null) {
            int length = strArr.length;
            int i = 0;
            while (i < length) {
                int i2 = i + 1;
                bindObjectToProgram(sQLiteStatement, i2, strArr[i]);
                i = i2;
            }
        }
        return sQLiteStatement.simpleQueryForString();
    }

    public static void cursorStringToContentValuesIfPresent(Cursor cursor, ContentValues contentValues, String str) {
        int columnIndexOrThrow = cursor.getColumnIndexOrThrow(str);
        if (cursor.isNull(columnIndexOrThrow)) {
            return;
        }
        contentValues.put(str, cursor.getString(columnIndexOrThrow));
    }

    public static void cursorLongToContentValuesIfPresent(Cursor cursor, ContentValues contentValues, String str) {
        int columnIndexOrThrow = cursor.getColumnIndexOrThrow(str);
        if (cursor.isNull(columnIndexOrThrow)) {
            return;
        }
        contentValues.put(str, Long.valueOf(cursor.getLong(columnIndexOrThrow)));
    }

    public static void cursorShortToContentValuesIfPresent(Cursor cursor, ContentValues contentValues, String str) {
        int columnIndexOrThrow = cursor.getColumnIndexOrThrow(str);
        if (cursor.isNull(columnIndexOrThrow)) {
            return;
        }
        contentValues.put(str, Short.valueOf(cursor.getShort(columnIndexOrThrow)));
    }

    public static void cursorIntToContentValuesIfPresent(Cursor cursor, ContentValues contentValues, String str) {
        int columnIndexOrThrow = cursor.getColumnIndexOrThrow(str);
        if (cursor.isNull(columnIndexOrThrow)) {
            return;
        }
        contentValues.put(str, Integer.valueOf(cursor.getInt(columnIndexOrThrow)));
    }

    public static void cursorFloatToContentValuesIfPresent(Cursor cursor, ContentValues contentValues, String str) {
        int columnIndexOrThrow = cursor.getColumnIndexOrThrow(str);
        if (cursor.isNull(columnIndexOrThrow)) {
            return;
        }
        contentValues.put(str, Float.valueOf(cursor.getFloat(columnIndexOrThrow)));
    }

    public static void cursorDoubleToContentValuesIfPresent(Cursor cursor, ContentValues contentValues, String str) {
        int columnIndexOrThrow = cursor.getColumnIndexOrThrow(str);
        if (cursor.isNull(columnIndexOrThrow)) {
            return;
        }
        contentValues.put(str, Double.valueOf(cursor.getDouble(columnIndexOrThrow)));
    }

    /* loaded from: classes9.dex */
    public static class InsertHelper {
        public static final int TABLE_INFO_PRAGMA_COLUMNNAME_INDEX = 1;
        public static final int TABLE_INFO_PRAGMA_DEFAULT_INDEX = 4;
        private HashMap<String, Integer> mColumns;
        private final SQLiteDatabase mDb;
        private final String mTableName;
        private String mInsertSQL = null;
        private SQLiteStatement mInsertStatement = null;
        private SQLiteStatement mReplaceStatement = null;
        private SQLiteStatement mPreparedStatement = null;

        public InsertHelper(SQLiteDatabase sQLiteDatabase, String str) {
            this.mDb = sQLiteDatabase;
            this.mTableName = str;
        }

        private void buildSQL() throws SQLException {
            StringBuilder sb = new StringBuilder(128);
            sb.append("INSERT INTO ");
            sb.append(this.mTableName);
            sb.append(" (");
            StringBuilder sb2 = new StringBuilder(128);
            sb2.append("VALUES (");
            Cursor cursor = null;
            try {
                SQLiteDatabase sQLiteDatabase = this.mDb;
                StringBuilder sb3 = new StringBuilder();
                sb3.append("PRAGMA table_info(");
                sb3.append(this.mTableName);
                sb3.append(")");
                cursor = sQLiteDatabase.rawQuery(sb3.toString(), (String[]) null);
                this.mColumns = new HashMap<>(cursor.getCount());
                int i = 1;
                while (cursor.moveToNext()) {
                    String string = cursor.getString(1);
                    String string2 = cursor.getString(4);
                    this.mColumns.put(string, Integer.valueOf(i));
                    sb.append("'");
                    sb.append(string);
                    sb.append("'");
                    if (string2 == null) {
                        sb2.append("?");
                    } else {
                        sb2.append("COALESCE(?, ");
                        sb2.append(string2);
                        sb2.append(")");
                    }
                    sb.append(i == cursor.getCount() ? ") " : ", ");
                    sb2.append(i == cursor.getCount() ? ");" : ", ");
                    i++;
                }
                sb.append((CharSequence) sb2);
                this.mInsertSQL = sb.toString();
            } finally {
                if (cursor != null) {
                    cursor.close();
                }
            }
        }

        private SQLiteStatement getStatement(boolean z) throws SQLException {
            if (z) {
                if (this.mReplaceStatement == null) {
                    if (this.mInsertSQL == null) {
                        buildSQL();
                    }
                    StringBuilder sb = new StringBuilder();
                    sb.append("INSERT OR REPLACE");
                    sb.append(this.mInsertSQL.substring(6));
                    this.mReplaceStatement = this.mDb.compileStatement(sb.toString());
                }
                return this.mReplaceStatement;
            }
            if (this.mInsertStatement == null) {
                if (this.mInsertSQL == null) {
                    buildSQL();
                }
                this.mInsertStatement = this.mDb.compileStatement(this.mInsertSQL);
            }
            return this.mInsertStatement;
        }

        private long insertInternal(ContentValues contentValues, boolean z) {
            long executeInsert;
            synchronized (this) {
                try {
                    SQLiteStatement statement = getStatement(z);
                    statement.clearBindings();
                    for (Map.Entry<String, Object> entry : contentValues.valueSet()) {
                        DatabaseUtils.bindObjectToProgram(statement, getColumnIndex(entry.getKey()), entry.getValue());
                    }
                    executeInsert = statement.executeInsert();
                } catch (SQLException e) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("Error inserting ");
                    sb.append(contentValues);
                    sb.append(" into table  ");
                    sb.append(this.mTableName);
                    InstrumentInjector.log_e(DatabaseUtils.TAG, sb.toString(), e);
                    return -1L;
                }
            }
            return executeInsert;
        }

        public int getColumnIndex(String str) {
            getStatement(false);
            Integer num = this.mColumns.get(str);
            if (num == null) {
                StringBuilder sb = new StringBuilder();
                sb.append("column '");
                sb.append(str);
                sb.append("' is invalid");
                throw new IllegalArgumentException(sb.toString());
            }
            return num.intValue();
        }

        public void bind(int i, double d) {
            this.mPreparedStatement.bindDouble(i, d);
        }

        public void bind(int i, float f) {
            this.mPreparedStatement.bindDouble(i, f);
        }

        public void bind(int i, long j) {
            this.mPreparedStatement.bindLong(i, j);
        }

        public void bind(int i, int i2) {
            this.mPreparedStatement.bindLong(i, i2);
        }

        public void bind(int i, boolean z) {
            this.mPreparedStatement.bindLong(i, z ? 1L : 0L);
        }

        public void bindNull(int i) {
            this.mPreparedStatement.bindNull(i);
        }

        public void bind(int i, byte[] bArr) {
            if (bArr == null) {
                this.mPreparedStatement.bindNull(i);
            } else {
                this.mPreparedStatement.bindBlob(i, bArr);
            }
        }

        public void bind(int i, String str) {
            if (str == null) {
                this.mPreparedStatement.bindNull(i);
            } else {
                this.mPreparedStatement.bindString(i, str);
            }
        }

        public long insert(ContentValues contentValues) {
            return insertInternal(contentValues, false);
        }

        public long execute() {
            SQLiteStatement sQLiteStatement = this.mPreparedStatement;
            if (sQLiteStatement == null) {
                throw new IllegalStateException("you must prepare this inserter before calling execute");
            }
            try {
                try {
                    return sQLiteStatement.executeInsert();
                } catch (SQLException e) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("Error executing InsertHelper with table ");
                    sb.append(this.mTableName);
                    InstrumentInjector.log_e(DatabaseUtils.TAG, sb.toString(), e);
                    this.mPreparedStatement = null;
                    return -1L;
                }
            } finally {
                this.mPreparedStatement = null;
            }
        }

        public void prepareForInsert() {
            SQLiteStatement statement = getStatement(false);
            this.mPreparedStatement = statement;
            statement.clearBindings();
        }

        public void prepareForReplace() {
            SQLiteStatement statement = getStatement(true);
            this.mPreparedStatement = statement;
            statement.clearBindings();
        }

        public long replace(ContentValues contentValues) {
            return insertInternal(contentValues, true);
        }

        public void close() {
            SQLiteStatement sQLiteStatement = this.mInsertStatement;
            if (sQLiteStatement != null) {
                sQLiteStatement.close();
                this.mInsertStatement = null;
            }
            SQLiteStatement sQLiteStatement2 = this.mReplaceStatement;
            if (sQLiteStatement2 != null) {
                sQLiteStatement2.close();
                this.mReplaceStatement = null;
            }
            this.mInsertSQL = null;
            this.mColumns = null;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x0026, code lost:
    
        if (r2 >= r1) goto L40;
     */
    /* JADX WARN: Code restructure failed: missing block: B:11:0x0028, code lost:
    
        r3 = r5.getType(r2);
     */
    /* JADX WARN: Code restructure failed: missing block: B:12:0x002c, code lost:
    
        if (r3 == 0) goto L29;
     */
    /* JADX WARN: Code restructure failed: missing block: B:14:0x002f, code lost:
    
        if (r3 == 1) goto L28;
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x0032, code lost:
    
        if (r3 == 2) goto L27;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x0035, code lost:
    
        if (r3 == 4) goto L23;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x0037, code lost:
    
        r3 = r5.getString(r2);
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x003b, code lost:
    
        if (r3 == null) goto L22;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x003d, code lost:
    
        r3 = r7.putString(r3, r6, r2);
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x0042, code lost:
    
        r3 = r7.putNull(r6, r2);
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x0047, code lost:
    
        r3 = r5.getBlob(r2);
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x004b, code lost:
    
        if (r3 == null) goto L26;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x004d, code lost:
    
        r3 = r7.putBlob(r3, r6, r2);
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x0052, code lost:
    
        r3 = r7.putNull(r6, r2);
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x0057, code lost:
    
        r3 = r7.putDouble(r5.getDouble(r2), r6, r2);
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x0060, code lost:
    
        r3 = r7.putLong(r5.getLong(r2), r6, r2);
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x0069, code lost:
    
        r3 = r7.putNull(r6, r2);
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x006d, code lost:
    
        if (r3 != false) goto L32;
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x006f, code lost:
    
        r7.freeLastRow();
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x0073, code lost:
    
        r2 = r2 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x0076, code lost:
    
        r6 = r6 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x007c, code lost:
    
        if (r5.moveToNext() != false) goto L39;
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x007e, code lost:
    
        r5.moveToPosition(r0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x0081, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:6:0x001d, code lost:
    
        if (r5.moveToPosition(r6) != false) goto L7;
     */
    /* JADX WARN: Code restructure failed: missing block: B:8:0x0023, code lost:
    
        if (r7.allocRow() == false) goto L37;
     */
    /* JADX WARN: Code restructure failed: missing block: B:9:0x0025, code lost:
    
        r2 = 0;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static void cursorFillWindow(net.sqlcipher.Cursor r5, int r6, android.database.CursorWindow r7) {
        /*
            if (r6 < 0) goto L81
            int r0 = r5.getCount()
            if (r6 >= r0) goto L81
            int r0 = r5.getPosition()
            int r1 = r5.getColumnCount()
            r7.clear()
            r7.setStartPosition(r6)
            r7.setNumColumns(r1)
            boolean r2 = r5.moveToPosition(r6)
            if (r2 == 0) goto L7e
        L1f:
            boolean r2 = r7.allocRow()
            if (r2 == 0) goto L7e
            r2 = 0
        L26:
            if (r2 >= r1) goto L76
            int r3 = r5.getType(r2)
            if (r3 == 0) goto L69
            r4 = 1
            if (r3 == r4) goto L60
            r4 = 2
            if (r3 == r4) goto L57
            r4 = 4
            if (r3 == r4) goto L47
            java.lang.String r3 = r5.getString(r2)
            if (r3 == 0) goto L42
            boolean r3 = r7.putString(r3, r6, r2)
            goto L6d
        L42:
            boolean r3 = r7.putNull(r6, r2)
            goto L6d
        L47:
            byte[] r3 = r5.getBlob(r2)
            if (r3 == 0) goto L52
            boolean r3 = r7.putBlob(r3, r6, r2)
            goto L6d
        L52:
            boolean r3 = r7.putNull(r6, r2)
            goto L6d
        L57:
            double r3 = r5.getDouble(r2)
            boolean r3 = r7.putDouble(r3, r6, r2)
            goto L6d
        L60:
            long r3 = r5.getLong(r2)
            boolean r3 = r7.putLong(r3, r6, r2)
            goto L6d
        L69:
            boolean r3 = r7.putNull(r6, r2)
        L6d:
            if (r3 != 0) goto L73
            r7.freeLastRow()
            goto L76
        L73:
            int r2 = r2 + 1
            goto L26
        L76:
            int r6 = r6 + 1
            boolean r2 = r5.moveToNext()
            if (r2 != 0) goto L1f
        L7e:
            r5.moveToPosition(r0)
        L81:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.sqlcipher.DatabaseUtils.cursorFillWindow(net.sqlcipher.Cursor, int, android.database.CursorWindow):void");
    }
}
