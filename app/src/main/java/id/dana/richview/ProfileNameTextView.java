package id.dana.richview;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import androidx.appcompat.widget.AppCompatTextView;
import id.dana.R;

/* loaded from: classes5.dex */
public class ProfileNameTextView extends AppCompatTextView {
    private Level MyBillsEntityDataFactory;

    public ProfileNameTextView(Context context) {
        super(context);
        this.MyBillsEntityDataFactory = Level.Normal;
        BuiltInFictitiousFunctionClassFactory(null);
    }

    public ProfileNameTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.MyBillsEntityDataFactory = Level.Normal;
        BuiltInFictitiousFunctionClassFactory(attributeSet);
    }

    public ProfileNameTextView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.MyBillsEntityDataFactory = Level.Normal;
        BuiltInFictitiousFunctionClassFactory(attributeSet);
    }

    private void BuiltInFictitiousFunctionClassFactory(AttributeSet attributeSet) {
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R.styleable.SplitReferralConfigEntityData_Factory);
            try {
                this.MyBillsEntityDataFactory = Level.getByValue(obtainStyledAttributes.getInt(0, 0));
            } finally {
                obtainStyledAttributes.recycle();
            }
        }
        setLevel(this.MyBillsEntityDataFactory);
    }

    /* renamed from: id.dana.richview.ProfileNameTextView$1  reason: invalid class name */
    /* loaded from: classes5.dex */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] getAuthRequestContext;

        static {
            int[] iArr = new int[Level.values().length];
            getAuthRequestContext = iArr;
            try {
                iArr[Level.Normal.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                getAuthRequestContext[Level.ManualReview.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                getAuthRequestContext[Level.InProgress.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                getAuthRequestContext[Level.Failed.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                getAuthRequestContext[Level.Success.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                getAuthRequestContext[Level.Verified.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                getAuthRequestContext[Level.Premium.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
        }
    }

    public void setLevel(Level level) {
        this.MyBillsEntityDataFactory = level;
    }

    /* loaded from: classes9.dex */
    public enum Level {
        Normal(0),
        ManualReview(1),
        InProgress(2),
        Failed(3),
        Success(4),
        Verified(5),
        Premium(6);

        private int value;

        Level(int i) {
            this.value = i;
        }

        public static Level getByValue(int i) {
            for (Level level : values()) {
                if (level.getValue() == i) {
                    return level;
                }
            }
            return null;
        }

        public final int getValue() {
            return this.value;
        }
    }
}
