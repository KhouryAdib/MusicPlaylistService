package com.amazon.ata.music.playlist.service.dynamodb.models;

import com.amazon.ata.music.playlist.service.models.SongModel;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBRangeKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable;

import java.util.Objects;

/**
 * Represents a record in the album_tracks table.
 */
@DynamoDBTable(tableName = "album_tracks")
public class AlbumTrack {
    private String asin;// partition key, string
    private Integer track_number; // sort key, number
    private String album_name; // string
    private String song_title; // string

    public AlbumTrack(Builder builder) {
        this.asin = builder.asin;
        this.track_number = builder.track_number;
        this.album_name = builder.album;
        this.song_title = builder.title;
    }

    public AlbumTrack() {

    }


    @DynamoDBHashKey(attributeName = "asin")
    public String getAsin() {
        return asin;
    }

    public void setAsin(String asin) {
        this.asin = asin;
    }

    @DynamoDBRangeKey(attributeName = "track_number")
    public int getTrackNumber() {
        return track_number;
    }

    public void setTrackNumber(int track_number) {
        this.track_number = track_number;
    }

    @DynamoDBAttribute(attributeName = "album_name")
    public String getAlbumName() {
        return album_name;
    }

    public void setAlbumName(String album_name) {
        this.album_name = album_name;
    }

    @DynamoDBAttribute(attributeName = "song_title")
    public String getSongTitle() {
        return song_title;
    }

    public void setSongTitle(String song_title) {
        this.song_title = song_title;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AlbumTrack albumTrack = (AlbumTrack) o;
        return track_number == albumTrack.track_number &&
                Objects.equals(asin, albumTrack.asin) &&
                Objects.equals(album_name, albumTrack.album_name) &&
                Objects.equals(song_title, albumTrack.song_title);
    }

    @Override
    public int hashCode() {
        return Objects.hash(asin, album_name, track_number, song_title);
    }

    @Override
    public String toString() {
        return "SongModel{" +
                "asin='" + asin + '\'' +
                ", album='" + album_name + '\'' +
                ", track_number=" + track_number +
                ", title='" + song_title + '\'' +
                '}';
    }

    public static SongModel.Builder builder() {
        return new SongModel.Builder();
    }

    public static final class Builder {
        private String asin;
        private String album;
        private int track_number;
        private String title;

        public AlbumTrack.Builder withAsin(String asinToUse) {
            this.asin = asinToUse;
            return this;
        }

        public AlbumTrack.Builder withAlbum(String albumToUse) {
            this.album = albumToUse;
            return this;
        }

        public AlbumTrack.Builder withTrackNumber(int track_numberToUse) {
            this.track_number = track_numberToUse;
            return this;
        }

        public AlbumTrack.Builder withTitle(String titleToUse) {
            this.title = titleToUse;
            return this;
        }

        public AlbumTrack build() {
            return new AlbumTrack(this);
        }

    }
}
