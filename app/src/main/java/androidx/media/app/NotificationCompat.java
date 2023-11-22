package androidx.media.app;

import android.app.Notification;
import android.app.PendingIntent;
import android.media.session.MediaSession;
import android.os.Build;
import android.support.v4.media.session.MediaSessionCompat;
import android.widget.RemoteViews;
import androidx.core.app.NotificationBuilderWithBuilderAccessor;
import androidx.core.app.NotificationCompat;
import androidx.media.R;

/* loaded from: classes6.dex */
public class NotificationCompat {
    private NotificationCompat() {
    }

    /* loaded from: classes6.dex */
    public static class MediaStyle extends NotificationCompat.Style {
        PendingIntent PlaceComponentResult;
        int[] getAuthRequestContext = null;
        boolean moveToNextValue;
        MediaSessionCompat.Token scheduleImpl;

        @Override // androidx.core.app.NotificationCompat.Style
        public void BuiltInFictitiousFunctionClassFactory(NotificationBuilderWithBuilderAccessor notificationBuilderWithBuilderAccessor) {
            if (Build.VERSION.SDK_INT >= 21) {
                notificationBuilderWithBuilderAccessor.KClassImpl$Data$declaredNonStaticMembers$2().setStyle(KClassImpl$Data$declaredNonStaticMembers$2(new Notification.MediaStyle()));
            } else if (this.moveToNextValue) {
                notificationBuilderWithBuilderAccessor.KClassImpl$Data$declaredNonStaticMembers$2().setOngoing(true);
            }
        }

        Notification.MediaStyle KClassImpl$Data$declaredNonStaticMembers$2(Notification.MediaStyle mediaStyle) {
            int[] iArr = this.getAuthRequestContext;
            if (iArr != null) {
                mediaStyle.setShowActionsInCompactView(iArr);
            }
            MediaSessionCompat.Token token = this.scheduleImpl;
            if (token != null) {
                mediaStyle.setMediaSession((MediaSession.Token) token.KClassImpl$Data$declaredNonStaticMembers$2());
            }
            return mediaStyle;
        }

        @Override // androidx.core.app.NotificationCompat.Style
        public RemoteViews PlaceComponentResult(NotificationBuilderWithBuilderAccessor notificationBuilderWithBuilderAccessor) {
            if (Build.VERSION.SDK_INT >= 21) {
                return null;
            }
            return getAuthRequestContext();
        }

        RemoteViews getAuthRequestContext() {
            RemoteViews authRequestContext = getAuthRequestContext(false, MyBillsEntityDataFactory(), true);
            int size = this.BuiltInFictitiousFunctionClassFactory.getAuthRequestContext.size();
            int[] iArr = this.getAuthRequestContext;
            int min = iArr == null ? 0 : Math.min(iArr.length, 3);
            authRequestContext.removeAllViews(R.id.PlaceComponentResult);
            if (min > 0) {
                for (int i = 0; i < min; i++) {
                    if (i >= size) {
                        throw new IllegalArgumentException(String.format("setShowActionsInCompactView: action %d out of bounds (max %d)", Integer.valueOf(i), Integer.valueOf(size - 1)));
                    }
                    authRequestContext.addView(R.id.PlaceComponentResult, MyBillsEntityDataFactory(this.BuiltInFictitiousFunctionClassFactory.getAuthRequestContext.get(this.getAuthRequestContext[i])));
                }
            }
            if (this.moveToNextValue) {
                authRequestContext.setViewVisibility(R.id.BuiltInFictitiousFunctionClassFactory, 8);
                authRequestContext.setViewVisibility(R.id.getAuthRequestContext, 0);
                authRequestContext.setOnClickPendingIntent(R.id.getAuthRequestContext, this.PlaceComponentResult);
                authRequestContext.setInt(R.id.getAuthRequestContext, "setAlpha", this.BuiltInFictitiousFunctionClassFactory.newProxyInstance.getResources().getInteger(R.integer.KClassImpl$Data$declaredNonStaticMembers$2));
            } else {
                authRequestContext.setViewVisibility(R.id.BuiltInFictitiousFunctionClassFactory, 0);
                authRequestContext.setViewVisibility(R.id.getAuthRequestContext, 8);
            }
            return authRequestContext;
        }

