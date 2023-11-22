package androidx.room.util;

import android.database.Cursor;
import android.os.Build;
import androidx.room.Index;
import androidx.sqlite.db.SupportSQLiteDatabase;
import id.dana.data.foundation.logger.log.LoginTrackingConstants;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

/* loaded from: classes6.dex */
public final class TableInfo {
    public final String KClassImpl$Data$declaredNonStaticMembers$2;
    public final Set<ForeignKey> MyBillsEntityDataFactory;
    public final Set<Index> PlaceComponentResult;
    public final Map<String, Column> getAuthRequestContext;

    public TableInfo(String str, Map<String, Column> map, Set<ForeignKey> set, Set<Index> set2) {
        this.KClassImpl$Data$declaredNonStaticMembers$2 = str;
        this.getAuthRequestContext = Collections.unmodifiableMap(map);
        this.MyBillsEntityDataFactory = Collections.unmodifiableSet(set);
        this.PlaceComponentResult = set2 == null ? null : Collections.unmodifiableSet(set2);
    }

    public final boolean equals(Object obj) {
        Set<Index> set;
        if (this == obj) {
            return true;
        }
        if (obj instanceof TableInfo) {
            TableInfo tableInfo = (TableInfo) obj;
            String str = this.KClassImpl$Data$declaredNonStaticMembers$2;
            if (str == null ? tableInfo.KClassImpl$Data$declaredNonStaticMembers$2 == null : str.equals(tableInfo.KClassImpl$Data$declaredNonStaticMembers$2)) {
                Map<String, Column> map = this.getAuthRequestContext;
                if (map == null ? tableInfo.getAuthRequestContext == null : map.equals(tableInfo.getAuthRequestContext)) {
                    Set<ForeignKey> set2 = this.MyBillsEntityDataFactory;
                    if (set2 == null ? tableInfo.MyBillsEntityDataFactory == null : set2.equals(tableInfo.MyBillsEntityDataFactory)) {
                        Set<Index> set3 = this.PlaceComponentResult;
                        if (set3 == null || (set = tableInfo.PlaceComponentResult) == null) {
                            return true;
                        }
                        return set3.equals(set);
                    }
                    return false;
                }
                return false;
            }
            return false;
        }
        return false;
    }

    public final int hashCode() {
        String str = this.KClassImpl$Data$declaredNonStaticMembers$2;
        int hashCode = str != null ? str.hashCode() : 0;
        Map<String, Column> map = this.getAuthRequestContext;
        int hashCode2 = map != null ? map.hashCode() : 0;
        Set<ForeignKey> set = this.MyBillsEntityDataFactory;
        return (((hashCode * 31) + hashCode2) * 31) + (set != null ? set.hashCode() : 0);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("TableInfo{name='");
        sb.append(this.KClassImpl$Data$declaredNonStaticMembers$2);
        sb.append('\'');
        sb.append(", columns=");
        sb.append(this.getAuthRequestContext);
        sb.append(", foreignKeys=");
        sb.append(this.MyBillsEntityDataFactory);
        sb.append(", indices=");
        sb.append(this.PlaceComponentResult);
        sb.append('}');
        return sb.toString();
    }

    public static TableInfo BuiltInFictitiousFunctionClassFactory(SupportSQLiteDatabase supportSQLiteDatabase, String str) {
        return new TableInfo(str, getAuthRequestContext(supportSQLiteDatabase, str), MyBillsEntityDataFactory(supportSQLiteDatabase, str), KClassImpl$Data$declaredNonStaticMembers$2(supportSQLiteDatabase, str));
    }

