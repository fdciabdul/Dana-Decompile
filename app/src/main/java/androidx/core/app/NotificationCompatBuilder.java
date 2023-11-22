package androidx.core.app;

import android.app.Notification;
import android.app.Person;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.SparseArray;
import android.widget.RemoteViews;
import androidx.collection.ArraySet;
import androidx.core.app.NotificationCompat;
import androidx.core.graphics.drawable.IconCompat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes3.dex */
public class NotificationCompatBuilder implements NotificationBuilderWithBuilderAccessor {
    private final NotificationCompat.Builder BuiltInFictitiousFunctionClassFactory;
    private RemoteViews KClassImpl$Data$declaredNonStaticMembers$2;
    private final Notification.Builder MyBillsEntityDataFactory;
    private RemoteViews PlaceComponentResult;
    private RemoteViews lookAheadTest;
    private final Context moveToNextValue;
    private int scheduleImpl;
    private final List<Bundle> getAuthRequestContext = new ArrayList();
    private final Bundle NetworkUserEntityData$$ExternalSyntheticLambda0 = new Bundle();

    /* JADX INFO: Access modifiers changed from: package-private */
    public NotificationCompatBuilder(NotificationCompat.Builder builder) {
        android.app.Person build;
        List list;
        List<String> PlaceComponentResult;
        this.BuiltInFictitiousFunctionClassFactory = builder;
        this.moveToNextValue = builder.newProxyInstance;
        if (Build.VERSION.SDK_INT >= 26) {
            this.MyBillsEntityDataFactory = new Notification.Builder(builder.newProxyInstance, builder.NetworkUserEntityData$$ExternalSyntheticLambda0);
        } else {
            this.MyBillsEntityDataFactory = new Notification.Builder(builder.newProxyInstance);
        }
        Notification notification = builder.SubSequence;
        this.MyBillsEntityDataFactory.setWhen(notification.when).setSmallIcon(notification.icon, notification.iconLevel).setContent(notification.contentView).setTicker(notification.tickerText, builder.M).setVibrate(notification.vibrate).setLights(notification.ledARGB, notification.ledOnMS, notification.ledOffMS).setOngoing((notification.flags & 2) != 0).setOnlyAlertOnce((notification.flags & 8) != 0).setAutoCancel((notification.flags & 16) != 0).setDefaults(notification.defaults).setContentTitle(builder.NetworkUserEntityData$$ExternalSyntheticLambda1).setContentText(builder.initRecordTimeStamp).setContentInfo(builder.GetContactSyncConfig).setContentIntent(builder.NetworkUserEntityData$$ExternalSyntheticLambda2).setDeleteIntent(notification.deleteIntent).setFullScreenIntent(builder.PrepareContext, (notification.flags & 128) != 0).setLargeIcon(builder.getCallingPid).setNumber(builder.getSupportButtonTintMode).setProgress(builder.VerifyPinStateManager$executeRiskChallenge$2$2, builder.B, builder.C);
        if (Build.VERSION.SDK_INT < 21) {
            this.MyBillsEntityDataFactory.setSound(notification.sound, notification.audioStreamType);
        }
        if (Build.VERSION.SDK_INT >= 16) {
            this.MyBillsEntityDataFactory.setSubText(builder.L).setUsesChronometer(builder.getNameOrBuilderList).setPriority(builder.A);
            Iterator<NotificationCompat.Action> it = builder.getAuthRequestContext.iterator();
            while (it.hasNext()) {
                BuiltInFictitiousFunctionClassFactory(it.next());
            }
            if (builder.isLayoutRequested != null) {
                this.NetworkUserEntityData$$ExternalSyntheticLambda0.putAll(builder.isLayoutRequested);
            }
            if (Build.VERSION.SDK_INT < 20) {
                if (builder.whenAvailable) {
                    this.NetworkUserEntityData$$ExternalSyntheticLambda0.putBoolean("android.support.localOnly", true);
                }
                if (builder.NetworkUserEntityData$$ExternalSyntheticLambda6 != null) {
                    this.NetworkUserEntityData$$ExternalSyntheticLambda0.putString("android.support.groupKey", builder.NetworkUserEntityData$$ExternalSyntheticLambda6);
                    if (builder.NetworkUserEntityData$$ExternalSyntheticLambda5) {
                        this.NetworkUserEntityData$$ExternalSyntheticLambda0.putBoolean("android.support.isGroupSummary", true);
                    } else {
                        this.NetworkUserEntityData$$ExternalSyntheticLambda0.putBoolean("android.support.useSideChannel", true);
                    }
                }
                if (builder.G != null) {
                    this.NetworkUserEntityData$$ExternalSyntheticLambda0.putString("android.support.sortKey", builder.G);
                }
            }
            this.KClassImpl$Data$declaredNonStaticMembers$2 = builder.NetworkUserEntityData$$ExternalSyntheticLambda8;
            this.PlaceComponentResult = builder.MyBillsEntityDataFactory;
        }
        if (Build.VERSION.SDK_INT >= 17) {
            this.MyBillsEntityDataFactory.setShowWhen(builder.AppCompatEmojiTextHelper);
        }
        if (Build.VERSION.SDK_INT >= 19 && Build.VERSION.SDK_INT < 21 && (PlaceComponentResult = PlaceComponentResult(BuiltInFictitiousFunctionClassFactory(builder.VerifyPinStateManager$executeRiskChallenge$2$1), builder.BottomSheetCardBindingView$watcherCardNumberView$1)) != null && !PlaceComponentResult.isEmpty()) {
            this.NetworkUserEntityData$$ExternalSyntheticLambda0.putStringArray("android.people", (String[]) PlaceComponentResult.toArray(new String[PlaceComponentResult.size()]));
        }
        if (Build.VERSION.SDK_INT >= 20) {
            this.MyBillsEntityDataFactory.setLocalOnly(builder.whenAvailable).setGroup(builder.NetworkUserEntityData$$ExternalSyntheticLambda6).setGroupSummary(builder.NetworkUserEntityData$$ExternalSyntheticLambda5).setSortKey(builder.G);
            this.scheduleImpl = builder.NetworkUserEntityData$$ExternalSyntheticLambda3;
        }
        if (Build.VERSION.SDK_INT >= 21) {
            this.MyBillsEntityDataFactory.setCategory(builder.moveToNextValue).setColor(builder.lookAheadTest).setVisibility(builder.K).setPublicVersion(builder.D).setSound(notification.sound, notification.audioAttributes);
            if (Build.VERSION.SDK_INT < 28) {
                list = PlaceComponentResult(BuiltInFictitiousFunctionClassFactory(builder.VerifyPinStateManager$executeRiskChallenge$2$1), builder.BottomSheetCardBindingView$watcherCardNumberView$1);
            } else {
                list = builder.BottomSheetCardBindingView$watcherCardNumberView$1;
            }
            if (list != null && !list.isEmpty()) {
                Iterator it2 = list.iterator();
                while (it2.hasNext()) {
                    this.MyBillsEntityDataFactory.addPerson((String) it2.next());
                }
            }
            this.lookAheadTest = builder.FragmentBottomSheetPaymentSettingBinding;
            if (builder.NetworkUserEntityData$$ExternalSyntheticLambda4.size() > 0) {
                Bundle bundle = builder.KClassImpl$Data$declaredNonStaticMembers$2().getBundle("android.car.EXTENSIONS");
                bundle = bundle == null ? new Bundle() : bundle;
                Bundle bundle2 = new Bundle(bundle);
                Bundle bundle3 = new Bundle();
                for (int i = 0; i < builder.NetworkUserEntityData$$ExternalSyntheticLambda4.size(); i++) {
                    bundle3.putBundle(Integer.toString(i), NotificationCompatJellybean.MyBillsEntityDataFactory(builder.NetworkUserEntityData$$ExternalSyntheticLambda4.get(i)));
                }
                bundle.putBundle("invisible_actions", bundle3);
                bundle2.putBundle("invisible_actions", bundle3);
                builder.KClassImpl$Data$declaredNonStaticMembers$2().putBundle("android.car.EXTENSIONS", bundle);
                this.NetworkUserEntityData$$ExternalSyntheticLambda0.putBundle("android.car.EXTENSIONS", bundle2);
            }
        }
        if (Build.VERSION.SDK_INT >= 23 && builder.F != null) {
            this.MyBillsEntityDataFactory.setSmallIcon(builder.F);
        }
        if (Build.VERSION.SDK_INT >= 24) {
            this.MyBillsEntityDataFactory.setExtras(builder.isLayoutRequested).setRemoteInputHistory(builder.getValueOfTouchPositionAbsolute);
            if (builder.NetworkUserEntityData$$ExternalSyntheticLambda8 != null) {
                this.MyBillsEntityDataFactory.setCustomContentView(builder.NetworkUserEntityData$$ExternalSyntheticLambda8);
            }
            if (builder.MyBillsEntityDataFactory != null) {
                this.MyBillsEntityDataFactory.setCustomBigContentView(builder.MyBillsEntityDataFactory);
            }
            if (builder.FragmentBottomSheetPaymentSettingBinding != null) {
                this.MyBillsEntityDataFactory.setCustomHeadsUpContentView(builder.FragmentBottomSheetPaymentSettingBinding);
            }
        }
        if (Build.VERSION.SDK_INT >= 26) {
            this.MyBillsEntityDataFactory.setBadgeIconType(builder.BuiltInFictitiousFunctionClassFactory).setSettingsText(builder.getOnBoardingScenario).setShortcutId(builder.E).setTimeoutAfter(builder.J).setGroupAlertBehavior(builder.NetworkUserEntityData$$ExternalSyntheticLambda3);
            if (builder.DatabaseTableConfigUtil) {
                this.MyBillsEntityDataFactory.setColorized(builder.getErrorConfigVersion);
            }
            if (!TextUtils.isEmpty(builder.NetworkUserEntityData$$ExternalSyntheticLambda0)) {
                this.MyBillsEntityDataFactory.setSound(null).setDefaults(0).setLights(0, 0, 0).setVibrate(null);
            }
        }
        if (Build.VERSION.SDK_INT >= 28) {
            Iterator<Person> it3 = builder.VerifyPinStateManager$executeRiskChallenge$2$1.iterator();
            while (it3.hasNext()) {
                Person next = it3.next();
                Notification.Builder builder2 = this.MyBillsEntityDataFactory;
                build = new Person.Builder().setName(next.BuiltInFictitiousFunctionClassFactory).setIcon(r2.PlaceComponentResult != null ? next.PlaceComponentResult.moveToNextValue() : null).setUri(next.scheduleImpl).setKey(next.MyBillsEntityDataFactory).setBot(next.getAuthRequestContext()).setImportant(next.MyBillsEntityDataFactory()).build();
                builder2.addPerson(build);
            }
        }
        if (Build.VERSION.SDK_INT >= 29) {
            this.MyBillsEntityDataFactory.setAllowSystemGeneratedContextualActions(builder.KClassImpl$Data$declaredNonStaticMembers$2);
            this.MyBillsEntityDataFactory.setBubbleMetadata(NotificationCompat.BubbleMetadata.getAuthRequestContext(builder.PlaceComponentResult));
            if (builder.readMicros != null) {
                this.MyBillsEntityDataFactory.setLocusId(builder.readMicros.BuiltInFictitiousFunctionClassFactory());
            }
        }
        if (Build.VERSION.SDK_INT >= 31 && builder.NetworkUserEntityData$$ExternalSyntheticLambda7 != 0) {
            this.MyBillsEntityDataFactory.setForegroundServiceBehavior(builder.NetworkUserEntityData$$ExternalSyntheticLambda7);
        }
        if (builder.H) {
            if (this.BuiltInFictitiousFunctionClassFactory.NetworkUserEntityData$$ExternalSyntheticLambda5) {
                this.scheduleImpl = 2;
            } else {
                this.scheduleImpl = 1;
            }
            this.MyBillsEntityDataFactory.setVibrate(null);
            this.MyBillsEntityDataFactory.setSound(null);
            notification.defaults &= -2;
            notification.defaults &= -3;
            this.MyBillsEntityDataFactory.setDefaults(notification.defaults);
            if (Build.VERSION.SDK_INT >= 26) {
                if (TextUtils.isEmpty(this.BuiltInFictitiousFunctionClassFactory.NetworkUserEntityData$$ExternalSyntheticLambda6)) {
                    this.MyBillsEntityDataFactory.setGroup("silent");
                }
                this.MyBillsEntityDataFactory.setGroupAlertBehavior(this.scheduleImpl);
            }
        }
    }

