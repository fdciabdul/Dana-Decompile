package androidx.core.app;

import android.app.Notification;
import android.app.PendingIntent;
import android.app.Person;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Icon;
import android.media.AudioAttributes;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.TextAppearanceSpan;
import android.widget.RemoteViews;
import androidx.core.R;
import androidx.core.content.LocusIdCompat;
import androidx.core.graphics.drawable.IconCompat;
import com.alibaba.ariver.resource.parser.tar.TarHeader;
import com.fullstory.instrumentation.InstrumentInjector;
import com.google.common.base.Ascii;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes3.dex */
public class NotificationCompat {

    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes3.dex */
    public @interface BadgeIconType {
    }

    /* loaded from: classes6.dex */
    public static final class CarExtender implements Extender {
        private int MyBillsEntityDataFactory = 0;

        @Deprecated
        /* loaded from: classes6.dex */
        public static class UnreadConversation {

            /* loaded from: classes6.dex */
            public static class Builder {
            }
        }
    }

    /* loaded from: classes6.dex */
    public interface Extender {
    }

    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes3.dex */
    public @interface GroupAlertBehavior {
    }

    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes3.dex */
    public @interface NotificationVisibility {
    }

    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes3.dex */
    public @interface ServiceNotificationBehavior {
    }

    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes3.dex */
    public @interface StreamType {
    }

    /* loaded from: classes.dex */
    public static class Builder {
        int A;
        boolean AppCompatEmojiTextHelper;
        int B;
        @Deprecated
        public ArrayList<String> BottomSheetCardBindingView$watcherCardNumberView$1;
        int BuiltInFictitiousFunctionClassFactory;
        boolean C;
        Notification D;
        boolean DatabaseTableConfigUtil;
        String E;
        Icon F;
        RemoteViews FragmentBottomSheetPaymentSettingBinding;
        String G;
        CharSequence GetContactSyncConfig;
        boolean H;
        Style I;
        long J;
        int K;
        boolean KClassImpl$Data$declaredNonStaticMembers$2;
        CharSequence L;
        RemoteViews M;
        RemoteViews MyBillsEntityDataFactory;
        String NetworkUserEntityData$$ExternalSyntheticLambda0;
        CharSequence NetworkUserEntityData$$ExternalSyntheticLambda1;
        PendingIntent NetworkUserEntityData$$ExternalSyntheticLambda2;
        int NetworkUserEntityData$$ExternalSyntheticLambda3;
        ArrayList<Action> NetworkUserEntityData$$ExternalSyntheticLambda4;
        boolean NetworkUserEntityData$$ExternalSyntheticLambda5;
        String NetworkUserEntityData$$ExternalSyntheticLambda6;
        int NetworkUserEntityData$$ExternalSyntheticLambda7;
        RemoteViews NetworkUserEntityData$$ExternalSyntheticLambda8;
        BubbleMetadata PlaceComponentResult;
        PendingIntent PrepareContext;
        Notification SubSequence;
        public ArrayList<Person> VerifyPinStateManager$executeRiskChallenge$2$1;
        int VerifyPinStateManager$executeRiskChallenge$2$2;
        public ArrayList<Action> getAuthRequestContext;
        Bitmap getCallingPid;
        boolean getErrorConfigVersion;
        boolean getNameOrBuilderList;
        CharSequence getOnBoardingScenario;
        int getSupportButtonTintMode;
        CharSequence[] getValueOfTouchPositionAbsolute;
        CharSequence initRecordTimeStamp;
        Bundle isLayoutRequested;
        int lookAheadTest;
        String moveToNextValue;
        public Context newProxyInstance;
        LocusIdCompat readMicros;
        boolean scheduleImpl;
        boolean whenAvailable;

        public Builder(Context context, String str) {
            this.getAuthRequestContext = new ArrayList<>();
            this.VerifyPinStateManager$executeRiskChallenge$2$1 = new ArrayList<>();
            this.NetworkUserEntityData$$ExternalSyntheticLambda4 = new ArrayList<>();
            this.AppCompatEmojiTextHelper = true;
            this.whenAvailable = false;
            this.lookAheadTest = 0;
            this.K = 0;
            this.BuiltInFictitiousFunctionClassFactory = 0;
            this.NetworkUserEntityData$$ExternalSyntheticLambda3 = 0;
            this.NetworkUserEntityData$$ExternalSyntheticLambda7 = 0;
            Notification notification = new Notification();
            this.SubSequence = notification;
            this.newProxyInstance = context;
            this.NetworkUserEntityData$$ExternalSyntheticLambda0 = str;
            notification.when = System.currentTimeMillis();
            this.SubSequence.audioStreamType = -1;
            this.A = 0;
            this.BottomSheetCardBindingView$watcherCardNumberView$1 = new ArrayList<>();
            this.KClassImpl$Data$declaredNonStaticMembers$2 = true;
        }

        @Deprecated
        public Builder(Context context) {
            this(context, null);
        }

        public Builder KClassImpl$Data$declaredNonStaticMembers$2(long j) {
            this.SubSequence.when = j;
            return this;
        }

        public Builder MyBillsEntityDataFactory(boolean z) {
            this.AppCompatEmojiTextHelper = z;
            return this;
        }

        public Builder getAuthRequestContext(int i) {
            this.SubSequence.icon = i;
            return this;
        }

        public Builder getAuthRequestContext(CharSequence charSequence) {
            this.NetworkUserEntityData$$ExternalSyntheticLambda1 = PlaceComponentResult(charSequence);
            return this;
        }

        public Builder MyBillsEntityDataFactory(CharSequence charSequence) {
            this.initRecordTimeStamp = PlaceComponentResult(charSequence);
            return this;
        }

        public Builder MyBillsEntityDataFactory(int i) {
            this.getSupportButtonTintMode = i;
            return this;
        }

        public Builder KClassImpl$Data$declaredNonStaticMembers$2(PendingIntent pendingIntent) {
            this.NetworkUserEntityData$$ExternalSyntheticLambda2 = pendingIntent;
            return this;
        }

        public Builder getAuthRequestContext(PendingIntent pendingIntent) {
            this.SubSequence.deleteIntent = pendingIntent;
            return this;
        }

        public Builder KClassImpl$Data$declaredNonStaticMembers$2(CharSequence charSequence) {
            this.SubSequence.tickerText = PlaceComponentResult(charSequence);
            return this;
        }

        public Builder BuiltInFictitiousFunctionClassFactory(Bitmap bitmap) {
            this.getCallingPid = getAuthRequestContext(bitmap);
            return this;
        }

        private Bitmap getAuthRequestContext(Bitmap bitmap) {
            if (bitmap == null || Build.VERSION.SDK_INT >= 27) {
                return bitmap;
            }
            Resources resources = this.newProxyInstance.getResources();
            int dimensionPixelSize = resources.getDimensionPixelSize(R.dimen.BuiltInFictitiousFunctionClassFactory);
            int dimensionPixelSize2 = resources.getDimensionPixelSize(R.dimen.PlaceComponentResult);
            if (bitmap.getWidth() > dimensionPixelSize || bitmap.getHeight() > dimensionPixelSize2) {
                double d = dimensionPixelSize;
                double max = Math.max(1, bitmap.getWidth());
                Double.isNaN(d);
                Double.isNaN(max);
                double d2 = d / max;
                double d3 = dimensionPixelSize2;
                double max2 = Math.max(1, bitmap.getHeight());
                Double.isNaN(d3);
                Double.isNaN(max2);
                double min = Math.min(d2, d3 / max2);
                double width = bitmap.getWidth();
                Double.isNaN(width);
                int ceil = (int) Math.ceil(width * min);
                double height = bitmap.getHeight();
                Double.isNaN(height);
                return Bitmap.createScaledBitmap(bitmap, ceil, (int) Math.ceil(height * min), true);
            }
            return bitmap;
        }

        public Builder KClassImpl$Data$declaredNonStaticMembers$2(Uri uri) {
            this.SubSequence.sound = uri;
            this.SubSequence.audioStreamType = -1;
            if (Build.VERSION.SDK_INT >= 21) {
                this.SubSequence.audioAttributes = new AudioAttributes.Builder().setContentType(4).setUsage(5).build();
            }
            return this;
        }

        public Builder getAuthRequestContext(long[] jArr) {
            this.SubSequence.vibrate = jArr;
            return this;
        }

        public Builder BuiltInFictitiousFunctionClassFactory(int i, int i2, int i3) {
            this.SubSequence.ledARGB = i;
            this.SubSequence.ledOnMS = i2;
            this.SubSequence.ledOffMS = i3;
            int i4 = (this.SubSequence.ledOnMS == 0 || this.SubSequence.ledOffMS == 0) ? 0 : 1;
            Notification notification = this.SubSequence;
            notification.flags = i4 | (notification.flags & (-2));
            return this;
        }

