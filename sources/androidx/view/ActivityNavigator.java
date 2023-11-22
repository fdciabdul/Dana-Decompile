package androidx.view;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.Intent;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.net.Uri;
import android.os.Bundle;
import android.util.AttributeSet;
import androidx.core.app.ActivityCompat;
import androidx.core.app.ActivityOptionsCompat;
import androidx.view.Navigator;
import com.fullstory.instrumentation.InstrumentInjector;
import id.dana.danah5.akulaku.AkuEventParamsKey;
import java.util.Iterator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.sequences.SequencesKt;
import kotlin.text.StringsKt;
import net.sqlcipher.database.SQLiteDatabase;

@Navigator.Name(AkuEventParamsKey.KEY_ACTIVITY)
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\b\u0017\u0018\u0000 \u00102\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0003\u0010\u0011\u0012B\u000f\u0012\u0006\u0010\r\u001a\u00020\u0006¢\u0006\u0004\b\u000e\u0010\u000fJ\u000f\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\t\u001a\u00020\u0006X\u0006¢\u0006\u0006\n\u0004\b\u0007\u0010\bR\u0016\u0010\f\u001a\u0004\u0018\u00010\n8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010\u000b"}, d2 = {"Landroidx/navigation/ActivityNavigator;", "Landroidx/navigation/Navigator;", "Landroidx/navigation/ActivityNavigator$Destination;", "", "MyBillsEntityDataFactory", "()Z", "Landroid/content/Context;", "BuiltInFictitiousFunctionClassFactory", "Landroid/content/Context;", "PlaceComponentResult", "Landroid/app/Activity;", "Landroid/app/Activity;", "KClassImpl$Data$declaredNonStaticMembers$2", "p0", "<init>", "(Landroid/content/Context;)V", "Companion", "Destination", "Extras"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes3.dex */
public class ActivityNavigator extends Navigator<Destination> {

    /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
    public final Context PlaceComponentResult;

    /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
    private final Activity KClassImpl$Data$declaredNonStaticMembers$2;

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\u00020\u0001:\u0001\tR\u0013\u0010\u0003\u001a\u0004\u0018\u00010\u0002X\u0006¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0011\u0010\b\u001a\u00020\u0005X\u0006¢\u0006\u0006\n\u0004\b\u0006\u0010\u0007"}, d2 = {"Landroidx/navigation/ActivityNavigator$Extras;", "Landroidx/navigation/Navigator$Extras;", "Landroidx/core/app/ActivityOptionsCompat;", "KClassImpl$Data$declaredNonStaticMembers$2", "Landroidx/core/app/ActivityOptionsCompat;", "", "MyBillsEntityDataFactory", "I", "getAuthRequestContext", "Builder"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes3.dex */
    public static final class Extras implements Navigator.Extras {
        final ActivityOptionsCompat KClassImpl$Data$declaredNonStaticMembers$2;

        /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
        final int getAuthRequestContext;

        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Landroidx/navigation/ActivityNavigator$Extras$Builder;", "", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
        /* loaded from: classes6.dex */
        public static final class Builder {
        }
    }

