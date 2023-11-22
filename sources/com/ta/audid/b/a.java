package com.ta.audid.b;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.text.TextUtils;
import com.iap.ac.android.biz.common.utils.log.LogConstants;
import com.j256.ormlite.field.FieldType;
import com.ta.audid.g.m;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

/* loaded from: classes.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    private c f7671a;
    private String c;

    /* renamed from: a  reason: collision with other field name */
    private HashMap<String, Boolean> f44a = new HashMap<>();
    private HashMap<Class<?>, List<Field>> b = new HashMap<>();

    /* renamed from: c  reason: collision with other field name */
    private HashMap<Field, String> f45c = new HashMap<>();
    private HashMap<Class<?>, String> d = new HashMap<>();

    public a(Context context, String str) {
        this.f7671a = new c(context, str);
        this.c = str;
    }

    public List<? extends b> find(Class<? extends b> cls, String str, String str2, int i) {
        String obj;
        String obj2;
        String obj3;
        List<? extends b> list;
        Object valueOf;
        synchronized (this) {
            List<? extends b> list2 = Collections.EMPTY_LIST;
            if (cls == null) {
                return list2;
            }
            String tablename = getTablename(cls);
            SQLiteDatabase a2 = a(cls, tablename);
            if (a2 == null) {
                m.d("db is null", new Object[0]);
                return list2;
            }
            StringBuilder sb = new StringBuilder();
            sb.append("SELECT * FROM ");
            sb.append(tablename);
            if (TextUtils.isEmpty(str)) {
                obj = "";
            } else {
                StringBuilder sb2 = new StringBuilder();
                sb2.append(" WHERE ");
                sb2.append(str);
                obj = sb2.toString();
            }
            sb.append(obj);
            if (TextUtils.isEmpty(str2)) {
                obj2 = "";
            } else {
                StringBuilder sb3 = new StringBuilder();
                sb3.append(" ORDER BY ");
                sb3.append(str2);
                obj2 = sb3.toString();
            }
            sb.append(obj2);
            if (i <= 0) {
                obj3 = "";
            } else {
                StringBuilder sb4 = new StringBuilder();
                sb4.append(" LIMIT ");
                sb4.append(i);
                obj3 = sb4.toString();
            }
            sb.append(obj3);
            String obj4 = sb.toString();
            m.d("DBMgr", "sql", obj4);
            Cursor cursor = null;
            try {
                cursor = a2.rawQuery(obj4, null);
                list = new ArrayList<>();
            } catch (Throwable th) {
                th = th;
            }
            try {
                List<Field> m243a = m243a((Class) cls);
                while (cursor != null && cursor.moveToNext()) {
                    b newInstance = cls.newInstance();
                    for (int i2 = 0; i2 < m243a.size(); i2++) {
                        Field field = m243a.get(i2);
                        Class<?> type = field.getType();
                        String a3 = a(field);
                        int columnIndex = cursor.getColumnIndex(a3);
                        if (columnIndex != -1) {
                            try {
                                if (type != Long.class && type != Long.TYPE) {
                                    if (type != Integer.class && type != Integer.TYPE) {
                                        if (type != Double.TYPE && type != Double.class) {
                                            valueOf = cursor.getString(columnIndex);
                                            field.set(newInstance, valueOf);
                                        }
                                        valueOf = Double.valueOf(cursor.getDouble(columnIndex));
                                        field.set(newInstance, valueOf);
                                    }
                                    valueOf = Integer.valueOf(cursor.getInt(columnIndex));
                                    field.set(newInstance, valueOf);
                                }
                                field.set(newInstance, valueOf);
                            } catch (Exception unused) {
                            }
                            valueOf = Long.valueOf(cursor.getLong(columnIndex));
                        } else {
                            StringBuilder sb5 = new StringBuilder();
                            sb5.append("can not get field: ");
                            sb5.append(a3);
                            m.w("DBMgr", sb5.toString());
                        }
                    }
                    list.add(newInstance);
                }
            } catch (Throwable th2) {
                th = th2;
                list2 = list;
                try {
                    m.w("DBMgr", "[get]", th);
                    this.f7671a.closeCursor(cursor);
                    this.f7671a.closeWritableDatabase(a2);
                    list = list2;
                    return list;
                } finally {
                    this.f7671a.closeCursor(cursor);
                    this.f7671a.closeWritableDatabase(a2);
                }
            }
            return list;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void insert(List<? extends b> list) {
        synchronized (this) {
            if (list != null) {
                if (list.size() != 0) {
                    String tablename = getTablename(list.get(0).getClass());
                    SQLiteDatabase a2 = a(list.get(0).getClass(), tablename);
                    if (a2 == null) {
                        m.w("DBMgr", "can not get available db");
                        return;
                    }
                    try {
                        List<Field> m243a = m243a((Class) list.get(0).getClass());
                        ContentValues contentValues = new ContentValues();
                        a2.beginTransaction();
                        for (int i = 0; i < list.size(); i++) {
                            b bVar = list.get(i);
                            for (int i2 = 0; i2 < m243a.size(); i2++) {
                                Field field = m243a.get(i2);
                                String a3 = a(field);
                                try {
                                    Object obj = field.get(bVar);
                                    if (obj != null) {
                                        StringBuilder sb = new StringBuilder();
                                        sb.append(obj);
                                        contentValues.put(a3, sb.toString());
                                    } else {
                                        contentValues.put(a3, "");
                                    }
                                } catch (Exception e) {
                                    m.w("DBMgr", "get field failed", e);
                                }
                            }
                            if (bVar._id == -1) {
                                contentValues.remove(FieldType.FOREIGN_ID_FIELD_SUFFIX);
                                long insert = a2.insert(tablename, null, contentValues);
                                if (insert != -1) {
                                    bVar._id = insert;
                                    m.d("DBMgr", "mDbName", this.c, "tablename", tablename, "insert:success", bVar);
                                } else {
                                    m.w("DBMgr", "mDbName", this.c, "tablename", tablename, "insert:error", bVar);
                                }
                            } else {
                                long update = a2.update(tablename, contentValues, "_id=?", new String[]{String.valueOf(bVar._id)});
                                StringBuilder sb2 = new StringBuilder();
                                sb2.append("db update :");
                                sb2.append(update);
                                m.w("DBMgr", sb2.toString());
                            }
                            contentValues.clear();
                        }
                        try {
                            a2.setTransactionSuccessful();
                        } catch (Exception unused) {
                        }
                        a2.endTransaction();
                        this.f7671a.closeWritableDatabase(a2);
                    } catch (Throwable th) {
                        try {
                            m.d("DBMgr", th.toString());
                            try {
                                a2.setTransactionSuccessful();
                            } catch (Exception unused2) {
                            }
                            a2.endTransaction();
                        } catch (Throwable th2) {
                            try {
                                a2.setTransactionSuccessful();
                            } catch (Exception unused3) {
                            }
                            try {
                                a2.endTransaction();
                            } catch (Exception unused4) {
                            }
                            this.f7671a.closeWritableDatabase(a2);
                            throw th2;
                        }
                    }
                }
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int delete(List<? extends b> list) {
        synchronized (this) {
            if (list != null) {
                if (list.size() != 0) {
                    String tablename = getTablename(list.get(0).getClass());
                    SQLiteDatabase a2 = a(list.get(0).getClass(), tablename);
                    if (a2 == null) {
                        m.d("DBMgr", "db is null");
                        return 0;
                    }
                    try {
                        try {
                            a2.beginTransaction();
                            for (int i = 0; i < list.size(); i++) {
                                new StringBuilder().append(list.get(i)._id);
                                if (a2.delete(tablename, "_id=?", new String[]{r9.toString()}) <= 0) {
                                    m.w("DBMgr", "db", this.c, LogConstants.MultiLanguage.TABLE_NAME, tablename, " delete failed _id", Long.valueOf(list.get(i)._id));
                                } else {
                                    m.d("DBMgr", "db ", this.c, LogConstants.MultiLanguage.TABLE_NAME, tablename, "delete success _id", Long.valueOf(list.get(i)._id));
                                    list.get(i)._id = -1L;
                                }
                            }
                            try {
                                a2.setTransactionSuccessful();
                            } catch (Throwable unused) {
                            }
                            a2.endTransaction();
                        } catch (Throwable th) {
                            try {
                                m.w("DBMgr", "db delete error:", th);
                                try {
                                    a2.setTransactionSuccessful();
                                } catch (Throwable unused2) {
                                }
                                a2.endTransaction();
                            } catch (Throwable th2) {
                                try {
                                    a2.setTransactionSuccessful();
                                } catch (Throwable unused3) {
                                }
                                try {
                                    a2.endTransaction();
                                } catch (Throwable unused4) {
                                }
                                this.f7671a.closeWritableDatabase(a2);
                                throw th2;
                            }
                        }
                    } catch (Throwable unused5) {
                    }
                    this.f7671a.closeWritableDatabase(a2);
                    return list.size();
                }
            }
            return 0;
        }
    }

    public int delete(Class<? extends b> cls, String str, String[] strArr) {
        c cVar;
        synchronized (this) {
            int i = 0;
            m.d(null, "whereArgs", strArr, "", "whereArgs", strArr);
            if (cls != null) {
                SQLiteDatabase a2 = a(cls, getTablename(cls));
                if (a2 == null) {
                    return 0;
                }
                try {
                    int delete = a2.delete(getTablename(cls), str, strArr);
                    cVar = this.f7671a;
                    i = delete;
                } catch (Throwable th) {
                    try {
                        m.w("DBMgr", th, new Object[0]);
                        cVar = this.f7671a;
                    } catch (Throwable th2) {
                        this.f7671a.closeWritableDatabase(a2);
                        throw th2;
                    }
                }
                cVar.closeWritableDatabase(a2);
            }
            return i;
        }
    }

    public String getTablename(Class<?> cls) {
        String replace;
        if (cls == null) {
            return null;
        }
        if (this.d.containsKey(cls)) {
            return this.d.get(cls);
        }
        com.ta.audid.b.a.c cVar = (com.ta.audid.b.a.c) cls.getAnnotation(com.ta.audid.b.a.c.class);
        if (cVar != null && !TextUtils.isEmpty(cVar.value())) {
            replace = cVar.value();
        } else {
            replace = cls.getName().replace(".", "_");
        }
        this.d.put(cls, replace);
        return replace;
    }

    private SQLiteDatabase a(Class<? extends b> cls, String str) {
        SQLiteDatabase writableDatabase = this.f7671a.getWritableDatabase();
        Boolean bool = Boolean.TRUE;
        Boolean bool2 = (this.f44a.get(str) == null || !this.f44a.get(str).booleanValue()) ? Boolean.FALSE : bool;
        if (cls != null && !bool2.booleanValue()) {
            List<Field> m243a = m243a((Class) cls);
            ArrayList<Field> arrayList = new ArrayList<>();
            StringBuilder sb = new StringBuilder();
            sb.append(" SELECT * FROM ");
            sb.append(str);
            sb.append(" LIMIT 0");
            String obj = sb.toString();
            int i = 0;
            if (m243a != null) {
                Cursor cursor = null;
                try {
                    cursor = writableDatabase.rawQuery(obj, null);
                } catch (Exception unused) {
                    m.d("DBMgr", "has not create talbe:", str);
                }
                int i2 = cursor != null ? 0 : 1;
                while (i < m243a.size()) {
                    Field field = m243a.get(i);
                    if (!FieldType.FOREIGN_ID_FIELD_SUFFIX.equalsIgnoreCase(a(field)) && (i2 != 0 || (cursor != null && cursor.getColumnIndex(a(field)) == -1))) {
                        arrayList.add(field);
                    }
                    i++;
                }
                this.f7671a.closeCursor(cursor);
                i = i2;
            }
            if (i != 0) {
                b(writableDatabase, str, arrayList);
            } else if (arrayList.size() > 0) {
                a(writableDatabase, str, arrayList);
            }
            this.f44a.put(str, bool);
        }
        return writableDatabase;
    }

    private void a(SQLiteDatabase sQLiteDatabase, String str, ArrayList<Field> arrayList) {
        StringBuilder sb = new StringBuilder();
        sb.append("ALTER TABLE ");
        sb.append(str);
        sb.append(" ADD COLUMN ");
        String obj = sb.toString();
        StringBuilder sb2 = new StringBuilder();
        for (int i = 0; i < arrayList.size(); i++) {
            sb2.append(obj);
            sb2.append(a(arrayList.get(i)));
            sb2.append(" ");
            sb2.append(a(arrayList.get(i).getType()));
            String obj2 = sb2.toString();
            try {
                sQLiteDatabase.execSQL(obj2);
            } catch (Exception e) {
                m.w("DBMgr", "update db error...", e);
            }
            sb2.delete(0, obj2.length());
            m.d("DBMgr", null, "excute sql:", obj2);
        }
    }

    private void b(SQLiteDatabase sQLiteDatabase, String str, ArrayList<Field> arrayList) {
        StringBuilder sb = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();
        sb2.append("CREATE TABLE IF NOT EXISTS ");
        sb2.append(str);
        sb2.append(" (_id INTEGER PRIMARY KEY AUTOINCREMENT ,");
        sb.append(sb2.toString());
        if (arrayList.size() > 0) {
            for (int i = 0; i < arrayList.size(); i++) {
                if (i != 0) {
                    sb.append(",");
                }
                Class<?> type = arrayList.get(i).getType();
                sb.append(" ");
                sb.append(a(arrayList.get(i)));
                sb.append(" ");
                sb.append(a(type));
                sb.append(" ");
                sb.append(b(type));
            }
        }
        sb.append(" );");
        String obj = sb.toString();
        m.d("DBMgr", "excute sql:", obj);
        try {
            sQLiteDatabase.execSQL(obj);
        } catch (Exception e) {
            m.w("DBMgr", "create db error", e);
        }
    }

    private String a(Class<?> cls) {
        return (cls == Long.TYPE || cls == Integer.TYPE || cls == Long.class) ? "INTEGER" : "TEXT";
    }

    public int count(Class<? extends b> cls) {
        synchronized (this) {
            int i = 0;
            if (cls == null) {
                return 0;
            }
            String tablename = getTablename(cls);
            SQLiteDatabase a2 = a(cls, tablename);
            if (a2 != null) {
                Cursor cursor = null;
                try {
                    StringBuilder sb = new StringBuilder();
                    sb.append("SELECT count(*) FROM ");
                    sb.append(tablename);
                    cursor = a2.rawQuery(sb.toString(), null);
                    if (cursor != null) {
                        cursor.moveToFirst();
                        i = cursor.getInt(0);
                    }
                    this.f7671a.closeCursor(cursor);
                } catch (Throwable unused) {
                    this.f7671a.closeCursor(cursor);
                }
                this.f7671a.closeWritableDatabase(a2);
            } else {
                m.d("DBMgr", "db is null");
            }
            return i;
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    private List<Field> m243a(Class cls) {
        if (this.b.containsKey(cls)) {
            return this.b.get(cls);
        }
        List<Field> emptyList = Collections.emptyList();
        if (cls != null) {
            emptyList = new ArrayList<>();
            for (Field field : cls.getDeclaredFields()) {
                if (field.getAnnotation(com.ta.audid.b.a.b.class) == null && !field.isSynthetic()) {
                    field.setAccessible(true);
                    emptyList.add(field);
                }
            }
            if (cls.getSuperclass() != null && cls.getSuperclass() != Object.class) {
                emptyList.addAll(m243a(cls.getSuperclass()));
            }
            this.b.put(cls, emptyList);
        }
        return emptyList;
    }

    private String a(Field field) {
        String name;
        if (this.f45c.containsKey(field)) {
            return this.f45c.get(field);
        }
        com.ta.audid.b.a.a aVar = (com.ta.audid.b.a.a) field.getAnnotation(com.ta.audid.b.a.a.class);
        if (aVar != null && !TextUtils.isEmpty(aVar.value())) {
            name = aVar.value();
        } else {
            name = field.getName();
        }
        this.f45c.put(field, name);
        return name;
    }

    private String b(Class cls) {
        return (cls == Long.TYPE || cls == Integer.TYPE || cls == Long.class) ? "default 0" : "default \"\"";
    }
}
