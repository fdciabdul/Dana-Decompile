package androidx.appcompat.widget;

import android.app.SearchableInfo;
import android.content.ComponentName;
import android.content.Context;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.database.Cursor;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.TextAppearanceSpan;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.R;
import androidx.core.content.ContextCompat;
import androidx.cursoradapter.widget.ResourceCursorAdapter;
import com.fullstory.instrumentation.InstrumentInjector;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.WeakHashMap;

/* loaded from: classes6.dex */
class SuggestionsAdapter extends ResourceCursorAdapter implements View.OnClickListener {
    private boolean DatabaseTableConfigUtil;
    private int GetContactSyncConfig;
    private final int NetworkUserEntityData$$ExternalSyntheticLambda1;
    private int NetworkUserEntityData$$ExternalSyntheticLambda2;
    private int NetworkUserEntityData$$ExternalSyntheticLambda3;
    private int NetworkUserEntityData$$ExternalSyntheticLambda4;
    private ColorStateList NetworkUserEntityData$$ExternalSyntheticLambda6;
    private final Context NetworkUserEntityData$$ExternalSyntheticLambda7;
    private final SearchableInfo NetworkUserEntityData$$ExternalSyntheticLambda8;
    private final WeakHashMap<String, Drawable.ConstantState> PrepareContext;
    int getAuthRequestContext;
    private int initRecordTimeStamp;
    private final SearchView isLayoutRequested;
    private int newProxyInstance;

    @Override // androidx.cursoradapter.widget.CursorAdapter, android.widget.BaseAdapter, android.widget.Adapter
    public boolean hasStableIds() {
        return false;
    }

    public SuggestionsAdapter(Context context, SearchView searchView, SearchableInfo searchableInfo, WeakHashMap<String, Drawable.ConstantState> weakHashMap) {
        super(context, searchView.getSuggestionRowLayout());
        this.DatabaseTableConfigUtil = false;
        this.getAuthRequestContext = 1;
        this.newProxyInstance = -1;
        this.NetworkUserEntityData$$ExternalSyntheticLambda3 = -1;
        this.NetworkUserEntityData$$ExternalSyntheticLambda4 = -1;
        this.NetworkUserEntityData$$ExternalSyntheticLambda2 = -1;
        this.GetContactSyncConfig = -1;
        this.initRecordTimeStamp = -1;
        this.isLayoutRequested = searchView;
        this.NetworkUserEntityData$$ExternalSyntheticLambda8 = searchableInfo;
        this.NetworkUserEntityData$$ExternalSyntheticLambda1 = searchView.getSuggestionCommitIconResId();
        this.NetworkUserEntityData$$ExternalSyntheticLambda7 = context;
        this.PrepareContext = weakHashMap;
    }

