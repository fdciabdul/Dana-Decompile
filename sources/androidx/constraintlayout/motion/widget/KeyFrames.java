package androidx.constraintlayout.motion.widget;

import android.content.Context;
import android.util.Xml;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.constraintlayout.widget.ConstraintAttribute;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.fullstory.instrumentation.InstrumentInjector;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* loaded from: classes3.dex */
public class KeyFrames {
    static HashMap<String, Constructor<? extends Key>> BuiltInFictitiousFunctionClassFactory;
    HashMap<Integer, ArrayList<Key>> PlaceComponentResult = new HashMap<>();

    static {
        HashMap<String, Constructor<? extends Key>> hashMap = new HashMap<>();
        BuiltInFictitiousFunctionClassFactory = hashMap;
        try {
            hashMap.put("KeyAttribute", KeyAttributes.class.getConstructor(new Class[0]));
            BuiltInFictitiousFunctionClassFactory.put(TypedValues.PositionType.getAuthRequestContext, KeyPosition.class.getConstructor(new Class[0]));
            BuiltInFictitiousFunctionClassFactory.put(TypedValues.CycleType.KClassImpl$Data$declaredNonStaticMembers$2, KeyCycle.class.getConstructor(new Class[0]));
            BuiltInFictitiousFunctionClassFactory.put("KeyTimeCycle", KeyTimeCycle.class.getConstructor(new Class[0]));
            BuiltInFictitiousFunctionClassFactory.put(TypedValues.TriggerType.MyBillsEntityDataFactory, KeyTrigger.class.getConstructor(new Class[0]));
        } catch (NoSuchMethodException e) {
            InstrumentInjector.log_e("KeyFrames", "unable to load", e);
        }
    }

    public final void KClassImpl$Data$declaredNonStaticMembers$2(Key key) {
        if (!this.PlaceComponentResult.containsKey(Integer.valueOf(key.KClassImpl$Data$declaredNonStaticMembers$2))) {
            this.PlaceComponentResult.put(Integer.valueOf(key.KClassImpl$Data$declaredNonStaticMembers$2), new ArrayList<>());
        }
        ArrayList<Key> arrayList = this.PlaceComponentResult.get(Integer.valueOf(key.KClassImpl$Data$declaredNonStaticMembers$2));
        if (arrayList != null) {
            arrayList.add(key);
        }
    }

    public KeyFrames() {
    }

    public KeyFrames(Context context, XmlPullParser xmlPullParser) {
        Exception e;
        Key key;
        Constructor<? extends Key> constructor;
        try {
            int eventType = xmlPullParser.getEventType();
            Key key2 = null;
            while (eventType != 1) {
                if (eventType == 2) {
                    String name = xmlPullParser.getName();
                    if (BuiltInFictitiousFunctionClassFactory.containsKey(name)) {
                        try {
                            constructor = BuiltInFictitiousFunctionClassFactory.get(name);
                        } catch (Exception e2) {
                            Key key3 = key2;
                            e = e2;
                            key = key3;
                        }
                        if (constructor != null) {
                            key = constructor.newInstance(new Object[0]);
                            try {
                                key.getAuthRequestContext(context, Xml.asAttributeSet(xmlPullParser));
                                KClassImpl$Data$declaredNonStaticMembers$2(key);
                            } catch (Exception e3) {
                                e = e3;
                                InstrumentInjector.log_e("KeyFrames", "unable to create ", e);
                                key2 = key;
                                eventType = xmlPullParser.next();
                            }
                            key2 = key;
                        } else {
                            StringBuilder sb = new StringBuilder();
                            sb.append("Keymaker for ");
                            sb.append(name);
                            sb.append(" not found");
                            throw new NullPointerException(sb.toString());
                            break;
                        }
                    } else if (name.equalsIgnoreCase("CustomAttribute")) {
                        if (key2 != null && key2.MyBillsEntityDataFactory != null) {
                            ConstraintAttribute.MyBillsEntityDataFactory(context, xmlPullParser, key2.MyBillsEntityDataFactory);
                        }
                    } else if (name.equalsIgnoreCase("CustomMethod") && key2 != null && key2.MyBillsEntityDataFactory != null) {
                        ConstraintAttribute.MyBillsEntityDataFactory(context, xmlPullParser, key2.MyBillsEntityDataFactory);
                    }
                } else if (eventType == 3 && "KeyFrameSet".equals(xmlPullParser.getName())) {
                    return;
                }
                eventType = xmlPullParser.next();
            }
        } catch (IOException | XmlPullParserException unused) {
        }
    }

    public final void BuiltInFictitiousFunctionClassFactory(MotionController motionController) {
        ArrayList<Key> arrayList = this.PlaceComponentResult.get(Integer.valueOf(motionController.getErrorConfigVersion));
        if (arrayList != null) {
            motionController.NetworkUserEntityData$$ExternalSyntheticLambda1.addAll(arrayList);
        }
        ArrayList<Key> arrayList2 = this.PlaceComponentResult.get(-1);
        if (arrayList2 != null) {
            Iterator<Key> it = arrayList2.iterator();
            while (it.hasNext()) {
                Key next = it.next();
                if (next.BuiltInFictitiousFunctionClassFactory(((ConstraintLayout.LayoutParams) motionController.getSupportButtonTintMode.getLayoutParams()).DatabaseTableConfigUtil)) {
                    motionController.NetworkUserEntityData$$ExternalSyntheticLambda1.add(next);
                }
            }
        }
    }
}