        private RemoteViews MyBillsEntityDataFactory(NotificationCompat.Action action) {
            boolean z = action.getAuthRequestContext() == null;
            RemoteViews remoteViews = new RemoteViews(this.BuiltInFictitiousFunctionClassFactory.newProxyInstance.getPackageName(), R.layout.PlaceComponentResult);
            remoteViews.setImageViewResource(R.id.KClassImpl$Data$declaredNonStaticMembers$2, action.KClassImpl$Data$declaredNonStaticMembers$2());
            if (!z) {
                remoteViews.setOnClickPendingIntent(R.id.KClassImpl$Data$declaredNonStaticMembers$2, action.getAuthRequestContext());
            }
            if (Build.VERSION.SDK_INT >= 15) {
                remoteViews.setContentDescription(R.id.KClassImpl$Data$declaredNonStaticMembers$2, action.scheduleImpl());
            }
            return remoteViews;
        }

        int MyBillsEntityDataFactory() {
            return R.layout.NetworkUserEntityData$$ExternalSyntheticLambda0;
        }

        @Override // androidx.core.app.NotificationCompat.Style
        public RemoteViews getAuthRequestContext(NotificationBuilderWithBuilderAccessor notificationBuilderWithBuilderAccessor) {
            if (Build.VERSION.SDK_INT >= 21) {
                return null;
            }
            return KClassImpl$Data$declaredNonStaticMembers$2();
        }

        RemoteViews KClassImpl$Data$declaredNonStaticMembers$2() {
            int min = Math.min(this.BuiltInFictitiousFunctionClassFactory.getAuthRequestContext.size(), 5);
            RemoteViews authRequestContext = getAuthRequestContext(false, MyBillsEntityDataFactory(min), false);
            authRequestContext.removeAllViews(R.id.PlaceComponentResult);
            if (min > 0) {
                for (int i = 0; i < min; i++) {
                    authRequestContext.addView(R.id.PlaceComponentResult, MyBillsEntityDataFactory(this.BuiltInFictitiousFunctionClassFactory.getAuthRequestContext.get(i)));
                }
            }
            if (this.moveToNextValue) {
                authRequestContext.setViewVisibility(R.id.getAuthRequestContext, 0);
                authRequestContext.setInt(R.id.getAuthRequestContext, "setAlpha", this.BuiltInFictitiousFunctionClassFactory.newProxyInstance.getResources().getInteger(R.integer.KClassImpl$Data$declaredNonStaticMembers$2));
                authRequestContext.setOnClickPendingIntent(R.id.getAuthRequestContext, this.PlaceComponentResult);
            } else {
                authRequestContext.setViewVisibility(R.id.getAuthRequestContext, 8);
            }
            return authRequestContext;
        }

        int MyBillsEntityDataFactory(int i) {
            return i <= 3 ? R.layout.KClassImpl$Data$declaredNonStaticMembers$2 : R.layout.getAuthRequestContext;
        }
    }

    /* loaded from: classes6.dex */
    public static class DecoratedMediaCustomViewStyle extends MediaStyle {
        @Override // androidx.media.app.NotificationCompat.MediaStyle, androidx.core.app.NotificationCompat.Style
        public void BuiltInFictitiousFunctionClassFactory(NotificationBuilderWithBuilderAccessor notificationBuilderWithBuilderAccessor) {
            if (Build.VERSION.SDK_INT >= 24) {
                notificationBuilderWithBuilderAccessor.KClassImpl$Data$declaredNonStaticMembers$2().setStyle(KClassImpl$Data$declaredNonStaticMembers$2(new Notification.DecoratedMediaCustomViewStyle()));
            } else {
                super.BuiltInFictitiousFunctionClassFactory(notificationBuilderWithBuilderAccessor);
            }
        }

        @Override // androidx.media.app.NotificationCompat.MediaStyle, androidx.core.app.NotificationCompat.Style
        public RemoteViews PlaceComponentResult(NotificationBuilderWithBuilderAccessor notificationBuilderWithBuilderAccessor) {
            if (Build.VERSION.SDK_INT >= 24) {
                return null;
            }
            boolean z = this.BuiltInFictitiousFunctionClassFactory.MyBillsEntityDataFactory() != null;
            if (Build.VERSION.SDK_INT >= 21) {
                if (z || this.BuiltInFictitiousFunctionClassFactory.getAuthRequestContext() != null) {
                    RemoteViews authRequestContext = getAuthRequestContext();
                    if (z) {
                        MyBillsEntityDataFactory(authRequestContext, this.BuiltInFictitiousFunctionClassFactory.MyBillsEntityDataFactory());
                    }
                    MyBillsEntityDataFactory(authRequestContext);
                    return authRequestContext;
                }
            } else {
                RemoteViews authRequestContext2 = getAuthRequestContext();
                if (z) {
                    MyBillsEntityDataFactory(authRequestContext2, this.BuiltInFictitiousFunctionClassFactory.MyBillsEntityDataFactory());
                    return authRequestContext2;
                }
            }
            return null;
        }

