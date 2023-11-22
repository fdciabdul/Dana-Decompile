package com.huawei.hms.common.sqlite;

import android.database.AbstractWindowedCursor;
import android.database.CrossProcessCursor;
import android.database.Cursor;
import android.database.CursorWindow;
import android.database.CursorWrapper;

/* loaded from: classes7.dex */
public class HMSCursorWrapper extends CursorWrapper implements CrossProcessCursor {
    private AbstractWindowedCursor mCursor;

    public HMSCursorWrapper(Cursor cursor) {
        super(cursor);
        if (cursor != null) {
            if (cursor instanceof CursorWrapper) {
                Cursor wrappedCursor = ((CursorWrapper) cursor).getWrappedCursor();
                if (wrappedCursor != null) {
                    if (wrappedCursor instanceof AbstractWindowedCursor) {
                        this.mCursor = (AbstractWindowedCursor) wrappedCursor;
                        return;
                    }
                    StringBuilder sb = new StringBuilder();
                    sb.append("getWrappedCursor:");
                    sb.append(wrappedCursor);
                    sb.append(" is not a subclass for CursorWrapper");
                    throw new IllegalArgumentException(sb.toString());
                }
                throw new IllegalArgumentException("getWrappedCursor cannot be null");
            }
            StringBuilder sb2 = new StringBuilder();
            sb2.append("cursor:");
            sb2.append(cursor);
            sb2.append(" is not a subclass for CursorWrapper");
            throw new IllegalArgumentException(sb2.toString());
        }
        throw new IllegalArgumentException("cursor cannot be null");
    }

    @Override // android.database.CrossProcessCursor
    public void fillWindow(int i, CursorWindow cursorWindow) {
        this.mCursor.fillWindow(i, cursorWindow);
    }

    @Override // android.database.CrossProcessCursor
    public CursorWindow getWindow() {
        return this.mCursor.getWindow();
    }

    @Override // android.database.CursorWrapper
    public Cursor getWrappedCursor() {
        return this.mCursor;
    }

    @Override // android.database.CrossProcessCursor
    public boolean onMove(int i, int i2) {
        return this.mCursor.onMove(i, i2);
    }

    public void setWindow(CursorWindow cursorWindow) {
        this.mCursor.setWindow(cursorWindow);
    }
}