    private static List<String> PlaceComponentResult(List<String> list, List<String> list2) {
        if (list == null) {
            return list2;
        }
        if (list2 == null) {
            return list;
        }
        ArraySet arraySet = new ArraySet(list.size() + list2.size());
        arraySet.addAll(list);
        arraySet.addAll(list2);
        return new ArrayList(arraySet);
    }

    private static List<String> BuiltInFictitiousFunctionClassFactory(List<Person> list) {
        if (list == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList(list.size());
        for (Person person : list) {
            String str = person.scheduleImpl;
            if (str == null) {
                if (person.BuiltInFictitiousFunctionClassFactory != null) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("name:");
                    sb.append((Object) person.BuiltInFictitiousFunctionClassFactory);
                    str = sb.toString();
                } else {
                    str = "";
                }
            }
            arrayList.add(str);
        }
        return arrayList;
    }

    @Override // androidx.core.app.NotificationBuilderWithBuilderAccessor
    public Notification.Builder KClassImpl$Data$declaredNonStaticMembers$2() {
        return this.MyBillsEntityDataFactory;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Context PlaceComponentResult() {
        return this.moveToNextValue;
    }

    public Notification BuiltInFictitiousFunctionClassFactory() {
        Bundle PlaceComponentResult;
        RemoteViews MyBillsEntityDataFactory;
        RemoteViews authRequestContext;
        NotificationCompat.Style style = this.BuiltInFictitiousFunctionClassFactory.I;
        if (style != null) {
            style.BuiltInFictitiousFunctionClassFactory(this);
        }
        RemoteViews PlaceComponentResult2 = style != null ? style.PlaceComponentResult(this) : null;
        Notification authRequestContext2 = getAuthRequestContext();
        if (PlaceComponentResult2 != null) {
            authRequestContext2.contentView = PlaceComponentResult2;
        } else if (this.BuiltInFictitiousFunctionClassFactory.NetworkUserEntityData$$ExternalSyntheticLambda8 != null) {
            authRequestContext2.contentView = this.BuiltInFictitiousFunctionClassFactory.NetworkUserEntityData$$ExternalSyntheticLambda8;
        }
        if (Build.VERSION.SDK_INT >= 16 && style != null && (authRequestContext = style.getAuthRequestContext(this)) != null) {
            authRequestContext2.bigContentView = authRequestContext;
        }
        if (Build.VERSION.SDK_INT >= 21 && style != null && (MyBillsEntityDataFactory = this.BuiltInFictitiousFunctionClassFactory.I.MyBillsEntityDataFactory(this)) != null) {
            authRequestContext2.headsUpContentView = MyBillsEntityDataFactory;
        }
        if (Build.VERSION.SDK_INT >= 16 && style != null && (PlaceComponentResult = NotificationCompat.PlaceComponentResult(authRequestContext2)) != null) {
            style.MyBillsEntityDataFactory(PlaceComponentResult);
        }
        return authRequestContext2;
    }

    private void BuiltInFictitiousFunctionClassFactory(NotificationCompat.Action action) {
        Notification.Action.Builder builder;
        Bundle bundle;
        if (Build.VERSION.SDK_INT >= 20) {
            IconCompat NetworkUserEntityData$$ExternalSyntheticLambda0 = action.NetworkUserEntityData$$ExternalSyntheticLambda0();
            if (Build.VERSION.SDK_INT >= 23) {
                builder = new Notification.Action.Builder(NetworkUserEntityData$$ExternalSyntheticLambda0 != null ? NetworkUserEntityData$$ExternalSyntheticLambda0.moveToNextValue() : null, action.scheduleImpl(), action.getAuthRequestContext());
            } else {
                builder = new Notification.Action.Builder(NetworkUserEntityData$$ExternalSyntheticLambda0 != null ? NetworkUserEntityData$$ExternalSyntheticLambda0.MyBillsEntityDataFactory() : 0, action.scheduleImpl(), action.getAuthRequestContext());
            }
            if (action.getErrorConfigVersion() != null) {
                for (android.app.RemoteInput remoteInput : RemoteInput.KClassImpl$Data$declaredNonStaticMembers$2(action.getErrorConfigVersion())) {
                    builder.addRemoteInput(remoteInput);
                }
            }
            if (action.MyBillsEntityDataFactory() != null) {
                bundle = new Bundle(action.MyBillsEntityDataFactory());
            } else {
                bundle = new Bundle();
            }
            bundle.putBoolean("android.support.allowGeneratedReplies", action.PlaceComponentResult());
            if (Build.VERSION.SDK_INT >= 24) {
                builder.setAllowGeneratedReplies(action.PlaceComponentResult());
            }
            bundle.putInt("android.support.action.semanticAction", action.lookAheadTest());
            if (Build.VERSION.SDK_INT >= 28) {
                builder.setSemanticAction(action.lookAheadTest());
            }
            if (Build.VERSION.SDK_INT >= 29) {
                builder.setContextual(action.NetworkUserEntityData$$ExternalSyntheticLambda2());
            }
            if (Build.VERSION.SDK_INT >= 31) {
                builder.setAuthenticationRequired(action.DatabaseTableConfigUtil());
            }
            bundle.putBoolean("android.support.action.showsUserInterface", action.moveToNextValue());
            builder.addExtras(bundle);
            this.MyBillsEntityDataFactory.addAction(builder.build());
        } else if (Build.VERSION.SDK_INT >= 16) {
            this.getAuthRequestContext.add(NotificationCompatJellybean.BuiltInFictitiousFunctionClassFactory(this.MyBillsEntityDataFactory, action));
        }
    }

    protected Notification getAuthRequestContext() {
        if (Build.VERSION.SDK_INT >= 26) {
            return this.MyBillsEntityDataFactory.build();
        }
        if (Build.VERSION.SDK_INT >= 24) {
            Notification build = this.MyBillsEntityDataFactory.build();
            if (this.scheduleImpl != 0) {
                if (build.getGroup() != null && (build.flags & 512) != 0 && this.scheduleImpl == 2) {
                    KClassImpl$Data$declaredNonStaticMembers$2(build);
                }
                if (build.getGroup() != null && (build.flags & 512) == 0 && this.scheduleImpl == 1) {
                    KClassImpl$Data$declaredNonStaticMembers$2(build);
                }
            }
            return build;
        } else if (Build.VERSION.SDK_INT >= 21) {
            this.MyBillsEntityDataFactory.setExtras(this.NetworkUserEntityData$$ExternalSyntheticLambda0);
            Notification build2 = this.MyBillsEntityDataFactory.build();
            RemoteViews remoteViews = this.KClassImpl$Data$declaredNonStaticMembers$2;
            if (remoteViews != null) {
                build2.contentView = remoteViews;
            }
            RemoteViews remoteViews2 = this.PlaceComponentResult;
            if (remoteViews2 != null) {
                build2.bigContentView = remoteViews2;
            }
            RemoteViews remoteViews3 = this.lookAheadTest;
            if (remoteViews3 != null) {
                build2.headsUpContentView = remoteViews3;
            }
            if (this.scheduleImpl != 0) {
                if (build2.getGroup() != null && (build2.flags & 512) != 0 && this.scheduleImpl == 2) {
                    KClassImpl$Data$declaredNonStaticMembers$2(build2);
                }
                if (build2.getGroup() != null && (build2.flags & 512) == 0 && this.scheduleImpl == 1) {
                    KClassImpl$Data$declaredNonStaticMembers$2(build2);
                }
            }
            return build2;
        } else if (Build.VERSION.SDK_INT >= 20) {
            this.MyBillsEntityDataFactory.setExtras(this.NetworkUserEntityData$$ExternalSyntheticLambda0);
            Notification build3 = this.MyBillsEntityDataFactory.build();
            RemoteViews remoteViews4 = this.KClassImpl$Data$declaredNonStaticMembers$2;
            if (remoteViews4 != null) {
                build3.contentView = remoteViews4;
            }
            RemoteViews remoteViews5 = this.PlaceComponentResult;
            if (remoteViews5 != null) {
                build3.bigContentView = remoteViews5;
            }
            if (this.scheduleImpl != 0) {
                if (build3.getGroup() != null && (build3.flags & 512) != 0 && this.scheduleImpl == 2) {
                    KClassImpl$Data$declaredNonStaticMembers$2(build3);
                }
                if (build3.getGroup() != null && (build3.flags & 512) == 0 && this.scheduleImpl == 1) {
                    KClassImpl$Data$declaredNonStaticMembers$2(build3);
                }
            }
            return build3;
        } else if (Build.VERSION.SDK_INT >= 19) {
            SparseArray<Bundle> MyBillsEntityDataFactory = NotificationCompatJellybean.MyBillsEntityDataFactory(this.getAuthRequestContext);
            if (MyBillsEntityDataFactory != null) {
                this.NetworkUserEntityData$$ExternalSyntheticLambda0.putSparseParcelableArray("android.support.actionExtras", MyBillsEntityDataFactory);
            }
            this.MyBillsEntityDataFactory.setExtras(this.NetworkUserEntityData$$ExternalSyntheticLambda0);
            Notification build4 = this.MyBillsEntityDataFactory.build();
            RemoteViews remoteViews6 = this.KClassImpl$Data$declaredNonStaticMembers$2;
            if (remoteViews6 != null) {
                build4.contentView = remoteViews6;
            }
            RemoteViews remoteViews7 = this.PlaceComponentResult;
            if (remoteViews7 != null) {
                build4.bigContentView = remoteViews7;
            }
            return build4;
        } else if (Build.VERSION.SDK_INT >= 16) {
            Notification build5 = this.MyBillsEntityDataFactory.build();
            Bundle PlaceComponentResult = NotificationCompat.PlaceComponentResult(build5);
            Bundle bundle = new Bundle(this.NetworkUserEntityData$$ExternalSyntheticLambda0);
            for (String str : this.NetworkUserEntityData$$ExternalSyntheticLambda0.keySet()) {
                if (PlaceComponentResult.containsKey(str)) {
                    bundle.remove(str);
                }
            }
            PlaceComponentResult.putAll(bundle);
            SparseArray<Bundle> MyBillsEntityDataFactory2 = NotificationCompatJellybean.MyBillsEntityDataFactory(this.getAuthRequestContext);
            if (MyBillsEntityDataFactory2 != null) {
                NotificationCompat.PlaceComponentResult(build5).putSparseParcelableArray("android.support.actionExtras", MyBillsEntityDataFactory2);
            }
            RemoteViews remoteViews8 = this.KClassImpl$Data$declaredNonStaticMembers$2;
            if (remoteViews8 != null) {
                build5.contentView = remoteViews8;
            }
            RemoteViews remoteViews9 = this.PlaceComponentResult;
            if (remoteViews9 != null) {
                build5.bigContentView = remoteViews9;
            }
            return build5;
        } else {
            return this.MyBillsEntityDataFactory.getNotification();
        }
    }

    private void KClassImpl$Data$declaredNonStaticMembers$2(Notification notification) {
        notification.sound = null;
        notification.vibrate = null;
        notification.defaults &= -2;
        notification.defaults &= -3;
    }
}