        @Override // androidx.media.app.NotificationCompat.MediaStyle
        int MyBillsEntityDataFactory() {
            return this.BuiltInFictitiousFunctionClassFactory.MyBillsEntityDataFactory() != null ? R.layout.getErrorConfigVersion : super.MyBillsEntityDataFactory();
        }

        @Override // androidx.media.app.NotificationCompat.MediaStyle, androidx.core.app.NotificationCompat.Style
        public RemoteViews getAuthRequestContext(NotificationBuilderWithBuilderAccessor notificationBuilderWithBuilderAccessor) {
            RemoteViews MyBillsEntityDataFactory;
            if (Build.VERSION.SDK_INT >= 24) {
                return null;
            }
            if (this.BuiltInFictitiousFunctionClassFactory.getAuthRequestContext() != null) {
                MyBillsEntityDataFactory = this.BuiltInFictitiousFunctionClassFactory.getAuthRequestContext();
            } else {
                MyBillsEntityDataFactory = this.BuiltInFictitiousFunctionClassFactory.MyBillsEntityDataFactory();
            }
            if (MyBillsEntityDataFactory == null) {
                return null;
            }
            RemoteViews KClassImpl$Data$declaredNonStaticMembers$2 = KClassImpl$Data$declaredNonStaticMembers$2();
            MyBillsEntityDataFactory(KClassImpl$Data$declaredNonStaticMembers$2, MyBillsEntityDataFactory);
            if (Build.VERSION.SDK_INT >= 21) {
                MyBillsEntityDataFactory(KClassImpl$Data$declaredNonStaticMembers$2);
            }
            return KClassImpl$Data$declaredNonStaticMembers$2;
        }

        @Override // androidx.media.app.NotificationCompat.MediaStyle
        int MyBillsEntityDataFactory(int i) {
            return i <= 3 ? R.layout.MyBillsEntityDataFactory : R.layout.BuiltInFictitiousFunctionClassFactory;
        }

        @Override // androidx.core.app.NotificationCompat.Style
        public RemoteViews MyBillsEntityDataFactory(NotificationBuilderWithBuilderAccessor notificationBuilderWithBuilderAccessor) {
            RemoteViews MyBillsEntityDataFactory;
            if (Build.VERSION.SDK_INT >= 24) {
                return null;
            }
            if (this.BuiltInFictitiousFunctionClassFactory.NetworkUserEntityData$$ExternalSyntheticLambda0() != null) {
                MyBillsEntityDataFactory = this.BuiltInFictitiousFunctionClassFactory.NetworkUserEntityData$$ExternalSyntheticLambda0();
            } else {
                MyBillsEntityDataFactory = this.BuiltInFictitiousFunctionClassFactory.MyBillsEntityDataFactory();
            }
            if (MyBillsEntityDataFactory == null) {
                return null;
            }
            RemoteViews KClassImpl$Data$declaredNonStaticMembers$2 = KClassImpl$Data$declaredNonStaticMembers$2();
            MyBillsEntityDataFactory(KClassImpl$Data$declaredNonStaticMembers$2, MyBillsEntityDataFactory);
            if (Build.VERSION.SDK_INT >= 21) {
                MyBillsEntityDataFactory(KClassImpl$Data$declaredNonStaticMembers$2);
            }
            return KClassImpl$Data$declaredNonStaticMembers$2;
        }

        private void MyBillsEntityDataFactory(RemoteViews remoteViews) {
            int color;
            if (this.BuiltInFictitiousFunctionClassFactory.PlaceComponentResult() != 0) {
                color = this.BuiltInFictitiousFunctionClassFactory.PlaceComponentResult();
            } else {
                color = this.BuiltInFictitiousFunctionClassFactory.newProxyInstance.getResources().getColor(R.color.getAuthRequestContext);
            }
            remoteViews.setInt(R.id.MyBillsEntityDataFactory, "setBackgroundColor", color);
        }
    }
}
