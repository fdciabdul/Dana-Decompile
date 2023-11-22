package androidx.constraintlayout.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.SparseArray;
import android.util.Xml;
import com.alipay.mobile.zebra.data.BoxData;
import com.fullstory.instrumentation.InstrumentInjector;
import id.dana.analytics.tracker.TrackerKey;
import java.io.IOException;
import java.util.ArrayList;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* loaded from: classes3.dex */
public class StateSet {
    int getAuthRequestContext;
    int MyBillsEntityDataFactory = -1;
    int PlaceComponentResult = -1;
    public SparseArray<State> KClassImpl$Data$declaredNonStaticMembers$2 = new SparseArray<>();
    private SparseArray<ConstraintSet> BuiltInFictitiousFunctionClassFactory = new SparseArray<>();
    private ConstraintsChangedListener getErrorConfigVersion = null;

    public StateSet(Context context, XmlPullParser xmlPullParser) {
        this.getAuthRequestContext = -1;
        State state = null;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(Xml.asAttributeSet(xmlPullParser), R.styleable.FeatureSplitBillPay);
        int indexCount = obtainStyledAttributes.getIndexCount();
        for (int i = 0; i < indexCount; i++) {
            int index = obtainStyledAttributes.getIndex(i);
            if (index == R.styleable.CashierEntityDataFactory_Factory) {
                this.getAuthRequestContext = obtainStyledAttributes.getResourceId(index, this.getAuthRequestContext);
            }
        }
        obtainStyledAttributes.recycle();
        try {
            int eventType = xmlPullParser.getEventType();
            while (true) {
                char c = 1;
                if (eventType == 1) {
                    return;
                }
                if (eventType == 0) {
                    xmlPullParser.getName();
                } else if (eventType == 2) {
                    String name = xmlPullParser.getName();
                    switch (name.hashCode()) {
                        case 80204913:
                            if (name.equals(TrackerKey.Property.STATE)) {
                                c = 2;
                                break;
                            }
                            c = 65535;
                            break;
                        case 1301459538:
                            if (name.equals("LayoutDescription")) {
                                c = 0;
                                break;
                            }
                            c = 65535;
                            break;
                        case 1382829617:
                            if (name.equals("StateSet")) {
                                break;
                            }
                            c = 65535;
                            break;
                        case 1901439077:
                            if (name.equals("Variant")) {
                                c = 3;
                                break;
                            }
                            c = 65535;
                            break;
                        default:
                            c = 65535;
                            break;
                    }
                    if (c == 2) {
                        state = new State(context, xmlPullParser);
                        this.KClassImpl$Data$declaredNonStaticMembers$2.put(state.KClassImpl$Data$declaredNonStaticMembers$2, state);
                    } else if (c == 3) {
                        Variant variant = new Variant(context, xmlPullParser);
                        if (state != null) {
                            state.PlaceComponentResult.add(variant);
                        }
                    }
                } else if (eventType != 3) {
                    continue;
                } else if ("StateSet".equals(xmlPullParser.getName())) {
                    return;
                }
                eventType = xmlPullParser.next();
            }
        } catch (IOException | XmlPullParserException unused) {
        }
    }

    public final int getAuthRequestContext(int i) {
        State state;
        int KClassImpl$Data$declaredNonStaticMembers$2;
        if (-1 != i) {
            State state2 = this.KClassImpl$Data$declaredNonStaticMembers$2.get(i);
            if (state2 == null) {
                return -1;
            }
            int KClassImpl$Data$declaredNonStaticMembers$22 = state2.KClassImpl$Data$declaredNonStaticMembers$2(-1.0f, -1.0f);
            return KClassImpl$Data$declaredNonStaticMembers$22 == -1 ? state2.BuiltInFictitiousFunctionClassFactory : state2.PlaceComponentResult.get(KClassImpl$Data$declaredNonStaticMembers$22).KClassImpl$Data$declaredNonStaticMembers$2;
        }
        if (i == -1) {
            state = this.KClassImpl$Data$declaredNonStaticMembers$2.valueAt(0);
        } else {
            state = this.KClassImpl$Data$declaredNonStaticMembers$2.get(this.MyBillsEntityDataFactory);
        }
        if (state == null) {
            return -1;
        }
        if ((this.PlaceComponentResult == -1 || !state.PlaceComponentResult.get(-1).getAuthRequestContext(-1.0f, -1.0f)) && -1 != (KClassImpl$Data$declaredNonStaticMembers$2 = state.KClassImpl$Data$declaredNonStaticMembers$2(-1.0f, -1.0f))) {
            return KClassImpl$Data$declaredNonStaticMembers$2 == -1 ? state.BuiltInFictitiousFunctionClassFactory : state.PlaceComponentResult.get(KClassImpl$Data$declaredNonStaticMembers$2).KClassImpl$Data$declaredNonStaticMembers$2;
        }
        return -1;
    }

    /* loaded from: classes3.dex */
    public static class State {
        public int BuiltInFictitiousFunctionClassFactory;
        int KClassImpl$Data$declaredNonStaticMembers$2;
        public ArrayList<Variant> PlaceComponentResult = new ArrayList<>();
        boolean getAuthRequestContext;

