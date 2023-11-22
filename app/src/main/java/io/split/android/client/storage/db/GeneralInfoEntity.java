package io.split.android.client.storage.db;

/* loaded from: classes6.dex */
public class GeneralInfoEntity {
    public static final String CHANGE_NUMBER_INFO = "splitChangesChangeNumber";
    public static final String DATABASE_ENCRYPTION_MODE = "databaseEncryptionMode";
    public static final String DATBASE_MIGRATION_STATUS = "databaseMigrationStatus";
    public static final int DATBASE_MIGRATION_STATUS_DONE = 1;
    public static final String SPLITS_FILTER_QUERY_STRING = "splitsFilterQueryString";
    public static final String SPLITS_UPDATE_TIMESTAMP = "splitsUpdateTimestamp";
    private long longValue;
    private String name;
    private String stringValue;
    private long updatedAt;

    public GeneralInfoEntity() {
    }

    public GeneralInfoEntity(String str, String str2) {
        this.name = str;
        this.stringValue = str2;
    }

    public GeneralInfoEntity(String str, long j) {
        this.name = str;
        this.longValue = j;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String str) {
        this.name = str;
    }

    public String getStringValue() {
        return this.stringValue;
    }

    public void setStringValue(String str) {
        this.stringValue = str;
    }

    public long getLongValue() {
        return this.longValue;
    }

    public void setLongValue(long j) {
        this.longValue = j;
    }

    public long getUpdatedAt() {
        return this.updatedAt;
    }

    public void setUpdatedAt(long j) {
        this.updatedAt = j;
    }
}
