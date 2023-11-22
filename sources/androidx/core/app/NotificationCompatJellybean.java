package androidx.core.app;

import android.app.Notification;
import android.os.Bundle;
import android.util.SparseArray;
import androidx.core.app.NotificationCompat;
import androidx.core.graphics.drawable.IconCompat;
import com.fullstory.instrumentation.InstrumentInjector;
import com.google.firebase.messaging.Constants;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes3.dex */
public class NotificationCompatJellybean {
    private static Field MyBillsEntityDataFactory;
    private static boolean PlaceComponentResult;
    private static final Object KClassImpl$Data$declaredNonStaticMembers$2 = new Object();
    private static final Object getAuthRequestContext = new Object();

    public static SparseArray<Bundle> MyBillsEntityDataFactory(List<Bundle> list) {
        int size = list.size();
        SparseArray<Bundle> sparseArray = null;
        for (int i = 0; i < size; i++) {
            Bundle bundle = list.get(i);
            if (bundle != null) {
                if (sparseArray == null) {
                    sparseArray = new SparseArray<>();
                }
                sparseArray.put(i, bundle);
            }
        }
        return sparseArray;
    }

    public static Bundle KClassImpl$Data$declaredNonStaticMembers$2(Notification notification) {
        synchronized (KClassImpl$Data$declaredNonStaticMembers$2) {
            if (PlaceComponentResult) {
                return null;
            }
            try {
                if (MyBillsEntityDataFactory == null) {
                    Field declaredField = Notification.class.getDeclaredField("extras");
                    if (!Bundle.class.isAssignableFrom(declaredField.getType())) {
                        InstrumentInjector.log_e("NotificationCompat", "Notification.extras field is not of type Bundle");
                        PlaceComponentResult = true;
                        return null;
                    }
                    declaredField.setAccessible(true);
                    MyBillsEntityDataFactory = declaredField;
                }
                Bundle bundle = (Bundle) MyBillsEntityDataFactory.get(notification);
                if (bundle == null) {
                    bundle = new Bundle();
                    MyBillsEntityDataFactory.set(notification, bundle);
                }
                return bundle;
            } catch (IllegalAccessException e) {
                InstrumentInjector.log_e("NotificationCompat", "Unable to access notification extras", e);
                PlaceComponentResult = true;
                return null;
            } catch (NoSuchFieldException e2) {
                InstrumentInjector.log_e("NotificationCompat", "Unable to access notification extras", e2);
                PlaceComponentResult = true;
                return null;
            }
        }
    }

    public static Bundle BuiltInFictitiousFunctionClassFactory(Notification.Builder builder, NotificationCompat.Action action) {
        IconCompat NetworkUserEntityData$$ExternalSyntheticLambda0 = action.NetworkUserEntityData$$ExternalSyntheticLambda0();
        builder.addAction(NetworkUserEntityData$$ExternalSyntheticLambda0 != null ? NetworkUserEntityData$$ExternalSyntheticLambda0.MyBillsEntityDataFactory() : 0, action.scheduleImpl(), action.getAuthRequestContext());
        Bundle bundle = new Bundle(action.MyBillsEntityDataFactory());
        if (action.getErrorConfigVersion() != null) {
            bundle.putParcelableArray("android.support.remoteInputs", MyBillsEntityDataFactory(action.getErrorConfigVersion()));
        }
        if (action.BuiltInFictitiousFunctionClassFactory() != null) {
            bundle.putParcelableArray("android.support.dataRemoteInputs", MyBillsEntityDataFactory(action.BuiltInFictitiousFunctionClassFactory()));
        }
        bundle.putBoolean("android.support.allowGeneratedReplies", action.PlaceComponentResult());
        return bundle;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Bundle MyBillsEntityDataFactory(NotificationCompat.Action action) {
        Bundle bundle;
        Bundle bundle2 = new Bundle();
        IconCompat NetworkUserEntityData$$ExternalSyntheticLambda0 = action.NetworkUserEntityData$$ExternalSyntheticLambda0();
        bundle2.putInt("icon", NetworkUserEntityData$$ExternalSyntheticLambda0 != null ? NetworkUserEntityData$$ExternalSyntheticLambda0.MyBillsEntityDataFactory() : 0);
        bundle2.putCharSequence("title", action.scheduleImpl());
        bundle2.putParcelable("actionIntent", action.getAuthRequestContext());
        if (action.MyBillsEntityDataFactory() != null) {
            bundle = new Bundle(action.MyBillsEntityDataFactory());
        } else {
            bundle = new Bundle();
        }
        bundle.putBoolean("android.support.allowGeneratedReplies", action.PlaceComponentResult());
        bundle2.putBundle("extras", bundle);
        bundle2.putParcelableArray("remoteInputs", MyBillsEntityDataFactory(action.getErrorConfigVersion()));
        bundle2.putBoolean("showsUserInterface", action.moveToNextValue());
        bundle2.putInt("semanticAction", action.lookAheadTest());
        return bundle2;
    }

    private static Bundle MyBillsEntityDataFactory(RemoteInput remoteInput) {
        Bundle bundle = new Bundle();
        bundle.putString("resultKey", remoteInput.moveToNextValue);
        bundle.putCharSequence(Constants.ScionAnalytics.PARAM_LABEL, remoteInput.getAuthRequestContext);
        bundle.putCharSequenceArray("choices", remoteInput.PlaceComponentResult);
        bundle.putBoolean("allowFreeFormInput", remoteInput.KClassImpl$Data$declaredNonStaticMembers$2());
        bundle.putBundle("extras", remoteInput.BuiltInFictitiousFunctionClassFactory);
        Set<String> set = remoteInput.KClassImpl$Data$declaredNonStaticMembers$2;
        if (set != null && !set.isEmpty()) {
            ArrayList<String> arrayList = new ArrayList<>(set.size());
            Iterator<String> it = set.iterator();
            while (it.hasNext()) {
                arrayList.add(it.next());
            }
            bundle.putStringArrayList("allowedDataTypes", arrayList);
        }
        return bundle;
    }

    private static Bundle[] MyBillsEntityDataFactory(RemoteInput[] remoteInputArr) {
        if (remoteInputArr == null) {
            return null;
        }
        Bundle[] bundleArr = new Bundle[remoteInputArr.length];
        for (int i = 0; i < remoteInputArr.length; i++) {
            bundleArr[i] = MyBillsEntityDataFactory(remoteInputArr[i]);
        }
        return bundleArr;
    }

    private NotificationCompatJellybean() {
    }
}
