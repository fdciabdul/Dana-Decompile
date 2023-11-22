package androidx.constraintlayout.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.util.SparseArray;
import android.util.Xml;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import com.alipay.mobile.zebra.data.BoxData;
import com.fullstory.instrumentation.InstrumentInjector;
import id.dana.analytics.tracker.TrackerKey;
import java.io.IOException;
import java.util.ArrayList;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* loaded from: classes3.dex */
public class ConstraintLayoutStates {
    ConstraintSet BuiltInFictitiousFunctionClassFactory;
    private final ConstraintLayout PlaceComponentResult;
    int KClassImpl$Data$declaredNonStaticMembers$2 = -1;
    int getAuthRequestContext = -1;
    private SparseArray<State> NetworkUserEntityData$$ExternalSyntheticLambda0 = new SparseArray<>();
    private SparseArray<ConstraintSet> scheduleImpl = new SparseArray<>();
    ConstraintsChangedListener MyBillsEntityDataFactory = null;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ConstraintLayoutStates(Context context, ConstraintLayout constraintLayout, int i) {
        char c;
        State state = null;
        this.PlaceComponentResult = constraintLayout;
        XmlResourceParser xml = context.getResources().getXml(i);
        try {
            for (int eventType = xml.getEventType(); eventType != 1; eventType = xml.next()) {
                if (eventType == 0) {
                    xml.getName();
                } else if (eventType == 2) {
                    String name = xml.getName();
                    int i2 = 0;
                    switch (name.hashCode()) {
                        case -1349929691:
                            if (name.equals("ConstraintSet")) {
                                c = 4;
                                break;
                            }
                            c = 65535;
                            break;
                        case 80204913:
                            if (name.equals(TrackerKey.Property.STATE)) {
                                c = 2;
                                break;
                            }
                            c = 65535;
                            break;
                        case 1382829617:
                            if (name.equals("StateSet")) {
                                c = 1;
                                break;
                            }
                            c = 65535;
                            break;
                        case 1657696882:
                            if (name.equals("layoutDescription")) {
                                c = 0;
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
                        State state2 = new State(context, xml);
                        this.NetworkUserEntityData$$ExternalSyntheticLambda0.put(state2.getAuthRequestContext, state2);
                        state = state2;
                    } else if (c == 3) {
                        Variant variant = new Variant(context, xml);
                        if (state != null) {
                            state.BuiltInFictitiousFunctionClassFactory.add(variant);
                        }
                    } else if (c == 4) {
                        ConstraintSet constraintSet = new ConstraintSet();
                        int attributeCount = xml.getAttributeCount();
                        while (true) {
                            if (i2 < attributeCount) {
                                String attributeName = xml.getAttributeName(i2);
                                String attributeValue = xml.getAttributeValue(i2);
                                if (attributeName == null || attributeValue == null || !"id".equals(attributeName)) {
                                    i2++;
                                } else {
                                    int identifier = attributeValue.contains("/") ? context.getResources().getIdentifier(attributeValue.substring(attributeValue.indexOf(47) + 1), "id", context.getPackageName()) : -1;
                                    if (identifier == -1) {
                                        if (attributeValue.length() > 1) {
                                            identifier = Integer.parseInt(attributeValue.substring(1));
                                        } else {
                                            InstrumentInjector.log_e("ConstraintLayoutStates", "error in parsing id");
                                        }
                                    }
                                    constraintSet.getAuthRequestContext(context, xml);
                                    this.scheduleImpl.put(identifier, constraintSet);
                                }
                            }
                        }
                    }
                }
            }
        } catch (IOException | XmlPullParserException unused) {
        }
    }

    public final void KClassImpl$Data$declaredNonStaticMembers$2(int i, float f, float f2) {
        ConstraintSet constraintSet;
        State state;
        int authRequestContext;
        ConstraintSet constraintSet2;
        int i2 = this.KClassImpl$Data$declaredNonStaticMembers$2;
        if (i2 == i) {
            if (i == -1) {
                state = this.NetworkUserEntityData$$ExternalSyntheticLambda0.valueAt(0);
            } else {
                state = this.NetworkUserEntityData$$ExternalSyntheticLambda0.get(i2);
            }
            if ((this.getAuthRequestContext == -1 || !state.BuiltInFictitiousFunctionClassFactory.get(this.getAuthRequestContext).MyBillsEntityDataFactory(f, f2)) && this.getAuthRequestContext != (authRequestContext = state.getAuthRequestContext(f, f2))) {
                if (authRequestContext == -1) {
                    constraintSet2 = this.BuiltInFictitiousFunctionClassFactory;
                } else {
                    constraintSet2 = state.BuiltInFictitiousFunctionClassFactory.get(authRequestContext).getAuthRequestContext;
                }
                if (authRequestContext == -1) {
                    int i3 = state.KClassImpl$Data$declaredNonStaticMembers$2;
                } else {
                    int i4 = state.BuiltInFictitiousFunctionClassFactory.get(authRequestContext).BuiltInFictitiousFunctionClassFactory;
                }
                if (constraintSet2 == null) {
                    return;
                }
                this.getAuthRequestContext = authRequestContext;
                constraintSet2.KClassImpl$Data$declaredNonStaticMembers$2(this.PlaceComponentResult);
                if (this.MyBillsEntityDataFactory != null) {
                    return;
                }
                return;
            }
            return;
        }
        this.KClassImpl$Data$declaredNonStaticMembers$2 = i;
        State state2 = this.NetworkUserEntityData$$ExternalSyntheticLambda0.get(i);
        int authRequestContext2 = state2.getAuthRequestContext(f, f2);
        if (authRequestContext2 == -1) {
            constraintSet = state2.MyBillsEntityDataFactory;
        } else {
            constraintSet = state2.BuiltInFictitiousFunctionClassFactory.get(authRequestContext2).getAuthRequestContext;
        }
        if (authRequestContext2 == -1) {
            int i5 = state2.KClassImpl$Data$declaredNonStaticMembers$2;
        } else {
            int i6 = state2.BuiltInFictitiousFunctionClassFactory.get(authRequestContext2).BuiltInFictitiousFunctionClassFactory;
        }
        if (constraintSet == null) {
            StringBuilder sb = new StringBuilder();
            sb.append("NO Constraint set found ! id=");
            sb.append(i);
            sb.append(", dim =");
            sb.append(f);
            sb.append(", ");
            sb.append(f2);
            InstrumentInjector.log_v("ConstraintLayoutStates", sb.toString());
            return;
        }
        this.getAuthRequestContext = authRequestContext2;
        constraintSet.KClassImpl$Data$declaredNonStaticMembers$2(this.PlaceComponentResult);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public static class State {
        ArrayList<Variant> BuiltInFictitiousFunctionClassFactory = new ArrayList<>();
        int KClassImpl$Data$declaredNonStaticMembers$2;
        ConstraintSet MyBillsEntityDataFactory;
        int getAuthRequestContext;

        public State(Context context, XmlPullParser xmlPullParser) {
            this.KClassImpl$Data$declaredNonStaticMembers$2 = -1;
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(Xml.asAttributeSet(xmlPullParser), R.styleable.castToIterator);
            int indexCount = obtainStyledAttributes.getIndexCount();
            for (int i = 0; i < indexCount; i++) {
                int index = obtainStyledAttributes.getIndex(i);
                if (index == R.styleable.setProxyNotificationsInitialized) {
                    this.getAuthRequestContext = obtainStyledAttributes.getResourceId(index, this.getAuthRequestContext);
                } else if (index == R.styleable.getTodayCalendar) {
                    this.KClassImpl$Data$declaredNonStaticMembers$2 = obtainStyledAttributes.getResourceId(index, this.KClassImpl$Data$declaredNonStaticMembers$2);
                    String resourceTypeName = context.getResources().getResourceTypeName(this.KClassImpl$Data$declaredNonStaticMembers$2);
                    context.getResources().getResourceName(this.KClassImpl$Data$declaredNonStaticMembers$2);
                    if (BoxData.ATTR_LAYOUT.equals(resourceTypeName)) {
                        ConstraintSet constraintSet = new ConstraintSet();
                        this.MyBillsEntityDataFactory = constraintSet;
                        constraintSet.getAuthRequestContext((ConstraintLayout) LayoutInflater.from(context).inflate(this.KClassImpl$Data$declaredNonStaticMembers$2, (ViewGroup) null));
                    }
                }
            }
            obtainStyledAttributes.recycle();
        }

        public final int getAuthRequestContext(float f, float f2) {
            for (int i = 0; i < this.BuiltInFictitiousFunctionClassFactory.size(); i++) {
                if (this.BuiltInFictitiousFunctionClassFactory.get(i).MyBillsEntityDataFactory(f, f2)) {
                    return i;
                }
            }
            return -1;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public static class Variant {
        int BuiltInFictitiousFunctionClassFactory;
        float KClassImpl$Data$declaredNonStaticMembers$2;
        float MyBillsEntityDataFactory;
        float PlaceComponentResult;
        ConstraintSet getAuthRequestContext;
        float lookAheadTest;

        public Variant(Context context, XmlPullParser xmlPullParser) {
            this.lookAheadTest = Float.NaN;
            this.PlaceComponentResult = Float.NaN;
            this.KClassImpl$Data$declaredNonStaticMembers$2 = Float.NaN;
            this.MyBillsEntityDataFactory = Float.NaN;
            this.BuiltInFictitiousFunctionClassFactory = -1;
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(Xml.asAttributeSet(xmlPullParser), R.styleable.f17xa318a7bf);
            int indexCount = obtainStyledAttributes.getIndexCount();
            for (int i = 0; i < indexCount; i++) {
                int index = obtainStyledAttributes.getIndex(i);
                if (index == R.styleable.ItemKeyedDataSource$map$1) {
                    this.BuiltInFictitiousFunctionClassFactory = obtainStyledAttributes.getResourceId(index, this.BuiltInFictitiousFunctionClassFactory);
                    String resourceTypeName = context.getResources().getResourceTypeName(this.BuiltInFictitiousFunctionClassFactory);
                    context.getResources().getResourceName(this.BuiltInFictitiousFunctionClassFactory);
                    if (BoxData.ATTR_LAYOUT.equals(resourceTypeName)) {
                        ConstraintSet constraintSet = new ConstraintSet();
                        this.getAuthRequestContext = constraintSet;
                        constraintSet.getAuthRequestContext((ConstraintLayout) LayoutInflater.from(context).inflate(this.BuiltInFictitiousFunctionClassFactory, (ViewGroup) null));
                    }
                } else if (index == R.styleable.ItemKeyedDataSource$map$2) {
                    this.MyBillsEntityDataFactory = obtainStyledAttributes.getDimension(index, this.MyBillsEntityDataFactory);
                } else if (index == R.styleable.LTOMLengthOf) {
                    this.PlaceComponentResult = obtainStyledAttributes.getDimension(index, this.PlaceComponentResult);
                } else if (index == R.styleable.getViewConfigIconList) {
                    this.KClassImpl$Data$declaredNonStaticMembers$2 = obtainStyledAttributes.getDimension(index, this.KClassImpl$Data$declaredNonStaticMembers$2);
                } else if (index == R.styleable.ktpDetailModule) {
                    this.lookAheadTest = obtainStyledAttributes.getDimension(index, this.lookAheadTest);
                } else {
                    InstrumentInjector.log_v("ConstraintLayoutStates", "Unknown tag");
                }
            }
            obtainStyledAttributes.recycle();
        }

        final boolean MyBillsEntityDataFactory(float f, float f2) {
            if (Float.isNaN(this.lookAheadTest) || f >= this.lookAheadTest) {
                if (Float.isNaN(this.PlaceComponentResult) || f2 >= this.PlaceComponentResult) {
                    if (Float.isNaN(this.KClassImpl$Data$declaredNonStaticMembers$2) || f <= this.KClassImpl$Data$declaredNonStaticMembers$2) {
                        return Float.isNaN(this.MyBillsEntityDataFactory) || f2 <= this.MyBillsEntityDataFactory;
                    }
                    return false;
                }
                return false;
            }
            return false;
        }
    }
}
