package androidx.cursoradapter.widget;

import android.content.Context;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/* loaded from: classes6.dex */
public abstract class ResourceCursorAdapter extends CursorAdapter {
    private int GetContactSyncConfig;
    private LayoutInflater NetworkUserEntityData$$ExternalSyntheticLambda1;
    private int getAuthRequestContext;

    @Deprecated
    public ResourceCursorAdapter(Context context, int i) {
        super(context);
        this.getAuthRequestContext = i;
        this.GetContactSyncConfig = i;
        this.NetworkUserEntityData$$ExternalSyntheticLambda1 = (LayoutInflater) context.getSystemService("layout_inflater");
    }

    @Override // androidx.cursoradapter.widget.CursorAdapter
    public View PlaceComponentResult(Context context, Cursor cursor, ViewGroup viewGroup) {
        return this.NetworkUserEntityData$$ExternalSyntheticLambda1.inflate(this.GetContactSyncConfig, viewGroup, false);
    }

    @Override // androidx.cursoradapter.widget.CursorAdapter
    public final View getAuthRequestContext(Context context, Cursor cursor, ViewGroup viewGroup) {
        return this.NetworkUserEntityData$$ExternalSyntheticLambda1.inflate(this.getAuthRequestContext, viewGroup, false);
    }
}
