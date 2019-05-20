package id.codepanda.instagramclone.util

import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.media.RingtoneManager
import android.net.Uri
import android.os.Build
import android.support.v4.app.NotificationCompat
import android.support.v4.content.ContextCompat
import id.codepanda.instagramclone.R
import org.jetbrains.anko.notificationManager

fun showNotif(context: Context?, title: String, message: String, target: Class<*>) {
    val channelID = "id.codepanda.instagramclone"
    val pendingIntent: PendingIntent = PendingIntent.getActivity(context, 0, Intent(context, target), 0)
    val uriTone: Uri = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION)
    val builder = NotificationCompat.Builder(context!!, channelID)
        .setSmallIcon(R.drawable.ic_instagram_clone_logo)
        .setContentTitle(title)
        .setContentText(message)
        .setStyle(
            NotificationCompat.BigTextStyle()
                .bigText(message))
        .setContentIntent(pendingIntent)
        .setPriority(NotificationCompat.PRIORITY_DEFAULT)
        .setSound(uriTone)
        .setAutoCancel(true)
        .setVibrate(longArrayOf(1000, 1000, 1000, 1000, 1000))
        .setColor(ContextCompat.getColor(context, android.R.color.transparent))


    // Create the NotificationChannel, but only on API 26+ because
    // the NotificationChannel class is new and not in the support library
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
        val name = "Instagram Clone"
        val descriptionText = "instagram clone notifiation channel"
        val importance = NotificationManager.IMPORTANCE_DEFAULT
        val channel = NotificationChannel(channelID, name, importance).apply {
            description = descriptionText
        }
        channel.enableLights(true)
        channel.lightColor = Color.BLUE
        channel.enableVibration(true)
        channel.vibrationPattern = longArrayOf(1000, 1000, 1000, 1000, 1000)
        channel.setShowBadge(true)

        // Register the channel with the system
        val notificationManager: NotificationManager =
            context.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager

        notificationManager.createNotificationChannel(channel)
    }

    if (target.name == "certain activity that require same notif id") context.notificationManager.notify(3001, builder.build())
    else context.notificationManager.notify((3002 until 4000).random(), builder.build())

}
