package androidx.cursoradapter.widget;

import android.content.Context;
import android.database.ContentObserver;
import android.database.Cursor;
import android.database.DataSetObserver;
import android.os.Handler;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Filter;
import android.widget.FilterQueryProvider;
import android.widget.Filterable;
import androidx.cursoradapter.widget.CursorFilter;
import com.j256.ormlite.field.FieldType;

/* loaded from: classes6.dex */
public abstract class CursorAdapter extends BaseAdapter implements Filterable, CursorFilter.CursorFilterClient {
    protected FilterQueryProvider NetworkUserEntityData$$ExternalSyntheticLambda0;
    protected Context PlaceComponentResult;
    protected CursorFilter scheduleImpl;
    protected boolean KClassImpl$Data$declaredNonStaticMembers$2 = true;
    protected Cursor MyBillsEntityDataFactory = null;
    protected boolean getErrorConfigVersion = false;
    protected int lookAheadTest = -1;
    protected ChangeObserver BuiltInFictitiousFunctionClassFactory = new ChangeObserver();
    protected DataSetObserver moveToNextValue = new MyDataSetObserver();

    public abstract void MyBillsEntityDataFactory(View view, Cursor cursor);

    public abstract View PlaceComponentResult(Context context, Cursor cursor, ViewGroup viewGroup);

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public boolean hasStableIds() {
        return true;
    }

    public CursorAdapter(Context context) {
        this.PlaceComponentResult = context;
    }

    @Override // androidx.cursoradapter.widget.CursorFilter.CursorFilterClient
    public final Cursor BuiltInFictitiousFunctionClassFactory() {
        return this.MyBillsEntityDataFactory;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        Cursor cursor;
        if (!this.getErrorConfigVersion || (cursor = this.MyBillsEntityDataFactory) == null) {
            return 0;
        }
        return cursor.getCount();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        Cursor cursor;
        if (!this.getErrorConfigVersion || (cursor = this.MyBillsEntityDataFactory) == null) {
            return null;
        }
        cursor.moveToPosition(i);
        return this.MyBillsEntityDataFactory;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        Cursor cursor;
        if (this.getErrorConfigVersion && (cursor = this.MyBillsEntityDataFactory) != null && cursor.moveToPosition(i)) {
            return this.MyBillsEntityDataFactory.getLong(this.lookAheadTest);
        }
        return 0L;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        if (!this.getErrorConfigVersion) {
            throw new IllegalStateException("this should only be called when the cursor is valid");
        }
        if (!this.MyBillsEntityDataFactory.moveToPosition(i)) {
            StringBuilder sb = new StringBuilder();
            sb.append("couldn't move cursor to position ");
            sb.append(i);
            throw new IllegalStateException(sb.toString());
        }
        if (view == null) {
            view = PlaceComponentResult(this.PlaceComponentResult, this.MyBillsEntityDataFactory, viewGroup);
        }
        MyBillsEntityDataFactory(view, this.MyBillsEntityDataFactory);
        return view;
    }

    @Override // android.widget.BaseAdapter, android.widget.SpinnerAdapter
    public View getDropDownView(int i, View view, ViewGroup viewGroup) {
        if (this.getErrorConfigVersion) {
            this.MyBillsEntityDataFactory.moveToPosition(i);
            if (view == null) {
                view = getAuthRequestContext(this.PlaceComponentResult, this.MyBillsEntityDataFactory, viewGroup);
            }
            MyBillsEntityDataFactory(view, this.MyBillsEntityDataFactory);
            return view;
        }
        return null;
    }

    public View getAuthRequestContext(Context context, Cursor cursor, ViewGroup viewGroup) {
        return PlaceComponentResult(context, cursor, viewGroup);
    }

    public void MyBillsEntityDataFactory(Cursor cursor) {
        Cursor KClassImpl$Data$declaredNonStaticMembers$2 = KClassImpl$Data$declaredNonStaticMembers$2(cursor);
        if (KClassImpl$Data$declaredNonStaticMembers$2 != null) {
            KClassImpl$Data$declaredNonStaticMembers$2.close();
        }
    }

    public Cursor KClassImpl$Data$declaredNonStaticMembers$2(Cursor cursor) {
        Cursor cursor2 = this.MyBillsEntityDataFactory;
        if (cursor == cursor2) {
            return null;
        }
        if (cursor2 != null) {
            ChangeObserver changeObserver = this.BuiltInFictitiousFunctionClassFactory;
            if (changeObserver != null) {
                cursor2.unregisterContentObserver(changeObserver);
            }
            DataSetObserver dataSetObserver = this.moveToNextValue;
            if (dataSetObserver != null) {
                cursor2.unregisterDataSetObserver(dataSetObserver);
            }
        }
        this.MyBillsEntityDataFactory = cursor;
        if (cursor != null) {
            ChangeObserver changeObserver2 = this.BuiltInFictitiousFunctionClassFactory;
            if (changeObserver2 != null) {
                cursor.registerContentObserver(changeObserver2);
            }
            DataSetObserver dataSetObserver2 = this.moveToNextValue;
            if (dataSetObserver2 != null) {
                cursor.registerDataSetObserver(dataSetObserver2);
            }
            this.lookAheadTest = cursor.getColumnIndexOrThrow(FieldType.FOREIGN_ID_FIELD_SUFFIX);
            this.getErrorConfigVersion = true;
            notifyDataSetChanged();
        } else {
            this.lookAheadTest = -1;
            this.getErrorConfigVersion = false;
            notifyDataSetInvalidated();
        }
        return cursor2;
    }

    public CharSequence BuiltInFictitiousFunctionClassFactory(Cursor cursor) {
        return cursor == null ? "" : cursor.toString();
    }

    public Cursor BuiltInFictitiousFunctionClassFactory(CharSequence charSequence) {
        FilterQueryProvider filterQueryProvider = this.NetworkUserEntityData$$ExternalSyntheticLambda0;
        if (filterQueryProvider != null) {
            return filterQueryProvider.runQuery(charSequence);
        }
        return this.MyBillsEntityDataFactory;
    }

    @Override // android.widget.Filterable
    public Filter getFilter() {
        if (this.scheduleImpl == null) {
            this.scheduleImpl = new CursorFilter(this);
        }
        return this.scheduleImpl;
    }

    protected final void getAuthRequestContext() {
        Cursor cursor;
        if (!this.KClassImpl$Data$declaredNonStaticMembers$2 || (cursor = this.MyBillsEntityDataFactory) == null || cursor.isClosed()) {
            return;
        }
        this.getErrorConfigVersion = this.MyBillsEntityDataFactory.requery();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes6.dex */
    public class ChangeObserver extends ContentObserver {
        @Override // android.database.ContentObserver
        public boolean deliverSelfNotifications() {
            return true;
        }

        ChangeObserver() {
            super(new Handler());
        }

        @Override // android.database.ContentObserver
        public void onChange(boolean z) {
            CursorAdapter.this.getAuthRequestContext();
        }
    }

    /* loaded from: classes6.dex */
    class MyDataSetObserver extends DataSetObserver {
        MyDataSetObserver() {
        }

        @Override // android.database.DataSetObserver
        public void onChanged() {
            CursorAdapter.this.getErrorConfigVersion = true;
            CursorAdapter.this.notifyDataSetChanged();
        }

        @Override // android.database.DataSetObserver
        public void onInvalidated() {
            CursorAdapter.this.getErrorConfigVersion = false;
            CursorAdapter.this.notifyDataSetInvalidated();
        }
    }
}