        public Builder KClassImpl$Data$declaredNonStaticMembers$2(boolean z) {
            MyBillsEntityDataFactory(2, z);
            return this;
        }

        public Builder BuiltInFictitiousFunctionClassFactory(boolean z) {
            MyBillsEntityDataFactory(16, z);
            return this;
        }

        public Builder PlaceComponentResult(boolean z) {
            this.whenAvailable = z;
            return this;
        }

        public Builder BuiltInFictitiousFunctionClassFactory(int i) {
            this.SubSequence.defaults = i;
            if ((i & 4) != 0) {
                this.SubSequence.flags |= 1;
            }
            return this;
        }

        private void MyBillsEntityDataFactory(int i, boolean z) {
            if (z) {
                Notification notification = this.SubSequence;
                notification.flags = i | notification.flags;
                return;
            }
            Notification notification2 = this.SubSequence;
            notification2.flags = (i ^ (-1)) & notification2.flags;
        }

        public Builder KClassImpl$Data$declaredNonStaticMembers$2(int i) {
            this.A = i;
            return this;
        }

        public Bundle KClassImpl$Data$declaredNonStaticMembers$2() {
            if (this.isLayoutRequested == null) {
                this.isLayoutRequested = new Bundle();
            }
            return this.isLayoutRequested;
        }

        public Builder MyBillsEntityDataFactory(int i, CharSequence charSequence, PendingIntent pendingIntent) {
            this.getAuthRequestContext.add(new Action(i, charSequence, pendingIntent));
            return this;
        }

        public Builder PlaceComponentResult(Action action) {
            if (action != null) {
                this.getAuthRequestContext.add(action);
            }
            return this;
        }

        public Builder getAuthRequestContext(Style style) {
            if (this.I != style) {
                this.I = style;
                if (style != null) {
                    style.BuiltInFictitiousFunctionClassFactory(this);
                }
            }
            return this;
        }

        public Builder PlaceComponentResult(int i) {
            this.lookAheadTest = i;
            return this;
        }

        public Builder scheduleImpl(int i) {
            this.K = i;
            return this;
        }

        public Builder BuiltInFictitiousFunctionClassFactory(String str) {
            this.NetworkUserEntityData$$ExternalSyntheticLambda0 = str;
            return this;
        }

        public Notification BuiltInFictitiousFunctionClassFactory() {
            return new NotificationCompatBuilder(this).BuiltInFictitiousFunctionClassFactory();
        }

        protected static CharSequence PlaceComponentResult(CharSequence charSequence) {
            return (charSequence != null && charSequence.length() > 5120) ? charSequence.subSequence(0, 5120) : charSequence;
        }

        public RemoteViews MyBillsEntityDataFactory() {
            return this.NetworkUserEntityData$$ExternalSyntheticLambda8;
        }

        public RemoteViews getAuthRequestContext() {
            return this.MyBillsEntityDataFactory;
        }

        public RemoteViews NetworkUserEntityData$$ExternalSyntheticLambda0() {
            return this.FragmentBottomSheetPaymentSettingBinding;
        }

        public long lookAheadTest() {
            if (this.AppCompatEmojiTextHelper) {
                return this.SubSequence.when;
            }
            return 0L;
        }

        public int scheduleImpl() {
            return this.A;
        }

        public int PlaceComponentResult() {
            return this.lookAheadTest;
        }
    }

    /* loaded from: classes.dex */
    public static abstract class Style {
        protected Builder BuiltInFictitiousFunctionClassFactory;
        CharSequence KClassImpl$Data$declaredNonStaticMembers$2;
        CharSequence MyBillsEntityDataFactory;
        boolean NetworkUserEntityData$$ExternalSyntheticLambda0 = false;

        private static float KClassImpl$Data$declaredNonStaticMembers$2(float f, float f2, float f3) {
            return f >= f2 ? f > f3 ? f3 : f : f2;
        }

        public void BuiltInFictitiousFunctionClassFactory(NotificationBuilderWithBuilderAccessor notificationBuilderWithBuilderAccessor) {
        }

        public RemoteViews MyBillsEntityDataFactory(NotificationBuilderWithBuilderAccessor notificationBuilderWithBuilderAccessor) {
            return null;
        }

        public RemoteViews PlaceComponentResult(NotificationBuilderWithBuilderAccessor notificationBuilderWithBuilderAccessor) {
            return null;
        }

        protected String PlaceComponentResult() {
            return null;
        }

        public RemoteViews getAuthRequestContext(NotificationBuilderWithBuilderAccessor notificationBuilderWithBuilderAccessor) {
            return null;
        }

        public void BuiltInFictitiousFunctionClassFactory(Builder builder) {
            if (this.BuiltInFictitiousFunctionClassFactory != builder) {
                this.BuiltInFictitiousFunctionClassFactory = builder;
                if (builder != null) {
                    builder.getAuthRequestContext(this);
                }
            }
        }

        public void MyBillsEntityDataFactory(Bundle bundle) {
            if (this.NetworkUserEntityData$$ExternalSyntheticLambda0) {
                bundle.putCharSequence("android.summaryText", this.KClassImpl$Data$declaredNonStaticMembers$2);
            }
            CharSequence charSequence = this.MyBillsEntityDataFactory;
            if (charSequence != null) {
                bundle.putCharSequence("android.title.big", charSequence);
            }
            String PlaceComponentResult = PlaceComponentResult();
            if (PlaceComponentResult != null) {
                bundle.putString("androidx.core.app.extra.COMPAT_TEMPLATE", PlaceComponentResult);
            }
        }

        /* JADX WARN: Removed duplicated region for block: B:66:0x019d  */
        /* JADX WARN: Removed duplicated region for block: B:67:0x01ad  */
        /* JADX WARN: Removed duplicated region for block: B:70:0x01b5  */
        /* JADX WARN: Removed duplicated region for block: B:73:0x01bb  */
        /* JADX WARN: Removed duplicated region for block: B:77:0x01dd  */
        /* JADX WARN: Removed duplicated region for block: B:87:0x0233  */
        /* JADX WARN: Removed duplicated region for block: B:90:0x0238  */
        /* JADX WARN: Removed duplicated region for block: B:91:0x023a  */
        /* JADX WARN: Removed duplicated region for block: B:95:0x0244  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public android.widget.RemoteViews getAuthRequestContext(boolean r13, int r14, boolean r15) {
            /*
                Method dump skipped, instructions count: 586
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.core.app.NotificationCompat.Style.getAuthRequestContext(boolean, int, boolean):android.widget.RemoteViews");
        }

        public Bitmap PlaceComponentResult(int i, int i2) {
            return PlaceComponentResult(i, i2, 0);
        }

        Bitmap BuiltInFictitiousFunctionClassFactory(IconCompat iconCompat, int i) {
            return PlaceComponentResult(iconCompat, i, 0);
        }

        private Bitmap PlaceComponentResult(int i, int i2, int i3) {
            return PlaceComponentResult(IconCompat.KClassImpl$Data$declaredNonStaticMembers$2(this.BuiltInFictitiousFunctionClassFactory.newProxyInstance, i), i2, i3);
        }

        private Bitmap PlaceComponentResult(IconCompat iconCompat, int i, int i2) {
            Drawable authRequestContext = iconCompat.getAuthRequestContext(this.BuiltInFictitiousFunctionClassFactory.newProxyInstance);
            int intrinsicWidth = i2 == 0 ? authRequestContext.getIntrinsicWidth() : i2;
            if (i2 == 0) {
                i2 = authRequestContext.getIntrinsicHeight();
            }
            Bitmap createBitmap = Bitmap.createBitmap(intrinsicWidth, i2, Bitmap.Config.ARGB_8888);
            authRequestContext.setBounds(0, 0, intrinsicWidth, i2);
            if (i != 0) {
                authRequestContext.mutate().setColorFilter(new PorterDuffColorFilter(i, PorterDuff.Mode.SRC_IN));
            }
            authRequestContext.draw(new Canvas(createBitmap));
            return createBitmap;
        }

        private Bitmap MyBillsEntityDataFactory(int i, int i2, int i3, int i4) {
            int i5 = R.drawable.PlaceComponentResult;
            if (i4 == 0) {
                i4 = 0;
            }
            Bitmap PlaceComponentResult = PlaceComponentResult(i5, i4, i2);
            Canvas canvas = new Canvas(PlaceComponentResult);
            Drawable mutate = InstrumentInjector.Resources_getDrawable(this.BuiltInFictitiousFunctionClassFactory.newProxyInstance.getResources(), i).mutate();
            mutate.setFilterBitmap(true);
            int i6 = (i2 - i3) / 2;
            int i7 = i3 + i6;
            mutate.setBounds(i6, i6, i7, i7);
            mutate.setColorFilter(new PorterDuffColorFilter(-1, PorterDuff.Mode.SRC_ATOP));
            mutate.draw(canvas);
            return PlaceComponentResult;
        }

        public void MyBillsEntityDataFactory(RemoteViews remoteViews, RemoteViews remoteViews2) {
            PlaceComponentResult(remoteViews);
            remoteViews.removeAllViews(R.id.F);
            remoteViews.addView(R.id.F, remoteViews2.clone());
            remoteViews.setViewVisibility(R.id.F, 0);
            if (Build.VERSION.SDK_INT >= 21) {
                remoteViews.setViewPadding(R.id.M, 0, BuiltInFictitiousFunctionClassFactory(), 0, 0);
            }
        }

        private void PlaceComponentResult(RemoteViews remoteViews) {
            remoteViews.setViewVisibility(R.id.T, 8);
            remoteViews.setViewVisibility(R.id.X, 8);
            remoteViews.setViewVisibility(R.id.W, 8);
        }

        private int BuiltInFictitiousFunctionClassFactory() {
            Resources resources = this.BuiltInFictitiousFunctionClassFactory.newProxyInstance.getResources();
            int dimensionPixelSize = resources.getDimensionPixelSize(R.dimen.moveToNextValue);
            int dimensionPixelSize2 = resources.getDimensionPixelSize(R.dimen.getErrorConfigVersion);
            float KClassImpl$Data$declaredNonStaticMembers$2 = (KClassImpl$Data$declaredNonStaticMembers$2(resources.getConfiguration().fontScale, 1.0f, 1.3f) - 1.0f) / 0.29999995f;
            return Math.round(((1.0f - KClassImpl$Data$declaredNonStaticMembers$2) * dimensionPixelSize) + (KClassImpl$Data$declaredNonStaticMembers$2 * dimensionPixelSize2));
        }
    }

    /* loaded from: classes3.dex */
    public static class BigPictureStyle extends Style {
        private IconCompat PlaceComponentResult;
        private boolean getAuthRequestContext;
        private IconCompat lookAheadTest;
        private boolean moveToNextValue;
        private CharSequence scheduleImpl;

