package androidx.room;

import androidx.sqlite.db.SupportSQLiteOpenHelper;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes3.dex */
public final class AutoClosingRoomOpenHelperFactory implements SupportSQLiteOpenHelper.Factory {
    private final SupportSQLiteOpenHelper.Factory KClassImpl$Data$declaredNonStaticMembers$2;
    private final AutoCloser MyBillsEntityDataFactory;

    /* JADX INFO: Access modifiers changed from: package-private */
    public AutoClosingRoomOpenHelperFactory(SupportSQLiteOpenHelper.Factory factory, AutoCloser autoCloser) {
        this.KClassImpl$Data$declaredNonStaticMembers$2 = factory;
        this.MyBillsEntityDataFactory = autoCloser;
    }

    @Override // androidx.sqlite.db.SupportSQLiteOpenHelper.Factory
    public final /* synthetic */ SupportSQLiteOpenHelper create(SupportSQLiteOpenHelper.Configuration configuration) {
        return new AutoClosingRoomOpenHelper(this.KClassImpl$Data$declaredNonStaticMembers$2.create(configuration), this.MyBillsEntityDataFactory);
    }
}