    @Override // androidx.view.Navigator
    public final /* synthetic */ NavDestination MyBillsEntityDataFactory(Destination destination, Bundle bundle, NavOptions navOptions, Navigator.Extras extras) {
        Intent intent;
        int intExtra;
        Destination destination2 = destination;
        Intrinsics.checkNotNullParameter(destination2, "");
        if (destination2.BuiltInFictitiousFunctionClassFactory == null) {
            StringBuilder sb = new StringBuilder();
            sb.append("Destination ");
            sb.append(destination2.getErrorConfigVersion);
            sb.append(" does not have an Intent set.");
            throw new IllegalStateException(sb.toString().toString());
        }
        Intent intent2 = new Intent(destination2.BuiltInFictitiousFunctionClassFactory);
        if (bundle != null) {
            intent2.putExtras(bundle);
            String str = destination2.PlaceComponentResult;
            String str2 = str;
            if (!(str2 == null || str2.length() == 0)) {
                StringBuffer stringBuffer = new StringBuffer();
                Matcher matcher = Pattern.compile("\\{(.+?)\\}").matcher(str2);
                while (matcher.find()) {
                    String group = matcher.group(1);
                    if (bundle.containsKey(group)) {
                        matcher.appendReplacement(stringBuffer, "");
                        stringBuffer.append(Uri.encode(String.valueOf(bundle.get(group))));
                    } else {
                        StringBuilder sb2 = new StringBuilder();
                        sb2.append("Could not find ");
                        sb2.append(group);
                        sb2.append(" in ");
                        sb2.append(bundle);
                        sb2.append(" to fill data pattern ");
                        sb2.append(str);
                        throw new IllegalArgumentException(sb2.toString());
                    }
                }
                matcher.appendTail(stringBuffer);
                intent2.setData(Uri.parse(stringBuffer.toString()));
            }
        }
        boolean z = extras instanceof Extras;
        if (z) {
            intent2.addFlags(((Extras) extras).getAuthRequestContext);
        }
        if (this.KClassImpl$Data$declaredNonStaticMembers$2 == null) {
            intent2.addFlags(SQLiteDatabase.CREATE_IF_NECESSARY);
        }
        if (navOptions != null && navOptions.getScheduleImpl()) {
            intent2.addFlags(536870912);
        }
        Activity activity = this.KClassImpl$Data$declaredNonStaticMembers$2;
        if (activity != null && (intent = activity.getIntent()) != null && (intExtra = intent.getIntExtra("android-support-navigation:ActivityNavigator:current", 0)) != 0) {
            intent2.putExtra("android-support-navigation:ActivityNavigator:source", intExtra);
        }
        intent2.putExtra("android-support-navigation:ActivityNavigator:current", destination2.getErrorConfigVersion);
        Resources resources = this.PlaceComponentResult.getResources();
        if (navOptions != null) {
            int i = navOptions.MyBillsEntityDataFactory;
            int i2 = navOptions.PlaceComponentResult;
            if ((i > 0 && Intrinsics.areEqual(resources.getResourceTypeName(i), "animator")) || (i2 > 0 && Intrinsics.areEqual(resources.getResourceTypeName(i2), "animator"))) {
                StringBuilder sb3 = new StringBuilder();
                sb3.append("Activity destinations do not support Animator resource. Ignoring popEnter resource ");
                sb3.append(resources.getResourceName(i));
                sb3.append(" and popExit resource ");
                sb3.append(resources.getResourceName(i2));
                sb3.append(" when launching ");
                sb3.append(destination2);
                InstrumentInjector.log_w("ActivityNavigator", sb3.toString());
            } else {
                intent2.putExtra("android-support-navigation:ActivityNavigator:popEnterAnim", i);
                intent2.putExtra("android-support-navigation:ActivityNavigator:popExitAnim", i2);
            }
        }
        if (!z) {
            this.PlaceComponentResult.startActivity(intent2);
        } else {
            ActivityOptionsCompat activityOptionsCompat = ((Extras) extras).KClassImpl$Data$declaredNonStaticMembers$2;
            if (activityOptionsCompat != null) {
                ActivityCompat.MyBillsEntityDataFactory(this.PlaceComponentResult, intent2, activityOptionsCompat.MyBillsEntityDataFactory());
            } else {
                this.PlaceComponentResult.startActivity(intent2);
            }
        }
        if (navOptions == null || this.KClassImpl$Data$declaredNonStaticMembers$2 == null) {
            return null;
        }
        int i3 = navOptions.KClassImpl$Data$declaredNonStaticMembers$2;
        int i4 = navOptions.getAuthRequestContext;
        if ((i3 <= 0 || !Intrinsics.areEqual(resources.getResourceTypeName(i3), "animator")) && (i4 <= 0 || !Intrinsics.areEqual(resources.getResourceTypeName(i4), "animator"))) {
            if (i3 >= 0 || i4 >= 0) {
                this.KClassImpl$Data$declaredNonStaticMembers$2.overridePendingTransition(RangesKt.coerceAtLeast(i3, 0), RangesKt.coerceAtLeast(i4, 0));
                return null;
            }
            return null;
        }
        StringBuilder sb4 = new StringBuilder();
        sb4.append("Activity destinations do not support Animator resource. Ignoring enter resource ");
        sb4.append(resources.getResourceName(i3));
        sb4.append(" and exit resource ");
        sb4.append(resources.getResourceName(i4));
        sb4.append("when launching ");
        sb4.append(destination2);
        InstrumentInjector.log_w("ActivityNavigator", sb4.toString());
        return null;
    }