    /* JADX WARN: Removed duplicated region for block: B:25:0x0078 A[Catch: RuntimeException -> 0x007c, TRY_LEAVE, TryCatch #0 {RuntimeException -> 0x007c, blocks: (B:10:0x001b, B:25:0x0078, B:13:0x0021, B:16:0x0028, B:18:0x0045, B:19:0x0048, B:21:0x0053, B:23:0x005f, B:22:0x005b), top: B:30:0x001b }] */
    @Override // androidx.cursoradapter.widget.CursorAdapter, androidx.cursoradapter.widget.CursorFilter.CursorFilterClient
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final android.database.Cursor BuiltInFictitiousFunctionClassFactory(java.lang.CharSequence r11) {
        /*
            r10 = this;
            java.lang.String r0 = ""
            if (r11 != 0) goto L6
            r11 = r0
            goto La
        L6:
            java.lang.String r11 = r11.toString()
        La:
            androidx.appcompat.widget.SearchView r1 = r10.isLayoutRequested
            int r1 = r1.getVisibility()
            r2 = 0
            if (r1 != 0) goto L84
            androidx.appcompat.widget.SearchView r1 = r10.isLayoutRequested
            int r1 = r1.getWindowVisibility()
            if (r1 != 0) goto L84
            android.app.SearchableInfo r1 = r10.NetworkUserEntityData$$ExternalSyntheticLambda8     // Catch: java.lang.RuntimeException -> L7c
            if (r1 != 0) goto L21
        L1f:
            r11 = r2
            goto L76
        L21:
            java.lang.String r3 = r1.getSuggestAuthority()     // Catch: java.lang.RuntimeException -> L7c
            if (r3 != 0) goto L28
            goto L1f
        L28:
            android.net.Uri$Builder r4 = new android.net.Uri$Builder     // Catch: java.lang.RuntimeException -> L7c
            r4.<init>()     // Catch: java.lang.RuntimeException -> L7c
            java.lang.String r5 = "content"
            android.net.Uri$Builder r4 = r4.scheme(r5)     // Catch: java.lang.RuntimeException -> L7c
            android.net.Uri$Builder r3 = r4.authority(r3)     // Catch: java.lang.RuntimeException -> L7c
            android.net.Uri$Builder r3 = r3.query(r0)     // Catch: java.lang.RuntimeException -> L7c
            android.net.Uri$Builder r0 = r3.fragment(r0)     // Catch: java.lang.RuntimeException -> L7c
            java.lang.String r3 = r1.getSuggestPath()     // Catch: java.lang.RuntimeException -> L7c
            if (r3 == 0) goto L48
            r0.appendEncodedPath(r3)     // Catch: java.lang.RuntimeException -> L7c
        L48:
            java.lang.String r3 = "search_suggest_query"
            r0.appendPath(r3)     // Catch: java.lang.RuntimeException -> L7c
            java.lang.String r7 = r1.getSuggestSelection()     // Catch: java.lang.RuntimeException -> L7c
            if (r7 == 0) goto L5b
            r1 = 1
            java.lang.String[] r1 = new java.lang.String[r1]     // Catch: java.lang.RuntimeException -> L7c
            r3 = 0
            r1[r3] = r11     // Catch: java.lang.RuntimeException -> L7c
            r8 = r1
            goto L5f
        L5b:
            r0.appendPath(r11)     // Catch: java.lang.RuntimeException -> L7c
            r8 = r2
        L5f:
            java.lang.String r11 = "limit"
            java.lang.String r1 = "50"
            r0.appendQueryParameter(r11, r1)     // Catch: java.lang.RuntimeException -> L7c
            android.net.Uri r5 = r0.build()     // Catch: java.lang.RuntimeException -> L7c
            android.content.Context r11 = r10.NetworkUserEntityData$$ExternalSyntheticLambda7     // Catch: java.lang.RuntimeException -> L7c
            android.content.ContentResolver r4 = r11.getContentResolver()     // Catch: java.lang.RuntimeException -> L7c
            r6 = 0
            r9 = 0
            android.database.Cursor r11 = r4.query(r5, r6, r7, r8, r9)     // Catch: java.lang.RuntimeException -> L7c
        L76:
            if (r11 == 0) goto L84
            r11.getCount()     // Catch: java.lang.RuntimeException -> L7c
            return r11
        L7c:
            r11 = move-exception
            java.lang.String r0 = "SuggestionsAdapter"
            java.lang.String r1 = "Search suggestions query threw an exception."
            com.fullstory.instrumentation.InstrumentInjector.log_w(r0, r1, r11)
        L84:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.SuggestionsAdapter.BuiltInFictitiousFunctionClassFactory(java.lang.CharSequence):android.database.Cursor");
    }

    @Override // android.widget.BaseAdapter
    public void notifyDataSetChanged() {
        super.notifyDataSetChanged();
        Cursor BuiltInFictitiousFunctionClassFactory = BuiltInFictitiousFunctionClassFactory();
        Bundle extras = BuiltInFictitiousFunctionClassFactory != null ? BuiltInFictitiousFunctionClassFactory.getExtras() : null;
        if (extras != null) {
            extras.getBoolean("in_progress");
        }
    }

    @Override // android.widget.BaseAdapter
    public void notifyDataSetInvalidated() {
        super.notifyDataSetInvalidated();
        Cursor BuiltInFictitiousFunctionClassFactory = BuiltInFictitiousFunctionClassFactory();
        Bundle extras = BuiltInFictitiousFunctionClassFactory != null ? BuiltInFictitiousFunctionClassFactory.getExtras() : null;
        if (extras != null) {
            extras.getBoolean("in_progress");
        }
    }

    @Override // androidx.cursoradapter.widget.CursorAdapter, androidx.cursoradapter.widget.CursorFilter.CursorFilterClient
    public final void MyBillsEntityDataFactory(Cursor cursor) {
        if (this.DatabaseTableConfigUtil) {
            InstrumentInjector.log_w("SuggestionsAdapter", "Tried to change cursor after adapter was closed.");
            if (cursor != null) {
                cursor.close();
                return;
            }
            return;
        }
        try {
            super.MyBillsEntityDataFactory(cursor);
            if (cursor != null) {
                this.newProxyInstance = cursor.getColumnIndex("suggest_text_1");
                this.NetworkUserEntityData$$ExternalSyntheticLambda3 = cursor.getColumnIndex("suggest_text_2");
                this.NetworkUserEntityData$$ExternalSyntheticLambda4 = cursor.getColumnIndex("suggest_text_2_url");
                this.NetworkUserEntityData$$ExternalSyntheticLambda2 = cursor.getColumnIndex("suggest_icon_1");
                this.GetContactSyncConfig = cursor.getColumnIndex("suggest_icon_2");
                this.initRecordTimeStamp = cursor.getColumnIndex("suggest_flags");
            }
        } catch (Exception e) {
            InstrumentInjector.log_e("SuggestionsAdapter", "error changing cursor and caching columns", e);
        }
    }

    @Override // androidx.cursoradapter.widget.ResourceCursorAdapter, androidx.cursoradapter.widget.CursorAdapter
    public final View PlaceComponentResult(Context context, Cursor cursor, ViewGroup viewGroup) {
        View PlaceComponentResult = super.PlaceComponentResult(context, cursor, viewGroup);
        PlaceComponentResult.setTag(new ChildViewCache(PlaceComponentResult));
        InstrumentInjector.Resources_setImageResource((ImageView) PlaceComponentResult.findViewById(R.id.PrepareContext), this.NetworkUserEntityData$$ExternalSyntheticLambda1);
        return PlaceComponentResult;
    }

    /* loaded from: classes6.dex */
    static final class ChildViewCache {
        public final TextView BuiltInFictitiousFunctionClassFactory;
        public final ImageView KClassImpl$Data$declaredNonStaticMembers$2;
        public final ImageView MyBillsEntityDataFactory;
        public final ImageView PlaceComponentResult;
        public final TextView getAuthRequestContext;

        public ChildViewCache(View view) {
            this.BuiltInFictitiousFunctionClassFactory = (TextView) view.findViewById(16908308);
            this.getAuthRequestContext = (TextView) view.findViewById(16908309);
            this.MyBillsEntityDataFactory = (ImageView) view.findViewById(16908295);
            this.KClassImpl$Data$declaredNonStaticMembers$2 = (ImageView) view.findViewById(16908296);
            this.PlaceComponentResult = (ImageView) view.findViewById(R.id.PrepareContext);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // androidx.cursoradapter.widget.CursorAdapter
    public final void MyBillsEntityDataFactory(View view, Cursor cursor) {
        Drawable KClassImpl$Data$declaredNonStaticMembers$2;
        String str;
        ChildViewCache childViewCache = (ChildViewCache) view.getTag();
        int i = this.initRecordTimeStamp;
        int i2 = i != -1 ? cursor.getInt(i) : 0;
        if (childViewCache.BuiltInFictitiousFunctionClassFactory != null) {
            String BuiltInFictitiousFunctionClassFactory = BuiltInFictitiousFunctionClassFactory(cursor, this.newProxyInstance);
            TextView textView = childViewCache.BuiltInFictitiousFunctionClassFactory;
            textView.setText(BuiltInFictitiousFunctionClassFactory);
            if (TextUtils.isEmpty(BuiltInFictitiousFunctionClassFactory)) {
                textView.setVisibility(8);
            } else {
                textView.setVisibility(0);
            }
        }
        if (childViewCache.getAuthRequestContext != null) {
            String BuiltInFictitiousFunctionClassFactory2 = BuiltInFictitiousFunctionClassFactory(cursor, this.NetworkUserEntityData$$ExternalSyntheticLambda4);
            if (BuiltInFictitiousFunctionClassFactory2 == null) {
                str = BuiltInFictitiousFunctionClassFactory(cursor, this.NetworkUserEntityData$$ExternalSyntheticLambda3);
            } else {
                if (this.NetworkUserEntityData$$ExternalSyntheticLambda6 == null) {
                    TypedValue typedValue = new TypedValue();
                    this.NetworkUserEntityData$$ExternalSyntheticLambda7.getTheme().resolveAttribute(R.attr.AppCompatEmojiTextHelper, typedValue, true);
                    this.NetworkUserEntityData$$ExternalSyntheticLambda6 = this.NetworkUserEntityData$$ExternalSyntheticLambda7.getResources().getColorStateList(typedValue.resourceId);
                }
                SpannableString spannableString = new SpannableString(BuiltInFictitiousFunctionClassFactory2);
                spannableString.setSpan(new TextAppearanceSpan(null, 0, 0, this.NetworkUserEntityData$$ExternalSyntheticLambda6, null), 0, BuiltInFictitiousFunctionClassFactory2.length(), 33);
                str = spannableString;
            }
            if (TextUtils.isEmpty(str)) {
                if (childViewCache.BuiltInFictitiousFunctionClassFactory != null) {
                    childViewCache.BuiltInFictitiousFunctionClassFactory.setSingleLine(false);
                    childViewCache.BuiltInFictitiousFunctionClassFactory.setMaxLines(2);
                }
            } else if (childViewCache.BuiltInFictitiousFunctionClassFactory != null) {
                childViewCache.BuiltInFictitiousFunctionClassFactory.setSingleLine(true);
                childViewCache.BuiltInFictitiousFunctionClassFactory.setMaxLines(1);
            }
            TextView textView2 = childViewCache.getAuthRequestContext;
            textView2.setText(str);
            if (TextUtils.isEmpty(str)) {
                textView2.setVisibility(8);
            } else {
                textView2.setVisibility(0);
            }
        }
        if (childViewCache.MyBillsEntityDataFactory != null) {
            ImageView imageView = childViewCache.MyBillsEntityDataFactory;
            int i3 = this.NetworkUserEntityData$$ExternalSyntheticLambda2;
            if (i3 == -1) {
                KClassImpl$Data$declaredNonStaticMembers$2 = null;
            } else {
                KClassImpl$Data$declaredNonStaticMembers$2 = KClassImpl$Data$declaredNonStaticMembers$2(cursor.getString(i3));
                if (KClassImpl$Data$declaredNonStaticMembers$2 == null) {
                    ComponentName searchActivity = this.NetworkUserEntityData$$ExternalSyntheticLambda8.getSearchActivity();
                    String flattenToShortString = searchActivity.flattenToShortString();
                    if (this.PrepareContext.containsKey(flattenToShortString)) {
                        Drawable.ConstantState constantState = this.PrepareContext.get(flattenToShortString);
                        KClassImpl$Data$declaredNonStaticMembers$2 = constantState == null ? null : constantState.newDrawable(this.NetworkUserEntityData$$ExternalSyntheticLambda7.getResources());
                    } else {
                        KClassImpl$Data$declaredNonStaticMembers$2 = getAuthRequestContext(searchActivity);
                        this.PrepareContext.put(flattenToShortString, KClassImpl$Data$declaredNonStaticMembers$2 == null ? null : KClassImpl$Data$declaredNonStaticMembers$2.getConstantState());
                    }
                    if (KClassImpl$Data$declaredNonStaticMembers$2 == null) {
                        KClassImpl$Data$declaredNonStaticMembers$2 = this.NetworkUserEntityData$$ExternalSyntheticLambda7.getPackageManager().getDefaultActivityIcon();
                    }
                }
            }
            BuiltInFictitiousFunctionClassFactory(imageView, KClassImpl$Data$declaredNonStaticMembers$2, 4);
        }
        if (childViewCache.KClassImpl$Data$declaredNonStaticMembers$2 != null) {
            ImageView imageView2 = childViewCache.KClassImpl$Data$declaredNonStaticMembers$2;
            int i4 = this.GetContactSyncConfig;
            BuiltInFictitiousFunctionClassFactory(imageView2, i4 != -1 ? KClassImpl$Data$declaredNonStaticMembers$2(cursor.getString(i4)) : null, 8);
        }
        int i5 = this.getAuthRequestContext;
        if (i5 == 2 || (i5 == 1 && (i2 & 1) != 0)) {
            childViewCache.PlaceComponentResult.setVisibility(0);
            childViewCache.PlaceComponentResult.setTag(childViewCache.BuiltInFictitiousFunctionClassFactory.getText());
            childViewCache.PlaceComponentResult.setOnClickListener(this);
            return;
        }
        childViewCache.PlaceComponentResult.setVisibility(8);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Object tag = view.getTag();
        if (tag instanceof CharSequence) {
            this.isLayoutRequested.onQueryRefine((CharSequence) tag);
        }
    }

    private static void BuiltInFictitiousFunctionClassFactory(ImageView imageView, Drawable drawable, int i) {
        imageView.setImageDrawable(drawable);
        if (drawable == null) {
            imageView.setVisibility(i);
            return;
        }
        imageView.setVisibility(0);
        drawable.setVisible(false, false);
        drawable.setVisible(true, false);
    }

    @Override // androidx.cursoradapter.widget.CursorAdapter, android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        try {
            return super.getView(i, view, viewGroup);
        } catch (RuntimeException e) {
            InstrumentInjector.log_w("SuggestionsAdapter", "Search suggestions cursor threw exception.", e);
            View PlaceComponentResult = PlaceComponentResult(this.NetworkUserEntityData$$ExternalSyntheticLambda7, BuiltInFictitiousFunctionClassFactory(), viewGroup);
            if (PlaceComponentResult != null) {
                ((ChildViewCache) PlaceComponentResult.getTag()).BuiltInFictitiousFunctionClassFactory.setText(e.toString());
            }
            return PlaceComponentResult;
        }
    }

    @Override // androidx.cursoradapter.widget.CursorAdapter, android.widget.BaseAdapter, android.widget.SpinnerAdapter
    public View getDropDownView(int i, View view, ViewGroup viewGroup) {
        try {
            return super.getDropDownView(i, view, viewGroup);
        } catch (RuntimeException e) {
            InstrumentInjector.log_w("SuggestionsAdapter", "Search suggestions cursor threw exception.", e);
            View authRequestContext = getAuthRequestContext(this.NetworkUserEntityData$$ExternalSyntheticLambda7, BuiltInFictitiousFunctionClassFactory(), viewGroup);
            if (authRequestContext != null) {
                ((ChildViewCache) authRequestContext.getTag()).BuiltInFictitiousFunctionClassFactory.setText(e.toString());
            }
            return authRequestContext;
        }
    }

    private Drawable KClassImpl$Data$declaredNonStaticMembers$2(String str) {
        if (str != null && !str.isEmpty() && !"0".equals(str)) {
            try {
                int parseInt = Integer.parseInt(str);
                StringBuilder sb = new StringBuilder();
                sb.append("android.resource://");
                sb.append(this.NetworkUserEntityData$$ExternalSyntheticLambda7.getPackageName());
                sb.append("/");
                sb.append(parseInt);
                String obj = sb.toString();
                Drawable.ConstantState constantState = this.PrepareContext.get(obj);
                Drawable newDrawable = constantState == null ? null : constantState.newDrawable();
                if (newDrawable != null) {
                    return newDrawable;
                }
                Drawable PlaceComponentResult = ContextCompat.PlaceComponentResult(this.NetworkUserEntityData$$ExternalSyntheticLambda7, parseInt);
                if (PlaceComponentResult != null) {
                    this.PrepareContext.put(obj, PlaceComponentResult.getConstantState());
                }
                return PlaceComponentResult;
            } catch (Resources.NotFoundException unused) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("Icon resource not found: ");
                sb2.append(str);
                InstrumentInjector.log_w("SuggestionsAdapter", sb2.toString());
                return null;
            } catch (NumberFormatException unused2) {
                Drawable.ConstantState constantState2 = this.PrepareContext.get(str);
                r0 = constantState2 != null ? constantState2.newDrawable() : null;
                if (r0 != null) {
                    return r0;
                }
                r0 = PlaceComponentResult(Uri.parse(str));
                if (r0 != null) {
                    this.PrepareContext.put(str, r0.getConstantState());
                }
            }
        }
        return r0;
    }

