package com.alibaba.griver.ui.refresh;

import android.content.Context;
import android.view.View;
import android.widget.RelativeLayout;
import com.alibaba.griver.ui.refresh.GriverSwipeRefreshLayout;
import id.dana.nearbyme.NearbyMeActivity;

/* loaded from: classes6.dex */
public abstract class RefreshHeader extends RelativeLayout {
    protected GriverSwipeRefreshLayout.OnPullRefreshListener mPullRefreshListener;
    protected RefreshState mState;

    /* loaded from: classes6.dex */
    public enum RefreshHeaderStyle {
        NORMAL,
        DARK
    }

    public abstract void changeToState(RefreshState refreshState);

    public abstract View getRefreshView();

    public abstract View getSecondFloorView();

    public abstract void setProgress(float f);

    public abstract void setRefreshAnimation(String[] strArr, String str);

    public abstract void setRefreshTipColor(int i);

    public abstract void setRefreshTips(String[] strArr);

    public abstract void setSecondFloorView(View view);

    public void switchStyle(RefreshHeaderStyle refreshHeaderStyle) {
    }

    public RefreshHeader(Context context) {
        super(context);
        this.mState = RefreshState.NONE;
    }

    public RefreshState getCurrentState() {
        return this.mState;
    }

    public void setPullRefreshListener(GriverSwipeRefreshLayout.OnPullRefreshListener onPullRefreshListener) {
        this.mPullRefreshListener = onPullRefreshListener;
    }

    /* renamed from: com.alibaba.griver.ui.refresh.RefreshHeader$1  reason: invalid class name */
    /* loaded from: classes6.dex */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$alibaba$griver$ui$refresh$RefreshHeader$RefreshState;

        static {
            int[] iArr = new int[RefreshState.values().length];
            $SwitchMap$com$alibaba$griver$ui$refresh$RefreshHeader$RefreshState = iArr;
            try {
                iArr[RefreshState.NONE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$alibaba$griver$ui$refresh$RefreshHeader$RefreshState[RefreshState.PULL_TO_REFRESH.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$alibaba$griver$ui$refresh$RefreshHeader$RefreshState[RefreshState.RELEASE_TO_REFRESH.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$alibaba$griver$ui$refresh$RefreshHeader$RefreshState[RefreshState.REFRESHING.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$com$alibaba$griver$ui$refresh$RefreshHeader$RefreshState[RefreshState.PREPARE_TO_SECOND_FLOOR.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$com$alibaba$griver$ui$refresh$RefreshHeader$RefreshState[RefreshState.SECOND_FLOOR_START.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                $SwitchMap$com$alibaba$griver$ui$refresh$RefreshHeader$RefreshState[RefreshState.SECOND_FLOOR_END.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
        }
    }

    /* loaded from: classes6.dex */
    public enum RefreshState {
        NONE,
        PULL_TO_REFRESH,
        RELEASE_TO_REFRESH,
        REFRESHING,
        PREPARE_TO_SECOND_FLOOR,
        SECOND_FLOOR_START,
        SECOND_FLOOR_END;

        @Override // java.lang.Enum
        public final String toString() {
            switch (AnonymousClass1.$SwitchMap$com$alibaba$griver$ui$refresh$RefreshHeader$RefreshState[ordinal()]) {
                case 1:
                    return "NONE";
                case 2:
                    return "PULL_TO_REFRESH";
                case 3:
                    return "RELEASE_TO_REFRESH";
                case 4:
                    return NearbyMeActivity.RefreshCondition.REFRESHING;
                case 5:
                    return "PREPARE_TO_SECOND_FLOOR";
                case 6:
                    return "SECOND_FLOOR_START";
                case 7:
                    return "SECOND_FLOOR_END";
                default:
                    return "";
            }
        }
    }
}