        public State(Context context, XmlPullParser xmlPullParser) {
            this.BuiltInFictitiousFunctionClassFactory = -1;
            this.getAuthRequestContext = false;
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(Xml.asAttributeSet(xmlPullParser), R.styleable.castToIterator);
            int indexCount = obtainStyledAttributes.getIndexCount();
            for (int i = 0; i < indexCount; i++) {
                int index = obtainStyledAttributes.getIndex(i);
                if (index == R.styleable.setProxyNotificationsInitialized) {
                    this.KClassImpl$Data$declaredNonStaticMembers$2 = obtainStyledAttributes.getResourceId(index, this.KClassImpl$Data$declaredNonStaticMembers$2);
                } else if (index == R.styleable.getTodayCalendar) {
                    this.BuiltInFictitiousFunctionClassFactory = obtainStyledAttributes.getResourceId(index, this.BuiltInFictitiousFunctionClassFactory);
                    String resourceTypeName = context.getResources().getResourceTypeName(this.BuiltInFictitiousFunctionClassFactory);
                    context.getResources().getResourceName(this.BuiltInFictitiousFunctionClassFactory);
                    if (BoxData.ATTR_LAYOUT.equals(resourceTypeName)) {
                        this.getAuthRequestContext = true;
                    }
                }
            }
            obtainStyledAttributes.recycle();
        }

        public final int KClassImpl$Data$declaredNonStaticMembers$2(float f, float f2) {
            for (int i = 0; i < this.PlaceComponentResult.size(); i++) {
                if (this.PlaceComponentResult.get(i).getAuthRequestContext(-1.0f, -1.0f)) {
                    return i;
                }
            }
            return -1;
        }
    }

    /* loaded from: classes3.dex */
    public static class Variant {
        float BuiltInFictitiousFunctionClassFactory;
        public int KClassImpl$Data$declaredNonStaticMembers$2;
        float MyBillsEntityDataFactory;
        float PlaceComponentResult;
        boolean getAuthRequestContext;
        float getErrorConfigVersion;

        public Variant(Context context, XmlPullParser xmlPullParser) {
            this.getErrorConfigVersion = Float.NaN;
            this.PlaceComponentResult = Float.NaN;
            this.MyBillsEntityDataFactory = Float.NaN;
            this.BuiltInFictitiousFunctionClassFactory = Float.NaN;
            this.KClassImpl$Data$declaredNonStaticMembers$2 = -1;
            this.getAuthRequestContext = false;
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(Xml.asAttributeSet(xmlPullParser), R.styleable.f17xa318a7bf);
            int indexCount = obtainStyledAttributes.getIndexCount();
            for (int i = 0; i < indexCount; i++) {
                int index = obtainStyledAttributes.getIndex(i);
                if (index == R.styleable.ItemKeyedDataSource$map$1) {
                    this.KClassImpl$Data$declaredNonStaticMembers$2 = obtainStyledAttributes.getResourceId(index, this.KClassImpl$Data$declaredNonStaticMembers$2);
                    String resourceTypeName = context.getResources().getResourceTypeName(this.KClassImpl$Data$declaredNonStaticMembers$2);
                    context.getResources().getResourceName(this.KClassImpl$Data$declaredNonStaticMembers$2);
                    if (BoxData.ATTR_LAYOUT.equals(resourceTypeName)) {
                        this.getAuthRequestContext = true;
                    }
                } else if (index == R.styleable.ItemKeyedDataSource$map$2) {
                    this.BuiltInFictitiousFunctionClassFactory = obtainStyledAttributes.getDimension(index, this.BuiltInFictitiousFunctionClassFactory);
                } else if (index == R.styleable.LTOMLengthOf) {
                    this.PlaceComponentResult = obtainStyledAttributes.getDimension(index, this.PlaceComponentResult);
                } else if (index == R.styleable.getViewConfigIconList) {
                    this.MyBillsEntityDataFactory = obtainStyledAttributes.getDimension(index, this.MyBillsEntityDataFactory);
                } else if (index == R.styleable.ktpDetailModule) {
                    this.getErrorConfigVersion = obtainStyledAttributes.getDimension(index, this.getErrorConfigVersion);
                } else {
                    InstrumentInjector.log_v("ConstraintLayoutStates", "Unknown tag");
                }
            }
            obtainStyledAttributes.recycle();
        }

        public final boolean getAuthRequestContext(float f, float f2) {
            if (Float.isNaN(this.getErrorConfigVersion) || f >= this.getErrorConfigVersion) {
                if (Float.isNaN(this.PlaceComponentResult) || f2 >= this.PlaceComponentResult) {
                    if (Float.isNaN(this.MyBillsEntityDataFactory) || f <= this.MyBillsEntityDataFactory) {
                        return Float.isNaN(this.BuiltInFictitiousFunctionClassFactory) || f2 <= this.BuiltInFictitiousFunctionClassFactory;
                    }
                    return false;
                }
                return false;
            }
            return false;
        }
    }
}
