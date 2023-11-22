package io.split.android.client.storage.db;

import android.content.Context;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import com.google.common.base.Preconditions;
import io.split.android.client.storage.db.attributes.AttributesDao;
import io.split.android.client.storage.db.impressions.unique.UniqueKeysDao;
import j$.util.concurrent.ConcurrentHashMap;
import java.util.Map;

/* loaded from: classes6.dex */
public abstract class SplitRoomDatabase extends RoomDatabase {
    private static volatile Map<String, SplitRoomDatabase> mInstances = new ConcurrentHashMap();
    private volatile SplitQueryDao mSplitQueryDao;

    public abstract AttributesDao attributesDao();

    public abstract EventDao eventDao();

    public abstract GeneralInfoDao generalInfoDao();

    public abstract ImpressionDao impressionDao();

    public abstract ImpressionsCountDao impressionsCountDao();

    public abstract MySegmentDao mySegmentDao();

    public abstract SplitDao splitDao();

    public abstract UniqueKeysDao uniqueKeysDao();

    public static SplitRoomDatabase getDatabase(Context context, String str) {
        SplitRoomDatabase splitRoomDatabase;
        Preconditions.checkNotNull(context);
        Preconditions.checkNotNull(str);
        Preconditions.checkArgument(!str.isEmpty());
        synchronized (SplitRoomDatabase.class) {
            splitRoomDatabase = mInstances.get(str);
            if (splitRoomDatabase == null) {
                RoomDatabase.Builder KClassImpl$Data$declaredNonStaticMembers$2 = Room.KClassImpl$Data$declaredNonStaticMembers$2(context.getApplicationContext(), SplitRoomDatabase.class, str);
                KClassImpl$Data$declaredNonStaticMembers$2.MyBillsEntityDataFactory = RoomDatabase.JournalMode.TRUNCATE;
                KClassImpl$Data$declaredNonStaticMembers$2.moveToNextValue = false;
                KClassImpl$Data$declaredNonStaticMembers$2.getAuthRequestContext = true;
                splitRoomDatabase = (SplitRoomDatabase) KClassImpl$Data$declaredNonStaticMembers$2.BuiltInFictitiousFunctionClassFactory();
                mInstances.put(str, splitRoomDatabase);
            }
        }
        return splitRoomDatabase;
    }

    public SplitQueryDao splitQueryDao() {
        SplitQueryDao splitQueryDao;
        if (this.mSplitQueryDao != null) {
            return this.mSplitQueryDao;
        }
        synchronized (this) {
            this.mSplitQueryDao = new SplitQueryDaoImpl(this);
            splitQueryDao = this.mSplitQueryDao;
        }
        return splitQueryDao;
    }
}
