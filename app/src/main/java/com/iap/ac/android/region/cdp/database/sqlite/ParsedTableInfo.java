package com.iap.ac.android.region.cdp.database.sqlite;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import com.iap.ac.android.acs.minioperation.a.a;
import com.iap.ac.android.region.cdp.database.annotation.IAPDatabaseTable;
import com.iap.ac.android.region.cdp.database.sqlite.IParsedTableInfo;
import com.iap.ac.android.region.cdp.database.sqlite.internal.ParsedFieldInfo;
import id.dana.cashier.view.InputCardNumberView;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;

/* loaded from: classes3.dex */
public class ParsedTableInfo<T> implements IParsedTableInfo<T> {
    public static final Map<Class<?>, ParsedTableInfo<?>> sCache = new HashMap();
    public final Class<T> mClazz;
    public ParsedFieldInfo mIdParsedFieldInfo;
    public final List<ParsedFieldInfo> mParsedFieldInfos;
    public final String mTableName;
    public boolean mUniqueComboExists;
    public boolean mUniqueExists;

    public ParsedTableInfo(Class<T> cls) {
        checkNoArgConstructor(cls);
        this.mClazz = cls;
        this.mTableName = parseTableName();
        this.mParsedFieldInfos = parseFieldInfos();
    }

    private StringBuilder appendEscaped(StringBuilder sb, String str) {
        sb.append('`');
        int indexOf = str.indexOf(46);
        if (indexOf > 0) {
            sb.append(str.substring(0, indexOf));
            sb.append("`.`");
            sb.append(str.substring(indexOf + 1));
        } else {
            sb.append(str);
        }
        sb.append('`');
        return sb;
    }

    public static void checkNoArgConstructor(Class<?> cls) {
        try {
            for (Constructor<?> constructor : cls.getDeclaredConstructors()) {
                if (constructor.getParameterTypes().length == 0) {
                    if (constructor.isAccessible()) {
                        return;
                    }
                    try {
                        constructor.setAccessible(true);
                        return;
                    } catch (SecurityException unused) {
                        StringBuilder sb = new StringBuilder();
                        sb.append("The no arg constructor of ");
                        sb.append(cls);
                        sb.append(" can not be accessed");
                        throw new IllegalArgumentException(sb.toString());
                    }
                }
            }
            StringBuilder sb2 = new StringBuilder();
            sb2.append(cls);
            sb2.append(" has no no-arg constructor");
            throw new IllegalArgumentException(sb2.toString());
        } catch (SecurityException unused2) {
            StringBuilder sb3 = new StringBuilder();
            sb3.append("The declared constructors of ");
            sb3.append(cls);
            sb3.append(" can not be accessed");
            throw new IllegalArgumentException(sb3.toString());
        }
    }

    public static <T> ParsedTableInfo<T> create(Class<T> cls) {
        synchronized (ParsedTableInfo.class) {
            Map<Class<?>, ParsedTableInfo<?>> map = sCache;
            if (map.containsKey(cls)) {
                return map.get(cls);
            }
            ParsedTableInfo<T> parsedTableInfo = new ParsedTableInfo<>(cls);
            map.put(cls, parsedTableInfo);
            return parsedTableInfo;
        }
    }

