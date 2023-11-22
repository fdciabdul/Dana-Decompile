package androidx.work.impl.model;

import androidx.sqlite.db.SupportSQLiteQuery;
import androidx.work.impl.model.WorkSpec;
import java.util.List;

/* loaded from: classes6.dex */
public interface RawWorkInfoDao {
    List<WorkSpec.WorkInfoPojo> getAuthRequestContext(SupportSQLiteQuery supportSQLiteQuery);
}