        @Override // androidx.core.app.NotificationCompat.Style
        protected String PlaceComponentResult() {
            return "androidx.core.app.NotificationCompat$BigPictureStyle";
        }

        public BigPictureStyle KClassImpl$Data$declaredNonStaticMembers$2(CharSequence charSequence) {
            this.MyBillsEntityDataFactory = Builder.PlaceComponentResult(charSequence);
            return this;
        }

        public BigPictureStyle MyBillsEntityDataFactory(CharSequence charSequence) {
            this.KClassImpl$Data$declaredNonStaticMembers$2 = Builder.PlaceComponentResult(charSequence);
            this.NetworkUserEntityData$$ExternalSyntheticLambda0 = true;
            return this;
        }

        public BigPictureStyle PlaceComponentResult(Bitmap bitmap) {
            this.lookAheadTest = bitmap == null ? null : IconCompat.KClassImpl$Data$declaredNonStaticMembers$2(bitmap);
            return this;
        }

        public BigPictureStyle BuiltInFictitiousFunctionClassFactory(Bitmap bitmap) {
            this.PlaceComponentResult = bitmap == null ? null : IconCompat.KClassImpl$Data$declaredNonStaticMembers$2(bitmap);
            this.getAuthRequestContext = true;
            return this;
        }

        @Override // androidx.core.app.NotificationCompat.Style
        public void BuiltInFictitiousFunctionClassFactory(NotificationBuilderWithBuilderAccessor notificationBuilderWithBuilderAccessor) {
            if (Build.VERSION.SDK_INT >= 16) {
                Notification.BigPictureStyle bigContentTitle = new Notification.BigPictureStyle(notificationBuilderWithBuilderAccessor.KClassImpl$Data$declaredNonStaticMembers$2()).setBigContentTitle(this.MyBillsEntityDataFactory);
                if (this.lookAheadTest != null) {
                    if (Build.VERSION.SDK_INT >= 31) {
                        Api31Impl.getAuthRequestContext(bigContentTitle, this.lookAheadTest.PlaceComponentResult(notificationBuilderWithBuilderAccessor instanceof NotificationCompatBuilder ? ((NotificationCompatBuilder) notificationBuilderWithBuilderAccessor).PlaceComponentResult() : null));
                    } else if (this.lookAheadTest.KClassImpl$Data$declaredNonStaticMembers$2() == 1) {
                        bigContentTitle = bigContentTitle.bigPicture(this.lookAheadTest.BuiltInFictitiousFunctionClassFactory());
                    }
                }
                if (this.getAuthRequestContext) {
                    if (this.PlaceComponentResult != null) {
                        if (Build.VERSION.SDK_INT >= 23) {
                            Api23Impl.getAuthRequestContext(bigContentTitle, this.PlaceComponentResult.PlaceComponentResult(notificationBuilderWithBuilderAccessor instanceof NotificationCompatBuilder ? ((NotificationCompatBuilder) notificationBuilderWithBuilderAccessor).PlaceComponentResult() : null));
                        } else if (this.PlaceComponentResult.KClassImpl$Data$declaredNonStaticMembers$2() == 1) {
                            Api16Impl.getAuthRequestContext(bigContentTitle, this.PlaceComponentResult.BuiltInFictitiousFunctionClassFactory());
                        }
                    }
                    Api16Impl.getAuthRequestContext(bigContentTitle, null);
                }
                if (this.NetworkUserEntityData$$ExternalSyntheticLambda0) {
                    Api16Impl.BuiltInFictitiousFunctionClassFactory(bigContentTitle, this.KClassImpl$Data$declaredNonStaticMembers$2);
                }
                if (Build.VERSION.SDK_INT >= 31) {
                    Api31Impl.PlaceComponentResult(bigContentTitle, this.moveToNextValue);
                    Api31Impl.getAuthRequestContext(bigContentTitle, this.scheduleImpl);
                }
            }
        }

        /* loaded from: classes3.dex */
        static class Api16Impl {
            private Api16Impl() {
            }

            static void getAuthRequestContext(Notification.BigPictureStyle bigPictureStyle, Bitmap bitmap) {
                bigPictureStyle.bigLargeIcon(bitmap);
            }

            static void BuiltInFictitiousFunctionClassFactory(Notification.BigPictureStyle bigPictureStyle, CharSequence charSequence) {
                bigPictureStyle.setSummaryText(charSequence);
            }
        }

        /* loaded from: classes3.dex */
        static class Api23Impl {
            private Api23Impl() {
            }

            static void getAuthRequestContext(Notification.BigPictureStyle bigPictureStyle, Icon icon) {
                bigPictureStyle.bigLargeIcon(icon);
            }
        }

        /* loaded from: classes3.dex */
        static class Api31Impl {
            private Api31Impl() {
            }

            static void PlaceComponentResult(Notification.BigPictureStyle bigPictureStyle, boolean z) {
                bigPictureStyle.showBigPictureWhenCollapsed(z);
            }

            static void getAuthRequestContext(Notification.BigPictureStyle bigPictureStyle, CharSequence charSequence) {
                bigPictureStyle.setContentDescription(charSequence);
            }

            static void getAuthRequestContext(Notification.BigPictureStyle bigPictureStyle, Icon icon) {
                bigPictureStyle.bigPicture(icon);
            }
        }
    }

    /* loaded from: classes.dex */
    public static class BigTextStyle extends Style {
        private CharSequence getAuthRequestContext;

        @Override // androidx.core.app.NotificationCompat.Style
        protected String PlaceComponentResult() {
            return "androidx.core.app.NotificationCompat$BigTextStyle";
        }

        public BigTextStyle KClassImpl$Data$declaredNonStaticMembers$2(CharSequence charSequence) {
            this.MyBillsEntityDataFactory = Builder.PlaceComponentResult(charSequence);
            return this;
        }

        public BigTextStyle getAuthRequestContext(CharSequence charSequence) {
            this.getAuthRequestContext = Builder.PlaceComponentResult(charSequence);
            return this;
        }

        @Override // androidx.core.app.NotificationCompat.Style
        public void BuiltInFictitiousFunctionClassFactory(NotificationBuilderWithBuilderAccessor notificationBuilderWithBuilderAccessor) {
            if (Build.VERSION.SDK_INT >= 16) {
                Notification.BigTextStyle bigText = new Notification.BigTextStyle(notificationBuilderWithBuilderAccessor.KClassImpl$Data$declaredNonStaticMembers$2()).setBigContentTitle(this.MyBillsEntityDataFactory).bigText(this.getAuthRequestContext);
                if (this.NetworkUserEntityData$$ExternalSyntheticLambda0) {
                    bigText.setSummaryText(this.KClassImpl$Data$declaredNonStaticMembers$2);
                }
            }
        }

