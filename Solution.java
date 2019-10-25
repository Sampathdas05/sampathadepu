package AmazonOnline;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.regex.Pattern;

/**
 * Created by E Ananthaneshan on 12/9/18. temp
 */
public class Solution {


    public static void main(String[] args) throws ParseException {

        String photoRecordsInput = "photo.jpg, Warsaw, 2013-09-05 14:08:15\n" +
                "john.png, London, 2015-06-20 15:13:22\n" +
                "my Friends.png, Warsaw, 2013-09-05 14:07:13\n" +
                "Eiffel.jpg, Paris, 2015-07-23 08:03:02\n" +
                "pisatower.jpg, Paris, 2015-07-22 23:59:59\n" +
                "BOB.jpg, London, 2015-08-05 00:02:03\n" +
                "notredame.png, Paris, 2015-09-01 12:00:00\n" +
                "me.jpg, Warsaw, 2013-09-06 15:40:22\n" +
                "a.png, Warsaw, 2016-02-13 13:33:50\n" +
                "b.jpg, Warsaw, 2016-01-02 15:12:22\n" +
                "c.jpg, Warsaw, 2016-01-02 14:34:30\n" +
                "d.jpg, Warsaw, 2016-01-02 15:15:01\n" +
                "e.png, Warsaw, 2016-01-02 09:49:09\n" +
                "f.png, Warsaw, 2016-01-02 10:55:32\n" +
                "g.jpg, Warsaw, 2016-02-29 22:13:11\n" +
                "g.jpg, Warsaw, 2016-02-29 22:13:11\n" +
                "g.jpg, Warsaw, 2016-02-29 22:13:11\n"+
                "g.jpg, Warsaw, 2016-02-29 22:13:11\n"+"g.jpg, Warsaw, 2016-02-29 22:13:11";

        System.out.println(photoRecordsInput);
        System.out.println("------- Answer Below --------");
        System.out.println(new Solution().solution(photoRecordsInput));
    }

    private String solution(String photoRecords) throws ParseException {
        Album myAlbum = new Album(photoRecords);
        return myAlbum.convertFileNamesToString();

    }

}

class Album {
    private static final String REGEX_CONSTANT_LINE_BREAK = "\n";
    private List<Photo> photos = new ArrayList<>();
    private Set<String> cities = new HashSet<>();

    Album(String photoRecords) throws ParseException {

        String[] photoRecord = photoRecords.split(Pattern.quote(REGEX_CONSTANT_LINE_BREAK));

        for (int i = 0; i < photoRecord.length; i++) {
            Photo photo = new Photo(photoRecord[i]);
            photos.add(i, photo);
            cities.add(photo.city);

        }

        updateOrder();
    }

    private void updateOrder() {

        for (String next : cities) {
            Set<Photo> byLocation = getByLocation(next);
            updateOrderProperty(byLocation.toArray(new Photo[0]));

        }
    }

    private Set<Photo> getByLocation(String location) {
        Set<Photo> photosByLocation = new TreeSet<>(new SortByDate());

        for (Photo photo : photos) {
            if (photo.city.equals(location)) photosByLocation.add(photo);
        }

        return photosByLocation;
    }

    private void updateOrderProperty(Photo[] bucket) {
        int length = ("" + bucket.length).length();

        for (int i = 0; i < bucket.length; i++) {
            Photo photo = bucket[i];
            photo.order = String.format("%0" + length + "d", i + 1);

        }
    }

    String convertFileNamesToString() {
        StringBuilder builder = new StringBuilder();

        for (Photo photo : photos) {
            builder.append(photo.toString()).append("\n");
        }

        return builder.toString();
    }

    private class SortByDate implements Comparator<Photo> {

        public int compare(Photo a, Photo b) {
            return a.date.compareTo(b.date);
        }

    }

    class Photo {
        static final String YYYY_MM_DD_HH_MM_SS = "yyyy-MM-dd HH:mm:ss";
        static final String REGEX_CONSTANT_COMMA = ",";
        static final String REGEX_CONSTANT_FULL_STOP = ".";
        private String city;
        private Date date;
        private String order;
        private String fileType;

        private Photo(String photoRecord) throws ParseException {
            String[] partsOfRecord = photoRecord.split(REGEX_CONSTANT_COMMA);
            this.date = new SimpleDateFormat(YYYY_MM_DD_HH_MM_SS).parse(partsOfRecord[2]);
            this.city = partsOfRecord[1];
            this.fileType = getTypeFromFileName(partsOfRecord[0]);

        }

        private String getTypeFromFileName(String fileName) {
            return fileName.split(Pattern.quote(REGEX_CONSTANT_FULL_STOP))[1];
        }

        @Override
        public String toString() {
            return String.format("%s%s.%s", city, order, fileType);
        }
    }

}