    private static Set<ForeignKey> MyBillsEntityDataFactory(SupportSQLiteDatabase supportSQLiteDatabase, String str) {
        HashSet hashSet = new HashSet();
        StringBuilder sb = new StringBuilder();
        sb.append("PRAGMA foreign_key_list(`");
        sb.append(str);
        sb.append("`)");
        Cursor query = supportSQLiteDatabase.query(sb.toString());
        try {
            int columnIndex = query.getColumnIndex("id");
            int columnIndex2 = query.getColumnIndex("seq");
            int columnIndex3 = query.getColumnIndex("table");
            int columnIndex4 = query.getColumnIndex("on_delete");
            int columnIndex5 = query.getColumnIndex("on_update");
            int columnIndex6 = query.getColumnIndex("id");
            int columnIndex7 = query.getColumnIndex("seq");
            int columnIndex8 = query.getColumnIndex("from");
            int columnIndex9 = query.getColumnIndex(LoginTrackingConstants.LoginParam.TO);
            int count = query.getCount();
            ArrayList<ForeignKeyWithSequence> arrayList = new ArrayList();
            int i = 0;
            while (i < count) {
                query.moveToPosition(i);
                arrayList.add(new ForeignKeyWithSequence(query.getInt(columnIndex6), query.getInt(columnIndex7), query.getString(columnIndex8), query.getString(columnIndex9)));
                i++;
                columnIndex7 = columnIndex7;
                columnIndex6 = columnIndex6;
                columnIndex8 = columnIndex8;
            }
            Collections.sort(arrayList);
            int count2 = query.getCount();
            for (int i2 = 0; i2 < count2; i2++) {
                query.moveToPosition(i2);
                if (query.getInt(columnIndex2) == 0) {
                    int i3 = query.getInt(columnIndex);
                    ArrayList arrayList2 = new ArrayList();
                    ArrayList arrayList3 = new ArrayList();
                    for (ForeignKeyWithSequence foreignKeyWithSequence : arrayList) {
                        if (foreignKeyWithSequence.PlaceComponentResult == i3) {
                            arrayList2.add(foreignKeyWithSequence.KClassImpl$Data$declaredNonStaticMembers$2);
                            arrayList3.add(foreignKeyWithSequence.BuiltInFictitiousFunctionClassFactory);
                        }
                    }
                    hashSet.add(new ForeignKey(query.getString(columnIndex3), query.getString(columnIndex4), query.getString(columnIndex5), arrayList2, arrayList3));
                }
            }
            return hashSet;
        } finally {
            query.close();
        }
    }

    private static Map<String, Column> getAuthRequestContext(SupportSQLiteDatabase supportSQLiteDatabase, String str) {
        StringBuilder sb = new StringBuilder();
        sb.append("PRAGMA table_info(`");
        sb.append(str);
        sb.append("`)");
        Cursor query = supportSQLiteDatabase.query(sb.toString());
        HashMap hashMap = new HashMap();
        try {
            if (query.getColumnCount() > 0) {
                int columnIndex = query.getColumnIndex("name");
                int columnIndex2 = query.getColumnIndex("type");
                int columnIndex3 = query.getColumnIndex("notnull");
                int columnIndex4 = query.getColumnIndex("pk");
                int columnIndex5 = query.getColumnIndex("dflt_value");
                while (query.moveToNext()) {
                    String string = query.getString(columnIndex);
                    hashMap.put(string, new Column(string, query.getString(columnIndex2), query.getInt(columnIndex3) != 0, query.getInt(columnIndex4), query.getString(columnIndex5), 2));
                }
            }
            return hashMap;
        } finally {
            query.close();
        }
    }

    private static Set<Index> KClassImpl$Data$declaredNonStaticMembers$2(SupportSQLiteDatabase supportSQLiteDatabase, String str) {
        StringBuilder sb = new StringBuilder();
        sb.append("PRAGMA index_list(`");
        sb.append(str);
        sb.append("`)");
        Cursor query = supportSQLiteDatabase.query(sb.toString());
        try {
            int columnIndex = query.getColumnIndex("name");
            int columnIndex2 = query.getColumnIndex("origin");
            int columnIndex3 = query.getColumnIndex("unique");
            if (columnIndex == -1 || columnIndex2 == -1 || columnIndex3 == -1) {
                return null;
            }
            HashSet hashSet = new HashSet();
            while (query.moveToNext()) {
                if ("c".equals(query.getString(columnIndex2))) {
                    Index PlaceComponentResult = PlaceComponentResult(supportSQLiteDatabase, query.getString(columnIndex), query.getInt(columnIndex3) == 1);
                    if (PlaceComponentResult == null) {
                        return null;
                    }
                    hashSet.add(PlaceComponentResult);
                }
            }
            return hashSet;
        } finally {
            query.close();
        }
    }

