package com.kaytat.simpleprotocolplayer;

import android.content.Intent;
import android.net.Uri;
import androidx.annotation.Nullable;
import androidx.annotation.OptIn;
import androidx.media3.common.MediaItem;
import androidx.media3.common.MediaMetadata;
import androidx.media3.common.SimpleBasePlayer;
import androidx.media3.common.util.UnstableApi;
import androidx.media3.session.MediaSession;
import androidx.media3.session.MediaSessionService;
import com.google.common.collect.ImmutableList;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.List;


public class BackgroundMusicService extends MediaSessionService {
  private MediaSession mediaSession = null;

  @OptIn(markerClass = UnstableApi.class)
  @Override
  public void onCreate() {
    super.onCreate();
    mediaSession =
        new MediaSession.Builder(this, new SppPlayer(getMainLooper())).build();
  }

  @Nullable
  public MediaSession onGetSession(MediaSession.ControllerInfo controllerInfo) {
    return mediaSession;
  }

  @Override
  public void onTaskRemoved(@Nullable Intent rootIntent) {}

  @Override
  public void onDestroy() {
    mediaSession.getPlayer().release();
    mediaSession.release();
    mediaSession = null;
    super.onDestroy();
    super.onDestroy();
  }
}
