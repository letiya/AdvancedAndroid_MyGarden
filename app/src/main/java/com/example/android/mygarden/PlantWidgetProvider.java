package com.example.android.mygarden;

import android.app.PendingIntent;
import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProvider;
import android.content.Context;
import android.content.Intent;
import android.widget.RemoteViews;

import com.example.android.mygarden.ui.MainActivity;

public class PlantWidgetProvider extends AppWidgetProvider {

    static void updateAppWidget(Context context, AppWidgetManager appWidgetManager, int appWidgetId) {
        // Create an Intent to launch MainActivity when clicked
        Intent intent = new Intent(context, MainActivity.class);
        PendingIntent pendingIntent = PendingIntent.getActivity(context, 0, intent, 0);
        // Construct the RemoteViews object
        RemoteViews remoteViews = new RemoteViews(context.getPackageName(), R.layout.plant_widget);
        // Widgets allow click handlers to only launch pending intents
        remoteViews.setOnClickPendingIntent(R.id.widget_plant_image, pendingIntent);
        // Instruct the widget manager to update the widget
        appWidgetManager.updateAppWidget(appWidgetId, remoteViews);
    }

    @Override
    public void onUpdate(Context context, AppWidgetManager appWidgetManager, int[] appWidgetIds) {
        // There may be multiple widgets active, so update all of them
        for (int appWidgetId : appWidgetIds) {
            updateAppWidget(context, appWidgetManager, appWidgetId);
        }
    }

    @Override
    public void onDeleted(Context context, int[] appWidgetIds) {

    }

    @Override
    public void onEnabled(Context context) {

    }

    @Override
    public void onDisabled(Context context) {
        
    }
}
