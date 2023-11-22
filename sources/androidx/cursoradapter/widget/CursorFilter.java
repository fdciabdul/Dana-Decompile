package androidx.cursoradapter.widget;

import android.database.Cursor;
import android.widget.Filter;

/* loaded from: classes6.dex */
class CursorFilter extends Filter {
    CursorFilterClient getAuthRequestContext;

    /* loaded from: classes6.dex */
    interface CursorFilterClient {
        Cursor BuiltInFictitiousFunctionClassFactory();

        Cursor BuiltInFictitiousFunctionClassFactory(CharSequence charSequence);

        CharSequence BuiltInFictitiousFunctionClassFactory(Cursor cursor);

        void MyBillsEntityDataFactory(Cursor cursor);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public CursorFilter(CursorFilterClient cursorFilterClient) {
        this.getAuthRequestContext = cursorFilterClient;
    }

    @Override // android.widget.Filter
    public CharSequence convertResultToString(Object obj) {
        return this.getAuthRequestContext.BuiltInFictitiousFunctionClassFactory((Cursor) obj);
    }

    @Override // android.widget.Filter
    protected Filter.FilterResults performFiltering(CharSequence charSequence) {
        Cursor BuiltInFictitiousFunctionClassFactory = this.getAuthRequestContext.BuiltInFictitiousFunctionClassFactory(charSequence);
        Filter.FilterResults filterResults = new Filter.FilterResults();
        if (BuiltInFictitiousFunctionClassFactory != null) {
            filterResults.count = BuiltInFictitiousFunctionClassFactory.getCount();
            filterResults.values = BuiltInFictitiousFunctionClassFactory;
        } else {
            filterResults.count = 0;
            filterResults.values = null;
        }
        return filterResults;
    }

    @Override // android.widget.Filter
    protected void publishResults(CharSequence charSequence, Filter.FilterResults filterResults) {
        Cursor BuiltInFictitiousFunctionClassFactory = this.getAuthRequestContext.BuiltInFictitiousFunctionClassFactory();
        if (filterResults.values == null || filterResults.values == BuiltInFictitiousFunctionClassFactory) {
            return;
        }
        this.getAuthRequestContext.MyBillsEntityDataFactory((Cursor) filterResults.values);
    }
}