    public ActivityNavigator(Context context) {
        Object obj;
        Intrinsics.checkNotNullParameter(context, "");
        this.PlaceComponentResult = context;
        Iterator it = SequencesKt.generateSequence(context, new Function1<Context, Context>() { // from class: androidx.navigation.ActivityNavigator$hostActivity$1
            @Override // kotlin.jvm.functions.Function1
            public final android.content.Context invoke(android.content.Context context2) {
                Intrinsics.checkNotNullParameter(context2, "");
                if (context2 instanceof ContextWrapper) {
                    return ((ContextWrapper) context2).getBaseContext();
                }
                return null;
            }
        }).iterator();
        while (true) {
            if (!it.hasNext()) {
                obj = null;
                break;
            }
            obj = it.next();
            if (obj instanceof Activity) {
                break;
            }
        }
        this.KClassImpl$Data$declaredNonStaticMembers$2 = (Activity) obj;
    }

    @Override // androidx.view.Navigator
    public final boolean MyBillsEntityDataFactory() {
        Activity activity = this.KClassImpl$Data$declaredNonStaticMembers$2;
        if (activity != null) {
            activity.finish();
            return true;
        }
        return false;
    }

    @Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0016\u0018\u00002\u00020\u0001B\u0017\u0012\u000e\u0010\u0003\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00000\u001a¢\u0006\u0004\b\u001b\u0010\u001cJ\u001a\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0096\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\b\u0010\tJ\u001f\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0003\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ\u000f\u0010\u0010\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0010\u0010\u0011J\u000f\u0010\u0013\u001a\u00020\u0012H\u0016¢\u0006\u0004\b\u0013\u0010\u0014R \u0010\u0017\u001a\u0004\u0018\u00010\u00122\b\u0010\u0003\u001a\u0004\u0018\u00010\u0012@BX\u0086\n¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016R \u0010\u000e\u001a\u0004\u0018\u00010\u00182\b\u0010\u0003\u001a\u0004\u0018\u00010\u0018@BX\u0086\n¢\u0006\u0006\n\u0004\b\u000e\u0010\u0019"}, d2 = {"Landroidx/navigation/ActivityNavigator$Destination;", "Landroidx/navigation/NavDestination;", "", "p0", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "Landroid/content/Context;", "Landroid/util/AttributeSet;", "p1", "", "BuiltInFictitiousFunctionClassFactory", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "MyBillsEntityDataFactory", "()Z", "", "toString", "()Ljava/lang/String;", "KClassImpl$Data$declaredNonStaticMembers$2", "Ljava/lang/String;", "PlaceComponentResult", "Landroid/content/Intent;", "Landroid/content/Intent;", "Landroidx/navigation/Navigator;", "<init>", "(Landroidx/navigation/Navigator;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes3.dex */
    public static class Destination extends NavDestination {
        Intent BuiltInFictitiousFunctionClassFactory;

        /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
        String PlaceComponentResult;

        @Override // androidx.view.NavDestination
        public final boolean MyBillsEntityDataFactory() {
            return false;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Destination(Navigator<? extends Destination> navigator) {
            super(navigator);
            Intrinsics.checkNotNullParameter(navigator, "");
        }

        @Override // androidx.view.NavDestination
        public final void BuiltInFictitiousFunctionClassFactory(Context p0, AttributeSet p1) {
            Intrinsics.checkNotNullParameter(p0, "");
            Intrinsics.checkNotNullParameter(p1, "");
            super.BuiltInFictitiousFunctionClassFactory(p0, p1);
            TypedArray obtainAttributes = p0.getResources().obtainAttributes(p1, C0212R.styleable.MyBillsEntityDataFactory);
            Intrinsics.checkNotNullExpressionValue(obtainAttributes, "");
            String string = obtainAttributes.getString(C0212R.styleable.NetworkUserEntityData$$ExternalSyntheticLambda0);
            if (string != null) {
                String packageName = p0.getPackageName();
                Intrinsics.checkNotNullExpressionValue(packageName, "");
                string = StringsKt.replace$default(string, "${applicationId}", packageName, false, 4, (Object) null);
            }
            if (this.BuiltInFictitiousFunctionClassFactory == null) {
                this.BuiltInFictitiousFunctionClassFactory = new Intent();
            }
            Intent intent = this.BuiltInFictitiousFunctionClassFactory;
            Intrinsics.checkNotNull(intent);
            intent.setPackage(string);
            String string2 = obtainAttributes.getString(C0212R.styleable.PlaceComponentResult);
            if (string2 != null) {
                if (string2.charAt(0) == '.') {
                    StringBuilder sb = new StringBuilder();
                    sb.append(p0.getPackageName());
                    sb.append(string2);
                    string2 = sb.toString();
                }
                ComponentName componentName = new ComponentName(p0, string2);
                if (this.BuiltInFictitiousFunctionClassFactory == null) {
                    this.BuiltInFictitiousFunctionClassFactory = new Intent();
                }
                Intent intent2 = this.BuiltInFictitiousFunctionClassFactory;
                Intrinsics.checkNotNull(intent2);
                intent2.setComponent(componentName);
            }
            String string3 = obtainAttributes.getString(C0212R.styleable.KClassImpl$Data$declaredNonStaticMembers$2);
            if (this.BuiltInFictitiousFunctionClassFactory == null) {
                this.BuiltInFictitiousFunctionClassFactory = new Intent();
            }
            Intent intent3 = this.BuiltInFictitiousFunctionClassFactory;
            Intrinsics.checkNotNull(intent3);
            intent3.setAction(string3);
            String string4 = obtainAttributes.getString(C0212R.styleable.getAuthRequestContext);
            if (string4 != null) {
                Uri parse = Uri.parse(string4);
                if (this.BuiltInFictitiousFunctionClassFactory == null) {
                    this.BuiltInFictitiousFunctionClassFactory = new Intent();
                }
                Intent intent4 = this.BuiltInFictitiousFunctionClassFactory;
                Intrinsics.checkNotNull(intent4);
                intent4.setData(parse);
            }
            this.PlaceComponentResult = obtainAttributes.getString(C0212R.styleable.BuiltInFictitiousFunctionClassFactory);
            obtainAttributes.recycle();
        }

        @Override // androidx.view.NavDestination
        public boolean equals(Object p0) {
            if (p0 != null && (p0 instanceof Destination) && super.equals(p0)) {
                Intent intent = this.BuiltInFictitiousFunctionClassFactory;
                if ((intent != null ? intent.filterEquals(((Destination) p0).BuiltInFictitiousFunctionClassFactory) : ((Destination) p0).BuiltInFictitiousFunctionClassFactory == null) && Intrinsics.areEqual(this.PlaceComponentResult, ((Destination) p0).PlaceComponentResult)) {
                    return true;
                }
            }
            return false;
        }

        @Override // androidx.view.NavDestination
        public int hashCode() {
            int hashCode = super.hashCode();
            Intent intent = this.BuiltInFictitiousFunctionClassFactory;
            int filterHashCode = intent != null ? intent.filterHashCode() : 0;
            String str = this.PlaceComponentResult;
            return (((hashCode * 31) + filterHashCode) * 31) + (str != null ? str.hashCode() : 0);
        }

        @Override // androidx.view.NavDestination
        public String toString() {
            Intent intent = this.BuiltInFictitiousFunctionClassFactory;
            ComponentName component = intent != null ? intent.getComponent() : null;
            StringBuilder sb = new StringBuilder();
            sb.append(super.toString());
            if (component != null) {
                sb.append(" class=");
                sb.append(component.getClassName());
            } else {
                Intent intent2 = this.BuiltInFictitiousFunctionClassFactory;
                String action = intent2 != null ? intent2.getAction() : null;
                if (action != null) {
                    sb.append(" action=");
                    sb.append(action);
                }
            }
            String obj = sb.toString();
            Intrinsics.checkNotNullExpressionValue(obj, "");
            return obj;
        }
    }

    @Override // androidx.view.Navigator
    public final /* synthetic */ Destination KClassImpl$Data$declaredNonStaticMembers$2() {
        return new Destination(this);
    }
}