    private List<ParsedFieldInfo> parseFieldInfos() {
        ArrayList arrayList = new ArrayList();
        for (Class<T> cls = this.mClazz; cls != null; cls = cls.getSuperclass()) {
            for (Field field : cls.getDeclaredFields()) {
                ParsedFieldInfo create = ParsedFieldInfo.create(field);
                if (create != null) {
                    arrayList.add(create);
                    if (create.isUnique()) {
                        this.mUniqueExists = true;
                    }
                    if (create.isUniqueCombo()) {
                        this.mUniqueComboExists = true;
                    }
                    if (create.isId() || create.isGeneratedId()) {
                        if (this.mIdParsedFieldInfo == null) {
                            this.mIdParsedFieldInfo = create;
                        } else {
                            StringBuilder sb = new StringBuilder();
                            sb.append(this.mClazz);
                            sb.append(" has more than one id field");
                            throw new IllegalArgumentException(sb.toString());
                        }
                    }
                }
            }
        }
        if (arrayList.isEmpty()) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append(this.mClazz);
            sb2.append("must have at least one @IAPDatabaseField");
            throw new IllegalArgumentException(sb2.toString());
        }
        return arrayList;
    }

    private String parseTableName() {
        IAPDatabaseTable iAPDatabaseTable = (IAPDatabaseTable) this.mClazz.getAnnotation(IAPDatabaseTable.class);
        return (iAPDatabaseTable == null || iAPDatabaseTable.tableName().isEmpty()) ? this.mClazz.getSimpleName().toLowerCase(Locale.ENGLISH) : iAPDatabaseTable.tableName();
    }

    @Override // com.iap.ac.android.region.cdp.database.sqlite.IParsedTableInfo
    public ContentValues createContentValues(T t, boolean z) throws SQLException {
        ContentValues contentValues = new ContentValues();
        Iterator<ParsedFieldInfo> it = this.mParsedFieldInfos.iterator();
        while (it.hasNext()) {
            it.next().put(contentValues, t, z);
        }
        return contentValues;
    }

    @Override // com.iap.ac.android.region.cdp.database.sqlite.IParsedTableInfo
    public T createObject(Cursor cursor) throws SQLException {
        try {
            T newInstance = this.mClazz.newInstance();
            Iterator<ParsedFieldInfo> it = this.mParsedFieldInfos.iterator();
            while (it.hasNext()) {
                it.next().assign((Object) newInstance, cursor);
            }
            return newInstance;
        } catch (Exception e) {
            StringBuilder a2 = a.a("Can not create an object for ");
            a2.append(this.mClazz);
            throw new SQLException(a2.toString(), e);
        }
    }

    @Override // com.iap.ac.android.region.cdp.database.sqlite.IParsedTableInfo
    public void createTable(SQLiteDatabase sQLiteDatabase, boolean z) {
        StringBuilder sb = new StringBuilder();
        sb.append("CREATE TABLE ");
        if (z) {
            sb.append("IF NOT EXISTS ");
        }
        appendEscaped(sb, this.mTableName).append(" (");
        boolean z2 = true;
        for (ParsedFieldInfo parsedFieldInfo : this.mParsedFieldInfos) {
            if (z2) {
                z2 = false;
            } else {
                sb.append(", ");
            }
            StringBuilder appendEscaped = appendEscaped(sb, parsedFieldInfo.getColumnName());
            appendEscaped.append(InputCardNumberView.DIVIDER);
            appendEscaped.append(parsedFieldInfo.getSqlType());
            if (parsedFieldInfo.isGeneratedId()) {
                sb.append(" PRIMARY KEY AUTOINCREMENT");
            } else if (parsedFieldInfo.isId()) {
                sb.append(" PRIMARY KEY");
            }
            if (parsedFieldInfo.defaultValue() != null) {
                sb.append(" DEFAULT ");
                sb.append(parsedFieldInfo.defaultValue());
            }
            if (!parsedFieldInfo.canBeNull()) {
                sb.append(" NOT NULL");
            }
            if (parsedFieldInfo.isUnique()) {
                sb.append(" UNIQUE");
            }
        }
        boolean z3 = false;
        boolean z4 = true;
        for (ParsedFieldInfo parsedFieldInfo2 : this.mParsedFieldInfos) {
            if (parsedFieldInfo2.isUniqueCombo()) {
                if (z4) {
                    sb.append(", UNIQUE (");
                    z4 = false;
                } else {
                    sb.append(", ");
                }
                appendEscaped(sb, parsedFieldInfo2.getColumnName());
                z3 = true;
            }
        }
        if (z3) {
            sb.append(")");
        }
        sb.append(")");
        sQLiteDatabase.execSQL(sb.toString());
    }

    @Override // com.iap.ac.android.region.cdp.database.sqlite.IParsedTableInfo
    public void dropTable(SQLiteDatabase sQLiteDatabase, boolean z) {
        StringBuilder sb = new StringBuilder();
        sb.append("DROP TABLE ");
        if (z) {
            sb.append("IF EXISTS ");
        }
        appendEscaped(sb, this.mTableName);
        sQLiteDatabase.execSQL(sb.toString());
    }

    @Override // com.iap.ac.android.region.cdp.database.sqlite.IParsedTableInfo
    public <ID> ID getId(T t) throws SQLException {
        ParsedFieldInfo parsedFieldInfo = this.mIdParsedFieldInfo;
        if (parsedFieldInfo != null) {
            return (ID) parsedFieldInfo.getValue(t);
        }
        StringBuilder a2 = a.a("No id field in ");
        a2.append(this.mClazz);
        throw new SQLException(a2.toString());
    }

    @Override // com.iap.ac.android.region.cdp.database.sqlite.IParsedTableInfo
    public String getIdColumnName() throws SQLException {
        ParsedFieldInfo parsedFieldInfo = this.mIdParsedFieldInfo;
        if (parsedFieldInfo != null) {
            return parsedFieldInfo.getColumnName();
        }
        StringBuilder a2 = a.a("No id field in ");
        a2.append(this.mClazz);
        throw new SQLException(a2.toString());
    }

    @Override // com.iap.ac.android.region.cdp.database.sqlite.IParsedTableInfo
    public String getTableName() {
        return this.mTableName;
    }

    @Override // com.iap.ac.android.region.cdp.database.sqlite.IParsedTableInfo
    public boolean idExists() {
        return this.mIdParsedFieldInfo != null;
    }

    @Override // com.iap.ac.android.region.cdp.database.sqlite.IParsedTableInfo
    public boolean isGeneratedId() {
        ParsedFieldInfo parsedFieldInfo = this.mIdParsedFieldInfo;
        return parsedFieldInfo != null && parsedFieldInfo.isGeneratedId();
    }

    @Override // com.iap.ac.android.region.cdp.database.sqlite.IParsedTableInfo
    public boolean uniqueComboExists() {
        return this.mUniqueComboExists;
    }

    @Override // com.iap.ac.android.region.cdp.database.sqlite.IParsedTableInfo
    public boolean uniqueExists() {
        return this.mUniqueExists;
    }

    @Override // com.iap.ac.android.region.cdp.database.sqlite.IParsedTableInfo
    public T createObject(IParsedTableInfo.GetFieldValueCallback getFieldValueCallback) throws SQLException {
        try {
            T newInstance = this.mClazz.newInstance();
            for (ParsedFieldInfo parsedFieldInfo : this.mParsedFieldInfos) {
                parsedFieldInfo.assign(newInstance, getFieldValueCallback.getFieldValue(parsedFieldInfo.getName()));
            }
            return newInstance;
        } catch (Exception e) {
            StringBuilder a2 = a.a("Can not create an object for ");
            a2.append(this.mClazz);
            throw new SQLException(a2.toString(), e);
        }
    }
}
