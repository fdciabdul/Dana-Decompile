package androidx.room;

import androidx.arch.core.util.Function;
import androidx.room.AutoClosingRoomOpenHelper;
import androidx.sqlite.db.SupportSQLiteDatabase;

/* loaded from: classes3.dex */
public final /* synthetic */ class AutoClosingRoomOpenHelper$AutoClosingSupportSQLiteDatabase$$ExternalSyntheticLambda1 implements Function {
    @Override // androidx.arch.core.util.Function
    public final Object getAuthRequestContext(Object obj) {
        SupportSQLiteDatabase supportSQLiteDatabase = (SupportSQLiteDatabase) obj;
        return AutoClosingRoomOpenHelper.AutoClosingSupportSQLiteDatabase.getAuthRequestContext();
    }
}