    private static Index PlaceComponentResult(SupportSQLiteDatabase supportSQLiteDatabase, String str, boolean z) {
        StringBuilder sb = new StringBuilder();
        sb.append("PRAGMA index_xinfo(`");
        sb.append(str);
        sb.append("`)");
        Cursor query = supportSQLiteDatabase.query(sb.toString());
        try {
            int columnIndex = query.getColumnIndex("seqno");
            int columnIndex2 = query.getColumnIndex("cid");
            int columnIndex3 = query.getColumnIndex("name");
            int columnIndex4 = query.getColumnIndex("desc");
            if (columnIndex == -1 || columnIndex2 == -1 || columnIndex3 == -1 || columnIndex4 == -1) {
                query.close();
                return null;
            }
            TreeMap treeMap = new TreeMap();
            TreeMap treeMap2 = new TreeMap();
            while (query.moveToNext()) {
                if (query.getInt(columnIndex2) >= 0) {
                    int i = query.getInt(columnIndex);
                    String string = query.getString(columnIndex3);
                    String str2 = query.getInt(columnIndex4) > 0 ? "DESC" : "ASC";
                    treeMap.put(Integer.valueOf(i), string);
                    treeMap2.put(Integer.valueOf(i), str2);
                }
            }
            ArrayList arrayList = new ArrayList(treeMap.size());
            arrayList.addAll(treeMap.values());
            ArrayList arrayList2 = new ArrayList(treeMap2.size());
            arrayList2.addAll(treeMap2.values());
            return new Index(str, z, arrayList, arrayList2);
        } finally {
            query.close();
        }
    }

    /* loaded from: classes6.dex */
    public static final class Column {
        public final String BuiltInFictitiousFunctionClassFactory;
        public final int KClassImpl$Data$declaredNonStaticMembers$2;
        public final String MyBillsEntityDataFactory;
        public final int PlaceComponentResult;
        public final boolean getAuthRequestContext;
        private final int lookAheadTest;
        public final String scheduleImpl;

        @Deprecated
        public Column(String str, String str2, boolean z, int i) {
            this(str, str2, z, i, null, 0);
        }

        public Column(String str, String str2, boolean z, int i, String str3, int i2) {
            this.MyBillsEntityDataFactory = str;
            this.scheduleImpl = str2;
            this.getAuthRequestContext = z;
            this.PlaceComponentResult = i;
            int i3 = 5;
            if (str2 != null) {
                String upperCase = str2.toUpperCase(Locale.US);
                if (upperCase.contains("INT")) {
                    i3 = 3;
                } else if (upperCase.contains("CHAR") || upperCase.contains("CLOB") || upperCase.contains("TEXT")) {
                    i3 = 2;
                } else if (!upperCase.contains("BLOB")) {
                    i3 = (upperCase.contains("REAL") || upperCase.contains("FLOA") || upperCase.contains("DOUB")) ? 4 : 1;
                }
            }
            this.KClassImpl$Data$declaredNonStaticMembers$2 = i3;
            this.BuiltInFictitiousFunctionClassFactory = str3;
            this.lookAheadTest = i2;
        }

        public final boolean equals(Object obj) {
            String str;
            String str2;
            String str3;
            if (this == obj) {
                return true;
            }
            if (obj instanceof Column) {
                Column column = (Column) obj;
                if (Build.VERSION.SDK_INT >= 20) {
                    if (this.PlaceComponentResult != column.PlaceComponentResult) {
                        return false;
                    }
                } else if (MyBillsEntityDataFactory() != column.MyBillsEntityDataFactory()) {
                    return false;
                }
                if (this.MyBillsEntityDataFactory.equals(column.MyBillsEntityDataFactory) && this.getAuthRequestContext == column.getAuthRequestContext) {
                    if (this.lookAheadTest != 1 || column.lookAheadTest != 2 || (str3 = this.BuiltInFictitiousFunctionClassFactory) == null || getAuthRequestContext(str3, column.BuiltInFictitiousFunctionClassFactory)) {
                        if (this.lookAheadTest != 2 || column.lookAheadTest != 1 || (str2 = column.BuiltInFictitiousFunctionClassFactory) == null || getAuthRequestContext(str2, this.BuiltInFictitiousFunctionClassFactory)) {
                            int i = this.lookAheadTest;
                            return (i == 0 || i != column.lookAheadTest || ((str = this.BuiltInFictitiousFunctionClassFactory) == null ? column.BuiltInFictitiousFunctionClassFactory == null : getAuthRequestContext(str, column.BuiltInFictitiousFunctionClassFactory))) && this.KClassImpl$Data$declaredNonStaticMembers$2 == column.KClassImpl$Data$declaredNonStaticMembers$2;
                        }
                        return false;
                    }
                    return false;
                }
                return false;
            }
            return false;
        }

