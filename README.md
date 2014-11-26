activity-navigation
===================

# Android Test preserving activity navigation on Notifications #

### References ###
[1](http://developer.android.com/guide/topics/ui/notifiers/notifications.html#NotificationResponse)
[2](http://developer.android.com/training/implementing-navigation/temporal.html#SynthesizeBackStack)

### Problem ###
Activity A starts Activity B waiting for result. But Activity B can be started from Notification.
Want to keep navigation when starting B from Notification

### Solution ###
While starting B from notification the Activity A starts from onCreate method. The onActivityResult method is not called so I added the result into a shared preference and check that value while starting A
