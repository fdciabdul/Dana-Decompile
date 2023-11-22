package androidx.work.impl.utils;

import androidx.sqlite.db.SimpleSQLiteQuery;
import androidx.sqlite.db.SupportSQLiteQuery;
import androidx.work.WorkInfo;
import androidx.work.WorkQuery;
import androidx.work.impl.model.WorkTypeConverters;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;

/* loaded from: classes6.dex */
public final class RawQueries {
    private RawQueries() {
    }

    public static SupportSQLiteQuery BuiltInFictitiousFunctionClassFactory(WorkQuery workQuery) {
        ArrayList arrayList = new ArrayList();
        StringBuilder sb = new StringBuilder("SELECT * FROM workspec");
        List<WorkInfo.State> list = workQuery.getAuthRequestContext;
        String str = " WHERE";
        String str2 = " AND";
        if (!list.isEmpty()) {
            ArrayList arrayList2 = new ArrayList(list.size());
            Iterator<WorkInfo.State> it = list.iterator();
            while (it.hasNext()) {
                arrayList2.add(Integer.valueOf(WorkTypeConverters.getAuthRequestContext(it.next())));
            }
            sb.append(" WHERE");
            sb.append(" state IN (");
            getAuthRequestContext(sb, arrayList2.size());
            sb.append(")");
            arrayList.addAll(arrayList2);
            str = " AND";
        }
        List<UUID> list2 = workQuery.PlaceComponentResult;
        if (!list2.isEmpty()) {
            ArrayList arrayList3 = new ArrayList(list2.size());
            Iterator<UUID> it2 = list2.iterator();
            while (it2.hasNext()) {
                arrayList3.add(it2.next().toString());
            }
            sb.append(str);
            sb.append(" id IN (");
            getAuthRequestContext(sb, list2.size());
            sb.append(")");
            arrayList.addAll(arrayList3);
            str = " AND";
        }
        List<String> list3 = workQuery.MyBillsEntityDataFactory;
        if (list3.isEmpty()) {
            str2 = str;
        } else {
            sb.append(str);
            sb.append(" id IN (SELECT work_spec_id FROM worktag WHERE tag IN (");
            getAuthRequestContext(sb, list3.size());
            sb.append("))");
            arrayList.addAll(list3);
        }
        List<String> list4 = workQuery.KClassImpl$Data$declaredNonStaticMembers$2;
        if (!list4.isEmpty()) {
            sb.append(str2);
            sb.append(" id IN (SELECT work_spec_id FROM workname WHERE name IN (");
            getAuthRequestContext(sb, list4.size());
            sb.append("))");
            arrayList.addAll(list4);
        }
        sb.append(";");
        return new SimpleSQLiteQuery(sb.toString(), arrayList.toArray());
    }

    private static void getAuthRequestContext(StringBuilder sb, int i) {
        if (i <= 0) {
            return;
        }
        sb.append("?");
        for (int i2 = 1; i2 < i; i2++) {
            sb.append(",");
            sb.append("?");
        }
    }
}
