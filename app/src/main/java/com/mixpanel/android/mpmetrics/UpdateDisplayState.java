package com.mixpanel.android.mpmetrics;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.mixpanel.android.util.MPLog;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.ReentrantLock;

/* loaded from: classes.dex */
public class UpdateDisplayState implements Parcelable {
    public final DisplayState KClassImpl$Data$declaredNonStaticMembers$2;
    public final String PlaceComponentResult;
    private final String lookAheadTest;
    public static final Parcelable.Creator<UpdateDisplayState> CREATOR = new Parcelable.Creator<UpdateDisplayState>() { // from class: com.mixpanel.android.mpmetrics.UpdateDisplayState.1
        @Override // android.os.Parcelable.Creator
        public /* synthetic */ UpdateDisplayState createFromParcel(Parcel parcel) {
            Bundle bundle = new Bundle(UpdateDisplayState.class.getClassLoader());
            bundle.readFromParcel(parcel);
            return new UpdateDisplayState(bundle, (byte) 0);
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ UpdateDisplayState[] newArray(int i) {
            return new UpdateDisplayState[i];
        }
    };
    private static final ReentrantLock MyBillsEntityDataFactory = new ReentrantLock();
    private static long getErrorConfigVersion = -1;
    private static UpdateDisplayState scheduleImpl = null;
    private static int getAuthRequestContext = 0;
    private static int BuiltInFictitiousFunctionClassFactory = -1;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    /* synthetic */ UpdateDisplayState(Bundle bundle, byte b) {
        this(bundle);
    }

    /* loaded from: classes.dex */
    public static abstract class DisplayState implements Parcelable {
        public static final Parcelable.Creator<DisplayState> CREATOR = new Parcelable.Creator<DisplayState>() { // from class: com.mixpanel.android.mpmetrics.UpdateDisplayState.DisplayState.1
            @Override // android.os.Parcelable.Creator
            public /* synthetic */ DisplayState createFromParcel(Parcel parcel) {
                Bundle bundle = new Bundle(DisplayState.class.getClassLoader());
                bundle.readFromParcel(parcel);
                String string = bundle.getString("com.mixpanel.android.mpmetrics.UpdateDisplayState.DisplayState.STATE_TYPE_KEY");
                Bundle bundle2 = bundle.getBundle("com.mixpanel.android.mpmetrics.UpdateDisplayState.DisplayState.STATE_IMPL_KEY");
                if ("InAppNotificationState".equals(string)) {
                    return new InAppNotificationState(bundle2, (byte) 0);
                }
                StringBuilder sb = new StringBuilder();
                sb.append("Unrecognized display state type ");
                sb.append(string);
                throw new RuntimeException(sb.toString());
            }

            @Override // android.os.Parcelable.Creator
            public /* bridge */ /* synthetic */ DisplayState[] newArray(int i) {
                return new DisplayState[i];
            }
        };

        /* synthetic */ DisplayState(byte b) {
            this();
        }

        private DisplayState() {
        }

        /* loaded from: classes.dex */
        public static final class InAppNotificationState extends DisplayState {
            public static final Parcelable.Creator<InAppNotificationState> CREATOR = new Parcelable.Creator<InAppNotificationState>() { // from class: com.mixpanel.android.mpmetrics.UpdateDisplayState.DisplayState.InAppNotificationState.1
                @Override // android.os.Parcelable.Creator
                public /* synthetic */ InAppNotificationState createFromParcel(Parcel parcel) {
                    Bundle bundle = new Bundle(InAppNotificationState.class.getClassLoader());
                    bundle.readFromParcel(parcel);
                    return new InAppNotificationState(bundle, (byte) 0);
                }

                @Override // android.os.Parcelable.Creator
                public /* bridge */ /* synthetic */ InAppNotificationState[] newArray(int i) {
                    return new InAppNotificationState[i];
                }
            };
            private static String MyBillsEntityDataFactory = "com.com.mixpanel.android.mpmetrics.UpdateDisplayState.InAppNotificationState.INAPP_KEY";
            private static String getAuthRequestContext = "com.com.mixpanel.android.mpmetrics.UpdateDisplayState.InAppNotificationState.HIGHLIGHT_KEY";
            public final InAppNotification BuiltInFictitiousFunctionClassFactory;
            private final int PlaceComponentResult;

            @Override // android.os.Parcelable
            public final int describeContents() {
                return 0;
            }

            /* synthetic */ InAppNotificationState(Bundle bundle, byte b) {
                this(bundle);
            }

            public InAppNotificationState(InAppNotification inAppNotification, int i) {
                super((byte) 0);
                this.BuiltInFictitiousFunctionClassFactory = inAppNotification;
                this.PlaceComponentResult = i;
            }

            @Override // android.os.Parcelable
            public final void writeToParcel(Parcel parcel, int i) {
                Bundle bundle = new Bundle();
                bundle.putParcelable(MyBillsEntityDataFactory, this.BuiltInFictitiousFunctionClassFactory);
                bundle.putInt(getAuthRequestContext, this.PlaceComponentResult);
                parcel.writeBundle(bundle);
            }

            private InAppNotificationState(Bundle bundle) {
                super((byte) 0);
                this.BuiltInFictitiousFunctionClassFactory = (InAppNotification) bundle.getParcelable(MyBillsEntityDataFactory);
                this.PlaceComponentResult = bundle.getInt(getAuthRequestContext);
            }
        }
    }

    /* loaded from: classes.dex */
    public static class AnswerMap implements Parcelable {
        public static final Parcelable.Creator<AnswerMap> CREATOR = new Parcelable.Creator<AnswerMap>() { // from class: com.mixpanel.android.mpmetrics.UpdateDisplayState.AnswerMap.1
            @Override // android.os.Parcelable.Creator
            public /* synthetic */ AnswerMap createFromParcel(Parcel parcel) {
                Bundle bundle = new Bundle(AnswerMap.class.getClassLoader());
                AnswerMap answerMap = new AnswerMap();
                bundle.readFromParcel(parcel);
                for (String str : bundle.keySet()) {
                    answerMap.PlaceComponentResult.put(Integer.valueOf(str), bundle.getString(str));
                }
                return answerMap;
            }

            @Override // android.os.Parcelable.Creator
            public /* bridge */ /* synthetic */ AnswerMap[] newArray(int i) {
                return new AnswerMap[i];
            }
        };
        final HashMap<Integer, String> PlaceComponentResult = new HashMap<>();

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            Bundle bundle = new Bundle();
            for (Map.Entry<Integer, String> entry : this.PlaceComponentResult.entrySet()) {
                bundle.putString(Integer.toString(entry.getKey().intValue()), entry.getValue());
            }
            parcel.writeBundle(bundle);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static ReentrantLock getAuthRequestContext() {
        return MyBillsEntityDataFactory;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean MyBillsEntityDataFactory() {
        if (!MyBillsEntityDataFactory.isHeldByCurrentThread()) {
            throw new AssertionError();
        }
        long currentTimeMillis = System.currentTimeMillis();
        long j = getErrorConfigVersion;
        if (getAuthRequestContext > 0 && currentTimeMillis - j > 43200000) {
            MPLog.MyBillsEntityDataFactory("MixpanelAPI.UpDisplSt", "UpdateDisplayState set long, long ago, without showing. Update state will be cleared.");
            scheduleImpl = null;
        }
        return scheduleImpl != null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int BuiltInFictitiousFunctionClassFactory(DisplayState displayState, String str, String str2) {
        if (!MyBillsEntityDataFactory.isHeldByCurrentThread()) {
            throw new AssertionError();
        }
        if (!MyBillsEntityDataFactory()) {
            getErrorConfigVersion = System.currentTimeMillis();
            scheduleImpl = new UpdateDisplayState(displayState, str, str2);
            int i = getAuthRequestContext + 1;
            getAuthRequestContext = i;
            return i;
        }
        MPLog.KClassImpl$Data$declaredNonStaticMembers$2("MixpanelAPI.UpDisplSt", "Already showing (or cooking) a Mixpanel update, declining to show another.");
        return -1;
    }

    public static void BuiltInFictitiousFunctionClassFactory(int i) {
        ReentrantLock reentrantLock = MyBillsEntityDataFactory;
        reentrantLock.lock();
        try {
            if (i == BuiltInFictitiousFunctionClassFactory) {
                BuiltInFictitiousFunctionClassFactory = -1;
                scheduleImpl = null;
            }
            reentrantLock.unlock();
        } catch (Throwable th) {
            MyBillsEntityDataFactory.unlock();
            throw th;
        }
    }

    public static UpdateDisplayState MyBillsEntityDataFactory(int i) {
        ReentrantLock reentrantLock = MyBillsEntityDataFactory;
        reentrantLock.lock();
        try {
            int i2 = BuiltInFictitiousFunctionClassFactory;
            if (i2 <= 0 || i2 == i) {
                if (scheduleImpl != null) {
                    getErrorConfigVersion = System.currentTimeMillis();
                    BuiltInFictitiousFunctionClassFactory = i;
                    UpdateDisplayState updateDisplayState = scheduleImpl;
                    reentrantLock.unlock();
                    return updateDisplayState;
                }
                reentrantLock.unlock();
                return null;
            }
            reentrantLock.unlock();
            return null;
        } catch (Throwable th) {
            MyBillsEntityDataFactory.unlock();
            throw th;
        }
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        Bundle bundle = new Bundle();
        bundle.putString("com.mixpanel.android.mpmetrics.UpdateDisplayState.DISTINCT_ID_BUNDLE_KEY", this.lookAheadTest);
        bundle.putString("com.mixpanel.android.mpmetrics.UpdateDisplayState.TOKEN_BUNDLE_KEY", this.PlaceComponentResult);
        bundle.putParcelable("com.mixpanel.android.mpmetrics.UpdateDisplayState.DISPLAYSTATE_BUNDLE_KEY", this.KClassImpl$Data$declaredNonStaticMembers$2);
        parcel.writeBundle(bundle);
    }

    private UpdateDisplayState(DisplayState displayState, String str, String str2) {
        this.lookAheadTest = str;
        this.PlaceComponentResult = str2;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = displayState;
    }

    private UpdateDisplayState(Bundle bundle) {
        this.lookAheadTest = bundle.getString("com.mixpanel.android.mpmetrics.UpdateDisplayState.DISTINCT_ID_BUNDLE_KEY");
        this.PlaceComponentResult = bundle.getString("com.mixpanel.android.mpmetrics.UpdateDisplayState.TOKEN_BUNDLE_KEY");
        this.KClassImpl$Data$declaredNonStaticMembers$2 = (DisplayState) bundle.getParcelable("com.mixpanel.android.mpmetrics.UpdateDisplayState.DISPLAYSTATE_BUNDLE_KEY");
    }
}
