package com.amazon.ata.music.playlist.service.converters;

import com.amazon.ata.music.playlist.service.dynamodb.models.AlbumTrack;
import com.amazon.ata.music.playlist.service.models.PlaylistModel;
import com.amazon.ata.music.playlist.service.dynamodb.models.Playlist;
import com.amazon.ata.music.playlist.service.models.SongModel;

import java.util.ArrayList;
import java.util.List;

public class ModelConverter {
    /**
     * Converts a provided {@link Playlist} into a {@link PlaylistModel} representation..
     * @param playlist the playlist to convert
     * @return the converted playlist
     */
    public PlaylistModel toPlaylistModel(Playlist playlist) {
        List<String> tags = null;

        if(playlist.getTags() != null){
            tags = new ArrayList<>(playlist.getTags());
        }

        return PlaylistModel.builder()
            .withId(playlist.getId())
            .withName(playlist.getName())
            .withCustomerId(playlist.getCustomerId())
            .withSongCount(playlist.getSongCount())
            .withTags(tags)
            .build();
    }

    public SongModel toSongModel(AlbumTrack albumTrack){
        return SongModel.builder()
                .withTitle(albumTrack.getSongTitle())
                .withAsin(albumTrack.getAsin())
                .withTrackNumber(albumTrack.getTrackNumber())
                .withAlbum(albumTrack.getAlbumName())
                .build();
    }

    public List<SongModel> toSongModelList(List<AlbumTrack> albumTracks) {
        List<SongModel> list = new ArrayList<>();

        for(AlbumTrack albumTrack : albumTracks){
                SongModel model = SongModel.builder()
                        .withAlbum(albumTrack.getAlbumName())
                        .withAsin(albumTrack.getAsin())
                        .withTitle(albumTrack.getSongTitle())
                        .withTrackNumber(albumTrack.getTrackNumber())
                        .build();
                list.add(model);
        }
        return list;
    }
}