        @Override // androidx.core.app.NotificationCompat.Style
        public void MyBillsEntityDataFactory(Bundle bundle) {
            super.MyBillsEntityDataFactory(bundle);
            if (Build.VERSION.SDK_INT < 21) {
                bundle.putCharSequence("android.bigText", this.getAuthRequestContext);
            }
        }
    }

    /* loaded from: classes6.dex */
    public static class MessagingStyle extends Style {
        private Person NetworkUserEntityData$$ExternalSyntheticLambda2;
        private Boolean getErrorConfigVersion;
        private CharSequence lookAheadTest;
        public static final byte[] getAuthRequestContext = {111, 16, 84, -34, Ascii.NAK, -2, 22, 5, 2, 3, -46, 61, Ascii.DC4, 7, 14, -7, 17, 14, -62, Ascii.GS, TarHeader.LF_BLK, 7, 14, -7, Ascii.ESC, 4, 6, Ascii.ETB, -43, TarHeader.LF_CONTIG, 8, 4, 5, 2, 6, Ascii.ESC, -3, 14, 7, -29, 45, 0, 17};
        public static final int PlaceComponentResult = 8;
        private final List<Message> scheduleImpl = new ArrayList();
        private final List<Message> moveToNextValue = new ArrayList();

        /* JADX WARN: Removed duplicated region for block: B:10:0x002d  */
        /* JADX WARN: Removed duplicated region for block: B:8:0x0025  */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x002d -> B:11:0x0037). Please submit an issue!!! */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        private static void a(byte r6, byte r7, short r8, java.lang.Object[] r9) {
            /*
                int r6 = r6 * 22
                int r6 = r6 + 4
                int r7 = r7 * 6
                int r7 = 103 - r7
                int r8 = r8 * 5
                int r8 = r8 + 18
                byte[] r0 = androidx.core.app.NotificationCompat.MessagingStyle.getAuthRequestContext
                byte[] r1 = new byte[r8]
                int r8 = r8 + (-1)
                r2 = 0
                if (r0 != 0) goto L1d
                r3 = r1
                r4 = 0
                r1 = r0
                r0 = r9
                r9 = r8
                r8 = r7
                r7 = r6
                goto L37
            L1d:
                r3 = 0
            L1e:
                byte r4 = (byte) r7
                r1[r3] = r4
                int r4 = r3 + 1
                if (r3 != r8) goto L2d
                java.lang.String r6 = new java.lang.String
                r6.<init>(r1, r2)
                r9[r2] = r6
                return
            L2d:
                r3 = r0[r6]
                r5 = r7
                r7 = r6
                r6 = r3
                r3 = r1
                r1 = r0
                r0 = r9
                r9 = r8
                r8 = r5
            L37:
                int r8 = r8 + r6
                int r6 = r8 + (-8)
                int r7 = r7 + 1
                r8 = r9
                r9 = r0
                r0 = r1
                r1 = r3
                r3 = r4
                r5 = r7
                r7 = r6
                r6 = r5
                goto L1e
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.core.app.NotificationCompat.MessagingStyle.a(byte, byte, short, java.lang.Object[]):void");
        }

        @Override // androidx.core.app.NotificationCompat.Style
        protected String PlaceComponentResult() {
            return "androidx.core.app.NotificationCompat$MessagingStyle";
        }

        MessagingStyle() {
        }

        public MessagingStyle KClassImpl$Data$declaredNonStaticMembers$2(boolean z) {
            this.getErrorConfigVersion = Boolean.valueOf(z);
            return this;
        }

        public boolean KClassImpl$Data$declaredNonStaticMembers$2() {
            if (this.BuiltInFictitiousFunctionClassFactory != null) {
                Context context = this.BuiltInFictitiousFunctionClassFactory.newProxyInstance;
                try {
                    byte b = getAuthRequestContext[41];
                    byte b2 = (byte) (b + 1);
                    Object[] objArr = new Object[1];
                    a(b, b2, b2, objArr);
                    Class<?> cls = Class.forName((String) objArr[0]);
                    byte b3 = (byte) (getAuthRequestContext[8] - 1);
                    byte b4 = getAuthRequestContext[41];
                    Object[] objArr2 = new Object[1];
                    a(b3, b4, b4, objArr2);
                    if (((ApplicationInfo) cls.getMethod((String) objArr2[0], null).invoke(context, null)).targetSdkVersion < 28 && this.getErrorConfigVersion == null) {
                        return this.lookAheadTest != null;
                    }
                } catch (Throwable th) {
                    Throwable cause = th.getCause();
                    if (cause != null) {
                        throw cause;
                    }
                    throw th;
                }
            }
            Boolean bool = this.getErrorConfigVersion;
            if (bool != null) {
                return bool.booleanValue();
            }
            return false;
        }

        @Override // androidx.core.app.NotificationCompat.Style
        public void BuiltInFictitiousFunctionClassFactory(NotificationBuilderWithBuilderAccessor notificationBuilderWithBuilderAccessor) {
            CharSequence MyBillsEntityDataFactory;
            Notification.MessagingStyle messagingStyle;
            android.app.Person build;
            KClassImpl$Data$declaredNonStaticMembers$2(KClassImpl$Data$declaredNonStaticMembers$2());
            if (Build.VERSION.SDK_INT >= 24) {
                if (Build.VERSION.SDK_INT >= 28) {
                    build = new Person.Builder().setName(r2.BuiltInFictitiousFunctionClassFactory).setIcon(r2.PlaceComponentResult != null ? r2.PlaceComponentResult.moveToNextValue() : null).setUri(r2.scheduleImpl).setKey(r2.MyBillsEntityDataFactory).setBot(r2.getAuthRequestContext()).setImportant(this.NetworkUserEntityData$$ExternalSyntheticLambda2.MyBillsEntityDataFactory()).build();
                    messagingStyle = new Notification.MessagingStyle(build);
                } else {
                    messagingStyle = new Notification.MessagingStyle(this.NetworkUserEntityData$$ExternalSyntheticLambda2.BuiltInFictitiousFunctionClassFactory);
                }
                Iterator<Message> it = this.scheduleImpl.iterator();
                while (it.hasNext()) {
                    messagingStyle.addMessage(it.next().moveToNextValue());
                }
                if (Build.VERSION.SDK_INT >= 26) {
                    Iterator<Message> it2 = this.moveToNextValue.iterator();
                    while (it2.hasNext()) {
                        messagingStyle.addHistoricMessage(it2.next().moveToNextValue());
                    }
                }
                if (this.getErrorConfigVersion.booleanValue() || Build.VERSION.SDK_INT >= 28) {
                    messagingStyle.setConversationTitle(this.lookAheadTest);
                }
                if (Build.VERSION.SDK_INT >= 28) {
                    messagingStyle.setGroupConversation(this.getErrorConfigVersion.booleanValue());
                }
                messagingStyle.setBuilder(notificationBuilderWithBuilderAccessor.KClassImpl$Data$declaredNonStaticMembers$2());
                return;
            }
            Message BuiltInFictitiousFunctionClassFactory = BuiltInFictitiousFunctionClassFactory();
            if (this.lookAheadTest != null && this.getErrorConfigVersion.booleanValue()) {
                notificationBuilderWithBuilderAccessor.KClassImpl$Data$declaredNonStaticMembers$2().setContentTitle(this.lookAheadTest);
            } else if (BuiltInFictitiousFunctionClassFactory != null) {
                notificationBuilderWithBuilderAccessor.KClassImpl$Data$declaredNonStaticMembers$2().setContentTitle("");
                if (BuiltInFictitiousFunctionClassFactory.BuiltInFictitiousFunctionClassFactory() != null) {
                    notificationBuilderWithBuilderAccessor.KClassImpl$Data$declaredNonStaticMembers$2().setContentTitle(BuiltInFictitiousFunctionClassFactory.BuiltInFictitiousFunctionClassFactory().BuiltInFictitiousFunctionClassFactory);
                }
            }
            if (BuiltInFictitiousFunctionClassFactory != null) {
                Notification.Builder KClassImpl$Data$declaredNonStaticMembers$2 = notificationBuilderWithBuilderAccessor.KClassImpl$Data$declaredNonStaticMembers$2();
                if (this.lookAheadTest != null) {
                    MyBillsEntityDataFactory = KClassImpl$Data$declaredNonStaticMembers$2(BuiltInFictitiousFunctionClassFactory);
                } else {
                    MyBillsEntityDataFactory = BuiltInFictitiousFunctionClassFactory.MyBillsEntityDataFactory();
                }
                KClassImpl$Data$declaredNonStaticMembers$2.setContentText(MyBillsEntityDataFactory);
            }
            if (Build.VERSION.SDK_INT >= 16) {
                SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
                boolean z = this.lookAheadTest != null || MyBillsEntityDataFactory();
                for (int size = this.scheduleImpl.size() - 1; size >= 0; size--) {
                    Message message = this.scheduleImpl.get(size);
                    CharSequence KClassImpl$Data$declaredNonStaticMembers$22 = z ? KClassImpl$Data$declaredNonStaticMembers$2(message) : message.MyBillsEntityDataFactory();
                    if (size != this.scheduleImpl.size() - 1) {
                        spannableStringBuilder.insert(0, (CharSequence) "\n");
                    }
                    spannableStringBuilder.insert(0, KClassImpl$Data$declaredNonStaticMembers$22);
                }
                new Notification.BigTextStyle(notificationBuilderWithBuilderAccessor.KClassImpl$Data$declaredNonStaticMembers$2()).setBigContentTitle(null).bigText(spannableStringBuilder);
            }
        }

        private Message BuiltInFictitiousFunctionClassFactory() {
            for (int size = this.scheduleImpl.size() - 1; size >= 0; size--) {
                Message message = this.scheduleImpl.get(size);
                if (message.BuiltInFictitiousFunctionClassFactory() != null && !TextUtils.isEmpty(message.BuiltInFictitiousFunctionClassFactory().BuiltInFictitiousFunctionClassFactory)) {
                    return message;
                }
            }
            if (this.scheduleImpl.isEmpty()) {
                return null;
            }
            return this.scheduleImpl.get(r0.size() - 1);
        }

        private boolean MyBillsEntityDataFactory() {
            for (int size = this.scheduleImpl.size() - 1; size >= 0; size--) {
                Message message = this.scheduleImpl.get(size);
                if (message.BuiltInFictitiousFunctionClassFactory() != null && message.BuiltInFictitiousFunctionClassFactory().BuiltInFictitiousFunctionClassFactory == null) {
                    return true;
                }
            }
            return false;
        }

        /* JADX WARN: Removed duplicated region for block: B:25:0x006c  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        private java.lang.CharSequence KClassImpl$Data$declaredNonStaticMembers$2(androidx.core.app.NotificationCompat.MessagingStyle.Message r9) {
            /*
                r8 = this;
                androidx.core.text.BidiFormatter r0 = androidx.core.text.BidiFormatter.MyBillsEntityDataFactory()
                android.text.SpannableStringBuilder r1 = new android.text.SpannableStringBuilder
                r1.<init>()
                int r2 = android.os.Build.VERSION.SDK_INT
                r3 = 21
                if (r2 < r3) goto L11
                r2 = 1
                goto L12
            L11:
                r2 = 0
            L12:
                r3 = -16777216(0xffffffffff000000, float:-1.7014118E38)
                if (r2 == 0) goto L19
                r4 = -16777216(0xffffffffff000000, float:-1.7014118E38)
                goto L1a
            L19:
                r4 = -1
            L1a:
                androidx.core.app.Person r5 = r9.BuiltInFictitiousFunctionClassFactory()
                java.lang.String r6 = ""
                if (r5 != 0) goto L24
                r5 = r6
                goto L2a
            L24:
                androidx.core.app.Person r5 = r9.BuiltInFictitiousFunctionClassFactory()
                java.lang.CharSequence r5 = r5.BuiltInFictitiousFunctionClassFactory
            L2a:
                boolean r7 = android.text.TextUtils.isEmpty(r5)
                if (r7 == 0) goto L45
                androidx.core.app.Person r5 = r8.NetworkUserEntityData$$ExternalSyntheticLambda2
                java.lang.CharSequence r5 = r5.BuiltInFictitiousFunctionClassFactory
                if (r2 == 0) goto L45
                androidx.core.app.NotificationCompat$Builder r2 = r8.BuiltInFictitiousFunctionClassFactory
                int r2 = r2.PlaceComponentResult()
                if (r2 == 0) goto L46
                androidx.core.app.NotificationCompat$Builder r2 = r8.BuiltInFictitiousFunctionClassFactory
                int r3 = r2.PlaceComponentResult()
                goto L46
            L45:
                r3 = r4
            L46:
                androidx.core.text.TextDirectionHeuristicCompat r2 = r0.MyBillsEntityDataFactory
                java.lang.CharSequence r2 = r0.MyBillsEntityDataFactory(r5, r2)
                r1.append(r2)
                android.text.style.TextAppearanceSpan r3 = r8.KClassImpl$Data$declaredNonStaticMembers$2(r3)
                int r4 = r1.length()
                int r2 = r2.length()
                int r5 = r1.length()
                int r4 = r4 - r2
                r2 = 33
                r1.setSpan(r3, r4, r5, r2)
                java.lang.CharSequence r2 = r9.MyBillsEntityDataFactory()
                if (r2 != 0) goto L6c
                goto L70
            L6c:
                java.lang.CharSequence r6 = r9.MyBillsEntityDataFactory()
            L70:
                java.lang.String r9 = "  "
                android.text.SpannableStringBuilder r9 = r1.append(r9)
                androidx.core.text.TextDirectionHeuristicCompat r2 = r0.MyBillsEntityDataFactory
                java.lang.CharSequence r0 = r0.MyBillsEntityDataFactory(r6, r2)
                r9.append(r0)
                return r1
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.core.app.NotificationCompat.MessagingStyle.KClassImpl$Data$declaredNonStaticMembers$2(androidx.core.app.NotificationCompat$MessagingStyle$Message):java.lang.CharSequence");
        }

        private TextAppearanceSpan KClassImpl$Data$declaredNonStaticMembers$2(int i) {
            return new TextAppearanceSpan(null, 0, 0, ColorStateList.valueOf(i), null);
        }

        @Override // androidx.core.app.NotificationCompat.Style
        public void MyBillsEntityDataFactory(Bundle bundle) {
            super.MyBillsEntityDataFactory(bundle);
            bundle.putCharSequence("android.selfDisplayName", this.NetworkUserEntityData$$ExternalSyntheticLambda2.BuiltInFictitiousFunctionClassFactory);
            bundle.putBundle("android.messagingStyleUser", this.NetworkUserEntityData$$ExternalSyntheticLambda2.PlaceComponentResult());
            bundle.putCharSequence("android.hiddenConversationTitle", this.lookAheadTest);
            if (this.lookAheadTest != null && this.getErrorConfigVersion.booleanValue()) {
                bundle.putCharSequence("android.conversationTitle", this.lookAheadTest);
            }
            if (!this.scheduleImpl.isEmpty()) {
                bundle.putParcelableArray("android.messages", Message.KClassImpl$Data$declaredNonStaticMembers$2(this.scheduleImpl));
            }
            if (!this.moveToNextValue.isEmpty()) {
                bundle.putParcelableArray("android.messages.historic", Message.KClassImpl$Data$declaredNonStaticMembers$2(this.moveToNextValue));
            }
            Boolean bool = this.getErrorConfigVersion;
            if (bool != null) {
                bundle.putBoolean("android.isGroupConversation", bool.booleanValue());
            }
        }

        /* loaded from: classes6.dex */
        public static final class Message {
            private Uri BuiltInFictitiousFunctionClassFactory;
            private final Person KClassImpl$Data$declaredNonStaticMembers$2;
            private String MyBillsEntityDataFactory;
            private final CharSequence PlaceComponentResult;
            private Bundle getAuthRequestContext;
            private final long lookAheadTest;

            public final CharSequence MyBillsEntityDataFactory() {
                return this.PlaceComponentResult;
            }

            public final long PlaceComponentResult() {
                return this.lookAheadTest;
            }

            public final Person BuiltInFictitiousFunctionClassFactory() {
                return this.KClassImpl$Data$declaredNonStaticMembers$2;
            }

            public final String KClassImpl$Data$declaredNonStaticMembers$2() {
                return this.MyBillsEntityDataFactory;
            }

            public final Uri getAuthRequestContext() {
                return this.BuiltInFictitiousFunctionClassFactory;
            }

            private Bundle getErrorConfigVersion() {
                android.app.Person build;
                Bundle bundle = new Bundle();
                CharSequence charSequence = this.PlaceComponentResult;
                if (charSequence != null) {
                    bundle.putCharSequence("text", charSequence);
                }
                bundle.putLong("time", this.lookAheadTest);
                Person person = this.KClassImpl$Data$declaredNonStaticMembers$2;
                if (person != null) {
                    bundle.putCharSequence("sender", person.BuiltInFictitiousFunctionClassFactory);
                    if (Build.VERSION.SDK_INT >= 28) {
                        build = new Person.Builder().setName(r1.BuiltInFictitiousFunctionClassFactory).setIcon(r2.PlaceComponentResult != null ? r1.PlaceComponentResult.moveToNextValue() : null).setUri(r1.scheduleImpl).setKey(r1.MyBillsEntityDataFactory).setBot(r1.getAuthRequestContext()).setImportant(this.KClassImpl$Data$declaredNonStaticMembers$2.MyBillsEntityDataFactory()).build();
                        bundle.putParcelable("sender_person", build);
                    } else {
                        bundle.putBundle("person", this.KClassImpl$Data$declaredNonStaticMembers$2.PlaceComponentResult());
                    }
                }
                String str = this.MyBillsEntityDataFactory;
                if (str != null) {
                    bundle.putString("type", str);
                }
                Uri uri = this.BuiltInFictitiousFunctionClassFactory;
                if (uri != null) {
                    bundle.putParcelable("uri", uri);
                }
                Bundle bundle2 = this.getAuthRequestContext;
                if (bundle2 != null) {
                    bundle.putBundle("extras", bundle2);
                }
                return bundle;
            }

            static Bundle[] KClassImpl$Data$declaredNonStaticMembers$2(List<Message> list) {
                Bundle[] bundleArr = new Bundle[list.size()];
                int size = list.size();
                for (int i = 0; i < size; i++) {
                    bundleArr[i] = list.get(i).getErrorConfigVersion();
                }
                return bundleArr;
            }

            final Notification.MessagingStyle.Message moveToNextValue() {
                Notification.MessagingStyle.Message message;
                Person BuiltInFictitiousFunctionClassFactory = BuiltInFictitiousFunctionClassFactory();
                android.app.Person person = null;
                if (Build.VERSION.SDK_INT >= 28) {
                    CharSequence MyBillsEntityDataFactory = MyBillsEntityDataFactory();
                    long PlaceComponentResult = PlaceComponentResult();
                    if (BuiltInFictitiousFunctionClassFactory != null) {
                        person = new Person.Builder().setName(BuiltInFictitiousFunctionClassFactory.BuiltInFictitiousFunctionClassFactory).setIcon(r2.PlaceComponentResult != null ? BuiltInFictitiousFunctionClassFactory.PlaceComponentResult.moveToNextValue() : null).setUri(BuiltInFictitiousFunctionClassFactory.scheduleImpl).setKey(BuiltInFictitiousFunctionClassFactory.MyBillsEntityDataFactory).setBot(BuiltInFictitiousFunctionClassFactory.getAuthRequestContext()).setImportant(BuiltInFictitiousFunctionClassFactory.MyBillsEntityDataFactory()).build();
                    }
                    message = new Notification.MessagingStyle.Message(MyBillsEntityDataFactory, PlaceComponentResult, person);
                } else {
                    message = new Notification.MessagingStyle.Message(MyBillsEntityDataFactory(), PlaceComponentResult(), BuiltInFictitiousFunctionClassFactory != null ? BuiltInFictitiousFunctionClassFactory.BuiltInFictitiousFunctionClassFactory : null);
                }
                if (KClassImpl$Data$declaredNonStaticMembers$2() != null) {
                    message.setData(KClassImpl$Data$declaredNonStaticMembers$2(), getAuthRequestContext());
                }
                return message;
            }
        }
    }

