package androidx.work.impl.model;

import android.database.Cursor;
import androidx.collection.ArrayMap;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.room.util.StringUtil;
import androidx.sqlite.db.SupportSQLiteQuery;
import androidx.work.Data;
import androidx.work.impl.model.WorkSpec;
import com.alibaba.ariver.remotedebug.utils.TinyAppLogUtil;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.Callable;

/* loaded from: classes6.dex */
public final class RawWorkInfoDao_Impl implements RawWorkInfoDao {
    private final RoomDatabase PlaceComponentResult;

    public RawWorkInfoDao_Impl(RoomDatabase roomDatabase) {
        this.PlaceComponentResult = roomDatabase;
    }

    @Override // androidx.work.impl.model.RawWorkInfoDao
    public final List<WorkSpec.WorkInfoPojo> getAuthRequestContext(SupportSQLiteQuery supportSQLiteQuery) {
        this.PlaceComponentResult.assertNotSuspendingTransaction();
        Cursor KClassImpl$Data$declaredNonStaticMembers$2 = DBUtil.KClassImpl$Data$declaredNonStaticMembers$2(this.PlaceComponentResult, supportSQLiteQuery, true);
        try {
            int KClassImpl$Data$declaredNonStaticMembers$22 = CursorUtil.KClassImpl$Data$declaredNonStaticMembers$2(KClassImpl$Data$declaredNonStaticMembers$2, "id");
            int KClassImpl$Data$declaredNonStaticMembers$23 = CursorUtil.KClassImpl$Data$declaredNonStaticMembers$2(KClassImpl$Data$declaredNonStaticMembers$2, "state");
            int KClassImpl$Data$declaredNonStaticMembers$24 = CursorUtil.KClassImpl$Data$declaredNonStaticMembers$2(KClassImpl$Data$declaredNonStaticMembers$2, TinyAppLogUtil.TINY_APP_STANDARD_OUTPUT);
            int KClassImpl$Data$declaredNonStaticMembers$25 = CursorUtil.KClassImpl$Data$declaredNonStaticMembers$2(KClassImpl$Data$declaredNonStaticMembers$2, "run_attempt_count");
            ArrayMap<String, ArrayList<String>> arrayMap = new ArrayMap<>();
            ArrayMap<String, ArrayList<Data>> arrayMap2 = new ArrayMap<>();
            while (KClassImpl$Data$declaredNonStaticMembers$2.moveToNext()) {
                if (!KClassImpl$Data$declaredNonStaticMembers$2.isNull(KClassImpl$Data$declaredNonStaticMembers$22)) {
                    String string = KClassImpl$Data$declaredNonStaticMembers$2.getString(KClassImpl$Data$declaredNonStaticMembers$22);
                    if (arrayMap.get(string) == null) {
                        arrayMap.put(string, new ArrayList<>());
                    }
                }
                if (!KClassImpl$Data$declaredNonStaticMembers$2.isNull(KClassImpl$Data$declaredNonStaticMembers$22)) {
                    String string2 = KClassImpl$Data$declaredNonStaticMembers$2.getString(KClassImpl$Data$declaredNonStaticMembers$22);
                    if (arrayMap2.get(string2) == null) {
                        arrayMap2.put(string2, new ArrayList<>());
                    }
                }
            }
            KClassImpl$Data$declaredNonStaticMembers$2.moveToPosition(-1);
            getAuthRequestContext(arrayMap);
            PlaceComponentResult(arrayMap2);
            ArrayList arrayList = new ArrayList(KClassImpl$Data$declaredNonStaticMembers$2.getCount());
            while (KClassImpl$Data$declaredNonStaticMembers$2.moveToNext()) {
                ArrayList<String> arrayList2 = !KClassImpl$Data$declaredNonStaticMembers$2.isNull(KClassImpl$Data$declaredNonStaticMembers$22) ? arrayMap.get(KClassImpl$Data$declaredNonStaticMembers$2.getString(KClassImpl$Data$declaredNonStaticMembers$22)) : null;
                if (arrayList2 == null) {
                    arrayList2 = new ArrayList<>();
                }
                ArrayList<Data> arrayList3 = KClassImpl$Data$declaredNonStaticMembers$2.isNull(KClassImpl$Data$declaredNonStaticMembers$22) ? null : arrayMap2.get(KClassImpl$Data$declaredNonStaticMembers$2.getString(KClassImpl$Data$declaredNonStaticMembers$22));
                if (arrayList3 == null) {
                    arrayList3 = new ArrayList<>();
                }
                WorkSpec.WorkInfoPojo workInfoPojo = new WorkSpec.WorkInfoPojo();
                if (KClassImpl$Data$declaredNonStaticMembers$22 != -1) {
                    workInfoPojo.KClassImpl$Data$declaredNonStaticMembers$2 = KClassImpl$Data$declaredNonStaticMembers$2.getString(KClassImpl$Data$declaredNonStaticMembers$22);
                }
                if (KClassImpl$Data$declaredNonStaticMembers$23 != -1) {
                    workInfoPojo.BuiltInFictitiousFunctionClassFactory = WorkTypeConverters.PlaceComponentResult(KClassImpl$Data$declaredNonStaticMembers$2.getInt(KClassImpl$Data$declaredNonStaticMembers$23));
                }
                if (KClassImpl$Data$declaredNonStaticMembers$24 != -1) {
                    workInfoPojo.PlaceComponentResult = Data.MyBillsEntityDataFactory(KClassImpl$Data$declaredNonStaticMembers$2.getBlob(KClassImpl$Data$declaredNonStaticMembers$24));
                }
                if (KClassImpl$Data$declaredNonStaticMembers$25 != -1) {
                    workInfoPojo.MyBillsEntityDataFactory = KClassImpl$Data$declaredNonStaticMembers$2.getInt(KClassImpl$Data$declaredNonStaticMembers$25);
                }
                workInfoPojo.scheduleImpl = arrayList2;
                workInfoPojo.getAuthRequestContext = arrayList3;
                arrayList.add(workInfoPojo);
            }
            return arrayList;
        } finally {
            KClassImpl$Data$declaredNonStaticMembers$2.close();
        }
    }

