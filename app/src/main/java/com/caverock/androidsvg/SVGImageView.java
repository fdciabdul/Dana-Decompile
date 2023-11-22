package com.caverock.androidsvg;

import android.content.Context;
import android.content.res.AssetManager;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Picture;
import android.graphics.drawable.PictureDrawable;
import android.net.Uri;
import android.os.AsyncTask;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ExpandableListView;
import android.widget.ImageView;
import com.fullstory.instrumentation.InstrumentInjector;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Method;
import o.NetworkUserEntityData$$ExternalSyntheticLambda7;

/* loaded from: classes7.dex */
public class SVGImageView extends ImageView {
    private static int KClassImpl$Data$declaredNonStaticMembers$2 = 1;
    private static int MyBillsEntityDataFactory;
    private static Method setLayerTypeMethod;
    private RenderOptions renderOptions;
    private SVG svg;
    public static final byte[] BuiltInFictitiousFunctionClassFactory = {10, -99, -17, -84, 38, 6, -4, -66, 81, 4, 8, -81, 73, 12, 9, -4, -7, -39, -23};
    public static final int getAuthRequestContext = 123;

    public static void __fsTypeCheck_e3af777227381b06da2ac5e1dcf49f72(SVGImageView sVGImageView, int i) {
        if (sVGImageView instanceof ImageView) {
            InstrumentInjector.Resources_setImageResource(sVGImageView, i);
        } else {
            sVGImageView.setImageResource(i);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0020  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0018  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x0020 -> B:11:0x002a). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void a(int r7, java.lang.Object[] r8) {
        /*
            int r7 = r7 + 4
            byte[] r0 = com.caverock.androidsvg.SVGImageView.BuiltInFictitiousFunctionClassFactory
            r1 = 16
            byte[] r1 = new byte[r1]
            r2 = 70
            r3 = 0
            if (r0 != 0) goto L10
            r4 = 3
            r5 = 0
            goto L2a
        L10:
            r4 = 0
        L11:
            byte r5 = (byte) r2
            r1[r4] = r5
            r5 = 15
            if (r4 != r5) goto L20
            java.lang.String r7 = new java.lang.String
            r7.<init>(r1, r3)
            r8[r3] = r7
            return
        L20:
            int r7 = r7 + 1
            int r4 = r4 + 1
            r5 = r0[r7]
            r6 = r4
            r4 = r2
            r2 = r5
            r5 = r6
        L2a:
            int r4 = r4 + r2
            int r2 = r4 + (-3)
            r4 = r5
            goto L11
        */
        throw new UnsupportedOperationException("Method not decompiled: com.caverock.androidsvg.SVGImageView.a(int, java.lang.Object[]):void");
    }

    static {
        try {
            setLayerTypeMethod = View.class.getMethod("setLayerType", Integer.TYPE, Paint.class);
        } catch (NoSuchMethodException unused) {
        }
    }

    public SVGImageView(Context context) {
        super(context);
        this.svg = null;
        this.renderOptions = new RenderOptions();
    }

    public SVGImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, 0);
        this.svg = null;
        this.renderOptions = new RenderOptions();
        init(attributeSet, 0);
    }

    public SVGImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.svg = null;
        this.renderOptions = new RenderOptions();
        init(attributeSet, i);
    }

    private void init(AttributeSet attributeSet, int i) {
        if (isInEditMode()) {
            return;
        }
        TypedArray obtainStyledAttributes = getContext().getTheme().obtainStyledAttributes(attributeSet, R.styleable.SVGImageView, i, 0);
        try {
            String string = obtainStyledAttributes.getString(R.styleable.SVGImageView_css);
            if (string != null) {
                this.renderOptions.css(string);
            }
            int resourceId = obtainStyledAttributes.getResourceId(R.styleable.SVGImageView_svg, -1);
            if (resourceId != -1) {
                __fsTypeCheck_e3af777227381b06da2ac5e1dcf49f72(this, resourceId);
                return;
            }
            String string2 = obtainStyledAttributes.getString(R.styleable.SVGImageView_svg);
            if (string2 != null) {
                if (internalSetImageURI(Uri.parse(string2))) {
                    return;
                }
                if (internalSetImageAsset(string2)) {
                    return;
                }
                setFromString(string2);
            }
        } finally {
            obtainStyledAttributes.recycle();
        }
    }

    public void setSVG(SVG svg) {
        if (svg == null) {
            throw new IllegalArgumentException("Null value passed to setSVG()");
        }
        this.svg = svg;
        doRender();
    }

    public void setSVG(SVG svg, String str) {
        if (svg == null) {
            throw new IllegalArgumentException("Null value passed to setSVG()");
        }
        this.svg = svg;
        this.renderOptions.css(str);
        doRender();
    }

    public void setCSS(String str) {
        this.renderOptions.css(str);
        doRender();
    }

    @Override // android.widget.ImageView
    public void setImageResource(int i) {
        new LoadResourceTask(getContext(), i).execute(new Integer[0]);
    }

    @Override // android.widget.ImageView
    public void setImageURI(Uri uri) {
        if (internalSetImageURI(uri)) {
            return;
        }
        StringBuilder sb = new StringBuilder();
        Object[] objArr = new Object[1];
        a(-1, objArr);
        sb.append((String) objArr[0]);
        sb.append(uri);
        InstrumentInjector.log_e("SVGImageView", sb.toString());
    }

    public void setImageAsset(String str) {
        if (internalSetImageAsset(str)) {
            return;
        }
        StringBuilder sb = new StringBuilder();
        Object[] objArr = new Object[1];
        a(-1, objArr);
        sb.append((String) objArr[0]);
        sb.append(str);
        InstrumentInjector.log_e("SVGImageView", sb.toString());
    }

    private boolean internalSetImageURI(Uri uri) {
        try {
            new LoadURITask().execute(getContext().getContentResolver().openInputStream(uri));
            return true;
        } catch (FileNotFoundException unused) {
            return false;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private boolean internalSetImageAsset(String str) {
        try {
            try {
                Object[] objArr = {getContext().getAssets(), str};
                Object obj = NetworkUserEntityData$$ExternalSyntheticLambda7.isLayoutRequested.get(-906490705);
                if (obj == null) {
                    obj = ((Class) NetworkUserEntityData$$ExternalSyntheticLambda7.PlaceComponentResult((char) (58133 - TextUtils.getCapsMode("", 0, 0)), Color.green(0), 49 - (ExpandableListView.getPackedPositionForGroup(0) > 0L ? 1 : (ExpandableListView.getPackedPositionForGroup(0) == 0L ? 0 : -1)))).getMethod("getAuthRequestContext", AssetManager.class, String.class);
                    NetworkUserEntityData$$ExternalSyntheticLambda7.isLayoutRequested.put(-906490705, obj);
                }
                new LoadURITask().execute(((Method) obj).invoke(null, objArr));
                int i = KClassImpl$Data$declaredNonStaticMembers$2 + 69;
                MyBillsEntityDataFactory = i % 128;
                int i2 = i % 2;
                return true;
            } catch (Throwable th) {
                Throwable cause = th.getCause();
                if (cause != null) {
                    throw cause;
                }
                throw th;
            }
        } catch (IOException unused) {
            return false;
        }
    }

    private void setFromString(String str) {
        try {
            this.svg = SVG.getFromString(str);
            doRender();
        } catch (SVGParseException unused) {
            StringBuilder sb = new StringBuilder();
            sb.append("Could not find SVG at: ");
            sb.append(str);
            InstrumentInjector.log_e("SVGImageView", sb.toString());
        }
    }

    /* loaded from: classes7.dex */
    class LoadResourceTask extends AsyncTask<Integer, Integer, SVG> {
        private Context context;
        private int resourceId;

        LoadResourceTask(Context context, int i) {
            this.context = context;
            this.resourceId = i;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        public SVG doInBackground(Integer... numArr) {
            try {
                return SVG.getFromResource(this.context, this.resourceId);
            } catch (SVGParseException e) {
                InstrumentInjector.log_e("SVGImageView", String.format("Error loading resource 0x%x: %s", Integer.valueOf(this.resourceId), e.getMessage()));
                return null;
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        public void onPostExecute(SVG svg) {
            SVGImageView.this.svg = svg;
            SVGImageView.this.doRender();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes7.dex */
    public class LoadURITask extends AsyncTask<InputStream, Integer, SVG> {
        private LoadURITask() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        public SVG doInBackground(InputStream... inputStreamArr) {
            try {
                try {
                    SVG fromInputStream = SVG.getFromInputStream(inputStreamArr[0]);
                    try {
                        inputStreamArr[0].close();
                    } catch (IOException unused) {
                    }
                    return fromInputStream;
                } catch (Throwable th) {
                    try {
                        inputStreamArr[0].close();
                    } catch (IOException unused2) {
                    }
                    throw th;
                }
            } catch (SVGParseException e) {
                StringBuilder sb = new StringBuilder();
                sb.append("Parse error loading URI: ");
                sb.append(e.getMessage());
                InstrumentInjector.log_e("SVGImageView", sb.toString());
                try {
                    inputStreamArr[0].close();
                    return null;
                } catch (IOException unused3) {
                    return null;
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        public void onPostExecute(SVG svg) {
            SVGImageView.this.svg = svg;
            SVGImageView.this.doRender();
        }
    }

    private void setSoftwareLayerType() {
        if (setLayerTypeMethod == null) {
            return;
        }
        try {
            setLayerTypeMethod.invoke(this, Integer.valueOf(View.class.getField("LAYER_TYPE_SOFTWARE").getInt(new View(getContext()))), null);
        } catch (Exception e) {
            InstrumentInjector.log_w("SVGImageView", "Unexpected failure calling setLayerType", e);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void doRender() {
        SVG svg = this.svg;
        if (svg == null) {
            return;
        }
        Picture renderToPicture = svg.renderToPicture(this.renderOptions);
        setSoftwareLayerType();
        setImageDrawable(new PictureDrawable(renderToPicture));
    }
}