    /* loaded from: classes6.dex */
    public static class InboxStyle extends Style {
        private ArrayList<CharSequence> PlaceComponentResult = new ArrayList<>();

        @Override // androidx.core.app.NotificationCompat.Style
        protected String PlaceComponentResult() {
            return "androidx.core.app.NotificationCompat$InboxStyle";
        }

        @Override // androidx.core.app.NotificationCompat.Style
        public void BuiltInFictitiousFunctionClassFactory(NotificationBuilderWithBuilderAccessor notificationBuilderWithBuilderAccessor) {
            if (Build.VERSION.SDK_INT >= 16) {
                Notification.InboxStyle bigContentTitle = new Notification.InboxStyle(notificationBuilderWithBuilderAccessor.KClassImpl$Data$declaredNonStaticMembers$2()).setBigContentTitle(this.MyBillsEntityDataFactory);
                if (this.NetworkUserEntityData$$ExternalSyntheticLambda0) {
                    bigContentTitle.setSummaryText(this.KClassImpl$Data$declaredNonStaticMembers$2);
                }
                Iterator<CharSequence> it = this.PlaceComponentResult.iterator();
                while (it.hasNext()) {
                    bigContentTitle.addLine(it.next());
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public static class DecoratedCustomViewStyle extends Style {
        @Override // androidx.core.app.NotificationCompat.Style
        protected String PlaceComponentResult() {
            return "androidx.core.app.NotificationCompat$DecoratedCustomViewStyle";
        }

        @Override // androidx.core.app.NotificationCompat.Style
        public void BuiltInFictitiousFunctionClassFactory(NotificationBuilderWithBuilderAccessor notificationBuilderWithBuilderAccessor) {
            if (Build.VERSION.SDK_INT >= 24) {
                notificationBuilderWithBuilderAccessor.KClassImpl$Data$declaredNonStaticMembers$2().setStyle(new Notification.DecoratedCustomViewStyle());
            }
        }

        @Override // androidx.core.app.NotificationCompat.Style
        public RemoteViews PlaceComponentResult(NotificationBuilderWithBuilderAccessor notificationBuilderWithBuilderAccessor) {
            if (Build.VERSION.SDK_INT < 24 && this.BuiltInFictitiousFunctionClassFactory.MyBillsEntityDataFactory() != null) {
                return getAuthRequestContext(this.BuiltInFictitiousFunctionClassFactory.MyBillsEntityDataFactory(), false);
            }
            return null;
        }

        @Override // androidx.core.app.NotificationCompat.Style
        public RemoteViews getAuthRequestContext(NotificationBuilderWithBuilderAccessor notificationBuilderWithBuilderAccessor) {
            if (Build.VERSION.SDK_INT >= 24) {
                return null;
            }
            RemoteViews authRequestContext = this.BuiltInFictitiousFunctionClassFactory.getAuthRequestContext();
            if (authRequestContext == null) {
                authRequestContext = this.BuiltInFictitiousFunctionClassFactory.MyBillsEntityDataFactory();
            }
            if (authRequestContext == null) {
                return null;
            }
            return getAuthRequestContext(authRequestContext, true);
        }

        @Override // androidx.core.app.NotificationCompat.Style
        public RemoteViews MyBillsEntityDataFactory(NotificationBuilderWithBuilderAccessor notificationBuilderWithBuilderAccessor) {
            if (Build.VERSION.SDK_INT >= 24) {
                return null;
            }
            RemoteViews NetworkUserEntityData$$ExternalSyntheticLambda0 = this.BuiltInFictitiousFunctionClassFactory.NetworkUserEntityData$$ExternalSyntheticLambda0();
            RemoteViews MyBillsEntityDataFactory = NetworkUserEntityData$$ExternalSyntheticLambda0 != null ? NetworkUserEntityData$$ExternalSyntheticLambda0 : this.BuiltInFictitiousFunctionClassFactory.MyBillsEntityDataFactory();
            if (NetworkUserEntityData$$ExternalSyntheticLambda0 == null) {
                return null;
            }
            return getAuthRequestContext(MyBillsEntityDataFactory, true);
        }

        private RemoteViews getAuthRequestContext(RemoteViews remoteViews, boolean z) {
            int min;
            boolean z2 = true;
            RemoteViews authRequestContext = getAuthRequestContext(true, R.layout.PlaceComponentResult, false);
            authRequestContext.removeAllViews(R.id.getOnBoardingScenario);
            List<Action> MyBillsEntityDataFactory = MyBillsEntityDataFactory(this.BuiltInFictitiousFunctionClassFactory.getAuthRequestContext);
            if (!z || MyBillsEntityDataFactory == null || (min = Math.min(MyBillsEntityDataFactory.size(), 3)) <= 0) {
                z2 = false;
            } else {
                for (int i = 0; i < min; i++) {
                    authRequestContext.addView(R.id.getOnBoardingScenario, KClassImpl$Data$declaredNonStaticMembers$2(MyBillsEntityDataFactory.get(i)));
                }
            }
            int i2 = z2 ? 0 : 8;
            authRequestContext.setViewVisibility(R.id.getOnBoardingScenario, i2);
            authRequestContext.setViewVisibility(R.id.VerifyPinStateManager$executeRiskChallenge$2$1, i2);
            MyBillsEntityDataFactory(authRequestContext, remoteViews);
            return authRequestContext;
        }

        private static List<Action> MyBillsEntityDataFactory(List<Action> list) {
            if (list == null) {
                return null;
            }
            ArrayList arrayList = new ArrayList();
            for (Action action : list) {
                if (!action.NetworkUserEntityData$$ExternalSyntheticLambda2()) {
                    arrayList.add(action);
                }
            }
            return arrayList;
        }

        private RemoteViews KClassImpl$Data$declaredNonStaticMembers$2(Action action) {
            int i;
            boolean z = action.PlaceComponentResult == null;
            String packageName = this.BuiltInFictitiousFunctionClassFactory.newProxyInstance.getPackageName();
            if (z) {
                i = R.layout.MyBillsEntityDataFactory;
            } else {
                i = R.layout.KClassImpl$Data$declaredNonStaticMembers$2;
            }
            RemoteViews remoteViews = new RemoteViews(packageName, i);
            IconCompat NetworkUserEntityData$$ExternalSyntheticLambda0 = action.NetworkUserEntityData$$ExternalSyntheticLambda0();
            if (NetworkUserEntityData$$ExternalSyntheticLambda0 != null) {
                remoteViews.setImageViewBitmap(R.id.getValueOfTouchPositionAbsolute, BuiltInFictitiousFunctionClassFactory(NetworkUserEntityData$$ExternalSyntheticLambda0, this.BuiltInFictitiousFunctionClassFactory.newProxyInstance.getResources().getColor(R.color.BuiltInFictitiousFunctionClassFactory)));
            }
            remoteViews.setTextViewText(R.id.D, action.MyBillsEntityDataFactory);
            if (!z) {
                remoteViews.setOnClickPendingIntent(R.id.A, action.PlaceComponentResult);
            }
            if (Build.VERSION.SDK_INT >= 15) {
                remoteViews.setContentDescription(R.id.A, action.MyBillsEntityDataFactory);
            }
            return remoteViews;
        }
    }

    /* loaded from: classes3.dex */
    public static class Action {
        @Deprecated
        public int BuiltInFictitiousFunctionClassFactory;
        final Bundle KClassImpl$Data$declaredNonStaticMembers$2;
        public CharSequence MyBillsEntityDataFactory;
        private boolean NetworkUserEntityData$$ExternalSyntheticLambda0;
        private final int NetworkUserEntityData$$ExternalSyntheticLambda2;
        public PendingIntent PlaceComponentResult;
        boolean getAuthRequestContext;
        private IconCompat getErrorConfigVersion;
        private final RemoteInput[] initRecordTimeStamp;
        private final RemoteInput[] lookAheadTest;
        private boolean moveToNextValue;
        private final boolean scheduleImpl;

        /* loaded from: classes6.dex */
        public interface Extender {
        }

        @Retention(RetentionPolicy.SOURCE)
        /* loaded from: classes3.dex */
        public @interface SemanticAction {
        }

        public Action(int i, CharSequence charSequence, PendingIntent pendingIntent) {
            this(i != 0 ? IconCompat.PlaceComponentResult(null, "", i) : null, charSequence, pendingIntent);
        }

        public Action(IconCompat iconCompat, CharSequence charSequence, PendingIntent pendingIntent) {
            this(iconCompat, charSequence, pendingIntent, new Bundle(), null, null, true, 0, true, false, false);
        }

        Action(IconCompat iconCompat, CharSequence charSequence, PendingIntent pendingIntent, Bundle bundle, RemoteInput[] remoteInputArr, RemoteInput[] remoteInputArr2, boolean z, int i, boolean z2, boolean z3, boolean z4) {
            this.getAuthRequestContext = true;
            this.getErrorConfigVersion = iconCompat;
            if (iconCompat != null && iconCompat.KClassImpl$Data$declaredNonStaticMembers$2() == 2) {
                this.BuiltInFictitiousFunctionClassFactory = iconCompat.MyBillsEntityDataFactory();
            }
            this.MyBillsEntityDataFactory = Builder.PlaceComponentResult(charSequence);
            this.PlaceComponentResult = pendingIntent;
            this.KClassImpl$Data$declaredNonStaticMembers$2 = bundle == null ? new Bundle() : bundle;
            this.initRecordTimeStamp = remoteInputArr;
            this.lookAheadTest = remoteInputArr2;
            this.moveToNextValue = z;
            this.NetworkUserEntityData$$ExternalSyntheticLambda2 = i;
            this.getAuthRequestContext = z2;
            this.scheduleImpl = z3;
            this.NetworkUserEntityData$$ExternalSyntheticLambda0 = z4;
        }

        @Deprecated
        public int KClassImpl$Data$declaredNonStaticMembers$2() {
            return this.BuiltInFictitiousFunctionClassFactory;
        }

        public IconCompat NetworkUserEntityData$$ExternalSyntheticLambda0() {
            int i;
            if (this.getErrorConfigVersion == null && (i = this.BuiltInFictitiousFunctionClassFactory) != 0) {
                this.getErrorConfigVersion = IconCompat.PlaceComponentResult(null, "", i);
            }
            return this.getErrorConfigVersion;
        }

        public CharSequence scheduleImpl() {
            return this.MyBillsEntityDataFactory;
        }

        public PendingIntent getAuthRequestContext() {
            return this.PlaceComponentResult;
        }

        public Bundle MyBillsEntityDataFactory() {
            return this.KClassImpl$Data$declaredNonStaticMembers$2;
        }

        public boolean PlaceComponentResult() {
            return this.moveToNextValue;
        }

        public boolean DatabaseTableConfigUtil() {
            return this.NetworkUserEntityData$$ExternalSyntheticLambda0;
        }

        public RemoteInput[] getErrorConfigVersion() {
            return this.initRecordTimeStamp;
        }

        public int lookAheadTest() {
            return this.NetworkUserEntityData$$ExternalSyntheticLambda2;
        }

        public boolean NetworkUserEntityData$$ExternalSyntheticLambda2() {
            return this.scheduleImpl;
        }

        public RemoteInput[] BuiltInFictitiousFunctionClassFactory() {
            return this.lookAheadTest;
        }

        public boolean moveToNextValue() {
            return this.getAuthRequestContext;
        }

        /* loaded from: classes6.dex */
        public static final class Builder {
            private final IconCompat BuiltInFictitiousFunctionClassFactory;
            private final Bundle KClassImpl$Data$declaredNonStaticMembers$2;
            private final PendingIntent MyBillsEntityDataFactory;
            private int NetworkUserEntityData$$ExternalSyntheticLambda0;
            private boolean PlaceComponentResult;
            private boolean getAuthRequestContext;
            private final CharSequence getErrorConfigVersion;
            private ArrayList<RemoteInput> lookAheadTest;
            private boolean moveToNextValue;
            private boolean scheduleImpl;

            public Builder(int i, CharSequence charSequence, PendingIntent pendingIntent) {
                this(i != 0 ? IconCompat.PlaceComponentResult(null, "", i) : null, charSequence, pendingIntent, new Bundle(), null, true, 0, true, false, false);
            }

            private Builder(IconCompat iconCompat, CharSequence charSequence, PendingIntent pendingIntent, Bundle bundle, RemoteInput[] remoteInputArr, boolean z, int i, boolean z2, boolean z3, boolean z4) {
                this.PlaceComponentResult = true;
                this.scheduleImpl = true;
                this.BuiltInFictitiousFunctionClassFactory = iconCompat;
                this.getErrorConfigVersion = Builder.PlaceComponentResult(charSequence);
                this.MyBillsEntityDataFactory = pendingIntent;
                this.KClassImpl$Data$declaredNonStaticMembers$2 = bundle;
                this.lookAheadTest = remoteInputArr == null ? null : new ArrayList<>(Arrays.asList(remoteInputArr));
                this.PlaceComponentResult = z;
                this.NetworkUserEntityData$$ExternalSyntheticLambda0 = i;
                this.scheduleImpl = z2;
                this.moveToNextValue = z3;
                this.getAuthRequestContext = z4;
            }

            private void MyBillsEntityDataFactory() {
                if (this.moveToNextValue && this.MyBillsEntityDataFactory == null) {
                    throw new NullPointerException("Contextual Actions must contain a valid PendingIntent");
                }
            }

            public final Action PlaceComponentResult() {
                MyBillsEntityDataFactory();
                ArrayList arrayList = new ArrayList();
                ArrayList arrayList2 = new ArrayList();
                ArrayList<RemoteInput> arrayList3 = this.lookAheadTest;
                if (arrayList3 != null) {
                    Iterator<RemoteInput> it = arrayList3.iterator();
                    while (it.hasNext()) {
                        RemoteInput next = it.next();
                        if (next.BuiltInFictitiousFunctionClassFactory()) {
                            arrayList.add(next);
                        } else {
                            arrayList2.add(next);
                        }
                    }
                }
                RemoteInput[] remoteInputArr = arrayList.isEmpty() ? null : (RemoteInput[]) arrayList.toArray(new RemoteInput[arrayList.size()]);
                return new Action(this.BuiltInFictitiousFunctionClassFactory, this.getErrorConfigVersion, this.MyBillsEntityDataFactory, this.KClassImpl$Data$declaredNonStaticMembers$2, arrayList2.isEmpty() ? null : (RemoteInput[]) arrayList2.toArray(new RemoteInput[arrayList2.size()]), remoteInputArr, this.PlaceComponentResult, this.NetworkUserEntityData$$ExternalSyntheticLambda0, this.scheduleImpl, this.moveToNextValue, this.getAuthRequestContext);
            }
        }

        /* loaded from: classes6.dex */
        public static final class WearableExtender implements Extender {
            private CharSequence BuiltInFictitiousFunctionClassFactory;
            private CharSequence KClassImpl$Data$declaredNonStaticMembers$2;
            private int MyBillsEntityDataFactory = 1;
            private CharSequence PlaceComponentResult;

            /* renamed from: PlaceComponentResult  reason: merged with bridge method [inline-methods] */
            public final WearableExtender clone() {
                WearableExtender wearableExtender = new WearableExtender();
                wearableExtender.MyBillsEntityDataFactory = this.MyBillsEntityDataFactory;
                wearableExtender.PlaceComponentResult = this.PlaceComponentResult;
                wearableExtender.BuiltInFictitiousFunctionClassFactory = this.BuiltInFictitiousFunctionClassFactory;
                wearableExtender.KClassImpl$Data$declaredNonStaticMembers$2 = this.KClassImpl$Data$declaredNonStaticMembers$2;
                return wearableExtender;
            }
        }
    }

    /* loaded from: classes6.dex */
    public static final class WearableExtender implements Extender {
        private int GetContactSyncConfig;
        private int MyBillsEntityDataFactory;
        private int NetworkUserEntityData$$ExternalSyntheticLambda0;
        private String PlaceComponentResult;
        private Bitmap getAuthRequestContext;
        private String getErrorConfigVersion;
        private PendingIntent scheduleImpl;
        private ArrayList<Action> BuiltInFictitiousFunctionClassFactory = new ArrayList<>();
        private int NetworkUserEntityData$$ExternalSyntheticLambda1 = 1;
        private ArrayList<Notification> NetworkUserEntityData$$ExternalSyntheticLambda2 = new ArrayList<>();
        private int lookAheadTest = 8388613;
        private int KClassImpl$Data$declaredNonStaticMembers$2 = -1;
        private int moveToNextValue = 0;
        private int DatabaseTableConfigUtil = 80;

        /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: merged with bridge method [inline-methods] */
        public final WearableExtender clone() {
            WearableExtender wearableExtender = new WearableExtender();
            wearableExtender.BuiltInFictitiousFunctionClassFactory = new ArrayList<>(this.BuiltInFictitiousFunctionClassFactory);
            wearableExtender.NetworkUserEntityData$$ExternalSyntheticLambda1 = this.NetworkUserEntityData$$ExternalSyntheticLambda1;
            wearableExtender.scheduleImpl = this.scheduleImpl;
            wearableExtender.NetworkUserEntityData$$ExternalSyntheticLambda2 = new ArrayList<>(this.NetworkUserEntityData$$ExternalSyntheticLambda2);
            wearableExtender.getAuthRequestContext = this.getAuthRequestContext;
            wearableExtender.MyBillsEntityDataFactory = this.MyBillsEntityDataFactory;
            wearableExtender.lookAheadTest = this.lookAheadTest;
            wearableExtender.KClassImpl$Data$declaredNonStaticMembers$2 = this.KClassImpl$Data$declaredNonStaticMembers$2;
            wearableExtender.moveToNextValue = this.moveToNextValue;
            wearableExtender.NetworkUserEntityData$$ExternalSyntheticLambda0 = this.NetworkUserEntityData$$ExternalSyntheticLambda0;
            wearableExtender.DatabaseTableConfigUtil = this.DatabaseTableConfigUtil;
            wearableExtender.GetContactSyncConfig = this.GetContactSyncConfig;
            wearableExtender.getErrorConfigVersion = this.getErrorConfigVersion;
            wearableExtender.PlaceComponentResult = this.PlaceComponentResult;
            return wearableExtender;
        }
    }

    /* loaded from: classes3.dex */
    public static final class BubbleMetadata {
        private int BuiltInFictitiousFunctionClassFactory;
        private int KClassImpl$Data$declaredNonStaticMembers$2;
        private IconCompat MyBillsEntityDataFactory;
        private int PlaceComponentResult;
        private PendingIntent getAuthRequestContext;
        private PendingIntent lookAheadTest;
        private String moveToNextValue;

        public final PendingIntent getErrorConfigVersion() {
            return this.lookAheadTest;
        }

        public final String scheduleImpl() {
            return this.moveToNextValue;
        }

        public final PendingIntent MyBillsEntityDataFactory() {
            return this.getAuthRequestContext;
        }

        public final IconCompat getAuthRequestContext() {
            return this.MyBillsEntityDataFactory;
        }

        public final int BuiltInFictitiousFunctionClassFactory() {
            return this.PlaceComponentResult;
        }

        public final int KClassImpl$Data$declaredNonStaticMembers$2() {
            return this.BuiltInFictitiousFunctionClassFactory;
        }

        public final boolean PlaceComponentResult() {
            return (this.KClassImpl$Data$declaredNonStaticMembers$2 & 1) != 0;
        }

        public final boolean lookAheadTest() {
            return (this.KClassImpl$Data$declaredNonStaticMembers$2 & 2) != 0;
        }

        public static Notification.BubbleMetadata getAuthRequestContext(BubbleMetadata bubbleMetadata) {
            if (bubbleMetadata == null) {
                return null;
            }
            if (Build.VERSION.SDK_INT >= 30) {
                return Api30Impl.getAuthRequestContext(bubbleMetadata);
            }
            if (Build.VERSION.SDK_INT == 29) {
                return Api29Impl.PlaceComponentResult(bubbleMetadata);
            }
            return null;
        }

        /* loaded from: classes6.dex */
        public static final class Builder {
            @Deprecated
            public Builder() {
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes3.dex */
        public static class Api29Impl {
            private Api29Impl() {
            }

            static Notification.BubbleMetadata PlaceComponentResult(BubbleMetadata bubbleMetadata) {
                if (bubbleMetadata == null || bubbleMetadata.getErrorConfigVersion() == null) {
                    return null;
                }
                Notification.BubbleMetadata.Builder suppressNotification = new Notification.BubbleMetadata.Builder().setIcon(bubbleMetadata.getAuthRequestContext().moveToNextValue()).setIntent(bubbleMetadata.getErrorConfigVersion()).setDeleteIntent(bubbleMetadata.MyBillsEntityDataFactory()).setAutoExpandBubble(bubbleMetadata.PlaceComponentResult()).setSuppressNotification(bubbleMetadata.lookAheadTest());
                if (bubbleMetadata.BuiltInFictitiousFunctionClassFactory() != 0) {
                    suppressNotification.setDesiredHeight(bubbleMetadata.BuiltInFictitiousFunctionClassFactory());
                }
                if (bubbleMetadata.KClassImpl$Data$declaredNonStaticMembers$2() != 0) {
                    suppressNotification.setDesiredHeightResId(bubbleMetadata.KClassImpl$Data$declaredNonStaticMembers$2());
                }
                return suppressNotification.build();
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes3.dex */
        public static class Api30Impl {
            private Api30Impl() {
            }

            static Notification.BubbleMetadata getAuthRequestContext(BubbleMetadata bubbleMetadata) {
                Notification.BubbleMetadata.Builder builder;
                if (bubbleMetadata == null) {
                    return null;
                }
                if (bubbleMetadata.scheduleImpl() != null) {
                    builder = new Notification.BubbleMetadata.Builder(bubbleMetadata.scheduleImpl());
                } else {
                    builder = new Notification.BubbleMetadata.Builder(bubbleMetadata.getErrorConfigVersion(), bubbleMetadata.getAuthRequestContext().moveToNextValue());
                }
                builder.setDeleteIntent(bubbleMetadata.MyBillsEntityDataFactory()).setAutoExpandBubble(bubbleMetadata.PlaceComponentResult()).setSuppressNotification(bubbleMetadata.lookAheadTest());
                if (bubbleMetadata.BuiltInFictitiousFunctionClassFactory() != 0) {
                    builder.setDesiredHeight(bubbleMetadata.BuiltInFictitiousFunctionClassFactory());
                }
                if (bubbleMetadata.KClassImpl$Data$declaredNonStaticMembers$2() != 0) {
                    builder.setDesiredHeightResId(bubbleMetadata.KClassImpl$Data$declaredNonStaticMembers$2());
                }
                return builder.build();
            }
        }
    }

    public static Bundle PlaceComponentResult(Notification notification) {
        if (Build.VERSION.SDK_INT >= 19) {
            return notification.extras;
        }
        if (Build.VERSION.SDK_INT >= 16) {
            return NotificationCompatJellybean.KClassImpl$Data$declaredNonStaticMembers$2(notification);
        }
        return null;
    }

    @Deprecated
    public NotificationCompat() {
    }
}