        private static boolean getAuthRequestContext(String str, String str2) {
            if (str2 == null) {
                return false;
            }
            if (str.equals(str2)) {
                return true;
            }
            if (PlaceComponentResult(str)) {
                return str.substring(1, str.length() - 1).trim().equals(str2);
            }
            return false;
        }

        private static boolean PlaceComponentResult(String str) {
            if (str.length() == 0) {
                return false;
            }
            int i = 0;
            for (int i2 = 0; i2 < str.length(); i2++) {
                char charAt = str.charAt(i2);
                if (i2 == 0 && charAt != '(') {
                    return false;
                }
                if (charAt == '(') {
                    i++;
                } else if (charAt == ')' && i - 1 == 0 && i2 != str.length() - 1) {
                    return false;
                }
            }
            return i == 0;
        }

        private boolean MyBillsEntityDataFactory() {
            return this.PlaceComponentResult > 0;
        }

        public final int hashCode() {
            int hashCode = this.MyBillsEntityDataFactory.hashCode();
            return (((((hashCode * 31) + this.KClassImpl$Data$declaredNonStaticMembers$2) * 31) + (this.getAuthRequestContext ? 1231 : 1237)) * 31) + this.PlaceComponentResult;
        }

        public final String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("Column{name='");
            sb.append(this.MyBillsEntityDataFactory);
            sb.append('\'');
            sb.append(", type='");
            sb.append(this.scheduleImpl);
            sb.append('\'');
            sb.append(", affinity='");
            sb.append(this.KClassImpl$Data$declaredNonStaticMembers$2);
            sb.append('\'');
            sb.append(", notNull=");
            sb.append(this.getAuthRequestContext);
            sb.append(", primaryKeyPosition=");
            sb.append(this.PlaceComponentResult);
            sb.append(", defaultValue='");
            sb.append(this.BuiltInFictitiousFunctionClassFactory);
            sb.append('\'');
            sb.append('}');
            return sb.toString();
        }
    }

    /* loaded from: classes6.dex */
    public static final class ForeignKey {
        public final String BuiltInFictitiousFunctionClassFactory;
        public final List<String> KClassImpl$Data$declaredNonStaticMembers$2;
        public final String MyBillsEntityDataFactory;
        public final List<String> PlaceComponentResult;
        public final String getAuthRequestContext;

        public ForeignKey(String str, String str2, String str3, List<String> list, List<String> list2) {
            this.MyBillsEntityDataFactory = str;
            this.getAuthRequestContext = str2;
            this.BuiltInFictitiousFunctionClassFactory = str3;
            this.PlaceComponentResult = Collections.unmodifiableList(list);
            this.KClassImpl$Data$declaredNonStaticMembers$2 = Collections.unmodifiableList(list2);
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof ForeignKey) {
                ForeignKey foreignKey = (ForeignKey) obj;
                if (this.MyBillsEntityDataFactory.equals(foreignKey.MyBillsEntityDataFactory) && this.getAuthRequestContext.equals(foreignKey.getAuthRequestContext) && this.BuiltInFictitiousFunctionClassFactory.equals(foreignKey.BuiltInFictitiousFunctionClassFactory) && this.PlaceComponentResult.equals(foreignKey.PlaceComponentResult)) {
                    return this.KClassImpl$Data$declaredNonStaticMembers$2.equals(foreignKey.KClassImpl$Data$declaredNonStaticMembers$2);
                }
                return false;
            }
            return false;
        }

        public final int hashCode() {
            int hashCode = this.MyBillsEntityDataFactory.hashCode();
            int hashCode2 = this.getAuthRequestContext.hashCode();
            return (((((((hashCode * 31) + hashCode2) * 31) + this.BuiltInFictitiousFunctionClassFactory.hashCode()) * 31) + this.PlaceComponentResult.hashCode()) * 31) + this.KClassImpl$Data$declaredNonStaticMembers$2.hashCode();
        }

        public final String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("ForeignKey{referenceTable='");
            sb.append(this.MyBillsEntityDataFactory);
            sb.append('\'');
            sb.append(", onDelete='");
            sb.append(this.getAuthRequestContext);
            sb.append('\'');
            sb.append(", onUpdate='");
            sb.append(this.BuiltInFictitiousFunctionClassFactory);
            sb.append('\'');
            sb.append(", columnNames=");
            sb.append(this.PlaceComponentResult);
            sb.append(", referenceColumnNames=");
            sb.append(this.KClassImpl$Data$declaredNonStaticMembers$2);
            sb.append('}');
            return sb.toString();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes6.dex */
    public static class ForeignKeyWithSequence implements Comparable<ForeignKeyWithSequence> {
        final String BuiltInFictitiousFunctionClassFactory;
        final String KClassImpl$Data$declaredNonStaticMembers$2;
        final int PlaceComponentResult;
        final int getAuthRequestContext;

        @Override // java.lang.Comparable
        public /* bridge */ /* synthetic */ int compareTo(ForeignKeyWithSequence foreignKeyWithSequence) {
            ForeignKeyWithSequence foreignKeyWithSequence2 = foreignKeyWithSequence;
            int i = this.PlaceComponentResult - foreignKeyWithSequence2.PlaceComponentResult;
            return i == 0 ? this.getAuthRequestContext - foreignKeyWithSequence2.getAuthRequestContext : i;
        }

        ForeignKeyWithSequence(int i, int i2, String str, String str2) {
            this.PlaceComponentResult = i;
            this.getAuthRequestContext = i2;
            this.KClassImpl$Data$declaredNonStaticMembers$2 = str;
            this.BuiltInFictitiousFunctionClassFactory = str2;
        }
    }

    /* loaded from: classes6.dex */
    public static final class Index {
        public final String KClassImpl$Data$declaredNonStaticMembers$2;
        public final boolean MyBillsEntityDataFactory;
        public final List<String> PlaceComponentResult;
        public final List<String> getAuthRequestContext;

        public Index(String str, List<String> list) {
            this(str, false, list, null);
        }

        public Index(String str, boolean z, List<String> list, List<String> list2) {
            this.KClassImpl$Data$declaredNonStaticMembers$2 = str;
            this.MyBillsEntityDataFactory = z;
            this.PlaceComponentResult = list;
            this.getAuthRequestContext = (list2 == null || list2.size() == 0) ? Collections.nCopies(list.size(), Index.Order.ASC.name()) : list2;
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof Index) {
                Index index = (Index) obj;
                if (this.MyBillsEntityDataFactory == index.MyBillsEntityDataFactory && this.PlaceComponentResult.equals(index.PlaceComponentResult) && this.getAuthRequestContext.equals(index.getAuthRequestContext)) {
                    if (this.KClassImpl$Data$declaredNonStaticMembers$2.startsWith("index_")) {
                        return index.KClassImpl$Data$declaredNonStaticMembers$2.startsWith("index_");
                    }
                    return this.KClassImpl$Data$declaredNonStaticMembers$2.equals(index.KClassImpl$Data$declaredNonStaticMembers$2);
                }
                return false;
            }
            return false;
        }

        public final int hashCode() {
            return ((((((this.KClassImpl$Data$declaredNonStaticMembers$2.startsWith("index_") ? -1184239155 : this.KClassImpl$Data$declaredNonStaticMembers$2.hashCode()) * 31) + (this.MyBillsEntityDataFactory ? 1 : 0)) * 31) + this.PlaceComponentResult.hashCode()) * 31) + this.getAuthRequestContext.hashCode();
        }

        public final String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("Index{name='");
            sb.append(this.KClassImpl$Data$declaredNonStaticMembers$2);
            sb.append('\'');
            sb.append(", unique=");
            sb.append(this.MyBillsEntityDataFactory);
            sb.append(", columns=");
            sb.append(this.PlaceComponentResult);
            sb.append(", orders=");
            sb.append(this.getAuthRequestContext);
            sb.append('}');
            return sb.toString();
        }
    }
}
