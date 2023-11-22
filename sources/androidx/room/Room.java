package androidx.room;

import android.content.Context;
import androidx.room.RoomDatabase;

/* loaded from: classes3.dex */
public class Room {
    public static <T extends RoomDatabase> RoomDatabase.Builder<T> KClassImpl$Data$declaredNonStaticMembers$2(Context context, Class<T> cls, String str) {
        if (str == null || str.trim().length() == 0) {
            throw new IllegalArgumentException("Cannot build a database with null or empty name. If you are trying to create an in memory database, use Room.inMemoryDatabaseBuilder");
        }
        return new RoomDatabase.Builder<>(context, cls, str);
    }

    public static <T extends RoomDatabase> RoomDatabase.Builder<T> KClassImpl$Data$declaredNonStaticMembers$2(Context context, Class<T> cls) {
        return new RoomDatabase.Builder<>(context, cls, null);
    }

    public static <T, C> T MyBillsEntityDataFactory(Class<C> cls, String str) {
        String obj;
        String name = cls.getPackage().getName();
        String canonicalName = cls.getCanonicalName();
        if (!name.isEmpty()) {
            canonicalName = canonicalName.substring(name.length() + 1);
        }
        StringBuilder sb = new StringBuilder();
        sb.append(canonicalName.replace('.', '_'));
        sb.append(str);
        String obj2 = sb.toString();
        try {
            if (name.isEmpty()) {
                obj = obj2;
            } else {
                StringBuilder sb2 = new StringBuilder();
                sb2.append(name);
                sb2.append(".");
                sb2.append(obj2);
                obj = sb2.toString();
            }
            return (T) Class.forName(obj, true, cls.getClassLoader()).newInstance();
        } catch (ClassNotFoundException unused) {
            StringBuilder sb3 = new StringBuilder();
            sb3.append("cannot find implementation for ");
            sb3.append(cls.getCanonicalName());
            sb3.append(". ");
            sb3.append(obj2);
            sb3.append(" does not exist");
            throw new RuntimeException(sb3.toString());
        } catch (IllegalAccessException unused2) {
            StringBuilder sb4 = new StringBuilder();
            sb4.append("Cannot access the constructor");
            sb4.append(cls.getCanonicalName());
            throw new RuntimeException(sb4.toString());
        } catch (InstantiationException unused3) {
            StringBuilder sb5 = new StringBuilder();
            sb5.append("Failed to create an instance of ");
            sb5.append(cls.getCanonicalName());
            throw new RuntimeException(sb5.toString());
        }
    }

    @Deprecated
    public Room() {
    }
}
