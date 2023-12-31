package com.kaytat.simpleprotocolplayer;

import android.net.Uri;
import android.os.Looper;
import androidx.media3.common.MediaItem;
import androidx.media3.common.MediaMetadata;
import androidx.media3.common.SimpleBasePlayer;
import androidx.media3.common.util.UnstableApi;
import com.google.common.collect.ImmutableList;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.List;

@UnstableApi public class SppPlayer extends SimpleBasePlayer {
  protected SppPlayer(Looper applicationLooper) {
    super(applicationLooper);
  }

  final MediaItem mediaItem =
      new MediaItem.Builder()
          .setMediaId("media-1")
          .setUri("https://storage.googleapis.com/exoplayer-test-media-1/gen-3/screens/dash-vod-single-segment/video-avc-baseline-480.mp4")
          .setMediaMetadata(
              new MediaMetadata.Builder()
                  .setArtist("David Bowie")
                  .setTitle("Heroes")
                  .setArtworkUri(Uri.parse(
                      "https://cdn.pixabay.com/photo/2014/10/09/13/14/video-481821_960_720.png"))
                  .build())
          .build();

  State state =
      new State.Builder()
          .setAvailableCommands(
              new Commands.Builder()
                  .add(COMMAND_PLAY_PAUSE)
                  .add(COMMAND_STOP)
                  .add(COMMAND_PREPARE)
                  .add(COMMAND_GET_TIMELINE)
                  .add(COMMAND_GET_CURRENT_MEDIA_ITEM)
                  .add(COMMAND_GET_CURRENT_MEDIA_ITEM)
                  .add(COMMAND_GET_METADATA)
                  .add(COMMAND_SET_MEDIA_ITEM)
                  .build())
          .setPlaybackState(STATE_READY)
          .setPlaylist(
              ImmutableList.of(
                  new MediaItemData.Builder("string UID")
                      .setMediaItem(mediaItem)
                      .build()))
          .setPlaylistMetadata(
              new MediaMetadata.Builder()
                  .setMediaType(MediaMetadata.MEDIA_TYPE_PLAYLIST)
                  .setTitle("TTS test")
                  .build())
          .setCurrentMediaItemIndex(0)
          .build();

  // final State playingState = new State.Builder().setAvailableCommands(new
  // Commands.Builder().add(COMMAND_STOP).build()).setPlaybackState(STATE_READY).build();

  @Override
  protected State getState() {
    return state;
  }

  protected ListenableFuture<?> handleSetMediaItems(
      List<MediaItem> mediaItems, int startIndex, long startPositionMs) {
    return Futures.immediateVoidFuture();
  }

  protected ListenableFuture<?> handlePrepare() {
    return Futures.immediateVoidFuture();
  }

  protected ListenableFuture<?> handleSetPlayWhenReady(boolean playWhenReady) {
    return Futures.immediateVoidFuture();
  }
    /*

  @Override
  protected ListenableFuture<?> handleSetPlayWhenReady(boolean playWhenReady) {
    state =
        new State.Builder()
            .setAvailableCommands(new Commands.Builder().add(COMMAND_STOP).build())
            .setPlaybackState(STATE_READY)
            .setPlaylist(
                ImmutableList.of(
                    new MediaItemData.Builder("string UID")
                        .setMediaItem(mediaItem)
                        .build()))
            .setPlaylistMetadata(
                new MediaMetadata.Builder()
                    .setMediaType(MediaMetadata.MEDIA_TYPE_PLAYLIST)
                    .setTitle("TTS test")
                    .build())
            .setCurrentMediaItemIndex(0)
            .build();
    return Futures.immediateVoidFuture();
  }
  */
}