    private Drawable PlaceComponentResult(Uri uri) {
        try {
            if ("android.resource".equals(uri.getScheme())) {
                try {
                    return KClassImpl$Data$declaredNonStaticMembers$2(uri);
                } catch (Resources.NotFoundException unused) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("Resource does not exist: ");
                    sb.append(uri);
                    throw new FileNotFoundException(sb.toString());
                }
            }
            InputStream openInputStream = this.NetworkUserEntityData$$ExternalSyntheticLambda7.getContentResolver().openInputStream(uri);
            if (openInputStream == null) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("Failed to open ");
                sb2.append(uri);
                throw new FileNotFoundException(sb2.toString());
            }
            try {
                return Drawable.createFromStream(openInputStream, null);
            } finally {
                try {
                    openInputStream.close();
                } catch (IOException e) {
                    StringBuilder sb3 = new StringBuilder();
                    sb3.append("Error closing icon stream for ");
                    sb3.append(uri);
                    InstrumentInjector.log_e("SuggestionsAdapter", sb3.toString(), e);
                }
            }
        } catch (FileNotFoundException e2) {
            StringBuilder sb4 = new StringBuilder();
            sb4.append("Icon not found: ");
            sb4.append(uri);
            sb4.append(", ");
            sb4.append(e2.getMessage());
            InstrumentInjector.log_w("SuggestionsAdapter", sb4.toString());
            return null;
        }
        StringBuilder sb42 = new StringBuilder();
        sb42.append("Icon not found: ");
        sb42.append(uri);
        sb42.append(", ");
        sb42.append(e2.getMessage());
        InstrumentInjector.log_w("SuggestionsAdapter", sb42.toString());
        return null;
    }

    private Drawable getAuthRequestContext(ComponentName componentName) {
        PackageManager packageManager = this.NetworkUserEntityData$$ExternalSyntheticLambda7.getPackageManager();
        try {
            ActivityInfo activityInfo = packageManager.getActivityInfo(componentName, 128);
            int iconResource = activityInfo.getIconResource();
            if (iconResource == 0) {
                return null;
            }
            Drawable drawable = packageManager.getDrawable(componentName.getPackageName(), iconResource, activityInfo.applicationInfo);
            if (drawable == null) {
                StringBuilder sb = new StringBuilder();
                sb.append("Invalid icon resource ");
                sb.append(iconResource);
                sb.append(" for ");
                sb.append(componentName.flattenToShortString());
                InstrumentInjector.log_w("SuggestionsAdapter", sb.toString());
                return null;
            }
            return drawable;
        } catch (PackageManager.NameNotFoundException e) {
            InstrumentInjector.log_w("SuggestionsAdapter", e.toString());
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String BuiltInFictitiousFunctionClassFactory(Cursor cursor, int i) {
        if (i == -1) {
            return null;
        }
        try {
            return cursor.getString(i);
        } catch (Exception e) {
            InstrumentInjector.log_e("SuggestionsAdapter", "unexpected error retrieving valid column from cursor, did the remote process die?", e);
            return null;
        }
    }

    private Drawable KClassImpl$Data$declaredNonStaticMembers$2(Uri uri) throws FileNotFoundException {
        int parseInt;
        String authority = uri.getAuthority();
        if (TextUtils.isEmpty(authority)) {
            StringBuilder sb = new StringBuilder();
            sb.append("No authority: ");
            sb.append(uri);
            throw new FileNotFoundException(sb.toString());
        }
        try {
            Resources resourcesForApplication = this.NetworkUserEntityData$$ExternalSyntheticLambda7.getPackageManager().getResourcesForApplication(authority);
            List<String> pathSegments = uri.getPathSegments();
            if (pathSegments == null) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("No path: ");
                sb2.append(uri);
                throw new FileNotFoundException(sb2.toString());
            }
            int size = pathSegments.size();
            if (size == 1) {
                try {
                    parseInt = Integer.parseInt(pathSegments.get(0));
                } catch (NumberFormatException unused) {
                    StringBuilder sb3 = new StringBuilder();
                    sb3.append("Single path segment is not a resource ID: ");
                    sb3.append(uri);
                    throw new FileNotFoundException(sb3.toString());
                }
            } else if (size == 2) {
                parseInt = resourcesForApplication.getIdentifier(pathSegments.get(1), pathSegments.get(0), authority);
            } else {
                StringBuilder sb4 = new StringBuilder();
                sb4.append("More than two path segments: ");
                sb4.append(uri);
                throw new FileNotFoundException(sb4.toString());
            }
            if (parseInt == 0) {
                StringBuilder sb5 = new StringBuilder();
                sb5.append("No resource found for: ");
                sb5.append(uri);
                throw new FileNotFoundException(sb5.toString());
            }
            return InstrumentInjector.Resources_getDrawable(resourcesForApplication, parseInt);
        } catch (PackageManager.NameNotFoundException unused2) {
            StringBuilder sb6 = new StringBuilder();
            sb6.append("No package found for authority: ");
            sb6.append(uri);
            throw new FileNotFoundException(sb6.toString());
        }
    }

    @Override // androidx.cursoradapter.widget.CursorAdapter, androidx.cursoradapter.widget.CursorFilter.CursorFilterClient
    public final CharSequence BuiltInFictitiousFunctionClassFactory(Cursor cursor) {
        String BuiltInFictitiousFunctionClassFactory;
        String BuiltInFictitiousFunctionClassFactory2;
        if (cursor == null) {
            return null;
        }
        String BuiltInFictitiousFunctionClassFactory3 = BuiltInFictitiousFunctionClassFactory(cursor, cursor.getColumnIndex("suggest_intent_query"));
        if (BuiltInFictitiousFunctionClassFactory3 != null) {
            return BuiltInFictitiousFunctionClassFactory3;
        }
        if (!this.NetworkUserEntityData$$ExternalSyntheticLambda8.shouldRewriteQueryFromData() || (BuiltInFictitiousFunctionClassFactory2 = BuiltInFictitiousFunctionClassFactory(cursor, cursor.getColumnIndex("suggest_intent_data"))) == null) {
            if (!this.NetworkUserEntityData$$ExternalSyntheticLambda8.shouldRewriteQueryFromText() || (BuiltInFictitiousFunctionClassFactory = BuiltInFictitiousFunctionClassFactory(cursor, cursor.getColumnIndex("suggest_text_1"))) == null) {
                return null;
            }
            return BuiltInFictitiousFunctionClassFactory;
        }
        return BuiltInFictitiousFunctionClassFactory2;
    }
}
