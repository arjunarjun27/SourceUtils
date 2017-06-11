package customview;

import android.content.Context;

import Interface.IReportBack;

/**
 * Created by arjun27 on 6/11/2017.
 */

public class BaseTester {
    protected IReportBack mReportTo;
    protected Context mContext;
    public BaseTester(Context ctx, IReportBack target)
    {
        mReportTo = target;
        mContext = ctx;
    }

}
