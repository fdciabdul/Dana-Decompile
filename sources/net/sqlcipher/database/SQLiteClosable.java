package net.sqlcipher.database;

/* loaded from: classes6.dex */
public abstract class SQLiteClosable {
    private int mReferenceCount = 1;
    private Object mLock = new Object();

    protected abstract void onAllReferencesReleased();

    /* JADX INFO: Access modifiers changed from: protected */
    public void onAllReferencesReleasedFromContainer() {
    }

    public void acquireReference() {
        synchronized (this.mLock) {
            int i = this.mReferenceCount;
            if (i <= 0) {
                StringBuilder sb = new StringBuilder();
                sb.append("attempt to re-open an already-closed object: ");
                sb.append(getObjInfo());
                throw new IllegalStateException(sb.toString());
            }
            this.mReferenceCount = i + 1;
        }
    }

    public void releaseReference() {
        synchronized (this.mLock) {
            int i = this.mReferenceCount - 1;
            this.mReferenceCount = i;
            if (i == 0) {
                onAllReferencesReleased();
            }
        }
    }

    public void releaseReferenceFromContainer() {
        synchronized (this.mLock) {
            int i = this.mReferenceCount - 1;
            this.mReferenceCount = i;
            if (i == 0) {
                onAllReferencesReleasedFromContainer();
            }
        }
    }

    private String getObjInfo() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getName());
        sb.append(" (");
        if (this instanceof SQLiteDatabase) {
            sb.append("database = ");
            sb.append(((SQLiteDatabase) this).getPath());
        } else if ((this instanceof SQLiteProgram) || (this instanceof SQLiteStatement) || (this instanceof SQLiteQuery)) {
            sb.append("mSql = ");
            sb.append(((SQLiteProgram) this).mSql);
        }
        sb.append(") ");
        return sb.toString();
    }
}