    /* renamed from: androidx.work.impl.model.RawWorkInfoDao_Impl$1  reason: invalid class name */
    /* loaded from: classes6.dex */
    class AnonymousClass1 implements Callable<List<WorkSpec.WorkInfoPojo>> {
        final /* synthetic */ RawWorkInfoDao_Impl PlaceComponentResult;
        final /* synthetic */ SupportSQLiteQuery getAuthRequestContext;

        /* JADX INFO: Access modifiers changed from: private */
        @Override // java.util.concurrent.Callable
        /* renamed from: getAuthRequestContext  reason: merged with bridge method [inline-methods] */
        public List<WorkSpec.WorkInfoPojo> call() throws Exception {
            Cursor KClassImpl$Data$declaredNonStaticMembers$2 = DBUtil.KClassImpl$Data$declaredNonStaticMembers$2(this.PlaceComponentResult.PlaceComponentResult, this.getAuthRequestContext, true);
            try {
                int KClassImpl$Data$declaredNonStaticMembers$22 = CursorUtil.KClassImpl$Data$declaredNonStaticMembers$2(KClassImpl$Data$declaredNonStaticMembers$2, "id");
                int KClassImpl$Data$declaredNonStaticMembers$23 = CursorUtil.KClassImpl$Data$declaredNonStaticMembers$2(KClassImpl$Data$declaredNonStaticMembers$2, "state");
                int KClassImpl$Data$declaredNonStaticMembers$24 = CursorUtil.KClassImpl$Data$declaredNonStaticMembers$2(KClassImpl$Data$declaredNonStaticMembers$2, TinyAppLogUtil.TINY_APP_STANDARD_OUTPUT);
                int KClassImpl$Data$declaredNonStaticMembers$25 = CursorUtil.KClassImpl$Data$declaredNonStaticMembers$2(KClassImpl$Data$declaredNonStaticMembers$2, "run_attempt_count");
                ArrayMap arrayMap = new ArrayMap();
                ArrayMap arrayMap2 = new ArrayMap();
                while (KClassImpl$Data$declaredNonStaticMembers$2.moveToNext()) {
                    if (!KClassImpl$Data$declaredNonStaticMembers$2.isNull(KClassImpl$Data$declaredNonStaticMembers$22)) {
                        String string = KClassImpl$Data$declaredNonStaticMembers$2.getString(KClassImpl$Data$declaredNonStaticMembers$22);
                        if (((ArrayList) arrayMap.get(string)) == null) {
                            arrayMap.put(string, new ArrayList());
                        }
                    }
                    if (!KClassImpl$Data$declaredNonStaticMembers$2.isNull(KClassImpl$Data$declaredNonStaticMembers$22)) {
                        String string2 = KClassImpl$Data$declaredNonStaticMembers$2.getString(KClassImpl$Data$declaredNonStaticMembers$22);
                        if (((ArrayList) arrayMap2.get(string2)) == null) {
                            arrayMap2.put(string2, new ArrayList());
                        }
                    }
                }
                KClassImpl$Data$declaredNonStaticMembers$2.moveToPosition(-1);
                this.PlaceComponentResult.getAuthRequestContext(arrayMap);
                this.PlaceComponentResult.PlaceComponentResult(arrayMap2);
                ArrayList arrayList = new ArrayList(KClassImpl$Data$declaredNonStaticMembers$2.getCount());
                while (KClassImpl$Data$declaredNonStaticMembers$2.moveToNext()) {
                    ArrayList arrayList2 = !KClassImpl$Data$declaredNonStaticMembers$2.isNull(KClassImpl$Data$declaredNonStaticMembers$22) ? (ArrayList) arrayMap.get(KClassImpl$Data$declaredNonStaticMembers$2.getString(KClassImpl$Data$declaredNonStaticMembers$22)) : null;
                    if (arrayList2 == null) {
                        arrayList2 = new ArrayList();
                    }
                    ArrayList arrayList3 = KClassImpl$Data$declaredNonStaticMembers$2.isNull(KClassImpl$Data$declaredNonStaticMembers$22) ? null : (ArrayList) arrayMap2.get(KClassImpl$Data$declaredNonStaticMembers$2.getString(KClassImpl$Data$declaredNonStaticMembers$22));
                    if (arrayList3 == null) {
                        arrayList3 = new ArrayList();
                    }
                    WorkSpec.WorkInfoPojo workInfoPojo = new WorkSpec.WorkInfoPojo();
                    if (KClassImpl$Data$declaredNonStaticMembers$22 != -1) {
                        workInfoPojo.KClassImpl$Data$declaredNonStaticMembers$2 = KClassImpl$Data$declaredNonStaticMembers$2.getString(KClassImpl$Data$declaredNonStaticMembers$22);
                    }
                    if (KClassImpl$Data$declaredNonStaticMembers$23 != -1) {
                        workInfoPojo.BuiltInFictitiousFunctionClassFactory = WorkTypeConverters.PlaceComponentResult(KClassImpl$Data$declaredNonStaticMembers$2.getInt(KClassImpl$Data$declaredNonStaticMembers$23));
                    }
                    if (KClassImpl$Data$declaredNonStaticMembers$24 != -1) {
                        workInfoPojo.PlaceComponentResult = Data.MyBillsEntityDataFactory(KClassImpl$Data$declaredNonStaticMembers$2.getBlob(KClassImpl$Data$declaredNonStaticMembers$24));
                    }
                    if (KClassImpl$Data$declaredNonStaticMembers$25 != -1) {
                        workInfoPojo.MyBillsEntityDataFactory = KClassImpl$Data$declaredNonStaticMembers$2.getInt(KClassImpl$Data$declaredNonStaticMembers$25);
                    }
                    workInfoPojo.scheduleImpl = arrayList2;
                    workInfoPojo.getAuthRequestContext = arrayList3;
                    arrayList.add(workInfoPojo);
                }
                return arrayList;
            } finally {
                KClassImpl$Data$declaredNonStaticMembers$2.close();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void getAuthRequestContext(ArrayMap<String, ArrayList<String>> arrayMap) {
        ArrayList<String> arrayList;
        int i;
        while (true) {
            Set<String> keySet = arrayMap.keySet();
            if (keySet.isEmpty()) {
                return;
            }
            int i2 = 1;
            if (arrayMap.size() > 999) {
                ArrayMap<String, ArrayList<String>> arrayMap2 = new ArrayMap<>(999);
                int size = arrayMap.size();
                int i3 = 0;
                while (true) {
                    i = 0;
                    while (i3 < size) {
                        int i4 = i3 << 1;
                        arrayMap2.put((String) arrayMap.moveToNextValue[i4], (ArrayList) arrayMap.moveToNextValue[i4 + 1]);
                        i3++;
                        i++;
                        if (i == 999) {
                            break;
                        }
                    }
                    getAuthRequestContext(arrayMap2);
                    arrayMap2 = new ArrayMap<>(999);
                }
                if (i <= 0) {
                    return;
                }
                arrayMap = arrayMap2;
            } else {
                StringBuilder KClassImpl$Data$declaredNonStaticMembers$2 = StringUtil.KClassImpl$Data$declaredNonStaticMembers$2();
                KClassImpl$Data$declaredNonStaticMembers$2.append("SELECT `tag`,`work_spec_id` FROM `WorkTag` WHERE `work_spec_id` IN (");
                int size2 = keySet.size();
                StringUtil.PlaceComponentResult(KClassImpl$Data$declaredNonStaticMembers$2, size2);
                KClassImpl$Data$declaredNonStaticMembers$2.append(")");
                RoomSQLiteQuery authRequestContext = RoomSQLiteQuery.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$2.toString(), size2 + 0);
                for (String str : keySet) {
                    if (str == null) {
                        authRequestContext.bindNull(i2);
                    } else {
                        authRequestContext.bindString(i2, str);
                    }
                    i2++;
                }
                Cursor KClassImpl$Data$declaredNonStaticMembers$22 = DBUtil.KClassImpl$Data$declaredNonStaticMembers$2(this.PlaceComponentResult, authRequestContext, false);
                try {
                    int KClassImpl$Data$declaredNonStaticMembers$23 = CursorUtil.KClassImpl$Data$declaredNonStaticMembers$2(KClassImpl$Data$declaredNonStaticMembers$22, "work_spec_id");
                    if (KClassImpl$Data$declaredNonStaticMembers$23 == -1) {
                        return;
                    }
                    while (KClassImpl$Data$declaredNonStaticMembers$22.moveToNext()) {
                        if (!KClassImpl$Data$declaredNonStaticMembers$22.isNull(KClassImpl$Data$declaredNonStaticMembers$23) && (arrayList = arrayMap.get(KClassImpl$Data$declaredNonStaticMembers$22.getString(KClassImpl$Data$declaredNonStaticMembers$23))) != null) {
                            arrayList.add(KClassImpl$Data$declaredNonStaticMembers$22.getString(0));
                        }
                    }
                    return;
                } finally {
                    KClassImpl$Data$declaredNonStaticMembers$22.close();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void PlaceComponentResult(ArrayMap<String, ArrayList<Data>> arrayMap) {
        ArrayList<Data> arrayList;
        int i;
        while (true) {
            Set<String> keySet = arrayMap.keySet();
            if (keySet.isEmpty()) {
                return;
            }
            int i2 = 1;
            if (arrayMap.size() > 999) {
                ArrayMap<String, ArrayList<Data>> arrayMap2 = new ArrayMap<>(999);
                int size = arrayMap.size();
                int i3 = 0;
                while (true) {
                    i = 0;
                    while (i3 < size) {
                        int i4 = i3 << 1;
                        arrayMap2.put((String) arrayMap.moveToNextValue[i4], (ArrayList) arrayMap.moveToNextValue[i4 + 1]);
                        i3++;
                        i++;
                        if (i == 999) {
                            break;
                        }
                    }
                    PlaceComponentResult(arrayMap2);
                    arrayMap2 = new ArrayMap<>(999);
                }
                if (i <= 0) {
                    return;
                }
                arrayMap = arrayMap2;
            } else {
                StringBuilder KClassImpl$Data$declaredNonStaticMembers$2 = StringUtil.KClassImpl$Data$declaredNonStaticMembers$2();
                KClassImpl$Data$declaredNonStaticMembers$2.append("SELECT `progress`,`work_spec_id` FROM `WorkProgress` WHERE `work_spec_id` IN (");
                int size2 = keySet.size();
                StringUtil.PlaceComponentResult(KClassImpl$Data$declaredNonStaticMembers$2, size2);
                KClassImpl$Data$declaredNonStaticMembers$2.append(")");
                RoomSQLiteQuery authRequestContext = RoomSQLiteQuery.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$2.toString(), size2 + 0);
                for (String str : keySet) {
                    if (str == null) {
                        authRequestContext.bindNull(i2);
                    } else {
                        authRequestContext.bindString(i2, str);
                    }
                    i2++;
                }
                Cursor KClassImpl$Data$declaredNonStaticMembers$22 = DBUtil.KClassImpl$Data$declaredNonStaticMembers$2(this.PlaceComponentResult, authRequestContext, false);
                try {
                    int KClassImpl$Data$declaredNonStaticMembers$23 = CursorUtil.KClassImpl$Data$declaredNonStaticMembers$2(KClassImpl$Data$declaredNonStaticMembers$22, "work_spec_id");
                    if (KClassImpl$Data$declaredNonStaticMembers$23 == -1) {
                        return;
                    }
                    while (KClassImpl$Data$declaredNonStaticMembers$22.moveToNext()) {
                        if (!KClassImpl$Data$declaredNonStaticMembers$22.isNull(KClassImpl$Data$declaredNonStaticMembers$23) && (arrayList = arrayMap.get(KClassImpl$Data$declaredNonStaticMembers$22.getString(KClassImpl$Data$declaredNonStaticMembers$23))) != null) {
                            arrayList.add(Data.MyBillsEntityDataFactory(KClassImpl$Data$declaredNonStaticMembers$22.getBlob(0)));
                        }
                    }
                    return;
                } finally {
                    KClassImpl$Data$declaredNonStaticMembers$22.close();
                }
            }
        }
    }
}
