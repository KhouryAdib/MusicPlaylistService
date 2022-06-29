package com.amazon.ata.music.playlist.service.dependency;

import com.amazon.ata.music.playlist.service.activity.*;
import com.amazon.ata.music.playlist.service.dynamodb.PlaylistDao;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import dagger.Component;
import javax.inject.Singleton;

@Singleton
@Component(modules = {DaoModule.class})
public interface  ServiceComponent {

    DynamoDBMapper provideDynamoDBMapper();

    CreatePlaylistActivity provideCreatePlaylistActivity();

    GetPlaylistActivity provideGetPlaylistActivity();

   AddSongToPlaylistActivity provideAddSongToPlaylistActivity();

    PlaylistDao providePlaylistDao();

    GetPlaylistSongsActivity provideGetPlaylistSongsActivity();

    UpdatePlaylistActivity provideUpdatePlaylistActivity();

}
