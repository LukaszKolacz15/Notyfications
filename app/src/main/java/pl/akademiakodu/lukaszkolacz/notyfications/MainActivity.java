package pl.akademiakodu.lukaszkolacz.notyfications;

import android.app.Activity;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v4.app.NotificationCompat;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



//      ------------------------------------------ 3 -----------------------------------------------
        Intent intent = new Intent(this, MainActivity.class);
        PendingIntent pendingIntent = PendingIntent.getActivity(this,0, intent, 0);

//      ------------------------------------------ 4 -----------------------------------------------

        Intent intentTest = new Intent(this, MainActivity.class);
        PendingIntent pendingIntentTest = PendingIntent.getActivity(this,0, intent, 0);

//      ------------------------------------------ 2 -----------------------------------------------

        NotificationCompat.InboxStyle inboxStyle = new NotificationCompat.InboxStyle();
        inboxStyle.addLine("Jestem wiadomością pierwszą");
        inboxStyle.addLine("Jestem wiadomością drugą");
        inboxStyle.addLine("Jestem wiadomością trzecią");
        inboxStyle.addLine("Jestem wiadomością czwartą");
        inboxStyle.setBigContentTitle("Wiadomość email");


//      ------------------------------------------ 1 -----------------------------------------------
        NotificationCompat.Builder builder = new NotificationCompat.Builder(this)
                .setContentTitle("Witaj świecie!")
                .setContentText("Pochodzę z kursu, jest mi tu dobrze!")
                .setAutoCancel(false)
                .setStyle(inboxStyle) // linijka dodana aby wyświetdlać naszą inboxStyle notyfikację (2)
                .setContentIntent(pendingIntent) // Do otwierania "apki" (3)
                .addAction(R.mipmap.ic_launcher, "Otwórz apkę", pendingIntentTest) // dodanie guziora w notyfikacji (3)
                .addAction(R.mipmap.ic_launcher, "TEST", pendingIntentTest) // dodanie guziora w notyfikacji (4)
                .setTicker("Krótkie powiadomienie")
                .setLargeIcon(BitmapFactory.decodeResource(getResources(), R.mipmap.ic_launcher))
                .setSmallIcon(R.mipmap.ic_launcher);

        NotificationManager manager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        manager.notify(1, builder.build());
    }
}
