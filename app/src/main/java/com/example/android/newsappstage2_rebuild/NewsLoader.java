package com.example.android.newsappstage2_rebuild;

import android.content.AsyncTaskLoader;
import android.content.Context;

import java.util.List;

public class NewsLoader extends AsyncTaskLoader<List<News>> {

    private String mUrl;

    /**
     * New NewsLoader.
     *
     * @param context of the activity
     * @param url     url for
     */
    public NewsLoader(Context context, String url) {
        super(context);
        mUrl = url;
    }

    @Override
    protected void onStartLoading() {
        forceLoad();
    }

    // Background thread.

    @Override
    public List<News> loadInBackground() {
        if (mUrl == null) {
            return null;
        }

        // Make the network request and after extraction of list of news parse the response.
        List<News> News = null;
        try {
            News = NewsUtils.fetchNewsData(mUrl);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return News;
    }
}